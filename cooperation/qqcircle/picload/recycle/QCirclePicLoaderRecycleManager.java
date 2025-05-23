package cooperation.qqcircle.picload.recycle;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.libra.IPicLoader;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.util.WeakReference;
import uq3.c;

/* loaded from: classes28.dex */
public class QCirclePicLoaderRecycleManager extends QCircleBasePicLoaderRecycler<Option> {
    private static final int DEV_OPTION_REQ = -1;
    private static final String TAG = "[PMC][PicRecycler]-LibraPicLoader";
    private WeakReference<IPicLoader> mPicLoaderWeak;
    private final CopyOnWriteArrayList<Integer> mRestoreReqList = new CopyOnWriteArrayList<>();
    private final CopyOnWriteArrayList<Integer> mGCReqList = new CopyOnWriteArrayList<>();
    private boolean isEnabledForceClearNotAttachBitmapResult = c.L5();

    public QCirclePicLoaderRecycleManager(IPicLoader iPicLoader) {
        this.mPicLoaderWeak = new WeakReference<>(iPicLoader);
    }

    private String getTag() {
        return "[PMC][PicRecycler]-LibraPicLoader_" + hashCode();
    }

    private boolean isNeedRecycler(Option option) {
        boolean z16;
        int hashCode;
        if (option == null) {
            return false;
        }
        boolean isSupportRecycler = option.isSupportRecycler();
        ImageView targetView = getTargetView(option);
        if (targetView != null && targetView.isAttachedToWindow()) {
            z16 = true;
        } else {
            z16 = false;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[isNeedRecycler] isSupportRecycler: ");
        sb5.append(isSupportRecycler);
        sb5.append(" | isAttachedToWindow: ");
        sb5.append(z16);
        sb5.append(" | targetView: ");
        if (targetView == null) {
            hashCode = -1;
        } else {
            hashCode = targetView.hashCode();
        }
        sb5.append(hashCode);
        QLog.d(TAG, 4, sb5.toString());
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_clear_bitmap_detach_to_window", true)) {
            return isSupportRecycler;
        }
        if (!isSupportRecycler || !z16) {
            return false;
        }
        return true;
    }

    private void notifyClearCache(Option option) {
        IPicLoader iPicLoader;
        WeakReference<IPicLoader> weakReference = this.mPicLoaderWeak;
        if (weakReference == null) {
            iPicLoader = null;
        } else {
            iPicLoader = weakReference.get();
        }
        if (iPicLoader == null) {
            return;
        }
        iPicLoader.removeCache(option);
    }

    private void notifyRestoreCache(Option option) {
        IPicLoader iPicLoader;
        WeakReference<IPicLoader> weakReference = this.mPicLoaderWeak;
        if (weakReference == null) {
            iPicLoader = null;
        } else {
            iPicLoader = weakReference.get();
        }
        if (iPicLoader == null) {
            return;
        }
        iPicLoader.loadImage(option, null);
    }

    @Override // cooperation.qqcircle.picload.recycle.QCircleBasePicLoaderRecycler
    protected void onClearFinish() {
        Iterator<Integer> it = this.mGCReqList.iterator();
        String str = "";
        while (it.hasNext()) {
            str = str + it.next() + " ";
        }
        int size = this.mGCReqList.size();
        if (QLog.isColorLevel()) {
            QLog.d(getTag(), 2, "[onClearFinish] seq list = [" + str + "] size:" + size + " free gc bitmap option.");
        }
    }

    @Override // cooperation.qqcircle.picload.recycle.QCircleBasePicLoaderRecycler, cooperation.qqcircle.picload.recycle.IQCircleRecycleInterface
    public void onHandlerMemoryClear() {
        super.onHandlerMemoryClear();
        this.mGCReqList.clear();
    }

    @Override // cooperation.qqcircle.picload.recycle.QCircleBasePicLoaderRecycler, cooperation.qqcircle.picload.recycle.IQCircleRecycleInterface
    public void onHandlerMemoryRestore() {
        super.onHandlerMemoryRestore();
        this.mRestoreReqList.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cooperation.qqcircle.picload.recycle.QCircleBasePicLoaderRecycler
    public void onRegisterFinish(Integer num, Option option) {
    }

    @Override // cooperation.qqcircle.picload.recycle.QCircleBasePicLoaderRecycler
    protected void onRestoreFinish() {
        Iterator<Integer> it = this.mRestoreReqList.iterator();
        String str = "";
        while (it.hasNext()) {
            str = str + it.next() + " ";
        }
        int size = this.mRestoreReqList.size();
        if (QLog.isColorLevel()) {
            QLog.d(getTag(), 2, "[onRestoreFinish] seq list = [" + str + "] size:" + size + " reload bitmap source.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cooperation.qqcircle.picload.recycle.QCircleBasePicLoaderRecycler
    public void freeGcBitmapOption(Option option) {
        if (option != null && isNeedRecycler(option)) {
            ImageView targetView = getTargetView(option);
            if (targetView != null) {
                targetView.setImageBitmap(null);
                targetView.setImageDrawable(null);
            }
            option.releaseResource();
            notifyClearCache(option);
            int seq = option.getSeq();
            if (-1 != seq) {
                this.mGCReqList.add(Integer.valueOf(seq));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cooperation.qqcircle.picload.recycle.QCircleBasePicLoaderRecycler
    public Bitmap getBitmapView(Option option) {
        if (option == null) {
            return null;
        }
        return option.getResultBitMap();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cooperation.qqcircle.picload.recycle.QCircleBasePicLoaderRecycler
    public ImageView getTargetView(Option option) {
        if (option == null) {
            return null;
        }
        return option.getTargetView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cooperation.qqcircle.picload.recycle.QCircleBasePicLoaderRecycler
    public boolean isSupportRecycler(Option option) {
        return option != null && option.isSupportRecycler();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cooperation.qqcircle.picload.recycle.QCircleBasePicLoaderRecycler
    public void onUnregisterFinish(Integer num, Option option, boolean z16) {
        if (this.isEnabledForceClearNotAttachBitmapResult && option != null) {
            option.setResultBitMap(null);
            this.mOptionArrayMap.remove(num);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cooperation.qqcircle.picload.recycle.QCircleBasePicLoaderRecycler
    public void restoreOptionToBitmap(Option option) {
        if (option != null && isNeedRecycler(option)) {
            int seq = option.getSeq();
            if (-1 != seq) {
                this.mRestoreReqList.add(Integer.valueOf(seq));
            }
            notifyRestoreCache(option);
        }
    }
}

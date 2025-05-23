package cooperation.qqcircle.picload.recycle;

import android.graphics.Bitmap;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

/* loaded from: classes28.dex */
public abstract class QCircleBasePicLoaderRecycler<T> implements IQCircleRecycleInterface {
    private static final long CHECK_NONE_TARGET_TIME = 60000;
    private static final int DEF_ILLEGAL_KEY_VAL = -1;
    private static final String TAG = "[PMC][BaseRecycler]-LibraPicLoader";
    private long mPreCheckNoneTargetTime = 0;
    protected final ConcurrentHashMap<Integer, WeakReference<T>> mOptionArrayMap = new ConcurrentHashMap<>();

    private void checkNoneTargetOption() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mPreCheckNoneTargetTime < 60000) {
            return;
        }
        this.mPreCheckNoneTargetTime = currentTimeMillis;
        clearNoneTargetOption();
    }

    private void clearNoneTargetOption() {
        Set<Integer> keySet = this.mOptionArrayMap.keySet();
        if (keySet.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(1);
        for (Integer num : keySet) {
            T option = getOption(num);
            View targetView = getTargetView(option);
            Bitmap bitmapView = getBitmapView(option);
            if (option == null) {
                arrayList.add(num);
            } else if (targetView == null && bitmapView != null) {
                arrayList.add(num);
            }
        }
        int size = arrayList.size();
        QLog.d(getTag(), 1, "[checkNoneTargetOption] handle none target option check, exec clear flow. this: " + hashCode() + " | size: " + size);
        clearTargetNoneKeys(arrayList);
    }

    private void clearTargetNoneKeys(List<Integer> list) {
        if (list != null && !list.isEmpty()) {
            QLog.d(getTag(), 1, "[clearTargetNoneKeys] none target options size: " + list.size());
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                unregisterOption(it.next(), false);
            }
        }
    }

    @Nullable
    private T getOption(Integer num) {
        WeakReference<T> weakReference = this.mOptionArrayMap.get(num);
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    private int getRecycleKeyVal(T t16) {
        View targetView = getTargetView(t16);
        if (targetView == null) {
            return -1;
        }
        return targetView.hashCode();
    }

    private String getTag() {
        return "[PMC][BaseRecycler]-LibraPicLoader_" + hashCode();
    }

    private void unregisterOption(Integer num, boolean z16) {
        if (num.intValue() == -1) {
            return;
        }
        onUnregisterFinish(num, getOption(num), z16);
    }

    protected Bitmap getBitmapView(T t16) {
        return null;
    }

    protected View getTargetView(T t16) {
        return null;
    }

    protected boolean isSupportRecycler(T t16) {
        return false;
    }

    @Override // cooperation.qqcircle.picload.recycle.IQCircleRecycleInterface
    public void onHandlerMemoryClear() {
        Set<Integer> keySet = this.mOptionArrayMap.keySet();
        if (keySet.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (QLog.isColorLevel()) {
            int size = keySet.size();
            QLog.d(getTag(), 2, "[onHandlerMemoryClear] restoreSize: " + size);
        }
        for (Integer num : keySet) {
            T option = getOption(num);
            View targetView = getTargetView(option);
            if (option != null && targetView != null) {
                freeGcBitmapOption(option);
            } else {
                arrayList.add(num);
            }
        }
        clearTargetNoneKeys(arrayList);
        onClearFinish();
    }

    @Override // cooperation.qqcircle.picload.recycle.IQCircleRecycleInterface
    public void onHandlerMemoryRestore() {
        Set<Integer> keySet = this.mOptionArrayMap.keySet();
        if (keySet.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (QLog.isColorLevel()) {
            int size = keySet.size();
            QLog.d(getTag(), 2, "[onHandlerMemoryRestore] restoreSize: " + size);
        }
        for (Integer num : keySet) {
            T option = getOption(num);
            View targetView = getTargetView(option);
            if (option != null && targetView != null) {
                restoreOptionToBitmap(option);
            } else {
                arrayList.add(num);
            }
        }
        clearTargetNoneKeys(arrayList);
        onRestoreFinish();
    }

    public void registerOption(T t16) {
        if (!isSupportRecycler(t16)) {
            return;
        }
        if (getTargetView(t16) == null) {
            QLog.d(getTag(), 2, "[registerOption] current target view should not be null.");
            return;
        }
        int recycleKeyVal = getRecycleKeyVal(t16);
        if (recycleKeyVal == -1) {
            QLog.d(getTag(), 2, "[registerOption] current key is illegal, no next step.");
            return;
        }
        if (this.mOptionArrayMap.containsKey(Integer.valueOf(recycleKeyVal))) {
            unregisterOption(Integer.valueOf(recycleKeyVal), true);
        }
        checkNoneTargetOption();
        this.mOptionArrayMap.put(Integer.valueOf(recycleKeyVal), new WeakReference<>(t16));
        onRegisterFinish(Integer.valueOf(recycleKeyVal), t16);
    }

    public void release() {
        this.mOptionArrayMap.clear();
    }

    public void removeCache(T t16) {
        int recycleKeyVal = getRecycleKeyVal(t16);
        if (recycleKeyVal == -1) {
            QLog.d(getTag(), 2, "[removeCache] current key is illegal, no next step.");
        } else {
            this.mOptionArrayMap.remove(Integer.valueOf(recycleKeyVal));
        }
    }

    protected void onClearFinish() {
    }

    protected void onRestoreFinish() {
    }

    protected void freeGcBitmapOption(T t16) {
    }

    protected void restoreOptionToBitmap(T t16) {
    }

    protected void onRegisterFinish(Integer num, T t16) {
    }

    protected void onUnregisterFinish(Integer num, T t16, boolean z16) {
    }
}

package com.tencent.aelight.camera.ae.play;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.camera.ui.AECaptureController;
import com.tencent.aelight.camera.ae.data.AEMaterialManager;
import com.tencent.aelight.camera.ae.mode.c;
import com.tencent.aelight.camera.ae.n;
import com.tencent.aelight.camera.ae.play.AEPlayShowGridViewHolder;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.ae.util.e;
import com.tencent.aelight.camera.aioeditor.shortvideo.QIMPtvTemplateManager;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes32.dex */
public class AEPlayShowGridAdapter extends RecyclerView.Adapter<AEPlayShowGridViewHolder> implements AEPlayShowGridViewHolder.ItemClickCallback {
    private static final String TAG = "AEPlayShowGridAdapter";
    public static AEMaterialMetaData selectedMaterial;
    public static AEMaterialMetaData selectedMidMaterial;
    private String curTabId = "";
    private AECaptureController mAECaptureController;
    private Map<String, AEPlayShowGridViewHolder> mCachedViewHolder;
    private c mCaptureModeViewModel;
    private Context mContext;
    private int mLayoutType;
    private List<AEMaterialMetaData> mMaterialList;
    private AEMaterialManager mMidMaterialManager;
    private com.tencent.aelight.camera.ae.part.c mPartManager;
    private SizeInfo mSizeInfo;
    private AEPituCameraUnit mUnit;

    /* loaded from: classes32.dex */
    public static class SizeInfo {
        public int itemHeight;
        public int itemHorizontalPadding;
        public int itemVerticalPadding;
        public int itemWidth;

        public SizeInfo() {
        }

        public SizeInfo(SizeInfo sizeInfo) {
            this.itemWidth = sizeInfo.itemWidth;
            this.itemHeight = sizeInfo.itemHeight;
            this.itemHorizontalPadding = sizeInfo.itemHorizontalPadding;
            this.itemVerticalPadding = sizeInfo.itemVerticalPadding;
        }
    }

    public AEPlayShowGridAdapter(Context context, com.tencent.aelight.camera.ae.part.c cVar, SizeInfo sizeInfo, int i3) {
        this.mContext = context;
        this.mPartManager = cVar;
        AEPituCameraUnit aEPituCameraUnit = (AEPituCameraUnit) cVar.b(65537, new Object[0]);
        this.mUnit = aEPituCameraUnit;
        this.mAECaptureController = aEPituCameraUnit.I1();
        this.mSizeInfo = sizeInfo;
        this.mLayoutType = i3;
        this.mMidMaterialManager = (AEMaterialManager) com.tencent.aelight.camera.ae.control.a.c().d(1);
        this.mCaptureModeViewModel = (c) n.a(this.mUnit).get(c.class);
        this.mCachedViewHolder = new HashMap();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0029, code lost:
    
        com.tencent.aelight.camera.ae.play.PlayDownloadManagerWrap.getInstance().addProgressObserver(r3, r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized void addProgressObserver(String str, IProgressObserver iProgressObserver) {
        Iterator<Map.Entry<String, com.tencent.aelight.camera.download.a>> it = PlayDownloadManagerWrap.getInstance().getDownloadingMap().entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, com.tencent.aelight.camera.download.a> next = it.next();
            if (str != null && str.equals(next.getKey())) {
                break;
            }
        }
    }

    private void applyTemplate(AEMaterialMetaData aEMaterialMetaData) {
        int i3 = aEMaterialMetaData.playShowType;
        if (i3 == 0) {
            selectedMidMaterial = aEMaterialMetaData;
            Long l3 = QIMPtvTemplateManager.J;
            this.mAECaptureController.v(aEMaterialMetaData);
            this.mPartManager.q(393218, aEMaterialMetaData);
            return;
        }
        if (i3 == 4 || i3 == 5 || i3 == 6 || i3 == 7) {
            selectedMidMaterial = null;
            this.mPartManager.q(655361, aEMaterialMetaData);
        }
    }

    private void downloadTemplate(AEMaterialMetaData aEMaterialMetaData) {
        if (aEMaterialMetaData.downloading || TextUtils.isEmpty(aEMaterialMetaData.f69050id)) {
            return;
        }
        downloadTemplateDirectly(aEMaterialMetaData);
    }

    private void downloadTemplateDirectly(AEMaterialMetaData aEMaterialMetaData) {
        AEPlayShowGridViewHolder aEPlayShowGridViewHolder = this.mCachedViewHolder.get(aEMaterialMetaData.f69050id);
        if (aEPlayShowGridViewHolder != null) {
            aEPlayShowGridViewHolder.onDownloadStart();
        }
        ms.a.f(TAG, "\u3010Play Item\u3011onDownloadStart :" + aEMaterialMetaData.f69050id);
        PlayDownloadManagerWrap.getInstance().addProgressObserver(aEMaterialMetaData.f69050id, aEPlayShowGridViewHolder);
        PlayDownloadManagerWrap.getInstance().startDownload(this.mPartManager, this.mMidMaterialManager, aEMaterialMetaData);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0029, code lost:
    
        com.tencent.aelight.camera.ae.play.PlayDownloadManagerWrap.getInstance().removeProgressObserver(r3, r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized void removeProgressObserver(String str, AEPlayShowGridViewHolder aEPlayShowGridViewHolder) {
        Iterator<Map.Entry<String, com.tencent.aelight.camera.download.a>> it = PlayDownloadManagerWrap.getInstance().getDownloadingMap().entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<String, com.tencent.aelight.camera.download.a> next = it.next();
            if (str != null && str.equals(next.getKey())) {
                break;
            }
        }
    }

    private void scanExistHolderToObserve(String str) {
        AEPlayShowGridViewHolder aEPlayShowGridViewHolder;
        AEMaterialMetaData aEMaterialMetaData;
        Map<String, AEPlayShowGridViewHolder> map = this.mCachedViewHolder;
        if (map == null || map.get(str) == null || (aEPlayShowGridViewHolder = this.mCachedViewHolder.get(str)) == null || (aEMaterialMetaData = aEPlayShowGridViewHolder.mPlayMaterial) == null || !aEMaterialMetaData.downloading) {
            return;
        }
        addProgressObserver(aEMaterialMetaData.f69050id, aEPlayShowGridViewHolder);
    }

    public static boolean selectedMidMaterialNotConsumed() {
        return selectedMidMaterial != null;
    }

    private void toMiniApp(AEMaterialMetaData aEMaterialMetaData) {
        this.mPartManager.q(655363, aEMaterialMetaData);
    }

    private void toWebView(AEMaterialMetaData aEMaterialMetaData) {
        this.mPartManager.q(655362, aEMaterialMetaData);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mMaterialList.size();
    }

    public void initObservers() {
        String key;
        Map<String, AEPlayShowGridViewHolder> map = this.mCachedViewHolder;
        if (map == null || map.size() < 1) {
            return;
        }
        for (Map.Entry<String, AEPlayShowGridViewHolder> entry : this.mCachedViewHolder.entrySet()) {
            if (entry != null && (key = entry.getKey()) != null) {
                scanExistHolderToObserve(key);
            }
        }
    }

    public void onDestroy() {
        for (Map.Entry<String, AEPlayShowGridViewHolder> entry : this.mCachedViewHolder.entrySet()) {
            PlayDownloadManagerWrap.getInstance().removeProgressObserver(entry.getKey(), entry.getValue());
        }
    }

    @Override // com.tencent.aelight.camera.ae.play.AEPlayShowGridViewHolder.ItemClickCallback
    public void onItemClicked(View view, AEMaterialMetaData aEMaterialMetaData, int i3) {
        if (e.a(view)) {
            return;
        }
        if (i3 >= 0) {
            i3++;
        }
        Integer.toString(i3);
        AEBaseReportParam.U().R0(i3);
        AEBaseReportParam.U().Q0("3");
        AEBaseReportParam.U().T0(aEMaterialMetaData.playShowType);
        selectedMaterial = aEMaterialMetaData;
        ms.a.f(TAG, "\u3010Play Material OnClick\u3011playShowType:" + aEMaterialMetaData.playShowType);
        ms.a.f(TAG, "\u3010Play Material OnClick\u3011id:" + aEMaterialMetaData.f69050id);
        if (AEMaterialMetaData.isRealMaterial(aEMaterialMetaData)) {
            if (aEMaterialMetaData.usable) {
                applyTemplate(aEMaterialMetaData);
            } else if (!NetworkUtil.isNetworkAvailable()) {
                selectedMaterial = null;
                selectedMidMaterial = null;
                Context context = this.mContext;
                QQToast.makeText(context, context.getString(R.string.f173056gt1), 0).show();
            } else {
                downloadTemplate(aEMaterialMetaData);
            }
            com.tencent.aelight.camera.ae.report.b.b().L0(aEMaterialMetaData.f69050id);
            return;
        }
        int i16 = aEMaterialMetaData.playShowType;
        if (i16 == 2) {
            toWebView(aEMaterialMetaData);
            com.tencent.aelight.camera.ae.report.b.b().L0(aEMaterialMetaData.f69050id);
        } else if (i16 == 3) {
            toMiniApp(aEMaterialMetaData);
            com.tencent.aelight.camera.ae.report.b.b().L0(aEMaterialMetaData.f69050id);
        }
    }

    public void putData(List<AEMaterialMetaData> list) {
        this.mMaterialList = list;
        if (list.size() == 0) {
            this.mCachedViewHolder.clear();
        }
        notifyDataSetChanged();
    }

    public void setCurTabId(String str) {
        this.curTabId = str;
    }

    public static void onSelectedMidMaterialConsumed() {
        selectedMidMaterial = null;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(AEPlayShowGridViewHolder aEPlayShowGridViewHolder, int i3) {
        AEMaterialMetaData aEMaterialMetaData = this.mMaterialList.get(i3);
        aEPlayShowGridViewHolder.bind(aEMaterialMetaData, i3);
        String str = this.curTabId;
        if (str == null || !str.equals(aEMaterialMetaData.tabId)) {
            return;
        }
        AEBaseReportParam.U().T0(aEPlayShowGridViewHolder.mPlayMaterial.playShowType);
        AEBaseReportParam.U().R0(i3 + 1);
        com.tencent.aelight.camera.ae.report.b.b().q1(aEPlayShowGridViewHolder.mPlayMaterial.f69050id);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public AEPlayShowGridViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        View inflate;
        if (this.mLayoutType == 1) {
            inflate = LayoutInflater.from(this.mContext).inflate(R.layout.dmi, viewGroup, false);
        } else {
            inflate = LayoutInflater.from(this.mContext).inflate(R.layout.dmj, viewGroup, false);
        }
        return new AEPlayShowGridViewHolder(inflate, this.mSizeInfo, this, this.mLayoutType);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(AEPlayShowGridViewHolder aEPlayShowGridViewHolder) {
        super.onViewAttachedToWindow((AEPlayShowGridAdapter) aEPlayShowGridViewHolder);
        AEMaterialMetaData aEMaterialMetaData = aEPlayShowGridViewHolder.mPlayMaterial;
        if (aEMaterialMetaData == null || TextUtils.isEmpty(aEMaterialMetaData.f69050id) || !AEMaterialMetaData.isRealMaterial(aEPlayShowGridViewHolder.mPlayMaterial)) {
            return;
        }
        this.mCachedViewHolder.put(aEPlayShowGridViewHolder.mPlayMaterial.f69050id, aEPlayShowGridViewHolder);
        aEPlayShowGridViewHolder.resetProgress();
        addProgressObserver(aEPlayShowGridViewHolder.mPlayMaterial.f69050id, aEPlayShowGridViewHolder);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(AEPlayShowGridViewHolder aEPlayShowGridViewHolder) {
        super.onViewDetachedFromWindow((AEPlayShowGridAdapter) aEPlayShowGridViewHolder);
        AEMaterialMetaData aEMaterialMetaData = aEPlayShowGridViewHolder.mPlayMaterial;
        if (aEMaterialMetaData == null || TextUtils.isEmpty(aEMaterialMetaData.f69050id) || !AEMaterialMetaData.isRealMaterial(aEPlayShowGridViewHolder.mPlayMaterial)) {
            return;
        }
        this.mCachedViewHolder.remove(aEPlayShowGridViewHolder.mPlayMaterial.f69050id);
        aEPlayShowGridViewHolder.resetProgress();
        removeProgressObserver(aEPlayShowGridViewHolder.mPlayMaterial.f69050id, aEPlayShowGridViewHolder);
        scanExistHolderToObserve(aEPlayShowGridViewHolder.mPlayMaterial.f69050id);
    }
}

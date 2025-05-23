package com.qzone.reborn.albumx.common.layer.part;

import android.text.TextUtils;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.viewmodel.RFWLayerViewModel;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b&\u0018\u0000 \u000f*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H&J\u001c\u0010\f\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/qzone/reborn/albumx/common/layer/part/f;", "T", "Lcom/qzone/reborn/albumx/common/layer/part/i;", "", "layerState", "", "G9", "", "F9", "", "action", "args", "handleBroadcastMessage", "<init>", "()V", tl.h.F, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class f<T> extends i<T> {
    private final void G9(final Object layerState) {
        if (F9() && (layerState instanceof RFWLayerState)) {
            final List<RFWLayerItemMediaInfo> richMediaDataList = ((RFWLayerState) layerState).getRichMediaDataList();
            List<RFWLayerItemMediaInfo> list = richMediaDataList;
            if (list == null || list.isEmpty()) {
                return;
            }
            QLog.i("CommonLayerIOPart", 1, "handleAssembleOriginPicInfo");
            RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.qzone.reborn.albumx.common.layer.part.d
                @Override // java.lang.Runnable
                public final void run() {
                    f.H9(f.this, richMediaDataList, layerState);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(f this$0, List list, final Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final RFWLayerViewModel mLayerViewModel = this$0.getMLayerViewModel();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo = (RFWLayerItemMediaInfo) it.next();
            RFWLayerPicInfo layerPicInfo = rFWLayerItemMediaInfo.getLayerPicInfo();
            if ((layerPicInfo != null ? layerPicInfo.getOriginPicInfo() : null) != null) {
                RFWLayerPicInfo layerPicInfo2 = rFWLayerItemMediaInfo.getLayerPicInfo();
                Intrinsics.checkNotNull(layerPicInfo2);
                RFWLayerPicInfo.RFWPicInfo originPicInfo = layerPicInfo2.getOriginPicInfo();
                Intrinsics.checkNotNull(originPicInfo);
                if (RFWFileUtils.fileExists(originPicInfo.getLocalPath())) {
                    RFWLayerPicInfo layerPicInfo3 = rFWLayerItemMediaInfo.getLayerPicInfo();
                    Intrinsics.checkNotNull(layerPicInfo3);
                    RFWLayerPicInfo layerPicInfo4 = rFWLayerItemMediaInfo.getLayerPicInfo();
                    Intrinsics.checkNotNull(layerPicInfo4);
                    RFWLayerPicInfo.RFWPicInfo originPicInfo2 = layerPicInfo4.getOriginPicInfo();
                    Intrinsics.checkNotNull(originPicInfo2);
                    layerPicInfo3.setCurrentPicInfo(originPicInfo2);
                }
            }
        }
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.qzone.reborn.albumx.common.layer.part.e
            @Override // java.lang.Runnable
            public final void run() {
                f.I9(RFWLayerViewModel.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(RFWLayerViewModel this_with, Object obj) {
        Intrinsics.checkNotNullParameter(this_with, "$this_with");
        this_with.mRichMediaInfo.setValue(UIStateData.obtainSuccess(false).setDataList(obj));
    }

    public abstract boolean F9();

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String action, Object args) {
        super.handleBroadcastMessage(action, args);
        if (TextUtils.equals(action, "LAYER_ASSEMBLE_ORIGIN_PIC_INFO")) {
            G9(args);
        }
    }
}

package com.qzone.reborn.layer.part;

import android.app.Activity;
import android.os.Bundle;
import androidx.core.util.Consumer;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0014R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/qzone/reborn/layer/part/bg;", "Lcom/qzone/reborn/layer/part/ap;", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "", "N9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onPartCreate", "onLayerStateUpdate", "Lcom/qzone/reborn/layer/part/a;", "G", "Lcom/qzone/reborn/layer/part/a;", "outsideDataControl", "", "H", "Z", "isLoading", "<init>", "()V", "I", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class bg extends ap {

    /* renamed from: G, reason: from kotlin metadata */
    private a outsideDataControl;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean isLoading;

    private final int N9(RFWLayerState layerState) {
        List<RFWLayerItemMediaInfo> richMediaDataList = layerState.getRichMediaDataList();
        return (richMediaDataList != null ? richMediaDataList.size() - layerState.getSelectedPosition() : 1) - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(RFWLayerState layerState, bg this$0, List list) {
        Intrinsics.checkNotNullParameter(layerState, "$layerState");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        layerState.setRichMediaDataList(list);
        UIStateData<RFWLayerState> obtainSuccess = UIStateData.obtainSuccess(true);
        obtainSuccess.setDataList(layerState);
        this$0.getMLayerViewModel().mRichMediaInfo.postValue(obtainSuccess);
        this$0.isLoading = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.layer.part.ap
    public void onLayerStateUpdate(final RFWLayerState layerState) {
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        super.onLayerStateUpdate(layerState);
        int N9 = N9(layerState);
        a aVar = this.outsideDataControl;
        layerState.setMediaSum(aVar != null ? aVar.b() : 0);
        if (!this.isLoading && N9 < 3) {
            this.isLoading = true;
            a aVar2 = this.outsideDataControl;
            if (aVar2 != null) {
                aVar2.a(new Consumer() { // from class: com.qzone.reborn.layer.part.bf
                    @Override // androidx.core.util.Consumer
                    public final void accept(Object obj) {
                        bg.O9(RFWLayerState.this, this, (List) obj);
                    }
                });
            }
        }
    }

    @Override // com.qzone.reborn.layer.part.ap, com.tencent.richframework.gallery.part.RFWLayerBasePart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        String stringExtra = activity.getIntent().getStringExtra("layer_outside_data");
        if (stringExtra == null || stringExtra.length() == 0) {
            return;
        }
        Object a16 = fj.a.f399444a.a(stringExtra);
        this.outsideDataControl = a16 instanceof a ? (a) a16 : null;
    }
}

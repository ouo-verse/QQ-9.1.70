package com.qzone.reborn.albumx.common.layer.part;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.part.RFWLayerBasePart;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b&\u0010'J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u001a\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0015J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0014J\u0010\u0010\u0011\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u0012\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\fJ\n\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0014R$\u0010\u001b\u001a\u0004\u0018\u00018\u00008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\"\u0010%\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Lcom/qzone/reborn/albumx/common/layer/part/i;", "T", "Lcom/tencent/richframework/gallery/part/RFWLayerBasePart;", "Landroid/os/Bundle;", "data", "", "initCommonData", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, Constants.FILE_INSTANCE_STATE, "onPartCreate", "initIntentData", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "updateLayerState", "onLayerStateUpdate", "", "C9", "B9", "Lpk/b;", "A9", "d", "Ljava/lang/Object;", "x9", "()Ljava/lang/Object;", "setCurrentSelectedMedia", "(Ljava/lang/Object;)V", "currentSelectedMedia", "e", "Lpk/b;", "layerReportListener", "f", "I", "z9", "()I", "setCurrentSelectedPosition", "(I)V", "currentSelectedPosition", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class i<T> extends RFWLayerBasePart {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private T currentSelectedMedia;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private pk.b layerReportListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int currentSelectedPosition;

    /* JADX INFO: Access modifiers changed from: protected */
    public pk.b A9() {
        if (this.layerReportListener == null) {
            this.layerReportListener = (pk.b) RFWIocAbilityProvider.g().getIocInterface(pk.b.class, getRootView(), null);
        }
        return this.layerReportListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onLayerStateUpdate(RFWLayerState layerState) {
        Intrinsics.checkNotNullParameter(layerState, "layerState");
    }

    @Override // com.tencent.richframework.gallery.part.RFWLayerBasePart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        Intent intent = activity.getIntent();
        if (intent == null || intent.getExtras() == null) {
            return;
        }
        initCommonData(intent.getExtras());
        initIntentData(intent.getExtras());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.richframework.gallery.part.RFWLayerBasePart
    public void updateLayerState(RFWLayerState layerState) {
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        T t16 = null;
        if ((rFWLayerItemMediaInfo != null ? rFWLayerItemMediaInfo.getExtraData() : null) != null) {
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo2 = this.mCurrentSelectedItem;
            if (rFWLayerItemMediaInfo2 != null) {
                t16 = (T) rFWLayerItemMediaInfo2.getExtraData();
            }
            this.currentSelectedMedia = t16;
            this.mSelectedPosition = layerState.getSelectedPosition();
        } else {
            this.currentSelectedMedia = null;
        }
        this.currentSelectedPosition = layerState.getSelectedPosition();
        onLayerStateUpdate(layerState);
    }

    public final T x9() {
        return this.currentSelectedMedia;
    }

    /* renamed from: z9, reason: from getter */
    public final int getCurrentSelectedPosition() {
        return this.currentSelectedPosition;
    }

    public final int B9(RFWLayerState layerState) {
        if (layerState == null) {
            return 1;
        }
        return 1 + layerState.getSelectedPosition() + layerState.getPositionOffset();
    }

    public final int C9(RFWLayerState layerState) {
        if (layerState == null) {
            return 1;
        }
        if (layerState.getRichMediaDataList() == null) {
            return layerState.getMediaSum();
        }
        int mediaSum = layerState.getMediaSum();
        List<RFWLayerItemMediaInfo> richMediaDataList = layerState.getRichMediaDataList();
        Intrinsics.checkNotNull(richMediaDataList);
        return Math.max(mediaSum, richMediaDataList.size());
    }

    private final void initCommonData(Bundle data) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initIntentData(Bundle data) {
    }
}

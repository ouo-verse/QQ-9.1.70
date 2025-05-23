package com.tencent.richframework.gallery.part;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.CallSuper;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.gallery.RFWLayerIOCUtil;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerState;
import com.tencent.richframework.gallery.delegate.INTLayerOperationListener;
import com.tencent.richframework.gallery.delegate.inner.IVideoPlayerProvider;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0015J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0017J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0014J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0002H\u0014J\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u001a\u001a\u00020\u0019R$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001d\u0010'\u001a\u0004\u0018\u00010\"8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0013\u0010+\u001a\u0004\u0018\u00010(8F\u00a2\u0006\u0006\u001a\u0004\b)\u0010*\u00a8\u0006."}, d2 = {"Lcom/tencent/richframework/gallery/part/NTAIOLayerBasePart;", "Lcom/tencent/richframework/gallery/part/RFWLayerBasePart;", "Landroid/os/Bundle;", "data", "", "initCommonData", "Lcom/tencent/richframework/gallery/bean/RFWLayerState;", "layerState", "updateLayerState", "onLayerStateUpdate", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, Constants.FILE_INSTANCE_STATE, "onPartCreate", "bundle", "onRestore", "initIntentData", "", "getPageId", "Landroid/view/View;", "view", "bindDtElement", "Lcom/tencent/richframework/data/base/UIStateData$ModifyListRecord;", "modifyRecord", "updateRichMediaList", "", "isCurrentSelectVideo", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "mCurrentSelectedMessage", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "getMCurrentSelectedMessage", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "setMCurrentSelectedMessage", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "Lcom/tencent/richframework/gallery/delegate/INTLayerOperationListener;", "mLayerOperateListener$delegate", "Lkotlin/Lazy;", "getMLayerOperateListener", "()Lcom/tencent/richframework/gallery/delegate/INTLayerOperationListener;", "mLayerOperateListener", "Lcom/tencent/richframework/gallery/delegate/inner/IVideoPlayerProvider;", "getMLayerVideoControlProvider", "()Lcom/tencent/richframework/gallery/delegate/inner/IVideoPlayerProvider;", "mLayerVideoControlProvider", "<init>", "()V", "qq-layer-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public class NTAIOLayerBasePart extends RFWLayerBasePart {

    @Nullable
    private MsgRecord mCurrentSelectedMessage;

    /* renamed from: mLayerOperateListener$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mLayerOperateListener;

    public NTAIOLayerBasePart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<INTLayerOperationListener>() { // from class: com.tencent.richframework.gallery.part.NTAIOLayerBasePart$mLayerOperateListener$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final INTLayerOperationListener invoke() {
                return (INTLayerOperationListener) RFWIocAbilityProvider.g().getIocInterface(INTLayerOperationListener.class, NTAIOLayerBasePart.this.getPartRootView(), null);
            }
        });
        this.mLayerOperateListener = lazy;
    }

    public final void bindDtElement(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
    }

    @Nullable
    public final MsgRecord getMCurrentSelectedMessage() {
        return this.mCurrentSelectedMessage;
    }

    @Nullable
    public final INTLayerOperationListener getMLayerOperateListener() {
        return (INTLayerOperationListener) this.mLayerOperateListener.getValue();
    }

    @Nullable
    public final IVideoPlayerProvider getMLayerVideoControlProvider() {
        View rootView = getPartRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        return RFWLayerIOCUtil.getVideoControlProvider(rootView);
    }

    @NotNull
    public final String getPageId() {
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        Intrinsics.checkNotNull(rFWLayerItemMediaInfo);
        if (rFWLayerItemMediaInfo.isVideo()) {
            return "pg_bas_video_viewing";
        }
        return "pg_bas_picture_view";
    }

    protected void initIntentData(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
    }

    public final boolean isCurrentSelectVideo() {
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        if (rFWLayerItemMediaInfo == null || !rFWLayerItemMediaInfo.isVideo()) {
            return false;
        }
        return true;
    }

    public void onLayerStateUpdate(@NotNull RFWLayerState layerState) {
        Intrinsics.checkNotNullParameter(layerState, "layerState");
    }

    @Override // com.tencent.richframework.gallery.part.RFWLayerBasePart, com.tencent.biz.richframework.part.Part
    @CallSuper
    public void onPartCreate(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        Intent intent = activity.getIntent();
        if (savedInstanceState != null) {
            onRestore(savedInstanceState);
            return;
        }
        if (intent != null && intent.getExtras() != null) {
            Bundle extras = intent.getExtras();
            Intrinsics.checkNotNull(extras);
            initCommonData(extras);
            Bundle extras2 = intent.getExtras();
            Intrinsics.checkNotNull(extras2);
            initIntentData(extras2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.richframework.gallery.part.RFWLayerBasePart
    @CallSuper
    public void updateLayerState(@NotNull RFWLayerState layerState) {
        Object obj;
        Intrinsics.checkNotNullParameter(layerState, "layerState");
        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = this.mCurrentSelectedItem;
        MsgRecord msgRecord = null;
        Object obj2 = null;
        if (rFWLayerItemMediaInfo != null) {
            obj = rFWLayerItemMediaInfo.getExtraData();
        } else {
            obj = null;
        }
        if (obj instanceof AIOMsgItem) {
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo2 = this.mCurrentSelectedItem;
            if (rFWLayerItemMediaInfo2 != null) {
                obj2 = rFWLayerItemMediaInfo2.getExtraData();
            }
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.AIOMsgItem");
            msgRecord = ((AIOMsgItem) obj2).getMsgRecord();
        }
        this.mCurrentSelectedMessage = msgRecord;
        onLayerStateUpdate(layerState);
    }

    public final void updateRichMediaList(@NotNull UIStateData.ModifyListRecord modifyRecord) {
        Intrinsics.checkNotNullParameter(modifyRecord, "modifyRecord");
        UIStateData<RFWLayerState> value = getMLayerViewModel().mRichMediaInfo.getValue();
        if (value != null) {
            value.setLatestModifyRecord(modifyRecord);
        }
        getMLayerViewModel().mRichMediaInfo.setValue(getMLayerViewModel().mRichMediaInfo.getValue());
    }

    private final void initCommonData(Bundle data) {
    }

    protected void onRestore(@Nullable Bundle bundle) {
    }
}

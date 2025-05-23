package com.tencent.mobileqq.wink.preprocess;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.api.IQQWinkLaucher;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.context.p;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.lowthresholdltemplate.WinkTemplateSharePreviewViewModel;
import com.tencent.mobileqq.wink.lowthresholdltemplate.q;
import com.tencent.mobileqq.wink.view.QCircleCommonLoadingDialog;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.ResourceModel;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 82\u00020\u0001:\u00019B\u0007\u00a2\u0006\u0004\b6\u00107J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u0012\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J&\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001a2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J \u0010 \u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\tH\u0016J\u0018\u0010!\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\tH\u0016J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005H\u0016J\u000e\u0010#\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0005R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u001b\u00105\u001a\u0002008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/wink/preprocess/WinkAvatarShareTransFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "vh", "Dh", "", "missionId", "Fh", "newAvatarPath", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;", "editData", OcrConfig.CHINESE, "winkEditDataWrapper", "wh", "reason", "xh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "onResume", "outState", "onSaveInstanceState", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, IProfileCardConst.KEY_FROM_TYPE, "editDataWrapper", "yh", "Ah", "Bh", "Gh", "Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;", "dialog", "Lcom/tencent/mobileqq/wink/context/p;", "D", "Lcom/tencent/mobileqq/wink/context/p;", "winkCurrentContextBuilder", "Lcom/tencent/mobileqq/wink/lowthresholdltemplate/p;", "E", "Lcom/tencent/mobileqq/wink/lowthresholdltemplate/p;", "winkTemplateShareConfig", "Lcom/tencent/mobileqq/wink/lowthresholdltemplate/WinkTemplateSharePreviewViewModel;", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "Ch", "()Lcom/tencent/mobileqq/wink/lowthresholdltemplate/WinkTemplateSharePreviewViewModel;", "viewModel", "<init>", "()V", "G", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public class WinkAvatarShareTransFragment extends QPublicBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private QCircleCommonLoadingDialog dialog;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final p winkCurrentContextBuilder = new p();

    /* renamed from: E, reason: from kotlin metadata */
    private com.tencent.mobileqq.wink.lowthresholdltemplate.p winkTemplateShareConfig;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    public WinkAvatarShareTransFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<WinkTemplateSharePreviewViewModel>() { // from class: com.tencent.mobileqq.wink.preprocess.WinkAvatarShareTransFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WinkTemplateSharePreviewViewModel invoke() {
                com.tencent.mobileqq.wink.lowthresholdltemplate.p pVar;
                WinkTemplateSharePreviewViewModel winkTemplateSharePreviewViewModel = (WinkTemplateSharePreviewViewModel) WinkAvatarShareTransFragment.this.getViewModel(WinkTemplateSharePreviewViewModel.class);
                pVar = WinkAvatarShareTransFragment.this.winkTemplateShareConfig;
                if (pVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("winkTemplateShareConfig");
                    pVar = null;
                }
                winkTemplateSharePreviewViewModel.k2(pVar);
                return winkTemplateSharePreviewViewModel;
            }
        });
        this.viewModel = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WinkTemplateSharePreviewViewModel Ch() {
        Object value = this.viewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-viewModel>(...)");
        return (WinkTemplateSharePreviewViewModel) value;
    }

    private final void Dh() {
        LiveData<Result<com.tencent.mobileqq.wink.lowthresholdltemplate.a>> Z1 = Ch().Z1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Result<? extends com.tencent.mobileqq.wink.lowthresholdltemplate.a>, Unit> function1 = new Function1<Result<? extends com.tencent.mobileqq.wink.lowthresholdltemplate.a>, Unit>() { // from class: com.tencent.mobileqq.wink.preprocess.WinkAvatarShareTransFragment$initObserve$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Result<? extends com.tencent.mobileqq.wink.lowthresholdltemplate.a> result) {
                invoke2(result);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Result<? extends com.tencent.mobileqq.wink.lowthresholdltemplate.a> it) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (!Result.m483isSuccessimpl(it.getValue())) {
                    Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(it.getValue());
                    if (m479exceptionOrNullimpl != null) {
                        WinkAvatarShareTransFragment winkAvatarShareTransFragment = WinkAvatarShareTransFragment.this;
                        if (m479exceptionOrNullimpl instanceof CancellationException) {
                            return;
                        }
                        w53.b.d("WinkProcessContentTransFragment", "observa video prepare fail", m479exceptionOrNullimpl);
                        winkAvatarShareTransFragment.xh("error");
                        return;
                    }
                    return;
                }
                Object value = it.getValue();
                ResultKt.throwOnFailure(value);
                com.tencent.mobileqq.wink.lowthresholdltemplate.a aVar = (com.tencent.mobileqq.wink.lowthresholdltemplate.a) value;
                WinkEditorResourceManager.a1().i0(aVar.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String());
                WinkAvatarShareTransFragment.this.wh(aVar.getWinkEditDataWrapper());
            }
        };
        Z1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.wink.preprocess.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkAvatarShareTransFragment.Eh(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Fh(String missionId) {
        w53.b.f("WinkProcessContentTransFragment", "[recoveryFromWinkEditData] missionId=" + missionId + ", this:" + this);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.b()), null, null, new WinkAvatarShareTransFragment$recoveryFromWinkEditData$1(missionId, this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hh(String str) {
        QQToast.makeText(RFWApplication.getApplication(), str, 1).show();
    }

    private final void vh() {
        String str;
        QCircleCommonLoadingDialog.c cVar = new QCircleCommonLoadingDialog.c(getContext());
        Context context = getContext();
        if (context != null) {
            str = context.getString(R.string.f241327rk);
        } else {
            str = null;
        }
        this.dialog = cVar.p(str).n(false).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void wh(WinkEditDataWrapper winkEditDataWrapper) {
        Bundle bundle = new Bundle();
        bundle.putString(PeakConstants.QCIRCLE_CLIENT_TRACEID, WinkContext.INSTANCE.d().getTraceId());
        com.tencent.mobileqq.wink.lowthresholdltemplate.p pVar = this.winkTemplateShareConfig;
        com.tencent.mobileqq.wink.lowthresholdltemplate.p pVar2 = null;
        if (pVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkTemplateShareConfig");
            pVar = null;
        }
        bundle.putBoolean(QQWinkConstants.WINK_PUBLISH_PARAM_IS_SAVE_MEDIA, pVar.c().getNeedSaveToMedia());
        com.tencent.mobileqq.wink.lowthresholdltemplate.p pVar3 = this.winkTemplateShareConfig;
        if (pVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkTemplateShareConfig");
            pVar3 = null;
        }
        bundle.putString(WinkDaTongReportConstant.ElementParamKey.XSJ_AVATAR_PREVIEW_SOURCE, pVar3.getCom.tencent.mobileqq.profilecard.api.IProfileCardConst.KEY_FROM_TYPE java.lang.String());
        com.tencent.mobileqq.wink.editor.draft.a.h(winkEditDataWrapper, winkEditDataWrapper.getMissionId());
        com.tencent.mobileqq.wink.editor.draft.a.i(winkEditDataWrapper, winkEditDataWrapper.getMissionId());
        com.tencent.mobileqq.wink.lowthresholdltemplate.p pVar4 = this.winkTemplateShareConfig;
        if (pVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("winkTemplateShareConfig");
        } else {
            pVar2 = pVar4;
        }
        bundle.putString(QQWinkConstants.WINK_PUBLISH_TASK_ID, pVar2.c().getTaskId());
        bundle.putString(QQWinkConstants.MISSION_ID, winkEditDataWrapper.getMissionId());
        bundle.putString(QQWinkConstants.ENTRY_BUSINESS_NAME, "QCIRCLE");
        bundle.putBoolean(QQWinkConstants.EDITOR_ENABLE_SWITCH_EDIT_MODE, false);
        bundle.putInt(QQWinkConstants.EDITOR_ENTRANCE, 8);
        bundle.putBoolean(QQWinkConstants.EDITOR_DISABLE_SAVE_PUBLISH_DRAFT, true);
        bundle.putString(QQWinkConstants.EDITOR_EDITOR_TABS, "filter,textSticker,sticker,enhance");
        ((IQQWinkLaucher) QRoute.api(IQQWinkLaucher.class)).jumpToWinkEditor(com.tencent.mobileqq.wink.b.c(), bundle);
        xh("success");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void xh(String reason) {
        w53.b.f("WinkProcessContentTransFragment", "exit: " + reason);
        try {
            QCircleCommonLoadingDialog qCircleCommonLoadingDialog = this.dialog;
            if (qCircleCommonLoadingDialog != null) {
                qCircleCommonLoadingDialog.dismiss();
            }
        } catch (Exception e16) {
            w53.b.d("WinkProcessContentTransFragment", "dialog dismiss error", e16);
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
            activity.overridePendingTransition(R.anim.f154548b2, R.anim.f154550b4);
        }
    }

    private final WinkEditDataWrapper zh(String newAvatarPath, WinkEditDataWrapper editData) {
        ResourceModel resourceModel;
        int collectionSizeOrDefault;
        List mutableListOf;
        MediaModel copy;
        WinkEditData copy2;
        ResourceModel copy3;
        LocalMediaInfo outMediaInfo = editData.getOutMediaInfo();
        ResourceModel resourceModel2 = null;
        if (outMediaInfo != null) {
            outMediaInfo.thumbnailPath = null;
        }
        MediaClip mediaClip = editData.getEditDatas().get(0).getMediaModel().videos.get(0);
        ResourceModel resourceModel3 = mediaClip.resource;
        if (resourceModel3 != null) {
            copy3 = resourceModel3.copy((r35 & 1) != 0 ? resourceModel3.id : null, (r35 & 2) != 0 ? resourceModel3.path : null, (r35 & 4) != 0 ? Long.valueOf(resourceModel3.scaleDuration) : 10000000L, (r35 & 8) != 0 ? Long.valueOf(resourceModel3.sourceStart) : null, (r35 & 16) != 0 ? Long.valueOf(resourceModel3.sourceDuration) : 10000000L, (r35 & 32) != 0 ? Long.valueOf(resourceModel3.selectStart) : null, (r35 & 64) != 0 ? Long.valueOf(resourceModel3.selectDuration) : 10000000L, (r35 & 128) != 0 ? resourceModel3.type : null, (r35 & 256) != 0 ? resourceModel3.size : null, (r35 & 512) != 0 ? Float.valueOf(resourceModel3.volume) : null, (r35 & 1024) != 0 ? resourceModel3.extras : null, (r35 & 2048) != 0 ? resourceModel3.picClipRect : null, (r35 & 4096) != 0 ? resourceModel3.reversePath : null, (r35 & 8192) != 0 ? resourceModel3.normalPath : null, (r35 & 16384) != 0 ? resourceModel3.isReverseMode : null, (r35 & 32768) != 0 ? Float.valueOf(resourceModel3.deblurScore) : null, (r35 & 65536) != 0 ? resourceModel3.unknownFields() : null);
            resourceModel = copy3;
        } else {
            resourceModel = null;
        }
        MediaClip copy$default = MediaClip.copy$default(mediaClip, resourceModel, null, null, null, null, null, null, 126, null);
        MediaClip mediaClip2 = editData.getEditDatas().get(0).getMediaModel().videos.get(1);
        ResourceModel resourceModel4 = mediaClip2.resource;
        if (resourceModel4 != null) {
            resourceModel2 = resourceModel4.copy((r35 & 1) != 0 ? resourceModel4.id : null, (r35 & 2) != 0 ? resourceModel4.path : newAvatarPath, (r35 & 4) != 0 ? Long.valueOf(resourceModel4.scaleDuration) : 10000000L, (r35 & 8) != 0 ? Long.valueOf(resourceModel4.sourceStart) : null, (r35 & 16) != 0 ? Long.valueOf(resourceModel4.sourceDuration) : 10000000L, (r35 & 32) != 0 ? Long.valueOf(resourceModel4.selectStart) : null, (r35 & 64) != 0 ? Long.valueOf(resourceModel4.selectDuration) : 10000000L, (r35 & 128) != 0 ? resourceModel4.type : null, (r35 & 256) != 0 ? resourceModel4.size : null, (r35 & 512) != 0 ? Float.valueOf(resourceModel4.volume) : null, (r35 & 1024) != 0 ? resourceModel4.extras : null, (r35 & 2048) != 0 ? resourceModel4.picClipRect : null, (r35 & 4096) != 0 ? resourceModel4.reversePath : null, (r35 & 8192) != 0 ? resourceModel4.normalPath : null, (r35 & 16384) != 0 ? resourceModel4.isReverseMode : null, (r35 & 32768) != 0 ? Float.valueOf(resourceModel4.deblurScore) : null, (r35 & 65536) != 0 ? resourceModel4.unknownFields() : null);
        }
        MediaClip copy$default2 = MediaClip.copy$default(mediaClip2, resourceModel2, null, null, null, null, null, null, 126, null);
        ArrayList<WinkEditData> editDatas = editData.getEditDatas();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(editDatas, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (WinkEditData winkEditData : editDatas) {
            MediaModel mediaModel = winkEditData.getMediaModel();
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(copy$default, copy$default2);
            copy = mediaModel.copy((r39 & 1) != 0 ? mediaModel.id : null, (r39 & 2) != 0 ? mediaModel.name : null, (r39 & 4) != 0 ? mediaModel.version : null, (r39 & 8) != 0 ? mediaModel.createTime : null, (r39 & 16) != 0 ? mediaModel.updateTime : null, (r39 & 32) != 0 ? mediaModel.duration : null, (r39 & 64) != 0 ? mediaModel.videos : mutableListOf, (r39 & 128) != 0 ? mediaModel.audios : null, (r39 & 256) != 0 ? mediaModel.stickers : null, (r39 & 512) != 0 ? mediaModel.backgroundModel : null, (r39 & 1024) != 0 ? mediaModel.filterModels : null, (r39 & 2048) != 0 ? mediaModel.specialEffects : null, (r39 & 4096) != 0 ? mediaModel.transitions : null, (r39 & 8192) != 0 ? mediaModel.templateModel : null, (r39 & 16384) != 0 ? mediaModel.coverInfo : null, (r39 & 32768) != 0 ? mediaModel.exportSetting : null, (r39 & 65536) != 0 ? mediaModel.openHDR : null, (r39 & 131072) != 0 ? mediaModel.hdrModels : null, (r39 & 262144) != 0 ? mediaModel.smoothModels : null, (r39 & 524288) != 0 ? mediaModel.openSuperHDR : null, (r39 & 1048576) != 0 ? mediaModel.unknownFields() : null);
            copy2 = winkEditData.copy((r37 & 1) != 0 ? winkEditData.mediaModel : copy, (r37 & 2) != 0 ? winkEditData.durationUs : 0L, (r37 & 4) != 0 ? winkEditData.stickerModelMap : null, (r37 & 8) != 0 ? winkEditData.filterModelMap : null, (r37 & 16) != 0 ? winkEditData.filterMaterialMap : null, (r37 & 32) != 0 ? winkEditData.stickerExtraMap : null, (r37 & 64) != 0 ? winkEditData.openHDR : false, (r37 & 128) != 0 ? winkEditData.effectModelMap : null, (r37 & 256) != 0 ? winkEditData.renderModelStr : null, (r37 & 512) != 0 ? winkEditData.templateMaterialMap : null, (r37 & 1024) != 0 ? winkEditData.stretchData : null, (r37 & 2048) != 0 ? winkEditData.assetData : null, (r37 & 4096) != 0 ? winkEditData.isLakData : false, (r37 & 8192) != 0 ? winkEditData.mosaicData : null, (r37 & 16384) != 0 ? winkEditData.challengeData : null, (r37 & 32768) != 0 ? winkEditData.manualDeletedChallengeTag : null, (r37 & 65536) != 0 ? winkEditData.isAIElimination : false, (r37 & 131072) != 0 ? winkEditData.aiTemplate : null);
            arrayList.add(copy2);
        }
        return WinkEditDataWrapper.copy$default(editData, null, null, new ArrayList(arrayList), null, null, null, null, 0L, false, null, null, false, 0, 0.0f, 0.0f, null, false, null, null, false, 0L, null, null, false, 0L, false, null, false, null, false, null, 0, null, false, false, null, false, false, false, null, null, null, null, false, -5, 4095, null);
    }

    @NotNull
    public WinkEditDataWrapper Ah(@NotNull String newAvatarPath, @NotNull WinkEditDataWrapper editDataWrapper) {
        MediaClip mediaClip;
        char c16;
        char c17;
        ResourceModel resourceModel;
        int collectionSizeOrDefault;
        List mutableListOf;
        MediaModel copy;
        WinkEditData copy2;
        Intrinsics.checkNotNullParameter(newAvatarPath, "newAvatarPath");
        Intrinsics.checkNotNullParameter(editDataWrapper, "editDataWrapper");
        MediaClip mediaClip2 = editDataWrapper.getEditDatas().get(0).getMediaModel().videos.get(0);
        MediaClip mediaClip3 = editDataWrapper.getEditDatas().get(0).getMediaModel().videos.get(1);
        ResourceModel resourceModel2 = mediaClip3.resource;
        if (resourceModel2 != null) {
            mediaClip = mediaClip3;
            c16 = 1;
            c17 = 0;
            resourceModel = resourceModel2.copy((r35 & 1) != 0 ? resourceModel2.id : null, (r35 & 2) != 0 ? resourceModel2.path : newAvatarPath, (r35 & 4) != 0 ? Long.valueOf(resourceModel2.scaleDuration) : 5680000L, (r35 & 8) != 0 ? Long.valueOf(resourceModel2.sourceStart) : null, (r35 & 16) != 0 ? Long.valueOf(resourceModel2.sourceDuration) : 5680000L, (r35 & 32) != 0 ? Long.valueOf(resourceModel2.selectStart) : null, (r35 & 64) != 0 ? Long.valueOf(resourceModel2.selectDuration) : 5680000L, (r35 & 128) != 0 ? resourceModel2.type : null, (r35 & 256) != 0 ? resourceModel2.size : null, (r35 & 512) != 0 ? Float.valueOf(resourceModel2.volume) : null, (r35 & 1024) != 0 ? resourceModel2.extras : null, (r35 & 2048) != 0 ? resourceModel2.picClipRect : null, (r35 & 4096) != 0 ? resourceModel2.reversePath : null, (r35 & 8192) != 0 ? resourceModel2.normalPath : null, (r35 & 16384) != 0 ? resourceModel2.isReverseMode : null, (r35 & 32768) != 0 ? Float.valueOf(resourceModel2.deblurScore) : null, (r35 & 65536) != 0 ? resourceModel2.unknownFields() : null);
        } else {
            mediaClip = mediaClip3;
            c16 = 1;
            c17 = 0;
            resourceModel = null;
        }
        MediaClip copy$default = MediaClip.copy$default(mediaClip, resourceModel, null, null, null, null, null, null, 126, null);
        ArrayList<WinkEditData> editDatas = editDataWrapper.getEditDatas();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(editDatas, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (WinkEditData winkEditData : editDatas) {
            MediaModel mediaModel = winkEditData.getMediaModel();
            MediaClip[] mediaClipArr = new MediaClip[2];
            mediaClipArr[c17] = mediaClip2;
            mediaClipArr[c16] = copy$default;
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(mediaClipArr);
            copy = mediaModel.copy((r39 & 1) != 0 ? mediaModel.id : null, (r39 & 2) != 0 ? mediaModel.name : null, (r39 & 4) != 0 ? mediaModel.version : null, (r39 & 8) != 0 ? mediaModel.createTime : null, (r39 & 16) != 0 ? mediaModel.updateTime : null, (r39 & 32) != 0 ? mediaModel.duration : null, (r39 & 64) != 0 ? mediaModel.videos : mutableListOf, (r39 & 128) != 0 ? mediaModel.audios : null, (r39 & 256) != 0 ? mediaModel.stickers : null, (r39 & 512) != 0 ? mediaModel.backgroundModel : null, (r39 & 1024) != 0 ? mediaModel.filterModels : null, (r39 & 2048) != 0 ? mediaModel.specialEffects : null, (r39 & 4096) != 0 ? mediaModel.transitions : null, (r39 & 8192) != 0 ? mediaModel.templateModel : null, (r39 & 16384) != 0 ? mediaModel.coverInfo : null, (r39 & 32768) != 0 ? mediaModel.exportSetting : null, (r39 & 65536) != 0 ? mediaModel.openHDR : null, (r39 & 131072) != 0 ? mediaModel.hdrModels : null, (r39 & 262144) != 0 ? mediaModel.smoothModels : null, (r39 & 524288) != 0 ? mediaModel.openSuperHDR : null, (r39 & 1048576) != 0 ? mediaModel.unknownFields() : null);
            copy2 = winkEditData.copy((r37 & 1) != 0 ? winkEditData.mediaModel : copy, (r37 & 2) != 0 ? winkEditData.durationUs : 0L, (r37 & 4) != 0 ? winkEditData.stickerModelMap : null, (r37 & 8) != 0 ? winkEditData.filterModelMap : null, (r37 & 16) != 0 ? winkEditData.filterMaterialMap : null, (r37 & 32) != 0 ? winkEditData.stickerExtraMap : null, (r37 & 64) != 0 ? winkEditData.openHDR : false, (r37 & 128) != 0 ? winkEditData.effectModelMap : null, (r37 & 256) != 0 ? winkEditData.renderModelStr : null, (r37 & 512) != 0 ? winkEditData.templateMaterialMap : null, (r37 & 1024) != 0 ? winkEditData.stretchData : null, (r37 & 2048) != 0 ? winkEditData.assetData : null, (r37 & 4096) != 0 ? winkEditData.isLakData : false, (r37 & 8192) != 0 ? winkEditData.mosaicData : null, (r37 & 16384) != 0 ? winkEditData.challengeData : null, (r37 & 32768) != 0 ? winkEditData.manualDeletedChallengeTag : null, (r37 & 65536) != 0 ? winkEditData.isAIElimination : false, (r37 & 131072) != 0 ? winkEditData.aiTemplate : null);
            arrayList.add(copy2);
        }
        return WinkEditDataWrapper.copy$default(editDataWrapper, null, null, new ArrayList(arrayList), null, null, null, null, 0L, false, null, null, false, 0, 0.0f, 0.0f, null, false, null, null, false, 0L, null, null, false, 0L, false, null, false, null, false, null, 0, null, false, false, null, false, false, false, null, null, null, null, false, -5, 4095, null);
    }

    @NotNull
    public String Bh(@NotNull String fromType) {
        Intrinsics.checkNotNullParameter(fromType, "fromType");
        if (!Intrinsics.areEqual(fromType, QQWinkConstants.WinkLowLevelTemplateShareConstant.QQ_AVATAR_ALBUM) && !Intrinsics.areEqual(fromType, QQWinkConstants.WinkLowLevelTemplateShareConstant.QQ_AVATAR_HISTORY)) {
            return "\u6b22\u8fce\u56f4\u89c2\u6211\u7684\u65b0\u5934\u50cf #\u6211\u7684QQ\u77ed\u89c6\u9891\u5934\u50cf";
        }
        return "\u66f4\u65b0\u4e86\u6211\u7684QQ\u5934\u50cf\uff0c\u5927\u5bb6\u5feb\u6765\u56f4\u89c2\uff5e#QQ\u5934\u50cf\u89c6\u9891\u6765\u4e86";
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Gh(@NotNull String fromType) {
        boolean z16;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(fromType, "fromType");
        if (Intrinsics.areEqual(fromType, QQWinkConstants.WinkLowLevelTemplateShareConstant.QQ_SIGN) || Intrinsics.areEqual(fromType, QQWinkConstants.WinkLowLevelTemplateShareConstant.QQ_AVATAR_ALBUM) || Intrinsics.areEqual(fromType, QQWinkConstants.WinkLowLevelTemplateShareConstant.QQ_AVATAR_HISTORY)) {
            com.tencent.mobileqq.wink.lowthresholdltemplate.p pVar = this.winkTemplateShareConfig;
            if (pVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("winkTemplateShareConfig");
                pVar = null;
            }
            final String publishingToastText = pVar.e().getPublishingToastText();
            if (publishingToastText != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(publishingToastText);
                if (!isBlank) {
                    z16 = false;
                    if (z16) {
                        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.preprocess.b
                            @Override // java.lang.Runnable
                            public final void run() {
                                WinkAvatarShareTransFragment.Hh(publishingToastText);
                            }
                        }, 500L);
                        return;
                    }
                    return;
                }
            }
            z16 = true;
            if (z16) {
            }
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Intent intent;
        super.onCreate(savedInstanceState);
        p pVar = this.winkCurrentContextBuilder;
        FragmentActivity activity = getActivity();
        com.tencent.mobileqq.wink.lowthresholdltemplate.p pVar2 = null;
        if (activity != null) {
            intent = activity.getIntent();
        } else {
            intent = null;
        }
        pVar.a(savedInstanceState, intent);
        Intent intent2 = requireActivity().getIntent();
        if (intent2 != null) {
            String stringExtra = intent2.getStringExtra(QQWinkConstants.WinkLowLevelTemplateShareConstant.WINK_TEMPLATE_FROM_TYPE);
            q qVar = new q();
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            Intrinsics.checkNotNull(stringExtra, "null cannot be cast to non-null type kotlin.String");
            pVar2 = qVar.e(requireActivity, stringExtra, intent2.getExtras());
            w53.b.a(QPublicBaseFragment.TAG, stringExtra + ", " + pVar2);
        }
        if (pVar2 == null) {
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.finish();
                return;
            }
            return;
        }
        this.winkTemplateShareConfig = pVar2;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.i78, container, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Intent intent;
        super.onResume();
        p pVar = this.winkCurrentContextBuilder;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            intent = activity.getIntent();
        } else {
            intent = null;
        }
        pVar.a(null, intent);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        this.winkCurrentContextBuilder.c(outState);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        QLog.d("WinkProcessContentTransFragment", 1, "onViewCreated, this:" + this);
        Dh();
        Fh(WinkContext.INSTANCE.d().getMissionId());
        vh();
        QCircleCommonLoadingDialog qCircleCommonLoadingDialog = this.dialog;
        if (qCircleCommonLoadingDialog != null) {
            qCircleCommonLoadingDialog.show();
        }
    }

    @NotNull
    public WinkEditDataWrapper yh(@NotNull String newAvatarPath, @NotNull String fromType, @NotNull WinkEditDataWrapper editDataWrapper) {
        Intrinsics.checkNotNullParameter(newAvatarPath, "newAvatarPath");
        Intrinsics.checkNotNullParameter(fromType, "fromType");
        Intrinsics.checkNotNullParameter(editDataWrapper, "editDataWrapper");
        if (!Intrinsics.areEqual(fromType, QQWinkConstants.WinkLowLevelTemplateShareConstant.QQ_AVATAR_ALBUM) && !Intrinsics.areEqual(fromType, QQWinkConstants.WinkLowLevelTemplateShareConstant.QQ_AVATAR_HISTORY)) {
            return zh(newAvatarPath, editDataWrapper);
        }
        return Ah(newAvatarPath, editDataWrapper);
    }
}

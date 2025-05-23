package com.tencent.mobileqq.wink.picker.qcircle.templatelibrary;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.picker.MediaType;
import com.tencent.mobileqq.wink.picker.core.universal.UniversalMediaItemClickListener;
import com.tencent.mobileqq.wink.picker.core.viewmodel.WinkSelectedMediaViewModel;
import com.tencent.mobileqq.wink.picker.qcircle.viewmodel.QCircleTemplateMediaPickerViewModel;
import com.tencent.mobileqq.wink.utils.j;
import com.tencent.mobileqq.wink.view.QCircleCommonLoadingDialog;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.util.UiThreadUtil;
import d93.c;
import e93.i;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0017\u00a2\u0006\u0004\b\u001e\u0010\u001fJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J6\u0010\u0014\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0006H\u0016J(\u0010\u0016\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qcircle/templatelibrary/TemplateLibMediaItemClickListener;", "Lcom/tencent/mobileqq/wink/picker/core/universal/UniversalMediaItemClickListener;", "Landroid/view/View;", "view", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "toAddedMedia", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;", "selectedMediaViewModel", "", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "v", "", QAdVrReportParams.ParamKey.MEDIA, "Lcom/tencent/mobileqq/wink/picker/MediaType;", "mediaType", "", "layoutPosition", "winkMediaViewModel", "b", "itemInfo", "a", "Lcom/tencent/mobileqq/wink/picker/qcircle/viewmodel/QCircleTemplateMediaPickerViewModel;", "Lcom/tencent/mobileqq/wink/picker/qcircle/viewmodel/QCircleTemplateMediaPickerViewModel;", "templateMediaPickerViewModel", "", "c", "Z", "isEnableSelect", "<init>", "(Lcom/tencent/mobileqq/wink/picker/qcircle/viewmodel/QCircleTemplateMediaPickerViewModel;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class TemplateLibMediaItemClickListener extends UniversalMediaItemClickListener {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QCircleTemplateMediaPickerViewModel templateMediaPickerViewModel;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isEnableSelect;

    public TemplateLibMediaItemClickListener(@NotNull QCircleTemplateMediaPickerViewModel templateMediaPickerViewModel) {
        Intrinsics.checkNotNullParameter(templateMediaPickerViewModel, "templateMediaPickerViewModel");
        this.templateMediaPickerViewModel = templateMediaPickerViewModel;
        this.isEnableSelect = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(LocalMediaInfo toAddedMedia, WinkSelectedMediaViewModel selectedMediaViewModel) {
        Integer value = this.templateMediaPickerViewModel.R1().getValue();
        if (value != null && value.intValue() != -1 && this.templateMediaPickerViewModel.n2(toAddedMedia)) {
            selectedMediaViewModel.O1(toAddedMedia, value.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(final View view, final LocalMediaInfo toAddedMedia, final WinkSelectedMediaViewModel selectedMediaViewModel) {
        this.isEnableSelect = false;
        final QCircleCommonLoadingDialog a16 = new QCircleCommonLoadingDialog.c(view.getContext()).p(view.getContext().getString(R.string.f240367oz)).n(true).a();
        a16.show();
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.qcircle.templatelibrary.a
            @Override // java.lang.Runnable
            public final void run() {
                TemplateLibMediaItemClickListener.o(LocalMediaInfo.this, this, a16, selectedMediaViewModel, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(final LocalMediaInfo toAddedMedia, final TemplateLibMediaItemClickListener this$0, final QCircleCommonLoadingDialog qCircleCommonLoadingDialog, final WinkSelectedMediaViewModel selectedMediaViewModel, final View view) {
        Intrinsics.checkNotNullParameter(toAddedMedia, "$toAddedMedia");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(selectedMediaViewModel, "$selectedMediaViewModel");
        Intrinsics.checkNotNullParameter(view, "$view");
        String str = toAddedMedia.path;
        Intrinsics.checkNotNullExpressionValue(str, "toAddedMedia.path");
        final boolean g16 = j.g(str);
        this$0.isEnableSelect = true;
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.qcircle.templatelibrary.b
            @Override // java.lang.Runnable
            public final void run() {
                TemplateLibMediaItemClickListener.p(QCircleCommonLoadingDialog.this, g16, this$0, toAddedMedia, selectedMediaViewModel, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0020, code lost:
    
        if (r3.isShowing() == true) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void p(QCircleCommonLoadingDialog qCircleCommonLoadingDialog, boolean z16, TemplateLibMediaItemClickListener this$0, LocalMediaInfo toAddedMedia, WinkSelectedMediaViewModel selectedMediaViewModel, View view) {
        boolean z17;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(toAddedMedia, "$toAddedMedia");
        Intrinsics.checkNotNullParameter(selectedMediaViewModel, "$selectedMediaViewModel");
        Intrinsics.checkNotNullParameter(view, "$view");
        if (qCircleCommonLoadingDialog != null) {
            z17 = true;
        }
        z17 = false;
        if (z17) {
            qCircleCommonLoadingDialog.dismiss();
        }
        if (z16) {
            this$0.m(toAddedMedia, selectedMediaViewModel);
        } else {
            QQToast.makeText(view.getContext(), R.string.f241357rn, 0).show();
            this$0.q(view);
        }
    }

    private final void q(View view) {
        VideoReport.setElementId(view, WinkDaTongReportConstant.ElementId.EM_XSJ_ERROR_PANEL);
        Map<String, Object> map = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(map, "map");
        map.put("xsj_custom_pgid", "pg_xsj_choose_media_new_page");
        map.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CHOOSE_MEDIA_ERROR_TYPE, 0);
        VideoReport.reportEvent("ev_xsj_camera_action", view, map);
    }

    @Override // com.tencent.mobileqq.wink.picker.core.universal.UniversalMediaItemClickListener, com.tencent.mobileqq.wink.picker.core.a
    public int a(@NotNull final View v3, @NotNull final LocalMediaInfo itemInfo, @NotNull MediaType mediaType, @NotNull final WinkSelectedMediaViewModel selectedMediaViewModel) {
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(itemInfo, "itemInfo");
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        Intrinsics.checkNotNullParameter(selectedMediaViewModel, "selectedMediaViewModel");
        this.templateMediaPickerViewModel.q2(v3);
        if (selectedMediaViewModel.b2()) {
            c.Companion companion = d93.c.INSTANCE;
            Context context = v3.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "v.context");
            companion.b(context, i.x(itemInfo), new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.templatelibrary.TemplateLibMediaItemClickListener$onItemSelect$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    boolean z16;
                    if (WinkSelectedMediaViewModel.this.getNeedFaceDetectWhenSelect()) {
                        z16 = this.isEnableSelect;
                        if (z16) {
                            this.n(v3, itemInfo, WinkSelectedMediaViewModel.this);
                            return;
                        }
                        return;
                    }
                    this.m(itemInfo, WinkSelectedMediaViewModel.this);
                }
            });
        } else {
            d(v3, itemInfo, selectedMediaViewModel);
        }
        return itemInfo.selectStatus;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.universal.UniversalMediaItemClickListener, com.tencent.mobileqq.wink.picker.core.a
    public void b(@NotNull View v3, @NotNull final List<? extends LocalMediaInfo> media, @NotNull MediaType mediaType, final int layoutPosition, @NotNull WinkSelectedMediaViewModel winkMediaViewModel) {
        Object orNull;
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(media, "media");
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        Intrinsics.checkNotNullParameter(winkMediaViewModel, "winkMediaViewModel");
        if (!this.templateMediaPickerViewModel.getIsFragmentCollapsed()) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(media, layoutPosition);
            LocalMediaInfo localMediaInfo = (LocalMediaInfo) orNull;
            if (localMediaInfo != null) {
                c.Companion companion = d93.c.INSTANCE;
                Context context = v3.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "v.context");
                companion.b(context, i.x(localMediaInfo), new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.templatelibrary.TemplateLibMediaItemClickListener$onItemClick$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        com.tencent.mobileqq.wink.picker.core.c.f324480a.i(TemplateLibMediaPreviewFragment.INSTANCE.a(media, layoutPosition));
                    }
                });
                return;
            }
            return;
        }
        this.templateMediaPickerViewModel.p2(v3);
    }
}

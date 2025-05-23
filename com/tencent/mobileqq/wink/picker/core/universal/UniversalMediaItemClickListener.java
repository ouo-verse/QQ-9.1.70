package com.tencent.mobileqq.wink.picker.core.universal;

import android.content.Context;
import android.view.View;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.picker.MediaType;
import com.tencent.mobileqq.wink.picker.TabType;
import com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment;
import com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPreviewFragment;
import com.tencent.mobileqq.wink.picker.core.viewmodel.WinkSelectedMediaViewModel;
import com.tencent.mobileqq.wink.picker.qcircle.viewmodel.QCircleTemplateMediaPickerViewModel;
import d93.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J6\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J(\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J \u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000fH\u0014J \u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000fH\u0014J\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000fH\u0014J\u0018\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH\u0014R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001d\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/universal/UniversalMediaItemClickListener;", "Lcom/tencent/mobileqq/wink/picker/core/a;", "Lcom/tencent/mobileqq/wink/picker/qcircle/viewmodel/QCircleTemplateMediaPickerViewModel;", "templateMediaPickerViewModel", "", "c", "Landroid/view/View;", "v", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", QAdVrReportParams.ParamKey.MEDIA, "Lcom/tencent/mobileqq/wink/picker/MediaType;", "mediaType", "", "layoutPosition", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;", "winkMediaViewModel", "b", "itemInfo", "selectedMediaViewModel", "a", "toAddedMedia", "e", "d", "toRemovedMedia", "f", "", "toastMsg", "g", "Lcom/tencent/mobileqq/wink/picker/qcircle/viewmodel/QCircleTemplateMediaPickerViewModel;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public class UniversalMediaItemClickListener implements com.tencent.mobileqq.wink.picker.core.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QCircleTemplateMediaPickerViewModel templateMediaPickerViewModel;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f324681a;

        static {
            int[] iArr = new int[TabType.values().length];
            try {
                iArr[TabType.ALL_MEDIA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TabType.ONLY_IMAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TabType.ONLY_VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f324681a = iArr;
        }
    }

    @Override // com.tencent.mobileqq.wink.picker.core.a
    public int a(@NotNull View v3, @NotNull LocalMediaInfo itemInfo, @NotNull MediaType mediaType, @NotNull WinkSelectedMediaViewModel selectedMediaViewModel) {
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(itemInfo, "itemInfo");
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        Intrinsics.checkNotNullParameter(selectedMediaViewModel, "selectedMediaViewModel");
        QCircleTemplateMediaPickerViewModel qCircleTemplateMediaPickerViewModel = this.templateMediaPickerViewModel;
        if (qCircleTemplateMediaPickerViewModel != null) {
            qCircleTemplateMediaPickerViewModel.q2(v3);
        }
        if (itemInfo.selectStatus == 1) {
            f(itemInfo, selectedMediaViewModel);
        } else if (selectedMediaViewModel.b2()) {
            e(v3, itemInfo, selectedMediaViewModel);
        } else {
            d(v3, itemInfo, selectedMediaViewModel);
        }
        return itemInfo.selectStatus;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.a
    public void b(@NotNull View v3, @NotNull final List<? extends LocalMediaInfo> media, @NotNull final MediaType mediaType, final int layoutPosition, @NotNull WinkSelectedMediaViewModel winkMediaViewModel) {
        Object orNull;
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(media, "media");
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        Intrinsics.checkNotNullParameter(winkMediaViewModel, "winkMediaViewModel");
        QCircleTemplateMediaPickerViewModel qCircleTemplateMediaPickerViewModel = this.templateMediaPickerViewModel;
        boolean z16 = false;
        if (qCircleTemplateMediaPickerViewModel != null && qCircleTemplateMediaPickerViewModel.getIsFragmentCollapsed()) {
            z16 = true;
        }
        if (!z16) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(media, layoutPosition);
            final LocalMediaInfo localMediaInfo = (LocalMediaInfo) orNull;
            if (localMediaInfo != null) {
                c.Companion companion = d93.c.INSTANCE;
                Context context = v3.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "v.context");
                companion.b(context, e93.i.x(localMediaInfo), new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.picker.core.universal.UniversalMediaItemClickListener$onItemClick$1$1
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
                        List<? extends LocalMediaInfo> listOf;
                        com.tencent.mobileqq.wink.picker.core.c cVar = com.tencent.mobileqq.wink.picker.core.c.f324480a;
                        MediaType mediaType2 = MediaType.this;
                        LocalMediaInfo localMediaInfo2 = localMediaInfo;
                        List<LocalMediaInfo> list = media;
                        int i3 = layoutPosition;
                        if (cVar.h()) {
                            WinkMediaPickerMainBaseFragment<?> f16 = cVar.f();
                            if (f16 != null) {
                                boolean isQZoneMedia = mediaType2.isQZoneMedia();
                                listOf = CollectionsKt__CollectionsJVMKt.listOf(localMediaInfo2);
                                f16.di(isQZoneMedia, listOf);
                                return;
                            }
                            return;
                        }
                        cVar.i(WinkMediaPreviewFragment.I.a(list, i3));
                        com.tencent.mobileqq.wink.picker.report.a.g(null, null, "em_xsj_clck_preview", null, 10, null);
                    }
                });
                return;
            }
            return;
        }
        QCircleTemplateMediaPickerViewModel qCircleTemplateMediaPickerViewModel2 = this.templateMediaPickerViewModel;
        if (qCircleTemplateMediaPickerViewModel2 != null) {
            qCircleTemplateMediaPickerViewModel2.p2(v3);
        }
    }

    public final void c(@NotNull QCircleTemplateMediaPickerViewModel templateMediaPickerViewModel) {
        Intrinsics.checkNotNullParameter(templateMediaPickerViewModel, "templateMediaPickerViewModel");
        this.templateMediaPickerViewModel = templateMediaPickerViewModel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(@NotNull View v3, @NotNull LocalMediaInfo toAddedMedia, @NotNull WinkSelectedMediaViewModel selectedMediaViewModel) {
        String string;
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(toAddedMedia, "toAddedMedia");
        Intrinsics.checkNotNullParameter(selectedMediaViewModel, "selectedMediaViewModel");
        String string2 = v3.getContext().getResources().getString(R.string.f174142v2, Integer.valueOf(selectedMediaViewModel.getMaxSelectMediaSize()));
        Intrinsics.checkNotNullExpressionValue(string2, "v.context.resources.getS\u2026SelectMediaSize\n        )");
        int i3 = a.f324681a[com.tencent.mobileqq.wink.picker.core.c.f324480a.b().getLocalMediaTabType().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    string = v3.getContext().getResources().getString(R.string.f174192v7);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                string = v3.getContext().getResources().getString(R.string.f174182v6);
            }
        } else {
            string = v3.getContext().getResources().getString(R.string.f174172v5);
        }
        Intrinsics.checkNotNullExpressionValue(string, "when (WinkMediaPickerCon\u2026ist_type_video)\n        }");
        g(v3, string2 + string);
    }

    protected void e(@NotNull View v3, @NotNull final LocalMediaInfo toAddedMedia, @NotNull final WinkSelectedMediaViewModel selectedMediaViewModel) {
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(toAddedMedia, "toAddedMedia");
        Intrinsics.checkNotNullParameter(selectedMediaViewModel, "selectedMediaViewModel");
        c.Companion companion = d93.c.INSTANCE;
        Context context = v3.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "v.context");
        companion.b(context, e93.i.x(toAddedMedia), new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.picker.core.universal.UniversalMediaItemClickListener$onItemSelected$1
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
                WinkSelectedMediaViewModel.P1(WinkSelectedMediaViewModel.this, toAddedMedia, 0, 2, null);
            }
        });
    }

    protected void f(@NotNull LocalMediaInfo toRemovedMedia, @NotNull WinkSelectedMediaViewModel selectedMediaViewModel) {
        Intrinsics.checkNotNullParameter(toRemovedMedia, "toRemovedMedia");
        Intrinsics.checkNotNullParameter(selectedMediaViewModel, "selectedMediaViewModel");
        selectedMediaViewModel.d2(e93.i.p(toRemovedMedia), toRemovedMedia);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(@NotNull View v3, @NotNull String toastMsg) {
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(toastMsg, "toastMsg");
        if (!FastClickUtils.isFastDoubleClick("key_show_toast_interval", 2000L)) {
            QQToast.makeText(v3.getContext(), toastMsg, 0).show();
        }
    }
}

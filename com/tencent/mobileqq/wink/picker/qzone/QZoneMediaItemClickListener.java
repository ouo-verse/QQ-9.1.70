package com.tencent.mobileqq.wink.picker.qzone;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.wink.picker.MediaType;
import com.tencent.mobileqq.wink.picker.QZoneInitBean;
import com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment;
import com.tencent.mobileqq.wink.picker.core.universal.UniversalMediaItemClickListener;
import com.tencent.mobileqq.wink.picker.core.viewmodel.WinkSelectedMediaViewModel;
import com.tencent.mobileqq.wink.picker.qzone.QZoneMediaPreviewFragment;
import d93.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0017\u0010\u0018J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J6\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J(\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qzone/QZoneMediaItemClickListener;", "Lcom/tencent/mobileqq/wink/picker/core/universal/UniversalMediaItemClickListener;", "Landroid/view/View;", "v", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", QAdVrReportParams.ParamKey.MEDIA, "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;", "selectedMediaViewModel", "", "i", "", "Lcom/tencent/mobileqq/wink/picker/MediaType;", "mediaType", "", "layoutPosition", "winkMediaViewModel", "", "b", "itemInfo", "a", "Lcom/tencent/mobileqq/wink/picker/QZoneInitBean;", "Lcom/tencent/mobileqq/wink/picker/QZoneInitBean;", "initBean", "<init>", "(Lcom/tencent/mobileqq/wink/picker/QZoneInitBean;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class QZoneMediaItemClickListener extends UniversalMediaItemClickListener {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QZoneInitBean initBean;

    public QZoneMediaItemClickListener(@NotNull QZoneInitBean initBean) {
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        this.initBean = initBean;
    }

    private final boolean i(View v3, LocalMediaInfo media, WinkSelectedMediaViewModel selectedMediaViewModel) {
        if (!e93.i.I(media) || media.selectStatus == 1 || !selectedMediaViewModel.b2() || selectedMediaViewModel.X1() < this.initBean.getMaxVideoCountLimitNum()) {
            return false;
        }
        String string = v3.getContext().getResources().getString(R.string.f174132v1, Integer.valueOf(this.initBean.getMaxVideoCountLimitNum()));
        Intrinsics.checkNotNullExpressionValue(string, "v.context.resources.getS\u2026eoCountLimitNum\n        )");
        g(v3, string);
        return true;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.universal.UniversalMediaItemClickListener, com.tencent.mobileqq.wink.picker.core.a
    public int a(@NotNull View v3, @NotNull LocalMediaInfo itemInfo, @NotNull MediaType mediaType, @NotNull WinkSelectedMediaViewModel selectedMediaViewModel) {
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(itemInfo, "itemInfo");
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        Intrinsics.checkNotNullParameter(selectedMediaViewModel, "selectedMediaViewModel");
        if (i(v3, itemInfo, selectedMediaViewModel)) {
            return itemInfo.selectStatus;
        }
        boolean z16 = true;
        if (itemInfo.selectStatus == 1) {
            z16 = false;
        }
        com.tencent.mobileqq.wink.picker.report.a.c(v3, "em_xsj_content", z16);
        return super.a(v3, itemInfo, mediaType, selectedMediaViewModel);
    }

    @Override // com.tencent.mobileqq.wink.picker.core.universal.UniversalMediaItemClickListener, com.tencent.mobileqq.wink.picker.core.a
    public void b(@NotNull View v3, @NotNull List<? extends LocalMediaInfo> media, @NotNull final MediaType mediaType, final int layoutPosition, @NotNull final WinkSelectedMediaViewModel winkMediaViewModel) {
        Object orNull;
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(media, "media");
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        Intrinsics.checkNotNullParameter(winkMediaViewModel, "winkMediaViewModel");
        orNull = CollectionsKt___CollectionsKt.getOrNull(media, layoutPosition);
        final LocalMediaInfo localMediaInfo = (LocalMediaInfo) orNull;
        if (localMediaInfo != null) {
            c.Companion companion = d93.c.INSTANCE;
            Context context = v3.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "v.context");
            companion.b(context, e93.i.x(localMediaInfo), new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.picker.qzone.QZoneMediaItemClickListener$onItemClick$1$1
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
                    QZoneInitBean qZoneInitBean;
                    QZoneInitBean qZoneInitBean2;
                    List<? extends LocalMediaInfo> listOf;
                    com.tencent.mobileqq.wink.picker.core.c cVar = com.tencent.mobileqq.wink.picker.core.c.f324480a;
                    QZoneMediaItemClickListener qZoneMediaItemClickListener = QZoneMediaItemClickListener.this;
                    MediaType mediaType2 = mediaType;
                    LocalMediaInfo localMediaInfo2 = localMediaInfo;
                    WinkSelectedMediaViewModel winkSelectedMediaViewModel = winkMediaViewModel;
                    int i3 = layoutPosition;
                    qZoneInitBean = qZoneMediaItemClickListener.initBean;
                    if (qZoneInitBean.isSingleSelectMode()) {
                        WinkMediaPickerMainBaseFragment<?> f16 = cVar.f();
                        if (f16 != null) {
                            boolean isQZoneMedia = mediaType2.isQZoneMedia();
                            listOf = CollectionsKt__CollectionsJVMKt.listOf(localMediaInfo2);
                            f16.di(isQZoneMedia, listOf);
                            return;
                        }
                        return;
                    }
                    winkSelectedMediaViewModel.e2();
                    QZoneMediaPreviewFragment.a aVar = QZoneMediaPreviewFragment.L;
                    ArrayList arrayList = new ArrayList();
                    qZoneInitBean2 = qZoneMediaItemClickListener.initBean;
                    cVar.i(aVar.a(arrayList, i3, mediaType2, true, qZoneInitBean2.getEnableEdit()));
                }
            });
        }
    }
}

package com.tencent.mobileqq.wink.picker.qcircle;

import android.content.Context;
import android.view.View;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.wink.picker.MediaType;
import com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment;
import com.tencent.mobileqq.wink.picker.core.universal.UniversalMediaItemClickListener;
import com.tencent.mobileqq.wink.picker.core.viewmodel.WinkSelectedMediaViewModel;
import d93.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J6\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qcircle/QCircleMediaClickListener;", "Lcom/tencent/mobileqq/wink/picker/core/universal/UniversalMediaItemClickListener;", "Landroid/view/View;", "v", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", QAdVrReportParams.ParamKey.MEDIA, "Lcom/tencent/mobileqq/wink/picker/MediaType;", "mediaType", "", "layoutPosition", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;", "winkMediaViewModel", "", "b", "<init>", "()V", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class QCircleMediaClickListener extends UniversalMediaItemClickListener {
    @Override // com.tencent.mobileqq.wink.picker.core.universal.UniversalMediaItemClickListener, com.tencent.mobileqq.wink.picker.core.a
    public void b(@NotNull View v3, @NotNull final List<? extends LocalMediaInfo> media, @NotNull final MediaType mediaType, final int layoutPosition, @NotNull WinkSelectedMediaViewModel winkMediaViewModel) {
        Object orNull;
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(media, "media");
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        Intrinsics.checkNotNullParameter(winkMediaViewModel, "winkMediaViewModel");
        if (!FastClickUtils.isFastDoubleClick("QCircleMediaClickListener")) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(media, layoutPosition);
            final LocalMediaInfo localMediaInfo = (LocalMediaInfo) orNull;
            if (localMediaInfo != null) {
                c.Companion companion = d93.c.INSTANCE;
                Context context = v3.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "v.context");
                companion.b(context, e93.i.x(localMediaInfo), new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.picker.qcircle.QCircleMediaClickListener$onItemClick$1$1
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
                        cVar.i(QCircleMediaPickerPreviewFragment.K.a(list, i3));
                        com.tencent.mobileqq.wink.picker.report.a.g(null, null, "em_xsj_clck_preview", null, 10, null);
                    }
                });
            }
        }
    }
}

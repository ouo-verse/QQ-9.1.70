package com.tencent.mobileqq.wink.editor.sticker.sticker;

import android.content.Context;
import android.text.TextUtils;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.editor.WinkEditorFragment;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.performance.WinkEditPerformanceViewModel;
import com.tencent.mobileqq.wink.editor.sticker.l;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.ttpic.videoshelf.data.Constants;
import com.tencent.videocut.model.WatermarkDataSourceModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/sticker/WinkApplyStickerMaterialTask;", "", "a", "Companion", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkApplyStickerMaterialTask {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016JF\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000eR\u0014\u0010\u0013\u001a\u00020\u00128\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/sticker/WinkApplyStickerMaterialTask$Companion;", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "Lcom/tencent/mobileqq/wink/editor/WinkEditorFragment;", "fragment", "Lcom/tencent/mobileqq/wink/editor/dr;", "tavCutDelegate", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel;", "winkEditorViewModel", "Lcom/tencent/mobileqq/wink/editor/performance/WinkEditPerformanceViewModel;", "winkEditPerformanceViewModel", "", "code", "", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull MetaMaterial material, @Nullable WinkEditorFragment fragment, @Nullable dr tavCutDelegate, @NotNull Context context, @Nullable WinkEditorViewModel winkEditorViewModel, @Nullable WinkEditPerformanceViewModel winkEditPerformanceViewModel, int code) {
            String str;
            Intrinsics.checkNotNullParameter(material, "material");
            Intrinsics.checkNotNullParameter(context, "context");
            if (tavCutDelegate == null) {
                return;
            }
            if (fragment != null) {
                if (l.B(material)) {
                    if (winkEditorViewModel != null) {
                        winkEditorViewModel.U4(material);
                    }
                    ms.a.a("customPicker", "\u70b9\u51fb\u8d34\u7eb8\uff0cpagFilePath= " + ((Object) material.additionalFields.get(Constants.PAG_FILE_PATH)));
                    com.tencent.mobileqq.wink.picker.g.f324860a.f(context, code, WinkContext.INSTANCE.d().getTraceId());
                } else {
                    List<WatermarkDataSourceModel> j3 = l73.a.f413927a.j(material);
                    if (j3.isEmpty()) {
                        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.d()), null, null, new WinkApplyStickerMaterialTask$Companion$onApplyMaterialLocal$1(tavCutDelegate, fragment, material, winkEditPerformanceViewModel, null), 3, null);
                    } else {
                        WinkApplyStickerMaterialTaskKt.c(context, material, fragment, tavCutDelegate, j3, winkEditPerformanceViewModel);
                    }
                }
            }
            if (winkEditorViewModel != null) {
                str = winkEditorViewModel.getCom.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants.RPORT_KEY_BUSINESS_NAME java.lang.String();
            } else {
                str = null;
            }
            String valueOf = String.valueOf(str);
            if (!TextUtils.isEmpty(valueOf)) {
                y53.e.d().a(valueOf, material.f30533id, new WinkPublishQualityReportData.Builder().eventId("P_MATERIAL_COST_END").ext1(material.f30533id).ext2("video").retCode("0").getReportData());
            }
        }

        Companion() {
        }
    }
}

package f83;

import android.content.Context;
import android.os.Bundle;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.IWinkProfileThemeHelp;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.f;
import com.tencent.mobileqq.wink.sdk.Wink;
import com.tencent.mobileqq.wink.templatelibrary.jump.TemplateJumpImpl;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import cooperation.peak.PeakConstants;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z93.b;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a6\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u001a!\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000f\u001a\"\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u001a\u001e\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u0014"}, d2 = {"Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "", "traceId", "Landroid/os/Bundle;", "bundle", "Lcom/tencent/mobileqq/wink/templatelibrary/jump/TemplateJumpImpl;", "jumpImpl", "Lcom/tencent/mobileqq/wink/templatelibrary/jump/a;", "callback", "", "d", "", "from", "a", "(Landroid/os/Bundle;Ljava/lang/Integer;)V", "Landroid/content/Context;", "context", "b", "c", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {
    private static final void a(Bundle bundle, Integer num) {
        if (WinkContext.INSTANCE.d().u("QZONE")) {
            if (num != null && num.intValue() == 100) {
                bundle.putString(WinkDaTongReportConstant.ElementParamKey.XSJ_QZONE_LIBTEMPLATE_MATERIAL_TYPE, "operation_material");
            } else if (num != null && num.intValue() == 104) {
                bundle.putString(WinkDaTongReportConstant.ElementParamKey.XSJ_QZONE_LIBTEMPLATE_MATERIAL_TYPE, "normal_material");
            }
        }
    }

    public static final void b(@NotNull Context context, @NotNull MetaMaterial material, @Nullable Bundle bundle) {
        HashMap hashMapOf;
        Integer num;
        boolean z16;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(material, "material");
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("target", "0"), TuplesKt.to("meterial", material.f30533id));
        if (bundle != null) {
            num = Integer.valueOf(bundle.getInt("JUMP_FROM_KEY", -1));
        } else {
            num = null;
        }
        if (WinkContext.INSTANCE.d().u("QZONE") && ((num != null && num.intValue() == 100) || (num != null && num.intValue() == 104))) {
            hashMapOf.put("from", QQWinkConstants.QCIRCLE_FROM_QZONE);
        }
        if (bundle != null) {
            a(bundle, num);
        }
        if (bundle != null && bundle.getBoolean(QQWinkConstants.IS_TO_TEMPLATE_TAB)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            bundle.putBoolean(QQWinkConstants.IS_TO_TEMPLATE_TAB, false);
        }
        if (bundle != null) {
            bundle.putBoolean(QQWinkConstants.HOME_SHOW_CAPTURE_TAB, true);
        }
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        bundle2.putSerializable("key_attrs", hashMapOf);
        b e16 = Wink.INSTANCE.e();
        if (e16 != null) {
            e16.jumpToQQWinkHome(context, bundle2);
        }
    }

    public static final void c(@NotNull Context context, @NotNull String traceId, @NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        f.o(context, traceId, bundle);
    }

    public static final void d(@NotNull MetaMaterial material, @NotNull String traceId, @Nullable Bundle bundle, @Nullable TemplateJumpImpl templateJumpImpl, @Nullable com.tencent.mobileqq.wink.templatelibrary.jump.a aVar) {
        Integer num;
        Intrinsics.checkNotNullParameter(material, "material");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Bundle bundle2 = new Bundle();
        bundle2.putString(PeakConstants.QCIRCLE_CLIENT_TRACEID, traceId);
        if (WinkContext.INSTANCE.d().u("QCIRCLE")) {
            ((IWinkProfileThemeHelp) QRoute.api(IWinkProfileThemeHelp.class)).addUseProfileThemeFlag(bundle2);
        }
        if (bundle != null) {
            num = Integer.valueOf(bundle.getInt("JUMP_FROM_KEY", -1));
        } else {
            num = null;
        }
        a(bundle2, num);
        if (templateJumpImpl != null) {
            templateJumpImpl.m(material, aVar, bundle2);
        }
    }
}

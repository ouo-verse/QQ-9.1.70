package ca3;

import android.content.Intent;
import com.tencent.mobileqq.wink.api.QQWinkTempConstants;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lca3/d;", "Lz93/d;", "Landroid/content/Intent;", "intent", "", "", "", "a", "b", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class d implements z93.d {
    @Override // z93.d
    @NotNull
    public Map<String, Object> a(@NotNull Intent intent) {
        boolean z16;
        Intrinsics.checkNotNullParameter(intent, "intent");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String stringExtra = intent.getStringExtra(QQWinkTempConstants.FROM_MAGIC_STUDIO);
        if (stringExtra == null) {
            stringExtra = "";
        }
        if (stringExtra.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            linkedHashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_MAGIC_DRAW, "1");
        } else {
            linkedHashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_MAGIC_DRAW, "0");
        }
        if (intent.getBooleanExtra("aigc_img_mode", false)) {
            linkedHashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_FROM, QCircleDaTongConstant.ElementParamValue.XSJ_AIGC_PICTURE_TAB);
        } else {
            linkedHashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_FROM, QCircleDaTongConstant.ElementParamValue.XSJ_AIGC_CHARACTER_TAB);
        }
        return linkedHashMap;
    }

    @Override // z93.d
    @NotNull
    public Map<String, Object> b(@NotNull Intent intent) {
        Map<String, Object> emptyMap;
        Intrinsics.checkNotNullParameter(intent, "intent");
        emptyMap = MapsKt__MapsKt.emptyMap();
        return emptyMap;
    }
}

package f13;

import com.tencent.mobileqq.vas.VasNtToggle;
import com.tencent.mobileqq.vas.toggle.UnitedProxy;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\t\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lf13/a;", "", "", "b", "", "timeStr", "", "currentTimeMillis", "a", "Z", "c", "()Z", "isInterceptFrequency", "<init>", "()V", "vas_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f397699a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final boolean isInterceptFrequency;

    static {
        a aVar = new a();
        f397699a = aVar;
        isInterceptFrequency = aVar.b();
    }

    a() {
    }

    private final boolean a(String timeStr, long currentTimeMillis) {
        List split$default;
        boolean z16;
        try {
            split$default = StringsKt__StringsKt.split$default((CharSequence) timeStr, new String[]{"-"}, false, 0, 6, (Object) null);
            if (split$default.size() == 2) {
                long parseLong = Long.parseLong((String) split$default.get(0));
                long parseLong2 = Long.parseLong((String) split$default.get(1));
                if (parseLong + 1 <= currentTimeMillis && currentTimeMillis < parseLong2) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    QLog.i("FrequencyIntercept", 1, "intercept frequency time: " + currentTimeMillis + "  config: " + timeStr);
                    return true;
                }
            }
        } catch (NumberFormatException e16) {
            QLog.e("FrequencyIntercept", 1, "checkNeedIntercept: " + e16.getMessage());
        }
        return false;
    }

    private final boolean b() {
        JSONArray optJSONArray;
        try {
            UnitedProxy unitedProxy = VasNtToggle.VAS_PROTECT_HOLIDAYS_FESTIVALS_FREQUENCY_CONTROL;
            if (unitedProxy.isEnable(false) && (optJSONArray = unitedProxy.getJson().optJSONArray("time")) != null && optJSONArray.length() > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    String timeStr = optJSONArray.optString(i3);
                    Intrinsics.checkNotNullExpressionValue(timeStr, "timeStr");
                    if (a(timeStr, currentTimeMillis)) {
                        return true;
                    }
                }
            }
        } catch (JSONException e16) {
            QLog.e("FrequencyIntercept", 1, "isInterceptFrequency: " + e16.getMessage());
        }
        return false;
    }

    public final boolean c() {
        return isInterceptFrequency;
    }
}

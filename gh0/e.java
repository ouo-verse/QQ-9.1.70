package gh0;

import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u001c\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\b\u00a8\u0006\f"}, d2 = {"Lgh0/e;", "", "", "phoneNum", "", "a", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "Ljava/util/regex/Pattern;", "mobilePhoneNumPattern", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class e {

    /* renamed from: b, reason: collision with root package name */
    public static final e f402043b = new e();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Pattern mobilePhoneNumPattern = Pattern.compile("^1[3456789]\\d{9}$");

    e() {
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x000f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(String phoneNum) {
        boolean z16;
        boolean isBlank;
        if (phoneNum != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(phoneNum);
            if (!isBlank) {
                z16 = false;
                if (z16) {
                    return mobilePhoneNumPattern.matcher(phoneNum).matches();
                }
                return false;
            }
        }
        z16 = true;
        if (z16) {
        }
    }
}

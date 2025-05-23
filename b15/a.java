package b15;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.util.Log;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J&\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lb15/a;", "", "", "b", "", "Landroid/content/Context;", "context", "packageName", "Lkotlin/Pair;", "a", "", "[C", "HEX_DIGITS", "<init>", "()V", "qwallet-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes28.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f27745a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F'};

    a() {
    }

    private final String b(byte[] b16) {
        StringBuilder sb5 = new StringBuilder(b16.length * 2);
        for (byte b17 : b16) {
            char[] cArr = HEX_DIGITS;
            sb5.append(cArr[(b17 & 240) >>> 4]);
            sb5.append(cArr[b17 & RegisterType.DOUBLE_HI]);
            sb5.append(':');
        }
        if (sb5.length() > 0) {
            String substring = sb5.substring(0, sb5.length() - 1);
            Intrinsics.checkNotNullExpressionValue(substring, "{\n            // \u53bb\u6389\u672b\u5c3e':'\u2026 sb.length - 1)\n        }");
            return substring;
        }
        return "";
    }

    @Nullable
    public final Pair<String, String> a(@NotNull Context context, @Nullable String packageName) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (packageName == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), packageName, 64);
            Intrinsics.checkNotNullExpressionValue(packageInfo, "context.packageManager.g\u2026_SIGNATURES\n            )");
            String str = packageInfo.versionName;
            Signature[] signatureArr = packageInfo.signatures;
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            messageDigest.reset();
            messageDigest.update(signatureArr[0].toByteArray());
            byte[] dataHash = messageDigest.digest();
            Intrinsics.checkNotNullExpressionValue(dataHash, "dataHash");
            return new Pair<>(str, b(dataHash));
        } catch (Exception unused) {
            Log.e("ApkUtils", "error msg in qqpay-impl module: ");
            return null;
        }
    }
}

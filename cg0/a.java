package cg0;

import com.qzone.preview.service.base.PictureConst;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.logger.api.IECLog;
import com.tencent.ecommerce.base.report.api.IECDataReport;
import com.tencent.ecommerce.base.report.service.b;
import com.vivo.push.PushClientConstants;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0007J \u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0007J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0007J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0007J,\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002R\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcg0/a;", "", "", "c", "", "tag", "methodName", "msg", "", "a", "f", "b", PushClientConstants.TAG_CLASS_NAME, "d", "e", "Lcom/tencent/ecommerce/base/logger/api/IECLog;", "Lcom/tencent/ecommerce/base/logger/api/IECLog;", "logger", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes39.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final a f30786b = new a();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final IECLog logger = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getLogger();

    a() {
    }

    @JvmStatic
    public static final void a(String tag, String methodName, String msg2) {
        logger.logError(tag, msg2);
        a aVar = f30786b;
        String e16 = aVar.e(tag);
        aVar.d(e16, msg2, e16, methodName);
    }

    @JvmStatic
    public static final void b(String tag, String msg2) {
        logger.logInfo(tag, msg2);
    }

    @JvmStatic
    public static final boolean c() {
        return logger.isColorLevel();
    }

    private final void d(String tag, String msg2, String className, String methodName) {
        b bVar = b.f100913b;
        Pair[] pairArr = new Pair[5];
        pairArr[0] = TuplesKt.to("error_tag", tag);
        if (msg2 == null) {
            msg2 = "";
        }
        pairArr[1] = TuplesKt.to("error_msg", msg2);
        pairArr[2] = TuplesKt.to(PictureConst.KEY_CLASSNAME, className);
        pairArr[3] = TuplesKt.to("line_num", "0");
        pairArr[4] = TuplesKt.to("method", methodName);
        IECDataReport.a.a(bVar, "ec_quality_error_log", MapsKt.mapOf(pairArr), false, 4, null);
    }

    private final String e(String tag) {
        String substring;
        try {
            if (StringsKt.contains$default((CharSequence) tag, (CharSequence) "[", false, 2, (Object) null)) {
                int indexOf$default = StringsKt.indexOf$default((CharSequence) tag, "[", 0, false, 6, (Object) null);
                if (tag != null) {
                    substring = tag.substring(0, indexOf$default);
                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
            } else {
                if (!StringsKt.contains$default((CharSequence) tag, (CharSequence) "_", false, 2, (Object) null)) {
                    return tag;
                }
                int indexOf$default2 = StringsKt.indexOf$default((CharSequence) tag, "_", 0, false, 6, (Object) null);
                if (tag != null) {
                    substring = tag.substring(0, indexOf$default2);
                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
            }
            return substring;
        } catch (Exception unused) {
            return tag;
        }
    }

    @JvmStatic
    public static final void f(String tag, String msg2) {
        logger.logWarn(tag, msg2);
    }
}

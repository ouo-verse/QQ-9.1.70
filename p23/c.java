package p23;

import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.ReportInfo;
import com.tencent.mobileqq.vas.quickupdate.ThemeUpdateBusiness;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002JY\u0010\u0011\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012R0\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00140\u0013j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0014`\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lp23/c;", "", "", "scid", "", "e", "Lcom/tencent/mobileqq/vas/VasCommonReportProxy;", "proxy", "", "errCode", "httpCode", "errMsg", "", "isSupportNewScid", "isSample", "Lcom/tencent/mobileqq/vas/quickupdate/ThemeUpdateBusiness;", "business", "c", "(Lcom/tencent/mobileqq/vas/VasCommonReportProxy;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;ZZLcom/tencent/mobileqq/vas/quickupdate/ThemeUpdateBusiness;)V", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "map", "<init>", "()V", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f424977a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, Long> map = new HashMap<>();

    c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(String str, ReportInfo reportInfo, Integer num, String str2, boolean z16, Integer num2, boolean z17, ThemeUpdateBusiness business) {
        long j3;
        long uptimeMillis;
        long j16;
        String str3;
        int i3;
        Intrinsics.checkNotNullParameter(business, "$business");
        HashMap<String, Long> hashMap = map;
        synchronized (hashMap) {
            Long l3 = (Long) TypeIntrinsics.asMutableMap(hashMap).remove(str);
            if (l3 != null) {
                j3 = l3.longValue();
            } else {
                j3 = 0;
            }
            long j17 = -1;
            if (j3 == 0) {
                uptimeMillis = -1;
            } else {
                uptimeMillis = SystemClock.uptimeMillis() - j3;
            }
            if (reportInfo != null) {
                ReportInfo value1 = reportInfo.setValue1(str);
                if (num != null) {
                    j16 = num.intValue();
                } else {
                    j16 = -1;
                }
                ReportInfo num1 = value1.setNum1(j16);
                if (num2 != null) {
                    j17 = num2.intValue();
                }
                ReportInfo num3 = num1.setNum2(j17).setNum3(uptimeMillis);
                if (str2 == null) {
                    str3 = "";
                } else {
                    str3 = str2;
                }
                ReportInfo value2 = num3.setValue2(str3);
                if (z17) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append(i3);
                ReportInfo value3 = value2.setValue3(sb5.toString());
                long downloadFileSize = business.getDownloadFileSize(str);
                StringBuilder sb6 = new StringBuilder();
                sb6.append(downloadFileSize);
                value3.setValue4(sb6.toString()).report(z16);
            }
            QLog.i("BusinessReportHelper", 1, "endTime: " + str + " " + num + ", " + str2 + ", " + z16 + " " + uptimeMillis);
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(String scid) {
        Intrinsics.checkNotNullParameter(scid, "$scid");
        HashMap<String, Long> hashMap = map;
        synchronized (hashMap) {
            long uptimeMillis = SystemClock.uptimeMillis();
            if (hashMap.get(scid) != null) {
                return;
            }
            hashMap.put(scid, Long.valueOf(uptimeMillis));
            QLog.i("BusinessReportHelper", 1, "setTime: " + scid + " " + uptimeMillis);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void c(@Nullable final ReportInfo proxy, @Nullable final String scid, @Nullable final Integer errCode, @Nullable final Integer httpCode, @Nullable final String errMsg, final boolean isSupportNewScid, final boolean isSample, @NotNull final ThemeUpdateBusiness business) {
        Intrinsics.checkNotNullParameter(business, "business");
        ThreadManagerV2.excute(new Runnable() { // from class: p23.b
            @Override // java.lang.Runnable
            public final void run() {
                c.d(scid, proxy, errCode, errMsg, isSample, httpCode, isSupportNewScid, business);
            }
        }, 16, null, false);
    }

    public final void e(@NotNull final String scid) {
        Intrinsics.checkNotNullParameter(scid, "scid");
        ThreadManagerV2.excute(new Runnable() { // from class: p23.a
            @Override // java.lang.Runnable
            public final void run() {
                c.f(scid);
            }
        }, 16, null, false);
    }
}

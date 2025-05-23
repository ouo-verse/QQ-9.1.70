package com.tencent.mobileqq.activity.lastclean;

import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/activity/lastclean/a;", "", "", "uin", "", "a", "dayNum", "c", "b", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f183343a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51691);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f183343a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final int a(String uin) {
        Date b16 = LastCleanMMKVHelper.f183341a.b(uin);
        if (b16 == null) {
            return 0;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(b16);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(new Date());
        calendar2.set(11, 0);
        calendar2.set(12, 0);
        calendar2.set(13, 0);
        calendar2.set(14, 0);
        long abs = Math.abs(calendar2.getTime().getTime() - calendar.getTime().getTime());
        long j3 = abs / 86400000;
        QLog.d("LastCleanTextHelper", 1, "daysFromLastCleanTime diffTime: " + abs + ", dayNum: " + j3);
        return (int) j3;
    }

    private final String c(int dayNum) {
        boolean z16;
        boolean z17;
        int i3;
        boolean z18 = true;
        if (93 <= dayNum && dayNum < 186) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            i3 = R.string.f228636u_;
        } else {
            if (186 <= dayNum && dayNum < 372) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                i3 = R.string.f228616u8;
            } else {
                if (372 > dayNum || dayNum > Integer.MAX_VALUE) {
                    z18 = false;
                }
                if (z18) {
                    i3 = R.string.f228626u9;
                } else {
                    i3 = R.string.f228646ua;
                }
            }
        }
        String string = MobileQQ.sMobileQQ.getString(i3);
        Intrinsics.checkNotNullExpressionValue(string, "sMobileQQ.getString(resId)");
        return string;
    }

    @NotNull
    public final String b(@Nullable String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) uin);
        }
        if (TextUtils.isEmpty(uin)) {
            String string = MobileQQ.sMobileQQ.getString(R.string.f228646ua);
            Intrinsics.checkNotNullExpressionValue(string, "sMobileQQ.getString(R.st\u2026orage_clean_time_default)");
            return string;
        }
        Intrinsics.checkNotNull(uin);
        return c(a(uin));
    }
}

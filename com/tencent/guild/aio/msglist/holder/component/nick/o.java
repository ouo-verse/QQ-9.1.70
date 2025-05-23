package com.tencent.guild.aio.msglist.holder.component.nick;

import android.annotation.SuppressLint;
import android.content.Context;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/component/nick/o;", "", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    private static final Calendar f111651b = Calendar.getInstance();

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final ThreadLocal<SimpleDateFormat> f111652c = new ThreadLocal<>();

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static ThreadLocal<SimpleDateFormat> f111653d = new ThreadLocal<>();

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static ThreadLocal<SimpleDateFormat> f111654e = new ThreadLocal<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J8\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0007J\b\u0010\f\u001a\u00020\nH\u0007J\b\u0010\r\u001a\u00020\nH\u0007J\u0016\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010R\u001f\u0010\u0016\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\n0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001cR\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\n0\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001c\u00a8\u0006!"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/component/nick/o$a;", "", "", "lhsYear", "lhsMonth", "lhsDay", "rhsYear", "rhsMonth", "rhsDay", "a", "Ljava/text/SimpleDateFormat;", "d", "e", "c", "Landroid/content/Context;", "context", "", PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, "", "b", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", "stampCal", "Ljava/util/Calendar;", "f", "()Ljava/util/Calendar;", "Ljava/lang/ThreadLocal;", "threadLocalHM", "Ljava/lang/ThreadLocal;", "threadLocalMD", "threadLocalYMD", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.msglist.holder.component.nick.o$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final int a(int lhsYear, int lhsMonth, int lhsDay, int rhsYear, int rhsMonth, int rhsDay) {
            long timeInMillis = (new GregorianCalendar(lhsYear, lhsMonth, lhsDay).getTimeInMillis() - new GregorianCalendar(rhsYear, rhsMonth, rhsDay).getTimeInMillis()) / 1000;
            long j3 = 60;
            return (int) (((timeInMillis / j3) / j3) / 24);
        }

        @NotNull
        public final String b(@NotNull Context context, long timeStamp) {
            Intrinsics.checkNotNullParameter(context, "context");
            f().setTimeInMillis(System.currentTimeMillis());
            int i3 = f().get(1);
            int i16 = f().get(2);
            int i17 = f().get(5);
            f().setTimeInMillis(timeStamp);
            int i18 = f().get(1);
            int a16 = a(i3, i16, i17, i18, f().get(2), f().get(5));
            StringBuilder sb5 = new StringBuilder();
            if (a16 != 0) {
                if (a16 == 1) {
                    sb5.append(context.getString(R.string.f208765dl));
                } else if (i3 == i18) {
                    sb5.append(d().format(new Date(timeStamp)));
                } else {
                    sb5.append(e().format(new Date(timeStamp)));
                }
            }
            if (!StringUtil.isEmpty(sb5.toString())) {
                sb5.append(" ");
            }
            sb5.append(c().format(Long.valueOf(timeStamp)));
            String sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "resTime.toString()");
            return sb6;
        }

        @SuppressLint({"SimpleDateFormat"})
        @NotNull
        public final SimpleDateFormat c() {
            SimpleDateFormat simpleDateFormat = (SimpleDateFormat) o.f111654e.get();
            if (simpleDateFormat == null) {
                SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(DateUtil.DATE_FORMAT_HOUR);
                o.f111654e.set(simpleDateFormat2);
                return simpleDateFormat2;
            }
            return simpleDateFormat;
        }

        @SuppressLint({"SimpleDateFormat"})
        @NotNull
        public final SimpleDateFormat d() {
            SimpleDateFormat simpleDateFormat = (SimpleDateFormat) o.f111652c.get();
            if (simpleDateFormat == null) {
                SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("MM-dd");
                o.f111652c.set(simpleDateFormat2);
                return simpleDateFormat2;
            }
            return simpleDateFormat;
        }

        @SuppressLint({"SimpleDateFormat"})
        @NotNull
        public final SimpleDateFormat e() {
            SimpleDateFormat simpleDateFormat = (SimpleDateFormat) o.f111653d.get();
            if (simpleDateFormat == null) {
                SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
                o.f111653d.set(simpleDateFormat2);
                return simpleDateFormat2;
            }
            return simpleDateFormat;
        }

        public final Calendar f() {
            return o.f111651b;
        }

        Companion() {
        }
    }
}

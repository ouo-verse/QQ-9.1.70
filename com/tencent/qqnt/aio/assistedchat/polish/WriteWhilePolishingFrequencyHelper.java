package com.tencent.qqnt.aio.assistedchat.polish;

import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import tl.h;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00072\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u0010\u001a\u00020\tJ\u000e\u0010\u0011\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u0013\u001a\u00020\tR\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001d\u001a\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR#\u0010!\u001a\n \u001e*\u0004\u0018\u00010\u00040\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u001a\u001a\u0004\b\u001f\u0010 R\u001b\u0010%\u001a\u00020\"8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u001a\u001a\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/polish/WriteWhilePolishingFrequencyHelper;", "", "", "d", "", "key", "Lkotlin/Pair;", "e", Element.ELEMENT_NAME_TIMES, "", "l", "b", "Lcom/tencent/qqnt/aio/assistedchat/config/b;", DownloadInfo.spKey_Config, "", "j", "i", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "c", "a", "I", "getChatType", "()I", "chatType", "Ljava/text/SimpleDateFormat;", "Lkotlin/Lazy;", "g", "()Ljava/text/SimpleDateFormat;", "sdf", "kotlin.jvm.PlatformType", h.F, "()Ljava/lang/String;", "todaySimpleDateFormat", "Lcom/tencent/mobileqq/qmmkv/v2/MMKVOptionEntityV2;", "f", "()Lcom/tencent/mobileqq/qmmkv/v2/MMKVOptionEntityV2;", "mmkvEntity", "<init>", "(I)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class WriteWhilePolishingFrequencyHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int chatType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy sdf;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy todaySimpleDateFormat;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mmkvEntity;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/polish/WriteWhilePolishingFrequencyHelper$a;", "", "", "DATE_PATTERN", "Ljava/lang/String;", "KEY_LAST_SHOW_GUIDE_DATE", "KEY_TODAY_AUTOMATIC_POLISHING_TIMES", "KEY_TOTAL_GUIDE_SHOWN_TIMES", "TAG", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.assistedchat.polish.WriteWhilePolishingFrequencyHelper$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59859);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public WriteWhilePolishingFrequencyHelper(int i3) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
            return;
        }
        this.chatType = i3;
        lazy = LazyKt__LazyJVMKt.lazy(WriteWhilePolishingFrequencyHelper$sdf$2.INSTANCE);
        this.sdf = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.qqnt.aio.assistedchat.polish.WriteWhilePolishingFrequencyHelper$todaySimpleDateFormat$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WriteWhilePolishingFrequencyHelper.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                SimpleDateFormat g16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                g16 = WriteWhilePolishingFrequencyHelper.this.g();
                return g16.format(new Date());
            }
        });
        this.todaySimpleDateFormat = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(WriteWhilePolishingFrequencyHelper$mmkvEntity$2.INSTANCE);
        this.mmkvEntity = lazy3;
    }

    private final String b(String key) {
        String str;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        return str + "_" + key + "_" + this.chatType;
    }

    private final int d() {
        return e("today_automatic_polishing_times").getSecond().intValue();
    }

    private final Pair<String, Integer> e(String key) {
        boolean z16;
        int indexOf$default;
        String string = f().getString(b(key), "");
        int i3 = 0;
        if (string != null && string.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) string, "_", 0, false, 6, (Object) null);
            String substring = string.substring(0, indexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            String substring2 = string.substring(indexOf$default + 1);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
            if (Intrinsics.areEqual(h(), substring)) {
                i3 = Integer.parseInt(substring2);
            }
            return new Pair<>(substring, Integer.valueOf(i3));
        }
        return new Pair<>("", 0);
    }

    private final MMKVOptionEntityV2 f() {
        return (MMKVOptionEntityV2) this.mmkvEntity.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SimpleDateFormat g() {
        return (SimpleDateFormat) this.sdf.getValue();
    }

    private final String h() {
        return (String) this.todaySimpleDateFormat.getValue();
    }

    private final void l(String key, int times) {
        f().putString(b(key), h() + "_" + times);
    }

    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            l("today_automatic_polishing_times", d() + 1);
        }
    }

    public final void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        l("last_show_guide_date", e("last_show_guide_date").getSecond().intValue() + 1);
        f().putInt(b("total_guide_shown_times"), f().getInt(b("total_guide_shown_times"), 0) + 1);
    }

    public final boolean j(@NotNull com.tencent.qqnt.aio.assistedchat.config.b config) {
        int e16;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) config)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(config, "config");
        int i3 = f().getInt(b("total_guide_shown_times"), 0);
        Pair<String, Integer> e17 = e("last_show_guide_date");
        String first = e17.getFirst();
        int intValue = e17.getSecond().intValue();
        if (QLog.isDevelopLevel()) {
            QLog.i("WriteWhilePolishingFrequencyHelper", 1, "guideShownTimes=" + i3 + ", todayShowGuideTimes=" + intValue);
        }
        if (intValue >= config.b()) {
            return false;
        }
        if (i3 < config.c() || i3 % config.c() != 0) {
            return true;
        }
        if (i3 / config.c() == 1) {
            e16 = config.d();
        } else {
            e16 = config.e();
        }
        long currentTimeMillis = System.currentTimeMillis();
        Date parse = g().parse(first);
        if (parse != null) {
            j3 = parse.getTime();
        } else {
            j3 = 0;
        }
        long j16 = (currentTimeMillis - j3) / 86400000;
        if (QLog.isDevelopLevel()) {
            QLog.i("WriteWhilePolishingFrequencyHelper", 1, "dayDiff=" + j16 + ", daysInterval=" + e16);
        }
        if (j16 <= e16) {
            return false;
        }
        return true;
    }

    public final void k(@NotNull com.tencent.qqnt.aio.assistedchat.config.b config) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) config);
            return;
        }
        Intrinsics.checkNotNullParameter(config, "config");
        f().putInt(b("total_guide_shown_times"), 0);
        l("last_show_guide_date", config.b());
    }

    public final boolean m(@NotNull com.tencent.qqnt.aio.assistedchat.config.b config) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) config)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(config, "config");
        if (d() < config.a()) {
            return true;
        }
        return false;
    }
}

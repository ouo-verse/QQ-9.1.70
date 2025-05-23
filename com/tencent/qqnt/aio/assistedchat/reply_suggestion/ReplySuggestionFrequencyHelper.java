package com.tencent.qqnt.aio.assistedchat.reply_suggestion;

import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.assistedchat.config.d;
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
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u0001:\u0001\u0013B\u001f\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0018\u00a2\u0006\u0004\b(\u0010)J\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u000f\u001a\u00020\bJ\u0006\u0010\u0010\u001a\u00020\bJ\u0006\u0010\u0011\u001a\u00020\bJ\u0006\u0010\u0012\u001a\u00020\rR\u0014\u0010\u0015\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0019R\u001b\u0010\u001f\u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR#\u0010#\u001a\n  *\u0004\u0018\u00010\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b!\u0010\"R\u001b\u0010'\u001a\u00020$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010\u001c\u001a\u0004\b%\u0010&\u00a8\u0006*"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/reply_suggestion/ReplySuggestionFrequencyHelper;", "", "", "key", "Lkotlin/Pair;", "", "e", Element.ELEMENT_NAME_TIMES, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "originKey", "b", "d", "", "c", "k", "l", "j", "i", "a", "I", "chatType", "Ljava/lang/String;", "peerId", "Lcom/tencent/qqnt/aio/assistedchat/config/d;", "Lcom/tencent/qqnt/aio/assistedchat/config/d;", DownloadInfo.spKey_Config, "Ljava/text/SimpleDateFormat;", "Lkotlin/Lazy;", "g", "()Ljava/text/SimpleDateFormat;", "sdf", "kotlin.jvm.PlatformType", h.F, "()Ljava/lang/String;", "todaySimpleDateFormat", "Lcom/tencent/mobileqq/qmmkv/v2/MMKVOptionEntityV2;", "f", "()Lcom/tencent/mobileqq/qmmkv/v2/MMKVOptionEntityV2;", "mmkvEntity", "<init>", "(ILjava/lang/String;Lcom/tencent/qqnt/aio/assistedchat/config/d;)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class ReplySuggestionFrequencyHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int chatType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String peerId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d config;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy sdf;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy todaySimpleDateFormat;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mmkvEntity;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/reply_suggestion/ReplySuggestionFrequencyHelper$a;", "", "", "DATE_PATTERN", "Ljava/lang/String;", "KEY_LAST_SHOW_RS_TAIL_DATE", "KEY_PEER_AI_SERVICE_DISABLE_GRAY_TIP", "KEY_TOTAL_RS_TAIL_SHOWN_TIMES", "TAG", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.assistedchat.reply_suggestion.ReplySuggestionFrequencyHelper$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60060);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ReplySuggestionFrequencyHelper(int i3, @NotNull String peerId, @NotNull d config) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(peerId, "peerId");
        Intrinsics.checkNotNullParameter(config, "config");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), peerId, config);
            return;
        }
        this.chatType = i3;
        this.peerId = peerId;
        this.config = config;
        lazy = LazyKt__LazyJVMKt.lazy(ReplySuggestionFrequencyHelper$sdf$2.INSTANCE);
        this.sdf = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.qqnt.aio.assistedchat.reply_suggestion.ReplySuggestionFrequencyHelper$todaySimpleDateFormat$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ReplySuggestionFrequencyHelper.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                SimpleDateFormat g16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                g16 = ReplySuggestionFrequencyHelper.this.g();
                return g16.format(new Date());
            }
        });
        this.todaySimpleDateFormat = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(ReplySuggestionFrequencyHelper$mmkvEntity$2.INSTANCE);
        this.mmkvEntity = lazy3;
    }

    private final String b(String originKey) {
        return this.chatType + "_" + this.peerId + "_" + originKey;
    }

    private final String d(String originKey) {
        return this.chatType + "_" + originKey;
    }

    private final Pair<String, Integer> e(String key) {
        boolean z16;
        int indexOf$default;
        String string = f().getString(d(key), "", true);
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

    private final void m(String key, int times) {
        f().putString(d(key), h() + "_" + times, true);
    }

    public final boolean c() {
        int d16;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        int i3 = f().getInt(d("total_rs_tail_shown_times"), 0, true);
        Pair<String, Integer> e16 = e("last_show_rs_tail_date");
        String first = e16.getFirst();
        int intValue = e16.getSecond().intValue();
        QLog.i("ReplySuggestionFrequencyHelper", 1, "guideShownTimes=" + i3 + ", todayShowGuideTimes=" + intValue);
        if (intValue >= this.config.a()) {
            return false;
        }
        if (i3 < this.config.b() || i3 % this.config.b() != 0) {
            return true;
        }
        if (i3 / this.config.b() == 1) {
            d16 = this.config.c();
        } else {
            d16 = this.config.d();
        }
        long currentTimeMillis = System.currentTimeMillis();
        Date parse = g().parse(first);
        if (parse != null) {
            j3 = parse.getTime();
        } else {
            j3 = 0;
        }
        long j16 = (currentTimeMillis - j3) / 86400000;
        QLog.i("ReplySuggestionFrequencyHelper", 1, "dayDiff=" + j16 + ", daysInterval=" + d16);
        if (j16 <= d16) {
            return false;
        }
        return true;
    }

    public final boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return f().getBoolean(b("peer_ai_service_disable_gray_tip"), false, true);
    }

    public final void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            f().putBoolean(b("peer_ai_service_disable_gray_tip"), true, true);
        }
    }

    public final void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        m("last_show_rs_tail_date", e("last_show_rs_tail_date").getSecond().intValue() + 1);
        f().putInt(d("total_rs_tail_shown_times"), f().getInt(d("total_rs_tail_shown_times"), 0, true) + 1, true);
    }

    public final void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            f().putInt(d("total_rs_tail_shown_times"), 0, true);
            m("last_show_rs_tail_date", this.config.a());
        }
    }
}

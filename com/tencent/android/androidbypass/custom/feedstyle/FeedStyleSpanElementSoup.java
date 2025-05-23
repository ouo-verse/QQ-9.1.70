package com.tencent.android.androidbypass.custom.feedstyle;

import android.net.Uri;
import android.util.Size;
import com.tencent.guild.api.msg.impl.GuildMsgElementApiImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.tvkplayer.event.TVKEventId;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import com.tenpay.proxy.dlg.location.QbAddrData;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0004B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010\b\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\u000b\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R/\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\fj\u0004\u0018\u0001`\r8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\t\u0010\u000eR\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u00108FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0005\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u001a\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0007R\u0011\u0010\u001c\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u0007\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/android/androidbypass/custom/feedstyle/FeedStyleSpanElementSoup;", "", "", "j", "a", "Lkotlin/Lazy;", h.F, "()Ljava/lang/String;", "title", "b", "c", "description", "Lkotlin/Pair;", "Lcom/tencent/android/androidbypass/custom/feedstyle/AvatarNicknamePair;", "()Lkotlin/Pair;", "avatarNicknamePair", "Landroid/util/Size;", "d", "()Landroid/util/Size;", "imageRequestSize", "Landroid/net/Uri;", "e", "Landroid/net/Uri;", "g", "()Landroid/net/Uri;", "src", "imageUrl", "f", ZPlanPublishSource.FROM_SCHEME, "<init>", "(Landroid/net/Uri;)V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class FeedStyleSpanElementSoup {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private static final Regex f72082f;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy title;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy description;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Lazy avatarNicknamePair;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Lazy imageRequestSize;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Uri src;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/android/androidbypass/custom/feedstyle/FeedStyleSpanElementSoup$a;", "", "Landroid/net/Uri;", "src", "Lcom/tencent/android/androidbypass/custom/feedstyle/FeedStyleSpanElementSoup;", "a", "Lkotlin/text/Regex;", "LINE_FEED_REGEX", "Lkotlin/text/Regex;", "", "PICTURE_DESCRIPTION", "Ljava/lang/String;", "<init>", "()V", "bypass_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.android.androidbypass.custom.feedstyle.FeedStyleSpanElementSoup$a, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this);
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0080, code lost:
        
            if (r5 != false) goto L31;
         */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0086  */
        /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
        @JvmStatic
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final FeedStyleSpanElementSoup a(@NotNull Uri src) {
            boolean z16;
            boolean z17;
            boolean z18;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z19 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (FeedStyleSpanElementSoup) iPatchRedirector.redirect((short) 1, (Object) this, (Object) src);
            }
            Intrinsics.checkNotNullParameter(src, "src");
            String queryParameter = src.getQueryParameter("id");
            if (!Intrinsics.areEqual(src.getQueryParameter("id"), "1")) {
                com.tencent.android.androidbypass.config.a.f72049a.e("FeedStyleSpan", "unsupported template id: " + queryParameter);
                return null;
            }
            FeedStyleSpanElementSoup feedStyleSpanElementSoup = new FeedStyleSpanElementSoup(src);
            if (feedStyleSpanElementSoup.b() != null) {
                if (feedStyleSpanElementSoup.e().length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    if (feedStyleSpanElementSoup.c().length() > 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (!z17) {
                        if (feedStyleSpanElementSoup.h().length() > 0) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                    }
                }
                if (z19) {
                    return null;
                }
                return feedStyleSpanElementSoup;
            }
            z19 = false;
            if (z19) {
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(TVKEventId.PLAYER_STATE_DEBUG_TRACKING_INFO);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
            f72082f = new Regex("[\n\r]");
        }
    }

    public FeedStyleSpanElementSoup(@NotNull Uri src) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Intrinsics.checkNotNullParameter(src, "src");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) src);
            return;
        }
        this.src = src;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<String>() { // from class: com.tencent.android.androidbypass.custom.feedstyle.FeedStyleSpanElementSoup$title$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) FeedStyleSpanElementSoup.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                String str;
                Regex regex;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    return (String) iPatchRedirector2.redirect((short) 1, (Object) this);
                }
                String queryParameter = FeedStyleSpanElementSoup.this.g().getQueryParameter("text1");
                if (queryParameter != null) {
                    regex = FeedStyleSpanElementSoup.f72082f;
                    str = regex.replace(queryParameter, "");
                } else {
                    str = null;
                }
                String str2 = str == null || str.length() == 0 ? null : str;
                if (str2 != null) {
                    return str2;
                }
                if (FeedStyleSpanElementSoup.this.e().length() > 0) {
                    return FeedStyleSpanElementSoup.this.c().length() == 0 ? GuildMsgElementApiImpl.DESC_ELEMENT_PIC : "";
                }
                return "";
            }
        });
        this.title = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<String>() { // from class: com.tencent.android.androidbypass.custom.feedstyle.FeedStyleSpanElementSoup$description$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) FeedStyleSpanElementSoup.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                Regex regex;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    return (String) iPatchRedirector2.redirect((short) 1, (Object) this);
                }
                String queryParameter = FeedStyleSpanElementSoup.this.g().getQueryParameter("text2");
                if (queryParameter == null) {
                    return "";
                }
                regex = FeedStyleSpanElementSoup.f72082f;
                String replace = regex.replace(queryParameter, "");
                return replace != null ? replace : "";
            }
        });
        this.description = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<Pair<? extends String, ? extends String>>() { // from class: com.tencent.android.androidbypass.custom.feedstyle.FeedStyleSpanElementSoup$avatarNicknamePair$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) FeedStyleSpanElementSoup.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Pair<? extends String, ? extends String> invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    return (Pair) iPatchRedirector2.redirect((short) 1, (Object) this);
                }
                String queryParameter = FeedStyleSpanElementSoup.this.g().getQueryParameter("icon3");
                if (queryParameter == null) {
                    queryParameter = "";
                }
                Intrinsics.checkNotNullExpressionValue(queryParameter, "src.getQueryParameter(Te\u2026Constant.TAIL_ICON) ?: \"\"");
                String queryParameter2 = FeedStyleSpanElementSoup.this.g().getQueryParameter("text3");
                String str = queryParameter2 != null ? queryParameter2 : "";
                Intrinsics.checkNotNullExpressionValue(str, "src.getQueryParameter(Te\u2026Constant.TAIL_TEXT) ?: \"\"");
                if (str.length() == 0) {
                    return null;
                }
                return TuplesKt.to(queryParameter, str);
            }
        });
        this.avatarNicknamePair = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<Size>() { // from class: com.tencent.android.androidbypass.custom.feedstyle.FeedStyleSpanElementSoup$imageRequestSize$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) FeedStyleSpanElementSoup.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Size invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    return (Size) iPatchRedirector2.redirect((short) 1, (Object) this);
                }
                String queryParameter = FeedStyleSpanElementSoup.this.g().getQueryParameter("leftImageWidth");
                Integer intOrNull = queryParameter != null ? StringsKt__StringNumberConversionsKt.toIntOrNull(queryParameter) : null;
                String queryParameter2 = FeedStyleSpanElementSoup.this.g().getQueryParameter("leftImageHeight");
                Integer intOrNull2 = queryParameter2 != null ? StringsKt__StringNumberConversionsKt.toIntOrNull(queryParameter2) : null;
                if (intOrNull != null && intOrNull.intValue() > 0 && intOrNull2 != null && intOrNull2.intValue() > 0) {
                    return new Size(intOrNull.intValue(), intOrNull2.intValue());
                }
                com.tencent.android.androidbypass.config.a.f72049a.w("FeedStyleSpan", "illegal image request size:  " + intOrNull + QbAddrData.DATA_SPLITER + intOrNull2);
                return null;
            }
        });
        this.imageRequestSize = lazy4;
    }

    @JvmStatic
    @Nullable
    public static final FeedStyleSpanElementSoup i(@NotNull Uri uri) {
        return INSTANCE.a(uri);
    }

    @Nullable
    public final Pair<String, String> b() {
        Object value;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            value = iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            value = this.avatarNicknamePair.getValue();
        }
        return (Pair) value;
    }

    @NotNull
    public final String c() {
        Object value;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            value = iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            value = this.description.getValue();
        }
        return (String) value;
    }

    @Nullable
    public final Size d() {
        Object value;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            value = iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            value = this.imageRequestSize.getValue();
        }
        return (Size) value;
    }

    @NotNull
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        String queryParameter = this.src.getQueryParameter("leftImageUrl");
        if (queryParameter == null) {
            return "";
        }
        return queryParameter;
    }

    @NotNull
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        String queryParameter = this.src.getQueryParameter(ZPlanPublishSource.FROM_SCHEME);
        if (queryParameter == null) {
            return "";
        }
        return queryParameter;
    }

    @NotNull
    public final Uri g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Uri) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.src;
    }

    @NotNull
    public final String h() {
        Object value;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            value = iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            value = this.title.getValue();
        }
        return (String) value;
    }

    @NotNull
    public final String j() {
        boolean z16;
        boolean z17;
        boolean z18;
        String str;
        boolean z19;
        boolean z26;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        StringBuffer stringBuffer = new StringBuffer();
        boolean z27 = true;
        if (e().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            stringBuffer.append(GuildMsgElementApiImpl.DESC_ELEMENT_PIC);
        }
        if (h().length() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            if (stringBuffer.length() > 0) {
                z26 = true;
            } else {
                z26 = false;
            }
            if (z26) {
                stringBuffer.append(" ");
            }
            stringBuffer.append(h());
        }
        if (c().length() > 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18) {
            stringBuffer.append('\n' + c());
        }
        Pair<String, String> b16 = b();
        String str2 = null;
        if (b16 != null) {
            str = b16.getFirst();
        } else {
            str = null;
        }
        Pair<String, String> b17 = b();
        if (b17 != null) {
            str2 = b17.getSecond();
        }
        if (str != null && str.length() != 0) {
            z19 = false;
        } else {
            z19 = true;
        }
        if (!z19) {
            stringBuffer.append("\n[\u56fe\u7247]");
        }
        if (str2 != null && str2.length() != 0) {
            z27 = false;
        }
        if (!z27) {
            stringBuffer.append(TokenParser.SP + str2 + '\n');
        }
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer2, "stringBuffer.toString()");
        return stringBuffer2;
    }
}

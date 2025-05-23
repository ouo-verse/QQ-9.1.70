package com.tencent.mobileqq.guild.config;

import com.tencent.mobileqq.guild.util.bs;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00042\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0006R\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/config/GuildSearchConfBean;", "", "", "text", "d", "a", "Ljava/lang/String;", "searchRegexPattern", "b", "searchRegexReplacement", "Lkotlin/Lazy;", "Lkotlin/text/Regex;", "c", "Lkotlin/Lazy;", "lazyRegex", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildSearchConfBean {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String searchRegexPattern = "";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String searchRegexReplacement = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Lazy<Regex> lazyRegex;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\n\u001a\u00020\u0002H\u0007R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/config/GuildSearchConfBean$a;", "", "Lcom/tencent/mobileqq/guild/config/GuildSearchConfBean;", "bean", "Lorg/json/JSONObject;", "jsonObj", "", "c", "", "b", "a", "", "KEY_REGEX_PATTERN", "Ljava/lang/String;", "KEY_REGEX_REPLACEMENT", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.config.GuildSearchConfBean$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final GuildSearchConfBean a() {
            return bs.f235483a.h("106061").getGuildSearchBean();
        }

        @JvmStatic
        public final boolean b(@NotNull JSONObject jsonObj) {
            Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
            if (jsonObj.has("guild_search_regex_pattern") && jsonObj.has("guild_search_regex_replacement")) {
                return true;
            }
            return false;
        }

        @JvmStatic
        public final void c(@NotNull GuildSearchConfBean bean, @NotNull JSONObject jsonObj) {
            Intrinsics.checkNotNullParameter(bean, "bean");
            Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
            String optString = jsonObj.optString("guild_search_regex_pattern");
            Intrinsics.checkNotNullExpressionValue(optString, "jsonObj.optString(KEY_REGEX_PATTERN)");
            bean.searchRegexPattern = optString;
            String optString2 = jsonObj.optString("guild_search_regex_replacement");
            Intrinsics.checkNotNullExpressionValue(optString2, "jsonObj.optString(KEY_REGEX_REPLACEMENT)");
            bean.searchRegexReplacement = optString2;
            QLog.i("GuildSearchConfBean", 1, "parseFromJson complete. shareContent = " + jsonObj);
        }

        Companion() {
        }
    }

    public GuildSearchConfBean() {
        Lazy<Regex> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Regex>() { // from class: com.tencent.mobileqq.guild.config.GuildSearchConfBean$lazyRegex$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Regex invoke() {
                String str;
                str = GuildSearchConfBean.this.searchRegexPattern;
                return new Regex(str);
            }
        });
        this.lazyRegex = lazy;
    }

    @NotNull
    public final String d(@NotNull String text) {
        boolean z16;
        Object m476constructorimpl;
        Intrinsics.checkNotNullParameter(text, "text");
        boolean z17 = true;
        if (this.searchRegexPattern.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (this.searchRegexReplacement.length() != 0) {
                z17 = false;
            }
            if (!z17) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl(this.lazyRegex.getValue().replace(text, this.searchRegexReplacement));
                } catch (Throwable th5) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                }
                if (Result.m482isFailureimpl(m476constructorimpl)) {
                    m476constructorimpl = null;
                }
                String str = (String) m476constructorimpl;
                if (str != null) {
                    return str;
                }
                return text;
            }
            return text;
        }
        return text;
    }
}

package com.tencent.mobileqq.guild.config.subconfig.parser;

import com.tencent.freesia.BaseConfigParser;
import com.tencent.freesia.IConfigData;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\b\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\n\u0006B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/config/subconfig/parser/GuildSpeakRuleParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/guild/config/subconfig/parser/GuildSpeakRuleParser$b;", "", "content", "c", "b", "<init>", "()V", "d", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildSpeakRuleParser extends BaseConfigParser<b> {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 \r2\u00020\u0001:\u0001\u0005B\u001b\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/config/subconfig/parser/GuildSpeakRuleParser$b;", "Lcom/tencent/freesia/IConfigData;", "", "d", "Z", "a", "()Z", "showAd", "e", "b", "showBlockWords", "<init>", "(ZZ)V", "f", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements IConfigData {

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean showAd;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean showBlockWords;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/config/subconfig/parser/GuildSpeakRuleParser$b$a;", "", "", "content", "Lcom/tencent/mobileqq/guild/config/subconfig/parser/GuildSpeakRuleParser$b;", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.config.subconfig.parser.GuildSpeakRuleParser$b$a, reason: from kotlin metadata */
        /* loaded from: classes13.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final b a(@Nullable String content) {
                boolean z16;
                boolean z17 = false;
                if (content != null && content.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                DefaultConstructorMarker defaultConstructorMarker = null;
                int i3 = 3;
                if (z16) {
                    return new b(z17, z17, i3, defaultConstructorMarker);
                }
                try {
                    JSONObject jSONObject = new JSONObject(content);
                    return new b(jSONObject.getBoolean("showAd"), jSONObject.getBoolean("showBlockWords"));
                } catch (JSONException e16) {
                    QLog.e("GuildSpeakRuleParser", 1, "error parse GuildSpeakRuleParser content:" + content, e16);
                    return new b(z17, z17, i3, defaultConstructorMarker);
                }
            }

            Companion() {
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b() {
            this(r2, r2, 3, null);
            boolean z16 = false;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getShowAd() {
            return this.showAd;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getShowBlockWords() {
            return this.showBlockWords;
        }

        public b(boolean z16, boolean z17) {
            this.showAd = z16;
            this.showBlockWords = z17;
        }

        public /* synthetic */ b(boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? false : z17);
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b defaultConfig() {
        boolean z16 = false;
        return new b(z16, z16, 3, null);
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NotNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b parse(@NotNull byte[] content) {
        Intrinsics.checkNotNullParameter(content, "content");
        b.Companion companion = b.INSTANCE;
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        return companion.a(new String(content, UTF_8));
    }
}

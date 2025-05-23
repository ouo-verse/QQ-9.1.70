package com.tencent.mobileqq.guild.config.subconfig.parser;

import com.tencent.freesia.BaseConfigParser;
import com.tencent.freesia.IConfigData;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\b\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\n\u0006B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/config/subconfig/parser/GuildShareConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/guild/config/subconfig/parser/GuildShareConfigParser$b;", "", "content", "c", "b", "<init>", "()V", "d", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildShareConfigParser extends BaseConfigParser<b> {

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B!\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/config/subconfig/parser/GuildShareConfigParser$b;", "Lcom/tencent/freesia/IConfigData;", "", "d", "Z", "getEnableShortUrl", "()Z", "enableShortUrl", "", "", "e", "Ljava/util/List;", "getGuildUrlDomain", "()Ljava/util/List;", "guildUrlDomain", "<init>", "(ZLjava/util/List;)V", "f", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements IConfigData {

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean enableShortUrl;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<String> guildUrlDomain;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/config/subconfig/parser/GuildShareConfigParser$b$a;", "", "", "content", "Lcom/tencent/mobileqq/guild/config/subconfig/parser/GuildShareConfigParser$b;", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.config.subconfig.parser.GuildShareConfigParser$b$a, reason: from kotlin metadata */
        /* loaded from: classes13.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX WARN: Multi-variable type inference failed */
            @NotNull
            public final b a(@Nullable String content) {
                byte b16;
                Set set;
                boolean z16 = false;
                if (content != null && content.length() != 0) {
                    b16 = false;
                } else {
                    b16 = true;
                }
                int i3 = 3;
                List list = null;
                byte b17 = 0;
                byte b18 = 0;
                byte b19 = 0;
                if (b16 != false) {
                    return new b(z16, list, i3, b19 == true ? 1 : 0);
                }
                try {
                    JSONObject jSONObject = new JSONObject(content);
                    boolean optBoolean = jSONObject.optBoolean("userShortShareUrl", false);
                    JSONArray optJSONArray = jSONObject.optJSONArray("shortShareUrlDomainList");
                    ArrayList arrayList = new ArrayList();
                    if (optJSONArray != null) {
                        int length = optJSONArray.length();
                        for (int i16 = 0; i16 < length; i16++) {
                            String optString = optJSONArray.optString(i16);
                            Intrinsics.checkNotNullExpressionValue(optString, "itemArrayJson.optString(i)");
                            arrayList.add(optString);
                        }
                    }
                    set = CollectionsKt___CollectionsKt.toSet(arrayList);
                    com.tencent.mobileqq.guild.share.shorturl.a.o(set);
                    if (!arrayList.contains("://pd.qq.com/s")) {
                        arrayList.add("://pd.qq.com/s");
                    }
                    return new b(optBoolean, arrayList);
                } catch (JSONException e16) {
                    QLog.e("GuildShareConfigParser.Config", 1, "error parse GuildShareConfigParser content:" + content, e16);
                    return new b(z16, b18 == true ? 1 : 0, i3, b17 == true ? 1 : 0);
                }
            }

            Companion() {
            }
        }

        public b(boolean z16, @NotNull List<String> guildUrlDomain) {
            Intrinsics.checkNotNullParameter(guildUrlDomain, "guildUrlDomain");
            this.enableShortUrl = z16;
            this.guildUrlDomain = guildUrlDomain;
        }

        public /* synthetic */ b(boolean z16, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? new ArrayList() : list);
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b defaultConfig() {
        return new b(false, null, 3, 0 == true ? 1 : 0);
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

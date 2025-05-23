package com.tencent.mobileqq.guild.feed.feedoption;

import com.tencent.freesia.BaseConfigParser;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000f\u0010B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedoption/GuildFeedOptionConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/guild/feed/feedoption/GuildFeedOptionConfigParser$b;", "c", "", "isAccountRelated", "", "version", "", "onSend", "", "content", "d", "<init>", "()V", "a", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedOptionConfigParser extends BaseConfigParser<b> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final ArrayList<String> f218617e;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedoption/GuildFeedOptionConfigParser$a;", "", "Lcom/tencent/mobileqq/guild/feed/feedoption/GuildFeedOptionConfigParser$b;", "a", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "DEFAULT_FEED_OPTIONS", "Ljava/util/ArrayList;", "ID", "Ljava/lang/String;", "JSON_KEY", "TAG", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.feedoption.GuildFeedOptionConfigParser$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final b a() {
            b bVar = (b) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100308");
            if (bVar == null) {
                return new b();
            }
            return bVar;
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedoption/GuildFeedOptionConfigParser$b;", "Lcom/tencent/freesia/IConfigData;", "", "content", "", "b", "", "a", "d", "Ljava/util/List;", "options", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements IConfigData {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private List<String> options = GuildFeedOptionConfigParser.f218617e;

        @NotNull
        public final List<String> a() {
            return this.options;
        }

        public final void b(@NotNull String content) {
            int i3;
            Object obj;
            Intrinsics.checkNotNullParameter(content, "content");
            QLog.d("GuildFeedOptionConfigParser", 1, "[parse] config: " + content);
            JSONArray optJSONArray = new JSONObject(content).optJSONArray("options");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray != null) {
                i3 = optJSONArray.length();
            } else {
                i3 = 0;
            }
            for (int i16 = 0; i16 < i3; i16++) {
                if (optJSONArray != null) {
                    obj = optJSONArray.get(i16);
                } else {
                    obj = null;
                }
                if (obj instanceof String) {
                    arrayList.add(obj);
                }
            }
            if (arrayList.size() > 0) {
                this.options = arrayList;
            }
        }
    }

    static {
        ArrayList<String> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("\u4e0d\u611f\u5174\u8da3", "\u5185\u5bb9\u8d28\u91cf\u5dee", "\u8272\u60c5\u4f4e\u4fd7");
        f218617e = arrayListOf;
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b defaultConfig() {
        QLog.d("GuildFeedOptionConfigParser", 1, "get defaultConfig");
        return new b();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NotNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public b parse(@NotNull byte[] content) {
        boolean z16;
        Intrinsics.checkNotNullParameter(content, "content");
        b bVar = new b();
        if (content.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            bVar.b(new String(content, UTF_8));
            QLog.d("GuildFeedOptionConfigParser", 1, "[parse] config: " + bVar);
        } else {
            QLog.d("GuildFeedOptionConfigParser", 1, "[parse] empty content");
        }
        return bVar;
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public boolean isAccountRelated() {
        return false;
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onSend(@NotNull String version) {
        Intrinsics.checkNotNullParameter(version, "version");
        QLog.d("GuildFeedOptionConfigParser", 1, "[onSend] version: ", version);
    }
}

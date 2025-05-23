package com.tencent.mobileqq.guild.config;

import android.text.TextUtils;
import com.google.gson.JsonSyntaxException;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\b\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\n\u0006B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/config/GuildCoverConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/guild/config/GuildCoverConfigParser$b;", "", "content", "c", "b", "<init>", "()V", "d", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildCoverConfigParser extends BaseConfigParser<b> {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/config/GuildCoverConfigParser$b;", "Lcom/tencent/freesia/IConfigData;", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/config/GuildCoverInfo;", "Lkotlin/collections/ArrayList;", "e", "<init>", "()V", "d", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements IConfigData {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: e, reason: collision with root package name */
        private static boolean f216049e;

        /* renamed from: f, reason: collision with root package name */
        private static long f216050f;

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0006\u001a\u00020\u0002R\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/config/GuildCoverConfigParser$b$a;", "", "", "content", "Lcom/tencent/mobileqq/guild/config/GuildCoverConfigParser$b;", "d", "configUrl", "", "a", "", "isRequesting", "Z", "c", "()Z", "f", "(Z)V", "", "requestTime", "J", "b", "()J", "e", "(J)V", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.config.GuildCoverConfigParser$b$a, reason: from kotlin metadata */
        /* loaded from: classes13.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final void a(@NotNull String configUrl) {
                Intrinsics.checkNotNullParameter(configUrl, "configUrl");
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime == null) {
                    QLog.d("GuildCoverConfigParser.Config", 1, "download fail, appRuntime null.");
                    return;
                }
                if (c() && System.currentTimeMillis() - b() < 30000) {
                    return;
                }
                f(true);
                e(System.currentTimeMillis());
                String c06 = ch.c0(peekAppRuntime.getApp(), "100556");
                QLog.d("GuildCoverConfigParser.Config", 1, "download localPath " + c06);
                ch.F(peekAppRuntime, configUrl, c06, new C7709a(c06));
            }

            public final long b() {
                return b.f216050f;
            }

            public final boolean c() {
                return b.f216049e;
            }

            @NotNull
            public final b d(@Nullable String content) {
                boolean z16;
                if (content != null && content.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    return new b();
                }
                try {
                    JSONObject jSONObject = new JSONObject(content);
                    if (jSONObject.has("guildCoverConfigDownloadUrl")) {
                        String configUrl = jSONObject.optString("guildCoverConfigDownloadUrl");
                        int optInt = jSONObject.optInt("guildCoverConfigVersion");
                        int guildCoverConfigVersion = ((IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class)).getGuildCoverConfigVersion();
                        QLog.e("GuildCoverConfigParser.Config", 1, "oldVersion " + guildCoverConfigVersion + " version " + optInt + " ");
                        if (guildCoverConfigVersion < optInt) {
                            ((IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class)).setGuildCoverConfigVersion(optInt);
                            ((IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class)).setGuildCoverConfigUrl(configUrl);
                            Intrinsics.checkNotNullExpressionValue(configUrl, "configUrl");
                            a(configUrl);
                        }
                    }
                    return new b();
                } catch (JSONException e16) {
                    QLog.e("GuildCoverConfigParser.Config", 1, "error parse GuildCoverConfigParser content:" + content, e16);
                    return new b();
                }
            }

            public final void e(long j3) {
                b.f216050f = j3;
            }

            public final void f(boolean z16) {
                b.f216049e = z16;
            }

            Companion() {
            }

            @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010\u000b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/config/GuildCoverConfigParser$b$a$a", "Lcom/tencent/mobileqq/transfile/INetEngineListener;", "Lcom/tencent/mobileqq/transfile/NetResp;", "resp", "", "onResp", "Lcom/tencent/mobileqq/transfile/NetReq;", "req", "", "curOffset", "totalLen", "onUpdateProgeress", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
            /* renamed from: com.tencent.mobileqq.guild.config.GuildCoverConfigParser$b$a$a, reason: collision with other inner class name */
            /* loaded from: classes13.dex */
            public static final class C7709a implements INetEngineListener {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f216051d;

                C7709a(String str) {
                    this.f216051d = str;
                }

                @Override // com.tencent.mobileqq.transfile.INetEngineListener
                public void onResp(@Nullable NetResp resp) {
                    boolean z16;
                    Integer num;
                    if (resp != null && resp.mResult == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        String c16 = com.tencent.mobileqq.guild.util.p.c(this.f216051d);
                        QLog.e("GuildCoverConfigParser.Config", 1, "downloadAndSaveCoverList json " + c16);
                        if (c16 != null) {
                            ((IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class)).setGuildCoverInfoList(c16);
                        }
                        CopyOnWriteArrayList<GuildCoverInfo> copyOnWriteArrayList = GuildCoverInfo.F;
                        if (copyOnWriteArrayList != null) {
                            copyOnWriteArrayList.clear();
                            GuildCoverInfo.b();
                        }
                    } else {
                        String str = null;
                        if (resp != null) {
                            num = Integer.valueOf(resp.mErrCode);
                        } else {
                            num = null;
                        }
                        if (resp != null) {
                            str = resp.mErrDesc;
                        }
                        QLog.d("GuildCoverConfigParser.Config", 1, "download fail, errCode " + num + " errDesc " + str);
                        ((IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class)).setGuildCoverInfoList("");
                    }
                    ch.w(this.f216051d);
                    b.INSTANCE.f(false);
                }

                @Override // com.tencent.mobileqq.transfile.INetEngineListener
                public void onUpdateProgeress(@Nullable NetReq req, long curOffset, long totalLen) {
                }
            }
        }

        @NotNull
        public final ArrayList<GuildCoverInfo> e() {
            String guildCoverInfoList = ((IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class)).getGuildCoverInfoList();
            if (TextUtils.isEmpty(guildCoverInfoList)) {
                int guildCoverConfigVersion = ((IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class)).getGuildCoverConfigVersion();
                String configUrl = ((IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class)).getGuildCoverConfigUrl();
                if (guildCoverConfigVersion > 0 && !TextUtils.isEmpty(configUrl)) {
                    Companion companion = INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(configUrl, "configUrl");
                    companion.a(configUrl);
                }
                QLog.d("GuildCoverConfigParser.Config", 1, "getGuildCoverConfigFromJson json == null");
                return new ArrayList<>();
            }
            try {
                JSONObject jSONObject = new JSONObject(guildCoverInfoList);
                ArrayList<GuildCoverInfo> arrayList = new ArrayList<>();
                JSONArray optJSONArray = jSONObject.optJSONArray("guildCoverInfo");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i3 = 0; i3 < length; i3++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                        Intrinsics.checkNotNullExpressionValue(jSONObject2, "it.getJSONObject(i)");
                        if (jSONObject2.has("id")) {
                            arrayList.add(new GuildCoverInfo(jSONObject2.optString("id"), jSONObject2.optString("name"), jSONObject2.optString("nameColor"), jSONObject2.optString("url"), jSONObject2.optString("bgUrl"), jSONObject2.optString("guildBgStartColor"), jSONObject2.optString("guildBgEndColor")));
                        }
                    }
                }
                return arrayList;
            } catch (JsonSyntaxException e16) {
                QLog.d("GuildCoverConfigParser.Config", 1, "JsonSyntaxException " + e16.getMessage());
                return new ArrayList<>();
            } catch (Exception e17) {
                QLog.d("GuildCoverConfigParser.Config", 1, "\u89e3\u6790\u914d\u7f6e\u5931\u8d25 " + e17.getMessage());
                return new ArrayList<>();
            }
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b defaultConfig() {
        return new b();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NotNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b parse(@NotNull byte[] content) {
        Intrinsics.checkNotNullParameter(content, "content");
        b.Companion companion = b.INSTANCE;
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        return companion.d(new String(content, UTF_8));
    }
}

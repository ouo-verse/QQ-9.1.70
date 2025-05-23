package com.tencent.mobileqq.guild.config;

import android.text.TextUtils;
import com.google.gson.JsonSyntaxException;
import com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/config/g;", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\u000f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\nR\u0014\u0010\u0010\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/config/g$a;", "", "Lorg/json/JSONObject;", "jsonObj", "", "c", "Lcom/tencent/mobileqq/guild/config/g;", "bean", "", "d", "", "configUrl", "a", "succeeded", "localPath", "b", "CONFIG_ID", "Ljava/lang/String;", "TAG", "TYPE_LIST_JSON_KEY", "TYPE_LIST_VERSION_KEY", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.config.g$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull String configUrl) {
            Intrinsics.checkNotNullParameter(configUrl, "configUrl");
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                QLog.d("Guild.config.GuildCanGameLiveConfig", 1, "download fail, appRuntime null.");
                return;
            }
            String c06 = ch.c0(peekAppRuntime.getApp(), "100595");
            QLog.d("Guild.config.GuildCanGameLiveConfig", 1, "download localPath " + c06);
            ch.F(peekAppRuntime, configUrl, c06, new C7710a(c06));
        }

        public final void b(boolean succeeded, @NotNull String localPath) {
            Intrinsics.checkNotNullParameter(localPath, "localPath");
            if (succeeded) {
                try {
                    ((IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class)).setGuildOnePlayConfigJson(com.tencent.mobileqq.guild.util.p.c(localPath));
                } catch (JsonSyntaxException e16) {
                    QLog.d("Guild.config.GuildCanGameLiveConfig", 1, "JsonSyntaxException " + e16.getMessage());
                } catch (Exception e17) {
                    QLog.d("Guild.config.GuildCanGameLiveConfig", 1, "\u4e0b\u8f7d\u914d\u7f6e\u5931\u8d25 " + e17.getMessage());
                }
            }
            ch.w(localPath);
        }

        @JvmStatic
        public final boolean c(@NotNull JSONObject jsonObj) {
            Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
            return jsonObj.has("guildOnePlayConfigDownloadUrl");
        }

        @JvmStatic
        public final void d(@NotNull g bean, @NotNull JSONObject jsonObj) {
            Intrinsics.checkNotNullParameter(bean, "bean");
            Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
            QLog.d("Guild.config.GuildCanGameLiveConfig", 1, "[parseFromJson] jsonObj = " + jsonObj);
            String configUrl = jsonObj.optString("guildOnePlayConfigDownloadUrl");
            int optInt = jsonObj.optInt("guildOnePlayConfigVersion");
            if (((IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class)).getGuildOnePlayConfigVersion() >= optInt && !TextUtils.isEmpty(((IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class)).getGuildOnePlayConfigJson())) {
                return;
            }
            ((IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class)).setGuildOnePlayConfigVersion(optInt);
            ((IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class)).setGuildOnePlayConfigUrl(configUrl);
            Companion companion = g.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(configUrl, "configUrl");
            companion.a(configUrl);
        }

        Companion() {
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010\u000b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/config/g$a$a", "Lcom/tencent/mobileqq/transfile/INetEngineListener;", "Lcom/tencent/mobileqq/transfile/NetResp;", "resp", "", "onResp", "Lcom/tencent/mobileqq/transfile/NetReq;", "req", "", "curOffset", "totalLen", "onUpdateProgeress", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.config.g$a$a, reason: collision with other inner class name */
        /* loaded from: classes13.dex */
        public static final class C7710a implements INetEngineListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f216135d;

            C7710a(String str) {
                this.f216135d = str;
            }

            @Override // com.tencent.mobileqq.transfile.INetEngineListener
            public void onResp(@Nullable NetResp resp) {
                boolean z16;
                if (resp != null && resp.mResult == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                Companion companion = g.INSTANCE;
                String localPath = this.f216135d;
                Intrinsics.checkNotNullExpressionValue(localPath, "localPath");
                companion.b(z16, localPath);
            }

            @Override // com.tencent.mobileqq.transfile.INetEngineListener
            public void onUpdateProgeress(@Nullable NetReq req, long curOffset, long totalLen) {
            }
        }
    }

    @NotNull
    public final ArrayList<String> a() {
        ArrayList<String> arrayList = new ArrayList<>();
        if (TextUtils.isEmpty(((IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class)).getGuildOnePlayConfigJson())) {
            String url = ((IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class)).getGuildOnePlayConfigUrl();
            if (!TextUtils.isEmpty(url)) {
                Companion companion = INSTANCE;
                Intrinsics.checkNotNullExpressionValue(url, "url");
                companion.a(url);
            }
            return arrayList;
        }
        JSONArray optJSONArray = new JSONObject(((IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class)).getGuildOnePlayConfigJson()).optJSONArray("canGameLiveGuild");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            arrayList.clear();
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                arrayList.add(optJSONArray.optString(i3));
            }
            return arrayList;
        }
        QLog.d("Guild.config.GuildCanGameLiveConfig", 1, "\u914d\u7f6ecanGameLiveGuild\u4e3a\u7a7a");
        return arrayList;
    }
}

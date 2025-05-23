package com.tencent.mobileqq.search.config;

import ap2.g;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.tools.config.ITVKConfigRequester;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/search/config/SearchAudioAIConfigParser;", "Lcom/tencent/freesia/BaseConfigParser;", "Lap2/b;", "b", "", "content", "c", "<init>", "()V", "d", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SearchAudioAIConfigParser extends BaseConfigParser<ap2.b> {
    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ap2.b defaultConfig() {
        return new ap2.b();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NotNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public ap2.b parse(@NotNull byte[] content) {
        boolean z16;
        Intrinsics.checkNotNullParameter(content, "content");
        ap2.b bVar = new ap2.b();
        try {
            if (content.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                Charset UTF_8 = StandardCharsets.UTF_8;
                Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                String str = new String(content, UTF_8);
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    bVar.p(jSONObject.optInt("canUseAudioSearch", 0));
                    String optString = jSONObject.optString("audioPanelTips");
                    Intrinsics.checkNotNullExpressionValue(optString, "optString(\"audioPanelTips\")");
                    bVar.o(optString);
                    bVar.v(jSONObject.optInt("searchDelayTimeMills"));
                    bVar.u(jSONObject.optInt("panelCloseTimeoutMillis"));
                    String optString2 = jSONObject.optString("AIModeTitle");
                    Intrinsics.checkNotNullExpressionValue(optString2, "optString(\"AIModeTitle\")");
                    bVar.n(optString2);
                    String optString3 = jSONObject.optString("loadingText");
                    Intrinsics.checkNotNullExpressionValue(optString3, "optString(\"loadingText\")");
                    bVar.t(optString3);
                    String optString4 = jSONObject.optString("emptyText");
                    Intrinsics.checkNotNullExpressionValue(optString4, "optString(\"emptyText\")");
                    bVar.q(optString4);
                    bVar.r(jSONObject.optBoolean("expandAICard", false));
                    String optString5 = jSONObject.optString("voiceExpName", "");
                    Intrinsics.checkNotNullExpressionValue(optString5, "optString(\"voiceExpName\", \"\")");
                    bVar.w(optString5);
                    bVar.s(jSONObject.optBoolean("forbiddenAICard", false));
                    JSONObject thirdAppConfigJson = jSONObject.optJSONObject("thirdAppConfig");
                    if (thirdAppConfigJson != null) {
                        Intrinsics.checkNotNullExpressionValue(thirdAppConfigJson, "thirdAppConfigJson");
                        bVar.getThirdAppConfig().l(thirdAppConfigJson.optBoolean("enable", false));
                        g thirdAppConfig = bVar.getThirdAppConfig();
                        String optString6 = thirdAppConfigJson.optString("text", "");
                        Intrinsics.checkNotNullExpressionValue(optString6, "it.optString(\"text\", \"\")");
                        thirdAppConfig.o(optString6);
                        g thirdAppConfig2 = bVar.getThirdAppConfig();
                        String optString7 = thirdAppConfigJson.optString("url", "");
                        Intrinsics.checkNotNullExpressionValue(optString7, "it.optString(\"url\", \"\")");
                        thirdAppConfig2.q(optString7);
                        bVar.getThirdAppConfig().k(thirdAppConfigJson.optBoolean("checkAppInstalled", false));
                        g thirdAppConfig3 = bVar.getThirdAppConfig();
                        String optString8 = thirdAppConfigJson.optString(DKEngine.GlobalKey.APP_PACKAGE_NAME, "");
                        Intrinsics.checkNotNullExpressionValue(optString8, "it.optString(\"appPackageName\", \"\")");
                        thirdAppConfig3.j(optString8);
                        bVar.getThirdAppConfig().n(thirdAppConfigJson.optInt("maxDisplayCount", -1));
                        g thirdAppConfig4 = bVar.getThirdAppConfig();
                        String optString9 = thirdAppConfigJson.optString("thirdAppUUID", "");
                        Intrinsics.checkNotNullExpressionValue(optString9, "it.optString(\"thirdAppUUID\", \"\")");
                        thirdAppConfig4.p(optString9);
                        g thirdAppConfig5 = bVar.getThirdAppConfig();
                        String optString10 = thirdAppConfigJson.optString(ITVKConfigRequester.ConfigRequestListener.EXTRA_KEY_EXP_NAME, "");
                        Intrinsics.checkNotNullExpressionValue(optString10, "it.optString(\"expName\", \"\")");
                        thirdAppConfig5.m(optString10);
                    }
                    bVar.m(jSONObject.optBoolean("aiCardMoreBtnCheckAppInstalled", false));
                    Logger.f235387a.d().i("SearchAudioAIConfigParser", 1, "parse, configString=" + str + ", config=" + bVar + ", config.hash=" + bVar.hashCode());
                } catch (JSONException e16) {
                    QLog.e("SearchAudioAIConfigParser", 1, e16, new Object[0]);
                    return bVar;
                }
            } else {
                Logger.f235387a.d().w("SearchAudioAIConfigParser", 1, "parse, configString is empty");
            }
        } catch (Exception e17) {
            Logger logger = Logger.f235387a;
            Logger.b bVar2 = new Logger.b();
            String str2 = "parse, Exception=" + e17;
            if (str2 instanceof String) {
                bVar2.a().add(str2);
            }
            Iterator<T> it = bVar2.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("SearchAudioAIConfigParser", 1, (String) it.next(), null);
            }
        }
        return bVar;
    }
}

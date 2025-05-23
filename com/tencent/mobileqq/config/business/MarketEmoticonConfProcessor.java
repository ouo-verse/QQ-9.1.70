package com.tencent.mobileqq.config.business;

import com.tencent.freesia.BaseConfigParser;
import com.tencent.mobileqq.config.business.w;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.raft.codegenmeta.utils.Constants;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000f\u0003B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0014J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/config/business/MarketEmoticonConfProcessor;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/config/business/w;", "b", "", "content", "d", DownloadInfo.spKey_Config, "", "c", "", "success", "onCdnDownload", "<init>", "()V", "a", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class MarketEmoticonConfProcessor extends BaseConfigParser<w> {

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/config/business/MarketEmoticonConfProcessor$b;", "Lcom/tencent/mobileqq/config/business/w;", "Lorg/json/JSONArray;", Constants.Configs.CONFIGS, "", "e", "", "content", "d", "<init>", "()V", "f", "a", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b extends w {
        private final void e(JSONArray configs) {
            if (configs == null) {
                QLog.w("MarketEmoticonConf", 1, "'configs is null, return");
                return;
            }
            int length = configs.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObject = configs.getJSONObject(i3);
                String string = jSONObject.getString("name");
                String string2 = jSONObject.getString("jumpURL");
                JSONArray jSONArray = jSONObject.getJSONArray("emotions");
                int length2 = jSONArray.length();
                for (int i16 = 0; i16 < length2; i16++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i16);
                    String epid = jSONObject2.getString("epid");
                    String eid = jSONObject2.getString("eid");
                    HashMap<w.MarketEmoticonId, w.b> c16 = c();
                    Intrinsics.checkNotNullExpressionValue(epid, "epid");
                    Intrinsics.checkNotNullExpressionValue(eid, "eid");
                    c16.put(new w.MarketEmoticonId(epid, eid), new w.b(string2, string));
                }
            }
        }

        public final void d(@NotNull String content) {
            Intrinsics.checkNotNullParameter(content, "content");
            try {
                e(new JSONArray(content));
            } catch (JSONException e16) {
                QLog.w("MarketEmoticonConf", 1, "", e16);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/config/business/MarketEmoticonConfProcessor$c", "Lpy2/a;", "Lcom/tencent/mobileqq/config/business/w;", DownloadInfo.spKey_Config, "", "b", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class c implements py2.a<w> {
        c() {
        }

        @Override // py2.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@Nullable w config) {
            if (config != null) {
                x.f202849a.c(config);
            }
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public w defaultConfig() {
        return new w();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(@Nullable w config) {
        super.doOnConfigUpdate(config);
        if (QLog.isColorLevel()) {
            QLog.d("MarketEmoticonConf", 2, "doOnConfigUpdate");
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NotNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public w parse(@NotNull byte[] content) {
        Intrinsics.checkNotNullParameter(content, "content");
        b bVar = new b();
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        String str = new String(content, UTF_8);
        if (QLog.isColorLevel()) {
            QLog.d("MarketEmoticonConf", 2, "config " + str);
        }
        bVar.d(str);
        return bVar;
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    public void onCdnDownload(boolean success) {
        super.onCdnDownload(success);
        ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadLargeConfigAsync("101009", new c());
    }
}

package com.tencent.mobileqq.settings.business;

import android.net.Uri;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/settings/business/GrowthPushSwitchParse;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/settings/business/e;", "b", "", "content", "d", DownloadInfo.spKey_Config, "", "c", "<init>", "()V", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class GrowthPushSwitchParse extends BaseConfigParser<e> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0002R\u0014\u0010\f\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/settings/business/GrowthPushSwitchParse$a;", "", "Lorg/json/JSONObject;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/settings/business/f;", "d", "", "url", "", "c", "iconUrl", "b", "TAG", "Ljava/lang/String;", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.settings.business.GrowthPushSwitchParse$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final String b(String iconUrl) {
            if ((iconUrl.length() == 0) || c(iconUrl)) {
                return iconUrl;
            }
            QLog.w("GrowthPushSwitch.Parse", 1, "[getIconUrl] invalid iconUrl, iconUrl=" + iconUrl);
            return "";
        }

        Companion() {
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0027 A[Catch: Exception -> 0x003c, TryCatch #0 {Exception -> 0x003c, blocks: (B:10:0x0011, B:12:0x001b, B:17:0x0027, B:19:0x002d), top: B:9:0x0011 }] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x003a A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final boolean c(String url) {
            boolean z16;
            boolean z17;
            if (url == null || url.length() == 0) {
                return false;
            }
            try {
                Uri parse = Uri.parse(url);
                String scheme = parse.getScheme();
                if (scheme != null && scheme.length() != 0) {
                    z16 = false;
                    if (!z16) {
                        String host = parse.getHost();
                        if (host != null) {
                            if (host.length() != 0) {
                                z17 = false;
                                if (z17) {
                                    return true;
                                }
                            }
                        }
                        z17 = true;
                        if (z17) {
                        }
                    }
                    return false;
                }
                z16 = true;
                if (!z16) {
                }
                return false;
            } catch (Exception e16) {
                QLog.w("GrowthPushSwitch.Parse", 1, "[isValidUrl] invalid url, url=" + url, e16);
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final f d(JSONObject item) {
            if (item == null) {
                return null;
            }
            try {
                String text = item.getString("text");
                String sceneId = item.optString(WadlProxyConsts.SCENE_ID, "");
                String optString = item.optString("iconUrl", "");
                Intrinsics.checkNotNullExpressionValue(optString, "item.optString(\"iconUrl\", \"\")");
                String b16 = b(optString);
                String iconToken = item.optString("imgToken", "");
                String jumpUrl = item.getString(WadlProxyConsts.KEY_JUMP_URL);
                Intrinsics.checkNotNullExpressionValue(sceneId, "sceneId");
                if (!(sceneId.length() == 0)) {
                    Intrinsics.checkNotNullExpressionValue(text, "text");
                    if (!(text.length() == 0) && c(jumpUrl)) {
                        Intrinsics.checkNotNullExpressionValue(iconToken, "iconToken");
                        Intrinsics.checkNotNullExpressionValue(jumpUrl, "jumpUrl");
                        return new f(sceneId, text, iconToken, b16, jumpUrl, false, 32, null);
                    }
                }
                QLog.w("GrowthPushSwitch.Parse", 1, "[parse] invalid config, id=" + sceneId + " text=" + text + " jumpUrl=" + jumpUrl);
                return null;
            } catch (Exception e16) {
                QLog.w("GrowthPushSwitch.Parse", 1, "[parseItem] error: " + e16);
                return null;
            }
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e defaultConfig() {
        List emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return new e("", emptyList);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void doOnConfigUpdate(e config) {
        super.doOnConfigUpdate(config);
        QLog.i("GrowthPushSwitch.Parse", 1, "[doOnConfigUpdate] config=" + config);
    }

    @Override // com.tencent.freesia.BaseConfigParser
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public e parse(byte[] content) {
        Intrinsics.checkNotNullParameter(content, "content");
        ArrayList arrayList = new ArrayList();
        try {
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            JSONObject jSONObject = new JSONObject(new String(content, UTF_8));
            String title = jSONObject.optString("title", "");
            JSONArray optJSONArray = jSONObject.optJSONArray("items");
            if (optJSONArray == null) {
                QLog.w("GrowthPushSwitch.Parse", 1, "[parse] invalid config, 'items' not found");
                return defaultConfig();
            }
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                f d16 = INSTANCE.d(optJSONArray.optJSONObject(i3));
                if (d16 != null) {
                    arrayList.add(d16);
                }
            }
            Intrinsics.checkNotNullExpressionValue(title, "title");
            return new e(title, arrayList);
        } catch (Exception e16) {
            QLog.w("GrowthPushSwitch.Parse", 1, "[parse] error", e16);
            return defaultConfig();
        }
    }
}

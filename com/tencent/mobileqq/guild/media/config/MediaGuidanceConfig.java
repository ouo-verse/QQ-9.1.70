package com.tencent.mobileqq.guild.media.config;

import androidx.fragment.app.a;
import com.tencent.freesia.BaseConfigParser;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.bandwidth.SPBufferRangeController;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\b\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\n\u0006\u0005\tB\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/media/config/MediaGuidanceConfig;", "Lcom/tencent/freesia/BaseConfigParser;", "Lcom/tencent/mobileqq/guild/media/config/MediaGuidanceConfig$b;", "", "content", "c", "b", "<init>", "()V", "d", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MediaGuidanceConfig extends BaseConfigParser<b> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0006R\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0006R\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0006R\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0006R\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0006R\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0006R\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0006R\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0006R\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0006R\u0014\u0010\u0016\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0006R\u0014\u0010\u0017\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0006\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/media/config/MediaGuidanceConfig$a;", "", "Lcom/tencent/mobileqq/guild/media/config/MediaGuidanceConfig$b;", "a", "", "ACTIVE_TIPS", "Ljava/lang/String;", "BTN_MSG", "DATA_VERSION", "EFFECTIVE_CONDITION", "EFFECTIVE_TIME", "ICON_URL", "ID", "INVITE_OPEN_MIC_DIALOG_CONFIG", "INVITE_OPEN_MIC_TIPS_CONFIG", "NAV_TIPS_CONFIG", "NEW_PLAY_UPDATE_CONFIG", "OFFLINE_PRELOAD_IDS", "OPEN_INDEX", "PLAY_OFFLINE_CONFIG", "TAG", "TIMES_LIMIT_LIST", "TYPE", "USER_ENTER_TIME_LIST", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.media.config.MediaGuidanceConfig$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final b a() {
            b bVar = (b) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100446");
            if (bVar == null) {
                return new b();
            }
            return bVar;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\bH\u0002J\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\r\u001a\u0004\b\u0013\u0010\u000fR\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000fR\u0017\u0010\u001c\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/media/config/MediaGuidanceConfig$b;", "Lcom/tencent/freesia/IConfigData;", "Lorg/json/JSONObject;", "jsonObject", "Lcom/tencent/mobileqq/guild/media/config/MediaGuidanceConfig$c;", "configData", "", "e", "Lcom/tencent/mobileqq/guild/media/config/MediaGuidanceConfig$d;", "f", "", "content", "d", "Lcom/tencent/mobileqq/guild/media/config/MediaGuidanceConfig$c;", "b", "()Lcom/tencent/mobileqq/guild/media/config/MediaGuidanceConfig$c;", "navConfigData", "c", "updateConfigData", "a", "inviteOpenMicTipsConfigData", h.F, "getInviteOpenMicDialogConfigData", "inviteOpenMicDialogConfigData", "i", "Lcom/tencent/mobileqq/guild/media/config/MediaGuidanceConfig$d;", "getPreloadOfflineIdConfigData", "()Lcom/tencent/mobileqq/guild/media/config/MediaGuidanceConfig$d;", "preloadOfflineIdConfigData", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements IConfigData {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final NavConfigData navConfigData;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final NavConfigData updateConfigData;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final NavConfigData inviteOpenMicTipsConfigData;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final NavConfigData inviteOpenMicDialogConfigData;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final OfflineConfigData preloadOfflineIdConfigData = new OfflineConfigData(null, 1, 0 == true ? 1 : 0);

        public b() {
            String str = null;
            String str2 = null;
            this.navConfigData = new NavConfigData(null, null, 0, 0L, null, str, str2, 0, null, 0, 1023, null);
            String str3 = null;
            JSONArray jSONArray = null;
            int i3 = 0;
            long j3 = 0;
            String str4 = null;
            String str5 = null;
            String str6 = null;
            int i16 = 0;
            JSONArray jSONArray2 = null;
            int i17 = 0;
            int i18 = 1023;
            DefaultConstructorMarker defaultConstructorMarker = null;
            this.updateConfigData = new NavConfigData(str3, jSONArray, i3, j3, str4, str5, str6, i16, jSONArray2, i17, i18, defaultConstructorMarker);
            this.inviteOpenMicTipsConfigData = new NavConfigData(0 == true ? 1 : 0, null, 0, 0L, str, str2, null, 0, null, 0, 1023, null);
            this.inviteOpenMicDialogConfigData = new NavConfigData(str3, jSONArray, i3, j3, str4, str5, str6, i16, jSONArray2, i17, i18, defaultConstructorMarker);
        }

        private final void e(JSONObject jsonObject, NavConfigData configData) {
            if (jsonObject == null) {
                return;
            }
            String optString = jsonObject.optString("type");
            Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(TYPE)");
            configData.r(optString);
            configData.s(jsonObject.optJSONArray("user_enter_time_list"));
            configData.m(jsonObject.optInt("effective_condition"));
            configData.n(jsonObject.optLong(SPBufferRangeController.CONFIG_EFFECTIVE_TIME));
            String optString2 = jsonObject.optString("icon_url");
            Intrinsics.checkNotNullExpressionValue(optString2, "jsonObject.optString(ICON_URL)");
            configData.o(optString2);
            String optString3 = jsonObject.optString("active_tips");
            Intrinsics.checkNotNullExpressionValue(optString3, "jsonObject.optString(ACTIVE_TIPS)");
            configData.j(optString3);
            String optString4 = jsonObject.optString("btn_msg");
            Intrinsics.checkNotNullExpressionValue(optString4, "jsonObject.optString(BTN_MSG)");
            configData.k(optString4);
            configData.p(jsonObject.optInt("open_index"));
            configData.q(jsonObject.optJSONArray("times_limit_list"));
            configData.l(jsonObject.optInt("data_version"));
        }

        private final void f(JSONObject jsonObject, OfflineConfigData configData) {
            JSONArray jSONArray;
            int length;
            boolean isBlank;
            QLog.d("QGMC.MediaGuidanceConfig", 1, "parseOfflineConfig: " + jsonObject);
            if (jsonObject != null) {
                jSONArray = jsonObject.optJSONArray("offline_preload_ids");
            } else {
                jSONArray = null;
            }
            if (jSONArray == null || (length = jSONArray.length()) == 0) {
                return;
            }
            for (int i3 = 0; i3 < length; i3++) {
                String optString = jSONArray.optString(i3);
                if (optString != null) {
                    isBlank = StringsKt__StringsJVMKt.isBlank(optString);
                    if ((!isBlank) && !configData.a().contains(optString)) {
                        configData.a().add(optString);
                    }
                }
            }
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final NavConfigData getInviteOpenMicTipsConfigData() {
            return this.inviteOpenMicTipsConfigData;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final NavConfigData getNavConfigData() {
            return this.navConfigData;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final NavConfigData getUpdateConfigData() {
            return this.updateConfigData;
        }

        public final void d(@NotNull String content) {
            Intrinsics.checkNotNullParameter(content, "content");
            JSONObject jSONObject = new JSONObject(content);
            e(jSONObject.optJSONObject("nav_tips_config"), this.navConfigData);
            e(jSONObject.optJSONObject("new_play_update_config"), this.updateConfigData);
            e(jSONObject.optJSONObject("invite_open_mic_tips_config"), this.inviteOpenMicTipsConfigData);
            e(jSONObject.optJSONObject("invite_open_mic_dialog_config"), this.inviteOpenMicDialogConfigData);
            f(jSONObject.optJSONObject("play_offline_config"), this.preloadOfflineIdConfigData);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0004\u0012\b\b\u0002\u0010%\u001a\u00020\u001f\u0012\b\b\u0002\u0010(\u001a\u00020\u0002\u0012\b\b\u0002\u0010*\u001a\u00020\u0002\u0012\b\b\u0002\u0010-\u001a\u00020\u0002\u0012\b\b\u0002\u00100\u001a\u00020\u0004\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u00104\u001a\u00020\u0004\u00a2\u0006\u0004\b5\u00106J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010%\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010(\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\n\u001a\u0004\b&\u0010\f\"\u0004\b'\u0010\u000eR\"\u0010*\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\n\u001a\u0004\b\t\u0010\f\"\u0004\b)\u0010\u000eR\"\u0010-\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b,\u0010\u000eR\"\u00100\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010\u0019\u001a\u0004\b+\u0010\u001b\"\u0004\b/\u0010\u001dR$\u00102\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0012\u001a\u0004\b.\u0010\u0014\"\u0004\b1\u0010\u0016R\"\u00104\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010\u0019\u001a\u0004\b\u0018\u0010\u001b\"\u0004\b3\u0010\u001d\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/guild/media/config/MediaGuidanceConfig$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "r", "(Ljava/lang/String;)V", "type", "Lorg/json/JSONArray;", "b", "Lorg/json/JSONArray;", "i", "()Lorg/json/JSONArray;", ReportConstant.COSTREPORT_PREFIX, "(Lorg/json/JSONArray;)V", "userEnterTime", "c", "I", "d", "()I", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(I)V", "effectiveCondition", "", "J", "e", "()J", DomainData.DOMAIN_NAME, "(J)V", "effectiveTime", "f", "o", "iconUrl", "j", "activeTips", "g", "k", "btnMsg", h.F, "p", "openIndex", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "timesLimit", "l", "dataVersion", "<init>", "(Ljava/lang/String;Lorg/json/JSONArray;IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILorg/json/JSONArray;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.media.config.MediaGuidanceConfig$c, reason: from toString */
    /* loaded from: classes14.dex */
    public static final /* data */ class NavConfigData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String type;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private JSONArray userEnterTime;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private int effectiveCondition;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private long effectiveTime;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String iconUrl;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String activeTips;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String btnMsg;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        private int openIndex;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private JSONArray timesLimit;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
        private int dataVersion;

        public NavConfigData() {
            this(null, null, 0, 0L, null, null, null, 0, null, 0, 1023, null);
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getActiveTips() {
            return this.activeTips;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getBtnMsg() {
            return this.btnMsg;
        }

        /* renamed from: c, reason: from getter */
        public final int getDataVersion() {
            return this.dataVersion;
        }

        /* renamed from: d, reason: from getter */
        public final int getEffectiveCondition() {
            return this.effectiveCondition;
        }

        /* renamed from: e, reason: from getter */
        public final long getEffectiveTime() {
            return this.effectiveTime;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NavConfigData)) {
                return false;
            }
            NavConfigData navConfigData = (NavConfigData) other;
            if (Intrinsics.areEqual(this.type, navConfigData.type) && Intrinsics.areEqual(this.userEnterTime, navConfigData.userEnterTime) && this.effectiveCondition == navConfigData.effectiveCondition && this.effectiveTime == navConfigData.effectiveTime && Intrinsics.areEqual(this.iconUrl, navConfigData.iconUrl) && Intrinsics.areEqual(this.activeTips, navConfigData.activeTips) && Intrinsics.areEqual(this.btnMsg, navConfigData.btnMsg) && this.openIndex == navConfigData.openIndex && Intrinsics.areEqual(this.timesLimit, navConfigData.timesLimit) && this.dataVersion == navConfigData.dataVersion) {
                return true;
            }
            return false;
        }

        @NotNull
        /* renamed from: f, reason: from getter */
        public final String getIconUrl() {
            return this.iconUrl;
        }

        /* renamed from: g, reason: from getter */
        public final int getOpenIndex() {
            return this.openIndex;
        }

        @Nullable
        /* renamed from: h, reason: from getter */
        public final JSONArray getTimesLimit() {
            return this.timesLimit;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = this.type.hashCode() * 31;
            JSONArray jSONArray = this.userEnterTime;
            int i3 = 0;
            if (jSONArray == null) {
                hashCode = 0;
            } else {
                hashCode = jSONArray.hashCode();
            }
            int a16 = (((((((((((((hashCode2 + hashCode) * 31) + this.effectiveCondition) * 31) + a.a(this.effectiveTime)) * 31) + this.iconUrl.hashCode()) * 31) + this.activeTips.hashCode()) * 31) + this.btnMsg.hashCode()) * 31) + this.openIndex) * 31;
            JSONArray jSONArray2 = this.timesLimit;
            if (jSONArray2 != null) {
                i3 = jSONArray2.hashCode();
            }
            return ((a16 + i3) * 31) + this.dataVersion;
        }

        @Nullable
        /* renamed from: i, reason: from getter */
        public final JSONArray getUserEnterTime() {
            return this.userEnterTime;
        }

        public final void j(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.activeTips = str;
        }

        public final void k(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.btnMsg = str;
        }

        public final void l(int i3) {
            this.dataVersion = i3;
        }

        public final void m(int i3) {
            this.effectiveCondition = i3;
        }

        public final void n(long j3) {
            this.effectiveTime = j3;
        }

        public final void o(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.iconUrl = str;
        }

        public final void p(int i3) {
            this.openIndex = i3;
        }

        public final void q(@Nullable JSONArray jSONArray) {
            this.timesLimit = jSONArray;
        }

        public final void r(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.type = str;
        }

        public final void s(@Nullable JSONArray jSONArray) {
            this.userEnterTime = jSONArray;
        }

        @NotNull
        public String toString() {
            return "NavConfigData(type=" + this.type + ", userEnterTime=" + this.userEnterTime + ", effectiveCondition=" + this.effectiveCondition + ", effectiveTime=" + this.effectiveTime + ", iconUrl=" + this.iconUrl + ", activeTips=" + this.activeTips + ", btnMsg=" + this.btnMsg + ", openIndex=" + this.openIndex + ", timesLimit=" + this.timesLimit + ", dataVersion=" + this.dataVersion + ")";
        }

        public NavConfigData(@NotNull String type, @Nullable JSONArray jSONArray, int i3, long j3, @NotNull String iconUrl, @NotNull String activeTips, @NotNull String btnMsg, int i16, @Nullable JSONArray jSONArray2, int i17) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
            Intrinsics.checkNotNullParameter(activeTips, "activeTips");
            Intrinsics.checkNotNullParameter(btnMsg, "btnMsg");
            this.type = type;
            this.userEnterTime = jSONArray;
            this.effectiveCondition = i3;
            this.effectiveTime = j3;
            this.iconUrl = iconUrl;
            this.activeTips = activeTips;
            this.btnMsg = btnMsg;
            this.openIndex = i16;
            this.timesLimit = jSONArray2;
            this.dataVersion = i17;
        }

        public /* synthetic */ NavConfigData(String str, JSONArray jSONArray, int i3, long j3, String str2, String str3, String str4, int i16, JSONArray jSONArray2, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
            this((i18 & 1) != 0 ? "" : str, (i18 & 2) != 0 ? null : jSONArray, (i18 & 4) != 0 ? 0 : i3, (i18 & 8) != 0 ? 0L : j3, (i18 & 16) != 0 ? "" : str2, (i18 & 32) != 0 ? "" : str3, (i18 & 64) == 0 ? str4 : "", (i18 & 128) != 0 ? 0 : i16, (i18 & 256) == 0 ? jSONArray2 : null, (i18 & 512) == 0 ? i17 : 0);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0018\b\u0002\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00020\tj\b\u0012\u0004\u0012\u00020\u0002`\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R'\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00020\tj\b\u0012\u0004\u0012\u00020\u0002`\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/media/config/MediaGuidanceConfig$d;", "", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "a", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "preloadIDList", "<init>", "(Ljava/util/ArrayList;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.media.config.MediaGuidanceConfig$d, reason: from toString */
    /* loaded from: classes14.dex */
    public static final /* data */ class OfflineConfigData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final ArrayList<String> preloadIDList;

        public OfflineConfigData() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @NotNull
        public final ArrayList<String> a() {
            return this.preloadIDList;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof OfflineConfigData) && Intrinsics.areEqual(this.preloadIDList, ((OfflineConfigData) other).preloadIDList)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.preloadIDList.hashCode();
        }

        @NotNull
        public String toString() {
            return "OfflineConfigData(preloadIDList=" + this.preloadIDList + ")";
        }

        public OfflineConfigData(@NotNull ArrayList<String> preloadIDList) {
            Intrinsics.checkNotNullParameter(preloadIDList, "preloadIDList");
            this.preloadIDList = preloadIDList;
        }

        public /* synthetic */ OfflineConfigData(ArrayList arrayList, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? new ArrayList() : arrayList);
        }
    }

    @Override // com.tencent.freesia.BaseConfigParser, com.tencent.freesia.ConfigParser
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b defaultConfig() {
        QLog.d("QGMC.MediaGuidanceConfig", 1, "get defaultConfig");
        return new b();
    }

    @Override // com.tencent.freesia.BaseConfigParser
    @NotNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b parse(@NotNull byte[] content) {
        boolean z16;
        Intrinsics.checkNotNullParameter(content, "content");
        QLog.d("QGMC.MediaGuidanceConfig", 1, "parse config");
        b bVar = new b();
        if (content.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            bVar.d(new String(content, UTF_8));
            QLog.d("QGMC.MediaGuidanceConfig", 1, "test: " + bVar);
        } else {
            QLog.d("QGMC.MediaGuidanceConfig", 1, "parse empty content");
        }
        return bVar;
    }
}

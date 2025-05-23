package com.tencent.mobileqq.guild.live.config;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.oskplayer.util.SecretUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\tR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0006R\u0011\u0010\u0013\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0006\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/live/config/GuildLiveReadyTipsConfBean;", "", "Lcom/tencent/mobileqq/guild/live/config/b;", "a", "Lkotlin/Lazy;", "d", "()Lcom/tencent/mobileqq/guild/live/config/b;", "defaultPushLiveConf", "b", "Lcom/tencent/mobileqq/guild/live/config/b;", "_gameLiveConf", "c", "_programLiveConf", "_pushLiveConf", "e", "gameLiveConf", "f", "programLiveConf", "g", "pushLiveConf", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildLiveReadyTipsConfBean {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy defaultPushLiveConf;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildLiveTipsBean _gameLiveConf;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildLiveTipsBean _programLiveConf;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildLiveTipsBean _pushLiveConf;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0007J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0002H\u0007R\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000fR\u0014\u0010\u0015\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000fR\u0014\u0010\u0016\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u000fR\u0014\u0010\u0017\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u000fR\u0014\u0010\u0018\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u000fR\u0014\u0010\u0019\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u000fR\u0014\u0010\u001a\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u000f\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/live/config/GuildLiveReadyTipsConfBean$a;", "", "Lorg/json/JSONObject;", "obj", "Lcom/tencent/mobileqq/guild/live/config/b;", "b", "Lcom/tencent/mobileqq/guild/live/config/GuildLiveReadyTipsConfBean;", "bean", "jsonObj", "", "c", "", "a", "", "CONTENT_KEY", "Ljava/lang/String;", "DES_KEY", "ENABLE_KEY", "GAME_CONFIG_KEY", "ICON_URL_KEY", "ITEM_KEY", "PROGRAM_CONFIG_KEY", "PUSH_CONFIG_KEY", "PUSH_LIVE_DEFAULT_ICON", "TAG", "TEXT_KEY", "TITLE_KEY", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.live.config.GuildLiveReadyTipsConfBean$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final GuildLiveTipsBean b(JSONObject obj) {
            JSONObject jSONObject;
            JSONObject jSONObject2 = obj.getJSONObject("content");
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject2.optJSONArray(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME);
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    Object obj2 = optJSONArray.get(i3);
                    if (obj2 instanceof JSONObject) {
                        jSONObject = (JSONObject) obj2;
                    } else {
                        jSONObject = null;
                    }
                    if (jSONObject != null) {
                        String optString = jSONObject.optString("iconUrl", "");
                        Intrinsics.checkNotNullExpressionValue(optString, "optString(ICON_URL_KEY, \"\")");
                        String optString2 = jSONObject.optString("text", "");
                        Intrinsics.checkNotNullExpressionValue(optString2, "optString(TEXT_KEY, \"\")");
                        arrayList.add(new GuildLiveTipsContentItem(optString, optString2));
                    }
                }
            }
            boolean optBoolean = obj.optBoolean("enable", false);
            String optString3 = obj.optString("title", "");
            Intrinsics.checkNotNullExpressionValue(optString3, "obj.optString(TITLE_KEY, \"\")");
            String optString4 = jSONObject2.optString(SecretUtils.DES, "");
            Intrinsics.checkNotNullExpressionValue(optString4, "contentObj.optString(DES_KEY, \"\")");
            return new GuildLiveTipsBean(optBoolean, optString3, new GuildLiveTipsContent(optString4, arrayList));
        }

        @JvmStatic
        public final boolean a(@NotNull JSONObject jsonObj) {
            Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
            if (!jsonObj.has("gameLiveTypeTips") && !jsonObj.has("pushLiveTypeTips")) {
                return false;
            }
            return true;
        }

        @JvmStatic
        public final void c(@NotNull GuildLiveReadyTipsConfBean bean, @NotNull JSONObject jsonObj) {
            JSONObject optJSONObject;
            JSONObject optJSONObject2;
            JSONObject optJSONObject3;
            Intrinsics.checkNotNullParameter(bean, "bean");
            Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
            if (jsonObj.has("gameLiveTypeTips") && (optJSONObject3 = jsonObj.optJSONObject("gameLiveTypeTips")) != null) {
                bean._gameLiveConf = GuildLiveReadyTipsConfBean.INSTANCE.b(optJSONObject3);
            }
            if (jsonObj.has("programLiveTypeTips") && (optJSONObject2 = jsonObj.optJSONObject("programLiveTypeTips")) != null) {
                bean._programLiveConf = GuildLiveReadyTipsConfBean.INSTANCE.b(optJSONObject2);
            }
            if (jsonObj.has("pushLiveTypeTips") && (optJSONObject = jsonObj.optJSONObject("pushLiveTypeTips")) != null) {
                bean._pushLiveConf = GuildLiveReadyTipsConfBean.INSTANCE.b(optJSONObject);
            }
            QLog.i("GuildLiveReadyTipsConfBean", 2, "parseFromJson complete.");
        }

        Companion() {
        }
    }

    public GuildLiveReadyTipsConfBean() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildLiveTipsBean>() { // from class: com.tencent.mobileqq.guild.live.config.GuildLiveReadyTipsConfBean$defaultPushLiveConf$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildLiveTipsBean invoke() {
                ArrayList arrayListOf;
                String qqStr = HardCodeUtil.qqStr(R.string.f148550zw);
                Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.guild_live_tips_default_title)");
                String qqStr2 = HardCodeUtil.qqStr(R.string.f148540zv);
                Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(R.string.guild_live_tips_default_text)");
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new GuildLiveTipsContentItem("https://downv6.qq.com/innovate/guild/live_channel/icon_live_tips_report.png", qqStr2));
                return new GuildLiveTipsBean(true, qqStr, new GuildLiveTipsContent("", arrayListOf));
            }
        });
        this.defaultPushLiveConf = lazy;
    }

    private final GuildLiveTipsBean d() {
        return (GuildLiveTipsBean) this.defaultPushLiveConf.getValue();
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final GuildLiveTipsBean get_gameLiveConf() {
        return this._gameLiveConf;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final GuildLiveTipsBean get_programLiveConf() {
        return this._programLiveConf;
    }

    @NotNull
    public final GuildLiveTipsBean g() {
        GuildLiveTipsBean guildLiveTipsBean = this._pushLiveConf;
        if (guildLiveTipsBean == null) {
            return d();
        }
        return guildLiveTipsBean;
    }
}

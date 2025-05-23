package com.tencent.mobileqq.guild.config;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.raft.codegenmeta.utils.Constants;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \u00112\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0016R$\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR$\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\n8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR$\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u0011\u0010\bRD\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u00152\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u00158\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R$\u0010 \u001a\u00020\u001b2\u0006\u0010\u0004\u001a\u00020\u001b8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR$\u0010\"\u001a\u00020\u001b2\u0006\u0010\u0004\u001a\u00020\u001b8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0018\u0010\u001d\u001a\u0004\b!\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/guild/config/ab;", "", "", "toString", "<set-?>", "a", "Ljava/lang/String;", "j", "()Ljava/lang/String;", "tipStr", "", "b", "Z", "i", "()Z", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "c", "g", "jumpURL", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "d", "Ljava/util/HashSet;", "f", "()Ljava/util/HashSet;", "allowShowClassSet", "", "e", "I", tl.h.F, "()I", "showMaxTimes", "k", "version", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.config.ab, reason: from toString */
/* loaded from: classes13.dex */
public final class TroopJoinGuildBean {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String tipStr;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean switch;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String jumpURL;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private HashSet<Long> allowShowClassSet;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private int showMaxTimes;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private int version;

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0012R\u0014\u0010\u0018\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0012R\u0014\u0010\u0019\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0012R\u0014\u0010\u001a\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\f\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/config/ab$a;", "", "Lcom/tencent/mobileqq/guild/config/ab;", "bean", "Lorg/json/JSONObject;", "jsonObj", "", "b", "", "a", "", Constants.KEY_OPTION_FALSE, "I", "", "ILLEGAL_CLASS_TYPE", "J", "", "KEY_CLASS_FILTER", "Ljava/lang/String;", "KEY_CLASS_FILTER_TYPE", "KEY_ITEM_SWITCH", "KEY_ITEM_TIPS_STR", "KEY_ITEM_URL", "KEY_MAX_SHOW_TIMES", "KEY_MAX_VERSION", "TAG", Constants.KEY_OPTION_TRUE, "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.config.ab$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final boolean a(@NotNull JSONObject jsonObj) {
            Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
            if (!jsonObj.has("troopJoinGuild_Switch") || jsonObj.optInt("troopJoinGuild_Switch", 0) != 1) {
                return false;
            }
            return true;
        }

        @JvmStatic
        public final void b(@NotNull TroopJoinGuildBean bean, @NotNull JSONObject jsonObj) {
            boolean z16;
            Intrinsics.checkNotNullParameter(bean, "bean");
            Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
            QLog.d("Guild.config.TroopJoinGuildBean", 1, "[parseFromJson] jsonObj = " + jsonObj);
            String optString = jsonObj.optString("troopJoinGuild_TipStr", bean.getTipStr());
            Intrinsics.checkNotNullExpressionValue(optString, "jsonObj.optString(KEY_ITEM_TIPS_STR, tipStr)");
            bean.tipStr = optString;
            if (jsonObj.optInt("troopJoinGuild_Switch", 0) == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            bean.switch = z16;
            String optString2 = jsonObj.optString("troopJoinGuild_URL", bean.getJumpURL());
            Intrinsics.checkNotNullExpressionValue(optString2, "jsonObj.optString(KEY_ITEM_URL, jumpURL)");
            bean.jumpURL = optString2;
            bean.showMaxTimes = jsonObj.optInt("troopJoinGuild_MaxShowTimes", bean.getShowMaxTimes());
            bean.version = jsonObj.optInt("troopJoinGuild_Version", bean.getVersion());
            int showTroopJoinGuildTipsVersion = ((IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class)).getShowTroopJoinGuildTipsVersion();
            if (showTroopJoinGuildTipsVersion < bean.getVersion()) {
                QLog.d("Guild.config.TroopJoinGuildBean", 1, "[parseFromJson] oldVersion = " + showTroopJoinGuildTipsVersion + ", newVersion = " + bean.getVersion());
                ((IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class)).setShowTroopJoinGuildTipsVersion(bean.getVersion());
                ((IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class)).resetShowTroopJoinGuildTipsHasClose();
                ((IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class)).resetShowTroopJoinGuildTipsTimes();
            }
            JSONArray optJSONArray = jsonObj.optJSONArray("troopJoinGuild_classFilter");
            if (optJSONArray != null) {
                Intrinsics.checkNotNullExpressionValue(optJSONArray, "optJSONArray(KEY_CLASS_FILTER)");
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    long optLong = optJSONArray.getJSONObject(i3).optLong("type", Long.MIN_VALUE);
                    if (optLong != Long.MIN_VALUE) {
                        bean.f().add(Long.valueOf(optLong));
                    }
                }
            }
            QLog.d("Guild.config.TroopJoinGuildBean", 2, "[parseFromJson] " + bean);
        }

        Companion() {
        }
    }

    public TroopJoinGuildBean() {
        String string = BaseApplication.getContext().getString(R.string.f158061ol);
        Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(R\u2026ild_troop_join_guild_tip)");
        this.tipStr = string;
        this.jumpURL = "https://qun.qq.com/qqweb/qunpro/templatenew?_wv=16777219&_wwv=128&appid=51";
        this.allowShowClassSet = new HashSet<>();
    }

    @NotNull
    public final HashSet<Long> f() {
        return this.allowShowClassSet;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getJumpURL() {
        return this.jumpURL;
    }

    /* renamed from: h, reason: from getter */
    public final int getShowMaxTimes() {
        return this.showMaxTimes;
    }

    /* renamed from: i, reason: from getter */
    public final boolean getSwitch() {
        return this.switch;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final String getTipStr() {
        return this.tipStr;
    }

    /* renamed from: k, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    @NotNull
    public String toString() {
        return "TroopJoinGuildBean(tipStr='" + this.tipStr + "', switch=" + this.switch + ", jumpURL='" + this.jumpURL + "', allowShowClassSet=" + this.allowShowClassSet + ", showMaxTimes=" + this.showMaxTimes + ", version=" + this.version + ")";
    }
}

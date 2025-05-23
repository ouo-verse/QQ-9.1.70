package com.tencent.mobileqq.troop.data;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopSystemMsgUtilApi;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b \b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0001\u000fBc\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b&\u0010'Ji\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u00c6\u0001J\t\u0010\u0010\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\t\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\n\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b \u0010\u001f\u001a\u0004\b\u001b\u0010!R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u001c\u001a\u0004\b#\u0010\u001eR\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010!R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b%\u0010\u001f\u001a\u0004\b$\u0010!R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u001c\u001a\u0004\b\"\u0010\u001e\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/troop/data/v;", "", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", "", "dbHasTroopInfo", "", "channelSourceItem", "", "cityId", "activeMemberNum", "userFrom", "statOption", "sourceId", "sceneTargetId", "a", "toString", "hashCode", "other", "equals", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "i", "()Lcom/tencent/mobileqq/data/troop/TroopInfo;", "b", "Z", "getDbHasTroopInfo", "()Z", "c", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "I", "e", "()I", "f", "j", "g", tl.h.F, "<init>", "(Lcom/tencent/mobileqq/data/troop/TroopInfo;ZLjava/lang/String;IILjava/lang/String;IILjava/lang/String;)V", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final /* data */ class v {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TroopInfo troopInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean dbHasTroopInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String channelSourceItem;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int cityId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int activeMemberNum;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String userFrom;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final int statOption;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int sourceId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String sceneTargetId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\u0007\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0006\u001a\u00020\u0005R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/troop/data/v$a;", "", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "extra", "b", "Lcom/tencent/mobileqq/troop/data/v;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.data.v$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        private final TroopInfo b(TroopInfo troopInfo, Context context, Bundle bundle) {
            boolean z16;
            troopInfo.troopuin = bundle.getString("troop_uin");
            troopInfo.troopcode = bundle.getString(AppConstants.Key.TROOP_CODE);
            troopInfo.troopface = bundle.getShort(AppConstants.Key.TROOP_INFO_FACEID);
            troopInfo.troopname = bundle.getString(AppConstants.Key.TROOP_INFO_NAME);
            troopInfo.troopowneruin = bundle.getString(AppConstants.Key.TROOP_INFO_OWNER);
            troopInfo.dwGroupClassExt = bundle.getLong(AppConstants.Key.TROOP_INFO_CLASSEXT);
            troopInfo.strLocation = bundle.getString(AppConstants.Key.TROOP_INFO_LOCA);
            String string = bundle.getString(AppConstants.Key.TROOP_INFO_FINGERMEMO);
            troopInfo.mRichFingerMemo = string;
            if (string != null && string.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                troopInfo.mRichFingerMemo = com.tencent.mobileqq.troop.util.a.c(troopInfo.mRichFingerMemo);
            }
            troopInfo.cGroupOption = bundle.getByte(AppConstants.Key.TROOP_INFO_OPT);
            troopInfo.joinTroopQuestion = ((ITroopSystemMsgUtilApi) QRoute.api(ITroopSystemMsgUtilApi.class)).getTroopQuestionFromSP(context, troopInfo.troopuin);
            troopInfo.joinTroopAnswer = ((ITroopSystemMsgUtilApi) QRoute.api(ITroopSystemMsgUtilApi.class)).getTroopAnswerFromSP(context, troopInfo.troopuin);
            troopInfo.nTroopGrade = bundle.getInt(AppConstants.Key.TROOP_INFO_TROOP_GRADE);
            troopInfo.dwGroupFlagExt = bundle.getLong(AppConstants.Key.TROOP_INFO_FLAG_EXT);
            troopInfo.dwAuthGroupType = bundle.getLong(AppConstants.Key.TROOP_INFO_AUTH_TYPE);
            troopInfo.mTags = bundle.getString(AppConstants.Key.TROOP_INFO_TAGS_EXT);
            return troopInfo;
        }

        @Nullable
        public final v a(@NotNull Bundle extra) {
            AppRuntime appRuntime;
            Context applicationContext;
            Long l3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (v) iPatchRedirector.redirect((short) 2, (Object) this, (Object) extra);
            }
            Intrinsics.checkNotNullParameter(extra, "extra");
            MobileQQ mobileQQ = MobileQQ.sMobileQQ;
            if (mobileQQ != null) {
                appRuntime = mobileQQ.peekAppRuntime();
            } else {
                appRuntime = null;
            }
            if (appRuntime == null || (applicationContext = appRuntime.getApplicationContext()) == null) {
                return null;
            }
            String string = extra.getString("troop_uin");
            if (string != null) {
                l3 = StringsKt__StringNumberConversionsKt.toLongOrNull(string);
            } else {
                l3 = null;
            }
            if (l3 != null && l3.longValue() > 0) {
                int i3 = extra.getInt(AppConstants.Key.TROOP_INFO_FROM);
                int statOption = TroopInfoData.getStatOption(extra.getInt(AppConstants.Key.TROOP_INFO_FROM_EX), i3);
                String string2 = extra.getString("param_scene_target_id");
                TroopInfo findTroopInfo = ((ITroopInfoService) appRuntime.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(String.valueOf(l3));
                if (findTroopInfo != null) {
                    v vVar = new v(findTroopInfo, true, null, 0, 0, null, statOption, i3, string2, 60, null);
                    QLog.i("TroopInfoWrapper", 1, "initFromDBOrBundle --> DB, " + vVar);
                    return vVar;
                }
                v vVar2 = new v(b(new TroopInfo(l3.longValue()), applicationContext, extra), false, null, 0, 0, null, statOption, i3, string2, 60, null);
                QLog.i("TroopInfoWrapper", 1, "initFromDBOrBundle --> Bundle, " + vVar2);
                return vVar2;
            }
            QLog.e("TroopInfoWrapper", 1, "initFromDBOrBundle error troopUin=" + l3);
            return null;
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23272);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 25)) {
            redirector.redirect((short) 25);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public v(@NotNull TroopInfo troopInfo, boolean z16, @Nullable String str, int i3, int i16, @Nullable String str2, int i17, int i18, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(troopInfo, "troopInfo");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, troopInfo, Boolean.valueOf(z16), str, Integer.valueOf(i3), Integer.valueOf(i16), str2, Integer.valueOf(i17), Integer.valueOf(i18), str3);
            return;
        }
        this.troopInfo = troopInfo;
        this.dbHasTroopInfo = z16;
        this.channelSourceItem = str;
        this.cityId = i3;
        this.activeMemberNum = i16;
        this.userFrom = str2;
        this.statOption = i17;
        this.sourceId = i18;
        this.sceneTargetId = str3;
    }

    public static /* synthetic */ v b(v vVar, TroopInfo troopInfo, boolean z16, String str, int i3, int i16, String str2, int i17, int i18, String str3, int i19, Object obj) {
        TroopInfo troopInfo2;
        boolean z17;
        String str4;
        int i26;
        int i27;
        String str5;
        int i28;
        int i29;
        String str6;
        if ((i19 & 1) != 0) {
            troopInfo2 = vVar.troopInfo;
        } else {
            troopInfo2 = troopInfo;
        }
        if ((i19 & 2) != 0) {
            z17 = vVar.dbHasTroopInfo;
        } else {
            z17 = z16;
        }
        if ((i19 & 4) != 0) {
            str4 = vVar.channelSourceItem;
        } else {
            str4 = str;
        }
        if ((i19 & 8) != 0) {
            i26 = vVar.cityId;
        } else {
            i26 = i3;
        }
        if ((i19 & 16) != 0) {
            i27 = vVar.activeMemberNum;
        } else {
            i27 = i16;
        }
        if ((i19 & 32) != 0) {
            str5 = vVar.userFrom;
        } else {
            str5 = str2;
        }
        if ((i19 & 64) != 0) {
            i28 = vVar.statOption;
        } else {
            i28 = i17;
        }
        if ((i19 & 128) != 0) {
            i29 = vVar.sourceId;
        } else {
            i29 = i18;
        }
        if ((i19 & 256) != 0) {
            str6 = vVar.sceneTargetId;
        } else {
            str6 = str3;
        }
        return vVar.a(troopInfo2, z17, str4, i26, i27, str5, i28, i29, str6);
    }

    @NotNull
    public final v a(@NotNull TroopInfo troopInfo, boolean dbHasTroopInfo, @Nullable String channelSourceItem, int cityId, int activeMemberNum, @Nullable String userFrom, int statOption, int sourceId, @Nullable String sceneTargetId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (v) iPatchRedirector.redirect((short) 21, this, troopInfo, Boolean.valueOf(dbHasTroopInfo), channelSourceItem, Integer.valueOf(cityId), Integer.valueOf(activeMemberNum), userFrom, Integer.valueOf(statOption), Integer.valueOf(sourceId), sceneTargetId);
        }
        Intrinsics.checkNotNullParameter(troopInfo, "troopInfo");
        return new v(troopInfo, dbHasTroopInfo, channelSourceItem, cityId, activeMemberNum, userFrom, statOption, sourceId, sceneTargetId);
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.activeMemberNum;
    }

    @Nullable
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.channelSourceItem;
    }

    public final int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.cityId;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof v)) {
            return false;
        }
        v vVar = (v) other;
        if (Intrinsics.areEqual(this.troopInfo, vVar.troopInfo) && this.dbHasTroopInfo == vVar.dbHasTroopInfo && Intrinsics.areEqual(this.channelSourceItem, vVar.channelSourceItem) && this.cityId == vVar.cityId && this.activeMemberNum == vVar.activeMemberNum && Intrinsics.areEqual(this.userFrom, vVar.userFrom) && this.statOption == vVar.statOption && this.sourceId == vVar.sourceId && Intrinsics.areEqual(this.sceneTargetId, vVar.sceneTargetId)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.sceneTargetId;
    }

    public final int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.sourceId;
    }

    public final int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.statOption;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        int hashCode3 = this.troopInfo.hashCode() * 31;
        boolean z16 = this.dbHasTroopInfo;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode3 + i3) * 31;
        String str = this.channelSourceItem;
        int i17 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i18 = (((((i16 + hashCode) * 31) + this.cityId) * 31) + this.activeMemberNum) * 31;
        String str2 = this.userFrom;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i19 = (((((i18 + hashCode2) * 31) + this.statOption) * 31) + this.sourceId) * 31;
        String str3 = this.sceneTargetId;
        if (str3 != null) {
            i17 = str3.hashCode();
        }
        return i19 + i17;
    }

    @NotNull
    public final TroopInfo i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TroopInfo) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.troopInfo;
    }

    @Nullable
    public final String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.userFrom;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return "TroopInfoWrapper(troopInfo=" + this.troopInfo + ", dbHasTroopInfo=" + this.dbHasTroopInfo + ", channelSourceItem=" + this.channelSourceItem + ", cityId=" + this.cityId + ", activeMemberNum=" + this.activeMemberNum + ", userFrom=" + this.userFrom + ", statOption=" + this.statOption + ", sourceId=" + this.sourceId + ", sceneTargetId=" + this.sceneTargetId + ")";
    }

    public /* synthetic */ v(TroopInfo troopInfo, boolean z16, String str, int i3, int i16, String str2, int i17, int i18, String str3, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this(troopInfo, z16, (i19 & 4) != 0 ? null : str, (i19 & 8) != 0 ? 0 : i3, (i19 & 16) != 0 ? 0 : i16, (i19 & 32) != 0 ? null : str2, (i19 & 64) != 0 ? 0 : i17, (i19 & 128) != 0 ? -1 : i18, (i19 & 256) != 0 ? null : str3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, troopInfo, Boolean.valueOf(z16), str, Integer.valueOf(i3), Integer.valueOf(i16), str2, Integer.valueOf(i17), Integer.valueOf(i18), str3, Integer.valueOf(i19), defaultConstructorMarker);
    }
}

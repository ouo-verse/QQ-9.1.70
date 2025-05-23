package com.tencent.mobileqq.data.troop;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.qqnt.ITroopListTempApi;
import com.tencent.qqnt.ITroopMemberTempApi;
import com.tencent.qqnt.ITroopRobotTempApi;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b+\b\u0087\b\u0018\u0000 R2\u00020\u00012\u00020\u0002:\u0001SBk\u0012\u0006\u00106\u001a\u00020\u0003\u0012\u0006\u00107\u001a\u00020\u0003\u0012\u0006\u00108\u001a\u00020\u0003\u0012\u0006\u00109\u001a\u00020\u0003\u0012\u0006\u0010:\u001a\u00020'\u0012\u0006\u0010;\u001a\u00020\u0003\u0012\u0006\u0010<\u001a\u00020\u0003\u0012\u0006\u0010=\u001a\u00020\u0003\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\bO\u0010PB\u0011\b\u0016\u0012\u0006\u0010*\u001a\u00020)\u00a2\u0006\u0004\bO\u0010QJ\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J\f\u0010\n\u001a\u00020\t*\u00020\bH\u0002J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u00c2\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003H\u00c2\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u00c2\u0003J\u0010\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u0014\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u0006\u0010\u0015\u001a\u00020\u0012J\u0016\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\tJ&\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\tJ\u0006\u0010\u001b\u001a\u00020\u0003J\u0006\u0010\u001c\u001a\u00020\u0003J\u0006\u0010\u001d\u001a\u00020\u0003J\u0016\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\tJ\u0016\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\tJ\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u001eJ\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u001e2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\tJ\u0006\u0010\"\u001a\u00020\u0003J\u0006\u0010#\u001a\u00020\u0003J\u0013\u0010&\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010$H\u0096\u0002J\b\u0010(\u001a\u00020'H\u0016J\u0018\u0010,\u001a\u00020\u00102\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020'H\u0016J\b\u0010-\u001a\u00020'H\u0016J\t\u0010.\u001a\u00020\u0003H\u00c6\u0003J\t\u0010/\u001a\u00020\u0003H\u00c6\u0003J\t\u00100\u001a\u00020\u0003H\u00c6\u0003J\t\u00101\u001a\u00020\u0003H\u00c6\u0003J\t\u00102\u001a\u00020'H\u00c6\u0003J\t\u00103\u001a\u00020\u0003H\u00c6\u0003J\t\u00104\u001a\u00020\u0003H\u00c6\u0003J\t\u00105\u001a\u00020\u0003H\u00c6\u0003J}\u0010A\u001a\u00020\u00002\b\b\u0002\u00106\u001a\u00020\u00032\b\b\u0002\u00107\u001a\u00020\u00032\b\b\u0002\u00108\u001a\u00020\u00032\b\b\u0002\u00109\u001a\u00020\u00032\b\b\u0002\u0010:\u001a\u00020'2\b\b\u0002\u0010;\u001a\u00020\u00032\b\b\u0002\u0010<\u001a\u00020\u00032\b\b\u0002\u0010=\u001a\u00020\u00032\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\t\u0010B\u001a\u00020\u0003H\u00d6\u0001R\u0017\u00106\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b6\u0010C\u001a\u0004\bD\u0010ER\u0017\u00107\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b7\u0010C\u001a\u0004\bF\u0010ER\u0017\u00108\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b8\u0010C\u001a\u0004\bG\u0010ER\u0017\u00109\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b9\u0010C\u001a\u0004\bH\u0010ER\u0017\u0010:\u001a\u00020'8\u0006\u00a2\u0006\f\n\u0004\b:\u0010I\u001a\u0004\bJ\u0010KR\u0017\u0010;\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b;\u0010C\u001a\u0004\bL\u0010ER\u0017\u0010<\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b<\u0010C\u001a\u0004\bM\u0010ER\u0017\u0010=\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b=\u0010C\u001a\u0004\bN\u0010ER\u0018\u0010>\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010CR\u0018\u0010?\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010CR\u0018\u0010@\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010C\u00a8\u0006T"}, d2 = {"Lcom/tencent/mobileqq/data/troop/TroopMemberNickInfo;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "", "getNoFriendRemark", "name", "Lcom/tencent/mobileqq/data/troop/c;", "generateSearchInfo", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/d;", "", IProfileProtocolConst.PARAM_IS_FRIEND, "component9", "component10", "component11", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfoExt;", "ext", "", "initPinyin", "Lcom/tencent/mobileqq/data/troop/TroopMemberNickUIInfo;", "uiInfo", "updatePinyin", "getUIInfo", "needColorNick", "needRemark", "needPinyinFirst", "needPinyinAll", "getUIInfoV2", "getShowName", "getShowNameV2", "getHBShowName", "", "getSearchInfo", "showNameNeedColorNick", "showNameNeedRemark", "getRemarkFromFriend", "getRemarkFromFriendV2", "", "other", "equals", "", "hashCode", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "writeToParcel", "describeContents", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "troopUin", "uin", "uid", "colorNick", "colorNickId", AppConstants.Preferences.TROOP_NICK, "autoRemark", "friendNick", "cacheShowNameForPinyin", "cachePinyinFirst", "cachePinyinAll", "copy", "toString", "Ljava/lang/String;", "getTroopUin", "()Ljava/lang/String;", "getUin", "getUid", "getColorNick", "I", "getColorNickId", "()I", "getTroopNick", "getAutoRemark", "getFriendNick", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(Landroid/os/Parcel;)V", "CREATOR", "a", "imcore-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final /* data */ class TroopMemberNickInfo implements Parcelable, Serializable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static Boolean enableShowNameOpt;

    @NotNull
    private final String autoRemark;

    @Nullable
    private String cachePinyinAll;

    @Nullable
    private String cachePinyinFirst;

    @Nullable
    private String cacheShowNameForPinyin;

    @NotNull
    private final String colorNick;
    private final int colorNickId;

    @NotNull
    private final String friendNick;

    @NotNull
    private final String troopNick;

    @NotNull
    private final String troopUin;

    @NotNull
    private final String uid;

    @NotNull
    private final String uin;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\nR\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/data/troop/TroopMemberNickInfo$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/data/troop/TroopMemberNickInfo;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/data/troop/TroopMemberNickInfo;", "", "enableShowNameOpt", "Ljava/lang/Boolean;", "<init>", "()V", "imcore-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.data.troop.TroopMemberNickInfo$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion implements Parcelable.Creator<TroopMemberNickInfo> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TroopMemberNickInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new TroopMemberNickInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public TroopMemberNickInfo[] newArray(int size) {
            return new TroopMemberNickInfo[size];
        }

        Companion() {
        }
    }

    public TroopMemberNickInfo(@NotNull String troopUin, @NotNull String uin, @NotNull String uid, @NotNull String colorNick, int i3, @NotNull String troopNick, @NotNull String autoRemark, @NotNull String friendNick, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(colorNick, "colorNick");
        Intrinsics.checkNotNullParameter(troopNick, "troopNick");
        Intrinsics.checkNotNullParameter(autoRemark, "autoRemark");
        Intrinsics.checkNotNullParameter(friendNick, "friendNick");
        this.troopUin = troopUin;
        this.uin = uin;
        this.uid = uid;
        this.colorNick = colorNick;
        this.colorNickId = i3;
        this.troopNick = troopNick;
        this.autoRemark = autoRemark;
        this.friendNick = friendNick;
        this.cacheShowNameForPinyin = str;
        this.cachePinyinFirst = str2;
        this.cachePinyinAll = str3;
    }

    /* renamed from: component10, reason: from getter */
    private final String getCachePinyinFirst() {
        return this.cachePinyinFirst;
    }

    /* renamed from: component11, reason: from getter */
    private final String getCachePinyinAll() {
        return this.cachePinyinAll;
    }

    /* renamed from: component9, reason: from getter */
    private final String getCacheShowNameForPinyin() {
        return this.cacheShowNameForPinyin;
    }

    private final TroopMemberNickSearchInfo generateSearchInfo(String name) {
        String d16 = ChnToSpell.d(name, 2);
        Intrinsics.checkNotNullExpressionValue(d16, "makeSpellCode(name, ChnT\u2026RANS_MODE_PINYIN_INITIAL)");
        String d17 = ChnToSpell.d(name, 1);
        Intrinsics.checkNotNullExpressionValue(d17, "makeSpellCode(name, ChnT\u2026pell.TRANS_MODE_QUAN_PIN)");
        return new TroopMemberNickSearchInfo(name, d16, d17);
    }

    private final String getNoFriendRemark() {
        return ((ITroopMemberTempApi) QRoute.api(ITroopMemberTempApi.class)).getNoFriendRemark(this.uid);
    }

    private final boolean isFriend(com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar) {
        if (dVar.f() >= 0) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getTroopUin() {
        return this.troopUin;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getUid() {
        return this.uid;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getColorNick() {
        return this.colorNick;
    }

    /* renamed from: component5, reason: from getter */
    public final int getColorNickId() {
        return this.colorNickId;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getTroopNick() {
        return this.troopNick;
    }

    @NotNull
    /* renamed from: component7, reason: from getter */
    public final String getAutoRemark() {
        return this.autoRemark;
    }

    @NotNull
    /* renamed from: component8, reason: from getter */
    public final String getFriendNick() {
        return this.friendNick;
    }

    @NotNull
    public final TroopMemberNickInfo copy(@NotNull String troopUin, @NotNull String uin, @NotNull String uid, @NotNull String colorNick, int colorNickId, @NotNull String troopNick, @NotNull String autoRemark, @NotNull String friendNick, @Nullable String cacheShowNameForPinyin, @Nullable String cachePinyinFirst, @Nullable String cachePinyinAll) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(colorNick, "colorNick");
        Intrinsics.checkNotNullParameter(troopNick, "troopNick");
        Intrinsics.checkNotNullParameter(autoRemark, "autoRemark");
        Intrinsics.checkNotNullParameter(friendNick, "friendNick");
        return new TroopMemberNickInfo(troopUin, uin, uid, colorNick, colorNickId, troopNick, autoRemark, friendNick, cacheShowNameForPinyin, cachePinyinFirst, cachePinyinAll);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TroopMemberNickInfo)) {
            return false;
        }
        TroopMemberNickInfo troopMemberNickInfo = (TroopMemberNickInfo) other;
        if (Intrinsics.areEqual(this.uin, troopMemberNickInfo.uin) || Intrinsics.areEqual(this.uid, troopMemberNickInfo.uid)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getAutoRemark() {
        return this.autoRemark;
    }

    @NotNull
    public final String getColorNick() {
        return this.colorNick;
    }

    public final int getColorNickId() {
        return this.colorNickId;
    }

    @NotNull
    public final String getFriendNick() {
        return this.friendNick;
    }

    @NotNull
    public final String getHBShowName() {
        return getShowName(false, true);
    }

    @NotNull
    public final String getRemarkFromFriend() {
        ArrayList<String> arrayListOf;
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar;
        String r16;
        Object firstOrNull;
        IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
        boolean z16 = true;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(this.uid);
        ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> friendSimpleInfoWithUid = iFriendsInfoService.getFriendSimpleInfoWithUid(arrayListOf, "TroopMemberNickInfo");
        if (friendSimpleInfoWithUid != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) friendSimpleInfoWithUid);
            dVar = (com.tencent.qqnt.ntrelation.friendsinfo.bean.d) firstOrNull;
        } else {
            dVar = null;
        }
        if (dVar == null || !dVar.B()) {
            z16 = false;
        }
        if (!z16 || (r16 = dVar.r()) == null) {
            return "";
        }
        return r16;
    }

    @NotNull
    public final String getRemarkFromFriendV2() {
        String str;
        Friends friendFromMemoryCache = ((IFriendDataService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IFriendDataService.class, "")).getFriendFromMemoryCache(this.uin);
        boolean z16 = false;
        if (friendFromMemoryCache != null && friendFromMemoryCache.isFriend()) {
            z16 = true;
        }
        if (!z16 || (str = friendFromMemoryCache.remark) == null) {
            return "";
        }
        return str;
    }

    @NotNull
    public final List<TroopMemberNickSearchInfo> getSearchInfo() {
        return getSearchInfo(false, true);
    }

    @NotNull
    public final String getShowName() {
        return getShowName(false, true);
    }

    @NotNull
    public final String getShowNameV2() {
        return getShowNameV2(false, true);
    }

    @NotNull
    public final String getTroopNick() {
        return this.troopNick;
    }

    @NotNull
    public final String getTroopUin() {
        return this.troopUin;
    }

    @NotNull
    public final TroopMemberNickUIInfo getUIInfo() {
        return getUIInfo(false, true);
    }

    @NotNull
    public final TroopMemberNickUIInfo getUIInfoV2(boolean needColorNick, boolean needRemark, boolean needPinyinFirst, boolean needPinyinAll) {
        String str;
        boolean z16;
        String showNameV2 = getShowNameV2(needColorNick, needRemark);
        String str2 = "";
        if (!Intrinsics.areEqual(showNameV2, this.cacheShowNameForPinyin)) {
            str = "";
        } else {
            String str3 = this.cachePinyinFirst;
            if (str3 == null) {
                str3 = "";
            }
            String str4 = this.cachePinyinAll;
            if (str4 != null) {
                str2 = str4;
            }
            String str5 = str2;
            str2 = str3;
            str = str5;
        }
        boolean z17 = false;
        if (needPinyinFirst) {
            if (str2.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                str2 = ChnToSpell.d(showNameV2, 2);
                Intrinsics.checkNotNullExpressionValue(str2, "makeSpellCode(showName, \u2026RANS_MODE_PINYIN_INITIAL)");
            }
        }
        String str6 = str2;
        if (needPinyinAll) {
            if (str.length() == 0) {
                z17 = true;
            }
            if (z17) {
                str = ChnToSpell.d(showNameV2, 1);
                Intrinsics.checkNotNullExpressionValue(str, "makeSpellCode(showName, \u2026pell.TRANS_MODE_QUAN_PIN)");
            }
        }
        return new TroopMemberNickUIInfo(this.uin, this.uid, showNameV2, str6, str);
    }

    @NotNull
    public final String getUid() {
        return this.uid;
    }

    @NotNull
    public final String getUin() {
        return this.uin;
    }

    public int hashCode() {
        return (this.uin.hashCode() * 31) + this.uid.hashCode();
    }

    public final void initPinyin(@Nullable TroopMemberInfoExt ext) {
        String str;
        String str2;
        String str3 = null;
        if (ext != null) {
            str = ext.showNameForPinyin;
        } else {
            str = null;
        }
        this.cacheShowNameForPinyin = str;
        if (ext != null) {
            str2 = ext.showNamePinyinFirst;
        } else {
            str2 = null;
        }
        this.cachePinyinFirst = str2;
        if (ext != null) {
            str3 = ext.showNamePinyinAll;
        }
        this.cachePinyinAll = str3;
    }

    @NotNull
    public String toString() {
        return "TroopMemberNickInfo(troopUin=" + this.troopUin + ", uin=" + this.uin + ", uid=" + this.uid + ", colorNick=" + this.colorNick + ", colorNickId=" + this.colorNickId + ", troopNick=" + this.troopNick + ", autoRemark=" + this.autoRemark + ", friendNick=" + this.friendNick + ", cacheShowNameForPinyin=" + this.cacheShowNameForPinyin + ", cachePinyinFirst=" + this.cachePinyinFirst + ", cachePinyinAll=" + this.cachePinyinAll + ')';
    }

    public final void updatePinyin(@Nullable TroopMemberNickUIInfo uiInfo) {
        String str;
        String str2;
        String str3 = null;
        if (uiInfo != null) {
            str = uiInfo.getShowName();
        } else {
            str = null;
        }
        this.cacheShowNameForPinyin = str;
        if (uiInfo != null) {
            str2 = uiInfo.getShowNamePyFirst();
        } else {
            str2 = null;
        }
        this.cachePinyinFirst = str2;
        if (uiInfo != null) {
            str3 = uiInfo.getShowNamePyAll();
        }
        this.cachePinyinAll = str3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.troopUin);
        parcel.writeString(this.uin);
        parcel.writeString(this.uid);
        parcel.writeString(this.colorNick);
        parcel.writeInt(this.colorNickId);
        parcel.writeString(this.troopNick);
        parcel.writeString(this.autoRemark);
        parcel.writeString(this.friendNick);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x007d  */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<TroopMemberNickSearchInfo> getSearchInfo(boolean showNameNeedColorNick, boolean showNameNeedRemark) {
        List<TroopMemberNickSearchInfo> mutableListOf;
        ArrayList<String> arrayListOf;
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar;
        boolean z16;
        Object firstOrNull;
        boolean z17 = false;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(generateSearchInfo(getShowName(showNameNeedColorNick, showNameNeedRemark)), generateSearchInfo(this.colorNick), generateSearchInfo(this.troopNick), generateSearchInfo(this.autoRemark), generateSearchInfo(this.friendNick));
        IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(this.uid);
        ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> friendSimpleInfoWithUid = iFriendsInfoService.getFriendSimpleInfoWithUid(arrayListOf, "TroopMemberNickInfo");
        if (friendSimpleInfoWithUid != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) friendSimpleInfoWithUid);
            dVar = (com.tencent.qqnt.ntrelation.friendsinfo.bean.d) firstOrNull;
        } else {
            dVar = null;
        }
        if (dVar != null && dVar.B()) {
            String r16 = dVar.r();
            if (r16 != null) {
                if (r16.length() > 0) {
                    z16 = true;
                    if (z16) {
                        mutableListOf.add(generateSearchInfo(r16));
                    }
                }
            }
            z16 = false;
            if (z16) {
            }
        } else {
            String noFriendRemark = getNoFriendRemark();
            if (!(noFriendRemark == null || noFriendRemark.length() == 0)) {
                mutableListOf.add(generateSearchInfo(noFriendRemark));
            }
        }
        Object troopInfoFromCache = ((ITroopListTempApi) QRoute.api(ITroopListTempApi.class)).getTroopInfoFromCache(this.troopUin);
        TroopInfo troopInfo = troopInfoFromCache instanceof TroopInfo ? (TroopInfo) troopInfoFromCache : null;
        if (troopInfo != null && troopInfo.isQidianPrivateTroop()) {
            z17 = true;
        }
        if (!z17) {
            mutableListOf.add(new TroopMemberNickSearchInfo(this.uin, "", ""));
        }
        return mutableListOf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x012c  */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r7v26 */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r7v28 */
    /* JADX WARN: Type inference failed for: r7v29 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v30 */
    /* JADX WARN: Type inference failed for: r7v31 */
    /* JADX WARN: Type inference failed for: r7v32 */
    /* JADX WARN: Type inference failed for: r7v34 */
    /* JADX WARN: Type inference failed for: r7v36 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v46 */
    /* JADX WARN: Type inference failed for: r7v49 */
    /* JADX WARN: Type inference failed for: r7v50 */
    /* JADX WARN: Type inference failed for: r7v52 */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String getShowName(boolean needColorNick, boolean needRemark) {
        ArrayList<String> arrayListOf;
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar;
        ?? r56;
        ?? r57;
        Object firstOrNull;
        ArrayList<String> arrayListOf2;
        String p16;
        Object firstOrNull2;
        if (enableShowNameOpt == null) {
            enableShowNameOpt = Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("106036", true));
        }
        if (Intrinsics.areEqual(enableShowNameOpt, Boolean.TRUE)) {
            return getShowNameV2(needColorNick, needRemark);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QRouteApi api = QRoute.api(ITroopRobotTempApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(ITroopRobotTempApi::class.java)");
        if (((ITroopRobotTempApi) api).isRobotUin(this.uin)) {
            if ((this.friendNick.length() > 0) != false) {
                return this.friendNick;
            }
        }
        if (needColorNick) {
            if ((this.colorNick.length() > 0) != false) {
                return this.colorNick;
            }
        }
        if ((this.troopNick.length() > 0) == true) {
            return this.troopNick;
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar2 = null;
        if (Intrinsics.areEqual(this.uid, peekAppRuntime != null ? peekAppRuntime.getCurrentUid() : null)) {
            IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
            arrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf(this.uid);
            ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> friendSimpleInfoWithUid = iFriendsInfoService.getFriendSimpleInfoWithUid(arrayListOf2, "TroopMemberNickInfo");
            if (friendSimpleInfoWithUid != null) {
                firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) friendSimpleInfoWithUid);
                dVar2 = (com.tencent.qqnt.ntrelation.friendsinfo.bean.d) firstOrNull2;
            }
            return (dVar2 == null || (p16 = dVar2.p()) == null) ? this.uin : p16;
        }
        IFriendsInfoService iFriendsInfoService2 = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(this.uid);
        ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> friendSimpleInfoWithUid2 = iFriendsInfoService2.getFriendSimpleInfoWithUid(arrayListOf, "TroopMemberNickInfo");
        if (friendSimpleInfoWithUid2 != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) friendSimpleInfoWithUid2);
            dVar = (com.tencent.qqnt.ntrelation.friendsinfo.bean.d) firstOrNull;
        } else {
            dVar = null;
        }
        String noFriendRemark = getNoFriendRemark();
        if (needRemark) {
            if ((dVar != null && dVar.B()) != false) {
                String r16 = dVar.r();
                if (r16 != null) {
                    if ((r16.length() > 0) == true) {
                        r57 = true;
                        if (r57 != false) {
                            String r17 = dVar.r();
                            Intrinsics.checkNotNull(r17, "null cannot be cast to non-null type kotlin.String");
                            return r17;
                        }
                    }
                }
                r57 = false;
                if (r57 != false) {
                }
            }
        }
        if ((dVar != null && dVar.B()) != false) {
            String p17 = dVar.p();
            if (p17 != null) {
                if ((p17.length() > 0) == true) {
                    r56 = true;
                    if (r56 != false) {
                        String p18 = dVar.p();
                        Intrinsics.checkNotNull(p18, "null cannot be cast to non-null type kotlin.String");
                        return p18;
                    }
                }
            }
            r56 = false;
            if (r56 != false) {
            }
        }
        if (needRemark) {
            if ((dVar != null && dVar.B()) == false) {
                if ((noFriendRemark == null || noFriendRemark.length() == 0) == false) {
                    return noFriendRemark;
                }
            }
        }
        if (needRemark) {
            if ((this.autoRemark.length() > 0) != false) {
                return this.autoRemark;
            }
        }
        if ((this.friendNick.length() > 0) != false) {
            return this.friendNick;
        }
        Object troopInfoFromCache = ((ITroopListTempApi) QRoute.api(ITroopListTempApi.class)).getTroopInfoFromCache(this.troopUin);
        TroopInfo troopInfo = troopInfoFromCache instanceof TroopInfo ? (TroopInfo) troopInfoFromCache : null;
        if (troopInfo != null && troopInfo.isQidianPrivateTroop()) {
            String str = TroopInfo.QIDIAN_TROOP_MEMBER_DEF_NICK;
            Intrinsics.checkNotNullExpressionValue(str, "{\n                    //\u2026EF_NICK\n                }");
            return str;
        }
        return this.uin;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00d6  */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v26 */
    /* JADX WARN: Type inference failed for: r7v28 */
    /* JADX WARN: Type inference failed for: r7v29 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v30 */
    /* JADX WARN: Type inference failed for: r7v33 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v42 */
    /* JADX WARN: Type inference failed for: r7v45 */
    /* JADX WARN: Type inference failed for: r7v46 */
    /* JADX WARN: Type inference failed for: r7v48 */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String getShowNameV2(boolean needColorNick, boolean needRemark) {
        ?? r46;
        ?? r47;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QRouteApi api = QRoute.api(ITroopRobotTempApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(ITroopRobotTempApi::class.java)");
        if (((ITroopRobotTempApi) api).isRobotUin(this.uin)) {
            if ((this.friendNick.length() > 0) != false) {
                return this.friendNick;
            }
        }
        if (needColorNick) {
            if ((this.colorNick.length() > 0) != false) {
                return this.colorNick;
            }
        }
        if ((this.troopNick.length() > 0) == true) {
            return this.troopNick;
        }
        if (Intrinsics.areEqual(this.uid, peekAppRuntime != null ? peekAppRuntime.getCurrentUid() : null)) {
            Friends friendFromMemoryCache = ((IFriendDataService) peekAppRuntime.getRuntimeService(IFriendDataService.class, "")).getFriendFromMemoryCache(this.uin);
            String str = friendFromMemoryCache != null ? friendFromMemoryCache.name : null;
            return str == null ? this.uin : str;
        }
        Friends friendFromMemoryCache2 = ((IFriendDataService) peekAppRuntime.getRuntimeService(IFriendDataService.class, "")).getFriendFromMemoryCache(this.uin);
        if (needRemark) {
            if ((friendFromMemoryCache2 != null && friendFromMemoryCache2.isFriend()) != false) {
                String str2 = friendFromMemoryCache2.remark;
                if (str2 != null) {
                    if ((str2.length() > 0) == true) {
                        r47 = true;
                        if (r47 != false) {
                            String str3 = friendFromMemoryCache2.remark;
                            Intrinsics.checkNotNull(str3, "null cannot be cast to non-null type kotlin.String");
                            return str3;
                        }
                    }
                }
                r47 = false;
                if (r47 != false) {
                }
            }
        }
        if ((friendFromMemoryCache2 != null && friendFromMemoryCache2.isFriend()) != false) {
            String str4 = friendFromMemoryCache2.name;
            if (str4 != null) {
                if ((str4.length() > 0) == true) {
                    r46 = true;
                    if (r46 != false) {
                        String str5 = friendFromMemoryCache2.name;
                        Intrinsics.checkNotNull(str5, "null cannot be cast to non-null type kotlin.String");
                        return str5;
                    }
                }
            }
            r46 = false;
            if (r46 != false) {
            }
        }
        if (needRemark) {
            if ((friendFromMemoryCache2 != null && friendFromMemoryCache2.isFriend()) == false) {
                String noFriendRemark = getNoFriendRemark();
                if ((noFriendRemark == null || noFriendRemark.length() == 0) == false) {
                    return noFriendRemark;
                }
            }
        }
        if (needRemark) {
            if ((this.autoRemark.length() > 0) != false) {
                return this.autoRemark;
            }
        }
        if ((this.friendNick.length() > 0) != false) {
            return this.friendNick;
        }
        Object troopInfoFromCache = ((ITroopListTempApi) QRoute.api(ITroopListTempApi.class)).getTroopInfoFromCache(this.troopUin);
        TroopInfo troopInfo = troopInfoFromCache instanceof TroopInfo ? (TroopInfo) troopInfoFromCache : null;
        if (troopInfo != null && troopInfo.isQidianPrivateTroop()) {
            String str6 = TroopInfo.QIDIAN_TROOP_MEMBER_DEF_NICK;
            Intrinsics.checkNotNullExpressionValue(str6, "{\n                    //\u2026EF_NICK\n                }");
            return str6;
        }
        return this.uin;
    }

    @NotNull
    public final TroopMemberNickUIInfo getUIInfo(boolean needColorNick, boolean needRemark) {
        String showName = getShowName(needColorNick, needRemark);
        String str = this.uin;
        String str2 = this.uid;
        String d16 = ChnToSpell.d(showName, 2);
        Intrinsics.checkNotNullExpressionValue(d16, "makeSpellCode(showName, \u2026RANS_MODE_PINYIN_INITIAL)");
        String d17 = ChnToSpell.d(showName, 1);
        Intrinsics.checkNotNullExpressionValue(d17, "makeSpellCode(showName, \u2026pell.TRANS_MODE_QUAN_PIN)");
        return new TroopMemberNickUIInfo(str, str2, showName, d16, d17);
    }

    public /* synthetic */ TroopMemberNickInfo(String str, String str2, String str3, String str4, int i3, String str5, String str6, String str7, String str8, String str9, String str10, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, i3, str5, str6, str7, (i16 & 256) != 0 ? null : str8, (i16 & 512) != 0 ? null : str9, (i16 & 1024) != 0 ? null : str10);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TroopMemberNickInfo(@NotNull Parcel parcel) {
        this(r4, r5, r6, r7, r8, r9, r10, r0 == null ? "" : r0, null, null, null, 1792, null);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        String str = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        String str2 = readString2 == null ? "" : readString2;
        String readString3 = parcel.readString();
        String str3 = readString3 == null ? "" : readString3;
        String readString4 = parcel.readString();
        String str4 = readString4 == null ? "" : readString4;
        int readInt = parcel.readInt();
        String readString5 = parcel.readString();
        String str5 = readString5 == null ? "" : readString5;
        String readString6 = parcel.readString();
        String str6 = readString6 == null ? "" : readString6;
        String readString7 = parcel.readString();
    }
}

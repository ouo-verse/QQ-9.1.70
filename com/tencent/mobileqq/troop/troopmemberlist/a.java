package com.tencent.mobileqq.troop.troopmemberlist;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.data.troop.TroopMemberNickInfo;
import com.tencent.mobileqq.data.troop.TroopMemberNickSearchInfo;
import com.tencent.mobileqq.data.troop.TroopMemberNickUIInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.memberlist.AddFrdHelper;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b)\b\u0086\b\u0018\u0000 D2\u00020\u0001:\u0001\rB\u0087\u0001\b\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u001f\u001a\u00020\u0018\u0012\f\u0010(\u001a\b\u0012\u0004\u0012\u00020!0 \u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010!\u0012\b\b\u0002\u00102\u001a\u00020\u0002\u0012\b\b\u0002\u00105\u001a\u00020\u0002\u0012\b\b\u0002\u00108\u001a\u00020\u0002\u0012\b\b\u0002\u0010>\u001a\u00020\n\u0012\b\b\u0002\u0010C\u001a\u00020\u0007\u0012\b\b\u0002\u0010E\u001a\u00020\u0007\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\bH\u0010IJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\t\u0010\u0006\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u001f\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR(\u0010(\u001a\b\u0012\u0004\u0012\u00020!0 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010/\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0017\u00102\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u00100\u001a\u0004\b\u0019\u00101R\"\u00105\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u00100\u001a\u0004\b\u0013\u00101\"\u0004\b3\u00104R\"\u00108\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u00100\u001a\u0004\b)\u00101\"\u0004\b7\u00104R\"\u0010>\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010C\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010?\u001a\u0004\b6\u0010@\"\u0004\bA\u0010BR\"\u0010E\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010?\u001a\u0004\b\r\u0010@\"\u0004\bD\u0010BR$\u0010G\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u00100\u001a\u0004\b\"\u00101\"\u0004\bF\u00104\u00a8\u0006J"}, d2 = {"Lcom/tencent/mobileqq/troop/troopmemberlist/a;", "", "", "j", "", "k", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "a", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "f", "()Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "memberInfo", "Lcom/tencent/mobileqq/data/DiscussionMemberInfo;", "b", "Lcom/tencent/mobileqq/data/DiscussionMemberInfo;", "getDiscussionMemberInfo", "()Lcom/tencent/mobileqq/data/DiscussionMemberInfo;", "discussionMemberInfo", "Lcom/tencent/mobileqq/data/troop/TroopMemberNickUIInfo;", "c", "Lcom/tencent/mobileqq/data/troop/TroopMemberNickUIInfo;", "i", "()Lcom/tencent/mobileqq/data/troop/TroopMemberNickUIInfo;", "setUiInfo", "(Lcom/tencent/mobileqq/data/troop/TroopMemberNickUIInfo;)V", "uiInfo", "", "Lcom/tencent/mobileqq/data/troop/c;", "d", "Ljava/util/List;", "g", "()Ljava/util/List;", "setSearchInfo", "(Ljava/util/List;)V", "searchInfo", "e", "Lcom/tencent/mobileqq/data/troop/c;", "getSearchResult", "()Lcom/tencent/mobileqq/data/troop/c;", "r", "(Lcom/tencent/mobileqq/data/troop/c;)V", "searchResult", "Ljava/lang/String;", "()Ljava/lang/String;", "friendRemark", DomainData.DOMAIN_NAME, "(Ljava/lang/String;)V", "addTroopDateStr", h.F, "p", "lastActiveDateStr", "Z", "l", "()Z", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Z)V", "isOnline", "I", "()I", ReportConstant.COSTREPORT_PREFIX, "(I)V", "starLeagueScore", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "addFrdState", "o", "inActiveDataStr", "<init>", "(Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;Lcom/tencent/mobileqq/data/DiscussionMemberInfo;Lcom/tencent/mobileqq/data/troop/TroopMemberNickUIInfo;Ljava/util/List;Lcom/tencent/mobileqq/data/troop/c;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZIILjava/lang/String;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final /* data */ class a {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final TroopMemberInfo memberInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final DiscussionMemberInfo discussionMemberInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TroopMemberNickUIInfo uiInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<TroopMemberNickSearchInfo> searchInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TroopMemberNickSearchInfo searchResult;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String friendRemark;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String addTroopDateStr;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String lastActiveDateStr;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isOnline;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private int starLeagueScore;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private int addFrdState;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String inActiveDataStr;

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bJ(\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bJ\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J(\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/troop/troopmemberlist/a$a;", "", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "info", "Lcom/tencent/mobileqq/troop/memberlist/AddFrdHelper;", "addFrdHelper", "", "needColorNick", "Lcom/tencent/mobileqq/troop/troopmemberlist/a;", "a", "d", "Lcom/tencent/mobileqq/data/DiscussionMemberInfo;", "b", "", "troopUin", "uin", "nickName", "c", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopmemberlist.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return;
            }
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final a a(@NotNull QBaseActivity activity, @NotNull TroopMemberInfo info, @Nullable AddFrdHelper addFrdHelper, boolean needColorNick) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, this, activity, info, addFrdHelper, Boolean.valueOf(needColorNick));
            }
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(info, "info");
            DiscussionMemberInfo discussionMemberInfo = null;
            TroopMemberNickUIInfo uIInfo = info.nickInfo.getUIInfo(needColorNick, true);
            List<TroopMemberNickSearchInfo> searchInfo = info.nickInfo.getSearchInfo(needColorNick, true);
            TroopMemberNickSearchInfo troopMemberNickSearchInfo = null;
            String remarkFromFriend = info.nickInfo.getRemarkFromFriend();
            g gVar = g.f300632a;
            String f16 = gVar.f(activity, info.join_time);
            String h16 = gVar.h(activity, info.last_active_time);
            boolean z16 = false;
            int i16 = 0;
            if (addFrdHelper != null) {
                i3 = addFrdHelper.d(info.memberuin);
            } else {
                i3 = 0;
            }
            return new a(info, discussionMemberInfo, uIInfo, searchInfo, troopMemberNickSearchInfo, remarkFromFriend, f16, h16, z16, i16, i3, null, 2832, null);
        }

        @NotNull
        public final a b(@NotNull DiscussionMemberInfo info, @Nullable AddFrdHelper addFrdHelper) {
            String str;
            String str2;
            String str3;
            String str4;
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (a) iPatchRedirector.redirect((short) 4, (Object) this, (Object) info, (Object) addFrdHelper);
            }
            Intrinsics.checkNotNullParameter(info, "info");
            String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(info.memberUin);
            String str5 = info.discussionUin;
            if (str5 == null) {
                str = "";
            } else {
                str = str5;
            }
            String str6 = info.memberUin;
            if (str6 == null) {
                str2 = "";
            } else {
                str2 = str6;
            }
            Intrinsics.checkNotNullExpressionValue(uid, "uid");
            String str7 = "";
            int i16 = 0;
            String str8 = info.memberName;
            if (str8 == null) {
                str3 = "";
            } else {
                str3 = str8;
            }
            String str9 = info.inteRemark;
            if (str9 == null) {
                str4 = "";
            } else {
                str4 = str9;
            }
            TroopMemberNickInfo troopMemberNickInfo = new TroopMemberNickInfo(str, str2, uid, str7, i16, str3, str4, "", null, null, null, 1792, null);
            TroopMemberInfo troopMemberInfo = null;
            TroopMemberNickUIInfo uIInfo = troopMemberNickInfo.getUIInfo();
            List<TroopMemberNickSearchInfo> searchInfo = troopMemberNickInfo.getSearchInfo();
            TroopMemberNickSearchInfo troopMemberNickSearchInfo = null;
            String remarkFromFriend = troopMemberNickInfo.getRemarkFromFriend();
            String str10 = null;
            String str11 = null;
            boolean z16 = false;
            int i17 = 0;
            if (addFrdHelper != null) {
                i3 = addFrdHelper.d(info.memberUin);
            } else {
                i3 = 0;
            }
            return new a(troopMemberInfo, info, uIInfo, searchInfo, troopMemberNickSearchInfo, remarkFromFriend, str10, str11, z16, i17, i3, null, 3024, null);
        }

        @NotNull
        public final a c(@NotNull String troopUin, @NotNull String uin, @NotNull String nickName, @Nullable AddFrdHelper addFrdHelper) {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i3 = 0;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (a) iPatchRedirector.redirect((short) 5, this, troopUin, uin, nickName, addFrdHelper);
            }
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            Intrinsics.checkNotNullParameter(uin, "uin");
            Intrinsics.checkNotNullParameter(nickName, "nickName");
            String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(uin);
            Intrinsics.checkNotNullExpressionValue(uid, "uid");
            TroopMemberNickInfo troopMemberNickInfo = new TroopMemberNickInfo(troopUin, uin, uid, "", 0, nickName, "", "", null, null, null, 1792, null);
            TroopMemberInfo troopMemberInfo = null;
            DiscussionMemberInfo discussionMemberInfo = null;
            TroopMemberNickUIInfo uIInfo = troopMemberNickInfo.getUIInfo();
            List<TroopMemberNickSearchInfo> searchInfo = troopMemberNickInfo.getSearchInfo();
            TroopMemberNickSearchInfo troopMemberNickSearchInfo = null;
            String remarkFromFriend = troopMemberNickInfo.getRemarkFromFriend();
            String str = null;
            String str2 = null;
            boolean z16 = false;
            int i16 = 0;
            if (addFrdHelper != null) {
                i3 = addFrdHelper.d(uin);
            }
            return new a(troopMemberInfo, discussionMemberInfo, uIInfo, searchInfo, troopMemberNickSearchInfo, remarkFromFriend, str, str2, z16, i16, i3, null, 3024, null);
        }

        @NotNull
        public final a d(@NotNull QBaseActivity activity, @NotNull TroopMemberInfo info, @Nullable AddFrdHelper addFrdHelper, boolean needColorNick) {
            List emptyList;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (a) iPatchRedirector.redirect((short) 3, this, activity, info, addFrdHelper, Boolean.valueOf(needColorNick));
            }
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(info, "info");
            TroopMemberNickUIInfo uIInfoV2 = info.nickInfo.getUIInfoV2(needColorNick, true, true, false);
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return new a(info, null, uIInfoV2, emptyList, null, info.nickInfo.getRemarkFromFriendV2(), "", "", false, 0, -1, null, 2832, null);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58531);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 42)) {
            redirector.redirect((short) 42);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    a(TroopMemberInfo troopMemberInfo, DiscussionMemberInfo discussionMemberInfo, TroopMemberNickUIInfo troopMemberNickUIInfo, List<TroopMemberNickSearchInfo> list, TroopMemberNickSearchInfo troopMemberNickSearchInfo, String str, String str2, String str3, boolean z16, int i3, int i16, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, troopMemberInfo, discussionMemberInfo, troopMemberNickUIInfo, list, troopMemberNickSearchInfo, str, str2, str3, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), str4);
            return;
        }
        this.memberInfo = troopMemberInfo;
        this.discussionMemberInfo = discussionMemberInfo;
        this.uiInfo = troopMemberNickUIInfo;
        this.searchInfo = list;
        this.searchResult = troopMemberNickSearchInfo;
        this.friendRemark = str;
        this.addTroopDateStr = str2;
        this.lastActiveDateStr = str3;
        this.isOnline = z16;
        this.starLeagueScore = i3;
        this.addFrdState = i16;
        this.inActiveDataStr = str4;
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        return this.addFrdState;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.addTroopDateStr;
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.friendRemark;
    }

    @Nullable
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return this.inActiveDataStr;
    }

    @NotNull
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.lastActiveDateStr;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Boolean) iPatchRedirector.redirect((short) 41, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (Intrinsics.areEqual(this.memberInfo, aVar.memberInfo) && Intrinsics.areEqual(this.discussionMemberInfo, aVar.discussionMemberInfo) && Intrinsics.areEqual(this.uiInfo, aVar.uiInfo) && Intrinsics.areEqual(this.searchInfo, aVar.searchInfo) && Intrinsics.areEqual(this.searchResult, aVar.searchResult) && Intrinsics.areEqual(this.friendRemark, aVar.friendRemark) && Intrinsics.areEqual(this.addTroopDateStr, aVar.addTroopDateStr) && Intrinsics.areEqual(this.lastActiveDateStr, aVar.lastActiveDateStr) && this.isOnline == aVar.isOnline && this.starLeagueScore == aVar.starLeagueScore && this.addFrdState == aVar.addFrdState && Intrinsics.areEqual(this.inActiveDataStr, aVar.inActiveDataStr)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final TroopMemberInfo f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TroopMemberInfo) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.memberInfo;
    }

    @NotNull
    public final List<TroopMemberNickSearchInfo> g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (List) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.searchInfo;
    }

    public final int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        return this.starLeagueScore;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Integer) iPatchRedirector.redirect((short) 40, (Object) this)).intValue();
        }
        TroopMemberInfo troopMemberInfo = this.memberInfo;
        int i3 = 0;
        if (troopMemberInfo == null) {
            hashCode = 0;
        } else {
            hashCode = troopMemberInfo.hashCode();
        }
        int i16 = hashCode * 31;
        DiscussionMemberInfo discussionMemberInfo = this.discussionMemberInfo;
        if (discussionMemberInfo == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = discussionMemberInfo.hashCode();
        }
        int hashCode4 = (((((i16 + hashCode2) * 31) + this.uiInfo.hashCode()) * 31) + this.searchInfo.hashCode()) * 31;
        TroopMemberNickSearchInfo troopMemberNickSearchInfo = this.searchResult;
        if (troopMemberNickSearchInfo == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = troopMemberNickSearchInfo.hashCode();
        }
        int hashCode5 = (((((((hashCode4 + hashCode3) * 31) + this.friendRemark.hashCode()) * 31) + this.addTroopDateStr.hashCode()) * 31) + this.lastActiveDateStr.hashCode()) * 31;
        boolean z16 = this.isOnline;
        int i17 = z16;
        if (z16 != 0) {
            i17 = 1;
        }
        int i18 = (((((hashCode5 + i17) * 31) + this.starLeagueScore) * 31) + this.addFrdState) * 31;
        String str = this.inActiveDataStr;
        if (str != null) {
            i3 = str.hashCode();
        }
        return i18 + i3;
    }

    @NotNull
    public final TroopMemberNickUIInfo i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (TroopMemberNickUIInfo) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.uiInfo;
    }

    @NotNull
    public final String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (String) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return this.uiInfo.getUin();
    }

    public final void k() {
        List<TroopMemberNickSearchInfo> emptyList;
        TroopMemberNickInfo troopMemberNickInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        TroopMemberInfo troopMemberInfo = this.memberInfo;
        if (troopMemberInfo == null || (troopMemberNickInfo = troopMemberInfo.nickInfo) == null || (emptyList = troopMemberNickInfo.getSearchInfo(false, true)) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        this.searchInfo = emptyList;
    }

    public final boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return this.isOnline;
    }

    public final void m(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
        } else {
            this.addFrdState = i3;
        }
    }

    public final void n(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.addTroopDateStr = str;
        }
    }

    public final void o(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) str);
        } else {
            this.inActiveDataStr = str;
        }
    }

    public final void p(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.lastActiveDateStr = str;
        }
    }

    public final void q(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, z16);
        } else {
            this.isOnline = z16;
        }
    }

    public final void r(@Nullable TroopMemberNickSearchInfo troopMemberNickSearchInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) troopMemberNickSearchInfo);
        } else {
            this.searchResult = troopMemberNickSearchInfo;
        }
    }

    public final void s(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
        } else {
            this.starLeagueScore = i3;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return (String) iPatchRedirector.redirect((short) 39, (Object) this);
        }
        return "TroopMemberListItemInfo(memberInfo=" + this.memberInfo + ", discussionMemberInfo=" + this.discussionMemberInfo + ", uiInfo=" + this.uiInfo + ", searchInfo=" + this.searchInfo + ", searchResult=" + this.searchResult + ", friendRemark=" + this.friendRemark + ", addTroopDateStr=" + this.addTroopDateStr + ", lastActiveDateStr=" + this.lastActiveDateStr + ", isOnline=" + this.isOnline + ", starLeagueScore=" + this.starLeagueScore + ", addFrdState=" + this.addFrdState + ", inActiveDataStr=" + this.inActiveDataStr + ")";
    }

    /* synthetic */ a(TroopMemberInfo troopMemberInfo, DiscussionMemberInfo discussionMemberInfo, TroopMemberNickUIInfo troopMemberNickUIInfo, List list, TroopMemberNickSearchInfo troopMemberNickSearchInfo, String str, String str2, String str3, boolean z16, int i3, int i16, String str4, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(troopMemberInfo, discussionMemberInfo, troopMemberNickUIInfo, list, (i17 & 16) != 0 ? null : troopMemberNickSearchInfo, (i17 & 32) != 0 ? "" : str, (i17 & 64) != 0 ? "" : str2, (i17 & 128) != 0 ? "" : str3, (i17 & 256) != 0 ? false : z16, (i17 & 512) != 0 ? 0 : i3, (i17 & 1024) != 0 ? 0 : i16, (i17 & 2048) != 0 ? "" : str4);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, troopMemberInfo, discussionMemberInfo, troopMemberNickUIInfo, list, troopMemberNickSearchInfo, str, str2, str3, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), str4, Integer.valueOf(i17), defaultConstructorMarker);
    }
}

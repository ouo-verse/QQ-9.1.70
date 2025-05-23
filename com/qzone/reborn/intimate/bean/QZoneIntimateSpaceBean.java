package com.qzone.reborn.intimate.bean;

import com.qzone.common.account.LoginData;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.model.n;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mk.d;
import oj.a;
import qzone.QZIntimateCheckIn$CheckinCalendar;
import qzone.QZIntimateSpaceMedal$MainPageMedalDetail;
import qzone.QZIntimateSpaceReader$ActiveGuideInfo;
import qzone.QZIntimateSpaceReader$GetSpaceMainPageHeadRsp;
import qzone.QZIntimateSpaceReader$MenuItem;
import qzone.QZIntimateSpaceReader$PHShareStatus;
import qzone.QZoneBaseCommon$StCommonExt;
import qzone.QZoneBaseMeta$StButton;
import qzone.QZoneBaseMeta$StUser;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u0000\n\u0002\bZ\b\u0086\b\u0018\u0000 \u00a8\u00012\u00020\u0001:\u0002\u00a9\u0001B\u00c9\u0002\u0012\b\b\u0002\u00101\u001a\u00020\u0004\u0012\u000e\b\u0002\u00102\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u000e\b\u0002\u00103\u001a\b\u0012\u0004\u0012\u00020\r0\n\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u00105\u001a\u00020\u0004\u0012\b\b\u0002\u00106\u001a\u00020\u0004\u0012\b\b\u0002\u00107\u001a\u00020\u0004\u0012\b\b\u0002\u00108\u001a\u00020\u0014\u0012\b\b\u0002\u00109\u001a\u00020\u0004\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010;\u001a\u00020\u0004\u0012\b\b\u0002\u0010<\u001a\u00020\u0004\u0012\b\b\u0002\u0010=\u001a\u00020\u0014\u0012\b\b\u0002\u0010>\u001a\u00020\u001c\u0012\b\b\u0002\u0010?\u001a\u00020\u0014\u0012\b\b\u0002\u0010@\u001a\u00020\u0002\u0012\b\b\u0002\u0010A\u001a\u00020\u001c\u0012\b\b\u0002\u0010B\u001a\u00020\u0002\u0012\b\b\u0002\u0010C\u001a\u00020\u0002\u0012\b\b\u0002\u0010D\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00040$\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010&\u0012\u000e\b\u0002\u0010G\u001a\b\u0012\u0004\u0012\u00020\u000f0$\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010)\u0012\b\b\u0002\u0010I\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010J\u001a\b\u0012\u0004\u0012\u00020,0$\u0012\n\b\u0002\u0010K\u001a\u0004\u0018\u00010.\u0012\b\b\u0002\u0010L\u001a\u00020\u0014\u00a2\u0006\u0006\b\u00a6\u0001\u0010\u00a7\u0001J\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002J\t\u0010\t\u001a\u00020\u0004H\u00c6\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u00c6\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\nH\u00c6\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0014H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0004H\u00c6\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0014H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u001cH\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0014H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0002H\u00c6\u0003J\t\u0010 \u001a\u00020\u001cH\u00c6\u0003J\t\u0010!\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0002H\u00c6\u0003J\t\u0010#\u001a\u00020\u0002H\u00c6\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040$H\u00c6\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010&H\u00c6\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000f0$H\u00c6\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010)H\u00c6\u0003J\t\u0010+\u001a\u00020\u0002H\u00c6\u0003J\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00020,0$H\u00c6\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010.H\u00c6\u0003J\t\u00100\u001a\u00020\u0014H\u00c6\u0003J\u00c9\u0002\u0010M\u001a\u00020\u00002\b\b\u0002\u00101\u001a\u00020\u00042\u000e\b\u0002\u00102\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u000e\b\u0002\u00103\u001a\b\u0012\u0004\u0012\u00020\r0\n2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u00105\u001a\u00020\u00042\b\b\u0002\u00106\u001a\u00020\u00042\b\b\u0002\u00107\u001a\u00020\u00042\b\b\u0002\u00108\u001a\u00020\u00142\b\b\u0002\u00109\u001a\u00020\u00042\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010;\u001a\u00020\u00042\b\b\u0002\u0010<\u001a\u00020\u00042\b\b\u0002\u0010=\u001a\u00020\u00142\b\b\u0002\u0010>\u001a\u00020\u001c2\b\b\u0002\u0010?\u001a\u00020\u00142\b\b\u0002\u0010@\u001a\u00020\u00022\b\b\u0002\u0010A\u001a\u00020\u001c2\b\b\u0002\u0010B\u001a\u00020\u00022\b\b\u0002\u0010C\u001a\u00020\u00022\b\b\u0002\u0010D\u001a\u00020\u00022\u000e\b\u0002\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00040$2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010&2\u000e\b\u0002\u0010G\u001a\b\u0012\u0004\u0012\u00020\u000f0$2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010)2\b\b\u0002\u0010I\u001a\u00020\u00022\u000e\b\u0002\u0010J\u001a\b\u0012\u0004\u0012\u00020,0$2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010.2\b\b\u0002\u0010L\u001a\u00020\u0014H\u00c6\u0001J\t\u0010N\u001a\u00020\u0004H\u00d6\u0001J\t\u0010O\u001a\u00020\u0014H\u00d6\u0001J\u0013\u0010R\u001a\u00020\u00022\b\u0010Q\u001a\u0004\u0018\u00010PH\u00d6\u0003R\"\u00101\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR(\u00102\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R(\u00103\u001a\b\u0012\u0004\u0012\u00020\r0\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010X\u001a\u0004\b]\u0010Z\"\u0004\b^\u0010\\R$\u00104\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\"\u00105\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010S\u001a\u0004\bd\u0010U\"\u0004\be\u0010WR\"\u00106\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010S\u001a\u0004\bf\u0010U\"\u0004\bg\u0010WR\"\u00107\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u0010S\u001a\u0004\bh\u0010U\"\u0004\bi\u0010WR\"\u00108\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u0010j\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\"\u00109\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010S\u001a\u0004\bo\u0010U\"\u0004\bp\u0010WR$\u0010:\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010q\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR\"\u0010;\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010S\u001a\u0004\bv\u0010U\"\u0004\bw\u0010WR\"\u0010<\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010S\u001a\u0004\bx\u0010U\"\u0004\by\u0010WR\"\u0010=\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010j\u001a\u0004\bz\u0010l\"\u0004\b{\u0010nR#\u0010>\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0013\n\u0004\b>\u0010|\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R$\u0010?\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\b?\u0010j\u001a\u0005\b\u0081\u0001\u0010l\"\u0005\b\u0082\u0001\u0010nR'\u0010@\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b@\u0010\u0083\u0001\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001\"\u0006\b\u0086\u0001\u0010\u0087\u0001R%\u0010A\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0004\bA\u0010|\u001a\u0005\b\u0088\u0001\u0010~\"\u0006\b\u0089\u0001\u0010\u0080\u0001R'\u0010B\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\bB\u0010\u0083\u0001\u001a\u0006\b\u008a\u0001\u0010\u0085\u0001\"\u0006\b\u008b\u0001\u0010\u0087\u0001R&\u0010C\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\bC\u0010\u0083\u0001\u001a\u0005\bC\u0010\u0085\u0001\"\u0006\b\u008c\u0001\u0010\u0087\u0001R&\u0010D\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\bD\u0010\u0083\u0001\u001a\u0005\bD\u0010\u0085\u0001\"\u0006\b\u008d\u0001\u0010\u0087\u0001R*\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00040$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\bE\u0010X\u001a\u0005\b\u008e\u0001\u0010Z\"\u0005\b\u008f\u0001\u0010\\R)\u0010F\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\bF\u0010\u0090\u0001\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001\"\u0006\b\u0093\u0001\u0010\u0094\u0001R*\u0010G\u001a\b\u0012\u0004\u0012\u00020\u000f0$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\bG\u0010X\u001a\u0005\b\u0095\u0001\u0010Z\"\u0005\b\u0096\u0001\u0010\\R)\u0010H\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\bH\u0010\u0097\u0001\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001\"\u0006\b\u009a\u0001\u0010\u009b\u0001R&\u0010I\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\bI\u0010\u0083\u0001\u001a\u0005\bI\u0010\u0085\u0001\"\u0006\b\u009c\u0001\u0010\u0087\u0001R*\u0010J\u001a\b\u0012\u0004\u0012\u00020,0$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\bJ\u0010X\u001a\u0005\b\u009d\u0001\u0010Z\"\u0005\b\u009e\u0001\u0010\\R)\u0010K\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\bK\u0010\u009f\u0001\u001a\u0006\b\u00a0\u0001\u0010\u00a1\u0001\"\u0006\b\u00a2\u0001\u0010\u00a3\u0001R$\u0010L\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\bL\u0010j\u001a\u0005\b\u00a4\u0001\u0010l\"\u0005\b\u00a5\u0001\u0010n\u00a8\u0006\u00aa\u0001"}, d2 = {"Lcom/qzone/reborn/intimate/bean/QZoneIntimateSpaceBean;", "Ljava/io/Serializable;", "", "isMasterSpace", "", "uid", "getMemberUid", "supportModifyAnniversary", "isLoveSpace", "component1", "", "Lcom/qzone/proxy/feedcomponent/model/User;", "component2", "Lqzone/QZoneBaseMeta$StUser;", "component3", "Lqzone/QZIntimateSpaceMedal$MainPageMedalDetail;", "component4", "component5", "component6", "component7", "", "component8", "component9", "Lqzone/QZoneBaseMeta$StButton;", "component10", "component11", "component12", "component13", "", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "", "component21", "Lqzone/QZIntimateSpaceReader$ActiveGuideInfo;", "component22", "component23", "Lqzone/QZIntimateCheckIn$CheckinCalendar;", "component24", "component25", "Lqzone/QZIntimateSpaceReader$MenuItem;", "component26", "Lqzone/QZIntimateSpaceReader$PHShareStatus;", "component27", "component28", "title", "members", "stMembers", "medalInfo", "bgImageLight", "bgImageDark", "relationMsg", "relationDays", "relationColorPrimary", "checkInButton", "checkInAnimUrl", "checkInJumpUrl", "spaceType", "checkInDays", "displayRight", "hasCheckInToday", "anniversary", "showOldUserGuideDialog", "isFromRefreshSpace", "isDraft", "iconList", "activateGuideInfo", "animInfoList", "checkInCalendar", "isFromCheckIn", "menuList", "phShareStatus", "checkInAnimLevel", "copy", "toString", "hashCode", "", "other", "equals", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "Ljava/util/List;", "getMembers", "()Ljava/util/List;", "setMembers", "(Ljava/util/List;)V", "getStMembers", "setStMembers", "Lqzone/QZIntimateSpaceMedal$MainPageMedalDetail;", "getMedalInfo", "()Lqzone/QZIntimateSpaceMedal$MainPageMedalDetail;", "setMedalInfo", "(Lqzone/QZIntimateSpaceMedal$MainPageMedalDetail;)V", "getBgImageLight", "setBgImageLight", "getBgImageDark", "setBgImageDark", "getRelationMsg", "setRelationMsg", "I", "getRelationDays", "()I", "setRelationDays", "(I)V", "getRelationColorPrimary", "setRelationColorPrimary", "Lqzone/QZoneBaseMeta$StButton;", "getCheckInButton", "()Lqzone/QZoneBaseMeta$StButton;", "setCheckInButton", "(Lqzone/QZoneBaseMeta$StButton;)V", "getCheckInAnimUrl", "setCheckInAnimUrl", "getCheckInJumpUrl", "setCheckInJumpUrl", "getSpaceType", "setSpaceType", "J", "getCheckInDays", "()J", "setCheckInDays", "(J)V", "getDisplayRight", "setDisplayRight", "Z", "getHasCheckInToday", "()Z", "setHasCheckInToday", "(Z)V", "getAnniversary", "setAnniversary", "getShowOldUserGuideDialog", "setShowOldUserGuideDialog", "setFromRefreshSpace", "setDraft", "getIconList", "setIconList", "Lqzone/QZIntimateSpaceReader$ActiveGuideInfo;", "getActivateGuideInfo", "()Lqzone/QZIntimateSpaceReader$ActiveGuideInfo;", "setActivateGuideInfo", "(Lqzone/QZIntimateSpaceReader$ActiveGuideInfo;)V", "getAnimInfoList", "setAnimInfoList", "Lqzone/QZIntimateCheckIn$CheckinCalendar;", "getCheckInCalendar", "()Lqzone/QZIntimateCheckIn$CheckinCalendar;", "setCheckInCalendar", "(Lqzone/QZIntimateCheckIn$CheckinCalendar;)V", "setFromCheckIn", "getMenuList", "setMenuList", "Lqzone/QZIntimateSpaceReader$PHShareStatus;", "getPhShareStatus", "()Lqzone/QZIntimateSpaceReader$PHShareStatus;", "setPhShareStatus", "(Lqzone/QZIntimateSpaceReader$PHShareStatus;)V", "getCheckInAnimLevel", "setCheckInAnimLevel", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lqzone/QZIntimateSpaceMedal$MainPageMedalDetail;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lqzone/QZoneBaseMeta$StButton;Ljava/lang/String;Ljava/lang/String;IJIZJZZZLjava/util/List;Lqzone/QZIntimateSpaceReader$ActiveGuideInfo;Ljava/util/List;Lqzone/QZIntimateCheckIn$CheckinCalendar;ZLjava/util/List;Lqzone/QZIntimateSpaceReader$PHShareStatus;I)V", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final /* data */ class QZoneIntimateSpaceBean implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private QZIntimateSpaceReader$ActiveGuideInfo activateGuideInfo;
    private List<QZIntimateSpaceMedal$MainPageMedalDetail> animInfoList;
    private long anniversary;
    private String bgImageDark;
    private String bgImageLight;
    private int checkInAnimLevel;
    private String checkInAnimUrl;
    private QZoneBaseMeta$StButton checkInButton;
    private QZIntimateCheckIn$CheckinCalendar checkInCalendar;
    private long checkInDays;
    private String checkInJumpUrl;
    private int displayRight;
    private boolean hasCheckInToday;
    private List<String> iconList;
    private boolean isDraft;
    private boolean isFromCheckIn;
    private boolean isFromRefreshSpace;
    private QZIntimateSpaceMedal$MainPageMedalDetail medalInfo;
    private List<? extends User> members;
    private List<QZIntimateSpaceReader$MenuItem> menuList;
    private QZIntimateSpaceReader$PHShareStatus phShareStatus;
    private String relationColorPrimary;
    private int relationDays;
    private String relationMsg;
    private boolean showOldUserGuideDialog;
    private int spaceType;
    private List<QZoneBaseMeta$StUser> stMembers;
    private String title;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\b"}, d2 = {"Lcom/qzone/reborn/intimate/bean/QZoneIntimateSpaceBean$a;", "", "Lqzone/QZIntimateSpaceReader$GetSpaceMainPageHeadRsp;", "rsp", "Lcom/qzone/reborn/intimate/bean/QZoneIntimateSpaceBean;", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.intimate.bean.QZoneIntimateSpaceBean$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }

        public final QZoneIntimateSpaceBean a(QZIntimateSpaceReader$GetSpaceMainPageHeadRsp rsp) {
            if (rsp == null) {
                return null;
            }
            QZoneIntimateSpaceBean qZoneIntimateSpaceBean = new QZoneIntimateSpaceBean(null, null, null, null, null, null, null, 0, null, null, null, null, 0, 0L, 0, false, 0L, false, false, false, null, null, null, null, false, null, null, 0, 268435455);
            String str = rsp.title.get();
            Intrinsics.checkNotNullExpressionValue(str, "rsp.title.get()");
            qZoneIntimateSpaceBean.setTitle(str);
            a aVar = a.f423008a;
            List<QZoneBaseMeta$StUser> list = rsp.members.get();
            QZoneBaseCommon$StCommonExt qZoneBaseCommon$StCommonExt = rsp.ext;
            Intrinsics.checkNotNullExpressionValue(qZoneBaseCommon$StCommonExt, "rsp.ext");
            qZoneIntimateSpaceBean.setMembers(aVar.a0(list, qZoneBaseCommon$StCommonExt));
            List<QZoneBaseMeta$StUser> list2 = rsp.members.get();
            Intrinsics.checkNotNullExpressionValue(list2, "rsp.members.get()");
            qZoneIntimateSpaceBean.setStMembers(list2);
            qZoneIntimateSpaceBean.setCheckInButton(rsp.checkin_info.checkin_in_btn.get());
            String str2 = rsp.checkin_info.animation_url.get();
            Intrinsics.checkNotNullExpressionValue(str2, "rsp.checkin_info.animation_url.get()");
            qZoneIntimateSpaceBean.setCheckInAnimUrl(str2);
            String str3 = rsp.checkin_info.detail_page_url.get();
            Intrinsics.checkNotNullExpressionValue(str3, "rsp.checkin_info.detail_page_url.get()");
            qZoneIntimateSpaceBean.setCheckInJumpUrl(str3);
            qZoneIntimateSpaceBean.setMedalInfo(rsp.medalInfo.get());
            String str4 = rsp.bg_image_light.get();
            Intrinsics.checkNotNullExpressionValue(str4, "rsp.bg_image_light.get()");
            qZoneIntimateSpaceBean.setBgImageLight(str4);
            String str5 = rsp.bg_image_dark.get();
            Intrinsics.checkNotNullExpressionValue(str5, "rsp.bg_image_dark.get()");
            qZoneIntimateSpaceBean.setBgImageDark(str5);
            String str6 = rsp.relation_msg.get();
            Intrinsics.checkNotNullExpressionValue(str6, "rsp.relation_msg.get()");
            qZoneIntimateSpaceBean.setRelationMsg(str6);
            qZoneIntimateSpaceBean.setRelationDays(rsp.relation_days.get());
            String str7 = rsp.relation_days_color.get();
            Intrinsics.checkNotNullExpressionValue(str7, "rsp.relation_days_color.get()");
            qZoneIntimateSpaceBean.setRelationColorPrimary(str7);
            qZoneIntimateSpaceBean.setSpaceType(rsp.space_type.get());
            qZoneIntimateSpaceBean.setCheckInDays(rsp.checkin_info.days.get());
            qZoneIntimateSpaceBean.setDisplayRight(rsp.display_right.get());
            qZoneIntimateSpaceBean.setHasCheckInToday(rsp.checkin_info.done_today.get());
            qZoneIntimateSpaceBean.setAnniversary(rsp.anniversary_timestamp.get());
            qZoneIntimateSpaceBean.setShowOldUserGuideDialog(rsp.show_sweet_old_user_guide_pop.get());
            qZoneIntimateSpaceBean.setFromRefreshSpace(true);
            qZoneIntimateSpaceBean.setFromCheckIn(false);
            qZoneIntimateSpaceBean.setIconList(aVar.u(rsp, rsp.space_type.get()));
            qZoneIntimateSpaceBean.setActivateGuideInfo(rsp.guide_info.get());
            List<QZIntimateSpaceMedal$MainPageMedalDetail> list3 = rsp.animationInfo.get();
            Intrinsics.checkNotNullExpressionValue(list3, "rsp.animationInfo.get()");
            qZoneIntimateSpaceBean.setAnimInfoList(list3);
            List<QZIntimateSpaceReader$MenuItem> list4 = rsp.menu.get();
            Intrinsics.checkNotNullExpressionValue(list4, "rsp.menu.get()");
            qZoneIntimateSpaceBean.setMenuList(list4);
            qZoneIntimateSpaceBean.setPhShareStatus(rsp.phs_status.get());
            qZoneIntimateSpaceBean.setCheckInAnimLevel(d.f416875a.j(rsp.checkin_info.days.get()));
            RFWLog.i("QZoneIntimateSpaceBean", RFWLog.USR, "relation_days is " + rsp.relation_days.get());
            return qZoneIntimateSpaceBean;
        }
    }

    public QZoneIntimateSpaceBean() {
        this(null, null, null, null, null, null, null, 0, null, null, null, null, 0, 0L, 0, false, 0L, false, false, false, null, null, null, null, false, null, null, 0, 268435455);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component10, reason: from getter */
    public final QZoneBaseMeta$StButton getCheckInButton() {
        return this.checkInButton;
    }

    /* renamed from: component11, reason: from getter */
    public final String getCheckInAnimUrl() {
        return this.checkInAnimUrl;
    }

    /* renamed from: component12, reason: from getter */
    public final String getCheckInJumpUrl() {
        return this.checkInJumpUrl;
    }

    /* renamed from: component13, reason: from getter */
    public final int getSpaceType() {
        return this.spaceType;
    }

    /* renamed from: component14, reason: from getter */
    public final long getCheckInDays() {
        return this.checkInDays;
    }

    /* renamed from: component15, reason: from getter */
    public final int getDisplayRight() {
        return this.displayRight;
    }

    /* renamed from: component16, reason: from getter */
    public final boolean getHasCheckInToday() {
        return this.hasCheckInToday;
    }

    /* renamed from: component17, reason: from getter */
    public final long getAnniversary() {
        return this.anniversary;
    }

    /* renamed from: component18, reason: from getter */
    public final boolean getShowOldUserGuideDialog() {
        return this.showOldUserGuideDialog;
    }

    /* renamed from: component19, reason: from getter */
    public final boolean getIsFromRefreshSpace() {
        return this.isFromRefreshSpace;
    }

    public final List<User> component2() {
        return this.members;
    }

    /* renamed from: component20, reason: from getter */
    public final boolean getIsDraft() {
        return this.isDraft;
    }

    public final List<String> component21() {
        return this.iconList;
    }

    /* renamed from: component22, reason: from getter */
    public final QZIntimateSpaceReader$ActiveGuideInfo getActivateGuideInfo() {
        return this.activateGuideInfo;
    }

    public final List<QZIntimateSpaceMedal$MainPageMedalDetail> component23() {
        return this.animInfoList;
    }

    /* renamed from: component24, reason: from getter */
    public final QZIntimateCheckIn$CheckinCalendar getCheckInCalendar() {
        return this.checkInCalendar;
    }

    /* renamed from: component25, reason: from getter */
    public final boolean getIsFromCheckIn() {
        return this.isFromCheckIn;
    }

    public final List<QZIntimateSpaceReader$MenuItem> component26() {
        return this.menuList;
    }

    /* renamed from: component27, reason: from getter */
    public final QZIntimateSpaceReader$PHShareStatus getPhShareStatus() {
        return this.phShareStatus;
    }

    /* renamed from: component28, reason: from getter */
    public final int getCheckInAnimLevel() {
        return this.checkInAnimLevel;
    }

    public final List<QZoneBaseMeta$StUser> component3() {
        return this.stMembers;
    }

    /* renamed from: component4, reason: from getter */
    public final QZIntimateSpaceMedal$MainPageMedalDetail getMedalInfo() {
        return this.medalInfo;
    }

    /* renamed from: component5, reason: from getter */
    public final String getBgImageLight() {
        return this.bgImageLight;
    }

    /* renamed from: component6, reason: from getter */
    public final String getBgImageDark() {
        return this.bgImageDark;
    }

    /* renamed from: component7, reason: from getter */
    public final String getRelationMsg() {
        return this.relationMsg;
    }

    /* renamed from: component8, reason: from getter */
    public final int getRelationDays() {
        return this.relationDays;
    }

    /* renamed from: component9, reason: from getter */
    public final String getRelationColorPrimary() {
        return this.relationColorPrimary;
    }

    public final QZoneIntimateSpaceBean copy(String title, List<? extends User> members, List<QZoneBaseMeta$StUser> stMembers, QZIntimateSpaceMedal$MainPageMedalDetail medalInfo, String bgImageLight, String bgImageDark, String relationMsg, int relationDays, String relationColorPrimary, QZoneBaseMeta$StButton checkInButton, String checkInAnimUrl, String checkInJumpUrl, int spaceType, long checkInDays, int displayRight, boolean hasCheckInToday, long anniversary, boolean showOldUserGuideDialog, boolean isFromRefreshSpace, boolean isDraft, List<String> iconList, QZIntimateSpaceReader$ActiveGuideInfo activateGuideInfo, List<QZIntimateSpaceMedal$MainPageMedalDetail> animInfoList, QZIntimateCheckIn$CheckinCalendar checkInCalendar, boolean isFromCheckIn, List<QZIntimateSpaceReader$MenuItem> menuList, QZIntimateSpaceReader$PHShareStatus phShareStatus, int checkInAnimLevel) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(members, "members");
        Intrinsics.checkNotNullParameter(stMembers, "stMembers");
        Intrinsics.checkNotNullParameter(bgImageLight, "bgImageLight");
        Intrinsics.checkNotNullParameter(bgImageDark, "bgImageDark");
        Intrinsics.checkNotNullParameter(relationMsg, "relationMsg");
        Intrinsics.checkNotNullParameter(relationColorPrimary, "relationColorPrimary");
        Intrinsics.checkNotNullParameter(checkInAnimUrl, "checkInAnimUrl");
        Intrinsics.checkNotNullParameter(checkInJumpUrl, "checkInJumpUrl");
        Intrinsics.checkNotNullParameter(iconList, "iconList");
        Intrinsics.checkNotNullParameter(animInfoList, "animInfoList");
        Intrinsics.checkNotNullParameter(menuList, "menuList");
        return new QZoneIntimateSpaceBean(title, members, stMembers, medalInfo, bgImageLight, bgImageDark, relationMsg, relationDays, relationColorPrimary, checkInButton, checkInAnimUrl, checkInJumpUrl, spaceType, checkInDays, displayRight, hasCheckInToday, anniversary, showOldUserGuideDialog, isFromRefreshSpace, isDraft, iconList, activateGuideInfo, animInfoList, checkInCalendar, isFromCheckIn, menuList, phShareStatus, checkInAnimLevel);
    }

    public final QZIntimateSpaceReader$ActiveGuideInfo getActivateGuideInfo() {
        return this.activateGuideInfo;
    }

    public final List<QZIntimateSpaceMedal$MainPageMedalDetail> getAnimInfoList() {
        return this.animInfoList;
    }

    public final long getAnniversary() {
        return this.anniversary;
    }

    public final String getBgImageDark() {
        return this.bgImageDark;
    }

    public final String getBgImageLight() {
        return this.bgImageLight;
    }

    public final int getCheckInAnimLevel() {
        return this.checkInAnimLevel;
    }

    public final String getCheckInAnimUrl() {
        return this.checkInAnimUrl;
    }

    public final QZoneBaseMeta$StButton getCheckInButton() {
        return this.checkInButton;
    }

    public final QZIntimateCheckIn$CheckinCalendar getCheckInCalendar() {
        return this.checkInCalendar;
    }

    public final long getCheckInDays() {
        return this.checkInDays;
    }

    public final String getCheckInJumpUrl() {
        return this.checkInJumpUrl;
    }

    public final int getDisplayRight() {
        return this.displayRight;
    }

    public final boolean getHasCheckInToday() {
        return this.hasCheckInToday;
    }

    public final List<String> getIconList() {
        return this.iconList;
    }

    public final QZIntimateSpaceMedal$MainPageMedalDetail getMedalInfo() {
        return this.medalInfo;
    }

    public final String getMemberUid(String uid) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        List<? extends User> list = this.members;
        if (list == null) {
            return null;
        }
        for (User user : list) {
            if (!Intrinsics.areEqual(user.uid, uid)) {
                return user.uid;
            }
        }
        return null;
    }

    public final List<User> getMembers() {
        return this.members;
    }

    public final List<QZIntimateSpaceReader$MenuItem> getMenuList() {
        return this.menuList;
    }

    public final QZIntimateSpaceReader$PHShareStatus getPhShareStatus() {
        return this.phShareStatus;
    }

    public final String getRelationColorPrimary() {
        return this.relationColorPrimary;
    }

    public final int getRelationDays() {
        return this.relationDays;
    }

    public final String getRelationMsg() {
        return this.relationMsg;
    }

    public final boolean getShowOldUserGuideDialog() {
        return this.showOldUserGuideDialog;
    }

    public final int getSpaceType() {
        return this.spaceType;
    }

    public final List<QZoneBaseMeta$StUser> getStMembers() {
        return this.stMembers;
    }

    public final String getTitle() {
        return this.title;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.title.hashCode() * 31) + this.members.hashCode()) * 31) + this.stMembers.hashCode()) * 31;
        QZIntimateSpaceMedal$MainPageMedalDetail qZIntimateSpaceMedal$MainPageMedalDetail = this.medalInfo;
        int hashCode2 = (((((((((((hashCode + (qZIntimateSpaceMedal$MainPageMedalDetail == null ? 0 : qZIntimateSpaceMedal$MainPageMedalDetail.hashCode())) * 31) + this.bgImageLight.hashCode()) * 31) + this.bgImageDark.hashCode()) * 31) + this.relationMsg.hashCode()) * 31) + this.relationDays) * 31) + this.relationColorPrimary.hashCode()) * 31;
        QZoneBaseMeta$StButton qZoneBaseMeta$StButton = this.checkInButton;
        int hashCode3 = (((((((((((hashCode2 + (qZoneBaseMeta$StButton == null ? 0 : qZoneBaseMeta$StButton.hashCode())) * 31) + this.checkInAnimUrl.hashCode()) * 31) + this.checkInJumpUrl.hashCode()) * 31) + this.spaceType) * 31) + n.a(this.checkInDays)) * 31) + this.displayRight) * 31;
        boolean z16 = this.hasCheckInToday;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int a16 = (((hashCode3 + i3) * 31) + n.a(this.anniversary)) * 31;
        boolean z17 = this.showOldUserGuideDialog;
        int i16 = z17;
        if (z17 != 0) {
            i16 = 1;
        }
        int i17 = (a16 + i16) * 31;
        boolean z18 = this.isFromRefreshSpace;
        int i18 = z18;
        if (z18 != 0) {
            i18 = 1;
        }
        int i19 = (i17 + i18) * 31;
        boolean z19 = this.isDraft;
        int i26 = z19;
        if (z19 != 0) {
            i26 = 1;
        }
        int hashCode4 = (((i19 + i26) * 31) + this.iconList.hashCode()) * 31;
        QZIntimateSpaceReader$ActiveGuideInfo qZIntimateSpaceReader$ActiveGuideInfo = this.activateGuideInfo;
        int hashCode5 = (((hashCode4 + (qZIntimateSpaceReader$ActiveGuideInfo == null ? 0 : qZIntimateSpaceReader$ActiveGuideInfo.hashCode())) * 31) + this.animInfoList.hashCode()) * 31;
        QZIntimateCheckIn$CheckinCalendar qZIntimateCheckIn$CheckinCalendar = this.checkInCalendar;
        int hashCode6 = (hashCode5 + (qZIntimateCheckIn$CheckinCalendar == null ? 0 : qZIntimateCheckIn$CheckinCalendar.hashCode())) * 31;
        boolean z26 = this.isFromCheckIn;
        int hashCode7 = (((hashCode6 + (z26 ? 1 : z26 ? 1 : 0)) * 31) + this.menuList.hashCode()) * 31;
        QZIntimateSpaceReader$PHShareStatus qZIntimateSpaceReader$PHShareStatus = this.phShareStatus;
        return ((hashCode7 + (qZIntimateSpaceReader$PHShareStatus != null ? qZIntimateSpaceReader$PHShareStatus.hashCode() : 0)) * 31) + this.checkInAnimLevel;
    }

    public final boolean isDraft() {
        return this.isDraft;
    }

    public final boolean isFromCheckIn() {
        return this.isFromCheckIn;
    }

    public final boolean isFromRefreshSpace() {
        return this.isFromRefreshSpace;
    }

    public final boolean isLoveSpace() {
        int i3 = this.spaceType;
        return i3 == 0 || i3 == 5;
    }

    public final boolean isMasterSpace() {
        List<? extends User> list = this.members;
        if (list == null) {
            return false;
        }
        for (User user : list) {
            if (user.uin == LoginData.getInstance().getUin() || Intrinsics.areEqual(user.uid, LoginData.getInstance().getUid())) {
                return true;
            }
        }
        return false;
    }

    public final void setActivateGuideInfo(QZIntimateSpaceReader$ActiveGuideInfo qZIntimateSpaceReader$ActiveGuideInfo) {
        this.activateGuideInfo = qZIntimateSpaceReader$ActiveGuideInfo;
    }

    public final void setAnimInfoList(List<QZIntimateSpaceMedal$MainPageMedalDetail> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.animInfoList = list;
    }

    public final void setAnniversary(long j3) {
        this.anniversary = j3;
    }

    public final void setBgImageDark(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bgImageDark = str;
    }

    public final void setBgImageLight(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bgImageLight = str;
    }

    public final void setCheckInAnimLevel(int i3) {
        this.checkInAnimLevel = i3;
    }

    public final void setCheckInAnimUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.checkInAnimUrl = str;
    }

    public final void setCheckInButton(QZoneBaseMeta$StButton qZoneBaseMeta$StButton) {
        this.checkInButton = qZoneBaseMeta$StButton;
    }

    public final void setCheckInCalendar(QZIntimateCheckIn$CheckinCalendar qZIntimateCheckIn$CheckinCalendar) {
        this.checkInCalendar = qZIntimateCheckIn$CheckinCalendar;
    }

    public final void setCheckInDays(long j3) {
        this.checkInDays = j3;
    }

    public final void setCheckInJumpUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.checkInJumpUrl = str;
    }

    public final void setDisplayRight(int i3) {
        this.displayRight = i3;
    }

    public final void setDraft(boolean z16) {
        this.isDraft = z16;
    }

    public final void setFromCheckIn(boolean z16) {
        this.isFromCheckIn = z16;
    }

    public final void setFromRefreshSpace(boolean z16) {
        this.isFromRefreshSpace = z16;
    }

    public final void setHasCheckInToday(boolean z16) {
        this.hasCheckInToday = z16;
    }

    public final void setIconList(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.iconList = list;
    }

    public final void setMedalInfo(QZIntimateSpaceMedal$MainPageMedalDetail qZIntimateSpaceMedal$MainPageMedalDetail) {
        this.medalInfo = qZIntimateSpaceMedal$MainPageMedalDetail;
    }

    public final void setMembers(List<? extends User> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.members = list;
    }

    public final void setMenuList(List<QZIntimateSpaceReader$MenuItem> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.menuList = list;
    }

    public final void setPhShareStatus(QZIntimateSpaceReader$PHShareStatus qZIntimateSpaceReader$PHShareStatus) {
        this.phShareStatus = qZIntimateSpaceReader$PHShareStatus;
    }

    public final void setRelationColorPrimary(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.relationColorPrimary = str;
    }

    public final void setRelationDays(int i3) {
        this.relationDays = i3;
    }

    public final void setRelationMsg(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.relationMsg = str;
    }

    public final void setShowOldUserGuideDialog(boolean z16) {
        this.showOldUserGuideDialog = z16;
    }

    public final void setSpaceType(int i3) {
        this.spaceType = i3;
    }

    public final void setStMembers(List<QZoneBaseMeta$StUser> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.stMembers = list;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final boolean supportModifyAnniversary() {
        return isMasterSpace() && d.f416875a.y(Integer.valueOf(this.spaceType));
    }

    public QZoneIntimateSpaceBean(String title, List<? extends User> members, List<QZoneBaseMeta$StUser> stMembers, QZIntimateSpaceMedal$MainPageMedalDetail qZIntimateSpaceMedal$MainPageMedalDetail, String bgImageLight, String bgImageDark, String relationMsg, int i3, String relationColorPrimary, QZoneBaseMeta$StButton qZoneBaseMeta$StButton, String checkInAnimUrl, String checkInJumpUrl, int i16, long j3, int i17, boolean z16, long j16, boolean z17, boolean z18, boolean z19, List<String> iconList, QZIntimateSpaceReader$ActiveGuideInfo qZIntimateSpaceReader$ActiveGuideInfo, List<QZIntimateSpaceMedal$MainPageMedalDetail> animInfoList, QZIntimateCheckIn$CheckinCalendar qZIntimateCheckIn$CheckinCalendar, boolean z26, List<QZIntimateSpaceReader$MenuItem> menuList, QZIntimateSpaceReader$PHShareStatus qZIntimateSpaceReader$PHShareStatus, int i18) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(members, "members");
        Intrinsics.checkNotNullParameter(stMembers, "stMembers");
        Intrinsics.checkNotNullParameter(bgImageLight, "bgImageLight");
        Intrinsics.checkNotNullParameter(bgImageDark, "bgImageDark");
        Intrinsics.checkNotNullParameter(relationMsg, "relationMsg");
        Intrinsics.checkNotNullParameter(relationColorPrimary, "relationColorPrimary");
        Intrinsics.checkNotNullParameter(checkInAnimUrl, "checkInAnimUrl");
        Intrinsics.checkNotNullParameter(checkInJumpUrl, "checkInJumpUrl");
        Intrinsics.checkNotNullParameter(iconList, "iconList");
        Intrinsics.checkNotNullParameter(animInfoList, "animInfoList");
        Intrinsics.checkNotNullParameter(menuList, "menuList");
        this.title = title;
        this.members = members;
        this.stMembers = stMembers;
        this.medalInfo = qZIntimateSpaceMedal$MainPageMedalDetail;
        this.bgImageLight = bgImageLight;
        this.bgImageDark = bgImageDark;
        this.relationMsg = relationMsg;
        this.relationDays = i3;
        this.relationColorPrimary = relationColorPrimary;
        this.checkInButton = qZoneBaseMeta$StButton;
        this.checkInAnimUrl = checkInAnimUrl;
        this.checkInJumpUrl = checkInJumpUrl;
        this.spaceType = i16;
        this.checkInDays = j3;
        this.displayRight = i17;
        this.hasCheckInToday = z16;
        this.anniversary = j16;
        this.showOldUserGuideDialog = z17;
        this.isFromRefreshSpace = z18;
        this.isDraft = z19;
        this.iconList = iconList;
        this.activateGuideInfo = qZIntimateSpaceReader$ActiveGuideInfo;
        this.animInfoList = animInfoList;
        this.checkInCalendar = qZIntimateCheckIn$CheckinCalendar;
        this.isFromCheckIn = z26;
        this.menuList = menuList;
        this.phShareStatus = qZIntimateSpaceReader$PHShareStatus;
        this.checkInAnimLevel = i18;
    }

    public String toString() {
        return "QZoneIntimateSpaceBean(title=" + this.title + ", members=" + this.members + ", stMembers=" + this.stMembers + ", medalInfo=" + this.medalInfo + ", bgImageLight=" + this.bgImageLight + ", bgImageDark=" + this.bgImageDark + ", relationMsg=" + this.relationMsg + ", relationDays=" + this.relationDays + ", relationColorPrimary=" + this.relationColorPrimary + ", checkInButton=" + this.checkInButton + ", checkInAnimUrl=" + this.checkInAnimUrl + ", checkInJumpUrl=" + this.checkInJumpUrl + ", spaceType=" + this.spaceType + ", checkInDays=" + this.checkInDays + ", displayRight=" + this.displayRight + ", hasCheckInToday=" + this.hasCheckInToday + ", anniversary=" + this.anniversary + ", showOldUserGuideDialog=" + this.showOldUserGuideDialog + ", isFromRefreshSpace=" + this.isFromRefreshSpace + ", isDraft=" + this.isDraft + ", iconList=" + this.iconList + ", activateGuideInfo=" + this.activateGuideInfo + ", animInfoList=" + this.animInfoList + ", checkInCalendar=" + this.checkInCalendar + ", isFromCheckIn=" + this.isFromCheckIn + ", menuList=" + this.menuList + ", phShareStatus=" + this.phShareStatus + ", checkInAnimLevel=" + this.checkInAnimLevel + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QZoneIntimateSpaceBean)) {
            return false;
        }
        QZoneIntimateSpaceBean qZoneIntimateSpaceBean = (QZoneIntimateSpaceBean) other;
        return Intrinsics.areEqual(this.title, qZoneIntimateSpaceBean.title) && Intrinsics.areEqual(this.members, qZoneIntimateSpaceBean.members) && Intrinsics.areEqual(this.stMembers, qZoneIntimateSpaceBean.stMembers) && Intrinsics.areEqual(this.medalInfo, qZoneIntimateSpaceBean.medalInfo) && Intrinsics.areEqual(this.bgImageLight, qZoneIntimateSpaceBean.bgImageLight) && Intrinsics.areEqual(this.bgImageDark, qZoneIntimateSpaceBean.bgImageDark) && Intrinsics.areEqual(this.relationMsg, qZoneIntimateSpaceBean.relationMsg) && this.relationDays == qZoneIntimateSpaceBean.relationDays && Intrinsics.areEqual(this.relationColorPrimary, qZoneIntimateSpaceBean.relationColorPrimary) && Intrinsics.areEqual(this.checkInButton, qZoneIntimateSpaceBean.checkInButton) && Intrinsics.areEqual(this.checkInAnimUrl, qZoneIntimateSpaceBean.checkInAnimUrl) && Intrinsics.areEqual(this.checkInJumpUrl, qZoneIntimateSpaceBean.checkInJumpUrl) && this.spaceType == qZoneIntimateSpaceBean.spaceType && this.checkInDays == qZoneIntimateSpaceBean.checkInDays && this.displayRight == qZoneIntimateSpaceBean.displayRight && this.hasCheckInToday == qZoneIntimateSpaceBean.hasCheckInToday && this.anniversary == qZoneIntimateSpaceBean.anniversary && this.showOldUserGuideDialog == qZoneIntimateSpaceBean.showOldUserGuideDialog && this.isFromRefreshSpace == qZoneIntimateSpaceBean.isFromRefreshSpace && this.isDraft == qZoneIntimateSpaceBean.isDraft && Intrinsics.areEqual(this.iconList, qZoneIntimateSpaceBean.iconList) && Intrinsics.areEqual(this.activateGuideInfo, qZoneIntimateSpaceBean.activateGuideInfo) && Intrinsics.areEqual(this.animInfoList, qZoneIntimateSpaceBean.animInfoList) && Intrinsics.areEqual(this.checkInCalendar, qZoneIntimateSpaceBean.checkInCalendar) && this.isFromCheckIn == qZoneIntimateSpaceBean.isFromCheckIn && Intrinsics.areEqual(this.menuList, qZoneIntimateSpaceBean.menuList) && Intrinsics.areEqual(this.phShareStatus, qZoneIntimateSpaceBean.phShareStatus) && this.checkInAnimLevel == qZoneIntimateSpaceBean.checkInAnimLevel;
    }
}

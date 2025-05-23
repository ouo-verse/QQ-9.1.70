package com.tencent.mobileqq.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelpublic.nativeinterface.MemberRole;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0xa2a.oidb_0xa2a$UserInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u0016\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0019Bj\u0012\u0007\u0010\u008c\u0001\u001a\u00020Q\u0012\u0006\u0010-\u001a\u00020+\u0012\u0006\u00100\u001a\u00020\u001a\u0012\u0006\u00105\u001a\u00020\u001a\u0012\u0006\u0010<\u001a\u000206\u0012\n\u0010E\u001a\u00060=R\u00020>\u0012\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010K\u001a\u00020\u0018\u0012\u0006\u0010L\u001a\u00020\u0018\u00a2\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\u0007\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\b\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\t\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\n\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\u000b\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\f\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\r\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\u000e\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\u000f\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\u0010\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\u0011\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0012\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\u0016\u0010\u0017\u001a\u00020\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\u000e\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001aJ\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eJ\u0014\u0010!\u001a\u00020\u00142\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0006\u0010\"\u001a\u00020\u0005J4\u0010*\u001a\u0004\u0018\u00010\u001c2\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001c0'2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001c0'R\u0014\u0010-\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010,R\u0014\u00100\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\"\u00105\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010/\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u0010<\u001a\u0002068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R&\u0010E\u001a\u00060=R\u00020>8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001a\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010GR\u0014\u0010K\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010JR\"\u0010L\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010J\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\"\u0010U\u001a\u0010\u0012\f\u0012\n R*\u0004\u0018\u00010Q0Q0P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u001a\u0010W\u001a\b\u0012\u0004\u0012\u00020\u001c0'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bV\u0010GR\u001a\u0010X\u001a\b\u0012\u0004\u0012\u00020\u001c0'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010GR\"\u0010\\\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bY\u0010/\u001a\u0004\bZ\u00102\"\u0004\b[\u00104R\"\u0010`\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b]\u0010/\u001a\u0004\b^\u00102\"\u0004\b_\u00104R\"\u0010d\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\ba\u0010/\u001a\u0004\bb\u00102\"\u0004\bc\u00104R\"\u0010g\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\be\u0010/\u001a\u0004\bF\u00102\"\u0004\bf\u00104R\u0017\u0010j\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b3\u0010h\u001a\u0004\b.\u0010iR\u0017\u0010m\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\bk\u0010h\u001a\u0004\bl\u0010iR*\u0010q\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010G\u001a\u0004\bn\u0010o\"\u0004\bV\u0010pR*\u0010s\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010G\u001a\u0004\br\u0010o\"\u0004\ba\u0010pR$\u0010y\u001a\u0004\u0018\u00010t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010u\u001a\u0004\bv\u0010w\"\u0004\bS\u0010xR$\u0010{\u001a\u0004\u0018\u00010t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010u\u001a\u0004\bz\u0010w\"\u0004\b]\u0010xR$\u0010}\u001a\u0004\u0018\u00010t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010u\u001a\u0004\b|\u0010w\"\u0004\bY\u0010xR+\u0010\u0080\u0001\u001a\n\u0012\u0004\u0012\u00020~\u0018\u00010'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010G\u001a\u0004\b\u007f\u0010o\"\u0004\bk\u0010pR(\u0010\u0084\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u001c0\u0081\u0001j\t\u0012\u0004\u0012\u00020\u001c`\u0082\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\f\u0010\u0083\u0001R)\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\b\u0010\u0010\u0085\u0001\u001a\u0005\b?\u0010\u0086\u0001\"\u0006\b\u0087\u0001\u0010\u0088\u0001R)\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\b\t\u0010\u0085\u0001\u001a\u0006\b\u008a\u0001\u0010\u0086\u0001\"\u0005\be\u0010\u0088\u0001\u00a8\u0006\u008f\u0001"}, d2 = {"Lcom/tencent/mobileqq/activity/ii;", "", "", "Lcom/tencent/mobileqq/troop/troopmemberlist/a;", "listData", "Lcom/tencent/mobileqq/activity/ij;", UserInfo.SEX_FEMALE, "w", BdhLogUtil.LogTag.Tag_Conn, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "u", "D", "y", "E", "B", HippyTKDListViewAdapter.X, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "v", "", "dividerIndex", "", "H", "adminList", "t", "", "a", "", "resId", "", "g", "Lcom/tencent/common/app/AppInterface;", "c", "dataList", tl.h.F, "G", "", "lastActiveTime", "Ljava/util/Calendar;", "serverCal", "", "days", "name", "d", "Landroid/os/Bundle;", "Landroid/os/Bundle;", "bundle", "b", "I", "from", "getSortType", "()I", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(I)V", "sortType", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "getTroopInfo", "()Lcom/tencent/mobileqq/data/troop/TroopInfo;", ReportConstant.COSTREPORT_PREFIX, "(Lcom/tencent/mobileqq/data/troop/TroopInfo;)V", "troopInfo", "Lcom/tencent/mobileqq/activity/TroopMemberListActivity$t;", "Lcom/tencent/mobileqq/activity/TroopMemberListActivity;", "e", "Lcom/tencent/mobileqq/activity/TroopMemberListActivity$t;", "getAdapter", "()Lcom/tencent/mobileqq/activity/TroopMemberListActivity$t;", "i", "(Lcom/tencent/mobileqq/activity/TroopMemberListActivity$t;)V", "adapter", "f", "Ljava/util/List;", "data", "selectedList", "Z", "filerRobot", "isHomeworkTroop", "()Z", "l", "(Z)V", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/app/QBaseActivity;", "kotlin.jvm.PlatformType", "j", "Lmqq/util/WeakReference;", "activityRef", "k", "inactiveSeqName", "inactiveSeqDays", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getMaxAvailableHeight", "setMaxAvailableHeight", "maxAvailableHeight", DomainData.DOMAIN_NAME, "getIndexHeight", "setIndexHeight", "indexHeight", "o", "getItemHeight", "setItemHeight", "itemHeight", "p", "setMaxItemCountPerPage", "maxItemCountPerPage", "Ljava/lang/String;", "()Ljava/lang/String;", "adminAndTeacherTitle", "r", "getAdminTitle", "adminTitle", "getGameOnlineUinList", "()Ljava/util/List;", "(Ljava/util/List;)V", "gameOnlineUinList", "getOnlineUinList", "onlineUinList", "", "[J", "getBirthdays", "()[J", "([J)V", "birthdays", "getMineSends", "mineSends", "getMineRecvs", "mineRecvs", "Ltencent/im/oidb/cmd0xa2a/oidb_0xa2a$UserInfo;", "getStarLeagueMembers", "starLeagueMembers", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "preSelectedUins", "Lcom/tencent/mobileqq/activity/ij;", "()Lcom/tencent/mobileqq/activity/ij;", "setListSortResult", "(Lcom/tencent/mobileqq/activity/ij;)V", "listSortResult", "getPreloadListSortResult", "preloadListSortResult", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "<init>", "(Lcom/tencent/mobileqq/app/QBaseActivity;Landroid/os/Bundle;IILcom/tencent/mobileqq/data/troop/TroopInfo;Lcom/tencent/mobileqq/activity/TroopMemberListActivity$t;Ljava/util/List;Ljava/util/List;ZZ)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class ii {
    static IPatchRedirector $redirector_;

    /* renamed from: B, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: A, reason: from kotlin metadata */
    @Nullable
    private ij preloadListSortResult;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Bundle bundle;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int from;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int sortType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TroopInfo troopInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TroopMemberListActivity.t adapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<com.tencent.mobileqq.troop.troopmemberlist.a> data;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<com.tencent.mobileqq.troop.troopmemberlist.a> selectedList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final boolean filerRobot;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isHomeworkTroop;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<QBaseActivity> activityRef;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> inactiveSeqName;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> inactiveSeqDays;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int maxAvailableHeight;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private int indexHeight;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private int itemHeight;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private int maxItemCountPerPage;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String adminAndTeacherTitle;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String adminTitle;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<String> gameOnlineUinList;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<String> onlineUinList;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private long[] birthdays;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private long[] mineSends;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private long[] mineRecvs;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<oidb_0xa2a$UserInfo> starLeagueMembers;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<String> preSelectedUins;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ij listSortResult;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/activity/ii$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.ii$a, reason: from kotlin metadata */
    /* loaded from: classes9.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22418);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 41)) {
            redirector.redirect((short) 41);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x014e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ii(@NotNull QBaseActivity activity, @NotNull Bundle bundle, int i3, int i16, @NotNull TroopInfo troopInfo, @NotNull TroopMemberListActivity.t adapter, @NotNull List<com.tencent.mobileqq.troop.troopmemberlist.a> data, @NotNull List<com.tencent.mobileqq.troop.troopmemberlist.a> selectedList, boolean z16, boolean z17) {
        List<String> emptyList;
        List<String> emptyList2;
        String g16;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(troopInfo, "troopInfo");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(selectedList, "selectedList");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, activity, bundle, Integer.valueOf(i3), Integer.valueOf(i16), troopInfo, adapter, data, selectedList, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        this.bundle = bundle;
        this.from = i3;
        this.sortType = i16;
        this.troopInfo = troopInfo;
        this.adapter = adapter;
        this.data = data;
        this.selectedList = selectedList;
        this.filerRobot = z16;
        this.isHomeworkTroop = z17;
        this.activityRef = new WeakReference<>(activity);
        this.maxItemCountPerPage = 50;
        String qqStr = HardCodeUtil.qqStr(R.string.ukv);
        this.adminAndTeacherTitle = qqStr == null ? "" : qqStr;
        if (i3 != 15) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.inactiveSeqName = emptyList;
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            this.inactiveSeqDays = emptyList2;
        } else {
            List<String> stringArrayList = bundle.getStringArrayList(TroopMemberListActivity.PARAM_SEQ_DAYS);
            this.inactiveSeqDays = stringArrayList == null ? CollectionsKt__CollectionsKt.emptyList() : stringArrayList;
            List<String> stringArrayList2 = bundle.getStringArrayList(TroopMemberListActivity.PARAM_SEQ_NAME);
            this.inactiveSeqName = stringArrayList2 == null ? CollectionsKt__CollectionsKt.emptyList() : stringArrayList2;
        }
        DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(displayMetrics, "activity.resources.displayMetrics");
        int max = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
        int titleBarHeight = activity.getTitleBarHeight();
        int statusBarHeight = ImmersiveUtils.getStatusBarHeight(activity);
        int i17 = (int) (60 * activity.getResources().getDisplayMetrics().density);
        this.indexHeight = activity.getResources().getDimensionPixelSize(R.dimen.b1p);
        int dimensionPixelSize = activity.getResources().getDimensionPixelSize(R.dimen.f158565j4);
        this.itemHeight = dimensionPixelSize;
        if (dimensionPixelSize == 0) {
            this.itemHeight = (int) (58 * displayMetrics.density);
        }
        int i18 = ((max - titleBarHeight) - statusBarHeight) - i17;
        this.maxAvailableHeight = i18;
        this.maxItemCountPerPage = (i18 - this.indexHeight) / this.itemHeight;
        if (i3 != 1) {
            if (i3 == 5) {
                g16 = g(R.string.dvl);
            } else if (i3 != 11) {
                g16 = g(R.string.i8s);
            }
            this.adminTitle = g16;
            ArrayList<String> stringArrayList3 = bundle.getStringArrayList("param_pick_selected_list");
            this.preSelectedUins = stringArrayList3 == null ? new ArrayList<>() : stringArrayList3;
        }
        g16 = g(R.string.f170845at3);
        this.adminTitle = g16;
        ArrayList<String> stringArrayList32 = bundle.getStringArrayList("param_pick_selected_list");
        this.preSelectedUins = stringArrayList32 == null ? new ArrayList<>() : stringArrayList32;
    }

    private final ij A(List<com.tencent.mobileqq.troop.troopmemberlist.a> listData) {
        long j3;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (this.inactiveSeqDays.size() == 0) {
            return new ij();
        }
        Calendar serverCal = Calendar.getInstance();
        serverCal.setTimeInMillis(NetConnInfoCenter.getServerTime() * 1000);
        for (com.tencent.mobileqq.troop.troopmemberlist.a aVar : listData) {
            if (aVar.f() != null && TextUtils.isEmpty(aVar.d())) {
                if (aVar.f().last_active_time == 0) {
                    j3 = aVar.f().join_time;
                } else {
                    j3 = aVar.f().last_active_time;
                }
                Intrinsics.checkNotNullExpressionValue(serverCal, "serverCal");
                aVar.o(d(j3, serverCal, this.inactiveSeqDays, this.inactiveSeqName));
            }
            String d16 = aVar.d();
            if (d16 != null) {
                if (linkedHashMap.get(d16) == null) {
                    linkedHashMap.put(d16, new ArrayList());
                }
                List list = (List) linkedHashMap.get(d16);
                if (list != null) {
                    list.add(aVar);
                }
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (String str : this.inactiveSeqName) {
            List<com.tencent.mobileqq.troop.troopmemberlist.a> list2 = (List) linkedHashMap.get(str);
            if (list2 != null) {
                com.tencent.mobileqq.troop.troopmemberlist.d.f300628a.c(list2, false);
                linkedHashMap2.put(str, list2);
            }
        }
        return new ij(linkedHashMap2);
    }

    private final ij B(List<com.tencent.mobileqq.troop.troopmemberlist.a> listData) {
        QBaseActivity qBaseActivity = this.activityRef.get();
        if (qBaseActivity == null) {
            return new ij();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String[] stringArray = qBaseActivity.getResources().getStringArray(R.array.f155247bx);
        Intrinsics.checkNotNullExpressionValue(stringArray, "activity.resources.getSt\u2026member_king_segment_list)");
        String otherGroupName = HardCodeUtil.qqStr(R.string.uln);
        Iterator<com.tencent.mobileqq.troop.troopmemberlist.a> it = listData.iterator();
        while (true) {
            int i3 = 0;
            if (!it.hasNext()) {
                break;
            }
            com.tencent.mobileqq.troop.troopmemberlist.a next = it.next();
            TroopMemberInfo f16 = next.f();
            if (f16 != null) {
                i3 = f16.titleId;
            }
            if (i3 >= 10000) {
                i3 -= 10000;
            }
            if (i3 >= 321 && i3 <= 327) {
                String str = stringArray[i3 - 321];
                if (linkedHashMap.get(str) == null) {
                    linkedHashMap.put(str, new ArrayList());
                }
                List list = (List) linkedHashMap.get(str);
                if (list != null) {
                    list.add(next);
                }
            } else {
                if (linkedHashMap.get(otherGroupName) == null) {
                    Intrinsics.checkNotNullExpressionValue(otherGroupName, "otherGroupName");
                    linkedHashMap.put(otherGroupName, new ArrayList());
                }
                List list2 = (List) linkedHashMap.get(otherGroupName);
                if (list2 != null) {
                    list2.add(next);
                }
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (String str2 : stringArray) {
            List<com.tencent.mobileqq.troop.troopmemberlist.a> list3 = (List) linkedHashMap.get(str2);
            if (list3 != null) {
                com.tencent.mobileqq.troop.troopmemberlist.d.f300628a.d(list3, false);
                linkedHashMap2.put(str2, list3);
            }
        }
        ((ITroopMemberListActivityApi) QRoute.api(ITroopMemberListActivityApi.class)).reportDC00087(null, "846", "205607", "", "84601", "1", WadlProxyConsts.PAGE_ID_DOWNLOAD);
        return new ij(linkedHashMap2);
    }

    private final ij C(List<com.tencent.mobileqq.troop.troopmemberlist.a> listData) {
        QBaseActivity qBaseActivity = this.activityRef.get();
        if (qBaseActivity == null) {
            return new ij();
        }
        AppInterface c16 = c();
        if (c16 == null) {
            return new ij();
        }
        IRuntimeService runtimeService = c16.getRuntimeService(ITroopRobotService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IT\u2026ava, ProcessConstant.ALL)");
        ITroopRobotService iTroopRobotService = (ITroopRobotService) runtimeService;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (com.tencent.mobileqq.troop.troopmemberlist.a aVar : listData) {
            if (!iTroopRobotService.isRobotUin(aVar.j()) || a()) {
                if (aVar.f() != null && TextUtils.isEmpty(aVar.e())) {
                    aVar.p(com.tencent.mobileqq.troop.troopmemberlist.g.f300632a.h(qBaseActivity, aVar.f().last_active_time));
                }
                String e16 = aVar.e();
                if (linkedHashMap.get(e16) == null) {
                    linkedHashMap.put(e16, new ArrayList());
                }
                List list = (List) linkedHashMap.get(e16);
                if (list != null) {
                    list.add(aVar);
                }
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (String seg : com.tencent.mobileqq.troop.troopmemberlist.g.f300632a.e(qBaseActivity)) {
            List<com.tencent.mobileqq.troop.troopmemberlist.a> list2 = (List) linkedHashMap.get(seg);
            if (list2 != null) {
                com.tencent.mobileqq.troop.troopmemberlist.d.f300628a.c(list2, false);
                Intrinsics.checkNotNullExpressionValue(seg, "seg");
                linkedHashMap2.put(seg, list2);
            }
        }
        return new ij(linkedHashMap2);
    }

    private final ij D(List<com.tencent.mobileqq.troop.troopmemberlist.a> listData) {
        int i3;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        int i16;
        AppInterface c16 = c();
        if (c16 == null) {
            return new ij();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        IRuntimeService runtimeService = c16.getRuntimeService(ITroopRobotService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService<IT\u2026ava, ProcessConstant.ALL)");
        ITroopRobotService iTroopRobotService = (ITroopRobotService) runtimeService;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        Iterator<com.tencent.mobileqq.troop.troopmemberlist.a> it = listData.iterator();
        while (true) {
            boolean z26 = false;
            if (!it.hasNext()) {
                break;
            }
            com.tencent.mobileqq.troop.troopmemberlist.a next = it.next();
            if (iTroopRobotService.isRobotUin(next.j())) {
                if (this.from != 5 && !this.filerRobot) {
                    List<String> list = this.onlineUinList;
                    if (list != null && list.contains(next.j())) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        arrayList.add(next);
                        next.q(true);
                    } else {
                        arrayList4.add(next);
                        next.q(false);
                    }
                }
            } else {
                List<String> list2 = this.onlineUinList;
                if (list2 != null && list2.contains(next.j())) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17 && !TextUtils.equals(next.j(), c16.getCurrentAccountUin())) {
                    next.q(false);
                    arrayList4.add(next);
                } else {
                    next.q(true);
                    TroopMemberInfo f16 = next.f();
                    if (f16 != null) {
                        MemberRole memberRole = f16.role;
                        if (memberRole == MemberRole.OWNER) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        if (memberRole == MemberRole.ADMIN) {
                            z19 = true;
                        } else {
                            z19 = false;
                        }
                        if (this.isHomeworkTroop && ((i16 = f16.titleId) == 332 || i16 == 333)) {
                            z26 = true;
                        }
                        if (!z18 && !z19 && !z26) {
                            arrayList3.add(next);
                        } else {
                            arrayList2.add(next);
                        }
                    } else {
                        arrayList3.add(next);
                    }
                }
            }
        }
        com.tencent.mobileqq.troop.troopmemberlist.d dVar = com.tencent.mobileqq.troop.troopmemberlist.d.f300628a;
        dVar.h(arrayList, false);
        if (arrayList.size() > 0) {
            linkedHashMap.put(g(R.string.i8u), arrayList);
        }
        if (arrayList2.size() > 0) {
            dVar.h(arrayList2, false);
            t(arrayList2);
            if (this.isHomeworkTroop) {
                i3 = R.string.cnz;
            } else {
                i3 = R.string.cny;
            }
            linkedHashMap.put(g(i3), arrayList2);
        }
        dVar.h(arrayList3, false);
        if (arrayList3.size() > 0) {
            linkedHashMap.put(g(R.string.i8q), arrayList3);
        }
        dVar.h(arrayList4, false);
        if (arrayList4.size() > 0) {
            linkedHashMap.put(g(R.string.i8p), arrayList4);
        }
        return new ij(linkedHashMap);
    }

    private final ij E(List<com.tencent.mobileqq.troop.troopmemberlist.a> listData) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap = new HashMap();
        List<oidb_0xa2a$UserInfo> list = this.starLeagueMembers;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                oidb_0xa2a$UserInfo oidb_0xa2a_userinfo = list.get(i3);
                hashMap.put(String.valueOf(oidb_0xa2a_userinfo.uin.get()), oidb_0xa2a_userinfo);
            }
        }
        for (com.tencent.mobileqq.troop.troopmemberlist.a aVar : listData) {
            oidb_0xa2a$UserInfo oidb_0xa2a_userinfo2 = (oidb_0xa2a$UserInfo) hashMap.get(aVar.j());
            if (oidb_0xa2a_userinfo2 != null) {
                arrayList.add(aVar);
                aVar.s(oidb_0xa2a_userinfo2.score.get());
            } else {
                arrayList2.add(aVar);
            }
        }
        if (arrayList.size() > 0) {
            com.tencent.mobileqq.troop.troopmemberlist.d.f300628a.f(arrayList, false);
            String qqStr = HardCodeUtil.qqStr(R.string.ulz);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.qqstr_troopmem_7064c4a4)");
            linkedHashMap.put(qqStr, arrayList);
        }
        if (arrayList2.size() > 0) {
            com.tencent.mobileqq.troop.troopmemberlist.d.f300628a.f(arrayList2, false);
            String qqStr2 = HardCodeUtil.qqStr(R.string.unf);
            Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(R.string.qqstr_troopmem_f341a00a)");
            linkedHashMap.put(qqStr2, arrayList2);
        }
        return new ij(linkedHashMap);
    }

    private final ij F(List<com.tencent.mobileqq.troop.troopmemberlist.a> listData) {
        ij z16;
        int i3;
        long currentTimeMillis = System.currentTimeMillis();
        switch (this.sortType) {
            case 0:
                int i16 = this.from;
                if (i16 != 19) {
                    if (i16 != 21) {
                        z16 = w(listData);
                        break;
                    } else {
                        z16 = v(listData);
                        break;
                    }
                } else {
                    z16 = z(listData);
                    break;
                }
            case 1:
                z16 = D(listData);
                break;
            case 2:
                z16 = C(listData);
                break;
            case 3:
                z16 = u(listData);
                break;
            case 4:
                z16 = B(listData);
                break;
            case 5:
                z16 = x(listData);
                break;
            case 6:
                z16 = A(listData);
                break;
            case 7:
                z16 = y(listData);
                break;
            case 8:
                z16 = E(listData);
                break;
            default:
                z16 = new ij();
                break;
        }
        if (this.troopInfo.isQidianPrivateTroop()) {
            z16.g().remove(g(R.string.hor));
        }
        Set<String> keySet = z16.g().keySet();
        int size = keySet.size();
        if (size == 0) {
            QLog.d("TroopMemberListController", 1, "sortTroopMemberItem: group size=0");
            return z16;
        }
        int[] iArr = new int[size];
        String[] strArr = new String[size];
        for (int i17 = 0; i17 < size; i17++) {
            strArr[i17] = "";
        }
        iArr[0] = 0;
        int i18 = 0;
        for (String str : keySet) {
            strArr[i18] = str;
            int i19 = i18 + 1;
            if (i19 < size) {
                List<com.tencent.mobileqq.troop.troopmemberlist.a> list = z16.g().get(str);
                if (list != null) {
                    i3 = list.size();
                } else {
                    i3 = 0;
                }
                iArr[i19] = iArr[i18] + i3 + 1;
            }
            i18 = i19;
        }
        H(iArr);
        z16.i(strArr);
        z16.h(iArr);
        long currentTimeMillis2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d(TroopMemberListActivity.TAG_TIME, 2, "constructHashStruct, time " + (currentTimeMillis2 - currentTimeMillis) + ", sortType: " + this.sortType + ", listSize: " + listData.size());
        }
        return z16;
    }

    private final void H(int[] dividerIndex) {
        boolean z16;
        int i3;
        int i16;
        int i17;
        if (dividerIndex != null) {
            int i18 = 0;
            if (dividerIndex.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                ij ijVar = this.listSortResult;
                if (ijVar != null) {
                    i3 = ijVar.e();
                } else {
                    i3 = 0;
                }
                ij ijVar2 = this.listSortResult;
                if (ijVar2 != null) {
                    i16 = ijVar2.f();
                } else {
                    i16 = 0;
                }
                if (i3 + i16 > 16) {
                    return;
                }
                int length = dividerIndex.length;
                int i19 = 0;
                int i26 = 1;
                while (true) {
                    if (i26 >= length) {
                        break;
                    }
                    int i27 = (dividerIndex[i26] - dividerIndex[i26 - 1]) - 1;
                    if (i27 > 0) {
                        int i28 = i18 + this.indexHeight;
                        int i29 = (this.itemHeight * i27) + i28;
                        if (i29 > this.maxAvailableHeight) {
                            do {
                                i27--;
                                i17 = (this.indexHeight * i27) + i28;
                                if (i17 <= this.maxAvailableHeight) {
                                    break;
                                }
                            } while (i27 > 0);
                            i19 += i27;
                            i18 = i17;
                        } else {
                            i19 += i27;
                            i18 = i29;
                        }
                    }
                    i26++;
                }
                int i36 = i19 + 1;
                if (i18 + this.itemHeight > this.maxAvailableHeight) {
                    this.maxItemCountPerPage = i36;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("TroopMemberListController", 2, "updateMaxItemCount: max: " + this.maxItemCountPerPage);
                }
            }
        }
    }

    private final boolean a() {
        if (this.from != 5 && !this.filerRobot) {
            return true;
        }
        return false;
    }

    private final void t(List<com.tencent.mobileqq.troop.troopmemberlist.a> adminList) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        com.tencent.mobileqq.troop.troopmemberlist.a aVar = null;
        for (com.tencent.mobileqq.troop.troopmemberlist.a aVar2 : adminList) {
            TroopMemberInfo f16 = aVar2.f();
            if (f16 != null) {
                MemberRole memberRole = f16.role;
                if (memberRole == MemberRole.OWNER) {
                    aVar = aVar2;
                } else {
                    MemberRole memberRole2 = MemberRole.ADMIN;
                    if (memberRole == memberRole2 && f16.titleId == 332) {
                        arrayList.add(aVar2);
                    } else if (memberRole == memberRole2 && f16.titleId == 333) {
                        arrayList2.add(aVar2);
                    } else {
                        int i3 = f16.titleId;
                        if (i3 == 332) {
                            arrayList3.add(aVar2);
                        } else if (i3 == 333) {
                            arrayList4.add(aVar2);
                        } else if (memberRole == memberRole2) {
                            arrayList5.add(aVar2);
                        } else {
                            arrayList6.add(aVar2);
                        }
                    }
                }
            }
        }
        adminList.clear();
        if (aVar != null) {
            adminList.add(aVar);
        }
        adminList.addAll(arrayList);
        adminList.addAll(arrayList2);
        adminList.addAll(arrayList3);
        adminList.addAll(arrayList4);
        adminList.addAll(arrayList5);
        adminList.addAll(arrayList6);
    }

    private final ij u(List<com.tencent.mobileqq.troop.troopmemberlist.a> listData) {
        List reversed;
        QBaseActivity qBaseActivity = this.activityRef.get();
        if (qBaseActivity == null) {
            return new ij();
        }
        AppInterface c16 = c();
        if (c16 == null) {
            return new ij();
        }
        IRuntimeService runtimeService = c16.getRuntimeService(ITroopRobotService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IT\u2026ava, ProcessConstant.ALL)");
        ITroopRobotService iTroopRobotService = (ITroopRobotService) runtimeService;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (com.tencent.mobileqq.troop.troopmemberlist.a aVar : listData) {
            if (!iTroopRobotService.isRobotUin(aVar.j()) || a()) {
                String b16 = aVar.b();
                if (aVar.f() != null && TextUtils.isEmpty(b16)) {
                    b16 = com.tencent.mobileqq.troop.troopmemberlist.g.f300632a.f(qBaseActivity, aVar.f().join_time);
                    aVar.n(b16);
                }
                if (linkedHashMap.get(b16) == null) {
                    linkedHashMap.put(b16, new ArrayList());
                }
                List list = (List) linkedHashMap.get(b16);
                if (list != null) {
                    list.add(aVar);
                }
            }
        }
        String[] g16 = com.tencent.mobileqq.troop.troopmemberlist.g.f300632a.g(qBaseActivity);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        reversed = ArraysKt___ArraysKt.reversed(g16);
        int size = reversed.size();
        for (int i3 = 0; i3 < size; i3++) {
            String seg = (String) reversed.get(i3);
            List<com.tencent.mobileqq.troop.troopmemberlist.a> list2 = (List) linkedHashMap.get(seg);
            if (list2 != null) {
                com.tencent.mobileqq.troop.troopmemberlist.d.f300628a.e(list2, true);
                Intrinsics.checkNotNullExpressionValue(seg, "seg");
                linkedHashMap2.put(seg, list2);
            }
        }
        return new ij(linkedHashMap2);
    }

    private final ij v(List<com.tencent.mobileqq.troop.troopmemberlist.a> listData) {
        MemberRole memberRole;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        for (com.tencent.mobileqq.troop.troopmemberlist.a aVar : listData) {
            TroopMemberInfo f16 = aVar.f();
            if (f16 != null && ((memberRole = f16.role) == MemberRole.OWNER || memberRole == MemberRole.ADMIN)) {
                arrayList.add(aVar);
            }
        }
        com.tencent.mobileqq.troop.troopmemberlist.d.f300628a.d(arrayList, true);
        String qqStr = HardCodeUtil.qqStr(R.string.ulm);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.qqstr_troopmem_51dbaf61)");
        linkedHashMap.put(qqStr, listData);
        return new ij(linkedHashMap);
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x018f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0102  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final ij w(List<com.tencent.mobileqq.troop.troopmemberlist.a> listData) {
        boolean z16;
        int i3;
        int i16;
        String str;
        ITroopRobotService iTroopRobotService;
        String str2;
        int i17;
        String showNamePyFirst;
        boolean z17;
        int i18;
        String substring;
        char charAt;
        boolean z18;
        String upperCase;
        List list;
        boolean z19;
        AppInterface c16 = c();
        if (c16 == null) {
            return new ij();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        IRuntimeService runtimeService = c16.getRuntimeService(ITroopRobotService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IT\u2026ava, ProcessConstant.ALL)");
        ITroopRobotService iTroopRobotService2 = (ITroopRobotService) runtimeService;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        int i19 = 0;
        for (com.tencent.mobileqq.troop.troopmemberlist.a aVar : listData) {
            TroopMemberInfo f16 = aVar.f();
            if (f16 != null) {
                if (iTroopRobotService2.isRobotUin(aVar.j())) {
                    if (a() && f16.role == MemberRole.ADMIN) {
                        arrayList3.add(aVar);
                    } else if (a()) {
                        arrayList5.add(aVar);
                    }
                } else {
                    int i26 = this.from;
                    iTroopRobotService = iTroopRobotService2;
                    if ((i26 == 12 || i26 == 20) && this.preSelectedUins.contains(aVar.j()) && !this.selectedList.contains(aVar)) {
                        this.selectedList.add(aVar);
                        this.preSelectedUins.remove(aVar.j());
                    }
                    int i27 = this.from;
                    if (i27 != 13 && i27 != 21) {
                        if (!this.isHomeworkTroop && f16.isTroopFollowed) {
                            arrayList.add(aVar);
                        }
                        if (!this.isHomeworkTroop && f16.mIsShielded) {
                            arrayList4.add(aVar);
                        }
                        if (!Intrinsics.areEqual(aVar.j(), c16.getCurrentAccountUin())) {
                            str2 = "#";
                            if (f16.credit_level == 1) {
                                arrayList2.add(aVar);
                            }
                            if (this.from != 5) {
                                if (!TextUtils.isEmpty(f16.getSpecialTitleStr())) {
                                    arrayList3.add(aVar);
                                }
                                showNamePyFirst = aVar.i().getShowNamePyFirst();
                                if (showNamePyFirst.length() != 0) {
                                    z17 = true;
                                } else {
                                    z17 = false;
                                }
                                if (!z17) {
                                    substring = str2;
                                    i18 = 0;
                                } else {
                                    i18 = 0;
                                    substring = showNamePyFirst.substring(0, 1);
                                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                                }
                                charAt = substring.charAt(i18);
                                if ('A' > charAt && charAt < '[') {
                                    z18 = true;
                                } else {
                                    z18 = false;
                                }
                                if (!z18) {
                                    if ('a' <= charAt && charAt < '{') {
                                        z19 = true;
                                    } else {
                                        z19 = false;
                                    }
                                    if (!z19) {
                                        upperCase = str2;
                                        if (linkedHashMap2.get(upperCase) == null) {
                                            linkedHashMap2.put(upperCase, new ArrayList());
                                        }
                                        i19++;
                                        list = (List) linkedHashMap2.get(upperCase);
                                        if (list != null) {
                                            list.add(aVar);
                                        }
                                    }
                                }
                                upperCase = substring.toUpperCase();
                                Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase()");
                                if (linkedHashMap2.get(upperCase) == null) {
                                }
                                i19++;
                                list = (List) linkedHashMap2.get(upperCase);
                                if (list != null) {
                                }
                            } else {
                                MemberRole memberRole = f16.role;
                                if (memberRole != MemberRole.OWNER && memberRole != MemberRole.ADMIN) {
                                    if (this.isHomeworkTroop && ((i17 = f16.titleId) == 332 || i17 == 333)) {
                                        arrayList3.add(aVar);
                                    }
                                    showNamePyFirst = aVar.i().getShowNamePyFirst();
                                    if (showNamePyFirst.length() != 0) {
                                    }
                                    if (!z17) {
                                    }
                                    charAt = substring.charAt(i18);
                                    if ('A' > charAt) {
                                    }
                                    z18 = false;
                                    if (!z18) {
                                    }
                                    upperCase = substring.toUpperCase();
                                    Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase()");
                                    if (linkedHashMap2.get(upperCase) == null) {
                                    }
                                    i19++;
                                    list = (List) linkedHashMap2.get(upperCase);
                                    if (list != null) {
                                    }
                                } else {
                                    arrayList3.add(aVar);
                                }
                            }
                            iTroopRobotService2 = iTroopRobotService;
                        }
                    }
                    str2 = "#";
                    if (this.from != 5) {
                    }
                    iTroopRobotService2 = iTroopRobotService;
                }
            }
            iTroopRobotService = iTroopRobotService2;
            iTroopRobotService2 = iTroopRobotService;
        }
        if (arrayList4.size() > 0 && this.from != 3) {
            com.tencent.mobileqq.troop.troopmemberlist.d.f300628a.d(arrayList4, true);
            linkedHashMap.put(g(R.string.i8e), arrayList4);
        }
        if (arrayList2.size() > 0 && this.from != 3) {
            com.tencent.mobileqq.troop.troopmemberlist.d.f300628a.d(arrayList2, true);
            linkedHashMap.put(g(R.string.f170807af3), arrayList2);
        }
        if (arrayList.size() > 0 && this.from != 12) {
            z16 = true;
            com.tencent.mobileqq.troop.troopmemberlist.d.f300628a.d(arrayList, true);
            linkedHashMap.put(g(R.string.hor), arrayList);
        } else {
            z16 = true;
        }
        if (arrayList3.size() > 0) {
            com.tencent.mobileqq.troop.troopmemberlist.d.f300628a.d(arrayList3, z16);
            i3 = 0;
            i16 = arrayList3.size() + 0;
            t(arrayList3);
            if (this.isHomeworkTroop) {
                str = this.adminAndTeacherTitle;
            } else {
                str = this.adminTitle;
            }
            linkedHashMap.put(str, arrayList3);
        } else {
            i3 = 0;
            i16 = 0;
        }
        if (arrayList5.size() > 0) {
            com.tencent.mobileqq.troop.troopmemberlist.d.f300628a.d(arrayList5, true);
            i16 += arrayList5.size();
            linkedHashMap.put(g(R.string.i8u), arrayList5);
        }
        Iterator it = linkedHashMap2.values().iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.troop.troopmemberlist.d.f300628a.d((List) it.next(), true);
        }
        int i28 = i3;
        for (char c17 = EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET; Intrinsics.compare((int) c17, 90) <= 0; c17 = (char) (c17 + 1)) {
            List list2 = (List) linkedHashMap2.get(String.valueOf(c17));
            if (list2 != null) {
                i28++;
                linkedHashMap.put(String.valueOf(c17), list2);
            }
        }
        List<com.tencent.mobileqq.troop.troopmemberlist.a> list3 = (List) linkedHashMap2.get("#");
        if (list3 != null) {
            i28++;
            com.tencent.mobileqq.troop.troopmemberlist.d.f300628a.d(list3, true);
            linkedHashMap.put("#", list3);
        }
        return new ij(linkedHashMap, i19, i28, i16);
    }

    private final ij x(List<com.tencent.mobileqq.troop.troopmemberlist.a> listData) {
        boolean z16;
        AppInterface c16 = c();
        if (c16 == null) {
            return new ij();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        IRuntimeService runtimeService = c16.getRuntimeService(ITroopRobotService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService<IT\u2026ava, ProcessConstant.ALL)");
        ITroopRobotService iTroopRobotService = (ITroopRobotService) runtimeService;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (com.tencent.mobileqq.troop.troopmemberlist.a aVar : listData) {
            if (!iTroopRobotService.isRobotUin(aVar.j())) {
                List<String> list = this.gameOnlineUinList;
                if (list != null && list.contains(aVar.j())) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    aVar.q(true);
                    arrayList.add(aVar);
                } else {
                    aVar.q(false);
                    arrayList2.add(aVar);
                }
            }
        }
        com.tencent.mobileqq.troop.troopmemberlist.d dVar = com.tencent.mobileqq.troop.troopmemberlist.d.f300628a;
        dVar.d(arrayList, false);
        if (arrayList.size() > 0) {
            linkedHashMap.put(g(R.string.vtf), arrayList);
        }
        dVar.d(arrayList2, false);
        if (arrayList2.size() > 0) {
            linkedHashMap.put(g(R.string.vte), arrayList2);
        }
        return new ij(linkedHashMap);
    }

    private final ij y(List<com.tencent.mobileqq.troop.troopmemberlist.a> listData) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        int size = listData.size();
        HashMap hashMap = new HashMap(size);
        for (int i3 = 0; i3 < size; i3++) {
            com.tencent.mobileqq.troop.troopmemberlist.a aVar = listData.get(i3);
            hashMap.put(aVar.j(), aVar);
        }
        long[] jArr = this.birthdays;
        if (jArr != null) {
            for (long j3 : jArr) {
                com.tencent.mobileqq.troop.troopmemberlist.a aVar2 = (com.tencent.mobileqq.troop.troopmemberlist.a) hashMap.remove(String.valueOf(j3));
                if (aVar2 != null) {
                    arrayList.add(aVar2);
                }
            }
        }
        long[] jArr2 = this.mineSends;
        if (jArr2 != null) {
            for (long j16 : jArr2) {
                com.tencent.mobileqq.troop.troopmemberlist.a aVar3 = (com.tencent.mobileqq.troop.troopmemberlist.a) hashMap.remove(String.valueOf(j16));
                if (aVar3 != null) {
                    arrayList2.add(aVar3);
                }
            }
        }
        long[] jArr3 = this.mineRecvs;
        if (jArr3 != null) {
            for (long j17 : jArr3) {
                com.tencent.mobileqq.troop.troopmemberlist.a aVar4 = (com.tencent.mobileqq.troop.troopmemberlist.a) hashMap.remove(String.valueOf(j17));
                if (aVar4 != null) {
                    arrayList3.add(aVar4);
                }
            }
        }
        Iterator it = hashMap.entrySet().iterator();
        while (it.hasNext()) {
            arrayList4.add(((Map.Entry) it.next()).getValue());
        }
        com.tencent.mobileqq.troop.troopmemberlist.d dVar = com.tencent.mobileqq.troop.troopmemberlist.d.f300628a;
        dVar.c(arrayList, false);
        if (!arrayList.isEmpty()) {
            String qqStr = HardCodeUtil.qqStr(R.string.umi);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.qqstr_troopmem_9ab18d9f)");
            linkedHashMap.put(qqStr, arrayList);
        }
        if (!arrayList2.isEmpty()) {
            String qqStr2 = HardCodeUtil.qqStr(R.string.ult);
            Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(R.string.qqstr_troopmem_632b6bdd)");
            linkedHashMap.put(qqStr2, arrayList2);
        }
        if (!arrayList3.isEmpty()) {
            String qqStr3 = HardCodeUtil.qqStr(R.string.f172842un1);
            Intrinsics.checkNotNullExpressionValue(qqStr3, "qqStr(R.string.qqstr_troopmem_ca3e728c)");
            linkedHashMap.put(qqStr3, arrayList3);
        }
        dVar.c(arrayList4, false);
        if (!arrayList4.isEmpty()) {
            String qqStr4 = HardCodeUtil.qqStr(R.string.ull);
            Intrinsics.checkNotNullExpressionValue(qqStr4, "qqStr(R.string.qqstr_troopmem_4db5a69a)");
            linkedHashMap.put(qqStr4, arrayList4);
        }
        return new ij(linkedHashMap);
    }

    private final ij z(List<com.tencent.mobileqq.troop.troopmemberlist.a> listData) {
        int i3;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        for (com.tencent.mobileqq.troop.troopmemberlist.a aVar : listData) {
            TroopMemberInfo f16 = aVar.f();
            if (f16 != null) {
                MemberRole memberRole = f16.role;
                if (memberRole != MemberRole.OWNER && memberRole != MemberRole.ADMIN) {
                    if (this.isHomeworkTroop && ((i3 = f16.titleId) == 332 || i3 == 333)) {
                        arrayList.add(aVar);
                    }
                } else {
                    arrayList.add(aVar);
                }
            }
        }
        if (arrayList.size() > 0) {
            com.tencent.mobileqq.troop.troopmemberlist.d.f300628a.d(arrayList, true);
            t(arrayList);
            linkedHashMap.put(this.adminAndTeacherTitle, arrayList);
        }
        return new ij(linkedHashMap);
    }

    @NotNull
    public final ij G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return (ij) iPatchRedirector.redirect((short) 39, (Object) this);
        }
        ij ijVar = this.preloadListSortResult;
        if (ijVar != null) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopMemberListController", 2, "sortTroopMemberItem: use preload cache");
            }
            this.listSortResult = ijVar;
            return ijVar;
        }
        ij F = F(this.data);
        this.listSortResult = F;
        return F;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.adminAndTeacherTitle;
    }

    @Nullable
    public final AppInterface c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (AppInterface) iPatchRedirector.redirect((short) 37, (Object) this);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            return (AppInterface) peekAppRuntime;
        }
        return null;
    }

    @Nullable
    public final String d(long lastActiveTime, @NotNull Calendar serverCal, @NotNull List<String> days, @NotNull List<String> name) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return (String) iPatchRedirector.redirect((short) 40, this, Long.valueOf(lastActiveTime), serverCal, days, name);
        }
        Intrinsics.checkNotNullParameter(serverCal, "serverCal");
        Intrinsics.checkNotNullParameter(days, "days");
        Intrinsics.checkNotNullParameter(name, "name");
        if (!name.isEmpty() && !days.isEmpty()) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(lastActiveTime * 1000);
            int i3 = (((serverCal.get(1) - calendar.get(1)) * 365) + serverCal.get(6)) - calendar.get(6);
            int size = name.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i16 = size - 1;
                    if (i3 >= Integer.parseInt(days.get(size))) {
                        return name.get(size);
                    }
                    if (i16 < 0) {
                        break;
                    }
                    size = i16;
                }
            }
        }
        return null;
    }

    @Nullable
    public final ij e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (ij) iPatchRedirector.redirect((short) 32, (Object) this);
        }
        return this.listSortResult;
    }

    public final int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return this.maxItemCountPerPage;
    }

    @NotNull
    public final String g(int resId) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (String) iPatchRedirector.redirect((short) 36, (Object) this, resId);
        }
        QBaseActivity qBaseActivity = this.activityRef.get();
        if (qBaseActivity != null) {
            str = qBaseActivity.getString(resId);
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public final void h(@NotNull List<com.tencent.mobileqq.troop.troopmemberlist.a> dataList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) dataList);
            return;
        }
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        ij F = F(dataList);
        if (!F.g().isEmpty()) {
            this.preloadListSortResult = F;
        }
    }

    public final void i(@NotNull TroopMemberListActivity.t tVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) tVar);
        } else {
            Intrinsics.checkNotNullParameter(tVar, "<set-?>");
            this.adapter = tVar;
        }
    }

    public final void j(@Nullable long[] jArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) jArr);
        } else {
            this.birthdays = jArr;
        }
    }

    public final void k(@Nullable List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) list);
        } else {
            this.gameOnlineUinList = list;
        }
    }

    public final void l(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
        } else {
            this.isHomeworkTroop = z16;
        }
    }

    public final void m(@Nullable long[] jArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) jArr);
        } else {
            this.mineRecvs = jArr;
        }
    }

    public final void n(@Nullable long[] jArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) jArr);
        } else {
            this.mineSends = jArr;
        }
    }

    public final void o(@Nullable List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) list);
        } else {
            this.onlineUinList = list;
        }
    }

    public final void p(@Nullable ij ijVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) ijVar);
        } else {
            this.preloadListSortResult = ijVar;
        }
    }

    public final void q(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.sortType = i3;
        }
    }

    public final void r(@Nullable List<oidb_0xa2a$UserInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) list);
        } else {
            this.starLeagueMembers = list;
        }
    }

    public final void s(@NotNull TroopInfo troopInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) troopInfo);
        } else {
            Intrinsics.checkNotNullParameter(troopInfo, "<set-?>");
            this.troopInfo = troopInfo;
        }
    }
}

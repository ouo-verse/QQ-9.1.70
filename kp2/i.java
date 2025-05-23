package kp2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.qqcircle.immersive.views.search.util.p;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.n;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileContactInfo;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.ac;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.fragment.SearchEntryFragment;
import com.tencent.mobileqq.search.searchlocal.model.SearchHistory;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.functions.Function1;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;
import yx3.a;

/* compiled from: P */
/* loaded from: classes18.dex */
public class i implements yx3.a {

    /* renamed from: a, reason: collision with root package name */
    private a.InterfaceC11637a f412836a;

    /* renamed from: b, reason: collision with root package name */
    private Context f412837b;

    /* renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f412838c = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void s(final SearchHistory searchHistory) {
        final DiscussionMemberInfo discussionMemberInfo;
        Context context = this.f412837b;
        if (context == null) {
            return;
        }
        int i3 = searchHistory.type;
        if (i3 != 0) {
            final boolean z16 = true;
            if (i3 != 1) {
                if (i3 != 1000) {
                    if (i3 != 1001 && i3 != 3000 && i3 != 10002 && i3 != 10004 && i3 != 10010) {
                        switch (i3) {
                            case 1004:
                                n nVar = (n) j().getManager(QQManagerFactory.DISCUSSION_MANAGER);
                                if (nVar != null) {
                                    Map<String, DiscussionMemberInfo> n3 = nVar.n(searchHistory.troopUin);
                                    if (n3 != null) {
                                        discussionMemberInfo = n3.get(searchHistory.uin);
                                    } else {
                                        discussionMemberInfo = null;
                                    }
                                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: kp2.f
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            i.this.o(searchHistory, discussionMemberInfo);
                                        }
                                    });
                                    return;
                                }
                                return;
                            case 1005:
                            case 1006:
                                break;
                            default:
                                return;
                        }
                    }
                } else {
                    if (!(context instanceof UniteSearchActivity) || !SearchUtil.w(searchHistory.uin)) {
                        z16 = false;
                    }
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: kp2.g
                        @Override // java.lang.Runnable
                        public final void run() {
                            i.this.p(searchHistory, z16);
                        }
                    });
                    return;
                }
            }
            l(searchHistory, context);
            return;
        }
        final com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(searchHistory.uin), "HistorySearchEntryDataRepo");
        if (friendsSimpleInfoWithUid != null) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: kp2.e
                @Override // java.lang.Runnable
                public final void run() {
                    i.this.n(searchHistory, friendsSimpleInfoWithUid);
                }
            });
        }
    }

    private void k(final Function1<List<com.tencent.mobileqq.search.j>, Void> function1) {
        final QQAppInterface qQAppInterface = (QQAppInterface) j();
        if (qQAppInterface == null) {
            QLog.d("HistorySearchEntryDataRepo", 1, "syncGetSearchHistoryData fail. app is null");
            function1.invoke(Collections.emptyList());
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        final ac acVar = (ac) qQAppInterface.getManager(QQManagerFactory.SEARCHHISTORY_MANAGER);
        if (acVar == null) {
            QLog.d("HistorySearchEntryDataRepo", 1, "syncGetSearchHistoryData fail. not found manager");
            function1.invoke(Collections.emptyList());
        } else {
            acVar.n(new Function1() { // from class: kp2.d
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Void t16;
                    t16 = i.t(ac.this, qQAppInterface, currentTimeMillis, function1, (Boolean) obj);
                    return t16;
                }
            });
        }
    }

    private void l(final SearchHistory searchHistory, final Context context) {
        final AppInterface j3 = j();
        if (j3 == null) {
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: kp2.h
            @Override // java.lang.Runnable
            public final void run() {
                i.this.u(searchHistory, j3, context);
            }
        });
    }

    private boolean m(int i3) {
        if (i3 != 0 && i3 != 1 && i3 != 1000 && i3 != 1001 && i3 != 3000 && i3 != 10002 && i3 != 10004 && i3 != 10010) {
            switch (i3) {
                case 1004:
                case 1005:
                case 1006:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(SearchHistory searchHistory, boolean z16) {
        o(searchHistory, Boolean.valueOf(z16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void q(List list) {
        a.InterfaceC11637a interfaceC11637a = this.f412836a;
        if (interfaceC11637a != null) {
            interfaceC11637a.a(list);
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(com.tencent.mobileqq.search.j jVar) {
        if (j() == null) {
            QLog.d("HistorySearchEntryDataRepo", 1, "deleteHistory fail. app is null");
            v(false, null);
            return;
        }
        ac acVar = (ac) j().getManager(QQManagerFactory.SEARCHHISTORY_MANAGER);
        if (acVar == null) {
            v(false, null);
            return;
        }
        boolean e16 = acVar.e((SearchHistory) jVar.h());
        if (!e16) {
            jVar = null;
        }
        v(e16, jVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void t(ac acVar, QQAppInterface qQAppInterface, long j3, Function1 function1, Boolean bool) {
        ArrayList arrayList = new ArrayList();
        if (bool.booleanValue()) {
            Iterator<SearchHistory> it = acVar.g().iterator();
            while (it.hasNext()) {
                SearchHistory next = it.next();
                if (QLog.isDebugVersion()) {
                    QLog.d("HistorySearchEntryDataRepo", 1, "syncGetSearchHistoryData sh of searchHistory: " + next);
                }
                arrayList.add(new com.tencent.mobileqq.search.d(qQAppInterface, next));
            }
            if (QLog.isColorLevel()) {
                QLog.d("HistorySearchEntryDataRepo", 2, "initSearchHistoryData() time cost = " + (System.currentTimeMillis() - j3) + " , size = " + arrayList.size());
            }
            function1.invoke(arrayList);
            return null;
        }
        function1.invoke(Collections.emptyList());
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(SearchHistory searchHistory, AppInterface appInterface, Context context) {
        String str = searchHistory.displayName;
        if (searchHistory.type == 1) {
            TroopInfo k3 = ((TroopManager) appInterface.getManager(QQManagerFactory.TROOP_MANAGER)).k(searchHistory.uin);
            if (k3 != null) {
                str = k3.getTroopDisplayName();
            }
            Intent intent = new Intent();
            intent.putExtra("uin", searchHistory.uin);
            intent.putExtra("uintype", searchHistory.type);
            if (com.tencent.mobileqq.troop.blocktroop.k.l((Activity) context, appInterface, intent)) {
                return;
            }
        }
        o(searchHistory, str);
    }

    private void v(boolean z16, @Nullable com.tencent.mobileqq.search.j jVar) {
        this.f412838c.compareAndSet(true, false);
        a.InterfaceC11637a interfaceC11637a = this.f412836a;
        if (interfaceC11637a != null) {
            interfaceC11637a.j(z16, jVar);
        }
    }

    private void w(int i3, SearchHistory searchHistory) {
        int i16;
        int i17;
        int i18 = searchHistory.type;
        int i19 = 2;
        if (i18 != 0) {
            if (i18 == 1) {
                i17 = 2;
            } else if (i18 == 3000) {
                i17 = 3;
            } else {
                i17 = 1;
            }
            ReportController.o(null, "CliOper", "", "", "Search", "May_find", 0, 0, String.valueOf(i17), "", "", "");
        }
        int i26 = searchHistory.type;
        if (i26 == 0) {
            i16 = 1;
        } else {
            if (i26 != 1 && i26 != 3000) {
                i19 = 0;
            }
            i16 = i19;
        }
        com.tencent.mobileqq.search.report.b.e(j(), 0, SearchEntryFragment.convertTabTypeToSearchFrom(i3), "0X8009D19", i16, 0, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    /* renamed from: x, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void o(SearchHistory searchHistory, Object obj) {
        String str;
        String[] split;
        Context context = this.f412837b;
        if (context == null) {
            return;
        }
        int i3 = searchHistory.type;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 1000) {
                    if (i3 != 1001 && i3 != 3000 && i3 != 10002 && i3 != 10004) {
                        if (i3 != 10007) {
                            if (i3 != 10010) {
                                switch (i3) {
                                    case 1004:
                                        if (obj instanceof DiscussionMemberInfo) {
                                            RecentUtil.f185176a = true;
                                            RecentUtil.x(context, searchHistory.uin, searchHistory.troopUin, i3, ((DiscussionMemberInfo) obj).memberName, false, null, null);
                                            return;
                                        } else {
                                            RecentUtil.f185176a = true;
                                            RecentUtil.x(context, searchHistory.uin, searchHistory.troopUin, i3, searchHistory.displayName, false, null, null);
                                            return;
                                        }
                                    case 1005:
                                    case 1006:
                                        break;
                                    default:
                                        int i16 = 0;
                                        switch (i3) {
                                            case 10023:
                                                try {
                                                    JSONObject jSONObject = new JSONObject(searchHistory.extralInfo);
                                                    go2.d.a(true, jSONObject.optString("guildId"), jSONObject.optString("joinGuildSig"), null);
                                                    return;
                                                } catch (JSONException e16) {
                                                    QLog.e("HistorySearchEntryDataRepo", 1, e16, new Object[0]);
                                                    return;
                                                }
                                            case 10024:
                                                ax c16 = bi.c((BaseQQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime(), MobileQQ.sMobileQQ, Uri.parse("mqqapi://kuikly/open?src_type=internal&version=1&source=11&target=52&channel=2&page_name=qsearch_detail").buildUpon().appendQueryParameter("sessionId", p.r()).appendQueryParameter("keyword", searchHistory.displayName).appendQueryParameter("func_payload", searchHistory.extralInfo).appendQueryParameter("user_source", "11").appendQueryParameter(QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE, "20").toString());
                                                if (c16 != null) {
                                                    c16.b();
                                                    return;
                                                }
                                                return;
                                            case 10025:
                                                try {
                                                    Uri parse = Uri.parse(new JSONObject(searchHistory.extralInfo).optString(WadlProxyConsts.KEY_JUMP_URL));
                                                    Uri.Builder path = new Uri.Builder().scheme(parse.getScheme()).authority(parse.getAuthority()).path(parse.getPath());
                                                    for (String str2 : parse.getQueryParameterNames()) {
                                                        if (str2.equals("user_source")) {
                                                            path.appendQueryParameter("user_source", "11");
                                                        } else {
                                                            if (!str2.equals(QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE) && !str2.equals("query_source") && !str2.equals("querysource")) {
                                                                path.appendQueryParameter(str2, parse.getQueryParameter(str2));
                                                            }
                                                            path.appendQueryParameter(QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE, "20");
                                                        }
                                                    }
                                                    ax c17 = bi.c((BaseQQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime(), MobileQQ.sMobileQQ, path.build().toString());
                                                    if (c17 != null) {
                                                        c17.b();
                                                        return;
                                                    }
                                                    return;
                                                } catch (JSONException e17) {
                                                    QLog.e("HistorySearchEntryDataRepo", 1, e17, new Object[0]);
                                                    return;
                                                }
                                            default:
                                                switch (i3) {
                                                    case AppConstants.VALUE.UIN_TYPE_UNBIND_PHONE_CONTACT /* 56938 */:
                                                        AllInOne allInOne = new AllInOne(searchHistory.uin, 33);
                                                        allInOne.contactArray = new ArrayList<>();
                                                        allInOne.contactName = searchHistory.displayName;
                                                        if (!TextUtils.isEmpty(searchHistory.uin) && (split = searchHistory.uin.split("\\|")) != null) {
                                                            while (i16 < split.length) {
                                                                ArrayList<ProfileContactInfo> arrayList = allInOne.contactArray;
                                                                StringBuilder sb5 = new StringBuilder();
                                                                sb5.append(HardCodeUtil.qqStr(R.string.n8k));
                                                                int i17 = i16 + 1;
                                                                sb5.append(i17);
                                                                arrayList.add(new ProfileContactInfo(sb5.toString(), split[i16], null));
                                                                i16 = i17;
                                                            }
                                                        }
                                                        allInOne.lastActivity = 3;
                                                        ProfileUtils.openProfileCard(context, allInOne);
                                                        return;
                                                    case AppConstants.VALUE.UIN_TYPE_PHONE_CONTACT_PROFILE_FRIEND /* 56939 */:
                                                    case AppConstants.VALUE.UIN_TYPE_PHONE_CONTACT_PROFILE_UNBIND /* 56942 */:
                                                        AllInOne allInOne2 = new AllInOne(searchHistory.uin, 53);
                                                        allInOne2.contactName = searchHistory.displayName;
                                                        allInOne2.lastActivity = 3;
                                                        ProfileUtils.openProfileCard(context, allInOne2);
                                                        return;
                                                    case AppConstants.VALUE.UIN_TYPE_PHONE_CONTACT_PROFILE_SELFUNBIND /* 56940 */:
                                                        AllInOne allInOne3 = new AllInOne(searchHistory.uin, 29);
                                                        allInOne3.contactName = searchHistory.displayName;
                                                        allInOne3.lastActivity = 3;
                                                        ProfileUtils.openProfileCard(context, allInOne3);
                                                        return;
                                                    case AppConstants.VALUE.UIN_TYPE_PHONE_CONTACT_PROFILE_BIND /* 56941 */:
                                                        AllInOne allInOne4 = new AllInOne(searchHistory.uin, 34);
                                                        allInOne4.contactName = searchHistory.displayName;
                                                        allInOne4.lastActivity = 3;
                                                        ProfileUtils.openProfileCard(context, allInOne4);
                                                        return;
                                                    default:
                                                        return;
                                                }
                                        }
                                }
                            }
                        } else {
                            ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).enterGameMsgChatPie(j(), context, searchHistory.uin, 6);
                            return;
                        }
                    }
                } else {
                    RecentUtil.f185176a = true;
                    if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                        com.tencent.mobileqq.troop.utils.k.o(context, null, searchHistory.uin);
                        return;
                    } else {
                        RecentUtil.x(context, searchHistory.uin, searchHistory.troopUin, searchHistory.type, searchHistory.displayName, false, null, null);
                        return;
                    }
                }
            }
            RecentUtil.f185176a = true;
            QQAppInterface qQAppInterface = (QQAppInterface) j();
            String str3 = searchHistory.uin;
            int i18 = searchHistory.type;
            if (obj instanceof String) {
                str = (String) obj;
            } else {
                str = searchHistory.displayName;
            }
            RecentUtil.s(context, qQAppInterface, str3, i18, str, false);
            return;
        }
        if (obj instanceof com.tencent.qqnt.ntrelation.friendsinfo.bean.d) {
            RecentUtil.f185176a = true;
            RecentUtil.s(context, (QQAppInterface) j(), searchHistory.uin, 0, SearchUtils.x((com.tencent.qqnt.ntrelation.friendsinfo.bean.d) obj), false);
        }
    }

    @Override // yx3.a
    public void asyncGetSearchHistoryData(a.InterfaceC11637a interfaceC11637a) {
        if (interfaceC11637a == null) {
            return;
        }
        this.f412836a = interfaceC11637a;
        k(new Function1() { // from class: kp2.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Void q16;
                q16 = i.this.q((List) obj);
                return q16;
            }
        });
    }

    @Override // yx3.a
    public void deleteHistory(final com.tencent.mobileqq.search.j jVar) {
        if (!(jVar instanceof com.tencent.mobileqq.search.d)) {
            QLog.d("HistorySearchEntryDataRepo", 1, "deleteHistory fail. data is not instanceof ContactSearchableSearchHistory");
        } else if (this.f412838c.get()) {
            QLog.d("HistorySearchEntryDataRepo", 1, "deleteHistory fail. is deleting, not retry");
            v(false, null);
        } else {
            this.f412838c.compareAndSet(false, true);
            ThreadManagerV2.excute(new Runnable() { // from class: kp2.a
                @Override // java.lang.Runnable
                public final void run() {
                    i.this.r(jVar);
                }
            }, 32, null, true);
        }
    }

    @Override // yx3.a
    public void destroy() {
        this.f412838c.compareAndSet(true, false);
        this.f412836a = null;
        this.f412837b = null;
    }

    @Override // yx3.a
    public void doSearchHistoryAction(Context context, int i3, int i16, com.tencent.mobileqq.search.j jVar) {
        if (!(jVar instanceof com.tencent.mobileqq.search.d)) {
            QLog.d("HistorySearchEntryDataRepo", 1, "info not instanceof ContactSearchableSearchHistory!");
            return;
        }
        SearchUtils.W0("home_page", "clk_history", String.valueOf(i16));
        final SearchHistory h16 = ((com.tencent.mobileqq.search.d) jVar).h();
        int i17 = h16.type;
        if (i17 != 10023 && i17 != 10025 && i17 != 10024) {
            SearchUtils.f1(j(), h16.displayName, h16.uin, h16.troopUin, h16.type);
        } else {
            SearchUtils.g1(h16.displayName, i17, h16.troopUin, h16.extralInfo);
        }
        w(i3, h16);
        if (m(h16.type)) {
            ThreadManagerV2.excute(new Runnable() { // from class: kp2.c
                @Override // java.lang.Runnable
                public final void run() {
                    i.this.s(h16);
                }
            }, 16, null, true);
        } else {
            o(h16, null);
        }
    }

    @Override // yx3.a
    public void init(AppInterface appInterface, Context context) {
        this.f412837b = context;
        if (((ac) appInterface.getManager(QQManagerFactory.SEARCHHISTORY_MANAGER)) == null) {
            QLog.d("HistorySearchEntryDataRepo", 2, "preload init history list");
        }
    }

    public AppInterface j() {
        return (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
    }
}

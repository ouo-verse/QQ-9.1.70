package com.tencent.mobileqq.search.searchlocal.repository.history;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.msf.MSFAccountChangeRegisterTask;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.search.searchlocal.model.SearchHistory;
import com.tencent.mobileqq.troop.api.IDiscussionService;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016J\"\u0010\u0013\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0011H\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J&\u0010\u0018\u001a\u00020\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00112\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/search/searchlocal/repository/history/a;", "", "Lcom/tencent/mobileqq/search/searchlocal/model/SearchHistory;", "sh", "", "f", "", "e", "history", "Lcom/tencent/mobileqq/phonecontact/api/IPhoneContactService;", "pcm", "c", "b", "g", "a", "", "uin", "Lhx3/b;", "callback", "d", "getGroupNameByUin", "groupName", "", "code", "responseDataToCallback", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public interface a {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.search.searchlocal.repository.history.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public static final class C8548a {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/search/searchlocal/repository/history/a$a$a", "Lhx3/b;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/b;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/e;", WebViewPlugin.KEY_RESPONSE, "", "onQueryResult", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.search.searchlocal.repository.history.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes18.dex */
        public static final class C8549a implements hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ a f284831a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ hx3.b<String> f284832b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f284833c;

            C8549a(a aVar, hx3.b<String> bVar, String str) {
                this.f284831a = aVar;
                this.f284832b = bVar;
                this.f284833c = str;
            }

            @Override // hx3.b
            public void onQueryResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> responseData) {
                if (responseData == null || responseData.a() != 0) {
                    C8548a.j(this.f284831a, this.f284832b, this.f284833c, -1);
                    return;
                }
                ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> b16 = responseData.b();
                if (b16 == null || b16.size() == 0) {
                    C8548a.j(this.f284831a, this.f284832b, this.f284833c, -1);
                    return;
                }
                com.tencent.qqnt.ntrelation.friendsinfo.bean.b bVar = b16.get(0);
                Intrinsics.checkNotNullExpressionValue(bVar, "ntCategoryInfoList[0]");
                String f16 = bVar.f();
                a aVar = this.f284831a;
                hx3.b<String> bVar2 = this.f284832b;
                if (f16 == null) {
                    f16 = this.f284833c;
                }
                C8548a.j(aVar, bVar2, f16, 0);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\u0006\u001a\u00020\u00052\u0010\b\u0001\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/search/searchlocal/repository/history/a$a$b", "Lhx3/b;", "", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/e;", WebViewPlugin.KEY_RESPONSE, "", "onQueryResult", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.search.searchlocal.repository.history.a$a$b */
        /* loaded from: classes18.dex */
        public static final class b implements hx3.b<String> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ SearchHistory f284834a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ a f284835b;

            b(SearchHistory searchHistory, a aVar) {
                this.f284834a = searchHistory;
                this.f284835b = aVar;
            }

            /* JADX WARN: Code restructure failed: missing block: B:7:0x0015, code lost:
            
                if ((!r0.isEmpty()) == true) goto L11;
             */
            @Override // hx3.b
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onQueryResult(@androidx.annotation.Nullable @Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<String> responseData) {
                boolean z16;
                String str;
                if (responseData != null && responseData.a() == 0) {
                    if (responseData.b() != null) {
                        z16 = true;
                    }
                    z16 = false;
                    if (z16) {
                        SearchHistory searchHistory = this.f284834a;
                        ArrayList<String> b16 = responseData.b();
                        if (b16 != null) {
                            str = b16.get(0);
                        } else {
                            str = null;
                        }
                        searchHistory.extralInfo = str;
                    }
                }
                SearchHistory searchHistory2 = this.f284834a;
                if (searchHistory2.extralInfo == null) {
                    searchHistory2.extralInfo = HardCodeUtil.qqStr(R.string.t6r);
                }
                SearchHistory searchHistory3 = this.f284834a;
                searchHistory3.key = searchHistory3.uin + HippyQQConstants.HIPPY_CHANNEL;
                this.f284835b.f(this.f284834a);
            }
        }

        public static boolean b(@NotNull a aVar, @NotNull SearchHistory history) {
            Intrinsics.checkNotNullParameter(history, "history");
            Object findDiscussionInfoByID = ((IDiscussionService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IDiscussionService.class, "")).findDiscussionInfoByID(history.uin);
            Intrinsics.checkNotNull(findDiscussionInfoByID, "null cannot be cast to non-null type com.tencent.mobileqq.data.DiscussionInfo");
            return ((DiscussionInfo) findDiscussionInfoByID).isHidden();
        }

        public static boolean c(@NotNull a aVar, @NotNull SearchHistory history) {
            DiscussionInfo discussionInfo;
            Intrinsics.checkNotNullParameter(history, "history");
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(history.uin);
            IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
            Intrinsics.checkNotNullExpressionValue(uid, "uid");
            boolean isFriend = iFriendsInfoService.isFriend(uid, "searchHistory");
            int i3 = history.type;
            if (i3 == 1000) {
                return false;
            }
            if (i3 == 1004) {
                Object findDiscussionInfoByID = ((IDiscussionService) peekAppRuntime.getRuntimeService(IDiscussionService.class, "")).findDiscussionInfoByID(history.troopUin);
                if (findDiscussionInfoByID instanceof DiscussionInfo) {
                    discussionInfo = (DiscussionInfo) findDiscussionInfoByID;
                } else {
                    discussionInfo = null;
                }
                if (discussionInfo == null || discussionInfo.isDiscussHrMeeting() || discussionInfo.isHidden()) {
                    return true;
                }
                return isFriend;
            }
            return isFriend;
        }

        public static boolean d(@NotNull a aVar, @NotNull SearchHistory history) {
            PhoneContact queryContactByCodeNumber;
            Intrinsics.checkNotNullParameter(history, "history");
            IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IPhoneContactService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService<IP\u2026va, ProcessConstant.MAIN)");
            IPhoneContactService iPhoneContactService = (IPhoneContactService) runtimeService;
            if (iPhoneContactService.isBindedIgnoreUpload() || (queryContactByCodeNumber = iPhoneContactService.queryContactByCodeNumber(history.uin)) == null || TextUtils.isEmpty(queryContactByCodeNumber.uin)) {
                return true;
            }
            return false;
        }

        public static boolean e(@NotNull a aVar, @NotNull SearchHistory history, @NotNull IPhoneContactService pcm) {
            PhoneContact queryContactByCodeNumber;
            Intrinsics.checkNotNullParameter(history, "history");
            Intrinsics.checkNotNullParameter(pcm, "pcm");
            if (!pcm.isBindedIgnoreUpload() || (queryContactByCodeNumber = pcm.queryContactByCodeNumber(history.uin)) == null || !Intrinsics.areEqual("0", queryContactByCodeNumber.uin)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00e9, code lost:
        
            if (r0 == true) goto L56;
         */
        /* JADX WARN: Failed to find 'out' block for switch in B:14:0x0039. Please report as an issue. */
        /* JADX WARN: Failed to find 'out' block for switch in B:15:0x003c. Please report as an issue. */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static boolean f(@NotNull a aVar, @NotNull SearchHistory history) {
            TroopInfo troopInfo;
            boolean z16;
            Intrinsics.checkNotNullParameter(history, "history");
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IPhoneContactService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService<IP\u2026va, ProcessConstant.MAIN)");
            IPhoneContactService iPhoneContactService = (IPhoneContactService) runtimeService;
            int i3 = history.type;
            boolean z17 = true;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 1000 && i3 != 1004) {
                        if (i3 != 1008) {
                            if (i3 == 1021) {
                                return true;
                            }
                            if (i3 != 3000) {
                                switch (i3) {
                                    case 10023:
                                    case 10024:
                                    case 10025:
                                        return true ^ SearchHistoryConfig.f284826a.b();
                                    default:
                                        switch (i3) {
                                            case AppConstants.VALUE.UIN_TYPE_PHONE_CONTACT_PROFILE_FRIEND /* 56939 */:
                                                PhoneContact queryContactByCodeNumber = iPhoneContactService.queryContactByCodeNumber(history.uin);
                                                if (queryContactByCodeNumber == null || TextUtils.isEmpty(queryContactByCodeNumber.uin) || Intrinsics.areEqual("0", queryContactByCodeNumber.uin)) {
                                                    return true;
                                                }
                                                break;
                                            case AppConstants.VALUE.UIN_TYPE_PHONE_CONTACT_PROFILE_SELFUNBIND /* 56940 */:
                                                return aVar.g(history);
                                            case AppConstants.VALUE.UIN_TYPE_PHONE_CONTACT_PROFILE_BIND /* 56941 */:
                                                return aVar.c(history, iPhoneContactService);
                                            case AppConstants.VALUE.UIN_TYPE_PHONE_CONTACT_PROFILE_UNBIND /* 56942 */:
                                                PhoneContact queryContactByCodeNumber2 = iPhoneContactService.queryContactByCodeNumber(history.uin);
                                                if (queryContactByCodeNumber2 != null && !TextUtils.isEmpty(queryContactByCodeNumber2.uin)) {
                                                    return true;
                                                }
                                                break;
                                        }
                                }
                            } else {
                                return aVar.b(history);
                            }
                        } else {
                            if (!TextUtils.equals(history.uin, AppConstants.NEW_KANDIAN_UIN) || ((IReadInJoyHelper) QRoute.api(IReadInJoyHelper.class)).isInReadinjoyFolderMergerStyle()) {
                                return true;
                            }
                            IPublicAccountConfigUtil iPublicAccountConfigUtil = (IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class);
                            Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
                            history.displayName = iPublicAccountConfigUtil.getXinKandianName((AppInterface) peekAppRuntime, BaseApplication.getContext());
                        }
                    } else {
                        return aVar.a(history);
                    }
                } else {
                    ITroopInfoService iTroopInfoService = (ITroopInfoService) bg.l(ITroopInfoService.class);
                    if (iTroopInfoService != null) {
                        troopInfo = iTroopInfoService.findTroopInfo(history.uin);
                    } else {
                        troopInfo = null;
                    }
                    if (troopInfo == null) {
                        return true;
                    }
                    String newTroopNameOrTroopName = troopInfo.getNewTroopNameOrTroopName();
                    if (newTroopNameOrTroopName != null) {
                        if (newTroopNameOrTroopName.length() > 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                    }
                    z17 = false;
                    if (z17) {
                        history.displayName = troopInfo.getNewTroopNameOrTroopName();
                    }
                }
            } else {
                String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(history.uin);
                IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
                Intrinsics.checkNotNullExpressionValue(uid, "uid");
                if (!iFriendsInfoService.isFriend(uid, "searchHistory")) {
                    return true;
                }
            }
            return false;
        }

        public static boolean g(@NotNull a aVar, @NotNull SearchHistory history) {
            Intrinsics.checkNotNullParameter(history, "history");
            if (history.type == 10028) {
                return true;
            }
            return false;
        }

        public static void h(@NotNull a aVar, @Nullable String str, @Nullable hx3.b<String> bVar) {
            if (bVar == null) {
                return;
            }
            if (TextUtils.isEmpty(str)) {
                j(aVar, bVar, "", -1);
                return;
            }
            String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
            QRouteApi api = QRoute.api(IFriendsInfoService.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IFriendsInfoService::class.java)");
            IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) api;
            IFriendsInfoService iFriendsInfoService2 = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
            Intrinsics.checkNotNullExpressionValue(uid, "uid");
            com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = iFriendsInfoService2.getFriendsSimpleInfoWithUid(uid, "searchHistory");
            if (friendsSimpleInfoWithUid == null) {
                j(aVar, bVar, "", -1);
            } else {
                iFriendsInfoService.getCategoryInfoWithCategoryId(friendsSimpleInfoWithUid.f(), "searchHistory", new C8549a(aVar, bVar, ""));
            }
        }

        public static boolean i(@NotNull a aVar, @NotNull SearchHistory sh5) {
            Intrinsics.checkNotNullParameter(sh5, "sh");
            sh5.count = 1;
            sh5.time = System.currentTimeMillis();
            int i3 = sh5.type;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 1000) {
                        if (i3 != 1004) {
                            if (i3 != 1006) {
                                if (i3 != 1008) {
                                    if (i3 != 1021) {
                                        if (i3 != 3000) {
                                            if (i3 != 7220) {
                                                if (i3 != 10007) {
                                                    if (i3 != 10028) {
                                                        switch (i3) {
                                                            case 10023:
                                                                sh5.key = sh5.displayName + i3 + sh5.troopUin;
                                                                if (!SearchHistoryConfig.f284826a.b()) {
                                                                    return true;
                                                                }
                                                                return false;
                                                            case 10024:
                                                            case 10025:
                                                                sh5.key = sh5.displayName + i3;
                                                                if (!SearchHistoryConfig.f284826a.b() || aVar.e(sh5)) {
                                                                    return true;
                                                                }
                                                                return false;
                                                            default:
                                                                switch (i3) {
                                                                    case AppConstants.VALUE.UIN_TYPE_UNBIND_PHONE_CONTACT /* 56938 */:
                                                                    case AppConstants.VALUE.UIN_TYPE_PHONE_CONTACT_PROFILE_FRIEND /* 56939 */:
                                                                    case AppConstants.VALUE.UIN_TYPE_PHONE_CONTACT_PROFILE_SELFUNBIND /* 56940 */:
                                                                    case AppConstants.VALUE.UIN_TYPE_PHONE_CONTACT_PROFILE_BIND /* 56941 */:
                                                                    case AppConstants.VALUE.UIN_TYPE_PHONE_CONTACT_PROFILE_UNBIND /* 56942 */:
                                                                        break;
                                                                    default:
                                                                        return true;
                                                                }
                                                        }
                                                    } else {
                                                        sh5.key = sh5.displayName + i3;
                                                        return false;
                                                    }
                                                } else {
                                                    sh5.extralInfo = "\u6e38\u620f\u6d88\u606f";
                                                    sh5.key = sh5.uin + HippyQQConstants.HIPPY_CHANNEL;
                                                    return false;
                                                }
                                            } else {
                                                sh5.extralInfo = HardCodeUtil.qqStr(R.string.t6w);
                                                sh5.key = sh5.uin + HippyQQConstants.HIPPY_CHANNEL;
                                                return false;
                                            }
                                        } else {
                                            sh5.extralInfo = HardCodeUtil.qqStr(R.string.t6s);
                                            sh5.key = sh5.uin + MSFAccountChangeRegisterTask.MSF_DEFAULT_UIN;
                                            return false;
                                        }
                                    } else {
                                        sh5.extralInfo = HardCodeUtil.qqStr(R.string.t6q);
                                        sh5.key = sh5.uin + HippyQQConstants.HIPPY_CHANNEL;
                                        return false;
                                    }
                                } else {
                                    if (TextUtils.equals(sh5.uin, AppConstants.NEW_KANDIAN_UIN)) {
                                        sh5.extralInfo = HardCodeUtil.qqStr(R.string.t6v);
                                        sh5.key = sh5.uin + HippyQQConstants.HIPPY_CHANNEL;
                                        return false;
                                    }
                                    return false;
                                }
                            }
                            sh5.extralInfo = HardCodeUtil.qqStr(R.string.t6t);
                            sh5.key = sh5.uin + HippyQQConstants.HIPPY_CHANNEL;
                            return false;
                        }
                        sh5.extralInfo = HardCodeUtil.qqStr(R.string.t6x);
                        sh5.key = sh5.uin + HippyQQConstants.HIPPY_CHANNEL;
                        return false;
                    }
                    sh5.extralInfo = HardCodeUtil.qqStr(R.string.t6y);
                    sh5.key = sh5.uin + HippyQQConstants.HIPPY_CHANNEL;
                    return false;
                }
                sh5.extralInfo = HardCodeUtil.qqStr(R.string.t6u);
                sh5.key = sh5.uin + MSFAccountChangeRegisterTask.MSF_DEFAULT_UIN;
                return false;
            }
            aVar.d(sh5.uin, new b(sh5, aVar));
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void j(a aVar, hx3.b<String> bVar, String str, int i3) {
            com.tencent.qqnt.ntrelation.friendsinfo.bean.e<String> eVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.e<>();
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(str);
            eVar.d(i3);
            eVar.e(arrayList);
            bVar.onQueryResult(eVar);
        }
    }

    boolean a(@NotNull SearchHistory history);

    boolean b(@NotNull SearchHistory history);

    boolean c(@NotNull SearchHistory history, @NotNull IPhoneContactService pcm);

    void d(@Nullable String uin, @Nullable hx3.b<String> callback);

    boolean e(@NotNull SearchHistory sh5);

    void f(@NotNull SearchHistory sh5);

    boolean g(@NotNull SearchHistory history);
}

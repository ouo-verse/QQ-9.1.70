package com.tencent.mobileqq.search.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import com.tencent.biz.lebasearch.Utils;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.AddFriendActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.UniteSearchHandler;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.guild.api.IQQGuildService;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.SearchHistoryEntity;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.ac;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.api.ISearchUtilFetcher;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchActivity;
import com.tencent.mobileqq.search.ftsentity.FTSEntitySearchDetailActivity;
import com.tencent.mobileqq.search.model.SearchResultItem;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mobileqq.search.model.z;
import com.tencent.mobileqq.search.mostused.MostUsedSearchResultManager;
import com.tencent.mobileqq.search.searchlocal.model.SearchHistory;
import com.tencent.mobileqq.search.util.SearchEnginePerfReporter;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.af;
import com.tencent.mobileqq.search.util.t;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.api.ISubAccountAssistantForward;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.k;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.functions.Function1;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import wn2.f;
import wn2.h;
import wn2.i;
import wn2.q;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SearchUtilFetcherImpl implements ISearchUtilFetcher {
    private static final String TAG = "SearchUtilFetcherImpl";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void lambda$loadSearchHistory$0(ac acVar, Function1 function1, Boolean bool) {
        ArrayList arrayList = new ArrayList();
        ArrayList<SearchHistory> g16 = acVar.g();
        for (int i3 = 0; i3 < g16.size(); i3++) {
            SearchHistory searchHistory = g16.get(i3);
            arrayList.add(new SearchHistoryEntity(searchHistory.getId(), searchHistory.displayName, searchHistory.type, searchHistory.extralInfo));
        }
        function1.invoke(arrayList);
        return null;
    }

    @Override // com.tencent.mobileqq.search.api.ISearchUtilFetcher
    public void fTSEntitySearchActivityLaunch(Context context, String str, int i3) {
        FTSEntitySearchActivity.P2(context, str, i3);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchUtilFetcher
    public void fTSEntitySearchDetailActivityLaunch(Context context, String str, String str2, CharSequence charSequence, List list, int i3, String str3, int i16, int i17, int i18) {
        FTSEntitySearchDetailActivity.J2(context, str, str2, charSequence, list, i3, str3, i16, i17, i18);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchUtilFetcher
    public Class getActiveEntitySearchActivityClass() {
        return ActiveEntitySearchActivity.class;
    }

    @Override // com.tencent.mobileqq.search.api.ISearchUtilFetcher
    public Drawable getFaceBitmap(IFaceDecoder iFaceDecoder, String str, int i3) {
        int i16;
        if (i3 == 103) {
            i16 = 1;
        } else {
            i16 = i3;
        }
        Bitmap bitmapFromCache = iFaceDecoder.getBitmapFromCache(i16, str);
        if (bitmapFromCache != null) {
            if (i3 == 103) {
                return SearchUtils.r0(bitmapFromCache);
            }
            return new BitmapDrawable(bitmapFromCache);
        }
        if (!iFaceDecoder.isPausing()) {
            iFaceDecoder.requestDecodeFace(str, i16, true, (byte) 1);
        }
        if (i3 == 1) {
            return BaseImageUtil.getDefaultFaceDrawable();
        }
        if (i3 == 101) {
            return BaseImageUtil.getDefaultDiscusionFaceDrawable();
        }
        if (i3 == 4) {
            return BaseImageUtil.getDefaultTroopFaceDrawable();
        }
        if (i3 == 11) {
            return new BitmapDrawable(BaseImageUtil.getDefaultPhoneContactBitmap());
        }
        if (i3 == 102) {
            return BaseApplicationImpl.sApplication.getResources().getDrawable(R.drawable.ogi);
        }
        if (i3 == 107) {
            return BaseApplicationImpl.sApplication.getResources().getDrawable(R.drawable.ogk);
        }
        if (i3 == 120) {
            return BaseApplicationImpl.sApplication.getResources().getDrawable(R.drawable.ogl);
        }
        if (i3 == 106) {
            return BaseApplicationImpl.sApplication.getResources().getDrawable(R.drawable.qvip_aio_shop_assist_tab_icon);
        }
        if (i3 == 105) {
            IPublicAccountConfigUtil.a folder = ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getFolder((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime(), BaseApplication.getContext(), 1);
            if (folder != null && folder.a() != null) {
                return folder.a();
            }
            return ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getDefaultDrawable(BaseApplicationImpl.sApplication, 1);
        }
        if (String.valueOf(AppConstants.LBS_HELLO_UIN_LONGVALUE).equals(str)) {
            return BaseApplicationImpl.sApplication.getResources().getDrawable(R.drawable.icon_recent_lbs_hello);
        }
        if (String.valueOf(AppConstants.TROOP_ASSISTANT_UIN_LONGVALUE).equals(str)) {
            return BaseApplicationImpl.sApplication.getResources().getDrawable(R.drawable.icon_recent_troop_assistant);
        }
        if (String.valueOf(AppConstants.SUBACCOUNT_ASSISTANT_UIN_LONGVALUE).equals(str)) {
            return BaseApplicationImpl.sApplication.getResources().getDrawable(R.drawable.icon_recent_subaccount);
        }
        if (AppConstants.SERVICE_ACCOUNT_FOLDER_UIN.equals(str)) {
            return ServiceAccountFolderManager.c();
        }
        if (String.valueOf(AppConstants.TROOP_NOTIFICATION_UIN_LONGVALUE).equals(str)) {
            return BaseApplicationImpl.sApplication.getResources().getDrawable(R.drawable.icon_recent_sysmsg);
        }
        if (String.valueOf(9973L).equals(str)) {
            return BaseApplicationImpl.sApplication.getResources().getDrawable(R.drawable.qq_af_icon);
        }
        if (i3 == 9889987) {
            return BaseApplicationImpl.sApplication.getResources().getDrawable(R.drawable.qui_group_build_white_brand_bg);
        }
        if (i3 == 108) {
            AppRuntime runtime = BaseApplicationImpl.sApplication.getRuntime();
            if (runtime != null) {
                return ((BlessManager) runtime.getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).H();
            }
        } else {
            if (String.valueOf(AppConstants.RECOMMEND_CONTACT_UIN).equals(str)) {
                return BaseApplicationImpl.sApplication.getResources().getDrawable(R.drawable.cqe);
            }
            if (i3 == 110) {
                IPublicAccountConfigUtil.a folder2 = ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getFolder((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime(), BaseApplicationImpl.sApplication, 2);
                if (folder2 != null && folder2.a() != null) {
                    return folder2.a().getConstantState().newDrawable();
                }
                return ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getDefaultDrawable(BaseApplicationImpl.sApplication, 2).getConstantState().newDrawable();
            }
            if (i3 == 111) {
                IPublicAccountConfigUtil.a folder3 = ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getFolder((QQAppInterface) BaseApplicationImpl.sApplication.getRuntime(), BaseApplicationImpl.sApplication, 3);
                if (folder3 != null && folder3.a() != null) {
                    return folder3.a().getConstantState().newDrawable();
                }
                return ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getDefaultDrawable(BaseApplicationImpl.sApplication, 3).getConstantState().newDrawable();
            }
            if (i3 == 117) {
                return ((IQQGuildService) BaseApplicationImpl.sApplication.getRuntime().getRuntimeService(IQQGuildService.class, "")).getAvatarDrawable(str);
            }
            if (i3 == 119) {
                AppRuntime runtime2 = BaseApplicationImpl.sApplication.getRuntime();
                if (runtime2 instanceof AppInterface) {
                    return ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).getGameMsgAvatarDrawable((AppInterface) runtime2, str);
                }
            }
        }
        return BaseImageUtil.getDefaultFaceDrawable();
    }

    @Override // com.tencent.mobileqq.search.api.ISearchUtilFetcher
    public Manager getLocalSearchManager(AppInterface appInterface) {
        return appInterface.getManager(QQManagerFactory.MINI_APP_LOCAL_SEARCH);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchUtilFetcher
    public boolean getSearchUtilIsContentFromHotWord() {
        return SearchUtil.f282612b;
    }

    @Override // com.tencent.mobileqq.search.api.ISearchUtilFetcher
    public Class getUniteSearchActivityClass() {
        return UniteSearchActivity.class;
    }

    @Override // com.tencent.mobileqq.search.api.ISearchUtilFetcher
    public int getUniteSearchActivityFromForHistoryCode() {
        return UniteSearchActivity.f282684b0;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:27:0x0044. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:28:0x0047. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d5 A[FALL_THROUGH] */
    @Override // com.tencent.mobileqq.search.api.ISearchUtilFetcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleFeatureJump(Context context, int i3, int i16) {
        HashMap hashMap = new HashMap();
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        if (i3 != 2 && i3 != 18 && i3 != 4 && i3 != 5 && i3 != 6 && i3 != 14 && i3 != 15 && i3 != 27 && i3 != 28) {
            if (i3 != 40) {
                if (i3 != 41) {
                    if (i3 != 43) {
                        if (i3 != 44) {
                            switch (i3) {
                                default:
                                    switch (i3) {
                                        case 30:
                                            Utils.gotoFaceToFaceSend(context, hashMap);
                                            return;
                                        default:
                                            switch (i3) {
                                                case 35:
                                                case 36:
                                                case 37:
                                                case 38:
                                                    break;
                                                default:
                                                    return;
                                            }
                                        case 31:
                                        case 32:
                                        case 33:
                                            hashMap.put(Utils.KEY_NEW_TASK, Boolean.FALSE);
                                            hashMap.put(Utils.KEY_BUSINESS_ID, Integer.valueOf(i3));
                                            Utils.gotoFunctionActivity(context, hashMap);
                                    }
                                case 8:
                                case 9:
                                case 10:
                                    break;
                            }
                        } else {
                            Intent intent = new Intent(context, (Class<?>) ActivateFriendActivity.class);
                            intent.putExtra("af_key_from", 5);
                            context.startActivity(intent);
                            if (i16 == 2 || i16 == 1) {
                                ReportController.o(qQAppInterface, "CliOper", "", "", "0X8006477", "0X8006477", i16, 0, "", "", "", "");
                                return;
                            }
                            return;
                        }
                    } else {
                        com.tencent.biz.subscribe.d.j(context, 9005, null);
                        if (QLog.isColorLevel()) {
                            QLog.d("ContactSearchModelTool", 2, "enterServiceAccountFolderActivityFromSearch");
                            return;
                        }
                        return;
                    }
                } else {
                    ((INewFriendApi) QRoute.api(INewFriendApi.class)).startActivity(context, null, 0);
                    return;
                }
            } else {
                ((ISubAccountAssistantForward) QRoute.api(ISubAccountAssistantForward.class)).forwardTo(qQAppInterface, context, String.valueOf(AppConstants.SUBACCOUNT_ASSISTANT_UIN_LONGVALUE));
                qQAppInterface.getMessageFacade().O0(String.valueOf(AppConstants.SUBACCOUNT_ASSISTANT_UIN_LONGVALUE), 7000);
                return;
            }
        }
        hashMap.put(Utils.KEY_NEW_TASK, Boolean.FALSE);
        hashMap.put(Utils.KEY_BUSINESS_ID, Integer.valueOf(i3));
        Utils.gotoFunctionActivity(context, hashMap);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchUtilFetcher
    public boolean isEntityGroup(long j3) {
        if (j3 <= 0 || j3 == 1073745984 || j3 == 2049 || j3 == 1004 || j3 == 64 || j3 == 4097) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.search.api.ISearchUtilFetcher
    public boolean isGuildModel(y yVar) {
        if (yVar instanceof h) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.search.api.ISearchUtilFetcher
    public boolean isRobotUin(AppRuntime appRuntime, String str) {
        return k.l(appRuntime, str);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchUtilFetcher
    public boolean isTroopModel(y yVar) {
        if (!(yVar instanceof wn2.a) && !(yVar instanceof f) && !(yVar instanceof i) && !(yVar instanceof q)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.search.api.ISearchUtilFetcher
    public boolean isUniteSearchActivity(Context context) {
        if (((Activity) context) instanceof UniteSearchActivity) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.search.api.ISearchUtilFetcher
    public boolean isValidGroupMask(long j3) {
        for (long j16 : UniteSearchHandler.f195177i) {
            if (j16 == j3) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.search.api.ISearchUtilFetcher
    public void launchActiveEntitySearchActivity(boolean z16, Context context, String str, String str2, long[] jArr) {
        ActiveEntitySearchActivity.G0 = z16;
        ActiveEntitySearchActivity.c3(context, str, str2, jArr);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchUtilFetcher
    public void loadSearchHistory(final Function1<List<SearchHistoryEntity>, Void> function1) {
        final ac acVar = (ac) MobileQQ.sMobileQQ.peekAppRuntime().getManager(QQManagerFactory.SEARCHHISTORY_MANAGER);
        if (acVar == null) {
            function1.invoke(Collections.emptyList());
        } else {
            acVar.n(new Function1() { // from class: com.tencent.mobileqq.search.api.impl.d
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Void lambda$loadSearchHistory$0;
                    lambda$loadSearchHistory$0 = SearchUtilFetcherImpl.lambda$loadSearchHistory$0(ac.this, function1, (Boolean) obj);
                    return lambda$loadSearchHistory$0;
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.search.api.ISearchUtilFetcher
    public void mobileReportAction(String str, String str2, String str3, String str4, String str5, int i3, int i16, long j3) {
        MobileReportManager.getInstance().reportAction(str, str2, str3, str4, str5, i3, i16, j3);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchUtilFetcher
    public void openRobotProfileCard(Context context, String str, String str2) {
        k.o(context, str, str2);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchUtilFetcher
    public void openTroopInfoActivity(Context context, Bundle bundle, int i3) {
        TroopUtils.I(context, bundle, i3);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchUtilFetcher
    public void publicFragmentStart(Context context, Intent intent, Class cls) {
        PublicFragmentActivity.start(context, intent, cls);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchUtilFetcher
    public boolean removeHistoryById(long j3) {
        ac acVar = (ac) MobileQQ.sMobileQQ.peekAppRuntime().getManager(QQManagerFactory.SEARCHHISTORY_MANAGER);
        if (acVar == null) {
            QLog.e("searchUtils", 2, "shm is null, do not remove");
            return false;
        }
        SearchHistory searchHistory = new SearchHistory();
        searchHistory.setId(j3);
        return acVar.e(searchHistory);
    }

    public void report(String str, String str2, String... strArr) {
        report(str, str2, 0, 0, strArr);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchUtilFetcher
    public void reportContactResultItemClick(z zVar, View view) {
        if (zVar instanceof com.tencent.mobileqq.search.model.k) {
            SearchUtil.z((com.tencent.mobileqq.search.model.k) zVar, view);
        }
    }

    @Override // com.tencent.mobileqq.search.api.ISearchUtilFetcher
    public void reportJumpToAIOorProfile(String str, int i3, View view, boolean z16) {
        if (z16) {
            if (QLog.isColorLevel()) {
                QLog.d("searchUtils", 2, "moduleType:40 -3 searchKey:");
            }
            ReportController.o(null, "CliOper", "", "", "0X8005E12", "0X8005E12", 40, 0, "3", "", "", "");
            return;
        }
        if (isUniteSearchActivity(view.getContext())) {
            if (QLog.isColorLevel()) {
                QLog.d("searchUtils", 2, "moduleType:" + i3 + " -1 searchKey:");
            }
            ReportController.o(null, "CliOper", "", "", "0X8005E12", "0X8005E12", i3, 0, "1", "", "", "");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("searchUtils", 2, "moduleType:" + i3 + " -2 searchKey:");
        }
        ReportController.o(null, "CliOper", "", "", "0X8005E12", "0X8005E12", i3, 0, "2", "", "", "");
    }

    @Override // com.tencent.mobileqq.search.api.ISearchUtilFetcher
    public void reportSearchResultClickItem(z zVar) {
        if (zVar instanceof lo2.c) {
            t.i((lo2.c) zVar);
        }
    }

    @Override // com.tencent.mobileqq.search.api.ISearchUtilFetcher
    public void reportSearchResultClickMore(List<y> list, String str) {
        t.j(list, str);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchUtilFetcher
    public void saveSearchHistory(AppInterface appInterface, String str, String str2, String str3, int i3) {
        saveSearchHistory(appInterface, str, str2, str3, i3, "");
    }

    @Override // com.tencent.mobileqq.search.api.ISearchUtilFetcher
    public void searchEnginePerfReporterAddParams(String str, String str2, Object obj) {
        SearchEnginePerfReporter.g(str, str2, obj);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchUtilFetcher
    public void searchEnginePerfReporterEndStep(String str, String str2) {
        SearchEnginePerfReporter.m(str, str2);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchUtilFetcher
    public void searchEnginePerfReporterStartStep(String str, String str2) {
        SearchEnginePerfReporter.v(str, str2);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchUtilFetcher
    public void selectContactResult(View view, z zVar) {
        if (zVar instanceof com.tencent.mobileqq.search.model.k) {
            SearchUtil.C(view, (com.tencent.mobileqq.search.model.k) zVar);
        }
    }

    @Override // com.tencent.mobileqq.search.api.ISearchUtilFetcher
    public ArrayList<String> splitSearchKeyword(String str) {
        return vy2.b.l(str);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchUtilFetcher
    public void startProfileCardActivity(Activity activity, SearchResultItem searchResultItem, AppInterface appInterface, boolean z16, int i3) {
        AddFriendActivity.startProfileCardActivity(activity, searchResultItem, (QQAppInterface) appInterface, true, i3);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchUtilFetcher
    public void updateItemUsed(AppInterface appInterface, String str, String str2, String str3, int i3) {
        ((MostUsedSearchResultManager) appInterface.getManager(QQManagerFactory.MOST_USE_SEARCH_MANAGER)).c(str, str2, str3, i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.search.api.ISearchUtilFetcher
    public void report(Context context, String str, String str2) {
        if (context instanceof nn2.b) {
            nn2.b bVar = (nn2.b) context;
            report(str, str2, bVar.getSearchKeyword(), "" + bVar.getCurrentPageMasks(), "", SearchUtils.g0("dynamic_tab_search.1", bVar.getCurrentPageMasks()));
            return;
        }
        report(str, str2, new String[0]);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchUtilFetcher
    public void saveSearchHistory(final AppInterface appInterface, final String str, final String str2, final String str3, final int i3, final String str4) {
        ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.search.api.impl.SearchUtilFetcherImpl.1
            @Override // java.lang.Runnable
            public void run() {
                QLog.d(SearchUtilFetcherImpl.TAG, 1, "saveSearchHistory, displayName:" + af.a(str, 2) + " ,type" + i3);
                SearchHistory searchHistory = new SearchHistory();
                searchHistory.type = i3;
                searchHistory.uin = str2;
                searchHistory.troopUin = str3;
                searchHistory.displayName = str;
                searchHistory.extralInfo = str4;
                ac acVar = (ac) appInterface.getManager(QQManagerFactory.SEARCHHISTORY_MANAGER);
                if (acVar == null) {
                    return;
                }
                acVar.p(searchHistory);
                UniteSearchActivity.f282685c0 = true;
            }
        }, null, false);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchUtilFetcher
    public void report(String str, String str2, int i3, int i16, String... strArr) {
        new com.tencent.mobileqq.statistics.q(null).i("dc00899").a("Grp_all_search").f(str).d(str2).c(i3).e(i16).b(strArr).g();
    }

    @Override // com.tencent.mobileqq.search.api.ISearchUtilFetcher
    public void report(String str, String str2, String str3, int i3, int i16, String... strArr) {
        new com.tencent.mobileqq.statistics.q(null).i("dc00899").a(str).f(str2).d(str3).c(i3).e(i16).b(strArr).g();
    }
}

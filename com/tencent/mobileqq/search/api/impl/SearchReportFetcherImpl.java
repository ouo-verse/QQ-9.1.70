package com.tencent.mobileqq.search.api.impl;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountSearchRecommendManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.pubaccount.weishi.api.IWSManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.ecshop.api.IEcshopUtilApi;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.search.ac;
import com.tencent.mobileqq.search.activity.ContactSearchActivity;
import com.tencent.mobileqq.search.activity.PublicAcntSearchActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.api.ISearchReportFetcher;
import com.tencent.mobileqq.search.model.PublicAccountInfoForSearch;
import com.tencent.mobileqq.search.model.v;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.cc;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.contentbox.IQzoneMsgApi;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import wn2.f;
import wn2.g;
import wn2.i;
import wn2.j;
import wn2.q;
import wn2.r;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SearchReportFetcherImpl implements ISearchReportFetcher {
    @Override // com.tencent.mobileqq.search.api.ISearchReportFetcher
    public PublicAccountInfoForSearch convertToPublicAccountEntity(Entity entity) {
        if (!(entity instanceof PublicAccountInfo)) {
            return null;
        }
        PublicAccountInfoForSearch publicAccountInfoForSearch = new PublicAccountInfoForSearch();
        PublicAccountInfo publicAccountInfo = (PublicAccountInfo) entity;
        publicAccountInfoForSearch.setUid(publicAccountInfo.uid);
        publicAccountInfoForSearch.setUid(publicAccountInfo.uid);
        publicAccountInfoForSearch.setName(publicAccountInfo.name);
        publicAccountInfoForSearch.setDisplayNumber(publicAccountInfo.displayNumber);
        publicAccountInfoForSearch.setSummary(publicAccountInfo.summary);
        publicAccountInfoForSearch.setRecvMsg(publicAccountInfo.isRecvMsg);
        publicAccountInfoForSearch.setRecvPush(publicAccountInfo.isRecvPush);
        publicAccountInfoForSearch.setClickCount(publicAccountInfo.clickCount);
        publicAccountInfoForSearch.setOffLine(publicAccountInfo.isOffLine);
        publicAccountInfoForSearch.setMarks(publicAccountInfo.Marks);
        publicAccountInfoForSearch.setOrderForMark(publicAccountInfo.orderForMark);
        publicAccountInfoForSearch.setCertifiedGrade(publicAccountInfo.certifiedGrade);
        publicAccountInfoForSearch.setSyncLbs(publicAccountInfo.isSyncLbs);
        publicAccountInfoForSearch.setShowFlag(publicAccountInfo.showFlag);
        publicAccountInfoForSearch.setMShowMsgFlag(publicAccountInfo.mShowMsgFlag);
        publicAccountInfoForSearch.setMIsAgreeSyncLbs(publicAccountInfo.mIsAgreeSyncLbs);
        publicAccountInfoForSearch.setMIsSyncLbsSelected(publicAccountInfo.mIsSyncLbsSelected);
        publicAccountInfoForSearch.setDateTime(publicAccountInfo.dateTime);
        publicAccountInfoForSearch.setAccountFlag(publicAccountInfo.accountFlag);
        publicAccountInfoForSearch.setAccountFlag2(publicAccountInfo.accountFlag2);
        publicAccountInfoForSearch.setEqqAccountFlag(publicAccountInfo.eqqAccountFlag);
        publicAccountInfoForSearch.setShieldMsg(publicAccountInfo.isShieldMsg);
        publicAccountInfoForSearch.setMessageSettingFlag(publicAccountInfo.messageSettingFlag);
        publicAccountInfoForSearch.setExtendType(publicAccountInfo.extendType);
        publicAccountInfoForSearch.setUinStr(publicAccountInfo.getUin());
        publicAccountInfoForSearch.setMComparePartInt(publicAccountInfo.mComparePartInt);
        publicAccountInfoForSearch.setMCompareSpell(publicAccountInfo.mCompareSpell);
        publicAccountInfoForSearch.setLogo(publicAccountInfo.logo);
        publicAccountInfoForSearch.setLastAIOReadTime(publicAccountInfo.lastAIOReadTime);
        return publicAccountInfoForSearch;
    }

    public String getReportType(y yVar) {
        if (!(yVar instanceof wn2.a) && !(yVar instanceof wn2.b)) {
            if (!(yVar instanceof f) && !(yVar instanceof g) && !(yVar instanceof q) && !(yVar instanceof r) && !(yVar instanceof i) && !(yVar instanceof j)) {
                return HardCodeUtil.qqStr(R.string.nde);
            }
            return HardCodeUtil.qqStr(R.string.ndd);
        }
        return HardCodeUtil.qqStr(R.string.ndc);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchReportFetcher
    public void onActionContactSearchModel(y yVar, View view, String str, int i3, String str2) {
        if (SearchUtils.F0(i3)) {
            Integer num = (Integer) view.getTag(R.id.kxc);
            Integer num2 = (Integer) view.getTag(R.id.kxa);
            if (QLog.isColorLevel()) {
                QLog.i("Q.uniteSearch..ContectReport", 2, " view.getTag(R.id.view_tag_position) = " + num);
            }
            if (view.getContext() instanceof UniteSearchActivity) {
                HashMap<v, SearchUtils.d> hashMap = SearchUtils.f284965n;
                if (hashMap.containsKey(this)) {
                    SearchUtils.d dVar = hashMap.get(this);
                    QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("project", com.tencent.mobileqq.search.report.b.c());
                        jSONObject.put("event_src", "client");
                        jSONObject.put("obj_lct", dVar.f284978c);
                        jSONObject.put("get_src", "native");
                    } catch (JSONException e16) {
                        QLog.e(str2, 2, "e = " + e16);
                    }
                    com.tencent.mobileqq.search.report.b.h(null, new ReportModelDC02528().module("all_result").action("clk_item").obj1(dVar.f284977b + "").obj2(dVar.f284980e).ver1(dVar.f284976a).ver2(com.tencent.mobileqq.search.report.b.a(i3)).ver7(jSONObject.toString()).session_id(qQAppInterface.getCurrentAccountUin() + SearchUtils.f284963l));
                }
            }
            if ((view.getContext() instanceof UniteSearchActivity) && !(yVar instanceof up2.b) && num2.intValue() >= 0 && num.intValue() >= 0) {
                SearchUtils.W0("all_result", "clk_contact", "" + str, "" + num2, "" + (num.intValue() + 1), "" + getReportType(yVar));
                return;
            }
            if ((view.getContext() instanceof ContactSearchActivity) && !(yVar instanceof up2.b)) {
                SearchUtils.W0("contact", "clk_result", "" + str, "" + num2, "" + (num.intValue() + 1), "" + getReportType(yVar));
                return;
            }
            if ((view.getContext() instanceof UniteSearchActivity) && (yVar instanceof up2.b)) {
                SearchUtils.W0("all_result", "clk_public_uin", "" + str, "" + num2, "" + (num.intValue() + 1), "" + getReportType(yVar));
                return;
            }
            if (!(view.getContext() instanceof UniteSearchActivity) && (yVar instanceof up2.b)) {
                SearchUtils.W0("all_result", "clk_public_uin_page", "" + str, "" + num2, "" + (num.intValue() + 1), "" + getReportType(yVar));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x021e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x023b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // com.tencent.mobileqq.search.api.ISearchReportFetcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onActionPublicAccountSearchResultModel(AppInterface appInterface, View view, Context context, PublicAccountInfoForSearch publicAccountInfoForSearch, int i3, String str, int i16) {
        int i17;
        String str2;
        String str3;
        String str4;
        String str5;
        boolean z16;
        boolean z17;
        String str6;
        boolean z18;
        boolean z19 = context instanceof UniteSearchActivity;
        boolean z26 = true;
        if (z19) {
            SearchUtils.W0("all_result", "clk_public_uin", "" + str);
            com.tencent.mobileqq.search.report.b.e(null, 0, i16, "0X8009D51", 0, 0, publicAccountInfoForSearch.getUinString(), null);
        }
        String uinString = publicAccountInfoForSearch.getUinString();
        String str7 = null;
        cc.a(null, "pubAcc_aio_open", uinString);
        IPublicAccountDataManager iPublicAccountDataManager = (IPublicAccountDataManager) appInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
        if (AppConstants.WEISHI_UIN.equals(uinString)) {
            ((IWSManager) QRoute.api(IWSManager.class)).enterWSPublicAccount(context, "from_search_result", true);
        } else if (AppConstants.TIM_TEAM_UIN.equals(uinString)) {
            ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).enterTimTeam(context, appInterface);
        } else if (!TextUtils.equals(AppConstants.VALUE.UIN_QZONE, uinString) || !((IQzoneMsgApi) QRoute.api(IQzoneMsgApi.class)).openContentBox(context)) {
            if ("2747277822".equals(uinString) && ((IQQGameConfigUtil) QRoute.api(IQQGameConfigUtil.class)).checkGamePubAccountConfig()) {
                ((IQQGameHelper) QRoute.api(IQQGameHelper.class)).startQQGamePubAccount(context, 3);
                ((QQAppInterface) appInterface).getConversationFacade().r("2747277822", 1008, false);
            } else if ("3593944551".equals(uinString) && ((IQQGameConfigUtil) QRoute.api(IQQGameConfigUtil.class)).isCustomGameMallPubAccount()) {
                ((IQQGameHelper) QRoute.api(IQQGameHelper.class)).startGameMallPubAccount(context, 3);
                ((QQAppInterface) appInterface).getConversationFacade().r("3593944551", 1008, false);
            } else if (((IMiniAppService) QRoute.api(IMiniAppService.class)).shouldOpenWebFragment(uinString)) {
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).launchMiniGamePublicAccount(context);
                ((QQAppInterface) appInterface).getConversationFacade().r(AppConstants.MINI_GAME_PUBLIC_ACCOUNT_UIN, 1008, false);
            } else {
                String str8 = qb2.a.f428781a;
                if (str8.equals(uinString)) {
                    qb2.b.e(context, uinString, 3);
                    ((QQAppInterface) appInterface).getConversationFacade().r(str8, 1008, false);
                } else if (TextUtils.equals(IPublicAccountUtil.UIN_FOR_SHOP, uinString)) {
                    ((IEcshopUtilApi) QRoute.api(IEcshopUtilApi.class)).jump(context);
                    ((QQAppInterface) appInterface).getConversationFacade().r(IPublicAccountUtil.UIN_FOR_SHOP, 1008, false);
                    Intent intent = new Intent(view.getContext(), (Class<?>) ChatActivity.class);
                    if (publicAccountInfoForSearch.getExtendType() == 2) {
                        intent.putExtra("chat_subType", 1);
                        i17 = 0;
                    } else {
                        i17 = 1008;
                    }
                    if (TextUtils.isEmpty(uinString)) {
                        if (QLog.isColorLevel()) {
                            QLog.w("Q.uniteSearch.PublicAccountSearchResultModel", 2, "uin is null");
                            return;
                        }
                        return;
                    }
                    intent.putExtra("uin", uinString);
                    intent.putExtra("uintype", i17);
                    intent.putExtra("uinname", publicAccountInfoForSearch.getName());
                    intent.putExtra(AppConstants.LeftViewText.SELFSET_LEFTVIEWTEXT, context.getString(R.string.button_back));
                    z26 = true;
                    RecentUtil.f185176a = true;
                    RecentUtil.k0(intent);
                    context.startActivity(intent);
                    publicAccountInfoForSearch.setClickCount(publicAccountInfoForSearch.getClickCount() + 1);
                    if (iPublicAccountDataManager != null) {
                        iPublicAccountDataManager.savePublicAccountInfo(publicAccountInfoForSearch);
                    }
                    str7 = null;
                } else {
                    z26 = true;
                    if (TextUtils.isEmpty(uinString)) {
                        if (QLog.isColorLevel()) {
                            QLog.w("Q.uniteSearch.PublicAccountSearchResultModel", 2, "uin is null");
                            return;
                        }
                        return;
                    }
                    ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, IPublicAccountDetailActivity.ROUTE_NAME);
                    activityURIRequest.extra().putString("uin", uinString);
                    activityURIRequest.extra().putInt("source", 4);
                    str7 = null;
                    QRoute.startUri(activityURIRequest, (o) null);
                    String str9 = str7;
                    SearchUtils.d1(str, 50, 0, view, uinString, publicAccountInfoForSearch.getIsOffLine(), i16);
                    ac.o((QQAppInterface) appInterface, str);
                    SearchUtils.Z0(str, 50, view, false);
                    if ((context instanceof BaseActivity) && i3 > 0) {
                        if (z19) {
                            str4 = "0X8005D1C";
                            str5 = "0X8006570";
                        } else if (context instanceof PublicAcntSearchActivity) {
                            str4 = "0X8005D1E";
                            str5 = "0X8006588";
                        } else {
                            str2 = str9;
                            str3 = str2;
                            if (str3 != null) {
                                return;
                            }
                            if (i16 == 12) {
                                z16 = false;
                                ReportController.n(appInterface, "CliOper", "", "", str2, str2, 0, 1, 0, i3 + "", "", uinString, str);
                                z17 = z26;
                            } else {
                                z16 = false;
                                z17 = z26;
                                ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(appInterface, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, uinString, str3, str3, 0, 0, i3 + "", "", str, "", false);
                            }
                            IPublicAccountSearchRecommendManager iPublicAccountSearchRecommendManager = (IPublicAccountSearchRecommendManager) QRoute.api(IPublicAccountSearchRecommendManager.class);
                            String name = publicAccountInfoForSearch.getName();
                            if (publicAccountInfoForSearch.getExtendType() != 2) {
                                str6 = uinString;
                                z18 = z17;
                            } else {
                                str6 = uinString;
                                z18 = z16;
                            }
                            iPublicAccountSearchRecommendManager.updatePublicAccountSearchHistoryItem(appInterface, str6, name, z18);
                            return;
                        }
                        str3 = str4;
                        str2 = str5;
                        if (str3 != null) {
                        }
                    } else {
                        return;
                    }
                }
            }
            str7 = null;
            z26 = true;
            String str92 = str7;
            SearchUtils.d1(str, 50, 0, view, uinString, publicAccountInfoForSearch.getIsOffLine(), i16);
            ac.o((QQAppInterface) appInterface, str);
            SearchUtils.Z0(str, 50, view, false);
            if (context instanceof BaseActivity) {
                return;
            } else {
                return;
            }
        }
        String str922 = str7;
        SearchUtils.d1(str, 50, 0, view, uinString, publicAccountInfoForSearch.getIsOffLine(), i16);
        ac.o((QQAppInterface) appInterface, str);
        SearchUtils.Z0(str, 50, view, false);
        if (context instanceof BaseActivity) {
        }
    }

    @Override // com.tencent.mobileqq.search.api.ISearchReportFetcher
    public void onReportClick898(AppInterface appInterface, int i3, int i16, String str, int i17, int i18, String str2, String str3) {
        com.tencent.mobileqq.search.report.b.e(null, 0, i16, str, 0, 0, null, null);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchReportFetcher
    public void onReportRuntimeDC02528(AppInterface appInterface, long j3, String str, String str2, JSONObject jSONObject) {
        com.tencent.mobileqq.search.report.b.h(null, new ReportModelDC02528().module("all_result").action("clk_item").obj1(j3 + "").obj2(str).ver1(str2).ver2(com.tencent.mobileqq.search.report.b.a(UniteSearchActivity.f282684b0)).ver7(jSONObject.toString()).session_id(appInterface.getCurrentAccountUin() + SearchUtils.f284963l));
    }
}

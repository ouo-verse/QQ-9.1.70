package com.tencent.mobileqq.mini.report;

import android.graphics.Rect;
import android.view.View;
import com.tencent.ditto.widget.DittoImageArea;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.RankRvSectionViewHolder;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b)\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010,\u001a\u0004\u0018\u00010\u00042\u0006\u0010-\u001a\u00020.J\u0010\u0010/\u001a\u0004\u0018\u00010\u00042\u0006\u0010-\u001a\u00020.J\u0018\u00100\u001a\u0004\u0018\u00010\u00042\u0006\u0010-\u001a\u00020.2\u0006\u00101\u001a\u000202J\u000e\u00103\u001a\u0002022\u0006\u00104\u001a\u000205Jn\u00106\u001a\u0002072\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00042\u0006\u0010:\u001a\u00020\u00042\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0004J\u0018\u0010A\u001a\u0002022\b\u0010B\u001a\u0004\u0018\u00010C2\u0006\u00109\u001a\u00020\u0004Jb\u0010D\u001a\u0002072\n\b\u0002\u0010E\u001a\u0004\u0018\u00010F2\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00042\u0006\u0010:\u001a\u00020\u00042\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/mini/report/MiniAppExpDesktop04239ReportHelper;", "", "()V", "HOST_SCENE_MINE_MODULE", "", "HOST_SCENE_MINE_SUB_MODULE", "HOST_SCENE_MINE_SUB_VIA", "HOST_SCENE_MINE_VIA", "HOST_SCENE_RANK_BEST_SELLER_MODULE", "HOST_SCENE_RANK_BEST_SELLER_VIA", "HOST_SCENE_RANK_NEW_LIST_MODULE", "HOST_SCENE_RANK_NEW_LIST_VIA", "HOST_SCENE_RANK_PLAY_LIST_MODULE", "HOST_SCENE_RANK_RECOMMEND_MODULE", "HOST_SCENE_RANK_RECOMMEND_VIA", "HOST_SCENE_RANK_VIA", "HOST_SCENE_RECENTLY_MODULE", "HOST_SCENE_RECENTLY_SUB_MODULE", "HOST_SCENE_RECENTLY_SUB_VIA", "HOST_SCENE_RECENTLY_VIA", "RESERVES_ACTION_ADD_MY_MINIAPP", "RESERVES_ACTION_DELETE_MY_MINIAPP", "RESERVE_ACTION_MY_APP", "RESERVE_ACTION_MY_APP_LEVELE_2_PV", "RESERVE_ACTION_MY_APP_MORE", "RESERVE_ACTION_MY_APP_TAB", "RESERVE_ACTION_XIALA_BANGDAN", "RESERVE_ACTION_XIALA_BANGDAN_MORE", "RESERVE_ACTION_XIALA_BANGDAN_TAB", "RESERVE_ACTION_XIALA_DJZW", "RESERVE_ACTION_XIALA_DJZW_LEVELE_2_PV", "RESERVE_ACTION_XIALA_DJZW_MORE", "RESERVE_ACTION_XIALA_JRTJ", "RESERVE_ACTION_XIALA_JRTJ_LEVELE_2_PV", "RESERVE_ACTION_XIALA_JRTJ_MORE", "RESERVE_ACTION_XIALA_KUAIJIE", "RESERVE_ACTION_XIALA_PV", "RESERVE_ACTION_XIALA_SOUSUOKUANG", "RESERVE_ACTION_XSTG", "RESERVE_ACTION_ZJSY", "RESERVE_ACTION_ZJSY_LEVELE_2_PV", "RESERVE_ACTION_ZJSY_MORE", "RESERVE_ACTION_ZJSY_TAB", "TAG", "getModuleMoreClickReserveAction", "moduleType", "", "getModuleSelectReserveAction", "getPageReserveAction", "isSubPage", "", "isViewVisibleInScreen", "itemView", "Landroid/view/View;", "report", "", "appId", "via", "subActionType", "reserveAction", "reserves3", "reserves4", "resourceId", "slotId", "alkaidPt", "reportItemExpose", "holder", "Lcom/tencent/mobileqq/mini/entry/expDesktop/part/adapter/RankRvSectionViewHolder;", "reportWithAppInfo", "miniAppInfo", "Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppExpDesktop04239ReportHelper {
    public static final String HOST_SCENE_MINE_MODULE = "20001002";
    public static final String HOST_SCENE_MINE_SUB_MODULE = "20003001";
    public static final String HOST_SCENE_MINE_SUB_VIA = "3422_2_level2";
    public static final String HOST_SCENE_MINE_VIA = "3422_2";
    public static final String HOST_SCENE_RANK_BEST_SELLER_MODULE = "20001004";
    public static final String HOST_SCENE_RANK_BEST_SELLER_VIA = "3422_4";
    public static final String HOST_SCENE_RANK_NEW_LIST_MODULE = "20001006";
    public static final String HOST_SCENE_RANK_NEW_LIST_VIA = "3422_5";
    public static final String HOST_SCENE_RANK_PLAY_LIST_MODULE = "20001005";
    public static final String HOST_SCENE_RANK_RECOMMEND_MODULE = "20001003";
    public static final String HOST_SCENE_RANK_RECOMMEND_VIA = "3422_3";
    public static final String HOST_SCENE_RANK_VIA = "3422_6";
    public static final String HOST_SCENE_RECENTLY_MODULE = "20001001";
    public static final String HOST_SCENE_RECENTLY_SUB_MODULE = "20002001";
    public static final String HOST_SCENE_RECENTLY_SUB_VIA = "3422_1_level2";
    public static final String HOST_SCENE_RECENTLY_VIA = "3422_1";
    public static final MiniAppExpDesktop04239ReportHelper INSTANCE = new MiniAppExpDesktop04239ReportHelper();
    public static final String RESERVES_ACTION_ADD_MY_MINIAPP = "add_my_miniapp";
    public static final String RESERVES_ACTION_DELETE_MY_MINIAPP = "delete_my_miniapp";
    public static final String RESERVE_ACTION_MY_APP = "minigame_xiala_my_app";
    public static final String RESERVE_ACTION_MY_APP_LEVELE_2_PV = "minigame_xiala_my_app_level2_pv";
    public static final String RESERVE_ACTION_MY_APP_MORE = "minigame_xiala_my_app_more";
    public static final String RESERVE_ACTION_MY_APP_TAB = "minigame_xiala_my_app_tab";
    public static final String RESERVE_ACTION_XIALA_BANGDAN = "minigame_xiala_bangdan";
    public static final String RESERVE_ACTION_XIALA_BANGDAN_MORE = "minigame_xiala_bangdan_more";
    public static final String RESERVE_ACTION_XIALA_BANGDAN_TAB = "minigame_xiala_bangdan_tab";
    public static final String RESERVE_ACTION_XIALA_DJZW = "minigame_xiala_djzw";
    public static final String RESERVE_ACTION_XIALA_DJZW_LEVELE_2_PV = "minigame_xiala_djzw_level2_pv";
    public static final String RESERVE_ACTION_XIALA_DJZW_MORE = "minigame_xiala_djzw_more";
    public static final String RESERVE_ACTION_XIALA_JRTJ = "minigame_xiala_jrtj";
    public static final String RESERVE_ACTION_XIALA_JRTJ_LEVELE_2_PV = "minigame_xiala_jrtj_level2_pv";
    public static final String RESERVE_ACTION_XIALA_JRTJ_MORE = "minigame_xiala_jrtj_more";
    public static final String RESERVE_ACTION_XIALA_KUAIJIE = "minigame_xiala_kuaijie";
    public static final String RESERVE_ACTION_XIALA_PV = "minigame_xiala_pv";
    public static final String RESERVE_ACTION_XIALA_SOUSUOKUANG = "minigame_xiala_sousuokuang";
    public static final String RESERVE_ACTION_XSTG = "minigame_xiala_xstg";
    public static final String RESERVE_ACTION_ZJSY = "minigame_xiala_zjsy";
    public static final String RESERVE_ACTION_ZJSY_LEVELE_2_PV = "minigame_xiala_zjsy_level2_pv";
    public static final String RESERVE_ACTION_ZJSY_MORE = "minigame_xiala_zjsy_more";
    public static final String RESERVE_ACTION_ZJSY_TAB = "minigame_xiala_zjsy_tab";
    private static final String TAG = "MiniAppExpDesktop04239ReportHelper";

    MiniAppExpDesktop04239ReportHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void report$lambda$0(String subActionType, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        Intrinsics.checkNotNullParameter(subActionType, "$subActionType");
        ArrayList arrayList = new ArrayList();
        if (!(str == null || str.length() == 0)) {
            arrayList.add(MiniProgramReportHelper.newEntry("appid", str));
        }
        arrayList.add(MiniProgramReportHelper.newEntry("refer", "3422"));
        if (!(str2 == null || str2.length() == 0)) {
            arrayList.add(MiniProgramReportHelper.newEntry("via", str2));
        }
        if (!(str4 == null || str4.length() == 0)) {
            arrayList.add(MiniProgramReportHelper.newEntry("reserves3", str4));
        }
        if (!(str5 == null || str5.length() == 0)) {
            arrayList.add(MiniProgramReportHelper.newEntry("reserves4", str5));
        }
        if (!(str6 == null || str6.length() == 0)) {
            arrayList.add(MiniProgramReportHelper.newEntry(DittoImageArea.RESOURCE_ID, str6));
        }
        if (!(str7 == null || str7.length() == 0)) {
            arrayList.add(MiniProgramReportHelper.newEntry(com.tencent.qqmini.sdk.report.MiniAppReportManager2.KEY_SLOT_ID, str7));
        }
        if (!(str8 == null || str8.length() == 0)) {
            arrayList.add(MiniProgramReportHelper.newEntry("alkaid_pt", str8));
        }
        MiniProgramLpReportDC04239.reportAsyncWithExtraEntries("page_view", subActionType, str3, arrayList);
    }

    public final boolean isViewVisibleInScreen(View itemView) {
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        try {
            if (!itemView.isShown() || !itemView.getGlobalVisibleRect(new Rect())) {
                return false;
            }
            Rect rect = new Rect();
            itemView.getWindowVisibleDisplayFrame(rect);
            int[] iArr = new int[2];
            itemView.getLocationOnScreen(iArr);
            int i3 = iArr[0];
            int i16 = iArr[1];
            int width = itemView.getWidth() + i3;
            int height = itemView.getHeight() + i16;
            if (width > rect.left && i3 < rect.right && height > rect.top) {
                if (i16 < rect.bottom - com.tencent.qqnt.base.utils.c.f353052a.b(80)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "isViewVisibleInScreen throw:", th5);
            return false;
        }
    }

    public final void report(final String appId, final String via, final String subActionType, final String reserveAction, final String reserves3, final String reserves4, final String resourceId, final String slotId, final String alkaidPt) {
        Intrinsics.checkNotNullParameter(subActionType, "subActionType");
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.report.a
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppExpDesktop04239ReportHelper.report$lambda$0(subActionType, appId, via, reserveAction, reserves3, reserves4, resourceId, slotId, alkaidPt);
            }
        });
    }

    public final void reportWithAppInfo(final MiniAppInfo miniAppInfo, final String via, final String subActionType, final String reserveAction, final String reserves3, final String reserves4, final String resourceId, final String slotId) {
        Intrinsics.checkNotNullParameter(subActionType, "subActionType");
        if (miniAppInfo == null) {
            QLog.e(TAG, 1, "miniAppInfo is null!");
        } else {
            MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.report.b
                @Override // java.lang.Runnable
                public final void run() {
                    MiniAppExpDesktop04239ReportHelper.reportWithAppInfo$lambda$1(subActionType, miniAppInfo, via, reserveAction, reserves3, reserves4, resourceId, slotId);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reportWithAppInfo$lambda$1(String subActionType, MiniAppInfo miniAppInfo, String str, String str2, String str3, String str4, String str5, String str6) {
        String str7;
        Intrinsics.checkNotNullParameter(subActionType, "$subActionType");
        ArrayList arrayList = new ArrayList();
        MiniAppConfig miniAppConfig = new MiniAppConfig(miniAppInfo);
        miniAppConfig.launchParam.scene = 3422;
        if (!miniAppInfo.isWxMiniApp()) {
            str7 = String.valueOf(miniAppConfig.launchParam.scene);
        } else {
            str7 = "";
        }
        arrayList.addAll(MiniProgramReportHelper.newBusinessEntries(miniAppConfig, "", str7, "page_view", subActionType, str2, "", str3, str4, "", "", "", "", MiniProgramLpReportDC04239.getAppType(miniAppConfig), "", str6));
        MiniProgramLpReportDC04239.reportAsyncWithExtraEntries("page_view", subActionType, str2, arrayList);
    }

    public final boolean reportItemExpose(RankRvSectionViewHolder holder, String via) {
        Intrinsics.checkNotNullParameter(via, "via");
        if (holder == null) {
            return false;
        }
        View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        if (!isViewVisibleInScreen(view)) {
            return false;
        }
        Object tag = holder.itemView.getTag();
        if (!(tag instanceof DesktopAppInfo)) {
            return false;
        }
        reportWithAppInfo$default(INSTANCE, ((DesktopAppInfo) tag).mMiniAppInfo, via, "expo", null, null, null, null, String.valueOf(holder.getAdapterPosition() + 1), 120, null);
        return true;
    }

    public final String getModuleSelectReserveAction(int moduleType) {
        if (moduleType == 1) {
            return RESERVE_ACTION_ZJSY_TAB;
        }
        if (moduleType != 3) {
            switch (moduleType) {
                case 18:
                case 19:
                case 20:
                case 21:
                    return RESERVE_ACTION_XIALA_BANGDAN_TAB;
                default:
                    return null;
            }
        }
        return RESERVE_ACTION_MY_APP_TAB;
    }

    public final String getPageReserveAction(int moduleType, boolean isSubPage) {
        if (moduleType == 1) {
            if (isSubPage) {
                return RESERVE_ACTION_ZJSY_LEVELE_2_PV;
            }
            return RESERVE_ACTION_ZJSY;
        }
        if (moduleType == 3) {
            if (isSubPage) {
                return RESERVE_ACTION_MY_APP_LEVELE_2_PV;
            }
            return RESERVE_ACTION_MY_APP;
        }
        if (moduleType == 23) {
            if (isSubPage) {
                return RESERVE_ACTION_XIALA_JRTJ_LEVELE_2_PV;
            }
            return RESERVE_ACTION_XIALA_JRTJ;
        }
        switch (moduleType) {
            case 17:
                if (isSubPage) {
                    return RESERVE_ACTION_XIALA_DJZW_LEVELE_2_PV;
                }
                return RESERVE_ACTION_XIALA_DJZW;
            case 18:
            case 19:
            case 20:
            case 21:
                return RESERVE_ACTION_XIALA_BANGDAN;
            default:
                return null;
        }
    }

    public final String getModuleMoreClickReserveAction(int moduleType) {
        if (moduleType == 1) {
            return RESERVE_ACTION_ZJSY_MORE;
        }
        if (moduleType == 3) {
            return RESERVE_ACTION_MY_APP_MORE;
        }
        if (moduleType == 17) {
            return RESERVE_ACTION_XIALA_DJZW_MORE;
        }
        if (moduleType != 23) {
            return null;
        }
        return RESERVE_ACTION_XIALA_JRTJ_MORE;
    }

    public static /* synthetic */ void reportWithAppInfo$default(MiniAppExpDesktop04239ReportHelper miniAppExpDesktop04239ReportHelper, MiniAppInfo miniAppInfo, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i3, Object obj) {
        miniAppExpDesktop04239ReportHelper.reportWithAppInfo((i3 & 1) != 0 ? null : miniAppInfo, (i3 & 2) != 0 ? null : str, str2, (i3 & 8) != 0 ? null : str3, (i3 & 16) != 0 ? null : str4, (i3 & 32) != 0 ? null : str5, (i3 & 64) != 0 ? null : str6, (i3 & 128) != 0 ? null : str7);
    }
}

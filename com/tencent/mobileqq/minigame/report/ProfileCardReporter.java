package com.tencent.mobileqq.minigame.report;

import NS_MINI_APP_MISC.MISC$StAppPlayingInfo;
import NS_MINI_INTERFACE.INTERFACE$StApiAppInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.friends.intimate.MiniGamePlayTogetherHandler;
import com.tencent.mobileqq.mini.api.MiniProgramReportConst;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.report.MiniProgramReportHelper;
import com.tencent.mobileqq.profilecard.bussiness.miniapp.ProfileMiniAppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J$\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0007J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/minigame/report/ProfileCardReporter;", "", "()V", "TAG", "", "sProfileExpo", "reportMiniGameProfile", "", "miniAppConfig", "Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;", "refer", "", "isClick", "", "subAction", "reportProfileCardExposed", "profileMiniAppInfo", "Lcom/tencent/mobileqq/profilecard/bussiness/miniapp/ProfileMiniAppInfo;", "isOwner", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class ProfileCardReporter {
    public static final ProfileCardReporter INSTANCE = new ProfileCardReporter();
    private static final String TAG = "ProfileCardReporter";
    private static String sProfileExpo;

    ProfileCardReporter() {
    }

    @JvmStatic
    public static final void reportMiniGameProfile(MiniAppConfig miniAppConfig, int refer, boolean isClick) {
        String str;
        if (isClick) {
            str = "em_click";
        } else {
            str = refer == 2064 ? "expo" : "em_expo";
        }
        reportMiniGameProfile(miniAppConfig, refer, str);
    }

    @JvmStatic
    public static final void reportProfileCardExposed(ProfileMiniAppInfo profileMiniAppInfo, boolean isOwner) {
        List<MISC$StAppPlayingInfo> list;
        String str;
        ArrayList<INTERFACE$StApiAppInfo> arrayList;
        Intrinsics.checkNotNullParameter(profileMiniAppInfo, "profileMiniAppInfo");
        int i3 = 0;
        try {
            if (isOwner) {
                if (!profileMiniAppInfo.isShowMiniPlaying || (arrayList = profileMiniAppInfo.miniAppInfoArrayList) == null || arrayList.size() <= 0) {
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                int size = profileMiniAppInfo.miniAppInfoArrayList.size();
                while (i3 < size) {
                    MiniAppConfig miniAppConfig = new MiniAppConfig(MiniAppInfo.from(profileMiniAppInfo.miniAppInfoArrayList.get(i3)));
                    miniAppConfig.launchParam.scene = 2062;
                    arrayList2.add(new MiniAppExposureManager.MiniAppExposureData(miniAppConfig, i3));
                    i3++;
                }
                MiniProgramLpReportDC04239.reportPageView(arrayList2, "expo");
                return;
            }
            if (!profileMiniAppInfo.isShowMiniPlaying || (list = profileMiniAppInfo.appPlayingInfos) == null || list.size() <= 0) {
                return;
            }
            if (profileMiniAppInfo.appPlayingInfos.size() > 1) {
                ArrayList arrayList3 = new ArrayList();
                int size2 = profileMiniAppInfo.appPlayingInfos.size();
                while (i3 < size2) {
                    MiniAppConfig miniAppConfig2 = new MiniAppConfig(MiniAppInfo.from(profileMiniAppInfo.appPlayingInfos.get(i3).appMetaInfo));
                    miniAppConfig2.launchParam.scene = 2062;
                    arrayList3.add(new MiniAppExposureManager.MiniAppExposureData(miniAppConfig2, i3));
                    i3++;
                }
                MiniProgramLpReportDC04239.reportPageView(arrayList3, "expo");
                return;
            }
            INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo = profileMiniAppInfo.appPlayingInfos.get(0).appMetaInfo;
            MiniAppConfig miniAppConfig3 = new MiniAppConfig(MiniAppInfo.from(iNTERFACE$StApiAppInfo));
            miniAppConfig3.launchParam.scene = 2062;
            if (MiniGamePlayTogetherHandler.a(iNTERFACE$StApiAppInfo)) {
                str = "id_card";
            } else {
                str = "page_view";
            }
            MiniProgramLpReportDC04239.reportAsync(miniAppConfig3, str, "expo", null, null);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "reportProfileCardExposed error", e16);
        }
    }

    @JvmStatic
    public static final void reportMiniGameProfile(final MiniAppConfig miniAppConfig, final int refer, final String subAction) {
        final String str = refer == 2064 ? "c2close" : MiniProgramReportConst.NEW_PROFILE_CARD_ACTION;
        final String str2 = "1";
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = -1;
        if ((miniAppConfig != null ? miniAppConfig.config : null) != null) {
            intRef.element = miniAppConfig.config.getReportType();
        }
        if (intRef.element == 0) {
            QLog.e(TAG, 1, "reportMiniGameProfile: reserves71");
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.minigame.report.k
            @Override // java.lang.Runnable
            public final void run() {
                ProfileCardReporter.reportMiniGameProfile$lambda$0(MiniAppConfig.this, refer, subAction, str, str2, intRef);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reportMiniGameProfile$lambda$0(MiniAppConfig miniAppConfig, int i3, String str, String reservesAction, String reserves7, Ref.IntRef appType) {
        Intrinsics.checkNotNullParameter(reservesAction, "$reservesAction");
        Intrinsics.checkNotNullParameter(reserves7, "$reserves7");
        Intrinsics.checkNotNullParameter(appType, "$appType");
        String valueOf = String.valueOf(i3);
        int i16 = appType.element;
        MiniProgramLpReportDC04239.reportAsync(MiniProgramReportHelper.newBusinessEntries(miniAppConfig, null, valueOf, "page_view", str, reservesAction, null, null, null, null, null, reserves7, null, i16 == -1 ? null : String.valueOf(i16), null));
    }
}

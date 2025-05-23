package com.tencent.mobileqq.troop.memberlevel.api.impl;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.troop.TroopExtDBInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.troop.api.ITroopMemberLevelService;
import com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi;
import com.tencent.mobileqq.troop.memberlevel.api.ITroopMemberLevelUtilsApi;
import com.tencent.mobileqq.troop.memberlevel.api.b;
import com.tencent.mobileqq.troop.troopmemberlevel.a;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.ar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelpublic.nativeinterface.MemberRole;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopMemberLevelUtilsApiImpl implements ITroopMemberLevelUtilsApi {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "TroopMemberLevelUtilsApiImpl";

    public TroopMemberLevelUtilsApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private int convertRealLevelToMapLevel(int i3, b bVar) {
        if (bVar != null) {
            return bVar.b(i3);
        }
        return 0;
    }

    private void getDefaultRankItem(a aVar, TroopInfo troopInfo, boolean z16, boolean z17, boolean z18, int i3, String str, b bVar) {
        if (aVar != null && troopInfo != null) {
            if (!TextUtils.isEmpty(str)) {
                aVar.f300592c = str;
                aVar.f300593d = getRankGradientColorByRankId(302, bVar);
                aVar.f300597h = getRankTextColorByRankId(302, bVar);
                return;
            }
            if (z16) {
                aVar.f300592c = HardCodeUtil.qqStr(R.string.upl);
                aVar.f300593d = getRankGradientColorByRankId(300, bVar);
                aVar.f300597h = getRankTextColorByRankId(300, bVar);
            } else {
                if (z17) {
                    aVar.f300592c = HardCodeUtil.qqStr(R.string.upa);
                    aVar.f300593d = getRankGradientColorByRankId(301, bVar);
                    aVar.f300597h = getRankTextColorByRankId(301, bVar);
                    return;
                }
                ConcurrentHashMap<Integer, String> newTroopLevelMap = troopInfo.getNewTroopLevelMap();
                if (newTroopLevelMap != null && newTroopLevelMap.size() > 0) {
                    aVar.f300592c = newTroopLevelMap.get(Integer.valueOf(i3));
                }
                if (TextUtils.isEmpty(aVar.f300592c)) {
                    aVar.f300592c = getRankTitleByLevelInConfig(i3, bVar);
                }
                aVar.f300593d = getRankGradientColorByRankId(315, bVar);
                aVar.f300597h = getRankTextColorByRankId(315, bVar);
            }
        }
    }

    private void getHomeWorkTroopShowRank(a aVar, int i3, b bVar) {
        if (i3 == 332) {
            aVar.f300590a = 332;
            aVar.f300592c = HardCodeUtil.qqStr(R.string.uph);
            aVar.f300593d = getRankGradientColorByRankId(332, bVar);
            aVar.f300597h = getRankTextColorByRankId(332, bVar);
            aVar.f300596g = true;
            aVar.f300594e = null;
            aVar.f300595f = false;
            return;
        }
        if (i3 == 333) {
            aVar.f300590a = 333;
            aVar.f300592c = HardCodeUtil.qqStr(R.string.upm);
            aVar.f300593d = getRankGradientColorByRankId(333, bVar);
            aVar.f300597h = getRankTextColorByRankId(333, bVar);
            aVar.f300596g = true;
            aVar.f300594e = null;
            aVar.f300595f = false;
            return;
        }
        if (i3 == 336) {
            aVar.f300590a = 336;
            aVar.f300592c = HardCodeUtil.qqStr(R.string.f214615td);
            aVar.f300593d = getRankGradientColorByRankId(336, bVar);
            aVar.f300597h = getRankTextColorByRankId(336, bVar);
            aVar.f300596g = true;
            aVar.f300594e = null;
            aVar.f300595f = false;
            return;
        }
        aVar.f300596g = false;
        aVar.f300595f = false;
    }

    private int[] getOnlyLevelColor(b bVar) {
        if (bVar != null) {
            return bVar.e();
        }
        return null;
    }

    private void getOnlyShowOwnerAndAdminRank(a aVar, boolean z16, boolean z17, b bVar) {
        if (z17) {
            aVar.f300590a = 300;
            aVar.f300592c = HardCodeUtil.qqStr(R.string.upl);
            aVar.f300593d = getRankGradientColorByRankId(300, bVar);
            aVar.f300597h = getRankTextColorByRankId(300, bVar);
            aVar.f300596g = true;
            aVar.f300594e = null;
            aVar.f300595f = false;
            return;
        }
        if (z16) {
            aVar.f300590a = 301;
            aVar.f300592c = HardCodeUtil.qqStr(R.string.upa);
            aVar.f300593d = getRankGradientColorByRankId(301, bVar);
            aVar.f300597h = getRankTextColorByRankId(301, bVar);
            aVar.f300596g = true;
            aVar.f300594e = null;
            aVar.f300595f = false;
            return;
        }
        aVar.f300596g = false;
        aVar.f300595f = false;
    }

    private void getSelfSelectRankItem(a aVar, TroopInfo troopInfo, boolean z16, boolean z17, boolean z18, int i3, int i16, String str, b bVar) {
        if (troopInfo != null && aVar != null) {
            if (i16 == 302) {
                aVar.f300592c = str;
                aVar.f300593d = getRankGradientColorByRankId(302, bVar);
                aVar.f300597h = getRankTextColorByRankId(302, bVar);
                return;
            }
            if (i16 == 300) {
                aVar.f300592c = HardCodeUtil.qqStr(R.string.upl);
                aVar.f300593d = getRankGradientColorByRankId(300, bVar);
                aVar.f300597h = getRankTextColorByRankId(300, bVar);
            } else {
                if (i16 == 301) {
                    aVar.f300592c = HardCodeUtil.qqStr(R.string.upa);
                    aVar.f300593d = getRankGradientColorByRankId(301, bVar);
                    aVar.f300597h = getRankTextColorByRankId(301, bVar);
                    return;
                }
                ConcurrentHashMap<Integer, String> newTroopLevelMap = troopInfo.getNewTroopLevelMap();
                if (newTroopLevelMap != null && newTroopLevelMap.size() > 0) {
                    aVar.f300592c = newTroopLevelMap.get(Integer.valueOf(i3));
                }
                if (TextUtils.isEmpty(aVar.f300592c)) {
                    aVar.f300592c = getRankTitleByLevelInConfig(i3, bVar);
                }
                aVar.f300593d = getRankGradientColorByRankId(315, bVar);
                aVar.f300597h = getRankTextColorByRankId(315, bVar);
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.memberlevel.api.ITroopMemberLevelUtilsApi
    public int convertOldLevelToNewLevel(int i3) {
        b config;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this, i3)).intValue();
        }
        ITroopMemberLevelService iTroopMemberLevelService = (ITroopMemberLevelService) bg.m(ITroopMemberLevelService.class, "");
        if (iTroopMemberLevelService == null) {
            config = null;
        } else {
            config = iTroopMemberLevelService.getConfig();
        }
        if (config != null) {
            return config.d(i3);
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.troop.memberlevel.api.ITroopMemberLevelUtilsApi
    public String getNewGroupMemberLevelJumpUrl() {
        b config;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        ITroopMemberLevelService iTroopMemberLevelService = (ITroopMemberLevelService) bg.m(ITroopMemberLevelService.class, "");
        if (iTroopMemberLevelService == null) {
            config = null;
        } else {
            config = iTroopMemberLevelService.getConfig();
        }
        if (config == null) {
            return "";
        }
        return config.c();
    }

    @Override // com.tencent.mobileqq.troop.memberlevel.api.ITroopMemberLevelUtilsApi
    public JSONObject getRankBgColorConfigJson(int i3) {
        b config;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (JSONObject) iPatchRedirector.redirect((short) 9, (Object) this, i3);
        }
        ITroopMemberLevelService iTroopMemberLevelService = (ITroopMemberLevelService) bg.m(ITroopMemberLevelService.class, "");
        if (iTroopMemberLevelService == null) {
            config = null;
        } else {
            config = iTroopMemberLevelService.getConfig();
        }
        if (config == null) {
            return null;
        }
        return config.f(i3);
    }

    @Override // com.tencent.mobileqq.troop.memberlevel.api.ITroopMemberLevelUtilsApi
    public int[] getRankGradientColorByRankId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (int[]) iPatchRedirector.redirect((short) 7, (Object) this, i3);
        }
        ITroopMemberLevelService iTroopMemberLevelService = (ITroopMemberLevelService) bg.m(ITroopMemberLevelService.class, "");
        b config = iTroopMemberLevelService == null ? null : iTroopMemberLevelService.getConfig();
        if (config != null) {
            return config.a(i3);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.troop.memberlevel.api.ITroopMemberLevelUtilsApi
    public int getRankTextColor(int i3) {
        b config;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, i3)).intValue();
        }
        ITroopMemberLevelService iTroopMemberLevelService = (ITroopMemberLevelService) bg.m(ITroopMemberLevelService.class, "");
        if (iTroopMemberLevelService == null) {
            config = null;
        } else {
            config = iTroopMemberLevelService.getConfig();
        }
        return getRankTextColorByRankId(i3, config);
    }

    @Override // com.tencent.mobileqq.troop.memberlevel.api.ITroopMemberLevelUtilsApi
    public int getRankTextColorByRankId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, i3)).intValue();
        }
        ITroopMemberLevelService iTroopMemberLevelService = (ITroopMemberLevelService) bg.m(ITroopMemberLevelService.class, "");
        b config = iTroopMemberLevelService == null ? null : iTroopMemberLevelService.getConfig();
        if (config != null) {
            return config.h(i3);
        }
        return -1;
    }

    public String getRankTitleByLevelInConfig(int i3, b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, i3, (Object) bVar);
        }
        if (bVar != null) {
            return bVar.g(i3);
        }
        return "";
    }

    @Override // com.tencent.mobileqq.troop.memberlevel.api.ITroopMemberLevelUtilsApi
    public a getTroopMemberRankItem(TroopInfo troopInfo, String str, int i3, int i16, String str2, byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) ? getTroopMemberRankItem(troopInfo, str, i3, i16, str2, b16, false, troopInfo.isTroopOwner(str), troopInfo.isTroopAdmin(str)) : (a) iPatchRedirector.redirect((short) 13, this, troopInfo, str, Integer.valueOf(i3), Integer.valueOf(i16), str2, Byte.valueOf(b16));
    }

    @Override // com.tencent.mobileqq.troop.memberlevel.api.ITroopMemberLevelUtilsApi
    public a getTroopMemberRankItem_Unique(TroopInfo troopInfo, TroopMemberInfo troopMemberInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (a) iPatchRedirector.redirect((short) 12, (Object) this, (Object) troopInfo, (Object) troopMemberInfo);
        }
        String str = troopMemberInfo.memberuin;
        if (troopInfo != null && !TextUtils.isEmpty(str)) {
            a troopMemberRankItem = getTroopMemberRankItem(troopInfo, troopMemberInfo);
            String specialTitleStr = troopMemberInfo.getSpecialTitleStr();
            if (!TextUtils.isEmpty(specialTitleStr)) {
                troopMemberRankItem.f300590a = 302;
                troopMemberRankItem.f300596g = true;
                troopMemberRankItem.f300592c = specialTitleStr;
                MemberRole memberRole = troopMemberInfo.role;
                if (memberRole == MemberRole.OWNER) {
                    troopMemberRankItem.f300590a = 300;
                } else if (memberRole == MemberRole.ADMIN) {
                    troopMemberRankItem.f300590a = 301;
                }
                troopMemberRankItem.f300593d = ((ITroopMemberLevelUtilsApi) QRoute.api(ITroopMemberLevelUtilsApi.class)).getRankGradientColorByRankId(troopMemberRankItem.f300590a);
                troopMemberRankItem.f300597h = ((ITroopMemberLevelUtilsApi) QRoute.api(ITroopMemberLevelUtilsApi.class)).getRankTextColor(troopMemberRankItem.f300590a);
                ((ITroopMemberListActivityApi) QRoute.api(ITroopMemberListActivityApi.class)).handleRichLevel(troopMemberRankItem.f300590a, troopMemberInfo.mHonorRichFlag, troopMemberRankItem);
            }
            return troopMemberRankItem;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.troop.memberlevel.api.ITroopMemberLevelUtilsApi
    public boolean hasNewGroupMemberLevelJumpUrl() {
        b config;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        ITroopMemberLevelService iTroopMemberLevelService = (ITroopMemberLevelService) bg.m(ITroopMemberLevelService.class, "");
        if (iTroopMemberLevelService == null) {
            config = null;
        } else {
            config = iTroopMemberLevelService.getConfig();
        }
        if (config != null && config.i()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "hasNewGroupMemberLevelJumpUrl= true");
                return true;
            }
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "hasNewGroupMemberLevelJumpUrl= false");
            return false;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.troop.memberlevel.api.ITroopMemberLevelUtilsApi
    public boolean isNewRealLevelGrayTroop(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.troop.memberlevel.api.ITroopMemberLevelUtilsApi
    public void jumpToVasTroopHonorUrl(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, (Object) str);
            return;
        }
        String str2 = ar.b("linkliang", "2025-04-09", "vas_troop_identity_icon").getStringData("mqqapi://kuikly/open?version=1&src_type=web&bundle_name=vas_group_title&qqmc_config=vas_kuikly_config&page_name=vas_group_title&enteranceId=group_title") + "&gc=" + str;
        if (str2.startsWith("http")) {
            ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openBrowser(context, str2);
        } else {
            ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openKuiklySchema(context, str2, null);
        }
    }

    private a getTroopMemberRankItem(TroopInfo troopInfo, String str, int i3, int i16, String str2, byte b16, boolean z16, boolean z17, boolean z18) {
        ITroopMemberListActivityApi iTroopMemberListActivityApi;
        b bVar;
        boolean z19;
        boolean z26;
        byte b17;
        ITroopMemberListActivityApi iTroopMemberListActivityApi2;
        int i17;
        int i18 = i16;
        b bVar2 = null;
        if (troopInfo != null && !TextUtils.isEmpty(str)) {
            a aVar = new a();
            int i19 = i3 == 0 ? 1 : i3;
            TroopExtDBInfo troopExtDBInfo = troopInfo.extDBInfo;
            boolean z27 = troopExtDBInfo.cNewGroupRankUserFlag == 0;
            boolean z28 = troopExtDBInfo.cGroupRankUserFlag == 1;
            aVar.f300596g = z28;
            aVar.f300595f = z27;
            if (z16) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime != null) {
                    bVar2 = ((ITroopMemberLevelService) peekAppRuntime.getRuntimeService(ITroopMemberLevelService.class, "")).getConfig();
                }
            } else {
                ITroopMemberLevelService iTroopMemberLevelService = (ITroopMemberLevelService) bg.m(ITroopMemberLevelService.class, "");
                if (iTroopMemberLevelService != null) {
                    bVar2 = iTroopMemberLevelService.getConfig();
                }
            }
            b bVar3 = bVar2;
            if (troopInfo.isHomeworkTroop()) {
                getHomeWorkTroopShowRank(aVar, i18, bVar3);
                return aVar;
            }
            if (!z27 && !z28 && !z17 && !z18) {
                return aVar;
            }
            ITroopMemberListActivityApi iTroopMemberListActivityApi3 = (ITroopMemberListActivityApi) QRoute.api(ITroopMemberListActivityApi.class);
            if (troopInfo.isQidianPrivateTroop()) {
                getOnlyShowOwnerAndAdminRank(aVar, z18, z17, bVar3);
                iTroopMemberListActivityApi3.handleRichLevel(aVar.f300590a, b16, aVar);
                return aVar;
            }
            if (SimpleUIUtil.getSimpleUISwitch()) {
                getOnlyShowOwnerAndAdminRank(aVar, z18, z17, bVar3);
                iTroopMemberListActivityApi3.handleRichLevel(aVar.f300590a, b16, aVar);
                return aVar;
            }
            aVar.f300590a = i18;
            aVar.f300596g = z28;
            aVar.f300593d = getRankGradientColorByRankId(i18, bVar3);
            aVar.f300597h = getRankTextColorByRankId(i18, bVar3);
            aVar.f300595f = z27;
            aVar.f300594e = getOnlyLevelColor(bVar3);
            aVar.f300591b = i19;
            int convertRealLevelToMapLevel = convertRealLevelToMapLevel(i19, bVar3);
            if (i18 < 10000 && i18 > 0) {
                iTroopMemberListActivityApi = iTroopMemberListActivityApi3;
                bVar = bVar3;
                z19 = z28;
                z26 = true;
                getSelfSelectRankItem(aVar, troopInfo, z17, z18, z28, convertRealLevelToMapLevel, i16, str2, bVar);
            } else {
                iTroopMemberListActivityApi = iTroopMemberListActivityApi3;
                bVar = bVar3;
                z19 = z28;
                z26 = true;
                getDefaultRankItem(aVar, troopInfo, z17, z18, z19, convertRealLevelToMapLevel, str2, bVar);
            }
            if (z17) {
                if (!z19) {
                    aVar.f300596g = z26;
                    aVar.f300592c = HardCodeUtil.qqStr(R.string.upl);
                }
                i17 = 300;
                b bVar4 = bVar;
                aVar.f300593d = getRankGradientColorByRankId(300, bVar4);
                aVar.f300597h = getRankTextColorByRankId(300, bVar4);
            } else {
                b bVar5 = bVar;
                if (z18) {
                    if (!z19) {
                        aVar.f300596g = z26;
                        aVar.f300592c = HardCodeUtil.qqStr(R.string.upa);
                    }
                    i17 = 301;
                    aVar.f300593d = getRankGradientColorByRankId(301, bVar5);
                    aVar.f300597h = getRankTextColorByRankId(301, bVar5);
                } else {
                    if (i18 > 10000 && !TextUtils.isEmpty(str2)) {
                        i18 = 302;
                    }
                    b17 = b16;
                    iTroopMemberListActivityApi2 = iTroopMemberListActivityApi;
                    iTroopMemberListActivityApi2.handleRichLevel(i18, b17, aVar);
                    return aVar;
                }
            }
            i18 = i17;
            iTroopMemberListActivityApi2 = iTroopMemberListActivityApi;
            b17 = b16;
            iTroopMemberListActivityApi2.handleRichLevel(i18, b17, aVar);
            return aVar;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getTroopMemberRankItem troopInfo=" + troopInfo + ", memberUin=" + str);
        }
        return null;
    }

    private int[] getRankGradientColorByRankId(int i3, b bVar) {
        if (bVar != null) {
            return bVar.a(i3);
        }
        return null;
    }

    private int getRankTextColorByRankId(int i3, b bVar) {
        if (bVar != null) {
            return bVar.h(i3);
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.troop.memberlevel.api.ITroopMemberLevelUtilsApi
    public a getTroopMemberRankItem(TroopInfo troopInfo, TroopMemberInfo troopMemberInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (a) iPatchRedirector.redirect((short) 14, (Object) this, (Object) troopInfo, (Object) troopMemberInfo);
        }
        if (troopInfo != null && troopMemberInfo != null) {
            int i3 = troopMemberInfo.realLevel;
            MemberRole memberRole = troopMemberInfo.role;
            return getTroopMemberRankItem(troopInfo, troopMemberInfo.memberuin, i3, troopMemberInfo.titleId, troopMemberInfo.getSpecialTitleStr(), troopMemberInfo.mHonorRichFlag, true, memberRole == MemberRole.OWNER, memberRole == MemberRole.ADMIN);
        }
        if (!QLog.isColorLevel()) {
            return null;
        }
        QLog.d(TAG, 2, "getTroopMemberRankItemFromAIO troopInfo=" + troopInfo + ", troopMemberInfo=" + troopMemberInfo);
        return null;
    }
}

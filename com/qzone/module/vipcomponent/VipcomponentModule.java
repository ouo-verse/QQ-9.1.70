package com.qzone.module.vipcomponent;

import NS_COMM_VIP_GROWTH.IconInfo;
import NS_MOBILE_COMM.combine_diamond_info;
import NS_MOBILE_COMM.star_info;
import SWEET_NEW_PRIVILEGE.sweet_style_info_item;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import com.qzone.module.Module;
import com.qzone.module.vipcomponent.service.VipInfoManager;
import com.qzone.module.vipcomponent.service.VipManager;
import com.qzone.module.vipcomponent.ui.DiamondYellowOpenActivity;
import com.qzone.module.vipcomponent.ui.QzoneStarVipIconShow;
import com.qzone.module.vipcomponent.ui.VipBusinessManager;
import com.qzone.proxy.vipcomponent.IVipComponentService;
import com.qzone.proxy.vipcomponent.IVipComponentUI;
import com.qzone.proxy.vipcomponent.adapter.IVipManager;
import com.qzone.proxy.vipcomponent.adapter.VipEnv;
import com.qzone.proxy.vipcomponent.model.QzoneVipInfo;
import cooperation.vip.vipcomponent.ui.QzoneHuangzuanVipIconShow;
import cooperation.vip.vipcomponent.util.VipResourcesListener;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class VipcomponentModule extends Module<IVipComponentUI, IVipComponentService> {
    private IVipComponentUI iVipComponentUI = new IVipComponentUI() { // from class: com.qzone.module.vipcomponent.VipcomponentModule.1
        @Override // com.qzone.proxy.vipcomponent.IVipComponentUI
        public Drawable getStarVipIcon(int i3, int i16, boolean z16, boolean z17, int i17, VipResourcesListener vipResourcesListener) {
            return getStarVipIcon(i3, i16, z16, z17, i17, 100, vipResourcesListener);
        }

        @Override // com.qzone.proxy.vipcomponent.IVipComponentUI
        public Class<?> getYellowOpenVipActivityClass() {
            return DiamondYellowOpenActivity.class;
        }

        @Override // com.qzone.proxy.vipcomponent.IVipComponentUI
        public Drawable getYellowVipIcon(int i3, int i16, boolean z16, boolean z17, String str, int i17, VipResourcesListener vipResourcesListener) {
            return getYellowVipIcon(i3, i16, z16, z17, str, i17, 100, null, vipResourcesListener);
        }

        @Override // com.qzone.proxy.vipcomponent.IVipComponentUI
        public void goOpenStarVip(Context context, Intent intent) {
            if (VipEnv.getQUA().contains("_GM_")) {
                return;
            }
            String openStarVipUrl = VipEnv.getOpenStarVipUrl();
            String stringExtra = intent.getStringExtra("key_aid_star_vip");
            if (stringExtra == null) {
                stringExtra = "aid";
            }
            VipEnv.toTransparentWeb(context, openStarVipUrl.replace("{aid}", stringExtra).replace("{qua}", VipEnv.getQUA()).replace("{openUin}", VipEnv.getLoginUin() + "").replace("{openVipType}", "3").replace("{openMonth}", "0"), -1, false);
        }

        @Override // com.qzone.proxy.vipcomponent.IVipComponentUI
        public Drawable getStarVipIcon(int i3, int i16, boolean z16, boolean z17, int i17, int i18, VipResourcesListener vipResourcesListener) {
            return QzoneStarVipIconShow.getInstance().getVipIcon(i3, i16, z16, z17, i17, i18, vipResourcesListener);
        }

        @Override // com.qzone.proxy.vipcomponent.IVipComponentUI
        public Drawable getYellowVipIcon(int i3, int i16, boolean z16, boolean z17, String str, int i17, int i18, String str2, VipResourcesListener vipResourcesListener) {
            return QzoneHuangzuanVipIconShow.getInstance().getLayers(i3, i16, z16, z17, str, i17, i18, str2, vipResourcesListener, 0);
        }

        @Override // com.qzone.proxy.vipcomponent.IVipComponentUI
        public Drawable getYellowVipIcon(int i3, int i16, boolean z16, boolean z17, String str, int i17, int i18, String str2, VipResourcesListener vipResourcesListener, int i19) {
            return QzoneHuangzuanVipIconShow.getInstance().getLayers(i3, i16, z16, z17, str, i17, i18, str2, vipResourcesListener, i19);
        }

        @Override // com.qzone.proxy.vipcomponent.IVipComponentUI
        public void goOpenYellowVip(Context context, Intent intent, int i3) {
            if (intent == null) {
                intent = new Intent(context, getYellowOpenVipActivityClass());
            } else {
                intent.setClass(context, getYellowOpenVipActivityClass());
            }
            if (i3 >= 0 && (context instanceof Activity)) {
                ((Activity) context).startActivityForResult(intent, i3);
            } else {
                context.startActivity(intent);
            }
        }

        @Override // com.qzone.proxy.vipcomponent.IVipComponentUI
        public Drawable getComVipIcon(int i3, int i16, boolean z16, boolean z17, boolean z18, String str, int i17, String str2, VipResourcesListener vipResourcesListener) {
            switch (i16) {
                case 1:
                    return getYellowVipIcon(i3, 1, z16, z18, str, i17, 100, str2, vipResourcesListener);
                case 2:
                    return getYellowVipIcon(i3, 0, z16, z18, str, i17, 100, str2, vipResourcesListener);
                case 3:
                    return getStarVipIcon(i3, 2, z16, false, i17, vipResourcesListener);
                case 4:
                    return getStarVipIcon(i3, 1, z16, false, i17, vipResourcesListener);
                case 5:
                    return getYellowVipIcon(i3, 2, z16, z18, str, i17, 100, str2, vipResourcesListener);
                case 6:
                    return getStarVipIcon(i3, 2, z16, true, i17, vipResourcesListener);
                default:
                    return null;
            }
        }
    };
    private IVipComponentService iVipComponentService = new IVipComponentService() { // from class: com.qzone.module.vipcomponent.VipcomponentModule.2
        @Override // com.qzone.proxy.vipcomponent.IVipComponentService
        public long getABTestTimeStamp() {
            return VipInfoManager.getInstance().getABTestTimeStamp();
        }

        @Override // com.qzone.proxy.vipcomponent.IVipComponentService
        public int getABTestType() {
            return VipInfoManager.getInstance().getABTestType();
        }

        @Override // com.qzone.proxy.vipcomponent.IVipComponentService
        public int getComDiamondLevel() {
            return getCurrentVipInfo().getComDiamondLevel();
        }

        @Override // com.qzone.proxy.vipcomponent.IVipComponentService
        public int getComDiamondType() {
            return getCurrentVipInfo().getComDiamondType();
        }

        @Override // com.qzone.proxy.vipcomponent.IVipComponentService
        public QzoneVipInfo getCurrentVipInfo() {
            return getVipInfo(VipEnv.getLoginUin() + "");
        }

        @Override // com.qzone.proxy.vipcomponent.IVipComponentService
        public String getLoveVipIconJumpUrl(String str) {
            return VipInfoManager.getInstance().getLoveVipIconJumpUrl(str);
        }

        @Override // com.qzone.proxy.vipcomponent.IVipComponentService
        public int getLoveVipIconLevel(String str) {
            return VipInfoManager.getInstance().getLoveVipIconLevel(str);
        }

        @Override // com.qzone.proxy.vipcomponent.IVipComponentService
        public String getLoveVipIconPicUrl(String str) {
            return VipInfoManager.getInstance().getLoveVipIconPicUrl(str);
        }

        @Override // com.qzone.proxy.vipcomponent.IVipComponentService
        public sweet_style_info_item getLoveVipInfo(String str) {
            return VipInfoManager.getInstance().getLoveVipInfo(str);
        }

        @Override // com.qzone.proxy.vipcomponent.IVipComponentService
        public int getStarVipLevel() {
            return getCurrentVipInfo().getStarLevel();
        }

        @Override // com.qzone.proxy.vipcomponent.IVipComponentService
        public QzoneVipInfo getVipInfo(String str) {
            return VipInfoManager.getInstance().getVipInfo(str);
        }

        @Override // com.qzone.proxy.vipcomponent.IVipComponentService
        public int getVipLevel() {
            return getCurrentVipInfo().getVipLevel();
        }

        @Override // com.qzone.proxy.vipcomponent.IVipComponentService
        public int getVipType() {
            return getCurrentVipInfo().getVipType();
        }

        @Override // com.qzone.proxy.vipcomponent.IVipComponentService
        public boolean getYellowDiamondHaveBeenToPayPage() {
            return VipBusinessManager.haveBeentoPayPage();
        }

        @Override // com.qzone.proxy.vipcomponent.IVipComponentService
        public boolean getYellowDiamondHavePaid() {
            return VipBusinessManager.havePaid();
        }

        @Override // com.qzone.proxy.vipcomponent.IVipComponentService
        public int getstarVipStatus() {
            return getCurrentVipInfo().getStarStatus();
        }

        @Override // com.qzone.proxy.vipcomponent.IVipComponentService
        public boolean isAnnualVip() {
            return getCurrentVipInfo().isAnnualVip();
        }

        @Override // com.qzone.proxy.vipcomponent.IVipComponentService
        public boolean isAnnualVipEver() {
            return getCurrentVipInfo().isAnnualVipEver();
        }

        @Override // com.qzone.proxy.vipcomponent.IVipComponentService
        public boolean isComDiamondAnnualVip() {
            return getCurrentVipInfo().isComDiamondAnnualVip();
        }

        @Override // com.qzone.proxy.vipcomponent.IVipComponentService
        public boolean isQzoneVip() {
            return VipInfoManager.getInstance().getVipInfo(String.valueOf(VipEnv.getLoginUin())).getVipType() >= 1;
        }

        @Override // com.qzone.proxy.vipcomponent.IVipComponentService
        public boolean isShowEventLoveVipIcon(String str) {
            return VipInfoManager.getInstance().isShowEventLoveVipIcon(str);
        }

        @Override // com.qzone.proxy.vipcomponent.IVipComponentService
        public boolean isStarAnnualVip() {
            return getCurrentVipInfo().isStarAnnualVip();
        }

        @Override // com.qzone.proxy.vipcomponent.IVipComponentService
        public boolean isSuperQzoneVip() {
            return VipInfoManager.getInstance().getVipInfo(String.valueOf(VipEnv.getLoginUin())).getVipType() >= 2;
        }

        @Override // com.qzone.proxy.vipcomponent.IVipComponentService
        public IVipManager obtainVipManager() {
            return new VipManager();
        }

        @Override // com.qzone.proxy.vipcomponent.IVipComponentService
        public void refreshAllVipInfo() {
            VipEnv.refreshAllVipInfo();
        }

        @Override // com.qzone.proxy.vipcomponent.IVipComponentService
        public void refreshYellowDiamondInfo() {
            VipEnv.refreshYellowDiamondInfo();
        }

        @Override // com.qzone.proxy.vipcomponent.IVipComponentService
        public void saveABtest(String str, int i3, long j3) {
            VipInfoManager.getInstance().saveABtest(str, i3, j3);
        }

        @Override // com.qzone.proxy.vipcomponent.IVipComponentService
        public void setYellowDiamondHaveBeenToPayPage(boolean z16) {
            VipBusinessManager.haveBeenToPayPage = z16;
        }

        @Override // com.qzone.proxy.vipcomponent.IVipComponentService
        public void setYellowDiamondHavePaid(boolean z16) {
            VipBusinessManager.havePaid = z16;
        }

        @Override // com.qzone.proxy.vipcomponent.IVipComponentService
        public void updateLoveVipInfo(String str, sweet_style_info_item sweet_style_info_itemVar) {
            VipInfoManager.getInstance().updateLoveVipInfo(str, sweet_style_info_itemVar);
        }

        @Override // com.qzone.proxy.vipcomponent.IVipComponentService
        public void updateQQNewVip(String str, boolean z16, Map<String, IconInfo> map) {
            VipInfoManager.getInstance().updateQQNewVip(str, z16, map);
        }

        @Override // com.qzone.proxy.vipcomponent.IVipComponentService
        public void updateQQUnionVip(String str, boolean z16, int i3, Map<String, IconInfo> map) {
            VipInfoManager.getInstance().updateQQUnionVip(str, z16, i3, map);
        }

        @Override // com.qzone.proxy.vipcomponent.IVipComponentService
        public void updateVipInfo(String str, int i3, int i16, boolean z16, star_info star_infoVar, combine_diamond_info combine_diamond_infoVar, String str2, boolean z17) {
            VipInfoManager.getInstance().updateVipInfo(str, i3, i16, z16, star_infoVar, combine_diamond_infoVar, str2, z17);
        }

        @Override // com.qzone.proxy.vipcomponent.IVipComponentService
        public void updateVipInfoDiamondUrl(String str, boolean z16, String str2) {
            VipInfoManager.getInstance().updateVipInfoDiamondUrl(str, z16, str2);
        }

        @Override // com.qzone.proxy.vipcomponent.IVipComponentService
        public void updateVipInfo(String str, QzoneVipInfo qzoneVipInfo) {
            VipInfoManager.getInstance().updateVipInfo(str, qzoneVipInfo);
        }

        @Override // com.qzone.proxy.vipcomponent.IVipComponentService
        public void updateVipInfo(String str, int i3, String str2) {
            VipInfoManager.getInstance().updateVipInfo(str, i3, str2, false);
        }
    };

    @Override // com.qzone.module.Proxy
    public String getModuleClassName() {
        return "com.qzone.module.vipcomponent.VipcomponentModule";
    }

    @Override // com.qzone.module.Module
    public String getName() {
        return "VipcomponentModule";
    }

    @Override // com.qzone.module.Module
    public int getVersion() {
        return 0;
    }

    @Override // com.qzone.module.Proxy, com.qzone.module.IProxy
    public IVipComponentService getServiceInterface() {
        return this.iVipComponentService;
    }

    @Override // com.qzone.module.Proxy, com.qzone.module.IProxy
    public IVipComponentUI getUiInterface() {
        return this.iVipComponentUI;
    }
}

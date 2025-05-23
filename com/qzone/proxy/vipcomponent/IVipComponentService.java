package com.qzone.proxy.vipcomponent;

import NS_COMM_VIP_GROWTH.IconInfo;
import NS_MOBILE_COMM.combine_diamond_info;
import NS_MOBILE_COMM.star_info;
import SWEET_NEW_PRIVILEGE.sweet_style_info_item;
import com.qzone.proxy.vipcomponent.adapter.IVipManager;
import com.qzone.proxy.vipcomponent.model.QzoneVipInfo;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public interface IVipComponentService {
    long getABTestTimeStamp();

    int getABTestType();

    int getComDiamondLevel();

    int getComDiamondType();

    QzoneVipInfo getCurrentVipInfo();

    String getLoveVipIconJumpUrl(String str);

    int getLoveVipIconLevel(String str);

    String getLoveVipIconPicUrl(String str);

    sweet_style_info_item getLoveVipInfo(String str);

    int getStarVipLevel();

    QzoneVipInfo getVipInfo(String str);

    int getVipLevel();

    int getVipType();

    boolean getYellowDiamondHaveBeenToPayPage();

    boolean getYellowDiamondHavePaid();

    int getstarVipStatus();

    boolean isAnnualVip();

    boolean isAnnualVipEver();

    boolean isComDiamondAnnualVip();

    boolean isQzoneVip();

    boolean isShowEventLoveVipIcon(String str);

    boolean isStarAnnualVip();

    boolean isSuperQzoneVip();

    IVipManager obtainVipManager();

    void refreshAllVipInfo();

    void refreshYellowDiamondInfo();

    void saveABtest(String str, int i3, long j3);

    void setYellowDiamondHaveBeenToPayPage(boolean z16);

    void setYellowDiamondHavePaid(boolean z16);

    void updateLoveVipInfo(String str, sweet_style_info_item sweet_style_info_itemVar);

    void updateQQNewVip(String str, boolean z16, Map<String, IconInfo> map);

    void updateQQUnionVip(String str, boolean z16, int i3, Map<String, IconInfo> map);

    void updateVipInfo(String str, int i3, int i16, boolean z16, star_info star_infoVar, combine_diamond_info combine_diamond_infoVar, String str2, boolean z17);

    void updateVipInfo(String str, int i3, String str2);

    void updateVipInfo(String str, QzoneVipInfo qzoneVipInfo);

    void updateVipInfoDiamondUrl(String str, boolean z16, String str2);
}

package com.qzone.module.vipcomponent.service;

import NS_COMM_VIP_GROWTH.IconInfo;
import NS_MOBILE_COMM.combine_diamond_info;
import NS_MOBILE_COMM.star_info;
import SWEET_NEW_PRIVILEGE.sweet_style_info_item;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import com.qzone.proxy.vipcomponent.adapter.VipEnv;
import com.qzone.proxy.vipcomponent.model.QzoneVipInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.vas.VipNtMMKV;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import cooperation.vip.vipcomponent.QQUnionIconInfo;
import cooperation.vip.vipcomponent.util.b;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class VipInfoManager {
    public static final String TAG = "VipInfoManager";

    /* renamed from: d, reason: collision with root package name */
    private static VipInfoManager f49038d;

    /* renamed from: b, reason: collision with root package name */
    private Handler f49040b = new Handler(VipEnv.getBackGroundLopper());

    /* renamed from: c, reason: collision with root package name */
    private int f49041c = 1;

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, QzoneVipInfo> f49039a = new HashMap<>();

    public VipInfoManager() {
        b.d(TAG, " VipInfoManager init");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String f(String str) {
        return MimeHelper.IMAGE_SUBTYPE_BITMAP + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String g(String str) {
        return "diamond" + str;
    }

    public static VipInfoManager getInstance() {
        if (f49038d == null) {
            synchronized (VipInfoManager.class) {
                if (f49038d == null) {
                    f49038d = new VipInfoManager();
                }
            }
        }
        return f49038d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String h(String str) {
        return "personalized" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String i(String str) {
        return "vip_map" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String j(String str) {
        return "union_map" + str;
    }

    private void k(final String str, final QzoneVipInfo qzoneVipInfo) {
        this.f49040b.post(new Runnable() { // from class: com.qzone.module.vipcomponent.service.VipInfoManager.1
            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences multiProSp = VipEnv.getMultiProSp("vas_qzone");
                if (multiProSp != null) {
                    b.d(VipInfoManager.TAG, " VipInfoManager write sp pro = " + VipEnv.getCurrentProName());
                    VipNtMMKV.getCommon(str).encodeBool("vas_qzone_vip_pay", false);
                    SharedPreferences.Editor edit = multiProSp.edit();
                    edit.putInt(VipInfoManager.this.f(str), qzoneVipInfo.getBitMap());
                    edit.putString(VipInfoManager.this.h(str), qzoneVipInfo.getPersonalizedYellowVipUrl());
                    edit.putString(VipInfoManager.this.g(str), qzoneVipInfo.getCustomDiamondUrl());
                    String j3 = VipInfoManager.this.j(str);
                    QzoneVipInfo qzoneVipInfo2 = qzoneVipInfo;
                    edit.putString(j3, qzoneVipInfo2.convertMapToJson(qzoneVipInfo2.getQQUnionVipIconMap()));
                    String i3 = VipInfoManager.this.i(str);
                    QzoneVipInfo qzoneVipInfo3 = qzoneVipInfo;
                    edit.putString(i3, qzoneVipInfo3.convertMapToJson(qzoneVipInfo3.getQQNewVipIconMap()));
                    edit.commit();
                }
            }
        });
    }

    public long getABTestTimeStamp() {
        return VipEnv.getLocalConfigLong(VipEnv.getLoginUin() + "_openVipDialogTimestamp", 0L);
    }

    public int getABTestType() {
        return this.f49041c;
    }

    public String getLoveVipIconJumpUrl(String str) {
        QzoneVipInfo qzoneVipInfo = this.f49039a.get(str);
        if (qzoneVipInfo != null) {
            return qzoneVipInfo.getLoveVipIconJumpUrl();
        }
        return "";
    }

    public int getLoveVipIconLevel(String str) {
        QzoneVipInfo qzoneVipInfo = this.f49039a.get(str);
        if (qzoneVipInfo != null) {
            return qzoneVipInfo.getLoveVipDiamondLevel();
        }
        return 0;
    }

    public String getLoveVipIconPicUrl(String str) {
        QzoneVipInfo qzoneVipInfo = this.f49039a.get(str);
        if (qzoneVipInfo != null) {
            return qzoneVipInfo.getLoveVipIconPicUrl();
        }
        return "";
    }

    public sweet_style_info_item getLoveVipInfo(String str) {
        QzoneVipInfo qzoneVipInfo = this.f49039a.get(str);
        if (qzoneVipInfo == null) {
            return null;
        }
        sweet_style_info_item sweet_style_info_itemVar = new sweet_style_info_item();
        sweet_style_info_itemVar.pic_url = qzoneVipInfo.getLoveVipIconPicUrl();
        sweet_style_info_itemVar.jump_url = qzoneVipInfo.getLoveVipIconJumpUrl();
        sweet_style_info_itemVar.level = qzoneVipInfo.getLoveVipDiamondLevel();
        return sweet_style_info_itemVar;
    }

    public QzoneVipInfo getVipInfo(String str) {
        String str2;
        String str3;
        String str4;
        QzoneVipInfo qzoneVipInfo;
        int i3 = 0;
        if (VasNormalToggle.QZONE_VIP_CACHE_FIX.isEnable(false) && (qzoneVipInfo = this.f49039a.get(str)) != null) {
            return qzoneVipInfo;
        }
        SharedPreferences multiProSp = VipEnv.getMultiProSp("vas_qzone");
        String str5 = null;
        if (multiProSp != null) {
            i3 = multiProSp.getInt(f(str), 0);
            String string = multiProSp.getString(h(str), null);
            str3 = multiProSp.getString(g(str), null);
            str4 = multiProSp.getString(j(str), null);
            str2 = multiProSp.getString(i(str), null);
            str5 = string;
        } else {
            str2 = null;
            str3 = null;
            str4 = null;
        }
        QzoneVipInfo qzoneVipInfo2 = new QzoneVipInfo(i3, str5);
        qzoneVipInfo2.setCustomDiamondUrl(str3);
        qzoneVipInfo2.setQQUnionVipIconMap(qzoneVipInfo2.convertJsonToMap(str4));
        qzoneVipInfo2.setQQNewVipIconMap(qzoneVipInfo2.convertJsonToMap(str2));
        this.f49039a.put(str, qzoneVipInfo2);
        return qzoneVipInfo2;
    }

    public boolean isShowEventLoveVipIcon(String str) {
        if (this.f49039a.get(str) != null) {
            return (TextUtils.isEmpty(getLoveVipIconPicUrl(str)) || TextUtils.isEmpty(getLoveVipIconJumpUrl(str))) ? false : true;
        }
        return false;
    }

    public void updateLoveVipInfo(String str, sweet_style_info_item sweet_style_info_itemVar) {
        QzoneVipInfo qzoneVipInfo = this.f49039a.get(str);
        if (qzoneVipInfo == null) {
            qzoneVipInfo = new QzoneVipInfo(0, null);
            this.f49039a.put(str, qzoneVipInfo);
        }
        if (sweet_style_info_itemVar != null) {
            qzoneVipInfo.setLoveVipDiamondLevel((int) sweet_style_info_itemVar.level);
            qzoneVipInfo.setLoveVipIconJumpUrl(sweet_style_info_itemVar.jump_url);
            qzoneVipInfo.setLoveVipIconPicUrl(sweet_style_info_itemVar.pic_url);
        }
        k(str, qzoneVipInfo);
    }

    public void updateQQNewVip(String str, boolean z16, Map<String, IconInfo> map) {
        QzoneVipInfo qzoneVipInfo = this.f49039a.get(str);
        if (qzoneVipInfo == null) {
            qzoneVipInfo = new QzoneVipInfo(0, null);
            this.f49039a.put(str, qzoneVipInfo);
        }
        qzoneVipInfo.setShowNewVip(z16);
        qzoneVipInfo.setQQNewVipIconMap(QQUnionIconInfo.convertToQQUnionIconMap(map));
        k(str, qzoneVipInfo);
    }

    public void updateQQUnionVip(String str, boolean z16, int i3, Map<String, IconInfo> map) {
        QzoneVipInfo qzoneVipInfo = this.f49039a.get(str);
        if (qzoneVipInfo == null) {
            qzoneVipInfo = new QzoneVipInfo(0, null);
            this.f49039a.put(str, qzoneVipInfo);
        }
        qzoneVipInfo.setQQUnionVip(z16);
        qzoneVipInfo.setQQUnionVipLevel(i3);
        qzoneVipInfo.setQQUnionVipIconMap(QQUnionIconInfo.convertToQQUnionIconMap(map));
        k(str, qzoneVipInfo);
    }

    public void updateVipInfo(String str, int i3, int i16, boolean z16, star_info star_infoVar, combine_diamond_info combine_diamond_infoVar, String str2, boolean z17) {
        int bitMap;
        String personalizedYellowVipUrl;
        if (!TextUtils.isEmpty(str)) {
            QzoneVipInfo vipInfo = getVipInfo(str);
            if (vipInfo == null) {
                personalizedYellowVipUrl = null;
                vipInfo = new QzoneVipInfo(0, null);
                bitMap = -1;
            } else {
                bitMap = vipInfo.getBitMap();
                personalizedYellowVipUrl = vipInfo.getPersonalizedYellowVipUrl();
            }
            vipInfo.setVipType(i3);
            vipInfo.setVipLevel(i16);
            vipInfo.setIsAnnualVip(z16);
            if (z17) {
                vipInfo.setPersonalizedYellowVipUrl(str2);
            }
            if (star_infoVar != null) {
                vipInfo.setStarStatus(star_infoVar.iStarStatus);
                vipInfo.setStarLevel(star_infoVar.iStarLevel);
                vipInfo.setIsStarAnnualVip(star_infoVar.isAnnualVip != 0);
                vipInfo.setIsHighStarVip(star_infoVar.isHighStarVip != 0);
            }
            if (combine_diamond_infoVar != null) {
                vipInfo.setComDiamondType(combine_diamond_infoVar.iShowType);
                vipInfo.setComDiamondLevel(combine_diamond_infoVar.iVipLevel);
                vipInfo.setIsComDiamondAnnualVip(combine_diamond_infoVar.isAnnualVip != 0);
                vipInfo.setIsAnnualVipEver(combine_diamond_infoVar.isAnnualVipEver != 0);
            }
            this.f49039a.put(str, vipInfo);
            if (bitMap == vipInfo.getBitMap() && personalizedYellowVipUrl != null && personalizedYellowVipUrl.equals(vipInfo.getPersonalizedYellowVipUrl())) {
                return;
            }
            k(str, vipInfo);
            return;
        }
        b.d(TAG, "updateVipInfo uin = null");
    }

    public void updateVipInfoDiamondUrl(String str, boolean z16, String str2) {
        QzoneVipInfo qzoneVipInfo = this.f49039a.get(str);
        if (qzoneVipInfo == null) {
            qzoneVipInfo = new QzoneVipInfo(0, null);
            this.f49039a.put(str, qzoneVipInfo);
        }
        qzoneVipInfo.setIsCustomDiamond(z16);
        qzoneVipInfo.setCustomDiamondUrl(str2);
        k(str, qzoneVipInfo);
    }

    public void saveABtest(String str, int i3, long j3) {
        if (2 == i3 || 1 == i3) {
            VipEnv.putLocalConfigInt(str + "_openVipDialogType", i3);
            VipEnv.putLocalConfigLong(str + "_openVipDialogTimestamp", j3);
            this.f49041c = i3;
        }
    }

    public void updateVipInfo(String str, QzoneVipInfo qzoneVipInfo) {
        if (qzoneVipInfo != null) {
            QzoneVipInfo qzoneVipInfo2 = this.f49039a.get(str);
            this.f49039a.put(str, qzoneVipInfo);
            if (qzoneVipInfo2 == null || qzoneVipInfo2.getBitMap() != qzoneVipInfo.getBitMap() || qzoneVipInfo2.getPersonalizedYellowVipUrl() == null || !qzoneVipInfo2.getPersonalizedYellowVipUrl().equals(qzoneVipInfo.getPersonalizedYellowVipUrl())) {
                k(str, qzoneVipInfo);
            }
        }
    }

    public void updateVipInfo(String str, int i3, String str2, boolean z16) {
        QzoneVipInfo qzoneVipInfo = this.f49039a.get(str);
        boolean z17 = z16 && (qzoneVipInfo == null || i3 != qzoneVipInfo.getBitMap());
        if (qzoneVipInfo == null) {
            qzoneVipInfo = new QzoneVipInfo(i3, str2);
            this.f49039a.put(str, qzoneVipInfo);
        } else {
            qzoneVipInfo.setBitmap(i3);
            qzoneVipInfo.setPersonalizedYellowVipUrl(str2);
        }
        if (z17) {
            k(str, qzoneVipInfo);
        }
    }
}

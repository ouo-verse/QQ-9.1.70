package com.qzone.proxy.vipcomponent.model;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import cooperation.vip.b;
import cooperation.vip.manager.i;
import cooperation.vip.vipcomponent.QQUnionIconInfo;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneVipInfo {

    /* renamed from: a, reason: collision with root package name */
    private int f51004a;

    /* renamed from: b, reason: collision with root package name */
    private String f51005b;

    /* renamed from: c, reason: collision with root package name */
    private String f51006c = i.r().q();

    /* renamed from: d, reason: collision with root package name */
    private Map<String, QQUnionIconInfo> f51007d;

    /* renamed from: e, reason: collision with root package name */
    private String f51008e;

    /* renamed from: f, reason: collision with root package name */
    private String f51009f;
    public Map<String, QQUnionIconInfo> qqNewIconMap;
    public boolean showNewVip;

    public QzoneVipInfo(int i3, String str) {
        this.f51004a = i3;
        this.f51005b = str;
    }

    public int getBitMap() {
        return this.f51004a;
    }

    public int getComDiamondLevel() {
        return i.o(this.f51004a);
    }

    public int getComDiamondType() {
        return i.p(this.f51004a);
    }

    public String getCustomDiamondUrl() {
        return this.f51006c;
    }

    public int getLoveVipDiamondLevel() {
        return i.s(this.f51004a);
    }

    public String getLoveVipIconJumpUrl() {
        return this.f51009f;
    }

    public String getLoveVipIconPicUrl() {
        return this.f51008e;
    }

    public String getPersonalizedYellowVipUrl() {
        return this.f51005b;
    }

    public Map<String, QQUnionIconInfo> getQQNewVipIconMap() {
        return this.qqNewIconMap;
    }

    public Map<String, QQUnionIconInfo> getQQUnionVipIconMap() {
        return this.f51007d;
    }

    public int getQQUnionVipLevel() {
        return i.v(this.f51004a);
    }

    public int getStarLevel() {
        return i.t(this.f51004a);
    }

    public int getStarStatus() {
        return i.u(this.f51004a);
    }

    public int getVipLevel() {
        return i.y(this.f51004a);
    }

    public int getVipType() {
        return i.A(this.f51004a);
    }

    public boolean isAnnualVip() {
        return i.B(this.f51004a);
    }

    public boolean isAnnualVipEver() {
        return i.C(this.f51004a);
    }

    public boolean isComDiamondAnnualVip() {
        return i.D(this.f51004a);
    }

    public boolean isCustomDiamond() {
        return i.E(this.f51004a);
    }

    public boolean isHighStarVip() {
        return i.F(this.f51004a);
    }

    public boolean isQQUnionVip() {
        return i.I(this.f51004a);
    }

    public boolean isShowLoveVipIcon() {
        return TextUtils.isEmpty(this.f51009f) || TextUtils.isEmpty(this.f51008e);
    }

    public boolean isShowNewVip() {
        Map<String, QQUnionIconInfo> map = this.qqNewIconMap;
        return (map == null || map.size() == 0) ? false : true;
    }

    public boolean isStarAnnualVip() {
        return i.H(this.f51004a);
    }

    public void setBitmap(int i3) {
        this.f51004a = i3;
    }

    public void setComDiamondLevel(int i3) {
        this.f51004a = i.M(this.f51004a, i3);
    }

    public void setComDiamondType(int i3) {
        this.f51004a = i.N(this.f51004a, i3);
    }

    public void setCustomDiamondUrl(String str) {
        this.f51006c = str;
    }

    public void setIsAnnualVip(boolean z16) {
        this.f51004a = i.O(this.f51004a, z16);
    }

    public void setIsAnnualVipEver(boolean z16) {
        this.f51004a = i.P(this.f51004a, z16);
    }

    public void setIsComDiamondAnnualVip(boolean z16) {
        this.f51004a = i.Q(this.f51004a, z16);
    }

    public void setIsCustomDiamond(boolean z16) {
        this.f51004a = i.R(this.f51004a, z16);
    }

    public void setIsHighStarVip(boolean z16) {
        this.f51004a = i.S(this.f51004a, z16);
    }

    public void setIsStarAnnualVip(boolean z16) {
        this.f51004a = i.T(this.f51004a, z16);
    }

    public void setLoveVipDiamondLevel(int i3) {
        this.f51004a = i.V(this.f51004a, i3);
    }

    public void setLoveVipIconJumpUrl(String str) {
        this.f51009f = str;
    }

    public void setLoveVipIconPicUrl(String str) {
        this.f51008e = str;
    }

    public void setPersonalizedYellowVipUrl(String str) {
        this.f51005b = str;
    }

    public void setQQNewVipIconMap(Map<String, QQUnionIconInfo> map) {
        this.qqNewIconMap = map;
    }

    public void setQQUnionVip(boolean z16) {
        this.f51004a = i.U(this.f51004a, z16);
    }

    public void setQQUnionVipIconMap(Map<String, QQUnionIconInfo> map) {
        this.f51007d = map;
    }

    public void setQQUnionVipLevel(int i3) {
        this.f51004a = i.Y(this.f51004a, i3);
    }

    public void setShowNewVip(boolean z16) {
        this.showNewVip = z16;
    }

    public void setStarLevel(int i3) {
        this.f51004a = i.W(this.f51004a, i3);
    }

    public void setStarStatus(int i3) {
        this.f51004a = i.X(this.f51004a, i3);
    }

    public void setVipLevel(int i3) {
        this.f51004a = i.a0(this.f51004a, i3);
    }

    public void setVipType(int i3) {
        this.f51004a = i.b0(this.f51004a, i3);
    }

    public String toString() {
        return getVipType() + ContainerUtils.FIELD_DELIMITER + getVipType() + ContainerUtils.FIELD_DELIMITER + isAnnualVip() + ContainerUtils.FIELD_DELIMITER + getStarStatus() + ContainerUtils.FIELD_DELIMITER + getStarLevel() + ContainerUtils.FIELD_DELIMITER + isStarAnnualVip() + ContainerUtils.FIELD_DELIMITER + getComDiamondType() + ContainerUtils.FIELD_DELIMITER + getComDiamondLevel() + ContainerUtils.FIELD_DELIMITER + isComDiamondAnnualVip() + ContainerUtils.FIELD_DELIMITER + isAnnualVipEver();
    }

    public Map<String, QQUnionIconInfo> convertJsonToMap(String str) {
        try {
            Map<String, Object> b16 = b.b(new JSONObject(str));
            if (b16 == null) {
                return null;
            }
            HashMap hashMap = new HashMap(b16.size());
            for (Map.Entry<String, Object> entry : b16.entrySet()) {
                if (entry != null) {
                    hashMap.put(entry.getKey(), QQUnionIconInfo.parseFromJson(new JSONObject((Map) entry.getValue())));
                }
            }
            return hashMap;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public String convertMapToJson(Map<String, QQUnionIconInfo> map) {
        if (map == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, QQUnionIconInfo> entry : map.entrySet()) {
            if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                hashMap.put(entry.getKey(), QQUnionIconInfo.convertToJson(entry.getValue()));
            }
        }
        return new JSONObject(hashMap).toString();
    }
}

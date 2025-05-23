package com.tencent.mobileqq.data;

import NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_rsp;
import android.os.Parcel;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.model.CoverCacheData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes10.dex */
public class QZoneCover extends Entity {
    public int jigsaw;
    public String type;

    @unique
    public String uin;
    public byte[] vCoverInfo;
    public byte[] vPhotoInfo;

    public HashMap<String, String> parseCoverInfo() {
        HashMap hashMap = null;
        if (this.vCoverInfo == null) {
            return null;
        }
        try {
            Parcel obtain = Parcel.obtain();
            byte[] bArr = this.vCoverInfo;
            obtain.unmarshall(bArr, 0, bArr.length);
            obtain.setDataPosition(0);
            hashMap = obtain.readHashMap(getClass().getClassLoader());
            OaidMonitor.parcelRecycle(obtain);
            return hashMap;
        } catch (Exception unused) {
            return hashMap;
        }
    }

    public ArrayList<Map<Integer, String>> parsePhotoInfo() {
        ArrayList arrayList = null;
        if (this.vPhotoInfo == null) {
            return null;
        }
        try {
            Parcel obtain = Parcel.obtain();
            byte[] bArr = this.vPhotoInfo;
            obtain.unmarshall(bArr, 0, bArr.length);
            obtain.setDataPosition(0);
            arrayList = obtain.readArrayList(getClass().getClassLoader());
            OaidMonitor.parcelRecycle(obtain);
            return arrayList;
        } catch (Error e16) {
            if (QLog.isColorLevel()) {
                QLog.i(LogTag.PROFILE_CARD, 2, e16.toString());
                return arrayList;
            }
            return arrayList;
        } catch (Exception e17) {
            if (QLog.isColorLevel()) {
                QLog.i(LogTag.PROFILE_CARD, 2, e17.toString());
                return arrayList;
            }
            return arrayList;
        }
    }

    protected void printInfo(String str, String str2, String str3, Map<String, String> map, ArrayList<Map<Integer, String>> arrayList) {
        if (QLog.isColorLevel()) {
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    entry.getKey();
                    entry.getValue();
                }
            }
            if (arrayList != null) {
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    Map<Integer, String> map2 = arrayList.get(i3);
                    if (map2 != null) {
                        for (Map.Entry<Integer, String> entry2 : map2.entrySet()) {
                            Objects.toString(entry2.getKey());
                            entry2.getValue();
                        }
                    }
                }
            }
        }
    }

    public void updateQzoneCover(CoverCacheData coverCacheData) {
        if (coverCacheData == null) {
            return;
        }
        printInfo("updateQzoneCover|CoverCacheData", "null", coverCacheData.type, coverCacheData.urls, coverCacheData.photoWall);
        this.type = coverCacheData.type;
        this.jigsaw = coverCacheData.isJigsawOpen;
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        obtain.writeMap(coverCacheData.urls);
        this.vCoverInfo = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        Parcel obtain2 = Parcel.obtain();
        obtain2.setDataPosition(0);
        obtain2.writeList(coverCacheData.photoWall);
        this.vPhotoInfo = obtain2.marshall();
        OaidMonitor.parcelRecycle(obtain2);
    }

    public void updateQzoneCover(mobile_sub_get_cover_rsp mobile_sub_get_cover_rspVar) {
        if (mobile_sub_get_cover_rspVar == null) {
            return;
        }
        printInfo("updateQzoneCover|mobile_sub_get_cover_rsp", "null", mobile_sub_get_cover_rspVar.type, mobile_sub_get_cover_rspVar.MulRelsotionUrl, mobile_sub_get_cover_rspVar.vecUrls);
        this.type = mobile_sub_get_cover_rspVar.type;
        this.jigsaw = mobile_sub_get_cover_rspVar.photoWallCombinePic;
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        obtain.writeMap(mobile_sub_get_cover_rspVar.MulRelsotionUrl);
        this.vCoverInfo = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        Parcel obtain2 = Parcel.obtain();
        obtain2.setDataPosition(0);
        obtain2.writeList(mobile_sub_get_cover_rspVar.vecUrls);
        this.vPhotoInfo = obtain2.marshall();
        OaidMonitor.parcelRecycle(obtain2);
    }
}

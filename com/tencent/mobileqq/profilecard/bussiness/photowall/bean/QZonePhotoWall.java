package com.tencent.mobileqq.profilecard.bussiness.photowall.bean;

import NS_MOBILE_MAIN_PAGE.PhotoWall;
import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
import android.os.Parcel;
import android.text.TextUtils;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes16.dex */
public class QZonePhotoWall extends Entity {
    static IPatchRedirector $redirector_;
    public String attachInfo;

    @notColumn
    public int curListSize;
    public int hasMore;
    public int totalPic;

    @unique
    public String uin;
    public byte[] vPhotoIds;
    public byte[] vPhotoTimes;
    public byte[] vPhotoUrls;

    public QZonePhotoWall() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void packPhotoWallData(String str, ArrayList<PhotoWall> arrayList) {
        ArrayList<PhotoWall> arrayList2 = new ArrayList<>();
        if (!TextUtils.isEmpty(str)) {
            arrayList2 = unpackPhotoWallData();
        }
        arrayList2.addAll(arrayList);
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        Iterator<PhotoWall> it = arrayList2.iterator();
        while (it.hasNext()) {
            PhotoWall next = it.next();
            arrayList3.add(next.photoId);
            arrayList4.add(Long.valueOf(next.ctime));
            arrayList5.add(next.photoUrls);
        }
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        obtain.writeList(arrayList3);
        this.vPhotoIds = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        Parcel obtain2 = Parcel.obtain();
        obtain2.setDataPosition(0);
        obtain2.writeList(arrayList4);
        this.vPhotoTimes = obtain2.marshall();
        OaidMonitor.parcelRecycle(obtain2);
        Parcel obtain3 = Parcel.obtain();
        obtain3.setDataPosition(0);
        obtain3.writeList(arrayList5);
        this.vPhotoUrls = obtain3.marshall();
        OaidMonitor.parcelRecycle(obtain3);
        this.curListSize = arrayList2.size();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder(20);
        sb5.append("QZonePhotoWall totalPic:");
        sb5.append(this.totalPic);
        sb5.append(" hasMore:");
        sb5.append(this.hasMore);
        sb5.append(" photoWallSize:");
        sb5.append(this.curListSize);
        return sb5.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00e9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00f3 A[Catch: Exception -> 0x011a, TRY_LEAVE, TryCatch #2 {Exception -> 0x011a, blocks: (B:20:0x00ed, B:22:0x00f3), top: B:19:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ad A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0067 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArrayList<PhotoWall> unpackPhotoWallData() {
        ArrayList arrayList;
        Parcel obtain;
        ArrayList arrayList2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        ArrayList<PhotoWall> arrayList3 = new ArrayList<>();
        ArrayList arrayList4 = null;
        if (this.vPhotoIds != null) {
            try {
                obtain = Parcel.obtain();
                byte[] bArr = this.vPhotoIds;
                obtain.unmarshall(bArr, 0, bArr.length);
                obtain.setDataPosition(0);
                arrayList = obtain.readArrayList(getClass().getClassLoader());
            } catch (Error e16) {
                e = e16;
                arrayList = null;
            } catch (Exception e17) {
                e = e17;
                arrayList = null;
            }
            try {
                OaidMonitor.parcelRecycle(obtain);
            } catch (Error e18) {
                e = e18;
                if (QLog.isColorLevel()) {
                    QLog.i(LogTag.PROFILE_CARD, 2, e.toString());
                }
                if (this.vPhotoTimes != null) {
                }
                if (this.vPhotoUrls != null) {
                }
                if (arrayList != null) {
                    while (r5 < arrayList.size()) {
                        try {
                        } catch (Exception e19) {
                            if (QLog.isColorLevel()) {
                                QLog.e(LogTag.QZONE_PHOTO_WALL, 2, "unpackPhotoWallData e:" + e19.toString());
                            }
                        }
                    }
                }
                return arrayList3;
            } catch (Exception e26) {
                e = e26;
                if (QLog.isColorLevel()) {
                    QLog.i(LogTag.PROFILE_CARD, 2, e.toString());
                }
                if (this.vPhotoTimes != null) {
                }
                if (this.vPhotoUrls != null) {
                }
                if (arrayList != null) {
                }
                return arrayList3;
            }
        } else {
            arrayList = null;
        }
        if (this.vPhotoTimes != null) {
            try {
                Parcel obtain2 = Parcel.obtain();
                byte[] bArr2 = this.vPhotoTimes;
                obtain2.unmarshall(bArr2, 0, bArr2.length);
                obtain2.setDataPosition(0);
                arrayList2 = obtain2.readArrayList(getClass().getClassLoader());
                try {
                    OaidMonitor.parcelRecycle(obtain2);
                } catch (Error e27) {
                    e = e27;
                    if (QLog.isColorLevel()) {
                        QLog.i(LogTag.PROFILE_CARD, 2, e.toString());
                    }
                    if (this.vPhotoUrls != null) {
                    }
                    if (arrayList != null) {
                    }
                    return arrayList3;
                } catch (Exception e28) {
                    e = e28;
                    if (QLog.isColorLevel()) {
                        QLog.i(LogTag.PROFILE_CARD, 2, e.toString());
                    }
                    if (this.vPhotoUrls != null) {
                    }
                    if (arrayList != null) {
                    }
                    return arrayList3;
                }
            } catch (Error e29) {
                e = e29;
                arrayList2 = null;
            } catch (Exception e36) {
                e = e36;
                arrayList2 = null;
            }
        } else {
            arrayList2 = null;
        }
        if (this.vPhotoUrls != null) {
            try {
                Parcel obtain3 = Parcel.obtain();
                byte[] bArr3 = this.vPhotoUrls;
                obtain3.unmarshall(bArr3, 0, bArr3.length);
                obtain3.setDataPosition(0);
                arrayList4 = obtain3.readArrayList(getClass().getClassLoader());
                OaidMonitor.parcelRecycle(obtain3);
            } catch (Error e37) {
                if (QLog.isColorLevel()) {
                    QLog.i(LogTag.PROFILE_CARD, 2, e37.toString());
                }
            } catch (Exception e38) {
                if (QLog.isColorLevel()) {
                    QLog.i(LogTag.PROFILE_CARD, 2, e38.toString());
                }
            }
        }
        if (arrayList != null && arrayList2 != null && arrayList4 != null) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                PhotoWall photoWall = new PhotoWall();
                photoWall.ctime = ((Long) arrayList2.get(i3)).longValue();
                photoWall.photoId = (String) arrayList.get(i3);
                photoWall.photoUrls = (Map) arrayList4.get(i3);
                arrayList3.add(photoWall);
            }
        }
        return arrayList3;
    }

    public void updateQzonePhotoWall(String str, mobile_sub_get_photo_wall_rsp mobile_sub_get_photo_wall_rspVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) mobile_sub_get_photo_wall_rspVar);
            return;
        }
        if (mobile_sub_get_photo_wall_rspVar == null) {
            return;
        }
        this.totalPic = mobile_sub_get_photo_wall_rspVar.total_pic;
        this.hasMore = mobile_sub_get_photo_wall_rspVar.iHasMore;
        packPhotoWallData(str, mobile_sub_get_photo_wall_rspVar.vecUrls);
        this.attachInfo = mobile_sub_get_photo_wall_rspVar.attachInfo;
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.QZONE_PHOTO_WALL, 2, "updateQzonePhotoWall " + toString());
        }
    }
}

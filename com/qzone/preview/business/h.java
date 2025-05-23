package com.qzone.preview.business;

import android.os.Bundle;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.preview.service.PictureManager;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.remote.Callback;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class h extends g {
    private void A1(ArrayList<PhotoInfo> arrayList) {
        o1(arrayList.size());
        PhotoInfo[] photoInfoArr = this.f49872b;
        int length = photoInfoArr.length;
        this.f49872b = new PhotoInfo[length];
        this.f49885o = arrayList.size();
        for (int i3 = 0; i3 < length; i3++) {
            int i16 = this.f49885o;
            if (i3 + i16 >= 0 && i3 + i16 < this.f49874d) {
                this.f49872b[i16 + i3] = photoInfoArr[i3];
            }
        }
        for (int i17 = 0; i17 < arrayList.size(); i17++) {
            this.f49872b[i17] = arrayList.get(i17);
        }
        this.f49881k += arrayList.size();
        this.f49873c += arrayList.size();
        this.f49885o = 0;
    }

    @Override // com.qzone.preview.business.g, com.qzone.preview.business.BasePicureViewController
    public void C0(QZoneResult qZoneResult, int i3) {
        Bundle bundle;
        if (qZoneResult.getSucceed() && (bundle = qZoneResult.getBundle()) != null) {
            ClassLoader classLoader = this.W;
            if (classLoader != null) {
                bundle.setClassLoader(classLoader);
            }
            ArrayList<PhotoInfo> parcelableArrayList = bundle.getParcelableArrayList("responseList");
            int i16 = bundle.getInt("direction", -1);
            QZLog.d("recentPhotoTimeLine", 1, " direction :", Integer.valueOf(i16));
            if (i16 == -1) {
                return;
            }
            if (parcelableArrayList != null && !parcelableArrayList.isEmpty()) {
                if (i16 == 1) {
                    this.f49883m = !bundle.getBoolean("hasMore", false);
                    k1(parcelableArrayList);
                } else if (i16 == 2) {
                    this.f49882l = !bundle.getBoolean("hasMore", false);
                    A1(parcelableArrayList);
                }
            }
            if (this.f49883m) {
                m1();
            }
        }
        this.f49886p = true;
        this.U = false;
    }

    @Override // com.qzone.preview.business.g, com.qzone.preview.business.BasePicureViewController
    public void Q(Callback callback) {
        x0(callback);
    }

    @Override // com.qzone.preview.business.g, com.qzone.preview.business.BasePicureViewController
    public void Y(Bundle bundle) {
        super.Y(bundle);
        this.f49882l = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.preview.business.g
    public void k1(ArrayList<PhotoInfo> arrayList) {
        o1(arrayList.size());
        int i3 = this.f49881k + 1;
        for (int i16 = 0; i16 < arrayList.size(); i16++) {
            int i17 = i3 + i16;
            PhotoInfo[] photoInfoArr = this.f49872b;
            if (i17 >= photoInfoArr.length) {
                break;
            }
            photoInfoArr[i17] = arrayList.get(i16);
        }
        this.f49881k += arrayList.size();
    }

    @Override // com.qzone.preview.business.g, com.qzone.preview.business.BasePicureViewController
    public void x0(Callback callback) {
        int i3 = this.f49873c;
        int i16 = this.f49884n;
        if (i3 - i16 <= this.f49880j && !this.f49882l) {
            g1(1, 0, callback);
            this.f49879i = this.f49873c;
        } else {
            if (i3 + i16 < this.f49881k || this.f49883m) {
                return;
            }
            g1(0, 1, callback);
            this.f49879i = this.f49873c;
        }
    }

    @Override // com.qzone.preview.business.g
    protected void w1(long j3, int i3, int i16, Callback callback) {
        QZLog.d("recentPhotoTimeLine", 1, "getPullUpRecentPhotoList");
        PictureManager.getInstance().getPullUpRecentPhotoList(j3, callback);
    }

    @Override // com.qzone.preview.business.g
    protected void x1(long j3, Callback callback) {
        QZLog.d("recentPhotoTimeLine", 1, "getPullDownRecentPhotoList");
        PictureManager.getInstance().getPullDownRecentPhotoList(j3, callback);
    }

    @Override // com.qzone.preview.business.g, com.qzone.preview.business.BasePicureViewController
    public boolean g1(int i3, int i16, Callback callback) {
        if (i3 != 0 && this.f49882l) {
            i3 = 0;
        }
        if (i16 != 0 && this.f49883m) {
            i16 = 0;
        }
        if (i3 == 0 && i16 == 0) {
            return false;
        }
        if ((this.U && System.currentTimeMillis() - this.V < 180000) || b() == null) {
            return false;
        }
        long j3 = this.Q;
        if (j3 < 10001) {
            j3 = this.f49877g.ownerUin;
        }
        if (i3 != 0) {
            w1(j3, 0, 0, callback);
        }
        if (i16 != 0) {
            x1(j3, callback);
        }
        this.U = true;
        this.V = System.currentTimeMillis();
        return true;
    }
}

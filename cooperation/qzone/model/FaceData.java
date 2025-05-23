package cooperation.qzone.model;

import NS_MOBILE_FEEDS.FaceRecommendInfo;
import NS_MOBILE_FEEDS.stFaceItem;
import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes28.dex */
public class FaceData implements Serializable {
    public Bitmap bitmap;
    public String faceUrl;

    /* renamed from: h, reason: collision with root package name */
    public long f390863h;
    public long opertime;
    public long owner_uin;
    public int quanstate;
    public String targetGroupid;
    public long targetuin;

    /* renamed from: w, reason: collision with root package name */
    public long f390864w;
    public long writeruin;

    /* renamed from: x, reason: collision with root package name */
    public long f390865x;

    /* renamed from: y, reason: collision with root package name */
    public long f390866y;
    public String album_id = "";
    public String photo_id = "";
    public String faceid = "";
    public String quanid = "";
    public String targetnick = "";
    public String writernick = "";
    public boolean isFromSystem = true;
    public String groupid = "";
    public ArrayList<FaceRecommendInfo> recommend_infos = null;
    public boolean isRecommend = false;

    public static stFaceItem FaceDataTostFaceItem(FaceData faceData) {
        stFaceItem stfaceitem = new stFaceItem();
        stfaceitem.photo_id = faceData.photo_id;
        stfaceitem.f24995x = faceData.f390865x;
        stfaceitem.f24996y = faceData.f390866y;
        stfaceitem.f24994w = faceData.f390864w;
        stfaceitem.f24993h = faceData.f390863h;
        stfaceitem.quanstate = faceData.quanstate;
        stfaceitem.opertime = faceData.opertime;
        stfaceitem.faceid = faceData.faceid;
        stfaceitem.quanid = faceData.quanid;
        stfaceitem.targetuin = faceData.targetuin;
        stfaceitem.targetnick = faceData.targetnick;
        stfaceitem.writeruin = faceData.writeruin;
        stfaceitem.writernick = faceData.writernick;
        stfaceitem.faceUrl = faceData.faceUrl;
        stfaceitem.FromSys = faceData.isFromSystem;
        stfaceitem.groupid = faceData.groupid;
        stfaceitem.recommend_infos = faceData.recommend_infos;
        stfaceitem.target_groupid = faceData.targetGroupid;
        stfaceitem.is_recommend = faceData.isRecommend;
        return stfaceitem;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static FaceData stFaceItemToFaceData(stFaceItem stfaceitem, String str, long j3) {
        long j16;
        int i3;
        FaceData faceData = new FaceData();
        faceData.album_id = str;
        faceData.owner_uin = j3;
        if (stfaceitem != null) {
            faceData.photo_id = stfaceitem.photo_id;
            faceData.f390865x = stfaceitem.f24995x;
            faceData.f390866y = stfaceitem.f24996y;
            faceData.f390864w = stfaceitem.f24994w;
            faceData.f390863h = stfaceitem.f24993h;
            faceData.quanstate = stfaceitem.quanstate;
            faceData.opertime = stfaceitem.opertime;
            faceData.faceid = stfaceitem.faceid;
            faceData.quanid = stfaceitem.quanid;
            faceData.targetuin = stfaceitem.targetuin;
            faceData.targetnick = stfaceitem.targetnick;
            faceData.writeruin = stfaceitem.writeruin;
            faceData.writernick = stfaceitem.writernick;
            faceData.faceUrl = stfaceitem.faceUrl;
            faceData.isFromSystem = stfaceitem.FromSys;
            faceData.groupid = stfaceitem.groupid;
            faceData.targetGroupid = stfaceitem.target_groupid;
            faceData.isRecommend = stfaceitem.is_recommend;
            ArrayList<FaceRecommendInfo> arrayList = new ArrayList<>();
            faceData.recommend_infos = arrayList;
            if (faceData.quanstate == 5) {
                long j17 = faceData.targetuin;
                if (j17 != 0) {
                    arrayList.add(new FaceRecommendInfo(j17, faceData.targetnick, ""));
                    j16 = faceData.targetuin;
                    faceData.targetuin = 0L;
                    faceData.targetnick = "";
                    for (i3 = 0; i3 < stfaceitem.recommend_infos.size(); i3++) {
                        if (stfaceitem.recommend_infos.get(i3).uin != 0 && stfaceitem.recommend_infos.get(i3).uin != j16) {
                            faceData.recommend_infos.add(stfaceitem.recommend_infos.get(i3));
                        }
                    }
                }
            }
            j16 = -1;
            while (i3 < stfaceitem.recommend_infos.size()) {
            }
        }
        return faceData;
    }

    public static ArrayList<FaceData> toFaceDataList(ArrayList<stFaceItem> arrayList, String str, long j3) {
        if (arrayList == null) {
            QLog.e("FaceFuntion", 2, "[Data come back] toFaceDataList | faceItems is null");
            return null;
        }
        ArrayList<FaceData> arrayList2 = new ArrayList<>();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            arrayList2.add(stFaceItemToFaceData(arrayList.get(i3), str, j3));
        }
        return arrayList2;
    }

    public String toString() {
        return "FaceData{album_id='" + this.album_id + "', photo_id='" + this.photo_id + "', owner_uin=" + this.owner_uin + ", x=" + this.f390865x + ", y=" + this.f390866y + ", w=" + this.f390864w + ", h=" + this.f390863h + ", quanstate=" + this.quanstate + ", opertime=" + this.opertime + ", faceid='" + this.faceid + "', quanid='" + this.quanid + "', targetuin=" + this.targetuin + ", targetnick='" + this.targetnick + "', writeruin=" + this.writeruin + ", writernick='" + this.writernick + "', bitmap=" + this.bitmap + ", faceUrl='" + this.faceUrl + "', isFromSystem=" + this.isFromSystem + ", groupid='" + this.groupid + "', recommend_infos=" + this.recommend_infos + ", targetGroupid='" + this.targetGroupid + "'}";
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public FaceData m470clone() {
        FaceData faceData = new FaceData();
        faceData.album_id = this.album_id;
        faceData.photo_id = this.photo_id;
        faceData.owner_uin = this.owner_uin;
        faceData.f390865x = this.f390865x;
        faceData.f390866y = this.f390866y;
        faceData.f390864w = this.f390864w;
        faceData.f390863h = this.f390863h;
        faceData.quanstate = this.quanstate;
        faceData.opertime = this.opertime;
        faceData.faceid = this.faceid;
        faceData.quanid = this.quanid;
        faceData.targetuin = this.targetuin;
        faceData.targetnick = this.targetnick;
        faceData.writeruin = this.writeruin;
        faceData.writernick = this.writernick;
        faceData.bitmap = null;
        faceData.faceUrl = this.faceUrl;
        faceData.isFromSystem = this.isFromSystem;
        return faceData;
    }
}

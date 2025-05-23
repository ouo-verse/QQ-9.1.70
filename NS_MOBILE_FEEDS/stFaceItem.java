package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stFaceItem extends JceStruct {
    static int cache_quanstate;
    static ArrayList<FaceRecommendInfo> cache_recommend_infos = new ArrayList<>();
    public boolean FromSys;
    public String faceUrl;
    public String faceid;
    public String groupid;

    /* renamed from: h, reason: collision with root package name */
    public long f24993h;
    public boolean is_recommend;
    public long opertime;
    public String photo_id;
    public String quanid;
    public int quanstate;
    public ArrayList<FaceRecommendInfo> recommend_infos;
    public String target_groupid;
    public String targetnick;
    public long targetuin;

    /* renamed from: w, reason: collision with root package name */
    public long f24994w;
    public String writernick;
    public long writeruin;

    /* renamed from: x, reason: collision with root package name */
    public long f24995x;

    /* renamed from: y, reason: collision with root package name */
    public long f24996y;

    static {
        cache_recommend_infos.add(new FaceRecommendInfo());
    }

    public stFaceItem() {
        this.photo_id = "";
        this.f24995x = 0L;
        this.f24996y = 0L;
        this.f24994w = 0L;
        this.f24993h = 0L;
        this.quanstate = 0;
        this.opertime = 0L;
        this.faceid = "";
        this.quanid = "";
        this.targetuin = 0L;
        this.targetnick = "";
        this.writeruin = 0L;
        this.writernick = "";
        this.faceUrl = "";
        this.FromSys = true;
        this.groupid = "";
        this.recommend_infos = null;
        this.target_groupid = "";
        this.is_recommend = false;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.photo_id = jceInputStream.readString(0, true);
        this.f24995x = jceInputStream.read(this.f24995x, 1, true);
        this.f24996y = jceInputStream.read(this.f24996y, 2, true);
        this.f24994w = jceInputStream.read(this.f24994w, 3, true);
        this.f24993h = jceInputStream.read(this.f24993h, 4, true);
        this.quanstate = jceInputStream.read(this.quanstate, 5, true);
        this.opertime = jceInputStream.read(this.opertime, 6, true);
        this.faceid = jceInputStream.readString(7, false);
        this.quanid = jceInputStream.readString(8, false);
        this.targetuin = jceInputStream.read(this.targetuin, 9, false);
        this.targetnick = jceInputStream.readString(10, false);
        this.writeruin = jceInputStream.read(this.writeruin, 11, false);
        this.writernick = jceInputStream.readString(12, false);
        this.faceUrl = jceInputStream.readString(13, false);
        this.FromSys = jceInputStream.read(this.FromSys, 14, false);
        this.groupid = jceInputStream.readString(15, false);
        this.recommend_infos = (ArrayList) jceInputStream.read((JceInputStream) cache_recommend_infos, 16, false);
        this.target_groupid = jceInputStream.readString(17, false);
        this.is_recommend = jceInputStream.read(this.is_recommend, 18, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.photo_id, 0);
        jceOutputStream.write(this.f24995x, 1);
        jceOutputStream.write(this.f24996y, 2);
        jceOutputStream.write(this.f24994w, 3);
        jceOutputStream.write(this.f24993h, 4);
        jceOutputStream.write(this.quanstate, 5);
        jceOutputStream.write(this.opertime, 6);
        String str = this.faceid;
        if (str != null) {
            jceOutputStream.write(str, 7);
        }
        String str2 = this.quanid;
        if (str2 != null) {
            jceOutputStream.write(str2, 8);
        }
        jceOutputStream.write(this.targetuin, 9);
        String str3 = this.targetnick;
        if (str3 != null) {
            jceOutputStream.write(str3, 10);
        }
        jceOutputStream.write(this.writeruin, 11);
        String str4 = this.writernick;
        if (str4 != null) {
            jceOutputStream.write(str4, 12);
        }
        String str5 = this.faceUrl;
        if (str5 != null) {
            jceOutputStream.write(str5, 13);
        }
        jceOutputStream.write(this.FromSys, 14);
        String str6 = this.groupid;
        if (str6 != null) {
            jceOutputStream.write(str6, 15);
        }
        ArrayList<FaceRecommendInfo> arrayList = this.recommend_infos;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 16);
        }
        String str7 = this.target_groupid;
        if (str7 != null) {
            jceOutputStream.write(str7, 17);
        }
        jceOutputStream.write(this.is_recommend, 18);
    }

    public stFaceItem(String str, long j3, long j16, long j17, long j18, int i3, long j19, String str2, String str3, long j26, String str4, long j27, String str5, String str6, boolean z16, String str7, ArrayList<FaceRecommendInfo> arrayList, String str8, boolean z17) {
        this.photo_id = str;
        this.f24995x = j3;
        this.f24996y = j16;
        this.f24994w = j17;
        this.f24993h = j18;
        this.quanstate = i3;
        this.opertime = j19;
        this.faceid = str2;
        this.quanid = str3;
        this.targetuin = j26;
        this.targetnick = str4;
        this.writeruin = j27;
        this.writernick = str5;
        this.faceUrl = str6;
        this.FromSys = z16;
        this.groupid = str7;
        this.recommend_infos = arrayList;
        this.target_groupid = str8;
        this.is_recommend = z17;
    }
}

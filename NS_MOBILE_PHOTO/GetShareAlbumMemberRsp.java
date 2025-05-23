package NS_MOBILE_PHOTO;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public class GetShareAlbumMemberRsp extends JceStruct {
    static Album cache_album = new Album();
    static ArrayList<ShareAlbumMemberData> cache_member_datas = new ArrayList<>();
    public Album album;
    public ArrayList<ShareAlbumMemberData> member_datas;

    /* renamed from: msg, reason: collision with root package name */
    public String f25028msg;
    public int ret;

    static {
        cache_member_datas.add(new ShareAlbumMemberData());
    }

    public GetShareAlbumMemberRsp() {
        this.ret = 0;
        this.f25028msg = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret = jceInputStream.read(this.ret, 0, false);
        this.f25028msg = jceInputStream.readString(1, false);
        this.album = (Album) jceInputStream.read((JceStruct) cache_album, 2, false);
        this.member_datas = (ArrayList) jceInputStream.read((JceInputStream) cache_member_datas, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret, 0);
        String str = this.f25028msg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        Album album = this.album;
        if (album != null) {
            jceOutputStream.write((JceStruct) album, 2);
        }
        ArrayList<ShareAlbumMemberData> arrayList = this.member_datas;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
    }

    public GetShareAlbumMemberRsp(int i3, String str, Album album, ArrayList<ShareAlbumMemberData> arrayList) {
        this.ret = i3;
        this.f25028msg = str;
        this.album = album;
        this.member_datas = arrayList;
    }
}

package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ShuoshuoInfoReq extends JceStruct {
    static byte[] cache_busiData;
    static ArrayList<ShuoshuoPicInfo> cache_pic_list = new ArrayList<>();
    public byte[] busiData;
    public int iAlbumTypeID;
    public long iBatchID;
    public ArrayList<ShuoshuoPicInfo> pic_list;
    public String sAlbumID;

    static {
        cache_busiData = r0;
        byte[] bArr = {0};
        cache_pic_list.add(new ShuoshuoPicInfo());
    }

    public ShuoshuoInfoReq() {
        this.sAlbumID = "";
        this.iAlbumTypeID = 0;
        this.iBatchID = 0L;
        this.busiData = null;
        this.pic_list = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.sAlbumID = jceInputStream.readString(0, true);
        this.iAlbumTypeID = jceInputStream.read(this.iAlbumTypeID, 1, true);
        this.iBatchID = jceInputStream.read(this.iBatchID, 2, true);
        this.busiData = jceInputStream.read(cache_busiData, 3, true);
        this.pic_list = (ArrayList) jceInputStream.read((JceInputStream) cache_pic_list, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.sAlbumID, 0);
        jceOutputStream.write(this.iAlbumTypeID, 1);
        jceOutputStream.write(this.iBatchID, 2);
        jceOutputStream.write(this.busiData, 3);
        ArrayList<ShuoshuoPicInfo> arrayList = this.pic_list;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 4);
        }
    }

    public ShuoshuoInfoReq(String str, int i3, long j3, byte[] bArr, ArrayList<ShuoshuoPicInfo> arrayList) {
        this.sAlbumID = str;
        this.iAlbumTypeID = i3;
        this.iBatchID = j3;
        this.busiData = bArr;
        this.pic_list = arrayList;
    }
}

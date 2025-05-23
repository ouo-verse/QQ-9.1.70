package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReqSetCard extends JceStruct {
    static int cache_eSubCmd;
    static ReqHead cache_stHeader;
    static ArrayList<TagInfo> cache_vAddTags;
    static byte[] cache_vBackground;
    static ArrayList<TagInfo> cache_vDelTags;
    static byte[] cache_vReqSetTemplate;
    static ArrayList<TagInfo> cache_vTagsID;
    public byte bIsSingle;
    public int eSubCmd;
    public ReqHead stHeader;
    public ArrayList<TagInfo> vAddTags;
    public byte[] vBackground;
    public ArrayList<TagInfo> vDelTags;
    public byte[] vReqSetTemplate;
    public ArrayList<TagInfo> vTagsID;

    public ReqSetCard() {
        this.stHeader = null;
        this.eSubCmd = CARDSETTYPE.TYPE_SET_DEFAUT.value();
        this.bIsSingle = (byte) 0;
        this.vTagsID = null;
        this.vBackground = null;
        this.vDelTags = null;
        this.vAddTags = null;
        this.vReqSetTemplate = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stHeader == null) {
            cache_stHeader = new ReqHead();
        }
        this.stHeader = (ReqHead) jceInputStream.read((JceStruct) cache_stHeader, 0, true);
        this.eSubCmd = jceInputStream.read(this.eSubCmd, 1, true);
        this.bIsSingle = jceInputStream.read(this.bIsSingle, 2, false);
        if (cache_vTagsID == null) {
            cache_vTagsID = new ArrayList<>();
            cache_vTagsID.add(new TagInfo());
        }
        this.vTagsID = (ArrayList) jceInputStream.read((JceInputStream) cache_vTagsID, 3, false);
        if (cache_vBackground == null) {
            cache_vBackground = r0;
            byte[] bArr = {0};
        }
        this.vBackground = jceInputStream.read(cache_vBackground, 4, false);
        if (cache_vDelTags == null) {
            cache_vDelTags = new ArrayList<>();
            cache_vDelTags.add(new TagInfo());
        }
        this.vDelTags = (ArrayList) jceInputStream.read((JceInputStream) cache_vDelTags, 5, false);
        if (cache_vAddTags == null) {
            cache_vAddTags = new ArrayList<>();
            cache_vAddTags.add(new TagInfo());
        }
        this.vAddTags = (ArrayList) jceInputStream.read((JceInputStream) cache_vAddTags, 6, false);
        if (cache_vReqSetTemplate == null) {
            cache_vReqSetTemplate = r0;
            byte[] bArr2 = {0};
        }
        this.vReqSetTemplate = jceInputStream.read(cache_vReqSetTemplate, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stHeader, 0);
        jceOutputStream.write(this.eSubCmd, 1);
        jceOutputStream.write(this.bIsSingle, 2);
        ArrayList<TagInfo> arrayList = this.vTagsID;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
        byte[] bArr = this.vBackground;
        if (bArr != null) {
            jceOutputStream.write(bArr, 4);
        }
        ArrayList<TagInfo> arrayList2 = this.vDelTags;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 5);
        }
        ArrayList<TagInfo> arrayList3 = this.vAddTags;
        if (arrayList3 != null) {
            jceOutputStream.write((Collection) arrayList3, 6);
        }
        byte[] bArr2 = this.vReqSetTemplate;
        if (bArr2 != null) {
            jceOutputStream.write(bArr2, 7);
        }
    }

    public ReqSetCard(ReqHead reqHead, int i3, byte b16, ArrayList<TagInfo> arrayList, byte[] bArr, ArrayList<TagInfo> arrayList2, ArrayList<TagInfo> arrayList3, byte[] bArr2) {
        this.stHeader = null;
        CARDSETTYPE.TYPE_SET_DEFAUT.value();
        this.stHeader = reqHead;
        this.eSubCmd = i3;
        this.bIsSingle = b16;
        this.vTagsID = arrayList;
        this.vBackground = bArr;
        this.vDelTags = arrayList2;
        this.vAddTags = arrayList3;
        this.vReqSetTemplate = bArr2;
    }
}

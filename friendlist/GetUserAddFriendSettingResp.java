package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class GetUserAddFriendSettingResp extends JceStruct {
    static byte[] cache_name;
    static byte[] cache_name1;
    static int cache_queryuinsetting;
    static int cache_result;
    static ArrayList<String> cache_vecStrUserQuestion;
    public boolean contact_bothway_friend;
    public short errorCode;
    public byte[] name;
    public byte[] name1;
    public long queryuin;
    public int queryuinsetting;
    public int result;
    public long uin;
    public ArrayList<String> vecStrUserQuestion;

    public GetUserAddFriendSettingResp() {
        this.uin = 0L;
        this.queryuin = 0L;
        this.queryuinsetting = 0;
        this.vecStrUserQuestion = null;
        this.result = 0;
        this.errorCode = (short) 0;
        this.name = null;
        this.contact_bothway_friend = false;
        this.name1 = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.queryuin = jceInputStream.read(this.queryuin, 1, true);
        this.queryuinsetting = jceInputStream.read(this.queryuinsetting, 2, true);
        if (cache_vecStrUserQuestion == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            cache_vecStrUserQuestion = arrayList;
            arrayList.add("");
        }
        this.vecStrUserQuestion = (ArrayList) jceInputStream.read((JceInputStream) cache_vecStrUserQuestion, 3, false);
        this.result = jceInputStream.read(this.result, 4, true);
        this.errorCode = jceInputStream.read(this.errorCode, 5, false);
        if (cache_name == null) {
            cache_name = r0;
            byte[] bArr = {0};
        }
        this.name = jceInputStream.read(cache_name, 6, false);
        this.contact_bothway_friend = jceInputStream.read(this.contact_bothway_friend, 7, false);
        if (cache_name1 == null) {
            cache_name1 = r0;
            byte[] bArr2 = {0};
        }
        this.name1 = jceInputStream.read(cache_name1, 8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.queryuin, 1);
        jceOutputStream.write(this.queryuinsetting, 2);
        ArrayList<String> arrayList = this.vecStrUserQuestion;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
        jceOutputStream.write(this.result, 4);
        jceOutputStream.write(this.errorCode, 5);
        byte[] bArr = this.name;
        if (bArr != null) {
            jceOutputStream.write(bArr, 6);
        }
        jceOutputStream.write(this.contact_bothway_friend, 7);
        byte[] bArr2 = this.name1;
        if (bArr2 != null) {
            jceOutputStream.write(bArr2, 8);
        }
    }

    public GetUserAddFriendSettingResp(long j3, long j16, int i3, ArrayList<String> arrayList, int i16, short s16, byte[] bArr, boolean z16, byte[] bArr2) {
        this.uin = j3;
        this.queryuin = j16;
        this.queryuinsetting = i3;
        this.vecStrUserQuestion = arrayList;
        this.result = i16;
        this.errorCode = s16;
        this.name = bArr;
        this.contact_bothway_friend = z16;
        this.name1 = bArr2;
    }
}

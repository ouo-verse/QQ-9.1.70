package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class ProfFriendInfoRes extends JceStruct {
    static Map<Short, byte[]> cache_mFieldsInfo;
    static ArrayList<Short> cache_vUnGetFields;
    public byte cDataCode;
    public byte cResult;
    public Map<Short, byte[]> mFieldsInfo;
    public String sSigInfo;
    public long uFriendUin;
    public ArrayList<Short> vUnGetFields;
    public short wLevel;

    public ProfFriendInfoRes() {
        this.uFriendUin = 0L;
        this.cResult = (byte) 0;
        this.cDataCode = (byte) 0;
        this.mFieldsInfo = null;
        this.vUnGetFields = null;
        this.sSigInfo = "";
        this.wLevel = (short) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uFriendUin = jceInputStream.read(this.uFriendUin, 0, true);
        this.cResult = jceInputStream.read(this.cResult, 1, true);
        this.cDataCode = jceInputStream.read(this.cDataCode, 2, true);
        if (cache_mFieldsInfo == null) {
            cache_mFieldsInfo = new HashMap();
            cache_mFieldsInfo.put((short) 0, new byte[]{0});
        }
        this.mFieldsInfo = (Map) jceInputStream.read((JceInputStream) cache_mFieldsInfo, 3, true);
        if (cache_vUnGetFields == null) {
            cache_vUnGetFields = new ArrayList<>();
            cache_vUnGetFields.add((short) 0);
        }
        this.vUnGetFields = (ArrayList) jceInputStream.read((JceInputStream) cache_vUnGetFields, 4, true);
        this.sSigInfo = jceInputStream.readString(5, true);
        this.wLevel = jceInputStream.read(this.wLevel, 6, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uFriendUin, 0);
        jceOutputStream.write(this.cResult, 1);
        jceOutputStream.write(this.cDataCode, 2);
        jceOutputStream.write((Map) this.mFieldsInfo, 3);
        jceOutputStream.write((Collection) this.vUnGetFields, 4);
        jceOutputStream.write(this.sSigInfo, 5);
        jceOutputStream.write(this.wLevel, 6);
    }

    public ProfFriendInfoRes(long j3, byte b16, byte b17, Map<Short, byte[]> map, ArrayList<Short> arrayList, String str, short s16) {
        this.uFriendUin = j3;
        this.cResult = b16;
        this.cDataCode = b17;
        this.mFieldsInfo = map;
        this.vUnGetFields = arrayList;
        this.sSigInfo = str;
        this.wLevel = s16;
    }
}

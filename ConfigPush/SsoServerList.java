package ConfigPush;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SsoServerList extends JceStruct {
    static ArrayList<SsoServerListInfo> cache_v2G3GList;
    static ArrayList<SsoServerListInfo> cache_vHttp_2G3GList;
    static ArrayList<SsoServerListInfo> cache_vHttp_WifiList;
    static ArrayList<SsoServerListInfo> cache_vWifiList;
    public byte bTestSpeed;
    public byte bUseNewList;
    public int iMultiConn;
    public int iReconnect;
    public ArrayList<SsoServerListInfo> v2G3GList;
    public ArrayList<SsoServerListInfo> vHttp_2G3GList;
    public ArrayList<SsoServerListInfo> vHttp_WifiList;
    public ArrayList<SsoServerListInfo> vWifiList;

    public SsoServerList() {
        this.v2G3GList = null;
        this.vWifiList = null;
        this.iReconnect = 0;
        this.bTestSpeed = (byte) 0;
        this.bUseNewList = (byte) 0;
        this.iMultiConn = 1;
        this.vHttp_2G3GList = null;
        this.vHttp_WifiList = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_v2G3GList == null) {
            cache_v2G3GList = new ArrayList<>();
            cache_v2G3GList.add(new SsoServerListInfo());
        }
        this.v2G3GList = (ArrayList) jceInputStream.read((JceInputStream) cache_v2G3GList, 1, true);
        if (cache_vWifiList == null) {
            cache_vWifiList = new ArrayList<>();
            cache_vWifiList.add(new SsoServerListInfo());
        }
        this.vWifiList = (ArrayList) jceInputStream.read((JceInputStream) cache_vWifiList, 3, true);
        this.iReconnect = jceInputStream.read(this.iReconnect, 4, true);
        this.bTestSpeed = jceInputStream.read(this.bTestSpeed, 5, false);
        this.bUseNewList = jceInputStream.read(this.bUseNewList, 6, false);
        this.iMultiConn = jceInputStream.read(this.iMultiConn, 7, false);
        if (cache_vHttp_2G3GList == null) {
            cache_vHttp_2G3GList = new ArrayList<>();
            cache_vHttp_2G3GList.add(new SsoServerListInfo());
        }
        this.vHttp_2G3GList = (ArrayList) jceInputStream.read((JceInputStream) cache_vHttp_2G3GList, 8, false);
        if (cache_vHttp_WifiList == null) {
            cache_vHttp_WifiList = new ArrayList<>();
            cache_vHttp_WifiList.add(new SsoServerListInfo());
        }
        this.vHttp_WifiList = (ArrayList) jceInputStream.read((JceInputStream) cache_vHttp_WifiList, 9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.v2G3GList, 1);
        jceOutputStream.write((Collection) this.vWifiList, 3);
        jceOutputStream.write(this.iReconnect, 4);
        jceOutputStream.write(this.bTestSpeed, 5);
        jceOutputStream.write(this.bUseNewList, 6);
        jceOutputStream.write(this.iMultiConn, 7);
        ArrayList<SsoServerListInfo> arrayList = this.vHttp_2G3GList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 8);
        }
        ArrayList<SsoServerListInfo> arrayList2 = this.vHttp_WifiList;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 9);
        }
    }

    public SsoServerList(ArrayList<SsoServerListInfo> arrayList, ArrayList<SsoServerListInfo> arrayList2, int i3, byte b16, byte b17, int i16, ArrayList<SsoServerListInfo> arrayList3, ArrayList<SsoServerListInfo> arrayList4) {
        this.v2G3GList = arrayList;
        this.vWifiList = arrayList2;
        this.iReconnect = i3;
        this.bTestSpeed = b16;
        this.bUseNewList = b17;
        this.iMultiConn = i16;
        this.vHttp_2G3GList = arrayList3;
        this.vHttp_WifiList = arrayList4;
    }
}

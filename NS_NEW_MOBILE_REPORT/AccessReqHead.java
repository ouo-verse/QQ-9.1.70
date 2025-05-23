package NS_NEW_MOBILE_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AccessReqHead extends JceStruct {
    static ArrayList<String> cache_installPkgList;
    static ArrayList<String> cache_uninstallPkgList;
    public ArrayList<String> installPkgList;
    public IOSTerminal iosTerminal;
    public int loginType;
    public String opendId;
    public String phoneNum;
    public int platform;
    public String qua;
    public Terminal terminal;
    public TicketForQQ ticketForQQ;
    public long uin;
    public ArrayList<String> uninstallPkgList;
    public String uniqueId;
    static Terminal cache_terminal = new Terminal();
    static TicketForQQ cache_ticketForQQ = new TicketForQQ();
    static IOSTerminal cache_iosTerminal = new IOSTerminal();

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_installPkgList = arrayList;
        arrayList.add("");
        ArrayList<String> arrayList2 = new ArrayList<>();
        cache_uninstallPkgList = arrayList2;
        arrayList2.add("");
    }

    public AccessReqHead() {
        this.qua = "";
        this.uin = 0L;
        this.uniqueId = "";
        this.terminal = null;
        this.ticketForQQ = null;
        this.platform = 1;
        this.iosTerminal = null;
        this.loginType = 0;
        this.opendId = "";
        this.phoneNum = "";
        this.installPkgList = null;
        this.uninstallPkgList = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.qua = jceInputStream.readString(0, false);
        this.uin = jceInputStream.read(this.uin, 1, false);
        this.uniqueId = jceInputStream.readString(2, false);
        this.terminal = (Terminal) jceInputStream.read((JceStruct) cache_terminal, 3, false);
        this.ticketForQQ = (TicketForQQ) jceInputStream.read((JceStruct) cache_ticketForQQ, 4, false);
        this.platform = jceInputStream.read(this.platform, 5, false);
        this.iosTerminal = (IOSTerminal) jceInputStream.read((JceStruct) cache_iosTerminal, 6, false);
        this.loginType = jceInputStream.read(this.loginType, 7, false);
        this.opendId = jceInputStream.readString(8, false);
        this.phoneNum = jceInputStream.readString(9, false);
        this.installPkgList = (ArrayList) jceInputStream.read((JceInputStream) cache_installPkgList, 10, false);
        this.uninstallPkgList = (ArrayList) jceInputStream.read((JceInputStream) cache_uninstallPkgList, 11, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.qua;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.uin, 1);
        String str2 = this.uniqueId;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        Terminal terminal = this.terminal;
        if (terminal != null) {
            jceOutputStream.write((JceStruct) terminal, 3);
        }
        TicketForQQ ticketForQQ = this.ticketForQQ;
        if (ticketForQQ != null) {
            jceOutputStream.write((JceStruct) ticketForQQ, 4);
        }
        jceOutputStream.write(this.platform, 5);
        IOSTerminal iOSTerminal = this.iosTerminal;
        if (iOSTerminal != null) {
            jceOutputStream.write((JceStruct) iOSTerminal, 6);
        }
        jceOutputStream.write(this.loginType, 7);
        String str3 = this.opendId;
        if (str3 != null) {
            jceOutputStream.write(str3, 8);
        }
        String str4 = this.phoneNum;
        if (str4 != null) {
            jceOutputStream.write(str4, 9);
        }
        ArrayList<String> arrayList = this.installPkgList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 10);
        }
        ArrayList<String> arrayList2 = this.uninstallPkgList;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 11);
        }
    }

    public AccessReqHead(String str, long j3, String str2, Terminal terminal, TicketForQQ ticketForQQ, int i3, IOSTerminal iOSTerminal, int i16, String str3, String str4, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        this.qua = str;
        this.uin = j3;
        this.uniqueId = str2;
        this.terminal = terminal;
        this.ticketForQQ = ticketForQQ;
        this.platform = i3;
        this.iosTerminal = iOSTerminal;
        this.loginType = i16;
        this.opendId = str3;
        this.phoneNum = str4;
        this.installPkgList = arrayList;
        this.uninstallPkgList = arrayList2;
    }
}

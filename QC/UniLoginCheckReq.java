package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UniLoginCheckReq extends JceStruct {
    static GetUsrKeyWordInfoReq cache_stKeyWord;
    public ArrayList<Hamlet> stHamletList;
    public GetUsrKeyWordInfoReq stKeyWord;
    public LoginInfo stLogin;
    public long uAppidMask;
    static LoginInfo cache_stLogin = new LoginInfo();
    static ArrayList<Hamlet> cache_stHamletList = new ArrayList<>();

    static {
        cache_stHamletList.add(new Hamlet());
        cache_stKeyWord = new GetUsrKeyWordInfoReq();
    }

    public UniLoginCheckReq() {
        this.stLogin = null;
        this.stHamletList = null;
        this.uAppidMask = 0L;
        this.stKeyWord = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stLogin = (LoginInfo) jceInputStream.read((JceStruct) cache_stLogin, 0, false);
        this.stHamletList = (ArrayList) jceInputStream.read((JceInputStream) cache_stHamletList, 1, false);
        this.uAppidMask = jceInputStream.read(this.uAppidMask, 2, false);
        this.stKeyWord = (GetUsrKeyWordInfoReq) jceInputStream.read((JceStruct) cache_stKeyWord, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        LoginInfo loginInfo = this.stLogin;
        if (loginInfo != null) {
            jceOutputStream.write((JceStruct) loginInfo, 0);
        }
        ArrayList<Hamlet> arrayList = this.stHamletList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        jceOutputStream.write(this.uAppidMask, 2);
        GetUsrKeyWordInfoReq getUsrKeyWordInfoReq = this.stKeyWord;
        if (getUsrKeyWordInfoReq != null) {
            jceOutputStream.write((JceStruct) getUsrKeyWordInfoReq, 3);
        }
    }

    public UniLoginCheckReq(LoginInfo loginInfo, ArrayList<Hamlet> arrayList, long j3, GetUsrKeyWordInfoReq getUsrKeyWordInfoReq) {
        this.stLogin = loginInfo;
        this.stHamletList = arrayList;
        this.uAppidMask = j3;
        this.stKeyWord = getUsrKeyWordInfoReq;
    }
}

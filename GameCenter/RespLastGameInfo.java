package GameCenter;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RespLastGameInfo extends JceStruct {
    static ArrayList<GameLogoUrl> cache_stGameLogoInfo;
    public boolean bNative;
    public boolean bShowGameLogo;
    public byte iResult;
    public byte iVersion;
    public String sLogoUrl;
    public String sProfileUrl;
    public ArrayList<GameLogoUrl> stGameLogoInfo;

    public RespLastGameInfo() {
        this.iVersion = (byte) 1;
        this.iResult = (byte) 0;
        this.bShowGameLogo = true;
        this.bNative = true;
        this.sLogoUrl = "";
        this.stGameLogoInfo = null;
        this.sProfileUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iVersion = jceInputStream.read(this.iVersion, 0, true);
        this.iResult = jceInputStream.read(this.iResult, 1, true);
        this.bShowGameLogo = jceInputStream.read(this.bShowGameLogo, 2, true);
        this.bNative = jceInputStream.read(this.bNative, 3, true);
        this.sLogoUrl = jceInputStream.readString(4, true);
        if (cache_stGameLogoInfo == null) {
            cache_stGameLogoInfo = new ArrayList<>();
            cache_stGameLogoInfo.add(new GameLogoUrl());
        }
        this.stGameLogoInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_stGameLogoInfo, 5, true);
        this.sProfileUrl = jceInputStream.readString(6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iVersion, 0);
        jceOutputStream.write(this.iResult, 1);
        jceOutputStream.write(this.bShowGameLogo, 2);
        jceOutputStream.write(this.bNative, 3);
        jceOutputStream.write(this.sLogoUrl, 4);
        jceOutputStream.write((Collection) this.stGameLogoInfo, 5);
        String str = this.sProfileUrl;
        if (str != null) {
            jceOutputStream.write(str, 6);
        }
    }

    public RespLastGameInfo(byte b16, byte b17, boolean z16, boolean z17, String str, ArrayList<GameLogoUrl> arrayList, String str2) {
        this.iVersion = b16;
        this.iResult = b17;
        this.bShowGameLogo = z16;
        this.bNative = z17;
        this.sLogoUrl = str;
        this.stGameLogoInfo = arrayList;
        this.sProfileUrl = str2;
    }
}

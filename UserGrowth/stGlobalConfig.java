package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stGlobalConfig extends JceStruct {
    static stAioAction cache_aioAction;
    static stCallInfo cache_callinfo;
    static stCommentConfig cache_commentConfig;
    static downloadConfig cache_download;
    static stLinkConfig cache_linkConfig;
    static Map<String, String> cache_mapExt;
    static pendantConfig cache_pendant;
    static stPopWindowsConfig cache_red_dot_window;
    static stUserAuth cache_user_auth;
    public stAioAction aioAction;
    public int cache_size;
    public stCallInfo callinfo;
    public stCommentConfig commentConfig;
    public downloadConfig download;
    public String encrypted_deviceid;
    public boolean isHalfAppStoreScreen;
    public byte is_call_weishi;
    public byte is_direct_open;
    public stJumpInfo jumpinfo;
    public stLinkConfig linkConfig;
    public int link_strategy_type;
    public Map<String, String> mapExt;
    public int open_4g_autodownload;
    public pendantConfig pendant;
    public int playerType;
    public stPopWindowsConfig red_dot_window;
    public stUserAuth user_auth;
    public ArrayList<stPopWindowsConfig> windows_config;
    static stJumpInfo cache_jumpinfo = new stJumpInfo();
    static ArrayList<stPopWindowsConfig> cache_windows_config = new ArrayList<>();

    static {
        cache_windows_config.add(new stPopWindowsConfig());
        cache_pendant = new pendantConfig();
        cache_download = new downloadConfig();
        cache_linkConfig = new stLinkConfig();
        cache_red_dot_window = new stPopWindowsConfig();
        HashMap hashMap = new HashMap();
        cache_mapExt = hashMap;
        hashMap.put("", "");
        cache_callinfo = new stCallInfo();
        cache_user_auth = new stUserAuth();
        cache_commentConfig = new stCommentConfig();
        cache_aioAction = new stAioAction();
    }

    public stGlobalConfig() {
        this.jumpinfo = null;
        this.windows_config = null;
        this.is_call_weishi = (byte) 0;
        this.link_strategy_type = 0;
        this.open_4g_autodownload = 0;
        this.pendant = null;
        this.cache_size = 0;
        this.is_direct_open = (byte) 0;
        this.download = null;
        this.encrypted_deviceid = "";
        this.linkConfig = null;
        this.red_dot_window = null;
        this.isHalfAppStoreScreen = false;
        this.mapExt = null;
        this.callinfo = null;
        this.user_auth = null;
        this.commentConfig = null;
        this.aioAction = null;
        this.playerType = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.jumpinfo = (stJumpInfo) jceInputStream.read((JceStruct) cache_jumpinfo, 0, false);
        this.windows_config = (ArrayList) jceInputStream.read((JceInputStream) cache_windows_config, 1, false);
        this.is_call_weishi = jceInputStream.read(this.is_call_weishi, 2, false);
        this.link_strategy_type = jceInputStream.read(this.link_strategy_type, 3, false);
        this.open_4g_autodownload = jceInputStream.read(this.open_4g_autodownload, 4, false);
        this.pendant = (pendantConfig) jceInputStream.read((JceStruct) cache_pendant, 5, false);
        this.cache_size = jceInputStream.read(this.cache_size, 6, false);
        this.is_direct_open = jceInputStream.read(this.is_direct_open, 7, false);
        this.download = (downloadConfig) jceInputStream.read((JceStruct) cache_download, 8, false);
        this.encrypted_deviceid = jceInputStream.readString(9, false);
        this.linkConfig = (stLinkConfig) jceInputStream.read((JceStruct) cache_linkConfig, 10, false);
        this.red_dot_window = (stPopWindowsConfig) jceInputStream.read((JceStruct) cache_red_dot_window, 11, false);
        this.isHalfAppStoreScreen = jceInputStream.read(this.isHalfAppStoreScreen, 12, false);
        this.mapExt = (Map) jceInputStream.read((JceInputStream) cache_mapExt, 13, false);
        this.callinfo = (stCallInfo) jceInputStream.read((JceStruct) cache_callinfo, 14, false);
        this.user_auth = (stUserAuth) jceInputStream.read((JceStruct) cache_user_auth, 15, false);
        this.commentConfig = (stCommentConfig) jceInputStream.read((JceStruct) cache_commentConfig, 16, false);
        this.aioAction = (stAioAction) jceInputStream.read((JceStruct) cache_aioAction, 17, false);
        this.playerType = jceInputStream.read(this.playerType, 18, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        stJumpInfo stjumpinfo = this.jumpinfo;
        if (stjumpinfo != null) {
            jceOutputStream.write((JceStruct) stjumpinfo, 0);
        }
        ArrayList<stPopWindowsConfig> arrayList = this.windows_config;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        jceOutputStream.write(this.is_call_weishi, 2);
        jceOutputStream.write(this.link_strategy_type, 3);
        jceOutputStream.write(this.open_4g_autodownload, 4);
        pendantConfig pendantconfig = this.pendant;
        if (pendantconfig != null) {
            jceOutputStream.write((JceStruct) pendantconfig, 5);
        }
        jceOutputStream.write(this.cache_size, 6);
        jceOutputStream.write(this.is_direct_open, 7);
        downloadConfig downloadconfig = this.download;
        if (downloadconfig != null) {
            jceOutputStream.write((JceStruct) downloadconfig, 8);
        }
        String str = this.encrypted_deviceid;
        if (str != null) {
            jceOutputStream.write(str, 9);
        }
        stLinkConfig stlinkconfig = this.linkConfig;
        if (stlinkconfig != null) {
            jceOutputStream.write((JceStruct) stlinkconfig, 10);
        }
        stPopWindowsConfig stpopwindowsconfig = this.red_dot_window;
        if (stpopwindowsconfig != null) {
            jceOutputStream.write((JceStruct) stpopwindowsconfig, 11);
        }
        jceOutputStream.write(this.isHalfAppStoreScreen, 12);
        Map<String, String> map = this.mapExt;
        if (map != null) {
            jceOutputStream.write((Map) map, 13);
        }
        stCallInfo stcallinfo = this.callinfo;
        if (stcallinfo != null) {
            jceOutputStream.write((JceStruct) stcallinfo, 14);
        }
        stUserAuth stuserauth = this.user_auth;
        if (stuserauth != null) {
            jceOutputStream.write((JceStruct) stuserauth, 15);
        }
        stCommentConfig stcommentconfig = this.commentConfig;
        if (stcommentconfig != null) {
            jceOutputStream.write((JceStruct) stcommentconfig, 16);
        }
        stAioAction staioaction = this.aioAction;
        if (staioaction != null) {
            jceOutputStream.write((JceStruct) staioaction, 17);
        }
        jceOutputStream.write(this.playerType, 18);
    }

    public stGlobalConfig(stJumpInfo stjumpinfo, ArrayList<stPopWindowsConfig> arrayList, byte b16, int i3, int i16, pendantConfig pendantconfig, int i17, byte b17, downloadConfig downloadconfig, String str, stLinkConfig stlinkconfig, stPopWindowsConfig stpopwindowsconfig, boolean z16, Map<String, String> map, stCallInfo stcallinfo, stUserAuth stuserauth, stCommentConfig stcommentconfig, stAioAction staioaction, int i18) {
        this.jumpinfo = stjumpinfo;
        this.windows_config = arrayList;
        this.is_call_weishi = b16;
        this.link_strategy_type = i3;
        this.open_4g_autodownload = i16;
        this.pendant = pendantconfig;
        this.cache_size = i17;
        this.is_direct_open = b17;
        this.download = downloadconfig;
        this.encrypted_deviceid = str;
        this.linkConfig = stlinkconfig;
        this.red_dot_window = stpopwindowsconfig;
        this.isHalfAppStoreScreen = z16;
        this.mapExt = map;
        this.callinfo = stcallinfo;
        this.user_auth = stuserauth;
        this.commentConfig = stcommentconfig;
        this.aioAction = staioaction;
        this.playerType = i18;
    }
}

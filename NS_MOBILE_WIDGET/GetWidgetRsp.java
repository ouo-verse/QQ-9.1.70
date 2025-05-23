package NS_MOBILE_WIDGET;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetWidgetRsp extends JceStruct {
    static PartnerPlugin cache_partner_info = new PartnerPlugin();
    static PluginInfo cache_plugin_info = new PluginInfo();
    static byte[] cache_widget;
    public String attach_info;
    public int expire;
    public int iNameplateFlag;
    public int iNeedRedPacket;
    public int no_update;
    public PartnerPlugin partner_info;
    public PluginInfo plugin_info;
    public int stored_widget_id;
    public String tmp_data_json;
    public String tmp_url;
    public int today_delta;
    public byte[] widget;

    static {
        cache_widget = r0;
        byte[] bArr = {0};
    }

    public GetWidgetRsp() {
        this.widget = null;
        this.expire = 0;
        this.no_update = 0;
        this.attach_info = "";
        this.partner_info = null;
        this.stored_widget_id = 0;
        this.plugin_info = null;
        this.iNameplateFlag = 0;
        this.iNeedRedPacket = 0;
        this.tmp_url = "";
        this.tmp_data_json = "";
        this.today_delta = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.widget = jceInputStream.read(cache_widget, 0, false);
        this.expire = jceInputStream.read(this.expire, 1, false);
        this.no_update = jceInputStream.read(this.no_update, 2, false);
        this.attach_info = jceInputStream.readString(3, false);
        this.partner_info = (PartnerPlugin) jceInputStream.read((JceStruct) cache_partner_info, 4, false);
        this.stored_widget_id = jceInputStream.read(this.stored_widget_id, 5, false);
        this.plugin_info = (PluginInfo) jceInputStream.read((JceStruct) cache_plugin_info, 6, false);
        this.iNameplateFlag = jceInputStream.read(this.iNameplateFlag, 7, false);
        this.iNeedRedPacket = jceInputStream.read(this.iNeedRedPacket, 8, false);
        this.tmp_url = jceInputStream.readString(9, false);
        this.tmp_data_json = jceInputStream.readString(10, false);
        this.today_delta = jceInputStream.read(this.today_delta, 11, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        byte[] bArr = this.widget;
        if (bArr != null) {
            jceOutputStream.write(bArr, 0);
        }
        jceOutputStream.write(this.expire, 1);
        jceOutputStream.write(this.no_update, 2);
        String str = this.attach_info;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        PartnerPlugin partnerPlugin = this.partner_info;
        if (partnerPlugin != null) {
            jceOutputStream.write((JceStruct) partnerPlugin, 4);
        }
        jceOutputStream.write(this.stored_widget_id, 5);
        PluginInfo pluginInfo = this.plugin_info;
        if (pluginInfo != null) {
            jceOutputStream.write((JceStruct) pluginInfo, 6);
        }
        jceOutputStream.write(this.iNameplateFlag, 7);
        jceOutputStream.write(this.iNeedRedPacket, 8);
        String str2 = this.tmp_url;
        if (str2 != null) {
            jceOutputStream.write(str2, 9);
        }
        String str3 = this.tmp_data_json;
        if (str3 != null) {
            jceOutputStream.write(str3, 10);
        }
        jceOutputStream.write(this.today_delta, 11);
    }

    public GetWidgetRsp(byte[] bArr, int i3, int i16, String str, PartnerPlugin partnerPlugin, int i17, PluginInfo pluginInfo, int i18, int i19, String str2, String str3, int i26) {
        this.widget = bArr;
        this.expire = i3;
        this.no_update = i16;
        this.attach_info = str;
        this.partner_info = partnerPlugin;
        this.stored_widget_id = i17;
        this.plugin_info = pluginInfo;
        this.iNameplateFlag = i18;
        this.iNeedRedPacket = i19;
        this.tmp_url = str2;
        this.tmp_data_json = str3;
        this.today_delta = i26;
    }
}

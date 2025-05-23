package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stBusinessIconInfo extends JceStruct {
    static stBusinessAdCard cache_adCard;
    static Map<String, String> cache_mapExt;
    public stBusinessAdCard adCard;
    public stIconButton button;
    public int cardSwitch;
    public Map<String, String> mapExt;
    public stSchema schema;
    public int type;
    static stSchema cache_schema = new stSchema();
    static stIconButton cache_button = new stIconButton();

    static {
        HashMap hashMap = new HashMap();
        cache_mapExt = hashMap;
        hashMap.put("", "");
        cache_adCard = new stBusinessAdCard();
    }

    public stBusinessIconInfo() {
        this.schema = null;
        this.button = null;
        this.type = 0;
        this.mapExt = null;
        this.adCard = null;
        this.cardSwitch = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.schema = (stSchema) jceInputStream.read((JceStruct) cache_schema, 0, false);
        this.button = (stIconButton) jceInputStream.read((JceStruct) cache_button, 1, false);
        this.type = jceInputStream.read(this.type, 2, false);
        this.mapExt = (Map) jceInputStream.read((JceInputStream) cache_mapExt, 3, false);
        this.adCard = (stBusinessAdCard) jceInputStream.read((JceStruct) cache_adCard, 4, false);
        this.cardSwitch = jceInputStream.read(this.cardSwitch, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        stSchema stschema = this.schema;
        if (stschema != null) {
            jceOutputStream.write((JceStruct) stschema, 0);
        }
        stIconButton sticonbutton = this.button;
        if (sticonbutton != null) {
            jceOutputStream.write((JceStruct) sticonbutton, 1);
        }
        jceOutputStream.write(this.type, 2);
        Map<String, String> map = this.mapExt;
        if (map != null) {
            jceOutputStream.write((Map) map, 3);
        }
        stBusinessAdCard stbusinessadcard = this.adCard;
        if (stbusinessadcard != null) {
            jceOutputStream.write((JceStruct) stbusinessadcard, 4);
        }
        jceOutputStream.write(this.cardSwitch, 5);
    }

    public stBusinessIconInfo(stSchema stschema, stIconButton sticonbutton, int i3, Map<String, String> map, stBusinessAdCard stbusinessadcard, int i16) {
        this.schema = stschema;
        this.button = sticonbutton;
        this.type = i3;
        this.mapExt = map;
        this.adCard = stbusinessadcard;
        this.cardSwitch = i16;
    }
}

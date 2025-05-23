package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class stPersonExt extends JceStruct {
    public stSchema dingSchema;
    public stSchema editSchema;
    public stSchema fansSchema;
    public stSchema followSchema;
    public stSchema msgSchema;
    public stSchema settingSchema;
    static stSchema cache_dingSchema = new stSchema();
    static stSchema cache_followSchema = new stSchema();
    static stSchema cache_fansSchema = new stSchema();
    static stSchema cache_settingSchema = new stSchema();
    static stSchema cache_editSchema = new stSchema();
    static stSchema cache_msgSchema = new stSchema();

    public stPersonExt() {
        this.dingSchema = null;
        this.followSchema = null;
        this.fansSchema = null;
        this.settingSchema = null;
        this.editSchema = null;
        this.msgSchema = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.dingSchema = (stSchema) jceInputStream.read((JceStruct) cache_dingSchema, 0, false);
        this.followSchema = (stSchema) jceInputStream.read((JceStruct) cache_followSchema, 1, false);
        this.fansSchema = (stSchema) jceInputStream.read((JceStruct) cache_fansSchema, 2, false);
        this.settingSchema = (stSchema) jceInputStream.read((JceStruct) cache_settingSchema, 3, false);
        this.editSchema = (stSchema) jceInputStream.read((JceStruct) cache_editSchema, 4, false);
        this.msgSchema = (stSchema) jceInputStream.read((JceStruct) cache_msgSchema, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        stSchema stschema = this.dingSchema;
        if (stschema != null) {
            jceOutputStream.write((JceStruct) stschema, 0);
        }
        stSchema stschema2 = this.followSchema;
        if (stschema2 != null) {
            jceOutputStream.write((JceStruct) stschema2, 1);
        }
        stSchema stschema3 = this.fansSchema;
        if (stschema3 != null) {
            jceOutputStream.write((JceStruct) stschema3, 2);
        }
        stSchema stschema4 = this.settingSchema;
        if (stschema4 != null) {
            jceOutputStream.write((JceStruct) stschema4, 3);
        }
        stSchema stschema5 = this.editSchema;
        if (stschema5 != null) {
            jceOutputStream.write((JceStruct) stschema5, 4);
        }
        stSchema stschema6 = this.msgSchema;
        if (stschema6 != null) {
            jceOutputStream.write((JceStruct) stschema6, 5);
        }
    }

    public stPersonExt(stSchema stschema, stSchema stschema2, stSchema stschema3, stSchema stschema4, stSchema stschema5, stSchema stschema6) {
        this.dingSchema = stschema;
        this.followSchema = stschema2;
        this.fansSchema = stschema3;
        this.settingSchema = stschema4;
        this.editSchema = stschema5;
        this.msgSchema = stschema6;
    }
}

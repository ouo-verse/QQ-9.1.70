package com.tencent.mapsdk.core.components.protocol.jce.trafficevent;

import com.qq.taf.jce.MapJceStruct;
import com.tencent.mapsdk.internal.m;
import com.tencent.mapsdk.internal.n;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class Basic extends MapJceStruct {
    public float anchor_x;
    public float anchor_y;
    public String brief;
    public int confidence;
    public float coord_lat;
    public float coord_lon;
    public int end_time;
    public String eventid;
    public String icon_highlight;
    public String icon_normal;
    public int max_scale;
    public String message;
    public int min_scale;
    public String roadname;
    public String source;
    public int start_time;
    public int subtype;
    public int type;
    public int update_time;

    public Basic() {
        this.eventid = "";
        this.source = "";
        this.type = 0;
        this.subtype = 0;
        this.coord_lat = 0.0f;
        this.coord_lon = 0.0f;
        this.brief = "";
        this.message = "";
        this.confidence = 0;
        this.start_time = 0;
        this.end_time = 0;
        this.update_time = 0;
        this.roadname = "";
        this.icon_normal = "";
        this.icon_highlight = "";
        this.anchor_x = 0.0f;
        this.anchor_y = 0.0f;
        this.min_scale = 0;
        this.max_scale = 0;
    }

    @Override // com.tencent.mapsdk.internal.p
    public final void readFrom(m mVar) {
        this.eventid = mVar.b(0, true);
        this.source = mVar.b(1, true);
        this.type = mVar.a(this.type, 2, true);
        this.subtype = mVar.a(this.subtype, 3, false);
        this.coord_lat = mVar.a(this.coord_lat, 4, false);
        this.coord_lon = mVar.a(this.coord_lon, 5, false);
        this.brief = mVar.b(6, false);
        this.message = mVar.b(7, false);
        this.confidence = mVar.a(this.confidence, 8, true);
        this.start_time = mVar.a(this.start_time, 9, false);
        this.end_time = mVar.a(this.end_time, 10, false);
        this.update_time = mVar.a(this.update_time, 11, false);
        this.roadname = mVar.b(12, false);
        this.icon_normal = mVar.b(13, true);
        this.icon_highlight = mVar.b(14, true);
        this.anchor_x = mVar.a(this.anchor_x, 15, true);
        this.anchor_y = mVar.a(this.anchor_y, 16, true);
        this.min_scale = mVar.a(this.min_scale, 17, true);
        this.max_scale = mVar.a(this.max_scale, 18, true);
    }

    @Override // com.tencent.mapsdk.internal.p
    public final void writeTo(n nVar) {
        nVar.a(this.eventid, 0);
        nVar.a(this.source, 1);
        nVar.a(this.type, 2);
        nVar.a(this.subtype, 3);
        nVar.a(this.coord_lat, 4);
        nVar.a(this.coord_lon, 5);
        String str = this.brief;
        if (str != null) {
            nVar.a(str, 6);
        }
        String str2 = this.message;
        if (str2 != null) {
            nVar.a(str2, 7);
        }
        nVar.a(this.confidence, 8);
        nVar.a(this.start_time, 9);
        nVar.a(this.end_time, 10);
        nVar.a(this.update_time, 11);
        String str3 = this.roadname;
        if (str3 != null) {
            nVar.a(str3, 12);
        }
        nVar.a(this.icon_normal, 13);
        nVar.a(this.icon_highlight, 14);
        nVar.a(this.anchor_x, 15);
        nVar.a(this.anchor_y, 16);
        nVar.a(this.min_scale, 17);
        nVar.a(this.max_scale, 18);
    }

    public Basic(String str, String str2, int i3, int i16, float f16, float f17, String str3, String str4, int i17, int i18, int i19, int i26, String str5, String str6, String str7, float f18, float f19, int i27, int i28) {
        this.eventid = str;
        this.source = str2;
        this.type = i3;
        this.subtype = i16;
        this.coord_lat = f16;
        this.coord_lon = f17;
        this.brief = str3;
        this.message = str4;
        this.confidence = i17;
        this.start_time = i18;
        this.end_time = i19;
        this.update_time = i26;
        this.roadname = str5;
        this.icon_normal = str6;
        this.icon_highlight = str7;
        this.anchor_x = f18;
        this.anchor_y = f19;
        this.min_scale = i27;
        this.max_scale = i28;
    }
}

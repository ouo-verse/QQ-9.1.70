package com.tencent.mapsdk.internal;

import com.tencent.map.sdk.comps.offlinemap.OfflineItem;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.annotation.Json;
import com.tencent.mobileqq.videocodec.ffmpeg.Argument;
import java.io.File;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class cb extends JsonComposer {

    /* renamed from: a, reason: collision with root package name */
    @Json(ignore = true)
    public String f147996a;

    /* renamed from: b, reason: collision with root package name */
    @Json(name = "md5")
    public String f147997b;

    /* renamed from: c, reason: collision with root package name */
    @Json(name = "pinyin")
    public String f147998c;

    /* renamed from: d, reason: collision with root package name */
    @Json(name = "size")
    public int f147999d;

    /* renamed from: e, reason: collision with root package name */
    @Json(name = "ver")
    public int f148000e;

    private boolean a(OfflineItem offlineItem) {
        return offlineItem.getPinyin().equals(this.f147998c);
    }

    private String b() {
        return this.f147998c + ".zip";
    }

    private String c() {
        return this.f147996a + File.separator + this.f147998c + this.f148000e + ".zip";
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer("OfflineMapConfigCity{");
        stringBuffer.append("url='");
        stringBuffer.append(this.f147996a);
        stringBuffer.append('\'');
        stringBuffer.append(", md5='");
        stringBuffer.append(this.f147997b);
        stringBuffer.append('\'');
        stringBuffer.append(", pinyin='");
        stringBuffer.append(this.f147998c);
        stringBuffer.append('\'');
        stringBuffer.append(", size=");
        stringBuffer.append(this.f147999d);
        stringBuffer.append(", version=");
        stringBuffer.append(this.f148000e);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    private void b(mv mvVar) {
        if (mvVar != null) {
            mvVar.a(this.f147998c + "-md5", this.f147997b);
            mvVar.a(this.f147998c + Argument.VERSION, this.f148000e);
        }
    }

    public final String a() {
        return this.f147998c + ".dat";
    }

    private boolean a(mv mvVar) {
        if (mvVar == null) {
            return false;
        }
        String a16 = mvVar.a(this.f147998c + "-md5");
        if (this.f148000e == mvVar.b(this.f147998c + Argument.VERSION, -1)) {
            return (a16 == null || a16.equals(this.f147997b)) ? false : true;
        }
        return true;
    }
}

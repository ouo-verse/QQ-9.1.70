package com.qq.e.comm.plugin.base.ad;

import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.qq.e.comm.plugin.k.x;
import com.qq.e.comm.plugin.k.y;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private com.qq.e.comm.plugin.base.ad.model.c f38467a = new com.qq.e.comm.plugin.base.ad.model.c();

    /* renamed from: b, reason: collision with root package name */
    private View f38468b;

    private void c() {
        this.f38468b.setOnTouchListener(new View.OnTouchListener() { // from class: com.qq.e.comm.plugin.base.ad.c.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            c.this.f38467a.a(true);
                            return false;
                        }
                        return false;
                    }
                    c.this.f38467a.c(motionEvent.getX());
                    c.this.f38467a.d(motionEvent.getY());
                    c.this.f38467a.d(System.currentTimeMillis());
                    return false;
                }
                c.this.f38467a.m();
                c.this.f38467a.a(motionEvent.getX());
                c.this.f38467a.b(motionEvent.getY());
                c.this.f38467a.c(System.currentTimeMillis());
                return false;
            }
        });
    }

    public void b(long j3) {
        this.f38467a.b(j3);
    }

    public com.qq.e.comm.plugin.base.ad.model.c a() {
        return this.f38467a;
    }

    public String b() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        long j3 = -999;
        long l3 = (this.f38467a.l() <= 0 || this.f38467a.k() <= 0) ? -999L : this.f38467a.l() - this.f38467a.k();
        long j16 = (this.f38467a.j() <= 0 || this.f38467a.l() <= 0) ? -999L : this.f38467a.j() - this.f38467a.l();
        long j17 = (this.f38467a.j() <= 0 || this.f38467a.k() <= 0) ? -999L : this.f38467a.j() - this.f38467a.k();
        if (this.f38467a.j() > 0 && this.f38467a.i() > 0) {
            j3 = this.f38467a.j() - this.f38467a.i();
        }
        String str = this.f38467a.n() ? "1" : "0";
        jSONObject.put("g", String.valueOf(l3));
        jSONObject.put("sc", String.valueOf(j16));
        jSONObject.put("ec", String.valueOf(j17));
        jSONObject.put("aa", String.valueOf((int) this.f38467a.e()));
        jSONObject.put("ab", String.valueOf((int) this.f38467a.f()));
        jSONObject.put("ba", String.valueOf((int) this.f38467a.g()));
        jSONObject.put("bb", String.valueOf((int) this.f38467a.h()));
        jSONObject.put("d", "0");
        jSONObject.put("p", String.valueOf(j3));
        jSONObject.put("f", "0");
        jSONObject.put(HippyTKDListViewAdapter.X, str);
        if (!TextUtils.isEmpty(this.f38467a.c())) {
            jSONObject.put("sz", this.f38467a.c());
        }
        if (!TextUtils.isEmpty(this.f38467a.d())) {
            jSONObject.put("tid", this.f38467a.d());
        }
        if (this.f38467a.b() >= 0) {
            jSONObject.put("da", String.valueOf(this.f38467a.b()));
        }
        if (this.f38467a.a() >= 0) {
            jSONObject.put(TVKNetVideoInfo.AUDIO_TRACK_DOLBY, String.valueOf(this.f38467a.a()));
        }
        if (this.f38467a.o() >= 0) {
            y.a(jSONObject, "sh", String.valueOf(this.f38467a.o()));
        }
        if (this.f38467a.p() >= 0) {
            y.a(jSONObject, "sw", String.valueOf(this.f38467a.p()));
        }
        y.a(jSONObject, "px", this.f38467a.q());
        y.a(jSONObject, "py", this.f38467a.r());
        return new x(jSONObject).toString();
    }

    public void a(View view) {
        this.f38468b = view;
        c();
    }

    public void a(long j3) {
        this.f38467a.a(j3);
    }
}

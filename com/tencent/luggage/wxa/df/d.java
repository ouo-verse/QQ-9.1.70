package com.tencent.luggage.wxa.df;

import com.tencent.luggage.wxa.df.h;
import com.tencent.luggage.wxa.kj.v;
import com.tencent.luggage.wxa.ol.g0;
import com.tencent.luggage.wxa.ol.k;
import com.tencent.luggage.wxa.ol.l;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xd.p;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.plugins.InputJsPlugin;
import com.tencent.tuxmetersdk.export.config.TuxQuestionType;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d extends h {
    public static final int CTRL_INDEX = 110;
    public static final String NAME = "insertTextArea";

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements l.v {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f124207a;

        public a(l lVar) {
            this.f124207a = lVar;
        }

        @Override // com.tencent.luggage.wxa.ol.l.v
        public void a(int i3, int i16) {
            int inputId = this.f124207a.getInputId();
            v a16 = d.this.a(inputId);
            if (a16 != null && a16.isRunning()) {
                c cVar = new c(null);
                HashMap hashMap = new HashMap();
                hashMap.put("height", Integer.valueOf(com.tencent.luggage.wxa.tk.g.b(i16)));
                hashMap.put("lineCount", Integer.valueOf(i3));
                hashMap.put("inputId", Integer.valueOf(inputId));
                cVar.setContext(a16).setData(hashMap).dispatch();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends p {
        private static final int CTRL_INDEX = -2;
        private static final String NAME = "onTextAreaHeightChange";

        public c() {
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    @Override // com.tencent.luggage.wxa.df.h, com.tencent.luggage.wxa.xd.a
    /* renamed from: a */
    public void invoke(v vVar, JSONObject jSONObject, int i3) {
        super.invoke(vVar, jSONObject, i3);
    }

    @Override // com.tencent.luggage.wxa.df.h
    public boolean f() {
        return false;
    }

    @Override // com.tencent.luggage.wxa.df.h
    public boolean g() {
        return false;
    }

    @Override // com.tencent.luggage.wxa.df.h
    public boolean a(com.tencent.luggage.wxa.vl.f fVar, JSONObject jSONObject, v vVar, int i3) {
        if (!super.a(fVar, jSONObject, vVar, i3)) {
            return false;
        }
        fVar.f143683u = Boolean.TRUE;
        fVar.R = TuxQuestionType.QUESTION_TEXT_TEXTAREA;
        fVar.S = false;
        fVar.T = false;
        fVar.f143684v = Boolean.valueOf(jSONObject.optBoolean(MiniProgramLpReportDC04239.NORMAL_URL_DIALOG_CONFIRM, true));
        fVar.G = Boolean.valueOf(jSONObject.optBoolean("showCoverView", false));
        fVar.C = jSONObject.optString("adjustKeyboardTo", "cursor");
        return true;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b extends g0 {
        public final /* synthetic */ WeakReference P;
        public final /* synthetic */ int Q;
        public final /* synthetic */ String R;

        public b(WeakReference weakReference, int i3, String str) {
            this.P = weakReference;
            this.Q = i3;
            this.R = str;
        }

        public final void B() {
            v vVar = (v) this.P.get();
            if (vVar != null && vVar.D0() != null) {
                k.a().c(vVar);
            }
        }

        @Override // com.tencent.luggage.wxa.ol.l
        public void a(String str, int i3, boolean z16, boolean z17) {
            if (this.P.get() != null) {
                try {
                    String jSONObject = new JSONObject().put("value", com.tencent.luggage.wxa.uk.j.a(str)).put("inputId", getInputId()).put("cursor", i3).toString();
                    if (z16) {
                        ((v) this.P.get()).a(InputJsPlugin.ON_KEYBOARD_CONFIRM_CALLBACK, jSONObject);
                    }
                    if (!z17) {
                        ((v) this.P.get()).a(InputJsPlugin.ON_KEYBOARD_COMPLETE_CALLBACK, jSONObject);
                    }
                } catch (JSONException e16) {
                    w.b("MicroMsg.JsApiInsertTextArea", "dispatch input done, exp = %s", w0.a((Throwable) e16));
                }
                if (z17) {
                    return;
                }
                B();
            }
        }

        @Override // com.tencent.luggage.wxa.ol.l
        public void u() {
            if (this.P.get() != null) {
                int inputId = getInputId();
                HashMap hashMap = new HashMap(1);
                hashMap.put("inputId", Integer.valueOf(inputId));
                ((v) this.P.get()).a(this.Q, d.this.makeReturnJson(FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS, hashMap));
                d.this.a(inputId, this.R);
                d.this.a(inputId, (v) this.P.get());
            }
        }

        @Override // com.tencent.luggage.wxa.ol.l
        public void v() {
            if (this.P.get() != null) {
                ((v) this.P.get()).a(this.Q, d.this.makeReturnJson("fail"));
                B();
            }
        }

        @Override // com.tencent.luggage.wxa.ol.l
        public void a(String str) {
            v vVar = (v) this.P.get();
            if (vVar == null) {
                return;
            }
            try {
                int inputId = getInputId();
                h.g gVar = new h.g();
                gVar.setData(new JSONObject().put("value", com.tencent.luggage.wxa.uk.j.a(str)).put("data", d.this.b(inputId)).put("cursor", 0).put("inputId", inputId).put("keyCode", 8).toString());
                vVar.a(gVar, (int[]) null);
            } catch (Exception e16) {
                w.b("MicroMsg.JsApiInsertTextArea", "onBackspacePressedWhileValueNoChange, e = %s", e16);
            }
        }
    }

    @Override // com.tencent.luggage.wxa.df.h
    public void a(l lVar) {
        super.a(lVar);
        lVar.a(new a(lVar));
    }

    @Override // com.tencent.luggage.wxa.df.h
    public l a(WeakReference weakReference, String str, int i3) {
        return new b(weakReference, i3, str);
    }
}

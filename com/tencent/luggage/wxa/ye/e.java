package com.tencent.luggage.wxa.ye;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.luggage.wxa.gh.e;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xd.k0;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static int f145572a;

    /* renamed from: b, reason: collision with root package name */
    public static int f145573b;

    /* renamed from: c, reason: collision with root package name */
    public static long f145574c;

    /* renamed from: d, reason: collision with root package name */
    public static long f145575d;

    public static void a(com.tencent.luggage.wxa.xd.f fVar, View view, int i3, MotionEvent motionEvent, String str, boolean z16) {
        k0 cVar;
        int actionIndex = motionEvent.getActionIndex();
        int pointerId = motionEvent.getPointerId(actionIndex);
        float x16 = motionEvent.getX(actionIndex);
        float y16 = motionEvent.getY(actionIndex);
        int i16 = 0;
        if (f145572a == motionEvent.getAction() && f145573b == pointerId && f145574c == motionEvent.getEventTime() && f145575d == motionEvent.getDownTime()) {
            w.d("MicroMsg.InsertViewTouchEventDispatch", "action:%d, eventId:%d, eventTime:%d, downTime:%d, don't send Duplicate event", Integer.valueOf(motionEvent.getAction()), Integer.valueOf(pointerId), Long.valueOf(motionEvent.getEventTime()), Long.valueOf(motionEvent.getDownTime()));
            return;
        }
        f145572a = motionEvent.getAction();
        f145573b = pointerId;
        f145574c = motionEvent.getEventTime();
        f145575d = motionEvent.getDownTime();
        e.f fVar2 = new e.f();
        fVar2.a(pointerId, x16, y16);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("data", str);
            jSONObject.put("viewId", i3);
        } catch (JSONException unused) {
        }
        w.d("MicroMsg.InsertViewTouchEventDispatch", "action:%d, eventId:%d, eventTime:%d, downTime:%d", Integer.valueOf(motionEvent.getAction()), Integer.valueOf(pointerId), Long.valueOf(f145574c), Long.valueOf(f145575d));
        int action = motionEvent.getAction();
        if (action == 0) {
            try {
                jSONObject.put(WebRTCSDK.PRIVILEGE_TOUCH, fVar2.a());
            } catch (JSONException unused2) {
            }
            cVar = new e.c();
        } else if (action == 1) {
            try {
                jSONObject.put(WebRTCSDK.PRIVILEGE_TOUCH, fVar2.a());
            } catch (JSONException unused3) {
            }
            cVar = new e.C6244e();
        } else if (action == 2) {
            JSONArray jSONArray = new JSONArray();
            try {
                jSONObject.put("touches", jSONArray);
            } catch (JSONException unused4) {
            }
            e.f[] a16 = a(motionEvent);
            if (a16 != null && a16.length > 0) {
                while (i16 < a16.length) {
                    jSONArray.mo162put(a16[i16].a());
                    i16++;
                }
            }
            cVar = new e.d();
        } else if (action != 3) {
            cVar = null;
        } else {
            JSONArray jSONArray2 = new JSONArray();
            try {
                jSONObject.put("touches", jSONArray2);
            } catch (JSONException unused5) {
            }
            e.f[] a17 = a(motionEvent);
            if (a17 != null && a17.length > 0) {
                while (i16 < a17.length) {
                    jSONArray2.mo162put(a17[i16].a());
                    i16++;
                }
            }
            cVar = new e.b();
        }
        if (cVar != null && z16) {
            cVar.setData(jSONObject.toString());
            fVar.a(cVar);
        } else if (cVar != null) {
            cVar.setData(jSONObject.toString());
            fVar.a(cVar, (int[]) null);
        }
    }

    public static e.f[] a(MotionEvent motionEvent) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < motionEvent.getPointerCount(); i3++) {
            e.f fVar = new e.f();
            fVar.f126742a = motionEvent.getPointerId(i3);
            fVar.f126743b = motionEvent.getX(i3);
            fVar.f126744c = motionEvent.getY(i3);
            arrayList.add(fVar);
        }
        e.f[] fVarArr = new e.f[arrayList.size()];
        for (int i16 = 0; i16 < arrayList.size(); i16++) {
            fVarArr[i16] = (e.f) arrayList.get(i16);
        }
        return fVarArr;
    }
}

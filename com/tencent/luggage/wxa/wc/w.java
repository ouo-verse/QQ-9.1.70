package com.tencent.luggage.wxa.wc;

import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import com.tencent.pts.ui.vnode.PTSNodeTextBase;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes8.dex */
public class w implements d {
    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, JSONArray jSONArray) {
        if (jSONArray.length() < 1) {
            return false;
        }
        try {
            return a(dVar, jSONArray.getString(0));
        } catch (JSONException unused) {
            return false;
        }
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public String getMethod() {
        return CanvasView.ACTION_SETGLOBALCOMPOSITEOPERATION;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x01f1, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(com.tencent.luggage.wxa.vc.d dVar, String str) {
        char c16;
        com.tencent.luggage.wxa.ad.a d16 = dVar.d();
        switch (str.hashCode()) {
            case -2120744511:
                if (str.equals("luminosity")) {
                    c16 = 24;
                    break;
                }
                c16 = '\uffff';
                break;
            case -1763725041:
                if (str.equals("destination-out")) {
                    c16 = 6;
                    break;
                }
                c16 = '\uffff';
                break;
            case -1698458601:
                if (str.equals("source-in")) {
                    c16 = 1;
                    break;
                }
                c16 = '\uffff';
                break;
            case -1427739212:
                if (str.equals("hard-light")) {
                    c16 = 17;
                    break;
                }
                c16 = '\uffff';
                break;
            case -1338968417:
                if (str.equals("darken")) {
                    c16 = '\r';
                    break;
                }
                c16 = '\uffff';
                break;
            case -1247677005:
                if (str.equals("soft-light")) {
                    c16 = 18;
                    break;
                }
                c16 = '\uffff';
                break;
            case -1112602980:
                if (str.equals("source-out")) {
                    c16 = 2;
                    break;
                }
                c16 = '\uffff';
                break;
            case -1091287984:
                if (str.equals("overlay")) {
                    c16 = '\f';
                    break;
                }
                c16 = '\uffff';
                break;
            case -230491182:
                if (str.equals("saturation")) {
                    c16 = 22;
                    break;
                }
                c16 = '\uffff';
                break;
            case -131372090:
                if (str.equals("source-atop")) {
                    c16 = 3;
                    break;
                }
                c16 = '\uffff';
                break;
            case -130953402:
                if (str.equals("source-over")) {
                    c16 = 0;
                    break;
                }
                c16 = '\uffff';
                break;
            case -120580883:
                if (str.equals("color-dodge")) {
                    c16 = 15;
                    break;
                }
                c16 = '\uffff';
                break;
            case 103672:
                if (str.equals("hue")) {
                    c16 = 21;
                    break;
                }
                c16 = '\uffff';
                break;
            case 118875:
                if (str.equals("xor")) {
                    c16 = '\n';
                    break;
                }
                c16 = '\uffff';
                break;
            case 3059573:
                if (str.equals("copy")) {
                    c16 = '\t';
                    break;
                }
                c16 = '\uffff';
                break;
            case 94842723:
                if (str.equals("color")) {
                    c16 = 23;
                    break;
                }
                c16 = '\uffff';
                break;
            case 170546239:
                if (str.equals("lighten")) {
                    c16 = 14;
                    break;
                }
                c16 = '\uffff';
                break;
            case 170546243:
                if (str.equals(PTSNodeTextBase.WEIGHT_LIGHTER)) {
                    c16 = '\b';
                    break;
                }
                c16 = '\uffff';
                break;
            case 653829668:
                if (str.equals("multiply")) {
                    c16 = 11;
                    break;
                }
                c16 = '\uffff';
                break;
            case 912936772:
                if (str.equals("destination-in")) {
                    c16 = 5;
                    break;
                }
                c16 = '\uffff';
                break;
            case 1158680499:
                if (str.equals("destination-atop")) {
                    c16 = 7;
                    break;
                }
                c16 = '\uffff';
                break;
            case 1159099187:
                if (str.equals("destination-over")) {
                    c16 = 4;
                    break;
                }
                c16 = '\uffff';
                break;
            case 1242982905:
                if (str.equals("color-burn")) {
                    c16 = 16;
                    break;
                }
                c16 = '\uffff';
                break;
            case 1686617550:
                if (str.equals("exclusion")) {
                    c16 = 20;
                    break;
                }
                c16 = '\uffff';
                break;
            case 1728361789:
                if (str.equals("difference")) {
                    c16 = 19;
                    break;
                }
                c16 = '\uffff';
                break;
            default:
                c16 = '\uffff';
                break;
        }
        switch (c16) {
            case 0:
                d16.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
                break;
            case 1:
                d16.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
                break;
            case 2:
                d16.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
                break;
            case 3:
                d16.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
                break;
            case 4:
                d16.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
                break;
            case 5:
                d16.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
                break;
            case 6:
                d16.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
                break;
            case 7:
                d16.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
                break;
            case '\b':
                d16.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.LIGHTEN));
                break;
            case '\t':
                d16.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.ADD));
                break;
            case '\n':
                d16.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.XOR));
                break;
            case 11:
                d16.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
                break;
            case '\f':
                d16.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.OVERLAY));
                break;
            case '\r':
                d16.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DARKEN));
                break;
            case 14:
                d16.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.LIGHTEN));
                break;
        }
    }

    @Override // com.tencent.luggage.wxa.wc.d
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas, com.tencent.luggage.wxa.xc.c cVar) {
        com.tencent.luggage.wxa.xc.u uVar = (com.tencent.luggage.wxa.xc.u) com.tencent.luggage.wxa.tk.d.a(cVar);
        if (uVar == null) {
            return false;
        }
        return a(dVar, uVar.f144722b);
    }
}

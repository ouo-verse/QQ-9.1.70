package hr;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import hr.d;
import ir.g;
import ir.i;
import ir.j;
import ir.k;
import ir.m;
import ir.o;
import ir.p;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes38.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final Set<Integer> f406008a;

    /* renamed from: b, reason: collision with root package name */
    private static final Set<Integer> f406009b;

    static {
        HashSet hashSet = new HashSet(5);
        f406008a = hashSet;
        HashSet hashSet2 = new HashSet(5);
        f406009b = hashSet2;
        hashSet.add(4);
        hashSet.add(5);
        hashSet.add(9);
        hashSet.add(10);
        hashSet2.add(9);
        hashSet2.add(10);
    }

    public static int a(d.c cVar) {
        int i3 = 1;
        switch (cVar.f406025d) {
            case 1:
            case 2:
            default:
                i3 = 0;
                break;
            case 3:
                i3 = 4;
                break;
            case 4:
            case 7:
                break;
            case 5:
            case 9:
            case 10:
                i3 = 2;
                break;
            case 6:
                i3 = 33;
                break;
            case 8:
                i3 = 14;
                break;
            case 11:
                i3 = 3;
                break;
            case 12:
                i3 = 5;
                break;
        }
        if (QLog.isColorLevel()) {
            QLog.d("InformationFaceConstant", 2, "check num of download dir:" + i3);
        }
        return i3;
    }

    public static i b(Context context, String str) {
        JSONObject jSONObject;
        try {
            if (QLog.isColorLevel()) {
                QLog.e("InformationFaceConstant", 2, "to be parsed" + str);
            }
            jSONObject = new JSONObject(str);
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("InformationFaceConstant", 2, e16, new Object[0]);
            }
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        switch (jSONObject.optInt("type", 0)) {
            case 1:
                return new ir.d(context, str);
            case 2:
                return new m(context, str);
            case 3:
                return new k(context, str);
            case 4:
                return new j(context, str);
            case 5:
                return new ir.e(context, str);
            case 6:
                return new p(context, str);
            case 7:
                return new ir.c(context, str);
            case 8:
            default:
                return null;
            case 9:
                return new ir.f(context, str);
            case 10:
                return new o(context, str);
            case 11:
                return new ir.b(context, str);
            case 12:
                return new g(context, str);
        }
    }

    public static i c(d.c cVar, Context context, long j3) {
        int i3 = cVar.f406025d;
        switch (i3) {
            case 1:
                return new ir.d(context, ir.d.l(i3, com.tencent.aelight.camera.aioeditor.capture.util.d.d(j3), com.tencent.aelight.camera.aioeditor.capture.util.d.e(j3), com.tencent.aelight.camera.aioeditor.capture.util.d.f(j3)));
            case 2:
                return new m(context, m.m(i3, com.tencent.aelight.camera.aioeditor.capture.util.d.i(j3), com.tencent.aelight.camera.aioeditor.capture.util.d.j(j3)));
            case 3:
                String c16 = com.tencent.aelight.camera.aioeditor.capture.util.c.c(cVar);
                String[] b16 = com.tencent.aelight.camera.aioeditor.capture.util.d.b(j3);
                StringBuilder sb5 = new StringBuilder();
                sb5.append(c16);
                String str = File.separator;
                sb5.append(str);
                sb5.append("eea02a45.ttf");
                String sb6 = sb5.toString();
                String str2 = c16 + str + "outsideBorder.png";
                String str3 = c16 + str + "insideBorder.png";
                if (QLog.isColorLevel()) {
                    QLog.d("InformationFaceConstant", 2, "luar.ttf file name:" + sb6);
                }
                return new k(context, k.l(i3, b16[2], b16[3], b16[0], b16[1], sb6, str2, str3));
            case 4:
                String str4 = com.tencent.aelight.camera.aioeditor.capture.util.c.c(cVar) + File.separator + "Roboto-Condensed.ttf";
                String str5 = cVar.f406039r;
                if (TextUtils.isEmpty(str5)) {
                    str5 = HardCodeUtil.qqStr(R.string.y96);
                }
                return new j(context, j.l(i3, com.tencent.aelight.camera.aioeditor.capture.util.d.i(j3), str5, str4));
            case 5:
                String c17 = com.tencent.aelight.camera.aioeditor.capture.util.c.c(cVar);
                StringBuilder sb7 = new StringBuilder();
                sb7.append(c17);
                String str6 = File.separator;
                sb7.append(str6);
                sb7.append("Roboto-Condensed.ttf");
                String sb8 = sb7.toString();
                String str7 = c17 + str6 + "location_icon.png";
                String str8 = cVar.f406039r;
                if (TextUtils.isEmpty(str8)) {
                    str8 = HardCodeUtil.qqStr(R.string.y95);
                }
                return new ir.e(context, ir.e.l(i3, str8, com.tencent.aelight.camera.aioeditor.capture.util.d.h(j3), str7, sb8));
            case 6:
                String c18 = com.tencent.aelight.camera.aioeditor.capture.util.c.c(cVar);
                StringBuilder sb9 = new StringBuilder();
                sb9.append(c18);
                String str9 = File.separator;
                sb9.append(str9);
                sb9.append("DINCond-Medium.ttf");
                String sb10 = sb9.toString();
                String str10 = c18 + str9 + "temperatureSymbol.png";
                return new p(context, p.m(i3, cVar.f406036o, c18 + str9 + cVar.f406035n + ".apng", cVar.f406034m, str10, sb10, c18 + str9 + "line.png", cVar.f406037p == 3));
            case 7:
                return new ir.c(context, ir.c.l(i3, com.tencent.aelight.camera.aioeditor.capture.util.c.c(cVar) + File.separator + "city.bpng"));
            case 8:
            default:
                return null;
            case 9:
                String str11 = cVar.f406039r;
                if (TextUtils.isEmpty(str11)) {
                    str11 = "YOUR CITY";
                }
                return new ir.f(context, ir.f.l(i3, com.tencent.aelight.camera.aioeditor.capture.util.c.c(cVar) + File.separator + "location3_icon_3x.png", str11));
            case 10:
                String str12 = cVar.f406039r;
                StringBuilder sb11 = new StringBuilder();
                sb11.append(com.tencent.aelight.camera.aioeditor.capture.util.c.c(cVar));
                String str13 = File.separator;
                sb11.append(str13);
                sb11.append("location4_icon.png");
                return new o(context, o.l(i3, sb11.toString(), com.tencent.aelight.camera.aioeditor.capture.util.c.c(cVar) + str13 + "lantingzhonghei.ttf", str12));
            case 11:
                StringBuilder sb12 = new StringBuilder();
                sb12.append(com.tencent.aelight.camera.aioeditor.capture.util.c.c(cVar));
                String str14 = File.separator;
                sb12.append(str14);
                sb12.append("up.png");
                return new ir.b(context, ir.b.n(i3, sb12.toString(), com.tencent.aelight.camera.aioeditor.capture.util.c.c(cVar) + str14 + "down.png", com.tencent.aelight.camera.aioeditor.capture.util.d.k(j3), com.tencent.aelight.camera.aioeditor.capture.util.d.g(j3)));
            case 12:
                return new g(context, g.l(i3, com.tencent.aelight.camera.aioeditor.capture.util.d.c(j3)));
        }
    }

    public static boolean d(int i3) {
        return f406009b.contains(Integer.valueOf(i3));
    }

    public static boolean e(int i3) {
        return f406008a.contains(Integer.valueOf(i3));
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x0012. Please report as an issue. */
    public static i f(i iVar, Context context, String str) {
        i dVar;
        int i3 = iVar.i();
        if (i3 == 1) {
            dVar = new ir.d(context, ir.d.l(iVar.i(), com.tencent.aelight.camera.aioeditor.capture.util.d.d(-1L), com.tencent.aelight.camera.aioeditor.capture.util.d.e(-1L), com.tencent.aelight.camera.aioeditor.capture.util.d.f(-1L)));
        } else if (i3 == 2) {
            dVar = new m(context, m.m(iVar.i(), com.tencent.aelight.camera.aioeditor.capture.util.d.i(-1L), com.tencent.aelight.camera.aioeditor.capture.util.d.j(-1L)));
        } else if (i3 == 4) {
            j jVar = (j) iVar;
            dVar = new j(context, j.l(jVar.i(), jVar.m(), str, jVar.n()));
        } else if (i3 != 5) {
            switch (i3) {
                case 9:
                    ir.f fVar = (ir.f) iVar;
                    dVar = new ir.f(context, ir.f.l(fVar.i(), fVar.m(), str));
                    break;
                case 10:
                    o oVar = (o) iVar;
                    dVar = new o(context, o.l(oVar.i(), oVar.n(), oVar.m(), str));
                    break;
                case 11:
                    ir.b bVar = (ir.b) iVar;
                    dVar = new ir.b(context, ir.b.n(bVar.i(), bVar.p(), bVar.o(), com.tencent.aelight.camera.aioeditor.capture.util.d.k(-1L), com.tencent.aelight.camera.aioeditor.capture.util.d.g(-1L)));
                    break;
                case 12:
                    g gVar = (g) iVar;
                    dVar = new g(context, g.l(gVar.i(), gVar.m()));
                    break;
                default:
                    return null;
            }
        } else {
            ir.e eVar = (ir.e) iVar;
            dVar = new ir.e(context, ir.e.l(eVar.i(), str, com.tencent.aelight.camera.aioeditor.capture.util.d.h(-1L), eVar.o(), eVar.n()));
        }
        return dVar;
    }

    public static BitmapDrawable g(String str, Context context, String str2) {
        JSONObject jSONObject;
        i jVar;
        try {
            if (QLog.isColorLevel()) {
                QLog.e("InformationFaceConstant", 2, "to be parsed" + str);
            }
            jSONObject = new JSONObject(str);
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("InformationFaceConstant", 2, e16, new Object[0]);
            }
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        int optInt = jSONObject.optInt("type", 0);
        if (optInt == 4) {
            String[] k3 = new j(context, str).k(str);
            jVar = new j(context, j.l(optInt, k3[0], str2, k3[2]));
        } else if (optInt == 5) {
            String[] k16 = new ir.e(context, str).k(str);
            jVar = new ir.e(context, ir.e.l(optInt, str2, k16[1], k16[3], k16[2]));
        } else if (optInt == 9) {
            jVar = new ir.f(context, ir.f.l(optInt, new ir.f(context, str).k(str)[0], str2));
        } else if (optInt != 10) {
            jVar = optInt != 12 ? null : new g(context, g.l(optInt, new g(context, str).k(str)[1]));
        } else {
            String[] k17 = new o(context, str).k(str);
            jVar = new o(context, o.l(optInt, k17[0], k17[1], str2));
        }
        if (jVar != null) {
            return new BitmapDrawable(context.getResources(), jVar.h());
        }
        return null;
    }
}

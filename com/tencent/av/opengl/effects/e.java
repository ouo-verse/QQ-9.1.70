package com.tencent.av.opengl.effects;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.av.opengl.effects.c;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.config.BeautyRealConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes3.dex */
public class e extends d {

    /* renamed from: c, reason: collision with root package name */
    private boolean f73972c = true;

    @Override // com.tencent.av.opengl.effects.d
    public String d() {
        StringBuilder sb5 = new StringBuilder();
        ArrayList arrayList = new ArrayList(this.f73971b.keySet());
        Collections.sort(arrayList);
        sb5.append("VERSION");
        sb5.append(":");
        sb5.append(1);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            String str = (String) arrayList.get(i3);
            c.a aVar = this.f73971b.get(str);
            if (aVar != null && aVar.f73969e != aVar.f73967c) {
                sb5.append(",");
                sb5.append(str);
                sb5.append(":");
                sb5.append(aVar.f73969e);
            }
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("BeautyV5Config", 4, "getConfigStr, config[" + sb5.toString() + "]");
        }
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.av.opengl.effects.d
    public void e() {
        this.f73971b = new LinkedHashMap<>();
        if (AEFilterSupport.e() >= 7) {
            this.f73972c = false;
        }
        this.f73971b.clear();
        this.f73971b.put("BEAUTY_SKIN", new c.a(null, 1, 50, 0));
        if (this.f73972c) {
            this.f73971b.put("COLOR_TONE", new c.a(BeautyRealConfig.TYPE.COLOR_TONE, 2, 50, 50));
            this.f73971b.put("EYE_LIGHTEN", new c.a(BeautyRealConfig.TYPE.EYE_LIGHTEN, 2, 0, 0));
            this.f73971b.put("TOOTH_WHITEN", new c.a(BeautyRealConfig.TYPE.TOOTH_WHITEN, 2, 0, 0));
            this.f73971b.put("ENLARGE_EYE", new c.a(BeautyRealConfig.TYPE.EYE, 3, 0, 0));
            this.f73971b.put("MOUTH_SHAPE", new c.a(BeautyRealConfig.TYPE.MOUTH_SHAPE, 3, 50, 50));
            this.f73971b.put("CHIN", new c.a(BeautyRealConfig.TYPE.CHIN, 3, 50, 50));
            this.f73971b.put("FACE_THIN", new c.a(BeautyRealConfig.TYPE.FACE_THIN, 3, 0, 0));
            this.f73971b.put("FACE_V", new c.a(BeautyRealConfig.TYPE.FACE_V, 3, 0, 0));
            this.f73971b.put("FACE_SHAPE_4", new c.a(BeautyRealConfig.TYPE.BASIC4, 3, 0, 0));
            this.f73971b.put("FACE_SHORTEN", new c.a(BeautyRealConfig.TYPE.FACE_SHORTEN, 3, 0, 0));
            this.f73971b.put("NOSE_THIN", new c.a(BeautyRealConfig.TYPE.NOSE, 3, 0, 0));
            return;
        }
        this.f73971b.put("COLOR_TONE", new c.a(BeautyRealConfig.TYPE.COLOR_TONE, 2, 50, 50));
        this.f73971b.put("EYE_LIGHTEN", new c.a(BeautyRealConfig.TYPE.EYE_LIGHTEN, 2, 0, 0));
        this.f73971b.put("TOOTH_WHITEN", new c.a(BeautyRealConfig.TYPE.TOOTH_WHITEN, 2, 0, 0));
        this.f73971b.put("ENLARGE_EYE", new c.a(BeautyRealConfig.TYPE.EYE, 3, 0, 0));
        this.f73971b.put("MOUTH_SHAPE", new c.a(BeautyRealConfig.TYPE.MOUTH_SHAPE, 3, 50, 50));
        this.f73971b.put("CHIN", new c.a(BeautyRealConfig.TYPE.CHIN, 3, 50, 50));
        this.f73971b.put("FACE_THIN", new c.a(BeautyRealConfig.TYPE.FACE_THIN, 3, 0, 0));
        this.f73971b.put("FACE_V", new c.a(BeautyRealConfig.TYPE.FACE_V, 3, 0, 0));
        this.f73971b.put("FACE_SHAPE_4", new c.a(BeautyRealConfig.TYPE.BASIC4, 3, 40, 0));
        this.f73971b.put("FACE_SHORTEN", new c.a(BeautyRealConfig.TYPE.FACE_SHORTEN, 3, 0, 0));
        this.f73971b.put("NOSE_THIN", new c.a(BeautyRealConfig.TYPE.NOSE, 3, 0, 0));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.av.opengl.effects.d
    public void f() {
        SparseArray<String> sparseArray = new SparseArray<>();
        this.f73970a = sparseArray;
        sparseArray.put(BeautyRealConfig.TYPE.COLOR_TONE.value, "COLOR_TONE");
        this.f73970a.put(BeautyRealConfig.TYPE.EYE_LIGHTEN.value, "EYE_LIGHTEN");
        this.f73970a.put(BeautyRealConfig.TYPE.TOOTH_WHITEN.value, "TOOTH_WHITEN");
        this.f73970a.put(BeautyRealConfig.TYPE.EYE.value, "ENLARGE_EYE");
        this.f73970a.put(BeautyRealConfig.TYPE.MOUTH_SHAPE.value, "MOUTH_SHAPE");
        this.f73970a.put(BeautyRealConfig.TYPE.CHIN.value, "CHIN");
        this.f73970a.put(BeautyRealConfig.TYPE.FACE_THIN.value, "FACE_THIN");
        this.f73970a.put(BeautyRealConfig.TYPE.FACE_V.value, "FACE_V");
        this.f73970a.put(BeautyRealConfig.TYPE.BASIC4.value, "FACE_SHAPE_4");
        this.f73970a.put(BeautyRealConfig.TYPE.FACE_SHORTEN.value, "FACE_SHORTEN");
        this.f73970a.put(BeautyRealConfig.TYPE.NOSE.value, "NOSE_THIN");
    }

    @Override // com.tencent.av.opengl.effects.d
    public void g(String str) {
        if (str != null && str.length() != 0) {
            int i3 = -1;
            for (String str2 : str.split(",")) {
                if (str2 != null) {
                    String[] split = str2.split(":");
                    if (split.length == 2) {
                        try {
                            String str3 = split[0];
                            int parseInt = Integer.parseInt(split[1]);
                            if (TextUtils.equals(str3, "VERSION")) {
                                i3 = parseInt;
                            } else {
                                c.a aVar = this.f73971b.get(str3);
                                if (aVar != null) {
                                    aVar.f73969e = parseInt;
                                }
                            }
                        } catch (NumberFormatException e16) {
                            e16.printStackTrace();
                        }
                    }
                }
            }
            if (i3 < 1 && this.f73972c) {
                Iterator<Map.Entry<String, c.a>> it = this.f73971b.entrySet().iterator();
                boolean z16 = true;
                while (it.hasNext()) {
                    c.a value = it.next().getValue();
                    if (value != null && value.f73965a != 1 && value.f73966b != BeautyRealConfig.TYPE.BASIC4 && value.f73969e != value.f73967c) {
                        z16 = false;
                    }
                }
                if (z16 && b("FACE_SHAPE_4") != 40) {
                    z16 = false;
                }
                if (z16) {
                    h("FACE_SHAPE_4", 0);
                }
            }
            if (QLog.isDevelopLevel()) {
                QLog.i("BeautyV5Config", 4, "parseConfig, config[" + str + "]");
            }
        }
    }
}

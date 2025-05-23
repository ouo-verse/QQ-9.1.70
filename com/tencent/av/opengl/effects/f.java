package com.tencent.av.opengl.effects;

import android.util.SparseArray;
import com.tencent.av.opengl.effects.c;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.config.BeautyRealConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class f extends d {

    /* renamed from: c, reason: collision with root package name */
    public static final ArrayList<String> f73973c = new ArrayList<>(Arrays.asList("BEAUTY_SKIN", "FACE", "TEETH_WHITEN", "FACE_3D", "ROUGE", "MOUTH_LIPS", "POUCH", "NASOLABIAL", "CONTRAST", "BRIGHTEN", "FOREHEAD", "EYES_MAGNIFY", "MOUTH", "FACE_WIDTH", "FACE_V", "NOSE_SHRINK", "CHEEK_THIN"));

    private int i(String str) {
        return com.tencent.av.utils.af.d(com.tencent.luggage.wxa.uf.g.CTRL_INDEX, com.tencent.av.utils.af.f76962q).getInt("V7_" + str, -1);
    }

    @Override // com.tencent.av.opengl.effects.d
    public String d() {
        StringBuilder sb5 = new StringBuilder();
        ArrayList arrayList = new ArrayList(this.f73971b.keySet());
        Collections.sort(arrayList);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            String str = (String) arrayList.get(i3);
            c.a aVar = this.f73971b.get(str);
            if (aVar != null && aVar.f73969e != aVar.f73967c) {
                sb5.append(str);
                sb5.append(":");
                sb5.append(aVar.f73969e);
                sb5.append(",");
            }
        }
        if (sb5.toString().endsWith(",")) {
            sb5.deleteCharAt(sb5.length() - 1);
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("BeautyV7ConfigProcessor", 4, "getConfigStr, config[" + sb5.toString() + "]");
        }
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.av.opengl.effects.d
    public void e() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        int i36;
        int i37;
        int i38;
        int i39;
        int i46;
        LinkedHashMap<String, c.a> linkedHashMap = new LinkedHashMap<>();
        this.f73971b = linkedHashMap;
        BeautyRealConfig.TYPE type = BeautyRealConfig.TYPE.BEAUTY;
        if (i("BEAUTY_SKIN") != -1) {
            i3 = i("BEAUTY_SKIN");
        } else {
            i3 = 60;
        }
        linkedHashMap.put("BEAUTY_SKIN", new c.a(type, -1, i3, 0));
        LinkedHashMap<String, c.a> linkedHashMap2 = this.f73971b;
        BeautyRealConfig.TYPE type2 = BeautyRealConfig.TYPE.FACTOR_THIN_NEW;
        int i47 = 40;
        if (i("FACE") != -1) {
            i16 = i("FACE");
        } else {
            i16 = 40;
        }
        linkedHashMap2.put("FACE", new c.a(type2, -1, i16, 0));
        LinkedHashMap<String, c.a> linkedHashMap3 = this.f73971b;
        BeautyRealConfig.TYPE type3 = BeautyRealConfig.TYPE.TOOTH_WHITEN;
        int i48 = 20;
        if (i("TEETH_WHITEN") != -1) {
            i17 = i("TEETH_WHITEN");
        } else {
            i17 = 20;
        }
        linkedHashMap3.put("TEETH_WHITEN", new c.a(type3, -1, i17, 0));
        LinkedHashMap<String, c.a> linkedHashMap4 = this.f73971b;
        BeautyRealConfig.TYPE type4 = BeautyRealConfig.TYPE.FACE_FEATURE_SOFT;
        if (i("FACE_3D") != -1) {
            i47 = i("FACE_3D");
        }
        linkedHashMap4.put("FACE_3D", new c.a(type4, -1, i47, 0));
        LinkedHashMap<String, c.a> linkedHashMap5 = this.f73971b;
        BeautyRealConfig.TYPE type5 = BeautyRealConfig.TYPE.FACE_FEATURE_REDCHEEK;
        if (i("ROUGE") != -1) {
            i18 = i("ROUGE");
        } else {
            i18 = 20;
        }
        linkedHashMap5.put("ROUGE", new c.a(type5, -1, i18, 0));
        LinkedHashMap<String, c.a> linkedHashMap6 = this.f73971b;
        BeautyRealConfig.TYPE type6 = BeautyRealConfig.TYPE.FACE_FEATURE_LIPS_LUT_ALPHA;
        int i49 = 30;
        if (i("MOUTH_LIPS") != -1) {
            i19 = i("MOUTH_LIPS");
        } else {
            i19 = 30;
        }
        linkedHashMap6.put("MOUTH_LIPS", new c.a(type6, -1, i19, 0));
        LinkedHashMap<String, c.a> linkedHashMap7 = this.f73971b;
        BeautyRealConfig.TYPE type7 = BeautyRealConfig.TYPE.REMOVE_POUNCH;
        if (i("POUCH") != -1) {
            i26 = i("POUCH");
        } else {
            i26 = 50;
        }
        linkedHashMap7.put("POUCH", new c.a(type7, -1, i26, 0));
        LinkedHashMap<String, c.a> linkedHashMap8 = this.f73971b;
        BeautyRealConfig.TYPE type8 = BeautyRealConfig.TYPE.REMOVE_WRINKLES2;
        if (i("NASOLABIAL") != -1) {
            i27 = i("NASOLABIAL");
        } else {
            i27 = 30;
        }
        linkedHashMap8.put("NASOLABIAL", new c.a(type8, -1, i27, 0));
        LinkedHashMap<String, c.a> linkedHashMap9 = this.f73971b;
        BeautyRealConfig.TYPE type9 = BeautyRealConfig.TYPE.LUT_CLERA_ALPHA;
        if (i("CONTRAST") != -1) {
            i28 = i("CONTRAST");
        } else {
            i28 = 20;
        }
        linkedHashMap9.put("CONTRAST", new c.a(type9, -1, i28, 0));
        LinkedHashMap<String, c.a> linkedHashMap10 = this.f73971b;
        BeautyRealConfig.TYPE type10 = BeautyRealConfig.TYPE.LUT_FOUNDATION_ALPHA;
        if (i("BRIGHTEN") != -1) {
            i29 = i("BRIGHTEN");
        } else {
            i29 = 30;
        }
        linkedHashMap10.put("BRIGHTEN", new c.a(type10, -1, i29, 0));
        LinkedHashMap<String, c.a> linkedHashMap11 = this.f73971b;
        BeautyRealConfig.TYPE type11 = BeautyRealConfig.TYPE.FOREHEAD;
        if (i("FOREHEAD") != -1) {
            i36 = i("FOREHEAD");
        } else {
            i36 = 0;
        }
        linkedHashMap11.put("FOREHEAD", new c.a(type11, -1, i36, 0));
        LinkedHashMap<String, c.a> linkedHashMap12 = this.f73971b;
        BeautyRealConfig.TYPE type12 = BeautyRealConfig.TYPE.EYE;
        if (i("EYES_MAGNIFY") != -1) {
            i37 = i("EYES_MAGNIFY");
        } else {
            i37 = 30;
        }
        linkedHashMap12.put("EYES_MAGNIFY", new c.a(type12, -1, i37, 0));
        LinkedHashMap<String, c.a> linkedHashMap13 = this.f73971b;
        BeautyRealConfig.TYPE type13 = BeautyRealConfig.TYPE.MOUTH_SHAPE;
        if (i("MOUTH") != -1) {
            i38 = i("MOUTH");
        } else {
            i38 = 0;
        }
        linkedHashMap13.put("MOUTH", new c.a(type13, -1, i38, 0));
        LinkedHashMap<String, c.a> linkedHashMap14 = this.f73971b;
        BeautyRealConfig.TYPE type14 = BeautyRealConfig.TYPE.FACE_THIN;
        if (i("FACE_WIDTH") != -1) {
            i39 = i("FACE_WIDTH");
        } else {
            i39 = 0;
        }
        linkedHashMap14.put("FACE_WIDTH", new c.a(type14, -1, i39, 0));
        LinkedHashMap<String, c.a> linkedHashMap15 = this.f73971b;
        BeautyRealConfig.TYPE type15 = BeautyRealConfig.TYPE.FACTOR_SMALL_NEW;
        if (i("FACE_V") != -1) {
            i46 = i("FACE_V");
        } else {
            i46 = 0;
        }
        linkedHashMap15.put("FACE_V", new c.a(type15, -1, i46, 0));
        LinkedHashMap<String, c.a> linkedHashMap16 = this.f73971b;
        BeautyRealConfig.TYPE type16 = BeautyRealConfig.TYPE.NOSE;
        if (i("NOSE_SHRINK") != -1) {
            i49 = i("NOSE_SHRINK");
        }
        linkedHashMap16.put("NOSE_SHRINK", new c.a(type16, -1, i49, 0));
        LinkedHashMap<String, c.a> linkedHashMap17 = this.f73971b;
        BeautyRealConfig.TYPE type17 = BeautyRealConfig.TYPE.CHEEKBONE_THIN;
        if (i("CHEEK_THIN") != -1) {
            i48 = i("CHEEK_THIN");
        }
        linkedHashMap17.put("CHEEK_THIN", new c.a(type17, -1, i48, 0));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.av.opengl.effects.d
    public void f() {
        SparseArray<String> sparseArray = new SparseArray<>();
        this.f73970a = sparseArray;
        sparseArray.put(BeautyRealConfig.TYPE.BEAUTY.value, "BEAUTY_SKIN");
        this.f73970a.put(BeautyRealConfig.TYPE.FACTOR_THIN_NEW.value, "FACE");
        this.f73970a.put(BeautyRealConfig.TYPE.TOOTH_WHITEN.value, "TEETH_WHITEN");
        this.f73970a.put(BeautyRealConfig.TYPE.FACE_FEATURE_SOFT.value, "FACE_3D");
        this.f73970a.put(BeautyRealConfig.TYPE.FACE_FEATURE_REDCHEEK.value, "ROUGE");
        this.f73970a.put(BeautyRealConfig.TYPE.FACE_FEATURE_LIPS_LUT_ALPHA.value, "MOUTH_LIPS");
        this.f73970a.put(BeautyRealConfig.TYPE.REMOVE_POUNCH.value, "POUCH");
        this.f73970a.put(BeautyRealConfig.TYPE.REMOVE_WRINKLES2.value, "NASOLABIAL");
        this.f73970a.put(BeautyRealConfig.TYPE.LUT_CLERA_ALPHA.value, "CONTRAST");
        this.f73970a.put(BeautyRealConfig.TYPE.LUT_FOUNDATION_ALPHA.value, "BRIGHTEN");
        this.f73970a.put(BeautyRealConfig.TYPE.FOREHEAD.value, "FOREHEAD");
        this.f73970a.put(BeautyRealConfig.TYPE.EYE.value, "EYES_MAGNIFY");
        this.f73970a.put(BeautyRealConfig.TYPE.MOUTH_SHAPE.value, "MOUTH");
        this.f73970a.put(BeautyRealConfig.TYPE.FACE_THIN.value, "FACE_WIDTH");
        this.f73970a.put(BeautyRealConfig.TYPE.FACTOR_SMALL_NEW.value, "FACE_V");
        this.f73970a.put(BeautyRealConfig.TYPE.NOSE.value, "NOSE_SHRINK");
        this.f73970a.put(BeautyRealConfig.TYPE.CHEEKBONE_THIN.value, "CHEEK_THIN");
    }

    @Override // com.tencent.av.opengl.effects.d
    public void g(String str) {
        if (str != null && str.length() != 0) {
            for (String str2 : str.split(",")) {
                if (str2 != null) {
                    String[] split = str2.split(":");
                    if (split.length == 2) {
                        try {
                            String str3 = split[0];
                            int parseInt = Integer.parseInt(split[1]);
                            c.a aVar = this.f73971b.get(str3);
                            if (aVar != null) {
                                aVar.f73969e = parseInt;
                            }
                        } catch (NumberFormatException e16) {
                            e16.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}

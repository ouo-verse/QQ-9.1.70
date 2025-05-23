package com.tencent.aelight.camera.aioeditor.capture.paster;

import com.tencent.aelight.camera.aioeditor.capture.text.CaptureComboText;
import fr.f;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b {
    public static com.tencent.aelight.camera.aioeditor.capture.data.a a(String str) {
        return new com.tencent.aelight.camera.aioeditor.capture.music.a(Integer.valueOf(str).intValue());
    }

    public static com.tencent.aelight.camera.aioeditor.capture.data.a c(String str) {
        return new c(str);
    }

    public static com.tencent.aelight.camera.aioeditor.capture.data.a d(String str, List<String> list, float f16, float f17, float f18) {
        return new CaptureComboText(str, list, f16, f17, f18);
    }

    public static com.tencent.aelight.camera.aioeditor.capture.data.a b(String str, String str2, String str3, float f16, float f17, float f18) {
        hr.a q16 = ((PasterDataManager) f.c(4)).q(str2);
        if (q16 instanceof hr.f) {
            return new CaptureComboNormalPaster((hr.f) q16, str2, str3, f16, f17, f18);
        }
        if (q16 instanceof hr.e) {
            return new a((hr.e) q16, str2, str3, f16, f17, f18);
        }
        if (q16 instanceof hr.d) {
            return new CaptureComboInformationPaster((hr.d) q16, str, str2, str3, f16, f17, f18);
        }
        return null;
    }
}

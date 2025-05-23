package bo3;

import android.content.Context;
import android.text.TextPaint;
import com.tencent.now.app.misc.ui.UIUtil;
import zn3.e;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {
    public static e a(int i3, long j3, long j16, float f16, float f17) {
        e eVar = new e();
        eVar.f452818a = j3;
        eVar.f452819b = j16;
        if (j3 == 0 && j16 == 0) {
            eVar.f452820c = i3 * 0.5f;
        } else if (j3 > 0 && j16 == 0) {
            eVar.f452820c = i3 - f17;
        } else if (j3 == 0 && j16 > 0) {
            eVar.f452820c = f16;
        } else {
            float f18 = ((float) j3) * 1.0f;
            float f19 = (float) (j3 + j16);
            float f26 = f18 / f19;
            float f27 = (((float) j16) * 1.0f) / f19;
            float f28 = i3;
            float f29 = f26 * f28;
            eVar.f452820c = f29;
            float f36 = f27 * f28;
            eVar.f452821d = f36;
            if (f29 < f16) {
                eVar.f452820c = f16;
            }
            if (f36 < f17) {
                eVar.f452820c = f28 - f17;
            }
        }
        eVar.f452821d = i3 - eVar.f452820c;
        return eVar;
    }

    public static float b(Context context, int i3) {
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(UIUtil.b(context, i3));
        return textPaint.measureText("0");
    }
}

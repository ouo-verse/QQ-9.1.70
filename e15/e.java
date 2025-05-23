package e15;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.ditto.widget.DittoTextArea;

/* compiled from: P */
/* loaded from: classes28.dex */
public class e extends f {
    private float C;
    private float D;
    private int E;
    private float F;

    public e(String str, View view) {
        super(str, view);
    }

    private int u(String str) {
        if (!TextUtils.isEmpty(str)) {
            if ("center".equals(str)) {
                return 17;
            }
            if ("left".equals(str) || !"right".equals(str)) {
                return 3;
            }
            return 5;
        }
        throw new RuntimeException(getClass().getName() + " setGravity value can not be null");
    }

    private void v(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ((TextView) this.f395367e).setTextColor(Color.parseColor(str));
    }

    private void w(String str) {
        try {
            ((TextView) this.f395367e).setTextSize(0, e(str));
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e15.f
    public void m() {
        super.m();
        ((TextView) this.f395367e).setShadowLayer(this.F, this.C, this.D, this.E);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e15.f
    public void q(String str, String str2) {
        super.q(str, str2);
        if (!(this.f395367e instanceof TextView)) {
            return;
        }
        if ("content".equals(str)) {
            ((TextView) this.f395367e).setText(str2);
            return;
        }
        if ("text_color".equals(str)) {
            v(str2);
            return;
        }
        if ("text_align".equals(str)) {
            ((TextView) this.f395367e).setGravity(u(str2));
            return;
        }
        if ("max_lines".equals(str)) {
            ((TextView) this.f395367e).setMaxLines(Integer.parseInt(str2));
            return;
        }
        if ("shadow_color".equals(str)) {
            this.E = Color.parseColor(str2);
            return;
        }
        if ("shadow_x".equals(str)) {
            this.C = Float.parseFloat(str2);
            return;
        }
        if ("shadow_y".equals(str)) {
            this.D = Float.parseFloat(str2);
        } else if (DittoTextArea.SHADOW_RADIUS.equals(str)) {
            this.F = Float.parseFloat(str2);
        } else if ("text_size".equals(str)) {
            w(str2);
        }
    }
}

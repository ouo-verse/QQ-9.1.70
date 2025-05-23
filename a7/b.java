package a7;

import android.graphics.Color;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.tencent.ditto.widget.DittoTextArea;
import cooperation.qzone.util.QZLog;
import e15.f;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b extends f {
    private float C;
    private float D;
    private int E;
    private float F;
    private String G;
    private CellTextView H;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f25617a;

        /* renamed from: b, reason: collision with root package name */
        public String f25618b;

        /* renamed from: c, reason: collision with root package name */
        public int f25619c;

        public static a b(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                a aVar = new a();
                JSONObject jSONObject = new JSONObject(str);
                aVar.f25617a = jSONObject.optInt("id");
                aVar.f25619c = jSONObject.optInt("type");
                aVar.f25618b = jSONObject.optString("url");
                return aVar;
            } catch (JSONException e16) {
                e16.printStackTrace();
                return null;
            }
        }

        public boolean a() {
            return (this.f25617a == 0 || TextUtils.isEmpty(this.f25618b)) ? false : true;
        }
    }

    public b(String str, View view) {
        super(str, view);
        if (view != null) {
            try {
                if (view instanceof ViewGroup) {
                    this.H = (CellTextView) ((ViewGroup) view).getChildAt(0);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    private int u(String str) {
        if (!TextUtils.isEmpty(str)) {
            if ("center".equals(str)) {
                return 17;
            }
            return (!"left".equals(str) && "right".equals(str)) ? 5 : 3;
        }
        throw new RuntimeException(getClass().getName() + " setGravity value can not be null");
    }

    private int v(String str) {
        Rect rect = new Rect();
        this.H.getPaint().getTextBounds(str, 0, str.length(), rect);
        rect.height();
        return rect.width();
    }

    private void w(String str) {
        a b16 = a.b(str);
        if (b16 == null || !b16.a()) {
            return;
        }
        this.H.setFont(b16.f25617a, b16.f25618b, b16.f25619c);
    }

    private void x(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.H.setTextColor(Color.parseColor(str));
    }

    private void y(String str) {
        try {
            this.H.setTextSize(0, e(str));
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e15.f
    public void m() {
        super.m();
        CellTextView cellTextView = this.H;
        if (cellTextView == null) {
            return;
        }
        cellTextView.setRichText(this.G);
        this.H.setShadowLayer((int) this.F, (int) this.C, (int) this.D, this.E);
    }

    @Override // e15.f
    public void p() {
        ViewGroup.LayoutParams layoutParams;
        super.p();
        if (this.f395367e.getParent() != null && (this.f395367e.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.f395367e.getParent()).setClipChildren(false);
        }
        CellTextView cellTextView = this.H;
        if (cellTextView == null || (layoutParams = cellTextView.getLayoutParams()) == null) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < 140; i3++) {
            sb5.append(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS);
        }
        if (QZLog.isColorLevel()) {
            QZLog.i("JsonInflateViewModel", 2, " cell text view width " + v(this.G) + " string = " + this.G + " build 140 = " + v(sb5.toString()));
        }
        layoutParams.width = v(sb5.toString());
        this.H.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e15.f
    public void q(String str, String str2) {
        super.q(str, str2);
        if (this.H == null) {
            return;
        }
        if ("content".equals(str)) {
            this.G = str2;
            return;
        }
        if ("text_color".equals(str)) {
            x(str2);
            return;
        }
        if ("text_align".equals(str)) {
            ((CellTextView) this.f395367e).setTextGravity(u(str2));
            return;
        }
        if ("max_lines".equals(str)) {
            this.H.setMaxLine(Integer.parseInt(str2));
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
            return;
        }
        if (DittoTextArea.SHADOW_RADIUS.equals(str)) {
            this.F = Float.parseFloat(str2);
        } else if ("text_size".equals(str)) {
            y(str2);
        } else if ("font".equals(str)) {
            w(str2);
        }
    }
}

package e15;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
/* loaded from: classes28.dex */
public class f implements Handler.Callback {

    /* renamed from: d, reason: collision with root package name */
    protected String f395366d;

    /* renamed from: e, reason: collision with root package name */
    protected View f395367e;

    /* renamed from: f, reason: collision with root package name */
    protected Handler f395368f;

    /* renamed from: h, reason: collision with root package name */
    protected int f395369h;

    /* renamed from: i, reason: collision with root package name */
    protected int f395370i;

    /* renamed from: m, reason: collision with root package name */
    private ArrayList<f> f395371m;

    public f(View view) {
        this.f395367e = view;
        this.f395368f = new Handler(Looper.getMainLooper(), this);
        this.f395371m = new ArrayList<>();
    }

    private int f(String str) {
        if (TextUtils.isEmpty(str)) {
            return -2;
        }
        try {
            if (CanvasView.CUSTOM_ACTION_FILL.equals(str)) {
                return -1;
            }
            if ("fit".equals(str)) {
                return -2;
            }
            return e(str);
        } catch (Exception e16) {
            e16.printStackTrace();
            return -2;
        }
    }

    private void t(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Drawable d16 = d(str);
        if (d16 != null) {
            this.f395367e.setBackgroundDrawable(d16);
            return;
        }
        throw new RuntimeException(getClass().getName() + " set background drawable = null not match value = " + str);
    }

    public void a(f fVar) {
        if (fVar == null) {
            return;
        }
        if (this.f395371m == null) {
            this.f395371m = new ArrayList<>();
        }
        this.f395371m.add(fVar);
    }

    protected ViewGroup.LayoutParams b(int i3, int i16) {
        return new ViewGroup.LayoutParams(i3, i16);
    }

    public ViewGroup.LayoutParams c(JSONObject jSONObject, f fVar) {
        if (this.f395367e != null && jSONObject != null && jSONObject.length() != 0) {
            String optString = jSONObject.optString("width");
            String optString2 = jSONObject.optString("height");
            this.f395369h = f(optString);
            this.f395370i = f(optString2);
            if (QLog.isColorLevel()) {
                QLog.i("JsonInflateViewModel", 2, "class = " + this.f395367e.getClass().getSimpleName() + " width = " + this.f395369h + " height = " + this.f395370i);
            }
            ViewGroup.LayoutParams b16 = b(this.f395369h, this.f395370i);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                s(str, jSONObject.optString(str), b16);
            }
            fVar.k(b16, jSONObject);
            return b16;
        }
        return null;
    }

    protected Drawable d(String str) {
        if (str.startsWith("#")) {
            return new ColorDrawable(Color.parseColor(str));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int e(String str) {
        int parseInt;
        int h16;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            if (str.endsWith("w")) {
                parseInt = Integer.parseInt(str.substring(0, str.indexOf("w")));
                h16 = h();
            } else if (str.endsWith(h.F)) {
                parseInt = Integer.parseInt(str.substring(0, str.indexOf(h.F)));
                h16 = g();
            } else {
                parseInt = Integer.parseInt(str);
                h16 = h();
            }
            return (parseInt * h16) / 10000;
        } catch (Exception e16) {
            e16.printStackTrace();
            QLog.e("JsonInflateViewModel", 1, "getIntegerValue exception: value =  " + str);
            return 0;
        }
    }

    protected int g() {
        return ViewUtils.getScreenHeight();
    }

    protected int h() {
        return ViewUtils.getScreenWidth();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        return false;
    }

    public View i() {
        return this.f395367e;
    }

    public f j(String str) {
        ArrayList<f> arrayList;
        f next;
        f fVar = null;
        if (!TextUtils.isEmpty(this.f395366d) && (arrayList = this.f395371m) != null) {
            if (arrayList.size() == 0) {
                if (!this.f395366d.equals(str)) {
                    return null;
                }
                return this;
            }
            Iterator<f> it = this.f395371m.iterator();
            while (it.hasNext() && ((next = it.next()) == null || (fVar = next.j(str)) == null)) {
            }
        }
        return fVar;
    }

    public void l() {
        Iterator<f> it = this.f395371m.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (next != null) {
                next.l();
            }
        }
    }

    public void n() {
        Iterator<f> it = this.f395371m.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (next != null) {
                next.n();
            }
        }
    }

    public void o() {
        Iterator<f> it = this.f395371m.iterator();
        while (it.hasNext()) {
            f next = it.next();
            if (next != null) {
                next.o();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if ("background_color".equals(str)) {
            t(str2);
            return;
        }
        if (CanvasView.ACTION_ROTATE.equals(str)) {
            this.f395367e.setPivotX(0.0f);
            this.f395367e.setPivotY(0.0f);
            this.f395367e.setRotation(Float.parseFloat(str2));
        } else {
            if ("id".equals(str)) {
                this.f395367e.setId(Integer.parseInt(str2));
                return;
            }
            QLog.e("JsonInflateViewModel", 1, this.f395366d + " illegal attr :" + str + " = " + str2);
        }
    }

    public void r(JSONObject jSONObject) {
        if (this.f395367e != null && jSONObject != null && jSONObject.length() != 0) {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                q(str, jSONObject.optString(str));
            }
            m();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s(String str, String str2, ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            if (HippyTKDListViewAdapter.X.equals(str)) {
                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = e(str2);
            } else if ("y".equals(str)) {
                ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = e(str2);
            }
        }
    }

    public f(String str, View view) {
        this(view);
        this.f395366d = str;
    }

    public f() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m() {
    }

    public void p() {
    }

    protected ViewGroup.LayoutParams k(ViewGroup.LayoutParams layoutParams, JSONObject jSONObject) {
        return layoutParams;
    }
}

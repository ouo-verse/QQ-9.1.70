package com.tencent.aelight.camera.aioeditor.capture.text;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.InputFilter;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class DynamicTextItem {

    /* renamed from: o, reason: collision with root package name */
    private static final String f66887o = "DynamicTextItem";

    /* renamed from: a, reason: collision with root package name */
    private int f66888a;

    /* renamed from: b, reason: collision with root package name */
    protected int f66889b;

    /* renamed from: c, reason: collision with root package name */
    protected boolean f66890c;

    /* renamed from: e, reason: collision with root package name */
    private TextMap f66892e;

    /* renamed from: k, reason: collision with root package name */
    StaticLayout f66898k;

    /* renamed from: l, reason: collision with root package name */
    private Paint f66899l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f66900m;

    /* renamed from: d, reason: collision with root package name */
    public Stack<Integer> f66891d = new Stack<>();

    /* renamed from: f, reason: collision with root package name */
    private boolean f66893f = false;

    /* renamed from: g, reason: collision with root package name */
    private int f66894g = 0;

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f66895h = false;

    /* renamed from: i, reason: collision with root package name */
    private volatile boolean f66896i = false;

    /* renamed from: j, reason: collision with root package name */
    private Handler f66897j = null;

    /* renamed from: n, reason: collision with root package name */
    private volatile a<Integer, Boolean> f66901n = new a<>(-1, Boolean.FALSE);

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class a<F, S> {

        /* renamed from: a, reason: collision with root package name */
        public F f66907a;

        /* renamed from: b, reason: collision with root package name */
        public S f66908b;

        public a(F f16, S s16) {
            this.f66907a = f16;
            this.f66908b = s16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface b {
        String a(int i3, String str);
    }

    public DynamicTextItem(int i3, List<String> list) {
        this.f66888a = i3;
        this.f66892e = new TextMap(list);
        Paint paint = new Paint();
        this.f66899l = paint;
        paint.setAntiAlias(true);
        this.f66899l.setColor(Color.parseColor("#12b7f5"));
        this.f66899l.setStyle(Paint.Style.STROKE);
        this.f66899l.setStrokeWidth(2.0f);
        this.f66899l.setPathEffect(new DashPathEffect(new float[]{6.0f, 7.0f}, 1.0f));
    }

    public boolean A() {
        return this.f66896i;
    }

    public boolean B(int i3) {
        return p(i3).equals(DynamicTextBuilder.d(this.f66888a, i3));
    }

    public boolean C() {
        ArrayList<String> s16 = s();
        List<String> e16 = DynamicTextBuilder.e(this.f66888a);
        if (e16 == null || s16.size() < e16.size()) {
            return false;
        }
        for (int i3 = 0; i3 < e16.size(); i3++) {
            String str = e16.get(i3);
            if (str == null) {
                if (s16.get(i3) != null) {
                    return false;
                }
            } else if (!str.equals(s16.get(i3))) {
                return false;
            }
        }
        return true;
    }

    public boolean D() {
        return this.f66892e.c(0, o());
    }

    public boolean E() {
        return this.f66893f;
    }

    public abstract boolean F();

    public final boolean G() {
        return o() > 1;
    }

    public boolean H(int i3) {
        if (this.f66901n.f66907a.intValue() == i3 || this.f66901n.f66907a.intValue() == -1) {
            return this.f66901n.f66908b.booleanValue();
        }
        return false;
    }

    protected abstract void I(Canvas canvas);

    public void K(int i3) {
        this.f66899l.setColor(i3);
    }

    public void L(boolean z16) {
        this.f66893f = z16;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [F, java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r3v1, types: [S, java.lang.Boolean] */
    public void O(int i3, boolean z16) {
        P();
        this.f66901n.f66907a = Integer.valueOf(i3);
        this.f66901n.f66908b = Boolean.valueOf(z16);
    }

    public void P() {
        Handler handler = this.f66897j;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.f66895h = false;
    }

    public void c(int i3) {
        if (G()) {
            if (i3 < 0) {
                i3 = 0;
            }
            this.f66894g = i3;
            return;
        }
        this.f66894g = 0;
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [F, java.lang.Integer] */
    public void d(int i3, final View view, final boolean z16, int i16, int i17, final Runnable runnable) {
        if (this.f66895h || !F()) {
            return;
        }
        this.f66895h = true;
        this.f66896i = true;
        Handler handler = this.f66897j;
        if (handler == null) {
            this.f66897j = new Handler(Looper.getMainLooper());
        } else {
            handler.removeCallbacksAndMessages(null);
        }
        this.f66901n.f66907a = Integer.valueOf(i3);
        int i18 = 0;
        while (i18 < i16 - i17) {
            this.f66897j.postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem.1
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r1v6, types: [S, java.lang.Boolean] */
                @Override // java.lang.Runnable
                public void run() {
                    DynamicTextItem.this.f66901n.f66908b = Boolean.valueOf(!((Boolean) DynamicTextItem.this.f66901n.f66908b).booleanValue());
                    view.invalidate();
                }
            }, i18);
            i18 += i17;
        }
        this.f66897j.postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem.2
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v8, types: [S, java.lang.Boolean] */
            @Override // java.lang.Runnable
            public void run() {
                if (((Boolean) DynamicTextItem.this.f66901n.f66908b).booleanValue() != z16) {
                    DynamicTextItem.this.f66901n.f66908b = Boolean.valueOf(!((Boolean) DynamicTextItem.this.f66901n.f66908b).booleanValue());
                    view.invalidate();
                }
                Runnable runnable2 = runnable;
                if (runnable2 != null) {
                    runnable2.run();
                }
                DynamicTextItem.this.f66895h = false;
            }
        }, i18);
    }

    public String e(int i3, String str) {
        int i16;
        if (str.length() <= i3) {
            return str;
        }
        StringBuilder sb5 = new StringBuilder();
        int i17 = 0;
        for (int i18 = 0; i18 < str.length(); i18++) {
            i17 = str.charAt(i18) == ' ' ? i17 + 1 : 0;
            sb5.append(str.charAt(i18));
            if (i17 == i3 && (i16 = i18 + 1) <= str.length() - 1 && str.charAt(i16) == ' ') {
                sb5.append("\r\n");
                i17 = 0;
            }
        }
        return sb5.toString();
    }

    public final void g(Canvas canvas) {
        canvas.save();
        canvas.translate((-w()) / 2.0f, (-m()) / 2.0f);
        I(canvas);
        canvas.restore();
    }

    public int h() {
        if (this.f66894g < 0) {
            this.f66894g = 0;
        }
        if (this.f66894g >= this.f66892e.f()) {
            return 0;
        }
        return this.f66894g;
    }

    public int hashCode() {
        int i3 = this.f66888a * 31;
        TextMap textMap = this.f66892e;
        return i3 + (textMap != null ? textMap.hashCode() : 0);
    }

    public String i() {
        return this.f66892e.a(h());
    }

    public Paint j() {
        return this.f66899l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String l(int i3, b bVar) {
        int f16 = f(i3);
        String p16 = p(f16);
        if (bVar != null) {
            p16 = bVar.a(f16, p16);
        }
        return y(p16);
    }

    public abstract float m();

    public InputFilter n() {
        return null;
    }

    public abstract int o();

    public String p(int i3) {
        if (i3 != f(i3)) {
            String str = "getText index out of bound, support size is " + o() + ", current index is " + i3;
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(str);
            if (QLog.isColorLevel()) {
                QLog.e(f66887o, 2, indexOutOfBoundsException, str);
            }
            i3 = 0;
        }
        return this.f66892e.a(i3);
    }

    public TextMap q() {
        return this.f66892e;
    }

    public int r() {
        return this.f66889b;
    }

    public ArrayList<String> s() {
        return new ArrayList<>(this.f66892e.b());
    }

    public int t(float f16, float f17, float f18, float f19) {
        return -1;
    }

    public String toString() {
        return "curIndex: " + this.f66894g + ", textMap: " + this.f66892e;
    }

    public int u(MotionEvent motionEvent, float f16, float f17, g.c cVar, zr.c cVar2) {
        if (!QLog.isColorLevel()) {
            return -1;
        }
        String str = f66887o;
        QLog.d(str, 2, "=========================================");
        QLog.d(str, 2, "Touch X: " + motionEvent.getX());
        QLog.d(str, 2, "Touch Y: " + motionEvent.getY());
        QLog.d(str, 2, "Container W: " + f16);
        QLog.d(str, 2, "Container H: " + f17);
        if (cVar == null) {
            QLog.d(str, 2, "Text Zoom info is null, use default info");
            QLog.d(str, 2, "Text W: " + w());
            QLog.d(str, 2, "Text H: " + m());
        } else {
            QLog.d(str, 2, "Text X: " + cVar.f453045a.x);
            QLog.d(str, 2, "Text Y: " + cVar.f453045a.y);
            QLog.d(str, 2, "Text W: " + cVar.f68001z.w());
            QLog.d(str, 2, "Text H: " + cVar.f68001z.m());
            QLog.d(str, 2, "Text Scale: " + cVar2.l(cVar));
            QLog.d(str, 2, "Text Matrix: " + cVar2.n(cVar));
            QLog.d(str, 2, "Text translateX: " + cVar.f453048d);
            QLog.d(str, 2, "Text translateY: " + cVar.f453049e);
            QLog.d(str, 2, "Text rotate: " + cVar.f453047c);
        }
        QLog.d(str, 2, "=========================================");
        return -1;
    }

    public int v() {
        return this.f66888a;
    }

    public abstract float w();

    /* JADX INFO: Access modifiers changed from: protected */
    public String y(String str) {
        if (!EditTextDialog.m0(v()) || str.length() <= 20) {
            return str;
        }
        StringBuilder sb5 = new StringBuilder();
        int i3 = 0;
        for (int i16 = 0; i16 < str.length() && i3 < 20; i16++) {
            sb5.append(str.charAt(i16));
            if (str.charAt(i16) != '\n' && str.charAt(i16) != '\r') {
                i3++;
            }
        }
        String sb6 = sb5.toString();
        if (sb6.isEmpty()) {
            return sb6;
        }
        return sb6.substring(0, Character.isHighSurrogate(sb6.charAt(sb6.length() - 1)) ? sb6.length() - 1 : sb6.length());
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [S, java.lang.Boolean] */
    public void z() {
        P();
        this.f66901n.f66908b = Boolean.FALSE;
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class TextMap implements Parcelable {
        public static final Parcelable.Creator<TextMap> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name */
        private Map<Integer, String> f66906d;

        /* compiled from: P */
        /* loaded from: classes32.dex */
        class a implements Parcelable.Creator<TextMap> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public TextMap createFromParcel(Parcel parcel) {
                return new TextMap(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public TextMap[] newArray(int i3) {
                return new TextMap[i3];
            }
        }

        public TextMap() {
            this.f66906d = new HashMap();
        }

        public String a(int i3) {
            int f16 = f();
            if (f16 == 0) {
                return "";
            }
            if (i3 >= 0 && i3 < f16) {
                String str = this.f66906d.get(Integer.valueOf(i3));
                return str == null ? "" : str;
            }
            throw new IndexOutOfBoundsException("location " + i3 + " is out of bounds, TextMap size is " + f16);
        }

        public List<String> b() {
            ArrayList arrayList = new ArrayList();
            int f16 = f();
            for (int i3 = 0; i3 < f16; i3++) {
                arrayList.add(this.f66906d.get(Integer.valueOf(i3)));
            }
            return arrayList;
        }

        public boolean c(int i3, int i16) {
            for (Map.Entry<Integer, String> entry : this.f66906d.entrySet()) {
                if (entry.getKey().intValue() >= i3 && entry.getKey().intValue() < i16 && !TextUtils.isEmpty(entry.getValue())) {
                    return false;
                }
            }
            return true;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public int f() {
            int i3 = -1;
            for (Map.Entry<Integer, String> entry : this.f66906d.entrySet()) {
                if (entry.getKey().intValue() > i3) {
                    i3 = entry.getKey().intValue();
                }
            }
            return i3 + 1;
        }

        public int hashCode() {
            return this.f66906d.hashCode();
        }

        public String toString() {
            int f16 = f();
            StringBuilder sb5 = new StringBuilder();
            for (int i3 = 0; i3 < f16; i3++) {
                sb5.append(this.f66906d.get(Integer.valueOf(i3)));
                sb5.append("#");
            }
            return sb5.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeInt(this.f66906d.size());
            for (Map.Entry<Integer, String> entry : this.f66906d.entrySet()) {
                parcel.writeInt(entry.getKey().intValue());
                parcel.writeString(entry.getValue());
            }
        }

        public TextMap(List<String> list) {
            this();
            if (list != null) {
                for (int i3 = 0; i3 < list.size(); i3++) {
                    this.f66906d.put(Integer.valueOf(i3), list.get(i3));
                }
            }
        }

        public void e(int i3, String str) {
            if (i3 != -1) {
                this.f66906d.put(Integer.valueOf(i3), str);
            }
        }

        protected TextMap(Parcel parcel) {
            this();
            int readInt = parcel.readInt();
            for (int i3 = 0; i3 < readInt; i3++) {
                this.f66906d.put(Integer.valueOf(parcel.readInt()), parcel.readString());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            TextMap textMap = (TextMap) obj;
            if (this.f66906d.equals(textMap.f66906d)) {
                return true;
            }
            int size = this.f66906d.size();
            if (size != textMap.f66906d.size()) {
                return false;
            }
            for (int i3 = 0; i3 < size; i3++) {
                if (!a(i3).equals(textMap.a(i3))) {
                    return false;
                }
            }
            return true;
        }
    }

    public void J() {
        this.f66896i = false;
    }

    public void N(int i3) {
        this.f66890c = true;
        this.f66889b = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String k(int i3) {
        return l(i3, null);
    }

    private int f(int i3) {
        if (i3 < 0 || i3 >= o()) {
            return 0;
        }
        return i3;
    }

    public void M(int i3, String str) {
        if (str == null) {
            str = "";
        }
        if (i3 != f(i3)) {
            String str2 = "setText index out of bound, support size is " + o() + ", current index is " + i3;
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(str2);
            if (QLog.isColorLevel()) {
                QLog.e(f66887o, 2, indexOutOfBoundsException, str2);
            }
            i3 = 0;
        }
        this.f66892e.e(i3, str);
    }

    public float x(StaticLayout staticLayout) {
        float f16 = 0.0f;
        if (staticLayout == null) {
            return 0.0f;
        }
        for (int i3 = 0; i3 < staticLayout.getLineCount(); i3++) {
            f16 = Math.max(f16, staticLayout.getLineWidth(i3));
        }
        return f16;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DynamicTextItem dynamicTextItem = (DynamicTextItem) obj;
        if (this.f66888a != dynamicTextItem.f66888a) {
            return false;
        }
        TextMap textMap = this.f66892e;
        TextMap textMap2 = dynamicTextItem.f66892e;
        if (textMap != null) {
            return textMap.equals(textMap2);
        }
        return textMap2 == null;
    }
}

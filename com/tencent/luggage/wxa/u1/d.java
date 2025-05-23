package com.tencent.luggage.wxa.u1;

import android.content.Context;
import android.os.Looper;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.internal.view.SupportMenu;
import com.tencent.luggage.wxa.tn.e0;
import com.tencent.luggage.wxa.u1.e;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d extends AppCompatTextView {

    /* renamed from: a, reason: collision with root package name */
    public final List f142043a;

    /* renamed from: b, reason: collision with root package name */
    public StringBuilder f142044b;

    /* renamed from: c, reason: collision with root package name */
    public e.d f142045c;

    /* renamed from: d, reason: collision with root package name */
    public e0 f142046d;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements e0.a {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.tn.e0.a
        public boolean a() {
            d.this.f142043a.clear();
            if (d.this.f142045c != null) {
                d.this.f142045c.a(d.this.f142043a);
            }
            d dVar = d.this;
            dVar.a(dVar.f142043a);
            return true;
        }
    }

    public d(Context context) {
        super(context);
        this.f142043a = new ArrayList(4);
        this.f142044b = new StringBuilder(100);
        this.f142045c = null;
        this.f142046d = new e0(Looper.getMainLooper(), (e0.a) new a(), true);
        a();
        this.f142046d.a(1000L);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public final void a() {
        setTextSize(12.0f);
        setTextColor(SupportMenu.CATEGORY_MASK);
        setFocusable(false);
        setClickable(false);
        setOnClickListener(null);
    }

    public void b() {
        this.f142046d.f();
        this.f142045c = null;
        this.f142043a.clear();
    }

    public void a(List list) {
        this.f142044b.setLength(0);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            f fVar = (f) it.next();
            StringBuilder sb5 = this.f142044b;
            sb5.append(fVar.f142066a);
            sb5.append(MsgSummary.STR_COLON);
            sb5.append(fVar.f142067b);
            sb5.append("\n");
        }
        setText(this.f142044b);
    }

    public void a(e.d dVar) {
        this.f142045c = dVar;
    }
}

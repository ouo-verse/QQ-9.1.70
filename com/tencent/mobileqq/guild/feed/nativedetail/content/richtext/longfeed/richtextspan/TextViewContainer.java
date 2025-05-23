package com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes13.dex */
public class TextViewContainer extends FrameLayout {
    ViewTreeObserver.OnScrollChangedListener C;
    Runnable D;
    c.d E;
    c.InterfaceC7762c F;
    c.b G;
    c.e H;

    /* renamed from: d, reason: collision with root package name */
    private TextView f221480d;

    /* renamed from: e, reason: collision with root package name */
    private final List<com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c> f221481e;

    /* renamed from: f, reason: collision with root package name */
    private List<com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c> f221482f;

    /* renamed from: h, reason: collision with root package name */
    private int f221483h;

    /* renamed from: i, reason: collision with root package name */
    private int f221484i;

    /* renamed from: m, reason: collision with root package name */
    private int f221485m;

    /* compiled from: P */
    /* loaded from: classes13.dex */
    class a implements ViewTreeObserver.OnScrollChangedListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            for (int i3 = 0; i3 < TextViewContainer.this.f221481e.size(); i3++) {
                com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c cVar = (com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c) TextViewContainer.this.f221481e.get(i3);
                Rect g16 = cVar.g();
                if (g16 != null) {
                    int y16 = TextViewContainer.this.y(g16);
                    if (cVar.h() == null && y16 == 1) {
                        if (QLog.isDevelopLevel()) {
                            QLog.d("TextViewContainer", 4, "onScrollChanged create: " + cVar.hashCode());
                        }
                        TextViewContainer.this.addView(cVar.l());
                        TextViewContainer.this.f221480d.requestLayout();
                    }
                    int j3 = cVar.j();
                    if (j3 == 0 && y16 == 1) {
                        cVar.o();
                    } else if (j3 == 1 && y16 == 0) {
                        cVar.n();
                    }
                    cVar.u(y16);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    class b implements c.d {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c.d
        public void a(com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c cVar) {
            int y16 = TextViewContainer.this.y(cVar.g());
            if (cVar.h() == null && y16 == 1) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("TextViewContainer", 4, "onInitialSpanDraw create: " + cVar.hashCode());
                }
                TextViewContainer.this.addView(cVar.l());
                cVar.u(y16);
                TextViewContainer.this.f221480d.requestLayout();
                TextViewContainer.this.f221483h++;
            }
            if (y16 == 1) {
                cVar.o();
            }
            TextViewContainer.this.f221484i++;
            if (TextViewContainer.this.f221484i == TextViewContainer.this.f221481e.size() && TextViewContainer.this.f221483h == 0) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("TextViewContainer", 4, "onInitialSpanDraw post createViewRunnable. initialSpanDrawCount: " + TextViewContainer.this.f221484i);
                }
                TextViewContainer textViewContainer = TextViewContainer.this;
                textViewContainer.post(textViewContainer.D);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    class c implements c.e {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c.e
        public void a(com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c cVar) {
            TextViewContainer.this.f221480d.setText(TextViewContainer.this.f221480d.getText());
        }
    }

    public TextViewContainer(@NonNull Context context) {
        this(context, null);
    }

    private void l() {
        addView(this.f221480d, new ViewGroup.LayoutParams(-1, -2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (!this.f221482f.isEmpty()) {
            if (QLog.isDevelopLevel()) {
                QLog.d("TextViewContainer", 4, "[clearOldSpans] size: " + this.f221482f.size());
            }
            for (com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c cVar : this.f221482f) {
                if (cVar.h() != null && (cVar.h().getParent() instanceof ViewGroup)) {
                    ((ViewGroup) cVar.h().getParent()).removeView(cVar.h());
                }
                cVar.m();
            }
        }
        this.f221482f.clear();
    }

    private void n() {
        if (!this.f221482f.isEmpty()) {
            postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.f
                @Override // java.lang.Runnable
                public final void run() {
                    TextViewContainer.this.m();
                }
            }, 100L);
        }
    }

    static List<com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c> p(List<com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c> list, List<com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c> list2) {
        boolean z16;
        ArrayList arrayList = new ArrayList();
        for (com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c cVar : list) {
            Iterator<com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c> it = list2.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (cVar == it.next()) {
                        z16 = true;
                        break;
                    }
                } else {
                    z16 = false;
                    break;
                }
            }
            if (!z16) {
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c cVar) {
        int i3 = this.f221485m + 1;
        this.f221485m = i3;
        if (i3 == this.f221483h) {
            if (QLog.isDevelopLevel()) {
                QLog.d("TextViewContainer", 4, "onFirstLayoutCompleted post createViewRunnable. firstLayoutCompletedCount: " + this.f221485m);
            }
            n();
            post(this.D);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean u(com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c cVar, CharSequence charSequence) {
        if (!this.f221480d.hasSelection() && TextUtils.equals(this.f221480d.getText(), charSequence)) {
            return true;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("TextViewContainer", 4, "OnAdjustViewPositionListener hasSelection: " + this.f221480d.hasSelection());
            return false;
        }
        return false;
    }

    private void w(List<com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c> list) {
        if (!this.f221481e.isEmpty()) {
            this.f221482f.addAll(this.f221481e);
        }
        this.f221483h = 0;
        this.f221484i = 0;
        this.f221485m = 0;
        this.f221481e.clear();
        if (list != null) {
            Iterator<com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c> it = list.iterator();
            while (it.hasNext()) {
                k(it.next());
            }
        }
    }

    private void x(List<com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c> list) {
        List<com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c> p16 = p(this.f221481e, list);
        if (!p16.isEmpty()) {
            this.f221482f.addAll(p16);
            Iterator<com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c> it = p16.iterator();
            while (it.hasNext()) {
                this.f221481e.remove(it.next());
            }
        }
        List<com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c> p17 = p(list, this.f221481e);
        if (!p17.isEmpty()) {
            Iterator<com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c> it5 = p17.iterator();
            while (it5.hasNext()) {
                k(it5.next());
            }
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("TextViewContainer", 4, "[reuseAndAddSpanList] spansToRemove: " + p16.size() + ", spansToAdd: " + p17.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int y(Rect rect) {
        if (rect == null) {
            return 0;
        }
        Rect rect2 = new Rect();
        this.f221480d.getGlobalVisibleRect(rect2);
        int[] iArr = new int[2];
        this.f221480d.getLocationOnScreen(iArr);
        int i3 = iArr[0];
        int i16 = rect.left + i3;
        int i17 = iArr[1];
        if (!Rect.intersects(rect2, new Rect(i16, rect.top + i17, i3 + rect.right, i17 + rect.bottom))) {
            return 0;
        }
        return 1;
    }

    public void k(com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c cVar) {
        cVar.s(this.H);
        cVar.r(this.E);
        cVar.u(0);
        cVar.q(this.F);
        cVar.p(this.G);
        this.f221481e.add(cVar);
    }

    public void o(String str, Object obj) {
        Iterator<com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c> it = this.f221481e.iterator();
        while (it.hasNext()) {
            it.next().i().f(str, obj);
        }
    }

    public Runnable q() {
        return this.D;
    }

    public List<com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c> r() {
        return this.f221481e;
    }

    public TextView s() {
        return this.f221480d;
    }

    public void setText(CharSequence charSequence) {
        w(null);
        this.f221480d.setText(charSequence);
        n();
    }

    public void v() {
        Iterator<com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c> it = this.f221481e.iterator();
        while (it.hasNext()) {
            it.next().m();
        }
    }

    public TextViewContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextViewContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public TextViewContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        this.f221482f = new ArrayList();
        this.f221483h = 0;
        this.f221484i = 0;
        this.f221485m = 0;
        this.C = new a();
        this.D = new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.TextViewContainer.2
            @Override // java.lang.Runnable
            public void run() {
                for (com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c cVar : TextViewContainer.this.f221481e) {
                    if (cVar.h() == null) {
                        if (QLog.isDevelopLevel()) {
                            QLog.d("TextViewContainer", 4, "createViewRunnable create: " + cVar.hashCode());
                        }
                        TextViewContainer.this.addView(cVar.l());
                        cVar.q(null);
                    }
                    TextViewContainer.this.f221480d.requestLayout();
                }
            }
        };
        this.E = new b();
        this.F = new c.InterfaceC7762c() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.d
            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c.InterfaceC7762c
            public final void a(c cVar) {
                TextViewContainer.this.t(cVar);
            }
        };
        this.G = new c.b() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.e
            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c.b
            public final boolean a(c cVar, CharSequence charSequence) {
                boolean u16;
                u16 = TextViewContainer.this.u(cVar, charSequence);
                return u16;
            }
        };
        this.H = new c();
        this.f221481e = new ArrayList();
        this.f221480d = new TextView(context);
        l();
        getViewTreeObserver().addOnScrollChangedListener(this.C);
    }

    public void setText(CharSequence charSequence, List<com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c> list, boolean z16) {
        if (!z16 && !this.f221481e.isEmpty()) {
            x(list);
        } else {
            w(list);
        }
        this.f221480d.setText(charSequence);
        n();
    }

    public TextViewContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16, TextView textView) {
        super(context, attributeSet, i3, i16);
        this.f221482f = new ArrayList();
        this.f221483h = 0;
        this.f221484i = 0;
        this.f221485m = 0;
        this.C = new a();
        this.D = new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.TextViewContainer.2
            @Override // java.lang.Runnable
            public void run() {
                for (com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c cVar : TextViewContainer.this.f221481e) {
                    if (cVar.h() == null) {
                        if (QLog.isDevelopLevel()) {
                            QLog.d("TextViewContainer", 4, "createViewRunnable create: " + cVar.hashCode());
                        }
                        TextViewContainer.this.addView(cVar.l());
                        cVar.q(null);
                    }
                    TextViewContainer.this.f221480d.requestLayout();
                }
            }
        };
        this.E = new b();
        this.F = new c.InterfaceC7762c() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.d
            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c.InterfaceC7762c
            public final void a(c cVar) {
                TextViewContainer.this.t(cVar);
            }
        };
        this.G = new c.b() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.e
            @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c.b
            public final boolean a(c cVar, CharSequence charSequence) {
                boolean u16;
                u16 = TextViewContainer.this.u(cVar, charSequence);
                return u16;
            }
        };
        this.H = new c();
        this.f221481e = new ArrayList();
        this.f221480d = textView;
        l();
        getViewTreeObserver().addOnScrollChangedListener(this.C);
    }
}

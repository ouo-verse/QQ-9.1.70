package com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.view;

import android.content.Context;
import android.database.Observable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.view.QQStrangerSignalPickerView;
import com.tencent.mobileqq.remind.widget.WheelView;
import com.tencent.widget.VerticalGallery;

/* loaded from: classes33.dex */
public class QQStrangerSignalPickerView extends ConstraintLayout {
    private f C;

    /* renamed from: d, reason: collision with root package name */
    private g f244941d;

    /* renamed from: e, reason: collision with root package name */
    private WheelView f244942e;

    /* renamed from: f, reason: collision with root package name */
    private WheelView f244943f;

    /* renamed from: h, reason: collision with root package name */
    private d f244944h;

    /* renamed from: i, reason: collision with root package name */
    private b f244945i;

    /* renamed from: m, reason: collision with root package name */
    private c f244946m;

    /* loaded from: classes33.dex */
    class a extends f {
        a() {
        }

        @Override // com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.view.QQStrangerSignalPickerView.f
        void a() {
            QQStrangerSignalPickerView.this.f244945i.notifyDataSetChanged();
            QQStrangerSignalPickerView.this.f244944h.notifyDataSetChanged();
        }
    }

    /* loaded from: classes33.dex */
    public interface c {
        void onItemSelected(int i3, int i16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public static class e extends Observable<f> {
        e() {
        }

        public void a() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((f) ((Observable) this).mObservers.get(size)).a();
            }
        }
    }

    /* loaded from: classes33.dex */
    public static abstract class f {
        abstract void a();
    }

    /* loaded from: classes33.dex */
    public static abstract class g<VH extends h> {

        /* renamed from: a, reason: collision with root package name */
        private final e f244951a = new e();

        public abstract int a();

        public abstract int b(int i3);

        public void c() {
            this.f244951a.a();
        }

        public abstract void d(VH vh5, int i3);

        public abstract VH e(ViewGroup viewGroup, int i3);

        public abstract void f(VH vh5, int i3, int i16);

        public abstract VH g(ViewGroup viewGroup, int i3, int i16);

        public void h(f fVar) {
            this.f244951a.registerObserver(fVar);
        }

        public void i(f fVar) {
            this.f244951a.unregisterObserver(fVar);
        }
    }

    /* loaded from: classes33.dex */
    public static abstract class h {

        /* renamed from: a, reason: collision with root package name */
        public View f244952a;

        public h(View view) {
            this.f244952a = view;
        }
    }

    public QQStrangerSignalPickerView(Context context) {
        this(context, null);
    }

    private void E0(g gVar) {
        this.f244945i = new b(gVar);
        d dVar = new d(0, gVar);
        this.f244944h = dVar;
        this.f244942e.setAdapter((SpinnerAdapter) dVar);
        this.f244942e.setOnEndMovementListener(new VerticalGallery.OnEndMovementListener() { // from class: h82.a
            @Override // com.tencent.widget.VerticalGallery.OnEndMovementListener
            public final void onEndMovement(VerticalGallery verticalGallery) {
                QQStrangerSignalPickerView.this.F0(verticalGallery);
            }
        });
        this.f244943f.setAdapter((SpinnerAdapter) this.f244945i);
        this.f244943f.setOnEndMovementListener(new VerticalGallery.OnEndMovementListener() { // from class: h82.b
            @Override // com.tencent.widget.VerticalGallery.OnEndMovementListener
            public final void onEndMovement(VerticalGallery verticalGallery) {
                QQStrangerSignalPickerView.this.G0(verticalGallery);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F0(VerticalGallery verticalGallery) {
        c cVar = this.f244946m;
        if (cVar != null) {
            cVar.onItemSelected(this.f244943f.getSelectedItemPosition(), this.f244942e.getSelectedItemPosition());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G0(VerticalGallery verticalGallery) {
        int selectedItemPosition = this.f244943f.getSelectedItemPosition();
        this.f244944h.a(selectedItemPosition);
        this.f244944h.notifyDataSetChanged();
        this.f244942e.setSelection(Math.min(this.f244944h.getCount() - 1, 2), true);
        c cVar = this.f244946m;
        if (cVar != null) {
            cVar.onItemSelected(selectedItemPosition, this.f244942e.getSelectedItemPosition());
        }
    }

    public WheelView D0() {
        return this.f244943f;
    }

    public void setAdapter(g gVar) {
        g gVar2 = this.f244941d;
        if (gVar2 != null) {
            gVar2.i(this.C);
        }
        if (gVar != null) {
            gVar.h(this.C);
        }
        this.f244941d = gVar;
        E0(gVar);
    }

    public void setFirstSelection(int i3) {
        this.f244943f.setSelection(i3, true);
        d dVar = this.f244944h;
        if (dVar != null) {
            dVar.a(i3);
            this.f244944h.notifyDataSetChanged();
        }
    }

    public void setOnItemSelectedListener(c cVar) {
        this.f244946m = cVar;
    }

    public void setSecondSelection(int i3) {
        this.f244942e.setSelection(i3, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes33.dex */
    public static class b extends BaseAdapter {

        /* renamed from: d, reason: collision with root package name */
        private g f244948d;

        b(g gVar) {
            this.f244948d = gVar;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f244948d.a();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            return Integer.valueOf(i3);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            h hVar;
            if (view == null) {
                hVar = this.f244948d.e(viewGroup, i3);
            } else {
                hVar = (h) view.getTag();
            }
            this.f244948d.d(hVar, i3);
            return hVar.f244952a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes33.dex */
    public static class d extends BaseAdapter {

        /* renamed from: d, reason: collision with root package name */
        private int f244949d;

        /* renamed from: e, reason: collision with root package name */
        private g f244950e;

        d(int i3, g gVar) {
            this.f244949d = i3;
            this.f244950e = gVar;
        }

        public void a(int i3) {
            this.f244949d = i3;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f244950e.b(this.f244949d);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            return Integer.valueOf(i3);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            h hVar;
            if (view == null) {
                hVar = this.f244950e.g(viewGroup, this.f244949d, i3);
            } else {
                hVar = (h) view.getTag();
            }
            this.f244950e.f(hVar, this.f244949d, i3);
            return hVar.f244952a;
        }
    }

    public QQStrangerSignalPickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QQStrangerSignalPickerView(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public QQStrangerSignalPickerView(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        this.C = new a();
        LayoutInflater.from(context).inflate(R.layout.cy8, (ViewGroup) this, true);
        this.f244942e = (WheelView) findViewById(R.id.ope);
        this.f244943f = (WheelView) findViewById(R.id.opm);
    }
}

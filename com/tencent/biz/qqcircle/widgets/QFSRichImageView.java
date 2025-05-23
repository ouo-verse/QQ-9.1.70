package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.provider.Settings;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSRichImageView extends QFSPagAnimView {
    private final float M;
    private b N;
    private boolean P;
    private boolean Q;
    private int R;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public Object f93410a;

        /* renamed from: b, reason: collision with root package name */
        public Object f93411b;
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public Object f93412a;

        /* renamed from: b, reason: collision with root package name */
        public Object f93413b;

        /* renamed from: d, reason: collision with root package name */
        public Object f93415d;

        /* renamed from: e, reason: collision with root package name */
        public Object f93416e;

        /* renamed from: g, reason: collision with root package name */
        public a f93418g;

        /* renamed from: c, reason: collision with root package name */
        public boolean f93414c = true;

        /* renamed from: f, reason: collision with root package name */
        public boolean f93417f = true;
    }

    public QFSRichImageView(Context context) {
        this(context, null);
    }

    public static float Y(Context context) {
        try {
            return Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f);
        } catch (Exception e16) {
            QLog.d("QFSRichImageView", 1, "[getAnimationScale] error:" + e16);
            return 1.0f;
        }
    }

    private Object a0(boolean z16) {
        if (this.N == null) {
            return null;
        }
        if (d0()) {
            if (z16) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.N.f93412a);
                arrayList.add(this.N.f93413b);
                a aVar = this.N.f93418g;
                if (aVar != null) {
                    arrayList.add(aVar.f93410a);
                }
                return c0(arrayList);
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(this.N.f93413b);
            arrayList2.add(this.N.f93412a);
            a aVar2 = this.N.f93418g;
            if (aVar2 != null) {
                arrayList2.add(aVar2.f93410a);
            }
            return c0(arrayList2);
        }
        if (z16) {
            ArrayList arrayList3 = new ArrayList();
            a aVar3 = this.N.f93418g;
            if (aVar3 != null) {
                arrayList3.add(aVar3.f93410a);
            }
            arrayList3.add(this.N.f93412a);
            arrayList3.add(this.N.f93413b);
            return c0(arrayList3);
        }
        ArrayList arrayList4 = new ArrayList();
        a aVar4 = this.N.f93418g;
        if (aVar4 != null) {
            arrayList4.add(aVar4.f93410a);
        }
        arrayList4.add(this.N.f93413b);
        arrayList4.add(this.N.f93412a);
        return c0(arrayList4);
    }

    private Object b0(boolean z16) {
        if (this.N == null) {
            return null;
        }
        if (d0()) {
            if (z16) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.N.f93415d);
                arrayList.add(this.N.f93416e);
                a aVar = this.N.f93418g;
                if (aVar != null) {
                    arrayList.add(aVar.f93411b);
                }
                return c0(arrayList);
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(this.N.f93416e);
            arrayList2.add(this.N.f93415d);
            a aVar2 = this.N.f93418g;
            if (aVar2 != null) {
                arrayList2.add(aVar2.f93411b);
            }
            return c0(arrayList2);
        }
        if (z16) {
            ArrayList arrayList3 = new ArrayList();
            a aVar3 = this.N.f93418g;
            if (aVar3 != null) {
                arrayList3.add(aVar3.f93411b);
            }
            arrayList3.add(this.N.f93415d);
            arrayList3.add(this.N.f93416e);
            return c0(arrayList3);
        }
        ArrayList arrayList4 = new ArrayList();
        a aVar4 = this.N.f93418g;
        if (aVar4 != null) {
            arrayList4.add(aVar4.f93411b);
        }
        arrayList4.add(this.N.f93416e);
        arrayList4.add(this.N.f93415d);
        return c0(arrayList4);
    }

    private Object c0(List<Object> list) {
        if (list == null) {
            return null;
        }
        for (Object obj : list) {
            if (obj != null) {
                return obj;
            }
        }
        return null;
    }

    private boolean d0() {
        int i3 = this.R;
        if (i3 == 1) {
            return true;
        }
        if (i3 == 0 && !QCircleSkinHelper.getInstance().isDarkMode()) {
            return true;
        }
        return false;
    }

    private void f0(boolean z16, boolean z17) {
        b bVar = this.N;
        if (bVar == null) {
            return;
        }
        boolean z18 = false;
        if (z16) {
            Object a06 = a0(z17);
            if (a06 != null) {
                if (!bVar.f93414c || !z17) {
                    z18 = true;
                }
                setStaticImageMode(z18);
                U(a06);
                return;
            }
            QLog.d("QFSRichImageView", 1, "[updateStatusUi] selectUrl is null");
            return;
        }
        Object b06 = b0(z17);
        if (b06 != null) {
            if (!bVar.f93417f || !z17) {
                z18 = true;
            }
            setStaticImageMode(z18);
            U(b06);
            return;
        }
        QLog.d("QFSRichImageView", 1, "[updateStatusUi] unSelectUrl is null");
    }

    @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView
    public void F() {
        super.F();
        this.P = false;
    }

    @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView
    public void G() {
        super.G();
        this.P = false;
        f0(isSelected(), false);
    }

    @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView
    public void K(String str) {
        super.K(str);
        f0(isSelected(), false);
    }

    public b Z() {
        return this.N;
    }

    public void e0() {
        f0(isSelected(), false);
    }

    public void setColorMode(int i3) {
        this.R = i3;
    }

    public void setIsWrapContent(boolean z16) {
        this.Q = z16;
    }

    public void setResInfo(b bVar) {
        this.N = bVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(bVar.f93412a);
        arrayList.add(bVar.f93415d);
        a aVar = bVar.f93418g;
        if (aVar != null) {
            arrayList.add(aVar.f93410a);
            arrayList.add(bVar.f93418g.f93411b);
        }
        setResUrl((List<Object>) arrayList);
        f0(isSelected(), false);
    }

    @Override // android.view.View
    public void setSelected(boolean z16) {
        super.setSelected(z16);
        f0(z16, true);
        this.P = true;
    }

    @Override // com.tencent.biz.qqcircle.widgets.QFSPagAnimView
    protected boolean w() {
        return this.Q;
    }

    public QFSRichImageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QFSRichImageView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.Q = false;
        this.R = 0;
        setRepeatTimes(1);
        this.M = Y(context);
    }

    public void setSelected(boolean z16, boolean z17) {
        super.setSelected(z16);
        f0(z16, z17);
    }
}

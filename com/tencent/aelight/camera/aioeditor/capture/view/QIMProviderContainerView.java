package com.tencent.aelight.camera.aioeditor.capture.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.m;
import com.tencent.aelight.camera.aioeditor.capture.util.g;
import com.tencent.aelight.camera.aioeditor.capture.util.h;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.widget.RedDotImageView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes32.dex */
public class QIMProviderContainerView extends AbsBottomPanal {
    private h C;
    private HashMap<Integer, ProviderView> D;
    private ProviderView E;
    private View F;
    public int G;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private ArrayList<View> L;
    private float M;
    boolean N;
    public boolean P;
    public boolean Q;
    private boolean R;
    private List<b> S;
    View.OnClickListener T;

    /* renamed from: e, reason: collision with root package name */
    LinearLayout f67295e;

    /* renamed from: f, reason: collision with root package name */
    FrameLayout f67296f;

    /* renamed from: h, reason: collision with root package name */
    View f67297h;

    /* renamed from: i, reason: collision with root package name */
    View f67298i;

    /* renamed from: m, reason: collision with root package name */
    View f67299m;

    /* renamed from: com.tencent.aelight.camera.aioeditor.capture.view.QIMProviderContainerView$6, reason: invalid class name */
    /* loaded from: classes32.dex */
    class AnonymousClass6 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RedDotImageView f67300d;
        final /* synthetic */ QIMProviderContainerView this$0;

        @Override // java.lang.Runnable
        public void run() {
            int childCount = this.this$0.f67295e.getChildCount();
            m.A();
            final boolean z16 = false;
            int i3 = 0;
            while (true) {
                if (i3 >= childCount) {
                    break;
                }
                if (this.this$0.C.h(i3)) {
                    z16 = true;
                    break;
                }
                i3++;
            }
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.capture.view.QIMProviderContainerView.6.1
                @Override // java.lang.Runnable
                public void run() {
                    if (z16 && !AnonymousClass6.this.f67300d.a()) {
                        AnonymousClass6.this.f67300d.setReddotXOffsetDp(12);
                        AnonymousClass6.this.f67300d.setReddotYOffsetDp(11);
                        RedDotImageView redDotImageView = AnonymousClass6.this.f67300d;
                        redDotImageView.setRedDotDrawable(redDotImageView.getResources().getDrawable(R.drawable.skin_tips_dot_small));
                        AnonymousClass6.this.f67300d.b(true);
                        return;
                    }
                    if (z16 || !AnonymousClass6.this.f67300d.a()) {
                        return;
                    }
                    AnonymousClass6.this.f67300d.b(false);
                }
            });
        }
    }

    /* renamed from: com.tencent.aelight.camera.aioeditor.capture.view.QIMProviderContainerView$7, reason: invalid class name */
    /* loaded from: classes32.dex */
    class AnonymousClass7 implements Runnable {
        final /* synthetic */ QIMProviderContainerView this$0;

        @Override // java.lang.Runnable
        public void run() {
            final int childCount = this.this$0.f67295e.getChildCount();
            if (this.this$0.K) {
                final Drawable[] drawableArr = new Drawable[childCount];
                for (int i3 = 0; i3 < childCount; i3++) {
                    if (this.this$0.C.h(i3)) {
                        drawableArr[i3] = this.this$0.getResources().getDrawable(this.this$0.C.e(((Integer) ((ImageView) this.this$0.f67295e.getChildAt(i3)).getTag()).intValue()));
                    }
                }
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.capture.view.QIMProviderContainerView.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        for (int i16 = 0; i16 < childCount; i16++) {
                            if (AnonymousClass7.this.this$0.C.h(i16)) {
                                ImageView imageView = (ImageView) AnonymousClass7.this.this$0.f67295e.getChildAt(i16);
                                Drawable drawable = drawableArr[i16];
                                if (drawable != null) {
                                    imageView.setImageDrawable(drawable);
                                    if (imageView.getDrawable() instanceof AnimationDrawable) {
                                        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
                                        animationDrawable.stop();
                                        animationDrawable.setOneShot(true);
                                        animationDrawable.start();
                                    }
                                }
                            }
                        }
                    }
                });
                this.this$0.K = false;
            }
        }
    }

    /* loaded from: classes32.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MusicProviderView musicProviderView;
            EventCollector.getInstance().onViewClickedBefore(view);
            if (view.getId() == R.id.gl8 && (musicProviderView = (MusicProviderView) QIMProviderContainerView.this.D.get(104)) != null && !musicProviderView.K()) {
                QQToast.makeText(BaseApplication.getContext(), HardCodeUtil.qqStr(R.string.qdp), 0).show();
            } else {
                switch (view.getId()) {
                    case R.id.gl5 /* 2131382861 */:
                        id0.a.o("clk_beauty", id0.a.e(-1), 0, false, new String[0]);
                        break;
                    case R.id.gl6 /* 2131382862 */:
                        id0.a.o("clk_effect", id0.a.e(-1), 0, false, new String[0]);
                        break;
                    case R.id.gl7 /* 2131382863 */:
                        id0.a.o("clk_filter", id0.a.e(-1), 0, false, new String[0]);
                        break;
                    case R.id.gl8 /* 2131382864 */:
                        id0.a.o("clk_music", id0.a.e(-1), 0, false, new String[0]);
                        break;
                    case R.id.gla /* 2131382866 */:
                        id0.a.o("clk_face", id0.a.e(-1), 0, false, new String[0]);
                        break;
                }
                int intValue = ((Integer) view.getTag()).intValue();
                if (QLog.isColorLevel()) {
                    QLog.i("ProviderContainerView", 2, "onclick, index: " + intValue);
                }
                QIMProviderContainerView.this.g(intValue, 0, null, false);
                QIMProviderContainerView.c(QIMProviderContainerView.this);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes32.dex */
    public interface b {
        void a(boolean z16);
    }

    public QIMProviderContainerView(Context context) {
        super(context);
        this.D = new HashMap<>();
        this.H = false;
        this.I = false;
        this.J = false;
        this.K = true;
        this.L = new ArrayList<>();
        this.M = 0.0f;
        this.N = false;
        this.P = false;
        this.Q = false;
        this.R = false;
        this.S = new ArrayList();
        this.T = new a();
        h();
    }

    static /* bridge */ /* synthetic */ fr.a c(QIMProviderContainerView qIMProviderContainerView) {
        qIMProviderContainerView.getClass();
        return null;
    }

    private void h() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ap6, (ViewGroup) null);
        addView(inflate);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.d_b);
        this.f67295e = linearLayout;
        linearLayout.setGravity(0);
        this.f67296f = (FrameLayout) inflate.findViewById(R.id.f166550g32);
        this.f67297h = inflate.findViewById(R.id.c2f);
        this.f67298i = inflate.findViewById(R.id.c2e);
        this.f67299m = inflate.findViewById(R.id.kmu);
        this.C = new h(0);
        this.L.add(this.f67295e);
        this.L.add(this.f67297h);
        this.L.add(this.f67298i);
        this.L.add(this.f67299m);
    }

    private void i(int i3, boolean z16) {
        ProviderView providerView;
        ProviderView providerView2 = this.E;
        if (providerView2 != null) {
            providerView2.x();
            this.E.setAlpha(1.0f);
            this.E.setVisibility(8);
            this.E = null;
        }
        if (this.D.containsKey(Integer.valueOf(this.C.d(i3)))) {
            providerView = this.D.get(Integer.valueOf(this.C.d(i3)));
        } else {
            ProviderView a16 = this.C.a(getContext(), this.C.d(i3));
            if (a16 != null) {
                this.D.put(Integer.valueOf(this.C.d(i3)), a16);
                this.f67296f.addView(a16);
            } else if (QLog.isColorLevel()) {
                QLog.e("ProviderContainerView", 2, "build provider view failed " + i3);
                return;
            }
            providerView = a16;
        }
        if (providerView != null) {
            if (!providerView.I) {
                providerView.setProviderViewListener(null);
                providerView.setDoodleEventListener(null);
                providerView.v(null);
            }
            this.E = providerView;
            if (!z16) {
                providerView.setAlpha(1.0f);
                this.E.setVisibility(0);
            } else {
                providerView.setAlpha(1.0f);
                this.E.setVisibility(8);
            }
            if (this.E.getId() == R.id.apf) {
                for (b bVar : this.S) {
                    if (bVar != null) {
                        bVar.a(false);
                    }
                }
                this.E.y();
                throw null;
            }
            throw null;
        }
    }

    public void f(int i3, int i16, String str, String str2, boolean z16) {
        if (!this.J) {
            if (QLog.isColorLevel()) {
                QLog.e("ProviderContainerView", 2, "doOpenProviderView failed isInflated" + this.J);
                return;
            }
            return;
        }
        if (i3 >= 0 && i3 < this.f67295e.getChildCount()) {
            View view = this.F;
            if (view != null) {
                view.setSelected(false);
                this.H = true;
            }
            View childAt = this.f67295e.getChildAt(i3);
            this.F = childAt;
            childAt.setSelected(true);
            this.G = i3;
            ((ImageView) this.F).setImageResource(this.C.c(i3));
            if (!this.H) {
                j(i3);
            } else {
                i(i3, false);
            }
            this.C.o(i3);
            if (z16) {
                if (QLog.isColorLevel()) {
                    QLog.d("ProviderContainerView", 2, "openSpecificTabByWeb tab_index= " + i3 + ",categoryId=" + i16 + ",categoryName=" + str + "itemId=" + str2);
                }
                this.E.D(i16, str, str2);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("ProviderContainerView", 2, "doOpenProviderView failed out bounds" + i3 + " size:" + this.f67295e.getChildCount());
        }
    }

    public void setBackGroundAlpha(float f16) {
        ArrayList<View> arrayList = this.L;
        if (arrayList != null) {
            Iterator<View> it = arrayList.iterator();
            while (it.hasNext()) {
                View next = it.next();
                if (next != null) {
                    next.setAlpha(f16);
                }
            }
        }
    }

    public void setBeautyEnable(boolean z16) {
        h hVar = this.C;
        if (hVar != null) {
            hVar.i(z16);
        }
    }

    public void setComboEnable(boolean z16) {
        h hVar = this.C;
        if (hVar != null) {
            hVar.j(z16);
        }
    }

    public void setDpcEnable(boolean z16) {
        h hVar = this.C;
        if (hVar != null) {
            hVar.k(z16);
        }
    }

    public void setFaceEffectEnable(boolean z16) {
        h hVar = this.C;
        if (hVar != null) {
            hVar.l(z16);
        }
    }

    public void setFilterEnable(boolean z16) {
        h hVar = this.C;
        if (hVar != null) {
            hVar.m(z16);
        }
    }

    public void setIsGuideMode(boolean z16) {
        MusicProviderView musicProviderView = (MusicProviderView) this.D.get(104);
        if (musicProviderView != null) {
            musicProviderView.setIsGuideMode(z16);
        }
    }

    public void setMusicEnable(boolean z16) {
        h hVar = this.C;
        if (hVar != null) {
            hVar.n(z16);
        }
    }

    private void j(int i3) {
        this.I = true;
        i(i3, true);
        int b16 = UIUtils.b(getContext(), 88.0f);
        ArrayList arrayList = new ArrayList();
        arrayList.add(ObjectAnimator.ofFloat(this, "translationY", b16, 0.0f));
        arrayList.add(ObjectAnimator.ofFloat(this.f67295e, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f));
        arrayList.add(g.a(this.f67297h, getResources().getColor(R.color.f156931fl), 0, 153));
        arrayList.add(g.a(this.f67298i, getResources().getColor(R.color.f156931fl), 0, 153));
        throw null;
    }

    public void setCaptureControllerAndPreloadView(fr.a aVar) {
        this.J = true;
        if (QLog.isColorLevel()) {
            QLog.d("ProviderContainerView", 2, "preloadProviderView");
        }
    }

    public void g(int i3, int i16, String str, boolean z16) {
        f(i3, i16, null, str, z16);
    }

    public QIMProviderContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.D = new HashMap<>();
        this.H = false;
        this.I = false;
        this.J = false;
        this.K = true;
        this.L = new ArrayList<>();
        this.M = 0.0f;
        this.N = false;
        this.P = false;
        this.Q = false;
        this.R = false;
        this.S = new ArrayList();
        this.T = new a();
        h();
    }

    public QIMProviderContainerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.D = new HashMap<>();
        this.H = false;
        this.I = false;
        this.J = false;
        this.K = true;
        this.L = new ArrayList<>();
        this.M = 0.0f;
        this.N = false;
        this.P = false;
        this.Q = false;
        this.R = false;
        this.S = new ArrayList();
        this.T = new a();
        h();
    }
}

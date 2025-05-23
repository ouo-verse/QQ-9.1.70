package com.tencent.aelight.camera.aioeditor.capture.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes32.dex */
public class ProviderContainerView extends FrameLayout {
    private View C;
    private int D;
    private View.OnClickListener E;

    /* renamed from: d, reason: collision with root package name */
    private LinearLayout f67269d;

    /* renamed from: e, reason: collision with root package name */
    private FrameLayout f67270e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.aelight.camera.aioeditor.capture.view.b f67271f;

    /* renamed from: h, reason: collision with root package name */
    private HashMap<Integer, ProviderView> f67272h;

    /* renamed from: i, reason: collision with root package name */
    private b f67273i;

    /* renamed from: m, reason: collision with root package name */
    private ProviderView f67274m;

    /* loaded from: classes32.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            int intValue = ((Integer) view.getTag()).intValue();
            int e16 = ProviderContainerView.this.f67271f.e(intValue);
            if (e16 == 102) {
                ProviderContainerView.this.f67273i.h();
            } else {
                ProviderContainerView.this.i(intValue);
            }
            ProviderContainerView.this.g(e16);
            if (QLog.isColorLevel()) {
                QLog.i("ProviderContainerView", 2, "onclick, index: " + intValue);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes32.dex */
    public interface b {
        void h();
    }

    public ProviderContainerView(Context context) {
        super(context);
        this.f67272h = new HashMap<>();
        this.E = new a();
        d();
    }

    private void d() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.f168771gu3, (ViewGroup) null);
        addView(inflate);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.d_b);
        this.f67269d = linearLayout;
        linearLayout.setGravity(0);
        this.f67270e = (FrameLayout) inflate.findViewById(R.id.f166550g32);
    }

    private void e(int i3) {
        ProviderView providerView;
        ProviderView providerView2 = this.f67274m;
        if (providerView2 != null) {
            providerView2.x();
            this.f67274m.setAlpha(1.0f);
            this.f67274m.setVisibility(8);
            this.f67274m = null;
        }
        if (this.f67272h.containsKey(Integer.valueOf(this.f67271f.e(i3)))) {
            providerView = this.f67272h.get(Integer.valueOf(this.f67271f.e(i3)));
        } else {
            ProviderView a16 = this.f67271f.a(getContext(), this.f67271f.e(i3));
            if (a16 != null) {
                this.f67272h.put(Integer.valueOf(this.f67271f.e(i3)), a16);
                this.f67270e.addView(a16);
            } else if (QLog.isColorLevel()) {
                QLog.e("ProviderContainerView", 2, "build provider view failed " + i3);
                return;
            }
            providerView = a16;
        }
        if (providerView != null) {
            if (!providerView.I) {
                providerView.v(null);
            }
            this.f67274m = providerView;
            providerView.setAlpha(1.0f);
            this.f67274m.setVisibility(0);
            this.f67274m.y();
        }
    }

    private void j(ImageView imageView, int i3) {
        int e16 = this.f67271f.e(i3);
        if (e16 == 100) {
            imageView.setContentDescription(HardCodeUtil.qqStr(R.string.qdo));
        } else if (e16 == 101) {
            imageView.setContentDescription(HardCodeUtil.qqStr(R.string.qds));
        }
    }

    public <T extends ProviderView> T c(Class<? extends ProviderView> cls) {
        Iterator<ProviderView> it = this.f67272h.values().iterator();
        while (it.hasNext()) {
            T t16 = (T) it.next();
            if (cls.isInstance(t16)) {
                return t16;
            }
        }
        return null;
    }

    public void f(int i3, List<Integer> list) {
        this.f67271f = new com.tencent.aelight.camera.aioeditor.capture.view.b(i3, list);
        this.f67269d.removeAllViews();
        for (int i16 = 0; i16 < this.f67271f.b(); i16++) {
            PressScaleImageView pressScaleImageView = new PressScaleImageView(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.weight = 1.0f;
            layoutParams.gravity = 16;
            pressScaleImageView.setTag(Integer.valueOf(i16));
            pressScaleImageView.setId(this.f67271f.c(i16));
            pressScaleImageView.setImageResource(this.f67271f.d(i16));
            pressScaleImageView.setScaleType(ImageView.ScaleType.CENTER);
            pressScaleImageView.setOnClickListener(this.E);
            j(pressScaleImageView, i16);
            this.f67269d.addView(pressScaleImageView, layoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = this.f67270e.getLayoutParams();
        layoutParams2.height = UIUtils.b(getContext(), 272.0f);
        this.f67270e.setLayoutParams(layoutParams2);
    }

    public void h() {
        if (this.f67272h.isEmpty()) {
            return;
        }
        Iterator<Map.Entry<Integer, ProviderView>> it = this.f67272h.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().w();
        }
    }

    public void setEditActivityEntrance(int i3) {
        this.D = i3;
    }

    public void setProviderContainViewListener(b bVar) {
        this.f67273i = bVar;
    }

    public void i(int i3) {
        if (i3 >= 0 && i3 < this.f67269d.getChildCount()) {
            View view = this.C;
            if (view != null) {
                view.setSelected(false);
            }
            View childAt = this.f67269d.getChildAt(i3);
            this.C = childAt;
            childAt.setSelected(true);
            e(i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("ProviderContainerView", 2, "doOpenProviderView failed out bounds" + i3 + " size:" + this.f67269d.getChildCount());
        }
    }

    public ProviderContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f67272h = new HashMap<>();
        this.E = new a();
        d();
    }

    public void g(int i3) {
        String str;
        if (i3 == 102) {
            str = "0X800B3D1";
        } else if (i3 == 101) {
            str = "0X800B3CD";
        } else {
            str = i3 == 100 ? "0X800B3CF" : null;
        }
        if (str != null) {
            com.tencent.mobileqq.shortvideo.c.d(str, this.D);
        }
    }

    public ProviderContainerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f67272h = new HashMap<>();
        this.E = new a();
        d();
    }
}

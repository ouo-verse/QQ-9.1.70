package com.tencent.mobileqq.poke;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.viewpager.widget.ViewPager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes16.dex */
public class NTPokeAndEmoPanel extends RelativeLayout implements ViewPager.OnPageChangeListener, View.OnClickListener {
    static IPatchRedirector $redirector_;
    private int C;
    private int D;

    /* renamed from: d, reason: collision with root package name */
    private QQViewPager f258954d;

    /* renamed from: e, reason: collision with root package name */
    private View f258955e;

    /* renamed from: f, reason: collision with root package name */
    private View f258956f;

    /* renamed from: h, reason: collision with root package name */
    private NTPokePanel f258957h;

    /* renamed from: i, reason: collision with root package name */
    private NTPEPanel f258958i;

    /* renamed from: m, reason: collision with root package name */
    private ViewGroup f258959m;

    /* loaded from: classes16.dex */
    class a extends AccessibilityDelegateCompat {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NTPokeAndEmoPanel.this);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) accessibilityNodeInfoCompat);
            } else {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.setTraversalBefore(NTPokeAndEmoPanel.this.f258956f);
            }
        }
    }

    /* loaded from: classes16.dex */
    class b extends AccessibilityDelegateCompat {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NTPokeAndEmoPanel.this);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) accessibilityNodeInfoCompat);
            } else {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.setTraversalAfter(NTPokeAndEmoPanel.this.f258955e);
            }
        }
    }

    public NTPokeAndEmoPanel(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    public ImageView c(int i3, int i16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (ImageView) iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Integer.valueOf(i16), str);
        }
        ImageButton imageButton = new ImageButton(getContext());
        imageButton.setLayoutParams(new LinearLayout.LayoutParams(x.c(MobileQQ.sMobileQQ, 50.0f), -1));
        imageButton.setId(i3);
        imageButton.setImageResource(i16);
        StateListDrawable stateListDrawable = new StateListDrawable();
        ColorDrawable colorDrawable = new ColorDrawable();
        colorDrawable.setColor(getResources().getColor(R.color.qui_common_fill_standard_primary));
        ColorDrawable colorDrawable2 = new ColorDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, colorDrawable);
        stateListDrawable.addState(new int[]{android.R.attr.state_selected}, colorDrawable);
        stateListDrawable.addState(new int[0], colorDrawable2);
        imageButton.setBackgroundDrawable(stateListDrawable);
        imageButton.setContentDescription(str);
        return imageButton;
    }

    public void d(com.tencent.aio.api.runtime.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
            return;
        }
        QQViewPager qQViewPager = (QQViewPager) findViewById(R.id.fkf);
        this.f258954d = qQViewPager;
        qQViewPager.setOnPageChangeListener(this);
        this.f258959m = (ViewGroup) findViewById(R.id.f166941ja2);
        this.f258956f = c(R.id.j_s, R.drawable.c2f, getContext().getString(R.string.f7i));
        ImageView c16 = c(R.id.j_r, R.drawable.c2g, getContext().getString(R.string.f7h));
        this.f258955e = c16;
        ViewCompat.setAccessibilityDelegate(c16, new a());
        ViewCompat.setAccessibilityDelegate(this.f258956f, new b());
        this.f258955e.setOnClickListener(this);
        this.f258956f.setOnClickListener(this);
        this.f258957h = (NTPokePanel) View.inflate(getContext(), R.layout.f167613dw0, null);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String h16 = f.h(peekAppRuntime);
        this.f258957h.p(peekAppRuntime, h16, aVar);
        this.f258957h.u(h16);
        this.f258958i = new NTPEPanel(aVar, getContext(), null, 0);
        String f16 = f.f((AppInterface) peekAppRuntime, 8);
        this.f258958i.e();
        this.f258958i.i(f16);
        ArrayList arrayList = new ArrayList();
        int g16 = f.g(peekAppRuntime, 4);
        int g17 = f.g(peekAppRuntime, 11);
        if (g16 == 1 && f.O) {
            this.C = 1;
            this.f258959m.addView(this.f258956f);
            this.f258959m.addView(this.f258955e);
            arrayList.add(this.f258958i);
            arrayList.add(this.f258957h);
            this.f258956f.setSelected(true);
            this.f258955e.setSelected(false);
            this.f258956f.setVisibility(0);
            if (g17 == 1) {
                this.f258955e.setVisibility(8);
                arrayList.remove(this.f258957h);
            }
        } else {
            this.C = 0;
            this.f258959m.addView(this.f258955e);
            this.f258959m.addView(this.f258956f);
            arrayList.add(this.f258957h);
            arrayList.add(this.f258958i);
            this.f258955e.setSelected(true);
            this.f258956f.setSelected(false);
            if (g17 == 1 || !f.O) {
                this.f258956f.setVisibility(8);
                arrayList.remove(this.f258958i);
            }
        }
        this.f258954d.setAdapter(new j(getContext(), arrayList));
        if (arrayList.size() > 1) {
            int i3 = f.M;
            this.D = i3;
            if (i3 == -1) {
                this.D = (this.C + 1) % 2;
            }
            if (this.C == 1 && this.D == 0) {
                this.f258958i.g();
            } else {
                this.f258954d.setCurrentItem(this.D);
            }
        } else if (this.C == 1) {
            this.f258958i.g();
        }
        if (QLog.isColorLevel()) {
            QLog.d("PokeAndEmoPanel", 2, String.format(" init..entryType = %d,viewType = %d,currentIndex = %d", Integer.valueOf(g16), Integer.valueOf(g17), Integer.valueOf(this.D)));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.j_r) {
                this.f258954d.setCurrentItem(this.C, true);
                view.setSelected(true);
                this.f258956f.setSelected(false);
            } else if (id5 == R.id.j_s) {
                this.f258954d.setCurrentItem((this.C + 1) % 2, true);
                view.setSelected(true);
                this.f258955e.setSelected(false);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) motionEvent)).booleanValue();
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i3, float f16, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Float.valueOf(f16), Integer.valueOf(i16));
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
            return;
        }
        if (i3 == this.C) {
            this.f258955e.setSelected(true);
            this.f258956f.setSelected(false);
        } else {
            this.f258956f.setSelected(true);
            this.f258955e.setSelected(false);
            this.f258958i.g();
            if (QLog.isColorLevel()) {
                QLog.d("PokeAndEmoPanel", 2, String.format(" onPageSelected i = %d", Integer.valueOf(i3)));
            }
        }
        this.D = i3;
        f.M = i3;
    }

    public NTPokeAndEmoPanel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public NTPokeAndEmoPanel(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }
}

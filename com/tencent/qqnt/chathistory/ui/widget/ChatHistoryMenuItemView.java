package com.tencent.qqnt.chathistory.ui.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes23.dex */
public class ChatHistoryMenuItemView extends LinearLayout implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private ArrayList<e> C;
    private ArrayList<g> D;
    private ArrayList<TextView> E;
    private ArrayList<f> F;

    /* renamed from: d, reason: collision with root package name */
    private int f353987d;

    /* renamed from: e, reason: collision with root package name */
    private int f353988e;

    /* renamed from: f, reason: collision with root package name */
    private ColorStateList f353989f;

    /* renamed from: h, reason: collision with root package name */
    private ColorStateList f353990h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f353991i;

    /* renamed from: m, reason: collision with root package name */
    private LinearLayout f353992m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class a extends AccessibilityDelegateCompat {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TextView f353993a;

        a(TextView textView) {
            this.f353993a = textView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistoryMenuItemView.this, (Object) textView);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) accessibilityNodeInfoCompat);
            } else {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.setTraversalBefore(this.f353993a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class b extends AccessibilityDelegateCompat {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TextView f353995a;

        b(TextView textView) {
            this.f353995a = textView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatHistoryMenuItemView.this, (Object) textView);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) accessibilityNodeInfoCompat);
            } else {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.setTraversalAfter(this.f353995a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class c extends AccessibilityDelegateCompat {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TextView f353997a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ TextView f353998b;

        c(TextView textView, TextView textView2) {
            this.f353997a = textView;
            this.f353998b = textView2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ChatHistoryMenuItemView.this, textView, textView2);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) accessibilityNodeInfoCompat);
                return;
            }
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setTraversalBefore(this.f353997a);
            accessibilityNodeInfoCompat.setTraversalAfter(this.f353998b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class d extends AppCompatTextView {
        static IPatchRedirector $redirector_;

        d(Context context, String str, View.OnClickListener onClickListener) {
            super(context);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, context, str, onClickListener);
                return;
            }
            setTextSize(2, 16.0f);
            setTextColor(getResources().getColorStateList(R.color.qui_common_text_link, null));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(0, 0, 0, ViewUtils.dip2px(36.0f));
            setLayoutParams(layoutParams);
            setText(str);
            setOnClickListener(onClickListener);
            setMaxLines(1);
            setEllipsize(TextUtils.TruncateAt.MARQUEE);
        }

        @Override // android.widget.TextView, android.view.View
        public CharSequence getAccessibilityClassName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (CharSequence) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return Button.class.getName();
        }

        @Override // android.widget.TextView, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) motionEvent)).booleanValue();
            }
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    setAlpha(1.0f);
                }
            } else {
                setAlpha(0.5f);
            }
            return super.onTouchEvent(motionEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class e extends LinearLayout {
        static IPatchRedirector $redirector_;

        e(Context context) {
            super(context);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
                return;
            }
            setOrientation(1);
            setGravity(1);
            setLayoutParams(new LinearLayout.LayoutParams(0, -2, 40.0f));
        }

        public static ArrayList<e> a(Context context, int i3) {
            ArrayList<e> arrayList = new ArrayList<>();
            for (int i16 = 0; i16 < i3; i16++) {
                arrayList.add(new e(context));
            }
            return arrayList;
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface f {
        void a(int i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class g extends LinearLayout {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* loaded from: classes23.dex */
        private static class a extends View {
            static IPatchRedirector $redirector_;

            a(Context context, int i3) {
                super(context);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, i3);
                    return;
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewUtils.dip2px(1.0f), ViewUtils.dip2px(18.0f));
                layoutParams.setMargins(0, ViewUtils.dip2px(2.0f), 0, ViewUtils.dip2px(38.0f));
                setLayoutParams(layoutParams);
                setBackgroundColor(i3);
            }
        }

        g(Context context, int i3, int i16) {
            super(context);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, context, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            setOrientation(1);
            setGravity(1);
            setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
            for (int i17 = 0; i17 < i3; i17++) {
                addView(new a(context, i16));
            }
        }

        public static ArrayList<g> a(Context context, int i3, ArrayList<e> arrayList, int i16) {
            ArrayList<g> arrayList2 = new ArrayList<>();
            int i17 = 0;
            while (i17 < i3 - 1) {
                i17++;
                arrayList2.add(new g(context, arrayList.get(i17).getChildCount(), i16));
            }
            return arrayList2;
        }
    }

    public ChatHistoryMenuItemView(Context context, int i3, String str, int[] iArr) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, Integer.valueOf(i3), str, iArr);
            return;
        }
        this.f353987d = i3;
        this.f353988e = iArr.length;
        e(context, str, b(iArr));
    }

    private ArrayList<String> b(int[] iArr) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i3 : iArr) {
            arrayList.add(getResources().getString(i3));
        }
        return arrayList;
    }

    private void c(Context context, String str) {
        TextView textView = new TextView(context);
        this.f353991i = textView;
        textView.setText(str);
        this.f353991i.setGravity(17);
        this.f353991i.setTextSize(2, 14.0f);
        this.f353991i.setTextColor(this.f353989f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, ViewUtils.dip2px(40.0f), 0, ViewUtils.dip2px(30.0f));
        this.f353991i.setLayoutParams(layoutParams);
        addView(this.f353991i);
    }

    private void d() {
        this.f353989f = getResources().getColorStateList(R.color.qui_common_text_secondary, null);
        this.f353990h = getResources().getColorStateList(R.color.qui_common_border_standard, null);
    }

    private void e(Context context, String str, ArrayList<String> arrayList) {
        int i3;
        int i16;
        int i17;
        setOrientation(1);
        d();
        c(context, str);
        LinearLayout linearLayout = new LinearLayout(context);
        this.f353992m = linearLayout;
        int i18 = 0;
        linearLayout.setOrientation(0);
        this.f353992m.setGravity(1);
        addView(this.f353992m);
        this.C = e.a(context, this.f353987d);
        this.E = new ArrayList<>(this.f353988e);
        for (int i19 = 0; i19 < this.f353988e; i19++) {
            d dVar = new d(context, arrayList.get(i19), this);
            this.E.add(dVar);
            this.C.get(i19 % this.f353987d).addView(dVar);
        }
        this.D = g.a(context, this.f353987d, this.C, this.f353990h.getDefaultColor());
        View view = new View(context);
        View view2 = new View(context);
        view.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 10.0f));
        view2.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 10.0f));
        this.f353992m.addView(view);
        int i26 = 0;
        while (true) {
            i3 = this.f353987d;
            if (i26 >= i3 - 1) {
                break;
            }
            this.f353992m.addView(this.C.get(i26));
            this.f353992m.addView(this.D.get(i26));
            i26++;
        }
        this.f353992m.addView(this.C.get(i3 - 1));
        this.f353992m.addView(view2);
        while (true) {
            int i27 = this.f353988e;
            if (i18 < i27) {
                if (i18 == 0 && (i17 = i18 + 1) < i27) {
                    ViewCompat.setAccessibilityDelegate(this.E.get(i18), new a(this.E.get(i17)));
                } else if (i18 == i27 - 1 && i18 - 1 >= 0) {
                    ViewCompat.setAccessibilityDelegate(this.E.get(i18), new b(this.E.get(i16)));
                } else {
                    ViewCompat.setAccessibilityDelegate(this.E.get(i18), new c(this.E.get(i18 + 1), this.E.get(i18 - 1)));
                }
                i18++;
            } else {
                return;
            }
        }
    }

    public void a(f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) fVar);
            return;
        }
        if (this.F == null) {
            this.F = new ArrayList<>();
        }
        this.F.add(fVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        } else {
            ArrayList<f> arrayList = this.F;
            if (arrayList != null) {
                Iterator<f> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().a(this.E.indexOf(view));
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}

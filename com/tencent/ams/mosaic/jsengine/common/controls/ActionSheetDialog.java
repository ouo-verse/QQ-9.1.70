package com.tencent.ams.mosaic.jsengine.common.controls;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.PathInterpolator;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.ams.mosaic.jsengine.common.controls.ActionSheetDialog;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.dom.node.TextNode;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ActionSheetDialog extends FrameLayout implements DialogInterface, AdapterView.OnItemClickListener {
    static IPatchRedirector $redirector_;
    private boolean C;
    private String D;
    private String[] E;
    private String F;
    private DialogInterface.OnClickListener G;
    private DialogInterface.OnCancelListener H;

    /* renamed from: d, reason: collision with root package name */
    private WindowManager f70826d;

    /* renamed from: e, reason: collision with root package name */
    private final View f70827e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    private final c f70828f;

    /* renamed from: h, reason: collision with root package name */
    private DialogInterface.OnDismissListener f70829h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f70830i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f70831m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ActionSheetDialog.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (ActionSheetDialog.this.f70830i) {
                ActionSheetDialog.this.cancel();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class b extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ActionSheetDialog.this);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
                return;
            }
            if (ActionSheetDialog.this.f70826d != null) {
                try {
                    ActionSheetDialog.this.f70826d.removeView(ActionSheetDialog.this);
                } catch (Throwable unused) {
                }
            }
            ActionSheetDialog.this.f70826d = null;
            if (ActionSheetDialog.this.f70829h != null) {
                ActionSheetDialog.this.f70829h.onDismiss(ActionSheetDialog.this);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animator);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animator);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class c extends LinearLayout {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        @NonNull
        TextView f70834d;

        /* renamed from: e, reason: collision with root package name */
        @NonNull
        View f70835e;

        /* renamed from: f, reason: collision with root package name */
        @NonNull
        ListView f70836f;

        /* renamed from: h, reason: collision with root package name */
        @NonNull
        TextView f70837h;

        /* renamed from: i, reason: collision with root package name */
        @NonNull
        BaseAdapter f70838i;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes3.dex */
        public class a extends BaseAdapter {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
                }
            }

            @Override // android.widget.Adapter
            public int getCount() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
                }
                if (ActionSheetDialog.this.E != null) {
                    return ActionSheetDialog.this.E.length;
                }
                return 0;
            }

            @Override // android.widget.Adapter
            public Object getItem(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
                return ActionSheetDialog.this.E[i3];
            }

            @Override // android.widget.Adapter
            public long getItemId(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, i3)).longValue();
                }
                return i3;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v4, types: [android.view.View] */
            @Override // android.widget.Adapter
            public View getView(int i3, View view, ViewGroup viewGroup) {
                TextView textView;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    textView = (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
                } else {
                    TextView textView2 = new TextView(c.this.getContext());
                    textView2.setText(ActionSheetDialog.this.E[i3]);
                    textView2.setTextSize(1, 16.0f);
                    textView2.setTextColor(-16777216);
                    textView2.setGravity(17);
                    textView2.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) MosaicUtils.j(50.0f)));
                    textView = textView2;
                }
                EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
                return textView;
            }
        }

        public c(Context context) {
            super(context);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ActionSheetDialog.this, (Object) context);
                return;
            }
            setOrientation(1);
            g(context);
            f(context);
            e(context);
            c();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ActionSheetDialog.this.cancel();
            EventCollector.getInstance().onViewClicked(view);
        }

        private void e(Context context) {
            View view = new View(context);
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) MosaicUtils.j(8.0f)));
            view.setBackgroundColor(218103808);
            addView(view);
            TextView textView = new TextView(context);
            textView.setTextSize(1, 16.0f);
            textView.setTextColor(-16777216);
            textView.setGravity(1);
            textView.setPadding(0, (int) MosaicUtils.j(15.0f), 0, (int) MosaicUtils.j(15.0f));
            textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.ams.mosaic.jsengine.common.controls.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ActionSheetDialog.c.this.b(view2);
                }
            });
            addView(textView);
            this.f70837h = textView;
        }

        private void f(Context context) {
            this.f70836f = new ListView(context);
            a aVar = new a();
            this.f70838i = aVar;
            this.f70836f.setAdapter((ListAdapter) aVar);
            this.f70836f.setDivider(new ColorDrawable(218103808));
            this.f70836f.setDividerHeight((int) MosaicUtils.j(1.0f));
            this.f70836f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            addView(this.f70836f);
        }

        private void g(Context context) {
            TextView textView = new TextView(context);
            textView.setText(ActionSheetDialog.this.D);
            textView.setTextSize(1, 14.0f);
            textView.setTextColor(-1879048192);
            textView.setGravity(17);
            textView.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) MosaicUtils.j(50.0f)));
            addView(textView);
            this.f70834d = textView;
            View view = new View(context);
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) MosaicUtils.j(1.0f)));
            view.setBackgroundColor(218103808);
            addView(view);
            this.f70835e = view;
        }

        public void c() {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            this.f70838i.notifyDataSetChanged();
            if (TextUtils.isEmpty(ActionSheetDialog.this.D)) {
                this.f70834d.setVisibility(8);
                this.f70835e.setVisibility(8);
            } else {
                this.f70834d.setText(ActionSheetDialog.this.D);
                this.f70834d.setVisibility(0);
                this.f70835e.setVisibility(0);
            }
            TextView textView = this.f70837h;
            if (!TextUtils.isEmpty(ActionSheetDialog.this.F)) {
                str = ActionSheetDialog.this.F;
            } else {
                str = "\u53d6\u6d88";
            }
            textView.setText(str);
        }

        public void d(AdapterView.OnItemClickListener onItemClickListener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) onItemClickListener);
            } else {
                this.f70836f.setOnItemClickListener(onItemClickListener);
            }
        }
    }

    public ActionSheetDialog(@NonNull Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f70830i = true;
        this.f70831m = true;
        this.C = false;
        this.f70827e = new View(context);
        m(context);
        c cVar = new c(context);
        this.f70828f = cVar;
        n();
        this.f70826d = i(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        addView(cVar, layoutParams);
    }

    private Drawable h() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        float j3 = MosaicUtils.j(12.0f);
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadii(new float[]{j3, j3, j3, j3, 0.0f, 0.0f, 0.0f, 0.0f});
        return gradientDrawable;
    }

    private WindowManager i(Context context) {
        return (WindowManager) context.getSystemService("window");
    }

    private WindowManager.LayoutParams j() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -1, 99, 256, -2);
        if (Build.VERSION.SDK_INT >= 28) {
            layoutParams.layoutInDisplayCutoutMode = 1;
        }
        return layoutParams;
    }

    private void k() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f70828f, "translationY", 0.0f, r0.getHeight());
        ofFloat.setInterpolator(new PathInterpolator(0.39f, 0.0f, 0.95f, 0.44f));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f70828f, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.setDuration(200L);
        animatorSet.start();
        animatorSet.addListener(new b());
    }

    private void l() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f70827e, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        ofFloat.setDuration(200L);
        ofFloat.start();
    }

    private void m(Context context) {
        this.f70827e.setBackgroundColor(TextNode.DEFAULT_TEXT_SHADOW_COLOR);
        this.f70827e.setOnClickListener(new a());
        addView(this.f70827e, new FrameLayout.LayoutParams(-1, -1));
    }

    private void n() {
        this.f70828f.setBackground(h());
        this.f70828f.d(this);
    }

    private void r() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f70828f, "translationY", 200.0f, 0.0f);
        ofFloat.setInterpolator(new PathInterpolator(0.04f, 0.75f, 0.63f, 1.0f));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f70828f, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.setDuration(270L);
        animatorSet.start();
    }

    private void s() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f70827e, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        ofFloat.setDuration(270L);
        ofFloat.start();
    }

    @Override // android.content.DialogInterface
    public void cancel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        dismiss();
        DialogInterface.OnCancelListener onCancelListener = this.H;
        if (onCancelListener != null) {
            onCancelListener.onCancel(this);
        }
    }

    @Override // android.content.DialogInterface
    public void dismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else if (this.C) {
            this.C = false;
            k();
            l();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) keyEvent)).booleanValue();
        }
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1 && this.f70831m) {
            cancel();
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public ActionSheetDialog o(String str, String[] strArr, String str2, DialogInterface.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ActionSheetDialog) iPatchRedirector.redirect((short) 2, this, str, strArr, str2, onClickListener);
        }
        this.D = str;
        this.E = strArr;
        this.F = str2;
        this.G = onClickListener;
        this.f70828f.c();
        return this;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3));
        } else {
            DialogInterface.OnClickListener onClickListener = this.G;
            if (onClickListener != null) {
                onClickListener.onClick(this, i3);
            }
            dismiss();
        }
        EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
    }

    public ActionSheetDialog p(DialogInterface.OnCancelListener onCancelListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ActionSheetDialog) iPatchRedirector.redirect((short) 3, (Object) this, (Object) onCancelListener);
        }
        this.H = onCancelListener;
        return this;
    }

    public boolean q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (this.f70826d != null) {
            try {
                this.f70826d.addView(this, j());
                r();
                s();
                this.C = true;
                return true;
            } catch (Throwable th5) {
                com.tencent.ams.mosaic.utils.f.c("ActionSheetDialog", "show failed", th5);
                return false;
            }
        }
        com.tencent.ams.mosaic.utils.f.h("ActionSheetDialog", "show failed: windowManager is null");
        return false;
    }

    public void setCancelable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        } else {
            this.f70831m = z16;
        }
    }

    public void setCanceledOnTouchOutside(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
        } else {
            this.f70830i = z16;
        }
    }

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) onDismissListener);
        } else {
            this.f70829h = onDismissListener;
        }
    }
}

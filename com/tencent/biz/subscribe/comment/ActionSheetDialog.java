package com.tencent.biz.subscribe.comment;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ActionSheetDialog extends p implements DialogInterface.OnCancelListener, Animation.AnimationListener {
    private TextView D;
    private Button E;
    protected Context F;
    protected Context G;
    protected Context H;
    private LinearLayout I;
    private LinearLayout J;
    private View K;
    private Handler L;
    private int M;
    private ArrayList<Button> N;
    private View.OnClickListener P;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ActionSheetDialog.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public ActionSheetDialog(Context context) {
        this(context, (Context) null);
    }

    private void Y() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, this.J.getHeight());
        translateAnimation.setFillAfter(true);
        translateAnimation.setInterpolator(AnimationUtils.loadInterpolator(this.F, R.anim.decelerate_interpolator));
        translateAnimation.setDuration(200L);
        this.J.startAnimation(translateAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setDuration(200L);
        this.K.startAnimation(alphaAnimation);
        alphaAnimation.setAnimationListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, this.J.getHeight(), 0.0f);
        translateAnimation.setFillAfter(true);
        translateAnimation.setInterpolator(AnimationUtils.loadInterpolator(this.F, R.anim.decelerate_interpolator));
        translateAnimation.setDuration(200L);
        this.J.startAnimation(translateAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setDuration(200L);
        this.K.startAnimation(alphaAnimation);
    }

    private void bindEvents() {
        this.E.setOnClickListener(new a());
        this.L = new Handler(Looper.getMainLooper());
    }

    private void init() {
        this.I = (LinearLayout) findViewById(com.tencent.mobileqq.R.id.bcv);
        this.J = (LinearLayout) findViewById(com.tencent.mobileqq.R.id.ejb);
        Button button = (Button) findViewById(com.tencent.mobileqq.R.id.f163910c3);
        this.E = button;
        button.setDrawingCacheEnabled(false);
        this.K = findViewById(com.tencent.mobileqq.R.id.a4f);
        TextView textView = (TextView) findViewById(com.tencent.mobileqq.R.id.title);
        this.D = textView;
        textView.setVisibility(8);
        this.D.setText("");
    }

    public Button W(int i3, String str, int i16, View.OnClickListener onClickListener) {
        Button addButton = addButton(str, i16, onClickListener);
        addButton.setId(i3);
        return addButton;
    }

    public void X(final String str) {
        this.E.post(new Runnable() { // from class: com.tencent.biz.subscribe.comment.ActionSheetDialog.4
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(str)) {
                    ActionSheetDialog.this.E.setText("");
                    ActionSheetDialog.this.E.setVisibility(8);
                } else {
                    ActionSheetDialog.this.E.setText(str);
                    ActionSheetDialog.this.E.setVisibility(0);
                }
            }
        });
    }

    public Button addButton(String str, int i3, View.OnClickListener onClickListener) {
        int color;
        Button button = new Button(this.F);
        this.I.addView(button);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = (int) this.F.getResources().getDimension(com.tencent.mobileqq.R.dimen.f159123wa);
        layoutParams.bottomMargin = (int) this.F.getResources().getDimension(com.tencent.mobileqq.R.dimen.f158571ja);
        layoutParams.gravity = 17;
        button.setLayoutParams(layoutParams);
        button.setText(str);
        int i16 = com.tencent.mobileqq.R.drawable.f160431h5;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            color = this.H.getResources().getColor(com.tencent.mobileqq.R.color.f156737af);
                        } else {
                            color = -14833678;
                        }
                    } else {
                        color = this.H.getResources().getColor(com.tencent.mobileqq.R.color.alq);
                        button.setTypeface(Typeface.defaultFromStyle(1));
                    }
                } else {
                    int f16 = BaseAIOUtils.f(8.0f, getContext().getResources());
                    SpannableString spannableString = new SpannableString(button.getText());
                    Drawable drawable = this.F.getResources().getDrawable(com.tencent.mobileqq.R.drawable.cqf);
                    drawable.setBounds(f16, 0, drawable.getIntrinsicWidth() + f16, drawable.getIntrinsicHeight());
                    spannableString.setSpan(new ImageSpan(drawable, 1), spannableString.length() - 1, spannableString.length(), 33);
                    button.setText(spannableString);
                    color = -16777216;
                }
            } else {
                color = -14207157;
                i16 = com.tencent.mobileqq.R.drawable.f160429h3;
            }
        } else {
            color = this.H.getResources().getColor(com.tencent.mobileqq.R.color.f157924ab3);
        }
        button.setBackgroundDrawable(this.H.getResources().getDrawable(i16));
        button.setTextColor(color);
        button.setTextSize(16.0f);
        button.setOnClickListener(onClickListener);
        this.M++;
        this.N.add(button);
        return button;
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Y();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        super.dismiss();
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        View.OnClickListener onClickListener = this.P;
        if (onClickListener != null) {
            try {
                onClickListener.onClick(null);
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 82) {
            dismiss();
        }
        return super.onKeyDown(i3, keyEvent);
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            dismiss();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setTitle(final String str) {
        this.D.post(new Runnable() { // from class: com.tencent.biz.subscribe.comment.ActionSheetDialog.3
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(str)) {
                    ActionSheetDialog.this.D.setText("");
                    ActionSheetDialog.this.D.setVisibility(8);
                } else {
                    ActionSheetDialog.this.D.setText(str);
                    ActionSheetDialog.this.D.setVisibility(0);
                }
            }
        });
    }

    @Override // com.tencent.biz.subscribe.comment.p, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        if (isShowing()) {
            return;
        }
        Context context = this.F;
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return;
        }
        super.show();
        this.J.setVisibility(4);
        this.K.setVisibility(4);
        this.L.postDelayed(new Runnable() { // from class: com.tencent.biz.subscribe.comment.ActionSheetDialog.1
            @Override // java.lang.Runnable
            public void run() {
                ActionSheetDialog.this.J.setVisibility(0);
                ActionSheetDialog.this.K.setVisibility(0);
                ActionSheetDialog.this.Z();
            }
        }, 0L);
    }

    public ActionSheetDialog(Context context, Context context2) {
        super(context, com.tencent.mobileqq.R.style.f173747jj);
        this.M = 0;
        this.N = new ArrayList<>();
        this.P = null;
        this.F = context;
        this.G = context2;
        if (context2 != null) {
            this.H = context2;
        } else {
            this.H = context;
        }
        setContentView(LayoutInflater.from(this.H).inflate(com.tencent.mobileqq.R.layout.f167713et, (ViewGroup) null));
        init();
        bindEvents();
    }

    public ActionSheetDialog(Context context, boolean z16, boolean z17) {
        this(context, z17 ? com.tencent.mobileqq.R.style.f173746ji : z16 ? com.tencent.mobileqq.R.style.f173747jj : com.tencent.mobileqq.R.style.f173745jh);
    }

    public ActionSheetDialog(Context context, int i3) {
        super(context, i3);
        this.M = 0;
        this.N = new ArrayList<>();
        this.P = null;
        this.F = context;
        this.H = context;
        setContentView(com.tencent.mobileqq.R.layout.f167713et);
        init();
        bindEvents();
        N();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}

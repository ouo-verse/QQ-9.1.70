package com.tencent.mtt.hippy.a;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.ams.dsdk.view.webview.DKWebViewController;
import com.tencent.mtt.hippy.common.HippyJsException;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class c extends ReportDialog implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private TextView f336946a;

    /* renamed from: b, reason: collision with root package name */
    private TextView f336947b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f336948c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f336949d;

    /* renamed from: e, reason: collision with root package name */
    private a f336950e;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
        void a();
    }

    public c(Context context) {
        super(context);
        setCanceledOnTouchOutside(false);
        b();
    }

    private void b() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(PixelUtil.dp2px(8.0f));
        linearLayout.setBackgroundDrawable(gradientDrawable);
        linearLayout.setOrientation(1);
        this.f336946a = new TextView(getContext());
        int dp2px = (int) PixelUtil.dp2px(12.0f);
        this.f336946a.setPadding(dp2px, dp2px, dp2px, dp2px);
        this.f336946a.setTextSize(16.0f);
        this.f336946a.setGravity(1);
        this.f336946a.setTextColor(-16777216);
        linearLayout.addView(this.f336946a, new LinearLayout.LayoutParams(-1, -2));
        ScrollView scrollView = new ScrollView(getContext());
        scrollView.setVerticalScrollBarEnabled(false);
        TextView textView = new TextView(getContext());
        this.f336947b = textView;
        textView.setGravity(17);
        this.f336947b.setTextSize(12.0f);
        this.f336947b.setTextColor(Color.parseColor("#424242"));
        scrollView.addView(this.f336947b);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.gravity = 1;
        layoutParams.leftMargin = (int) PixelUtil.dp2px(40.0f);
        layoutParams.rightMargin = (int) PixelUtil.dp2px(40.0f);
        layoutParams.bottomMargin = (int) PixelUtil.dp2px(30.0f);
        layoutParams.weight = 1.0f;
        linearLayout.addView(scrollView, layoutParams);
        View view = new View(getContext());
        view.setBackgroundColor(Color.parseColor("#f3f3f3"));
        linearLayout.addView(view, new LinearLayout.LayoutParams(-1, (int) PixelUtil.dp2px(1.0f)));
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(0);
        linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, (int) PixelUtil.dp2px(50.0f)));
        TextView textView2 = new TextView(getContext());
        this.f336948c = textView2;
        textView2.setGravity(17);
        this.f336948c.setTextSize(12.0f);
        this.f336948c.setTextColor(-16776961);
        this.f336948c.setFocusable(true);
        this.f336948c.setText(DKWebViewController.DKHippyWebviewFunction.RELOAD);
        this.f336948c.setOnClickListener(this);
        this.f336948c.setBackgroundDrawable(a());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1);
        layoutParams2.weight = 1.0f;
        linearLayout2.addView(this.f336948c, layoutParams2);
        View view2 = new View(getContext());
        view2.setBackgroundColor(Color.parseColor("#f3f3f3"));
        linearLayout2.addView(view2, new LinearLayout.LayoutParams((int) PixelUtil.dp2px(1.0f), -1));
        TextView textView3 = new TextView(getContext());
        this.f336949d = textView3;
        textView3.setGravity(17);
        this.f336949d.setTextSize(12.0f);
        this.f336949d.setText("cancel");
        this.f336949d.setFocusable(true);
        this.f336949d.setOnClickListener(this);
        this.f336949d.setTextColor(Color.parseColor("#a1a1a1"));
        this.f336949d.setBackgroundDrawable(a());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        linearLayout2.addView(this.f336949d, layoutParams3);
        setContentView(linearLayout);
    }

    StateListDrawable a() {
        int[] iArr = {R.attr.state_focused, R.attr.state_enabled};
        int parseColor = Color.parseColor("#ffddd9d9");
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(iArr, new ColorDrawable(parseColor));
        stateListDrawable.addState(new int[0], new ColorDrawable(0));
        return stateListDrawable;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.f336949d) {
            dismiss();
        } else if (view == this.f336948c && this.f336950e != null) {
            dismiss();
            this.f336950e.a();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
    }

    public void a(a aVar) {
        this.f336950e = aVar;
    }

    public void a(Throwable th5) {
        TextView textView;
        String sb5;
        this.f336946a.setText(th5.getMessage());
        if (th5 instanceof HippyJsException) {
            textView = this.f336947b;
            sb5 = ((HippyJsException) th5).getStack();
        } else {
            StackTraceElement[] stackTrace = th5.getStackTrace();
            StringBuilder sb6 = new StringBuilder();
            for (StackTraceElement stackTraceElement : stackTrace) {
                sb6.append(stackTraceElement.toString());
                sb6.append("\n");
                sb6.append("\n");
            }
            for (StackTraceElement stackTraceElement2 : stackTrace) {
                sb6.append(stackTraceElement2.toString());
                sb6.append("\n");
                sb6.append("\n");
            }
            textView = this.f336947b;
            sb5 = sb6.toString();
        }
        textView.setText(sb5);
        th5.printStackTrace();
        this.f336947b.setGravity(3);
    }
}

package com.tx.x2j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.troop.troopnotification.render.richtext.TroopNotificationRichTextView;
import ty4.a;
import ty4.c;
import ty4.d;

/* compiled from: P */
/* loaded from: classes27.dex */
public class QbGroupNotificationListDefaultItemBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public RelativeLayout f387490a;

    /* renamed from: b, reason: collision with root package name */
    public QQProAvatarView f387491b;

    /* renamed from: c, reason: collision with root package name */
    public TroopNotificationRichTextView f387492c;

    /* renamed from: d, reason: collision with root package name */
    public ImageView f387493d;

    /* renamed from: e, reason: collision with root package name */
    public ViewStub f387494e;

    /* renamed from: f, reason: collision with root package name */
    public LinearLayout f387495f;

    /* renamed from: g, reason: collision with root package name */
    public ViewStub f387496g;

    /* renamed from: h, reason: collision with root package name */
    public FrameLayout f387497h;

    /* renamed from: i, reason: collision with root package name */
    public QUIButton f387498i;

    /* renamed from: j, reason: collision with root package name */
    public TextView f387499j;

    /* renamed from: k, reason: collision with root package name */
    public View f387500k;

    @Override // ty4.c
    protected void a(Context context, Resources resources, DisplayMetrics displayMetrics, ViewGroup.LayoutParams layoutParams) {
        layoutParams.width = -1;
    }

    @Override // ty4.c
    protected void b(Context context, Resources resources, DisplayMetrics displayMetrics, AbsListView.LayoutParams layoutParams) {
        layoutParams.width = -1;
    }

    @Override // ty4.c
    protected void c(Context context, Resources resources, DisplayMetrics displayMetrics, FrameLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
    }

    @Override // ty4.c
    protected void d(Context context, Resources resources, DisplayMetrics displayMetrics, LinearLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
    }

    @Override // ty4.c
    protected void e(Context context, Resources resources, DisplayMetrics displayMetrics, RadioGroup.LayoutParams layoutParams) {
        layoutParams.width = -1;
    }

    @Override // ty4.c
    protected void f(Context context, Resources resources, DisplayMetrics displayMetrics, RelativeLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
    }

    @Override // ty4.c
    protected void g(Context context, Resources resources, DisplayMetrics displayMetrics, ConstraintLayout.LayoutParams layoutParams) {
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
        layoutParams.validate();
    }

    @Override // ty4.c
    protected void h(Context context, Resources resources, DisplayMetrics displayMetrics, RecyclerView.LayoutParams layoutParams) {
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
    }

    @Override // ty4.c
    @SuppressLint({"NewApi"})
    public View i(Context context) {
        Log.d("X2J_APT", "createView " + getClass().getName());
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        RelativeLayout relativeLayout = new RelativeLayout(context, null);
        this.f387490a = relativeLayout;
        this.f387500k = relativeLayout;
        relativeLayout.setId(R.id.root);
        d.e(this.f387490a);
        this.f387490a.setBackground(context.getResources().getDrawable(R.drawable.qui_common_fill_light_primary_bg_selector));
        this.f387490a.setPadding((int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f), (int) (TypedValue.applyDimension(1, 8.0f, displayMetrics) + 0.5f), (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f), (int) (TypedValue.applyDimension(1, 8.0f, displayMetrics) + 0.5f));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.width = (int) (TypedValue.applyDimension(1, 52.0f, displayMetrics) + 0.5f);
        layoutParams.height = (int) (TypedValue.applyDimension(1, 52.0f, displayMetrics) + 0.5f);
        QQProAvatarView qQProAvatarView = new QQProAvatarView(context, null);
        this.f387491b = qQProAvatarView;
        qQProAvatarView.setId(R.id.f103075zm);
        this.f387490a.addView(this.f387491b, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.width = -1;
        layoutParams2.addRule(1, R.id.f103075zm);
        layoutParams2.addRule(0, R.id.f103095zo);
        layoutParams2.leftMargin = (int) (TypedValue.applyDimension(1, 12.0f, displayMetrics) + 0.5f);
        LinearLayout linearLayout = new LinearLayout(context, null);
        linearLayout.setOrientation(1);
        this.f387490a.addView(linearLayout, layoutParams2);
        ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        LinearLayout linearLayout2 = new LinearLayout(context, null);
        linearLayout2.setOrientation(0);
        linearLayout.addView(linearLayout2, layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.height = (int) (TypedValue.applyDimension(1, 24.0f, displayMetrics) + 0.5f);
        layoutParams4.gravity = 17;
        TroopNotificationRichTextView troopNotificationRichTextView = new TroopNotificationRichTextView(context, null);
        this.f387492c = troopNotificationRichTextView;
        troopNotificationRichTextView.setId(R.id.f1033760f);
        linearLayout2.addView(this.f387492c, layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.width = (int) (TypedValue.applyDimension(1, 14.0f, displayMetrics) + 0.5f);
        layoutParams5.height = (int) (TypedValue.applyDimension(1, 14.0f, displayMetrics) + 0.5f);
        layoutParams5.leftMargin = (int) (TypedValue.applyDimension(1, 3.0f, displayMetrics) + 0.5f);
        layoutParams5.topMargin = (int) (TypedValue.applyDimension(1, 6.0f, displayMetrics) + 0.5f);
        ImageView imageView = new ImageView(context, null);
        this.f387493d = imageView;
        imageView.setId(R.id.f767642j);
        this.f387493d.setVisibility(8);
        this.f387493d.setImageDrawable(context.getResources().getDrawable(R.drawable.qq_troop_bot_icon));
        linearLayout2.addView(this.f387493d, layoutParams5);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.width = -1;
        layoutParams6.height = (int) (TypedValue.applyDimension(1, 18.0f, displayMetrics) + 0.5f);
        layoutParams6.topMargin = (int) (TypedValue.applyDimension(1, 4.0f, displayMetrics) + 0.5f);
        ViewStub viewStub = new ViewStub(context, (AttributeSet) null);
        this.f387494e = viewStub;
        viewStub.setLayoutResource(R.layout.fvf);
        this.f387494e.setLayoutInflater(new a(this.f387494e.getContext(), new QbGroupNotificationMemberTagBinding()));
        this.f387494e.setId(R.id.f103045zj);
        this.f387494e.setVisibility(8);
        linearLayout.addView(this.f387494e, layoutParams6);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams7.width = -1;
        layoutParams7.topMargin = (int) (TypedValue.applyDimension(1, 4.0f, displayMetrics) + 0.5f);
        LinearLayout linearLayout3 = new LinearLayout(context, null);
        this.f387495f = linearLayout3;
        linearLayout3.setId(R.id.f10326605);
        this.f387495f.setOrientation(1);
        linearLayout.addView(this.f387495f, layoutParams7);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams8.width = -1;
        layoutParams8.topMargin = (int) (TypedValue.applyDimension(1, 4.0f, displayMetrics) + 0.5f);
        ViewStub viewStub2 = new ViewStub(context, (AttributeSet) null);
        this.f387496g = viewStub2;
        viewStub2.setLayoutResource(R.layout.fvc);
        this.f387496g.setLayoutInflater(new a(this.f387496g.getContext(), new QbGroupNotificationDoubtTipsBinding()));
        this.f387496g.setId(R.id.f103135zs);
        linearLayout.addView(this.f387496g, layoutParams8);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams9.addRule(11, -1);
        layoutParams9.addRule(15, -1);
        layoutParams9.leftMargin = (int) (TypedValue.applyDimension(1, 12.0f, displayMetrics) + 0.5f);
        FrameLayout frameLayout = new FrameLayout(context, null);
        this.f387497h = frameLayout;
        frameLayout.setId(R.id.f103095zo);
        this.f387490a.addView(this.f387497h, layoutParams9);
        FrameLayout.LayoutParams layoutParams10 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams10.height = (int) (TypedValue.applyDimension(1, 29.0f, displayMetrics) + 0.5f);
        layoutParams10.gravity = 17;
        QUIButton qUIButton = new QUIButton(context, null);
        this.f387498i = qUIButton;
        qUIButton.setTextSize(0, (int) resources.getDimension(R.dimen.d_6));
        this.f387498i.setId(R.id.f10328607);
        this.f387498i.setMinimumWidth((int) (TypedValue.applyDimension(1, 0.0f, displayMetrics) + 0.5f));
        this.f387498i.setGravity(17);
        this.f387498i.setVisibility(8);
        this.f387498i.setMinimumHeight((int) resources.getDimension(R.dimen.d_2));
        this.f387498i.setPadding((int) resources.getDimension(R.dimen.d_4), 0, (int) resources.getDimension(R.dimen.d_5), 0);
        this.f387498i.setSizeType(2);
        this.f387498i.setType(1);
        this.f387497h.addView(this.f387498i, layoutParams10);
        FrameLayout.LayoutParams layoutParams11 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams11.height = (int) (TypedValue.applyDimension(1, 29.0f, displayMetrics) + 0.5f);
        layoutParams11.gravity = 17;
        TextView textView = new TextView(context, null);
        this.f387499j = textView;
        textView.setId(R.id.f103195zy);
        this.f387499j.setTextSize(0, (int) (TypedValue.applyDimension(2, 14.0f, displayMetrics) + 0.5f));
        this.f387499j.setMaxLines(1);
        this.f387499j.setGravity(17);
        this.f387499j.setVisibility(8);
        this.f387499j.setTextColor(resources.getColor(R.color.qui_common_text_secondary));
        this.f387499j.setPadding((int) (TypedValue.applyDimension(1, 12.0f, displayMetrics) + 0.5f), 0, (int) (TypedValue.applyDimension(1, 12.0f, displayMetrics) + 0.5f), 0);
        this.f387497h.addView(this.f387499j, layoutParams11);
        return this.f387490a;
    }

    public View u() {
        return this.f387500k;
    }
}

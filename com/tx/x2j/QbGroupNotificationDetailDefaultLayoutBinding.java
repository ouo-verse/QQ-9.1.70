package com.tx.x2j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
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
import android.widget.ScrollView;
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
public class QbGroupNotificationDetailDefaultLayoutBinding extends c {
    public View A;

    /* renamed from: a, reason: collision with root package name */
    public RelativeLayout f387462a;

    /* renamed from: b, reason: collision with root package name */
    public QQProAvatarView f387463b;

    /* renamed from: c, reason: collision with root package name */
    public LinearLayout f387464c;

    /* renamed from: d, reason: collision with root package name */
    public TroopNotificationRichTextView f387465d;

    /* renamed from: e, reason: collision with root package name */
    public ImageView f387466e;

    /* renamed from: f, reason: collision with root package name */
    public LinearLayout f387467f;

    /* renamed from: g, reason: collision with root package name */
    public TextView f387468g;

    /* renamed from: h, reason: collision with root package name */
    public TextView f387469h;

    /* renamed from: i, reason: collision with root package name */
    public TextView f387470i;

    /* renamed from: j, reason: collision with root package name */
    public View f387471j;

    /* renamed from: k, reason: collision with root package name */
    public ImageView f387472k;

    /* renamed from: l, reason: collision with root package name */
    public TextView f387473l;

    /* renamed from: m, reason: collision with root package name */
    public LinearLayout f387474m;

    /* renamed from: n, reason: collision with root package name */
    public TextView f387475n;

    /* renamed from: o, reason: collision with root package name */
    public LinearLayout f387476o;

    /* renamed from: p, reason: collision with root package name */
    public LinearLayout f387477p;

    /* renamed from: q, reason: collision with root package name */
    public TextView f387478q;

    /* renamed from: r, reason: collision with root package name */
    public TroopNotificationRichTextView f387479r;

    /* renamed from: s, reason: collision with root package name */
    public ViewStub f387480s;

    /* renamed from: t, reason: collision with root package name */
    public QUIButton f387481t;

    /* renamed from: u, reason: collision with root package name */
    public LinearLayout f387482u;

    /* renamed from: v, reason: collision with root package name */
    public QUIButton f387483v;

    /* renamed from: w, reason: collision with root package name */
    public QUIButton f387484w;

    /* renamed from: x, reason: collision with root package name */
    public LinearLayout f387485x;

    /* renamed from: y, reason: collision with root package name */
    public TextView f387486y;

    /* renamed from: z, reason: collision with root package name */
    public TextView f387487z;

    @Override // ty4.c
    protected void a(Context context, Resources resources, DisplayMetrics displayMetrics, ViewGroup.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = -1;
    }

    @Override // ty4.c
    protected void b(Context context, Resources resources, DisplayMetrics displayMetrics, AbsListView.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = -1;
    }

    @Override // ty4.c
    protected void c(Context context, Resources resources, DisplayMetrics displayMetrics, FrameLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = -1;
    }

    @Override // ty4.c
    protected void d(Context context, Resources resources, DisplayMetrics displayMetrics, LinearLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = -1;
    }

    @Override // ty4.c
    protected void e(Context context, Resources resources, DisplayMetrics displayMetrics, RadioGroup.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = -1;
    }

    @Override // ty4.c
    protected void f(Context context, Resources resources, DisplayMetrics displayMetrics, RelativeLayout.LayoutParams layoutParams) {
        layoutParams.width = -1;
        layoutParams.height = -1;
    }

    @Override // ty4.c
    protected void g(Context context, Resources resources, DisplayMetrics displayMetrics, ConstraintLayout.LayoutParams layoutParams) {
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = -1;
        layoutParams.validate();
    }

    @Override // ty4.c
    protected void h(Context context, Resources resources, DisplayMetrics displayMetrics, RecyclerView.LayoutParams layoutParams) {
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = -1;
    }

    @Override // ty4.c
    @SuppressLint({"NewApi"})
    public View i(Context context) {
        Log.d("X2J_APT", "createView " + getClass().getName());
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        ScrollView scrollView = new ScrollView(context, null);
        this.A = scrollView;
        scrollView.setFillViewport(true);
        scrollView.setPadding((int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f), 0, (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f), 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.width = -1;
        layoutParams.height = -1;
        FrameLayout frameLayout = new FrameLayout(context, null);
        scrollView.addView(frameLayout, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.width = -1;
        LinearLayout linearLayout = new LinearLayout(context, null);
        linearLayout.setOrientation(1);
        frameLayout.addView(linearLayout, layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.width = -1;
        layoutParams3.topMargin = (int) (TypedValue.applyDimension(1, 20.0f, displayMetrics) + 0.5f);
        RelativeLayout relativeLayout = new RelativeLayout(context, null);
        this.f387462a = relativeLayout;
        relativeLayout.setId(R.id.f10324603);
        d.e(this.f387462a);
        this.f387462a.setBackground(context.getResources().getDrawable(R.drawable.qui_common_fill_light_secondary_bg_corner_8));
        this.f387462a.setPadding((int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f), (int) (TypedValue.applyDimension(1, 12.0f, displayMetrics) + 0.5f), (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f), (int) (TypedValue.applyDimension(1, 12.0f, displayMetrics) + 0.5f));
        linearLayout.addView(this.f387462a, layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.width = (int) (TypedValue.applyDimension(1, 52.0f, displayMetrics) + 0.5f);
        layoutParams4.height = (int) (TypedValue.applyDimension(1, 52.0f, displayMetrics) + 0.5f);
        QQProAvatarView qQProAvatarView = new QQProAvatarView(context, null);
        this.f387463b = qQProAvatarView;
        qQProAvatarView.setId(R.id.f103075zm);
        this.f387462a.addView(this.f387463b, layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.width = -1;
        layoutParams5.height = (int) (TypedValue.applyDimension(1, 52.0f, displayMetrics) + 0.5f);
        layoutParams5.addRule(1, R.id.f103075zm);
        layoutParams5.addRule(0, R.id.f103065zl);
        layoutParams5.leftMargin = (int) (TypedValue.applyDimension(1, 12.0f, displayMetrics) + 0.5f);
        LinearLayout linearLayout2 = new LinearLayout(context, null);
        linearLayout2.setGravity(16);
        linearLayout2.setOrientation(1);
        this.f387462a.addView(linearLayout2, layoutParams5);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.width = -1;
        LinearLayout linearLayout3 = new LinearLayout(context, null);
        this.f387464c = linearLayout3;
        linearLayout3.setId(R.id.f1033660e);
        this.f387464c.setOrientation(0);
        linearLayout2.addView(this.f387464c, layoutParams6);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams7.height = (int) (TypedValue.applyDimension(1, 24.0f, displayMetrics) + 0.5f);
        layoutParams7.gravity = 17;
        TroopNotificationRichTextView troopNotificationRichTextView = new TroopNotificationRichTextView(context, null);
        this.f387465d = troopNotificationRichTextView;
        troopNotificationRichTextView.setId(R.id.f1033760f);
        this.f387464c.addView(this.f387465d, layoutParams7);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams8.width = (int) (TypedValue.applyDimension(1, 14.0f, displayMetrics) + 0.5f);
        layoutParams8.height = (int) (TypedValue.applyDimension(1, 14.0f, displayMetrics) + 0.5f);
        layoutParams8.leftMargin = (int) (TypedValue.applyDimension(1, 3.0f, displayMetrics) + 0.5f);
        layoutParams8.topMargin = (int) (TypedValue.applyDimension(1, 6.0f, displayMetrics) + 0.5f);
        ImageView imageView = new ImageView(context, null);
        this.f387466e = imageView;
        imageView.setId(R.id.f767642j);
        this.f387466e.setVisibility(8);
        this.f387466e.setImageDrawable(context.getResources().getDrawable(R.drawable.qq_troop_bot_icon));
        this.f387464c.addView(this.f387466e, layoutParams8);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams9.width = -1;
        layoutParams9.topMargin = (int) (TypedValue.applyDimension(1, 3.0f, displayMetrics) + 0.5f);
        LinearLayout linearLayout4 = new LinearLayout(context, null);
        this.f387467f = linearLayout4;
        linearLayout4.setId(R.id.f1034160j);
        this.f387467f.setOrientation(0);
        this.f387467f.setPadding(0, (int) (TypedValue.applyDimension(1, 5.0f, displayMetrics) + 0.5f), 0, 0);
        linearLayout2.addView(this.f387467f, layoutParams9);
        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams10.rightMargin = (int) (TypedValue.applyDimension(1, 10.0f, displayMetrics) + 0.5f);
        TextView textView = new TextView(context, null);
        this.f387468g = textView;
        textView.setId(R.id.f1034060i);
        this.f387468g.setTextSize(0, (int) (TypedValue.applyDimension(1, 17.0f, displayMetrics) + 0.5f));
        this.f387468g.setEllipsize(TextUtils.TruncateAt.END);
        this.f387468g.setMaxWidth((int) (TypedValue.applyDimension(1, 120.0f, displayMetrics) + 0.5f));
        this.f387468g.setMaxLines(1);
        this.f387468g.setDuplicateParentStateEnabled(true);
        this.f387468g.setIncludeFontPadding(false);
        this.f387468g.setTextColor(resources.getColor(R.color.qui_common_text_secondary));
        this.f387467f.addView(this.f387468g, layoutParams10);
        LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams11.rightMargin = (int) (TypedValue.applyDimension(1, 20.0f, displayMetrics) + 0.5f);
        TextView textView2 = new TextView(context, null);
        this.f387469h = textView2;
        textView2.setId(R.id.f1033860g);
        this.f387469h.setTextSize(0, (int) (TypedValue.applyDimension(1, 17.0f, displayMetrics) + 0.5f));
        this.f387469h.setEllipsize(TextUtils.TruncateAt.END);
        this.f387469h.setMaxWidth((int) (TypedValue.applyDimension(1, 120.0f, displayMetrics) + 0.5f));
        this.f387469h.setMaxLines(1);
        this.f387469h.setDuplicateParentStateEnabled(true);
        this.f387469h.setIncludeFontPadding(false);
        this.f387469h.setTextColor(resources.getColor(R.color.qui_common_text_secondary));
        this.f387467f.addView(this.f387469h, layoutParams11);
        LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(-2, -2);
        TextView textView3 = new TextView(context, null);
        this.f387470i = textView3;
        textView3.setId(R.id.f1033960h);
        this.f387470i.setTextSize(0, (int) (TypedValue.applyDimension(1, 15.0f, displayMetrics) + 0.5f));
        this.f387470i.setEllipsize(TextUtils.TruncateAt.END);
        this.f387470i.setMaxLines(1);
        this.f387470i.setVisibility(8);
        this.f387470i.setDuplicateParentStateEnabled(true);
        this.f387470i.setIncludeFontPadding(false);
        this.f387470i.setTextColor(resources.getColor(R.color.qui_common_text_secondary));
        this.f387467f.addView(this.f387470i, layoutParams12);
        RelativeLayout.LayoutParams layoutParams13 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams13.width = -1;
        layoutParams13.height = (int) (TypedValue.applyDimension(0, 1.0f, displayMetrics) + 0.5f);
        layoutParams13.addRule(3, R.id.f103075zm);
        layoutParams13.topMargin = (int) (TypedValue.applyDimension(1, 12.0f, displayMetrics) + 0.5f);
        View view = new View(context, null);
        this.f387471j = view;
        view.setId(R.id.f10325604);
        d.e(this.f387471j);
        this.f387471j.setBackground(context.getResources().getDrawable(R.drawable.qui_common_border_standard_bg));
        this.f387462a.addView(this.f387471j, layoutParams13);
        RelativeLayout.LayoutParams layoutParams14 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams14.width = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        layoutParams14.height = (int) (TypedValue.applyDimension(1, 52.0f, displayMetrics) + 0.5f);
        layoutParams14.addRule(11, -1);
        layoutParams14.rightMargin = (int) (TypedValue.applyDimension(1, 15.0f, displayMetrics) + 0.5f);
        ImageView imageView2 = new ImageView(context, null);
        this.f387472k = imageView2;
        imageView2.setId(R.id.f103065zl);
        this.f387472k.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.f387472k.setImageDrawable(context.getResources().getDrawable(R.drawable.qui_chevron_right_icon_secondary_01));
        this.f387462a.addView(this.f387472k, layoutParams14);
        RelativeLayout.LayoutParams layoutParams15 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams15.addRule(3, R.id.f10325604);
        layoutParams15.addRule(11, -1);
        layoutParams15.topMargin = (int) (TypedValue.applyDimension(1, 12.0f, displayMetrics) + 0.5f);
        TextView textView4 = new TextView(context, null);
        this.f387473l = textView4;
        textView4.setId(R.id.f1033460c);
        this.f387473l.setTextSize(0, (int) (TypedValue.applyDimension(1, 12.0f, displayMetrics) + 0.5f));
        this.f387473l.setTextColor(resources.getColor(R.color.qui_common_text_secondary));
        this.f387462a.addView(this.f387473l, layoutParams15);
        RelativeLayout.LayoutParams layoutParams16 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams16.width = -1;
        layoutParams16.addRule(3, R.id.f10325604);
        layoutParams16.addRule(0, R.id.f1033460c);
        layoutParams16.topMargin = (int) (TypedValue.applyDimension(1, 12.0f, displayMetrics) + 0.5f);
        LinearLayout linearLayout5 = new LinearLayout(context, null);
        this.f387474m = linearLayout5;
        linearLayout5.setId(R.id.f10326605);
        this.f387474m.setOrientation(1);
        this.f387462a.addView(this.f387474m, layoutParams16);
        LinearLayout.LayoutParams layoutParams17 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams17.leftMargin = (int) (TypedValue.applyDimension(1, 15.0f, displayMetrics) + 0.5f);
        layoutParams17.topMargin = (int) (TypedValue.applyDimension(1, 8.0f, displayMetrics) + 0.5f);
        layoutParams17.rightMargin = (int) (TypedValue.applyDimension(1, 15.0f, displayMetrics) + 0.5f);
        TextView textView5 = new TextView(context, null);
        this.f387475n = textView5;
        textView5.setId(R.id.f102355xo);
        this.f387475n.setTextSize(0, (int) (TypedValue.applyDimension(1, 14.0f, displayMetrics) + 0.5f));
        this.f387475n.setVisibility(8);
        this.f387475n.setTextColor(resources.getColor(R.color.qui_common_text_tertiary));
        linearLayout.addView(this.f387475n, layoutParams17);
        LinearLayout.LayoutParams layoutParams18 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams18.width = -1;
        layoutParams18.height = (int) (TypedValue.applyDimension(1, 44.0f, displayMetrics) + 0.5f);
        layoutParams18.topMargin = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        LinearLayout linearLayout6 = new LinearLayout(context, null);
        this.f387476o = linearLayout6;
        linearLayout6.setId(R.id.f1033160_);
        this.f387476o.setGravity(16);
        this.f387476o.setVisibility(8);
        this.f387476o.setOrientation(0);
        d.e(this.f387476o);
        this.f387476o.setBackground(context.getResources().getDrawable(R.drawable.qui_common_fill_light_secondary_bg_corner_8));
        this.f387476o.setPadding((int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f), 0, (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f), 0);
        linearLayout.addView(this.f387476o, layoutParams18);
        LinearLayout.LayoutParams layoutParams19 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams19.width = (int) (TypedValue.applyDimension(1, 73.0f, displayMetrics) + 0.5f);
        layoutParams19.gravity = 16;
        TextView textView6 = new TextView(context, null);
        textView6.setTextSize(0, (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f));
        textView6.setText(resources.getString(R.string.esf));
        textView6.setGravity(16);
        textView6.setTextColor(resources.getColor(R.color.cqi));
        this.f387476o.addView(textView6, layoutParams19);
        LinearLayout.LayoutParams layoutParams20 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams20.width = -1;
        layoutParams20.topMargin = (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f);
        LinearLayout linearLayout7 = new LinearLayout(context, null);
        this.f387477p = linearLayout7;
        linearLayout7.setId(R.id.f103155zu);
        this.f387477p.setVisibility(8);
        this.f387477p.setOrientation(0);
        d.e(this.f387477p);
        this.f387477p.setBackground(context.getResources().getDrawable(R.drawable.qui_common_fill_light_secondary_bg_corner_8));
        this.f387477p.setPadding((int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f), 0, (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f), 0);
        linearLayout.addView(this.f387477p, layoutParams20);
        LinearLayout.LayoutParams layoutParams21 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams21.gravity = 17;
        layoutParams21.leftMargin = (int) (TypedValue.applyDimension(1, 15.0f, displayMetrics) + 0.5f);
        layoutParams21.topMargin = (int) (TypedValue.applyDimension(1, 20.0f, displayMetrics) + 0.5f);
        layoutParams21.rightMargin = (int) (TypedValue.applyDimension(1, 15.0f, displayMetrics) + 0.5f);
        TextView textView7 = new TextView(context, null);
        this.f387478q = textView7;
        textView7.setId(R.id.f103025zh);
        this.f387478q.setTextSize(0, (int) (TypedValue.applyDimension(2, 14.0f, displayMetrics) + 0.5f));
        this.f387478q.setVisibility(8);
        this.f387478q.setTextColor(resources.getColor(R.color.f157719xr));
        linearLayout.addView(this.f387478q, layoutParams21);
        LinearLayout.LayoutParams layoutParams22 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams22.width = -1;
        layoutParams22.leftMargin = (int) (TypedValue.applyDimension(1, 15.0f, displayMetrics) + 0.5f);
        layoutParams22.topMargin = (int) (TypedValue.applyDimension(1, 20.0f, displayMetrics) + 0.5f);
        layoutParams22.rightMargin = (int) (TypedValue.applyDimension(1, 15.0f, displayMetrics) + 0.5f);
        TroopNotificationRichTextView troopNotificationRichTextView2 = new TroopNotificationRichTextView(context, null);
        this.f387479r = troopNotificationRichTextView2;
        troopNotificationRichTextView2.setId(R.id.f103205zz);
        this.f387479r.setGravity(17);
        this.f387479r.setVisibility(8);
        linearLayout.addView(this.f387479r, layoutParams22);
        LinearLayout.LayoutParams layoutParams23 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams23.width = -1;
        layoutParams23.leftMargin = (int) (TypedValue.applyDimension(1, 15.0f, displayMetrics) + 0.5f);
        layoutParams23.topMargin = (int) (TypedValue.applyDimension(1, 20.0f, displayMetrics) + 0.5f);
        layoutParams23.rightMargin = (int) (TypedValue.applyDimension(1, 15.0f, displayMetrics) + 0.5f);
        ViewStub viewStub = new ViewStub(context, (AttributeSet) null);
        this.f387480s = viewStub;
        viewStub.setLayoutResource(R.layout.fvc);
        this.f387480s.setLayoutInflater(new a(this.f387480s.getContext(), new QbGroupNotificationDoubtTipsBinding()));
        this.f387480s.setId(R.id.f103135zs);
        linearLayout.addView(this.f387480s, layoutParams23);
        LinearLayout.LayoutParams layoutParams24 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams24.width = -1;
        layoutParams24.leftMargin = (int) (TypedValue.applyDimension(1, 15.0f, displayMetrics) + 0.5f);
        layoutParams24.topMargin = (int) (TypedValue.applyDimension(1, 20.0f, displayMetrics) + 0.5f);
        layoutParams24.rightMargin = (int) (TypedValue.applyDimension(1, 15.0f, displayMetrics) + 0.5f);
        QUIButton qUIButton = new QUIButton(context, null);
        this.f387481t = qUIButton;
        qUIButton.setTextSize(0, (int) resources.getDimension(R.dimen.d9r));
        this.f387481t.setText(resources.getString(R.string.f235117as));
        this.f387481t.setId(R.id.f103015zg);
        this.f387481t.setVisibility(8);
        this.f387481t.setMinimumHeight((int) resources.getDimension(R.dimen.d9p));
        this.f387481t.setSizeType(0);
        this.f387481t.setType(0);
        linearLayout.addView(this.f387481t, layoutParams24);
        FrameLayout.LayoutParams layoutParams25 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams25.width = -1;
        layoutParams25.gravity = 80;
        LinearLayout linearLayout8 = new LinearLayout(context, null);
        linearLayout8.setOrientation(1);
        frameLayout.addView(linearLayout8, layoutParams25);
        LinearLayout.LayoutParams layoutParams26 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams26.width = -1;
        layoutParams26.leftMargin = (int) (TypedValue.applyDimension(1, 15.0f, displayMetrics) + 0.5f);
        layoutParams26.topMargin = (int) (TypedValue.applyDimension(1, 20.0f, displayMetrics) + 0.5f);
        layoutParams26.rightMargin = (int) (TypedValue.applyDimension(1, 15.0f, displayMetrics) + 0.5f);
        LinearLayout linearLayout9 = new LinearLayout(context, null);
        this.f387482u = linearLayout9;
        linearLayout9.setId(R.id.f103095zo);
        this.f387482u.setOrientation(0);
        linearLayout8.addView(this.f387482u, layoutParams26);
        LinearLayout.LayoutParams layoutParams27 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams27.width = (int) (TypedValue.applyDimension(1, 0.0f, displayMetrics) + 0.5f);
        layoutParams27.gravity = 80;
        layoutParams27.weight = 1.0f;
        QUIButton qUIButton2 = new QUIButton(context, null);
        this.f387483v = qUIButton2;
        qUIButton2.setId(R.id.f103105zp);
        this.f387483v.setTextSize(0, (int) resources.getDimension(R.dimen.d9r));
        this.f387483v.setText(resources.getString(R.string.q7u));
        this.f387483v.setVisibility(8);
        this.f387483v.setMinimumHeight((int) resources.getDimension(R.dimen.d9p));
        this.f387483v.setSizeType(0);
        this.f387483v.setType(1);
        this.f387482u.addView(this.f387483v, layoutParams27);
        LinearLayout.LayoutParams layoutParams28 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams28.gravity = 80;
        layoutParams28.weight = 1.0f;
        layoutParams28.width = (int) (TypedValue.applyDimension(1, 0.0f, displayMetrics) + 0.5f);
        layoutParams28.leftMargin = (int) (TypedValue.applyDimension(1, 10.0f, displayMetrics) + 0.5f);
        QUIButton qUIButton3 = new QUIButton(context, null);
        this.f387484w = qUIButton3;
        qUIButton3.setTextSize(0, (int) resources.getDimension(R.dimen.d9r));
        this.f387484w.setText(resources.getString(R.string.q7t));
        this.f387484w.setId(R.id.f10328607);
        this.f387484w.setVisibility(8);
        this.f387484w.setMinimumHeight((int) resources.getDimension(R.dimen.d9p));
        this.f387484w.setSizeType(0);
        this.f387484w.setType(0);
        this.f387482u.addView(this.f387484w, layoutParams28);
        LinearLayout.LayoutParams layoutParams29 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams29.width = -1;
        layoutParams29.leftMargin = (int) (TypedValue.applyDimension(1, 15.0f, displayMetrics) + 0.5f);
        layoutParams29.topMargin = (int) (TypedValue.applyDimension(1, 5.0f, displayMetrics) + 0.5f);
        layoutParams29.rightMargin = (int) (TypedValue.applyDimension(1, 15.0f, displayMetrics) + 0.5f);
        LinearLayout linearLayout10 = new LinearLayout(context, null);
        this.f387485x = linearLayout10;
        linearLayout10.setId(R.id.f1033360b);
        this.f387485x.setGravity(81);
        this.f387485x.setOrientation(0);
        linearLayout8.addView(this.f387485x, layoutParams29);
        LinearLayout.LayoutParams layoutParams30 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams30.gravity = 81;
        TextView textView8 = new TextView(context, null);
        this.f387486y = textView8;
        textView8.setId(R.id.f103085zn);
        this.f387486y.setTextSize(0, (int) (TypedValue.applyDimension(2, 14.0f, displayMetrics) + 0.5f));
        this.f387486y.setText(resources.getString(R.string.f1788837v));
        this.f387486y.setTextColor(resources.getColor(R.color.cql));
        int applyDimension = (int) (TypedValue.applyDimension(1, 6.0f, displayMetrics) + 0.5f);
        this.f387486y.setPadding(applyDimension, applyDimension, applyDimension, applyDimension);
        this.f387485x.addView(this.f387486y, layoutParams30);
        LinearLayout.LayoutParams layoutParams31 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams31.gravity = 81;
        TextView textView9 = new TextView(context, null);
        textView9.setTextSize(0, (int) (TypedValue.applyDimension(2, 14.0f, displayMetrics) + 0.5f));
        textView9.setText(resources.getString(R.string.by));
        textView9.setTextColor(resources.getColor(R.color.cql));
        int applyDimension2 = (int) (TypedValue.applyDimension(1, 3.0f, displayMetrics) + 0.5f);
        textView9.setPadding(applyDimension2, applyDimension2, applyDimension2, applyDimension2);
        this.f387485x.addView(textView9, layoutParams31);
        LinearLayout.LayoutParams layoutParams32 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams32.gravity = 81;
        TextView textView10 = new TextView(context, null);
        this.f387487z = textView10;
        textView10.setId(R.id.f1033260a);
        this.f387487z.setTextSize(0, (int) (TypedValue.applyDimension(2, 14.0f, displayMetrics) + 0.5f));
        this.f387487z.setText(resources.getString(R.string.f169995c2));
        this.f387487z.setTextColor(resources.getColor(R.color.cql));
        int applyDimension3 = (int) (TypedValue.applyDimension(1, 6.0f, displayMetrics) + 0.5f);
        this.f387487z.setPadding(applyDimension3, applyDimension3, applyDimension3, applyDimension3);
        this.f387485x.addView(this.f387487z, layoutParams32);
        LinearLayout.LayoutParams layoutParams33 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams33.width = (int) (TypedValue.applyDimension(1, 0.0f, displayMetrics) + 0.5f);
        layoutParams33.height = (int) (TypedValue.applyDimension(1, 15.0f, displayMetrics) + 0.5f);
        linearLayout8.addView(new View(context, null), layoutParams33);
        return scrollView;
    }

    public View u() {
        return this.A;
    }
}

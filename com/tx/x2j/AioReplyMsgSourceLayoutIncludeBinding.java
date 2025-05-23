package com.tx.x2j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msglist.holder.component.reply.ReplyTextRelativeLayout;
import com.tencent.mobileqq.qqui.widget.MosaicTextView;
import com.tencent.mobileqq.qqui.widget.RoundBubbleImageView;
import com.tencent.qqnt.aio.widget.AIOMsgTextView;
import com.tencent.qqnt.aio.widget.AsyncImageView;
import com.tx.x2j.ano.X2JInclude;
import ty4.c;
import ty4.d;

/* compiled from: P */
@X2JInclude
/* loaded from: classes27.dex */
public class AioReplyMsgSourceLayoutIncludeBinding extends c {

    /* renamed from: a, reason: collision with root package name */
    public RelativeLayout f387101a;

    /* renamed from: b, reason: collision with root package name */
    public MosaicTextView f387102b;

    /* renamed from: c, reason: collision with root package name */
    public TextView f387103c;

    /* renamed from: d, reason: collision with root package name */
    public AIOMsgTextView f387104d;

    /* renamed from: e, reason: collision with root package name */
    public RelativeLayout f387105e;

    /* renamed from: f, reason: collision with root package name */
    public RoundBubbleImageView f387106f;

    /* renamed from: g, reason: collision with root package name */
    public TextView f387107g;

    /* renamed from: h, reason: collision with root package name */
    public AsyncImageView f387108h;

    /* renamed from: i, reason: collision with root package name */
    public View f387109i;

    /* renamed from: j, reason: collision with root package name */
    public View f387110j;

    /* renamed from: k, reason: collision with root package name */
    public ImageView f387111k;

    /* renamed from: l, reason: collision with root package name */
    public TextView f387112l;

    /* renamed from: m, reason: collision with root package name */
    public TextView f387113m;

    /* renamed from: n, reason: collision with root package name */
    public ImageView f387114n;

    /* renamed from: o, reason: collision with root package name */
    public View f387115o;

    @Override // ty4.c
    protected void g(Context context, Resources resources, DisplayMetrics displayMetrics, ConstraintLayout.LayoutParams layoutParams) {
        layoutParams.validate();
    }

    @Override // ty4.c
    @SuppressLint({"NewApi"})
    public View i(Context context) {
        Log.d("X2J_APT", "createView " + getClass().getName());
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        ReplyTextRelativeLayout replyTextRelativeLayout = new ReplyTextRelativeLayout(context, null);
        this.f387115o = replyTextRelativeLayout;
        d.e(replyTextRelativeLayout);
        replyTextRelativeLayout.setBackground(context.getResources().getDrawable(R.drawable.gxi));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        RelativeLayout relativeLayout = new RelativeLayout(context, null);
        this.f387101a = relativeLayout;
        relativeLayout.setId(R.id.i7f);
        this.f387101a.setPadding((int) resources.getDimension(R.dimen.c0k), (int) resources.getDimension(R.dimen.c0k), (int) resources.getDimension(R.dimen.c0k), (int) resources.getDimension(R.dimen.c0k));
        replyTextRelativeLayout.addView(this.f387101a, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        MosaicTextView mosaicTextView = new MosaicTextView(context, null);
        this.f387102b = mosaicTextView;
        mosaicTextView.setId(R.id.f86974t4);
        this.f387102b.setEllipsize(TextUtils.TruncateAt.END);
        this.f387102b.setMaxLines(1);
        this.f387102b.setIncludeFontPadding(false);
        this.f387101a.addView(this.f387102b, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(1, R.id.f86974t4);
        TextView textView = new TextView(context, null);
        this.f387103c = textView;
        textView.setId(R.id.f86984t5);
        this.f387103c.setMaxLines(1);
        this.f387103c.setIncludeFontPadding(false);
        this.f387103c.setPadding(0, 0, (int) (TypedValue.applyDimension(1, 37.0f, displayMetrics) + 0.5f), 0);
        this.f387101a.addView(this.f387103c, layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(3, R.id.f86974t4);
        layoutParams4.topMargin = (int) (TypedValue.applyDimension(1, 8.0f, displayMetrics) + 0.5f);
        AIOMsgTextView aIOMsgTextView = new AIOMsgTextView(context, null);
        this.f387104d = aIOMsgTextView;
        aIOMsgTextView.setId(R.id.f87044ta);
        this.f387104d.setIncludeFontPadding(false);
        this.f387101a.addView(this.f387104d, layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(3, R.id.f87044ta);
        layoutParams5.topMargin = (int) (TypedValue.applyDimension(1, 8.0f, displayMetrics) + 0.5f);
        RelativeLayout relativeLayout2 = new RelativeLayout(context, null);
        this.f387105e = relativeLayout2;
        relativeLayout2.setId(R.id.ddn);
        this.f387105e.setVisibility(8);
        this.f387101a.addView(this.f387105e, layoutParams5);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        RoundBubbleImageView roundBubbleImageView = new RoundBubbleImageView(context, null);
        this.f387106f = roundBubbleImageView;
        roundBubbleImageView.setId(R.id.jks);
        this.f387106f.setVisibility(8);
        this.f387105e.addView(this.f387106f, layoutParams6);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.width = (int) (TypedValue.applyDimension(1, 24.0f, displayMetrics) + 0.5f);
        layoutParams7.height = (int) (TypedValue.applyDimension(1, 24.0f, displayMetrics) + 0.5f);
        layoutParams7.addRule(7, R.id.jks);
        layoutParams7.addRule(8, R.id.jks);
        TextView textView2 = new TextView(context, null);
        this.f387107g = textView2;
        textView2.setId(R.id.f24820_6);
        this.f387107g.setTextSize(0, (int) (TypedValue.applyDimension(1, 12.0f, displayMetrics) + 0.5f));
        this.f387107g.setGravity(17);
        this.f387107g.setVisibility(8);
        this.f387107g.setTextColor(resources.getColor(R.color.f158017al3));
        d.e(this.f387107g);
        this.f387107g.setBackground(context.getResources().getDrawable(R.drawable.mmx));
        this.f387107g.setPadding(0, (int) (TypedValue.applyDimension(1, 5.0f, displayMetrics) + 0.5f), 0, 0);
        this.f387105e.addView(this.f387107g, layoutParams7);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.height = (int) (TypedValue.applyDimension(1, 40.0f, displayMetrics) + 0.5f);
        AsyncImageView asyncImageView = new AsyncImageView(context, null);
        this.f387108h = asyncImageView;
        asyncImageView.setId(R.id.jkq);
        this.f387108h.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f387108h.setMaxWidth((int) (TypedValue.applyDimension(1, 120.0f, displayMetrics) + 0.5f));
        this.f387108h.setVisibility(8);
        this.f387108h.setCornerRadius((int) (TypedValue.applyDimension(1, 6.0f, displayMetrics) + 0.5f));
        this.f387105e.addView(this.f387108h, layoutParams8);
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams9.width = (int) (TypedValue.applyDimension(1, 60.0f, displayMetrics) + 0.5f);
        layoutParams9.height = (int) (TypedValue.applyDimension(1, 40.0f, displayMetrics) + 0.5f);
        layoutParams9.addRule(13, -1);
        View view = new View(context, null);
        this.f387109i = view;
        view.setId(R.id.lfc);
        this.f387109i.setVisibility(8);
        d.e(this.f387109i);
        this.f387109i.setBackground(context.getResources().getDrawable(R.drawable.hfm));
        this.f387105e.addView(this.f387109i, layoutParams9);
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams10.width = (int) (TypedValue.applyDimension(1, 0.0f, displayMetrics) + 0.5f);
        layoutParams10.height = (int) (TypedValue.applyDimension(1, 0.0f, displayMetrics) + 0.5f);
        View view2 = new View(context, null);
        this.f387110j = view2;
        view2.setId(R.id.lew);
        this.f387110j.setVisibility(8);
        d.e(this.f387110j);
        this.f387110j.setBackground(context.getResources().getDrawable(R.drawable.hfl));
        this.f387105e.addView(this.f387110j, layoutParams10);
        RelativeLayout.LayoutParams layoutParams11 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams11.addRule(13, -1);
        ImageView imageView = new ImageView(context, null);
        this.f387111k = imageView;
        imageView.setId(R.id.d_m);
        this.f387111k.setVisibility(8);
        this.f387105e.addView(this.f387111k, layoutParams11);
        RelativeLayout.LayoutParams layoutParams12 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams12.addRule(3, R.id.ddn);
        layoutParams12.topMargin = (int) (TypedValue.applyDimension(1, 8.0f, displayMetrics) + 0.5f);
        TextView textView3 = new TextView(context, null);
        this.f387112l = textView3;
        textView3.setId(R.id.f1e);
        this.f387112l.setText("");
        this.f387112l.setVisibility(8);
        this.f387112l.setIncludeFontPadding(false);
        this.f387101a.addView(this.f387112l, layoutParams12);
        RelativeLayout.LayoutParams layoutParams13 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams13.addRule(3, R.id.f1e);
        layoutParams13.topMargin = (int) (TypedValue.applyDimension(1, 8.0f, displayMetrics) + 0.5f);
        TextView textView4 = new TextView(context, null);
        this.f387113m = textView4;
        textView4.setId(R.id.lin);
        this.f387113m.setText("");
        this.f387113m.setEllipsize(TextUtils.TruncateAt.END);
        this.f387113m.setMaxLines(1);
        this.f387113m.setVisibility(8);
        this.f387113m.setIncludeFontPadding(false);
        this.f387113m.setPadding(0, 0, (int) (TypedValue.applyDimension(1, 40.0f, displayMetrics) + 0.5f), 0);
        this.f387101a.addView(this.f387113m, layoutParams13);
        RelativeLayout.LayoutParams layoutParams14 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams14.width = (int) (TypedValue.applyDimension(1, 54.0f, displayMetrics) + 0.5f);
        layoutParams14.height = (int) (TypedValue.applyDimension(1, 41.0f, displayMetrics) + 0.5f);
        ImageView imageView2 = new ImageView(context, null);
        this.f387114n = imageView2;
        imageView2.setId(R.id.f165947lo3);
        this.f387114n.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.f387114n.setImageDrawable(context.getResources().getDrawable(R.drawable.hl7));
        this.f387114n.setPadding((int) (TypedValue.applyDimension(1, 30.0f, displayMetrics) + 0.5f), (int) (TypedValue.applyDimension(1, 10.0f, displayMetrics) + 0.5f), (int) (TypedValue.applyDimension(1, 9.0f, displayMetrics) + 0.5f), (int) (TypedValue.applyDimension(1, 16.0f, displayMetrics) + 0.5f));
        replyTextRelativeLayout.addView(this.f387114n, layoutParams14);
        return replyTextRelativeLayout;
    }
}

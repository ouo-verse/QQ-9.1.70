package com.tencent.guild.aio.msglist.ark;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.guild.aio.msglist.ark.view.GuildArkAppView;
import com.tencent.mobileqq.R;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes6.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public ViewGroup f111221a;

    /* renamed from: b, reason: collision with root package name */
    public RelativeLayout f111222b;

    /* renamed from: c, reason: collision with root package name */
    public LinearLayout f111223c;

    /* renamed from: d, reason: collision with root package name */
    public ImageView f111224d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f111225e;

    /* renamed from: f, reason: collision with root package name */
    public GuildArkAppView f111226f;

    /* renamed from: g, reason: collision with root package name */
    public View f111227g;

    /* renamed from: h, reason: collision with root package name */
    public ArkAppLoadLayout f111228h;

    /* renamed from: i, reason: collision with root package name */
    public LinearLayout f111229i;

    /* renamed from: j, reason: collision with root package name */
    public ProgressBar f111230j;

    /* renamed from: k, reason: collision with root package name */
    public TextView f111231k;

    /* renamed from: l, reason: collision with root package name */
    public LinearLayout f111232l;

    /* renamed from: m, reason: collision with root package name */
    public TextView f111233m;

    /* renamed from: n, reason: collision with root package name */
    public View f111234n;

    private ViewGroup.LayoutParams a(Context context, ViewGroup.LayoutParams layoutParams) {
        context.getResources();
        layoutParams.width = -2;
        layoutParams.height = -2;
        return layoutParams;
    }

    private ViewGroup.LayoutParams b(Context context, AbsListView.LayoutParams layoutParams) {
        context.getResources();
        layoutParams.width = -2;
        layoutParams.height = -2;
        return layoutParams;
    }

    private ViewGroup.LayoutParams c(Context context, FrameLayout.LayoutParams layoutParams) {
        context.getResources();
        layoutParams.width = -2;
        layoutParams.height = -2;
        return layoutParams;
    }

    private ViewGroup.LayoutParams d(Context context, LinearLayout.LayoutParams layoutParams) {
        context.getResources();
        layoutParams.width = -2;
        layoutParams.height = -2;
        return layoutParams;
    }

    private ViewGroup.LayoutParams e(Context context, RadioGroup.LayoutParams layoutParams) {
        context.getResources();
        layoutParams.width = -2;
        layoutParams.height = -2;
        return layoutParams;
    }

    private ViewGroup.LayoutParams f(Context context, RelativeLayout.LayoutParams layoutParams) {
        context.getResources();
        layoutParams.width = -2;
        layoutParams.height = -2;
        return layoutParams;
    }

    private ViewGroup.LayoutParams g(Context context, ConstraintLayout.LayoutParams layoutParams) {
        context.getResources();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -2;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = -2;
        layoutParams.validate();
        return layoutParams;
    }

    private ViewGroup.LayoutParams h(Context context, RecyclerView.LayoutParams layoutParams) {
        context.getResources();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -2;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = -2;
        return layoutParams;
    }

    public View i(Context context, ViewGroup viewGroup) {
        boolean z16;
        if (viewGroup != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        return j(context, viewGroup, z16);
    }

    public View j(Context context, ViewGroup viewGroup, boolean z16) {
        View k3 = k(context);
        if (viewGroup == null) {
            return k3;
        }
        ViewGroup.LayoutParams l3 = l(context, viewGroup);
        if (l3 == null) {
            return k3;
        }
        if (z16) {
            viewGroup.addView(k3, l3);
            return k3;
        }
        k3.setLayoutParams(l3);
        return k3;
    }

    public View k(Context context) {
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = new RelativeLayout(context, null);
        this.f111221a = relativeLayout;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        RelativeLayout relativeLayout2 = new RelativeLayout(context, null);
        this.f111222b = relativeLayout2;
        relativeLayout2.setId(R.id.svh);
        this.f111222b.setLayoutParams(layoutParams);
        relativeLayout.addView(this.f111222b);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.width = -2;
        layoutParams2.height = (int) TypedValue.applyDimension(1, 22.0f, resources.getDisplayMetrics());
        layoutParams2.addRule(3, R.id.y_);
        layoutParams2.topMargin = (int) TypedValue.applyDimension(1, 7.0f, resources.getDisplayMetrics());
        LinearLayout linearLayout = new LinearLayout(context, null);
        this.f111223c = linearLayout;
        linearLayout.setBackgroundResource(R.drawable.guild_ark_item_app_info_bg);
        this.f111223c.setId(R.id.f164456yf);
        this.f111223c.setGravity(16);
        this.f111223c.setVisibility(8);
        this.f111223c.setOrientation(0);
        this.f111223c.setLayoutParams(layoutParams2);
        this.f111222b.addView(this.f111223c);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.width = (int) TypedValue.applyDimension(1, 14.0f, resources.getDisplayMetrics());
        layoutParams3.height = (int) TypedValue.applyDimension(1, 14.0f, resources.getDisplayMetrics());
        layoutParams3.leftMargin = (int) TypedValue.applyDimension(1, 5.0f, resources.getDisplayMetrics());
        ImageView imageView = new ImageView(context, null);
        this.f111224d = imageView;
        imageView.setId(R.id.f164455ye);
        this.f111224d.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f111224d.setVisibility(8);
        this.f111224d.setLayoutParams(layoutParams3);
        this.f111223c.addView(this.f111224d);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.width = -2;
        layoutParams4.height = -2;
        layoutParams4.leftMargin = (int) TypedValue.applyDimension(1, 10.0f, resources.getDisplayMetrics());
        layoutParams4.rightMargin = (int) TypedValue.applyDimension(1, 10.0f, resources.getDisplayMetrics());
        TextView textView = new TextView(context, null);
        this.f111225e = textView;
        textView.setId(R.id.f164457yg);
        this.f111225e.setTextSize(0, resources.getDimension(R.dimen.ayk));
        this.f111225e.setGravity(16);
        this.f111225e.setVisibility(8);
        this.f111225e.setTextColor(resources.getColor(R.color.f156970gg));
        this.f111225e.setLayoutParams(layoutParams4);
        this.f111223c.addView(this.f111225e);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.width = -2;
        layoutParams5.height = -2;
        layoutParams5.addRule(14, -1);
        GuildArkAppView guildArkAppView = new GuildArkAppView(context, null);
        this.f111226f = guildArkAppView;
        guildArkAppView.setId(R.id.y_);
        this.f111226f.setLayoutParams(layoutParams5);
        this.f111222b.addView(this.f111226f);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.width = (int) TypedValue.applyDimension(1, 0.0f, resources.getDisplayMetrics());
        layoutParams6.height = (int) TypedValue.applyDimension(1, 0.0f, resources.getDisplayMetrics());
        layoutParams6.addRule(3, R.id.eet);
        View view = new View(context, null);
        this.f111227g = view;
        view.setId(R.id.f164453yc);
        this.f111227g.setVisibility(8);
        this.f111227g.setLayoutParams(layoutParams6);
        relativeLayout.addView(this.f111227g);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.width = -1;
        layoutParams7.height = (int) TypedValue.applyDimension(1, 352.0f, resources.getDisplayMetrics());
        ArkAppLoadLayout arkAppLoadLayout = new ArkAppLoadLayout(context, null);
        this.f111228h = arkAppLoadLayout;
        arkAppLoadLayout.setId(R.id.eet);
        this.f111228h.setVisibility(8);
        this.f111228h.setLayoutParams(layoutParams7);
        relativeLayout.addView(this.f111228h);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.width = -2;
        layoutParams8.height = -2;
        layoutParams8.addRule(13, -1);
        LinearLayout linearLayout2 = new LinearLayout(context, null);
        this.f111229i = linearLayout2;
        linearLayout2.setId(R.id.loading);
        this.f111229i.setGravity(17);
        this.f111229i.setOrientation(1);
        this.f111229i.setLayoutParams(layoutParams8);
        this.f111228h.addView(this.f111229i);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams9.width = (int) TypedValue.applyDimension(1, 16.0f, resources.getDisplayMetrics());
        layoutParams9.height = (int) TypedValue.applyDimension(1, 16.0f, resources.getDisplayMetrics());
        layoutParams9.gravity = 17;
        ProgressBar progressBar = new ProgressBar(context, null);
        this.f111230j = progressBar;
        progressBar.setIndeterminateDrawable(context.getResources().getDrawable(R.drawable.f160545jt));
        this.f111230j.setId(R.id.g1f);
        this.f111230j.setIndeterminate(true);
        try {
            Field declaredField = this.f111230j.getClass().getDeclaredField("mBehavior");
            declaredField.setAccessible(true);
            declaredField.set(this.f111230j, 1);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        this.f111230j.setLayoutParams(layoutParams9);
        this.f111229i.addView(this.f111230j);
        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams10.width = -2;
        layoutParams10.height = -2;
        layoutParams10.topMargin = (int) TypedValue.applyDimension(1, 10.0f, resources.getDisplayMetrics());
        TextView textView2 = new TextView(context, null);
        this.f111231k = textView2;
        textView2.setId(R.id.efo);
        this.f111231k.setText(R.string.f170468s3);
        this.f111231k.setTextSize(2, 15.0f);
        this.f111231k.setTextColor(resources.getColor(R.color.f156780bh));
        this.f111231k.setLayoutParams(layoutParams10);
        this.f111229i.addView(this.f111231k);
        RelativeLayout.LayoutParams layoutParams11 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams11.width = -2;
        layoutParams11.height = -2;
        layoutParams11.addRule(13, -1);
        LinearLayout linearLayout3 = new LinearLayout(context, null);
        this.f111232l = linearLayout3;
        linearLayout3.setId(R.id.i5h);
        this.f111232l.setOrientation(1);
        this.f111232l.setLayoutParams(layoutParams11);
        this.f111228h.addView(this.f111232l);
        LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams12.width = -2;
        layoutParams12.height = -2;
        layoutParams12.topMargin = (int) TypedValue.applyDimension(1, 10.0f, resources.getDisplayMetrics());
        layoutParams12.gravity = 17;
        TextView textView3 = new TextView(context, null);
        this.f111233m = textView3;
        textView3.setId(R.id.i5p);
        this.f111233m.setText(R.string.f170470s5);
        this.f111233m.setTextSize(2, 15.0f);
        this.f111233m.setGravity(17);
        this.f111233m.setTextColor(resources.getColor(R.color.f156780bh));
        this.f111233m.setLayoutParams(layoutParams12);
        this.f111232l.addView(this.f111233m);
        LinearLayout.LayoutParams layoutParams13 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams13.width = (int) TypedValue.applyDimension(1, 75.0f, resources.getDisplayMetrics());
        layoutParams13.height = (int) TypedValue.applyDimension(1, 75.0f, resources.getDisplayMetrics());
        layoutParams13.gravity = 17;
        View view2 = new View(context, null);
        this.f111234n = view2;
        view2.setBackgroundResource(R.drawable.c_j);
        this.f111234n.setId(R.id.i5l);
        this.f111234n.setLayoutParams(layoutParams13);
        this.f111232l.addView(this.f111234n);
        return relativeLayout;
    }

    public ViewGroup.LayoutParams l(Context context, ViewGroup viewGroup) {
        if (viewGroup == null) {
            return null;
        }
        for (Class<?> cls = viewGroup.getClass(); cls != null; cls = cls.getSuperclass()) {
            String name = cls.getName();
            if ("android.widget.RelativeLayout".equals(name)) {
                return f(context, new RelativeLayout.LayoutParams(0, 0));
            }
            if ("androidx.recyclerview.widget.RecyclerView".equals(name)) {
                return h(context, new RecyclerView.LayoutParams(0, 0));
            }
            if ("android.view.ViewGroup".equals(name)) {
                return a(context, new ViewGroup.LayoutParams(0, 0));
            }
            if ("android.widget.RadioGroup".equals(name)) {
                return e(context, new RadioGroup.LayoutParams(0, 0));
            }
            if ("android.widget.LinearLayout".equals(name)) {
                return d(context, new LinearLayout.LayoutParams(0, 0));
            }
            if ("android.widget.AbsListView".equals(name)) {
                return b(context, new AbsListView.LayoutParams(0, 0));
            }
            if ("androidx.constraintlayout.widget.ConstraintLayout".equals(name)) {
                return g(context, new ConstraintLayout.LayoutParams(0, 0));
            }
            if ("android.widget.FrameLayout".equals(name)) {
                return c(context, new FrameLayout.LayoutParams(0, 0));
            }
        }
        Log.e("X2J", "error parent : " + viewGroup.toString());
        return null;
    }
}

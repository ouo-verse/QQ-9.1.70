package a81;

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
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msglist.holder.component.ark.ArkAppLoadLayout;
import com.tencent.mobileqq.aio.msglist.holder.component.ark.view.ArkAppView;

/* compiled from: P */
/* loaded from: classes11.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public ViewGroup f25706a;

    /* renamed from: b, reason: collision with root package name */
    public RelativeLayout f25707b;

    /* renamed from: c, reason: collision with root package name */
    public LinearLayout f25708c;

    /* renamed from: d, reason: collision with root package name */
    public ImageView f25709d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f25710e;

    /* renamed from: f, reason: collision with root package name */
    public ArkAppView f25711f;

    /* renamed from: g, reason: collision with root package name */
    public View f25712g;

    /* renamed from: h, reason: collision with root package name */
    public ArkAppLoadLayout f25713h;

    /* renamed from: i, reason: collision with root package name */
    public LinearLayout f25714i;

    /* renamed from: j, reason: collision with root package name */
    public TextView f25715j;

    /* renamed from: k, reason: collision with root package name */
    public ImageView f25716k;

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
        this.f25706a = relativeLayout;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.width = -2;
        layoutParams.height = -2;
        RelativeLayout relativeLayout2 = new RelativeLayout(context, null);
        this.f25707b = relativeLayout2;
        relativeLayout2.setId(R.id.svh);
        this.f25707b.setLayoutParams(layoutParams);
        relativeLayout.addView(this.f25707b);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.width = -2;
        layoutParams2.height = (int) TypedValue.applyDimension(1, 22.0f, resources.getDisplayMetrics());
        layoutParams2.addRule(3, R.id.y_);
        layoutParams2.topMargin = (int) TypedValue.applyDimension(1, 7.0f, resources.getDisplayMetrics());
        LinearLayout linearLayout = new LinearLayout(context, null);
        this.f25708c = linearLayout;
        linearLayout.setBackgroundResource(R.drawable.mnr);
        this.f25708c.setId(R.id.f164456yf);
        this.f25708c.setGravity(16);
        this.f25708c.setVisibility(8);
        this.f25708c.setOrientation(0);
        this.f25708c.setLayoutParams(layoutParams2);
        this.f25707b.addView(this.f25708c);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.width = (int) TypedValue.applyDimension(1, 14.0f, resources.getDisplayMetrics());
        layoutParams3.height = (int) TypedValue.applyDimension(1, 14.0f, resources.getDisplayMetrics());
        layoutParams3.leftMargin = (int) TypedValue.applyDimension(1, 5.0f, resources.getDisplayMetrics());
        ImageView imageView = new ImageView(context, null);
        this.f25709d = imageView;
        imageView.setId(R.id.f164455ye);
        this.f25709d.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f25709d.setVisibility(8);
        this.f25709d.setLayoutParams(layoutParams3);
        this.f25708c.addView(this.f25709d);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.width = -2;
        layoutParams4.height = -2;
        layoutParams4.leftMargin = (int) TypedValue.applyDimension(1, 10.0f, resources.getDisplayMetrics());
        layoutParams4.rightMargin = (int) TypedValue.applyDimension(1, 10.0f, resources.getDisplayMetrics());
        TextView textView = new TextView(context, null);
        this.f25710e = textView;
        textView.setId(R.id.f164457yg);
        this.f25710e.setTextSize(0, resources.getDimension(R.dimen.ayk));
        this.f25710e.setGravity(16);
        this.f25710e.setVisibility(8);
        this.f25710e.setTextColor(resources.getColor(R.color.f156970gg));
        this.f25710e.setLayoutParams(layoutParams4);
        this.f25708c.addView(this.f25710e);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.width = -2;
        layoutParams5.height = -2;
        layoutParams5.addRule(14, -1);
        ArkAppView arkAppView = new ArkAppView(context, null);
        this.f25711f = arkAppView;
        arkAppView.setId(R.id.y_);
        this.f25711f.setLayoutParams(layoutParams5);
        this.f25707b.addView(this.f25711f);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.width = (int) TypedValue.applyDimension(1, 0.0f, resources.getDisplayMetrics());
        layoutParams6.height = (int) TypedValue.applyDimension(1, 0.0f, resources.getDisplayMetrics());
        layoutParams6.addRule(3, R.id.eet);
        View view = new View(context, null);
        this.f25712g = view;
        view.setId(R.id.f164453yc);
        this.f25712g.setVisibility(8);
        this.f25712g.setLayoutParams(layoutParams6);
        relativeLayout.addView(this.f25712g);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.width = -1;
        layoutParams7.height = (int) TypedValue.applyDimension(1, 352.0f, resources.getDisplayMetrics());
        ArkAppLoadLayout arkAppLoadLayout = new ArkAppLoadLayout(context, null);
        this.f25713h = arkAppLoadLayout;
        arkAppLoadLayout.setId(R.id.eet);
        this.f25713h.setVisibility(8);
        this.f25713h.setLayoutParams(layoutParams7);
        relativeLayout.addView(this.f25713h);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.width = -2;
        layoutParams8.height = -2;
        layoutParams8.addRule(13, -1);
        LinearLayout linearLayout2 = new LinearLayout(context, null);
        this.f25714i = linearLayout2;
        linearLayout2.setId(R.id.loading);
        this.f25714i.setGravity(17);
        this.f25714i.setOrientation(1);
        this.f25714i.setLayoutParams(layoutParams8);
        this.f25713h.addView(this.f25714i);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams9.width = (int) TypedValue.applyDimension(1, 28.0f, resources.getDisplayMetrics());
        layoutParams9.height = (int) TypedValue.applyDimension(1, 28.0f, resources.getDisplayMetrics());
        layoutParams9.gravity = 17;
        ImageView imageView2 = new ImageView(context, null);
        this.f25716k = imageView2;
        imageView2.setId(R.id.yrs);
        this.f25716k.setLayoutParams(layoutParams9);
        this.f25714i.addView(this.f25716k);
        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams10.width = -2;
        layoutParams10.height = -2;
        layoutParams10.topMargin = (int) TypedValue.applyDimension(1, 4.0f, resources.getDisplayMetrics());
        layoutParams10.gravity = 17;
        TextView textView2 = new TextView(context, null);
        this.f25715j = textView2;
        textView2.setId(R.id.f166128ys2);
        this.f25715j.setText(R.string.f170470s5);
        this.f25715j.setTextSize(2, 12.0f);
        this.f25715j.setGravity(17);
        this.f25715j.setTextColor(resources.getColor(R.color.f156780bh));
        this.f25715j.setLayoutParams(layoutParams10);
        this.f25714i.addView(this.f25715j);
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

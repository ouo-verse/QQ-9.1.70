package eq0;

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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.guild.aio.msglist.holder.template.BubbleLayoutCompatPress;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public ViewGroup f396967a;

    /* renamed from: b, reason: collision with root package name */
    public ConstraintLayout f396968b;

    /* renamed from: c, reason: collision with root package name */
    public LinearLayout f396969c;

    /* renamed from: d, reason: collision with root package name */
    public LinearLayout f396970d;

    /* renamed from: e, reason: collision with root package name */
    public FrameLayout f396971e;

    /* renamed from: f, reason: collision with root package name */
    public LinearLayout f396972f;

    /* renamed from: g, reason: collision with root package name */
    public LinearLayout f396973g;

    /* renamed from: h, reason: collision with root package name */
    public LinearLayout f396974h;

    /* renamed from: i, reason: collision with root package name */
    public ImageView f396975i;

    /* renamed from: j, reason: collision with root package name */
    public BubbleLayoutCompatPress f396976j;

    /* renamed from: k, reason: collision with root package name */
    public LinearLayout f396977k;

    /* renamed from: l, reason: collision with root package name */
    public LinearLayout f396978l;

    /* renamed from: m, reason: collision with root package name */
    public FrameLayout f396979m;

    private ViewGroup.LayoutParams a(Context context, ViewGroup.LayoutParams layoutParams) {
        context.getResources();
        layoutParams.width = -1;
        layoutParams.height = -2;
        return layoutParams;
    }

    private ViewGroup.LayoutParams b(Context context, AbsListView.LayoutParams layoutParams) {
        context.getResources();
        layoutParams.width = -1;
        layoutParams.height = -2;
        return layoutParams;
    }

    private ViewGroup.LayoutParams c(Context context, FrameLayout.LayoutParams layoutParams) {
        context.getResources();
        layoutParams.width = -1;
        layoutParams.height = -2;
        return layoutParams;
    }

    private ViewGroup.LayoutParams d(Context context, LinearLayout.LayoutParams layoutParams) {
        context.getResources();
        layoutParams.width = -1;
        layoutParams.height = -2;
        return layoutParams;
    }

    private ViewGroup.LayoutParams e(Context context, RadioGroup.LayoutParams layoutParams) {
        context.getResources();
        layoutParams.width = -1;
        layoutParams.height = -2;
        return layoutParams;
    }

    private ViewGroup.LayoutParams f(Context context, RelativeLayout.LayoutParams layoutParams) {
        context.getResources();
        layoutParams.width = -1;
        layoutParams.height = -2;
        return layoutParams;
    }

    private ViewGroup.LayoutParams g(Context context, ConstraintLayout.LayoutParams layoutParams) {
        context.getResources();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = -2;
        layoutParams.validate();
        return layoutParams;
    }

    private ViewGroup.LayoutParams h(Context context, RecyclerView.LayoutParams layoutParams) {
        context.getResources();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = -2;
        return layoutParams;
    }

    public View i(Context context, ViewGroup viewGroup, boolean z16) {
        View j3 = j(context);
        if (viewGroup == null) {
            return j3;
        }
        ViewGroup.LayoutParams k3 = k(context, viewGroup);
        if (k3 == null) {
            return j3;
        }
        if (z16) {
            viewGroup.addView(j3, k3);
            return j3;
        }
        j3.setLayoutParams(k3);
        return j3;
    }

    public View j(Context context) {
        Resources resources = context.getResources();
        ConstraintLayout constraintLayout = new ConstraintLayout(context, null);
        this.f396968b = constraintLayout;
        this.f396967a = constraintLayout;
        constraintLayout.setId(R.id.root);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams).width = (int) TypedValue.applyDimension(1, 0.0f, resources.getDisplayMetrics());
        ((ViewGroup.MarginLayoutParams) layoutParams).height = -2;
        layoutParams.topToTop = 0;
        layoutParams.startToStart = 0;
        layoutParams.endToEnd = 0;
        layoutParams.validate();
        LinearLayout linearLayout = new LinearLayout(context, null);
        this.f396969c = linearLayout;
        linearLayout.setId(R.id.f166331zg3);
        this.f396969c.setOrientation(1);
        this.f396969c.setLayoutParams(layoutParams);
        this.f396968b.addView(this.f396969c);
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = -2;
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = -2;
        layoutParams2.topToBottom = R.id.f166331zg3;
        layoutParams2.startToStart = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = (int) resources.getDimension(R.dimen.f158723nd);
        layoutParams2.validate();
        LinearLayout linearLayout2 = new LinearLayout(context, null);
        this.f396970d = linearLayout2;
        linearLayout2.setId(R.id.zg7);
        this.f396970d.setOrientation(0);
        this.f396970d.setLayoutParams(layoutParams2);
        this.f396968b.addView(this.f396970d);
        ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams3).width = -2;
        ((ViewGroup.MarginLayoutParams) layoutParams3).height = -2;
        layoutParams3.topToBottom = R.id.f166331zg3;
        ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin = (int) resources.getDimension(R.dimen.chb);
        layoutParams3.startToEnd = R.id.zg7;
        layoutParams3.validate();
        FrameLayout frameLayout = new FrameLayout(context, null);
        this.f396971e = frameLayout;
        frameLayout.setId(R.id.zfr);
        this.f396971e.setPadding(0, 0, (int) resources.getDimension(R.dimen.f158723nd), 0);
        this.f396971e.setLayoutParams(layoutParams3);
        this.f396968b.addView(this.f396971e);
        ConstraintLayout.LayoutParams layoutParams4 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams4).width = -2;
        ((ViewGroup.MarginLayoutParams) layoutParams4).height = -2;
        layoutParams4.topToBottom = R.id.f166331zg3;
        ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin = (int) resources.getDimension(R.dimen.f158240c04);
        ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin = (int) resources.getDimension(R.dimen.f158723nd);
        layoutParams4.startToEnd = R.id.zfr;
        layoutParams4.validate();
        LinearLayout linearLayout3 = new LinearLayout(context, null);
        this.f396972f = linearLayout3;
        linearLayout3.setId(R.id.zg8);
        this.f396972f.setOrientation(0);
        this.f396972f.setPadding(0, 0, 0, (int) resources.getDimension(R.dimen.ccl));
        this.f396972f.setLayoutParams(layoutParams4);
        this.f396968b.addView(this.f396972f);
        ConstraintLayout.LayoutParams layoutParams5 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams5).width = -2;
        ((ViewGroup.MarginLayoutParams) layoutParams5).height = -2;
        layoutParams5.topToBottom = R.id.zg8;
        layoutParams5.horizontalBias = 0.0f;
        layoutParams5.startToStart = R.id.zg8;
        layoutParams5.constrainedWidth = true;
        ((ViewGroup.MarginLayoutParams) layoutParams5).rightMargin = (int) resources.getDimension(R.dimen.cco);
        layoutParams5.endToEnd = 0;
        layoutParams5.validate();
        LinearLayout linearLayout4 = new LinearLayout(context, null);
        this.f396973g = linearLayout4;
        linearLayout4.setId(R.id.f164907u83);
        this.f396973g.setOrientation(1);
        int dimension = (int) resources.getDimension(R.dimen.f158700mp);
        this.f396973g.setPadding(dimension, dimension, dimension, dimension);
        this.f396973g.setLayoutParams(layoutParams5);
        this.f396968b.addView(this.f396973g);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.width = -2;
        layoutParams6.height = -2;
        layoutParams6.gravity = 16;
        LinearLayout linearLayout5 = new LinearLayout(context, null);
        this.f396974h = linearLayout5;
        linearLayout5.setId(R.id.zgk);
        this.f396974h.setOrientation(1);
        this.f396974h.setLayoutParams(layoutParams6);
        this.f396973g.addView(this.f396974h);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams7.width = -1;
        layoutParams7.height = (int) TypedValue.applyDimension(1, 0.5f, resources.getDisplayMetrics());
        layoutParams7.topMargin = (int) TypedValue.applyDimension(1, 8.0f, resources.getDisplayMetrics());
        ImageView imageView = new ImageView(context, null);
        this.f396975i = imageView;
        imageView.setId(R.id.f73123sp);
        this.f396975i.setVisibility(8);
        this.f396975i.setLayoutParams(layoutParams7);
        this.f396973g.addView(this.f396975i);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams8.width = -2;
        layoutParams8.height = -2;
        BubbleLayoutCompatPress bubbleLayoutCompatPress = new BubbleLayoutCompatPress(context, null);
        this.f396976j = bubbleLayoutCompatPress;
        bubbleLayoutCompatPress.setId(R.id.zfv);
        this.f396976j.setOrientation(1);
        this.f396976j.setLayoutParams(layoutParams8);
        this.f396973g.addView(this.f396976j);
        ConstraintLayout.LayoutParams layoutParams9 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams9).width = -2;
        ((ViewGroup.MarginLayoutParams) layoutParams9).height = -2;
        layoutParams9.topToBottom = R.id.f164907u83;
        layoutParams9.startToStart = R.id.f164907u83;
        ((ViewGroup.MarginLayoutParams) layoutParams9).topMargin = (int) TypedValue.applyDimension(1, 5.0f, resources.getDisplayMetrics());
        layoutParams9.validate();
        LinearLayout linearLayout6 = new LinearLayout(context, null);
        this.f396977k = linearLayout6;
        linearLayout6.setId(R.id.zgm);
        this.f396977k.setOrientation(0);
        this.f396977k.setLayoutParams(layoutParams9);
        this.f396968b.addView(this.f396977k);
        ConstraintLayout.LayoutParams layoutParams10 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams10).width = -2;
        ((ViewGroup.MarginLayoutParams) layoutParams10).height = -2;
        layoutParams10.topToBottom = R.id.f164907u83;
        layoutParams10.startToStart = R.id.f164907u83;
        layoutParams10.validate();
        LinearLayout linearLayout7 = new LinearLayout(context, null);
        this.f396978l = linearLayout7;
        linearLayout7.setId(R.id.zgs);
        this.f396978l.setOrientation(0);
        this.f396978l.setLayoutParams(layoutParams10);
        this.f396968b.addView(this.f396978l);
        ConstraintLayout.LayoutParams layoutParams11 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams11).width = (int) TypedValue.applyDimension(1, 0.0f, resources.getDisplayMetrics());
        ((ViewGroup.MarginLayoutParams) layoutParams11).height = -2;
        layoutParams11.topToBottom = R.id.zgs;
        layoutParams11.startToStart = R.id.f164907u83;
        layoutParams11.endToEnd = 0;
        layoutParams11.validate();
        FrameLayout frameLayout2 = new FrameLayout(context, null);
        this.f396979m = frameLayout2;
        frameLayout2.setId(R.id.zfx);
        this.f396979m.setPadding(0, 0, 0, (int) TypedValue.applyDimension(1, 4.0f, resources.getDisplayMetrics()));
        this.f396979m.setLayoutParams(layoutParams11);
        this.f396968b.addView(this.f396979m);
        return this.f396968b;
    }

    public ViewGroup.LayoutParams k(Context context, ViewGroup viewGroup) {
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

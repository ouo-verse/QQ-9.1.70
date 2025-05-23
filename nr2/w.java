package nr2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.timi.game.emo.ui.comm.LabelLayout;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class w implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f421146a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f421147b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f421148c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final View f421149d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f421150e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final FrameLayout f421151f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final RecyclerView f421152g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f421153h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f421154i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final LinearLayout f421155j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final TextView f421156k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f421157l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final LabelLayout f421158m;

    /* renamed from: n, reason: collision with root package name */
    @NonNull
    public final TextView f421159n;

    w(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull View view, @NonNull TextView textView2, @NonNull FrameLayout frameLayout, @NonNull RecyclerView recyclerView, @NonNull RelativeLayout relativeLayout, @NonNull RelativeLayout relativeLayout2, @NonNull LinearLayout linearLayout2, @NonNull TextView textView3, @NonNull RelativeLayout relativeLayout3, @NonNull LabelLayout labelLayout, @NonNull TextView textView4) {
        this.f421146a = linearLayout;
        this.f421147b = textView;
        this.f421148c = imageView;
        this.f421149d = view;
        this.f421150e = textView2;
        this.f421151f = frameLayout;
        this.f421152g = recyclerView;
        this.f421153h = relativeLayout;
        this.f421154i = relativeLayout2;
        this.f421155j = linearLayout2;
        this.f421156k = textView3;
        this.f421157l = relativeLayout3;
        this.f421158m = labelLayout;
        this.f421159n = textView4;
    }

    @NonNull
    public static w e(@NonNull View view) {
        int i3 = R.id.tlf;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.tlf);
        if (textView != null) {
            i3 = R.id.txi;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.txi);
            if (imageView != null) {
                i3 = R.id.f166131ys4;
                View findChildViewById = ViewBindings.findChildViewById(view, R.id.f166131ys4);
                if (findChildViewById != null) {
                    i3 = R.id.zrl;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.zrl);
                    if (textView2 != null) {
                        i3 = R.id.f247309x;
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f247309x);
                        if (frameLayout != null) {
                            i3 = R.id.f73673u7;
                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.f73673u7);
                            if (recyclerView != null) {
                                i3 = R.id.f80504bn;
                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.f80504bn);
                                if (relativeLayout != null) {
                                    i3 = R.id.f80534bq;
                                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.f80534bq);
                                    if (relativeLayout2 != null) {
                                        i3 = R.id.f80574bu;
                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f80574bu);
                                        if (linearLayout != null) {
                                            i3 = R.id.f80594bw;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.f80594bw);
                                            if (textView3 != null) {
                                                i3 = R.id.f80624bz;
                                                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.f80624bz);
                                                if (relativeLayout3 != null) {
                                                    i3 = R.id.f80644c1;
                                                    LabelLayout labelLayout = (LabelLayout) ViewBindings.findChildViewById(view, R.id.f80644c1);
                                                    if (labelLayout != null) {
                                                        i3 = R.id.f80654c2;
                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.f80654c2);
                                                        if (textView4 != null) {
                                                            return new w((LinearLayout) view, textView, imageView, findChildViewById, textView2, frameLayout, recyclerView, relativeLayout, relativeLayout2, linearLayout, textView3, relativeLayout3, labelLayout, textView4);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static w g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.htx, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f421146a;
    }
}

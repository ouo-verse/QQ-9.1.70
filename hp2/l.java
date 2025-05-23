package hp2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.base.view.ShadowFrameLayout;
import com.tencent.mobileqq.search.searchdetail.content.template.ai.ui.FeedBackItemView;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class l implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f405682a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final View f405683b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f405684c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final FeedBackItemView f405685d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final FeedBackItemView f405686e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final FeedBackItemView f405687f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final FeedBackItemView f405688g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f405689h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final ShadowFrameLayout f405690i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final LinearLayout f405691j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final TextView f405692k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final QUIButton f405693l;

    /* renamed from: m, reason: collision with root package name */
    @NonNull
    public final View f405694m;

    l(@NonNull ConstraintLayout constraintLayout, @NonNull View view, @NonNull TextView textView, @NonNull FeedBackItemView feedBackItemView, @NonNull FeedBackItemView feedBackItemView2, @NonNull FeedBackItemView feedBackItemView3, @NonNull FeedBackItemView feedBackItemView4, @NonNull ConstraintLayout constraintLayout2, @NonNull ShadowFrameLayout shadowFrameLayout, @NonNull LinearLayout linearLayout, @NonNull TextView textView2, @NonNull QUIButton qUIButton, @NonNull View view2) {
        this.f405682a = constraintLayout;
        this.f405683b = view;
        this.f405684c = textView;
        this.f405685d = feedBackItemView;
        this.f405686e = feedBackItemView2;
        this.f405687f = feedBackItemView3;
        this.f405688g = feedBackItemView4;
        this.f405689h = constraintLayout2;
        this.f405690i = shadowFrameLayout;
        this.f405691j = linearLayout;
        this.f405692k = textView2;
        this.f405693l = qUIButton;
        this.f405694m = view2;
    }

    @NonNull
    public static l e(@NonNull View view) {
        int i3 = R.id.bmt;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.bmt);
        if (findChildViewById != null) {
            i3 = R.id.v4d;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.v4d);
            if (textView != null) {
                i3 = R.id.xsg;
                FeedBackItemView feedBackItemView = (FeedBackItemView) ViewBindings.findChildViewById(view, R.id.xsg);
                if (feedBackItemView != null) {
                    i3 = R.id.xsh;
                    FeedBackItemView feedBackItemView2 = (FeedBackItemView) ViewBindings.findChildViewById(view, R.id.xsh);
                    if (feedBackItemView2 != null) {
                        i3 = R.id.xsi;
                        FeedBackItemView feedBackItemView3 = (FeedBackItemView) ViewBindings.findChildViewById(view, R.id.xsi);
                        if (feedBackItemView3 != null) {
                            i3 = R.id.xsj;
                            FeedBackItemView feedBackItemView4 = (FeedBackItemView) ViewBindings.findChildViewById(view, R.id.xsj);
                            if (feedBackItemView4 != null) {
                                i3 = R.id.f212900m;
                                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.f212900m);
                                if (constraintLayout != null) {
                                    i3 = R.id.f84074l_;
                                    ShadowFrameLayout shadowFrameLayout = (ShadowFrameLayout) ViewBindings.findChildViewById(view, R.id.f84074l_);
                                    if (shadowFrameLayout != null) {
                                        i3 = R.id.f87024t9;
                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f87024t9);
                                        if (linearLayout != null) {
                                            i3 = R.id.f87034t_;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f87034t_);
                                            if (textView2 != null) {
                                                i3 = R.id.j6p;
                                                QUIButton qUIButton = (QUIButton) ViewBindings.findChildViewById(view, R.id.j6p);
                                                if (qUIButton != null) {
                                                    i3 = R.id.f167009jw1;
                                                    View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.f167009jw1);
                                                    if (findChildViewById2 != null) {
                                                        return new l((ConstraintLayout) view, findChildViewById, textView, feedBackItemView, feedBackItemView2, feedBackItemView3, feedBackItemView4, constraintLayout, shadowFrameLayout, linearLayout, textView2, qUIButton, findChildViewById2);
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
    public static l g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f168331fo2, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f405682a;
    }
}

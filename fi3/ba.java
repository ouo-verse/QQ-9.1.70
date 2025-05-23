package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.zplan.friend.changerole.view.widget.ZPlanFriendRoleStepSelectView;
import com.tencent.mobileqq.zplan.friend.changerole.view.widget.ZPlaneFriendSelectListView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class ba implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f399020a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f399021b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f399022c;

    /* renamed from: d, reason: collision with root package name */
    public final ConstraintLayout f399023d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f399024e;

    /* renamed from: f, reason: collision with root package name */
    public final ZPlanFriendRoleStepSelectView f399025f;

    /* renamed from: g, reason: collision with root package name */
    public final TextView f399026g;

    /* renamed from: h, reason: collision with root package name */
    public final CardView f399027h;

    /* renamed from: i, reason: collision with root package name */
    public final ZPlaneFriendSelectListView f399028i;

    ba(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, ConstraintLayout constraintLayout2, TextView textView2, ZPlanFriendRoleStepSelectView zPlanFriendRoleStepSelectView, TextView textView3, CardView cardView, ZPlaneFriendSelectListView zPlaneFriendSelectListView) {
        this.f399020a = constraintLayout;
        this.f399021b = imageView;
        this.f399022c = textView;
        this.f399023d = constraintLayout2;
        this.f399024e = textView2;
        this.f399025f = zPlanFriendRoleStepSelectView;
        this.f399026g = textView3;
        this.f399027h = cardView;
        this.f399028i = zPlaneFriendSelectListView;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f399020a;
    }

    public static ba e(View view) {
        int i3 = R.id.r3l;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.r3l);
        if (imageView != null) {
            i3 = R.id.r3m;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.r3m);
            if (textView != null) {
                i3 = R.id.r3n;
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.r3n);
                if (constraintLayout != null) {
                    i3 = R.id.r3o;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.r3o);
                    if (textView2 != null) {
                        i3 = R.id.r3p;
                        ZPlanFriendRoleStepSelectView zPlanFriendRoleStepSelectView = (ZPlanFriendRoleStepSelectView) ViewBindings.findChildViewById(view, R.id.r3p);
                        if (zPlanFriendRoleStepSelectView != null) {
                            i3 = R.id.r3q;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.r3q);
                            if (textView3 != null) {
                                i3 = R.id.r5e;
                                CardView cardView = (CardView) ViewBindings.findChildViewById(view, R.id.r5e);
                                if (cardView != null) {
                                    i3 = R.id.r7q;
                                    ZPlaneFriendSelectListView zPlaneFriendSelectListView = (ZPlaneFriendSelectListView) ViewBindings.findChildViewById(view, R.id.r7q);
                                    if (zPlaneFriendSelectListView != null) {
                                        return new ba((ConstraintLayout) view, imageView, textView, constraintLayout, textView2, zPlanFriendRoleStepSelectView, textView3, cardView, zPlaneFriendSelectListView);
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

    public static ba g(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dc9, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}

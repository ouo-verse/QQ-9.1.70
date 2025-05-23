package hp2;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class ac implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f405536a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final View f405537b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final RoundCornerImageView f405538c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final RecyclerView f405539d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f405540e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f405541f;

    ac(@NonNull ConstraintLayout constraintLayout, @NonNull View view, @NonNull RoundCornerImageView roundCornerImageView, @NonNull RecyclerView recyclerView, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView) {
        this.f405536a = constraintLayout;
        this.f405537b = view;
        this.f405538c = roundCornerImageView;
        this.f405539d = recyclerView;
        this.f405540e = constraintLayout2;
        this.f405541f = textView;
    }

    @NonNull
    public static ac e(@NonNull View view) {
        int i3 = R.id.bmt;
        View findChildViewById = ViewBindings.findChildViewById(view, R.id.bmt);
        if (findChildViewById != null) {
            i3 = R.id.df9;
            RoundCornerImageView roundCornerImageView = (RoundCornerImageView) ViewBindings.findChildViewById(view, R.id.df9);
            if (roundCornerImageView != null) {
                i3 = R.id.eap;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.eap);
                if (recyclerView != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    i3 = R.id.title;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.title);
                    if (textView != null) {
                        return new ac(constraintLayout, findChildViewById, roundCornerImageView, recyclerView, constraintLayout, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f405536a;
    }
}

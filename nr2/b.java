package nr2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class b implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f420967a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f420968b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f420969c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final View f420970d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f420971e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final RecyclerView f420972f;

    b(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull View view, @NonNull TextView textView2, @NonNull RecyclerView recyclerView) {
        this.f420967a = constraintLayout;
        this.f420968b = imageView;
        this.f420969c = textView;
        this.f420970d = view;
        this.f420971e = textView2;
        this.f420972f = recyclerView;
    }

    @NonNull
    public static b e(@NonNull View view) {
        int i3 = R.id.gg5;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.gg5);
        if (imageView != null) {
            i3 = R.id.yuy;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.yuy);
            if (textView != null) {
                i3 = R.id.f87484uh;
                View findChildViewById = ViewBindings.findChildViewById(view, R.id.f87484uh);
                if (findChildViewById != null) {
                    i3 = R.id.f166986jo4;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f166986jo4);
                    if (textView2 != null) {
                        i3 = R.id.f114416t_;
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.f114416t_);
                        if (recyclerView != null) {
                            return new b((ConstraintLayout) view, imageView, textView, findChildViewById, textView2, recyclerView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static b g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dx6, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f420967a;
    }
}

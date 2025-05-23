package m53;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.search.QUISearchBar;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class d implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final RelativeLayout f416208a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final QUISearchBar f416209b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final RecyclerView f416210c;

    d(@NonNull RelativeLayout relativeLayout, @NonNull QUISearchBar qUISearchBar, @NonNull RecyclerView recyclerView) {
        this.f416208a = relativeLayout;
        this.f416209b = qUISearchBar;
        this.f416210c = recyclerView;
    }

    @NonNull
    public static d e(@NonNull View view) {
        int i3 = R.id.v5c;
        QUISearchBar qUISearchBar = (QUISearchBar) ViewBindings.findChildViewById(view, R.id.v5c);
        if (qUISearchBar != null) {
            i3 = R.id.ebg;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.ebg);
            if (recyclerView != null) {
                return new d((RelativeLayout) view, qUISearchBar, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static d g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static d h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.e9z, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f416208a;
    }
}

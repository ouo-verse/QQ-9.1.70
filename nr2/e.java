package nr2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.timi.game.widget.MediumBoldTextView;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class e implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f421046a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final RecyclerView f421047b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final MediumBoldTextView f421048c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final View f421049d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final MediumBoldTextView f421050e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final View f421051f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final View f421052g;

    e(@NonNull View view, @NonNull RecyclerView recyclerView, @NonNull MediumBoldTextView mediumBoldTextView, @NonNull View view2, @NonNull MediumBoldTextView mediumBoldTextView2, @NonNull View view3, @NonNull View view4) {
        this.f421046a = view;
        this.f421047b = recyclerView;
        this.f421048c = mediumBoldTextView;
        this.f421049d = view2;
        this.f421050e = mediumBoldTextView2;
        this.f421051f = view3;
        this.f421052g = view4;
    }

    @NonNull
    public static e e(@NonNull View view) {
        int i3 = R.id.s7u;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.s7u);
        if (recyclerView != null) {
            i3 = R.id.f164879u42;
            MediumBoldTextView mediumBoldTextView = (MediumBoldTextView) ViewBindings.findChildViewById(view, R.id.f164879u42);
            if (mediumBoldTextView != null) {
                i3 = R.id.lft;
                View findChildViewById = ViewBindings.findChildViewById(view, R.id.lft);
                if (findChildViewById != null) {
                    i3 = R.id.f98175md;
                    MediumBoldTextView mediumBoldTextView2 = (MediumBoldTextView) ViewBindings.findChildViewById(view, R.id.f98175md);
                    if (mediumBoldTextView2 != null) {
                        i3 = R.id.f100555st;
                        View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.f100555st);
                        if (findChildViewById2 != null) {
                            i3 = R.id.f100565su;
                            View findChildViewById3 = ViewBindings.findChildViewById(view, R.id.f100565su);
                            if (findChildViewById3 != null) {
                                return new e(view, recyclerView, mediumBoldTextView, findChildViewById, mediumBoldTextView2, findChildViewById2, findChildViewById3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static e f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.hso, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f421046a;
    }
}

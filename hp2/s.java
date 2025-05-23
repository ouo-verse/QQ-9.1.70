package hp2;

import android.view.View;
import android.view.ViewStub;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.searchdetail.content.refresh.SearchDetailRefreshHeader;
import com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class s implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f405739a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ViewStub f405740b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ViewStub f405741c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ViewStub f405742d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final RecyclerView f405743e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final SearchDetailRefreshHeader f405744f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final SmartRefreshLayout f405745g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final ViewStub f405746h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f405747i;

    s(@NonNull ConstraintLayout constraintLayout, @NonNull ViewStub viewStub, @NonNull ViewStub viewStub2, @NonNull ViewStub viewStub3, @NonNull RecyclerView recyclerView, @NonNull SearchDetailRefreshHeader searchDetailRefreshHeader, @NonNull SmartRefreshLayout smartRefreshLayout, @NonNull ViewStub viewStub4, @NonNull ConstraintLayout constraintLayout2) {
        this.f405739a = constraintLayout;
        this.f405740b = viewStub;
        this.f405741c = viewStub2;
        this.f405742d = viewStub3;
        this.f405743e = recyclerView;
        this.f405744f = searchDetailRefreshHeader;
        this.f405745g = smartRefreshLayout;
        this.f405746h = viewStub4;
        this.f405747i = constraintLayout2;
    }

    @NonNull
    public static s e(@NonNull View view) {
        int i3 = R.id.uuz;
        ViewStub viewStub = (ViewStub) ViewBindings.findChildViewById(view, R.id.uuz);
        if (viewStub != null) {
            i3 = R.id.vaw;
            ViewStub viewStub2 = (ViewStub) ViewBindings.findChildViewById(view, R.id.vaw);
            if (viewStub2 != null) {
                i3 = R.id.loading_layout;
                ViewStub viewStub3 = (ViewStub) ViewBindings.findChildViewById(view, R.id.loading_layout);
                if (viewStub3 != null) {
                    i3 = R.id.i4m;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.i4m);
                    if (recyclerView != null) {
                        i3 = R.id.f72303qh;
                        SearchDetailRefreshHeader searchDetailRefreshHeader = (SearchDetailRefreshHeader) ViewBindings.findChildViewById(view, R.id.f72303qh);
                        if (searchDetailRefreshHeader != null) {
                            i3 = R.id.f72333qk;
                            SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) ViewBindings.findChildViewById(view, R.id.f72333qk);
                            if (smartRefreshLayout != null) {
                                i3 = R.id.f80894cp;
                                ViewStub viewStub4 = (ViewStub) ViewBindings.findChildViewById(view, R.id.f80894cp);
                                if (viewStub4 != null) {
                                    i3 = R.id.f80904cq;
                                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.f80904cq);
                                    if (constraintLayout != null) {
                                        return new s((ConstraintLayout) view, viewStub, viewStub2, viewStub3, recyclerView, searchDetailRefreshHeader, smartRefreshLayout, viewStub4, constraintLayout);
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

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getMRv() {
        return this.f405739a;
    }
}

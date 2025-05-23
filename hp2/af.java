package hp2;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.searchdetail.content.view.QSearchGuildGuildFeedItemLayout;
import com.tencent.mobileqq.search.searchdetail.content.view.QSearchGuildGuildTitleLayout;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class af implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f405554a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final QSearchGuildGuildFeedItemLayout f405555b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final QSearchGuildGuildFeedItemLayout f405556c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final QSearchGuildGuildFeedItemLayout f405557d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final QSearchGuildGuildTitleLayout f405558e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final LinearLayout f405559f;

    af(@NonNull LinearLayout linearLayout, @NonNull QSearchGuildGuildFeedItemLayout qSearchGuildGuildFeedItemLayout, @NonNull QSearchGuildGuildFeedItemLayout qSearchGuildGuildFeedItemLayout2, @NonNull QSearchGuildGuildFeedItemLayout qSearchGuildGuildFeedItemLayout3, @NonNull QSearchGuildGuildTitleLayout qSearchGuildGuildTitleLayout, @NonNull LinearLayout linearLayout2) {
        this.f405554a = linearLayout;
        this.f405555b = qSearchGuildGuildFeedItemLayout;
        this.f405556c = qSearchGuildGuildFeedItemLayout2;
        this.f405557d = qSearchGuildGuildFeedItemLayout3;
        this.f405558e = qSearchGuildGuildTitleLayout;
        this.f405559f = linearLayout2;
    }

    @NonNull
    public static af e(@NonNull View view) {
        int i3 = R.id.v2z;
        QSearchGuildGuildFeedItemLayout qSearchGuildGuildFeedItemLayout = (QSearchGuildGuildFeedItemLayout) ViewBindings.findChildViewById(view, R.id.v2z);
        if (qSearchGuildGuildFeedItemLayout != null) {
            i3 = R.id.f165179v30;
            QSearchGuildGuildFeedItemLayout qSearchGuildGuildFeedItemLayout2 = (QSearchGuildGuildFeedItemLayout) ViewBindings.findChildViewById(view, R.id.f165179v30);
            if (qSearchGuildGuildFeedItemLayout2 != null) {
                i3 = R.id.f165180v31;
                QSearchGuildGuildFeedItemLayout qSearchGuildGuildFeedItemLayout3 = (QSearchGuildGuildFeedItemLayout) ViewBindings.findChildViewById(view, R.id.f165180v31);
                if (qSearchGuildGuildFeedItemLayout3 != null) {
                    i3 = R.id.x2h;
                    QSearchGuildGuildTitleLayout qSearchGuildGuildTitleLayout = (QSearchGuildGuildTitleLayout) ViewBindings.findChildViewById(view, R.id.x2h);
                    if (qSearchGuildGuildTitleLayout != null) {
                        LinearLayout linearLayout = (LinearLayout) view;
                        return new af(linearLayout, qSearchGuildGuildFeedItemLayout, qSearchGuildGuildFeedItemLayout2, qSearchGuildGuildFeedItemLayout3, qSearchGuildGuildTitleLayout, linearLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f405554a;
    }
}

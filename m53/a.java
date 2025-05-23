package m53;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.biz.qui.profileskin.widget.QUIImageButton;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class a implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f416186a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f416187b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final QUIImageButton f416188c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final QUIImageButton f416189d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f416190e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f416191f;

    a(@NonNull ConstraintLayout constraintLayout, @NonNull FrameLayout frameLayout, @NonNull QUIImageButton qUIImageButton, @NonNull QUIImageButton qUIImageButton2, @NonNull RelativeLayout relativeLayout, @NonNull TextView textView) {
        this.f416186a = constraintLayout;
        this.f416187b = frameLayout;
        this.f416188c = qUIImageButton;
        this.f416189d = qUIImageButton2;
        this.f416190e = relativeLayout;
        this.f416191f = textView;
    }

    @NonNull
    public static a e(@NonNull View view) {
        int i3 = R.id.content;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.content);
        if (frameLayout != null) {
            i3 = R.id.xcj;
            QUIImageButton qUIImageButton = (QUIImageButton) ViewBindings.findChildViewById(view, R.id.xcj);
            if (qUIImageButton != null) {
                i3 = R.id.xcm;
                QUIImageButton qUIImageButton2 = (QUIImageButton) ViewBindings.findChildViewById(view, R.id.xcm);
                if (qUIImageButton2 != null) {
                    i3 = R.id.title_container;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.title_container);
                    if (relativeLayout != null) {
                        i3 = R.id.kbs;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.kbs);
                        if (textView != null) {
                            return new a((ConstraintLayout) view, frameLayout, qUIImageButton, qUIImageButton2, relativeLayout, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static a g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static a h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.e9w, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f416186a;
    }
}

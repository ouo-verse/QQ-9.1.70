package nr2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.timi.game.widget.MediumBoldTextView;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class p implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f421106a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final MediumBoldTextView f421107b;

    p(@NonNull View view, @NonNull MediumBoldTextView mediumBoldTextView) {
        this.f421106a = view;
        this.f421107b = mediumBoldTextView;
    }

    @NonNull
    public static p e(@NonNull View view) {
        MediumBoldTextView mediumBoldTextView = (MediumBoldTextView) ViewBindings.findChildViewById(view, R.id.f24880_b);
        if (mediumBoldTextView != null) {
            return new p(view, mediumBoldTextView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.f24880_b)));
    }

    @NonNull
    public static p f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.htf, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f421106a;
    }
}

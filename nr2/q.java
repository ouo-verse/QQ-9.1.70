package nr2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.timi.game.widget.MediumBoldTextView;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class q implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f421108a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final MediumBoldTextView f421109b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final RoundImageView f421110c;

    q(@NonNull View view, @NonNull MediumBoldTextView mediumBoldTextView, @NonNull RoundImageView roundImageView) {
        this.f421108a = view;
        this.f421109b = mediumBoldTextView;
        this.f421110c = roundImageView;
    }

    @NonNull
    public static q e(@NonNull View view) {
        int i3 = R.id.u7y;
        MediumBoldTextView mediumBoldTextView = (MediumBoldTextView) ViewBindings.findChildViewById(view, R.id.u7y);
        if (mediumBoldTextView != null) {
            i3 = R.id.f114916um;
            RoundImageView roundImageView = (RoundImageView) ViewBindings.findChildViewById(view, R.id.f114916um);
            if (roundImageView != null) {
                return new q(view, mediumBoldTextView, roundImageView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static q f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.hth, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f421108a;
    }
}

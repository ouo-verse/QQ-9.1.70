package nr2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.timi.game.ui.progress.RectangleProgressBar;
import com.tencent.timi.game.ui.widget.RoundCornerImageView;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class ak implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final FrameLayout f420818a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final RoundCornerImageView f420819b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final RectangleProgressBar f420820c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f420821d;

    ak(@NonNull FrameLayout frameLayout, @NonNull RoundCornerImageView roundCornerImageView, @NonNull RectangleProgressBar rectangleProgressBar, @NonNull TextView textView) {
        this.f420818a = frameLayout;
        this.f420819b = roundCornerImageView;
        this.f420820c = rectangleProgressBar;
        this.f420821d = textView;
    }

    @NonNull
    public static ak e(@NonNull View view) {
        int i3 = R.id.zzq;
        RoundCornerImageView roundCornerImageView = (RoundCornerImageView) ViewBindings.findChildViewById(view, R.id.zzq);
        if (roundCornerImageView != null) {
            i3 = R.id.f71753p0;
            RectangleProgressBar rectangleProgressBar = (RectangleProgressBar) ViewBindings.findChildViewById(view, R.id.f71753p0);
            if (rectangleProgressBar != null) {
                i3 = R.id.f88034vz;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f88034vz);
                if (textView != null) {
                    return new ak((FrameLayout) view, roundCornerImageView, rectangleProgressBar, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static ak g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.hvn, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f420818a;
    }
}

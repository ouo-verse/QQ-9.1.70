package nr2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.timi.game.ui.widget.TopCropImageView;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class aw implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final RelativeLayout f420922a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TopCropImageView f420923b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f420924c;

    aw(@NonNull RelativeLayout relativeLayout, @NonNull TopCropImageView topCropImageView, @NonNull TextView textView) {
        this.f420922a = relativeLayout;
        this.f420923b = topCropImageView;
        this.f420924c = textView;
    }

    @NonNull
    public static aw e(@NonNull View view) {
        int i3 = R.id.vo_;
        TopCropImageView topCropImageView = (TopCropImageView) ViewBindings.findChildViewById(view, R.id.vo_);
        if (topCropImageView != null) {
            i3 = R.id.vok;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.vok);
            if (textView != null) {
                return new aw((RelativeLayout) view, topCropImageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static aw g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.hww, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.f420922a;
    }
}

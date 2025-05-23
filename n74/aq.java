package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class aq implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f418688a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f418689b;

    aq(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.f418688a = frameLayout;
        this.f418689b = frameLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f418688a;
    }

    public static aq e(View view) {
        if (view != null) {
            FrameLayout frameLayout = (FrameLayout) view;
            return new aq(frameLayout, frameLayout);
        }
        throw new NullPointerException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
    }

    public static aq g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static aq h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.f167436db0, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}

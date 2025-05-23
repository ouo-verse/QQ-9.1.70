package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class bf implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final URLImageView f399081a;

    /* renamed from: b, reason: collision with root package name */
    public final URLImageView f399082b;

    bf(URLImageView uRLImageView, URLImageView uRLImageView2) {
        this.f399081a = uRLImageView;
        this.f399082b = uRLImageView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public URLImageView getRoot() {
        return this.f399081a;
    }

    public static bf e(View view) {
        if (view != null) {
            URLImageView uRLImageView = (URLImageView) view;
            return new bf(uRLImageView, uRLImageView);
        }
        throw new NullPointerException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
    }

    public static bf g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static bf h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.dd_, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}

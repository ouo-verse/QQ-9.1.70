package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class m implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final TextView f399302a;

    m(TextView textView) {
        this.f399302a = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public TextView getRoot() {
        return this.f399302a;
    }

    public static m e(View view) {
        if (view != null) {
            return new m((TextView) view);
        }
        throw new NullPointerException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
    }

    public static m g(LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    public static m h(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.d7r, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }
}

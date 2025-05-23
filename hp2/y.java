package hp2;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class y implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final TextView f405787a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f405788b;

    y(@NonNull TextView textView, @NonNull TextView textView2) {
        this.f405787a = textView;
        this.f405788b = textView2;
    }

    @NonNull
    public static y e(@NonNull View view) {
        if (view != null) {
            TextView textView = (TextView) view;
            return new y(textView, textView);
        }
        throw new NullPointerException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public TextView getRoot() {
        return this.f405787a;
    }
}

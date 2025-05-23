package n74;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.sqshow.zootopia.nativeui.view.experience.ExperienceCountdownView;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class cf implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final View f419003a;

    /* renamed from: b, reason: collision with root package name */
    public final ExperienceCountdownView f419004b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f419005c;

    cf(View view, ExperienceCountdownView experienceCountdownView, TextView textView) {
        this.f419003a = view;
        this.f419004b = experienceCountdownView;
        this.f419005c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f419003a;
    }

    public static cf e(View view) {
        int i3 = R.id.pkw;
        ExperienceCountdownView experienceCountdownView = (ExperienceCountdownView) ViewBindings.findChildViewById(view, R.id.pkw);
        if (experienceCountdownView != null) {
            i3 = R.id.qj5;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.qj5);
            if (textView != null) {
                return new cf(view, experienceCountdownView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static cf f(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.deh, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}

package nr2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.timi.game.emo.ui.TimiEmoPanelView;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class t implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final ScrollView f421124a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final Button f421125b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final Button f421126c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final Button f421127d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final Button f421128e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final Button f421129f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final Button f421130g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final Button f421131h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final Button f421132i;

    /* renamed from: j, reason: collision with root package name */
    @NonNull
    public final ScrollView f421133j;

    /* renamed from: k, reason: collision with root package name */
    @NonNull
    public final URLImageView f421134k;

    /* renamed from: l, reason: collision with root package name */
    @NonNull
    public final TimiEmoPanelView f421135l;

    t(@NonNull ScrollView scrollView, @NonNull Button button, @NonNull Button button2, @NonNull Button button3, @NonNull Button button4, @NonNull Button button5, @NonNull Button button6, @NonNull Button button7, @NonNull Button button8, @NonNull ScrollView scrollView2, @NonNull URLImageView uRLImageView, @NonNull TimiEmoPanelView timiEmoPanelView) {
        this.f421124a = scrollView;
        this.f421125b = button;
        this.f421126c = button2;
        this.f421127d = button3;
        this.f421128e = button4;
        this.f421129f = button5;
        this.f421130g = button6;
        this.f421131h = button7;
        this.f421132i = button8;
        this.f421133j = scrollView2;
        this.f421134k = uRLImageView;
        this.f421135l = timiEmoPanelView;
    }

    @NonNull
    public static t e(@NonNull View view) {
        int i3 = R.id.tbz;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.tbz);
        if (button != null) {
            i3 = R.id.f164644tc0;
            Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.f164644tc0);
            if (button2 != null) {
                i3 = R.id.f164645tc1;
                Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.f164645tc1);
                if (button3 != null) {
                    i3 = R.id.tc5;
                    Button button4 = (Button) ViewBindings.findChildViewById(view, R.id.tc5);
                    if (button4 != null) {
                        i3 = R.id.tc7;
                        Button button5 = (Button) ViewBindings.findChildViewById(view, R.id.tc7);
                        if (button5 != null) {
                            i3 = R.id.tcb;
                            Button button6 = (Button) ViewBindings.findChildViewById(view, R.id.tcb);
                            if (button6 != null) {
                                i3 = R.id.tcd;
                                Button button7 = (Button) ViewBindings.findChildViewById(view, R.id.tcd);
                                if (button7 != null) {
                                    i3 = R.id.f70093ki;
                                    Button button8 = (Button) ViewBindings.findChildViewById(view, R.id.f70093ki);
                                    if (button8 != null) {
                                        ScrollView scrollView = (ScrollView) view;
                                        i3 = R.id.f94415c8;
                                        URLImageView uRLImageView = (URLImageView) ViewBindings.findChildViewById(view, R.id.f94415c8);
                                        if (uRLImageView != null) {
                                            i3 = R.id.f97595kt;
                                            TimiEmoPanelView timiEmoPanelView = (TimiEmoPanelView) ViewBindings.findChildViewById(view, R.id.f97595kt);
                                            if (timiEmoPanelView != null) {
                                                return new t(scrollView, button, button2, button3, button4, button5, button6, button7, button8, scrollView, uRLImageView, timiEmoPanelView);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static t g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.htu, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public ScrollView getRoot() {
        return this.f421124a;
    }
}

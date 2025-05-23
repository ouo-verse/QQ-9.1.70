package fi3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.zootopia.view.ZootopiaDetailImageGallery;
import com.tencent.mobileqq.zootopia.view.ZootopiaExpandTextView;
import com.tencent.mobileqq.zootopia.view.ZootopiaUserView;
import com.tencent.mobileqq.zootopia.view.ZootopiaVersionView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class x implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    private final View f399426a;

    /* renamed from: b, reason: collision with root package name */
    public final ZootopiaExpandTextView f399427b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f399428c;

    /* renamed from: d, reason: collision with root package name */
    public final ZootopiaDetailImageGallery f399429d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f399430e;

    /* renamed from: f, reason: collision with root package name */
    public final ZootopiaVersionView f399431f;

    /* renamed from: g, reason: collision with root package name */
    public final TextView f399432g;

    /* renamed from: h, reason: collision with root package name */
    public final ZootopiaUserView f399433h;

    x(View view, ZootopiaExpandTextView zootopiaExpandTextView, TextView textView, ZootopiaDetailImageGallery zootopiaDetailImageGallery, TextView textView2, ZootopiaVersionView zootopiaVersionView, TextView textView3, ZootopiaUserView zootopiaUserView) {
        this.f399426a = view;
        this.f399427b = zootopiaExpandTextView;
        this.f399428c = textView;
        this.f399429d = zootopiaDetailImageGallery;
        this.f399430e = textView2;
        this.f399431f = zootopiaVersionView;
        this.f399432g = textView3;
        this.f399433h = zootopiaUserView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.f399426a;
    }

    public static x e(View view) {
        int i3 = R.id.qtd;
        ZootopiaExpandTextView zootopiaExpandTextView = (ZootopiaExpandTextView) ViewBindings.findChildViewById(view, R.id.qtd);
        if (zootopiaExpandTextView != null) {
            i3 = R.id.qze;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.qze);
            if (textView != null) {
                i3 = R.id.qzj;
                ZootopiaDetailImageGallery zootopiaDetailImageGallery = (ZootopiaDetailImageGallery) ViewBindings.findChildViewById(view, R.id.qzj);
                if (zootopiaDetailImageGallery != null) {
                    i3 = R.id.qzm;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.qzm);
                    if (textView2 != null) {
                        i3 = R.id.r2c;
                        ZootopiaVersionView zootopiaVersionView = (ZootopiaVersionView) ViewBindings.findChildViewById(view, R.id.r2c);
                        if (zootopiaVersionView != null) {
                            i3 = R.id.r2f;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.r2f);
                            if (textView3 != null) {
                                i3 = R.id.r2g;
                                ZootopiaUserView zootopiaUserView = (ZootopiaUserView) ViewBindings.findChildViewById(view, R.id.r2g);
                                if (zootopiaUserView != null) {
                                    return new x(view, zootopiaExpandTextView, textView, zootopiaDetailImageGallery, textView2, zootopiaVersionView, textView3, zootopiaUserView);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static x f(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.d8b, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }
}

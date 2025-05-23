package hp2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.biz.qqcircle.immersive.views.search.widget.QFSSearchVideoView;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class p implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f405708a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageFilterView f405709b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f405710c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final Group f405711d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final ImageView f405712e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f405713f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final QFSSearchVideoView f405714g;

    p(@NonNull View view, @NonNull ImageFilterView imageFilterView, @NonNull ImageView imageView, @NonNull Group group, @NonNull ImageView imageView2, @NonNull TextView textView, @NonNull QFSSearchVideoView qFSSearchVideoView) {
        this.f405708a = view;
        this.f405709b = imageFilterView;
        this.f405710c = imageView;
        this.f405711d = group;
        this.f405712e = imageView2;
        this.f405713f = textView;
        this.f405714g = qFSSearchVideoView;
    }

    @NonNull
    public static p e(@NonNull View view) {
        int i3 = R.id.bat;
        ImageFilterView imageFilterView = (ImageFilterView) ViewBindings.findChildViewById(view, R.id.bat);
        if (imageFilterView != null) {
            i3 = R.id.zkm;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.zkm);
            if (imageView != null) {
                i3 = R.id.zpb;
                Group group = (Group) ViewBindings.findChildViewById(view, R.id.zpb);
                if (group != null) {
                    i3 = R.id.lzl;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.lzl);
                    if (imageView2 != null) {
                        i3 = R.id.f25680bh;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.f25680bh);
                        if (textView != null) {
                            i3 = R.id.kvb;
                            QFSSearchVideoView qFSSearchVideoView = (QFSSearchVideoView) ViewBindings.findChildViewById(view, R.id.kvb);
                            if (qFSSearchVideoView != null) {
                                return new p(view, imageFilterView, imageView, group, imageView2, textView, qFSSearchVideoView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static p f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.foe, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f405708a;
    }
}

package p81;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.input.edit.AIOEditText;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class l implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f425774a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f425775b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final AIOEditText f425776c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f425777d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final QUIButton f425778e;

    l(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull AIOEditText aIOEditText, @NonNull ImageView imageView2, @NonNull QUIButton qUIButton) {
        this.f425774a = linearLayout;
        this.f425775b = imageView;
        this.f425776c = aIOEditText;
        this.f425777d = imageView2;
        this.f425778e = qUIButton;
    }

    @NonNull
    public static l e(@NonNull View view) {
        int i3 = R.id.emo_btn;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.emo_btn);
        if (imageView != null) {
            i3 = R.id.input;
            AIOEditText aIOEditText = (AIOEditText) ViewBindings.findChildViewById(view, R.id.input);
            if (aIOEditText != null) {
                i3 = R.id.plus_btn;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.plus_btn);
                if (imageView2 != null) {
                    i3 = R.id.send_btn;
                    QUIButton qUIButton = (QUIButton) ViewBindings.findChildViewById(view, R.id.send_btn);
                    if (qUIButton != null) {
                        return new l((LinearLayout) view, imageView, aIOEditText, imageView2, qUIButton);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static l g(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, null, false);
    }

    @NonNull
    public static l h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        View inflate = layoutInflater.inflate(R.layout.fs6, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f425774a;
    }
}

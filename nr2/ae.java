package nr2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.timi.game.liveroom.impl.room.gameinfo.LiveGameInfoTextView;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class ae implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f420789a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f420790b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f420791c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final LiveGameInfoTextView f420792d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TextView f420793e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final ImageView f420794f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final LinearLayout f420795g;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    public final LinearLayout f420796h;

    /* renamed from: i, reason: collision with root package name */
    @NonNull
    public final ImageView f420797i;

    ae(@NonNull View view, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull LiveGameInfoTextView liveGameInfoTextView, @NonNull TextView textView2, @NonNull ImageView imageView2, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull ImageView imageView3) {
        this.f420789a = view;
        this.f420790b = imageView;
        this.f420791c = textView;
        this.f420792d = liveGameInfoTextView;
        this.f420793e = textView2;
        this.f420794f = imageView2;
        this.f420795g = linearLayout;
        this.f420796h = linearLayout2;
        this.f420797i = imageView3;
    }

    @NonNull
    public static ae e(@NonNull View view) {
        int i3 = R.id.t2w;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.t2w);
        if (imageView != null) {
            i3 = R.id.uvy;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.uvy);
            if (textView != null) {
                i3 = R.id.uvz;
                LiveGameInfoTextView liveGameInfoTextView = (LiveGameInfoTextView) ViewBindings.findChildViewById(view, R.id.uvz);
                if (liveGameInfoTextView != null) {
                    i3 = R.id.f165132v01;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f165132v01);
                    if (textView2 != null) {
                        i3 = R.id.f165825xp1;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.f165825xp1);
                        if (imageView2 != null) {
                            i3 = R.id.f165826xp2;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f165826xp2);
                            if (linearLayout != null) {
                                i3 = R.id.f165827xp3;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.f165827xp3);
                                if (linearLayout2 != null) {
                                    i3 = R.id.f165828xp4;
                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.f165828xp4);
                                    if (imageView3 != null) {
                                        return new ae(view, imageView, textView, liveGameInfoTextView, textView2, imageView2, linearLayout, linearLayout2, imageView3);
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
    public static ae f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.huu, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f420789a;
    }
}

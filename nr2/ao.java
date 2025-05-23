package nr2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.timi.game.profile.impl.view.record.MessageSmobaRecordView;
import com.tencent.timi.game.userinfo.api.view.AvatarRoundImageView;
import com.tencent.timi.game.widget.MediumBoldTextView;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class ao implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f420846a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f420847b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final MessageSmobaRecordView f420848c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final AvatarRoundImageView f420849d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f420850e;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    public final MediumBoldTextView f420851f;

    /* renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f420852g;

    ao(@NonNull View view, @NonNull TextView textView, @NonNull MessageSmobaRecordView messageSmobaRecordView, @NonNull AvatarRoundImageView avatarRoundImageView, @NonNull RelativeLayout relativeLayout, @NonNull MediumBoldTextView mediumBoldTextView, @NonNull TextView textView2) {
        this.f420846a = view;
        this.f420847b = textView;
        this.f420848c = messageSmobaRecordView;
        this.f420849d = avatarRoundImageView;
        this.f420850e = relativeLayout;
        this.f420851f = mediumBoldTextView;
        this.f420852g = textView2;
    }

    @NonNull
    public static ao e(@NonNull View view) {
        int i3 = R.id.ugi;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.ugi);
        if (textView != null) {
            i3 = R.id.f71703ov;
            MessageSmobaRecordView messageSmobaRecordView = (MessageSmobaRecordView) ViewBindings.findChildViewById(view, R.id.f71703ov);
            if (messageSmobaRecordView != null) {
                i3 = R.id.f114936uo;
                AvatarRoundImageView avatarRoundImageView = (AvatarRoundImageView) ViewBindings.findChildViewById(view, R.id.f114936uo);
                if (avatarRoundImageView != null) {
                    i3 = R.id.f114956uq;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.f114956uq);
                    if (relativeLayout != null) {
                        i3 = R.id.f115006uv;
                        MediumBoldTextView mediumBoldTextView = (MediumBoldTextView) ViewBindings.findChildViewById(view, R.id.f115006uv);
                        if (mediumBoldTextView != null) {
                            i3 = R.id.f115066v1;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.f115066v1);
                            if (textView2 != null) {
                                return new ao(view, textView, messageSmobaRecordView, avatarRoundImageView, relativeLayout, mediumBoldTextView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static ao f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.hvx, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f420846a;
    }
}

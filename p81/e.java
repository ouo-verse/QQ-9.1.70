package p81;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.qqnt.aio.holder.template.BubbleLayoutCompatPress;
import com.tencent.qqnt.aio.holder.template.TemplateLayout;
import com.tx.x2j.AioMsgCenterNoAvatarTemplateBinding;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class e implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final TemplateLayout f425726a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final BubbleLayoutCompatPress f425727b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final ViewStub f425728c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final FrameLayout f425729d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TemplateLayout f425730e;

    e(@NonNull TemplateLayout templateLayout, @NonNull BubbleLayoutCompatPress bubbleLayoutCompatPress, @NonNull ViewStub viewStub, @NonNull FrameLayout frameLayout, @NonNull TemplateLayout templateLayout2) {
        this.f425726a = templateLayout;
        this.f425727b = bubbleLayoutCompatPress;
        this.f425728c = viewStub;
        this.f425729d = frameLayout;
        this.f425730e = templateLayout2;
    }

    @NonNull
    public static e e(@NonNull View view) {
        int i3 = R.id.zfv;
        BubbleLayoutCompatPress bubbleLayoutCompatPress = (BubbleLayoutCompatPress) ViewBindings.findChildViewById(view, R.id.zfv);
        if (bubbleLayoutCompatPress != null) {
            i3 = R.id.zg7;
            ViewStub viewStub = (ViewStub) ViewBindings.findChildViewById(view, R.id.zg7);
            if (viewStub != null) {
                i3 = R.id.f166336f24;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.f166336f24);
                if (frameLayout != null) {
                    TemplateLayout templateLayout = (TemplateLayout) view;
                    return new e(templateLayout, bubbleLayoutCompatPress, viewStub, frameLayout, templateLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static e g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z16) {
        AioMsgCenterNoAvatarTemplateBinding aioMsgCenterNoAvatarTemplateBinding = new AioMsgCenterNoAvatarTemplateBinding();
        aioMsgCenterNoAvatarTemplateBinding.t(layoutInflater, viewGroup, z16);
        View u16 = aioMsgCenterNoAvatarTemplateBinding.u();
        if (u16 != null) {
            return e(u16);
        }
        View inflate = layoutInflater.inflate(R.layout.dvm, viewGroup, false);
        if (z16) {
            viewGroup.addView(inflate);
        }
        return e(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public TemplateLayout getRoot() {
        return this.f425726a;
    }
}

package nr2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.timi.game.component.chat.input.ExpandHallInputBoxView;
import com.tencent.timi.game.component.chat.message.MessageLayoutImpl;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class r implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f421111a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final ExpandHallInputBoxView f421112b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final MessageLayoutImpl f421113c;

    r(@NonNull View view, @NonNull ExpandHallInputBoxView expandHallInputBoxView, @NonNull MessageLayoutImpl messageLayoutImpl) {
        this.f421111a = view;
        this.f421112b = expandHallInputBoxView;
        this.f421113c = messageLayoutImpl;
    }

    @NonNull
    public static r e(@NonNull View view) {
        int i3 = R.id.xob;
        ExpandHallInputBoxView expandHallInputBoxView = (ExpandHallInputBoxView) ViewBindings.findChildViewById(view, R.id.xob);
        if (expandHallInputBoxView != null) {
            i3 = R.id.z59;
            MessageLayoutImpl messageLayoutImpl = (MessageLayoutImpl) ViewBindings.findChildViewById(view, R.id.z59);
            if (messageLayoutImpl != null) {
                return new r(view, expandHallInputBoxView, messageLayoutImpl);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static r f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.htq, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: getRoot */
    public View getMRv() {
        return this.f421111a;
    }
}

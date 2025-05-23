package nr2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.timi.game.component.chat.message.MessageLayoutImpl;
import com.tencent.timi.game.team.impl.chat.TeamInputView;
import com.tencent.timi.game.team.impl.input.TeamOperateView;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class at implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    private final View f420893a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final TeamInputView f420894b;

    /* renamed from: c, reason: collision with root package name */
    @NonNull
    public final View f420895c;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    public final MessageLayoutImpl f420896d;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    public final TeamOperateView f420897e;

    at(@NonNull View view, @NonNull TeamInputView teamInputView, @NonNull View view2, @NonNull MessageLayoutImpl messageLayoutImpl, @NonNull TeamOperateView teamOperateView) {
        this.f420893a = view;
        this.f420894b = teamInputView;
        this.f420895c = view2;
        this.f420896d = messageLayoutImpl;
        this.f420897e = teamOperateView;
    }

    @NonNull
    public static at e(@NonNull View view) {
        int i3 = R.id.xob;
        TeamInputView teamInputView = (TeamInputView) ViewBindings.findChildViewById(view, R.id.xob);
        if (teamInputView != null) {
            i3 = R.id.f166248z54;
            View findChildViewById = ViewBindings.findChildViewById(view, R.id.f166248z54);
            if (findChildViewById != null) {
                i3 = R.id.z59;
                MessageLayoutImpl messageLayoutImpl = (MessageLayoutImpl) ViewBindings.findChildViewById(view, R.id.z59);
                if (messageLayoutImpl != null) {
                    i3 = R.id.f93365_d;
                    TeamOperateView teamOperateView = (TeamOperateView) ViewBindings.findChildViewById(view, R.id.f93365_d);
                    if (teamOperateView != null) {
                        return new at(view, teamInputView, findChildViewById, messageLayoutImpl, teamOperateView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    @NonNull
    public static at f(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.hwn, viewGroup);
            return e(viewGroup);
        }
        throw new NullPointerException(HippyNestedScrollComponent.PRIORITY_PARENT);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    /* renamed from: getRoot */
    public View getMRv() {
        return this.f420893a;
    }
}

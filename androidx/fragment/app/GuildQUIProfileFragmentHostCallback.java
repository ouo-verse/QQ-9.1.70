package androidx.fragment.app;

import android.content.Context;
import android.view.GuildQUIProfileLayoutInflater;
import android.view.LayoutInflater;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.richframework.layoutinflater.RFWDelegateLayoutInflater;
import com.tencent.mobileqq.guild.quiprofile.GuildActivityWrapper;
import com.tencent.mobileqq.guild.quiprofile.f;
import com.tencent.richframework.argus.ContextWrapperFactory;
import java.util.Objects;

/* loaded from: classes.dex */
class GuildQUIProfileFragmentHostCallback extends FragmentActivity.HostCallbacks {
    private final FragmentActivity activity;
    private final FragmentHostCallback<?> origin;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildQUIProfileFragmentHostCallback(FragmentActivity fragmentActivity, FragmentHostCallback<?> fragmentHostCallback, boolean z16) {
        super();
        Objects.requireNonNull(fragmentActivity);
        if (z16) {
            this.activity = ContextWrapperFactory.INSTANCE.getFragmentActivityWrapper(GuildActivityWrapper.SupportVasThemeActivityWrapper.class, fragmentActivity);
        } else {
            this.activity = ContextWrapperFactory.INSTANCE.getFragmentActivityWrapper(GuildActivityWrapper.class, fragmentActivity);
        }
        this.origin = fragmentHostCallback;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.fragment.app.FragmentHostCallback
    @NonNull
    public Context getContext() {
        return this.activity;
    }

    public FragmentHostCallback getOrigin() {
        return this.origin;
    }

    @Override // androidx.fragment.app.FragmentActivity.HostCallbacks, androidx.fragment.app.FragmentHostCallback
    @NonNull
    public LayoutInflater onGetLayoutInflater() {
        LayoutInflater onGetLayoutInflater = super.onGetLayoutInflater();
        if (onGetLayoutInflater instanceof RFWDelegateLayoutInflater) {
            RFWDelegateLayoutInflater rFWDelegateLayoutInflater = (RFWDelegateLayoutInflater) onGetLayoutInflater.cloneInContext(this.activity);
            rFWDelegateLayoutInflater.addDelegate(new f());
            return rFWDelegateLayoutInflater;
        }
        if (onGetLayoutInflater instanceof GuildQUIProfileLayoutInflater) {
            Context context = onGetLayoutInflater.getContext();
            FragmentActivity fragmentActivity = this.activity;
            if (context == fragmentActivity) {
                return onGetLayoutInflater;
            }
            return onGetLayoutInflater.cloneInContext(fragmentActivity);
        }
        return new GuildQUIProfileLayoutInflater(onGetLayoutInflater, this.activity);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.fragment.app.FragmentActivity.HostCallbacks, androidx.fragment.app.FragmentHostCallback
    public FragmentActivity onGetHost() {
        return this.activity;
    }
}

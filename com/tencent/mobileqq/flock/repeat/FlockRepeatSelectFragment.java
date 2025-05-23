package com.tencent.mobileqq.flock.repeat;

import android.content.Context;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.flock.base.FlockBaseFragment;
import com.tencent.mobileqq.flock.repeat.part.FlockRepeatEndTimePart;
import com.tencent.mobileqq.flock.repeat.part.FlockRepeatNavigatePart;
import com.tencent.mobileqq.flock.repeat.part.FlockRepeatSetResultPart;
import com.tencent.mobileqq.flock.repeat.part.FlockRepeatTipsPart;
import com.tencent.mobileqq.flock.repeat.part.FlockRepeatTypePart;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0014J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0007H\u0014\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/flock/repeat/FlockRepeatSelectFragment;", "Lcom/tencent/mobileqq/flock/base/FlockBaseFragment;", "()V", "assembleParts", "", "Lcom/tencent/biz/richframework/part/Part;", "getContentLayoutId", "", "getPageId", "", "getStatusBarColor", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class FlockRepeatSelectFragment extends FlockBaseFragment {
    static IPatchRedirector $redirector_;

    public FlockRepeatSelectFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new FlockRepeatNavigatePart(), new FlockRepeatTypePart(), new FlockRepeatEndTimePart(), new FlockRepeatTipsPart(), new FlockRepeatSetResultPart());
            return mutableListOf;
        }
        return (List) iPatchRedirector.redirect((short) 3, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return R.layout.f167963e90;
    }

    @Override // com.tencent.mobileqq.flock.base.FlockBaseFragment
    @NotNull
    public String getPageId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "pg_bas_partner_publishing_repeat_select";
    }

    @Override // com.tencent.mobileqq.flock.base.FlockBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        Context context = getContext();
        if (context != null) {
            return context.getColor(R.color.qui_common_fill_light_primary);
        }
        return 0;
    }
}

package com.tencent.mobileqq.flock.publish;

import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.flock.base.FlockLayerBaseFragment;
import com.tencent.mobileqq.flock.publish.part.i;
import com.tencent.mobileqq.flock.publish.part.l;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/flock/publish/FlockPublishGalleryLayerFragment;", "Lcom/tencent/mobileqq/flock/base/FlockLayerBaseFragment;", "()V", "assembleParts", "", "Lcom/tencent/biz/richframework/part/Part;", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class FlockPublishGalleryLayerFragment extends FlockLayerBaseFragment {
    static IPatchRedirector $redirector_;

    public FlockPublishGalleryLayerFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.flock.base.FlockLayerBaseFragment, com.tencent.richframework.gallery.QQLayerFragment, com.tencent.richframework.gallery.RFWLayerFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        List<Part> assembleParts = super.assembleParts();
        assembleParts.add(new l());
        assembleParts.add(new i());
        return assembleParts;
    }
}

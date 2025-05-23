package com.tencent.mobileqq.preview;

import com.tencent.biz.richframework.delegate.impl.RFWConfig;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.preview.parts.TBSToolLayerBottomPart;
import com.tencent.mobileqq.preview.parts.c;
import com.tencent.mobileqq.preview.parts.d;
import com.tencent.mobileqq.preview.parts.h;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.richframework.gallery.QQLayerFragment;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/preview/TBSToolMediaPreviewLayerFragment;", "Lcom/tencent/richframework/gallery/QQLayerFragment;", "()V", "assembleParts", "", "Lcom/tencent/biz/richframework/part/Part;", "getPlayScene", "", "isOpenNavigationBarImmersive", "", "qqfile-filebrowser-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class TBSToolMediaPreviewLayerFragment extends QQLayerFragment {
    static IPatchRedirector $redirector_;

    public TBSToolMediaPreviewLayerFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.richframework.gallery.QQLayerFragment, com.tencent.richframework.gallery.RFWLayerFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(super.assembleParts());
        arrayList.add(new TBSToolLayerBottomPart(isOpenNavigationBarImmersive()));
        arrayList.add(new d());
        arrayList.add(new h());
        arrayList.add(new c());
        return arrayList;
    }

    @Override // com.tencent.richframework.gallery.QQLayerFragment
    public int getPlayScene() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 171;
    }

    @Override // com.tencent.richframework.gallery.RFWLayerFragment
    public boolean isOpenNavigationBarImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (RFWConfig.getConfigValue("aio_open_immersive_navigation_bar", true)) {
            return true;
        }
        return false;
    }
}

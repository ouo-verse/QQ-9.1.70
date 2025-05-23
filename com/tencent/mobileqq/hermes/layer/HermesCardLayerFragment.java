package com.tencent.mobileqq.hermes.layer;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.compat.RFWImmersiveUtils;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.hermes.layer.part.HermesLayerMorePart;
import com.tencent.mobileqq.hermes.layer.part.b;
import com.tencent.mobileqq.hermes.layer.part.g;
import com.tencent.mobileqq.hermes.layer.part.i;
import com.tencent.mobileqq.hermes.layer.part.j;
import com.tencent.mobileqq.hermes.share.HermesAddFavoriteAction;
import com.tencent.mobileqq.hermes.share.HermesSaveToAlbumAction;
import com.tencent.mobileqq.hermes.share.HermesShareActionManager;
import com.tencent.mobileqq.hermes.share.HermesShareToQQFriendAction;
import com.tencent.mobileqq.hermes.share.HermesShareToQZoneAction;
import com.tencent.mobileqq.hermes.share.HermesShareToWXFriendAction;
import com.tencent.mobileqq.hermes.share.HermesShareToWXTimeLineAction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.richframework.gallery.part.RFWCardPagePart;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.QQPermissionHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J-\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016\u00a2\u0006\u0002\u0010\u000fJ\u001a\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/hermes/layer/HermesCardLayerFragment;", "Lcom/tencent/mobileqq/hermes/layer/HermesBaseFragment;", "()V", "assembleParts", "", "Lcom/tencent/biz/richframework/part/Part;", "onRequestPermissionsResult", "", "requestCode", "", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "view", "Landroid/view/View;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "hermes-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class HermesCardLayerFragment extends HermesBaseFragment {
    static IPatchRedirector $redirector_;

    public HermesCardLayerFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.richframework.gallery.RFWLayerFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.tencent.mobileqq.hermes.layer.part.a());
        arrayList.add(new RFWCardPagePart());
        arrayList.add(new i());
        arrayList.add(new b());
        arrayList.add(new g());
        arrayList.add(new j());
        HermesShareActionManager hermesShareActionManager = new HermesShareActionManager();
        hermesShareActionManager.a(new HermesShareToQQFriendAction());
        hermesShareActionManager.a(new HermesShareToQZoneAction());
        hermesShareActionManager.a(new HermesShareToWXFriendAction());
        hermesShareActionManager.a(new HermesShareToWXTimeLineAction());
        hermesShareActionManager.a(new HermesSaveToAlbumAction());
        hermesShareActionManager.a(new HermesAddFavoriteAction());
        arrayList.add(new HermesLayerMorePart(hermesShareActionManager));
        return arrayList;
    }

    @Override // com.tencent.mobileqq.hermes.layer.HermesBaseFragment, androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int requestCode, @NotNull String[] permissions, @NotNull int[] grantResults) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(requestCode), permissions, grantResults);
            return;
        }
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        QQPermissionHelper.requestResult(this, requestCode, permissions, grantResults);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Window window;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        FragmentActivity activity = getActivity();
        Window window2 = null;
        if (activity != null) {
            window = activity.getWindow();
        } else {
            window = null;
        }
        Intrinsics.checkNotNull(window);
        RFWImmersiveUtils.setTransparentStatusBar(window);
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            window2 = activity2.getWindow();
        }
        RFWImmersiveUtils.setImmersiveLayout(window2, false);
    }
}

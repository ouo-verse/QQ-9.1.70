package com.tencent.mobileqq.sharepanel.forward.v2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.sharepanel.forward.ForwardPreviewPanelFragment;
import com.tencent.mobileqq.sharepanel.forward.d;
import com.tencent.mobileqq.sharepanel.forward.part.ForwardPreviewReportPart;
import com.tencent.mobileqq.sharepanel.forward.v2.part.ForwardPreviewSelectedContactPart;
import com.tencent.mobileqq.sharepanel.forward.v2.part.ForwardPreviewSwitchPart;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R\u001a\u0010\u0014\u001a\u00020\u000f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/forward/v2/ForwardPreviewPanelFragmentV2;", "Lcom/tencent/mobileqq/sharepanel/forward/ForwardPreviewPanelFragment;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "dismiss", "Landroidx/fragment/app/Fragment;", "J", "Landroidx/fragment/app/Fragment;", "getHostFragment", "()Landroidx/fragment/app/Fragment;", "hostFragment", "Lcom/tencent/mobileqq/sharepanel/forward/d;", "param", "<init>", "(Lcom/tencent/mobileqq/sharepanel/forward/d;)V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ForwardPreviewPanelFragmentV2 extends ForwardPreviewPanelFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Fragment hostFragment;

    public ForwardPreviewPanelFragmentV2() {
        this(null, 1, 0 == true ? 1 : 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, (Object) this);
    }

    @Override // com.tencent.mobileqq.sharepanel.forward.ForwardPreviewPanelFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        super.assembleParts();
        ArrayList arrayList = new ArrayList();
        d ph5 = ph();
        if (ph5 != null) {
            arrayList.add(new ForwardPreviewSelectedContactPart(ph5));
            arrayList.add(new ForwardPreviewSwitchPart(ph5));
            arrayList.add(new com.tencent.mobileqq.sharepanel.forward.v2.part.b(ph5));
            arrayList.add(new ForwardPreviewReportPart(ph5));
        }
        List<Part> qh5 = qh();
        if (qh5 != null) {
            qh5.addAll(0, arrayList);
        }
        List<Part> qh6 = qh();
        if (qh6 == null) {
            return new ArrayList();
        }
        return qh6;
    }

    @Override // com.tencent.mobileqq.sharepanel.forward.ForwardPreviewPanelFragment, androidx.fragment.app.DialogFragment
    public void dismiss() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            dismissAllowingStateLoss();
        }
    }

    @Override // com.tencent.mobileqq.sharepanel.forward.ForwardPreviewPanelFragment, com.tencent.biz.richframework.part.IPartFragmentHost
    @NotNull
    public Fragment getHostFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Fragment) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.hostFragment;
    }

    @Override // com.tencent.mobileqq.sharepanel.forward.ForwardPreviewPanelFragment, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            rootView = (View) iPatchRedirector.redirect((short) 4, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            View inflate = inflater.inflate(R.layout.e9g, container, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026out_v2, container, false)");
            th(inflate);
            View findViewById = getRootView().findViewById(R.id.b9t);
            Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.content_container)");
            sh(findViewById);
            com.tencent.mobileqq.sharepanel.util.b.f287600a.a(getContentView());
            rootView = getRootView();
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, rootView);
        return rootView;
    }

    public /* synthetic */ ForwardPreviewPanelFragmentV2(d dVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : dVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, dVar, Integer.valueOf(i3), defaultConstructorMarker);
    }

    public ForwardPreviewPanelFragmentV2(@Nullable d dVar) {
        super(dVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.hostFragment = this;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) dVar);
        }
    }
}

package com.tencent.mobileqq.troop.edittroopinfo.parts.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.ViewModel;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.troop.edittroopinfo.EditTroopInfoFragment;
import com.tencent.mobileqq.troop.edittroopinfo.TroopEditInfoViewModel;
import com.tencent.mobileqq.troop.troopinfoedit.TroopBindGameItemHelper;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b+\u0010,J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u001a\u0010\u0010\u001a\u00020\u00062\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\u000f\u001a\u00020\u000eJ\u0012\u0010\u0011\u001a\u00020\u00062\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\fJV\u0010\u001e\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u00142(\b\u0002\u0010\u0019\u001a\"\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016j\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001d\u001a\u00020\u001cJ,\u0010\"\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001f\u001a\u00020\u000e2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\u0014R\"\u0010*\u001a\u00020#8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/troop/edittroopinfo/parts/base/c;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onPartCreate", "Lcom/tencent/mobileqq/troop/edittroopinfo/EditTroopInfoFragment;", "B9", "Lcom/tencent/mobileqq/troop/troopinfoedit/TroopBindGameItemHelper;", "A9", "Lcom/tencent/mobileqq/widget/listitem/a;", DownloadInfo.spKey_Config, "", "isVisible", "E9", "D9", "Landroid/view/View;", "view", "", "elementId", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "params", "Lcom/tencent/qqlive/module/videoreport/constants/ExposurePolicy;", "exposurePolicy", "Lcom/tencent/qqlive/module/videoreport/constants/ClickPolicy;", IECDtReport.ACTION_CLICK_POLICY, "x9", "hasSet", "pid", "eventId", "F9", "Lcom/tencent/mobileqq/troop/edittroopinfo/TroopEditInfoViewModel;", "d", "Lcom/tencent/mobileqq/troop/edittroopinfo/TroopEditInfoViewModel;", "C9", "()Lcom/tencent/mobileqq/troop/edittroopinfo/TroopEditInfoViewModel;", "H9", "(Lcom/tencent/mobileqq/troop/edittroopinfo/TroopEditInfoViewModel;)V", "viewModel", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public class c extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    protected TroopEditInfoViewModel viewModel;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ void G9(c cVar, View view, boolean z16, String str, String str2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 4) != 0) {
                str = "group_set_type";
            }
            if ((i3 & 8) != 0) {
                str2 = "dt_clck";
            }
            cVar.F9(view, z16, str, str2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportDTEvent");
    }

    public static /* synthetic */ void z9(c cVar, View view, String str, HashMap hashMap, ExposurePolicy exposurePolicy, ClickPolicy clickPolicy, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 4) != 0) {
                hashMap = null;
            }
            HashMap hashMap2 = hashMap;
            if ((i3 & 8) != 0) {
                exposurePolicy = ExposurePolicy.REPORT_NONE;
            }
            ExposurePolicy exposurePolicy2 = exposurePolicy;
            if ((i3 & 16) != 0) {
                clickPolicy = ClickPolicy.REPORT_NONE;
            }
            cVar.x9(view, str, hashMap2, exposurePolicy2, clickPolicy);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bindDtReport");
    }

    @Nullable
    public final TroopBindGameItemHelper A9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (TroopBindGameItemHelper) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return getPartHost().Ah();
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: B9, reason: merged with bridge method [inline-methods] */
    public EditTroopInfoFragment getPartHost() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (EditTroopInfoFragment) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        IPartHost partHost = super.getPartHost();
        Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type com.tencent.mobileqq.troop.edittroopinfo.EditTroopInfoFragment");
        return (EditTroopInfoFragment) partHost;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final TroopEditInfoViewModel C9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TroopEditInfoViewModel) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        TroopEditInfoViewModel troopEditInfoViewModel = this.viewModel;
        if (troopEditInfoViewModel != null) {
            return troopEditInfoViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public final void D9(@NotNull com.tencent.mobileqq.widget.listitem.a<?> config) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) config);
            return;
        }
        Intrinsics.checkNotNullParameter(config, "config");
        QUIListItemAdapter adapter = getPartHost().zh().getAdapter();
        if (adapter != null) {
            adapter.l0(config);
        }
    }

    public final void E9(@NotNull com.tencent.mobileqq.widget.listitem.a<?> config, boolean isVisible) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, config, Boolean.valueOf(isVisible));
            return;
        }
        Intrinsics.checkNotNullParameter(config, "config");
        QUIListItemAdapter adapter = getPartHost().zh().getAdapter();
        if (adapter != null) {
            adapter.m0(config, isVisible);
        }
    }

    public final void F9(@Nullable View view, boolean hasSet, @NotNull String pid, @NotNull String eventId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, view, Boolean.valueOf(hasSet), pid, eventId);
            return;
        }
        Intrinsics.checkNotNullParameter(pid, "pid");
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        HashMap hashMap = new HashMap();
        hashMap.put(pid, Integer.valueOf(hasSet ? 1 : 0));
        Unit unit = Unit.INSTANCE;
        VideoReport.reportEvent(eventId, view, hashMap);
    }

    protected final void H9(@NotNull TroopEditInfoViewModel troopEditInfoViewModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) troopEditInfoViewModel);
        } else {
            Intrinsics.checkNotNullParameter(troopEditInfoViewModel, "<set-?>");
            this.viewModel = troopEditInfoViewModel;
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        super.onPartCreate(activity, savedInstanceState);
        ViewModel viewModel = getViewModel(TroopEditInfoViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(TroopEditInfoViewModel::class.java)");
        H9((TroopEditInfoViewModel) viewModel);
    }

    public final void x9(@Nullable View view, @NotNull String elementId, @Nullable HashMap<String, Object> params, @NotNull ExposurePolicy exposurePolicy, @NotNull ClickPolicy clickPolicy) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, view, elementId, params, exposurePolicy, clickPolicy);
            return;
        }
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        Intrinsics.checkNotNullParameter(exposurePolicy, "exposurePolicy");
        Intrinsics.checkNotNullParameter(clickPolicy, "clickPolicy");
        VideoReport.setElementId(view, elementId);
        VideoReport.setElementParams(view, params);
        VideoReport.setElementExposePolicy(view, exposurePolicy);
        VideoReport.setElementClickPolicy(view, clickPolicy);
    }
}

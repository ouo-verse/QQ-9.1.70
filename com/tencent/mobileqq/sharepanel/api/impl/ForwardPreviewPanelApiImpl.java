package com.tencent.mobileqq.sharepanel.api.impl;

import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.sharepanel.api.IForwardPreviewPanelApi;
import com.tencent.mobileqq.sharepanel.forward.b;
import com.tencent.mobileqq.sharepanel.forward.f;
import com.tencent.mobileqq.sharepanel.forward.g;
import com.tencent.mobileqq.sharepanel.forward.v2.a;
import com.tencent.mobileqq.sharepanel.model.SharePanelContactItem;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016J0\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J0\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/api/impl/ForwardPreviewPanelApiImpl;", "Lcom/tencent/mobileqq/sharepanel/api/IForwardPreviewPanelApi;", "", "enable", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/sharepanel/model/SharePanelContactItem;", "Lkotlin/collections/ArrayList;", "targetList", "Lcom/tencent/mobileqq/sharepanel/forward/f;", "uiControl", "Lcom/tencent/mobileqq/sharepanel/forward/g;", OperateCustomButton.OPERATE_CREATE, "createV2", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ForwardPreviewPanelApiImpl implements IForwardPreviewPanelApi {
    static IPatchRedirector $redirector_;

    public ForwardPreviewPanelApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.sharepanel.api.IForwardPreviewPanelApi
    @NotNull
    public g create(@NotNull FragmentActivity activity, @NotNull ArrayList<SharePanelContactItem> targetList, @NotNull f uiControl) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (g) iPatchRedirector.redirect((short) 3, this, activity, targetList, uiControl);
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(targetList, "targetList");
        Intrinsics.checkNotNullParameter(uiControl, "uiControl");
        return new b(activity, targetList, uiControl);
    }

    @Override // com.tencent.mobileqq.sharepanel.api.IForwardPreviewPanelApi
    @NotNull
    public g createV2(@NotNull FragmentActivity activity, @NotNull ArrayList<SharePanelContactItem> targetList, @NotNull f uiControl) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (g) iPatchRedirector.redirect((short) 4, this, activity, targetList, uiControl);
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(targetList, "targetList");
        Intrinsics.checkNotNullParameter(uiControl, "uiControl");
        return new a(activity, targetList, uiControl);
    }

    @Override // com.tencent.mobileqq.sharepanel.api.IForwardPreviewPanelApi
    public boolean enable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return !((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("revert_fs_bottom_sheet_preview", false);
    }
}

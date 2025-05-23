package com.tencent.mobileqq.troop.selectmember.api.impl;

import android.app.Activity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.troop.selectmember.TroopSelectMemberFragment;
import com.tencent.mobileqq.troop.selectmember.api.ITroopSelectMemberApi;
import com.tencent.mobileqq.troop.selectmember.config.TroopSelectMemberConfig;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/troop/selectmember/api/impl/TroopSelectMemberApiImpl;", "Lcom/tencent/mobileqq/troop/selectmember/api/ITroopSelectMemberApi;", "()V", "createSelectTroopMemberFragment", "Lcom/tencent/mobileqq/troop/selectmember/TroopSelectMemberFragment;", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/troop/selectmember/config/TroopSelectMemberConfig;", "launchSelectTroopMemberFragment", "", "launchSelectTroopMemberFragmentForResult", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "requestCode", "", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class TroopSelectMemberApiImpl implements ITroopSelectMemberApi {
    static IPatchRedirector $redirector_;

    public TroopSelectMemberApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.selectmember.api.ITroopSelectMemberApi
    public void launchSelectTroopMemberFragment(@NotNull TroopSelectMemberConfig config) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) config);
        } else {
            Intrinsics.checkNotNullParameter(config, "config");
            TroopSelectMemberFragment.Companion.d(TroopSelectMemberFragment.INSTANCE, config, null, null, 6, null);
        }
    }

    @Override // com.tencent.mobileqq.troop.selectmember.api.ITroopSelectMemberApi
    public void launchSelectTroopMemberFragmentForResult(@NotNull TroopSelectMemberConfig config, @NotNull Activity activity, int requestCode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, config, activity, Integer.valueOf(requestCode));
            return;
        }
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(activity, "activity");
        TroopSelectMemberFragment.INSTANCE.c(config, activity, Integer.valueOf(requestCode));
    }

    @Override // com.tencent.mobileqq.troop.selectmember.api.ITroopSelectMemberApi
    @Nullable
    public TroopSelectMemberFragment createSelectTroopMemberFragment(@NotNull TroopSelectMemberConfig config) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (TroopSelectMemberFragment) iPatchRedirector.redirect((short) 4, (Object) this, (Object) config);
        }
        Intrinsics.checkNotNullParameter(config, "config");
        return TroopSelectMemberFragment.INSTANCE.a(config);
    }
}

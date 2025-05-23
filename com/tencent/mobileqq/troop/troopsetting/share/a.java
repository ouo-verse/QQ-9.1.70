package com.tencent.mobileqq.troop.troopsetting.share;

import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.troopsetting.share.troopsetting.TroopSettingShareManager;
import com.tencent.mobileqq.troop.troopshare.tempapi.ITroopShareUtility;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0004J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0004\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/share/a;", "", "", "", "d", "Lcom/tencent/mobileqq/troop/troopsetting/share/b;", "shareContext", "", "a", "c", "b", "", "e", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public abstract class a {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract void a(@NotNull b shareContext);

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final String b(@NotNull b shareContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) shareContext);
        }
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        String str = shareContext.h().mRichFingerMemo;
        if (TextUtils.isEmpty(str)) {
            str = ((ITroopShareUtility) QRoute.api(ITroopShareUtility.class)).getTroopShareDescDefaultWording();
        }
        if (TextUtils.isEmpty(str)) {
            shareContext.b().getString(R.string.hjq);
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final String c(@NotNull b shareContext) {
        String str;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) shareContext);
        }
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        TroopInfoData h16 = shareContext.h();
        if (TextUtils.isEmpty(h16.troopName)) {
            str = h16.troopUin;
        } else {
            str = h16.troopName;
        }
        if (!h16.hasSetNewTroopName && (i3 = h16.wMemberNum) > 0) {
            return str + "(" + i3 + ")";
        }
        return str;
    }

    @NotNull
    public abstract List<String> d();

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean e(@NotNull b shareContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) shareContext)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        if (!WXShareHelper.b0().e0()) {
            TroopSettingShareManager.Companion companion = TroopSettingShareManager.INSTANCE;
            QBaseActivity b16 = shareContext.b();
            String qqStr = HardCodeUtil.qqStr(R.string.f173257ih1);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.wx_not_installed)");
            companion.b(b16, 1, qqStr);
            return true;
        }
        if (!WXShareHelper.b0().f0()) {
            TroopSettingShareManager.Companion companion2 = TroopSettingShareManager.INSTANCE;
            QBaseActivity b17 = shareContext.b();
            String qqStr2 = HardCodeUtil.qqStr(R.string.f173258ih2);
            Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(R.string.wx_version_too_low)");
            companion2.b(b17, 1, qqStr2);
            return true;
        }
        return false;
    }
}

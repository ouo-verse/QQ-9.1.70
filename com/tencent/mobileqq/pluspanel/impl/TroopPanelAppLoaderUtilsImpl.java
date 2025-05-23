package com.tencent.mobileqq.pluspanel.impl;

import com.tencent.mobileqq.pluspanel.ITroopPanelAppLoaderUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.robot.api.IRobotUtilApi;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.qqnt.pluspanel.utils.a;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J(\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00062\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/pluspanel/impl/TroopPanelAppLoaderUtilsImpl;", "Lcom/tencent/mobileqq/pluspanel/ITroopPanelAppLoaderUtils;", "()V", "afterAppIdList", "", "mTabHideRedEnvelopeExpName", "", "checkIfNeedHideApp", "", "curId", "troopAppInfo", "Lcom/tencent/mobileqq/troop/data/TroopAIOAppInfo;", "fillAppListIfNeed", "", "list", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class TroopPanelAppLoaderUtilsImpl implements ITroopPanelAppLoaderUtils {
    static IPatchRedirector $redirector_;

    @NotNull
    private final int[] afterAppIdList;

    @NotNull
    private final String mTabHideRedEnvelopeExpName;

    public TroopPanelAppLoaderUtilsImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mTabHideRedEnvelopeExpName = "exp_red_envelope_hide";
        a.Companion companion = a.INSTANCE;
        this.afterAppIdList = new int[]{companion.K(), companion.Y(), companion.c(), companion.M(), companion.u0(), companion.V()};
    }

    @Override // com.tencent.mobileqq.pluspanel.ITroopPanelAppLoaderUtils
    public boolean checkIfNeedHideApp(@NotNull String curId, @NotNull TroopAIOAppInfo troopAppInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) curId, (Object) troopAppInfo)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(curId, "curId");
        Intrinsics.checkNotNullParameter(troopAppInfo, "troopAppInfo");
        int i3 = troopAppInfo.appid;
        a.Companion companion = a.INSTANCE;
        if (i3 == companion.q0() || troopAppInfo.appid == companion.K()) {
            return true;
        }
        if (troopAppInfo.appid == companion.V()) {
            if (SimpleUIUtil.getSimpleUISwitch()) {
                return false;
            }
            ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(this.mTabHideRedEnvelopeExpName);
            Intrinsics.checkNotNullExpressionValue(expEntity, "getInstance()\n          \u2026abHideRedEnvelopeExpName)");
            expEntity.reportExpExposure();
            return expEntity.isExperiment();
        }
        if (troopAppInfo.appid != 102078357) {
            return false;
        }
        return !((IRobotUtilApi) QRoute.api(IRobotUtilApi.class)).canInviteRobotInGroup(MobileQQ.sMobileQQ.peekAppRuntime(), curId);
    }

    @Override // com.tencent.mobileqq.pluspanel.ITroopPanelAppLoaderUtils
    public void fillAppListIfNeed(@NotNull String curId, @NotNull ArrayList<Integer> list) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) curId, (Object) list);
            return;
        }
        Intrinsics.checkNotNullParameter(curId, "curId");
        Intrinsics.checkNotNullParameter(list, "list");
        int[] iArr = this.afterAppIdList;
        int length = iArr.length;
        int i16 = 0;
        while (true) {
            if (i16 < length) {
                i3 = list.indexOf(Integer.valueOf(iArr[i16]));
                if (i3 != -1) {
                    break;
                } else {
                    i16++;
                }
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 == -1) {
            list.add(Integer.valueOf(a.INSTANCE.r0()));
        } else {
            list.add(i3, Integer.valueOf(a.INSTANCE.r0()));
        }
    }
}

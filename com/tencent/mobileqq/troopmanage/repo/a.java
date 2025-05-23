package com.tencent.mobileqq.troopmanage.repo;

import android.os.Bundle;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troopmanage.api.ITroopManageService;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0016\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\u0007H&J\b\u0010\t\u001a\u00020\u0002H&J\b\u0010\u000b\u001a\u00020\nH&J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH&J\b\u0010\u0011\u001a\u00020\u0004H&JK\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152!\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00040\u0018H&J\b\u0010\u001f\u001a\u00020\u001eH&J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H&J\b\u0010!\u001a\u00020\u0004H&J\b\u0010\"\u001a\u00020\u0004H&J \u0010'\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u000eH&J \u0010+\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\u0012H&J\u0010\u0010-\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\nH&J\u0016\u00100\u001a\u00020\u00042\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000e0.H&J8\u00107\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u00122\u0006\u00103\u001a\u00020\u00122\u0006\u00104\u001a\u00020\n2\u0006\u00105\u001a\u00020\u00122\u0006\u00106\u001a\u00020\u0012H&JC\u0010<\u001a\u00020\u00042\u0006\u00108\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u00109\u001a\u00020\u00122!\u0010;\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(:\u0012\u0004\u0012\u00020\u00040\u0018H&J=\u0010?\u001a\u00020\u00042\b\u0010)\u001a\u0004\u0018\u00010\u000e2\u0006\u0010=\u001a\u00020\u00122!\u0010;\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(>\u0012\u0004\u0012\u00020\u00040\u0018H&J=\u0010@\u001a\u00020\u00042\b\u0010)\u001a\u0004\u0018\u00010\u000e2\u0006\u0010=\u001a\u00020\u00122!\u0010;\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(>\u0012\u0004\u0012\u00020\u00040\u0018H&J\"\u0010A\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u000e2\b\u0010&\u001a\u0004\u0018\u00010\u000e2\u0006\u0010$\u001a\u00020#H&J\u0010\u0010C\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\nH&\u00a8\u0006D"}, d2 = {"Lcom/tencent/mobileqq/troopmanage/repo/a;", "", "Landroid/os/Bundle;", "arguments", "", "b", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/troopmanage/repo/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "", "p", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "", "from", "j", "l", "", "isChecked", "troopUin", "", "troopPrivilegeFlag", "privilegeMask", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "callback", "e", "Lcom/tencent/mobileqq/troopmanage/api/ITroopManageService;", DomainData.DOMAIN_NAME, "c", "i", "d", "", QCircleDaTongConstant.ElementParamValue.OPERATION, IProfileProtocolConst.PARAM_TROOP_CODE, "memberUin", "r", "updateFromWeb", "groupCode", "autoApprovalSetting", ReportConstant.COSTREPORT_PREFIX, "adminsCount", "t", "", "troopAdminList", "g", "isCanSearchByTroopUin", "isCanSearchByKeywords", "onlyInvite", "opType", "isSetFeeSuccess", "isSetSuccess", tl.h.F, "bSuc", "bAllow", "enable", "failCallback", "k", "allowUpload", "allow", "o", "f", "u", "cGroupOption", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public interface a {
    @NotNull
    Bundle a();

    void b(@NotNull Bundle arguments);

    void c(boolean isChecked);

    void d();

    void e(boolean isChecked, @NotNull String troopUin, long troopPrivilegeFlag, long privilegeMask, @NotNull Function1<? super Boolean, Unit> callback);

    void f(@Nullable String groupCode, boolean allowUpload, @NotNull Function1<? super Boolean, Unit> failCallback);

    void g(@NotNull List<String> troopAdminList);

    void h(boolean isCanSearchByTroopUin, boolean isCanSearchByKeywords, boolean onlyInvite, int opType, boolean isSetFeeSuccess, boolean isSetSuccess);

    void i();

    void j(@NotNull LifecycleOwner lifecycleOwner, @NotNull String from);

    void k(boolean bSuc, @NotNull String troopUin, boolean bAllow, @NotNull Function1<? super Boolean, Unit> failCallback);

    void l();

    @NotNull
    b m();

    @NotNull
    ITroopManageService n();

    void o(@Nullable String groupCode, boolean allowUpload, @NotNull Function1<? super Boolean, Unit> failCallback);

    void onDestroy();

    int p();

    void q(int cGroupOption);

    void r(byte operation, @NotNull String troopCode, @NotNull String memberUin);

    void s(boolean updateFromWeb, long groupCode, boolean autoApprovalSetting);

    void t(int adminsCount);

    void u(@NotNull String troopUin, @Nullable String memberUin, byte operation);
}

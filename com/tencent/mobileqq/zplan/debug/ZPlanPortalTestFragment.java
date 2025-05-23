package com.tencent.mobileqq.zplan.debug;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0014J&\u0010\u0012\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014J\u001a\u0010\u0015\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0018R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0018R\u0018\u0010!\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u0018\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/zplan/debug/ZPlanPortalTestFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "", "isChecked", "", "key", "", "ph", "getUin", "", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", "Landroid/widget/CompoundButton;", "buttonView", "onCheckedChanged", "Lcom/tencent/mobileqq/widget/FormSwitchItem;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/widget/FormSwitchItem;", "debugPortalBuyFail", "D", "debugPortalSaveFail", "E", "debugPortalPayFail", UserInfo.SEX_FEMALE, "debugNewPortal", "G", "debugDynamicPortalNativeAppReuse", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanPortalTestFragment extends QIphoneTitleBarFragment implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: C, reason: from kotlin metadata */
    private FormSwitchItem debugPortalBuyFail;

    /* renamed from: D, reason: from kotlin metadata */
    private FormSwitchItem debugPortalSaveFail;

    /* renamed from: E, reason: from kotlin metadata */
    private FormSwitchItem debugPortalPayFail;

    /* renamed from: F, reason: from kotlin metadata */
    private FormSwitchItem debugNewPortal;

    /* renamed from: G, reason: from kotlin metadata */
    private FormSwitchItem debugDynamicPortalNativeAppReuse;

    private final String getUin() {
        return MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
    }

    private final void ph(boolean isChecked, String key) {
        String uin = getUin();
        if (uin == null || uin.length() == 0) {
            QLog.e("IphoneTitleBarFragment", 1, "updateSwitch " + key + " uin invalid");
        }
        j74.a.f409621a.e(uin, isChecked, key);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.doOnCreateView(inflater, container, savedInstanceState);
        String uin = getUin();
        View findViewById = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f166401zq1);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type com.tencent.mobileqq.widget.FormSwitchItem");
        FormSwitchItem formSwitchItem = (FormSwitchItem) findViewById;
        this.debugNewPortal = formSwitchItem;
        if (formSwitchItem != null) {
            formSwitchItem.setOnCheckedChangeListener(this);
        }
        FormSwitchItem formSwitchItem2 = this.debugNewPortal;
        if (formSwitchItem2 != null) {
            formSwitchItem2.setChecked(j74.a.f409621a.a(uin, "zplan_new_portal", true));
        }
        View findViewById2 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f165045up4);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type com.tencent.mobileqq.widget.FormSwitchItem");
        FormSwitchItem formSwitchItem3 = (FormSwitchItem) findViewById2;
        this.debugDynamicPortalNativeAppReuse = formSwitchItem3;
        if (formSwitchItem3 != null) {
            formSwitchItem3.setOnCheckedChangeListener(this);
        }
        FormSwitchItem formSwitchItem4 = this.debugDynamicPortalNativeAppReuse;
        if (formSwitchItem4 != null) {
            formSwitchItem4.setChecked(j74.a.f409621a.a(uin, "zplan_dynamic_portal_native_app_reuse", false));
        }
        View findViewById3 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f126727pj);
        Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type com.tencent.mobileqq.widget.FormSwitchItem");
        FormSwitchItem formSwitchItem5 = (FormSwitchItem) findViewById3;
        this.debugPortalBuyFail = formSwitchItem5;
        if (formSwitchItem5 != null) {
            formSwitchItem5.setOnCheckedChangeListener(this);
        }
        FormSwitchItem formSwitchItem6 = this.debugPortalBuyFail;
        if (formSwitchItem6 != null) {
            formSwitchItem6.setChecked(j74.a.f409621a.a(uin, "zplan_debug_portal_buy_fail", false));
        }
        View findViewById4 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f126747pl);
        Intrinsics.checkNotNull(findViewById4, "null cannot be cast to non-null type com.tencent.mobileqq.widget.FormSwitchItem");
        FormSwitchItem formSwitchItem7 = (FormSwitchItem) findViewById4;
        this.debugPortalSaveFail = formSwitchItem7;
        if (formSwitchItem7 != null) {
            formSwitchItem7.setOnCheckedChangeListener(this);
        }
        FormSwitchItem formSwitchItem8 = this.debugPortalSaveFail;
        if (formSwitchItem8 != null) {
            formSwitchItem8.setChecked(j74.a.f409621a.a(uin, "zplan_debug_portal_save_fail", false));
        }
        View findViewById5 = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f126737pk);
        Intrinsics.checkNotNull(findViewById5, "null cannot be cast to non-null type com.tencent.mobileqq.widget.FormSwitchItem");
        FormSwitchItem formSwitchItem9 = (FormSwitchItem) findViewById5;
        this.debugPortalPayFail = formSwitchItem9;
        if (formSwitchItem9 != null) {
            formSwitchItem9.setOnCheckedChangeListener(this);
        }
        FormSwitchItem formSwitchItem10 = this.debugPortalPayFail;
        if (formSwitchItem10 == null) {
            return;
        }
        formSwitchItem10.setChecked(j74.a.f409621a.a(uin, "zplan_debug_portal_pay_fail", false));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.i95;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        FormSwitchItem formSwitchItem = this.debugPortalBuyFail;
        if (Intrinsics.areEqual(buttonView, formSwitchItem != null ? formSwitchItem.getSwitch() : null)) {
            ph(isChecked, "zplan_debug_portal_buy_fail");
            return;
        }
        FormSwitchItem formSwitchItem2 = this.debugPortalSaveFail;
        if (Intrinsics.areEqual(buttonView, formSwitchItem2 != null ? formSwitchItem2.getSwitch() : null)) {
            ph(isChecked, "zplan_debug_portal_save_fail");
            return;
        }
        FormSwitchItem formSwitchItem3 = this.debugPortalPayFail;
        if (Intrinsics.areEqual(buttonView, formSwitchItem3 != null ? formSwitchItem3.getSwitch() : null)) {
            ph(isChecked, "zplan_debug_portal_pay_fail");
            return;
        }
        FormSwitchItem formSwitchItem4 = this.debugNewPortal;
        if (Intrinsics.areEqual(buttonView, formSwitchItem4 != null ? formSwitchItem4.getSwitch() : null)) {
            ph(isChecked, "zplan_new_portal");
            return;
        }
        FormSwitchItem formSwitchItem5 = this.debugDynamicPortalNativeAppReuse;
        if (Intrinsics.areEqual(buttonView, formSwitchItem5 != null ? formSwitchItem5.getSwitch() : null)) {
            ph(isChecked, "zplan_dynamic_portal_native_app_reuse");
        }
    }
}

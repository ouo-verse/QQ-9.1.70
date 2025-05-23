package com.tencent.mobileqq.zplan.utils;

import android.view.View;
import android.widget.CompoundButton;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zplan.model.AccessibleDetail;
import com.tencent.mobileqq.zplan.setting.SwitchSetting;
import com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001,B\t\b\u0002\u00a2\u0006\u0004\b*\u0010+J\"\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007J$\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0007J$\u0010\u0015\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0007J&\u0010\u0018\u001a\u00020\u00132\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0007J0\u0010 \u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0007J\u0010\u0010!\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0007J.\u0010$\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\u0016\u0010&\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020%J\u0016\u0010)\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010(\u001a\u00020'\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/y;", "", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "resID", "iconType", "", "g", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "viewId", "stringId", "Lcom/tencent/mobileqq/widget/FormSimpleItem;", "c", "Lcom/tencent/mobileqq/widget/FormSwitchItem;", "switchItem", "", "isChecked", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "listener", "e", "Lcom/tencent/mobileqq/zplan/utils/y$a;", "switchChangeListener", "d", "view", "", DTConstants.TAG.ELEMENT, "Lcom/tencent/qqlive/module/videoreport/constants/ClickPolicy;", IECDtReport.ACTION_CLICK_POLICY, "Lcom/tencent/qqlive/module/videoreport/constants/ExposurePolicy;", "exposurePolicy", "f", tl.h.F, "Landroid/widget/CompoundButton;", "buttonView", "b", "Lji3/l;", "i", "", "scene", "k", "<init>", "()V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public static final y f335851a = new y();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/y$a;", "", "Landroid/widget/CompoundButton;", "buttonView", "", "isChecked", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "changeListener", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public interface a {
        void a(CompoundButton buttonView, boolean isChecked, CompoundButton.OnCheckedChangeListener changeListener);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/utils/y$b", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "Landroid/widget/CompoundButton;", "buttonView", "", "isChecked", "", "onCheckedChanged", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QBaseActivity f335852d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ FormSwitchItem f335853e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f335854f;

        b(QBaseActivity qBaseActivity, FormSwitchItem formSwitchItem, a aVar) {
            this.f335852d = qBaseActivity;
            this.f335853e = formSwitchItem;
            this.f335854f = aVar;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            Intrinsics.checkNotNullParameter(buttonView, "buttonView");
            QLog.d("SettingUtil", 4, "toggleSwitch: " + isChecked);
            if (!y.f335851a.b(this.f335852d, this.f335853e, buttonView, this)) {
                QLog.d("SettingUtil", 1, "checkNetwork: is not support net" + isChecked);
                return;
            }
            a aVar = this.f335854f;
            if (aVar != null) {
                aVar.a(buttonView, isChecked, this);
            }
        }
    }

    y() {
    }

    @JvmStatic
    public static final CompoundButton.OnCheckedChangeListener d(QBaseActivity activity, FormSwitchItem switchItem, a switchChangeListener) {
        return new b(activity, switchItem, switchChangeListener);
    }

    @JvmStatic
    public static final void f(View view, String element, ClickPolicy clickPolicy, ExposurePolicy exposurePolicy) {
        VideoReport.setElementId(view, element);
        VideoReport.setElementClickPolicy(view, clickPolicy);
        VideoReport.setElementExposePolicy(view, exposurePolicy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(boolean z16, ji3.l listener, boolean z17) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        QLog.d("SettingUtil", 2, "updateQZoneSwitchStatus success = " + z17 + ", isChecked = " + z16);
        if (!z17) {
            listener.a(false);
            return;
        }
        if (z16) {
            com.tencent.mobileqq.zplan.setting.c.n(z16);
            h(z16);
        }
        com.tencent.mobileqq.zplan.setting.c.o(SwitchSetting.DYNAMIC_SETTING, z16);
        f335851a.k(z16, com.tencent.shadow.dynamic.host.Constant.FROM_ID_UNINSTALL_PLUGIN);
    }

    public final void i(final boolean isChecked, final ji3.l listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair(SwitchSetting.DYNAMIC_SETTING, Boolean.valueOf(isChecked)));
        if (isChecked) {
            arrayList.add(new Pair(SwitchSetting.MASTER_SETTING, Boolean.valueOf(isChecked)));
        }
        com.tencent.mobileqq.zplan.setting.e.f335451a.g(arrayList, new nk3.a() { // from class: com.tencent.mobileqq.zplan.utils.x
            @Override // nk3.a
            public final void onResult(boolean z16) {
                y.j(isChecked, listener, z16);
            }
        });
    }

    public final void k(boolean isChecked, long scene) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            AccessibleDetail zplanAccessibleDetail = ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).getZplanAccessibleDetail(scene, peekAppRuntime.getLongAccountUin());
            if (zplanAccessibleDetail == null) {
                return;
            }
            zplanAccessibleDetail.settingPass = isChecked ? 1 : 0;
            QLog.i("SettingUtil", 1, "updateZPlanDetailForCache detail:" + zplanAccessibleDetail);
            ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).updateCache(zplanAccessibleDetail);
        }
    }

    @JvmStatic
    public static final void e(FormSwitchItem switchItem, boolean isChecked, CompoundButton.OnCheckedChangeListener listener) {
        if (switchItem == null) {
            QLog.i("SettingUtil", 1, "refreshSwitch switchItem == null");
            return;
        }
        switchItem.setOnCheckedChangeListener(null);
        switchItem.setChecked(isChecked);
        switchItem.setOnCheckedChangeListener(listener);
    }

    @JvmStatic
    public static final void g(QBaseActivity activity, int resID, int iconType) {
        if (activity == null) {
            QLog.i("SettingUtil", 1, "toast activity == null");
        } else {
            QQToast.makeText(activity, iconType, resID, 0).show(activity.getTitleBarHeight());
        }
    }

    @JvmStatic
    public static final FormSimpleItem c(View rootView, int viewId, int stringId) {
        if (rootView == null) {
            QLog.i("SettingUtil", 1, "rootView == null");
            return null;
        }
        FormSimpleItem formSimpleItem = (FormSimpleItem) rootView.findViewById(viewId);
        if (formSimpleItem == null) {
            return null;
        }
        String string = rootView.getResources().getString(stringId);
        Intrinsics.checkNotNullExpressionValue(string, "rootView.resources.getString(stringId)");
        formSimpleItem.setLeftText(string);
        formSimpleItem.setContentDescription(string);
        return formSimpleItem;
    }

    public final boolean b(QBaseActivity activity, FormSwitchItem switchItem, CompoundButton buttonView, CompoundButton.OnCheckedChangeListener listener) {
        if (activity != null && buttonView != null) {
            if (NetworkUtil.isNetSupport(activity)) {
                return true;
            }
            g(activity, R.string.b3j, 1);
            e(switchItem, !buttonView.isChecked(), listener);
            return false;
        }
        QLog.i("SettingUtil", 1, "checkNetworkAndToast activity||buttonView == null");
        return false;
    }

    @JvmStatic
    public static final void h(boolean isChecked) {
        if (!isChecked) {
            y yVar = f335851a;
            yVar.k(false, 1004L);
            yVar.k(false, com.tencent.shadow.dynamic.host.Constant.FROM_ID_UNINSTALL_PLUGIN);
            yVar.k(false, 1009L);
            return;
        }
        y yVar2 = f335851a;
        yVar2.k(com.tencent.mobileqq.zplan.setting.c.h(SwitchSetting.PROFILE_CARD_SETTING), 1004L);
        yVar2.k(com.tencent.mobileqq.zplan.setting.c.h(SwitchSetting.DYNAMIC_SETTING), com.tencent.shadow.dynamic.host.Constant.FROM_ID_UNINSTALL_PLUGIN);
        yVar2.k(com.tencent.mobileqq.zplan.setting.c.h(SwitchSetting.AIO_AVATAR_SETTING), 1009L);
    }
}

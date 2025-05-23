package com.tencent.mobileqq.leba.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.annotation.StringRes;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.leba.ILebaUIStyleSettingApi;
import com.tencent.mobileqq.leba.view.QZoneStyleRadioGroup;
import com.tencent.mobileqq.pad.m;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQSettingMeABTestHelper;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QFormSimpleItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.model.AccessibleDetail;
import com.tencent.mobileqq.zplan.utils.api.IZPlanAccessibleHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qzonehub.api.IQZonePageApi;
import com.tencent.shadow.dynamic.host.Constant;
import com.tencent.util.UiThreadUtil;
import cooperation.qzone.api.QZoneApiProxy;
import ji3.l;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 22\u00020\u0001:\u0002BCB%\u0012\u0006\u0010<\u001a\u00020\u001d\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010=\u0012\b\b\u0002\u0010?\u001a\u00020\b\u00a2\u0006\u0004\b@\u0010AJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J\u001a\u0010\u0012\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\b\b\u0001\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\bH\u0002J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002R\u0016\u0010\u0018\u001a\u00020\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010*R\u0016\u0010/\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010*R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00105\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00102R\u0016\u00107\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010*R\u0016\u00109\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u0010*R\u0016\u0010;\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010*\u00a8\u0006D"}, d2 = {"Lcom/tencent/mobileqq/leba/view/QZoneStyleRadioGroup;", "Landroid/widget/LinearLayout;", "", "r", "l", "j", "", "isChecked", "", "id", "k", "o", "Landroid/widget/RadioGroup;", "radioGroup", "t", "showQzoneFrame", ReportConstant.COSTREPORT_PREFIX, "p", "u", "type", DomainData.DOMAIN_NAME, "v", "d", "Landroid/widget/LinearLayout;", "mContainer", "Landroid/view/View;", "e", "Landroid/view/View;", "mTitle", "Landroid/content/Context;", "f", "Landroid/content/Context;", "mContext", "Lcom/tencent/mobileqq/widget/FormSwitchItem;", tl.h.F, "Lcom/tencent/mobileqq/widget/FormSwitchItem;", "mZPlanSwitchItem", "Lcom/tencent/mobileqq/widget/QFormSimpleItem;", "i", "Lcom/tencent/mobileqq/widget/QFormSimpleItem;", "mZPlanSettingBackgroundItem", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "mIsZPlanQZoneEnabled", BdhLogUtil.LogTag.Tag_Conn, "mIsZPlanDynamicAccessible", "D", "mSettingMeDisableLebaExpGroup", "", "E", "J", "mLastClickTime", UserInfo.SEX_FEMALE, "mLastToastTime", "G", "mIsUserClickForSwitch", "H", "mIsUserClickForRadioGroup", "I", "mEnableZPlanNativeAppFilament", "context", "Landroid/util/AttributeSet;", "attr", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class QZoneStyleRadioGroup extends LinearLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean mIsZPlanDynamicAccessible;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean mSettingMeDisableLebaExpGroup;

    /* renamed from: E, reason: from kotlin metadata */
    private long mLastClickTime;

    /* renamed from: F, reason: from kotlin metadata */
    private long mLastToastTime;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean mIsUserClickForSwitch;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean mIsUserClickForRadioGroup;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean mEnableZPlanNativeAppFilament;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LinearLayout mContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private View mTitle;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context mContext;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private FormSwitchItem mZPlanSwitchItem;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private QFormSimpleItem mZPlanSettingBackgroundItem;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mIsZPlanQZoneEnabled;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/leba/view/QZoneStyleRadioGroup$a;", "", "", "MIN_CLICK_TIME", "J", "MIN_TOAST_TIME", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.leba.view.QZoneStyleRadioGroup$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\t\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\"\u0010\r\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/leba/view/QZoneStyleRadioGroup$b;", "Lji3/l;", "", "isSuccess", "", "a", "Z", "mIsChecked", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/leba/view/QZoneStyleRadioGroup;", "kotlin.jvm.PlatformType", "b", "Lmqq/util/WeakReference;", "mQZoneStyleRadioGroupRef", "isChecked", "qZoneStyleRadioGroup", "<init>", "(ZLcom/tencent/mobileqq/leba/view/QZoneStyleRadioGroup;)V", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b implements l {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final boolean mIsChecked;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<QZoneStyleRadioGroup> mQZoneStyleRadioGroupRef;

        public b(boolean z16, @NotNull QZoneStyleRadioGroup qZoneStyleRadioGroup) {
            Intrinsics.checkNotNullParameter(qZoneStyleRadioGroup, "qZoneStyleRadioGroup");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), qZoneStyleRadioGroup);
            } else {
                this.mIsChecked = z16;
                this.mQZoneStyleRadioGroupRef = new WeakReference<>(qZoneStyleRadioGroup);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(b this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            QLog.e("QZoneStyleRadioGroup", 1, "updateZPlanSettingQZoneSwitch failed");
            QZoneStyleRadioGroup qZoneStyleRadioGroup = this$0.mQZoneStyleRadioGroupRef.get();
            if (qZoneStyleRadioGroup == null) {
                return;
            }
            QQToast.makeText(qZoneStyleRadioGroup.mContext, 1, R.string.f162261zy, 0).show();
            qZoneStyleRadioGroup.v(!this$0.mIsChecked);
        }

        @Override // ji3.l
        public void a(boolean isSuccess) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, isSuccess);
            } else {
                if (isSuccess) {
                    return;
                }
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.leba.view.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        QZoneStyleRadioGroup.b.c(QZoneStyleRadioGroup.b.this);
                    }
                });
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/leba/view/QZoneStyleRadioGroup$c", "Lji3/j;", "Lcom/tencent/mobileqq/zplan/model/AccessibleDetail;", "detail", "", "a", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class c implements ji3.j {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QZoneStyleRadioGroup.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(QZoneStyleRadioGroup this$0, boolean z16) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.v(z16);
            this$0.o();
        }

        @Override // ji3.j
        public void a(@NotNull AccessibleDetail detail) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) detail);
                return;
            }
            Intrinsics.checkNotNullParameter(detail, "detail");
            boolean isPassWithoutSetting = detail.isPassWithoutSetting();
            if (isPassWithoutSetting != QZoneStyleRadioGroup.this.mIsZPlanDynamicAccessible) {
                final boolean isAccessible = detail.isAccessible();
                QLog.i("QZoneStyleRadioGroup", 1, "isPassWithoutSetting = " + isPassWithoutSetting + ", isInWhiteList = " + isAccessible);
                QZoneStyleRadioGroup.this.mIsZPlanDynamicAccessible = isPassWithoutSetting;
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final QZoneStyleRadioGroup qZoneStyleRadioGroup = QZoneStyleRadioGroup.this;
                uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.leba.view.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        QZoneStyleRadioGroup.c.c(QZoneStyleRadioGroup.this, isAccessible);
                    }
                });
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19484);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public /* synthetic */ QZoneStyleRadioGroup(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Context context, QZoneStyleRadioGroup this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!NetworkUtil.isNetSupport(context)) {
            this$0.k(z16, R.string.cjm);
        } else {
            if (this$0.mIsUserClickForSwitch) {
                ((IZPlanApi) QRoute.api(IZPlanApi.class)).updateZPlanSettingQZoneSwitch(z16, new b(z16, this$0));
            }
            this$0.mIsZPlanQZoneEnabled = this$0.mZPlanSwitchItem.isChecked();
            this$0.o();
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    private final void j() {
        String str;
        if (this.mIsZPlanQZoneEnabled) {
            str = "on";
        } else {
            str = DebugKt.DEBUG_PROPERTY_VALUE_OFF;
        }
        com.tencent.mobileqq.leba.report.d.w(this, com.tencent.mobileqq.leba.controller.a.f240329a.b(), str);
    }

    private final void k(boolean isChecked, @StringRes int id5) {
        QLog.e("QZoneStyleRadioGroup", 1, "updateZPlanSettingQZoneSwitch failed, net is not supported");
        QQToast.makeText(getContext(), 1, id5, 0).show();
        this.mZPlanSwitchItem.setChecked(!isChecked);
    }

    private final void l() {
        this.mZPlanSettingBackgroundItem.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.leba.view.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneStyleRadioGroup.m(QZoneStyleRadioGroup.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(QZoneStyleRadioGroup this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent();
        intent.putExtra("from_type", "from_qzone_setting");
        Context context = this$0.mContext;
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        Activity activity = (Activity) context;
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).startZPlanBackgroundEdit(activity, intent);
        if (AppSetting.t(activity)) {
            m.b(activity);
        } else {
            activity.finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void n(int type) {
        boolean z16 = true;
        QLog.i("QZoneStyleRadioGroup", 1, "notifyViewChange type = " + type);
        com.tencent.mobileqq.leba.controller.a.f240329a.f(type);
        if (type != 2) {
            z16 = false;
        }
        s(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        LinearLayout linearLayout;
        RadioGroup radioGroup;
        this.mContainer.removeAllViews();
        int i3 = 0;
        if (!AppSetting.t(getContext())) {
            this.mTitle.setVisibility(0);
            this.mContainer.setVisibility(0);
            if (this.mIsZPlanQZoneEnabled) {
                View inflate = View.inflate(this.mContext, R.layout.gxq, this.mContainer);
                Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.LinearLayout");
                linearLayout = (LinearLayout) inflate;
            } else {
                View inflate2 = View.inflate(this.mContext, R.layout.gxo, this.mContainer);
                Intrinsics.checkNotNull(inflate2, "null cannot be cast to non-null type android.widget.LinearLayout");
                linearLayout = (LinearLayout) inflate2;
            }
            if (this.mIsZPlanQZoneEnabled) {
                radioGroup = (RadioGroup) linearLayout.findViewById(R.id.f70043kd);
            } else {
                radioGroup = (RadioGroup) linearLayout.findViewById(R.id.f70053ke);
            }
            View findViewById = linearLayout.findViewById(R.id.v4h);
            Intrinsics.checkNotNullExpressionValue(findViewById, "container.findViewById(R.id.feeds_mode_btn)");
            ((RadioButton) findViewById).setText(((IQZonePageApi) QRoute.api(IQZonePageApi.class)).getLebaEntranceText());
            Intrinsics.checkNotNullExpressionValue(radioGroup, "radioGroup");
            t(radioGroup);
            p(radioGroup);
        } else {
            this.mTitle.setVisibility(8);
            this.mContainer.setVisibility(8);
        }
        if (this.mIsZPlanDynamicAccessible && !this.mSettingMeDisableLebaExpGroup && this.mEnableZPlanNativeAppFilament) {
            this.mZPlanSwitchItem.setVisibility(0);
        } else {
            this.mZPlanSwitchItem.setVisibility(8);
        }
        QFormSimpleItem qFormSimpleItem = this.mZPlanSettingBackgroundItem;
        if (!this.mIsZPlanQZoneEnabled || !this.mEnableZPlanNativeAppFilament) {
            i3 = 8;
        }
        qFormSimpleItem.setVisibility(i3);
    }

    private final void p(final RadioGroup radioGroup) {
        QRouteApi api = QRoute.api(ILebaUIStyleSettingApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(ILebaUIStyleSettingApi::class.java)");
        final ILebaUIStyleSettingApi iLebaUIStyleSettingApi = (ILebaUIStyleSettingApi) api;
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.leba.view.h
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup2, int i3) {
                QZoneStyleRadioGroup.q(QZoneStyleRadioGroup.this, radioGroup, iLebaUIStyleSettingApi, radioGroup2, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(QZoneStyleRadioGroup this$0, RadioGroup radioGroup, ILebaUIStyleSettingApi api, RadioGroup radioGroup2, int i3) {
        EventCollector.getInstance().onRadioGroupCheckedBefore(radioGroup2, i3);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(radioGroup, "$radioGroup");
        Intrinsics.checkNotNullParameter(api, "$api");
        if (this$0.mIsUserClickForRadioGroup) {
            if (!NetworkUtil.isNetSupport(this$0.getContext())) {
                this$0.u(radioGroup, R.string.cjm);
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this$0.mLastClickTime < 1000) {
                    if (currentTimeMillis - this$0.mLastToastTime > 2000) {
                        QQToast.makeText(this$0.getContext(), 1, R.string.f162001z9, 0).show();
                        this$0.mLastToastTime = currentTimeMillis;
                    }
                    this$0.t(radioGroup);
                } else {
                    this$0.mLastClickTime = currentTimeMillis;
                    if (i3 == R.id.yjn) {
                        api.setLebaStyleUserSetting(1);
                        this$0.n(1);
                    } else if (i3 == R.id.v4h) {
                        api.setLebaStyleUserSetting(2);
                        if (!QZoneApiProxy.needShowQzoneFrame(this$0.getContext(), MobileQQ.sMobileQQ.peekAppRuntime())) {
                            QLog.d("QZoneStyleRadioGroup", 1, "canSwitchToQzone false");
                            api.setLebaStyleUserSetting(1);
                            this$0.u(radioGroup, R.string.f162231zv);
                        } else {
                            this$0.n(2);
                        }
                    }
                }
            }
        }
        EventCollector.getInstance().onRadioGroupChecked(radioGroup2, i3);
    }

    private final void r() {
        c cVar = new c();
        QRouteApi api = QRoute.api(IZPlanApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanApi::class.java)");
        ((IZPlanApi) api).setOnZplanAccessibleWithoutSettingListener(Constant.FROM_ID_UNINSTALL_PLUGIN, cVar);
    }

    private final void s(boolean showQzoneFrame) {
        ViewParent viewParent;
        ViewParent parent = getParent();
        View view = null;
        if (parent != null) {
            viewParent = parent.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent instanceof View) {
            view = (View) viewParent;
        }
        if (view != null) {
            com.tencent.mobileqq.leba.report.d.x(view, showQzoneFrame);
        }
    }

    private final void t(RadioGroup radioGroup) {
        boolean b16 = com.tencent.mobileqq.leba.controller.a.f240329a.b();
        QLog.i("QZoneStyleRadioGroup", 2, "updateRadioGroup needShowQZoneFrame : " + b16);
        if (b16) {
            radioGroup.check(R.id.v4h);
        } else {
            radioGroup.check(R.id.yjn);
        }
        s(b16);
    }

    private final void u(RadioGroup radioGroup, @StringRes int id5) {
        QLog.e("QZoneStyleRadioGroup", 1, "updateRadioGroupWhenSwitchError");
        QQToast.makeText(getContext(), 1, id5, 1).show();
        this.mIsUserClickForRadioGroup = false;
        t(radioGroup);
        this.mIsUserClickForRadioGroup = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(boolean isChecked) {
        this.mIsUserClickForSwitch = false;
        this.mZPlanSwitchItem.setChecked(isChecked);
        this.mIsUserClickForSwitch = true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneStyleRadioGroup(@NotNull final Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mContext = context;
        this.mIsUserClickForSwitch = true;
        this.mIsUserClickForRadioGroup = true;
        this.mEnableZPlanNativeAppFilament = ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).enableZPlanNativeAppFilament(0);
        setOrientation(1);
        long longAccountUin = MobileQQ.sMobileQQ.peekAppRuntime().getLongAccountUin();
        this.mIsZPlanQZoneEnabled = ((IZPlanApi) QRoute.api(IZPlanApi.class)).isQzoneEntranceEnabled(longAccountUin);
        this.mIsZPlanDynamicAccessible = ((IZPlanAccessibleHelper) QRoute.api(IZPlanAccessibleHelper.class)).isZplanAccessibleWithoutSetting(Constant.FROM_ID_UNINSTALL_PLUGIN, longAccountUin);
        boolean f16 = QQSettingMeABTestHelper.e().f();
        this.mSettingMeDisableLebaExpGroup = f16;
        QLog.i("QZoneStyleRadioGroup", 2, "mIsZPlanQZoneEnabled: " + this.mIsZPlanQZoneEnabled + " ,mIsZPlanDynamicAccessible: " + this.mIsZPlanDynamicAccessible + ", mSettingMeDisableLebaExpGroup: " + f16);
        View inflate = View.inflate(context, R.layout.gxm, this);
        View findViewById = inflate.findViewById(R.id.ygh);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.LinearLayout");
        this.mContainer = (LinearLayout) findViewById;
        View findViewById2 = inflate.findViewById(R.id.ygi);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "layout.findViewById(R.id\u2026a_mode_radio_group_title)");
        this.mTitle = findViewById2;
        View findViewById3 = inflate.findViewById(R.id.f126827pt);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "layout.findViewById(R.id.zplan_setting_background)");
        this.mZPlanSettingBackgroundItem = (QFormSimpleItem) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.f126837pu);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "layout.findViewById(R.id\u2026lan_setting_qzone_switch)");
        FormSwitchItem formSwitchItem = (FormSwitchItem) findViewById4;
        this.mZPlanSwitchItem = formSwitchItem;
        formSwitchItem.setChecked(this.mIsZPlanQZoneEnabled);
        this.mZPlanSwitchItem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.leba.view.g
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                QZoneStyleRadioGroup.d(context, this, compoundButton, z16);
            }
        });
        o();
        r();
        l();
        j();
    }
}

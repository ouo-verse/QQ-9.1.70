package com.tencent.mobileqq.activity.qqsettingme;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.viewmodel.QQSettingMeViewModel;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.IZootopiaApi;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\f\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u000bH\u0014J\u001a\u0010\u000f\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0012\u0010\u0010\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u000bH\u0016R\u0016\u0010\u0013\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0015R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/activity/qqsettingme/QQSettingMeZPlanProcessor;", "Lcom/tencent/mobileqq/activity/qqsettingme/q;", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "appInfo", "", "v", "w", "Lcom/tencent/mobileqq/qqsettingme/a;", "qqSettingMe", "", "d", "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "report", "j", NodeProps.ON_CLICK, "i", "Z", "isV9", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/MutableLiveData;", "drawerZPlanAppInfo", "k", "Ljava/lang/String;", "drawerItemJumpUrl", "<init>", "()V", "l", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class QQSettingMeZPlanProcessor extends q {
    static IPatchRedirector $redirector_;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isV9;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<BusinessInfoCheckUpdate.AppInfo> drawerZPlanAppInfo;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String drawerItemJumpUrl;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/activity/qqsettingme/QQSettingMeZPlanProcessor$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.qqsettingme.QQSettingMeZPlanProcessor$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52433);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQSettingMeZPlanProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.drawerZPlanAppInfo = new MutableLiveData<>();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final String v(BusinessInfoCheckUpdate.AppInfo appInfo) {
        boolean z16;
        boolean z17;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        PBStringField pBStringField;
        boolean z18 = false;
        if (appInfo != null && (pBStringField = appInfo.buffer) != null && pBStringField.has()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(appInfo.buffer.get());
            QLog.i("QQSettingMeZPlanProcessor", 1, "prepareRedJumpUrl buffer: " + jSONObject);
            String showMission = jSONObject.optString("_show_mission", "");
            Intrinsics.checkNotNullExpressionValue(showMission, "showMission");
            if (showMission.length() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17 || (optJSONObject = jSONObject.optJSONObject("msg")) == null || (optJSONObject2 = optJSONObject.optJSONObject(showMission)) == null) {
                return null;
            }
            String link = optJSONObject2.optString(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK, "");
            Intrinsics.checkNotNullExpressionValue(link, "link");
            if (link.length() == 0) {
                z18 = true;
            }
            if (z18) {
                return null;
            }
            return link;
        } catch (Throwable th5) {
            QLog.e("QQSettingMeZPlanProcessor", 1, "prepareRedJumpUrl failed.", th5);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(AppRuntime appRuntime, BusinessInfoCheckUpdate.AppInfo appInfo, QQSettingMeZPlanProcessor this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        am.a(appRuntime, appInfo, this$0.f259744e);
        this$0.drawerZPlanAppInfo.setValue(appInfo);
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.q, com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void d(@Nullable final com.tencent.mobileqq.qqsettingme.a qqSettingMe) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) qqSettingMe);
            return;
        }
        super.d(qqSettingMe);
        if (qqSettingMe != null) {
            z16 = qqSettingMe.n();
        } else {
            z16 = false;
        }
        this.isV9 = z16;
        QLog.i("QQSettingMeZPlanProcessor", 2, "initViewBinder isV9? " + z16);
        MutableLiveData<BusinessInfoCheckUpdate.AppInfo> mutableLiveData = this.drawerZPlanAppInfo;
        LifecycleOwner lifecycleOwner = this.f259743d;
        final Function1<BusinessInfoCheckUpdate.AppInfo, Unit> function1 = new Function1<BusinessInfoCheckUpdate.AppInfo, Unit>() { // from class: com.tencent.mobileqq.activity.qqsettingme.QQSettingMeZPlanProcessor$initViewBinder$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) com.tencent.mobileqq.qqsettingme.a.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BusinessInfoCheckUpdate.AppInfo appInfo) {
                invoke2(appInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(BusinessInfoCheckUpdate.AppInfo appInfo) {
                QQSettingMeViewModel k3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) appInfo);
                    return;
                }
                com.tencent.mobileqq.qqsettingme.a aVar = com.tencent.mobileqq.qqsettingme.a.this;
                if (aVar != null) {
                    aVar.y("d_zplan", appInfo);
                }
                com.tencent.mobileqq.qqsettingme.a aVar2 = com.tencent.mobileqq.qqsettingme.a.this;
                MutableLiveData<com.tencent.mobileqq.activity.qqsettingme.bean.k> mutableLiveData2 = (aVar2 == null || (k3 = aVar2.k()) == null) ? null : k3.P;
                if (mutableLiveData2 == null) {
                    return;
                }
                mutableLiveData2.setValue(new com.tencent.mobileqq.activity.qqsettingme.bean.k("d_zplan", appInfo));
            }
        };
        mutableLiveData.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.activity.qqsettingme.bg
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeZPlanProcessor.u(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.q, com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void j(@Nullable final BusinessInfoCheckUpdate.AppInfo appInfo, boolean report) {
        Integer num;
        PBInt32Field pBInt32Field;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, appInfo, Boolean.valueOf(report));
            return;
        }
        QLog.i("QQSettingMeZPlanProcessor", 1, "updateRedTouchData, report: " + report);
        super.i(report);
        final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String str = null;
        if (appInfo != null && (pBInt32Field = appInfo.iNewFlag) != null) {
            num = Integer.valueOf(pBInt32Field.get());
        } else {
            num = null;
        }
        if (num == null) {
            this.drawerItemJumpUrl = null;
            return;
        }
        QLog.i("QQSettingMeZPlanProcessor", 1, "updateRedTouchData, iNewFlag: " + num);
        if (num.intValue() != 0) {
            str = v(appInfo);
        }
        this.drawerItemJumpUrl = str;
        if (this.f259745f) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.qqsettingme.bf
                @Override // java.lang.Runnable
                public final void run() {
                    QQSettingMeZPlanProcessor.x(AppRuntime.this, appInfo, this);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.q, com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onClick(@Nullable View v3) {
        Context context;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) v3);
            return;
        }
        QBaseActivity qBaseActivity = this.f259741b.get();
        if (qBaseActivity == null) {
            return;
        }
        q(v3);
        if (v3 != null) {
            context = v3.getContext();
        } else {
            context = null;
        }
        String str = this.drawerItemJumpUrl;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && context != null) {
            ((IZPlanApi) QRoute.api(IZPlanApi.class)).launchScheme(context, str);
        } else {
            ((IZootopiaApi) QRoute.api(IZootopiaApi.class)).startPortalActivity(qBaseActivity, ZootopiaSource.Companion.d(ZootopiaSource.INSTANCE, Source.DRAWER, ZootopiaSource.SUB_SOURCE_DRAWER_SUPER_QQ_SHOW_TAB, null, 4, null), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.qqsettingme.q
    public void q(@Nullable View v3) {
        AppRuntime peekAppRuntime;
        IRedTouchManager iRedTouchManager;
        BusinessInfoCheckUpdate.AppInfo appInfoByPath;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) v3);
            return;
        }
        super.q(v3);
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null && (peekAppRuntime = mobileQQ.peekAppRuntime()) != null && (iRedTouchManager = (IRedTouchManager) peekAppRuntime.getRuntimeService(IRedTouchManager.class, "")) != null && (appInfoByPath = iRedTouchManager.getAppInfoByPath("140117")) != null) {
            PBInt32Field pBInt32Field = appInfoByPath.iNewFlag;
            boolean z16 = false;
            if (pBInt32Field != null && pBInt32Field.get() == 0) {
                z16 = true;
            }
            if (!z16) {
                iRedTouchManager.reportLevelOneRedInfo(BusinessInfoCheckUpdateItem.UIAPPID_DRAWER_ZPLAN, 31);
            }
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    @NotNull
    public String w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "d_zplan";
    }
}

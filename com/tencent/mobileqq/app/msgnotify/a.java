package com.tencent.mobileqq.app.msgnotify;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.notification.api.ISystemNotificationApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.mobileqq.utils.bk;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.lifecycle.IProcessStateChangeCallback;
import com.tencent.richframework.lifecycle.RFWLifecycleHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001-\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u000b\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\tJ\u0006\u0010\r\u001a\u00020\tJ\u0006\u0010\u000e\u001a\u00020\tJ\u0006\u0010\u000f\u001a\u00020\tJ\u0006\u0010\u0010\u001a\u00020\tJ\u0006\u0010\u0011\u001a\u00020\tJ\u0006\u0010\u0012\u001a\u00020\u0002J\u0006\u0010\u0013\u001a\u00020\tJ\u0006\u0010\u0014\u001a\u00020\u0002J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015R\"\u0010\u001e\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0018\u0010 \u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001fR\u0016\u0010#\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\"R\u0017\u0010(\u001a\u00020$8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010%\u001a\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0019R\u0016\u0010*\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0019R\u0016\u0010,\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010\"R\u0014\u0010/\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010.R\u0013\u00102\u001a\u0004\u0018\u0001008F\u00a2\u0006\u0006\u001a\u0004\b+\u00101\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/app/msgnotify/a;", "", "", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "Landroid/content/Context;", "context", "o", "", "g", "f", DomainData.DOMAIN_NAME, "k", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "d", "e", "t", "c", ReportConstant.COSTREPORT_PREFIX, "", "key", "i", "b", "Z", "getDialogCanShow", "()Z", "p", "(Z)V", "dialogCanShow", "Ljava/lang/String;", "currentUinAIO", "", "I", "aioShowMaxCount", "Lcom/tencent/mobileqq/qmmkv/v2/MMKVOptionEntityV2;", "Lcom/tencent/mobileqq/qmmkv/v2/MMKVOptionEntityV2;", "getEntityV2", "()Lcom/tencent/mobileqq/qmmkv/v2/MMKVOptionEntityV2;", "entityV2", "isShowAIOGray", "needListener", h.F, "dialogShowMaxCount", "com/tencent/mobileqq/app/msgnotify/a$a", "Lcom/tencent/mobileqq/app/msgnotify/a$a;", "processChangeListener", "Lcom/tencent/mobileqq/tianshu/config/c;", "()Lcom/tencent/mobileqq/tianshu/config/c;", "dialogConfig", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f196345a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean dialogCanShow;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static String currentUinAIO;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static int aioShowMaxCount;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final MMKVOptionEntityV2 entityV2;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static boolean isShowAIOGray;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static boolean needListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static int dialogShowMaxCount;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final C7386a processChangeListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/app/msgnotify/a$a", "Lcom/tencent/richframework/lifecycle/IProcessStateChangeCallback;", "", "onProcessForeground", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.app.msgnotify.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static final class C7386a implements IProcessStateChangeCallback {
        static IPatchRedirector $redirector_;

        C7386a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.richframework.lifecycle.IProcessStateChangeCallback
        public /* synthetic */ void onProcessBackground() {
            com.tencent.richframework.lifecycle.a.a(this);
        }

        @Override // com.tencent.richframework.lifecycle.IProcessStateChangeCallback
        public void onProcessForeground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (a.needListener) {
                a.needListener = false;
                QLog.d("MsgNotifyHelper", 1, "onProcessForeground");
                a aVar = a.f196345a;
                if (aVar.l()) {
                    aVar.r();
                }
            }
        }
    }

    static {
        int i3;
        com.tencent.mobileqq.tianshu.config.b a16;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54312);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 22)) {
            redirector.redirect((short) 22);
            return;
        }
        a aVar = new a();
        f196345a = aVar;
        dialogCanShow = true;
        currentUinAIO = "";
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        entityV2 = fromV2;
        com.tencent.mobileqq.tianshu.config.c h16 = aVar.h();
        if (h16 != null && (a16 = h16.a()) != null) {
            i3 = a16.d();
        } else {
            i3 = 3;
        }
        dialogShowMaxCount = i3;
        processChangeListener = new C7386a();
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void j() {
        boolean equals$default;
        String accountId = RFWApplication.getAccountId();
        equals$default = StringsKt__StringsJVMKt.equals$default(currentUinAIO, accountId, false, 2, null);
        if (!equals$default) {
            ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity("exp_push_notification_aio");
            Intrinsics.checkNotNullExpressionValue(expEntity, "getInstance().getExpEntity(AIO_GRAY_AB_TAB_KEY)");
            if (TextUtils.isEmpty(expEntity.getAssignment())) {
                QLog.e("MsgNotifyHelper", 1, "initAIOMsgGaryMaxCount fail, entityInfo is null");
                return;
            }
            currentUinAIO = accountId;
            isShowAIOGray = false;
            expEntity.reportExpExposure();
            String str = expEntity.getTabParams().get("maxShowCount");
            QLog.d("MsgNotifyHelper", 1, "initAIOMsgGaryMaxCount entityInfo:" + expEntity.getExpName() + ", data:" + str);
            if (TextUtils.isEmpty(str)) {
                aioShowMaxCount = 0;
                return;
            }
            try {
                Intrinsics.checkNotNull(str);
                aioShowMaxCount = Integer.parseInt(str);
            } catch (Exception unused) {
                QLog.e("MsgNotifyHelper", 1, "initAIOMsgGaryMaxCount fail, data:" + str);
            }
        }
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        j();
        if (isShowAIOGray) {
            QLog.d("MsgNotifyHelper", 1, "canShowAIOGray isShowAIOGray");
            return false;
        }
        MMKVOptionEntityV2 mMKVOptionEntityV2 = entityV2;
        if (!z61.b.e(System.currentTimeMillis(), mMKVOptionEntityV2.decodeLong(i("aio_gray_show_last_time"), 0L))) {
            QLog.d("MsgNotifyHelper", 1, "canShowAIOGray is not same day");
            return true;
        }
        int decodeInt = mMKVOptionEntityV2.decodeInt(i("aio_gray_show_count"), 0);
        QLog.d("MsgNotifyHelper", 1, "canShowAIOGray count:" + decodeInt);
        if (decodeInt >= aioShowMaxCount) {
            return false;
        }
        return true;
    }

    public final boolean d() {
        boolean z16;
        com.tencent.mobileqq.tianshu.config.b a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        MMKVOptionEntityV2 mMKVOptionEntityV2 = entityV2;
        if (System.currentTimeMillis() - mMKVOptionEntityV2.decodeLong(i(AppConstants.Preferences.PUSH_OPEN_NOTIFY_LASTTIME), 0L) < 86400000) {
            QLog.d("MsgNotifyHelper", 1, "canShowDialog today has show");
            return false;
        }
        int decodeInt = mMKVOptionEntityV2.decodeInt(i(AppConstants.Preferences.PUSH_MSG_NOTIFY_COUNT), 0);
        QLog.d("MsgNotifyHelper", 1, "updateDialogParam count:" + decodeInt);
        if (decodeInt < dialogShowMaxCount) {
            com.tencent.mobileqq.tianshu.config.c h16 = h();
            if (h16 != null && (a16 = h16.a()) != null && a16.c() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return true;
            }
        }
        return false;
    }

    public final boolean e() {
        boolean decodeBool;
        boolean z16;
        boolean z17;
        com.tencent.mobileqq.tianshu.config.b a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        if (g()) {
            if (entityV2.decodeInt(i(AppConstants.Preferences.PUSH_MSG_NOTIFY_COUNT), 0) >= dialogShowMaxCount) {
                decodeBool = true;
            } else {
                decodeBool = false;
            }
        } else {
            decodeBool = entityV2.decodeBool(i(AppConstants.Preferences.PUSH_MSG_NOTIFY_IS_MAX), false);
        }
        if (!decodeBool) {
            com.tencent.mobileqq.tianshu.config.c h16 = h();
            if (h16 != null && (a16 = h16.a()) != null && a16.c() == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                z16 = false;
                if (z16 && dialogCanShow) {
                    return false;
                }
            }
        }
        z16 = true;
        return z16 ? true : true;
    }

    public final boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        j();
        if (aioShowMaxCount != 0) {
            return true;
        }
        return false;
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return true;
    }

    @Nullable
    public final com.tencent.mobileqq.tianshu.config.c h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.mobileqq.tianshu.config.c) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return (com.tencent.mobileqq.tianshu.config.c) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("push_notify_dialog_tab");
    }

    @Nullable
    public final String i(@Nullable String key) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this, (Object) key);
        }
        return QMMKVFile.getKeyWithUin("MsgNotifyHelper", key);
    }

    public final boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        ISystemNotificationApi iSystemNotificationApi = (ISystemNotificationApi) QRoute.api(ISystemNotificationApi.class);
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return iSystemNotificationApi.getCachedNotificationSwitch(context);
    }

    public final boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        if (QQAppInterface.isNotificationEnabled() == 1) {
            return true;
        }
        return false;
    }

    public final boolean m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return SettingCloneUtil.readValue((Context) BaseApplication.context, RFWApplication.getAccountId(), (String) null, AppConstants.NEW_MSG_NOTIFICATION_KEY, true);
    }

    public final boolean n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        if (k() && m()) {
            return true;
        }
        return false;
    }

    public final void o(@Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) context);
            return;
        }
        QLog.d("MsgNotifyHelper", 1, "jumpToMsgSettingFragment");
        if (!k()) {
            q();
            Intent a16 = bk.a(MobileQQ.sMobileQQ);
            BaseActivity baseActivity = BaseActivity.sTopActivity;
            if (baseActivity != null) {
                baseActivity.startActivity(a16);
                return;
            } else if (context != null) {
                context.startActivity(a16);
                return;
            } else {
                RFWApplication.getApplication().startActivity(a16);
                return;
            }
        }
        if (!m()) {
            r();
            QQToast.makeText(context, 0, "\u5df2\u5f00\u542f\u6d88\u606f\u901a\u77e5", 1).show();
        }
    }

    public final void p(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            dialogCanShow = z16;
        }
    }

    public final void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            needListener = true;
            RFWLifecycleHelper.getInstance().registerProcessChangeListener(processChangeListener);
        }
    }

    public final void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            if (m()) {
                QLog.d("MsgNotifyHelper", 1, "internalSwitch is open");
                return;
            }
            QLog.d("MsgNotifyHelper", 1, "internalSwitch set true");
            SettingCloneUtil.writeValue((Context) BaseApplication.context, RFWApplication.getAccountId(), (String) null, AppConstants.NEW_MSG_NOTIFICATION_KEY, true);
            com.tencent.mobileqq.pushnotice.c.f(true);
        }
    }

    public final void s() {
        int decodeInt;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        isShowAIOGray = true;
        MMKVOptionEntityV2 mMKVOptionEntityV2 = entityV2;
        if (!z61.b.e(System.currentTimeMillis(), mMKVOptionEntityV2.decodeLong(i("aio_gray_show_last_time"), 0L))) {
            mMKVOptionEntityV2.encodeInt(i("aio_gray_show_count"), 1);
            decodeInt = 1;
        } else {
            decodeInt = mMKVOptionEntityV2.decodeInt(i("aio_gray_show_count"), 0) + 1;
            mMKVOptionEntityV2.encodeInt(i("aio_gray_show_count"), decodeInt);
        }
        mMKVOptionEntityV2.encodeLong(i("aio_gray_show_last_time"), System.currentTimeMillis());
        QLog.d("MsgNotifyHelper", 1, "updateAIOGrayParam lastShowTime:" + System.currentTimeMillis() + ", count:" + decodeInt);
    }

    public final void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        MMKVOptionEntityV2 mMKVOptionEntityV2 = entityV2;
        int decodeInt = mMKVOptionEntityV2.decodeInt(i(AppConstants.Preferences.PUSH_MSG_NOTIFY_COUNT), 0) + 1;
        mMKVOptionEntityV2.encodeInt(i(AppConstants.Preferences.PUSH_MSG_NOTIFY_COUNT), decodeInt);
        mMKVOptionEntityV2.encodeLong(i(AppConstants.Preferences.PUSH_OPEN_NOTIFY_LASTTIME), currentTimeMillis);
        if (e.a() && decodeInt >= MsgNotifyPushDialog.f196334f0) {
            mMKVOptionEntityV2.encodeBool(i(AppConstants.Preferences.PUSH_MSG_NOTIFY_IS_MAX), true);
            if (QLog.isColorLevel()) {
                QLog.d(MsgNotifyPushDialog.F, 1, "updateDialogParam: newDialogShowCount >= newPushOpenNotifyFreq_Max");
            }
        }
        QLog.d("MsgNotifyHelper", 1, "updateDialogParam lastShowTime:" + currentTimeMillis + ", count:" + decodeInt);
    }
}

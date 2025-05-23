package com.tencent.mobileqq.settings.message;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msg.api.IFeatureSwitch;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupMigrateFragment;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupPCAuthFragment;
import com.tencent.mobileqq.profilecommon.processor.ChatHistoryProfileCommonProcessor;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.setting.fragment.BaseSettingFragment;
import com.tencent.mobileqq.settings.message.ChatNewSettingFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vip.api.IVipTraceDetailReport;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.ICanImportCallback;
import com.tencent.qqnt.msg.migration.NTMsgMigrationManager;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bs\u0010tJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J\b\u0010\u0012\u001a\u00020\u0002H\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0004H\u0002J\u001a\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\f\u0010\u001b\u001a\u00020\t*\u0004\u0018\u00010\u001aJ\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cJ\b\u0010\u001e\u001a\u00020\u0002H\u0016J\b\u0010\u001f\u001a\u00020\u0002H\u0016J\u0013\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 \u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010&\u001a\u00020\u00022\b\u0010%\u001a\u0004\u0018\u00010$J\u0006\u0010'\u001a\u00020\u0002J\n\u0010)\u001a\u0006\u0012\u0002\b\u00030(J\n\u0010*\u001a\u0006\u0012\u0002\b\u00030(J\n\u0010+\u001a\u0006\u0012\u0002\b\u00030(J\n\u0010,\u001a\u0006\u0012\u0002\b\u00030(J\n\u0010-\u001a\u0006\u0012\u0002\b\u00030(J\n\u0010.\u001a\u0006\u0012\u0002\b\u00030(J\n\u0010/\u001a\u0006\u0012\u0002\b\u00030(J\u000e\u00101\u001a\u00020\u00022\u0006\u00100\u001a\u00020\tJ\u000e\u00103\u001a\u00020$2\u0006\u00102\u001a\u00020\tR\u001a\u00108\u001a\u00020\t8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001a\u0010;\u001a\u00020\t8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b9\u00105\u001a\u0004\b:\u00107R\u001a\u0010>\u001a\u00020\t8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b<\u00105\u001a\u0004\b=\u00107R\u001a\u0010C\u001a\u00020$8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u001a\u0010F\u001a\u00020$8\u0006X\u0086D\u00a2\u0006\f\n\u0004\bD\u0010@\u001a\u0004\bE\u0010BR$\u0010L\u001a\u0010\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020I\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR$\u0010O\u001a\u0010\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020M\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010KR$\u0010Q\u001a\u0010\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020M\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010KR\u0018\u0010U\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010X\u001a\u00020V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u00104R$\u0010`\u001a\u0004\u0018\u00010Y8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\"\u0010h\u001a\u00020a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bb\u0010c\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u0018\u0010j\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010[R\"\u0010r\u001a\u00020k8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bl\u0010m\u001a\u0004\bn\u0010o\"\u0004\bp\u0010q\u00a8\u0006u"}, d2 = {"Lcom/tencent/mobileqq/settings/message/ChatNewSettingFragment;", "Lcom/tencent/mobileqq/setting/fragment/BaseSettingFragment;", "", "xi", "", "isSyncSwitchOpen", "Ii", "hidden", "gi", "", "hi", "Di", "Gi", "Lcom/tencent/qqnt/msg/migration/NTMsgMigrationManager;", "migrationManager", "pi", "zi", "Mi", "Ji", "show", "Hi", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Landroid/app/Activity;", "ei", "Lcom/tencent/mobileqq/app/QQAppInterface;", "Vh", "onResume", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "Yh", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "", "message", "Ci", "fi", "Lcom/tencent/mobileqq/widget/listitem/a;", "li", "ni", "Wh", "Ki", "bi", "Zh", WidgetCacheLunarData.JI, "index", "si", "resId", WidgetCacheLunarData.YI, "J", "I", "getMSG_NEW_IMPORT_DONE", "()I", "MSG_NEW_IMPORT_DONE", "K", "getMSG_NEW_NEVER_IMPORT", "MSG_NEW_NEVER_IMPORT", "L", "getMSG_NEW_IMPORT_IN_PROGRESS", "MSG_NEW_IMPORT_IN_PROGRESS", "M", "Ljava/lang/String;", "getLOG_TAG", "()Ljava/lang/String;", "LOG_TAG", "N", "getSYNC_SWITCH_FEATURE_KEY", "SYNC_SWITCH_FEATURE_KEY", "Lcom/tencent/mobileqq/activity/newsetting/custom/config/b;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "P", "Lcom/tencent/mobileqq/activity/newsetting/custom/config/b;", "chatListMigrateConfig", "Lcom/tencent/mobileqq/widget/listitem/x$c$f;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "migrateSettingConfig", BdhLogUtil.LogTag.Tag_Req, "syncLastMsgTolocalConfig", "Lcom/tencent/qqnt/msg/migration/a;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/qqnt/msg/migration/a;", "migrationListener", "", "T", "lastClickTime", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "U", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "di", "()Lcom/tencent/mobileqq/widget/QQProgressDialog;", "setPublishDialog", "(Lcom/tencent/mobileqq/widget/QQProgressDialog;)V", "publishDialog", "Lcom/tencent/mobileqq/troop/roamsetting/b;", "V", "Lcom/tencent/mobileqq/troop/roamsetting/b;", "getRoamSettingObserver", "()Lcom/tencent/mobileqq/troop/roamsetting/b;", "setRoamSettingObserver", "(Lcom/tencent/mobileqq/troop/roamsetting/b;)V", "roamSettingObserver", "W", "mDlgProgress", "Landroid/os/Handler;", "X", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "setHandler", "(Landroid/os/Handler;)V", "handler", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ChatNewSettingFragment extends BaseSettingFragment {

    /* renamed from: J, reason: from kotlin metadata */
    private final int MSG_NEW_IMPORT_DONE;

    /* renamed from: P, reason: from kotlin metadata */
    private com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c.g> chatListMigrateConfig;

    /* renamed from: Q, reason: from kotlin metadata */
    private com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c.f> migrateSettingConfig;

    /* renamed from: R, reason: from kotlin metadata */
    private com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c.f> syncLastMsgTolocalConfig;

    /* renamed from: S, reason: from kotlin metadata */
    private com.tencent.qqnt.msg.migration.a migrationListener;

    /* renamed from: T, reason: from kotlin metadata */
    private long lastClickTime;

    /* renamed from: U, reason: from kotlin metadata */
    private QQProgressDialog publishDialog;

    /* renamed from: W, reason: from kotlin metadata */
    private QQProgressDialog mDlgProgress;

    /* renamed from: K, reason: from kotlin metadata */
    private final int MSG_NEW_NEVER_IMPORT = 1;

    /* renamed from: L, reason: from kotlin metadata */
    private final int MSG_NEW_IMPORT_IN_PROGRESS = 2;

    /* renamed from: M, reason: from kotlin metadata */
    private final String LOG_TAG = "ChatNewSettingFragment";

    /* renamed from: N, reason: from kotlin metadata */
    private final String SYNC_SWITCH_FEATURE_KEY = "QQ_c2c_chat_record_hidden_switch";

    /* renamed from: V, reason: from kotlin metadata */
    private com.tencent.mobileqq.troop.roamsetting.b roamSettingObserver = new b();

    /* renamed from: X, reason: from kotlin metadata */
    private Handler handler = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/settings/message/ChatNewSettingFragment$a", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "", "handleMessage", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            super.handleMessage(msg2);
            FragmentActivity activity = ChatNewSettingFragment.this.getActivity();
            if (!(activity instanceof FragmentActivity)) {
                activity = null;
            }
            int i3 = msg2.what;
            if (i3 != 0) {
                if (i3 == 1 && ChatNewSettingFragment.this.getPublishDialog() != null) {
                    QQProgressDialog publishDialog = ChatNewSettingFragment.this.getPublishDialog();
                    if (publishDialog != null && publishDialog.isShowing()) {
                        QQProgressDialog publishDialog2 = ChatNewSettingFragment.this.getPublishDialog();
                        if (publishDialog2 != null) {
                            publishDialog2.cancel();
                        }
                        QQProgressDialog publishDialog3 = ChatNewSettingFragment.this.getPublishDialog();
                        if (publishDialog3 != null) {
                            publishDialog3.setMessage(ChatNewSettingFragment.this.yi(R.string.a3f));
                        }
                        QQProgressDialog publishDialog4 = ChatNewSettingFragment.this.getPublishDialog();
                        if (publishDialog4 != null) {
                            publishDialog4.setBackAndSearchFilter(true);
                        }
                        QQProgressDialog publishDialog5 = ChatNewSettingFragment.this.getPublishDialog();
                        if (publishDialog5 != null) {
                            publishDialog5.showTipImageView(false);
                        }
                        QQProgressDialog publishDialog6 = ChatNewSettingFragment.this.getPublishDialog();
                        if (publishDialog6 != null) {
                            publishDialog6.showProgerss(true);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            if (activity != null && !activity.isFinishing()) {
                QQProgressDialog publishDialog7 = ChatNewSettingFragment.this.getPublishDialog();
                if (publishDialog7 != null) {
                    publishDialog7.setMessage(ChatNewSettingFragment.this.getString(R.string.a3d));
                }
                QQProgressDialog publishDialog8 = ChatNewSettingFragment.this.getPublishDialog();
                if (publishDialog8 != null) {
                    publishDialog8.setTipImageView(R.drawable.setting_icons_correct);
                }
                QQProgressDialog publishDialog9 = ChatNewSettingFragment.this.getPublishDialog();
                if (publishDialog9 != null) {
                    publishDialog9.showProgerss(false);
                }
            }
            sendEmptyMessageDelayed(1, 1000L);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006H\u0014\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/settings/message/ChatNewSettingFragment$b", "Lcom/tencent/mobileqq/troop/roamsetting/b;", "", "issuc", "", "path", "", "", "data", "", "b", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends com.tencent.mobileqq.troop.roamsetting.b {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(ChatNewSettingFragment this$0, CompoundButton compoundButton, boolean z16) {
            MobileQQ application;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            QQAppInterface Vh = this$0.Vh();
            if (!NetworkUtil.isNetSupport((Vh == null || (application = Vh.getApplication()) == null) ? null : application.getApplicationContext())) {
                FragmentActivity activity = this$0.getActivity();
                QQToast.makeText(activity != null ? activity.getApplicationContext() : null, R.string.f171139ci4, 1).show();
                return;
            }
            ao.a(this$0.Vh(), "0X800B877", z16);
            this$0.Ci(this$0.getString(R.string.hfh));
            QQAppInterface Vh2 = this$0.Vh();
            if (Vh2 != null) {
                Vh2.setC2CRoamingSetting(z16 ? 1 : 0);
            }
        }

        @Override // com.tencent.mobileqq.troop.roamsetting.b
        protected void b(boolean issuc, String path, Map<String, Integer> data) {
            boolean startsWith$default;
            Intrinsics.checkNotNullParameter(path, "path");
            Intrinsics.checkNotNullParameter(data, "data");
            if (TextUtils.isEmpty(path)) {
                return;
            }
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(path, AppConstants.RoamingMapPath.C2C_ROAMING_MSG, false, 2, null);
            if (startsWith$default) {
                if (QLog.isColorLevel()) {
                    QLog.d("SecuritySettingActivity", 2, "onSetGeneralSettingsC2CRoaming issuc =" + issuc);
                }
                ChatNewSettingFragment.this.fi();
                FragmentActivity activity = ChatNewSettingFragment.this.getActivity();
                if (activity == null) {
                    QLog.e(ChatNewSettingFragment.this.getTAG(), 1, "onSetGeneralSettingsC2CRoaming: activity is null");
                    return;
                }
                if (!issuc) {
                    if (ChatNewSettingFragment.this.syncLastMsgTolocalConfig != null) {
                        com.tencent.mobileqq.activity.newsetting.custom.config.b bVar = ChatNewSettingFragment.this.syncLastMsgTolocalConfig;
                        if (bVar != null) {
                            bVar.e0(null);
                        }
                        com.tencent.mobileqq.activity.newsetting.custom.config.b bVar2 = ChatNewSettingFragment.this.syncLastMsgTolocalConfig;
                        if (bVar2 != null) {
                            QQAppInterface Vh = ChatNewSettingFragment.this.Vh();
                            bVar2.a0(Vh != null && Vh.getC2CRoamingSetting() == 1);
                        }
                        com.tencent.mobileqq.activity.newsetting.custom.config.b bVar3 = ChatNewSettingFragment.this.syncLastMsgTolocalConfig;
                        if (bVar3 != null) {
                            final ChatNewSettingFragment chatNewSettingFragment = ChatNewSettingFragment.this;
                            bVar3.e0(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.settings.message.w
                                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                                public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                                    ChatNewSettingFragment.b.f(ChatNewSettingFragment.this, compoundButton, z16);
                                }
                            });
                        }
                    }
                    QQToast.makeText(activity.getApplicationContext(), R.string.d0f, 0).show(ChatNewSettingFragment.this.ei(activity));
                    return;
                }
                QQToast.makeText(activity.getApplicationContext(), 2, R.string.d0h, 0).show(ChatNewSettingFragment.this.ei(activity));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0002H\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/settings/message/ChatNewSettingFragment$c", "Lcom/tencent/qqnt/msg/migration/a;", "", "showSpeedUpTip", "", "a", "", "progress", "b", "onSuccess", "isLowMem", "needShowTipBar", "d", "c", "enable", "e", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements com.tencent.qqnt.msg.migration.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g>> f286957a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ChatNewSettingFragment f286958b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ NTMsgMigrationManager f286959c;

        c(Ref.ObjectRef<com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g>> objectRef, ChatNewSettingFragment chatNewSettingFragment, NTMsgMigrationManager nTMsgMigrationManager) {
            this.f286957a = objectRef;
            this.f286958b = chatNewSettingFragment;
            this.f286959c = nTMsgMigrationManager;
        }

        @Override // com.tencent.qqnt.msg.migration.a
        public void a(boolean showSpeedUpTip) {
            float b06 = NTMsgMigrationManager.INSTANCE.a().b0();
            if (b06 == 0.0f) {
                x.c.g O = this.f286957a.element.O();
                String string = this.f286958b.getString(R.string.f171862ow);
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.nt_msg_migrating_short)");
                O.h(string);
                return;
            }
            this.f286957a.element.O().h(this.f286958b.getString(R.string.f171862ow) + this.f286959c.d0(b06));
        }

        @Override // com.tencent.qqnt.msg.migration.a
        public void b(float progress, boolean showSpeedUpTip) {
            this.f286957a.element.O().h(this.f286958b.getString(R.string.f171862ow) + this.f286959c.d0(progress));
        }

        @Override // com.tencent.qqnt.msg.migration.a
        public void c() {
            this.f286957a.element.O().h("");
        }

        @Override // com.tencent.qqnt.msg.migration.a
        public void d(boolean isLowMem, boolean needShowTipBar) {
            this.f286957a.element.O().h("");
        }

        @Override // com.tencent.qqnt.msg.migration.a
        public void e(boolean enable) {
            com.tencent.mobileqq.activity.newsetting.custom.config.b bVar;
            com.tencent.mobileqq.activity.newsetting.custom.config.b bVar2 = this.f286958b.migrateSettingConfig;
            boolean z16 = false;
            if (bVar2 != null && bVar2.Y()) {
                z16 = true;
            }
            if (!z16 || (bVar = this.f286958b.migrateSettingConfig) == null) {
                return;
            }
            bVar.a0(enable);
        }

        @Override // com.tencent.qqnt.msg.migration.a
        public void onSuccess() {
            this.f286957a.element.O().h("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ai(ChatNewSettingFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.pi(NTMsgMigrationManager.INSTANCE.a());
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bi(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    private final void Di() {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getContext(), 231, (String) null, getString(R.string.f16526282), getString(R.string.zd_), getString(R.string.zd9), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.settings.message.t
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ChatNewSettingFragment.Ei(ChatNewSettingFragment.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.settings.message.u
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ChatNewSettingFragment.Fi(dialogInterface, i3);
            }
        });
        Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(\n    \u2026ch -> dialog.dismiss() })");
        createCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ei(ChatNewSettingFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.pi(NTMsgMigrationManager.INSTANCE.a());
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fi(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    private final void Gi() {
        QLog.d(this.LOG_TAG, 1, "showMsgImportProgressTip");
        QQToast.makeText(getContext(), getString(R.string.f168352fe), 0).show();
    }

    private final void Hi(boolean show) {
        QQProgressDialog qQProgressDialog;
        QQProgressDialog qQProgressDialog2 = this.publishDialog;
        if (qQProgressDialog2 != null) {
            if (show) {
                if ((qQProgressDialog2 == null || qQProgressDialog2.isShowing()) ? false : true) {
                    QQProgressDialog qQProgressDialog3 = this.publishDialog;
                    if (qQProgressDialog3 != null) {
                        qQProgressDialog3.show();
                        return;
                    }
                    return;
                }
            }
            if (show) {
                return;
            }
            QQProgressDialog qQProgressDialog4 = this.publishDialog;
            if (!(qQProgressDialog4 != null && qQProgressDialog4.isShowing()) || (qQProgressDialog = this.publishDialog) == null) {
                return;
            }
            qQProgressDialog.dismiss();
        }
    }

    private final void Ii(boolean isSyncSwitchOpen) {
        QLog.d(getTAG(), 2, "showSyncMsgGetViewIfNeed isSyncSwitchOpen:" + isSyncSwitchOpen);
        if (isSyncSwitchOpen) {
            boolean isFeatureSwitchEnable = ((IFeatureSwitch) QRoute.api(IFeatureSwitch.class)).isFeatureSwitchEnable(this.SYNC_SWITCH_FEATURE_KEY, false);
            QLog.d(getTAG(), 2, "showSyncMsgGetViewIfNeed featureEnable:" + isFeatureSwitchEnable);
            gi(isFeatureSwitchEnable);
            return;
        }
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        QQAppInterface Vh = Vh();
        String currentAccountUin = Vh != null ? Vh.getCurrentAccountUin() : null;
        if (currentAccountUin == null) {
            currentAccountUin = "";
        }
        String str = ChatHistoryProfileCommonProcessor.f260937a;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        sb5.append("_");
        sb5.append(currentAccountUin);
        boolean z16 = from.decodeInt(sb5.toString(), 0) == 1;
        QLog.d(getTAG(), 2, "showSyncMsgGetViewIfNeed isFlagEnable:" + z16);
        gi(z16);
    }

    private final void Ji() {
        SharedPreferences sharedPreferences;
        MobileQQ application;
        if (getActivity() == null) {
            QLog.e(getTAG(), 1, "syncMessageRoamFlag: activity is null");
            return;
        }
        QQAppInterface Vh = Vh();
        String str = null;
        if (Vh == null || (application = Vh.getApplication()) == null || (sharedPreferences = application.getSharedPreferences("vip_message_roam_banner_file", 0)) == null) {
            sharedPreferences = null;
        }
        if (sharedPreferences == null) {
            QLog.e(getTAG(), 1, "syncMessageRoamFlag: pref is null");
            return;
        }
        QQAppInterface Vh2 = Vh();
        int i3 = sharedPreferences.getInt("message_roam_flag" + (Vh2 != null ? Vh2.getCurrentAccountUin() : null), 0);
        if (i3 == 1) {
            str = getResources().getString(R.string.f172963g45);
        } else if (i3 == 2) {
            str = getResources().getString(R.string.g3s);
        } else if (i3 == 3) {
            str = getResources().getString(R.string.g3q);
        } else if (i3 == 4) {
            str = getResources().getString(R.string.g3p);
        } else if (i3 == 5) {
            str = getResources().getString(R.string.g3r);
        }
        if (!TextUtils.isEmpty(str)) {
            com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c.g> bVar = this.chatListMigrateConfig;
            if (bVar != null) {
                bVar.f0(str);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(getTAG(), 2, "messge roam flag is error ,is : " + i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Li(NTMsgMigrationManager migrationManager, ChatNewSettingFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(migrationManager, "$migrationManager");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!migrationManager.w0()) {
            QQToast.makeText(this$0.getContext(), 1, R.string.f172042pd, 0).show();
        } else {
            if (migrationManager.v0()) {
                return;
            }
            this$0.pi(migrationManager);
        }
    }

    private final void Mi() {
        FragmentActivity activity = getActivity();
        Intent intent = activity != null ? activity.getIntent() : null;
        if (intent == null) {
            intent = new Intent();
        }
        if ((intent.hasExtra("set_display_type") ? intent.getIntExtra("set_display_type", 0) : 0) == 2) {
            com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c.f> bVar = this.syncLastMsgTolocalConfig;
            if (bVar != null) {
                bVar.h0(8);
            }
            com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c.g> bVar2 = this.chatListMigrateConfig;
            if (bVar2 != null) {
                bVar2.h0(8);
                return;
            }
            return;
        }
        com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c.f> bVar3 = this.syncLastMsgTolocalConfig;
        if (bVar3 != null) {
            bVar3.h0(0);
        }
        com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c.g> bVar4 = this.chatListMigrateConfig;
        if (bVar4 != null) {
            bVar4.h0(0);
        }
        ReportController.y(Vh(), "0X800B814");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xh(ChatNewSettingFragment this$0, View view) {
        boolean contains$default;
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String pageUrl = IndividuationUrlHelper.getUrl(IndividuationUrlHelper.UrlId.VIP_CHAT_ROAM_CELL);
        if (TextUtils.isEmpty(pageUrl)) {
            QLog.e(this$0.LOG_TAG, 1, "gotoRoamMessageSettingUrl ! url empty");
            return;
        }
        Intrinsics.checkNotNullExpressionValue(pageUrl, "pageUrl");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) pageUrl, (CharSequence) QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, false, 2, (Object) null);
        if (contains$default) {
            str = "&ADTAG=msgRoam";
        } else {
            str = "?ADTAG=msgRoam";
        }
        String pageUrl2 = ((Object) pageUrl) + str;
        IVipTraceDetailReport iVipTraceDetailReport = (IVipTraceDetailReport) QRoute.api(IVipTraceDetailReport.class);
        Intrinsics.checkNotNullExpressionValue(pageUrl2, "pageUrl");
        String pageUrl3 = iVipTraceDetailReport.buildTraceDetailUrl(pageUrl2, IVipTraceDetailReport.FROM.SETTING_CHAT_HISTORY_ROAM);
        if (QLog.isColorLevel()) {
            QLog.i(this$0.LOG_TAG, 2, "message_roam_setting pageUrl:" + ((Object) pageUrl3));
        }
        if (((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).isEnable()) {
            FragmentActivity activity = this$0.getActivity();
            if (activity != null) {
                IVasHybridRoute iVasHybridRoute = (IVasHybridRoute) QRoute.api(IVasHybridRoute.class);
                Intrinsics.checkNotNullExpressionValue(pageUrl3, "pageUrl");
                iVasHybridRoute.openBrowser(activity, pageUrl3);
            }
        } else {
            Intent intent = new Intent(this$0.getActivity(), (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", pageUrl3);
            this$0.startActivity(intent);
        }
        ReportController.y(this$0.Vh(), "0X800B878");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ai(ChatNewSettingFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.si(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ci(ChatNewSettingFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.si(1);
    }

    private final void gi(boolean hidden) {
        QLog.d(getTAG(), 2, "hideSyncMsgGetView hidden:" + hidden);
        com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c.f> bVar = this.syncLastMsgTolocalConfig;
        if (bVar != null) {
            bVar.h0(hidden ? 8 : 0);
        }
    }

    private final int hi() {
        com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
        final Ref.IntRef intRef = new Ref.IntRef();
        if (e16 == null) {
            QLog.e(getTAG(), 1, "kernelMsgService is null");
            return intRef.element;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        long currentTimeMillis = System.currentTimeMillis();
        QLog.d(getTAG(), 1, "CountDownLatch start: ", Long.valueOf(System.currentTimeMillis()));
        e16.canProcessDataMigration(new ICanImportCallback() { // from class: com.tencent.mobileqq.settings.message.v
            @Override // com.tencent.qqnt.kernel.nativeinterface.ICanImportCallback
            public final void onResult(int i3, String str, int i16) {
                ChatNewSettingFragment.ii(ChatNewSettingFragment.this, intRef, countDownLatch, i3, str, i16);
            }
        });
        try {
            countDownLatch.await(5L, TimeUnit.SECONDS);
        } catch (InterruptedException e17) {
            QLog.e(getTAG(), 1, "InterruptedException: ", e17);
        }
        QLog.d(getTAG(), 1, "CountDownLatch time: ", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        QLog.d(getTAG(), 1, "isMsgImportDone resultCode: ", Integer.valueOf(intRef.element));
        return intRef.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ii(ChatNewSettingFragment this$0, Ref.IntRef resultCode, CountDownLatch countDownLatch, int i3, String str, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(resultCode, "$resultCode");
        Intrinsics.checkNotNullParameter(countDownLatch, "$countDownLatch");
        QLog.d(this$0.getTAG(), 1, "canProcessDataMigration result = ", Integer.valueOf(i3), "errMsg = ", str);
        resultCode.element = i3;
        countDownLatch.countDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ki(String currentUin, CompoundButton compoundButton, boolean z16) {
        Intrinsics.checkNotNullParameter(currentUin, "$currentUin");
        NTMsgMigrationManager.INSTANCE.a().e1(currentUin, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mi(ChatNewSettingFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ReportController.y(this$0.Vh(), "0X800B875");
        int hi5 = this$0.hi();
        if (hi5 == this$0.MSG_NEW_IMPORT_DONE) {
            QPublicFragmentActivity.startForResult(this$0.getActivity(), (Class<? extends QPublicBaseFragment>) MsgBackupMigrateFragment.class, 1000);
            return;
        }
        if (hi5 == this$0.MSG_NEW_NEVER_IMPORT) {
            this$0.Di();
        } else if (hi5 == this$0.MSG_NEW_IMPORT_IN_PROGRESS) {
            this$0.Gi();
        } else {
            QLog.e(this$0.LOG_TAG, 1, "Get MsgImport status error");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oi(ChatNewSettingFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ReportController.y(this$0.Vh(), "0X800B876");
        int hi5 = this$0.hi();
        if (hi5 == 0) {
            com.tencent.mobileqq.msgbackup.authentication.a.d().h(1);
            QPublicFragmentActivity.startForResult(this$0.getActivity(), (Class<? extends QPublicBaseFragment>) MsgBackupPCAuthFragment.class, 1000);
        } else if (hi5 == 1) {
            this$0.zi();
        } else if (hi5 != 2) {
            QLog.d(this$0.LOG_TAG, 1, "Get MsgImport status error");
        } else {
            this$0.Gi();
        }
    }

    private final void pi(final NTMsgMigrationManager migrationManager) {
        com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 == null) {
            return;
        }
        QQAppInterface Vh = Vh();
        final String currentAccountUin = Vh != null ? Vh.getCurrentAccountUin() : null;
        if (currentAccountUin == null) {
            currentAccountUin = "";
        }
        if (TextUtils.isEmpty(currentAccountUin)) {
            return;
        }
        QLog.d("NTMsgMigration.Manager", 1, "onClickImport");
        e16.canImportOldDbMsg(new ICanImportCallback() { // from class: com.tencent.mobileqq.settings.message.f
            @Override // com.tencent.qqnt.kernel.nativeinterface.ICanImportCallback
            public final void onResult(int i3, String str, int i16) {
                ChatNewSettingFragment.qi(ChatNewSettingFragment.this, migrationManager, currentAccountUin, i3, str, i16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qi(final ChatNewSettingFragment this$0, final NTMsgMigrationManager migrationManager, final String uin, final int i3, String errMsg, final int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(migrationManager, "$migrationManager");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        QLog.d(this$0.getTAG(), 1, "initNtMsgMigration canImportOldDbMsg " + i3 + " " + errMsg + " level=" + i16);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.settings.message.k
            @Override // java.lang.Runnable
            public final void run() {
                ChatNewSettingFragment.ri(ChatNewSettingFragment.this, i3, migrationManager, i16, uin);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ti(final ChatNewSettingFragment this$0, ActionSheet choiceDialog, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(choiceDialog, "$choiceDialog");
        ReportController.y(this$0.Vh(), "0X800B879");
        if (this$0.getActivity() != null) {
            FragmentActivity activity = this$0.getActivity();
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            if (!activity.isFinishing()) {
                choiceDialog.cancel();
                this$0.Hi(true);
            }
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.settings.message.l
            @Override // java.lang.Runnable
            public final void run() {
                ChatNewSettingFragment.ui(ChatNewSettingFragment.this);
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ui(ChatNewSettingFragment this$0) {
        MessageHandler msgHandler;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQAppInterface Vh = this$0.Vh();
        if (Vh != null && (msgHandler = Vh.getMsgHandler()) != null) {
            msgHandler.c5(true);
        }
        Lifecycle lifecycle = this$0.getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
        ChatHistorySettingNTHelper.e(lifecycle, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.settings.message.ChatNewSettingFragment$onClickView$1$r$1$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }
        });
        ((ISubAccountControllUtil) QRoute.api(ISubAccountControllUtil.class)).clearSubAccountAssistantTime();
        this$0.handler.sendEmptyMessageDelayed(0, 1000L);
        QQAppInterface Vh2 = this$0.Vh();
        MqqHandler handler = Vh2 != null ? Vh2.getHandler(Conversation.class) : null;
        if (handler != null) {
            handler.sendEmptyMessage(1009);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vi(final ChatNewSettingFragment this$0, ActionSheet choiceDialog, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(choiceDialog, "$choiceDialog");
        ReportController.y(this$0.Vh(), "0X800B87A");
        if (this$0.getActivity() != null) {
            FragmentActivity activity = this$0.getActivity();
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            if (!activity.isFinishing()) {
                choiceDialog.cancel();
                this$0.Hi(true);
            }
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.settings.message.m
            @Override // java.lang.Runnable
            public final void run() {
                ChatNewSettingFragment.wi(ChatNewSettingFragment.this);
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wi(ChatNewSettingFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Lifecycle lifecycle = this$0.getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
        ChatHistorySettingNTHelper.f(lifecycle);
        ((ISubAccountControllUtil) QRoute.api(ISubAccountControllUtil.class)).clearSubAccountAssistantTime();
        this$0.handler.sendEmptyMessageDelayed(0, 1000L);
    }

    private final void xi() {
        ReportController.y(Vh(), "0X800B813");
        ReportController.y(Vh(), "0X800B815");
        ReportController.y(Vh(), "0X800B816");
    }

    private final void zi() {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getContext(), 231, (String) null, getString(R.string.zd8), getString(R.string.zd_), getString(R.string.zd9), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.settings.message.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ChatNewSettingFragment.Ai(ChatNewSettingFragment.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.settings.message.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ChatNewSettingFragment.Bi(dialogInterface, i3);
            }
        });
        Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(\n    \u2026ch -> dialog.dismiss() })");
        createCustomDialog.show();
    }

    public final void Ci(String message) {
        if (this.mDlgProgress == null && getActivity() != null && getActivity() != null) {
            FragmentActivity activity = getActivity();
            FragmentActivity activity2 = getActivity();
            Intrinsics.checkNotNull(activity2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            this.mDlgProgress = new QQProgressDialog(activity, ei(activity2));
        }
        QQProgressDialog qQProgressDialog = this.mDlgProgress;
        if (qQProgressDialog != null) {
            qQProgressDialog.setCancelable(true);
        }
        QQProgressDialog qQProgressDialog2 = this.mDlgProgress;
        if (qQProgressDialog2 != null) {
            qQProgressDialog2.setMessage(message);
        }
        QQProgressDialog qQProgressDialog3 = this.mDlgProgress;
        if (qQProgressDialog3 != null) {
            qQProgressDialog3.show();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, com.tencent.mobileqq.widget.listitem.x] */
    public final com.tencent.mobileqq.widget.listitem.a<?> Ki() {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        String string = getString(R.string.f172022pb);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.nt_msg_migration_setting_item)");
        objectRef.element = new com.tencent.mobileqq.widget.listitem.x(new x.b.d(string), new x.c.g("", true, false));
        final NTMsgMigrationManager a16 = NTMsgMigrationManager.INSTANCE.a();
        if (a16.v0()) {
            ((x.c.g) ((com.tencent.mobileqq.widget.listitem.x) objectRef.element).O()).h(getString(R.string.f171862ow) + a16.c0());
        }
        ((com.tencent.mobileqq.widget.listitem.x) objectRef.element).x(new View.OnClickListener() { // from class: com.tencent.mobileqq.settings.message.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChatNewSettingFragment.Li(NTMsgMigrationManager.this, this, view);
            }
        });
        c cVar = new c(objectRef, this, a16);
        this.migrationListener = cVar;
        Intrinsics.checkNotNull(cVar, "null cannot be cast to non-null type com.tencent.qqnt.msg.migration.IMigrationListener");
        a16.K(cVar);
        return (com.tencent.mobileqq.widget.listitem.a) objectRef.element;
    }

    public final QQAppInterface Vh() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        Intrinsics.checkNotNullExpressionValue(waitAppRuntime, "sMobileQQ.waitAppRuntime()");
        if (waitAppRuntime instanceof QQAppInterface) {
            return (QQAppInterface) waitAppRuntime;
        }
        QLog.d("SoundNewFragment", 2, "-get app is null- ");
        return null;
    }

    public final com.tencent.mobileqq.widget.listitem.a<?> Wh() {
        String string = getString(R.string.c8l);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.message_roam_settings)");
        com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c.g> bVar = new com.tencent.mobileqq.activity.newsetting.custom.config.b<>(new x.b.d(string), new x.c.g("\u4e0d\u6f2b\u6e38", true, false), th());
        this.chatListMigrateConfig = bVar;
        bVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.settings.message.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChatNewSettingFragment.Xh(ChatNewSettingFragment.this, view);
            }
        });
        return bVar;
    }

    public final com.tencent.mobileqq.widget.listitem.a<?> Zh() {
        String string = getString(R.string.ajf);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.del_all_chat_history)");
        com.tencent.mobileqq.widget.listitem.x xVar = new com.tencent.mobileqq.widget.listitem.x(new x.b.d(string), new x.c.g("", false, false));
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.settings.message.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChatNewSettingFragment.ai(ChatNewSettingFragment.this, view);
            }
        });
        return xVar;
    }

    public final com.tencent.mobileqq.widget.listitem.a<?> bi() {
        String string = getString(R.string.ajt);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.del_recent_list)");
        com.tencent.mobileqq.widget.listitem.x xVar = new com.tencent.mobileqq.widget.listitem.x(new x.b.d(string), new x.c.g("", false, false));
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.settings.message.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChatNewSettingFragment.ci(ChatNewSettingFragment.this, view);
            }
        });
        return xVar;
    }

    /* renamed from: di, reason: from getter */
    public final QQProgressDialog getPublishDialog() {
        return this.publishDialog;
    }

    public final void fi() {
        try {
            QQProgressDialog qQProgressDialog = this.mDlgProgress;
            if (qQProgressDialog != null) {
                if (qQProgressDialog != null) {
                    qQProgressDialog.dismiss();
                }
                QQProgressDialog qQProgressDialog2 = this.mDlgProgress;
                if (qQProgressDialog2 != null) {
                    qQProgressDialog2.cancel();
                }
                this.mDlgProgress = null;
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public final com.tencent.mobileqq.widget.listitem.a<?> ji() {
        String string = getString(R.string.f172032pc);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.nt_ms\u2026ting_item_back_migration)");
        com.tencent.mobileqq.activity.newsetting.custom.config.b<x.b.d, x.c.f> bVar = new com.tencent.mobileqq.activity.newsetting.custom.config.b<>(new x.b.d(string), new x.c.f(false, null, true), th());
        bVar.h0(8);
        this.migrateSettingConfig = bVar;
        QQAppInterface Vh = Vh();
        final String currentAccountUin = Vh != null ? Vh.getCurrentAccountUin() : null;
        if (currentAccountUin == null) {
            currentAccountUin = "";
        }
        NTMsgMigrationManager.Companion companion = NTMsgMigrationManager.INSTANCE;
        if (companion.a().D0()) {
            bVar.h0(0);
            bVar.a0(companion.a().U(currentAccountUin));
            bVar.e0(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.settings.message.n
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                    ChatNewSettingFragment.ki(currentAccountUin, compoundButton, z16);
                }
            });
        }
        return bVar;
    }

    public final com.tencent.mobileqq.widget.listitem.a<?> li() {
        ReportController.y(Vh(), "0X800B811");
        String string = getString(R.string.ije);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.backup_and_migrate_item_1)");
        com.tencent.mobileqq.widget.listitem.x xVar = new com.tencent.mobileqq.widget.listitem.x(new x.b.d(string), new x.c.g("", true, false));
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.settings.message.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChatNewSettingFragment.mi(ChatNewSettingFragment.this, view);
            }
        });
        return xVar;
    }

    public final com.tencent.mobileqq.widget.listitem.a<?> ni() {
        String string = getString(R.string.ijf);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.backup_and_migrate_item_2)");
        com.tencent.mobileqq.widget.listitem.x xVar = new com.tencent.mobileqq.widget.listitem.x(new x.b.d(string), new x.c.g("", true, false));
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.settings.message.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChatNewSettingFragment.oi(ChatNewSettingFragment.this, view);
            }
        });
        ReportController.y(Vh(), "0X800B812");
        return xVar;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        QQAppInterface Vh;
        QQProgressDialog qQProgressDialog = this.publishDialog;
        if (qQProgressDialog != null) {
            Intrinsics.checkNotNull(qQProgressDialog);
            if (qQProgressDialog.isShowing()) {
                Hi(false);
            }
        }
        if (Vh() != null && (Vh = Vh()) != null) {
            Vh.removeObserver(this.roamSettingObserver);
        }
        this.handler.removeCallbacksAndMessages(null);
        super.onDestroy();
        QQSettingMsgHistoryActivity.H2();
        com.tencent.mobileqq.qrscan.utils.b.c(getActivity());
        if (this.migrationListener != null) {
            NTMsgMigrationManager a16 = NTMsgMigrationManager.INSTANCE.a();
            com.tencent.qqnt.msg.migration.a aVar = this.migrationListener;
            Intrinsics.checkNotNull(aVar);
            a16.X0(aVar);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Ji();
    }

    @Override // com.tencent.mobileqq.setting.fragment.BaseSettingFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        String string = getString(R.string.zk7);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.chat_history_manage_text)");
        setTitle(string);
        QUIListItemAdapter th5 = th();
        if (th5 != null) {
            Group[] Yh = Yh();
            th5.t0((Group[]) Arrays.copyOf(Yh, Yh.length));
        }
        Mi();
        QQAppInterface Vh = Vh();
        if (Vh != null) {
            Vh.addObserver(this.roamSettingObserver);
        }
        QQAppInterface Vh2 = Vh();
        Ii(Vh2 != null && Vh2.getC2CRoamingSetting() == 1);
        if (this.publishDialog == null && getActivity() != null && getActivity() != null) {
            FragmentActivity activity = getActivity();
            FragmentActivity activity2 = getActivity();
            Intrinsics.checkNotNull(activity2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            QQProgressDialog qQProgressDialog = new QQProgressDialog(activity, ei(activity2));
            this.publishDialog = qQProgressDialog;
            qQProgressDialog.setMessage(getString(R.string.a3f));
            QQProgressDialog qQProgressDialog2 = this.publishDialog;
            if (qQProgressDialog2 != null) {
                qQProgressDialog2.setCanceledOnTouchOutside(true);
            }
            QQProgressDialog qQProgressDialog3 = this.publishDialog;
            if (qQProgressDialog3 != null) {
                qQProgressDialog3.setBackAndSearchFilter(true);
            }
            QQProgressDialog qQProgressDialog4 = this.publishDialog;
            if (qQProgressDialog4 != null) {
                qQProgressDialog4.showTipImageView(false);
            }
            QQProgressDialog qQProgressDialog5 = this.publishDialog;
            if (qQProgressDialog5 != null) {
                qQProgressDialog5.showProgerss(true);
            }
        }
        xi();
    }

    public final void si(int index) {
        int i3;
        int i16;
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = currentTimeMillis - this.lastClickTime;
        if (getActivity() == null || getActivity() == null) {
            return;
        }
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        if (activity.isFinishing() || j3 < 500) {
            return;
        }
        this.lastClickTime = currentTimeMillis;
        ActionSheet.OnButtonClickListener onButtonClickListener = null;
        Dialog createDialog = ActionSheetHelper.createDialog(getActivity(), null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        if (index == 1) {
            onButtonClickListener = new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.settings.message.i
                @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
                public final void onClick(View view, int i17) {
                    ChatNewSettingFragment.ti(ChatNewSettingFragment.this, actionSheet, view, i17);
                }
            };
            i3 = R.string.ajt;
            i16 = R.string.a3e;
        } else if (index != 2) {
            i3 = 0;
            i16 = 0;
        } else {
            onButtonClickListener = new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.settings.message.j
                @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
                public final void onClick(View view, int i17) {
                    ChatNewSettingFragment.vi(ChatNewSettingFragment.this, actionSheet, view, i17);
                }
            };
            i3 = R.string.zqo;
            i16 = R.string.zqp;
        }
        actionSheet.addButton(i3, 3);
        actionSheet.addCancelButton(getString(R.string.cancel));
        actionSheet.setOnButtonClickListener(onButtonClickListener);
        actionSheet.setMainTitle(i16);
        actionSheet.show();
    }

    public final String yi(int resId) {
        String string = BaseApplication.context.getString(resId);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(resId)");
        return string;
    }

    public final Group[] Yh() {
        List mutableListOf;
        List filterNotNull;
        List mutableListOf2;
        List filterNotNull2;
        List mutableListOf3;
        List filterNotNull3;
        List mutableListOf4;
        List filterNotNull4;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(li(), ni());
        filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(mutableListOf);
        Object[] array = filterNotNull.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = (com.tencent.mobileqq.widget.listitem.a[]) array;
        mutableListOf2 = CollectionsKt__CollectionsKt.mutableListOf(Wh());
        filterNotNull2 = CollectionsKt___CollectionsKt.filterNotNull(mutableListOf2);
        Object[] array2 = filterNotNull2.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
        Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr2 = (com.tencent.mobileqq.widget.listitem.a[]) array2;
        mutableListOf3 = CollectionsKt__CollectionsKt.mutableListOf(Ki(), ji());
        filterNotNull3 = CollectionsKt___CollectionsKt.filterNotNull(mutableListOf3);
        Object[] array3 = filterNotNull3.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
        Intrinsics.checkNotNull(array3, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr3 = (com.tencent.mobileqq.widget.listitem.a[]) array3;
        mutableListOf4 = CollectionsKt__CollectionsKt.mutableListOf(bi(), Zh());
        filterNotNull4 = CollectionsKt___CollectionsKt.filterNotNull(mutableListOf4);
        Object[] array4 = filterNotNull4.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
        Intrinsics.checkNotNull(array4, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr4 = (com.tencent.mobileqq.widget.listitem.a[]) array4;
        return new Group[]{new Group((com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr, aVarArr.length)), new Group((com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr2, aVarArr2.length)), new Group((com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr3, aVarArr3.length)), new Group((com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr4, aVarArr4.length))};
    }

    public final int ei(Activity activity) {
        if (activity == null) {
            return 0;
        }
        QBaseActivity qBaseActivity = activity instanceof QBaseActivity ? (QBaseActivity) activity : null;
        if (qBaseActivity != null) {
            return qBaseActivity.getTitleBarHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ri(ChatNewSettingFragment this$0, int i3, NTMsgMigrationManager migrationManager, int i16, String uin) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(migrationManager, "$migrationManager");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        if (this$0.getActivity() == null || this$0.getActivity() == null) {
            return;
        }
        FragmentActivity activity = this$0.getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        if (activity.isFinishing()) {
            return;
        }
        if (i3 != 2 && i3 != 3) {
            str = "2";
        } else {
            str = "1";
        }
        ReportController.o(null, "dc00898", "", "", "0X800C4D6", "0X800C4D6", NTMsgMigrationManager.INSTANCE.a().h0(), 0, str, "", "", "");
        if (i3 != 2 && i3 != 3) {
            QQToast.makeText(this$0.getContext(), 0, R.string.f171872ox, 0).show();
            migrationManager.o1(i16);
            migrationManager.m1(uin, false);
            migrationManager.U0(uin);
            migrationManager.F1(uin);
            if (i3 == 1) {
                migrationManager.k0(uin);
                return;
            } else {
                migrationManager.G0(uin, false, false);
                return;
            }
        }
        QQToast.makeText(this$0.getContext(), 0, R.string.f171842ou, 0).show();
    }
}

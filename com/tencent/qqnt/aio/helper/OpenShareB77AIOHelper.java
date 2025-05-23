package com.tencent.qqnt.aio.helper;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.runtime.message.ExternalCommIntent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.forward.ForwardSdkBaseOption;
import com.tencent.mobileqq.forward.ForwardStatisticsReporter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.AIOLifeCycleEvent;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00bd\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007*\u00010\b\u0007\u0018\u0000 b2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001cB\u0007\u00a2\u0006\u0004\b`\u0010aJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\u001c\u0010\u000e\u001a\u00020\u00062\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0002J$\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010\u0015\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\u0016\u001a\u00020\u000fH\u0002J\u001c\u0010\u001a\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002J\b\u0010\u001b\u001a\u00020\u0006H\u0002J\b\u0010\u001c\u001a\u00020\u0006H\u0002J\b\u0010\u001d\u001a\u00020\u0006H\u0002J\b\u0010\u001e\u001a\u00020\u0006H\u0002J\b\u0010\u001f\u001a\u00020\u0004H\u0002J\b\u0010 \u001a\u00020\u000fH\u0016J\b\u0010!\u001a\u00020\u000bH\u0016J\u0010\u0010$\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"H\u0016J\b\u0010&\u001a\u00020%H\u0016J\u0010\u0010(\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u000fH\u0016J\b\u0010)\u001a\u00020\u0006H\u0016J\u000e\u0010,\u001a\u00020\u00062\u0006\u0010+\u001a\u00020*J\u0010\u0010/\u001a\u00020\u00042\u0006\u0010.\u001a\u00020-H\u0016R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010A\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010H\u001a\u00020F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010GR\u0018\u0010K\u001a\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010JR\u0018\u0010N\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010MR\u0018\u0010Q\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010PR\u0016\u0010U\u001a\u00020R8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010Y\u001a\u00020V8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010\\\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0014\u0010_\u001a\u00020]8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010^\u00a8\u0006d"}, d2 = {"Lcom/tencent/qqnt/aio/helper/OpenShareB77AIOHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "Landroid/os/Handler$Callback;", "Lcom/tencent/mvi/base/route/g;", "", "B", "", "r", "D", UserInfo.SEX_FEMALE, "", "", "", "b77Result", BdhLogUtil.LogTag.Tag_Conn, "", "errCode", "wording", "errorMsgForApp", ReportConstant.COSTREPORT_PREFIX, "jumpString", "p", "o", WadlProxyConsts.KEY_JUMP_URL, "Landroid/content/Context;", "context", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "u", HippyTKDListViewAdapter.X, "E", "v", "y", "getId", "getTag", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "", "interestedIn", "state", "onMoveToState", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mvi/base/route/MsgIntent;", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/os/Message;", "msg", "handleMessage", "com/tencent/qqnt/aio/helper/OpenShareB77AIOHelper$b", "d", "Lcom/tencent/qqnt/aio/helper/OpenShareB77AIOHelper$b;", "action", "e", "Z", "needProcess", "Lcom/tencent/aio/api/runtime/a;", "f", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "Lcom/tencent/qqnt/aio/helper/OpenShareByServerAIOHelper;", tl.h.F, "Lcom/tencent/qqnt/aio/helper/OpenShareByServerAIOHelper;", "shareByServerAIOHelper", "Landroid/app/Activity;", "Landroid/app/Activity;", "mActivity", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "J", "mShareAppId", "Lmqq/os/MqqHandler;", "Lmqq/os/MqqHandler;", "mHandler", "Landroid/app/Dialog;", "Landroid/app/Dialog;", "mWaitDialog", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "mShareResultDlg", "Landroid/content/BroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "mNotifyAIOBroadcastReceiver", "Landroid/os/Bundle;", "G", "Landroid/os/Bundle;", "mExtra", "Landroid/content/Intent;", "H", "Landroid/content/Intent;", "mIntent", "I", "Ljava/lang/String;", "mCachedKey", "Landroid/content/DialogInterface$OnClickListener;", "Landroid/content/DialogInterface$OnClickListener;", "mCancelDialogClickListener", "<init>", "()V", "K", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes34.dex */
public final class OpenShareB77AIOHelper implements com.tencent.aio.main.businesshelper.h, Handler.Callback, com.tencent.mvi.base.route.g {

    /* renamed from: D, reason: from kotlin metadata */
    private Dialog mWaitDialog;

    /* renamed from: E, reason: from kotlin metadata */
    private QQCustomDialog mShareResultDlg;

    /* renamed from: F, reason: from kotlin metadata */
    private BroadcastReceiver mNotifyAIOBroadcastReceiver;

    /* renamed from: G, reason: from kotlin metadata */
    private Bundle mExtra;

    /* renamed from: H, reason: from kotlin metadata */
    private Intent mIntent;

    /* renamed from: I, reason: from kotlin metadata */
    private String mCachedKey;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean needProcess;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private OpenShareByServerAIOHelper shareByServerAIOHelper;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Activity mActivity;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private long mShareAppId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final b action = new b();

    /* renamed from: C, reason: from kotlin metadata */
    private final MqqHandler mHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this);

    /* renamed from: J, reason: from kotlin metadata */
    private final DialogInterface.OnClickListener mCancelDialogClickListener = new DialogInterface.OnClickListener() { // from class: com.tencent.qqnt.aio.helper.cv
        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i3) {
            OpenShareB77AIOHelper.A(OpenShareB77AIOHelper.this, dialogInterface, i3);
        }
    };

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/helper/OpenShareB77AIOHelper$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            OpenShareB77AIOHelper.this.q(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(OpenShareB77AIOHelper this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 1) {
            ForwardSdkBaseOption.F(this$0.mActivity, false, "shareToQQ", this$0.mShareAppId);
            com.tencent.biz.common.util.k.k(this$0.mActivity, 0, "", "");
            com.tencent.aio.api.runtime.a aVar = this$0.mAIOContext;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                aVar = null;
            }
            aVar.e().h(new ExternalCommIntent("close_aio", new Bundle()));
            Activity activity = this$0.mActivity;
            Intrinsics.checkNotNull(activity);
            activity.moveTaskToBack(true);
        }
    }

    private final boolean B() {
        boolean z16;
        Bundle bundle = this.mExtra;
        Bundle bundle2 = null;
        if (bundle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mExtra");
            bundle = null;
        }
        if (bundle.getLong(AppConstants.Key.SHARE_RES_ID, -1L) != -1) {
            Bundle bundle3 = this.mExtra;
            if (bundle3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mExtra");
                bundle3 = null;
            }
            z16 = bundle3.containsKey(AppConstants.Key.SHARE_RES_ID);
        } else {
            z16 = false;
        }
        if (!z16) {
            Bundle bundle4 = this.mExtra;
            if (bundle4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mExtra");
                bundle4 = null;
            }
            z16 = bundle4.getBoolean(AppConstants.Key.SHARE_FLAG, false);
        }
        Bundle bundle5 = this.mExtra;
        if (bundle5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mExtra");
            bundle5 = null;
        }
        if (Intrinsics.areEqual("qzoneShareTopic", bundle5.getString(AppConstants.Key.SHARE_REQ_EXT_STR))) {
            z16 = false;
        }
        QLog.i("OpenShareB77AIOHelper", 1, "isFromShare = " + z16);
        if (!z16) {
            return false;
        }
        Bundle bundle6 = this.mExtra;
        if (bundle6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mExtra");
        } else {
            bundle2 = bundle6;
        }
        return bundle2.getInt(AppConstants.Key.SHARE_SDK_SHARE_TYPE, 0) == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(Map<String, ? extends Object> b77Result) {
        Integer num = (Integer) b77Result.get("key_b77_error_code");
        Integer num2 = (Integer) b77Result.get("key_b77_jump_result");
        String str = (String) b77Result.get("key_b77_jump_url");
        String str2 = (String) b77Result.get("key_b77_wording");
        String str3 = (String) b77Result.get("key_b77_develop_msg");
        if (num != null && num.intValue() != 0) {
            QLog.d("OpenShareB77AIOHelper", 1, "errorCode=", num);
            s(num.intValue(), str2, str3);
        } else if (num2 != null && num2.intValue() != 0) {
            QLog.d("OpenShareB77AIOHelper", 1, "jumpResult=", num2);
            p(str);
        } else {
            QLog.d("OpenShareB77AIOHelper", 1, "handleSendSuccess");
            u();
        }
    }

    private final void D() {
        Intent intent = this.mIntent;
        Intent intent2 = null;
        if (intent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIntent");
            intent = null;
        }
        String stringExtra = intent.getStringExtra("key_b77_sdk_share");
        this.mCachedKey = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            QLog.d("OpenShareB77AIOHelper", 1, "showB77ResultDialog cachedKey empty");
            return;
        }
        Intent intent3 = this.mIntent;
        if (intent3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIntent");
        } else {
            intent2 = intent3;
        }
        intent2.removeExtra("key_b77_sdk_share");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        Manager manager = ((QQAppInterface) peekAppRuntime).getManager(QQManagerFactory.SDK_SHARE);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.forward.ForwardSdkStatusManager");
        Map<String, Object> b16 = ((com.tencent.mobileqq.forward.u) manager).b(this.mCachedKey);
        QLog.d("OpenShareB77AIOHelper", 1, "showB77ResultDialog cachedKey:", this.mCachedKey);
        if (b16 == null) {
            QLog.d("OpenShareB77AIOHelper", 1, "initBroadcastReceiver");
            x();
            MqqHandler mqqHandler = this.mHandler;
            mqqHandler.sendMessageDelayed(mqqHandler.obtainMessage(1), 500L);
            return;
        }
        QLog.d("OpenShareB77AIOHelper", 1, "showB77ResultDialog_parseB77Result");
        C(b16);
    }

    private final void E() {
        QLog.i("OpenShareB77AIOHelper", 1, "showWaitDialog");
        Activity activity = this.mActivity;
        if (activity != null) {
            Intrinsics.checkNotNull(activity);
            if (!activity.isFinishing()) {
                Dialog dialog = this.mWaitDialog;
                if (dialog != null) {
                    Intrinsics.checkNotNull(dialog);
                    if (dialog.isShowing()) {
                        return;
                    }
                    Dialog dialog2 = this.mWaitDialog;
                    Intrinsics.checkNotNull(dialog2);
                    dialog2.show();
                    return;
                }
                Activity activity2 = this.mActivity;
                Intrinsics.checkNotNull(activity2);
                Dialog dialog3 = new Dialog(activity2, R.style.qZoneInputDialog);
                this.mWaitDialog = dialog3;
                dialog3.setCancelable(false);
                Dialog dialog4 = this.mWaitDialog;
                if (dialog4 != null) {
                    dialog4.setContentView(R.layout.f168383uh);
                }
                Dialog dialog5 = this.mWaitDialog;
                View findViewById = dialog5 != null ? dialog5.findViewById(R.id.photo_prievew_progress_dialog_text) : null;
                Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
                ((TextView) findViewById).setText(R.string.cuv);
                Dialog dialog6 = this.mWaitDialog;
                if (dialog6 != null) {
                    dialog6.show();
                    return;
                }
                return;
            }
        }
        QLog.d("OpenShareB77AIOHelper", 1, "showWaitDialog mActivity status invalid");
    }

    private final void F() {
        Activity activity = this.mActivity;
        Intent intent = activity != null ? activity.getIntent() : null;
        if (intent == null) {
            intent = new Intent();
        }
        this.mIntent = intent;
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        this.mExtra = extras;
        long j3 = extras.getLong("req_share_id");
        this.mShareAppId = j3;
        QLog.d("OpenShareB77AIOHelper", 1, "mShareAppId=" + j3);
    }

    private final int o() {
        Bundle bundle = this.mExtra;
        if (bundle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mExtra");
            bundle = null;
        }
        return bundle.getInt(AppConstants.Key.SHARE_REQ_TYPE, Integer.MAX_VALUE);
    }

    private final void p(String jumpString) {
        if (!TextUtils.isEmpty(jumpString)) {
            z(jumpString, this.mActivity);
        }
        ForwardStatisticsReporter.k("KEY_STAGE_2_TOTAL", false);
        Bundle bundle = this.mExtra;
        if (bundle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mExtra");
            bundle = null;
        }
        com.tencent.mobileqq.forward.x.n(bundle, o(), this.mShareAppId, false);
    }

    private final void r() {
        QLog.i("OpenShareB77AIOHelper", 1, "handleOnNewIntent.");
        this.needProcess = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(OpenShareB77AIOHelper this$0, int i3, String str, DialogInterface dialogInterface, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i16 == 1) {
            com.tencent.mobileqq.forward.x.p(this$0.mActivity, "shareToQQ", this$0.mShareAppId, i3, str);
            com.tencent.biz.common.util.k.k(this$0.mActivity, 0, "", "");
            com.tencent.aio.api.runtime.a aVar = this$0.mAIOContext;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                aVar = null;
            }
            aVar.e().h(new ExternalCommIntent("close_aio", new Bundle()));
            Activity activity = this$0.mActivity;
            if (activity != null) {
                activity.moveTaskToBack(true);
            }
        }
    }

    private final void u() {
        com.tencent.aio.api.runtime.a aVar;
        Bundle bundle = this.mExtra;
        Bundle bundle2 = null;
        if (bundle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mExtra");
            bundle = null;
        }
        String string = bundle.getString("app_name");
        Bundle bundle3 = this.mExtra;
        if (bundle3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mExtra");
            bundle3 = null;
        }
        AbsStructMsg e16 = com.tencent.mobileqq.structmsg.i.e(bundle3);
        if (e16 instanceof AbsShareMsg) {
            Activity activity = this.mActivity;
            QQCustomDialog qQCustomDialog = this.mShareResultDlg;
            com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                aVar = null;
            } else {
                aVar = aVar2;
            }
            this.mShareResultDlg = com.tencent.mobileqq.forward.x.o(activity, qQCustomDialog, aVar, ((AbsShareMsg) e16).mSourceAppid, e16.mMsgServiceID, string);
        }
        Bundle bundle4 = this.mExtra;
        if (bundle4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mExtra");
        } else {
            bundle2 = bundle4;
        }
        com.tencent.mobileqq.forward.x.n(bundle2, o(), this.mShareAppId, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(OpenShareB77AIOHelper this$0) {
        Dialog dialog;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.y() && (dialog = this$0.mWaitDialog) != null) {
            dialog.dismiss();
        }
    }

    private final void x() {
        if (this.mNotifyAIOBroadcastReceiver == null) {
            BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.tencent.qqnt.aio.helper.OpenShareB77AIOHelper$initBroadcastReceiver$1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    Activity activity;
                    Activity activity2;
                    MqqHandler mqqHandler;
                    MqqHandler mqqHandler2;
                    Intent intent2;
                    String str;
                    String str2;
                    BroadcastReceiver broadcastReceiver2;
                    Activity activity3;
                    BroadcastReceiver broadcastReceiver3;
                    Intrinsics.checkNotNullParameter(context, "context");
                    Intrinsics.checkNotNullParameter(intent, "intent");
                    activity = OpenShareB77AIOHelper.this.mActivity;
                    if (activity != null) {
                        activity2 = OpenShareB77AIOHelper.this.mActivity;
                        Intrinsics.checkNotNull(activity2);
                        if (!activity2.isFinishing()) {
                            OpenShareB77AIOHelper.this.v();
                            mqqHandler = OpenShareB77AIOHelper.this.mHandler;
                            mqqHandler.removeMessages(1);
                            mqqHandler2 = OpenShareB77AIOHelper.this.mHandler;
                            mqqHandler2.removeMessages(2);
                            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                            Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
                            Manager manager = ((QQAppInterface) peekAppRuntime).getManager(QQManagerFactory.SDK_SHARE);
                            Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.forward.ForwardSdkStatusManager");
                            com.tencent.mobileqq.forward.u uVar = (com.tencent.mobileqq.forward.u) manager;
                            intent2 = OpenShareB77AIOHelper.this.mIntent;
                            if (intent2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mIntent");
                                intent2 = null;
                            }
                            QLog.d("OpenShareB77AIOHelper", 1, "tempKey = " + intent2.getStringExtra("key_b77_sdk_share"));
                            str = OpenShareB77AIOHelper.this.mCachedKey;
                            Map<String, Object> b16 = uVar.b(str);
                            if (b16 != null) {
                                str2 = OpenShareB77AIOHelper.this.mCachedKey;
                                QLog.d("OpenShareB77AIOHelper", 1, "onReceive parseB77Result key:", str2);
                                OpenShareB77AIOHelper.this.C(b16);
                            } else {
                                QLog.d("OpenShareB77AIOHelper", 1, "onReceive b77Result == null");
                            }
                            try {
                                broadcastReceiver2 = OpenShareB77AIOHelper.this.mNotifyAIOBroadcastReceiver;
                                if (broadcastReceiver2 != null) {
                                    activity3 = OpenShareB77AIOHelper.this.mActivity;
                                    if (activity3 != null) {
                                        broadcastReceiver3 = OpenShareB77AIOHelper.this.mNotifyAIOBroadcastReceiver;
                                        activity3.unregisterReceiver(broadcastReceiver3);
                                    }
                                    OpenShareB77AIOHelper.this.mNotifyAIOBroadcastReceiver = null;
                                    return;
                                }
                                return;
                            } catch (Exception e16) {
                                QLog.e("OpenShareB77AIOHelper", 1, "unregisterReceiver error, ", e16);
                                return;
                            }
                        }
                    }
                    QLog.e("OpenShareB77AIOHelper", 1, "onReceive null == mActivity || mActivity.isFinishing()");
                }
            };
            this.mNotifyAIOBroadcastReceiver = broadcastReceiver;
            try {
                Activity activity = this.mActivity;
                if (activity != null) {
                    activity.registerReceiver(broadcastReceiver, new IntentFilter("action_notify_aio_activity_by_b77"));
                }
            } catch (Exception e16) {
                QLog.e("OpenShareB77AIOHelper", 1, "registerReceiver error, ", e16);
            }
        }
    }

    private final boolean y() {
        Dialog dialog;
        Activity activity = this.mActivity;
        if (activity != null) {
            Intrinsics.checkNotNull(activity);
            if (!activity.isFinishing() && (dialog = this.mWaitDialog) != null) {
                Intrinsics.checkNotNull(dialog);
                if (dialog.isShowing()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.N0;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.qqnt.aio.AIOLifeCycleEvent.OnNewIntent");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        return new HashSet();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "OpenShareB77AIOHelper";
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        int i3 = msg2.what;
        if (i3 == 1) {
            E();
            MqqHandler mqqHandler = this.mHandler;
            mqqHandler.sendMessageDelayed(mqqHandler.obtainMessage(2), 10000L);
        } else if (i3 == 2) {
            Activity activity = this.mActivity;
            if (activity != null) {
                Intrinsics.checkNotNull(activity);
                if (!activity.isFinishing()) {
                    ReportController.o(null, "dc00898", "", "", "0X8009CF9", "0X8009CF9", 0, 0, "", "", "", "");
                    v();
                    com.tencent.mobileqq.forward.g.c(this.mActivity, HardCodeUtil.qqStr(R.string.mpy), this.mCancelDialogClickListener);
                }
            }
            QLog.d("OpenShareB77AIOHelper", 1, "msg_sdk_share_request_timeout_status mActivity == null || mActivity.isFinishing()");
            return true;
        }
        return true;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        com.tencent.aio.api.runtime.a a16 = param.a();
        this.mAIOContext = a16;
        com.tencent.aio.api.runtime.a aVar = null;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            a16 = null;
        }
        com.tencent.mvi.base.route.j e16 = a16.e();
        if (e16 != null) {
            e16.f(this, this.action);
        }
        com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
        } else {
            aVar = aVar2;
        }
        this.mActivity = aVar.c().getActivity();
        this.needProcess = true;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(1);
        v();
        QQCustomDialog qQCustomDialog = this.mShareResultDlg;
        if (qQCustomDialog != null) {
            qQCustomDialog.dismiss();
        }
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        com.tencent.mvi.base.route.j e16 = aVar.e();
        if (e16 != null) {
            e16.i(this, this.action);
        }
        OpenShareByServerAIOHelper openShareByServerAIOHelper = this.shareByServerAIOHelper;
        if (openShareByServerAIOHelper != null) {
            openShareByServerAIOHelper.K();
        }
        this.shareByServerAIOHelper = null;
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state == 0) {
            QLog.i("OpenShareB77AIOHelper", 1, "onMoveToState CREATE");
            this.needProcess = true;
            return;
        }
        if (state != 3) {
            if (state != 12) {
                return;
            }
            QLog.i("OpenShareB77AIOHelper", 1, "onMoveToState DESTROY");
            return;
        }
        QLog.i("OpenShareB77AIOHelper", 1, "onMoveToState RESUME");
        if (this.needProcess) {
            F();
            if (B()) {
                Intent intent = this.mIntent;
                com.tencent.aio.api.runtime.a aVar = null;
                if (intent == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mIntent");
                    intent = null;
                }
                if (!TextUtils.isEmpty(intent.getStringExtra("key_b77_sdk_share"))) {
                    D();
                    return;
                }
                if (this.shareByServerAIOHelper == null) {
                    com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
                    if (aVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                    } else {
                        aVar = aVar2;
                    }
                    this.shareByServerAIOHelper = new OpenShareByServerAIOHelper(aVar, this.mActivity);
                }
                OpenShareByServerAIOHelper openShareByServerAIOHelper = this.shareByServerAIOHelper;
                if (openShareByServerAIOHelper != null) {
                    openShareByServerAIOHelper.C();
                }
            }
        }
    }

    public final void q(MsgIntent i3) {
        Intrinsics.checkNotNullParameter(i3, "i");
        if (i3 instanceof AIOLifeCycleEvent.OnNewIntent) {
            r();
        }
    }

    private final void s(final int errCode, String wording, final String errorMsgForApp) {
        ForwardStatisticsReporter.k("KEY_STAGE_2_TOTAL", false);
        Bundle bundle = this.mExtra;
        Bundle bundle2 = null;
        if (bundle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mExtra");
            bundle = null;
        }
        com.tencent.mobileqq.forward.x.n(bundle, o(), this.mShareAppId, false);
        Bundle bundle3 = this.mExtra;
        if (bundle3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mExtra");
        } else {
            bundle2 = bundle3;
        }
        if (bundle2.getBoolean(AppConstants.Key.FORWARD_MINI_PROGRAM_ARK_FROM_SDK, false)) {
            ReportController.o(null, "dc00898", "", "", "0X8009F7C", "0X8009F7C", 0, 0, "2", String.valueOf(errCode), "", "");
        }
        com.tencent.mobileqq.forward.g.c(this.mActivity, wording, new DialogInterface.OnClickListener() { // from class: com.tencent.qqnt.aio.helper.ct
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                OpenShareB77AIOHelper.t(OpenShareB77AIOHelper.this, errCode, errorMsgForApp, dialogInterface, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v() {
        Activity activity;
        QLog.d("OpenShareB77AIOHelper", 1, "hideWaiteDialog");
        if (y() && (activity = this.mActivity) != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.qqnt.aio.helper.cu
                @Override // java.lang.Runnable
                public final void run() {
                    OpenShareB77AIOHelper.w(OpenShareB77AIOHelper.this);
                }
            });
        }
    }

    private final void z(String jumpUrl, Context context) {
        QLog.d("OpenShareB77AIOHelper", 1, "jumpToErrorWeb: invoked. info: jumpUrl = ", jumpUrl);
        if (TextUtils.isEmpty(jumpUrl) || context == null) {
            return;
        }
        try {
            Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", jumpUrl);
            context.startActivity(intent);
        } catch (Throwable th5) {
            QLog.e("OpenShareB77AIOHelper", 1, "jumpToErrorWeb: Failed. info: exception = ", th5);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{0, 3, 12};
    }
}

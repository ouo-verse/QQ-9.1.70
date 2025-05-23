package com.tencent.qqnt.aio.helper;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.managers.PushNotificationManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.report.api.ITroopMsgDTReportApi;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.holder.MsgItemEvent;
import com.tencent.qqnt.aio.menu.MenuMsgEvent;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00042\u00020\u00012\u00020\u0002:\u0001AB\u0007\u00a2\u0006\u0004\b?\u0010@J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u000bH\u0002J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u0017\u001a\u00020\u0003H\u0002J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J\b\u0010\"\u001a\u00020!H\u0016J\b\u0010$\u001a\u00020#H\u0016J\u0010\u0010&\u001a\u00020\u00032\u0006\u0010%\u001a\u00020!H\u0016J\b\u0010'\u001a\u00020\u0003H\u0016J\u000e\u0010(\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tR\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00103\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010\u0010R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010:\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=\u00a8\u0006B"}, d2 = {"Lcom/tencent/qqnt/aio/helper/cc;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/mvi/base/route/g;", "", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "u", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "Landroid/content/Context;", "context", "M", "I", "G", "J", "v", "conrtext", HippyTKDListViewAdapter.X, "D", ReportConstant.COSTREPORT_PREFIX, "L", "r", "Ljava/lang/Runnable;", "callback", "o", "B", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "", "getTag", "", "getId", "", "interestedIn", "state", "onMoveToState", MosaicConstants$JsFunction.FUNC_ON_DESTROY, UserInfo.SEX_FEMALE, "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "e", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "progressDialog", "", "f", "enterUnreadCnt", "Lcom/tencent/mvi/base/route/a;", tl.h.F, "Lcom/tencent/mvi/base/route/a;", "mAction1", "i", "Ljava/lang/Runnable;", "mRunnable", "Lcom/tencent/widget/ActionSheet;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/widget/ActionSheet;", "mActionSheet", "<init>", "()V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes23.dex */
public final class cc implements com.tencent.aio.main.businesshelper.h, com.tencent.mvi.base.route.g {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QQProgressDialog progressDialog;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long enterUnreadCnt;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mvi.base.route.a mAction1;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Runnable mRunnable;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ActionSheet mActionSheet;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/aio/helper/cc$a;", "", "", "ERROR_CODE_ADMIN_RECALL_ADMIN", "I", "ERROR_CODE_ROLE_RECALL_ADMIN", "ERROR_CODE_ROLE_RECALL_ROLE", "ERROR_CODE_SYS_ERR", "", "TAG", "Ljava/lang/String;", "", "TWO_HOURS", "J", "TWO_MINUTES", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.helper.cc$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/helper/cc$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) cc.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                cc.this.u(i3);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return a.C9235a.a(this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63575);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public cc() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mAction1 = new b();
            this.mRunnable = new Runnable() { // from class: com.tencent.qqnt.aio.helper.br
                @Override // java.lang.Runnable
                public final void run() {
                    cc.A(cc.this);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(cc this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QQProgressDialog qQProgressDialog = this$0.progressDialog;
        if (qQProgressDialog != null) {
            Intrinsics.checkNotNull(qQProgressDialog);
            if (qQProgressDialog.isShowing()) {
                QQProgressDialog qQProgressDialog2 = this$0.progressDialog;
                Intrinsics.checkNotNull(qQProgressDialog2);
                qQProgressDialog2.dismiss();
                QQProgressDialog qQProgressDialog3 = this$0.progressDialog;
                Intrinsics.checkNotNull(qQProgressDialog3);
                qQProgressDialog3.setBackAndSearchFilter(false);
            }
        }
    }

    private final void B(AIOMsgItem msgItem) {
        String joinToString$default;
        if (msgItem.getMsgRecord().chatType == 2) {
            ITroopMsgDTReportApi iTroopMsgDTReportApi = (ITroopMsgDTReportApi) QRoute.api(ITroopMsgDTReportApi.class);
            String str = msgItem.getMsgRecord().peerUid;
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(msgItem.Q(), null, null, null, 0, null, null, 63, null);
            iTroopMsgDTReportApi.reportLongTapMsg(str, joinToString$default, String.valueOf(msgItem.getMsgRecord().senderUin), msgItem.getMsgRecord().msgTime);
        }
    }

    private final void C() {
        Integer num;
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar != null && (g16 = aVar.g()) != null && (r16 = g16.r()) != null && (c16 = r16.c()) != null) {
            num = Integer.valueOf(c16.e());
        } else {
            num = null;
        }
        if (this.enterUnreadCnt > 0) {
            if ((num != null && num.intValue() == 1) || (num != null && num.intValue() == 2)) {
                QLog.d("MsgHelper", 1, "onDelayLoad enterUnreadCnt :" + this.enterUnreadCnt);
                z();
            }
        }
    }

    private final void D(final AIOMsgItem msgItem, final Context context) {
        if (!NetworkUtil.isNetworkAvailable(context)) {
            QQToastUtil.showQQToastInUiThread(0, context.getString(R.string.f171375ei3));
            return;
        }
        L(msgItem, context);
        QLog.d("MsgHelper", 1, "recall msgId=" + msgItem.getMsgId());
        ((IMsgService) QRoute.api(IMsgService.class)).recallMsg(new Contact(msgItem.getMsgRecord().chatType, msgItem.getMsgRecord().peerUid, msgItem.getMsgRecord().guildId), msgItem.getMsgId(), new IOperateCallback() { // from class: com.tencent.qqnt.aio.helper.cb
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                cc.E(AIOMsgItem.this, context, this, i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(AIOMsgItem msgItem, Context context, cc this$0, int i3, String str) {
        int i16;
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("MsgHelper", 1, "recall resultCode=" + i3 + " errorMsg=" + str + ", msgId=" + msgItem.getMsgId());
        if (i3 != -30002) {
            switch (i3) {
                case 200501:
                case 200502:
                case 200503:
                    i16 = R.string.f211515l1;
                    break;
                default:
                    i16 = 0;
                    break;
            }
        } else {
            i16 = R.string.cdh;
        }
        if (i16 != 0) {
            QQToast.makeText(context, 1, i16, 0).show();
        }
        this$0.r();
    }

    private final void G(final AIOMsgItem msgItem, final Context context) {
        boolean z16;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
        String valueOf = String.valueOf(msgItem.getMsgRecord().peerUin);
        SharedPreferences sharedPreferences = qQAppInterface.getApp().getSharedPreferences(qQAppInterface.getCurrentAccountUin(), 0);
        if (sharedPreferences != null) {
            z16 = sharedPreferences.getBoolean(AppConstants.Preferences.FIRST_TIME_REVOKE_MESSAGE, true);
        } else {
            z16 = false;
        }
        if (z16 && !com.tencent.mobileqq.activity.aio.l.H(msgItem.getMsgRecord()) && !TroopUtils.C(qQAppInterface, valueOf, qQAppInterface.getCurrentAccountUin())) {
            sharedPreferences.edit().putBoolean(AppConstants.Preferences.FIRST_TIME_REVOKE_MESSAGE, false).commit();
            String string = BaseApplication.getContext().getString(R.string.cd5);
            Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(R\u2026.msg_first_revoke_prompt)");
            QQCustomDialog positiveButton = DialogUtil.createCustomDialog(context, 230).setMessage(string).setPositiveButton(R.string.f171151ok, new DialogInterface.OnClickListener() { // from class: com.tencent.qqnt.aio.helper.bw
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    cc.H(cc.this, msgItem, context, dialogInterface, i3);
                }
            });
            Intrinsics.checkNotNullExpressionValue(positiveButton, "createCustomDialog(conte\u2026s()\n                    }");
            positiveButton.show();
            return;
        }
        J(msgItem, context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(cc this$0, AIOMsgItem msgItem, Context context, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        Intrinsics.checkNotNullParameter(context, "$context");
        this$0.J(msgItem, context);
        dialogInterface.dismiss();
    }

    private final void I(AIOMsgItem msgItem, Context context) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
        if (TroopUtils.z(qQAppInterface, msgItem, qQAppInterface.getCurrentAccountUin())) {
            v(msgItem, context);
        } else {
            G(msgItem, context);
        }
    }

    private final void J(final AIOMsgItem msgItem, final Context context) {
        if (!com.tencent.mobileqq.activity.aio.l.H(msgItem.getMsgRecord())) {
            v(msgItem, context);
            return;
        }
        Dialog createDialog = ActionSheetHelper.createDialog(context, null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        actionSheet.setMainTitle(HardCodeUtil.qqStr(R.string.jxi) + HardCodeUtil.qqStr(R.string.jxb));
        actionSheet.addButton(HardCodeUtil.qqStr(R.string.jx9), 3);
        actionSheet.addCancelButton(HardCodeUtil.qqStr(R.string.j6l));
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.qqnt.aio.helper.bx
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                cc.K(cc.this, msgItem, context, actionSheet, view, i3);
            }
        });
        actionSheet.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(cc this$0, AIOMsgItem msgItem, Context context, ActionSheet actionSheet, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        if (i3 == 0) {
            this$0.v(msgItem, context);
        }
        actionSheet.dismiss();
    }

    private final void L(AIOMsgItem msgItem, Context context) {
        long j3;
        QQProgressDialog qQProgressDialog = new QQProgressDialog(context);
        this.progressDialog = qQProgressDialog;
        qQProgressDialog.setMessage(context.getString(R.string.cdj));
        QQProgressDialog qQProgressDialog2 = this.progressDialog;
        if (qQProgressDialog2 != null) {
            qQProgressDialog2.setBackAndSearchFilter(true);
        }
        QQProgressDialog qQProgressDialog3 = this.progressDialog;
        if (qQProgressDialog3 != null) {
            qQProgressDialog3.show();
        }
        if (msgItem.getMsgRecord().msgType == 3) {
            j3 = 30000;
        } else {
            j3 = 20000;
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.mRunnable, j3);
    }

    private final void M(final AIOMsgItem msgItem, final Context context) {
        Dialog createDialog = ActionSheetHelper.createDialog(context, null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        actionSheet.setMainTitle(BaseApplication.getContext().getString(R.string.ius));
        actionSheet.addButton(BaseApplication.getContext().getString(R.string.cde), 3);
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.qqnt.aio.helper.bu
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                cc.N(cc.this, msgItem, context, actionSheet, view, i3);
            }
        });
        actionSheet.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(cc this$0, AIOMsgItem msgItem, Context context, ActionSheet sheet, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(sheet, "$sheet");
        if (i3 == 0) {
            this$0.I(msgItem, context);
        }
        sheet.dismiss();
    }

    private final void o(final Runnable callback) {
        final Context context;
        Fragment c16;
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar != null && (c16 = aVar.c()) != null) {
            context = c16.getContext();
        } else {
            context = null;
        }
        if (context == null) {
            QLog.d("MsgHelper", 1, "delCheck failure, context == null");
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.tencent.qqnt.aio.helper.bs
            @Override // java.lang.Runnable
            public final void run() {
                cc.p(cc.this, context, callback);
            }
        };
        Object systemService = context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        boolean isActive = inputMethodManager.isActive();
        if ((context instanceof Activity) && isActive) {
            inputMethodManager.hideSoftInputFromWindow(((Activity) context).getWindow().getDecorView().getWindowToken(), 0);
            ThreadManagerV2.getUIHandlerV2().postDelayed(runnable, 60L);
        } else {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(final cc this$0, Context context, final Runnable callback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Dialog createDialog = ActionSheetHelper.createDialog(context, null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        this$0.mActionSheet = (ActionSheet) createDialog;
        Intrinsics.checkNotNull(context);
        String string = context.getResources().getString(R.string.f1787537i);
        Intrinsics.checkNotNull(string, "null cannot be cast to non-null type kotlin.CharSequence");
        ActionSheet actionSheet = this$0.mActionSheet;
        if (actionSheet != null) {
            actionSheet.setMainTitle(string);
        }
        ActionSheet actionSheet2 = this$0.mActionSheet;
        if (actionSheet2 != null) {
            actionSheet2.addButton(R.string.f170822ak3, 3);
        }
        ActionSheet actionSheet3 = this$0.mActionSheet;
        if (actionSheet3 != null) {
            actionSheet3.addCancelButton(R.string.cancel);
        }
        ActionSheet actionSheet4 = this$0.mActionSheet;
        if (actionSheet4 != null) {
            actionSheet4.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.qqnt.aio.helper.bt
                @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
                public final void onClick(View view, int i3) {
                    cc.q(callback, this$0, view, i3);
                }
            });
        }
        ActionSheet actionSheet5 = this$0.mActionSheet;
        if (actionSheet5 != null) {
            actionSheet5.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(Runnable callback, cc this$0, View view, int i3) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0) {
            callback.run();
        }
        ActionSheet actionSheet = this$0.mActionSheet;
        if (actionSheet != null) {
            actionSheet.dismiss();
        }
    }

    private final void r() {
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.mRunnable);
        ThreadManagerV2.getUIHandlerV2().post(this.mRunnable);
    }

    private final void s(AIOMsgItem msgItem, Context context) {
        int i3;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
        if (!TroopUtils.x(qQAppInterface, msgItem, qQAppInterface.getCurrentAccountUin())) {
            QQCustomDialog positiveButton = DialogUtil.createCustomDialog(context, 230).setMessage(HardCodeUtil.qqStr(R.string.ucz)).setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() { // from class: com.tencent.qqnt.aio.helper.ca
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i16) {
                    cc.t(dialogInterface, i16);
                }
            });
            Intrinsics.checkNotNullExpressionValue(positiveButton, "createCustomDialog(conte\u2026smiss()\n                }");
            positiveButton.show();
            return;
        }
        if (NetworkUtil.isNetworkAvailable(context)) {
            D(msgItem, context);
            return;
        }
        Resources resources = context.getResources();
        if (resources != null) {
            i3 = resources.getDimensionPixelSize(R.dimen.title_bar_height);
        } else {
            i3 = 0;
        }
        QQToast.makeText(context, R.string.f171375ei3, 0).show(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(MsgIntent intent) {
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        boolean z16 = false;
        if (intent instanceof MenuMsgEvent.RevokeCheck) {
            MenuMsgEvent.RevokeCheck revokeCheck = (MenuMsgEvent.RevokeCheck) intent;
            F(revokeCheck.a());
            revokeCheck.c(false);
            QLog.d("MsgHelper", 1, "MenuMsgEvent.RevokeCheck. needHandle:  false");
            return;
        }
        if (intent instanceof MenuMsgEvent.DelCheckEvent) {
            QLog.d("MsgHelper", 1, "MenuMsgEvent.DelCheckEvent");
            o(((MenuMsgEvent.DelCheckEvent) intent).a());
            return;
        }
        if (intent instanceof MsgItemEvent.MsgItemLongClickEvent) {
            QLog.d("MsgHelper", 1, "MsgItemEvent.MsgItemLongClickEvent");
            B(((MsgItemEvent.MsgItemLongClickEvent) intent).a());
            return;
        }
        if (intent instanceof AIOMsgSendEvent.OnMsgSendSuccessEvent) {
            com.tencent.aio.api.runtime.a aVar = this.aioContext;
            if (aVar != null && (g16 = aVar.g()) != null && (r16 = g16.r()) != null && (c16 = r16.c()) != null && c16.e() == 1) {
                z16 = true;
            }
            if (z16) {
                z();
            }
        }
    }

    private final void v(final AIOMsgItem msgItem, final Context context) {
        if (com.tencent.mobileqq.activity.aio.l.M(msgItem.getMsgRecord())) {
            Dialog createDialog = ActionSheetHelper.createDialog(context, null);
            Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
            final ActionSheet actionSheet = (ActionSheet) createDialog;
            actionSheet.setMainTitle(HardCodeUtil.qqStr(R.string.ud_) + HardCodeUtil.qqStr(R.string.f172809ud4));
            actionSheet.addButton(context.getString(R.string.cde), 3);
            actionSheet.addCancelButton(R.string.cancel);
            actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.qqnt.aio.helper.bv
                @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
                public final void onClick(View view, int i3) {
                    cc.w(cc.this, msgItem, context, actionSheet, view, i3);
                }
            });
            actionSheet.show();
            return;
        }
        x(msgItem, context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(cc this$0, AIOMsgItem msgItem, Context context, ActionSheet sheet, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(sheet, "$sheet");
        if (i3 == 0) {
            this$0.s(msgItem, context);
        }
        sheet.dismiss();
    }

    private final void x(AIOMsgItem msgItem, Context conrtext) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
        boolean C = TroopUtils.C(qQAppInterface, String.valueOf(msgItem.getMsgRecord().peerUin), qQAppInterface.getCurrentAccountUin());
        if ((!com.tencent.imcore.message.ext.codec.decoder.msgType0x210.ae.f(qQAppInterface, msgItem.getMsgRecord().msgTime, 120000L) || C) && !C && ((!com.tencent.mobileqq.activity.aio.l.H(msgItem.getMsgRecord()) || !com.tencent.imcore.message.ext.codec.decoder.msgType0x210.ae.f(qQAppInterface, msgItem.getMsgRecord().msgTime, 7200000L)) && !TroopUtils.z(qQAppInterface, msgItem, qQAppInterface.getCurrentAccountUin()))) {
            QQCustomDialog positiveButton = DialogUtil.createCustomDialog(conrtext, 230).setMessage(BaseApplication.getContext().getString(R.string.cdf)).setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() { // from class: com.tencent.qqnt.aio.helper.bz
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    cc.y(dialogInterface, i3);
                }
            });
            Intrinsics.checkNotNullExpressionValue(positiveButton, "createCustomDialog(conrt\u2026smiss()\n                }");
            if (com.tencent.mobileqq.activity.aio.l.H(msgItem.getMsgRecord())) {
                positiveButton.setMessage(BaseApplication.getContext().getString(R.string.f168432fm));
            }
            positiveButton.show();
            return;
        }
        D(msgItem, conrtext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    private final void z() {
        AIOSession aIOSession;
        AIOParam g16;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        Manager manager = peekAppRuntime.getManager(QQManagerFactory.PUSH_NOTIFICATION_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.managers.PushNotificationManager");
        PushNotificationManager pushNotificationManager = (PushNotificationManager) manager;
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar != null && (g16 = aVar.g()) != null) {
            aIOSession = g16.r();
        } else {
            aIOSession = null;
        }
        pushNotificationManager.h(aIOSession, 0);
    }

    public final void F(@NotNull AIOMsgItem msgItem) {
        FragmentActivity fragmentActivity;
        Fragment c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) msgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar != null && (c16 = aVar.c()) != null) {
            fragmentActivity = c16.getActivity();
        } else {
            fragmentActivity = null;
        }
        if (fragmentActivity == null) {
            QLog.d("MsgHelper", 1, "revokeMessage context == null, msgId=" + msgItem.getMsgId());
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
        String valueOf = String.valueOf(msgItem.getMsgRecord().peerUin);
        if (!msgItem.isSelf() && TroopUtils.C(qQAppInterface, valueOf, qQAppInterface.getCurrentAccountUin()) && msgItem.getMsgRecord().msgType != 3) {
            M(msgItem, fragmentActivity);
        } else {
            I(msgItem, fragmentActivity);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return cw.f350677u0;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Set) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.qqnt.aio.menu.MenuMsgEvent.RevokeCheck");
        hashSet.add("com.tencent.qqnt.aio.menu.MenuMsgEvent.DelCheckEvent");
        hashSet.add("com.tencent.qqnt.aio.holder.MsgItemEvent.MsgItemLongClickEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgSendEvent.OnMsgSendSuccessEvent");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Set) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return new HashSet();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "MsgHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (int[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return new int[]{4};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        AIOParam g16;
        Bundle l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) param);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        com.tencent.aio.api.runtime.a a16 = param.a();
        this.aioContext = a16;
        Intrinsics.checkNotNull(a16);
        a16.e().f(this, this.mAction1);
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        long j3 = 0;
        if (aVar != null && (g16 = aVar.g()) != null && (l3 = g16.l()) != null) {
            j3 = l3.getLong("key_enter_unread_cnt", 0L);
        }
        this.enterUnreadCnt = j3;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        com.tencent.mvi.base.route.j e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        h.a.b(this);
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar != null && (e16 = aVar.e()) != null) {
            e16.i(this, this.mAction1);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, state);
        } else if (state == 4) {
            C();
        }
    }
}

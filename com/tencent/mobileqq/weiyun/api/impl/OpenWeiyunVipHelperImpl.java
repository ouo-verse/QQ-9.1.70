package com.tencent.mobileqq.weiyun.api.impl;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.weiyun.api.IOpenWeiyunVipHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class OpenWeiyunVipHelperImpl implements IOpenWeiyunVipHelper {
    static IPatchRedirector $redirector_ = null;
    private static final String AID_WY_OPEN_QQ_VIP = "mvip.n.a.zcwy_popup";
    private static final int HANDLE_MSG_DELAY_TIME = 1000;
    private static final int MSG_CLOSE_SPACE_OR_FLOW_DIALOG = 3001;
    private static final int MSG_SHOW_SPACE_OR_FLOW_DIALOG = 3000;
    private static final String OPEN_QQ_VIP_STRATEIE_URL = "https://h5.vip.qq.com/proxy/domain/imgcache.qq.com/club/platform/lib/pay/wv_proxy.html?_wv=524289&aid=%s";
    private static final String OPEN_WEIYUN_VIP_STRATEIE_URL = "https://jump.weiyun.com?from=3092";
    private static final int SHOW_DIALOG_INTERVAL = 4000;
    private static final String TAG = "OpenWeiyunVipHelper";
    private static final String[] WHITE_ACTIVITY_LIST;
    private static d mHandler;
    private static volatile long mLastShowDialogTime;
    private static QQCustomDialog sQQCustomDialog;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f315120d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Activity f315121e;

        a(int i3, Activity activity) {
            this.f315120d = i3;
            this.f315121e = activity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, OpenWeiyunVipHelperImpl.this, Integer.valueOf(i3), activity);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else if (OpenWeiyunVipHelperImpl.this.isNonVipSpaceOverErrorCode(this.f315120d)) {
                OpenWeiyunVipHelperImpl.this.startOpenWeiyunVipCompareH5(this.f315121e, null, false);
            } else {
                OpenWeiyunVipHelperImpl.this.startOpenQQVipH5(this.f315121e, OpenWeiyunVipHelperImpl.AID_WY_OPEN_QQ_VIP, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) OpenWeiyunVipHelperImpl.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class c implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) OpenWeiyunVipHelperImpl.this);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            } else {
                OpenWeiyunVipHelperImpl.this.closeLimitDialog();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class d extends Handler {
        static IPatchRedirector $redirector_;

        public d(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            int i3 = message.what;
            if (i3 != 3000) {
                if (i3 == 3001) {
                    QQCustomDialog unused = OpenWeiyunVipHelperImpl.sQQCustomDialog = null;
                    long unused2 = OpenWeiyunVipHelperImpl.mLastShowDialogTime = SystemClock.uptimeMillis();
                    return;
                }
                return;
            }
            ((OpenWeiyunVipHelperImpl) QRoute.api(IOpenWeiyunVipHelper.class)).showLimitDialogInner((Activity) message.obj, message.arg1);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19394);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
            return;
        }
        sQQCustomDialog = null;
        mHandler = new d(Looper.getMainLooper());
        WHITE_ACTIVITY_LIST = new String[]{"TroopFileDetailBrowserActivity", "FMActivity", "FileBrowserActivity", "ChatHistoryFileActivity", "FileAssistantActivity"};
        mLastShowDialogTime = 0L;
    }

    public OpenWeiyunVipHelperImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean isInWhiteList(Activity activity) {
        if (activity != null) {
            String name = activity.getClass().getName();
            for (String str : WHITE_ACTIVITY_LIST) {
                if (!TextUtils.isEmpty(name) && name.contains(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isNeedShowOutOfInterval() {
        if (mLastShowDialogTime == 0) {
            return true;
        }
        if (mLastShowDialogTime + 4000 < SystemClock.uptimeMillis()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLimitDialogInner(Activity activity, int i3) {
        String string;
        String string2;
        if (activity == null || activity.isFinishing() || activity != QBaseActivity.sTopActivity) {
            activity = QBaseActivity.sTopActivity;
        }
        Activity activity2 = activity;
        if (activity2 != null && !activity2.isFinishing() && isInWhiteList(activity2)) {
            QQCustomDialog qQCustomDialog = sQQCustomDialog;
            if ((qQCustomDialog == null || !qQCustomDialog.isShowing()) && isNeedShowOutOfInterval()) {
                if (isNonVipSpaceOverErrorCode(i3)) {
                    string = MobileQQ.sMobileQQ.getString(R.string.baz);
                } else {
                    string = MobileQQ.sMobileQQ.getString(R.string.f170963bb0);
                }
                String str = string;
                if (isNonVipSpaceOverErrorCode(i3)) {
                    string2 = MobileQQ.sMobileQQ.getString(R.string.bau);
                } else {
                    string2 = MobileQQ.sMobileQQ.getString(R.string.baw);
                }
                QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity2, 230, str, string2, R.string.bax, R.string.bay, new a(i3, activity2), new b());
                sQQCustomDialog = createCustomDialog;
                createCustomDialog.setOnDismissListener(new c());
                sQQCustomDialog.show();
            }
        }
    }

    private void showLimitDialogInnerForGP(Activity activity, int i3) {
        String string;
        if (activity == null || activity.isFinishing() || activity != QBaseActivity.sTopActivity) {
            activity = QBaseActivity.sTopActivity;
        }
        if (activity != null && !activity.isFinishing() && isInWhiteList(activity)) {
            if (isNonVipSpaceOverErrorCode(i3)) {
                string = MobileQQ.sMobileQQ.getString(R.string.f1355001m);
            } else {
                string = MobileQQ.sMobileQQ.getString(R.string.f1355101n);
            }
            QQToast.makeText(activity, 0, string, 1).show();
        }
    }

    @Override // com.tencent.mobileqq.weiyun.api.IOpenWeiyunVipHelper
    public void closeLimitDialog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        Message obtainMessage = mHandler.obtainMessage();
        obtainMessage.what = 3001;
        mHandler.sendMessage(obtainMessage);
    }

    @Override // com.tencent.mobileqq.weiyun.api.IOpenWeiyunVipHelper
    public boolean isNonVipFlowOverErrorCode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, i3)).booleanValue();
        }
        if (i3 != 1127 && i3 != 22000) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.weiyun.api.IOpenWeiyunVipHelper
    public boolean isNonVipSpaceOverErrorCode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, i3)).booleanValue();
        }
        if (i3 != 1053 && i3 != 22081) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.weiyun.api.IOpenWeiyunVipHelper
    public boolean needShowLimitDialog(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, i3)).booleanValue();
        }
        if (!isNonVipFlowOverErrorCode(i3) && !isNonVipSpaceOverErrorCode(i3)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.weiyun.api.IOpenWeiyunVipHelper
    public void showLimitDialog(Activity activity, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity, i3);
            return;
        }
        QLog.d(TAG, 2, "showLimitDialog");
        mHandler.removeMessages(3000);
        Message obtainMessage = mHandler.obtainMessage();
        obtainMessage.what = 3000;
        obtainMessage.obj = activity;
        obtainMessage.arg1 = i3;
        mHandler.sendMessageDelayed(obtainMessage, 1000L);
    }

    @Override // com.tencent.mobileqq.weiyun.api.IOpenWeiyunVipHelper
    public void showWeiYunSpaceOrFlowLimitDialog(Activity activity, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, i3);
        } else if (needShowLimitDialog(i3)) {
            showLimitDialog(activity, i3);
        }
    }

    @Override // com.tencent.mobileqq.weiyun.api.IOpenWeiyunVipHelper
    public void startOpenQQVipH5(Activity activity, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, activity, str, Boolean.valueOf(z16));
            return;
        }
        String format = String.format(OPEN_QQ_VIP_STRATEIE_URL, str);
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(activity, RouterConstants.UI_ROUTE_BROWSER);
        activityURIRequest.extra().putString("url", format);
        if (z16) {
            activityURIRequest.setRequestCode(2000);
        }
        QRoute.startUri(activityURIRequest, (o) null);
    }

    @Override // com.tencent.mobileqq.weiyun.api.IOpenWeiyunVipHelper
    public void startOpenWeiyunVipCompareH5(Activity activity, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, activity, str, Boolean.valueOf(z16));
            return;
        }
        StringBuffer stringBuffer = new StringBuffer(OPEN_WEIYUN_VIP_STRATEIE_URL);
        if (str != null) {
            stringBuffer.append("&aid=");
            stringBuffer.append(str);
        }
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(activity, RouterConstants.UI_ROUTE_BROWSER);
        activityURIRequest.extra().putString("url", stringBuffer.toString());
        if (z16) {
            activityURIRequest.setRequestCode(2000);
        }
        QRoute.startUri(activityURIRequest, (o) null);
    }
}

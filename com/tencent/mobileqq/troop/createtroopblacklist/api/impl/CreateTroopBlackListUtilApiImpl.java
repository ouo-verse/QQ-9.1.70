package com.tencent.mobileqq.troop.createtroopblacklist.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.troop.createtroopblacklist.api.ICreateTroopBlackListUtilApi;
import com.tencent.mobileqq.troop.data.TroopCreateInfo;
import com.tencent.mobileqq.troop.temporaryban.c;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.SecurityInfo;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes19.dex */
public class CreateTroopBlackListUtilApiImpl implements ICreateTroopBlackListUtilApi {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "CreateTroopBlackListUtilApiImpl";

    public CreateTroopBlackListUtilApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void jumpH5(Context context, String str) {
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, RouterConstants.UI_ROUTE_BROWSER);
        activityURIRequest.extra().putString("url", str);
        QRoute.startUri(activityURIRequest, (o) null);
    }

    private void jumpMiniApp(Context context, String str) {
        QLog.i(TAG, 1, "[jumpMiniApp] url: " + str);
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(context, str, 2010, null);
    }

    private void jumpWebPageNeeded(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.w(TAG, 1, "[jumpWebPageNeeded] empty jumpUrl. ignore");
            return;
        }
        if (str.startsWith("http")) {
            jumpH5(context, str);
            return;
        }
        if (str.startsWith("mqq")) {
            jumpMiniApp(context, str);
            return;
        }
        showCreateFailedToast();
        QLog.w(TAG, 1, "[jumpWebPageNeeded] failed. jumpUrl invalid: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showCreateTroopSecurityDialog$0(Activity activity, com.tencent.mobileqq.troop.createtroopblacklist.api.a aVar, DialogInterface dialogInterface, int i3) {
        jumpWebPageNeeded(activity, aVar.f());
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showCreateTroopSecurityDialog$1(Activity activity, com.tencent.mobileqq.troop.createtroopblacklist.api.a aVar, DialogInterface dialogInterface, int i3) {
        jumpWebPageNeeded(activity, aVar.d());
        dialogInterface.dismiss();
    }

    private void showCreateFailedToast() {
        String qqStr = HardCodeUtil.qqStr(R.string.f170803zp2);
        QLog.w(TAG, 1, "[showCreateFailedToast]. Use Toast: " + qqStr);
        QQToast.makeText(MobileQQ.sMobileQQ.getApplicationContext(), qqStr, 0).show();
    }

    @Override // com.tencent.mobileqq.troop.createtroopblacklist.api.ICreateTroopBlackListUtilApi
    public void onCreateTroopFailure(int i3, String str, SecurityInfo securityInfo, WeakReference<Activity> weakReference) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, securityInfo, weakReference);
            return;
        }
        Activity activity = weakReference.get();
        if (i3 == 255 && securityInfo != null && activity != null) {
            c.e().f(bg.e(), activity, securityInfo);
            return;
        }
        int a16 = TroopCreateInfo.c.a(i3);
        if (a16 != 0) {
            QQToast.makeText(BaseApplication.getContext(), a16, 0).show();
        } else if (!TextUtils.isEmpty(str)) {
            QQToast.makeText(BaseApplication.getContext(), str, 0).show();
        }
    }

    @Override // com.tencent.mobileqq.troop.createtroopblacklist.api.ICreateTroopBlackListUtilApi
    public void showCreateTroopSecurityDialog(final Activity activity, final com.tencent.mobileqq.troop.createtroopblacklist.api.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) aVar);
            return;
        }
        if (activity != null && !activity.isDestroyed() && !activity.isFinishing()) {
            QLog.i(TAG, 1, "[showCreateTroopSecurityDialog] params: " + aVar);
            DialogUtil.createCustomDialog(activity, 230, aVar.b(), aVar.a(), aVar.c(), aVar.e(), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.createtroopblacklist.api.impl.a
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    CreateTroopBlackListUtilApiImpl.this.lambda$showCreateTroopSecurityDialog$0(activity, aVar, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.createtroopblacklist.api.impl.b
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    CreateTroopBlackListUtilApiImpl.this.lambda$showCreateTroopSecurityDialog$1(activity, aVar, dialogInterface, i3);
                }
            }).show();
            return;
        }
        showCreateFailedToast();
    }
}

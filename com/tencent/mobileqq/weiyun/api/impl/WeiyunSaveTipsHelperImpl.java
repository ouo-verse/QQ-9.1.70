package com.tencent.mobileqq.weiyun.api.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.api.IQQFileSelector;
import com.tencent.mobileqq.filemanager.util.an;
import com.tencent.mobileqq.filemanager.util.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.weiyun.api.IWeiyunApi;
import com.tencent.mobileqq.weiyun.api.IWeiyunSaveTipsHelper;
import com.tencent.mobileqq.weiyun.utils.c;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class WeiyunSaveTipsHelperImpl implements IWeiyunSaveTipsHelper {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "WeiyunSaveTipsFactory";

    public WeiyunSaveTipsHelperImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void queryNeedVerifyPwd(AppInterface appInterface, Activity activity) {
        IQQFileEngine iQQFileEngine = (IQQFileEngine) appInterface.getRuntimeService(IQQFileEngine.class, "all");
        if (iQQFileEngine.hasQueriedVerifyPassword()) {
            iQQFileEngine.queryNeedVerifyPwd();
        } else if (NetworkUtil.isNetSupport(MobileQQ.sMobileQQ)) {
            ((IQQFileSelector) QRoute.api(IQQFileSelector.class)).enterCloudFileBrowser(activity);
        } else {
            d.f(MobileQQ.sMobileQQ.getString(R.string.f171137ci2));
        }
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunSaveTipsHelper
    public void showTopTips(AppInterface appInterface, Activity activity, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appInterface, activity, Integer.valueOf(i3));
        } else if (appInterface != null && activity != null) {
            an.j();
            ThreadManager.getUIHandler().postDelayed(new Runnable(activity, i3, appInterface) { // from class: com.tencent.mobileqq.weiyun.api.impl.WeiyunSaveTipsHelperImpl.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Activity f315132d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f315133e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ AppInterface f315134f;

                /* compiled from: P */
                /* renamed from: com.tencent.mobileqq.weiyun.api.impl.WeiyunSaveTipsHelperImpl$1$a */
                /* loaded from: classes20.dex */
                class a implements View.OnTouchListener {
                    static IPatchRedirector $redirector_;

                    a() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                        }
                    }

                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
                        }
                        if (motionEvent.getAction() != 0) {
                            return false;
                        }
                        QLog.d("hehe", 2, "", "toast touch event");
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        WeiyunSaveTipsHelperImpl weiyunSaveTipsHelperImpl = WeiyunSaveTipsHelperImpl.this;
                        AppInterface appInterface = anonymousClass1.f315134f;
                        Activity activity = anonymousClass1.f315132d;
                        weiyunSaveTipsHelperImpl.startWeiyunDisk(appInterface, activity, activity.getApplicationContext());
                        return true;
                    }
                }

                {
                    this.f315132d = activity;
                    this.f315133e = i3;
                    this.f315134f = appInterface;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, WeiyunSaveTipsHelperImpl.this, activity, Integer.valueOf(i3), appInterface);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (Build.VERSION.SDK_INT >= 28) {
                        QQToast.makeText(this.f315132d.getApplicationContext(), 2, R.string.em5, 1).show(this.f315133e);
                    } else {
                        QQToast.makeText(this.f315132d.getApplicationContext(), 2, R.string.imn, 1).showTouchableToast(this.f315133e, R.layout.f169207cf2, new a());
                    }
                }
            }, 1000L);
        }
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunSaveTipsHelper
    public void startWeiyunDisk(AppInterface appInterface, Activity activity, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, appInterface, activity, context);
            return;
        }
        int e16 = c.e(context, appInterface.getCurrentAccountUin());
        if (e16 == 1) {
            String d16 = c.d(context, appInterface.getCurrentAccountUin());
            int f16 = c.f(context, appInterface.getCurrentAccountUin());
            if (!TextUtils.isEmpty(d16)) {
                ((IWeiyunApi) QRoute.api(IWeiyunApi.class)).startWeiYunMiniApp(activity, d16, f16, null);
                return;
            }
            QLog.w(TAG, 2, "can not to start WeiYun Mini app, apkgUrl = " + d16 + ", version = " + f16);
            queryNeedVerifyPwd(appInterface, activity);
            return;
        }
        QLog.w(TAG, 2, "can not to start WeiYun Mini app, weiYunGrayConfig = " + e16);
        queryNeedVerifyPwd(appInterface, activity);
    }
}

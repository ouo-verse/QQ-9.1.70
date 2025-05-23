package com.tencent.comic;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.IQWalletHelper;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes32.dex */
public class g extends RemoteCommand {

    /* renamed from: b, reason: collision with root package name */
    private static Bundle f99374b;

    /* renamed from: a, reason: collision with root package name */
    boolean f99375a;

    public g(String str, boolean z16) {
        super(str);
        this.f99375a = z16;
    }

    private boolean a(AppInterface appInterface, String str) {
        IPublicAccountDataManager iPublicAccountDataManager = (IPublicAccountDataManager) appInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
        return (iPublicAccountDataManager == null || iPublicAccountDataManager.findPublicAccountInfo(str) == null) ? false : true;
    }

    private Bundle b(Bundle bundle) {
        AppRuntime a16 = com.tencent.comic.utils.a.a();
        if (!(a16 instanceof BaseQQAppInterface)) {
            if (QLog.isColorLevel()) {
                QLog.d("VipComicRemoteCommand", 2, "onRemoteInvoke cannot get QQAppInterface");
            }
            return null;
        }
        BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) a16;
        String string = bundle.getString("cacomicetinfo");
        if ("Remotecall_getPublicAccountState".equals(string)) {
            String string2 = bundle.getString("uin");
            if (!TextUtils.isEmpty(string2)) {
                boolean a17 = a(baseQQAppInterface, string2);
                Bundle bundle2 = new Bundle();
                bundle2.putBoolean("state", a17);
                return bundle2;
            }
        } else if ("Remotecall_showPublicAccountDetail".equals(string)) {
            String string3 = bundle.getString("uin");
            if (!TextUtils.isEmpty(string3)) {
                e(baseQQAppInterface, string3);
            }
        } else {
            if ("Remotecall_getUserStatus".equals(string)) {
                Bundle bundle3 = new Bundle();
                if (VasUtil.getSignedService(baseQQAppInterface).getVipStatus().isSVip()) {
                    bundle3.putInt("userStatus", 3);
                } else if (VasUtil.getSignedService(baseQQAppInterface).getVipStatus().isVip()) {
                    bundle3.putInt("userStatus", 2);
                } else {
                    bundle3.putInt("userStatus", 1);
                }
                return bundle3;
            }
            if ("Remotecall_initQbPlugin".equals(string)) {
                try {
                    ((IQWalletHelper) QRoute.api(IQWalletHelper.class)).preloadQWallet(baseQQAppInterface);
                    if (QLog.isColorLevel()) {
                        QLog.i("VipComicRemoteCommand", 2, "preloadQWallet()");
                    }
                    Bundle bundle4 = new Bundle();
                    bundle4.putBoolean("success", true);
                    return bundle4;
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            } else if ("Remotecall_showComicBar".equals(string)) {
                d(bundle);
            } else if (QLog.isColorLevel()) {
                QLog.d("VipComicRemoteCommand", 2, "onRemoteInvoke unknow invokeCmd");
            }
        }
        return null;
    }

    public static void c() {
        PluginCommunicationHandler pluginCommunicationHandler = PluginCommunicationHandler.getInstance();
        if (pluginCommunicationHandler != null) {
            pluginCommunicationHandler.register(new g("cacomicetinfo", true));
        }
    }

    public static synchronized Bundle d(Bundle bundle) {
        Bundle bundle2;
        synchronized (g.class) {
            bundle2 = f99374b;
            f99374b = bundle;
        }
        return bundle2;
    }

    private void e(AppInterface appInterface, String str) {
        Intent intent = new Intent();
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.addFlags(268435456);
        ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).gotoProfile(intent, appInterface, BaseApplication.getContext(), str, -1);
    }

    @Override // com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand
    public Bundle invoke(Bundle bundle, RemoteCommand.OnInvokeFinishLinstener onInvokeFinishLinstener) {
        Bundle b16 = b(bundle);
        if (onInvokeFinishLinstener != null) {
            onInvokeFinishLinstener.onInvokeFinish(b16);
        }
        return b16;
    }
}

package com.tencent.mobileqq.weiyun.api.impl;

import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.f;
import com.tencent.mobileqq.graytip.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.e;
import com.tencent.mobileqq.weiyun.api.IWeiyunGrayTipHelper;
import com.tencent.mobileqq.weiyun.api.IWeiyunHelper;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;

/* compiled from: P */
/* loaded from: classes20.dex */
public class WeiyunGrayTipHelperImpl implements IWeiyunGrayTipHelper {
    static IPatchRedirector $redirector_;

    public WeiyunGrayTipHelperImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.weiyun.api.IWeiyunGrayTipHelper
    public void insertAIOGrayTips(AppInterface appInterface, String str, String str2, int i3, int i16, String str3) {
        String str4;
        String str5;
        String string;
        String openWeiyunBuySpaceH5;
        int indexOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appInterface, str, str2, Integer.valueOf(i3), Integer.valueOf(i16), str3);
            return;
        }
        if (!TextUtils.isEmpty(str3)) {
            IWeiyunHelper iWeiyunHelper = (IWeiyunHelper) QRoute.api(IWeiyunHelper.class);
            if (i16 == 1127) {
                string = appInterface.getApp().getString(R.string.c0c);
                openWeiyunBuySpaceH5 = iWeiyunHelper.getOpenQQVipH5(appInterface.getCurrentAccountUin(), IWeiyunHelper.AID_WY_OPEN_QQ_VIP);
            } else if (i16 == 22000) {
                string = appInterface.getApp().getString(R.string.c0c);
                openWeiyunBuySpaceH5 = iWeiyunHelper.getOpenQQVipH5(appInterface.getCurrentAccountUin(), IWeiyunHelper.AID_WY_OPEN_QQ_VIP);
            } else if (i16 == 1053) {
                string = appInterface.getApp().getString(R.string.c0f);
                openWeiyunBuySpaceH5 = iWeiyunHelper.getOpenWeiyunVipH5(appInterface.getCurrentAccountUin(), "qq_aio_capacity_open_vip");
            } else if (i16 == 22081) {
                string = appInterface.getApp().getString(R.string.c0e);
                openWeiyunBuySpaceH5 = iWeiyunHelper.getOpenWeiyunVipH5(appInterface.getCurrentAccountUin(), "qq_aio_capacity_open_vip");
            } else if (i16 == 22121) {
                string = appInterface.getApp().getString(R.string.c0d);
                openWeiyunBuySpaceH5 = iWeiyunHelper.getOpenWeiyunBuySpaceH5();
            } else {
                str4 = "";
                str5 = str4;
                if (!TextUtils.isEmpty(str5) || (indexOf = str3.indexOf(str5)) == -1) {
                    return;
                }
                new BaseThread(new Runnable(appInterface, str, str2, str3, i3, str4, indexOf, str5) { // from class: com.tencent.mobileqq.weiyun.api.impl.WeiyunGrayTipHelperImpl.1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ int C;
                    final /* synthetic */ String D;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ AppInterface f315126d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ String f315127e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ String f315128f;

                    /* renamed from: h, reason: collision with root package name */
                    final /* synthetic */ String f315129h;

                    /* renamed from: i, reason: collision with root package name */
                    final /* synthetic */ int f315130i;

                    /* renamed from: m, reason: collision with root package name */
                    final /* synthetic */ String f315131m;

                    {
                        this.f315126d = appInterface;
                        this.f315127e = str;
                        this.f315128f = str2;
                        this.f315129h = str3;
                        this.f315130i = i3;
                        this.f315131m = str4;
                        this.C = indexOf;
                        this.D = str5;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, WeiyunGrayTipHelperImpl.this, appInterface, str, str2, str3, Integer.valueOf(i3), str4, Integer.valueOf(indexOf), str5);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        if (!(this.f315126d instanceof QQAppInterface)) {
                            return;
                        }
                        Process.setThreadPriority(10);
                        g gVar = new g(this.f315127e, this.f315128f, this.f315129h, this.f315130i, MessageRecord.MSG_TYPE_UNITE_TAB_HISTORI_INVI, 2424833, e.K0());
                        Bundle bundle = new Bundle();
                        bundle.putInt("key_action", 1);
                        bundle.putString("key_action_DATA", this.f315131m);
                        int i17 = this.C;
                        gVar.b(i17, this.D.length() + i17, bundle);
                        MessageForUniteGrayTip messageForUniteGrayTip = new MessageForUniteGrayTip();
                        messageForUniteGrayTip.initGrayTipMsg((QQAppInterface) this.f315126d, gVar);
                        f.a((QQAppInterface) this.f315126d, messageForUniteGrayTip);
                    }
                }).start();
            }
            str5 = string;
            str4 = openWeiyunBuySpaceH5;
            if (!TextUtils.isEmpty(str5)) {
                return;
            }
            new BaseThread(new Runnable(appInterface, str, str2, str3, i3, str4, indexOf, str5) { // from class: com.tencent.mobileqq.weiyun.api.impl.WeiyunGrayTipHelperImpl.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int C;
                final /* synthetic */ String D;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ AppInterface f315126d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f315127e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ String f315128f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ String f315129h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ int f315130i;

                /* renamed from: m, reason: collision with root package name */
                final /* synthetic */ String f315131m;

                {
                    this.f315126d = appInterface;
                    this.f315127e = str;
                    this.f315128f = str2;
                    this.f315129h = str3;
                    this.f315130i = i3;
                    this.f315131m = str4;
                    this.C = indexOf;
                    this.D = str5;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, WeiyunGrayTipHelperImpl.this, appInterface, str, str2, str3, Integer.valueOf(i3), str4, Integer.valueOf(indexOf), str5);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (!(this.f315126d instanceof QQAppInterface)) {
                        return;
                    }
                    Process.setThreadPriority(10);
                    g gVar = new g(this.f315127e, this.f315128f, this.f315129h, this.f315130i, MessageRecord.MSG_TYPE_UNITE_TAB_HISTORI_INVI, 2424833, e.K0());
                    Bundle bundle = new Bundle();
                    bundle.putInt("key_action", 1);
                    bundle.putString("key_action_DATA", this.f315131m);
                    int i17 = this.C;
                    gVar.b(i17, this.D.length() + i17, bundle);
                    MessageForUniteGrayTip messageForUniteGrayTip = new MessageForUniteGrayTip();
                    messageForUniteGrayTip.initGrayTipMsg((QQAppInterface) this.f315126d, gVar);
                    f.a((QQAppInterface) this.f315126d, messageForUniteGrayTip);
                }
            }).start();
        }
    }
}

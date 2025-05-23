package com.tencent.mobileqq.qwallet.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.util.QQToastUtil;
import java.net.URLDecoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\r\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\fH\u0016J\u001c\u0010\u0010\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016R \u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001e\u0010\u001d\u001a\n \u001a*\u0004\u0018\u00010\u00190\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/qwallet/utils/QWalletWxMiniAppLauncher;", "Lcom/tencent/mm/opensdk/openapi/IWXAPIEventHandler;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/net/Uri;", LayoutAttrDefine.CLICK_URI, "", "a", "Lcom/tencent/mm/opensdk/modelbase/BaseReq;", "p0", "onReq", "Lcom/tencent/mm/opensdk/modelbase/BaseResp;", "onResp", "Landroid/content/Intent;", "intent", "onReceive", "Lmqq/util/WeakReference;", "e", "Lmqq/util/WeakReference;", "contextRef", "", "f", "Ljava/lang/String;", "targetWxAppId", "Lcom/tencent/mm/opensdk/openapi/IWXAPI;", "kotlin.jvm.PlatformType", tl.h.F, "Lcom/tencent/mm/opensdk/openapi/IWXAPI;", DTConstants.TAG.API, "<init>", "()V", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QWalletWxMiniAppLauncher extends BroadcastReceiver implements IWXAPIEventHandler {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final QWalletWxMiniAppLauncher f279245d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static WeakReference<Context> contextRef;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String targetWxAppId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static IWXAPI api;

    static {
        QWalletWxMiniAppLauncher qWalletWxMiniAppLauncher = new QWalletWxMiniAppLauncher();
        f279245d = qWalletWxMiniAppLauncher;
        targetWxAppId = "wxf0a80d0ac2e82aa7";
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(MobileQQ.sMobileQQ, "wxf0a80d0ac2e82aa7", true);
        api = createWXAPI;
        try {
            createWXAPI.registerApp("wxf0a80d0ac2e82aa7");
            MobileQQ.sMobileQQ.registerReceiver(qWalletWxMiniAppLauncher, new IntentFilter("com.tencent.mobileqq.action.ACTION_WECHAT_RESPONSE"), "com.tencent.msg.permission.pushnotify", null);
        } catch (Exception e16) {
            QLog.e("QWalletWxMiniAppLauncher", 1, "registerApp error:", e16);
        }
    }

    QWalletWxMiniAppLauncher() {
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(@Nullable Context context, @NotNull Uri uri) {
        int i3;
        String queryParameter;
        boolean z16;
        String queryParameter2;
        String queryParameter3;
        Intrinsics.checkNotNullParameter(uri, "uri");
        boolean z17 = true;
        if (!api.isWXAppInstalled()) {
            QQToastUtil.showQQToast(1, R.string.f170986w14);
            return;
        }
        if (api.getWXAppSupportAPI() < 621086464) {
            QQToastUtil.showQQToast(1, R.string.f170987w15);
            return;
        }
        contextRef = new WeakReference<>(context);
        String queryParameter4 = uri.getQueryParameter(AudienceReportConst.USER_NAME);
        WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
        req.userName = queryParameter4;
        try {
            queryParameter3 = uri.getQueryParameter("app_type");
        } catch (NumberFormatException e16) {
            QLog.e("QWalletWxMiniAppLauncher", 1, e16, new Object[0]);
        }
        if (queryParameter3 != null) {
            i3 = Integer.parseInt(queryParameter3);
            req.miniprogramType = i3;
            queryParameter = uri.getQueryParameter("path");
            if (queryParameter == null && queryParameter.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                try {
                    req.path = URLDecoder.decode(queryParameter, "UTF-8");
                } catch (Throwable th5) {
                    QLog.e("QWalletWxMiniAppLauncher", 1, "decode path error: " + queryParameter, th5);
                }
            }
            queryParameter2 = uri.getQueryParameter("ext");
            if (queryParameter2 != null && queryParameter2.length() != 0) {
                z17 = false;
            }
            if (!z17) {
                req.extData = queryParameter2;
            }
            api.sendReq(req);
        }
        i3 = 0;
        req.miniprogramType = i3;
        queryParameter = uri.getQueryParameter("path");
        if (queryParameter == null) {
        }
        z16 = true;
        if (!z16) {
        }
        queryParameter2 = uri.getQueryParameter("ext");
        if (queryParameter2 != null) {
            z17 = false;
        }
        if (!z17) {
        }
        api.sendReq(req);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        Context context2;
        WeakReference<Context> weakReference = contextRef;
        if (weakReference != null) {
            context2 = weakReference.get();
        } else {
            context2 = null;
        }
        IWXAPI iwxapi = api;
        if (iwxapi != null && context2 != null) {
            iwxapi.handleIntent(intent, this);
        }
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onReq(@Nullable BaseReq p06) {
        QLog.i("QWalletWxMiniAppLauncher", 1, "onReq");
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onResp(@Nullable BaseResp p06) {
        QLog.i("QWalletWxMiniAppLauncher", 1, "onResp");
    }
}

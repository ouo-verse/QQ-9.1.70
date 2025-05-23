package com.tencent.gdtad.adapter;

import android.content.Context;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.statistics.AdReporterForLinkEvent;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.wechat.AdWXCanvas;
import com.tencent.ad.tangram.wechat.AdWXCanvasAdapter;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessView;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtWXCanvasAdapter implements AdWXCanvasAdapter {
    private static void a(AdWXCanvas.Params params, AdError adError) {
        int i3;
        Context context;
        if (params != null && params.reportForLinkEvent) {
            if (adError != null) {
                i3 = adError.getErrorCode();
            } else {
                i3 = 1;
            }
            QLog.i("GdtWXCanvasAdapter", 1, "[reportForLinkEventOnEnd] errorCode:" + i3);
            int[] iArr = new int[0];
            if (i3 == 4) {
                iArr = new int[]{4006003};
            } else if (i3 != 12 && i3 != 14) {
                if (i3 == 151) {
                    iArr = new int[]{4006002, 4006006, 4006009};
                } else if (i3 == 0) {
                    iArr = new int[]{4006002, 4006006, 4006008};
                }
            } else {
                iArr = new int[]{4006002, 4006007};
            }
            for (int i16 : iArr) {
                AdReporterForLinkEvent adReporterForLinkEvent = AdReporterForLinkEvent.getInstance();
                WeakReference<Context> weakReference = params.context;
                if (weakReference != null) {
                    context = weakReference.get();
                } else {
                    context = null;
                }
                adReporterForLinkEvent.reportAsync(context, i16, params.f61349ad, null, null);
            }
            return;
        }
        QLog.i("GdtWXCanvasAdapter", 1, "[reportForLinkEventOnStart] do nothing");
    }

    private static void b(AdWXCanvas.Params params) {
        Context context;
        if (params != null && params.reportForLinkEvent) {
            QLog.i("GdtWXCanvasAdapter", 1, "[reportForLinkEventOnStart]");
            AdReporterForLinkEvent adReporterForLinkEvent = AdReporterForLinkEvent.getInstance();
            WeakReference<Context> weakReference = params.context;
            if (weakReference != null) {
                context = weakReference.get();
            } else {
                context = null;
            }
            adReporterForLinkEvent.reportAsync(context, 4006001, params.f61349ad, null, null);
            return;
        }
        QLog.i("GdtWXCanvasAdapter", 1, "[reportForLinkEventOnStart] do nothing");
    }

    private static AdError c(final AdWXCanvas.Params params) {
        if (params != null && params.isValid()) {
            final Context context = params.context.get();
            AdError a16 = y.a(context, params.channelAppID, 671089408);
            if (a16 == null) {
                a16 = new AdError(1);
            }
            if (!a16.isSuccess()) {
                return a16;
            }
            AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.gdtad.adapter.GdtWXCanvasAdapter.1
                @Override // java.lang.Runnable
                public void run() {
                    IWXAPI iwxapi;
                    boolean z16;
                    try {
                        iwxapi = WXAPIFactory.createWXAPI(context, params.channelAppID);
                    } catch (Throwable th5) {
                        QLog.e("GdtWXCanvasAdapter", 1, "[showImpl] createWXAPI", th5);
                        iwxapi = null;
                    }
                    if (iwxapi == null) {
                        QLog.e("GdtWXCanvasAdapter", 1, "[showImpl] error, api is null");
                        return;
                    }
                    try {
                        WXOpenBusinessView.Req req = new WXOpenBusinessView.Req();
                        req.businessType = "nativeOpenAdCanvas";
                        req.extInfo = params.getExtInfo();
                        z16 = iwxapi.sendReq(req);
                    } catch (Throwable th6) {
                        QLog.e("GdtWXCanvasAdapter", 1, "[showImpl] sendReq", th6);
                        z16 = false;
                    }
                    QLog.i("GdtWXCanvasAdapter", 1, "[showImpl] sendReq:" + z16);
                }
            }, 5);
            return new AdError(0);
        }
        return new AdError(4);
    }

    @Override // com.tencent.ad.tangram.wechat.AdWXCanvasAdapter
    public AdError show(AdWXCanvas.Params params) {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[show] channelAppID:");
        String str2 = null;
        if (params != null) {
            str = params.channelAppID;
        } else {
            str = null;
        }
        sb5.append(str);
        sb5.append(" extInfo:");
        if (params != null) {
            str2 = params.getExtInfo();
        }
        sb5.append(str2);
        QLog.i("GdtWXCanvasAdapter", 1, sb5.toString());
        b(params);
        AdError c16 = c(params);
        a(params, c16);
        return c16;
    }
}

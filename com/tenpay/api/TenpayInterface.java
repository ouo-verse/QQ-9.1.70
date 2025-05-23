package com.tenpay.api;

import android.app.Service;
import android.content.Context;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TenpayInterface extends EnterBase<IApiInterface> {
    public static final int ERR_QWALLET_PLUGIN_SDK_OFFLINE = -7;
    public static final String VIEWTAG_QQ_TRANSFER_PAGE = "qqTransfer";
    public static final String VIEWTAG_REQARDTRANSFER = "rewardTransferInput";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class Ins {
        public static TenpayInterface mins = new TenpayInterface();

        Ins() {
        }
    }

    TenpayInterface() {
    }

    public static void closeTenpay(Context context) {
        IApiInterface logic = getLogic(context, null);
        if (logic == null) {
            return;
        }
        if (context instanceof BasePluginActivity) {
            context = ((BasePluginActivity) context).getOutActivity();
        }
        logic.closeTenpay(context);
    }

    protected static IApiInterface getLogic(Context context, ResultReceiver resultReceiver) {
        IApiInterface logic = instance().getLogic(context);
        if (logic == null && resultReceiver != null) {
            Bundle bundle = new Bundle();
            bundle.putString("retdata", "SDK\u79bb\u7ebf\u5316\u9519\u8bef\uff01");
            resultReceiver.send(-7, bundle);
        }
        return logic;
    }

    public static void gotoPay(Context context, Bundle bundle, ResultReceiver resultReceiver) {
        if (context instanceof BasePluginActivity) {
            context = ((BasePluginActivity) context).getOutActivity();
        }
        IApiInterface logic = getLogic(context, resultReceiver);
        if (logic == null) {
            return;
        }
        logic.gotoPay(context, bundle, resultReceiver);
    }

    public static void gotoView(Context context, String str, String str2, String str3, Bundle bundle, ResultReceiver resultReceiver) {
        IApiInterface logic = getLogic(context, resultReceiver);
        if (logic == null) {
            return;
        }
        if (context instanceof BasePluginActivity) {
            context = ((BasePluginActivity) context).getOutActivity();
        }
        logic.gotoView(context, str, str2, str3, bundle, resultReceiver);
    }

    private static TenpayInterface instance() {
        return Ins.mins;
    }

    public static void preConnect(Context context, String str) {
        if (context instanceof BasePluginActivity) {
            context = ((BasePluginActivity) context).getOutActivity();
        }
        IApiInterface logic = getLogic(context, null);
        if (logic == null) {
            return;
        }
        logic.preConnect(context, str);
    }

    public static void pregetQrcode(Context context, Map<String, String> map, ResultReceiver resultReceiver) {
        if (context instanceof BasePluginActivity) {
            context = ((BasePluginActivity) context).getOutActivity();
        }
        IApiInterface logic = getLogic(context, resultReceiver);
        if (logic == null) {
            return;
        }
        logic.pregetQrcode(context, map, resultReceiver);
    }

    public static void requestData(Context context, String str, String str2, Map<String, String> map, ResultReceiver resultReceiver) {
        IApiInterface logic = getLogic(context, resultReceiver);
        if (logic == null) {
            return;
        }
        logic.requestData(context, str, str2, map, resultReceiver);
    }

    @Override // com.tenpay.api.EnterBase
    protected String enterApi() {
        return IApiInterface.LOGIC;
    }

    public static void gotoView(Context context, String str, String str2, String str3, Bundle bundle, ResultReceiver resultReceiver, Service service) {
        IApiInterface logic = getLogic(context, resultReceiver);
        if (logic == null) {
            return;
        }
        if (context instanceof BasePluginActivity) {
            context = ((BasePluginActivity) context).getOutActivity();
        }
        logic.gotoView(context, str, str2, str3, bundle, resultReceiver, service);
    }
}

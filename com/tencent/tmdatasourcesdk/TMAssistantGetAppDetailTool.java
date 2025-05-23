package com.tencent.tmdatasourcesdk;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.r;
import com.tencent.tmdatasourcesdk.a.a.a;
import com.tencent.tmdatasourcesdk.internal.protocol.jce.AppDetailParam;
import com.tencent.tmdatasourcesdk.internal.protocol.jce.AppSimpleDetail;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TMAssistantGetAppDetailTool implements ITMAssistantExchangeURLListenner {
    static IPatchRedirector $redirector_ = null;
    protected static final String TAG = "TMAssistantDownloadSDKExchangeURL";
    protected static TMAssistantGetAppDetailTool mInstance;
    protected a engine;
    protected ITMAssistantExchangeURLListenner mListener;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10877);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    TMAssistantGetAppDetailTool(ITMAssistantExchangeURLListenner iTMAssistantExchangeURLListenner, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iTMAssistantExchangeURLListenner, (Object) context);
            return;
        }
        this.mListener = null;
        this.engine = null;
        r.b(TAG, "listener = " + iTMAssistantExchangeURLListenner + ",context = " + context);
        if (iTMAssistantExchangeURLListenner != null && context != null) {
            this.mListener = iTMAssistantExchangeURLListenner;
            this.engine = new a(this);
            GlobalUtil.getInstance().setContext(context);
            return;
        }
        r.a(TAG, "ITMAssistantExchangeURLListenner listener shouldn't be null!");
    }

    public static synchronized TMAssistantGetAppDetailTool getInstance(ITMAssistantExchangeURLListenner iTMAssistantExchangeURLListenner, Context context) {
        TMAssistantGetAppDetailTool tMAssistantGetAppDetailTool;
        synchronized (TMAssistantGetAppDetailTool.class) {
            if (mInstance == null) {
                mInstance = new TMAssistantGetAppDetailTool(iTMAssistantExchangeURLListenner, context);
            }
            tMAssistantGetAppDetailTool = mInstance;
        }
        return tMAssistantGetAppDetailTool;
    }

    public void exchangeUrlsFromPackageNames(ArrayList<String> arrayList) {
        Object valueOf;
        a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) arrayList);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("paramStrs size = ");
        if (arrayList == null) {
            valueOf = "null";
        } else {
            valueOf = Integer.valueOf(arrayList.size());
        }
        sb5.append(valueOf);
        r.b(TAG, sb5.toString());
        if (arrayList != null) {
            ArrayList<AppDetailParam> arrayList2 = new ArrayList<>();
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String[] split = it.next().split(";");
                if (split != null && split.length > 0) {
                    AppDetailParam appDetailParam = new AppDetailParam();
                    appDetailParam.packageName = split[0];
                    if (split.length > 1) {
                        appDetailParam.channelId = split[1];
                    }
                    arrayList2.add(appDetailParam);
                }
            }
            if (arrayList2.size() > 0 && (aVar = this.engine) != null) {
                aVar.b(arrayList2);
                return;
            }
            return;
        }
        r.a(TAG, "packageNames is null!");
    }

    @Override // com.tencent.tmdatasourcesdk.ITMAssistantExchangeURLListenner
    public void onExchangedURLSucceed(ArrayList<AppSimpleDetail> arrayList, boolean z16) {
        Object valueOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, arrayList, Boolean.valueOf(z16));
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("appDetails size = ");
        if (arrayList == null) {
            valueOf = "null";
        } else {
            valueOf = Integer.valueOf(arrayList.size());
        }
        sb5.append(valueOf);
        sb5.append(",isSuccess = ");
        sb5.append(z16);
        r.b(TAG, sb5.toString());
        ITMAssistantExchangeURLListenner iTMAssistantExchangeURLListenner = this.mListener;
        if (iTMAssistantExchangeURLListenner != null) {
            iTMAssistantExchangeURLListenner.onExchangedURLSucceed(arrayList, z16);
        } else {
            r.a(TAG, "mListener is null!");
        }
    }
}

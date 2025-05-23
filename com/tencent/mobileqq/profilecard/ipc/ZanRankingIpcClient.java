package com.tencent.mobileqq.profilecard.ipc;

import android.os.Bundle;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.profilecard.data.CardCoverData;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ZanRankingIpcClient extends QIPCModule implements EIPCResultCallback {
    public static final String NAME = "ZanRankingIpcClient";
    public static final String PROCESS_NAME = "com.tencent.mobileqq:tool";
    public static final String SERVER_NAME = "ZanRankingIpcServer";
    public static final String TAG = "ZanRankingIpcClient";
    WeakReference<ICallback> iCallbackRef;
    private volatile boolean inited;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public static class Holder {
        private static ZanRankingIpcClient sInstance = new ZanRankingIpcClient();

        Holder() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public interface ICallback {
        void onGetCardCover(int i3, String str, boolean z16, CardCoverData cardCoverData);
    }

    ZanRankingIpcClient() {
        super("ZanRankingIpcClient");
        this.inited = false;
        this.iCallbackRef = null;
    }

    public static ZanRankingIpcClient getInstance() {
        return Holder.sInstance;
    }

    public void callGetCardCover(int i3, String str, boolean z16) {
        Bundle bundle = new Bundle();
        bundle.putString("action", ZanRankingIpcServer.ACTION_GET_CARD_COVER);
        bundle.putString("uin", str);
        bundle.putBoolean("fromCache", z16);
        bundle.putInt("seq", i3);
        QIPCClientHelper.getInstance().getClient().callServer("ZanRankingIpcServer", ZanRankingIpcServer.ACTION_GET_CARD_COVER, bundle, this);
    }

    public Map<String, String> getFrdNicks(ArrayList<String> arrayList) {
        HashMap hashMap = new HashMap();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("uins", arrayList);
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "ZanRankingIpcServer", ZanRankingIpcServer.ACTION_GET_FRD_NICKS, bundle);
        if (callServer.isSuccess()) {
            Bundle bundle2 = callServer.data;
            ArrayList<String> stringArrayList = bundle2.getStringArrayList("uins");
            ArrayList<String> stringArrayList2 = bundle2.getStringArrayList("nicks");
            for (int i3 = 0; i3 < stringArrayList2.size(); i3++) {
                hashMap.put(stringArrayList.get(i3), stringArrayList2.get(i3));
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("ZanRankingIpcClient", 2, String.format("getFrdNicks suc=%b nicks.size=%d", Boolean.valueOf(callServer.isSuccess()), Integer.valueOf(hashMap.size())));
        }
        return hashMap;
    }

    public synchronized void init() {
        if (this.inited) {
            return;
        }
        try {
            QIPCClientHelper.getInstance().register(getInstance());
            this.inited = true;
            if (QLog.isColorLevel()) {
                QLog.d("ZanRankingIpcClient", 2, "init");
            }
        } catch (Exception e16) {
            QLog.e("ZanRankingIpcClient", 1, "register ipc module error.", e16);
        }
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        if (!QLog.isColorLevel()) {
            return null;
        }
        QLog.d("ZanRankingIpcClient", 2, "onCall, params=" + bundle + ", action=" + str + ", callBackId=" + i3);
        return null;
    }

    @Override // eipc.EIPCResultCallback
    public void onCallback(EIPCResult eIPCResult) {
        Bundle bundle;
        if (eIPCResult == null) {
            return;
        }
        try {
            if (!eIPCResult.isSuccess() || (bundle = eIPCResult.data) == null) {
                return;
            }
            String string = bundle.getString("action", "");
            QLog.d("ZanRankingIpcClient", 1, "onCallback result action= " + string);
            if (string.equals(ZanRankingIpcServer.ACTION_GET_CARD_COVER)) {
                int i3 = bundle.getInt("seq");
                String string2 = bundle.getString("uin");
                boolean z16 = bundle.getBoolean("fromCache");
                CardCoverData cardCoverData = new CardCoverData(bundle.getInt("type"), bundle.getString("text"));
                WeakReference<ICallback> weakReference = this.iCallbackRef;
                ICallback iCallback = weakReference != null ? weakReference.get() : null;
                if (iCallback != null) {
                    iCallback.onGetCardCover(i3, string2, z16, cardCoverData);
                }
            }
        } catch (Exception e16) {
            QLog.e("ZanRankingIpcClient", 1, e16.getMessage(), e16);
        }
    }

    public synchronized void unInit() {
        if (this.inited) {
            try {
                if (QIPCClientHelper.getInstance().getClient() != null) {
                    QIPCClientHelper.getInstance().getClient().unRegisterModule(getInstance());
                    this.inited = false;
                    if (QLog.isColorLevel()) {
                        QLog.d("ZanRankingIpcClient", 2, "unInit");
                    }
                }
            } catch (Exception e16) {
                QLog.e("ZanRankingIpcClient", 1, "unregister ipc module error.", e16);
            }
        }
    }

    public void setCallback(ICallback iCallback) {
        if (iCallback != null) {
            this.iCallbackRef = new WeakReference<>(iCallback);
        }
    }
}

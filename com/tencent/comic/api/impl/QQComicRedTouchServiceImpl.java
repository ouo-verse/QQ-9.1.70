package com.tencent.comic.api.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.comic.api.IQQComicRedTouchService;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.redtouch.RedAppInfo;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.tianshu.data.RedTouchConst;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes32.dex */
public class QQComicRedTouchServiceImpl extends Observable implements IQQComicRedTouchService {
    public static final String TAG = "QQComicRedTouchService";
    AppRuntime mApp;
    BroadcastReceiver mReceiver;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static abstract class PluginRedTouchObserver implements Observer {
        public abstract void a();

        @Override // java.util.Observer
        public final void update(Observable observable, Object obj) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.comic.api.impl.QQComicRedTouchServiceImpl.PluginRedTouchObserver.1
                @Override // java.lang.Runnable
                public void run() {
                    if (QLog.isColorLevel()) {
                        QLog.d(QQComicRedTouchServiceImpl.TAG, 2, "onReceiveNewRedTouch()");
                    }
                    PluginRedTouchObserver.this.a();
                }
            });
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (QLog.isColorLevel()) {
                QLog.d(QQComicRedTouchServiceImpl.TAG, 2, "Received red touch push");
            }
            QQComicRedTouchServiceImpl.super.setChanged();
            QQComicRedTouchServiceImpl.super.notifyObservers();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0053, code lost:
    
        if (r9 == r12.length) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0066  */
    @Override // com.tencent.comic.api.IQQComicRedTouchService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String convertString(String str, int i3) {
        int i16;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        StringBuilder obtainStringBuilder = QQDcReporterImpl.obtainStringBuilder();
        if (i3 != 0) {
            i16 = i3 == 1 ? -100000000 : 100000000;
            return null;
        }
        obtainStringBuilder.append(BusinessInfoCheckUpdateItem.UIAPPID_LEBA_MORE);
        obtainStringBuilder.append('.');
        boolean z16 = false;
        if (str.contains(".")) {
            String[] split = str.split("\\.");
            if (split.length > 0) {
                int i17 = 0;
                for (String str2 : split) {
                    try {
                        obtainStringBuilder.append(Integer.parseInt(str2) + i16);
                        obtainStringBuilder.append('.');
                        i17++;
                    } catch (NumberFormatException e16) {
                        e16.printStackTrace();
                    }
                }
            }
            if (z16) {
                if (obtainStringBuilder.length() > 0 && obtainStringBuilder.charAt(obtainStringBuilder.length() - 1) == '.') {
                    obtainStringBuilder.deleteCharAt(obtainStringBuilder.length() - 1);
                }
                if (i3 == 1) {
                    int indexOf = obtainStringBuilder.indexOf(".");
                    if (indexOf < 0) {
                        return null;
                    }
                    return obtainStringBuilder.substring(indexOf + 1);
                }
                return obtainStringBuilder.toString();
            }
            return null;
        }
        try {
            obtainStringBuilder.append(Integer.parseInt(str) + i16);
        } catch (NumberFormatException e17) {
            e17.printStackTrace();
        }
        z16 = true;
        if (z16) {
        }
        return null;
    }

    @Override // com.tencent.comic.api.IQQComicRedTouchService
    public boolean isLebaItemOpen(int i3) {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        bundle2.putInt("appId", i3);
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "QQComicIPCModule", "isLebaItemOpen", bundle2);
        if (callServer == null || callServer.code != 0 || (bundle = callServer.data) == null) {
            return false;
        }
        return bundle.getBoolean("isLebaItemOpen", false);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.mApp = appRuntime;
        this.mReceiver = new a();
        this.mApp.getApplicationContext().registerReceiver(this.mReceiver, new IntentFilter(RedTouchConst.Action.PUSH_ACTION_FOR_AV));
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        super.deleteObservers();
        try {
            this.mApp.getApplicationContext().unregisterReceiver(this.mReceiver);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        this.mApp = null;
    }

    @Override // com.tencent.comic.api.IQQComicRedTouchService
    public void reportRedTouchClick(String str) {
        if (str == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("path", str);
        BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "QQComicIPCModule", "reportRedTouchClick", bundle);
    }

    @Override // com.tencent.comic.api.IQQComicRedTouchService
    public Map<String, Object> getRedAppInfo(ArrayList<String> arrayList) {
        Bundle bundle;
        HashMap hashMap = null;
        if (arrayList == null) {
            return null;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putStringArrayList("pathList", arrayList);
        EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "QQComicIPCModule", "getRedTouchInfo", bundle2);
        if (callServer != null && callServer.code == 0 && (bundle = callServer.data) != null) {
            bundle.setClassLoader(RedAppInfo.class.getClassLoader());
            ArrayList<RedAppInfo> parcelableArrayList = bundle.getParcelableArrayList("redTouchInfoList");
            if (parcelableArrayList != null) {
                hashMap = new HashMap();
                for (RedAppInfo redAppInfo : parcelableArrayList) {
                    hashMap.put(redAppInfo.C(), redAppInfo);
                }
            }
        }
        return hashMap;
    }
}

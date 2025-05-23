package com.tencent.tmassistant;

import android.content.Context;
import com.tencent.assistant.sdk.remote.SDKConst;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.l;
import com.tencent.tmassistantsdk.a.b.b;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import com.tencent.tmdownloader.c;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TMAssistantDownloadSDKManager {

    /* renamed from: b, reason: collision with root package name */
    protected static TMAssistantDownloadSDKManager f380358b;

    /* renamed from: c, reason: collision with root package name */
    protected static ArrayList<TMAssistantDownloadClient> f380359c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    protected static ArrayList<b> f380360d = new ArrayList<>();

    /* renamed from: a, reason: collision with root package name */
    protected Context f380361a;

    protected TMAssistantDownloadSDKManager(Context context) {
        this.f380361a = context;
    }

    public static synchronized TMAssistantDownloadSDKManager a(Context context) {
        TMAssistantDownloadSDKManager tMAssistantDownloadSDKManager;
        synchronized (TMAssistantDownloadSDKManager.class) {
            if (f380358b == null) {
                f380358b = new TMAssistantDownloadSDKManager(context);
                if (!l.e()) {
                    if (GlobalUtil.getInstance().getContext() == null) {
                        GlobalUtil.getInstance().setContext(context);
                    }
                    c.a();
                }
            }
            tMAssistantDownloadSDKManager = f380358b;
        }
        return tMAssistantDownloadSDKManager;
    }

    public synchronized boolean b(String str) {
        Iterator<TMAssistantDownloadClient> it = f380359c.iterator();
        while (it.hasNext()) {
            TMAssistantDownloadClient next = it.next();
            if (next != null && next.mClientKey.equals(str)) {
                next.unInitTMAssistantDownloadSDK();
                it.remove();
                return true;
            }
        }
        return false;
    }

    public synchronized b a(String str) {
        Iterator<b> it = f380360d.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (next.mClientKey.equals(str)) {
                return next;
            }
        }
        b bVar = new b(this.f380361a, str, SDKConst.SERVICE_NAME);
        if (!bVar.initTMAssistantDownloadSDK()) {
            return null;
        }
        f380360d.add(bVar);
        return bVar;
    }
}

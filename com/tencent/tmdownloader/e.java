package com.tencent.tmdownloader;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.BatchSDKDownloadActionResponse;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.IPCSDKDownloadInfo;
import com.tencent.tmassistantsdk.internal.openSDK.param.jce.SubScribeSDKDownloadTaskByViaResponse;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes26.dex */
public class e implements ITMAssistantDownloadClientListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private List<TMAssistantDownloadTaskInfo> f380625a;

    /* renamed from: b, reason: collision with root package name */
    private List<String> f380626b;

    /* renamed from: c, reason: collision with root package name */
    private TMAssistantDownloadClient f380627c;

    /* renamed from: d, reason: collision with root package name */
    protected ReferenceQueue<b> f380628d;

    /* renamed from: e, reason: collision with root package name */
    protected ArrayList<WeakReference<b>> f380629e;

    /* renamed from: f, reason: collision with root package name */
    private Context f380630f;

    /* renamed from: g, reason: collision with root package name */
    private String f380631g;

    public e(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) str);
            return;
        }
        this.f380625a = new ArrayList();
        this.f380626b = new ArrayList();
        this.f380630f = context;
        this.f380631g = str;
        if (context != null) {
            a();
        }
        this.f380628d = new ReferenceQueue<>();
        this.f380629e = new ArrayList<>();
    }

    private void a() {
        if (this.f380627c != null) {
            return;
        }
        TMAssistantDownloadClient tMAssistantDownloadClient = new TMAssistantDownloadClient(this.f380630f, this.f380631g);
        this.f380627c = tMAssistantDownloadClient;
        if (tMAssistantDownloadClient.initTMAssistantDownloadSDK()) {
            Objects.toString(this.f380627c);
            this.f380627c.registerDownloadTaskListener(this);
        } else {
            this.f380627c = null;
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        TMAssistantDownloadClient tMAssistantDownloadClient = this.f380627c;
        if (tMAssistantDownloadClient != null) {
            tMAssistantDownloadClient.unInitTMAssistantDownloadSDK();
            this.f380627c = null;
        }
    }

    public synchronized List<TMAssistantDownloadTaskInfo> c(List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this, (Object) list);
        }
        if (list == null) {
            return this.f380625a;
        }
        this.f380626b.clear();
        this.f380626b.addAll(list);
        this.f380625a.clear();
        Iterator<String> it = this.f380626b.iterator();
        while (it.hasNext()) {
            List<TMAssistantDownloadTaskInfo> downloadTaskInfosByVia = this.f380627c.getDownloadTaskInfosByVia(it.next());
            if (downloadTaskInfosByVia != null) {
                this.f380625a.addAll(downloadTaskInfosByVia);
            }
        }
        b(this.f380625a);
        return this.f380625a;
    }

    @Override // com.tencent.tmdownloader.ITMAssistantDownloadClientListener
    public void onDownloadSDKTaskProgressChanged(TMAssistantDownloadClient tMAssistantDownloadClient, String str, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, tMAssistantDownloadClient, str, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        TMAssistantDownloadTaskInfo a16 = a(str);
        if (a16 != null) {
            a16.mReceiveDataLen = j3;
            a16.mTotalDataLen = j16;
            b(a16);
            return;
        }
        try {
            TMAssistantDownloadTaskInfo downloadTaskState = this.f380627c.getDownloadTaskState(str);
            if (downloadTaskState != null) {
                b(downloadTaskState);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.tmdownloader.ITMAssistantDownloadClientListener
    public void onDownloadSDKTaskStateChanged(TMAssistantDownloadClient tMAssistantDownloadClient, String str, int i3, int i16, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, tMAssistantDownloadClient, str, Integer.valueOf(i3), Integer.valueOf(i16), str2);
            return;
        }
        TMAssistantDownloadTaskInfo a16 = a(str);
        if (a16 != null) {
            a16.mState = i3;
            b(a16);
            return;
        }
        try {
            TMAssistantDownloadTaskInfo downloadTaskState = this.f380627c.getDownloadTaskState(str);
            if (downloadTaskState != null) {
                b(downloadTaskState);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.tmdownloader.ITMAssistantDownloadClientListener
    public void onDwonloadSDKServiceInvalid(TMAssistantDownloadClient tMAssistantDownloadClient) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) tMAssistantDownloadClient);
            return;
        }
        Iterator<WeakReference<b>> it = this.f380629e.iterator();
        while (it.hasNext()) {
            b bVar = it.next().get();
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    private void b(TMAssistantDownloadTaskInfo tMAssistantDownloadTaskInfo) {
        if (tMAssistantDownloadTaskInfo == null) {
            return;
        }
        Iterator<WeakReference<b>> it = this.f380629e.iterator();
        while (it.hasNext()) {
            b bVar = it.next().get();
            if (bVar != null) {
                bVar.a(tMAssistantDownloadTaskInfo);
            }
        }
    }

    private void b(List<TMAssistantDownloadTaskInfo> list) {
        if (list == null) {
            return;
        }
        Iterator<WeakReference<b>> it = this.f380629e.iterator();
        while (it.hasNext()) {
            b bVar = it.next().get();
            if (bVar != null) {
                bVar.a(this.f380626b, list);
            }
        }
    }

    public synchronized boolean a(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar)).booleanValue();
        }
        if (bVar == null) {
            return false;
        }
        while (true) {
            Reference<? extends b> poll = this.f380628d.poll();
            if (poll == null) {
                break;
            }
            this.f380629e.remove(poll);
        }
        Iterator<WeakReference<b>> it = this.f380629e.iterator();
        while (it.hasNext()) {
            if (it.next().get() == bVar) {
                return true;
            }
        }
        this.f380629e.add(new WeakReference<>(bVar, this.f380628d));
        return true;
    }

    private boolean b(String str) {
        try {
            Intent launchIntentForPackage = InstalledAppListMonitor.getLaunchIntentForPackage(this.f380630f.getPackageManager(), str);
            if (launchIntentForPackage == null && InstalledAppListMonitor.getPackageInfo(this.f380630f.getPackageManager(), str, 1) != null) {
                launchIntentForPackage = new Intent(str);
            }
            if (launchIntentForPackage == null) {
                return false;
            }
            launchIntentForPackage.setFlags(268435456);
            this.f380630f.startActivity(launchIntentForPackage);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public synchronized void a(List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) list);
            return;
        }
        if (list != null && list.size() != 0) {
            this.f380626b.removeAll(list);
            ArrayList arrayList = new ArrayList();
            for (TMAssistantDownloadTaskInfo tMAssistantDownloadTaskInfo : this.f380625a) {
                if (list.contains(tMAssistantDownloadTaskInfo.mVia)) {
                    arrayList.add(tMAssistantDownloadTaskInfo);
                }
            }
            this.f380625a.removeAll(arrayList);
        }
    }

    public void a(SubScribeSDKDownloadTaskByViaResponse subScribeSDKDownloadTaskByViaResponse) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) subScribeSDKDownloadTaskByViaResponse);
            return;
        }
        if (this.f380627c == null) {
            a();
        }
        if (subScribeSDKDownloadTaskByViaResponse.subscribeType == 1) {
            c(subScribeSDKDownloadTaskByViaResponse.viaList);
        } else {
            a(subScribeSDKDownloadTaskByViaResponse.viaList);
        }
    }

    public synchronized void a(BatchSDKDownloadActionResponse batchSDKDownloadActionResponse) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) batchSDKDownloadActionResponse);
            return;
        }
        if (this.f380627c == null) {
            a();
        }
        Objects.toString(this.f380627c);
        if (batchSDKDownloadActionResponse == null) {
            return;
        }
        switch (batchSDKDownloadActionResponse.batchRequestType) {
            case 1:
                Iterator<IPCSDKDownloadInfo> it = batchSDKDownloadActionResponse.batchData.iterator();
                while (it.hasNext()) {
                    IPCSDKDownloadInfo next = it.next();
                    String str = next.url;
                    this.f380627c.startDownloadTask(next.url, "application/vnd.android.package-archive", new HashMap());
                }
                break;
            case 2:
                Iterator<IPCSDKDownloadInfo> it5 = batchSDKDownloadActionResponse.batchData.iterator();
                while (it5.hasNext()) {
                    this.f380627c.pauseDownloadTask(it5.next().url);
                }
                break;
            case 3:
                Iterator<IPCSDKDownloadInfo> it6 = batchSDKDownloadActionResponse.batchData.iterator();
                while (it6.hasNext()) {
                    this.f380627c.cancelDownloadTask(it6.next().url);
                }
                break;
            case 4:
                Iterator<IPCSDKDownloadInfo> it7 = batchSDKDownloadActionResponse.batchData.iterator();
                while (it7.hasNext()) {
                    this.f380627c.deleteDownloadTask(it7.next().url);
                }
                break;
            case 5:
                Iterator<IPCSDKDownloadInfo> it8 = batchSDKDownloadActionResponse.batchData.iterator();
                while (it8.hasNext()) {
                    IPCSDKDownloadInfo next2 = it8.next();
                    String str2 = next2.packageName;
                    a(this.f380627c.getDownloadTaskState(next2.url));
                }
                break;
            case 6:
                Iterator<IPCSDKDownloadInfo> it9 = batchSDKDownloadActionResponse.batchData.iterator();
                while (it9.hasNext()) {
                    IPCSDKDownloadInfo next3 = it9.next();
                    if (!TextUtils.isEmpty(next3.packageName)) {
                        b(next3.packageName);
                    }
                }
                break;
        }
    }

    private TMAssistantDownloadTaskInfo a(String str) {
        if (str != null && this.f380625a.size() != 0) {
            for (TMAssistantDownloadTaskInfo tMAssistantDownloadTaskInfo : this.f380625a) {
                if (str.equals(tMAssistantDownloadTaskInfo.mUrl)) {
                    return tMAssistantDownloadTaskInfo;
                }
            }
        }
        return null;
    }

    private void a(TMAssistantDownloadTaskInfo tMAssistantDownloadTaskInfo) {
        if (tMAssistantDownloadTaskInfo == null || tMAssistantDownloadTaskInfo.mState != 4 || TextUtils.isEmpty(tMAssistantDownloadTaskInfo.mSavePath)) {
            return;
        }
        com.tencent.tmdownloader.internal.downloadservice.a.b(tMAssistantDownloadTaskInfo.mSavePath);
    }
}

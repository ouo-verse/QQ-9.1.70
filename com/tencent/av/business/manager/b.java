package com.tencent.av.business.manager;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.pendant.EffectPendantTools;
import com.tencent.av.business.manager.pendant.d;
import com.tencent.av.business.manager.report.VideoNodeReporter;
import com.tencent.av.screenshare.ScreenShareManager;
import com.tencent.avcore.util.AVCoreLog;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<VideoAppInterface> f73318b;

    /* renamed from: a, reason: collision with root package name */
    private Object f73317a = new Object();

    /* renamed from: c, reason: collision with root package name */
    private a[] f73319c = new a[20];

    public b(VideoAppInterface videoAppInterface) {
        this.f73318b = new WeakReference<>(videoAppInterface);
        b(4);
        b(5);
        b(12);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected a a(VideoAppInterface videoAppInterface, int i3) {
        a aVar;
        a aVar2;
        long currentTimeMillis = System.currentTimeMillis();
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            if (i3 != 18) {
                                if (i3 != 19) {
                                    switch (i3) {
                                        case 11:
                                            aVar = new ju.a(videoAppInterface);
                                            break;
                                        case 12:
                                            aVar = new EffectMutexManager(videoAppInterface);
                                            break;
                                        case 13:
                                            aVar = new gu.a(videoAppInterface);
                                            break;
                                        case 14:
                                            aVar = new d(videoAppInterface);
                                            break;
                                        case 15:
                                            aVar = new hu.a(videoAppInterface);
                                            break;
                                        default:
                                            AVCoreLog.printColorLog("BusinessManagerFactory", "error-->create Manager unknown name :" + i3);
                                            aVar2 = null;
                                            break;
                                    }
                                    if (aVar2 != null) {
                                        aVar2.g();
                                    }
                                    AVCoreLog.printColorLog("BusinessManagerFactory", "create Manager,cost time:" + (System.currentTimeMillis() - currentTimeMillis));
                                    return aVar2;
                                }
                                aVar = new ku.b(videoAppInterface);
                            } else {
                                aVar = new ScreenShareManager(videoAppInterface);
                            }
                        } else {
                            aVar = new com.tencent.av.business.manager.support.a(videoAppInterface);
                        }
                    } else {
                        aVar = new VideoNodeReporter(videoAppInterface);
                    }
                } else {
                    aVar = new com.tencent.av.business.manager.magicface.a(videoAppInterface);
                }
            } else {
                aVar = new EffectPendantTools(videoAppInterface);
            }
        } else {
            aVar = new fu.a(videoAppInterface);
        }
        aVar2 = aVar;
        if (aVar2 != null) {
        }
        AVCoreLog.printColorLog("BusinessManagerFactory", "create Manager,cost time:" + (System.currentTimeMillis() - currentTimeMillis));
        return aVar2;
    }

    public a b(int i3) {
        a aVar;
        WeakReference<VideoAppInterface> weakReference;
        a aVar2 = this.f73319c[i3];
        if (aVar2 != null) {
            return aVar2;
        }
        synchronized (this.f73317a) {
            aVar = this.f73319c[i3];
            if (aVar == null && (weakReference = this.f73318b) != null && weakReference.get() != null && (aVar = a(this.f73318b.get(), i3)) != null) {
                this.f73319c[i3] = aVar;
            }
        }
        return aVar;
    }

    public boolean c(int i3) {
        if (i3 < 0 || i3 >= 20 || this.f73319c[i3] == null) {
            return false;
        }
        return true;
    }

    public void d(int i3, String str) {
        WeakReference<VideoAppInterface> weakReference;
        if (i3 >= 0 && i3 < 20 && (weakReference = this.f73318b) != null && weakReference.get() != null && !a.f("BusinessManagerFactory", this.f73318b.get(), i3) && b(i3).i(str)) {
            a.k("BusinessManagerFactory", this.f73318b.get().getApplication(), i3, true);
        }
    }
}

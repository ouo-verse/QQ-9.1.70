package com.tencent.superplayer.datatransport;

import com.tencent.thumbplayer.core.datatransport.aidl.TPDataTransportMessageInfo;
import com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportCommonInfoListener;
import com.tencent.thumbplayer.core.datatransport.api.TPDataTransportMgr;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadListener;
import com.tencent.thumbplayer.core.downloadproxy.apiinner.TPListenerManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final List<com.tencent.superplayer.datatransport.a> f373914a;

    /* compiled from: P */
    /* renamed from: com.tencent.superplayer.datatransport.b$b, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    private class C9871b implements ITPDownloadListener, ITPDataTransportCommonInfoListener {
        C9871b() {
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadListener
        public void deleteCacheFinished(String str) {
            synchronized (this) {
                Iterator it = b.this.f373914a.iterator();
                while (it.hasNext()) {
                    ((com.tencent.superplayer.datatransport.a) it.next()).deleteCacheFinished(str);
                }
            }
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadListener
        public void didReleaseMemory(String str) {
            synchronized (this) {
                Iterator it = b.this.f373914a.iterator();
                while (it.hasNext()) {
                    ((com.tencent.superplayer.datatransport.a) it.next()).didReleaseMemory(str);
                }
            }
        }

        @Override // com.tencent.thumbplayer.core.datatransport.api.ITPDataTransportCommonInfoListener
        public void onCommonInfoUpdate(int i3, TPDataTransportMessageInfo tPDataTransportMessageInfo) {
            if (i3 == 1) {
                onQuicQualityReportUpdate((String) tPDataTransportMessageInfo.obj1);
            } else if (i3 == 2) {
                willReleaseMemory((String) tPDataTransportMessageInfo.obj1);
            } else if (i3 == 3) {
                didReleaseMemory((String) tPDataTransportMessageInfo.obj1);
            }
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadListener
        public void onDownloadInfoReportUpdate(String str) {
            synchronized (this) {
                Iterator it = b.this.f373914a.iterator();
                while (it.hasNext()) {
                    ((com.tencent.superplayer.datatransport.a) it.next()).onDownloadInfoReportUpdate(str);
                }
            }
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadListener
        public void onQuicQualityReportUpdate(String str) {
            synchronized (this) {
                Iterator it = b.this.f373914a.iterator();
                while (it.hasNext()) {
                    ((com.tencent.superplayer.datatransport.a) it.next()).onQuicQualityReportUpdate(str);
                }
            }
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadListener
        public void willReleaseMemory(String str) {
            synchronized (this) {
                Iterator it = b.this.f373914a.iterator();
                while (it.hasNext()) {
                    ((com.tencent.superplayer.datatransport.a) it.next()).willReleaseMemory(str);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    private static class c {

        /* renamed from: a, reason: collision with root package name */
        private static final b f373916a = new b();
    }

    public static b c() {
        return c.f373916a;
    }

    public void b(com.tencent.superplayer.datatransport.a aVar) {
        synchronized (this) {
            if (!this.f373914a.contains(aVar)) {
                this.f373914a.add(aVar);
            }
        }
    }

    b() {
        this.f373914a = new ArrayList();
        TPListenerManager.getInstance().setDownloadListener(new C9871b());
        TPDataTransportMgr.registerCommonInfoListener(new C9871b());
    }
}

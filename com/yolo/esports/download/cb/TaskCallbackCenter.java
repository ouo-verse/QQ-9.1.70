package com.yolo.esports.download.cb;

import android.text.TextUtils;
import com.tencent.timi.game.utils.l;
import com.tencent.timi.game.utils.w;
import com.yolo.esports.download.common.DownloadInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class TaskCallbackCenter {

    /* renamed from: d, reason: collision with root package name */
    private static volatile TaskCallbackCenter f390002d;

    /* renamed from: a, reason: collision with root package name */
    private Map<String, LinkedList<a>> f390003a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private LinkedList<a> f390004b = new LinkedList<>();

    /* renamed from: c, reason: collision with root package name */
    private final Object f390005c = new Object();

    TaskCallbackCenter() {
    }

    public static TaskCallbackCenter f() {
        if (f390002d == null) {
            synchronized (TaskCallbackCenter.class) {
                if (f390002d == null) {
                    f390002d = new TaskCallbackCenter();
                }
            }
        }
        return f390002d;
    }

    private List<a> g(String str) {
        LinkedList linkedList = new LinkedList();
        synchronized (this.f390005c) {
            LinkedList<a> linkedList2 = this.f390003a.get(str);
            if (linkedList2 != null && linkedList2.size() > 0) {
                linkedList.addAll(linkedList2);
            }
            linkedList.addAll(this.f390004b);
        }
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(String str, DownloadInfo downloadInfo) {
        List<a> g16 = g(str);
        if (g16.size() == 0) {
            return;
        }
        for (a aVar : g16) {
            if (aVar != null) {
                try {
                    aVar.b(downloadInfo);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str, DownloadInfo downloadInfo) {
        List<a> g16 = g(str);
        if (g16.size() == 0) {
            return;
        }
        for (a aVar : g16) {
            if (aVar != null) {
                try {
                    aVar.a(downloadInfo);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(String str, DownloadInfo downloadInfo) {
        List<a> g16 = g(str);
        if (g16.size() == 0) {
            return;
        }
        for (a aVar : g16) {
            if (aVar != null) {
                try {
                    aVar.c(downloadInfo);
                } catch (Exception unused) {
                }
            }
        }
    }

    public void d(a aVar) {
        if (aVar == null) {
            return;
        }
        synchronized (this.f390005c) {
            Iterator it = new ArrayList(this.f390004b).iterator();
            while (it.hasNext()) {
                a aVar2 = (a) it.next();
                if (aVar2 != null && aVar2 == aVar) {
                    l.i("TaskCallbackCenter", "[addListener(TaskListener listener)]listener" + aVar + "\u5df2\u7ecf\u88ab\u6dfb\u52a0\u8fc7\u4e86\uff0c\u653e\u5f03\u672c\u6b21\u6dfb\u52a0\u52a8\u4f5c");
                    return;
                }
            }
            this.f390004b.add(aVar);
        }
    }

    public void e(String str, a aVar) {
        if (!TextUtils.isEmpty(str) && aVar != null) {
            synchronized (this.f390005c) {
                n(aVar);
                LinkedList<a> linkedList = this.f390003a.get(str);
                if (linkedList == null) {
                    linkedList = new LinkedList<>();
                }
                Iterator<a> it = linkedList.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next != null && next == aVar) {
                        l.i("TaskCallbackCenter", "[addListener(String ticket, TaskListener listener)]listener" + aVar + "\u5df2\u7ecf\u88ab\u6dfb\u52a0\u8fc7\u4e86\uff0c\u653e\u5f03\u672c\u6b21\u6dfb\u52a0\u52a8\u4f5c");
                        return;
                    }
                }
                linkedList.add(aVar);
                this.f390003a.put(str, linkedList);
            }
        }
    }

    public void h(final String str, final DownloadInfo downloadInfo) {
        l.i("TaskCallbackCenter", "onTaskProgressChanged:" + downloadInfo);
        w.a(new Runnable() { // from class: com.yolo.esports.download.cb.TaskCallbackCenter.3
            @Override // java.lang.Runnable
            public void run() {
                TaskCallbackCenter.this.i(str, downloadInfo);
            }
        });
    }

    public void j(final String str, final DownloadInfo downloadInfo) {
        l.i("TaskCallbackCenter", "onTaskStart:" + downloadInfo);
        w.a(new Runnable() { // from class: com.yolo.esports.download.cb.TaskCallbackCenter.2
            @Override // java.lang.Runnable
            public void run() {
                TaskCallbackCenter.this.k(str, downloadInfo);
            }
        });
    }

    public void l(final String str, final DownloadInfo downloadInfo) {
        l.i("TaskCallbackCenter", "onTaskStateChanged:" + downloadInfo);
        w.a(new Runnable() { // from class: com.yolo.esports.download.cb.TaskCallbackCenter.1
            @Override // java.lang.Runnable
            public void run() {
                TaskCallbackCenter.this.m(str, downloadInfo);
            }
        });
    }

    public void n(a aVar) {
        synchronized (this.f390005c) {
            Iterator<Map.Entry<String, LinkedList<a>>> it = this.f390003a.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().remove(aVar);
            }
        }
    }

    public void o(a aVar) {
        synchronized (this.f390005c) {
            this.f390004b.remove(aVar);
        }
    }
}

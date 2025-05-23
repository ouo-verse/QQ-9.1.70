package com.tencent.av.qavperf.manager;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qqperf.tools.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public class QAVPCpuManager implements Handler.Callback {
    protected long C;

    /* renamed from: e, reason: collision with root package name */
    private SessionInfo f74209e;

    /* renamed from: m, reason: collision with root package name */
    protected long f74213m;

    /* renamed from: d, reason: collision with root package name */
    private Status f74208d = Status.IDLE;

    /* renamed from: f, reason: collision with root package name */
    private final List<Integer> f74210f = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private final List<Integer> f74211h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    private final Handler f74212i = new Handler(d.a(), this);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public enum Status {
        IDLE,
        RUNNING
    }

    public QAVPCpuManager(VideoAppInterface videoAppInterface) {
    }

    private void b(SessionInfo sessionInfo) {
        xv.a.f(new Runnable() { // from class: com.tencent.av.qavperf.manager.a
            @Override // java.lang.Runnable
            public final void run() {
                QAVPCpuManager.this.f();
            }
        });
    }

    private void c() {
        if (e()) {
            this.f74212i.sendEmptyMessageDelayed(17, 10000L);
        }
    }

    private void d(List<Integer> list, int i3) {
        if (i3 <= 100) {
            list.add(Integer.valueOf(i3));
        }
    }

    private boolean e() {
        if (this.f74208d == Status.RUNNING && this.f74210f.size() + this.f74211h.size() < 720) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        int size = this.f74210f.size();
        int size2 = this.f74211h.size();
        if (size <= 0 && size2 <= 0) {
            xv.a.g(51, 1, null);
            return;
        }
        HashMap hashMap = new HashMap();
        int i3 = 0;
        if (size2 > 0) {
            int i16 = 0;
            while (i3 < size2) {
                i16 = (int) (i16 + this.f74211h.get(i3).intValue());
                i3++;
            }
            hashMap.put("video_cpu_avg", String.valueOf(i16 / size2));
        } else {
            int i17 = 0;
            while (i3 < size) {
                i17 = (int) (i17 + this.f74210f.get(i3).intValue());
                i3++;
            }
            hashMap.put("audio_cpu_avg", String.valueOf(i17 / size));
        }
        xv.a.g(51, 2, hashMap);
        h();
    }

    private void g() {
        char c16;
        if (e()) {
            try {
                this.C = this.f74213m;
                long a16 = f.a("-1");
                this.f74213m = a16;
                if (a16 != -1) {
                    long j3 = this.C;
                    if (j3 != 0) {
                        int i3 = (int) (((a16 - j3) * 100) / 10000);
                        String a17 = vv.d.a(this.f74209e);
                        switch (a17.hashCode()) {
                            case -143225276:
                                if (a17.equals("local_video_only")) {
                                    c16 = 1;
                                    break;
                                }
                                c16 = '\uffff';
                                break;
                            case 93166550:
                                if (a17.equals("audio")) {
                                    c16 = 3;
                                    break;
                                }
                                c16 = '\uffff';
                                break;
                            case 112202875:
                                if (a17.equals("video")) {
                                    c16 = 0;
                                    break;
                                }
                                c16 = '\uffff';
                                break;
                            case 413855369:
                                if (a17.equals("remote_video_only")) {
                                    c16 = 2;
                                    break;
                                }
                                c16 = '\uffff';
                                break;
                            default:
                                c16 = '\uffff';
                                break;
                        }
                        if (c16 != 0 && c16 != 1 && c16 != 2) {
                            if (c16 == 3) {
                                d(this.f74210f, i3);
                                return;
                            }
                            return;
                        }
                        d(this.f74211h, i3);
                        return;
                    }
                    return;
                }
                throw new RuntimeException("cpu permission denied");
            } catch (Throwable th5) {
                Handler handler = this.f74212i;
                if (handler != null) {
                    handler.removeMessages(17);
                }
                vv.c.b("get cpu value fail:" + th5.getMessage());
            }
        }
    }

    private void h() {
        this.C = 0L;
        this.f74213m = 0L;
        this.f74211h.clear();
        this.f74210f.clear();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        if (message.what == 17) {
            g();
            c();
            return true;
        }
        return true;
    }

    public void i(SessionInfo sessionInfo) {
        Status status = this.f74208d;
        Status status2 = Status.RUNNING;
        if (status == status2) {
            return;
        }
        this.f74209e = sessionInfo;
        this.f74208d = status2;
        g();
        c();
        vv.c.a("start record cpu");
    }

    public void j(SessionInfo sessionInfo) {
        Status status = this.f74208d;
        Status status2 = Status.IDLE;
        if (status == status2) {
            return;
        }
        this.f74208d = status2;
        Handler handler = this.f74212i;
        if (handler != null) {
            handler.removeMessages(17);
        }
        b(sessionInfo);
        vv.c.a("finish record cpu");
    }
}

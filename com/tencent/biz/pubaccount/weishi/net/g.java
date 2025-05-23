package com.tencent.biz.pubaccount.weishi.net;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.util.x;
import common.config.service.QzoneConfig;
import cooperation.qzone.statistic.Singleton;

/* compiled from: P */
@Deprecated
/* loaded from: classes32.dex */
public class g implements Handler.Callback {

    /* renamed from: e, reason: collision with root package name */
    private static final Singleton<g, Void> f80969e = new a();

    /* renamed from: f, reason: collision with root package name */
    private static String f80970f = null;

    /* renamed from: d, reason: collision with root package name */
    public Handler f80971d;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a extends Singleton<g, Void> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // cooperation.qzone.statistic.Singleton
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public g create(Void r16) {
            return new g();
        }
    }

    public static g b() {
        return f80969e.get(null);
    }

    public void a(l lVar) {
        if (this.f80971d == null) {
            this.f80971d = new Handler(Looper.getMainLooper(), this);
        }
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = lVar;
        this.f80971d.sendMessage(obtain);
    }

    public void c(Runnable runnable, long j3) {
        if (this.f80971d == null) {
            this.f80971d = new Handler(Looper.getMainLooper(), this);
        }
        this.f80971d.postDelayed(runnable, j3);
    }

    public void d(Runnable runnable) {
        if (this.f80971d == null) {
            this.f80971d = new Handler(Looper.getMainLooper(), this);
        }
        this.f80971d.post(runnable);
    }

    public void e(Runnable runnable) {
        Handler handler = this.f80971d;
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
    }

    public void g(l lVar) {
        if (this.f80971d == null) {
            this.f80971d = new Handler(Looper.getMainLooper(), this);
        }
        Message obtain = Message.obtain();
        obtain.what = 0;
        obtain.obj = lVar;
        this.f80971d.sendMessage(obtain);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        l lVar;
        if (message == null) {
            x.f("weishi-BusinessLooper", "WeishiBusinessLooper handleMessage, msg is null");
            return true;
        }
        int i3 = message.what;
        String str = "mRequest is null";
        if (i3 == 0) {
            l lVar2 = (l) message.obj;
            if (lVar2 == null) {
                return false;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("runTask cmd=");
            j jVar = lVar2.f80994g;
            if (jVar != null) {
                str = jVar.getCmdString();
            }
            sb5.append(str);
            x.i("weishi-BusinessLooper", sb5.toString());
            lVar2.c();
            return false;
        }
        if (i3 != 1 || (lVar = (l) message.obj) == null) {
            return false;
        }
        StringBuilder sb6 = new StringBuilder();
        sb6.append("completeTask resultCode:");
        sb6.append(lVar.f80992e);
        sb6.append(", cmd=");
        j jVar2 = lVar.f80994g;
        if (jVar2 != null) {
            str = jVar2.getCmdString();
        }
        sb6.append(str);
        x.l("weishi-BusinessLooper", sb6.toString());
        if (lVar.f80989b == null) {
            return false;
        }
        try {
            f(lVar);
            lVar.f80989b.a(lVar);
            return false;
        } catch (Exception e16) {
            x.f("weishi-BusinessLooper", "handleMessage MSG_COMPLETE_TASK:" + e16.getLocalizedMessage());
            return false;
        }
    }

    private static void f(l lVar) {
        j jVar;
        if (lVar == null || (jVar = lVar.f80994g) == null || TextUtils.isEmpty(jVar.getRequestCmd())) {
            return;
        }
        try {
            if (f80970f == null) {
                f80970f = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_LINK_REPORT_CMD_LIST, "getVisitorNotify,getWidget,getActiveFeeds,getFeedAlert,getMainPage,getHostHBInfo,getProfileFeeds,applist.shuoshuo,applist.photo,detail.shuoshuo,detail.photo,getPassiveFeeds,getPhotoListEx,like,addComment,forward,Operation.shareOutsite");
            }
            String requestCmd = lVar.f80994g.getRequestCmd();
            if (!f80970f.contains(requestCmd) || lVar.f80992e == 0) {
                return;
            }
            x.f("WeishiBusinessLooper", "cmd error report! cmd=" + requestCmd + " retCode=" + lVar.f80992e + " msg=" + lVar.f80990c + " duration=" + (System.currentTimeMillis() - lVar.f80998k));
        } catch (Exception e16) {
            x.f("weishi-BusinessLooper", "reportRequest Exception:" + e16.getLocalizedMessage());
        }
    }
}

package com.tencent.mobileqq.qqguildsdk.wrapper;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGuildService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import vh2.bl;

/* compiled from: P */
/* loaded from: classes17.dex */
public class hm {

    /* renamed from: e, reason: collision with root package name */
    private static final Handler f270259e = new Handler(Looper.getMainLooper());

    /* renamed from: a, reason: collision with root package name */
    private final IKernelGuildService f270260a;

    /* renamed from: b, reason: collision with root package name */
    private final ArrayList<IGProUserInfo> f270261b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    private Object f270262c = null;

    /* renamed from: d, reason: collision with root package name */
    private b f270263d = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class a implements vh2.bl {
        a() {
        }

        @Override // vh2.bl
        public void a(bl.a aVar) {
            hm.this.h(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final String f270265a;

        /* renamed from: b, reason: collision with root package name */
        private final long f270266b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f270267c;

        /* renamed from: d, reason: collision with root package name */
        private final int f270268d;

        public b(String str, long j3, boolean z16, int i3, vh2.br brVar) {
            this.f270265a = str;
            this.f270266b = j3;
            this.f270267c = z16;
            this.f270268d = i3;
        }

        static /* bridge */ /* synthetic */ vh2.br a(b bVar) {
            bVar.getClass();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public List<IGProUserInfo> f270269a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        public List<IGProUserInfo> f270270b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        public List<IGProUserInfo> f270271c = new ArrayList();

        public c(List<IGProUserInfo> list) {
            a(list);
        }

        public void a(List<IGProUserInfo> list) {
            for (IGProUserInfo iGProUserInfo : list) {
                if (iGProUserInfo.getRobotType() == 1) {
                    this.f270271c.add(iGProUserInfo);
                } else if (hm.i(iGProUserInfo)) {
                    this.f270270b.add(iGProUserInfo);
                } else if (hm.j(iGProUserInfo)) {
                    this.f270269a.add(iGProUserInfo);
                } else {
                    QLog.e("GProUserListApiAdapter", 1, "USER: unknown type of user: ", iGProUserInfo);
                }
            }
        }
    }

    public hm(IKernelGuildService iKernelGuildService) {
        this.f270260a = iKernelGuildService;
    }

    private void d(bl.a aVar) {
        b.a(this.f270263d);
        String unused = this.f270263d.f270265a;
        int i3 = aVar.f441681a;
        Collections.emptyList();
        Collections.emptyList();
        Collections.emptyList();
        throw null;
    }

    private void e() {
        if (QLog.isColorLevel()) {
            QLog.d("GProUserListApiAdapter", 2, "dispatchUserList: ");
            Iterator<IGProUserInfo> it = this.f270261b.iterator();
            while (it.hasNext()) {
                QLog.d("GProUserListApiAdapter", 2, "USER:", String.valueOf(0), MsgSummary.STR_COLON, it.next());
            }
        }
        new c(this.f270261b);
        b.a(this.f270263d);
        String unused = this.f270263d.f270265a;
        throw null;
    }

    private void f() {
        GProUserListPaginationRequest.j(this.f270260a).h(this.f270263d.f270267c).k(this.f270263d.f270266b).i(this.f270263d.f270265a, this.f270262c, this.f270263d.f270268d, new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(bl.a aVar) {
        this.f270262c = aVar.f441685e;
        if (aVar.f441681a != 0) {
            d(aVar);
        } else {
            this.f270261b.addAll(aVar.f441683c);
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean i(IGProUserInfo iGProUserInfo) {
        if (iGProUserInfo.getUserType() == 1 || iGProUserInfo.getUserType() == 2) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean j(IGProUserInfo iGProUserInfo) {
        if (iGProUserInfo.getUserType() == 0) {
            return true;
        }
        return false;
    }

    public void g(String str, long j3, boolean z16, int i3, vh2.br brVar) {
        this.f270263d = new b(str, j3, z16, i3, brVar);
        f();
    }
}

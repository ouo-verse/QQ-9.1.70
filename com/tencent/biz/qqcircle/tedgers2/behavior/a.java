package com.tencent.biz.qqcircle.tedgers2.behavior;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import cc0.e;
import com.tencent.biz.qqcircle.immersive.layer.biz.inside.tab.QFSTabFeedViewModel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleReporter;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StFeed;
import java.lang.ref.WeakReference;
import java.util.List;
import seal.SealEdgeComputing$ClientItemInfo;
import uq3.c;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a implements QCircleReporter.QCircleReportListener {

    /* renamed from: f, reason: collision with root package name */
    private static volatile a f92450f;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<b> f92451d;

    /* renamed from: e, reason: collision with root package name */
    private int f92452e;

    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.tedgers2.behavior.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0931a {

        /* renamed from: a, reason: collision with root package name */
        private int f92453a = 0;

        /* renamed from: b, reason: collision with root package name */
        private int f92454b = 0;

        /* renamed from: c, reason: collision with root package name */
        private String f92455c = "";

        /* renamed from: d, reason: collision with root package name */
        private String f92456d = "";

        /* renamed from: e, reason: collision with root package name */
        private String f92457e = "";

        /* renamed from: f, reason: collision with root package name */
        private String f92458f = "";

        /* renamed from: g, reason: collision with root package name */
        private String f92459g = "";

        /* renamed from: h, reason: collision with root package name */
        private long f92460h = 0;

        /* renamed from: i, reason: collision with root package name */
        private long f92461i = 0;

        /* renamed from: j, reason: collision with root package name */
        private long f92462j = 0;

        /* renamed from: k, reason: collision with root package name */
        private int f92463k = 0;

        public int a() {
            return this.f92453a;
        }

        public String b() {
            return this.f92457e;
        }

        public String c() {
            return this.f92459g;
        }

        public String d() {
            return this.f92455c;
        }

        public int e() {
            return this.f92463k;
        }

        public int f() {
            return this.f92454b;
        }

        public String g() {
            return this.f92458f;
        }

        public long h() {
            return this.f92460h;
        }

        public long i() {
            return this.f92461i;
        }

        public long j() {
            return this.f92462j;
        }

        public C0931a k(int i3) {
            this.f92453a = i3;
            return this;
        }

        public C0931a l(String str) {
            this.f92457e = str;
            return this;
        }

        public C0931a m(String str) {
            this.f92459g = str;
            return this;
        }

        public C0931a n(String str) {
            this.f92455c = str;
            return this;
        }

        public void o(int i3) {
            this.f92463k = i3;
        }

        public C0931a p(int i3) {
            this.f92454b = i3;
            return this;
        }

        public C0931a q(String str) {
            this.f92458f = str;
            return this;
        }

        public C0931a r(long j3) {
            this.f92460h = j3;
            return this;
        }

        public C0931a s(String str) {
            this.f92456d = str;
            return this;
        }

        public C0931a t(long j3) {
            this.f92461i = j3;
            return this;
        }

        public C0931a u(long j3) {
            this.f92462j = j3;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface b {
        void a(C0931a c0931a, e30.b bVar);
    }

    private void a(@NonNull C0931a c0931a, @NonNull e30.b bVar) {
        int a16 = c0931a.a();
        if (!QFSEdgeCollectAction.a(a16, c0931a.f()) || QFSEdgeBasedAction.a(a16) == -1) {
            return;
        }
        j(c0931a);
        WeakReference<b> weakReference = this.f92451d;
        if (weakReference != null && weakReference.get() != null) {
            this.f92451d.get().a(c0931a, bVar);
        }
    }

    private boolean b() {
        w20.a j3 = w20.a.j();
        if (j3 == null) {
            return false;
        }
        IDataDisplaySurface displaySurface = j3.getDisplaySurface(e30.b.class, String.valueOf(6));
        if (!(displaySurface instanceof QFSTabFeedViewModel) || displaySurface.hashCode() != this.f92452e) {
            return false;
        }
        return true;
    }

    private boolean c(String str, String str2) {
        if (i(str, str2)) {
            return true;
        }
        return false;
    }

    public static a d() {
        if (f92450f == null) {
            synchronized (a.class) {
                if (f92450f == null) {
                    f92450f = new a();
                }
            }
        }
        return f92450f;
    }

    private String e(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        return feedCloudMeta$StFeed.poster.f398463id.get() + "|" + feedCloudMeta$StFeed.f398449id.get() + "|" + feedCloudMeta$StFeed.createTime.get();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0054 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0056 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0058 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0009 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void f(List<FeedCloudCommon$Entry> list) {
        String str = "";
        String str2 = "";
        String str3 = str2;
        for (FeedCloudCommon$Entry feedCloudCommon$Entry : list) {
            String str4 = feedCloudCommon$Entry.value.get();
            String str5 = feedCloudCommon$Entry.key.get();
            str5.hashCode();
            char c16 = '\uffff';
            switch (str5.hashCode()) {
                case -1278409927:
                    if (str5.equals("feedid")) {
                        c16 = 0;
                    }
                    switch (c16) {
                        case 0:
                            str = str4;
                            break;
                        case 1:
                            str3 = str4;
                            break;
                        case 2:
                            str2 = str4;
                            break;
                    }
                    break;
                case 386461872:
                    if (str5.equals("subactiontype")) {
                        c16 = 1;
                    }
                    switch (c16) {
                    }
                    break;
                case 1852834416:
                    if (str5.equals("actiontype")) {
                        c16 = 2;
                    }
                    switch (c16) {
                    }
                    break;
                default:
                    switch (c16) {
                    }
                    break;
            }
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            e30.b a16 = e.a(str);
            if (a16 == null || a16.g() == null) {
                a16 = e.c(str);
            }
            if (a16 != null && a16.g() != null) {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                C0931a c0931a = new C0931a();
                c0931a.k(Integer.parseInt(str2));
                c0931a.p(Integer.parseInt(str3));
                c0931a.n(str);
                c0931a.s(e(a16.g()));
                c0931a.r(currentTimeMillis);
                c0931a.t(0L);
                c0931a.u(0L);
                m(a16, c0931a);
                a(c0931a, a16);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0083 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0081 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x000d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void g(List<FeedCloudCommon$Entry> list) {
        String str = "";
        String str2 = "";
        String str3 = str2;
        String str4 = str3;
        String str5 = str4;
        int i3 = 0;
        for (FeedCloudCommon$Entry feedCloudCommon$Entry : list) {
            String str6 = feedCloudCommon$Entry.value.get();
            String str7 = feedCloudCommon$Entry.key.get();
            str7.hashCode();
            char c16 = '\uffff';
            switch (str7.hashCode()) {
                case -1788292820:
                    if (str7.equals(QCircleLpReportDc05507.KEY_VIDEO_TOTAL_TIME)) {
                        c16 = 0;
                    }
                    switch (c16) {
                        case 0:
                            str4 = str6;
                            break;
                        case 1:
                            str = str6;
                            break;
                        case 2:
                            try {
                                i3 = Integer.parseInt(str6);
                                break;
                            } catch (Exception e16) {
                                QLog.e("TEDGEQFS_QFSEdgeActionCollector", 1, "[handle5507Report] parseInt error:" + e16);
                                break;
                            }
                        case 3:
                            str5 = str6;
                            break;
                        case 4:
                            str3 = str6;
                            break;
                        case 5:
                            str2 = str6;
                            break;
                    }
                    break;
                case -1278409927:
                    if (str7.equals("feedid")) {
                        c16 = 1;
                    }
                    switch (c16) {
                    }
                    break;
                case -137438223:
                    if (str7.equals(QCircleLpReportDc05507.KEY_POSITION_ID)) {
                        c16 = 2;
                    }
                    switch (c16) {
                    }
                    break;
                case 165761588:
                    if (str7.equals(QCircleLpReportDc05507.KEY_VIDEO_PLAY_TIME)) {
                        c16 = 3;
                    }
                    switch (c16) {
                    }
                    break;
                case 386461872:
                    if (str7.equals("subactiontype")) {
                        c16 = 4;
                    }
                    switch (c16) {
                    }
                    break;
                case 1852834416:
                    if (str7.equals("actiontype")) {
                        c16 = 5;
                    }
                    switch (c16) {
                    }
                    break;
                default:
                    switch (c16) {
                    }
                    break;
            }
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4) || TextUtils.isEmpty(str5) || c(str2, str3)) {
            return;
        }
        e30.b a16 = e.a(str);
        if (a16 == null || a16.g() == null) {
            a16 = e.c(str);
        }
        if (a16 != null && a16.g() != null) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            long parseLong = Long.parseLong(str5);
            long parseLong2 = Long.parseLong(str4);
            int parseInt = Integer.parseInt(str2);
            C0931a c0931a = new C0931a();
            c0931a.k(parseInt);
            c0931a.p(Integer.parseInt(str3));
            c0931a.n(str);
            c0931a.s(e(a16.g()));
            c0931a.r(currentTimeMillis);
            c0931a.t(parseLong);
            c0931a.u(parseLong2);
            c0931a.o(i3);
            m(a16, c0931a);
            a(c0931a, a16);
        }
    }

    private boolean i(String str, String str2) {
        if (TextUtils.equals(str, "69") && TextUtils.equals(str2, "2")) {
            return true;
        }
        return false;
    }

    private void j(C0931a c0931a) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("printTriggerReRankInfo action: ");
        sb5.append(c0931a.a());
        sb5.append(", ".concat("feed_id: " + c0931a.d() + ", ").concat("timeStamp: " + c0931a.h() + ", ").concat("playDuration: " + c0931a.i() + ", ").concat("physicalDuration: " + c0931a.j() + ", ").concat("cateId: " + c0931a.b() + ", ").concat("subCateId: " + c0931a.g() + ", ").concat("extend: " + c0931a.c() + ", "));
        QLog.d("TEDGEQFS_QFSEdgeActionCollector", 1, sb5.toString());
    }

    private void m(@NonNull e30.b bVar, C0931a c0931a) {
        try {
            SealEdgeComputing$ClientItemInfo sealEdgeComputing$ClientItemInfo = new SealEdgeComputing$ClientItemInfo();
            sealEdgeComputing$ClientItemInfo.mergeFrom(bVar.g().recomInfo.clientSealData.get().toByteArray());
            if (!TextUtils.isEmpty(sealEdgeComputing$ClientItemInfo.cate_name.get())) {
                c0931a.l(sealEdgeComputing$ClientItemInfo.cate_name.get());
                c0931a.q(sealEdgeComputing$ClientItemInfo.sub_cate_name.get());
                c0931a.m(sealEdgeComputing$ClientItemInfo.extend.get());
            }
        } catch (Exception e16) {
            QLog.e("TEDGEQFS_QFSEdgeActionCollector", 1, "wrapCateInfo error:", e16.toString());
        }
    }

    public void h() {
        QCircleReporter.getInstance().addReportListener(d());
    }

    public void k(b bVar) {
        this.f92451d = new WeakReference<>(bVar);
    }

    public void l(int i3) {
        this.f92452e = i3;
    }

    @Override // cooperation.qqcircle.report.QCircleReporter.QCircleReportListener
    public void onAddReportData(int i3, List<FeedCloudCommon$Entry> list) {
        if (!c.n0() || !b()) {
            return;
        }
        if (i3 != 5501) {
            if (i3 == 5507) {
                g(list);
                return;
            }
            return;
        }
        f(list);
    }
}

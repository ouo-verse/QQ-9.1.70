package com.tencent.mobileqq.filemanager.activity.favfile;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.app.IQQFavProxy;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.al;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import mqq.app.AppRuntime;

/* loaded from: classes12.dex */
public class QfileFavFileRecordProvider extends Observable implements IQQFavProxy.b {
    static String G = "QfileFavFileRecordProvider<FileAssistant>";
    static String H = "FavFileS ";
    private Runnable D;
    private Runnable F;

    /* renamed from: d, reason: collision with root package name */
    private BaseQQAppInterface f206526d;

    /* renamed from: m, reason: collision with root package name */
    private Handler f206531m;

    /* renamed from: e, reason: collision with root package name */
    private long f206527e = 0;

    /* renamed from: f, reason: collision with root package name */
    private boolean f206528f = false;

    /* renamed from: h, reason: collision with root package name */
    private c f206529h = new c();

    /* renamed from: i, reason: collision with root package name */
    private boolean f206530i = false;
    private volatile boolean C = false;
    private volatile boolean E = false;

    /* loaded from: classes12.dex */
    public static class EventObserver implements Observer {
        /* JADX INFO: Access modifiers changed from: private */
        public void e(Object obj) {
            Object[] objArr = (Object[]) obj;
            int intValue = ((Integer) objArr[0]).intValue();
            Object[] objArr2 = (Object[]) objArr[1];
            if (intValue == 1) {
                d(((Integer) objArr2[0]).intValue());
            } else if (intValue == 2) {
                b((Bundle) objArr2[0]);
            } else if (intValue == 3) {
                c(((Boolean) objArr2[0]).booleanValue(), (Bundle) objArr2[1]);
            }
        }

        public void b(Bundle bundle) {
            throw null;
        }

        public void c(boolean z16, Bundle bundle) {
            throw null;
        }

        public void d(int i3) {
            throw null;
        }

        @Override // java.util.Observer
        public void update(Observable observable, final Object obj) {
            if (obj == null) {
                return;
            }
            Looper mainLooper = Looper.getMainLooper();
            if (Thread.currentThread() != mainLooper.getThread()) {
                new Handler(mainLooper).post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileRecordProvider.EventObserver.1
                    @Override // java.lang.Runnable
                    public void run() {
                        EventObserver.this.e(obj);
                    }
                });
            } else {
                e(obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class a extends IQQFavProxy.a {
        a() {
        }

        @Override // com.tencent.mobileqq.filemanager.app.IQQFavProxy.a
        public void a(int i3, List<FavFileInfo> list, Bundle bundle) {
            int i16;
            if (!QfileFavFileRecordProvider.this.C) {
                QLog.d(QfileFavFileRecordProvider.G, 1, QfileFavFileRecordProvider.H + "<<<getMoreFileRecords is not getting");
                return;
            }
            QLog.i(QfileFavFileRecordProvider.G, 1, QfileFavFileRecordProvider.H + "<<<getMoreFileRecords result errCode:" + i3);
            QfileFavFileRecordProvider.this.F();
            if (i3 != 0) {
                if (i3 == 65535) {
                    i16 = R.string.f187323to;
                } else {
                    i16 = R.string.f187313tn;
                }
                QQToast.makeText(BaseApplication.getContext(), 0, i16, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height) - ((int) al.a(BaseApplication.getContext(), 5.0f)));
                QfileFavFileRecordProvider.this.setChanged();
                QfileFavFileRecordProvider.this.notifyObservers(new Object[]{1, new Object[]{Integer.valueOf(i3)}});
                return;
            }
            if (bundle != null) {
                QfileFavFileRecordProvider.this.f206527e = bundle.getLong("resultTimestamp");
                boolean z16 = bundle.getBoolean("fecth_end");
                QfileFavFileRecordProvider.this.f206530i = bundle.getBoolean("fecth_local_end");
                if (z16 && (list == null || list.size() == 0)) {
                    QfileFavFileRecordProvider.this.f206528f = true;
                }
                QLog.i(QfileFavFileRecordProvider.G, 1, QfileFavFileRecordProvider.H + "getMoreFileRecords result: nextTimestamp:" + QfileFavFileRecordProvider.this.f206527e + " gettedListEnd:" + z16 + " localEnd:" + QfileFavFileRecordProvider.this.f206530i);
            } else {
                QLog.i(QfileFavFileRecordProvider.G, 1, QfileFavFileRecordProvider.H + "getMoreFileRecords result: lastTimestamp:" + QfileFavFileRecordProvider.this.f206527e + " exData=null");
            }
            d dVar = new d();
            QfileFavFileRecordProvider.this.y(list, dVar);
            QfileFavFileRecordProvider.this.t(dVar);
            QfileFavFileRecordProvider.this.setChanged();
            QfileFavFileRecordProvider.this.notifyObservers(new Object[]{1, new Object[]{0}});
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class b extends IQQFavProxy.a {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Bundle f206534c;

        b(Bundle bundle) {
            this.f206534c = bundle;
        }

        @Override // com.tencent.mobileqq.filemanager.app.IQQFavProxy.a
        public void a(int i3, List<FavFileInfo> list, Bundle bundle) {
            Bundle bundle2;
            int i16;
            if (!QfileFavFileRecordProvider.this.E) {
                QLog.d(QfileFavFileRecordProvider.G, 1, QfileFavFileRecordProvider.H + "<<<syncLastFileRecord is not getting");
                return;
            }
            QLog.i(QfileFavFileRecordProvider.G, 1, QfileFavFileRecordProvider.H + "<<<syncLastFileRecord result errCode:" + i3);
            if (bundle == null) {
                bundle2 = new Bundle();
            } else {
                bundle2 = bundle;
            }
            Bundle bundle3 = this.f206534c;
            if (bundle3 != null) {
                bundle2.putAll(bundle3);
            }
            QfileFavFileRecordProvider.this.G();
            if (i3 != 0) {
                if (i3 == 65535) {
                    i16 = R.string.f187323to;
                } else {
                    i16 = R.string.f187313tn;
                }
                QQToast.makeText(BaseApplication.getContext(), 0, i16, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height) - ((int) al.a(BaseApplication.getContext(), 5.0f)));
                QfileFavFileRecordProvider.this.setChanged();
                QfileFavFileRecordProvider.this.notifyObservers(new Object[]{3, new Object[]{Boolean.FALSE, bundle2}});
                return;
            }
            ((IQQFileEngine) QfileFavFileRecordProvider.this.f206526d.getRuntimeService(IQQFileEngine.class)).favProxyCancelGetFileList(QfileFavFileRecordProvider.this.f206527e);
            QfileFavFileRecordProvider.this.F();
            QfileFavFileRecordProvider.this.B();
            if (bundle != null) {
                QfileFavFileRecordProvider.this.f206527e = bundle.getLong("resultTimestamp");
                boolean z16 = bundle.getBoolean("fecth_end");
                QfileFavFileRecordProvider.this.f206530i = bundle.getBoolean("fecth_local_end");
                if (z16 && (list == null || list.size() == 0)) {
                    QfileFavFileRecordProvider.this.f206528f = true;
                }
                QLog.i(QfileFavFileRecordProvider.G, 1, QfileFavFileRecordProvider.H + "syncLastFileRecord result: nextTimestamp:" + QfileFavFileRecordProvider.this.f206527e + " gettedListEnd:" + z16 + " localEnd:" + QfileFavFileRecordProvider.this.f206530i);
            } else {
                QLog.i(QfileFavFileRecordProvider.G, 1, QfileFavFileRecordProvider.H + "syncLastFileRecord result: lastTimestamp:" + QfileFavFileRecordProvider.this.f206527e + " exData=null");
            }
            d dVar = new d();
            QfileFavFileRecordProvider.this.y(list, dVar);
            QfileFavFileRecordProvider.this.t(dVar);
            QfileFavFileRecordProvider.this.setChanged();
            QfileFavFileRecordProvider.this.notifyObservers(new Object[]{3, new Object[]{Boolean.TRUE, bundle2}});
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public class c extends d {

        /* renamed from: f, reason: collision with root package name */
        Map<Long, FavFileInfo> f206536f = new HashMap();

        /* renamed from: g, reason: collision with root package name */
        Comparator<FavFileInfo> f206537g = new a();

        /* loaded from: classes12.dex */
        class a implements Comparator<FavFileInfo> {
            a() {
            }

            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(FavFileInfo favFileInfo, FavFileInfo favFileInfo2) {
                long j3 = favFileInfo2.C;
                long j16 = favFileInfo.C;
                if (j3 > j16) {
                    return 1;
                }
                if (j3 < j16) {
                    return -1;
                }
                return 0;
            }
        }

        c() {
        }

        void b(List<FavFileInfo> list, int i3) {
            ArrayList<FavFileInfo> arrayList;
            if (list != null && list.size() != 0) {
                if (i3 == 1) {
                    arrayList = this.f206540a;
                } else if (i3 == 2) {
                    arrayList = this.f206541b;
                } else if (i3 == 3) {
                    arrayList = this.f206542c;
                } else if (i3 == 4) {
                    arrayList = this.f206543d;
                } else if (i3 == 5) {
                    arrayList = this.f206544e;
                } else {
                    arrayList = this.f206544e;
                }
                boolean z16 = false;
                for (FavFileInfo favFileInfo : list) {
                    if (favFileInfo != null) {
                        if (this.f206536f.containsKey(Long.valueOf(favFileInfo.f207672d))) {
                            QLog.w(QfileFavFileRecordProvider.G, 1, QfileFavFileRecordProvider.H + "addOrUpdateFileRecords favfile is exsited, favid:" + favFileInfo.f207672d);
                        }
                        arrayList.add(favFileInfo);
                        this.f206536f.put(Long.valueOf(favFileInfo.f207672d), favFileInfo);
                        z16 = true;
                    }
                }
                if (z16) {
                    Collections.sort(arrayList, this.f206537g);
                }
                QLog.i(QfileFavFileRecordProvider.G, 1, QfileFavFileRecordProvider.H + "addOrUpdateFileRecords recordType:" + i3 + " addsize:" + list.size() + " recordSize:" + arrayList.size());
            }
        }

        void c() {
            this.f206540a.clear();
            this.f206541b.clear();
            this.f206542c.clear();
            this.f206543d.clear();
            this.f206544e.clear();
            this.f206536f.clear();
            QLog.i(QfileFavFileRecordProvider.G, 1, QfileFavFileRecordProvider.H + "FavFileRecords clear...");
        }

        FavFileInfo d(long j3) {
            return this.f206536f.get(Long.valueOf(j3));
        }

        List<FavFileInfo> e(int i3) {
            if (i3 == 1) {
                return this.f206540a;
            }
            if (i3 == 2) {
                return this.f206541b;
            }
            if (i3 == 3) {
                return this.f206542c;
            }
            if (i3 == 4) {
                return this.f206543d;
            }
            if (i3 == 5) {
                return this.f206544e;
            }
            return this.f206544e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        ArrayList<FavFileInfo> f206540a = new ArrayList<>();

        /* renamed from: b, reason: collision with root package name */
        ArrayList<FavFileInfo> f206541b = new ArrayList<>();

        /* renamed from: c, reason: collision with root package name */
        ArrayList<FavFileInfo> f206542c = new ArrayList<>();

        /* renamed from: d, reason: collision with root package name */
        ArrayList<FavFileInfo> f206543d = new ArrayList<>();

        /* renamed from: e, reason: collision with root package name */
        ArrayList<FavFileInfo> f206544e = new ArrayList<>();

        d() {
        }

        ArrayList<FavFileInfo> a(String str) {
            int o06 = ah.o0(str);
            if (o06 == 0) {
                return this.f206540a;
            }
            if (o06 != 3 && o06 != 6 && o06 != 7 && o06 != 9 && o06 != 10) {
                if (o06 == 2) {
                    return this.f206542c;
                }
                if (o06 == 5) {
                    return this.f206543d;
                }
                return this.f206544e;
            }
            return this.f206541b;
        }
    }

    public QfileFavFileRecordProvider(AppRuntime appRuntime) {
        this.f206526d = (BaseQQAppInterface) appRuntime;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        QLog.i(G, 1, H + "resetFileRecordInfo.");
        this.f206527e = 0L;
        this.f206530i = false;
        this.f206528f = false;
        this.f206529h.c();
    }

    private void C() {
        if (this.C) {
            return;
        }
        this.C = true;
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileRecordProvider.2
            @Override // java.lang.Runnable
            public void run() {
                if (!QfileFavFileRecordProvider.this.C) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                long favProxyGetGettedPartList = ((IQQFileEngine) QfileFavFileRecordProvider.this.f206526d.getRuntimeService(IQQFileEngine.class)).favProxyGetGettedPartList(QfileFavFileRecordProvider.this.f206527e, arrayList);
                QLog.e(QfileFavFileRecordProvider.G, 1, QfileFavFileRecordProvider.H + "get favList timeout!!! gettedsize:" + arrayList.size() + " nextTimestamp:" + favProxyGetGettedPartList);
                if (arrayList.size() > 0) {
                    d dVar = new d();
                    QfileFavFileRecordProvider.this.y(arrayList, dVar);
                    QfileFavFileRecordProvider.this.t(dVar);
                }
                ((IQQFileEngine) QfileFavFileRecordProvider.this.f206526d.getRuntimeService(IQQFileEngine.class)).favProxyCancelGetFileList(QfileFavFileRecordProvider.this.f206527e);
                QfileFavFileRecordProvider.this.f206527e = favProxyGetGettedPartList;
                QfileFavFileRecordProvider.this.F();
                QfileFavFileRecordProvider.this.setChanged();
                QfileFavFileRecordProvider.this.notifyObservers(new Object[]{1, new Object[]{65535}});
            }
        };
        this.D = runnable;
        this.f206531m.postDelayed(runnable, 30000L);
        QLog.i(G, 1, H + "setGettingFavList timeout:30000");
    }

    private void D() {
        if (this.E) {
            return;
        }
        this.E = true;
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileRecordProvider.3
            @Override // java.lang.Runnable
            public void run() {
                if (!QfileFavFileRecordProvider.this.E) {
                    return;
                }
                QLog.e(QfileFavFileRecordProvider.G, 1, QfileFavFileRecordProvider.H + "refresh favList timeout!!!");
                QfileFavFileRecordProvider.this.G();
                QQToast.makeText(BaseApplication.getContext(), 0, R.string.f187563ub, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height) - ((int) al.a(BaseApplication.getContext(), 5.0f)));
                QfileFavFileRecordProvider.this.setChanged();
                QfileFavFileRecordProvider.this.notifyObservers(new Object[]{3, new Object[]{Boolean.FALSE, new Bundle()}});
            }
        };
        this.F = runnable;
        this.f206531m.postDelayed(runnable, 30000L);
        QLog.i(G, 1, H + "setRefreshingFavList timeout:30000");
    }

    private void E(Bundle bundle) {
        QLog.i(G, 1, H + ">>>syncLastFileRecord...");
        ((IQQFileEngine) this.f206526d.getRuntimeService(IQQFileEngine.class)).favProxyGetFileList(0L, false, null, new b(bundle));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        this.C = false;
        Runnable runnable = this.D;
        if (runnable != null) {
            this.f206531m.removeCallbacks(runnable);
            this.D = null;
        }
        QLog.i(G, 1, H + "unsetGettingFavList");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        this.E = false;
        Runnable runnable = this.F;
        if (runnable != null) {
            this.f206531m.removeCallbacks(runnable);
            this.F = null;
        }
        QLog.i(G, 1, H + "unsetRefreshingFavList");
    }

    private void s(List<FavFileInfo> list, int i3) {
        this.f206529h.b(list, i3);
    }

    public void A() {
        QLog.i(G, 1, H + "release...");
        ((IQQFileEngine) this.f206526d.getRuntimeService(IQQFileEngine.class)).favProxyCancelGetFileList(this.f206527e);
        ((IQQFileEngine) this.f206526d.getRuntimeService(IQQFileEngine.class)).favProxyDeleteListener(this);
        this.f206526d = null;
        this.f206529h.c();
        F();
        G();
    }

    @Override // com.tencent.mobileqq.filemanager.app.IQQFavProxy.b
    public void a(long j3, int i3, String str) {
        QLog.i(G, 1, H + "onFileThumbUpdated. favid:" + j3 + " type:" + i3 + " strSavePath:" + str);
        FavFileInfo d16 = this.f206529h.d(j3);
        if (d16 != null) {
            if (i3 == 0) {
                d16.F = str;
            } else if (i3 == 1) {
                d16.G = str;
            } else if (i3 == 2) {
                d16.H = str;
            } else if (i3 == 3) {
                d16.I = str;
            } else if (i3 == 4) {
                d16.J = str;
            }
        }
        setChanged();
        notifyObservers(new Object[]{2, new Object[]{new Bundle()}});
    }

    @Override // com.tencent.mobileqq.filemanager.app.IQQFavProxy.b
    public void onFileDownloaded(long j3, String str) {
        QLog.i(G, 1, H + "onFileDownloaded. favid:" + j3 + " strSavePath:" + str);
        FavFileInfo d16 = this.f206529h.d(j3);
        if (d16 != null) {
            d16.D = str;
        }
        setChanged();
        notifyObservers(new Object[]{2, new Object[]{new Bundle()}});
    }

    @Override // com.tencent.mobileqq.filemanager.app.IQQFavProxy.b
    public void onFileListRefreshed(boolean z16, Bundle bundle) {
        if (z16) {
            E(bundle);
            return;
        }
        QQToast.makeText(BaseApplication.getContext(), 0, R.string.f187123t5, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height) - ((int) al.a(BaseApplication.getContext(), 5.0f)));
        G();
        setChanged();
        notifyObservers(new Object[]{3, new Object[]{Boolean.FALSE, bundle}});
    }

    void t(d dVar) {
        if (dVar == null) {
            QLog.e(G, 1, H + "addOrUpdateRecords parm err");
            return;
        }
        if (dVar.f206540a.size() > 0) {
            s(dVar.f206540a, 1);
        }
        if (dVar.f206541b.size() > 0) {
            s(dVar.f206541b, 2);
        }
        if (dVar.f206542c.size() > 0) {
            s(dVar.f206542c, 3);
        }
        if (dVar.f206543d.size() > 0) {
            s(dVar.f206543d, 4);
        }
        if (dVar.f206544e.size() > 0) {
            s(dVar.f206544e, 5);
        }
    }

    public List<FavFileInfo> u(int i3) {
        return this.f206529h.e(i3);
    }

    public void v() {
        if (this.C) {
            QLog.d(G, 1, H + "getMoreFileRecords. is getting...");
            return;
        }
        if (this.E) {
            QLog.i(G, 1, H + "getMoreFileRecords. is refreshing...");
            return;
        }
        QLog.i(G, 1, H + ">>>getMoreFileRecords... lastTimestamp:" + this.f206527e);
        ((IQQFileEngine) this.f206526d.getRuntimeService(IQQFileEngine.class)).favProxyGetFileList(this.f206527e, this.f206530i, null, new a());
        C();
    }

    public void w() {
        QLog.i(G, 1, H + "init...");
        ((IQQFileEngine) this.f206526d.getRuntimeService(IQQFileEngine.class)).favProxyAddListener(this);
        if (this.f206531m == null) {
            this.f206531m = new Handler(Looper.getMainLooper());
        }
    }

    public boolean x() {
        return this.f206528f;
    }

    void y(List<FavFileInfo> list, d dVar) {
        if (dVar != null && list != null) {
            for (FavFileInfo favFileInfo : list) {
                if (favFileInfo != null) {
                    dVar.a(favFileInfo.f207675h).add(favFileInfo);
                }
            }
            QLog.i(G, 1, H + "pickFavFileList. picSize:" + dVar.f206540a.size() + " docSize:" + dVar.f206541b.size() + " videoSize:" + dVar.f206542c.size() + " appSize:" + dVar.f206543d.size() + " otherSize:" + dVar.f206544e.size());
            return;
        }
        QLog.e(G, 1, H + "pickFavFileList parm err");
    }

    public void z(Bundle bundle) {
        if (this.E) {
            return;
        }
        QLog.i(G, 1, H + "refreshFileRecords...");
        if (!NetworkUtil.isNetworkAvailable(this.f206526d.getApplication().getApplicationContext())) {
            QLog.i(G, 2, "refreshFileRecords no network");
            QQToast.makeText(BaseApplication.getContext(), 0, R.string.f187123t5, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height) - ((int) al.a(BaseApplication.getContext(), 5.0f)));
            setChanged();
            notifyObservers(new Object[]{3, new Object[]{Boolean.FALSE, new Bundle()}});
            return;
        }
        ((IQQFileEngine) this.f206526d.getRuntimeService(IQQFileEngine.class)).favProxyRefreshList(bundle);
        D();
    }
}

package com.tencent.mobileqq.filemanager.activity.favfile;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewTreeObserver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileRecordProvider;
import com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView;
import com.tencent.mobileqq.filemanager.app.IQQFavProxy;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.filemanager.data.f;
import com.tencent.mobileqq.filemanager.widget.NoFileRelativeLayout;
import com.tencent.mobileqq.filemanager.widget.QfilePinnedHeaderExpandableListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class QfileBaseFavFileTabView extends QfileBaseTabView {
    static String R = "QfileBaseFavFileTabView<FileAssistant>";
    static String S = "FavFileS ";
    protected LinkedHashMap<String, List<FavFileInfo>> E;
    protected QfilePinnedHeaderExpandableListView F;
    protected ob1.d G;
    protected NoFileRelativeLayout H;
    protected LayoutInflater I;
    protected QfileFavFileRecordProvider J;
    protected int K;
    protected c L;
    protected QfileFavFileRecordProvider.EventObserver M;
    protected volatile boolean N;
    protected volatile boolean P;
    protected d Q;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a extends QfileFavFileRecordProvider.EventObserver {
        a() {
        }

        @Override // com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileRecordProvider.EventObserver
        public void b(Bundle bundle) {
            QfileBaseFavFileTabView.this.U(bundle);
        }

        @Override // com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileRecordProvider.EventObserver
        public void c(boolean z16, Bundle bundle) {
            QfileBaseFavFileTabView.this.V(z16, bundle);
        }

        @Override // com.tencent.mobileqq.filemanager.activity.favfile.QfileFavFileRecordProvider.EventObserver
        public void d(int i3) {
            QfileBaseFavFileTabView.this.W(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            QfileBaseFavFileTabView.this.Z();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        boolean f206519a = false;

        /* renamed from: b, reason: collision with root package name */
        int f206520b = 0;

        /* renamed from: c, reason: collision with root package name */
        int f206521c = 0;

        /* renamed from: d, reason: collision with root package name */
        int f206522d = 0;

        /* renamed from: e, reason: collision with root package name */
        int f206523e = 0;

        /* renamed from: f, reason: collision with root package name */
        int f206524f = 0;

        /* renamed from: g, reason: collision with root package name */
        int f206525g = 0;

        c() {
        }

        boolean a() {
            if (this.f206524f >= 5 && this.f206523e <= 10) {
                return false;
            }
            return true;
        }

        String b() {
            return " startCount:" + this.f206520b + " targetCount:" + this.f206521c + " ReqSeq:" + this.f206522d + " continueCount:" + this.f206523e + " mNoNewDataCount:" + this.f206524f + " mLastRecordSize:" + this.f206525g;
        }

        void c(int i3) {
            this.f206523e++;
            if (i3 == this.f206525g) {
                this.f206524f++;
            }
            this.f206525g = i3;
        }

        void d(int i3, int i16) {
            this.f206519a = true;
            this.f206520b = i3;
            this.f206521c = i16;
            this.f206522d++;
            this.f206523e = 0;
            this.f206524f = 0;
            this.f206525g = i3;
        }

        void e() {
            this.f206519a = false;
            this.f206520b = 0;
            this.f206521c = 0;
            this.f206523e = 0;
            this.f206524f = 0;
            this.f206525g = 0;
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface d {
        boolean b();

        void setRefreshedFavList(boolean z16);
    }

    public QfileBaseFavFileTabView(Context context, QfileFavFileRecordProvider qfileFavFileRecordProvider, d dVar) {
        super(context);
        this.K = 0;
        this.L = new c();
        this.M = new a();
        this.N = false;
        this.P = false;
        this.E = new LinkedHashMap<>();
        this.J = qfileFavFileRecordProvider;
        qfileFavFileRecordProvider.addObserver(this.M);
        this.Q = dVar;
    }

    private void R() {
        this.F = (QfilePinnedHeaderExpandableListView) findViewById(R.id.c_r);
        NoFileRelativeLayout noFileRelativeLayout = new NoFileRelativeLayout(o());
        this.H = noFileRelativeLayout;
        this.F.addHeaderView(noFileRelativeLayout);
        Z();
        ob1.d O = O();
        this.G = O;
        O.f(this.F);
        this.F.setAdapter(this.G);
        this.F.setFocusable(false);
        this.F.setSelector(R.color.ajr);
        this.F.setTranscriptMode(0);
        for (int i3 = 0; i3 < this.G.getGroupCount(); i3++) {
            this.F.expandGroup(i3);
        }
        this.F.smoothScrollToPosition(0);
        this.F.setStackFromBottom(false);
        this.F.setTranscriptMode(0);
        this.F.getViewTreeObserver().addOnGlobalLayoutListener(new b());
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void A() {
        if (this.N) {
            return;
        }
        BaseFileAssistantActivity baseFileAssistantActivity = this.f206603d;
        baseFileAssistantActivity.H2(baseFileAssistantActivity.r3());
        setEditbarButton(false, true, false, true, true);
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void B() {
        super.B();
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void C() {
        E(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.favfile.QfileBaseFavFileTabView.4
            @Override // java.lang.Runnable
            public void run() {
                QfileBaseFavFileTabView.this.Y();
            }
        });
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void D() {
        List<FavFileInfo> P = P();
        if (P != null && P.size() > 0) {
            this.E.clear();
            for (FavFileInfo favFileInfo : P) {
                String L = L(favFileInfo);
                if (!this.E.containsKey(L)) {
                    this.E.put(L, new ArrayList());
                }
                this.E.get(L).add(favFileInfo);
            }
            this.K = P.size();
            C();
            return;
        }
        this.E.clear();
        C();
    }

    protected void J() {
        this.L.e();
        c0();
    }

    protected abstract int K();

    protected abstract String L(FavFileInfo favFileInfo);

    /* JADX INFO: Access modifiers changed from: protected */
    public void M() {
        a0(N());
    }

    protected abstract int N();

    protected abstract ob1.d O();

    protected List<FavFileInfo> P() {
        return this.J.u(K());
    }

    protected void Q() {
        if (this.N) {
            return;
        }
        this.E.clear();
        List<FavFileInfo> P = P();
        for (FavFileInfo favFileInfo : P) {
            String L = L(favFileInfo);
            if (!this.E.containsKey(L)) {
                this.E.put(L, new ArrayList());
            }
            this.E.get(L).add(favFileInfo);
        }
        this.K = P.size();
        C();
        setSelect(0);
        QLog.i(R, 1, S + "-> initGetRecentFileRecords. curSize:" + P.size() + " OnceShowSize:" + N() + " isEnd:" + T());
        if (!this.Q.b()) {
            this.J.z(null);
        } else {
            this.P = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean S() {
        return this.L.f206519a;
    }

    public boolean T() {
        return this.J.x();
    }

    protected void U(Bundle bundle) {
        if (getVisibility() != 0) {
            return;
        }
        C();
    }

    protected void V(boolean z16, Bundle bundle) {
        String str;
        int i3;
        this.P = true;
        this.Q.setRefreshedFavList(true);
        if (getVisibility() != 0) {
            return;
        }
        QLog.i(R, 1, S + "onFileRecordsRefreshed suc:" + z16 + ". recordType:" + K());
        List<FavFileInfo> P = P();
        if (this.K != P.size()) {
            QLog.d(R, 1, S + "onFileRecordsRefreshed. updateTabView");
            if (this.K == 0) {
                i3 = 0;
            } else {
                i3 = -1;
            }
            d0(i3);
        }
        if (bundle != null) {
            str = bundle.getString(IQQFavProxy.DELETE_FAVIDS);
        } else {
            str = "";
        }
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            try {
                for (String str2 : str.split(",")) {
                    if (!TextUtils.isEmpty(str2)) {
                        arrayList.add(Long.valueOf(Long.valueOf(str2).longValue()));
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        if (arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                f.J(((Long) it.next()).longValue());
            }
            k();
        }
        if (P.size() < N() && !T()) {
            a0(N() - P.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void W(int i3) {
        if (!this.L.f206519a) {
            return;
        }
        int i16 = 0;
        if (i3 != 0) {
            J();
            if (getVisibility() == 0) {
                if (this.K != P().size()) {
                    QLog.d(R, 1, S + "onGettedFileRecords err. updateTabView");
                    if (this.K != 0) {
                        i16 = -1;
                    }
                    d0(i16);
                    return;
                }
                return;
            }
            return;
        }
        List<FavFileInfo> P = P();
        QLog.i(R, 1, S + "onGettedFileRecords. gettedSize:" + P.size() + " isEnd:" + T() + " curShowSize:" + this.K + this.L.b());
        if (!T()) {
            int size = P.size();
            c cVar = this.L;
            if (size - cVar.f206520b < cVar.f206521c) {
                if (cVar.a()) {
                    QLog.i(R, 1, S + "onGettedFileRecords. continue get." + this.L.b());
                    this.J.v();
                    this.L.c(P.size());
                } else {
                    J();
                }
                if (getVisibility() != 0) {
                    if ((this.K == 0 && T()) || this.K != P.size()) {
                        QLog.d(R, 1, S + "onGettedFileRecords. updateTabView");
                        if (this.K != 0) {
                            i16 = -1;
                        }
                        d0(i16);
                        return;
                    }
                    return;
                }
                return;
            }
        }
        J();
        if (getVisibility() != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void X() {
        this.F.setWhetherImageTab(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Y() {
        LinkedHashMap<String, List<FavFileInfo>> linkedHashMap = this.E;
        if (linkedHashMap != null && linkedHashMap.size() != 0) {
            if (this.F.getHeaderViewsCount() > 0) {
                this.F.removeHeaderView(this.H);
            }
        } else if (this.F.getHeaderViewsCount() == 0) {
            this.F.addHeaderView(this.H);
        }
        this.G.notifyDataSetChanged();
    }

    protected void Z() {
        this.H.setLayoutParams(this.F.getWidth(), this.f206603d.getWindow().getDecorView().getHeight() / 2);
    }

    void a0(int i3) {
        if (this.L.f206519a) {
            return;
        }
        QLog.i(R, 1, S + "startGetMoreFileRecord. targertCount:" + i3);
        b0();
        this.L.d(this.K, i3);
        this.J.v();
    }

    protected void d0(int i3) {
        this.E.clear();
        List<FavFileInfo> P = P();
        for (FavFileInfo favFileInfo : P) {
            String L = L(favFileInfo);
            if (!this.E.containsKey(L)) {
                this.E.put(L, new ArrayList());
            }
            this.E.get(L).add(favFileInfo);
        }
        this.K = P.size();
        C();
        if (i3 >= 0) {
            setSelect(i3);
        }
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView, com.tencent.mobileqq.filemanager.activity.fileassistant.a
    public void onResume() {
        int i3;
        if (this.N) {
            return;
        }
        BaseFileAssistantActivity baseFileAssistantActivity = this.f206603d;
        baseFileAssistantActivity.H2(baseFileAssistantActivity.r3());
        List<FavFileInfo> P = P();
        if (this.K != P.size()) {
            if (this.K == 0) {
                i3 = 0;
            } else {
                i3 = -1;
            }
            d0(i3);
        }
        if (this.P && P.size() < N() && !T()) {
            a0(N() - P.size());
        }
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public int p() {
        return 0;
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public ListView q() {
        return this.F;
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void setSelect(final int i3) {
        if (this.G.getGroupCount() <= i3) {
            if (QLog.isColorLevel()) {
                QLog.e(R, 1, "setSelect[" + i3 + "] faild,becouse GroupCount[" + this.G.getGroupCount() + "]");
                return;
            }
            return;
        }
        E(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.favfile.QfileBaseFavFileTabView.5
            @Override // java.lang.Runnable
            public void run() {
                QfileBaseFavFileTabView qfileBaseFavFileTabView = QfileBaseFavFileTabView.this;
                qfileBaseFavFileTabView.f206603d.U3(qfileBaseFavFileTabView);
                QfileBaseFavFileTabView qfileBaseFavFileTabView2 = QfileBaseFavFileTabView.this;
                if (qfileBaseFavFileTabView2.F != null && ((QfileBaseTabView) qfileBaseFavFileTabView2).f206606h) {
                    if (QLog.isColorLevel()) {
                        QLog.i(QfileBaseFavFileTabView.R, 2, "setSelect[" + i3 + "] success mFileListView");
                    }
                    QfileBaseFavFileTabView.this.F.expandGroup(i3);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void y() {
        F(R.layout.alw);
        this.I = LayoutInflater.from(o());
        R();
        X();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.activity.favfile.QfileBaseFavFileTabView.2
            @Override // java.lang.Runnable
            public void run() {
                QfileBaseFavFileTabView.this.Q();
            }
        });
    }

    @Override // com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView
    public void z() {
        super.z();
        B();
        this.E.clear();
        this.J.deleteObserver(this.M);
        this.J = null;
        J();
        this.N = true;
    }

    protected void b0() {
    }

    protected void c0() {
    }
}

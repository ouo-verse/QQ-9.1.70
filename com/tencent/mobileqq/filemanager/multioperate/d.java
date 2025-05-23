package com.tencent.mobileqq.filemanager.multioperate;

import android.app.Activity;
import android.content.DialogInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.data.n;
import com.tencent.mobileqq.troop.data.t;
import com.tencent.mobileqq.troop.file.api.ITroopFileApi;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import cooperation.qqfav.QfavBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes12.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private QQAppInterface f208654a;

    /* renamed from: b, reason: collision with root package name */
    private Activity f208655b;

    /* renamed from: c, reason: collision with root package name */
    private long f208656c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f208657d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.filemanager.multioperate.c f208658e;

        a(List list, com.tencent.mobileqq.filemanager.multioperate.c cVar) {
            this.f208657d = list;
            this.f208658e = cVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (i3 == 1) {
                d.this.f(this.f208657d);
                com.tencent.mobileqq.filemanager.multioperate.c cVar = this.f208658e;
                if (cVar != null) {
                    cVar.a(1, 0);
                    return;
                }
                return;
            }
            com.tencent.mobileqq.filemanager.multioperate.c cVar2 = this.f208658e;
            if (cVar2 != null) {
                cVar2.a(1, 1);
            }
        }
    }

    public d(QQAppInterface qQAppInterface, Activity activity, long j3) {
        this.f208654a = qQAppInterface;
        this.f208655b = activity;
        this.f208656c = j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(List<n> list) {
        UUID uuid;
        int i3;
        TroopFileTransferManager O = TroopFileTransferManager.O(this.f208654a, this.f208656c);
        for (n nVar : list) {
            t k3 = TroopFileUtils.k(this.f208654a, this.f208656c, nVar.f294915a.toString(), nVar.f294916b, nVar.f294917c, nVar.f294918d, nVar.f294919e);
            if (k3 != null && (uuid = k3.f294967a) != null && ((i3 = k3.f294972f) == 10 || i3 == 9)) {
                O.e0(uuid);
            } else {
                O.x0(nVar.f294916b, nVar.f294917c, nVar.f294918d, nVar.f294919e, null);
            }
        }
    }

    private void g(List<n> list, com.tencent.mobileqq.filemanager.multioperate.c cVar) {
        if (list == null) {
            QLog.w("TroopFileMultiOperate", 1, "fileList == null");
            return;
        }
        boolean z16 = false;
        for (n nVar : list) {
            t tVar = new t();
            tVar.f294987u = nVar.f294917c;
            tVar.f294978l = nVar.f294934t;
            tVar.f294976j = nVar.f294918d;
            tVar.f294977k = nVar.f294932r;
            tVar.f294967a = nVar.f294915a;
            long j3 = this.f208656c;
            tVar.f294971e = j3;
            tVar.f294988v = nVar.f294919e;
            tVar.f294985s = nVar.f294916b;
            tVar.f294986t = nVar.f294926l;
            tVar.f294979m = nVar.f294937w;
            tVar.f294980n = nVar.f294938x;
            tVar.f294981o = nVar.f294939y;
            tVar.f294972f = nVar.f294930p;
            TroopFileManager.F(this.f208654a, j3).c(tVar.f294967a);
            FileManagerEntity newEntityByTroopFileInfo = FileManagerUtil.newEntityByTroopFileInfo(tVar);
            if (nVar.f294920f != 0) {
                newEntityByTroopFileInfo.selfUin = "" + nVar.f294920f;
            }
            int i3 = nVar.f294923i;
            if (i3 != 0) {
                newEntityByTroopFileInfo.lastTime = i3;
            }
            newEntityByTroopFileInfo.bSend = this.f208654a.getAccount().equals(newEntityByTroopFileInfo.selfUin);
            if (!new QfavBuilder(3).v(this.f208654a, this.f208655b, newEntityByTroopFileInfo, null, false, "", false, false)) {
                z16 = true;
            }
        }
        if (z16) {
            FileManagerUtil.dealWithErrCode(this.f208655b.getString(R.string.f187023sv));
        } else {
            QQToastUtil.showQQToastInUiThread(2, this.f208655b.getString(R.string.b3n));
        }
    }

    private void h(List<n> list, com.tencent.mobileqq.filemanager.multioperate.c cVar) {
        TroopFileManager F;
        if (TroopFileUtils.d(this.f208654a, this.f208655b, this.f208656c) == 0 || (F = TroopFileManager.F(this.f208654a, this.f208656c)) == null) {
            return;
        }
        boolean a16 = TroopFileUtils.a(this.f208654a, this.f208656c);
        boolean z16 = false;
        for (n nVar : list) {
            boolean equals = this.f208654a.getCurrentAccountUin().equals(nVar.i());
            if (nVar.a(this.f208654a, this.f208656c, true) && (equals || a16)) {
                F.t(nVar);
                z16 = true;
            }
        }
        if (a16) {
            com.tencent.mobileqq.filemanager.util.d.g(R.string.b7x);
        } else if (z16) {
            com.tencent.mobileqq.filemanager.util.d.g(R.string.b7z);
        } else {
            com.tencent.mobileqq.filemanager.util.d.c(R.string.b7y);
        }
    }

    private void i(List<n> list, com.tencent.mobileqq.filemanager.multioperate.c cVar) {
        if (!NetworkUtil.isNetSupport(this.f208655b)) {
            QQToast.makeText(this.f208655b, R.string.cjm, 1).show(this.f208655b.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            return;
        }
        Iterator<n> it = list.iterator();
        long j3 = 0;
        while (it.hasNext()) {
            j3 += it.next().f294918d;
        }
        TroopFileTransferManager.O(this.f208654a, this.f208656c);
        if (FileManagerUtil.is2GOr3G() && j3 > 3145728) {
            a aVar = new a(list, cVar);
            String string = this.f208655b.getString(R.string.emc);
            Activity activity = this.f208655b;
            DialogUtil.createCustomDialog(activity, 230, activity.getString(R.string.erp), string, R.string.cancel, R.string.ekq, aVar, aVar).show();
            return;
        }
        f(list);
        if (cVar != null) {
            cVar.a(1, 0);
        }
    }

    private void j(List<n> list) {
        if (!NetworkUtil.isNetSupport(this.f208655b)) {
            QQToast.makeText(this.f208655b, R.string.cjm, 1).show(this.f208655b.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            return;
        }
        Iterator<n> it = list.iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            t Y = QFileUtils.Y(this.f208654a, this.f208656c, it.next());
            if (Y != null) {
                z16 = QFileUtils.h(false, Y.f294976j, Y.f294985s);
            }
        }
        if (z16 && !((ITroopFileApi) QRoute.api(ITroopFileApi.class)).canUseMsgForwardOnTroopFile()) {
            FMDialogUtil.a(this.f208655b, R.string.b_v, R.string.f170958ba0, new b(list));
        } else {
            QFileUtils.C(this.f208654a, list, this.f208655b, this.f208656c);
        }
    }

    private void k(List<n> list) {
        if (!NetworkUtil.isNetSupport(this.f208655b)) {
            QQToast.makeText(this.f208655b, R.string.cjm, 1).show(this.f208655b.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            return;
        }
        Iterator<n> it = list.iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            t Y = QFileUtils.Y(this.f208654a, this.f208656c, it.next());
            if (Y != null) {
                z16 = QFileUtils.h(false, Y.f294976j, Y.f294985s);
            }
        }
        if (z16) {
            FMDialogUtil.a(this.f208655b, R.string.b_v, R.string.b_y, new c(list));
        } else {
            com.tencent.mobileqq.filemanager.util.d.d(this.f208655b.getString(R.string.f170978be3));
            TroopFileUtils.A(this.f208654a, this.f208656c, list);
        }
    }

    public void e(List<n> list, int i3, com.tencent.mobileqq.filemanager.multioperate.c cVar) {
        QLog.i("TroopFileMultiOperate", 1, "doFileMultiOperate. operateType[" + i3 + "]");
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList(list);
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 == 5) {
                                g(arrayList, cVar);
                                return;
                            }
                            return;
                        }
                        k(arrayList);
                        return;
                    }
                    h(arrayList, cVar);
                    return;
                }
                j(arrayList);
                return;
            }
            i(arrayList, cVar);
            return;
        }
        QLog.i("TroopFileMultiOperate", 1, "doFileMultiOperate. file list is null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements FMDialogUtil.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f208660a;

        b(List list) {
            this.f208660a = list;
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void b() {
            QFileUtils.C(d.this.f208654a, this.f208660a, d.this.f208655b, d.this.f208656c);
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c implements FMDialogUtil.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f208662a;

        c(List list) {
            this.f208662a = list;
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void b() {
            com.tencent.mobileqq.filemanager.util.d.d(d.this.f208655b.getString(R.string.f170978be3));
            TroopFileUtils.A(d.this.f208654a, d.this.f208656c, this.f208662a);
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void a() {
        }
    }
}

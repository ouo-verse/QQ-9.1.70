package com.tencent.mobileqq.troop.avatar;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopClipPic;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.avatar.TroopPhotoController;
import com.tencent.mobileqq.troop.avatar.TroopUploadingThread;
import com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.ITroopExtInfoDBApi;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import tencent.trpc.qqgroup.GroupFace$UploadRsp;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopAvatarController extends TroopPhotoController {
    static IPatchRedirector $redirector_;
    protected a X;
    protected a Y;
    protected TroopClipPic Z;

    /* renamed from: a0, reason: collision with root package name */
    private Boolean f294472a0;

    public TroopAvatarController(Context context, Activity activity, AppInterface appInterface, Bundle bundle) {
        super(context, activity, appInterface, bundle);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, activity, appInterface, bundle);
        } else {
            this.f294472a0 = Boolean.FALSE;
            this.K = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.troop.avatar.TroopPhotoController
    public void A(a aVar, TroopUploadingThread.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) aVar, (Object) bVar);
        } else {
            super.A(aVar, bVar);
        }
    }

    @Override // com.tencent.mobileqq.troop.avatar.TroopPhotoController
    public void B(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3);
        }
    }

    @Override // com.tencent.mobileqq.troop.avatar.TroopPhotoController
    public void F(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
        }
    }

    @Override // com.tencent.mobileqq.troop.avatar.TroopPhotoController
    public boolean G(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) str2)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.i("TroopPhotoController.TroopAvatarController", 2, String.format("onNewIntent clip=%s path=%s", str2, str));
        }
        if (k(str) || h(str, str2)) {
            return false;
        }
        TroopClipPic g16 = g(str, str2);
        a f16 = f(g16, "-1");
        ArrayList<g> e16 = this.C.e();
        if (e16 != null) {
            Iterator<g> it = e16.iterator();
            while (it.hasNext()) {
                g next = it.next();
                if (next != null && next.f294554e == 1) {
                    it.remove();
                }
            }
        }
        this.Y = f16;
        this.Z = g16;
        if (this.E != 2) {
            x();
        }
        R();
        ReportController.o(this.f294495m, "P_CliOper", "Grp_set", "", "Grp_moredata", "upload_head", 0, 0, this.f294493h.troopuin, "", "", "");
        return true;
    }

    @Override // com.tencent.mobileqq.troop.avatar.TroopPhotoController
    public void K(boolean z16) {
        a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("TroopPhotoController.TroopAvatarController", 2, String.format("onUpdateTroopAvatarWallList bServer=%b", Boolean.valueOf(z16)));
        }
        if (this.f294495m != null) {
            if (z16) {
                T();
            }
            TroopInfo troopInfo = this.f294493h;
            if (troopInfo != null) {
                boolean z17 = this.f294494i.hasSetNewTroopHead;
                int i3 = troopInfo.extDBInfo.avatarId;
                if (QLog.isColorLevel()) {
                    QLog.i("TroopPhotoController.TroopAvatarController", 2, String.format("onUpdateTroopAvatarWallList hasHead=%b id=%d", Boolean.valueOf(z17), Integer.valueOf(i3)));
                }
                a aVar2 = null;
                if (z17) {
                    if (i3 > 0) {
                        aVar = new a();
                        String valueOf = String.valueOf(i3);
                        aVar.f294530b = valueOf;
                        aVar.f294537i = 1;
                        aVar.f294531c = 1;
                        aVar.f294534f = this.f294493h.mTroopVerifyingPics.contains(valueOf);
                    } else {
                        aVar = null;
                    }
                    if (aVar == null) {
                        aVar = new a();
                        aVar.f294530b = a.f294527k;
                        aVar.f294537i = 1;
                        aVar.f294531c = 3;
                    }
                } else {
                    aVar = null;
                }
                ArrayList<g> e16 = this.C.e();
                if (e16 != null) {
                    Iterator<g> it = e16.iterator();
                    while (it.hasNext()) {
                        g next = it.next();
                        if (next != null && next.f294554e == 1) {
                            if (aVar2 != null) {
                                it.remove();
                            } else {
                                aVar2 = new a();
                                aVar2.f294529a = next.f294550a;
                                aVar2.f294532d = next.f294553d;
                                aVar2.f294537i = next.f294554e;
                                aVar2.f294531c = 2;
                                aVar2.f294533e = true;
                                aVar2.f294538j = next.f294555f;
                                aVar2.f294536h = next.f294556g;
                            }
                        }
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.i("TroopPhotoController.TroopAvatarController", 2, String.format("onUpdateTroopAvatarWallList uploadItems=%s", e16));
                }
                Runnable runnable = new Runnable(aVar, aVar2) { // from class: com.tencent.mobileqq.troop.avatar.TroopAvatarController.2
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ a f294476d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ a f294477e;

                    {
                        this.f294476d = aVar;
                        this.f294477e = aVar2;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, TroopAvatarController.this, aVar, aVar2);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        TroopAvatarController troopAvatarController = TroopAvatarController.this;
                        troopAvatarController.X = this.f294476d;
                        troopAvatarController.Y = this.f294477e;
                        troopAvatarController.x();
                    }
                };
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    runnable.run();
                } else {
                    this.F.post(runnable);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.avatar.TroopPhotoController
    public void R() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        L();
        ArrayList<TroopClipPic> arrayList = new ArrayList<>();
        arrayList.add(this.Z);
        com.tencent.mobileqq.troop.helper.a.c().k(arrayList, this.D, StatisticCollector.QTROOP_AVATAR_UPLOAD_STATISTIC_TAG);
    }

    @Override // com.tencent.mobileqq.troop.avatar.TroopPhotoController
    protected boolean S(int i3, a aVar) {
        ITroopInfoService iTroopInfoService;
        TroopInfo findTroopInfo;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, i3, (Object) aVar)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.i("TroopPhotoController.TroopAvatarController", 2, String.format("update2DB picId=%d info=%s", Integer.valueOf(i3), aVar));
        }
        if (this.E == 2) {
            return false;
        }
        a aVar2 = this.X;
        if (aVar2 != null) {
            String str = aVar2.f294530b;
            try {
                i16 = Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                i16 = -1;
            }
            if (str != null && i16 >= 0 && i16 == i3) {
                return false;
            }
        }
        HashSet hashSet = new HashSet();
        if (aVar.f294534f) {
            hashSet.add(aVar.f294530b);
        }
        AppInterface appInterface = this.f294495m;
        if (appInterface != null && (iTroopInfoService = (ITroopInfoService) appInterface.getRuntimeService(ITroopInfoService.class, "")) != null && (findTroopInfo = iTroopInfoService.findTroopInfo(String.valueOf(this.f294493h.troopuin))) != null) {
            findTroopInfo.extDBInfo.avatarId = i3;
            ((ITroopExtInfoDBApi) QRoute.api(ITroopExtInfoDBApi.class)).updateAvatarId(this.f294493h.troopuin, i3, "TroopPhotoController.TroopAvatarController");
            findTroopInfo.mTroopVerifyingPics.addAll(hashSet);
        }
        return true;
    }

    public void U() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.f294472a0 = Boolean.TRUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.troop.avatar.TroopPhotoController
    public boolean h(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) str2)).booleanValue();
        }
        if (this.f294472a0.booleanValue()) {
            return false;
        }
        return super.h(str, str2);
    }

    @Override // com.tencent.mobileqq.troop.avatar.TroopPhotoController
    public a l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (a) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        a aVar = this.Y;
        if (aVar != null) {
            return aVar;
        }
        return this.X;
    }

    @Override // com.tencent.mobileqq.troop.avatar.TroopPhotoController
    public List<a> n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (List) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.troop.avatar.TroopPhotoController
    protected Runnable p(GroupFace$UploadRsp groupFace$UploadRsp, a aVar, TroopUploadingThread.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Runnable) iPatchRedirector.redirect((short) 2, this, groupFace$UploadRsp, aVar, bVar);
        }
        return new Runnable(groupFace$UploadRsp, bVar, aVar) { // from class: com.tencent.mobileqq.troop.avatar.TroopAvatarController.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ GroupFace$UploadRsp f294473d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ TroopUploadingThread.b f294474e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ a f294475f;

            {
                this.f294473d = groupFace$UploadRsp;
                this.f294474e = bVar;
                this.f294475f = aVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, TroopAvatarController.this, groupFace$UploadRsp, bVar, aVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                int i3 = this.f294473d.seq.get();
                this.f294474e.f294522c = i3;
                a aVar2 = this.f294475f;
                aVar2.f294533e = false;
                aVar2.f294531c = 1;
                aVar2.f294534f = false;
                TroopAvatarController.this.t(aVar2);
                int i16 = i3 & Integer.MAX_VALUE;
                if (i16 < 0 || i16 > 1) {
                    this.f294475f.f294530b = String.valueOf(i16);
                    a aVar3 = this.f294475f;
                    aVar3.f294531c = 1;
                    aVar3.f294533e = false;
                    if (TroopAvatarController.this.S(this.f294474e.f294521b, aVar3)) {
                        TroopAvatarController.this.X = this.f294475f;
                    }
                    TroopAvatarController troopAvatarController = TroopAvatarController.this;
                    if (troopAvatarController.E == 2) {
                        troopAvatarController.X = this.f294475f;
                    }
                }
                TroopAvatarController troopAvatarController2 = TroopAvatarController.this;
                troopAvatarController2.Z = null;
                troopAvatarController2.Y = null;
                troopAvatarController2.A(this.f294475f, this.f294474e);
                TroopAvatarController.this.x();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.troop.avatar.TroopPhotoController
    public void q(FileMsg fileMsg, GroupFace$UploadRsp groupFace$UploadRsp, a aVar, TroopUploadingThread.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, fileMsg, groupFace$UploadRsp, aVar, bVar);
        } else {
            super.q(fileMsg, groupFace$UploadRsp, aVar, bVar);
            this.Y = null;
        }
    }

    @Override // com.tencent.mobileqq.troop.avatar.TroopPhotoController, java.util.Observer
    public void update(Observable observable, Object obj) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) observable, obj);
            return;
        }
        if (obj == null || !(obj instanceof TroopUploadingThread.b)) {
            return;
        }
        TroopUploadingThread.b bVar = (TroopUploadingThread.b) obj;
        if (bVar.f294524e != this.K) {
            return;
        }
        long j3 = bVar.f294523d;
        a aVar = this.Y;
        if (aVar != null && aVar.f294538j == j3) {
            int i3 = bVar.f294520a;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        ReportController.o(this.f294495m, "P_CliOper", "Grp_set", "", "Grp_Admin_data", "upload_head_cancel", 0, 0, this.f294493h.troopuin, String.valueOf(bVar.f294521b), "", "");
                        if (TextUtils.isEmpty(bVar.f294526g)) {
                            str = ((ITroopPhotoUtilsApi) QRoute.api(ITroopPhotoUtilsApi.class)).getErrText(this.f294491e, bVar.f294521b);
                        } else {
                            str = bVar.f294526g;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.i("TroopPhotoController.TroopAvatarController", 2, String.format("update() failed result=%d info=%s", Integer.valueOf(bVar.f294521b), aVar));
                        }
                        this.F.post(new Runnable(str) { // from class: com.tencent.mobileqq.troop.avatar.TroopAvatarController.5
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ String f294483d;

                            {
                                this.f294483d = str;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopAvatarController.this, (Object) str);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                    return;
                                }
                                TroopAvatarController troopAvatarController = TroopAvatarController.this;
                                troopAvatarController.C.g(troopAvatarController.f294493h.troopuin);
                                TroopAvatarController troopAvatarController2 = TroopAvatarController.this;
                                troopAvatarController2.Y = null;
                                if (troopAvatarController2.E != 2) {
                                    troopAvatarController2.x();
                                }
                                TroopPhotoController.P(this.f294483d);
                            }
                        });
                        return;
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("TroopPhotoController.TroopAvatarController", 2, String.format("update() suc state.result=%d newSeq=%d info=%s", Integer.valueOf(bVar.f294521b), Integer.valueOf(bVar.f294522c), aVar));
                }
                int i16 = bVar.f294521b;
                this.F.post(new Runnable(bVar, aVar, i16) { // from class: com.tencent.mobileqq.troop.avatar.TroopAvatarController.4
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ TroopUploadingThread.b f294480d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ a f294481e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ int f294482f;

                    {
                        this.f294480d = bVar;
                        this.f294481e = aVar;
                        this.f294482f = i16;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, TroopAvatarController.this, bVar, aVar, Integer.valueOf(i16));
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        int i17 = this.f294480d.f294522c;
                        a aVar2 = this.f294481e;
                        aVar2.f294533e = false;
                        aVar2.f294531c = 1;
                        aVar2.f294534f = false;
                        TroopAvatarController.this.t(aVar2);
                        int i18 = i17 & Integer.MAX_VALUE;
                        if (i18 < 0 || i18 > 1) {
                            this.f294481e.f294530b = String.valueOf(this.f294482f);
                            a aVar3 = this.f294481e;
                            aVar3.f294531c = 1;
                            aVar3.f294533e = false;
                            if (TroopAvatarController.this.S(this.f294482f, aVar3)) {
                                TroopAvatarController.this.X = this.f294481e;
                            }
                            TroopAvatarController troopAvatarController = TroopAvatarController.this;
                            if (troopAvatarController.E == 2) {
                                troopAvatarController.X = this.f294481e;
                            }
                        }
                        TroopAvatarController troopAvatarController2 = TroopAvatarController.this;
                        troopAvatarController2.Z = null;
                        troopAvatarController2.Y = null;
                        troopAvatarController2.A(this.f294481e, this.f294480d);
                        TroopAvatarController.this.x();
                    }
                });
                ((ITroopPhotoUtilsApi) QRoute.api(ITroopPhotoUtilsApi.class)).cacheFileFromLocal(i16, aVar.f294529a, this.f294493h.troopuin);
                return;
            }
            aVar.f294532d = bVar.f294521b;
            this.F.post(new Runnable(aVar, bVar) { // from class: com.tencent.mobileqq.troop.avatar.TroopAvatarController.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ a f294478d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ TroopUploadingThread.b f294479e;

                {
                    this.f294478d = aVar;
                    this.f294479e = bVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, TroopAvatarController.this, aVar, bVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        TroopAvatarController.this.A(this.f294478d, this.f294479e);
                    }
                }
            });
            return;
        }
        if (bVar.f294520a == 1) {
            this.C.g(this.f294493h.troopuin);
        }
    }

    @Override // com.tencent.mobileqq.troop.avatar.TroopPhotoController
    protected void w(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) aVar);
        }
    }

    @Override // com.tencent.mobileqq.troop.avatar.TroopPhotoController
    protected void x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        Iterator<TroopPhotoController.d> it = this.N.iterator();
        while (it.hasNext()) {
            it.next().B2();
        }
    }

    @Override // com.tencent.mobileqq.troop.avatar.TroopPhotoController
    protected void y(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) aVar);
        }
    }

    @Override // com.tencent.mobileqq.troop.avatar.TroopPhotoController
    protected void z(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        }
    }
}

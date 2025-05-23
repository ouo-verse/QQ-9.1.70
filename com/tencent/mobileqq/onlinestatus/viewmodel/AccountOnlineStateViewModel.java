package com.tencent.mobileqq.onlinestatus.viewmodel;

import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.DiyStatusEmoInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.onlinestatus.AutoReplyManagerImpl;
import com.tencent.mobileqq.onlinestatus.OnlineStatusFriendsPermissionItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker;
import com.tencent.mobileqq.onlinestatus.af;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.as;
import com.tencent.mobileqq.onlinestatus.au;
import com.tencent.mobileqq.onlinestatus.bv;
import com.tencent.mobileqq.onlinestatus.manager.OnlineStatusPermissionManager;
import com.tencent.mobileqq.onlinestatus.w;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.ICardHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class AccountOnlineStateViewModel extends com.tencent.mobileqq.mvvm.c<com.tencent.mobileqq.onlinestatus.repository.a> implements OnlineStatusPermissionManager.b {
    private MutableLiveData<List<AutoReplyText>> C;
    private MutableLiveData<Integer> D;
    private MutableLiveData<com.tencent.mobileqq.onlinestatus.model.h> E;
    private MutableLiveData<OnlineStatusPermissionChecker.OnlineStatusPermissionItem> F;
    private OnlineStatusPermissionChecker.OnlineStatusPermissionItem G;
    private com.tencent.mobileqq.onlinestatus.model.g H;
    private boolean I;
    private boolean J;
    private Handler K;

    /* renamed from: i, reason: collision with root package name */
    private MutableLiveData<com.tencent.mobileqq.onlinestatus.model.g> f256843i;

    /* renamed from: m, reason: collision with root package name */
    private MutableLiveData<com.tencent.mobileqq.onlinestatus.model.g> f256844m;

    public AccountOnlineStateViewModel(com.tencent.mobileqq.onlinestatus.repository.a aVar) {
        super(aVar);
        this.f256843i = new MutableLiveData<>();
        this.f256844m = new MutableLiveData<>();
        this.C = new MutableLiveData<>();
        this.D = new MutableLiveData<>();
        this.E = new MutableLiveData<>();
        this.F = new MutableLiveData<>();
        this.I = false;
        this.J = false;
        this.K = ThreadManagerV2.getUIHandlerV2();
    }

    @Override // com.tencent.mobileqq.onlinestatus.manager.OnlineStatusPermissionManager.b
    public void G6(OnlineStatusFriendsPermissionItem onlineStatusFriendsPermissionItem, List<Integer> list) {
        if (this.I) {
            this.F.setValue(OnlineStatusPermissionChecker.OnlineStatusPermissionItem.create(40001L, onlineStatusFriendsPermissionItem.allHasPermission, onlineStatusFriendsPermissionItem.permissionUins));
        }
    }

    public void M1(@Nullable com.tencent.mobileqq.onlinestatus.model.g gVar, AppInterface appInterface, AutoReplyText autoReplyText) {
        if (gVar == null) {
            return;
        }
        as.e(appInterface, gVar.f256022a, gVar.f256023b);
        as.c(appInterface, gVar.f256022a, gVar.f256023b, autoReplyText);
        int a16 = com.tencent.mobileqq.onlinestatus.utils.e.a(gVar.f256022a);
        if (a16 > 0) {
            bv.b("0X800B23A", a16);
        }
    }

    public boolean N1(au auVar, w wVar, AppInterface appInterface, DiyStatusEmoInfo diyStatusEmoInfo) {
        AppRuntime.Status i3 = af.C().i(auVar);
        IOnlineStatusService iOnlineStatusService = (IOnlineStatusService) appInterface.getRuntimeService(IOnlineStatusService.class, "");
        if (i3 != null && (!c2(auVar, i3) || auVar.f255489b == 2000)) {
            if (wVar != null) {
                g2(true);
                wVar.f(false, this.F.getValue());
            } else {
                long j3 = auVar.f255489b;
                if (j3 == 2000 && diyStatusEmoInfo != null) {
                    iOnlineStatusService.updateDiyOnlineStatus(i3, j3, diyStatusEmoInfo);
                } else {
                    iOnlineStatusService.updateOnlineStatus(i3, j3);
                }
                g2(true);
            }
        } else if (wVar != null) {
            g2(true);
            wVar.f(true, this.F.getValue());
        } else {
            W1().setValue(new com.tencent.mobileqq.onlinestatus.model.h(true, 0));
        }
        return false;
    }

    public MutableLiveData<List<AutoReplyText>> O1() {
        return this.C;
    }

    public MutableLiveData<Integer> P1() {
        return this.D;
    }

    public MutableLiveData<com.tencent.mobileqq.onlinestatus.model.g> Q1() {
        return this.f256843i;
    }

    public boolean R1() {
        return this.J;
    }

    public MutableLiveData<com.tencent.mobileqq.onlinestatus.model.g> S1() {
        return this.f256844m;
    }

    public com.tencent.mobileqq.onlinestatus.model.g T1() {
        return this.H;
    }

    public MutableLiveData<OnlineStatusPermissionChecker.OnlineStatusPermissionItem> U1() {
        return this.F;
    }

    public MutableLiveData<com.tencent.mobileqq.onlinestatus.model.h> W1() {
        return this.E;
    }

    public void X1(OnlineStatusPermissionChecker.OnlineStatusPermissionItem onlineStatusPermissionItem) {
        if (onlineStatusPermissionItem != null) {
            i2(onlineStatusPermissionItem);
            bv.b("0X800AF4A", 2);
        }
    }

    public void Z1(AppRuntime appRuntime) {
        this.C.setValue(((AutoReplyManagerImpl) ((IOnlineStatusManagerService) appRuntime.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(com.tencent.mobileqq.onlinestatus.manager.b.class)).B());
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.viewmodel.AccountOnlineStateViewModel.1
            @Override // java.lang.Runnable
            public void run() {
                ((ICardHandler) QRoute.api(ICardHandler.class)).getAutoReplyList();
            }
        });
    }

    public void a2() {
        ((com.tencent.mobileqq.onlinestatus.repository.a) this.mRepository).k();
    }

    public void b2(AppInterface appInterface, QBaseActivity qBaseActivity) {
        if (this.F.getValue() == null) {
            this.F.setValue((OnlineStatusPermissionChecker.OnlineStatusPermissionItem) qBaseActivity.getIntent().getSerializableExtra("online_status_permission_item"));
            if (this.F.getValue() == null) {
                OnlineStatusFriendsPermissionItem D = ((OnlineStatusPermissionManager) ((IOnlineStatusManagerService) appInterface.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(com.tencent.mobileqq.onlinestatus.manager.i.class)).D(40001L, false, this);
                if (D != null) {
                    this.I = false;
                    this.F.setValue(OnlineStatusPermissionChecker.OnlineStatusPermissionItem.create(40001L, D.allHasPermission, D.permissionUins));
                } else {
                    this.I = true;
                    this.F.setValue(OnlineStatusPermissionChecker.OnlineStatusPermissionItem.create(40001L, true, null));
                }
            } else {
                this.I = false;
            }
        } else {
            this.I = false;
        }
        if (this.F.getValue() != null) {
            this.F.getValue().filterNotFriend();
        }
    }

    public boolean c2(au auVar, AppRuntime.Status status) {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        AppRuntime.Status onlineStatus = ((IOnlineStatusService) waitAppRuntime.getRuntimeService(IOnlineStatusService.class, "")).getOnlineStatus();
        long M = af.C().M(waitAppRuntime);
        if (status == onlineStatus && M == auVar.f255489b) {
            return true;
        }
        return false;
    }

    public void d2(final boolean z16, final List<AutoReplyText> list) {
        Handler handler = this.K;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.viewmodel.AccountOnlineStateViewModel.2
                @Override // java.lang.Runnable
                public void run() {
                    if (z16) {
                        AccountOnlineStateViewModel.this.C.setValue(list);
                    } else {
                        QQToast.makeText(MobileQQ.sMobileQQ, 1, R.string.f170516tg, 1).show();
                    }
                }
            });
        }
    }

    public void e2(boolean z16, AppInterface appInterface, QBaseActivity qBaseActivity) {
        String str;
        if (QLog.isColorLevel()) {
            QLog.d("AccountOnlineStateViewModel", 2, "account_online_status_show_part!");
        }
        if (z16) {
            if (QLog.isColorLevel()) {
                Object[] objArr = new Object[2];
                objArr[0] = "account_online_status_show_part! mLastPartPermission:";
                if (this.G == null) {
                    str = "null";
                } else {
                    str = " not null";
                }
                objArr[1] = str;
                QLog.d("AccountOnlineStateViewModel", 2, objArr);
            }
            OnlineStatusPermissionChecker.OnlineStatusPermissionItem onlineStatusPermissionItem = this.G;
            if (onlineStatusPermissionItem == null) {
                OnlineStatusPermissionChecker.d(appInterface, qBaseActivity, this.F.getValue(), false);
            } else {
                this.F.setValue(onlineStatusPermissionItem);
            }
        } else {
            OnlineStatusPermissionChecker.d(appInterface, qBaseActivity, this.F.getValue(), false);
        }
        bv.b("0X800AF99", 2);
    }

    public void f2(au auVar) {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        AppRuntime.Status i3 = af.C().i(auVar);
        if (i3 != null && !c2(auVar, i3)) {
            g2(true);
            ((IOnlineStatusService) waitAppRuntime.getRuntimeService(IOnlineStatusService.class, "")).updateOnlineStatus(i3, auVar.f255489b);
        } else {
            this.E.setValue(new com.tencent.mobileqq.onlinestatus.model.h(true, 0));
        }
    }

    public void g2(boolean z16) {
        this.J = z16;
    }

    public void h2(com.tencent.mobileqq.onlinestatus.model.g gVar) {
        this.H = gVar;
    }

    public void i2(OnlineStatusPermissionChecker.OnlineStatusPermissionItem onlineStatusPermissionItem) {
        if (onlineStatusPermissionItem == null) {
            return;
        }
        if (this.F.getValue() != null && !this.F.getValue().isAllHasPermission()) {
            if (QLog.isColorLevel()) {
                QLog.d("AccountOnlineStateViewModel", 2, "account_online_status_show_all! mOnlinePermission is part");
            }
            this.G = this.F.getValue();
        }
        this.F.setValue(onlineStatusPermissionItem);
    }
}

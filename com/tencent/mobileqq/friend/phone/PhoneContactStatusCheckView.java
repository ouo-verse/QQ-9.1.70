package com.tencent.mobileqq.friend.phone;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.phone.DenyRunnable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QUITokenResUtil;
import java.lang.ref.WeakReference;

/* loaded from: classes33.dex */
public class PhoneContactStatusCheckView extends LinearLayout implements View.OnClickListener {
    private int C;
    private boolean D;
    private boolean E;
    private boolean F;
    private Handler G;

    /* renamed from: d, reason: collision with root package name */
    private TextView f211706d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f211707e;

    /* renamed from: f, reason: collision with root package name */
    private Context f211708f;

    /* renamed from: h, reason: collision with root package name */
    private QUIEmptyState f211709h;

    /* renamed from: i, reason: collision with root package name */
    private WeakReference<PhoneContactFragment> f211710i;

    /* renamed from: m, reason: collision with root package name */
    private Boolean f211711m;

    public PhoneContactStatusCheckView(Context context) {
        super(context);
        this.f211711m = null;
        this.C = 0;
        this.D = false;
        this.E = false;
        this.F = false;
        e(context);
    }

    private void d() {
        if (this.f211709h != null) {
            return;
        }
        QUIEmptyState build = new QUIEmptyState.Builder(this.f211708f).setImageType(9).setTitle(HardCodeUtil.qqStr(R.string.f173932uh)).setBackgroundColorType(0).setDesc(HardCodeUtil.qqStr(R.string.f173942ui)).setButton(HardCodeUtil.qqStr(R.string.f173872ub), this).setHalfScreenState(true).build();
        this.f211709h = build;
        build.setVisibility(8);
        addView(this.f211709h);
    }

    private void e(Context context) {
        this.f211708f = context;
        setOrientation(1);
        LayoutInflater.from(getContext()).inflate(QUITokenResUtil.getResId(R.layout.f168022p8, R.layout.edc), this);
        this.f211707e = (ImageView) findViewById(R.id.loading);
        this.f211706d = (TextView) findViewById(R.id.f164891b84);
        this.G = new Handler(Looper.getMainLooper());
        d();
    }

    public void a(QQAppInterface qQAppInterface) {
        this.f211711m = Boolean.valueOf(PermissionChecker.h().f());
    }

    public void f(boolean z16) {
        QUIEmptyState qUIEmptyState = this.f211709h;
        if (qUIEmptyState == null) {
            return;
        }
        qUIEmptyState.setImageView(0, 9, true);
    }

    public void g(QQAppInterface qQAppInterface, String str, String str2, int i3) {
        ReportController.o(qQAppInterface, str, "", "", str2, str2, i3, 0, "", "", "", "");
    }

    protected void i(final IPhoneContactService iPhoneContactService) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.friend.phone.PhoneContactStatusCheckView.2
            @Override // java.lang.Runnable
            public void run() {
                IPhoneContactService iPhoneContactService2 = iPhoneContactService;
                if (iPhoneContactService2 != null) {
                    iPhoneContactService2.uploadOrUpdateContact();
                    iPhoneContactService.setNeedUploadResultTip(true);
                }
            }
        }, 16, null, false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseActivity baseActivity;
        QQAppInterface qQAppInterface;
        WeakReference<PhoneContactFragment> weakReference = this.f211710i;
        PhoneContactFragment phoneContactFragment = weakReference == null ? null : weakReference.get();
        if (phoneContactFragment == null || (baseActivity = phoneContactFragment.getBaseActivity()) == null || (qQAppInterface = baseActivity.app) == null) {
            return;
        }
        final IPhoneContactService iPhoneContactService = (IPhoneContactService) qQAppInterface.getRuntimeService(IPhoneContactService.class, "");
        if (iPhoneContactService == null) {
            QLog.i("PhoneContactStatusCheckView", 1, "onClick CONTACT_MANAGER is null");
            return;
        }
        if (!NetworkUtil.isNetSupport(getContext())) {
            BaseApplication context = BaseApplication.getContext();
            QQToast.makeText(context, 1, R.string.cjm, 0).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            return;
        }
        int i3 = this.C;
        if (i3 == 1) {
            g(qQAppInterface, "dc00898", "0X8009F22", 0);
        } else if (i3 == 2) {
            g(qQAppInterface, "dc00898", "0X8009F26", 0);
        } else if (i3 == 3) {
            g(qQAppInterface, "dc00898", "0X8009F24", 0);
        } else if (i3 == 4) {
            g(qQAppInterface, "dc00898", "0X8009F22", 0);
        }
        int selfBindState = iPhoneContactService.getSelfBindState();
        if (QLog.isColorLevel()) {
            QLog.d("PhoneContactStatusCheckView", 2, "onClick phone contact state = " + selfBindState + ", has = " + this.f211711m);
        }
        if (!this.f211711m.booleanValue()) {
            PermissionChecker.e(baseActivity, new Runnable() { // from class: com.tencent.mobileqq.friend.phone.PhoneContactStatusCheckView.1
                @Override // java.lang.Runnable
                public void run() {
                    PhoneContactStatusCheckView.this.i(iPhoneContactService);
                }
            }, new DenyRunnable(baseActivity, new DenyRunnable.a(qQAppInterface)));
        } else {
            i(iPhoneContactService);
        }
    }

    public void setPhoneContactFragment(PhoneContactFragment phoneContactFragment) {
        this.f211710i = new WeakReference<>(phoneContactFragment);
    }

    public void c() {
        this.F = false;
        this.E = false;
        this.D = false;
    }

    public void h(boolean z16) {
        if (z16) {
            this.f211707e.setVisibility(0);
            Drawable drawable = this.f211707e.getDrawable();
            if (drawable instanceof AnimationDrawable) {
                ((AnimationDrawable) drawable).start();
                return;
            }
            return;
        }
        this.f211707e.setVisibility(8);
        Drawable drawable2 = this.f211707e.getDrawable();
        if (drawable2 instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable2).stop();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x0050, code lost:
    
        if (r5.isStopFindMatch != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x005c, code lost:
    
        if (r2.isBindNoneFriendListEmpty() != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x005e, code lost:
    
        r2 = 5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x007e, code lost:
    
        if (r2.isBindNoneFriendListEmpty() != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00ab, code lost:
    
        if (r2 != false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(QQAppInterface qQAppInterface) {
        int i3;
        IPhoneContactService iPhoneContactService = (IPhoneContactService) qQAppInterface.getRuntimeService(IPhoneContactService.class, "");
        if (iPhoneContactService == null) {
            QLog.e("PhoneContactStatusCheckView", 1, "checkPhoneStatus CONTACT_MANAGER get null.");
            return;
        }
        if (this.f211711m == null) {
            this.f211711m = Boolean.valueOf(PermissionChecker.h().g());
        }
        RespondQueryQQBindingStat selfBindInfo = iPhoneContactService.getSelfBindInfo();
        int selfBindState = iPhoneContactService.getSelfBindState();
        if (!this.f211711m.booleanValue()) {
            i3 = 4;
        } else if (selfBindState >= 9) {
            if (selfBindInfo != null) {
            }
            i3 = 0;
        } else if (selfBindState != 8) {
            if (selfBindState == 7) {
                i3 = 2;
            } else {
                if (selfBindState != 6 || iPhoneContactService.getSelfBindInfo().lastUsedFlag != 3) {
                    if (selfBindState != 2) {
                        if (selfBindState != 4) {
                            boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101715", false);
                            if (QLog.isColorLevel()) {
                                QLog.i("PhoneContactStatusCheckView", 2, "defaultHasPermission:" + isSwitchOn);
                            }
                        }
                    }
                    i3 = 0;
                }
                i3 = 3;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("PhoneContactStatusCheckView", 2, String.format("checkPhoneStatus [%s, %s, %s, %s]", Integer.valueOf(selfBindState), Integer.valueOf(i3), this.f211711m, selfBindInfo));
        }
        com.tencent.mobileqq.newfriend.config.a confBean = ((INewFriendService) qQAppInterface.getRuntimeService(INewFriendService.class)).getConfBean();
        if (i3 == 0) {
            setVisibility(8);
            h(false);
        } else if (i3 == 1) {
            setVisibility(0);
            h(false);
            this.f211706d.setVisibility(8);
            this.f211709h.setDesc(confBean.f254002f.f254005a);
            this.f211709h.setBtnText(confBean.f254002f.f254007c, 1);
            this.f211709h.setVisibility(0);
        } else if (i3 == 2) {
            setVisibility(0);
            h(false);
            this.f211706d.setVisibility(8);
            this.f211709h.setDesc(confBean.f254003g.f254005a);
            this.f211709h.setBtnText(confBean.f254003g.f254007c, 1);
            this.f211709h.setVisibility(0);
        } else if (i3 == 3) {
            setVisibility(0);
            h(false);
            this.f211706d.setVisibility(8);
            this.f211709h.setDesc(confBean.f254004h.f254005a);
            this.f211709h.setBtnText(confBean.f254004h.f254007c, 1);
            this.f211709h.setVisibility(0);
        } else if (i3 == 4) {
            setVisibility(0);
            h(false);
            this.f211706d.setVisibility(8);
            this.f211709h.setDesc(confBean.f254001e.f254005a);
            this.f211709h.setBtnText(confBean.f254001e.f254007c, 1);
            this.f211709h.setVisibility(0);
        } else if (i3 != 5) {
            setVisibility(8);
            h(false);
        } else {
            setVisibility(0);
            h(true);
            this.f211706d.setVisibility(0);
            this.f211706d.setText(HardCodeUtil.qqStr(R.string.p2i));
            this.f211709h.setVisibility(8);
        }
        if (this.C != i3) {
            this.C = i3;
        }
        int i16 = this.C;
        if (i16 == 1) {
            if (this.D) {
                return;
            }
            this.D = true;
            g(qQAppInterface, "dc00898", "0X8009F21", 0);
            return;
        }
        if (i16 == 2) {
            if (this.F) {
                return;
            }
            this.F = true;
            g(qQAppInterface, "dc00898", "0X8009F25", 0);
            return;
        }
        if (i16 != 3) {
            if (i16 == 4 && !this.E) {
                this.E = true;
                g(qQAppInterface, "dc00898", "0X8009F21", 0);
                return;
            }
            return;
        }
        if (this.F) {
            return;
        }
        this.F = true;
        g(qQAppInterface, "dc00898", "0X8009F23", 0);
    }

    public PhoneContactStatusCheckView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f211711m = null;
        this.C = 0;
        this.D = false;
        this.E = false;
        this.F = false;
        e(context);
    }

    public PhoneContactStatusCheckView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f211711m = null;
        this.C = 0;
        this.D = false;
        this.E = false;
        this.F = false;
        e(context);
    }
}

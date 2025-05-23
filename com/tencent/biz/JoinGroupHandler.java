package com.tencent.biz;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes2.dex */
public class JoinGroupHandler {

    /* renamed from: a, reason: collision with root package name */
    protected QQProgressDialog f78138a;

    /* renamed from: b, reason: collision with root package name */
    protected Context f78139b;

    /* renamed from: c, reason: collision with root package name */
    protected QQAppInterface f78140c;

    /* renamed from: d, reason: collision with root package name */
    protected String f78141d;

    /* renamed from: e, reason: collision with root package name */
    protected String f78142e;

    /* renamed from: f, reason: collision with root package name */
    protected b f78143f;

    /* renamed from: g, reason: collision with root package name */
    protected int f78144g;

    /* renamed from: h, reason: collision with root package name */
    protected long f78145h = 0;

    /* renamed from: i, reason: collision with root package name */
    protected Bundle f78146i = null;

    /* renamed from: j, reason: collision with root package name */
    protected Runnable f78147j = new Runnable() { // from class: com.tencent.biz.JoinGroupHandler.2
        @Override // java.lang.Runnable
        public void run() {
            QQProgressDialog qQProgressDialog = JoinGroupHandler.this.f78138a;
            if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
                JoinGroupHandler.this.f78138a.dismiss();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a implements DialogInterface.OnDismissListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            JoinGroupHandler.this.f78143f.a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface b {
        void a();

        void error();

        void success();
    }

    public JoinGroupHandler(Context context, QQAppInterface qQAppInterface, int i3, String str, b bVar) {
        this.f78139b = context;
        this.f78140c = qQAppInterface;
        this.f78144g = i3;
        this.f78142e = str;
        this.f78143f = bVar;
    }

    private void b(TroopInfo troopInfo) {
        short s16 = troopInfo.cGroupOption;
        if (s16 != 3) {
            Intent n3 = AddFriendLogicActivity.n3(this.f78139b, troopInfo.troopuin, troopInfo.troopname, s16, this.f78144g, troopInfo.joinTroopQuestion, troopInfo.joinTroopAnswer, null, this.f78142e, this.f78141d);
            Bundle bundle = this.f78146i;
            if (bundle != null) {
                n3.putExtras(bundle);
            }
            this.f78139b.startActivity(n3);
            this.f78143f.success();
            return;
        }
        f(R.string.i7i, 1);
        this.f78143f.error();
    }

    private void c(boolean z16) {
        try {
            QQProgressDialog qQProgressDialog = this.f78138a;
            if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
                long currentTimeMillis = System.currentTimeMillis() - this.f78145h;
                if (!z16 && currentTimeMillis < 1000) {
                    ThreadManagerV2.getUIHandlerV2().postDelayed(this.f78147j, 500L);
                } else {
                    this.f78138a.dismiss();
                }
            }
        } catch (Exception e16) {
            QLog.e("JoinGroupHandler", 1, e16, "hide Juhua");
        }
    }

    private void d(final long j3) {
        ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).fetchTroopInfoForJoinTroop(String.valueOf(j3), "JoinGroupHandler", null, false, new Function2() { // from class: com.tencent.biz.k
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit e16;
                e16 = JoinGroupHandler.this.e(j3, (Boolean) obj, (TroopInfo) obj2);
                return e16;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit e(long j3, Boolean bool, TroopInfo troopInfo) {
        c(false);
        if (bool.booleanValue()) {
            b(troopInfo);
            QLog.i("JoinGroupHandler", 1, "[joinGroup] success. troopUin:" + j3);
            return null;
        }
        f(R.string.he7, 1);
        this.f78143f.error();
        QLog.d("JoinGroupHandler", 1, "[joinGroup] failed. troopUin:" + j3);
        return null;
    }

    private void f(int i3, int i16) {
        new QQToastNotifier(this.f78139b).notifyUser(i3, this.f78139b.getResources().getDimensionPixelSize(R.dimen.title_bar_height), 0, i16);
    }

    private void j() {
        try {
            if (this.f78138a == null) {
                Context context = this.f78139b;
                QQProgressDialog qQProgressDialog = new QQProgressDialog(context, context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                this.f78138a = qQProgressDialog;
                qQProgressDialog.setMessage(R.string.cpr);
                this.f78138a.setBackAndSearchFilter(false);
                this.f78138a.setOnDismissListener(new a());
            }
            this.f78138a.show();
            this.f78145h = System.currentTimeMillis();
        } catch (Exception e16) {
            QLog.e("JoinGroupHandler", 1, e16, "show Juhua");
        }
    }

    public void h() {
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.f78147j);
        c(true);
    }

    public void i(Bundle bundle) {
        this.f78146i = bundle;
    }

    public void k(long j3, String str) {
        if (!NetworkUtil.isNetSupport(this.f78139b)) {
            f(R.string.f171137ci2, 0);
            this.f78143f.error();
        } else {
            if (0 == j3) {
                this.f78143f.error();
                return;
            }
            QLog.i("JoinGroupHandler", 1, "joinGroup uin: " + j3);
            this.f78141d = str;
            j();
            d(j3);
        }
    }

    public void g() {
    }
}

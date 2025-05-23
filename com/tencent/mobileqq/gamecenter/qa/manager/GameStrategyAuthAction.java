package com.tencent.mobileqq.gamecenter.qa.manager;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gamecenter.qa.data.GameStrategyAuthRequire;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import fe1.d;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GameStrategyAuthAction {

    /* renamed from: a, reason: collision with root package name */
    private final fe1.c f212528a;

    /* renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<String, ce1.a> f212529b;

    /* renamed from: c, reason: collision with root package name */
    private d f212530c = new a();

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a extends fe1.a {
        a() {
        }

        @Override // fe1.a, fe1.d
        public void onGetAuthRequire(long j3, String str, int i3, @Nullable GameStrategyAuthRequire gameStrategyAuthRequire) {
            if (j3 == 0) {
                GameStrategyAuthAction.this.d(str, true, gameStrategyAuthRequire);
            } else {
                GameStrategyAuthAction.this.d(str, false, null);
            }
        }

        @Override // fe1.a, fe1.d
        public void onGetAuthWhite(long j3, String str, int i3, boolean z16) {
            if (j3 != 0) {
                GameStrategyAuthAction.this.d(str, false, null);
            } else if (z16) {
                GameStrategyAuthAction.this.d(str, true, null);
            } else {
                GameStrategyAuthAction.this.f212528a.L(str, i3);
            }
        }
    }

    public GameStrategyAuthAction() {
        fe1.c cVar = new fe1.c();
        this.f212528a = cVar;
        this.f212529b = new ConcurrentHashMap<>();
        cVar.Z0(this.f212530c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final String str, final boolean z16, final GameStrategyAuthRequire gameStrategyAuthRequire) {
        Object[] objArr = new Object[6];
        boolean z17 = false;
        objArr[0] = "handleAuth isSuccess:";
        objArr[1] = Boolean.valueOf(z16);
        objArr[2] = ",channelId:";
        objArr[3] = str;
        objArr[4] = ",canJoinAnswer:";
        if (gameStrategyAuthRequire != null && gameStrategyAuthRequire.canJoinAnswer) {
            z17 = true;
        }
        objArr[5] = Boolean.valueOf(z17);
        QLog.d("GameStrategyAuthAction", 1, objArr);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.manager.GameStrategyAuthAction.2
            @Override // java.lang.Runnable
            public void run() {
                ce1.a aVar = (ce1.a) GameStrategyAuthAction.this.f212529b.get(str);
                if (aVar == null) {
                    QLog.e("GameStrategyAuthAction", 1, "handleAuth listener is null");
                    return;
                }
                if (!z16) {
                    QQToast.makeText(BaseApplication.getContext(), 0, "\u8df3\u8f6c\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5\uff5e", 1);
                    aVar.a(false, false, null);
                    return;
                }
                GameStrategyAuthRequire gameStrategyAuthRequire2 = gameStrategyAuthRequire;
                if (gameStrategyAuthRequire2 != null && gameStrategyAuthRequire2.canJoinAnswer) {
                    aVar.a(true, true, gameStrategyAuthRequire2);
                } else {
                    aVar.a(true, false, null);
                }
                GameStrategyAuthAction.this.f212529b.remove(str);
            }
        });
    }

    public void e() {
        this.f212529b.clear();
        this.f212528a.N0();
    }

    public void f(String str, int i3, ce1.a aVar) {
        this.f212528a.M(str, i3);
        if (aVar != null) {
            this.f212529b.put(str, aVar);
        }
    }
}

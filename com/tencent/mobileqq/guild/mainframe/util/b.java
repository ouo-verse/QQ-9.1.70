package com.tencent.mobileqq.guild.mainframe.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import vh2.n;

/* compiled from: P */
/* loaded from: classes14.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private String f227699a;

    /* renamed from: b, reason: collision with root package name */
    private String f227700b;

    /* renamed from: c, reason: collision with root package name */
    private long f227701c;

    /* renamed from: d, reason: collision with root package name */
    private n f227702d;

    /* renamed from: e, reason: collision with root package name */
    private final MqqHandler f227703e = new MqqHandler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.tencent.mobileqq.guild.mainframe.util.a
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            boolean f16;
            f16 = b.this.f(message);
            return f16;
        }
    });

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a implements n {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ n f227704a;

        a(n nVar) {
            this.f227704a = nVar;
        }

        @Override // vh2.n
        public void a(int i3, String str, IGProChannelInfo iGProChannelInfo) {
            this.f227704a.a(i3, str, iGProChannelInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.guild.mainframe.util.b$b, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public class C7828b implements n {
        C7828b() {
        }

        @Override // vh2.n
        public void a(int i3, String str, IGProChannelInfo iGProChannelInfo) {
            b.this.f227703e.removeMessages(1);
            if (b.this.f227702d != null) {
                b.this.f227702d.a(i3, str, iGProChannelInfo);
            }
        }
    }

    public b(String str, String str2, long j3) {
        this.f227699a = str;
        this.f227700b = str2;
        this.f227701c = j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean f(Message message) {
        if (message.what == 1) {
            this.f227702d.a(-1, "\u7f51\u7edc\u4e0d\u7ed9\u529b\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", null);
            this.f227702d = null;
            return false;
        }
        return false;
    }

    public void d(int i3, @NonNull n nVar) {
        if (this.f227703e.hasMessages(1)) {
            QLog.w("Guild.MF.GuildChannelListTimeoutWrapper", 1, "the helper is working!!");
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.w("Guild.MF.GuildChannelListTimeoutWrapper", 1, "appRuntime is null");
            return;
        }
        IGPSService iGPSService = (IGPSService) peekAppRuntime.getRuntimeService(IGPSService.class, "");
        long j3 = this.f227701c;
        if (j3 <= 0) {
            iGPSService.fetchChannelInfoWithCategory(this.f227699a, this.f227700b, i3, new a(nVar));
            return;
        }
        this.f227702d = nVar;
        this.f227703e.sendEmptyMessageDelayed(1, j3);
        iGPSService.fetchChannelInfoWithCategory(this.f227699a, this.f227700b, i3, new C7828b());
    }

    public void e(@NonNull n nVar) {
        d(100, nVar);
    }
}

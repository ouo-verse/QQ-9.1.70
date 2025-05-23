package pq1;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.avbiz.Constants;
import com.tencent.mobileqq.guild.config.QQGuildMCParser;
import com.tencent.mobileqq.guild.util.h;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes14.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private boolean f426992a = false;

    /* renamed from: b, reason: collision with root package name */
    private boolean f426993b = false;

    /* renamed from: c, reason: collision with root package name */
    private long f426994c = 0;

    /* renamed from: d, reason: collision with root package name */
    private int f426995d = 15000;

    /* renamed from: e, reason: collision with root package name */
    private Handler f426996e = new Handler();

    /* renamed from: f, reason: collision with root package name */
    Runnable f426997f = new Runnable() { // from class: pq1.b
        @Override // java.lang.Runnable
        public final void run() {
            c.this.e();
        }
    };

    private void b(long j3) {
        QLog.e("QGL.HttpDns_req", 4, "doStartGetIpForLive delayMs:" + j3);
        if (j3 <= 0) {
            if (!d()) {
                return;
            }
            this.f426996e.removeCallbacks(this.f426997f);
            if (c()) {
                this.f426996e.postDelayed(this.f426997f, this.f426995d);
                QLog.e("QGL.HttpDns_req", 4, "\u97f3\u89c6\u9891\u7126\u70b9\u88ab\u5360\u636e");
                return;
            }
            QQGuildMCParser.Companion companion = QQGuildMCParser.INSTANCE;
            String f16 = companion.f("100535", "LiveDomain", "");
            this.f426995d = companion.d("100535", "RequestInterval", -1) * 1000;
            vq1.a.a(f16);
            this.f426996e.postDelayed(this.f426997f, this.f426995d);
            this.f426994c = System.currentTimeMillis();
            return;
        }
        QLog.e("QGL.HttpDns_req", 4, "\u5ef6\u8fdf\u8bf7\u6c42\u540e\u53f0\u63a5\u53e3\uff1a" + j3);
        this.f426996e.postDelayed(this.f426997f, j3);
    }

    private static boolean c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Constants.Business.SYSTEM_PHONE);
        arrayList.add(Constants.Business.QQ_RTC);
        if (h.c(Constants.Business.QQ_GUILD_LIVE_VIEWER, arrayList)) {
            return true;
        }
        arrayList.clear();
        arrayList.add(Constants.Business.QQ_GUILD);
        if (h.c(Constants.Business.QQ_GUILD_LIVE_VIEWER, arrayList)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void e() {
        if (this.f426992a && this.f426993b) {
            b(this.f426995d - (System.currentTimeMillis() - this.f426994c));
        }
    }

    private void j() {
        this.f426996e.removeCallbacks(this.f426997f);
    }

    public boolean d() {
        QQGuildMCParser.Companion companion = QQGuildMCParser.INSTANCE;
        Boolean valueOf = Boolean.valueOf(companion.c("100535", "enableLiveSupportLocalDns", false));
        String f16 = companion.f("100535", "LiveDomain", "");
        int d16 = companion.d("100535", "RequestInterval", -1);
        if (!valueOf.booleanValue() || TextUtils.isEmpty(f16) || d16 == -1) {
            return false;
        }
        return true;
    }

    public void f(boolean z16) {
        if (this.f426993b == z16) {
            return;
        }
        this.f426993b = z16;
        if (z16) {
            e();
        } else {
            j();
        }
    }

    public void g(boolean z16) {
        if (this.f426992a == z16) {
            return;
        }
        this.f426992a = z16;
        if (z16) {
            e();
        } else {
            j();
        }
    }

    public void h(boolean z16) {
        j();
        if (z16) {
            b(0L);
        }
    }
}

package com.tencent.mobileqq.richmediabrowser;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.RichMediaBrowserConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import cooperation.peak.PeakConstants;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private boolean f281805a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f281806b;

    /* renamed from: c, reason: collision with root package name */
    private String f281807c;

    /* renamed from: d, reason: collision with root package name */
    private String f281808d;

    /* renamed from: e, reason: collision with root package name */
    private String f281809e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f281810f;

    /* renamed from: g, reason: collision with root package name */
    private long f281811g;

    /* renamed from: h, reason: collision with root package name */
    private int f281812h;

    /* renamed from: i, reason: collision with root package name */
    private String f281813i;

    /* renamed from: j, reason: collision with root package name */
    private String f281814j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f281815k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f281816l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f281817m;

    /* renamed from: n, reason: collision with root package name */
    private int f281818n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f281819o;

    /* renamed from: p, reason: collision with root package name */
    protected int f281820p;

    /* renamed from: q, reason: collision with root package name */
    private int f281821q;

    /* renamed from: r, reason: collision with root package name */
    private int f281822r;

    /* renamed from: s, reason: collision with root package name */
    boolean f281823s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f281824t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f281825u;

    /* renamed from: v, reason: collision with root package name */
    public Rect f281826v;

    /* renamed from: w, reason: collision with root package name */
    public long f281827w;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final h f281828a = new h();
    }

    public static h a() {
        return b.f281828a;
    }

    public int b() {
        return this.f281818n;
    }

    public int c() {
        return this.f281820p;
    }

    public Rect d() {
        return this.f281826v;
    }

    public int e() {
        return this.f281821q;
    }

    public int f() {
        return this.f281812h;
    }

    public String g() {
        return this.f281813i;
    }

    public String h() {
        return this.f281808d;
    }

    public String i() {
        if (TextUtils.isEmpty(this.f281807c)) {
            this.f281807c = this.f281813i;
        }
        return this.f281807c;
    }

    public String j() {
        return this.f281809e;
    }

    public int k() {
        return this.f281822r;
    }

    public long l() {
        return this.f281811g;
    }

    public String m() {
        return this.f281814j;
    }

    public void n(Intent intent) {
        boolean z16;
        Bundle extras = intent.getExtras();
        this.f281805a = extras.getBoolean(RichMediaBrowserConstants.IS_APP_SHARE_PIC, false);
        this.f281806b = extras.getBoolean(RichMediaBrowserConstants.EXTRA_ISAPOLLO);
        this.f281807c = extras.getString(((IBrowserDepend) QRoute.api(IBrowserDepend.class)).getExtraGroupUin());
        this.f281808d = extras.getString(((IBrowserDepend) QRoute.api(IBrowserDepend.class)).getExtraGroupCode());
        this.f281809e = extras.getString(((IBrowserDepend) QRoute.api(IBrowserDepend.class)).getExtraGuildId());
        this.f281810f = extras.getBoolean(((IBrowserDepend) QRoute.api(IBrowserDepend.class)).getExtraMutilMsg());
        this.f281811g = extras.getLong(PeakConstants.KEY_MULTI_FORWARD_SEQ, 0L);
        this.f281812h = extras.getInt(AppConstants.Key.FORWARD_SOURCE_UIN_TYPE, -1);
        this.f281813i = extras.getString("uin");
        if (MobileQQ.sMobileQQ.peekAppRuntime() != null) {
            this.f281814j = MobileQQ.sMobileQQ.peekAppRuntime().getAccount();
        }
        this.f281815k = !TextUtils.isEmpty(extras.getString(AppConstants.Key.KEY_BABYQ_VIDEO_TYPE));
        int i3 = extras.getInt(RichMediaBrowserConstants.INTERNAL_EXTRA_ENTRANCE);
        this.f281820p = i3;
        if (!this.f281806b && i3 != 4 && !extras.getBoolean(ShortVideoConstants.IS_ONE_ITEM)) {
            z16 = false;
        } else {
            z16 = true;
        }
        this.f281816l = z16;
        this.f281817m = extras.getBoolean(RichMediaBrowserConstants.INTERNAL_EXTRA_FORBID_FETCH_ALL_IMAGE, false);
        this.f281818n = intent.getBooleanExtra(RichMediaBrowserConstants.EXTRA_IS_FROM_CHAT_FILE_HISTORY, false) ? 1 : 0;
        this.f281821q = extras.getInt(RichMediaBrowserConstants.EXTRA_AIO_CURRENT_PANEL_STATE, -3321);
        this.f281822r = extras.getInt(RichMediaBrowserConstants.EXTRA_MOBILE_QQ_PROCESS_ID, Integer.MIN_VALUE);
        this.f281819o = extras.getBoolean(RichMediaBrowserConstants.EXTRA_IS_FROM_CHAT_FILE_HISTORY, false);
        this.f281823s = extras.getBoolean(ShortVideoConstants.IS_REPLYMSG_FROM_SAME_SESSION, true);
        this.f281825u = extras.getBoolean(RichMediaBrowserConstants.EXTRA_IS_REPLY_SRC_MSG_EXIST, true);
        this.f281824t = extras.getBoolean(RichMediaBrowserConstants.EXTRA_IS_MIXED_MSG);
        this.f281827w = intent.getLongExtra(((IBrowserDepend) QRoute.api(IBrowserDepend.class)).getExtraSeekPos(), 0L);
    }

    public boolean o() {
        return this.f281806b;
    }

    public boolean p() {
        return this.f281817m;
    }

    public boolean q() {
        return this.f281810f;
    }

    public boolean r() {
        if (this.f281823s && this.f281812h != -1) {
            return true;
        }
        return false;
    }

    public boolean s() {
        return this.f281805a;
    }

    public boolean t() {
        return this.f281823s;
    }

    public boolean u() {
        return this.f281816l;
    }

    public boolean v() {
        return this.f281819o;
    }

    public void w(Rect rect) {
        this.f281826v = rect;
    }

    h() {
        this.f281805a = false;
        this.f281806b = false;
        this.f281810f = false;
        this.f281811g = 0L;
        this.f281816l = false;
        this.f281817m = false;
        this.f281820p = -1;
        this.f281823s = true;
        this.f281825u = true;
        this.f281827w = 0L;
    }
}

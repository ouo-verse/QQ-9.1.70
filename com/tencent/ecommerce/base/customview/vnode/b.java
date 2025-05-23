package com.tencent.ecommerce.base.customview.vnode;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.customview.view.PTSTimerTextView;
import com.tencent.ecommerce.base.ticket.api.IECTicketManager;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.PTSNodeAttributeConstant;
import com.tencent.pts.ui.vnode.PTSNodeText;
import com.tencent.pts.ui.vnode.PTSNodeVirtual;
import com.tencent.pts.utils.e;
import java.lang.ref.WeakReference;
import java.util.Calendar;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b extends PTSNodeText {

    /* renamed from: a, reason: collision with root package name */
    private final String f100664a;

    /* renamed from: b, reason: collision with root package name */
    private int f100665b;

    /* renamed from: c, reason: collision with root package name */
    private final int f100666c;

    /* renamed from: d, reason: collision with root package name */
    private final int f100667d;

    /* renamed from: e, reason: collision with root package name */
    private long f100668e;

    /* renamed from: f, reason: collision with root package name */
    private long f100669f;

    /* renamed from: g, reason: collision with root package name */
    private long f100670g;

    /* renamed from: h, reason: collision with root package name */
    private long f100671h;

    /* renamed from: i, reason: collision with root package name */
    private long f100672i;

    /* renamed from: j, reason: collision with root package name */
    private long f100673j;

    /* renamed from: k, reason: collision with root package name */
    private long f100674k;

    /* renamed from: l, reason: collision with root package name */
    private long f100675l;

    /* renamed from: m, reason: collision with root package name */
    private long f100676m;

    /* renamed from: n, reason: collision with root package name */
    private long f100677n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f100678o;

    /* renamed from: p, reason: collision with root package name */
    private IECTicketManager f100679p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f100680q;

    /* renamed from: r, reason: collision with root package name */
    private PTSTimerRunnable f100681r;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class a implements PTSNodeVirtual.a {
        @Override // com.tencent.pts.ui.vnode.PTSNodeVirtual.a
        public View buildNativeView(Context context, PTSNodeVirtual pTSNodeVirtual) {
            return new PTSTimerTextView((b) pTSNodeVirtual);
        }

        @Override // com.tencent.pts.ui.vnode.PTSNodeVirtual.a
        public PTSNodeVirtual buildNodeVirtual(PTSAppInstance pTSAppInstance) {
            return new b(pTSAppInstance);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.ecommerce.base.customview.vnode.b$b, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public static class C1027b implements IPTTimerTextCallback {

        /* renamed from: a, reason: collision with root package name */
        WeakReference<b> f100682a;

        public C1027b(b bVar) {
            this.f100682a = new WeakReference<>(bVar);
        }

        @Override // com.tencent.ecommerce.base.customview.vnode.IPTTimerTextCallback
        public boolean onContentUpdate() {
            b bVar = this.f100682a.get();
            if (bVar == null || bVar.getContext() == null) {
                return false;
            }
            bVar.setTextWithSpannableString(bVar.d());
            return true;
        }

        @Override // com.tencent.ecommerce.base.customview.vnode.IPTTimerTextCallback
        public void onTimerEnd() {
            b bVar = this.f100682a.get();
            if (bVar != null) {
                bVar.i(Boolean.FALSE, Boolean.TRUE);
            }
        }

        @Override // com.tencent.ecommerce.base.customview.vnode.IPTTimerTextCallback
        public void onTimerStart() {
            b bVar = this.f100682a.get();
            if (bVar != null) {
                bVar.i(Boolean.TRUE, Boolean.FALSE);
            }
        }
    }

    public b(PTSAppInstance pTSAppInstance) {
        super(pTSAppInstance);
        this.f100664a = "PTSNodeTimerText";
        this.f100665b = 1;
        this.f100666c = Color.parseColor("#26FFFFFF");
        this.f100667d = Color.parseColor("#00FFFFFF");
        this.f100668e = 0L;
        this.f100669f = 0L;
        this.f100670g = 0L;
        this.f100671h = 0L;
        this.f100672i = 0L;
        this.f100673j = 0L;
        this.f100674k = 0L;
        this.f100675l = 0L;
        this.f100676m = 0L;
        this.f100677n = 0L;
        this.f100678o = false;
        this.f100680q = false;
        try {
            this.f100679p = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getTicket();
        } catch (Exception e16) {
            cg0.a.a("PTSNodeTimerText", "PTSNodeTimerText", "[PTSNodeTimerText] get ticket manager error = " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SpannableStringBuilder d() {
        String format;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.f100668e) {
            return new SpannableStringBuilder(String.format("%s\u6708%s\u65e5 %s:%s \u5f00\u552e", e(this.f100670g), e(this.f100671h), e(this.f100672i), e(this.f100673j)));
        }
        if (currentTimeMillis > this.f100669f) {
            return new SpannableStringBuilder("\u6d3b\u52a8\u5df2\u7ed3\u675f");
        }
        f();
        String e16 = e(this.f100674k);
        String e17 = e(this.f100675l);
        String e18 = e(this.f100676m);
        String e19 = e(this.f100677n);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(" ");
        int i3 = this.f100665b;
        if (i3 == 1) {
            if (this.f100674k > 0) {
                format = String.format("\u6d3b\u52a8\u5269\u4f59 %s\u5929%s:%s:%s", e16, e17, e18, e19);
            } else {
                format = String.format("\u6d3b\u52a8\u5269\u4f59 %s:%s:%s", e17, e18, e19);
            }
            return new SpannableStringBuilder(format);
        }
        if (i3 != 2) {
            return spannableStringBuilder;
        }
        if (this.f100674k > 0) {
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(e16 + "\u5929");
            j(0, e16.length(), this.f100666c, spannableStringBuilder2);
            j(e16.length(), e16.length() + 1, this.f100667d, spannableStringBuilder2);
            spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
        }
        SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(e17 + ":" + e18 + ":" + e19);
        j(0, 2, this.f100666c, spannableStringBuilder3);
        k(2, 3, this.f100667d, spannableStringBuilder3);
        j(3, 5, this.f100666c, spannableStringBuilder3);
        k(5, 6, this.f100667d, spannableStringBuilder3);
        j(6, 8, this.f100666c, spannableStringBuilder3);
        spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
        return spannableStringBuilder;
    }

    private void f() {
        long serverTimeMillis;
        IECTicketManager iECTicketManager = this.f100679p;
        if (iECTicketManager == null) {
            serverTimeMillis = System.currentTimeMillis();
        } else {
            serverTimeMillis = iECTicketManager.getServerTimeMillis();
        }
        if (serverTimeMillis > this.f100669f) {
            if (this.f100678o) {
                i(Boolean.FALSE, Boolean.TRUE);
            }
            this.f100678o = false;
        }
        long j3 = (this.f100669f - serverTimeMillis) / 1000;
        this.f100674k = j3 / 86400;
        long j16 = j3 % 86400;
        this.f100675l = j16 / 3600;
        long j17 = j16 % 3600;
        this.f100676m = j17 / 60;
        this.f100677n = j17 % 60;
    }

    private void g() {
        if (this.f100681r == null) {
            this.f100681r = new PTSTimerRunnable(this.f100668e, this.f100669f, 1000L, new C1027b(this));
        }
    }

    private void h() {
        Calendar.getInstance().setTimeInMillis(this.f100668e);
        this.f100670g = r0.get(2) + 1;
        this.f100671h = r0.get(5);
        this.f100672i = r0.get(11);
        this.f100673j = r0.get(12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(Boolean bool, Boolean bool2) {
        Context context = getContext();
        if (context != null) {
            Intent intent = new Intent("com.tencent.pts.broadcast.countdown.end");
            if (bool.booleanValue()) {
                intent.putExtra("startCount", true);
            } else if (bool2.booleanValue()) {
                intent.putExtra("endCount", true);
            }
            cg0.a.b("PTSNodeTimerText", "[sendBroadcast] isStartCount = " + bool + " isEndCount = " + bool2);
            context.sendBroadcast(intent);
        }
    }

    private void j(int i3, int i16, int i17, SpannableStringBuilder spannableStringBuilder) {
        spannableStringBuilder.setSpan(new e(i17, getForegroundColor(), 10.0f, 10.0f, 5.0f, 5.0f, 6.0f, getFontSize()), i3, i16, 33);
    }

    private void k(int i3, int i16, int i17, SpannableStringBuilder spannableStringBuilder) {
        spannableStringBuilder.setSpan(new e(i17, getForegroundColor(), 5.0f, 5.0f, 2.0f, 2.0f, 6.0f, getFontSize()), i3, i16, 33);
    }

    @Override // com.tencent.pts.ui.vnode.PTSNodeTextBase, com.tencent.pts.ui.vnode.PTSNodeVirtual
    public void onParseValueFinished() {
        super.onParseValueFinished();
        super.setTextContent("");
        long j3 = this.f100668e;
        if (j3 == 0 && this.f100669f == 0) {
            return;
        }
        if (this.f100680q && j3 != 0) {
            super.setTextContent(String.format("%s\u6708%s\u65e5 %s:%s \u5f00\u552e", e(this.f100670g), e(this.f100671h), e(this.f100672i), e(this.f100673j)));
        } else {
            g();
        }
    }

    @Override // com.tencent.pts.ui.vnode.PTSNodeTextBase, com.tencent.pts.ui.vnode.PTSNodeVirtual
    protected boolean setContent(String str) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.pts.ui.vnode.PTSNodeTextBase, com.tencent.pts.ui.vnode.PTSNodeVirtual
    public boolean setAttribute(String str, Object obj) {
        if (str == null || str.equals("")) {
            return false;
        }
        if (str.equalsIgnoreCase(PTSNodeAttributeConstant.TIMER_STYLE)) {
            if ((obj instanceof String) && !obj.equals("")) {
                try {
                    this.f100665b = Integer.parseInt((String) obj);
                } catch (Exception e16) {
                    cg0.a.a("PTSNodeTimerText", "setAttribute", "[setAttribute] parse card type error = " + e16);
                }
            }
            return true;
        }
        if (str.equalsIgnoreCase(PTSNodeAttributeConstant.START_TIMESTAMP)) {
            if ((obj instanceof String) && !obj.equals("")) {
                try {
                    this.f100668e = Long.parseLong((String) obj) * 1000;
                    h();
                } catch (Exception e17) {
                    cg0.a.a("PTSNodeTimerText", "setAttribute", "[setAttribute] parse start time error = " + e17);
                }
            }
            return true;
        }
        if (str.equalsIgnoreCase(PTSNodeAttributeConstant.END_TIMESTAMP)) {
            if ((obj instanceof String) && !obj.equals("")) {
                try {
                    this.f100669f = Long.parseLong((String) obj) * 1000;
                    f();
                } catch (Exception e18) {
                    cg0.a.a("PTSNodeTimerText", "setAttribute", "[setAttribute] parse end time error = " + e18);
                }
            }
            return true;
        }
        if (str.equalsIgnoreCase("freeze-time")) {
            if (obj instanceof String) {
                try {
                    if (String.valueOf(obj).equals("1")) {
                        this.f100680q = true;
                    }
                } catch (Exception e19) {
                    cg0.a.a("PTSNodeTimerText", "setAttribute", "[setAttribute] parse freeze time tag error = " + e19);
                }
            }
            return true;
        }
        return super.setAttribute(str, obj);
    }

    private String e(long j3) {
        if (j3 < 10) {
            return "0" + j3;
        }
        return String.valueOf(j3);
    }
}

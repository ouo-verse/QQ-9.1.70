package com.tencent.mobileqq.openapi.sdk;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;

/* compiled from: P */
/* loaded from: classes16.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name */
    public static final String f256952k;

    /* renamed from: l, reason: collision with root package name */
    public static final String f256953l;

    /* renamed from: m, reason: collision with root package name */
    public static final String f256954m;

    /* renamed from: n, reason: collision with root package name */
    public static final String f256955n;

    /* renamed from: o, reason: collision with root package name */
    public static final String f256956o;

    /* renamed from: p, reason: collision with root package name */
    public static final String f256957p;

    /* renamed from: q, reason: collision with root package name */
    public static final String[] f256958q;

    /* renamed from: a, reason: collision with root package name */
    public String f256959a;

    /* renamed from: b, reason: collision with root package name */
    public int f256960b;

    /* renamed from: c, reason: collision with root package name */
    public String f256961c;

    /* renamed from: d, reason: collision with root package name */
    public int f256962d;

    /* renamed from: e, reason: collision with root package name */
    public String f256963e;

    /* renamed from: f, reason: collision with root package name */
    public long f256964f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f256965g;

    /* renamed from: h, reason: collision with root package name */
    public String f256966h;

    /* renamed from: i, reason: collision with root package name */
    public int f256967i;

    /* renamed from: j, reason: collision with root package name */
    public String f256968j;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73473);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f256952k = HardCodeUtil.qqStr(R.string.o2s);
        f256953l = HardCodeUtil.qqStr(R.string.o2r);
        f256954m = HardCodeUtil.qqStr(R.string.o2q);
        f256955n = HardCodeUtil.qqStr(R.string.o2u);
        f256956o = HardCodeUtil.qqStr(R.string.o2t);
        f256957p = HardCodeUtil.qqStr(R.string.o2v);
        f256958q = new String[]{"uin", IPublicAccountBrowser.KEY_UIN_TYPE, AppConstants.Key.COLUMN_MSG_SENDER_UIN, QQHealthReportApiImpl.MSG_TYPE_KEY, "msgid", "msgTime", QQBrowserActivity.KEY_IS_SEND, RemoteMessageConst.MessageBody.MSG_CONTENT, "media_path", "mediaStatus"};
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public Object[] a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Object[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new Object[]{this.f256959a, Integer.valueOf(this.f256960b), this.f256961c, Integer.valueOf(this.f256962d), this.f256963e, Long.valueOf(this.f256964f), Boolean.valueOf(this.f256965g), this.f256966h, this.f256968j, Integer.valueOf(this.f256967i)};
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder(200);
        sb5.append(this.f256959a);
        sb5.append("; ");
        sb5.append(this.f256962d);
        sb5.append("; ");
        sb5.append(this.f256961c);
        sb5.append("; ");
        sb5.append(this.f256963e);
        sb5.append("; ");
        sb5.append(this.f256964f);
        sb5.append(";");
        sb5.append(this.f256965g);
        sb5.append("; ");
        sb5.append(this.f256966h);
        sb5.append("; ");
        sb5.append(this.f256968j);
        sb5.append("; ");
        sb5.append(this.f256967i);
        sb5.append(". ");
        return sb5.toString();
    }

    public d(String str, int i3, String str2, int i16, String str3, long j3, boolean z16, String str4, String str5, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), str2, Integer.valueOf(i16), str3, Long.valueOf(j3), Boolean.valueOf(z16), str4, str5, Integer.valueOf(i17));
            return;
        }
        this.f256959a = str;
        this.f256960b = i3;
        this.f256961c = str2;
        this.f256962d = i16;
        this.f256963e = str3;
        this.f256964f = j3;
        this.f256965g = z16;
        this.f256966h = str4;
        this.f256968j = str5;
        this.f256967i = i17;
    }
}

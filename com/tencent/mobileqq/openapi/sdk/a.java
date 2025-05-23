package com.tencent.mobileqq.openapi.sdk;

import android.net.Uri;
import com.tencent.gamecenter.wadl.api.IQQGameProviderService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final Uri f256925a;

    /* renamed from: b, reason: collision with root package name */
    public static final Uri f256926b;

    /* renamed from: c, reason: collision with root package name */
    public static final Uri f256927c;

    /* renamed from: d, reason: collision with root package name */
    public static final Uri f256928d;

    /* renamed from: e, reason: collision with root package name */
    public static final Uri f256929e;

    /* renamed from: f, reason: collision with root package name */
    public static final Uri f256930f;

    /* renamed from: g, reason: collision with root package name */
    public static final Uri f256931g;

    /* renamed from: h, reason: collision with root package name */
    public static final Uri f256932h;

    /* renamed from: i, reason: collision with root package name */
    public static final Uri f256933i;

    /* renamed from: j, reason: collision with root package name */
    public static final Uri f256934j;

    /* renamed from: k, reason: collision with root package name */
    public static final Uri f256935k;

    /* renamed from: l, reason: collision with root package name */
    public static final String[] f256936l;

    /* renamed from: m, reason: collision with root package name */
    public static final String[] f256937m;

    /* renamed from: n, reason: collision with root package name */
    public static final String[] f256938n;

    /* renamed from: o, reason: collision with root package name */
    public static final String[] f256939o;

    /* renamed from: p, reason: collision with root package name */
    public static final String[] f256940p;

    /* renamed from: q, reason: collision with root package name */
    public static final String[] f256941q;

    /* renamed from: r, reason: collision with root package name */
    public static final String[] f256942r;

    /* renamed from: s, reason: collision with root package name */
    public static final String[] f256943s;

    /* renamed from: t, reason: collision with root package name */
    public static final String[] f256944t;

    /* renamed from: u, reason: collision with root package name */
    public static final String[] f256945u;

    /* renamed from: v, reason: collision with root package name */
    public static final String[] f256946v;

    /* renamed from: w, reason: collision with root package name */
    public static final String[] f256947w;

    /* renamed from: x, reason: collision with root package name */
    public static final String[] f256948x;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73466);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f256925a = Uri.parse("content://com.tencent.mobileqq.openapi.provider/query_msg");
        f256926b = Uri.parse("content://com.tencent.mobileqq.openapi.provider/query_face");
        f256927c = Uri.parse("content://com.tencent.mobileqq.openapi.provider/query_nick");
        f256928d = Uri.parse("content://com.tencent.mobileqq.openapi.provider/reg_receiver");
        f256929e = Uri.parse("content://com.tencent.mobileqq.openapi.provider/send_msg");
        f256930f = Uri.parse("content://com.tencent.mobileqq.openapi.provider/set_readed");
        f256931g = Uri.parse("content://com.tencent.mobileqq.openapi.provider/openaio");
        f256932h = Uri.parse("content://com.tencent.mobileqq.openapi.provider/decodesilk");
        f256933i = Uri.parse("content://com.tencent.mobileqq.openapi.provider/download_media");
        f256934j = Uri.parse("content://com.tencent.mobileqq.openapi.provider/exchange_uin");
        f256935k = Uri.parse("content://com.tencent.mobileqq.openapi.provider/paycode_channel");
        f256936l = new String[]{IQQGameProviderService.COLUMN_NAME_RS_CODE};
        f256937m = d.f256958q;
        f256938n = new String[]{"media_path"};
        f256939o = new String[]{"nick"};
        f256940p = new String[]{IQQGameProviderService.COLUMN_NAME_RS_CODE, "sessionkey", "uin"};
        f256941q = new String[]{"msgid"};
        f256942r = new String[]{IQQGameProviderService.COLUMN_NAME_RS_CODE};
        f256943s = new String[]{IQQGameProviderService.COLUMN_NAME_RS_CODE};
        f256944t = new String[]{IQQGameProviderService.COLUMN_NAME_RS_CODE, "sampleRate"};
        f256945u = new String[]{"mediaStatus"};
        f256946v = new String[]{IQQGameProviderService.COLUMN_NAME_RS_CODE, "uin"};
        f256947w = new String[]{QQHealthReportApiImpl.MSG_TYPE_KEY, IQQGameProviderService.COLUMN_NAME_RS_CODE, "msgSummary"};
        f256948x = new String[]{"app_version"};
    }
}

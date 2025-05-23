package com.tencent.mobileqq.activity.contact.addcontact.findtroop;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static String f181089a;

    /* renamed from: b, reason: collision with root package name */
    public static String f181090b;

    /* renamed from: c, reason: collision with root package name */
    public static String f181091c;

    /* renamed from: d, reason: collision with root package name */
    public static String f181092d;

    /* renamed from: e, reason: collision with root package name */
    public static String f181093e;

    /* renamed from: f, reason: collision with root package name */
    public static String f181094f;

    /* renamed from: g, reason: collision with root package name */
    public static String f181095g;

    /* renamed from: h, reason: collision with root package name */
    public static String f181096h;

    /* renamed from: i, reason: collision with root package name */
    public static String f181097i;

    /* renamed from: j, reason: collision with root package name */
    public static String f181098j;

    /* renamed from: k, reason: collision with root package name */
    public static String f181099k;

    /* renamed from: l, reason: collision with root package name */
    public static String f181100l;

    /* renamed from: m, reason: collision with root package name */
    public static String f181101m;

    /* renamed from: n, reason: collision with root package name */
    public static String f181102n;

    /* renamed from: o, reason: collision with root package name */
    public static String f181103o;

    /* renamed from: p, reason: collision with root package name */
    public static String f181104p;

    /* renamed from: q, reason: collision with root package name */
    public static String f181105q;

    /* renamed from: r, reason: collision with root package name */
    public static String f181106r;

    /* renamed from: s, reason: collision with root package name */
    public static String f181107s;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27699);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f181089a = "pg_group_recommand";
        f181090b = "group_channel_tab_status";
        f181091c = "group_recommand_exist_group";
        f181092d = "group_recommand_exist_channel";
        f181093e = "em_group_recommand_result";
        f181094f = "em_group_join";
        f181095g = "em_group_recommand_class";
        f181096h = "group_recommand_rank";
        f181097i = "group_recommand_result_type";
        f181098j = "group_recommand_tag";
        f181099k = "group_recommand_channel_status";
        f181100l = "group_recommand_result_id";
        f181101m = "group_recommand_class_level";
        f181102n = "group_recommand_class_name";
        f181103o = "group_recommand_result_name";
        f181104p = "em_group_banner";
        f181105q = "em_group_tab";
        f181106r = "group_recall_id";
        f181107s = "group_recall_trace_id";
    }
}

package com.tencent.mobileqq.troop.homework.entry.ui;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f297019a;

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f297020b;

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f297021c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f297022d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f297023e;

    /* renamed from: f, reason: collision with root package name */
    public static final String f297024f;

    /* renamed from: g, reason: collision with root package name */
    public static final String f297025g;

    /* renamed from: h, reason: collision with root package name */
    public static final String f297026h;

    /* renamed from: i, reason: collision with root package name */
    public static final String f297027i;

    /* renamed from: j, reason: collision with root package name */
    public static final String f297028j;

    /* renamed from: k, reason: collision with root package name */
    public static final String f297029k;

    /* renamed from: l, reason: collision with root package name */
    public static final String f297030l;

    /* renamed from: m, reason: collision with root package name */
    public static final String f297031m;

    /* renamed from: n, reason: collision with root package name */
    public static final HashMap<String, Integer> f297032n;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64194);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f297019a = new String[]{"type"};
        f297020b = new String[]{"str", "img", "video", "voice"};
        f297021c = new String[]{"recite", "calculation"};
        String qqStr = HardCodeUtil.qqStr(R.string.n97);
        f297022d = qqStr;
        String qqStr2 = HardCodeUtil.qqStr(R.string.n9b);
        f297023e = qqStr2;
        String qqStr3 = HardCodeUtil.qqStr(R.string.n9g);
        f297024f = qqStr3;
        String qqStr4 = HardCodeUtil.qqStr(R.string.f172093n92);
        f297025g = qqStr4;
        String qqStr5 = HardCodeUtil.qqStr(R.string.n9e);
        f297026h = qqStr5;
        String qqStr6 = HardCodeUtil.qqStr(R.string.n9c);
        f297027i = qqStr6;
        String qqStr7 = HardCodeUtil.qqStr(R.string.f172092n91);
        f297028j = qqStr7;
        String qqStr8 = HardCodeUtil.qqStr(R.string.n99);
        f297029k = qqStr8;
        String qqStr9 = HardCodeUtil.qqStr(R.string.n9_);
        f297030l = qqStr9;
        String qqStr10 = HardCodeUtil.qqStr(R.string.n9f);
        f297031m = qqStr10;
        HashMap<String, Integer> hashMap = new HashMap<>();
        f297032n = hashMap;
        hashMap.put(qqStr, Integer.valueOf(R.drawable.cps));
        hashMap.put(qqStr2, Integer.valueOf(R.drawable.cpw));
        hashMap.put(qqStr3, Integer.valueOf(R.drawable.cpt));
        hashMap.put(qqStr4, Integer.valueOf(R.drawable.cpy));
        hashMap.put(qqStr5, Integer.valueOf(R.drawable.cpz));
        hashMap.put(qqStr6, Integer.valueOf(R.drawable.cpu));
        hashMap.put(qqStr7, Integer.valueOf(R.drawable.cpr));
        hashMap.put(qqStr8, Integer.valueOf(R.drawable.cpv));
        hashMap.put(qqStr9, Integer.valueOf(R.drawable.cpq));
        hashMap.put(qqStr10, Integer.valueOf(R.drawable.cpx));
    }
}

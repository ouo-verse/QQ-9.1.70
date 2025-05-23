package com.tencent.mobileqq.filemanageraux.util;

import com.qzone.personalize.music.request.QzoneSetBackgroundMusicPlayModeRequest;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final String f209654a;

    /* renamed from: b, reason: collision with root package name */
    private final String f209655b;

    /* renamed from: c, reason: collision with root package name */
    private final ArrayList<byte[]> f209656c;

    /* renamed from: d, reason: collision with root package name */
    private final byte f209657d;

    /* renamed from: e, reason: collision with root package name */
    private final byte[] f209658e;

    /* renamed from: f, reason: collision with root package name */
    private final byte[] f209659f;

    /* renamed from: g, reason: collision with root package name */
    private final byte[] f209660g;

    /* renamed from: h, reason: collision with root package name */
    private final byte[] f209661h;

    /* renamed from: i, reason: collision with root package name */
    private final byte[] f209662i;

    /* renamed from: j, reason: collision with root package name */
    private final byte[] f209663j;

    /* renamed from: k, reason: collision with root package name */
    private final byte[] f209664k;

    /* renamed from: l, reason: collision with root package name */
    private final byte[] f209665l;

    /* renamed from: m, reason: collision with root package name */
    private final byte[] f209666m;

    /* renamed from: n, reason: collision with root package name */
    private final byte f209667n;

    /* renamed from: o, reason: collision with root package name */
    private final byte f209668o;

    /* renamed from: p, reason: collision with root package name */
    private final byte f209669p;

    /* renamed from: q, reason: collision with root package name */
    private final int f209670q;

    /* renamed from: r, reason: collision with root package name */
    private HashMap<Long, String> f209671r;

    /* renamed from: s, reason: collision with root package name */
    private byte[] f209672s;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f209654a = "DESede/ECB/PKCS5Padding";
        this.f209655b = QzoneSetBackgroundMusicPlayModeRequest.PLAY_MODE_RANDOM;
        ArrayList<byte[]> arrayList = new ArrayList<>(10);
        this.f209656c = arrayList;
        this.f209657d = (byte) 0;
        byte[] bytes = "gavinhuangdaydayup_happy".getBytes();
        this.f209658e = bytes;
        byte[] bytes2 = "doscarlettmarryrenzzhang".getBytes();
        this.f209659f = bytes2;
        byte[] bytes3 = "wangpeilin_georgewangson".getBytes();
        this.f209660g = bytes3;
        byte[] bytes4 = "georgebirthdayis19790526".getBytes();
        this.f209661h = bytes4;
        byte[] bytes5 = "qlinkwillthebestfunction".getBytes();
        this.f209662i = bytes5;
        byte[] bytes6 = "qqwillbebetterthanwechat".getBytes();
        this.f209663j = bytes6;
        byte[] bytes7 = "whowillbethenextbigtiger".getBytes();
        this.f209664k = bytes7;
        byte[] bytes8 = "whenwillwefindmahang_370".getBytes();
        this.f209665l = bytes8;
        byte[] bytes9 = "whenwillchinagetworldcap".getBytes();
        this.f209666m = bytes9;
        this.f209667n = (byte) 0;
        this.f209668o = (byte) 1;
        this.f209669p = (byte) 0;
        this.f209670q = 20;
        this.f209671r = new HashMap<>();
        this.f209672s = null;
        arrayList.add(bytes);
        arrayList.add(bytes2);
        arrayList.add(bytes3);
        arrayList.add(bytes4);
        arrayList.add(bytes5);
        arrayList.add(bytes6);
        arrayList.add(bytes7);
        arrayList.add(bytes8);
        arrayList.add(bytes9);
    }

    public void a(String str) {
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        if (str != null) {
            bArr = str.getBytes();
        } else {
            bArr = null;
        }
        this.f209672s = bArr;
    }
}

package com.tencent.av.ui.funchat.record;

import android.text.TextUtils;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes3.dex */
public class e {

    /* renamed from: u, reason: collision with root package name */
    private static e f75868u;

    /* renamed from: a, reason: collision with root package name */
    public String f75869a = null;

    /* renamed from: b, reason: collision with root package name */
    public int f75870b = 1;

    /* renamed from: c, reason: collision with root package name */
    public int f75871c = 4;

    /* renamed from: d, reason: collision with root package name */
    public int f75872d = 2000;

    /* renamed from: e, reason: collision with root package name */
    public int f75873e = 4;

    /* renamed from: f, reason: collision with root package name */
    public int f75874f = 2150;

    /* renamed from: g, reason: collision with root package name */
    public int f75875g = 720;

    /* renamed from: h, reason: collision with root package name */
    public int f75876h = 1;

    /* renamed from: i, reason: collision with root package name */
    public int f75877i = 5;

    /* renamed from: j, reason: collision with root package name */
    public int f75878j = 120000;

    /* renamed from: k, reason: collision with root package name */
    public int f75879k = 1;

    /* renamed from: l, reason: collision with root package name */
    public int f75880l = 1;

    /* renamed from: m, reason: collision with root package name */
    public int f75881m = 0;

    /* renamed from: n, reason: collision with root package name */
    public int f75882n = 0;

    /* renamed from: o, reason: collision with root package name */
    public int f75883o = 5000;

    /* renamed from: p, reason: collision with root package name */
    public int f75884p = 0;

    /* renamed from: q, reason: collision with root package name */
    public int f75885q = 25000;

    /* renamed from: r, reason: collision with root package name */
    public int f75886r = 1;

    /* renamed from: s, reason: collision with root package name */
    public int f75887s;

    /* renamed from: t, reason: collision with root package name */
    public int f75888t;

    public static e a() {
        if (f75868u == null) {
            f75868u = b();
        }
        return f75868u;
    }

    private static e b() {
        e eVar = new e();
        String featureValueWithoutAccountManager = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(DPCNames.qavDpc.name());
        eVar.f75869a = featureValueWithoutAccountManager;
        if (!TextUtils.isEmpty(featureValueWithoutAccountManager)) {
            String[] split = featureValueWithoutAccountManager.split("\\|");
            eVar.f75870b = c(split, 0, 1);
            eVar.f75871c = c(split, 1, 4);
            eVar.f75872d = c(split, 2, 2000);
            eVar.f75873e = c(split, 3, 4);
            eVar.f75874f = c(split, 4, 2150);
            eVar.f75875g = c(split, 5, 720);
            eVar.f75876h = c(split, 6, 1);
            eVar.f75877i = c(split, 7, 5);
            eVar.f75878j = c(split, 8, 120000);
            eVar.f75879k = c(split, 9, 1);
            eVar.f75880l = c(split, 10, 1);
            eVar.f75881m = c(split, 11, 0);
            eVar.f75882n = c(split, 12, 0);
            eVar.f75883o = c(split, 13, 5000);
            eVar.f75884p = c(split, 14, 0);
            eVar.f75885q = c(split, 15, 25000);
            eVar.f75886r = c(split, 16, 1);
        }
        eVar.f75887s = ah.n();
        eVar.f75888t = (int) (ah.m() / 1000);
        if (QLog.isColorLevel()) {
            QLog.d("QavRecordDpc", 2, "init=" + eVar);
        }
        return eVar;
    }

    private static int c(String[] strArr, int i3, int i16) {
        if (strArr != null && i3 < strArr.length) {
            try {
                return Integer.parseInt(strArr[i3]);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return i16;
    }

    public String toString() {
        return String.format(Locale.getDefault(), "QavRecordDpc:dpc=%s, default=%d|%d|%d|%d|%d|%d, value=%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%d|%s|%s|%s, system=%d|%d", this.f75869a, 1, 4, 2000, 4, 2150, 720, Integer.valueOf(this.f75870b), Integer.valueOf(this.f75871c), Integer.valueOf(this.f75872d), Integer.valueOf(this.f75873e), Integer.valueOf(this.f75874f), Integer.valueOf(this.f75875g), Integer.valueOf(this.f75876h), Integer.valueOf(this.f75877i), Integer.valueOf(this.f75878j), Integer.valueOf(this.f75880l), Integer.valueOf(this.f75881m), Integer.valueOf(this.f75882n), Integer.valueOf(this.f75883o), Integer.valueOf(this.f75884p), Integer.valueOf(this.f75885q), Integer.valueOf(this.f75886r), Integer.valueOf(this.f75887s), Integer.valueOf(this.f75888t));
    }
}

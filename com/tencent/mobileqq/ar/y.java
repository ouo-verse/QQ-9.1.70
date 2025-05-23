package com.tencent.mobileqq.ar;

import android.text.TextUtils;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes11.dex */
public class y {

    /* renamed from: l, reason: collision with root package name */
    private static y f198840l;

    /* renamed from: a, reason: collision with root package name */
    public boolean f198841a;

    /* renamed from: b, reason: collision with root package name */
    public int f198842b;

    /* renamed from: c, reason: collision with root package name */
    public float f198843c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f198844d;

    /* renamed from: e, reason: collision with root package name */
    public int f198845e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f198846f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f198847g;

    /* renamed from: h, reason: collision with root package name */
    public int f198848h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f198849i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f198850j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f198851k;

    public static y a() {
        if (f198840l == null) {
            y yVar = new y();
            f198840l = yVar;
            yVar.b();
        }
        return f198840l;
    }

    private void b() {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        boolean z28;
        long currentTimeMillis = System.currentTimeMillis();
        c();
        String featureValueWithoutAccountManager = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(DPCNames.ARCfg.name());
        QLog.d("ScanEntranceDPC", 1, String.format("loadDPC dpcValue=%s", featureValueWithoutAccountManager));
        int i3 = -1;
        if (!TextUtils.isEmpty(featureValueWithoutAccountManager)) {
            try {
                String[] split = featureValueWithoutAccountManager.split("\\|");
                if (split.length >= 9) {
                    if (Integer.valueOf(split[1]).intValue() == 1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    this.f198841a = z16;
                    int intValue = Integer.valueOf(split[2]).intValue();
                    if (intValue >= 0) {
                        this.f198842b = intValue;
                    }
                    float floatValue = Float.valueOf(split[3]).floatValue();
                    if (floatValue >= 0.05f && floatValue <= 0.95f) {
                        this.f198843c = floatValue;
                    }
                    if (Integer.valueOf(split[4]).intValue() == 1) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    this.f198844d = z17;
                    int intValue2 = Integer.valueOf(split[5]).intValue();
                    if (intValue2 >= 0) {
                        this.f198845e = intValue2;
                    }
                    if (Integer.valueOf(split[6]).intValue() == 1) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    this.f198846f = z18;
                    if (Integer.valueOf(split[7]).intValue() == 1) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    this.f198847g = z19;
                    int intValue3 = Integer.valueOf(split[8]).intValue();
                    if (intValue3 >= 0 && intValue3 <= 255) {
                        this.f198848h = intValue3;
                    }
                    if (split.length >= 12) {
                        if (Integer.valueOf(split[11]).intValue() == 1) {
                            z28 = true;
                        } else {
                            z28 = false;
                        }
                        this.f198849i = z28;
                    }
                    if (split.length > 12) {
                        i3 = Integer.valueOf(split[12]).intValue();
                    }
                    if (split.length >= 18) {
                        if (Integer.valueOf(split[17]).intValue() == 1) {
                            z27 = true;
                        } else {
                            z27 = false;
                        }
                        this.f198850j = z27;
                    }
                    if (split.length >= 19) {
                        if (Integer.valueOf(split[18]).intValue() == 1) {
                            z26 = true;
                        } else {
                            z26 = false;
                        }
                        this.f198851k = z26;
                    }
                } else {
                    QLog.e("ScanEntranceDPC", 1, "loadDPC dpc length invalid, use default value.");
                }
            } catch (Exception e16) {
                QLog.e("ScanEntranceDPC", 1, "loadDPC fail, use default value.", e16);
                c();
            }
        }
        QLog.d("ScanEntranceDPC", 1, String.format("loadDPC mHighPerfDevice=%s mCameraZoom=%s mScanRectRadio=%s mContinuousFocus=%s mARRecogInterval=%s mRecycleFaceResource=%s mRecordEnable=%s mDarkThreshold=%s mNeonCfgSwitch=%s, disableWorldCup=%s mMiniDecodeSwitch=%s mMiniDetectSwitch=%s", Boolean.valueOf(this.f198841a), Integer.valueOf(this.f198842b), Float.valueOf(this.f198843c), Boolean.valueOf(this.f198844d), Integer.valueOf(this.f198845e), Boolean.valueOf(this.f198846f), Boolean.valueOf(this.f198847g), Integer.valueOf(this.f198848h), Boolean.valueOf(this.f198849i), Integer.valueOf(i3), Boolean.valueOf(this.f198850j), Boolean.valueOf(this.f198851k)));
        QLog.d("ScanEntranceDPC", 1, String.format("loadDPC time cost:%sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
    }

    private void c() {
        this.f198841a = false;
        this.f198842b = 2;
        this.f198843c = 0.7f;
        this.f198844d = false;
        this.f198845e = 500;
        this.f198846f = true;
        this.f198847g = true;
        this.f198848h = 28;
        this.f198849i = false;
        this.f198850j = false;
        this.f198851k = false;
    }
}

package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.pic.api.IPicValue;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.AIOImgThumbHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class AIOPicThumbSizeProcessor extends com.tencent.mobileqq.config.l<a> {

    /* renamed from: a, reason: collision with root package name */
    public static final int f202413a = ((IPicValue) QRoute.api(IPicValue.class)).getAioOtherSpaceValue();

    /* renamed from: b, reason: collision with root package name */
    private static volatile a f202414b;

    /* loaded from: classes10.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f202415a = true;

        /* renamed from: b, reason: collision with root package name */
        public double f202416b;

        /* renamed from: c, reason: collision with root package name */
        public double f202417c;

        /* renamed from: d, reason: collision with root package name */
        public int f202418d;

        /* renamed from: e, reason: collision with root package name */
        public int f202419e;

        /* renamed from: f, reason: collision with root package name */
        public int f202420f;

        /* renamed from: g, reason: collision with root package name */
        public int f202421g;

        /* renamed from: h, reason: collision with root package name */
        public int f202422h;

        /* renamed from: i, reason: collision with root package name */
        public int f202423i;

        /* renamed from: j, reason: collision with root package name */
        public int f202424j;

        /* renamed from: k, reason: collision with root package name */
        public int f202425k;

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f202415a != aVar.f202415a || this.f202420f != aVar.f202420f || this.f202421g != aVar.f202421g || this.f202422h != aVar.f202422h || this.f202423i != aVar.f202423i || this.f202424j != aVar.f202424j || this.f202425k != aVar.f202425k || this.f202419e != aVar.f202419e) {
                return false;
            }
            return true;
        }
    }

    private void a(a aVar) {
        double min = (int) ((Math.min(r0.widthPixels, r0.heightPixels) / c().density) - aVar.f202418d);
        aVar.f202421g = (int) (aVar.f202417c * min);
        aVar.f202420f = (int) (min * aVar.f202416b);
    }

    public static a b() {
        if (f202414b == null) {
            f202414b = (a) com.tencent.mobileqq.config.am.s().x(672);
        }
        return f202414b;
    }

    public DisplayMetrics c() {
        DisplayMetrics displayMetrics = FontSettingManager.systemMetrics;
        if (displayMetrics != null && displayMetrics.density > 0.0f) {
            return displayMetrics;
        }
        return BaseApplication.getContext().getResources().getDisplayMetrics();
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<a> clazz() {
        return a.class;
    }

    @Override // com.tencent.mobileqq.config.l
    @NonNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public a migrateOldOrDefaultContent(int i3) {
        return g();
    }

    @Override // com.tencent.mobileqq.config.l
    @Nullable
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public a onParsed(com.tencent.mobileqq.config.ai[] aiVarArr) {
        if (aiVarArr != null && aiVarArr.length != 0) {
            String str = aiVarArr[0].f202268b;
            if (QLog.isColorLevel()) {
                QLog.d("AIOPicThumbSizeProcessor", 2, "onParsed, content:" + str);
            }
            a aVar = new a();
            try {
                JSONObject jSONObject = new JSONObject(str);
                boolean optBoolean = jSONObject.optBoolean("useNewConfig", true);
                aVar.f202415a = optBoolean;
                if (optBoolean) {
                    aVar.f202417c = jSONObject.optDouble("minRatio", 0.0d);
                    aVar.f202416b = jSONObject.optDouble("maxRatio", 0.0d);
                    aVar.f202418d = jSONObject.optInt("textOtherSpace", f202413a);
                    aVar.f202419e = jSONObject.optInt("picSizeLimit", 650);
                    if (aVar.f202416b > 0.0d && aVar.f202417c > 0.0d && aVar.f202418d > 0) {
                        a(aVar);
                    } else {
                        aVar.f202421g = jSONObject.optInt("aioImageMinSize", 45);
                        aVar.f202420f = jSONObject.optInt("aioImageMaxSize", 135);
                    }
                    aVar.f202423i = jSONObject.optInt("aioImageMinSizeUnderLimit", 45);
                    aVar.f202422h = jSONObject.optInt("aioImageMaxSizeUnderLimit", 135);
                    aVar.f202425k = jSONObject.optInt("aioImageDynamicMinSize", 45);
                    aVar.f202424j = jSONObject.optInt("aioImageDynamicMaxSize", 135);
                    return aVar;
                }
                return aVar;
            } catch (Exception unused) {
                QLog.d("AIOPicThumbSizeProcessor", 1, "onParsed error, content:" + str);
                return g();
            }
        }
        return g();
    }

    @Override // com.tencent.mobileqq.config.l
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public synchronized void onUpdate(a aVar) {
        if (QLog.isColorLevel()) {
            QLog.d("AIOPicThumbSizeProcessor", 2, "onUpdate");
        }
        f202414b = (a) com.tencent.mobileqq.config.am.s().x(672);
        if (f202414b != null && f202414b.f202415a) {
            AIOImgThumbHelper.getInstance().updateByConfig(f202414b);
        }
    }

    public a g() {
        a aVar = new a();
        aVar.f202416b = 0.85d;
        aVar.f202417c = 0.28d;
        aVar.f202419e = 650;
        aVar.f202418d = f202413a;
        a(aVar);
        aVar.f202423i = 45;
        aVar.f202422h = 135;
        aVar.f202425k = 45;
        aVar.f202424j = 135;
        return aVar;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedCompressed() {
        return true;
    }

    @Override // com.tencent.mobileqq.config.l
    public boolean isNeedStoreLargeFile() {
        return false;
    }

    @Override // com.tencent.mobileqq.config.l
    public int migrateOldVersion() {
        return 0;
    }

    @Override // com.tencent.mobileqq.config.l
    public void onReqFailed(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("AIOPicThumbSizeProcessor", 2, "onReqFailed");
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return 672;
    }
}

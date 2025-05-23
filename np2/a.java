package np2;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.gson.JsonObject;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private c f420652a;

    /* renamed from: b, reason: collision with root package name */
    private long f420653b = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;

    /* renamed from: c, reason: collision with root package name */
    private JsonObject f420654c;

    /* compiled from: P */
    /* renamed from: np2.a$a, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public static final class C10860a {

        /* renamed from: a, reason: collision with root package name */
        public String f420655a;

        /* renamed from: b, reason: collision with root package name */
        public String f420656b;

        public boolean a() {
            if (!TextUtils.isEmpty(this.f420655a) && !TextUtils.isEmpty(this.f420656b)) {
                return true;
            }
            return false;
        }

        @NonNull
        public String toString() {
            return "QQSearchWXAd.Params(extBackComm=" + this.f420655a + ", searchAdExtraData=" + this.f420656b + ")";
        }
    }

    a() {
    }

    public static a a(C10860a c10860a) {
        if (c10860a != null && c10860a.a()) {
            a aVar = new a();
            c a16 = c.a(c10860a.f420655a);
            aVar.f420652a = a16;
            try {
                aVar.f420653b = Long.parseLong(a16.aid);
            } catch (Throwable th5) {
                QLog.e("QQSearchWXAd", 1, "[build] params:" + c10860a, th5);
            }
            aVar.f420654c = (JsonObject) op2.a.a(c10860a.f420656b, JsonObject.class, null);
            if (!aVar.j()) {
                QLog.e("QQSearchWXAd", 1, "[build] error, not valid, params:" + c10860a);
                return null;
            }
            return aVar;
        }
        QLog.e("QQSearchWXAd", 1, "[build] error, not valid, params:" + c10860a);
        return null;
    }

    public long b() {
        return this.f420653b;
    }

    public String c() {
        c cVar = this.f420652a;
        if (cVar != null) {
            return cVar.groupId;
        }
        return null;
    }

    public String d() {
        c cVar = this.f420652a;
        if (cVar != null) {
            return cVar.adPosId;
        }
        return null;
    }

    public JsonObject e() {
        return this.f420654c;
    }

    public String f() {
        c cVar = this.f420652a;
        if (cVar != null) {
            return cVar.traceId;
        }
        return null;
    }

    public String g() {
        c cVar = this.f420652a;
        if (cVar != null) {
            return cVar.f420659rl;
        }
        return null;
    }

    public String h() {
        c cVar = this.f420652a;
        if (cVar != null) {
            return cVar.apurl;
        }
        return null;
    }

    public String i() {
        c cVar = this.f420652a;
        if (cVar != null) {
            return cVar.apurl;
        }
        return null;
    }

    public boolean j() {
        c cVar = this.f420652a;
        if (cVar != null && cVar.b() && this.f420653b != WebViewConstants.WV.ENABLE_WEBAIO_SWITCH && this.f420654c != null) {
            return true;
        }
        return false;
    }

    @NonNull
    public String toString() {
        return "QQSearchWXAd(mExtBackComm=" + this.f420652a + ", mAId=" + this.f420653b + ",mSearchAdExtraData=" + this.f420654c + ")";
    }
}

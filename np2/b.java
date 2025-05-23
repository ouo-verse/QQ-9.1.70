package np2;

import android.text.TextUtils;
import com.tencent.biz.common.util.WebViewConstants;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public String f420657a;

    /* renamed from: b, reason: collision with root package name */
    public long f420658b = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;

    public boolean a() {
        if (!b() && !c()) {
            return false;
        }
        return true;
    }

    public boolean b() {
        if (!TextUtils.isEmpty(this.f420657a) && this.f420658b != WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
            return true;
        }
        return false;
    }

    public boolean c() {
        if (TextUtils.isEmpty(this.f420657a) && this.f420658b == WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
            return true;
        }
        return false;
    }
}

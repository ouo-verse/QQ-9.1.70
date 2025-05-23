package n01;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.k;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class b extends k {

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f417916e = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(b.class, "qrCodeUrl", "getQrCodeUrl$qecommerce_biz_release()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(b.class, "qrCodeSize", "getQrCodeSize$qecommerce_biz_release()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(b.class, "darkColor", "getDarkColor$qecommerce_biz_release()Lcom/tencent/kuikly/core/base/Color;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(b.class, "lightColor", "getLightColor$qecommerce_biz_release()Lcom/tencent/kuikly/core/base/Color;", 0)};

    /* renamed from: a, reason: collision with root package name */
    public final ReadWriteProperty f417917a = c01.c.a(null);

    /* renamed from: b, reason: collision with root package name */
    public final ReadWriteProperty f417918b = c01.c.a(Float.valueOf(200.0f));

    /* renamed from: c, reason: collision with root package name */
    public final ReadWriteProperty f417919c;

    /* renamed from: d, reason: collision with root package name */
    public final ReadWriteProperty f417920d;

    public b() {
        h.Companion companion = h.INSTANCE;
        this.f417919c = c01.c.a(companion.b());
        this.f417920d = c01.c.a(companion.m());
    }

    public final float h() {
        return ((Number) this.f417918b.getValue(this, f417916e[1])).floatValue();
    }

    public final void i(String str, float f16) {
        if (str.length() == 0) {
            this.f417917a.setValue(this, f417916e[0], null);
        } else {
            this.f417917a.setValue(this, f417916e[0], str);
        }
        this.f417918b.setValue(this, f417916e[1], Float.valueOf(f16));
    }
}

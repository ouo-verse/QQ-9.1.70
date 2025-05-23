package g94;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.sqshow.zootopia.nativeui.data.OrientationMode;
import com.tencent.sqshow.zootopia.nativeui.view.panel.PortalStoreViewOrientationHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.ranges.RangesKt___RangesKt;
import t74.u;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0016\u0018\u0000 \u00162\u00020\u0001:\u0001\u0012B\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u001a\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\u0006\u0010\u000e\u001a\u00020\u0004J\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\bJ\u0006\u0010\u0011\u001a\u00020\bJ\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\bJ\u0006\u0010\u0014\u001a\u00020\u0004J\u0006\u0010\u0015\u001a\u00020\bJ\u0006\u0010\u0016\u001a\u00020\u0004R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001dR\u0014\u0010 \u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001dR\u0016\u0010\"\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010!R\u0016\u0010#\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001dR\"\u0010)\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(\u00a8\u0006,"}, d2 = {"Lg94/g;", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "j", "", "r", "", "d", h.F, DomainData.DOMAIN_NAME, "g", "f", "e", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "a", "b", "o", "c", "i", "Landroid/content/Context;", "Landroid/content/Context;", "context", "Lcom/tencent/sqshow/zootopia/nativeui/data/OrientationMode;", "Lcom/tencent/sqshow/zootopia/nativeui/data/OrientationMode;", "orientationMode", UserInfo.SEX_FEMALE, "itemPreferWidth", "itemHeight", "mItemFixedGap", "I", TtmlNode.TAG_SPAN, "itemWidth", "Z", "p", "()Z", ReportConstant.COSTREPORT_PREFIX, "(Z)V", "isBigPic", "<init>", "(Landroid/content/Context;Lcom/tencent/sqshow/zootopia/nativeui/data/OrientationMode;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public class g {

    /* renamed from: j, reason: collision with root package name */
    private static final float f401580j = ViewUtils.dpToPx(79.0f);

    /* renamed from: k, reason: collision with root package name */
    private static final int f401581k;

    /* renamed from: l, reason: collision with root package name */
    private static final int f401582l;

    /* renamed from: m, reason: collision with root package name */
    private static final int f401583m;

    /* renamed from: n, reason: collision with root package name */
    private static final int f401584n;

    /* renamed from: o, reason: collision with root package name */
    private static final int f401585o;

    /* renamed from: p, reason: collision with root package name */
    private static final int f401586p;

    /* renamed from: q, reason: collision with root package name */
    private static final int f401587q;

    /* renamed from: r, reason: collision with root package name */
    private static final int f401588r;

    /* renamed from: s, reason: collision with root package name */
    private static final int f401589s;

    /* renamed from: t, reason: collision with root package name */
    private static final int f401590t;

    /* renamed from: u, reason: collision with root package name */
    private static final int f401591u;

    /* renamed from: v, reason: collision with root package name */
    private static final int f401592v;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final OrientationMode orientationMode;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final float itemPreferWidth;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final float itemHeight;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final float mItemFixedGap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int span;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private float itemWidth;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isBigPic;

    static {
        int roundToInt;
        int roundToInt2;
        int roundToInt3;
        int roundToInt4;
        int roundToInt5;
        int roundToInt6;
        int dpToPx = ViewUtils.dpToPx(60.0f);
        f401581k = dpToPx;
        roundToInt = MathKt__MathJVMKt.roundToInt(dpToPx * 0.8f);
        f401582l = roundToInt;
        int dpToPx2 = ViewUtils.dpToPx(32.5f);
        f401583m = dpToPx2;
        roundToInt2 = MathKt__MathJVMKt.roundToInt(dpToPx2 * 0.8f);
        f401584n = roundToInt2;
        int dpToPx3 = ViewUtils.dpToPx(12.25f);
        f401585o = dpToPx3;
        roundToInt3 = MathKt__MathJVMKt.roundToInt(dpToPx3 * 0.8f);
        f401586p = roundToInt3;
        int dpToPx4 = ViewUtils.dpToPx(31.0f);
        f401587q = dpToPx4;
        roundToInt4 = MathKt__MathJVMKt.roundToInt(dpToPx4 * 0.8f);
        f401588r = roundToInt4;
        int dpToPx5 = ViewUtils.dpToPx(18.0f);
        f401589s = dpToPx5;
        roundToInt5 = MathKt__MathJVMKt.roundToInt(dpToPx5 * 0.8f);
        f401590t = roundToInt5;
        int dpToPx6 = ViewUtils.dpToPx(41.0f);
        f401591u = dpToPx6;
        roundToInt6 = MathKt__MathJVMKt.roundToInt(dpToPx6 * 0.8f);
        f401592v = roundToInt6;
    }

    public g(Context context, OrientationMode orientationMode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(orientationMode, "orientationMode");
        this.context = context;
        this.orientationMode = orientationMode;
        float dimension = context.getResources().getDimension(R.dimen.f115351);
        this.itemPreferWidth = dimension;
        this.itemHeight = context.getResources().getDimension(R.dimen.f11454t);
        this.mItemFixedGap = context.getResources().getDimension(R.dimen.f11444s);
        this.span = 4;
        this.itemWidth = dimension;
        r();
    }

    private final int j() {
        if (q()) {
            PortalStoreViewOrientationHelper.Companion companion = PortalStoreViewOrientationHelper.INSTANCE;
            return companion.b() - companion.a();
        }
        return u.INSTANCE.c(this.context);
    }

    private final boolean q() {
        Resources resources;
        Configuration configuration;
        return (this.orientationMode == OrientationMode.PORTRAIT || (resources = this.context.getResources()) == null || (configuration = resources.getConfiguration()) == null || configuration.orientation != 2) ? false : true;
    }

    public final int a() {
        if (q()) {
            return f401588r;
        }
        return f401587q;
    }

    public final float b() {
        return q() ? 9.6f : 12.0f;
    }

    public final float c() {
        return q() ? 8.0f : 10.0f;
    }

    public float d() {
        if (q()) {
            return f401580j;
        }
        return this.itemHeight;
    }

    public final int e() {
        if (q()) {
            return f401584n;
        }
        return f401583m;
    }

    public int f() {
        if (q()) {
            return f401582l;
        }
        return f401581k;
    }

    public int g() {
        if (q()) {
            return f401582l;
        }
        return f401581k;
    }

    /* renamed from: h, reason: from getter */
    public float getItemWidth() {
        return this.itemWidth;
    }

    public final int i() {
        if (q()) {
            return f401592v;
        }
        return f401591u;
    }

    public final int k() {
        if (q()) {
            return f401586p;
        }
        return f401585o;
    }

    public final float l() {
        return q() ? 9.6f : 12.0f;
    }

    public final float m() {
        return q() ? 8.8f : 11.0f;
    }

    /* renamed from: n, reason: from getter */
    public int getSpan() {
        return this.span;
    }

    public final int o() {
        if (q()) {
            return f401590t;
        }
        return f401589s;
    }

    /* renamed from: p, reason: from getter */
    public final boolean getIsBigPic() {
        return this.isBigPic;
    }

    public final void r() {
        int coerceAtLeast;
        int j3 = j();
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(j3 / ((int) this.itemPreferWidth), 4);
        this.span = coerceAtLeast;
        float f16 = this.itemPreferWidth;
        this.itemWidth = f16 + (((j3 * 1.0f) - (coerceAtLeast * f16)) / coerceAtLeast);
    }

    public final void s(boolean z16) {
        this.isBigPic = z16;
    }
}

package o53;

import android.content.Context;
import com.tencent.common.config.AppSetting;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pad.m;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b%\u0010&J\u0012\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\u0007\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\b\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\t\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\n\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\u000b\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\f\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\r\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\u000e\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\u0011\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\u0012\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\u0013\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\u0014\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\u0016\u001a\u00020\u00152\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0017\u001a\u00020\u0015J\u0012\u0010\u0018\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\u0019\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\u001a\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\u001b\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\u001c\u001a\u00020\u00152\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\u001d\u001a\u00020\u00152\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\u001e\u001a\u00020\u00152\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\u001f\u001a\u00020\u00152\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010 \u001a\u00020\u00152\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010!\u001a\u00020\u00152\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\"\u001a\u00020\u00152\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0014\u0010#\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0014\u0010$\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002\u00a8\u0006'"}, d2 = {"Lo53/h;", "", "Landroid/content/Context;", "context", "", "d", "c", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "i", tl.h.F, "g", "f", DomainData.DOMAIN_NAME, ReportConstant.COSTREPORT_PREFIX, "", "t", "u", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "k", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "y", "v", "p", "j", "e", "D", "w", "a", "B", HippyTKDListViewAdapter.X, BdhLogUtil.LogTag.Tag_Conn, "E", "b", "o", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f422138a = new h();

    h() {
    }

    public static /* synthetic */ boolean A(h hVar, Context context, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            context = null;
        }
        return hVar.z(context);
    }

    private final int b(Context context) {
        return (int) ((q(context) * 2.0f) + ImmersiveUtils.dpToPx(20.0f));
    }

    private final int o(Context context) {
        if (w(context)) {
            int d16 = m.d();
            if (d16 <= 0) {
                return v(context);
            }
            return d16;
        }
        return v(context);
    }

    public final boolean B(@Nullable Context context) {
        boolean z16;
        DeviceType a16 = PadUtil.a(BaseApplication.getContext());
        Intrinsics.checkNotNullExpressionValue(a16, "getDeviceType(MobileQQ.getContext())");
        if (a16 == DeviceType.TABLET) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && !y() && !D(context)) {
            return true;
        }
        return false;
    }

    public final boolean C(@Nullable Context context) {
        boolean z16 = false;
        if (z(context)) {
            return false;
        }
        int p16 = p(context);
        int j3 = j(context);
        if (p16 > 0 && j3 > 0) {
            float f16 = (p16 * 1.0f) / j3;
            float f17 = 1 / 0.52f;
            if (f16 >= 0.52f && f16 <= f17) {
                z16 = true;
            }
            if (QLog.isColorLevel()) {
                w53.b.f("WinkAIAvatarViewLayoutHelper", "[isPhoneWideScreen] " + z16 + ",curRatio:" + f16 + ", screenHeight:" + j3 + ", screenWidth:" + p16 + ", ");
            }
        }
        return z16;
    }

    public final boolean D(@Nullable Context context) {
        if (A(this, null, 1, null) && !y() && p(context) / j(context) > 0.75f) {
            return true;
        }
        return false;
    }

    public final boolean E(@Nullable Context context) {
        int p16 = p(context);
        int j3 = j(context);
        boolean z16 = false;
        if (p16 > 0 && j3 > 0) {
            float f16 = (p16 * 1.0f) / j3;
            float f17 = 1 / 0.71f;
            if (f16 >= 0.71f && f16 <= f17) {
                z16 = true;
            }
            if (QLog.isColorLevel()) {
                w53.b.f("WinkAIAvatarViewLayoutHelper", "[isFolderScreenOpenMode] " + z16 + ",curRatio:" + f16 + ", screenHeight:" + j3 + ", screenWidth:" + p16 + ", ");
            }
        }
        return z16;
    }

    public final boolean a(@Nullable Context context) {
        if (!w(context)) {
            return AppSetting.o(context);
        }
        return E(context);
    }

    public final int c(@Nullable Context context) {
        return b(context) - ImmersiveUtils.dpToPx(10.0f);
    }

    public final int d(@Nullable Context context) {
        return b(context) - ImmersiveUtils.dpToPx(34.0f);
    }

    public final int e(@Nullable Context context) {
        if (context == null) {
            return Math.max(ImmersiveUtils.getScreenWidth(), ImmersiveUtils.getScreenHeight());
        }
        return x.f(context).f185861b;
    }

    public final int f(@Nullable Context context) {
        return (int) ((o(context) * 154.0f) / 428.0f);
    }

    public final int g(@Nullable Context context) {
        return (int) (((o(context) * 260.0f) / 428.0f) + ViewUtils.dpToPx(1.0f));
    }

    public final int h(@Nullable Context context) {
        return (int) ((o(context) * 151.0f) / 428.0f);
    }

    public final int i(@Nullable Context context) {
        return (int) ((o(context) * 127.0f) / 428.0f);
    }

    public final int j(@Nullable Context context) {
        return Math.max(v(context), e(context));
    }

    public final int k(@Nullable Context context) {
        return (int) ((v(context) * 250.0f) / 768.0f);
    }

    public final int l(@Nullable Context context) {
        return k(context) + ImmersiveUtils.dpToPx(78.0f);
    }

    public final int m(@Nullable Context context) {
        float v3 = (v(context) * 466.0f) / 768.0f;
        if (y() || D(context) || x(context)) {
            v3 = (p(context) * 250.0f) / 768.0f;
        }
        return (int) v3;
    }

    public final int n(@Nullable Context context) {
        float v3 = (v(context) * 513.0f) / 768.0f;
        if (y() || D(context) || x(context)) {
            v3 = (j(context) * 428.0f) / 1024.0f;
        }
        return (int) v3;
    }

    public final int p(@Nullable Context context) {
        return Math.min(v(context), e(context));
    }

    public final int q(@Nullable Context context) {
        return r(context) + ImmersiveUtils.dpToPx(24.0f);
    }

    public final int r(@Nullable Context context) {
        return (int) ((o(context) * 115.0f) / 428.0f);
    }

    public final int s(@Nullable Context context) {
        float v3 = (v(context) * 513.0f) / 768.0f;
        if (y() || D(context) || x(context)) {
            v3 = (j(context) * 428.0f) / 1024.0f;
        }
        return (int) v3;
    }

    public final float t(@Nullable Context context) {
        float coerceAtMost;
        int e16;
        float coerceAtMost2;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost((e(context) * 135.0f) / 926.0f, ImmersiveUtils.dpToPx(135.0f));
        if (y() || C(context) || x(context)) {
            if (y()) {
                e16 = p(context);
            } else {
                e16 = e(context);
            }
            coerceAtMost2 = RangesKt___RangesKt.coerceAtMost((e16 * 20.0f) / 428.0f, ImmersiveUtils.dpToPx(20.0f));
            return coerceAtMost2;
        }
        return coerceAtMost;
    }

    public final int u(@Nullable Context context) {
        float e16 = (e(context) * 348.0f) / 926.0f;
        if (y() || E(context) || x(context)) {
            e16 = (p(context) * 280.0f) / 768.0f;
        }
        return (int) e16;
    }

    public final int v(@Nullable Context context) {
        if (context == null) {
            return Math.min(ImmersiveUtils.getScreenWidth(), ImmersiveUtils.getScreenHeight());
        }
        return x.f(context).f185860a;
    }

    public final boolean w(@Nullable Context context) {
        DeviceType a16 = PadUtil.a(BaseApplication.getContext());
        Intrinsics.checkNotNullExpressionValue(a16, "getDeviceType(MobileQQ.getContext())");
        if (a16 == DeviceType.FOLD) {
            return true;
        }
        return false;
    }

    public final boolean x(@Nullable Context context) {
        DeviceType a16 = PadUtil.a(BaseApplication.getContext());
        Intrinsics.checkNotNullExpressionValue(a16, "getDeviceType(MobileQQ.getContext())");
        if (a16 == DeviceType.FOLD && E(context)) {
            return true;
        }
        return false;
    }

    public final boolean y() {
        BaseApplication context = BaseApplication.getContext();
        if (context.getResources().getConfiguration().orientation == 2 && AppSetting.o(context)) {
            return true;
        }
        return false;
    }

    public final boolean z(@Nullable Context context) {
        boolean z16;
        boolean z17;
        DeviceType a16 = PadUtil.a(BaseApplication.getContext());
        Intrinsics.checkNotNullExpressionValue(a16, "getDeviceType(MobileQQ.getContext())");
        DeviceType deviceType = DeviceType.TABLET;
        boolean z18 = false;
        if (a16 != deviceType && (a16 != DeviceType.FOLD || !E(context))) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (a16 == deviceType) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (a16 == DeviceType.FOLD) {
            z18 = true;
        }
        w53.b.f("WinkAIAvatarViewLayoutHelper", "[isPadDevice] " + z16 + ", deviceType == DeviceType.TABLET:" + z17 + ", deviceType == DeviceType.FOLD :" + z18);
        return z16;
    }
}

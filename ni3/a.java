package ni3;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000f\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\n\u0010\u0005J\u000f\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u000b\u0010\u0005J\u000f\u0010\f\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\r\u0010\u0005J\u000f\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u000e\u0010\u0005R\u0014\u0010\u0010\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00118\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00118\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00118\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0012R\u0014\u0010\u0018\u001a\u00020\u00118\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0012R\u0014\u0010\u0019\u001a\u00020\u00118\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0012R\u0014\u0010\u001a\u001a\u00020\u00118\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0012R\u0014\u0010\u001b\u001a\u00020\u00118\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0012\u00a8\u0006\u001e"}, d2 = {"Lni3/a;", "", "", "c", "b", "()Ljava/lang/Integer;", "j", "a", "i", "e", "k", "f", "g", "d", h.F, "I", "ceilingHeight", "", UserInfo.SEX_FEMALE, "attachTopUpperRate", "attachTopUpperRateXw", "attachTopLowerRate", "attachTopLowerRateXw", "initHeightRate", "initHeigntRateXw", "playActionToInitDiff", "refreshHeightRate", "fullScreenHeightRate", "<init>", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f420201a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final int ceilingHeight = (ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext()) + ImmersiveUtils.dpToPx(50.0f)) + ImmersiveUtils.dpToPx(10.0f);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final float attachTopUpperRate = 0.06f;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final float attachTopUpperRateXw = 0.35f;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final float attachTopLowerRate = 0.18f;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final float attachTopLowerRateXw = 0.35f;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static final float initHeightRate = 0.23f;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static final float initHeigntRateXw = 0.4f;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static final float playActionToInitDiff = 10.0f;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static final float refreshHeightRate = 0.37f;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private static final float fullScreenHeightRate = 0.42f;

    a() {
    }

    @Nullable
    public final Integer a() {
        int roundToInt;
        if (h() != null) {
            roundToInt = MathKt__MathJVMKt.roundToInt(r0.intValue() * attachTopLowerRate);
            return Integer.valueOf(roundToInt);
        }
        return null;
    }

    @Nullable
    public final Integer b() {
        int roundToInt;
        if (h() != null) {
            roundToInt = MathKt__MathJVMKt.roundToInt(ceilingHeight + (r0.intValue() * attachTopUpperRate));
            return Integer.valueOf(roundToInt);
        }
        return null;
    }

    public final int c() {
        return ceilingHeight;
    }

    @Nullable
    public final Integer d() {
        int roundToInt;
        if (h() != null) {
            roundToInt = MathKt__MathJVMKt.roundToInt(r0.intValue() * fullScreenHeightRate);
            return Integer.valueOf(roundToInt);
        }
        return null;
    }

    @Nullable
    public final Integer e() {
        int roundToInt;
        if (h() != null) {
            roundToInt = MathKt__MathJVMKt.roundToInt(r0.intValue() * initHeightRate);
            return Integer.valueOf(roundToInt);
        }
        return null;
    }

    @Nullable
    public final Integer f() {
        int roundToInt;
        if (e() != null) {
            roundToInt = MathKt__MathJVMKt.roundToInt(r0.intValue() + playActionToInitDiff);
            return Integer.valueOf(roundToInt);
        }
        return null;
    }

    @Nullable
    public final Integer g() {
        int roundToInt;
        if (h() != null) {
            roundToInt = MathKt__MathJVMKt.roundToInt(r0.intValue() * refreshHeightRate);
            return Integer.valueOf(roundToInt);
        }
        return null;
    }

    @Nullable
    public final Integer h() {
        BaseApplication context = BaseApplication.getContext();
        if (context == null) {
            return null;
        }
        return Integer.valueOf(ScreenUtil.getRealHeight(context));
    }

    @Nullable
    public final Integer i() {
        int roundToInt;
        if (h() != null) {
            roundToInt = MathKt__MathJVMKt.roundToInt(r0.intValue() * attachTopLowerRateXw);
            return Integer.valueOf(roundToInt);
        }
        return null;
    }

    @Nullable
    public final Integer j() {
        int roundToInt;
        if (h() != null) {
            roundToInt = MathKt__MathJVMKt.roundToInt(ceilingHeight + (r0.intValue() * attachTopUpperRateXw));
            return Integer.valueOf(roundToInt);
        }
        return null;
    }

    @Nullable
    public final Integer k() {
        int roundToInt;
        if (h() != null) {
            roundToInt = MathKt__MathJVMKt.roundToInt(r0.intValue() * initHeigntRateXw);
            return Integer.valueOf(roundToInt);
        }
        return null;
    }
}

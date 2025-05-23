package dh1;

import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.pad.SplitViewState;
import com.tencent.mobileqq.pad.e;
import com.tencent.mobileqq.util.x;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0002R\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\fR\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\fR\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\fR\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\fR\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\f\u00a8\u0006\u0014"}, d2 = {"Ldh1/a;", "", "", "f", "screenWidth", "", "g", "e", "d", "b", "c", "a", "I", "mostCardCnt", "cardWidth", "cardHeight", "avatarSize", "horizontalSpacing", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f393835a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int mostCardCnt;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int cardWidth;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static int cardHeight;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static int avatarSize;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static int horizontalSpacing;

    a() {
    }

    public final int a() {
        int b16 = x.f(BaseApplication.getContext()).b();
        if (AppSetting.t(BaseApplication.getContext()) && e.a() == SplitViewState.STATE_FLAT) {
            return (int) (b16 * e.g());
        }
        return b16;
    }

    public final int b() {
        return avatarSize;
    }

    public final int c() {
        return horizontalSpacing;
    }

    public final int d() {
        return cardHeight;
    }

    public final int e() {
        return cardWidth;
    }

    public final int f() {
        g(a());
        return mostCardCnt;
    }

    public final void g(int screenWidth) {
        int coerceIn;
        int coerceAtLeast;
        int a16 = com.tencent.mobileqq.utils.x.a(32.0f);
        int a17 = com.tencent.mobileqq.utils.x.a(6.0f);
        int i3 = screenWidth - a16;
        coerceIn = RangesKt___RangesKt.coerceIn((i3 + a17) / (com.tencent.mobileqq.utils.x.a(195.0f) + a17), 2, 5);
        mostCardCnt = coerceIn;
        int i16 = (i3 - (a17 * (coerceIn - 1))) / coerceIn;
        cardWidth = i16;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast((int) (i16 * 0.8717949f), com.tencent.mobileqq.utils.x.a(170.0f));
        cardHeight = coerceAtLeast;
        int d16 = cardWidth - ((int) cw.d(10));
        horizontalSpacing = Math.min((d16 * 12) / 150, (int) cw.d(12));
        avatarSize = Math.min((d16 * 38) / 150, (int) cw.d(38));
        QLog.e("GridLayoutHelper", 1, "mostCardCnt=" + mostCardCnt + " screenWidth:" + screenWidth + "  orientation=" + RFWApplication.getApplication().getResources().getConfiguration().orientation);
    }
}

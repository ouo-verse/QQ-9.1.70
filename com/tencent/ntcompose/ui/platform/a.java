package com.tencent.ntcompose.ui.platform;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import com.tencent.kuikly.core.base.n;
import com.tencent.kuikly.core.pager.g;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import kotlin.Metadata;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b/\u00100J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u001b\u0010\u0011\u001a\u00020\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0014\u001a\u00020\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0013\u0010\u0010R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\nR\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\nR\u001b\u0010\u0019\u001a\u00020\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\n\u001a\u0004\b\t\u0010\u0010R\u001b\u0010\u001b\u001a\u00020\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\n\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u001e\u001a\u00020\u001c8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u001dR\u0011\u0010\u001f\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u0010R\u0011\u0010 \u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0010R\u0011\u0010$\u001a\u00020!8F\u00a2\u0006\u0006\u001a\u0004\b\"\u0010#R\u0011\u0010&\u001a\u00020!8F\u00a2\u0006\u0006\u001a\u0004\b%\u0010#R\u0011\u0010(\u001a\u00020!8F\u00a2\u0006\u0006\u001a\u0004\b'\u0010#R\u0011\u0010*\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b)\u0010\u0010R\u0011\u0010+\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\u0010R\u0011\u0010.\u001a\u00020,8F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010-\u00a8\u00061"}, d2 = {"Lcom/tencent/ntcompose/ui/platform/a;", "", "", "width", "height", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/compose/runtime/MutableState;", "", "a", "Landroidx/compose/runtime/MutableState;", "_pageViewWidth", "b", "_activityWidth", "c", "getActivityWidth", "()F", "activityWidth", "d", "e", "pageViewWidth", "_pageViewHeight", "f", "_activityHeight", "g", "activityHeight", h.F, "pageViewHeight", "Lcom/tencent/kuikly/core/pager/g;", "()Lcom/tencent/kuikly/core/pager/g;", ISchemeApi.KEY_PAGE_DATA, "screenWidthDp", "screenHeightDp", "", "k", "()Z", "isIOS", "j", "isAndroid", "l", "isIphoneX", "i", "statusBarHeight", "navigationBarHeight", "Lcom/tencent/kuikly/core/base/n;", "()Lcom/tencent/kuikly/core/base/n;", "safeAreaInsets", "<init>", "()V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private MutableState<Float> _pageViewWidth;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private MutableState<Float> _activityWidth;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final MutableState activityWidth;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final MutableState pageViewWidth;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private MutableState<Float> _pageViewHeight;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private MutableState<Float> _activityHeight;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final MutableState activityHeight;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final MutableState pageViewHeight;

    public a() {
        MutableState<Float> mutableStateOf$default;
        float c16;
        MutableState<Float> mutableStateOf$default2;
        MutableState<Float> mutableStateOf$default3;
        float b16;
        MutableState<Float> mutableStateOf$default4;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(c().m()), null, 2, null);
        this._pageViewWidth = mutableStateOf$default;
        if (c().c() == 0.0f) {
            c16 = c().m();
        } else {
            c16 = c().c();
        }
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(c16), null, 2, null);
        this._activityWidth = mutableStateOf$default2;
        this.activityWidth = mutableStateOf$default2;
        this.pageViewWidth = this._pageViewWidth;
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(c().l()), null, 2, null);
        this._pageViewHeight = mutableStateOf$default3;
        boolean z16 = c().b() == 0.0f;
        g c17 = c();
        if (z16) {
            b16 = c17.l();
        } else {
            b16 = c17.b();
        }
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(b16), null, 2, null);
        this._activityHeight = mutableStateOf$default4;
        this.activityHeight = mutableStateOf$default4;
        this.pageViewHeight = this._pageViewHeight;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final float a() {
        return ((Number) this.activityHeight.getValue()).floatValue();
    }

    public final float b() {
        return c().getNavigationBarHeight();
    }

    public final g c() {
        return com.tencent.kuikly.core.manager.c.f117352a.g().getPageData();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final float d() {
        return ((Number) this.pageViewHeight.getValue()).floatValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final float e() {
        return ((Number) this.pageViewWidth.getValue()).floatValue();
    }

    public final n f() {
        return c().getSafeAreaInsets();
    }

    public final float g() {
        return c().g();
    }

    public final float h() {
        return c().h();
    }

    public final float i() {
        return c().getStatusBarHeight();
    }

    public final boolean j() {
        return c().getIsAndroid();
    }

    public final boolean k() {
        return c().getIsIOS();
    }

    public final boolean l() {
        return c().getIsIphoneX();
    }

    public final void m(double width, double height) {
        float f16 = (float) width;
        this._pageViewWidth.setValue(Float.valueOf(f16));
        float f17 = (float) height;
        this._pageViewHeight.setValue(Float.valueOf(f17));
        this._activityWidth.setValue(Float.valueOf(f16));
        this._activityHeight.setValue(Float.valueOf(f17));
    }
}

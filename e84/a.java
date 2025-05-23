package e84;

import android.content.Context;
import android.graphics.Rect;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.utils.ScreenUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import t74.u;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R\u0016\u0010\u0015\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0016R\u0016\u0010\u001f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0016\u00a8\u0006\""}, d2 = {"Le84/a;", "Le84/b;", "", "c", "Landroid/content/Context;", "context", "g", "Landroid/graphics/Rect;", "a", "d", "", "e", "f", "fullViewWidth", "fullViewHeight", "b", "", "isFolderScreenOpen", h.F, "", UserInfo.SEX_FEMALE, "curRateHw", "I", "mFullWidth", "mNormalHeight", "mFullHeight", "Landroid/graphics/Rect;", "mNormalSize", "mFullSize", "mFullScreenViewHeight", "i", "mFullScreenViewWidth", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a implements b {

    /* renamed from: a, reason: collision with root package name */
    public static final a f395879a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static float curRateHw;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int mFullWidth;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static int mNormalHeight;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static int mFullHeight;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final Rect mNormalSize;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static final Rect mFullSize;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static int mFullScreenViewHeight;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static int mFullScreenViewWidth;

    static {
        a aVar = new a();
        f395879a = aVar;
        curRateHw = 1.16f;
        mNormalSize = new Rect();
        mFullSize = new Rect();
        Context context = Foreground.getTopActivity();
        if (context == null) {
            context = BaseApplication.context;
            Intrinsics.checkNotNullExpressionValue(context, "context");
        }
        aVar.g(context);
    }

    a() {
    }

    private final void c() {
        if (Foreground.getTopActivity() == null) {
            BaseApplication context = BaseApplication.context;
            Intrinsics.checkNotNullExpressionValue(context, "context");
        }
        int i3 = mFullScreenViewWidth;
        mFullWidth = i3;
        int i16 = mFullScreenViewHeight;
        mFullHeight = i16;
        int i17 = (int) (i3 * curRateHw);
        mNormalHeight = i17;
        Rect rect = mNormalSize;
        rect.left = 0;
        rect.top = 0;
        rect.right = i3;
        rect.bottom = i17 + 0;
        Rect rect2 = mFullSize;
        rect2.left = 0;
        rect2.top = 0;
        rect2.right = i3;
        rect2.bottom = i16;
        QLog.i("AvatarSizeApiImpl_", 1, "mNormalSize:" + rect + ", mFullSize:" + rect2);
    }

    @Override // e84.b
    public Rect a() {
        return mNormalSize;
    }

    @Override // e84.b
    public void b(int fullViewWidth, int fullViewHeight) {
        boolean z16;
        QLog.i("AvatarSizeApiImpl_", 1, "reCalculateSize fullViewHeight\uff1a" + fullViewHeight + ", fullViewWidth:" + fullViewWidth);
        boolean z17 = false;
        if (fullViewHeight <= 0 || mFullHeight == fullViewHeight) {
            z16 = false;
        } else {
            mFullScreenViewHeight = fullViewHeight;
            z16 = true;
        }
        if (fullViewWidth > 0 && mFullWidth != fullViewWidth) {
            mFullScreenViewWidth = fullViewWidth;
            z17 = true;
        }
        if (z17 || z16) {
            c();
        }
        QLog.i("AvatarSizeApiImpl_", 1, "reCalculateSize mFullSize" + mFullSize + ", mNormalSize:" + mNormalSize);
    }

    public Rect d() {
        return mFullSize;
    }

    public int e() {
        return mFullSize.height();
    }

    public int f() {
        return mFullSize.width();
    }

    public void g(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int i3 = context.getResources().getConfiguration().orientation;
        QLog.i("AvatarSizeApiImpl_", 1, "resetParams ctxOrientation:" + i3);
        int screenWidth = ScreenUtils.getScreenWidth(context);
        int screenHeight = ScreenUtils.getScreenHeight(context) + ImmersiveUtils.getStatusBarHeight(context);
        if (i3 != 2) {
            screenHeight = screenWidth;
            screenWidth = screenHeight;
        }
        mFullScreenViewHeight = screenWidth;
        mFullScreenViewWidth = screenHeight;
        h(u.Companion.e(u.INSTANCE, context, false, 2, null));
        QLog.i("AvatarSizeApiImpl_", 1, "init height:" + mFullScreenViewHeight + ", width:" + mFullScreenViewWidth + ", context:" + context);
        c();
    }

    public void h(boolean isFolderScreenOpen) {
        float f16 = isFolderScreenOpen ? 0.8f : 1.16f;
        curRateHw = f16;
        QLog.i("AvatarSizeApiImpl_", 1, "updateRateHW " + isFolderScreenOpen + " - " + f16);
    }
}

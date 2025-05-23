package com.tencent.qqnt.chats.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.util.view.b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 E2\u00020\u0001:\u0001\u000eB\u0011\b\u0016\u0012\u0006\u0010=\u001a\u00020<\u00a2\u0006\u0004\b>\u0010?B\u001b\b\u0016\u0012\u0006\u0010=\u001a\u00020<\u0012\b\u0010A\u001a\u0004\u0018\u00010@\u00a2\u0006\u0004\b>\u0010BB#\b\u0016\u0012\u0006\u0010=\u001a\u00020<\u0012\b\u0010A\u001a\u0004\u0018\u00010@\u0012\u0006\u0010C\u001a\u00020\u000f\u00a2\u0006\u0004\b>\u0010DJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u001e\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u0004J\u0016\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fJ\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000fJ\u0016\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fJ\u0016\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000fJ\u000e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u000fJ\u000e\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u000fR\u0016\u0010\u001e\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0016\u0010\"\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001dR\u0016\u0010$\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\u001dR\u0016\u0010&\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010\u001dR\u0016\u0010)\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010\u001dR\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00104\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u00102R\u0016\u00106\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010\u001dR\u0016\u00108\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u0010\u001dR\u0016\u00109\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001dR\u0016\u0010;\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010\u001d\u00a8\u0006F"}, d2 = {"Lcom/tencent/qqnt/chats/view/widget/HollowOutAvatarFrameLayout;", "Landroid/widget/FrameLayout;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "draw", "dispatchDraw", "", "redPointWidth", "redPointHeight", "", "isNumPoint", "setTopRightHole", "setBottomRightHole", "a", "", "horizontalOffset", "verticalOffset", "setUnreadOffset", "radius", "setStateIconRoundRadius", "setStateIconOffset", "width", "high", "setSize", "hollowOutSize", "setUnreadHollowOutSize", "setStateIconHollowOutSize", "d", "I", "mWidth", "e", "mHigh", "f", "mUnreadHollowOutSize", h.F, "mStateIconHollowOutSize", "i", "mNumPointRoundRadius", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, UserInfo.SEX_FEMALE, "mPointRoundRadius", BdhLogUtil.LogTag.Tag_Conn, "mStateIconRoundRadius", "Landroid/graphics/Paint;", "D", "Landroid/graphics/Paint;", "mPaint", "Landroid/graphics/Path;", "E", "Landroid/graphics/Path;", "mUnreadPointPath", "mStateIconPath", "G", "mUnreadHorizontalOffset", "H", "mUnreadVerticalOffset", "mStateIconHorizontalOffset", "J", "mStateIconVerticalOffset", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "K", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class HollowOutAvatarFrameLayout extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private int mStateIconRoundRadius;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Paint mPaint;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Path mUnreadPointPath;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private Path mStateIconPath;

    /* renamed from: G, reason: from kotlin metadata */
    private int mUnreadHorizontalOffset;

    /* renamed from: H, reason: from kotlin metadata */
    private int mUnreadVerticalOffset;

    /* renamed from: I, reason: from kotlin metadata */
    private int mStateIconHorizontalOffset;

    /* renamed from: J, reason: from kotlin metadata */
    private int mStateIconVerticalOffset;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mWidth;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mHigh;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mUnreadHollowOutSize;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mStateIconHollowOutSize;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mNumPointRoundRadius;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float mPointRoundRadius;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chats/view/widget/HollowOutAvatarFrameLayout$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.view.widget.HollowOutAvatarFrameLayout$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57627);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HollowOutAvatarFrameLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mWidth = 58;
        this.mHigh = 58;
        this.mUnreadHollowOutSize = 2;
        this.mStateIconHollowOutSize = 2;
        this.mNumPointRoundRadius = 10;
        this.mPointRoundRadius = 7.5f;
        this.mStateIconRoundRadius = 8;
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        if (Build.VERSION.SDK_INT >= 28 || getLayerType() == 1) {
            return;
        }
        setLayerType(1, null);
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else if (this.mStateIconPath != null) {
            this.mStateIconPath = null;
            invalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.mStateIconPath != null) {
            int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null);
            super.dispatchDraw(canvas);
            Path path = this.mStateIconPath;
            Intrinsics.checkNotNull(path);
            canvas.drawPath(path, this.mPaint);
            canvas.restoreToCount(saveLayer);
            return;
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.View
    public void draw(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.draw(canvas);
        Path path = this.mUnreadPointPath;
        if (path != null) {
            Intrinsics.checkNotNull(path);
            canvas.drawPath(path, this.mPaint);
        }
    }

    public final void setBottomRightHole() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        this.mStateIconPath = new Path();
        b bVar = b.f362999a;
        int b16 = (bVar.b(this.mWidth) - bVar.b(this.mStateIconRoundRadius)) + bVar.b(this.mStateIconHorizontalOffset);
        int b17 = (bVar.b(this.mHigh) - bVar.b(this.mStateIconRoundRadius)) + bVar.b(this.mStateIconHorizontalOffset);
        Path path = this.mStateIconPath;
        Intrinsics.checkNotNull(path);
        path.addCircle(b16, b17, bVar.b(this.mStateIconHollowOutSize) + bVar.b(this.mStateIconRoundRadius), Path.Direction.CCW);
        invalidate();
    }

    public final void setSize(int width, int high) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(width), Integer.valueOf(high));
        } else {
            this.mWidth = width;
            this.mHigh = high;
        }
    }

    public final void setStateIconHollowOutSize(int hollowOutSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, hollowOutSize);
        } else {
            this.mStateIconHollowOutSize = hollowOutSize;
        }
    }

    public final void setStateIconOffset(int horizontalOffset, int verticalOffset) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(horizontalOffset), Integer.valueOf(verticalOffset));
        } else {
            this.mStateIconHorizontalOffset = horizontalOffset;
            this.mStateIconVerticalOffset = verticalOffset;
        }
    }

    public final void setStateIconRoundRadius(int radius) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, radius);
        } else {
            this.mStateIconRoundRadius = radius;
        }
    }

    public final void setTopRightHole(float redPointWidth, float redPointHeight, boolean isNumPoint) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Float.valueOf(redPointWidth), Float.valueOf(redPointHeight), Boolean.valueOf(isNumPoint));
            return;
        }
        if (redPointWidth == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (redPointHeight != 0.0f) {
                z17 = false;
            }
            if (z17) {
                this.mUnreadPointPath = null;
                invalidate();
                return;
            }
        }
        b bVar = b.f362999a;
        RectF rectF = new RectF(((bVar.b(this.mWidth) - bVar.b(this.mUnreadHollowOutSize)) - redPointWidth) + this.mUnreadHorizontalOffset, (bVar.b(this.mUnreadHollowOutSize) * (-1)) + this.mUnreadVerticalOffset, bVar.b(this.mWidth) + bVar.b(this.mUnreadHollowOutSize) + this.mUnreadHorizontalOffset, redPointHeight + bVar.b(this.mUnreadHollowOutSize) + this.mUnreadVerticalOffset);
        Path path = new Path();
        this.mUnreadPointPath = path;
        if (isNumPoint) {
            Intrinsics.checkNotNull(path);
            path.addRoundRect(rectF, bVar.b(this.mNumPointRoundRadius), bVar.b(this.mNumPointRoundRadius), Path.Direction.CCW);
        } else {
            Intrinsics.checkNotNull(path);
            path.addRoundRect(rectF, bVar.a(this.mPointRoundRadius), bVar.a(this.mPointRoundRadius), Path.Direction.CCW);
        }
        invalidate();
    }

    public final void setUnreadHollowOutSize(int hollowOutSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, hollowOutSize);
        } else {
            this.mUnreadHollowOutSize = hollowOutSize;
        }
    }

    public final void setUnreadOffset(int horizontalOffset, int verticalOffset) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(horizontalOffset), Integer.valueOf(verticalOffset));
        } else {
            this.mUnreadHorizontalOffset = horizontalOffset;
            this.mUnreadVerticalOffset = verticalOffset;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HollowOutAvatarFrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.mWidth = 58;
        this.mHigh = 58;
        this.mUnreadHollowOutSize = 2;
        this.mStateIconHollowOutSize = 2;
        this.mNumPointRoundRadius = 10;
        this.mPointRoundRadius = 7.5f;
        this.mStateIconRoundRadius = 8;
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        if (Build.VERSION.SDK_INT >= 28 || getLayerType() == 1) {
            return;
        }
        setLayerType(1, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HollowOutAvatarFrameLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mWidth = 58;
        this.mHigh = 58;
        this.mUnreadHollowOutSize = 2;
        this.mStateIconHollowOutSize = 2;
        this.mNumPointRoundRadius = 10;
        this.mPointRoundRadius = 7.5f;
        this.mStateIconRoundRadius = 8;
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        if (Build.VERSION.SDK_INT >= 28 || getLayerType() == 1) {
            return;
        }
        setLayerType(1, null);
    }
}

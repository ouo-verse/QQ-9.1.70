package com.tencent.mobileqq.qqui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 /2\u00020\u0001:\u00010B\u0011\b\u0016\u0012\u0006\u0010'\u001a\u00020&\u00a2\u0006\u0004\b(\u0010)B\u001b\b\u0016\u0012\u0006\u0010'\u001a\u00020&\u0012\b\u0010+\u001a\u0004\u0018\u00010*\u00a2\u0006\u0004\b(\u0010,B#\b\u0016\u0012\u0006\u0010'\u001a\u00020&\u0012\b\u0010+\u001a\u0004\u0018\u00010*\u0012\u0006\u0010-\u001a\u00020\u0006\u00a2\u0006\u0004\b(\u0010.J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002J\u0010\u0010\u000e\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\fJ\b\u0010\u000f\u001a\u0004\u0018\u00010\fJ\u000e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/qqui/widget/RoundBubbleImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "", "dp", "Landroid/content/res/Resources;", "res", "", "l", "", "init", "radius", "setRadiusDP", "Landroid/graphics/drawable/Drawable;", "borderImg", "setBorderImg", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "rectRadius", "setRadii", "Landroid/graphics/Canvas;", PM.CANVAS, "draw", "Landroid/graphics/RectF;", "Landroid/graphics/RectF;", "mRectF", BdhLogUtil.LogTag.Tag_Conn, "[F", "mRadiusList", "Landroid/graphics/Path;", "D", "Landroid/graphics/Path;", "mPath", "E", "Landroid/graphics/drawable/Drawable;", "mBorderImg", UserInfo.SEX_FEMALE, "Landroid/content/res/Resources;", "mRes", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "G", "a", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class RoundBubbleImageView extends AppCompatImageView {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private float[] mRadiusList;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Path mPath;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Drawable mBorderImg;

    /* renamed from: F, reason: from kotlin metadata */
    private Resources mRes;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RectF mRectF;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqui/widget/RoundBubbleImageView$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqui.widget.RoundBubbleImageView$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39327);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundBubbleImageView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mRectF = new RectF();
        this.mRadiusList = new float[8];
        this.mPath = new Path();
        init();
    }

    private final int l(float dp5, Resources res) {
        return (int) ((res.getDisplayMetrics().density * dp5) + 0.5f);
    }

    @Override // android.view.View
    public void draw(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        this.mRectF.left = getPaddingLeft();
        this.mRectF.top = getPaddingTop();
        this.mRectF.right = getPaddingLeft() + width;
        this.mRectF.bottom = getPaddingTop() + height;
        this.mPath.reset();
        this.mPath.addRoundRect(this.mRectF, this.mRadiusList, Path.Direction.CCW);
        this.mPath.setFillType(Path.FillType.EVEN_ODD);
        canvas.clipPath(this.mPath);
        super.draw(canvas);
        Drawable drawable = this.mBorderImg;
        if (drawable != null) {
            RectF rectF = this.mRectF;
            drawable.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        }
        Drawable drawable2 = this.mBorderImg;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    public final void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "this.resources");
        this.mRes = resources;
    }

    @Nullable
    public final Drawable m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Drawable) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.mBorderImg;
    }

    public final void setBorderImg(@Nullable Drawable borderImg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) borderImg);
        } else {
            this.mBorderImg = borderImg;
        }
    }

    public final void setRadii(@NotNull float[] rectRadius) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) rectRadius);
        } else {
            Intrinsics.checkNotNullParameter(rectRadius, "rectRadius");
            this.mRadiusList = rectRadius;
        }
    }

    public final void setRadiusDP(float radius) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Float.valueOf(radius));
            return;
        }
        Resources resources = this.mRes;
        if (resources == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRes");
            resources = null;
        }
        Arrays.fill(this.mRadiusList, l(radius, resources));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundBubbleImageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.mRectF = new RectF();
        this.mRadiusList = new float[8];
        this.mPath = new Path();
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundBubbleImageView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mRectF = new RectF();
        this.mRadiusList = new float[8];
        this.mPath = new Path();
        init();
    }
}

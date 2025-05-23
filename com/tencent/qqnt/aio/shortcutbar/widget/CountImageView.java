package com.tencent.qqnt.aio.shortcutbar.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
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

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001,B\u0011\b\u0016\u0012\u0006\u0010#\u001a\u00020\"\u00a2\u0006\u0004\b$\u0010%B\u001b\b\u0016\u0012\u0006\u0010#\u001a\u00020\"\u0012\b\u0010'\u001a\u0004\u0018\u00010&\u00a2\u0006\u0004\b$\u0010(B#\b\u0016\u0012\u0006\u0010#\u001a\u00020\"\u0012\b\u0010'\u001a\u0004\u0018\u00010&\u0012\u0006\u0010)\u001a\u00020\u0006\u00a2\u0006\u0004\b$\u0010*J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0006J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0014R\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0016R\u0016\u0010\u001c\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0013R\u0016\u0010\u001e\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0013R\u0016\u0010\u001f\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0013R\u0016\u0010!\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u0013\u00a8\u0006-"}, d2 = {"Lcom/tencent/qqnt/aio/shortcutbar/widget/CountImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "radius", "", "colorId", "", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", WidgetCacheConstellationData.NUM, "setNum", "onDraw", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "paint", BdhLogUtil.LogTag.Tag_Conn, "I", "count", "D", UserInfo.SEX_FEMALE, "insideRadius", "E", "outsideRadius", "textSize", "G", "pRight", "H", "pTop", "imageWidth", "J", "imageHeight", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "K", "a", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class CountImageView extends AppCompatImageView {
    static IPatchRedirector $redirector_;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private int count;

    /* renamed from: D, reason: from kotlin metadata */
    private float insideRadius;

    /* renamed from: E, reason: from kotlin metadata */
    private float outsideRadius;

    /* renamed from: F, reason: from kotlin metadata */
    private float textSize;

    /* renamed from: G, reason: from kotlin metadata */
    private int pRight;

    /* renamed from: H, reason: from kotlin metadata */
    private int pTop;

    /* renamed from: I, reason: from kotlin metadata */
    private int imageWidth;

    /* renamed from: J, reason: from kotlin metadata */
    private int imageHeight;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint paint;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/aio/shortcutbar/widget/CountImageView$a;", "", "", "IMAGE_HEIGHT", "I", "IMAGE_WIDTH", "", "INSIDE_CIRCLE_RADIUS", UserInfo.SEX_FEMALE, "OUTSIDE_CIRCLE_RADIUS", "<init>", "()V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.shortcutbar.widget.CountImageView$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47814);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CountImageView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.paint = new Paint();
        b bVar = b.f362999a;
        this.imageWidth = bVar.b(23);
        this.imageHeight = bVar.b(20);
    }

    private final void l(Canvas canvas, float radius, int colorId) {
        this.paint.setColor(getContext().getColor(colorId));
        canvas.drawCircle((getWidth() / 2) + radius + m(radius), o(), radius, this.paint);
    }

    private final float m(float radius) {
        return (this.imageWidth / 2) - radius;
    }

    private final float o() {
        return (getHeight() - this.imageHeight) / 2;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 5;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas);
            return;
        }
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (this.count <= 0) {
            return;
        }
        b bVar = b.f362999a;
        this.insideRadius = bVar.c(7.0f);
        float c16 = bVar.c(8.0f);
        this.outsideRadius = c16;
        if (this.count >= 10) {
            i3 = 0;
        }
        this.textSize = c16 + i3;
        this.pRight = getPaddingRight();
        this.pTop = getPaddingTop();
        this.paint.setAntiAlias(true);
        this.paint.setStyle(Paint.Style.FILL);
        l(canvas, this.outsideRadius, R.color.f158017al3);
        l(canvas, this.insideRadius, R.color.qui_button_bg_primary_default);
        this.paint.setColor(getContext().getColor(R.color.qui_common_on_brand_primary));
        this.paint.setTextSize(this.textSize);
        this.paint.setTextAlign(Paint.Align.CENTER);
        String valueOf = String.valueOf(this.count);
        float width = getWidth() / 2;
        float f16 = this.insideRadius;
        float f17 = 2;
        canvas.drawText(valueOf, width + f16 + m(f16), (o() - (this.paint.getFontMetrics().top / f17)) - (this.paint.getFontMetrics().bottom / f17), this.paint);
    }

    public final void setNum(int num) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, num);
        } else {
            this.count = num;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CountImageView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.paint = new Paint();
        b bVar = b.f362999a;
        this.imageWidth = bVar.b(23);
        this.imageHeight = bVar.b(20);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CountImageView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.paint = new Paint();
        b bVar = b.f362999a;
        this.imageWidth = bVar.b(23);
        this.imageHeight = bVar.b(20);
    }
}

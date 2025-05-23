package com.tencent.mobileqq.aio.msglist.holder.component.stream.anomator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.SpannableString;
import android.text.style.ReplacementSpan;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0005B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/stream/anomator/e;", "", "Landroid/content/Context;", "context", "Landroid/text/SpannableString;", "a", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f191878a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001c\u0010\u001dJ4\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016JR\u0010\u0014\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/stream/anomator/e$a;", "Landroid/text/style/ReplacementSpan;", "Landroid/graphics/Paint;", "paint", "", "text", "", "start", "end", "Landroid/graphics/Paint$FontMetricsInt;", "fm", "getSize", "Landroid/graphics/Canvas;", PM.CANVAS, "", HippyTKDListViewAdapter.X, "top", "y", "bottom", "", "draw", "Landroid/graphics/drawable/Drawable;", "d", "Landroid/graphics/drawable/Drawable;", "drawable", "e", "I", NodeProps.MARGIN_HORIZONTAL, "<init>", "(Landroid/graphics/drawable/Drawable;I)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class a extends ReplacementSpan {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Drawable drawable;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int marginHorizontal;

        public a(@NotNull Drawable drawable, int i3) {
            Intrinsics.checkNotNullParameter(drawable, "drawable");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) drawable, i3);
            } else {
                this.drawable = drawable;
                this.marginHorizontal = i3;
            }
        }

        @Override // android.text.style.ReplacementSpan
        public void draw(@NotNull Canvas canvas, @Nullable CharSequence text, int start, int end, float x16, int top, int y16, int bottom, @NotNull Paint paint) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, canvas, text, Integer.valueOf(start), Integer.valueOf(end), Float.valueOf(x16), Integer.valueOf(top), Integer.valueOf(y16), Integer.valueOf(bottom), paint);
                return;
            }
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Intrinsics.checkNotNullParameter(paint, "paint");
            canvas.save();
            Intrinsics.checkNotNullExpressionValue(this.drawable.getBounds(), "drawable.bounds");
            canvas.translate(x16 + this.marginHorizontal, (top + ((bottom - top) / 2)) - (r7.height() / 2));
            this.drawable.draw(canvas);
            canvas.restore();
        }

        @Override // android.text.style.ReplacementSpan
        public int getSize(@NotNull Paint paint, @Nullable CharSequence text, int start, int end, @Nullable Paint.FontMetricsInt fm5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, this, paint, text, Integer.valueOf(start), Integer.valueOf(end), fm5)).intValue();
            }
            Intrinsics.checkNotNullParameter(paint, "paint");
            Rect bounds = this.drawable.getBounds();
            Intrinsics.checkNotNullExpressionValue(bounds, "drawable.getBounds()");
            return bounds.width() + (this.marginHorizontal * 2);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63229);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f191878a = new e();
        }
    }

    e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final SpannableString a(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SpannableString) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.setIntrinsicHeight(ViewUtils.dpToPx(6.0f));
        shapeDrawable.setIntrinsicWidth(ViewUtils.dpToPx(6.0f));
        shapeDrawable.setBounds(0, 0, shapeDrawable.getIntrinsicWidth(), shapeDrawable.getIntrinsicHeight());
        shapeDrawable.getPaint().setColor(context.getColor(R.color.qui_common_bubble_guest_text_primary));
        a aVar = new a(shapeDrawable, ViewUtils.dpToPx(3.5f));
        SpannableString spannableString = new SpannableString("\u25cf");
        spannableString.setSpan(aVar, 0, spannableString.length(), 33);
        return spannableString;
    }
}

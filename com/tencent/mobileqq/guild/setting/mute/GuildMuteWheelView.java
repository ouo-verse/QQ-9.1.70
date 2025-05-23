package com.tencent.mobileqq.guild.setting.mute;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.remind.widget.WheelView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.xweb.FileReaderHelper;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B'\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/mute/GuildMuteWheelView;", "Lcom/tencent/mobileqq/remind/widget/WheelView;", "", FileReaderHelper.TXT_EXT, "", "setExtraText", "Landroid/graphics/Canvas;", PM.CANVAS, "dispatchDraw", "Landroid/graphics/Paint;", "d", "Landroid/graphics/Paint;", "mTextPaint", "e", "Ljava/lang/String;", "mExtraText", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "f", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMuteWheelView extends WheelView {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint mTextPaint;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mExtraText;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildMuteWheelView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@NotNull Canvas canvas) {
        int c16;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.dispatchDraw(canvas);
        if (!TextUtils.isEmpty(this.mExtraText) && getChildCount() >= 1) {
            if (GuildThemeManager.f235286a.b()) {
                c16 = GuildMuteCustomTimePickView.INSTANCE.d();
            } else {
                c16 = GuildMuteCustomTimePickView.INSTANCE.c();
            }
            this.mTextPaint.setColor(c16);
            float height = (getHeight() / 2) - ((this.mTextPaint.descent() + this.mTextPaint.ascent()) / 2);
            String str = this.mExtraText;
            Intrinsics.checkNotNull(str);
            canvas.drawText(str, getWidth() / 2.0f, height, this.mTextPaint);
        }
    }

    public final void setExtraText(@NotNull String txt) {
        Intrinsics.checkNotNullParameter(txt, "txt");
        this.mExtraText = txt;
        postInvalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildMuteWheelView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildMuteWheelView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildMuteWheelView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Paint paint = new Paint();
        this.mTextPaint = paint;
        paint.setAntiAlias(true);
        paint.setTextSize(ViewUtils.dip2px(17.0f));
    }
}

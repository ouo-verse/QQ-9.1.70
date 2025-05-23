package com.tencent.mobileqq.vas.flash;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.flashname.IFlashNickNameComponent;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x03.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J.\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0006J\u0006\u0010\u000f\u001a\u00020\u0004R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/vas/flash/VipFlashNickNameView;", "Landroid/widget/TextView;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "onDraw", "", "width", "height", "", "colorValue", "", "isSingle", "repeatCount", "a", "b", "Lx03/b;", "d", "Lx03/b;", "flashNickName", "e", "I", "textWidth", "f", "textHeight", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "vas_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VipFlashNickNameView extends TextView {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b flashNickName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int textWidth;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int textHeight;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VipFlashNickNameView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void a(int width, int height, @NotNull String colorValue, boolean isSingle, int repeatCount) {
        Intrinsics.checkNotNullParameter(colorValue, "colorValue");
        this.textWidth = width;
        this.textHeight = height;
        b createFlashNickName = ((IFlashNickNameComponent) QRoute.api(IFlashNickNameComponent.class)).createFlashNickName(width, height, colorValue, isSingle, this);
        this.flashNickName = createFlashNickName;
        if (createFlashNickName != null) {
            createFlashNickName.c(repeatCount);
        }
    }

    public final void b() {
        b bVar = this.flashNickName;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        b bVar = this.flashNickName;
        if (bVar != null && !bVar.d()) {
            canvas.saveLayerAlpha(0.0f, 0.0f, this.textWidth, Math.max(this.textHeight, getHeight()), 255);
            super.onDraw(canvas);
            bVar.b(canvas);
            canvas.restore();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VipFlashNickNameView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ VipFlashNickNameView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VipFlashNickNameView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}

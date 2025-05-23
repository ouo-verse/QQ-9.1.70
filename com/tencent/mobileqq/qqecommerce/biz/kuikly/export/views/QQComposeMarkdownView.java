package com.tencent.mobileqq.qqecommerce.biz.kuikly.export.views;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.kuikly.core.render.android.expand.component.KRView;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014R\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/views/QQComposeMarkdownView;", "Lcom/tencent/kuikly/core/render/android/expand/component/KRView;", "Li01/b;", "shadow", "", CanvasView.ACTION_SET_SHADOW, "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/views/QQComposeMarkdownShadow;", "H", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/views/QQComposeMarkdownShadow;", "markdownShadow", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "I", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class QQComposeMarkdownView extends KRView {

    /* renamed from: H, reason: from kotlin metadata */
    private QQComposeMarkdownShadow markdownShadow;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQComposeMarkdownView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Layout textLayout;
        super.onDraw(canvas);
        QQComposeMarkdownShadow qQComposeMarkdownShadow = this.markdownShadow;
        if (qQComposeMarkdownShadow == null || (textLayout = qQComposeMarkdownShadow.getTextLayout()) == null) {
            return;
        }
        textLayout.draw(canvas);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c
    public void setShadow(i01.b shadow) {
        Intrinsics.checkNotNullParameter(shadow, "shadow");
        this.markdownShadow = (QQComposeMarkdownShadow) shadow;
        invalidate();
    }
}

package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Size;
import android.widget.LinearLayout;
import com.tencent.biz.qqcircle.utils.cx;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B!\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011B\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0012B\u001b\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u0010\u0010\u0013R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/personal/widget/QFSPersonalVisitorGuideAnimationView;", "Landroid/widget/LinearLayout;", "", "d", "Z", "getHasShow", "()Z", "setHasShow", "(Z)V", "hasShow", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "e", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSPersonalVisitorGuideAnimationView extends LinearLayout {

    /* renamed from: f, reason: collision with root package name */
    private static final int f89349f;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final Size f89350h;

    /* renamed from: i, reason: collision with root package name */
    private static final int f89351i;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean hasShow;

    static {
        int a16 = cx.a(18.0f);
        f89349f = a16;
        f89350h = new Size(a16, a16);
        f89351i = -cx.a(6.0f);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSPersonalVisitorGuideAnimationView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        setOrientation(0);
        setGravity(1);
        setClipChildren(false);
        setClipToPadding(false);
    }

    public final void setHasShow(boolean z16) {
        this.hasShow = z16;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QFSPersonalVisitorGuideAnimationView(@NotNull Context context) {
        this(context, null, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QFSPersonalVisitorGuideAnimationView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}

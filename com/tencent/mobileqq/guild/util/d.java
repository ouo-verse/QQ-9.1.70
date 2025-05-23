package com.tencent.mobileqq.guild.util;

import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import androidx.annotation.ColorRes;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 \"2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b&\u0010'J\u0012\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\bH\u0016R$\u0010\u0012\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0019\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010 \u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001b\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/guild/util/d;", "Lcom/tencent/mobileqq/guild/util/c;", "", "color", "", "setColor", "", "useUnderLine", "Lkotlin/Function1;", "Landroid/view/View;", NodeProps.ON_CLICK, "a", "Landroid/text/style/ForegroundColorSpan;", "Landroid/text/style/ForegroundColorSpan;", "b", "()Landroid/text/style/ForegroundColorSpan;", "setForegroundColorSpan", "(Landroid/text/style/ForegroundColorSpan;)V", "foregroundColorSpan", "Landroid/text/style/AbsoluteSizeSpan;", "Landroid/text/style/AbsoluteSizeSpan;", "d", "()Landroid/text/style/AbsoluteSizeSpan;", "setTextSizeSpan", "(Landroid/text/style/AbsoluteSizeSpan;)V", "textSizeSpan", "Landroid/text/style/ClickableSpan;", "c", "Landroid/text/style/ClickableSpan;", "()Landroid/text/style/ClickableSpan;", "setOnClickSpan", "(Landroid/text/style/ClickableSpan;)V", "onClickSpan", "Z", "e", "()Z", "setUseUnderLine", "(Z)V", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class d implements c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ForegroundColorSpan foregroundColorSpan;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AbsoluteSizeSpan textSizeSpan;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ClickableSpan onClickSpan;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean useUnderLine = true;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/util/d$b", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", NodeProps.ON_CLICK, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends ClickableSpan {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1<View, Unit> f235552d;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function1<? super View, Unit> function1) {
            this.f235552d = function1;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            com.tencent.mobileqq.guild.safety.j.d("DslSpanBuilderImpl", "onClick | id: " + widget.getId() + "}");
            if (o.a(widget)) {
                com.tencent.mobileqq.guild.safety.j.d("DslSpanBuilderImpl", "fastClick | id: " + widget.getId() + "}");
                return;
            }
            this.f235552d.invoke(widget);
        }
    }

    @Override // com.tencent.mobileqq.guild.util.c
    public void a(boolean useUnderLine, @NotNull Function1<? super View, Unit> onClick) {
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.onClickSpan = new b(onClick);
        this.useUnderLine = useUnderLine;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final ForegroundColorSpan getForegroundColorSpan() {
        return this.foregroundColorSpan;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final ClickableSpan getOnClickSpan() {
        return this.onClickSpan;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final AbsoluteSizeSpan getTextSizeSpan() {
        return this.textSizeSpan;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getUseUnderLine() {
        return this.useUnderLine;
    }

    @Override // com.tencent.mobileqq.guild.util.c
    public void setColor(@ColorRes int color) {
        this.foregroundColorSpan = new ForegroundColorSpan(BaseApplication.getContext().getResources().getColor(color));
    }
}

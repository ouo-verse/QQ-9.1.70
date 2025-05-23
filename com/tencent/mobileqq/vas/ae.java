package com.tencent.mobileqq.vas;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010(\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b)\u0010*J\f\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR*\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R0\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010%\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/vas/ae;", "Lcom/tencent/mobileqq/setting/processor/c;", "Lcom/tencent/mobileqq/widget/listitem/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "g", "Ljava/lang/CharSequence;", "leftText", "", tl.h.F, "I", "leftIcon", "Lkotlin/Function0;", "", "i", "Lkotlin/jvm/functions/Function0;", "getOnClick", "()Lkotlin/jvm/functions/Function0;", BdhLogUtil.LogTag.Tag_Conn, "(Lkotlin/jvm/functions/Function0;)V", NodeProps.ON_CLICK, "Lkotlin/Function1;", "Landroid/view/View;", "j", "Lkotlin/jvm/functions/Function1;", "getOnBindView", "()Lkotlin/jvm/functions/Function1;", "B", "(Lkotlin/jvm/functions/Function1;)V", "onBindView", "", "k", "Z", "getVisible", "()Z", "D", "(Z)V", NodeProps.VISIBLE, "Landroid/content/Context;", "context", "type", "<init>", "(Landroid/content/Context;ILjava/lang/CharSequence;I)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class ae extends com.tencent.mobileqq.setting.processor.c {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CharSequence leftText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int leftIcon;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function0<Unit> onClick;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super View, Unit> onBindView;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean visible;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ae(@NotNull Context context, int i3, @NotNull CharSequence leftText, int i16) {
        super(context, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(leftText, "leftText");
        this.leftText = leftText;
        this.leftIcon = i16;
        this.visible = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        VideoReport.traversePage(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(ae this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function0<Unit> function0 = this$0.onClick;
        if (function0 != null) {
            function0.invoke();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(ae this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        Function1<? super View, Unit> function1 = this$0.onBindView;
        if (function1 != null) {
            function1.invoke(it);
        }
    }

    public final void B(@Nullable Function1<? super View, Unit> function1) {
        this.onBindView = function1;
    }

    public final void C(@Nullable Function0<Unit> function0) {
        this.onClick = function0;
    }

    public final void D(boolean z16) {
        this.visible = z16;
    }

    @Override // com.tencent.mobileqq.setting.processor.c
    @NotNull
    public com.tencent.mobileqq.widget.listitem.a<?> q() {
        x.b dVar;
        int i3 = this.leftIcon;
        if (i3 != 0) {
            dVar = new x.b.C8996b(this.leftText, i3);
        } else {
            dVar = new x.b.d(this.leftText);
        }
        com.tencent.mobileqq.widget.listitem.x xVar = new com.tencent.mobileqq.widget.listitem.x(dVar, new x.c.g("", true, false));
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.vas.ab
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ae.y(ae.this, view);
            }
        });
        xVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.vas.ac
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                ae.z(ae.this, view);
            }
        });
        xVar.v(new com.tencent.mobileqq.widget.listitem.f() { // from class: com.tencent.mobileqq.vas.ad
            @Override // com.tencent.mobileqq.widget.listitem.f
            public final void a(View view) {
                ae.A(view);
            }
        });
        xVar.p(this.visible);
        return xVar;
    }
}

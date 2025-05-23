package com.tencent.mobileqq.vas;

import android.content.Context;
import android.view.View;
import android.widget.CompoundButton;
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
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0005\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010*\u001a\u00020)\u0012\u0006\u0010,\u001a\u00020+\u0012\u0006\u0010.\u001a\u00020-\u0012\b\b\u0002\u0010/\u001a\u00020+\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0004\b0\u00101J\f\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR$\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R0\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\"\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R \u0010(\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%0#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/vas/aa;", "Lcom/tencent/mobileqq/setting/processor/c;", "Lcom/tencent/mobileqq/widget/listitem/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "onResume", "Lkotlin/Function0;", "", "g", "Lkotlin/jvm/functions/Function0;", "isChecked", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", tl.h.F, "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "getOnCheckedChange", "()Landroid/widget/CompoundButton$OnCheckedChangeListener;", BdhLogUtil.LogTag.Tag_Conn, "(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V", "onCheckedChange", "Lkotlin/Function1;", "Landroid/view/View;", "i", "Lkotlin/jvm/functions/Function1;", "getOnBindView", "()Lkotlin/jvm/functions/Function1;", "B", "(Lkotlin/jvm/functions/Function1;)V", "onBindView", "j", "Z", "getVisible", "()Z", "D", "(Z)V", NodeProps.VISIBLE, "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$f;", "k", "Lcom/tencent/mobileqq/widget/listitem/x;", "itemConfig", "Landroid/content/Context;", "context", "", "type", "", "leftText", "leftIcon", "<init>", "(Landroid/content/Context;ILjava/lang/CharSequence;ILkotlin/jvm/functions/Function0;)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class aa extends com.tencent.mobileqq.setting.processor.c {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Function0<Boolean> isChecked;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CompoundButton.OnCheckedChangeListener onCheckedChange;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super View, Unit> onBindView;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean visible;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> itemConfig;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(@NotNull Context context, int i3, @NotNull CharSequence leftText, int i16, @NotNull Function0<Boolean> isChecked) {
        super(context, i3);
        x.b dVar;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(leftText, "leftText");
        Intrinsics.checkNotNullParameter(isChecked, "isChecked");
        this.isChecked = isChecked;
        this.visible = true;
        if (i16 != 0) {
            dVar = new x.b.C8996b(leftText, i16);
        } else {
            dVar = new x.b.d(leftText);
        }
        this.itemConfig = new com.tencent.mobileqq.widget.listitem.x<>(dVar, new x.c.f(this.isChecked.invoke().booleanValue(), new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.vas.z
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                aa.y(aa.this, compoundButton, z16);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        VideoReport.traversePage(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(aa this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = this$0.onCheckedChange;
        if (onCheckedChangeListener != null) {
            onCheckedChangeListener.onCheckedChanged(compoundButton, z16);
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(aa this$0, View it) {
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

    public final void C(@Nullable CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.onCheckedChange = onCheckedChangeListener;
    }

    public final void D(boolean z16) {
        this.visible = z16;
    }

    @Override // com.tencent.mobileqq.setting.processor.c, com.tencent.mobileqq.setting.processor.d
    public void onResume() {
        super.onResume();
        if (this.itemConfig.O().getIsChecked() != this.isChecked.invoke().booleanValue()) {
            this.itemConfig.O().f(this.isChecked.invoke().booleanValue());
        }
        l();
    }

    @Override // com.tencent.mobileqq.setting.processor.c
    @NotNull
    public com.tencent.mobileqq.widget.listitem.a<?> q() {
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.f> xVar = this.itemConfig;
        xVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.vas.x
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                aa.z(aa.this, view);
            }
        });
        xVar.v(new com.tencent.mobileqq.widget.listitem.f() { // from class: com.tencent.mobileqq.vas.y
            @Override // com.tencent.mobileqq.widget.listitem.f
            public final void a(View view) {
                aa.A(view);
            }
        });
        xVar.p(this.visible);
        return xVar;
    }
}

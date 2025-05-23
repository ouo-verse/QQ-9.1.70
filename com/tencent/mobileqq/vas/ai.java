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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u0010*\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b+\u0010,J\f\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R0\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010'\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u000e\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/vas/ai;", "Lcom/tencent/mobileqq/setting/processor/c;", "Lcom/tencent/mobileqq/widget/listitem/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "g", "Ljava/lang/CharSequence;", "leftText", "", tl.h.F, "I", "leftIcon", "", "i", "Z", "isChecked", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "j", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "getOnCheckedChange", "()Landroid/widget/CompoundButton$OnCheckedChangeListener;", BdhLogUtil.LogTag.Tag_Conn, "(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V", "onCheckedChange", "Lkotlin/Function1;", "Landroid/view/View;", "", "k", "Lkotlin/jvm/functions/Function1;", "getOnBindView", "()Lkotlin/jvm/functions/Function1;", "B", "(Lkotlin/jvm/functions/Function1;)V", "onBindView", "l", "getVisible", "()Z", "D", "(Z)V", NodeProps.VISIBLE, "Landroid/content/Context;", "context", "type", "<init>", "(Landroid/content/Context;ILjava/lang/CharSequence;IZ)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class ai extends com.tencent.mobileqq.setting.processor.c {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CharSequence leftText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int leftIcon;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isChecked;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CompoundButton.OnCheckedChangeListener onCheckedChange;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super View, Unit> onBindView;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean visible;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ai(@NotNull Context context, int i3, @NotNull CharSequence leftText, int i16, boolean z16) {
        super(context, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(leftText, "leftText");
        this.leftText = leftText;
        this.leftIcon = i16;
        this.isChecked = z16;
        this.visible = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        VideoReport.traversePage(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(ai this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = this$0.onCheckedChange;
        if (onCheckedChangeListener != null) {
            onCheckedChangeListener.onCheckedChanged(compoundButton, z16);
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(ai this$0, View it) {
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
        com.tencent.mobileqq.widget.listitem.x xVar = new com.tencent.mobileqq.widget.listitem.x(dVar, new x.c.f(this.isChecked, new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.vas.af
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                ai.y(ai.this, compoundButton, z16);
            }
        }));
        xVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.vas.ag
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                ai.z(ai.this, view);
            }
        });
        xVar.v(new com.tencent.mobileqq.widget.listitem.f() { // from class: com.tencent.mobileqq.vas.ah
            @Override // com.tencent.mobileqq.widget.listitem.f
            public final void a(View view) {
                ai.A(view);
            }
        });
        xVar.p(this.visible);
        return xVar;
    }
}

package com.tencent.mobileqq.vas;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.vas.GXHSettingProvider;
import com.tencent.mobileqq.vas.inject.VasInjectApi;
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
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010$\u001a\u00020#\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\f\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016R*\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R0\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R \u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/vas/u;", "Lcom/tencent/mobileqq/setting/processor/c;", "", "E", "", "y", "Lcom/tencent/mobileqq/widget/listitem/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "onResume", "o", "Lkotlin/Function0;", "g", "Lkotlin/jvm/functions/Function0;", "getOnClick", "()Lkotlin/jvm/functions/Function0;", "D", "(Lkotlin/jvm/functions/Function0;)V", NodeProps.ON_CLICK, "Lkotlin/Function1;", "Landroid/view/View;", tl.h.F, "Lkotlin/jvm/functions/Function1;", "getOnBindView", "()Lkotlin/jvm/functions/Function1;", BdhLogUtil.LogTag.Tag_Conn, "(Lkotlin/jvm/functions/Function1;)V", "onBindView", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "i", "Lcom/tencent/mobileqq/widget/listitem/x;", "itemConfig", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/vas/GXHSettingProvider$Companion$a;", "itemData", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/vas/GXHSettingProvider$Companion$a;)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class u extends com.tencent.mobileqq.setting.processor.c {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function0<Unit> onClick;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super View, Unit> onBindView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> itemConfig;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(@NotNull Context context, @NotNull GXHSettingProvider.Companion.Item itemData) {
        super(context, 20);
        x.b dVar;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        if (itemData.getIcon() != 0) {
            dVar = new x.b.C8996b(itemData.getTittle(), itemData.getIcon());
        } else {
            dVar = new x.b.d(itemData.getTittle());
        }
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar = new com.tencent.mobileqq.widget.listitem.x<>(dVar, new x.c.g("", true, false));
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.vas.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                u.z(u.this, view);
            }
        });
        xVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.vas.s
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                u.A(u.this, view);
            }
        });
        xVar.v(new com.tencent.mobileqq.widget.listitem.f() { // from class: com.tencent.mobileqq.vas.t
            @Override // com.tencent.mobileqq.widget.listitem.f
            public final void a(View view) {
                u.B(view);
            }
        });
        this.itemConfig = xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(u this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        Function1<? super View, Unit> function1 = this$0.onBindView;
        if (function1 != null) {
            function1.invoke(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        VideoReport.traversePage(it);
    }

    private final void E() {
        String y16 = y();
        if (!Intrinsics.areEqual(this.itemConfig.O().getText(), y16)) {
            this.itemConfig.O().h(y16);
            l();
        }
    }

    private final String y() {
        if (VasInjectApi.getInstance().isShowGameIcon()) {
            return "\u5c55\u793a";
        }
        return "\u4e0d\u5c55\u793a";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(u this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function0<Unit> function0 = this$0.onClick;
        if (function0 != null) {
            function0.invoke();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void C(@Nullable Function1<? super View, Unit> function1) {
        this.onBindView = function1;
    }

    public final void D(@Nullable Function0<Unit> function0) {
        this.onClick = function0;
    }

    @Override // com.tencent.mobileqq.setting.processor.c
    public void o() {
        super.o();
        E();
    }

    @Override // com.tencent.mobileqq.setting.processor.c, com.tencent.mobileqq.setting.processor.d
    public void onResume() {
        super.onResume();
        E();
    }

    @Override // com.tencent.mobileqq.setting.processor.c
    @NotNull
    public com.tencent.mobileqq.widget.listitem.a<?> q() {
        this.itemConfig.O().h(y());
        return this.itemConfig;
    }
}

package com.tencent.mobileqq.zplan.minihome.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.zplan.minihome.view.MiniHomeActionBtnComponent;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import yk0.FurnitureDesc;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class MiniHomeActionBtnComponent$show$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ FurnitureDesc $furniture;
    final /* synthetic */ MiniHomeActionBtnComponent this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniHomeActionBtnComponent$show$1(FurnitureDesc furnitureDesc, MiniHomeActionBtnComponent miniHomeActionBtnComponent) {
        super(0);
        this.$furniture = furnitureDesc;
        this.this$0 = miniHomeActionBtnComponent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(MiniHomeActionBtnComponent this$0, FurnitureDesc furnitureDesc, View it) {
        Function3 function3;
        ImageView imageView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        function3 = this$0.com.tencent.mtt.hippy.dom.node.NodeProps.ON_CLICK java.lang.String;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        function3.invoke(it, MiniHomeActionBtnComponent.Companion.ACTION.DELETE, furnitureDesc);
        imageView = this$0.deleteImage;
        Intrinsics.checkNotNull(imageView);
        this$0.f(imageView, "clck", "em_zplan_delete");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(MiniHomeActionBtnComponent this$0, FurnitureDesc furnitureDesc, View it) {
        Function3 function3;
        ImageView imageView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        function3 = this$0.com.tencent.mtt.hippy.dom.node.NodeProps.ON_CLICK java.lang.String;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        function3.invoke(it, MiniHomeActionBtnComponent.Companion.ACTION.ROTATE, furnitureDesc);
        imageView = this$0.rotateImage;
        Intrinsics.checkNotNull(imageView);
        this$0.f(imageView, "clck", "em_zplan_turn");
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        RelativeLayout relativeLayout;
        ImageView imageView;
        ImageView imageView2;
        Set of5;
        boolean contains;
        RelativeLayout relativeLayout2;
        ImageView imageView3;
        ImageView imageView4;
        ImageView imageView5;
        ImageView imageView6;
        QLog.i("MiniHomeActionBtnComponent", 1, "show " + this.$furniture);
        relativeLayout = this.this$0.actionRoot;
        if (relativeLayout != null) {
            imageView = this.this$0.deleteImage;
            if (imageView != null) {
                imageView2 = this.this$0.rotateImage;
                if (imageView2 != null) {
                    FurnitureDesc furnitureDesc = this.$furniture;
                    if (!(furnitureDesc != null && furnitureDesc.getDeleted())) {
                        of5 = SetsKt__SetsKt.setOf((Object[]) new String[]{"wall", "floor"});
                        FurnitureDesc furnitureDesc2 = this.$furniture;
                        contains = CollectionsKt___CollectionsKt.contains(of5, furnitureDesc2 != null ? furnitureDesc2.getSlot() : null);
                        if (contains) {
                            return;
                        }
                        relativeLayout2 = this.this$0.actionRoot;
                        if (relativeLayout2 != null) {
                            relativeLayout2.setVisibility(0);
                        }
                        imageView3 = this.this$0.deleteImage;
                        if (imageView3 != null) {
                            final MiniHomeActionBtnComponent miniHomeActionBtnComponent = this.this$0;
                            final FurnitureDesc furnitureDesc3 = this.$furniture;
                            imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.minihome.view.b
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    MiniHomeActionBtnComponent$show$1.c(MiniHomeActionBtnComponent.this, furnitureDesc3, view);
                                }
                            });
                        }
                        MiniHomeActionBtnComponent miniHomeActionBtnComponent2 = this.this$0;
                        imageView4 = miniHomeActionBtnComponent2.deleteImage;
                        Intrinsics.checkNotNull(imageView4);
                        miniHomeActionBtnComponent2.f(imageView4, "imp", "em_zplan_delete");
                        imageView5 = this.this$0.rotateImage;
                        if (imageView5 != null) {
                            final MiniHomeActionBtnComponent miniHomeActionBtnComponent3 = this.this$0;
                            final FurnitureDesc furnitureDesc4 = this.$furniture;
                            imageView5.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.minihome.view.c
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    MiniHomeActionBtnComponent$show$1.d(MiniHomeActionBtnComponent.this, furnitureDesc4, view);
                                }
                            });
                        }
                        MiniHomeActionBtnComponent miniHomeActionBtnComponent4 = this.this$0;
                        imageView6 = miniHomeActionBtnComponent4.rotateImage;
                        Intrinsics.checkNotNull(imageView6);
                        miniHomeActionBtnComponent4.f(imageView6, "imp", "em_zplan_turn");
                        return;
                    }
                    QLog.e("MiniHomeActionBtnComponent", 1, "show furniture deleted, return.");
                    return;
                }
            }
        }
        QLog.e("MiniHomeActionBtnComponent", 1, "show error, need init");
    }
}

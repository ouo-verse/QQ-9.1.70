package com.tencent.mobileqq.zplan.minihome.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import yk0.FurnitureDesc;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class MiniHomeEditGuideComponent$show$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ MiniHomeEditGuideComponent this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniHomeEditGuideComponent$show$1(MiniHomeEditGuideComponent miniHomeEditGuideComponent) {
        super(0);
        this.this$0 = miniHomeEditGuideComponent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(MiniHomeEditGuideComponent this$0, View view) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        function1 = this$0.com.tencent.mtt.hippy.dom.node.NodeProps.ON_CLICK java.lang.String;
        function1.invoke(this$0.h());
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        RelativeLayout relativeLayout;
        FurnitureDesc furnitureDesc;
        FurnitureDesc furnitureDesc2;
        RelativeLayout relativeLayout2;
        URLDrawable f16;
        RelativeLayout relativeLayout3;
        QLog.i("MiniHomeEditGuideComponent", 1, "show");
        relativeLayout = this.this$0.com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon.CONTAINER java.lang.String;
        int height = relativeLayout.getHeight();
        ImageView h16 = this.this$0.h();
        furnitureDesc = this.this$0.guideInfo;
        h16.setX(furnitureDesc.getX() - 62);
        ImageView h17 = this.this$0.h();
        furnitureDesc2 = this.this$0.guideInfo;
        h17.setY((height - furnitureDesc2.getY()) - 62);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(124, 124);
        relativeLayout2 = this.this$0.com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon.CONTAINER java.lang.String;
        relativeLayout2.addView(this.this$0.h(), layoutParams);
        this.this$0.h().setPadding(30, 30, 30, 30);
        ImageView h18 = this.this$0.h();
        f16 = this.this$0.f();
        h18.setImageDrawable(f16);
        ImageView h19 = this.this$0.h();
        final MiniHomeEditGuideComponent miniHomeEditGuideComponent = this.this$0;
        h19.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.minihome.view.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiniHomeEditGuideComponent$show$1.b(MiniHomeEditGuideComponent.this, view);
            }
        });
        this.this$0.g().setVisibility(8);
        this.this$0.g().setX(this.this$0.h().getX() + com.tencent.sqshow.zootopia.utils.i.e(10));
        this.this$0.g().setY(this.this$0.h().getY() - com.tencent.sqshow.zootopia.utils.i.e(2));
        this.this$0.g().setTextColor(-1);
        relativeLayout3 = this.this$0.com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon.CONTAINER java.lang.String;
        relativeLayout3.addView(this.this$0.g(), layoutParams);
    }
}

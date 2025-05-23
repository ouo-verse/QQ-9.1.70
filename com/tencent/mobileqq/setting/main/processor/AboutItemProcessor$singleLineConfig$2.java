package com.tencent.mobileqq.setting.main.processor;

import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.listitem.x;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$b;", "Lcom/tencent/mobileqq/widget/listitem/x$c$d;", "invoke", "()Lcom/tencent/mobileqq/widget/listitem/x;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class AboutItemProcessor$singleLineConfig$2 extends Lambda implements Function0<x<x.b.C8996b, x.c.d>> {
    final /* synthetic */ AboutItemProcessor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AboutItemProcessor$singleLineConfig$2(AboutItemProcessor aboutItemProcessor) {
        super(0);
        this.this$0 = aboutItemProcessor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(AboutItemProcessor this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.E();
        com.tencent.mobileqq.setting.utils.o oVar = com.tencent.mobileqq.setting.utils.o.f286768a;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        com.tencent.mobileqq.setting.utils.o.g(oVar, it, "em_bas_about_qq_and_help", null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        com.tencent.mobileqq.setting.utils.o.f286768a.l(it, "em_bas_about_qq_and_help", null, false);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final x<x.b.C8996b, x.c.d> invoke() {
        String leftText;
        leftText = this.this$0.B();
        Intrinsics.checkNotNullExpressionValue(leftText, "leftText");
        x<x.b.C8996b, x.c.d> xVar = new x<>(new x.b.C8996b(leftText, R.drawable.qui_info_circle), new x.c.d("", "", true, false));
        final AboutItemProcessor aboutItemProcessor = this.this$0;
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.setting.main.processor.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AboutItemProcessor$singleLineConfig$2.c(AboutItemProcessor.this, view);
            }
        });
        xVar.T(new Function2<ImageView, String, Unit>() { // from class: com.tencent.mobileqq.setting.main.processor.AboutItemProcessor$singleLineConfig$2$1$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(ImageView imageView, String str) {
                invoke2(imageView, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ImageView imageView, String url) {
                Intrinsics.checkNotNullParameter(imageView, "imageView");
                Intrinsics.checkNotNullParameter(url, "url");
                if (url.length() == 0) {
                    imageView.setImageDrawable(null);
                } else {
                    imageView.setImageResource(R.drawable.obo);
                    imageView.setContentDescription(HardCodeUtil.qqStr(R.string.j0h));
                }
            }
        });
        xVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.setting.main.processor.b
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                AboutItemProcessor$singleLineConfig$2.d(view);
            }
        });
        return xVar;
    }
}

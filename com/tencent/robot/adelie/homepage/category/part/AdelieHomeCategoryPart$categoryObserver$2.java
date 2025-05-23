package com.tencent.robot.adelie.homepage.category.part;

import androidx.lifecycle.Observer;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.RobotTabInfo;
import com.tencent.robot.adelie.homepage.category.viewmodel.Category;
import com.tencent.robot.adelie.homepage.category.viewmodel.CategoryType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/lifecycle/Observer;", "Lcom/tencent/robot/adelie/homepage/category/viewmodel/c;", "invoke", "()Landroidx/lifecycle/Observer;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieHomeCategoryPart$categoryObserver$2 extends Lambda implements Function0<Observer<Category>> {
    final /* synthetic */ AdelieHomeCategoryPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdelieHomeCategoryPart$categoryObserver$2(AdelieHomeCategoryPart adelieHomeCategoryPart) {
        super(0);
        this.this$0 = adelieHomeCategoryPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(AdelieHomeCategoryPart this$0, Category category) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z16 = true;
        QLog.i("AdelieHomeCategoryPart", 1, "observe new category:" + category);
        Intrinsics.checkNotNullExpressionValue(category, "category");
        this$0.P9(category);
        if (category.a().isEmpty()) {
            return;
        }
        List<RobotTabInfo> a16 = category.a();
        if (category.getType() != CategoryType.BACKEND) {
            z16 = false;
        }
        this$0.H9(a16, z16);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Observer<Category> invoke() {
        final AdelieHomeCategoryPart adelieHomeCategoryPart = this.this$0;
        return new Observer() { // from class: com.tencent.robot.adelie.homepage.category.part.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AdelieHomeCategoryPart$categoryObserver$2.b(AdelieHomeCategoryPart.this, (Category) obj);
            }
        };
    }
}

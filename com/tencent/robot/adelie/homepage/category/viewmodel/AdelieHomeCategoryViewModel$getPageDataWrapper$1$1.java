package com.tencent.robot.adelie.homepage.category.viewmodel;

import com.tencent.qqnt.kernel.nativeinterface.RobotTabInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public /* synthetic */ class AdelieHomeCategoryViewModel$getPageDataWrapper$1$1 extends FunctionReferenceImpl implements Function2<List<? extends RobotTabInfo>, PageDataType, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AdelieHomeCategoryViewModel$getPageDataWrapper$1$1(Object obj) {
        super(2, obj, AdelieHomeCategoryViewModel.class, "fillCategoryInfoIfNeed", "fillCategoryInfoIfNeed(Ljava/util/List;Lcom/tencent/robot/adelie/homepage/category/viewmodel/PageDataType;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends RobotTabInfo> list, PageDataType pageDataType) {
        invoke2((List<RobotTabInfo>) list, pageDataType);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull List<RobotTabInfo> p06, @NotNull PageDataType p16) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        Intrinsics.checkNotNullParameter(p16, "p1");
        ((AdelieHomeCategoryViewModel) this.receiver).N1(p06, p16);
    }
}

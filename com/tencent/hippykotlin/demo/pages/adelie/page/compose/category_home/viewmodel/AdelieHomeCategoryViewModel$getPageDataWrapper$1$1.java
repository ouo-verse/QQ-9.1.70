package com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.viewmodel;

import com.tencent.kuikly.core.log.KLog;
import g25.h;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* loaded from: classes31.dex */
public /* synthetic */ class AdelieHomeCategoryViewModel$getPageDataWrapper$1$1 extends FunctionReferenceImpl implements Function2<List<? extends h>, PageDataType, Unit> {
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0060, code lost:
    
        if ((r8 != null ? r8.type : 0) == 3) goto L20;
     */
    @Override // kotlin.jvm.functions.Function2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Unit invoke(List<? extends h> list, PageDataType pageDataType) {
        List<? extends h> list2 = list;
        PageDataType pageDataType2 = pageDataType;
        AdelieHomeCategoryViewModel adelieHomeCategoryViewModel = (AdelieHomeCategoryViewModel) this.receiver;
        adelieHomeCategoryViewModel.getClass();
        if (list2.isEmpty()) {
            if (pageDataType2 == PageDataType.ERROR) {
                Category value = adelieHomeCategoryViewModel._category._state.getValue();
                if ((value != null ? value.type : 0) == 1) {
                    KLog.INSTANCE.i("AdelieHomeCategoryViewModel", "fillCategoryInfoIfNeed error");
                    adelieHomeCategoryViewModel._category._state.setValue(new Category(3, list2));
                }
            }
        } else {
            Category value2 = adelieHomeCategoryViewModel._category._state.getValue();
            if ((value2 != null ? value2.type : 0) != 1) {
                Category value3 = adelieHomeCategoryViewModel._category._state.getValue();
            }
            KLog.INSTANCE.i("AdelieHomeCategoryViewModel", "fillCategoryInfoIfNeed");
            adelieHomeCategoryViewModel._category._state.setValue(new Category(2, list2));
        }
        return Unit.INSTANCE;
    }

    public AdelieHomeCategoryViewModel$getPageDataWrapper$1$1(Object obj) {
        super(2, obj, AdelieHomeCategoryViewModel.class, "fillCategoryInfoIfNeed", "fillCategoryInfoIfNeed(Ljava/util/List;Lcom/tencent/hippykotlin/demo/pages/adelie/page/compose/category_home/viewmodel/PageDataType;)V", 0);
    }
}

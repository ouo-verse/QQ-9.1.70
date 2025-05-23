package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.PageStatus;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.QSearchDetailPage;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.SubPageName;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.QSearchDetailBaseSubPageAttr;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.QSearchReportView;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.pager.b;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* loaded from: classes32.dex */
public abstract class QSearchDetailBaseSubPage<A extends QSearchDetailBaseSubPageAttr, E extends l> extends QSearchReportView<A, E> {
    public PageStatus subPageStatus;

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QSearchDetailBaseSubPageAttr access$getAttr(QSearchDetailBaseSubPage qSearchDetailBaseSubPage) {
        return (QSearchDetailBaseSubPageAttr) qSearchDetailBaseSubPage.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$updatePageStatus(QSearchDetailBaseSubPage qSearchDetailBaseSubPage) {
        PageStatus pageStatus;
        if (((QSearchDetailBaseSubPageAttr) qSearchDetailBaseSubPage.getAttr()).getViewModel().getCurrentPage() == qSearchDetailBaseSubPage.getSubPageName()) {
            pageStatus = ((QSearchDetailBaseSubPageAttr) qSearchDetailBaseSubPage.getAttr()).getViewModel().getPageStatus();
        } else {
            int ordinal = ((QSearchDetailBaseSubPageAttr) qSearchDetailBaseSubPage.getAttr()).getViewModel().getPageStatus().ordinal();
            if (ordinal == 0 || ordinal == 1) {
                pageStatus = PageStatus.DID_DISAPPEAR;
            } else if (ordinal == 2) {
                pageStatus = PageStatus.WILL_DESTROY;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        if (pageStatus == qSearchDetailBaseSubPage.subPageStatus) {
            return;
        }
        qSearchDetailBaseSubPage.subPageStatus = pageStatus;
        if (pageStatus != null) {
            int ordinal2 = pageStatus.ordinal();
            if (ordinal2 == 0) {
                qSearchDetailBaseSubPage.pageDidAppear();
            } else if (ordinal2 == 1) {
                qSearchDetailBaseSubPage.pageDidDisappear();
            } else {
                if (ordinal2 != 2) {
                    return;
                }
                qSearchDetailBaseSubPage.pageWillDestroy();
            }
        }
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public void created() {
        super.created();
        bindValueChange(new Function0<Object>(this) { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.QSearchDetailBaseSubPage$created$1
            public final /* synthetic */ QSearchDetailBaseSubPage<A, E> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return QSearchDetailBaseSubPage.access$getAttr(this.this$0).getViewModel().getCurrentPage();
            }
        }, new Function1<Object, Unit>(this) { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.QSearchDetailBaseSubPage$created$2
            public final /* synthetic */ QSearchDetailBaseSubPage<A, E> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                QSearchDetailBaseSubPage.access$updatePageStatus(this.this$0);
                return Unit.INSTANCE;
            }
        });
        bindValueChange(new Function0<Object>(this) { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.QSearchDetailBaseSubPage$created$3
            public final /* synthetic */ QSearchDetailBaseSubPage<A, E> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return QSearchDetailBaseSubPage.access$getAttr(this.this$0).getViewModel().getPageStatus();
            }
        }, new Function1<Object, Unit>(this) { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.QSearchDetailBaseSubPage$created$4
            public final /* synthetic */ QSearchDetailBaseSubPage<A, E> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                QSearchDetailBaseSubPage.access$updatePageStatus(this.this$0);
                return Unit.INSTANCE;
            }
        });
    }

    public abstract SubPageName getSubPageName();

    public final void hideKeyboard() {
        b pager = getPager();
        QSearchDetailPage qSearchDetailPage = pager instanceof QSearchDetailPage ? (QSearchDetailPage) pager : null;
        if (qSearchDetailPage != null) {
            qSearchDetailPage.hideKeyboard();
        }
    }

    public void pageDidAppear() {
    }

    public void pageDidDisappear() {
    }

    public void pageWillDestroy() {
    }
}

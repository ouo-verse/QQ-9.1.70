package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.repo;

import com.qzone.homepage.ui.Facade.model.FacadeCacheData;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ExpressionInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ISearchItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.UnifySearchRspBody;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.UnifySearchTabContent;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.UnifySearchTabContentResult;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.UnifySearchTabInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.expression.ExpressionItemModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.expression.ExpressionItemsModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.SearchNetApi$covertPbByteArrayToString$1;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.pager.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kuikly.com.tencent.trpcprotocol.search.unifysearch.e;
import kuikly.com.tencent.trpcprotocol.search.unifysearch.r;
import kuikly.com.tencent.trpcprotocol.search.unifysearch.s;
import kuikly.com.tencent.trpcprotocol.search.unifysearch.t;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchExpressionContentNetRepo extends QSearchContentNetRepo {
    public List<ExpressionInfo> lastItemList;

    public QSearchExpressionContentNetRepo(String str, g gVar, UnifySearchTabInfo unifySearchTabInfo, boolean z16) {
        super(str, gVar, unifySearchTabInfo, z16);
        this.lastItemList = new ArrayList();
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.repo.QSearchContentNetRepo
    public final void handleMSFReqSuccessResult(UnifySearchRspBody unifySearchRspBody, Function5<? super Boolean, ? super Boolean, ? super List<? extends ISearchItemModel>, ? super String, ? super e, Unit> function5, boolean z16) {
        UnifySearchTabContentResult unifySearchTabContentResult = unifySearchRspBody.tabContentResult;
        function5.invoke(Boolean.TRUE, Boolean.valueOf(z16), processExpressionTabContent(unifySearchTabContentResult != null ? unifySearchTabContentResult.resultItems : null, z16), unifySearchRspBody.correctionQuery, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.repo.QSearchContentNetRepo
    public final void handleOIDBSuccessResult(r rVar, Function5<? super Boolean, ? super Boolean, ? super List<? extends ISearchItemModel>, ? super String, ? super e, Unit> function5, boolean z16) {
        String joinToString$default;
        t tVar = rVar.f413245f;
        List<s> list = tVar != null ? tVar.f413257e : null;
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (s sVar : list) {
                String str = sVar.f413249d;
                String str2 = sVar.f413250e;
                long j3 = sVar.f413251f;
                int i3 = sVar.f413252h;
                String str3 = sVar.f413253i;
                joinToString$default = ArraysKt___ArraysKt.joinToString$default(sVar.f413254m.f30291a, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) SearchNetApi$covertPbByteArrayToString$1.INSTANCE, 30, (Object) null);
                arrayList.add(new UnifySearchTabContent(str, str2, j3, i3, str3, joinToString$default));
            }
        }
        function5.invoke(Boolean.TRUE, Boolean.valueOf(z16), processExpressionTabContent(arrayList, z16), rVar.D, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x00f6, code lost:
    
        if (r0 == null) goto L45;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c9 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r13v0, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ExpressionInfo>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v12, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ExpressionInfo>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v13, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ExpressionInfo>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v18, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ExpressionInfo>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ExpressionInfo>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ExpressionInfo>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ExpressionInfo>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ExpressionInfo>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ExpressionInfo>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ExpressionInfo>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ExpressionInfo>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r9v2, types: [java.util.List<com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.ExpressionInfo>, java.util.ArrayList] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<ISearchItemModel> processExpressionTabContent(List<UnifySearchTabContent> list, boolean z16) {
        List emptyList;
        IntRange until;
        IntProgression step;
        boolean z17;
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (UnifySearchTabContent unifySearchTabContent : list) {
                try {
                } catch (Exception e16) {
                    Utils utils = Utils.INSTANCE;
                    String message = e16.getMessage();
                    if (message == null) {
                        message = "";
                    }
                    utils.logToNative(message);
                }
                if (unifySearchTabContent.layoutId == 5) {
                    String str = unifySearchTabContent.layoutContent;
                    ExpressionItemsModel expressionItemsModel = new ExpressionItemsModel();
                    b bVar = new b(str);
                    int c16 = bVar.c();
                    for (int i3 = 0; i3 < c16; i3++) {
                        com.tencent.kuikly.core.nvi.serialization.json.e l3 = bVar.l(i3);
                        if (l3 != null) {
                            expressionItemsModel.itemList.add(new ExpressionInfo(l3.q("md5", ""), l3.q("url", ""), l3.q("thumb_md5", ""), l3.q(FacadeCacheData.THUMB_URL, ""), l3.q("src_desc", ""), l3.q("src_pack_name", ""), l3.q("src_web_url", ""), l3.q("src_icon_url", ""), l3.q("img_other", "")));
                        }
                    }
                    unifySearchTabContent.searchItem = expressionItemsModel;
                    z17 = true;
                    if (z17) {
                        ISearchItemModel iSearchItemModel = unifySearchTabContent.searchItem;
                        if (!(iSearchItemModel != null && iSearchItemModel.isValid())) {
                        }
                    }
                    arrayList.add(unifySearchTabContent);
                } else {
                    Utils.INSTANCE.logToNative("unknown layoutId: " + unifySearchTabContent.layoutId);
                    z17 = false;
                    if (z17) {
                    }
                    arrayList.add(unifySearchTabContent);
                }
            }
        }
        if (list != null) {
            list.removeAll(arrayList);
        }
        if (list != null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ISearchItemModel iSearchItemModel2 = ((UnifySearchTabContent) it.next()).searchItem;
                if (iSearchItemModel2 != null) {
                    arrayList2.add(iSearchItemModel2);
                }
            }
            emptyList = CollectionsKt___CollectionsKt.toList(arrayList2);
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : emptyList) {
            if (obj instanceof ExpressionItemsModel) {
                arrayList3.add(obj);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        if (!this.lastItemList.isEmpty()) {
            arrayList4.addAll(this.lastItemList);
            this.lastItemList.clear();
        }
        Iterator it5 = arrayList3.iterator();
        while (it5.hasNext()) {
            arrayList4.addAll(((ExpressionItemsModel) it5.next()).itemList);
        }
        ArrayList arrayList5 = new ArrayList();
        int size = arrayList4.size() % 3;
        until = RangesKt___RangesKt.until(0, arrayList4.size() - size);
        step = RangesKt___RangesKt.step(until, 3);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
            while (true) {
                ExpressionItemModel expressionItemModel = new ExpressionItemModel();
                expressionItemModel.itemList.add(arrayList4.get(first));
                expressionItemModel.itemList.add(arrayList4.get(first + 1));
                expressionItemModel.itemList.add(arrayList4.get(first + 2));
                arrayList5.add(expressionItemModel);
                if (first == last) {
                    break;
                }
                first += step2;
            }
        }
        if (size == 1) {
            ExpressionInfo expressionInfo = (ExpressionInfo) arrayList4.get(arrayList4.size() - 1);
            if (z16) {
                ExpressionItemModel expressionItemModel2 = new ExpressionItemModel();
                expressionItemModel2.itemList.add(expressionInfo);
                arrayList5.add(expressionItemModel2);
            } else {
                this.lastItemList.add(expressionInfo);
            }
        }
        if (size == 2) {
            ExpressionInfo expressionInfo2 = (ExpressionInfo) arrayList4.get(arrayList4.size() - 2);
            ExpressionInfo expressionInfo3 = (ExpressionInfo) arrayList4.get(arrayList4.size() - 1);
            if (z16) {
                ExpressionItemModel expressionItemModel3 = new ExpressionItemModel();
                expressionItemModel3.itemList.add(expressionInfo2);
                expressionItemModel3.itemList.add(expressionInfo3);
                arrayList5.add(expressionItemModel3);
            } else {
                this.lastItemList.add(expressionInfo2);
                this.lastItemList.add(expressionInfo3);
            }
        }
        return arrayList5;
    }
}

package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.QzoneRight;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.QzoneRightGroupItem;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.QzoneRightQuestion;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u0001H\u0000\u00a8\u0006\u0004"}, d2 = {"toCommon", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonRight;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/QzoneRight;", "toPb", "qecommerce-biz_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonRightKt {
    public static final CommonRight toCommon(QzoneRight qzoneRight) {
        int collectionSizeOrDefault;
        List<CommonRightQuestion> mutableList;
        int collectionSizeOrDefault2;
        List<CommonRightGroupItem> mutableList2;
        if (qzoneRight == null) {
            return null;
        }
        CommonRight commonRight = new CommonRight();
        commonRight.setFlag(qzoneRight.flag);
        commonRight.setWhiteUins(qzoneRight.whiteUins);
        commonRight.setBlackUins(qzoneRight.blackUins);
        List<QzoneRightQuestion> list = qzoneRight.questions;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(CommonRightQuestionKt.toCommon((QzoneRightQuestion) it.next()));
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        commonRight.setQuestions(mutableList);
        List<QzoneRightGroupItem> list2 = qzoneRight.whiteGroups;
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
        Iterator<T> it5 = list2.iterator();
        while (it5.hasNext()) {
            arrayList2.add(CommonRightGroupItemKt.toCommon((QzoneRightGroupItem) it5.next()));
        }
        mutableList2 = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList2);
        commonRight.setWhiteGroups(mutableList2);
        return commonRight;
    }

    public static final QzoneRight toPb(CommonRight commonRight) {
        int collectionSizeOrDefault;
        List mutableList;
        int collectionSizeOrDefault2;
        List mutableList2;
        if (commonRight == null) {
            return null;
        }
        List<Integer> flag = commonRight.getFlag();
        List<String> whiteUins = commonRight.getWhiteUins();
        List<String> blackUins = commonRight.getBlackUins();
        List<CommonRightQuestion> questions = commonRight.getQuestions();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(questions, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = questions.iterator();
        while (it.hasNext()) {
            arrayList.add(CommonRightQuestionKt.toPb((CommonRightQuestion) it.next()));
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        List<CommonRightGroupItem> whiteGroups = commonRight.getWhiteGroups();
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(whiteGroups, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
        Iterator<T> it5 = whiteGroups.iterator();
        while (it5.hasNext()) {
            arrayList2.add(CommonRightGroupItemKt.toPb((CommonRightGroupItem) it5.next()));
        }
        mutableList2 = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList2);
        return new QzoneRight(flag, whiteUins, blackUins, mutableList, mutableList2);
    }
}

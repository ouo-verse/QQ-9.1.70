package com.tencent.biz.qqcircle.comment.recpic;

import com.tencent.biz.qqcircle.comment.recpic.QFSCommentRecPicClusterHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.Embedding;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import u20.QFSPipelineConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012&\u0010\u0002\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004 \u0006*\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "it", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lfeedcloud/Embedding;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class QFSCommentRecPicClusterHelper$startAnalyseFeed$1$1 extends Lambda implements Function1<UIStateData<List<? extends Embedding>>, Unit> {
    final /* synthetic */ String $feedId;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSCommentRecPicClusterHelper$startAnalyseFeed$1$1(String str) {
        super(1);
        this.$feedId = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(UIStateData uIStateData, final String feedId) {
        int i3;
        Object obj;
        float f16;
        int collectionSizeOrDefault;
        float[] floatArray;
        boolean z16;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = ((List) uIStateData.getData()).iterator();
        while (true) {
            i3 = 0;
            if (!it.hasNext()) {
                break;
            }
            Embedding embedding = (Embedding) it.next();
            Iterator<T> it5 = z.f83900a.q().iterator();
            while (true) {
                if (it5.hasNext()) {
                    obj = it5.next();
                    if (((QFSPipelineConfig) obj).getPipelineId() == 102) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            QFSPipelineConfig qFSPipelineConfig = (QFSPipelineConfig) obj;
            if (qFSPipelineConfig != null) {
                f16 = qFSPipelineConfig.getThreshold();
            } else {
                f16 = 68.0f;
            }
            if (f16 == 0.0f) {
                i3 = 1;
            }
            if (i3 != 0) {
                f16 = 68.0f;
            }
            List<Double> list = embedding.value;
            Intrinsics.checkNotNullExpressionValue(list, "embedding.value");
            List<Double> list2 = list;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it6 = list2.iterator();
            while (it6.hasNext()) {
                arrayList3.add(Float.valueOf((float) ((Double) it6.next()).doubleValue()));
            }
            floatArray = CollectionsKt___CollectionsKt.toFloatArray(arrayList3);
            Intrinsics.checkNotNullExpressionValue(feedId, "feedId");
            arrayList.add(new QFSCommentRecPicClusterHelper.StrategyConfig(feedId, 7, floatArray, f16, null, 16, null));
        }
        QFSCommentRecPicClusterHelper qFSCommentRecPicClusterHelper = QFSCommentRecPicClusterHelper.f83716a;
        List<QFSRecPicInfo> I = qFSCommentRecPicClusterHelper.I();
        if (!I.isEmpty() && !arrayList.isEmpty()) {
            final ArrayList arrayList4 = new ArrayList();
            arrayList4.addAll(qFSCommentRecPicClusterHelper.N(I, arrayList));
            Iterator it7 = arrayList.iterator();
            while (it7.hasNext()) {
                it7.next();
                String str = ((Embedding) ((List) uIStateData.getData()).get(i3)).model_input_hash;
                Intrinsics.checkNotNullExpressionValue(str, "it.data[i].model_input_hash");
                arrayList2.add(new InputClusterBean(str, ((Embedding) ((List) uIStateData.getData()).get(i3)).pipeline_id.getValue(), arrayList4.size()));
                i3++;
            }
            QLog.d("QFSCommentRecPicClusterHelper", 1, "[startAnalyseFeed] match " + arrayList4.size() + " local pic.");
            if (arrayList4.isEmpty()) {
                return;
            }
            RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.recpic.w
                @Override // java.lang.Runnable
                public final void run() {
                    QFSCommentRecPicClusterHelper$startAnalyseFeed$1$1.d(feedId, arrayList4);
                }
            });
            ak.f83788a.k(arrayList2);
            return;
        }
        QLog.d("QFSCommentRecPicClusterHelper", 1, "[startAnalyseFeed] strategyList size: " + arrayList.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(String feedId, List matchLocalPicList) {
        Intrinsics.checkNotNullParameter(matchLocalPicList, "$matchLocalPicList");
        QFSCommentRecPicClusterHelper qFSCommentRecPicClusterHelper = QFSCommentRecPicClusterHelper.f83716a;
        Intrinsics.checkNotNullExpressionValue(feedId, "feedId");
        qFSCommentRecPicClusterHelper.x(feedId, matchLocalPicList);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(UIStateData<List<? extends Embedding>> uIStateData) {
        invoke2((UIStateData<List<Embedding>>) uIStateData);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final UIStateData<List<Embedding>> uIStateData) {
        int state = uIStateData.getState();
        if (state == 2 || state == 3) {
            RFWThreadManager rFWThreadManager = RFWThreadManager.getInstance();
            final String str = this.$feedId;
            rFWThreadManager.execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.recpic.v
                @Override // java.lang.Runnable
                public final void run() {
                    QFSCommentRecPicClusterHelper$startAnalyseFeed$1$1.c(UIStateData.this, str);
                }
            });
        }
    }
}

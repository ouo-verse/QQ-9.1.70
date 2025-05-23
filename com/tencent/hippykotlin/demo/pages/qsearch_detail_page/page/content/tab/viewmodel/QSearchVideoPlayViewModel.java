package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes32.dex */
public class QSearchVideoPlayViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchVideoPlayViewModel.class, "playIndex", "getPlayIndex()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchVideoPlayViewModel.class, "isPageActive", "isPageActive()Z", 0)};
    public boolean needPlayVideo;
    public final ReadWriteProperty playIndex$delegate = c.a(-2);
    public Map<Integer, Float> itemViewVisiblePercentMap = new LinkedHashMap();
    public final ReadWriteProperty isPageActive$delegate = c.a(Boolean.FALSE);

    public final int getPlayIndex() {
        return ((Number) this.playIndex$delegate.getValue(this, $$delegatedProperties[0])).intValue();
    }

    public final boolean isPageActive() {
        return ((Boolean) this.isPageActive$delegate.getValue(this, $$delegatedProperties[1])).booleanValue();
    }

    public boolean isVideoItem(int i3) {
        return true;
    }

    public final void playVideoInNextTickIfNeed() {
        if (!isPageActive() || this.needPlayVideo) {
            return;
        }
        this.needPlayVideo = true;
        com.tencent.kuikly.core.manager.c.f117352a.g().addNextTickTask(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.tab.viewmodel.QSearchVideoPlayViewModel$playVideoInNextTickIfNeed$1
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r1v3, types: [java.util.LinkedHashMap, java.util.Map<java.lang.Integer, java.lang.Float>] */
            /* JADX WARN: Type inference failed for: r2v0, types: [java.util.LinkedHashMap, java.util.Map<java.lang.Integer, java.lang.Float>] */
            /* JADX WARN: Type inference failed for: r6v1, types: [java.util.LinkedHashMap, java.util.Map<java.lang.Integer, java.lang.Float>] */
            /* JADX WARN: Type inference failed for: r7v4, types: [java.util.LinkedHashMap, java.util.Map<java.lang.Integer, java.lang.Float>] */
            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                float f16;
                List sorted;
                Float f17;
                QSearchVideoPlayViewModel qSearchVideoPlayViewModel = QSearchVideoPlayViewModel.this;
                if (qSearchVideoPlayViewModel.needPlayVideo) {
                    qSearchVideoPlayViewModel.needPlayVideo = false;
                    Set keySet = qSearchVideoPlayViewModel.itemViewVisiblePercentMap.keySet();
                    ArrayList arrayList = new ArrayList();
                    Iterator it = keySet.iterator();
                    while (true) {
                        f16 = 0.0f;
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        Float f18 = (Float) qSearchVideoPlayViewModel.itemViewVisiblePercentMap.get(Integer.valueOf(((Number) next).intValue()));
                        if (f18 == null || f18.floatValue() <= 0.0f || f18.floatValue() > 1.0f) {
                            arrayList.add(next);
                        }
                    }
                    Iterator it5 = arrayList.iterator();
                    while (it5.hasNext()) {
                        qSearchVideoPlayViewModel.itemViewVisiblePercentMap.remove(Integer.valueOf(((Number) it5.next()).intValue()));
                    }
                    sorted = CollectionsKt___CollectionsKt.sorted(qSearchVideoPlayViewModel.itemViewVisiblePercentMap.keySet());
                    Iterator it6 = sorted.iterator();
                    int i3 = -1;
                    while (it6.hasNext()) {
                        int intValue = ((Number) it6.next()).intValue();
                        if (qSearchVideoPlayViewModel.isVideoItem(intValue) && (f17 = (Float) qSearchVideoPlayViewModel.itemViewVisiblePercentMap.get(Integer.valueOf(intValue))) != null) {
                            float floatValue = f17.floatValue();
                            if (floatValue > f16 && floatValue > 0.5f) {
                                i3 = intValue;
                                f16 = floatValue;
                            }
                        }
                    }
                    if (i3 >= 0) {
                        qSearchVideoPlayViewModel.setPlayIndex(i3);
                    } else {
                        qSearchVideoPlayViewModel.setPlayIndex(-1);
                    }
                    if (QSearchVideoPlayViewModel.this.getPlayIndex() >= 0) {
                        QSearchVideoPlayViewModel.this.predownloadVideo();
                    }
                }
                return Unit.INSTANCE;
            }
        });
    }

    public final void setPlayIndex(int i3) {
        this.playIndex$delegate.setValue(this, $$delegatedProperties[0], Integer.valueOf(i3));
    }

    public void predownloadVideo() {
    }
}

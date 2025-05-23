package com.tencent.mobileqq.wink.editor.mosaic;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u000520\u0010\u0004\u001a,\u0012\u0004\u0012\u00020\u0001 \u0003*\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u00020\u0000j\b\u0012\u0004\u0012\u00020\u0001`\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/wink/editor/crop/model/a;", "Lkotlin/collections/ArrayList;", "kotlin.jvm.PlatformType", "dataList", "", "invoke", "(Ljava/util/ArrayList;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkEditorMosaicContentPart$observerLiveData$1 extends Lambda implements Function1<ArrayList<com.tencent.mobileqq.wink.editor.crop.model.a>, Unit> {
    final /* synthetic */ WinkEditorMosaicContentPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkEditorMosaicContentPart$observerLiveData$1(WinkEditorMosaicContentPart winkEditorMosaicContentPart) {
        super(1);
        this.this$0 = winkEditorMosaicContentPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(WinkEditorMosaicContentPart this$0, AdapterView adapterView, View view, int i3, long j3) {
        a73.a N9;
        a73.a N92;
        MosaicLayout mosaicLayout;
        a73.a N93;
        z63.a aVar;
        EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        N9 = this$0.N9();
        Integer value = N9.Q1().getValue();
        if (value == null || i3 != value.intValue()) {
            N92 = this$0.N9();
            mosaicLayout = this$0.mosaicLayout;
            if (mosaicLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mosaicLayout");
                mosaicLayout = null;
            }
            N92.a2(MosaicLayout.l(mosaicLayout, null, 1, null));
            N93 = this$0.N9();
            N93.b2(i3);
            aVar = this$0.videoListViewAdapter;
            if (aVar != null) {
                aVar.b(i3);
            }
        }
        EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ArrayList<com.tencent.mobileqq.wink.editor.crop.model.a> arrayList) {
        invoke2(arrayList);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ArrayList<com.tencent.mobileqq.wink.editor.crop.model.a> dataList) {
        z63.a aVar;
        z63.a aVar2;
        HorizontalListView horizontalListView;
        z63.a aVar3;
        HorizontalListView horizontalListView2;
        a73.a N9;
        z63.a aVar4;
        int i3;
        WinkEditorMosaicContentPart winkEditorMosaicContentPart = this.this$0;
        Context context = winkEditorMosaicContentPart.getContext();
        HorizontalListView horizontalListView3 = null;
        if (context != null) {
            Intrinsics.checkNotNullExpressionValue(dataList, "dataList");
            aVar = new z63.a(context, dataList);
        } else {
            aVar = null;
        }
        winkEditorMosaicContentPart.videoListViewAdapter = aVar;
        Intrinsics.checkNotNullExpressionValue(dataList, "dataList");
        if (!dataList.isEmpty()) {
            WinkEditorMosaicContentPart winkEditorMosaicContentPart2 = this.this$0;
            N9 = winkEditorMosaicContentPart2.N9();
            Integer value = N9.Q1().getValue();
            winkEditorMosaicContentPart2.lastSelectIndex = value == null ? 0 : value.intValue();
            aVar4 = this.this$0.videoListViewAdapter;
            if (aVar4 != null) {
                i3 = this.this$0.lastSelectIndex;
                aVar4.b(i3);
            }
        }
        aVar2 = this.this$0.videoListViewAdapter;
        if (aVar2 != null) {
            horizontalListView = this.this$0.horizontalListView;
            if (horizontalListView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("horizontalListView");
                horizontalListView = null;
            }
            aVar3 = this.this$0.videoListViewAdapter;
            horizontalListView.setAdapter((ListAdapter) aVar3);
            horizontalListView2 = this.this$0.horizontalListView;
            if (horizontalListView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("horizontalListView");
            } else {
                horizontalListView3 = horizontalListView2;
            }
            final WinkEditorMosaicContentPart winkEditorMosaicContentPart3 = this.this$0;
            horizontalListView3.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.tencent.mobileqq.wink.editor.mosaic.g
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i16, long j3) {
                    WinkEditorMosaicContentPart$observerLiveData$1.b(WinkEditorMosaicContentPart.this, adapterView, view, i16, j3);
                }
            });
        }
    }
}

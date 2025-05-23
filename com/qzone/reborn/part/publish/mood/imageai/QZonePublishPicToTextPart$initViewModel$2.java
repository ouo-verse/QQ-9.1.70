package com.qzone.reborn.part.publish.mood.imageai;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.qzone.widget.dynamicgridview.DynamicArrayList;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "dynamicArrayList", "Lcom/qzone/widget/dynamicgridview/DynamicArrayList;", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QZonePublishPicToTextPart$initViewModel$2 extends Lambda implements Function1<DynamicArrayList<String>, Unit> {
    final /* synthetic */ QZonePublishPicToTextPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZonePublishPicToTextPart$initViewModel$2(QZonePublishPicToTextPart qZonePublishPicToTextPart) {
        super(1);
        this.this$0 = qZonePublishPicToTextPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(DynamicArrayList<String> dynamicArrayList) {
        invoke2(dynamicArrayList);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(DynamicArrayList<String> dynamicArrayList) {
        LiveData<ArrayList<String>> liveData;
        if (dynamicArrayList == null || (liveData = dynamicArrayList.getLiveData()) == null) {
            return;
        }
        final QZonePublishPicToTextPart qZonePublishPicToTextPart = this.this$0;
        final Function1<ArrayList<String>, Unit> function1 = new Function1<ArrayList<String>, Unit>() { // from class: com.qzone.reborn.part.publish.mood.imageai.QZonePublishPicToTextPart$initViewModel$2.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ArrayList<String> arrayList) {
                invoke2(arrayList);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ArrayList<String> arrayList) {
                e eVar;
                l lVar;
                QZonePublishPicToTextPart.this.aa();
                eVar = QZonePublishPicToTextPart.this.mHalfScreenFloatDialog;
                if (eVar != null) {
                    lVar = QZonePublishPicToTextPart.this.mPublishViewModel;
                    if (lVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mPublishViewModel");
                        lVar = null;
                    }
                    lVar.c2(QZonePublishPicToTextPart.this.J9());
                }
            }
        };
        liveData.observeForever(new Observer() { // from class: com.qzone.reborn.part.publish.mood.imageai.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZonePublishPicToTextPart$initViewModel$2.b(Function1.this, obj);
            }
        });
    }
}

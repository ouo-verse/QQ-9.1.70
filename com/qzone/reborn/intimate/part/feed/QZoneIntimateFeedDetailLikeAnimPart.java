package com.qzone.reborn.intimate.part.feed;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.richframework.data.base.UIStateData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nk.aq;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/qzone/reborn/intimate/part/feed/QZoneIntimateFeedDetailLikeAnimPart;", "Lcom/qzone/reborn/intimate/part/feed/b;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "", "getLogTag", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class QZoneIntimateFeedDetailLikeAnimPart extends b {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneIntimateFeedDetailLikeAnimPart";
    }

    @Override // com.qzone.reborn.intimate.part.feed.b, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        MutableLiveData<UIStateData<BusinessFeedData>> R1;
        super.onInitView(rootView);
        aq aqVar = (aq) getViewModel(aq.class);
        if (aqVar == null || (R1 = aqVar.R1()) == null) {
            return;
        }
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<UIStateData<BusinessFeedData>, Unit> function1 = new Function1<UIStateData<BusinessFeedData>, Unit>() { // from class: com.qzone.reborn.intimate.part.feed.QZoneIntimateFeedDetailLikeAnimPart$onInitView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<BusinessFeedData> uIStateData) {
                invoke2(uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<BusinessFeedData> uIStateData) {
                if (uIStateData.getData() == null || uIStateData.getData().cellIntimateSpaceInfo == null) {
                    return;
                }
                QZoneIntimateFeedDetailLikeAnimPart qZoneIntimateFeedDetailLikeAnimPart = QZoneIntimateFeedDetailLikeAnimPart.this;
                int i3 = uIStateData.getData().cellIntimateSpaceInfo.spaceType;
                String str = uIStateData.getData().cellIntimateSpaceInfo.spaceId;
                Intrinsics.checkNotNullExpressionValue(str, "it.data.cellIntimateSpaceInfo.spaceId");
                qZoneIntimateFeedDetailLikeAnimPart.J9(i3, str);
            }
        };
        R1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.intimate.part.feed.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneIntimateFeedDetailLikeAnimPart.O9(Function1.this, obj);
            }
        });
    }
}

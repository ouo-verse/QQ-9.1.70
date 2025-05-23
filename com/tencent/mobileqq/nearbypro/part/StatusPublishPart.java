package com.tencent.mobileqq.nearbypro.part;

import android.view.View;
import android.view.ViewStub;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/part/StatusPublishPart;", "Lcom/tencent/mobileqq/nearbypro/part/e;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class StatusPublishPart extends e {
    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        View view;
        final View findViewById;
        ViewStub viewStub;
        super.onInitView(rootView);
        if (rootView != null && (viewStub = (ViewStub) rootView.findViewById(R.id.v3_)) != null) {
            view = viewStub.inflate();
        } else {
            view = null;
        }
        if (view != null && (findViewById = view.findViewById(R.id.f29130kt)) != null) {
            final long j3 = 200;
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.nearbypro.part.StatusPublishPart$onInitView$$inlined$setSingleClickListener$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View it) {
                    EventCollector.getInstance().onViewClickedBefore(it);
                    findViewById.setClickable(false);
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    this.z9().t5("update_map_concise_action", Boolean.TRUE);
                    final View view2 = findViewById;
                    view2.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.nearbypro.part.StatusPublishPart$onInitView$$inlined$setSingleClickListener$1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            view2.setClickable(true);
                        }
                    }, j3);
                    EventCollector.getInstance().onViewClicked(it);
                }
            });
        }
    }
}

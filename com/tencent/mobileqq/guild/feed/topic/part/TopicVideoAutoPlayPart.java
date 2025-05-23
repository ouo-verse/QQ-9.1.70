package com.tencent.mobileqq.guild.feed.topic.part;

import android.app.Activity;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u001a\u0010\r\u001a\u00060\tj\u0002`\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/part/TopicVideoAutoPlayPart;", "Lcom/tencent/mobileqq/guild/feed/topic/part/TopicListBasePart;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Lyj1/e;", "Lcom/tencent/mobileqq/guild/feed/topic/TopicVideoPlayManager;", "D", "Lyj1/e;", "videoPlayManager", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class TopicVideoAutoPlayPart extends TopicListBasePart {

    /* renamed from: D, reason: from kotlin metadata */
    private yj1.e videoPlayManager;

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        this.videoPlayManager = C9().getVideoMgr();
        RecyclerView rv5 = (RecyclerView) rootView.findViewById(R.id.f100245rz);
        Intrinsics.checkNotNullExpressionValue(rv5, "rv");
        LifecycleOwner viewLifecycleOwner = getHostFragment().getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "hostFragment.viewLifecycleOwner");
        wj1.e.a(rv5, viewLifecycleOwner, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.topic.part.TopicVideoAutoPlayPart$onInitView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                yj1.e eVar;
                eVar = TopicVideoAutoPlayPart.this.videoPlayManager;
                if (eVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("videoPlayManager");
                    eVar = null;
                }
                eVar.b();
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        yj1.e eVar = this.videoPlayManager;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoPlayManager");
            eVar = null;
        }
        eVar.d();
        super.onPartDestroy(activity);
    }
}

package com.tencent.mobileqq.guild.feed.part;

import android.view.View;
import android.widget.FrameLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/part/g;", "Lcom/tencent/mobileqq/guild/feed/part/d;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Landroid/widget/FrameLayout;", "d", "Landroid/widget/FrameLayout;", ParseCommon.CONTAINER, "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class g extends d {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout container;

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        FrameLayout frameLayout;
        super.onInitView(rootView);
        if (rootView != null) {
            frameLayout = (FrameLayout) rootView.findViewById(R.id.w7s);
        } else {
            frameLayout = null;
        }
        this.container = frameLayout;
        if (frameLayout != null) {
            frameLayout.setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
        }
    }
}

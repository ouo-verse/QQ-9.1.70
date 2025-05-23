package com.tencent.mobileqq.guild.feed.nativedetail.content.part;

import android.app.Activity;
import android.util.SparseArray;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.animation.transition.TransitionBean;
import com.tencent.biz.richframework.animation.transition.TransitionHelper;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0016\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/part/ae;", "Lcom/tencent/mobileqq/guild/feed/part/d;", "Lcom/tencent/biz/richframework/animation/transition/TransitionHelper$TransitionBeanCreator;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "", com.tencent.luggage.wxa.c8.c.G, "creator", "x9", "Lcom/tencent/biz/richframework/animation/transition/TransitionBean;", "generateTransitionBean", "Landroid/util/SparseArray;", "d", "Landroid/util/SparseArray;", "creators", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class ae extends com.tencent.mobileqq.guild.feed.part.d implements TransitionHelper.TransitionBeanCreator {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SparseArray<TransitionHelper.TransitionBeanCreator> creators = new SparseArray<>();

    @Override // com.tencent.biz.richframework.animation.transition.TransitionHelper.TransitionBeanCreator
    @Nullable
    public TransitionBean generateTransitionBean(int pos) {
        TransitionHelper.TransitionBeanCreator transitionBeanCreator = this.creators.get(pos);
        if (transitionBeanCreator != null) {
            return transitionBeanCreator.generateTransitionBean(pos);
        }
        return null;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        RFWIocAbilityProvider.g().registerIoc(rootView, this, TransitionHelper.TransitionBeanCreator.class);
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        RFWIocAbilityProvider.g().unregisterSingleIoc(getPartRootView(), TransitionHelper.TransitionBeanCreator.class);
    }

    public final void x9(int pos, @NotNull TransitionHelper.TransitionBeanCreator creator) {
        Intrinsics.checkNotNullParameter(creator, "creator");
        this.creators.put(pos, creator);
    }
}

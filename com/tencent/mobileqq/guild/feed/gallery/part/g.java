package com.tencent.mobileqq.guild.feed.gallery.part;

import android.app.Activity;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.gallery.widget.GuildFeedDoublePraiseView;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/part/g;", "Lcom/tencent/mobileqq/guild/feed/part/f;", "Lcom/tencent/mobileqq/guild/feed/gallery/part/t;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "B9", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Lcom/tencent/mobileqq/guild/feed/gallery/part/g$a$a;", "param", "r0", "Lcom/tencent/mobileqq/guild/feed/gallery/widget/GuildFeedDoublePraiseView;", tl.h.F, "Lcom/tencent/mobileqq/guild/feed/gallery/widget/GuildFeedDoublePraiseView;", "mAnimationView", "<init>", "()V", "i", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class g extends com.tencent.mobileqq.guild.feed.part.f implements t {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildFeedDoublePraiseView mAnimationView;

    private final void B9(View rootView) {
        this.mAnimationView = (GuildFeedDoublePraiseView) rootView.findViewById(R.id.wge);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        if (rootView == null) {
            return;
        }
        super.onInitView(rootView);
        B9(rootView);
        RFWIocAbilityProvider.g().registerIoc(getPartRootView(), this, t.class);
    }

    @Override // com.tencent.mobileqq.guild.feed.part.f, com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        RFWIocAbilityProvider.g().unregisterSingleIoc(getPartRootView(), t.class);
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.part.t
    public void r0(@NotNull Companion.ExecuteLikeParam param) {
        Intrinsics.checkNotNullParameter(param, "param");
        if (param.getPositionX() != null && param.getPositionY() != null) {
            QLog.d("GuildFeedGalleryLikeAnimationPart", 1, QZoneJsConstants.ACTION_START_ANIMATION);
            GuildFeedDoublePraiseView guildFeedDoublePraiseView = this.mAnimationView;
            if (guildFeedDoublePraiseView != null) {
                guildFeedDoublePraiseView.g(param.getPositionX().intValue(), param.getPositionY().intValue());
            }
            broadcastMessage("message_on_do_execute_like", param.getFeedId());
        }
    }
}

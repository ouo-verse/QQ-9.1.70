package com.tencent.mobileqq.guild.feed.part;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.detail.event.MFViewShowEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedTroopLifeCycleEvent;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedMainInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedTroopInitBean;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.widget.operationbanner.GuildOperationBanner;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 ,2\u00020\u0001:\u0001-B\u0007\u00a2\u0006\u0004\b*\u0010+J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\f\u0010\u000e\u001a\u00020\u0004*\u00020\rH\u0002J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J$\u0010\u0017\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0013j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014`\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0016R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010#\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010&\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/guild/feed/part/e;", "Lcom/tencent/mobileqq/guild/feed/part/f;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "E9", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "D9", "", "lifeCycleTypeCode", "F9", "B9", "Lcom/tencent/mobileqq/guild/widget/operationbanner/GuildOperationBanner;", "C9", "onInitView", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "simpleBaseEvent", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "", "Lkotlin/collections/ArrayList;", "getEventClass", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartPause", "onPartDestroy", "Landroid/widget/LinearLayout;", tl.h.F, "Landroid/widget/LinearLayout;", "mContainer", "i", "Lcom/tencent/mobileqq/guild/widget/operationbanner/GuildOperationBanner;", "mBannerView", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "mLastExposureStatusExceptLifeCycle", BdhLogUtil.LogTag.Tag_Conn, "mIsFirstResume", "<init>", "()V", "D", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class e extends f {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildOperationBanner mBannerView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mLastExposureStatusExceptLifeCycle = true;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean mIsFirstResume = true;

    private final void B9() {
        if (ax.G(x9())) {
            LinearLayout linearLayout = this.mContainer;
            RelativeLayout.LayoutParams layoutParams = null;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                linearLayout = null;
            }
            ViewGroup.LayoutParams layoutParams2 = linearLayout.getLayoutParams();
            if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                layoutParams = (RelativeLayout.LayoutParams) layoutParams2;
            }
            if (layoutParams == null) {
                new RelativeLayout.LayoutParams(-2, -2);
            }
        }
    }

    private final void C9(GuildOperationBanner guildOperationBanner) {
        GuildFeedMainInitBean x95 = x9();
        if (x95 == null) {
            return;
        }
        try {
            if (x95 instanceof GuildFeedTroopInitBean) {
                String guildId = ((GuildFeedTroopInitBean) x95).getGuildId();
                Intrinsics.checkNotNullExpressionValue(guildId, "bean.guildId");
                long parseLong = Long.parseLong(guildId);
                String troopUin = ((GuildFeedTroopInitBean) x95).getTroopUin();
                Intrinsics.checkNotNullExpressionValue(troopUin, "bean.troopUin");
                guildOperationBanner.t(parseLong, Long.parseLong(troopUin));
            } else {
                String guildId2 = x95.getGuildId();
                Intrinsics.checkNotNullExpressionValue(guildId2, "bean.guildId");
                long parseLong2 = Long.parseLong(guildId2);
                String channelId = x95.getChannelId();
                Intrinsics.checkNotNullExpressionValue(channelId, "bean.channelId");
                guildOperationBanner.u(parseLong2, Long.parseLong(channelId), 7);
            }
        } catch (NumberFormatException unused) {
            QLog.e("GuildFeedBannerContainerPart", 1, "initData | id isn't number");
        }
    }

    private final void D9(ViewGroup container) {
        if (container.getChildCount() != 0) {
            container.removeAllViews();
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        GuildOperationBanner guildOperationBanner = new GuildOperationBanner(context, null, 2, null);
        container.setVisibility(0);
        container.addView(guildOperationBanner);
        C9(guildOperationBanner);
        this.mBannerView = guildOperationBanner;
    }

    private final void E9(View rootView) {
        View findViewById = rootView.findViewById(R.id.wch);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026ld_feed_operation_banner)");
        this.mContainer = (LinearLayout) findViewById;
        B9();
        LinearLayout linearLayout = this.mContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            linearLayout = null;
        }
        D9(linearLayout);
    }

    private final void F9(int lifeCycleTypeCode) {
        GuildOperationBanner guildOperationBanner;
        if (lifeCycleTypeCode != 1) {
            if (lifeCycleTypeCode != 3) {
                if (lifeCycleTypeCode != 6) {
                    if (lifeCycleTypeCode == 7) {
                        this.mLastExposureStatusExceptLifeCycle = false;
                        GuildOperationBanner guildOperationBanner2 = this.mBannerView;
                        if (guildOperationBanner2 != null) {
                            guildOperationBanner2.setAttachedPageVisibility(false);
                            return;
                        }
                        return;
                    }
                    return;
                }
                this.mLastExposureStatusExceptLifeCycle = true;
                GuildOperationBanner guildOperationBanner3 = this.mBannerView;
                if (guildOperationBanner3 != null) {
                    guildOperationBanner3.setAttachedPageVisibility(true);
                    return;
                }
                return;
            }
            GuildOperationBanner guildOperationBanner4 = this.mBannerView;
            if (guildOperationBanner4 != null) {
                guildOperationBanner4.setAttachedPageVisibility(false);
                return;
            }
            return;
        }
        if (this.mLastExposureStatusExceptLifeCycle && (guildOperationBanner = this.mBannerView) != null) {
            guildOperationBanner.setAttachedPageVisibility(true);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<Object>> getEventClass() {
        ArrayList<Class<Object>> eventClass = super.getEventClass();
        if (eventClass == null) {
            eventClass = new ArrayList<>();
        }
        if (ax.G(x9())) {
            eventClass.add(GuildFeedTroopLifeCycleEvent.class);
        } else {
            eventClass.add(MFViewShowEvent.class);
        }
        return eventClass;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        if (rootView != null) {
            E9(rootView);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.part.f, com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        GuildOperationBanner guildOperationBanner = this.mBannerView;
        if (guildOperationBanner != null) {
            guildOperationBanner.setAttachedPageVisibility(false);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (ax.G(x9())) {
            return;
        }
        super.onPartPause(activity);
        GuildOperationBanner guildOperationBanner = this.mBannerView;
        if (guildOperationBanner != null) {
            guildOperationBanner.setAttachedPageVisibility(false);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@NotNull Activity activity) {
        GuildOperationBanner guildOperationBanner;
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (!this.mIsFirstResume && ax.G(x9())) {
            return;
        }
        QLog.d("GuildFeedBannerContainerPart", 1, "onActivityResumed | setAttachedPageVisibility to " + this.mLastExposureStatusExceptLifeCycle);
        this.mIsFirstResume = false;
        super.onPartResume(activity);
        if (this.mLastExposureStatusExceptLifeCycle && (guildOperationBanner = this.mBannerView) != null) {
            guildOperationBanner.setAttachedPageVisibility(true);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof MFViewShowEvent) {
            boolean show = ((MFViewShowEvent) simpleBaseEvent).getShow();
            this.mLastExposureStatusExceptLifeCycle = show;
            GuildOperationBanner guildOperationBanner = this.mBannerView;
            if (guildOperationBanner != null) {
                guildOperationBanner.setAttachedPageVisibility(show);
                return;
            }
            return;
        }
        if (simpleBaseEvent instanceof GuildFeedTroopLifeCycleEvent) {
            F9(((GuildFeedTroopLifeCycleEvent) simpleBaseEvent).getTroopContainerLifeCycle());
        }
    }
}

package com.tencent.mobileqq.guild.feed.gallery;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartFragmentIOCKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.guild.api.IRecentGuildApi;
import com.tencent.mobileqq.guild.feed.api.AnimationParams;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedImagePreDecoder;
import com.tencent.mobileqq.guild.feed.api.impl.GuildFeedImagePreDecoder;
import com.tencent.mobileqq.guild.feed.bean.GuildFeedRichMediaData;
import com.tencent.mobileqq.guild.feed.feedsquare.data.g;
import com.tencent.mobileqq.guild.feed.fragment.GuildQBasePartFragment;
import com.tencent.mobileqq.guild.feed.gallery.msgintent.FeedPublishFinishMsgResult;
import com.tencent.mobileqq.guild.feed.gallery.part.GuildFeedGalleryBottomInputHelperPart;
import com.tencent.mobileqq.guild.feed.gallery.part.GuildFeedGalleryBusinessPart;
import com.tencent.mobileqq.guild.feed.gallery.part.GuildFeedGalleryCommentCachePart;
import com.tencent.mobileqq.guild.feed.gallery.part.GuildFeedGalleryListPart;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedGalleryInitBean;
import com.tencent.mobileqq.guild.feed.nativedetail.content.part.FeedGalleryAnimPart;
import com.tencent.mobileqq.guild.feed.part.GuildFeedRichMediaDownLoadPart;
import com.tencent.mobileqq.guild.feed.part.aa;
import com.tencent.mobileqq.guild.feed.part.av;
import com.tencent.mobileqq.guild.feed.part.f;
import com.tencent.mobileqq.guild.feed.preload.detail.data.GuildFeedDetailPreloadParams;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildTaskProgressState;
import com.tencent.mobileqq.guild.feed.publish.publishV2.IFeedPublishServiceV2;
import com.tencent.mobileqq.guild.feed.share.x;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.mainframe.GuildFeedReportSourceInfo;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.az;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mvi.base.route.VMMessenger;
import com.tencent.mvi.base.route.j;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelSign;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kn1.FeedPublishStateV2;
import kn1.a;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import mk1.e;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 <2\u00020\u0001:\u0001=B\u0007\u00a2\u0006\u0004\b:\u0010;J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J,\u0010\u0012\u001a\u00020\u00042\"\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rj\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f`\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u000eH\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0014J&\u0010%\u001a\u0004\u0018\u00010\b2\u0006\u0010 \u001a\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010$\u001a\u0004\u0018\u00010#H\u0016J\b\u0010&\u001a\u00020\u001dH\u0014J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020'H\u0016J\u001c\u0010*\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010$\u001a\u0004\u0018\u00010#H\u0014J\u0012\u0010+\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010#H\u0016J\b\u0010,\u001a\u00020\u0004H\u0016J\u000e\u0010/\u001a\b\u0012\u0004\u0012\u00020.0-H\u0016J\b\u00100\u001a\u00020\u000eH\u0014J\b\u00101\u001a\u00020\u0017H\u0014J\b\u00102\u001a\u00020\u0004H\u0016J\b\u00103\u001a\u00020\u0004H\u0016J\b\u00104\u001a\u00020\u0004H\u0016R\u0018\u00105\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u00108\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/GuildFeedGalleryFragment;", "Lcom/tencent/mobileqq/guild/feed/fragment/GuildQBasePartFragment;", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedGalleryInitBean;", "getInitBean", "", "initGalleryInitBean", "initStFeed", "initEmptyStFeed", "Landroid/view/View;", "contentView", "pageDtReport", "Lcom/tencent/mobileqq/guild/feed/part/f;", "getFeedGallerySharePart", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "params", "addGroupParam", "getPageId", "initFeedPublishObserve", "Lkn1/b;", "state", "", "filterPublishFeed", "Lkn1/a$b;", "event", "handlePublishEnd", "updateInitBean", "", "getStatusBarColor", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", "getContentLayoutId", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onAttach", "onViewCreatedBeforePartInit", "onCreate", "onFinish", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "getLogTag", "needSupportFullScreen", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "mGalleryInitBean", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedGalleryInitBean;", "Lcom/tencent/mvi/base/route/VMMessenger;", "mMessenger", "Lcom/tencent/mvi/base/route/VMMessenger;", "<init>", "()V", "Companion", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedGalleryFragment extends GuildQBasePartFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "Guild_Feed_GAL_GuildFeedGalleryFragment";

    @Nullable
    private GuildFeedGalleryInitBean mGalleryInitBean;
    private VMMessenger mMessenger;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\"\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/GuildFeedGalleryFragment$a;", "", "Landroid/view/View;", "animaView", "Lcom/tencent/mobileqq/guild/feed/api/AnimationParams;", "b", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedGalleryInitBean;", "initBean", "", "d", "Landroid/content/Context;", "context", "animView", "c", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.gallery.GuildFeedGalleryFragment$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final AnimationParams b(View animaView) {
            animaView.getLocationInWindow(new int[2]);
            AnimationParams animationParams = new AnimationParams(r0[0], r0[1], animaView.getWidth(), animaView.getHeight(), animaView.getHeight());
            QLog.i(GuildFeedGalleryFragment.TAG, 4, "getAnimationParams screenX=" + animationParams.getScreenX() + " screenY=" + animationParams.getScreenY() + " width=" + animationParams.getWidthSource() + " height=" + animationParams.getHeightSource());
            return animationParams;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void d(GuildFeedGalleryInitBean initBean) {
            Object orNull;
            GProStImage firstShowImage;
            List listOf;
            List<GuildFeedRichMediaData> richMediaDataList = initBean.getRichMediaDataList();
            Intrinsics.checkNotNullExpressionValue(richMediaDataList, "initBean.richMediaDataList");
            orNull = CollectionsKt___CollectionsKt.getOrNull(richMediaDataList, initBean.getEnterPos());
            GuildFeedRichMediaData guildFeedRichMediaData = (GuildFeedRichMediaData) orNull;
            if (guildFeedRichMediaData == null) {
                return;
            }
            int type = guildFeedRichMediaData.getType();
            if (type != 0) {
                if (type != 1) {
                    Logger logger = Logger.f235387a;
                    Logger.b bVar = new Logger.b();
                    String str = "[preloadBitmap] error media " + guildFeedRichMediaData.getType();
                    if (str instanceof String) {
                        bVar.a().add(str);
                    }
                    Iterator<T> it = bVar.a().iterator();
                    while (it.hasNext()) {
                        Logger.f235387a.d().e(GuildFeedGalleryFragment.TAG, 1, (String) it.next(), null);
                    }
                    return;
                }
                firstShowImage = guildFeedRichMediaData.getVideo().cover;
            } else {
                firstShowImage = guildFeedRichMediaData.getImage();
            }
            Logger logger2 = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d(GuildFeedGalleryFragment.TAG, "[preloadBitmap] " + firstShowImage.picUrl);
            }
            GuildFeedImagePreDecoder guildFeedImagePreDecoder = GuildFeedImagePreDecoder.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(firstShowImage, "firstShowImage");
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{pl1.a.g(firstShowImage), pl1.a.d(firstShowImage)});
            IGuildFeedImagePreDecoder.a.a(guildFeedImagePreDecoder, listOf, null, 2, null);
        }

        public final void c(@NotNull Context context, @NotNull GuildFeedGalleryInitBean initBean, @Nullable View animView) {
            Activity activity;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(initBean, "initBean");
            if (MobileQQ.sProcessId == 1) {
                d(initBean);
            }
            Intent intent = new Intent();
            intent.setClass(context, QPublicTransFragmentActivity.class);
            intent.putExtra(com.tencent.mobileqq.guild.feed.b.f218115a, initBean);
            intent.addFlags(268435456);
            intent.putExtra("public_fragment_window_feature", 1);
            intent.putExtra("public_fragment_class", GuildFeedGalleryFragment.class.getName());
            if (animView != null) {
                AnimationParams b16 = GuildFeedGalleryFragment.INSTANCE.b(animView);
                Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type android.os.Parcelable");
                intent.putExtra("feed_detail_animation_params", (Parcelable) b16);
            }
            context.startActivity(intent);
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                activity = null;
            }
            if (activity != null) {
                activity.overridePendingTransition(0, 0);
            }
        }

        Companion() {
        }
    }

    private final void addGroupParam(HashMap<String, Object> params) {
        String str;
        Integer num;
        String str2;
        String str3;
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.mGalleryInitBean;
        String str4 = null;
        if (guildFeedGalleryInitBean != null) {
            str = guildFeedGalleryInitBean.getTroopUin();
        } else {
            str = null;
        }
        String str5 = "";
        if (str == null) {
            str = "";
        }
        params.put("group_id", str);
        GuildFeedGalleryInitBean guildFeedGalleryInitBean2 = this.mGalleryInitBean;
        if (guildFeedGalleryInitBean2 == null) {
            num = "";
        } else {
            num = Integer.valueOf(guildFeedGalleryInitBean2.getTroopRole());
        }
        params.put("group_uin_type", num);
        GuildFeedGalleryInitBean guildFeedGalleryInitBean3 = this.mGalleryInitBean;
        if (guildFeedGalleryInitBean3 != null) {
            str2 = guildFeedGalleryInitBean3.getChannelId();
        } else {
            str2 = null;
        }
        if (str2 == null) {
            str2 = "";
        }
        params.put("sgrp_channel_id", str2);
        GuildFeedGalleryInitBean guildFeedGalleryInitBean4 = this.mGalleryInitBean;
        if (guildFeedGalleryInitBean4 != null) {
            str3 = guildFeedGalleryInitBean4.getFeedId();
        } else {
            str3 = null;
        }
        if (str3 == null) {
            str3 = "";
        }
        params.put("sgrp_feed_id", str3);
        GuildFeedGalleryInitBean guildFeedGalleryInitBean5 = this.mGalleryInitBean;
        if (guildFeedGalleryInitBean5 != null) {
            str4 = guildFeedGalleryInitBean5.getFeedId();
        }
        if (str4 != null) {
            str5 = str4;
        }
        params.put("sgrp_content_id", str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean filterPublishFeed(FeedPublishStateV2 state) {
        if (this.mGalleryInitBean == null) {
            return false;
        }
        String taskId = state.getTaskId();
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.mGalleryInitBean;
        Intrinsics.checkNotNull(guildFeedGalleryInitBean);
        if (!Intrinsics.areEqual(taskId, guildFeedGalleryInitBean.getPublishTaskId())) {
            return false;
        }
        return true;
    }

    private final f getFeedGallerySharePart() {
        GuildFeedGalleryInitBean initBean = getInitBean();
        boolean z16 = false;
        if (initBean != null && initBean.getBusinessType() == 7) {
            z16 = true;
        }
        if (z16 && !TextUtils.isEmpty(initBean.getTroopUin())) {
            String troopUin = initBean.getTroopUin();
            Intrinsics.checkNotNullExpressionValue(troopUin, "initBean.troopUin");
            return new av(troopUin);
        }
        return new aa();
    }

    private final GuildFeedGalleryInitBean getInitBean() {
        Intent intent;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            intent = activity.getIntent();
        } else {
            intent = null;
        }
        if (intent == null) {
            return null;
        }
        if (!intent.hasExtra(com.tencent.mobileqq.guild.feed.b.f218115a)) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("[initGalleryInitBean] no bean in intent!");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e(TAG, 1, (String) it.next(), null);
            }
            return null;
        }
        Serializable serializableExtra = intent.getSerializableExtra(com.tencent.mobileqq.guild.feed.b.f218115a);
        if (!(serializableExtra instanceof GuildFeedGalleryInitBean)) {
            return null;
        }
        return (GuildFeedGalleryInitBean) serializableExtra;
    }

    private final String getPageId() {
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.mGalleryInitBean;
        boolean z16 = false;
        if (guildFeedGalleryInitBean != null && guildFeedGalleryInitBean.isFromTroop()) {
            z16 = true;
        }
        if (z16) {
            return "pg_group_sgrp_forum_viewer_feeds";
        }
        return "pg_sgrp_forum_viewer_feeds";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handlePublishEnd(a.FeedPublishFinish event) {
        Logger.f235387a.d().i(TAG, 1, "[handlePublishEnd] stFeed.idd=" + event.getState().getStFeed().idd + " taskState=" + event.getState().getTaskState() + " ");
        if (kn1.c.c(event.getState().getTaskState())) {
            updateInitBean(event);
            GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.mGalleryInitBean;
            if (guildFeedGalleryInitBean != null) {
                VMMessenger vMMessenger = this.mMessenger;
                if (vMMessenger == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMessenger");
                    vMMessenger = null;
                }
                vMMessenger.h(new FeedPublishFinishMsgResult(guildFeedGalleryInitBean));
            }
        }
    }

    private final void initEmptyStFeed() {
        String str;
        String str2;
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.mGalleryInitBean;
        if (guildFeedGalleryInitBean != null) {
            long d16 = az.d(guildFeedGalleryInitBean.getGuildId(), 0L);
            long d17 = az.d(guildFeedGalleryInitBean.getChannelId(), 0L);
            String feedId = guildFeedGalleryInitBean.getFeedId();
            if (feedId == null) {
                str = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(feedId, "it.feedId ?: \"\"");
                str = feedId;
            }
            String posterId = guildFeedGalleryInitBean.getPosterId();
            if (posterId == null) {
                str2 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(posterId, "it.posterId ?: \"\"");
                str2 = posterId;
            }
            guildFeedGalleryInitBean.setFeed(new GuildFeedDetailPreloadParams(d16, d17, str, str2, 0L, 0L).covertToStFeed());
        }
    }

    private final void initFeedPublishObserve() {
        VMMessenger vMMessenger = new VMMessenger(false, null, 3, 0 == true ? 1 : 0);
        PartFragmentIOCKt.registerIoc(this, vMMessenger, j.class);
        this.mMessenger = vMMessenger;
        final Flow<a.FeedPublishFinish> publishEndFlow = ((IFeedPublishServiceV2) ch.R0(IFeedPublishServiceV2.class)).publishEndFlow();
        FlowKt.launchIn(FlowKt.onEach(new Flow<a.FeedPublishFinish>() { // from class: com.tencent.mobileqq.guild.feed.gallery.GuildFeedGalleryFragment$initFeedPublishObserve$$inlined$filter$1

            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$lambda-1$$inlined$collect$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 7, 1}, xi = 48)
            /* renamed from: com.tencent.mobileqq.guild.feed.gallery.GuildFeedGalleryFragment$initFeedPublishObserve$$inlined$filter$1$2, reason: invalid class name */
            /* loaded from: classes13.dex */
            public static final class AnonymousClass2 implements FlowCollector<a.FeedPublishFinish> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ FlowCollector f219560d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ GuildFeedGalleryFragment f219561e;

                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.gallery.GuildFeedGalleryFragment$initFeedPublishObserve$$inlined$filter$1$2", f = "GuildFeedGalleryFragment.kt", i = {}, l = {136}, m = "emit", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.guild.feed.gallery.GuildFeedGalleryFragment$initFeedPublishObserve$$inlined$filter$1$2$1, reason: invalid class name */
                /* loaded from: classes13.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, GuildFeedGalleryFragment guildFeedGalleryFragment) {
                    this.f219560d = flowCollector;
                    this.f219561e = guildFeedGalleryFragment;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object emit(a.FeedPublishFinish feedPublishFinish, @NotNull Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object coroutine_suspended;
                    int i3;
                    boolean filterPublishFeed;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i16 = anonymousClass1.label;
                        if ((i16 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label = i16 - Integer.MIN_VALUE;
                            Object obj = anonymousClass1.result;
                            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i3 = anonymousClass1.label;
                            if (i3 == 0) {
                                if (i3 == 1) {
                                    ResultKt.throwOnFailure(obj);
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            } else {
                                ResultKt.throwOnFailure(obj);
                                FlowCollector flowCollector = this.f219560d;
                                filterPublishFeed = this.f219561e.filterPublishFeed(feedPublishFinish.getState());
                                if (filterPublishFeed) {
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(feedPublishFinish, anonymousClass1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj2 = anonymousClass1.result;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i3 = anonymousClass1.label;
                    if (i3 == 0) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            @Nullable
            public Object collect(@NotNull FlowCollector<? super a.FeedPublishFinish> flowCollector, @NotNull Continuation continuation) {
                Object coroutine_suspended;
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector, this), continuation);
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (collect == coroutine_suspended) {
                    return collect;
                }
                return Unit.INSTANCE;
            }
        }, new GuildFeedGalleryFragment$initFeedPublishObserve$3(this, null)), LifecycleOwnerKt.getLifecycleScope(this));
    }

    private final void initGalleryInitBean() {
        GuildFeedReportSourceInfo guildFeedReportSourceInfo;
        Integer num;
        Integer num2;
        List<GuildFeedRichMediaData> richMediaDataList;
        GuildFeedGalleryInitBean initBean = getInitBean();
        if (initBean == null) {
            return;
        }
        this.mGalleryInitBean = initBean;
        initStFeed();
        com.tencent.mobileqq.guild.feed.report.c.f223280a.t(this.mGalleryInitBean, getArguments());
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.mGalleryInitBean;
        Boolean bool = null;
        if (guildFeedGalleryInitBean != null) {
            guildFeedReportSourceInfo = guildFeedGalleryInitBean.getFeedReportSourceInfo();
        } else {
            guildFeedReportSourceInfo = null;
        }
        if (guildFeedReportSourceInfo == null) {
            guildFeedReportSourceInfo = new GuildFeedReportSourceInfo();
        }
        String pageId = getPageId();
        guildFeedReportSourceInfo.addReportItem("extra_feeds_page_id", pageId);
        GuildFeedGalleryInitBean guildFeedGalleryInitBean2 = this.mGalleryInitBean;
        if (guildFeedGalleryInitBean2 != null && (richMediaDataList = guildFeedGalleryInitBean2.getRichMediaDataList()) != null) {
            Iterator<T> it = richMediaDataList.iterator();
            while (it.hasNext()) {
                ((GuildFeedRichMediaData) it.next()).setPageId(pageId);
            }
        }
        GuildFeedGalleryInitBean guildFeedGalleryInitBean3 = this.mGalleryInitBean;
        if (guildFeedGalleryInitBean3 != null) {
            guildFeedGalleryInitBean3.setFeedReportSourceInfo(guildFeedReportSourceInfo);
        }
        Logger.a d16 = Logger.f235387a.d();
        GuildFeedGalleryInitBean guildFeedGalleryInitBean4 = this.mGalleryInitBean;
        if (guildFeedGalleryInitBean4 != null) {
            num = Integer.valueOf(guildFeedGalleryInitBean4.getImmersiveSource());
        } else {
            num = null;
        }
        GuildFeedGalleryInitBean guildFeedGalleryInitBean5 = this.mGalleryInitBean;
        if (guildFeedGalleryInitBean5 != null) {
            num2 = Integer.valueOf(guildFeedGalleryInitBean5.getBusinessType());
        } else {
            num2 = null;
        }
        GuildFeedGalleryInitBean guildFeedGalleryInitBean6 = this.mGalleryInitBean;
        if (guildFeedGalleryInitBean6 != null) {
            bool = Boolean.valueOf(guildFeedGalleryInitBean6.isFromTroop());
        }
        d16.d(TAG, 1, "[initData] immersiveSource=" + num + "  mBusinessType=" + num2 + " curPageId=" + pageId + " isFromTroop=" + bool);
        ax.K(getActivity(), this.mGalleryInitBean);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initStFeed() {
        GProStFeed feed;
        String str;
        byte b16;
        String str2;
        byte b17;
        String str3;
        byte b18;
        GuildFeedGalleryInitBean guildFeedGalleryInitBean;
        GuildFeedGalleryInitBean guildFeedGalleryInitBean2;
        GuildFeedGalleryInitBean guildFeedGalleryInitBean3;
        GuildFeedGalleryInitBean guildFeedGalleryInitBean4;
        GuildFeedGalleryInitBean guildFeedGalleryInitBean5 = this.mGalleryInitBean;
        Unit unit = null;
        String str4 = null;
        unit = null;
        if (guildFeedGalleryInitBean5 != null && (feed = guildFeedGalleryInitBean5.getFeed()) != null) {
            GuildFeedGalleryInitBean guildFeedGalleryInitBean6 = this.mGalleryInitBean;
            if (guildFeedGalleryInitBean6 != null) {
                str = guildFeedGalleryInitBean6.getChannelId();
            } else {
                str = null;
            }
            boolean z16 = false;
            if (str != null && str.length() != 0) {
                b16 = false;
            } else {
                b16 = true;
            }
            if (b16 != false && (guildFeedGalleryInitBean4 = this.mGalleryInitBean) != null) {
                guildFeedGalleryInitBean4.setChannelId(String.valueOf(feed.channelInfo.sign.channelId));
            }
            GuildFeedGalleryInitBean guildFeedGalleryInitBean7 = this.mGalleryInitBean;
            if (guildFeedGalleryInitBean7 != null) {
                str2 = guildFeedGalleryInitBean7.getGuildId();
            } else {
                str2 = null;
            }
            if (str2 != null && str2.length() != 0) {
                b17 = false;
            } else {
                b17 = true;
            }
            if (b17 != false && (guildFeedGalleryInitBean3 = this.mGalleryInitBean) != null) {
                guildFeedGalleryInitBean3.setGuildId(String.valueOf(feed.channelInfo.sign.guildId));
            }
            GuildFeedGalleryInitBean guildFeedGalleryInitBean8 = this.mGalleryInitBean;
            if (guildFeedGalleryInitBean8 != null) {
                str3 = guildFeedGalleryInitBean8.getFeedId();
            } else {
                str3 = null;
            }
            if (str3 != null && str3.length() != 0) {
                b18 = false;
            } else {
                b18 = true;
            }
            if (b18 != false && (guildFeedGalleryInitBean2 = this.mGalleryInitBean) != null) {
                guildFeedGalleryInitBean2.setFeedId(feed.idd);
            }
            GuildFeedGalleryInitBean guildFeedGalleryInitBean9 = this.mGalleryInitBean;
            if (guildFeedGalleryInitBean9 != null) {
                str4 = guildFeedGalleryInitBean9.getPosterId();
            }
            if (str4 == null || str4.length() == 0) {
                z16 = true;
            }
            if (z16 && (guildFeedGalleryInitBean = this.mGalleryInitBean) != null) {
                guildFeedGalleryInitBean.setPosterId(feed.poster.idd);
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            initEmptyStFeed();
        }
    }

    private final void pageDtReport(View contentView) {
        final GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.mGalleryInitBean;
        if (guildFeedGalleryInitBean == null) {
            return;
        }
        HashMap<String, Object> e16 = e.e(guildFeedGalleryInitBean);
        if (guildFeedGalleryInitBean.isFromTroop()) {
            addGroupParam(e16);
        }
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(contentView, getPageId());
        VideoReport.setPageParams(contentView, new PageParams(e16));
        VideoReport.setPageReportPolicy(contentView, PageReportPolicy.REPORT_NONE);
        VideoReport.setEventDynamicParams(contentView, new IDynamicParams() { // from class: com.tencent.mobileqq.guild.feed.gallery.c
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map pageDtReport$lambda$8;
                pageDtReport$lambda$8 = GuildFeedGalleryFragment.pageDtReport$lambda$8(GuildFeedGalleryInitBean.this, str);
                return pageDtReport$lambda$8;
            }
        });
        QLog.i(TAG, 1, "pageDtReport pageId=" + getPageId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map pageDtReport$lambda$8(GuildFeedGalleryInitBean galleryInitBean, String str) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(galleryInitBean, "$galleryInitBean");
        String sessionId = galleryInitBean.getSessionId();
        if (sessionId == null) {
            sessionId = "";
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_recommend_session", sessionId));
        return mapOf;
    }

    private final void updateInitBean(a.FeedPublishFinish event) {
        Logger.f235387a.d().i(TAG, 1, "[updateInitBean] save new InitBean");
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.mGalleryInitBean;
        if (guildFeedGalleryInitBean != null) {
            guildFeedGalleryInitBean.setFeedId(event.getState().getStFeed().idd);
            guildFeedGalleryInitBean.setFeed(event.getState().getStFeed());
            guildFeedGalleryInitBean.setTransStFeed(event.getState().getStFeed());
            GuildTaskProgressState taskState = event.getState().getTaskState();
            GProStFeed feed = guildFeedGalleryInitBean.getFeed();
            Intrinsics.checkNotNullExpressionValue(feed, "feed");
            guildFeedGalleryInitBean.setGuildFeedPublishInfo(g.a(taskState, com.tencent.mobileqq.guild.feed.nativeinterface.kt.a.j(feed)));
        }
        ax.K(getActivity(), this.mGalleryInitBean);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new GuildFeedGalleryListPart());
        arrayList.add(new com.tencent.mobileqq.guild.feed.gallery.part.e());
        arrayList.add(getFeedGallerySharePart());
        arrayList.add(new GuildFeedGalleryBusinessPart());
        arrayList.add(new GuildFeedRichMediaDownLoadPart());
        arrayList.add(new com.tencent.mobileqq.guild.feed.gallery.part.g());
        arrayList.add(new GuildFeedGalleryBottomInputHelperPart());
        arrayList.add(new com.tencent.mobileqq.guild.feed.gallery.part.d(21));
        arrayList.add(new GuildFeedGalleryCommentCachePart());
        arrayList.add(new FeedGalleryAnimPart());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f168077eo4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return TAG;
    }

    @Override // com.tencent.mobileqq.guild.feed.fragment.GuildQBasePartFragment
    protected int getStatusBarColor() {
        return 0;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.guild.feed.fragment.GuildQBasePartFragment
    protected boolean needSupportFullScreen() {
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onAttach(activity);
        ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).quitFloatingScreen(x.INSTANCE.a());
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Serializable serializable;
        Intent intent;
        FragmentActivity activity = getActivity();
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = null;
        if (activity != null && (intent = activity.getIntent()) != null) {
            serializable = intent.getSerializableExtra(com.tencent.mobileqq.guild.feed.b.f218115a);
        } else {
            serializable = null;
        }
        if (serializable instanceof GuildFeedGalleryInitBean) {
            guildFeedGalleryInitBean = (GuildFeedGalleryInitBean) serializable;
        }
        if (guildFeedGalleryInitBean != null) {
            INSTANCE.d(guildFeedGalleryInitBean);
        }
        super.onCreate(savedInstanceState);
    }

    @Override // com.tencent.mobileqq.guild.feed.fragment.GuildQBasePartFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.overridePendingTransition(0, 0);
        }
        View onCreateView = super.onCreateView(inflater, container, savedInstanceState);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        int i3;
        super.onDestroy();
        Logger.f235387a.d().d(TAG, 1, "[onDestroy] " + this);
        mk1.b bVar = mk1.b.f416885a;
        Context context = getContext();
        int i16 = 0;
        if (context != null) {
            i3 = context.hashCode();
        } else {
            i3 = 0;
        }
        bVar.d(i3);
        Context context2 = getContext();
        if (context2 != null) {
            i16 = context2.hashCode();
        }
        bVar.c(i16);
        bVar.e(null);
        PartFragmentIOCKt.unregisterIoc(this, j.class);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.overridePendingTransition(R.anim.f154557nb, R.anim.f154558nc);
        }
        super.onFinish();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        String str;
        super.onPause();
        Logger.f235387a.d().d(TAG, 1, "[onPause] " + this);
        View view = ((GuildQBasePartFragment) this).mContentView;
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.mGalleryInitBean;
        if (guildFeedGalleryInitBean != null) {
            str = guildFeedGalleryInitBean.getSessionId();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        VideoReport.setPageParams(view, "sgrp_recommend_session", str);
        VideoReport.reportPgOut(((GuildQBasePartFragment) this).mContentView);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        enableFlingRight(false);
        ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).preloadWebProcess();
        Logger.f235387a.d().d(TAG, 1, "[onResume] " + this);
        VideoReport.reportPgIn(((GuildQBasePartFragment) this).mContentView, false);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(@Nullable View contentView, @Nullable Bundle savedInstanceState) {
        GProStFeed feed;
        GProStChannelInfo gProStChannelInfo;
        GProStChannelSign gProStChannelSign;
        super.onViewCreatedBeforePartInit(contentView, savedInstanceState);
        initGalleryInitBean();
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = this.mGalleryInitBean;
        if (guildFeedGalleryInitBean != null && (feed = guildFeedGalleryInitBean.getFeed()) != null && (gProStChannelInfo = feed.channelInfo) != null && (gProStChannelSign = gProStChannelInfo.sign) != null) {
            ((IRecentGuildApi) QRoute.api(IRecentGuildApi.class)).addRecentVisitGuildsListSync(String.valueOf(gProStChannelSign.guildId), "GuildFeedGalleryFragment");
        }
        View mContentView = ((GuildQBasePartFragment) this).mContentView;
        Intrinsics.checkNotNullExpressionValue(mContentView, "mContentView");
        pageDtReport(mContentView);
        initFeedPublishObserve();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }
}

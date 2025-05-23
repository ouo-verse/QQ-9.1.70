package com.tencent.mobileqq.guild.feed.detail;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Consumer;
import androidx.core.util.Supplier;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.IGuildIPCService;
import com.tencent.mobileqq.guild.channel.joinchannel.JoinGuildLogic;
import com.tencent.mobileqq.guild.feed.FeedImpeachData;
import com.tencent.mobileqq.guild.feed.api.AnimationParams;
import com.tencent.mobileqq.guild.feed.comment.fragment.GuildWebFeedCommentFragment;
import com.tencent.mobileqq.guild.feed.debug.detail.GuildFeedDetailCostTimeViewDebug;
import com.tencent.mobileqq.guild.feed.detail.GuildFeedDetailWebViewFragment;
import com.tencent.mobileqq.guild.feed.detail.event.CommentStatusEvent;
import com.tencent.mobileqq.guild.feed.detail.event.FindUnfinishedCommentEvent;
import com.tencent.mobileqq.guild.feed.detail.event.GuildFeedDetailCacheRespEvent;
import com.tencent.mobileqq.guild.feed.detail.event.NotifySendingCommentsEvent;
import com.tencent.mobileqq.guild.feed.detail.guidebar.FeedDetailWebPageGuideBarDependencyImpl;
import com.tencent.mobileqq.guild.feed.event.GuildDetailViewDestroyEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedDeleteEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedDetailClickCommentEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedDetailClickPreferEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedDetailClickShareEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedDetailLikeEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedMuteStateChangeEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedShareChannelEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedUpdateCommentsEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedUpdatePreferEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedUpdateSharedCountEvent;
import com.tencent.mobileqq.guild.feed.event.GuildSpeakThresholdStateChangeEvent;
import com.tencent.mobileqq.guild.feed.fragment.GuildFeedBaseWebViewFragment;
import com.tencent.mobileqq.guild.feed.gallery.event.GuildFeedGalleryFirstPagerEvent;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDetailInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedLauncher;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedPublishEditPostInitBean;
import com.tencent.mobileqq.guild.feed.manager.GuildFeedDetailDataCacheManager;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.ui.NavigatorUI;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.SpeakPermissionType;
import com.tencent.mobileqq.guild.feed.usecases.GuildFeedArkShareInfo;
import com.tencent.mobileqq.guild.feed.util.GuildFeedReportHelper;
import com.tencent.mobileqq.guild.feed.util.au;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.feed.util.bl;
import com.tencent.mobileqq.guild.mainframe.GuildFeedReportSourceInfo;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.IGuildFastClickUtilApi;
import com.tencent.mobileqq.guild.util.IQQGuildUIUtilApi;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import nj1.FeedWebDetailParams;
import org.json.JSONException;
import org.json.JSONObject;
import pj1.a;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedDetailWebViewFragment extends GuildFeedBaseWebViewFragment implements lj1.a {
    private static final long ALPHA_ANIM_DURATION = 67;
    private static final float CLOSE_ICON_PADDINGBOTTOM = 12.0f;
    private static final float CLOSE_ICON_PADDINGLEFT = 10.0f;
    private static final float CLOSE_ICON_PADDINGTOP = 12.0f;
    private static final int CLOSE_ICON_WIDTH = 30;
    private static final int DEFAULT_HEIGHT = 44;
    private static final long SHOW_INPUT_POP_DELAY = 80;
    private static final String TAG = "GuildFeedDetailWebViewFragment";
    private static final long TOTAL_ANIM_DURATION = 200;
    private static boolean mIsNativeEmoji;
    private ej1.e inputPop;
    private ImageView mCloseIcon;
    private ImageView mCommentBtn;
    private g mCommentCallBack;
    private TextView mCommentNumTv;
    private View mDetailBottomLayout;
    private View mDetailTopLayout;
    private pj1.a mFacade;
    private g mFeedCacheCallback;
    private TextView mIntPut;
    private NavigatorUI mNavigatorUI;
    private g mOtherFeedCommentCallback;
    private long mPageInTime;
    private TextView mPreferNumTv;
    private ImageView mShareBtn;
    private View mShareContainer;
    private TextView mShareNumTv;
    private ImageView mUpVoteBtn;
    private LottieAnimationView mUpVoteClickedAnimView;
    private FeedWebDetailParams configParams = new FeedWebDetailParams();
    private final pj1.b mPermissionCalculator = new pj1.b(new Supplier() { // from class: com.tencent.mobileqq.guild.feed.detail.g
        @Override // androidx.core.util.Supplier
        public final Object get() {
            Boolean lambda$new$0;
            lambda$new$0 = GuildFeedDetailWebViewFragment.this.lambda$new$0();
            return lambda$new$0;
        }
    });
    private int mCurrentCommentCount = 0;
    private int mCurrentShareCount = 0;
    private int mCurrentPreferCount = 0;
    private int mPreferStatus = 0;
    private f mRecoverCommentCallback = null;
    private DecimalFormat mDecimalFormat = new DecimalFormat("#.#");
    private Map<String, Object> mDtReportParams = new HashMap();
    private boolean mHadReportPageIn = false;
    private boolean needFinishAnim = false;
    private float startScaleX = 1.0f;
    private float startScaleY = 1.0f;
    private float startTranslationX = 0.0f;
    private float startTranslationY = 0.0f;
    private Rect startClipBounds = new Rect();
    private Rect endClipBounds = new Rect();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class a implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f218441d;

        a(View view) {
            this.f218441d = view;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit b() {
            GuildFeedDetailWebViewFragment.this.needFinishAnim = true;
            return null;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f218441d.getViewTreeObserver().removeOnPreDrawListener(this);
            GuildFeedDetailWebViewFragment guildFeedDetailWebViewFragment = GuildFeedDetailWebViewFragment.this;
            guildFeedDetailWebViewFragment.initAnimationParams(((GuildFeedDetailInitBean) ((GuildFeedBaseWebViewFragment) guildFeedDetailWebViewFragment).mInitBean).getAnimationParams());
            View view = this.f218441d;
            Float valueOf = Float.valueOf(GuildFeedDetailWebViewFragment.this.startScaleX);
            Float valueOf2 = Float.valueOf(1.0f);
            Pair pair = new Pair(valueOf, valueOf2);
            Pair pair2 = new Pair(Float.valueOf(GuildFeedDetailWebViewFragment.this.startScaleY), valueOf2);
            Float valueOf3 = Float.valueOf(GuildFeedDetailWebViewFragment.this.startTranslationX);
            Float valueOf4 = Float.valueOf(0.0f);
            tl1.c.e(view, GuildFeedDetailWebViewFragment.TOTAL_ANIM_DURATION, pair, pair2, new Pair(valueOf3, valueOf4), new Pair(Float.valueOf(GuildFeedDetailWebViewFragment.this.startTranslationY), valueOf4), new Pair(GuildFeedDetailWebViewFragment.this.startClipBounds, GuildFeedDetailWebViewFragment.this.endClipBounds), new Pair(valueOf4, valueOf2), 0L, null, new Function0() { // from class: com.tencent.mobileqq.guild.feed.detail.w
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit b16;
                    b16 = GuildFeedDetailWebViewFragment.a.this.b();
                    return b16;
                }
            });
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    class b implements a.InterfaceC11021a {
        b() {
        }

        @Override // pj1.a.InterfaceC11021a
        @NonNull
        public pj1.b a() {
            return GuildFeedDetailWebViewFragment.this.mPermissionCalculator;
        }

        @Override // pj1.a.InterfaceC11021a
        public void b(nj1.a aVar) {
            aVar.l(GuildFeedDetailWebViewFragment.this.configParams.getSupportAt());
            aVar.m(GuildFeedDetailWebViewFragment.this.configParams.getTroopName());
            GuildFeedDetailWebViewFragment guildFeedDetailWebViewFragment = GuildFeedDetailWebViewFragment.this;
            guildFeedDetailWebViewFragment.showInputPopInner(aVar, guildFeedDetailWebViewFragment.getInitBean());
        }

        @Override // pj1.a.InterfaceC11021a
        @NonNull
        public GuildFeedDetailInitBean c() {
            return (GuildFeedDetailInitBean) ((GuildFeedBaseWebViewFragment) GuildFeedDetailWebViewFragment.this).mInitBean;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            GuildFeedDetailWebViewFragment.this.finish();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class d implements View.OnLongClickListener {
        d() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            EventCollector.getInstance().onViewLongClickedBefore(view);
            final nj1.a createDefaultInputParams = GuildFeedDetailWebViewFragment.this.createDefaultInputParams();
            ax.J(GuildFeedDetailWebViewFragment.this.mFacade, new Consumer() { // from class: com.tencent.mobileqq.guild.feed.detail.x
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    ((pj1.a) obj).e(nj1.a.this);
                }
            });
            EventCollector.getInstance().onViewLongClicked(view);
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public interface f {
        void onResult(String str);
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public interface g {
        void onResult(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: asyncCheckIfGuildInfoUpdateForGuest, reason: merged with bridge method [inline-methods] */
    public void lambda$tryCheckIfGuildInfoUpdateForGuest$12(final boolean z16) {
        Bundle bundle = new Bundle();
        bundle.putString("guildId", this.mInitBean.getGuildId());
        QIPCClientHelper.getInstance().callServer(IGuildIPCService.GUILD_NAME_IPC_NAME, "async_check_guild_info_update", bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.guild.feed.detail.r
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                GuildFeedDetailWebViewFragment.this.lambda$asyncCheckIfGuildInfoUpdateForGuest$16(z16, eIPCResult);
            }
        });
    }

    private void callToJs(boolean z16) {
        if (this.webView != null) {
            QLog.i(TAG, 1, "callToJs, hidden=" + z16);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("hidden", z16);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            this.webView.callJs(WebViewPlugin.toJsScript("guild_hybrid_visibility_change", jSONObject, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public nj1.a createDefaultInputParams() {
        return new nj1.a(this.configParams.getMaxLength(), false, "", 0L, "", "", "", 0, 1, this.configParams.getPlaceHolder(), this.configParams.getSupportAt(), this.configParams.getTroopName());
    }

    public static int dp2px(float f16) {
        return (int) TypedValue.applyDimension(1, f16, Resources.getSystem().getDisplayMetrics());
    }

    private void elementDtExposeReport() {
        HashMap hashMap = new HashMap();
        GuildFeedBaseInitBean guildFeedBaseInitBean = this.mInitBean;
        if (guildFeedBaseInitBean == null) {
            return;
        }
        hashMap.put("sgrp_channel_id", guildFeedBaseInitBean.getGuildId());
        hashMap.put("sgrp_sub_channel_id", this.mInitBean.getChannelId());
        GuildFeedBaseInitBean guildFeedBaseInitBean2 = this.mInitBean;
        if (guildFeedBaseInitBean2 instanceof GuildFeedDetailInitBean) {
            hashMap.put("sgrp_content_id", ((GuildFeedDetailInitBean) guildFeedBaseInitBean2).getFeedId());
            hashMap.put("sgrp_content_type", Integer.valueOf(((GuildFeedDetailInitBean) this.mInitBean).getFeedType()));
        }
        HashMap hashMap2 = new HashMap(hashMap);
        int i3 = 1;
        if (this.mPreferStatus != 1) {
            i3 = 0;
        }
        hashMap2.put("sgrp_state", Integer.valueOf(i3));
        hashMap2.put("sgrp_action_result", 0);
        VideoReport.setElementId(this.mCommentBtn, "em_sgrp_forum_comment");
        VideoReport.setElementParams(this.mCommentBtn, new HashMap<String, Object>(hashMap) { // from class: com.tencent.mobileqq.guild.feed.detail.GuildFeedDetailWebViewFragment.7
            final /* synthetic */ Map val$params;

            {
                this.val$params = hashMap;
                putAll(hashMap);
                put("sgrp_click_region", 2);
            }
        });
        ImageView imageView = this.mCommentBtn;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
        VideoReport.setElementExposePolicy(imageView, exposurePolicy);
        ImageView imageView2 = this.mCommentBtn;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
        VideoReport.setElementClickPolicy(imageView2, clickPolicy);
        VideoReport.setElementId(this.mIntPut, "em_sgrp_forum_comment");
        VideoReport.setElementParams(this.mIntPut, new HashMap<String, Object>(hashMap) { // from class: com.tencent.mobileqq.guild.feed.detail.GuildFeedDetailWebViewFragment.8
            final /* synthetic */ Map val$params;

            {
                this.val$params = hashMap;
                putAll(hashMap);
                put("sgrp_click_region", 1);
            }
        });
        VideoReport.setElementExposePolicy(this.mIntPut, exposurePolicy);
        TextView textView = this.mIntPut;
        ClickPolicy clickPolicy2 = ClickPolicy.REPORT_NONE;
        VideoReport.setElementClickPolicy(textView, clickPolicy2);
        VideoReport.setElementId(this.mUpVoteBtn, "em_sgrp_forum_up");
        VideoReport.setElementParams(this.mUpVoteBtn, hashMap2);
        VideoReport.setElementExposePolicy(this.mUpVoteBtn, exposurePolicy);
        VideoReport.setElementClickPolicy(this.mUpVoteBtn, clickPolicy2);
        VideoReport.setElementId(this.mShareBtn, "em_sgrp_forum_share");
        VideoReport.setElementParams(this.mShareBtn, hashMap);
        VideoReport.setElementExposePolicy(this.mShareBtn, exposurePolicy);
        VideoReport.setElementClickPolicy(this.mShareBtn, clickPolicy);
    }

    private int getZeroHintByViewId(View view) {
        if (view.getId() == R.id.e9q) {
            return R.string.f144510oz;
        }
        if (view.getId() == R.id.f164861b54) {
            return R.string.f144490ox;
        }
        if (view.getId() == R.id.f84514mg) {
            return R.string.f144520p0;
        }
        return 0;
    }

    private void handleChannelSelectShow() {
        ej1.e eVar = this.inputPop;
        if (eVar != null) {
            eVar.dismiss();
        }
        Bundle bundle = new Bundle();
        bundle.putString("key_guild_id", getInitBean().getGuildId());
        bundle.putString("key_channel_id", getInitBean().getChannelId());
        bundle.putInt("key_channel_type", 7);
        bundle.putInt("KEY_NEED_CHECK_PERMISSION_TYPE", 30002);
        bundle.putInt("part_panel_biz_type", 1);
        QIPCClientHelper.getInstance().callServer(IGuildIPCService.GUILD_NAME_IPC_NAME, "action_sync_check_empty_show_guild_hashtag", bundle);
    }

    private void handleEmoji() {
        Bundle bundle = new Bundle();
        bundle.putString("key_guild_id", this.mInitBean.getGuildId());
        bundle.putString("key_channel_id", this.mInitBean.getChannelId());
        QIPCClientHelper.getInstance().callServer(IGuildIPCService.GUILD_NAME_IPC_NAME, "sync_show_guild_emoj", bundle);
    }

    private void handleFeedDetailCacheResp(SimpleBaseEvent simpleBaseEvent) {
        QLog.d(TAG, 1, "handleFeedDetailCacheResp FeedWebBundle== " + simpleBaseEvent);
        GuildFeedDetailCacheRespEvent guildFeedDetailCacheRespEvent = (GuildFeedDetailCacheRespEvent) simpleBaseEvent;
        final String feedId = guildFeedDetailCacheRespEvent.getFeedId();
        final long lastModifyTime = guildFeedDetailCacheRespEvent.getLastModifyTime();
        if (this.mFeedCacheCallback != null) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.detail.GuildFeedDetailWebViewFragment.6
                @Override // java.lang.Runnable
                public void run() {
                    String q16 = GuildFeedDetailDataCacheManager.y().q(feedId, lastModifyTime);
                    if (!TextUtils.isEmpty(q16)) {
                        hj1.b.b(GuildFeedDetailWebViewFragment.TAG, "handleFeedDetailCacheResp FeedWebBundle== update to H5");
                        GuildFeedDetailWebViewFragment.this.mFeedCacheCallback.onResult(q16);
                    }
                }
            }, 64, null, true);
        } else {
            GuildFeedDetailDataCacheManager.y().F(feedId, lastModifyTime);
        }
    }

    private void handleFinish() {
        if (getActivity() != null && this.needFinishAnim) {
            this.needFinishAnim = false;
            getActivity().overridePendingTransition(0, 0);
            tl1.c.e(this.contentView, TOTAL_ANIM_DURATION, new Pair(Float.valueOf(1.0f), Float.valueOf(this.startScaleX)), new Pair(Float.valueOf(1.0f), Float.valueOf(this.startScaleY)), new Pair(Float.valueOf(0.0f), Float.valueOf(this.startTranslationX)), new Pair(Float.valueOf(0.0f), Float.valueOf(this.startTranslationY)), new Pair(this.endClipBounds, this.startClipBounds), new Pair(Float.valueOf(1.0f), Float.valueOf(0.0f)), 133L, null, new Function0() { // from class: com.tencent.mobileqq.guild.feed.detail.v
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit lambda$handleFinish$4;
                    lambda$handleFinish$4 = GuildFeedDetailWebViewFragment.this.lambda$handleFinish$4();
                    return lambda$handleFinish$4;
                }
            });
            return;
        }
        super.finish();
    }

    private void handleUpdatPreferEvent(GuildFeedUpdatePreferEvent guildFeedUpdatePreferEvent) {
        hj1.b.b(TAG, "handleUpdatePreferEvent: count[" + guildFeedUpdatePreferEvent.getPreferCount() + "] isClick[" + guildFeedUpdatePreferEvent.getPreferStatus() + "]");
        int preferCount = guildFeedUpdatePreferEvent.getPreferCount();
        this.mCurrentPreferCount = preferCount;
        setOperateShowNum(preferCount, this.mPreferNumTv);
        int preferStatus = guildFeedUpdatePreferEvent.getPreferStatus();
        this.mPreferStatus = preferStatus;
        if (preferStatus != 0) {
            if (preferStatus != 1) {
                if (preferStatus != 2) {
                    return;
                }
            } else {
                this.mUpVoteBtn.setImageDrawable(GuildUIUtils.w(getContext(), R.drawable.guild_feed_item_up_vote_icon_clicked_normal, Integer.valueOf(R.color.qui_common_feedback_error)));
                return;
            }
        }
        this.mUpVoteBtn.setImageDrawable(GuildUIUtils.w(getContext(), R.drawable.guild_feed_detail_up_vote_icon_selector, Integer.valueOf(R.color.qui_common_text_primary)));
    }

    private void handleUpdateCommentEvent(GuildFeedUpdateCommentsEvent guildFeedUpdateCommentsEvent) {
        hj1.b.b(TAG, "handleUpdateCommentEvent: count[" + guildFeedUpdateCommentsEvent.getList() + "]");
        int list = guildFeedUpdateCommentsEvent.getList();
        this.mCurrentCommentCount = list;
        setOperateShowNum(list, this.mCommentNumTv);
    }

    private void handleUpdateSharedChannelEvent(GuildFeedShareChannelEvent guildFeedShareChannelEvent) {
        int shareCount = this.mCurrentShareCount + guildFeedShareChannelEvent.getShareCount();
        this.mCurrentShareCount = shareCount;
        setOperateShowNum(shareCount, this.mShareNumTv);
    }

    private void handleUpdateSharedCountEvent(GuildFeedUpdateSharedCountEvent guildFeedUpdateSharedCountEvent) {
        hj1.b.b(TAG, "handleUpdateSharedCountEvent: count[" + guildFeedUpdateSharedCountEvent.getSharedCount() + "]");
        int sharedCount = guildFeedUpdateSharedCountEvent.getSharedCount();
        this.mCurrentShareCount = sharedCount;
        setOperateShowNum(sharedCount, this.mShareNumTv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initAnimationParams(AnimationParams animationParams) {
        int[] iArr = new int[2];
        this.contentView.getLocationOnScreen(iArr);
        float f16 = iArr[0];
        float f17 = iArr[1];
        float widthSource = animationParams.getWidthSource() / this.contentView.getWidth();
        this.startScaleX = widthSource;
        this.startScaleY = widthSource;
        this.startTranslationX = animationParams.getScreenX() - f16;
        this.startTranslationY = animationParams.getScreenY() - f17;
        this.startClipBounds = new Rect(0, (int) f17, this.contentView.getWidth(), (int) ((animationParams.getLimitHeight() / this.startScaleY) + f17));
        this.endClipBounds = new Rect(0, 0, this.contentView.getWidth(), this.contentView.getHeight());
        this.contentView.setPivotX(0.0f);
        this.contentView.setPivotY(f17);
    }

    private void initListener() {
        this.mCloseIcon.setOnClickListener(this);
        this.mIntPut.setOnClickListener(this);
        this.mDetailTopLayout.setOnClickListener(new c());
        this.mIntPut.setOnLongClickListener(new d());
        this.mIntPut.setFocusable(false);
        this.mIntPut.setFocusableInTouchMode(false);
        this.mIntPut.clearFocus();
        this.mDetailBottomLayout.setOnClickListener(this);
        this.mDetailBottomLayout.findViewById(R.id.e9l).setOnClickListener(this);
        this.mDetailBottomLayout.findViewById(R.id.f84364m2).setOnClickListener(this);
        this.mDetailBottomLayout.findViewById(R.id.b4g).setOnClickListener(this);
        this.mUpVoteClickedAnimView.addAnimatorListener(new e());
    }

    private void initOperateData() {
        GuildFeedBaseInitBean guildFeedBaseInitBean = this.mInitBean;
        if (guildFeedBaseInitBean instanceof GuildFeedDetailInitBean) {
            GuildFeedDetailInitBean guildFeedDetailInitBean = (GuildFeedDetailInitBean) guildFeedBaseInitBean;
            this.mCurrentCommentCount = guildFeedDetailInitBean.getCommentNum();
            this.mCurrentShareCount = guildFeedDetailInitBean.getShareNum();
            this.mCurrentPreferCount = guildFeedDetailInitBean.getPreferNum();
            this.mPreferStatus = guildFeedDetailInitBean.getPreferStatus();
            updateOperateData();
        }
    }

    @NonNull
    private wk1.a initializeGuideBarDependency() {
        return new FeedDetailWebPageGuideBarDependencyImpl(new Supplier() { // from class: com.tencent.mobileqq.guild.feed.detail.s
            @Override // androidx.core.util.Supplier
            public final Object get() {
                return GuildFeedDetailWebViewFragment.this.getInitBean();
            }
        }, new Supplier() { // from class: com.tencent.mobileqq.guild.feed.detail.t
            @Override // androidx.core.util.Supplier
            public final Object get() {
                LifecycleOwner lambda$initializeGuideBarDependency$2;
                lambda$initializeGuideBarDependency$2 = GuildFeedDetailWebViewFragment.this.lambda$initializeGuideBarDependency$2();
                return lambda$initializeGuideBarDependency$2;
            }
        });
    }

    private void initializeNavigatorUI() {
        if (!(this.mDetailBottomLayout instanceof ViewGroup)) {
            return;
        }
        NavigatorUI navigatorUI = new NavigatorUI(initializeGuideBarDependency());
        this.mNavigatorUI = navigatorUI;
        navigatorUI.init((ViewGroup) this.mDetailBottomLayout);
        this.mNavigatorUI.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$asyncCheckIfGuildInfoUpdateForGuest$13(boolean z16, NavigatorUI navigatorUI) {
        if (z16) {
            navigatorUI.f((short) 1);
        } else {
            navigatorUI.f((short) 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$asyncCheckIfGuildInfoUpdateForGuest$14(String str) {
        this.webView.callJs(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$asyncCheckIfGuildInfoUpdateForGuest$15(Bundle bundle) {
        this.mPermissionCalculator.n(bundle);
        this.mPermissionCalculator.o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$asyncCheckIfGuildInfoUpdateForGuest$16(boolean z16, EIPCResult eIPCResult) {
        boolean z17;
        if (!eIPCResult.isSuccess()) {
            QLog.e(TAG, 1, "tryCheckIfGuildInfoUpdateForGuest failed!");
            return;
        }
        if ((getActivity() != null && getActivity().isFinishing()) || this.mInitBean == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            QLog.e(TAG, 1, "isActivityFinishing. mInitBean: " + this.mInitBean);
            return;
        }
        final Bundle bundle = eIPCResult.data;
        final boolean z18 = bundle.getBoolean("attrs_is_member", this.mInitBean.isMember());
        QLog.d(TAG, 1, "from ipc isMember: " + z18 + ", mInitBean.isMember(): " + this.mInitBean.isMember());
        if (z18 != this.mInitBean.isMember()) {
            this.mInitBean.setIsMember(z18);
            ax.J(this.mNavigatorUI, new Consumer() { // from class: com.tencent.mobileqq.guild.feed.detail.h
                @Override // androidx.core.util.Consumer
                public final void accept(Object obj) {
                    GuildFeedDetailWebViewFragment.lambda$asyncCheckIfGuildInfoUpdateForGuest$13(z18, (NavigatorUI) obj);
                }
            });
            if (z16) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("guildId", this.mInitBean.getGuildId());
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
                final String jsScript = WebViewPlugin.toJsScript("guild_hybrid_join_guild", jSONObject, null);
                RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.detail.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        GuildFeedDetailWebViewFragment.this.lambda$asyncCheckIfGuildInfoUpdateForGuest$14(jsScript);
                    }
                });
            } else {
                QLog.w(TAG, 1, "don't needCallJs mIsPageFinish= " + this.mIsPageFinish);
            }
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.detail.j
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedDetailWebViewFragment.this.lambda$asyncCheckIfGuildInfoUpdateForGuest$15(bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$handleFinish$4() {
        super.finish();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleReceiveEvent$17(String str) {
        this.webView.callJs(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleReceiveEvent$18(String str) {
        this.webView.callJs(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initData$3(SpeakPermissionType speakPermissionType) {
        this.mFacade.d(speakPermissionType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$1(GuildFeedDetailInitBean guildFeedDetailInitBean) {
        if (guildFeedDetailInitBean.getBusinessType() == 7) {
            return;
        }
        initializeNavigatorUI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ LifecycleOwner lambda$initializeGuideBarDependency$2() {
        return getViewLifecycleOwnerLiveData().getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$new$0() {
        boolean z16;
        GuildFeedBaseInitBean guildFeedBaseInitBean = this.mInitBean;
        if (guildFeedBaseInitBean != null && guildFeedBaseInitBean.isMember()) {
            z16 = true;
        } else {
            z16 = false;
        }
        return Boolean.valueOf(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setDefaultPlaceholder$5(String str) {
        this.mFacade.h(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setDefaultPlaceholder$6() {
        this.mPermissionCalculator.o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showInputPopInner$10(GuildFeedDetailInitBean guildFeedDetailInitBean) {
        QLog.i(TAG, 1, "onInputPop dismiss");
        this.inputPop = null;
        if (com.tencent.mobileqq.guild.feed.widget.comment.d.f224303h.a(guildFeedDetailInitBean.getFeedId()) != null) {
            this.mIntPut.setText(getContext().getString(R.string.f143950ng));
        } else {
            this.mPermissionCalculator.o();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showInputPopWhenEnter$8() {
        final nj1.a createDefaultInputParams = createDefaultInputParams();
        ax.J(this.mFacade, new Consumer() { // from class: com.tencent.mobileqq.guild.feed.detail.p
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                ((pj1.a) obj).e(nj1.a.this);
            }
        });
    }

    private void manualReportClickEvent(String str, Map<String, Object> map, int i3) {
        String str2;
        if (map == null) {
            map = new HashMap<>();
        }
        GuildFeedBaseInitBean guildFeedBaseInitBean = this.mInitBean;
        if (guildFeedBaseInitBean == null) {
            return;
        }
        map.put("sgrp_channel_id", guildFeedBaseInitBean.getGuildId());
        map.put("sgrp_sub_channel_id", this.mInitBean.getChannelId());
        GuildFeedBaseInitBean guildFeedBaseInitBean2 = this.mInitBean;
        if (guildFeedBaseInitBean2 instanceof GuildFeedDetailInitBean) {
            map.put("sgrp_content_id", ((GuildFeedDetailInitBean) guildFeedBaseInitBean2).getFeedId());
            map.put("sgrp_content_type", Integer.valueOf(((GuildFeedDetailInitBean) this.mInitBean).getFeedType()));
        }
        map.put("eid", str);
        map.put("cur_pg", this.mDtReportParams);
        if ("em_sgrp_forum_comment".equals(str)) {
            map.put("sgrp_click_region", Integer.valueOf(i3));
        }
        if (this.mInitBean.isMember()) {
            str2 = "pg_sgrp_forumshared_joined";
        } else {
            str2 = "pg_sgrp_forumshared_notjoined";
        }
        map.put("dt_pgid", str2);
        VideoReport.reportEvent("dt_clck", map);
    }

    private void manualReportVoteClickEvent(String str, boolean z16) {
        int i3;
        int i16;
        HashMap hashMap = new HashMap();
        int i17 = 0;
        if (z16) {
            if (this.mPreferStatus == 1) {
                i16 = 1;
            } else {
                i16 = 0;
            }
            hashMap.put("sgrp_state", Integer.valueOf(i16));
            if (this.mPreferStatus == 1) {
                i17 = 1;
            }
            hashMap.put("sgrp_action_result", Integer.valueOf(i17));
        } else {
            if (this.mPreferStatus == 2) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            hashMap.put("sgrp_state", Integer.valueOf(i3));
            if (this.mPreferStatus == 2) {
                i17 = 1;
            }
            hashMap.put("sgrp_action_result", Integer.valueOf(i17));
        }
        manualReportClickEvent(str, hashMap, 2);
    }

    private void onClickHintTv() {
        final nj1.a createDefaultInputParams = createDefaultInputParams();
        ax.J(this.mFacade, new Consumer() { // from class: com.tencent.mobileqq.guild.feed.detail.l
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                ((pj1.a) obj).e(nj1.a.this);
            }
        });
    }

    private void pageDtReport() {
        int i3;
        String str;
        String str2;
        GuildFeedBaseInitBean guildFeedBaseInitBean = this.mInitBean;
        if (guildFeedBaseInitBean != null && this.contentView != null) {
            if (guildFeedBaseInitBean instanceof GuildFeedDetailInitBean) {
                i3 = ((GuildFeedDetailInitBean) guildFeedBaseInitBean).getFromPage();
                str = ((GuildFeedDetailInitBean) this.mInitBean).getPosterTinyId();
            } else {
                i3 = 4;
                str = "";
            }
            VideoReport.addToDetectionWhitelist((QBaseActivity) getActivity());
            if (this.mInitBean.isMember()) {
                str2 = "pg_sgrp_forumshared_joined";
            } else {
                str2 = "pg_sgrp_forumshared_notjoined";
            }
            VideoReport.setPageId(this.contentView, str2);
            VideoReport.setPageReportPolicy(this.contentView, PageReportPolicy.REPORT_NONE);
            HashMap hashMap = new HashMap();
            hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
            GuildFeedBaseInitBean guildFeedBaseInitBean2 = this.mInitBean;
            if (guildFeedBaseInitBean2 instanceof GuildFeedDetailInitBean) {
                hashMap.put("sgrp_content_id", ((GuildFeedDetailInitBean) guildFeedBaseInitBean2).getFeedId());
                hashMap.put("sgrp_content_type", Integer.valueOf(((GuildFeedDetailInitBean) this.mInitBean).getFeedType()));
            }
            hashMap.put("sgrp_channel_id", this.mInitBean.getGuildId());
            hashMap.put("sgrp_sub_channel_id", this.mInitBean.getChannelId());
            hashMap.put("sgrp_subchannel_type", String.valueOf(7));
            hashMap.put("sgrp_user_type", this.mInitBean.getUserType());
            hashMap.put("sgrp_forum_details_enter_source", Integer.valueOf(i3));
            hashMap.put("author_uin", str);
            hashMap.put("Platform", "Android");
            hashMap.put("aio_disappear_type", "0");
            Bundle bundle = new Bundle();
            bundle.putParcelable("GuildAppReportSourceInfo", getInitBean().getJumpExtraInfo());
            ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setOpenGuildSourceParams(bundle, hashMap);
            hashMap.putAll(com.tencent.mobileqq.guild.report.b.d());
            VideoReport.setPageParams(this.contentView, new PageParams(hashMap));
            this.mDtReportParams.putAll(hashMap);
            this.mDtReportParams.put("dt_pgid", str2);
            reportDtPageIn();
        }
    }

    private void reportDtPageIn() {
        Map<String, Object> map;
        if (this.contentView != null && (map = this.mDtReportParams) != null && !map.isEmpty() && !this.mHadReportPageIn) {
            QLog.i(TAG, 1, "reportDtPageIn:");
            VideoReport.reportEvent("pgin", this.contentView, this.mDtReportParams);
            this.mHadReportPageIn = true;
            this.mPageInTime = SystemClock.uptimeMillis();
        }
    }

    private void reportDtPageOut() {
        Map<String, Object> map;
        if (this.contentView != null && (map = this.mDtReportParams) != null && !map.isEmpty() && this.mHadReportPageIn) {
            QLog.i(TAG, 1, "reportDtPageOut:");
            this.mDtReportParams.put(DTParamKey.REPORT_KEY_LVTM, Long.valueOf(SystemClock.uptimeMillis() - this.mPageInTime));
            VideoReport.reportEvent("pgout", this.contentView, this.mDtReportParams);
            this.mPageInTime = 0L;
            this.mHadReportPageIn = false;
        }
    }

    private void sendJumpToCommentEvent() {
        SimpleEventBus.getInstance().dispatchEvent(new GuildFeedDetailClickCommentEvent(), false);
    }

    private void sendUpVoteEvent() {
        if (this.mPreferStatus != 1) {
            this.mPreferStatus = 1;
        } else {
            this.mPreferStatus = 3;
        }
        GuildFeedDetailClickPreferEvent guildFeedDetailClickPreferEvent = new GuildFeedDetailClickPreferEvent(this.mPreferStatus);
        hj1.b.a(TAG, "sendUpVoteEvent: " + this.mPreferStatus);
        if (this.mPreferStatus == 1) {
            this.mUpVoteBtn.setImageDrawable(GuildUIUtils.w(getContext(), R.drawable.guild_feed_item_up_vote_icon_clicked_normal, Integer.valueOf(R.color.qui_common_feedback_error)));
            this.mUpVoteClickedAnimView.setVisibility(0);
            this.mUpVoteBtn.setVisibility(4);
            this.mUpVoteClickedAnimView.playAnimation();
        } else {
            this.mUpVoteBtn.setImageDrawable(GuildUIUtils.w(getContext(), R.drawable.guild_feed_detail_up_vote_icon_selector, Integer.valueOf(R.color.qui_common_text_primary)));
        }
        SimpleEventBus.getInstance().dispatchEvent(guildFeedDetailClickPreferEvent, false);
        GuildFeedReportHelper.i().x(this.mPreferStatus);
    }

    private void setCloseIconLayoutParams() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mCloseIcon.getLayoutParams();
        layoutParams.width = dp2px(30.0f);
        layoutParams.height = dp2px(44.0f);
        layoutParams.gravity = 83;
        this.mCloseIcon.setLayoutParams(layoutParams);
        this.mCloseIcon.setPadding(dp2px(10.0f), dp2px(12.0f), 0, dp2px(12.0f));
    }

    private void setDetailBottomLtVisibility(boolean z16) {
        int i3;
        View view = this.mDetailBottomLayout;
        if (view == null) {
            return;
        }
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
        if (z16) {
            VideoReport.traversePage(this.mDetailBottomLayout);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOperateShowNum(int i3, TextView textView) {
        String e16 = bl1.b.f28597a.e(i3);
        if (e16.isEmpty()) {
            int zeroHintByViewId = getZeroHintByViewId(textView);
            if (zeroHintByViewId != 0) {
                textView.setText(zeroHintByViewId);
                return;
            }
            return;
        }
        textView.setText(e16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showInputPopInner(nj1.a aVar, final GuildFeedDetailInitBean guildFeedDetailInitBean) {
        QLog.i(TAG, 1, String.format("showInputPopInner params=%s", aVar.toString()));
        ej1.e eVar = this.inputPop;
        if (eVar != null) {
            eVar.dismiss();
        }
        this.inputPop = GuildWebFeedCommentFragment.INSTANCE.a(this, aVar, guildFeedDetailInitBean, new GuildWebFeedCommentFragment.b() { // from class: com.tencent.mobileqq.guild.feed.detail.q
            @Override // com.tencent.mobileqq.guild.feed.comment.fragment.GuildWebFeedCommentFragment.b
            public final void onDismiss() {
                GuildFeedDetailWebViewFragment.this.lambda$showInputPopInner$10(guildFeedDetailInitBean);
            }
        });
    }

    private void showSharePanel() {
        GuildFeedDetailClickShareEvent guildFeedDetailClickShareEvent = new GuildFeedDetailClickShareEvent();
        guildFeedDetailClickShareEvent.mHashCode = hashCode();
        SimpleEventBus.getInstance().dispatchEvent(guildFeedDetailClickShareEvent, false);
    }

    private void tryCheckIfGuildInfoUpdateForGuest(final boolean z16) {
        QLog.d(TAG, 1, "tryCheckIfGuildInfoUpdateForGuest");
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.detail.c
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedDetailWebViewFragment.this.lambda$tryCheckIfGuildInfoUpdateForGuest$12(z16);
            }
        });
    }

    private void updateOperateData() {
        setOperateShowNum(this.mCurrentCommentCount, this.mCommentNumTv);
        setOperateShowNum(this.mCurrentShareCount, this.mShareNumTv);
        setOperateShowNum(this.mCurrentPreferCount, this.mPreferNumTv);
        ImageView imageView = this.mShareBtn;
        Context context = getContext();
        Integer valueOf = Integer.valueOf(R.color.qui_common_text_primary);
        imageView.setImageDrawable(GuildUIUtils.w(context, R.drawable.guild_feed_detail_share_icon_selector, valueOf));
        this.mCommentBtn.setImageDrawable(GuildUIUtils.w(getContext(), R.drawable.guild_feed_detail_comment_icon_selector, valueOf));
        int i3 = this.mPreferStatus;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return;
                }
            } else {
                this.mUpVoteBtn.setImageDrawable(GuildUIUtils.w(getContext(), R.drawable.guild_feed_item_up_vote_icon_clicked_normal, Integer.valueOf(R.color.qui_common_feedback_error)));
                return;
            }
        }
        this.mUpVoteBtn.setImageDrawable(GuildUIUtils.w(getContext(), R.drawable.guild_feed_detail_up_vote_icon_selector, valueOf));
    }

    @Override // com.tencent.mobileqq.guild.feed.fragment.GuildFeedBaseWebViewFragment
    protected void addEventClass(ArrayList arrayList) {
        super.addEventClass(arrayList);
        arrayList.add(GuildFeedUpdateCommentsEvent.class);
        arrayList.add(GuildFeedUpdatePreferEvent.class);
        arrayList.add(GuildFeedUpdateSharedCountEvent.class);
        arrayList.add(GuildFeedShareChannelEvent.class);
        arrayList.add(CommentStatusEvent.class);
        arrayList.add(NotifySendingCommentsEvent.class);
        arrayList.add(GuildFeedGalleryFirstPagerEvent.class);
        arrayList.add(JoinGuildLogic.JoinGuildResultEvent.class);
    }

    @Override // com.tencent.mobileqq.guild.feed.fragment.GuildFeedBaseWebViewFragment, pk1.b
    public boolean available() {
        return super.available();
    }

    @Override // lj1.a
    public void deleteLocalCache() {
        GuildFeedDetailInitBean initBean = getInitBean();
        if (initBean == null) {
            QLog.e(TAG, 1, "deleteLocalCache: init bean is null");
            return;
        }
        String feedId = initBean.getFeedId();
        if (TextUtils.isEmpty(feedId)) {
            QLog.e(TAG, 1, "deleteLocalCache: feedId is null");
        } else {
            GuildFeedDetailDataCacheManager.y().k(feedId);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        ej1.e eVar;
        super.doOnActivityResult(i3, i16, intent);
        QLog.d(TAG, 1, "doOnActivityResult requestCode=" + i3);
        if ((i3 == 10014 || i3 == 10000) && (eVar = this.inputPop) != null) {
            eVar.getFragment().onActivityResult(i3, i16, intent);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webview.swift.WebViewProvider
    public void doOnBackEvent() {
        if (handleBackEvent()) {
            return;
        }
        handleFinish();
    }

    @Override // com.tencent.mobileqq.guild.feed.fragment.GuildFeedBaseWebViewFragment, lj1.a
    public void finish() {
        handleFinish();
    }

    @Override // com.tencent.mobileqq.guild.feed.fragment.GuildFeedBaseWebViewFragment
    @ColorInt
    protected int getBackgroundColorId() {
        if (getContext() != null) {
            return ((IQQGuildUIUtilApi) QRoute.api(IQQGuildUIUtilApi.class)).getColor(getContext(), R.color.qui_common_bg_bottom_light);
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.guild.feed.fragment.GuildFeedBaseWebViewFragment
    @ColorInt
    protected int getBackgroundNightColorId() {
        if (getContext() != null) {
            return ((IQQGuildUIUtilApi) QRoute.api(IQQGuildUIUtilApi.class)).getColor(getContext(), R.color.qui_common_bg_bottom_light);
        }
        return 0;
    }

    @Override // lj1.a
    public GuildFeedBaseInitBean getDetailInitBean() {
        return this.mInitBean;
    }

    @Override // lj1.a
    public FeedInteractiveData getFeedInteractiveData() {
        return new FeedInteractiveData(this.mPreferStatus, this.mCurrentPreferCount, this.mCurrentCommentCount, this.mCurrentShareCount);
    }

    @Override // lj1.a
    public Bitmap getScreenBitmap() {
        if (getHostActivity() != null && getHostActivity().getWindow() != null && getHostActivity().getWindow().getDecorView() != null) {
            View decorView = getHostActivity().getWindow().getDecorView();
            decorView.destroyDrawingCache();
            if (!decorView.isDrawingCacheEnabled()) {
                decorView.setDrawingCacheEnabled(true);
            }
            decorView.buildDrawingCache();
            return decorView.getDrawingCache();
        }
        QLog.e(TAG, 1, "get decorView error for null");
        return null;
    }

    @Override // com.tencent.mobileqq.guild.feed.fragment.GuildFeedBaseWebViewFragment
    protected void handleMuteChangeEvent(GuildFeedMuteStateChangeEvent guildFeedMuteStateChangeEvent) {
        super.handleMuteChangeEvent(guildFeedMuteStateChangeEvent);
        GuildFeedBaseInitBean guildFeedBaseInitBean = this.mInitBean;
        if (guildFeedBaseInitBean != null && guildFeedMuteStateChangeEvent.guildId.equals(guildFeedBaseInitBean.getGuildId()) && guildFeedMuteStateChangeEvent.channelId.equals(this.mInitBean.getChannelId())) {
            if (TextUtils.isEmpty(this.mInitBean.getChannelId())) {
                QLog.e(TAG, 1, "handleMuteChangeEvent: initBean is error.");
                return;
            }
            QLog.e(TAG, 1, "handleMuteChangeEvent: event[" + guildFeedMuteStateChangeEvent);
            this.mPermissionCalculator.k(guildFeedMuteStateChangeEvent);
            this.mPermissionCalculator.o();
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.fragment.GuildFeedBaseWebViewFragment
    protected void handleReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.handleReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof GuildFeedUpdateCommentsEvent) {
            handleUpdateCommentEvent((GuildFeedUpdateCommentsEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof GuildFeedUpdatePreferEvent) {
            handleUpdatPreferEvent((GuildFeedUpdatePreferEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof GuildFeedUpdateSharedCountEvent) {
            handleUpdateSharedCountEvent((GuildFeedUpdateSharedCountEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof GuildFeedShareChannelEvent) {
            handleUpdateSharedChannelEvent((GuildFeedShareChannelEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof CommentStatusEvent) {
            String result = ((CommentStatusEvent) simpleBaseEvent).getResult();
            hj1.b.a(TAG, "ReceiveEvent CommentStatusEvent: " + result);
            g gVar = this.mOtherFeedCommentCallback;
            if (gVar != null) {
                gVar.onResult(result);
            } else {
                g gVar2 = this.mCommentCallBack;
                if (gVar2 != null) {
                    gVar2.onResult(result);
                }
            }
            GuildFeedReportHelper.i().w(result);
            return;
        }
        if (simpleBaseEvent instanceof NotifySendingCommentsEvent) {
            String results = ((NotifySendingCommentsEvent) simpleBaseEvent).getResults();
            hj1.b.a(TAG, "ReceiveEvent NotifySendingCommentsEvent: " + results);
            f fVar = this.mRecoverCommentCallback;
            if (fVar != null) {
                fVar.onResult(results);
                return;
            }
            return;
        }
        if (simpleBaseEvent instanceof GuildFeedDetailCacheRespEvent) {
            handleFeedDetailCacheResp(simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof JoinGuildLogic.JoinGuildResultEvent) {
            GuildFeedBaseInitBean guildFeedBaseInitBean = this.mInitBean;
            if (guildFeedBaseInitBean != null && Objects.equals(guildFeedBaseInitBean.getGuildId(), ((JoinGuildLogic.JoinGuildResultEvent) simpleBaseEvent).getGuildId())) {
                tryCheckIfGuildInfoUpdateForGuest(true);
                return;
            }
            return;
        }
        if (simpleBaseEvent instanceof GuildFeedGalleryFirstPagerEvent) {
            GuildFeedGalleryFirstPagerEvent guildFeedGalleryFirstPagerEvent = (GuildFeedGalleryFirstPagerEvent) simpleBaseEvent;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("curMediaIndex", guildFeedGalleryFirstPagerEvent.getFirstPos());
                jSONObject.put("firstFeedId", guildFeedGalleryFirstPagerEvent.getFirstFeedId());
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            final String jsScript = WebViewPlugin.toJsScript("guild_hybrid_cur_media_index", jSONObject, null);
            RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.detail.d
                @Override // java.lang.Runnable
                public final void run() {
                    GuildFeedDetailWebViewFragment.this.lambda$handleReceiveEvent$17(jsScript);
                }
            });
            return;
        }
        if (simpleBaseEvent instanceof GuildFeedDeleteEvent) {
            GuildFeedDeleteEvent guildFeedDeleteEvent = (GuildFeedDeleteEvent) simpleBaseEvent;
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("guildId", guildFeedDeleteEvent.getGuildId());
            } catch (JSONException e17) {
                e17.printStackTrace();
            }
            final String jsScript2 = WebViewPlugin.toJsScript("guild_hybrid_delete", jSONObject2, null);
            RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.detail.e
                @Override // java.lang.Runnable
                public final void run() {
                    GuildFeedDetailWebViewFragment.this.lambda$handleReceiveEvent$18(jsScript2);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.fragment.GuildFeedBaseWebViewFragment
    protected void handleSpeakThresholdChangeEvent(GuildSpeakThresholdStateChangeEvent guildSpeakThresholdStateChangeEvent) {
        super.handleSpeakThresholdChangeEvent(guildSpeakThresholdStateChangeEvent);
        GuildFeedBaseInitBean guildFeedBaseInitBean = this.mInitBean;
        if (guildFeedBaseInitBean != null && guildSpeakThresholdStateChangeEvent.mGuildId.equals(guildFeedBaseInitBean.getGuildId()) && guildSpeakThresholdStateChangeEvent.mChannelId.equals(this.mInitBean.getChannelId())) {
            if (TextUtils.isEmpty(this.mInitBean.getChannelId())) {
                QLog.e(TAG, 1, "handleSpeakThresholdChangeEvent: initBean is error.");
            } else {
                this.mPermissionCalculator.m(guildSpeakThresholdStateChangeEvent);
                this.mPermissionCalculator.o();
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.fragment.GuildFeedBaseWebViewFragment
    protected void initData() {
        GuildFeedBaseInitBean guildFeedBaseInitBean = this.mInitBean;
        if (guildFeedBaseInitBean != null && !TextUtils.isEmpty(guildFeedBaseInitBean.getGuildId()) && !TextUtils.isEmpty(this.mInitBean.getChannelId())) {
            initOperateData();
            if (getSwiftTitleUI() != null) {
                getSwiftTitleUI().M.setVisibility(8);
            }
            elementDtExposeReport();
            this.mFacade = new pj1.a(this.mIntPut, new b());
            this.mPermissionCalculator.j(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.guild.feed.detail.u
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    GuildFeedDetailWebViewFragment.this.lambda$initData$3((SpeakPermissionType) obj);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.fragment.GuildFeedBaseWebViewFragment
    protected void initView() {
        this.mDecimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        getContentView().c().setClipChildren(false);
        this.mDetailTopLayout = LayoutInflater.from(getContext()).inflate(R.layout.enm, (ViewGroup) null);
        this.mDetailBottomLayout = LayoutInflater.from(getContext()).inflate(R.layout.f0x, (ViewGroup) null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, ImmersiveUtils.getStatusBarHeight(getHostActivity()) + dp2px(44.0f));
        layoutParams.gravity = 51;
        getContentView().c().addView(this.mDetailTopLayout, layoutParams);
        ImageView imageView = (ImageView) this.mDetailTopLayout.findViewById(R.id.w8l);
        this.mCloseIcon = imageView;
        imageView.setImageDrawable(GuildUIUtils.w(getContext(), R.drawable.guild_skin_left_arrow, Integer.valueOf(R.color.qui_common_icon_primary)));
        setCloseIconLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, getResource().getDimensionPixelSize(R.dimen.ce8));
        layoutParams2.gravity = 80;
        getContentView().c().addView(this.mDetailBottomLayout, layoutParams2);
        this.mIntPut = (TextView) this.mDetailBottomLayout.findViewById(R.id.u1l);
        this.mCommentBtn = (ImageView) this.mDetailBottomLayout.findViewById(R.id.b4f);
        this.mShareBtn = (ImageView) this.mDetailBottomLayout.findViewById(R.id.f84344m0);
        this.mCommentNumTv = (TextView) this.mDetailBottomLayout.findViewById(R.id.f164861b54);
        this.mShareNumTv = (TextView) this.mDetailBottomLayout.findViewById(R.id.f84514mg);
        this.mShareContainer = this.mDetailBottomLayout.findViewById(R.id.f84364m2);
        this.mPreferNumTv = (TextView) this.mDetailBottomLayout.findViewById(R.id.e9q);
        this.mUpVoteBtn = (ImageView) this.mDetailBottomLayout.findViewById(R.id.e9k);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) this.mDetailBottomLayout.findViewById(R.id.yi5);
        this.mUpVoteClickedAnimView = lottieAnimationView;
        lottieAnimationView.setAnimation("feed/feed_item/feed_native_detail_like_anim.json");
        this.mUpVoteClickedAnimView.setVisibility(4);
        au.f223851a.n(this.mUpVoteClickedAnimView, getResources().getColor(R.color.qui_common_text_primary));
        GuildFeedDetailInitBean initBean = getInitBean();
        if (initBean != null && initBean.getBusinessType() == 7) {
            this.mShareContainer.setVisibility(8);
            supportAt(false);
        } else {
            this.mShareContainer.setVisibility(0);
        }
        initListener();
        pageDtReport();
        ax.J(initBean, new Consumer() { // from class: com.tencent.mobileqq.guild.feed.detail.k
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                GuildFeedDetailWebViewFragment.this.lambda$initView$1((GuildFeedDetailInitBean) obj);
            }
        });
    }

    @Override // lj1.a
    public boolean isNativeEmojiClick() {
        return mIsNativeEmoji;
    }

    @Override // lj1.a
    public void jumpNativePublish(String str, String str2, String str3, String str4, int i3, String str5, int i16, GuildFeedReportSourceInfo guildFeedReportSourceInfo) {
        em1.a.d(getActivity(), str, str2, str3, str4, i3, str5, i16, guildFeedReportSourceInfo);
    }

    @Override // lj1.a
    public void jumpPublish(GuildFeedPublishEditPostInitBean guildFeedPublishEditPostInitBean) {
        GuildFeedLauncher.C(getActivity(), guildFeedPublishEditPostInitBean);
    }

    @Override // lj1.a
    public void jumpUserSummary(String str, String str2, String str3, int i3, String str4, String str5, FeedImpeachData feedImpeachData) {
        if (!((IGuildFastClickUtilApi) QRoute.api(IGuildFastClickUtilApi.class)).isFastClick("GuildFeedDetailWebViewFragment_jumpUserSummary")) {
            Bundle bundle = new Bundle();
            if (i3 == 1) {
                bundle.putString("key_uin", str4);
                bundle.putString("key_troop_id", str5);
                QIPCClientHelper.getInstance().callServer(IGuildIPCService.GUILD_NAME_IPC_NAME, "sync_show_troop_user_card", bundle);
            } else {
                bundle.putString("key_guild_id", str);
                bundle.putString("key_channel_id", str2);
                bundle.putString("key_tiny_id", str3);
                bundle.putSerializable("impeachData", feedImpeachData);
                QIPCClientHelper.getInstance().callServer(IGuildIPCService.GUILD_NAME_IPC_NAME, "sync_show_guild_user_card", bundle);
            }
        }
    }

    @Override // lj1.a
    public void noteUserWriteOrStay(String str, String str2, String str3) {
        if (!str3.equals("comment") && !str3.equals("reply")) {
            Bundle bundle = new Bundle();
            bundle.putString("key_guild_id", str);
            bundle.putString("key_channel_id", str2);
            bundle.putInt("key_channel_type", 7);
            QIPCClientHelper.getInstance().callServer(IGuildIPCService.GUILD_NAME_IPC_NAME, "sync_note_user_write_or_stay", bundle);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        GuildFeedDetailCostTimeViewDebug.c().d(this);
        if (getHostActivity() != null && getHostActivity().getWindow() != null) {
            QLog.i(TAG, 4, "setSoftInputMode ADJUST_NOTHING");
            getHostActivity().getWindow().setSoftInputMode(48);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        super.onClick(view);
        if (!((IGuildFastClickUtilApi) QRoute.api(IGuildFastClickUtilApi.class)).isFastClick("GuildFeedDetailWebViewFragment_popwindow")) {
            if (view.getId() != R.id.w8l && view.getId() != R.id.wf9) {
                if (view.getId() == R.id.u1l) {
                    manualReportClickEvent("em_sgrp_forum_comment", null, 1);
                    onClickHintTv();
                } else if (view.getId() == R.id.b4g) {
                    manualReportClickEvent("em_sgrp_forum_comment", null, 2);
                    sendJumpToCommentEvent();
                } else if (view.getId() == R.id.f84364m2) {
                    manualReportClickEvent("em_sgrp_forum_share", null, 2);
                    showSharePanel();
                } else if (view.getId() == R.id.e9l) {
                    manualReportVoteClickEvent("em_sgrp_forum_up", true);
                    sendUpVoteEvent();
                }
            } else {
                finish();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.guild.feed.fragment.GuildFeedBaseWebViewFragment, com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        if (getActivity() != null) {
            GuildFeedBaseInitBean guildFeedBaseInitBean = this.mInitBean;
            if ((guildFeedBaseInitBean instanceof GuildFeedDetailInitBean) && ((GuildFeedDetailInitBean) guildFeedBaseInitBean).getAnimationParams() != null) {
                getActivity().overridePendingTransition(0, 0);
                onCreateView.getViewTreeObserver().addOnPreDrawListener(new a(onCreateView));
            }
        }
        if (getActivity() != null) {
            QUIImmersiveHelper.s(getActivity(), false, true);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // com.tencent.mobileqq.guild.feed.fragment.GuildFeedBaseWebViewFragment, com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ej1.e eVar = this.inputPop;
        if (eVar != null) {
            eVar.dismiss();
        }
        this.inputPop = null;
        com.tencent.mobileqq.guild.feed.widget.comment.d.f224303h.d();
    }

    @Override // com.tencent.mobileqq.guild.feed.fragment.GuildFeedBaseWebViewFragment, com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        boolean z16;
        GuildFeedBaseInitBean guildFeedBaseInitBean;
        super.onPause();
        if (getActivity() != null && getActivity().isFinishing()) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.i(TAG, 1, "onPause, isActivityFinishing " + z16 + ", mInitBean: " + this.mInitBean);
        if (z16 && (guildFeedBaseInitBean = this.mInitBean) != null) {
            bl.c().b(new GuildDetailViewDestroyEvent(((GuildFeedDetailInitBean) guildFeedBaseInitBean).getFeedId(), this.mCurrentCommentCount, this.mCurrentPreferCount, this.mPreferStatus, this.mCurrentShareCount), true);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.fragment.GuildFeedBaseWebViewFragment, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof GuildDetailViewDestroyEvent) {
            GuildDetailViewDestroyEvent guildDetailViewDestroyEvent = (GuildDetailViewDestroyEvent) simpleBaseEvent;
            if (!guildDetailViewDestroyEvent.getFeedId().equals(getInitBean().getFeedId())) {
                return;
            }
            this.mCurrentCommentCount = guildDetailViewDestroyEvent.getCommentCount();
            this.mCurrentPreferCount = guildDetailViewDestroyEvent.getPreferCount();
            this.mCurrentShareCount = guildDetailViewDestroyEvent.getShareCount();
            this.mPreferStatus = guildDetailViewDestroyEvent.getPreferStatus();
            updateOperateData();
            return;
        }
        if (simpleBaseEvent instanceof GuildFeedDetailLikeEvent) {
            GuildFeedDetailLikeEvent guildFeedDetailLikeEvent = (GuildFeedDetailLikeEvent) simpleBaseEvent;
            QLog.e(TAG, 1, "event.getFromWeb() = " + guildFeedDetailLikeEvent.getFromWeb() + " , mPreferStatus = " + this.mPreferStatus);
            if (guildFeedDetailLikeEvent.getFromWeb() && this.mPreferStatus != 1) {
                sendUpVoteEvent();
            }
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.mInitBean == null) {
            finish();
            return;
        }
        QLog.d(TAG, 1, "[onResume], isMember: " + this.mInitBean.isMember() + ", mIsPageFinish: " + this.mIsPageFinish);
        tryCheckIfGuildInfoUpdateForGuest(this.mIsPageFinish);
        GuildFeedDetailDataCacheManager.y().F(getInitBean().getFeedId(), getInitBean().getLastModifiedTime());
        reportDtPageIn();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        callToJs(false);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        reportDtPageOut();
        callToJs(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (getUIStyleHandler() != null) {
            getUIStyleHandler().f314499a0 = true;
        }
    }

    @Override // lj1.a
    public void recoverComment4Web(f fVar) {
        this.mRecoverCommentCallback = fVar;
        bl.c().b(new FindUnfinishedCommentEvent(getInitBean().getGuildId(), getInitBean().getChannelId(), getInitBean().getFeedId()), true);
    }

    @Override // lj1.a
    public void setDefaultPlaceholder(String str) {
        if (str == null) {
            QLog.e(TAG, 1, "setDefaultPlaceholder == null");
            return;
        }
        QLog.i(TAG, 1, "setDefaultPlaceholder placeholder=" + str);
        if (TextUtils.isEmpty(str)) {
            str = requireContext().getString(R.string.f144480ow);
        }
        bl1.b.f28597a.b(this.mIntPut, str, 12, 0, new Consumer() { // from class: com.tencent.mobileqq.guild.feed.detail.n
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                GuildFeedDetailWebViewFragment.this.lambda$setDefaultPlaceholder$5((String) obj);
            }
        });
        this.mIntPut.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.detail.o
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedDetailWebViewFragment.this.lambda$setDefaultPlaceholder$6();
            }
        });
    }

    @Override // lj1.a
    public void setFeedCacheCallback(g gVar) {
        this.mFeedCacheCallback = gVar;
    }

    @Override // lj1.a
    public void setNativeEmojiClick(boolean z16) {
        mIsNativeEmoji = z16;
    }

    @Override // lj1.a
    public void setSendCommentCallBack(g gVar) {
        this.mCommentCallBack = gVar;
    }

    @Override // lj1.a
    public void setSendOtherFeedCommentCallBack(g gVar) {
        this.mOtherFeedCommentCallback = gVar;
    }

    @Override // lj1.a
    public void showEmoji(boolean z16) {
        if (z16) {
            handleEmoji();
        }
    }

    @Override // lj1.a
    public void showGuildHashtag() {
        handleChannelSelectShow();
    }

    @Override // lj1.a
    public void showInputPop(final nj1.a aVar) {
        QLog.i(TAG, 1, "showReplyInputPop");
        ax.J(this.mFacade, new Consumer() { // from class: com.tencent.mobileqq.guild.feed.detail.f
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                ((pj1.a) obj).e(nj1.a.this);
            }
        });
    }

    @Override // lj1.a
    public void showInputPopForRecommendFeed(bj1.a aVar, String str, int i3) {
        if (((IGuildFastClickUtilApi) QRoute.api(IGuildFastClickUtilApi.class)).isFastClick("GuildFeedDetailWebViewFragment_PopWindows")) {
            return;
        }
        QLog.i(TAG, 1, "showInputPopForRecommendFeed");
        nj1.a aVar2 = new nj1.a(i3, false, "", aVar.getFeedCreateTime(), "", "", "", 0, 2, str, this.configParams.getSupportAt(), "");
        GuildFeedDetailInitBean guildFeedDetailInitBean = new GuildFeedDetailInitBean();
        guildFeedDetailInitBean.setFeedId(aVar.getFeedId());
        guildFeedDetailInitBean.setGuildId(aVar.getGuildId());
        guildFeedDetailInitBean.setChannelId(aVar.getChannelId());
        showInputPopInner(aVar2, guildFeedDetailInitBean);
    }

    public void showInputPopWhenEnter(boolean z16) {
        QLog.i(TAG, 1, "showInputPopWhenEnter, isShow=" + z16);
        if (z16) {
            getMainHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.detail.m
                @Override // java.lang.Runnable
                public final void run() {
                    GuildFeedDetailWebViewFragment.this.lambda$showInputPopWhenEnter$8();
                }
            }, 80L);
            return;
        }
        ej1.e eVar = this.inputPop;
        if (eVar != null) {
            eVar.dismiss();
        }
    }

    @Override // lj1.a
    public void showMoveHashtagEmptyToastMsg() {
        QQToastUtil.showQQToast(R.string.f143960nh);
    }

    @Override // lj1.a
    public void showShare(Context context, GuildFeedArkShareInfo guildFeedArkShareInfo) {
        QLog.e(TAG, 1, "showShare error");
    }

    @Override // lj1.a
    public void supportAt(boolean z16) {
        QLog.i(TAG, 1, "supportAt enable=" + z16);
        this.configParams.e(z16);
    }

    @Override // lj1.a
    public void updateBottomBarVisible(boolean z16) {
        setDetailBottomLtVisibility(z16);
    }

    @Override // lj1.a
    public void updateGuildFeedInfo(String str, String str2, String str3) {
        GuildFeedDetailInitBean initBean = getInitBean();
        if (initBean == null) {
            QLog.e(TAG, 1, "updateGuildFeedInfo: init bean is null");
            return;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, initBean.getGuildId())) {
            QLog.e(TAG, 1, "updateGuildFeedInfo: update guildId before[" + initBean.getGuildId() + "] after[" + str + "]");
            initBean.setGuildId(str);
        }
        if (!TextUtils.isEmpty(str2) && !TextUtils.equals(str2, initBean.getChannelId())) {
            QLog.e(TAG, 1, "updateGuildFeedInfo: update channelId before[" + initBean.getChannelId() + "] after[" + str2 + "]");
            initBean.setChannelId(str2);
        }
        if (!TextUtils.isEmpty(str3) && !TextUtils.equals(str3, initBean.getFeedId())) {
            QLog.e(TAG, 1, "updateGuildFeedInfo: update feedId before[" + initBean.getFeedId() + "] after[" + str3 + "]");
            initBean.setFeedId(str3);
        }
    }

    @Override // lj1.a
    public void updateWebParams(FeedWebDetailParams feedWebDetailParams) {
        QLog.i(TAG, 1, "updateWebParams");
        this.configParams = feedWebDetailParams;
    }

    @Override // pk1.b
    public GuildFeedDetailInitBean getInitBean() {
        return (GuildFeedDetailInitBean) this.mInitBean;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class e implements Animator.AnimatorListener {
        e() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            hj1.b.b(GuildFeedDetailWebViewFragment.TAG, "mUpVoteClickedAnimView onAnimationEnd: " + GuildFeedDetailWebViewFragment.this.mPreferStatus);
            GuildFeedDetailWebViewFragment.this.mUpVoteClickedAnimView.setVisibility(4);
            GuildFeedDetailWebViewFragment.this.mUpVoteBtn.setVisibility(0);
            GuildFeedDetailWebViewFragment.this.mPreferNumTv.setVisibility(0);
            GuildFeedDetailWebViewFragment guildFeedDetailWebViewFragment = GuildFeedDetailWebViewFragment.this;
            guildFeedDetailWebViewFragment.setOperateShowNum(guildFeedDetailWebViewFragment.mCurrentPreferCount, GuildFeedDetailWebViewFragment.this.mPreferNumTv);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            hj1.b.b(GuildFeedDetailWebViewFragment.TAG, "mUpVoteClickedAnimView onAnimationStart: " + GuildFeedDetailWebViewFragment.this.mPreferStatus);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    @Override // lj1.a
    public void supportPic(boolean z16) {
    }
}

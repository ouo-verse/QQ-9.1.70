package com.tencent.mobileqq.guild.feed.nativedetail.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.Part;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.data.v;
import com.tencent.mobileqq.guild.feed.event.GuildFeedDetailViewDestroyEvent;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.BottomInteractivePart;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.NativeInteractiveCooperateMediator;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.SpeakPermissionPart;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.InputSendPart;
import com.tencent.mobileqq.guild.feed.nativedetail.content.part.CommentFunctionPart;
import com.tencent.mobileqq.guild.feed.nativedetail.content.part.ContentDataFusionPart;
import com.tencent.mobileqq.guild.feed.nativedetail.content.part.FeedTipPart;
import com.tencent.mobileqq.guild.feed.nativedetail.content.part.PageAnimPart;
import com.tencent.mobileqq.guild.feed.nativedetail.content.part.PreloadContentPart;
import com.tencent.mobileqq.guild.feed.nativedetail.content.part.StartIntentResolvePart;
import com.tencent.mobileqq.guild.feed.nativedetail.content.part.ad;
import com.tencent.mobileqq.guild.feed.nativedetail.content.part.ae;
import com.tencent.mobileqq.guild.feed.nativedetail.content.part.af;
import com.tencent.mobileqq.guild.feed.nativedetail.content.part.i;
import com.tencent.mobileqq.guild.feed.nativedetail.content.part.j;
import com.tencent.mobileqq.guild.feed.nativedetail.content.part.s;
import com.tencent.mobileqq.guild.feed.nativedetail.content.part.t;
import com.tencent.mobileqq.guild.feed.nativedetail.title.TitlePart;
import com.tencent.mobileqq.guild.feed.widget.comment.GuildFeedDetailCommentDraftManager;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pad.d;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wk1.c;
import wk1.h;
import yl1.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J(\u0010\r\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\tj\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b`\fH\u0002J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0014J\u001a\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0007H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001b\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0019H\u0016J\b\u0010\u001d\u001a\u00020\u0019H\u0016R\u001b\u0010#\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/fragment/FeedNativeDetailFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Lcom/tencent/mobileqq/pad/d;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/interactive/BottomInteractivePart;", "sh", "Landroid/view/View;", "contentView", "", "qh", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "uh", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "onResume", "", "getContentLayoutId", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onDestroyView", "", "needStatusTrans", "needImmersive", "shouldDispatchActivityResult", "shouldDispatchPostThemeChanged", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/part/CommentFunctionPart;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "th", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/content/part/CommentFunctionPart;", "commentFunPart", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedNativeDetailFragment extends QPublicBaseFragment implements d {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy commentFunPart;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/fragment/FeedNativeDetailFragment$a", "Lwk1/d;", "Lwk1/h;", "inputContext", "Lwk1/c;", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements wk1.d {
        a() {
        }

        @Override // wk1.d
        @NotNull
        public c a(@NotNull h inputContext) {
            Intrinsics.checkNotNullParameter(inputContext, "inputContext");
            return new NativeInteractiveCooperateMediator(FeedNativeDetailFragment.this, inputContext);
        }
    }

    public FeedNativeDetailFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<CommentFunctionPart>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.fragment.FeedNativeDetailFragment$commentFunPart$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CommentFunctionPart invoke() {
                return new CommentFunctionPart(n.n(GuildSplitViewUtils.f235370a.h(FeedNativeDetailFragment.this)));
            }
        });
        this.commentFunPart = lazy;
    }

    private final void qh(View contentView) {
        Bundle bundle;
        Intent intent;
        VideoReport.addToDetectionWhitelist(requireActivity());
        VideoReport.setPageId(contentView, "pg_sgrp_forum_detail");
        VideoReport.setPageReportPolicy(contentView, PageReportPolicy.REPORT_ALL);
        VideoReport.setPageParams(contentView, new PageParams(uh()));
        final WeakReference weakReference = new WeakReference(this);
        VideoReport.setEventDynamicParams(contentView, new IDynamicParams() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.fragment.a
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map rh5;
                rh5 = FeedNativeDetailFragment.rh(weakReference, str);
                return rh5;
            }
        });
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            bundle = intent.getExtras();
        } else {
            bundle = null;
        }
        qw1.b.c(bundle, JumpGuildParam.EXTRA_JUMP_REPORT_TASK).duplicate(new String[0]).setStageCode("stage_jump_feed_detail_show").report();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map rh(WeakReference weakRef, String str) {
        CommentFunctionPart commentFunctionPart;
        int i3;
        long j3;
        Map mapOf;
        Intrinsics.checkNotNullParameter(weakRef, "$weakRef");
        FeedNativeDetailFragment feedNativeDetailFragment = (FeedNativeDetailFragment) weakRef.get();
        if (feedNativeDetailFragment != null) {
            commentFunctionPart = feedNativeDetailFragment.th();
        } else {
            commentFunctionPart = null;
        }
        Pair[] pairArr = new Pair[2];
        if (commentFunctionPart != null) {
            i3 = commentFunctionPart.z3();
        } else {
            i3 = 0;
        }
        pairArr[0] = TuplesKt.to("sgrp_forum_comment_region_imp_number", Integer.valueOf(i3));
        if (commentFunctionPart != null) {
            j3 = commentFunctionPart.Z9();
        } else {
            j3 = 0;
        }
        pairArr[1] = TuplesKt.to("sgrp_forum_comment_region_lvtm", Long.valueOf(j3));
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        return mapOf;
    }

    private final BottomInteractivePart sh() {
        return new BottomInteractivePart(new a());
    }

    private final CommentFunctionPart th() {
        return (CommentFunctionPart) this.commentFunPart.getValue();
    }

    private final HashMap<String, Object> uh() {
        boolean isBlank;
        Bundle h16 = GuildSplitViewUtils.f235370a.h(this);
        String str = "";
        String string = h16.getString("guild_id", "");
        String string2 = h16.getString("feed_id", "");
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("sgrp_channel_id", string);
        hashMap.put("sgrp_sub_channel_id", h16.getString("channel_id", ""));
        hashMap.put("sgrp_user_type", Integer.valueOf(v.c(string)));
        hashMap.put("sgrp_channel_invite_code", h16.getString("inviteCode", ""));
        hashMap.put("sgrp_content_id", string2);
        hashMap.put("sgrp_feed_id", string2);
        hashMap.put(JumpGuildParam.EXTRA_KEY_TRACE_ID, h16.getString("trace_Id", ""));
        yl1.a.a(hashMap, h16);
        hashMap.putAll(com.tencent.mobileqq.guild.report.b.d());
        String string3 = h16.getString("sgrp_channel_extension_info", "");
        if (string3 != null) {
            str = string3;
        }
        isBlank = StringsKt__StringsJVMKt.isBlank(str);
        if (!isBlank) {
            hashMap.put("sgrp_channel_extension_info", str);
        }
        QLog.d(QPublicBaseFragment.TAG, 4, "searchExtension " + str);
        return hashMap;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new ym1.a(0, 1, null), new TitlePart(), new j(), new s(new hl1.c()), th(), new i(), sh(), new com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.c(new GuildFeedDetailCommentDraftManager(this), null, null, false, 14, null), new SpeakPermissionPart(), new InputSendPart(), new wl1.a(), new ContentDataFusionPart(false, 1, null), new PreloadContentPart(), new FeedTipPart(), new StartIntentResolvePart(), new ae(), new PageAnimPart(), new ad(), new t(), new af());
        return mutableListOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.end;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Bundle arguments = getArguments();
        if (arguments != null) {
            GuildFeedDetailViewDestroyEvent guildFeedDetailViewDestroyEvent = new GuildFeedDetailViewDestroyEvent();
            guildFeedDetailViewDestroyEvent.setBusinessType(arguments.getInt("business_type", 0));
            String string = arguments.getString("sgrp_channel_extension_info", "");
            Intrinsics.checkNotNullExpressionValue(string, "it.getString(\n          \u2026     \"\"\n                )");
            guildFeedDetailViewDestroyEvent.setChannelExtensionInfo(string);
            String string2 = arguments.getString("param_key_search_extension_info", "");
            Intrinsics.checkNotNullExpressionValue(string2, "it.getString(\n          \u2026     \"\"\n                )");
            guildFeedDetailViewDestroyEvent.setSearchExtensionInfo(string2);
            SimpleEventBus.getInstance().dispatchEvent(guildFeedDetailViewDestroyEvent);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        QQSysAndEmojiResMgr.getInstance().refreshConfig();
        AbstractGifImage.resumeAll();
        try {
            ApngImage.resumeAll();
        } catch (Exception e16) {
            QLog.e(QPublicBaseFragment.TAG, 1, "onResume exception: " + e16.getMessage());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        qh(view);
        GuildSplitViewUtils.f235370a.B(view);
    }

    @Override // com.tencent.mobileqq.pad.d
    public boolean shouldDispatchActivityResult() {
        return true;
    }

    @Override // com.tencent.mobileqq.pad.d
    public boolean shouldDispatchPostThemeChanged() {
        return false;
    }
}

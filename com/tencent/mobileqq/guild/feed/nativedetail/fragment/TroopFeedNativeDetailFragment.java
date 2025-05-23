package com.tencent.mobileqq.guild.feed.nativedetail.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.part.Part;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.data.v;
import com.tencent.mobileqq.guild.feed.manager.GuildInfoManager;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.ReplyCommentArgs;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.BottomInteractivePart;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.NativeInteractiveCooperateMediator;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.i;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.InputSendPart;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.commentfeed.CommentFeedRequestArgs;
import com.tencent.mobileqq.guild.feed.nativedetail.content.part.CommentFunctionPart;
import com.tencent.mobileqq.guild.feed.nativedetail.content.part.ContentDataFusionPart;
import com.tencent.mobileqq.guild.feed.nativedetail.content.part.FeedTipPart;
import com.tencent.mobileqq.guild.feed.nativedetail.content.part.PageAnimPart;
import com.tencent.mobileqq.guild.feed.nativedetail.content.part.PreloadContentPart;
import com.tencent.mobileqq.guild.feed.nativedetail.content.part.StartIntentResolvePart;
import com.tencent.mobileqq.guild.feed.nativedetail.content.part.ae;
import com.tencent.mobileqq.guild.feed.nativedetail.content.part.af;
import com.tencent.mobileqq.guild.feed.nativedetail.content.part.j;
import com.tencent.mobileqq.guild.feed.nativedetail.content.part.s;
import com.tencent.mobileqq.guild.feed.nativedetail.content.part.t;
import com.tencent.mobileqq.guild.feed.nativedetail.title.TroopFeedTitlePart;
import com.tencent.mobileqq.guild.feed.util.bi;
import com.tencent.mobileqq.guild.feed.widget.comment.GuildFeedDetailCommentDraftManager;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.pad.d;
import com.tencent.mobileqq.proavatar.api.IProAvatarUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStIconInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStUser;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wk1.c;
import wk1.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J(\u0010\u000f\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000bj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r`\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\fH\u0002J\n\u0010\u0015\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\u0016\u001a\u00020\fH\u0002J\b\u0010\u0017\u001a\u00020\fH\u0002J\b\u0010\u0018\u001a\u00020\fH\u0002J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0016J\b\u0010\u001c\u001a\u00020\tH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0014J\u001a\u0010!\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010#\u001a\u00020\"H\u0016J\b\u0010$\u001a\u00020\"H\u0016J\b\u0010%\u001a\u00020\"H\u0016J\b\u0010&\u001a\u00020\"H\u0016R\u001b\u0010,\u001a\u00020'8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/fragment/TroopFeedNativeDetailFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Lcom/tencent/mobileqq/pad/d;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/InputSendPart;", OcrConfig.CHINESE, "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/interactive/BottomInteractivePart;", "vh", "Landroid/view/View;", "contentView", "", "th", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "yh", "Landroid/os/Bundle;", "bundle", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/part/CommentFunctionPart$a$a;", "xh", "Bh", "Ah", "Dh", "getChannelId", "Ch", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "onResume", "", "getContentLayoutId", "view", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "needStatusTrans", "needImmersive", "shouldDispatchActivityResult", "shouldDispatchPostThemeChanged", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/part/CommentFunctionPart;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "wh", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/content/part/CommentFunctionPart;", "commentFunPart", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class TroopFeedNativeDetailFragment extends QPublicBaseFragment implements d {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy commentFunPart;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/fragment/TroopFeedNativeDetailFragment$a", "Lwk1/d;", "Lwk1/h;", "inputContext", "Lwk1/c;", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements wk1.d {
        a() {
        }

        @Override // wk1.d
        @NotNull
        public c a(@NotNull h inputContext) {
            Intrinsics.checkNotNullParameter(inputContext, "inputContext");
            return new NativeInteractiveCooperateMediator(null, inputContext, 1, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\tH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/fragment/TroopFeedNativeDetailFragment$b", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/c;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStUser;", ITVKPlayerEventListener.KEY_USER_INFO, "", "c", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/send/commentfeed/c;", "args", "b", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/h;", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.c {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.c
        public void a(@NotNull ReplyCommentArgs args) {
            Intrinsics.checkNotNullParameter(args, "args");
            args.g(bi.a());
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.c
        public void b(@NotNull CommentFeedRequestArgs args) {
            Intrinsics.checkNotNullParameter(args, "args");
            args.g(bi.a());
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.send.c
        public void c(@NotNull GProStUser userInfo) {
            Intrinsics.checkNotNullParameter(userInfo, "userInfo");
            userInfo.nick = TroopFeedNativeDetailFragment.this.Bh();
            GProStIconInfo gProStIconInfo = userInfo.icon;
            String Ah = TroopFeedNativeDetailFragment.this.Ah();
            if (Ah == null) {
                Ah = "";
            }
            gProStIconInfo.iconUrl = Ah;
            userInfo.icon.avatarMeta = new byte[0];
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                String currentAccountUin = peekAppRuntime.getCurrentAccountUin();
                Intrinsics.checkNotNullExpressionValue(currentAccountUin, "it.currentAccountUin");
                userInfo.uin = MiscKt.l(currentAccountUin);
            }
        }
    }

    public TroopFeedNativeDetailFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<CommentFunctionPart>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.fragment.TroopFeedNativeDetailFragment$commentFunPart$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CommentFunctionPart invoke() {
                CommentFunctionPart.Companion.CommentInitArgs xh5;
                TroopFeedNativeDetailFragment troopFeedNativeDetailFragment = TroopFeedNativeDetailFragment.this;
                xh5 = troopFeedNativeDetailFragment.xh(GuildSplitViewUtils.f235370a.h(troopFeedNativeDetailFragment));
                return new CommentFunctionPart(xh5);
            }
        });
        this.commentFunPart = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String Ah() {
        String str;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        return com.tencent.mobileqq.proavatar.utils.d.f259720a.a(((IProAvatarUtilsApi) QRoute.api(IProAvatarUtilsApi.class)).getAvatarInfo(1, str), 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String Bh() {
        String str;
        String p16;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
        IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
        Intrinsics.checkNotNullExpressionValue(uid, "uid");
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = iFriendsInfoService.getFriendsSimpleInfoWithUid(uid, QPublicBaseFragment.TAG);
        if (friendsSimpleInfoWithUid != null && !TextUtils.isEmpty(friendsSimpleInfoWithUid.p()) && (p16 = friendsSimpleInfoWithUid.p()) != null) {
            return p16;
        }
        return str;
    }

    private final String Ch() {
        String string = GuildSplitViewUtils.f235370a.h(this).getString("FEED_TROOP_ROLE");
        if (string == null) {
            return "";
        }
        return string;
    }

    private final String Dh() {
        String string = GuildSplitViewUtils.f235370a.h(this).getString("FEED_TROOP_UIN");
        if (string == null) {
            return "";
        }
        return string;
    }

    private final String getChannelId() {
        String string = GuildSplitViewUtils.f235370a.h(this).getString("channel_id");
        if (string == null) {
            return "";
        }
        return string;
    }

    private final void th(View contentView) {
        VideoReport.addToDetectionWhitelist(requireActivity());
        VideoReport.setPageId(contentView, "pg_group_forum_detail");
        VideoReport.setPageReportPolicy(contentView, PageReportPolicy.REPORT_ALL);
        VideoReport.setPageParams(contentView, new PageParams(yh()));
        VideoReport.setEventDynamicParams(contentView, new IDynamicParams() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.fragment.b
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map uh5;
                uh5 = TroopFeedNativeDetailFragment.uh(TroopFeedNativeDetailFragment.this, str);
                return uh5;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map uh(TroopFeedNativeDetailFragment this$0, String str) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("sgrp_forum_comment_region_imp_number", Integer.valueOf(this$0.wh().z3())), TuplesKt.to("sgrp_forum_comment_region_lvtm", Long.valueOf(this$0.wh().Z9())));
        return mapOf;
    }

    private final BottomInteractivePart vh() {
        return new i(new a());
    }

    private final CommentFunctionPart wh() {
        return (CommentFunctionPart) this.commentFunPart.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CommentFunctionPart.Companion.CommentInitArgs xh(Bundle bundle) {
        String str;
        String str2;
        String str3;
        String string = bundle.getString("feed_id");
        if (string == null) {
            str = "";
        } else {
            str = string;
        }
        String string2 = bundle.getString("guild_id");
        if (string2 == null) {
            str2 = "";
        } else {
            str2 = string2;
        }
        String string3 = bundle.getString("channel_id");
        if (string3 == null) {
            str3 = "";
        } else {
            str3 = string3;
        }
        return new CommentFunctionPart.Companion.CommentInitArgs(str2, str3, str, Dh(), false);
    }

    private final HashMap<String, Object> yh() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        boolean isBlank;
        Bundle h16 = GuildSplitViewUtils.f235370a.h(this);
        String str6 = null;
        String str7 = "";
        if (h16 != null) {
            str = h16.getString("guild_id", "");
        } else {
            str = null;
        }
        if (h16 != null) {
            str2 = h16.getString("feed_id", "");
        } else {
            str2 = null;
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("sgrp_channel_id", str);
        if (h16 != null) {
            str3 = h16.getString("channel_id", "");
        } else {
            str3 = null;
        }
        hashMap.put("sgrp_sub_channel_id", str3);
        hashMap.put("sgrp_user_type", Integer.valueOf(v.c(str)));
        if (h16 != null) {
            str4 = h16.getString("inviteCode", "");
        } else {
            str4 = null;
        }
        hashMap.put("sgrp_channel_invite_code", str4);
        hashMap.put("sgrp_content_id", str2);
        hashMap.put("sgrp_feed_id", str2);
        if (h16 != null) {
            str5 = h16.getString("trace_Id", "");
        } else {
            str5 = null;
        }
        hashMap.put(JumpGuildParam.EXTRA_KEY_TRACE_ID, str5);
        hashMap.put("group_id", Dh());
        hashMap.put("group_uin_type", Ch());
        if (h16 != null) {
            str6 = h16.getString("sgrp_channel_extension_info", "");
        }
        if (str6 != null) {
            str7 = str6;
        }
        isBlank = StringsKt__StringsJVMKt.isBlank(str7);
        if (!isBlank) {
            hashMap.put("sgrp_channel_extension_info", str7);
        }
        QLog.d(QPublicBaseFragment.TAG, 4, "getDTParams " + str7);
        yl1.a.a(hashMap, h16);
        hashMap.putAll(com.tencent.mobileqq.guild.report.b.d());
        return hashMap;
    }

    private final InputSendPart zh() {
        InputSendPart inputSendPart = new InputSendPart();
        inputSendPart.ca(new b());
        return inputSendPart;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new ym1.a(0, 1, null), new TroopFeedTitlePart(Dh()), new j(), new s(new hl1.h()), wh(), new com.tencent.mobileqq.guild.feed.nativedetail.content.part.i(), vh(), new com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.c(new GuildFeedDetailCommentDraftManager(this), null, null, false, 14, null), new com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.b(Dh()), zh(), new wl1.a(), new ContentDataFusionPart(false), new PreloadContentPart(), new FeedTipPart(), new StartIntentResolvePart(), new ae(), new PageAnimPart(), new t(), new af());
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
        th(view);
        GuildInfoManager.q().h(getChannelId(), Dh());
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

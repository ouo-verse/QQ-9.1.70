package com.tencent.mobileqq.guild.feed.part.notice;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.guild.api.IGuildRoleGroupApi;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.InputFunctionType;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.NativeDetailInputWindowDirector;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.ReplyCommentArgs;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.ShowInputComponentArgs;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor.SendButtonActor;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.b;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.SpeakPermissionType;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a;
import com.tencent.mobileqq.guild.feed.nativepublish.utils.GuildFeedPublishUtils;
import com.tencent.mobileqq.guild.feed.util.l;
import com.tencent.mobileqq.guild.feed.widget.comment.GuildFeedDetailCommentDraftManager;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqnt.kernel.api.o;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStComment;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStCommonExt;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoLikeReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoLikeRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStEmojiReaction;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStEmotionReactionInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStLike;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStNotice;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStReply;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProDoLikeCallback;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import ui1.g;
import yl1.i;
import yl1.n;

@Metadata(d1 = {"\u0000\u00b0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0007\n\u0002\b\n*\u0002Y`\u0018\u0000 f2\u00020\u00012\u00020\u0002:\u0002ghB\u0007\u00a2\u0006\u0004\bd\u0010eJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010\t\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0002J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\u001c\u0010\u001a\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u001d\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0010H\u0016J\u0012\u0010\"\u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\"\u0010'\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\n2\b\u0010&\u001a\u0004\u0018\u00010%H\u0016J*\u0010/\u001a\u00020\u00072\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020*2\b\u0010-\u001a\u0004\u0018\u00010,2\u0006\u0010.\u001a\u00020\u0003H\u0016J4\u00105\u001a\u00020\u00072\u0006\u0010)\u001a\u00020(2\u0006\u00100\u001a\u00020*2\b\u00101\u001a\u0004\u0018\u00010,2\u0006\u00102\u001a\u00020\n2\b\u00104\u001a\u0004\u0018\u000103H\u0016J \u00108\u001a\u00020\u00072\u0006\u00107\u001a\u0002062\u0006\u0010+\u001a\u00020*2\b\u0010-\u001a\u0004\u0018\u00010,J\u001e\u00109\u001a\u0004\u0018\u00010\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016R\u0016\u0010<\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010>\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u0010;R\u0016\u0010@\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010;R\u0016\u0010C\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010F\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010J\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0014\u0010N\u001a\u00020K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010Q\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010U\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010X\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010\\\u001a\u00020Y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010_\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u0014\u0010c\u001a\u00020`8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\ba\u0010b\u00a8\u0006i"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/part/notice/GuildFeedNoticeCommentPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/mobileqq/guild/feed/part/notice/f;", "", "M9", "", "args", "", "L9", "K9", "", "bottomInteractiveViewHeight", "N9", "Lcom/tencent/mobileqq/guild/feed/widget/comment/GuildFeedDetailCommentDraftManager;", "I9", "F9", "Landroid/view/View;", "view", "Landroid/graphics/Bitmap;", "D9", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStEmotionReactionInfo;", "E9", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/utils/a$h;", "J9", "", "action", "handleBroadcastMessage", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStNotice;", "mStNotice", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStComment;", "comment", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStReply;", "reply", "isGuildNotice", "e6", "commentData", "replyData", "likeStatus", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProDoLikeCallback;", "cb", "l8", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "H9", "getMessage", "d", "Ljava/lang/String;", "feedId", "e", "guildId", "f", "channelId", h.F, "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStNotice;", "stNotice", "i", "Landroid/view/View;", "bottomInteractiveView", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector;", "inputDirector", "Landroid/graphics/Canvas;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/graphics/Canvas;", "canvasForCapture", "D", "Landroid/graphics/Bitmap;", "cacheBitmap", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/i;", "E", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/i;", "inputParam", UserInfo.SEX_FEMALE, "Z", "isInGuildNotice", "com/tencent/mobileqq/guild/feed/part/notice/GuildFeedNoticeCommentPart$e", "G", "Lcom/tencent/mobileqq/guild/feed/part/notice/GuildFeedNoticeCommentPart$e;", "sendCallback", "H", "Lcom/tencent/mobileqq/guild/feed/widget/comment/GuildFeedDetailCommentDraftManager;", "draftManager", "com/tencent/mobileqq/guild/feed/part/notice/GuildFeedNoticeCommentPart$d", "I", "Lcom/tencent/mobileqq/guild/feed/part/notice/GuildFeedNoticeCommentPart$d;", "dismissCallback", "<init>", "()V", "J", "a", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedNoticeCommentPart extends Part implements f {

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Bitmap cacheBitmap;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private ShowInputComponentArgs inputParam;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isInGuildNotice;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private GuildFeedDetailCommentDraftManager draftManager;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String feedId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String guildId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String channelId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private GProStNotice stNotice;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View bottomInteractiveView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private NativeDetailInputWindowDirector inputDirector;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Canvas canvasForCapture = new Canvas();

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private e sendCallback = new e();

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final d dismissCallback = new d();

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u001e\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0017\u0010\u000b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\nR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\b\u001a\u0004\b\u0010\u0010\nR\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/part/notice/GuildFeedNoticeCommentPart$b;", "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "", "event", "", "", "getDynamicParams", "a", "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "guildId", "b", "getChannelId", "channelId", "c", "getFeedId", "feedId", "", "d", "I", "getType", "()I", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String guildId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String channelId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String feedId;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int type;

        public b(@NotNull String guildId, @NotNull String channelId, @NotNull String feedId, int i3) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(feedId, "feedId");
            this.guildId = guildId;
            this.channelId = channelId;
            this.feedId = feedId;
            this.type = i3;
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        @NotNull
        public Map<String, Object> getDynamicParams(@Nullable String event) {
            Map<String, Object> mapOf;
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("sgrp_sub_channel_id", this.channelId), TuplesKt.to("sgrp_channel_id", this.guildId), TuplesKt.to("sgrp_feed_id", this.feedId), TuplesKt.to("sgrp_msg_type", Integer.valueOf(this.type)));
            return mapOf;
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f222584a;

        static {
            int[] iArr = new int[SpeakPermissionType.values().length];
            try {
                iArr[SpeakPermissionType.PERMISSION_TYPE_ALL_MUTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SpeakPermissionType.PERMISSION_TYPE_SELF_MUTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f222584a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/feed/part/notice/GuildFeedNoticeCommentPart$d", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$d;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$InputBarDismissCause;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d implements NativeDetailInputWindowDirector.d {
        d() {
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.NativeDetailInputWindowDirector.d
        public void a(@NotNull NativeDetailInputWindowDirector.InputBarDismissCause cause) {
            Intrinsics.checkNotNullParameter(cause, "cause");
            QLog.i("GuildFeedNoticeCommentPart", 1, "OnDismissListener");
            GuildFeedNoticeCommentPart guildFeedNoticeCommentPart = GuildFeedNoticeCommentPart.this;
            guildFeedNoticeCommentPart.broadcastMessage("message_update_hint_when_dismiss", Boolean.valueOf(guildFeedNoticeCommentPart.M9()));
        }
    }

    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JI\u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a2\u0006\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/guild/feed/part/notice/GuildFeedNoticeCommentPart$e", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/b;", "", "content", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/i;", "inputArgs", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Lkotlin/collections/ArrayList;", AEEditorConstants.KEY_WINK_LOCAL_MEDIA_INFOS, "", "originalPic", "", "b", "(Ljava/lang/String;Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/i;Ljava/util/ArrayList;Ljava/lang/Boolean;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class e implements com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.b {
        e() {
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.b
        public boolean a(@NotNull Intent intent) {
            return b.a.a(this, intent);
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0019, code lost:
        
            if (r0 == false) goto L15;
         */
        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void b(@Nullable String content, @Nullable ShowInputComponentArgs inputArgs, @Nullable ArrayList<LocalMediaInfo> localMediaInfos, @Nullable Boolean originalPic) {
            boolean z16;
            boolean z17 = false;
            if (content != null && content.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                if (localMediaInfos == null || localMediaInfos.isEmpty()) {
                    z17 = true;
                }
            }
            if (inputArgs != null) {
                GuildFeedNoticeCommentPart.this.broadcastMessage("message_try_to_send_input_content", new a.TryToSendInputContentMessage(true, inputArgs, content, null, localMediaInfos, originalPic, 8, null));
                NativeDetailInputWindowDirector nativeDetailInputWindowDirector = GuildFeedNoticeCommentPart.this.inputDirector;
                if (nativeDetailInputWindowDirector != null) {
                    nativeDetailInputWindowDirector.l();
                    return;
                }
                return;
            }
            QLog.e("GuildFeedNoticeCommentPart", 1, "sendCallback invoke args error!");
        }
    }

    private final Bitmap D9(View view) {
        Object m476constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            if (this.cacheBitmap == null) {
                Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
                this.cacheBitmap = createBitmap;
                this.canvasForCapture.setBitmap(createBitmap);
            }
            view.draw(this.canvasForCapture);
            m476constructorimpl = Result.m476constructorimpl(this.cacheBitmap);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (Result.m482isFailureimpl(m476constructorimpl)) {
            m476constructorimpl = null;
        }
        return (Bitmap) m476constructorimpl;
    }

    private final GProStEmotionReactionInfo E9() {
        GProStEmotionReactionInfo gProStEmotionReactionInfo = new GProStEmotionReactionInfo();
        ArrayList<GProStEmojiReaction> arrayList = gProStEmotionReactionInfo.emojiReactionList;
        GProStEmojiReaction gProStEmojiReaction = new GProStEmojiReaction();
        gProStEmojiReaction.emojiId = "271";
        gProStEmojiReaction.emojiType = 1L;
        arrayList.add(gProStEmojiReaction);
        return gProStEmotionReactionInfo;
    }

    private final void F9() {
        this.draftManager = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(IPerformanceReportTask reportTask, IGProDoLikeCallback iGProDoLikeCallback, int i3, String str, boolean z16, GProStDoLikeRsp gProStDoLikeRsp) {
        Intrinsics.checkNotNullParameter(reportTask, "$reportTask");
        com.tencent.mobileqq.guild.feed.report.c.E(com.tencent.mobileqq.guild.feed.report.c.f223280a, reportTask, i3, str, false, 8, null);
        if (iGProDoLikeCallback != null) {
            iGProDoLikeCallback.onResult(i3, str, z16, gProStDoLikeRsp);
        }
    }

    private final GuildFeedDetailCommentDraftManager I9() {
        if (this.draftManager == null) {
            LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
            this.draftManager = new GuildFeedDetailCommentDraftManager(lifecycleOwner);
        }
        GuildFeedDetailCommentDraftManager guildFeedDetailCommentDraftManager = this.draftManager;
        Intrinsics.checkNotNull(guildFeedDetailCommentDraftManager);
        return guildFeedDetailCommentDraftManager;
    }

    private final a.OnCommentMainFeedDataResult J9() {
        String str;
        String str2;
        String str3;
        GProStNotice gProStNotice = null;
        a.OnCommentMainFeedDataResult onCommentMainFeedDataResult = new a.OnCommentMainFeedDataResult(null, 1, null);
        String str4 = this.guildId;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildId");
            str = null;
        } else {
            str = str4;
        }
        String str5 = this.channelId;
        if (str5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelId");
            str2 = null;
        } else {
            str2 = str5;
        }
        String str6 = this.feedId;
        if (str6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedId");
            str3 = null;
        } else {
            str3 = str6;
        }
        GProStNotice gProStNotice2 = this.stNotice;
        if (gProStNotice2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stNotice");
            gProStNotice2 = null;
        }
        long j3 = gProStNotice2.origineFeed.createTime;
        GProStNotice gProStNotice3 = this.stNotice;
        if (gProStNotice3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stNotice");
        } else {
            gProStNotice = gProStNotice3;
        }
        String str7 = gProStNotice.origineFeed.poster.idd;
        Intrinsics.checkNotNullExpressionValue(str7, "stNotice.origineFeed.poster.idd");
        onCommentMainFeedDataResult.b(new a.CommentMainFeedData(str, str2, str3, j3, str7));
        return onCommentMainFeedDataResult;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void K9(Object args) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        boolean z16;
        String str;
        View view;
        View view2;
        View view3;
        if (!(args instanceof a.ShowInputComponentMessage)) {
            QLog.e("GuildFeedNoticeCommentPart", 1, "handleShowInputComponentMessage args error!");
            return;
        }
        a.ShowInputComponentMessage showInputComponentMessage = (a.ShowInputComponentMessage) args;
        this.inputParam = showInputComponentMessage.getInputArgs();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        View view4 = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        } else {
            iRuntimeService = null;
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            String str2 = this.guildId;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildId");
                str2 = null;
            }
            IGProGuildInfo guildInfo = iGPSService.getGuildInfo(str2);
            if (guildInfo != null) {
                z16 = guildInfo.isMember();
                str = this.feedId;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feedId");
                    str = null;
                }
                QLog.i("GuildFeedNoticeCommentPart", 1, "showInputComponent isMember = " + z16 + " feedId = " + str);
                view = this.bottomInteractiveView;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomInteractiveView");
                    view = null;
                }
                N9(view.getHeight());
                NativeDetailInputWindowDirector nativeDetailInputWindowDirector = this.inputDirector;
                Intrinsics.checkNotNull(nativeDetailInputWindowDirector);
                view2 = this.bottomInteractiveView;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomInteractiveView");
                    view2 = null;
                }
                nativeDetailInputWindowDirector.t(view2.getHeight());
                nativeDetailInputWindowDirector.s(z16);
                view3 = this.bottomInteractiveView;
                if (view3 != null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomInteractiveView");
                } else {
                    view4 = view3;
                }
                nativeDetailInputWindowDirector.w(D9(view4));
                nativeDetailInputWindowDirector.u(showInputComponentMessage.getInputArgs());
                nativeDetailInputWindowDirector.v(z16);
            }
        }
        z16 = false;
        str = this.feedId;
        if (str == null) {
        }
        QLog.i("GuildFeedNoticeCommentPart", 1, "showInputComponent isMember = " + z16 + " feedId = " + str);
        view = this.bottomInteractiveView;
        if (view == null) {
        }
        N9(view.getHeight());
        NativeDetailInputWindowDirector nativeDetailInputWindowDirector2 = this.inputDirector;
        Intrinsics.checkNotNull(nativeDetailInputWindowDirector2);
        view2 = this.bottomInteractiveView;
        if (view2 == null) {
        }
        nativeDetailInputWindowDirector2.t(view2.getHeight());
        nativeDetailInputWindowDirector2.s(z16);
        view3 = this.bottomInteractiveView;
        if (view3 != null) {
        }
        nativeDetailInputWindowDirector2.w(D9(view4));
        nativeDetailInputWindowDirector2.u(showInputComponentMessage.getInputArgs());
        nativeDetailInputWindowDirector2.v(z16);
    }

    private final void L9(Object args) {
        NativeDetailInputWindowDirector nativeDetailInputWindowDirector;
        if (!(args instanceof a.OnSpeakPermissionChangedMessage)) {
            QLog.e("GuildFeedNoticeCommentPart", 1, "handleSpeakPermissionChangedMessage args error!");
            return;
        }
        int i3 = c.f222584a[((a.OnSpeakPermissionChangedMessage) args).getNewSpeakPermission().ordinal()];
        if ((i3 == 1 || i3 == 2) && (nativeDetailInputWindowDirector = this.inputDirector) != null) {
            nativeDetailInputWindowDirector.r();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean M9() {
        GuildFeedDetailCommentDraftManager guildFeedDetailCommentDraftManager = this.draftManager;
        LocalMediaInfo localMediaInfo = null;
        String str = null;
        if (guildFeedDetailCommentDraftManager != null) {
            String str2 = this.feedId;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedId");
            } else {
                str = str2;
            }
            localMediaInfo = guildFeedDetailCommentDraftManager.a(str);
        }
        if (localMediaInfo != null) {
            return true;
        }
        return false;
    }

    private final void N9(int bottomInteractiveViewHeight) {
        NativeDetailInputWindowDirector nativeDetailInputWindowDirector = this.inputDirector;
        String str = null;
        GProStNotice gProStNotice = null;
        if (nativeDetailInputWindowDirector == null) {
            NativeDetailInputWindowDirector nativeDetailInputWindowDirector2 = new NativeDetailInputWindowDirector();
            Bundle f16 = nativeDetailInputWindowDirector2.f();
            String str2 = this.guildId;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildId");
                str2 = null;
            }
            f16.putString("guild_id", str2);
            String str3 = this.channelId;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelId");
                str3 = null;
            }
            f16.putString("channel_id", str3);
            String str4 = this.feedId;
            if (str4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedId");
                str4 = null;
            }
            f16.putString("feed_id", str4);
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            nativeDetailInputWindowDirector2.i(context);
            nativeDetailInputWindowDirector2.t(bottomInteractiveViewHeight);
            Object b16 = nativeDetailInputWindowDirector2.getRouter().b(SendButtonActor.class);
            Intrinsics.checkNotNull(b16);
            ((SendButtonActor) b16).l(this.sendCallback);
            Object b17 = nativeDetailInputWindowDirector2.getRouter().b(com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor.d.class);
            Intrinsics.checkNotNull(b17);
            ((com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor.d) b17).l(I9());
            nativeDetailInputWindowDirector2.m(this.dismissCallback);
            ShowInputComponentArgs showInputComponentArgs = this.inputParam;
            if (showInputComponentArgs != null) {
                showInputComponentArgs.getInvokeFrom();
            }
            gl1.b reporter = nativeDetailInputWindowDirector2.getReporter();
            if (reporter != null) {
                String str5 = this.guildId;
                if (str5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("guildId");
                    str5 = null;
                }
                String str6 = this.channelId;
                if (str6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("channelId");
                    str6 = null;
                }
                String str7 = this.feedId;
                if (str7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("feedId");
                    str7 = null;
                }
                GProStNotice gProStNotice2 = this.stNotice;
                if (gProStNotice2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("stNotice");
                } else {
                    gProStNotice = gProStNotice2;
                }
                reporter.b(new b(str5, str6, str7, gProStNotice.datongType));
            }
            this.inputDirector = nativeDetailInputWindowDirector2;
            return;
        }
        if (nativeDetailInputWindowDirector != null) {
            Bundle f17 = nativeDetailInputWindowDirector.f();
            String str8 = this.guildId;
            if (str8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildId");
                str8 = null;
            }
            f17.putString("guild_id", str8);
            String str9 = this.channelId;
            if (str9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelId");
                str9 = null;
            }
            f17.putString("channel_id", str9);
            String str10 = this.feedId;
            if (str10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedId");
            } else {
                str = str10;
            }
            f17.putString("feed_id", str);
        }
    }

    public final void H9(@NotNull IGProGuildInfo guildInfo, @NotNull GProStComment comment, @Nullable GProStReply reply) {
        Intrinsics.checkNotNullParameter(guildInfo, "guildInfo");
        Intrinsics.checkNotNullParameter(comment, "comment");
        int i3 = 1;
        if (!guildInfo.isMember() && !((IGuildRoleGroupApi) QRoute.api(IGuildRoleGroupApi.class)).getIsVisitorOperate(guildInfo, 1)) {
            n.z(0, R.string.f158261p5);
            return;
        }
        GuildFeedPublishUtils guildFeedPublishUtils = GuildFeedPublishUtils.f222315a;
        Function1<SpeakPermissionType, Unit> function1 = new Function1<SpeakPermissionType, Unit>() { // from class: com.tencent.mobileqq.guild.feed.part.notice.GuildFeedNoticeCommentPart$doReply$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SpeakPermissionType speakPermissionType) {
                invoke2(speakPermissionType);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull SpeakPermissionType it) {
                String str;
                Intrinsics.checkNotNullParameter(it, "it");
                GuildFeedPublishUtils guildFeedPublishUtils2 = GuildFeedPublishUtils.f222315a;
                Activity hostActivity = GuildFeedNoticeCommentPart.this.getPartHost().getHostActivity();
                str = GuildFeedNoticeCommentPart.this.guildId;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("guildId");
                    str = null;
                }
                guildFeedPublishUtils2.D(hostActivity, str, it);
            }
        };
        String str = this.guildId;
        String str2 = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildId");
            str = null;
        }
        String str3 = this.channelId;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelId");
            str3 = null;
        }
        if (!guildFeedPublishUtils.k(function1, str, str3)) {
            String str4 = this.guildId;
            if (str4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildId");
                str4 = null;
            }
            String str5 = this.channelId;
            if (str5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelId");
            } else {
                str2 = str5;
            }
            QLog.i("GuildFeedNoticeCommentPart", 1, "no permission to post in guildId=" + str4 + ", " + str2);
            return;
        }
        if (reply != null) {
            i3 = 2;
        }
        K9(new a.ShowInputComponentMessage(new ShowInputComponentArgs(InputFunctionType.FUNCTION_TYPE_REPLY_COMMENT, new ReplyCommentArgs(i3, comment, reply, null, false, 16, null), 0, (short) 3, null, 16, null)));
    }

    @Override // com.tencent.mobileqq.guild.feed.part.notice.f
    public void e6(@NotNull GProStNotice mStNotice, @NotNull final GProStComment comment, @Nullable final GProStReply reply, boolean isGuildNotice) {
        boolean z16;
        boolean z17;
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        IGProGuildInfo iGProGuildInfo;
        Intrinsics.checkNotNullParameter(mStNotice, "mStNotice");
        Intrinsics.checkNotNullParameter(comment, "comment");
        this.stNotice = mStNotice;
        this.isInGuildNotice = isGuildNotice;
        this.guildId = g.b(mStNotice);
        this.channelId = g.a(mStNotice);
        String str = mStNotice.origineFeed.idd;
        Intrinsics.checkNotNullExpressionValue(str, "mStNotice.origineFeed.idd");
        this.feedId = str;
        String str2 = this.channelId;
        String str3 = null;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelId");
            str2 = null;
        }
        if (str2.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            String str4 = this.channelId;
            if (str4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelId");
                str4 = null;
            }
            if (str4.length() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime instanceof AppInterface) {
                    appInterface = (AppInterface) peekAppRuntime;
                } else {
                    appInterface = null;
                }
                if (appInterface != null) {
                    iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
                } else {
                    iRuntimeService = null;
                }
                IGPSService iGPSService = (IGPSService) iRuntimeService;
                if (iGPSService != null) {
                    String str5 = this.guildId;
                    if (str5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("guildId");
                        str5 = null;
                    }
                    iGProGuildInfo = iGPSService.getGuildInfo(str5);
                } else {
                    iGProGuildInfo = null;
                }
                if (iGProGuildInfo == null) {
                    String str6 = this.guildId;
                    if (str6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("guildId");
                    } else {
                        str3 = str6;
                    }
                    GuildMainFrameUtils.l(str3, false, new Function1<IGProGuildInfo, Unit>() { // from class: com.tencent.mobileqq.guild.feed.part.notice.GuildFeedNoticeCommentPart$doReply$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(IGProGuildInfo iGProGuildInfo2) {
                            invoke2(iGProGuildInfo2);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@Nullable IGProGuildInfo iGProGuildInfo2) {
                            String str7;
                            String str8;
                            str7 = GuildFeedNoticeCommentPart.this.guildId;
                            String str9 = null;
                            if (str7 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("guildId");
                                str7 = null;
                            }
                            if (!(str7.length() == 0)) {
                                str8 = GuildFeedNoticeCommentPart.this.channelId;
                                if (str8 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("channelId");
                                } else {
                                    str9 = str8;
                                }
                                if (!(str9.length() == 0) && iGProGuildInfo2 != null) {
                                    GuildFeedNoticeCommentPart.this.H9(iGProGuildInfo2, comment, reply);
                                    return;
                                }
                            }
                            n.A(0, "\u64cd\u4f5c\u5931\u8d25");
                            QLog.e("GuildFeedNoticeCommentPart", 1, "fetchGuildInfoAnyway guildInfo is null.");
                        }
                    });
                    return;
                }
                H9(iGProGuildInfo, comment, reply);
                return;
            }
        }
        QLog.e("GuildFeedNoticeCommentPart", 1, "doReply |channelId and guildId must not be empty");
    }

    @Override // com.tencent.biz.richframework.part.Part
    @Nullable
    public Object getMessage(@Nullable String action, @Nullable Object args) {
        if (Intrinsics.areEqual(action, "action_get_detail_main_data")) {
            return Unit.INSTANCE;
        }
        if (Intrinsics.areEqual(action, "message_get_comment_feed_data")) {
            return J9();
        }
        return null;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        NativeDetailInputWindowDirector nativeDetailInputWindowDirector;
        if (action != null) {
            switch (action.hashCode()) {
                case -1357264245:
                    if (action.equals("message_close_input")) {
                        QLog.i("GuildFeedNoticeCommentPart", 1, "close input, caller: " + args);
                        NativeDetailInputWindowDirector nativeDetailInputWindowDirector2 = this.inputDirector;
                        if (nativeDetailInputWindowDirector2 != null) {
                            nativeDetailInputWindowDirector2.r();
                            return;
                        }
                        return;
                    }
                    return;
                case 69131257:
                    if (action.equals("message_on_speak_permission_changed")) {
                        L9(args);
                        return;
                    }
                    return;
                case 1047580686:
                    if (action.equals("message_on_reply_completed") && this.isInGuildNotice) {
                        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                        String str = this.guildId;
                        if (str == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("guildId");
                            str = null;
                        }
                        com.tencent.mobileqq.guild.main.d.d(peekAppRuntime, str, "guild_notice_list_reply");
                        return;
                    }
                    return;
                case 1179209504:
                    if (action.equals("message_clear_input") && (nativeDetailInputWindowDirector = this.inputDirector) != null) {
                        nativeDetailInputWindowDirector.q();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.part.notice.f
    public void l8(@NotNull GProStNotice mStNotice, @NotNull GProStComment commentData, @Nullable GProStReply replyData, int likeStatus, @Nullable final IGProDoLikeCallback cb5) {
        int i3;
        boolean z16;
        Intrinsics.checkNotNullParameter(mStNotice, "mStNotice");
        Intrinsics.checkNotNullParameter(commentData, "commentData");
        this.stNotice = mStNotice;
        boolean z17 = false;
        if (likeStatus == 1) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        GProStDoLikeReq gProStDoLikeReq = new GProStDoLikeReq();
        GProStNotice gProStNotice = this.stNotice;
        if (gProStNotice == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stNotice");
            gProStNotice = null;
        }
        gProStDoLikeReq.feed = gProStNotice.origineFeed;
        ol1.a aVar = ol1.a.f423087a;
        int i16 = 1 - i3;
        if (replyData != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        gProStDoLikeReq.likeType = aVar.a(i16, z16);
        gProStDoLikeReq.emotionReaction = E9();
        GProStCommonExt gProStCommonExt = new GProStCommonExt();
        gProStCommonExt.mapInfoList.addAll(i.f450608a.f());
        gProStDoLikeReq.extInfo = gProStCommonExt;
        GProStComment gProStComment = new GProStComment();
        gProStComment.idd = commentData.idd;
        gProStDoLikeReq.comment = gProStComment;
        if (replyData != null) {
            GProStReply gProStReply = new GProStReply();
            gProStReply.idd = replyData.idd;
            GProStLike gProStLike = new GProStLike();
            gProStLike.idd = replyData.idd;
            gProStLike.status = likeStatus;
            gProStReply.likeInfo = gProStLike;
            gProStDoLikeReq.reply = gProStReply;
        }
        String likeId = commentData.idd;
        if (replyData == null) {
            GProStComment gProStComment2 = gProStDoLikeReq.comment;
            GProStLike gProStLike2 = new GProStLike();
            gProStLike2.idd = commentData.idd;
            gProStLike2.status = likeStatus;
            gProStComment2.likeInfo = gProStLike2;
        } else {
            likeId = replyData.idd;
        }
        GProStLike gProStLike3 = new GProStLike();
        gProStLike3.idd = likeId;
        gProStLike3.status = likeStatus;
        gProStDoLikeReq.like = gProStLike3;
        com.tencent.mobileqq.guild.feed.report.c cVar = com.tencent.mobileqq.guild.feed.report.c.f223280a;
        if (replyData != null) {
            z17 = true;
        }
        Intrinsics.checkNotNullExpressionValue(likeId, "likeId");
        final IPerformanceReportTask e16 = cVar.e(gProStDoLikeReq, z17, likeId);
        o c16 = l.c();
        if (c16 != null) {
            c16.doLike(gProStDoLikeReq, new IGProDoLikeCallback() { // from class: com.tencent.mobileqq.guild.feed.part.notice.a
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProDoLikeCallback
                public final void onResult(int i17, String str, boolean z18, GProStDoLikeRsp gProStDoLikeRsp) {
                    GuildFeedNoticeCommentPart.G9(IPerformanceReportTask.this, cb5, i17, str, z18, gProStDoLikeRsp);
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        NativeDetailInputWindowDirector nativeDetailInputWindowDirector = this.inputDirector;
        if (nativeDetailInputWindowDirector != null) {
            nativeDetailInputWindowDirector.j(requestCode, resultCode, data);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        this.cacheBitmap = null;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.v1n);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById<Vi\u2026.feed_detail_bottom_root)");
        this.bottomInteractiveView = findViewById;
        RFWIocAbilityProvider.g().registerIoc(rootView, this, f.class);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        NativeDetailInputWindowDirector nativeDetailInputWindowDirector = this.inputDirector;
        if (nativeDetailInputWindowDirector != null) {
            nativeDetailInputWindowDirector.k();
        }
        F9();
        RFWIocAbilityProvider.g().unregisterSingleIoc(getPartRootView(), f.class);
    }
}

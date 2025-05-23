package com.tencent.mobileqq.guild.feed.gallery.part;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.gallery.constants.GuildFeedGalleryMessage;
import com.tencent.mobileqq.guild.feed.gallery.data.GuildGalleryCommentPanelParams;
import com.tencent.mobileqq.guild.feed.gallery.part.GuildFeedGalleryBottomInputHelperPart$feedLikeManage$2;
import com.tencent.mobileqq.guild.feed.gallery.part.GuildFeedGalleryBottomInputHelperPart$inputMessageDelegate$2;
import com.tencent.mobileqq.guild.feed.gallery.part.f;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.ShowInputComponentArgs;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.SpeakPermissionType;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.handler.SpeakPermissionInputHandler;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStComment;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStCommonExt;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoCommentReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoCommentRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStDoReplyReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wk1.FeedReferRequestArgs;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0006\n\u0002\b\u000b*\u00027=\u0018\u0000 D2\u00020\u00012\u00020\u0002:\u0002EFB\u0007\u00a2\u0006\u0004\bB\u0010CJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u0012\u0010\u0017\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u001c\u0010\u0019\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010!\u001a\u00020 H\u0016R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010(\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00102\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u001b\u0010<\u001a\u0002078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u001b\u0010A\u001a\u00020=8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b>\u00109\u001a\u0004\b?\u0010@\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/part/GuildFeedGalleryBottomInputHelperPart;", "Lcom/tencent/mobileqq/guild/feed/part/d;", "Lcom/tencent/mobileqq/guild/feed/gallery/part/s;", "", "msg", "", "J9", "N9", "", "sourceTag", "K9", "I9", "G9", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "H9", "Landroid/view/View;", "view", "Landroid/graphics/Bitmap;", "D9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "action", "handleBroadcastMessage", "Lcom/tencent/mobileqq/guild/feed/gallery/part/GuildFeedGalleryBottomInputHelperPart$b;", "param", "M9", "Lcom/tencent/mobileqq/guild/feed/gallery/constants/GuildFeedGalleryMessage$b;", "showArgs", "F6", "Lwk1/f;", "f", "Lcom/tencent/mobileqq/guild/feed/gallery/data/GuildGalleryCommentPanelParams;", "d", "Lcom/tencent/mobileqq/guild/feed/gallery/data/GuildGalleryCommentPanelParams;", "initBean", "e", "Landroid/view/View;", "inputShadowView", "", "I", "inputHostViewHeight", "Landroid/graphics/Canvas;", tl.h.F, "Landroid/graphics/Canvas;", "canvasForCapture", "i", "Landroid/graphics/Bitmap;", "cacheBitmap", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/handler/SpeakPermissionInputHandler;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/handler/SpeakPermissionInputHandler;", "speakPermissionInputHandler", "com/tencent/mobileqq/guild/feed/gallery/part/GuildFeedGalleryBottomInputHelperPart$inputMessageDelegate$2$a", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "F9", "()Lcom/tencent/mobileqq/guild/feed/gallery/part/GuildFeedGalleryBottomInputHelperPart$inputMessageDelegate$2$a;", "inputMessageDelegate", "com/tencent/mobileqq/guild/feed/gallery/part/GuildFeedGalleryBottomInputHelperPart$feedLikeManage$2$a", "D", "E9", "()Lcom/tencent/mobileqq/guild/feed/gallery/part/GuildFeedGalleryBottomInputHelperPart$feedLikeManage$2$a;", "feedLikeManage", "<init>", "()V", "E", "a", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedGalleryBottomInputHelperPart extends com.tencent.mobileqq.guild.feed.part.d implements s {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy inputMessageDelegate;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy feedLikeManage;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildGalleryCommentPanelParams initBean;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View inputShadowView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int inputHostViewHeight;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Canvas canvasForCapture = new Canvas();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Bitmap cacheBitmap;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private SpeakPermissionInputHandler speakPermissionInputHandler;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00158\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001c\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u001a\u001a\u0004\b\u0010\u0010\u001bR\u0017\u0010 \u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b\n\u0010\u001f\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/part/GuildFeedGalleryBottomInputHelperPart$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/guild/feed/gallery/data/GuildGalleryCommentPanelParams;", "a", "Lcom/tencent/mobileqq/guild/feed/gallery/data/GuildGalleryCommentPanelParams;", "c", "()Lcom/tencent/mobileqq/guild/feed/gallery/data/GuildGalleryCommentPanelParams;", "initBean", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/SpeakPermissionType;", "b", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/SpeakPermissionType;", "e", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/SpeakPermissionType;", "speakType", "Landroid/view/View;", "Landroid/view/View;", "d", "()Landroid/view/View;", "inputShadowView", "I", "()I", "hostViewHeight", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/i;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/i;", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/i;", "args", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.gallery.part.GuildFeedGalleryBottomInputHelperPart$b, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class ShowInputDialogProxyParam {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final GuildGalleryCommentPanelParams initBean;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final SpeakPermissionType speakType;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final View inputShadowView;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int hostViewHeight;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final ShowInputComponentArgs args;

        @NotNull
        /* renamed from: a, reason: from getter */
        public final ShowInputComponentArgs getArgs() {
            return this.args;
        }

        /* renamed from: b, reason: from getter */
        public final int getHostViewHeight() {
            return this.hostViewHeight;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final GuildGalleryCommentPanelParams getInitBean() {
            return this.initBean;
        }

        @Nullable
        /* renamed from: d, reason: from getter */
        public final View getInputShadowView() {
            return this.inputShadowView;
        }

        @NotNull
        /* renamed from: e, reason: from getter */
        public final SpeakPermissionType getSpeakType() {
            return this.speakType;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ShowInputDialogProxyParam)) {
                return false;
            }
            ShowInputDialogProxyParam showInputDialogProxyParam = (ShowInputDialogProxyParam) other;
            if (Intrinsics.areEqual(this.initBean, showInputDialogProxyParam.initBean) && this.speakType == showInputDialogProxyParam.speakType && Intrinsics.areEqual(this.inputShadowView, showInputDialogProxyParam.inputShadowView) && this.hostViewHeight == showInputDialogProxyParam.hostViewHeight && Intrinsics.areEqual(this.args, showInputDialogProxyParam.args)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = ((this.initBean.hashCode() * 31) + this.speakType.hashCode()) * 31;
            View view = this.inputShadowView;
            if (view == null) {
                hashCode = 0;
            } else {
                hashCode = view.hashCode();
            }
            return ((((hashCode2 + hashCode) * 31) + this.hostViewHeight) * 31) + this.args.hashCode();
        }

        @NotNull
        public String toString() {
            return "ShowInputDialogProxyParam(initBean=" + this.initBean + ", speakType=" + this.speakType + ", inputShadowView=" + this.inputShadowView + ", hostViewHeight=" + this.hostViewHeight + ", args=" + this.args + ")";
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000f\u001a\u00020\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\b\u00a8\u0006\u0012"}, d2 = {"com/tencent/mobileqq/guild/feed/gallery/part/GuildFeedGalleryBottomInputHelperPart$c", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/handler/a;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "", "getGuildId", "()Ljava/lang/String;", "guildId", "getChannelId", "channelId", "Lwk1/i;", "getDelegate", "()Lwk1/i;", "delegate", "getTroopUin", "troopUin", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.handler.a {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.handler.a
        @NotNull
        public String getChannelId() {
            String channelId;
            GuildGalleryCommentPanelParams guildGalleryCommentPanelParams = GuildFeedGalleryBottomInputHelperPart.this.initBean;
            if (guildGalleryCommentPanelParams == null || (channelId = guildGalleryCommentPanelParams.getChannelId()) == null) {
                return "";
            }
            return channelId;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.handler.a
        @NotNull
        public Context getContext() {
            Context context = GuildFeedGalleryBottomInputHelperPart.this.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "this@GuildFeedGalleryBottomInputHelperPart.context");
            return context;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.handler.a
        @NotNull
        public wk1.i getDelegate() {
            return GuildFeedGalleryBottomInputHelperPart.this.F9();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.handler.a
        @NotNull
        public String getGuildId() {
            String guildId;
            GuildGalleryCommentPanelParams guildGalleryCommentPanelParams = GuildFeedGalleryBottomInputHelperPart.this.initBean;
            if (guildGalleryCommentPanelParams == null || (guildId = guildGalleryCommentPanelParams.getGuildId()) == null) {
                return "";
            }
            return guildId;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.handler.a
        @NotNull
        public String getTroopUin() {
            return "";
        }
    }

    public GuildFeedGalleryBottomInputHelperPart() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildFeedGalleryBottomInputHelperPart$inputMessageDelegate$2.a>() { // from class: com.tencent.mobileqq.guild.feed.gallery.part.GuildFeedGalleryBottomInputHelperPart$inputMessageDelegate$2

            @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/feed/gallery/part/GuildFeedGalleryBottomInputHelperPart$inputMessageDelegate$2$a", "Lwk1/i;", "", "action", "", "msg", "", "lh", "I2", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes13.dex */
            public static final class a implements wk1.i {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ GuildFeedGalleryBottomInputHelperPart f219654d;

                a(GuildFeedGalleryBottomInputHelperPart guildFeedGalleryBottomInputHelperPart) {
                    this.f219654d = guildFeedGalleryBottomInputHelperPart;
                }

                @Override // wk1.i
                @Nullable
                public Object I2(@NotNull String action, @Nullable Object msg2) {
                    JumpGuildParam.JoinInfoParam H9;
                    Intrinsics.checkNotNullParameter(action, "action");
                    if (Intrinsics.areEqual(action, "message_get_join_guild_sign")) {
                        H9 = this.f219654d.H9();
                        return H9;
                    }
                    return null;
                }

                @Override // wk1.i
                public void lh(@NotNull String action, @Nullable Object msg2) {
                    Intrinsics.checkNotNullParameter(action, "action");
                    if (Intrinsics.areEqual(action, "message_check_input_speak_permission_succ")) {
                        this.f219654d.G9(msg2);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a(GuildFeedGalleryBottomInputHelperPart.this);
            }
        });
        this.inputMessageDelegate = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<GuildFeedGalleryBottomInputHelperPart$feedLikeManage$2.a>() { // from class: com.tencent.mobileqq.guild.feed.gallery.part.GuildFeedGalleryBottomInputHelperPart$feedLikeManage$2

            @Metadata(d1 = {"\u0000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0011\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0001Jj\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062W\b\u0002\u0010\u0011\u001aQ\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0007\u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\bj\u0004\u0018\u0001`\u0010H\u0096\u0001J\b\u0010\u0014\u001a\u00020\u0013H\u0016\u00a8\u0006\u0015"}, d2 = {"com/tencent/mobileqq/guild/feed/gallery/part/GuildFeedGalleryBottomInputHelperPart$feedLikeManage$2$a", "Lwk1/f;", "", "feedId", "", "isRequesting", "Lwk1/b;", "args", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "result", "", "rsp", "", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/base/LikeCallBack;", "callback", "a", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStCommonExt;", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes13.dex */
            public static final class a implements wk1.f {

                /* renamed from: a, reason: collision with root package name */
                private final /* synthetic */ com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.logic.f f219652a = new com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.logic.f();

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ GuildFeedGalleryBottomInputHelperPart f219653b;

                a(GuildFeedGalleryBottomInputHelperPart guildFeedGalleryBottomInputHelperPart) {
                    this.f219653b = guildFeedGalleryBottomInputHelperPart;
                }

                @Override // wk1.f
                public void a(@NotNull FeedReferRequestArgs args, @Nullable Function3<? super Integer, ? super FeedReferRequestArgs, Object, Unit> callback) {
                    Intrinsics.checkNotNullParameter(args, "args");
                    this.f219652a.a(args, callback);
                }

                @Override // wk1.f
                @NotNull
                public GProStCommonExt b() {
                    GProStCommonExt gProStCommonExt = new GProStCommonExt();
                    com.tencent.mobileqq.guild.feed.nativepublish.utils.k.a(com.tencent.mobileqq.guild.feed.nativepublish.utils.k.c(1, ax.q(this.f219653b.getContext())), gProStCommonExt);
                    com.tencent.mobileqq.guild.feed.nativepublish.utils.k.b(gProStCommonExt);
                    return gProStCommonExt;
                }

                @Override // wk1.f
                public boolean isRequesting(@NotNull String feedId) {
                    Intrinsics.checkNotNullParameter(feedId, "feedId");
                    return this.f219652a.isRequesting(feedId);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a(GuildFeedGalleryBottomInputHelperPart.this);
            }
        });
        this.feedLikeManage = lazy2;
    }

    private final Bitmap D9(View view) {
        Object m476constructorimpl;
        Object obj = null;
        try {
            Result.Companion companion = Result.INSTANCE;
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (view == null) {
            return null;
        }
        if (this.cacheBitmap == null) {
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
            this.cacheBitmap = createBitmap;
            this.canvasForCapture.setBitmap(createBitmap);
        }
        view.draw(this.canvasForCapture);
        m476constructorimpl = Result.m476constructorimpl(this.cacheBitmap);
        if (!Result.m482isFailureimpl(m476constructorimpl)) {
            obj = m476constructorimpl;
        }
        return (Bitmap) obj;
    }

    private final GuildFeedGalleryBottomInputHelperPart$feedLikeManage$2.a E9() {
        return (GuildFeedGalleryBottomInputHelperPart$feedLikeManage$2.a) this.feedLikeManage.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GuildFeedGalleryBottomInputHelperPart$inputMessageDelegate$2.a F9() {
        return (GuildFeedGalleryBottomInputHelperPart$inputMessageDelegate$2.a) this.inputMessageDelegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G9(Object msg2) {
        String str;
        String str2;
        String str3;
        String feedId;
        String channelId;
        String guildId;
        if (msg2 instanceof a.ShowInputComponentMessage) {
            a.ShowInputComponentMessage showInputComponentMessage = (a.ShowInputComponentMessage) msg2;
            if (showInputComponentMessage.getInputArgs().getExtObj() instanceof GuildFeedGalleryMessage.CommentPanelShowArgs) {
                broadcastMessage("message_on_comment_panel_show", showInputComponentMessage.getInputArgs().getExtObj());
                return;
            }
            GuildGalleryCommentPanelParams guildGalleryCommentPanelParams = this.initBean;
            if (guildGalleryCommentPanelParams == null || (guildId = guildGalleryCommentPanelParams.getGuildId()) == null) {
                str = "";
            } else {
                str = guildId;
            }
            GuildGalleryCommentPanelParams guildGalleryCommentPanelParams2 = this.initBean;
            if (guildGalleryCommentPanelParams2 == null || (channelId = guildGalleryCommentPanelParams2.getChannelId()) == null) {
                str2 = "";
            } else {
                str2 = channelId;
            }
            GuildGalleryCommentPanelParams guildGalleryCommentPanelParams3 = this.initBean;
            if (guildGalleryCommentPanelParams3 == null || (feedId = guildGalleryCommentPanelParams3.getFeedId()) == null) {
                str3 = "";
            } else {
                str3 = feedId;
            }
            broadcastMessage("message_on_show_input_dialog", new f.ShowInputDialogParam(str, str2, str3, D9(this.inputShadowView), this.inputHostViewHeight, showInputComponentMessage.getInputArgs()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JumpGuildParam.JoinInfoParam H9() {
        GuildGalleryCommentPanelParams guildGalleryCommentPanelParams = this.initBean;
        if (guildGalleryCommentPanelParams != null) {
            return new JumpGuildParam.JoinInfoParam(guildGalleryCommentPanelParams.getChannelId(), guildGalleryCommentPanelParams.getJoinGuildSig(), "immersive_feed", "others");
        }
        return null;
    }

    private final void I9(Object msg2) {
        boolean z16;
        if (!(msg2 instanceof a.ModifyBottomInteractiveDataMessage)) {
            return;
        }
        a.ModifyBottomInteractiveDataMessage modifyBottomInteractiveDataMessage = (a.ModifyBottomInteractiveDataMessage) msg2;
        if (modifyBottomInteractiveDataMessage.getFeedId().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && modifyBottomInteractiveDataMessage.getCommentCount() != null) {
            String feedId = modifyBottomInteractiveDataMessage.getFeedId();
            Integer commentCount = modifyBottomInteractiveDataMessage.getCommentCount();
            Intrinsics.checkNotNull(commentCount);
            broadcastMessage("message_on_comment_data_change", new GuildFeedGalleryMessage.CommentDataChangeArgs(feedId, 1, commentCount.intValue()));
        }
    }

    private final void J9(Object msg2) {
        GProStDoReplyReq req;
        GProStFeed gProStFeed;
        String str;
        GProStFeed gProStFeed2;
        boolean z16;
        if (msg2 instanceof a.OnCommentCompletedMessage) {
            str = ((a.OnCommentCompletedMessage) msg2).getCommentReq().feed.idd;
        } else if (msg2 instanceof a.OnReplyCommentCompletedMessage) {
            str = ((a.OnReplyCommentCompletedMessage) msg2).getReq().feed.idd;
        } else if (msg2 instanceof a.CommentRequestOperationResult) {
            GProStDoCommentReq req2 = ((a.CommentRequestOperationResult) msg2).getReq();
            if (req2 != null && (gProStFeed2 = req2.feed) != null) {
                str = gProStFeed2.idd;
            }
            str = null;
        } else {
            if ((msg2 instanceof a.ReplyRequestOperationResult) && (req = ((a.ReplyRequestOperationResult) msg2).getReq()) != null && (gProStFeed = req.feed) != null) {
                str = gProStFeed.idd;
            }
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            broadcastMessage("message_on_comment_data_change", new GuildFeedGalleryMessage.CommentDataChangeArgs(str, 2, 1));
        }
    }

    private final void K9(final String sourceTag) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.gallery.part.b
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedGalleryBottomInputHelperPart.L9(GuildFeedGalleryBottomInputHelperPart.this, sourceTag);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L9(GuildFeedGalleryBottomInputHelperPart this$0, String sourceTag) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(sourceTag, "$sourceTag");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        GuildGalleryCommentPanelParams guildGalleryCommentPanelParams = this$0.initBean;
        if (guildGalleryCommentPanelParams == null || (str = guildGalleryCommentPanelParams.getGuildId()) == null) {
            str = "";
        }
        com.tencent.mobileqq.guild.main.d.d(peekAppRuntime, str, sourceTag);
    }

    private final void N9(Object msg2) {
        String str;
        if (!(msg2 instanceof a.OnCommentCompletedMessage)) {
            return;
        }
        a.OnCommentCompletedMessage onCommentCompletedMessage = (a.OnCommentCompletedMessage) msg2;
        String str2 = onCommentCompletedMessage.getCommentReq().feed.idd;
        GProStDoCommentRsp commentRsp = onCommentCompletedMessage.getCommentRsp();
        Intrinsics.checkNotNull(commentRsp);
        GProStComment gProStComment = commentRsp.comment;
        Intrinsics.checkNotNull(gProStComment);
        String commentId = gProStComment.idd;
        GuildGalleryCommentPanelParams guildGalleryCommentPanelParams = this.initBean;
        if (guildGalleryCommentPanelParams != null) {
            Intrinsics.checkNotNull(guildGalleryCommentPanelParams);
            if (Intrinsics.areEqual(guildGalleryCommentPanelParams.getFeedId(), str2)) {
                GuildGalleryCommentPanelParams guildGalleryCommentPanelParams2 = this.initBean;
                Intrinsics.checkNotNull(guildGalleryCommentPanelParams2);
                Intrinsics.checkNotNullExpressionValue(commentId, "commentId");
                broadcastMessage("message_on_comment_panel_show", new GuildFeedGalleryMessage.CommentPanelShowArgs(guildGalleryCommentPanelParams2, true, false, commentId, null, false, 48, null));
                return;
            }
        }
        GuildGalleryCommentPanelParams guildGalleryCommentPanelParams3 = this.initBean;
        if (guildGalleryCommentPanelParams3 != null) {
            str = guildGalleryCommentPanelParams3.getFeedId();
        } else {
            str = null;
        }
        QLog.e("Guild_Feed_GAL_GuildFeedGalleryBottomInputHelperPart", 1, "tryAutoShowCommentPanel error feedId: " + str2 + " initBean.feedId:" + str);
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.part.s
    public void F6(@NotNull GuildFeedGalleryMessage.CommentPanelShowProxyArgs showArgs) {
        Intrinsics.checkNotNullParameter(showArgs, "showArgs");
        if (showArgs.getShowArgs().getAutoShowInputDialog()) {
            this.initBean = showArgs.getShowArgs().getInitBean();
            showArgs.getArgs().f(showArgs.getShowArgs());
            SpeakPermissionInputHandler speakPermissionInputHandler = this.speakPermissionInputHandler;
            if (speakPermissionInputHandler == null) {
                Intrinsics.throwUninitializedPropertyAccessException("speakPermissionInputHandler");
                speakPermissionInputHandler = null;
            }
            speakPermissionInputHandler.c(showArgs.getSpeakType(), showArgs.getArgs());
            return;
        }
        broadcastMessage("message_on_comment_panel_show", showArgs.getShowArgs());
    }

    public void M9(@NotNull ShowInputDialogProxyParam param) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.initBean = param.getInitBean();
        this.inputShadowView = param.getInputShadowView();
        this.inputHostViewHeight = param.getHostViewHeight();
        SpeakPermissionInputHandler speakPermissionInputHandler = this.speakPermissionInputHandler;
        if (speakPermissionInputHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("speakPermissionInputHandler");
            speakPermissionInputHandler = null;
        }
        speakPermissionInputHandler.c(param.getSpeakType(), param.getArgs());
    }

    @Override // com.tencent.mobileqq.guild.feed.gallery.part.s
    @NotNull
    public wk1.f f() {
        return E9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object msg2) {
        if (action != null) {
            int hashCode = action.hashCode();
            if (hashCode != -738605245) {
                if (hashCode != 94648422) {
                    if (hashCode == 1994817324 && action.equals("message_modify_bottom_interact_data")) {
                        I9(msg2);
                        return;
                    }
                    return;
                }
                if (!action.equals("message_on_show_input_dialog_proxy") || !(msg2 instanceof ShowInputDialogProxyParam)) {
                    return;
                }
                M9((ShowInputDialogProxyParam) msg2);
                return;
            }
            if (action.equals("message_on_comment_completed") && (msg2 instanceof a.OnCommentCompletedMessage) && ((a.OnCommentCompletedMessage) msg2).getIsSuccess()) {
                J9(msg2);
                N9(msg2);
                K9("do comment or reply");
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        this.speakPermissionInputHandler = new SpeakPermissionInputHandler(new c());
        RFWIocAbilityProvider.g().registerIoc(getPartRootView(), this, s.class);
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        RFWIocAbilityProvider.g().unregisterSingleIoc(getPartRootView(), s.class);
    }
}

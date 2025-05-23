package com.tencent.mobileqq.guild.feed.gallery.comment.part;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi;
import com.tencent.mobileqq.guild.feed.gallery.comment.part.GuildFeedGalleryCommentSpeakPermissionPart$inputMessageDelegate$2;
import com.tencent.mobileqq.guild.feed.gallery.data.GuildGalleryCommentPanelParams;
import com.tencent.mobileqq.guild.feed.gallery.part.f;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.ShowInputComponentArgs;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.SpeakPermissionType;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.handler.SpeakPermissionInputHandler;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import el1.a;
import hk1.a;
import java.util.HashSet;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u000448<B\u0018\u0000 J2\u00020\u0001:\u0001KB\u0011\u0012\b\u0010G\u001a\u0004\u0018\u00010F\u00a2\u0006\u0004\bH\u0010IJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0012\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0012\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u000eH\u0002J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J\u0018\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0010\u0010 \u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0016H\u0016J\u001c\u0010\"\u001a\u00020\u00022\b\u0010!\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0012\u0010%\u001a\u00020\u00022\b\u0010$\u001a\u0004\u0018\u00010#H\u0016R\u0016\u0010(\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00103\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010;\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u001b\u0010A\u001a\u00020<8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u0014\u0010E\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010D\u00a8\u0006L"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/comment/part/GuildFeedGalleryCommentSpeakPermissionPart;", "Lcom/tencent/mobileqq/guild/feed/gallery/comment/part/a;", "", "initData", "O9", "", "updateSource", "S9", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "R9", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/SpeakPermissionType;", "newSpeakPermission", "Q9", "", "args", "M9", "K9", "msg", "N9", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "L9", "Landroid/view/View;", "view", "Landroid/graphics/Bitmap;", "I9", QCircleDaTongConstant.ElementParamValue.PERMISSION, "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/i;", "inputArgs", "", "P9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "action", "handleBroadcastMessage", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "f", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/SpeakPermissionType;", "curSpeakPermission", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/handler/SpeakPermissionInputHandler;", tl.h.F, "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/handler/SpeakPermissionInputHandler;", "speakPermissionInputHandler", "Landroid/graphics/Canvas;", "i", "Landroid/graphics/Canvas;", "canvasForCapture", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/graphics/Bitmap;", "cacheBitmap", "com/tencent/mobileqq/guild/feed/gallery/comment/part/GuildFeedGalleryCommentSpeakPermissionPart$b", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/feed/gallery/comment/part/GuildFeedGalleryCommentSpeakPermissionPart$b;", "serviceObserver", "com/tencent/mobileqq/guild/feed/gallery/comment/part/GuildFeedGalleryCommentSpeakPermissionPart$d", "D", "Lcom/tencent/mobileqq/guild/feed/gallery/comment/part/GuildFeedGalleryCommentSpeakPermissionPart$d;", "speakThresholdUpdateListener", "com/tencent/mobileqq/guild/feed/gallery/comment/part/GuildFeedGalleryCommentSpeakPermissionPart$inputMessageDelegate$2$a", "E", "Lkotlin/Lazy;", "J9", "()Lcom/tencent/mobileqq/guild/feed/gallery/comment/part/GuildFeedGalleryCommentSpeakPermissionPart$inputMessageDelegate$2$a;", "inputMessageDelegate", "com/tencent/mobileqq/guild/feed/gallery/comment/part/GuildFeedGalleryCommentSpeakPermissionPart$c", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/feed/gallery/comment/part/GuildFeedGalleryCommentSpeakPermissionPart$c;", "speakInputContextProvider", "Lgk1/b;", "contextProvider", "<init>", "(Lgk1/b;)V", "G", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedGalleryCommentSpeakPermissionPart extends a {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final b serviceObserver;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final d speakThresholdUpdateListener;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy inputMessageDelegate;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final c speakInputContextProvider;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private SpeakPermissionType curSpeakPermission;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private SpeakPermissionInputHandler speakPermissionInputHandler;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Canvas canvasForCapture;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Bitmap cacheBitmap;

    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J\u0012\u0010\t\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\f\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u001a\u0010\u0011\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J\u001a\u0010\u0014\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0014\u00a8\u0006\u0015"}, d2 = {"com/tencent/mobileqq/guild/feed/gallery/comment/part/GuildFeedGalleryCommentSpeakPermissionPart$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "admint", "", "bAdmin", "", "onAdminChanged", "onGuildInfoUpdated", "channelUin", "onChannelInfoUpdated", "onChannelListUpdated", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "info", "", "sourceType", "onAddGuildWithInfo", "", "expireTime", "onShutUpStateChanged", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onAddGuildWithInfo(@Nullable IGProGuildInfo info, int sourceType) {
            String str;
            String guildId = GuildFeedGalleryCommentSpeakPermissionPart.this.z9().getGuildId();
            if (info != null) {
                str = info.getGuildID();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(guildId, str)) {
                GuildFeedGalleryCommentSpeakPermissionPart.this.S9("onAddGuildWithInfo");
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onAdminChanged(@Nullable String guildId, @Nullable String admint, boolean bAdmin) {
            if (Intrinsics.areEqual(GuildFeedGalleryCommentSpeakPermissionPart.this.z9().getGuildId(), guildId)) {
                GuildFeedGalleryCommentSpeakPermissionPart.this.S9("onAdminChanged");
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelInfoUpdated(@Nullable String channelUin) {
            if (Intrinsics.areEqual(GuildFeedGalleryCommentSpeakPermissionPart.this.z9().getChannelId(), channelUin)) {
                GuildFeedGalleryCommentSpeakPermissionPart.this.S9("onChannelInfoUpdated");
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelListUpdated(@Nullable String guildId) {
            if (Intrinsics.areEqual(GuildFeedGalleryCommentSpeakPermissionPart.this.z9().getGuildId(), guildId)) {
                GuildFeedGalleryCommentSpeakPermissionPart.this.S9("onChannelListUpdated");
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildInfoUpdated(@Nullable String guildId) {
            if (Intrinsics.areEqual(GuildFeedGalleryCommentSpeakPermissionPart.this.z9().getGuildId(), guildId)) {
                GuildFeedGalleryCommentSpeakPermissionPart.this.S9("onGuildInfoUpdated");
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onShutUpStateChanged(@Nullable String guildId, long expireTime) {
            if (Intrinsics.areEqual(GuildFeedGalleryCommentSpeakPermissionPart.this.z9().getGuildId(), guildId)) {
                GuildFeedGalleryCommentSpeakPermissionPart.this.S9("onShutUpStateChanged");
            }
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0014\u0010\r\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\bR\u0014\u0010\u0011\u001a\u00020\u000e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0012"}, d2 = {"com/tencent/mobileqq/guild/feed/gallery/comment/part/GuildFeedGalleryCommentSpeakPermissionPart$c", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/handler/a;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "", "getGuildId", "()Ljava/lang/String;", "guildId", "getChannelId", "channelId", "getTroopUin", "troopUin", "Lwk1/i;", "getDelegate", "()Lwk1/i;", "delegate", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.handler.a {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.handler.a
        @NotNull
        public String getChannelId() {
            return GuildFeedGalleryCommentSpeakPermissionPart.this.z9().getChannelId();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.handler.a
        @NotNull
        public Context getContext() {
            Context context = GuildFeedGalleryCommentSpeakPermissionPart.this.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "this@GuildFeedGalleryCom\u2026eakPermissionPart.context");
            return context;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.handler.a
        @NotNull
        public wk1.i getDelegate() {
            return GuildFeedGalleryCommentSpeakPermissionPart.this.J9();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.handler.a
        @NotNull
        public String getGuildId() {
            return GuildFeedGalleryCommentSpeakPermissionPart.this.z9().getGuildId();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.handler.a
        @NotNull
        public String getTroopUin() {
            return "";
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\b\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0016J\u001e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/feed/gallery/comment/part/GuildFeedGalleryCommentSpeakPermissionPart$d", "Lcom/tencent/mobileqq/guild/api/IGuildSpeakThresholdApi$a;", "", "guildId", "", "M", "", "guildIds", "G", "Ljava/util/HashSet;", "channelIds", "E", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d implements IGuildSpeakThresholdApi.a {
        d() {
        }

        @Override // com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi.a
        public void E(@NotNull String guildId, @NotNull HashSet<String> channelIds) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelIds, "channelIds");
            if (Intrinsics.areEqual(GuildFeedGalleryCommentSpeakPermissionPart.this.z9().getGuildId(), guildId) && channelIds.contains(GuildFeedGalleryCommentSpeakPermissionPart.this.z9().getChannelId())) {
                GuildFeedGalleryCommentSpeakPermissionPart.this.S9("onSpeakThresholdUpdate channel list");
            }
        }

        @Override // com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi.a
        public void G(@NotNull List<String> guildIds) {
            Intrinsics.checkNotNullParameter(guildIds, "guildIds");
            if (guildIds.contains(GuildFeedGalleryCommentSpeakPermissionPart.this.z9().getGuildId())) {
                GuildFeedGalleryCommentSpeakPermissionPart.this.S9("onSpeakThresholdUpdate guild list");
            }
        }

        @Override // com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi.a
        public void M(@NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            if (Intrinsics.areEqual(GuildFeedGalleryCommentSpeakPermissionPart.this.z9().getGuildId(), guildId)) {
                GuildFeedGalleryCommentSpeakPermissionPart.this.S9("onSpeakThresholdUpdate");
            }
        }
    }

    public GuildFeedGalleryCommentSpeakPermissionPart(@Nullable gk1.b bVar) {
        super(bVar);
        Lazy lazy;
        this.curSpeakPermission = SpeakPermissionType.PERMISSION_TYPE_INVALID;
        this.canvasForCapture = new Canvas();
        this.serviceObserver = new b();
        this.speakThresholdUpdateListener = new d();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildFeedGalleryCommentSpeakPermissionPart$inputMessageDelegate$2.a>() { // from class: com.tencent.mobileqq.guild.feed.gallery.comment.part.GuildFeedGalleryCommentSpeakPermissionPart$inputMessageDelegate$2

            @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/feed/gallery/comment/part/GuildFeedGalleryCommentSpeakPermissionPart$inputMessageDelegate$2$a", "Lwk1/i;", "", "action", "", "msg", "", "lh", "I2", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes13.dex */
            public static final class a implements wk1.i {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ GuildFeedGalleryCommentSpeakPermissionPart f219585d;

                a(GuildFeedGalleryCommentSpeakPermissionPart guildFeedGalleryCommentSpeakPermissionPart) {
                    this.f219585d = guildFeedGalleryCommentSpeakPermissionPart;
                }

                @Override // wk1.i
                @Nullable
                public Object I2(@NotNull String action, @Nullable Object msg2) {
                    JumpGuildParam.JoinInfoParam L9;
                    Intrinsics.checkNotNullParameter(action, "action");
                    if (Intrinsics.areEqual(action, "message_get_join_guild_sign")) {
                        L9 = this.f219585d.L9();
                        return L9;
                    }
                    return null;
                }

                @Override // wk1.i
                public void lh(@NotNull String action, @Nullable Object msg2) {
                    Intrinsics.checkNotNullParameter(action, "action");
                    if (Intrinsics.areEqual(action, "message_check_input_speak_permission_succ")) {
                        this.f219585d.N9(msg2);
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
                return new a(GuildFeedGalleryCommentSpeakPermissionPart.this);
            }
        });
        this.inputMessageDelegate = lazy;
        this.speakInputContextProvider = new c();
    }

    private final Bitmap I9(View view) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public final GuildFeedGalleryCommentSpeakPermissionPart$inputMessageDelegate$2.a J9() {
        return (GuildFeedGalleryCommentSpeakPermissionPart$inputMessageDelegate$2.a) this.inputMessageDelegate.getValue();
    }

    private final void K9(Object args) {
        if (!(args instanceof a.CommentFeedMessage)) {
            QLog.i("Guild_Feed_GAL_GuildFeedGalleryCommentSpeakPermissionPart", 1, "handleCommentFeedMessage args error!");
            return;
        }
        a.CommentFeedMessage commentFeedMessage = (a.CommentFeedMessage) args;
        QLog.i("Guild_Feed_GAL_GuildFeedGalleryCommentSpeakPermissionPart", 1, "handleCommentFeedMessage, source = " + commentFeedMessage.getSource());
        if (P9(this.curSpeakPermission, commentFeedMessage.getInputArgs())) {
            return;
        }
        SpeakPermissionInputHandler speakPermissionInputHandler = this.speakPermissionInputHandler;
        if (speakPermissionInputHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("speakPermissionInputHandler");
            speakPermissionInputHandler = null;
        }
        speakPermissionInputHandler.c(this.curSpeakPermission, commentFeedMessage.getInputArgs());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JumpGuildParam.JoinInfoParam L9() {
        return new JumpGuildParam.JoinInfoParam(getChannelId(), A9(), "immersive_feed", "others");
    }

    private final void M9(Object args) {
        if (!(args instanceof a.ReplyCommentMessage)) {
            QLog.i("Guild_Feed_GAL_GuildFeedGalleryCommentSpeakPermissionPart", 1, "handleReplyCommentMessage args error!");
            return;
        }
        a.ReplyCommentMessage replyCommentMessage = (a.ReplyCommentMessage) args;
        QLog.i("Guild_Feed_GAL_GuildFeedGalleryCommentSpeakPermissionPart", 1, "handleReplyCommentMessage, source = " + replyCommentMessage.getSource());
        if (P9(this.curSpeakPermission, replyCommentMessage.getInputArgs())) {
            return;
        }
        SpeakPermissionInputHandler speakPermissionInputHandler = this.speakPermissionInputHandler;
        if (speakPermissionInputHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("speakPermissionInputHandler");
            speakPermissionInputHandler = null;
        }
        speakPermissionInputHandler.c(this.curSpeakPermission, replyCommentMessage.getInputArgs());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N9(Object msg2) {
        a.GetInputViewArgs getInputViewArgs;
        int i3;
        if (msg2 instanceof a.ShowInputComponentMessage) {
            View view = null;
            Object broadcastGetMessage = broadcastGetMessage("message_get_input_view", null);
            if (broadcastGetMessage instanceof a.GetInputViewArgs) {
                getInputViewArgs = (a.GetInputViewArgs) broadcastGetMessage;
            } else {
                getInputViewArgs = null;
            }
            GuildGalleryCommentPanelParams z95 = z9();
            String guildId = z95.getGuildId();
            String channelId = z95.getChannelId();
            String feedId = z95.getFeedId();
            if (getInputViewArgs != null) {
                view = getInputViewArgs.getRootView();
            }
            Bitmap I9 = I9(view);
            if (getInputViewArgs != null) {
                i3 = getInputViewArgs.getHeight();
            } else {
                i3 = 0;
            }
            broadcastMessage("message_on_show_input_dialog", new f.ShowInputDialogParam(guildId, channelId, feedId, I9, i3, ((a.ShowInputComponentMessage) msg2).getInputArgs()));
        }
    }

    private final void O9() {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IGProGuildInfo iGProGuildInfo = null;
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
            iGProGuildInfo = iGPSService.getGuildInfo(z9().getGuildId());
        }
        if (iGProGuildInfo != null) {
            R9(iGProGuildInfo);
        } else {
            Q9(SpeakPermissionType.PERMISSION_TYPE_SIMPLE_INIT);
        }
    }

    private final boolean P9(SpeakPermissionType permission, ShowInputComponentArgs inputArgs) {
        String str;
        boolean isAllowComment = z9().getIsAllowComment();
        boolean isPosterSelf = z9().getIsPosterSelf();
        if (permission != SpeakPermissionType.PERMISSION_TYPE_NORMAL || isAllowComment || isPosterSelf) {
            return false;
        }
        if (inputArgs.getReplyCommentArgs() == null) {
            str = "\u5bf9\u65b9\u5df2\u5173\u95ed\u8bc4\u8bba\u80fd\u529b";
        } else {
            str = "\u5bf9\u65b9\u5df2\u5173\u95ed\u8bc4\u8bba\u56de\u590d\u80fd\u529b";
        }
        QQToastUtil.showQQToast(0, str);
        return true;
    }

    private final void Q9(SpeakPermissionType newSpeakPermission) {
        if (newSpeakPermission == this.curSpeakPermission) {
            return;
        }
        this.curSpeakPermission = newSpeakPermission;
        broadcastMessage("message_on_speak_permission_changed", new a.OnSpeakPermissionChangedMessage(newSpeakPermission));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R9(IGProGuildInfo guildInfo) {
        GuildGalleryCommentPanelParams z95 = z9();
        SpeakPermissionType b16 = new el1.a(new a.Companion.Args(z95.getGuildId(), z95.getChannelId())).b(guildInfo);
        QLog.i("Guild_Feed_GAL_GuildFeedGalleryCommentSpeakPermissionPart", 1, "updateSpeakPermission newSpeakPermission = " + b16);
        Q9(b16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S9(String updateSource) {
        QLog.i("Guild_Feed_GAL_GuildFeedGalleryCommentSpeakPermissionPart", 1, "updateSpeakPermission. source = " + updateSource);
        GuildGalleryCommentPanelParams z95 = z9();
        GuildMainFrameUtils.l(z95.getGuildId(), false, new GuildFeedGalleryCommentSpeakPermissionPart$updateSpeakPermission$1(z95, this));
    }

    private final void initData() {
        AppInterface appInterface;
        this.speakPermissionInputHandler = new SpeakPermissionInputHandler(this.speakInputContextProvider);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            iGPSService.addObserver(this.serviceObserver);
        }
        ((IGuildSpeakThresholdApi) QRoute.api(IGuildSpeakThresholdApi.class)).addListener(this.speakThresholdUpdateListener);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        if (action != null) {
            switch (action.hashCode()) {
                case -1998994918:
                    if (!action.equals("message_comment_emotion_feed")) {
                        return;
                    }
                    break;
                case -1206425582:
                    if (!action.equals("message_comment_at_feed")) {
                        return;
                    }
                    break;
                case -729901398:
                    if (!action.equals("message_comment_box_feed")) {
                        return;
                    }
                    break;
                case 1409275858:
                    if (action.equals("message_reply_comment")) {
                        M9(args);
                        return;
                    }
                    return;
                default:
                    return;
            }
            K9(args);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        initData();
        O9();
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        AppInterface appInterface;
        super.onPartDestroy(activity);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            iGPSService.deleteObserver(this.serviceObserver);
        }
        ((IGuildSpeakThresholdApi) QRoute.api(IGuildSpeakThresholdApi.class)).removeListener(this.speakThresholdUpdateListener);
    }
}

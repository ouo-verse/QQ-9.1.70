package com.tencent.mobileqq.guild.feed.gallery.part;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.NativeDetailInputWindowDirector;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.ShowInputComponentArgs;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor.SendButtonActor;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.b;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a;
import com.tencent.mobileqq.guild.feed.widget.comment.GuildFeedDetailCommentDraftManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\b\f*\u0002*.\u0018\u0000 42\u00020\u0001:\u00045678B\u0007\u00a2\u0006\u0004\b2\u00103J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\"\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u001c\u0010\u001f\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016R\u0016\u0010\"\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/part/f;", "Lcom/tencent/mobileqq/guild/feed/gallery/comment/part/a;", "Lcom/tencent/mobileqq/guild/feed/gallery/part/f$d;", "param", "", "M9", "", "K9", "L9", "", "extOperate", "J9", "H9", "G9", "Lcom/tencent/mobileqq/guild/feed/widget/comment/GuildFeedDetailCommentDraftManager;", "I9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "", "action", "", "args", "handleBroadcastMessage", "f", "I", "inputStatus", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector;", tl.h.F, "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector;", "inputDirector", "i", "Lcom/tencent/mobileqq/guild/feed/widget/comment/GuildFeedDetailCommentDraftManager;", "draftManager", "com/tencent/mobileqq/guild/feed/gallery/part/f$f", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/feed/gallery/part/f$f;", "sendCallback", "com/tencent/mobileqq/guild/feed/gallery/part/f$e", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/feed/gallery/part/f$e;", "dismissCallback", "<init>", "()V", "D", "a", "b", "c", "d", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class f extends com.tencent.mobileqq.guild.feed.gallery.comment.part.a {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final e dismissCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int inputStatus;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private NativeDetailInputWindowDirector inputDirector;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildFeedDetailCommentDraftManager draftManager;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private C7743f sendCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/part/f$b;", "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "", "event", "", "", "getDynamicParams", "", "a", "I", "inputStatus", "<init>", "(I)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int inputStatus;

        public b(int i3) {
            this.inputStatus = i3;
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        @NotNull
        public Map<String, Object> getDynamicParams(@Nullable String event) {
            Map<String, Object> mapOf;
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_status", Integer.valueOf(this.inputStatus)));
            return mapOf;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/part/f$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "guildId", "b", "channelId", "feedId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.gallery.part.f$c, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class SendInputContentExtData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String guildId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String channelId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String feedId;

        public SendInputContentExtData(@NotNull String guildId, @NotNull String channelId, @NotNull String feedId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(feedId, "feedId");
            this.guildId = guildId;
            this.channelId = channelId;
            this.feedId = feedId;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getChannelId() {
            return this.channelId;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getFeedId() {
            return this.feedId;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getGuildId() {
            return this.guildId;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SendInputContentExtData)) {
                return false;
            }
            SendInputContentExtData sendInputContentExtData = (SendInputContentExtData) other;
            if (Intrinsics.areEqual(this.guildId, sendInputContentExtData.guildId) && Intrinsics.areEqual(this.channelId, sendInputContentExtData.channelId) && Intrinsics.areEqual(this.feedId, sendInputContentExtData.feedId)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.guildId.hashCode() * 31) + this.channelId.hashCode()) * 31) + this.feedId.hashCode();
        }

        @NotNull
        public String toString() {
            return "SendInputContentExtData(guildId=" + this.guildId + ", channelId=" + this.channelId + ", feedId=" + this.feedId + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0004\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0010\u0010\fR\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00128\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001a\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001e\u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u001c\u001a\u0004\b\t\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/gallery/part/f$d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "guildId", "b", "channelId", "c", "feedId", "Landroid/graphics/Bitmap;", "Landroid/graphics/Bitmap;", "e", "()Landroid/graphics/Bitmap;", "hostViewBitmap", "I", "f", "()I", "hostViewHeight", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/i;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/i;", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/i;", "args", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Bitmap;ILcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/i;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.gallery.part.f$d, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class ShowInputDialogParam {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String guildId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String channelId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String feedId;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Bitmap hostViewBitmap;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final int hostViewHeight;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final ShowInputComponentArgs args;

        public ShowInputDialogParam(@NotNull String guildId, @NotNull String channelId, @NotNull String feedId, @Nullable Bitmap bitmap, int i3, @NotNull ShowInputComponentArgs args) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(feedId, "feedId");
            Intrinsics.checkNotNullParameter(args, "args");
            this.guildId = guildId;
            this.channelId = channelId;
            this.feedId = feedId;
            this.hostViewBitmap = bitmap;
            this.hostViewHeight = i3;
            this.args = args;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final ShowInputComponentArgs getArgs() {
            return this.args;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getChannelId() {
            return this.channelId;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getFeedId() {
            return this.feedId;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getGuildId() {
            return this.guildId;
        }

        @Nullable
        /* renamed from: e, reason: from getter */
        public final Bitmap getHostViewBitmap() {
            return this.hostViewBitmap;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ShowInputDialogParam)) {
                return false;
            }
            ShowInputDialogParam showInputDialogParam = (ShowInputDialogParam) other;
            if (Intrinsics.areEqual(this.guildId, showInputDialogParam.guildId) && Intrinsics.areEqual(this.channelId, showInputDialogParam.channelId) && Intrinsics.areEqual(this.feedId, showInputDialogParam.feedId) && Intrinsics.areEqual(this.hostViewBitmap, showInputDialogParam.hostViewBitmap) && this.hostViewHeight == showInputDialogParam.hostViewHeight && Intrinsics.areEqual(this.args, showInputDialogParam.args)) {
                return true;
            }
            return false;
        }

        /* renamed from: f, reason: from getter */
        public final int getHostViewHeight() {
            return this.hostViewHeight;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = ((((this.guildId.hashCode() * 31) + this.channelId.hashCode()) * 31) + this.feedId.hashCode()) * 31;
            Bitmap bitmap = this.hostViewBitmap;
            if (bitmap == null) {
                hashCode = 0;
            } else {
                hashCode = bitmap.hashCode();
            }
            return ((((hashCode2 + hashCode) * 31) + this.hostViewHeight) * 31) + this.args.hashCode();
        }

        @NotNull
        public String toString() {
            return "ShowInputDialogParam(guildId=" + this.guildId + ", channelId=" + this.channelId + ", feedId=" + this.feedId + ", hostViewBitmap=" + this.hostViewBitmap + ", hostViewHeight=" + this.hostViewHeight + ", args=" + this.args + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/feed/gallery/part/f$e", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$d;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$InputBarDismissCause;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class e implements NativeDetailInputWindowDirector.d {
        e() {
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.NativeDetailInputWindowDirector.d
        public void a(@NotNull NativeDetailInputWindowDirector.InputBarDismissCause cause) {
            Intrinsics.checkNotNullParameter(cause, "cause");
            QLog.i("Guild_Feed_GAL_GuildFeedGalleryInputDialogPart", 1, "OnDismissListener cause=" + cause);
            f.this.inputStatus = 1;
            f fVar = f.this;
            fVar.broadcastMessage("message_action_gallery_comment_input_bar_hide", Boolean.valueOf(fVar.K9()));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JI\u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a2\u0006\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/guild/feed/gallery/part/f$f", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/b;", "", "content", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/i;", "inputArgs", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Lkotlin/collections/ArrayList;", AEEditorConstants.KEY_WINK_LOCAL_MEDIA_INFOS, "", "originalPic", "", "b", "(Ljava/lang/String;Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/i;Ljava/util/ArrayList;Ljava/lang/Boolean;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.gallery.part.f$f, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static final class C7743f implements com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.b {
        C7743f() {
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.b
        public boolean a(@NotNull Intent intent) {
            return b.a.a(this, intent);
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x001c, code lost:
        
            if (r2 == false) goto L17;
         */
        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void b(@Nullable String content, @Nullable ShowInputComponentArgs inputArgs, @Nullable ArrayList<LocalMediaInfo> localMediaInfos, @Nullable Boolean originalPic) {
            boolean z16;
            boolean z17;
            boolean z18;
            boolean z19;
            boolean z26 = false;
            if (content != null && content.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                if (localMediaInfos != null && !localMediaInfos.isEmpty()) {
                    z19 = false;
                } else {
                    z19 = true;
                }
            }
            if (inputArgs != null) {
                NativeDetailInputWindowDirector nativeDetailInputWindowDirector = f.this.inputDirector;
                SendInputContentExtData sendInputContentExtData = null;
                if (nativeDetailInputWindowDirector != null) {
                    String guildId = nativeDetailInputWindowDirector.f().getString("guild_id", "");
                    String channelId = nativeDetailInputWindowDirector.f().getString("channel_id", "");
                    String feedId = nativeDetailInputWindowDirector.f().getString("feed_id", "");
                    Intrinsics.checkNotNullExpressionValue(guildId, "guildId");
                    if (guildId.length() > 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        Intrinsics.checkNotNullExpressionValue(channelId, "channelId");
                        if (channelId.length() > 0) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        if (z18) {
                            Intrinsics.checkNotNullExpressionValue(feedId, "feedId");
                            if (feedId.length() > 0) {
                                z26 = true;
                            }
                            if (z26) {
                                sendInputContentExtData = new SendInputContentExtData(guildId, channelId, feedId);
                            }
                        }
                    }
                }
                f.this.broadcastMessage("message_try_to_send_input_content", new a.TryToSendInputContentMessage(true, inputArgs, content, sendInputContentExtData, localMediaInfos, originalPic));
                NativeDetailInputWindowDirector nativeDetailInputWindowDirector2 = f.this.inputDirector;
                if (nativeDetailInputWindowDirector2 != null) {
                    nativeDetailInputWindowDirector2.l();
                    return;
                }
                return;
            }
            QLog.e("Guild_Feed_GAL_GuildFeedGalleryInputDialogPart", 1, "sendCallback invoke args error!");
        }
    }

    public f() {
        super(null, 1, null);
        this.inputStatus = 1;
        this.sendCallback = new C7743f();
        this.dismissCallback = new e();
    }

    private final void G9() {
        this.draftManager = null;
    }

    private final void H9() {
        NativeDetailInputWindowDirector nativeDetailInputWindowDirector = this.inputDirector;
        if (nativeDetailInputWindowDirector != null) {
            nativeDetailInputWindowDirector.k();
        }
        this.inputDirector = null;
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

    private final int J9(int extOperate) {
        if (extOperate != 1 && extOperate != 2) {
            if (Build.VERSION.SDK_INT >= 30) {
                return 48;
            }
            return 16;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            return 50;
        }
        return 18;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean K9() {
        LocalMediaInfo localMediaInfo;
        GuildFeedDetailCommentDraftManager guildFeedDetailCommentDraftManager = this.draftManager;
        if (guildFeedDetailCommentDraftManager != null) {
            localMediaInfo = guildFeedDetailCommentDraftManager.a(z9().getFeedId());
        } else {
            localMediaInfo = null;
        }
        if (localMediaInfo != null) {
            return true;
        }
        return false;
    }

    private final void L9(ShowInputDialogParam param) {
        if (this.inputDirector == null) {
            NativeDetailInputWindowDirector nativeDetailInputWindowDirector = new NativeDetailInputWindowDirector();
            Bundle f16 = nativeDetailInputWindowDirector.f();
            f16.putString("guild_id", param.getGuildId());
            f16.putString("channel_id", param.getChannelId());
            f16.putString("feed_id", param.getFeedId());
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            nativeDetailInputWindowDirector.i(context);
            nativeDetailInputWindowDirector.y(J9(param.getArgs().getExtOperate()));
            nativeDetailInputWindowDirector.t(param.getHostViewHeight());
            nativeDetailInputWindowDirector.m(this.dismissCallback);
            Object b16 = nativeDetailInputWindowDirector.getRouter().b(com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor.d.class);
            Intrinsics.checkNotNull(b16);
            ((com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor.d) b16).l(I9());
            Object b17 = nativeDetailInputWindowDirector.getRouter().b(SendButtonActor.class);
            Intrinsics.checkNotNull(b17);
            ((SendButtonActor) b17).l(this.sendCallback);
            gl1.b reporter = nativeDetailInputWindowDirector.getReporter();
            if (reporter != null) {
                reporter.b(new b(this.inputStatus));
            }
            this.inputDirector = nativeDetailInputWindowDirector;
        }
    }

    private final void M9(ShowInputDialogParam param) {
        AppInterface appInterface;
        boolean z16;
        IGProGuildInfo guildInfo;
        QLog.i("Guild_Feed_GAL_GuildFeedGalleryInputDialogPart", 1, "showInputDialog param:" + param);
        this.inputStatus = 2;
        H9();
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
        if (iGPSService != null && (guildInfo = iGPSService.getGuildInfo(param.getGuildId())) != null) {
            z16 = guildInfo.isMember();
        } else {
            z16 = false;
        }
        QLog.i("Guild_Feed_GAL_GuildFeedGalleryInputDialogPart", 1, "showInputComponent isMember = " + z16 + " guildid = " + param.getGuildId());
        L9(param);
        NativeDetailInputWindowDirector nativeDetailInputWindowDirector = this.inputDirector;
        Intrinsics.checkNotNull(nativeDetailInputWindowDirector);
        nativeDetailInputWindowDirector.x(new ColorDrawable(getContext().getResources().getColor(R.color.qui_common_fill_allblack_medium)));
        nativeDetailInputWindowDirector.s(z16);
        Bitmap hostViewBitmap = param.getHostViewBitmap();
        if (hostViewBitmap != null) {
            nativeDetailInputWindowDirector.w(hostViewBitmap);
        }
        nativeDetailInputWindowDirector.u(param.getArgs());
        nativeDetailInputWindowDirector.v(z16);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        NativeDetailInputWindowDirector nativeDetailInputWindowDirector;
        if (action != null) {
            int hashCode = action.hashCode();
            if (hashCode != -1293070281) {
                if (hashCode != 3323268) {
                    if (hashCode == 1179209504 && action.equals("message_clear_input") && (nativeDetailInputWindowDirector = this.inputDirector) != null) {
                        nativeDetailInputWindowDirector.q();
                        return;
                    }
                    return;
                }
                if (action.equals("message_on_page_select")) {
                    H9();
                    G9();
                    return;
                }
                return;
            }
            if (action.equals("message_on_show_input_dialog")) {
                Intrinsics.checkNotNull(args, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.gallery.part.GuildFeedGalleryInputDialogPart.ShowInputDialogParam");
                M9((ShowInputDialogParam) args);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        QLog.i("Guild_Feed_GAL_GuildFeedGalleryInputDialogPart", 1, "onActivityResult");
        NativeDetailInputWindowDirector nativeDetailInputWindowDirector = this.inputDirector;
        if (nativeDetailInputWindowDirector != null) {
            nativeDetailInputWindowDirector.j(requestCode, resultCode, data);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        H9();
        G9();
    }
}

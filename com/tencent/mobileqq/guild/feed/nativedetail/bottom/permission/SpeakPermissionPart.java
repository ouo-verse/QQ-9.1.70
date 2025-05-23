package com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartIOCKt;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.api.IGuildMuteApi;
import com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedPublishInfo;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.ShowInputComponentArgs;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.handler.SpeakPermissionInputHandler;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a;
import com.tencent.mobileqq.guild.feed.util.ae;
import com.tencent.mobileqq.guild.feed.util.bn;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.api.IGProGlobalService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import el1.a;
import java.util.HashSet;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import tl1.g;
import wk1.i;
import wk1.l;
import yl1.n;

@Metadata(d1 = {"\u0000{\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\t*\u0003BFP\b\u0016\u0018\u0000 V2\u00020\u0001:\u0001WB\u0007\u00a2\u0006\u0004\bT\u0010UJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J$\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\u0018\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0012\u0010\u001c\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0014J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001fH\u0004J\u0010\u0010\"\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u001fH\u0014J\u001c\u0010$\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010'\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010%H\u0016R\"\u0010.\u001a\u00020\u00078\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u0010)R\u0016\u00102\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u0010)R\u0016\u00105\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00107\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00104R\u0016\u0010:\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010=\u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010E\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010I\u001a\u00020F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u001b\u0010O\u001a\u00020J8DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010NR\u0014\u0010S\u001a\u00020P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010R\u00a8\u0006X"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/SpeakPermissionPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lrl1/a;", "D9", "", "initData", "K9", "", "updateSource", "", "useCache", "needLog", "Q9", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/SpeakPermissionType;", "newSpeakPermission", "M9", "", "args", "J9", "H9", "G9", "I9", QCircleDaTongConstant.ElementParamValue.PERMISSION, "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/i;", "inputArgs", "L9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/handler/SpeakPermissionInputHandler;", "E9", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "P9", "C9", "action", "handleBroadcastMessage", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "d", "Ljava/lang/String;", "getFeedId", "()Ljava/lang/String;", "O9", "(Ljava/lang/String;)V", "feedId", "e", "guildId", "f", "channelId", h.F, "Z", "isFeedAllowComment", "i", "isPosterSelf", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/SpeakPermissionType;", "curSpeakPermission", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/handler/SpeakPermissionInputHandler;", "speakPermissionInputHandler", "Lkotlinx/coroutines/Job;", "D", "Lkotlinx/coroutines/Job;", "checkSpeakPermissionUpdateJob", "com/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/SpeakPermissionPart$b", "E", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/SpeakPermissionPart$b;", "serviceObserver", "com/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/SpeakPermissionPart$d", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/SpeakPermissionPart$d;", "speakThresholdUpdateListener", "Lwk1/l;", "G", "Lkotlin/Lazy;", "F9", "()Lwk1/l;", "inputMessageDelegate", "com/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/SpeakPermissionPart$c", "H", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/SpeakPermissionPart$c;", "speakInputContextProvider", "<init>", "()V", "I", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class SpeakPermissionPart extends Part {

    /* renamed from: C, reason: from kotlin metadata */
    private SpeakPermissionInputHandler speakPermissionInputHandler;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private volatile Job checkSpeakPermissionUpdateJob;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy inputMessageDelegate;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final c speakInputContextProvider;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    protected String feedId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String guildId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String channelId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isFeedAllowComment = true;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isPosterSelf = true;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private SpeakPermissionType curSpeakPermission = SpeakPermissionType.PERMISSION_TYPE_INVALID;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final b serviceObserver = new b();

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final d speakThresholdUpdateListener = new d();

    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J\u0012\u0010\t\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\f\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u001a\u0010\u0011\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J\u001a\u0010\u0014\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0014J\u0012\u0010\u0015\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\u0016\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u001a\u0010\u0018\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u000fH\u0014J\u0012\u0010\u0019\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\u001a"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/SpeakPermissionPart$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "admint", "", "bAdmin", "", "onAdminChanged", "onGuildInfoUpdated", "channelUin", "onChannelInfoUpdated", "onChannelListUpdated", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "info", "", "sourceType", "onAddGuildWithInfo", "", "expireTime", "onShutUpStateChanged", "onRemoveGuild", "onDestoryGuild", "black", "onBeKickFromGuild", "onDeleteGuild", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onAddGuildWithInfo(@Nullable IGProGuildInfo info, int sourceType) {
            String str = SpeakPermissionPart.this.guildId;
            String str2 = null;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildId");
                str = null;
            }
            if (info != null) {
                str2 = info.getGuildID();
            }
            if (!Intrinsics.areEqual(str, str2)) {
                return;
            }
            SpeakPermissionPart.R9(SpeakPermissionPart.this, "onAddGuildWithInfo", false, false, 6, null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onAdminChanged(@Nullable String guildId, @Nullable String admint, boolean bAdmin) {
            String str = SpeakPermissionPart.this.guildId;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildId");
                str = null;
            }
            if (!Intrinsics.areEqual(str, guildId)) {
                return;
            }
            SpeakPermissionPart.R9(SpeakPermissionPart.this, "onAdminChanged", false, false, 6, null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onBeKickFromGuild(@Nullable String guildId, int black) {
            String str = SpeakPermissionPart.this.guildId;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildId");
                str = null;
            }
            if (Intrinsics.areEqual(str, guildId)) {
                SpeakPermissionPart.R9(SpeakPermissionPart.this, "onBeKickFromGuild", false, false, 6, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelInfoUpdated(@Nullable String channelUin) {
            String str = SpeakPermissionPart.this.channelId;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelId");
                str = null;
            }
            if (!Intrinsics.areEqual(str, channelUin)) {
                return;
            }
            SpeakPermissionPart.R9(SpeakPermissionPart.this, "onChannelInfoUpdated", false, false, 6, null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelListUpdated(@Nullable String guildId) {
            String str = SpeakPermissionPart.this.guildId;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildId");
                str = null;
            }
            if (!Intrinsics.areEqual(str, guildId)) {
                return;
            }
            SpeakPermissionPart.R9(SpeakPermissionPart.this, "onChannelListUpdated", false, false, 2, null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDeleteGuild(@Nullable String guildId) {
            String str = SpeakPermissionPart.this.guildId;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildId");
                str = null;
            }
            if (Intrinsics.areEqual(str, guildId)) {
                SpeakPermissionPart.R9(SpeakPermissionPart.this, "onDeleteGuild", false, false, 6, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDestoryGuild(@Nullable String guildId) {
            String str = SpeakPermissionPart.this.guildId;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildId");
                str = null;
            }
            if (Intrinsics.areEqual(str, guildId)) {
                SpeakPermissionPart.R9(SpeakPermissionPart.this, "onDestroyGuild", false, false, 6, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildInfoUpdated(@Nullable String guildId) {
            String str = SpeakPermissionPart.this.guildId;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildId");
                str = null;
            }
            if (!Intrinsics.areEqual(str, guildId)) {
                return;
            }
            SpeakPermissionPart.R9(SpeakPermissionPart.this, "onGuildInfoUpdated", false, false, 2, null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onRemoveGuild(@Nullable String guildId) {
            String str = SpeakPermissionPart.this.guildId;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildId");
                str = null;
            }
            if (Intrinsics.areEqual(str, guildId)) {
                SpeakPermissionPart.R9(SpeakPermissionPart.this, "onRemoveGuild", false, false, 6, null);
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onShutUpStateChanged(@Nullable String guildId, long expireTime) {
            String str = SpeakPermissionPart.this.guildId;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildId");
                str = null;
            }
            if (!Intrinsics.areEqual(str, guildId)) {
                return;
            }
            SpeakPermissionPart.R9(SpeakPermissionPart.this, "onShutUpStateChanged", false, false, 6, null);
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0014\u0010\r\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\bR\u0014\u0010\u0011\u001a\u00020\u000e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0012"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/SpeakPermissionPart$c", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/handler/a;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "", "getGuildId", "()Ljava/lang/String;", "guildId", "getChannelId", "channelId", "getTroopUin", "troopUin", "Lwk1/i;", "getDelegate", "()Lwk1/i;", "delegate", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.handler.a {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.handler.a
        @NotNull
        public String getChannelId() {
            String str = SpeakPermissionPart.this.channelId;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelId");
                return null;
            }
            return str;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.handler.a
        @NotNull
        public Context getContext() {
            Context context = SpeakPermissionPart.this.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "this@SpeakPermissionPart.context");
            return context;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.handler.a
        @NotNull
        public i getDelegate() {
            return SpeakPermissionPart.this.F9();
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.handler.a
        @NotNull
        public String getGuildId() {
            String str = SpeakPermissionPart.this.guildId;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildId");
                return null;
            }
            return str;
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.handler.a
        @NotNull
        public String getTroopUin() {
            return "";
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\b\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0016J(\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00020\tj\b\u0012\u0004\u0012\u00020\u0002`\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/SpeakPermissionPart$d", "Lcom/tencent/mobileqq/guild/api/IGuildSpeakThresholdApi$a;", "", "guildId", "", "M", "", "guildIds", "G", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "channelIds", "E", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d implements IGuildSpeakThresholdApi.a {
        d() {
        }

        @Override // com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi.a
        public void E(@NotNull String guildId, @NotNull HashSet<String> channelIds) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelIds, "channelIds");
            String str = SpeakPermissionPart.this.guildId;
            String str2 = null;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildId");
                str = null;
            }
            if (Intrinsics.areEqual(str, guildId)) {
                String str3 = SpeakPermissionPart.this.channelId;
                if (str3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("channelId");
                } else {
                    str2 = str3;
                }
                if (channelIds.contains(str2)) {
                    SpeakPermissionPart.R9(SpeakPermissionPart.this, "onSpeakThresholdUpdate channel list", false, false, 6, null);
                }
            }
        }

        @Override // com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi.a
        public void G(@NotNull List<String> guildIds) {
            boolean contains$default;
            Intrinsics.checkNotNullParameter(guildIds, "guildIds");
            String str = SpeakPermissionPart.this.guildId;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildId");
                str = null;
            }
            String str2 = SpeakPermissionPart.this.guildId;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildId");
                str2 = null;
            }
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) str2, false, 2, (Object) null);
            if (!contains$default) {
                return;
            }
            SpeakPermissionPart.R9(SpeakPermissionPart.this, "onSpeakThresholdUpdate guild list", false, false, 6, null);
        }

        @Override // com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi.a
        public void M(@NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            String str = SpeakPermissionPart.this.guildId;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildId");
                str = null;
            }
            if (!Intrinsics.areEqual(str, guildId)) {
                return;
            }
            SpeakPermissionPart.R9(SpeakPermissionPart.this, "onSpeakThresholdUpdate", false, false, 2, null);
        }
    }

    public SpeakPermissionPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<l>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.SpeakPermissionPart$inputMessageDelegate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final l invoke() {
                return new l(SpeakPermissionPart.this);
            }
        });
        this.inputMessageDelegate = lazy;
        this.speakInputContextProvider = new c();
    }

    private final rl1.a D9() {
        return (rl1.a) PartIOCKt.getIocInterface(this, rl1.a.class);
    }

    private final void G9(Object args) {
        if (!(args instanceof a.CommentFeedMessage)) {
            QLog.i("SpeakPermissionPart", 1, "handleCommentFeedMessage args error!");
            return;
        }
        a.CommentFeedMessage commentFeedMessage = (a.CommentFeedMessage) args;
        QLog.i("SpeakPermissionPart", 1, "handleCommentFeedMessage, source = " + commentFeedMessage.getSource());
        if (L9(this.curSpeakPermission, commentFeedMessage.getInputArgs())) {
            return;
        }
        SpeakPermissionInputHandler speakPermissionInputHandler = this.speakPermissionInputHandler;
        if (speakPermissionInputHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("speakPermissionInputHandler");
            speakPermissionInputHandler = null;
        }
        speakPermissionInputHandler.c(this.curSpeakPermission, commentFeedMessage.getInputArgs());
    }

    private final void H9(Object args) {
        boolean z16;
        int i3;
        Boolean d16;
        if (!(args instanceof a.CommentFeedMessage)) {
            QLog.i("SpeakPermissionPart", 1, "handleCommentIconClick args error!");
            return;
        }
        rl1.a D9 = D9();
        if (D9 != null && (d16 = D9.d()) != null) {
            z16 = d16.booleanValue();
        } else {
            z16 = true;
        }
        rl1.a D92 = D9();
        if (D92 != null) {
            i3 = D92.c();
        } else {
            i3 = 2;
        }
        QLog.i("SpeakPermissionPart", 1, "handleCommentIconClick needScrollToCommentArea=" + z16);
        if (z16) {
            broadcastMessage("message_content_list_scroll_to_pos", new g.ScrollToPositionMessageData(i3, true));
            return;
        }
        a.CommentFeedMessage commentFeedMessage = (a.CommentFeedMessage) args;
        if (L9(this.curSpeakPermission, commentFeedMessage.getInputArgs())) {
            return;
        }
        SpeakPermissionInputHandler speakPermissionInputHandler = this.speakPermissionInputHandler;
        if (speakPermissionInputHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("speakPermissionInputHandler");
            speakPermissionInputHandler = null;
        }
        speakPermissionInputHandler.c(this.curSpeakPermission, commentFeedMessage.getInputArgs());
    }

    private final void I9(Object args) {
        if (!(args instanceof g.UpdateFeedAllowCommentMessage)) {
            return;
        }
        g.UpdateFeedAllowCommentMessage updateFeedAllowCommentMessage = (g.UpdateFeedAllowCommentMessage) args;
        this.isFeedAllowComment = updateFeedAllowCommentMessage.getIsAllowComment();
        this.isPosterSelf = updateFeedAllowCommentMessage.getIsFeedPosterSelf();
    }

    private final void J9(Object args) {
        if (!(args instanceof a.ReplyCommentMessage)) {
            QLog.i("SpeakPermissionPart", 1, "handleReplyCommentMessage args error!");
            return;
        }
        a.ReplyCommentMessage replyCommentMessage = (a.ReplyCommentMessage) args;
        QLog.i("SpeakPermissionPart", 1, "handleReplyCommentMessage, source = " + replyCommentMessage.getSource());
        if (L9(this.curSpeakPermission, replyCommentMessage.getInputArgs())) {
            return;
        }
        SpeakPermissionInputHandler speakPermissionInputHandler = this.speakPermissionInputHandler;
        if (speakPermissionInputHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("speakPermissionInputHandler");
            speakPermissionInputHandler = null;
        }
        speakPermissionInputHandler.c(this.curSpeakPermission, replyCommentMessage.getInputArgs());
    }

    private final void K9() {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IGProGuildInfo iGProGuildInfo = null;
        String str = null;
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
            } else {
                str = str2;
            }
            iGProGuildInfo = iGPSService.getGuildInfo(str);
        }
        boolean z16 = false;
        if (iGProGuildInfo != null && iGProGuildInfo.isMember()) {
            z16 = true;
        }
        if (z16) {
            P9(iGProGuildInfo);
        } else {
            M9(SpeakPermissionType.PERMISSION_TYPE_SIMPLE_INIT);
            R9(this, "init", false, false, 4, null);
        }
    }

    private final boolean L9(SpeakPermissionType permission, ShowInputComponentArgs inputArgs) {
        String str;
        if (permission != SpeakPermissionType.PERMISSION_TYPE_NORMAL || this.isFeedAllowComment || this.isPosterSelf) {
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

    private final void M9(SpeakPermissionType newSpeakPermission) {
        if (newSpeakPermission == this.curSpeakPermission) {
            return;
        }
        this.curSpeakPermission = newSpeakPermission;
        broadcastMessage("message_on_speak_permission_changed", new a.OnSpeakPermissionChangedMessage(newSpeakPermission));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Q9(String updateSource, boolean useCache, boolean needLog) {
        if (needLog) {
            QLog.i("SpeakPermissionPart", 1, "updateSpeakPermission. source = " + updateSource);
        }
        Job job = null;
        String str = null;
        if (useCache) {
            String str2 = this.guildId;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildId");
                str2 = null;
            }
            IGProGuildInfo L = ch.L(str2);
            if (L == null) {
                String str3 = this.guildId;
                if (str3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("guildId");
                } else {
                    str = str3;
                }
                QLog.d("SpeakPermissionPart", 2, "[updateSpeakPermission], useCache but cache miss, " + str);
                return;
            }
            LifecycleCoroutineScope e16 = com.tencent.mobileqq.guild.feed.part.a.e(this);
            if (e16 != null) {
                BuildersKt__Builders_commonKt.launch$default(e16, ae.a().e().getImmediate(), null, new SpeakPermissionPart$updateSpeakPermission$1(this, L, null), 2, null);
                return;
            }
            return;
        }
        Job job2 = this.checkSpeakPermissionUpdateJob;
        if (job2 != null && !job2.isCompleted()) {
            QLog.i("SpeakPermissionPart", 1, "already has an incomplete update job");
            return;
        }
        LifecycleCoroutineScope e17 = com.tencent.mobileqq.guild.feed.part.a.e(this);
        if (e17 != null) {
            job = BuildersKt__Builders_commonKt.launch$default(e17, ae.a().c(), null, new SpeakPermissionPart$updateSpeakPermission$2(this, updateSource, useCache, null), 2, null);
        }
        this.checkSpeakPermissionUpdateJob = job;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void R9(SpeakPermissionPart speakPermissionPart, String str, boolean z16, boolean z17, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                z16 = true;
            }
            if ((i3 & 4) != 0) {
                z17 = true;
            }
            speakPermissionPart.Q9(str, z16, z17);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateSpeakPermission");
    }

    private final void initData() {
        AppInterface appInterface;
        Bundle h16 = GuildSplitViewUtils.f235370a.h(getPartHost());
        String string = h16.getString("feed_id", "");
        if (string == null) {
            string = "";
        }
        O9(string);
        String string2 = h16.getString("guild_id", "");
        if (string2 == null) {
            string2 = "";
        }
        this.guildId = string2;
        String string3 = h16.getString("channel_id", "");
        if (string3 == null) {
            string3 = "";
        }
        this.channelId = string3;
        this.speakPermissionInputHandler = E9();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGProGlobalService.class, "");
        }
        IGProGlobalService iGProGlobalService = (IGProGlobalService) iRuntimeService;
        if (iGProGlobalService != null) {
            iGProGlobalService.addObserver(this.serviceObserver);
        }
        ((IGuildSpeakThresholdApi) QRoute.api(IGuildSpeakThresholdApi.class)).addListener(this.speakThresholdUpdateListener);
    }

    @NotNull
    protected SpeakPermissionType C9(@NotNull IGProGuildInfo guildInfo) {
        Intrinsics.checkNotNullParameter(guildInfo, "guildInfo");
        String str = this.guildId;
        String str2 = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildId");
            str = null;
        }
        String str3 = this.channelId;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelId");
        } else {
            str2 = str3;
        }
        return new el1.a(new a.Companion.Args(str, str2)).b(guildInfo);
    }

    @NotNull
    protected SpeakPermissionInputHandler E9() {
        return new SpeakPermissionInputHandler(this.speakInputContextProvider);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final l F9() {
        return (l) this.inputMessageDelegate.getValue();
    }

    protected final void O9(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.feedId = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void P9(@NotNull IGProGuildInfo guildInfo) {
        Intrinsics.checkNotNullParameter(guildInfo, "guildInfo");
        M9(C9(guildInfo));
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        GuildFeedPublishInfo q16 = n.q(GuildSplitViewUtils.f235370a.h(getPartHost()));
        if (action != null) {
            switch (action.hashCode()) {
                case -729901398:
                    if (!action.equals("message_comment_box_feed") || bn.f223895a.d(q16)) {
                        return;
                    }
                    G9(args);
                    return;
                case -35842170:
                    if (action.equals("message_update_feed_allow_comment")) {
                        I9(args);
                        return;
                    }
                    return;
                case 667130252:
                    if (!action.equals("message_comment_icon_feed") || bn.f223895a.d(q16)) {
                        return;
                    }
                    H9(args);
                    return;
                case 1409275858:
                    if (action.equals("message_reply_comment")) {
                        J9(args);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        initData();
        K9();
        IGuildMuteApi iGuildMuteApi = (IGuildMuteApi) QRoute.api(IGuildMuteApi.class);
        String str = this.guildId;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildId");
            str = null;
        }
        e12.a<Long> selfGuildMuteLiveData = iGuildMuteApi.getSelfGuildMuteLiveData(str);
        LifecycleOwner c16 = com.tencent.mobileqq.guild.feed.part.a.c(this);
        final Function1<Long, Unit> function1 = new Function1<Long, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.SpeakPermissionPart$onInitView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                invoke2(l3);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Long l3) {
                SpeakPermissionPart.R9(SpeakPermissionPart.this, "onMuteStateUpdate", false, false, 2, null);
            }
        };
        selfGuildMuteLiveData.observe(c16, new Observer() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SpeakPermissionPart.N9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
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
            iRuntimeService = appInterface.getRuntimeService(IGProGlobalService.class, "");
        }
        IGProGlobalService iGProGlobalService = (IGProGlobalService) iRuntimeService;
        if (iGProGlobalService != null) {
            iGProGlobalService.deleteObserver(this.serviceObserver);
        }
        ((IGuildSpeakThresholdApi) QRoute.api(IGuildSpeakThresholdApi.class)).removeListener(this.speakThresholdUpdateListener);
    }
}

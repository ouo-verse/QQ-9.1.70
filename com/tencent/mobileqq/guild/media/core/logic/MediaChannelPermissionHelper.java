package com.tencent.mobileqq.guild.media.core.logic;

import android.text.TextUtils;
import android.util.Log;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi;
import com.tencent.mobileqq.guild.media.core.MediaChannelUtils;
import com.tencent.mobileqq.guild.media.core.logic.MediaChannelRaiseHandHelper;
import com.tencent.mobileqq.guild.media.core.notify.SwitchThemeEvent;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.dx;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.avatar.EngineLoadingScene;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000w\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\t*\u0003CKR\u0018\u0000 %2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002XYB\u000f\u0012\u0006\u00108\u001a\u000205\u00a2\u0006\u0004\bV\u0010WJ&\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rJ\u001a\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u0007J\u0006\u0010\u0013\u001a\u00020\u0007J\u0006\u0010\u0014\u001a\u00020\u0007J\u0006\u0010\u0015\u001a\u00020\u0007J\u001a\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u0007J\u0006\u0010\u0017\u001a\u00020\u0007J\u0006\u0010\u0018\u001a\u00020\u0007J\u0006\u0010\u0019\u001a\u00020\u0007J\u0006\u0010\u001a\u001a\u00020\u0007J\u0006\u0010\u001b\u001a\u00020\u0007J\u0006\u0010\u001c\u001a\u00020\u0007J\b\u0010\u001d\u001a\u00020\u000bH\u0016J\b\u0010\u001e\u001a\u00020\u000bH\u0016J\b\u0010\u001f\u001a\u00020\u000bH\u0016J\u0006\u0010 \u001a\u00020\u000bJ\u0006\u0010!\u001a\u00020\u000bJ\u0010\u0010\"\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0016\u0010%\u001a\u00020\u000b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040#H\u0016J(\u0010)\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0016\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u00040&j\b\u0012\u0004\u0012\u00020\u0004`'H\u0016J\b\u0010*\u001a\u00020\u000bH\u0002J\u0010\u0010+\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J\u0010\u0010,\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010-\u001a\u00020\u0007H\u0002J\b\u0010.\u001a\u00020\u0007H\u0002J\b\u0010/\u001a\u00020\u0007H\u0002J\b\u00100\u001a\u00020\u0007H\u0002J\b\u00101\u001a\u00020\u0007H\u0002J\b\u00102\u001a\u00020\u0007H\u0002J\b\u00103\u001a\u00020\u0007H\u0002J\b\u00104\u001a\u00020\u0007H\u0002R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u001a\u0010<\u001a\b\u0012\u0004\u0012\u0002090#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010?\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010B\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010F\u001a\u00020C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u001a\u0010J\u001a\b\u0012\u0004\u0012\u00020\t0G8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0014\u0010N\u001a\u00020K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0014\u0010Q\u001a\u00020O8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010PR\u0014\u0010U\u001a\u00020R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bS\u0010T\u00a8\u0006Z"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelPermissionHelper;", "Lcom/tencent/mobileqq/guild/media/core/g;", "Lcom/tencent/mobileqq/guild/api/IGuildSpeakThresholdApi$a;", "Lcom/tencent/mobileqq/guild/media/core/logic/h;", "", "guildId", "tinyId", "", "bAllow", "", "source", "", "M0", "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelPermissionHelper$PermissionChangeType;", "changeType", "S0", "canRaiseHand", "canJoinMicQueue", "T", "X", "Y", "P0", "W", "b0", "i0", "H0", "d0", "f0", "c0", "E0", "p", "u", "T0", "U0", "M", "", "guildIds", "G", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "channelIds", "E", "V0", "J0", "W0", "F0", "j0", "l0", "O0", "e0", "Q0", "a0", "I0", "Lcom/tencent/mobileqq/guild/media/core/f;", "e", "Lcom/tencent/mobileqq/guild/media/core/f;", "mediaChannelCore", "", "f", "Ljava/util/List;", "registerSpecialThemeList", tl.h.F, "Z", "selfTalkPermission", "i", "Ljava/lang/Boolean;", "isLimitBySpeakThreshold", "com/tencent/mobileqq/guild/media/core/logic/MediaChannelPermissionHelper$d", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelPermissionHelper$d;", "speakThresholdListener", "Landroidx/lifecycle/Observer;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/Observer;", "muteObserver", "com/tencent/mobileqq/guild/media/core/logic/MediaChannelPermissionHelper$c", "D", "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelPermissionHelper$c;", "observer", "Lcom/tencent/mobileqq/guild/media/core/notify/y;", "Lcom/tencent/mobileqq/guild/media/core/notify/y;", "mAudioRoomObserver", "com/tencent/mobileqq/guild/media/core/logic/MediaChannelPermissionHelper$e", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelPermissionHelper$e;", "switchThemeEventObserver", "<init>", "(Lcom/tencent/mobileqq/guild/media/core/f;)V", "a", "PermissionChangeType", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MediaChannelPermissionHelper extends h implements IGuildSpeakThresholdApi.a {

    /* renamed from: C */
    @NotNull
    private final Observer<Long> muteObserver;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final c observer;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.media.core.notify.y mAudioRoomObserver;

    /* renamed from: F */
    @NotNull
    private final e switchThemeEventObserver;

    /* renamed from: e, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.media.core.f mediaChannelCore;

    /* renamed from: f, reason: from kotlin metadata */
    @NotNull
    private final List<Integer> registerSpecialThemeList;

    /* renamed from: h */
    private boolean selfTalkPermission;

    /* renamed from: i, reason: from kotlin metadata */
    @Nullable
    private Boolean isLimitBySpeakThreshold;

    /* renamed from: m */
    @NotNull
    private final d speakThresholdListener;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/logic/MediaChannelPermissionHelper$PermissionChangeType;", "", "(Ljava/lang/String;I)V", com.tencent.tmdownloader.a.CONNTECTSTATE_INIT, EngineLoadingScene.ROLE, "MUTE", "THRESHOLD", "BAN", "RAISE_HAND", "USER_LIST", "THEME", "THIRD_APP", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public enum PermissionChangeType {
        INIT,
        ROLE,
        MUTE,
        THRESHOLD,
        BAN,
        RAISE_HAND,
        USER_LIST,
        THEME,
        THIRD_APP
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/MediaChannelPermissionHelper$b", "Lcom/tencent/mobileqq/guild/media/core/notify/y;", "", "from", "guildId", "channelId", "Lcom/tencent/mobileqq/guild/media/core/data/f;", "localUserInfo", "", HippyTKDListViewAdapter.X, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends com.tencent.mobileqq.guild.media.core.notify.y {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.y
        public void x(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable com.tencent.mobileqq.guild.media.core.data.f fVar) {
            if (Intrinsics.areEqual("onFetchAudioChannelUserList", str)) {
                QLog.i("QGMC.Core.MediaChannelPermissionHelper", 1, "[onUserDataUpdate]");
                MediaChannelPermissionHelper.this.W0(PermissionChangeType.USER_LIST);
            }
        }
    }

    @Metadata(d1 = {"\u0000=\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0014J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u001a\u0010\u0010\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0014J\u001c\u0010\u0013\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014J\u001a\u0010\u0016\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0014\u00a8\u0006\u0017"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/MediaChannelPermissionHelper$c", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "admint", "", "bAdmin", "", "onAdminChanged", "channelUin", "onChannelInfoUpdated", "onChannelListUpdated", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "info", "", "sourceType", "onAddGuildWithInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/dx;", QCircleDaTongConstant.ElementParamValue.PERMISSION, "onGuildPermissionChanged", "", "expireTime", "onShutUpStateChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c extends GPServiceObserver {
        c() {
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onAddGuildWithInfo(@Nullable IGProGuildInfo info, int sourceType) {
            String str;
            String str2 = null;
            if (info != null) {
                str = info.getGuildID();
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                if (info != null) {
                    str2 = info.getGuildID();
                }
                if (Intrinsics.areEqual(str2, MediaChannelPermissionHelper.this.mediaChannelCore.getGuildID())) {
                    Logger.f235387a.d().i("QGMC.Core.MediaChannelPermissionHelper", 1, "onAddGuildWithInfo: guildId[" + info + "?.guildID]");
                    MediaChannelPermissionHelper.this.W0(PermissionChangeType.ROLE);
                }
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onAdminChanged(@NotNull String guildId, @NotNull String admint, boolean bAdmin) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(admint, "admint");
            if (TextUtils.equals(MediaChannelPermissionHelper.this.mediaChannelCore.getGuildID(), guildId)) {
                Logger.f235387a.d().i("QGMC.Core.MediaChannelPermissionHelper", 1, "onAdminChanged: guildId[" + guildId + "]");
                MediaChannelPermissionHelper.this.W0(PermissionChangeType.ROLE);
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelInfoUpdated(@NotNull String channelUin) {
            Intrinsics.checkNotNullParameter(channelUin, "channelUin");
            if (TextUtils.equals(MediaChannelPermissionHelper.this.mediaChannelCore.E(), channelUin)) {
                Logger.f235387a.d().i("QGMC.Core.MediaChannelPermissionHelper", 1, "onChannelInfoUpdated: channelUin[" + channelUin + "]");
                MediaChannelPermissionHelper.this.W0(PermissionChangeType.ROLE);
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelListUpdated(@NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            if (TextUtils.equals(MediaChannelPermissionHelper.this.mediaChannelCore.getGuildID(), guildId)) {
                Logger.f235387a.d().i("QGMC.Core.MediaChannelPermissionHelper", 1, "onChannelListUpdated: guildId[" + guildId + "]");
                MediaChannelPermissionHelper.this.W0(PermissionChangeType.ROLE);
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildPermissionChanged(@Nullable String guildId, @Nullable dx r46) {
            if (TextUtils.equals(MediaChannelPermissionHelper.this.mediaChannelCore.getGuildID(), guildId)) {
                Logger.f235387a.d().i("QGMC.Core.MediaChannelPermissionHelper", 1, "onGuildPermissionChanged: guildId[" + guildId + "]");
                MediaChannelPermissionHelper.this.W0(PermissionChangeType.ROLE);
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onShutUpStateChanged(@Nullable String guildId, long expireTime) {
            if (TextUtils.equals(MediaChannelPermissionHelper.this.mediaChannelCore.getGuildID(), guildId)) {
                Logger.f235387a.d().i("QGMC.Core.MediaChannelPermissionHelper", 1, "onShutUpStateChanged: guildId[" + guildId + "]");
                MediaChannelPermissionHelper.this.W0(PermissionChangeType.MUTE);
            }
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\b\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0016J(\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00020\tj\b\u0012\u0004\u0012\u00020\u0002`\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/MediaChannelPermissionHelper$d", "Lcom/tencent/mobileqq/guild/api/IGuildSpeakThresholdApi$a;", "", "guildId", "", "M", "", "guildIds", "G", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "channelIds", "E", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements IGuildSpeakThresholdApi.a {
        d() {
        }

        @Override // com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi.a
        public void E(@NotNull String guildId, @NotNull HashSet<String> channelIds) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelIds, "channelIds");
        }

        @Override // com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi.a
        public void G(@NotNull List<String> guildIds) {
            Intrinsics.checkNotNullParameter(guildIds, "guildIds");
            if (guildIds.contains(MediaChannelPermissionHelper.this.mediaChannelCore.getGuildID())) {
                MediaChannelPermissionHelper.this.V0();
            }
        }

        @Override // com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi.a
        public void M(@NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/core/logic/MediaChannelPermissionHelper$e", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/ar;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e implements com.tencent.mobileqq.guild.media.core.notify.o<SwitchThemeEvent> {
        e() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a */
        public void D0(@NotNull SwitchThemeEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            MediaChannelPermissionHelper.this.W0(PermissionChangeType.THEME);
        }
    }

    public MediaChannelPermissionHelper(@NotNull com.tencent.mobileqq.guild.media.core.f mediaChannelCore) {
        Intrinsics.checkNotNullParameter(mediaChannelCore, "mediaChannelCore");
        this.mediaChannelCore = mediaChannelCore;
        ArrayList arrayList = new ArrayList();
        arrayList.add(6);
        this.registerSpecialThemeList = arrayList;
        this.speakThresholdListener = new d();
        this.muteObserver = new Observer() { // from class: com.tencent.mobileqq.guild.media.core.logic.at
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MediaChannelPermissionHelper.R0(MediaChannelPermissionHelper.this, (Long) obj);
            }
        };
        this.observer = new c();
        this.mAudioRoomObserver = new b();
        this.switchThemeEventObserver = new e();
    }

    private final boolean F0() {
        Logger.f235387a.d().d("QGMC.Core.MediaChannelPermissionHelper", 4, "checkSpecialThemeRegister: current theme type[" + com.tencent.mobileqq.guild.media.core.m.n(com.tencent.mobileqq.guild.media.core.j.c()) + "]");
        return this.registerSpecialThemeList.contains(Integer.valueOf(com.tencent.mobileqq.guild.media.core.m.n(com.tencent.mobileqq.guild.media.core.j.c())));
    }

    private final boolean I0() {
        return MediaChannelUtils.f228046a.D(this.mediaChannelCore.getSelfUserInfo().C.getUserAVInfo().getUserAVState());
    }

    private final boolean J0(boolean canRaiseHand) {
        boolean f06 = f0();
        boolean e06 = e0();
        Logger.f235387a.d().d("QGMC.Core.MediaChannelPermissionHelper", 4, "getRaiseHandRight canTalkByRole " + f06 + ", canTalkByApplyRight " + e06 + " ");
        if (canRaiseHand) {
            if (!f06 && !e06 && MediaChannelUtils.f228046a.n(com.tencent.mobileqq.guild.media.core.j.c().e()) != 4) {
                return false;
            }
            return true;
        }
        if (!f06 && !e06) {
            return false;
        }
        return true;
    }

    private final boolean O0() {
        if (this.mediaChannelCore.d0().m1() && this.mediaChannelCore.d0().n1()) {
            return true;
        }
        return false;
    }

    private final boolean Q0() {
        if (!com.tencent.mobileqq.guild.util.ch.m0(com.tencent.mobileqq.guild.media.core.j.a().getGuildID()) && !com.tencent.mobileqq.guild.util.ch.h0(com.tencent.mobileqq.guild.media.core.j.a().E()) && !MediaChannelUtils.f228046a.t(this.mediaChannelCore.getSelfUserInfo())) {
            return false;
        }
        return true;
    }

    public static final void R0(MediaChannelPermissionHelper this$0, Long l3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger.f235387a.d().i("QGMC.Core.MediaChannelPermissionHelper", 1, "guildMuteUpdate: time[" + l3 + "]");
        this$0.W0(PermissionChangeType.MUTE);
    }

    public static /* synthetic */ boolean U(MediaChannelPermissionHelper mediaChannelPermissionHelper, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        if ((i3 & 2) != 0) {
            z17 = false;
        }
        return mediaChannelPermissionHelper.T(z16, z17);
    }

    public final void V0() {
        this.isLimitBySpeakThreshold = Boolean.valueOf(sz1.d.k(this.mediaChannelCore.getGuildID(), this.mediaChannelCore.E()));
    }

    public final void W0(PermissionChangeType changeType) {
        if (changeType == PermissionChangeType.THRESHOLD) {
            V0();
        }
        this.selfTalkPermission = U(this, false, false, 3, null);
        Logger.f235387a.d().d("QGMC.Core.MediaChannelPermissionHelper", 4, "[notifyUpdateTalkPermission] selfTalkPermission " + this.selfTalkPermission + ", changeType " + changeType);
        this.mediaChannelCore.getEventBus().i(new com.tencent.mobileqq.guild.media.core.notify.bi(this.selfTalkPermission, changeType));
    }

    private final boolean a0() {
        if (!MediaChannelUtils.f228046a.u(this.mediaChannelCore.E()) || Q0()) {
            return true;
        }
        if (this.mediaChannelCore.getSelfUserInfo().E && I0()) {
            return true;
        }
        return false;
    }

    private final boolean e0() {
        if (this.mediaChannelCore.T().getSelfRaiseHandState() == MediaChannelRaiseHandHelper.RaiseHandState.PLAIN_USER_HAS_RIGHT) {
            return true;
        }
        return false;
    }

    private final boolean j0() {
        if (com.tencent.mobileqq.guild.media.core.m.n(com.tencent.mobileqq.guild.media.core.j.c()) == 6) {
            return this.mediaChannelCore.d0().m1();
        }
        return false;
    }

    private final boolean l0() {
        if (com.tencent.mobileqq.guild.media.core.m.n(com.tencent.mobileqq.guild.media.core.j.c()) == 6) {
            return O0();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi.a
    public void E(@NotNull String guildId, @NotNull HashSet<String> channelIds) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelIds, "channelIds");
        if (!TextUtils.equals(guildId, this.mediaChannelCore.getGuildID()) || !channelIds.contains(this.mediaChannelCore.E())) {
            return;
        }
        W0(PermissionChangeType.THRESHOLD);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.h, com.tencent.mobileqq.guild.media.core.g
    public void E0() {
        super.E0();
        W0(PermissionChangeType.INIT);
        T0();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi.a
    public void G(@NotNull List<String> guildIds) {
        String str;
        Intrinsics.checkNotNullParameter(guildIds, "guildIds");
        ListIterator<String> listIterator = guildIds.listIterator(guildIds.size());
        while (true) {
            if (listIterator.hasPrevious()) {
                str = listIterator.previous();
                if (TextUtils.equals(str, this.mediaChannelCore.getGuildID())) {
                    break;
                }
            } else {
                str = null;
                break;
            }
        }
        if (!TextUtils.isEmpty(str)) {
            W0(PermissionChangeType.THRESHOLD);
        }
    }

    public final boolean H0() {
        String guildID = this.mediaChannelCore.getGuildID();
        if (TextUtils.isEmpty(guildID) || !com.tencent.mobileqq.guild.util.ch.j0(guildID)) {
            return true;
        }
        return com.tencent.mobileqq.guild.util.ch.q(guildID);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi.a
    public void M(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        if (TextUtils.equals(guildId, this.mediaChannelCore.getGuildID())) {
            W0(PermissionChangeType.THRESHOLD);
        }
    }

    public final void M0(@NotNull String guildId, @NotNull String tinyId, boolean bAllow, long source) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        if (TextUtils.equals(this.mediaChannelCore.getGuildID(), guildId)) {
            Logger.f235387a.d().i("QGMC.Core.MediaChannelPermissionHelper", 1, "onPushPermissionInGuild: guildId[" + guildId + "]");
            W0(PermissionChangeType.BAN);
        }
    }

    public final boolean P0() {
        if (F0()) {
            return j0();
        }
        return false;
    }

    public final void S0(@NotNull PermissionChangeType changeType) {
        Intrinsics.checkNotNullParameter(changeType, "changeType");
        W0(changeType);
    }

    public final boolean T(boolean canRaiseHand, boolean canJoinMicQueue) {
        if (!X()) {
            return false;
        }
        if (P0()) {
            return Y();
        }
        return W(canRaiseHand, canJoinMicQueue);
    }

    public final void T0() {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("QGMC.Core.MediaChannelPermissionHelper", "registerObservers:");
        }
        ((IGPSService) com.tencent.mobileqq.guild.util.ch.m().getRuntimeService(IGPSService.class, "")).addObserver(this.observer);
        sz1.d.e(this);
        com.tencent.mobileqq.guild.setting.mute.c.C(this.mediaChannelCore.getGuildID()).observeForever(this.muteObserver);
        sz1.d.e(this.speakThresholdListener);
        com.tencent.mobileqq.guild.media.core.j.a().l0().b(this.mAudioRoomObserver);
        com.tencent.mobileqq.guild.media.core.j.d().V(SwitchThemeEvent.class, this.switchThemeEventObserver);
    }

    public final void U0() {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("QGMC.Core.MediaChannelPermissionHelper", "unregisterObserver:");
        }
        ((IGPSService) com.tencent.mobileqq.guild.util.ch.m().getRuntimeService(IGPSService.class, "")).deleteObserver(this.observer);
        sz1.d.p(this);
        com.tencent.mobileqq.guild.setting.mute.c.C(this.mediaChannelCore.getGuildID()).removeObserver(this.muteObserver);
        sz1.d.p(this.speakThresholdListener);
        com.tencent.mobileqq.guild.media.core.j.a().l0().B(this.mAudioRoomObserver);
        com.tencent.mobileqq.guild.media.core.j.d().j(SwitchThemeEvent.class, this.switchThemeEventObserver);
    }

    public final boolean W(boolean canRaiseHand, boolean canJoinMicQueue) {
        boolean z16;
        boolean a06;
        MediaChannelUtils mediaChannelUtils = MediaChannelUtils.f228046a;
        boolean u16 = mediaChannelUtils.u(this.mediaChannelCore.E());
        if (mediaChannelUtils.n(this.mediaChannelCore.E()) == 4) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!u16 && !z16) {
            if (com.tencent.mobileqq.guild.media.core.j.c().getSelfUserInfo().f228101i || I0()) {
                return true;
            }
            return f0();
        }
        boolean J0 = J0(canRaiseHand);
        if (!u16) {
            Logger.f235387a.d().d("QGMC.Core.MediaChannelPermissionHelper", 4, "canTalkByChannelPermission current type is not audio queue mode, check raiseHandRight " + J0);
            return J0;
        }
        if (canJoinMicQueue) {
            a06 = f0();
        } else {
            a06 = a0();
        }
        Logger.f235387a.d().d("QGMC.Core.MediaChannelPermissionHelper", 4, "canTalkByChannelPermission current type is audio queue mode, check canTalkInAudioQueueMode " + a06);
        return a06;
    }

    public final boolean X() {
        boolean z16;
        boolean d06 = d0();
        if (!Q0() && i0()) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean c06 = c0();
        boolean H0 = H0();
        Logger.f235387a.d().d("QGMC.Core.MediaChannelPermissionHelper", 4, "[updateTalkPermission] canTalkByGuildPermission[" + this.selfTalkPermission + "] isSelfGuildMuting[" + d06 + "], isSpeakThresholdLimiting[" + z16 + "], isChannelBanned[" + c06 + "], visitorCanTalk[" + H0 + "]");
        if (!d06 && !z16 && !c06 && H0) {
            return true;
        }
        return false;
    }

    public final boolean Y() {
        boolean f06 = f0();
        boolean l06 = l0();
        boolean l3 = com.tencent.mobileqq.guild.media.core.m.l(this.mediaChannelCore.v0());
        Logger.f235387a.d().d("QGMC.Core.MediaChannelPermissionHelper", 1, "[canTalkBySpecialThemePermission] canTalkByRole[" + f06 + "], hasTalkRight[" + l06 + "], isMicInActive[" + l3 + "]");
        if (!f06) {
            return false;
        }
        if (l06 || l3) {
            return true;
        }
        return false;
    }

    /* renamed from: b0, reason: from getter */
    public final boolean getSelfTalkPermission() {
        return this.selfTalkPermission;
    }

    public final boolean c0() {
        boolean n06 = com.tencent.mobileqq.guild.util.ch.n0(this.mediaChannelCore.getGuildID());
        if (this.mediaChannelCore.getSelfUserInfo().f228114v && !n06) {
            return true;
        }
        return false;
    }

    public final boolean d0() {
        return com.tencent.mobileqq.guild.setting.mute.c.l(this.mediaChannelCore.getGuildID());
    }

    public final boolean f0() {
        return com.tencent.mobileqq.guild.util.ao.a(this.mediaChannelCore.getChannelInfo());
    }

    public final boolean i0() {
        String guildID = this.mediaChannelCore.getGuildID();
        String E = this.mediaChannelCore.E();
        if (TextUtils.isEmpty(guildID) || TextUtils.isEmpty(E) || com.tencent.mobileqq.guild.util.ch.j0(guildID)) {
            return false;
        }
        if (this.isLimitBySpeakThreshold == null) {
            V0();
        }
        Boolean bool = this.isLimitBySpeakThreshold;
        Intrinsics.checkNotNull(bool);
        if (!bool.booleanValue() || MediaChannelUtils.f228046a.t(com.tencent.mobileqq.guild.media.core.j.c().getSelfUserInfo())) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.h, com.tencent.mobileqq.guild.media.core.g
    public void p() {
        super.p();
        E0();
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.h, com.tencent.mobileqq.guild.media.core.g
    public void u() {
        super.u();
        U0();
        this.isLimitBySpeakThreshold = null;
    }
}

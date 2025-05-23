package pj1;

import android.os.Bundle;
import androidx.core.util.Supplier;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.guild.feed.event.GuildFeedMuteStateChangeEvent;
import com.tencent.mobileqq.guild.feed.event.GuildSpeakThresholdStateChangeEvent;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.SpeakPermissionType;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 .2\u00020\u0001:\u0001\tB\u0015\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u0006\u0010\u000b\u001a\u00020\nJ\u001c\u0010\u0010\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0012R*\u0010\u001b\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\"\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010)\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010,\u001a\u0010\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00020\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010+R$\u00102\u001a\u00020\u00022\u0006\u0010-\u001a\u00020\u00028F@BX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b.\u0010/\"\u0004\b0\u00101\u00a8\u00065"}, d2 = {"Lpj1/b;", "", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/SpeakPermissionType;", "c", "b", "", h.F, "i", "d", "a", "", "o", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Landroidx/lifecycle/Observer;", "observer", "j", "Landroidx/core/util/Supplier;", "Landroidx/core/util/Supplier;", "isMemberStateSupplier", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "Landroid/os/Bundle;", "getVisitorThresholdLimitResult", "()Landroid/os/Bundle;", DomainData.DOMAIN_NAME, "(Landroid/os/Bundle;)V", "visitorThresholdLimitResult", "Lcom/tencent/mobileqq/guild/feed/event/GuildSpeakThresholdStateChangeEvent;", "Lcom/tencent/mobileqq/guild/feed/event/GuildSpeakThresholdStateChangeEvent;", "g", "()Lcom/tencent/mobileqq/guild/feed/event/GuildSpeakThresholdStateChangeEvent;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/mobileqq/guild/feed/event/GuildSpeakThresholdStateChangeEvent;)V", "speakThresholdEvent", "Lcom/tencent/mobileqq/guild/feed/event/GuildFeedMuteStateChangeEvent;", "Lcom/tencent/mobileqq/guild/feed/event/GuildFeedMuteStateChangeEvent;", "e", "()Lcom/tencent/mobileqq/guild/feed/event/GuildFeedMuteStateChangeEvent;", "k", "(Lcom/tencent/mobileqq/guild/feed/event/GuildFeedMuteStateChangeEvent;)V", "muteEvent", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/MutableLiveData;", "permissionTypeLiveData", "value", "f", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/SpeakPermissionType;", "l", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/SpeakPermissionType;)V", "permissionType", "<init>", "(Landroidx/core/util/Supplier;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final a f426317f = new a(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Supplier<Boolean> isMemberStateSupplier;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Bundle visitorThresholdLimitResult;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildSpeakThresholdStateChangeEvent speakThresholdEvent;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildFeedMuteStateChangeEvent muteEvent;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<SpeakPermissionType> permissionTypeLiveData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lpj1/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    public b(@NotNull Supplier<Boolean> isMemberStateSupplier) {
        Intrinsics.checkNotNullParameter(isMemberStateSupplier, "isMemberStateSupplier");
        this.isMemberStateSupplier = isMemberStateSupplier;
        this.visitorThresholdLimitResult = Bundle.EMPTY;
        this.permissionTypeLiveData = new MutableLiveData<>(SpeakPermissionType.PERMISSION_TYPE_INVALID);
    }

    private final SpeakPermissionType a() {
        GuildFeedMuteStateChangeEvent guildFeedMuteStateChangeEvent = this.muteEvent;
        if (guildFeedMuteStateChangeEvent == null) {
            return SpeakPermissionType.PERMISSION_TYPE_SIMPLE_INIT;
        }
        if (guildFeedMuteStateChangeEvent.isManager) {
            return SpeakPermissionType.PERMISSION_TYPE_NORMAL;
        }
        if (!guildFeedMuteStateChangeEvent.isMute) {
            return SpeakPermissionType.PERMISSION_TYPE_NORMAL;
        }
        if (guildFeedMuteStateChangeEvent.globalShutUpExpireTime > NetConnInfoCenter.getServerTime()) {
            return SpeakPermissionType.PERMISSION_TYPE_ALL_MUTED;
        }
        if (guildFeedMuteStateChangeEvent.myShutUpExpireTime > NetConnInfoCenter.getServerTime()) {
            return SpeakPermissionType.PERMISSION_TYPE_SELF_MUTED;
        }
        return SpeakPermissionType.PERMISSION_TYPE_SELF_MUTED;
    }

    private final SpeakPermissionType b() {
        if (this.visitorThresholdLimitResult.isEmpty()) {
            QLog.i("SpeakPermissionCalculatorCompat", 1, "visitorThresholdLimitResult is empty");
            return SpeakPermissionType.PERMISSION_TYPE_SIMPLE_INIT;
        }
        if (!h()) {
            return SpeakPermissionType.PERMISSION_TYPE_VISITOR_NEED_JOIN;
        }
        if (i()) {
            return SpeakPermissionType.PERMISSION_TYPE_REAL_NAME;
        }
        return SpeakPermissionType.PERMISSION_TYPE_NORMAL;
    }

    private final SpeakPermissionType c() {
        boolean z16;
        SpeakPermissionType d16 = d();
        if (d16 == SpeakPermissionType.PERMISSION_TYPE_NORMAL) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            d16 = null;
        }
        if (d16 == null) {
            return a();
        }
        return d16;
    }

    private final SpeakPermissionType d() {
        GuildSpeakThresholdStateChangeEvent guildSpeakThresholdStateChangeEvent = this.speakThresholdEvent;
        if (guildSpeakThresholdStateChangeEvent == null) {
            return SpeakPermissionType.PERMISSION_TYPE_SIMPLE_INIT;
        }
        if (guildSpeakThresholdStateChangeEvent.mIsChannelLevelAdmin) {
            return SpeakPermissionType.PERMISSION_TYPE_NORMAL;
        }
        int guildLimitType = guildSpeakThresholdStateChangeEvent.mSpeakThresholdState.getGuildLimitType();
        if (guildLimitType != 2) {
            if (guildLimitType != 4) {
                return SpeakPermissionType.PERMISSION_TYPE_NORMAL;
            }
            return SpeakPermissionType.PERMISSION_TYPE_JOIN_TIME;
        }
        return SpeakPermissionType.PERMISSION_TYPE_REAL_NAME;
    }

    private final boolean h() {
        Bundle bundle = this.visitorThresholdLimitResult;
        if (!bundle.getBoolean("isEnableVisitorMode", false) || !bundle.getBoolean("isEnableVisitorInteractMode", false)) {
            return false;
        }
        return true;
    }

    private final boolean i() {
        return this.visitorThresholdLimitResult.getBoolean("isVisitorNeedRealName", false);
    }

    private final void l(SpeakPermissionType speakPermissionType) {
        this.permissionTypeLiveData.setValue(speakPermissionType);
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final GuildFeedMuteStateChangeEvent getMuteEvent() {
        return this.muteEvent;
    }

    @NotNull
    public final SpeakPermissionType f() {
        SpeakPermissionType value = this.permissionTypeLiveData.getValue();
        if (value == null) {
            return SpeakPermissionType.PERMISSION_TYPE_INVALID;
        }
        return value;
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final GuildSpeakThresholdStateChangeEvent getSpeakThresholdEvent() {
        return this.speakThresholdEvent;
    }

    public final void j(@NotNull LifecycleOwner owner, @NotNull Observer<SpeakPermissionType> observer) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.permissionTypeLiveData.observe(owner, observer);
    }

    public final void k(@Nullable GuildFeedMuteStateChangeEvent guildFeedMuteStateChangeEvent) {
        this.muteEvent = guildFeedMuteStateChangeEvent;
    }

    public final void m(@Nullable GuildSpeakThresholdStateChangeEvent guildSpeakThresholdStateChangeEvent) {
        this.speakThresholdEvent = guildSpeakThresholdStateChangeEvent;
    }

    public final void n(Bundle bundle) {
        this.visitorThresholdLimitResult = bundle;
    }

    public final void o() {
        SpeakPermissionType b16;
        Boolean bool = this.isMemberStateSupplier.get();
        Intrinsics.checkNotNullExpressionValue(bool, "isMemberStateSupplier.get()");
        if (bool.booleanValue()) {
            b16 = c();
        } else {
            b16 = b();
        }
        if (b16 == SpeakPermissionType.PERMISSION_TYPE_NORMAL) {
            b16 = a();
        }
        l(b16);
    }
}

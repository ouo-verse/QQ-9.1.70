package com.tencent.mobileqq.guild.live.helper;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.live.livemanager.player.GuildLivePlayerTag;
import com.tencent.mobileqq.guild.live.livemanager.player.l;
import com.tencent.mobileqq.guild.live.livemanager.player.m;
import com.tencent.mobileqq.guild.live.model.GLiveChannelStartParams;
import com.tencent.mobileqq.guild.live.model.LiveChannelRoomInfo;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/live/helper/c;", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Observer<Boolean> f226692b = new Observer() { // from class: com.tencent.mobileqq.guild.live.helper.b
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object obj) {
            c.i((Boolean) obj);
        }
    };

    /* renamed from: c, reason: collision with root package name */
    private static long f226693c = -1;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private static String f226694d;

    /* renamed from: e, reason: collision with root package name */
    private static int f226695e;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u000f\u001a\u00020\tH\u0007R\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0012R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0014\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/live/helper/c$a;", "", "Lcom/tencent/mobileqq/guild/live/model/GLiveChannelStartParams;", "startParams", "", "f", "", "tinyId", "e", "", "c", "Lmqq/app/AppRuntime;", "kotlin.jvm.PlatformType", "d", "g", "b", "", "INVALID_ROOM_ID", "J", "TAG", "Ljava/lang/String;", "Landroidx/lifecycle/Observer;", "initObserver", "Landroidx/lifecycle/Observer;", "", "videoViewScaleType", "I", "willEnterRoomId", "willPrePlayUrl", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.live.helper.c$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/guild/live/helper/c$a$a", "Lcom/tencent/mobileqq/guild/live/livemanager/player/m;", "", "disableViewCallback", "enableViewCallback", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.live.helper.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes14.dex */
        public static final class C7812a implements m {
            C7812a() {
            }

            @Override // com.tencent.mobileqq.guild.live.livemanager.player.m
            public boolean disableViewCallback() {
                return GLiveChannelCore.f226698a.m().f(GuildLivePlayerTag.LIVE);
            }

            @Override // com.tencent.mobileqq.guild.live.livemanager.player.m
            public boolean enableViewCallback() {
                return GLiveChannelCore.f226698a.m().g(GuildLivePlayerTag.LIVE);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void c() {
            GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
            gLiveChannelCore.p().k().removeObserver(c.f226692b);
            if (c.f226693c != -1) {
                gLiveChannelCore.o().b(c.f226695e);
                gLiveChannelCore.o().e(c.f226693c);
                gLiveChannelCore.o().f(c.f226694d);
                c.f226693c = -1L;
                c.f226694d = null;
                c.f226695e = 0;
            }
        }

        private final AppRuntime d() {
            return MobileQQ.sMobileQQ.peekAppRuntime();
        }

        private final boolean e(String tinyId) {
            return Intrinsics.areEqual(((IGPSService) d().getRuntimeService(IGPSService.class, "")).getSelfTinyId(), tinyId);
        }

        private final boolean f(GLiveChannelStartParams startParams) {
            boolean z16;
            GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
            if (Intrinsics.areEqual(gLiveChannelCore.t().n().getValue(), Boolean.TRUE)) {
                return false;
            }
            if (startParams.getLiveType() == 0 && e(String.valueOf(startParams.getAnchorTinyId()))) {
                LiveChannelRoomInfo liveChannelRoomInfo = startParams.getLiveChannelRoomInfo();
                if (liveChannelRoomInfo != null && liveChannelRoomInfo.getPlatform() == 3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    return false;
                }
                return true;
            }
            if (gLiveChannelCore.x()) {
                QLog.i("QGL.GuildLivePreEnterHelper", 1, "shouldUseOutPlayer.");
                gLiveChannelCore.t().v0();
                return false;
            }
            return startParams.isLiving();
        }

        @JvmStatic
        public final void b() {
            GLiveChannelCore.f226698a.p().k().removeObserver(c.f226692b);
            c.f226693c = -1L;
            c.f226694d = null;
        }

        @JvmStatic
        public final void g(@NotNull GLiveChannelStartParams startParams) {
            boolean z16;
            Intrinsics.checkNotNullParameter(startParams, "startParams");
            if (!f(startParams)) {
                return;
            }
            int liveType = startParams.getLiveType();
            String liveUrl = startParams.getLiveUrl();
            boolean z17 = false;
            if (liveUrl != null && liveUrl.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            QLog.i("QGL.GuildLivePreEnterHelper", 1, "start pre enter, " + liveType + ", " + z16);
            if (startParams.isValidRoomId()) {
                c.f226693c = startParams.getRoomId();
                c.f226694d = startParams.getLiveUrl();
                c.f226695e = startParams.getVideoScaleType();
                if (QLog.isColorLevel()) {
                    QLog.i("QGL.GuildLivePreEnterHelper", 2, "pre play url:" + c.f226694d);
                }
                String str = c.f226694d;
                if (str == null || str.length() == 0) {
                    z17 = true;
                }
                if (!z17) {
                    GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
                    gLiveChannelCore.o().b(c.f226695e);
                    gLiveChannelCore.o().a();
                    gLiveChannelCore.o().f(c.f226694d);
                }
                LiveData<Boolean> g16 = GLiveChannelCore.f226698a.p().g(d());
                g16.removeObserver(c.f226692b);
                g16.observeForever(c.f226692b);
                return;
            }
            if (startParams.isValidLiveUrl()) {
                if (QLog.isColorLevel()) {
                    QLog.i("QGL.GuildLivePreEnterHelper", 2, "pre play url:" + startParams.getLiveUrl());
                }
                GLiveChannelCore gLiveChannelCore2 = GLiveChannelCore.f226698a;
                l m3 = gLiveChannelCore2.m();
                String liveUrl2 = startParams.getLiveUrl();
                Intrinsics.checkNotNull(liveUrl2);
                gLiveChannelCore2.t().l0(l.a.a(m3, liveUrl2, GuildLivePlayerTag.LIVE, 0, false, false, 28, null), new C7812a());
                gLiveChannelCore2.t().c0(Boolean.TRUE);
            }
        }

        Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Boolean it) {
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (it.booleanValue()) {
            INSTANCE.c();
        }
    }

    @JvmStatic
    public static final void j(@NotNull GLiveChannelStartParams gLiveChannelStartParams) {
        INSTANCE.g(gLiveChannelStartParams);
    }
}

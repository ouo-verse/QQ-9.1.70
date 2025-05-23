package com.tencent.mobileqq.qqlive.sail;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.login.ILiveLoginApi;
import com.tencent.mobileqq.qqlive.callback.message.IQQLiveMessageCallback;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData;
import com.tencent.mobileqq.qqlive.login.LiveLoginInfo;
import com.tencent.mobileqq.qqlive.sail.model.common.UserInfo;
import com.tencent.mobileqq.qqlive.sail.room.e;
import com.tencent.mobileqq.qqlive.sail.room.f;
import com.tencent.mobileqq.qqlive.widget.player.QQLiveRemotePlayer;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bE\u0010FJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0006J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\nJ\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\nJ\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0006\u0010\u0012\u001a\u00020\u0002J\u0006\u0010\u0013\u001a\u00020\nJ\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\nJ\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\nJ\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\nJ\u0018\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\nJ\u0018\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\nJ\u0018\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\nJ\u0018\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\nJ\u0018\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\nJ\u0018\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\nJ\u0018\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\nJ\u0018\u0010 \u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\nJ\u0018\u0010!\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\nJ\u001c\u0010$\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00010\"J\u0016\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010%2\u0006\u0010\u0003\u001a\u00020\u0002JD\u0010/\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u00162$\b\u0002\u0010,\u001a\u001e\u0012\b\u0012\u00060)R\u00020*\u0018\u00010(j\u000e\u0012\b\u0012\u00060)R\u00020*\u0018\u0001`+2\u0006\u0010.\u001a\u00020-J\u0006\u00100\u001a\u00020\u0006R\u0017\u00105\u001a\u0002018\u0006\u00a2\u0006\f\n\u0004\b\t\u00102\u001a\u0004\b3\u00104R\u0017\u0010:\u001a\u0002068\u0006\u00a2\u0006\f\n\u0004\b0\u00107\u001a\u0004\b8\u00109R \u0010=\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u0010<R\u0011\u0010@\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b>\u0010?R\u0013\u0010D\u001a\u0004\u0018\u00010A8F\u00a2\u0006\u0006\u001a\u0004\bB\u0010C\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/c;", "", "", "roomId", "Lcom/tencent/mobileqq/qqlive/widget/player/QQLiveRemotePlayer;", "remotePlayer", "", "a", HippyTKDListViewAdapter.X, "b", "", "query", "", "H", "Lcom/tencent/mobileqq/qqlive/sail/room/f;", "y", "Lcom/tencent/mobileqq/qqlive/sail/model/common/UserInfo;", "o", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "audienceQueryType", "k", "", "D", "t", "J", "v", "r", "g", "e", "i", "B", "E", DomainData.DOMAIN_NAME, "", "msgs", "L", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "message", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData$ExtData;", "Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData;", "Lkotlin/collections/ArrayList;", "exts", "Lcom/tencent/mobileqq/qqlive/callback/message/IQQLiveMessageCallback;", "callback", "M", "c", "Lcom/tencent/mobileqq/qqlive/sail/SailAudienceRoomManager;", "Lcom/tencent/mobileqq/qqlive/sail/SailAudienceRoomManager;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/mobileqq/qqlive/sail/SailAudienceRoomManager;", "audience", "Lcom/tencent/mobileqq/qqlive/sail/SailAnchorRoomManager;", "Lcom/tencent/mobileqq/qqlive/sail/SailAnchorRoomManager;", "d", "()Lcom/tencent/mobileqq/qqlive/sail/SailAnchorRoomManager;", "anchor", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "roomIdToRemotePlayerInfo", "G", "()J", "selfUid", "Lcom/tencent/mobileqq/qqlive/login/LiveLoginInfo;", "u", "()Lcom/tencent/mobileqq/qqlive/login/LiveLoginInfo;", "loginInfo", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f272176a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final SailAudienceRoomManager audience;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final SailAnchorRoomManager anchor;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<Long, QQLiveRemotePlayer> roomIdToRemotePlayerInfo;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18781);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 31)) {
            redirector.redirect((short) 31);
            return;
        }
        f272176a = new c();
        audience = new SailAudienceRoomManager();
        anchor = new SailAnchorRoomManager();
        roomIdToRemotePlayerInfo = new ConcurrentHashMap<>();
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ String C(c cVar, long j3, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 1;
        }
        return cVar.B(j3, i3);
    }

    public static /* synthetic */ int F(c cVar, long j3, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 1;
        }
        return cVar.E(j3, i3);
    }

    public static /* synthetic */ boolean I(c cVar, long j3, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 1;
        }
        return cVar.H(j3, i3);
    }

    public static /* synthetic */ boolean K(c cVar, long j3, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 1;
        }
        return cVar.J(j3, i3);
    }

    public static /* synthetic */ String f(c cVar, long j3, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 1;
        }
        return cVar.e(j3, i3);
    }

    public static /* synthetic */ String h(c cVar, long j3, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 1;
        }
        return cVar.g(j3, i3);
    }

    public static /* synthetic */ int j(c cVar, long j3, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 1;
        }
        return cVar.i(j3, i3);
    }

    public static /* synthetic */ long l(c cVar, long j3, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 1;
        }
        return cVar.k(j3, i3);
    }

    public static /* synthetic */ long s(c cVar, long j3, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 1;
        }
        return cVar.r(j3, i3);
    }

    public static /* synthetic */ String w(c cVar, long j3, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 1;
        }
        return cVar.v(j3, i3);
    }

    public static /* synthetic */ f z(c cVar, long j3, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 1;
        }
        return cVar.y(j3, i3);
    }

    @Nullable
    public final List<Object> A(long roomId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (List) iPatchRedirector.redirect((short) 28, (Object) this, roomId);
        }
        return ((jg4.b) mm4.b.b(jg4.b.class)).d(roomId);
    }

    @NotNull
    public final String B(long roomId, int query) {
        boolean isBlank;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (String) iPatchRedirector.redirect((short) 24, this, Long.valueOf(roomId), Integer.valueOf(query));
        }
        String u16 = audience.u(roomId, query);
        isBlank = StringsKt__StringsJVMKt.isBlank(u16);
        if (!isBlank) {
            return u16;
        }
        return anchor.o();
    }

    @Nullable
    public final String D(long roomId, int audienceQueryType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, this, Long.valueOf(roomId), Integer.valueOf(audienceQueryType));
        }
        return audience.p(roomId, audienceQueryType);
    }

    public final int E(long roomId, int query) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, this, Long.valueOf(roomId), Integer.valueOf(query))).intValue();
        }
        SailAnchorRoomManager sailAnchorRoomManager = anchor;
        if (sailAnchorRoomManager.t()) {
            return sailAnchorRoomManager.p();
        }
        return audience.v(roomId, query);
    }

    public final long G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        LiveLoginInfo loginInfo = ((ILiveLoginApi) QRoute.api(ILiveLoginApi.class)).getLoginInfo(QQLiveBusinessConfig.QQLIVE_APP_ID, ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount());
        if (loginInfo != null) {
            return loginInfo.q();
        }
        return 0L;
    }

    public final boolean H(long roomId, int query) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, this, Long.valueOf(roomId), Integer.valueOf(query))).booleanValue();
        }
        if (!audience.B(roomId, query) && !anchor.t()) {
            return false;
        }
        return true;
    }

    public final boolean J(long roomId, int audienceQueryType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, this, Long.valueOf(roomId), Integer.valueOf(audienceQueryType))).booleanValue();
        }
        if (G() == k(roomId, audienceQueryType)) {
            return true;
        }
        return false;
    }

    public final void L(long roomId, @NotNull List<? extends Object> msgs) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, Long.valueOf(roomId), msgs);
        } else {
            Intrinsics.checkNotNullParameter(msgs, "msgs");
            ((jg4.b) mm4.b.b(jg4.b.class)).F(roomId, msgs);
        }
    }

    public final void M(long roomId, @NotNull String message, @Nullable ArrayList<LiveMessageData.ExtData> exts, @NotNull IQQLiveMessageCallback callback) {
        String m3;
        String str;
        String m16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, Long.valueOf(roomId), message, exts, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(callback, "callback");
        SailAudienceRoomManager sailAudienceRoomManager = audience;
        String str2 = "";
        if (sailAudienceRoomManager.B(roomId, 1)) {
            LiveLoginInfo u16 = f272176a.u();
            if (u16 == null || (m16 = u16.m()) == null) {
                str = "";
            } else {
                str = m16;
            }
            sailAudienceRoomManager.J(roomId, message, str, exts, callback);
            return;
        }
        SailAnchorRoomManager sailAnchorRoomManager = anchor;
        if (sailAnchorRoomManager.t()) {
            LiveLoginInfo u17 = f272176a.u();
            if (u17 != null && (m3 = u17.m()) != null) {
                str2 = m3;
            }
            sailAnchorRoomManager.u(message, str2, exts, callback);
        }
    }

    public final void a(long roomId, @NotNull QQLiveRemotePlayer remotePlayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Long.valueOf(roomId), remotePlayer);
        } else {
            Intrinsics.checkNotNullParameter(remotePlayer, "remotePlayer");
            roomIdToRemotePlayerInfo.put(Long.valueOf(roomId), remotePlayer);
        }
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            roomIdToRemotePlayerInfo.clear();
        }
    }

    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
        } else {
            audience.b();
        }
    }

    @NotNull
    public final SailAnchorRoomManager d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (SailAnchorRoomManager) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return anchor;
    }

    @NotNull
    public final String e(long roomId, int query) {
        boolean isBlank;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, this, Long.valueOf(roomId), Integer.valueOf(query));
        }
        String d16 = audience.d(roomId, query);
        isBlank = StringsKt__StringsJVMKt.isBlank(d16);
        if (!isBlank) {
            return d16;
        }
        return anchor.b();
    }

    @NotNull
    public final String g(long roomId, int query) {
        boolean isBlank;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, this, Long.valueOf(roomId), Integer.valueOf(query));
        }
        String f16 = audience.f(roomId, query);
        isBlank = StringsKt__StringsJVMKt.isBlank(f16);
        if (!isBlank) {
            return f16;
        }
        return anchor.d();
    }

    public final int i(long roomId, int query) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, this, Long.valueOf(roomId), Integer.valueOf(query))).intValue();
        }
        int g16 = audience.g(roomId, query);
        if (g16 > 0) {
            return g16;
        }
        return anchor.e();
    }

    public final long k(long roomId, int audienceQueryType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Long) iPatchRedirector.redirect((short) 14, this, Long.valueOf(roomId), Integer.valueOf(audienceQueryType))).longValue();
        }
        long h16 = audience.h(roomId, audienceQueryType);
        if (h16 > 0) {
            return h16;
        }
        return anchor.f();
    }

    @NotNull
    public final SailAudienceRoomManager m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SailAudienceRoomManager) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return audience;
    }

    @NotNull
    public final String n(long roomId, int query) {
        boolean isBlank;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (String) iPatchRedirector.redirect((short) 26, this, Long.valueOf(roomId), Integer.valueOf(query));
        }
        String j3 = audience.j(roomId, query);
        isBlank = StringsKt__StringsJVMKt.isBlank(j3);
        if (!isBlank) {
            return j3;
        }
        return anchor.h();
    }

    @Nullable
    public final UserInfo o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (UserInfo) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        long p16 = p();
        UserInfo e16 = audience.e(p16, 1);
        if (e16 != null) {
            return e16;
        }
        return anchor.c(p16, 1);
    }

    public final long p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Long) iPatchRedirector.redirect((short) 12, (Object) this)).longValue();
        }
        long l3 = audience.l();
        if (l3 > 0) {
            return l3;
        }
        return anchor.n();
    }

    public final int q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        SailAudienceRoomManager sailAudienceRoomManager = audience;
        long l3 = sailAudienceRoomManager.l();
        if (l3 > 0) {
            return SailAudienceRoomManager.w(sailAudienceRoomManager, l3, 0, 2, null);
        }
        return anchor.p();
    }

    public final long r(long roomId, int audienceQueryType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Long) iPatchRedirector.redirect((short) 20, this, Long.valueOf(roomId), Integer.valueOf(audienceQueryType))).longValue();
        }
        long m3 = audience.m(roomId, audienceQueryType);
        if (m3 > 0) {
            return m3;
        }
        return anchor.i();
    }

    @Nullable
    public final String t(long roomId, int audienceQueryType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, this, Long.valueOf(roomId), Integer.valueOf(audienceQueryType));
        }
        return audience.o(roomId, audienceQueryType);
    }

    @Nullable
    public final LiveLoginInfo u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (LiveLoginInfo) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return ((ILiveLoginApi) QRoute.api(ILiveLoginApi.class)).getLoginInfo(QQLiveBusinessConfig.QQLIVE_APP_ID, ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount());
    }

    @NotNull
    public final String v(long roomId, int audienceQueryType) {
        boolean isBlank;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, this, Long.valueOf(roomId), Integer.valueOf(audienceQueryType));
        }
        String q16 = audience.q(roomId, audienceQueryType);
        isBlank = StringsKt__StringsJVMKt.isBlank(q16);
        if (!isBlank) {
            return q16;
        }
        return anchor.l();
    }

    @Nullable
    public final QQLiveRemotePlayer x(long roomId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (QQLiveRemotePlayer) iPatchRedirector.redirect((short) 7, (Object) this, roomId);
        }
        return roomIdToRemotePlayerInfo.get(Long.valueOf(roomId));
    }

    @Nullable
    public final f y(long roomId, int query) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (f) iPatchRedirector.redirect((short) 10, this, Long.valueOf(roomId), Integer.valueOf(query));
        }
        e s16 = audience.s(roomId, query);
        if (s16 != null) {
            return s16;
        }
        return anchor.m();
    }
}

package com.tencent.mobileqq.qqlive.sail;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorTRTCRoom;
import com.tencent.mobileqq.qqlive.api.audio.audioeffect.IRTCMusicAccompany;
import com.tencent.mobileqq.qqlive.callback.message.IQQLiveMessageCallback;
import com.tencent.mobileqq.qqlive.data.anchor.camera.QQLiveAnchorStreamRecordType;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomConfig;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomGameInfo;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomAttr;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataUserInfo;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData;
import com.tencent.mobileqq.qqlive.data.room.BaseAnchorInfo;
import com.tencent.mobileqq.qqlive.sail.model.AnchorRoomInfo;
import com.tencent.mobileqq.qqlive.sail.model.anchor.SettingInfo;
import com.tencent.mobileqq.qqlive.sail.model.anchor.StyleInfo;
import com.tencent.mobileqq.qqlive.sail.model.common.RoomCoverInfo;
import com.tencent.mobileqq.qqlive.sail.model.common.UserInfo;
import com.tencent.mobileqq.qqlive.sail.room.LiveRoomInteractive;
import com.tencent.mobileqq.qqlive.sail.room.d;
import com.tencent.mobileqq.qqlive.sail.room.l;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rq3.g;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b2\u00103J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\b\u0010\n\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u000bJ\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0015\u001a\u00020\u000fJ\u0006\u0010\u0016\u001a\u00020\u000fJ\u0006\u0010\u0017\u001a\u00020\u000bJ\u0006\u0010\u0018\u001a\u00020\u0013J\u0006\u0010\u0019\u001a\u00020\u0013J\u0006\u0010\u001a\u001a\u00020\u0013J\u0006\u0010\u001b\u001a\u00020\u000fJ\u0006\u0010\u001c\u001a\u00020\u0013J\u0006\u0010\u001d\u001a\u00020\u0013J\u0006\u0010\u001e\u001a\u00020\u000fJ\u000e\u0010 \u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u000fJ\b\u0010\"\u001a\u0004\u0018\u00010!J\u0006\u0010#\u001a\u00020\u0013J\b\u0010%\u001a\u0004\u0018\u00010$JD\u0010/\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u00132$\b\u0002\u0010,\u001a\u001e\u0012\b\u0012\u00060)R\u00020*\u0018\u00010(j\u000e\u0012\b\u0012\u00060)R\u00020*\u0018\u0001`+2\u0006\u0010.\u001a\u00020-R\u0018\u00101\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u00100\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/SailAnchorRoomManager;", "", "Lcom/tencent/mobileqq/qqlive/api/anchor/room/IQQLiveAnchorRoom;", "k", "", "t", "Lcom/tencent/mobileqq/qqlive/sail/room/c;", "room", "", "w", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", DomainData.DOMAIN_NAME, "f", "roomId", "", "query", "Lcom/tencent/mobileqq/qqlive/sail/model/common/UserInfo;", "c", "", "l", "p", "j", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "d", "b", "e", "o", h.F, "r", "value", "v", "Lcom/tencent/mobileqq/qqlive/api/audio/audioeffect/IRTCMusicAccompany;", "a", ReportConstant.COSTREPORT_PREFIX, "Ltq4/a;", "g", "message", "nick", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData$ExtData;", "Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData;", "Lkotlin/collections/ArrayList;", "exts", "Lcom/tencent/mobileqq/qqlive/callback/message/IQQLiveMessageCallback;", "callback", "u", "Lcom/tencent/mobileqq/qqlive/sail/room/c;", "anchorRoom", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class SailAnchorRoomManager {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.qqlive.sail.room.c anchorRoom;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/SailAnchorRoomManager$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.SailAnchorRoomManager$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f272163a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18697);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[QQLiveAnchorStreamRecordType.values().length];
            try {
                iArr[QQLiveAnchorStreamRecordType.CAMERA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[QQLiveAnchorStreamRecordType.SCREEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[QQLiveAnchorStreamRecordType.THIRD_PUSH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[QQLiveAnchorStreamRecordType.THIRD_PUSH_BROADCAST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f272163a = iArr;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18723);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 25)) {
            redirector.redirect((short) 25);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public SailAnchorRoomManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final IQQLiveAnchorRoom k() {
        return ((jg4.b) mm4.b.b(jg4.b.class)).J3(0L);
    }

    @Nullable
    public final IRTCMusicAccompany a() {
        d dVar;
        IQQLiveAnchorTRTCRoom iQQLiveAnchorTRTCRoom;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (IRTCMusicAccompany) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        com.tencent.mobileqq.qqlive.sail.room.c cVar = this.anchorRoom;
        if (cVar == null) {
            IQQLiveAnchorRoom k3 = k();
            if (k3 instanceof IQQLiveAnchorTRTCRoom) {
                iQQLiveAnchorTRTCRoom = (IQQLiveAnchorTRTCRoom) k3;
            } else {
                iQQLiveAnchorTRTCRoom = null;
            }
            if (iQQLiveAnchorTRTCRoom == null) {
                return null;
            }
            return iQQLiveAnchorTRTCRoom.createMusicAccompany();
        }
        if (cVar instanceof d) {
            dVar = (d) cVar;
        } else {
            dVar = null;
        }
        if (dVar == null) {
            return null;
        }
        return dVar.createMusicAccompany();
    }

    @NotNull
    public final String b() {
        AnchorRoomInfo b16;
        UserInfo j3;
        String a16;
        QQLiveAnchorRoomInfo anchorRoomInfo;
        QQLiveAnchorDataUserInfo qQLiveAnchorDataUserInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        com.tencent.mobileqq.qqlive.sail.room.c cVar = this.anchorRoom;
        if (cVar == null) {
            IQQLiveAnchorRoom k3 = k();
            if (k3 != null && (anchorRoomInfo = k3.getAnchorRoomInfo()) != null && (qQLiveAnchorDataUserInfo = anchorRoomInfo.userDta) != null) {
                a16 = qQLiveAnchorDataUserInfo.avatarUrl;
            } else {
                a16 = null;
            }
            if (a16 == null) {
                return "";
            }
        } else if (cVar == null || (b16 = cVar.b()) == null || (j3 = b16.j()) == null || (a16 = j3.a()) == null) {
            return "";
        }
        return a16;
    }

    @Nullable
    public final UserInfo c(long roomId, int query) {
        AnchorRoomInfo b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (UserInfo) iPatchRedirector.redirect((short) 7, this, Long.valueOf(roomId), Integer.valueOf(query));
        }
        com.tencent.mobileqq.qqlive.sail.room.c cVar = this.anchorRoom;
        if (cVar == null || cVar == null || (b16 = cVar.b()) == null) {
            return null;
        }
        return b16.j();
    }

    @NotNull
    public final String d() {
        AnchorRoomInfo b16;
        UserInfo j3;
        String b17;
        QQLiveAnchorRoomInfo anchorRoomInfo;
        QQLiveAnchorDataUserInfo qQLiveAnchorDataUserInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        com.tencent.mobileqq.qqlive.sail.room.c cVar = this.anchorRoom;
        if (cVar == null) {
            IQQLiveAnchorRoom k3 = k();
            if (k3 != null && (anchorRoomInfo = k3.getAnchorRoomInfo()) != null && (qQLiveAnchorDataUserInfo = anchorRoomInfo.userDta) != null) {
                b17 = qQLiveAnchorDataUserInfo.nickName;
            } else {
                b17 = null;
            }
            if (b17 == null) {
                return "";
            }
        } else if (cVar == null || (b16 = cVar.b()) == null || (j3 = b16.j()) == null || (b17 = j3.b()) == null) {
            return "";
        }
        return b17;
    }

    public final int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return 0;
    }

    public final long f() {
        AnchorRoomInfo b16;
        UserInfo j3;
        BaseAnchorInfo anchorInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        com.tencent.mobileqq.qqlive.sail.room.c cVar = this.anchorRoom;
        if (cVar == null) {
            IQQLiveAnchorRoom k3 = k();
            if (k3 == null || (anchorInfo = k3.getAnchorInfo()) == null) {
                return 0L;
            }
            return anchorInfo.getAnchorUid();
        }
        if (cVar == null || (b16 = cVar.b()) == null || (j3 = b16.j()) == null) {
            return 0L;
        }
        return j3.f();
    }

    @Nullable
    public final tq4.a g() {
        AnchorRoomInfo b16;
        QQLiveAnchorRoomInfo anchorRoomInfo;
        QQLiveAnchorDataRoomAttr qQLiveAnchorDataRoomAttr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (tq4.a) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        com.tencent.mobileqq.qqlive.sail.room.c cVar = this.anchorRoom;
        if (cVar == null) {
            IQQLiveAnchorRoom k3 = k();
            if (k3 == null || (anchorRoomInfo = k3.getAnchorRoomInfo()) == null || (qQLiveAnchorDataRoomAttr = anchorRoomInfo.roomAttr) == null) {
                return null;
            }
            return qQLiveAnchorDataRoomAttr.backgroundInfo;
        }
        if (cVar == null || (b16 = cVar.b()) == null) {
            return null;
        }
        return b16.o();
    }

    @NotNull
    public final String h() {
        AnchorRoomInfo b16;
        SettingInfo r16;
        RoomCoverInfo c16;
        String e16;
        QQLiveAnchorRoomInfo anchorRoomInfo;
        QQLiveAnchorDataRoomAttr qQLiveAnchorDataRoomAttr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        com.tencent.mobileqq.qqlive.sail.room.c cVar = this.anchorRoom;
        if (cVar == null) {
            IQQLiveAnchorRoom k3 = k();
            if (k3 != null && (anchorRoomInfo = k3.getAnchorRoomInfo()) != null && (qQLiveAnchorDataRoomAttr = anchorRoomInfo.roomAttr) != null) {
                e16 = qQLiveAnchorDataRoomAttr.poster16v9;
            } else {
                e16 = null;
            }
            if (e16 == null) {
                return "";
            }
        } else if (cVar == null || (b16 = cVar.b()) == null || (r16 = b16.r()) == null || (c16 = r16.c()) == null || (e16 = c16.e()) == null) {
            return "";
        }
        return e16;
    }

    public final long i() {
        AnchorRoomInfo b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Long) iPatchRedirector.redirect((short) 11, (Object) this)).longValue();
        }
        com.tencent.mobileqq.qqlive.sail.room.c cVar = this.anchorRoom;
        if (cVar == null) {
            IQQLiveAnchorRoom k3 = k();
            if (k3 == null) {
                return 0L;
            }
            return k3.getEnterRoomTime();
        }
        if (cVar == null || (b16 = cVar.b()) == null) {
            return 0L;
        }
        return b16.e();
    }

    public final int j() {
        AnchorRoomInfo b16;
        SettingInfo r16;
        StyleInfo n3;
        QQLiveAnchorRoomInfo anchorRoomInfo;
        QQLiveAnchorDataRoomInfo qQLiveAnchorDataRoomInfo;
        QQLiveAnchorRoomGameInfo qQLiveAnchorRoomGameInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        com.tencent.mobileqq.qqlive.sail.room.c cVar = this.anchorRoom;
        if (cVar == null) {
            IQQLiveAnchorRoom k3 = k();
            if (k3 == null || (anchorRoomInfo = k3.getAnchorRoomInfo()) == null || (qQLiveAnchorDataRoomInfo = anchorRoomInfo.roomData) == null || (qQLiveAnchorRoomGameInfo = qQLiveAnchorDataRoomInfo.gameInfo) == null) {
                return 0;
            }
            return qQLiveAnchorRoomGameInfo.f271211id;
        }
        if (cVar == null || (b16 = cVar.b()) == null || (r16 = b16.r()) == null || (n3 = r16.n()) == null) {
            return 0;
        }
        return n3.b();
    }

    @NotNull
    public final String l() {
        AnchorRoomInfo b16;
        String programId;
        QQLiveAnchorRoomInfo anchorRoomInfo;
        QQLiveAnchorDataRoomInfo qQLiveAnchorDataRoomInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        com.tencent.mobileqq.qqlive.sail.room.c cVar = this.anchorRoom;
        if (cVar == null) {
            IQQLiveAnchorRoom k3 = k();
            if (k3 != null && (anchorRoomInfo = k3.getAnchorRoomInfo()) != null && (qQLiveAnchorDataRoomInfo = anchorRoomInfo.roomData) != null) {
                programId = qQLiveAnchorDataRoomInfo.programId;
            } else {
                programId = null;
            }
            if (programId == null) {
                return "";
            }
        } else if (cVar == null || (b16 = cVar.b()) == null || (programId = b16.getProgramId()) == null) {
            return "";
        }
        return programId;
    }

    @Nullable
    public final com.tencent.mobileqq.qqlive.sail.room.c m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.qqlive.sail.room.c) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.anchorRoom;
    }

    public final long n() {
        QQLiveAnchorRoomInfo anchorRoomInfo;
        QQLiveAnchorDataRoomInfo qQLiveAnchorDataRoomInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        com.tencent.mobileqq.qqlive.sail.room.c cVar = this.anchorRoom;
        if (cVar == null) {
            IQQLiveAnchorRoom k3 = k();
            if (k3 == null || (anchorRoomInfo = k3.getAnchorRoomInfo()) == null || (qQLiveAnchorDataRoomInfo = anchorRoomInfo.roomData) == null) {
                return 0L;
            }
            return qQLiveAnchorDataRoomInfo.getRoomId();
        }
        if (cVar == null) {
            return 0L;
        }
        return cVar.getRoomId();
    }

    @NotNull
    public final String o() {
        AnchorRoomInfo b16;
        SettingInfo r16;
        String j3;
        QQLiveAnchorRoomInfo anchorRoomInfo;
        QQLiveAnchorDataRoomInfo qQLiveAnchorDataRoomInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        com.tencent.mobileqq.qqlive.sail.room.c cVar = this.anchorRoom;
        if (cVar == null) {
            IQQLiveAnchorRoom k3 = k();
            if (k3 != null && (anchorRoomInfo = k3.getAnchorRoomInfo()) != null && (qQLiveAnchorDataRoomInfo = anchorRoomInfo.roomData) != null) {
                j3 = qQLiveAnchorDataRoomInfo.name;
            } else {
                j3 = null;
            }
            if (j3 == null) {
                return "";
            }
        } else if (cVar == null || (b16 = cVar.b()) == null || (r16 = b16.r()) == null || (j3 = r16.j()) == null) {
            return "";
        }
        return j3;
    }

    public final int p() {
        AnchorRoomInfo b16;
        QQLiveAnchorRoomInfo anchorRoomInfo;
        QQLiveAnchorDataRoomInfo qQLiveAnchorDataRoomInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        com.tencent.mobileqq.qqlive.sail.room.c cVar = this.anchorRoom;
        if (cVar == null) {
            IQQLiveAnchorRoom k3 = k();
            if (k3 == null || (anchorRoomInfo = k3.getAnchorRoomInfo()) == null || (qQLiveAnchorDataRoomInfo = anchorRoomInfo.roomData) == null) {
                return 0;
            }
            return qQLiveAnchorDataRoomInfo.liveRoomType;
        }
        if (cVar == null || (b16 = cVar.b()) == null) {
            return 0;
        }
        return b16.getRoomType();
    }

    @NotNull
    public final String q() {
        AnchorRoomInfo b16;
        SettingInfo r16;
        String l3;
        QQLiveAnchorRoomInfo anchorRoomInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        com.tencent.mobileqq.qqlive.sail.room.c cVar = this.anchorRoom;
        if (cVar == null) {
            IQQLiveAnchorRoom k3 = k();
            if (k3 != null && (anchorRoomInfo = k3.getAnchorRoomInfo()) != null) {
                l3 = anchorRoomInfo.source;
            } else {
                l3 = null;
            }
            if (l3 == null) {
                return "0";
            }
        } else if (cVar == null || (b16 = cVar.b()) == null || (r16 = b16.r()) == null || (l3 = r16.l()) == null) {
            return "0";
        }
        return l3;
    }

    public final int r() {
        AnchorRoomInfo b16;
        SettingInfo r16;
        int i3;
        QQLiveAnchorRoomConfig roomConfig;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        com.tencent.mobileqq.qqlive.sail.room.c cVar = this.anchorRoom;
        d dVar = null;
        r1 = null;
        QQLiveAnchorStreamRecordType qQLiveAnchorStreamRecordType = null;
        if (cVar == null) {
            IQQLiveAnchorRoom k3 = k();
            if (k3 != null && (roomConfig = k3.getRoomConfig()) != null) {
                qQLiveAnchorStreamRecordType = roomConfig.streamRecordType;
            }
            if (qQLiveAnchorStreamRecordType == null) {
                i3 = -1;
            } else {
                i3 = b.f272163a[qQLiveAnchorStreamRecordType.ordinal()];
            }
            if (i3 == 1) {
                return 0;
            }
            if (i3 == 2) {
                return 1;
            }
            if (i3 != 3 && i3 != 4) {
                return 0;
            }
            return 2;
        }
        if (cVar instanceof d) {
            dVar = (d) cVar;
        }
        if (dVar == null || (b16 = dVar.b()) == null || (r16 = b16.r()) == null) {
            return 0;
        }
        return r16.m();
    }

    @NotNull
    public final String s() {
        AnchorRoomInfo b16;
        String s16;
        QQLiveAnchorRoomInfo anchorRoomInfo;
        QQLiveAnchorDataRoomInfo qQLiveAnchorDataRoomInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        com.tencent.mobileqq.qqlive.sail.room.c cVar = this.anchorRoom;
        if (cVar == null) {
            IQQLiveAnchorRoom k3 = k();
            if (k3 != null && (anchorRoomInfo = k3.getAnchorRoomInfo()) != null && (qQLiveAnchorDataRoomInfo = anchorRoomInfo.roomData) != null) {
                s16 = qQLiveAnchorDataRoomInfo.systemNotice;
            } else {
                s16 = null;
            }
            if (s16 == null) {
                return "";
            }
        } else if (cVar == null || (b16 = cVar.b()) == null || (s16 = b16.s()) == null) {
            return "";
        }
        return s16;
    }

    public final boolean t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (this.anchorRoom != null) {
            return true;
        }
        IQQLiveAnchorRoom k3 = k();
        if (k3 != null && !k3.isDestroyed()) {
            return true;
        }
        return false;
    }

    public final void u(@NotNull String message, @NotNull String nick, @Nullable ArrayList<LiveMessageData.ExtData> exts, @NotNull final IQQLiveMessageCallback callback) {
        List<rq3.b> list;
        LiveRoomInteractive o16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, message, nick, exts, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(nick, "nick");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.anchorRoom == null) {
            IQQLiveAnchorRoom k3 = k();
            if (k3 != null) {
                k3.sendMessage(message, exts, callback, 0);
                return;
            }
            return;
        }
        if (exts != null) {
            list = a.c(exts);
        } else {
            list = null;
        }
        com.tencent.mobileqq.qqlive.sail.room.c cVar = this.anchorRoom;
        if (cVar != null && (o16 = cVar.o()) != null) {
            o16.g(message, nick, list, new Function1<l<g>, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.SailAnchorRoomManager$sendMessage$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) IQQLiveMessageCallback.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(l<g> lVar) {
                    invoke2(lVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull l<g> it) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    } else {
                        Intrinsics.checkNotNullParameter(it, "it");
                        a.b("Audience|SailAnchorRoomManager", it, IQQLiveMessageCallback.this);
                    }
                }
            });
        }
    }

    public final void v(int value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, value);
            return;
        }
        com.tencent.mobileqq.qqlive.sail.room.c cVar = this.anchorRoom;
        d dVar = null;
        IQQLiveAnchorTRTCRoom iQQLiveAnchorTRTCRoom = null;
        if (cVar == null) {
            IQQLiveAnchorRoom k3 = k();
            if (k3 instanceof IQQLiveAnchorTRTCRoom) {
                iQQLiveAnchorTRTCRoom = (IQQLiveAnchorTRTCRoom) k3;
            }
            if (iQQLiveAnchorTRTCRoom != null) {
                iQQLiveAnchorTRTCRoom.setAudioVolume(value);
                return;
            }
            return;
        }
        if (cVar instanceof d) {
            dVar = (d) cVar;
        }
        if (dVar != null) {
            dVar.setAudioVolume(value);
        }
    }

    public final void w(@Nullable com.tencent.mobileqq.qqlive.sail.room.c room) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) room);
        } else {
            this.anchorRoom = room;
        }
    }
}

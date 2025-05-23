package com.tencent.mobileqq.qqlive.sail;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow;
import com.tencent.mobileqq.qqlive.callback.message.IQQLiveMessageCallback;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData;
import com.tencent.mobileqq.qqlive.sail.model.AudienceRoomInfo;
import com.tencent.mobileqq.qqlive.sail.model.audience.StreamDefinition;
import com.tencent.mobileqq.qqlive.sail.room.LiveRoomInteractive;
import com.tencent.mobileqq.qqlive.sail.room.e;
import com.tencent.mobileqq.qqlive.sail.room.l;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.util.LongSparseArray;
import com.tencent.util.QQToastUtil;
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
import rt3.aa;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 %2\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b?\u0010@JL\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\"\u0010\u000b\u001a\u001e\u0012\b\u0012\u00060\bR\u00020\t\u0018\u00010\u0007j\u000e\u0012\b\u0012\u00060\bR\u00020\t\u0018\u0001`\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0018\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0010\u0010\u001b\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0016J\u0016\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018J\u001a\u0010\u001f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u0018J\u0006\u0010 \u001a\u00020\u0016J\b\u0010!\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\"\u001a\u00020\u0012J\u0018\u0010#\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u0018J\u001a\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u0018J\u001a\u0010&\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u0018J\u001a\u0010'\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u0018J\u0018\u0010(\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u0018J\u0018\u0010)\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u0018J\u0018\u0010*\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u0018J\u0018\u0010+\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u0018J\u0018\u0010,\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u0018J\u0018\u0010-\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u0018J\u0018\u0010.\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u0018J\u0018\u0010/\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u0018J\u0018\u00100\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u0018J\u0018\u00101\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u0018J\u0018\u00102\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u0018J \u00105\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u00104\u001a\u0002032\b\b\u0002\u0010\u0019\u001a\u00020\u0018JL\u00106\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042$\b\u0002\u0010\u000b\u001a\u001e\u0012\b\u0012\u00060\bR\u00020\t\u0018\u00010\u0007j\u000e\u0012\b\u0012\u00060\bR\u00020\t\u0018\u0001`\n2\u0006\u0010\r\u001a\u00020\fJ\u0006\u00107\u001a\u00020\u000eR\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00020\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u00109R\u0016\u0010;\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00106R\u0018\u0010=\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010<R\u0016\u0010>\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u00106\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/SailAudienceRoomManager;", "", "Lcom/tencent/mobileqq/qqlive/sail/room/e;", "room", "", "message", "nick", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData$ExtData;", "Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData;", "Lkotlin/collections/ArrayList;", "exts", "Lcom/tencent/mobileqq/qqlive/callback/message/IQQLiveMessageCallback;", "callback", "", "K", "Lrt3/aa;", "roomEnterSetting", "", "H", "shieldCommonWord", "E", "", "roomId", "", "query", HippyTKDListViewAdapter.X, "a", "I", "L", "B", ReportConstant.COSTREPORT_PREFIX, "l", "k", "c", h.F, "Lcom/tencent/mobileqq/qqlive/sail/model/common/UserInfo;", "e", "p", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "v", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, UserInfo.SEX_FEMALE, BdhLogUtil.LogTag.Tag_Conn, "f", "d", "g", "u", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "j", "Lcom/tencent/mobileqq/qqlive/sail/model/audience/StreamDefinition;", "definition", "y", "J", "b", "Lcom/tencent/util/LongSparseArray;", "Lcom/tencent/util/LongSparseArray;", "sailRooms", "currentSailRoomId", "Ljava/lang/String;", "lastSendMessage", "lastSendMessageTime", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class SailAudienceRoomManager {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: from kotlin metadata */
    @NotNull
    private final LongSparseArray<e> sailRooms;

    /* renamed from: b, reason: from kotlin metadata */
    private volatile long currentSailRoomId;

    /* renamed from: c, reason: from kotlin metadata */
    @Nullable
    private String lastSendMessage;

    /* renamed from: d, reason: from kotlin metadata */
    private long lastSendMessageTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/SailAudienceRoomManager$a;", "", "", "QUERY_CURRENT", "I", "QUERY_ONLY_PRELOAD", "QUERY_WITH_PRELOAD", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.SailAudienceRoomManager$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18773);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 30)) {
            redirector.redirect((short) 30);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public SailAudienceRoomManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.sailRooms = new LongSparseArray<>();
            this.currentSailRoomId = -1L;
        }
    }

    public static /* synthetic */ String A(SailAudienceRoomManager sailAudienceRoomManager, long j3, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        return sailAudienceRoomManager.z(j3, i3);
    }

    public static /* synthetic */ boolean D(SailAudienceRoomManager sailAudienceRoomManager, long j3, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        return sailAudienceRoomManager.C(j3, i3);
    }

    private final boolean E(boolean shieldCommonWord, String message) {
        if (shieldCommonWord && Intrinsics.areEqual(message, this.lastSendMessage)) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean G(SailAudienceRoomManager sailAudienceRoomManager, long j3, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        return sailAudienceRoomManager.F(j3, i3);
    }

    private final boolean H(aa roomEnterSetting) {
        if (System.currentTimeMillis() - this.lastSendMessageTime < roomEnterSetting.f432222a * 1000) {
            QQToastUtil.showQQToast(1, roomEnterSetting.f432224c);
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void K(e room, String message, String nick, ArrayList<LiveMessageData.ExtData> exts, IQQLiveMessageCallback callback) {
        Unit unit;
        boolean z16;
        boolean z17;
        List<rq3.b> list;
        List<rq3.b> list2;
        aa q16 = room.b().q();
        if (q16 != null) {
            AegisLogger.INSTANCE.i("Audience|SailAudienceRoomManager", "sendMessageToSailRoom", "shieldCommonWord = " + q16.f432223b + ", timeInterval = " + q16.f432222a + " lastSendMessageTime: " + this.lastSendMessageTime + " lastSendMessage: " + this.lastSendMessage);
            if (!H(q16) && !E(q16.f432223b, message)) {
                LiveRoomInteractive o16 = room.o();
                if (o16 != null) {
                    if (exts != null) {
                        list2 = a.c(exts);
                    } else {
                        list2 = null;
                    }
                    o16.g(message, nick, list2, new Function1<l<g>, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.SailAudienceRoomManager$sendMessageToSailRoom$1$1
                        static IPatchRedirector $redirector_;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) IQQLiveMessageCallback.this);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(l<g> lVar) {
                            invoke2(lVar);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull l<g> it) {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                            } else {
                                Intrinsics.checkNotNullParameter(it, "it");
                                a.b("Audience|SailAudienceRoomManager", it, IQQLiveMessageCallback.this);
                            }
                        }
                    });
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                z16 = true;
                if (unit != null) {
                    AegisLogger.INSTANCE.i("Audience|SailAudienceRoomManager", "sendMessageToSailRoom", "not get roomEnterSetting, send message directly");
                    LiveRoomInteractive o17 = room.o();
                    if (o17 != null) {
                        if (exts != null) {
                            list = a.c(exts);
                        } else {
                            list = null;
                        }
                        o17.g(message, nick, list, new Function1<l<g>, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.SailAudienceRoomManager$sendMessageToSailRoom$2$1
                            static IPatchRedirector $redirector_;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) IQQLiveMessageCallback.this);
                                }
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(l<g> lVar) {
                                invoke2(lVar);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@NotNull l<g> it) {
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                                } else {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    a.b("Audience|SailAudienceRoomManager", it, IQQLiveMessageCallback.this);
                                }
                            }
                        });
                    }
                    z17 = true;
                } else {
                    z17 = z16;
                }
                if (!z17) {
                    this.lastSendMessage = message;
                    this.lastSendMessageTime = System.currentTimeMillis();
                    return;
                }
                return;
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        z16 = false;
        if (unit != null) {
        }
        if (!z17) {
        }
    }

    public static /* synthetic */ long i(SailAudienceRoomManager sailAudienceRoomManager, long j3, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 1;
        }
        return sailAudienceRoomManager.h(j3, i3);
    }

    public static /* synthetic */ long n(SailAudienceRoomManager sailAudienceRoomManager, long j3, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 1;
        }
        return sailAudienceRoomManager.m(j3, i3);
    }

    public static /* synthetic */ String r(SailAudienceRoomManager sailAudienceRoomManager, long j3, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 1;
        }
        return sailAudienceRoomManager.q(j3, i3);
    }

    public static /* synthetic */ e t(SailAudienceRoomManager sailAudienceRoomManager, long j3, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 1;
        }
        return sailAudienceRoomManager.s(j3, i3);
    }

    public static /* synthetic */ int w(SailAudienceRoomManager sailAudienceRoomManager, long j3, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 1;
        }
        return sailAudienceRoomManager.v(j3, i3);
    }

    private final e x(long j3, int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2 || j3 == this.currentSailRoomId) {
                    return null;
                }
                return this.sailRooms.get(j3);
            }
            return this.sailRooms.get(j3);
        }
        if (this.currentSailRoomId != j3) {
            return null;
        }
        return this.sailRooms.get(j3);
    }

    public final boolean B(long roomId, int query) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, Long.valueOf(roomId), Integer.valueOf(query))).booleanValue();
        }
        if (this.sailRooms.get(roomId) != null) {
            return true;
        }
        return false;
    }

    public final boolean C(long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, this, Long.valueOf(j3), Integer.valueOf(i3))).booleanValue();
        }
        e x16 = x(j3, i3);
        if (x16 == null) {
            return false;
        }
        return x16.b().g();
    }

    public final boolean F(long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, this, Long.valueOf(j3), Integer.valueOf(i3))).booleanValue();
        }
        e x16 = x(j3, i3);
        if (x16 == null) {
            return false;
        }
        if ((x16.b().r().a() == 1 && !x16.b().x()) || x16.b().x()) {
            return true;
        }
        return false;
    }

    public final void I(long roomId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, roomId);
        } else {
            this.sailRooms.remove(roomId);
        }
    }

    public final void J(long roomId, @NotNull String message, @NotNull String nick, @Nullable ArrayList<LiveMessageData.ExtData> exts, @NotNull IQQLiveMessageCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, Long.valueOf(roomId), message, nick, exts, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(nick, "nick");
        Intrinsics.checkNotNullParameter(callback, "callback");
        e x16 = x(roomId, 0);
        if (x16 != null) {
            K(x16, message, nick, exts, callback);
        } else {
            AegisLogger.INSTANCE.w("Audience|SailAudienceRoomManager", "sendMessage", "no room found");
        }
    }

    public final void L(long roomId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, roomId);
        } else {
            this.currentSailRoomId = roomId;
        }
    }

    public final void a(@Nullable e room) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) room);
        } else if (room != null) {
            this.sailRooms.put(room.getRoomId(), room);
        }
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
        } else {
            this.lastSendMessage = null;
            this.lastSendMessageTime = 0L;
        }
    }

    public final boolean c() {
        com.tencent.mobileqq.qqlive.widget.floatwindow.g gVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        if (this.sailRooms.size() > 0) {
            return true;
        }
        com.tencent.mobileqq.qqfloatingwindow.a floatingProxyWrapper = ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).getFloatingProxyWrapper(BaseApplication.context, com.tencent.mobileqq.qqlive.widget.floatwindow.g.class.getName());
        e eVar = null;
        if (floatingProxyWrapper instanceof com.tencent.mobileqq.qqlive.widget.floatwindow.g) {
            gVar = (com.tencent.mobileqq.qqlive.widget.floatwindow.g) floatingProxyWrapper;
        } else {
            gVar = null;
        }
        if (gVar != null) {
            eVar = gVar.x0();
        }
        if (eVar != null) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String d(long roomId, int query) {
        com.tencent.mobileqq.qqlive.sail.model.common.UserInfo k3;
        String a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, this, Long.valueOf(roomId), Integer.valueOf(query));
        }
        e x16 = x(roomId, query);
        if (x16 == null || (k3 = x16.b().k()) == null || (a16 = k3.a()) == null) {
            return "";
        }
        return a16;
    }

    @Nullable
    public final com.tencent.mobileqq.qqlive.sail.model.common.UserInfo e(long roomId, int query) {
        AudienceRoomInfo b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (com.tencent.mobileqq.qqlive.sail.model.common.UserInfo) iPatchRedirector.redirect((short) 11, this, Long.valueOf(roomId), Integer.valueOf(query));
        }
        e x16 = x(roomId, query);
        if (x16 != null && (b16 = x16.b()) != null) {
            return b16.k();
        }
        return null;
    }

    @NotNull
    public final String f(long roomId, int query) {
        com.tencent.mobileqq.qqlive.sail.model.common.UserInfo k3;
        String b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, this, Long.valueOf(roomId), Integer.valueOf(query));
        }
        e x16 = x(roomId, query);
        if (x16 == null || (k3 = x16.b().k()) == null || (b16 = k3.b()) == null) {
            return "";
        }
        return b16;
    }

    public final int g(long roomId, int query) {
        com.tencent.mobileqq.qqlive.sail.model.common.UserInfo k3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, this, Long.valueOf(roomId), Integer.valueOf(query))).intValue();
        }
        e x16 = x(roomId, query);
        if (x16 == null || (k3 = x16.b().k()) == null) {
            return 0;
        }
        return k3.c();
    }

    public final long h(long j3, int i3) {
        com.tencent.mobileqq.qqlive.sail.model.common.UserInfo k3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Long) iPatchRedirector.redirect((short) 10, this, Long.valueOf(j3), Integer.valueOf(i3))).longValue();
        }
        e x16 = x(j3, i3);
        if (x16 == null || (k3 = x16.b().k()) == null) {
            return 0L;
        }
        return k3.f();
    }

    @NotNull
    public final String j(long roomId, int query) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (String) iPatchRedirector.redirect((short) 26, this, Long.valueOf(roomId), Integer.valueOf(query));
        }
        e x16 = x(roomId, query);
        if (x16 != null) {
            return x16.b().r().b();
        }
        return "";
    }

    @Nullable
    public final e k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (e) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return t(this, this.currentSailRoomId, 0, 2, null);
    }

    public final long l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this)).longValue();
        }
        if (this.currentSailRoomId <= 0) {
            return 0L;
        }
        return this.currentSailRoomId;
    }

    public final long m(long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Long) iPatchRedirector.redirect((short) 17, this, Long.valueOf(j3), Integer.valueOf(i3))).longValue();
        }
        e x16 = x(j3, i3);
        if (x16 != null) {
            return x16.b().n();
        }
        return 0L;
    }

    @Nullable
    public final String o(long roomId, int query) {
        com.tencent.mobileqq.qqlive.sail.model.common.UserInfo k3;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, this, Long.valueOf(roomId), Integer.valueOf(query));
        }
        e x16 = x(roomId, query);
        if (x16 == null || !x16.h()) {
            z16 = false;
        }
        if (!z16 || (k3 = x16.b().k()) == null) {
            return null;
        }
        return Long.valueOf(k3.e()).toString();
    }

    @Nullable
    public final String p(long roomId, int query) {
        AudienceRoomInfo b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, this, Long.valueOf(roomId), Integer.valueOf(query));
        }
        e x16 = x(roomId, query);
        if (x16 != null && (b16 = x16.b()) != null) {
            return b16.p();
        }
        return null;
    }

    @NotNull
    public final String q(long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, this, Long.valueOf(j3), Integer.valueOf(i3));
        }
        e x16 = x(j3, i3);
        if (x16 != null) {
            return x16.b().getProgramId();
        }
        return "";
    }

    @Nullable
    public final e s(long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (e) iPatchRedirector.redirect((short) 6, this, Long.valueOf(j3), Integer.valueOf(i3));
        }
        return x(j3, i3);
    }

    @NotNull
    public final String u(long roomId, int query) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (String) iPatchRedirector.redirect((short) 24, this, Long.valueOf(roomId), Integer.valueOf(query));
        }
        e x16 = x(roomId, query);
        if (x16 != null) {
            return x16.b().getRoomName();
        }
        return "";
    }

    public final int v(long roomId, int query) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) {
            return 0;
        }
        return ((Integer) iPatchRedirector.redirect((short) 16, this, Long.valueOf(roomId), Integer.valueOf(query))).intValue();
    }

    @NotNull
    public final String y(long roomId, @NotNull StreamDefinition definition, int query) {
        com.tencent.mobileqq.qqlive.sail.model.audience.a s16;
        String e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (String) iPatchRedirector.redirect((short) 27, this, Long.valueOf(roomId), definition, Integer.valueOf(query));
        }
        Intrinsics.checkNotNullParameter(definition, "definition");
        e x16 = x(roomId, query);
        if (x16 == null || (s16 = x16.b().s(definition)) == null || (e16 = s16.e()) == null) {
            return "";
        }
        return e16;
    }

    @NotNull
    public final String z(long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (String) iPatchRedirector.redirect((short) 25, this, Long.valueOf(j3), Integer.valueOf(i3));
        }
        e x16 = x(j3, i3);
        if (x16 != null) {
            return x16.b().u();
        }
        return "";
    }
}

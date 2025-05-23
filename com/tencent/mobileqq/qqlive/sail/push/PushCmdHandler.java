package com.tencent.mobileqq.qqlive.sail.push;

import android.util.SparseArray;
import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tbs.reader.ITbsReaderTool;
import fp4.c;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b'\u0010(J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002R'\u0010\u000f\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00078\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\f\u001a\u0004\b\r\u0010\u000eR'\u0010\u0012\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\f\u001a\u0004\b\u0011\u0010\u000eR'\u0010\u0016\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\u000eR'\u0010\u001a\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\f\u001a\u0004\b\u0019\u0010\u000eR'\u0010\u001e\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\f\u001a\u0004\b\u001d\u0010\u000eR'\u0010\"\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u00078\u0006\u00a2\u0006\f\n\u0004\b \u0010\f\u001a\u0004\b!\u0010\u000eR(\u0010&\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00070#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/push/PushCmdHandler;", "", "", "cmd", "", "c", "(Ljava/lang/Integer;)Z", "Lkotlin/Function1;", "Lfp4/c;", "Lcom/google/protobuf/nano/MessageNano;", "b", "Lrq3/a;", "Lkotlin/jvm/functions/Function1;", "getNormalChatMsgHandler", "()Lkotlin/jvm/functions/Function1;", "normalChatMsgHandler", "Lqt3/a;", "getRoomVideoStateHandler", "roomVideoStateHandler", "Lqq3/a;", "d", "getFollowRoomHandler", "followRoomHandler", "Lgp4/a;", "e", "getExtDataHandler", "extDataHandler", "Lsq3/a;", "f", "getUserEnterRoomHandler", "userEnterRoomHandler", "Li11/a;", "g", "getSystemNoticeMsgHandler", "systemNoticeMsgHandler", "Landroid/util/SparseArray;", h.F, "Landroid/util/SparseArray;", "handlerMap", "<init>", "()V", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class PushCmdHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final PushCmdHandler f272371a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Function1<c, rq3.a> normalChatMsgHandler;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Function1<c, qt3.a> roomVideoStateHandler;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Function1<c, qq3.a> followRoomHandler;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Function1<c, gp4.a> extDataHandler;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Function1<c, sq3.a> userEnterRoomHandler;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Function1<c, i11.a> systemNoticeMsgHandler;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final SparseArray<Function1<c, MessageNano>> handlerMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(ITbsReaderTool.CALL_HOST_API);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        f272371a = new PushCmdHandler();
        PushCmdHandler$normalChatMsgHandler$1 pushCmdHandler$normalChatMsgHandler$1 = PushCmdHandler$normalChatMsgHandler$1.INSTANCE;
        normalChatMsgHandler = pushCmdHandler$normalChatMsgHandler$1;
        PushCmdHandler$roomVideoStateHandler$1 pushCmdHandler$roomVideoStateHandler$1 = PushCmdHandler$roomVideoStateHandler$1.INSTANCE;
        roomVideoStateHandler = pushCmdHandler$roomVideoStateHandler$1;
        PushCmdHandler$followRoomHandler$1 pushCmdHandler$followRoomHandler$1 = PushCmdHandler$followRoomHandler$1.INSTANCE;
        followRoomHandler = pushCmdHandler$followRoomHandler$1;
        PushCmdHandler$extDataHandler$1 pushCmdHandler$extDataHandler$1 = PushCmdHandler$extDataHandler$1.INSTANCE;
        extDataHandler = pushCmdHandler$extDataHandler$1;
        PushCmdHandler$userEnterRoomHandler$1 pushCmdHandler$userEnterRoomHandler$1 = PushCmdHandler$userEnterRoomHandler$1.INSTANCE;
        userEnterRoomHandler = pushCmdHandler$userEnterRoomHandler$1;
        PushCmdHandler$systemNoticeMsgHandler$1 pushCmdHandler$systemNoticeMsgHandler$1 = PushCmdHandler$systemNoticeMsgHandler$1.INSTANCE;
        systemNoticeMsgHandler = pushCmdHandler$systemNoticeMsgHandler$1;
        SparseArray<Function1<c, MessageNano>> sparseArray = new SparseArray<>();
        sparseArray.put(33, pushCmdHandler$normalChatMsgHandler$1);
        sparseArray.put(75, pushCmdHandler$roomVideoStateHandler$1);
        sparseArray.put(165, pushCmdHandler$followRoomHandler$1);
        sparseArray.put(167, pushCmdHandler$extDataHandler$1);
        sparseArray.put(235, pushCmdHandler$extDataHandler$1);
        sparseArray.put(234, pushCmdHandler$extDataHandler$1);
        sparseArray.put(263, pushCmdHandler$extDataHandler$1);
        sparseArray.put(232, pushCmdHandler$extDataHandler$1);
        sparseArray.put(233, pushCmdHandler$extDataHandler$1);
        sparseArray.put(285, pushCmdHandler$extDataHandler$1);
        sparseArray.put(200, pushCmdHandler$userEnterRoomHandler$1);
        sparseArray.put(255, pushCmdHandler$systemNoticeMsgHandler$1);
        handlerMap = sparseArray;
    }

    PushCmdHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean c(Integer cmd) {
        if (cmd == null) {
            return false;
        }
        if (cmd.intValue() != 232 && cmd.intValue() != 167 && cmd.intValue() != 235 && cmd.intValue() != 233 && cmd.intValue() != 234 && cmd.intValue() != 263 && cmd.intValue() != 285) {
            return false;
        }
        return true;
    }

    @Nullable
    public final Function1<c, MessageNano> b(int cmd) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Function1) iPatchRedirector.redirect((short) 2, (Object) this, cmd);
        }
        return handlerMap.get(cmd);
    }
}

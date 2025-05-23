package com.tencent.mobileqq.aio.reserve1.unreadbubble;

import androidx.annotation.UiThread;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.data.AIOContact;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.MsgNavigationEvent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.MsgSimpleInfo;
import com.tencent.mobileqq.aio.reserve1.unreadbubble.UnreadBubbleUI;
import com.tencent.mobileqq.aio.reserve1.unreadbubble.UnreadMsgIntent;
import com.tencent.mobileqq.aio.reserve1.unreadbubble.a;
import com.tencent.mobileqq.aio.utils.o;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.Foreground;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009d\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0011*\u00017\b\u0007\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001YB\u000f\u0012\u0006\u00103\u001a\u00020\n\u00a2\u0006\u0004\bW\u0010XJ\u0016\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0003J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0011H\u0002J\u0012\u0010\u0014\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0003J\b\u0010\u0015\u001a\u00020\bH\u0003J\b\u0010\u0016\u001a\u00020\bH\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0019H\u0002J.\u0010!\u001a\u00020\u001f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001b2\u0006\u0010 \u001a\u00020\u001fH\u0002J$\u0010#\u001a\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001b2\u0006\u0010 \u001a\u00020\u001fH\u0002J\u0010\u0010%\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020$H\u0002J\u0010\u0010'\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020&H\u0002J\u0010\u0010)\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020(H\u0002J\u0010\u0010+\u001a\u00020\b2\u0006\u0010*\u001a\u00020\u001fH\u0002J,\u0010/\u001a\u001e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020-0,j\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020-`.2\u0006\u0010*\u001a\u00020\u001fH\u0002J\u0010\u00102\u001a\u00020\b2\u0006\u00101\u001a\u000200H\u0016J\u0010\u00104\u001a\u00020\b2\u0006\u00103\u001a\u00020\nH\u0016J\b\u00105\u001a\u00020\bH\u0016J\u0010\u00106\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016R\u0014\u0010:\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010=\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010?\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010<R\u0018\u0010A\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010<R\u0016\u0010C\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010BR\u0016\u0010D\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010BR\u0018\u0010G\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010FR\u0018\u0010H\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010FR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010N\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010MR$\u0010Q\u001a\u00020\u001f2\u0006\u0010O\u001a\u00020\u001f8\u0002@BX\u0082\u000e\u00a2\u0006\f\n\u0004\bK\u0010M\"\u0004\bJ\u0010PR\u0016\u0010R\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010MR\u0016\u0010T\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010MR\u0018\u0010V\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010U\u00a8\u0006Z"}, d2 = {"Lcom/tencent/mobileqq/aio/reserve1/unreadbubble/f;", "Lcom/tencent/qqnt/aio/lazy/lazyInit/b;", "Lcom/tencent/mobileqq/aio/reserve1/unreadbubble/a;", "Lcom/tencent/mobileqq/aio/reserve1/unreadbubble/UnreadBubbleUI;", "Lcom/tencent/mvi/base/route/g;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "list", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "E", "Lcom/tencent/mobileqq/aio/reserve1/unreadbubble/UnreadMsgIntent$MsgListScrollEvent;", "u", "Lcom/tencent/mobileqq/aio/reserve1/unreadbubble/UnreadMsgIntent$ListScrollDistanceNotify;", "v", "Lcom/tencent/mobileqq/aio/reserve1/unreadbubble/UnreadMsgIntent$ListScrollStateChanged;", "w", "lastVisibleMsg", "L", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "H", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/aio/reserve1/unreadbubble/UnreadMsgIntent$NotifyReplyMsgInfo;", "M", "Lcom/tencent/mobileqq/aio/msg/MsgSimpleInfo;", "topMsg", "bottomMsg", "replyMsgInfo", "", "useSeq", BdhLogUtil.LogTag.Tag_Conn, "msg", "y", "Lcom/tencent/mobileqq/aio/reserve1/unreadbubble/a$a;", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/aio/reserve1/unreadbubble/UnreadMsgIntent$MsgOnRevokeEvent;", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/aio/reserve1/unreadbubble/a$b;", UserInfo.SEX_FEMALE, "isArrow", "D", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "r", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", "initMsgIntent", "l", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "t", "com/tencent/mobileqq/aio/reserve1/unreadbubble/f$b", "f", "Lcom/tencent/mobileqq/aio/reserve1/unreadbubble/f$b;", "mAction", h.F, "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "mAIOBottomReadMsg", "i", "mAioLastRecMsg", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mAioFirstRecMsg", "J", "mUnreadCnt", "mLastUnreadCnt", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "mAioLatestTopMsg", "mAIORepoLastMsg", "", "G", "I", "mScrollDy", "Z", "mOutOfOneScreen", "value", "(Z)V", "mShowJumpBottomBtn", "mEnableUnreadBubble", "K", "hasMsgLoad", "Lcom/tencent/mobileqq/aio/msg/MsgSimpleInfo;", "mReplyMsgInfo", "<init>", "(Lcom/tencent/mvi/base/route/MsgIntent;)V", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes11.dex */
public final class f extends com.tencent.qqnt.aio.lazy.lazyInit.b<a, UnreadBubbleUI> {
    static IPatchRedirector $redirector_;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private long mUnreadCnt;

    /* renamed from: D, reason: from kotlin metadata */
    private long mLastUnreadCnt;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private AIOMsgItem mAioLatestTopMsg;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private AIOMsgItem mAIORepoLastMsg;

    /* renamed from: G, reason: from kotlin metadata */
    private int mScrollDy;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean mOutOfOneScreen;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean mShowJumpBottomBtn;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean mEnableUnreadBubble;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean hasMsgLoad;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private MsgSimpleInfo mReplyMsgInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MsgRecord mAIOBottomReadMsg;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MsgRecord mAioLastRecMsg;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MsgRecord mAioFirstRecMsg;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/aio/reserve1/unreadbubble/f$a;", "", "", "EM_BAS_DOWN_JUMP_ARROW", "Ljava/lang/String;", "EM_BAS_UNREAD_BUBBLE", "TAG", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.reserve1.unreadbubble.f$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/reserve1/unreadbubble/f$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                f.this.E(i3);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return a.C9235a.a(this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64833);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NotNull MsgIntent initMsgIntent) {
        super(initMsgIntent);
        Intrinsics.checkNotNullParameter(initMsgIntent, "initMsgIntent");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) initMsgIntent);
        } else {
            this.mAction = new b();
            this.mEnableUnreadBubble = true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x005e, code lost:
    
        if (r6 < r1.getMsgSeq()) goto L16;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @UiThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void A(List<MsgRecord> list) {
        Object last;
        Object first;
        Object last2;
        if (this.hasMsgLoad && (!list.isEmpty())) {
            String str = o.b(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c()).peerUid;
            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) list);
            if (Intrinsics.areEqual(((MsgRecord) last).peerUid, str)) {
                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
                MsgRecord msgRecord = (MsgRecord) first;
                if (msgRecord.getMsgSeq() > 0) {
                    if (this.mAioFirstRecMsg != null) {
                        long msgSeq = msgRecord.getMsgSeq();
                        MsgRecord msgRecord2 = this.mAioFirstRecMsg;
                        Intrinsics.checkNotNull(msgRecord2);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("UnreadBubbleVM", 2, "onMsgReceive firstSeq=" + msgRecord.getMsgSeq());
                    }
                    this.mAioFirstRecMsg = msgRecord;
                }
                last2 = CollectionsKt___CollectionsKt.last((List<? extends Object>) list);
                MsgRecord msgRecord3 = (MsgRecord) last2;
                if (msgRecord3.getMsgSeq() > 0) {
                    if (this.mAioLastRecMsg != null) {
                        long msgSeq2 = msgRecord3.getMsgSeq();
                        MsgRecord msgRecord4 = this.mAioLastRecMsg;
                        Intrinsics.checkNotNull(msgRecord4);
                        if (msgSeq2 <= msgRecord4.getMsgSeq()) {
                            return;
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("UnreadBubbleVM", 2, "onMsgReceive lastSeq=" + msgRecord3.getMsgSeq());
                    }
                    this.mAioLastRecMsg = msgRecord3;
                    if (q() == -1) {
                        return;
                    }
                    ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.aio.reserve1.unreadbubble.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            f.B(f.this);
                        }
                    }, 100L);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(f this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.z();
    }

    private final boolean C(MsgSimpleInfo topMsg, MsgSimpleInfo bottomMsg, MsgSimpleInfo replyMsgInfo, boolean useSeq) {
        if (topMsg != null && bottomMsg != null) {
            if (replyMsgInfo == null || y(topMsg, replyMsgInfo, useSeq) || !y(bottomMsg, replyMsgInfo, useSeq)) {
                return false;
            }
            QLog.i("UnreadBubbleVM", 1, "[replyMsgIsOnScreen]: replyMsg is onScreen");
            return true;
        }
        QLog.i("UnreadBubbleVM", 1, "[replyMsgIsOnScreen]: param is invalid");
        return false;
    }

    private final void D(boolean isArrow) {
        String str;
        if (isArrow) {
            str = "em_bas_down_jump_arrow";
        } else {
            str = "em_bas_unread_bubble";
        }
        com.tencent.mobileqq.aio.utils.b.l(str, r(isArrow));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent intent) {
        if (intent instanceof UnreadMsgIntent.MsgListScrollEvent) {
            u((UnreadMsgIntent.MsgListScrollEvent) intent);
            return;
        }
        if (intent instanceof UnreadMsgIntent.ListScrollDistanceNotify) {
            v((UnreadMsgIntent.ListScrollDistanceNotify) intent);
            return;
        }
        if (intent instanceof UnreadMsgIntent.ListScrollStateChanged) {
            w((UnreadMsgIntent.ListScrollStateChanged) intent);
            return;
        }
        if (intent instanceof UnreadMsgIntent.NotifyReplyMsgInfo) {
            M((UnreadMsgIntent.NotifyReplyMsgInfo) intent);
            return;
        }
        if (intent instanceof UnreadMsgIntent.MsgOnRevokeEvent) {
            x((UnreadMsgIntent.MsgOnRevokeEvent) intent);
            return;
        }
        if (intent instanceof UnreadMsgIntent.MsgReceive) {
            A(((UnreadMsgIntent.MsgReceive) intent).a());
            return;
        }
        if (intent instanceof UnreadMsgIntent.MsgCountChange) {
            UnreadMsgIntent.MsgCountChange msgCountChange = (UnreadMsgIntent.MsgCountChange) intent;
            if (msgCountChange.a() != null) {
                this.mAIORepoLastMsg = msgCountChange.a();
                return;
            }
            this.mAIORepoLastMsg = null;
            this.mUnreadCnt = 0L;
            updateUI(new UnreadBubbleUI.UnreadCntChanged(0L));
        }
    }

    private final void F(a.b intent) {
        String str;
        if (intent.a()) {
            str = "em_bas_down_jump_arrow";
        } else {
            str = "em_bas_unread_bubble";
        }
        com.tencent.mobileqq.aio.utils.b.q(str, r(intent.a()));
    }

    private final void G(boolean z16) {
        if (this.mShowJumpBottomBtn != z16) {
            updateUI(new UnreadBubbleUI.JumpBottomBtnState(z16));
        }
        this.mShowJumpBottomBtn = z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void H() {
        if (!Foreground.isCurrentProcessForeground()) {
            return;
        }
        final AIOContact c16 = ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.aio.reserve1.unreadbubble.d
            @Override // java.lang.Runnable
            public final void run() {
                f.J(AIOContact.this);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(AIOContact contact) {
        Intrinsics.checkNotNullParameter(contact, "$contact");
        QLog.i("UnreadBubbleVM", 1, "setMsgRead");
        ((IMsgService) QRoute.api(IMsgService.class)).setMsgRead(o.b(contact), new IOperateCallback() { // from class: com.tencent.mobileqq.aio.reserve1.unreadbubble.e
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                f.K(i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(int i3, String str) {
        QLog.i("UnreadBubbleVM", 1, "setMsgRead result = " + i3 + ", errMsg = " + str);
    }

    @UiThread
    private final void L(MsgRecord lastVisibleMsg) {
        Long l3;
        if (this.mEnableUnreadBubble && lastVisibleMsg != null && lastVisibleMsg.getMsgSeq() > 0) {
            if (this.mAIOBottomReadMsg != null) {
                long msgSeq = lastVisibleMsg.getMsgSeq();
                MsgRecord msgRecord = this.mAIOBottomReadMsg;
                Intrinsics.checkNotNull(msgRecord);
                if (msgSeq <= msgRecord.getMsgSeq()) {
                    return;
                }
            }
            this.mAIOBottomReadMsg = lastVisibleMsg;
            if (QLog.isColorLevel()) {
                MsgRecord msgRecord2 = this.mAIOBottomReadMsg;
                if (msgRecord2 != null) {
                    l3 = Long.valueOf(msgRecord2.getMsgSeq());
                } else {
                    l3 = null;
                }
                QLog.d("UnreadBubbleVM", 2, "updateAIOBottomReadMsg " + l3);
            }
            z();
        }
    }

    private final void M(UnreadMsgIntent.NotifyReplyMsgInfo intent) {
        Long l3;
        Long l16;
        this.mReplyMsgInfo = intent.a();
        G(true);
        MsgSimpleInfo msgSimpleInfo = this.mReplyMsgInfo;
        Long l17 = null;
        if (msgSimpleInfo != null) {
            l3 = Long.valueOf(msgSimpleInfo.a());
        } else {
            l3 = null;
        }
        MsgSimpleInfo msgSimpleInfo2 = this.mReplyMsgInfo;
        if (msgSimpleInfo2 != null) {
            l16 = Long.valueOf(msgSimpleInfo2.b());
        } else {
            l16 = null;
        }
        MsgSimpleInfo msgSimpleInfo3 = this.mReplyMsgInfo;
        if (msgSimpleInfo3 != null) {
            l17 = Long.valueOf(msgSimpleInfo3.c());
        }
        QLog.i("UnreadBubbleVM", 1, "[updateReplyMsgInfo]: reply msgId is " + l3 + ", msgSeq is " + l16 + "\uff0c msgTime is " + l17);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final long q() {
        AIOMsgListEvent.GetCurFocusIndex getCurFocusIndex = new AIOMsgListEvent.GetCurFocusIndex(0L, 1, null);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(getCurFocusIndex);
        return getCurFocusIndex.a();
    }

    private final HashMap<String, String> r(boolean isArrow) {
        String str;
        HashMap<String, String> hashMap = new HashMap<>();
        if (!isArrow) {
            hashMap.put("unread_messages_number", String.valueOf(this.mUnreadCnt));
        }
        if (this.mReplyMsgInfo == null) {
            str = "1";
        } else {
            str = "2";
        }
        hashMap.put("jump_scene", str);
        return hashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void s(a.C7352a intent) {
        Unit unit;
        if (this.mUnreadCnt > 0) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new MsgNavigationEvent.NavigateToBottomEvent("unread_bubble"));
        } else {
            MsgSimpleInfo msgSimpleInfo = this.mReplyMsgInfo;
            if (msgSimpleInfo != null) {
                if (msgSimpleInfo.a() > 0) {
                    ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new MsgNavigationEvent.NavigateByIdEvent("UnreadBubbleVM", msgSimpleInfo.a(), false, null, true, null, 44, null));
                    intent.c(true);
                } else if (msgSimpleInfo.b() > 0) {
                    ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new MsgNavigationEvent.NavigateBySeqEvent("UnreadBubbleVM", msgSimpleInfo.b(), 0L, false, null, false, true, null, 188, null));
                    intent.c(true);
                } else {
                    ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new MsgNavigationEvent.NavigateToBottomEvent("unread_bubble"));
                }
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new MsgNavigationEvent.NavigateToBottomEvent("unread_bubble"));
            }
        }
        D(intent.a());
        this.mReplyMsgInfo = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x004b, code lost:
    
        if (r6 <= r8.getMsgSeq()) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0060, code lost:
    
        if (r6 > r8.getMsgRecord().msgTime) goto L19;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void u(UnreadMsgIntent.MsgListScrollEvent intent) {
        MsgRecord msgRecord;
        boolean z16;
        MsgSimpleInfo msgSimpleInfo;
        MsgSimpleInfo msgSimpleInfo2;
        MsgSimpleInfo msgSimpleInfo3;
        Long l3;
        MsgRecord msgRecord2;
        MsgRecord msgRecord3;
        Long l16;
        boolean z17 = true;
        this.hasMsgLoad = true;
        AIOMsgItem a16 = intent.a();
        Long l17 = null;
        if (a16 != null) {
            msgRecord = a16.getMsgRecord();
        } else {
            msgRecord = null;
        }
        L(msgRecord);
        if (((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().e() == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        AIOMsgItem b16 = intent.b();
        if (b16 != null) {
            if (this.mAioLatestTopMsg != null) {
                if (z16) {
                    long msgSeq = b16.getMsgSeq();
                    AIOMsgItem aIOMsgItem = this.mAioLatestTopMsg;
                    Intrinsics.checkNotNull(aIOMsgItem);
                }
                long j3 = b16.getMsgRecord().msgTime;
                AIOMsgItem aIOMsgItem2 = this.mAioLatestTopMsg;
                Intrinsics.checkNotNull(aIOMsgItem2);
            }
            this.mAioLatestTopMsg = b16;
        }
        AIOMsgItem b17 = intent.b();
        if (b17 != null) {
            msgSimpleInfo = com.tencent.mobileqq.aio.utils.d.l(b17);
        } else {
            msgSimpleInfo = null;
        }
        AIOMsgItem a17 = intent.a();
        if (a17 != null) {
            msgSimpleInfo2 = com.tencent.mobileqq.aio.utils.d.l(a17);
        } else {
            msgSimpleInfo2 = null;
        }
        if (C(msgSimpleInfo, msgSimpleInfo2, this.mReplyMsgInfo, z16)) {
            this.mReplyMsgInfo = null;
        }
        AIOMsgItem aIOMsgItem3 = this.mAIORepoLastMsg;
        if (aIOMsgItem3 != null && intent.a() != null && this.mAioLatestTopMsg != null) {
            AIOMsgItem a18 = intent.a();
            if (a18 != null) {
                msgSimpleInfo3 = com.tencent.mobileqq.aio.utils.d.l(a18);
            } else {
                msgSimpleInfo3 = null;
            }
            if (y(msgSimpleInfo3, this.mReplyMsgInfo, z16)) {
                boolean z18 = this.mOutOfOneScreen;
                if ((!z16 || intent.a().getMsgSeq() >= aIOMsgItem3.getMsgSeq()) && intent.a().getMsgRecord().msgTime >= aIOMsgItem3.getMsgRecord().msgTime) {
                    z17 = false;
                }
                this.mOutOfOneScreen = z17;
                if (z18 != z17) {
                    if (z16) {
                        if (QLog.isColorLevel()) {
                            boolean z19 = this.mOutOfOneScreen;
                            AIOMsgItem a19 = intent.a();
                            if (a19 != null) {
                                l16 = Long.valueOf(a19.getMsgSeq());
                            } else {
                                l16 = null;
                            }
                            AIOMsgItem aIOMsgItem4 = this.mAioLatestTopMsg;
                            if (aIOMsgItem4 != null) {
                                l17 = Long.valueOf(aIOMsgItem4.getMsgSeq());
                            }
                            QLog.i("UnreadBubbleVM", 2, "[handleListScroll]: outOfScreenChange to " + z19 + ", aioBottomMsgSeq is " + l16 + ", aioLatestTopMsgSeq is " + l17);
                        }
                    } else if (QLog.isColorLevel()) {
                        boolean z26 = this.mOutOfOneScreen;
                        AIOMsgItem a26 = intent.a();
                        if (a26 != null && (msgRecord3 = a26.getMsgRecord()) != null) {
                            l3 = Long.valueOf(msgRecord3.msgTime);
                        } else {
                            l3 = null;
                        }
                        AIOMsgItem aIOMsgItem5 = this.mAioLatestTopMsg;
                        if (aIOMsgItem5 != null && (msgRecord2 = aIOMsgItem5.getMsgRecord()) != null) {
                            l17 = Long.valueOf(msgRecord2.msgTime);
                        }
                        QLog.i("UnreadBubbleVM", 2, "[handleListScroll]: outOfScreenChange to " + z26 + ", aioBottomMsgTime is " + l3 + ", aioLatestTopMsgTime is " + l17);
                    }
                }
                if (!this.mOutOfOneScreen) {
                    G(false);
                }
            }
        }
    }

    private final void v(UnreadMsgIntent.ListScrollDistanceNotify intent) {
        int a16 = this.mScrollDy + intent.a();
        this.mScrollDy = a16;
        if (Math.abs(a16) < 20 || this.mReplyMsgInfo != null) {
            return;
        }
        if (this.mScrollDy > 0 && !intent.b()) {
            G(this.mOutOfOneScreen);
        } else if (this.mScrollDy < 0) {
            G(false);
        }
        this.mScrollDy = 0;
    }

    private final void w(UnreadMsgIntent.ListScrollStateChanged intent) {
        if (intent.a() == 0 && q() == -1 && this.mShowJumpBottomBtn) {
            G(false);
            QLog.i("UnreadBubbleVM", 1, "[handleListScrollStateChange]: recycleView state idle, focus bottom, still show bottombtn, then hide");
        }
    }

    private final void x(UnreadMsgIntent.MsgOnRevokeEvent intent) {
        MsgSimpleInfo msgSimpleInfo = this.mReplyMsgInfo;
        boolean z16 = false;
        if (msgSimpleInfo != null && intent.a() == msgSimpleInfo.a()) {
            z16 = true;
        }
        if (z16) {
            QLog.i("UnreadBubbleVM", 1, "[handleMsgRevoke]: replyMsg revoked");
            this.mReplyMsgInfo = null;
        }
    }

    private final boolean y(MsgSimpleInfo msg2, MsgSimpleInfo replyMsgInfo, boolean useSeq) {
        if (msg2 == null) {
            return false;
        }
        if (replyMsgInfo == null) {
            return true;
        }
        if (useSeq) {
            if (msg2.b() < replyMsgInfo.b()) {
                return false;
            }
            return true;
        }
        if (msg2.c() < replyMsgInfo.c()) {
            return false;
        }
        return true;
    }

    @UiThread
    private final void z() {
        long coerceAtLeast;
        if (this.mAioLastRecMsg != null && this.mAioFirstRecMsg != null && this.mAIOBottomReadMsg != null) {
            if (this.mUnreadCnt == 0 && q() == -1) {
                return;
            }
            MsgRecord msgRecord = this.mAIOBottomReadMsg;
            Intrinsics.checkNotNull(msgRecord);
            long msgSeq = msgRecord.getMsgSeq() + 1;
            MsgRecord msgRecord2 = this.mAioFirstRecMsg;
            Intrinsics.checkNotNull(msgRecord2);
            long max = Math.max(msgSeq, msgRecord2.getMsgSeq());
            MsgRecord msgRecord3 = this.mAioLastRecMsg;
            Intrinsics.checkNotNull(msgRecord3);
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast((msgRecord3.getMsgSeq() - max) + 1, 0L);
            this.mUnreadCnt = coerceAtLeast;
            if (this.mLastUnreadCnt != coerceAtLeast) {
                if (coerceAtLeast == 0) {
                    H();
                }
                updateUI(new UnreadBubbleUI.UnreadCntChanged(this.mUnreadCnt));
                if (QLog.isDevelopLevel()) {
                    QLog.d("UnreadBubbleVM", 4, "notifyLocalUnreadChanged unread = " + this.mUnreadCnt);
                }
            }
            this.mLastUnreadCnt = this.mUnreadCnt;
        }
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Set) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.reserve1.unreadbubble.UnreadMsgIntent.MsgListScrollEvent");
        hashSet.add("com.tencent.mobileqq.aio.reserve1.unreadbubble.UnreadMsgIntent.ListScrollDistanceNotify");
        hashSet.add("com.tencent.mobileqq.aio.reserve1.unreadbubble.UnreadMsgIntent.MsgOnRevokeEvent");
        hashSet.add("com.tencent.mobileqq.aio.reserve1.unreadbubble.UnreadMsgIntent.ListScrollStateChanged");
        hashSet.add("com.tencent.mobileqq.aio.reserve1.unreadbubble.UnreadMsgIntent.NotifyReplyMsgInfo");
        hashSet.add("com.tencent.mobileqq.aio.reserve1.unreadbubble.UnreadMsgIntent.MsgReceive");
        hashSet.add("com.tencent.mobileqq.aio.reserve1.unreadbubble.UnreadMsgIntent.MsgCountChange");
        return hashSet;
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Set) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return new HashSet();
    }

    @Override // com.tencent.qqnt.aio.lazy.lazyInit.b
    public void l(@NotNull MsgIntent initMsgIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) initMsgIntent);
        } else {
            Intrinsics.checkNotNullParameter(initMsgIntent, "initMsgIntent");
            E(initMsgIntent);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.aio.baseVM.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onDestroy();
        ((com.tencent.aio.api.runtime.a) getMContext()).e().i(this, this.mAction);
        this.mAIOBottomReadMsg = null;
        this.mAioLastRecMsg = null;
        this.mAioFirstRecMsg = null;
        this.mUnreadCnt = 0L;
        this.mLastUnreadCnt = 0L;
        this.mAioLatestTopMsg = null;
        this.mAIORepoLastMsg = null;
        this.mScrollDy = 0;
        this.mOutOfOneScreen = false;
        G(false);
        this.mReplyMsgInfo = null;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.C7352a) {
            s((a.C7352a) intent);
        } else if (intent instanceof a.b) {
            F((a.b) intent);
        }
    }

    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        context.e().f(this, this.mAction);
        int e16 = context.g().r().c().e();
        boolean z16 = true;
        if (e16 != 1 && e16 != 2 && e16 != 100) {
            z16 = false;
        }
        this.mEnableUnreadBubble = z16;
        this.hasMsgLoad = false;
    }
}

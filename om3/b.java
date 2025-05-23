package om3;

import android.os.Handler;
import android.os.Looper;
import com.tencent.component.core.event.EventCenter;
import com.tencent.component.core.event.Eventor;
import com.tencent.component.core.event.impl.OnEvent;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.now.linkpkanchorplay.event.UIEvent;
import com.tencent.now.linkpkanchorplay.event.d;
import com.tencent.qqlive.common.api.AegisLogger;
import g55.ag;
import hn3.LinkScreenAnchorInfo;
import hn3.LinkScreenEvent;
import hn3.PKEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import om3.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 G2\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\bE\u0010FJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J(\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0006H\u0002J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u0019\u001a\u00020\u0006H\u0002J\b\u0010\u001a\u001a\u00020\u0006H\u0002J\b\u0010\u001b\u001a\u00020\u000eH\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\u0016J \u0010 \u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u0010\u0010\"\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\bH\u0016J\u0010\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#H\u0016J \u0010'\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010)\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020(H\u0016J\u001a\u0010+\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010*H\u0016J\b\u0010,\u001a\u00020\bH\u0016J\b\u0010-\u001a\u00020\bH\u0016J\b\u0010.\u001a\u00020\u0002H\u0016J\n\u0010/\u001a\u0004\u0018\u00010\u0015H\u0016J\u0006\u00100\u001a\u00020\u0006R\u0016\u00102\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u00101R\u0018\u00104\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u00103R\u0016\u00106\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u00105R\u0018\u00108\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u00107R\u0018\u0010:\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u00109R\u0016\u0010\u001d\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010;R\u0014\u0010>\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010=R\u0016\u0010A\u001a\u00020?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010@R\u0014\u0010D\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010C\u00a8\u0006H"}, d2 = {"Lom3/b;", "Lom3/e;", "", "inviteBizType", "Le55/a;", "anchorInfo", "", "t", "", "isPKGame", "pkType", "allowStartPK", "u", ReportConstant.COSTREPORT_PREFIX, "Lom3/d;", "nextState", BdhLogUtil.LogTag.Tag_Conn, "Lhn3/b;", "event", "w", "v", "Lhn3/d;", "pkEvent", "y", HippyTKDListViewAdapter.X, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "getCurrentState", "f", "bizType", "", "inviteID", h.F, "isSelfCancel", "c", "Lg55/ag;", "inviteMsg", "g", "isAccept", "e", "Lcom/tencent/now/linkpkanchorplay/event/UIEvent$PKType;", "a", "Le55/c;", "b", "d", "i", "getBizType", "r", "B", "Lom3/d;", "currentState", "Le55/a;", "currentLinkScreenAnchor", "Z", "isInLinking", "Lhn3/d;", "pkEventInfo", "Lhn3/b;", "linkScreenEventInfo", "I", "Lcom/tencent/component/core/event/Eventor;", "Lcom/tencent/component/core/event/Eventor;", "eventor", "", "J", "gameStartTime", "Landroid/os/Handler;", "Landroid/os/Handler;", "fixLinScreenStatusHandler", "<init>", "()V", "j", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class b implements e {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private e55.a currentLinkScreenAnchor;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isInLinking;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PKEvent pkEventInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinkScreenEvent linkScreenEventInfo;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Eventor eventor;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long gameStartTime;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler fixLinScreenStatusHandler;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private d currentState = new d.c();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int bizType = 3;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"om3/b$a", "Lcom/tencent/component/core/event/impl/OnEvent;", "Lhn3/b;", "event", "", "a", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class a implements OnEvent<LinkScreenEvent> {
        a() {
        }

        @Override // com.tencent.component.core.event.impl.OnEvent
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onRecv(@NotNull LinkScreenEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            AegisLogger.INSTANCE.i("PK_Biz|AnchorLinkMicStateMgr", "\u6536\u5230LinkPkEvent: " + event);
            b.this.linkScreenEventInfo = event;
            if (event.getType() == 1 && !b.this.isInLinking) {
                b.this.w(event);
            } else if (event.getType() == 2) {
                b.this.v();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"om3/b$b", "Lcom/tencent/component/core/event/impl/OnEvent;", "Lhn3/d;", "event", "", "a", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: om3.b$b, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static final class C10926b implements OnEvent<PKEvent> {
        C10926b() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x005a, code lost:
        
            if (r1 == false) goto L20;
         */
        @Override // com.tencent.component.core.event.impl.OnEvent
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onRecv(@NotNull PKEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            AegisLogger.INSTANCE.i("PK_Biz|AnchorLinkMicStateMgr", "\u6536\u5230PKEvent: " + event);
            boolean z16 = true;
            if (event.getEventType() == 1 || event.getEventType() == 3) {
                if (event.getPkStatus() == 4 || event.getPkStatus() == 6) {
                    b.this.x(event.getPkType());
                } else {
                    if (b.this.i()) {
                        PKEvent pkEventInfo = b.this.getPkEventInfo();
                        if (pkEventInfo == null || pkEventInfo.getPkType() != event.getPkType()) {
                            z16 = false;
                        }
                    }
                    b.this.y(event);
                }
            }
            if (event.getEventType() == 2) {
                b.this.x(event.getPkType());
            }
        }
    }

    public b() {
        Eventor eventor = new Eventor();
        this.eventor = eventor;
        this.fixLinScreenStatusHandler = new Handler(Looper.getMainLooper());
        eventor.addOnEvent(new a()).addOnEvent(new C10926b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(b this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.q();
    }

    private final void C(d nextState) {
        d dVar = this.currentState;
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        companion.i("PK_Biz|AnchorLinkMicStateMgr", "\u5bf9\u6bd4: currentState: " + this.currentState + ", nextState: " + nextState);
        this.currentState = nextState;
        if (c.f423174a.e(dVar, nextState)) {
            companion.i("PK_Biz|AnchorLinkMicStateMgr", "\u4e8b\u4ef6\u901a\u77e5 StateChange: " + this.currentState);
            EventCenter.post(new d.StateChangeEvent(this.currentState, dVar, getIsInLinking(), i()));
        }
    }

    private final void q() {
        LinkScreenEvent linkScreenEvent = this.linkScreenEventInfo;
        boolean z16 = false;
        if (linkScreenEvent != null && linkScreenEvent.getType() == 1) {
            z16 = true;
        }
        if (!z16) {
            C(new d.c());
        }
    }

    private final int s(int inviteBizType) {
        if (inviteBizType != 1) {
            if (inviteBizType != 5) {
                return 3;
            }
            return 2;
        }
        return 0;
    }

    private final void t(int inviteBizType, e55.a anchorInfo) {
        boolean z16;
        boolean z17 = false;
        if (this.bizType != 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        int s16 = s(inviteBizType);
        if (s16 != 2) {
            z17 = true;
        }
        u(z16, s16, anchorInfo, z17);
    }

    private final void u(boolean isPKGame, int pkType, e55.a anchorInfo, boolean allowStartPK) {
        AegisLogger.INSTANCE.i("PK_Biz|AnchorLinkMicStateMgr", "onGameStarted isPKGame " + isPKGame + ", pkType:" + pkType);
        this.gameStartTime = System.currentTimeMillis();
        C(new d.InLinkScreen(anchorInfo, i(), pkType, allowStartPK));
        this.currentLinkScreenAnchor = anchorInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v() {
        if (c.f423174a.d(this.currentState) && i()) {
            return;
        }
        if (System.currentTimeMillis() - this.gameStartTime <= 5000) {
            z();
            return;
        }
        this.isInLinking = false;
        this.currentLinkScreenAnchor = null;
        C(new d.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(LinkScreenEvent event) {
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        companion.i("PK_Biz|AnchorLinkMicStateMgr", "onLinkScreenStart");
        if (event.getLinkScreenAnchorInfo() == null) {
            companion.e("PK_Biz|AnchorLinkMicStateMgr", "onLinkScreenStart", "receive LinkScreen push, but anchorInfo is null.");
            return;
        }
        this.isInLinking = true;
        c cVar = c.f423174a;
        LinkScreenAnchorInfo linkScreenAnchorInfo = event.getLinkScreenAnchorInfo();
        Intrinsics.checkNotNull(linkScreenAnchorInfo);
        e55.a a16 = cVar.a(linkScreenAnchorInfo);
        this.currentLinkScreenAnchor = a16;
        zm3.a.f452778a.e(a16);
        e55.a aVar = this.currentLinkScreenAnchor;
        Intrinsics.checkNotNull(aVar);
        C(new d.InLinkScreen(aVar, i(), 0, false, 12, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0085, code lost:
    
        if (r9 == false) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void x(int pkType) {
        Integer num;
        boolean z16;
        int i3;
        boolean z17;
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        companion.i("PK_Biz|AnchorLinkMicStateMgr", "onPkEnd, pkType:" + pkType);
        boolean z18 = true;
        if (pkType == 1) {
            this.isInLinking = false;
            this.pkEventInfo = null;
            C(new d.c());
            return;
        }
        if ((pkType != 2 && pkType != 3) || !i()) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onPkEnd,isLinking: ");
        sb5.append(this.isInLinking);
        sb5.append(" pkType: ");
        PKEvent pKEvent = this.pkEventInfo;
        if (pKEvent != null) {
            num = Integer.valueOf(pKEvent.getPkType());
        } else {
            num = null;
        }
        sb5.append(num);
        companion.i("PK_Biz|AnchorLinkMicStateMgr", sb5.toString());
        PKEvent pKEvent2 = this.pkEventInfo;
        if (pKEvent2 != null && pKEvent2.getPkType() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            PKEvent pKEvent3 = this.pkEventInfo;
            if (pKEvent3 != null && pKEvent3.getPkType() == 2) {
                z17 = true;
            } else {
                z17 = false;
            }
        }
        z18 = false;
        PKEvent pKEvent4 = this.pkEventInfo;
        if (pKEvent4 != null) {
            i3 = pKEvent4.getPkType();
        } else {
            i3 = 0;
        }
        companion.i("PK_Biz|AnchorLinkMicStateMgr", "onPkEnd,isLinking: " + this.isInLinking + ", allowStartPK: " + z18 + ", pkType:" + i3);
        this.pkEventInfo = null;
        if (this.isInLinking) {
            e55.a aVar = this.currentLinkScreenAnchor;
            Intrinsics.checkNotNull(aVar);
            C(new d.InLinkScreen(aVar, false, i3, z18));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(PKEvent pkEvent) {
        AegisLogger.INSTANCE.i("PK_Biz|AnchorLinkMicStateMgr", "onPkStart,pkType: " + pkEvent.getPkType());
        if (c.f423174a.b(pkEvent.getPkType()) && !getIsInLinking()) {
            return;
        }
        this.pkEventInfo = pkEvent;
        if (pkEvent.getAnchorInfo() != null) {
            e55.a aVar = new e55.a();
            aVar.f395729a = pkEvent.getAnchorInfo();
            this.currentLinkScreenAnchor = aVar;
        }
        e55.a aVar2 = this.currentLinkScreenAnchor;
        Intrinsics.checkNotNull(aVar2);
        C(new d.InLinkScreen(aVar2, i(), pkEvent.getPkType(), false, 8, null));
    }

    private final void z() {
        AegisLogger.INSTANCE.i("PK_Biz|AnchorLinkMicStateMgr", "link screen starts less than 5s,not process!");
        this.fixLinScreenStatusHandler.postDelayed(new Runnable() { // from class: om3.a
            @Override // java.lang.Runnable
            public final void run() {
                b.A(b.this);
            }
        }, 5000L);
    }

    public final void B() {
        this.eventor.removeAll();
        this.fixLinScreenStatusHandler.removeCallbacksAndMessages(null);
    }

    @Override // om3.e
    public void a(@NotNull UIEvent.PKType pkType) {
        Intrinsics.checkNotNullParameter(pkType, "pkType");
        C(new d.InMatch(pkType));
    }

    @Override // om3.e
    public void b(int pkType, @Nullable e55.c anchorInfo) {
        if (anchorInfo == null) {
            if (this.currentState instanceof d.InLinkScreen) {
                AegisLogger.INSTANCE.e("PK_Biz|AnchorLinkMicStateMgr", "endMatch", "match failed, but curState is InLinkScreen");
                return;
            } else {
                C(new d.c());
                return;
            }
        }
        AegisLogger.INSTANCE.i("PK_Biz|AnchorLinkMicStateMgr", "\u5339\u914d\u6210\u529f, " + anchorInfo);
        e55.a aVar = new e55.a();
        aVar.f395729a = anchorInfo;
        Unit unit = Unit.INSTANCE;
        u(true, pkType, aVar, !c.f423174a.c(pkType));
    }

    @Override // om3.e
    public void c(boolean isSelfCancel) {
        AegisLogger.INSTANCE.i("PK_Biz|AnchorLinkMicStateMgr", "inviteCancelled, isSelfCancel:" + isSelfCancel);
        if (!this.isInLinking) {
            C(new d.c());
            return;
        }
        if (i()) {
            PKEvent pKEvent = this.pkEventInfo;
            Intrinsics.checkNotNull(pKEvent);
            y(pKEvent);
        } else if (this.isInLinking) {
            e55.a aVar = this.currentLinkScreenAnchor;
            Intrinsics.checkNotNull(aVar);
            C(new d.InLinkScreen(aVar, i(), 0, false, 12, null));
        }
    }

    @Override // om3.e
    /* renamed from: d, reason: from getter */
    public boolean getIsInLinking() {
        return this.isInLinking;
    }

    @Override // om3.e
    public void e(boolean isAccept, int inviteBizType, @NotNull e55.a anchorInfo) {
        Intrinsics.checkNotNullParameter(anchorInfo, "anchorInfo");
        AegisLogger.INSTANCE.i("PK_Biz|AnchorLinkMicStateMgr", "responseInvite isAccept " + isAccept);
        if (isAccept) {
            t(inviteBizType, anchorInfo);
            return;
        }
        if (!this.isInLinking) {
            C(new d.c());
            return;
        }
        if (i()) {
            PKEvent pKEvent = this.pkEventInfo;
            Intrinsics.checkNotNull(pKEvent);
            y(pKEvent);
        } else if (this.isInLinking) {
            e55.a aVar = this.currentLinkScreenAnchor;
            Intrinsics.checkNotNull(aVar);
            C(new d.InLinkScreen(aVar, i(), 0, false, 12, null));
        }
    }

    @Override // om3.e
    @Nullable
    /* renamed from: f, reason: from getter */
    public e55.a getCurrentLinkScreenAnchor() {
        return this.currentLinkScreenAnchor;
    }

    @Override // om3.e
    public void g(@NotNull ag inviteMsg) {
        Intrinsics.checkNotNullParameter(inviteMsg, "inviteMsg");
        C(new d.C10927d(inviteMsg));
    }

    @Override // om3.e
    public int getBizType() {
        return this.bizType;
    }

    @Override // om3.e
    @NotNull
    public d getCurrentState() {
        return this.currentState;
    }

    @Override // om3.e
    public void h(@NotNull e55.a anchorInfo, int bizType, @NotNull String inviteID) {
        Intrinsics.checkNotNullParameter(anchorInfo, "anchorInfo");
        Intrinsics.checkNotNullParameter(inviteID, "inviteID");
        C(new d.InvitationSent(anchorInfo, bizType, inviteID));
        this.bizType = bizType;
    }

    @Override // om3.e
    public boolean i() {
        if (this.pkEventInfo != null) {
            return true;
        }
        return false;
    }

    @Nullable
    /* renamed from: r, reason: from getter */
    public PKEvent getPkEventInfo() {
        return this.pkEventInfo;
    }
}

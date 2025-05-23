package com.tencent.now.pkgame.linkscreen.mutebutton;

import com.tencent.component.core.event.EventCenter;
import com.tencent.component.core.event.Eventor;
import com.tencent.component.core.event.impl.OnEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.now.app.misc.ui.UIUtil;
import com.tencent.now.pkgame.linkandpkobserver.audience.b;
import com.tencent.now.pkgame.pklib.utils.MuteAnchorHelperKt;
import com.tencent.qqlive.common.api.AegisLogger;
import hn3.PKEvent;
import io3.LinkMuteEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qo3.SeiConfig;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000i\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\b\u0006*\u0001B\u0018\u0000 \n2\u00020\u0001:\u0003\"%)B\u001f\u0012\u0006\u0010$\u001a\u00020\u0006\u0012\u0006\u0010'\u001a\u00020\f\u0012\u0006\u0010+\u001a\u00020(\u00a2\u0006\u0004\bE\u0010FJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0006H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\b\u0010\u0015\u001a\u00020\u0002H\u0002J\u001a\u0010\u001a\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018J\u000e\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bJ\u0006\u0010\u001e\u001a\u00020\u0004J\u000e\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0002J\u0006\u0010!\u001a\u00020\u0004R\u0014\u0010$\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010'\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010#R\u0016\u0010/\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010#R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0014\u00106\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u00105R\u0018\u00109\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u00108R\u0016\u0010;\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010:R\u0018\u0010=\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010<R\u0018\u0010?\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010>R\u0018\u0010A\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010@R\u0014\u0010D\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010C\u00a8\u0006G"}, d2 = {"Lcom/tencent/now/pkgame/linkscreen/mutebutton/f;", "", "", "msgResId", "", "r", "", "isMute", h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, DomainData.DOMAIN_NAME, "optType", "", "otherUid", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lqo3/a;", "seiConfig", "j", "otherAnchorMute", "p", "t", "i", "Lcom/tencent/now/pkgame/linkscreen/mutebutton/f$b;", "isMuteCallback", "Lcom/tencent/now/pkgame/linkscreen/mutebutton/f$c;", "isVisibleCallback", "k", "Lcom/tencent/now/pkgame/linkandpkobserver/audience/b;", "seiInfoSubscriber", "o", "g", "pkType", "l", ReportConstant.COSTREPORT_PREFIX, "a", "Z", "isSelfLive", "b", "J", "otherSideAnchorUin", "Lfo3/b;", "c", "Lfo3/b;", "pageInParams", "d", "mIsMute", "e", "mInPK", "Lhn3/d;", "f", "Lhn3/d;", "mPKEvent", "Lcom/tencent/component/core/event/Eventor;", "Lcom/tencent/component/core/event/Eventor;", "mEventor", "Lcom/tencent/mobileqq/widget/QQToast;", "Lcom/tencent/mobileqq/widget/QQToast;", "mQQToast", "I", "mLastMsgResId", "Lcom/tencent/now/pkgame/linkscreen/mutebutton/f$b;", "mIsMuteCallback", "Lcom/tencent/now/pkgame/linkscreen/mutebutton/f$c;", "mIsVisibleCallback", "Lcom/tencent/now/pkgame/linkandpkobserver/audience/b;", "mSeiInfoSubscriber", "com/tencent/now/pkgame/linkscreen/mutebutton/f$f", "Lcom/tencent/now/pkgame/linkscreen/mutebutton/f$f;", "mSeiCallback", "<init>", "(ZJLfo3/b;)V", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean isSelfLive;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final long otherSideAnchorUin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final fo3.b pageInParams;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean mIsMute;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mInPK;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PKEvent mPKEvent;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Eventor mEventor;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QQToast mQQToast;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mLastMsgResId;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b mIsMuteCallback;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c mIsVisibleCallback;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.now.pkgame.linkandpkobserver.audience.b mSeiInfoSubscriber;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final C9252f mSeiCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/now/pkgame/linkscreen/mutebutton/f$b;", "", "", "isMute", "", "a", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public interface b {
        void a(boolean isMute);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/now/pkgame/linkscreen/mutebutton/f$c;", "", "", NodeProps.VISIBLE, "", "a", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public interface c {
        void a(int visible);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/now/pkgame/linkscreen/mutebutton/f$d", "Lcom/tencent/now/pkgame/pklib/utils/a;", "", "muteType", "errCode", "", "errMsg", "", "a", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class d implements com.tencent.now.pkgame.pklib.utils.a {
        d() {
        }

        @Override // com.tencent.now.pkgame.pklib.utils.a
        public void a(int muteType, int errCode, @Nullable String errMsg) {
            AegisLogger.INSTANCE.i("PK_Biz|MuteButtonModel", "doMuteOtherAnchor", "onResult, type:" + muteType + ", code:" + errCode + ", msg:" + errMsg);
            boolean z16 = false;
            if (errCode == 0) {
                if (muteType == 1) {
                    z16 = true;
                }
                f.this.p(z16);
                f.this.q(z16);
                f.this.n(z16);
                return;
            }
            com.tencent.qui.b.b(ul3.b.d(), ul3.b.d().getString(R.string.f169702j2, Integer.valueOf(errCode)), 0).show();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/now/pkgame/linkscreen/mutebutton/f$e", "Lcom/tencent/component/core/event/impl/OnEvent;", "Lhn3/d;", "event", "", "a", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class e implements OnEvent<PKEvent> {
        e() {
        }

        @Override // com.tencent.component.core.event.impl.OnEvent
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onRecv(@NotNull PKEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (f.this.l(event.getPkType())) {
                if (event.getEventType() == 1) {
                    f.this.mInPK = true;
                } else if (event.getEventType() == 2) {
                    f.this.mInPK = false;
                }
                f.this.mPKEvent = event;
            }
        }
    }

    public f(boolean z16, long j3, @NotNull fo3.b pageInParams) {
        Intrinsics.checkNotNullParameter(pageInParams, "pageInParams");
        this.isSelfLive = z16;
        this.otherSideAnchorUin = j3;
        this.pageInParams = pageInParams;
        this.mEventor = new Eventor();
        this.mSeiCallback = new C9252f();
    }

    private final void h(boolean isMute) {
        long uid = ul3.b.b().getUid();
        long j3 = this.otherSideAnchorUin;
        AegisLogger.INSTANCE.i("PK_Biz|MuteButtonModel", "doMuteOtherAnchor, selfUid = " + uid + " otherUid = " + j3);
        int i3 = 1;
        if (uid != 0 && j3 != 0) {
            if (isMute) {
                i3 = 2;
            }
            int i16 = i3;
            MuteAnchorHelperKt.a(uid, j3, i16, new d());
            m(i16, j3);
            return;
        }
        com.tencent.qui.b.b(ul3.b.d(), ul3.b.d().getString(R.string.f169702j2, -1001), 0).show();
    }

    private final int i() {
        int i3 = 0;
        if (!this.isSelfLive && !this.mIsMute) {
            i3 = 8;
        }
        AegisLogger.INSTANCE.i("PK_Biz|MuteButtonModel", "getMuteButtonVisible: " + i3);
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x000c, code lost:
    
        if (r6.intValue() == 1) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void j(SeiConfig seiConfig) {
        boolean z16;
        Integer mute = seiConfig.getMute();
        if (mute != null) {
            z16 = true;
        }
        z16 = false;
        boolean z17 = this.mIsMute;
        if (z16 != z17 && this.mIsMuteCallback != null && this.mIsVisibleCallback != null) {
            AegisLogger.INSTANCE.i("PK_Biz|MuteButtonModel", "isMute:" + z16 + ", curMute:" + z17 + ", >>>>>> " + hashCode());
            p(z16);
            t();
        }
    }

    private final void m(int optType, long otherUid) {
        int i3;
        if (optType == 2) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        if (this.mInPK && this.mPKEvent != null) {
            g gVar = g.f338946a;
            long roomId = this.pageInParams.getRoomId();
            long uid = ul3.b.b().getUid();
            PKEvent pKEvent = this.mPKEvent;
            Intrinsics.checkNotNull(pKEvent);
            gVar.b(roomId, uid, pKEvent.getPkType(), i3, otherUid);
            return;
        }
        g.f338946a.a(this.pageInParams.getRoomId(), ul3.b.b().getUid(), i3, otherUid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(boolean isMute) {
        EventCenter.post(new LinkMuteEvent(String.valueOf(this.otherSideAnchorUin), isMute));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(boolean otherAnchorMute) {
        this.mIsMute = otherAnchorMute;
        b bVar = this.mIsMuteCallback;
        if (bVar != null) {
            bVar.a(otherAnchorMute);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(boolean isMute) {
        String str;
        if (isMute) {
            str = "\u5bf9\u65b9\u76f4\u64ad\u95f4\u58f0\u97f3\u5df2\u5173\u95ed";
        } else {
            str = "\u5bf9\u65b9\u76f4\u64ad\u95f4\u58f0\u97f3\u5df2\u5f00\u542f";
        }
        UIUtil.g(str, false);
    }

    private final void r(int msgResId) {
        if (this.mQQToast == null) {
            QQToast qQToast = new QQToast(ul3.b.d());
            qQToast.setDuration(0);
            qQToast.setType(0);
            this.mQQToast = qQToast;
        }
        QQToast qQToast2 = this.mQQToast;
        if (qQToast2 != null) {
            if (!qQToast2.isShowing() || msgResId != this.mLastMsgResId) {
                this.mLastMsgResId = msgResId;
                qQToast2.setToastMsg(msgResId);
                qQToast2.show();
            }
        }
    }

    private final void t() {
        int i3 = i();
        c cVar = this.mIsVisibleCallback;
        if (cVar != null) {
            cVar.a(i3);
        }
    }

    public final void g() {
        boolean z16 = this.mIsMute;
        AegisLogger.INSTANCE.i("PK_Biz|MuteButtonModel", "mute button click, isSelfLive = " + this.isSelfLive);
        if (this.isSelfLive) {
            h(z16);
        } else {
            r(R.string.f169712j3);
        }
    }

    public final void k(@Nullable b isMuteCallback, @Nullable c isVisibleCallback) {
        this.mIsMuteCallback = isMuteCallback;
        this.mIsVisibleCallback = isVisibleCallback;
        if (this.isSelfLive) {
            Intrinsics.checkNotNull(isVisibleCallback);
            isVisibleCallback.a(0);
            this.mEventor.addOnEvent(new e());
        } else {
            Intrinsics.checkNotNull(isVisibleCallback);
            isVisibleCallback.a(8);
        }
    }

    public final boolean l(int pkType) {
        if (pkType != 2 && pkType != 3) {
            return false;
        }
        return true;
    }

    public final void o(@NotNull com.tencent.now.pkgame.linkandpkobserver.audience.b seiInfoSubscriber) {
        Intrinsics.checkNotNullParameter(seiInfoSubscriber, "seiInfoSubscriber");
        this.mSeiInfoSubscriber = seiInfoSubscriber;
        if (seiInfoSubscriber != null) {
            seiInfoSubscriber.h(this.mSeiCallback, true);
        }
    }

    public final void s() {
        this.mIsMute = false;
        this.mIsMuteCallback = null;
        this.mIsVisibleCallback = null;
        this.mEventor.removeAll();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/now/pkgame/linkscreen/mutebutton/f$f", "Lcom/tencent/now/pkgame/linkandpkobserver/audience/b$b;", "Lqo3/a;", "seiConfig", "", "b", "a", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.now.pkgame.linkscreen.mutebutton.f$f, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static final class C9252f implements b.InterfaceC9251b {
        C9252f() {
        }

        @Override // com.tencent.now.pkgame.linkandpkobserver.audience.b.InterfaceC9251b
        public void b(@NotNull SeiConfig seiConfig) {
            Intrinsics.checkNotNullParameter(seiConfig, "seiConfig");
            f.this.j(seiConfig);
        }

        @Override // com.tencent.now.pkgame.linkandpkobserver.audience.b.InterfaceC9251b
        public void a() {
        }
    }
}

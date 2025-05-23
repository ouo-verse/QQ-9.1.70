package com.tencent.qqnt.aio.helper;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.api.help.b;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mobileqq.aio.event.TopPopupEvent;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.ListenTogetherSession;
import com.tencent.mobileqq.listentogether.nt.ListenTogetherHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.onlinemember.api.ITroopOnlineMemberService;
import com.tencent.mobileqq.trooponline.TroopOnlineMemberBar;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupAnonymousInfo;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0089\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001;\b\u0007\u0018\u0000 D2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001EB\u0007\u00a2\u0006\u0004\bB\u0010CJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0011H\u0002J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0003J\b\u0010\u001a\u001a\u00020\bH\u0002J\b\u0010\u001b\u001a\u00020\u000eH\u0016J\b\u0010\u001c\u001a\u00020\u0011H\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\u0010\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001fH\u0016J\u0010\u0010\"\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001fH\u0016J\u0010\u0010$\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u000eH\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010%\u001a\u00020\u0006H\u0016R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00103\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u00102R\u0014\u00106\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u00105R\u0014\u0010:\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010>\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010A\u001a\u00020?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010@\u00a8\u0006F"}, d2 = {"Lcom/tencent/qqnt/aio/helper/fi;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/aio/api/help/b;", "Lcom/tencent/mvi/base/route/g;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "u", "", "v", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/aio/event/TopPopupEvent$Show;", "event", "D", "", "type", ReportConstant.COSTREPORT_PREFIX, "", "onlineTip", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "uin", "t", "y", "Lcom/tencent/mobileqq/listentogether/nt/ListenTogetherHelper;", "listenTogetherHelper", "w", "p", "getId", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", tl.h.F, "state", "onMoveToState", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "Lcom/tencent/mobileqq/trooponline/TroopOnlineMemberBar;", "e", "Lcom/tencent/mobileqq/trooponline/TroopOnlineMemberBar;", "mTroopOnlineMemberBar", "Landroid/graphics/drawable/AnimationDrawable;", "f", "Landroid/graphics/drawable/AnimationDrawable;", "mJumpDrawable", "Z", "mIsSelectedMode", "Landroid/os/Handler;", "Landroid/os/Handler;", "mUiHandler", "Lcom/tencent/mvi/base/route/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mvi/base/route/a;", "mAction1", "com/tencent/qqnt/aio/helper/fi$c", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/aio/helper/fi$c;", "mTroopOnlineMemberObserver", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "mGetOnlineMemTipsRunnable", "<init>", "()V", "E", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes34.dex */
public final class fi implements com.tencent.aio.main.businesshelper.h, com.tencent.aio.api.help.b, com.tencent.mvi.base.route.g {

    /* renamed from: E, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TroopOnlineMemberBar mTroopOnlineMemberBar;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private AnimationDrawable mJumpDrawable;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mIsSelectedMode;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.mvi.base.route.a mAction1 = new b();

    /* renamed from: C, reason: from kotlin metadata */
    private final c mTroopOnlineMemberObserver = new c();

    /* renamed from: D, reason: from kotlin metadata */
    private final Runnable mGetOnlineMemTipsRunnable = new Runnable() { // from class: com.tencent.qqnt.aio.helper.fe
        @Override // java.lang.Runnable
        public final void run() {
            fi.A(fi.this);
        }
    };

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/aio/helper/fi$a;", "", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/mobileqq/aio/title/ai;", "a", "", "TAG", "Ljava/lang/String;", "TROOP_HIDE_ONLINE_MEMBER_BAR_CONFIG_ID", "TROOP_HIDE_ONLINE_MEMBER_BAR_JSON_KEY", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.helper.fi$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }

        public final com.tencent.mobileqq.aio.title.ai a(com.tencent.aio.api.runtime.a aioContext) {
            AIOParam g16;
            AIOSession r16;
            AIOContact c16;
            String j3;
            if (aioContext != null && com.tencent.mobileqq.activity.aio.l.K() && (g16 = aioContext.g()) != null && (r16 = g16.r()) != null && (c16 = r16.c()) != null && (j3 = c16.j()) != null) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
                ListenTogetherSession Q = ListenTogetherManager.J((QQAppInterface) peekAppRuntime).Q(1, j3);
                if (Q == null) {
                    return null;
                }
                boolean z16 = Q.M;
                com.tencent.mobileqq.listentogether.nt.c cVar = com.tencent.mobileqq.listentogether.nt.c.f241083a;
                QLog.d("TroopSubTitleHelper", 1, "getTogetherDataFromCache session.fold=" + z16 + ", isPanelShow=" + (!cVar.e(j3)));
                int i3 = Q.f437191i;
                if (i3 == 0 || i3 == 3 || cVar.e(j3)) {
                    return null;
                }
                Drawable B = com.tencent.mobileqq.activity.aio.l.B(false);
                String qqStr = HardCodeUtil.qqStr(R.string.isv);
                Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.listen_together_subtitle_hide)");
                return new com.tencent.mobileqq.aio.title.ai(null, B, null, qqStr, "3");
            }
            return null;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/aio/helper/fi$b", "Lcom/tencent/mvi/base/route/a;", "", "sticky", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            fi.this.u(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0014J$\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0014\u00a8\u0006\n"}, d2 = {"com/tencent/qqnt/aio/helper/fi$c", "Lcom/tencent/mobileqq/troop/onlinemember/api/b;", "", "isSuccess", "", "troopUin", "onlineTip", "", "g", "f", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c extends com.tencent.mobileqq.troop.onlinemember.api.b {
        c() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x0059, code lost:
        
            if (r1.f() == true) goto L33;
         */
        @Override // com.tencent.mobileqq.troop.onlinemember.api.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        protected void f(boolean isSuccess, String troopUin, String onlineTip) {
            com.tencent.aio.api.runtime.a aVar;
            AIOParam g16;
            AIOSession r16;
            AIOContact c16;
            String j3;
            boolean z16;
            if (fi.this.mTroopOnlineMemberBar == null || (aVar = fi.this.mAIOContext) == null || (g16 = aVar.g()) == null || (r16 = g16.r()) == null || (c16 = r16.c()) == null || (j3 = c16.j()) == null || !TextUtils.equals(troopUin, j3)) {
                return;
            }
            if (!isSuccess) {
                TroopOnlineMemberBar troopOnlineMemberBar = fi.this.mTroopOnlineMemberBar;
                if (troopOnlineMemberBar != null) {
                    troopOnlineMemberBar.h(2);
                    return;
                }
                return;
            }
            TroopOnlineMemberBar troopOnlineMemberBar2 = fi.this.mTroopOnlineMemberBar;
            if (troopOnlineMemberBar2 != null) {
                troopOnlineMemberBar2.g(troopUin);
            }
            TroopOnlineMemberBar troopOnlineMemberBar3 = fi.this.mTroopOnlineMemberBar;
            if (troopOnlineMemberBar3 != null) {
                z16 = true;
            }
            z16 = false;
            if (z16) {
                TroopOnlineMemberBar troopOnlineMemberBar4 = fi.this.mTroopOnlineMemberBar;
                if (troopOnlineMemberBar4 != null) {
                    troopOnlineMemberBar4.k();
                    return;
                }
                return;
            }
            TroopOnlineMemberBar troopOnlineMemberBar5 = fi.this.mTroopOnlineMemberBar;
            if (troopOnlineMemberBar5 != null) {
                troopOnlineMemberBar5.h(0);
            }
        }

        @Override // com.tencent.mobileqq.troop.onlinemember.api.b
        protected void g(boolean isSuccess, String troopUin, String onlineTip) {
            AIOParam g16;
            AIOSession r16;
            AIOContact c16;
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            Intrinsics.checkNotNullParameter(onlineTip, "onlineTip");
            com.tencent.aio.api.runtime.a aVar = fi.this.mAIOContext;
            String j3 = (aVar == null || (g16 = aVar.g()) == null || (r16 = g16.r()) == null || (c16 = r16.c()) == null) ? null : c16.j();
            QLog.d("TroopSubTitleHelper", 1, "onUpdateOnlineMemberTips isSuccess=" + isSuccess + ", curUin=" + StringUtil.getSimpleUinForPrint(j3) + ", respUin=" + StringUtil.getSimpleUinForPrint(troopUin));
            if (TextUtils.equals(troopUin, j3)) {
                fi fiVar = fi.this;
                fiVar.q(fiVar.t(troopUin));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(fi this$0) {
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            QLog.d("TroopSubTitleHelper", 1, "mGetOnlineMemTipsRunnable run");
            com.tencent.aio.api.runtime.a aVar = this$0.mAIOContext;
            String j3 = (aVar == null || (g16 = aVar.g()) == null || (r16 = g16.r()) == null || (c16 = r16.c()) == null) ? null : c16.j();
            if (j3 != null) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
                Object businessHandler = ((QQAppInterface) peekAppRuntime).getBusinessHandler(BusinessHandlerFactory.TROOP_ONLINE_MEMBER_HANDLER);
                Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.troop.onlinemember.api.ITroopOnlineMemberHandler");
                ((com.tencent.mobileqq.troop.onlinemember.api.a) businessHandler).M1(j3);
            }
        } catch (Exception e16) {
            QLog.e("TroopSubTitleHelper", 1, "mGetOnlineMemTipsRunnable", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(fi this$0) {
        com.tencent.mvi.base.route.j e16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.aio.api.runtime.a aVar = this$0.mAIOContext;
        if (aVar != null && (e16 = aVar.e()) != null) {
            e16.f(this$0, this$0.mAction1);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        ((QQAppInterface) peekAppRuntime).addObserver(this$0.mTroopOnlineMemberObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(fi this$0) {
        com.tencent.mvi.base.route.j e16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.aio.api.runtime.a aVar = this$0.mAIOContext;
        if (aVar != null && (e16 = aVar.e()) != null) {
            e16.i(this$0, this$0.mAction1);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        ((QQAppInterface) peekAppRuntime).removeObserver(this$0.mTroopOnlineMemberObserver);
    }

    private final void D(TopPopupEvent.Show event) {
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        String j3;
        AIOParam g17;
        Bundle l3;
        Fragment c17;
        FragmentActivity requireActivity;
        com.tencent.mvi.base.route.j e16;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null || (g16 = aVar.g()) == null || (r16 = g16.r()) == null || (c16 = r16.c()) == null || (j3 = c16.j()) == null) {
            return;
        }
        com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
        if (aVar2 != null && (e16 = aVar2.e()) != null) {
            e16.h(new AIOTitleEvent.SubTitleResponseEvent(new com.tencent.mobileqq.aio.title.ai(null, com.tencent.mobileqq.activity.aio.l.B(false), null, t(j3), "2")));
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
        com.tencent.aio.api.runtime.a aVar3 = this.mAIOContext;
        if (aVar3 == null || (g17 = aVar3.g()) == null || (l3 = g17.l()) == null) {
            return;
        }
        TroopOnlineMemberBar troopOnlineMemberBar = new TroopOnlineMemberBar(qQAppInterface, this.mAIOContext, null, null, !l3.getBoolean("key_is_scale_chat"));
        this.mTroopOnlineMemberBar = troopOnlineMemberBar;
        troopOnlineMemberBar.g(j3);
        TroopOnlineMemberBar troopOnlineMemberBar2 = this.mTroopOnlineMemberBar;
        event.b(troopOnlineMemberBar2 != null ? troopOnlineMemberBar2.h(1) : null);
        com.tencent.aio.api.runtime.a aVar4 = this.mAIOContext;
        if (aVar4 == null || (c17 = aVar4.c()) == null || (requireActivity = c17.requireActivity()) == null) {
            return;
        }
        Object businessHandler = qQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_ONLINE_MEMBER_HANDLER);
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.troop.onlinemember.api.ITroopOnlineMemberHandler");
        ((com.tencent.mobileqq.troop.onlinemember.api.a) businessHandler).O(j3, requireActivity);
    }

    private final boolean p() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(final String onlineTip) {
        com.tencent.mvi.base.route.j e16;
        com.tencent.mvi.base.route.j e17;
        QLog.d("TroopSubTitleHelper", 1, "checkRichStatus onlineTip=" + onlineTip);
        if (TextUtils.isEmpty(onlineTip)) {
            com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
            if (aVar == null || (e17 = aVar.e()) == null) {
                return;
            }
            e17.h(new AIOTitleEvent.SubTitleResponseEvent(new com.tencent.mobileqq.aio.title.ai(null, null, null, "", "2")));
            return;
        }
        if (this.mJumpDrawable == null) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.helper.fg
                @Override // java.lang.Runnable
                public final void run() {
                    fi.r(fi.this, onlineTip);
                }
            }, 64, null, true);
            return;
        }
        com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
        if (aVar2 == null || (e16 = aVar2.e()) == null) {
            return;
        }
        e16.h(new AIOTitleEvent.SubTitleResponseEvent(new com.tencent.mobileqq.aio.title.ai(null, com.tencent.mobileqq.activity.aio.l.B(true), null, onlineTip, "2")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(fi this$0, String onlineTip) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(onlineTip, "$onlineTip");
        this$0.y(onlineTip);
    }

    private final void s(int type) {
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        String j3;
        com.tencent.mvi.base.route.j e16;
        com.tencent.mvi.base.route.j e17;
        com.tencent.mvi.base.route.j e18;
        QLog.d("TroopSubTitleHelper", 1, "fetchSubTitle type=" + type);
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null || (g16 = aVar.g()) == null || (r16 = g16.r()) == null || (c16 = r16.c()) == null || (j3 = c16.j()) == null) {
            return;
        }
        com.tencent.qqnt.kernel.api.w e19 = com.tencent.qqnt.msg.f.e();
        GroupAnonymousInfo anonymousInfo = e19 != null ? e19.getAnonymousInfo(j3) : null;
        if (anonymousInfo != null && anonymousInfo.isAnonymousChat) {
            com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
            if (aVar2 == null || (e18 = aVar2.e()) == null) {
                return;
            }
            e18.h(new AIOTitleEvent.TitleResponseEvent(10, anonymousInfo));
            return;
        }
        ListenTogetherHelper d16 = com.tencent.mobileqq.listentogether.nt.c.f241083a.d(j3);
        if (d16 != null && d16.y() && com.tencent.mobileqq.activity.aio.l.K()) {
            w(d16);
            return;
        }
        com.tencent.mobileqq.aio.title.ai a16 = INSTANCE.a(this.mAIOContext);
        if (a16 != null) {
            com.tencent.aio.api.runtime.a aVar3 = this.mAIOContext;
            if (aVar3 == null || (e17 = aVar3.e()) == null) {
                return;
            }
            e17.h(new AIOTitleEvent.SubTitleResponseEvent(a16));
            return;
        }
        if (p()) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopSubTitleHelper", 2, "don't need show online member bar");
            }
            com.tencent.aio.api.runtime.a aVar4 = this.mAIOContext;
            if (aVar4 == null || (e16 = aVar4.e()) == null) {
                return;
            }
            e16.h(new AIOTitleEvent.SubTitleResponseEvent(new com.tencent.mobileqq.aio.title.ai(null, null, null, "", "")));
            return;
        }
        String t16 = t(j3);
        q(t16);
        if (TextUtils.isEmpty(t16)) {
            this.mGetOnlineMemTipsRunnable.run();
        } else {
            ThreadManager.getSubThreadHandler().removeCallbacks(this.mGetOnlineMemTipsRunnable);
            ThreadManager.getSubThreadHandler().postDelayed(this.mGetOnlineMemTipsRunnable, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String t(String uin) {
        if (TextUtils.isEmpty(uin)) {
            return "";
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        IRuntimeService runtimeService = ((QQAppInterface) peekAppRuntime).getRuntimeService(ITroopOnlineMemberService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IT\u2026va, ProcessConstant.MAIN)");
        String onlineTip = ((ITroopOnlineMemberService) runtimeService).getOnlineTip(uin);
        Intrinsics.checkNotNullExpressionValue(onlineTip, "service.getOnlineTip(uin)");
        return onlineTip;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(MsgIntent i3) {
        com.tencent.aio.api.runtime.a aVar;
        com.tencent.mvi.base.route.j e16;
        if (this.mAIOContext == null) {
            return;
        }
        if (i3 instanceof AIOTitleEvent.SubTitleRequestEvent) {
            s(((AIOTitleEvent.SubTitleRequestEvent) i3).a());
            return;
        }
        if (i3 instanceof AIOTitleEvent.SubTitleLeftIconClickEvent ? true : i3 instanceof AIOTitleEvent.SubTitleClickEvent) {
            if (v() || (aVar = this.mAIOContext) == null || (e16 = aVar.e()) == null) {
                return;
            }
            e16.h(new TopPopupEvent.OnClickTitleNick(1, null));
            return;
        }
        if (i3 instanceof AIOMsgListEvent.MultiSelectModeChangeEvent) {
            this.mIsSelectedMode = ((AIOMsgListEvent.MultiSelectModeChangeEvent) i3).b();
        } else if (i3 instanceof TopPopupEvent.Show) {
            D((TopPopupEvent.Show) i3);
        } else if (i3 instanceof TopPopupEvent.Hide) {
            x();
        }
    }

    private final boolean v() {
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        String j3;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null || (g16 = aVar.g()) == null || (r16 = g16.r()) == null || (c16 = r16.c()) == null || (j3 = c16.j()) == null) {
            return false;
        }
        com.tencent.mobileqq.listentogether.nt.c cVar = com.tencent.mobileqq.listentogether.nt.c.f241083a;
        ListenTogetherHelper d16 = cVar.d(j3);
        boolean y16 = d16 != null ? d16.y() : false;
        boolean mIsPanelShow = d16 != null ? d16.getMIsPanelShow() : false;
        if (!y16) {
            return false;
        }
        if (this.mIsSelectedMode) {
            return true;
        }
        if (d16 != null) {
            if (mIsPanelShow) {
                d16.x();
                cVar.f(j3, true);
            } else {
                d16.D();
                cVar.f(j3, false);
            }
        }
        s(0);
        return true;
    }

    private final void w(ListenTogetherHelper listenTogetherHelper) {
        com.tencent.mvi.base.route.j e16;
        QLog.d("TroopSubTitleHelper", 1, "handleListenerTogether");
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null || (e16 = aVar.e()) == null) {
            return;
        }
        e16.h(new AIOTitleEvent.SubTitleResponseEvent(new com.tencent.mobileqq.aio.title.ai(null, com.tencent.mobileqq.activity.aio.l.B(true ^ listenTogetherHelper.getMIsPanelShow()), null, listenTogetherHelper.v(), "3")));
    }

    private final void x() {
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        String j3;
        com.tencent.mvi.base.route.j e16;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null || (g16 = aVar.g()) == null || (r16 = g16.r()) == null || (c16 = r16.c()) == null || (j3 = c16.j()) == null) {
            return;
        }
        com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
        if (aVar2 != null && (e16 = aVar2.e()) != null) {
            e16.h(new AIOTitleEvent.SubTitleResponseEvent(new com.tencent.mobileqq.aio.title.ai(null, com.tencent.mobileqq.activity.aio.l.B(true), null, t(j3), "2")));
        }
        this.mTroopOnlineMemberBar = null;
    }

    private final void y(final String onlineTip) {
        Fragment c16;
        Context context;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        Resources resources = (aVar == null || (c16 = aVar.c()) == null || (context = c16.getContext()) == null) ? null : context.getResources();
        if (resources == null) {
            return;
        }
        Drawable drawable = resources.getDrawable(R.drawable.kdh);
        Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
        this.mJumpDrawable = (AnimationDrawable) drawable;
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.aio.helper.fh
            @Override // java.lang.Runnable
            public final void run() {
                fi.z(fi.this, onlineTip);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(fi this$0, String onlineTip) {
        com.tencent.mvi.base.route.j e16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(onlineTip, "$onlineTip");
        int dip2px = ViewUtils.dip2px(10.0f);
        AnimationDrawable animationDrawable = this$0.mJumpDrawable;
        if (animationDrawable != null) {
            animationDrawable.setOneShot(true);
        }
        AnimationDrawable animationDrawable2 = this$0.mJumpDrawable;
        if (animationDrawable2 != null) {
            animationDrawable2.setBounds(0, 0, dip2px, dip2px);
        }
        AnimationDrawable animationDrawable3 = this$0.mJumpDrawable;
        if (animationDrawable3 != null) {
            animationDrawable3.start();
        }
        com.tencent.aio.api.runtime.a aVar = this$0.mAIOContext;
        if (aVar == null || (e16 = aVar.e()) == null) {
            return;
        }
        e16.h(new AIOTitleEvent.SubTitleResponseEvent(new com.tencent.mobileqq.aio.title.ai(this$0.mJumpDrawable, null, null, onlineTip, "2")));
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.f350643j;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.AIOTitleEvent.SubTitleClickEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOTitleEvent.SubTitleLeftIconClickEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOTitleEvent.SubTitleRequestEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.MultiSelectModeChangeEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.TopPopupEvent.Show");
        hashSet.add("com.tencent.mobileqq.aio.event.TopPopupEvent.Hide");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        return new HashSet();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "TroopSubTitleHelper";
    }

    @Override // com.tencent.aio.api.help.b
    public void h(com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        b.a.a(this, param);
        this.mUiHandler.post(new Runnable() { // from class: com.tencent.qqnt.aio.helper.ff
            @Override // java.lang.Runnable
            public final void run() {
                fi.B(fi.this);
            }
        });
    }

    @Override // com.tencent.aio.api.help.b
    public void i() {
        b.a.b(this);
        this.mUiHandler.post(new Runnable() { // from class: com.tencent.qqnt.aio.helper.fd
            @Override // java.lang.Runnable
            public final void run() {
                fi.C(fi.this);
            }
        });
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.mAIOContext = param.a();
        this.mJumpDrawable = null;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        h.a.b(this);
        TroopOnlineMemberBar troopOnlineMemberBar = this.mTroopOnlineMemberBar;
        if (troopOnlineMemberBar != null) {
            troopOnlineMemberBar.e();
        }
        ThreadManager.getSubThreadHandler().removeCallbacks(this.mGetOnlineMemTipsRunnable);
        QLog.d("TroopSubTitleHelper", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        this.mJumpDrawable = null;
        this.mAIOContext = null;
        this.mTroopOnlineMemberBar = null;
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{12, 0};
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
    }
}

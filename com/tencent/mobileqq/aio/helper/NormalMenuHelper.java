package com.tencent.mobileqq.aio.helper;

import android.graphics.Rect;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.aio.event.GestureEvent;
import com.tencent.mobileqq.aio.event.InputEvent;
import com.tencent.mobileqq.aio.event.LifeCycleEvent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.title.AIOTitleContainerMsgIntent;
import com.tencent.mobileqq.aio.title.m;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqnt.aio.menu.MenuWrapper;
import com.tencent.qqnt.aio.menu.m;
import com.tencent.qqnt.aio.stream.StreamMsgEvent;
import com.tencent.qqnt.aio.stream.a;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000{\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005*\u00010\u0018\u0000 J2\u00020\u00012\u00020\u0002:\u0001&B\u0019\u0012\u0006\u0010G\u001a\u00020F\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\bH\u0010IJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J(\u0010\f\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH\u0002J\u0018\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0016\u0010\u001d\u001a\u00020\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u001bH\u0002J\b\u0010\u001e\u001a\u00020\rH\u0002J\b\u0010\u001f\u001a\u00020\rH\u0002J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020 H\u0002J\u0010\u0010#\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\nH\u0002J\u0012\u0010%\u001a\u00020\u00052\b\b\u0002\u0010$\u001a\u00020\rH\u0002J\b\u0010&\u001a\u00020\u0005H\u0016J\b\u0010'\u001a\u00020\u0005H\u0016J\b\u0010(\u001a\u00020\u0005H\u0016J\b\u0010)\u001a\u00020\u0005H\u0016J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0003H\u0016J\b\u0010,\u001a\u00020\nH\u0016J\b\u0010.\u001a\u00020-H\u0016J\b\u0010/\u001a\u00020\rH\u0016R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R&\u00106\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u000200040\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u00105R\u001b\u0010<\u001a\u0002078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u0018\u0010?\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010B\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010E\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010D\u00a8\u0006K"}, d2 = {"Lcom/tencent/mobileqq/aio/helper/NormalMenuHelper;", "Lcom/tencent/mobileqq/aio/helper/LateInitHelper/b;", "Lcom/tencent/aio/api/runtime/emitter/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", "p", "Landroid/view/MotionEvent;", "event", ReportConstant.COSTREPORT_PREFIX, "", HippyTKDListViewAdapter.X, "y", "", "u", "left", "top", "right", "bottom", "Landroid/view/View;", "archer", "Lcom/tencent/qqnt/aio/menu/ui/c;", "menu", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", TabPreloadItem.TAB_NAME_MESSAGE, "v", DomainData.DOMAIN_NAME, "t", "Lcom/tencent/mobileqq/aio/event/AIOMsgSendEvent$MsgOnRevokeEvent;", "w", "newState", "r", "needAnimation", "k", "a", tl.h.F, "g", "b", "msgIntent", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "getId", "", "getTag", "onBackEvent", "com/tencent/mobileqq/aio/helper/NormalMenuHelper$b", "f", "Lcom/tencent/mobileqq/aio/helper/NormalMenuHelper$b;", "mAction", "Lkotlin/Pair;", "Ljava/util/List;", "mMessagelList", "Lcom/tencent/qqnt/aio/menu/MenuWrapper;", "i", "Lkotlin/Lazy;", "o", "()Lcom/tencent/qqnt/aio/menu/MenuWrapper;", "mMenuWrapper", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/aio/menu/ui/c;", "mMenu", BdhLogUtil.LogTag.Tag_Conn, "Z", "mShowMenuMainThread", "D", "Landroid/view/View;", "mContent", "Lcom/tencent/aio/main/businesshelper/b;", "helperParam", "<init>", "(Lcom/tencent/aio/main/businesshelper/b;Lcom/tencent/mvi/base/route/MsgIntent;)V", "E", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class NormalMenuHelper extends com.tencent.mobileqq.aio.helper.LateInitHelper.b implements com.tencent.aio.api.runtime.emitter.a {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean mShowMenuMainThread;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private View mContent;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Pair<String, b>> mMessagelList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mMenuWrapper;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.aio.menu.ui.c mMenu;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/helper/NormalMenuHelper$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.helper.NormalMenuHelper$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/helper/NormalMenuHelper$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NormalMenuHelper.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                NormalMenuHelper.this.p(i3);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51993);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NormalMenuHelper(@NotNull com.tencent.aio.main.businesshelper.b helperParam, @Nullable MsgIntent msgIntent) {
        super(helperParam, msgIntent);
        List<Pair<String, b>> listOf;
        Lazy lazy;
        Intrinsics.checkNotNullParameter(helperParam, "helperParam");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) helperParam, (Object) msgIntent);
            return;
        }
        b bVar = new b();
        this.mAction = bVar;
        com.tencent.qqnt.aio.utils.j jVar = com.tencent.qqnt.aio.utils.j.f352301a;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.SelectMenuShowEvent.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(GestureEvent.DispatchTouchEvent.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(GestureEvent.LeftSwipeEvent.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.NormalMenuShowEvent.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.MenuDismissEvent.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.InputLayoutChange.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.OnReceiveMsgs.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AIOMsgSendEvent.MsgOnRevokeEvent.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.ListScrollStateChanged.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.OnMsgTailChanged.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(LifeCycleEvent.OnPause.class)), bVar), new Pair(jVar.a(Reflection.getOrCreateKotlinClass(AIOMsgListEvent.CancleSelectEvent.class)), bVar)});
        this.mMessagelList = listOf;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MenuWrapper>() { // from class: com.tencent.mobileqq.aio.helper.NormalMenuHelper$mMenuWrapper$2
            static IPatchRedirector $redirector_;

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/helper/NormalMenuHelper$mMenuWrapper$2$a", "Lcom/tencent/qqnt/aio/menu/w;", "", "needAnimation", "", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes10.dex */
            public static final class a implements com.tencent.qqnt.aio.menu.w {
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ NormalMenuHelper f188921a;

                a(NormalMenuHelper normalMenuHelper) {
                    this.f188921a = normalMenuHelper;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) normalMenuHelper);
                    }
                }

                @Override // com.tencent.qqnt.aio.menu.w
                public void a(boolean needAnimation) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        this.f188921a.k(needAnimation);
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this, needAnimation);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NormalMenuHelper.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MenuWrapper invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new MenuWrapper(1, new a(NormalMenuHelper.this), null) : (MenuWrapper) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.mMenuWrapper = lazy;
        this.mShowMenuMainThread = true;
    }

    private final void A(View archer, com.tencent.qqnt.aio.menu.ui.c menu) {
        a.C9495a c9495a;
        Unit unit = null;
        com.tencent.mvi.base.route.k k3 = c().a().e().k(new StreamMsgEvent.GetAnimStatus(null));
        if (k3 instanceof a.C9495a) {
            c9495a = (a.C9495a) k3;
        } else {
            c9495a = null;
        }
        boolean z16 = false;
        if (c9495a != null && c9495a.a()) {
            z16 = true;
        }
        if (z16) {
            return;
        }
        InputEvent.GetInputLayoutRect getInputLayoutRect = new InputEvent.GetInputLayoutRect(null, 1, null);
        c().a().e().h(getInputLayoutRect);
        Rect a16 = getInputLayoutRect.a();
        if (a16 != null) {
            y(a16.left, a16.top, a16.right, a16.bottom);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            o().q(com.tencent.mobileqq.aio.utils.e.f194142a.b());
        }
        z();
        this.mMenu = menu;
        this.mShowMenuMainThread = Looper.getMainLooper().isCurrentThread();
        this.mContent = archer;
        m.a.a(com.tencent.qqnt.aio.menu.ui.b.b(o(), c().a(), menu, null, 4, null), archer, menu, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(boolean needAnimation) {
        c().a().e().h(new AIOMsgListEvent.SetBottomPaddingIncrement(0));
        o().h(needAnimation);
    }

    static /* synthetic */ void m(NormalMenuHelper normalMenuHelper, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        normalMenuHelper.k(z16);
    }

    private final boolean n() {
        try {
            if (!o().l()) {
                return false;
            }
            c().a().e().h(new AIOMsgListEvent.SetBottomPaddingIncrement(0));
            MenuWrapper.i(o(), false, 1, null);
            this.mMenu = null;
            return true;
        } catch (Exception e16) {
            QLog.i("NormalMenuHelper", 1, "dismiss:" + e16);
            throw new IllegalStateException("NormalMenuHelper call dismiss from illegal thread, isMainThread " + Looper.getMainLooper().isCurrentThread() + ", showMenuMainThread " + this.mShowMenuMainThread);
        }
    }

    private final MenuWrapper o() {
        return (MenuWrapper) this.mMenuWrapper.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(MsgIntent intent) {
        if (intent instanceof GestureEvent.DispatchTouchEvent) {
            s(((GestureEvent.DispatchTouchEvent) intent).a());
            return;
        }
        if (intent instanceof LifeCycleEvent.OnPause) {
            m(this, false, 1, null);
            return;
        }
        if (intent instanceof AIOMsgListEvent.MenuDismissEvent) {
            n();
            return;
        }
        if (intent instanceof GestureEvent.LeftSwipeEvent) {
            n();
            return;
        }
        if (intent instanceof AIOMsgListEvent.NormalMenuShowEvent) {
            AIOMsgListEvent.NormalMenuShowEvent normalMenuShowEvent = (AIOMsgListEvent.NormalMenuShowEvent) intent;
            A(normalMenuShowEvent.a(), normalMenuShowEvent.b());
            return;
        }
        if (intent instanceof AIOMsgListEvent.OnReceiveMsgs) {
            v(((AIOMsgListEvent.OnReceiveMsgs) intent).a());
            return;
        }
        if (intent instanceof AIOMsgSendEvent.MsgOnRevokeEvent) {
            w((AIOMsgSendEvent.MsgOnRevokeEvent) intent);
            return;
        }
        if (intent instanceof AIOMsgListEvent.ListScrollStateChanged) {
            r(((AIOMsgListEvent.ListScrollStateChanged) intent).a());
            return;
        }
        if (intent instanceof AIOMsgListEvent.OnMsgTailChanged) {
            x(((AIOMsgListEvent.OnMsgTailChanged) intent).a());
        } else if (intent instanceof AIOMsgListEvent.SelectMenuShowEvent) {
            n();
        } else if (intent instanceof AIOMsgListEvent.CancleSelectEvent) {
            n();
        }
    }

    private final void r(int newState) {
        if (o().l() && newState == 1) {
            QLog.i("NormalMenuHelper", 1, "[handleScrollStateChanged]: listScroll dismiss menu");
            n();
        }
    }

    private final void s(MotionEvent event) {
        int action = event.getAction();
        int rawX = (int) event.getRawX();
        int rawY = (int) event.getRawY();
        if (action == 0 && !u(rawX, rawY)) {
            n();
        }
    }

    private final boolean t() {
        AIOMsgListEvent.GetCurFocusIndex getCurFocusIndex = new AIOMsgListEvent.GetCurFocusIndex(0L, 1, null);
        c().a().e().h(getCurFocusIndex);
        if (getCurFocusIndex.a() == -1) {
            return true;
        }
        return false;
    }

    private final boolean u(int x16, int y16) {
        View view = this.mContent;
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i3 = iArr[0];
        int i16 = iArr[1];
        int measuredWidth = view.getMeasuredWidth() + i3;
        int measuredHeight = view.getMeasuredHeight() + i16;
        if (x16 < i3 || x16 > measuredWidth || y16 < i16 || y16 > measuredHeight) {
            return false;
        }
        return true;
    }

    private final void v(List<? extends com.tencent.aio.data.msglist.a> msgList) {
        String str;
        AIOMsgItem aIOMsgItem;
        MsgRecord msgRecord;
        AIOSession r16;
        AIOContact c16;
        if (!o().l() || msgList == null || msgList.size() <= 0 || !t()) {
            return;
        }
        for (com.tencent.aio.data.msglist.a aVar : msgList) {
            AIOParam g16 = c().a().g();
            String str2 = null;
            if (g16 != null && (r16 = g16.r()) != null && (c16 = r16.c()) != null) {
                str = c16.j();
            } else {
                str = null;
            }
            if (aVar instanceof AIOMsgItem) {
                aIOMsgItem = (AIOMsgItem) aVar;
            } else {
                aIOMsgItem = null;
            }
            if (aIOMsgItem != null && (msgRecord = aIOMsgItem.getMsgRecord()) != null) {
                str2 = msgRecord.peerUid;
            }
            if (Intrinsics.areEqual(str, str2)) {
                n();
                return;
            }
        }
    }

    private final void w(AIOMsgSendEvent.MsgOnRevokeEvent intent) {
        com.tencent.qqnt.aio.menu.ui.c cVar;
        if (!o().l() || (cVar = this.mMenu) == null || cVar.d() == 0) {
            return;
        }
        long msgId = cVar.b(0).d().getMsgId();
        if (msgId == intent.a()) {
            QLog.i("NormalMenuHelper", 1, "[onMsgRevoke]: dismiss menu, msgId is " + msgId);
            n();
        }
    }

    private final void x(com.tencent.aio.data.msglist.a msgItem) {
        String str;
        AIOMsgItem aIOMsgItem;
        MsgRecord msgRecord;
        AIOSession r16;
        AIOContact c16;
        if (!o().l()) {
            return;
        }
        AIOParam g16 = c().a().g();
        String str2 = null;
        if (g16 != null && (r16 = g16.r()) != null && (c16 = r16.c()) != null) {
            str = c16.j();
        } else {
            str = null;
        }
        if (msgItem instanceof AIOMsgItem) {
            aIOMsgItem = (AIOMsgItem) msgItem;
        } else {
            aIOMsgItem = null;
        }
        if (aIOMsgItem != null && (msgRecord = aIOMsgItem.getMsgRecord()) != null) {
            str2 = msgRecord.peerUid;
        }
        if (Intrinsics.areEqual(str, str2)) {
            n();
        }
    }

    private final void y(int left, int top, int right, int bottom) {
        if (QLog.isColorLevel()) {
            QLog.i("NormalMenuHelper", 1, "[setMenuContainerBottom]: containerBottom top is " + top + ", bottom is " + bottom);
        }
        o().q(bottom);
    }

    private final void z() {
        m.e eVar;
        com.tencent.mvi.base.route.k k3 = c().a().e().k(AIOTitleContainerMsgIntent.GetTitleLocation.f193798d);
        if (k3 instanceof m.e) {
            eVar = (m.e) k3;
        } else {
            eVar = null;
        }
        if (eVar != null) {
            o().r(eVar.a());
        }
    }

    @Override // com.tencent.mobileqq.aio.helper.LateInitHelper.b
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        QLog.i("NormalMenuHelper", 1, OperateCustomButton.OPERATE_CREATE);
        if (e() != null) {
            q(e());
        }
        Iterator<T> it = this.mMessagelList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            c().a().e().d((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
        c().a().b().a(com.tencent.aio.api.runtime.emitter.a.class).a(this);
    }

    @Override // com.tencent.mobileqq.aio.helper.LateInitHelper.b
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        QLog.i("NormalMenuHelper", 1, "destroy");
        Iterator<T> it = this.mMessagelList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            c().a().e().b((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
        c().a().b().a(com.tencent.aio.api.runtime.emitter.a.class).c(this);
        n();
    }

    @Override // com.tencent.mobileqq.aio.helper.LateInitHelper.b
    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return 1;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return "NormalMenuHelper";
    }

    @Override // com.tencent.mobileqq.aio.helper.LateInitHelper.b
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.aio.api.runtime.emitter.a
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return n();
    }

    public void q(@NotNull MsgIntent msgIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) msgIntent);
        } else {
            Intrinsics.checkNotNullParameter(msgIntent, "msgIntent");
            p(msgIntent);
        }
    }
}

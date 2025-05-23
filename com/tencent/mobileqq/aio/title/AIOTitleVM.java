package com.tencent.mobileqq.aio.title;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.runtime.message.ExternalCommIntent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.AIOMsgListExtEvent;
import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mobileqq.aio.event.LongShotMsgIntent;
import com.tencent.mobileqq.aio.event.MultiSelectEvent;
import com.tencent.mobileqq.aio.event.ScaleAIOEvent;
import com.tencent.mobileqq.aio.event.ThemeEvent;
import com.tencent.mobileqq.aio.msglist.holder.external.MsgItemExternalRefreshEvent;
import com.tencent.mobileqq.aio.title.AIOTitleUIState;
import com.tencent.mobileqq.aio.title.m;
import com.tencent.mobileqq.aio.title.n;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.aio.utils.bb;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOTitleApi;
import com.tencent.qqnt.aio.background.AIOBackgroundMsgIntent;
import com.tencent.qqnt.chats.api.IChatsUnreadAPI;
import com.tencent.qqnt.chats.api.IChatsUtil;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.robot.api.IRobotServiceApi;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\b\u0004\n\u0002\b\u0007*\u0002>B\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u0005B\u0007\u00a2\u0006\u0004\bF\u0010GJ\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\bH\u0002J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0013H\u0002J\u0018\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0002J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0015H\u0002J\b\u0010\u001b\u001a\u00020\bH\u0002J\b\u0010\u001c\u001a\u00020\bH\u0002J\u0018\u0010 \u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001dH\u0002J\u0010\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u0015H\u0002J\b\u0010#\u001a\u00020\u0015H\u0002J\b\u0010$\u001a\u00020\u0015H\u0002J\b\u0010%\u001a\u00020\u0015H\u0002J\u0012\u0010(\u001a\u00020\u000b2\b\u0010'\u001a\u0004\u0018\u00010&H\u0002J\u0010\u0010*\u001a\u00020)2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010,\u001a\u00020)2\u0006\u0010\u0011\u001a\u00020+H\u0002J\n\u0010.\u001a\u0004\u0018\u00010-H\u0002J\u0010\u00101\u001a\u00020\b2\u0006\u00100\u001a\u00020/H\u0016J\b\u00102\u001a\u00020\bH\u0016J\u0010\u00103\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J(\u00108\u001a\u00020\b2\u0006\u00104\u001a\u00020\u000b2\u0006\u00105\u001a\u00020\u000b2\u000e\u00107\u001a\n\u0012\u0004\u0012\u00020&\u0018\u000106H\u0016R\u0016\u0010;\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010=\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010*R\u0014\u0010A\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010E\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010D\u00a8\u0006H"}, d2 = {"Lcom/tencent/mobileqq/aio/title/AIOTitleVM;", "Lcom/tencent/qqnt/aio/baseVM/a;", "Lcom/tencent/mobileqq/aio/title/n;", "Lcom/tencent/mobileqq/aio/title/AIOTitleUIState;", "Lcom/tencent/qqnt/kernel/invorker/d;", "Lcom/tencent/mvi/base/route/g;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", "E", HippyTKDListViewAdapter.X, "", "height", "topPadding", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "y", "Lcom/tencent/mobileqq/aio/event/AIOTitleEvent$UpdateZplanEvent;", "event", "G", "Lcom/tencent/mobileqq/aio/event/AIOTitleEvent$UpdateRight3IvEvent;", UserInfo.SEX_FEMALE, "", "isSelectMode", "isScaleChat", BdhLogUtil.LogTag.Tag_Conn, "isShotMode", "B", "M", "P", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "mosaicBitmap", "D", "needTransparentBg", "v", "J", "L", "K", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "info", "w", "Lcom/tencent/mvi/base/route/k;", "I", "Lcom/tencent/mobileqq/aio/event/AIOTitleEvent$ZplanRequestEvent;", "H", "Landroid/view/View$AccessibilityDelegate;", "u", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "listType", "unreadCnt", "", "changedList", "O0", "e", "Z", "mIsSelectedMode", "f", "curListType", "com/tencent/mobileqq/aio/title/AIOTitleVM$a", tl.h.F, "Lcom/tencent/mobileqq/aio/title/AIOTitleVM$a;", "mAction", "com/tencent/mobileqq/aio/title/AIOTitleVM$b", "i", "Lcom/tencent/mobileqq/aio/title/AIOTitleVM$b;", "mActionR", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOTitleVM extends com.tencent.qqnt.aio.baseVM.a<n, AIOTitleUIState> implements com.tencent.qqnt.kernel.invorker.d {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mIsSelectedMode;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int curListType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a mAction;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mActionR;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/title/AIOTitleVM$a", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class a implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOTitleVM.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                AIOTitleVM.this.E(i3);
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/title/AIOTitleVM$b", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements com.tencent.mvi.base.route.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOTitleVM.this);
            }
        }

        @Override // com.tencent.mvi.base.route.b
        @NotNull
        public com.tencent.mvi.base.route.k call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.mvi.base.route.k) iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            }
            Intrinsics.checkNotNullParameter(i3, "i");
            return AIOTitleVM.this.I(i3);
        }
    }

    public AIOTitleVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.curListType = 1;
        this.mAction = new a();
        this.mActionR = new b();
    }

    private final void B(boolean isShotMode) {
        if (isShotMode) {
            updateUI(AIOTitleUIState.PushShotTitleBitmap.f193809d);
        }
    }

    private final void C(boolean isSelectMode, boolean isScaleChat) {
        this.mIsSelectedMode = isSelectMode;
        updateUI(new AIOTitleUIState.MultiSelectModeChangeState(isSelectMode, isScaleChat));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void D(Bitmap bitmap, Bitmap mosaicBitmap) {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new LongShotMsgIntent.GetTitleBitmap(bitmap, mosaicBitmap));
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOTitleEvent.TitleRequestEvent(1, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void E(MsgIntent intent) {
        if (intent instanceof AIOMsgListEvent.MultiSelectModeChangeEvent) {
            C(((AIOMsgListEvent.MultiSelectModeChangeEvent) intent).b(), K());
            return;
        }
        if (intent instanceof AIOMsgListEvent.LongShotModeChangeEvent) {
            B(((AIOMsgListEvent.LongShotModeChangeEvent) intent).b());
            return;
        }
        if (intent instanceof AIOTitleEvent.UpdateRight3IvEvent) {
            F((AIOTitleEvent.UpdateRight3IvEvent) intent);
            return;
        }
        if (intent instanceof AIOTitleEvent.UpdateZplanEvent) {
            G((AIOTitleEvent.UpdateZplanEvent) intent);
            return;
        }
        if (intent instanceof AIOTitleEvent.AddFinishBtnEvent) {
            updateUI(AIOTitleUIState.AddFinishBtn.f193805d);
            return;
        }
        if (intent instanceof ThemeEvent.PostThemeChanged) {
            v(AIOUtil.f194084a.D((com.tencent.aio.api.runtime.a) getMContext()));
            return;
        }
        if (intent instanceof AIOBackgroundMsgIntent.ImmersiveChangeMsg) {
            v(AIOUtil.f194084a.D((com.tencent.aio.api.runtime.a) getMContext()));
            return;
        }
        if (intent instanceof MsgItemExternalRefreshEvent.EnterAIOAnimationEnd) {
            updateUI(AIOTitleUIState.ResetAccessibilityFocus.f193810d);
        } else if (intent instanceof AIOTitleEvent.ExpandFullScreenClickEvent) {
            x();
        } else if (intent instanceof ScaleAIOEvent.SwitchToFullScreen) {
            y();
        }
    }

    private final void F(AIOTitleEvent.UpdateRight3IvEvent intent) {
        updateUI(new AIOTitleUIState.UpdateRight3IvState(new ah(intent.a(), intent.e(), intent.b(), intent.c(), this.mIsSelectedMode, intent.d())));
    }

    private final void G(AIOTitleEvent.UpdateZplanEvent event) {
        int i3;
        Object a16 = event.a();
        if (event.b() == bb.f194129a.g()) {
            boolean isDefaultOrDIYTheme = QQTheme.isDefaultOrDIYTheme();
            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type kotlin.IntArray");
            int[] iArr = (int[]) a16;
            if (isDefaultOrDIYTheme) {
                i3 = iArr[1];
            } else {
                i3 = iArr[0];
            }
            a16 = Integer.valueOf(i3);
        }
        updateUI(new AIOTitleUIState.UpdateZplanState(new ap(event.b(), a16, this.mIsSelectedMode)));
    }

    private final com.tencent.mvi.base.route.k H(AIOTitleEvent.ZplanRequestEvent event) {
        int a16 = event.a();
        bb bbVar = bb.f194129a;
        if (a16 == bbVar.a()) {
            return new m.f(Boolean.TRUE);
        }
        if (a16 == bbVar.b()) {
            return new m.f(Boolean.TRUE);
        }
        return com.tencent.mobileqq.aio.event.b.f188738a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mvi.base.route.k I(MsgIntent intent) {
        if (intent instanceof AIOTitleEvent.ZplanRequestEvent) {
            return H((AIOTitleEvent.ZplanRequestEvent) intent);
        }
        return com.tencent.mobileqq.aio.event.b.f188738a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean J() {
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        return ((IRobotServiceApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRobotServiceApi.class)).isRobotAIO(String.valueOf(su3.c.a(g16)), Integer.valueOf(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().e()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean K() {
        return ((com.tencent.aio.api.runtime.a) getMContext()).g().l().getBoolean("key_is_scale_chat");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean L() {
        return com.tencent.mobileqq.aio.a.e((com.tencent.aio.api.runtime.a) getMContext());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void M() {
        com.tencent.mobileqq.aio.msglist.holder.component.multifoward.b bVar = com.tencent.mobileqq.aio.msglist.holder.component.multifoward.b.f191309a;
        if (bVar.i((com.tencent.aio.api.runtime.a) getMContext())) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new ExternalCommIntent("close_msg_select", new Bundle()));
            return;
        }
        if (bVar.j((com.tencent.aio.api.runtime.a) getMContext())) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new MultiSelectEvent.SetSelectMode(false));
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOMsgListEvent.MultiSelectModeChangeEvent(FrameworkVM.TAG, false));
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOMsgListEvent.SetCommunicationShareButton(false));
        } else {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelContainerMsgIntent.HideAllPanelAndKeyboardMsgIntent(FrameworkVM.TAG, false, 2, null));
            Bundle bundle = new Bundle();
            bundle.putString("aio_disappear_type", "1");
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new ExternalCommIntent("close_aio", bundle));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(AIOTitleVM this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((IChatsUnreadAPI) QRoute.api(IChatsUnreadAPI.class)).addExpandRecentContactListener(this$0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(AIOTitleVM this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((IChatsUnreadAPI) QRoute.api(IChatsUnreadAPI.class)).removeExpandRecentContactListener(this$0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void P() {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(AIOTitleEvent.Right3IvClickEvent.f188501d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final View.AccessibilityDelegate u() {
        AIOMsgListEvent.GetBeforeAccessibilityDelegate getBeforeAccessibilityDelegate = new AIOMsgListEvent.GetBeforeAccessibilityDelegate(null, 1, null);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(getBeforeAccessibilityDelegate);
        return getBeforeAccessibilityDelegate.a();
    }

    private final void v(boolean needTransparentBg) {
        BuildersKt__Builders_commonKt.launch$default(vmScope(), null, null, new AIOTitleVM$getData$1(this, needTransparentBg, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final int w(RecentContactInfo info) {
        Long l3;
        long j3;
        long coerceAtLeast;
        long j16 = ((com.tencent.aio.api.runtime.a) getMContext()).g().l().getLong("key_enter_unread_cnt", 0L);
        if (info != null) {
            l3 = Long.valueOf(com.tencent.qqnt.util.view.a.f362998a.a(info, this.curListType));
            ((com.tencent.aio.api.runtime.a) getMContext()).g().l().putLong("key_enter_unread_cnt", l3.longValue());
        } else {
            l3 = null;
        }
        int unreadCountByListType = ((IChatsUtil) QRoute.api(IChatsUtil.class)).getUnreadCountByListType(this.curListType);
        long j17 = unreadCountByListType;
        if (l3 != null) {
            j3 = l3.longValue();
        } else {
            j3 = j16;
        }
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(j17 - j3, 0L);
        int i3 = (int) coerceAtLeast;
        QLog.d(FrameworkVM.TAG, 1, "[notifyMsgUpdate] listType=" + this.curListType + ", totalCnt=" + unreadCountByListType + ", unreadCnt=" + i3 + ", enterUnreadCnt=" + j16 + ", infoCnt=" + l3);
        return i3;
    }

    private final void x() {
        updateUI(AIOTitleUIState.ExpandFullScreenAnim.f193806d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void y() {
        ((com.tencent.aio.api.runtime.a) getMContext()).g().l().putBoolean("key_is_scale_chat", false);
        ((com.tencent.aio.api.runtime.a) getMContext()).g().l().putBoolean("key_need_show_unread_count", true);
        v(AIOUtil.f194084a.D((com.tencent.aio.api.runtime.a) getMContext()));
        FragmentActivity activity = ((com.tencent.aio.api.runtime.a) getMContext()).c().getActivity();
        if (activity != null) {
            QUIImmersiveHelper.u(activity.getWindow(), true, false);
        }
        QLog.d(FrameworkVM.TAG, 1, "[handleExpandFullScreen]");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void z(int height, int topPadding) {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOMsgListEvent.TopLayoutHeightChange(height));
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOMsgListExtEvent.SetTopPadding(topPadding));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull n intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof n.d) {
            v(AIOUtil.f194084a.D((com.tencent.aio.api.runtime.a) getMContext()));
            return;
        }
        if (intent instanceof n.o) {
            M();
            return;
        }
        if (intent instanceof n.j) {
            M();
            return;
        }
        if (intent instanceof n.m) {
            P();
            return;
        }
        if (intent instanceof n.k) {
            n.k kVar = (n.k) intent;
            D(kVar.a(), kVar.b());
            return;
        }
        if (intent instanceof n.a) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(AIOTitleEvent.ClickFinishBtnEvent.f188484d);
            return;
        }
        if (intent instanceof n.b) {
            ((n.b) intent).b(u());
            return;
        }
        if (intent instanceof n.c) {
            ((n.c) intent).b(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().e());
            return;
        }
        if (intent instanceof n.g) {
            ((n.g) intent).a(com.tencent.mobileqq.aio.a.e((com.tencent.aio.api.runtime.a) getMContext()));
        } else if (intent instanceof n.i) {
            n.i iVar = (n.i) intent;
            z(iVar.a(), iVar.b());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.kernel.invorker.d
    public void O0(int listType, int unreadCnt, @Nullable List<RecentContactInfo> changedList) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(listType), Integer.valueOf(unreadCnt), changedList);
            return;
        }
        if (this.curListType == listType && ((IAIOTitleApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOTitleApi.class)).isSupportUnreadCount((com.tencent.aio.api.runtime.a) getMContext()) && L()) {
            AIOContact c16 = ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c();
            RecentContactInfo recentContactInfo = null;
            if (changedList != null) {
                Iterator<T> it = changedList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    RecentContactInfo recentContactInfo2 = (RecentContactInfo) next;
                    if ((!TextUtils.isEmpty(c16.j()) && Intrinsics.areEqual(recentContactInfo2.peerUid, c16.j())) || (TextUtils.isEmpty(c16.j()) && recentContactInfo2.chatType == c16.e())) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        recentContactInfo = next;
                        break;
                    }
                }
                recentContactInfo = recentContactInfo;
            }
            updateUI(new AIOTitleUIState.UpdateUnread(w(recentContactInfo), this.mIsSelectedMode, !J()));
        }
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Set) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.MultiSelectModeChangeEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.LongShotModeChangeEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOTitleEvent.UpdateRight3IvEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOTitleEvent.UpdateZplanEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOTitleEvent.AddFinishBtnEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.ThemeEvent.PostThemeChanged");
        hashSet.add("com.tencent.qqnt.aio.background.AIOBackgroundMsgIntent.ImmersiveChangeMsg");
        hashSet.add("com.tencent.mobileqq.aio.msglist.holder.external.MsgItemExternalRefreshEvent.EnterAIOAnimationEnd");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOTitleEvent.ExpandFullScreenClickEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.ScaleAIOEvent.SwitchToFullScreen");
        return hashSet;
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Set) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.AIOTitleEvent.ZplanRequestEvent");
        return hashSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.aio.baseVM.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onDestroy();
        ((com.tencent.aio.api.runtime.a) getMContext()).e().i(this, this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().e(this);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.aio.title.x
            @Override // java.lang.Runnable
            public final void run() {
                AIOTitleVM.O(AIOTitleVM.this);
            }
        }, 16, null, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        this.mIsSelectedMode = false;
        ((com.tencent.aio.api.runtime.a) getMContext()).e().f(this, this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().l(this, this.mActionR);
        this.curListType = ((com.tencent.aio.api.runtime.a) getMContext()).g().l().getInt("key_from_chat_listtype", 1);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.aio.title.y
            @Override // java.lang.Runnable
            public final void run() {
                AIOTitleVM.N(AIOTitleVM.this);
            }
        }, 16, null, false);
    }
}

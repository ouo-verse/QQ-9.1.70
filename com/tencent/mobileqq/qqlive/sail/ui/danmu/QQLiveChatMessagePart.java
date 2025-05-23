package com.tencent.mobileqq.qqlive.sail.ui.danmu;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.viewpager2.widget.ViewPager2;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.component.core.event.Eventor;
import com.tencent.component.core.event.impl.OnEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.sail.model.audience.WindowMode;
import com.tencent.mobileqq.qqlive.sail.report.QQLiveDaTongParams;
import com.tencent.mobileqq.qqlive.sail.ui.chat.ChatMessagePageData;
import com.tencent.mobileqq.qqlive.sail.ui.chat.QQLiveChatMessageViewPagerAdapter;
import com.tencent.mobileqq.qqlive.sail.ui.danmu.QQLiveChatMessagePart;
import com.tencent.mobileqq.qqlive.sail.ui.room.RoomViewModel;
import com.tencent.mobileqq.qqlive.widget.chat.ChatMessageLayout;
import com.tencent.mobileqq.qqlive.widget.chat.CustomTabLayout;
import com.tencent.mobileqq.qqlive.widget.chat.giftmsg.GiftMessageLayout;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.timi.game.liveroom.impl.room.message.ChatMessageLayoutManager;
import com.tencent.timi.game.liveroom.impl.room.message.stack.NormalFloatingBannerLogic;
import com.tencent.timi.game.liveroom.impl.room.view.config.BusConfigHelper;
import hn3.LinkScreenEvent;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00b9\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\t*\u0001d\u0018\u0000 j2\u00020\u0001:\u0001kB\u0007\u00a2\u0006\u0004\bh\u0010iJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\bH\u0002J\b\u0010\u0011\u001a\u00020\bH\u0002J\b\u0010\u0012\u001a\u00020\bH\u0002J\u0012\u0010\u0015\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0016\u001a\u00020\rH\u0014J\u0012\u0010\u0019\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u001a\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u001d\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010 \u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010!\u001a\u00020\bH\u0016J\b\u0010\"\u001a\u00020\bH\u0016J\u0012\u0010#\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016R\u0016\u0010&\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010F\u001a\u00020C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010I\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u001b\u0010O\u001a\u00020J8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010NR\u001b\u0010S\u001a\u00020P8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bH\u0010L\u001a\u0004\bQ\u0010RR\u001b\u0010X\u001a\u00020T8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bU\u0010L\u001a\u0004\bV\u0010WR\u001b\u0010]\u001a\u00020Y8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bZ\u0010L\u001a\u0004\b[\u0010\\R\u0018\u0010a\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010c\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010%R\u0014\u0010g\u001a\u00020d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\be\u0010f\u00a8\u0006l"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/danmu/QQLiveChatMessagePart;", "Lcom/tencent/mobileqq/qqlive/sail/base/c;", "Lcom/tencent/mobileqq/qqlive/widget/chat/ChatMessageLayout;", "Ha", "Lcom/tencent/mobileqq/qqlive/widget/chat/giftmsg/GiftMessageLayout;", "Ia", "", "showKeyBoard", "", "Va", "Ea", "Ba", "Ca", "", "tempMaxHeight", "Ua", "Ga", "Na", "Ta", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "getInitRelyViewStubId", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartStop", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "Lcom/tencent/mobileqq/qqlive/sail/ui/busconfig/a;", "updater", "S9", "U9", "V9", "onPartDestroy", "e", "Z", "shouldShowDanmu", "Landroid/widget/FrameLayout;", "f", "Landroid/widget/FrameLayout;", "partRootView", "Landroidx/viewpager2/widget/ViewPager2;", tl.h.F, "Landroidx/viewpager2/widget/ViewPager2;", "viewPager", "Lcom/tencent/mobileqq/qqlive/sail/ui/chat/QQLiveChatMessageViewPagerAdapter;", "i", "Lcom/tencent/mobileqq/qqlive/sail/ui/chat/QQLiveChatMessageViewPagerAdapter;", "pagerAdapter", "Lcom/tencent/mobileqq/qqlive/widget/chat/CustomTabLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qqlive/widget/chat/CustomTabLayout;", "tabLayout", "Lcom/tencent/mobileqq/qqlive/sail/ui/chat/a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/qqlive/sail/ui/chat/a;", "chatMsgViewPagerMgr", "Lcom/tencent/timi/game/liveroom/impl/room/message/ChatMessageLayoutManager;", "D", "Lcom/tencent/timi/game/liveroom/impl/room/message/ChatMessageLayoutManager;", "msgLayoutMgr", "Landroidx/constraintlayout/widget/ConstraintLayout;", "E", "Landroidx/constraintlayout/widget/ConstraintLayout;", "msgLayoutContainer", "Lcom/tencent/component/core/event/Eventor;", UserInfo.SEX_FEMALE, "Lcom/tencent/component/core/event/Eventor;", "eventor", "G", "I", "chatLayoutOriginalMaxHeight", "Lcom/tencent/mobileqq/qqlive/sail/ui/room/RoomViewModel;", "H", "Lkotlin/Lazy;", "Ma", "()Lcom/tencent/mobileqq/qqlive/sail/ui/room/RoomViewModel;", "roomViewModel", "Lcom/tencent/mobileqq/qqlive/sail/ui/linkscreen/e;", "La", "()Lcom/tencent/mobileqq/qqlive/sail/ui/linkscreen/e;", "pkViewModel", "Lcom/tencent/mobileqq/qqlive/sail/ui/normalflatingmsg/a;", "J", "Ka", "()Lcom/tencent/mobileqq/qqlive/sail/ui/normalflatingmsg/a;", "normalFloatingMsgViewModel", "Lcom/tencent/mobileqq/qqlive/sail/ui/input/a;", "K", "Ja", "()Lcom/tencent/mobileqq/qqlive/sail/ui/input/a;", "inputViewModel", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "L", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "viewPagerChangeListener", "M", "configUpdate", "com/tencent/mobileqq/qqlive/sail/ui/danmu/QQLiveChatMessagePart$d", "N", "Lcom/tencent/mobileqq/qqlive/sail/ui/danmu/QQLiveChatMessagePart$d;", "onLayoutChangeListener", "<init>", "()V", "P", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveChatMessagePart extends com.tencent.mobileqq.qqlive.sail.base.c {
    static IPatchRedirector $redirector_;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.qqlive.sail.ui.chat.a chatMsgViewPagerMgr;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private ChatMessageLayoutManager msgLayoutMgr;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private ConstraintLayout msgLayoutContainer;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Eventor eventor;

    /* renamed from: G, reason: from kotlin metadata */
    private int chatLayoutOriginalMaxHeight;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy roomViewModel;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy pkViewModel;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy normalFloatingMsgViewModel;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy inputViewModel;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private ViewPager2.OnPageChangeCallback viewPagerChangeListener;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean configUpdate;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final d onLayoutChangeListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean shouldShowDanmu;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout partRootView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewPager2 viewPager;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QQLiveChatMessageViewPagerAdapter pagerAdapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CustomTabLayout tabLayout;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/danmu/QQLiveChatMessagePart$a;", "", "", "TAG", "Ljava/lang/String;", "", "UPDATE_MESSAGE_DELAY", "J", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.danmu.QQLiveChatMessagePart$a, reason: from kotlin metadata */
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

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/danmu/QQLiveChatMessagePart$b", "Lcom/tencent/component/core/event/impl/OnEvent;", "Lhn3/b;", "event", "", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements OnEvent<LinkScreenEvent> {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveChatMessagePart.this);
            }
        }

        @Override // com.tencent.component.core.event.impl.OnEvent
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onRecv(@Nullable LinkScreenEvent event) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) event);
                return;
            }
            Intrinsics.checkNotNull(event);
            int type = event.getType();
            if (type != 1) {
                if (type == 2) {
                    QQLiveChatMessagePart.this.Ga();
                }
            } else {
                QQLiveChatMessagePart.this.Ua((((ViewUtils.getScreenHeight() - com.tencent.now.linkscreengame.model.d.f338503a.b().bottom) - wi2.c.b(64)) - wi2.c.b(4)) - wi2.c.a(32.0f));
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/danmu/QQLiveChatMessagePart$c", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "position", "", "onPageSelected", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c extends ViewPager2.OnPageChangeCallback {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveChatMessagePart.this);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            ChatMessagePageData.Page page;
            List<ChatMessagePageData> m06;
            ChatMessagePageData chatMessagePageData;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, position);
                return;
            }
            super.onPageSelected(position);
            CustomTabLayout customTabLayout = QQLiveChatMessagePart.this.tabLayout;
            if (customTabLayout != null) {
                customTabLayout.setSelectedPosition(position);
            }
            QQLiveChatMessageViewPagerAdapter qQLiveChatMessageViewPagerAdapter = QQLiveChatMessagePart.this.pagerAdapter;
            if (qQLiveChatMessageViewPagerAdapter != null) {
                qQLiveChatMessageViewPagerAdapter.q0(position);
            }
            QQLiveChatMessageViewPagerAdapter qQLiveChatMessageViewPagerAdapter2 = QQLiveChatMessagePart.this.pagerAdapter;
            if (qQLiveChatMessageViewPagerAdapter2 != null && (m06 = qQLiveChatMessageViewPagerAdapter2.m0()) != null && (chatMessagePageData = m06.get(position)) != null) {
                page = chatMessagePageData.a();
            } else {
                page = null;
            }
            if (page == ChatMessagePageData.Page.GIFT_MSG) {
                QQLiveChatMessagePart.this.Ta();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JP\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/danmu/QQLiveChatMessagePart$d", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View;", "view", "", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "", "onLayoutChange", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class d implements View.OnLayoutChangeListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveChatMessagePart.this);
            }
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(@NotNull View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, view, Integer.valueOf(left), Integer.valueOf(top), Integer.valueOf(right), Integer.valueOf(bottom), Integer.valueOf(oldLeft), Integer.valueOf(oldTop), Integer.valueOf(oldRight), Integer.valueOf(oldBottom));
                return;
            }
            Intrinsics.checkNotNullParameter(view, "view");
            view.removeOnLayoutChangeListener(this);
            int measuredHeight = view.getMeasuredHeight();
            com.tencent.timi.game.liveroom.impl.room.message.stack.b bVar = com.tencent.timi.game.liveroom.impl.room.message.stack.b.f378084a;
            int a16 = (measuredHeight - bVar.a()) - bVar.d();
            AegisLogger.INSTANCE.i("Chat_Message|QQLiveDanmuPart", "exact chatMsgLayoutMaxHeight:" + a16);
            QQLiveChatMessagePart.this.chatMsgViewPagerMgr.j(a16);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51709);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLiveChatMessagePart() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.shouldShowDanmu = true;
        this.chatMsgViewPagerMgr = new com.tencent.mobileqq.qqlive.sail.ui.chat.a();
        this.eventor = new Eventor();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RoomViewModel>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.danmu.QQLiveChatMessagePart$roomViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveChatMessagePart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final RoomViewModel invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (RoomViewModel) QQLiveChatMessagePart.this.getViewModel(RoomViewModel.class) : (RoomViewModel) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.roomViewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.qqlive.sail.ui.linkscreen.e>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.danmu.QQLiveChatMessagePart$pkViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveChatMessagePart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.qqlive.sail.ui.linkscreen.e invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (com.tencent.mobileqq.qqlive.sail.ui.linkscreen.e) QQLiveChatMessagePart.this.getViewModel(com.tencent.mobileqq.qqlive.sail.ui.linkscreen.e.class) : (com.tencent.mobileqq.qqlive.sail.ui.linkscreen.e) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.pkViewModel = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.qqlive.sail.ui.normalflatingmsg.a>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.danmu.QQLiveChatMessagePart$normalFloatingMsgViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveChatMessagePart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.qqlive.sail.ui.normalflatingmsg.a invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (com.tencent.mobileqq.qqlive.sail.ui.normalflatingmsg.a) QQLiveChatMessagePart.this.getViewModel(com.tencent.mobileqq.qqlive.sail.ui.normalflatingmsg.a.class) : (com.tencent.mobileqq.qqlive.sail.ui.normalflatingmsg.a) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.normalFloatingMsgViewModel = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.qqlive.sail.ui.input.a>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.danmu.QQLiveChatMessagePart$inputViewModel$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveChatMessagePart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.qqlive.sail.ui.input.a invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (com.tencent.mobileqq.qqlive.sail.ui.input.a) QQLiveChatMessagePart.this.getViewModel(com.tencent.mobileqq.qqlive.sail.ui.input.a.class) : (com.tencent.mobileqq.qqlive.sail.ui.input.a) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.inputViewModel = lazy4;
        this.onLayoutChangeListener = new d();
    }

    private final void Ba() {
        this.eventor.addOnEvent(new b());
    }

    private final void Ca() {
        LiveData<com.tencent.mobileqq.qqlive.sail.ui.linkscreen.a> M1 = La().M1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<com.tencent.mobileqq.qqlive.sail.ui.linkscreen.a, Unit> function1 = new Function1<com.tencent.mobileqq.qqlive.sail.ui.linkscreen.a, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.danmu.QQLiveChatMessagePart$audienceObserverLinkScreen$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveChatMessagePart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.qqlive.sail.ui.linkscreen.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.qqlive.sail.ui.linkscreen.a aVar) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
                } else if (!aVar.b()) {
                    QQLiveChatMessagePart.this.Ga();
                } else {
                    QQLiveChatMessagePart.this.Ua((((ViewUtils.getScreenHeight() - aVar.a()) - wi2.c.b(64)) - wi2.c.b(8)) - wi2.c.a(32.0f));
                }
            }
        };
        M1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.danmu.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveChatMessagePart.Da(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Da(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Ea() {
        if (this.configUpdate && R9()) {
            if (BusConfigHelper.f378723a.f(15, H9())) {
                QLog.i("Chat_Message|QQLiveDanmuPart", 2, "checkAndDelayMessageEnterRoom config block");
                return;
            } else {
                runOnActivityUiThread(new Runnable() { // from class: com.tencent.mobileqq.qqlive.sail.ui.danmu.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        QQLiveChatMessagePart.Fa(QQLiveChatMessagePart.this);
                    }
                });
                return;
            }
        }
        QLog.i("Chat_Message|QQLiveDanmuPart", 2, "checkAndDelayMessageEnterRoom configUpdate:" + this.configUpdate + " enterRoom:" + R9());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fa(QQLiveChatMessagePart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.F9() != null) {
            this$0.chatMsgViewPagerMgr.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ga() {
        vi2.b bVar;
        AegisLogger.INSTANCE.i("Chat_Message|QQLiveDanmuPart", "observeLinkScreen", "end, resetMaxHeight=" + this.chatLayoutOriginalMaxHeight);
        if (this.chatLayoutOriginalMaxHeight > 0) {
            ChatMessageLayoutManager chatMessageLayoutManager = this.msgLayoutMgr;
            ChatMessageLayout chatMessageLayout = null;
            if (chatMessageLayoutManager != null) {
                bVar = chatMessageLayoutManager.getMainLayout();
            } else {
                bVar = null;
            }
            if (bVar instanceof ChatMessageLayout) {
                chatMessageLayout = (ChatMessageLayout) bVar;
            }
            if (chatMessageLayout != null) {
                chatMessageLayout.setMaxHeight(this.chatLayoutOriginalMaxHeight);
            }
            this.chatLayoutOriginalMaxHeight = 0;
        }
    }

    private final ChatMessageLayout Ha() {
        FrameLayout frameLayout;
        QQLiveChatMessageViewPagerAdapter qQLiveChatMessageViewPagerAdapter = this.pagerAdapter;
        if (qQLiveChatMessageViewPagerAdapter != null) {
            frameLayout = qQLiveChatMessageViewPagerAdapter.l0(ChatMessagePageData.Page.ALL_MSG);
        } else {
            frameLayout = null;
        }
        if (!(frameLayout instanceof ChatMessageLayout)) {
            return null;
        }
        return (ChatMessageLayout) frameLayout;
    }

    private final GiftMessageLayout Ia() {
        FrameLayout frameLayout;
        QQLiveChatMessageViewPagerAdapter qQLiveChatMessageViewPagerAdapter = this.pagerAdapter;
        if (qQLiveChatMessageViewPagerAdapter != null) {
            frameLayout = qQLiveChatMessageViewPagerAdapter.l0(ChatMessagePageData.Page.GIFT_MSG);
        } else {
            frameLayout = null;
        }
        if (!(frameLayout instanceof GiftMessageLayout)) {
            return null;
        }
        return (GiftMessageLayout) frameLayout;
    }

    private final com.tencent.mobileqq.qqlive.sail.ui.input.a Ja() {
        Object value = this.inputViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-inputViewModel>(...)");
        return (com.tencent.mobileqq.qqlive.sail.ui.input.a) value;
    }

    private final com.tencent.mobileqq.qqlive.sail.ui.normalflatingmsg.a Ka() {
        Object value = this.normalFloatingMsgViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-normalFloatingMsgViewModel>(...)");
        return (com.tencent.mobileqq.qqlive.sail.ui.normalflatingmsg.a) value;
    }

    private final com.tencent.mobileqq.qqlive.sail.ui.linkscreen.e La() {
        Object value = this.pkViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-pkViewModel>(...)");
        return (com.tencent.mobileqq.qqlive.sail.ui.linkscreen.e) value;
    }

    private final RoomViewModel Ma() {
        Object value = this.roomViewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-roomViewModel>(...)");
        return (RoomViewModel) value;
    }

    private final void Na() {
        LiveData<NormalFloatingBannerLogic> L1 = Ka().L1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<NormalFloatingBannerLogic, Unit> function1 = new Function1<NormalFloatingBannerLogic, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.danmu.QQLiveChatMessagePart$observerNormalFloatingMsg$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLiveChatMessagePart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(NormalFloatingBannerLogic normalFloatingBannerLogic) {
                invoke2(normalFloatingBannerLogic);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(NormalFloatingBannerLogic t16) {
                ChatMessageLayoutManager chatMessageLayoutManager;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16);
                    return;
                }
                chatMessageLayoutManager = QQLiveChatMessagePart.this.msgLayoutMgr;
                if (chatMessageLayoutManager != null) {
                    Intrinsics.checkNotNullExpressionValue(t16, "t");
                    chatMessageLayoutManager.J0(t16);
                }
            }
        };
        L1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.danmu.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveChatMessagePart.Oa(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Pa(QQLiveChatMessagePart this$0) {
        String str;
        com.tencent.mobileqq.qqlive.sail.room.e eVar;
        boolean z16;
        com.tencent.mobileqq.qqlive.sail.model.d b16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.qqlive.sail.room.f F9 = this$0.F9();
        if (F9 != null) {
            com.tencent.mobileqq.qqlive.sail.ui.chat.a aVar = this$0.chatMsgViewPagerMgr;
            long H9 = this$0.H9();
            com.tencent.mobileqq.qqlive.sail.room.f F92 = this$0.F9();
            WindowMode windowMode = null;
            if (F92 != null && (b16 = F92.b()) != null) {
                str = b16.f();
            } else {
                str = null;
            }
            long C9 = this$0.C9();
            int roomType = F9.b().getRoomType();
            if (F9 instanceof com.tencent.mobileqq.qqlive.sail.room.e) {
                eVar = (com.tencent.mobileqq.qqlive.sail.room.e) F9;
            } else {
                eVar = null;
            }
            if (eVar != null) {
                windowMode = eVar.q();
            }
            if (windowMode == WindowMode.FLOAT) {
                z16 = true;
            } else {
                z16 = false;
            }
            aVar.b(H9, str, C9, roomType, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ra(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sa(Activity activity, QQLiveChatMessagePart this$0) {
        ChatMessageLayoutManager chatMessageLayoutManager;
        vi2.b mainLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z16 = false;
        if (activity != null && !activity.isFinishing()) {
            z16 = true;
        }
        if (z16 && (chatMessageLayoutManager = this$0.msgLayoutMgr) != null && (mainLayout = chatMessageLayoutManager.getMainLayout()) != null) {
            mainLayout.c(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ta() {
        com.tencent.mobileqq.qqlive.sail.report.a aVar = com.tencent.mobileqq.qqlive.sail.report.a.f272382a;
        QQLiveDaTongParams f16 = aVar.f(H9());
        f16.d("em_qqlive_gift_barrage_module");
        aVar.i("dt_imp", f16.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ua(int tempMaxHeight) {
        vi2.b bVar;
        ChatMessageLayoutManager chatMessageLayoutManager = this.msgLayoutMgr;
        ChatMessageLayout chatMessageLayout = null;
        if (chatMessageLayoutManager != null) {
            bVar = chatMessageLayoutManager.getMainLayout();
        } else {
            bVar = null;
        }
        if (bVar instanceof ChatMessageLayout) {
            chatMessageLayout = (ChatMessageLayout) bVar;
        }
        if (chatMessageLayout != null && this.chatLayoutOriginalMaxHeight != tempMaxHeight) {
            if (chatMessageLayout.F() <= tempMaxHeight) {
                AegisLogger.INSTANCE.i("Chat_Message|QQLiveDanmuPart", "observeLinkScreen", "start, ignore h1=" + chatMessageLayout.F() + " h2=" + tempMaxHeight);
                return;
            }
            AegisLogger.INSTANCE.i("Chat_Message|QQLiveDanmuPart", "observeLinkScreen", "start, tempMaxHeight=" + chatMessageLayout.F());
            this.chatLayoutOriginalMaxHeight = chatMessageLayout.F();
            chatMessageLayout.setMaxHeight(tempMaxHeight);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Va(boolean showKeyBoard) {
        ConstraintLayout constraintLayout = this.msgLayoutContainer;
        if (constraintLayout != null) {
            ViewGroup.LayoutParams layoutParams = constraintLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            if (showKeyBoard) {
                layoutParams2.topToBottom = -1;
                layoutParams2.bottomToTop = R.id.f59752tk;
                ((ViewGroup.MarginLayoutParams) layoutParams2).height = -2;
            } else {
                layoutParams2.topToBottom = R.id.f61672yr;
                layoutParams2.bottomToTop = R.id.f59762tl;
                ((ViewGroup.MarginLayoutParams) layoutParams2).height = wi2.c.b(0);
                ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = wi2.c.b(4);
            }
            constraintLayout.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void S9(@NotNull com.tencent.mobileqq.qqlive.sail.ui.busconfig.a updater) {
        Resources resources;
        Configuration configuration;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) updater);
            return;
        }
        Intrinsics.checkNotNullParameter(updater, "updater");
        super.S9(updater);
        boolean z16 = true;
        this.configUpdate = true;
        this.shouldShowDanmu = !BusConfigHelper.f378723a.g(12, updater.a());
        Activity activity = getActivity();
        if (activity == null || (resources = activity.getResources()) == null || (configuration = resources.getConfiguration()) == null || configuration.orientation != 2) {
            z16 = false;
        }
        AegisLogger.INSTANCE.i("Chat_Message|QQLiveDanmuPart", "onBusConfigUpdate", "shouldShowDanmu=" + this.shouldShowDanmu + ", isLandscape=" + z16);
        com.tencent.mobileqq.qqlive.sail.ui.chat.a aVar = this.chatMsgViewPagerMgr;
        if (aVar != null) {
            aVar.k(this.shouldShowDanmu, z16);
        }
        Ea();
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void U9() {
        Unit unit;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (F9() != null) {
            startInit();
            com.tencent.mobileqq.qqlive.sail.ui.chat.a aVar = this.chatMsgViewPagerMgr;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            aVar.a(context, J9());
            this.msgLayoutMgr = this.chatMsgViewPagerMgr.d();
            runOnActivityUiThread(new Runnable() { // from class: com.tencent.mobileqq.qqlive.sail.ui.danmu.c
                @Override // java.lang.Runnable
                public final void run() {
                    QQLiveChatMessagePart.Pa(QQLiveChatMessagePart.this);
                }
            });
            Ea();
            if (Q9()) {
                Ba();
            } else {
                Ca();
            }
            Na();
            Ma().R1();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            AegisLogger.INSTANCE.e("Chat_Message|QQLiveDanmuPart", "onEnterRoom", "no room");
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c
    public void V9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.V9();
        this.configUpdate = false;
        this.eventor.removeAll();
        this.chatMsgViewPagerMgr.f(H9());
        ConstraintLayout constraintLayout = this.msgLayoutContainer;
        if (constraintLayout != null) {
            constraintLayout.removeOnLayoutChangeListener(this.onLayoutChangeListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.Part
    public int getInitRelyViewStubId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return R.id.f60432ve;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) configuration);
            return;
        }
        super.onConfigurationChanged(configuration);
        if (configuration != null) {
            if (configuration.orientation == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            boolean b16 = com.tencent.timi.game.liveroom.impl.room.util.a.b(getContext(), ViewUtils.getScreenWidth(), ViewUtils.getScreenHeight());
            if (z16 && !b16) {
                this.chatMsgViewPagerMgr.k(false, true);
            } else {
                this.chatMsgViewPagerMgr.k(this.shouldShowDanmu, false);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable final View rootView) {
        FrameLayout frameLayout;
        ViewPager2 viewPager2;
        int i3;
        List<ChatMessagePageData> m06;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        CustomTabLayout customTabLayout = null;
        if (rootView != null) {
            frameLayout = (FrameLayout) rootView.findViewById(R.id.f60432ve);
        } else {
            frameLayout = null;
        }
        this.partRootView = frameLayout;
        if (frameLayout != null) {
            viewPager2 = (ViewPager2) frameLayout.findViewById(R.id.f60442vf);
        } else {
            viewPager2 = null;
        }
        this.viewPager = viewPager2;
        FrameLayout frameLayout2 = this.partRootView;
        if (frameLayout2 != null) {
            customTabLayout = (CustomTabLayout) frameLayout2.findViewById(R.id.f60452vg);
        }
        this.tabLayout = customTabLayout;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        QQLiveChatMessageViewPagerAdapter qQLiveChatMessageViewPagerAdapter = new QQLiveChatMessageViewPagerAdapter(context, Q9());
        this.pagerAdapter = qQLiveChatMessageViewPagerAdapter;
        ViewPager2 viewPager22 = this.viewPager;
        if (viewPager22 != null) {
            viewPager22.setAdapter(qQLiveChatMessageViewPagerAdapter);
            QQLiveChatMessageViewPagerAdapter qQLiveChatMessageViewPagerAdapter2 = this.pagerAdapter;
            if (qQLiveChatMessageViewPagerAdapter2 != null && (m06 = qQLiveChatMessageViewPagerAdapter2.m0()) != null) {
                i3 = m06.size();
            } else {
                i3 = 1;
            }
            viewPager22.setOffscreenPageLimit(i3);
        }
        QQLiveChatMessageViewPagerAdapter qQLiveChatMessageViewPagerAdapter3 = this.pagerAdapter;
        if (qQLiveChatMessageViewPagerAdapter3 != null) {
            if (qQLiveChatMessageViewPagerAdapter3.n0()) {
                CustomTabLayout customTabLayout2 = this.tabLayout;
                if (customTabLayout2 != null) {
                    customTabLayout2.b(qQLiveChatMessageViewPagerAdapter3.m0().size());
                }
                CustomTabLayout customTabLayout3 = this.tabLayout;
                if (customTabLayout3 != null) {
                    customTabLayout3.setSelectedPosition(0);
                }
            } else {
                CustomTabLayout customTabLayout4 = this.tabLayout;
                if (customTabLayout4 != null) {
                    customTabLayout4.setVisibility(8);
                }
            }
        }
        c cVar = new c();
        this.viewPagerChangeListener = cVar;
        ViewPager2 viewPager23 = this.viewPager;
        if (viewPager23 != null) {
            viewPager23.registerOnPageChangeCallback(cVar);
        }
        this.chatMsgViewPagerMgr.e(Q9(), Ha(), Ia());
        if (Q9()) {
            this.chatMsgViewPagerMgr.j(wi2.c.b(240));
            com.tencent.timi.game.liveroom.impl.util.c.f378976a.i("https://downv6.qq.com/video_story/qcircle/ttf/qvideo-digit-Bold.ttf");
            return;
        }
        LiveData<Boolean> L1 = Ja().L1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.danmu.QQLiveChatMessagePart$onInitView$5
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveChatMessagePart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean show) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) show);
                    return;
                }
                QQLiveChatMessagePart qQLiveChatMessagePart = QQLiveChatMessagePart.this;
                Intrinsics.checkNotNullExpressionValue(show, "show");
                qQLiveChatMessagePart.Va(show.booleanValue());
            }
        };
        L1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.danmu.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveChatMessagePart.Qa(Function1.this, obj);
            }
        });
        this.chatMsgViewPagerMgr.j(com.tencent.timi.game.liveroom.impl.room.message.stack.b.f378084a.e());
        MutableLiveData<Size> d26 = Ma().d2();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<Size, Unit> function12 = new Function1<Size, Unit>(rootView) { // from class: com.tencent.mobileqq.qqlive.sail.ui.danmu.QQLiveChatMessagePart$onInitView$6
            static IPatchRedirector $redirector_;
            final /* synthetic */ View $rootView;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$rootView = rootView;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveChatMessagePart.this, (Object) rootView);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Size size) {
                invoke2(size);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Size size) {
                ConstraintLayout constraintLayout;
                QQLiveChatMessagePart.d dVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) size);
                    return;
                }
                AegisLogger.INSTANCE.i("Chat_Message|QQLiveDanmuPart", "videoSize:" + size);
                QQLiveChatMessagePart qQLiveChatMessagePart = QQLiveChatMessagePart.this;
                View view = this.$rootView;
                qQLiveChatMessagePart.msgLayoutContainer = view != null ? (ConstraintLayout) view.findViewById(R.id.tto) : null;
                constraintLayout = QQLiveChatMessagePart.this.msgLayoutContainer;
                if (constraintLayout != null) {
                    dVar = QQLiveChatMessagePart.this.onLayoutChangeListener;
                    constraintLayout.addOnLayoutChangeListener(dVar);
                }
            }
        };
        d26.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.qqlive.sail.ui.danmu.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQLiveChatMessagePart.Ra(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.qqlive.sail.base.c, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        ViewPager2 viewPager2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.viewPagerChangeListener;
        if (onPageChangeCallback != null && (viewPager2 = this.viewPager) != null) {
            viewPager2.unregisterOnPageChangeCallback(onPageChangeCallback);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable final Activity activity) {
        vi2.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
            return;
        }
        super.onPartResume(activity);
        ChatMessageLayoutManager chatMessageLayoutManager = this.msgLayoutMgr;
        if (chatMessageLayoutManager != null) {
            bVar = chatMessageLayoutManager.getMainLayout();
        } else {
            bVar = null;
        }
        if (bVar != null) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqlive.sail.ui.danmu.d
                @Override // java.lang.Runnable
                public final void run() {
                    QQLiveChatMessagePart.Sa(activity, this);
                }
            }, 1000L);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
            return;
        }
        super.onPartStop(activity);
        ChatMessageLayoutManager chatMessageLayoutManager = this.msgLayoutMgr;
        if (chatMessageLayoutManager != null) {
            chatMessageLayoutManager.I0(true);
        }
    }
}

package com.tencent.mobileqq.qqlive.base.room;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.base.room.service.event.g;
import com.tencent.mobileqq.qqlive.base.room.service.event.i;
import com.tencent.mobileqq.qqlive.base.room.service.event.j;
import com.tencent.mobileqq.qqlive.base.room.service.event.k;
import com.tencent.mobileqq.qqlive.base.room.service.lifecycle.f;
import com.tencent.mobileqq.qqlive.base.room.service.liveview.e;
import com.tencent.mobileqq.qqlive.framework.page.Page;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\u00d4\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001b2\u00020\u0001:\u0002!%B\u0017\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010b\u001a\u00020a\u00a2\u0006\u0004\bc\u0010dJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\u0006J\u0010\u0010\u0012\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\u0013\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0006\u0010\u0014\u001a\u00020\u0006J\u0006\u0010\u0015\u001a\u00020\u0006J\u0006\u0010\u0016\u001a\u00020\u0006J\u0006\u0010\u0017\u001a\u00020\u0006J\u0006\u0010\u0018\u001a\u00020\u0006J\u000e\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cJ\u0006\u0010\u001f\u001a\u00020\u001cR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00105\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010=\u001a\u00020:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010A\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010E\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010I\u001a\u00020F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010M\u001a\u00020J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010Q\u001a\u00020N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u001b\u0010V\u001a\u00020R8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010S\u001a\u0004\bT\u0010UR\u001a\u0010Z\u001a\b\u0012\u0004\u0012\u00020X0W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bT\u0010YR\"\u0010]\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\\0[0W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010YR\u0014\u0010`\u001a\u00020^8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010_\u00a8\u0006e"}, d2 = {"Lcom/tencent/mobileqq/qqlive/base/room/AnchorLivePageAdapter;", "", "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "", DomainData.DOMAIN_NAME, "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroidx/fragment/app/Fragment;", "fragment", "p", "u", "Landroid/os/Bundle;", "arguments", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, ReportConstant.COSTREPORT_PREFIX, "y", HippyTKDListViewAdapter.X, "w", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "v", "Landroid/content/res/Configuration;", "newConfig", "r", "", MiniChatConstants.MINI_APP_LANDSCAPE, "t", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/qqlive/framework/page/Page;", "a", "Lcom/tencent/mobileqq/qqlive/framework/page/Page;", "page", "", "b", "Ljava/lang/String;", "TAG", "c", "Landroid/content/Context;", "Lcom/tencent/mobileqq/qqlive/base/room/service/liveview/b;", "d", "Lcom/tencent/mobileqq/qqlive/base/room/service/liveview/b;", "backEventAdapter", "Lcom/tencent/mobileqq/qqlive/base/room/service/roominfo/a;", "e", "Lcom/tencent/mobileqq/qqlive/base/room/service/roominfo/a;", "roomServiceAdapter", "Lcom/tencent/mobileqq/qqlive/base/room/service/lifecycle/a;", "f", "Lcom/tencent/mobileqq/qqlive/base/room/service/lifecycle/a;", "activityLifecycleAdapter", "Lcom/tencent/mobileqq/qqlive/base/room/service/lifecycle/f;", "g", "Lcom/tencent/mobileqq/qqlive/base/room/service/lifecycle/f;", "pageLifecycleAdapter", "Lcom/tencent/mobileqq/qqlive/base/room/service/orientation/c;", h.F, "Lcom/tencent/mobileqq/qqlive/base/room/service/orientation/c;", "orientationChangedAdapter", "Lcom/tencent/mobileqq/qqlive/base/room/service/liveview/a;", "i", "Lcom/tencent/mobileqq/qqlive/base/room/service/liveview/a;", "liveViewListenerServiceAdapter", "Lcom/tencent/mobileqq/qqlive/base/room/service/net/b;", "j", "Lcom/tencent/mobileqq/qqlive/base/room/service/net/b;", "ssoProxy", "Lcom/tencent/mobileqq/qqlive/base/room/service/login/b;", "k", "Lcom/tencent/mobileqq/qqlive/base/room/service/login/b;", "loginStateService", "Lcom/tencent/mobileqq/qqlive/base/room/service/fragment/a;", "l", "Lcom/tencent/mobileqq/qqlive/base/room/service/fragment/a;", "fragmentAdapter", "Lcom/tencent/mobileqq/qqlive/base/room/service/orientation/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qqlive/base/room/service/orientation/a;", "configuration", "Lcom/tencent/mobileqq/qqlive/base/room/service/b;", "Lkotlin/Lazy;", "o", "()Lcom/tencent/mobileqq/qqlive/base/room/service/b;", "qqLiveRoomService", "", "Lcom/tencent/mobileqq/qqlive/framework/connector/b;", "Ljava/util/List;", "extConnectorList", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/qqlive/framework/eventbroadcaster/b;", "pageEventList", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroidx/lifecycle/LifecycleEventObserver;", "activityLifeCycleObserver", "Lcom/tencent/mobileqq/qqlive/base/room/service/roominfo/b;", "roomInfoService", "<init>", "(Lcom/tencent/mobileqq/qqlive/framework/page/Page;Lcom/tencent/mobileqq/qqlive/base/room/service/roominfo/b;)V", "qq-live-room-base_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class AnchorLivePageAdapter {
    static IPatchRedirector $redirector_;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Page page;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Context context;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qqlive.base.room.service.liveview.b backEventAdapter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qqlive.base.room.service.roominfo.a roomServiceAdapter;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qqlive.base.room.service.lifecycle.a activityLifecycleAdapter;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private f pageLifecycleAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qqlive.base.room.service.orientation.c orientationChangedAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qqlive.base.room.service.liveview.a liveViewListenerServiceAdapter;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qqlive.base.room.service.net.b ssoProxy;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qqlive.base.room.service.login.b loginStateService;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qqlive.base.room.service.fragment.a fragmentAdapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qqlive.base.room.service.orientation.a configuration;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy qqLiveRoomService;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<com.tencent.mobileqq.qqlive.framework.connector.b> extConnectorList;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Class<? extends com.tencent.mobileqq.qqlive.framework.eventbroadcaster.b>> pageEventList;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleEventObserver activityLifeCycleObserver;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/qqlive/base/room/AnchorLivePageAdapter$a;", "Lcom/tencent/mobileqq/qqlive/framework/connector/a;", "", "Lcom/tencent/mobileqq/qqlive/framework/interfaceService/a;", "c", "Lfi2/b;", "connectorContext", "<init>", "(Lcom/tencent/mobileqq/qqlive/base/room/AnchorLivePageAdapter;Lfi2/b;)V", "qq-live-room-base_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public final class a extends com.tencent.mobileqq.qqlive.framework.connector.a {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AnchorLivePageAdapter f271055b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull AnchorLivePageAdapter anchorLivePageAdapter, fi2.b connectorContext) {
            super(connectorContext);
            Intrinsics.checkNotNullParameter(connectorContext, "connectorContext");
            this.f271055b = anchorLivePageAdapter;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) anchorLivePageAdapter, (Object) connectorContext);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.framework.connector.a, com.tencent.mobileqq.qqlive.framework.connector.b
        @NotNull
        public List<com.tencent.mobileqq.qqlive.framework.interfaceService.a<?>> c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (List) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            ArrayList arrayList = new ArrayList();
            AnchorLivePageAdapter anchorLivePageAdapter = this.f271055b;
            arrayList.add(new com.tencent.mobileqq.qqlive.framework.interfaceService.a(com.tencent.mobileqq.qqlive.base.room.service.lifecycle.c.class, anchorLivePageAdapter.activityLifecycleAdapter));
            f fVar = anchorLivePageAdapter.pageLifecycleAdapter;
            if (fVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageLifecycleAdapter");
                fVar = null;
            }
            arrayList.add(new com.tencent.mobileqq.qqlive.framework.interfaceService.a(com.tencent.mobileqq.qqlive.base.room.service.lifecycle.d.class, fVar));
            arrayList.add(new com.tencent.mobileqq.qqlive.framework.interfaceService.a(com.tencent.mobileqq.qqlive.base.room.service.orientation.b.class, anchorLivePageAdapter.orientationChangedAdapter));
            arrayList.add(new com.tencent.mobileqq.qqlive.framework.interfaceService.a(com.tencent.mobileqq.qqlive.base.room.service.roominfo.b.class, anchorLivePageAdapter.roomServiceAdapter));
            arrayList.add(new com.tencent.mobileqq.qqlive.framework.interfaceService.a(e.class, anchorLivePageAdapter.liveViewListenerServiceAdapter));
            arrayList.add(new com.tencent.mobileqq.qqlive.framework.interfaceService.a(com.tencent.mobileqq.qqlive.base.room.service.liveview.f.class, anchorLivePageAdapter.liveViewListenerServiceAdapter));
            arrayList.add(new com.tencent.mobileqq.qqlive.framework.interfaceService.a(com.tencent.mobileqq.qqlive.base.room.service.liveview.d.class, anchorLivePageAdapter.backEventAdapter));
            arrayList.add(new com.tencent.mobileqq.qqlive.framework.interfaceService.a(com.tencent.mobileqq.qqlive.base.room.service.net.a.class, anchorLivePageAdapter.ssoProxy));
            arrayList.add(new com.tencent.mobileqq.qqlive.framework.interfaceService.a(com.tencent.mobileqq.qqlive.base.room.service.login.a.class, anchorLivePageAdapter.loginStateService));
            arrayList.add(new com.tencent.mobileqq.qqlive.framework.interfaceService.a(com.tencent.mobileqq.qqlive.base.room.service.a.class, anchorLivePageAdapter.o()));
            arrayList.add(new com.tencent.mobileqq.qqlive.framework.interfaceService.a(com.tencent.mobileqq.qqlive.base.room.service.fragment.b.class, anchorLivePageAdapter.fragmentAdapter));
            return arrayList;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/base/room/AnchorLivePageAdapter$b;", "", "", "PAGE_KEY", "Ljava/lang/String;", "<init>", "()V", "qq-live-room-base_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.base.room.AnchorLivePageAdapter$b, reason: from kotlin metadata */
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

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public /* synthetic */ class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f271056a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21013);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Lifecycle.Event.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f271056a = iArr;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21050);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AnchorLivePageAdapter(@NotNull Page page, @NotNull com.tencent.mobileqq.qqlive.base.room.service.roominfo.b roomInfoService) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(roomInfoService, "roomInfoService");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) page, (Object) roomInfoService);
            return;
        }
        this.page = page;
        this.TAG = "AnchorLivePageAdapter" + hashCode();
        this.backEventAdapter = new com.tencent.mobileqq.qqlive.base.room.service.liveview.b();
        this.roomServiceAdapter = new com.tencent.mobileqq.qqlive.base.room.service.roominfo.a(roomInfoService);
        this.activityLifecycleAdapter = new com.tencent.mobileqq.qqlive.base.room.service.lifecycle.a(page);
        this.orientationChangedAdapter = new com.tencent.mobileqq.qqlive.base.room.service.orientation.c(page);
        this.liveViewListenerServiceAdapter = new com.tencent.mobileqq.qqlive.base.room.service.liveview.a();
        this.ssoProxy = new com.tencent.mobileqq.qqlive.base.room.service.net.b();
        this.loginStateService = new com.tencent.mobileqq.qqlive.base.room.service.login.b();
        this.fragmentAdapter = new com.tencent.mobileqq.qqlive.base.room.service.fragment.a(page);
        this.configuration = new com.tencent.mobileqq.qqlive.base.room.service.orientation.a(page);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.qqlive.base.room.service.b>() { // from class: com.tencent.mobileqq.qqlive.base.room.AnchorLivePageAdapter$qqLiveRoomService$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnchorLivePageAdapter.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.qqlive.base.room.service.b invoke() {
                com.tencent.mobileqq.qqlive.base.room.service.orientation.a aVar;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (com.tencent.mobileqq.qqlive.base.room.service.b) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                com.tencent.mobileqq.qqlive.base.room.service.roominfo.a aVar2 = AnchorLivePageAdapter.this.roomServiceAdapter;
                com.tencent.mobileqq.qqlive.base.room.service.lifecycle.a aVar3 = AnchorLivePageAdapter.this.activityLifecycleAdapter;
                f fVar = AnchorLivePageAdapter.this.pageLifecycleAdapter;
                if (fVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pageLifecycleAdapter");
                    fVar = null;
                }
                f fVar2 = fVar;
                com.tencent.mobileqq.qqlive.base.room.service.orientation.c cVar = AnchorLivePageAdapter.this.orientationChangedAdapter;
                com.tencent.mobileqq.qqlive.base.room.service.liveview.a aVar4 = AnchorLivePageAdapter.this.liveViewListenerServiceAdapter;
                com.tencent.mobileqq.qqlive.base.room.service.liveview.b bVar = AnchorLivePageAdapter.this.backEventAdapter;
                com.tencent.mobileqq.qqlive.base.room.service.fragment.a aVar5 = AnchorLivePageAdapter.this.fragmentAdapter;
                aVar = AnchorLivePageAdapter.this.configuration;
                return new com.tencent.mobileqq.qqlive.base.room.service.b(aVar2, aVar3, fVar2, cVar, aVar4, bVar, aVar5, aVar);
            }
        });
        this.qqLiveRoomService = lazy;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new a(this, page.m()));
        this.extConnectorList = arrayList;
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(com.tencent.mobileqq.qqlive.base.room.service.event.a.class);
        arrayList2.add(com.tencent.mobileqq.qqlive.base.room.service.event.b.class);
        arrayList2.add(com.tencent.mobileqq.qqlive.base.room.service.event.d.class);
        arrayList2.add(com.tencent.mobileqq.qqlive.base.room.service.event.e.class);
        arrayList2.add(com.tencent.mobileqq.qqlive.base.room.service.event.f.class);
        arrayList2.add(g.class);
        arrayList2.add(com.tencent.mobileqq.qqlive.base.room.service.event.h.class);
        arrayList2.add(j.class);
        arrayList2.add(k.class);
        arrayList2.add(i.class);
        arrayList2.add(com.tencent.mobileqq.qqlive.base.room.service.event.c.class);
        this.pageEventList = arrayList2;
        this.activityLifeCycleObserver = new LifecycleEventObserver() { // from class: com.tencent.mobileqq.qqlive.base.room.a
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                AnchorLivePageAdapter.m(AnchorLivePageAdapter.this, lifecycleOwner, event);
            }
        };
        com.tencent.mobileqq.qqlive.framework.log.b.f271266a.a(com.tencent.mobileqq.qqlive.base.room.proxy.a.f271116a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(AnchorLivePageAdapter this$0, LifecycleOwner source, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        this$0.n(source, event);
    }

    private final void n(LifecycleOwner source, Lifecycle.Event event) {
        switch (c.f271056a[event.ordinal()]) {
            case 1:
                this.activityLifecycleAdapter.a();
                return;
            case 2:
                this.activityLifecycleAdapter.e();
                return;
            case 3:
                this.activityLifecycleAdapter.d();
                return;
            case 4:
                this.activityLifecycleAdapter.c();
                return;
            case 5:
                this.activityLifecycleAdapter.f();
                return;
            case 6:
                source.getLifecycle().removeObserver(this.activityLifeCycleObserver);
                this.activityLifecycleAdapter.b();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.qqlive.base.room.service.b o() {
        return (com.tencent.mobileqq.qqlive.base.room.service.b) this.qqLiveRoomService.getValue();
    }

    public final void A(@Nullable Bundle arguments) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) arguments);
            return;
        }
        f fVar = this.pageLifecycleAdapter;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageLifecycleAdapter");
            fVar = null;
        }
        fVar.h(arguments);
    }

    public final void p(@NotNull Context context, @NotNull ViewGroup rootView, @NotNull Fragment fragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, rootView, fragment);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.context = context;
        this.pageLifecycleAdapter = new f(this.page, new com.tencent.mobileqq.qqlive.base.room.service.lifecycle.b(fragment));
        if (context instanceof FragmentActivity) {
            ((FragmentActivity) context).getLifecycle().addObserver(this.activityLifeCycleObserver);
        }
        this.activityLifecycleAdapter.g(context);
        this.page.u(fragment, fragment);
        this.page.s(rootView, this.extConnectorList, this.pageEventList);
        this.fragmentAdapter.a(fragment);
        this.page.r();
    }

    public final boolean q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return this.backEventAdapter.a();
    }

    public final void r(@NotNull Configuration newConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) newConfig);
        } else {
            Intrinsics.checkNotNullParameter(newConfig, "newConfig");
            this.configuration.a(newConfig);
        }
    }

    public final void s(@Nullable Bundle arguments) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) arguments);
            return;
        }
        f fVar = this.pageLifecycleAdapter;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageLifecycleAdapter");
            fVar = null;
        }
        fVar.a(arguments);
    }

    public final void t(boolean isLandscape) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, isLandscape);
        } else {
            this.orientationChangedAdapter.a(isLandscape);
        }
    }

    public final void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        f fVar = this.pageLifecycleAdapter;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageLifecycleAdapter");
            fVar = null;
        }
        fVar.b();
    }

    public final void v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        f fVar = this.pageLifecycleAdapter;
        Context context = null;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageLifecycleAdapter");
            fVar = null;
        }
        fVar.c();
        Context context2 = this.context;
        if (context2 != null) {
            if (context2 instanceof FragmentActivity) {
                context = context2;
            }
            if (context != null) {
                ((FragmentActivity) context).getLifecycle().removeObserver(this.activityLifeCycleObserver);
            }
        }
        this.backEventAdapter.b();
        this.page.t();
    }

    public final void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        f fVar = this.pageLifecycleAdapter;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageLifecycleAdapter");
            fVar = null;
        }
        fVar.d();
    }

    public final void x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        f fVar = this.pageLifecycleAdapter;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageLifecycleAdapter");
            fVar = null;
        }
        fVar.e();
    }

    public final void y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        f fVar = this.pageLifecycleAdapter;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageLifecycleAdapter");
            fVar = null;
        }
        fVar.f();
    }

    public final void z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        f fVar = this.pageLifecycleAdapter;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageLifecycleAdapter");
            fVar = null;
        }
        fVar.g();
    }
}

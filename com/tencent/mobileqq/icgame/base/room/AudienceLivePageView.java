package com.tencent.mobileqq.icgame.base.room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.icgame.game.api.live.BaseGameLiveAudienceView;
import com.tencent.icgame.game.api.live.BaseLiveAudienceView;
import com.tencent.icgame.game.api.live.LiveRoomExtraInfo;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.icgame.context.QQLiveContext;
import com.tencent.mobileqq.icgame.framework.page.Page;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.api.exception.QQLiveCalledFromWrongThreadException;
import i22.ActivityLifecycleEvent;
import i22.OrientationChangedEvent;
import i22.PageLifecycleEvent;
import i22.g;
import i22.i;
import i22.j;
import i22.k;
import i22.l;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\u00f0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0087\u0001B\u0019\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010<\u001a\u00020:\u00a2\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0006\u0010\u000f\u001a\u00020\u0004J\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J$\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016J \u0010\u001d\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J \u0010!\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001eH\u0016J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u001eH\u0016J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$H\u0016J\u0010\u0010'\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$H\u0016J\u0010\u0010(\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$H\u0016J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$H\u0016J\u0010\u0010*\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$H\u0016J\u0010\u0010+\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$H\u0016J\b\u0010,\u001a\u00020\u0004H\u0016J\b\u0010-\u001a\u00020\u0004H\u0016J\b\u0010.\u001a\u00020\u0004H\u0016J\b\u0010/\u001a\u00020\u0004H\u0016J\b\u00100\u001a\u00020\u0004H\u0016J\b\u00101\u001a\u00020\u0004H\u0016J\b\u00102\u001a\u00020\u0004H\u0016J\u0012\u00105\u001a\u00020\u00042\b\u00104\u001a\u0004\u0018\u000103H\u0016J\u0012\u00107\u001a\u00020\u00042\b\u0010)\u001a\u0004\u0018\u000106H\u0014J\b\u00108\u001a\u00020\u001eH\u0016J\b\u00109\u001a\u00020\u001eH\u0016R\u0014\u0010<\u001a\u00020:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010;R\u0014\u0010>\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010=R\u0014\u0010A\u001a\u00020?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010@R\u0016\u0010C\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010BR\u0018\u0010F\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u001b\u0010L\u001a\u00020G8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010KR\u001b\u0010Q\u001a\u00020M8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bN\u0010I\u001a\u0004\bO\u0010PR\u001b\u0010V\u001a\u00020R8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bS\u0010I\u001a\u0004\bT\u0010UR\u001b\u0010[\u001a\u00020W8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bX\u0010I\u001a\u0004\bY\u0010ZR\u001b\u0010`\u001a\u00020\\8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b]\u0010I\u001a\u0004\b^\u0010_R\u001b\u0010e\u001a\u00020a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bb\u0010I\u001a\u0004\bc\u0010dR\u001b\u0010i\u001a\u00020f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bT\u0010I\u001a\u0004\bg\u0010hR\u001b\u0010m\u001a\u00020j8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bJ\u0010I\u001a\u0004\bk\u0010lR\u001b\u0010r\u001a\u00020n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bo\u0010I\u001a\u0004\bp\u0010qR\u001b\u0010v\u001a\u00020s8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bt\u0010I\u001a\u0004\bt\u0010uR\u001b\u0010y\u001a\u00020w8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bg\u0010I\u001a\u0004\bo\u0010xR\u001b\u0010}\u001a\u00020z8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b^\u0010I\u001a\u0004\b{\u0010|R\u001c\u0010\u0081\u0001\u001a\b\u0012\u0004\u0012\u00020\u007f0~8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\bY\u0010\u0080\u0001R&\u0010\u0084\u0001\u001a\u0012\u0012\u000e\u0012\f\u0012\u0007\b\u0001\u0012\u00030\u0083\u00010\u0082\u00010~8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b{\u0010\u0080\u0001\u00a8\u0006\u0088\u0001"}, d2 = {"Lcom/tencent/mobileqq/icgame/base/room/AudienceLivePageView;", "Lcom/tencent/icgame/game/api/live/BaseLiveAudienceView;", "Landroidx/fragment/app/Fragment;", "fragment", "", "W", "", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/icgame/game/api/live/BaseGameLiveAudienceView$a;", "listener", "setLiveViewListener", "Landroid/content/Context;", "context", "setActivityContext", "setParentFragment", "Y", "Landroid/content/res/Configuration;", "newConfig", "X", "Landroid/content/Intent;", "intent", "setResumeIntent", "roomId", "", AppConstants.Key.KEY_QZONE_VIDEO_URL, "Lcom/tencent/icgame/game/api/live/LiveRoomExtraInfo;", "extraInfo", DomainData.DOMAIN_NAME, "u", "l", "", "isPageClosed", "shouldExitRoom", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, MiniChatConstants.MINI_APP_LANDSCAPE, "k", "Landroidx/lifecycle/LifecycleOwner;", "owner", "c", "g", "f", "e", h.F, "d", "j", "o", ReportConstant.COSTREPORT_PREFIX, "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "t", "p", "Lau0/c;", "roomSwitcher", "setRoomSwitcher", "Lcom/tencent/timi/game/api/exception/QQLiveCalledFromWrongThreadException;", "b", "v", "i", "Lcom/tencent/mobileqq/icgame/framework/page/Page;", "Lcom/tencent/mobileqq/icgame/framework/page/Page;", "page", "Ljava/lang/String;", "TAG", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "Lcom/tencent/icgame/common/api/IAegisLogApi;", "aegisLog", "Landroidx/fragment/app/Fragment;", "lifecycleFragmentProxy", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/LifecycleOwner;", "parentLifecycleOwner", "Lk22/a;", "D", "Lkotlin/Lazy;", "K", "()Lk22/a;", "backEventAdapter", "Lo22/a;", "E", "T", "()Lo22/a;", "roomServiceAdapter", "Lcom/tencent/mobileqq/icgame/base/room/service/lifecycle/a;", UserInfo.SEX_FEMALE, "J", "()Lcom/tencent/mobileqq/icgame/base/room/service/lifecycle/a;", "activityLifecycleAdapter", "Lcom/tencent/mobileqq/icgame/base/room/service/lifecycle/f;", "G", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "()Lcom/tencent/mobileqq/icgame/base/room/service/lifecycle/f;", "pageLifecycleAdapter", "Ln22/c;", "H", "P", "()Ln22/c;", "orientationChangedAdapter", "Lp22/b;", "I", "V", "()Lp22/b;", "switchRoomAdapter", "Lk22/f;", "N", "()Lk22/f;", "liveViewListenerServiceAdapter", "Lm22/b;", "U", "()Lm22/b;", "ssoProxy", "Ll22/b;", "L", "O", "()Ll22/b;", "loginStateService", "Lj22/a;", "M", "()Lj22/a;", "fragmentAdapter", "Ln22/a;", "()Ln22/a;", "configuration", "Lh22/b;", BdhLogUtil.LogTag.Tag_Req, "()Lh22/b;", "qqLiveRoomService", "", "Lcom/tencent/mobileqq/icgame/framework/connector/b;", "Ljava/util/List;", "extConnectorList", "Ljava/lang/Class;", "Lg32/b;", "pageEventList", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/icgame/framework/page/Page;)V", "a", "ic-game-room-base_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"ViewConstructor"})
/* loaded from: classes15.dex */
public final class AudienceLivePageView extends BaseLiveAudienceView {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private LifecycleOwner parentLifecycleOwner;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy backEventAdapter;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy roomServiceAdapter;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy activityLifecycleAdapter;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy pageLifecycleAdapter;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy orientationChangedAdapter;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy switchRoomAdapter;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy liveViewListenerServiceAdapter;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy ssoProxy;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Lazy loginStateService;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Lazy fragmentAdapter;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final Lazy configuration;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final Lazy qqLiveRoomService;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final List<com.tencent.mobileqq.icgame.framework.connector.b> extConnectorList;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final List<Class<? extends g32.b>> pageEventList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Page page;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IAegisLogApi aegisLog;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Fragment lifecycleFragmentProxy;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/icgame/base/room/AudienceLivePageView$a;", "Lcom/tencent/mobileqq/icgame/framework/connector/a;", "", "Li32/a;", "c", "Lf32/b;", "connectorContext", "<init>", "(Lcom/tencent/mobileqq/icgame/base/room/AudienceLivePageView;Lf32/b;)V", "ic-game-room-base_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public final class a extends com.tencent.mobileqq.icgame.framework.connector.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AudienceLivePageView f237151b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull AudienceLivePageView audienceLivePageView, f32.b connectorContext) {
            super(connectorContext);
            Intrinsics.checkNotNullParameter(connectorContext, "connectorContext");
            this.f237151b = audienceLivePageView;
        }

        @Override // com.tencent.mobileqq.icgame.framework.connector.a, com.tencent.mobileqq.icgame.framework.connector.b
        @NotNull
        public List<i32.a<?>> c() {
            ArrayList arrayList = new ArrayList();
            AudienceLivePageView audienceLivePageView = this.f237151b;
            arrayList.add(new i32.a(com.tencent.mobileqq.icgame.base.room.service.lifecycle.c.class, audienceLivePageView.J()));
            arrayList.add(new i32.a(com.tencent.mobileqq.icgame.base.room.service.lifecycle.d.class, audienceLivePageView.Q()));
            arrayList.add(new i32.a(n22.b.class, audienceLivePageView.P()));
            arrayList.add(new i32.a(p22.a.class, audienceLivePageView.V()));
            arrayList.add(new i32.a(o22.b.class, audienceLivePageView.T()));
            arrayList.add(new i32.a(k22.d.class, audienceLivePageView.N()));
            arrayList.add(new i32.a(k22.e.class, audienceLivePageView.N()));
            arrayList.add(new i32.a(k22.c.class, audienceLivePageView.K()));
            arrayList.add(new i32.a(m22.a.class, audienceLivePageView.U()));
            arrayList.add(new i32.a(l22.a.class, audienceLivePageView.O()));
            arrayList.add(new i32.a(h22.a.class, audienceLivePageView.R()));
            arrayList.add(new i32.a(j22.b.class, audienceLivePageView.M()));
            return arrayList;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudienceLivePageView(@NotNull Context context, @NotNull Page page) {
        super(context);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Lazy lazy7;
        Lazy lazy8;
        Lazy lazy9;
        Lazy lazy10;
        Lazy lazy11;
        Lazy lazy12;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(page, "page");
        this.page = page;
        this.TAG = "ICGameLiveSdkAdapter" + hashCode();
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.aegisLog = (IAegisLogApi) api;
        this.lifecycleFragmentProxy = new Fragment();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<k22.a>() { // from class: com.tencent.mobileqq.icgame.base.room.AudienceLivePageView$backEventAdapter$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final k22.a invoke() {
                return new k22.a();
            }
        });
        this.backEventAdapter = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<o22.a>() { // from class: com.tencent.mobileqq.icgame.base.room.AudienceLivePageView$roomServiceAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final o22.a invoke() {
                Page page2;
                page2 = AudienceLivePageView.this.page;
                return new o22.a(page2);
            }
        });
        this.roomServiceAdapter = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.icgame.base.room.service.lifecycle.a>() { // from class: com.tencent.mobileqq.icgame.base.room.AudienceLivePageView$activityLifecycleAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.icgame.base.room.service.lifecycle.a invoke() {
                Page page2;
                page2 = AudienceLivePageView.this.page;
                return new com.tencent.mobileqq.icgame.base.room.service.lifecycle.a(page2);
            }
        });
        this.activityLifecycleAdapter = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.icgame.base.room.service.lifecycle.f>() { // from class: com.tencent.mobileqq.icgame.base.room.AudienceLivePageView$pageLifecycleAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.mobileqq.icgame.base.room.service.lifecycle.f invoke() {
                Page page2;
                page2 = AudienceLivePageView.this.page;
                return new com.tencent.mobileqq.icgame.base.room.service.lifecycle.f(page2, new com.tencent.mobileqq.icgame.base.room.service.lifecycle.b());
            }
        });
        this.pageLifecycleAdapter = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<n22.c>() { // from class: com.tencent.mobileqq.icgame.base.room.AudienceLivePageView$orientationChangedAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final n22.c invoke() {
                Page page2;
                page2 = AudienceLivePageView.this.page;
                return new n22.c(page2);
            }
        });
        this.orientationChangedAdapter = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<p22.b>() { // from class: com.tencent.mobileqq.icgame.base.room.AudienceLivePageView$switchRoomAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final p22.b invoke() {
                Page page2;
                page2 = AudienceLivePageView.this.page;
                return new p22.b(page2, AudienceLivePageView.this.T());
            }
        });
        this.switchRoomAdapter = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<k22.f>() { // from class: com.tencent.mobileqq.icgame.base.room.AudienceLivePageView$liveViewListenerServiceAdapter$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final k22.f invoke() {
                return new k22.f();
            }
        });
        this.liveViewListenerServiceAdapter = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(new Function0<m22.b>() { // from class: com.tencent.mobileqq.icgame.base.room.AudienceLivePageView$ssoProxy$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final m22.b invoke() {
                return new m22.b();
            }
        });
        this.ssoProxy = lazy8;
        lazy9 = LazyKt__LazyJVMKt.lazy(new Function0<l22.b>() { // from class: com.tencent.mobileqq.icgame.base.room.AudienceLivePageView$loginStateService$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final l22.b invoke() {
                return new l22.b();
            }
        });
        this.loginStateService = lazy9;
        lazy10 = LazyKt__LazyJVMKt.lazy(new Function0<j22.a>() { // from class: com.tencent.mobileqq.icgame.base.room.AudienceLivePageView$fragmentAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final j22.a invoke() {
                Page page2;
                page2 = AudienceLivePageView.this.page;
                return new j22.a(page2);
            }
        });
        this.fragmentAdapter = lazy10;
        lazy11 = LazyKt__LazyJVMKt.lazy(new Function0<n22.a>() { // from class: com.tencent.mobileqq.icgame.base.room.AudienceLivePageView$configuration$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final n22.a invoke() {
                Page page2;
                page2 = AudienceLivePageView.this.page;
                return new n22.a(page2);
            }
        });
        this.configuration = lazy11;
        lazy12 = LazyKt__LazyJVMKt.lazy(new Function0<h22.b>() { // from class: com.tencent.mobileqq.icgame.base.room.AudienceLivePageView$qqLiveRoomService$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final h22.b invoke() {
                n22.a L;
                o22.a T = AudienceLivePageView.this.T();
                com.tencent.mobileqq.icgame.base.room.service.lifecycle.a J = AudienceLivePageView.this.J();
                com.tencent.mobileqq.icgame.base.room.service.lifecycle.f Q = AudienceLivePageView.this.Q();
                n22.c P = AudienceLivePageView.this.P();
                k22.f N = AudienceLivePageView.this.N();
                k22.a K = AudienceLivePageView.this.K();
                j22.a M = AudienceLivePageView.this.M();
                L = AudienceLivePageView.this.L();
                return new h22.b(T, J, Q, P, N, K, M, L);
            }
        });
        this.qqLiveRoomService = lazy12;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new a(this, page.n()));
        this.extConnectorList = arrayList;
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(ActivityLifecycleEvent.class);
        arrayList2.add(i22.b.class);
        arrayList2.add(OrientationChangedEvent.class);
        arrayList2.add(i22.e.class);
        arrayList2.add(PageLifecycleEvent.class);
        arrayList2.add(g.class);
        arrayList2.add(i22.h.class);
        arrayList2.add(j.class);
        arrayList2.add(k.class);
        arrayList2.add(i.class);
        arrayList2.add(l.class);
        arrayList2.add(i22.c.class);
        this.pageEventList = arrayList2;
        j32.b.f409197a.a(g22.a.f401117a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.icgame.base.room.service.lifecycle.a J() {
        return (com.tencent.mobileqq.icgame.base.room.service.lifecycle.a) this.activityLifecycleAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final k22.a K() {
        return (k22.a) this.backEventAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final n22.a L() {
        return (n22.a) this.configuration.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final j22.a M() {
        return (j22.a) this.fragmentAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final k22.f N() {
        return (k22.f) this.liveViewListenerServiceAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final l22.b O() {
        return (l22.b) this.loginStateService.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final n22.c P() {
        return (n22.c) this.orientationChangedAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.icgame.base.room.service.lifecycle.f Q() {
        return (com.tencent.mobileqq.icgame.base.room.service.lifecycle.f) this.pageLifecycleAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final h22.b R() {
        return (h22.b) this.qqLiveRoomService.getValue();
    }

    private final long S() {
        return T().getRoomId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final o22.a T() {
        return (o22.a) this.roomServiceAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final m22.b U() {
        return (m22.b) this.ssoProxy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final p22.b V() {
        return (p22.b) this.switchRoomAdapter.getValue();
    }

    private final void W(Fragment fragment) {
        Fragment fragment2;
        FragmentManager childFragmentManager;
        FragmentTransaction beginTransaction;
        FragmentTransaction remove;
        if (fragment != null) {
            try {
                if (!Intrinsics.areEqual(this.parentLifecycleOwner, fragment)) {
                    if (this.lifecycleFragmentProxy.isAdded()) {
                        LifecycleOwner lifecycleOwner = this.parentLifecycleOwner;
                        if ((lifecycleOwner instanceof Fragment) && (fragment2 = (Fragment) lifecycleOwner) != null && (childFragmentManager = fragment2.getChildFragmentManager()) != null && (beginTransaction = childFragmentManager.beginTransaction()) != null && (remove = beginTransaction.remove(this.lifecycleFragmentProxy)) != null) {
                            remove.commitNowAllowingStateLoss();
                        }
                    }
                    this.parentLifecycleOwner = fragment;
                    M().a(fragment);
                    setParentFragment(fragment);
                    fragment.getChildFragmentManager().executePendingTransactions();
                    fragment.getChildFragmentManager().beginTransaction().add(this.lifecycleFragmentProxy, "tag").commitNowAllowingStateLoss();
                }
            } catch (IllegalStateException e16) {
                QLog.e(this.TAG, 1, "setParentFragment: \u4ee3\u7406Fragment\u5207\u6362ParentFragment\u5931\u8d25\u72b6\u6001\u5931\u8d25", e16);
            } catch (Exception e17) {
                QLog.e(this.TAG, 1, "setParentFragment: \u4f7f\u7528\u4ee3\u7406Fragment\u5931\u8d25", e17);
            }
        }
    }

    public final void X(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        this.aegisLog.i(this.TAG, "onPageConfigurationChanged roomId:" + S());
        L().a(newConfig);
    }

    public final void Y() {
        V().f();
    }

    @Override // com.tencent.icgame.game.api.live.BaseLiveAudienceView
    protected void b(@Nullable QQLiveCalledFromWrongThreadException e16) {
        QLog.e(this.TAG, 1, "handleThreadError:Thread Error!!", e16);
        Intrinsics.checkNotNull(e16);
        p32.a.b(e16);
    }

    @Override // com.tencent.icgame.game.api.live.BaseLiveAudienceView
    public void c(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        if (owner instanceof Fragment) {
            W((Fragment) owner);
        }
        this.aegisLog.i(this.TAG, 1, "onActivityCreate roomId:" + S());
        Q().e();
    }

    @Override // com.tencent.icgame.game.api.live.BaseLiveAudienceView
    public void d(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        if (owner instanceof Fragment) {
            W((Fragment) owner);
        }
        this.aegisLog.i(this.TAG, 1, "onActivityDestroy roomId:" + S());
        Q().f();
    }

    @Override // com.tencent.icgame.game.api.live.BaseLiveAudienceView
    public void e(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        if (owner instanceof Fragment) {
            W((Fragment) owner);
        }
        this.aegisLog.i(this.TAG, 1, "onActivityPause roomId:" + S());
        Q().g();
    }

    @Override // com.tencent.icgame.game.api.live.BaseLiveAudienceView
    public void f(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        if (owner instanceof Fragment) {
            W((Fragment) owner);
        }
        this.aegisLog.i(this.TAG, 1, "onActivityResume roomId:" + S());
        Q().h();
    }

    @Override // com.tencent.icgame.game.api.live.BaseLiveAudienceView
    public void g(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        if (owner instanceof Fragment) {
            W((Fragment) owner);
        }
        this.aegisLog.i(this.TAG, 1, "onActivityStart roomId:" + S());
        Q().i();
    }

    @Override // com.tencent.icgame.game.api.live.BaseLiveAudienceView
    public void h(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        if (owner instanceof Fragment) {
            W((Fragment) owner);
        }
        this.aegisLog.i(this.TAG, 1, "onActivityStop roomId:" + S());
        Q().j();
    }

    @Override // com.tencent.icgame.game.api.live.BaseLiveAudienceView
    public boolean i() {
        return K().a();
    }

    @Override // com.tencent.icgame.game.api.live.BaseLiveAudienceView
    public void j() {
        this.aegisLog.i(this.TAG, 1, "onDestroy roomId:" + S());
        Q().d();
        K().b();
        e.f237158a.b(S());
        this.page.v();
    }

    @Override // com.tencent.icgame.game.api.live.BaseLiveAudienceView
    public void k(boolean isLandscape) {
        this.aegisLog.i(this.TAG, 1, "onOrientationChange roomId:" + S());
        P().a(isLandscape);
    }

    @Override // com.tencent.icgame.game.api.live.BaseLiveAudienceView
    public void l(@NotNull Context context, long roomId, @NotNull LiveRoomExtraInfo extraInfo) {
        String str;
        Map mapOf;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        this.aegisLog.i(this.TAG, 1, "onPageIn roomId:" + S() + ", extraInfo:" + extraInfo);
        Q().a();
        V().b(context, roomId, extraInfo);
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to(AudienceReportConst.ROOM_ID, String.valueOf(roomId));
        pairArr[1] = TuplesKt.to("room_type", String.valueOf(extraInfo.f114882f));
        QQLiveContext b16 = QQLiveContext.INSTANCE.b("1078");
        if (b16 == null || (str = b16.getTraceId()) == null) {
            str = "";
        }
        pairArr[2] = TuplesKt.to("ext1", str);
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        com.tencent.mobileqq.icgame.techreport.d.g("ev_icgame_enter_room_page_in", mapOf);
    }

    @Override // com.tencent.icgame.game.api.live.BaseLiveAudienceView
    public void m(long roomId, boolean isPageClosed, boolean shouldExitRoom) {
        this.aegisLog.i(this.TAG, 1, "onPageOut roomId:" + S());
        V().c(roomId, isPageClosed, shouldExitRoom);
        Q().b();
    }

    @Override // com.tencent.icgame.game.api.live.BaseLiveAudienceView
    public void n(long roomId, @Nullable String videoUrl, @Nullable LiveRoomExtraInfo extraInfo) {
        e.f237158a.a(roomId, this.page);
        V().d(roomId, videoUrl, extraInfo);
        this.aegisLog.i(this.TAG, 1, "onPagePreLoad roomId:" + S());
    }

    @Override // com.tencent.icgame.game.api.live.BaseLiveAudienceView
    public void o() {
        this.aegisLog.i(this.TAG, 1, "onRealActivityCreate roomId:" + S());
        J().a();
    }

    @Override // com.tencent.icgame.game.api.live.BaseLiveAudienceView
    public void p() {
        this.aegisLog.i(this.TAG, 1, "onRealActivityDestroy roomId:" + S());
        J().b();
    }

    @Override // com.tencent.icgame.game.api.live.BaseLiveAudienceView
    public void q() {
        this.aegisLog.i(this.TAG, 1, "onRealActivityPause roomId:" + S());
        J().c();
    }

    @Override // com.tencent.icgame.game.api.live.BaseLiveAudienceView
    public void r() {
        this.aegisLog.i(this.TAG, 1, "onRealActivityResume roomId:" + S());
        J().e();
    }

    @Override // com.tencent.icgame.game.api.live.BaseLiveAudienceView
    public void s() {
        this.aegisLog.i(this.TAG, 1, "onRealActivityStart roomId:" + S());
        J().f();
    }

    @Override // com.tencent.icgame.game.api.live.BaseLiveAudienceView
    public void setActivityContext(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.aegisLog.i(this.TAG, 1, "setActivityContext");
        J().h(context);
        this.page.w(context);
        this.page.x(this.lifecycleFragmentProxy);
        this.page.u(this, this.extConnectorList, this.pageEventList);
        this.page.t();
    }

    @Override // com.tencent.icgame.game.api.live.BaseLiveAudienceView
    public void setLiveViewListener(@Nullable BaseGameLiveAudienceView.a listener) {
        super.setLiveViewListener(listener);
        if (listener != null) {
            N().d(listener);
        }
    }

    @Override // com.tencent.icgame.game.api.live.BaseLiveAudienceView
    public void setParentFragment(@Nullable Fragment fragment) {
        super.setParentFragment(fragment);
        if (fragment != null) {
            M().a(fragment);
        }
    }

    @Override // com.tencent.icgame.game.api.live.BaseLiveAudienceView
    public void setResumeIntent(@Nullable Intent intent) {
        this.aegisLog.i(this.TAG, 1, "setResumeIntent roomId:" + S());
        T().b(intent);
    }

    @Override // com.tencent.icgame.game.api.live.BaseLiveAudienceView
    public void setRoomSwitcher(@Nullable au0.c roomSwitcher) {
        if (roomSwitcher != null) {
            V().g(roomSwitcher);
        }
    }

    @Override // com.tencent.icgame.game.api.live.BaseLiveAudienceView
    public void t() {
        this.aegisLog.i(this.TAG, 1, "onRealActivityStop roomId:" + S());
        J().g();
    }

    @Override // com.tencent.icgame.game.api.live.BaseLiveAudienceView
    public void u() {
        this.aegisLog.i(this.TAG, 1, "onSwitchRoom roomId:" + S());
        V().e();
    }

    @Override // com.tencent.icgame.game.api.live.BaseLiveAudienceView
    public boolean v() {
        boolean z16 = false;
        if (com.tencent.icgame.game.liveroom.impl.room.floatwindow.b.f115282a.a(S())) {
            return false;
        }
        LiveRoomExtraInfo extraInfo = R().getExtraInfo();
        if (extraInfo != null) {
            z16 = extraInfo.e();
        }
        if (z16) {
            return true;
        }
        return this.f114878d;
    }
}

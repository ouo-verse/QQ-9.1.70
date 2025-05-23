package com.tencent.mobileqq.aio.helper;

import com.tencent.aio.api.runtime.emitter.AIOServiceContact$IRecycleViewScrollCallBack;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.mobileqq.aio.background.FullBackgroundMviIntent;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.AIOTroopGiftEvent;
import com.tencent.mobileqq.aio.helper.DynamicPicHelper$scrollListener$2;
import com.tencent.mobileqq.aio.msglist.holder.component.video.AIOVideoViewer;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.anisticker.view.AniStickerLottieView;
import com.tencent.qqnt.aio.utils.ViewUtils;
import com.tencent.qqnt.doutu.DuiButtonImageView;
import cooperation.qzone.QZoneClickReport;
import java.util.HashSet;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\n*\u0002%(\b\u0007\u0018\u0000 /2\u00020\u00012\u00020\u0002:\u00010B\u0007\u00a2\u0006\u0004\b-\u0010.J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\u0005H\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u000eH\u0016R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010#R\u0014\u0010'\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010&R\u001b\u0010,\u001a\u00020(8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010)\u001a\u0004\b*\u0010+\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/aio/helper/DynamicPicHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/mvi/base/route/g;", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/aio/event/AIOMsgListEvent$ListScrollDistanceNotify;", "intent", DomainData.DOMAIN_NAME, tl.h.F, "g", "j", "i", "", "getId", "", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "state", "onMoveToState", "d", "Lcom/tencent/aio/main/businesshelper/b;", "", "e", "Z", "isShowEmotionPanel", "f", "I", "aioListScrollDy", "", "J", "aioListScrollStartTime", "com/tencent/mobileqq/aio/helper/DynamicPicHelper$b", "Lcom/tencent/mobileqq/aio/helper/DynamicPicHelper$b;", "action", "com/tencent/mobileqq/aio/helper/DynamicPicHelper$scrollListener$2$a", "Lkotlin/Lazy;", "k", "()Lcom/tencent/mobileqq/aio/helper/DynamicPicHelper$scrollListener$2$a;", "scrollListener", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes10.dex */
public final class DynamicPicHelper implements com.tencent.aio.main.businesshelper.h, com.tencent.mvi.base.route.g {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.aio.main.businesshelper.b param;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isShowEmotionPanel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int aioListScrollDy;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long aioListScrollStartTime;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b action;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy scrollListener;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/helper/DynamicPicHelper$a;", "", "", "FAST_SCROLL_SPEED_PER_MILLIS", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.helper.DynamicPicHelper$a, reason: from kotlin metadata */
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

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/helper/DynamicPicHelper$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DynamicPicHelper.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                DynamicPicHelper.this.m(i3);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50112);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public DynamicPicHelper() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.action = new b();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<DynamicPicHelper$scrollListener$2.a>() { // from class: com.tencent.mobileqq.aio.helper.DynamicPicHelper$scrollListener$2
            static IPatchRedirector $redirector_;

            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/helper/DynamicPicHelper$scrollListener$2$a", "Lcom/tencent/aio/api/runtime/emitter/AIOServiceContact$IRecycleViewScrollCallBack;", "", "state", "", "onScrollStateChange", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes10.dex */
            public static final class a implements AIOServiceContact$IRecycleViewScrollCallBack {
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ DynamicPicHelper f188862d;

                a(DynamicPicHelper dynamicPicHelper) {
                    this.f188862d = dynamicPicHelper;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) dynamicPicHelper);
                    }
                }

                @Override // com.tencent.aio.api.runtime.emitter.AIOServiceContact$IRecycleViewScrollCallBack
                public void onScrollStateChange(int state) {
                    com.tencent.aio.main.businesshelper.b bVar;
                    com.tencent.aio.main.businesshelper.b bVar2;
                    com.tencent.aio.main.businesshelper.b bVar3;
                    com.tencent.aio.api.runtime.a a16;
                    com.tencent.mvi.base.route.j e16;
                    com.tencent.aio.api.runtime.a a17;
                    com.tencent.mvi.base.route.j e17;
                    com.tencent.aio.api.runtime.a a18;
                    com.tencent.mvi.base.route.j e18;
                    boolean z16;
                    com.tencent.aio.main.businesshelper.b bVar4;
                    com.tencent.aio.main.businesshelper.b bVar5;
                    com.tencent.aio.main.businesshelper.b bVar6;
                    com.tencent.aio.api.runtime.a a19;
                    com.tencent.mvi.base.route.j e19;
                    com.tencent.aio.api.runtime.a a26;
                    com.tencent.mvi.base.route.j e26;
                    com.tencent.aio.api.runtime.a a27;
                    com.tencent.mvi.base.route.j e27;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, state);
                        return;
                    }
                    if (state == 0) {
                        this.f188862d.aioListScrollDy = 0;
                        AbstractGifImage.resumeAll();
                        ApngImage.resumeAll();
                        ApngImage.playByTag(0);
                        com.tencent.qqnt.emotion.pic.libra.ApngImage.C();
                        com.tencent.qqnt.emotion.pic.libra.ApngImage.A(0);
                        URLDrawable.resume();
                        AniStickerLottieView.INSTANCE.f();
                        DuiButtonImageView.d();
                        AIOVideoViewer.P.a();
                        bVar = this.f188862d.param;
                        if (bVar != null && (a18 = bVar.a()) != null && (e18 = a18.e()) != null) {
                            e18.h(new AIOMsgListEvent.VideoPlayEvent(false));
                        }
                        bVar2 = this.f188862d.param;
                        if (bVar2 != null && (a17 = bVar2.a()) != null && (e17 = a17.e()) != null) {
                            e17.h(new AIOTroopGiftEvent.TroopGiftPlayEvent(false));
                        }
                        com.tencent.cachedrawable.dynamicdrawable.api.b.e(com.tencent.cachedrawable.dynamicdrawable.api.b.f98854a, QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO, null, 2, null);
                        bVar3 = this.f188862d.param;
                        if (bVar3 != null && (a16 = bVar3.a()) != null && (e16 = a16.e()) != null) {
                            e16.h(new FullBackgroundMviIntent.AIOBackgroundPlayEvent(false));
                            return;
                        }
                        return;
                    }
                    if (state == 1 || state == 2) {
                        z16 = this.f188862d.isShowEmotionPanel;
                        if (!z16) {
                            AbstractGifImage.pauseAll();
                            ApngImage.pauseAll();
                            ApngImage.pauseByTag(0);
                            com.tencent.qqnt.emotion.pic.libra.ApngImage.y();
                            com.tencent.qqnt.emotion.pic.libra.ApngImage.z(0);
                            URLDrawable.pause();
                        }
                        DuiButtonImageView.c();
                        AIOVideoViewer.P.b();
                        bVar4 = this.f188862d.param;
                        if (bVar4 != null && (a27 = bVar4.a()) != null && (e27 = a27.e()) != null) {
                            e27.h(new AIOMsgListEvent.VideoPlayEvent(true));
                        }
                        bVar5 = this.f188862d.param;
                        if (bVar5 != null && (a26 = bVar5.a()) != null && (e26 = a26.e()) != null) {
                            e26.h(new AIOTroopGiftEvent.TroopGiftPlayEvent(true));
                        }
                        com.tencent.cachedrawable.dynamicdrawable.api.b.c(com.tencent.cachedrawable.dynamicdrawable.api.b.f98854a, QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO, null, 2, null);
                        bVar6 = this.f188862d.param;
                        if (bVar6 != null && (a19 = bVar6.a()) != null && (e19 = a19.e()) != null) {
                            e19.h(new FullBackgroundMviIntent.AIOBackgroundPlayEvent(true));
                        }
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DynamicPicHelper.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new a(DynamicPicHelper.this) : (a) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.scrollListener = lazy;
    }

    private final void g() {
        com.tencent.aio.api.runtime.a a16;
        com.tencent.mvi.base.route.j e16;
        if (QLog.isDevelopLevel()) {
            QLog.d("DynamicPicHelper", 4, "doOnCreate");
        }
        com.tencent.aio.main.businesshelper.b bVar = this.param;
        if (bVar != null) {
            bVar.a().b().a(AIOServiceContact$IRecycleViewScrollCallBack.class).a(k());
        }
        com.tencent.aio.main.businesshelper.b bVar2 = this.param;
        if (bVar2 != null && (a16 = bVar2.a()) != null && (e16 = a16.e()) != null) {
            e16.f(this, this.action);
        }
    }

    private final void h() {
        com.tencent.aio.api.runtime.a a16;
        com.tencent.mvi.base.route.j e16;
        if (QLog.isDevelopLevel()) {
            QLog.d("DynamicPicHelper", 4, "doOnDestroy");
        }
        this.isShowEmotionPanel = false;
        com.tencent.aio.main.businesshelper.b bVar = this.param;
        if (bVar != null) {
            bVar.a().b().a(AIOServiceContact$IRecycleViewScrollCallBack.class).c(k());
        }
        com.tencent.aio.main.businesshelper.b bVar2 = this.param;
        if (bVar2 != null && (a16 = bVar2.a()) != null && (e16 = a16.e()) != null) {
            e16.i(this, this.action);
        }
    }

    private final void i() {
        AbstractGifImage.pauseAll();
        ApngImage.pauseByTag(0);
    }

    private final void j() {
        AbstractGifImage.resumeAll();
        ApngImage.playByTag(0);
    }

    private final DynamicPicHelper$scrollListener$2.a k() {
        return (DynamicPicHelper$scrollListener$2.a) this.scrollListener.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(MsgIntent msgIntent) {
        if (msgIntent instanceof PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) {
            this.isShowEmotionPanel = ((PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) msgIntent).b();
            if (QLog.isDevelopLevel()) {
                QLog.d("DynamicPicHelper", 4, "[OnPanelStateChangedMsgIntent] isShowEmotionPanel=" + this.isShowEmotionPanel);
                return;
            }
            return;
        }
        if (msgIntent instanceof AIOMsgListEvent.ListScrollDistanceNotify) {
            n((AIOMsgListEvent.ListScrollDistanceNotify) msgIntent);
        }
    }

    private final void n(AIOMsgListEvent.ListScrollDistanceNotify intent) {
        if (this.aioListScrollDy == 0) {
            this.aioListScrollStartTime = System.currentTimeMillis();
        }
        int b16 = this.aioListScrollDy + intent.b();
        this.aioListScrollDy = b16;
        if (Math.abs(b16) > ViewUtils.f352270a.d()) {
            long currentTimeMillis = System.currentTimeMillis() - this.aioListScrollStartTime;
            if (currentTimeMillis > 0 && Math.abs(this.aioListScrollDy) / currentTimeMillis > 4) {
                AniStickerLottieView.INSTANCE.e();
            }
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return 2;
        }
        return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Set) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.input.base.panelcontainer.PanelContainerMsgIntent.OnPanelStateChangedMsgIntent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.ListScrollDistanceNotify");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Set) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return new HashSet();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "DynamicPicHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (int[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new int[]{0, 3, 8, 12};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) param);
        } else {
            Intrinsics.checkNotNullParameter(param, "param");
            this.param = param;
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            h.a.b(this);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, state);
            return;
        }
        if (state != 0) {
            if (state != 3) {
                if (state != 8) {
                    if (state == 12) {
                        h();
                        return;
                    }
                    return;
                }
                i();
                return;
            }
            j();
            return;
        }
        g();
    }
}

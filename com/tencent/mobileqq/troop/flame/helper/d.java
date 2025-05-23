package com.tencent.mobileqq.troop.flame.helper;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mobileqq.aio.title.an;
import com.tencent.mobileqq.aio.utils.ad;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.flame.api.ITroopFlameApi;
import com.tencent.mobileqq.troop.flame.detail.view.TroopFlameView;
import com.tencent.mobileqq.troop.flame.surprise.TroopFlameSurpriseEggManager;
import com.tencent.mobileqq.troop.halfscreennotification.api.ITroopHalfScreenNotificationApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.helper.cw;
import com.tencent.qqnt.aio.utils.l;
import com.tencent.qqnt.bus.api.IBusManager;
import com.tencent.qqnt.kernel.nativeinterface.GroupExt;
import com.tencent.qqnt.kernel.nativeinterface.GroupExtFlameData;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import com.tencent.qqnt.troop.TroopInfoRepo;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\t*\u0001)\b\u0007\u0018\u0000 /2\u00020\u0001:\u00010B\u0007\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\bH\u0016R\u0016\u0010\u0015\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/troop/flame/helper/d;", "Lcom/tencent/aio/main/businesshelper/h;", "", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", "p", "k", "", "getId", "", "getTag", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "", "interestedIn", "state", "onMoveToState", "d", "Lcom/tencent/aio/main/businesshelper/b;", "mHelperParam", "Lcom/tencent/aio/api/runtime/a;", "e", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "f", "Ljava/lang/String;", "mTroopUin", "Lcom/tencent/mobileqq/troop/flame/detail/view/TroopFlameView;", h.F, "Lcom/tencent/mobileqq/troop/flame/detail/view/TroopFlameView;", "flameView", "Lcom/tencent/mobileqq/troop/flame/surprise/TroopFlameSurpriseEggManager;", "i", "Lcom/tencent/mobileqq/troop/flame/surprise/TroopFlameSurpriseEggManager;", "eggManager", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupExtFlameData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/kernel/nativeinterface/GroupExtFlameData;", "troopFlameData", "com/tencent/mobileqq/troop/flame/helper/d$b", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/troop/flame/helper/d$b;", "troopFlameEventObserver", "<init>", "()V", "D", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes19.dex */
public final class d implements com.tencent.aio.main.businesshelper.h {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private b troopFlameEventObserver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.main.businesshelper.b mHelperParam;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private String mTroopUin;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TroopFlameView flameView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TroopFlameSurpriseEggManager eggManager;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GroupExtFlameData troopFlameData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/troop/flame/helper/d$a;", "", "", "MARGIN_LEFT_DP", "I", "PAG_FACE_ICON_EXTRA_DISTANCE_DP", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.flame.helper.d$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/troop/flame/helper/d$b", "Lzv3/c;", "Lzv3/a;", "event", "", "B5", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements zv3.c {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        @Override // zv3.c
        public void B5(@NotNull zv3.a event) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) event);
                return;
            }
            Intrinsics.checkNotNullParameter(event, "event");
            if (event instanceof com.tencent.mobileqq.troop.flame.event.a) {
                com.tencent.mobileqq.troop.flame.event.a aVar = (com.tencent.mobileqq.troop.flame.event.a) event;
                String b16 = aVar.b();
                String str = d.this.mTroopUin;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTroopUin");
                    str = null;
                }
                if (Intrinsics.areEqual(b16, str)) {
                    d.this.troopFlameData = aVar.a();
                    d.this.q();
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/troop/flame/helper/d$c", "Lcom/tencent/mobileqq/aio/utils/ad;", "", "xLocation", "yLocation", "", "width", "height", "", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class c implements ad {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        @Override // com.tencent.mobileqq.aio.utils.ad
        public void a(int xLocation, int yLocation, float width, float height) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(xLocation), Integer.valueOf(yLocation), Float.valueOf(width), Float.valueOf(height));
                return;
            }
            int[] iArr = {xLocation + l.b(4) + l.b(4), yLocation};
            float[] fArr = {width, height};
            TroopFlameSurpriseEggManager troopFlameSurpriseEggManager = d.this.eggManager;
            if (troopFlameSurpriseEggManager != null) {
                troopFlameSurpriseEggManager.n(iArr, fArr);
            }
            d.this.k();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36419);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.troopFlameEventObserver = new b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.troop.flame.helper.c
            @Override // java.lang.Runnable
            public final void run() {
                d.m(d.this);
            }
        }, 32, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(d this$0) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ITroopUtilApi iTroopUtilApi = (ITroopUtilApi) QRoute.api(ITroopUtilApi.class);
        String str = this$0.mTroopUin;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTroopUin");
            str = null;
        }
        if (!iTroopUtilApi.hasUnReadRepeatTroopNotification(str)) {
            TroopFlameSurpriseEggManager troopFlameSurpriseEggManager = this$0.eggManager;
            if (troopFlameSurpriseEggManager != null) {
                z16 = troopFlameSurpriseEggManager.g(this$0.troopFlameData);
            } else {
                z16 = false;
            }
            if (!z16) {
                ((ITroopHalfScreenNotificationApi) QRoute.api(ITroopHalfScreenNotificationApi.class)).notifyHalfScreenNotificationAvailable();
                return;
            }
            return;
        }
        QLog.i("TroopAIOTitleFlameHelper", 1, "[checkTroopNotificationAndAddEgg] has troop notification = true");
    }

    private final void n() {
        GroupExt groupExt;
        TroopInfoRepo troopInfoRepo = TroopInfoRepo.INSTANCE;
        String str = this.mTroopUin;
        GroupExtFlameData groupExtFlameData = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTroopUin");
            str = null;
        }
        TroopInfo troopInfoFromCache = troopInfoRepo.getTroopInfoFromCache(str);
        if (troopInfoFromCache != null && (groupExt = troopInfoFromCache.groupExt) != null) {
            groupExtFlameData = groupExt.groupExtFlameData;
        }
        this.troopFlameData = groupExtFlameData;
        q();
    }

    private final void o() {
        ((IBusManager) QRoute.api(IBusManager.class)).registerEvent(com.tencent.mobileqq.troop.flame.event.a.class, this.troopFlameEventObserver);
    }

    private final void p() {
        ((IBusManager) QRoute.api(IBusManager.class)).unRegisterEvent(com.tencent.mobileqq.troop.flame.event.a.class, this.troopFlameEventObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.flame.helper.a
            @Override // java.lang.Runnable
            public final void run() {
                d.r(d.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(final d this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.aio.main.businesshelper.b bVar = this$0.mHelperParam;
        com.tencent.aio.api.runtime.a aVar = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHelperParam");
            bVar = null;
        }
        final Context context = bVar.a().c().getContext();
        if (this$0.troopFlameData != null && context != null) {
            if (this$0.flameView == null) {
                TroopFlameView troopFlameView = new TroopFlameView(context);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 16;
                layoutParams.leftMargin = l.b(4);
                troopFlameView.setLayoutParams(layoutParams);
                troopFlameView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.flame.helper.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        d.s(context, this$0, view);
                    }
                });
                this$0.flameView = troopFlameView;
            }
            TroopFlameView troopFlameView2 = this$0.flameView;
            if (troopFlameView2 != null) {
                GroupExtFlameData groupExtFlameData = this$0.troopFlameData;
                if (groupExtFlameData != null) {
                    ITroopFlameApi.a flameViewDataFromPB = ((ITroopFlameApi) QRoute.api(ITroopFlameApi.class)).getFlameViewDataFromPB(groupExtFlameData);
                    if (!flameViewDataFromPB.f296043d) {
                        troopFlameView2.setVisibility(8);
                    } else {
                        troopFlameView2.setVisibility(0);
                        troopFlameView2.c(flameViewDataFromPB.f296040a, flameViewDataFromPB.f296041b, flameViewDataFromPB.f296042c);
                    }
                }
                com.tencent.aio.api.runtime.a aVar2 = this$0.mAIOContext;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                } else {
                    aVar = aVar2;
                }
                aVar.e().h(new AIOTitleEvent.UpdateTroopFlameEvent(new an(troopFlameView2, new c())));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(Context context, d this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ITroopFlameApi iTroopFlameApi = (ITroopFlameApi) QRoute.api(ITroopFlameApi.class);
        String str = this$0.mTroopUin;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTroopUin");
            str = null;
        }
        iTroopFlameApi.showTroopFlameDetailDialog(context, str);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return cw.f350687x1;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "TroopAIOTitleFlameHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (int[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return new int[]{0, 4, 12};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) param);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        h.a.a(this, param);
        this.mHelperParam = param;
        com.tencent.aio.api.runtime.a a16 = param.a();
        this.mAIOContext = a16;
        String str2 = null;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            a16 = null;
        }
        this.mTroopUin = a16.g().r().c().j();
        QRouteApi api = QRoute.api(ITroopListRepoApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(ITroopListRepoApi::class.java)");
        ITroopListRepoApi iTroopListRepoApi = (ITroopListRepoApi) api;
        String str3 = this.mTroopUin;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTroopUin");
            str = null;
        } else {
            str = str3;
        }
        if (ITroopListRepoApi.a.b(iTroopListRepoApi, str, "TroopAIOTitleFlameHelper", false, 4, null)) {
            String str4 = this.mTroopUin;
            if (str4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTroopUin");
            } else {
                str2 = str4;
            }
            QLog.i("TroopAIOTitleFlameHelper", 1, "[onCreate] isExitTroop, mTroopUin = " + str2);
            return;
        }
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        Context context = aVar.c().getContext();
        if (context != null) {
            com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                aVar2 = null;
            }
            String str5 = this.mTroopUin;
            if (str5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTroopUin");
            } else {
                str2 = str5;
            }
            this.eggManager = new TroopFlameSurpriseEggManager(aVar2, context, str2);
        }
        n();
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
            if (state == 12) {
                p();
                TroopFlameView troopFlameView = this.flameView;
                if (troopFlameView != null) {
                    troopFlameView.b();
                    return;
                }
                return;
            }
            return;
        }
        o();
    }
}

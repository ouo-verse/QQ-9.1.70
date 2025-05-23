package com.tencent.qqnt.aio.helper;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.api.ITroopEnterEffectApi;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController;
import com.tencent.mobileqq.troop.entereffect.api.ITroopEnterEffectService;
import com.tencent.mobileqq.vas.VasMMKVProxy;
import com.tencent.mobileqq.vas.VipMMKV;
import com.tencent.mobileqq.vas.troop.IceBreakHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.reserve2.animation.BusiAnimationEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001,B\u0007\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u000fH\u0016J\b\u0010\u0015\u001a\u00020\bH\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0017\u0010%\u001a\u00020!8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\"\u001a\u0004\b#\u0010$R\u0016\u0010)\u001a\u0004\u0018\u00010&8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b'\u0010(\u00a8\u0006-"}, d2 = {"Lcom/tencent/qqnt/aio/helper/du;", "Lcom/tencent/aio/main/businesshelper/h;", "", "i", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "e", "", tl.h.F, "o", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "state", "onMoveToState", "", "interestedIn", "getId", "getTag", "Lcom/tencent/mobileqq/troop/enterEffect/TroopEnterEffectController;", "d", "Lcom/tencent/mobileqq/troop/enterEffect/TroopEnterEffectController;", "mTroopEnterEffectController", "", "Z", "isFirstShow", "Lcom/tencent/aio/api/runtime/a;", "f", "Lcom/tencent/aio/api/runtime/a;", "mAioContext", "Lcom/tencent/mobileqq/troop/onlinepush/api/b;", "Lcom/tencent/mobileqq/troop/onlinepush/api/b;", "getTroopOnlinePushObserver", "()Lcom/tencent/mobileqq/troop/onlinepush/api/b;", "troopOnlinePushObserver", "Lcom/tencent/common/app/AppInterface;", "g", "()Lcom/tencent/common/app/AppInterface;", "mApp", "<init>", "()V", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes34.dex */
public final class du implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TroopEnterEffectController mTroopEnterEffectController;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAioContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isFirstShow = true;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.mobileqq.troop.onlinepush.api.b troopOnlinePushObserver = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/helper/du$b", "Lcom/tencent/mobileqq/troop/onlinepush/api/b;", "Lcom/tencent/mobileqq/troop/entereffect/f;", "data", "", "onPushTroopEnterEffect", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends com.tencent.mobileqq.troop.onlinepush.api.b {
        b() {
        }

        @Override // com.tencent.mobileqq.troop.onlinepush.api.b
        protected void onPushTroopEnterEffect(com.tencent.mobileqq.troop.entereffect.f data) {
            if (QLog.isColorLevel()) {
                Intrinsics.checkNotNull(data);
                QLog.d("TroopEffectHelper", 2, "onPushTroopEnterEffect: troopUin = " + data.f295260c + ", data.id = " + data.f295258a);
            }
            if (!com.tencent.biz.anonymous.a.h().d(du.this.h())) {
                du.this.o();
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("TroopEffectHelper", 2, "onPushTroopEnterEffect: troopUin = " + du.this.h() + " isAnonymous");
            }
        }
    }

    private final AppInterface g() {
        return com.tencent.mobileqq.troop.utils.bg.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String h() {
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        String j3;
        com.tencent.aio.api.runtime.a aVar = this.mAioContext;
        return (aVar == null || (g16 = aVar.g()) == null || (r16 = g16.r()) == null || (c16 = r16.c()) == null || (j3 = c16.j()) == null) ? "" : j3;
    }

    private final void i() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.helper.dt
            @Override // java.lang.Runnable
            public final void run() {
                du.j(du.this);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(du this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        VasMMKVProxy enterEffectConfig = VipMMKV.INSTANCE.getEnterEffectConfig();
        AppInterface g16 = this$0.g();
        long decodeLong = enterEffectConfig.decodeLong(g16 != null ? g16.getCurrentAccountUin() : null, System.currentTimeMillis());
        AppInterface g17 = this$0.g();
        ITroopEnterEffectService iTroopEnterEffectService = g17 != null ? (ITroopEnterEffectService) g17.getRuntimeService(ITroopEnterEffectService.class, "all") : null;
        com.tencent.mobileqq.troop.entereffect.e troopEnterEffectConfig = iTroopEnterEffectService != null ? iTroopEnterEffectService.getTroopEnterEffectConfig() : null;
        if (decodeLong == 0 || troopEnterEffectConfig == null || troopEnterEffectConfig.f295227b == null || (System.currentTimeMillis() - decodeLong) / 1000 > troopEnterEffectConfig.f295227b.f295232a) {
            ((ITroopEnterEffectApi) QRoute.api(ITroopEnterEffectApi.class)).sendTroopEnterEffectCMD(this$0.g(), 2L, 0L);
        }
    }

    private final void k() {
        ITroopEnterEffectService iTroopEnterEffectService;
        TroopEnterEffectController troopEnterEffectController = this.mTroopEnterEffectController;
        if (troopEnterEffectController != null) {
            troopEnterEffectController.p();
        }
        AppInterface g16 = g();
        if (g16 == null || (iTroopEnterEffectService = (ITroopEnterEffectService) g16.getRuntimeService(ITroopEnterEffectService.class, "all")) == null) {
            return;
        }
        iTroopEnterEffectService.setMode(0);
        iTroopEnterEffectService.setSvipLevel(0);
        iTroopEnterEffectService.setSvipType(0);
        iTroopEnterEffectService.setGroupLevel(0);
    }

    private final void m() {
        AppInterface g16;
        ITroopEnterEffectService iTroopEnterEffectService;
        TroopEnterEffectController troopEnterEffectController = this.mTroopEnterEffectController;
        if (troopEnterEffectController != null) {
            troopEnterEffectController.q();
        }
        if (this.isFirstShow || (g16 = g()) == null || (iTroopEnterEffectService = (ITroopEnterEffectService) g16.getRuntimeService(ITroopEnterEffectService.class, "all")) == null || iTroopEnterEffectService.getMode() == 0 || com.tencent.biz.anonymous.a.h().d(h()) || SimpleUIUtil.getSimpleUISwitch()) {
            return;
        }
        int effectId = iTroopEnterEffectService.getEffectId();
        AppInterface g17 = g();
        String currentAccountUin = g17 != null ? g17.getCurrentAccountUin() : null;
        if (currentAccountUin == null) {
            currentAccountUin = "";
        }
        iTroopEnterEffectService.addTroopEnterEffectData(new com.tencent.mobileqq.troop.entereffect.f(effectId, currentAccountUin, h(), iTroopEnterEffectService.getSvipLevel(), iTroopEnterEffectService.getSvipType(), iTroopEnterEffectService.getGroupLevel(), iTroopEnterEffectService.getMode()));
        o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        com.tencent.mvi.base.route.j e16;
        Fragment c16;
        if (this.mTroopEnterEffectController == null) {
            com.tencent.aio.api.runtime.a aVar = this.mAioContext;
            this.mTroopEnterEffectController = new TroopEnterEffectController((aVar == null || (c16 = aVar.c()) == null) ? null : c16.getContext());
        }
        TroopEnterEffectController troopEnterEffectController = this.mTroopEnterEffectController;
        if (troopEnterEffectController != null) {
            troopEnterEffectController.s(h());
        }
        TroopEnterEffectController troopEnterEffectController2 = this.mTroopEnterEffectController;
        if (troopEnterEffectController2 != null) {
            com.tencent.aio.api.runtime.a aVar2 = this.mAioContext;
            if (aVar2 != null && (e16 = aVar2.e()) != null) {
                View h16 = troopEnterEffectController2.h();
                Intrinsics.checkNotNullExpressionValue(h16, "it.rootView");
                e16.h(new BusiAnimationEvent.AddFullScreenView(5, h16));
            }
            troopEnterEffectController2.r();
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.f350680v0;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "TroopEffectHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.mAioContext = param.a();
        AppInterface g16 = g();
        if (g16 != null) {
            g16.addObserver(this.troopOnlinePushObserver);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        TroopEnterEffectController troopEnterEffectController = this.mTroopEnterEffectController;
        if (troopEnterEffectController != null) {
            troopEnterEffectController.o();
        }
        IceBreakHelper.INSTANCE.clearPlayEnterEffect();
        AppInterface g16 = g();
        if (g16 != null) {
            g16.removeObserver(this.troopOnlinePushObserver);
        }
        e();
        this.isFirstShow = true;
    }

    private final void n() {
        ITroopEnterEffectService iTroopEnterEffectService;
        Fragment c16;
        this.isFirstShow = false;
        i();
        if (this.mTroopEnterEffectController == null) {
            com.tencent.aio.api.runtime.a aVar = this.mAioContext;
            this.mTroopEnterEffectController = new TroopEnterEffectController((aVar == null || (c16 = aVar.c()) == null) ? null : c16.getContext());
        }
        TroopEnterEffectController troopEnterEffectController = this.mTroopEnterEffectController;
        if (troopEnterEffectController != null) {
            troopEnterEffectController.s(h());
        }
        AppInterface g16 = g();
        if (g16 == null || (iTroopEnterEffectService = (ITroopEnterEffectService) g16.getRuntimeService(ITroopEnterEffectService.class, "all")) == null) {
            return;
        }
        iTroopEnterEffectService.setMode(0);
        iTroopEnterEffectService.setSvipLevel(0);
        iTroopEnterEffectService.setSvipType(0);
        iTroopEnterEffectService.setGroupLevel(0);
        if (!SimpleUIUtil.getSimpleUISwitch()) {
            iTroopEnterEffectService.notifyEnterTroop(h());
        }
        m();
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{3, 4, 8};
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state == 3) {
            m();
        } else if (state == 4) {
            n();
        } else {
            if (state != 8) {
                return;
            }
            k();
        }
    }

    private final void e() {
    }
}

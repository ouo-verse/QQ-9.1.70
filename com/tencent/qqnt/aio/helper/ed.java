package com.tencent.qqnt.aio.helper;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.aio.event.AIOTroopGiftEvent;
import com.tencent.mobileqq.data.MessageForAioGift;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qqlive.api.config.QQLiveSDKConfigHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.mobileqq.vas.api.ITroopGiftApi;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.reserve2.animation.BusiAnimationEvent;
import com.tencent.qqnt.kernelpublic.nativeinterface.TextGiftElement;
import cooperation.ilive.util.ILiveEntranceUtilApi;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\b*\u0001%\b\u0007\u0018\u0000 \u00102\u00020\u00012\u00020\u0002:\u0001+B\u0007\u00a2\u0006\u0004\b)\u0010*J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016J\u001e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rJ\b\u0010\u0011\u001a\u00020\u0005H\u0016J\b\u0010\u0012\u001a\u00020\bH\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017H\u0016R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR$\u0010$\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006,"}, d2 = {"Lcom/tencent/qqnt/aio/helper/ed;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/mvi/base/route/g;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "c", "e", "", "state", "onMoveToState", "Lcom/tencent/mobileqq/aio/msg/ai;", "giftItem", "", "isClick", "isNewGiftMessage", tl.h.F, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "getId", "", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/b;", "Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/b;", "getAnimationEngine", "()Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/b;", "setAnimationEngine", "(Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/b;)V", "animationEngine", "com/tencent/qqnt/aio/helper/ed$b", "f", "Lcom/tencent/qqnt/aio/helper/ed$b;", "mAction1", "<init>", "()V", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes34.dex */
public final class ed implements com.tencent.aio.main.businesshelper.h, com.tencent.mvi.base.route.g {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.qqgift.mvvm.business.anim.b animationEngine;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final b mAction1 = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/helper/ed$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            ed.this.c(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(MsgIntent i3) {
        if (i3 instanceof AIOTroopGiftEvent.StartGiftAnimationEvent) {
            AIOTroopGiftEvent.StartGiftAnimationEvent startGiftAnimationEvent = (AIOTroopGiftEvent.StartGiftAnimationEvent) i3;
            com.tencent.aio.data.msglist.a a16 = startGiftAnimationEvent.a();
            com.tencent.mobileqq.aio.msg.ai aiVar = a16 instanceof com.tencent.mobileqq.aio.msg.ai ? (com.tencent.mobileqq.aio.msg.ai) a16 : null;
            if (aiVar != null) {
                h(aiVar, startGiftAnimationEvent.b(), startGiftAnimationEvent.c());
            }
        }
    }

    private final void e() {
        Fragment c16;
        Context context;
        com.tencent.mobileqq.qqgift.mvvm.business.anim.b A;
        com.tencent.mvi.base.route.j e16;
        nh2.c sDKImpl = ((IQQGiftManager) QRoute.api(IQQGiftManager.class)).getSDKImpl(QQLiveSDKConfigHelper.getSceneId());
        if (sDKImpl == null) {
            QLog.e("TroopNewGiftPagAnimPlayHelper", 1, "giftSDK == null.");
            return;
        }
        if (this.animationEngine == null) {
            if (!sDKImpl.isInited()) {
                com.tencent.mobileqq.qqgift.sdk.config.a b16 = com.tencent.mobileqq.qqgift.sdk.config.a.a().d(QQLiveSDKConfigHelper.getSceneId()).a(((ILiveEntranceUtilApi) QRoute.api(ILiveEntranceUtilApi.class)).getQQLiveSecretKey()).b();
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime != null) {
                    sDKImpl.c(peekAppRuntime, b16);
                }
            }
            com.tencent.aio.api.runtime.a aVar = this.aioContext;
            if (aVar == null || (c16 = aVar.c()) == null || (context = c16.getContext()) == null || (A = sDKImpl.d().A(context, 0)) == null) {
                return;
            }
            this.animationEngine = A;
            Intrinsics.checkNotNull(A);
            A.prepare();
            com.tencent.mobileqq.qqgift.mvvm.business.anim.b bVar = this.animationEngine;
            Intrinsics.checkNotNull(bVar);
            View k3 = bVar.k();
            Intrinsics.checkNotNullExpressionValue(k3, "animationEngine!!.giftAnimationView");
            k3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.aio.helper.ec
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ed.g(ed.this, view);
                }
            });
            com.tencent.aio.api.runtime.a aVar2 = this.aioContext;
            if (aVar2 != null && (e16 = aVar2.e()) != null) {
                e16.h(new BusiAnimationEvent.AddFullScreenView(2, k3));
            }
            com.tencent.mobileqq.qqgift.mvvm.business.anim.b bVar2 = this.animationEngine;
            Intrinsics.checkNotNull(bVar2);
            Intrinsics.checkNotNullExpressionValue(bVar2.b(), "animationEngine!!.giftBannerView");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(ed this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.qqgift.mvvm.business.anim.b bVar = this$0.animationEngine;
        Intrinsics.checkNotNull(bVar);
        bVar.reset();
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.f350688y;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.AIOTroopGiftEvent.StartGiftAnimationEvent");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        return new HashSet();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "TroopNewGiftPagAnimPlayHelper";
    }

    public final void h(com.tencent.mobileqq.aio.msg.ai giftItem, boolean isClick, boolean isNewGiftMessage) {
        TextGiftElement j26;
        View k3;
        com.tencent.aio.api.runtime.a aVar;
        com.tencent.mvi.base.route.j e16;
        Intrinsics.checkNotNullParameter(giftItem, "giftItem");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || (j26 = giftItem.j2()) == null) {
            return;
        }
        VasPerfReportUtils.reportGiftViewPlay(VasPerfReportUtils.INTENT_TO_PLAY, String.valueOf(QQLiveSDKConfigHelper.getSceneId()));
        if (this.animationEngine == null) {
            VasPerfReportUtils.reportGiftViewPlay(VasPerfReportUtils.PREPARE_ENGINE, String.valueOf(QQLiveSDKConfigHelper.getSceneId()));
            e();
        }
        if (this.animationEngine == null) {
            return;
        }
        String avatarUrl = ((IQQGuildAvatarApi) peekAppRuntime.getRuntimeService(IQQGuildAvatarApi.class, "")).getAvatarUrl(peekAppRuntime, "0", String.valueOf(j26.senderUin));
        String avatarUrl2 = ((IQQGuildAvatarApi) peekAppRuntime.getRuntimeService(IQQGuildAvatarApi.class, "")).getAvatarUrl(peekAppRuntime, "0", String.valueOf(j26.receiverUin));
        com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar2 = new com.tencent.mobileqq.qqgift.mvvm.business.anim.a();
        aVar2.f264914e = (int) j26.tianquanId;
        aVar2.f264913d = j26.giftName;
        aVar2.f264910a = (int) j26.giftId;
        aVar2.f264915f = 1;
        aVar2.f264918i = j26.senderUin;
        aVar2.f264919j = j26.senderNick;
        aVar2.f264920k = j26.receiverUin;
        aVar2.f264921l = j26.receiverNick;
        aVar2.f264922m = avatarUrl;
        aVar2.f264923n = avatarUrl2;
        aVar2.f264929t = true;
        aVar2.f264930u = j26.needPlayAnimation;
        if (j26.level > MessageForAioGift.GIFT_LEVEL_PRIMARY) {
            aVar2.f264924o = 3;
        } else {
            aVar2.f264924o = 1;
        }
        com.tencent.mobileqq.qqgift.mvvm.business.anim.b bVar = this.animationEngine;
        if (bVar != null && (k3 = bVar.k()) != null && (aVar = this.aioContext) != null && (e16 = aVar.e()) != null) {
            e16.h(new BusiAnimationEvent.AddFullScreenView(2, k3));
        }
        if (isClick) {
            aVar2.f264916g = 100;
            com.tencent.mobileqq.qqgift.mvvm.business.anim.b bVar2 = this.animationEngine;
            Intrinsics.checkNotNull(bVar2);
            bVar2.l(aVar2, 0);
            return;
        }
        if (isNewGiftMessage) {
            aVar2.f264916g = 100;
            com.tencent.mobileqq.qqgift.mvvm.business.anim.b bVar3 = this.animationEngine;
            Intrinsics.checkNotNull(bVar3);
            bVar3.d(aVar2);
            return;
        }
        com.tencent.mobileqq.qqgift.mvvm.business.anim.b bVar4 = this.animationEngine;
        Intrinsics.checkNotNull(bVar4);
        bVar4.l(aVar2, 0);
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(com.tencent.aio.main.businesshelper.b param) {
        com.tencent.mvi.base.route.j e16;
        Intrinsics.checkNotNullParameter(param, "param");
        com.tencent.aio.api.runtime.a a16 = param.a();
        this.aioContext = a16;
        if (a16 == null || (e16 = a16.e()) == null) {
            return;
        }
        e16.f(this, this.mAction1);
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        com.tencent.mvi.base.route.j e16;
        h.a.b(this);
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar != null && (e16 = aVar.e()) != null) {
            e16.i(this, this.mAction1);
        }
        com.tencent.mobileqq.qqgift.mvvm.business.anim.b bVar = this.animationEngine;
        if (bVar != null) {
            Intrinsics.checkNotNull(bVar);
            bVar.release();
            this.animationEngine = null;
        }
        this.aioContext = null;
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{0, 12};
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state == 0) {
            ((ITroopGiftApi) QRoute.api(ITroopGiftApi.class)).preLoadGiftHeadPag();
        } else {
            if (state != 12) {
                return;
            }
            onDestroy();
        }
    }
}

package com.tencent.ecommerce.biz.consumer.model;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import cg0.a;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.videnevent.api.IECVideoControlDelegate;
import com.tencent.ecommerce.biz.consumer.ECContentInfo;
import com.tencent.ecommerce.biz.consumer.view.ECVideoFeedsPrivatePolicyView;
import com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView;
import com.tencent.ecommerce.biz.consumer.view.IECPrivatePolicyView;
import com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanGameCardView;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import com.tencent.ecommerce.repo.consumer.resp.Advertisement;
import com.tencent.ecommerce.repo.consumer.resp.ExtendInfo;
import com.tencent.ecommerce.repo.consumer.resp.GameDownLoadInfo;
import com.tencent.ecommerce.repo.consumer.resp.GamePrivilegeInfo;
import com.tencent.ecommerce.repo.consumer.resp.PlayInfo;
import com.tencent.ecommerce.repo.consumer.resp.PlayUI;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import lh0.c;
import lh0.d;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010,\u001a\u00020+\u0012\u0006\u0010.\u001a\u00020-\u00a2\u0006\u0004\b/\u00100J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0007H\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\nH\u0002J\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\b\u0010\u001f\u001a\u00020\u0004H\u0002J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020 H\u0002J\b\u0010\"\u001a\u00020\nH\u0016J\b\u0010#\u001a\u00020\u0004H\u0016J\b\u0010$\u001a\u00020\u0004H\u0016J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010&\u001a\u00020\u0004H\u0016J\u0010\u0010'\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(H\u0016\u00a8\u00061"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/model/ECGoodsVideoFeedsViewModel;", "Lcom/tencent/ecommerce/biz/consumer/model/ECGoodsBaseViewModel;", "Llh0/a;", "event", "", "t0", "", "Lcom/tencent/ecommerce/repo/consumer/resp/PlayInfo;", "playInfoList", "v0", "", InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME, "duration", "B0", "Lcom/tencent/ecommerce/repo/consumer/resp/Advertisement;", "advertisement", "s0", "z0", "p0", "A0", "playInfo", "y0", "Lcom/tencent/ecommerce/repo/consumer/resp/PlayUI;", "playUI", "w0", "uiType", "", "x0", "Lcom/tencent/ecommerce/repo/consumer/resp/GamePrivilegeInfo;", "privilege", "r0", "q0", "Llh0/d;", "u0", "w", "Z", "onWrapperViewDisappear", "U", "T", "sendEvent", "Landroid/view/ViewGroup;", "viewGroup", "setTopWrapperView", "Landroid/content/Context;", "context", "Lcom/tencent/ecommerce/biz/consumer/ECContentInfo;", "contentInfo", "<init>", "(Landroid/content/Context;Lcom/tencent/ecommerce/biz/consumer/ECContentInfo;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECGoodsVideoFeedsViewModel extends ECGoodsBaseViewModel {
    public ECGoodsVideoFeedsViewModel(Context context, ECContentInfo eCContentInfo) {
        super(context, eCContentInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A0(int currentTime) {
        if (currentTime <= getMaxViewPlayPos()) {
            return;
        }
        Iterator<Map.Entry<Integer, PlayInfo>> it = H().entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<Integer, PlayInfo> next = it.next();
            int intValue = next.getKey().intValue();
            if (currentTime >= intValue) {
                f0(intValue);
                y0(next.getValue());
                break;
            }
        }
        if (getMaxViewPlayPos() == -1 || !H().containsKey(Integer.valueOf(getMaxViewPlayPos()))) {
            return;
        }
        H().remove(Integer.valueOf(getMaxViewPlayPos()));
        a.b(getTAG(), getPRE_LOG() + "initPlayPosInfoMapAndPreloadUI remove map time:" + getMaxViewPlayPos());
    }

    private final void B0(int currentTime, int duration) {
        e0(duration);
        d0(currentTime);
        p0();
        A0(currentTime);
    }

    private final void p0() {
        if (!B().isEmpty()) {
            v0(B());
            B().clear();
        }
    }

    private final void q0() {
        IECPrivatePolicyView privatePolicyView = getPrivatePolicyView();
        View view = privatePolicyView != null ? privatePolicyView.getView() : null;
        ViewGroup topWrapperView = getTopWrapperView();
        if (view == null || topWrapperView == null) {
            return;
        }
        ViewParent parent = view.getParent();
        if (Intrinsics.areEqual(parent, topWrapperView)) {
            return;
        }
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(view);
        }
        topWrapperView.addView(view);
    }

    private final boolean r0(GamePrivilegeInfo privilege) {
        return (TextUtils.isEmpty(privilege.getDeveloper()) || TextUtils.isEmpty(privilege.getVersion()) || TextUtils.isEmpty(privilege.getAppName())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t0(lh0.a event) {
        if (event instanceof c) {
            c cVar = (c) event;
            B0(cVar.getCom.tencent.mobileqq.tritonaudio.InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME java.lang.String(), cVar.getDuration());
        } else if (event instanceof d) {
            u0((d) event);
        }
    }

    private final void u0(d event) {
        if (getGoodCardView() == null) {
            a.b(getTAG(), getPRE_LOG() + "handleXingHuanEvent, goodCardView not ready.");
            return;
        }
        if (getGoodCardView() instanceof ECXingHuanGameCardView) {
            if (event.getAction() == 1) {
                IECGoodsCardView goodCardView = getGoodCardView();
                if (goodCardView != null) {
                    ((ECXingHuanGameCardView) goodCardView).X();
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.tencent.ecommerce.biz.consumer.view.xinghuan.ECXingHuanGameCardView");
            }
            return;
        }
        a.b(getTAG(), getPRE_LOG() + "handleXingHuanEvent, not ECXingHuanGameCardView.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v0(List<PlayInfo> playInfoList) {
        int i3;
        for (PlayInfo playInfo : playInfoList) {
            int playType = playInfo.getPlayPlan().getPlayType();
            if (playType != 0 && playType != 3) {
                if (playType == 1) {
                    i3 = playInfo.getPlayPlan().getPlayPlanFixedTime().getStartTime();
                } else {
                    if (playType == 2) {
                        int percentage = playInfo.getPlayPlan().getPlayPlanPercentage().getPercentage();
                        if (getDuration() == 0 && percentage != 0) {
                            if (!B().contains(playInfo)) {
                                B().add(playInfo);
                            }
                        } else {
                            i3 = (percentage * getDuration()) / 100;
                        }
                    }
                    i3 = -1;
                }
                if (i3 >= 0 && !H().containsValue(playInfo) && playType != 4) {
                    H().put(Integer.valueOf(i3), playInfo);
                    a.b(getTAG(), getPRE_LOG() + "initPlayPosInfoMapAndPreloadUI add map time:" + i3 + ",size:" + H().size());
                }
                q(M(playInfo.getUi()), playInfo.getUi().getUiType());
            }
        }
    }

    private final void w0(PlayUI playUI) {
        if (x0(playUI.getUiType())) {
            ViewGroup topWrapperView = getTopWrapperView();
            if (topWrapperView != null) {
                IECPrivatePolicyView privatePolicyView = getPrivatePolicyView();
                topWrapperView.removeView(privatePolicyView != null ? privatePolicyView.getView() : null);
            }
            if (getPrivatePolicyView() == null && r0(M(playUI).getGameInfo().getPrivilege())) {
                g0(new ECVideoFeedsPrivatePolicyView(this.context));
                IECPrivatePolicyView privatePolicyView2 = getPrivatePolicyView();
                if (privatePolicyView2 != null) {
                    privatePolicyView2.configUI(M(playUI).getGameInfo());
                }
            }
            q0();
        }
    }

    private final boolean x0(int uiType) {
        if (uiType != 400 && uiType != 420 && uiType != 421 && uiType != 422 && uiType != 423 && uiType != 424 && uiType != 425 && uiType != 426) {
            return false;
        }
        return true;
    }

    private final void z0() {
        ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.consumer.model.ECGoodsVideoFeedsViewModel$showUIIfNotShowing$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (ECGoodsVideoFeedsViewModel.this.getIsUIShowing() || ECGoodsVideoFeedsViewModel.this.getWrapperView() == null) {
                    return;
                }
                ECGoodsVideoFeedsViewModel.this.A0(0);
            }
        });
    }

    @Override // com.tencent.ecommerce.biz.consumer.model.ECGoodsBaseViewModel
    public void U(Advertisement advertisement) {
        s0(advertisement);
        if (!advertisement.getVideoAd().getPlayInfos().isEmpty()) {
            List<PlayInfo> playInfos = advertisement.getVideoAd().getPlayInfos();
            k0(playInfos);
            v0(playInfos);
            if (getContentInfo().getContentScene() == 3) {
                z0();
                return;
            }
            return;
        }
        a.a(getTAG(), "loadDataSucces", getPRE_LOG() + "videoAd null or playInfos null");
    }

    @Override // com.tencent.ecommerce.biz.consumer.model.ECGoodsBaseViewModel
    public void Z() {
        if (getIsUIShowing()) {
            o();
            j0(true);
        } else {
            z0();
        }
    }

    @Override // com.tencent.ecommerce.biz.consumer.model.ECGoodsBaseViewModel, com.tencent.ecommerce.biz.consumer.ui.api.IECGoodsViewModel
    public void onWrapperViewDisappear() {
        final boolean isWrapperViewVisible = getIsWrapperViewVisible();
        final IECGoodsCardView goodCardView = getGoodCardView();
        super.onWrapperViewDisappear();
        ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.consumer.model.ECGoodsVideoFeedsViewModel$onWrapperViewDisappear$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IECVideoControlDelegate videoControl;
                if (isWrapperViewVisible && goodCardView != null && (videoControl = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getVideoControl()) != null) {
                    videoControl.sendVideoInfoViewShowEvent(ECGoodsVideoFeedsViewModel.this.getContentInfo().getContentId(), true, false);
                }
                if (!ECGoodsVideoFeedsViewModel.this.N().isEmpty()) {
                    ECGoodsVideoFeedsViewModel eCGoodsVideoFeedsViewModel = ECGoodsVideoFeedsViewModel.this;
                    eCGoodsVideoFeedsViewModel.c0(eCGoodsVideoFeedsViewModel.N().get(0));
                    PlayInfo currentPlayInfo = ECGoodsVideoFeedsViewModel.this.getCurrentPlayInfo();
                    if (currentPlayInfo != null && currentPlayInfo.getPlayPlan().getPlayType() == 3 && ECGoodsVideoFeedsViewModel.this.N().size() >= 2) {
                        ECGoodsVideoFeedsViewModel eCGoodsVideoFeedsViewModel2 = ECGoodsVideoFeedsViewModel.this;
                        eCGoodsVideoFeedsViewModel2.c0(eCGoodsVideoFeedsViewModel2.N().get(1));
                    }
                }
                ECGoodsVideoFeedsViewModel.this.f0(-1);
                ECGoodsVideoFeedsViewModel eCGoodsVideoFeedsViewModel3 = ECGoodsVideoFeedsViewModel.this;
                eCGoodsVideoFeedsViewModel3.v0(eCGoodsVideoFeedsViewModel3.N());
            }
        });
    }

    @Override // com.tencent.ecommerce.biz.consumer.model.ECGoodsBaseViewModel, com.tencent.ecommerce.biz.consumer.event.IECEvent
    public void sendEvent(final lh0.a event) {
        ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.consumer.model.ECGoodsVideoFeedsViewModel$sendEvent$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ECGoodsVideoFeedsViewModel.this.t0(event);
            }
        });
    }

    @Override // com.tencent.ecommerce.biz.consumer.model.ECGoodsBaseViewModel, com.tencent.ecommerce.biz.consumer.ui.api.IECGoodsViewModel
    public void setTopWrapperView(ViewGroup viewGroup) {
        super.setTopWrapperView(viewGroup);
        q0();
        a.b(getTAG(), getPRE_LOG() + "setTopWrapperView called, viewGroup:" + viewGroup);
    }

    @Override // com.tencent.ecommerce.biz.consumer.model.ECGoodsBaseViewModel
    public int w() {
        PlayUI ui5;
        PlayInfo currentPlayInfo = getCurrentPlayInfo();
        if (currentPlayInfo == null || (ui5 = currentPlayInfo.getUi()) == null) {
            return -1;
        }
        return ui5.getUiType();
    }

    private final void y0(PlayInfo playInfo) {
        PlayUI ui5;
        PlayUI ui6;
        PlayUI ui7;
        j0(true);
        if (Intrinsics.areEqual(getCurrentPlayInfo(), playInfo)) {
            return;
        }
        PlayInfo currentPlayInfo = getCurrentPlayInfo();
        c0(playInfo);
        Integer num = null;
        Integer valueOf = (currentPlayInfo == null || (ui7 = currentPlayInfo.getUi()) == null) ? null : Integer.valueOf(ui7.getUiType());
        PlayInfo currentPlayInfo2 = getCurrentPlayInfo();
        boolean areEqual = Intrinsics.areEqual(valueOf, (currentPlayInfo2 == null || (ui6 = currentPlayInfo2.getUi()) == null) ? null : Integer.valueOf(ui6.getUiType()));
        if (currentPlayInfo != null && !areEqual) {
            Y(currentPlayInfo.getUi().getUiType());
        }
        int uiType = playInfo.getUi().getUiType();
        s(r(playInfo.getUi().getUiType()));
        ViewGroup wrapperView = getWrapperView();
        if (wrapperView != null) {
            setWrapperView(wrapperView, getBigWrapperView());
        }
        w0(playInfo.getUi());
        String tag = getTAG();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(getPRE_LOG());
        sb5.append("showUIByPlayInfo current ui type:");
        sb5.append(uiType);
        sb5.append(" last ui type :");
        if (currentPlayInfo != null && (ui5 = currentPlayInfo.getUi()) != null) {
            num = Integer.valueOf(ui5.getUiType());
        }
        sb5.append(num);
        sb5.append(TokenParser.SP);
        sb5.append("size:");
        sb5.append(H().size());
        a.b(tag, sb5.toString());
        D(w()).updateUIByType(uiType);
        if (!getIsWrapperViewVisible() || areEqual) {
            return;
        }
        W(uiType);
    }

    private final void s0(Advertisement advertisement) {
        String str;
        String str2;
        String str3;
        String str4;
        ExtendInfo ext;
        Map<String, String> ext2 = (advertisement == null || (ext = advertisement.getExt()) == null) ? null : ext.getExt();
        Iterator<PlayInfo> it = advertisement.getVideoAd().getPlayInfos().iterator();
        while (it.hasNext()) {
            GameDownLoadInfo download = M(it.next().getUi()).getGameInfo().getDownload();
            String str5 = "";
            if (ext2 == null || (str = ext2.get("channel_id")) == null) {
                str = "";
            }
            download.setChannelId(str);
            if (ext2 == null || (str2 = ext2.get("spark_task_key")) == null) {
                str2 = "";
            }
            download.setTaskKey(str2);
            if (ext2 == null || (str3 = ext2.get("spark_task_id")) == null) {
                str3 = "";
            }
            download.setTaskId(str3);
            if (ext2 != null && (str4 = ext2.get("iconUrl")) != null) {
                str5 = str4;
            }
            download.setIconUrl(str5);
            download.setContentId(getContentInfo().getContentId());
        }
    }

    @Override // com.tencent.ecommerce.biz.consumer.model.ECGoodsBaseViewModel
    public void T() {
    }
}

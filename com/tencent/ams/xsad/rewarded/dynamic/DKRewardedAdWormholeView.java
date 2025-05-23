package com.tencent.ams.xsad.rewarded.dynamic;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.core.wormhole.DKWormholeEngine;
import com.tencent.ams.dsdk.core.wormhole.DKWormholeManager;
import com.tencent.ams.dsdk.core.wormhole.DKWormholeView;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.ams.dsdk.utils.DynamicUtils;
import com.tencent.ams.xsad.rewarded.RewardedAd;
import com.tencent.ams.xsad.rewarded.RewardedAdData;
import com.tencent.ams.xsad.rewarded.RewardedAdListener;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.ams.xsad.rewarded.dynamic.method.RewardAdMethodHandler;
import com.tencent.ams.xsad.rewarded.dynamic.method.VideoPlayerMethodHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DKRewardedAdWormholeView extends DKWormholeView {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final RewardedAd.c f71779d;

    /* renamed from: e, reason: collision with root package name */
    private final AdCommonMethodHandler f71780e;

    /* renamed from: f, reason: collision with root package name */
    private final RewardAdMethodHandler f71781f;

    /* renamed from: h, reason: collision with root package name */
    private final VideoPlayerMethodHandler f71782h;

    /* renamed from: i, reason: collision with root package name */
    private final DKWormholeEngine f71783i;

    /* renamed from: m, reason: collision with root package name */
    private DKEngine.BackPressHandler f71784m;

    public DKRewardedAdWormholeView(@NonNull Context context) {
        this(context, DKEngine.DKModuleID.REWARD_WORMHOLE, "2");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void registerHandler() {
        DKWormholeEngine dKWormholeEngine = this.f71783i;
        if (dKWormholeEngine != null) {
            dKWormholeEngine.registerMethodHandler(getWormholeId(), this.f71780e);
            this.f71783i.registerMethodHandler(getWormholeId(), this.f71781f);
            this.f71783i.registerMethodHandler(getWormholeId(), this.f71782h);
        }
    }

    private void unregisterHandler() {
        DKWormholeEngine dKWormholeEngine = this.f71783i;
        if (dKWormholeEngine != null) {
            dKWormholeEngine.unregisterMethodHandler(getWormholeId(), this.f71780e);
            this.f71783i.unregisterMethodHandler(getWormholeId(), this.f71781f);
            this.f71783i.unregisterMethodHandler(getWormholeId(), this.f71782h);
        }
    }

    @Override // com.tencent.ams.dsdk.core.wormhole.DKWormholeView
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            super.destroy();
            unregisterHandler();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.dsdk.core.wormhole.DKWormholeView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            DLog.i("DKRewardedAdWormholeView", NodeProps.ON_ATTACHED_TO_WINDOW);
            super.onAttachedToWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.dsdk.core.wormhole.DKWormholeView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            DLog.i("DKRewardedAdWormholeView", NodeProps.ON_DETACHED_FROM_WINDOW);
            super.onDetachedFromWindow();
        }
    }

    public void setRewardData(RewardedAdData rewardedAdData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rewardedAdData);
            return;
        }
        RewardAdMethodHandler rewardAdMethodHandler = this.f71781f;
        if (rewardAdMethodHandler != null) {
            rewardAdMethodHandler.k(rewardedAdData);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("data", b.a(rewardedAdData));
        DLog.i("DKRewardedAdWormholeView", "setRewardData, data: " + hashMap);
        setData(hashMap);
        registerHandler();
    }

    public void setRewardedAdListener(RewardedAdListener rewardedAdListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) rewardedAdListener);
        } else {
            this.f71779d.b(rewardedAdListener);
        }
    }

    public DKRewardedAdWormholeView(@NonNull Context context, @DKEngine.DKModuleID String str, @DKEngine.DKAdType String str2) {
        super(context, str, str2);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, str, str2);
            return;
        }
        RewardedAd.c cVar = new RewardedAd.c();
        this.f71779d = cVar;
        DKEngine.setPlayerClass(DKRewardedAdVideoPlayer.class);
        AdCommonMethodHandler adCommonMethodHandler = new AdCommonMethodHandler(context, cVar);
        this.f71780e = adCommonMethodHandler;
        adCommonMethodHandler.l(this);
        this.f71781f = new RewardAdMethodHandler(cVar, new RewardAdMethodHandler.b() { // from class: com.tencent.ams.xsad.rewarded.dynamic.DKRewardedAdWormholeView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DKRewardedAdWormholeView.this);
                }
            }

            @Override // com.tencent.ams.xsad.rewarded.dynamic.method.RewardAdMethodHandler.b
            public void a() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    DynamicUtils.runOnUiThread(new Runnable() { // from class: com.tencent.ams.xsad.rewarded.dynamic.DKRewardedAdWormholeView.1.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                DKEngine.BackPressHandler backPressHandler = DKRewardedAdWormholeView.this.f71784m;
                                DKRewardedAdWormholeView.this.f71784m = null;
                                if (backPressHandler != null) {
                                    backPressHandler.onBackPressed();
                                    return;
                                }
                                return;
                            }
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                        }
                    });
                }
            }
        });
        this.f71782h = new VideoPlayerMethodHandler(cVar);
        this.f71783i = DKWormholeManager.getInstance().getEngine(str);
    }
}

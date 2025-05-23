package com.tencent.qqmini.custom;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.server.MiniAppSSOReqCallback;
import com.tencent.mobileqq.mini.server.MiniAppSSORequestClient;
import com.tencent.mobileqq.mini.server.MiniAppSSOResponse;
import com.tencent.mobileqq.mini.server.request.GetPCGuideRequest;
import com.tencent.mobileqq.minigame.manager.GamePCInstructionManager;
import com.tencent.mobileqq.minigame.report.MiniGamePCInstructionReport;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.qqmini.custom.MiniGameQQNavigationBar;
import com.tencent.qqmini.minigame.widget.GameNavigationBar;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.trpcprotocol.minigame.pc_guide.GetPCGuideRsp;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes34.dex */
public class MiniGameQQNavigationBar extends GameNavigationBar {

    /* renamed from: d, reason: collision with root package name */
    private ImageView f346193d;

    /* renamed from: e, reason: collision with root package name */
    private Boolean f346194e;

    public MiniGameQQNavigationBar(Context context) {
        super(context);
        this.f346194e = Boolean.FALSE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(MiniAppSSOResponse miniAppSSOResponse) {
        new JSONObject();
        if (miniAppSSOResponse == null) {
            return;
        }
        try {
            final GetPCGuideRsp getPCGuideRsp = new GetPCGuideRsp();
            getPCGuideRsp.mergeFrom(miniAppSSOResponse.getData());
            if (getPCGuideRsp.show_guide.get()) {
                ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.qqmini.custom.MiniGameQQNavigationBar.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MiniGameQQNavigationBar.this.attachPCInstructionWithBubbleText(getPCGuideRsp.bubble_text.get());
                    }
                }, 5000L);
            }
            QMLog.e("MiniGameQQNavigationBar", "[getGamePCInstructionConfig] retCode: " + miniAppSSOResponse.getRetCode() + ", errMsg: " + miniAppSSOResponse.getErrMsg() + ", showGuide:" + getPCGuideRsp.show_guide.get() + ", text:" + getPCGuideRsp.bubble_text.get());
        } catch (InvalidProtocolBufferMicroException e16) {
            QMLog.e("MiniGameQQNavigationBar", "getGamePCInstructionConfig: parse pb failed:", e16);
        }
    }

    @Override // com.tencent.qqmini.minigame.widget.GameNavigationBar, com.tencent.qqmini.sdk.launcher.ui.BaseGameNavigationBar
    public void attachMiniAppContext(IMiniAppContext iMiniAppContext) {
        super.attachMiniAppContext(iMiniAppContext);
        String str = iMiniAppContext.getMiniAppInfo().appId;
        if (TextUtils.isEmpty(str)) {
            QMLog.e("MiniGameQQNavigationBar", "getGamePCInstructionConfig: illegal params");
        } else {
            MiniAppSSORequestClient.INSTANCE.sendReq(new GetPCGuideRequest(str), new MiniAppSSOReqCallback() { // from class: com.tencent.qqmini.custom.a
                @Override // com.tencent.mobileqq.mini.server.MiniAppSSOReqCallback
                public final void onResponse(MiniAppSSOResponse miniAppSSOResponse) {
                    MiniGameQQNavigationBar.this.g(miniAppSSOResponse);
                }
            });
        }
    }

    public void attachPCInstructionWithBubbleText(String str) {
        IMiniAppContext iMiniAppContext;
        Activity attachActivity;
        if (this.mContainer == null || (iMiniAppContext = this.mMiniAppContext) == null || (attachActivity = iMiniAppContext.getAttachActivity()) == null || attachActivity.isFinishing() || attachActivity.isDestroyed()) {
            return;
        }
        ImageView imageView = new ImageView(attachActivity);
        this.f346193d = imageView;
        imageView.setId(R.id.ri5);
        RedDotTextView redDotTextView = new RedDotTextView(attachActivity);
        redDotTextView.c(true);
        if (this.mBarTextStyle == -1) {
            this.f346193d.setImageResource(R.drawable.iqt);
        } else {
            this.f346193d.setImageResource(R.drawable.iqs);
        }
        this.f346193d.setOnClickListener(new a(redDotTextView));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(getContext(), 44.0f), DisplayUtil.dip2px(getContext(), 30.0f));
        int i3 = com.tencent.qqmini.minigame.R.id.container_top_btns;
        layoutParams.addRule(6, i3);
        layoutParams.addRule(0, i3);
        layoutParams.rightMargin = DisplayUtil.dip2px(getContext(), 5.0f);
        this.mContainer.addView(this.f346193d, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(DisplayUtil.dip2px(attachActivity, 9.0f), DisplayUtil.dip2px(getContext(), 9.0f));
        layoutParams2.addRule(6, R.id.ri5);
        layoutParams2.addRule(7, R.id.ri5);
        layoutParams2.rightMargin = DisplayUtil.dip2px(attachActivity, 5.5f);
        layoutParams2.topMargin = DisplayUtil.dip2px(attachActivity, -1.5f);
        this.mContainer.addView(redDotTextView, layoutParams2);
        if (!TextUtils.isEmpty(str)) {
            final com.tencent.mobileqq.widget.tip.a T = com.tencent.mobileqq.widget.tip.a.r(getContext()).S(this.f346193d).k0(1).R(0).o0(str).f0(false).j0(10.0f, 8.0f, 10.0f, 8.0f).X(attachActivity.getDrawable(com.tencent.qqmini.minigame.R.drawable.mini_sdk_guide_bubble_rectangle_dark)).T(attachActivity.getDrawable(com.tencent.qqmini.minigame.R.drawable.mini_sdk_guide_bubble_triangle_up_dark));
            T.s0();
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.qqmini.custom.MiniGameQQNavigationBar.3
                @Override // java.lang.Runnable
                public void run() {
                    T.o();
                }
            }, 5000L);
        }
        MiniAppInfo miniAppInfo = this.mMiniAppContext.getMiniAppInfo();
        if (miniAppInfo == null) {
            return;
        }
        MiniGamePCInstructionReport.reportPCInstructionBtnShow(miniAppInfo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes34.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RedDotTextView f346197d;

        a(RedDotTextView redDotTextView) {
            this.f346197d = redDotTextView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f346197d.c(false);
            if (((GameNavigationBar) MiniGameQQNavigationBar.this).mMiniAppContext == null) {
                return;
            }
            final Activity attachActivity = ((GameNavigationBar) MiniGameQQNavigationBar.this).mMiniAppContext.getAttachActivity();
            final MiniAppInfo miniAppInfo = ((GameNavigationBar) MiniGameQQNavigationBar.this).mMiniAppContext.getMiniAppInfo();
            if (attachActivity == null || miniAppInfo == null) {
                return;
            }
            GamePCInstructionManager.showPCInstructionDialog(attachActivity, miniAppInfo, MiniGameQQNavigationBar.this.f346194e, Boolean.FALSE, new DialogInterface.OnClickListener() { // from class: com.tencent.qqmini.custom.b
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    MiniGameQQNavigationBar.a.this.d(attachActivity, miniAppInfo, dialogInterface, i3);
                }
            });
            MiniGamePCInstructionReport.reportPCInstructionBtnClick(miniAppInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(boolean z16, JSONObject jSONObject) {
            if (z16) {
                MiniGameQQNavigationBar.this.f346194e = Boolean.TRUE;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(Activity activity, MiniAppInfo miniAppInfo, DialogInterface dialogInterface, int i3) {
            if (i3 != 1 || MiniGameQQNavigationBar.this.f346194e.booleanValue()) {
                return;
            }
            GamePCInstructionManager.handlePCInstructionConfirm(activity, miniAppInfo, null, null, Boolean.FALSE, new AsyncResult() { // from class: com.tencent.qqmini.custom.c
                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                public final void onReceiveResult(boolean z16, JSONObject jSONObject) {
                    MiniGameQQNavigationBar.a.this.c(z16, jSONObject);
                }
            });
        }
    }

    public MiniGameQQNavigationBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f346194e = Boolean.FALSE;
    }

    public MiniGameQQNavigationBar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f346194e = Boolean.FALSE;
    }
}

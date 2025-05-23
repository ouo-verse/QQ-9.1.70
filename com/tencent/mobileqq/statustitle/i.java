package com.tencent.mobileqq.statustitle;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ConversationTitleBtnCtrl;
import com.tencent.mobileqq.activity.recent.l;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.observer.RedpointObserver;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginStatus;
import com.tencent.mobileqq.util.cn;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.util.TokenResUtils;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 22\u00020\u0001:\u0003\u0017\r\u0006B\u0017\u0012\u0006\u0010\u001d\u001a\u00020\u0016\u0012\u0006\u0010/\u001a\u00020(\u00a2\u0006\u0004\b0\u00101J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eJ\u0016\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u000eJ\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011R\"\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001fR\u0018\u0010#\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010%R(\u0010.\u001a\b\u0012\u0004\u0012\u00020(0'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/statustitle/i;", "", "Landroid/view/View;", "view", "", "e", "c", "g", "", "color", "l", "d", "j", "b", "", "needUpdate", "i", "Lcom/tencent/common/app/AppInterface;", "appInterface", QAdLoginDefine$LoginStatus.IS_LOGIN, tl.h.F, "k", "Landroid/widget/ImageView;", "a", "Landroid/widget/ImageView;", "getOpenSession", "()Landroid/widget/ImageView;", "setOpenSession", "(Landroid/widget/ImageView;)V", "openSession", "Lcom/tencent/mobileqq/tianshu/ui/RedTouch;", "Lcom/tencent/mobileqq/tianshu/ui/RedTouch;", "openSessionRedTouch", "Lcom/tencent/mobileqq/activity/recent/l;", "Lcom/tencent/mobileqq/activity/recent/l;", "recentOptionBar", "Lcom/tencent/mobileqq/statustitle/i$c;", "Lcom/tencent/mobileqq/statustitle/i$c;", "redPointObserver", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/statustitle/i$b;", "Ljava/lang/ref/WeakReference;", "getIOpenSessionCallbackRef", "()Ljava/lang/ref/WeakReference;", "setIOpenSessionCallbackRef", "(Ljava/lang/ref/WeakReference;)V", "iOpenSessionCallbackRef", "iOpenSessionCallback", "<init>", "(Landroid/widget/ImageView;Lcom/tencent/mobileqq/statustitle/i$b;)V", "f", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private ImageView openSession;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private RedTouch openSessionRedTouch;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private l recentOptionBar;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private c redPointObserver;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private WeakReference<b> iOpenSessionCallbackRef;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/statustitle/i$b;", "", "", "a", "Landroid/widget/RelativeLayout;", "b", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public interface b {
        boolean a();

        RelativeLayout b();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/statustitle/i$c;", "Lcom/tencent/mobileqq/tianshu/observer/RedpointObserver;", "", "isSucc", "", "onDataChange", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/statustitle/i;", "d", "Ljava/lang/ref/WeakReference;", "ref", "assistant", "<init>", "(Lcom/tencent/mobileqq/statustitle/i;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c extends RedpointObserver {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<i> ref;

        public c(i assistant) {
            Intrinsics.checkNotNullParameter(assistant, "assistant");
            this.ref = new WeakReference<>(assistant);
        }

        @Override // com.tencent.mobileqq.tianshu.observer.RedpointObserver
        public void onDataChange(boolean isSucc) {
            if (QLog.isColorLevel()) {
                QLog.d("OpenSessionAssistant", 2, "RedPointObserverImpl notify dataChanged");
            }
            i iVar = this.ref.get();
            if (iVar != null) {
                iVar.d();
            }
        }
    }

    public i(ImageView openSession, b iOpenSessionCallback) {
        Intrinsics.checkNotNullParameter(openSession, "openSession");
        Intrinsics.checkNotNullParameter(iOpenSessionCallback, "iOpenSessionCallback");
        this.openSession = openSession;
        this.iOpenSessionCallbackRef = new WeakReference<>(iOpenSessionCallback);
        ImageView imageView = this.openSession;
        imageView.setImageDrawable(cn.f(imageView.getResources().getDrawable(TokenResUtils.getTokenRes(R.drawable.header_btn_add, R.drawable.qui_add_icon_navigation_01_selector))));
        this.openSessionRedTouch = new RedTouch(imageView.getContext(), imageView).setGravity(53).applyTo();
        IphoneTitleBarActivity.setLayerType(imageView);
        Context context = imageView.getContext();
        BaseActivity baseActivity = context instanceof BaseActivity ? (BaseActivity) context : null;
        if (baseActivity != null) {
            this.recentOptionBar = new l(baseActivity);
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.statustitle.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i.f(i.this, view);
            }
        });
        this.redPointObserver = new c(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(i this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.e(it);
    }

    public final void b() {
        l lVar = this.recentOptionBar;
        if (lVar == null || !lVar.isShowing()) {
            return;
        }
        lVar.h();
    }

    public final void c() {
        int dimension = (int) this.openSession.getResources().getDimension(R.dimen.title_bar_height);
        ConversationTitleBtnCtrl.c(this.openSessionRedTouch, dimension);
        ConversationTitleBtnCtrl.c(this.openSession, dimension);
    }

    public final void d() {
        l lVar;
        RedTouch redTouch = this.openSessionRedTouch;
        if (redTouch == null || (lVar = this.recentOptionBar) == null) {
            return;
        }
        boolean D = lVar.D();
        QLog.i("OpenSessionAssistant", 1, "handleMessageForUpdatePlusRedTouch:: needsExposeRedTouchUpward = " + D);
        if (D) {
            BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
            redTypeInfo.red_type.set(0);
            redTouch.parseRedTouch(redTypeInfo);
            return;
        }
        redTouch.clearRedTouch();
    }

    public final void g() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            ImageView imageView = this.openSession;
            com.tencent.mobileqq.statustitle.c cVar = com.tencent.mobileqq.statustitle.c.f290185a;
            int a16 = cVar.a(peekAppRuntime);
            Resources resources = imageView.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "view.resources");
            int b16 = cVar.b(resources);
            imageView.setAlpha(a16);
            if (ThemeUtil.isNowThemeIsSuperTheme()) {
                imageView.setColorFilter((ColorFilter) null);
            } else {
                imageView.setColorFilter(b16);
            }
        }
    }

    public final void h(AppInterface appInterface, boolean isLogin) {
        Intrinsics.checkNotNullParameter(appInterface, "appInterface");
        if (isLogin) {
            appInterface.addObserver(this.redPointObserver);
        }
    }

    public final void i(boolean needUpdate) {
        l lVar = this.recentOptionBar;
        if (lVar == null) {
            return;
        }
        lVar.G = needUpdate;
    }

    public final void j() {
        l lVar = this.recentOptionBar;
        if (lVar != null) {
            lVar.E();
        }
    }

    public final void k(AppInterface appInterface) {
        Intrinsics.checkNotNullParameter(appInterface, "appInterface");
        appInterface.removeObserver(this.redPointObserver);
    }

    public final void l(int color) {
        this.openSession.setColorFilter(color);
    }

    private final void e(View view) {
        b bVar;
        RelativeLayout b16;
        Context context = view.getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null) {
            return;
        }
        b bVar2 = this.iOpenSessionCallbackRef.get();
        if (!(bVar2 != null && bVar2.a()) && !activity.isFinishing()) {
            l lVar = this.recentOptionBar;
            if (lVar != null && (bVar = this.iOpenSessionCallbackRef.get()) != null && (b16 = bVar.b()) != null) {
                Resources resources = activity.getResources();
                lVar.L(2);
                lVar.M(b16, (b16.getWidth() - resources.getDimensionPixelSize(R.dimen.au6)) - resources.getDimensionPixelSize(R.dimen.au7), resources.getDimensionPixelSize(R.dimen.au8));
            }
            VideoReport.setElementId(view, "em_sgrp_plus_btn");
            VideoReport.reportEvent("clck", view, null);
            ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "CliOper", "", "", "0X8004073", "0X8004073", 0, 0, "", "", "", "");
            id0.a.n("plus_shoot", "exp_entry", 0, 0, "", "", "", "");
            RedTouch redTouch = this.openSessionRedTouch;
            if (redTouch != null) {
                redTouch.clearRedTouch();
                return;
            }
            return;
        }
        QLog.i("BaseStatusTitlePart", 1, "handleOpenSessionClick is destroy | finishing");
    }
}

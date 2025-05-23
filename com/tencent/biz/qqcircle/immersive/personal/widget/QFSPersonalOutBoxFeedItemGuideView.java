package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import androidx.annotation.NonNull;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.biz.qqcircle.immersive.utils.QFSPersonalDraftUtil;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.mobileqq.winkpublish.model.DraftBean;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.libpag.PAGFile;
import org.libpag.PAGText;

/* loaded from: classes4.dex */
public class QFSPersonalOutBoxFeedItemGuideView extends QFSPersonalOutBoxFeedItemBaseView implements View.OnClickListener {
    private ViewSwitcher C;
    private TextView D;
    private FlipperRunnable E;
    private int F;
    private String G;
    private boolean H;
    private boolean I;

    /* renamed from: i, reason: collision with root package name */
    private final Map<String, Drawable> f89302i;

    /* renamed from: m, reason: collision with root package name */
    private final Map<String, PAGFile> f89303m;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class DownloadPicListener extends QCirclePicStateListener {

        /* renamed from: d, reason: collision with root package name */
        private String f89304d;

        DownloadPicListener() {
        }

        protected void a(Drawable drawable) {
            throw null;
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            QLog.d("QFSPersonalOutBoxFeedItemGuideView", 1, "onStateChange, mIconUrl: " + this.f89304d + ", state: " + loadState);
            if (loadState == LoadState.STATE_SUCCESS) {
                final BitmapDrawable bitmapDrawable = new BitmapDrawable(option.getResultBitMap());
                RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalOutBoxFeedItemGuideView.DownloadPicListener.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DownloadPicListener.this.a(bitmapDrawable);
                    }
                });
            }
        }

        DownloadPicListener(String str) {
            this.f89304d = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class FlipperRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<QFSPersonalOutBoxFeedItemGuideView> f89306d;

        public FlipperRunnable(QFSPersonalOutBoxFeedItemGuideView qFSPersonalOutBoxFeedItemGuideView) {
            this.f89306d = new WeakReference<>(qFSPersonalOutBoxFeedItemGuideView);
        }

        @Override // java.lang.Runnable
        public void run() {
            QFSPersonalOutBoxFeedItemGuideView qFSPersonalOutBoxFeedItemGuideView = this.f89306d.get();
            if (qFSPersonalOutBoxFeedItemGuideView != null && qFSPersonalOutBoxFeedItemGuideView.I0()) {
                qFSPersonalOutBoxFeedItemGuideView.A0(true);
                RFWThreadManager.getUIHandler().postDelayed(this, 4000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements ViewSwitcher.ViewFactory {
        a() {
        }

        @Override // android.widget.ViewSwitcher.ViewFactory
        public View makeView() {
            QFSPersonalOutBoxFeedItemGuideSwitchView qFSPersonalOutBoxFeedItemGuideSwitchView = new QFSPersonalOutBoxFeedItemGuideSwitchView(QFSPersonalOutBoxFeedItemGuideView.this.getContext());
            qFSPersonalOutBoxFeedItemGuideSwitchView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            qFSPersonalOutBoxFeedItemGuideSwitchView.setOnClickListener(QFSPersonalOutBoxFeedItemGuideView.this);
            QFSPersonalOutBoxFeedItemGuideView.this.D0(qFSPersonalOutBoxFeedItemGuideSwitchView.f89300e);
            return qFSPersonalOutBoxFeedItemGuideSwitchView;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b extends DownloadPicListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f89308e;

        b(boolean z16) {
            this.f89308e = z16;
        }

        @Override // com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalOutBoxFeedItemGuideView.DownloadPicListener
        protected void a(Drawable drawable) {
            QFSPersonalOutBoxFeedItemGuideView.this.K0(drawable, this.f89308e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c extends DownloadPicListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f89310e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ DownloadPicListener f89311f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(String str, String str2, DownloadPicListener downloadPicListener) {
            super(str);
            this.f89310e = str2;
            this.f89311f = downloadPicListener;
        }

        @Override // com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalOutBoxFeedItemGuideView.DownloadPicListener
        protected void a(Drawable drawable) {
            if (drawable != null) {
                QFSPersonalOutBoxFeedItemGuideView.this.f89302i.put(this.f89310e, drawable);
            }
            DownloadPicListener downloadPicListener = this.f89311f;
            if (downloadPicListener != null) {
                downloadPicListener.a(drawable);
            }
        }
    }

    public QFSPersonalOutBoxFeedItemGuideView(@NonNull Context context) {
        super(context);
        this.f89302i = new HashMap();
        this.f89303m = new HashMap(1);
        this.F = -1;
        this.G = null;
        this.H = true;
        this.I = false;
        initView();
        H0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(boolean z16) {
        int size = this.f89296f.size();
        if (size <= 0) {
            QLog.d("QFSPersonalOutBoxFeedItemGuideView", 1, "changeCover, size less than 0 ");
            return;
        }
        int i3 = this.F + 1;
        this.F = i3;
        int i16 = i3 % size;
        this.F = i16;
        String str = this.f89296f.get(i16);
        this.G = str;
        C0(str, new b(z16));
    }

    private void B0(int i3) {
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(115).setSubActionType(i3));
    }

    private void C0(String str, DownloadPicListener downloadPicListener) {
        if (TextUtils.isEmpty(str)) {
            QLog.w("QFSPersonalOutBoxFeedItemGuideView", 1, "downloadPic, iconUrl is null ");
            return;
        }
        Drawable drawable = this.f89302i.get(str);
        if (drawable != null) {
            if (downloadPicListener != null) {
                downloadPicListener.a(drawable);
            }
        } else {
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(str).setRequestWidth(getMeasuredWidth()).setRequestHeight(getMeasuredHeight()).setPredecode(true), new c(str, str, downloadPicListener));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0(View view) {
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_EDIT_DRAFT_BUTTON);
        VideoReport.setElementParams(view, new QCircleDTParamBuilder().buildElementParams());
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
    }

    private QFSPersonalOutBoxFeedItemGuideSwitchView E0() {
        return (QFSPersonalOutBoxFeedItemGuideSwitchView) this.C.getCurrentView();
    }

    private PAGFile F0() {
        PAGFile pAGFile;
        if (this.f89303m.containsKey("profilepage_draft_btn.pag")) {
            return this.f89303m.get("profilepage_draft_btn.pag");
        }
        try {
            pAGFile = PagViewMonitor.Load(getContext().getAssets(), "pag" + File.separator + "profilepage_draft_btn.pag");
        } catch (Error e16) {
            QLog.e("QFSPersonalOutBoxFeedItemGuideView", 1, "getPagFile, error ", e16);
            pAGFile = null;
        }
        if (pAGFile != null) {
            S0(pAGFile, G0());
            this.f89303m.put("profilepage_draft_btn.pag", pAGFile);
        }
        return pAGFile;
    }

    private String G0() {
        return this.f89294d.k();
    }

    private void H0() {
        this.E = new FlipperRunnable(this);
        B0(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean I0() {
        if (this.f89296f.size() > 1) {
            return true;
        }
        return false;
    }

    private void J0() {
        List<DraftBean> list = this.f89295e;
        if (list != null && !list.isEmpty()) {
            if (this.F > this.f89295e.size()) {
                QLog.d("QFSPersonalOutBoxFeedItemGuideView", 1, "jumpEditPage, mCurrentIndex out of bounds ");
                return;
            } else {
                new QFSPersonalDraftUtil().c(getContext(), this.f89295e.get(this.F), 3);
                return;
            }
        }
        QLog.d("QFSPersonalOutBoxFeedItemGuideView", 1, "jumpEditPage, mDraftList is null or empty ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K0(Drawable drawable, boolean z16) {
        QFSPersonalOutBoxFeedItemGuideSwitchView E0 = E0();
        if (z16) {
            P0(E0);
            QFSPersonalOutBoxFeedItemGuideSwitchView qFSPersonalOutBoxFeedItemGuideSwitchView = (QFSPersonalOutBoxFeedItemGuideSwitchView) this.C.getNextView();
            qFSPersonalOutBoxFeedItemGuideSwitchView.f89299d.setImageDrawable(drawable);
            this.C.showNext();
            N0(qFSPersonalOutBoxFeedItemGuideSwitchView);
            return;
        }
        E0.f89299d.setImageDrawable(drawable);
        N0(E0);
    }

    private void L0() {
        boolean isAttachedToWindow = isAttachedToWindow();
        QLog.d("QFSPersonalOutBoxFeedItemGuideView", 1, "startFlipper, isAttachedToWindow: " + isAttachedToWindow + ", mHasStarted: " + this.I);
        if (isAttachedToWindow && !this.I) {
            this.I = true;
            if (this.H) {
                this.H = false;
                A0(false);
            }
            if (I0()) {
                M0();
            }
            N0(E0());
        }
    }

    private void M0() {
        RFWThreadManager.getUIHandler().removeCallbacks(this.E);
        RFWThreadManager.getUIHandler().postDelayed(this.E, 4000L);
    }

    private void N0(QFSPersonalOutBoxFeedItemGuideSwitchView qFSPersonalOutBoxFeedItemGuideSwitchView) {
        qFSPersonalOutBoxFeedItemGuideSwitchView.f(F0());
    }

    private void O0() {
        QLog.d("QFSPersonalOutBoxFeedItemGuideView", 1, "stopFlipper, mHasStarted: " + this.I);
        if (this.I) {
            RFWThreadManager.getUIHandler().removeCallbacks(this.E);
            P0(E0());
            this.I = false;
        }
    }

    private void P0(QFSPersonalOutBoxFeedItemGuideSwitchView qFSPersonalOutBoxFeedItemGuideSwitchView) {
        qFSPersonalOutBoxFeedItemGuideSwitchView.g();
    }

    private void Q0() {
        if (this.F != -1 && !TextUtils.isEmpty(this.G) && !this.f89296f.isEmpty()) {
            int indexOf = this.f89296f.indexOf(this.G);
            QLog.d("QFSPersonalOutBoxFeedItemGuideView", 1, "updateFlipperIfNeed, index: " + indexOf);
            if (indexOf != -1) {
                this.F = indexOf;
            } else {
                this.F = (this.F % this.f89296f.size()) - 1;
                A0(false);
            }
        }
    }

    private void S0(PAGFile pAGFile, String str) {
        PAGText textData = pAGFile.getTextData(0);
        textData.text = str;
        pAGFile.replaceText(0, textData);
    }

    private void initView() {
        ViewSwitcher viewSwitcher = (ViewSwitcher) findViewById(R.id.f1194476v);
        this.C = viewSwitcher;
        viewSwitcher.setInAnimation(getContext(), R.anim.f154887sx);
        this.C.setOutAnimation(getContext(), R.anim.f154886sw);
        this.C.setFactory(new a());
        this.D = (TextView) findViewById(R.id.f107446af);
    }

    private void z0() {
        this.D.setText(n0());
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.f168621g32;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSPersonalOutBoxFeedItemGuideView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalOutBoxFeedItemBaseView, com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: l0 */
    public void bindData(com.tencent.biz.qqcircle.immersive.personal.bean.k kVar, int i3) {
        super.bindData(kVar, i3);
        if (this.f89294d == null) {
            return;
        }
        z0();
        Q0();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        QLog.d("QFSPersonalOutBoxFeedItemGuideView", 1, "onAttachedToWindow ");
        L0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f219802h) {
            J0();
            B0(2);
        }
        O0();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        QLog.d("QFSPersonalOutBoxFeedItemGuideView", 1, "onDetachedFromWindow ");
        O0();
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalOutBoxFeedItemBaseView
    public void p0() {
        QLog.d("QFSPersonalOutBoxFeedItemGuideView", 1, "onPartResume ");
        L0();
    }

    @Override // com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalOutBoxFeedItemBaseView
    public void q0() {
        QLog.d("QFSPersonalOutBoxFeedItemGuideView", 1, "onPartStop ");
        O0();
    }
}

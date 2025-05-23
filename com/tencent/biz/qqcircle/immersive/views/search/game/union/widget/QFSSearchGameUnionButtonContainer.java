package com.tencent.biz.qqcircle.immersive.views.search.game.union.widget;

import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.utils.h;
import com.tencent.gamecenter.wadl.distribute.api.IQQGameDistributeApi;
import com.tencent.gamecenter.wadl.distribute.data.ButtonDataBuilder;
import com.tencent.gamecenter.wadl.distribute.data.ButtonUiBuilder;
import com.tencent.gamecenter.wadl.distribute.listener.IButtonEventListener;
import com.tencent.gamecenter.wadl.distribute.provider.IBgAndFgColorFetcher;
import com.tencent.gamecenter.wadl.distribute.provider.ITextColorFetcher;
import com.tencent.gamecenter.wadl.distribute.provider.TextContentFetcherAdapter;
import com.tencent.gamecenter.wadl.distribute.widget.IDistributeButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.page.VideoReportPageInfo;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSearchGameUnionButtonContainer extends FrameLayout implements LifecycleObserver {

    /* renamed from: d, reason: collision with root package name */
    private final String f91132d;

    /* renamed from: e, reason: collision with root package name */
    private IDistributeButton f91133e;

    /* renamed from: f, reason: collision with root package name */
    private y80.a f91134f;

    /* renamed from: h, reason: collision with root package name */
    private w80.b f91135h;

    /* renamed from: i, reason: collision with root package name */
    private w80.c f91136i;

    /* renamed from: m, reason: collision with root package name */
    private final d f91137m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends TextContentFetcherAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f91138a;

        a(String str) {
            this.f91138a = str;
        }

        @Override // com.tencent.gamecenter.wadl.distribute.provider.TextContentFetcherAdapter, com.tencent.gamecenter.wadl.distribute.provider.ITextContentFetcher
        @NonNull
        public String fetchInitContent() {
            return this.f91138a;
        }

        @Override // com.tencent.gamecenter.wadl.distribute.provider.TextContentFetcherAdapter, com.tencent.gamecenter.wadl.distribute.provider.ITextContentFetcher
        @NonNull
        public String fetchInstalledContent() {
            return h.a(R.string.f195014dg);
        }

        @Override // com.tencent.gamecenter.wadl.distribute.provider.TextContentFetcherAdapter, com.tencent.gamecenter.wadl.distribute.provider.ITextContentFetcher
        @NonNull
        public String fetchProgressContentWithPlaceHolder() {
            return h.a(R.string.f195114dq);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements ITextColorFetcher {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IDistributeButton f91139a;

        b(IDistributeButton iDistributeButton) {
            this.f91139a = iDistributeButton;
        }

        @Override // com.tencent.gamecenter.wadl.distribute.provider.ITextColorFetcher
        public int fetchDisableTextColor() {
            return QCircleSkinHelper.getInstance().getColor(R.color.cla);
        }

        @Override // com.tencent.gamecenter.wadl.distribute.provider.ITextColorFetcher
        public int fetchEnableTextColor() {
            int downloadTaskStatus = this.f91139a.getButtonStatus().getDownloadTaskStatus();
            if (downloadTaskStatus != 4 && downloadTaskStatus != 2) {
                return QCircleSkinHelper.getInstance().getColor(R.color.qui_button_text_primary_default);
            }
            return QCircleSkinHelper.getInstance().getColor(R.color.qui_common_text_primary);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements IBgAndFgColorFetcher {
        c() {
        }

        @Override // com.tencent.gamecenter.wadl.distribute.provider.IBgAndFgColorFetcher
        public int fetchDisableBgColor() {
            return Color.parseColor("#C3F1FF");
        }

        @Override // com.tencent.gamecenter.wadl.distribute.provider.IBgAndFgColorFetcher
        public int fetchEnableBgColor() {
            return QCircleSkinHelper.getInstance().getColor(R.color.qui_button_bg_primary_default);
        }

        @Override // com.tencent.gamecenter.wadl.distribute.provider.IBgAndFgColorFetcher
        public int fetchProgressBgColor() {
            return QCircleSkinHelper.getInstance().getColor(R.color.qui_button_bg_primary_disable);
        }

        @Override // com.tencent.gamecenter.wadl.distribute.provider.IBgAndFgColorFetcher
        public int fetchProgressFgColor() {
            return QCircleSkinHelper.getInstance().getColor(R.color.qui_button_bg_primary_pressed);
        }
    }

    public QFSSearchGameUnionButtonContainer(@NonNull Context context) {
        super(context);
        this.f91132d = h.a(R.string.f183703jw);
        this.f91137m = new d();
        k();
    }

    private static IBgAndFgColorFetcher f() {
        return new c();
    }

    private ButtonDataBuilder g(w80.c cVar) {
        return new ButtonDataBuilder().setAppId(this.f91135h.f444956a).setApkChannel(this.f91135h.f444957b).setPkgName(this.f91135h.f444958c).setAppName(this.f91135h.f444959d).setApkUrl(this.f91135h.f444961f).setIconUrl(this.f91135h.f444960e).setPkgSizeStr(this.f91135h.f444962g).setBusinessChannel(cVar.f444971i).setSubscribeSource("1").setReportData(this.f91134f.c());
    }

    private static ITextColorFetcher h(IDistributeButton iDistributeButton) {
        return new b(iDistributeButton);
    }

    private static TextContentFetcherAdapter i(String str) {
        return new a(str);
    }

    private ButtonUiBuilder j() {
        return new ButtonUiBuilder().setUiStyle(0).setBgCorner(cx.a(4.0f)).setTextSize(cx.a(14.0f)).setCustomTextContentFetcher(i(this.f91132d)).setCustomTextColorFetcher(h(this.f91133e)).setCustomBgAndFgColorFetcher(f());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void k() {
        IDistributeButton createButton = ((IQQGameDistributeApi) QRoute.api(IQQGameDistributeApi.class)).createButton(getContext());
        this.f91133e = createButton;
        if (createButton instanceof View) {
            addView((View) createButton, new FrameLayout.LayoutParams(-1, -1));
        }
        this.f91133e.getTipsView().addTextChangedListener(this.f91137m);
    }

    public void e(w80.c cVar, y80.a aVar) {
        this.f91134f = aVar;
        this.f91135h = cVar.f444970h;
        this.f91136i = cVar;
        this.f91133e.setDataBuilder(g(cVar));
        this.f91133e.setUiBuilder(j());
        this.f91133e.update();
        this.f91133e.addEventListener(this.f91137m);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Object context = getContext();
        if (context instanceof LifecycleOwner) {
            ((LifecycleOwner) context).getLifecycle().addObserver(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Object context = getContext();
        if (context instanceof LifecycleOwner) {
            ((LifecycleOwner) context).getLifecycle().removeObserver(this);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        this.f91137m.c();
    }

    public QFSSearchGameUnionButtonContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f91132d = h.a(R.string.f183703jw);
        this.f91137m = new d();
        k();
    }

    public QFSSearchGameUnionButtonContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f91132d = h.a(R.string.f183703jw);
        this.f91137m = new d();
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class d implements IButtonEventListener, TextWatcher {

        /* renamed from: d, reason: collision with root package name */
        private String f91140d;

        d() {
        }

        private Map<String, String> a() {
            HashMap hashMap = new HashMap();
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, QFSSearchGameUnionButtonContainer.this.f91136i.f444964b.f444981f);
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_GAME_INSTALL_STATUS, QFSSearchGameUnionButtonContainer.this.f91133e.getTipsView().getText().toString());
            hashMap.put("eid", QFSSearchGameUnionButtonContainer.this.f91134f.g());
            hashMap.put("xsj_eid", QFSSearchGameUnionButtonContainer.this.f91134f.g());
            hashMap.put("xsj_custom_pgid", QFSSearchGameUnionButtonContainer.this.f91134f.getPageId());
            VideoReportPageInfo pageInfo = VideoReport.getPageInfo();
            if (pageInfo != null) {
                hashMap.put("dt_ref_pgid", pageInfo.pageId);
            }
            return hashMap;
        }

        private void b() {
            VideoReport.reportEvent("ev_xsj_abnormal_clck", a());
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String obj = editable.toString();
            if (TextUtils.equals(this.f91140d, obj)) {
                return;
            }
            this.f91140d = obj;
            c();
        }

        void c() {
            String charSequence = QFSSearchGameUnionButtonContainer.this.f91133e.getTipsView().getText().toString();
            if (!TextUtils.isEmpty(charSequence) && !TextUtils.equals(QFSSearchGameUnionButtonContainer.this.f91132d, charSequence)) {
                VideoReport.reportEvent("ev_xsj_abnormal_imp", a());
            }
        }

        @Override // com.tencent.gamecenter.wadl.distribute.listener.IButtonEventListener
        public void onClick(@NonNull View view) {
            if (QFSSearchGameUnionButtonContainer.this.f91133e.getButtonStatus().getSubscribeStatus() == 2) {
                return;
            }
            b();
        }

        @Override // com.tencent.gamecenter.wadl.distribute.listener.IButtonEventListener
        public void onDownloadTaskStatusChange(@NonNull String str, float f16, int i3) {
        }

        @Override // com.tencent.gamecenter.wadl.distribute.listener.IButtonEventListener
        public void onFollowOrSubscribeStatusChange(@NonNull String str, int i3, int i16) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}

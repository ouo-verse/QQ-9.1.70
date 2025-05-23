package com.tencent.mobileqq.qqecommerce.biz.game;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
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
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.page.VideoReportPageInfo;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ECGameUnionButtonContainer extends FrameLayout implements LifecycleObserver {

    /* renamed from: d, reason: collision with root package name */
    private IDistributeButton f262532d;

    /* renamed from: e, reason: collision with root package name */
    private final d f262533e;

    /* renamed from: f, reason: collision with root package name */
    private kf2.b f262534f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class a extends TextContentFetcherAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f262535a;

        a(String str) {
            this.f262535a = str;
        }

        @Override // com.tencent.gamecenter.wadl.distribute.provider.TextContentFetcherAdapter, com.tencent.gamecenter.wadl.distribute.provider.ITextContentFetcher
        public String fetchInitContent() {
            return this.f262535a;
        }

        @Override // com.tencent.gamecenter.wadl.distribute.provider.TextContentFetcherAdapter, com.tencent.gamecenter.wadl.distribute.provider.ITextContentFetcher
        public String fetchInstalledContent() {
            return "\u8fdb\u5165";
        }

        @Override // com.tencent.gamecenter.wadl.distribute.provider.TextContentFetcherAdapter, com.tencent.gamecenter.wadl.distribute.provider.ITextContentFetcher
        public String fetchProgressContentWithPlaceHolder() {
            return "\u6682\u505c";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class b implements ITextColorFetcher {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IDistributeButton f262536a;

        b(IDistributeButton iDistributeButton) {
            this.f262536a = iDistributeButton;
        }

        @Override // com.tencent.gamecenter.wadl.distribute.provider.ITextColorFetcher
        public int fetchDisableTextColor() {
            return -1;
        }

        @Override // com.tencent.gamecenter.wadl.distribute.provider.ITextColorFetcher
        public int fetchEnableTextColor() {
            int downloadTaskStatus = this.f262536a.getButtonStatus().getDownloadTaskStatus();
            if (downloadTaskStatus == 4 || downloadTaskStatus == 2) {
                return ECGameUnionButtonContainer.this.getContext().getColor(R.color.qui_common_text_primary);
            }
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class c implements IBgAndFgColorFetcher {
        c() {
        }

        @Override // com.tencent.gamecenter.wadl.distribute.provider.IBgAndFgColorFetcher
        public int fetchDisableBgColor() {
            return ECGameUnionButtonContainer.this.getContext().getColor(R.color.qui_button_bg_primary_disable);
        }

        @Override // com.tencent.gamecenter.wadl.distribute.provider.IBgAndFgColorFetcher
        public int fetchEnableBgColor() {
            return ECGameUnionButtonContainer.this.getContext().getColor(R.color.qui_button_bg_primary_default);
        }

        @Override // com.tencent.gamecenter.wadl.distribute.provider.IBgAndFgColorFetcher
        public int fetchProgressBgColor() {
            return ECGameUnionButtonContainer.this.getContext().getColor(R.color.qui_button_bg_primary_disable);
        }

        @Override // com.tencent.gamecenter.wadl.distribute.provider.IBgAndFgColorFetcher
        public int fetchProgressFgColor() {
            return ECGameUnionButtonContainer.this.getContext().getColor(R.color.qui_button_bg_primary_pressed);
        }
    }

    public ECGameUnionButtonContainer(Context context) {
        super(context);
        this.f262533e = new d();
        i();
    }

    private IBgAndFgColorFetcher d() {
        return new c();
    }

    private ButtonDataBuilder e(kf2.b bVar) {
        return new ButtonDataBuilder().setAppId(bVar.getAppId()).setApkChannel(bVar.getChannelId()).setPkgName(bVar.getCom.vivo.push.PushClientConstants.TAG_PKG_NAME java.lang.String()).setAppName(bVar.getName()).setApkUrl(bVar.getUrl()).setIconUrl(bVar.getIcon()).setPkgSizeStr(bVar.getAppSize()).setBusinessChannel(5).setSubscribeSource("1").setReportData("{\"ext_module\":\"92201\",\"ext_sub_module\":\"92201\"}");
    }

    private ITextColorFetcher f(IDistributeButton iDistributeButton) {
        return new b(iDistributeButton);
    }

    private static TextContentFetcherAdapter g(String str) {
        return new a(str);
    }

    private ButtonUiBuilder h() {
        return new ButtonUiBuilder().setUiStyle(0).setBgCorner(ViewUtils.dip2px(4.0f)).setTextSize(ViewUtils.dip2px(14.0f)).setCustomTextContentFetcher(g("\u52a0\u8f7d\u4e2d")).setCustomTextColorFetcher(f(this.f262532d)).setCustomBgAndFgColorFetcher(d());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void i() {
        IDistributeButton createButton = ((IQQGameDistributeApi) QRoute.api(IQQGameDistributeApi.class)).createButton(getContext());
        this.f262532d = createButton;
        if (createButton instanceof View) {
            addView((View) createButton, new FrameLayout.LayoutParams(-1, -1));
        }
        this.f262532d.getTipsView().addTextChangedListener(this.f262533e);
    }

    public void c(kf2.b bVar) {
        this.f262534f = bVar;
        this.f262532d.setDataBuilder(e(bVar));
        this.f262532d.setUiBuilder(h());
        this.f262532d.update();
        this.f262532d.addEventListener(this.f262533e);
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
        this.f262533e.c();
    }

    public ECGameUnionButtonContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f262533e = new d();
        i();
    }

    public ECGameUnionButtonContainer(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f262533e = new d();
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class d implements IButtonEventListener, TextWatcher {

        /* renamed from: d, reason: collision with root package name */
        private String f262539d;

        d() {
        }

        private Map<String, String> a() {
            if (ECGameUnionButtonContainer.this.f262534f.getReportInfo() == null) {
                return new HashMap();
            }
            HashMap hashMap = new HashMap();
            hashMap.put("eid", "em_bas_search_header_button");
            hashMap.put("qq_eid", "em_bas_search_header_button");
            hashMap.put("qq_pgid", "pg_qq_network_search_result_level2_page");
            hashMap.put(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, ECGameUnionButtonContainer.this.f262532d.getTipsView().getText().toString());
            hashMap.putAll(ECGameUnionButtonContainer.this.f262534f.getReportInfo().a());
            VideoReportPageInfo pageInfo = VideoReport.getPageInfo();
            if (pageInfo != null) {
                hashMap.put("dt_ref_pgid", pageInfo.pageId);
            }
            return hashMap;
        }

        private void b() {
            VideoReport.reportEvent("ev_bas_game_card_button_clck", a());
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String obj = editable.toString();
            if (TextUtils.equals(this.f262539d, obj)) {
                return;
            }
            this.f262539d = obj;
            c();
        }

        void c() {
            String charSequence = ECGameUnionButtonContainer.this.f262532d.getTipsView().getText().toString();
            if (TextUtils.isEmpty(charSequence) || TextUtils.equals("\u52a0\u8f7d\u4e2d", charSequence)) {
                return;
            }
            VideoReport.reportEvent("ev_bas_game_card_button_imp", a());
        }

        @Override // com.tencent.gamecenter.wadl.distribute.listener.IButtonEventListener
        public void onClick(View view) {
            if (ECGameUnionButtonContainer.this.f262532d.getButtonStatus().getSubscribeStatus() == 2) {
                return;
            }
            b();
        }

        @Override // com.tencent.gamecenter.wadl.distribute.listener.IButtonEventListener
        public void onDownloadTaskStatusChange(String str, float f16, int i3) {
        }

        @Override // com.tencent.gamecenter.wadl.distribute.listener.IButtonEventListener
        public void onFollowOrSubscribeStatusChange(String str, int i3, int i16) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}

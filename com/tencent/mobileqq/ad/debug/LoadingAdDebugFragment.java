package com.tencent.mobileqq.ad.debug;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.ad.api.ILoadingAdApi;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 ,2\u00020\u0001:\u0001-B\u0007\u00a2\u0006\u0004\b*\u0010+J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0014J\u001a\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/ad/debug/LoadingAdDebugFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "initViews", "yh", "Ch", "", "Bh", "", "adJson", "", "aid", "Dh", "Lcom/tencent/mobileqq/ad/loadingad/c;", "xh", "", "getContentLayoutId", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/TextView;", "mPreloadBtn", "D", "mReqAndShowBtn", "Lcom/tencent/mobileqq/ad/loadingad/j;", "E", "Lcom/tencent/mobileqq/ad/loadingad/j;", "mLoadingAdStatus", UserInfo.SEX_FEMALE, "Z", "mNeedRealTimeLoading", "G", "Ljava/lang/String;", "mLoadingAdJson", "H", "J", "mCachedAid", "<init>", "()V", "I", "a", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class LoadingAdDebugFragment extends QIphoneTitleBarFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private TextView mPreloadBtn;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView mReqAndShowBtn;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.ad.loadingad.j mLoadingAdStatus;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean mNeedRealTimeLoading;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private String mLoadingAdJson;

    /* renamed from: H, reason: from kotlin metadata */
    private long mCachedAid;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/ad/debug/LoadingAdDebugFragment$a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "a", "", "TAG", "Ljava/lang/String;", "TITLE", "<init>", "()V", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.ad.debug.LoadingAdDebugFragment$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        public final void a(@Nullable Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
            } else if (activity == null) {
                QLog.e("LoadingAdDebugFragment", 1, "start error");
            } else {
                QPublicFragmentActivity.start(activity, LoadingAdDebugFragment.class);
            }
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
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\"\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0004H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/ad/debug/LoadingAdDebugFragment$b", "Lcom/tencent/mobileqq/ad/loadingad/b;", "", "adJson", "", "aid", "", "needExtraDownload", "", "onChooseAdEnd", "onDownloadAdEnd", "needWait", "cacheAid", "onNeedWaitRealTime", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements com.tencent.mobileqq.ad.loadingad.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LoadingAdDebugFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.ad.loadingad.b
        public void onChooseAdEnd(@Nullable String adJson, long aid, boolean needExtraDownload) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, adJson, Long.valueOf(aid), Boolean.valueOf(needExtraDownload));
                return;
            }
            if (LoadingAdDebugFragment.this.Bh()) {
                if (needExtraDownload) {
                    QLog.d("LoadingAdDebugFragment", 1, "onChooseAdEnd \u9009\u5355\u8fd4\u56de\u4e86\u6ca1\u6709\u9884\u4e0b\u8f7d\u8fc7\u7684\u5e7f\u544a");
                    ((ILoadingAdApi) QRoute.api(ILoadingAdApi.class)).processSelectAdWithUncachedAd(adJson, this);
                    return;
                } else if (adJson != null && aid != -1) {
                    QLog.d("LoadingAdDebugFragment", 1, "onChooseAdEnd \u9009\u5355\u63a5\u53e3\u5b9e\u5355\u6210\u529f");
                    LoadingAdDebugFragment.this.Dh(adJson, aid);
                    return;
                } else {
                    QLog.d("LoadingAdDebugFragment", 1, "onChooseAdEnd \u9009\u5355\u63a5\u53e3\u7a7a\u5355\u6210\u529f");
                    LoadingAdDebugFragment.this.mLoadingAdStatus.a(3);
                    return;
                }
            }
            QLog.d("LoadingAdDebugFragment", 1, "onChooseAdEnd disableToShowAd");
            LoadingAdDebugFragment.this.mLoadingAdStatus.a(3);
        }

        @Override // com.tencent.mobileqq.ad.loadingad.b
        public void onDownloadAdEnd(@Nullable String adJson, long aid) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, adJson, Long.valueOf(aid));
                return;
            }
            if (LoadingAdDebugFragment.this.Bh()) {
                if (adJson != null && aid != -1) {
                    QLog.d("LoadingAdDebugFragment", 1, "onDownloadAdEnd download suc");
                    LoadingAdDebugFragment.this.Dh(adJson, aid);
                    return;
                } else {
                    QLog.e("LoadingAdDebugFragment", 1, "onDownloadAdEnd download fail");
                    LoadingAdDebugFragment.this.mLoadingAdStatus.a(3);
                    return;
                }
            }
            QLog.e("LoadingAdDebugFragment", 1, "onDownloadAdEnd download overtime");
            LoadingAdDebugFragment.this.mLoadingAdStatus.a(3);
        }

        @Override // com.tencent.mobileqq.ad.loadingad.b
        public void onNeedWaitRealTime(@Nullable String adJson, boolean needWait, long cacheAid) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                LoadingAdDebugFragment.this.mNeedRealTimeLoading = needWait;
                LoadingAdDebugFragment.this.mLoadingAdJson = adJson;
                LoadingAdDebugFragment.this.mCachedAid = cacheAid;
                QLog.d("LoadingAdDebugFragment", 1, "onNeedWaitRealTime update cache");
                return;
            }
            iPatchRedirector.redirect((short) 4, this, adJson, Boolean.valueOf(needWait), Long.valueOf(cacheAid));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/ad/debug/LoadingAdDebugFragment$c", "Lcom/tencent/mobileqq/ad/loadingad/i;", "", "isSuccess", "", "a", "onAdClose", "qqad-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class c implements com.tencent.mobileqq.ad.loadingad.i {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.ad.loadingad.i
        public void a(boolean isSuccess) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, isSuccess);
                return;
            }
            QLog.d("LoadingAdDebugFragment", 1, "onAdShowSuccess isSuccess:" + isSuccess);
        }

        @Override // com.tencent.mobileqq.ad.loadingad.i
        public void onAdClose() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                QLog.d("LoadingAdDebugFragment", 1, "onAdClose");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27817);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public LoadingAdDebugFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mLoadingAdStatus = new com.tencent.mobileqq.ad.loadingad.j();
            this.mLoadingAdJson = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ah(LoadingAdDebugFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ch();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Bh() {
        return true;
    }

    private final void Ch() {
        b bVar = new b();
        this.mLoadingAdStatus.a(1);
        ((ILoadingAdApi) QRoute.api(ILoadingAdApi.class)).requestAd(86, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Dh(String adJson, long aid) {
        ((ILoadingAdApi) QRoute.api(ILoadingAdApi.class)).showAd(getActivity(), xh(adJson, aid), new c());
    }

    private final void initViews(View rootView) {
        View findViewById = rootView.findViewById(R.id.f61722yw);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.qq_loading_ad_preload)");
        this.mPreloadBtn = (TextView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f61732yx);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.qq_loading_ad_req_show)");
        this.mReqAndShowBtn = (TextView) findViewById2;
    }

    private final com.tencent.mobileqq.ad.loadingad.c xh(String adJson, long aid) {
        com.tencent.mobileqq.ad.loadingad.c cVar = new com.tencent.mobileqq.ad.loadingad.c(null, null, null, 0, null, 0L, 63, null);
        cVar.k("\u817e\u8baf\u6587\u6863");
        cVar.j("https://minigame.gtimg.cn/public/appicon/1108244343/1c21043c_m.jpg");
        cVar.i("\u817e\u8baf\u6587\u6863desc todo");
        cVar.h(86);
        cVar.f(adJson);
        cVar.g(aid);
        return cVar;
    }

    private final void yh() {
        TextView textView = this.mPreloadBtn;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPreloadBtn");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.ad.debug.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoadingAdDebugFragment.zh(view);
            }
        });
        TextView textView3 = this.mReqAndShowBtn;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mReqAndShowBtn");
        } else {
            textView2 = textView3;
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.ad.debug.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoadingAdDebugFragment.Ah(LoadingAdDebugFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zh(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        ((ILoadingAdApi) QRoute.api(ILoadingAdApi.class)).preloadAd(86);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.gxv;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setTitle("Loading\u5e7f\u544a\u6d4b\u8bd5");
        initViews(view);
        yh();
    }
}

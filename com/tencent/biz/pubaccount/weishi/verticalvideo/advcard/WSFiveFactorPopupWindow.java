package com.tencent.biz.pubaccount.weishi.verticalvideo.advcard;

import UserGrowth.sTadLowItem;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.weishi.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi.util.r;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.WSFiveFactorPopupWindow;
import com.tencent.biz.pubaccount.weishi.view.RoundCornerImageView;
import com.tencent.biz.pubaccount.weishi.view.WSDragLayout;
import com.tencent.biz.pubaccount.weishi.z;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.ProgressButton;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.tencent.widget.immersive.SystemBarTintManager;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u00c9\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u0016\u0018\u0000 |2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001dB\u000f\u0012\u0006\u00102\u001a\u00020-\u00a2\u0006\u0004\bz\u0010{J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u000f\u0010\u0017\u001a\u00020\u0016H\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001e\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u00192\b\b\u0002\u0010\n\u001a\u00020\u000fH\u0002J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\bH\u0016J\b\u0010#\u001a\u00020\u0004H\u0016J\b\u0010$\u001a\u00020\u001bH\u0016J$\u0010)\u001a\u00020\u001b2\b\u0010\u0007\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\b2\b\u0010(\u001a\u0004\u0018\u00010'H\u0016J\u0016\u0010+\u001a\u00020\u00042\u0006\u0010*\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u0012J\b\u0010,\u001a\u00020\u0004H\u0016R\u0017\u00102\u001a\u00020-8\u0006\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0016\u00105\u001a\u0004\u0018\u0001038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u00104R\u001b\u0010;\u001a\u0002068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u001b\u0010@\u001a\u00020<8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b=\u00108\u001a\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010G\u001a\u00020E8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010Q\u001a\u00020L8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bP\u0010NR\u0016\u0010S\u001a\u00020L8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bR\u0010NR\u0016\u0010W\u001a\u00020T8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010[\u001a\u00020X8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010^\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010`\u001a\u00020L8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b_\u0010NR\u0016\u0010b\u001a\u00020T8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\ba\u0010VR\u0016\u0010e\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bc\u0010dR\u0016\u0010g\u001a\u00020L8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bf\u0010NR\u0016\u0010i\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bh\u0010dR\u0016\u0010m\u001a\u00020j8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bk\u0010lR\u0016\u0010o\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bn\u0010]R\u0016\u0010s\u001a\u00020p8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bq\u0010rR \u0010w\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020t0\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bu\u0010vR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bx\u0010y\u00a8\u0006}"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/verticalvideo/advcard/WSFiveFactorPopupWindow;", "Landroid/widget/PopupWindow;", "Lcom/tencent/biz/pubaccount/weishi/view/WSDragLayout$c;", "Landroid/view/View$OnKeyListener;", "", ReportConstant.COSTREPORT_PREFIX, "r", "v", "", "actionId", "clickPosition", "u", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/widget/FrameLayout;", "view", "", "url", "k", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/data/j;", "itemData", "t", "B", "com/tencent/biz/pubaccount/weishi/verticalvideo/advcard/WSFiveFactorPopupWindow$b", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/biz/pubaccount/weishi/verticalvideo/advcard/WSFiveFactorPopupWindow$b;", "", DomainData.DOMAIN_NAME, "", "up", "a", "", "progress", "e", "mode", "b", "scrollToTop", "g", "Landroid/view/View;", "keyCode", "Landroid/view/KeyEvent;", "event", "onKey", HippyNestedScrollComponent.PRIORITY_PARENT, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "dismiss", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/WSVerticalPageFragment;", "d", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/WSVerticalPageFragment;", "getFragment", "()Lcom/tencent/biz/pubaccount/weishi/verticalvideo/WSVerticalPageFragment;", "fragment", "Landroidx/fragment/app/FragmentActivity;", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/smtt/sdk/WebView;", "f", "Lkotlin/Lazy;", "p", "()Lcom/tencent/smtt/sdk/WebView;", "webView", "Landroid/widget/FrameLayout$LayoutParams;", tl.h.F, "l", "()Landroid/widget/FrameLayout$LayoutParams;", "defaultLayoutParams", "Lcom/tencent/biz/pubaccount/weishi/view/WSDragLayout;", "i", "Lcom/tencent/biz/pubaccount/weishi/view/WSDragLayout;", "dragLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "content", "Lcom/tencent/biz/pubaccount/weishi/view/RoundCornerImageView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/pubaccount/weishi/view/RoundCornerImageView;", "ivIcon", "Landroid/widget/TextView;", "D", "Landroid/widget/TextView;", "tvTitle", "E", "tvVersion", UserInfo.SEX_FEMALE, "tvDeveloper", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "ivClose", "Landroidx/core/widget/NestedScrollView;", "H", "Landroidx/core/widget/NestedScrollView;", "scrollContainer", "I", "Landroid/widget/FrameLayout;", "permissionContainer", "J", "permissionBtn", "K", "permissionArrowBtn", "L", "Landroid/view/View;", "permissionClickView", "M", "privacyBtn", "N", "privacyClickView", "Lcom/tencent/mobileqq/widget/ProgressButton;", "P", "Lcom/tencent/mobileqq/widget/ProgressButton;", "tvDownBtn", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "tvDownBtnContainer", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/advcard/m;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/advcard/m;", "downloadViewHelper", "LUserGrowth/sTadLowItem;", ExifInterface.LATITUDE_SOUTH, "Ljava/util/Map;", "appDataMap", "T", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/data/j;", "<init>", "(Lcom/tencent/biz/pubaccount/weishi/verticalvideo/WSVerticalPageFragment;)V", "U", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class WSFiveFactorPopupWindow extends PopupWindow implements WSDragLayout.c, View.OnKeyListener {

    /* renamed from: U, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private RoundCornerImageView ivIcon;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView tvTitle;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView tvVersion;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView tvDeveloper;

    /* renamed from: G, reason: from kotlin metadata */
    private ImageView ivClose;

    /* renamed from: H, reason: from kotlin metadata */
    private NestedScrollView scrollContainer;

    /* renamed from: I, reason: from kotlin metadata */
    private FrameLayout permissionContainer;

    /* renamed from: J, reason: from kotlin metadata */
    private TextView permissionBtn;

    /* renamed from: K, reason: from kotlin metadata */
    private ImageView permissionArrowBtn;

    /* renamed from: L, reason: from kotlin metadata */
    private View permissionClickView;

    /* renamed from: M, reason: from kotlin metadata */
    private TextView privacyBtn;

    /* renamed from: N, reason: from kotlin metadata */
    private View privacyClickView;

    /* renamed from: P, reason: from kotlin metadata */
    private ProgressButton tvDownBtn;

    /* renamed from: Q, reason: from kotlin metadata */
    private FrameLayout tvDownBtnContainer;

    /* renamed from: R, reason: from kotlin metadata */
    private m downloadViewHelper;

    /* renamed from: S, reason: from kotlin metadata */
    private final Map<String, sTadLowItem> appDataMap;

    /* renamed from: T, reason: from kotlin metadata */
    private com.tencent.biz.pubaccount.weishi.verticalvideo.data.j itemData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final WSVerticalPageFragment fragment;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final FragmentActivity activity;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy webView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Lazy defaultLayoutParams;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private WSDragLayout dragLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ConstraintLayout content;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0010\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/verticalvideo/advcard/WSFiveFactorPopupWindow$a;", "", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/WSVerticalPageFragment;", "fragment", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/advcard/WSFiveFactorPopupWindow;", "a", "", "BTN_CLOSE", "I", "BTN_PERMISSION", "BTN_PRIVACY", "", "CORNER", UserInfo.SEX_FEMALE, "", "KEY_APP", "Ljava/lang/String;", "KEY_COMPANY", "KEY_PERMISSION", "KEY_PRIVACY", "KEY_VERSION", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.WSFiveFactorPopupWindow$a, reason: from kotlin metadata */
    /* loaded from: classes32.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WSFiveFactorPopupWindow a(WSVerticalPageFragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            return new WSFiveFactorPopupWindow(fragment);
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WSFiveFactorPopupWindow(WSVerticalPageFragment fragment) {
        super(LayoutInflater.from(fragment.getActivity()).inflate(R.layout.d1v, (ViewGroup) null), -1, -1);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.fragment = fragment;
        this.activity = fragment.getActivity();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<WebView>() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.WSFiveFactorPopupWindow$webView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WebView invoke() {
                FragmentActivity fragmentActivity;
                WSFiveFactorPopupWindow.b m3;
                fragmentActivity = WSFiveFactorPopupWindow.this.activity;
                WebView webView = new WebView(fragmentActivity);
                WSFiveFactorPopupWindow wSFiveFactorPopupWindow = WSFiveFactorPopupWindow.this;
                WebSettings settings = webView.getSettings();
                settings.setJavaScriptEnabled(true);
                settings.setPluginsEnabled(true);
                settings.setJavaScriptCanOpenWindowsAutomatically(true);
                settings.setNeedInitialFocus(true);
                settings.setBuiltInZoomControls(false);
                settings.setSupportZoom(false);
                settings.setMediaPlaybackRequiresUserGesture(false);
                settings.setUseWideViewPort(true);
                settings.setTextSize(WebSettings.TextSize.NORMAL);
                settings.setCacheMode(-1);
                settings.setLoadWithOverviewMode(true);
                settings.setPluginState(WebSettings.PluginState.ON);
                settings.setDomStorageEnabled(true);
                settings.setAllowFileAccess(true);
                settings.setMixedContentMode(0);
                webView.setVerticalScrollbarOverlay(true);
                m3 = wSFiveFactorPopupWindow.m();
                webView.setWebViewClient(m3);
                return webView;
            }
        });
        this.webView = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout.LayoutParams>() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.WSFiveFactorPopupWindow$defaultLayoutParams$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FrameLayout.LayoutParams invoke() {
                return new FrameLayout.LayoutParams(-1, -2);
            }
        });
        this.defaultLayoutParams = lazy2;
        this.appDataMap = new LinkedHashMap();
        s();
        r();
        v();
    }

    private final void B(com.tencent.biz.pubaccount.weishi.verticalvideo.data.j itemData) {
        Map mapOf;
        ez.a f16 = itemData.f();
        ez.b bVar = f16 instanceof ez.b ? (ez.b) f16 : null;
        if (bVar != null) {
            WSPicLoader g16 = WSPicLoader.g();
            RoundCornerImageView roundCornerImageView = this.ivIcon;
            if (roundCornerImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivIcon");
                roundCornerImageView = null;
            }
            g16.w(roundCornerImageView, bVar.h(), null);
        }
        Pair[] pairArr = new Pair[3];
        TextView textView = this.tvTitle;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
            textView = null;
        }
        pairArr[0] = TuplesKt.to("app", textView);
        TextView textView2 = this.tvDeveloper;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvDeveloper");
            textView2 = null;
        }
        pairArr[1] = TuplesKt.to(IProfileProtocolConst.KEY_COMPANY, textView2);
        TextView textView3 = this.tvVersion;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvVersion");
            textView3 = null;
        }
        pairArr[2] = TuplesKt.to("version", textView3);
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        for (Map.Entry entry : mapOf.entrySet()) {
            TextView textView4 = (TextView) entry.getValue();
            sTadLowItem stadlowitem = this.appDataMap.get(entry.getKey());
            textView4.setText(stadlowitem != null ? stadlowitem.text : null);
        }
    }

    private final void k(FrameLayout view, String url) {
        ImageView imageView = null;
        if (p().getParent() == null) {
            WebView p16 = p();
            view.addView(p16, l());
            p16.loadUrl(url);
            ImageView imageView2 = this.permissionArrowBtn;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("permissionArrowBtn");
            } else {
                imageView = imageView2;
            }
            com.tencent.biz.pubaccount.weishi.util.h.c(imageView);
            return;
        }
        view.removeAllViews();
        ImageView imageView3 = this.permissionArrowBtn;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("permissionArrowBtn");
        } else {
            imageView = imageView3;
        }
        com.tencent.biz.pubaccount.weishi.util.h.a(imageView);
    }

    private final FrameLayout.LayoutParams l() {
        return (FrameLayout.LayoutParams) this.defaultLayoutParams.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b m() {
        return new b();
    }

    private final WebView p() {
        return (WebView) this.webView.getValue();
    }

    private final void q() {
        WSDragLayout wSDragLayout = this.dragLayout;
        WSDragLayout wSDragLayout2 = null;
        if (wSDragLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dragLayout");
            wSDragLayout = null;
        }
        wSDragLayout.setDisableMinScrollY(true);
        WSDragLayout wSDragLayout3 = this.dragLayout;
        if (wSDragLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dragLayout");
            wSDragLayout3 = null;
        }
        wSDragLayout3.setControlLitTongue(false);
        WSDragLayout wSDragLayout4 = this.dragLayout;
        if (wSDragLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dragLayout");
            wSDragLayout4 = null;
        }
        NestedScrollView nestedScrollView = this.scrollContainer;
        if (nestedScrollView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollContainer");
            nestedScrollView = null;
        }
        wSDragLayout4.setContentView(nestedScrollView);
        WSDragLayout wSDragLayout5 = this.dragLayout;
        if (wSDragLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dragLayout");
            wSDragLayout5 = null;
        }
        wSDragLayout5.setTouchListener(this);
        WSDragLayout wSDragLayout6 = this.dragLayout;
        if (wSDragLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dragLayout");
        } else {
            wSDragLayout2 = wSDragLayout6;
        }
        wSDragLayout2.setMode(1);
    }

    private final void r() {
        FrameLayout frameLayout;
        ProgressButton progressButton;
        View findViewById = getContentView().findViewById(R.id.p3k);
        Intrinsics.checkNotNullExpressionValue(findViewById, "contentView.findViewById(R.id.content)");
        this.content = (ConstraintLayout) findViewById;
        View findViewById2 = getContentView().findViewById(R.id.f163245p31);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "contentView.findViewById(R.id.app_icon)");
        RoundCornerImageView roundCornerImageView = (RoundCornerImageView) findViewById2;
        this.ivIcon = roundCornerImageView;
        if (roundCornerImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivIcon");
            roundCornerImageView = null;
        }
        roundCornerImageView.setCorner(r.H(44.0f));
        View findViewById3 = getContentView().findViewById(R.id.p37);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "contentView.findViewById(R.id.app_title)");
        this.tvTitle = (TextView) findViewById3;
        View findViewById4 = getContentView().findViewById(R.id.p38);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "contentView.findViewById(R.id.app_version)");
        this.tvVersion = (TextView) findViewById4;
        View findViewById5 = getContentView().findViewById(R.id.p2z);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "contentView.findViewById\u2026id.app_developer_content)");
        this.tvDeveloper = (TextView) findViewById5;
        View findViewById6 = getContentView().findViewById(R.id.p3_);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "contentView.findViewById(R.id.big_card_close_btn)");
        this.ivClose = (ImageView) findViewById6;
        View findViewById7 = getContentView().findViewById(R.id.p3n);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "contentView.findViewById(R.id.drag_layout)");
        this.dragLayout = (WSDragLayout) findViewById7;
        View findViewById8 = getContentView().findViewById(R.id.p68);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "contentView.findViewById(R.id.scroll_container)");
        this.scrollContainer = (NestedScrollView) findViewById8;
        View findViewById9 = getContentView().findViewById(R.id.f163247p33);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "contentView.findViewById\u2026app_permission_container)");
        this.permissionContainer = (FrameLayout) findViewById9;
        View findViewById10 = getContentView().findViewById(R.id.f163248p34);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "contentView.findViewById\u2026id.app_permissions_title)");
        this.permissionBtn = (TextView) findViewById10;
        View findViewById11 = getContentView().findViewById(R.id.p2y);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "contentView.findViewById(R.id.app_arrow)");
        this.permissionArrowBtn = (ImageView) findViewById11;
        View findViewById12 = getContentView().findViewById(R.id.f163246p32);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "contentView.findViewById\u2026.id.app_permission_click)");
        this.permissionClickView = findViewById12;
        View findViewById13 = getContentView().findViewById(R.id.p36);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "contentView.findViewById(R.id.app_privacy_title)");
        this.privacyBtn = (TextView) findViewById13;
        View findViewById14 = getContentView().findViewById(R.id.f163249p35);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "contentView.findViewById(R.id.app_privacy_click)");
        this.privacyClickView = findViewById14;
        View findViewById15 = getContentView().findViewById(R.id.p6k);
        Intrinsics.checkNotNull(findViewById15, "null cannot be cast to non-null type com.tencent.mobileqq.widget.ProgressButton");
        this.tvDownBtn = (ProgressButton) findViewById15;
        View findViewById16 = getContentView().findViewById(R.id.p6l);
        Intrinsics.checkNotNull(findViewById16, "null cannot be cast to non-null type android.widget.FrameLayout");
        this.tvDownBtnContainer = (FrameLayout) findViewById16;
        WSVerticalPageFragment wSVerticalPageFragment = this.fragment;
        FrameLayout frameLayout2 = this.tvDownBtnContainer;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvDownBtnContainer");
            frameLayout = null;
        } else {
            frameLayout = frameLayout2;
        }
        ProgressButton progressButton2 = this.tvDownBtn;
        if (progressButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvDownBtn");
            progressButton = null;
        } else {
            progressButton = progressButton2;
        }
        this.downloadViewHelper = new m(wSVerticalPageFragment, frameLayout, progressButton, WSThreeSegmentDownloadHelper.f81856a.f(), "download_float_btn", false, null, 96, null);
        q();
    }

    private final void t(com.tencent.biz.pubaccount.weishi.verticalvideo.data.j itemData) {
        this.itemData = itemData;
        ArrayList<sTadLowItem> arrayList = itemData.e().acquisitionInfo.items;
        Intrinsics.checkNotNullExpressionValue(arrayList, "itemData.itemInfo.acquisitionInfo.items");
        for (sTadLowItem it : arrayList) {
            Map<String, sTadLowItem> map = this.appDataMap;
            String str = it.name;
            Intrinsics.checkNotNullExpressionValue(str, "it.name");
            Intrinsics.checkNotNullExpressionValue(it, "it");
            map.put(str, it);
        }
    }

    private final void u(int actionId, int clickPosition) {
        com.tencent.biz.pubaccount.weishi.verticalvideo.data.j jVar = this.itemData;
        if (jVar != null) {
            String from = this.fragment.getFrom();
            Intrinsics.checkNotNullExpressionValue(from, "fragment.from");
            String playScene = this.fragment.getPlayScene();
            Intrinsics.checkNotNullExpressionValue(playScene, "fragment.playScene");
            p.h(from, playScene, jVar, actionId, n(String.valueOf(clickPosition)));
        }
    }

    private final void v() {
        getContentView().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WSFiveFactorPopupWindow.w(WSFiveFactorPopupWindow.this, view);
            }
        });
        getContentView().setOnKeyListener(this);
        View view = this.permissionClickView;
        ImageView imageView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("permissionClickView");
            view = null;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WSFiveFactorPopupWindow.x(WSFiveFactorPopupWindow.this, view2);
            }
        });
        View view2 = this.privacyClickView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("privacyClickView");
            view2 = null;
        }
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                WSFiveFactorPopupWindow.y(WSFiveFactorPopupWindow.this, view3);
            }
        });
        ImageView imageView2 = this.ivClose;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivClose");
        } else {
            imageView = imageView2;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                WSFiveFactorPopupWindow.z(WSFiveFactorPopupWindow.this, view3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(WSFiveFactorPopupWindow this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(WSFiveFactorPopupWindow this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.u(1000001, 5);
        FrameLayout frameLayout = this$0.permissionContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("permissionContainer");
            frameLayout = null;
        }
        sTadLowItem stadlowitem = this$0.appDataMap.get(QCircleDaTongConstant.ElementParamValue.PERMISSION);
        String str = stadlowitem != null ? stadlowitem.url : null;
        if (str == null) {
            str = "";
        }
        this$0.k(frameLayout, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(WSFiveFactorPopupWindow this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.u(1000004, 4);
        FragmentActivity fragmentActivity = this$0.activity;
        sTadLowItem stadlowitem = this$0.appDataMap.get("privacy");
        String str = stadlowitem != null ? stadlowitem.url : null;
        if (str == null) {
            str = "";
        }
        z.h(fragmentActivity, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(WSFiveFactorPopupWindow this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.u(1000001, 3);
        this$0.dismiss();
    }

    public final void A(View parent, com.tencent.biz.pubaccount.weishi.verticalvideo.data.j itemData) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        FragmentActivity fragmentActivity = this.activity;
        if (fragmentActivity != null && fragmentActivity.isFinishing()) {
            return;
        }
        super.showAtLocation(parent, 80, 0, (SystemBarTintManager.hasNavBar(this.activity) && ScreenUtil.isNavigationBarExist(this.activity)) ? (int) (ScreenUtil.getNavigationBarHeight(this.activity) / ScreenUtil.getDensity()) : 0);
        m mVar = this.downloadViewHelper;
        if (mVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("downloadViewHelper");
            mVar = null;
        }
        mVar.r(itemData);
        t(itemData);
        B(itemData);
        this.fragment.K1(3);
        String from = this.fragment.getFrom();
        Intrinsics.checkNotNullExpressionValue(from, "fragment.from");
        String playScene = this.fragment.getPlayScene();
        Intrinsics.checkNotNullExpressionValue(playScene, "fragment.playScene");
        p.i(from, playScene, itemData, o(this, null, 1, null));
    }

    @Override // com.tencent.biz.pubaccount.weishi.view.WSDragLayout.c
    public void b(int mode) {
        dismiss();
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        super.dismiss();
        m mVar = this.downloadViewHelper;
        if (mVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("downloadViewHelper");
            mVar = null;
        }
        mVar.s();
        this.fragment.H0(3);
    }

    @Override // com.tencent.biz.pubaccount.weishi.view.WSDragLayout.c
    public boolean g() {
        return false;
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/pubaccount/weishi/verticalvideo/advcard/WSFiveFactorPopupWindow$b", "Lcom/tencent/smtt/sdk/WebViewClient;", "Lcom/tencent/smtt/sdk/WebView;", "view", "", "url", "", "shouldOverrideUrlLoading", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class b extends WebViewClient {
        b() {
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (view == null) {
                return false;
            }
            view.loadUrl(url);
            return false;
        }
    }

    private final Map<String, String> n(String clickPosition) {
        Map<String, String> mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("btn_status", String.valueOf(WSThreeSegmentDownloadHelper.f81856a.f().getType())));
        if (clickPosition.length() > 0) {
            mutableMapOf.put("clk_loc", clickPosition);
        }
        return mutableMapOf;
    }

    private final void s() {
        setAnimationStyle(R.style.att);
        setFocusable(true);
        setInputMethodMode(1);
        setSoftInputMode(48);
        setOutsideTouchable(true);
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View v3, int keyCode, KeyEvent event) {
        if (keyCode != 4) {
            return false;
        }
        dismiss();
        return true;
    }

    static /* synthetic */ Map o(WSFiveFactorPopupWindow wSFiveFactorPopupWindow, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = "";
        }
        return wSFiveFactorPopupWindow.n(str);
    }

    @Override // com.tencent.biz.pubaccount.weishi.view.WSDragLayout.c
    public void scrollToTop() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.view.WSDragLayout.c
    public void a(boolean up5) {
    }

    @Override // com.tencent.biz.pubaccount.weishi.view.WSDragLayout.c
    public void e(float progress) {
    }
}

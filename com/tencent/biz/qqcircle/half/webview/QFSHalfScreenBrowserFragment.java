package com.tencent.biz.qqcircle.half.webview;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.qqcircle.half.webview.QFSHalfScreenBrowserFragment$sheetStateChangeListener$2;
import com.tencent.biz.richframework.compat.RFWImmersiveUtils;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.HalfScreenBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.ak;
import com.tencent.mobileqq.webview.swift.utils.t;
import com.tencent.mobileqq.webview.util.h;
import com.tencent.mobileqq.webview.view.WebBrowserViewContainerKt;
import com.tencent.mobileqq.webviewplugin.q;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.smtt.sdk.WebView;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0095\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\b\u000b*\u0001n\b\u0016\u0018\u0000 v2\u00020\u00012\u00020\u0002:\u0001wB\u0007\u00a2\u0006\u0004\bt\u0010uJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0002J\u0012\u0010\u0012\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J&\u0010\u0019\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u001b\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010\u001c\u001a\u00020\u0003H\u0014J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J\u001a\u0010#\u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\u00172\u0006\u0010\"\u001a\u00020\u001dH\u0016J\u0018\u0010$\u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\u00172\u0006\u0010\"\u001a\u00020\u001dJ\b\u0010%\u001a\u00020\u0005H\u0016J\b\u0010&\u001a\u0004\u0018\u00010\u0010J\u000e\u0010)\u001a\u00020\u00052\u0006\u0010(\u001a\u00020'J\u000f\u0010*\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b*\u0010+J\b\u0010,\u001a\u00020\u0005H\u0016J\b\u0010-\u001a\u00020\u0005H\u0016J\u0010\u0010/\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\fH\u0016J\u000e\u00102\u001a\b\u0012\u0004\u0012\u00020100H\u0016R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010A\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010C\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010@R\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010K\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010M\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010FR\u0018\u0010P\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010R\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010OR\u0018\u0010T\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010OR\u0016\u0010.\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0018\u0010Y\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010]\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\\R$\u0010d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\"\u0010j\u001a\u00020'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\be\u0010I\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\u0018\u0010m\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010lR\u001b\u0010s\u001a\u00020n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bo\u0010p\u001a\u0004\bq\u0010r\u00a8\u0006x"}, d2 = {"Lcom/tencent/biz/qqcircle/half/webview/QFSHalfScreenBrowserFragment;", "Lcom/tencent/mobileqq/webview/swift/WebViewFragment;", "Lcom/tencent/mobileqq/webview/util/h;", "", "action", "", "Gh", "Oh", "Ph", "Bh", "title", "Rh", "", "isShare", "Lh", "Qh", "Landroid/view/View;", "contentView", "registerDaTongReportPageId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", "fragmentLayout", "Eh", "getLogTag", "Lcom/tencent/mobileqq/webview/swift/utils/t;", "getWebViewKernelCallBack", "Lcom/tencent/mobileqq/webviewplugin/q;", "getWebTitleBarInterface", WadlProxyConsts.EXTRA_DATA, "webViewKernelCallBack", "onInitUIContent", "onFinalState", "doOnBackEvent", OcrConfig.CHINESE, "", "visibility", "Mh", "Hh", "()Ljava/lang/Boolean;", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "isShowNext", "i2", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Lcom/tencent/biz/qqcircle/half/webview/QFSHalfScreenWebSheetView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/qqcircle/half/webview/QFSHalfScreenWebSheetView;", "halfBottomSheetView", "Landroid/widget/LinearLayout;", "D", "Landroid/widget/LinearLayout;", "rootLinearLayout", "Landroidx/constraintlayout/utils/widget/ImageFilterView;", "E", "Landroidx/constraintlayout/utils/widget/ImageFilterView;", "garyBarIv", UserInfo.SEX_FEMALE, "Landroid/view/ViewGroup;", "titleContainer", "G", "titleOperateContainer", "Landroid/widget/ImageView;", "H", "Landroid/widget/ImageView;", "backIv", "Landroid/widget/TextView;", "I", "Landroid/widget/TextView;", "titleNameTv", "J", "shareIv", "K", "Landroid/view/View;", "mHalfClickMaskView", "L", "webLeftIv", "M", "webShareIv", "N", "Z", "P", "Ljava/lang/String;", "titleNameStr", "Lcom/tencent/biz/qqcircle/half/webview/f;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/biz/qqcircle/half/webview/f;", "panelManagePart", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/webview/util/h;", "Ih", "()Lcom/tencent/mobileqq/webview/util/h;", "setActionListener", "(Lcom/tencent/mobileqq/webview/util/h;)V", "actionListener", ExifInterface.LATITUDE_SOUTH, "Jh", "()I", "Nh", "(I)V", "mLastStatus", "T", "Ljava/lang/Boolean;", "mEnableForceFull", "com/tencent/biz/qqcircle/half/webview/QFSHalfScreenBrowserFragment$sheetStateChangeListener$2$a", "U", "Lkotlin/Lazy;", "Kh", "()Lcom/tencent/biz/qqcircle/half/webview/QFSHalfScreenBrowserFragment$sheetStateChangeListener$2$a;", "sheetStateChangeListener", "<init>", "()V", "V", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public class QFSHalfScreenBrowserFragment extends WebViewFragment implements h {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private QFSHalfScreenWebSheetView halfBottomSheetView;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private LinearLayout rootLinearLayout;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private ImageFilterView garyBarIv;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private ViewGroup titleContainer;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private ViewGroup titleOperateContainer;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private ImageView backIv;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private TextView titleNameTv;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private ImageView shareIv;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private View mHalfClickMaskView;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private View webLeftIv;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private View webShareIv;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean isShowNext;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private String titleNameStr;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private f panelManagePart;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private h actionListener;

    /* renamed from: S, reason: from kotlin metadata */
    private int mLastStatus;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private Boolean mEnableForceFull;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final Lazy sheetStateChangeListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\u001c\u0010\u0010\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u0010\u0012\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0016\u00a8\u0006\u0013"}, d2 = {"com/tencent/biz/qqcircle/half/webview/QFSHalfScreenBrowserFragment$b", "Lcom/tencent/mobileqq/webview/swift/proxy/a;", "Landroid/os/Bundle;", WadlProxyConsts.EXTRA_DATA, "Lcom/tencent/biz/ui/TouchWebView;", "webView", "", "onWebViewInit", "onShowPreview", "onInitUIContent", "onFinalState", "loadUrlFinish", "Lcom/tencent/smtt/sdk/WebView;", "view", "", "url", "onPageFinished", "title", "onReceivedTitle", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends com.tencent.mobileqq.webview.swift.proxy.a {
        b(ak akVar) {
            super(akVar);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void loadUrlFinish() {
            QLog.d(QFSHalfScreenBrowserFragment.this.getTAG(), 1, "loadUrlFinish");
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onFinalState(@Nullable Bundle extraData) {
            QFSHalfScreenBrowserFragment qFSHalfScreenBrowserFragment = QFSHalfScreenBrowserFragment.this;
            t webViewKernelCallBack = this.webViewKernelCallBack;
            Intrinsics.checkNotNullExpressionValue(webViewKernelCallBack, "webViewKernelCallBack");
            qFSHalfScreenBrowserFragment.onFinalState(extraData, webViewKernelCallBack);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onInitUIContent(@Nullable Bundle extraData) {
            QFSHalfScreenBrowserFragment qFSHalfScreenBrowserFragment = QFSHalfScreenBrowserFragment.this;
            t webViewKernelCallBack = this.webViewKernelCallBack;
            Intrinsics.checkNotNullExpressionValue(webViewKernelCallBack, "webViewKernelCallBack");
            qFSHalfScreenBrowserFragment.onInitUIContent(extraData, webViewKernelCallBack);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public void onPageFinished(@Nullable WebView view, @Nullable String url) {
            QLog.d(QFSHalfScreenBrowserFragment.this.getTAG(), 1, "onPageFinished");
            QFSHalfScreenBrowserFragment.this.Bh();
            QFSHalfScreenBrowserFragment.this.Ph();
            QFSHalfScreenBrowserFragment qFSHalfScreenBrowserFragment = QFSHalfScreenBrowserFragment.this;
            qFSHalfScreenBrowserFragment.Rh(qFSHalfScreenBrowserFragment.titleNameStr);
            if (Intrinsics.areEqual(QFSHalfScreenBrowserFragment.this.Hh(), Boolean.TRUE)) {
                QFSHalfScreenBrowserFragment.this.zh();
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public void onReceivedTitle(@Nullable WebView view, @Nullable String title) {
            super.onReceivedTitle(view, title);
            QFSHalfScreenBrowserFragment.this.Rh(title);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onShowPreview(@Nullable Bundle extraData) {
            Intent intent = QFSHalfScreenBrowserFragment.this.getIntent();
            if (intent != null) {
                intent.putExtra("isTransparentTitle", true);
            }
            super.onShowPreview(extraData);
            if (intent != null) {
                intent.removeExtra("isTransparentTitle");
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onWebViewInit(@Nullable Bundle extraData, @Nullable TouchWebView webView) {
            QLog.d(QFSHalfScreenBrowserFragment.this.getTAG(), 1, "onWebViewInit");
            super.onWebViewInit(extraData, webView);
        }
    }

    public QFSHalfScreenBrowserFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QFSHalfScreenBrowserFragment$sheetStateChangeListener$2.a>() { // from class: com.tencent.biz.qqcircle.half.webview.QFSHalfScreenBrowserFragment$sheetStateChangeListener$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a(QFSHalfScreenBrowserFragment.this);
            }

            /* compiled from: P */
            @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J \u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/biz/qqcircle/half/webview/QFSHalfScreenBrowserFragment$sheetStateChangeListener$2$a", "Lr30/b;", "", "k7", "m5", "l0", "", "slideOffset", "", "defaultHeight", "topSpaceHeight", ICustomDataEditor.NUMBER_PARAM_6, "", "withAnim", "l", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes4.dex */
            public static final class a implements r30.b {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ QFSHalfScreenBrowserFragment f84548d;

                a(QFSHalfScreenBrowserFragment qFSHalfScreenBrowserFragment) {
                    this.f84548d = qFSHalfScreenBrowserFragment;
                }

                @Override // r30.b
                public void k7() {
                    if (this.f84548d.getMLastStatus() == 1) {
                        this.f84548d.Gh(QCircleDaTongConstant.ElementParamValue.ACTION_SEMI_UP_SLIDE);
                    }
                    this.f84548d.Nh(2);
                }

                @Override // r30.b
                public void l(boolean withAnim) {
                    boolean z16;
                    h actionListener = this.f84548d.getActionListener();
                    if (actionListener != null) {
                        z16 = this.f84548d.isShowNext;
                        actionListener.i2(z16);
                    }
                    if (this.f84548d.getMLastStatus() == 1) {
                        this.f84548d.Gh(QCircleDaTongConstant.ElementParamValue.ACTION_SEMI_DOWN_SLIDE);
                    } else if (this.f84548d.getMLastStatus() == 2) {
                        this.f84548d.Gh(QCircleDaTongConstant.ElementParamValue.ACTION_FULL_SLIDE_CLOSE);
                    }
                    this.f84548d.Nh(0);
                }

                @Override // r30.b
                public void m5() {
                    if (this.f84548d.getMLastStatus() == 2) {
                        this.f84548d.Gh(QCircleDaTongConstant.ElementParamValue.ACTION_FULL_DOWN_SLIDE);
                    }
                    this.f84548d.Nh(1);
                }

                @Override // r30.b
                public void l0() {
                }

                @Override // r30.b
                public void n6(float slideOffset, int defaultHeight, int topSpaceHeight) {
                }
            }
        });
        this.sheetStateChangeListener = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ah(QFSHalfScreenBrowserFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QFSHalfScreenWebSheetView qFSHalfScreenWebSheetView = this$0.halfBottomSheetView;
        if (qFSHalfScreenWebSheetView != null) {
            qFSHalfScreenWebSheetView.m();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Bh() {
        Unit unit;
        ViewGroup.LayoutParams layoutParams;
        LinearLayout.LayoutParams layoutParams2;
        ViewGroup viewGroup;
        ImageView imageView;
        TextView textView;
        ImageView imageView2;
        if (this.titleContainer != null) {
            return;
        }
        WebBrowserViewContainerKt webBrowserViewContainerKt = this.contentView;
        Unit unit2 = null;
        ImageView imageView3 = null;
        if (!(webBrowserViewContainerKt instanceof RelativeLayout)) {
            webBrowserViewContainerKt = null;
        }
        if (webBrowserViewContainerKt != null) {
            this.webLeftIv = webBrowserViewContainerKt.findViewById(R.id.ivTitleBtnLeft);
            this.webShareIv = webBrowserViewContainerKt.findViewById(R.id.ivTitleBtnRightImage);
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.gd5, (ViewGroup) webBrowserViewContainerKt, false);
            Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.view.View");
            if (inflate instanceof ImageFilterView) {
                this.garyBarIv = (ImageFilterView) inflate;
            }
            this.contentView.addView(inflate);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.d(getTAG(), 1, "[addTitleIcon] contentView type error, not add title icon");
        }
        LinearLayout linearLayout = this.rootLinearLayout;
        if (linearLayout != null) {
            View inflate2 = LayoutInflater.from(getContext()).inflate(R.layout.gd8, (ViewGroup) linearLayout, false);
            Intrinsics.checkNotNull(inflate2, "null cannot be cast to non-null type android.view.ViewGroup");
            this.titleContainer = (ViewGroup) inflate2;
            int statusBarHeight = RFWImmersiveUtils.getStatusBarHeight();
            ViewGroup viewGroup2 = this.titleContainer;
            if (viewGroup2 != null) {
                layoutParams = viewGroup2.getLayoutParams();
            } else {
                layoutParams = null;
            }
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            } else {
                layoutParams2 = null;
            }
            if (layoutParams2 != null) {
                layoutParams2.height += statusBarHeight;
            }
            ViewGroup viewGroup3 = this.titleContainer;
            if (viewGroup3 != null) {
                viewGroup3.setPadding(viewGroup3.getPaddingLeft(), viewGroup3.getPaddingTop() + statusBarHeight, viewGroup3.getPaddingRight(), viewGroup3.getPaddingBottom());
            }
            ViewGroup viewGroup4 = this.titleContainer;
            if (viewGroup4 != null) {
                viewGroup = (ViewGroup) viewGroup4.findViewById(R.id.f43491mm);
            } else {
                viewGroup = null;
            }
            this.titleOperateContainer = viewGroup;
            ViewGroup viewGroup5 = this.titleContainer;
            if (viewGroup5 != null) {
                imageView = (ImageView) viewGroup5.findViewById(R.id.f43501mn);
            } else {
                imageView = null;
            }
            this.backIv = imageView;
            if (imageView != null) {
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.half.webview.b
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        QFSHalfScreenBrowserFragment.Ch(QFSHalfScreenBrowserFragment.this, view);
                    }
                });
            }
            ViewGroup viewGroup6 = this.titleContainer;
            if (viewGroup6 != null) {
                textView = (TextView) viewGroup6.findViewById(R.id.f43511mo);
            } else {
                textView = null;
            }
            this.titleNameTv = textView;
            ViewGroup viewGroup7 = this.titleContainer;
            if (viewGroup7 != null) {
                imageView3 = (ImageView) viewGroup7.findViewById(R.id.f43521mp);
            }
            this.shareIv = imageView3;
            if (imageView3 != null) {
                imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.half.webview.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        QFSHalfScreenBrowserFragment.Dh(QFSHalfScreenBrowserFragment.this, view);
                    }
                });
            }
            linearLayout.addView(this.titleContainer, 0);
            f fVar = this.panelManagePart;
            if (fVar != null) {
                fVar.R9(this.titleContainer, this.titleOperateContainer, this.garyBarIv);
            }
            if (getUIStyle().f314630m && (imageView2 = this.shareIv) != null) {
                imageView2.setVisibility(8);
            }
            unit2 = Unit.INSTANCE;
        }
        if (unit2 == null) {
            QLog.d(getTAG(), 1, "[addTitleIcon] halfBottomSheetView is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ch(QFSHalfScreenBrowserFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Lh(false);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Dh(QFSHalfScreenBrowserFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Lh(true);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fh(QFSHalfScreenBrowserFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.doOnBackEvent();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Gh(String action) {
        QLog.d(getTAG(), 1, "[doStatusChangeReport] action:" + action);
        WebBrowserViewContainerKt contentView = getContentView();
        if (contentView == null) {
            return;
        }
        VideoReport.setElementId(contentView, QCircleDaTongConstant.ElementId.EM_XSJ_GESTURE_SLIDING);
        Map<String, Object> map = new QCircleDTParamBuilder().buildElementParams();
        Intrinsics.checkNotNullExpressionValue(map, "map");
        map.put(QCircleDaTongConstant.ElementParamKey.XSJ_CURRENT_STATE, action);
        map.put("xsj_custom_pgid", QCircleDaTongConstant.PageId.PG_XSJ_SEMI_FLOAT_PAGE);
        map.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_GESTURE_SLIDING);
        VideoReport.reportEvent("ev_xsj_abnormal_clck", contentView, map);
    }

    private final QFSHalfScreenBrowserFragment$sheetStateChangeListener$2.a Kh() {
        return (QFSHalfScreenBrowserFragment$sheetStateChangeListener$2.a) this.sheetStateChangeListener.getValue();
    }

    private final void Lh(boolean isShare) {
        if (this.webViewSurface == null) {
            QLog.e(getTAG(), 1, "[handleTitleIconClick] webViewSurface is null, isShare:" + isShare);
            return;
        }
        QLog.d(getTAG(), 1, "[handleTitleIconClick] isShare:" + isShare);
        Unit unit = null;
        if (isShare) {
            View view = this.webShareIv;
            if (view != null) {
                this.webViewSurface.onClick(view);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                QLog.e(getTAG(), 1, "[handleTitleIconClick] web share iv is null");
                return;
            }
            return;
        }
        View view2 = this.webLeftIv;
        if (view2 != null) {
            this.webViewSurface.onClick(view2);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            QLog.e(getTAG(), 1, "[handleTitleIconClick] web left iv is null");
        }
    }

    private final void Oh() {
        View view;
        ViewGroup viewGroup;
        Window window;
        Activity hostActivity = getHostActivity();
        Unit unit = null;
        if (hostActivity != null && (window = hostActivity.getWindow()) != null) {
            view = window.getDecorView();
        } else {
            view = null;
        }
        if (view instanceof ViewGroup) {
            viewGroup = (ViewGroup) view;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            if (viewGroup.getChildCount() > 0) {
                View childAt = viewGroup.getChildAt(0);
                if (childAt == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(childAt, "it.getChildAt(0) ?: return");
                QLog.d(getTAG(), 1, "[setRootLayoutTransparentBackground]");
                childAt.setBackgroundResource(R.drawable.kn_);
            } else {
                QLog.d(getTAG(), 1, "[setRootLayoutTransparentBackground] decorView not has child view");
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            QLog.e(getTAG(), 1, "[setRootLayoutTransparentBackground] decorView is not ViewGroup");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ph() {
        Unit unit;
        QFSHalfScreenWebSheetView qFSHalfScreenWebSheetView = this.halfBottomSheetView;
        if (qFSHalfScreenWebSheetView != null) {
            QLog.d(getTAG(), 1, "[showSheetView] success");
            qFSHalfScreenWebSheetView.z();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.e(getTAG(), 1, "[showSheetView] error, sheet view is null");
        }
    }

    private final void Qh() {
        FragmentActivity activity = getActivity();
        if (activity != null && RFWImmersiveUtils.isNavigationBarExist(activity.getWindow())) {
            RFWImmersiveUtils.setNavigationBarIconColor(activity.getWindow(), !QQTheme.isNowThemeIsNight());
            RFWImmersiveUtils.setNavigationBarColor(activity.getWindow(), ie0.a.f().g(getContext(), R.color.qui_common_bg_nav_secondary, 1000));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Rh(String title) {
        TextView textView = this.titleNameTv;
        if (textView != null) {
            textView.setText(title);
        }
        this.titleNameStr = title;
    }

    private final void registerDaTongReportPageId(View contentView) {
        String str;
        if (contentView == null) {
            return;
        }
        VideoReport.setPageId(contentView, QCircleDaTongConstant.PageId.PG_XSJ_SEMI_FLOAT_PAGE);
        HashMap hashMap = new HashMap();
        HashMap<String, String> c16 = com.tencent.biz.qqcircle.d.c(getUrl());
        String str2 = null;
        if (c16 != null) {
            str = c16.get("qfs_autoshowpannel");
        } else {
            str = null;
        }
        if (c16 != null) {
            str2 = c16.get(QCircleSchemeAttr.WebView.KEY_TASK_ID);
        }
        QLog.d(getTAG(), 1, "[onResume] autoShow:" + str + ",taskId:" + str2);
        if (str != null) {
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_AUTO_TRIGGER, str);
        }
        if (str2 != null) {
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, str2);
        }
        VideoReport.setPageParams(contentView, new QCircleDTParamBuilder().buildPageParams(getTAG(), hashMap));
        VideoReport.setElementDynamicParams(contentView, new QCircleDTParamBuilder().buildElementDynamicParams());
        VideoReport.setEventDynamicParams(contentView, new QCircleDTParamBuilder().buildDynamicParams());
    }

    @NotNull
    protected View Eh(@Nullable View fragmentLayout) {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        QFSHalfScreenWebSheetView qFSHalfScreenWebSheetView = new QFSHalfScreenWebSheetView(requireContext, null, 2, null);
        LinearLayout linearLayout = new LinearLayout(requireContext());
        this.rootLinearLayout = linearLayout;
        Intrinsics.checkNotNull(linearLayout);
        linearLayout.setOrientation(1);
        if (fragmentLayout != null) {
            LinearLayout linearLayout2 = this.rootLinearLayout;
            Intrinsics.checkNotNull(linearLayout2);
            linearLayout2.addView(fragmentLayout, new ViewGroup.LayoutParams(-1, -1));
        }
        CoordinatorLayout.LayoutParams layoutParams = new CoordinatorLayout.LayoutParams(-1, -1);
        LinearLayout linearLayout3 = this.rootLinearLayout;
        Intrinsics.checkNotNull(linearLayout3);
        qFSHalfScreenWebSheetView.t(linearLayout3, layoutParams, fragmentLayout);
        qFSHalfScreenWebSheetView.i(Kh());
        qFSHalfScreenWebSheetView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.half.webview.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSHalfScreenBrowserFragment.Fh(QFSHalfScreenBrowserFragment.this, view);
            }
        });
        this.halfBottomSheetView = qFSHalfScreenWebSheetView;
        return qFSHalfScreenWebSheetView;
    }

    @Nullable
    public final Boolean Hh() {
        boolean contains$default;
        Boolean bool = this.mEnableForceFull;
        if (bool != null) {
            return bool;
        }
        String urlFromIntent = getUrlFromIntent();
        if (urlFromIntent != null) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) urlFromIntent, (CharSequence) "forceEnableFull=1", false, 2, (Object) null);
            this.mEnableForceFull = Boolean.valueOf(contains$default);
        }
        return this.mEnableForceFull;
    }

    @Nullable
    /* renamed from: Ih, reason: from getter */
    public final h getActionListener() {
        return this.actionListener;
    }

    /* renamed from: Jh, reason: from getter */
    public final int getMLastStatus() {
        return this.mLastStatus;
    }

    public final void Mh(int visibility) {
        View view = this.mHalfClickMaskView;
        if (view != null) {
            view.setVisibility(visibility);
        }
    }

    public final void Nh(int i3) {
        this.mLastStatus = i3;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        f fVar = new f(this.halfBottomSheetView);
        this.panelManagePart = fVar;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(fVar);
        return mutableListOf;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webview.swift.WebViewProvider
    public void doOnBackEvent() {
        HalfScreenBrowserActivity halfScreenBrowserActivity;
        if (handleBackEvent()) {
            return;
        }
        Activity hostActivity = getHostActivity();
        if (hostActivity instanceof HalfScreenBrowserActivity) {
            halfScreenBrowserActivity = (HalfScreenBrowserActivity) hostActivity;
        } else {
            halfScreenBrowserActivity = null;
        }
        if (halfScreenBrowserActivity != null) {
            halfScreenBrowserActivity.doOnBackPressed();
            return;
        }
        QLog.d(getTAG(), 1, "[doOnBackEvent] host activity not half screen, direct finish");
        Activity hostActivity2 = getHostActivity();
        if (hostActivity2 != null) {
            hostActivity2.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSHalfScreenBrowserFragment";
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
    @NotNull
    public q getWebTitleBarInterface() {
        q webTitleBarInterface = super.getWebTitleBarInterface();
        webTitleBarInterface.u6(true);
        Intrinsics.checkNotNullExpressionValue(webTitleBarInterface, "webTitleBarInterface");
        return webTitleBarInterface;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
    @NotNull
    public t getWebViewKernelCallBack() {
        return new b(this.webViewSurface);
    }

    @Override // com.tencent.mobileqq.webview.util.h
    public void i2(boolean isShowNext) {
        this.isShowNext = isShowNext;
        QFSHalfScreenWebSheetView qFSHalfScreenWebSheetView = this.halfBottomSheetView;
        if (qFSHalfScreenWebSheetView != null) {
            qFSHalfScreenWebSheetView.l();
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Oh();
        View onCreateView = super.onCreateView(inflater, container, savedInstanceState);
        if (getContext() != null) {
            onCreateView = Eh(onCreateView);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    public final void onFinalState(@Nullable Bundle extraData, @NotNull t webViewKernelCallBack) {
        h hVar;
        Intrinsics.checkNotNullParameter(webViewKernelCallBack, "webViewKernelCallBack");
        webViewKernelCallBack.onFinalState(extraData);
        f fVar = this.panelManagePart;
        if (fVar != null) {
            fVar.P9();
        }
        ComponentCallbacks2 hostActivity = getHostActivity();
        if (hostActivity instanceof h) {
            hVar = (h) hostActivity;
        } else {
            hVar = null;
        }
        if (hVar != null) {
            this.actionListener = hVar;
        }
        QLog.d(getTAG(), 1, "onFinalState");
    }

    public void onInitUIContent(@Nullable Bundle extraData, @NotNull t webViewKernelCallBack) {
        Intrinsics.checkNotNullParameter(webViewKernelCallBack, "webViewKernelCallBack");
        getUIStyle().f314622e = 0L;
        getUIStyleHandler().f314499a0 = true;
        getUIStyle().A = true;
        webViewKernelCallBack.onInitUIContent(extraData);
        if (getUIStyleHandler().S instanceof RefreshView) {
            ViewGroup viewGroup = getUIStyleHandler().S;
            Intrinsics.checkNotNull(viewGroup, "null cannot be cast to non-null type com.tencent.biz.ui.RefreshView");
            ((RefreshView) viewGroup).a(false);
        }
        if (getUIStyleHandler().f314500b0 != null) {
            getUIStyleHandler().f314500b0.setVisibility(8);
        }
        if (this.webView.getX5WebViewExtension() != null) {
            try {
                this.webView.getView().setBackgroundColor(0);
                this.webView.setBackgroundColor(0);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        } else {
            this.webView.setBackgroundColor(0);
        }
        QLog.d(getTAG(), 1, "onInitUIContent");
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        QLog.d(getTAG(), 1, "[onPause]");
        VideoReport.reportPgOut(this.contentView);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        QLog.d(getTAG(), 1, "[onResume]");
        Qh();
        registerDaTongReportPageId(this.contentView);
        VideoReport.reportPgIn(this.contentView);
    }

    @Nullable
    public final View zh() {
        View view = this.mHalfClickMaskView;
        if (view != null) {
            return view;
        }
        WebBrowserViewContainerKt webBrowserViewContainerKt = this.contentView;
        if (!(webBrowserViewContainerKt instanceof RelativeLayout)) {
            webBrowserViewContainerKt = null;
        }
        if (webBrowserViewContainerKt != null) {
            View view2 = new View(getContext());
            view2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            view2.setBackground(new ColorDrawable(0));
            this.mHalfClickMaskView = view2;
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.half.webview.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    QFSHalfScreenBrowserFragment.Ah(QFSHalfScreenBrowserFragment.this, view3);
                }
            });
            webBrowserViewContainerKt.addView(this.mHalfClickMaskView);
            QLog.d(getTAG(), 1, "[addHalfClickMaskView]");
        }
        return this.mHalfClickMaskView;
    }
}

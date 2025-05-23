package com.tencent.biz.qqcircle.half.webview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.qqcircle.events.QFSJsChangeHalfScreenState;
import com.tencent.biz.qqcircle.events.QFSJsGetCurrentHalfPannelStatusEvent;
import com.tencent.biz.qqcircle.events.QFSJsNeedCollapseEvent;
import com.tencent.biz.qqcircle.events.QFSJsSupportHalfToFullScreenEvent;
import com.tencent.biz.qqcircle.events.QFSRecommendPanelStatusEvent;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSStartVideoEvent;
import com.tencent.biz.qqcircle.immersive.part.u;
import com.tencent.biz.richframework.compat.RFWImmersiveUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.injector.aa;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import r30.a;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b(\u0018\u0000 }2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\b\u0012\u0004\u0012\u00020\u00060\u0005:\u0001~B\u0011\u0012\b\u0010Z\u001a\u0004\u0018\u00010W\u00a2\u0006\u0004\b{\u0010|J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0002J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\tH\u0002J\b\u0010\u0017\u001a\u00020\u0007H\u0002J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001bH\u0002J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001dH\u0002J\u0010\u0010 \u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001fH\u0002J\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\tH\u0002J\u0011\u0010#\u001a\u0004\u0018\u00010\u0013H\u0002\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010&\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u0013H\u0002J\b\u0010'\u001a\u00020\tH\u0002J\b\u0010(\u001a\u00020\tH\u0002J\b\u0010)\u001a\u00020\tH\u0002J\u0010\u0010,\u001a\u00020\u00072\u0006\u0010+\u001a\u00020*H\u0016J\b\u0010.\u001a\u00020-H\u0016J\u0006\u0010/\u001a\u00020\u0007J$\u00104\u001a\u00020\u00072\b\u00100\u001a\u0004\u0018\u00010*2\b\u00101\u001a\u0004\u0018\u00010*2\b\u00103\u001a\u0004\u0018\u000102J\u001c\u00109\u001a\u00020\u00072\b\u00106\u001a\u0004\u0018\u0001052\b\u00108\u001a\u0004\u0018\u000107H\u0016J\u0010\u0010:\u001a\u00020\u00072\u0006\u00106\u001a\u000205H\u0016J\u0010\u0010;\u001a\u00020\u00072\u0006\u00106\u001a\u000205H\u0016J\b\u0010<\u001a\u00020\tH\u0016J\u0012\u0010=\u001a\u00020\u00072\b\u00106\u001a\u0004\u0018\u000105H\u0016J0\u0010C\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u00132\u0006\u0010?\u001a\u00020\u00132\u0006\u0010@\u001a\u00020\t2\u0006\u0010A\u001a\u00020\t2\u0006\u0010B\u001a\u00020*H\u0016J\u001c\u0010G\u001a\u00020\t2\b\u0010D\u001a\u0004\u0018\u00010*2\b\u0010F\u001a\u0004\u0018\u00010EH\u0016J\b\u0010H\u001a\u00020\u0007H\u0016J\b\u0010I\u001a\u00020\u0007H\u0016J\b\u0010J\u001a\u00020\u0007H\u0016J \u0010O\u001a\u00020\u00072\u0006\u0010L\u001a\u00020K2\u0006\u0010M\u001a\u00020\u00132\u0006\u0010N\u001a\u00020\u0013H\u0016J\u0010\u0010Q\u001a\u00020\u00072\u0006\u0010P\u001a\u00020\tH\u0016J\u0012\u0010R\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010V\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060T0Sj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060T`UH\u0016R\u0016\u0010Z\u001a\u0004\u0018\u00010W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0018\u0010]\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0018\u0010_\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010\\R\u0018\u0010b\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0018\u0010e\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010dR\u0016\u0010h\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010j\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010gR\u0016\u0010l\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010gR\u0016\u0010n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010gR\u0016\u0010p\u001a\u00020K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010oR\u0016\u0010r\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bq\u0010gR\u0016\u0010t\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bs\u0010gR\u0016\u0010v\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bu\u0010gR\u0016\u0010x\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bw\u0010uR\u0016\u0010z\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\by\u0010g\u00a8\u0006\u007f"}, d2 = {"Lcom/tencent/biz/qqcircle/half/webview/f;", "Lcom/tencent/biz/qqcircle/immersive/part/u;", "Lcom/tencent/biz/ui/TouchWebView$OnOverScrolledListener;", "Lr30/a;", "Lr30/b;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "K9", "", "showTitle", "T9", "rounded", "U9", "z9", "B9", "A9", "isFixHalf", "V9", "", "visibility", "Q9", "L9", "C9", "Lcom/tencent/biz/qqcircle/events/QFSJsGetCurrentHalfPannelStatusEvent;", "event", "F9", "Lcom/tencent/biz/qqcircle/events/QFSJsChangeHalfScreenState;", "E9", "Lcom/tencent/biz/qqcircle/events/QFSJsSupportHalfToFullScreenEvent;", "H9", "Lcom/tencent/biz/qqcircle/events/QFSJsNeedCollapseEvent;", "G9", "isHalf", "O9", "D9", "()Ljava/lang/Integer;", "status", "J9", "I9", "N9", "M9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "getLogTag", "P9", "titleContainerView", "titleOperateView", "Landroid/widget/ImageView;", "garyBarIv", "R9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartResume", "onPartPause", "onBackEvent", "onPartDestroy", "scrollX", "scrollY", "clampedX", "clampedY", "v", "onOverScrolled", "parentView", "Landroid/view/MotionEvent;", "ev", "r7", "k7", "m5", "l0", "", "slideOffset", "defaultHeight", "topSpaceHeight", ICustomDataEditor.NUMBER_PARAM_6, "withAnim", "l", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/biz/qqcircle/half/webview/QFSHalfScreenWebSheetView;", "d", "Lcom/tencent/biz/qqcircle/half/webview/QFSHalfScreenWebSheetView;", "mSheetView", "e", "Landroid/view/View;", "mTitleContainerView", "f", "mTitleOperateView", h.F, "Landroid/widget/ImageView;", "mGaryBarIv", "i", "Ljava/lang/String;", "mEntranceFeedId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "isWebViewOverScrolled", BdhLogUtil.LogTag.Tag_Conn, "isMovingUp", "D", "mIsFullShow", "E", "mIsShowing", UserInfo.SEX_FEMALE, "moveYStart", "G", "mTitleIsShowing", "H", "mWebViewIsTop", "I", "mDisableFixHalfScreen", "J", "mStandardMode", "K", "mIsFixHalf", "<init>", "(Lcom/tencent/biz/qqcircle/half/webview/QFSHalfScreenWebSheetView;)V", "L", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class f extends u implements TouchWebView.OnOverScrolledListener, r30.a, r30.b, SimpleEventReceiver<SimpleBaseEvent> {

    @NotNull
    private static final Map<Integer, Integer> M = new LinkedHashMap();

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isMovingUp;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean mIsFullShow;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean mIsShowing;

    /* renamed from: F, reason: from kotlin metadata */
    private float moveYStart;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean mTitleIsShowing;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean mDisableFixHalfScreen;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean mIsFixHalf;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final QFSHalfScreenWebSheetView mSheetView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mTitleContainerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mTitleOperateView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView mGaryBarIv;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mEntranceFeedId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isWebViewOverScrolled;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean mWebViewIsTop = true;

    /* renamed from: J, reason: from kotlin metadata */
    private int mStandardMode = 3;

    public f(@Nullable QFSHalfScreenWebSheetView qFSHalfScreenWebSheetView) {
        this.mSheetView = qFSHalfScreenWebSheetView;
        A9();
        B9();
    }

    private final void A9() {
        Unit unit;
        QFSHalfScreenWebSheetView qFSHalfScreenWebSheetView = this.mSheetView;
        if (qFSHalfScreenWebSheetView != null) {
            qFSHalfScreenWebSheetView.i(this);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.e(getTAG(), 1, "[addPanelStateListener] sheet view is null");
        }
    }

    private final void B9() {
        Unit unit;
        QFSHalfScreenWebSheetView qFSHalfScreenWebSheetView = this.mSheetView;
        if (qFSHalfScreenWebSheetView != null) {
            qFSHalfScreenWebSheetView.setNestScrollDelegate(this);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.e(getTAG(), 1, "[addSheetViewNestScrollDelegate] sheet view is null");
        }
    }

    private final void C9() {
        Unit unit;
        QFSHalfScreenWebSheetView qFSHalfScreenWebSheetView = this.mSheetView;
        if (qFSHalfScreenWebSheetView != null) {
            QLog.d(getTAG(), 1, "[dismissSheetView] success");
            qFSHalfScreenWebSheetView.k();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.d(getTAG(), 1, "[dismissSheetView] fail, sheet view is null");
        }
    }

    private final Integer D9() {
        WebViewFragment webViewFragment;
        CustomWebView webView;
        IPartHost partHost = getPartHost();
        if (partHost instanceof WebViewFragment) {
            webViewFragment = (WebViewFragment) partHost;
        } else {
            webViewFragment = null;
        }
        if (webViewFragment == null || (webView = webViewFragment.getWebView()) == null) {
            return null;
        }
        return Integer.valueOf(webView.hashCode());
    }

    private final void E9(QFSJsChangeHalfScreenState event) {
        WebViewFragment webViewFragment;
        CustomWebView customWebView;
        Unit unit;
        IPartHost partHost = getPartHost();
        Unit unit2 = null;
        if (partHost instanceof WebViewFragment) {
            webViewFragment = (WebViewFragment) partHost;
        } else {
            webViewFragment = null;
        }
        if (webViewFragment != null) {
            customWebView = webViewFragment.getWebView();
        } else {
            customWebView = null;
        }
        if (customWebView != null) {
            if (customWebView.hashCode() == event.getWebViewHashCode()) {
                QLog.d(getTAG(), 1, "[handleChangeHalfScreenState] state:" + event.getState());
                String state = event.getState();
                if (state != null) {
                    int hashCode = state.hashCode();
                    if (hashCode != 3154575) {
                        if (hashCode != 3194931) {
                            if (hashCode == 94756344 && state.equals("close")) {
                                QFSHalfScreenWebSheetView qFSHalfScreenWebSheetView = this.mSheetView;
                                if (qFSHalfScreenWebSheetView != null) {
                                    qFSHalfScreenWebSheetView.l();
                                }
                            }
                        } else if (state.equals("half")) {
                            QFSHalfScreenWebSheetView qFSHalfScreenWebSheetView2 = this.mSheetView;
                            if (qFSHalfScreenWebSheetView2 != null) {
                                qFSHalfScreenWebSheetView2.j();
                                unit = Unit.INSTANCE;
                            }
                        }
                    } else if (state.equals("full")) {
                        V9(false);
                        QFSHalfScreenWebSheetView qFSHalfScreenWebSheetView3 = this.mSheetView;
                        if (qFSHalfScreenWebSheetView3 != null) {
                            qFSHalfScreenWebSheetView3.m();
                            unit = Unit.INSTANCE;
                        }
                    }
                }
                unit = Unit.INSTANCE;
            } else {
                QLog.e(getTAG(), 1, "[handleChangeHalfScreenState] webView hashCode not equal");
                unit = Unit.INSTANCE;
            }
            unit2 = unit;
        }
        if (unit2 == null) {
            QLog.e(getTAG(), 1, "[handleChangeHalfScreenState] curWebView is null");
        }
    }

    private final void F9(QFSJsGetCurrentHalfPannelStatusEvent event) {
        WebViewFragment webViewFragment;
        CustomWebView customWebView;
        IPartHost partHost = getPartHost();
        Unit unit = null;
        if (partHost instanceof WebViewFragment) {
            webViewFragment = (WebViewFragment) partHost;
        } else {
            webViewFragment = null;
        }
        if (webViewFragment != null) {
            customWebView = webViewFragment.getWebView();
        } else {
            customWebView = null;
        }
        if (customWebView != null) {
            if (customWebView.hashCode() == event.getWebViewHashCode()) {
                QLog.d(getTAG(), 1, "[handleGetCurrentHalfPanelStatusEvent] callback:" + event.getCallBack());
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("status", this.mIsFullShow ? 1 : 0);
                customWebView.callJs(event.getCallBack(), jSONObject.toString());
            } else {
                QLog.e(getTAG(), 1, "[handleGetCurrentHalfPanelStatusEvent] webView hashCode not equal");
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            QLog.e(getTAG(), 1, "[handleGetCurrentHalfPanelStatusEvent] curWebView is null");
        }
    }

    private final void G9(QFSJsNeedCollapseEvent event) {
        WebViewFragment webViewFragment;
        CustomWebView customWebView;
        boolean z16;
        IPartHost partHost = getPartHost();
        Unit unit = null;
        if (partHost instanceof WebViewFragment) {
            webViewFragment = (WebViewFragment) partHost;
        } else {
            webViewFragment = null;
        }
        if (webViewFragment != null) {
            customWebView = webViewFragment.getWebView();
        } else {
            customWebView = null;
        }
        if (customWebView != null) {
            if (customWebView.hashCode() == event.getWebViewHashCode()) {
                if (event.getNeedCollapse() == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16 != this.mWebViewIsTop) {
                    this.mWebViewIsTop = z16;
                    QLog.d(getTAG(), 1, "[handleJsNeedCollapse] is Top changed, mWebViewIsTop:" + this.mWebViewIsTop);
                }
            } else {
                QLog.e(getTAG(), 1, "[handleJsNeedCollapse] webView hashCode not equal");
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            QLog.e(getTAG(), 1, "[handleJsNeedCollapse] curWebView is null");
        }
    }

    private final void H9(QFSJsSupportHalfToFullScreenEvent event) {
        WebViewFragment webViewFragment;
        CustomWebView customWebView;
        IPartHost partHost = getPartHost();
        Unit unit = null;
        if (partHost instanceof WebViewFragment) {
            webViewFragment = (WebViewFragment) partHost;
        } else {
            webViewFragment = null;
        }
        if (webViewFragment != null) {
            customWebView = webViewFragment.getWebView();
        } else {
            customWebView = null;
        }
        if (customWebView != null) {
            if (customWebView.hashCode() == event.getWebViewHashCode()) {
                QLog.d(getTAG(), 1, "[handleSupportHalfToFullScreenEvent] supportHalfToFullScreen:" + event.getSupportHalfToFullScreen() + ", mDisableFixHalfScreen" + this.mDisableFixHalfScreen);
                if (!this.mDisableFixHalfScreen && event.getSupportHalfToFullScreen() == 1) {
                    this.mStandardMode = 1;
                    V9(false);
                    Q9(8);
                }
            } else {
                QLog.e(getTAG(), 1, "[handleSupportHalfToFullScreenEvent] webView hashCode not equal");
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            QLog.e(getTAG(), 1, "[handleSupportHalfToFullScreenEvent] curWebView is null");
        }
    }

    private final boolean I9() {
        if (!J9(3) && !J9(4)) {
            return false;
        }
        return true;
    }

    private final boolean J9(int status) {
        Integer D9 = D9();
        if (D9 != null) {
            int intValue = D9.intValue();
            for (Map.Entry<Integer, Integer> entry : M.entrySet()) {
                int intValue2 = entry.getKey().intValue();
                int intValue3 = entry.getValue().intValue();
                if (intValue2 != intValue && intValue3 == status) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private final void K9() {
        Unit unit;
        Intent intent;
        Activity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            this.mEntranceFeedId = intent.getStringExtra("entranceFeedId");
            QLog.d(getTAG(), 1, "[initParams] feedId:" + this.mEntranceFeedId + ", hashCode" + hashCode());
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.e(getTAG(), 1, "[initParams] intent is null, feedId:null");
        }
    }

    private final boolean L9() {
        if (this.mIsFullShow) {
            if (this.isWebViewOverScrolled && this.mWebViewIsTop) {
                return false;
            }
            return true;
        }
        if (this.isMovingUp) {
            if (this.mWebViewIsTop) {
                return false;
            }
        } else if (this.isWebViewOverScrolled && this.mWebViewIsTop) {
            return false;
        }
        return true;
    }

    private final boolean M9() {
        QFSHalfScreenWebSheetView qFSHalfScreenWebSheetView = this.mSheetView;
        if (qFSHalfScreenWebSheetView != null) {
            return qFSHalfScreenWebSheetView.v();
        }
        return false;
    }

    private final boolean N9() {
        QFSHalfScreenWebSheetView qFSHalfScreenWebSheetView = this.mSheetView;
        if (qFSHalfScreenWebSheetView != null) {
            return qFSHalfScreenWebSheetView.u();
        }
        return false;
    }

    private final void O9(boolean isHalf) {
        WebViewFragment webViewFragment;
        CustomWebView customWebView;
        IPartHost partHost = getPartHost();
        Unit unit = null;
        if (partHost instanceof WebViewFragment) {
            webViewFragment = (WebViewFragment) partHost;
        } else {
            webViewFragment = null;
        }
        if (webViewFragment != null) {
            customWebView = webViewFragment.getWebView();
        } else {
            customWebView = null;
        }
        if (customWebView != null) {
            QLog.d(getTAG(), 1, "[notifyH5HalfStatus] isHalf:" + isHalf);
            if (isHalf) {
                customWebView.callJs("~function(d,e){try{e=d.createEvent('Event');e.initEvent('mqqCircleHalfPannelChanged',true,true);e.isHalf=0;d.dispatchEvent(e)}catch(err){}}(document);");
            } else {
                customWebView.callJs("~function(d,e){try{e=d.createEvent('Event');e.initEvent('mqqCircleHalfPannelChanged',true,true);e.isHalf=1;d.dispatchEvent(e)}catch(err){}}(document);");
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            QLog.e(getTAG(), 1, "[notifyH5HalfStatus] curWebView is null");
        }
    }

    private final void Q9(int visibility) {
        QFSHalfScreenBrowserFragment qFSHalfScreenBrowserFragment;
        IPartHost partHost = getPartHost();
        if (partHost instanceof QFSHalfScreenBrowserFragment) {
            qFSHalfScreenBrowserFragment = (QFSHalfScreenBrowserFragment) partHost;
        } else {
            qFSHalfScreenBrowserFragment = null;
        }
        if (qFSHalfScreenBrowserFragment != null) {
            if (this.mStandardMode != 2) {
                visibility = 8;
            }
            qFSHalfScreenBrowserFragment.Mh(visibility);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(f this$0, View view) {
        QFSHalfScreenWebSheetView qFSHalfScreenWebSheetView;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.mIsFullShow && (qFSHalfScreenWebSheetView = this$0.mSheetView) != null) {
            qFSHalfScreenWebSheetView.l();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void T9(boolean showTitle) {
        boolean z16 = true;
        int i3 = 0;
        if (showTitle) {
            View view = this.mTitleOperateView;
            if (view != null) {
                view.setVisibility(0);
            }
            ImageView imageView = this.mGaryBarIv;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            U9(false);
        } else {
            View view2 = this.mTitleOperateView;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            ImageView imageView2 = this.mGaryBarIv;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            U9(true);
        }
        if (this.mTitleIsShowing != showTitle) {
            Activity activity = getActivity();
            if (activity != null) {
                Window window = activity.getWindow();
                if (!showTitle || QQTheme.isNowThemeIsNight()) {
                    z16 = false;
                }
                RFWImmersiveUtils.setStatusBarTextColor(window, z16);
            }
            View view3 = this.mTitleContainerView;
            if (view3 != null) {
                if (showTitle) {
                    i3 = ie0.a.f().g(getContext(), R.color.qui_common_bg_nav_secondary, 1000);
                }
                view3.setBackgroundColor(i3);
            }
        }
        this.mTitleIsShowing = showTitle;
    }

    private final void U9(boolean rounded) {
        QFSHalfScreenWebSheetView qFSHalfScreenWebSheetView = this.mSheetView;
        if (qFSHalfScreenWebSheetView != null) {
            qFSHalfScreenWebSheetView.A(rounded);
        }
    }

    private final void V9(boolean isFixHalf) {
        if (this.mIsFixHalf == isFixHalf) {
            return;
        }
        QLog.d(getTAG(), 1, "[updateSheetViewFixStatus] isFixHalf:" + isFixHalf);
        QFSHalfScreenWebSheetView qFSHalfScreenWebSheetView = this.mSheetView;
        if (qFSHalfScreenWebSheetView != null) {
            this.mIsFixHalf = isFixHalf;
            qFSHalfScreenWebSheetView.B(isFixHalf);
        }
    }

    private final void z9() {
        WebViewFragment webViewFragment;
        Object obj;
        TouchWebView touchWebView;
        IPartHost partHost = getPartHost();
        Unit unit = null;
        if (partHost instanceof WebViewFragment) {
            webViewFragment = (WebViewFragment) partHost;
        } else {
            webViewFragment = null;
        }
        if (webViewFragment != null) {
            obj = webViewFragment.getWebView();
        } else {
            obj = null;
        }
        if (obj == null) {
            QLog.e(getTAG(), 1, "[addOverScrolledListener] partHost is not WebViewFragment");
            obj = Unit.INSTANCE;
        }
        if (obj instanceof TouchWebView) {
            touchWebView = (TouchWebView) obj;
        } else {
            touchWebView = null;
        }
        if (touchWebView != null) {
            QLog.d(getTAG(), 1, "[addOverScrolledListener] success");
            touchWebView.addOverScrolledListener(this);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            QLog.e(getTAG(), 1, "[addOverScrolledListener] webView not TouchWebView");
        }
    }

    public final void P9() {
        z9();
    }

    public final void R9(@Nullable View titleContainerView, @Nullable View titleOperateView, @Nullable ImageView garyBarIv) {
        this.mGaryBarIv = garyBarIv;
        this.mTitleOperateView = titleOperateView;
        this.mTitleContainerView = titleContainerView;
        if (titleContainerView != null) {
            titleContainerView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.half.webview.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    f.S9(f.this, view);
                }
            });
        }
        View view = this.mTitleOperateView;
        if (view != null) {
            view.setClickable(true);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(QFSJsNeedCollapseEvent.class);
        arrayList.add(QFSJsSupportHalfToFullScreenEvent.class);
        arrayList.add(QFSJsGetCurrentHalfPannelStatusEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSHalfScreenWebPanelManagePart";
    }

    @Override // r30.b
    public void k7() {
        QLog.d(getTAG(), 1, "[showMaxHeight] standardMode:" + this.mStandardMode + ", isFixHalf:" + this.mIsFixHalf);
        if (this.mIsFixHalf) {
            return;
        }
        this.mIsFullShow = true;
        T9(true);
        Q9(8);
        if (!J9(3)) {
            if (this.mEntranceFeedId != null) {
                QFSRecommendPanelStatusEvent qFSRecommendPanelStatusEvent = new QFSRecommendPanelStatusEvent(this.mEntranceFeedId, 2);
                qFSRecommendPanelStatusEvent.enableCropVideoCover = false;
                SimpleEventBus.getInstance().dispatchEvent(qFSRecommendPanelStatusEvent, true);
            }
        } else {
            QLog.e(getTAG(), 1, "[showMaxHeight] has other half in max height, not dispatch panel status event");
        }
        O9(false);
        Integer D9 = D9();
        if (D9 != null) {
            M.put(Integer.valueOf(D9.intValue()), 3);
        }
    }

    @Override // r30.b
    public void l(boolean withAnim) {
        if (!this.mIsShowing) {
            QLog.d(getTAG(), 1, "[dismiss] already dismiss. ");
            return;
        }
        QLog.d(getTAG(), 1, "[dismiss] reset over scrolled:false");
        this.mIsShowing = false;
        this.mIsFullShow = false;
        this.isWebViewOverScrolled = false;
        T9(false);
        Q9(8);
        if (I9()) {
            QLog.e(getTAG(), 1, "[dismiss] has other half in max or default height, not dispatch panel status event");
        } else {
            String str = this.mEntranceFeedId;
            if (str != null) {
                StringsKt__StringsJVMKt.isBlank(str);
                QFSRecommendPanelStatusEvent qFSRecommendPanelStatusEvent = new QFSRecommendPanelStatusEvent(this.mEntranceFeedId, 4);
                qFSRecommendPanelStatusEvent.scene = 1;
                SimpleEventBus.getInstance().dispatchEvent(qFSRecommendPanelStatusEvent, true);
            }
        }
        Integer D9 = D9();
        if (D9 != null) {
            M.put(Integer.valueOf(D9.intValue()), 5);
        }
    }

    @Override // r30.b
    public void l0() {
        QLog.d(getTAG(), 1, "[startShowDefault] reset over scrolled:false");
        this.mIsShowing = true;
        this.mIsFullShow = false;
        this.isWebViewOverScrolled = false;
        Q9(8);
        if (I9()) {
            QLog.e(getTAG(), 1, "[startShowDefault] has other half in max or default height, not dispatch panel status event");
        } else if (this.mEntranceFeedId != null) {
            SimpleEventBus.getInstance().dispatchEvent(new QFSRecommendPanelStatusEvent(this.mEntranceFeedId, 1), true);
        }
    }

    @Override // r30.b
    public void m5() {
        QLog.d(getTAG(), 1, "[showDefaultHeight] reset over scrolled:false");
        this.mIsFullShow = false;
        this.isWebViewOverScrolled = false;
        T9(false);
        Q9(0);
        if (I9()) {
            QLog.e(getTAG(), 1, "[showDefaultHeight] has other half in max or default height, not dispatch start video event");
        } else if (this.mEntranceFeedId != null) {
            SimpleEventBus.getInstance().dispatchEvent(new QFSStartVideoEvent(this.mEntranceFeedId, true), true);
        }
        O9(true);
        Integer D9 = D9();
        if (D9 != null) {
            M.put(Integer.valueOf(D9.intValue()), 4);
        }
    }

    @Override // r30.b
    public void n6(float slideOffset, int defaultHeight, int topSpaceHeight) {
        if (slideOffset > 0.0f) {
            T9(false);
            return;
        }
        if (!I9()) {
            float f16 = (1 + slideOffset) * defaultHeight;
            String str = this.mEntranceFeedId;
            if (str != null) {
                StringsKt__StringsJVMKt.isBlank(str);
                QFSRecommendPanelStatusEvent qFSRecommendPanelStatusEvent = new QFSRecommendPanelStatusEvent(this.mEntranceFeedId, 3);
                qFSRecommendPanelStatusEvent.height = (int) f16;
                qFSRecommendPanelStatusEvent.defaultHeight = defaultHeight;
                qFSRecommendPanelStatusEvent.topSpaceHeight = topSpaceHeight;
                SimpleEventBus.getInstance().dispatchEvent(qFSRecommendPanelStatusEvent, true);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        QLog.d(getTAG(), 1, "[onBackEvent]");
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        K9();
    }

    @Override // com.tencent.biz.ui.TouchWebView.OnOverScrolledListener
    public void onOverScrolled(int scrollX, int scrollY, boolean clampedX, boolean clampedY, @NotNull View v3) {
        Intrinsics.checkNotNullParameter(v3, "v");
        if (scrollY <= 0 && !this.isMovingUp && !this.isWebViewOverScrolled) {
            if (QLog.isDevelopLevel()) {
                QLog.d(getTAG(), 1, "[onOverScrolled] web view over scrolled:true");
            }
            this.isWebViewOverScrolled = true;
        } else if (scrollY > 0 && this.isWebViewOverScrolled) {
            if (QLog.isDevelopLevel()) {
                QLog.d(getTAG(), 1, "[onOverScrolled] web view not over scrolled:false");
            }
            this.isWebViewOverScrolled = false;
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        QFSHalfScreenBrowserFragment qFSHalfScreenBrowserFragment;
        this.mDisableFixHalfScreen = ((com.tencent.mobileqq.webview.swift.injector.c) aa.k(com.tencent.mobileqq.webview.swift.injector.c.class)).isSwitchOn("qqcircle_disable_web_view_fixed_half", false);
        IPartHost partHost = getPartHost();
        Unit unit = null;
        if (partHost instanceof QFSHalfScreenBrowserFragment) {
            qFSHalfScreenBrowserFragment = (QFSHalfScreenBrowserFragment) partHost;
        } else {
            qFSHalfScreenBrowserFragment = null;
        }
        if (qFSHalfScreenBrowserFragment != null) {
            if (Intrinsics.areEqual(qFSHalfScreenBrowserFragment.Hh(), Boolean.TRUE)) {
                this.mStandardMode = 2;
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            QLog.e(getTAG(), 1, "[onPartCreate] partHost is not QFSHalfScreenBrowserFragment");
        }
        QLog.d(getTAG(), 1, "[onPartCreate] disableFixHalfScreen:" + this.mDisableFixHalfScreen + ", standardMode:" + this.mStandardMode);
        if (this.mStandardMode == 3) {
            if (this.mDisableFixHalfScreen) {
                this.mStandardMode = 0;
            } else {
                V9(true);
            }
        }
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        QLog.d(getTAG(), 1, "[onPartDestroy]");
        C9();
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartPause(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        QLog.d(getTAG(), 1, "[onPartPause]");
        if (N9()) {
            SimpleEventBus.getInstance().dispatchEvent(new QFSStartVideoEvent(this.mEntranceFeedId, false), true);
        }
        super.onPartPause(activity);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartResume(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        boolean J9 = J9(3);
        QLog.d(getTAG(), 1, "[onPartResume] is has other half in max height:" + J9);
        if (this.mIsFirstResume && !M9() && !J9 && J9(4)) {
            QLog.d(getTAG(), 1, "[onPartResume] first resume, dispatch start video event");
            SimpleEventBus.getInstance().dispatchEvent(new QFSStartVideoEvent(this.mEntranceFeedId, true), true);
        } else if (N9() && !J9) {
            SimpleEventBus.getInstance().dispatchEvent(new QFSStartVideoEvent(this.mEntranceFeedId, true), true);
        }
        super.onPartResume(activity);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof QFSJsNeedCollapseEvent) {
            G9((QFSJsNeedCollapseEvent) event);
            return;
        }
        if (event instanceof QFSJsSupportHalfToFullScreenEvent) {
            H9((QFSJsSupportHalfToFullScreenEvent) event);
        } else if (event instanceof QFSJsGetCurrentHalfPannelStatusEvent) {
            F9((QFSJsGetCurrentHalfPannelStatusEvent) event);
        } else if (event instanceof QFSJsChangeHalfScreenState) {
            E9((QFSJsChangeHalfScreenState) event);
        }
    }

    @Override // r30.a
    public boolean p2(@Nullable View view, @Nullable MotionEvent motionEvent) {
        return a.C11111a.a(this, view, motionEvent);
    }

    @Override // r30.a
    public boolean r7(@Nullable View parentView, @Nullable MotionEvent ev5) {
        Integer num;
        if (ev5 != null) {
            num = Integer.valueOf(ev5.getActionMasked());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 0) {
            this.moveYStart = ev5.getY();
            this.isMovingUp = false;
        } else if (num != null && num.intValue() == 2 && ev5.getY() - this.moveYStart < 0.0f) {
            if (this.isWebViewOverScrolled) {
                QLog.d(getTAG(), 1, "[isChildInterceptTouchEvent] moving up, reset over scrolled:false");
                this.isWebViewOverScrolled = false;
            }
            this.isMovingUp = true;
        }
        if (num == null || num.intValue() != 2) {
            return false;
        }
        return L9();
    }
}

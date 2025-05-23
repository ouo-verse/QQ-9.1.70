package com.tencent.mobileqq.ark.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.Constants;
import com.tencent.ark.ark;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.live2.impl.V2TXLiveProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.activity.history.NTChatHistoryMsgForwardSingleton;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.f;
import com.tencent.mobileqq.ark.module.b;
import com.tencent.mobileqq.ark.share.ShareArkView;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkMsgUtils;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.i;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.forward.NtMsgForwardUtils;
import com.tencent.ttpic.util.GsonUtils;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import com.tencent.util.QQCustomArkDialogUtil;
import java.io.File;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 j2\u00020\u0001:\u0002klB'\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010f\u001a\u0004\u0018\u00010e\u0012\b\b\u0002\u0010g\u001a\u00020\u0002\u00a2\u0006\u0004\bh\u0010iJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u001c\u0010\r\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0016\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0006\u0010\u0016\u001a\u00020\u0004J\b\u0010\u0017\u001a\u00020\u0004H\u0014J\u0018\u0010\u001a\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018J\u0010\u0010\u001c\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u0018J\u0010\u0010\u001e\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u0018R$\u0010&\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010-\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u00105\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u0010;\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010>\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u00106\u001a\u0004\b<\u00108\"\u0004\b=\u0010:R\"\u0010A\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u00106\u001a\u0004\b?\u00108\"\u0004\b@\u0010:R\"\u0010E\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u00106\u001a\u0004\bC\u00108\"\u0004\bD\u0010:R\"\u0010I\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bF\u00106\u001a\u0004\bG\u00108\"\u0004\bH\u0010:R\"\u0010M\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bJ\u00106\u001a\u0004\bK\u00108\"\u0004\bL\u0010:R\"\u0010Q\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bN\u00106\u001a\u0004\bO\u00108\"\u0004\bP\u0010:R\u0016\u0010T\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010V\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010SR\u0016\u0010W\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010SR\u001e\u0010\\\u001a\n\u0012\u0004\u0012\u00020Y\u0018\u00010X8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0014\u0010`\u001a\u00020]8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0014\u0010d\u001a\u00020a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bb\u0010c\u00a8\u0006m"}, d2 = {"Lcom/tencent/mobileqq/ark/share/ShareArkView;", "Landroid/widget/FrameLayout;", "", "state", "", "p", "Lcom/tencent/mobileqq/ark/share/ShareArkView$a;", "info", "Landroid/os/Bundle;", "bundle", "Lcom/tencent/mobileqq/activity/aio/item/ArkAppContainer;", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "l", "Landroid/content/Context;", "context", DomainData.DOMAIN_NAME, "Landroid/view/MotionEvent;", "event", "", "onTouchEvent", h.F, NodeProps.ON_DETACHED_FROM_WINDOW, "", "arkAppName", "j", "url", "k", "filePath", "i", "Lcom/tencent/mobileqq/activity/aio/item/ArkAppView;", "d", "Lcom/tencent/mobileqq/activity/aio/item/ArkAppView;", "getMArkView", "()Lcom/tencent/mobileqq/activity/aio/item/ArkAppView;", "setMArkView", "(Lcom/tencent/mobileqq/activity/aio/item/ArkAppView;)V", "mArkView", "e", "Lcom/tencent/mobileqq/activity/aio/item/ArkAppContainer;", "getMAppContainer", "()Lcom/tencent/mobileqq/activity/aio/item/ArkAppContainer;", "setMAppContainer", "(Lcom/tencent/mobileqq/activity/aio/item/ArkAppContainer;)V", "mAppContainer", "Lcom/tencent/mobileqq/activity/aio/item/ArkAppLoadLayout;", "f", "Lcom/tencent/mobileqq/activity/aio/item/ArkAppLoadLayout;", "getMArkLoadLayout", "()Lcom/tencent/mobileqq/activity/aio/item/ArkAppLoadLayout;", "setMArkLoadLayout", "(Lcom/tencent/mobileqq/activity/aio/item/ArkAppLoadLayout;)V", "mArkLoadLayout", "I", "getMaxHight", "()I", "setMaxHight", "(I)V", "maxHight", "getMinWidth", "setMinWidth", NodeProps.MIN_WIDTH, "getMinHight", "setMinHight", "minHight", BdhLogUtil.LogTag.Tag_Conn, "getMWidth", "setMWidth", "mWidth", "D", "getArkapp_width_fromsdk", "setArkapp_width_fromsdk", "arkapp_width_fromsdk", "E", "getArkapp_height_fromsdk", "setArkapp_height_fromsdk", "arkapp_height_fromsdk", UserInfo.SEX_FEMALE, "getAdjustHeight", "setAdjustHeight", "adjustHeight", "G", "Z", "outsideShowDialog", "H", "arkViewLoadFinish", "alreadyShowDialog", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "J", "Ljava/lang/ref/WeakReference;", "mActivityRef", "Lcom/tencent/mobileqq/activity/aio/item/ArkAppContainer$b;", "K", "Lcom/tencent/mobileqq/activity/aio/item/ArkAppContainer$b;", "mCallback", "Lcom/tencent/ark/ArkViewImplement$LoadCallback;", "L", "Lcom/tencent/ark/ArkViewImplement$LoadCallback;", "mLoadCallback", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "M", "a", "b", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class ShareArkView extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private int mWidth;

    /* renamed from: D, reason: from kotlin metadata */
    private int arkapp_width_fromsdk;

    /* renamed from: E, reason: from kotlin metadata */
    private int arkapp_height_fromsdk;

    /* renamed from: F, reason: from kotlin metadata */
    private int adjustHeight;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean outsideShowDialog;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean arkViewLoadFinish;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean alreadyShowDialog;

    /* renamed from: J, reason: from kotlin metadata */
    private WeakReference<Activity> mActivityRef;

    /* renamed from: K, reason: from kotlin metadata */
    private final ArkAppContainer.b mCallback;

    /* renamed from: L, reason: from kotlin metadata */
    private final ArkViewImplement.LoadCallback mLoadCallback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ArkAppView mArkView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ArkAppContainer mAppContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ArkAppLoadLayout mArkLoadLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int maxHight;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int minWidth;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int minHight;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 *2\u00020\u0001:\u0001\u0003B\u000f\u0012\u0006\u0010'\u001a\u00020&\u00a2\u0006\u0004\b(\u0010)R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\u0010\u0010\bR$\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR\"\u0010\u001b\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\"\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001d\u0010\u001f\"\u0004\b \u0010!R\"\u0010%\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\b\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/ark/share/ShareArkView$a;", "", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setAppName", "(Ljava/lang/String;)V", "appName", "c", "setAppView", QQCustomArkDialogUtil.APP_VIEW, "d", "setBizSrc", ark.APP_SPECIFIC_BIZSRC, "setAppMinVersion", QQCustomArkDialogUtil.APP_MIN_VERSION, "e", V2TXLiveProperty.kV2SetMetaData, QQCustomArkDialogUtil.META_DATA, "", "f", UserInfo.SEX_FEMALE, "()F", h.F, "(F)V", "scale", "Lcom/tencent/mobileqq/activity/aio/SessionInfo;", "g", "Lcom/tencent/mobileqq/activity/aio/SessionInfo;", "()Lcom/tencent/mobileqq/activity/aio/SessionInfo;", "setSession", "(Lcom/tencent/mobileqq/activity/aio/SessionInfo;)V", SessionDbHelper.SESSION_ID, "getTitle", "setTitle", "title", "Landroid/os/Bundle;", "bundle", "<init>", "(Landroid/os/Bundle;)V", "i", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private String appName;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private String appView;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private String bizSrc;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private String appMinVersion;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private String metaData;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private float scale;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private SessionInfo session;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private String title;

        public a(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            this.appName = bundle.getString("appName");
            this.appView = bundle.getString(QQCustomArkDialogUtil.APP_VIEW);
            this.bizSrc = bundle.getString(QQCustomArkDialogUtil.BIZ_SRC);
            this.appMinVersion = bundle.getString(QQCustomArkDialogUtil.APP_MIN_VERSION);
            this.metaData = bundle.getString(QQCustomArkDialogUtil.META_DATA);
            this.scale = bundle.getFloat("scale", 1.0f);
            this.session = new SessionInfo();
            this.title = "";
            String string = bundle.getString("troop_uin");
            if (string != null) {
                SessionInfo sessionInfo = this.session;
                if (sessionInfo != null) {
                    sessionInfo.f179555d = 1;
                }
                if (sessionInfo == null) {
                    return;
                }
                sessionInfo.f179557e = string;
            }
        }

        /* renamed from: a, reason: from getter */
        public final String getAppMinVersion() {
            return this.appMinVersion;
        }

        /* renamed from: b, reason: from getter */
        public final String getAppName() {
            return this.appName;
        }

        /* renamed from: c, reason: from getter */
        public final String getAppView() {
            return this.appView;
        }

        /* renamed from: d, reason: from getter */
        public final String getBizSrc() {
            return this.bizSrc;
        }

        /* renamed from: e, reason: from getter */
        public final String getMetaData() {
            return this.metaData;
        }

        /* renamed from: f, reason: from getter */
        public final float getScale() {
            return this.scale;
        }

        /* renamed from: g, reason: from getter */
        public final SessionInfo getSession() {
            return this.session;
        }

        public final void h(float f16) {
            this.scale = f16;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/ark/share/ShareArkView$c", "Lcom/tencent/mobileqq/activity/aio/item/ArkAppContainer$b;", "Lcom/tencent/mobileqq/activity/aio/item/ArkAppContainer;", "containerWrapper", "", "view", PublicAccountMessageUtilImpl.META_NAME, "", "U1", "Fb", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class c implements ArkAppContainer.b {
        c() {
        }

        @Override // com.tencent.mobileqq.activity.aio.item.ArkAppContainer.b
        public boolean Fb(ArkAppContainer containerWrapper) {
            Intrinsics.checkNotNullParameter(containerWrapper, "containerWrapper");
            return false;
        }

        @Override // com.tencent.mobileqq.activity.aio.item.ArkAppContainer.b
        public boolean U1(ArkAppContainer containerWrapper, String view, String meta) {
            Intrinsics.checkNotNullParameter(containerWrapper, "containerWrapper");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(meta, "meta");
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/ark/share/ShareArkView$d", "Lcom/tencent/ark/ArkViewImplement$LoadCallback;", "", "state", "errorCode", "", "msg", "", "canRetry", "", "onLoadFailed", "onLoadState", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class d implements ArkViewImplement.LoadCallback {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(WeakReference weakSelf, int i3) {
            Intrinsics.checkNotNullParameter(weakSelf, "$weakSelf");
            ShareArkView shareArkView = (ShareArkView) weakSelf.get();
            if (shareArkView == null) {
                return;
            }
            shareArkView.p(i3);
        }

        @Override // com.tencent.ark.ArkViewImplement.LoadCallback
        public void onLoadFailed(int state, int errorCode, String msg2, boolean canRetry) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            onLoadState(state);
        }

        @Override // com.tencent.ark.ArkViewImplement.LoadCallback
        public void onLoadState(final int state) {
            final WeakReference weakReference = new WeakReference(ShareArkView.this);
            ThreadManager.getUIHandler().post(new Runnable() { // from class: o91.f
                @Override // java.lang.Runnable
                public final void run() {
                    ShareArkView.d.b(weakReference, state);
                }
            });
            if (state == 0) {
                return;
            }
            ShareArkView.this.arkViewLoadFinish = true;
            if (QLog.isColorLevel()) {
                QLog.d("ShareArkView", 2, "arkView init finish,load state = ", Integer.valueOf(state), ";outsideShowDialog = ", Boolean.valueOf(ShareArkView.this.outsideShowDialog), ";alreadyShowDialog:", Boolean.valueOf(ShareArkView.this.alreadyShowDialog));
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShareArkView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void l(a info, Bundle bundle) {
        Intent intent;
        if (ArkMsgUtils.isMultiMsg(info.getAppName(), info.getAppView())) {
            cb1.c cVar = (cb1.c) GsonUtils.json2Obj(info.getMetaData(), cb1.c.class);
            if ((cVar != null ? cVar.detail : null) != null && !cVar.detail.news.isEmpty()) {
                Activity resumeActivity = MobileQQ.sMobileQQ.getResumeActivity();
                if (resumeActivity == null || (intent = resumeActivity.getIntent()) == null) {
                    return;
                }
                String str = cVar.detail.source;
                if (!TextUtils.isEmpty(str)) {
                    intent.putExtra(AppConstants.Key.FORWARD_NT_PREVIEW_MINIAIO_TITLE, str);
                }
                Intent intent2 = resumeActivity.getIntent();
                Intrinsics.checkNotNullExpressionValue(intent2, "activity.intent");
                NtMsgForwardUtils.q(resumeActivity, intent2);
                NTChatHistoryMsgForwardSingleton nTChatHistoryMsgForwardSingleton = NTChatHistoryMsgForwardSingleton.INSTANCE;
                Intent intent3 = resumeActivity.getIntent();
                Intrinsics.checkNotNullExpressionValue(intent3, "activity.intent");
                nTChatHistoryMsgForwardSingleton.previewForwardMsg(resumeActivity, intent3);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("ShareArkView", 1, "handleMultiMsgPreview fail, meta err: " + info.getMetaData());
            }
        }
    }

    private final void m(Bundle bundle) {
        a aVar = new a(bundle);
        aVar.h(f.c());
        ArkAppContainer g16 = g(aVar, bundle);
        if (g16 != null) {
            g16.a(this.mCallback);
        }
        if (QLog.isColorLevel()) {
            QLog.w("QQCustomArkDialog", 2, "init");
        }
        ArkAppView arkAppView = this.mArkView;
        if (arkAppView != null) {
            arkAppView.a(g16, this.mArkLoadLayout);
        }
        q(aVar, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(ShareArkView this$0, Bundle bundle) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bundle, "$bundle");
        WeakReference<Activity> weakReference = this$0.mActivityRef;
        Activity activity = null;
        if (weakReference != null && weakReference != null) {
            activity = weakReference.get();
        }
        if (activity != null && !activity.isFinishing()) {
            this$0.m(bundle);
        } else {
            QLog.e("ShareArkView", 1, "init bundle activity is null or finished");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(int state) {
        WeakReference<Activity> weakReference = this.mActivityRef;
        Activity activity = (weakReference == null || weakReference == null) ? null : weakReference.get();
        if (activity == null || activity.isFinishing()) {
            QLog.d("ShareArkView", 1, "onLoadFinish.right now activity is null or finished");
            return;
        }
        if (state != 1) {
            ArkAppLoadLayout arkAppLoadLayout = this.mArkLoadLayout;
            ViewGroup.LayoutParams layoutParams = arkAppLoadLayout != null ? arkAppLoadLayout.getLayoutParams() : null;
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.addRule(14);
            int i3 = this.mWidth;
            layoutParams2.width = i3;
            layoutParams2.height = i3;
            layoutParams2.setMargins(0, 0, 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean r(ShareArkView this$0, a aVar, Bundle bundle, View view, MotionEvent event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getAction() != 0) {
            return true;
        }
        this$0.l(aVar, bundle);
        return true;
    }

    public final void h() {
        ArkAppContainer arkAppContainer = this.mAppContainer;
        if (arkAppContainer != null) {
            arkAppContainer.doOnEvent(2);
        }
        b.f199564k = true;
    }

    public final String i(String filePath) {
        int lastIndexOf$default;
        if (filePath == null || TextUtils.isEmpty(filePath)) {
            return "";
        }
        String separator = File.separator;
        Intrinsics.checkNotNullExpressionValue(separator, "separator");
        lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) filePath, separator, 0, false, 6, (Object) null);
        if (lastIndexOf$default == -1) {
            return filePath;
        }
        String substring = filePath.substring(lastIndexOf$default + 1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        return substring;
    }

    public final void n(Context context, final Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        View inflate = LayoutInflater.from(context).inflate(R.layout.f167726f7, this);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.\u2026at_item_for_arkapp, this)");
        inflate.setPadding(1, 1, 1, 1);
        setBackgroundResource(R.drawable.f159656rq);
        View findViewById = inflate.findViewById(R.id.y_);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type com.tencent.mobileqq.activity.aio.item.ArkAppView");
        this.mArkView = (ArkAppView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.eet);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout");
        this.mArkLoadLayout = (ArkAppLoadLayout) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.f164471yu);
        ViewGroup.LayoutParams layoutParams = findViewById3.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        ((RelativeLayout.LayoutParams) layoutParams).addRule(14);
        findViewById3.setPadding(0, 0, 0, 0);
        View findViewById4 = inflate.findViewById(R.id.f164456yf);
        Intrinsics.checkNotNull(findViewById4, "null cannot be cast to non-null type android.widget.LinearLayout");
        ((LinearLayout) findViewById4).setVisibility(8);
        ArkAppView arkAppView = this.mArkView;
        if (arkAppView != null) {
            arkAppView.setBorderType(0);
        }
        ArkAppView arkAppView2 = this.mArkView;
        if (arkAppView2 != null) {
            arkAppView2.setLoadCallback(this.mLoadCallback);
        }
        boolean z16 = bundle.getBoolean("is_ark_display_share", false);
        if (QLog.isColorLevel()) {
            QLog.d("QQCustomArkDialog", 2, "from Forward:" + z16);
        }
        ArkAppMessage.Config config = new ArkAppMessage.Config();
        String string = bundle.getString(AppConstants.Key.FORWARD_ARK_APP_CONFIG);
        if (!TextUtils.isEmpty(string)) {
            config.fromString(string);
        }
        if (ArkFullScreenAppActivity.T2(bundle) && Intrinsics.areEqual(IndividuationUrlHelper.UrlId.CARD_HOME, config.type)) {
            this.adjustHeight = f.f199481a;
        }
        if (MessageForArkApp.isSetSizeByConfig(config)) {
            float c16 = f.c();
            Integer num = config.width;
            Intrinsics.checkNotNullExpressionValue(num, "config.width");
            int intValue = num.intValue();
            Integer num2 = config.height;
            Intrinsics.checkNotNullExpressionValue(num2, "config.height");
            MessageForArkApp.Size limitToSizeRange = MessageForArkApp.limitToSizeRange(c16, intValue, num2.intValue());
            this.arkapp_width_fromsdk = limitToSizeRange.width;
            Integer num3 = config.autoSize;
            if (num3 != null && num3 != null && num3.intValue() == 1) {
                this.arkapp_width_fromsdk = f.f199481a;
            }
            this.arkapp_height_fromsdk = limitToSizeRange.height;
            if (QLog.isColorLevel()) {
                float c17 = f.c();
                Integer num4 = config.width;
                Integer num5 = config.height;
                QLog.d("QQCustomArkDialog", 2, "width_from_sdk:" + num4 + ", height_from_sdk:" + num5 + ", scale:" + c17 + ", realwidth:" + ((int) (limitToSizeRange.width / c17)) + ", realheight:" + ((int) (limitToSizeRange.height / c17)));
            }
        }
        new LinearLayout.LayoutParams(-1, -2).setMargins(1, 1, 1, 1);
        this.maxHight = MessageForArkApp.dp2px(390.0f);
        this.minWidth = MessageForArkApp.dp2px(30.0f);
        this.minHight = MessageForArkApp.dp2px(30.0f);
        this.mWidth = context.getResources().getDimensionPixelSize(R.dimen.f158688md) - 0;
        ArkAppLoadLayout arkAppLoadLayout = this.mArkLoadLayout;
        ViewGroup.LayoutParams layoutParams2 = arkAppLoadLayout != null ? arkAppLoadLayout.getLayoutParams() : null;
        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) layoutParams2;
        layoutParams3.addRule(14);
        int i3 = this.mWidth;
        layoutParams3.width = i3;
        layoutParams3.height = i3;
        layoutParams3.setMargins(0, 0, 0, 0);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: o91.d
            @Override // java.lang.Runnable
            public final void run() {
                ShareArkView.o(ShareArkView.this, bundle);
            }
        });
        ArkAppView arkAppView3 = this.mArkView;
        if (arkAppView3 != null) {
            View rootView = arkAppView3 != null ? arkAppView3.getRootView() : null;
            Intrinsics.checkNotNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
            arkAppView3.setInputHolderAnchor((ViewGroup) rootView);
        }
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            this.mActivityRef = new WeakReference<>(activity);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        ArkAppView arkAppView = this.mArkView;
        if (arkAppView == null) {
            return super.onTouchEvent(event);
        }
        if (event.getAction() == 0) {
            float f16 = 10;
            if (event.getX() < arkAppView.getX() - f16 || event.getX() > arkAppView.getX() + arkAppView.getWidth() + f16 || event.getY() < arkAppView.getY() - f16 || event.getY() > arkAppView.getY() + arkAppView.getHeight() + f16) {
                ArkViewImplement arkViewImplement = arkAppView.mViewImpl;
                if (arkViewImplement == null) {
                    return super.onTouchEvent(event);
                }
                arkViewImplement.resetInputState();
                Object systemService = arkAppView.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                ((InputMethodManager) systemService).hideSoftInputFromWindow(arkAppView.getWindowToken(), 0);
            }
        }
        return super.onTouchEvent(event);
    }

    public final void setAdjustHeight(int i3) {
        this.adjustHeight = i3;
    }

    public final void setArkapp_height_fromsdk(int i3) {
        this.arkapp_height_fromsdk = i3;
    }

    public final void setArkapp_width_fromsdk(int i3) {
        this.arkapp_width_fromsdk = i3;
    }

    public final void setMAppContainer(ArkAppContainer arkAppContainer) {
        this.mAppContainer = arkAppContainer;
    }

    public final void setMArkLoadLayout(ArkAppLoadLayout arkAppLoadLayout) {
        this.mArkLoadLayout = arkAppLoadLayout;
    }

    public final void setMArkView(ArkAppView arkAppView) {
        this.mArkView = arkAppView;
    }

    public final void setMWidth(int i3) {
        this.mWidth = i3;
    }

    public final void setMaxHight(int i3) {
        this.maxHight = i3;
    }

    public final void setMinHight(int i3) {
        this.minHight = i3;
    }

    public final void setMinWidth(int i3) {
        this.minWidth = i3;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShareArkView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ShareArkView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    public final String k(String url) {
        boolean contains$default;
        boolean contains$default2;
        String replace$default;
        String str = url == null ? "" : url;
        if (TextUtils.isEmpty(url)) {
            return str;
        }
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "http://", false, 2, (Object) null);
        if (contains$default) {
            str = StringsKt__StringsJVMKt.replace$default(str, "http://", "", false, 4, (Object) null);
        }
        String str2 = str;
        contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) str2, (CharSequence) "https://", false, 2, (Object) null);
        if (!contains$default2) {
            return str2;
        }
        replace$default = StringsKt__StringsJVMKt.replace$default(str2, "https://", "", false, 4, (Object) null);
        return replace$default;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareArkView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.adjustHeight = -1;
        this.mCallback = new c();
        this.mLoadCallback = new d();
    }

    private final ArkAppContainer g(a info, Bundle bundle) {
        int i3;
        int i16;
        this.mAppContainer = new ArkAppContainer();
        ArkAppView arkAppView = this.mArkView;
        Integer valueOf = arkAppView != null ? Integer.valueOf(arkAppView.getWidth()) : null;
        ArkAppView arkAppView2 = this.mArkView;
        Integer valueOf2 = arkAppView2 != null ? Integer.valueOf(arkAppView2.getHeight()) : null;
        if (QLog.isDebugVersion()) {
            QLog.d("ShareArkView", 4, "w=" + valueOf + ",h=" + valueOf2 + ", appName:" + info.getAppName());
        }
        int i17 = bundle.getInt(AppConstants.Key.SHARE_REQ_TYPE);
        if (ArkFullScreenAppActivity.T2(bundle)) {
            ArkAppContainer arkAppContainer = this.mAppContainer;
            if (arkAppContainer != null) {
                arkAppContainer.h(info.getAppName(), info.getAppView(), info.getBizSrc(), info.getAppMinVersion(), info.getMetaData(), info.getScale(), info.getSession());
            }
        } else {
            String j3 = j(bundle, "com.tencent.structmsg");
            if (QLog.isColorLevel()) {
                QLog.d("ShareArkView", 2, ",metaData=" + j3);
            }
            ArkAppContainer arkAppContainer2 = this.mAppContainer;
            if (arkAppContainer2 != null) {
                arkAppContainer2.h("com.tencent.structmsg", i.b(i17), "", Constants.DEFAULT_MIN_APP_VERSION, j3, f.c(), info.getSession());
            }
        }
        int i18 = this.arkapp_width_fromsdk;
        if (i18 != 0 && (i16 = this.mWidth) != 0 && i18 > i16) {
            if (QLog.isColorLevel()) {
                QLog.d("ShareArkView", 2, "arkapp_width_fromsdk -> mWidth :" + this.arkapp_width_fromsdk + " -> " + this.mWidth);
            }
            this.arkapp_width_fromsdk = this.mWidth;
        }
        int i19 = this.arkapp_width_fromsdk;
        if (i19 != 0 && (i3 = this.arkapp_height_fromsdk) != 0) {
            ArkAppContainer arkAppContainer3 = this.mAppContainer;
            if (arkAppContainer3 != null) {
                arkAppContainer3.setFixSize(i19, i3);
            }
        } else {
            ArkAppContainer arkAppContainer4 = this.mAppContainer;
            if (arkAppContainer4 != null) {
                arkAppContainer4.setFixSize(this.mWidth, this.adjustHeight);
            }
            ArkAppContainer arkAppContainer5 = this.mAppContainer;
            if (arkAppContainer5 != null) {
                arkAppContainer5.setMaxSize(this.mWidth, this.maxHight);
            }
            ArkAppContainer arkAppContainer6 = this.mAppContainer;
            if (arkAppContainer6 != null) {
                arkAppContainer6.setMinSize(this.minWidth, this.minHight);
            }
        }
        b.f199564k = false;
        return this.mAppContainer;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x018c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String j(Bundle bundle, String arkAppName) {
        JSONObject jSONObject;
        String jSONObject2;
        String replace$default;
        String str;
        long j3;
        String str2;
        String str3;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        String str4;
        int i3;
        int i16;
        String str5;
        JSONObject jSONObject5;
        boolean z16;
        int i17;
        char c16;
        boolean contains$default;
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        int i18 = bundle.getInt(AppConstants.Key.SHARE_REQ_TYPE);
        long j16 = bundle.getLong("req_share_id");
        String string = bundle.getString("title");
        String string2 = bundle.getString("desc");
        String string3 = bundle.getString(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_URL);
        String string4 = bundle.getString(AppConstants.Key.SHARE_REQ_IMAGE_REMOTE_URL);
        String string5 = bundle.getString("image_url");
        bundle.getString(AppConstants.Key.SHARE_RES_PKG_NAME);
        String string6 = bundle.getString(AppConstants.Key.SHARE_REQ_AUDIO_URL);
        String string7 = bundle.getString("app_name");
        JSONObject jSONObject6 = new JSONObject();
        JSONObject jSONObject7 = new JSONObject();
        try {
            jSONObject7.put("title", string);
            if (i18 == 2) {
                string6 = k(string6);
                jSONObject7.put("musicUrl", string6);
                str = "music";
            } else if (i18 == 4) {
                str = "video";
            } else {
                str = "news";
            }
            if (TextUtils.isEmpty(string2)) {
                j3 = j16;
                str2 = "video";
                str3 = string6;
                jSONObject3 = jSONObject7;
                jSONObject4 = jSONObject6;
                str4 = string5;
                i3 = 4;
                i16 = 1;
            } else {
                if (string2 == null) {
                    str2 = "video";
                    jSONObject5 = jSONObject7;
                    z16 = false;
                    i17 = 1;
                    c16 = 2;
                } else {
                    String qqStr = HardCodeUtil.qqStr(R.string.qnz);
                    Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.qqstr_qqcustom_82b85728)");
                    str2 = "video";
                    jSONObject5 = jSONObject7;
                    z16 = false;
                    c16 = 2;
                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) string2, (CharSequence) qqStr, false, 2, (Object) null);
                    i17 = 1;
                    if (contains$default) {
                        z16 = true;
                    }
                }
                if (z16) {
                    String qqStr2 = HardCodeUtil.qqStr(R.string.f172427qo3);
                    Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(R.string.qqstr_qqcustom_c49aa6c3)");
                    str3 = string6;
                    jSONObject3 = jSONObject5;
                    jSONObject4 = jSONObject6;
                    j3 = j16;
                    i16 = i17;
                    str4 = string5;
                    i3 = 4;
                    try {
                        string2 = StringsKt__StringsJVMKt.replace$default(string2, qqStr2, "", false, 4, (Object) null);
                    } catch (Exception e16) {
                        e = e16;
                        jSONObject = jSONObject4;
                        if (QLog.isColorLevel()) {
                            QLog.e("QQCustomArkDialog", 2, e.toString());
                        }
                        jSONObject2 = jSONObject.toString();
                        Intrinsics.checkNotNullExpressionValue(jSONObject2, "metaObject.toString()");
                        if (TextUtils.isEmpty(jSONObject2)) {
                        }
                    }
                } else {
                    str3 = string6;
                    jSONObject4 = jSONObject6;
                    str4 = string5;
                    jSONObject3 = jSONObject5;
                    j3 = j16;
                    i16 = i17;
                    i3 = 4;
                }
            }
            jSONObject3.put("desc", string2);
            if (TextUtils.isEmpty(string4)) {
                if (TextUtils.isEmpty(str4)) {
                    string4 = "";
                } else {
                    String str6 = str4;
                    String i19 = i(str6);
                    FileUtils.copyFile(str6, ArkEnvironmentManager.getInstance().getAppResPath(arkAppName) + File.separator + i19);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("res:");
                    sb5.append(i19);
                    string4 = sb5.toString();
                }
            }
            jSONObject3.put("preview", string4);
            jSONObject3.put("tag", string7);
            if (i18 != 2) {
                str5 = i18 != i3 ? str : str2;
            } else {
                jSONObject3.put("musicUrl", str3);
                str5 = "music";
            }
            jSONObject3.put(WadlProxyConsts.KEY_JUMP_URL, k(string3));
            jSONObject3.put("appid", j3);
            jSONObject3.put("app_type", i16);
            jSONObject = jSONObject4;
        } catch (Exception e17) {
            e = e17;
            jSONObject = jSONObject6;
        }
        try {
            jSONObject.put(str5, jSONObject3);
        } catch (Exception e18) {
            e = e18;
            if (QLog.isColorLevel()) {
            }
            jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "metaObject.toString()");
            if (TextUtils.isEmpty(jSONObject2)) {
            }
        }
        jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "metaObject.toString()");
        if (TextUtils.isEmpty(jSONObject2)) {
            return jSONObject2;
        }
        replace$default = StringsKt__StringsJVMKt.replace$default(jSONObject2, "\\/", "/", false, 4, (Object) null);
        return replace$default;
    }

    private final void q(final a info, final Bundle bundle) {
        ArkAppView arkAppView;
        if (info == null || bundle == null || !ArkMsgUtils.isMultiMsg(info.getAppName(), info.getAppView()) || (arkAppView = this.mArkView) == null) {
            return;
        }
        arkAppView.setOnTouchListener(new View.OnTouchListener() { // from class: o91.e
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean r16;
                r16 = ShareArkView.r(ShareArkView.this, info, bundle, view, motionEvent);
                return r16;
            }
        });
    }
}

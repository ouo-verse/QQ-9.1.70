package com.tencent.timi.game.liveroom.impl.room.pendant.webview;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.api.halfweb.IQQLiveHalfWebHelperApi;
import com.tencent.mobileqq.qqlive.api.login.ILiveLoginApi;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback;
import com.tencent.mobileqq.qqlive.callback.message.IQQLiveMessageCallback;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qqlive.login.LiveLoginInfo;
import com.tencent.mobileqq.qqlive.sail.SailAudienceRoomManager;
import com.tencent.mobileqq.qqlive.webview.LiveWebDialogEvent;
import com.tencent.mobileqq.qqlive.webview.SendPendantData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.timi.game.api.ITimiGameApi;
import com.tencent.timi.game.api.auth.AuthScene;
import com.tencent.timi.game.liveroom.impl.room.anchor.UserSelfSendMsgEvent;
import com.tencent.timi.game.liveroom.impl.room.follow.TGLiveFollowManager;
import com.tencent.timi.game.liveroom.impl.room.input.AnchorInputLayout;
import com.tencent.timi.game.liveroom.impl.room.input.event.UpdateBarrageListEvent;
import com.tencent.timi.game.liveroom.impl.room.medal.QQLiveMedalServiceSupplier;
import com.tencent.timi.game.liveroom.impl.room.message.event.SysMsgEvent;
import com.tencent.timi.game.liveroom.impl.room.payguide.showdialog.ShowDialogEvent;
import com.tencent.timi.game.liveroom.impl.room.quickgift.quicksendgift.PurchasePackageGiftEvent;
import com.tencent.timi.game.liveroom.impl.room.view.af;
import com.vivo.push.PushClientConstants;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.Foreground;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import pk4.b;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b#\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 S2\u00020\u0001:\u0001TB\u0007\u00a2\u0006\u0004\bQ\u0010RJ3\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0010\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0005H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ!\u0010\u000b\u001a\u00020\n2\u0010\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0005H\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ!\u0010\r\u001a\u00020\n2\u0010\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0005H\u0002\u00a2\u0006\u0004\b\r\u0010\fJ)\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0005H\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ8\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0010H\u0002J)\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0005H\u0002\u00a2\u0006\u0004\b\u0019\u0010\u000fJ)\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0005H\u0002\u00a2\u0006\u0004\b\u001a\u0010\u000fJ)\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0005H\u0002\u00a2\u0006\u0004\b\u001b\u0010\u000fJ)\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0005H\u0002\u00a2\u0006\u0004\b\u001c\u0010\u000fJ\b\u0010\u001d\u001a\u00020\u0007H\u0002J)\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0005H\u0002\u00a2\u0006\u0004\b\u001e\u0010\u000fJ)\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0005H\u0002\u00a2\u0006\u0004\b\u001f\u0010\u000fJ)\u0010 \u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0005H\u0002\u00a2\u0006\u0004\b \u0010\u000fJ\u0018\u0010#\u001a\u00020\n2\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u0015H\u0002J)\u0010$\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0005H\u0002\u00a2\u0006\u0004\b$\u0010\u000fJ)\u0010%\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0005H\u0002\u00a2\u0006\u0004\b%\u0010\u000fJ)\u0010&\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0005H\u0002\u00a2\u0006\u0004\b&\u0010\u000fJ)\u0010'\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0005H\u0002\u00a2\u0006\u0004\b'\u0010\u000fJ)\u0010(\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0005H\u0002\u00a2\u0006\u0004\b(\u0010\u000fJ)\u0010)\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0005H\u0002\u00a2\u0006\u0004\b)\u0010\u000fJ)\u0010*\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0005H\u0002\u00a2\u0006\u0004\b*\u0010\u000fJ0\u0010/\u001a\u00020\n2\u0006\u0010+\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u00022\u0006\u0010-\u001a\u00020\u00152\u0006\u0010.\u001a\u00020\u0002H\u0002J\u0018\u00101\u001a\u00020\n2\u0006\u0010+\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u0007H\u0002J\"\u00103\u001a\u00020\n2\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u00152\b\b\u0002\u00102\u001a\u00020\u0002H\u0002J0\u00104\u001a\u00020\n2\u0006\u0010-\u001a\u00020\u00152\u0006\u0010,\u001a\u00020\u00152\u0006\u0010.\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u0002H\u0002J\b\u00105\u001a\u00020\u0007H\u0002J\b\u00106\u001a\u00020\nH\u0002J)\u00107\u001a\u00020\u00072\u0010\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b7\u00108J\"\u0010=\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010:\u001a\u0002092\b\u0010<\u001a\u0004\u0018\u00010;H\u0002J\u0012\u0010?\u001a\u00020\u00072\b\u0010>\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010@\u001a\u00020\u0015H\u0002J\b\u0010A\u001a\u00020\nH\u0002J\b\u0010B\u001a\u00020\nH\u0002J\b\u0010C\u001a\u00020\u0002H\u0016J\u000e\u0010F\u001a\u00020\n2\u0006\u0010E\u001a\u00020DJM\u0010I\u001a\u00020\u00072\b\u0010H\u001a\u0004\u0018\u00010G2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010>\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0005\"\u0004\u0018\u00010\u0002H\u0014\u00a2\u0006\u0004\bI\u0010JR\u0018\u0010E\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010P\u001a\u00020M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010O\u00a8\u0006U"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/pendant/webview/QQLiveJsPendantPlugin;", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "", "url", "method", "", "args", "", "M", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z", "", "L", "([Ljava/lang/String;)V", "N", "H", "(Ljava/lang/String;[Ljava/lang/String;)V", "", "uid", "roomid", "header", "nick", "", "gender", "roomid1", "l0", "B", "P", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "G", "T", "I", "D", "K", "callback", "errCode", "a0", BdhLogUtil.LogTag.Tag_Conn, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, UserInfo.SEX_FEMALE, "E", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "J", BdhLogUtil.LogTag.Tag_Req, "type", "giftId", QCircleWeakNetReporter.KEY_COST, "anchorId", "i0", "isSuccess", "g0", "errMsg", "b0", "O", "V", "X", "d0", "([Ljava/lang/String;Ljava/lang/String;)Z", "", "heightCoefficient", "Landroid/graphics/drawable/Drawable;", "bgDrawable", "e0", PushClientConstants.TAG_PKG_NAME, "W", HippyTKDListViewAdapter.X, "y", ExifInterface.LATITUDE_SOUTH, "getNameSpace", "Lcom/tencent/biz/ui/TouchWebView;", "webView", "f0", "Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;", "listener", "handleJsRequest", "(Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z", "d", "Lcom/tencent/biz/ui/TouchWebView;", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "e", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "mAegisLog", "<init>", "()V", "f", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class QQLiveJsPendantPlugin extends WebViewPlugin {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TouchWebView webView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IAegisLogApi mAegisLog;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/pendant/webview/QQLiveJsPendantPlugin$b", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveFollowCallback;", "", "onSuccess", "", "errCode", "", "errMsg", "onFail", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements IQQLiveFollowCallback {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f378195b;

        b(String str) {
            this.f378195b = str;
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback
        public void onFail(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QQLiveJsPendantPlugin qQLiveJsPendantPlugin = QQLiveJsPendantPlugin.this;
            String callback = this.f378195b;
            Intrinsics.checkNotNullExpressionValue(callback, "callback");
            qQLiveJsPendantPlugin.a0(callback, errCode);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback
        public void onSuccess() {
            QQLiveJsPendantPlugin qQLiveJsPendantPlugin = QQLiveJsPendantPlugin.this;
            String callback = this.f378195b;
            Intrinsics.checkNotNullExpressionValue(callback, "callback");
            qQLiveJsPendantPlugin.a0(callback, 0);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/pendant/webview/QQLiveJsPendantPlugin$d", "Lcom/tencent/mobileqq/qqlive/callback/message/IQQLiveMessageCallback;", "", "isLocal", "", "onSuccess", "", "errCode", "", "errMsg", "onFail", "onIllegalMsg", "msg", "onUserForbid", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d implements IQQLiveMessageCallback {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f378201b;

        d(String str) {
            this.f378201b = str;
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQLiveMessageCallback
        public void onFail(int errCode, @Nullable String errMsg) {
            QQLiveJsPendantPlugin qQLiveJsPendantPlugin = QQLiveJsPendantPlugin.this;
            String callback = this.f378201b;
            Intrinsics.checkNotNullExpressionValue(callback, "callback");
            qQLiveJsPendantPlugin.a0(callback, errCode);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQLiveMessageCallback
        public void onIllegalMsg() {
            QQLiveJsPendantPlugin qQLiveJsPendantPlugin = QQLiveJsPendantPlugin.this;
            String callback = this.f378201b;
            Intrinsics.checkNotNullExpressionValue(callback, "callback");
            qQLiveJsPendantPlugin.a0(callback, -1);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQLiveMessageCallback
        public void onSuccess(boolean isLocal) {
            if (!isLocal) {
                SimpleEventBus.getInstance().dispatchEvent(new UserSelfSendMsgEvent(tk4.d.f436481a.i()));
                QQLiveJsPendantPlugin qQLiveJsPendantPlugin = QQLiveJsPendantPlugin.this;
                String callback = this.f378201b;
                Intrinsics.checkNotNullExpressionValue(callback, "callback");
                qQLiveJsPendantPlugin.a0(callback, 0);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQLiveMessageCallback
        public void onUserForbid(@Nullable String msg2) {
            QQLiveJsPendantPlugin qQLiveJsPendantPlugin = QQLiveJsPendantPlugin.this;
            String callback = this.f378201b;
            Intrinsics.checkNotNullExpressionValue(callback, "callback");
            qQLiveJsPendantPlugin.a0(callback, -2);
        }
    }

    public QQLiveJsPendantPlugin() {
        QLog.i("Pendant|QQLivePendantJsPlugin", 1, "\u521d\u59cb\u5316QQLivePendantJsPlugin");
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.mAegisLog = (IAegisLogApi) api;
    }

    private final void A(String url, String[] args) {
        boolean z16;
        List split$default;
        if (args.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.mAegisLog.a("Pendant|QQLivePendantJsPlugin", 1, "QQLiveJsPendantPlugin handleJoinActivity url\u5f02\u5e38,args.isEmpty url=" + url);
            return;
        }
        try {
            String sceneIds = new JSONObject(args[0]).optString("giftSceneIds", "");
            this.mAegisLog.i("Pendant|QQLivePendantJsPlugin", 1, "joinActivity, sceneId=" + sceneIds);
            Intrinsics.checkNotNullExpressionValue(sceneIds, "sceneIds");
            split$default = StringsKt__StringsKt.split$default((CharSequence) sceneIds, new String[]{","}, false, 0, 6, (Object) null);
            Iterator it = split$default.iterator();
            while (it.hasNext()) {
                com.tencent.timi.game.initer.impl.b.f377190a.a(Integer.parseInt((String) it.next()));
            }
        } catch (Exception e16) {
            this.mAegisLog.a("Pendant|QQLivePendantJsPlugin", 1, "QQLiveJsPendantPlugin handleClearCacheGiftList Exception:" + e16 + JefsClass.INDEX_URL + url);
        }
    }

    private final void B(String url, String[] args) {
        boolean z16;
        if (args.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.mAegisLog.a("Pendant|QQLivePendantJsPlugin", 1, "QQLiveJsPendantPlugin_handleFansGroup_url\u5f02\u5e38,args.isEmpty url=" + url);
            return;
        }
        if (T()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(args[0]);
            String optString = jSONObject.optString("gift_id", "");
            String callback = jSONObject.optString("callback", "");
            String type = jSONObject.optString("type", "");
            String optString2 = jSONObject.optString(QCircleWeakNetReporter.KEY_COST, "");
            String anchorId = jSONObject.optString("anchor_uid", "");
            QLog.i("Pendant|QQLivePendantJsPlugin", 1, "giftId=" + optString + ",callback=" + callback + ",type=" + type + ",anchorId=" + anchorId + JefsClass.INDEX_URL + url);
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(anchorId)) {
                int parseInt = Integer.parseInt(optString);
                int parseInt2 = Integer.parseInt(optString2);
                Intrinsics.checkNotNullExpressionValue(type, "type");
                Intrinsics.checkNotNullExpressionValue(callback, "callback");
                Intrinsics.checkNotNullExpressionValue(anchorId, "anchorId");
                i0(type, parseInt, callback, parseInt2, anchorId);
                return;
            }
            this.mAegisLog.a("Pendant|QQLivePendantJsPlugin", 1, "QQLiveJsPendantPlugin_handleFansGroup\u6570\u636e\u5f02\u5e38 giftId=" + optString + ",anchorId=" + anchorId + JefsClass.INDEX_URL + url);
        } catch (JSONException e16) {
            this.mAegisLog.a("Pendant|QQLivePendantJsPlugin", 1, "QQLiveJsPendantPlugin_handleFansGroup_JSONException:" + e16 + JefsClass.INDEX_URL + url);
        }
    }

    private final void C(String url, String[] args) {
        boolean z16;
        if (args.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.mAegisLog.a("Pendant|QQLivePendantJsPlugin", 1, "QQLiveJsPendantPlugin handleFollowAnchor url\u5f02\u5e38,args.isEmpty url=" + url);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(args[0]);
            int optInt = jSONObject.optInt("isFollow", 1);
            tk4.d dVar = tk4.d.f436481a;
            long optLong = jSONObject.optLong("roomId", dVar.i());
            long optLong2 = jSONObject.optLong("anchorUid", dVar.e(optLong));
            b bVar = new b(jSONObject.optString("callback", ""));
            if (1 == optInt) {
                TGLiveFollowManager.f377684a.h(null, optLong2, optLong, bVar);
            } else {
                TGLiveFollowManager.f377684a.k(null, optLong2, optLong, bVar);
            }
        } catch (JSONException e16) {
            this.mAegisLog.a("Pendant|QQLivePendantJsPlugin", 1, "QQLiveJsPendantPlugin handleFollowAnchor JSONException:" + e16 + JefsClass.INDEX_URL + url);
        }
    }

    private final void D(String url, String[] args) {
        boolean z16;
        Long l3;
        String str;
        Integer num;
        if (args.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.mAegisLog.a("Pendant|QQLivePendantJsPlugin", 1, "QQLiveJsPendantPlugin handleGetUserInfoJs url\u5f02\u5e38,args.isEmpty url=" + url);
            return;
        }
        try {
            String optString = new JSONObject(args[0]).optString("callback", "");
            LiveLoginInfo loginInfo = ((ILiveLoginApi) QRoute.api(ILiveLoginApi.class)).getLoginInfo(QQLiveBusinessConfig.QQLIVE_APP_ID, ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount());
            JSONObject jSONObject = new JSONObject();
            String str2 = null;
            if (loginInfo != null) {
                l3 = Long.valueOf(loginInfo.q());
            } else {
                l3 = null;
            }
            jSONObject.put("uid", l3);
            if (loginInfo != null) {
                str = loginInfo.m();
            } else {
                str = null;
            }
            jSONObject.put("nick", str);
            if (loginInfo != null) {
                num = Integer.valueOf(loginInfo.o());
            } else {
                num = null;
            }
            jSONObject.put("sex", num);
            if (loginInfo != null) {
                str2 = loginInfo.j();
            }
            jSONObject.put("headUrl", str2);
            callJs(optString, jSONObject.toString());
        } catch (JSONException e16) {
            this.mAegisLog.a("Pendant|QQLivePendantJsPlugin", 1, "QQLiveJsPendantPlugin handleOpenGiftPanelJs JSONException:" + e16 + JefsClass.INDEX_URL + url);
        }
    }

    private final void E(String url, String[] args) {
        boolean z16;
        String str = "";
        if (args.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.mAegisLog.a("Pendant|QQLivePendantJsPlugin", 1, "QQLiveJsPendantPlugin handleJoinActivity url\u5f02\u5e38,args.isEmpty url=" + url);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(args[0]);
            int optInt = jSONObject.optInt("action", -1);
            String optString = jSONObject.optString("type", "");
            String id5 = jSONObject.optString("id", "");
            tk4.d dVar = tk4.d.f436481a;
            long optLong = jSONObject.optLong("roomId", dVar.i());
            this.mAegisLog.i("Pendant|QQLivePendantJsPlugin", 1, "joinActivity, action=" + optInt + ", type=" + optString + ", id=" + id5 + ", roomId=" + optLong);
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(id5) && optInt > -1) {
                String str2 = "join_activity_" + optLong + "_" + optString + "_";
                if (optInt == 0) {
                    Intrinsics.checkNotNullExpressionValue(id5, "id");
                    str = id5;
                }
                ct3.a.s(str2, dVar.v(), str);
                this.mAegisLog.i("Pendant|QQLivePendantJsPlugin", 1, "record joinActivity status={key=" + str2 + ", value=" + str + "}");
            }
        } catch (JSONException e16) {
            this.mAegisLog.a("Pendant|QQLivePendantJsPlugin", 1, "QQLiveJsPendantPlugin handleJoinActivity JSONException:" + e16 + JefsClass.INDEX_URL + url);
        }
    }

    private final void F(String url, String[] args) {
        boolean z16;
        int i3 = 0;
        if (args.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.mAegisLog.a("Pendant|QQLivePendantJsPlugin", 1, "QQLiveJsPendantPlugin handleLocalMessage url\u5f02\u5e38,args.isEmpty url=" + url);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(args[0]);
            String text = jSONObject.optString("text", "");
            try {
                i3 = Color.parseColor("#" + jSONObject.optString("text_color", ""));
            } catch (Exception unused) {
                QLog.e("Pendant|QQLivePendantJsPlugin", 1, "handleLocalMessage, parse bgColor error");
            }
            long optLong = jSONObject.optLong(AudienceReportConst.ROOM_ID);
            if (!TextUtils.isEmpty(text) && optLong == tk4.d.f436481a.i()) {
                SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                Intrinsics.checkNotNullExpressionValue(text, "text");
                simpleEventBus.dispatchEvent(new SysMsgEvent(optLong, text, i3));
            }
        } catch (JSONException e16) {
            this.mAegisLog.a("Pendant|QQLivePendantJsPlugin", 1, "QQLiveJsPendantPlugin handleSendMessage JSONException:" + e16 + JefsClass.INDEX_URL + url);
        }
    }

    private final void G(String url, String[] args) {
        boolean z16;
        if (args.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.mAegisLog.a("Pendant|QQLivePendantJsPlugin", 1, "QQLiveJsPendantPlugin handleOpenGiftPanelJs url\u5f02\u5e38,args.isEmpty url=" + url);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(args[0]);
            int optInt = jSONObject.optInt("qqlive_subscene_id", 0);
            String optString = jSONObject.optString("callback", "");
            ITimiGameApi iTimiGameApi = (ITimiGameApi) QRoute.api(ITimiGameApi.class);
            Activity a16 = this.mRuntime.a();
            Intrinsics.checkNotNullExpressionValue(a16, "mRuntime.activity");
            iTimiGameApi.openGiftPanelFragmentFromActivity(optInt, a16);
            callJs(optString, "");
        } catch (JSONException e16) {
            this.mAegisLog.a("Pendant|QQLivePendantJsPlugin", 1, "QQLiveJsPendantPlugin handleOpenGiftPanelJs JSONException:" + e16 + JefsClass.INDEX_URL + url);
        }
    }

    private final void H(String url, String[] args) {
        if (QLog.isDevelopLevel()) {
            this.mAegisLog.d("Pendant|QQLivePendantJsPlugin", "handleOpenMiniCard json:" + url);
        }
        try {
            JSONObject jSONObject = new JSONObject(args[0]);
            long optLong = jSONObject.optLong("uid", 0L);
            String optString = jSONObject.optString("header", "");
            Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"header\", \"\")");
            String optString2 = jSONObject.optString("nick", "");
            Intrinsics.checkNotNullExpressionValue(optString2, "json.optString(\"nick\", \"\")");
            int optInt = jSONObject.optInt("gender", 0);
            long optLong2 = jSONObject.optLong("roomid", 0L);
            l0(optLong, optLong2, optString, optString2, optInt, optLong2);
        } catch (JSONException e16) {
            this.mAegisLog.a("Pendant|QQLivePendantJsPlugin", 1, "QQLiveJsPendantPlugin_handleOpenMiniCard_JSONException:" + e16 + JefsClass.INDEX_URL + url);
        }
    }

    private final void I(String url, String[] args) {
        boolean z16;
        if (args.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.mAegisLog.a("Pendant|QQLivePendantJsPlugin", 1, "QQLiveJsPendantPlugin handleOpenPayPanelJs url\u5f02\u5e38,args.isEmpty url=" + url);
            return;
        }
        try {
            String optString = new JSONObject(args[0]).optString("callback", "");
            pk4.b.D(this.mRuntime.a(), 1);
            callJs(optString, "");
        } catch (JSONException e16) {
            this.mAegisLog.a("Pendant|QQLivePendantJsPlugin", 1, "QQLiveJsPendantPlugin handleOpenGiftPanelJs JSONException:" + e16 + JefsClass.INDEX_URL + url);
        }
    }

    private final void J(String url, String[] args) {
        boolean z16;
        if (args.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.mAegisLog.a("Pendant|QQLivePendantJsPlugin", 1, "QQLiveJsPendantPlugin handlePackageGiftPurchaseSuc url\u5f02\u5e38,args.isEmpty url=" + url);
            return;
        }
        try {
            int optInt = new JSONObject(args[0]).optInt("gift_id", 0);
            this.mAegisLog.i("Pendant|QQLivePendantJsPlugin", 1, "handlePackageGiftPurchaseSuc, giftId=" + optInt);
            SimpleEventBus.getInstance().dispatchEvent(new PurchasePackageGiftEvent(optInt));
        } catch (Exception e16) {
            this.mAegisLog.a("Pendant|QQLivePendantJsPlugin", 1, "QQLiveJsPendantPlugin handlePackageGiftPurchaseSuc Exception:" + e16 + JefsClass.INDEX_URL + url);
        }
    }

    private final void L(String[] args) {
        boolean z16;
        TouchWebView touchWebView;
        if (args != null) {
            if (args.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if ((!z16) && (touchWebView = this.webView) != null && (touchWebView instanceof PendantWebView)) {
                try {
                    JSONObject jSONObject = new JSONObject(args[0]);
                    String optString = jSONObject.optString("name", "pushPendant");
                    String optString2 = jSONObject.optString("callback", "");
                    TouchWebView touchWebView2 = this.webView;
                    Intrinsics.checkNotNull(touchWebView2, "null cannot be cast to non-null type com.tencent.timi.game.liveroom.impl.room.pendant.webview.PendantWebView");
                    ((PendantWebView) touchWebView2).setCallback(optString, optString2);
                    int optInt = jSONObject.optInt("delay", 100);
                    TouchWebView touchWebView3 = this.webView;
                    Intrinsics.checkNotNull(touchWebView3, "null cannot be cast to non-null type com.tencent.timi.game.liveroom.impl.room.pendant.webview.PendantWebView");
                    ((PendantWebView) touchWebView3).setParams("pushPendantDelay", optInt);
                } catch (JSONException e16) {
                    if (QLog.isDevelopLevel()) {
                        QLog.d("Pendant|QQLivePendantJsPlugin", 4, "handlePushPendant failed:" + e16);
                    }
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0104, code lost:
    
        if (r8.equals("updateAvatarDecorate") == false) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0198, code lost:
    
        S();
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x019b, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0194, code lost:
    
        if (r8.equals("updateSkin") == false) goto L180;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0038. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean M(String url, String method, String[] args) {
        String str;
        boolean z16;
        TouchWebView touchWebView;
        if (args.length <= 0) {
            str = "";
        } else {
            str = args[0];
        }
        this.mAegisLog.i("Pendant|QQLivePendantJsPlugin", 1, "handleQQLivestreamJsRequest: url ->" + url + ", arg ->" + str);
        if (method != null) {
            switch (method.hashCode()) {
                case -1981823421:
                    if (method.equals("clearCacheGiftList")) {
                        A(url, args);
                        return true;
                    }
                    break;
                case -795892135:
                    if (method.equals("animateHidePendant")) {
                        y();
                        return true;
                    }
                    break;
                case -780300497:
                    if (method.equals("fansGroupDeductCost")) {
                        B(url, args);
                        return true;
                    }
                    break;
                case -765459678:
                    if (method.equals("pushPendant")) {
                        L(args);
                        return true;
                    }
                    break;
                case -668458870:
                    if (method.equals("hideWebPendant")) {
                        this.mAegisLog.i("Pendant|QQLivePendantJsPlugin", 1, "hideWebPendant");
                        TouchWebView touchWebView2 = this.webView;
                        if (touchWebView2 != null && (touchWebView2 instanceof PendantWebView)) {
                            Intrinsics.checkNotNull(touchWebView2, "null cannot be cast to non-null type com.tencent.timi.game.liveroom.impl.room.pendant.webview.PendantWebView");
                            ((PendantWebView) touchWebView2).setVisibility(8);
                        }
                        return true;
                    }
                    break;
                case -625809843:
                    if (method.equals("addEventListener")) {
                        if (args.length == 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if ((!z16) && (touchWebView = this.webView) != null && (touchWebView instanceof PendantWebView)) {
                            try {
                                JSONObject jSONObject = new JSONObject(args[0]);
                                String optString = jSONObject.optString("name", "");
                                String optString2 = jSONObject.optString("callback", "");
                                TouchWebView touchWebView3 = this.webView;
                                Intrinsics.checkNotNull(touchWebView3, "null cannot be cast to non-null type com.tencent.timi.game.liveroom.impl.room.pendant.webview.PendantWebView");
                                ((PendantWebView) touchWebView3).setCallback(optString, optString2);
                            } catch (JSONException e16) {
                                if (QLog.isDevelopLevel()) {
                                    QLog.d("Pendant|QQLivePendantJsPlugin", 4, "closeWebViews failed:" + e16);
                                }
                            }
                            SimpleEventBus.getInstance().dispatchEvent(new SendPendantData(method));
                        }
                        return true;
                    }
                    break;
                case -543897314:
                    if (method.equals("openCustomWebview")) {
                        return d0(args, url);
                    }
                    break;
                case -450874714:
                    if (method.equals("openPayPanel")) {
                        I(url, args);
                        return true;
                    }
                    break;
                case -424901544:
                    if (method.equals("closeCurrentWebview")) {
                        this.mAegisLog.i("Pendant|QQLivePendantJsPlugin", 1, "url=" + url);
                        SimpleEventBus.getInstance().dispatchEvent(new LiveWebDialogEvent("hide", url, x()));
                        return true;
                    }
                    break;
                case -326633977:
                    if (method.equals("validatePurchaseGift")) {
                        z(url, args);
                        return true;
                    }
                    break;
                case -295959066:
                    break;
                case -159238490:
                    if (method.equals(WebAccelerateHelper.KEY_PRELOAD_URL)) {
                        K(url, args);
                        return true;
                    }
                    break;
                case 109254796:
                    if (method.equals("scene")) {
                        N(args);
                        return true;
                    }
                    break;
                case 276112707:
                    if (method.equals("showPopActivity")) {
                        SimpleEventBus.getInstance().dispatchEvent(new ShowDialogEvent("showPopActivity", url, x()));
                        return true;
                    }
                    break;
                case 384457610:
                    if (method.equals("openGiftPanel")) {
                        G(url, args);
                        return true;
                    }
                    break;
                case 691453791:
                    if (method.equals("sendMessage")) {
                        Q(url, args);
                        return true;
                    }
                    break;
                case 865320877:
                    if (method.equals("updateChatBubble")) {
                        R(url, args);
                        return true;
                    }
                    break;
                case 1060127960:
                    if (method.equals("updatePayDanmuList")) {
                        SimpleEventBus.getInstance().dispatchEvent(new UpdateBarrageListEvent(com.tencent.mobileqq.qqlive.sail.c.f272176a.p()));
                        return true;
                    }
                    break;
                case 1113479343:
                    break;
                case 1127985265:
                    if (method.equals("openMiniCard")) {
                        H(url, args);
                        return true;
                    }
                    break;
                case 1197828697:
                    if (method.equals("joinActivity")) {
                        E(url, args);
                        return true;
                    }
                    break;
                case 1208576325:
                    if (method.equals("modifyFansName")) {
                        X();
                        return true;
                    }
                    break;
                case 1247062232:
                    if (method.equals("sendGift")) {
                        P(url, args);
                        return true;
                    }
                    break;
                case 1385931206:
                    if (method.equals("followAnchor")) {
                        C(url, args);
                        return true;
                    }
                    break;
                case 1531518956:
                    if (method.equals("giftPackagePurchaseSuccess")) {
                        J(url, args);
                        return true;
                    }
                    break;
                case 1599241565:
                    if (method.equals("addLocalMessage")) {
                        F(url, args);
                        return true;
                    }
                    break;
                case 1646635098:
                    if (method.equals("getUserCommonInfo")) {
                        D(url, args);
                        return true;
                    }
                    break;
                case 1682191098:
                    if (method.equals("stoploading")) {
                        TouchWebView touchWebView4 = this.webView;
                        if (touchWebView4 != null) {
                            touchWebView4.stopLoading();
                        }
                        SimpleEventBus.getInstance().dispatchEvent(new LiveWebDialogEvent(UIJsPlugin.EVENT_HIDE_LOADING, url, x()));
                        break;
                    }
                    break;
                case 1793290373:
                    if (method.equals("showWebPendant")) {
                        this.mAegisLog.i("Pendant|QQLivePendantJsPlugin", 1, "showWebPendant");
                        TouchWebView touchWebView5 = this.webView;
                        if (touchWebView5 != null && (touchWebView5 instanceof PendantWebView)) {
                            Intrinsics.checkNotNull(touchWebView5, "null cannot be cast to non-null type com.tencent.timi.game.liveroom.impl.room.pendant.webview.PendantWebView");
                            ((PendantWebView) touchWebView5).setVisibility(0);
                        }
                        return true;
                    }
                    break;
            }
        }
        return false;
    }

    private final void N(String[] args) {
        boolean z16;
        TouchWebView touchWebView;
        if (args != null) {
            if (args.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if ((!z16) && (touchWebView = this.webView) != null && (touchWebView instanceof PendantWebView)) {
                try {
                    JSONObject jSONObject = new JSONObject(args[0]);
                    String optString = jSONObject.optString("name", "scene");
                    String optString2 = jSONObject.optString("callback", "");
                    TouchWebView touchWebView2 = this.webView;
                    Intrinsics.checkNotNull(touchWebView2, "null cannot be cast to non-null type com.tencent.timi.game.liveroom.impl.room.pendant.webview.PendantWebView");
                    ((PendantWebView) touchWebView2).setCallback(optString, optString2);
                } catch (JSONException e16) {
                    if (QLog.isDevelopLevel()) {
                        QLog.d("Pendant|QQLivePendantJsPlugin", 4, "handleScene failed:" + e16);
                    }
                }
            }
        }
    }

    private final void O(int cost, int giftId, String anchorId, String callback, String type) {
        com.tencent.mobileqq.qqgift.data.service.d dVar;
        AegisLogger.INSTANCE.i("Pendant|QQLivePendantJsPlugin", "handleSendGift", "giftId=" + giftId + ",anchorId=" + anchorId + ",cost=" + cost + ",type=" + type);
        com.tencent.mobileqq.qqgift.data.service.d dVar2 = new com.tencent.mobileqq.qqgift.data.service.d();
        dVar2.f264874d = giftId;
        dVar2.f264878f = cost;
        com.tencent.mobileqq.qqgift.data.service.d w3 = pk4.b.w(giftId);
        if (w3 != null) {
            dVar = w3;
        } else {
            dVar = dVar2;
        }
        pk4.b.n(this.mRuntime.a(), false, dVar, -1L, 0L, new c(giftId, this, callback, type));
    }

    private final void P(String url, String[] args) {
        boolean z16;
        String receiveId;
        if (args.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.mAegisLog.a("Pendant|QQLivePendantJsPlugin", 1, "QQLiveJsPendantPlugin handleSendGiftJs url\u5f02\u5e38,args.isEmpty url=" + url);
            return;
        }
        if (T()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(args[0]);
            String optString = jSONObject.optString("giftId", "");
            String callback = jSONObject.optString("callback", "");
            String optString2 = jSONObject.optString(QCircleWeakNetReporter.KEY_COST, "");
            String optString3 = jSONObject.optString("receiveUid", "");
            String type = jSONObject.optString("type", "");
            if (TextUtils.isEmpty(optString3)) {
                com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
                receiveId = String.valueOf(SailAudienceRoomManager.i(cVar.m(), cVar.m().l(), 0, 2, null));
            } else {
                receiveId = optString3;
            }
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(receiveId)) {
                int parseInt = Integer.parseInt(optString);
                int parseInt2 = Integer.parseInt(optString2);
                Intrinsics.checkNotNullExpressionValue(receiveId, "receiveId");
                Intrinsics.checkNotNullExpressionValue(callback, "callback");
                Intrinsics.checkNotNullExpressionValue(type, "type");
                O(parseInt2, parseInt, receiveId, callback, type);
                return;
            }
            this.mAegisLog.a("Pendant|QQLivePendantJsPlugin", 1, "QQLiveJsPendantPlugin handleSendGiftJs giftId=" + optString + ",receiveId=" + receiveId + JefsClass.INDEX_URL + url);
        } catch (JSONException e16) {
            this.mAegisLog.a("Pendant|QQLivePendantJsPlugin", 1, "QQLiveJsPendantPlugin handleSendGiftJs JSONException:" + e16 + JefsClass.INDEX_URL + url);
        }
    }

    private final void Q(String url, String[] args) {
        boolean z16;
        if (args.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.mAegisLog.a("Pendant|QQLivePendantJsPlugin", 1, "QQLiveJsPendantPlugin handleSendMessage url\u5f02\u5e38,args.isEmpty url=" + url);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(args[0]);
            String text = jSONObject.optString("text", "");
            String callback = jSONObject.optString("callback", "");
            if (TextUtils.isEmpty(text)) {
                Intrinsics.checkNotNullExpressionValue(callback, "callback");
                a0(callback, -1);
                return;
            }
            long p16 = com.tencent.mobileqq.qqlive.sail.c.f272176a.p();
            ArrayList<LiveMessageData.ExtData> a16 = AnchorInputLayout.INSTANCE.a();
            com.tencent.timi.game.liveroom.impl.room.message.i iVar = com.tencent.timi.game.liveroom.impl.room.message.i.f378067a;
            Intrinsics.checkNotNullExpressionValue(text, "text");
            iVar.b(p16, text, a16, new d(callback));
        } catch (JSONException e16) {
            this.mAegisLog.a("Pendant|QQLivePendantJsPlugin", 1, "QQLiveJsPendantPlugin handleSendMessage JSONException:" + e16 + JefsClass.INDEX_URL + url);
        }
    }

    private final void R(String url, String[] args) {
        com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
        QQLiveMedalServiceSupplier.f377955a.a().a(cVar.G(), cVar.p(), cVar.q(), null);
    }

    private final void S() {
        QLog.i("Pendant|QQLivePendantJsPlugin", 4, "handleUpdateAvatarDecorate, try update current userCardInfo");
        kk4.a.INSTANCE.b();
    }

    private final boolean T() {
        com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
        if (!SailAudienceRoomManager.G(cVar.m(), cVar.p(), 0, 2, null)) {
            AegisLogger.INSTANCE.w("Pendant|QQLivePendantJsPlugin", "isQQPromoted", "anchor is not QQAnchor");
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.pendant.webview.g
                @Override // java.lang.Runnable
                public final void run() {
                    QQLiveJsPendantPlugin.U();
                }
            });
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U() {
        gt3.a.INSTANCE.a().a("\u5916\u90e8\u5185\u5bb9\u6e90\u623f\u95f4\u4e0d\u652f\u6301\u9001\u793c", 0, BaseApplication.getContext());
    }

    private final boolean V() {
        com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
        return com.tencent.mobileqq.qqlive.sail.c.K(cVar, cVar.p(), 0, 2, null);
    }

    private final boolean W(String pkgName) {
        return Intrinsics.areEqual("qqlive", pkgName);
    }

    private final void X() {
        if (V()) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.pendant.webview.c
                @Override // java.lang.Runnable
                public final void run() {
                    QQLiveJsPendantPlugin.Y();
                }
            });
        } else if (this.mRuntime.a() != null) {
            this.mRuntime.a().finish();
        }
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.pendant.webview.d
            @Override // java.lang.Runnable
            public final void run() {
                QQLiveJsPendantPlugin.Z();
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y() {
        com.tencent.timi.game.liveroom.impl.room.livewebdialog.e.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z() {
        new af().show(Foreground.getTopActivity().getFragmentManager(), "modifyFansName");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a0(String callback, int errCode) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ret_code", errCode);
        callJs(callback, jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b0(String callback, int errCode, String errMsg) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("errCode", errCode);
        jSONObject.put("errMsg", errMsg);
        callJs(callback, jSONObject.toString());
    }

    static /* synthetic */ void c0(QQLiveJsPendantPlugin qQLiveJsPendantPlugin, String str, int i3, String str2, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            str2 = "";
        }
        qQLiveJsPendantPlugin.b0(str, i3, str2);
    }

    private final boolean d0(String[] args, String url) {
        boolean z16;
        ColorDrawable colorDrawable;
        if (args.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.w("Pendant|QQLivePendantJsPlugin", 1, "handleQQLivestreamJsRequest: args error! >>" + url);
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(args[0]);
            String url2 = jSONObject.optString("url", "");
            double optDouble = jSONObject.optDouble("height", 0.5d);
            int optInt = jSONObject.optInt("target", 1);
            try {
                colorDrawable = new ColorDrawable(Color.parseColor("#" + jSONObject.optString("bgColor", "")));
            } catch (Exception unused) {
                QLog.e("Pendant|QQLivePendantJsPlugin", 1, "openCustomWebView, parse bgColor error");
                colorDrawable = null;
            }
            if (optInt == 0) {
                TouchWebView touchWebView = this.webView;
                if (touchWebView != null) {
                    touchWebView.loadUrl(url2);
                }
            } else {
                Intrinsics.checkNotNullExpressionValue(url2, "url");
                e0(url2, (float) optDouble, colorDrawable);
            }
        } catch (JSONException e16) {
            if (QLog.isDevelopLevel()) {
                QLog.d("Pendant|QQLivePendantJsPlugin", 4, "openCustomWebView failed:" + e16);
            }
        }
        return true;
    }

    private final void e0(String url, float heightCoefficient, Drawable bgDrawable) {
        Bundle bundle = new Bundle();
        int i3 = x.f(BaseApplication.getContext()).f185861b;
        int i16 = x.f(BaseApplication.getContext()).f185860a;
        if (i3 <= i16) {
            i3 = i16;
        }
        bundle.putInt("height_web_dialog", x.h(BaseApplication.getContext(), i3 * heightCoefficient));
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity != null) {
            ((IQQLiveHalfWebHelperApi) QRoute.api(IQQLiveHalfWebHelperApi.class)).start(topActivity, url, bundle, null, bgDrawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g0(String type, boolean isSuccess) {
        String str;
        if (Intrinsics.areEqual("1", type)) {
            str = "\u52a0\u5165\u7c89\u4e1d\u56e2";
        } else if (Intrinsics.areEqual("2", type)) {
            str = "\u7eed\u8d39\u7c89\u4e1d\u56e2";
        } else if (Intrinsics.areEqual("3", type)) {
            str = "\u52a0\u5165\u94bb\u4f01\u9e45\u56e2";
        } else if (Intrinsics.areEqual("4", type)) {
            str = "\u7eed\u8d39\u94bb\u4f01\u9e45\u56e2";
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (isSuccess) {
            QQToast.makeText(BaseApplication.getContext(), "\u606d\u559c\u4f60\u6210\u529f" + str, 2).show();
            return;
        }
        QQToast.makeText(BaseApplication.getContext(), str + "\u5931\u8d25", 2).show();
    }

    private final void i0(final String type, final int giftId, final String callback, final int cost, final String anchorId) {
        String str;
        this.mAegisLog.i("Pendant|QQLivePendantJsPlugin", 1, "showJoinFansConfirmDialog giftId=" + giftId + ",anchorId=" + anchorId + ",cost=" + cost + ",type=" + type);
        if (Intrinsics.areEqual(type, "1")) {
            str = "\u786e\u5b9a\u6253\u8d4f\u5165\u56e2\u793c(" + cost + " \u91d1\u5e01)\u52a0\u5165\u4e3b\u64ad\u7c89\u4e1d\u56e2?";
        } else {
            str = "\u786e\u5b9a\u6253\u8d4f\u5165\u56e2\u793c(" + cost + " \u91d1\u5e01)\u7ee7\u7eed\u70b9\u4eae\u7c89\u4e1d\u56e2\u94ed\u724c?";
        }
        QQCustomDialog positiveButton = DialogUtil.createCustomDialog(Foreground.getTopActivity(), 230).setMessage(str).setNegativeButton("\u53d6\u6d88", new DialogInterface.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.pendant.webview.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                QQLiveJsPendantPlugin.j0(QQLiveJsPendantPlugin.this, dialogInterface, i3);
            }
        }).setPositiveButton("\u6253\u8d4f", new DialogInterface.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.pendant.webview.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                QQLiveJsPendantPlugin.k0(QQLiveJsPendantPlugin.this, cost, giftId, anchorId, callback, type, dialogInterface, i3);
            }
        }, false);
        positiveButton.setTitle((String) null);
        positiveButton.setCancelable(false);
        positiveButton.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(QQLiveJsPendantPlugin this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mRuntime.a() == null && this$0.mRuntime.a().isFinishing()) {
            return;
        }
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(QQLiveJsPendantPlugin this$0, int i3, int i16, String anchorId, String callback, String type, DialogInterface dialogInterface, int i17) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(anchorId, "$anchorId");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(type, "$type");
        this$0.O(i3, i16, anchorId, callback, type);
        dialogInterface.dismiss();
    }

    private final void l0(long uid, long roomid, String header, String nick, int gender, long roomid1) {
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null && bVar.e() != null && this.mRuntime.a() != null) {
            LiveUserInfo liveUserInfo = new LiveUserInfo(uid, header, nick, gender);
            Activity topActivity = Foreground.getTopActivity();
            if (topActivity != null) {
                if (roomid <= 0) {
                    roomid = com.tencent.mobileqq.qqlive.sail.c.f272176a.p();
                }
                kk4.a.INSTANCE.g(topActivity, com.tencent.mobileqq.qqlive.sail.c.l(com.tencent.mobileqq.qqlive.sail.c.f272176a, roomid, 0, 2, null), liveUserInfo, 1, false);
                return;
            }
            return;
        }
        this.mAegisLog.e("Pendant|QQLivePendantJsPlugin", "showMiniCard mRuntime is null");
    }

    private final int x() {
        CustomWebView e16;
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null && (e16 = bVar.e()) != null) {
            return e16.hashCode();
        }
        return 0;
    }

    private final void y() {
        TouchWebView touchWebView = this.webView;
        if (touchWebView != null && (touchWebView instanceof PendantWebView)) {
            QLog.i("Pendant|QQLivePendantJsPlugin", 4, "handleAnimationHidePendant");
            SimpleEventBus.getInstance().dispatchEvent(new RightBottomPendantPushEvent(false));
        }
    }

    private final void z(String url, String[] args) {
        boolean z16;
        if (args.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            AegisLogger.INSTANCE.i("Pendant|QQLivePendantJsPlugin", "handleCheckBalanceJs", "url\u5f02\u5e38,args.isEmpty url=" + url);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(args[0]);
            final int optInt = jSONObject.optInt(QCircleWeakNetReporter.KEY_COST, 0);
            final String callback = jSONObject.optString("callback", "");
            if (T()) {
                Intrinsics.checkNotNullExpressionValue(callback, "callback");
                b0(callback, -100, "isQQPromoted");
            } else {
                zh4.d.f452579a.d(this.mRuntime.a(), AuthScene.GIFT, new Function2<Boolean, String, Unit>() { // from class: com.tencent.timi.game.liveroom.impl.room.pendant.webview.QQLiveJsPendantPlugin$handleCheckBalanceJs$1

                    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J(\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/pendant/webview/QQLiveJsPendantPlugin$handleCheckBalanceJs$1$a", "Lrh2/a;", "", "errCode", "", "errMsg", "", "onFailed", "", "balance", "marketingBalance", "seq", "firstSave", tl.h.F, "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
                    /* loaded from: classes26.dex */
                    public static final class a implements rh2.a {

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ QQLiveJsPendantPlugin f378202d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ String f378203e;

                        /* renamed from: f, reason: collision with root package name */
                        final /* synthetic */ int f378204f;

                        a(QQLiveJsPendantPlugin qQLiveJsPendantPlugin, String str, int i3) {
                            this.f378202d = qQLiveJsPendantPlugin;
                            this.f378203e = str;
                            this.f378204f = i3;
                        }

                        @Override // rh2.a
                        public void h(long balance, long marketingBalance, long seq, int firstSave) {
                            if (this.f378204f <= balance) {
                                QQLiveJsPendantPlugin qQLiveJsPendantPlugin = this.f378202d;
                                String callback = this.f378203e;
                                Intrinsics.checkNotNullExpressionValue(callback, "callback");
                                qQLiveJsPendantPlugin.b0(callback, 0, "");
                                return;
                            }
                            pk4.b.D(this.f378202d.mRuntime.a(), 1);
                            QQLiveJsPendantPlugin qQLiveJsPendantPlugin2 = this.f378202d;
                            String callback2 = this.f378203e;
                            Intrinsics.checkNotNullExpressionValue(callback2, "callback");
                            qQLiveJsPendantPlugin2.b0(callback2, -101, "is not enough balance");
                        }

                        @Override // qh2.d
                        public void onFailed(int errCode, @Nullable String errMsg) {
                            QQLiveJsPendantPlugin qQLiveJsPendantPlugin = this.f378202d;
                            String callback = this.f378203e;
                            Intrinsics.checkNotNullExpressionValue(callback, "callback");
                            if (errMsg == null) {
                                errMsg = "";
                            }
                            qQLiveJsPendantPlugin.b0(callback, errCode, errMsg);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str) {
                        invoke(bool.booleanValue(), str);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z17, @Nullable String str) {
                        if (z17) {
                            pk4.b.t(new a(QQLiveJsPendantPlugin.this, callback, optInt));
                            return;
                        }
                        QQLiveJsPendantPlugin qQLiveJsPendantPlugin = QQLiveJsPendantPlugin.this;
                        String callback2 = callback;
                        Intrinsics.checkNotNullExpressionValue(callback2, "callback");
                        if (str == null) {
                            str = "";
                        }
                        qQLiveJsPendantPlugin.b0(callback2, -11153, str);
                    }
                });
            }
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e("Pendant|QQLivePendantJsPlugin", "handleCheckBalanceJs", "JSONException:" + e16 + JefsClass.INDEX_URL + url);
        }
    }

    public final void f0(@NotNull TouchWebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        this.webView = webView;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    @NotNull
    public String getNameSpace() {
        return "qqlive";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(@Nullable JsBridgeListener listener, @NotNull String url, @Nullable String pkgName, @Nullable String method, @NotNull String... args) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(args, "args");
        if (W(pkgName)) {
            return M(url, method, args);
        }
        return super.handleJsRequest(listener, url, pkgName, method, (String[]) Arrays.copyOf(args, args.length));
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/pendant/webview/QQLiveJsPendantPlugin$c", "Lpk4/b$k;", "Lcom/tencent/mobileqq/qqgift/data/service/d;", "giftServiceData", "", "d", "", "errCode", "", "errMsg", "a", "f", "e", "b", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements b.k {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f378196a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QQLiveJsPendantPlugin f378197b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f378198c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f378199d;

        c(int i3, QQLiveJsPendantPlugin qQLiveJsPendantPlugin, String str, String str2) {
            this.f378196a = i3;
            this.f378197b = qQLiveJsPendantPlugin;
            this.f378198c = str;
            this.f378199d = str2;
        }

        @Override // pk4.b.k
        public void a(int errCode, @Nullable String errMsg) {
            AegisLogger.INSTANCE.i("Pendant|QQLivePendantJsPlugin", "onPreCheckFail", "giftId=" + this.f378196a + ",errCode=" + errCode + ",errMsg=" + errMsg);
            QQLiveJsPendantPlugin.c0(this.f378197b, this.f378198c, errCode, null, 4, null);
        }

        @Override // pk4.b.k
        public void b(int errCode, @Nullable String errMsg) {
            AegisLogger.INSTANCE.i("Pendant|QQLivePendantJsPlugin", "onSendGiftFail", "giftId=" + this.f378196a + ",errCode=" + errCode + ",errMsg=" + errMsg);
            QQLiveJsPendantPlugin qQLiveJsPendantPlugin = this.f378197b;
            String str = this.f378198c;
            if (errMsg == null) {
                errMsg = "";
            }
            qQLiveJsPendantPlugin.b0(str, errCode, errMsg);
            this.f378197b.g0(this.f378199d, false);
        }

        @Override // pk4.b.k
        public void c(@Nullable com.tencent.mobileqq.qqgift.data.service.d giftServiceData) {
            AegisLogger.INSTANCE.i("Pendant|QQLivePendantJsPlugin", "onSendGiftSuccess", "giftServiceData=" + giftServiceData);
            QQLiveJsPendantPlugin.c0(this.f378197b, this.f378198c, 0, null, 4, null);
            this.f378197b.g0(this.f378199d, true);
        }

        @Override // pk4.b.k
        public void e(int errCode, @Nullable String errMsg) {
            AegisLogger.INSTANCE.i("Pendant|QQLivePendantJsPlugin", "onBalanceFail", "giftId=" + this.f378196a + ",errCode=" + errCode + ",errMsg=" + errMsg);
            QQLiveJsPendantPlugin.c0(this.f378197b, this.f378198c, -11008, null, 4, null);
        }

        @Override // pk4.b.k
        public void f(@Nullable String errMsg) {
            AegisLogger.INSTANCE.i("Pendant|QQLivePendantJsPlugin", "onIdentifyFail", "giftId=" + this.f378196a + ",errMsg=" + errMsg);
            QQLiveJsPendantPlugin.c0(this.f378197b, this.f378198c, -11013, null, 4, null);
        }

        @Override // pk4.b.k
        public void d(@Nullable com.tencent.mobileqq.qqgift.data.service.d giftServiceData) {
        }
    }

    private final void K(String url, String[] args) {
    }
}

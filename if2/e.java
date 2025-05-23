package if2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.ecommerce.biz.consumer.IECGameProxy;
import com.tencent.ecommerce.biz.consumer.event.IECGameEventReceiver;
import com.tencent.ecommerce.biz.consumer.xinghuan.IECXingHuanGameButton;
import com.tencent.ecommerce.biz.consumer.xinghuan.IGameEventListener;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.gamecenter.wadl.distribute.api.IQQGameDistributeApi;
import com.tencent.gamecenter.wadl.distribute.data.ButtonDataBuilder;
import com.tencent.gamecenter.wadl.distribute.data.ButtonUiBuilder;
import com.tencent.gamecenter.wadl.distribute.listener.IButtonEventListener;
import com.tencent.gamecenter.wadl.distribute.provider.IBgAndFgDrawableFetcher;
import com.tencent.gamecenter.wadl.distribute.provider.ITextColorFetcher;
import com.tencent.gamecenter.wadl.distribute.provider.TextContentFetcherAdapter;
import com.tencent.gamecenter.wadl.distribute.widget.IDistributeButton;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceUtil;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceWrap;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.minigame.kuikly.MiniGameKuiklyModule;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import com.vivo.push.PushClientConstants;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tencent.im.qqgame.QQGameGcSpkTaskDye;
import tencent.im.qqgame.QQGameQfsSubscribe;
import tencent.im.qqgame.QQGameSubscribe$SubscribeUpComingGameRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 J2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001KB\u0007\u00a2\u0006\u0004\bH\u0010IJ0\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002J.\u0010\u0014\u001a\u00020\u00132\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J.\u0010\u0015\u001a\u00020\u00132\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J;\u0010\"\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00042!\u0010!\u001a\u001d\u0012\u0013\u0012\u00110\u001d\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00130\u001cH\u0016J\u0018\u0010#\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010$\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J0\u0010%\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016J0\u0010&\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u0010\u0010'\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010(\u001a\u00020\u0013H\u0016J\u0010\u0010)\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010*\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010+\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010,\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0018\u0010.\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u0004H\u0016J\u0018\u0010/\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0016J \u00101\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u0016H\u0016J0\u00106\u001a\u00020\u00132\u0006\u00103\u001a\u0002022\u0006\u00104\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u0004H\u0016J(\u00109\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u00042\u0006\u00108\u001a\u00020\u0004H\u0016J\u0012\u0010<\u001a\u00020\u00132\b\u0010;\u001a\u0004\u0018\u00010:H\u0016J$\u0010@\u001a\u00020\u00132\u001a\u0010?\u001a\u0016\u0012\u0004\u0012\u00020:\u0018\u00010=j\n\u0012\u0004\u0012\u00020:\u0018\u0001`>H\u0016J$\u0010A\u001a\u00020\u00132\u001a\u0010?\u001a\u0016\u0012\u0004\u0012\u00020:\u0018\u00010=j\n\u0012\u0004\u0012\u00020:\u0018\u0001`>H\u0016J\u0018\u0010D\u001a\u0012\u0012\u0004\u0012\u00020\u00040Bj\b\u0012\u0004\u0012\u00020\u0004`CH\u0016J.\u0010E\u001a\u00020\u00132\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010G\u001a\u00020F2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016\u00a8\u0006L"}, d2 = {"Lif2/e;", "Lcom/tencent/gamecenter/wadl/biz/listener/WadlTrpcListener;", "Lcom/tencent/gamecenter/wadl/biz/listener/WadlProxyServiceCallBackInterface;", "Lcom/tencent/ecommerce/biz/consumer/IECGameProxy;", "", "appId", PushClientConstants.TAG_PKG_NAME, "appName", "channelId", "downloadUrl", "Lcom/tencent/gamecenter/wadl/biz/entity/WadlParams;", "g", "Landroid/content/Intent;", Const.BUNDLE_KEY_REQUEST, "cmd", "", "ret", "Lcom/tencent/gamecenter/wadl/biz/entity/TrpcProxy$TrpcInovkeRsp;", "rsp", "", "i", "j", "Lcom/tencent/ecommerce/biz/consumer/event/IECGameEventReceiver;", "receiver", "registerGameListener", "Landroid/content/Context;", "context", "noticeContent", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isConfirmed", "callback", "showNoWifiDialog", "startApp", "unRegisterGameListener", WadlProxyConsts.REMOTE_CMD_APP_DOWNLOAD_ACTION, WadlProxyConsts.REMOTE_CMD_APP_INSTALL_ACTION, WadlProxyConsts.REMOTE_CMD_APP_PAUSE_ACTION, WadlProxyConsts.REMOTE_CMD_QUERY_TASK, "doQuerySingleTask", WadlProxyConsts.REMOTE_CMD_APP_RESUME_ACTION, "isAppInstalled", "isWifiConnected", ZPlanPublishSource.FROM_SCHEME, MiniGameKuiklyModule.METHOD_OPEN_MINI_APP, "querySubscribeStatus", "listener", "querySubscribeStatusForKTV", "", "dyeOpType", "taskKey", "contentId", "subscribe", QCircleDaTongConstant.ElementParamValue.OPERATION, VasWebviewConstants.KEY_ADTAG, "subscribeGame", "Lcom/tencent/gamecenter/wadl/biz/entity/WadlResult;", "wadlResult", "onWadlTaskStatusChanged", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "wadlResults", "onQueryCallback", "onQueryCallbackVia", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getFilterCmds", "onTrpcRsp", "Lcom/tencent/ecommerce/biz/consumer/xinghuan/IECXingHuanGameButton;", "createXingHuanGameButton", "<init>", "()V", "d", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class e implements WadlTrpcListener, WadlProxyServiceCallBackInterface, IECGameProxy {

    /* renamed from: e, reason: collision with root package name */
    private static final LinkedList<IECGameEventReceiver> f407581e = new LinkedList<>();

    /* renamed from: f, reason: collision with root package name */
    private static final HashMap<Integer, IButtonEventListener> f407582f = new HashMap<>();

    /* renamed from: h, reason: collision with root package name */
    private static final HashSet<String> f407583h;

    /* compiled from: P */
    @Metadata(d1 = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016\u00a8\u0006\u0014"}, d2 = {"if2/e$b", "Lcom/tencent/ecommerce/biz/consumer/xinghuan/IECXingHuanGameButton;", "Landroid/view/View;", "getView", "Lcom/tencent/ecommerce/biz/consumer/xinghuan/IGameEventListener;", "listener", "", "addEventListener", "Landroid/view/ViewGroup;", "getBgView", "Landroid/widget/TextView;", "getTipsView", "removeEventListener", "Lph0/a;", "data", "setData", "Lph0/b;", SensorJsPlugin.SENSOR_INTERVAL_UI, "setUi", "update", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements IECXingHuanGameButton {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IDistributeButton f407584d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f407585e;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J \u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\bH\u0016\u00a8\u0006\u0010"}, d2 = {"if2/e$b$a", "Lcom/tencent/gamecenter/wadl/distribute/listener/IButtonEventListener;", "Landroid/view/View;", "view", "", NodeProps.ON_CLICK, "", "appId", "", "followStatus", "subscribeStatus", "onFollowOrSubscribeStatusChange", "", "progress", "taskStatus", "onDownloadTaskStatusChange", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes38.dex */
        public static final class a implements IButtonEventListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ IGameEventListener f407586d;

            a(IGameEventListener iGameEventListener) {
                this.f407586d = iGameEventListener;
            }

            @Override // com.tencent.gamecenter.wadl.distribute.listener.IButtonEventListener
            public void onClick(View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                IGameEventListener.a.a(this.f407586d, view, null, 2, null);
            }

            @Override // com.tencent.gamecenter.wadl.distribute.listener.IButtonEventListener
            public void onDownloadTaskStatusChange(String appId, float progress, int taskStatus) {
                Intrinsics.checkNotNullParameter(appId, "appId");
                this.f407586d.onDownloadTaskStatusChange(appId, (int) progress, taskStatus);
            }

            @Override // com.tencent.gamecenter.wadl.distribute.listener.IButtonEventListener
            public void onFollowOrSubscribeStatusChange(String appId, int followStatus, int subscribeStatus) {
                Intrinsics.checkNotNullParameter(appId, "appId");
                this.f407586d.onFollowOrSubscribeStatusChange(appId, followStatus, subscribeStatus);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"if2/e$b$b", "Lcom/tencent/gamecenter/wadl/distribute/provider/TextContentFetcherAdapter;", "", "fetchCanDownloadContent", "fetchPausedContent", "fetchWaitSubscribeContent", "fetchWaitFollowContent", "fetchDownloadedContent", "fetchInstalledContent", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: if2.e$b$b, reason: collision with other inner class name */
        /* loaded from: classes38.dex */
        public static final class C10524b extends TextContentFetcherAdapter {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ph0.b f407587a;

            C10524b(ph0.b bVar) {
                this.f407587a = bVar;
            }

            @Override // com.tencent.gamecenter.wadl.distribute.provider.TextContentFetcherAdapter, com.tencent.gamecenter.wadl.distribute.provider.ITextContentFetcher
            public String fetchCanDownloadContent() {
                return this.f407587a.getCanDownloadContent();
            }

            @Override // com.tencent.gamecenter.wadl.distribute.provider.TextContentFetcherAdapter, com.tencent.gamecenter.wadl.distribute.provider.ITextContentFetcher
            public String fetchDownloadedContent() {
                return this.f407587a.getDownloadedContent();
            }

            @Override // com.tencent.gamecenter.wadl.distribute.provider.TextContentFetcherAdapter, com.tencent.gamecenter.wadl.distribute.provider.ITextContentFetcher
            public String fetchInstalledContent() {
                return this.f407587a.getInstalledContent();
            }

            @Override // com.tencent.gamecenter.wadl.distribute.provider.TextContentFetcherAdapter, com.tencent.gamecenter.wadl.distribute.provider.ITextContentFetcher
            public String fetchPausedContent() {
                return this.f407587a.getPausedContent();
            }

            @Override // com.tencent.gamecenter.wadl.distribute.provider.TextContentFetcherAdapter, com.tencent.gamecenter.wadl.distribute.provider.ITextContentFetcher
            public String fetchWaitFollowContent() {
                return this.f407587a.getWaitFollowContent();
            }

            @Override // com.tencent.gamecenter.wadl.distribute.provider.TextContentFetcherAdapter, com.tencent.gamecenter.wadl.distribute.provider.ITextContentFetcher
            public String fetchWaitSubscribeContent() {
                return this.f407587a.getWaitSubscribeContent();
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"if2/e$b$c", "Lcom/tencent/gamecenter/wadl/distribute/provider/ITextColorFetcher;", "", "fetchEnableTextColor", "fetchDisableTextColor", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes38.dex */
        public static final class c implements ITextColorFetcher {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ph0.b f407588a;

            c(ph0.b bVar) {
                this.f407588a = bVar;
            }

            @Override // com.tencent.gamecenter.wadl.distribute.provider.ITextColorFetcher
            public int fetchDisableTextColor() {
                return this.f407588a.getDisableTextColor();
            }

            @Override // com.tencent.gamecenter.wadl.distribute.provider.ITextColorFetcher
            public int fetchEnableTextColor() {
                return this.f407588a.getEnableTextColor();
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"if2/e$b$d", "Lcom/tencent/gamecenter/wadl/distribute/provider/IBgAndFgDrawableFetcher;", "Landroid/graphics/drawable/Drawable;", "fetchEnableBgDrawable", "fetchDisableDrawable", "fetchProgressFgDrawable", "fetchProgressBgDrawable", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes38.dex */
        public static final class d implements IBgAndFgDrawableFetcher {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ph0.b f407589a;

            d(ph0.b bVar) {
                this.f407589a = bVar;
            }

            @Override // com.tencent.gamecenter.wadl.distribute.provider.IBgAndFgDrawableFetcher
            public Drawable fetchDisableDrawable() {
                return this.f407589a.getDisableBgDrawable();
            }

            @Override // com.tencent.gamecenter.wadl.distribute.provider.IBgAndFgDrawableFetcher
            public Drawable fetchEnableBgDrawable() {
                return this.f407589a.getEnableBgDrawable();
            }

            @Override // com.tencent.gamecenter.wadl.distribute.provider.IBgAndFgDrawableFetcher
            public Drawable fetchProgressBgDrawable() {
                return this.f407589a.getProgressBgDrawable();
            }

            @Override // com.tencent.gamecenter.wadl.distribute.provider.IBgAndFgDrawableFetcher
            public Drawable fetchProgressFgDrawable() {
                return this.f407589a.getProgressFgDrawable();
            }
        }

        b(IDistributeButton iDistributeButton, int i3) {
            this.f407584d = iDistributeButton;
            this.f407585e = i3;
        }

        @Override // com.tencent.ecommerce.biz.consumer.xinghuan.IECXingHuanGameButton
        public void addEventListener(IGameEventListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            a aVar = new a(listener);
            e.f407582f.put(Integer.valueOf(this.f407585e), aVar);
            this.f407584d.addEventListener(aVar);
        }

        @Override // com.tencent.ecommerce.biz.consumer.xinghuan.IECXingHuanGameButton
        public ViewGroup getBgView() {
            return this.f407584d.getBgView();
        }

        @Override // com.tencent.ecommerce.biz.consumer.xinghuan.IECXingHuanGameButton
        public TextView getTipsView() {
            return this.f407584d.getTipsView();
        }

        @Override // com.tencent.ecommerce.biz.consumer.xinghuan.IECXingHuanGameButton
        public View getView() {
            Object obj = this.f407584d;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.view.View");
            return (View) obj;
        }

        @Override // com.tencent.ecommerce.biz.consumer.xinghuan.IECXingHuanGameButton
        public void removeEventListener(IGameEventListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            IButtonEventListener iButtonEventListener = (IButtonEventListener) e.f407582f.get(Integer.valueOf(this.f407585e));
            if (iButtonEventListener != null) {
                this.f407584d.removeEventListener(iButtonEventListener);
            }
            e.f407582f.remove(Integer.valueOf(this.f407585e));
        }

        @Override // com.tencent.ecommerce.biz.consumer.xinghuan.IECXingHuanGameButton
        public void setData(ph0.a data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.f407584d.setDataBuilder(new ButtonDataBuilder().setAppId(data.getAppId()).setVersionCode(data.getVersionCode()).setApkChannel(data.getApkChannel()).setApkUrl(data.getApkUrl()).setAppName(data.getAppName()).setIconUrl(data.getIconUrl()).setPkgName(data.getCom.vivo.push.PushClientConstants.TAG_PKG_NAME java.lang.String()).setPkgSizeStr(data.getPkgSize()).setBusinessChannel(2).setSubscribeSource("1").setReportData(data.getReportData()));
        }

        @Override // com.tencent.ecommerce.biz.consumer.xinghuan.IECXingHuanGameButton
        public void setUi(ph0.b ui5) {
            Intrinsics.checkNotNullParameter(ui5, "ui");
            this.f407584d.setUiBuilder(new ButtonUiBuilder().setUiStyle(2).setBgCorner(ui5.getBgCorner()).setTextSize(ui5.getTextSize()).setCustomTextContentFetcher(new C10524b(ui5)).setCustomTextColorFetcher(new c(ui5)).setCustomBgAndFgDrawableFetcher(new d(ui5)));
        }

        @Override // com.tencent.ecommerce.biz.consumer.xinghuan.IECXingHuanGameButton
        public void update() {
            try {
                QLog.d("ECGameProxy", 1, "[createXingHuanGameButton] try update");
                this.f407584d.update();
            } catch (Exception e16) {
                QLog.e("ECGameProxy", 1, "[createXingHuanGameButton] update exception: " + e16);
            }
        }
    }

    static {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add(WadlProxyConsts.CMD_GAME_DYE_USER);
        hashSet.add(WadlProxyConsts.CMD_QUERY_SUBSCRIBE_STATUS);
        hashSet.add(WadlProxyConsts.CMD_GAME_SUBSCRIBE);
        f407583h = hashSet;
    }

    private final WadlParams g(String appId, String pkgName, String appName, String channelId, String downloadUrl) {
        WadlParams wadlParams = new WadlParams(appId, pkgName);
        wadlParams.apkUrl = downloadUrl;
        wadlParams.appName = appName;
        wadlParams.apkChannel = channelId;
        wadlParams.speedBuffer = 2048;
        return wadlParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            WadlResult wadlResult = (WadlResult) it.next();
            Iterator<IECGameEventReceiver> it5 = f407581e.iterator();
            while (it5.hasNext()) {
                IECGameEventReceiver next = it5.next();
                String str = wadlResult.wadlParams.appId;
                Intrinsics.checkNotNullExpressionValue(str, "wadlResult.wadlParams.appId");
                next.onDownloadStatusChanged(str, wadlResult.progress, wadlResult.taskStatus);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(WadlResult wadlResult) {
        Iterator<IECGameEventReceiver> it = f407581e.iterator();
        while (it.hasNext()) {
            IECGameEventReceiver next = it.next();
            String str = wadlResult.wadlParams.appId;
            Intrinsics.checkNotNullExpressionValue(str, "wadlResult.wadlParams.appId");
            next.onDownloadStatusChanged(str, wadlResult.progress, wadlResult.taskStatus);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(Function1 callback, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.invoke(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(Function1 callback, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.invoke(Boolean.FALSE);
    }

    @Override // com.tencent.ecommerce.biz.consumer.IECGameProxy
    public IECXingHuanGameButton createXingHuanGameButton(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new b(((IQQGameDistributeApi) QRoute.api(IQQGameDistributeApi.class)).createButton(context), new String().hashCode());
    }

    @Override // com.tencent.ecommerce.biz.consumer.IECGameProxy
    public void doDownloadAction(String appId, String pkgName, String appName, String channelId, String downloadUrl) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(pkgName, "pkgName");
        Intrinsics.checkNotNullParameter(appName, "appName");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(downloadUrl, "downloadUrl");
        WadlProxyServiceUtil.getProxyService().doDownloadAction(g(appId, appName, pkgName, channelId, downloadUrl));
    }

    @Override // com.tencent.ecommerce.biz.consumer.IECGameProxy
    public void doInstallAction(String appId, String pkgName, String appName, String channelId, String downloadUrl) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(pkgName, "pkgName");
        Intrinsics.checkNotNullParameter(appName, "appName");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(downloadUrl, "downloadUrl");
        WadlProxyServiceUtil.getProxyService().doInstallAction(g(appId, pkgName, appName, channelId, downloadUrl));
    }

    @Override // com.tencent.ecommerce.biz.consumer.IECGameProxy
    public void doPauseAction(String appId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        WadlProxyServiceUtil.getProxyService().doPauseAction(0, appId);
    }

    @Override // com.tencent.ecommerce.biz.consumer.IECGameProxy
    public void doQueryAllTask() {
        WadlProxyServiceUtil.getProxyService().doQueryAllTask();
    }

    @Override // com.tencent.ecommerce.biz.consumer.IECGameProxy
    public void doQuerySingleTask(String appId) {
        ArrayList<String> arrayListOf;
        Intrinsics.checkNotNullParameter(appId, "appId");
        WadlProxyServiceWrap proxyService = WadlProxyServiceUtil.getProxyService();
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(appId);
        proxyService.doQueryAction(arrayListOf);
    }

    @Override // com.tencent.ecommerce.biz.consumer.IECGameProxy
    public void doResumeAction(String appId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        WadlProxyServiceUtil.getProxyService().doResumeAction(0, appId);
    }

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
    public HashSet<String> getFilterCmds() {
        return f407583h;
    }

    @Override // com.tencent.ecommerce.biz.consumer.IECGameProxy
    public boolean isAppInstalled(Context context, String pkgName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pkgName, "pkgName");
        return PackageUtil.isAppInstalled(context, pkgName);
    }

    @Override // com.tencent.ecommerce.biz.consumer.IECGameProxy
    public boolean isWifiConnected(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return NetworkUtil.isWifiConnected(context);
    }

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
    public void onTrpcRsp(Intent request, String cmd, long ret, TrpcProxy.TrpcInovkeRsp rsp) {
        if (!Intrinsics.areEqual(WadlProxyConsts.CMD_GAME_DYE_USER, cmd) && !Intrinsics.areEqual(WadlProxyConsts.CMD_GAME_SUBSCRIBE, cmd)) {
            if (Intrinsics.areEqual(WadlProxyConsts.CMD_QUERY_SUBSCRIBE_STATUS, cmd)) {
                i(request, cmd, ret, rsp);
                return;
            }
            return;
        }
        j(request, cmd, ret, rsp);
    }

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface
    public void onWadlTaskStatusChanged(final WadlResult wadlResult) {
        QLog.d("ECGameProxy", 1, "onWadlTaskStatusChanged wadlResult = " + wadlResult);
        if ((wadlResult != null ? wadlResult.wadlParams : null) == null) {
            return;
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: if2.d
            @Override // java.lang.Runnable
            public final void run() {
                e.k(WadlResult.this);
            }
        });
    }

    @Override // com.tencent.ecommerce.biz.consumer.IECGameProxy
    public void openMiniApp(Context context, String scheme) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        if (!TextUtils.isEmpty(scheme)) {
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(context, scheme, 2016, null);
        } else {
            QLog.e("ECGameProxy", 1, "openMiniApp --> scheme is empty");
        }
    }

    @Override // com.tencent.ecommerce.biz.consumer.IECGameProxy
    public void querySubscribeStatus(String appId, String channelId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Bundle bundle = new Bundle();
        bundle.putString("appid", appId);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).querySubscribeStatus(appId, channelId, bundle);
    }

    @Override // com.tencent.ecommerce.biz.consumer.IECGameProxy
    public void querySubscribeStatusForKTV(String appId, String channelId, IECGameEventReceiver listener) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(listener, "listener");
        c cVar = new c(appId, listener);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(cVar);
        Bundle bundle = new Bundle();
        bundle.putString("appid", appId);
        bundle.putInt("key_ec_hashcode", cVar.hashCode());
        bundle.putBoolean("key_is_from_subs", true);
        QLog.i("ECGameProxy", 2, "querySubscribeStatusForKTV onQuerySubscribe subscribeStatus start  appid=" + appId + ", listener hashcode=" + cVar.hashCode() + ",ktv listener hashcode:" + listener.hashCode());
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).querySubscribeStatus(appId, channelId, bundle);
    }

    @Override // com.tencent.ecommerce.biz.consumer.IECGameProxy
    public void registerGameListener(IECGameEventReceiver receiver) {
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        LinkedList<IECGameEventReceiver> linkedList = f407581e;
        if (!linkedList.contains(receiver)) {
            linkedList.add(receiver);
        }
        WadlProxyServiceUtil.getProxyService().registerWadlServiceCallBack(this);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(this);
    }

    @Override // com.tencent.ecommerce.biz.consumer.IECGameProxy
    public void showNoWifiDialog(Context context, String noticeContent, final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(noticeContent, "noticeContent");
        Intrinsics.checkNotNullParameter(callback, "callback");
        DialogUtil.createCustomDialog(context, 230).setTitle("\u6e29\u99a8\u63d0\u9192").setMessage(noticeContent).setPositiveButton("\u7ee7\u7eed\u4e0b\u8f7d", new DialogInterface.OnClickListener() { // from class: if2.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                e.l(Function1.this, dialogInterface, i3);
            }
        }).setNegativeButton("\u6682\u505c\u4e0b\u8f7d", new DialogInterface.OnClickListener() { // from class: if2.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                e.m(Function1.this, dialogInterface, i3);
            }
        }).show();
    }

    @Override // com.tencent.ecommerce.biz.consumer.IECGameProxy
    public void startApp(Context context, String pkgName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pkgName, "pkgName");
        PackageUtil.startAppWithPkgName(context, pkgName, null);
    }

    @Override // com.tencent.ecommerce.biz.consumer.IECGameProxy
    public void subscribe(int dyeOpType, String taskKey, String channelId, String appId, String contentId) {
        QQGameGcSpkTaskDye.SubscribeReq subscribeReq;
        Intrinsics.checkNotNullParameter(taskKey, "taskKey");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(contentId, "contentId");
        if (dyeOpType == 1) {
            QQGameGcSpkTaskDye.SubscribeReq subscribeReq2 = new QQGameGcSpkTaskDye.SubscribeReq();
            subscribeReq2.subscribeType.set(1);
            subscribeReq = subscribeReq2;
        } else {
            subscribeReq = null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ECGameProxy", 2, "subscribe taskKey=" + taskKey + ", channelId=" + channelId + ", appId=" + appId + ", dyeOpType=" + dyeOpType);
        }
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).dyeUser(taskKey, channelId, appId, 2, dyeOpType, subscribeReq, "3", contentId);
    }

    @Override // com.tencent.ecommerce.biz.consumer.IECGameProxy
    public void subscribeGame(String appId, String channelId, String operation, String adTag) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(operation, "operation");
        Intrinsics.checkNotNullParameter(adTag, "adTag");
        Bundle bundle = new Bundle();
        bundle.putString("appid", appId);
        bundle.putString("type", operation);
        bundle.putBoolean("key_is_from_subs", true);
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).subscribe(appId, adTag, channelId, 1, bundle);
    }

    @Override // com.tencent.ecommerce.biz.consumer.IECGameProxy
    public void unRegisterGameListener(IECGameEventReceiver receiver) {
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        LinkedList<IECGameEventReceiver> linkedList = f407581e;
        linkedList.remove(receiver);
        if (linkedList.size() <= 0) {
            WadlProxyServiceUtil.getProxyService().unRegisterWadlServiceCallBack(this);
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).removeListener(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J.\u0010\r\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\u000e"}, d2 = {"if2/e$c", "Lcom/tencent/gamecenter/wadl/biz/listener/WadlTrpcListener;", "Ljava/util/HashSet;", "", "getFilterCmds", "Landroid/content/Intent;", Const.BUNDLE_KEY_REQUEST, "cmd", "", "ret", "Lcom/tencent/gamecenter/wadl/biz/entity/TrpcProxy$TrpcInovkeRsp;", "rsp", "", "onTrpcRsp", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class c implements WadlTrpcListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f407590d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ IECGameEventReceiver f407591e;

        c(String str, IECGameEventReceiver iECGameEventReceiver) {
            this.f407590d = str;
            this.f407591e = iECGameEventReceiver;
        }

        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
        public HashSet<String> getFilterCmds() {
            return e.f407583h;
        }

        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
        public void onTrpcRsp(Intent request, String cmd, long ret, TrpcProxy.TrpcInovkeRsp rsp) {
            PBEnumField pBEnumField;
            PBStringField pBStringField;
            PBBytesField pBBytesField;
            Integer num = null;
            String stringExtra = request != null ? request.getStringExtra("appid") : null;
            if (stringExtra != null && ret == 0) {
                if (((rsp == null || (pBBytesField = rsp.data) == null) ? null : pBBytesField.get()) != null) {
                    try {
                        QQGameQfsSubscribe.GetUserGameStatusRsp getUserGameStatusRsp = new QQGameQfsSubscribe.GetUserGameStatusRsp();
                        getUserGameStatusRsp.mergeFrom(rsp.data.get().toByteArray());
                        int i3 = getUserGameStatusRsp.result.get();
                        int i16 = getUserGameStatusRsp.follow_result.get();
                        int intExtra = request.getIntExtra("key_ec_hashcode", -1);
                        if (QLog.isColorLevel()) {
                            QLog.i("ECGameProxy", 2, "querySubscribeStatusForKTV onQuerySubscribe subscribeStatus=" + i3 + ", followStatus=" + i16 + ", respAppId:" + stringExtra + ",appid=" + this.f407590d + ",trpcListenerHashcode:" + intExtra + ",from listener hashcode:" + hashCode() + ",ktv listener hashcode:" + this.f407591e.hashCode());
                        }
                        if (Intrinsics.areEqual(stringExtra, this.f407590d) && intExtra == hashCode()) {
                            this.f407591e.onSubscribeStatus(stringExtra, i3, i16);
                            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).removeListener(this);
                            return;
                        }
                        QLog.i("ECGameProxy", 2, "querySubscribeStatusForKTV onQuerySubscribe subscribeStatus return by appId incorrect appid=" + this.f407590d + ", respAppId=" + stringExtra);
                        return;
                    } catch (Exception e16) {
                        QLog.e("ECGameProxy", 1, "querySubscribeStatusForKTV onQuerySubscribe error:" + e16);
                        return;
                    }
                }
            }
            String str = (rsp == null || (pBStringField = rsp.f106731msg) == null) ? null : pBStringField.get();
            if (rsp != null && (pBEnumField = rsp.errType) != null) {
                num = Integer.valueOf(pBEnumField.get());
            }
            QLog.e("ECGameProxy", 1, "querySubscribeStatusForKTV cmd:" + cmd + ", respAppId:" + stringExtra + ", ret:" + ret + ", errMsg:" + str + ", errType:" + num);
        }
    }

    private final void i(Intent request, String cmd, long ret, TrpcProxy.TrpcInovkeRsp rsp) {
        PBEnumField pBEnumField;
        PBStringField pBStringField;
        PBBytesField pBBytesField;
        Integer num = null;
        String stringExtra = request != null ? request.getStringExtra("appid") : null;
        if (stringExtra != null && ret == 0) {
            if (((rsp == null || (pBBytesField = rsp.data) == null) ? null : pBBytesField.get()) != null) {
                try {
                    QQGameQfsSubscribe.GetUserGameStatusRsp getUserGameStatusRsp = new QQGameQfsSubscribe.GetUserGameStatusRsp();
                    getUserGameStatusRsp.mergeFrom(rsp.data.get().toByteArray());
                    int i3 = getUserGameStatusRsp.result.get();
                    int i16 = getUserGameStatusRsp.follow_result.get();
                    if (QLog.isColorLevel()) {
                        QLog.i("ECGameProxy", 2, "onQuerySubscribe subscribeStatus=" + i3 + ", followStatus=" + i16 + ", appid=" + stringExtra);
                    }
                    Iterator<IECGameEventReceiver> it = f407581e.iterator();
                    while (it.hasNext()) {
                        it.next().onSubscribeStatus(stringExtra, i3, i16);
                    }
                    return;
                } catch (Exception e16) {
                    QLog.e("ECGameProxy", 1, "onQuerySubscribe error:" + e16);
                    return;
                }
            }
        }
        String str = (rsp == null || (pBStringField = rsp.f106731msg) == null) ? null : pBStringField.get();
        if (rsp != null && (pBEnumField = rsp.errType) != null) {
            num = Integer.valueOf(pBEnumField.get());
        }
        QLog.e("ECGameProxy", 1, "onQuerySubscribe cmd:" + cmd + ", appId:" + stringExtra + ", ret:" + ret + ", errMsg:" + str + ", errType:" + num);
    }

    private final void j(Intent request, String cmd, long ret, TrpcProxy.TrpcInovkeRsp rsp) {
        PBEnumField pBEnumField;
        PBStringField pBStringField;
        PBBytesField pBBytesField;
        Integer num = null;
        String stringExtra = request != null ? request.getStringExtra("appid") : null;
        Integer valueOf = request != null ? Integer.valueOf(request.getIntExtra("type", -1)) : null;
        boolean booleanExtra = request != null ? request.getBooleanExtra("key_is_from_subs", false) : false;
        if (stringExtra != null && ret == 0) {
            if (((rsp == null || (pBBytesField = rsp.data) == null) ? null : pBBytesField.get()) != null) {
                try {
                    if (booleanExtra) {
                        QQGameSubscribe$SubscribeUpComingGameRsp qQGameSubscribe$SubscribeUpComingGameRsp = new QQGameSubscribe$SubscribeUpComingGameRsp();
                        qQGameSubscribe$SubscribeUpComingGameRsp.mergeFrom(rsp.data.get().toByteArray());
                        int i3 = qQGameSubscribe$SubscribeUpComingGameRsp.result.get();
                        if (QLog.isColorLevel()) {
                            QLog.i("ECGameProxy", 2, "isFromSubscribeGame subscribeStatus=" + i3);
                        }
                        Iterator<IECGameEventReceiver> it = f407581e.iterator();
                        while (it.hasNext()) {
                            it.next().onSubscribeStatus(stringExtra, i3, i3);
                        }
                        return;
                    }
                    if (valueOf != null && valueOf.intValue() == 1) {
                        QQGameGcSpkTaskDye.GetDyedRsp getDyedRsp = new QQGameGcSpkTaskDye.GetDyedRsp();
                        getDyedRsp.mergeFrom(rsp.data.get().toByteArray());
                        int i16 = getDyedRsp.subscribe_rsp.get().result.get();
                        if (QLog.isColorLevel()) {
                            QLog.i("ECGameProxy", 2, "onSubscribe subscribeStatus=" + i16);
                        }
                        Iterator<IECGameEventReceiver> it5 = f407581e.iterator();
                        while (it5.hasNext()) {
                            it5.next().onSubscribeStatus(stringExtra, i16, 0);
                        }
                        return;
                    }
                    return;
                } catch (Exception e16) {
                    QLog.e("ECGameProxy", 1, "onSubscribe error:" + e16);
                    return;
                }
            }
        }
        String str = (rsp == null || (pBStringField = rsp.f106731msg) == null) ? null : pBStringField.get();
        if (rsp != null && (pBEnumField = rsp.errType) != null) {
            num = Integer.valueOf(pBEnumField.get());
        }
        QLog.e("ECGameProxy", 1, "onSubscribe cmd:" + cmd + ", appId:" + stringExtra + ", type:" + valueOf + ", ret:" + ret + ", errMsg:" + str + ", errType:" + num + ", isFromSubscribeGame:" + booleanExtra);
    }

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface
    public void onQueryCallback(final ArrayList<WadlResult> wadlResults) {
        if (wadlResults == null) {
            return;
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: if2.c
            @Override // java.lang.Runnable
            public final void run() {
                e.h(wadlResults);
            }
        });
    }

    @Override // com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface
    public void onQueryCallbackVia(ArrayList<WadlResult> wadlResults) {
    }
}

package com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.Window;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.api.IAELaunchRecorder;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ark.Constants;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.AppInterface;
import com.tencent.ecommerce.base.ktx.ViewExtKt;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.hippy.qq.module.QQUiModule;
import com.tencent.hippy.qq.utils.HippySaveToPhotoHelper;
import com.tencent.hippy.qq.utils.HippySharePanelHelper;
import com.tencent.hippy.qq.view.scroll.HippyHeaderListViewController;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.kuikly.core.render.android.c;
import com.tencent.kuikly.core.render.android.expand.component.KRTextFieldView;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.activateFriend.ae;
import com.tencent.mobileqq.activity.notifyservice.NotifyServiceBisConfigFragment;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.PublicAccountShowPictureReport;
import com.tencent.mobileqq.gamecenter.api.IGameCenterFriendApi;
import com.tencent.mobileqq.gamecenter.api.IGameCenterQIPCModuleApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.jsp.ShareMsgImpl;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyPlatform;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.sharepanel.api.ISharePanelApi;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vaswebviewplugin.QWalletMixJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasCommonJsPlugin;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQCustomArkDialogUtil;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.model.PhotoInfo;
import cooperation.qzone.model.PictureUrl;
import cooperation.qzone.model.VideoInfo;
import cooperation.qzone.model.VideoUrl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0002I]\u0018\u0000 \u00042\u00020\u00012\u00020\u0002:\u0001fB\u0007\u00a2\u0006\u0004\bd\u0010eJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J5\u0010\r\u001a\u00020\n2+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000bH\u0002J?\u0010\u0010\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000bH\u0002J?\u0010\u0011\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000bH\u0002J?\u0010\u0012\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000bH\u0002J?\u0010\u0013\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000bH\u0002JG\u0010\u0016\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\nH\u0002J\b\u0010\u0018\u001a\u00020\nH\u0002JG\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000bH\u0002J?\u0010\u001b\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000bH\u0002J?\u0010\u001c\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000bH\u0002J?\u0010\u001d\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000bH\u0002J(\u0010#\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u00142\u0006\u0010\"\u001a\u00020!H\u0002J\u0018\u0010(\u001a\u00020\n2\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&H\u0002J?\u0010)\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000bH\u0002J?\u0010*\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000bH\u0002J\n\u0010,\u001a\u0004\u0018\u00010+H\u0002J\u0012\u0010-\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J?\u0010.\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000bH\u0002J\u0018\u00103\u001a\u00020\n2\u0006\u00100\u001a\u00020/2\u0006\u00102\u001a\u000201H\u0002J5\u00104\u001a\u00020\n2+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000bH\u0002J?\u00105\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000bH\u0002J&\u00108\u001a\u00020\n2\u0006\u00106\u001a\u00020\u000e2\u0014\u00107\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010$\u0012\u0004\u0012\u00020\n0\u0005H\u0002JI\u0010:\u001a\u0004\u0018\u00010\u00062\u0006\u00109\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000bH\u0016J\u001c\u0010>\u001a\u00020\n2\b\u0010<\u001a\u0004\u0018\u00010;2\b\u0010=\u001a\u0004\u0018\u00010;H\u0016J\b\u0010?\u001a\u00020\nH\u0016R0\u0010E\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020A0@j\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020A`B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010H\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010P\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010ORG\u0010W\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u0018\u0010[\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010\\\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010GR\u0016\u0010_\u001a\u00020]8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010^R\u001a\u0010c\u001a\b\u0012\u0004\u0012\u00020&0`8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\ba\u0010b\u00a8\u0006g"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/QQUIModule;", "Li01/e;", "Lcom/tencent/mobileqq/activity/activateFriend/ae$b;", "", UserInfo.SEX_FEMALE, "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "P", "", "params", "e0", "X", "U", "W", "", "handleWhiteList", "V", "J", "b0", "module", "Y", BdhLogUtil.LogTag.Tag_Req, "d0", "D", "gameAppId", "isShowGameFriend", "isShowGroup", "Lcom/tencent/mtt/hippy/modules/Promise;", "promise", "f0", "Landroid/content/Intent;", "intent", "", QzoneIPCModule.RESULT_CODE, "H", ExifInterface.LATITUDE_SOUTH, "G", "Lcom/tencent/common/app/AppInterface;", "B", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "L", "Lorg/json/JSONObject;", "data", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "dialog", "g0", BdhLogUtil.LogTag.Tag_Conn, HippyTKDListViewAdapter.X, "jsonString", "block", "w", "method", "call", "Landroid/os/Bundle;", "bundle", "requestBundle", "queryHasSetNotify", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "d", "Ljava/util/HashMap;", "mLastSendProgressEventTimeMap", "e", "Lcom/tencent/mtt/hippy/modules/Promise;", "mGetFriendInfoPromise", "com/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/QQUIModule$c", "f", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/QQUIModule$c;", "currentRenderLifecycleCallback", "Landroid/content/BroadcastReceiver;", tl.h.F, "Landroid/content/BroadcastReceiver;", "mCallReceiver", "i", "Lkotlin/jvm/functions/Function1;", "getQqNotifyCallback", "()Lkotlin/jvm/functions/Function1;", "T", "(Lkotlin/jvm/functions/Function1;)V", "qqNotifyCallback", "Lcom/tencent/mobileqq/jsp/ShareMsgImpl;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/jsp/ShareMsgImpl;", "mShareMsgImpl", "mShareMsgPromise", "com/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/QQUIModule$h", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/QQUIModule$h;", "mShareMsgImplListener", "Landroid/util/SparseArray;", "E", "Landroid/util/SparseArray;", "FRIEND_TYPE_MAP", "<init>", "()V", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class QQUIModule extends i01.e implements ae.b {

    /* renamed from: C, reason: from kotlin metadata */
    private Promise mShareMsgPromise;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Promise mGetFriendInfoPromise;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private BroadcastReceiver mCallReceiver;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Function1<Object, Unit> qqNotifyCallback;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ShareMsgImpl mShareMsgImpl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final HashMap<String, Long> mLastSendProgressEventTimeMap = new HashMap<>();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private c currentRenderLifecycleCallback = new c();

    /* renamed from: D, reason: from kotlin metadata */
    private h mShareMsgImplListener = new h();

    /* renamed from: E, reason: from kotlin metadata */
    private final SparseArray<Integer> FRIEND_TYPE_MAP = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001\u00a8\u0006\u0003"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/QQUIModule$b", "Landroid/util/SparseArray;", "", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends SparseArray<Integer> {
        b() {
            put(0, 1);
            put(1, 2);
            put(10018, 3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/QQUIModule$c", "Lcom/tencent/kuikly/core/render/android/c;", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "", "onActivityResult", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements com.tencent.kuikly.core.render.android.c {
        c() {
        }

        @Override // com.tencent.kuikly.core.render.android.c
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            ShareMsgImpl shareMsgImpl;
            ShareMsgImpl shareMsgImpl2;
            QLog.d("QQUIModule", 2, "[onActivityResult] requestCode: " + requestCode + ", resultCode: " + resultCode);
            c.a.a(this, requestCode, resultCode, data);
            if (requestCode != 1) {
                if (requestCode != 3) {
                    if (requestCode == 16 && data != null) {
                        QQUIModule.this.H(data, resultCode);
                    }
                } else if (data != null && (shareMsgImpl2 = QQUIModule.this.mShareMsgImpl) != null) {
                    shareMsgImpl2.f(data, (byte) requestCode, resultCode);
                }
            } else if (data != null && (shareMsgImpl = QQUIModule.this.mShareMsgImpl) != null) {
                shareMsgImpl.f(data, (byte) requestCode, resultCode);
            }
            QQUIModule.this.removeKuiklyRenderLifeCycleCallback(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/QQUIModule$d", "Lcom/tencent/mobileqq/sharepanel/j;", "", "channelId", "", "a", "actionId", "b", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements com.tencent.mobileqq.sharepanel.j {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f262934a;

        d(Function1<Object, Unit> function1) {
            this.f262934a = function1;
        }

        @Override // com.tencent.mobileqq.sharepanel.j
        public void a(String channelId) {
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            QQUIModule.z(this.f262934a, "shareChannel", channelId);
        }

        @Override // com.tencent.mobileqq.sharepanel.j
        public void b(String actionId) {
            Intrinsics.checkNotNullParameter(actionId, "actionId");
            QQUIModule.z(this.f262934a, "appendAction", actionId);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/QQUIModule$e", "Lcom/tencent/mobileqq/sharepanel/l;", "", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class e implements com.tencent.mobileqq.sharepanel.l {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f262937a;

        e(Function1<Object, Unit> function1) {
            this.f262937a = function1;
        }

        @Override // com.tencent.mobileqq.sharepanel.l
        public void a() {
            QQUIModule.A(this.f262937a, "shown", null, 4, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/QQUIModule$f", "Lcom/tencent/mobileqq/sharepanel/k;", "", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class f implements com.tencent.mobileqq.sharepanel.k {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f262938a;

        f(Function1<Object, Unit> function1) {
            this.f262938a = function1;
        }

        @Override // com.tencent.mobileqq.sharepanel.k
        public void a() {
            QQUIModule.A(this.f262938a, "dismiss", null, 4, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/QQUIModule$h", "Lcom/tencent/mobileqq/jsp/ShareMsgImpl$b;", "", "callbackId", "result", "", "onSharMsgcallback", "Landroid/content/Intent;", "intent", "", "requestCode", IAELaunchRecorder.MILESTONE_START_ACTIVITY, "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class h implements ShareMsgImpl.b {
        h() {
        }

        @Override // com.tencent.mobileqq.jsp.ShareMsgImpl.b
        public void onSharMsgcallback(String callbackId, String result) {
            Promise promise;
            Intrinsics.checkNotNullParameter(callbackId, "callbackId");
            Intrinsics.checkNotNullParameter(result, "result");
            if (QQUIModule.this.mShareMsgPromise != null) {
                Promise promise2 = QQUIModule.this.mShareMsgPromise;
                if (!Intrinsics.areEqual(promise2 != null ? promise2.getCallId() : null, callbackId) || (promise = QQUIModule.this.mShareMsgPromise) == null) {
                    return;
                }
                promise.resolve(result);
            }
        }

        @Override // com.tencent.mobileqq.jsp.ShareMsgImpl.b
        public void startActivityForResult(Intent intent, byte requestCode) {
            Activity activity;
            Intrinsics.checkNotNullParameter(intent, "intent");
            if (QQUIModule.this.getActivity() == null || (activity = QQUIModule.this.getActivity()) == null) {
                return;
            }
            activity.startActivityForResult(intent, requestCode);
        }
    }

    private final AppInterface B() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            return (AppInterface) peekAppRuntime;
        }
        return null;
    }

    private final void C(Function1<Object, Unit> callback) {
        pf2.a aVar = new pf2.a();
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int a16 = aVar.a(context);
        if (callback != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("percent", a16);
            callback.invoke(jSONObject.toString());
        }
    }

    private final void D(String params, final Function1<Object, Unit> callback) {
        if (QLog.isColorLevel()) {
            QLog.d("QQUIModule", 2, "[getFriendInfo], params:" + params);
        }
        try {
            JSONObject jSONObject = new JSONObject(params);
            final String string = jSONObject.getString("appid");
            Intrinsics.checkNotNullExpressionValue(string, "paramsJson.getString(\"appid\")");
            final boolean z16 = jSONObject.getBoolean("withGroup");
            ((IGameCenterQIPCModuleApi) QRoute.api(IGameCenterQIPCModuleApi.class)).getGameFriendEnableStatus(string, new com.tencent.mobileqq.gamecenter.api.k() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.ae
                @Override // com.tencent.mobileqq.gamecenter.api.k
                public final void onResult(Object obj) {
                    QQUIModule.E(QQUIModule.this, string, z16, callback, ((Boolean) obj).booleanValue());
                }
            });
        } catch (Exception e16) {
            QLog.e("QQUIModule", 1, e16, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(QQUIModule this$0, String gameAppId, boolean z16, Function1 function1, boolean z17) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(gameAppId, "$gameAppId");
        this$0.addKuiklyRenderLifecycleCallback(this$0.currentRenderLifecycleCallback);
        this$0.f0(gameAppId, z17, z16, new g(function1));
    }

    private final float F() {
        return ((IQQKuiklyPlatform) QRoute.api(IQQKuiklyPlatform.class)).getTabBarHeight() / ViewUtils.getDensity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(Intent intent, int resultCode) {
        QLog.d("QQUIModule", 2, "[handleChooseFriendResult], resultCode:" + resultCode);
        int i3 = -1;
        if (resultCode != -1) {
            return;
        }
        QRouteApi api = QRoute.api(IGameCenterFriendApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(\n            IGameCe\u2026Api::class.java\n        )");
        IGameCenterFriendApi iGameCenterFriendApi = (IGameCenterFriendApi) api;
        final Integer friendType = this.FRIEND_TYPE_MAP.get(intent.getIntExtra("uintype", -1));
        final String stringExtra = intent.getStringExtra("uinname");
        final String stringExtra2 = intent.getStringExtra("uin");
        String stringExtra3 = intent.getStringExtra(AppConstants.Key.KEY_GC_SENDER_ID);
        if (TextUtils.isEmpty(stringExtra3)) {
            AppInterface B = B();
            stringExtra3 = B != null ? B.getCurrentAccountUin() : null;
        }
        final String str = stringExtra3;
        String stringExtra4 = intent.getStringExtra(AppConstants.Key.KEY_GC_GAME_APPID);
        if (stringExtra4 == null || stringExtra4.length() == 0) {
            try {
                JSONObject jSONObject = new JSONObject();
                if (friendType != null) {
                    i3 = friendType.intValue();
                }
                jSONObject.put("uinType", i3);
                jSONObject.put("name", stringExtra);
                jSONObject.put("uin", stringExtra2);
                jSONObject.put("ret", 0);
                Promise promise = this.mGetFriendInfoPromise;
                if (promise != null) {
                    promise.resolve(jSONObject.toString());
                    return;
                }
                return;
            } catch (Exception e16) {
                QLog.e("QQUIModule", 1, e16, new Object[0]);
                return;
            }
        }
        String stringExtra5 = intent.getStringExtra(AppConstants.Key.KEY_GC_GAME_APPID);
        Intrinsics.checkNotNullExpressionValue(friendType, "friendType");
        iGameCenterFriendApi.reportFriendChooseResult(stringExtra5, friendType.intValue(), "1");
        iGameCenterFriendApi.getTokenForFriendChosen(str, stringExtra2, new com.tencent.mobileqq.gamecenter.api.k() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.ai
            @Override // com.tencent.mobileqq.gamecenter.api.k
            public final void onResult(Object obj) {
                QQUIModule.I(stringExtra, friendType, stringExtra2, str, this, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(String str, Integer friendType, String str2, String str3, QQUIModule this$0, String str4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(str4)) {
                jSONObject2.put("name", str);
                Intrinsics.checkNotNullExpressionValue(friendType, "friendType");
                jSONObject2.put("type", friendType.intValue());
                jSONObject2.put("friendId", str2);
                jSONObject2.put("senderId", str3);
                jSONObject2.put("token", str4);
                jSONObject.put(GuildMsgItem.NICK_FRIEND, jSONObject2);
                jSONObject.put("ret", 0);
            } else {
                jSONObject.put("ret", 1);
            }
        } catch (JSONException e16) {
            QLog.e(QQUiModule.CLASSNAME, 2, "[handleChooseFriendResult] " + e16);
        }
        Promise promise = this$0.mGetFriendInfoPromise;
        if (promise != null) {
            promise.resolve(jSONObject.toString());
        }
    }

    private final void J() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.ac
            @Override // java.lang.Runnable
            public final void run() {
                QQUIModule.K(QQUIModule.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(QQUIModule this$0) {
        Window window;
        View decorView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = this$0.getActivity();
        if (activity == null || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 2);
    }

    private final void R(String params, Function1<Object, Unit> callback) {
        if (QLog.isColorLevel()) {
            QLog.i("QQUIModule", 2, "preloadToolProcess===>");
        }
        try {
            int optInt = new JSONObject(params).optInt("from");
            QLog.i("QQUIModule", 1, "[preloadToolProcess]from:" + optInt);
            ((IWebProcessManagerService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IWebProcessManagerService.class, "")).startWebProcess(optInt, null);
        } catch (Exception e16) {
            QLog.e("QQUIModule", 1, e16, new Object[0]);
        }
    }

    private final void S(String params, Function1<Object, Unit> callback) {
        HippySaveToPhotoHelper.INSTANCE.saveToPhoto(params, new j(callback), new Function2<String, Float, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.QQUIModule$saveToPhoto$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str, Float f16) {
                invoke(str, f16.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(String url, float f16) {
                HashMap hashMap;
                HashMap hashMap2;
                com.tencent.kuikly.core.render.android.d O0;
                Map mapOf;
                Intrinsics.checkNotNullParameter(url, "url");
                hashMap = QQUIModule.this.mLastSendProgressEventTimeMap;
                Long l3 = (Long) hashMap.get(url);
                if (l3 == null) {
                    l3 = 0L;
                }
                if (Math.abs(System.currentTimeMillis() - l3.longValue()) < 100) {
                    if (!(f16 == 100.0f)) {
                        return;
                    }
                }
                hashMap2 = QQUIModule.this.mLastSendProgressEventTimeMap;
                hashMap2.put(url, Long.valueOf(System.currentTimeMillis()));
                com.tencent.kuikly.core.render.android.a aVar = QQUIModule.this.get_kuiklyRenderContext();
                if (aVar == null || (O0 = aVar.O0()) == null) {
                    return;
                }
                mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("url", url), TuplesKt.to("progress", Float.valueOf(f16)));
                O0.d(HippySaveToPhotoHelper.EVENT_HIPPY_SAVE_TO_PHOTO_PROGRESS_CHANGE, mapOf);
            }
        }, getActivity());
    }

    private final void V(String params, Function1<Object, Unit> callback, boolean handleWhiteList) {
        QLog.d("QQUIModule", 2, "[shareArkMessage] params: " + params);
        if (TextUtils.isEmpty(params)) {
            return;
        }
        Activity activity = getActivity();
        AppInterface B = B();
        if ((activity instanceof QBaseActivity) && B != null) {
            if (this.mShareMsgImpl == null) {
                this.mShareMsgImpl = new ShareMsgImpl(activity, activity, B, this.mShareMsgImplListener);
            }
            try {
                this.mShareMsgPromise = null;
                JSONObject jSONObject = new JSONObject(params);
                if (callback != null) {
                    k kVar = new k(callback);
                    this.mShareMsgPromise = kVar;
                    jSONObject.put("callback", kVar.getCallId());
                }
                addKuiklyRenderLifecycleCallback(this.currentRenderLifecycleCallback);
                ShareMsgImpl shareMsgImpl = this.mShareMsgImpl;
                if (shareMsgImpl != null) {
                    shareMsgImpl.o(jSONObject.toString(), handleWhiteList);
                    return;
                }
                return;
            } catch (Throwable th5) {
                QLog.e("QQUIModule", 1, "shareMessage error:" + th5);
                return;
            }
        }
        QLog.e("QQUIModule", 1, "shareArkMessage activity isn'o't BaseActivity or appinterface is null");
    }

    private final void X(String params, Function1<Object, Unit> callback) {
        QLog.d("QQUIModule", 2, "[shareMessage] params: " + params);
        if (TextUtils.isEmpty(params)) {
            return;
        }
        Activity activity = getActivity();
        AppInterface B = B();
        if ((activity instanceof QBaseActivity) && B != null) {
            QBaseActivity qBaseActivity = (QBaseActivity) activity;
            if (this.mShareMsgImpl == null) {
                this.mShareMsgImpl = new ShareMsgImpl(qBaseActivity, qBaseActivity, B, this.mShareMsgImplListener);
            }
            try {
                this.mShareMsgPromise = null;
                JSONObject jSONObject = new JSONObject(params);
                if (callback != null) {
                    l lVar = new l(callback);
                    this.mShareMsgPromise = lVar;
                    jSONObject.put("callback", lVar.getCallId());
                }
                addKuiklyRenderLifecycleCallback(this.currentRenderLifecycleCallback);
                ShareMsgImpl shareMsgImpl = this.mShareMsgImpl;
                if (shareMsgImpl != null) {
                    shareMsgImpl.r(jSONObject.toString(), false);
                    return;
                }
                return;
            } catch (Throwable th5) {
                QLog.e("QQUIModule", 1, "shareMessage error:" + th5);
                return;
            }
        }
        QLog.e("QQUIModule", 1, "shareMessage activity isn'o't BaseActivity or appinterface is null");
    }

    private final void Y(QQUIModule module, String params, Function1<Object, Unit> callback) {
        if (QLog.isColorLevel()) {
            QLog.i("QQUIModule", 2, "showKeyboard===>");
        }
        Activity activity = getActivity();
        if (activity == null) {
            activity = Foreground.getTopActivity();
        }
        if (activity == null) {
            QLog.i("QQUIModule", 2, "showKeyboard ctx is null");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(params);
            QLog.i("QQUIModule", 1, "[showKeyboard] param:" + params);
            boolean z16 = jSONObject.optInt("show", 0) == 1;
            final View viewWithTag = module.viewWithTag(jSONObject.getInt("view_id"));
            if (viewWithTag == null) {
                return;
            }
            if (z16) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.ag
                    @Override // java.lang.Runnable
                    public final void run() {
                        QQUIModule.Z(viewWithTag, this);
                    }
                });
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.ah
                    @Override // java.lang.Runnable
                    public final void run() {
                        QQUIModule.a0(viewWithTag, this);
                    }
                });
            }
        } catch (Exception e16) {
            QLog.e("QQUIModule", 1, e16, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(View view, QQUIModule this$0) {
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        view.requestFocus();
        com.tencent.mobileqq.litelivesdk.utils.a.b(this$0.getActivity(), (KRTextFieldView) view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(View view, QQUIModule this$0) {
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        view.clearFocus();
        com.tencent.mobileqq.litelivesdk.utils.a.a(this$0.getActivity(), (KRTextFieldView) view);
    }

    private final void b0() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.af
            @Override // java.lang.Runnable
            public final void run() {
                QQUIModule.c0(QQUIModule.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(QQUIModule this$0) {
        Window window;
        View decorView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = this$0.getActivity();
        if (activity == null || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & (-3));
    }

    private final void e0(String params, Function1<Object, Unit> callback) {
        QLog.d("QQUIModule", 2, "[showSharePanel] params: " + params);
        HippySharePanelHelper.INSTANCE.showSharePanel(params, new m(callback), getActivity());
    }

    private final void f0(String gameAppId, boolean isShowGameFriend, boolean isShowGroup, Promise promise) {
        Intent intent = new Intent(getActivity(), (Class<?>) ForwardRecentActivity.class);
        intent.putExtra("forward_type", 1058);
        intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 1);
        intent.putExtra(AppConstants.Key.KEY_GC_GAME_APPID, gameAppId);
        intent.putExtra(AppConstants.Key.KEY_GC_SHOW_GAME_FRIEND_ENTRANCE, isShowGameFriend);
        intent.putExtra(AppConstants.Key.KEY_GC_SHOW_TROOP_ENTRANCE, isShowGroup);
        intent.putExtra(AppConstants.Key.KEY_GC_GET_FRIEND_INFO_SRC, "1");
        this.mGetFriendInfoPromise = promise;
        Activity activity = getActivity();
        if (activity != null) {
            activity.startActivityForResult(intent, 16);
        }
    }

    private final void g0(JSONObject data, QQCustomDialog dialog) {
        Integer num;
        String optString = data.optString("theme");
        if (Intrinsics.areEqual(optString, "day")) {
            num = 1001;
        } else {
            num = Intrinsics.areEqual(optString, "night") ? 1002 : null;
        }
        if (num != null) {
            dialog.setThemeId(num.intValue());
        }
    }

    private static final void y(Function1<Object, Unit> function1, String str) {
        QLog.e("QQUIModule", 1, "showNewSharePanel: " + str);
        if (function1 != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("success", false);
            jSONObject.put("error", str);
            function1.invoke(jSONObject.toString());
        }
    }

    public final void T(Function1<Object, Unit> function1) {
        this.qqNotifyCallback = function1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000a. Please report as an issue. */
    @Override // i01.e, i01.a
    public Object call(String method, String params, Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        switch (method.hashCode()) {
            case -2054742942:
                if (method.equals(VasCommonJsPlugin.H5_CALLBACK_GETFRIENDINFO)) {
                    D(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -1808499524:
                if (method.equals("shareImage")) {
                    return Boolean.valueOf(new pf2.r().e(this, params, callback, getActivity()));
                }
                return super.call(method, params, callback);
            case -1409789127:
                if (method.equals("shareArkMessageSafe")) {
                    W(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -1271503318:
                if (method.equals("toggleToFullScreen")) {
                    new pf2.e().h(params, getActivity(), callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -1090075252:
                if (method.equals("shareArkMessage")) {
                    U(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -1083082359:
                if (method.equals("qqNotify")) {
                    new pf2.p().m(this, params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -978331090:
                if (method.equals("openChooseFriendPage")) {
                    P(callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -897469656:
                if (method.equals("showNewSharePanel")) {
                    x(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -838211343:
                if (method.equals("showNavigation")) {
                    b0();
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -523672119:
                if (method.equals("gotoNoticeServicePage")) {
                    G(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -478170054:
                if (method.equals("saveToPhoto")) {
                    S(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -417400442:
                if (method.equals("screenShot")) {
                    new pf2.j().t(this, params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -348232188:
                if (method.equals("showKeyboard")) {
                    Y(this, params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -208290750:
                if (method.equals("showSharePanel")) {
                    e0(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -189582527:
                if (method.equals("showPicture")) {
                    d0(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -172929455:
                if (method.equals("openTransparentWebView")) {
                    Q(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 163601886:
                if (method.equals("saveImage")) {
                    new pf2.j().l(this, params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 536706856:
                if (method.equals("shareMessage")) {
                    X(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 857515547:
                if (method.equals("getQQTabBarHeight")) {
                    return Float.valueOf(F());
                }
                return super.call(method, params, callback);
            case 995006710:
                if (method.equals("hideNavigation")) {
                    J();
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1071025434:
                if (method.equals("openAlertDialog")) {
                    L(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1219146018:
                if (method.equals("longScreenShot")) {
                    new pf2.j().k(this, params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1461525486:
                if (method.equals("preloadToolProcess")) {
                    R(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1961271918:
                if (method.equals("getBatteryPercent")) {
                    C(callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            default:
                return super.call(method, params, callback);
        }
    }

    @Override // i01.e, i01.a
    public void onDestroy() {
        super.onDestroy();
        this.qqNotifyCallback = null;
    }

    private final void P(Function1<Object, Unit> callback) {
        QLog.d("QQUIModule", 2, "[openChooseFriendPage] ");
        addKuiklyRenderLifecycleCallback(this.currentRenderLifecycleCallback);
        f0("", false, true, new i(callback));
    }

    private final void U(String params, Function1<Object, Unit> callback) {
        V(params, callback, true);
    }

    private final void W(String params, Function1<Object, Unit> callback) {
        V(params, callback, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(Function1 function1, DialogInterface dialogInterface, int i3) {
        Map mapOf;
        if (function1 != null) {
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("isRightButtonClick", Boolean.FALSE));
            function1.invoke(mapOf);
        }
    }

    private final void d0(String params, final Function1<Object, Unit> callback) {
        String str;
        PublicAccountShowPictureReport publicAccountShowPictureReport;
        ArrayList arrayList;
        ArrayList arrayList2;
        if (!(getActivity() instanceof QBaseActivity)) {
            QLog.e("QQUIModule", 1, "showPicture activity is not QBaseActivity");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(params);
            String optString = jSONObject.optString("bigurl");
            if (!TextUtils.isEmpty(optString)) {
                String optString2 = jSONObject.optString("videoID");
                String optString3 = jSONObject.optString("videoURL");
                jSONObject.optString("originalVideoURL");
                int optInt = jSONObject.optInt("videoWidth");
                int optInt2 = jSONObject.optInt("videoHeight");
                jSONObject.optBoolean("isLike");
                QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
                Bundle bundle = new Bundle();
                ArrayList arrayList3 = new ArrayList();
                PhotoInfo photoInfo = new PhotoInfo();
                photoInfo.bigUrl = optString;
                photoInfo.videoflag = 1;
                VideoInfo videoInfo = new VideoInfo();
                photoInfo.videodata = videoInfo;
                videoInfo.videoId = optString2;
                PictureUrl pictureUrl = new PictureUrl();
                pictureUrl.url = optString;
                photoInfo.videodata.coverUrl = pictureUrl;
                VideoUrl videoUrl = new VideoUrl();
                videoUrl.url = optString3;
                VideoInfo videoInfo2 = photoInfo.videodata;
                videoInfo2.videoId = optString2;
                videoInfo2.actionUrl = optString3;
                videoInfo2.videoUrl = videoUrl;
                videoInfo2.width = optInt;
                videoInfo2.height = optInt2;
                videoInfo2.videoStatus = 5;
                arrayList3.add(photoInfo);
                bundle.putSerializable("picturelist", arrayList3);
                bundle.putInt("curindex", 0);
                bundle.putInt("mode", 3);
                bundle.putBoolean("need_clear_cache", true);
                QZoneHelper.forwardToPictureViewer(getActivity(), userInfo, bundle, 6);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("imageIDs");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("likes");
            JSONArray optJSONArray3 = jSONObject.optJSONArray("descs");
            JSONArray optJSONArray4 = jSONObject.optJSONArray("sourceIDs");
            JSONArray optJSONArray5 = jSONObject.optJSONArray("sourceSize");
            boolean optBoolean = jSONObject.optBoolean("needBottomBar");
            JSONObject optJSONObject = jSONObject.optJSONObject("extra");
            if (optJSONObject == null || (str = optJSONObject.toString()) == null) {
                str = "";
            }
            int optInt3 = jSONObject.optInt("index");
            String optString4 = jSONObject.optString("srcID");
            if (jSONObject.optBoolean("isReport")) {
                PublicAccountShowPictureReport publicAccountShowPictureReport2 = new PublicAccountShowPictureReport();
                publicAccountShowPictureReport2.parse(jSONObject);
                publicAccountShowPictureReport = publicAccountShowPictureReport2;
            } else {
                publicAccountShowPictureReport = null;
            }
            boolean optBoolean2 = jSONObject.optBoolean("isNotShowIndex", true);
            if (optJSONArray == null || optJSONArray.length() == 0 || B() == null) {
                return;
            }
            ArrayList arrayList4 = new ArrayList();
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                arrayList4.add(optJSONArray.get(i3).toString());
            }
            if (optJSONArray4 != null) {
                ArrayList arrayList5 = new ArrayList();
                int length2 = optJSONArray4.length();
                for (int i16 = 0; i16 < length2; i16++) {
                    arrayList5.add(optJSONArray4.get(i16).toString());
                }
                arrayList = arrayList5;
            } else {
                arrayList = null;
            }
            if (optJSONArray5 != null) {
                ArrayList arrayList6 = new ArrayList();
                int length3 = optJSONArray5.length();
                for (int i17 = 0; i17 < length3; i17++) {
                    arrayList6.add(optJSONArray5.get(i17).toString());
                }
                arrayList2 = arrayList6;
            } else {
                arrayList2 = null;
            }
            boolean optBoolean3 = jSONObject.optBoolean("showTitle", false);
            String optString5 = jSONObject.optString("title", "");
            Intrinsics.checkNotNullExpressionValue(optString5, "json.optString(\"title\", \"\")");
            byte[] bytes = optString5.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            String encodeToString = PluginBaseInfoHelper.Base64Helper.encodeToString(bytes, 0);
            String optString6 = jSONObject.optString("articleUrl", "");
            if (QLog.isColorLevel()) {
                QLog.d("QQUIModule", 2, "KANDIAN Grid Image title: ", encodeToString, ", articleUrl: ", optString6, ", showTitle: ", Boolean.valueOf(optBoolean3));
            }
            if (!optBoolean) {
                if (optBoolean3 && !TextUtils.isEmpty(encodeToString) && !TextUtils.isEmpty(optString6)) {
                    TroopNoticeJsHandler.A(getActivity(), optInt3, arrayList4, null, null, false, optBoolean2, optString4, 100, publicAccountShowPictureReport, optString6, encodeToString, str);
                    return;
                } else {
                    TroopNoticeJsHandler.x(getActivity(), optInt3, arrayList4, null, null, false, optBoolean2, optString4, 100, publicAccountShowPictureReport, str);
                    return;
                }
            }
            if (optJSONArray2 == null) {
                return;
            }
            boolean[] zArr = new boolean[optJSONArray2.length()];
            int length4 = optJSONArray2.length();
            for (int i18 = 0; i18 < length4; i18++) {
                zArr[i18] = optJSONArray2.getBoolean(i18);
            }
            ArrayList arrayList7 = new ArrayList();
            if (optJSONArray3 != null && optJSONArray3.length() != 0) {
                int length5 = optJSONArray3.length();
                for (int i19 = 0; i19 < length5; i19++) {
                    arrayList7.add(optJSONArray3.get(i19).toString());
                }
            }
            if (this.mCallReceiver == null) {
                this.mCallReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.QQUIModule$showPicture$1
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context, Intent intent) {
                        Intrinsics.checkNotNullParameter(context, "context");
                        Intrinsics.checkNotNullParameter(intent, "intent");
                        String stringExtra = intent.getStringExtra("callback");
                        QLog.d("TroopReceiver", 4, stringExtra);
                        Function1<Object, Unit> function1 = callback;
                        if (function1 != null) {
                            function1.invoke(stringExtra);
                        }
                    }
                };
                IntentFilter intentFilter = new IntentFilter("android.intent.action.WEBJSCALL");
                Activity activity = getActivity();
                if (activity != null) {
                    activity.registerReceiver(this.mCallReceiver, intentFilter);
                }
            }
            if (optBoolean3 && !TextUtils.isEmpty(encodeToString) && !TextUtils.isEmpty(optString6)) {
                TroopNoticeJsHandler.A(getActivity(), optInt3, arrayList4, zArr, arrayList7, optBoolean, optBoolean2, optString4, 100, publicAccountShowPictureReport, optString6, encodeToString, str);
            } else {
                TroopNoticeJsHandler.y(getActivity(), optInt3, arrayList4, zArr, arrayList7, optBoolean, optBoolean2, optString4, 100, publicAccountShowPictureReport, arrayList, arrayList2, str, true);
            }
        } catch (JSONException e16) {
            QLog.e("QQUIModule", 1, e16, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(String jsonString, Function1<? super Intent, Unit> block) {
        String str;
        try {
            JSONObject jSONObject = new JSONObject(jsonString);
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            String optString = jSONObject.optString(QQCustomArkDialogUtil.BIZ_SRC, "");
            String optString2 = jSONObject.optString("app", "");
            String optString3 = jSONObject.optString("view", "");
            String optString4 = jSONObject.optString("ver", Constants.DEFAULT_MIN_APP_VERSION);
            String optString5 = jSONObject.optString("prompt", "");
            bundle.putString(QQCustomArkDialogUtil.BIZ_SRC, optString);
            bundle.putString("forward_ark_biz_src", optString);
            bundle.putString("appName", optString2);
            bundle.putString("forward_ark_app_name", optString2);
            bundle.putString(QQCustomArkDialogUtil.APP_VIEW, optString3);
            bundle.putString("forward_ark_app_view", optString3);
            bundle.putString(QQCustomArkDialogUtil.APP_MIN_VERSION, optString4);
            bundle.putString("forward_ark_app_ver", optString4);
            bundle.putString("forward_ark_app_prompt", optString5);
            bundle.putString("prompt", optString5);
            if (jSONObject.has(PublicAccountMessageUtilImpl.META_NAME)) {
                String jSONObject2 = jSONObject.getJSONObject(PublicAccountMessageUtilImpl.META_NAME).toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "metaObj.toString()");
                bundle.putString(QQCustomArkDialogUtil.META_DATA, jSONObject2);
                bundle.putString("forward_ark_app_meta", jSONObject2);
                if (jSONObject.has(DownloadInfo.spKey_Config)) {
                    JSONObject optJSONObject = jSONObject.optJSONObject(DownloadInfo.spKey_Config);
                    if (optJSONObject == null || (str = optJSONObject.toString()) == null) {
                        str = "";
                    }
                    bundle.putString(DownloadInfo.spKey_Config, str);
                    bundle.putString(AppConstants.Key.FORWARD_ARK_APP_CONFIG, str);
                }
                if (jSONObject.has("desc")) {
                    String optString6 = jSONObject.optString("desc", "");
                    bundle.putString("desc", optString6);
                    bundle.putString(AppConstants.Key.FORWARD_ARK_APP_DESC, optString6);
                }
                bundle.putInt(ForwardRecentActivity.SELECTION_MODE, 2);
                bundle.putInt("forward_type", 27);
                bundle.putBoolean("is_ark_display_share", true);
                bundle.putDouble("scale", 2.7d);
                bundle.putString("troop_uin", null);
                intent.putExtras(bundle);
                block.invoke(intent);
                return;
            }
            QLog.e("QQUIModule", 1, "JSON\u4e2d\u7f3a\u5c11meta\u90e8\u5206");
            block.invoke(null);
        } catch (Exception e16) {
            QLog.e("QQUIModule", 1, "\u521b\u5efaIntent\u65f6\u51fa\u9519: " + e16.getMessage());
            block.invoke(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(Function1<Object, Unit> function1, String str, String str2) {
        if (function1 != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("success", true);
            jSONObject.put("type", str);
            if (str2 != null) {
                jSONObject.put("selected", str2);
            }
            function1.invoke(jSONObject.toString());
        }
    }

    private final void G(String params, Function1<Object, Unit> callback) {
        if (params == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(params);
            long j3 = jSONObject.getLong("appId");
            int i3 = jSONObject.getInt("appType");
            Intent intent = new Intent();
            intent.putExtra("key_notify_app_id", j3);
            intent.putExtra("key_notify_app_type", i3);
            QPublicFragmentActivity.start(getActivity(), intent, NotifyServiceBisConfigFragment.class);
        } catch (Throwable th5) {
            QLog.e("QQUIModule", 1, th5, new Object[0]);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void L(String params, final Function1<Object, Unit> callback) {
        if (params == null || params.length() == 0) {
            QLog.e("QQUIModule", 1, "openAlertDialog nothing");
            return;
        }
        try {
            final JSONObject jSONObject = new JSONObject(params);
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            Activity activity = getActivity();
            T t16 = activity;
            if (activity == null) {
                t16 = Foreground.getTopActivity();
            }
            objectRef.element = t16;
            if (t16 == 0) {
                QLog.e("QQUIModule", 1, "openAlertDialog no activity");
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.ad
                    @Override // java.lang.Runnable
                    public final void run() {
                        QQUIModule.M(JSONObject.this, objectRef, this, callback);
                    }
                });
            }
        } catch (Exception e16) {
            QLog.e("QQUIModule", 1, "json error", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(Function1 function1, DialogInterface dialogInterface, int i3) {
        Map mapOf;
        if (function1 != null) {
            Intrinsics.checkNotNull(dialogInterface, "null cannot be cast to non-null type com.tencent.mobileqq.utils.QQCustomDialog");
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("isRightButtonClick", Boolean.TRUE), TuplesKt.to("checked", Boolean.valueOf(((QQCustomDialog) dialogInterface).getCheckBoxState())));
            function1.invoke(mapOf);
        }
        dialogInterface.dismiss();
    }

    @Override // com.tencent.mobileqq.activity.activateFriend.ae.b
    public void queryHasSetNotify(Bundle bundle, Bundle requestBundle) {
        if (bundle == null) {
            return;
        }
        int i3 = bundle.getInt("retcode", -1);
        String string = bundle.getString("retmsg", "");
        int i16 = bundle.getInt(QWalletMixJsPlugin.PARAMS_HAS_SUBSCRIBE, -1);
        if (this.qqNotifyCallback != null) {
            JSONObject jSONObject = new JSONObject();
            if (i3 == 0) {
                jSONObject.put(QWalletMixJsPlugin.PARAMS_HAS_SUBSCRIBE, i16);
            }
            pf2.p.INSTANCE.a(this.qqNotifyCallback, i3, string, jSONObject.toString());
            this.qqNotifyCallback = null;
        }
    }

    private final void Q(String params) {
        if (params == null || params.length() == 0) {
            QLog.e("QQUIModule", 1, "openTransparentWebView nothing");
            return;
        }
        Activity activity = getActivity();
        if (activity == null) {
            activity = Foreground.getTopActivity();
        }
        if (activity == null) {
            QLog.e("QQUIModule", 1, "openTransparentWebView no activity");
        } else {
            ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openTranslucentBrowser(activity, params, 0, null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b9, code lost:
    
        if ((r7 == null || r7.length() == 0) == false) goto L48;
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00cc A[Catch: Exception -> 0x00c7, TryCatch #0 {Exception -> 0x00c7, blocks: (B:59:0x00c0, B:47:0x00cc, B:49:0x00f9, B:54:0x00d1, B:56:0x00d7, B:57:0x00dc), top: B:58:0x00c0 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f9 A[Catch: Exception -> 0x00c7, TRY_LEAVE, TryCatch #0 {Exception -> 0x00c7, blocks: (B:59:0x00c0, B:47:0x00cc, B:49:0x00f9, B:54:0x00d1, B:56:0x00d7, B:57:0x00dc), top: B:58:0x00c0 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00d1 A[Catch: Exception -> 0x00c7, TryCatch #0 {Exception -> 0x00c7, blocks: (B:59:0x00c0, B:47:0x00cc, B:49:0x00f9, B:54:0x00d1, B:56:0x00d7, B:57:0x00dc), top: B:58:0x00c0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void x(String params, Function1<Object, Unit> callback) {
        boolean z16 = false;
        if (params == null || params.length() == 0) {
            y(callback, "params is empty");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(params);
            String sceneId = jSONObject.optString("scene_id");
            Intrinsics.checkNotNullExpressionValue(sceneId, "sceneId");
            if (sceneId.length() == 0) {
                y(callback, "scene_id is required");
                return;
            }
            boolean optBoolean = jSONObject.optBoolean("hideRecentContact", false);
            String title = jSONObject.optString("title");
            int optInt = jSONObject.optInt(HippyHeaderListViewController.VIEW_TAG, -1);
            String optString = jSONObject.optString("localImagePath");
            final String optString2 = jSONObject.optString("arkStr");
            Activity activity = getActivity();
            Bitmap bitmap = null;
            FragmentActivity fragmentActivity = activity instanceof FragmentActivity ? (FragmentActivity) activity : null;
            if (fragmentActivity == null) {
                y(callback, "activity must be FragmentActivity");
                return;
            }
            com.tencent.mobileqq.sharepanel.f createSharePanel = ((ISharePanelApi) QRoute.api(ISharePanelApi.class)).createSharePanel(fragmentActivity, sceneId);
            if (optBoolean) {
                createSharePanel.s0();
            } else {
                createSharePanel.k0(new com.tencent.mobileqq.sharepanel.n() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.QQUIModule$doShowNewSharePanel$1
                    @Override // com.tencent.mobileqq.sharepanel.n
                    public void a(ArrayList<ResultRecord> targetList, final com.tencent.mobileqq.sharepanel.m callback2) {
                        Intrinsics.checkNotNullParameter(targetList, "targetList");
                        Intrinsics.checkNotNullParameter(callback2, "callback");
                        QQUIModule qQUIModule = QQUIModule.this;
                        String arkString = optString2;
                        Intrinsics.checkNotNullExpressionValue(arkString, "arkString");
                        qQUIModule.w(arkString, new Function1<Intent, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.QQUIModule$doShowNewSharePanel$1$prepareForwardData$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Intent intent) {
                                invoke2(intent);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Intent intent) {
                                if (intent != null) {
                                    com.tencent.mobileqq.sharepanel.m.this.a(intent);
                                } else {
                                    com.tencent.mobileqq.sharepanel.m.this.onFail();
                                }
                            }
                        });
                    }
                });
            }
            if (!(title == null || title.length() == 0)) {
                Intrinsics.checkNotNullExpressionValue(title, "title");
                createSharePanel.setTitle(title);
            }
            createSharePanel.t0(new d(callback));
            if (optInt <= 0) {
            }
            if (optString != null) {
                try {
                    if (optString.length() == 0) {
                    }
                    if (z16) {
                        bitmap = BitmapFactory.decodeFile(optString);
                    } else {
                        View viewWithTag = viewWithTag(optInt);
                        if (viewWithTag != null) {
                            bitmap = ViewExtKt.d(viewWithTag);
                        } else {
                            QLog.e("QQUIModule", 1, "showNewSharePanel: view with tag " + optInt + " not found");
                        }
                    }
                    if (bitmap != null) {
                        createSharePanel.q0(bitmap);
                    }
                } catch (Exception e16) {
                    QLog.e("QQUIModule", 1, "showNewSharePanel: error creating bitmap", e16);
                }
                createSharePanel.e0(new e(callback));
                createSharePanel.n0(new f(callback));
                createSharePanel.show();
            }
            z16 = true;
            if (z16) {
            }
            if (bitmap != null) {
            }
            createSharePanel.e0(new e(callback));
            createSharePanel.n0(new f(callback));
            createSharePanel.show();
        } catch (Exception e17) {
            y(callback, "json parse error: " + e17);
        }
    }

    static /* synthetic */ void A(Function1 function1, String str, String str2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str2 = null;
        }
        z(function1, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void M(JSONObject data, Ref.ObjectRef ctx, QQUIModule this$0, final Function1 function1) {
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(ctx, "$ctx");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String leftButtonText = data.optString("leftButtonText");
        Context context = (Context) ctx.element;
        String it = data.optString("titleText");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (it.length() == 0) {
            it = null;
        }
        String it5 = data.optString("contentText");
        Intrinsics.checkNotNullExpressionValue(it5, "it");
        if (it5.length() == 0) {
            it5 = null;
        }
        String str = leftButtonText.length() == 0 ? null : leftButtonText;
        String it6 = data.optString("rightButtonText");
        Intrinsics.checkNotNullExpressionValue(it6, "it");
        if (it6.length() == 0) {
            it6 = null;
        }
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.aj
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                QQUIModule.N(Function1.this, dialogInterface, i3);
            }
        };
        Intrinsics.checkNotNullExpressionValue(leftButtonText, "leftButtonText");
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 230, it, it5, str, it6, onClickListener, leftButtonText.length() == 0 ? null : new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.ak
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                QQUIModule.O(Function1.this, dialogInterface, i3);
            }
        });
        Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(\n    \u2026          }\n            )");
        String optString = data.optString("checkText");
        Intrinsics.checkNotNullExpressionValue(optString, "this");
        if (optString.length() > 0) {
            createCustomDialog.setCheckBox(optString, data.optBoolean("checked", false), null);
        }
        createCustomDialog.setCanceledOnTouchOutside(false);
        this$0.g0(data, createCustomDialog);
        createCustomDialog.show();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/QQUIModule$g", "Lcom/tencent/mtt/hippy/modules/Promise;", "", "p0", "", "resolve", "reject", "", "isCallback", "", "getCallId", "Lcom/tencent/mtt/hippy/HippyEngine$BridgeTransferType;", "setTransferType", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class g implements Promise {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f262939a;

        g(Function1<Object, Unit> function1) {
            this.f262939a = function1;
        }

        @Override // com.tencent.mtt.hippy.modules.Promise
        public String getCallId() {
            return "";
        }

        @Override // com.tencent.mtt.hippy.modules.Promise
        public boolean isCallback() {
            return true;
        }

        @Override // com.tencent.mtt.hippy.modules.Promise
        public void resolve(Object p06) {
            Function1<Object, Unit> function1 = this.f262939a;
            if (function1 != null) {
                function1.invoke(p06);
            }
        }

        @Override // com.tencent.mtt.hippy.modules.Promise
        public void reject(Object p06) {
        }

        @Override // com.tencent.mtt.hippy.modules.Promise
        public void setTransferType(HippyEngine.BridgeTransferType p06) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/QQUIModule$i", "Lcom/tencent/mtt/hippy/modules/Promise;", "", "p0", "", "resolve", "reject", "", "isCallback", "", "getCallId", "Lcom/tencent/mtt/hippy/HippyEngine$BridgeTransferType;", "setTransferType", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class i implements Promise {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f262941a;

        i(Function1<Object, Unit> function1) {
            this.f262941a = function1;
        }

        @Override // com.tencent.mtt.hippy.modules.Promise
        public String getCallId() {
            return "";
        }

        @Override // com.tencent.mtt.hippy.modules.Promise
        public boolean isCallback() {
            return true;
        }

        @Override // com.tencent.mtt.hippy.modules.Promise
        public void resolve(Object p06) {
            Function1<Object, Unit> function1 = this.f262941a;
            if (function1 != null) {
                function1.invoke(p06);
            }
        }

        @Override // com.tencent.mtt.hippy.modules.Promise
        public void reject(Object p06) {
        }

        @Override // com.tencent.mtt.hippy.modules.Promise
        public void setTransferType(HippyEngine.BridgeTransferType p06) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/QQUIModule$j", "Lcom/tencent/mtt/hippy/modules/Promise;", "", "p0", "", "resolve", "reject", "", "isCallback", "", "getCallId", "Lcom/tencent/mtt/hippy/HippyEngine$BridgeTransferType;", "setTransferType", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class j implements Promise {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f262942a;

        j(Function1<Object, Unit> function1) {
            this.f262942a = function1;
        }

        @Override // com.tencent.mtt.hippy.modules.Promise
        public String getCallId() {
            return "";
        }

        @Override // com.tencent.mtt.hippy.modules.Promise
        public boolean isCallback() {
            return true;
        }

        @Override // com.tencent.mtt.hippy.modules.Promise
        public void resolve(Object p06) {
            Function1<Object, Unit> function1 = this.f262942a;
            if (function1 != null) {
                function1.invoke(p06);
            }
        }

        @Override // com.tencent.mtt.hippy.modules.Promise
        public void reject(Object p06) {
        }

        @Override // com.tencent.mtt.hippy.modules.Promise
        public void setTransferType(HippyEngine.BridgeTransferType p06) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/QQUIModule$k", "Lcom/tencent/mtt/hippy/modules/Promise;", "", "p0", "", "resolve", "reject", "", "isCallback", "", "getCallId", "Lcom/tencent/mtt/hippy/HippyEngine$BridgeTransferType;", "setTransferType", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class k implements Promise {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f262943a;

        k(Function1<Object, Unit> function1) {
            this.f262943a = function1;
        }

        @Override // com.tencent.mtt.hippy.modules.Promise
        public String getCallId() {
            return "shareArkMessage";
        }

        @Override // com.tencent.mtt.hippy.modules.Promise
        public boolean isCallback() {
            return true;
        }

        @Override // com.tencent.mtt.hippy.modules.Promise
        public void reject(Object p06) {
            QLog.d("QQUIModule", 2, "[shareArkMessage] reject: " + p06);
        }

        @Override // com.tencent.mtt.hippy.modules.Promise
        public void resolve(Object p06) {
            QLog.d("QQUIModule", 2, "[shareArkMessage] resolve: " + p06);
            Function1<Object, Unit> function1 = this.f262943a;
            if (function1 != null) {
                function1.invoke(p06);
            }
        }

        @Override // com.tencent.mtt.hippy.modules.Promise
        public void setTransferType(HippyEngine.BridgeTransferType p06) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/QQUIModule$l", "Lcom/tencent/mtt/hippy/modules/Promise;", "", "p0", "", "resolve", "reject", "", "isCallback", "", "getCallId", "Lcom/tencent/mtt/hippy/HippyEngine$BridgeTransferType;", "setTransferType", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class l implements Promise {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f262944a;

        l(Function1<Object, Unit> function1) {
            this.f262944a = function1;
        }

        @Override // com.tencent.mtt.hippy.modules.Promise
        public String getCallId() {
            return "shareMessage";
        }

        @Override // com.tencent.mtt.hippy.modules.Promise
        public boolean isCallback() {
            return true;
        }

        @Override // com.tencent.mtt.hippy.modules.Promise
        public void reject(Object p06) {
            QLog.d("QQUIModule", 2, "[shareMessage] reject: " + p06);
        }

        @Override // com.tencent.mtt.hippy.modules.Promise
        public void resolve(Object p06) {
            QLog.d("QQUIModule", 2, "[shareMessage] resolve: " + p06);
            Function1<Object, Unit> function1 = this.f262944a;
            if (function1 != null) {
                function1.invoke(p06);
            }
        }

        @Override // com.tencent.mtt.hippy.modules.Promise
        public void setTransferType(HippyEngine.BridgeTransferType p06) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/QQUIModule$m", "Lcom/tencent/mtt/hippy/modules/Promise;", "", "p0", "", "resolve", "reject", "", "isCallback", "", "getCallId", "Lcom/tencent/mtt/hippy/HippyEngine$BridgeTransferType;", "setTransferType", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class m implements Promise {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f262945a;

        m(Function1<Object, Unit> function1) {
            this.f262945a = function1;
        }

        @Override // com.tencent.mtt.hippy.modules.Promise
        public String getCallId() {
            return "";
        }

        @Override // com.tencent.mtt.hippy.modules.Promise
        public boolean isCallback() {
            return true;
        }

        @Override // com.tencent.mtt.hippy.modules.Promise
        public void reject(Object p06) {
            QLog.d("QQUIModule", 2, "[showSharePanel] reject: " + p06);
        }

        @Override // com.tencent.mtt.hippy.modules.Promise
        public void resolve(Object p06) {
            QLog.d("QQUIModule", 2, "[showSharePanel] resolve: " + p06);
            Function1<Object, Unit> function1 = this.f262945a;
            if (function1 != null) {
                function1.invoke(p06);
            }
        }

        @Override // com.tencent.mtt.hippy.modules.Promise
        public void setTransferType(HippyEngine.BridgeTransferType p06) {
        }
    }
}

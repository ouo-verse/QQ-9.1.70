package com.tencent.mobileqq.wink.share;

import android.app.Activity;
import android.app.Application;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.type.DataTableNameType;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ark.Constants;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.config.impl.QCircleDynamicNameApiImpl;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqcamera.api.ICameraUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.aiavatar.base.WinkAIAvatarUtils;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.request.QQWinkPushArkMessageRequest;
import com.tencent.mobileqq.wink.request.QQWinkShareAIAvatarArkRequest;
import com.tencent.mobileqq.wink.request.QQWinkShareArkRequest;
import com.tencent.mobileqq.wink.share.WinkShareUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.api.IWXShareHelper;
import com.tencent.mobileqq.wxapi.data.WXShareRsp;
import com.tencent.mobileqq.wxapi.listener.IWXShareHelperListener;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.QQCustomArkDialogUtil;
import com.tencent.util.UiThreadUtil;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.QZoneShareManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import org.light.LightVersionInfo;
import qshadow.ShadowShareArkMessage$DisplayInfo;
import qshadow.ShadowShareArkMessage$JumpInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00182\u00020\u0001:\u0001=B\u0007\u00a2\u0006\u0004\bJ\u0010KJ0\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J.\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0002Jh\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0002H\u0002J&\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u001c\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0004\u0012\u00020\u001b0\u0019H\u0002J2\u0010$\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\t2\b\b\u0002\u0010\"\u001a\u00020\u00072\b\b\u0002\u0010#\u001a\u00020\u0012Jv\u0010%\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020\u00072\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002J^\u0010'\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010&\u001a\u00020\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002Jf\u0010(\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010&\u001a\u00020\u0002JB\u0010+\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u00022\u0016\b\u0002\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00192\b\b\u0002\u0010\"\u001a\u00020\u00072\b\b\u0002\u0010#\u001a\u00020\u0012JB\u0010,\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007J \u0010-\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020\u0007J:\u0010.\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\"\u001a\u00020\u0007J(\u00101\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020\u00072\u0006\u00100\u001a\u00020/J8\u00103\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u00102\u001a\u00020\u0012J \u00104\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\u00022\b\b\u0002\u00102\u001a\u00020\u0012J\u0016\u00107\u001a\u00020\u001b2\u0006\u00106\u001a\u0002052\u0006\u0010\u0003\u001a\u00020\u0002Jd\u00108\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002J\u0006\u00109\u001a\u00020\u0002RA\u0010C\u001a!\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(<\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u0018\u0010F\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010I\u001a\u00020G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u0010H\u00a8\u0006L"}, d2 = {"Lcom/tencent/mobileqq/wink/share/WinkShareUtils;", "", "", "url", "title", "desc", "iconUrl", "", "serviceId", "Landroid/content/Intent;", "k", QQCustomArkDialogUtil.META_DATA, "uinType", "uin", tl.h.F, "groupId", "sdkVersion", "id", "", "isNewArkRequest", "busId", "jumpUrlForGuild", "i", "mateData", "d", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "", "onGetBitmap", "g", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "toSpecificFriend", "intent", "requestCode", "isNewSharePanel", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "E", "o", "picPath", "callback", HippyTKDListViewAdapter.X, "u", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, BdhLogUtil.LogTag.Tag_Conn, "Landroid/os/Bundle;", "bundle", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "isToCircle", "v", "B", "Landroid/content/Context;", "context", "c", "e", "l", "Lkotlin/ParameterName;", "name", "success", "a", "Lkotlin/jvm/functions/Function1;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lkotlin/jvm/functions/Function1;", DomainData.DOMAIN_NAME, "(Lkotlin/jvm/functions/Function1;)V", "wxChatShareCallback", "b", "Ljava/lang/String;", "mWXTransaction", "Lcom/tencent/mobileqq/wxapi/listener/IWXShareHelperListener;", "Lcom/tencent/mobileqq/wxapi/listener/IWXShareHelperListener;", "mWxShareListener", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkShareUtils {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super Boolean, Unit> wxChatShareCallback;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mWXTransaction;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private IWXShareHelperListener mWxShareListener = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b-\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b5\u00106J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0002H\u0007J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0002H\u0007J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0002H\u0007J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0002H\u0007J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0007J*\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007J*\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007J\u000e\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006R\u0014\u0010\u0017\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0018R\u0014\u0010\u001e\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0018R\u0014\u0010\u001f\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0018R\u0014\u0010 \u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b \u0010\u0018R\u0014\u0010!\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b!\u0010\u0018R\u0014\u0010\"\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0018R\u0014\u0010#\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b#\u0010\u0018R\u0014\u0010$\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b$\u0010\u0018R\u0014\u0010%\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b%\u0010\u0018R\u0014\u0010&\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b&\u0010\u0018R\u0014\u0010'\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b'\u0010\u0018R\u0014\u0010(\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b(\u0010\u0018R\u0014\u0010)\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b)\u0010\u0018R\u0014\u0010*\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b*\u0010\u0018R\u0014\u0010+\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b+\u0010\u0018R\u0014\u0010,\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b,\u0010\u0018R\u0014\u0010-\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b-\u0010\u0018R\u0014\u0010.\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b.\u0010\u0018R\u0014\u0010/\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b/\u0010\u0018R\u0014\u00100\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b0\u0010\u0018R\u0014\u00101\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b1\u0010\u0018R\u0014\u00102\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b2\u0010\u0018R\u0014\u00103\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b3\u0010\u0018R\u0014\u00104\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b4\u0010\u0018\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/wink/share/WinkShareUtils$a;", "", "", "type", "", IProfileProtocolConst.PARAM_TARGET_UIN, "", "mateData", "Li83/g;", "listener", "", "l", "materialServiceId", "g", "e", "f", "d", "c", "uin", "i", "j", "serviceId", tl.h.F, "KEY_BUS_ID", "Ljava/lang/String;", "KEY_DESC", "KEY_IS_SHARE_NEW_ARK_REQEST", "KEY_JUMP_URL", "KEY_JUMP_URL_FOR_GUILD", "KEY_PREVIEW", "KEY_TAG", "KEY_TAG_GROUP_ID", "KEY_TAG_ICON", "KEY_TAG_MATERIAL_ID", "KEY_TAG_SDK_VER", "KEY_TAG_SERVICE_ID", "KEY_TITLE", "KEY_TO_UIN", "KEY_UIN_TYPE", "STRUCTURL", "TAG", "VALUE_ARK_AI_AVATAR_BIZ_SRC", "VALUE_ARK_NAME", "VALUE_ARK_PROMPT", "VALUE_ARK_PROMPT_AVATAR", "VALUE_ARK_PROMPT_QZONE", "VALUE_ARK_TAG", "VALUE_ARK_TAG_ICON", "VALUE_ARK_TAG_ICON_NEW", "VALUE_ARK_TAG_ICON_QZONE", "VALUE_ARK_TAG_QZONE", "VALUE_ARK_VER", "VALUE_ARK_VIEW", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.share.WinkShareUtils$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void k(i83.g gVar, BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
            w53.b.f("WinkShareUtils", "requestCommonShareArk onReceive: dispatch Success:" + z16 + " | TraceId:" + baseRequest.getTraceId() + " | SeqId:" + baseRequest.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str);
            if (z16) {
                if (gVar != null) {
                    gVar.onSuccess();
                }
            } else if (gVar != null) {
                gVar.onFailed();
            }
        }

        private final void l(int type, long targetUin, String mateData, final i83.g listener) {
            try {
                JSONObject jSONObject = new JSONObject(mateData);
                if (com.tencent.mobileqq.perf.tool.b.b(jSONObject, "KEY_IS_SHARE_NEW_ARK_REQEST", false)) {
                    j(type, targetUin, mateData, listener);
                    return;
                }
                String groupID = jSONObject.getString("group_id");
                int i3 = jSONObject.getInt("service_id");
                String sdkVersion = jSONObject.getString(HiAnalyticsConstant.BI_KEY_SDK_VER);
                String materialId = jSONObject.getString("material_id");
                VSNetworkHelper vSNetworkHelper = VSNetworkHelper.getInstance();
                Application application = RFWApplication.getApplication();
                Intrinsics.checkNotNullExpressionValue(groupID, "groupID");
                Intrinsics.checkNotNullExpressionValue(sdkVersion, "sdkVersion");
                Intrinsics.checkNotNullExpressionValue(materialId, "materialId");
                vSNetworkHelper.sendRequest(application, new QQWinkShareArkRequest(type, targetUin, groupID, i3, sdkVersion, materialId), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.wink.share.t
                    @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                    public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                        WinkShareUtils.Companion.m(i83.g.this, baseRequest, z16, j3, str, obj);
                    }
                });
            } catch (Exception e16) {
                w53.b.d("WinkShareUtils", "requestArk error", e16);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void m(i83.g gVar, BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
            w53.b.f("WinkShareUtils", "requestQQWinkMagicStudioShareArk requestArk onReceive: dispatch Success:" + z16 + " | TraceId:" + baseRequest.getTraceId() + " | SeqId:" + baseRequest.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str);
            if (z16) {
                if (gVar != null) {
                    gVar.onSuccess();
                }
            } else if (gVar != null) {
                gVar.onFailed();
            }
        }

        @JvmStatic
        public final int c(int materialServiceId) {
            if (QQWinkShareAIAvatarArkRequest.INSTANCE.a(materialServiceId)) {
                return DataTableNameType.TABLE_DATA_COLLECTION;
            }
            return 1060;
        }

        @JvmStatic
        @NotNull
        public final String d(int materialServiceId) {
            return "com.tencent.tuwen.lua";
        }

        @JvmStatic
        @NotNull
        public final String e(int materialServiceId) {
            if (QQWinkShareArkRequest.INSTANCE.a(materialServiceId)) {
                return "QQ\u7a7a\u95f4\u7d20\u6750\u5206\u4eab";
            }
            if (QQWinkShareAIAvatarArkRequest.INSTANCE.a(materialServiceId)) {
                return WinkAIAvatarUtils.f317678a.n(materialServiceId);
            }
            String d16 = com.dataline.util.j.d("\u5c0f\u4e16\u754c\u7d20\u6750\u5206\u4eab");
            Intrinsics.checkNotNullExpressionValue(d16, "{\n                QCircl\u2026ARK_PROMPT)\n            }");
            return d16;
        }

        @JvmStatic
        @NotNull
        public final String f(int materialServiceId) {
            if (QQWinkShareArkRequest.INSTANCE.a(materialServiceId)) {
                return "https://qq-video.cdn-go.cn/ios/latest/defaultmode/9105/qzone_lingganku_ai_share_qzonebrand.png";
            }
            if (QQWinkShareAIAvatarArkRequest.INSTANCE.a(materialServiceId)) {
                return WinkAIAvatarUtils.f317678a.m(materialServiceId);
            }
            if (com.dataline.util.j.b()) {
                return "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/changename/qvideo_ark_icon_face.png";
            }
            return "https://downv6.qq.com/shadow_qqcamera/Android/res/qvideo_share_qqxsj_logo.png";
        }

        @JvmStatic
        @NotNull
        public final String g(int materialServiceId) {
            if (QQWinkShareArkRequest.INSTANCE.a(materialServiceId)) {
                return "QQ\u7a7a\u95f4";
            }
            if (QQWinkShareAIAvatarArkRequest.INSTANCE.a(materialServiceId)) {
                return WinkAIAvatarUtils.f317678a.l(materialServiceId);
            }
            String d16 = com.dataline.util.j.d(QCircleDynamicNameApiImpl.ORIGIN_OLD_NAME);
            Intrinsics.checkNotNullExpressionValue(d16, "{\n                QCircl\u2026UE_ARK_TAG)\n            }");
            return d16;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000a. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0071 A[ORIG_RETURN, RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final int h(@NotNull String serviceId) {
            Intrinsics.checkNotNullParameter(serviceId, "serviceId");
            switch (serviceId.hashCode()) {
                case -1912588871:
                    if (serviceId.equals("qzone_ai_avatar_mainpage")) {
                        return 100;
                    }
                    return 0;
                case -1598572156:
                    if (serviceId.equals("qzoneTemplateLibrary")) {
                        return 7;
                    }
                    break;
                case -1293950386:
                    if (serviceId.equals("qzone_ai_avatar_result")) {
                        return 101;
                    }
                    break;
                case -1201252510:
                    if (serviceId.equals("MqKuaishanEdit")) {
                        return 3;
                    }
                    break;
                case 882620029:
                    if (serviceId.equals(AECameraConstants.CAMERA_FLASH_SHOW_SERVICEID)) {
                        return 1;
                    }
                    break;
                case 917326290:
                    if (serviceId.equals("MqKuaishanTemplate")) {
                        return 2;
                    }
                    break;
                case 1665413288:
                    if (serviceId.equals(QQWinkConstants.BUSINESS_MAIGC_STUDIO)) {
                        return 5;
                    }
                    break;
                case 2101819910:
                    if (serviceId.equals("qzoneMagicStudio")) {
                        return 6;
                    }
                    break;
            }
        }

        @JvmStatic
        public final void i(int type, long uin, @NotNull String mateData, @Nullable i83.g listener) {
            Intrinsics.checkNotNullParameter(mateData, "mateData");
            w53.b.f("WinkShareUtils", "requestArk type = " + type + ", uin = " + uin + ", mateData = " + mateData);
            try {
                if (QQWinkShareAIAvatarArkRequest.INSTANCE.a(new JSONObject(mateData).optInt("service_id"))) {
                    e.INSTANCE.d(type, uin, mateData, listener);
                } else {
                    l(type, uin, mateData, listener);
                }
            } catch (Exception e16) {
                w53.b.d("WinkShareUtils", "requestArk error", e16);
            }
        }

        @JvmStatic
        public final void j(int type, long uin, @NotNull String mateData, @Nullable final i83.g listener) {
            Intrinsics.checkNotNullParameter(mateData, "mateData");
            w53.b.f("WinkShareUtils", "requestCommonShareArk type = " + type + ", uin = " + uin + ", mateData = " + mateData);
            try {
                JSONObject jSONObject = new JSONObject(mateData);
                String g16 = com.tencent.mobileqq.perf.tool.b.g(jSONObject, "bus_id", "");
                VSNetworkHelper vSNetworkHelper = VSNetworkHelper.getInstance();
                Application application = RFWApplication.getApplication();
                int i3 = 1;
                if (type != 1) {
                    i3 = 2;
                }
                byte[] bytes = String.valueOf(uin).getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                String encodeToString = PluginBaseInfoHelper.Base64Helper.encodeToString(bytes, 0);
                Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(uin.toStr\u2026eArray(), Base64.DEFAULT)");
                ShadowShareArkMessage$JumpInfo shadowShareArkMessage$JumpInfo = new ShadowShareArkMessage$JumpInfo();
                shadowShareArkMessage$JumpInfo.jumpType.set(2);
                Unit unit = Unit.INSTANCE;
                ShadowShareArkMessage$DisplayInfo shadowShareArkMessage$DisplayInfo = new ShadowShareArkMessage$DisplayInfo();
                shadowShareArkMessage$DisplayInfo.title.set(com.tencent.mobileqq.perf.tool.b.g(jSONObject, "title", ""));
                shadowShareArkMessage$DisplayInfo.desc.set(com.tencent.mobileqq.perf.tool.b.g(jSONObject, "desc", ""));
                shadowShareArkMessage$DisplayInfo.imageUrl.set(com.tencent.mobileqq.perf.tool.b.g(jSONObject, "preview", ""));
                shadowShareArkMessage$DisplayInfo.iconName.set(com.tencent.mobileqq.perf.tool.b.g(jSONObject, "tag", ""));
                shadowShareArkMessage$DisplayInfo.iconUrl.set(com.tencent.mobileqq.perf.tool.b.g(jSONObject, "tagIcon", ""));
                vSNetworkHelper.sendRequest(application, new QQWinkPushArkMessageRequest(g16, i3, encodeToString, shadowShareArkMessage$JumpInfo, shadowShareArkMessage$DisplayInfo), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.wink.share.u
                    @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                    public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                        WinkShareUtils.Companion.k(i83.g.this, baseRequest, z16, j3, str, obj);
                    }
                });
            } catch (Exception e16) {
                w53.b.d("WinkShareUtils", "requestCommonShareArk error", e16);
            }
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/wink/share/WinkShareUtils$c", "Lcom/tencent/mobileqq/wxapi/listener/IWXShareHelperListener;", "Lcom/tencent/mobileqq/wxapi/data/WXShareRsp;", "resp", "", "onWXShareResp", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements IWXShareHelperListener {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(Context it) {
            Intrinsics.checkNotNullParameter(it, "$it");
            QQToast.makeText(it, 2, R.string.hj9, 1).show();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(Context it) {
            Intrinsics.checkNotNullParameter(it, "$it");
            QQToast.makeText(it, 2, R.string.hit, 1).show();
        }

        @Override // com.tencent.mobileqq.wxapi.listener.IWXShareHelperListener
        public void onWXShareResp(@NotNull WXShareRsp resp) {
            final Context applicationContext;
            final Context applicationContext2;
            Intrinsics.checkNotNullParameter(resp, "resp");
            if (WinkShareUtils.this.mWXTransaction != null && Intrinsics.areEqual(WinkShareUtils.this.mWXTransaction, resp.transaction)) {
                if (resp.errCode == ((IWXShareHelper) QRoute.api(IWXShareHelper.class)).ERR_OK()) {
                    BaseApplication context = BaseApplication.getContext();
                    if (context != null && (applicationContext2 = context.getApplicationContext()) != null) {
                        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.wink.share.v
                            @Override // java.lang.Runnable
                            public final void run() {
                                WinkShareUtils.c.c(applicationContext2);
                            }
                        });
                    }
                    Function1<Boolean, Unit> m3 = WinkShareUtils.this.m();
                    if (m3 != null) {
                        m3.invoke(Boolean.TRUE);
                    }
                } else if (resp.errCode != ((IWXShareHelper) QRoute.api(IWXShareHelper.class)).ERR_USER_CANCEL()) {
                    BaseApplication context2 = BaseApplication.getContext();
                    if (context2 != null && (applicationContext = context2.getApplicationContext()) != null) {
                        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.wink.share.w
                            @Override // java.lang.Runnable
                            public final void run() {
                                WinkShareUtils.c.d(applicationContext);
                            }
                        });
                    }
                    Function1<Boolean, Unit> m16 = WinkShareUtils.this.m();
                    if (m16 != null) {
                        m16.invoke(Boolean.FALSE);
                    }
                }
                ((IWXShareHelper) QRoute.api(IWXShareHelper.class)).removeObserver(this);
            }
        }
    }

    public static /* synthetic */ void D(WinkShareUtils winkShareUtils, Activity activity, String str, String str2, String str3, String str4, int i3, int i16, Object obj) {
        if ((i16 & 32) != 0) {
            i3 = -1;
        }
        winkShareUtils.C(activity, str, str2, str3, str4, i3);
    }

    public static /* synthetic */ Intent F(WinkShareUtils winkShareUtils, String str, int i3, String str2, String str3, String str4, String str5, String str6, int i16, String str7, String str8, int i17, Object obj) {
        String str9;
        String str10;
        if ((i17 & 256) != 0) {
            str9 = "";
        } else {
            str9 = str7;
        }
        if ((i17 & 512) != 0) {
            str10 = null;
        } else {
            str10 = str8;
        }
        return winkShareUtils.E(str, i3, str2, str3, str4, str5, str6, i16, str9, str10);
    }

    private final String d(String mateData) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("news", new JSONObject(mateData));
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "{\n            val jsonOb\u2026ject.toString()\n        }");
            return jSONObject2;
        } catch (Exception unused) {
            return "";
        }
    }

    public static /* synthetic */ Intent f(WinkShareUtils winkShareUtils, int i3, String str, String str2, String str3, String str4, String str5, String str6, int i16, String str7, String str8, String str9, int i17, Object obj) {
        String str10;
        if ((i17 & 1024) != 0) {
            str10 = null;
        } else {
            str10 = str9;
        }
        return winkShareUtils.e(i3, str, str2, str3, str4, str5, str6, i16, str7, str8, str10);
    }

    private final boolean g(String url, Function1<? super Bitmap, Unit> onGetBitmap) {
        w53.b.f("WinkShareUtils", "getBitmapFromUrl url: " + url);
        if (TextUtils.isEmpty(url)) {
            onGetBitmap.invoke(null);
            return false;
        }
        try {
            URLDrawable drawable = URLDrawable.getDrawable(url, URLDrawable.URLDrawableOptions.obtain());
            drawable.setURLDrawableListener(new b(onGetBitmap));
            if (drawable.getStatus() == 1) {
                onGetBitmap.invoke(BaseImageUtil.drawabletoBitmapV2(drawable, 100, 100));
            } else {
                drawable.startDownload();
            }
            return true;
        } catch (Throwable th5) {
            onGetBitmap.invoke(null);
            w53.b.c("WinkShareUtils", "getBitmapFromUrl: " + th5);
            return false;
        }
    }

    private final Intent h(String metaData, int serviceId, int uinType, String uin) {
        boolean z16;
        Intent intent = new Intent();
        Companion companion = INSTANCE;
        intent.putExtra("forward_type", companion.c(serviceId));
        intent.putExtra("forward_ark_app_name", companion.d(serviceId));
        intent.putExtra("forward_ark_app_view", "news");
        intent.putExtra("forward_ark_app_prompt", companion.e(serviceId));
        intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_DESC, companion.g(serviceId));
        intent.putExtra("forward_ark_app_ver", Constants.DEFAULT_MIN_APP_VERSION);
        intent.putExtra("forward_ark_app_meta", metaData);
        intent.putExtra("is_ark_display_share", true);
        intent.putExtras(QQCustomArkDialogUtil.zipArgs(companion.d(serviceId), "news", Constants.DEFAULT_MIN_APP_VERSION, d(metaData), MobileQQ.sMobileQQ.getApplicationContext().getResources().getDisplayMetrics().density, null, null));
        intent.putExtra(QQCustomArkDialogUtil.BIZ_SRC, "shadow.share_news");
        intent.putExtra(ShortVideoConstants.FROM_UIN, ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount());
        intent.putExtra("is_need_show_toast", true);
        intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 2);
        if (uin != null && uin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            intent.putExtra(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 1);
            intent.putExtra("uinType", uinType);
            intent.putExtra("toUin", uin);
            intent.putExtra("key_direct_show_uin_type", uinType);
            intent.putExtra("key_direct_show_uin", uin);
        }
        return intent;
    }

    private final String i(String url, String title, String desc, String iconUrl, String groupId, int serviceId, String sdkVersion, String id5, boolean isNewArkRequest, String busId, String jumpUrlForGuild) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("bus_id", busId);
            jSONObject.put("title", title);
            jSONObject.put("desc", desc);
            jSONObject.put(WadlProxyConsts.KEY_JUMP_URL, url);
            jSONObject.put("preview", iconUrl);
            Companion companion = INSTANCE;
            jSONObject.put("tag", companion.g(serviceId));
            jSONObject.put("tagIcon", companion.f(serviceId));
            jSONObject.put("group_id", groupId);
            jSONObject.put("service_id", serviceId);
            jSONObject.put(HiAnalyticsConstant.BI_KEY_SDK_VER, sdkVersion);
            jSONObject.put("material_id", id5);
            if (jumpUrlForGuild != null) {
                jSONObject.put("jumpUrlForGuild", jumpUrlForGuild);
            }
            jSONObject.put("KEY_IS_SHARE_NEW_ARK_REQEST", isNewArkRequest);
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "{\n            val jsonOb\u2026ject.toString()\n        }");
            return jSONObject2;
        } catch (Exception unused) {
            return "";
        }
    }

    static /* synthetic */ String j(WinkShareUtils winkShareUtils, String str, String str2, String str3, String str4, String str5, int i3, String str6, String str7, boolean z16, String str8, String str9, int i16, Object obj) {
        boolean z17;
        String str10;
        String str11;
        if ((i16 & 256) != 0) {
            z17 = false;
        } else {
            z17 = z16;
        }
        if ((i16 & 512) != 0) {
            str10 = "";
        } else {
            str10 = str8;
        }
        if ((i16 & 1024) != 0) {
            str11 = null;
        } else {
            str11 = str9;
        }
        return winkShareUtils.i(str, str2, str3, str4, str5, i3, str6, str7, z17, str10, str11);
    }

    private final Intent k(String url, String title, String desc, String iconUrl, int serviceId) {
        Intent intent = new Intent();
        intent.putExtra("key_flag_from_plugin", true);
        intent.putExtra("isFromShare", true);
        intent.putExtra("forward_type", 1001);
        intent.putExtra("pluginName", "web_share");
        intent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 146);
        intent.putExtra("detail_url", url);
        intent.putExtra("req_share_id", 0);
        intent.putExtra("forward _key_nojump", true);
        intent.putExtra("title", title);
        intent.putExtra("desc", desc);
        intent.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ACTION, "app");
        intent.putExtra(AppConstants.Key.SHARE_BRIEF, "[\u5206\u4eab] " + title);
        intent.putExtra(AppConstants.Key.FORWARD_THUMB, iconUrl);
        intent.putExtra(AppConstants.Key.SHARE_REQ_IMAGE_REMOTE_URL, iconUrl);
        intent.putExtra(QZoneShareManager.QZONE_SHARE_FROM_WEB, true);
        intent.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_CONTENT_ACTION, "web");
        intent.putExtra("isWebCompShare", true);
        intent.putExtra("struct_url", url);
        intent.putExtra(ShortVideoConstants.FROM_UIN, ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount());
        intent.putExtra("caller_name", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        intent.putExtra("forward_source_business_type", -1);
        intent.putExtra("forward_source_sub_business_type", "");
        intent.putExtra("key_allow_multiple_forward_from_limit", false);
        intent.putExtra("is_need_show_toast", true);
        intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 2);
        Companion companion = INSTANCE;
        intent.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_NAME, companion.g(serviceId));
        intent.putExtra("app_name", companion.g(serviceId));
        intent.putExtra(AppConstants.Key.STRUCT_MSG_BYTES, ((ICameraUtils) QRoute.api(ICameraUtils.class)).getStructMsgBytes(intent.getExtras()));
        return intent;
    }

    public static /* synthetic */ void p(WinkShareUtils winkShareUtils, Activity activity, String str, int i3, String str2, String str3, String str4, String str5, String str6, int i16, int i17, String str7, int i18, Object obj) {
        int i19;
        int i26;
        String str8;
        if ((i18 & 256) != 0) {
            i19 = 0;
        } else {
            i19 = i16;
        }
        if ((i18 & 512) != 0) {
            i26 = 9;
        } else {
            i26 = i17;
        }
        if ((i18 & 1024) != 0) {
            str8 = "";
        } else {
            str8 = str7;
        }
        winkShareUtils.o(activity, str, i3, str2, str3, str4, str5, str6, i19, i26, str8);
    }

    public static /* synthetic */ void s(WinkShareUtils winkShareUtils, Activity activity, int i3, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i16, String str10, int i17, Object obj) {
        int i18;
        String str11;
        if ((i17 & 2048) != 0) {
            i18 = 0;
        } else {
            i18 = i16;
        }
        if ((i17 & 4096) != 0) {
            str11 = null;
        } else {
            str11 = str10;
        }
        winkShareUtils.q(activity, i3, str, str2, str3, str4, str5, str6, str7, str8, str9, i18, str11);
    }

    public static /* synthetic */ void t(WinkShareUtils winkShareUtils, Activity activity, boolean z16, Intent intent, int i3, boolean z17, int i16, Object obj) {
        int i17;
        boolean z18;
        if ((i16 & 8) != 0) {
            i17 = 0;
        } else {
            i17 = i3;
        }
        if ((i16 & 16) != 0) {
            z18 = false;
        } else {
            z18 = z17;
        }
        winkShareUtils.r(activity, z16, intent, i17, z18);
    }

    public static /* synthetic */ boolean w(WinkShareUtils winkShareUtils, Activity activity, String str, String str2, String str3, String str4, boolean z16, int i3, Object obj) {
        if ((i3 & 32) != 0) {
            z16 = false;
        }
        return winkShareUtils.v(activity, str, str2, str3, str4, z16);
    }

    public static /* synthetic */ void y(WinkShareUtils winkShareUtils, Activity activity, String str, Function1 function1, int i3, boolean z16, int i16, Object obj) {
        int i17;
        boolean z17;
        if ((i16 & 4) != 0) {
            function1 = null;
        }
        Function1 function12 = function1;
        if ((i16 & 8) != 0) {
            i17 = 0;
        } else {
            i17 = i3;
        }
        if ((i16 & 16) != 0) {
            z17 = false;
        } else {
            z17 = z16;
        }
        winkShareUtils.x(activity, str, function12, i17, z17);
    }

    public final void A(@NotNull Activity activity, @NotNull String picPath, int requestCode, @NotNull Bundle bundle) {
        ArrayList<String> arrayListOf;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(picPath, "picPath");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(picPath);
        bundle.putStringArrayList("images", arrayListOf);
        QZoneShareManager.publishToQzone(com.tencent.mobileqq.wink.b.e(), activity, bundle, null, requestCode);
    }

    public final boolean B(@NotNull Activity activity, @NotNull final String picPath, final boolean isToCircle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(picPath, "picPath");
        if (!NetworkUtil.isNetworkAvailable(activity)) {
            QQToast.makeText(activity, 1, R.string.f171139ci4, 1).show();
            return false;
        }
        if (!WXShareHelper.b0().e0()) {
            QQToast.makeText(activity, 1, R.string.f173257ih1, 1).show();
            return false;
        }
        this.mWXTransaction = String.valueOf(System.currentTimeMillis());
        g(picPath, new Function1<Bitmap, Unit>() { // from class: com.tencent.mobileqq.wink.share.WinkShareUtils$sharePicToWeixin$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap) {
                invoke2(bitmap);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Bitmap bitmap) {
                IWXShareHelperListener iWXShareHelperListener;
                IWXShareHelper iWXShareHelper = (IWXShareHelper) QRoute.api(IWXShareHelper.class);
                iWXShareHelperListener = WinkShareUtils.this.mWxShareListener;
                iWXShareHelper.addObserver(iWXShareHelperListener);
                if (isToCircle) {
                    WXShareHelper.b0().x0(picPath, bitmap, 1, false, WinkShareUtils.this.mWXTransaction);
                } else {
                    WXShareHelper.b0().x0(picPath, bitmap, 0, false, WinkShareUtils.this.mWXTransaction);
                }
            }
        });
        return true;
    }

    public final void C(@NotNull Activity activity, @NotNull String url, @NotNull String title, @NotNull String desc, @Nullable String iconUrl, int requestCode) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(desc, "desc");
        QZoneShareData qZoneShareData = new QZoneShareData();
        qZoneShareData.mTitle = title;
        qZoneShareData.mSummary = desc;
        qZoneShareData.targetUrl = url;
        qZoneShareData.mShareBeginTime = SystemClock.currentThreadTimeMillis();
        if (!TextUtils.isEmpty(iconUrl)) {
            ArrayList<String> arrayList = new ArrayList<>();
            qZoneShareData.mImageUrls = arrayList;
            arrayList.add(iconUrl);
        }
        qZoneShareData.from = 2;
        qZoneShareData.mWebUrl = url;
        QZoneShareManager.shareToQzone(activity, ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount(), qZoneShareData, null, requestCode);
    }

    @NotNull
    public final Intent E(@NotNull String busId, int uinType, @Nullable String uin, @NotNull String url, @NotNull String title, @NotNull String desc, @NotNull String iconUrl, int serviceId, @NotNull String materialId, @Nullable String jumpUrlForGuild) {
        Intrinsics.checkNotNullParameter(busId, "busId");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(materialId, "materialId");
        return h(i(url, title, desc, iconUrl, "", serviceId, "", materialId, true, busId, jumpUrlForGuild), serviceId, uinType, uin);
    }

    public final void c(@NotNull Context context, @NotNull String url) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Object systemService = context.getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ClipboardMonitor.setText((ClipboardManager) systemService, url);
        QQToast.makeText(context, 0, context.getString(R.string.aev), 0).show();
    }

    @NotNull
    public final Intent e(int uinType, @Nullable String uin, @NotNull String url, @NotNull String title, @NotNull String desc, @NotNull String iconUrl, @NotNull String groupId, int serviceId, @NotNull String sdkVersion, @NotNull String id5, @Nullable String jumpUrlForGuild) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(sdkVersion, "sdkVersion");
        Intrinsics.checkNotNullParameter(id5, "id");
        return h(j(this, url, title, desc, iconUrl, groupId, serviceId, sdkVersion, id5, false, null, jumpUrlForGuild, 768, null), serviceId, uinType, uin);
    }

    @NotNull
    public final String l() {
        List split$default;
        if (TextUtils.isEmpty(LightVersionInfo.VERSION_NAME)) {
            return LightVersionInfo.VERSION_NAME;
        }
        split$default = StringsKt__StringsKt.split$default((CharSequence) LightVersionInfo.VERSION_NAME, new String[]{"."}, false, 0, 6, (Object) null);
        Object[] array = split$default.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        String[] strArr = (String[]) array;
        if (strArr.length <= 3) {
            return LightVersionInfo.VERSION_NAME;
        }
        return strArr[0] + "." + strArr[1] + "." + strArr[2];
    }

    @Nullable
    public final Function1<Boolean, Unit> m() {
        return this.wxChatShareCallback;
    }

    public final void n(@Nullable Function1<? super Boolean, Unit> function1) {
        this.wxChatShareCallback = function1;
    }

    public final void o(@NotNull Activity activity, @NotNull String busId, int uinType, @Nullable String uin, @NotNull String url, @NotNull String title, @NotNull String desc, @NotNull String iconUrl, int requestCode, int serviceId, @NotNull String materialId) {
        boolean z16;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(busId, "busId");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(materialId, "materialId");
        if (uin != null && uin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        t(this, activity, true ^ z16, F(this, busId, uinType, uin, url, title, desc, iconUrl, serviceId, materialId, null, 512, null), requestCode, false, 16, null);
    }

    public final void q(@NotNull Activity activity, int uinType, @Nullable String uin, @NotNull String url, @NotNull String title, @NotNull String desc, @NotNull String iconUrl, @NotNull String groupId, @NotNull String serviceId, @NotNull String sdkVersion, @NotNull String id5, int requestCode, @Nullable String jumpUrlForGuild) {
        boolean z16;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(serviceId, "serviceId");
        Intrinsics.checkNotNullParameter(sdkVersion, "sdkVersion");
        Intrinsics.checkNotNullParameter(id5, "id");
        if (uin != null && uin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        t(this, activity, true ^ z16, e(uinType, uin, url, title, desc, iconUrl, groupId, INSTANCE.h(serviceId), sdkVersion, id5, jumpUrlForGuild), requestCode, false, 16, null);
    }

    public final void r(@NotNull Activity activity, boolean toSpecificFriend, @NotNull Intent intent, int requestCode, boolean isNewSharePanel) {
        String str;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(intent, "intent");
        intent.putExtra(AppConstants.Key.FORWARD_USE_BOTTOM_SHEET_PREVIEW, isNewSharePanel);
        if (toSpecificFriend) {
            str = RouterConstants.UI_ROUTE_FORWARD_RECENT_TRANS;
        } else {
            str = RouterConstants.UI_ROUTE_JUMP_FORWARD_RECENT;
        }
        RouteUtils.startActivityForResult(activity, intent, str, requestCode);
    }

    public final void u(@NotNull Activity activity, @NotNull String url, @NotNull String title, @NotNull String desc, @NotNull String iconUrl, int requestCode, int serviceId) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        Intent k3 = k(url, title, desc, iconUrl, serviceId);
        k3.putExtra("forward_source_business_type", BusinessInfoCheckUpdateItem.UIAPPID_CUKING_CARD);
        k3.putExtra("forward_source_sub_business_type", "biz_src_ads_xsj");
        ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).startQQGuildForwardGuildListFragment(activity, k3, requestCode);
    }

    public final boolean v(@NotNull Activity activity, @NotNull final String url, @NotNull final String title, @NotNull final String desc, @NotNull String iconUrl, final boolean isToCircle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
        if (!NetworkUtil.isNetworkAvailable(activity)) {
            QQToast.makeText(activity, 1, R.string.f171139ci4, 1).show();
            return false;
        }
        if (!WXShareHelper.b0().e0()) {
            QQToast.makeText(activity, 1, R.string.f173257ih1, 1).show();
            return false;
        }
        this.mWXTransaction = String.valueOf(System.currentTimeMillis());
        w53.b.f("WinkShareUtils", "shareH5ToWeixin, url: " + url + ", title: " + title + ", desc: " + desc + ", iconUrl: " + iconUrl);
        g(iconUrl, new Function1<Bitmap, Unit>() { // from class: com.tencent.mobileqq.wink.share.WinkShareUtils$shareH5ToWeixin$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap) {
                invoke2(bitmap);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Bitmap bitmap) {
                IWXShareHelperListener iWXShareHelperListener;
                IWXShareHelper iWXShareHelper = (IWXShareHelper) QRoute.api(IWXShareHelper.class);
                iWXShareHelperListener = WinkShareUtils.this.mWxShareListener;
                iWXShareHelper.addObserver(iWXShareHelperListener);
                if (isToCircle) {
                    WXShareHelper.b0().N0(WinkShareUtils.this.mWXTransaction, title, bitmap, desc, url);
                } else {
                    WXShareHelper.b0().M0(WinkShareUtils.this.mWXTransaction, title, bitmap, desc, url);
                }
            }
        });
        return true;
    }

    public final void x(@NotNull Activity activity, @NotNull String picPath, @Nullable final Function1<? super Boolean, Unit> callback, int requestCode, boolean isNewSharePanel) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(picPath, "picPath");
        final Handler handler = new Handler(Looper.getMainLooper());
        ResultReceiver resultReceiver = new ResultReceiver(handler) { // from class: com.tencent.mobileqq.wink.share.WinkShareUtils$sharePicToQQFriend$resultReceiver$1
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int resultCode, @Nullable Bundle resultData) {
                if (resultCode == -1) {
                    Function1<Boolean, Unit> function1 = callback;
                    if (function1 != null) {
                        function1.invoke(Boolean.TRUE);
                        return;
                    }
                    return;
                }
                Function1<Boolean, Unit> function12 = callback;
                if (function12 != null) {
                    function12.invoke(Boolean.FALSE);
                }
            }
        };
        Intent intent = new Intent();
        intent.putExtra("caller_name", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        intent.putExtra("forward_source_business_type", BusinessInfoCheckUpdateItem.UIAPPID_CUKING_CARD);
        intent.putExtra(AppConstants.Key.KEY_HELP_FORWARD_PIC, true);
        intent.putExtra("forward_type", 1);
        intent.putExtra("PARAM_ActivityResultReceiver", resultReceiver);
        intent.putExtra(AppConstants.Key.FORWARD_USE_BOTTOM_SHEET_PREVIEW, isNewSharePanel);
        intent.setData(Uri.parse(picPath));
        RouteUtils.startActivityForResult(activity, intent, RouterConstants.UI_ROUTE_JUMP_FORWARD_RECENT, requestCode);
    }

    public final void z(@NotNull Activity activity, @NotNull String picPath, int requestCode) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(picPath, "picPath");
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", 1);
        bundle.putBoolean(AppConstants.Key.KEY_HELP_FORWARD_PIC, true);
        bundle.putString(AppConstants.Key.FORWARD_FILEPATH, picPath);
        bundle.putString(AppConstants.Key.FORWARD_THUMB, picPath);
        bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, picPath);
        bundle.putString(AppConstants.Key.FORWARD_EXTRA, picPath);
        Intent intent = new Intent();
        intent.putExtra("is_multi_selection", false);
        intent.putExtra("only_single_selection", true);
        intent.putExtra("call_by_forward", true);
        intent.putExtras(bundle);
        ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).startQQGuildForwardGuildListFragment(activity, intent, requestCode);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/wink/share/WinkShareUtils$b", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "drawable", "", "onLoadSuccessed", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "onLoadFialed", "onLoadCanceled", "", "progress", "onLoadProgressed", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1<Bitmap, Unit> f326345d;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function1<? super Bitmap, Unit> function1) {
            this.f326345d = function1;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(@Nullable URLDrawable drawable) {
            this.f326345d.invoke(null);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(@Nullable URLDrawable drawable, @Nullable Throwable cause) {
            this.f326345d.invoke(null);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(@Nullable URLDrawable drawable) {
            this.f326345d.invoke(BaseImageUtil.drawabletoBitmapV2(drawable, 100, 100));
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(@Nullable URLDrawable drawable, int progress) {
        }
    }
}

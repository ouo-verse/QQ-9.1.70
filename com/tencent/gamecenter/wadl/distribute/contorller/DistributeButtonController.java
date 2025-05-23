package com.tencent.gamecenter.wadl.distribute.contorller;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.gamecenter.wadl.api.IQQGameReportService;
import com.tencent.gamecenter.wadl.api.IQQGameSwitchApi;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.gamecenter.wadl.distribute.data.ButtonDataBuilder;
import com.tencent.gamecenter.wadl.distribute.data.ButtonStatus;
import com.tencent.gamecenter.wadl.distribute.data.DistributeConstants;
import com.tencent.gamecenter.wadl.distribute.listener.IButtonEventListener;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceUtil;
import com.tencent.gamecenter.wadl.util.WadlProxyServiceWrap;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.api.ITempApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.comm.api.IGameCenterUnitedConfigApi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.vivo.push.PushClientConstants;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.qqgame.QQGameGcSpkTaskDye;
import tencent.im.qqgame.QQGameQfsSubscribe;
import tencent.im.qqgame.QQGameSubscribe$SubscribeUpComingGameRsp;
import tencent.im.qqgame.UserGameVersionPB$QueryGameChannelRsp;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00e0\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\b*\u0004\u00be\u0001\u00c2\u0001\u0018\u0000 \u00c8\u00012\u00020\u0001:\u0004\u0096\u0001\u009a\u0001B\u0011\u0012\u0006\u0010m\u001a\u00020l\u00a2\u0006\u0006\b\u00c6\u0001\u0010\u00c7\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\f\u0010\t\u001a\u00020\b*\u00020\u0007H\u0002J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0014\u0010\u000f\u001a\u00020\u0002*\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002J\f\u0010\u0010\u001a\u00020\u0002*\u00020\u0007H\u0002J\f\u0010\u0011\u001a\u00020\u0002*\u00020\u0007H\u0002J\f\u0010\u0012\u001a\u00020\u0002*\u00020\u0007H\u0002J:\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002J\b\u0010\u001b\u001a\u00020\bH\u0002J\b\u0010\u001c\u001a\u00020\u0002H\u0002J\b\u0010\u001d\u001a\u00020\u0002H\u0002J\b\u0010\u001e\u001a\u00020\u0002H\u0002J\b\u0010\u001f\u001a\u00020\u0002H\u0002J \u0010\"\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u0016H\u0002J \u0010#\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u0016H\u0002J\u0018\u0010&\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u0016H\u0002J\b\u0010'\u001a\u00020\u0002H\u0002J\u0010\u0010*\u001a\u00020\b2\u0006\u0010)\u001a\u00020(H\u0002J\u001a\u0010,\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\n2\u0006\u0010+\u001a\u00020\bH\u0002J \u00100\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020\u0016H\u0002J$\u00107\u001a\u00020\u00022\b\u00102\u001a\u0004\u0018\u0001012\u0006\u00104\u001a\u0002032\b\u00106\u001a\u0004\u0018\u000105H\u0002J,\u00109\u001a\u00020\u00022\b\u00108\u001a\u0004\u0018\u00010\n2\u0006\u00106\u001a\u0002052\u0006\u00102\u001a\u0002012\b\u0010\u0015\u001a\u0004\u0018\u00010\nH\u0002J\u001c\u0010:\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\n2\b\u00108\u001a\u0004\u0018\u00010\nH\u0002J2\u0010>\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010;\u001a\u00020\u00162\u0006\u0010<\u001a\u00020\u00162\u0006\u0010=\u001a\u00020\u0016H\u0002J\u0012\u0010@\u001a\u00020\u00022\b\u0010?\u001a\u0004\u0018\u00010\nH\u0002J$\u0010A\u001a\u00020\u00022\b\u00102\u001a\u0004\u0018\u0001012\u0006\u00104\u001a\u0002032\b\u00106\u001a\u0004\u0018\u000105H\u0002J$\u0010B\u001a\u00020\u00022\b\u00102\u001a\u0004\u0018\u0001012\u0006\u00104\u001a\u0002032\b\u00106\u001a\u0004\u0018\u000105H\u0002J\b\u0010C\u001a\u00020\u0002H\u0002J\u0010\u0010D\u001a\u00020\b2\u0006\u0010$\u001a\u00020\nH\u0002J\u0012\u0010G\u001a\u00020\b2\b\u0010F\u001a\u0004\u0018\u00010EH\u0002J\"\u0010I\u001a\u00020\u00022\u0006\u0010H\u001a\u00020\n2\u0006\u0010?\u001a\u00020\n2\b\u0010F\u001a\u0004\u0018\u00010EH\u0002J\b\u0010J\u001a\u00020\nH\u0002J\u0010\u0010K\u001a\u00020\n2\u0006\u0010?\u001a\u00020\nH\u0002J\b\u0010L\u001a\u00020\u0002H\u0002J\b\u0010M\u001a\u00020\u0002H\u0002J\b\u0010N\u001a\u00020\u0002H\u0002J\b\u0010O\u001a\u00020\nH\u0002J\b\u0010P\u001a\u00020\nH\u0002J\b\u0010Q\u001a\u00020\nH\u0002J\b\u0010R\u001a\u00020\nH\u0002J\b\u0010S\u001a\u00020\nH\u0002J\b\u0010T\u001a\u00020\u0016H\u0002J\"\u0010W\u001a\u00020\u00022\b\u0010F\u001a\u0004\u0018\u00010E2\u0006\u0010U\u001a\u00020\u00162\u0006\u0010V\u001a\u00020\nH\u0002J\b\u0010X\u001a\u00020\u0002H\u0002J\b\u0010Y\u001a\u00020\bH\u0002J\f\u0010Z\u001a\u00020\u0002*\u00020\u0007H\u0002J\f\u0010[\u001a\u00020\b*\u00020\u0007H\u0002J@\u0010c\u001a\u00020b2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\\\u001a\u00020\n2\u0006\u0010]\u001a\u00020\n2\u0006\u0010^\u001a\u00020\n2\u0006\u0010_\u001a\u00020\n2\u0006\u0010`\u001a\u00020\n2\u0006\u0010a\u001a\u00020\u0016H\u0002J\b\u0010d\u001a\u00020\u0002H\u0002J\b\u0010f\u001a\u00020eH\u0002J\u001e\u0010j\u001a\u00020\u00022\u0006\u0010g\u001a\u00020\n2\f\u0010i\u001a\b\u0012\u0004\u0012\u00020\u00020hH\u0002J\b\u0010k\u001a\u00020\bH\u0002J;\u0010s\u001a\u00020\u00022\u0006\u0010m\u001a\u00020l2\u0006\u0010g\u001a\u00020\n2!\u0010r\u001a\u001d\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\bo\u0012\b\bp\u0012\u0004\b\b(q\u0012\u0004\u0012\u00020\u00020nH\u0002J\u0018\u0010v\u001a\u00020\u00022\u0006\u0010t\u001a\u00020\n2\u0006\u0010u\u001a\u00020\nH\u0002J\u0018\u0010w\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u0016H\u0002J\u001a\u0010y\u001a\u00020\u00022\b\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010x\u001a\u00020\u0016H\u0002J\u0012\u0010{\u001a\u0004\u0018\u00010E2\u0006\u0010z\u001a\u00020\bH\u0002J\b\u0010|\u001a\u00020\nH\u0002J\u0018\u0010}\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u0016H\u0002J\b\u0010~\u001a\u00020\nH\u0002J\b\u0010\u007f\u001a\u00020\nH\u0002J\u0010\u0010\u0081\u0001\u001a\u00020\u00022\u0007\u0010\u0080\u0001\u001a\u00020\u0007J\u0007\u0010\u0082\u0001\u001a\u00020-J\u0007\u0010\u0083\u0001\u001a\u00020\u0002J\u0017\u0010\u0084\u0001\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u0016J\u000f\u0010\u0085\u0001\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ\b\u0010\u0087\u0001\u001a\u00030\u0086\u0001J\u0011\u0010\u008a\u0001\u001a\u00020\u00022\b\u0010\u0089\u0001\u001a\u00030\u0088\u0001J\u0011\u0010\u008b\u0001\u001a\u00020\u00022\b\u0010\u0089\u0001\u001a\u00030\u0088\u0001J\u0007\u0010\u008c\u0001\u001a\u00020\u0002J\u0007\u0010\u008d\u0001\u001a\u00020\u0002J\u0011\u0010\u0090\u0001\u001a\u00020\u00022\b\u0010\u008f\u0001\u001a\u00030\u008e\u0001J\u0011\u0010\u0091\u0001\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\nJ\u000f\u0010\u0092\u0001\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u0016J\u0010\u0010\u0094\u0001\u001a\u00020\u00022\u0007\u0010\u0093\u0001\u001a\u00020\nJ\u0007\u0010\u0095\u0001\u001a\u00020\u0002R\u001b\u0010m\u001a\u00020l8\u0006\u00a2\u0006\u0010\n\u0006\b\u0096\u0001\u0010\u0097\u0001\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001R\u0019\u0010\u009c\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u009a\u0001\u0010\u009b\u0001R+\u0010\u00a1\u0001\u001a\u0016\u0012\u0005\u0012\u00030\u0088\u00010\u009d\u0001j\n\u0012\u0005\u0012\u00030\u0088\u0001`\u009e\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u009f\u0001\u0010\u00a0\u0001R\u0018\u0010\u0093\u0001\u001a\u00030\u0086\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a2\u0001\u0010\u00a3\u0001R\u0017\u0010\u00a6\u0001\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a4\u0001\u0010\u00a5\u0001R\u001c\u0010\u00aa\u0001\u001a\u0005\u0018\u00010\u00a7\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a8\u0001\u0010\u00a9\u0001R\u001c\u0010\u00ae\u0001\u001a\u0005\u0018\u00010\u00ab\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ac\u0001\u0010\u00ad\u0001R)\u0010\u00b3\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u00160\u00af\u0001j\t\u0012\u0004\u0012\u00020\u0016`\u00b0\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00b1\u0001\u0010\u00b2\u0001R\u001b\u0010\u00b6\u0001\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b4\u0001\u0010\u00b5\u0001R\u0017\u0010.\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00b7\u0001\u0010CR\u0018\u0010\u00b9\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00b8\u0001\u0010NR\u001c\u0010\u00bd\u0001\u001a\u0005\u0018\u00010\u00ba\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00bb\u0001\u0010\u00bc\u0001R\u0018\u0010\u00c1\u0001\u001a\u00030\u00be\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00bf\u0001\u0010\u00c0\u0001R\u0018\u0010\u00c5\u0001\u001a\u00030\u00c2\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00c3\u0001\u0010\u00c4\u0001\u00a8\u0006\u00c9\u0001"}, d2 = {"Lcom/tencent/gamecenter/wadl/distribute/contorller/DistributeButtonController;", "", "", "J0", "I0", "v0", "u0", "Lcom/tencent/gamecenter/wadl/distribute/data/ButtonDataBuilder;", "", "f0", "", "subscribeWay", "Lcom/tencent/gamecenter/wadl/api/IQQGameTrpcService;", "iqqGameTrpcService", "M", "H0", "E0", "G0", "F0", "taskKey", WadlProxyConsts.CHANNEL, "appId", "", "dyeOpType", "Ltencent/im/qqgame/QQGameGcSpkTaskDye$SubscribeReq;", "subscribeReq", "N", "B", "y0", "z0", "K0", "L0", "followStatus", "subscribeStatus", "X0", "j0", "from", "defaultTaskStatus", "O", "c0", "Lcom/tencent/gamecenter/wadl/biz/entity/WadlResult;", "wadlResult", "V0", "isGameCenterChannel", "W0", "", "progress", "taskStatus", "i0", "Landroid/content/Intent;", Const.BUNDLE_KEY_REQUEST, "", "ret", "Lcom/tencent/gamecenter/wadl/biz/entity/TrpcProxy$TrpcInovkeRsp;", "rsp", "q0", "subscribeFrom", "b0", "d0", "result", "reqTag", "ctlTag", "a0", "subscribeType", "s0", "p0", "o0", UserInfo.SEX_FEMALE, "D", "Lorg/json/JSONObject;", "jsonObj", BdhLogUtil.LogTag.Tag_Conn, "actionType", "r0", ExifInterface.LATITUDE_SOUTH, "Y", "K", "L", "I", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "U", BdhLogUtil.LogTag.Tag_Req, "P", "T", "Z", "actionCode", "via", "H", "J", "g0", "R0", "Q0", PushClientConstants.TAG_PKG_NAME, "appName", "channelId", "downloadUrl", "iconUrl", "versionCode", "Lcom/tencent/gamecenter/wadl/biz/entity/WadlParams;", "G", "T0", "Landroid/content/res/Resources;", "W", "noticeContent", "Lkotlin/Function0;", "runnable", "E", "h0", "Landroid/content/Context;", "context", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isConfirmed", "callback", "N0", "operId", "operType", "B0", "C0", VirtualAppProxy.KEY_DOWNLOAD_STATUS, "D0", "isClick", "w", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, HippyTKDListViewAdapter.X, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "builder", "M0", "V", "U0", "Y0", "S0", "Lcom/tencent/gamecenter/wadl/distribute/data/ButtonStatus;", "X", "Lcom/tencent/gamecenter/wadl/distribute/listener/IButtonEventListener;", "listener", "v", "w0", "x0", "l0", "Landroid/view/View;", "view", "k0", "e0", "n0", "buttonStatus", "A0", "m0", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "b", "Lcom/tencent/gamecenter/wadl/distribute/data/ButtonDataBuilder;", "dataBuilder", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "c", "Ljava/util/ArrayList;", "eventListeners", "d", "Lcom/tencent/gamecenter/wadl/distribute/data/ButtonStatus;", "e", "Lcom/tencent/gamecenter/wadl/api/IQQGameTrpcService;", "trpcService", "Ltencent/im/qqgame/QQGameQfsSubscribe$DownloadInfo;", "f", "Ltencent/im/qqgame/QQGameQfsSubscribe$DownloadInfo;", "downloadInfo", "Ltencent/im/qqgame/QQGameQfsSubscribe$GameInfo;", "g", "Ltencent/im/qqgame/QQGameQfsSubscribe$GameInfo;", "gameInfo", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", h.F, "Ljava/util/HashSet;", "privilegedSet", "i", "Ljava/lang/String;", "currInstallChannel", "j", "k", "downloadType", "Lcom/tencent/gamecenter/wadl/distribute/contorller/DistributeButtonController$b;", "l", "Lcom/tencent/gamecenter/wadl/distribute/contorller/DistributeButtonController$b;", "lastExposeReportRecord", "com/tencent/gamecenter/wadl/distribute/contorller/DistributeButtonController$d", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/gamecenter/wadl/distribute/contorller/DistributeButtonController$d;", "wadlTrpcListener", "com/tencent/gamecenter/wadl/distribute/contorller/DistributeButtonController$c", DomainData.DOMAIN_NAME, "Lcom/tencent/gamecenter/wadl/distribute/contorller/DistributeButtonController$c;", "wadlListener", "<init>", "(Landroid/content/Context;)V", "o", "qqgamedownloader-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class DistributeButtonController {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private ButtonDataBuilder dataBuilder;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<IButtonEventListener> eventListeners;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ButtonStatus buttonStatus;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IQQGameTrpcService trpcService;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QQGameQfsSubscribe.DownloadInfo downloadInfo;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QQGameQfsSubscribe.GameInfo gameInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashSet<Integer> privilegedSet;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String currInstallChannel;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private float progress;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private int downloadType;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ExposeReportRecord lastExposeReportRecord;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d wadlTrpcListener;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c wadlListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0016J.\u0010\u000e\u001a\u00020\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/gamecenter/wadl/distribute/contorller/DistributeButtonController$d", "Lcom/tencent/gamecenter/wadl/biz/listener/WadlTrpcListener;", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getFilterCmds", "Landroid/content/Intent;", Const.BUNDLE_KEY_REQUEST, "cmd", "", "ret", "Lcom/tencent/gamecenter/wadl/biz/entity/TrpcProxy$TrpcInovkeRsp;", "rsp", "", "onTrpcRsp", "qqgamedownloader-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class d implements WadlTrpcListener {
        d() {
        }

        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
        @NotNull
        public HashSet<String> getFilterCmds() {
            HashSet<String> hashSet = new HashSet<>();
            hashSet.add(WadlProxyConsts.CMD_GAME_SUBSCRIBE);
            hashSet.add(WadlProxyConsts.CMD_GAME_DYE_USER);
            hashSet.add(WadlProxyConsts.CMD_QUERY_SUBSCRIBE_STATUS);
            hashSet.add(WadlProxyConsts.CMD_CHECK_INSTALL_CHANNEL);
            return hashSet;
        }

        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
        public void onTrpcRsp(@Nullable Intent request, @Nullable String cmd, long ret, @Nullable TrpcProxy.TrpcInovkeRsp rsp) {
            if (cmd != null) {
                switch (cmd.hashCode()) {
                    case -2107025038:
                        if (cmd.equals(WadlProxyConsts.CMD_QUERY_SUBSCRIBE_STATUS)) {
                            DistributeButtonController.this.p0(request, ret, rsp);
                            return;
                        }
                        return;
                    case -2107022100:
                        if (!cmd.equals(WadlProxyConsts.CMD_GAME_DYE_USER)) {
                            return;
                        }
                        break;
                    case -893292633:
                        if (cmd.equals(WadlProxyConsts.CMD_CHECK_INSTALL_CHANNEL)) {
                            DistributeButtonController.this.o0(request, ret, rsp);
                            return;
                        }
                        return;
                    case 1456052255:
                        if (!cmd.equals(WadlProxyConsts.CMD_GAME_SUBSCRIBE)) {
                            return;
                        }
                        break;
                    default:
                        return;
                }
                DistributeButtonController.this.q0(request, ret, rsp);
            }
        }
    }

    public DistributeButtonController(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.eventListeners = new ArrayList<>();
        this.buttonStatus = new ButtonStatus(0, 0, 0);
        QRouteApi api = QRoute.api(IQQGameTrpcService.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IQQGameTrpcService::class.java)");
        this.trpcService = (IQQGameTrpcService) api;
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(6);
        this.privilegedSet = hashSet;
        this.downloadType = 1;
        this.wadlTrpcListener = new d();
        this.wadlListener = new c();
    }

    private final String A() {
        if (GameCenterUtil.checkInstallPermission()) {
            return "1";
        }
        return "2";
    }

    private final boolean B() {
        boolean z16;
        ButtonDataBuilder buttonDataBuilder = this.dataBuilder;
        if (buttonDataBuilder == null) {
            QLog.e("wadl_distribute_DistributeButtonControl", 1, "dataBuilder has not set before call update");
            return false;
        }
        if (buttonDataBuilder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBuilder");
            buttonDataBuilder = null;
        }
        if (buttonDataBuilder.getAppId().length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return true;
        }
        QLog.e("wadl_distribute_DistributeButtonControl", 1, "[checkData] appId is empty");
        return false;
    }

    private final void B0(String operId, String operType) {
        boolean z16;
        JSONObject jSONObject;
        try {
            ButtonDataBuilder buttonDataBuilder = this.dataBuilder;
            ButtonDataBuilder buttonDataBuilder2 = null;
            if (buttonDataBuilder == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBuilder");
                buttonDataBuilder = null;
            }
            if (buttonDataBuilder.getReportData().length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                jSONObject = new JSONObject();
            } else {
                ButtonDataBuilder buttonDataBuilder3 = this.dataBuilder;
                if (buttonDataBuilder3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dataBuilder");
                    buttonDataBuilder3 = null;
                }
                jSONObject = new JSONObject(buttonDataBuilder3.getReportData());
            }
            jSONObject.put(WadlReportBuilder.TableElem.SQ_VERSION, AppSetting.f99551k);
            jSONObject.put("device_type", Build.BRAND);
            jSONObject.put("domain", "1");
            jSONObject.put("ext11", "1");
            jSONObject.put("ext12", WadlProxyConsts.PAGE_ID_DOWNLOAD);
            jSONObject.put(WadlReportBuilder.TableElem.OPER_MOUDLE, WadlProxyConsts.OPER_MODULE_DOWNLOAD);
            jSONObject.put("ext1", "81708");
            jSONObject.put(WadlReportBuilder.TableElem.OPER_ID, operId);
            jSONObject.put("ext4", operType);
            ButtonDataBuilder buttonDataBuilder4 = this.dataBuilder;
            if (buttonDataBuilder4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBuilder");
            } else {
                buttonDataBuilder2 = buttonDataBuilder4;
            }
            jSONObject.put(WadlReportBuilder.TableElem.GAME_APPID, buttonDataBuilder2.getAppId());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("data", jSONObject);
            jSONObject2.put(WadlReportBuilder.KEY_DC_ID, WadlProxyConsts.TAG_DC_00087);
            JSONArray jSONArray = new JSONArray();
            jSONArray.mo162put(jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(WadlReportBuilder.KEY_REPORT_LIST, jSONArray);
            ((IQQGameReportService) QRoute.api(IQQGameReportService.class)).report(jSONObject3, 0);
        } catch (Exception e16) {
            QLog.e("wadl_distribute_DistributeButtonControl", 1, e16, new Object[0]);
        }
    }

    private final boolean C(JSONObject jsonObj) {
        boolean z16;
        if (jsonObj != null && jsonObj.optInt(IQQGameSwitchApi.PARAMS_KEY_NETWORK_CHECK) == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 || NetworkUtil.isNetSupport(MobileQQ.sMobileQQ)) {
            return false;
        }
        QLog.i("wadl_distribute_DistributeButtonControl", 1, "network error");
        QQToast.makeText(MobileQQ.sMobileQQ, 1, R.string.zse, 0).show();
        return true;
    }

    private final void C0(int followStatus, int subscribeStatus) {
        String str;
        ExposeReportRecord exposeReportRecord = new ExposeReportRecord(Q(), followStatus, subscribeStatus, 0, 8, null);
        if (exposeReportRecord.a(this.lastExposeReportRecord)) {
            return;
        }
        this.lastExposeReportRecord = exposeReportRecord;
        JSONObject w3 = w(false);
        if (w3 == null) {
            return;
        }
        if (followStatus > 0) {
            if (followStatus == 2) {
                str = "\u5df2\u5173\u6ce8";
            } else {
                str = "\u5173\u6ce8";
            }
        } else if (subscribeStatus != 2 && followStatus != 1995001) {
            str = "\u9884\u7ea6";
        } else {
            str = "\u5df2\u9884\u7ea6";
        }
        new com.tencent.gamecenter.wadl.biz.entity.d().h("distribution_button_expose").e(w3).k(Q()).r(U()).l(R()).j(22, str).j(11, String.valueOf(Z())).j(12, z(followStatus, subscribeStatus)).j(14, x()).j(15, A()).j(25, "2").b();
    }

    private final boolean D(String from) {
        int i3;
        QQGameQfsSubscribe.DownloadInfo downloadInfo = this.downloadInfo;
        if (downloadInfo != null) {
            Intrinsics.checkNotNull(downloadInfo);
            int appVersionCode = GameCenterUtil.getAppVersionCode(downloadInfo.pkgName.get());
            int i16 = -1;
            if (appVersionCode == -1) {
                return false;
            }
            try {
                QQGameQfsSubscribe.DownloadInfo downloadInfo2 = this.downloadInfo;
                Intrinsics.checkNotNull(downloadInfo2);
                String minVerStr = downloadInfo2.min_update_version.get();
                QQGameQfsSubscribe.DownloadInfo downloadInfo3 = this.downloadInfo;
                Intrinsics.checkNotNull(downloadInfo3);
                String lastVerStr = downloadInfo3.versionCode.get();
                QLog.d("wadl_distribute_DistributeButtonControl", 1, "checkUpdateFlag from=" + from + ",localVer=" + appVersionCode + ",minVerStr=" + minVerStr + ",lastVerStr=" + lastVerStr);
                if (!TextUtils.isEmpty(minVerStr)) {
                    Intrinsics.checkNotNullExpressionValue(minVerStr, "minVerStr");
                    i16 = Integer.parseInt(minVerStr);
                }
                if (!TextUtils.isEmpty(lastVerStr)) {
                    Intrinsics.checkNotNullExpressionValue(lastVerStr, "lastVerStr");
                    i3 = Integer.parseInt(lastVerStr);
                } else {
                    i3 = 0;
                }
                if (appVersionCode >= i16 || appVersionCode >= i3) {
                    return false;
                }
                return true;
            } catch (Exception e16) {
                QLog.e("wadl_distribute_DistributeButtonControl", 1, "checkUpdateFlag exception", e16);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00ac, code lost:
    
        if (r15 != 7) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00ae, code lost:
    
        r14 = "\u4e0b\u8f7d";
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00d2, code lost:
    
        if (r0 != false) goto L49;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void D0(WadlResult wadlResult, int downloadStatus) {
        int i3;
        WadlParams wadlParams;
        boolean z16 = false;
        JSONObject w3 = w(false);
        if (w3 != null && this.gameInfo != null) {
            ExposeReportRecord exposeReportRecord = new ExposeReportRecord(Q(), 0, 0, downloadStatus, 6, null);
            if (exposeReportRecord.a(this.lastExposeReportRecord)) {
                QLog.w("wadl_distribute_DistributeButtonControl", 1, "reportShowDownloadStatus isSameReport");
                return;
            }
            this.lastExposeReportRecord = exposeReportRecord;
            if (wadlResult != null && (wadlParams = wadlResult.wadlParams) != null) {
                i3 = wadlParams.downloadType;
            } else {
                i3 = this.downloadType;
            }
            this.downloadType = i3;
            QLog.d("wadl_distribute_DistributeButtonControl", 1, "reportShowDownloadStatus: appId=" + Q() + " downloadType=" + this.downloadType + " currInstallChannel=" + this.currInstallChannel + " gameInfo=" + this.gameInfo + " lastReportRecord=" + this.lastExposeReportRecord);
            int i16 = this.downloadType;
            if (i16 == 3 || i16 == 4) {
                z16 = true;
            }
            String str = "\u66f4\u65b0";
            if (downloadStatus != 0) {
                if (downloadStatus != 2) {
                    if (downloadStatus != 9) {
                        if (downloadStatus != 12) {
                            if (downloadStatus != 100) {
                                if (downloadStatus != 4) {
                                    if (downloadStatus != 5) {
                                        if (downloadStatus == 6) {
                                            str = z16 ? "\u66f4\u65b0\u5b89\u88c5" : "\u4e0b\u8f7d\u5b89\u88c5";
                                        }
                                    } else {
                                        str = z16 ? "\u6682\u505c\u66f4\u65b0" : "\u6682\u505c\u4e0b\u8f7d";
                                    }
                                }
                            }
                        }
                    } else {
                        str = "\u542f\u52a8";
                    }
                    new com.tencent.gamecenter.wadl.biz.entity.d().h("distribution_button_expose").e(w3).k(Q()).r(U()).l(R()).j(1, String.valueOf(this.downloadType)).j(22, str).j(4, this.currInstallChannel).j(11, String.valueOf(Z())).j(12, "3").j(14, x()).j(15, A()).j(25, "2").b();
                }
                str = z16 ? "\u66f4\u65b0\u4e2d" : "\u4e0b\u8f7d\u4e2d";
                new com.tencent.gamecenter.wadl.biz.entity.d().h("distribution_button_expose").e(w3).k(Q()).r(U()).l(R()).j(1, String.valueOf(this.downloadType)).j(22, str).j(4, this.currInstallChannel).j(11, String.valueOf(Z())).j(12, "3").j(14, x()).j(15, A()).j(25, "2").b();
            }
        } else {
            QLog.w("wadl_distribute_DistributeButtonControl", 1, "reportShowDownloadStatus params invalid, attaReportData=" + w3 + " gameInfo=" + this.gameInfo);
        }
    }

    private final void E(String noticeContent, final Function0<Unit> runnable) {
        if (h0()) {
            runnable.invoke();
            return;
        }
        try {
            QLog.i("wadl_distribute_DistributeButtonControl", 1, "[checkWifiAndRun] is wifi not connected");
            N0(this.context, noticeContent, new Function1<Boolean, Unit>() { // from class: com.tencent.gamecenter.wadl.distribute.contorller.DistributeButtonController$checkWifiAndRun$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    if (z16) {
                        runnable.invoke();
                    }
                }
            });
        } catch (Exception e16) {
            QLog.e("wadl_distribute_DistributeButtonControl", 1, e16 + "context:" + this.context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E0(ButtonDataBuilder buttonDataBuilder) {
        N(buttonDataBuilder.getSparkTaskKey(), buttonDataBuilder.getApkChannel(), buttonDataBuilder.getAppId(), 2, "", null);
    }

    private final void F() {
        this.downloadInfo = null;
        this.gameInfo = null;
    }

    private final void F0(ButtonDataBuilder buttonDataBuilder) {
        N(buttonDataBuilder.getSparkTaskKey(), buttonDataBuilder.getApkChannel(), buttonDataBuilder.getAppId(), 4, "", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WadlParams G(String appId, String pkgName, String appName, String channelId, String downloadUrl, String iconUrl, int versionCode) {
        WadlParams wadlParams = new WadlParams(appId, pkgName);
        wadlParams.apkUrl = downloadUrl;
        wadlParams.appName = appName;
        wadlParams.apkChannel = channelId;
        wadlParams.iconUrl = iconUrl;
        wadlParams.versionCode = versionCode;
        return wadlParams;
    }

    private final void G0(ButtonDataBuilder buttonDataBuilder) {
        N(buttonDataBuilder.getSparkTaskKey(), buttonDataBuilder.getApkChannel(), buttonDataBuilder.getAppId(), 3, "", null);
    }

    private final void H(final JSONObject jsonObj, final int actionCode, final String via) {
        ButtonDataBuilder buttonDataBuilder = this.dataBuilder;
        if (buttonDataBuilder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBuilder");
            buttonDataBuilder = null;
        }
        final ButtonDataBuilder buttonDataBuilder2 = buttonDataBuilder;
        String string = W().getString(R.string.f170856zs4);
        Intrinsics.checkNotNullExpressionValue(string, "getRes().getString(com.t\u2026stribute_button_not_wifi)");
        E(string, new Function0<Unit>() { // from class: com.tencent.gamecenter.wadl.distribute.contorller.DistributeButtonController$doDownloadAction$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                String R;
                String P;
                String T;
                int Z;
                WadlParams G;
                int i3;
                boolean f06;
                DistributeButtonController distributeButtonController = DistributeButtonController.this;
                String appId = buttonDataBuilder2.getAppId();
                String U = DistributeButtonController.this.U();
                R = DistributeButtonController.this.R();
                String apkChannel = buttonDataBuilder2.getApkChannel();
                P = DistributeButtonController.this.P();
                T = DistributeButtonController.this.T();
                Z = DistributeButtonController.this.Z();
                G = distributeButtonController.G(appId, U, R, apkChannel, P, T, Z);
                G.actionCode = actionCode;
                i3 = DistributeButtonController.this.downloadType;
                G.downloadType = i3;
                G.via = via;
                String attaReportData = buttonDataBuilder2.getAttaReportData();
                if (!(attaReportData == null || attaReportData.length() == 0)) {
                    JSONObject jSONObject = new JSONObject(attaReportData);
                    try {
                        G.adtag = jSONObject.optString("adtag");
                        G.wadlParamsPageInfo.a(jSONObject);
                        G.wadlParamsExt.a(jSONObject);
                    } catch (JSONException e16) {
                        QLog.e("wadl_distribute_DistributeButtonControl", 1, "doDownloadAction parse rawData failed, rawData=" + attaReportData + ", exception: ", e16);
                    }
                }
                WadlProxyServiceUtil.getProxyService().doDownloadAction(G);
                DistributeButtonController.this.r0("download", "", jsonObj);
                f06 = DistributeButtonController.this.f0(buttonDataBuilder2);
                if (f06) {
                    DistributeButtonController.this.E0(buttonDataBuilder2);
                }
            }
        });
    }

    private final void H0(ButtonDataBuilder buttonDataBuilder, String str) {
        QQGameGcSpkTaskDye.SubscribeReq subscribeReq = new QQGameGcSpkTaskDye.SubscribeReq();
        subscribeReq.subscribeType.set(1);
        N(buttonDataBuilder.getSparkTaskKey(), buttonDataBuilder.getApkChannel(), buttonDataBuilder.getAppId(), 1, str, subscribeReq);
    }

    private final void I() {
        ButtonDataBuilder buttonDataBuilder = this.dataBuilder;
        if (buttonDataBuilder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBuilder");
            buttonDataBuilder = null;
        }
        WadlProxyServiceUtil.getProxyService().doInstallAction(G(buttonDataBuilder.getAppId(), U(), R(), buttonDataBuilder.getApkChannel(), P(), T(), Z()));
        if (f0(buttonDataBuilder)) {
            F0(buttonDataBuilder);
        }
    }

    private final void I0() {
        QQGameQfsSubscribe.GameInfo gameInfo = this.gameInfo;
        if (gameInfo == null) {
            return;
        }
        ButtonDataBuilder buttonDataBuilder = this.dataBuilder;
        if (buttonDataBuilder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBuilder");
            buttonDataBuilder = null;
        }
        if (!Intrinsics.areEqual(buttonDataBuilder.getAppId(), gameInfo.appID.get())) {
            this.gameInfo = null;
            this.downloadInfo = null;
            this.currInstallChannel = "";
        }
    }

    private final void J() {
        ButtonDataBuilder buttonDataBuilder = this.dataBuilder;
        if (buttonDataBuilder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBuilder");
            buttonDataBuilder = null;
        }
        if (g0()) {
            R0(buttonDataBuilder);
        } else {
            Q0(buttonDataBuilder);
        }
        if (f0(buttonDataBuilder)) {
            G0(buttonDataBuilder);
        }
    }

    private final void J0() {
        I0();
        c0();
    }

    private final void K() {
        WadlProxyServiceWrap proxyService = WadlProxyServiceUtil.getProxyService();
        ButtonDataBuilder buttonDataBuilder = this.dataBuilder;
        if (buttonDataBuilder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBuilder");
            buttonDataBuilder = null;
        }
        proxyService.doPauseAction(0, buttonDataBuilder.getAppId());
    }

    private final void K0() {
        this.trpcService.addListener(this.wadlTrpcListener);
    }

    private final void L() {
        String string = W().getString(R.string.f170856zs4);
        Intrinsics.checkNotNullExpressionValue(string, "getRes().getString(com.t\u2026stribute_button_not_wifi)");
        E(string, new Function0<Unit>() { // from class: com.tencent.gamecenter.wadl.distribute.contorller.DistributeButtonController$doResumeAction$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ButtonDataBuilder buttonDataBuilder;
                boolean f06;
                buttonDataBuilder = DistributeButtonController.this.dataBuilder;
                if (buttonDataBuilder == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dataBuilder");
                    buttonDataBuilder = null;
                }
                DistributeButtonController distributeButtonController = DistributeButtonController.this;
                WadlProxyServiceUtil.getProxyService().doResumeAction(0, buttonDataBuilder.getAppId());
                f06 = distributeButtonController.f0(buttonDataBuilder);
                if (f06) {
                    distributeButtonController.E0(buttonDataBuilder);
                }
            }
        });
    }

    private final void L0() {
        WadlProxyServiceUtil.getProxyService().registerWadlServiceCallBack(this.wadlListener);
    }

    private final void M(String subscribeWay, IQQGameTrpcService iqqGameTrpcService) {
        ButtonDataBuilder buttonDataBuilder = this.dataBuilder;
        if (buttonDataBuilder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBuilder");
            buttonDataBuilder = null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("appid", buttonDataBuilder.getAppId());
        bundle.putString("key_disturbute_subscribe_way", subscribeWay);
        bundle.putString("key_disturbute_subscribe_from", "subscribe_from_common");
        bundle.putInt("key_req_tag", hashCode());
        iqqGameTrpcService.subscribe(buttonDataBuilder.getAppId(), buttonDataBuilder.getSubScribeSource(), buttonDataBuilder.getApkChannel(), 1, bundle);
    }

    private final void N(String taskKey, String channel, String appId, int dyeOpType, String subscribeWay, QQGameGcSpkTaskDye.SubscribeReq subscribeReq) {
        try {
            int parseInt = Integer.parseInt(appId);
            QLog.i("wadl_distribute_DistributeButtonControl", 2, "[dyeUserForSpark] taskKey:" + taskKey + ",channel:" + channel + ",appId:" + appId + ",dyeOpType:" + dyeOpType + ",subscribeWay:" + subscribeWay);
            QQGameGcSpkTaskDye.GetDyedReq getDyedReq = new QQGameGcSpkTaskDye.GetDyedReq();
            if (!TextUtils.isEmpty(taskKey)) {
                getDyedReq.task_key.set(taskKey);
            }
            if (!TextUtils.isEmpty(channel)) {
                getDyedReq.channel_id.set(channel);
            }
            getDyedReq.appid.set(parseInt);
            getDyedReq.f436034op.set(dyeOpType);
            if (subscribeReq != null) {
                getDyedReq.subscribe_req.set(subscribeReq);
            }
            getDyedReq.plat.set(1);
            TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = this.trpcService.createTrpcInvokeReq(WadlProxyConsts.CMD_GAME_DYE_USER, false, getDyedReq.toByteArray());
            TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
            trpcListReq.list.add(createTrpcInvokeReq);
            Bundle bundle = new Bundle();
            bundle.putString("appid", appId);
            bundle.putInt("type", dyeOpType);
            bundle.putString("key_disturbute_subscribe_way", subscribeWay);
            bundle.putString("key_disturbute_subscribe_from", "subscribe_from_spark");
            bundle.putInt("key_req_tag", hashCode());
            this.trpcService.requestTrpc(trpcListReq, bundle);
        } catch (Exception unused) {
            QLog.e("wadl_distribute_DistributeButtonControl", 1, "dyeUser msg exception");
        }
    }

    private final void N0(Context context, String noticeContent, final Function1<? super Boolean, Unit> callback) {
        if (!(context instanceof Activity) || ((Activity) context).isFinishing()) {
            Activity topActivity = Foreground.getTopActivity();
            QLog.e("wadl_distribute_DistributeButtonControl", 1, "[showNoWifiDialog] context is not Activity or finished,context:" + context + ",finalContext:" + topActivity);
            context = topActivity;
        }
        DialogUtil.createCustomDialog(context, 230).setTitle(W().getString(R.string.zsc)).setMessage(noticeContent).setPositiveButton(W().getString(R.string.zsb), new DialogInterface.OnClickListener() { // from class: com.tencent.gamecenter.wadl.distribute.contorller.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                DistributeButtonController.O0(Function1.this, dialogInterface, i3);
            }
        }).setNegativeButton(W().getString(R.string.zsd), new DialogInterface.OnClickListener() { // from class: com.tencent.gamecenter.wadl.distribute.contorller.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                DistributeButtonController.P0(Function1.this, dialogInterface, i3);
            }
        }).show();
    }

    private final int O(String from, int defaultTaskStatus) {
        if (defaultTaskStatus != 0 && defaultTaskStatus != 12 && defaultTaskStatus != 7 && defaultTaskStatus != 9) {
            return defaultTaskStatus;
        }
        if (D(from)) {
            this.downloadType = 3;
            return 100;
        }
        return defaultTaskStatus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O0(Function1 callback, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.invoke(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String P() {
        PBStringField pBStringField;
        ButtonDataBuilder buttonDataBuilder = this.dataBuilder;
        String str = null;
        ButtonDataBuilder buttonDataBuilder2 = null;
        str = null;
        if (buttonDataBuilder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBuilder");
            buttonDataBuilder = null;
        }
        if (!TextUtils.isEmpty(buttonDataBuilder.getApkUrl())) {
            ButtonDataBuilder buttonDataBuilder3 = this.dataBuilder;
            if (buttonDataBuilder3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBuilder");
            } else {
                buttonDataBuilder2 = buttonDataBuilder3;
            }
            return buttonDataBuilder2.getApkUrl();
        }
        QQGameQfsSubscribe.DownloadInfo downloadInfo = this.downloadInfo;
        if (downloadInfo != null && (pBStringField = downloadInfo.androidDownloadUrl) != null) {
            str = pBStringField.get();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P0(Function1 callback, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.invoke(Boolean.FALSE);
    }

    private final String Q() {
        ButtonDataBuilder buttonDataBuilder = this.dataBuilder;
        ButtonDataBuilder buttonDataBuilder2 = null;
        if (buttonDataBuilder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBuilder");
            buttonDataBuilder = null;
        }
        if (!TextUtils.isEmpty(buttonDataBuilder.getAppId())) {
            ButtonDataBuilder buttonDataBuilder3 = this.dataBuilder;
            if (buttonDataBuilder3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBuilder");
            } else {
                buttonDataBuilder2 = buttonDataBuilder3;
            }
            return buttonDataBuilder2.getAppId();
        }
        return "";
    }

    private final boolean Q0(ButtonDataBuilder buttonDataBuilder) {
        int i3;
        boolean z16;
        try {
            boolean contains = this.privilegedSet.contains(Integer.valueOf(buttonDataBuilder.getBusinessChannel()));
            if (QLog.isColorLevel()) {
                QLog.d("wadl_distribute_DistributeButtonControl", 2, "<--startAppWithPkgName pkgName=" + U() + " ,isPrivileged:" + contains);
            }
            PackageManager packageManager = this.context.getPackageManager();
            String U = U();
            int length = U.length() - 1;
            int i16 = 0;
            boolean z17 = false;
            while (i16 <= length) {
                if (!z17) {
                    i3 = i16;
                } else {
                    i3 = length;
                }
                if (Intrinsics.compare((int) U.charAt(i3), 32) <= 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z17) {
                    if (!z16) {
                        z17 = true;
                    } else {
                        i16++;
                    }
                } else {
                    if (!z16) {
                        break;
                    }
                    length--;
                }
            }
            Intent launchIntentForPackage = InstalledAppListMonitor.getLaunchIntentForPackage(packageManager, U.subSequence(i16, length + 1).toString());
            if (launchIntentForPackage != null) {
                launchIntentForPackage.setFlags(268435456);
                launchIntentForPackage.putExtra(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY, "qq_m");
                launchIntentForPackage.putExtra("big_brother_source_key", "biz_src_zf_games");
                launchIntentForPackage.putExtra("key_callback_id", 0);
                if (contains) {
                    launchIntentForPackage.putExtra("launchfrom", "sq_gamecenter");
                    launchIntentForPackage.putExtra("platform", "qq_m");
                }
                this.context.startActivity(launchIntentForPackage);
            }
            return true;
        } catch (Throwable th5) {
            QLog.e("wadl_distribute_DistributeButtonControl", 1, th5, new Object[0]);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String R() {
        PBStringField pBStringField;
        ButtonDataBuilder buttonDataBuilder = this.dataBuilder;
        String str = null;
        ButtonDataBuilder buttonDataBuilder2 = null;
        str = null;
        if (buttonDataBuilder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBuilder");
            buttonDataBuilder = null;
        }
        if (!TextUtils.isEmpty(buttonDataBuilder.getAppName())) {
            ButtonDataBuilder buttonDataBuilder3 = this.dataBuilder;
            if (buttonDataBuilder3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBuilder");
            } else {
                buttonDataBuilder2 = buttonDataBuilder3;
            }
            return buttonDataBuilder2.getAppName();
        }
        QQGameQfsSubscribe.GameInfo gameInfo = this.gameInfo;
        if (gameInfo != null && (pBStringField = gameInfo.appName) != null) {
            str = pBStringField.get();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    private final void R0(ButtonDataBuilder buttonDataBuilder) {
        ITempApi iTempApi = (ITempApi) QRoute.api(ITempApi.class);
        String appId = buttonDataBuilder.getAppId();
        String U = U();
        HashSet<Integer> hashSet = this.privilegedSet;
        ButtonDataBuilder buttonDataBuilder2 = this.dataBuilder;
        if (buttonDataBuilder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBuilder");
            buttonDataBuilder2 = null;
        }
        iTempApi.startGameForDistributeBtn(appId, U, hashSet.contains(Integer.valueOf(buttonDataBuilder2.getBusinessChannel())), this.context);
    }

    private final String S() {
        ButtonDataBuilder buttonDataBuilder = this.dataBuilder;
        ButtonDataBuilder buttonDataBuilder2 = null;
        if (buttonDataBuilder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBuilder");
            buttonDataBuilder = null;
        }
        String reportData = buttonDataBuilder.getReportData();
        ButtonDataBuilder buttonDataBuilder3 = this.dataBuilder;
        if (buttonDataBuilder3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBuilder");
        } else {
            buttonDataBuilder2 = buttonDataBuilder3;
        }
        return "action_type=download&appid=" + buttonDataBuilder2.getAppId() + "&report_params=" + reportData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String T() {
        PBStringField pBStringField;
        ButtonDataBuilder buttonDataBuilder = this.dataBuilder;
        String str = null;
        ButtonDataBuilder buttonDataBuilder2 = null;
        str = null;
        if (buttonDataBuilder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBuilder");
            buttonDataBuilder = null;
        }
        if (!TextUtils.isEmpty(buttonDataBuilder.getIconUrl())) {
            ButtonDataBuilder buttonDataBuilder3 = this.dataBuilder;
            if (buttonDataBuilder3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBuilder");
            } else {
                buttonDataBuilder2 = buttonDataBuilder3;
            }
            return buttonDataBuilder2.getIconUrl();
        }
        QQGameQfsSubscribe.GameInfo gameInfo = this.gameInfo;
        if (gameInfo != null && (pBStringField = gameInfo.gameIcon) != null) {
            str = pBStringField.get();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    private final void T0() {
        QLog.i("wadl_distribute_DistributeButtonControl", 1, "[tryQueryAllTask]");
        if (GameCenterUtil.isPackageInstalled(U())) {
            this.buttonStatus.setDownloadTaskStatus(9);
            u0();
        } else {
            WadlProxyServiceUtil.getProxyService().doQueryAllTask();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String U() {
        PBStringField pBStringField;
        ButtonDataBuilder buttonDataBuilder = this.dataBuilder;
        String str = null;
        ButtonDataBuilder buttonDataBuilder2 = null;
        str = null;
        if (buttonDataBuilder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBuilder");
            buttonDataBuilder = null;
        }
        if (!TextUtils.isEmpty(buttonDataBuilder.getPkgName())) {
            ButtonDataBuilder buttonDataBuilder3 = this.dataBuilder;
            if (buttonDataBuilder3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBuilder");
            } else {
                buttonDataBuilder2 = buttonDataBuilder3;
            }
            return buttonDataBuilder2.getPkgName();
        }
        QQGameQfsSubscribe.DownloadInfo downloadInfo = this.downloadInfo;
        if (downloadInfo != null && (pBStringField = downloadInfo.pkgName) != null) {
            str = pBStringField.get();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean V0(WadlResult wadlResult) {
        WadlParams wadlParams = wadlResult.wadlParams;
        if (wadlParams != null && e0(wadlParams.appId)) {
            this.progress = wadlResult.floatProgress;
            int i3 = wadlResult.taskStatus;
            if (i3 != 4) {
                this.buttonStatus.setDownloadTaskStatus(O("updateDownloadTaskStatus", i3));
            } else {
                this.buttonStatus.setDownloadTaskStatus(i3);
            }
            String str = wadlResult.wadlParams.appId;
            Intrinsics.checkNotNullExpressionValue(str, "wadlResult.wadlParams.appId");
            i0(str, this.progress, wadlResult.taskStatus);
            QLog.i("wadl_distribute_DistributeButtonControl", 2, "[updateDownloadTaskStatus] taskStatus:" + wadlResult + ".taskStatus,progress:" + this.progress);
            return true;
        }
        return false;
    }

    private final Resources W() {
        Resources resources = this.context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        return resources;
    }

    private final void W0(String appId, boolean isGameCenterChannel) {
        boolean z16 = true;
        QLog.d("wadl_distribute_DistributeButtonControl", 1, "[updateDownloadTaskStatus] appId:" + appId + ", isGCChannel:" + isGameCenterChannel + ", status:" + this.buttonStatus.getDownloadTaskStatus());
        if (appId != null && appId.length() != 0) {
            z16 = false;
        }
        if (!z16 && e0(appId) && this.buttonStatus.getDownloadTaskStatus() == 9 && !isGameCenterChannel) {
            this.buttonStatus.setDownloadTaskStatus(0);
            j0(appId, this.buttonStatus.getFollowStatus(), this.buttonStatus.getSubscribeStatus());
        }
    }

    private final void X0(String appId, int followStatus, int subscribeStatus) {
        if (followStatus != -1) {
            this.buttonStatus.setFollowStatus(followStatus);
        }
        if (subscribeStatus != -1) {
            this.buttonStatus.setSubscribeStatus(subscribeStatus);
        }
        j0(appId, this.buttonStatus.getFollowStatus(), this.buttonStatus.getSubscribeStatus());
        QLog.i("wadl_distribute_DistributeButtonControl", 1, "[updateFollowOrSubscribeStatus] followStatus:" + followStatus + ",subscribeStatus:" + subscribeStatus);
    }

    private final String Y(String subscribeType) {
        ButtonDataBuilder buttonDataBuilder = this.dataBuilder;
        ButtonDataBuilder buttonDataBuilder2 = null;
        if (buttonDataBuilder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBuilder");
            buttonDataBuilder = null;
        }
        String reportData = buttonDataBuilder.getReportData();
        ButtonDataBuilder buttonDataBuilder3 = this.dataBuilder;
        if (buttonDataBuilder3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBuilder");
        } else {
            buttonDataBuilder2 = buttonDataBuilder3;
        }
        return "action_type=subscribe&appid=" + buttonDataBuilder2.getAppId() + "&subscribe_type=" + subscribeType + "&report_params=" + reportData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int Z() {
        PBStringField pBStringField;
        ButtonDataBuilder buttonDataBuilder = this.dataBuilder;
        String str = null;
        ButtonDataBuilder buttonDataBuilder2 = null;
        str = null;
        if (buttonDataBuilder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBuilder");
            buttonDataBuilder = null;
        }
        if (buttonDataBuilder.getVersionCode() != 0) {
            ButtonDataBuilder buttonDataBuilder3 = this.dataBuilder;
            if (buttonDataBuilder3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBuilder");
            } else {
                buttonDataBuilder2 = buttonDataBuilder3;
            }
            return buttonDataBuilder2.getVersionCode();
        }
        QQGameQfsSubscribe.DownloadInfo downloadInfo = this.downloadInfo;
        if (downloadInfo != null && (pBStringField = downloadInfo.versionCode) != null) {
            str = pBStringField.get();
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            Intrinsics.checkNotNull(str);
            return Integer.parseInt(str);
        } catch (Throwable th5) {
            QLog.e("wadl_distribute_DistributeButtonControl", 1, th5, new Object[0]);
            return 0;
        }
    }

    private final void a0(String subscribeWay, String appId, int result, int reqTag, int ctlTag) {
        if (Intrinsics.areEqual("1", subscribeWay)) {
            X0(appId, result, -1);
        } else {
            X0(appId, -1, result);
        }
        if (reqTag == ctlTag) {
            s0(subscribeWay);
        }
    }

    private final void b0(String subscribeFrom, TrpcProxy.TrpcInovkeRsp rsp, Intent request, String appId) {
        int i3;
        try {
            if (Intrinsics.areEqual("subscribe_from_spark", subscribeFrom)) {
                QQGameGcSpkTaskDye.GetDyedRsp getDyedRsp = new QQGameGcSpkTaskDye.GetDyedRsp();
                getDyedRsp.mergeFrom(rsp.data.get().toByteArray());
                int intExtra = request.getIntExtra("type", 0);
                if (intExtra != 1) {
                    QLog.i("wadl_distribute_DistributeButtonControl", 2, "handleSubscribeRspSuccess no need handle,dyeOpType:" + intExtra + ",dyedRspMsg:" + getDyedRsp.f436035msg.get());
                    return;
                }
                i3 = getDyedRsp.subscribe_rsp.get().result.get();
            } else {
                QQGameSubscribe$SubscribeUpComingGameRsp qQGameSubscribe$SubscribeUpComingGameRsp = new QQGameSubscribe$SubscribeUpComingGameRsp();
                qQGameSubscribe$SubscribeUpComingGameRsp.mergeFrom(rsp.data.get().toByteArray());
                i3 = qQGameSubscribe$SubscribeUpComingGameRsp.result.get();
            }
            int i16 = i3;
            String stringExtra = request.getStringExtra("key_disturbute_subscribe_way");
            int intExtra2 = request.getIntExtra("key_req_tag", 0);
            int hashCode = hashCode();
            QLog.i("wadl_distribute_DistributeButtonControl", 1, "onSubscribeRsp subscribeStatus=" + i16 + ", appId:" + appId + ",subscribeType:" + stringExtra + ",ctl:" + hashCode + ",reqTag:" + intExtra2);
            if (i16 == 2 || i16 == 1995001) {
                Intrinsics.checkNotNull(appId);
                a0(stringExtra, appId, i16, intExtra2, hashCode);
            }
        } catch (Exception e16) {
            QLog.e("wadl_distribute_DistributeButtonControl", 1, "onSubscribeRsp error:" + e16);
        }
    }

    private final void c0() {
        if (GameCenterUtil.isPackageInstalled(U())) {
            this.buttonStatus.setDownloadTaskStatus(9);
        } else {
            this.buttonStatus.setDownloadTaskStatus(0);
        }
    }

    private final boolean d0(String appId, String subscribeFrom) {
        if (e0(appId) && (Intrinsics.areEqual("subscribe_from_common", subscribeFrom) || Intrinsics.areEqual("subscribe_from_spark", subscribeFrom))) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean f0(ButtonDataBuilder buttonDataBuilder) {
        boolean z16;
        if (buttonDataBuilder.getIsSupportSpark() != 1) {
            return false;
        }
        if (buttonDataBuilder.getSparkTaskKey().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        return true;
    }

    private final boolean g0() {
        if (((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).getConfigJsonObj(IGameCenterUnitedConfigApi.GAME_CENTER_DISTRIBUTE_BTN_CONFIG).optInt("useStartWithTokens", 1) == 1) {
            return true;
        }
        return false;
    }

    private final boolean h0() {
        return NetworkUtil.isWifiConnected(MobileQQ.sMobileQQ);
    }

    private final void i0(String appId, float progress, int taskStatus) {
        synchronized (this) {
            Iterator<IButtonEventListener> it = this.eventListeners.iterator();
            while (it.hasNext()) {
                it.next().onDownloadTaskStatusChange(appId, progress, taskStatus);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void j0(String appId, int followStatus, int subscribeStatus) {
        synchronized (this) {
            Iterator<IButtonEventListener> it = this.eventListeners.iterator();
            while (it.hasNext()) {
                it.next().onFollowOrSubscribeStatusChange(appId, followStatus, subscribeStatus);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o0(Intent request, long ret, TrpcProxy.TrpcInovkeRsp rsp) {
        PBBytesField pBBytesField;
        if (request == null || request.getIntExtra("actionFrom", 0) != 3) {
            return;
        }
        String stringExtra = request.getStringExtra("appid");
        PBBytesField pBBytesField2 = null;
        if (rsp != null) {
            pBBytesField = rsp.data;
        } else {
            pBBytesField = null;
        }
        if (pBBytesField != null && rsp.data.get() != null && ret == 0) {
            try {
                UserGameVersionPB$QueryGameChannelRsp userGameVersionPB$QueryGameChannelRsp = new UserGameVersionPB$QueryGameChannelRsp();
                userGameVersionPB$QueryGameChannelRsp.mergeFrom(rsp.data.get().toByteArray());
                W0(stringExtra, userGameVersionPB$QueryGameChannelRsp.is_gamecenter_channel.get());
                return;
            } catch (Throwable th5) {
                QLog.e("wadl_distribute_DistributeButtonControl", 1, "onQueryInstallChannelRsp: appId=" + stringExtra + " parse pb error:", th5);
                return;
            }
        }
        if (rsp != null) {
            pBBytesField2 = rsp.data;
        }
        QLog.w("wadl_distribute_DistributeButtonControl", 1, "onQueryInstallChannelRsp: appId=" + stringExtra + ", ret=" + ret + ", rspData=" + pBBytesField2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p0(Intent request, long ret, TrpcProxy.TrpcInovkeRsp rsp) {
        String str;
        PBBytesField pBBytesField;
        ByteStringMicro byteStringMicro;
        PBBytesField pBBytesField2;
        ByteStringMicro byteStringMicro2 = null;
        if (request != null) {
            str = request.getStringExtra("appid");
        } else {
            str = null;
        }
        if (!e0(str)) {
            return;
        }
        if (ret == 0) {
            if (rsp != null && (pBBytesField2 = rsp.data) != null) {
                byteStringMicro = pBBytesField2.get();
            } else {
                byteStringMicro = null;
            }
            if (byteStringMicro != null) {
                try {
                    QQGameQfsSubscribe.GetUserGameStatusRsp getUserGameStatusRsp = new QQGameQfsSubscribe.GetUserGameStatusRsp();
                    getUserGameStatusRsp.mergeFrom(rsp.data.get().toByteArray());
                    int i3 = getUserGameStatusRsp.result.get();
                    int i16 = getUserGameStatusRsp.follow_result.get();
                    int downloadTaskStatus = this.buttonStatus.getDownloadTaskStatus();
                    QLog.i("wadl_distribute_DistributeButtonControl", 1, "[onQuerySubscribeRsp] subscribeStatus=" + i3 + ", followStatus=" + i16 + ", appId:" + str);
                    if (i16 <= 0 && i3 == 3) {
                        this.downloadInfo = getUserGameStatusRsp.downloadInfo.get();
                        this.gameInfo = getUserGameStatusRsp.gameInfo.get();
                        downloadTaskStatus = O("init", downloadTaskStatus);
                    } else {
                        F();
                        C0(i16, i3);
                    }
                    QLog.i("wadl_distribute_DistributeButtonControl", 1, "[onQuerySubscribeRsp] downloadStatus=" + downloadTaskStatus);
                    this.buttonStatus.setDownloadTaskStatus(downloadTaskStatus);
                    Intrinsics.checkNotNull(str);
                    X0(str, i16, i3);
                    return;
                } catch (Exception e16) {
                    QLog.e("wadl_distribute_DistributeButtonControl", 1, "[onQuerySubscribeRsp] error:" + e16);
                    return;
                }
            }
        }
        if (rsp != null && (pBBytesField = rsp.data) != null) {
            byteStringMicro2 = pBBytesField.get();
        }
        QLog.i("wadl_distribute_DistributeButtonControl", 1, "[onQuerySubscribeRsp] failed ret:" + ret + ",data:" + byteStringMicro2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q0(Intent request, long ret, TrpcProxy.TrpcInovkeRsp rsp) {
        ByteStringMicro byteStringMicro;
        if (request != null && rsp != null) {
            String stringExtra = request.getStringExtra("appid");
            String stringExtra2 = request.getStringExtra("key_disturbute_subscribe_from");
            if (d0(stringExtra, stringExtra2)) {
                QLog.i("wadl_distribute_DistributeButtonControl", 1, "onSubscribeRsp no need handle, appId:" + stringExtra + ",subscribeFrom:" + stringExtra2);
                return;
            }
            ByteStringMicro byteStringMicro2 = null;
            if (ret == 0) {
                PBBytesField pBBytesField = rsp.data;
                if (pBBytesField != null) {
                    byteStringMicro = pBBytesField.get();
                } else {
                    byteStringMicro = null;
                }
                if (byteStringMicro != null) {
                    b0(stringExtra2, rsp, request, stringExtra);
                    return;
                }
            }
            PBBytesField pBBytesField2 = rsp.data;
            if (pBBytesField2 != null) {
                byteStringMicro2 = pBBytesField2.get();
            }
            QLog.i("wadl_distribute_DistributeButtonControl", 1, "onSubscribeRsp failed ret:" + ret + ",data:" + byteStringMicro2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r0(String actionType, String subscribeType, JSONObject jsonObj) {
        boolean z16;
        String Y;
        boolean contains$default;
        if (jsonObj != null) {
            String optString = jsonObj.optString("bundleName");
            if (optString != null && optString.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                String url = jsonObj.optString("url", DistributeConstants.GAME_CENTER_URL);
                if (Intrinsics.areEqual(actionType, "download")) {
                    Y = S();
                } else {
                    Y = Y(subscribeType);
                }
                Intrinsics.checkNotNullExpressionValue(url, "url");
                String str = QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, false, 2, (Object) null);
                if (contains$default) {
                    str = ContainerUtils.FIELD_DELIMITER;
                }
                jsonObj.put("url", url + str + Y);
                QLog.i("wadl_distribute_DistributeButtonControl", 1, "[openDownloadFlow] params:" + jsonObj + ",isSuccess:" + new OpenHippyInfo(jsonObj).openHippy(this.context));
                return;
            }
        }
        QLog.i("wadl_distribute_DistributeButtonControl", 1, "[openDownloadFlow] params is invalid:" + jsonObj);
    }

    private final void s0(final String subscribeType) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.gamecenter.wadl.distribute.contorller.a
            @Override // java.lang.Runnable
            public final void run() {
                DistributeButtonController.t0(subscribeType, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t0(String str, DistributeButtonController this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (str == null) {
            return;
        }
        this$0.r0("subscribe", str, ((IQQGameSwitchApi) QRoute.api(IQQGameSwitchApi.class)).getJSONObject(IQQGameSwitchApi.SWITCH_KEY_SUBSCRIBE_CONFIG));
    }

    private final void u0() {
        boolean z16;
        ButtonDataBuilder buttonDataBuilder = this.dataBuilder;
        ButtonDataBuilder buttonDataBuilder2 = null;
        if (buttonDataBuilder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBuilder");
            buttonDataBuilder = null;
        }
        String apkSourceDir = GameCenterUtil.getApkSourceDir(buttonDataBuilder.getPkgName());
        if (apkSourceDir != null && apkSourceDir.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            ButtonDataBuilder buttonDataBuilder3 = this.dataBuilder;
            if (buttonDataBuilder3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataBuilder");
            } else {
                buttonDataBuilder2 = buttonDataBuilder3;
            }
            QLog.d("wadl_distribute_DistributeButtonControl", 1, "queryInstallChannel pkg=" + buttonDataBuilder2.getPkgName() + " apkSourceDir is null");
            return;
        }
        String fileChannel = GameCenterUtil.getFileChannel(apkSourceDir);
        IQQGameTrpcService iQQGameTrpcService = this.trpcService;
        iQQGameTrpcService.addListener(this.wadlTrpcListener);
        ButtonDataBuilder buttonDataBuilder4 = this.dataBuilder;
        if (buttonDataBuilder4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBuilder");
            buttonDataBuilder4 = null;
        }
        String appId = buttonDataBuilder4.getAppId();
        ButtonDataBuilder buttonDataBuilder5 = this.dataBuilder;
        if (buttonDataBuilder5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBuilder");
        } else {
            buttonDataBuilder2 = buttonDataBuilder5;
        }
        iQQGameTrpcService.checkInstallChannel(3, 0, appId, buttonDataBuilder2.getPkgName(), fileChannel);
    }

    private final void v0() {
        ButtonDataBuilder buttonDataBuilder = this.dataBuilder;
        if (buttonDataBuilder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBuilder");
            buttonDataBuilder = null;
        }
        IQQGameTrpcService iQQGameTrpcService = this.trpcService;
        iQQGameTrpcService.addListener(this.wadlTrpcListener);
        Bundle bundle = new Bundle();
        bundle.putString("appid", buttonDataBuilder.getAppId());
        iQQGameTrpcService.querySubscribeStatus(buttonDataBuilder.getAppId(), buttonDataBuilder.getApkChannel(), bundle);
    }

    private final JSONObject w(boolean isClick) {
        boolean z16;
        String str;
        String obj;
        ButtonDataBuilder buttonDataBuilder = this.dataBuilder;
        if (buttonDataBuilder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBuilder");
            buttonDataBuilder = null;
        }
        String attaReportData = buttonDataBuilder.getAttaReportData();
        if (attaReportData != null && attaReportData.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(attaReportData);
            Object remove = jSONObject.remove("show_operId");
            String str2 = "";
            if (remove == null || (str = remove.toString()) == null) {
                str = "";
            }
            Object remove2 = jSONObject.remove("click_operId");
            if (remove2 != null && (obj = remove2.toString()) != null) {
                str2 = obj;
            }
            if (isClick) {
                str = str2;
            }
            jSONObject.put(WadlReportBuilder.TableElem.OPER_ID, str);
            return jSONObject;
        } catch (JSONException e16) {
            QLog.e("wadl_distribute_DistributeButtonControl", 1, "buildFinalAttaReportData: parse failed, rawData=" + attaReportData + ", exception: ", e16);
            return null;
        }
    }

    private final String x() {
        if (((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).checkPermission(this.context)) {
            return "1";
        }
        return "2";
    }

    private final String y() {
        if (this.downloadInfo != null) {
            return "3";
        }
        return z(this.buttonStatus.getFollowStatus(), this.buttonStatus.getSubscribeStatus());
    }

    private final void y0() {
        this.trpcService.removeListener(this.wadlTrpcListener);
    }

    private final String z(int followStatus, int subscribeStatus) {
        if (followStatus > 0) {
            return "1";
        }
        if (subscribeStatus != 3) {
            return "2";
        }
        return "3";
    }

    private final void z0() {
        WadlProxyServiceUtil.getProxyService().unRegisterWadlServiceCallBack(this.wadlListener);
    }

    public final void A0(@NotNull String buttonStatus) {
        Intrinsics.checkNotNullParameter(buttonStatus, "buttonStatus");
        JSONObject w3 = w(true);
        QLog.d("wadl_distribute_DistributeButtonControl", 1, "reportClickAtta currInstallChannel=" + this.currInstallChannel + " attaReportData=" + w3 + " gameInfo=" + this.gameInfo);
        if (w3 == null) {
            return;
        }
        new com.tencent.gamecenter.wadl.biz.entity.d().h("distribution_button_click").e(w3).k(Q()).r(U()).l(R()).j(1, String.valueOf(this.downloadType)).j(22, buttonStatus).j(4, this.currInstallChannel).j(11, String.valueOf(Z())).j(12, y()).j(14, x()).j(15, A()).j(25, "2").b();
    }

    public final void M0(@NotNull ButtonDataBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.dataBuilder = builder;
    }

    public final void S0(@NotNull String subscribeWay) {
        Intrinsics.checkNotNullParameter(subscribeWay, "subscribeWay");
        B0("205993", "20");
        if (Intrinsics.areEqual(subscribeWay, "1")) {
            A0("\u5173\u6ce8");
        } else if (Intrinsics.areEqual(subscribeWay, "0")) {
            A0("\u9884\u7ea6");
        }
        ButtonDataBuilder buttonDataBuilder = this.dataBuilder;
        if (buttonDataBuilder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBuilder");
            buttonDataBuilder = null;
        }
        IQQGameTrpcService iQQGameTrpcService = this.trpcService;
        iQQGameTrpcService.addListener(this.wadlTrpcListener);
        if (f0(buttonDataBuilder)) {
            H0(buttonDataBuilder, subscribeWay);
        } else {
            M(subscribeWay, iQQGameTrpcService);
        }
    }

    public final void U0() {
        if (!B()) {
            return;
        }
        ButtonDataBuilder buttonDataBuilder = this.dataBuilder;
        ButtonDataBuilder buttonDataBuilder2 = null;
        if (buttonDataBuilder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBuilder");
            buttonDataBuilder = null;
        }
        QLog.i("wadl_distribute_DistributeButtonControl", 1, "update from " + buttonDataBuilder.getBusinessChannel());
        WadlProxyServiceUtil.getProxyService().registerWadlServiceCallBack(this.wadlListener);
        J0();
        ButtonDataBuilder buttonDataBuilder3 = this.dataBuilder;
        if (buttonDataBuilder3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBuilder");
        } else {
            buttonDataBuilder2 = buttonDataBuilder3;
        }
        X0(buttonDataBuilder2.getAppId(), 0, 0);
        v0();
        u0();
    }

    /* renamed from: V, reason: from getter */
    public final float getProgress() {
        return this.progress;
    }

    @NotNull
    /* renamed from: X, reason: from getter */
    public final ButtonStatus getButtonStatus() {
        return this.buttonStatus;
    }

    public final void Y0(int followStatus, int subscribeStatus) {
        if (!B()) {
            return;
        }
        ButtonDataBuilder buttonDataBuilder = this.dataBuilder;
        ButtonDataBuilder buttonDataBuilder2 = null;
        if (buttonDataBuilder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBuilder");
            buttonDataBuilder = null;
        }
        QLog.i("wadl_distribute_DistributeButtonControl", 1, "updateWithInitStatus from " + buttonDataBuilder.getBusinessChannel());
        WadlProxyServiceUtil.getProxyService().registerWadlServiceCallBack(this.wadlListener);
        J0();
        ButtonDataBuilder buttonDataBuilder3 = this.dataBuilder;
        if (buttonDataBuilder3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBuilder");
        } else {
            buttonDataBuilder2 = buttonDataBuilder3;
        }
        X0(buttonDataBuilder2.getAppId(), followStatus, subscribeStatus);
        v0();
        u0();
    }

    public final boolean e0(@Nullable String appId) {
        boolean z16;
        if (appId != null && appId.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        ButtonDataBuilder buttonDataBuilder = this.dataBuilder;
        if (buttonDataBuilder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataBuilder");
            buttonDataBuilder = null;
        }
        if (!Intrinsics.areEqual(appId, buttonDataBuilder.getAppId())) {
            return false;
        }
        return true;
    }

    public final void k0(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        synchronized (this) {
            Iterator<IButtonEventListener> it = this.eventListeners.iterator();
            while (it.hasNext()) {
                it.next().onClick(view);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void l0() {
        K0();
        L0();
    }

    public final void m0() {
        y0();
        z0();
    }

    public final void n0(int taskStatus) {
        boolean z16;
        if (!B()) {
            return;
        }
        JSONObject jSONObject = ((IQQGameSwitchApi) QRoute.api(IQQGameSwitchApi.class)).getJSONObject(IQQGameSwitchApi.SWITCH_KEY_DOWNLOAD_CONFIG);
        boolean z17 = false;
        if (jSONObject != null && jSONObject.optInt("actionType") == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            ((IQQGameHelper) QRoute.api(IQQGameHelper.class)).enterGameCenter(DistributeConstants.GAME_CENTER_URL);
            QLog.e("wadl_distribute_DistributeButtonControl", 1, "[onGameOnlineClick] go to game center");
            return;
        }
        QLog.d("wadl_distribute_DistributeButtonControl", 1, "[onGameOnlineClick] downloadType=" + this.downloadType);
        int i3 = this.downloadType;
        if (i3 == 3 || i3 == 4) {
            z17 = true;
        }
        JSONObject jSONObject2 = null;
        if (taskStatus != 0) {
            if (taskStatus != 2) {
                if (taskStatus != 9) {
                    if (taskStatus != 100) {
                        if (taskStatus != 4) {
                            if (taskStatus != 5) {
                                if (taskStatus != 6) {
                                    if (taskStatus != 7 && taskStatus != 12) {
                                        if (taskStatus != 13) {
                                            QLog.e("wadl_distribute_DistributeButtonControl", 2, " [onGameOnlineClick]other taskStatus:" + taskStatus);
                                            T0();
                                            return;
                                        }
                                    }
                                } else {
                                    I();
                                    if (z17) {
                                        A0("\u66f4\u65b0\u5b89\u88c5");
                                        return;
                                    } else {
                                        A0("\u4e0b\u8f7d\u5b89\u88c5");
                                        return;
                                    }
                                }
                            } else {
                                if (C(jSONObject)) {
                                    return;
                                }
                                L();
                                if (z17) {
                                    A0("\u7ee7\u7eed\u66f4\u65b0");
                                    return;
                                } else {
                                    A0("\u7ee7\u7eed\u4e0b\u8f7d");
                                    return;
                                }
                            }
                        }
                    } else {
                        if (C(jSONObject)) {
                            return;
                        }
                        if (jSONObject != null) {
                            jSONObject2 = jSONObject.optJSONObject(IQQGameSwitchApi.PARAMS_KEY_HIPPY_INFO);
                        }
                        H(jSONObject2, 12, "manual_update");
                        B0("205991", "20");
                        A0("\u66f4\u65b0");
                        return;
                    }
                } else {
                    J();
                    B0("205992", "20");
                    A0("\u542f\u52a8");
                    return;
                }
            }
            K();
            if (z17) {
                A0("\u6682\u505c\u66f4\u65b0");
                return;
            } else {
                A0("\u6682\u505c\u4e0b\u8f7d");
                return;
            }
        }
        if (C(jSONObject)) {
            return;
        }
        if (jSONObject != null) {
            jSONObject2 = jSONObject.optJSONObject(IQQGameSwitchApi.PARAMS_KEY_HIPPY_INFO);
        }
        H(jSONObject2, 2, "");
        B0("205991", "20");
        if (z17) {
            A0("\u66f4\u65b0");
        } else {
            A0("\u4e0b\u8f7d");
        }
    }

    public final void v(@NotNull IButtonEventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this) {
            if (!this.eventListeners.contains(listener)) {
                this.eventListeners.add(listener);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void w0(@NotNull IButtonEventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (this) {
            if (this.eventListeners.contains(listener)) {
                this.eventListeners.remove(listener);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void x0() {
        synchronized (this) {
            this.eventListeners.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\b\u0002\u0018\u00002\u00020\u0001B/\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0000J\b\u0010\u0006\u001a\u00020\u0005H\u0016R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0013\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000fR\u0017\u0010\u0016\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u000f\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/gamecenter/wadl/distribute/contorller/DistributeButtonController$b;", "", "other", "", "a", "", "toString", "Ljava/lang/String;", "getAppId", "()Ljava/lang/String;", "appId", "", "b", "I", "getFollowStatus", "()I", "followStatus", "c", "getSubscribeStatus", "subscribeStatus", "d", "getDownloadStatus", VirtualAppProxy.KEY_DOWNLOAD_STATUS, "<init>", "(Ljava/lang/String;III)V", "qqgamedownloader-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.gamecenter.wadl.distribute.contorller.DistributeButtonController$b, reason: from toString */
    /* loaded from: classes6.dex */
    public static final class ExposeReportRecord {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String appId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int followStatus;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int subscribeStatus;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int downloadStatus;

        public ExposeReportRecord(@Nullable String str, int i3, int i16, int i17) {
            this.appId = str;
            this.followStatus = i3;
            this.subscribeStatus = i16;
            this.downloadStatus = i17;
        }

        public final boolean a(@Nullable ExposeReportRecord other) {
            if (other == null || !Intrinsics.areEqual(other.appId, this.appId) || other.followStatus != this.followStatus || other.subscribeStatus != this.subscribeStatus || other.downloadStatus != this.downloadStatus) {
                return false;
            }
            return true;
        }

        @NotNull
        public String toString() {
            return "ExposeReportRecord(appId=" + this.appId + ", followStatus=" + this.followStatus + ", subscribeStatus=" + this.subscribeStatus + ", downloadStatus=" + this.downloadStatus + ")";
        }

        public /* synthetic */ ExposeReportRecord(String str, int i3, int i16, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i18 & 2) != 0 ? -1 : i3, (i18 & 4) != 0 ? -1 : i16, (i18 & 8) != 0 ? -1 : i17);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J$\u0010\t\u001a\u00020\u00042\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0007H\u0016J$\u0010\n\u001a\u00020\u00042\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0007H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/gamecenter/wadl/distribute/contorller/DistributeButtonController$c", "Lcom/tencent/gamecenter/wadl/biz/listener/WadlProxyServiceCallBackInterface;", "Lcom/tencent/gamecenter/wadl/biz/entity/WadlResult;", "wadlResult", "", "onWadlTaskStatusChanged", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "wadlResults", "onQueryCallback", "onQueryCallbackVia", "qqgamedownloader-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class c implements WadlProxyServiceCallBackInterface {
        c() {
        }

        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface
        public void onQueryCallback(@Nullable ArrayList<WadlResult> wadlResults) {
            WadlResult wadlResult;
            DistributeButtonController distributeButtonController = DistributeButtonController.this;
            distributeButtonController.currInstallChannel = GameCenterUtil.getChannelId(distributeButtonController.U());
            if (wadlResults != null && wadlResults.size() > 0) {
                Iterator<WadlResult> it = wadlResults.iterator();
                while (it.hasNext()) {
                    wadlResult = it.next();
                    DistributeButtonController distributeButtonController2 = DistributeButtonController.this;
                    Intrinsics.checkNotNullExpressionValue(wadlResult, "wadlResult");
                    if (distributeButtonController2.V0(wadlResult)) {
                        break;
                    }
                }
            } else {
                QLog.d("wadl_distribute_DistributeButtonControl", 1, "[onQueryCallback] wadlResults is empty");
            }
            wadlResult = null;
            DistributeButtonController distributeButtonController3 = DistributeButtonController.this;
            distributeButtonController3.D0(wadlResult, distributeButtonController3.buttonStatus.getDownloadTaskStatus());
        }

        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface
        public void onWadlTaskStatusChanged(@Nullable WadlResult wadlResult) {
            if (wadlResult != null) {
                DistributeButtonController.this.V0(wadlResult);
            }
        }

        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlProxyServiceCallBackInterface
        public void onQueryCallbackVia(@Nullable ArrayList<WadlResult> wadlResults) {
        }
    }
}

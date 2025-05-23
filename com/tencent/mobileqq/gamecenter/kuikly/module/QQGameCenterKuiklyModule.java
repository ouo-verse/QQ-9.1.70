package com.tencent.mobileqq.gamecenter.kuikly.module;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.tg.rewardAD.RewardDialogContentViewHolder;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ark.ark;
import com.tencent.common.app.AppInterface;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.hippy.qq.api.IHippyUpdate;
import com.tencent.hippy.qq.utils.HippyUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.api.IGameQQPlayerUtilApi;
import com.tencent.mobileqq.gamecenter.api.ITempApi;
import com.tencent.mobileqq.gamecenter.api.IYunGameConstant;
import com.tencent.mobileqq.gamecenter.api.IYunGameManagerService;
import com.tencent.mobileqq.gamecenter.data.GameInfo;
import com.tencent.mobileqq.gamecenter.protocols.GameCenterUnissoHandler;
import com.tencent.mobileqq.gamecenter.trpcprotocol.SgamePartnerSvr$OpenAIORsp;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.springhb.api.ISpringHbTempApi;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.widget.media.live.TXJSAdapterConstants;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.aa;
import com.tencent.qqnt.kernel.nativeinterface.AnchorPointContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactListChangedInfo;
import com.tencent.thumbplayer.report.reportv1.TPReportParams;
import com.tencent.turingfd.sdk.xq.ITuringDID;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00152\u00020\u0001:\u0001pB\u0007\u00a2\u0006\u0004\bn\u0010oJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J?\u0010\r\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0002J5\u0010\u000e\u001a\u00020\u00022+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0002J5\u0010\u000f\u001a\u00020\u00022+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0002J\u0012\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J5\u0010\u0013\u001a\u00020\u00022+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0002J\u0012\u0010\u0014\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J5\u0010\u0015\u001a\u00020\u00022+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0002J5\u0010\u0016\u001a\u00020\u00022+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0002J?\u0010\u0017\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0002J?\u0010\u0018\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0002J?\u0010\u0019\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0002J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u001aH\u0002J\u0012\u0010\u001e\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u001f\u001a\u00020\u0002H\u0002J5\u0010 \u001a\u00020\u00022+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0002J?\u0010!\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0002J\b\u0010\"\u001a\u00020\u0002H\u0002J\u0012\u0010#\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010$\u001a\u00020\u0004H\u0002J?\u0010%\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0002JO\u0010)\u001a\u00020\u00022+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\u0004\u0018\u0001`\u000b2\u0006\u0010\n\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\b\u0010(\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010+\u001a\u00020*H\u0002J?\u0010,\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0002J?\u0010-\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00072+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0002JI\u00100\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u00010\u001a2+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0002JI\u00101\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u00010\u001a2+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0002J5\u00102\u001a\u00020&2+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0002J\u0012\u00105\u001a\u0004\u0018\u00010\u001a2\u0006\u00104\u001a\u000203H\u0002J\"\u00109\u001a\u00020\u00022\b\u00106\u001a\u0004\u0018\u0001032\u0006\u00107\u001a\u00020*2\u0006\u00108\u001a\u00020*H\u0002J\b\u0010:\u001a\u00020\u0002H\u0002J\u0010\u0010<\u001a\u00020\u00022\u0006\u0010;\u001a\u000203H\u0002J\b\u0010=\u001a\u00020\u0002H\u0002J$\u0010?\u001a\u00020\u00022\b\u0010>\u001a\u0004\u0018\u00010\u00042\u0006\u0010'\u001a\u00020&2\b\u0010(\u001a\u0004\u0018\u00010\u0004H\u0002J7\u0010@\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\u0004\u0018\u0001`\u000b2\b\u0010>\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010D\u001a\u00020\u00022\u000e\u0010C\u001a\n\u0012\u0004\u0012\u00020B\u0018\u00010AH\u0002JI\u0010F\u001a\u0004\u0018\u00010\u00072\u0006\u0010E\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00072+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0016J=\u0010G\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bJ\u0012\u0010I\u001a\u00020\u00022\b\u0010H\u001a\u0004\u0018\u000103H\u0004J\u001a\u0010K\u001a\u00020\u00022\b\u0010>\u001a\u0004\u0018\u00010\u00042\b\u0010J\u001a\u0004\u0018\u00010\u0004J\b\u0010L\u001a\u00020\u0002H\u0016R\u0016\u0010O\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NRv\u0010T\u001ab\u0012\u0004\u0012\u00020\u0004\u0012#\u0012!\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00060Pj3\u0012\u0004\u0012\u00020\u0004\u0012)\u0012'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006j\u0004\u0018\u0001`\u000b`Q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010X\u001a\u00020U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0018\u0010\\\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010`\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0018\u0010b\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010_R\u0018\u0010d\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010_R\u0018\u0010g\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010fR\"\u0010j\u001a\u000e\u0012\u0004\u0012\u00020h\u0012\u0004\u0012\u00020\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010iR\u0016\u0010m\u001a\u00020k8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010l\u00a8\u0006q"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/kuikly/module/QQGameCenterKuiklyModule;", "Li01/e;", "", "a0", "", "params", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "Z", "X", "n0", "Lcom/tencent/mobileqq/gamecenter/api/IYunGameConstant$GameStatusInfo;", "info", "f0", "I", "V", "G", "W", "j0", "l0", "b0", "Lorg/json/JSONObject;", "Lcom/tencent/mobileqq/gamecenter/data/GameInfo;", "U", "oaid", "e0", "y", UserInfo.SEX_FEMALE, "i0", "J", "h0", "E", "D", "", "ret", "msg", HippyTKDListViewAdapter.X, "", "H", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "O", "Lcom/tencent/mobileqq/gamecenter/trpcprotocol/SgamePartnerSvr$OpenAIORsp;", WadlProxyConsts.EXT_JSON, ExifInterface.LATITUDE_SOUTH, BdhLogUtil.LogTag.Tag_Req, "d0", "Landroid/os/Bundle;", "rsp", "T", "reqBundle", "withoutTimeout", "toast", "g0", "K", "pushmsg", "M", "L", "callbackId", "v", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "Lcom/tencent/mobileqq/gamecenter/data/n;", "list", "o0", "method", "call", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "resp", "N", ark.ARKMETADATA_JSON, "w", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "d", "Landroid/os/Bundle;", "mReqBundle", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "e", "Ljava/util/HashMap;", "mapCallbacks", "Ljava/util/concurrent/atomic/AtomicInteger;", "f", "Ljava/util/concurrent/atomic/AtomicInteger;", "mCallbackIdCounter", "Lcom/tencent/mobileqq/gamecenter/api/IGameMsgManagerService$a;", tl.h.F, "Lcom/tencent/mobileqq/gamecenter/api/IGameMsgManagerService$a;", "mPartnerSessionListener", "Lcom/tencent/mobileqq/gamecenter/api/IYunGameManagerService$a;", "i", "Lcom/tencent/mobileqq/gamecenter/api/IYunGameManagerService$a;", "mStartCallBack", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mRestartCallBack", BdhLogUtil.LogTag.Tag_Conn, "mStopCallBack", "Lcom/tencent/mobileqq/gamecenter/api/IYunGameManagerService$b;", "Lcom/tencent/mobileqq/gamecenter/api/IYunGameManagerService$b;", "mGameStateListener", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactListChangedInfo;", "Lkotlin/jvm/functions/Function1;", "mRecentContactListener", "Lcom/tencent/mobileqq/emosm/t;", "Lcom/tencent/mobileqq/emosm/t;", "mOnRemoteResp", "<init>", "()V", "a", "qq-gamecenter-msg-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public class QQGameCenterKuiklyModule extends i01.e {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private IYunGameManagerService.a mStopCallBack;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private IYunGameManagerService.b mGameStateListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IGameMsgManagerService.a mPartnerSessionListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IYunGameManagerService.a mStartCallBack;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IYunGameManagerService.a mRestartCallBack;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Bundle mReqBundle = new Bundle();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private HashMap<String, Function1<Object, Unit>> mapCallbacks = new HashMap<>();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicInteger mCallbackIdCounter = new AtomicInteger(0);

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private Function1<? super RecentContactListChangedInfo, Unit> mRecentContactListener = new Function1<RecentContactListChangedInfo, Unit>() { // from class: com.tencent.mobileqq.gamecenter.kuikly.module.QQGameCenterKuiklyModule$mRecentContactListener$1
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull RecentContactListChangedInfo it) {
            Intrinsics.checkNotNullParameter(it, "it");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RecentContactListChangedInfo recentContactListChangedInfo) {
            invoke2(recentContactListChangedInfo);
            return Unit.INSTANCE;
        }
    };

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.emosm.t mOnRemoteResp = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/gamecenter/kuikly/module/QQGameCenterKuiklyModule$b", "Lcom/tencent/mobileqq/emosm/t;", "Landroid/os/Bundle;", "resp", "", "onResponse", "onBindedToClient", "pushmsg", "onPushMsg", "onDisconnectWithService", "qq-gamecenter-msg-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b extends com.tencent.mobileqq.emosm.t {
        b() {
        }

        @Override // com.tencent.mobileqq.emosm.t
        public void onBindedToClient() {
            QQGameCenterKuiklyModule.this.K();
        }

        @Override // com.tencent.mobileqq.emosm.t
        public void onDisconnectWithService() {
            QQGameCenterKuiklyModule.this.L();
        }

        @Override // com.tencent.mobileqq.emosm.t
        public void onPushMsg(@NotNull Bundle pushmsg) {
            Intrinsics.checkNotNullParameter(pushmsg, "pushmsg");
            QQGameCenterKuiklyModule.this.M(pushmsg);
        }

        @Override // com.tencent.mobileqq.emosm.t
        public void onResponse(@NotNull Bundle resp) {
            Intrinsics.checkNotNullParameter(resp, "resp");
            QQGameCenterKuiklyModule.this.N(resp);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0016J.\u0010\u000e\u001a\u00020\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/gamecenter/kuikly/module/QQGameCenterKuiklyModule$c", "Lcom/tencent/gamecenter/wadl/biz/listener/WadlTrpcListener;", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getFilterCmds", "Landroid/content/Intent;", Const.BUNDLE_KEY_REQUEST, "cmd", "", "ret", "Lcom/tencent/gamecenter/wadl/biz/entity/TrpcProxy$TrpcInovkeRsp;", "rsp", "", "onTrpcRsp", "qq-gamecenter-msg-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c implements WadlTrpcListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ JSONObject f212104e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f212105f;

        c(JSONObject jSONObject, Function1<Object, Unit> function1) {
            this.f212104e = jSONObject;
            this.f212105f = function1;
        }

        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
        @NotNull
        public HashSet<String> getFilterCmds() {
            HashSet<String> hashSet = new HashSet<>();
            hashSet.add("/v1/1694");
            return hashSet;
        }

        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
        public void onTrpcRsp(@Nullable Intent request, @Nullable String cmd, long ret, @Nullable TrpcProxy.TrpcInovkeRsp rsp) {
            try {
                if (QLog.isColorLevel()) {
                    QLog.d("QQGameCenterKuiklyModule", 1, "[openQQPlayerAio] onTrpcRsp cmd:" + cmd + " ret:" + ret);
                }
                if (request == null) {
                    QLog.e("QQGameCenterKuiklyModule", 1, "[openQQPlayerAio] request is null.");
                    return;
                }
                if (ret == 0 && rsp != null && rsp.data.has()) {
                    SgamePartnerSvr$OpenAIORsp sgamePartnerSvr$OpenAIORsp = new SgamePartnerSvr$OpenAIORsp();
                    sgamePartnerSvr$OpenAIORsp.mergeFrom(rsp.data.get().toByteArray());
                    if (QQGameCenterKuiklyModule.this.H()) {
                        QQGameCenterKuiklyModule.this.S(sgamePartnerSvr$OpenAIORsp, this.f212104e, this.f212105f);
                        return;
                    } else {
                        QQGameCenterKuiklyModule.this.R(sgamePartnerSvr$OpenAIORsp, this.f212104e, this.f212105f);
                        return;
                    }
                }
                QLog.e("QQGameCenterKuiklyModule", 1, "[openQQPlayerAio] request is null.");
            } catch (Exception e16) {
                QLog.d("QQGameCenterKuiklyModule", 1, "[openQQPlayerAio] e: " + e16);
            }
        }
    }

    private final void A(String params, final Function1<Object, Unit> callback) {
        QLog.i("QQGameCenterKuiklyModule", 1, "[getPartnerSessionList] start");
        if (TextUtils.isEmpty(params)) {
            if (callback != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ret", "-1");
                jSONObject.put("msg", "param err");
                callback.invoke(jSONObject);
                return;
            }
            return;
        }
        try {
            final int optInt = new JSONObject(params).optInt("size", 20);
            AppInterface appInterface = HippyUtils.getAppInterface();
            if (appInterface == null) {
                if (callback != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("ret", "-1");
                    jSONObject2.put("msg", "app is null");
                    callback.invoke(jSONObject2);
                    return;
                }
                return;
            }
            IGameMsgManagerService iGameMsgManagerService = (IGameMsgManagerService) appInterface.getRuntimeService(IGameMsgManagerService.class, "");
            if (this.mPartnerSessionListener == null) {
                IGameMsgManagerService.a aVar = new IGameMsgManagerService.a() { // from class: com.tencent.mobileqq.gamecenter.kuikly.module.g
                    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService.a
                    public final void a(List list) {
                        QQGameCenterKuiklyModule.B(QQGameCenterKuiklyModule.this, list);
                    }
                };
                this.mPartnerSessionListener = aVar;
                if (iGameMsgManagerService != null) {
                    iGameMsgManagerService.addRecentPartnerListener(aVar);
                }
            }
            IRuntimeService runtimeService = appInterface.getRuntimeService(IKernelService.class, "");
            Intrinsics.checkNotNull(runtimeService);
            aa recentContactService = ((IKernelService) runtimeService).getRecentContactService();
            if (recentContactService == null) {
                QLog.d("QQGameCenterKuiklyModule", 1, "[getPartnerSessionList] recentContactService == null");
                return;
            }
            IRuntimeService runtimeService2 = appInterface.getRuntimeService(IKernelService.class, "");
            Intrinsics.checkNotNull(runtimeService2);
            aa recentContactService2 = ((IKernelService) runtimeService2).getRecentContactService();
            if (recentContactService2 != null) {
                recentContactService2.m(4, this.mRecentContactListener);
            }
            Function1<RecentContactListChangedInfo, Unit> function1 = new Function1<RecentContactListChangedInfo, Unit>() { // from class: com.tencent.mobileqq.gamecenter.kuikly.module.QQGameCenterKuiklyModule$getPartnerSessionList$4
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(RecentContactListChangedInfo recentContactListChangedInfo) {
                    invoke2(recentContactListChangedInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull RecentContactListChangedInfo it) {
                    IKernelService iKernelService;
                    aa recentContactService3;
                    Function1<? super RecentContactListChangedInfo, Unit> function12;
                    Intrinsics.checkNotNullParameter(it, "it");
                    try {
                        QLog.i("QQGameCenterKuiklyModule", 1, "[getPartnerSessionList] get recentContactList.");
                        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                        IGameMsgManagerService iGameMsgManagerService2 = peekAppRuntime != null ? (IGameMsgManagerService) peekAppRuntime.getRuntimeService(IGameMsgManagerService.class, "") : null;
                        List<com.tencent.mobileqq.gamecenter.data.n> recentPartnerList = iGameMsgManagerService2 != null ? iGameMsgManagerService2.getRecentPartnerList() : null;
                        JSONArray jSONArray = new JSONArray();
                        if (recentPartnerList != null && recentPartnerList.size() > 0) {
                            int size = recentPartnerList.size();
                            for (int i3 = 0; i3 < size && i3 <= optInt - 1; i3++) {
                                com.tencent.mobileqq.gamecenter.data.n nVar = recentPartnerList.get(i3);
                                Iterator<RecentContactInfo> it5 = it.changedList.iterator();
                                while (true) {
                                    if (it5.hasNext()) {
                                        RecentContactInfo next = it5.next();
                                        if (nVar.m(next)) {
                                            nVar.A((int) next.unreadCnt);
                                            nVar.u(next.msgTime);
                                            if (QLog.isColorLevel()) {
                                                QLog.d("QQGameCenterKuiklyModule", 1, "[getPartnerSessionList] match contact info, set unread: " + nVar.getUnreadCnt() + ", lastTime:" + nVar.getLastMsgTime());
                                            }
                                        }
                                    }
                                }
                                jSONArray.mo162put(nVar.B());
                            }
                        }
                        if (peekAppRuntime != null && (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")) != null && (recentContactService3 = iKernelService.getRecentContactService()) != null) {
                            function12 = this.mRecentContactListener;
                            recentContactService3.m(4, function12);
                        }
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("list", jSONArray);
                        QLog.d("QQGameCenterKuiklyModule", 1, "[getPartnerSessionList] return size: " + jSONArray.length());
                        Function1<Object, Unit> function13 = callback;
                        if (function13 != null) {
                            function13.invoke(jSONObject3.toString());
                        }
                    } catch (Exception e16) {
                        Function1<Object, Unit> function14 = callback;
                        if (function14 != null) {
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put("ret", "-2");
                            jSONObject4.put("msg", String.valueOf(e16));
                            function14.invoke(jSONObject4);
                        }
                    }
                }
            };
            this.mRecentContactListener = function1;
            recentContactService.g0(4, function1);
            recentContactService.v(new AnchorPointContactInfo(), true, 4, 200, new IOperateCallback() { // from class: com.tencent.mobileqq.gamecenter.kuikly.module.h
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    QQGameCenterKuiklyModule.C(i3, str);
                }
            });
        } catch (Exception e16) {
            if (callback != null) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("ret", "-1");
                jSONObject3.put("msg", String.valueOf(e16));
                callback.invoke(jSONObject3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(QQGameCenterKuiklyModule this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.o0(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(int i3, String errMsg) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        QLog.i("QQGameCenterKuiklyModule", 1, "[getPartnerSessionList] result:" + i3 + ", errMsg:" + errMsg);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x007a A[Catch: all -> 0x00dc, TryCatch #1 {all -> 0x00dc, blocks: (B:6:0x001a, B:11:0x006f, B:15:0x007a, B:17:0x008c, B:18:0x0094, B:20:0x009a, B:26:0x00ab, B:27:0x00bb, B:29:0x00ce, B:35:0x00b7), top: B:5:0x001a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void D(String params, Function1<Object, Unit> callback) {
        boolean z16;
        List emptyList;
        boolean z17;
        boolean contains$default;
        if (TextUtils.isEmpty(params)) {
            x(callback, 0, -5, "param error");
        }
        JSONObject jSONObject = new JSONObject();
        try {
            MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(getActivity(), "common_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(activity, IYunGameConstant.FILE_COMMON)");
            String string = fromV2.getString(IYunGameConstant.KEY_SCREEN_CFG + new JSONObject(params).optString(VirtualAppProxy.KEY_GAME_ID), "");
            QLog.d("QQGameCenterKuiklyModule", 2, "[getScreenOrientation] " + string);
            if (!StringUtil.isEmpty(string)) {
                if (string != null) {
                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) string, (CharSequence) ",", false, 2, (Object) null);
                    if (contains$default) {
                        z16 = true;
                        if (z16) {
                            Intrinsics.checkNotNull(string);
                            List<String> split = new Regex(",").split(string, 0);
                            if (!split.isEmpty()) {
                                ListIterator<String> listIterator = split.listIterator(split.size());
                                while (listIterator.hasPrevious()) {
                                    if (listIterator.previous().length() == 0) {
                                        z17 = true;
                                    } else {
                                        z17 = false;
                                    }
                                    if (!z17) {
                                        emptyList = CollectionsKt___CollectionsKt.take(split, listIterator.nextIndex() + 1);
                                        break;
                                    }
                                }
                            }
                            emptyList = CollectionsKt__CollectionsKt.emptyList();
                            Object[] array = emptyList.toArray(new String[0]);
                            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                            String[] strArr = (String[]) array;
                            if (strArr.length == 2) {
                                jSONObject.put(VirtualAppProxy.KEY_GAME_ID, strArr[0]);
                                jSONObject.put(RewardDialogContentViewHolder.Key.SCREEN_ORIENTATION, strArr[1]);
                            }
                        }
                    }
                }
                z16 = false;
                if (z16) {
                }
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    private final String E() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("isEnabled", ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).isUseCanaryEnv());
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026Env)\n        }.toString()");
        return jSONObject2;
    }

    private final void F(Function1<Object, Unit> callback) {
        try {
            MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(getActivity(), "common_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(activity, IYunGameConstant.FILE_COMMON)");
            String string = fromV2.getString(IYunGameConstant.KEY_QUALITY_CFG, "");
            QLog.d("YunGameActivity", 2, "[getYunGameClaritys] " + string);
            x(callback, 0, 0, string);
        } catch (Exception e16) {
            QLog.e("QQGameCenterKuiklyModule", 1, "[getYunGameClaritys] " + e16);
        }
    }

    private final void G(Function1<Object, Unit> callback) {
        QLog.i("QQGameCenterKuiklyModule", 1, "[installYunGameSDK], params:");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean H() {
        if (MobileQQ.sProcessId == 1) {
            return true;
        }
        return false;
    }

    private final void I(Function1<Object, Unit> callback) {
        QLog.d("QQGameCenterKuiklyModule", 2, "[isYunGameInstalled]");
        try {
            x(callback, 0, 0, "sdk installed.");
        } catch (Exception e16) {
            QLog.e("QQGameCenterKuiklyModule", 1, "[isYunGameInstalled] " + e16);
        }
    }

    private final void J() {
        QLog.i("QQGameCenterKuiklyModule", 1, "[notifyUserFeedback]");
        try {
            IRuntimeService runtimeService = HippyUtils.getAppInterface().getRuntimeService(IYunGameManagerService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "getAppInterface().getRun\u2026nt.MAIN\n                )");
            ((IYunGameManagerService) runtimeService).notifyUserFeedback();
        } catch (Exception e16) {
            QLog.e("QQGameCenterKuiklyModule", 1, "[notifyUserFeedback] " + e16);
        }
    }

    private final void O(Object params, Function1<Object, Unit> callback) {
        String obj;
        AppInterface appInterface;
        IGameMsgManagerService iGameMsgManagerService;
        if (params != null && (obj = params.toString()) != null) {
            try {
                boolean optBoolean = new JSONObject(obj).optBoolean("selectGamePartner", false);
                if (optBoolean && H() && (appInterface = HippyUtils.getAppInterface()) != null && (iGameMsgManagerService = (IGameMsgManagerService) appInterface.getRuntimeService(IGameMsgManagerService.class, "")) != null) {
                    iGameMsgManagerService.getRecentPartnerList();
                }
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final int i3 = optBoolean ? 1 : 0;
                uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.kuikly.module.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        QQGameCenterKuiklyModule.P(QQGameCenterKuiklyModule.this, i3);
                    }
                });
            } catch (JSONException e16) {
                QLog.e("QQGameCenterKuiklyModule", 1, "openGameMsgBox e:", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(QQGameCenterKuiklyModule this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = this$0.getActivity();
        if (activity != null && !activity.isFinishing()) {
            ((ITempApi) QRoute.api(ITempApi.class)).openGameMsgBox(activity, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R(SgamePartnerSvr$OpenAIORsp params, JSONObject extJson, Function1<Object, Unit> callback) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        long j3;
        PBStringField pBStringField;
        PBStringField pBStringField2;
        String str7;
        PBStringField pBStringField3;
        PBStringField pBStringField4;
        PBStringField pBStringField5;
        PBStringField pBStringField6;
        PBStringField pBStringField7;
        PBStringField pBStringField8;
        int d06 = d0(callback);
        this.mReqBundle.clear();
        Bundle bundle = this.mReqBundle;
        String str8 = null;
        if (params != null && (pBStringField8 = params.from_role_id) != null) {
            str = pBStringField8.get();
        } else {
            str = null;
        }
        bundle.putString("fromRoleId", str);
        Bundle bundle2 = this.mReqBundle;
        if (params != null && (pBStringField7 = params.from_openid) != null) {
            str2 = pBStringField7.get();
        } else {
            str2 = null;
        }
        bundle2.putString("fromOpenId", str2);
        Bundle bundle3 = this.mReqBundle;
        if (params != null && (pBStringField6 = params.to_role_id) != null) {
            str3 = pBStringField6.get();
        } else {
            str3 = null;
        }
        bundle3.putString("toRoleId", str3);
        Bundle bundle4 = this.mReqBundle;
        if (params != null && (pBStringField5 = params.to_openid) != null) {
            str4 = pBStringField5.get();
        } else {
            str4 = null;
        }
        bundle4.putString("toOpenId", str4);
        Bundle bundle5 = this.mReqBundle;
        if (params != null && (pBStringField4 = params.from_tinyid) != null) {
            str5 = pBStringField4.get();
        } else {
            str5 = null;
        }
        bundle5.putString("fromTinyId", str5);
        Bundle bundle6 = this.mReqBundle;
        if (params != null && (pBStringField3 = params.to_tinyid) != null) {
            str6 = pBStringField3.get();
        } else {
            str6 = null;
        }
        bundle6.putString("toTinyId", str6);
        Bundle bundle7 = this.mReqBundle;
        if (params != null && (pBStringField2 = params.appid) != null && (str7 = pBStringField2.get()) != null) {
            j3 = Long.parseLong(str7);
        } else {
            j3 = 0;
        }
        bundle7.putLong("gameAppId", j3);
        this.mReqBundle.putInt("windowFlag", 0);
        this.mReqBundle.putString("topGrayText", "");
        Bundle bundle8 = this.mReqBundle;
        if (params != null && (pBStringField = params.sig) != null) {
            str8 = pBStringField.get();
        }
        bundle8.putString(PreloadTRTCPlayerParams.KEY_SIG, str8);
        this.mReqBundle.putInt("fromPage", 0);
        if (extJson != null) {
            this.mReqBundle.putString(WadlProxyConsts.EXT_JSON, extJson.toString());
        }
        Bundle a16 = com.tencent.mobileqq.emosm.a.a("ipc_cmd_gamecenter_open_qqplayer_aio", String.valueOf(d06), this.mOnRemoteResp.key, this.mReqBundle);
        Intrinsics.checkNotNullExpressionValue(a16, "makeIPCRequestPacket(\n  \u2026     mReqBundle\n        )");
        g0(a16, false, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S(SgamePartnerSvr$OpenAIORsp params, JSONObject extJson, Function1<Object, Unit> callback) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        long j3;
        String str8;
        PBStringField pBStringField;
        String str9;
        PBStringField pBStringField2;
        PBStringField pBStringField3;
        PBStringField pBStringField4;
        PBStringField pBStringField5;
        PBStringField pBStringField6;
        PBStringField pBStringField7;
        PBStringField pBStringField8;
        AppInterface appInterface = HippyUtils.getAppInterface();
        Intrinsics.checkNotNullExpressionValue(appInterface, "getAppInterface()");
        Context applicationContext = appInterface.getApp().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "appInterface.getApp().getApplicationContext()");
        String str10 = null;
        if (params != null && (pBStringField8 = params.from_role_id) != null) {
            str = pBStringField8.get();
        } else {
            str = null;
        }
        if (params != null && (pBStringField7 = params.from_openid) != null) {
            str2 = pBStringField7.get();
        } else {
            str2 = null;
        }
        if (params != null && (pBStringField6 = params.to_role_id) != null) {
            str3 = pBStringField6.get();
        } else {
            str3 = null;
        }
        if (params != null && (pBStringField5 = params.to_openid) != null) {
            str4 = pBStringField5.get();
        } else {
            str4 = null;
        }
        if (params != null && (pBStringField4 = params.from_tinyid) != null) {
            str5 = pBStringField4.get();
        } else {
            str5 = null;
        }
        if (params != null && (pBStringField3 = params.to_tinyid) != null) {
            str6 = pBStringField3.get();
        } else {
            str6 = null;
        }
        if (params != null && (pBStringField2 = params.sig) != null) {
            str7 = pBStringField2.get();
        } else {
            str7 = null;
        }
        if (params != null && (pBStringField = params.appid) != null && (str9 = pBStringField.get()) != null) {
            j3 = Long.parseLong(str9);
        } else {
            j3 = 0;
        }
        IGameQQPlayerUtilApi iGameQQPlayerUtilApi = (IGameQQPlayerUtilApi) QRoute.api(IGameQQPlayerUtilApi.class);
        if (extJson != null) {
            str10 = extJson.toString();
        }
        iGameQQPlayerUtilApi.openGameMsgAIO(appInterface, applicationContext, str, str2, str3, str4, "", str7, j3, str5, str6, 0, 0, str10);
        Bundle bundle = new Bundle();
        bundle.putInt("result", 0);
        JSONObject T = T(bundle);
        if (callback != null) {
            if (T == null || (str8 = T.toString()) == null) {
                str8 = "";
            }
            callback.invoke(str8);
        }
    }

    private final JSONObject T(Bundle rsp) {
        int i3;
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        try {
            i3 = rsp.getInt("result", -1);
            jSONObject = new JSONObject();
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            jSONObject.put("ret", i3);
            if (QLog.isColorLevel()) {
                QLog.d("QQGameCenterKuiklyModule", 2, "parseClickCommonSessionRsp ret:" + i3);
                return jSONObject;
            }
            return jSONObject;
        } catch (Throwable th6) {
            th = th6;
            jSONObject2 = jSONObject;
            QLog.d("QQGameCenterKuiklyModule", 1, "parseClickCommonSessionRsp error:" + th);
            return jSONObject2;
        }
    }

    private final GameInfo U(JSONObject params) {
        GameInfo gameInfo = new GameInfo();
        gameInfo.setGameId(params.optString(VirtualAppProxy.KEY_GAME_ID));
        gameInfo.setAppId(params.optString("appid"));
        gameInfo.setGameName(params.optString("gameName"));
        gameInfo.setConfigUrl(params.optString("configUrl"));
        gameInfo.setPlayType(params.optInt(TXJSAdapterConstants.PLAYER_KEY_PLAY_TYPE));
        gameInfo.setExtraInfo(params.optString("extraInfo"));
        gameInfo.setJumpUrl(params.optString(WadlProxyConsts.KEY_JUMP_URL));
        gameInfo.setIconUrl(params.optString("iconUrl"));
        gameInfo.setLoadingUrl(params.optString("loadingUrl"));
        gameInfo.setAutoLogin(params.optBoolean("autoLogin"));
        gameInfo.setGameData(params.optString("gameData"));
        gameInfo.setOaid(params.optString("oaid"));
        gameInfo.setDcEventReqCmd(params.optString("dcEventReqCmd"));
        gameInfo.setDcEventReqData(params.optString("dcEventReqData"));
        gameInfo.setReportChannelId(params.optString("reportChannelId"));
        gameInfo.setReportActId(params.optString("reportActId"));
        return gameInfo;
    }

    private final void V(String params) {
        try {
            QLog.i("QQGameCenterKuiklyModule", 1, "[preLoadYunGame], params: " + params);
            e0(new JSONObject(params).optString("oaid"));
            IRuntimeService runtimeService = HippyUtils.getAppInterface().getRuntimeService(IYunGameManagerService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "getAppInterface().getRun\u2026nt.MAIN\n                )");
            ((IYunGameManagerService) runtimeService).preLoadYunGame();
        } catch (Exception e16) {
            QLog.e("QQGameCenterKuiklyModule", 1, e16, new Object[0]);
        }
    }

    private final void W(Function1<Object, Unit> callback) {
        QLog.i("QQGameCenterKuiklyModule", 1, "[queryInstallProgress], params:");
        x(callback, 0, 100, "sdk installed.");
    }

    private final void X(Function1<Object, Unit> callback) {
        QLog.d("QQGameCenterKuiklyModule", 2, "[registerGameStatusListener]");
        try {
            IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IYunGameManagerService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService<IY\u2026nstant.MAIN\n            )");
            IYunGameManagerService.b bVar = new IYunGameManagerService.b() { // from class: com.tencent.mobileqq.gamecenter.kuikly.module.f
                @Override // com.tencent.mobileqq.gamecenter.api.IYunGameManagerService.b
                public final void onStateChange(IYunGameConstant.GameStatusInfo gameStatusInfo) {
                    QQGameCenterKuiklyModule.Y(QQGameCenterKuiklyModule.this, gameStatusInfo);
                }
            };
            this.mGameStateListener = bVar;
            ((IYunGameManagerService) runtimeService).addGameStateListener(bVar);
        } catch (Exception e16) {
            QLog.e("QQGameCenterKuiklyModule", 1, "[registerGameStatusListener] " + e16);
        }
        x(callback, 0, 0, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(QQGameCenterKuiklyModule this$0, IYunGameConstant.GameStatusInfo gameStatusInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f0(gameStatusInfo);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005e, code lost:
    
        r5.invoke(new org.json.JSONObject().toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006a, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void Z(String params, Function1<Object, Unit> callback) {
        if (TextUtils.isEmpty(params)) {
            if (callback != null) {
                callback.invoke(new JSONObject().toString());
                return;
            }
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(params);
            AppInterface appInterface = HippyUtils.getAppInterface();
            if (appInterface == null) {
                return;
            }
            File tabConfigFile = ((IHippyUpdate) QRoute.api(IHippyUpdate.class)).getTabConfigFile(appInterface.getCurrentUin(), jSONObject.optString("bundleName"));
            if (tabConfigFile != null && tabConfigFile.exists()) {
                String readFileContent = FileUtils.readFileContent(tabConfigFile);
                if (callback != null) {
                    if (readFileContent == null) {
                        readFileContent = new JSONObject().toString();
                        Intrinsics.checkNotNullExpressionValue(readFileContent, "JSONObject().toString()");
                    }
                    callback.invoke(readFileContent);
                }
            }
        } catch (Exception unused) {
            if (callback != null) {
                callback.invoke(new JSONObject().toString());
            }
        }
    }

    private final void a0() {
        ((ISpringHbTempApi) QRoute.api(ISpringHbTempApi.class)).requestSpringHBPreloadSource();
    }

    private final void b0(String params, final Function1<Object, Unit> callback) {
        if (TextUtils.isEmpty(params)) {
            x(callback, 0, -5, "param error");
            return;
        }
        try {
            QLog.i("QQGameCenterKuiklyModule", 1, "[restartYunGame], params:" + params);
            JSONObject jSONObject = new JSONObject(params);
            if (TextUtils.isEmpty(jSONObject.optString(VirtualAppProxy.KEY_GAME_ID))) {
                QLog.e("QQGameCenterKuiklyModule", 1, "[restartYunGame], params error:" + jSONObject);
                x(callback, 0, -5, "param error");
                return;
            }
            IRuntimeService runtimeService = HippyUtils.getAppInterface().getRuntimeService(IYunGameManagerService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "getAppInterface().getRun\u2026nt.MAIN\n                )");
            GameInfo U = U(jSONObject);
            IYunGameManagerService.a aVar = new IYunGameManagerService.a() { // from class: com.tencent.mobileqq.gamecenter.kuikly.module.k
                @Override // com.tencent.mobileqq.gamecenter.api.IYunGameManagerService.a
                public final void onResult(int i3, String str) {
                    QQGameCenterKuiklyModule.c0(QQGameCenterKuiklyModule.this, callback, i3, str);
                }
            };
            this.mRestartCallBack = aVar;
            ((IYunGameManagerService) runtimeService).restartYunGame(U, aVar);
        } catch (Exception e16) {
            QLog.e("QQGameCenterKuiklyModule", 1, e16, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(QQGameCenterKuiklyModule this$0, Function1 function1, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.x(function1, i3, i3, str);
    }

    private final int d0(Function1<Object, Unit> callback) {
        int incrementAndGet = this.mCallbackIdCounter.incrementAndGet();
        this.mapCallbacks.put(String.valueOf(incrementAndGet), callback);
        return incrementAndGet;
    }

    private final void e0(String oaid) {
        if (TextUtils.isEmpty(oaid)) {
            QLog.d("QQGameCenterKuiklyModule", 2, "[saveOaid], oaid is empty, get from truingSdk");
            ITuringDID c16 = com.tencent.mobileqq.turingfd.c.a().c(true);
            if (c16 != null) {
                oaid = c16.getAIDTicket();
            } else {
                oaid = null;
            }
        }
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(getActivity(), "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(activity, IYunGameConstant.FILE_COMMON)");
        fromV2.putString(IYunGameConstant.KEY_OAID_CFG, oaid);
        if (QLog.isColorLevel()) {
            QLog.d("QQGameCenterKuiklyModule", 2, "[saveOaid], oaid:" + oaid);
        }
    }

    private final void f0(IYunGameConstant.GameStatusInfo info) {
        com.tencent.kuikly.core.render.android.d O0;
        String str;
        HashMap hashMap = new HashMap();
        if (info != null) {
            hashMap.put("ret", String.valueOf(info.getStatus()));
            hashMap.put("index", String.valueOf(info.getIndex()));
            hashMap.put("total", String.valueOf(info.getTotal()));
            GameInfo gameInfo = info.getGameInfo();
            if (gameInfo == null || (str = gameInfo.getGameId()) == null) {
                str = "-1";
            }
            hashMap.put(VirtualAppProxy.KEY_GAME_ID, str);
            hashMap.put("msg", String.valueOf(info.getMsg()));
            QLog.i("QQGameCenterKuiklyModule", 1, "[sendGameStatus] gameData:" + hashMap);
        } else {
            QLog.e("QQGameCenterKuiklyModule", 1, "[sendGameStatus] info is null");
        }
        com.tencent.kuikly.core.render.android.a aVar = get_kuiklyRenderContext();
        if (aVar != null && (O0 = aVar.O0()) != null) {
            O0.d("gameStatusChange", hashMap);
        }
    }

    private final void g0(Bundle reqBundle, boolean withoutTimeout, boolean toast) {
        if (!((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded()) {
            QLog.e("", 1, "sendRemoteReq error ipc service not ready");
        } else if (withoutTimeout) {
            ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReqWithoutTimeout(reqBundle);
        } else {
            ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(reqBundle);
        }
    }

    private final void h0(String params) {
        boolean z16;
        if (params != null && params.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        try {
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).setUseCanaryEnv(new JSONObject(params).optBoolean("isEnabled", false));
        } catch (Exception e16) {
            QLog.e("QQGameCenterKuiklyModule", 2, "[setTrpcCanaryEnv] failed", e16);
        }
    }

    private final void i0(String params, Function1<Object, Unit> callback) {
        QLog.d("QQGameCenterKuiklyModule", 1, "[setYunGameClarity]");
        if (TextUtils.isEmpty(params)) {
            x(callback, -1, -5, "param err.");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(params);
            IRuntimeService runtimeService = HippyUtils.getAppInterface().getRuntimeService(IYunGameManagerService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "getAppInterface().getRun\u2026nt.MAIN\n                )");
            ((IYunGameManagerService) runtimeService).setYunGameClarity(jSONObject.optInt(TPReportParams.JSON_KEY_VAL));
            x(callback, 0, 0, "");
        } catch (Exception e16) {
            x(callback, 0, 0, e16.toString());
        }
    }

    private final void j0(String params, final Function1<Object, Unit> callback) {
        if (TextUtils.isEmpty(params)) {
            x(callback, 0, -5, "param error");
            return;
        }
        try {
            QLog.i("QQGameCenterKuiklyModule", 1, "[startYunGame], params:" + params);
            JSONObject jSONObject = new JSONObject(params);
            if (TextUtils.isEmpty(jSONObject.optString(VirtualAppProxy.KEY_GAME_ID))) {
                QLog.e("QQGameCenterKuiklyModule", 1, "[startYunGame], params error:" + jSONObject);
                x(callback, 0, -5, "param error");
                return;
            }
            IRuntimeService runtimeService = HippyUtils.getAppInterface().getRuntimeService(IYunGameManagerService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "getAppInterface().getRun\u2026nt.MAIN\n                )");
            GameInfo U = U(jSONObject);
            e0(U.getOaid());
            QLog.i("QQGameCenterKuiklyModule", 2, "[startYunGame], gameId:" + U.getGameId() + ", autoLogin:" + U.getAutoLogin() + " gameData:" + U.getGameData());
            IYunGameManagerService.a aVar = new IYunGameManagerService.a() { // from class: com.tencent.mobileqq.gamecenter.kuikly.module.i
                @Override // com.tencent.mobileqq.gamecenter.api.IYunGameManagerService.a
                public final void onResult(int i3, String str) {
                    QQGameCenterKuiklyModule.k0(QQGameCenterKuiklyModule.this, callback, i3, str);
                }
            };
            this.mStartCallBack = aVar;
            ((IYunGameManagerService) runtimeService).startGame(U, aVar);
        } catch (Exception e16) {
            QLog.e("QQGameCenterKuiklyModule", 1, e16, new Object[0]);
            x(callback, 0, -5, e16.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(QQGameCenterKuiklyModule this$0, Function1 function1, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.x(function1, i3, i3, str);
    }

    private final void l0(String params, final Function1<Object, Unit> callback) {
        if (TextUtils.isEmpty(params)) {
            x(callback, 0, -5, "param error");
            return;
        }
        try {
            QLog.i("QQGameCenterKuiklyModule", 1, "[stopYunGame], params:" + params);
            JSONObject jSONObject = new JSONObject(params);
            if (TextUtils.isEmpty(jSONObject.optString(VirtualAppProxy.KEY_GAME_ID))) {
                QLog.e("QQGameCenterKuiklyModule", 1, "[stopYunGame], params error:" + jSONObject);
                x(callback, 0, -5, "param error");
                return;
            }
            IRuntimeService runtimeService = HippyUtils.getAppInterface().getRuntimeService(IYunGameManagerService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "getAppInterface().getRun\u2026nt.MAIN\n                )");
            GameInfo U = U(jSONObject);
            IYunGameManagerService.a aVar = new IYunGameManagerService.a() { // from class: com.tencent.mobileqq.gamecenter.kuikly.module.e
                @Override // com.tencent.mobileqq.gamecenter.api.IYunGameManagerService.a
                public final void onResult(int i3, String str) {
                    QQGameCenterKuiklyModule.m0(QQGameCenterKuiklyModule.this, callback, i3, str);
                }
            };
            this.mStopCallBack = aVar;
            ((IYunGameManagerService) runtimeService).stopGame(U, aVar);
        } catch (Exception e16) {
            QLog.e("QQGameCenterKuiklyModule", 1, e16, new Object[0]);
            x(callback, 0, -5, e16.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(QQGameCenterKuiklyModule this$0, Function1 function1, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.x(function1, i3, i3, str);
    }

    private final void n0(Function1<Object, Unit> callback) {
        QLog.d("QQGameCenterKuiklyModule", 2, "[unregisterGameStatusListener]");
        try {
            IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IYunGameManagerService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService<IY\u2026nstant.MAIN\n            )");
            ((IYunGameManagerService) runtimeService).removeGameStateListener(this.mGameStateListener);
        } catch (Exception e16) {
            QLog.e("QQGameCenterKuiklyModule", 1, "[unregisterGameStatusListener] " + e16);
        }
        x(callback, 0, 0, "");
    }

    private final void o0(List<com.tencent.mobileqq.gamecenter.data.n> list) {
        com.tencent.kuikly.core.render.android.d O0;
        if (list != null && list.size() > 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("list", "");
            QLog.i("QQGameCenterKuiklyModule", 1, "[updateMessage] gameData:" + hashMap);
            com.tencent.kuikly.core.render.android.a aVar = get_kuiklyRenderContext();
            if (aVar != null && (O0 = aVar.O0()) != null) {
                O0.d("onPartnerListChangeEvent", hashMap);
            }
        }
    }

    private final void v(String callbackId, int ret, String msg2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", ret);
            jSONObject.put("ret", ret);
            jSONObject.put("msg", msg2);
            w(callbackId, jSONObject.toString());
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("QQGameCenterKuiklyModule", 2, e16.getMessage());
            }
        }
    }

    private final void x(Function1<Object, Unit> callback, int result, int ret, String msg2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", result);
            jSONObject.put("ret", ret);
            jSONObject.put("msg", msg2);
            if (callback != null) {
                callback.invoke(jSONObject.toString());
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("QQGameCenterKuiklyModule", 2, e16.getMessage());
            }
        }
    }

    private final void y() {
        QLog.i("QQGameCenterKuiklyModule", 1, "[exitBackground]");
        try {
            IRuntimeService runtimeService = HippyUtils.getAppInterface().getRuntimeService(IYunGameManagerService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "getAppInterface().getRun\u2026nt.MAIN\n                )");
            ((IYunGameManagerService) runtimeService).exitBackground();
        } catch (Exception e16) {
            QLog.e("QQGameCenterKuiklyModule", 1, "[exitBackground] " + e16);
        }
    }

    private final Function1<Object, Unit> z(String callbackId) {
        return this.mapCallbacks.get(callbackId);
    }

    protected final void N(@Nullable Bundle resp) {
        String str;
        if (resp == null) {
            return;
        }
        String string = resp.getString("cmd");
        boolean z16 = false;
        int i3 = resp.getInt("respkey", 0);
        if (QLog.isColorLevel()) {
            QLog.d("QQGameCenterKuiklyModule", 1, "[onResponse] cmd:" + string + " respkey:" + i3 + "\uff0ckey:" + this.mOnRemoteResp.key);
        }
        if (i3 != this.mOnRemoteResp.key) {
            return;
        }
        String string2 = resp.getString("callbackid");
        Bundle bundle = resp.getBundle("response");
        if (!TextUtils.isEmpty(string) && bundle != null) {
            Activity activity = getActivity();
            if (activity != null && activity.isFinishing()) {
                z16 = true;
            }
            if (z16) {
                v(string2, 1, "-1000");
                return;
            }
            try {
                if (Intrinsics.areEqual("ipc_cmd_gamecenter_open_aio", string)) {
                    JSONObject T = T(bundle);
                    if (T == null || (str = T.toString()) == null) {
                        str = "";
                    }
                    w(string2, str);
                }
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.e("QQGameCenterKuiklyModule", 2, th5.getMessage());
                }
                v(string2, 1, "-2000");
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x005c, code lost:
    
        r8 = new org.json.JSONObject();
        r8.put("ret", "-1");
        r8.put("msg", "param err");
        r9.invoke(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006a, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Q(@Nullable String params, @Nullable Function1<Object, Unit> callback) {
        try {
            if (TextUtils.isEmpty(params)) {
                if (callback != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("ret", "-1");
                    jSONObject.put("msg", "param err");
                    callback.invoke(jSONObject);
                    return;
                }
                return;
            }
            JSONObject jSONObject2 = new JSONObject(params);
            String optString = jSONObject2.optString("fromOpenAioId", "");
            String optString2 = jSONObject2.optString("toOpenAioId", "");
            JSONObject optJSONObject = jSONObject2.optJSONObject(WadlProxyConsts.EXT_JSON);
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                GameCenterUnissoHandler.N2().t3(optString, optString2, new c(optJSONObject, callback));
            }
        } catch (Exception e16) {
            QLog.d("QQGameCenterKuiklyModule", 1, e16, new Object[0]);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000a. Please report as an issue. */
    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable Object params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        switch (method.hashCode()) {
            case -2112567934:
                if (method.equals("stopYunGame")) {
                    l0((String) params, callback);
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            case -2003047167:
                if (method.equals("requestGameCenterTabConfig")) {
                    Z((String) params, callback);
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            case -1633169444:
                if (method.equals("openQQPlayerAio")) {
                    Q((String) params, callback);
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            case -1328309012:
                if (method.equals("exitBackground")) {
                    y();
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            case -1231267520:
                if (method.equals("isYunGameInstalled")) {
                    I(callback);
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            case -1056581797:
                if (method.equals("registerGameStatusListener")) {
                    X(callback);
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            case -1005171614:
                if (method.equals("getPartnerSessionList")) {
                    A((String) params, callback);
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            case -962241246:
                if (method.equals("startYunGame")) {
                    j0((String) params, callback);
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            case -761518671:
                if (method.equals("installYunGameSDK")) {
                    G(callback);
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            case -574371066:
                if (method.equals("openGameMsgBox")) {
                    O(params, callback);
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            case -28127742:
                if (method.equals("setTrpcCanaryEnv")) {
                    h0((String) params);
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            case -10337362:
                if (method.equals("requestSpringHBPreloadSource")) {
                    a0();
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            case 206931545:
                if (method.equals("notifyUserFeedback")) {
                    J();
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            case 603554171:
                if (method.equals("preLoadYunGame")) {
                    V((String) params);
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            case 1342197933:
                if (method.equals("getYunGameClaritys")) {
                    F(callback);
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            case 1458448530:
                if (method.equals("setYunGameClarity")) {
                    i0((String) params, callback);
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            case 1623533838:
                if (method.equals("getScreenOrientation")) {
                    D((String) params, callback);
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            case 1803315086:
                if (method.equals("getTrpcCanaryEnv")) {
                    return E();
                }
                return Unit.INSTANCE;
            case 1901950720:
                if (method.equals("queryInstallProgress")) {
                    W(callback);
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            case 1902340276:
                if (method.equals("unregisterGameStatusListener")) {
                    n0(callback);
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            case 1964685013:
                if (method.equals("restartYunGame")) {
                    b0((String) params, callback);
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            default:
                return Unit.INSTANCE;
        }
    }

    @Override // i01.e, i01.a
    public void onDestroy() {
        AppInterface appInterface;
        super.onDestroy();
        if (this.mPartnerSessionListener != null && (appInterface = HippyUtils.getAppInterface()) != null) {
            IRuntimeService runtimeService = appInterface.getRuntimeService(IGameMsgManagerService.class, "all");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IG\u2026ava, ProcessConstant.ALL)");
            ((IGameMsgManagerService) runtimeService).removeRecentPartnerListener(this.mPartnerSessionListener);
        }
    }

    public final void w(@Nullable String callbackId, @Nullable String json) {
        Function1<Object, Unit> z16 = z(callbackId);
        if (z16 != null) {
            z16.invoke(json);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(Bundle pushmsg) {
    }
}

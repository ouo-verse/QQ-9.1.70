package com.tencent.timi.game.liveroom.impl.room.toparea;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.api.IQQLiveFollowApi;
import com.tencent.mobileqq.qqlive.api.login.ILiveLoginApi;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.data.follow.FollowPushMessage;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qqlive.login.LiveLoginInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.timi.game.liveroom.impl.room.audience.event.FansGroupConfigEvent;
import com.tencent.timi.game.liveroom.impl.room.fansqqgroup.FansQQGroupPushMgr;
import com.tencent.timi.game.liveroom.impl.room.follow.TGLiveFollowManager;
import com.tencent.timi.game.liveroom.impl.room.toparea.a;
import com.tencent.timi.game.liveroom.impl.room.toparea.f;
import com.tencent.timi.game.utils.o;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.HashMap;
import kk4.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pj4.b;
import trpc.qlive.trpc_room_global_config.TrpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp;
import ug4.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00de\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 \u00072\u00020\u0001:\u0002GOB\t\u00a2\u0006\u0006\b\u00d3\u0001\u0010\u00d4\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J\b\u0010\u0012\u001a\u00020\u0002H\u0002J\b\u0010\u0013\u001a\u00020\u0002H\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0015\u001a\u00020\u0002H\u0002J\u001e\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0004J\b\u0010\u001c\u001a\u00020\u0002H\u0016J\u0006\u0010\u001d\u001a\u00020\u0002J\u0006\u0010\u001e\u001a\u00020\u0002J\u0010\u0010!\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010\u001fJ\u0010\u0010$\u001a\u00020\u00022\b\u0010#\u001a\u0004\u0018\u00010\"J\u0010\u0010&\u001a\u00020\u00022\b\u0010%\u001a\u0004\u0018\u00010\"J\u0018\u0010)\u001a\u00020\u00022\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010(\u001a\u00020'J\u000e\u0010+\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u0004J\u0006\u0010,\u001a\u00020\u0002J\u0016\u00100\u001a\u00020\u00022\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020\u0018J\b\u00101\u001a\u00020\u0002H\u0016J\b\u00102\u001a\u00020\u0002H\u0016J\u000e\u00106\u001a\u0002052\u0006\u00104\u001a\u000203J\u0018\u00109\u001a\u00020\u00022\u0006\u00107\u001a\u00020\u00042\u0006\u00108\u001a\u00020\u0004H\u0004J\u0010\u0010;\u001a\u00020\u00022\u0006\u0010:\u001a\u00020\u0004H\u0004J\u0006\u0010<\u001a\u00020\u0002J\"\u0010=\u001a\u00020\u00022\u0006\u0010:\u001a\u00020\u00042\b\b\u0002\u00108\u001a\u00020\u00042\b\b\u0002\u0010*\u001a\u00020\u0004J&\u0010A\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010>\u001a\u00020\"2\u0006\u0010?\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\u0004J\u000e\u0010C\u001a\u00020\u00022\u0006\u0010B\u001a\u00020\u0004J\b\u0010D\u001a\u00020\u0004H\u0004J\u0006\u0010E\u001a\u00020\u0002R\"\u0010M\u001a\u00020F8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0018\u0010Q\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010U\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010Y\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010]\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0018\u0010a\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010`R\"\u0010\u0017\u001a\u00020\u00168\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bb\u00106\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\"\u0010\u0019\u001a\u00020\u00188\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bg\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR$\u0010s\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bm\u0010n\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR\"\u0010u\u001a\u00020\u00048\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bt\u0010,\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR\"\u0010z\u001a\u00020\u00048\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\by\u0010,\u001a\u0004\bz\u0010v\"\u0004\b{\u0010xR*\u0010~\u001a\u00020\u00042\u0006\u0010|\u001a\u00020\u00048\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b}\u0010,\u001a\u0004\b~\u0010v\"\u0004\b\u007f\u0010xR&\u0010\u0083\u0001\u001a\u00020\u00168\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0015\n\u0005\b\u0080\u0001\u00106\u001a\u0005\b\u0081\u0001\u0010d\"\u0005\b\u0082\u0001\u0010fR\u0019\u0010\u0086\u0001\u001a\u00030\u0084\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u001e\u0010\u0085\u0001R\u0019\u0010\u0089\u0001\u001a\u00030\u0087\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u001c\u0010\u0088\u0001R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u001d\u0010\u008a\u0001R/\u0010\u0091\u0001\u001a\t\u0012\u0004\u0012\u00020\u00180\u008b\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b0\u0010\u008c\u0001\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001\"\u0006\b\u008f\u0001\u0010\u0090\u0001R/\u0010\u0094\u0001\u001a\t\u0012\u0004\u0012\u00020\u00180\u008b\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\bI\u0010\u008c\u0001\u001a\u0006\b\u0092\u0001\u0010\u008e\u0001\"\u0006\b\u0093\u0001\u0010\u0090\u0001R0\u0010\u0097\u0001\u001a\t\u0012\u0004\u0012\u00020\u00180\u008b\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0081\u0001\u0010\u008c\u0001\u001a\u0006\b\u0095\u0001\u0010\u008e\u0001\"\u0006\b\u0096\u0001\u0010\u0090\u0001R0\u0010\u009b\u0001\u001a\t\u0012\u0004\u0012\u00020\u00180\u008b\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0098\u0001\u0010\u008c\u0001\u001a\u0006\b\u0099\u0001\u0010\u008e\u0001\"\u0006\b\u009a\u0001\u0010\u0090\u0001R0\u0010\u009f\u0001\u001a\t\u0012\u0004\u0012\u00020\u00180\u008b\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u009c\u0001\u0010\u008c\u0001\u001a\u0006\b\u009d\u0001\u0010\u008e\u0001\"\u0006\b\u009e\u0001\u0010\u0090\u0001R/\u0010\u00a2\u0001\u001a\t\u0012\u0004\u0012\u00020\"0\u008b\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u0013\u0010\u008c\u0001\u001a\u0006\b\u00a0\u0001\u0010\u008e\u0001\"\u0006\b\u00a1\u0001\u0010\u0090\u0001R0\u0010\u00a6\u0001\u001a\t\u0012\u0004\u0012\u00020\"0\u008b\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00a3\u0001\u0010\u008c\u0001\u001a\u0006\b\u00a4\u0001\u0010\u008e\u0001\"\u0006\b\u00a5\u0001\u0010\u0090\u0001R1\u0010\u00a9\u0001\u001a\n\u0012\u0005\u0012\u00030\u00a7\u00010\u008b\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0092\u0001\u0010\u008c\u0001\u001a\u0006\b\u0098\u0001\u0010\u008e\u0001\"\u0006\b\u00a8\u0001\u0010\u0090\u0001R0\u0010\u00ac\u0001\u001a\t\u0012\u0004\u0012\u00020\r0\u008b\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u008d\u0001\u0010\u008c\u0001\u001a\u0006\b\u00aa\u0001\u0010\u008e\u0001\"\u0006\b\u00ab\u0001\u0010\u0090\u0001R0\u0010\u00af\u0001\u001a\t\u0012\u0004\u0012\u00020\u00160\u008b\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0095\u0001\u0010\u008c\u0001\u001a\u0006\b\u00ad\u0001\u0010\u008e\u0001\"\u0006\b\u00ae\u0001\u0010\u0090\u0001R0\u0010\u00b1\u0001\u001a\t\u0012\u0004\u0012\u00020\u00160\u008b\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00aa\u0001\u0010\u008c\u0001\u001a\u0006\b\u009c\u0001\u0010\u008e\u0001\"\u0006\b\u00b0\u0001\u0010\u0090\u0001R\u001f\u0010\u00b5\u0001\u001a\n\u0012\u0005\u0012\u00030\u00b3\u00010\u00b2\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a4\u0001\u0010\u00b4\u0001R#\u0010\u00b9\u0001\u001a\n\u0012\u0005\u0012\u00030\u00b3\u00010\u00b6\u00018\u0006\u00a2\u0006\u000f\n\u0005\bD\u0010\u00b7\u0001\u001a\u0006\b\u00a3\u0001\u0010\u00b8\u0001R0\u0010\u00bc\u0001\u001a\t\u0012\u0004\u0012\u00020\u00040\u008b\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00a0\u0001\u0010\u008c\u0001\u001a\u0006\b\u00ba\u0001\u0010\u008e\u0001\"\u0006\b\u00bb\u0001\u0010\u0090\u0001R+\u0010\u00c2\u0001\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0099\u0001\u0010\u00bd\u0001\u001a\u0006\b\u00be\u0001\u0010\u00bf\u0001\"\u0006\b\u00c0\u0001\u0010\u00c1\u0001R*\u0010\u00c5\u0001\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\bo\u0010\u00bd\u0001\u001a\u0006\b\u00c3\u0001\u0010\u00bf\u0001\"\u0006\b\u00c4\u0001\u0010\u00c1\u0001R+\u0010\u00c8\u0001\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00ad\u0001\u0010\u00bd\u0001\u001a\u0006\b\u00c6\u0001\u0010\u00bf\u0001\"\u0006\b\u00c7\u0001\u0010\u00c1\u0001R\u0017\u0010\u00cb\u0001\u001a\u00030\u00c9\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\bc\u0010\u00ca\u0001R\u001b\u0010\u00ce\u0001\u001a\u0007\u0012\u0002\b\u00030\u00cc\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\bh\u0010\u00cd\u0001R\u0017\u0010\u00d1\u0001\u001a\u00030\u00cf\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b6\u0010\u00d0\u0001R\u0015\u0010\u00d2\u0001\u001a\u00020\u00168DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\bh\u0010d\u00a8\u0006\u00d5\u0001"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/toparea/TopAreaViewModel;", "Lcom/tencent/timi/game/liveroom/impl/room/toparea/a;", "", "k0", "", "isFromClick", "isFromCache", "K", "Lcom/tencent/mobileqq/qqlive/data/follow/FollowPushMessage;", "followPushMessage", "N", "o0", "W", "Lnr4/d;", "fansGroupInfo", "t0", "O", "h0", "c0", "v", "M", "i0", "", "roomId", "", "roomType", "mIsAnchor", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "o", "p", DomainData.DOMAIN_NAME, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "a0", "", "name", "g0", "headUrl", "f0", "Landroid/view/View;", "view", "u0", "isQuickShow", "Y", "Z", "Landroid/content/Context;", "context", "tabIndex", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "l0", "v0", "Lcom/tencent/image/URLImageView;", "igv", "Lcom/tencent/image/URLDrawable$URLDrawableOptions;", "J", QCircleDaTongConstant.ElementParamValue.FOLLOWED, "needReport", "X", "isFollow", "p0", "n0", "d0", "programId", "showGold", "showPraise", "P", "enablePraise", "w0", BdhLogUtil.LogTag.Tag_Conn, "m0", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "a", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "r", "()Lcom/tencent/qqlive/common/api/IAegisLogApi;", "setAegisLog", "(Lcom/tencent/qqlive/common/api/IAegisLogApi;)V", "aegisLog", "Lhj4/a;", "b", "Lhj4/a;", "fansGroupPushMgr", "Ljj4/d;", "c", "Ljj4/d;", "fansGroupModel", "Lcom/tencent/timi/game/liveroom/impl/room/fansqqgroup/FansQQGroupPushMgr;", "d", "Lcom/tencent/timi/game/liveroom/impl/room/fansqqgroup/FansQQGroupPushMgr;", "fansQQGroupPushMgr", "Lcom/tencent/timi/game/liveroom/impl/room/follow/a;", "e", "Lcom/tencent/timi/game/liveroom/impl/room/follow/a;", "followPushMgr", "Lcom/tencent/timi/game/liveroom/impl/room/toparea/f;", "f", "Lcom/tencent/timi/game/liveroom/impl/room/toparea/f;", "onlineMetricModel", "g", "H", "()J", "setRoomId", "(J)V", tl.h.F, "I", "getRoomType", "()I", "setRoomType", "(I)V", "i", "Ljava/lang/String;", UserInfo.SEX_FEMALE, "()Ljava/lang/String;", "r0", "(Ljava/lang/String;)V", "platform", "j", "isAnchor", "()Z", "setAnchor", "(Z)V", "k", "isRelease", "setRelease", "value", "l", MiniChatConstants.MINI_APP_LANDSCAPE, "q0", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, ReportConstant.COSTREPORT_PREFIX, "setAnchorId", "anchorId", "Landroid/graphics/drawable/ColorDrawable;", "Landroid/graphics/drawable/ColorDrawable;", "defaultColorDrawable", "Lcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;", "Lcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;", "currentLiveUserInfo", "Lnr4/d;", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/MutableLiveData;", "y", "()Landroidx/lifecycle/MutableLiveData;", "setFollowTxvVisible", "(Landroidx/lifecycle/MutableLiveData;)V", "followTxvVisible", HippyTKDListViewAdapter.X, "setFollowPagAnimVisible", "followPagAnimVisible", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "setFollowedIgvVisible", "followedIgvVisible", "t", "E", "setPlaceHolderViewVisible", "placeHolderViewVisible", "u", "getFollowFlVisible", "setFollowFlVisible", "followFlVisible", "D", "setNameLiveData", "nameLiveData", "w", "B", "setHeadUrlLiveData", "headUrlLiveData", "Lcom/tencent/timi/game/liveroom/impl/room/toparea/TopAreaViewModel$a;", "setClearFansGroupAnim", "clearFansGroupAnim", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "setGroupEntrance", "groupEntrance", "G", "setPraiseLiveData", "praiseLiveData", "setCoinLiveData", "coinLiveData", "Landroidx/lifecycle/MediatorLiveData;", "Lrr4/e;", "Landroidx/lifecycle/MediatorLiveData;", "_fansQQGroupData", "Landroidx/lifecycle/LiveData;", "Landroidx/lifecycle/LiveData;", "()Landroidx/lifecycle/LiveData;", "fansQQGroupData", "getFollowState", "setFollowState", "followState", "Landroid/view/View;", "getReportTopHeadView", "()Landroid/view/View;", "s0", "(Landroid/view/View;)V", "reportTopHeadView", "getReportFansGroupFlView", "setReportFansGroupFlView", "reportFansGroupFlView", "getReportFollowTxvView", "setReportFollowTxvView", "reportFollowTxvView", "Lpj4/b$b;", "Lpj4/b$b;", "statusListener", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "fansGroupConfigReceiver", "Lcom/tencent/mobileqq/qqlive/api/IQQLiveFollowApi$IQQLiveFollowStateListener;", "Lcom/tencent/mobileqq/qqlive/api/IQQLiveFollowApi$IQQLiveFollowStateListener;", "qqLiveFollowStateListener", "selfUid", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public abstract class TopAreaViewModel implements com.tencent.timi.game.liveroom.impl.room.toparea.a {

    /* renamed from: A, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<Long> coinLiveData;

    /* renamed from: B, reason: from kotlin metadata */
    @NotNull
    private final MediatorLiveData<rr4.e> _fansQQGroupData;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final LiveData<rr4.e> fansQQGroupData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<Boolean> followState;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private View reportTopHeadView;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private View reportFansGroupFlView;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private View reportFollowTxvView;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final b.InterfaceC11024b statusListener;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final SimpleEventReceiver<?> fansGroupConfigReceiver;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final IQQLiveFollowApi.IQQLiveFollowStateListener qqLiveFollowStateListener;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private IAegisLogApi aegisLog;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private hj4.a fansGroupPushMgr;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private jj4.d fansGroupModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FansQQGroupPushMgr fansQQGroupPushMgr;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.timi.game.liveroom.impl.room.follow.a followPushMgr;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.timi.game.liveroom.impl.room.toparea.f onlineMetricModel;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private long roomId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int roomType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String platform;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean isAnchor;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean isRelease;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean isLandscape;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private long anchorId;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ColorDrawable defaultColorDrawable;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LiveUserInfo currentLiveUserInfo;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private nr4.d fansGroupInfo;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MutableLiveData<Integer> followTxvVisible;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MutableLiveData<Integer> followPagAnimVisible;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MutableLiveData<Integer> followedIgvVisible;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MutableLiveData<Integer> placeHolderViewVisible;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MutableLiveData<Integer> followFlVisible;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MutableLiveData<String> nameLiveData;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MutableLiveData<String> headUrlLiveData;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MutableLiveData<a> clearFansGroupAnim;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MutableLiveData<nr4.d> groupEntrance;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MutableLiveData<Long> praiseLiveData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/toparea/TopAreaViewModel$a;", "", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0016\u0010\t\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b\u0018\u00010\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/toparea/TopAreaViewModel$c", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/timi/game/liveroom/impl/room/audience/event/FansGroupConfigEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "simpleBaseEvent", "", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements SimpleEventReceiver<FansGroupConfigEvent> {
        c() {
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        @Nullable
        public ArrayList<Class<FansGroupConfigEvent>> getEventClass() {
            ArrayList<Class<FansGroupConfigEvent>> arrayList = new ArrayList<>();
            arrayList.add(FansGroupConfigEvent.class);
            return arrayList;
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        public void onReceiveEvent(@NotNull SimpleBaseEvent simpleBaseEvent) {
            Intrinsics.checkNotNullParameter(simpleBaseEvent, "simpleBaseEvent");
            if ((simpleBaseEvent instanceof FansGroupConfigEvent) && TopAreaViewModel.this.R() && ((FansGroupConfigEvent) simpleBaseEvent).getRoomId() == TopAreaViewModel.this.getRoomId() && TopAreaViewModel.this.b()) {
                TopAreaViewModel.this.M(false);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/toparea/TopAreaViewModel$d", "Lzi4/a;", "Ltrpc/qlive/trpc_room_global_config/TrpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp;", "data", "", "a", "", "code", "", "msg", "fail", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d implements zi4.a<TrpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp> {
        d() {
        }

        @Override // zi4.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void success(@Nullable TrpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp data) {
            if (TopAreaViewModel.this.fansGroupInfo != null) {
                TopAreaViewModel.this.K(false, true);
            }
        }

        @Override // zi4.a
        public void fail(int code, @NotNull String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/toparea/TopAreaViewModel$e", "Lzi4/a;", "Lnr4/d;", "data", "", "a", "", "code", "", "msg", "fail", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class e implements zi4.a<nr4.d> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f378540b;

        e(boolean z16) {
            this.f378540b = z16;
        }

        @Override // zi4.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void success(@Nullable nr4.d data) {
            Integer num;
            IAegisLogApi aegisLog = TopAreaViewModel.this.getAegisLog();
            if (data != null) {
                num = Integer.valueOf(data.f421214a);
            } else {
                num = null;
            }
            aegisLog.i("Audience|TopAreaViewModel", 1, "getFansGroupInfo data?.retcode=" + num);
            TopAreaViewModel.this.fansGroupInfo = data;
            TopAreaViewModel.this.M(this.f378540b);
        }

        @Override // zi4.a
        public void fail(int code, @Nullable String msg2) {
            TopAreaViewModel.this.getAegisLog().i("Audience|TopAreaViewModel", 1, "handleFansGroupEntrance code=" + code + "\uff0cmsg=" + msg2);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/toparea/TopAreaViewModel$f", "Lcom/tencent/timi/game/liveroom/impl/room/toparea/f$b;", "", "coin", "", "a", "praise", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class f implements f.b {
        f() {
        }

        @Override // com.tencent.timi.game.liveroom.impl.room.toparea.f.b
        public void a(long coin) {
            TopAreaViewModel.this.u().setValue(Long.valueOf(coin));
        }

        @Override // com.tencent.timi.game.liveroom.impl.room.toparea.f.b
        public void b(long praise) {
            TopAreaViewModel.this.G().setValue(Long.valueOf(praise));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/toparea/TopAreaViewModel$g", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveFollowCallback;", "", "onSuccess", "", "errCode", "", "errMsg", "onFail", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class g implements IQQLiveFollowCallback {
        g() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback
        public void onFail(int errCode, @Nullable String errMsg) {
            QQToast.makeText(BaseApplication.getContext(), "\u5173\u6ce8\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5\uff08" + errCode + "\uff09", 0).show();
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback
        public void onSuccess() {
            TopAreaViewModel.e0(TopAreaViewModel.this, true, false, false, 4, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002#\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u0007J\u0013\u0010\b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0096\u0002\u00a8\u0006\t"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/toparea/TopAreaViewModel$h", "Lkotlin/Function1;", "Lnr4/f;", "Lkotlin/ParameterName;", "name", "msg", "", "Lcom/tencent/timi/game/liveroom/impl/room/fans/FansGroupReceiver;", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class h implements Function1<nr4.f, Unit> {
        h() {
        }

        public void a(@Nullable nr4.f msg2) {
            boolean z16;
            boolean z17 = true;
            if (msg2 != null && TopAreaViewModel.this.getRoomId() == msg2.f421231e) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (msg2 == null || msg2.f421227a != TopAreaViewModel.this.I()) {
                    z17 = false;
                }
                if (z17) {
                    TopAreaViewModel.this.c0();
                }
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(nr4.f fVar) {
            a(fVar);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002#\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u0007J\u0013\u0010\b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0096\u0002\u00a8\u0006\t"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/toparea/TopAreaViewModel$i", "Lkotlin/Function1;", "Lnr4/h;", "Lkotlin/ParameterName;", "name", "msg", "", "Lcom/tencent/timi/game/liveroom/impl/room/fans/DiamondGroupReceiver;", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class i implements Function1<nr4.h, Unit> {
        i() {
        }

        public void a(@Nullable nr4.h msg2) {
            boolean z16 = false;
            if (msg2 != null && msg2.f421238a == com.tencent.mobileqq.qqlive.sail.c.l(com.tencent.mobileqq.qqlive.sail.c.f272176a, TopAreaViewModel.this.getRoomId(), 0, 2, null)) {
                z16 = true;
            }
            if (z16) {
                TopAreaViewModel.this.c0();
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(nr4.h hVar) {
            a(hVar);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/toparea/TopAreaViewModel$j", "Lpj4/b$b;", "", "roomId", "", "status", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class j implements b.InterfaceC11024b {
        j() {
        }

        @Override // pj4.b.InterfaceC11024b
        public void a(long roomId, @NotNull String status) {
            Intrinsics.checkNotNullParameter(status, "status");
            TopAreaViewModel.this.o0();
        }
    }

    public TopAreaViewModel() {
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.aegisLog = (IAegisLogApi) api;
        this.roomId = -1L;
        this.defaultColorDrawable = new ColorDrawable(0);
        this.currentLiveUserInfo = new LiveUserInfo();
        this.followTxvVisible = new MutableLiveData<>();
        this.followPagAnimVisible = new MutableLiveData<>();
        this.followedIgvVisible = new MutableLiveData<>();
        this.placeHolderViewVisible = new MutableLiveData<>();
        this.followFlVisible = new MutableLiveData<>();
        this.nameLiveData = new MutableLiveData<>();
        this.headUrlLiveData = new MutableLiveData<>();
        this.clearFansGroupAnim = new MutableLiveData<>();
        this.groupEntrance = new MutableLiveData<>();
        this.praiseLiveData = new MutableLiveData<>();
        this.coinLiveData = new MutableLiveData<>();
        MediatorLiveData<rr4.e> mediatorLiveData = new MediatorLiveData<>();
        this._fansQQGroupData = mediatorLiveData;
        this.fansQQGroupData = mediatorLiveData;
        this.followState = new MutableLiveData<>(Boolean.FALSE);
        this.statusListener = new j();
        this.fansGroupConfigReceiver = new c();
        this.qqLiveFollowStateListener = new IQQLiveFollowApi.IQQLiveFollowStateListener() { // from class: com.tencent.timi.game.liveroom.impl.room.toparea.g
            @Override // com.tencent.mobileqq.qqlive.api.IQQLiveFollowApi.IQQLiveFollowStateListener
            public final void onFollowStateChange(long j3, long j16, int i3, String str) {
                TopAreaViewModel.b0(TopAreaViewModel.this, j3, j16, i3, str);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K(boolean isFromClick, boolean isFromCache) {
        this.aegisLog.i("Audience|TopAreaViewModel", 1, "handleFansGroupEntrance mAnchorId=" + this.anchorId + ",thread=" + Thread.currentThread().getName());
        jj4.d dVar = this.fansGroupModel;
        if (dVar != null) {
            dVar.f(this.anchorId, isFromCache, new e(isFromClick));
        }
    }

    static /* synthetic */ void L(TopAreaViewModel topAreaViewModel, boolean z16, boolean z17, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                z17 = true;
            }
            topAreaViewModel.K(z16, z17);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleFansGroupEntrance");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(boolean isFromClick) {
        nr4.b bVar;
        nr4.d dVar = this.fansGroupInfo;
        if (dVar != null) {
            bVar = dVar.f421217d;
        } else {
            bVar = null;
        }
        if (bVar == null) {
            this.followedIgvVisible.setValue(0);
            return;
        }
        nr4.b bVar2 = dVar.f421217d;
        if (bVar2.f421210f && jj4.d.g()) {
            AegisLogger.INSTANCE.i("Audience|TopAreaViewModel", "handleFansGroupRsp", "status=" + dVar.f421217d.f421205a);
            t0(dVar);
            return;
        }
        AegisLogger.INSTANCE.i("Audience|TopAreaViewModel", "handleFansGroupRsp", "has_fans_group=" + bVar2.f421210f + ", isEnable=" + jj4.d.g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N(FollowPushMessage followPushMessage) {
        boolean z16;
        if (!C()) {
            this.aegisLog.e("Audience|TopAreaViewModel", "handleFollowPushMsg mLiveRoom is null");
            return;
        }
        if (this.isAnchor) {
            this.aegisLog.d("Audience|TopAreaViewModel", "handleFollowPushMsg is anchor room");
            return;
        }
        boolean z17 = true;
        if (I() == followPushMessage.uid && this.anchorId == followPushMessage.toUid) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            this.aegisLog.i("Audience|TopAreaViewModel", 2, "onFollowReceive selfUid:" + MobileQQ.getShortUinStr(String.valueOf(I())) + ", mAnchorId:" + MobileQQ.getShortUinStr(String.valueOf(this.anchorId)) + ", msg.uid:" + MobileQQ.getShortUinStr(String.valueOf(followPushMessage.uid)) + "msg.toUid:" + MobileQQ.getShortUinStr(String.valueOf(followPushMessage.toUid)));
        }
        if (z16) {
            if (followPushMessage.type != 1) {
                z17 = false;
            }
            X(z17, false);
        }
    }

    private final void O() {
        this.followTxvVisible.setValue(8);
        this.followedIgvVisible.setValue(8);
        this.followPagAnimVisible.setValue(8);
        this.placeHolderViewVisible.setValue(8);
    }

    private final void W() {
        if (!C()) {
            this.aegisLog.e("Audience|TopAreaViewModel", 1, "loadingData initLiveRoom error!");
            return;
        }
        com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
        long l3 = com.tencent.mobileqq.qqlive.sail.c.l(cVar, this.roomId, 0, 2, null);
        this.anchorId = l3;
        if (l3 <= 0) {
            this.aegisLog.w("Audience|TopAreaViewModel", 1, "[loadingData] invalid anchorUid, " + l3);
            return;
        }
        this.nameLiveData.setValue(com.tencent.mobileqq.qqlive.sail.c.h(cVar, this.roomId, 0, 2, null));
        this.headUrlLiveData.setValue(com.tencent.mobileqq.qqlive.sail.c.f(cVar, this.roomId, 0, 2, null));
        LiveUserInfo liveUserInfo = this.currentLiveUserInfo;
        liveUserInfo.uid = this.anchorId;
        liveUserInfo.nick = this.nameLiveData.getValue();
        this.currentLiveUserInfo.headUrl = this.headUrlLiveData.getValue();
        this.currentLiveUserInfo.sex = com.tencent.mobileqq.qqlive.sail.c.j(cVar, this.roomId, 0, 2, null);
        v();
        if (this.isAnchor) {
            p0(false);
            O();
            L(this, false, false, 2, null);
        } else {
            a.C9953a.a(this, false, 1, null);
        }
        a.Companion.d(kk4.a.INSTANCE, this.roomId, this.anchorId, this.currentLiveUserInfo, 0, false, 16, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x009d, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r20, java.lang.String.valueOf(r14.roomId)) != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0082, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r20, java.lang.String.valueOf(r14.roomId)) != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x009f, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void b0(TopAreaViewModel this$0, long j3, long j16, int i3, String roomId) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.aegisLog.i("Audience|TopAreaViewModel", 1, "qqLiveFollowStateListener uid:" + j3 + " followedId:" + j16 + ", isFollowed:" + i3 + ",roomId:" + roomId + ", selfUid:" + this$0.I() + ", mRoomId:" + this$0.roomId);
        boolean z17 = false;
        if (this$0.roomType == 2) {
            Intrinsics.checkNotNullExpressionValue(roomId, "roomId");
            if (j16 == Long.parseLong(roomId)) {
                if (j3 == this$0.I()) {
                }
                z16 = false;
                if (!z16) {
                    if (i3 == 1) {
                        z17 = true;
                    }
                    e0(this$0, z17, false, false, 4, null);
                    return;
                }
                return;
            }
        }
        if (this$0.anchorId == j16) {
            if (j3 == this$0.I()) {
            }
        }
        z16 = false;
        if (!z16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c0() {
        K(false, false);
        if (!b() && C()) {
            c(this.roomId, this.anchorId, null);
        }
    }

    public static /* synthetic */ void e0(TopAreaViewModel topAreaViewModel, boolean z16, boolean z17, boolean z18, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                z17 = true;
            }
            if ((i3 & 4) != 0) {
                z18 = false;
            }
            topAreaViewModel.d0(z16, z17, z18);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: refreshFollowUI");
    }

    private final void h0() {
        hj4.a aVar = this.fansGroupPushMgr;
        if (aVar != null) {
            aVar.c(this.roomId, new h(), new i());
        }
    }

    private final void i0() {
        FansQQGroupPushMgr fansQQGroupPushMgr;
        if (!this.isAnchor && (fansQQGroupPushMgr = this.fansQQGroupPushMgr) != null) {
            fansQQGroupPushMgr.f(new Function1<rr4.e, Unit>() { // from class: com.tencent.timi.game.liveroom.impl.room.toparea.TopAreaViewModel$registerFansQQGroup$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(rr4.e eVar) {
                    invoke2(eVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable rr4.e eVar) {
                    MediatorLiveData mediatorLiveData;
                    if (eVar != null) {
                        mediatorLiveData = TopAreaViewModel.this._fansQQGroupData;
                        mediatorLiveData.postValue(eVar);
                    }
                }
            });
            this._fansQQGroupData.removeSource(fansQQGroupPushMgr.d());
            MediatorLiveData<rr4.e> mediatorLiveData = this._fansQQGroupData;
            LiveData<rr4.e> d16 = fansQQGroupPushMgr.d();
            final Function1<rr4.e, Unit> function1 = new Function1<rr4.e, Unit>() { // from class: com.tencent.timi.game.liveroom.impl.room.toparea.TopAreaViewModel$registerFansQQGroup$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(rr4.e eVar) {
                    invoke2(eVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(rr4.e eVar) {
                    MediatorLiveData mediatorLiveData2;
                    if (eVar != null) {
                        mediatorLiveData2 = TopAreaViewModel.this._fansQQGroupData;
                        mediatorLiveData2.postValue(eVar);
                    }
                }
            };
            mediatorLiveData.addSource(d16, new Observer() { // from class: com.tencent.timi.game.liveroom.impl.room.toparea.h
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    TopAreaViewModel.j0(Function1.this, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void k0() {
        com.tencent.timi.game.liveroom.impl.room.follow.a aVar = this.followPushMgr;
        if (aVar != null) {
            aVar.b(this.roomId, new Function1<FollowPushMessage, Unit>() { // from class: com.tencent.timi.game.liveroom.impl.room.toparea.TopAreaViewModel$registerFollowPush$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(FollowPushMessage followPushMessage) {
                    invoke2(followPushMessage);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable FollowPushMessage followPushMessage) {
                    if (followPushMessage != null) {
                        TopAreaViewModel.this.N(followPushMessage);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o0() {
        Object obj;
        View view = this.reportFollowTxvView;
        if (view == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        if (!this.isAnchor) {
            String str = "1";
            if (Intrinsics.areEqual(this.followState.getValue(), Boolean.TRUE)) {
                obj = "1";
            } else {
                obj = "0";
            }
            hashMap.put("qqlive_follow_status", obj);
            if (!this.isLandscape) {
                str = "0";
            }
            hashMap.put("qqlive_screen_orientation", str);
            hashMap.put("zengzhi_moduleid", "em_qqlive_anchor_inf");
            b.Companion companion = pj4.b.INSTANCE;
            hashMap.put("qqlive_equip_status", companion.a().b(this.roomId));
            mm4.a b16 = mm4.b.b(ug4.a.class);
            Intrinsics.checkNotNullExpressionValue(b16, "getService(ILiveReportService::class.java)");
            a.C11346a.a((ug4.a) b16, view, false, null, "em_qqlive_follow", hashMap, 6, null);
            if (!this.isRelease) {
                companion.a().c(this.statusListener);
            }
        }
    }

    private final void t0(nr4.d fansGroupInfo) {
        nr4.b bVar;
        AegisLogger.INSTANCE.i("Audience|TopAreaViewModel", "showFansGroupEntrance", "fansGroupInfo=" + fansGroupInfo);
        if (fansGroupInfo != null) {
            bVar = fansGroupInfo.f421217d;
        } else {
            bVar = null;
        }
        if (bVar == null) {
            return;
        }
        this.followFlVisible.setValue(8);
        O();
        this.groupEntrance.setValue(fansGroupInfo);
    }

    private final void v() {
        jj4.d dVar;
        com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
        long p16 = cVar.p();
        long l3 = com.tencent.mobileqq.qqlive.sail.c.l(cVar, p16, 0, 2, null);
        if (l3 > 0 && (dVar = this.fansGroupModel) != null) {
            dVar.d(l3, 1, p16, new d());
        }
    }

    @NotNull
    public final MutableLiveData<nr4.d> A() {
        return this.groupEntrance;
    }

    @NotNull
    public final MutableLiveData<String> B() {
        return this.headUrlLiveData;
    }

    protected final boolean C() {
        return com.tencent.mobileqq.qqlive.sail.c.I(com.tencent.mobileqq.qqlive.sail.c.f272176a, this.roomId, 0, 2, null);
    }

    @NotNull
    public final MutableLiveData<String> D() {
        return this.nameLiveData;
    }

    @NotNull
    public final MutableLiveData<Integer> E() {
        return this.placeHolderViewVisible;
    }

    @Nullable
    /* renamed from: F, reason: from getter */
    public final String getPlatform() {
        return this.platform;
    }

    @NotNull
    public final MutableLiveData<Long> G() {
        return this.praiseLiveData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: H, reason: from getter */
    public final long getRoomId() {
        return this.roomId;
    }

    protected final long I() {
        LiveLoginInfo loginInfo = ((ILiveLoginApi) QRoute.api(ILiveLoginApi.class)).getLoginInfo(QQLiveBusinessConfig.QQLIVE_APP_ID, ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount());
        if (loginInfo != null) {
            return loginInfo.q();
        }
        return 0L;
    }

    @NotNull
    public final URLDrawable.URLDrawableOptions J(@NotNull URLImageView igv) {
        Drawable drawable;
        Drawable drawable2;
        Intrinsics.checkNotNullParameter(igv, "igv");
        URLDrawable.URLDrawableOptions options = URLDrawable.URLDrawableOptions.obtain();
        if (igv.getDrawable() != null) {
            drawable = igv.getDrawable();
        } else {
            drawable = this.defaultColorDrawable;
        }
        options.mLoadingDrawable = drawable;
        if (igv.getDrawable() != null) {
            drawable2 = igv.getDrawable();
        } else {
            drawable2 = this.defaultColorDrawable;
        }
        options.mFailedDrawable = drawable2;
        Intrinsics.checkNotNullExpressionValue(options, "options");
        return options;
    }

    public final void P(long roomId, @NotNull String programId, boolean showGold, boolean showPraise) {
        Intrinsics.checkNotNullParameter(programId, "programId");
        com.tencent.timi.game.liveroom.impl.room.toparea.f fVar = this.onlineMetricModel;
        if (fVar != null) {
            fVar.n(roomId, programId, showGold, showPraise, new f());
        }
    }

    public final void Q(long roomId, int roomType, boolean mIsAnchor) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.isAnchor = mIsAnchor;
        if (R()) {
            if (this.fansGroupPushMgr == null) {
                this.fansGroupPushMgr = new hj4.a();
            }
            if (this.fansGroupModel == null) {
                this.fansGroupModel = new jj4.d();
            }
            if (this.fansQQGroupPushMgr == null) {
                this.fansQQGroupPushMgr = new FansQQGroupPushMgr(roomId);
            }
            if (this.followPushMgr == null) {
                this.followPushMgr = new com.tencent.timi.game.liveroom.impl.room.follow.a();
            }
            if (this.onlineMetricModel == null) {
                this.onlineMetricModel = new com.tencent.timi.game.liveroom.impl.room.toparea.f();
            }
        }
    }

    public boolean R() {
        return a.C9953a.b(this);
    }

    public boolean S() {
        return a.C9953a.c(this);
    }

    public boolean T() {
        return a.C9953a.d(this);
    }

    public boolean U() {
        return a.C9953a.e(this);
    }

    public boolean V() {
        return a.C9953a.f(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void X(boolean followed, boolean needReport) {
        if (needReport) {
            p0(followed);
        }
        if (followed) {
            ui4.c.INSTANCE.a(this.roomId);
        }
        if (followed && Intrinsics.areEqual(this.followState.getValue(), Boolean.TRUE)) {
            L(this, false, false, 2, null);
        } else {
            this.followState.setValue(Boolean.valueOf(followed));
            e0(this, followed, needReport, false, 4, null);
        }
    }

    public final void Y(boolean isQuickShow) {
        if (isQuickShow) {
            c(this.roomId, this.anchorId, null);
            d0(true, false, true);
        } else {
            c(this.roomId, this.anchorId, new g());
        }
    }

    public final void Z() {
        jj4.d dVar = this.fansGroupModel;
        if (dVar != null) {
            dVar.e(this.anchorId, null);
        }
    }

    public final void a0(@Nullable Activity activity) {
        if (activity != null) {
            com.tencent.timi.game.liveroom.impl.room.livewebdialog.e.i(activity, kj4.a.a(3, 1));
        }
    }

    public final void d0(boolean isFollow, boolean needReport, boolean isQuickShow) {
        this.followState.setValue(Boolean.valueOf(isFollow));
        this.placeHolderViewVisible.setValue(8);
        this.followFlVisible.setValue(0);
        this.followPagAnimVisible.setValue(8);
        this.clearFansGroupAnim.setValue(new a());
        if (needReport) {
            o0();
        }
        if (isFollow) {
            this.followTxvVisible.setValue(8);
            if (isQuickShow) {
                this.followedIgvVisible.setValue(8);
            } else {
                this.followedIgvVisible.setValue(0);
            }
            L(this, true, false, 2, null);
            return;
        }
        this.groupEntrance.setValue(null);
        this.followTxvVisible.setValue(0);
        this.followedIgvVisible.setValue(8);
    }

    public final void f0(@Nullable String headUrl) {
        this.aegisLog.i("Audience|TopAreaViewModel", "refreshHeadUrl url:" + headUrl);
        if (headUrl != null && !TextUtils.equals(this.headUrlLiveData.getValue(), headUrl)) {
            this.headUrlLiveData.setValue(headUrl);
        }
    }

    public final void g0(@Nullable String name) {
        this.aegisLog.i("Audience|TopAreaViewModel", "refreshAudienceRoomAnchorInfo name:" + name);
        if (name != null && !TextUtils.equals(this.nameLiveData.getValue(), name)) {
            this.nameLiveData.setValue(name);
        }
    }

    public void l0() {
        v0();
        k0();
        TGLiveFollowManager.f377684a.u(this.qqLiveFollowStateListener);
        h0();
        SimpleEventBus.getInstance().registerReceiver(this.fansGroupConfigReceiver);
        i0();
    }

    public final void m0() {
        this.isRelease = true;
        n();
    }

    public final void n() {
        v0();
        pj4.b.INSTANCE.a().e(this.statusListener);
    }

    public final void n0() {
        String str;
        View view = this.reportFansGroupFlView;
        if (view == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        if (this.isLandscape) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("qqlive_screen_orientation", str);
        hashMap.put("zengzhi_moduleid", "em_qqlive_anchor_inf");
        hashMap.put("qqlive_equip_status", pj4.b.INSTANCE.a().b(this.roomId));
        mm4.a b16 = mm4.b.b(ug4.a.class);
        Intrinsics.checkNotNullExpressionValue(b16, "getService(ILiveReportService::class.java)");
        a.C11346a.a((ug4.a) b16, view, false, null, "em_qqlive_joinfantuan_entrance", hashMap, 6, null);
    }

    public void o() {
        jj4.d dVar = this.fansGroupModel;
        if (dVar != null) {
            dVar.m(null);
        }
        W();
        l0();
    }

    public final void p() {
        jj4.d dVar = this.fansGroupModel;
        if (dVar != null) {
            dVar.l();
        }
        com.tencent.timi.game.liveroom.impl.room.toparea.f fVar = this.onlineMetricModel;
        if (fVar != null) {
            fVar.q();
        }
        v0();
        pj4.b.INSTANCE.a().e(this.statusListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void p0(boolean isFollow) {
        Object obj;
        View view = this.reportTopHeadView;
        if (view == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        if (!this.isAnchor) {
            String str = "1";
            if (isFollow) {
                obj = "1";
            } else {
                obj = "0";
            }
            hashMap.put("qqlive_follow_status", obj);
            if (!this.isLandscape) {
                str = "0";
            }
            hashMap.put("qqlive_screen_orientation", str);
            mm4.a b16 = mm4.b.b(ug4.a.class);
            Intrinsics.checkNotNullExpressionValue(b16, "getService(ILiveReportService::class.java)");
            a.C11346a.a((ug4.a) b16, view, false, null, "em_qqlive_anchor_inf", hashMap, 6, null);
            return;
        }
        mm4.a b17 = mm4.b.b(ug4.a.class);
        Intrinsics.checkNotNullExpressionValue(b17, "getService(ILiveReportService::class.java)");
        a.C11346a.a((ug4.a) b17, view, false, null, "em_qqlive_anchor_inf", hashMap, 6, null);
    }

    public final void q(@NotNull Context context, int tabIndex) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (o.b(800)) {
            return;
        }
        kj4.a.e(context, this.anchorId, I(), 3, tabIndex);
    }

    public final void q0(boolean z16) {
        this.isLandscape = z16;
        Boolean value = this.followState.getValue();
        if (value == null) {
            value = Boolean.FALSE;
        }
        p0(value.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: r, reason: from getter */
    public final IAegisLogApi getAegisLog() {
        return this.aegisLog;
    }

    public final void r0(@Nullable String str) {
        this.platform = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: s, reason: from getter */
    public final long getAnchorId() {
        return this.anchorId;
    }

    public final void s0(@Nullable View view) {
        this.reportTopHeadView = view;
    }

    @NotNull
    public final MutableLiveData<a> t() {
        return this.clearFansGroupAnim;
    }

    @NotNull
    public final MutableLiveData<Long> u() {
        return this.coinLiveData;
    }

    public final void u0(@Nullable Activity activity, @NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (T() && !o.a() && activity != null) {
            LiveUserInfo liveUserInfo = this.currentLiveUserInfo;
            if (liveUserInfo.uid == 0) {
                AegisLogger.INSTANCE.i("Audience|TopAreaViewModel", "topHeadClick", "openProfileDialog: mCurrentLiveUserInfo data not init!!!");
            } else {
                kk4.a.INSTANCE.f(activity, this.anchorId, liveUserInfo, 0, this._fansQQGroupData.getValue(), null, false, this.platform);
            }
        }
    }

    public void v0() {
        FansQQGroupPushMgr fansQQGroupPushMgr;
        hj4.a aVar = this.fansGroupPushMgr;
        if (aVar != null) {
            aVar.e();
        }
        com.tencent.timi.game.liveroom.impl.room.follow.a aVar2 = this.followPushMgr;
        if (aVar2 != null) {
            aVar2.c();
        }
        TGLiveFollowManager.f377684a.w(this.qqLiveFollowStateListener);
        SimpleEventBus.getInstance().unRegisterReceiver(this.fansGroupConfigReceiver);
        if (!this.isAnchor && (fansQQGroupPushMgr = this.fansQQGroupPushMgr) != null) {
            fansQQGroupPushMgr.c();
        }
    }

    @NotNull
    public final LiveData<rr4.e> w() {
        return this.fansQQGroupData;
    }

    public final void w0(boolean enablePraise) {
        com.tencent.timi.game.liveroom.impl.room.toparea.f fVar = this.onlineMetricModel;
        if (fVar != null) {
            fVar.r(enablePraise);
        }
    }

    @NotNull
    public final MutableLiveData<Integer> x() {
        return this.followPagAnimVisible;
    }

    @NotNull
    public final MutableLiveData<Integer> y() {
        return this.followTxvVisible;
    }

    @NotNull
    public final MutableLiveData<Integer> z() {
        return this.followedIgvVisible;
    }
}

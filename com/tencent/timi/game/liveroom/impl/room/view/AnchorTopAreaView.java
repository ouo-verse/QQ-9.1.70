package com.tencent.timi.game.liveroom.impl.room.view;

import af4.OperationData;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qqlive.api.IQQLivePortalServer;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom;
import com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomBaseCallback;
import com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback;
import com.tencent.mobileqq.qqlive.data.anchor.camera.QQLiveAnchorStreamRecordType;
import com.tencent.mobileqq.qqlive.data.anchor.room.AnchorLiveSystemInfo;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.timi.game.api.live.LiveRoomExtraInfo;
import com.tencent.timi.game.liveroom.api.IRoomWidget;
import com.tencent.timi.game.liveroom.impl.room.toparea.TopAreaViewModel;
import com.tencent.timi.game.liveroom.impl.room.view.AnchorTopAreaView;
import com.tencent.timi.game.liveroom.impl.room.view.AnchorTopAreaView$netQuaListener$2;
import com.tencent.timi.game.liveroom.impl.room.view.config.BusConfigHelper;
import com.tencent.timi.game.liveroom.impl.room.view.head.AnchorTopHeadView;
import com.tencent.timi.game.liveroom.impl.room.view.head.AnchorTopOperationView;
import com.tencent.timi.game.liveroom.impl.room.view.head.QQLiveRoomOnlineRankView;
import com.tencent.timi.game.liveroom.impl.room.view.rank.SelfRankInfoView;
import com.tencent.timi.game.liveroom.impl.room.view.subscript.AnchorSubscriptView;
import com.tencent.timi.game.liveroom.impl.room.view.systeminfo.AnchorLiveSystemInfoDetailView;
import com.tencent.util.UiThreadUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.vip.pb.TianShuAccess;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qn4.BlockOptConfig;
import trpc.yes.common.MessageOuterClass$TimMsgBody;
import trpc.yes.common.PendantOuterClass$PendantMsg;
import ug4.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009e\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00c1\u00012\u00020\u00012\u00020\u0002:\u0007\u00c2\u0001\u00c3\u0001QTVB,\b\u0007\u0012\u0006\u00105\u001a\u000204\u0012\f\b\u0002\u0010\u00bd\u0001\u001a\u0005\u0018\u00010\u00bc\u0001\u0012\t\b\u0002\u0010\u00be\u0001\u001a\u00020\u0003\u00a2\u0006\u0006\b\u00bf\u0001\u0010\u00c0\u0001J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0003H\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0002J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0005H\u0002J\b\u0010\u0014\u001a\u00020\u0005H\u0002J\u0012\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0005H\u0002J\b\u0010\u0019\u001a\u00020\u0005H\u0002J\b\u0010\u001a\u001a\u00020\u0005H\u0002J\b\u0010\u001b\u001a\u00020\u0015H\u0002J\b\u0010\u001c\u001a\u00020\u0005H\u0002J\b\u0010\u001d\u001a\u00020\u0005H\u0002J\b\u0010\u001e\u001a\u00020\u0005H\u0002J\u0010\u0010!\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u001fH\u0002J\b\u0010\"\u001a\u00020\u0005H\u0002J\b\u0010#\u001a\u00020\u0015H\u0002J\u0006\u0010$\u001a\u00020\u0005J\u000e\u0010'\u001a\u00020\u00052\u0006\u0010&\u001a\u00020%J\u000e\u0010)\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u0015J\u0006\u0010*\u001a\u00020\u0005J\u000e\u0010-\u001a\u00020\u00052\u0006\u0010,\u001a\u00020+J\u000e\u00100\u001a\u00020\u00052\u0006\u0010/\u001a\u00020.J\u000e\u00103\u001a\u00020\u00052\u0006\u00102\u001a\u000201J\u0010\u00106\u001a\u00020\u00052\b\u00105\u001a\u0004\u0018\u000104J\u000e\u00108\u001a\u00020\u00052\u0006\u00107\u001a\u00020\u0015J\u000e\u0010;\u001a\u00020\u00052\u0006\u0010:\u001a\u000209J\"\u0010?\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u00152\b\u0010>\u001a\u0004\u0018\u00010=H\u0016J\u0010\u0010@\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u0010H\u0016J\u0010\u0010A\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u0010H\u0016J\u000e\u0010B\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010D\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u0003J\u0018\u0010E\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u0015H\u0016J\u000e\u0010G\u001a\u00020\u00052\u0006\u0010/\u001a\u00020FJ\u0010\u0010H\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u0010H\u0016J\u000e\u0010J\u001a\u00020\u00052\u0006\u0010I\u001a\u00020\u0015J\b\u0010K\u001a\u00020\u0005H\u0014J\u000e\u0010L\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u0010J\u0016\u0010P\u001a\u00020\u00052\u000e\u0010O\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010MR\u0018\u0010S\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010U\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010\"R\u0016\u0010W\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010\u0019R\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010\"R\u0018\u0010\\\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010`\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010b\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010\u0019R\u0016\u0010d\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010\u0019R\u0016\u0010g\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010fR\u0018\u0010j\u001a\u0004\u0018\u00010h8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010iR\u0018\u0010l\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010kR\u0016\u0010n\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010mR\u0014\u0010q\u001a\u00020o8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bm\u0010pR\u0016\u0010t\u001a\u00020r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010sR\u001b\u0010z\u001a\u00020u8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bv\u0010w\u001a\u0004\bx\u0010yR\u0016\u0010|\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b{\u0010\u0019R(\u0010\u0083\u0001\u001a\u0004\u0018\u00010}8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0004\b\r\u0010~\u001a\u0005\b\u007f\u0010\u0080\u0001\"\u0006\b\u0081\u0001\u0010\u0082\u0001R\u0019\u0010\u0084\u0001\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bx\u0010[R\u001a\u0010\u0086\u0001\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b$\u0010\u0085\u0001R\u0017\u0010\u0089\u0001\u001a\u00030\u0087\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\bP\u0010\u0088\u0001R\u0019\u0010\u008a\u0001\u001a\u0004\u0018\u00010h8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010iR\u0017\u0010\u008b\u0001\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0019R&\u0010\u008e\u0001\u001a\u000b \u008c\u0001*\u0004\u0018\u00010Y0Y8BX\u0082\u0084\u0002\u00a2\u0006\r\n\u0004\b\u001c\u0010w\u001a\u0005\b{\u0010\u008d\u0001R\u0017\u0010\u0091\u0001\u001a\u00030\u008f\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u001b\u0010\u0090\u0001R\u0018\u0010\u0093\u0001\u001a\u00030\u008f\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0092\u0001\u0010\u0090\u0001R\u0017\u0010\u0096\u0001\u001a\u00030\u0094\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b#\u0010\u0095\u0001R\u0017\u0010\u0099\u0001\u001a\u00030\u0097\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0013\u0010\u0098\u0001R\u0017\u0010\u009c\u0001\u001a\u00030\u009a\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\bL\u0010\u009b\u0001R\u0017\u0010\u009d\u0001\u001a\u00030\u009a\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u001d\u0010\u009b\u0001R\u0017\u0010\u00a0\u0001\u001a\u00030\u009e\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u001a\u0010\u009f\u0001R\u0017\u0010\u00a3\u0001\u001a\u00030\u00a1\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\b\u0010\u00a2\u0001R\u0018\u0010\u00a7\u0001\u001a\u00030\u00a4\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a5\u0001\u0010\u00a6\u0001R\u0017\u0010\u00aa\u0001\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a8\u0001\u0010\u00a9\u0001R\u0018\u0010\u00ae\u0001\u001a\u00030\u00ab\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00ac\u0001\u0010\u00ad\u0001R\u0017\u0010\u00b1\u0001\u001a\u00030\u00af\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u001e\u0010\u00b0\u0001R\u001b\u0010\u00b4\u0001\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b2\u0001\u0010\u00b3\u0001R,\u0010\u00b6\u0001\u001a\u0005\u0018\u00010\u00b5\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00b6\u0001\u0010\u00b7\u0001\u001a\u0006\b\u00b8\u0001\u0010\u00b9\u0001\"\u0006\b\u00ba\u0001\u0010\u00bb\u0001\u00a8\u0006\u00c4\u0001"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/view/AnchorTopAreaView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/timi/game/liveroom/api/IRoomWidget;", "", CustomImageProps.QUALITY, "", "r0", "p0", "e0", "X", BdhLogUtil.LogTag.Tag_Req, "roomType", "Lcom/tencent/timi/game/liveroom/impl/room/toparea/TopAreaViewModel;", "M", UserInfo.SEX_FEMALE, "O", "", "anchorUid", ExifInterface.LATITUDE_SOUTH, "a0", "o0", "", "closeRoom", "H", "Y", "Z", "d0", "U", "T", "c0", "i0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "G", "J", "W", "P", "Landroidx/lifecycle/LifecycleOwner;", "owner", "setLifecycleOwner", "isAnchor", "setIsAnchor", "setAnchorTopHeadViewModel", "Lcom/tencent/timi/game/liveroom/impl/room/view/AnchorTopAreaView$d;", "l", "setListener", "Lcom/tencent/timi/game/liveroom/impl/room/view/AnchorTopAreaView$c;", "listener", "setUIVisibleChangedListener", "Lcom/tencent/timi/game/api/live/LiveRoomExtraInfo;", "extraInfo", "setLiveExtraInfo", "Landroid/content/Context;", "context", "setActivityContext", "isQQLive", "setQQLive", "Lvi4/a;", "audienceViewModel", "setAudienceViewModel", "roomId", "", AppConstants.Key.KEY_QZONE_VIDEO_URL, "onPreload", "onPageIn", "onPageOut", "setLiveRoomInfo", VirtualAppProxy.KEY_GAME_ID, "setGameId", "onEnterRoom", "Lcom/tencent/timi/game/liveroom/impl/room/view/rank/SelfRankInfoView$b;", "setOpenGiftPanelListener", "onExitRoom", NodeProps.VISIBLE, "setShowFansGroup", NodeProps.ON_DETACHED_FROM_WINDOW, "b0", "", "Ltrpc/yes/common/PendantOuterClass$PendantMsg;", "mutableList", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "d", "Lcom/tencent/timi/game/liveroom/impl/room/view/AnchorTopAreaView$d;", "mListener", "e", "mRoomId", "f", "mIsAnchor", tl.h.F, "Landroid/view/View;", "i", "Landroid/view/View;", "mHintView", "Lnr2/f;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lnr2/f;", "mHintViewBinding", BdhLogUtil.LogTag.Tag_Conn, "isDetachedFromWindow", "D", MiniChatConstants.MINI_APP_LANDSCAPE, "E", "Lcom/tencent/timi/game/api/live/LiveRoomExtraInfo;", "mLiveRoomExtraInfo", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "mPermissionDelayTask", "Landroid/content/Context;", "mActivityContext", "I", "mGameId", "Lcom/tencent/mobileqq/qqlive/callback/message/IQQCmdPushCallback;", "Lcom/tencent/mobileqq/qqlive/callback/message/IQQCmdPushCallback;", "timiCmdListener", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "mAegisLog", "Lcom/tencent/mobileqq/qqlive/callback/anchor/QQLiveAnchorRoomBaseCallback;", "K", "Lkotlin/Lazy;", "N", "()Lcom/tencent/mobileqq/qqlive/callback/anchor/QQLiveAnchorRoomBaseCallback;", "netQuaListener", "L", "mPip", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnClickListener;", "getMoreLivingClickListener", "()Landroid/view/View$OnClickListener;", "setMoreLivingClickListener", "(Landroid/view/View$OnClickListener;)V", "moreLivingClickListener", "moreLivingTipView", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/tencent/timi/game/liveroom/impl/room/view/AnchorTopAreaView$f;", "Lcom/tencent/timi/game/liveroom/impl/room/view/AnchorTopAreaView$f;", "operationAdsCallback", "fetchOperationAdsTaskForCancel", "hasClickRequestPermission", "kotlin.jvm.PlatformType", "()Landroid/view/View;", "fansQQGroupButton", "Lcom/tencent/image/URLImageView;", "Lcom/tencent/image/URLImageView;", "collapseIgv", "V", "minimizeRoomBtn", "Lcom/tencent/timi/game/liveroom/impl/room/view/head/AnchorTopHeadView;", "Lcom/tencent/timi/game/liveroom/impl/room/view/head/AnchorTopHeadView;", "topHeadView", "Lcom/tencent/timi/game/liveroom/impl/room/view/head/QQLiveRoomOnlineRankView;", "Lcom/tencent/timi/game/liveroom/impl/room/view/head/QQLiveRoomOnlineRankView;", "userRankContainer", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "moreLiveArea", "liveStatusArea", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "anchor_live_net_quality_icon", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "anchor_live_net_quality_text", "Lcom/tencent/timi/game/liveroom/impl/room/view/head/AnchorTopOperationView;", "f0", "Lcom/tencent/timi/game/liveroom/impl/room/view/head/AnchorTopOperationView;", "topOperationView", "g0", "Landroid/widget/FrameLayout;", "funGroupEntranceView", "Lcom/tencent/timi/game/liveroom/impl/room/view/subscript/AnchorSubscriptView;", "h0", "Lcom/tencent/timi/game/liveroom/impl/room/view/subscript/AnchorSubscriptView;", "anchorSubscript", "Lcom/tencent/mobileqq/msf/sdk/handler/INetEventHandler;", "Lcom/tencent/mobileqq/msf/sdk/handler/INetEventHandler;", "netEventHandler", "j0", "Lcom/tencent/timi/game/liveroom/impl/room/toparea/TopAreaViewModel;", "headViewModel", "Lcom/tencent/timi/game/liveroom/impl/room/view/AnchorTopAreaView$e;", "moreLivingShowListener", "Lcom/tencent/timi/game/liveroom/impl/room/view/AnchorTopAreaView$e;", "getMoreLivingShowListener", "()Lcom/tencent/timi/game/liveroom/impl/room/view/AnchorTopAreaView$e;", "setMoreLivingShowListener", "(Lcom/tencent/timi/game/liveroom/impl/room/view/AnchorTopAreaView$e;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "k0", "b", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class AnchorTopAreaView extends FrameLayout implements IRoomWidget {

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: l0, reason: collision with root package name */
    @NotNull
    private static final ArrayList<Integer> f378674l0;

    /* renamed from: m0, reason: collision with root package name */
    @NotNull
    private static final ArrayList<TianShuAdPosItemData> f378675m0;

    /* renamed from: n0, reason: collision with root package name */
    @NotNull
    private static final Lazy<BlockOptConfig> f378676n0;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isDetachedFromWindow;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isLandscape;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private LiveRoomExtraInfo mLiveRoomExtraInfo;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private Runnable mPermissionDelayTask;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private Context mActivityContext;

    /* renamed from: H, reason: from kotlin metadata */
    private int mGameId;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final IQQCmdPushCallback timiCmdListener;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private IAegisLogApi mAegisLog;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy netQuaListener;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean mPip;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private View.OnClickListener moreLivingClickListener;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private View moreLivingTipView;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private LifecycleOwner lifecycleOwner;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final f operationAdsCallback;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private Runnable fetchOperationAdsTaskForCancel;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean hasClickRequestPermission;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final Lazy fansQQGroupButton;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final URLImageView collapseIgv;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final URLImageView minimizeRoomBtn;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final AnchorTopHeadView topHeadView;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QQLiveRoomOnlineRankView userRankContainer;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinearLayout moreLiveArea;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinearLayout liveStatusArea;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private d mListener;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView anchor_live_net_quality_icon;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long mRoomId;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView anchor_live_net_quality_text;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mIsAnchor;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AnchorTopOperationView topOperationView;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FrameLayout funGroupEntranceView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long anchorUid;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AnchorSubscriptView anchorSubscript;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mHintView;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final INetEventHandler netEventHandler;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TopAreaViewModel headViewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private nr2.f mHintViewBinding;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019R\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R'\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00128\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/view/AnchorTopAreaView$b;", "", "Lqn4/a;", "blockOptConfig$delegate", "Lkotlin/Lazy;", "b", "()Lqn4/a;", "blockOptConfig", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "sTopBaseOperationAdIds", "Ljava/util/ArrayList;", "c", "()Ljava/util/ArrayList;", "", "BAD_NETWORK_TIME_INTERVAL", "J", "", "KEY_PIP", "Ljava/lang/String;", "LIVE_BASE_OPERATION_ID", "I", "TAG", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.timi.game.liveroom.impl.room.view.AnchorTopAreaView$b, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final BlockOptConfig b() {
            return (BlockOptConfig) AnchorTopAreaView.f378676n0.getValue();
        }

        @NotNull
        public final ArrayList<Integer> c() {
            return AnchorTopAreaView.f378674l0;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/view/AnchorTopAreaView$c;", "", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface c {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\n\u001a\u00020\tH&J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/view/AnchorTopAreaView$d;", "", "", "roomId", "", "c", "d", "a", "b", "", "onMoreClick", "e", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface d {
        void a(long roomId);

        void b(long roomId);

        void c(long roomId);

        void d(long roomId);

        void e(long roomId);

        boolean onMoreClick();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/view/AnchorTopAreaView$e;", "", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface e {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\t\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\"\u0010\r\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/view/AnchorTopAreaView$f;", "Lcom/tencent/mobileqq/tianshu/data/TianShuGetAdvCallback;", "", "result", "Lcooperation/vip/pb/TianShuAccess$GetAdsRsp;", "getAdsRsp", "", "onGetAdvs", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/timi/game/liveroom/impl/room/view/AnchorTopAreaView;", "kotlin.jvm.PlatformType", "d", "Ljava/lang/ref/WeakReference;", "anchorTopAreaViewWeakRef", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "e", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "mAegisLog", "anchorTopAreaView", "<init>", "(Lcom/tencent/timi/game/liveroom/impl/room/view/AnchorTopAreaView;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class f implements TianShuGetAdvCallback {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<AnchorTopAreaView> anchorTopAreaViewWeakRef;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final IAegisLogApi mAegisLog;

        public f(@NotNull AnchorTopAreaView anchorTopAreaView) {
            Intrinsics.checkNotNullParameter(anchorTopAreaView, "anchorTopAreaView");
            this.anchorTopAreaViewWeakRef = new WeakReference<>(anchorTopAreaView);
            QRouteApi api = QRoute.api(IAegisLogApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
            this.mAegisLog = (IAegisLogApi) api;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(List data, f this$0) {
            Object firstOrNull;
            Intrinsics.checkNotNullParameter(data, "$data");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) data);
            OperationData operationData = (OperationData) firstOrNull;
            if (operationData == null) {
                this$0.mAegisLog.e("AnchorTopAreaView_", 1, "requestOperationAds empty ad");
                return;
            }
            this$0.mAegisLog.i("AnchorTopAreaView_", 1, "requestOperationAds show ad:" + operationData);
            AnchorTopAreaView anchorTopAreaView = this$0.anchorTopAreaViewWeakRef.get();
            if (anchorTopAreaView != null) {
                AnchorTopOperationView anchorTopOperationView = anchorTopAreaView.topOperationView;
                if (anchorTopOperationView != null) {
                    anchorTopOperationView.setData(operationData);
                    return;
                }
                return;
            }
            this$0.mAegisLog.i("AnchorTopAreaView_", "postUI topAreaView is null");
        }

        @Override // com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback
        public void onGetAdvs(boolean result, @Nullable TianShuAccess.GetAdsRsp getAdsRsp) {
            this.mAegisLog.i("AnchorTopAreaView_", 1, "requestOperationAds result:" + result + ", getAdsRsp:" + getAdsRsp);
            if (getAdsRsp == null) {
                return;
            }
            if (this.anchorTopAreaViewWeakRef.get() == null) {
                this.mAegisLog.i("AnchorTopAreaView_", "topAreaView is null");
            } else {
                final List d16 = af4.g.d(af4.g.f26031a, getAdsRsp, AnchorTopAreaView.INSTANCE.c(), 0, 4, null);
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.view.ad
                    @Override // java.lang.Runnable
                    public final void run() {
                        AnchorTopAreaView.f.b(d16, this);
                    }
                });
            }
        }
    }

    static {
        Lazy<BlockOptConfig> lazy;
        ArrayList<Integer> arrayList = new ArrayList<>();
        f378674l0 = arrayList;
        ArrayList<TianShuAdPosItemData> arrayList2 = new ArrayList<>();
        f378675m0 = arrayList2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<BlockOptConfig>() { // from class: com.tencent.timi.game.liveroom.impl.room.view.AnchorTopAreaView$Companion$blockOptConfig$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final BlockOptConfig invoke() {
                return new BlockOptConfig(false, false, false, false, false, 31, null);
            }
        });
        f378676n0 = lazy;
        arrayList.add(878);
        TianShuAdPosItemData tianShuAdPosItemData = new TianShuAdPosItemData();
        tianShuAdPosItemData.mPosId = 878;
        tianShuAdPosItemData.mNeedCnt = 1;
        arrayList2.add(tianShuAdPosItemData);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnchorTopAreaView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void F() {
        String str;
        HashMap hashMap = new HashMap();
        if (!this.mIsAnchor) {
            if (this.isLandscape) {
                str = "1";
            } else {
                str = "0";
            }
            hashMap.put("qqlive_screen_orientation", str);
            mm4.a b16 = mm4.b.b(ug4.a.class);
            Intrinsics.checkNotNullExpressionValue(b16, "getService(ILiveReportService::class.java)");
            a.C11346a.a((ug4.a) b16, this.collapseIgv, false, null, "em_qqlive_room_mini", hashMap, 6, null);
        }
    }

    private final boolean G(ViewGroup parent) {
        RelativeLayout relativeLayout;
        if (this.mHintView == null) {
            nr2.f g16 = nr2.f.g(LayoutInflater.from(getContext()));
            this.mHintViewBinding = g16;
            if (g16 != null) {
                relativeLayout = g16.getRoot();
            } else {
                relativeLayout = null;
            }
            this.mHintView = relativeLayout;
            return true;
        }
        return false;
    }

    private final void H(boolean closeRoom) {
        Activity activity;
        d dVar;
        Context context = this.mActivityContext;
        if (context instanceof Activity) {
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity == null) {
            activity = vf4.a.b();
        }
        if (activity == null) {
            this.mAegisLog.e("AnchorTopAreaView_", "miss ac context to start portal page\uff01");
            return;
        }
        this.mAegisLog.i("AnchorTopAreaView_", "start portal page context:" + activity);
        if (com.tencent.timi.game.liveroom.impl.room.manager.b.INSTANCE.a()) {
            R();
            View.OnClickListener onClickListener = this.moreLivingClickListener;
            if (onClickListener != null) {
                onClickListener.onClick(this.moreLiveArea);
                return;
            }
            return;
        }
        ((IQQLivePortalServer) QRoute.api(IQQLivePortalServer.class)).goToPortal(activity, 22, 0);
        d dVar2 = this.mListener;
        if (dVar2 != null) {
            dVar2.e(this.mRoomId);
        }
        if (closeRoom && (dVar = this.mListener) != null) {
            dVar.b(this.mRoomId);
        }
    }

    static /* synthetic */ void I(AnchorTopAreaView anchorTopAreaView, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        anchorTopAreaView.H(z16);
    }

    private final void J() {
        boolean W = W();
        this.mAegisLog.i("AnchorTopAreaView_", "fetchOperationData start needFetch:" + W);
        if (!W) {
            return;
        }
        Companion companion = INSTANCE;
        if (!companion.b().getGameRoomFetchOperationAds()) {
            return;
        }
        if (companion.b().getGameRoomFetchOperationAdsInSubThread()) {
            Runnable runnable = this.fetchOperationAdsTaskForCancel;
            if (runnable != null) {
                ThreadManagerV2.removeJob(runnable, 128);
            }
            this.fetchOperationAdsTaskForCancel = ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.view.p
                @Override // java.lang.Runnable
                public final void run() {
                    AnchorTopAreaView.K(AnchorTopAreaView.this);
                }
            }, 128, null, true, 0L);
            return;
        }
        af4.g.f26031a.h(this.operationAdsCallback, f378675m0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(AnchorTopAreaView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mAegisLog.i("AnchorTopAreaView_", "fetchOperationData scheduled");
        af4.g.f26031a.h(this$0.operationAdsCallback, f378675m0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View L() {
        return (View) this.fansQQGroupButton.getValue();
    }

    private final TopAreaViewModel M(int roomType) {
        TopAreaViewModel bVar;
        TopAreaViewModel topAreaViewModel = this.headViewModel;
        if (topAreaViewModel != null) {
            Intrinsics.checkNotNull(topAreaViewModel);
            return topAreaViewModel;
        }
        if (roomType == 2) {
            bVar = new com.tencent.timi.game.liveroom.impl.room.toparea.c();
        } else {
            bVar = new com.tencent.timi.game.liveroom.impl.room.toparea.b();
        }
        this.headViewModel = bVar;
        return bVar;
    }

    private final QQLiveAnchorRoomBaseCallback N() {
        return (QQLiveAnchorRoomBaseCallback) this.netQuaListener.getValue();
    }

    private final int O() {
        return this.mLiveRoomExtraInfo.f376293f;
    }

    private final void R() {
        View view = this.moreLivingTipView;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private final void S(long anchorUid) {
        this.anchorUid = anchorUid;
        this.userRankContainer.setAnchorId(anchorUid);
    }

    private final void T() {
        QQLiveAnchorStreamRecordType qQLiveAnchorStreamRecordType;
        boolean z16;
        IQQLiveAnchorRoom J3 = ((jg4.b) mm4.b.b(jg4.b.class)).J3(this.mRoomId);
        if (J3 != null) {
            J3.registerAnchorCallback(N());
            QQLiveAnchorRoomConfig roomConfig = J3.getRoomConfig();
            QQLiveAnchorStreamRecordType qQLiveAnchorStreamRecordType2 = null;
            if (roomConfig != null) {
                qQLiveAnchorStreamRecordType = roomConfig.streamRecordType;
            } else {
                qQLiveAnchorStreamRecordType = null;
            }
            int i3 = 0;
            if (qQLiveAnchorStreamRecordType != QQLiveAnchorStreamRecordType.THIRD_PUSH) {
                QQLiveAnchorRoomConfig roomConfig2 = J3.getRoomConfig();
                if (roomConfig2 != null) {
                    qQLiveAnchorStreamRecordType2 = roomConfig2.streamRecordType;
                }
                if (qQLiveAnchorStreamRecordType2 != QQLiveAnchorStreamRecordType.THIRD_PUSH_BROADCAST) {
                    z16 = false;
                    LinearLayout linearLayout = this.liveStatusArea;
                    if (this.mIsAnchor || z16) {
                        i3 = 8;
                    }
                    linearLayout.setVisibility(i3);
                }
            }
            z16 = true;
            LinearLayout linearLayout2 = this.liveStatusArea;
            if (this.mIsAnchor) {
            }
            i3 = 8;
            linearLayout2.setVisibility(i3);
        }
    }

    private final boolean U() {
        if (this.minimizeRoomBtn.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(PopupWindow this_apply, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this_apply.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final boolean W() {
        if (wj4.c.a(this.mRoomId) == 1) {
            return true;
        }
        return false;
    }

    private final void X() {
        d dVar;
        if (this.hasClickRequestPermission && com.tencent.timi.game.utils.g.c(getContext()) && (dVar = this.mListener) != null) {
            dVar.d(this.mRoomId);
        }
        this.hasClickRequestPermission = false;
    }

    private final void Y() {
        this.collapseIgv.setVisibility(0);
    }

    private final void Z() {
        if (this.mIsAnchor) {
            this.minimizeRoomBtn.setVisibility(8);
        }
        if (this.mLiveRoomExtraInfo.f376293f == 2) {
            this.minimizeRoomBtn.setVisibility(8);
        }
    }

    private final void a0() {
        boolean z16 = true;
        this.mAegisLog.e("AnchorTopAreaView_", 1, "refreshMoreLiveUI jumpSource:" + this.mLiveRoomExtraInfo.F + ",  mPip:" + this.mPip + ", mIsAnchor:" + this.mIsAnchor);
        int i3 = 0;
        if (!this.mIsAnchor && !BusConfigHelper.f378723a.f(17, this.mRoomId)) {
            z16 = false;
        }
        if (z16) {
            i3 = 8;
        }
        if (this.moreLiveArea.getVisibility() != i3) {
            this.moreLiveArea.setVisibility(i3);
        }
        if (!z16) {
            o0();
        }
    }

    private final void c0() {
        if (this.mIsAnchor) {
            ((ug4.a) mm4.b.b(ug4.a.class)).a(this.funGroupEntranceView, true, null, "em_qqlive_fangroup_entrance", new LinkedHashMap());
        }
    }

    private final void d0() {
        String str;
        if (!this.mIsAnchor && this.minimizeRoomBtn.getVisibility() == 0) {
            HashMap hashMap = new HashMap();
            if (this.isLandscape) {
                str = "1";
            } else {
                str = "0";
            }
            hashMap.put("qqlive_screen_orientation", str);
            mm4.a b16 = mm4.b.b(ug4.a.class);
            Intrinsics.checkNotNullExpressionValue(b16, "getService(ILiveReportService::class.java)");
            a.C11346a.a((ug4.a) b16, this.minimizeRoomBtn, false, null, "em_qqlive_room_window", hashMap, 6, null);
        }
    }

    private final void e0() {
        com.tencent.timi.game.utils.g.h(getContext(), new DialogInterface.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.view.s
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                AnchorTopAreaView.f0(AnchorTopAreaView.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.view.t
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                AnchorTopAreaView.g0(AnchorTopAreaView.this, dialogInterface, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(AnchorTopAreaView this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).requestPermission(this$0.getContext());
        this$0.hasClickRequestPermission = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(AnchorTopAreaView this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
        this$0.hasClickRequestPermission = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void i0() {
        ViewParent parent = getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) parent;
        G(viewGroup);
        viewGroup.removeView(this.mHintView);
        viewGroup.addView(this.mHintView, new ViewGroup.LayoutParams(-1, -1));
        final nr2.f fVar = this.mHintViewBinding;
        if (fVar == null) {
            return;
        }
        Rect rect = new Rect();
        this.collapseIgv.getGlobalVisibleRect(rect);
        final int b16 = rect.bottom + fh4.b.b(3);
        fVar.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.view.ac
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnchorTopAreaView.j0(nr2.f.this, view);
            }
        });
        fVar.f421055c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.view.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnchorTopAreaView.k0(AnchorTopAreaView.this, fVar, view);
            }
        });
        fVar.f421057e.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.view.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnchorTopAreaView.l0(AnchorTopAreaView.this, fVar, view);
            }
        });
        HashMap hashMap = new HashMap();
        mm4.a b17 = mm4.b.b(ug4.a.class);
        Intrinsics.checkNotNullExpressionValue(b17, "getService(ILiveReportService::class.java)");
        TextView textView = fVar.f421055c;
        Intrinsics.checkNotNullExpressionValue(textView, "hintView.collapseTxv");
        a.C11346a.a((ug4.a) b17, textView, false, null, "em_qqlive_room_mini", hashMap, 6, null);
        mm4.a b18 = mm4.b.b(ug4.a.class);
        Intrinsics.checkNotNullExpressionValue(b18, "getService(ILiveReportService::class.java)");
        TextView textView2 = fVar.f421057e;
        Intrinsics.checkNotNullExpressionValue(textView2, "hintView.endLiveTxv");
        a.C11346a.a((ug4.a) b18, textView2, false, null, "em_qqlive_living_end", hashMap, 6, null);
        VideoReport.traversePage(viewGroup);
        post(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.view.o
            @Override // java.lang.Runnable
            public final void run() {
                AnchorTopAreaView.m0(nr2.f.this, b16, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(nr2.f hintView, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(hintView, "$hintView");
        hintView.getRoot().setVisibility(8);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(AnchorTopAreaView this$0, nr2.f hintView, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(hintView, "$hintView");
        d dVar = this$0.mListener;
        if (dVar != null) {
            dVar.c(this$0.mRoomId);
        }
        hintView.getRoot().setVisibility(8);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(AnchorTopAreaView this$0, nr2.f hintView, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(hintView, "$hintView");
        d dVar = this$0.mListener;
        if (dVar != null) {
            dVar.a(this$0.mRoomId);
        }
        hintView.getRoot().setVisibility(8);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(final nr2.f hintView, int i3, AnchorTopAreaView this$0) {
        Intrinsics.checkNotNullParameter(hintView, "$hintView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewGroup.LayoutParams layoutParams = hintView.f421056d.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.topMargin = i3;
        hintView.f421056d.setLayoutParams(layoutParams2);
        this$0.post(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.view.q
            @Override // java.lang.Runnable
            public final void run() {
                AnchorTopAreaView.n0(nr2.f.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(nr2.f hintView) {
        Intrinsics.checkNotNullParameter(hintView, "$hintView");
        hintView.f421056d.setVisibility(0);
        hintView.getRoot().setVisibility(0);
    }

    private final void o0() {
        String str;
        HashMap hashMap = new HashMap();
        if (this.isLandscape) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("qqlive_screen_orientation", str);
        mm4.a b16 = mm4.b.b(ug4.a.class);
        Intrinsics.checkNotNullExpressionValue(b16, "getService(ILiveReportService::class.java)");
        a.C11346a.a((ug4.a) b16, this.moreLiveArea, false, null, "em_qqlive_morelives", hashMap, 6, null);
    }

    private final void p0() {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.view.ab
            @Override // java.lang.Runnable
            public final void run() {
                AnchorTopAreaView.q0(AnchorTopAreaView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(AnchorTopAreaView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.tencent.timi.game.utils.o.f("netErrorToastTag", MiniBoxNoticeInfo.MIN_5)) {
            QQToast.makeText(this$0.getContext(), "\u5f53\u524d\u7f51\u7edc\u4e0d\u4f73\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc\u8bbe\u7f6e", 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r0(final int quality) {
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.view.r
            @Override // java.lang.Runnable
            public final void run() {
                AnchorTopAreaView.s0(quality, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(AnchorTopAreaView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (com.tencent.timi.game.utils.o.a()) {
            QLog.i("AnchorTopAreaView_", 1, "collapseIgv double click");
        } else if (this$0.mIsAnchor) {
            this$0.i0();
        } else if (this$0.mPip) {
            d dVar = this$0.mListener;
            if (dVar != null) {
                dVar.c(this$0.mRoomId);
            }
        } else {
            d dVar2 = this$0.mListener;
            if (dVar2 != null) {
                dVar2.b(this$0.mRoomId);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(int i3, AnchorTopAreaView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        switch (i3) {
            case 0:
            case 1:
            case 2:
                this$0.anchor_live_net_quality_icon.setImageDrawable(ResourcesCompat.getDrawable(this$0.getResources(), R.drawable.o5w, null));
                this$0.anchor_live_net_quality_text.setText(this$0.getResources().getString(R.string.yvr));
                return;
            case 3:
            case 4:
                this$0.anchor_live_net_quality_icon.setImageDrawable(ResourcesCompat.getDrawable(this$0.getResources(), R.drawable.o5x, null));
                this$0.anchor_live_net_quality_text.setText(this$0.getResources().getString(R.string.yvs));
                return;
            case 5:
            case 6:
                this$0.anchor_live_net_quality_icon.setImageDrawable(ResourcesCompat.getDrawable(this$0.getResources(), R.drawable.o5y, null));
                this$0.anchor_live_net_quality_text.setText(this$0.getResources().getString(R.string.yvt));
                this$0.p0();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(AnchorTopAreaView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (com.tencent.timi.game.utils.o.a()) {
            QLog.i("AnchorTopAreaView_", 1, "minimizeBtn double click");
        } else {
            this$0.P();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(AnchorTopAreaView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.X();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(AnchorTopAreaView this$0, View view) {
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.tencent.timi.game.utils.o.a()) {
            d dVar = this$0.mListener;
            if (dVar != null && dVar.onMoreClick()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                I(this$0, false, 1, null);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(Context context, AnchorTopAreaView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AnchorLiveSystemInfoDetailView anchorLiveSystemInfoDetailView = new AnchorLiveSystemInfoDetailView(context);
        anchorLiveSystemInfoDetailView.O0(this$0.mRoomId);
        com.tencent.timi.game.liveroom.impl.room.util.h hVar = new com.tencent.timi.game.liveroom.impl.room.util.h();
        hVar.t(false);
        hVar.v(-1);
        hVar.u(ImmersiveUtils.dpToPx(390.0f));
        hVar.x(true);
        hVar.q(R.style.b0e);
        Unit unit = Unit.INSTANCE;
        final PopupWindow e16 = com.tencent.timi.game.liveroom.impl.room.util.g.e(context, anchorLiveSystemInfoDetailView, hVar);
        anchorLiveSystemInfoDetailView.getBinding().f420740c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.view.aa
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AnchorTopAreaView.V(e16, view2);
            }
        });
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(AnchorTopAreaView this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!z16) {
            this$0.p0();
        }
    }

    public final void P() {
        if (!this.mIsAnchor) {
            this.mAegisLog.i("AnchorTopAreaView_", "handleClickMinimizeBtn:" + this.mRoomId);
            if (U()) {
                if (com.tencent.timi.game.utils.g.c(getContext())) {
                    d dVar = this.mListener;
                    if (dVar != null) {
                        dVar.d(this.mRoomId);
                        return;
                    }
                    return;
                }
                e0();
                return;
            }
            d dVar2 = this.mListener;
            if (dVar2 != null) {
                dVar2.b(this.mRoomId);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Q(@Nullable List<PendantOuterClass$PendantMsg> mutableList) {
        PendantOuterClass$PendantMsg pendantOuterClass$PendantMsg = null;
        if (mutableList != null) {
            Iterator<T> it = mutableList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((PendantOuterClass$PendantMsg) next).content.sub_script.has()) {
                    pendantOuterClass$PendantMsg = next;
                    break;
                }
            }
            pendantOuterClass$PendantMsg = pendantOuterClass$PendantMsg;
        }
        this.anchorSubscript.C0(pendantOuterClass$PendantMsg);
    }

    public final void b0(long roomId) {
        this.userRankContainer.setContentByConfig(roomId);
        BusConfigHelper busConfigHelper = BusConfigHelper.f378723a;
        uq4.c cVar = busConfigHelper.j().get(Long.valueOf(roomId));
        if (cVar != null) {
            if (busConfigHelper.g(2, cVar)) {
                this.topOperationView.setVisibility(8);
            } else {
                this.topOperationView.f();
            }
            this.topHeadView.Y(busConfigHelper.d(roomId));
            a0();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        AppNetConnInfo.unregisterNetEventHandler(this.netEventHandler);
        super.onDetachedFromWindow();
        this.isDetachedFromWindow = true;
    }

    @Override // com.tencent.timi.game.liveroom.api.IRoomWidget
    public void onEnterRoom(long roomId, boolean isAnchor) {
        this.mAegisLog.i("AnchorTopAreaView_", 1, "onEnterRoom roomId:" + roomId + ", isAnchor:" + isAnchor);
        this.mRoomId = roomId;
        this.mIsAnchor = isAnchor;
        this.userRankContainer.setRoomType(O());
        this.userRankContainer.onEnterRoom(roomId, isAnchor);
        this.topHeadView.setRoomType(O());
        this.topHeadView.onEnterRoom(roomId, isAnchor);
        Y();
        Z();
        a0();
        d0();
        F();
        c0();
        b0(roomId);
        this.topOperationView.d(this.mGameId, this.mRoomId);
        J();
        ((jg4.b) mm4.b.b(jg4.b.class)).Y1(isAnchor).a(this.timiCmdListener);
        T();
    }

    @Override // com.tencent.timi.game.liveroom.api.IRoomWidget
    public void onExitRoom(long roomId) {
        this.userRankContainer.onExitRoom(roomId);
        this.topHeadView.onExitRoom(roomId);
        ((jg4.b) mm4.b.b(jg4.b.class)).Y1(this.mIsAnchor).b(this.timiCmdListener);
        IQQLiveAnchorRoom J3 = ((jg4.b) mm4.b.b(jg4.b.class)).J3(this.mRoomId);
        if (J3 != null) {
            J3.unRegisterAnchorCallback(N());
        }
        R();
        this.topOperationView.e();
        this.moreLivingClickListener = null;
    }

    @Override // com.tencent.timi.game.liveroom.api.IRoomWidget
    public void onPageIn(long roomId) {
        this.userRankContainer.onPageIn(roomId);
        this.topHeadView.onPageIn(roomId);
    }

    @Override // com.tencent.timi.game.liveroom.api.IRoomWidget
    public void onPageOut(long roomId) {
        this.userRankContainer.onPageOut(roomId);
        this.topHeadView.onPageOut(roomId);
    }

    @Override // com.tencent.timi.game.liveroom.api.IRoomWidget
    public void onPreload(long roomId, boolean isAnchor, @Nullable String videoUrl) {
        this.mRoomId = roomId;
        this.mIsAnchor = isAnchor;
        this.userRankContainer.setRoomType(O());
        this.userRankContainer.onPreload(roomId, isAnchor, videoUrl);
        this.topHeadView.setRoomType(O());
        this.topHeadView.onPreload(roomId, isAnchor, videoUrl);
        a0();
    }

    public final void setActivityContext(@Nullable Context context) {
        this.mActivityContext = context;
    }

    public final void setAnchorTopHeadViewModel() {
        this.topHeadView.setViewModel(new com.tencent.timi.game.liveroom.impl.room.toparea.b());
    }

    public final void setAudienceViewModel(@NotNull vi4.a audienceViewModel) {
        Intrinsics.checkNotNullParameter(audienceViewModel, "audienceViewModel");
        this.userRankContainer.setAudienceViewModel(audienceViewModel);
    }

    public final void setGameId(int gameId) {
        this.mGameId = gameId;
    }

    public final void setIsAnchor(boolean isAnchor) {
        this.mIsAnchor = isAnchor;
        Z();
    }

    public final void setLifecycleOwner(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.lifecycleOwner = owner;
        this.topHeadView.setLifecycle(owner);
    }

    public final void setListener(@NotNull d l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        this.mListener = l3;
    }

    public final void setLiveExtraInfo(@NotNull LiveRoomExtraInfo extraInfo) {
        TopAreaViewModel topAreaViewModel;
        LiveData<rr4.e> w3;
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        this.mLiveRoomExtraInfo = extraInfo;
        String string = extraInfo.E.getString("pip");
        boolean z16 = false;
        if (string != null && Boolean.parseBoolean(string)) {
            z16 = true;
        }
        this.mPip = z16;
        a0();
        Y();
        Z();
        this.topHeadView.setViewModel(M(extraInfo.f376293f));
        this.topHeadView.Q(extraInfo.E.getString("ext_anchor_nick", ""), extraInfo.E.getString("ext_anchor_head", ""));
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        if (lifecycleOwner != null && (topAreaViewModel = this.headViewModel) != null && (w3 = topAreaViewModel.w()) != null) {
            final AnchorTopAreaView$setLiveExtraInfo$1$1 anchorTopAreaView$setLiveExtraInfo$1$1 = new AnchorTopAreaView$setLiveExtraInfo$1$1(this);
            w3.observe(lifecycleOwner, new Observer() { // from class: com.tencent.timi.game.liveroom.impl.room.view.z
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    AnchorTopAreaView.h0(Function1.this, obj);
                }
            });
        }
    }

    public final void setLiveRoomInfo(long anchorUid) {
        S(anchorUid);
    }

    public final void setMoreLivingClickListener(@Nullable View.OnClickListener onClickListener) {
        this.moreLivingClickListener = onClickListener;
    }

    public final void setOpenGiftPanelListener(@NotNull SelfRankInfoView.b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.userRankContainer.setOpenGiftPanelListener(listener);
    }

    public final void setQQLive(boolean isQQLive) {
        this.topHeadView.setQQLive();
    }

    public final void setUIVisibleChangedListener(@NotNull c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnchorTopAreaView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ AnchorTopAreaView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnchorTopAreaView(@NotNull final Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        this.mLiveRoomExtraInfo = new LiveRoomExtraInfo();
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.mAegisLog = (IAegisLogApi) api;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AnchorTopAreaView$netQuaListener$2.a>() { // from class: com.tencent.timi.game.liveroom.impl.room.view.AnchorTopAreaView$netQuaListener$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/view/AnchorTopAreaView$netQuaListener$2$a", "Lcom/tencent/mobileqq/qqlive/callback/anchor/QQLiveAnchorRoomBaseCallback;", "Lcom/tencent/mobileqq/qqlive/data/anchor/room/AnchorLiveSystemInfo;", "info", "", "onAnchorLiveNetStatus", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes26.dex */
            public static final class a extends QQLiveAnchorRoomBaseCallback {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ AnchorTopAreaView f378696d;

                a(AnchorTopAreaView anchorTopAreaView) {
                    this.f378696d = anchorTopAreaView;
                }

                @Override // com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorLiveStatusCallBack
                public void onAnchorLiveNetStatus(@NotNull AnchorLiveSystemInfo info) {
                    Intrinsics.checkNotNullParameter(info, "info");
                    if (!com.tencent.timi.game.utils.o.f("anchorLiveStatusTag", 60000L)) {
                        AegisLogger.INSTANCE.i(AegisLogger.ROOM_INFO, "onAnchorLiveNetStatus", "\u4e0a\u4f20\u901f\u5ea6: " + info.getUpSourceSpeed() + ", \u76f4\u64ad\u5ef6\u8fdf: " + info.getGateWayRtt() + ", \u4e22\u5305\u7387: " + info.getUpSourceLoss() + ", CPU\u5360\u7528\u7387: " + info.getCpuStatus() + ", \u5185\u5b58\u5360\u7528\u7387: " + info.getMemoryRate());
                    }
                    this.f378696d.r0(info.getAnchorLiveNetQuality());
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a(AnchorTopAreaView.this);
            }
        });
        this.netQuaListener = lazy;
        this.operationAdsCallback = new f(this);
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.timi.game.liveroom.impl.room.view.AnchorTopAreaView$fansQQGroupButton$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                return ((ViewStub) AnchorTopAreaView.this.findViewById(R.id.uzv)).inflate();
            }
        });
        this.fansQQGroupButton = lazy2;
        View.inflate(context, R.layout.ht8, this);
        View findViewById = findViewById(R.id.u0f);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.collapseIgv)");
        URLImageView uRLImageView = (URLImageView) findViewById;
        this.collapseIgv = uRLImageView;
        View findViewById2 = findViewById(R.id.zbr);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.minimizeRoomBtn)");
        URLImageView uRLImageView2 = (URLImageView) findViewById2;
        this.minimizeRoomBtn = uRLImageView2;
        View findViewById3 = findViewById(R.id.f99535q2);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.topHeadView)");
        this.topHeadView = (AnchorTopHeadView) findViewById3;
        View findViewById4 = findViewById(R.id.f115046uz);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.userRankContainer)");
        QQLiveRoomOnlineRankView qQLiveRoomOnlineRankView = (QQLiveRoomOnlineRankView) findViewById4;
        this.userRankContainer = qQLiveRoomOnlineRankView;
        View findViewById5 = findViewById(R.id.zdt);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.moreLiveArea)");
        LinearLayout linearLayout = (LinearLayout) findViewById5;
        this.moreLiveArea = linearLayout;
        View findViewById6 = findViewById(R.id.ykh);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.liveStatusArea)");
        LinearLayout linearLayout2 = (LinearLayout) findViewById6;
        this.liveStatusArea = linearLayout2;
        View findViewById7 = findViewById(R.id.soa);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.anchor_live_net_quality_icon)");
        this.anchor_live_net_quality_icon = (ImageView) findViewById7;
        View findViewById8 = findViewById(R.id.sob);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.anchor_live_net_quality_text)");
        this.anchor_live_net_quality_text = (TextView) findViewById8;
        View findViewById9 = findViewById(R.id.f99595q8);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.topOperationView)");
        this.topOperationView = (AnchorTopOperationView) findViewById9;
        View findViewById10 = findViewById(R.id.f165308vh0);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.funGroupEntranceView)");
        this.funGroupEntranceView = (FrameLayout) findViewById10;
        View findViewById11 = findViewById(R.id.snm);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(R.id.anchorSubscript)");
        this.anchorSubscript = (AnchorSubscriptView) findViewById11;
        RFWTypefaceUtil.preloadTypeface("https://downv6.qq.com/video_story/qcircle/ttf/qvideo-digit-Bold.ttf");
        uRLImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.view.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnchorTopAreaView.s(AnchorTopAreaView.this, view);
            }
        });
        uRLImageView.setImageResource(R.drawable.l8w);
        uRLImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.view.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnchorTopAreaView.t(AnchorTopAreaView.this, view);
            }
        });
        uRLImageView2.setImageResource(R.drawable.nst);
        this.mPermissionDelayTask = new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.view.v
            @Override // java.lang.Runnable
            public final void run() {
                AnchorTopAreaView.u(AnchorTopAreaView.this);
            }
        };
        this.timiCmdListener = new a();
        qQLiveRoomOnlineRankView.y();
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.view.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnchorTopAreaView.v(AnchorTopAreaView.this, view);
            }
        });
        mm4.a b16 = mm4.b.b(ug4.a.class);
        Intrinsics.checkNotNullExpressionValue(b16, "getService(ILiveReportService::class.java)");
        a.C11346a.a((ug4.a) b16, linearLayout2, false, null, "em_qqlive_network_status", null, 22, null);
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.view.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AnchorTopAreaView.w(context, this, view);
            }
        });
        INetEventHandler iNetEventHandler = new INetEventHandler() { // from class: com.tencent.timi.game.liveroom.impl.room.view.y
            @Override // com.tencent.mobileqq.msf.sdk.handler.INetEventHandler
            public final void onNetChangeEvent(boolean z16) {
                AnchorTopAreaView.x(AnchorTopAreaView.this, z16);
            }
        };
        this.netEventHandler = iNetEventHandler;
        AppNetConnInfo.registerNetChangeReceiver(BaseApplication.getContext(), iNetEventHandler);
    }

    public final void setMoreLivingShowListener(@Nullable e eVar) {
    }

    public final void setShowFansGroup(boolean visible) {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/view/AnchorTopAreaView$a", "Lcom/tencent/mobileqq/qqlive/callback/message/IQQCmdPushCallback;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "onFail", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements IQQCmdPushCallback {
        a() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback
        public void onReceive(@Nullable byte[] data) {
            List<PendantOuterClass$PendantMsg> mutableListOf;
            MessageOuterClass$TimMsgBody a16 = zk4.a.f452717a.a(data);
            if (a16 != null) {
                AnchorTopAreaView.this.mAegisLog.i("AnchorTopAreaView_", 1, "handleCmdMsg type:" + a16.msg_type.get());
                if (a16.msg_type.get() == 93) {
                    AnchorTopAreaView anchorTopAreaView = AnchorTopAreaView.this;
                    PendantOuterClass$PendantMsg pendantOuterClass$PendantMsg = a16.content.pendant_msg;
                    Intrinsics.checkNotNullExpressionValue(pendantOuterClass$PendantMsg, "msg.content.pendant_msg");
                    mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(pendantOuterClass$PendantMsg);
                    anchorTopAreaView.Q(mutableListOf);
                }
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback
        public void onFail(int errCode, @Nullable String errMsg) {
        }
    }
}

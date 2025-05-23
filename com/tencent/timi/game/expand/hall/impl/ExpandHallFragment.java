package com.tencent.timi.game.expand.hall.impl;

import ag4.h;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.performance.report.IGuildPerformanceReportApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.timi.game.api.cb.ExpandHallListener;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import com.tencent.timi.game.base.TimiGameBaseFragment;
import com.tencent.timi.game.component.chat.ChatView;
import com.tencent.timi.game.component.chat.ConvType;
import com.tencent.timi.game.component.chat.GroupChatView;
import com.tencent.timi.game.component.chat.input.TimiBaseInputView;
import com.tencent.timi.game.component.chat.message.n;
import com.tencent.timi.game.component.gamecore.api.view.GameAuthAndBindHintView;
import com.tencent.timi.game.emo.ui.TimiEmoPanelView;
import com.tencent.timi.game.expand.hall.impl.ExpandHallFragment;
import com.tencent.timi.game.expand.hall.impl.mic.view.MicCardView;
import com.tencent.timi.game.expand.hall.impl.operation.HallOperationContainer;
import com.tencent.timi.game.expand.hall.impl.presenter.OnlineUserViewModel;
import com.tencent.timi.game.expand.hall.impl.view.OnlineUserHeaderView;
import com.tencent.timi.game.floatwindow.impl.animate.WorldScaleLayout;
import com.tencent.timi.game.gift.impl.timi.TimiGiftController;
import com.tencent.timi.game.teamlist.service.TeamInfoAutoUpdateService;
import com.tencent.timi.game.teamlist.view.TeamListView;
import com.tencent.timi.game.tgpa.TGPAUtil;
import com.tencent.timi.game.ui.widget.RoundCornerImageView;
import com.tencent.timi.game.ui.widget.TopCropImageView;
import com.tencent.timi.game.utils.o;
import com.tencent.timi.game.utils.u;
import com.tencent.timi.game.utils.w;
import com.tencent.timi.game.utils.x;
import com.tencent.widget.immersive.ImmersiveUtils;
import fm4.TeamCreatePageParam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mh4.i;
import mh4.l;
import mh4.m;
import mh4.q;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.api.IRuntimeService;
import nr2.bd;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import th4.a;
import th4.g;
import th4.k;
import th4.p;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.YesGameInfoOuterClass$GameConfigInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomSpeakingPosInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomUserData;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomUserWhiteList;
import trpc.yes.wuji.WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf;
import ug4.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00b9\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u00ba\u0001B\b\u00a2\u0006\u0005\b\u00b8\u0001\u0010yJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0010H\u0002J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0010H\u0002J\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u0010\u0010!\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u001fH\u0002J\u001c\u0010%\u001a\u00020\u00102\b\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010$\u001a\u0004\u0018\u00010\"H\u0002J\u0010\u0010(\u001a\u00020\u00102\u0006\u0010'\u001a\u00020&H\u0002J\b\u0010)\u001a\u00020\u0010H\u0002J\b\u0010*\u001a\u00020\u0010H\u0002J\b\u0010+\u001a\u00020\u0010H\u0002J\b\u0010,\u001a\u00020\u0010H\u0002J\u0012\u0010.\u001a\u00020\u00102\b\u0010-\u001a\u0004\u0018\u00010&H\u0016J&\u00104\u001a\u0004\u0018\u0001032\u0006\u00100\u001a\u00020/2\b\u00102\u001a\u0004\u0018\u0001012\b\u0010-\u001a\u0004\u0018\u00010&H\u0016J\u001a\u00106\u001a\u00020\u00102\u0006\u00105\u001a\u0002032\b\u0010-\u001a\u0004\u0018\u00010&H\u0016J\b\u00107\u001a\u00020\u0004H\u0016J\u001a\u00108\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u00109\u001a\u00020\u0010H\u0016J\b\u0010:\u001a\u00020\u0010H\u0016J\b\u0010;\u001a\u00020\u0004H\u0016J\u0010\u0010<\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010=\u001a\u00020\u0010H\u0016J\b\u0010>\u001a\u00020\u0010H\u0016J\b\u0010?\u001a\u00020\u0004H\u0016J\u0010\u0010B\u001a\u00020\u00102\b\u0010A\u001a\u0004\u0018\u00010@J\u0010\u0010C\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010E\u001a\u00020\u00102\u0006\u0010D\u001a\u00020\"H\u0016J\b\u0010G\u001a\u00020FH\u0016J\b\u0010H\u001a\u00020\u0010H\u0016J\b\u0010I\u001a\u00020\u0010H\u0016J\b\u0010J\u001a\u00020\u0010H\u0016J\b\u0010L\u001a\u00020KH\u0016J\b\u0010M\u001a\u00020\u001cH\u0016J\b\u0010O\u001a\u00020NH\u0016J\b\u0010P\u001a\u00020\u0006H\u0016J\n\u0010Q\u001a\u0004\u0018\u000101H\u0016J\n\u0010S\u001a\u0004\u0018\u00010RH\u0016J\n\u0010U\u001a\u0004\u0018\u00010TH\u0016J\b\u0010V\u001a\u00020\u0010H\u0016J\b\u0010W\u001a\u00020\u0004H\u0016J\b\u0010X\u001a\u00020\u0004H\u0016J\b\u0010Y\u001a\u00020\u0004H\u0016J\u0010\u0010[\u001a\u00020\u00042\u0006\u0010Z\u001a\u00020NH\u0016J\u0010\u0010\\\u001a\u00020\u00042\u0006\u0010Z\u001a\u00020NH\u0016J\u0010\u0010^\u001a\u00020\u00102\u0006\u0010]\u001a\u00020\u0004H\u0016J\u0010\u0010`\u001a\u00020\u00102\u0006\u0010_\u001a\u00020\u0004H\u0016J\b\u0010a\u001a\u00020\"H\u0016J\b\u0010b\u001a\u00020\u001cH\u0016J\n\u0010c\u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010d\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010g\u001a\u00020\u00102\b\u0010f\u001a\u0004\u0018\u00010eH\u0016J\b\u0010h\u001a\u000201H\u0016J\b\u0010i\u001a\u00020\u0010H\u0016R\u0016\u0010k\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010jR\u0016\u0010n\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010mR\u0016\u0010p\u001a\u00020K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010oR\u0018\u0010r\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010qR\u0016\u0010s\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010mR\u0014\u0010v\u001a\u00020N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bt\u0010uR\u001c\u0010z\u001a\u00020\u001c8\u0002@\u0002X\u0083\u000e\u00a2\u0006\f\n\u0004\bw\u0010j\u0012\u0004\bx\u0010yR\u001c\u0010}\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\f\n\u0004\b{\u0010m\u0012\u0004\b|\u0010yR\u0019\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b~\u0010\u007fR\u0019\u0010\u0083\u0001\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001c\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0084\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R\u001c\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u0088\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R\u001c\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u008c\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R\u001c\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0090\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0091\u0001\u0010\u0092\u0001R\u001c\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0094\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001R\u0019\u0010\u009a\u0001\u001a\u00020F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0098\u0001\u0010\u0099\u0001R\u001c\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009b\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009c\u0001\u0010\u009d\u0001R\u001c\u0010\u00a2\u0001\u001a\u0005\u0018\u00010\u009f\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a0\u0001\u0010\u00a1\u0001R\u001c\u0010\u00a6\u0001\u001a\u0005\u0018\u00010\u00a3\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a4\u0001\u0010\u00a5\u0001R\u001c\u0010\u00a9\u0001\u001a\u0005\u0018\u00010\u00a7\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0082\u0001\u0010\u00a8\u0001R\u001b\u0010\u00ac\u0001\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00aa\u0001\u0010\u00ab\u0001R\u0018\u0010\u00b0\u0001\u001a\u00030\u00ad\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00ae\u0001\u0010\u00af\u0001R\u001b\u0010\u00b3\u0001\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b1\u0001\u0010\u00b2\u0001R\u001a\u0010\u00b7\u0001\u001a\u00030\u00b4\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u00b5\u0001\u0010\u00b6\u0001\u00a8\u0006\u00bb\u0001"}, d2 = {"Lcom/tencent/timi/game/expand/hall/impl/ExpandHallFragment;", "Lcom/tencent/timi/game/base/TimiGameBaseFragment;", "Lcom/tencent/timi/game/component/chat/at/d;", "Lgh4/e;", "", "Ih", "", "keyCode", "Landroid/view/KeyEvent;", "event", "Lh", "exitSource", "Mh", "Landroid/view/MotionEvent;", "ev", "Jh", "", "initData", "initViews", "Vh", "Nh", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;", "roomInfo", "di", "gi", "Lgm4/c;", "data", "Ph", "", "groupID", "Qh", "Ltrpc/yes/wuji/WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf;", ISchemeApi.KEY_PAGE_DATA, "ai", "", "cIcon", "cName", "Zh", "Landroid/os/Bundle;", "intent", "Yh", "Hh", "Oh", "Gh", "Kh", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onBackEvent", "doOnKeyDown", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "isWrapContent", "qh", "onDestroyView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "needImmersive", "Lcom/tencent/timi/game/api/cb/ExpandHallListener;", "listener", "ci", "Gb", "channelUin", "Zg", "Lgh4/d;", "m0", "Kc", "Xh", "Fa", "Lcom/tencent/timi/game/api/param/ExpandHallLaunchParam;", "O", "ue", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", ICustomDataEditor.STRING_PARAM_4, "o1", "getRootView", "Landroid/widget/EditText;", "H", "Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView;", UserInfo.SEX_FEMALE, com.tencent.bugly.common.constants.Constants.BASE_IN_HOTFIX, "t2", "w1", "y4", "uid", "f5", "Rg", "keepInRoom", "ha", "notifyPageClose", "Ig", "getPageName", "P8", "m7", "Ke", "Lrr1/i;", "notifyData", ICustomDataEditor.NUMBER_PARAM_7, "S1", "ug", "J", "mRoomIdFromServer", "G", "I", "mYesGameId", "Lcom/tencent/timi/game/api/param/ExpandHallLaunchParam;", "mLaunchParam", "Ltrpc/yes/wuji/WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf;", "mHallInfo", "mOnlineNum", "K", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "mQQUserId", "L", "getMHallState$annotations", "()V", "mHallState", "M", "getMExitSource$annotations", "mExitSource", "N", "Lgm4/c;", "mCurrentHallRoomData", "P", "Z", "mKeepInRoomWhenExit", "Lmh4/q;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lmh4/q;", "mSubViewHelper", "Lmh4/m;", BdhLogUtil.LogTag.Tag_Req, "Lmh4/m;", "mRoomListenerHelper", "Lmh4/l;", ExifInterface.LATITUDE_SOUTH, "Lmh4/l;", "mJoinRoomHelper", "Lmh4/e;", "T", "Lmh4/e;", "mFloatAnimHelper", "Lmh4/i;", "U", "Lmh4/i;", "mInputHelper", "V", "Lgh4/d;", "mReporterHelper", "Lln4/b;", "W", "Lln4/b;", "mGroupMsgManager", "Lcom/tencent/timi/game/gift/impl/timi/TimiGiftController;", "X", "Lcom/tencent/timi/game/gift/impl/timi/TimiGiftController;", "giftController", "Lth4/g;", "Y", "Lth4/g;", "mMicUtil", "Lcom/tencent/timi/game/floatwindow/impl/animate/WorldScaleLayout;", "Lcom/tencent/timi/game/floatwindow/impl/animate/WorldScaleLayout;", "mAnimateRootView", "a0", "Landroid/view/View;", "mRootView", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "b0", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "mShowAnimatorUpdateListener", "c0", "Lcom/tencent/timi/game/api/cb/ExpandHallListener;", "mHallListener", "Lnr2/bd;", "d0", "Lnr2/bd;", "mBinding", "<init>", "e0", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class ExpandHallFragment extends TimiGameBaseFragment implements com.tencent.timi.game.component.chat.at.d, gh4.e {

    /* renamed from: F, reason: from kotlin metadata */
    private long mRoomIdFromServer;

    /* renamed from: G, reason: from kotlin metadata */
    private int mYesGameId;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf mHallInfo;

    /* renamed from: J, reason: from kotlin metadata */
    private int mOnlineNum;

    /* renamed from: M, reason: from kotlin metadata */
    private int mExitSource;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private gm4.c mCurrentHallRoomData;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean mKeepInRoomWhenExit;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private q mSubViewHelper;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private m mRoomListenerHelper;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private l mJoinRoomHelper;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private mh4.e mFloatAnimHelper;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private i mInputHelper;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private ln4.b mGroupMsgManager;

    /* renamed from: X, reason: from kotlin metadata */
    @Nullable
    private TimiGiftController giftController;

    /* renamed from: Y, reason: from kotlin metadata */
    @Nullable
    private g mMicUtil;

    /* renamed from: Z, reason: from kotlin metadata */
    @Nullable
    private WorldScaleLayout mAnimateRootView;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mRootView;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ExpandHallListener mHallListener;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private bd mBinding;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private ExpandHallLaunchParam mLaunchParam = new ExpandHallLaunchParam();

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final CommonOuterClass$QQUserId mQQUserId = new CommonOuterClass$QQUserId();

    /* renamed from: L, reason: from kotlin metadata */
    private long mHallState = 1;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private gh4.d mReporterHelper = new gh4.d(this.mLaunchParam);

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ValueAnimator.AnimatorUpdateListener mShowAnimatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: ih4.a
        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            ExpandHallFragment.Wh(ExpandHallFragment.this, valueAnimator);
        }
    };

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/timi/game/expand/hall/impl/ExpandHallFragment$b", "Lth4/a;", "", TencentLocation.RUN_MODE, "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f376883b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ KeyEvent f376884c;

        b(int i3, KeyEvent keyEvent) {
            this.f376883b = i3;
            this.f376884c = keyEvent;
        }

        @Override // th4.a
        public boolean run() {
            return ExpandHallFragment.this.Lh(this.f376883b, this.f376884c);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/timi/game/expand/hall/impl/ExpandHallFragment$c", "Lth4/a;", "", TencentLocation.RUN_MODE, "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f376886b;

        c(int i3) {
            this.f376886b = i3;
        }

        @Override // th4.a
        public boolean run() {
            return ExpandHallFragment.this.Mh(this.f376886b);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/timi/game/expand/hall/impl/ExpandHallFragment$d", "Lth4/a;", "", TencentLocation.RUN_MODE, "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d implements a {
        d() {
        }

        @Override // th4.a
        public boolean run() {
            return ExpandHallFragment.this.Mh(1);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/timi/game/expand/hall/impl/ExpandHallFragment$e", "Lcom/tencent/timi/game/component/chat/message/n;", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "uid", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class e implements n {
        e() {
        }

        @Override // com.tencent.timi.game.component.chat.message.n
        public void a(@NotNull CommonOuterClass$QQUserId uid) {
            Intrinsics.checkNotNullParameter(uid, "uid");
            if (o.a()) {
                return;
            }
            k kVar = k.f436355a;
            QBaseActivity qBaseActivity = ExpandHallFragment.this.getQBaseActivity();
            Intrinsics.checkNotNullExpressionValue(qBaseActivity, "qBaseActivity");
            kVar.e(qBaseActivity, uid, ExpandHallFragment.this.mRoomIdFromServer);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/timi/game/expand/hall/impl/ExpandHallFragment$f", "Lcom/tencent/timi/game/component/chat/ChatView$b;", "Lcom/tencent/timi/game/tim/api/message/a;", "msg", "", "b", "", "errorCode", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class f implements ChatView.b {
        f() {
        }

        @Override // com.tencent.timi.game.component.chat.ChatView.b
        public void b(@NotNull com.tencent.timi.game.tim.api.message.a msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
        }

        @Override // com.tencent.timi.game.component.chat.ChatView.b
        public void c(int errorCode, @NotNull com.tencent.timi.game.tim.api.message.a msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (errorCode == 10007) {
                com.tencent.timi.game.utils.l.i("ExpandHallFragment_", "onSendMsgFiled error code " + errorCode + "  kickoff");
                ExpandHallFragment.this.qh(3);
            }
        }
    }

    private final void Gh() {
        int statusBarHeight = ImmersiveUtils.getStatusBarHeight(getQBaseActivity());
        com.tencent.timi.game.utils.l.i("ExpandHallFragment_", "setStatusBarToLightStatus statusBarHeight:" + statusBarHeight);
        bd bdVar = this.mBinding;
        bd bdVar2 = null;
        if (bdVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bdVar = null;
        }
        ViewGroup.LayoutParams layoutParams = bdVar.f421001v.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        com.tencent.timi.game.utils.l.i("ExpandHallFragment_", "setStatusBarToLightStatus lp.topMargin before:" + layoutParams2.topMargin);
        layoutParams2.setMargins(layoutParams2.leftMargin, layoutParams2.topMargin + statusBarHeight, layoutParams2.rightMargin, layoutParams2.bottomMargin);
        bd bdVar3 = this.mBinding;
        if (bdVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            bdVar2 = bdVar3;
        }
        bdVar2.f421001v.setLayoutParams(layoutParams2);
    }

    private final void Hh() {
        mm4.a b16 = mm4.b.b(ug4.b.class);
        Intrinsics.checkNotNullExpressionValue(b16, "getService(IReportService::class.java)");
        ug4.b bVar = (ug4.b) b16;
        bd bdVar = this.mBinding;
        bd bdVar2 = null;
        if (bdVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bdVar = null;
        }
        LinearLayout linearLayout = bdVar.f420994o;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "mBinding.headInfoArea");
        b.a.a(bVar, linearLayout, false, null, this.mReporterHelper.B(), this.mReporterHelper.E(), 6, null);
        mm4.a b17 = mm4.b.b(ug4.b.class);
        Intrinsics.checkNotNullExpressionValue(b17, "getService(IReportService::class.java)");
        ug4.b bVar2 = (ug4.b) b17;
        bd bdVar3 = this.mBinding;
        if (bdVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bdVar3 = null;
        }
        URLImageView uRLImageView = bdVar3.f420986g;
        Intrinsics.checkNotNullExpressionValue(uRLImageView, "mBinding.expandHallInfoIgv");
        b.a.c(bVar2, uRLImageView, false, null, this.mReporterHelper.G(), this.mReporterHelper.E(), 6, null);
        bd bdVar4 = this.mBinding;
        if (bdVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            bdVar2 = bdVar4;
        }
        bdVar2.f420999t.h();
    }

    private final boolean Ih() {
        boolean z16;
        q qVar = this.mSubViewHelper;
        if (qVar != null) {
            z16 = qVar.j();
        } else {
            z16 = false;
        }
        com.tencent.timi.game.utils.l.i("ExpandHallFragment_", "onBackEvent mSubViewHelper consumed:" + z16);
        if (z16) {
            return true;
        }
        bd bdVar = this.mBinding;
        if (bdVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bdVar = null;
        }
        boolean r16 = bdVar.f420989j.r();
        com.tencent.timi.game.utils.l.i("ExpandHallFragment_", "onBackEvent groupChatView consumed:" + r16);
        if (!r16) {
            return false;
        }
        return true;
    }

    private final boolean Jh(MotionEvent ev5) {
        boolean z16;
        q qVar = this.mSubViewHelper;
        if (qVar != null) {
            z16 = qVar.l();
        } else {
            z16 = false;
        }
        if (z16) {
            com.tencent.timi.game.utils.l.b("ExpandHallFragment_", "consumeTouchEvent consumed=true");
            return z16;
        }
        ArrayList arrayList = new ArrayList();
        bd bdVar = this.mBinding;
        bd bdVar2 = null;
        if (bdVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bdVar = null;
        }
        arrayList.add(bdVar.f420999t);
        bd bdVar3 = this.mBinding;
        if (bdVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bdVar3 = null;
        }
        arrayList.add(bdVar3.f420995p);
        bd bdVar4 = this.mBinding;
        if (bdVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            bdVar2 = bdVar4;
        }
        TimiEmoPanelView mEmoPanelView = bdVar2.f420989j.j().getMEmoPanelView();
        if (mEmoPanelView != null) {
            arrayList.add(mEmoPanelView);
            View f16 = mEmoPanelView.f();
            if (f16 != null) {
                arrayList.add(f16);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            View view = (View) it.next();
            th4.q qVar2 = th4.q.f436374a;
            Intrinsics.checkNotNullExpressionValue(view, "view");
            boolean a16 = qVar2.a(view, ev5);
            if (a16) {
                com.tencent.timi.game.utils.l.b("ExpandHallFragment_", "consumeTouchEvent is touched on " + view);
                return a16;
            }
            z16 = a16;
        }
        com.tencent.timi.game.utils.l.b("ExpandHallFragment_", "consumeTouchEvent consumed=" + z16);
        return z16;
    }

    private final void Kh() {
        if (getQBaseActivity() == null) {
            com.tencent.timi.game.utils.l.e("ExpandHallFragment_", "null activity");
            return;
        }
        QBaseActivity qBaseActivity = getQBaseActivity();
        Intrinsics.checkNotNullExpressionValue(qBaseActivity, "qBaseActivity");
        com.tencent.timi.game.gift.impl.timi.a c16 = new com.tencent.timi.game.gift.impl.timi.a(qBaseActivity).b(gh4.b.b(this.mLaunchParam)).f(this.mQQUserId).e(this.mRoomIdFromServer).c(2);
        QBaseActivity qBaseActivity2 = getQBaseActivity();
        Intrinsics.checkNotNullExpressionValue(qBaseActivity2, "qBaseActivity");
        com.tencent.timi.game.gift.impl.timi.a d16 = c16.d(qBaseActivity2);
        bd bdVar = this.mBinding;
        OnlineUserHeaderView onlineUserHeaderView = null;
        if (bdVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bdVar = null;
        }
        RelativeLayout relativeLayout = bdVar.f420997r;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "mBinding.rootView");
        TimiGiftController a16 = d16.a(relativeLayout);
        this.giftController = a16;
        if (a16 != null) {
            bd bdVar2 = this.mBinding;
            if (bdVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                bdVar2 = null;
            }
            View view = bdVar2.f420987h;
            Intrinsics.checkNotNullExpressionValue(view, "mBinding.giftBannerPlaceHolder");
            a16.F(view);
        }
        bd bdVar3 = this.mBinding;
        if (bdVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bdVar3 = null;
        }
        GameAuthAndBindHintView gameAuthAndBindHintView = bdVar3.f420982c;
        QBaseActivity qBaseActivity3 = getQBaseActivity();
        Intrinsics.checkNotNullExpressionValue(qBaseActivity3, "qBaseActivity");
        gameAuthAndBindHintView.e(qBaseActivity3, getMYesGameId());
        if (this.mLaunchParam.b(2)) {
            OnlineUserViewModel onlineUserViewModel = new OnlineUserViewModel(this.mRoomIdFromServer, this);
            bd bdVar4 = this.mBinding;
            if (bdVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                bdVar4 = null;
            }
            View inflate = bdVar4.f420996q.inflate();
            if (inflate instanceof OnlineUserHeaderView) {
                onlineUserHeaderView = (OnlineUserHeaderView) inflate;
            }
            if (onlineUserHeaderView != null) {
                onlineUserHeaderView.setOnlineUserViewModel(onlineUserViewModel);
            }
            onlineUserViewModel.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Lh(int keyCode, KeyEvent event) {
        boolean c16;
        if (keyCode == 4) {
            TimiGiftController timiGiftController = this.giftController;
            boolean z16 = false;
            if (timiGiftController != null && timiGiftController.getIsGiftPanelVisible()) {
                z16 = true;
            }
            if (z16) {
                TimiGiftController timiGiftController2 = this.giftController;
                if (timiGiftController2 != null) {
                    timiGiftController2.t();
                }
                return true;
            }
            ExpandHallListener expandHallListener = this.mHallListener;
            if (expandHallListener != null && (c16 = expandHallListener.c(1, this.mLaunchParam, getQBaseActivity()))) {
                return c16;
            }
            return Mh(1);
        }
        return super.doOnKeyDown(keyCode, event);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Mh(int exitSource) {
        ExpandHallListener expandHallListener = this.mHallListener;
        if (expandHallListener != null) {
            ExpandHallLaunchParam expandHallLaunchParam = this.mLaunchParam;
            QBaseActivity qBaseActivity = getQBaseActivity();
            if (qBaseActivity == null) {
                qBaseActivity = vf4.a.b();
            }
            boolean c16 = expandHallListener.c(exitSource, expandHallLaunchParam, qBaseActivity);
            if (c16) {
                return c16;
            }
        }
        if ((exitSource == 1 || exitSource == 0) && this.mLaunchParam.b(2) && com.tencent.timi.game.utils.g.c(BaseApplication.getContext())) {
            WorldScaleLayout worldScaleLayout = this.mAnimateRootView;
            if (worldScaleLayout != null) {
                worldScaleLayout.g();
            }
            return true;
        }
        return super.qh(exitSource);
    }

    private final void Nh() {
        if (this.mRoomIdFromServer != 0 && !this.mKeepInRoomWhenExit) {
            ((fm4.g) mm4.b.b(fm4.g.class)).T2(this.mRoomIdFromServer, true, 0, null, false);
            this.mReporterHelper.Y(this.mExitSource);
        }
        mh4.e eVar = this.mFloatAnimHelper;
        if (eVar != null) {
            eVar.h();
        }
    }

    private final void Oh() {
        bd bdVar = this.mBinding;
        bd bdVar2 = null;
        if (bdVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bdVar = null;
        }
        GroupChatView groupChatView = bdVar.f420989j;
        bd bdVar3 = this.mBinding;
        if (bdVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            bdVar2 = bdVar3;
        }
        TimiBaseInputView.b i3 = bdVar2.f420999t.i();
        Intrinsics.checkNotNullExpressionValue(i3, "mBinding.teamListView.inputStateChangeListener");
        groupChatView.f(i3);
    }

    private final void Ph(gm4.c data) {
        bd bdVar = null;
        if (!t2()) {
            com.tencent.timi.game.utils.l.k("ExpandHallFragment_", 1, "micCardSwitch is false!");
            bd bdVar2 = this.mBinding;
            if (bdVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                bdVar = bdVar2;
            }
            bdVar.f420995p.setVisibility(8);
            return;
        }
        g gVar = this.mMicUtil;
        if (gVar != null) {
            List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> n3 = data.n();
            Intrinsics.checkNotNullExpressionValue(n3, "data.speakingPosInfoList");
            gVar.b(n3);
        }
        bd bdVar3 = this.mBinding;
        if (bdVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bdVar3 = null;
        }
        bdVar3.f420995p.m(this.mRoomIdFromServer);
        bd bdVar4 = this.mBinding;
        if (bdVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            bdVar = bdVar4;
        }
        MicCardView micCardView = bdVar.f420995p;
        List<YoloRoomOuterClass$YoloRoomSpeakingPosInfo> n16 = data.n();
        Intrinsics.checkNotNullExpressionValue(n16, "data.speakingPosInfoList");
        micCardView.b(n16);
    }

    private final void Qh(long groupID) {
        bd bdVar = this.mBinding;
        if (bdVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bdVar = null;
        }
        bdVar.f421000u.l(getActivity(), groupID);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rh(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        com.tencent.timi.game.utils.l.i("ExpandHallFragment_", "rootView setOnClickListener");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sh(ExpandHallFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.qh(0);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Th(ExpandHallFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!o.c("headInfoArea") && this$0.mLaunchParam.f376301d != 2) {
            this$0.Xh();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Uh(ExpandHallFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Kc();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Vh() {
        WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf b16 = jh4.b.f409938a.b();
        com.tencent.timi.game.utils.l.i("ExpandHallFragment_", "hallInfo from cache:" + b16);
        if (b16 != null) {
            ai(b16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wh(ExpandHallFragment this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        bd bdVar = this$0.mBinding;
        if (bdVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bdVar = null;
        }
        GroupChatView groupChatView = bdVar.f420989j;
        if (groupChatView != null) {
            groupChatView.u();
        }
    }

    private final void Yh(Bundle intent) {
        try {
            ExpandHallLaunchParam expandHallLaunchParam = (ExpandHallLaunchParam) intent.getParcelable("key_expand_hall_launch_param");
            if (expandHallLaunchParam != null) {
                this.mLaunchParam = expandHallLaunchParam;
            }
            ExpandHallLaunchParam expandHallLaunchParam2 = this.mLaunchParam;
            this.mYesGameId = expandHallLaunchParam2.f376303f;
            this.mReporterHelper = new gh4.d(expandHallLaunchParam2);
            this.mQQUserId.guild_id.set(this.mLaunchParam.f376304h);
            this.mQQUserId.uid.set(((ll4.a) mm4.b.b(ll4.a.class)).h());
            this.mQQUserId.user_from.set(gh4.b.a(this.mLaunchParam));
            this.mQQUserId.yes_uid.set(((ll4.a) mm4.b.b(ll4.a.class)).g3());
        } catch (Exception unused) {
            com.tencent.timi.game.utils.l.e("ExpandHallFragment_", "parse mLaunchParam failed");
        }
        com.tencent.timi.game.utils.l.i("ExpandHallFragment_", "mLaunchParam:" + this.mLaunchParam);
    }

    private final void Zh(String cIcon, String cName) {
        bd bdVar = null;
        if (cIcon != null) {
            bd bdVar2 = this.mBinding;
            if (bdVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                bdVar2 = null;
            }
            bdVar2.f420993n.setRadius(com.tencent.timi.game.utils.b.c(4));
            th4.i iVar = th4.i.f436350a;
            bd bdVar3 = this.mBinding;
            if (bdVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                bdVar3 = null;
            }
            RoundCornerImageView roundCornerImageView = bdVar3.f420993n;
            Intrinsics.checkNotNullExpressionValue(roundCornerImageView, "mBinding.headIgv");
            iVar.e(cIcon, roundCornerImageView);
        }
        if (cName != null) {
            bd bdVar4 = this.mBinding;
            if (bdVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                bdVar = bdVar4;
            }
            bdVar.f420990k.setText(cName);
        }
    }

    private final void ai(WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf pageData) {
        String str;
        boolean z16;
        int i3;
        YesGameInfoOuterClass$GameConfigInfo l16 = ((h) mm4.b.b(h.class)).l1(this.mLaunchParam.f376303f);
        Intrinsics.checkNotNullExpressionValue(l16, "getService(IGameConfigSe\u2026o(mLaunchParam.yesGameId)");
        sh4.a.f433815a.b(l16);
        String str2 = l16.room_info.hall_config.icon_hall_back.get();
        th4.i iVar = th4.i.f436350a;
        bd bdVar = this.mBinding;
        bd bdVar2 = null;
        if (bdVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bdVar = null;
        }
        URLImageView uRLImageView = bdVar.f420984e;
        Intrinsics.checkNotNullExpressionValue(uRLImageView, "mBinding.backIgv");
        iVar.e(str2, uRLImageView);
        String str3 = l16.room_info.hall_config.bg_head_area.get();
        bd bdVar3 = this.mBinding;
        if (bdVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bdVar3 = null;
        }
        TopCropImageView topCropImageView = bdVar3.f421002w;
        Intrinsics.checkNotNullExpressionValue(topCropImageView, "mBinding.topBgIgv");
        iVar.e(str3, topCropImageView);
        String titleColor = l16.room_info.hall_config.color_hall_title.get();
        Intrinsics.checkNotNullExpressionValue(titleColor, "titleColor");
        bd bdVar4 = this.mBinding;
        if (bdVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bdVar4 = null;
        }
        TextView textView = bdVar4.f420990k;
        Intrinsics.checkNotNullExpressionValue(textView, "mBinding.hallName");
        iVar.d(titleColor, textView);
        List<String> contentColors = l16.room_info.hall_config.colors_content_area.get();
        com.tencent.timi.game.utils.l.i("ExpandHallFragment_", "refreshHallUI roomBgColors:" + contentColors);
        bd bdVar5 = this.mBinding;
        if (bdVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bdVar5 = null;
        }
        RelativeLayout chatContentArea = bdVar5.f420985f;
        float c16 = com.tencent.timi.game.utils.b.c(6);
        float c17 = com.tencent.timi.game.utils.b.c(6);
        Intrinsics.checkNotNullExpressionValue(contentColors, "contentColors");
        Intrinsics.checkNotNullExpressionValue(chatContentArea, "chatContentArea");
        th4.i.c(iVar, contentColors, c16, c17, 0.0f, 0.0f, chatContentArea, 24, null);
        List<String> operationIndicatorColors = l16.room_info.hall_config.colors_operations_indicator.get();
        bd bdVar6 = this.mBinding;
        if (bdVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bdVar6 = null;
        }
        HallOperationContainer hallOperationContainer = bdVar6.f420991l;
        Intrinsics.checkNotNullExpressionValue(operationIndicatorColors, "operationIndicatorColors");
        hallOperationContainer.setIndicatorColors(operationIndicatorColors);
        bd bdVar7 = this.mBinding;
        if (bdVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bdVar7 = null;
        }
        TeamListView teamListView = bdVar7.f420999t;
        String str4 = l16.room_info.hall_config.icon_fleet_unfold.get();
        String str5 = l16.room_info.hall_config.icon_fleet_fold.get();
        bd bdVar8 = this.mBinding;
        if (bdVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bdVar8 = null;
        }
        URLImageView uRLImageView2 = bdVar8.f420998s;
        bd bdVar9 = this.mBinding;
        if (bdVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bdVar9 = null;
        }
        teamListView.w(str4, str5, uRLImageView2, bdVar9.f420998s);
        if (l16.style_mode.get() == 0) {
            u.e(getQBaseActivity().getWindow());
        } else {
            u.d(getQBaseActivity().getWindow());
        }
        if (this.mLaunchParam.f376301d == 2) {
            IRuntimeService runtimeService = getQBaseActivity().getAppRuntime().getRuntimeService(IGPSService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "qBaseActivity.appRuntime\u2026nt.MAIN\n                )");
            IGPSService iGPSService = (IGPSService) runtimeService;
            IGProChannelInfo channelInfo = iGPSService.getChannelInfo(this.mLaunchParam.C);
            if (channelInfo == null || (str = channelInfo.getChannelName()) == null) {
                str = this.mLaunchParam.f376305i;
            }
            Zh(this.mLaunchParam.f376306m, str);
            bd bdVar10 = this.mBinding;
            if (bdVar10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                bdVar10 = null;
            }
            bdVar10.f420986g.setOnClickListener(new View.OnClickListener() { // from class: ih4.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExpandHallFragment.bi(ExpandHallFragment.this, view);
                }
            });
            String str6 = l16.room_info.hall_config.icon_guild_setting.get();
            if (str6 != null && str6.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                bd bdVar11 = this.mBinding;
                if (bdVar11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                    bdVar11 = null;
                }
                URLImageView uRLImageView3 = bdVar11.f420986g;
                Intrinsics.checkNotNullExpressionValue(uRLImageView3, "mBinding.expandHallInfoIgv");
                iVar.e(str6, uRLImageView3);
            }
            IGProGuildInfo guildInfo = iGPSService.getGuildInfo(String.valueOf(this.mLaunchParam.f376304h));
            boolean isChannelOrCategoryAdmin = channelInfo.isChannelOrCategoryAdmin();
            QLog.d("ExpandHallFragment_", 4, "getIsAdmin: channelAdmin[" + isChannelOrCategoryAdmin + "]");
            if (guildInfo != null) {
                i3 = guildInfo.getUserType();
            } else {
                i3 = 0;
            }
            if (i3 != 1 && i3 != 2 && !isChannelOrCategoryAdmin) {
                bd bdVar12 = this.mBinding;
                if (bdVar12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                } else {
                    bdVar2 = bdVar12;
                }
                bdVar2.f420986g.setVisibility(8);
                return;
            }
            bd bdVar13 = this.mBinding;
            if (bdVar13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            } else {
                bdVar2 = bdVar13;
            }
            bdVar2.f420986g.setVisibility(0);
            return;
        }
        String str7 = l16.room_info.game_info.icon.get();
        bd bdVar14 = this.mBinding;
        if (bdVar14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bdVar14 = null;
        }
        RoundCornerImageView roundCornerImageView = bdVar14.f420993n;
        Intrinsics.checkNotNullExpressionValue(roundCornerImageView, "mBinding.headIgv");
        iVar.e(str7, roundCornerImageView);
        WorldScaleLayout worldScaleLayout = this.mAnimateRootView;
        if (worldScaleLayout != null) {
            worldScaleLayout.p(uh4.b.INSTANCE.a(), pageData.room_pin_icon.get());
        }
        bd bdVar15 = this.mBinding;
        if (bdVar15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bdVar15 = null;
        }
        bdVar15.f420990k.setText(l16.room_info.game_info.text.get());
        bd bdVar16 = this.mBinding;
        if (bdVar16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            bdVar2 = bdVar16;
        }
        bdVar2.f420986g.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bi(ExpandHallFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!o.c("ExpandHall#expandHallInfoIgv")) {
            IQQGuildRouterApi iQQGuildRouterApi = (IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class);
            AppRuntime appRuntime = this$0.getQBaseActivity().getAppRuntime();
            Intrinsics.checkNotNull(appRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
            iQQGuildRouterApi.openGuildChannelInfoSetting((AppInterface) appRuntime, this$0.getContext(), String.valueOf(this$0.mLaunchParam.f376304h), this$0.mLaunchParam.C, 2);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void di(YoloRoomOuterClass$YoloRoomInfo roomInfo) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: ih4.g
            @Override // java.lang.Runnable
            public final void run() {
                ExpandHallFragment.ei(ExpandHallFragment.this);
            }
        });
        Hh();
        com.tencent.timi.game.utils.l.i("ExpandHallFragment_", "joinRoomSucceed mOnlineNum:" + this.mOnlineNum);
        WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf wujiYoloRoomOuterClass$WujiYoloCommunityRoomConf = this.mHallInfo;
        if (wujiYoloRoomOuterClass$WujiYoloCommunityRoomConf != null) {
            ai(wujiYoloRoomOuterClass$WujiYoloCommunityRoomConf);
        }
        this.mQQUserId.yes_uid.set(((ll4.a) mm4.b.b(ll4.a.class)).g3());
        bd bdVar = this.mBinding;
        bd bdVar2 = null;
        if (bdVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bdVar = null;
        }
        bdVar.f420989j.i();
        bd bdVar3 = this.mBinding;
        if (bdVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bdVar3 = null;
        }
        bdVar3.f420989j.g(ConvType.Group, roomInfo, this.mQQUserId);
        bd bdVar4 = this.mBinding;
        if (bdVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bdVar4 = null;
        }
        bdVar4.f420989j.setMessageListener(new e());
        bd bdVar5 = this.mBinding;
        if (bdVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bdVar5 = null;
        }
        bdVar5.f420989j.setMsgSendStatusListener(new f());
        if (this.mLaunchParam.a(2)) {
            w.a(new Runnable() { // from class: ih4.h
                @Override // java.lang.Runnable
                public final void run() {
                    ExpandHallFragment.fi();
                }
            });
        }
        gm4.c cVar = this.mCurrentHallRoomData;
        if (cVar != null) {
            Ph(cVar);
        }
        Qh(roomInfo.get().tim_group_id.get());
        bd bdVar6 = this.mBinding;
        if (bdVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bdVar6 = null;
        }
        bdVar6.f420991l.C(this);
        bd bdVar7 = this.mBinding;
        if (bdVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bdVar7 = null;
        }
        GroupChatView groupChatView = bdVar7.f420989j;
        bd bdVar8 = this.mBinding;
        if (bdVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            bdVar2 = bdVar8;
        }
        groupChatView.f(bdVar2.f420991l.getInputStateListener());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ei(ExpandHallFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Kh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fi() {
        ((IGuildPerformanceReportApi) QRoute.api(IGuildPerformanceReportApi.class)).endESportHallTask();
    }

    private final void gi() {
        ((bo4.d) mm4.b.b(bo4.d.class)).c1(this.mQQUserId, null);
    }

    private final void initData() {
        bd bdVar = this.mBinding;
        bd bdVar2 = null;
        if (bdVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bdVar = null;
        }
        RelativeLayout relativeLayout = bdVar.f420997r;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "mBinding.rootView");
        QBaseActivity qBaseActivity = getQBaseActivity();
        Intrinsics.checkNotNullExpressionValue(qBaseActivity, "qBaseActivity");
        this.mSubViewHelper = new q(this, relativeLayout, qBaseActivity);
        QBaseActivity qBaseActivity2 = getQBaseActivity();
        Intrinsics.checkNotNullExpressionValue(qBaseActivity2, "qBaseActivity");
        this.mRoomListenerHelper = new m(this, qBaseActivity2);
        bd bdVar3 = this.mBinding;
        if (bdVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bdVar3 = null;
        }
        RelativeLayout relativeLayout2 = bdVar3.f420997r;
        Intrinsics.checkNotNullExpressionValue(relativeLayout2, "mBinding.rootView");
        QBaseActivity qBaseActivity3 = getQBaseActivity();
        Intrinsics.checkNotNullExpressionValue(qBaseActivity3, "qBaseActivity");
        this.mJoinRoomHelper = new l(this, relativeLayout2, qBaseActivity3, this.mHallListener);
        bd bdVar4 = this.mBinding;
        if (bdVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            bdVar2 = bdVar4;
        }
        RelativeLayout relativeLayout3 = bdVar2.f420997r;
        Intrinsics.checkNotNullExpressionValue(relativeLayout3, "mBinding.rootView");
        QBaseActivity qBaseActivity4 = getQBaseActivity();
        Intrinsics.checkNotNullExpressionValue(qBaseActivity4, "qBaseActivity");
        this.mFloatAnimHelper = new mh4.e(this, relativeLayout3, qBaseActivity4);
        QBaseActivity qBaseActivity5 = getQBaseActivity();
        Intrinsics.checkNotNullExpressionValue(qBaseActivity5, "qBaseActivity");
        this.mInputHelper = new i(this, qBaseActivity5);
    }

    private final void initViews() {
        bd bdVar = this.mBinding;
        bd bdVar2 = null;
        if (bdVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bdVar = null;
        }
        bdVar.f420997r.setOnClickListener(new View.OnClickListener() { // from class: ih4.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExpandHallFragment.Rh(view);
            }
        });
        bd bdVar3 = this.mBinding;
        if (bdVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bdVar3 = null;
        }
        bdVar3.f420993n.setRadius(com.tencent.timi.game.utils.b.c(6));
        bd bdVar4 = this.mBinding;
        if (bdVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bdVar4 = null;
        }
        bdVar4.f420983d.setOnClickListener(new View.OnClickListener() { // from class: ih4.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExpandHallFragment.Sh(ExpandHallFragment.this, view);
            }
        });
        bd bdVar5 = this.mBinding;
        if (bdVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bdVar5 = null;
        }
        bdVar5.f420994o.setOnClickListener(new View.OnClickListener() { // from class: ih4.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExpandHallFragment.Th(ExpandHallFragment.this, view);
            }
        });
        bd bdVar6 = this.mBinding;
        if (bdVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bdVar6 = null;
        }
        bdVar6.f420999t.setOnMoreClickListener(new View.OnClickListener() { // from class: ih4.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExpandHallFragment.Uh(ExpandHallFragment.this, view);
            }
        });
        bd bdVar7 = this.mBinding;
        if (bdVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            bdVar2 = bdVar7;
        }
        bdVar2.f420999t.setShowAnimatorUpdateListener(this.mShowAnimatorUpdateListener);
        Oh();
    }

    @Override // gh4.e
    public void D4() {
        if (this.mLaunchParam.f376301d == 2) {
            ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).closeAppChannel(getQBaseActivity(), new rr1.b(this.mLaunchParam.C));
            return;
        }
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity != null) {
            qBaseActivity.finish();
        }
    }

    @Override // com.tencent.timi.game.component.chat.at.d
    @Nullable
    public TimiBaseInputView F() {
        bd bdVar = this.mBinding;
        if (bdVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bdVar = null;
        }
        return bdVar.f420989j.F();
    }

    @Override // gh4.e
    public void Fa() {
        ((sm4.a) mm4.b.b(sm4.a.class)).j1(getQBaseActivity(), getMYesGameId(), gh4.b.a(this.mLaunchParam), 1, this.mRoomIdFromServer, this.mReporterHelper.i(), null, new TeamCreatePageParam(false, 1, null));
    }

    @Override // gh4.e
    public void Gb(@NotNull YoloRoomOuterClass$YoloRoomInfo roomInfo) {
        Intrinsics.checkNotNullParameter(roomInfo, "roomInfo");
        com.tencent.timi.game.utils.l.h("ExpandHallFragment_", 1, "onJoinRoomSucceed mHallState:" + this.mHallState);
        long j3 = this.mHallState;
        if (j3 != 3 && j3 != 4) {
            this.mRoomIdFromServer = roomInfo.room_id.get();
            int t26 = ((fm4.g) mm4.b.b(fm4.g.class)).t2(roomInfo);
            if (t26 > 0) {
                this.mYesGameId = t26;
            }
            this.mHallState = 5L;
            com.tencent.timi.game.utils.l.i("ExpandHallFragment_", "onJoinRoomSucceed mRoomIdFromServer:" + this.mRoomIdFromServer + ", mYesGameId:" + this.mYesGameId);
            gm4.c K0 = ((fm4.g) mm4.b.b(fm4.g.class)).K0(this.mRoomIdFromServer);
            this.mCurrentHallRoomData = K0;
            this.mReporterHelper.c(this.mRoomIdFromServer, K0.getRoomType(), this.mYesGameId);
            this.mMicUtil = new g(this.mRoomIdFromServer, this.mLaunchParam);
            WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf wujiYoloRoomOuterClass$WujiYoloCommunityRoomConf = K0.Y().yolo_room_community_conf.wuji_yolo_room_community_conf;
            this.mHallInfo = wujiYoloRoomOuterClass$WujiYoloCommunityRoomConf;
            jh4.b.f409938a.d(wujiYoloRoomOuterClass$WujiYoloCommunityRoomConf);
            com.tencent.timi.game.utils.l.i("ExpandHallFragment_", "joinRoomSucceed pageData:" + this.mHallInfo);
            this.mOnlineNum = K0.I();
            this.mReporterHelper.W();
            p.INSTANCE.b(new p(this.mQQUserId, roomInfo.room_id.get(), roomInfo.tim_group_id.get()));
            this.mGroupMsgManager = ((kn4.b) mm4.b.b(kn4.b.class)).V1();
            ((ag4.i) mm4.b.b(ag4.i.class)).A0(this.mYesGameId);
            ((gh4.f) mm4.b.b(gh4.f.class)).z0(this.mRoomIdFromServer, this);
            ExpandHallListener expandHallListener = this.mHallListener;
            if (expandHallListener != null) {
                expandHallListener.e(this.mRoomIdFromServer, this.mLaunchParam, getQBaseActivity());
            }
            m mVar = this.mRoomListenerHelper;
            if (mVar != null) {
                mVar.c();
            }
            m mVar2 = this.mRoomListenerHelper;
            if (mVar2 != null) {
                mVar2.e();
            }
            ph4.e.f426246a.P(this.mRoomIdFromServer);
            gi();
            di(roomInfo);
            ((ag4.i) mm4.b.b(ag4.i.class)).e3(TGPAUtil.b(), getMYesGameId(), true, null);
            ((h) mm4.b.b(h.class)).e2();
            return;
        }
        com.tencent.timi.game.utils.l.c("ExpandHallFragment_", 1, "onJoinRoomSucceed hall already destroyed!");
    }

    @Override // com.tencent.timi.game.component.chat.at.d
    @Nullable
    public EditText H() {
        bd bdVar = this.mBinding;
        if (bdVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bdVar = null;
        }
        return bdVar.f420989j.H();
    }

    @Override // gh4.e
    public void Ig(boolean notifyPageClose) {
        mh4.e eVar = this.mFloatAnimHelper;
        if (eVar != null) {
            eVar.g(notifyPageClose);
        }
    }

    @Override // gh4.e
    public void Kc() {
        q qVar = this.mSubViewHelper;
        if (qVar != null) {
            qVar.d();
        }
        bd bdVar = this.mBinding;
        if (bdVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bdVar = null;
        }
        bdVar.f420989j.o();
        q qVar2 = this.mSubViewHelper;
        if (qVar2 != null) {
            qVar2.n();
        }
    }

    @Override // gh4.e
    public boolean Ke(@Nullable MotionEvent event) {
        if (event == null) {
            return false;
        }
        return Jh(event);
    }

    @Override // gh4.e
    /* renamed from: P8, reason: from getter */
    public long getMHallState() {
        return this.mHallState;
    }

    @Override // gh4.e
    public boolean Rg(@NotNull CommonOuterClass$QQUserId uid) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        g gVar = this.mMicUtil;
        if (gVar != null) {
            return gVar.f(uid);
        }
        return false;
    }

    @Override // gh4.e
    @NotNull
    public ViewGroup S1() {
        bd bdVar = this.mBinding;
        if (bdVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bdVar = null;
        }
        WorldScaleLayout worldScaleLayout = bdVar.f420981b;
        Intrinsics.checkNotNullExpressionValue(worldScaleLayout, "mBinding.animateContainer");
        return worldScaleLayout;
    }

    public void Xh() {
        bd bdVar = this.mBinding;
        if (bdVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bdVar = null;
        }
        bdVar.f420989j.o();
        q qVar = this.mSubViewHelper;
        if (qVar != null) {
            qVar.m();
        }
    }

    @Override // gh4.e
    public void Zg(@NotNull String channelUin) {
        Intrinsics.checkNotNullParameter(channelUin, "channelUin");
        IGProChannelInfo channelInfo = ((IGPSService) getQBaseActivity().getAppRuntime().getRuntimeService(IGPSService.class, "")).getChannelInfo(channelUin);
        Zh(channelInfo.getChannelUin(), channelInfo.getChannelName());
    }

    public final void ci(@Nullable ExpandHallListener listener) {
        this.mHallListener = listener;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int keyCode, @Nullable KeyEvent event) {
        if (keyCode == 4) {
            if (Ih()) {
                return true;
            }
            this.mExitSource = 1;
            b bVar = new b(keyCode, event);
            th4.f fVar = th4.f.f436343a;
            QBaseActivity qBaseActivity = getQBaseActivity();
            Intrinsics.checkNotNullExpressionValue(qBaseActivity, "qBaseActivity");
            return fVar.j(qBaseActivity, this, bVar);
        }
        return super.doOnKeyDown(keyCode, event);
    }

    @Override // gh4.e
    public boolean f5(@NotNull CommonOuterClass$QQUserId uid) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        g gVar = this.mMicUtil;
        if (gVar != null) {
            return gVar.d(uid);
        }
        return false;
    }

    @Override // fm4.f
    @NotNull
    public String getPageName() {
        return "ExpandHallFragment_";
    }

    @Override // com.tencent.timi.game.base.TimiGameBaseFragment
    @Nullable
    public ViewGroup getRootView() {
        bd bdVar = this.mBinding;
        if (bdVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bdVar = null;
        }
        return bdVar.f420997r;
    }

    @Override // gh4.e
    public void ha(boolean keepInRoom) {
        com.tencent.timi.game.utils.l.h("ExpandHallFragment_", 1, "setKeepInRoomWhenExit " + keepInRoom);
        this.mKeepInRoomWhenExit = keepInRoom;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // gh4.e
    @NotNull
    /* renamed from: m0, reason: from getter */
    public gh4.d getMReporterHelper() {
        return this.mReporterHelper;
    }

    @Override // gh4.e
    @Nullable
    /* renamed from: m7, reason: from getter */
    public WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf getMHallInfo() {
        return this.mHallInfo;
    }

    @Override // gh4.e
    public void n7(@Nullable rr1.i notifyData) {
        int i3;
        if (notifyData != null) {
            i3 = notifyData.e();
        } else {
            i3 = -2;
        }
        com.tencent.timi.game.utils.l.i("ExpandHallFragment_", String.valueOf(i3));
        i iVar = this.mInputHelper;
        if (iVar != null) {
            iVar.c(notifyData);
        }
        if (notifyData == null) {
            return;
        }
        com.tencent.timi.game.utils.l.b("AbsGestureListener", String.valueOf(notifyData.f()));
        if (notifyData.f() == 2) {
            bd bdVar = this.mBinding;
            if (bdVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBinding");
                bdVar = null;
            }
            bdVar.f420989j.o();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // gh4.e
    /* renamed from: o1, reason: from getter */
    public int getMYesGameId() {
        return this.mYesGameId;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        if (Ih()) {
            return true;
        }
        d dVar = new d();
        th4.f fVar = th4.f.f436343a;
        QBaseActivity qBaseActivity = getQBaseActivity();
        Intrinsics.checkNotNullExpressionValue(qBaseActivity, "qBaseActivity");
        return fVar.j(qBaseActivity, this, dVar);
    }

    @Override // com.tencent.timi.game.base.TimiGameBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mHallState = 2L;
        com.tencent.timi.game.utils.l.h("ExpandHallFragment_", 1, "onCreate in, this:" + this);
        Bundle arguments = getArguments();
        if (arguments != null) {
            Yh(arguments);
        }
        ((gh4.f) mm4.b.b(gh4.f.class)).K2(this);
        this.mReporterHelper.P();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        com.tencent.timi.game.utils.l.i("ExpandHallFragment_", "onCreateView in");
        bd g16 = bd.g(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, container, false)");
        this.mBinding = g16;
        View view = null;
        if (g16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            g16 = null;
        }
        WorldScaleLayout worldScaleLayout = g16.f420981b;
        this.mAnimateRootView = worldScaleLayout;
        if (worldScaleLayout != null) {
            view = worldScaleLayout.findViewById(R.id.iet);
        }
        this.mRootView = view;
        if (view != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("yes_game_id", String.valueOf(this.mLaunchParam.f376303f));
            if (this.mLaunchParam.f376301d == 2) {
                hashMap.putAll(this.mReporterHelper.h());
            }
            ((ug4.b) mm4.b.b(ug4.b.class)).S(this, view, this.mReporterHelper.C(), hashMap);
        }
        ((hn4.a) mm4.b.b(hn4.a.class)).H1(this.mRootView);
        WorldScaleLayout worldScaleLayout2 = this.mAnimateRootView;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, worldScaleLayout2);
        return worldScaleLayout2;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        URLDrawable.resume();
        g gVar = this.mMicUtil;
        if (gVar != null) {
            gVar.c();
        }
        m mVar = this.mRoomListenerHelper;
        if (mVar != null) {
            mVar.d();
        }
        l lVar = this.mJoinRoomHelper;
        if (lVar != null) {
            lVar.B();
        }
        this.mGroupMsgManager = null;
        p.INSTANCE.b(null);
        Nh();
        ((gh4.f) mm4.b.b(gh4.f.class)).d2(this);
        TeamInfoAutoUpdateService.h().n();
        ((hi4.b) mm4.b.b(hi4.b.class)).x1("ExpandHallFragment.destroy");
        com.tencent.timi.game.utils.l.i("ExpandHallFragment_", MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        i iVar = this.mInputHelper;
        if (iVar != null) {
            iVar.d();
        }
        super.onDestroy();
        this.mHallState = 4L;
        if (this.mLaunchParam.a(1, 3)) {
            com.tencent.timi.game.initer.impl.b.f377190a.b(10005);
        } else if (this.mLaunchParam.f376301d == 2) {
            com.tencent.timi.game.initer.impl.b.f377190a.b(10004);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.mHallState = 3L;
        l lVar = this.mJoinRoomHelper;
        if (lVar != null) {
            lVar.C();
        }
        q qVar = this.mSubViewHelper;
        if (qVar != null) {
            qVar.k();
        }
        com.tencent.timi.game.utils.l.i("ExpandHallFragment_", "onDestroyView");
        bd bdVar = this.mBinding;
        bd bdVar2 = null;
        if (bdVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bdVar = null;
        }
        GroupChatView groupChatView = bdVar.f420989j;
        bd bdVar3 = this.mBinding;
        if (bdVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bdVar3 = null;
        }
        groupChatView.t(bdVar3.f420991l.getInputStateListener());
        bd bdVar4 = this.mBinding;
        if (bdVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bdVar4 = null;
        }
        GroupChatView groupChatView2 = bdVar4.f420989j;
        bd bdVar5 = this.mBinding;
        if (bdVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bdVar5 = null;
        }
        TimiBaseInputView.b i3 = bdVar5.f420999t.i();
        Intrinsics.checkNotNullExpressionValue(i3, "mBinding.teamListView.inputStateChangeListener");
        groupChatView2.t(i3);
        bd bdVar6 = this.mBinding;
        if (bdVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bdVar6 = null;
        }
        bdVar6.f420989j.i();
        bd bdVar7 = this.mBinding;
        if (bdVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bdVar7 = null;
        }
        bdVar7.f420999t.v();
        TimiGiftController timiGiftController = this.giftController;
        if (timiGiftController != null) {
            timiGiftController.s(true);
        }
        bd bdVar8 = this.mBinding;
        if (bdVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bdVar8 = null;
        }
        bdVar8.f420995p.f();
        bd bdVar9 = this.mBinding;
        if (bdVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bdVar9 = null;
        }
        bdVar9.f420982c.d();
        bd bdVar10 = this.mBinding;
        if (bdVar10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bdVar10 = null;
        }
        bdVar10.f421000u.j(getActivity());
        bd bdVar11 = this.mBinding;
        if (bdVar11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            bdVar2 = bdVar11;
        }
        bdVar2.f420991l.k();
        super.onDestroyView();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        com.tencent.timi.game.utils.l.i("ExpandHallFragment_", "recover origin window soft input mode # onPause");
        i iVar = this.mInputHelper;
        if (iVar != null) {
            iVar.d();
        }
        ph4.e.f426246a.G();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        URLDrawable.resume();
        com.tencent.timi.game.utils.l.i("ExpandHallFragment_", "apply adjust resize # onResume");
        i iVar = this.mInputHelper;
        if (iVar != null) {
            iVar.a();
        }
        ph4.e.f426246a.H();
        bd bdVar = this.mBinding;
        if (bdVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            bdVar = null;
        }
        bdVar.f420989j.s();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        x a16 = x.b().a();
        super.onViewCreated(view, savedInstanceState);
        a16.d("ExpandHallFragment_", "super.onViewCreated");
        Gh();
        initData();
        i iVar = this.mInputHelper;
        if (iVar != null) {
            iVar.b();
        }
        initViews();
        a16.d("ExpandHallFragment_", "initViews");
        mh4.e eVar = this.mFloatAnimHelper;
        if (eVar != null) {
            eVar.e(this.mAnimateRootView);
        }
        Vh();
        a16.d("ExpandHallFragment_", "loadCacheData");
        this.mReporterHelper.Q();
        l lVar = this.mJoinRoomHelper;
        if (lVar != null) {
            lVar.r();
        }
        a16.d("ExpandHallFragment_", "joinRoom-doOnCreate end");
        ((ni4.a) mm4.b.b(ni4.a.class)).o0();
    }

    @Override // com.tencent.timi.game.base.TimiGameBaseFragment
    public boolean qh(int exitSource) {
        this.mExitSource = exitSource;
        c cVar = new c(exitSource);
        if (exitSource != 2 && exitSource != 3 && exitSource != 4) {
            th4.f fVar = th4.f.f436343a;
            QBaseActivity qBaseActivity = getQBaseActivity();
            Intrinsics.checkNotNullExpressionValue(qBaseActivity, "qBaseActivity");
            return fVar.j(qBaseActivity, this, cVar);
        }
        return Mh(exitSource);
    }

    @Override // gh4.e
    @NotNull
    /* renamed from: s4, reason: from getter */
    public CommonOuterClass$QQUserId getMQQUserId() {
        return this.mQQUserId;
    }

    @Override // gh4.e
    public boolean t2() {
        boolean z16;
        PBBoolField pBBoolField;
        WujiYoloRoomOuterClass$WujiYoloCommunityRoomConf wujiYoloRoomOuterClass$WujiYoloCommunityRoomConf = this.mHallInfo;
        if (wujiYoloRoomOuterClass$WujiYoloCommunityRoomConf != null && (pBBoolField = wujiYoloRoomOuterClass$WujiYoloCommunityRoomConf.speaking_list_switch) != null) {
            z16 = pBBoolField.get();
        } else {
            z16 = false;
        }
        com.tencent.timi.game.utils.l.a("ExpandHallFragment_", 1, "micCardSwitch:" + z16);
        return z16;
    }

    @Override // gh4.e
    /* renamed from: ue, reason: from getter */
    public long getMRoomIdFromServer() {
        return this.mRoomIdFromServer;
    }

    @Override // gh4.e
    public void ug() {
        this.mReporterHelper.O();
        l lVar = this.mJoinRoomHelper;
        if (lVar != null) {
            lVar.A();
        }
    }

    @Override // gh4.e
    public boolean w1() {
        boolean z16;
        YoloRoomOuterClass$YoloRoomUserData m3;
        YoloRoomOuterClass$YoloRoomUserWhiteList yoloRoomOuterClass$YoloRoomUserWhiteList;
        PBBoolField pBBoolField;
        gm4.c cVar = this.mCurrentHallRoomData;
        if (cVar != null && (m3 = cVar.m()) != null && (yoloRoomOuterClass$YoloRoomUserWhiteList = m3.yolo_room_user_white_list) != null && (pBBoolField = yoloRoomOuterClass$YoloRoomUserWhiteList.is_community_host) != null) {
            z16 = pBBoolField.get();
        } else {
            z16 = false;
        }
        com.tencent.timi.game.utils.l.a("ExpandHallFragment_", 1, "isMicCardWhiteListUser:" + z16);
        return z16;
    }

    @Override // gh4.e
    public boolean y4() {
        g gVar = this.mMicUtil;
        if (gVar != null) {
            return gVar.getMSelfOnMic();
        }
        return false;
    }

    @Override // fm4.f
    @NotNull
    public ExpandHallLaunchParam O() {
        return this.mReporterHelper.getCom.tencent.mm.opensdk.constants.ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY java.lang.String();
    }
}

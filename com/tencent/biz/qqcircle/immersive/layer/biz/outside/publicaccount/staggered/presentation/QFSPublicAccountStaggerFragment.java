package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qcircleshadow.lib.variation.HostAppSettingUtil;
import com.tencent.biz.qcircleshadow.libmanager.QCircleListenerProxyManager;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QFSSearchBean;
import com.tencent.biz.qqcircle.bizparts.QCirclePublishFeedPart;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.hodor.QFSHodorCollectManager;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.events.QFSPublicAccountScrollStateChangeEvent;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.events.QFSPublicAccountStaggerLifecycleEvent;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.followlist.QFSPublicAccountFollowUsersManager;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.o;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.repo.QFSPublicAccountStaggeredRepo;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.QFSPublishAccountStaggeredTechReporter;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.viewmodel.QFSPublicAccountStaggeredViewModel;
import com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.xinghuan.mask.QFSPublicAccountXingHuanAdMaskDownloadManager;
import com.tencent.biz.qqcircle.immersive.part.ea;
import com.tencent.biz.qqcircle.richframework.part.block.base.RefreshHeaderView;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.utils.bj;
import com.tencent.biz.qqcircle.utils.cj;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QCircleFullScreenStatusView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.BlockPart;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.video.rfw.player.videopreload.RFWVideoPreloadBean;
import com.tencent.biz.richframework.video.rfw.player.videopreload.RFWVideoPreloadManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.home.chats.api.IChatApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountMessageService;
import com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountRefreshCtrl;
import com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter;
import com.tencent.mobileqq.qcircle.api.IQCircleRMonitorApi;
import com.tencent.mobileqq.qcircle.api.IQQFrontBackListener;
import com.tencent.mobileqq.qcircle.api.impl.QCirclePublicAccountLauncher;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.adv.preload.api.IVasMaskAdvPreloadApi;
import com.tencent.mobileqq.wink.api.IQQWinkLauncher;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.engineer.test.api.RFWTestDataSourceList;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.tuxmetersdk.impl.ruleengine.JsonRuleKey;
import com.tencent.util.AppSetting;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedCloudOfficialaccount$OfficialTopFollowUsersRsp;
import feedcloud.FeedCloudOfficialaccount$TopUserDetail;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import t30.f;

@Metadata(d1 = {"\u0000\u0086\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u0096\u00012\u00020\u0001:\u0002\u0097\u0001B\t\u00a2\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\t\u001a\u00020\bH\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u001a\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\bH\u0014J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J&\u0010\u001a\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016J\b\u0010\u001d\u001a\u00020\u0004H\u0016J\b\u0010\u001e\u001a\u00020\u0004H\u0016J\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001fJ\b\u0010\"\u001a\u00020\u0006H\u0016J\b\u0010#\u001a\u00020\u0004H\u0002J\b\u0010$\u001a\u00020\u0004H\u0002J\u001a\u0010)\u001a\u0004\u0018\u00010(2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u0012H\u0002J\u0012\u0010+\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030*0\u001fH\u0002J\b\u0010,\u001a\u00020\u0004H\u0002J\b\u0010-\u001a\u00020\u0004H\u0002J\b\u0010.\u001a\u00020\u0004H\u0002J\b\u0010/\u001a\u00020\u0004H\u0002J\b\u00100\u001a\u00020\u0004H\u0002J\b\u00101\u001a\u00020\u0004H\u0003J\b\u00102\u001a\u00020\u0004H\u0002J\b\u00103\u001a\u00020\u0004H\u0002J\u001c\u00106\u001a\u00020\u00042\u0012\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f04H\u0002J\u0014\u00107\u001a\u00020\b*\n\u0012\u0006\u0012\u0004\u0018\u00010 0\u001fH\u0002J\u001c\u00108\u001a\u00020\u00042\u0012\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f04H\u0002J\u001c\u00109\u001a\u00020\u00042\u0012\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f04H\u0002J\u0018\u0010:\u001a\u00020\u0012*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f04H\u0002J\b\u0010;\u001a\u00020\u0012H\u0002J\b\u0010<\u001a\u00020\u0004H\u0002J\b\u0010=\u001a\u00020\u0004H\u0002J\u001c\u0010?\u001a\u00020\u00042\u0012\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f04H\u0002J\u001c\u0010@\u001a\u00020\u00042\u0012\u0010>\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f04H\u0002J\b\u0010A\u001a\u00020\u0004H\u0002J\u001c\u0010C\u001a\u00020\u00042\u0012\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020B0\u001f04H\u0002J\u0018\u0010F\u001a\u00020\u00042\u000e\u0010E\u001a\n\u0012\u0004\u0012\u00020D\u0018\u000104H\u0002J\b\u0010G\u001a\u00020\u0012H\u0002R\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010Q\u001a\u00020H8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bP\u0010JR\u0016\u0010S\u001a\u00020H8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bR\u0010JR\u0016\u0010W\u001a\u00020T8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010Z\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010^\u001a\u00020[8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010b\u001a\u00020_8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010f\u001a\u00020c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u0016\u0010j\u001a\u00020g8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bh\u0010iR\u0018\u0010n\u001a\u0004\u0018\u00010k8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010mR\u0016\u0010r\u001a\u00020o8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bp\u0010qR\u0018\u0010v\u001a\u0004\u0018\u00010s8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bt\u0010uR\u0018\u0010z\u001a\u0004\u0018\u00010w8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bx\u0010yR\u0016\u0010~\u001a\u00020{8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b|\u0010}R\u0018\u0010\u0081\u0001\u001a\u00020\u007f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0080\u0001\u0010`R\u0018\u0010\u0085\u0001\u001a\u00030\u0082\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0018\u0010\u0089\u0001\u001a\u00030\u0086\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u0019\u0010\u008c\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\u0018\u0010\u0090\u0001\u001a\u00030\u008d\u00018BX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001R\u0017\u0010\u0093\u0001\u001a\u00020\u007f8BX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001\u00a8\u0006\u0098\u0001"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/QFSPublicAccountStaggerFragment;", "Lcom/tencent/biz/qqcircle/fragments/QCircleBaseFragment;", "Landroid/content/res/Configuration;", "newConfig", "", "onConfigurationChanged", "", "getContentLayoutId", "", "getLogTag", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onViewCreatedAfterPartInit", "", "onBackEvent", "getDaTongPageId", "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "onCreateView", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onDestroyView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "Le30/b;", "getFeedList", "getPageId", "Oh", "pi", "Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "isMultiLevel", "Lcom/tencent/biz/richframework/video/rfw/player/videopreload/RFWVideoPreloadBean;", "Ph", "Lcom/tencent/biz/richframework/part/block/MultiViewBlock;", "qi", "initTitleBar", "ci", "di", "Zh", "fi", "bi", "gi", "initViewModel", "Lcom/tencent/richframework/data/base/UIStateData;", "listUIStateData", "Xh", "wi", "Vh", "Wh", "ti", "ni", "Qh", "vi", "uiStateData", "Sh", "Th", "si", "Lorg/json/JSONObject;", "Yh", "Lfeedcloud/FeedCloudOfficialaccount$OfficialTopFollowUsersRsp;", "rspUIStateData", "Uh", SensorJsPlugin.SENSOR_INTERVAL_UI, "Landroid/widget/ImageView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/ImageView;", "backIcon", "Landroid/widget/TextView;", "D", "Landroid/widget/TextView;", "titleText", "E", "moreIcon", UserInfo.SEX_FEMALE, "searchIcon", "Lcom/tencent/biz/qqcircle/widgets/QCircleAvatarView;", "G", "Lcom/tencent/biz/qqcircle/widgets/QCircleAvatarView;", "avatarView", "H", "Landroid/view/View;", "gradientMaskView", "Lcom/tencent/biz/richframework/part/BlockPart;", "I", "Lcom/tencent/biz/richframework/part/BlockPart;", "blockPart", "Lcom/tencent/biz/qqcircle/widgets/QCircleFullScreenStatusView;", "J", "Lcom/tencent/biz/qqcircle/widgets/QCircleFullScreenStatusView;", "statusView", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/o;", "K", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/o;", "feedsAdapter", "Lt30/f;", "L", "Lt30/f;", "counterWrapper", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/followlist/d;", "M", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/followlist/d;", "followUsersAdapter", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/viewmodel/QFSPublicAccountStaggeredViewModel;", "N", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/viewmodel/QFSPublicAccountStaggeredViewModel;", "viewModel", "Lj50/b;", "P", "Lj50/b;", "selfCheckController", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/QFSPublicAccountNegativePopup;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/QFSPublicAccountNegativePopup;", "negativePopup", "Ll50/b;", BdhLogUtil.LogTag.Tag_Req, "Ll50/b;", "xingHuanAdMaskInterceptor", "", ExifInterface.LATITUDE_SOUTH, "lastEnterTime", "Lcom/tencent/mobileqq/qcircle/api/IQQFrontBackListener;", "T", "Lcom/tencent/mobileqq/qcircle/api/IQQFrontBackListener;", "frontBackListener", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/a;", "U", "Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/a;", JsonRuleKey.OPERATOR, "V", "Z", "isCachedEmpty", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "getInitBean", "()Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "initBean", "Rh", "()J", "exposureCostTimeMills", "<init>", "()V", "W", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSPublicAccountStaggerFragment extends QCircleBaseFragment {

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int X = com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.a.a(40.0f);
    private static final int Y = ImmersiveUtils.dpToPx(7.0f);
    private static final boolean Z = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_gzh_sll_reason", true);

    /* renamed from: a0, reason: collision with root package name */
    private static boolean f86886a0;

    /* renamed from: C, reason: from kotlin metadata */
    private ImageView backIcon;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView titleText;

    /* renamed from: E, reason: from kotlin metadata */
    private ImageView moreIcon;

    /* renamed from: F, reason: from kotlin metadata */
    private ImageView searchIcon;

    /* renamed from: G, reason: from kotlin metadata */
    private QCircleAvatarView avatarView;

    /* renamed from: H, reason: from kotlin metadata */
    private View gradientMaskView;

    /* renamed from: I, reason: from kotlin metadata */
    private BlockPart blockPart;

    /* renamed from: J, reason: from kotlin metadata */
    private QCircleFullScreenStatusView statusView;

    /* renamed from: K, reason: from kotlin metadata */
    private o feedsAdapter;

    /* renamed from: L, reason: from kotlin metadata */
    private t30.f counterWrapper;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.followlist.d followUsersAdapter;

    /* renamed from: N, reason: from kotlin metadata */
    private QFSPublicAccountStaggeredViewModel viewModel;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private j50.b selfCheckController;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private QFSPublicAccountNegativePopup negativePopup;

    /* renamed from: S, reason: from kotlin metadata */
    private long lastEnterTime;

    /* renamed from: V, reason: from kotlin metadata */
    private boolean isCachedEmpty;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private l50.b xingHuanAdMaskInterceptor = new l50.b();

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final IQQFrontBackListener frontBackListener = new b();

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final a operator = new a() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.QFSPublicAccountStaggerFragment$operator$1
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.a
        public boolean a(@NotNull final FeedCloudMeta$StFeed feed, @NotNull View view, final int position) {
            int i3;
            byte b16;
            QFSPublicAccountNegativePopup qFSPublicAccountNegativePopup;
            QFSPublicAccountNegativePopup qFSPublicAccountNegativePopup2;
            Intrinsics.checkNotNullParameter(feed, "feed");
            Intrinsics.checkNotNullParameter(view, "view");
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            ArrayList<NegativeItem> j3 = com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.d.j(feed, context);
            if (j3.isEmpty()) {
                return false;
            }
            Rect d16 = com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.e.d(view);
            int height = d16.height();
            float c16 = com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.e.c(view);
            i3 = QFSPublicAccountStaggerFragment.X;
            int i16 = 1;
            if (height > i3 && c16 > 0.15f) {
                b16 = true;
            } else {
                b16 = false;
            }
            if (b16 == false) {
                QLog.i("QFSPublicAccountStaggerFragment", 1, "onLongClick item but the area is not enough, percent=" + c16);
                return false;
            }
            int centerX = d16.centerX();
            int centerY = d16.centerY();
            qFSPublicAccountNegativePopup = QFSPublicAccountStaggerFragment.this.negativePopup;
            if (qFSPublicAccountNegativePopup != null) {
                qFSPublicAccountNegativePopup.dismissAllowingStateLoss();
            }
            QFSPublicAccountStaggerFragment.this.negativePopup = new QFSPublicAccountNegativePopup(null, i16, 0 == true ? 1 : 0);
            qFSPublicAccountNegativePopup2 = QFSPublicAccountStaggerFragment.this.negativePopup;
            if (qFSPublicAccountNegativePopup2 != null) {
                FragmentManager childFragmentManager = QFSPublicAccountStaggerFragment.this.getChildFragmentManager();
                String str = feed.f398449id.get();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                Intrinsics.checkNotNullExpressionValue(str, "get()");
                final QFSPublicAccountStaggerFragment qFSPublicAccountStaggerFragment = QFSPublicAccountStaggerFragment.this;
                qFSPublicAccountNegativePopup2.Ch(childFragmentManager, str, j3, centerX, centerY, new Function1<NegativeItem, Unit>() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.QFSPublicAccountStaggerFragment$operator$1$onLongClick$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(NegativeItem negativeItem) {
                        invoke2(negativeItem);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull NegativeItem negativeItem) {
                        Intrinsics.checkNotNullParameter(negativeItem, "negativeItem");
                        QFSPublicAccountNegativeFeedback.c(FeedCloudMeta$StFeed.this, negativeItem, position, qFSPublicAccountStaggerFragment.getPageId(), this);
                    }
                });
            }
            return true;
        }

        @Override // com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.a
        public void removeAll(@NotNull Function1<? super e30.b, Boolean> predicate) {
            QFSPublicAccountStaggeredViewModel qFSPublicAccountStaggeredViewModel;
            o oVar;
            Intrinsics.checkNotNullParameter(predicate, "predicate");
            qFSPublicAccountStaggeredViewModel = QFSPublicAccountStaggerFragment.this.viewModel;
            o oVar2 = null;
            if (qFSPublicAccountStaggeredViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                qFSPublicAccountStaggeredViewModel = null;
            }
            qFSPublicAccountStaggeredViewModel.j2(predicate);
            oVar = QFSPublicAccountStaggerFragment.this.feedsAdapter;
            if (oVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedsAdapter");
            } else {
                oVar2 = oVar;
            }
            oVar2.B0(predicate);
        }
    };

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R \u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\bR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\bR\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00158\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\bR\u0014\u0010\u001b\u001a\u00020\u00128\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0014R\u0014\u0010\u001c\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001d\u00a8\u0006 "}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/QFSPublicAccountStaggerFragment$a;", "", "", "c", "", "d", "", "verticalSpacePx", "I", "b", "()I", "getVerticalSpacePx$annotations", "()V", "ITEM_CAN_TRIGGER_NEGATIVE_MIN_VISIBLE_HEIGHT", "", "ITEM_CAN_TRIGGER_NEGATIVE_MIN_VISIBLE_PERCENT", UserInfo.SEX_FEMALE, "LOAD_MORE_RETRY_COUNT", "", "MONITOR_PAGE_NAME", "Ljava/lang/String;", "", "REFRESH_CLICK_TRIGGER_MILLS", "J", "REFRESH_ICON_ANIMATION_COST", "REMOVE_ANIMATION_DURATION", "SPAN_COUNT", "TAG", "isGzhSllReasonEnable", "Z", "isHitExp", "<init>", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.QFSPublicAccountStaggerFragment$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void c() {
            boolean g16 = com.tencent.biz.qqcircle.utils.k.g("exp_gzh_sllreason", "exp_gzh_sllreason_B");
            QLog.d("QFSPublicAccountStaggerFragment", 1, "initGzhSllReasonExp:" + g16);
            QFSPublicAccountStaggerFragment.f86886a0 = g16;
            com.tencent.biz.qqcircle.utils.k.j("exp_gzh_sllreason");
        }

        public final int b() {
            return QFSPublicAccountStaggerFragment.Y;
        }

        public final boolean d() {
            if (!QFSPublicAccountStaggerFragment.Z) {
                return false;
            }
            if (!AppSetting.isGrayVersion()) {
                return QFSPublicAccountStaggerFragment.f86886a0;
            }
            return true;
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/QFSPublicAccountStaggerFragment$b", "Lcom/tencent/mobileqq/qcircle/api/IQQFrontBackListener;", "", "onQQEnterForeground", "onQQEnterBackground", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b implements IQQFrontBackListener {
        b() {
        }

        @Override // com.tencent.mobileqq.qcircle.api.IQQFrontBackListener
        public void onQQEnterBackground() {
            BaseQQAppInterface baseQQAppInterface;
            AppInterface appInterface = QCircleServiceImpl.getAppInterface();
            if (appInterface instanceof BaseQQAppInterface) {
                baseQQAppInterface = (BaseQQAppInterface) appInterface;
            } else {
                baseQQAppInterface = null;
            }
            if (baseQQAppInterface != null) {
                ((IQCirclePublicAccountReporter) QRoute.api(IQCirclePublicAccountReporter.class)).reportRedPointBack(baseQQAppInterface, NetConnInfoCenter.getServerTimeMillis() - QFSPublicAccountStaggerFragment.this.lastEnterTime, 2);
            }
            QFSPublicAccountStaggerFragment.this.lastEnterTime = 0L;
        }

        @Override // com.tencent.mobileqq.qcircle.api.IQQFrontBackListener
        public void onQQEnterForeground() {
            QFSPublicAccountStaggerFragment.this.lastEnterTime = NetConnInfoCenter.getServerTimeMillis();
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/presentation/QFSPublicAccountStaggerFragment$c", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class c extends RecyclerView.OnScrollListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ BlockContainer f86888d;

        c(BlockContainer blockContainer) {
            this.f86888d = blockContainer;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Integer minOrNull;
            int i3;
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            RecyclerView.LayoutManager layoutManager = this.f86888d.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager");
            StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
            if (newState == 0) {
                int[] iArr = new int[2];
                staggeredGridLayoutManager.findFirstVisibleItemPositions(iArr);
                minOrNull = ArraysKt___ArraysKt.minOrNull(iArr);
                if (minOrNull != null) {
                    i3 = minOrNull.intValue();
                } else {
                    i3 = 0;
                }
                if (i3 <= 0) {
                    staggeredGridLayoutManager.invalidateSpanAssignments();
                    recyclerView.invalidateItemDecorations();
                }
                SimpleEventBus.getInstance().dispatchEvent(new QFSPublicAccountScrollStateChangeEvent(1));
            }
        }
    }

    private final void Oh() {
        QLog.d("QFSPublicAccountStaggerFragment", 1, "[adjustStaggerListSize] screenWidth: " + DisplayUtil.getScreenWidth());
        o oVar = this.feedsAdapter;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedsAdapter");
            oVar = null;
        }
        oVar.notifyDataSetChanged();
    }

    private final RFWVideoPreloadBean Ph(FeedCloudMeta$StFeed feed, boolean isMultiLevel) {
        return RFWVideoPreloadBean.obtainBean(QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO()).setIsQUIC(QCirclePluginUtil.isQUIC(feed)).setIsMultiLevel(isMultiLevel).setIsSimpleFeed(com.tencent.biz.qqcircle.immersive.repository.foldertab.j.g(feed)).setPreloadVideo(gb0.b.k(feed.video.get()));
    }

    private final void Qh() {
        if (ni()) {
            BlockPart blockPart = this.blockPart;
            if (blockPart == null) {
                Intrinsics.throwUninitializedPropertyAccessException("blockPart");
                blockPart = null;
            }
            blockPart.getBlockContainer().getBlockMerger().getRefreshViewProvider().setRefreshing(false);
        }
    }

    private final long Rh() {
        return System.currentTimeMillis() - getInitBean().getEnterTime();
    }

    private final void Sh(UIStateData<List<e30.b>> uiStateData) {
        o oVar = this.feedsAdapter;
        o oVar2 = null;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedsAdapter");
            oVar = null;
        }
        oVar.notifyLoadingComplete(true, uiStateData.getIsFinish());
        o oVar3 = this.feedsAdapter;
        if (oVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedsAdapter");
            oVar3 = null;
        }
        Intrinsics.checkNotNullExpressionValue(oVar3.getDataList(), "feedsAdapter.dataList");
        if (!r0.isEmpty()) {
            QLog.e(getTAG(), 1, "hasFeedContents do nothing");
        } else if (!uiStateData.getIsLoadMore()) {
            QCircleFullScreenStatusView qCircleFullScreenStatusView = this.statusView;
            if (qCircleFullScreenStatusView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("statusView");
                qCircleFullScreenStatusView = null;
            }
            qCircleFullScreenStatusView.showEmptyView("");
        }
        if (uiStateData.getIsLoadMore()) {
            o oVar4 = this.feedsAdapter;
            if (oVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedsAdapter");
            } else {
                oVar2 = oVar4;
            }
            oVar2.getLoadInfo().setFinish(uiStateData.getIsFinish());
        }
    }

    private final void Th(UIStateData<List<e30.b>> uiStateData) {
        String msg2;
        List<e30.b> emptyList;
        if (uiStateData.getMsg() == null) {
            msg2 = com.tencent.biz.qqcircle.utils.h.a(R.string.f184743mp);
        } else {
            msg2 = uiStateData.getMsg();
        }
        QLog.e(getTAG(), 1, "handleFeedDataRsp() return error\uff01errMsg: " + msg2);
        o oVar = this.feedsAdapter;
        QCircleFullScreenStatusView qCircleFullScreenStatusView = null;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedsAdapter");
            oVar = null;
        }
        oVar.notifyLoadingComplete(true, uiStateData.getIsFinish());
        long retCode = uiStateData.getRetCode();
        if (!QCirclePluginUtil.isRequestSecurityHit(retCode)) {
            o oVar2 = this.feedsAdapter;
            if (oVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedsAdapter");
                oVar2 = null;
            }
            if (!oVar2.getDataList().isEmpty()) {
                cj.b(false, retCode, msg2);
                return;
            }
        }
        o oVar3 = this.feedsAdapter;
        if (oVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedsAdapter");
            oVar3 = null;
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        oVar3.setDatas(emptyList);
        QCircleFullScreenStatusView qCircleFullScreenStatusView2 = this.statusView;
        if (qCircleFullScreenStatusView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusView");
        } else {
            qCircleFullScreenStatusView = qCircleFullScreenStatusView2;
        }
        qCircleFullScreenStatusView.x0(msg2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005a, code lost:
    
        if (r5 == false) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void Uh(UIStateData<FeedCloudOfficialaccount$OfficialTopFollowUsersRsp> rspUIStateData) {
        boolean z16;
        boolean z17;
        String str;
        boolean z18;
        List<FeedCloudOfficialaccount$TopUserDetail> list;
        if (rspUIStateData != null && rspUIStateData.getState() == 3) {
            QFSPublicAccountFollowUsersManager.f86913a.g();
            FeedCloudOfficialaccount$OfficialTopFollowUsersRsp data = rspUIStateData.getData();
            if (data != null) {
                PBRepeatMessageField<FeedCloudOfficialaccount$TopUserDetail> pBRepeatMessageField = data.users_detail;
                boolean z19 = false;
                if (pBRepeatMessageField != null && (list = pBRepeatMessageField.get()) != null) {
                    Intrinsics.checkNotNullExpressionValue(list, "get()");
                    if (!list.isEmpty()) {
                        z16 = true;
                        if (z16) {
                            PBStringField pBStringField = data.title;
                            if (pBStringField != null && (str = pBStringField.get()) != null) {
                                Intrinsics.checkNotNullExpressionValue(str, "get()");
                                if (str.length() > 0) {
                                    z18 = true;
                                } else {
                                    z18 = false;
                                }
                                if (z18) {
                                    z17 = true;
                                    if (z17) {
                                        z19 = true;
                                    }
                                }
                            }
                            z17 = false;
                            if (z17) {
                            }
                        }
                    }
                }
                z16 = false;
                if (z16) {
                }
            }
            data = null;
            if (data == null) {
                QLog.i("QFSPublicAccountStaggerFragment", 1, "handleFollowUsersUIState, data is empty.");
                return;
            }
            com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.followlist.d dVar = this.followUsersAdapter;
            if (dVar != null) {
                dVar.i0(data);
                dVar.notifyDataSetChanged();
                return;
            }
            return;
        }
        QLog.e("QFSPublicAccountStaggerFragment", 1, "handleFollowUsersUIState, invalid rsp or state, do nothing.");
    }

    private final void Vh(UIStateData<List<e30.b>> listUIStateData) {
        QLog.i("QFSPublicAccountStaggerFragment", 1, "[handleModifyData] listUIStateData.type = " + listUIStateData.getType());
        List<e30.b> data = listUIStateData.getData();
        if (data == null) {
            data = new ArrayList<>();
        }
        o oVar = this.feedsAdapter;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedsAdapter");
            oVar = null;
        }
        oVar.q0(data, false, new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.QFSPublicAccountStaggerFragment$handleModifyData$$inlined$Runnable$1
            @Override // java.lang.Runnable
            public final void run() {
            }
        });
    }

    private final void Wh(UIStateData<List<e30.b>> listUIStateData) {
        boolean z16;
        Object orNull;
        QLog.i("QFSPublicAccountStaggerFragment", 1, "[handleSuccessData] listUIStateData.type = " + listUIStateData.getType());
        boolean isLoadMore = listUIStateData.getIsLoadMore();
        boolean isFinish = listUIStateData.getIsFinish();
        if (listUIStateData.getType() != QFSPublicAccountStaggeredRepo.RequestType.REFRESH.ordinal() && listUIStateData.getType() != QFSPublicAccountStaggeredRepo.RequestType.INIT_FETCH.ordinal()) {
            z16 = false;
        } else {
            z16 = true;
        }
        QCircleFullScreenStatusView qCircleFullScreenStatusView = this.statusView;
        o oVar = null;
        if (qCircleFullScreenStatusView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusView");
            qCircleFullScreenStatusView = null;
        }
        qCircleFullScreenStatusView.o0();
        if (isLoadMore) {
            o oVar2 = this.feedsAdapter;
            if (oVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedsAdapter");
                oVar2 = null;
            }
            oVar2.addAll(listUIStateData.getData());
        } else if (z16) {
            o oVar3 = this.feedsAdapter;
            if (oVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedsAdapter");
                oVar3 = null;
            }
            List<e30.b> data = listUIStateData.getData();
            Intrinsics.checkNotNullExpressionValue(data, "listUIStateData.data");
            oVar3.E0(data);
        } else {
            o oVar4 = this.feedsAdapter;
            if (oVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedsAdapter");
                oVar4 = null;
            }
            List<e30.b> data2 = listUIStateData.getData();
            Intrinsics.checkNotNullExpressionValue(data2, "listUIStateData.data");
            oVar4.setDatas(data2);
        }
        o oVar5 = this.feedsAdapter;
        if (oVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedsAdapter");
            oVar5 = null;
        }
        oVar5.notifyLoadingComplete(true, isFinish);
        if (ti(listUIStateData)) {
            o oVar6 = this.feedsAdapter;
            if (oVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedsAdapter");
            } else {
                oVar = oVar6;
            }
            oVar.x0(false);
            QLog.d("QFSPublicAccountStaggerFragment", 4, "xcy before [refreshAnimStart] time=" + System.currentTimeMillis());
        }
        if (z16 && !Intrinsics.areEqual(com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.ad.v.f86780a.c(), Boolean.TRUE) && this.mParentView != null) {
            l50.b bVar = this.xingHuanAdMaskInterceptor;
            FragmentActivity activity = getActivity();
            ViewGroup mParentView = this.mParentView;
            Intrinsics.checkNotNullExpressionValue(mParentView, "mParentView");
            List<e30.b> data3 = listUIStateData.getData();
            Intrinsics.checkNotNullExpressionValue(data3, "listUIStateData.data");
            orNull = CollectionsKt___CollectionsKt.getOrNull(data3, 0);
            bVar.f(activity, mParentView, (e30.b) orNull);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Xh(UIStateData<List<e30.b>> listUIStateData) {
        int i3;
        List<e30.b> mutableList;
        int state = listUIStateData.getState();
        boolean isLoadMore = listUIStateData.getIsLoadMore();
        boolean isFinish = listUIStateData.getIsFinish();
        long retCode = listUIStateData.getRetCode();
        QLog.d("QFSPublicAccountStaggerFragment", 1, "[handleUIState] state: " + state + ", isLoadMore: " + isLoadMore + ", isFinish: " + isFinish + ".");
        int i16 = 0;
        if (state != 0) {
            QCircleFullScreenStatusView qCircleFullScreenStatusView = null;
            o oVar = null;
            if (state != 1) {
                if (state != 2) {
                    if (state != 3) {
                        if (state != 4) {
                            if (state == 8) {
                                int pos = listUIStateData.getPos();
                                List<e30.b> data = listUIStateData.getData();
                                Intrinsics.checkNotNullExpressionValue(data, "listUIStateData.data");
                                mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) data);
                                QLog.i("QFSPublicAccountPositiveAction_Staggered", 1, "forceInsert succeed, toBeInsertData=" + wi(mutableList));
                                o oVar2 = this.feedsAdapter;
                                if (oVar2 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("feedsAdapter");
                                } else {
                                    oVar = oVar2;
                                }
                                oVar.insertData(mutableList, pos);
                            }
                        } else {
                            Th(listUIStateData);
                        }
                    } else {
                        si();
                        Wh(listUIStateData);
                        Qh();
                        if (listUIStateData.getType() == QFSPublicAccountStaggeredRepo.RequestType.INIT_FETCH.ordinal()) {
                            QFSPublishAccountStaggeredTechReporter.g(Rh(), this.isCachedEmpty, false, listUIStateData.getData());
                        }
                    }
                } else {
                    Wh(listUIStateData);
                    vi();
                    Intrinsics.checkNotNullExpressionValue(listUIStateData.getData(), "listUIStateData.data");
                    if (!r7.isEmpty()) {
                        QFSPublishAccountStaggeredTechReporter.g(Rh(), true, true, listUIStateData.getData());
                    }
                }
            } else {
                QCircleFullScreenStatusView qCircleFullScreenStatusView2 = this.statusView;
                if (qCircleFullScreenStatusView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("statusView");
                } else {
                    qCircleFullScreenStatusView = qCircleFullScreenStatusView2;
                }
                qCircleFullScreenStatusView.o0();
            }
        } else {
            Sh(listUIStateData);
        }
        if (retCode != -55555) {
            if (state == 3 || state == 4 || state == 0) {
                long retCode2 = listUIStateData.getRetCode();
                List<e30.b> data2 = listUIStateData.getData();
                if (data2 != null) {
                    i3 = data2.size();
                } else {
                    i3 = 0;
                }
                QFSPublishAccountStaggeredTechReporter.c(retCode2, i3, !this.isCachedEmpty, listUIStateData.getType());
                QFSPublishAccountStaggeredTechReporter qFSPublishAccountStaggeredTechReporter = QFSPublishAccountStaggeredTechReporter.f87043a;
                long retCode3 = listUIStateData.getRetCode();
                String msg2 = listUIStateData.getMsg();
                if (msg2 == null) {
                    msg2 = "";
                }
                String str = msg2;
                List<e30.b> data3 = listUIStateData.getData();
                if (data3 != null) {
                    i16 = data3.size();
                }
                qFSPublishAccountStaggeredTechReporter.h(retCode3, str, listUIStateData.getType(), i16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Yh(UIStateData<List<JSONObject>> listUIStateData) {
        int state = listUIStateData.getState();
        QLog.d("QFSPublicAccountStaggerFragment", 1, "[handleXingHuanAdMaskState] state: " + state);
        if (state == 3) {
            QFSPublicAccountXingHuanAdMaskDownloadManager qFSPublicAccountXingHuanAdMaskDownloadManager = QFSPublicAccountXingHuanAdMaskDownloadManager.f87145a;
            List<JSONObject> data = listUIStateData.getData();
            Intrinsics.checkNotNullExpressionValue(data, "listUIStateData.data");
            qFSPublicAccountXingHuanAdMaskDownloadManager.g(data);
        }
    }

    private final void Zh() {
        View findViewById = ((QCircleBaseFragment) this).mContentView.findViewById(R.id.f165909du3);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewById(R.id.iv_avatar)");
        this.avatarView = (QCircleAvatarView) findViewById;
        QCircleAvatarView qCircleAvatarView = null;
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101455", false)) {
            QCircleAvatarView qCircleAvatarView2 = this.avatarView;
            if (qCircleAvatarView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarView");
            } else {
                qCircleAvatarView = qCircleAvatarView2;
            }
            qCircleAvatarView.setVisibility(8);
            return;
        }
        QCircleAvatarView qCircleAvatarView3 = this.avatarView;
        if (qCircleAvatarView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarView");
            qCircleAvatarView3 = null;
        }
        qCircleAvatarView3.setVisibility(0);
        ImageView imageView = this.searchIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchIcon");
            imageView = null;
        }
        imageView.setVisibility(8);
        final FeedCloudMeta$StUser m3 = QCirclePluginGlobalInfo.m();
        Size a16 = com.tencent.biz.qqcircle.immersive.utils.n.a(getContext(), R.dimen.d4p);
        QCircleAvatarView qCircleAvatarView4 = this.avatarView;
        if (qCircleAvatarView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarView");
            qCircleAvatarView4 = null;
        }
        qCircleAvatarView4.setAvatar(m3, a16);
        QCircleAvatarView qCircleAvatarView5 = this.avatarView;
        if (qCircleAvatarView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarView");
            qCircleAvatarView5 = null;
        }
        qCircleAvatarView5.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSPublicAccountStaggerFragment.ai(FeedCloudMeta$StUser.this, this, view);
            }
        });
        QCircleAvatarView qCircleAvatarView6 = this.avatarView;
        if (qCircleAvatarView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarView");
            qCircleAvatarView6 = null;
        }
        VideoReport.setElementId(qCircleAvatarView6, QCircleDaTongConstant.ElementId.EM_XSJ_PROFILE_BUTTON);
        QCircleAvatarView qCircleAvatarView7 = this.avatarView;
        if (qCircleAvatarView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarView");
            qCircleAvatarView7 = null;
        }
        VideoReport.setElementParams(qCircleAvatarView7, new QCircleDTParamBuilder().buildElementParams());
        QCircleAvatarView qCircleAvatarView8 = this.avatarView;
        if (qCircleAvatarView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarView");
        } else {
            qCircleAvatarView = qCircleAvatarView8;
        }
        VideoReport.setElementClickPolicy(qCircleAvatarView, ClickPolicy.REPORT_ALL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ai(FeedCloudMeta$StUser feedCloudMeta$StUser, QFSPublicAccountStaggerFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        qCircleInitBean.setUser(feedCloudMeta$StUser);
        qCircleInitBean.setFromReportBean(this$0.getReportBean().m466clone());
        qCircleInitBean.setLaunchFrom("QFSPublicAccountStaggerFragment");
        com.tencent.biz.qqcircle.launcher.c.d0(this$0.getContext(), qCircleInitBean);
        EventCollector.getInstance().onViewClicked(view);
    }

    @RFWTestDataSourceList(keys = {"key_public_account_root_page", "key_public_account_recycler_view"}, objNames = {"mContentView", "blockPart.mBlockContainer.mRecyclerView"})
    private final void bi() {
        BlockPart blockPart = this.blockPart;
        if (blockPart == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blockPart");
            blockPart = null;
        }
        BlockContainer blockContainer = blockPart.getBlockContainer();
        blockContainer.getRecyclerView().setItemAnimator(new DefaultItemAnimator());
        blockContainer.getRecyclerView().addItemDecoration(new ab(Y, o.INSTANCE.b()));
        blockContainer.getRecyclerView().addOnScrollListener(new c(blockContainer));
        blockContainer.setParentFragment(this);
        blockContainer.getBlockMerger().setTryToLoadMoreWhenNotFullScreen(1);
        AppInterface appInterface = QCircleServiceImpl.getAppInterface();
        if (appInterface != null) {
            Intrinsics.checkNotNullExpressionValue(appInterface, "getAppInterface()");
            int qCirclePublicAccountStaggerPreloadTriggerCount = ((IQCirclePublicAccountMessageService) appInterface.getRuntimeService(IQCirclePublicAccountMessageService.class, "")).getQCirclePublicAccountStaggerPreloadTriggerCount();
            QLog.i("QFSPublicAccountStaggerFragment", 1, "initBlockPart, preload trigger count, value = " + qCirclePublicAccountStaggerPreloadTriggerCount);
            blockContainer.getBlockMerger().setStaggeredRemainCountToTriggerPreload(qCirclePublicAccountStaggerPreloadTriggerCount);
        }
        blockContainer.setEnableRefresh(true);
        RefreshHeaderView refreshHeaderView = new RefreshHeaderView(blockContainer.getContext());
        refreshHeaderView.setOnRefreshListener(blockContainer.getBlockMerger());
        blockContainer.setRefreshHeader(refreshHeaderView);
        blockContainer.setEnableLoadMore(true);
    }

    private final void ci() {
        Resources resources;
        Drawable drawable;
        View findViewById = ((QCircleBaseFragment) this).mContentView.findViewById(R.id.f55612id);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewByI\u2026s_top_gradient_mask_view)");
        this.gradientMaskView = findViewById;
        Context context = getContext();
        if (context != null && (resources = context.getResources()) != null && (drawable = resources.getDrawable(R.drawable.f162084l94)) != null) {
            View view = this.gradientMaskView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gradientMaskView");
                view = null;
            }
            view.setBackground(drawable);
        }
    }

    private final void di() {
        View findViewById = ((QCircleBaseFragment) this).mContentView.findViewById(R.id.ijw);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewById(R.id.search_icon)");
        ImageView imageView = (ImageView) findViewById;
        this.searchIcon = imageView;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchIcon");
            imageView = null;
        }
        imageView.setVisibility(0);
        ImageView imageView3 = this.searchIcon;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchIcon");
            imageView3 = null;
        }
        imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSPublicAccountStaggerFragment.ei(QFSPublicAccountStaggerFragment.this, view);
            }
        });
        ImageView imageView4 = this.searchIcon;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchIcon");
        } else {
            imageView2 = imageView4;
        }
        VideoReport.setElementId(imageView2, QCircleDaTongConstant.ElementId.EM_XSJ_SEARCH_BUTTON);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ei(QFSPublicAccountStaggerFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QFSSearchBean qFSSearchBean = new QFSSearchBean();
        qFSSearchBean.setUserSource(6);
        com.tencent.biz.qqcircle.launcher.c.y0(this$0.getContext(), qFSSearchBean);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void fi() {
        if (!HostAppSettingUtil.isDebugVersion()) {
            return;
        }
        ImageView selfCheckIcon = (ImageView) ((QCircleBaseFragment) this).mContentView.findViewById(R.id.f82894i4);
        j50.b bVar = new j50.b();
        Intrinsics.checkNotNullExpressionValue(selfCheckIcon, "selfCheckIcon");
        bVar.b(selfCheckIcon);
        this.selfCheckController = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QCircleInitBean getInitBean() {
        QCircleInitBean qCircleInitBean = getQCircleInitBean();
        if (qCircleInitBean == null) {
            return new QCircleInitBean();
        }
        return qCircleInitBean;
    }

    private final void gi() {
        QCircleFullScreenStatusView qCircleFullScreenStatusView = new QCircleFullScreenStatusView(getContext());
        qCircleFullScreenStatusView.setOnRetryClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSPublicAccountStaggerFragment.hi(QFSPublicAccountStaggerFragment.this, view);
            }
        });
        qCircleFullScreenStatusView.setEmptyImageAndText(5, uq3.c.A3(), qCircleFullScreenStatusView.getContext().getString(R.string.f183003i0));
        this.statusView = qCircleFullScreenStatusView;
        BlockPart blockPart = this.blockPart;
        QCircleFullScreenStatusView qCircleFullScreenStatusView2 = null;
        if (blockPart == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blockPart");
            blockPart = null;
        }
        BlockContainer blockContainer = blockPart.getBlockContainer();
        QCircleFullScreenStatusView qCircleFullScreenStatusView3 = this.statusView;
        if (qCircleFullScreenStatusView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusView");
        } else {
            qCircleFullScreenStatusView2 = qCircleFullScreenStatusView3;
        }
        blockContainer.setStatusViewInterface(qCircleFullScreenStatusView2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hi(QFSPublicAccountStaggerFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        o oVar = this$0.feedsAdapter;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedsAdapter");
            oVar = null;
        }
        oVar.x0(true);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ii(QFSPublicAccountStaggerFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void initTitleBar() {
        View findViewById = ((QCircleBaseFragment) this).mContentView.findViewById(R.id.a4a);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewById(R.id.back_icon)");
        ImageView imageView = (ImageView) findViewById;
        this.backIcon = imageView;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backIcon");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSPublicAccountStaggerFragment.ii(QFSPublicAccountStaggerFragment.this, view);
            }
        });
        View findViewById2 = ((QCircleBaseFragment) this).mContentView.findViewById(R.id.f166992jq2);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mContentView.findViewById(R.id.title_text)");
        TextView textView = (TextView) findViewById2;
        this.titleText = textView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleText");
            textView = null;
        }
        textView.setText(uq3.c.W2());
        View findViewById3 = ((QCircleBaseFragment) this).mContentView.findViewById(R.id.f06);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mContentView.findViewById(R.id.more_icon)");
        ImageView imageView3 = (ImageView) findViewById3;
        this.moreIcon = imageView3;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moreIcon");
        } else {
            imageView2 = imageView3;
        }
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSPublicAccountStaggerFragment.ji(view);
            }
        });
        di();
        fi();
        Zh();
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(QFSPublicAccountStaggeredViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QFSPublicAc\u2026redViewModel::class.java)");
        QFSPublicAccountStaggeredViewModel qFSPublicAccountStaggeredViewModel = (QFSPublicAccountStaggeredViewModel) viewModel;
        this.viewModel = qFSPublicAccountStaggeredViewModel;
        QFSPublicAccountStaggeredViewModel qFSPublicAccountStaggeredViewModel2 = null;
        if (qFSPublicAccountStaggeredViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            qFSPublicAccountStaggeredViewModel = null;
        }
        LiveData<UIStateData<List<e30.b>>> Z1 = qFSPublicAccountStaggeredViewModel.Z1();
        final QFSPublicAccountStaggerFragment$initViewModel$1 qFSPublicAccountStaggerFragment$initViewModel$1 = new QFSPublicAccountStaggerFragment$initViewModel$1(this);
        Z1.observe(this, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSPublicAccountStaggerFragment.ki(Function1.this, obj);
            }
        });
        QFSPublicAccountStaggeredViewModel qFSPublicAccountStaggeredViewModel3 = this.viewModel;
        if (qFSPublicAccountStaggeredViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            qFSPublicAccountStaggeredViewModel3 = null;
        }
        LiveData<UIStateData<List<JSONObject>>> b26 = qFSPublicAccountStaggeredViewModel3.b2();
        final QFSPublicAccountStaggerFragment$initViewModel$2 qFSPublicAccountStaggerFragment$initViewModel$2 = new QFSPublicAccountStaggerFragment$initViewModel$2(this);
        b26.observe(this, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.t
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSPublicAccountStaggerFragment.li(Function1.this, obj);
            }
        });
        QFSPublicAccountStaggeredViewModel qFSPublicAccountStaggeredViewModel4 = this.viewModel;
        if (qFSPublicAccountStaggeredViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            qFSPublicAccountStaggeredViewModel4 = null;
        }
        qFSPublicAccountStaggeredViewModel4.e2(getInitBean());
        if (ni()) {
            QFSPublicAccountStaggeredViewModel qFSPublicAccountStaggeredViewModel5 = this.viewModel;
            if (qFSPublicAccountStaggeredViewModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                qFSPublicAccountStaggeredViewModel5 = null;
            }
            qFSPublicAccountStaggeredViewModel5.W1(getInitBean());
        }
        QFSPublicAccountStaggeredViewModel qFSPublicAccountStaggeredViewModel6 = this.viewModel;
        if (qFSPublicAccountStaggeredViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            qFSPublicAccountStaggeredViewModel6 = null;
        }
        qFSPublicAccountStaggeredViewModel6.g2();
        if (QFSPublicAccountFollowUsersManager.f86913a.h()) {
            QFSPublicAccountStaggeredViewModel qFSPublicAccountStaggeredViewModel7 = this.viewModel;
            if (qFSPublicAccountStaggeredViewModel7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                qFSPublicAccountStaggeredViewModel7 = null;
            }
            LiveData<UIStateData<FeedCloudOfficialaccount$OfficialTopFollowUsersRsp>> a26 = qFSPublicAccountStaggeredViewModel7.a2();
            final QFSPublicAccountStaggerFragment$initViewModel$3 qFSPublicAccountStaggerFragment$initViewModel$3 = new QFSPublicAccountStaggerFragment$initViewModel$3(this);
            a26.observe(this, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.u
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QFSPublicAccountStaggerFragment.mi(Function1.this, obj);
                }
            });
            QFSPublicAccountStaggeredViewModel qFSPublicAccountStaggeredViewModel8 = this.viewModel;
            if (qFSPublicAccountStaggeredViewModel8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                qFSPublicAccountStaggeredViewModel2 = qFSPublicAccountStaggeredViewModel8;
            }
            qFSPublicAccountStaggeredViewModel2.n2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ji(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QCirclePublicAccountLauncher qCirclePublicAccountLauncher = QCirclePublicAccountLauncher.INSTANCE;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "it.context");
        qCirclePublicAccountLauncher.launchQCirclePublicAccountDetailPage(context);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ki(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void li(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mi(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final boolean ni() {
        return PreLoader.exists("2020");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oi() {
        ((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).requestMaskAdAndDownloadFile();
    }

    private final void pi() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        if (!uq3.o.B1()) {
            RFWLog.d(getTAG(), RFWLog.USR, "[preloadFirstFeed] current not enabled preload first feed.");
            return;
        }
        try {
            QCircleInitBean initBean = getInitBean();
            FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = null;
            if (initBean != null) {
                feedCloudMeta$StFeed = initBean.getFeed();
            } else {
                feedCloudMeta$StFeed = null;
            }
            if (feedCloudMeta$StFeed == null) {
                RFWLog.d(getTAG(), RFWLog.USR, "[preloadFirstFeed] current feed is null.");
                return;
            }
            QCircleInitBean initBean2 = getInitBean();
            if (initBean2 != null) {
                feedCloudMeta$StFeed2 = initBean2.getFeed();
            }
            String g16 = bj.g(feedCloudMeta$StFeed2);
            if (TextUtils.isEmpty(g16)) {
                RFWLog.d(getTAG(), RFWLog.USR, "[preloadFirstFeed] current feed id should not be null.");
                return;
            }
            RFWLog.d(getTAG(), RFWLog.USR, "[preloadFirstFeed] feed id: " + g16);
            int QQ_CIRCLE_VIDEO = QCircleHostConstants._SceneID.QQ_CIRCLE_VIDEO();
            String i3 = com.tencent.biz.qqcircle.immersive.manager.g.e().i(getReportBean());
            QCircleInitBean initBean3 = getInitBean();
            Intrinsics.checkNotNull(initBean3);
            FeedCloudMeta$StFeed feed = initBean3.getFeed();
            Intrinsics.checkNotNullExpressionValue(feed, "initBean!!.feed");
            RFWVideoPreloadManager.g(QQ_CIRCLE_VIDEO).preloadVideo(Ph(feed, true), i3);
        } catch (Throwable th5) {
            RFWLog.e(getTAG(), RFWLog.USR, th5);
        }
    }

    private final List<MultiViewBlock<?>> qi() {
        ArrayList arrayList = new ArrayList();
        if (QFSPublicAccountFollowUsersManager.f86913a.h()) {
            com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.followlist.d dVar = this.followUsersAdapter;
            if (dVar == null) {
                dVar = new com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.followlist.d(getArguments());
                this.followUsersAdapter = dVar;
            }
            arrayList.add(dVar);
        }
        INSTANCE.c();
        o oVar = new o(getArguments(), this.operator);
        this.feedsAdapter = oVar;
        oVar.F0(new o.b() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.QFSPublicAccountStaggerFragment$preparedPageViewAdapter$1
            @Override // com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.o.b
            public void onRefresh() {
                QFSPublicAccountStaggeredViewModel qFSPublicAccountStaggeredViewModel;
                QCircleInitBean initBean;
                qFSPublicAccountStaggeredViewModel = QFSPublicAccountStaggerFragment.this.viewModel;
                if (qFSPublicAccountStaggeredViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    qFSPublicAccountStaggeredViewModel = null;
                }
                initBean = QFSPublicAccountStaggerFragment.this.getInitBean();
                QFSPublicAccountStaggeredViewModel.i2(qFSPublicAccountStaggeredViewModel, initBean, null, 2, null);
            }

            @Override // com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.o.b
            public void s() {
                QFSPublicAccountStaggeredViewModel qFSPublicAccountStaggeredViewModel;
                QCircleInitBean initBean;
                qFSPublicAccountStaggeredViewModel = QFSPublicAccountStaggerFragment.this.viewModel;
                if (qFSPublicAccountStaggeredViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    qFSPublicAccountStaggeredViewModel = null;
                }
                initBean = QFSPublicAccountStaggerFragment.this.getInitBean();
                final QFSPublicAccountStaggerFragment qFSPublicAccountStaggerFragment = QFSPublicAccountStaggerFragment.this;
                qFSPublicAccountStaggeredViewModel.f2(initBean, new Function0<List<? extends String>>() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.QFSPublicAccountStaggerFragment$preparedPageViewAdapter$1$onLoadMore$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final List<? extends String> invoke() {
                        o oVar2;
                        List<? extends String> emptyList;
                        int collectionSizeOrDefault;
                        oVar2 = QFSPublicAccountStaggerFragment.this.feedsAdapter;
                        if (oVar2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("feedsAdapter");
                            oVar2 = null;
                        }
                        List<e30.b> dataList = oVar2.getDataList();
                        if (dataList != null) {
                            List<e30.b> list = dataList;
                            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                            Iterator<T> it = list.iterator();
                            while (it.hasNext()) {
                                arrayList2.add(((e30.b) it.next()).g().f398449id.get());
                            }
                            return arrayList2;
                        }
                        emptyList = CollectionsKt__CollectionsKt.emptyList();
                        return emptyList;
                    }
                });
            }

            @Override // com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.o.b
            public void s9() {
                QFSPublicAccountStaggeredViewModel qFSPublicAccountStaggeredViewModel;
                QCircleInitBean initBean;
                qFSPublicAccountStaggeredViewModel = QFSPublicAccountStaggerFragment.this.viewModel;
                if (qFSPublicAccountStaggeredViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    qFSPublicAccountStaggeredViewModel = null;
                }
                initBean = QFSPublicAccountStaggerFragment.this.getInitBean();
                qFSPublicAccountStaggeredViewModel.d2(initBean);
            }
        });
        String tag = getTAG();
        o oVar2 = this.feedsAdapter;
        o oVar3 = null;
        if (oVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedsAdapter");
            oVar2 = null;
        }
        t30.f fVar = new t30.f(tag, oVar2, new f.b() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.v
            @Override // t30.f.b
            public final void a(UIStateData uIStateData) {
                QFSPublicAccountStaggerFragment.ri(QFSPublicAccountStaggerFragment.this, uIStateData);
            }
        });
        this.counterWrapper = fVar;
        fVar.a2(1);
        o oVar4 = this.feedsAdapter;
        if (oVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedsAdapter");
        } else {
            oVar3 = oVar4;
        }
        arrayList.add(oVar3);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ri(QFSPublicAccountStaggerFragment this$0, UIStateData it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.Vh(it);
    }

    private final void si() {
        BlockPart blockPart = this.blockPart;
        if (blockPart == null) {
            Intrinsics.throwUninitializedPropertyAccessException("blockPart");
            blockPart = null;
        }
        BlockContainer blockContainer = blockPart.getBlockContainer();
        blockContainer.getBlockMerger().setTryToLoadMoreWhenNotFullScreen(1);
        blockContainer.getBlockMerger().resetTryToLoadMoreCount();
    }

    private final boolean ti(UIStateData<List<e30.b>> uIStateData) {
        boolean z16;
        if (uIStateData.getType() == QFSPublicAccountStaggeredRepo.RequestType.INIT_FETCH_CACHED.ordinal()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        if (ni()) {
            QLog.i("QFSPublicAccountStaggerFragment", 1, "[shouldAutoRefresh] isNeedPreLoad");
            return false;
        }
        boolean isEmpty = uIStateData.getData().isEmpty();
        this.isCachedEmpty = isEmpty;
        QLog.i("QFSPublicAccountStaggerFragment", 1, "[shouldAutoRefresh] isCachedEmpty=" + isEmpty);
        return this.isCachedEmpty;
    }

    private final boolean ui() {
        return Intrinsics.areEqual("exp_xsj_gzh_publishButton_B", com.tencent.biz.qqcircle.utils.l.b("exp_xsj_gzh_publishButton"));
    }

    private final void vi() {
        if (ni()) {
            BlockPart blockPart = this.blockPart;
            if (blockPart == null) {
                Intrinsics.throwUninitializedPropertyAccessException("blockPart");
                blockPart = null;
            }
            blockPart.getBlockContainer().getBlockMerger().getRefreshViewProvider().setState(4);
        }
    }

    private final String wi(List<e30.b> list) {
        String joinToString$default;
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(list, null, null, null, 0, null, new Function1<e30.b, CharSequence>() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.QFSPublicAccountStaggerFragment$toPrintText$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(@Nullable e30.b bVar) {
                FeedCloudMeta$StFeed g16;
                PBStringField pBStringField;
                String str = (bVar == null || (g16 = bVar.g()) == null || (pBStringField = g16.f398449id) == null) ? null : pBStringField.get();
                return str == null ? "" : str;
            }
        }, 31, null);
        return joinToString$default;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        BlockPart blockPart = new BlockPart(R.id.f34310yt, qi(), 3, 2);
        this.blockPart = blockPart;
        arrayList.add(blockPart);
        arrayList.add(new ea());
        if (ui()) {
            QCirclePublishFeedPart qCirclePublishFeedPart = new QCirclePublishFeedPart(QCirclePluginGlobalInfo.m());
            qCirclePublishFeedPart.setReportBean(getReportBean());
            qCirclePublishFeedPart.Ga(25);
            arrayList.add(qCirclePublishFeedPart);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.goh;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    @NotNull
    public String getDaTongPageId() {
        return QCircleDaTongConstant.PageId.PG_XSJ_GZH_DOUBLE_COLUMN_PAGE;
    }

    @NotNull
    public final List<e30.b> getFeedList() {
        List<e30.b> list;
        o oVar = this.feedsAdapter;
        if (oVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedsAdapter");
            oVar = null;
        }
        List<e30.b> dataList = oVar.getDataList();
        Intrinsics.checkNotNullExpressionValue(dataList, "feedsAdapter.dataList");
        list = CollectionsKt___CollectionsKt.toList(dataList);
        return list;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSPublicAccountStaggerFragment";
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment
    public int getPageId() {
        return 306;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return false;
        }
        activity.finish();
        IChatApi iChatApi = (IChatApi) QRoute.api(IChatApi.class);
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        iChatApi.overrideActivityAnimation((Activity) context, false);
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        QFSPublicAccountNegativePopup qFSPublicAccountNegativePopup = this.negativePopup;
        if (qFSPublicAccountNegativePopup != null) {
            qFSPublicAccountNegativePopup.dismissAllowingStateLoss();
        }
        Oh();
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        QFSHodorCollectManager.f84689a.b("qfs_public_account_begin_business");
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.presentation.w
            @Override // java.lang.Runnable
            public final void run() {
                QFSPublicAccountStaggerFragment.oi();
            }
        });
        this.lastEnterTime = System.currentTimeMillis();
        QCircleListenerProxyManager.getInstance().addQQFrontBackListener(this.frontBackListener);
        View onCreateView = super.onCreateView(inflater, container, savedInstanceState);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        FragmentManager fragmentManager;
        QFSPublicAccountNegativePopup qFSPublicAccountNegativePopup;
        super.onDestroy();
        QFSPublicAccountNegativePopup qFSPublicAccountNegativePopup2 = this.negativePopup;
        if (qFSPublicAccountNegativePopup2 != null) {
            fragmentManager = qFSPublicAccountNegativePopup2.getFragmentManager();
        } else {
            fragmentManager = null;
        }
        if (fragmentManager != null && (qFSPublicAccountNegativePopup = this.negativePopup) != null) {
            qFSPublicAccountNegativePopup.dismissAllowingStateLoss();
        }
        QFSHodorCollectManager.f84689a.b("qfs_public_account_end_business");
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        BaseQQAppInterface baseQQAppInterface;
        ((IQCirclePublicAccountRefreshCtrl) QRoute.api(IQCirclePublicAccountRefreshCtrl.class)).updateStaggeredExitTime();
        j50.b bVar = this.selfCheckController;
        if (bVar != null) {
            bVar.d();
        }
        com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.ad.v.f86780a.e();
        this.xingHuanAdMaskInterceptor.d();
        AppInterface appInterface = QCircleServiceImpl.getAppInterface();
        if (appInterface instanceof BaseQQAppInterface) {
            baseQQAppInterface = (BaseQQAppInterface) appInterface;
        } else {
            baseQQAppInterface = null;
        }
        if (baseQQAppInterface != null) {
            ((IQCirclePublicAccountReporter) QRoute.api(IQCirclePublicAccountReporter.class)).reportRedPointBack(baseQQAppInterface, NetConnInfoCenter.getServerTimeMillis() - this.lastEnterTime, 1);
        }
        QCircleListenerProxyManager.getInstance().removeQQFrontBackListener(this.frontBackListener);
        super.onDestroyView();
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        SimpleEventBus.getInstance().dispatchEvent(new QFSPublicAccountStaggerLifecycleEvent(2));
        com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.g.f87070a.o(getInitBean());
        com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.ad.v.f86780a.d();
        ((IQCircleRMonitorApi) QRoute.api(IQCircleRMonitorApi.class)).traceEnd("QFSPublicAccountStaggerPage");
        t30.f fVar = this.counterWrapper;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("counterWrapper");
            fVar = null;
        }
        fVar.onPause();
    }

    @Override // com.tencent.biz.qqcircle.fragments.QCircleBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Context context;
        super.onResume();
        ((IQCircleRMonitorApi) QRoute.api(IQCircleRMonitorApi.class)).traceStart("QFSPublicAccountStaggerPage");
        SimpleEventBus.getInstance().dispatchEvent(new QFSPublicAccountStaggerLifecycleEvent(1));
        com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.report.g.f87070a.f();
        com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.ad.v.f86780a.f();
        if (ui() && (context = getContext()) != null) {
            ((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).preloadQQWink(context);
        }
        QFSQUIUtilsKt.i(getActivity(), R.color.qui_common_bg_nav_secondary);
        t30.f fVar = this.counterWrapper;
        if (fVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("counterWrapper");
            fVar = null;
        }
        fVar.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreatedAfterPartInit(view, savedInstanceState);
        initTitleBar();
        ci();
        bi();
        gi();
        initViewModel();
        pi();
    }
}

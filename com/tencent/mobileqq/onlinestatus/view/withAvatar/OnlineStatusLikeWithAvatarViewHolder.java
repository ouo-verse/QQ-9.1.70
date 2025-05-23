package com.tencent.mobileqq.onlinestatus.view.withAvatar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseBusinessHandler;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.onlinestatus.af;
import com.tencent.mobileqq.onlinestatus.api.IAvatarStatusViewApi;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.au;
import com.tencent.mobileqq.onlinestatus.be;
import com.tencent.mobileqq.onlinestatus.bs;
import com.tencent.mobileqq.onlinestatus.model.AvatarStatusViewScene;
import com.tencent.mobileqq.onlinestatus.music.OnlineStatusHandler;
import com.tencent.mobileqq.onlinestatus.music.OnlineStatusLyricView;
import com.tencent.mobileqq.onlinestatus.networkhandler.CustomHandler;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils;
import com.tencent.mobileqq.onlinestatus.utils.ae;
import com.tencent.mobileqq.onlinestatus.utils.ag;
import com.tencent.mobileqq.onlinestatus.view.aj;
import com.tencent.mobileqq.onlinestatus.view.withAvatar.OnlineStatusLikeWithAvatarViewHolder$avatarEventListener$2;
import com.tencent.mobileqq.onlinestatus.view.withAvatar.OnlineStatusLikeWithAvatarViewHolder$lyricListener$2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.util.ab;
import com.tencent.mobileqq.util.cz;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vashealth.api.IQQHealthStatusApi;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.RoundRectImageView;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.onlinestatus.OnlineStatusShareInfo$ShareInfoItem;
import trpc.qq_status_rank.status_rank_mgr.StatusRankMgr$StatusRankRequest;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00dc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 F2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u00ae\u0001B\"\u0012\u0007\u0010\u00ab\u0001\u001a\u00020J\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010X\u001a\u00020U\u00a2\u0006\u0006\b\u00ac\u0001\u0010\u00ad\u0001J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\tH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\tH\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\u0018\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\tH\u0002J\u0018\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0018\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0018\u0010'\u001a\u00020\t2\u0006\u0010&\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u0006H\u0002J\u0010\u0010(\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0006H\u0002J\b\u0010)\u001a\u00020\u0004H\u0002J\b\u0010+\u001a\u00020*H\u0002J\u0010\u0010,\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0006H\u0002J\u0010\u0010-\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010.\u001a\u00020\u0004H\u0002J\u0010\u00100\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\tH\u0002J \u00104\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u00101\u001a\u00020\u00142\u0006\u00103\u001a\u000202H\u0002J\b\u00105\u001a\u00020\u0004H\u0002J\b\u00106\u001a\u00020\u0004H\u0002J\u0010\u00107\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u0014H\u0002J\b\u00108\u001a\u00020\u0004H\u0002J\b\u00109\u001a\u00020\u0004H\u0002J\b\u0010:\u001a\u00020\u0004H\u0002J\u000e\u0010;\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019J\u0018\u0010?\u001a\u00020\u00042\u0006\u0010=\u001a\u00020<2\b\b\u0002\u0010>\u001a\u00020\tJ\u0006\u0010@\u001a\u00020\u0004J\u000e\u0010C\u001a\u00020\u00042\u0006\u0010B\u001a\u00020AJ\u000e\u0010E\u001a\u00020\u00042\u0006\u0010D\u001a\u00020\u0011J\u0006\u0010F\u001a\u00020\u0004J\u0018\u0010I\u001a\u00020\u00042\u0006\u0010G\u001a\u00020\u00062\u0006\u0010H\u001a\u00020\u0006H\u0016J\u0012\u0010L\u001a\u00020\u00042\b\u0010K\u001a\u0004\u0018\u00010JH\u0016J\u0016\u0010O\u001a\u00020\u00042\u0006\u0010M\u001a\u00020\u00062\u0006\u0010N\u001a\u00020\u0006J\u0016\u0010Q\u001a\u00020\u00042\u0006\u0010G\u001a\u00020\u00062\u0006\u0010P\u001a\u00020\u0006J\u0016\u0010R\u001a\u00020\u00042\u0006\u0010G\u001a\u00020\u00062\u0006\u0010P\u001a\u00020\u0006J\u0006\u0010S\u001a\u00020\u0004R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0014\u0010X\u001a\u00020U8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bV\u0010WR<\u0010`\u001a\u001c\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0004\u0018\u00010Y8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u0014\u0010d\u001a\u00020a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u0014\u0010f\u001a\u00020J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010eR\u0014\u0010i\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bg\u0010hR\u0014\u0010m\u001a\u00020j8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bk\u0010lR\u0014\u0010o\u001a\u00020j8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bn\u0010lR\u0014\u0010s\u001a\u00020p8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bq\u0010rR\u0014\u0010u\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bt\u0010hR\u0014\u0010v\u001a\u00020j8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\\\u0010lR\u0014\u0010w\u001a\u00020j8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010lR\u0014\u0010z\u001a\u00020x8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010yR\u0014\u0010|\u001a\u00020j8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b{\u0010lR\u0018\u0010\u007f\u001a\u0004\u0018\u00010}8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010~R\u001f\u0010\u0083\u0001\u001a\u00030\u0080\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b#\u0010\u0081\u0001\u001a\u0005\bn\u0010\u0082\u0001R\u001a\u0010\u0087\u0001\u001a\u00030\u0084\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0017\u0010\u0088\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010+R\u0018\u0010\u008a\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0089\u0001\u0010\u0017R&\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\b'\u0010\u008b\u0001\u001a\u0005\bk\u0010\u008c\u0001\"\u0006\b\u008d\u0001\u0010\u008e\u0001R\u001a\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0017\u0010\u008f\u0001R'\u0010\u0091\u0001\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0004\b@\u0010\u0017\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001\"\u0006\b\u0093\u0001\u0010\u0094\u0001R'\u0010\u0099\u0001\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\b\u0013\u0010\u0095\u0001\u001a\u0005\bg\u0010\u0096\u0001\"\u0006\b\u0097\u0001\u0010\u0098\u0001R\u0017\u0010\u009a\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010+R\u0017\u0010\u009b\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010+R\u0017\u0010\u009c\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010+R'\u0010\u009f\u0001\u001a\u000b \u009d\u0001*\u0004\u0018\u00010J0J8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b8\u0010\u0081\u0001\u001a\u0005\bt\u0010\u009e\u0001R\u001c\u0010\u00a3\u0001\u001a\u0005\u0018\u00010\u00a0\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a1\u0001\u0010\u00a2\u0001R \u0010\u00a7\u0001\u001a\u00030\u00a4\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000f\n\u0006\b\u00a5\u0001\u0010\u0081\u0001\u001a\u0005\bb\u0010\u00a6\u0001R\u001f\u0010\u00aa\u0001\u001a\u00030\u00a8\u00018BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0005\b7\u0010\u0081\u0001\u001a\u0005\bq\u0010\u00a9\u0001\u00a8\u0006\u00af\u0001"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/view/withAvatar/OnlineStatusLikeWithAvatarViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/app/face/FaceDrawable$OnLoadingStateChangeListener;", "Landroid/view/View$OnClickListener;", "", "bindListener", "", "colorType", "G0", "", "show", "z0", "isArrow", "F0", "Lcom/tencent/mobileqq/onlinestatus/manager/a;", "shareInfoCacheManager", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ltencent/im/onlinestatus/OnlineStatusShareInfo$ShareInfoItem;", "info", "b0", "", "urlStr", "tryLoadManageIfFailed", "Z", "q0", "Lcom/tencent/mobileqq/onlinestatus/model/d;", GuildMsgItem.NICK_FRIEND, "Lcom/tencent/mobileqq/onlinestatus/au;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "A0", ViewStickEventHelper.IS_SHOW, "B0", "Landroid/widget/ImageView;", "iv", "C0", "U", "resMapId", "D", "uin", "Y", "s0", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mobileqq/onlinestatus/model/AvatarStatusViewScene;", "I", BdhLogUtil.LogTag.Tag_Req, "T", "r0", "isCenter", BdhLogUtil.LogTag.Tag_Conn, "statusName", "Lmqq/app/AppRuntime$Status;", "status", "W", "e0", "p0", "i0", "f0", "k0", "O", "B", "", "msg", "showArrow", "D0", "a0", "Landroid/graphics/drawable/Drawable;", "drawable", "c0", "infoItem", "d0", "j0", "oldState", "curState", "onLoadingStateChanged", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "oldIndex", "newIndex", "H0", "newState", "I0", "J0", "E", "Lcom/tencent/mobileqq/onlinestatus/manager/a;", "Lcom/tencent/mobileqq/onlinestatus/view/withAvatar/l;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/onlinestatus/view/withAvatar/l;", "extParam", "Lkotlin/Function3;", "G", "Lkotlin/jvm/functions/Function3;", "P", "()Lkotlin/jvm/functions/Function3;", "y0", "(Lkotlin/jvm/functions/Function3;)V", "onItemClickListener", "Lcom/tencent/widget/RoundRectImageView;", "H", "Lcom/tencent/widget/RoundRectImageView;", "ivBg", "Landroid/view/View;", "ivBgMask", "J", "Landroid/widget/ImageView;", "ivTitleStatus", "Landroid/widget/TextView;", "K", "Landroid/widget/TextView;", "tvTitle", "L", "btnSetStatus", "Landroid/widget/FrameLayout;", "M", "Landroid/widget/FrameLayout;", "flFilament", "N", "ivHead", "tvName", "tvRightEntry", "Lcom/tencent/mobileqq/onlinestatus/music/OnlineStatusLyricView;", "Lcom/tencent/mobileqq/onlinestatus/music/OnlineStatusLyricView;", "lyricView", ExifInterface.LATITUDE_SOUTH, "tvSubtitle", "Lcom/tencent/mobileqq/onlinestatus/view/aj;", "Lcom/tencent/mobileqq/onlinestatus/view/aj;", "avatarView", "Lcom/tencent/mobileqq/onlinestatus/view/withAvatar/t;", "Lkotlin/Lazy;", "()Lcom/tencent/mobileqq/onlinestatus/view/withAvatar/t;", "loadingView", "Lcom/tencent/mobileqq/onlinestatus/api/IAvatarStatusViewApi;", "V", "Lcom/tencent/mobileqq/onlinestatus/api/IAvatarStatusViewApi;", "avatarStatusApi", "curPlayState", "X", "hasCustomImage", "Lcom/tencent/mobileqq/onlinestatus/model/d;", "()Lcom/tencent/mobileqq/onlinestatus/model/d;", "setFriend", "(Lcom/tencent/mobileqq/onlinestatus/model/d;)V", "Lcom/tencent/mobileqq/onlinestatus/au;", "onlineItem", "isAutoReplyLoaded", "()Z", "w0", "(Z)V", "Ljava/lang/String;", "()Ljava/lang/String;", "x0", "(Ljava/lang/String;)V", "customImageUrl", "selectedIndex", HippyTKDListViewAdapter.SCROLL_STATE, "curColorType", "kotlin.jvm.PlatformType", "()Landroid/view/View;", "mOnlineStatueContentDescriptionView", "Lh43/a;", "g0", "Lh43/a;", "mGetStepInfoCallback", "Lcom/tencent/mobileqq/onlinestatus/view/aj$a;", "h0", "()Lcom/tencent/mobileqq/onlinestatus/view/aj$a;", "avatarEventListener", "Lcom/tencent/mobileqq/onlinestatus/music/a;", "()Lcom/tencent/mobileqq/onlinestatus/music/a;", "lyricListener", "itemView", "<init>", "(Landroid/view/View;Lcom/tencent/mobileqq/onlinestatus/manager/a;Lcom/tencent/mobileqq/onlinestatus/view/withAvatar/l;)V", "a", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class OnlineStatusLikeWithAvatarViewHolder extends RecyclerView.ViewHolder implements FaceDrawable.OnLoadingStateChangeListener, View.OnClickListener {

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: k0, reason: collision with root package name */
    @NotNull
    private static final com.tencent.mobileqq.onlinestatus.model.d f256693k0 = new com.tencent.mobileqq.onlinestatus.model.d(new com.tencent.qqnt.ntrelation.friendsinfo.bean.d(null, null, 3, null), new com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c(null, null, 3, null));

    /* renamed from: l0, reason: collision with root package name */
    @Nullable
    private static Integer f256694l0;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.onlinestatus.manager.a shareInfoCacheManager;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final OnlineStatusLikeWithAvatarExtParam extParam;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private Function3<? super View, ? super com.tencent.mobileqq.onlinestatus.model.d, ? super Integer, Unit> onItemClickListener;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final RoundRectImageView ivBg;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final View ivBgMask;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final ImageView ivTitleStatus;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final TextView tvTitle;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final TextView btnSetStatus;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final FrameLayout flFilament;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final ImageView ivHead;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final TextView tvName;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final TextView tvRightEntry;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final OnlineStatusLyricView lyricView;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final TextView tvSubtitle;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private aj avatarView;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final Lazy loadingView;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private IAvatarStatusViewApi avatarStatusApi;

    /* renamed from: W, reason: from kotlin metadata */
    private int curPlayState;

    /* renamed from: X, reason: from kotlin metadata */
    private boolean hasCustomImage;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.onlinestatus.model.d friend;

    /* renamed from: Z, reason: from kotlin metadata */
    @Nullable
    private au onlineItem;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private boolean isAutoReplyLoaded;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String customImageUrl;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private int selectedIndex;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private int scrollState;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private int curColorType;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mOnlineStatueContentDescriptionView;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private h43.a mGetStepInfoCallback;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy avatarEventListener;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy lyricListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\fR\u0014\u0010\u0015\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\fR\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/view/withAvatar/OnlineStatusLikeWithAvatarViewHolder$a;", "", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/tencent/mobileqq/onlinestatus/manager/a;", "shareInfoCacheManager", "Lcom/tencent/mobileqq/onlinestatus/view/withAvatar/l;", "extParam", "Lcom/tencent/mobileqq/onlinestatus/view/withAvatar/OnlineStatusLikeWithAvatarViewHolder;", "a", "", "COLOR_BLACK", "I", "COLOR_WHITE", "", "CORNER_RADIUS_DP", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/onlinestatus/model/d;", "EMPTY_ITEM", "Lcom/tencent/mobileqq/onlinestatus/model/d;", "PLAY_STATE_DEFAULT", "PLAY_STATE_RUNNING", "", "TAG", "Ljava/lang/String;", "sCurDisplayIndex", "Ljava/lang/Integer;", "<init>", "()V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.onlinestatus.view.withAvatar.OnlineStatusLikeWithAvatarViewHolder$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final OnlineStatusLikeWithAvatarViewHolder a(@NotNull ViewGroup parent, @NotNull com.tencent.mobileqq.onlinestatus.manager.a shareInfoCacheManager, @NotNull OnlineStatusLikeWithAvatarExtParam extParam) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(shareInfoCacheManager, "shareInfoCacheManager");
            Intrinsics.checkNotNullParameter(extParam, "extParam");
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fqp, parent, false);
            Intrinsics.checkNotNullExpressionValue(view, "view");
            return new OnlineStatusLikeWithAvatarViewHolder(view, shareInfoCacheManager, extParam);
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnlineStatusLikeWithAvatarViewHolder(@NotNull final View itemView, @NotNull com.tencent.mobileqq.onlinestatus.manager.a shareInfoCacheManager, @NotNull OnlineStatusLikeWithAvatarExtParam extParam) {
        super(itemView);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(shareInfoCacheManager, "shareInfoCacheManager");
        Intrinsics.checkNotNullParameter(extParam, "extParam");
        this.shareInfoCacheManager = shareInfoCacheManager;
        this.extParam = extParam;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<t>() { // from class: com.tencent.mobileqq.onlinestatus.view.withAvatar.OnlineStatusLikeWithAvatarViewHolder$loadingView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final t invoke() {
                Context context = itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
                return new t(context, false, 2, null);
            }
        });
        this.loadingView = lazy;
        this.friend = f256693k0;
        this.customImageUrl = "";
        this.selectedIndex = -1;
        this.scrollState = -1;
        this.curColorType = 1;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.onlinestatus.view.withAvatar.OnlineStatusLikeWithAvatarViewHolder$mOnlineStatueContentDescriptionView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                View findViewById = itemView.findViewById(R.id.zxr);
                findViewById.setOnClickListener(this);
                findViewById.setVisibility(0);
                return findViewById;
            }
        });
        this.mOnlineStatueContentDescriptionView = lazy2;
        View findViewById = itemView.findViewById(R.id.zxv);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.\u2026nline_status_content_img)");
        RoundRectImageView roundRectImageView = (RoundRectImageView) findViewById;
        this.ivBg = roundRectImageView;
        View findViewById2 = itemView.findViewById(R.id.zxw);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.\u2026_status_content_img_mask)");
        this.ivBgMask = findViewById2;
        View findViewById3 = itemView.findViewById(R.id.zxu);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.\u2026line_status_content_icon)");
        this.ivTitleStatus = (ImageView) findViewById3;
        View findViewById4 = itemView.findViewById(R.id.zxx);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.\u2026line_status_content_info)");
        this.tvTitle = (TextView) findViewById4;
        View findViewById5 = itemView.findViewById(R.id.zyc);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.\u2026ne_status_set_status_btn)");
        TextView textView = (TextView) findViewById5;
        this.btnSetStatus = textView;
        if (ab.a() && AppSetting.f99565y) {
            AccessibilityUtil.c(textView, HardCodeUtil.qqStr(R.string.f225596m2), Button.class.getName());
        }
        View findViewById6 = itemView.findViewById(R.id.zxs);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.\u2026_content_filament_layout)");
        this.flFilament = (FrameLayout) findViewById6;
        View findViewById7 = itemView.findViewById(R.id.zxt);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "itemView.findViewById(R.\u2026line_status_content_head)");
        this.ivHead = (ImageView) findViewById7;
        View findViewById8 = itemView.findViewById(R.id.zxy);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "itemView.findViewById(R.\u2026line_status_content_name)");
        this.tvName = (TextView) findViewById8;
        View findViewById9 = itemView.findViewById(R.id.f166463zy3);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "itemView.findViewById(R.\u2026_content_sub_title_lyric)");
        OnlineStatusLyricView onlineStatusLyricView = (OnlineStatusLyricView) findViewById9;
        this.lyricView = onlineStatusLyricView;
        View findViewById10 = itemView.findViewById(R.id.f166462zy2);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "itemView.findViewById(R.\u2026status_content_sub_title)");
        this.tvSubtitle = (TextView) findViewById10;
        onlineStatusLyricView.setUseDefaultTextViewWhenNoLyrics(true);
        onlineStatusLyricView.setCompoundDrawables(null, null, null, null);
        onlineStatusLyricView.setMaxTextWidth(itemView.getResources().getDisplayMetrics().widthPixels - ViewUtils.dpToPx(72.0f));
        View findViewById11 = itemView.findViewById(R.id.zxz);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "itemView.findViewById(R.\u2026atus_content_right_entry)");
        this.tvRightEntry = (TextView) findViewById11;
        itemView.setBackground(null);
        roundRectImageView.setVisibility(0);
        roundRectImageView.setCornerRadiusAndMode(ViewUtils.dpToPx(12.0f), 1);
        QRouteApi api = QRoute.api(IAvatarStatusViewApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAvatarStatusViewApi::class.java)");
        this.avatarStatusApi = (IAvatarStatusViewApi) api;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<OnlineStatusLikeWithAvatarViewHolder$avatarEventListener$2.a>() { // from class: com.tencent.mobileqq.onlinestatus.view.withAvatar.OnlineStatusLikeWithAvatarViewHolder$avatarEventListener$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a(OnlineStatusLikeWithAvatarViewHolder.this);
            }

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/onlinestatus/view/withAvatar/OnlineStatusLikeWithAvatarViewHolder$avatarEventListener$2$a", "Lcom/tencent/mobileqq/onlinestatus/view/aj$a;", "", "success", "", "onLoad", "a", "", "dressKey", "b", NodeProps.ON_CLICK, "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes16.dex */
            public static final class a implements aj.a {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ OnlineStatusLikeWithAvatarViewHolder f256704a;

                a(OnlineStatusLikeWithAvatarViewHolder onlineStatusLikeWithAvatarViewHolder) {
                    this.f256704a = onlineStatusLikeWithAvatarViewHolder;
                }

                @Override // com.tencent.mobileqq.onlinestatus.view.aj.a
                public void a() {
                    t L;
                    L = this.f256704a.L();
                    L.hide();
                }

                @Override // com.tencent.mobileqq.onlinestatus.view.aj.a
                public void onClick() {
                    FrameLayout frameLayout;
                    Function3<View, com.tencent.mobileqq.onlinestatus.model.d, Integer, Unit> P = this.f256704a.P();
                    if (P != null) {
                        frameLayout = this.f256704a.flFilament;
                        P.invoke(frameLayout, this.f256704a.getFriend(), Integer.valueOf(this.f256704a.getAdapterPosition()));
                    }
                }

                @Override // com.tencent.mobileqq.onlinestatus.view.aj.a
                public void onLoad(boolean success) {
                    t L;
                    OnlineStatusLikeWithAvatarExtParam onlineStatusLikeWithAvatarExtParam;
                    au auVar;
                    if (!success) {
                        auVar = this.f256704a.onlineItem;
                        if (auVar != null) {
                            this.f256704a.T(auVar);
                        }
                    } else {
                        L = this.f256704a.L();
                        L.hide();
                    }
                    onlineStatusLikeWithAvatarExtParam = this.f256704a.extParam;
                    OnlineStatusLikeWithAvatarReporter reporter = onlineStatusLikeWithAvatarExtParam.getReporter();
                    if (reporter != null) {
                        reporter.b(this.f256704a.getAdapterPosition(), success);
                    }
                }

                @Override // com.tencent.mobileqq.onlinestatus.view.aj.a
                public void b(@Nullable String dressKey) {
                }
            }
        });
        this.avatarEventListener = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<OnlineStatusLikeWithAvatarViewHolder$lyricListener$2.a>() { // from class: com.tencent.mobileqq.onlinestatus.view.withAvatar.OnlineStatusLikeWithAvatarViewHolder$lyricListener$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/onlinestatus/view/withAvatar/OnlineStatusLikeWithAvatarViewHolder$lyricListener$2$a", "Lcom/tencent/mobileqq/onlinestatus/music/a;", "", "b", "a", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes16.dex */
            public static final class a implements com.tencent.mobileqq.onlinestatus.music.a {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ OnlineStatusLikeWithAvatarViewHolder f256705a;

                a(OnlineStatusLikeWithAvatarViewHolder onlineStatusLikeWithAvatarViewHolder) {
                    this.f256705a = onlineStatusLikeWithAvatarViewHolder;
                }

                @Override // com.tencent.mobileqq.onlinestatus.music.a
                public void a() {
                    OnlineStatusLyricView onlineStatusLyricView;
                    TextView textView;
                    onlineStatusLyricView = this.f256705a.lyricView;
                    onlineStatusLyricView.setVisibility(8);
                    textView = this.f256705a.tvSubtitle;
                    textView.setVisibility(8);
                }

                @Override // com.tencent.mobileqq.onlinestatus.music.a
                public void b() {
                    OnlineStatusLyricView onlineStatusLyricView;
                    OnlineStatusLyricView onlineStatusLyricView2;
                    TextView textView;
                    ArrayList<com.tencent.mobileqq.lyric.data.d> arrayList;
                    OnlineStatusLyricView onlineStatusLyricView3;
                    TextView textView2;
                    OnlineStatusLyricView onlineStatusLyricView4;
                    TextView textView3;
                    onlineStatusLyricView = this.f256705a.lyricView;
                    if (!onlineStatusLyricView.d()) {
                        onlineStatusLyricView2 = this.f256705a.lyricView;
                        onlineStatusLyricView2.setVisibility(8);
                        textView = this.f256705a.tvSubtitle;
                        textView.setVisibility(8);
                        return;
                    }
                    String str = "";
                    IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IOnlineStatusManagerService.class, "");
                    Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ.peekAppRuntime\u2026va, ProcessConstant.MAIN)");
                    com.tencent.mobileqq.lyric.data.b j3 = ((com.tencent.mobileqq.onlinestatus.manager.e) ((IOnlineStatusManagerService) runtimeService).getManager(com.tencent.mobileqq.onlinestatus.manager.e.class)).j(this.f256705a.getFriend().getStatus().V());
                    String str2 = null;
                    if (j3 != null) {
                        arrayList = j3.f243142b;
                    } else {
                        arrayList = null;
                    }
                    if (arrayList != null && (!arrayList.isEmpty())) {
                        com.tencent.mobileqq.lyric.data.d dVar = arrayList.get(0);
                        if (dVar != null) {
                            str2 = dVar.f243148a;
                        }
                        if (str2 != null) {
                            str = str2;
                        }
                    }
                    onlineStatusLyricView3 = this.f256705a.lyricView;
                    onlineStatusLyricView3.setFriendSession(this.f256705a.getFriend().getStatus(), str);
                    textView2 = this.f256705a.tvTitle;
                    textView2.setText(str);
                    onlineStatusLyricView4 = this.f256705a.lyricView;
                    onlineStatusLyricView4.setVisibility(0);
                    textView3 = this.f256705a.tvSubtitle;
                    textView3.setVisibility(0);
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
                return new a(OnlineStatusLikeWithAvatarViewHolder.this);
            }
        });
        this.lyricListener = lazy4;
    }

    private final void A() {
        o.b("fila_add_spend");
        this.flFilament.setVisibility(0);
        this.flFilament.setOnClickListener(this);
        IAvatarStatusViewApi iAvatarStatusViewApi = this.avatarStatusApi;
        Context context = this.flFilament.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "flFilament.context");
        aj createIAvatarStatusView = iAvatarStatusViewApi.createIAvatarStatusView(context, I());
        this.avatarView = createIAvatarStatusView;
        if (createIAvatarStatusView != null) {
            View view = createIAvatarStatusView.getView();
            if (view.getParent() instanceof ViewGroup) {
                if (!Intrinsics.areEqual(view.getParent(), this.flFilament)) {
                    ViewParent parent = view.getParent();
                    Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                    ((ViewGroup) parent).removeView(view);
                    this.flFilament.addView(view, new FrameLayout.LayoutParams(-1, -1));
                }
            } else {
                this.flFilament.addView(view, new FrameLayout.LayoutParams(-1, -1));
            }
            createIAvatarStatusView.setEventListener(H());
        }
        o.a("fila_add_spend");
    }

    private final void A0(com.tencent.mobileqq.onlinestatus.model.d friend, au item) {
        o.b("common_ui_spend");
        this.tvName.setText(friend.getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().m());
        if (AppSetting.f99565y) {
            AccessibilityUtil.c(N(), friend.getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().p(), Button.class.getName());
        }
        this.ivHead.setTag(R.id.f923957r, friend.getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x());
        boolean z16 = true;
        Drawable a16 = cz.a(friend.getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x(), 1, this);
        this.ivHead.setTag(friend.getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x());
        this.ivHead.setImageDrawable(a16);
        Drawable b16 = k.b(this.btnSetStatus, R.drawable.qui_add_icon_white);
        if (b16 != null) {
            int dpToPx = ViewUtils.dpToPx(18.0f);
            b16.setBounds(0, 0, dpToPx, dpToPx);
            this.btnSetStatus.setCompoundDrawablesRelative(b16, null, null, null);
        }
        if (item.f255494g != AppRuntime.Status.online || item.f255489b <= 0) {
            z16 = false;
        }
        String displayOnlineStatusInfo = ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).getDisplayOnlineStatusInfo(MobileQQ.sMobileQQ.peekAppRuntime(), friend.getStatus(), this.tvTitle, 1, item, Boolean.valueOf(z16));
        if (!TextUtils.isEmpty(displayOnlineStatusInfo) && !Utils.G(friend.getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x())) {
            this.tvTitle.setText(displayOnlineStatusInfo);
        }
        C0(this.ivTitleStatus, item);
        q0();
        o.a("common_ui_spend");
    }

    private final void B0(boolean isShow) {
        String str;
        String str2;
        String str3;
        if (!isShow) {
            this.tvRightEntry.setVisibility(8);
            return;
        }
        au auVar = this.onlineItem;
        if (auVar != null) {
            str = auVar.f255501n;
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            au auVar2 = this.onlineItem;
            if (auVar2 != null) {
                str2 = auVar2.f255511x;
            } else {
                str2 = null;
            }
            if (!TextUtils.isEmpty(str2)) {
                this.tvRightEntry.setVisibility(0);
                TextView textView = this.tvRightEntry;
                au auVar3 = this.onlineItem;
                if (auVar3 != null) {
                    str3 = auVar3.f255511x;
                } else {
                    str3 = null;
                }
                textView.setText(str3);
                Drawable b16 = k.b(this.tvRightEntry, R.drawable.qui_chevron_right_text_secondary);
                if (b16 != null) {
                    int dpToPx = ViewUtils.dpToPx(12.0f);
                    b16.setBounds(0, ViewUtils.dpToPx(1.0f), dpToPx, ViewUtils.dpToPx(1.0f) + dpToPx);
                    this.tvRightEntry.setCompoundDrawables(null, null, b16, null);
                }
                this.tvRightEntry.setOnClickListener(this);
                return;
            }
        }
        this.tvRightEntry.setVisibility(8);
    }

    private final void C(boolean isCenter) {
        if (isCenter) {
            if (this.tvTitle.getTag(R.id.f9220579) != null) {
                return;
            }
            this.tvTitle.setTag(R.id.f9220579, Boolean.TRUE);
            TextView textView = this.tvTitle;
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            layoutParams2.endToEnd = 0;
            layoutParams2.endToStart = -1;
            textView.setLayoutParams(layoutParams2);
            this.tvTitle.setMaxWidth(Integer.MAX_VALUE);
            ImageView imageView = this.ivTitleStatus;
            ViewGroup.LayoutParams layoutParams3 = imageView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
            layoutParams4.bottomToTop = this.tvSubtitle.getId();
            layoutParams4.bottomToBottom = -1;
            layoutParams4.horizontalBias = 0.5f;
            layoutParams4.setMargins(0, 0, 0, 0);
            imageView.setLayoutParams(layoutParams4);
            OnlineStatusLyricView onlineStatusLyricView = this.lyricView;
            ViewGroup.LayoutParams layoutParams5 = onlineStatusLyricView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams5, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams6 = (ConstraintLayout.LayoutParams) layoutParams5;
            layoutParams6.verticalBias = 0.0f;
            onlineStatusLyricView.setLayoutParams(layoutParams6);
            return;
        }
        if (this.tvTitle.getTag(R.id.f9220579) == null) {
            return;
        }
        this.tvTitle.setTag(R.id.f9220579, null);
        TextView textView2 = this.tvTitle;
        ViewGroup.LayoutParams layoutParams7 = textView2.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams7, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams8 = (ConstraintLayout.LayoutParams) layoutParams7;
        layoutParams8.endToStart = this.btnSetStatus.getId();
        layoutParams8.endToEnd = -1;
        textView2.setLayoutParams(layoutParams8);
        this.tvTitle.setMaxWidth((this.itemView.getMeasuredWidth() - ViewUtils.dpToPx(65.0f)) - this.btnSetStatus.getMeasuredWidth());
        ImageView imageView2 = this.ivTitleStatus;
        ViewGroup.LayoutParams layoutParams9 = imageView2.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams9, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams10 = (ConstraintLayout.LayoutParams) layoutParams9;
        layoutParams10.bottomToTop = -1;
        layoutParams10.horizontalBias = 0.0f;
        layoutParams10.setMargins(ViewUtils.dpToPx(12.0f), ViewUtils.dpToPx(16.0f), 0, 0);
        imageView2.setLayoutParams(layoutParams10);
        OnlineStatusLyricView onlineStatusLyricView2 = this.lyricView;
        ViewGroup.LayoutParams layoutParams11 = onlineStatusLyricView2.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams11, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams12 = (ConstraintLayout.LayoutParams) layoutParams11;
        layoutParams12.verticalBias = 0.5f;
        onlineStatusLyricView2.setLayoutParams(layoutParams12);
    }

    private final void C0(ImageView iv5, au item) {
        iv5.setImageDrawable(af.C().V(item, this.friend.getStatus(), 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(int resMapId, au item) {
        if (bs.w(this.friend.getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x())) {
            R(resMapId);
        } else {
            T(item);
        }
    }

    public static /* synthetic */ void E0(OnlineStatusLikeWithAvatarViewHolder onlineStatusLikeWithAvatarViewHolder, CharSequence charSequence, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        onlineStatusLikeWithAvatarViewHolder.D0(charSequence, z16);
    }

    private final void F0(boolean isArrow) {
        int i3;
        if (isArrow && af.C().m(MobileQQ.sMobileQQ.peekAppRuntime(), this.friend.getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x())) {
            this.tvTitle.setOnClickListener(this);
            if (!(this.tvTitle.getTag() instanceof Integer) || !Intrinsics.areEqual(this.tvTitle.getTag(), Integer.valueOf(this.curColorType))) {
                TextView textView = this.tvTitle;
                if (this.curColorType == 0) {
                    i3 = R.drawable.qui_chevron_right_icon_white;
                } else {
                    i3 = R.drawable.qui_chevron_right;
                }
                Drawable b16 = k.b(textView, i3);
                if (b16 != null) {
                    int dpToPx = ViewUtils.dpToPx(16.0f);
                    b16.setBounds(0, ViewUtils.dpToPx(1.0f), dpToPx, ViewUtils.dpToPx(1.0f) + dpToPx);
                    this.tvTitle.setCompoundDrawables(null, null, b16, null);
                }
                this.tvTitle.setTag(Integer.valueOf(this.curColorType));
                return;
            }
            return;
        }
        this.tvTitle.setOnClickListener(null);
        if (this.tvTitle.getTag() != null) {
            this.tvTitle.setTag(null);
            this.tvTitle.setCompoundDrawablesRelative(null, null, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G0(int colorType) {
        int i3;
        boolean z16;
        TextView textView = this.tvTitle;
        if (colorType == 0) {
            i3 = R.color.qui_common_text_allwhite_primary;
        } else {
            i3 = R.color.qui_common_text_primary;
        }
        int a16 = k.a(textView, i3);
        this.tvTitle.setTextColor(a16);
        this.tvSubtitle.setTextColor(a16);
        this.lyricView.setTextColor(a16);
        this.curColorType = colorType;
        if (this.tvTitle.getTag() != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        F0(z16);
    }

    private final aj.a H() {
        return (aj.a) this.avatarEventListener.getValue();
    }

    private final AvatarStatusViewScene I() {
        OnlineStatusLikeWithAvatarExtParam onlineStatusLikeWithAvatarExtParam = this.extParam;
        if (onlineStatusLikeWithAvatarExtParam == null) {
            return AvatarStatusViewScene.UNKNOWN;
        }
        return be.q(onlineStatusLikeWithAvatarExtParam.getFrom());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final t L() {
        return (t) this.loadingView.getValue();
    }

    private final com.tencent.mobileqq.onlinestatus.music.a M() {
        return (com.tencent.mobileqq.onlinestatus.music.a) this.lyricListener.getValue();
    }

    private final View N() {
        return (View) this.mOnlineStatueContentDescriptionView.getValue();
    }

    private final void O() {
        if (TextUtils.isEmpty(this.friend.getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x())) {
            return;
        }
        StatusRankMgr$StatusRankRequest statusRankMgr$StatusRankRequest = new StatusRankMgr$StatusRankRequest();
        statusRankMgr$StatusRankRequest.status_id.set(1080);
        statusRankMgr$StatusRankRequest.genrank.set(false);
        statusRankMgr$StatusRankRequest.uin.set(Long.parseLong(this.friend.getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x()));
        com.tencent.mobileqq.onlinestatus.olympic.helper.a.a(MobileQQ.sMobileQQ.peekAppRuntime(), statusRankMgr$StatusRankRequest, new u(this.friend, this));
    }

    private final void Q(com.tencent.mobileqq.onlinestatus.manager.a shareInfoCacheManager) {
        AppInterface appInterface;
        BaseBusinessHandler baseBusinessHandler;
        if (shareInfoCacheManager.b(this.friend.getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x())) {
            OnlineStatusShareInfo$ShareInfoItem a16 = shareInfoCacheManager.a(this.friend.getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x());
            if (a16 == null) {
                a0();
                return;
            } else {
                b0(a16);
                return;
            }
        }
        q0();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        CustomHandler customHandler = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            baseBusinessHandler = appInterface.getBusinessHandler(CustomHandler.class.getName());
        } else {
            baseBusinessHandler = null;
        }
        if (baseBusinessHandler instanceof CustomHandler) {
            customHandler = (CustomHandler) baseBusinessHandler;
        }
        if (customHandler != null) {
            customHandler.H2(this.friend.getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x(), new v(this, this.friend.getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x()));
        }
    }

    private final void R(int resMapId) {
        Integer num;
        F0(true);
        B0(true);
        this.btnSetStatus.setTag(R.id.f922357b, Boolean.TRUE);
        o.b("fila_load_spend");
        o.b("fila_start_spend");
        this.flFilament.setVisibility(0);
        C(false);
        L().b(this.flFilament);
        int adapterPosition = getAdapterPosition();
        int i3 = this.selectedIndex;
        if (i3 == adapterPosition || i3 == -1) {
            int i16 = this.scrollState;
            if (i16 != 0 && i16 != -1) {
                return;
            }
            QLog.d("OnlineStatusLikeWithAvatarViewHolder", 1, "handleFilaView, try to update: " + resMapId + ", curIndex=" + i3 + ", friend=" + this.friend.getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().p() + ", tag=" + this.flFilament.getTag() + ", curPlayState=" + this.curPlayState + ", sCurDisplayIndex=" + f256694l0 + ", holder=" + this);
            try {
                if (this.curPlayState == 1 && (num = f256694l0) != null && num.intValue() == adapterPosition) {
                    return;
                }
                f256694l0 = Integer.valueOf(adapterPosition);
                if (this.flFilament.getTag() != null) {
                    Object tag = this.flFilament.getTag();
                    Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.Int");
                    if (((Integer) tag).intValue() == resMapId) {
                        aj ajVar = this.avatarView;
                        if (ajVar != null) {
                            ajVar.c(true);
                        }
                        o.a("fila_start_spend");
                        this.curPlayState = 1;
                    }
                }
                A();
                this.flFilament.setTag(Integer.valueOf(resMapId));
                int t16 = bs.t(this.friend.getStatus(), resMapId);
                QLog.d("OnlineStatusLikeWithAvatarViewHolder", 1, "handleCurrentFilaLoad Battery Status: " + t16);
                aj ajVar2 = this.avatarView;
                if (ajVar2 != null) {
                    ajVar2.b(this.friend.getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x(), resMapId, t16, new aj.LoadOption(null, false, true, 3, null));
                }
                o.a("fila_load_spend");
                this.curPlayState = 1;
            } catch (Throwable th5) {
                QLog.d("OnlineStatusLikeWithAvatarViewHolder", 1, "handleCurrentFilaLoad err: ", th5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void T(au item) {
        boolean z16;
        boolean z17;
        boolean contains$default;
        OnlineStatusLikeWithAvatarReporter reporter = this.extParam.getReporter();
        boolean z18 = false;
        if (reporter != null) {
            reporter.b(getAdapterPosition(), false);
        }
        o.b("default_spend");
        if (this.flFilament.getVisibility() == 0) {
            r0();
        }
        C(true);
        if (com.tencent.mobileqq.friend.status.b.a(this.friend.getStatus().u(), this.friend.getStatus().z()) == 0) {
            String c06 = this.friend.getStatus().c0();
            if (c06 != null && c06.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                String c07 = this.friend.getStatus().c0();
                if (c07 != null) {
                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) c07, (CharSequence) "TIM", false, 2, (Object) null);
                    if (!contains$default) {
                        z17 = true;
                        if (z17) {
                            return;
                        }
                    }
                }
                z17 = false;
                if (z17) {
                }
            } else {
                return;
            }
        }
        CharSequence text = this.tvTitle.getText();
        if (text == null) {
            text = "";
        }
        String obj = text.toString();
        this.lyricView.setFriendSession(this.friend.getStatus(), obj);
        AppRuntime.Status status = item.f255494g;
        Intrinsics.checkNotNullExpressionValue(status, "item.oldStatus");
        W(item, obj, status);
        if (this.customImageUrl.length() == 0) {
            z18 = true;
        }
        if (z18) {
            Q(this.shareInfoCacheManager);
        }
        o.a("default_spend");
    }

    private final void U(final au item) {
        boolean z16;
        final int p16 = bs.p(item);
        s0(p16);
        if (Y(this.friend.getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x(), p16)) {
            if (OnlineStatusToggleUtils.d()) {
                String realImageUrl = bs.B(this.friend.getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x()).f255505r;
                Intrinsics.checkNotNullExpressionValue(realImageUrl, "realImageUrl");
                if (realImageUrl.length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    this.customImageUrl = realImageUrl;
                    this.hasCustomImage = true;
                    Drawable drawable = this.ivBg.getDrawable();
                    URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                    obtain.mLoadingDrawable = drawable;
                    obtain.mFailedDrawable = drawable;
                    this.ivBg.setImageDrawable(URLDrawable.getDrawable(realImageUrl, obtain));
                    G0(0);
                    z0(QQTheme.isNowThemeIsNight());
                    if ((item.f255489b == 1028 && com.tencent.mobileqq.onlinestatus.utils.r.a(MobileQQ.sMobileQQ.peekAppRuntime(), this.friend.getStatus().V())) || AppSetting.o(BaseApplication.getContext())) {
                        if (QLog.isColorLevel()) {
                            QLog.d("OnlineStatusLikeWithAvatarViewHolder", 2, "handleOnlineStatusContent has lyric.");
                        }
                        T(item);
                        return;
                    }
                    D(p16, item);
                    return;
                }
                T(item);
                return;
            }
            this.avatarStatusApi.getNormalBackground(p16, new Function2<String, String, Unit>() { // from class: com.tencent.mobileqq.onlinestatus.view.withAvatar.OnlineStatusLikeWithAvatarViewHolder$handleOnlineStatusContent$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(String str, String str2) {
                    invoke2(str, str2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull String imageUrl, @NotNull String color) {
                    RoundRectImageView roundRectImageView;
                    RoundRectImageView roundRectImageView2;
                    Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
                    Intrinsics.checkNotNullParameter(color, "color");
                    OnlineStatusLikeWithAvatarViewHolder onlineStatusLikeWithAvatarViewHolder = OnlineStatusLikeWithAvatarViewHolder.this;
                    au auVar = item;
                    int i3 = p16;
                    if (!(imageUrl.length() > 0)) {
                        onlineStatusLikeWithAvatarViewHolder.T(auVar);
                        return;
                    }
                    onlineStatusLikeWithAvatarViewHolder.x0(imageUrl);
                    onlineStatusLikeWithAvatarViewHolder.hasCustomImage = true;
                    roundRectImageView = onlineStatusLikeWithAvatarViewHolder.ivBg;
                    Drawable drawable2 = roundRectImageView.getDrawable();
                    URLDrawable.URLDrawableOptions obtain2 = URLDrawable.URLDrawableOptions.obtain();
                    obtain2.mLoadingDrawable = drawable2;
                    obtain2.mFailedDrawable = drawable2;
                    roundRectImageView2 = onlineStatusLikeWithAvatarViewHolder.ivBg;
                    roundRectImageView2.setImageDrawable(URLDrawable.getDrawable(imageUrl, obtain2));
                    onlineStatusLikeWithAvatarViewHolder.G0(0);
                    onlineStatusLikeWithAvatarViewHolder.z0(QQTheme.isNowThemeIsNight());
                    if (auVar.f255489b != 1028 || !com.tencent.mobileqq.onlinestatus.utils.r.a(MobileQQ.sMobileQQ.peekAppRuntime(), onlineStatusLikeWithAvatarViewHolder.getFriend().getStatus().V())) {
                        onlineStatusLikeWithAvatarViewHolder.D(i3, auVar);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("OnlineStatusLikeWithAvatarViewHolder", 2, "handleOnlineStatusContent has lyric.");
                    }
                    onlineStatusLikeWithAvatarViewHolder.T(auVar);
                }
            }, bs.t(this.friend.getStatus(), p16));
            return;
        }
        T(item);
    }

    private final boolean W(au item, String statusName, AppRuntime.Status status) {
        long j3 = item.f255489b;
        if (j3 == 1028) {
            if (!TextUtils.isEmpty(this.friend.getStatus().V()) && System.currentTimeMillis() < this.friend.getStatus().N()) {
                F0(true);
            }
            i0(statusName);
            return true;
        }
        if (j3 == 2017) {
            F0(true);
            k0();
            return true;
        }
        if (j3 == 1030) {
            F0(true);
            p0();
            return true;
        }
        if (j3 == 1040) {
            F0(true);
            f0();
            return true;
        }
        if (j3 == 1080) {
            j0();
            return true;
        }
        if (j3 == 1021) {
            if (!TextUtils.isEmpty(this.friend.getStatus().i0()) && !TextUtils.isEmpty(this.friend.getStatus().g0()) && !TextUtils.isEmpty(this.friend.getStatus().h0())) {
                F0(true);
            }
        } else if (ae.a(status)) {
            e0();
            return true;
        }
        if (this.friend.getStatus().e0() == 1080 && this.friend.getStatus().r() <= 0) {
            O();
            return true;
        }
        if (!TextUtils.isEmpty(item.f255501n)) {
            F0(true);
            return true;
        }
        return false;
    }

    private final boolean Y(String uin, int resMapId) {
        if (this.avatarStatusApi.isSupportAvatarView(resMapId) && this.avatarStatusApi.isDeviceSupportFilament()) {
            return true;
        }
        return false;
    }

    private final void Z(String urlStr, boolean tryLoadManageIfFailed) {
        if (TextUtils.isEmpty(urlStr)) {
            this.customImageUrl = urlStr;
            q0();
            return;
        }
        if (TextUtils.equals(this.customImageUrl, urlStr) && this.hasCustomImage) {
            return;
        }
        try {
            URL url = new URL(urlStr);
            this.customImageUrl = urlStr;
            URLDrawable urlDrawable = URLDrawable.getDrawable(url, URLDrawable.URLDrawableOptions.obtain());
            urlDrawable.setURLDrawableListener(new s(this, this.friend.getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x(), tryLoadManageIfFailed));
            if (urlDrawable.getStatus() == 1) {
                Intrinsics.checkNotNullExpressionValue(urlDrawable, "urlDrawable");
                c0(urlDrawable);
            } else {
                q0();
                urlDrawable.startDownload();
            }
        } catch (MalformedURLException unused) {
            QLog.e("OnlineStatusLikeWithAvatarViewHolder", 1, "Invalid url: " + urlStr);
            q0();
        }
    }

    private final void b0(OnlineStatusShareInfo$ShareInfoItem info) {
        AppRuntime.Status status = ae.c(this.friend.getStatus());
        int i3 = info.status_desc.status.get();
        int i16 = info.status_desc.ex_status.get();
        String infoUrl = info.share_url.get().toStringUtf8();
        int i17 = info.share_type.get();
        String subtitleStr = info.share_wording.get().toStringUtf8();
        if (i3 == status.getValue() && i16 == this.friend.getStatus().e0() && i17 == 1 && !TextUtils.isEmpty(infoUrl)) {
            Intrinsics.checkNotNullExpressionValue(infoUrl, "infoUrl");
            Z(infoUrl, true);
        } else {
            a0();
        }
        Intrinsics.checkNotNullExpressionValue(status, "status");
        if (!com.tencent.mobileqq.onlinestatus.utils.f.e(status, (int) this.friend.getStatus().e0()) && i3 == status.getValue() && i16 == this.friend.getStatus().e0() && !TextUtils.isEmpty(subtitleStr)) {
            Intrinsics.checkNotNullExpressionValue(subtitleStr, "subtitleStr");
            E0(this, subtitleStr, false, 2, null);
        }
    }

    private final void bindListener() {
        this.ivHead.setOnClickListener(this);
        this.tvName.setOnClickListener(this);
        this.ivTitleStatus.setOnClickListener(this);
        this.btnSetStatus.setOnClickListener(this);
    }

    private final void e0() {
        if (!this.isAutoReplyLoaded) {
            hc2.a.c(MobileQQ.sMobileQQ.peekAppRuntime(), this.friend.getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x(), new r(this.friend.getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x(), this));
        }
    }

    private final void f0() {
        StringBuilder sb5 = new StringBuilder();
        if (!TextUtils.isEmpty(this.friend.getStatus().n())) {
            sb5.append(HardCodeUtil.qqStr(R.string.f1637523z));
            sb5.append(this.friend.getStatus().n());
            for (int i3 = 0; i3 < 4; i3++) {
                sb5.append(" ");
            }
        }
        if (!TextUtils.isEmpty(this.friend.getStatus().o())) {
            sb5.append(HardCodeUtil.qqStr(R.string.f16376240));
            sb5.append(this.friend.getStatus().o());
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "stringBuilder.toString()");
        if (!StringUtil.isEmpty(sb6)) {
            E0(this, sb6, false, 2, null);
        }
    }

    private final void i0(String statusName) {
        AppInterface appInterface;
        this.lyricView.setText(statusName);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        BusinessHandler businessHandler = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            businessHandler = appInterface.getBusinessHandler(OnlineStatusHandler.class.getName());
        }
        OnlineStatusHandler onlineStatusHandler = (OnlineStatusHandler) businessHandler;
        if (onlineStatusHandler != null) {
            onlineStatusHandler.I2(this.friend.getStatus());
        }
        this.lyricView.setVisibility(0);
        this.tvSubtitle.setVisibility(0);
        this.lyricView.setLyricStateListener(M());
    }

    private final void k0() {
        String str;
        if (!OnlineStatusToggleUtils.A()) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentAccountUin();
        } else {
            str = null;
        }
        final boolean equals = TextUtils.equals(str, this.friend.getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x());
        if (equals && !((IQQHealthStatusApi) QRoute.api(IQQHealthStatusApi.class)).getStepPermission()) {
            return;
        }
        this.mGetStepInfoCallback = new h43.a() { // from class: com.tencent.mobileqq.onlinestatus.view.withAvatar.p
            @Override // h43.a
            public final void a(h43.f fVar) {
                OnlineStatusLikeWithAvatarViewHolder.m0(equals, this, fVar);
            }
        };
        ((IQQHealthStatusApi) QRoute.api(IQQHealthStatusApi.class)).getStepInfo(this.friend.getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x(), Boolean.valueOf(equals), this.mGetStepInfoCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(boolean z16, final OnlineStatusLikeWithAvatarViewHolder this$0, final h43.f fVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                return;
            }
            IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IOnlineStatusService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
            ((IOnlineStatusService) runtimeService).setStepStatusInfo(fVar);
        } else {
            ag.f256338a.b(this$0.friend.getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x(), fVar);
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.view.withAvatar.q
            @Override // java.lang.Runnable
            public final void run() {
                OnlineStatusLikeWithAvatarViewHolder.o0(OnlineStatusLikeWithAvatarViewHolder.this, fVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(OnlineStatusLikeWithAvatarViewHolder this$0, h43.f fVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        String displayOnlineStatusInfo = ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).getDisplayOnlineStatusInfo(peekAppRuntime, this$0.friend.getStatus(), this$0.tvTitle, 1, ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).getOnlineStatusItem(AppRuntime.Status.online, this$0.friend.getStatus().e0(), false), Boolean.TRUE);
        if (fVar.f404302a != 0 && (((IQQHealthStatusApi) QRoute.api(IQQHealthStatusApi.class)).getStepPermission() || !Intrinsics.areEqual(peekAppRuntime.getCurrentUin(), this$0.friend.getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x()))) {
            String str = fVar.f404304c;
            Intrinsics.checkNotNullExpressionValue(str, "it.stepText");
            E0(this$0, str, false, 2, null);
        } else {
            this$0.tvSubtitle.setVisibility(8);
        }
        if (!TextUtils.isEmpty(displayOnlineStatusInfo) && !Utils.G(this$0.friend.getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x())) {
            this$0.tvTitle.setText(displayOnlineStatusInfo);
        }
    }

    private final void p0() {
        String j06 = this.friend.getStatus().j0();
        if (j06 == null) {
            j06 = "";
        }
        if (!StringUtil.isEmpty(j06)) {
            E0(this, j06, false, 2, null);
        }
    }

    private final void q0() {
        int i3;
        if (OnlineStatusToggleUtils.d()) {
            this.hasCustomImage = false;
            this.customImageUrl = "";
            this.ivBg.setImageResource(R.drawable.n4z);
            z0(false);
            G0(0);
            return;
        }
        boolean isNowThemeIsNight = QQTheme.isNowThemeIsNight();
        this.hasCustomImage = false;
        this.customImageUrl = "";
        RoundRectImageView roundRectImageView = this.ivBg;
        if (isNowThemeIsNight) {
            i3 = R.drawable.n4y;
        } else {
            i3 = R.drawable.n4x;
        }
        roundRectImageView.setImageResource(i3);
        z0(false);
        G0(1);
    }

    private final void r0() {
        this.flFilament.setVisibility(8);
        this.flFilament.setTag(null);
        aj ajVar = this.avatarView;
        if (ajVar != null) {
            ajVar.release();
        }
        this.avatarView = null;
        B0(false);
    }

    private final void s0(int resMapId) {
        this.tvSubtitle.setText("");
        this.tvSubtitle.setVisibility(8);
        this.lyricView.setVisibility(8);
        this.btnSetStatus.setTag(R.id.f922357b, null);
        F0(false);
        B0(false);
        if (this.flFilament.getTag() != null) {
            Object tag = this.flFilament.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.Int");
            if (((Integer) tag).intValue() == resMapId) {
                return;
            }
        }
        if (this.flFilament.getChildCount() > 0) {
            this.flFilament.removeAllViews();
        }
        r0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z0(boolean show) {
        if (show && !OnlineStatusToggleUtils.d()) {
            this.ivBgMask.setVisibility(0);
            TextView textView = this.tvName;
            textView.setTextColor(k.a(textView, R.color.qui_common_text_allwhite_primary));
            this.tvName.setAlpha(0.6f);
            return;
        }
        this.tvName.setAlpha(1.0f);
        this.ivBgMask.setVisibility(8);
        TextView textView2 = this.tvName;
        textView2.setTextColor(k.a(textView2, R.color.qui_common_text_secondary));
    }

    public final void B(@NotNull com.tencent.mobileqq.onlinestatus.model.d friend) {
        Intrinsics.checkNotNullParameter(friend, "friend");
        o.b("bind_spend");
        this.friend = friend;
        this.isAutoReplyLoaded = false;
        au item = ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).getOnlineStatusItem(ae.c(friend.getStatus()), friend.getStatus().e0(), false);
        this.onlineItem = item;
        Intrinsics.checkNotNullExpressionValue(item, "item");
        A0(friend, item);
        U(item);
        bindListener();
        o.a("bind_spend");
    }

    public final void D0(@NotNull CharSequence msg2, boolean showArrow) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (TextUtils.isEmpty(msg2)) {
            return;
        }
        this.tvSubtitle.setText(msg2);
        if (this.flFilament.getVisibility() != 0) {
            this.tvSubtitle.setVisibility(0);
        }
        F0(showArrow);
    }

    public final void E() {
        r0();
        this.curPlayState = 0;
    }

    public final void H0(int oldIndex, int newIndex) {
        this.selectedIndex = newIndex;
    }

    public final void I0(int oldState, int newState) {
        au auVar;
        this.scrollState = newState;
        if (oldState != -1 && newState == 0 && this.flFilament.getVisibility() == 0 && (auVar = this.onlineItem) != null) {
            R(bs.p(auVar));
        }
    }

    @NotNull
    /* renamed from: J, reason: from getter */
    public final String getCustomImageUrl() {
        return this.customImageUrl;
    }

    public final void J0(int oldState, int newState) {
        aj ajVar;
        if (newState != 0 && this.flFilament.getVisibility() == 0) {
            Integer num = f256694l0;
            int adapterPosition = getAdapterPosition();
            if ((num == null || num.intValue() != adapterPosition) && (ajVar = this.avatarView) != null && !ajVar.a()) {
                L().a();
            }
        }
    }

    @NotNull
    /* renamed from: K, reason: from getter */
    public final com.tencent.mobileqq.onlinestatus.model.d getFriend() {
        return this.friend;
    }

    @Nullable
    public final Function3<View, com.tencent.mobileqq.onlinestatus.model.d, Integer, Unit> P() {
        return this.onItemClickListener;
    }

    public final void a0() {
        String str = ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).getOnlineStatusItem(ae.c(this.friend.getStatus()), this.friend.getStatus().e0(), false).f255505r;
        Intrinsics.checkNotNullExpressionValue(str, "item.normalBgUrl");
        Z(str, false);
    }

    public final void c0(@NotNull Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.hasCustomImage = true;
        this.ivBg.setImageDrawable(drawable);
        z0(!OnlineStatusToggleUtils.d());
        G0(0);
    }

    public final void d0(@NotNull OnlineStatusShareInfo$ShareInfoItem infoItem) {
        Intrinsics.checkNotNullParameter(infoItem, "infoItem");
        this.shareInfoCacheManager.c(String.valueOf(infoItem.uin.get()), infoItem);
        if (infoItem.uin.get() != Long.parseLong(this.friend.getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x())) {
            return;
        }
        b0(infoItem);
    }

    public final void j0() {
        if (af.C().f0()) {
            String detailMsg = af.C().F();
            if (!StringUtil.isEmpty(detailMsg)) {
                Intrinsics.checkNotNullExpressionValue(detailMsg, "detailMsg");
                E0(this, detailMsg, false, 2, null);
                return;
            }
            return;
        }
        if (this.friend.getStatus().r() > 0) {
            String string = this.itemView.getContext().getResources().getString(R.string.f201474uw, String.valueOf(this.friend.getStatus().r()));
            Intrinsics.checkNotNullExpressionValue(string, "itemView.context.resourc\u2026tring()\n                )");
            E0(this, string, false, 2, null);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Function3<? super View, ? super com.tencent.mobileqq.onlinestatus.model.d, ? super Integer, Unit> function3;
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null && (function3 = this.onItemClickListener) != null) {
            function3.invoke(v3, this.friend, Integer.valueOf(getAdapterPosition()));
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.mobileqq.app.face.FaceDrawable.OnLoadingStateChangeListener
    public void onLoadingStateChanged(int oldState, int curState) {
        if (curState != 1) {
            return;
        }
        Object tag = this.ivHead.getTag();
        if ((tag instanceof String) && Intrinsics.areEqual(tag, this.friend.getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x())) {
            this.ivHead.setImageDrawable(cz.a(this.friend.getCom.tencent.guild.api.data.msglist.GuildMsgItem.NICK_FRIEND java.lang.String().x(), 1, null));
        }
    }

    public final void w0(boolean z16) {
        this.isAutoReplyLoaded = z16;
    }

    public final void x0(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.customImageUrl = str;
    }

    public final void y0(@Nullable Function3<? super View, ? super com.tencent.mobileqq.onlinestatus.model.d, ? super Integer, Unit> function3) {
        this.onItemClickListener = function3;
    }
}

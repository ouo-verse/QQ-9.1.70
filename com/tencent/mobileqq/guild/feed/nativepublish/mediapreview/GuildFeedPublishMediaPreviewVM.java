package com.tencent.mobileqq.guild.feed.nativepublish.mediapreview;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.animation.transition.TransitionBean;
import com.tencent.biz.richframework.animation.transition.TransitionHelper;
import com.tencent.biz.richframework.widget.RFWRoundImageView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.feed.bean.GuildFeedRichMediaData;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedGalleryInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedLauncher;
import com.tencent.mobileqq.guild.feed.nativepublish.content.FeedEditorContentMsgIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.edittext.GuildFeedEditTextMsgIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.feature.msgintent.SimplifiedFeedEditorGlobalMsgIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.mediapreview.FeedEditorMediaMsgIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.mediapreview.FeedPostMediaPreviewAdapter;
import com.tencent.mobileqq.guild.feed.nativepublish.mediapreview.n;
import com.tencent.mobileqq.guild.feed.nativepublish.mediapreview.r;
import com.tencent.mobileqq.guild.feed.util.ai;
import com.tencent.mobileqq.guild.feed.util.am;
import com.tencent.mobileqq.guild.feed.util.bf;
import com.tencent.mobileqq.guild.temp.api.IGuildFeedMediaApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProTencentDocsRsp;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.page.VideoReportPageInfo;
import gm1.a;
import gm1.c;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.SetsKt__SetsJVMKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.collections.SetsKt___SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0088\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010#\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 )2.\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u00060\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b:\u0001xB\u0007\u00a2\u0006\u0004\bv\u0010wJ\b\u0010\r\u001a\u00020\fH\u0002J\u0016\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u001c\u0010\u0019\u001a\u00020\f2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00170\u0016H\u0002J\u0016\u0010\u001d\u001a\u00020\f2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002J\u0016\u0010\u001f\u001a\u00020\u001e2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002J\u0010\u0010\"\u001a\u00020\f2\u0006\u0010!\u001a\u00020 H\u0002J\u0018\u0010&\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020$H\u0002J\u0010\u0010)\u001a\u00020\f2\u0006\u0010(\u001a\u00020'H\u0002J\u0016\u0010+\u001a\u00020\u001e2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002J\u0016\u0010,\u001a\u00020\u001e2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002J\b\u0010-\u001a\u00020\fH\u0002J \u00103\u001a\u00020\f2\u0006\u0010.\u001a\u00020\u001b2\u0006\u00100\u001a\u00020/2\u0006\u00102\u001a\u000201H\u0002J\"\u00106\u001a\u0012\u0012\u0004\u0012\u00020\u001b04j\b\u0012\u0004\u0012\u00020\u001b`5*\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002J\u0010\u00109\u001a\u00020\f2\u0006\u00108\u001a\u000207H\u0002J\u0016\u0010;\u001a\u00020\f2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002J\u001c\u0010=\u001a\b\u0012\u0004\u0012\u00020<0\u001a2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002J\u001e\u0010A\u001a\u00020@2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020>0\u001a2\u0006\u00102\u001a\u000201H\u0002J\u0012\u0010C\u001a\u0004\u0018\u00010B2\u0006\u00108\u001a\u000207H\u0002J\u0010\u0010E\u001a\u00020\f2\u0006\u00108\u001a\u00020DH\u0002J\u0018\u0010I\u001a\u00020H2\u0006\u0010F\u001a\u00020<2\u0006\u00100\u001a\u00020GH\u0002J\u001e\u0010N\u001a\u00020\f2\u0006\u0010K\u001a\u00020J2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020\f0LH\u0002J\b\u0010O\u001a\u00020\fH\u0002J\b\u0010P\u001a\u00020\fH\u0002J\u0010\u0010R\u001a\u00020\f2\u0006\u0010Q\u001a\u000207H\u0002J\u000e\u0010T\u001a\b\u0012\u0004\u0012\u00020\u000f0SH\u0016J\u000e\u0010U\u001a\b\u0012\u0004\u0012\u00020\u000f0SH\u0016J\u001a\u0010W\u001a\u00020\f2\u0010\u0010V\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006H\u0016J\b\u0010X\u001a\u00020\fH\u0016J\u0010\u0010Z\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020YH\u0016J\u0010\u0010]\u001a\u00020\f2\u0006\u0010\\\u001a\u00020[H\u0016J\u0010\u0010_\u001a\u00020^2\u0006\u0010\u0013\u001a\u00020YH\u0016J\u0010\u0010a\u001a\u00020\f2\u0006\u0010`\u001a\u00020\u0002H\u0016J\u0012\u0010c\u001a\u0004\u0018\u00010H2\u0006\u0010b\u001a\u000201H\u0016R\u0014\u0010g\u001a\u00020d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\be\u0010fR\u0014\u0010k\u001a\u00020h8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bi\u0010jR\u0016\u0010n\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010mR\u0016\u0010p\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010_R\u0016\u0010s\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bq\u0010rR\u0016\u0010u\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bt\u0010m\u00a8\u0006y"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/GuildFeedPublishMediaPreviewVM;", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/n;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/GuildFeedPublishMediaPreviewUIState;", "Lcom/tencent/base/api/runtime/a;", "Lzl1/a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/FeedEditorContext;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/EditorBaseVM;", "Lcom/tencent/biz/richframework/animation/transition/TransitionHelper$TransitionBeanCreator;", "Lcom/tencent/input/base/tool/emitter/a;", "Lcom/tencent/mvi/base/route/g;", "Lcom/tencent/mobileqq/guild/feed/util/bf;", "", "J", "", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/FeedEditorMediaMsgIntent$InitMediaList;", "event", "X", "D", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "queryList", "W", "", "Lfm1/i;", "mediaList", "t", "", "u", "Lcom/tencent/mobileqq/guild/feed/video/i;", QCircleScheme.AttrDetail.VIDEO_INFO, "N", "docUrl", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProTencentDocsRsp;", "docInfo", "M", "Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/FeedPostMediaPreviewAdapter;", "adapter", BdhLogUtil.LogTag.Tag_Conn, "dataLi", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, BdhLogUtil.LogTag.Tag_Req, "L", "data", "Landroid/widget/ImageView;", "view", "", "position", "K", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", HippyTKDListViewAdapter.X, "Landroidx/activity/result/ActivityResult;", "result", "B", "newMediaList", "Y", "Ljn1/d;", "w", "Lcom/tencent/mobileqq/guild/feed/bean/GuildFeedRichMediaData;", "guildFeedRichMediaData", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedGalleryInitBean;", "O", "Lcom/tencent/mobileqq/guild/temp/api/c;", "y", "Lgm1/a$a;", "T", "bean", "Landroid/view/View;", "Lcom/tencent/biz/richframework/animation/transition/TransitionBean;", "P", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lkotlin/Function0;", "allGranted", "v", "U", "G", "activityResult", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "getSubscribeEventNames", "getSubscribeEventRNames", "context", ExifInterface.LATITUDE_SOUTH, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mvi/base/route/MsgIntent;", "E", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "Lcom/tencent/mvi/base/route/k;", "I", "intent", UserInfo.SEX_FEMALE, "currentPos", "generateTransitionBean", "Lcom/tencent/mobileqq/guild/feed/util/a;", "d", "Lcom/tencent/mobileqq/guild/feed/util/a;", "actionSubscribeWrapper", "Lgm1/a;", "e", "Lgm1/a;", "localMediaGetter", "f", "Z", "isQuality", tl.h.F, "mTransitionCreatorKey", "i", "Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/FeedPostMediaPreviewAdapter;", "mAdapter", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isRemoveGameCenterShareMedia", "<init>", "()V", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedPublishMediaPreviewVM extends BaseVM<n, GuildFeedPublishMediaPreviewUIState, com.tencent.base.api.runtime.a<zl1.a>> implements TransitionHelper.TransitionBeanCreator, com.tencent.input.base.tool.emitter.a, bf {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.feed.util.a actionSubscribeWrapper = new com.tencent.mobileqq.guild.feed.util.a(this);

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final gm1.a localMediaGetter = new gm1.a();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isQuality;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mTransitionCreatorKey;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private FeedPostMediaPreviewAdapter mAdapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isRemoveGameCenterShareMedia;

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\t\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/feed/nativepublish/mediapreview/GuildFeedPublishMediaPreviewVM$b", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f222154a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildFeedPublishMediaPreviewVM f222155b;

        b(Function0<Unit> function0, GuildFeedPublishMediaPreviewVM guildFeedPublishMediaPreviewVM) {
            this.f222154a = function0;
            this.f222155b = guildFeedPublishMediaPreviewVM;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            this.f222154a.invoke();
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(@Nullable List<String> permissions, @Nullable List<Integer> results) {
            super.onDenied(permissions, results);
            this.f222155b.U();
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J \u0010\f\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0003H\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/guild/feed/nativepublish/mediapreview/GuildFeedPublishMediaPreviewVM$c", "Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/FeedPostMediaPreviewAdapter$f;", "", "Lfm1/i;", "mediaList", "", "a", "data", "Landroid/widget/ImageView;", "view", "", "position", "b", "removeItem", "c", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements FeedPostMediaPreviewAdapter.f {
        c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.guild.feed.nativepublish.mediapreview.FeedPostMediaPreviewAdapter.f
        public void a(@NotNull List<? extends fm1.i> mediaList) {
            Intrinsics.checkNotNullParameter(mediaList, "mediaList");
            GuildFeedPublishMediaPreviewVM.this.updateUI(new GuildFeedPublishMediaContainerVisibilityChange(!mediaList.isEmpty()));
            ((com.tencent.base.api.runtime.a) GuildFeedPublishMediaPreviewVM.this.getMContext()).e().h(new FeedEditorMediaMsgIntent.OnMediaChanged(mediaList.size(), GuildFeedPublishMediaPreviewVM.this.Q(mediaList), GuildFeedPublishMediaPreviewVM.this.R(mediaList)));
        }

        @Override // com.tencent.mobileqq.guild.feed.nativepublish.mediapreview.FeedPostMediaPreviewAdapter.f
        public void b(@NotNull fm1.i data, @NotNull ImageView view, int position) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(view, "view");
            GuildFeedPublishMediaPreviewVM.this.K(data, view, position);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.guild.feed.nativepublish.mediapreview.FeedPostMediaPreviewAdapter.f
        public void c(@NotNull fm1.i removeItem) {
            fm1.c cVar;
            Set of5;
            Intrinsics.checkNotNullParameter(removeItem, "removeItem");
            if (removeItem instanceof fm1.c) {
                cVar = (fm1.c) removeItem;
            } else {
                cVar = null;
            }
            if (cVar == null) {
                return;
            }
            if (cVar.k()) {
                GuildFeedPublishMediaPreviewVM.this.isRemoveGameCenterShareMedia = true;
            }
            com.tencent.mvi.base.route.j e16 = ((com.tencent.base.api.runtime.a) GuildFeedPublishMediaPreviewVM.this.getMContext()).e();
            of5 = SetsKt__SetsJVMKt.setOf(cVar.getCom.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet.KEY_TASKID java.lang.String());
            e16.h(new FeedEditorContentMsgIntent.TriggerMediasCancelUpload(of5));
        }
    }

    private final void A(ActivityResult activityResult) {
        com.tencent.mobileqq.guild.temp.api.c y16 = y(activityResult);
        if (y16 == null) {
            return;
        }
        QLog.i("GuildFeedPublishMediaPreviewVM", 1, "picker albumResult:" + y16);
        FeedPostMediaPreviewAdapter feedPostMediaPreviewAdapter = this.mAdapter;
        FeedPostMediaPreviewAdapter feedPostMediaPreviewAdapter2 = null;
        if (feedPostMediaPreviewAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            feedPostMediaPreviewAdapter = null;
        }
        ArrayList<fm1.i> x16 = x(feedPostMediaPreviewAdapter.a1());
        gm1.a aVar = this.localMediaGetter;
        FeedPostMediaPreviewAdapter feedPostMediaPreviewAdapter3 = this.mAdapter;
        if (feedPostMediaPreviewAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
        } else {
            feedPostMediaPreviewAdapter2 = feedPostMediaPreviewAdapter3;
        }
        c.b e16 = aVar.e(new a.MediaDataSource(y16, x16, feedPostMediaPreviewAdapter2.c1()));
        Intrinsics.checkNotNull(e16, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.nativepublish.mediapreview.datadelegate.GuildFeedPublishLocalMediaGetter.MediaDataResult");
        this.isQuality = y16.getIsQuality();
        T((a.MediaDataResult) e16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void B(ActivityResult result) {
        Serializable serializable;
        HashMap hashMap;
        com.tencent.mvi.base.route.j e16;
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        Object obj;
        fm1.c cVar;
        String str;
        Bundle extras;
        if (result.getResultCode() == -1 && result.getData() != null) {
            Intent data = result.getData();
            if (data != null && (extras = data.getExtras()) != null) {
                serializable = extras.getSerializable(QAlbumConstants.KEY_EDIT_PATHS_MAP);
            } else {
                serializable = null;
            }
            if (serializable instanceof HashMap) {
                hashMap = (HashMap) serializable;
            } else {
                hashMap = null;
            }
            if (hashMap == null) {
                return;
            }
            FeedPostMediaPreviewAdapter feedPostMediaPreviewAdapter = this.mAdapter;
            if (feedPostMediaPreviewAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                feedPostMediaPreviewAdapter = null;
            }
            ArrayList<fm1.i> x16 = x(feedPostMediaPreviewAdapter.a1());
            HashMap hashMap2 = new HashMap();
            HashSet hashSet = new HashSet();
            for (Map.Entry entry : hashMap.entrySet()) {
                String str2 = (String) entry.getKey();
                String str3 = (String) entry.getValue();
                Iterator<T> it = x16.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (Intrinsics.areEqual(((fm1.i) obj).getVideoPlayUrl(), str3)) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                fm1.i iVar = (fm1.i) obj;
                if (iVar != null && !TextUtils.equals(str3, str2)) {
                    int indexOf = x16.indexOf(iVar);
                    if (iVar instanceof fm1.e) {
                        cVar = ((fm1.e) iVar).j(this.isQuality);
                    } else if (iVar instanceof fm1.c) {
                        cVar = new fm1.c(((fm1.c) iVar).getRealInfo(), com.tencent.mobileqq.guild.feed.nativepublish.publish.a.f222223a.b());
                    } else {
                        Logger logger = Logger.f235387a;
                        Logger.b bVar = new Logger.b();
                        bVar.a().add("unknown media type");
                        Iterator<T> it5 = bVar.a().iterator();
                        while (it5.hasNext()) {
                            Logger.f235387a.d().e("GuildFeedPublishMediaPreviewVM", 1, (String) it5.next(), null);
                        }
                        cVar = null;
                    }
                    if (cVar != null) {
                        cVar.o(str2);
                    }
                    hashSet.add(iVar.getCom.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet.KEY_TASKID java.lang.String());
                    if (cVar != null) {
                        hashMap2.put(Integer.valueOf(indexOf), cVar);
                    }
                    Logger logger2 = Logger.f235387a;
                    if (QLog.isColorLevel()) {
                        Logger.a d16 = logger2.d();
                        if (cVar != null) {
                            str = cVar.getVideoPlayUrl();
                        } else {
                            str = null;
                        }
                        d16.d("GuildFeedPublishMediaPreviewVM", 1, "[handleAlbumPreviewResult]--originPath:" + str3 + ",editedPath:" + str + ",isQuality:" + this.isQuality + ", originalTaskId: " + iVar.getCom.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet.KEY_TASKID java.lang.String());
                    }
                }
            }
            com.tencent.base.api.runtime.a aVar = (com.tencent.base.api.runtime.a) getSafetyContext();
            if (aVar != null && (e16 = aVar.e()) != null) {
                Collection values = hashMap2.values();
                Intrinsics.checkNotNullExpressionValue(values, "toReplaceMediaMap.values");
                Collection<fm1.c> collection = values;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(collection, 10);
                mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
                LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
                for (fm1.c cVar2 : collection) {
                    Pair pair = TuplesKt.to(cVar2.getCom.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet.KEY_TASKID java.lang.String(), cVar2.getRealInfo());
                    linkedHashMap.put(pair.getFirst(), pair.getSecond());
                }
                e16.h(new FeedEditorContentMsgIntent.TriggerMediasModify(linkedHashMap, hashSet));
            }
            for (Map.Entry entry2 : hashMap2.entrySet()) {
                int intValue = ((Number) entry2.getKey()).intValue();
                fm1.c cVar3 = (fm1.c) entry2.getValue();
                x16.remove(intValue);
                x16.add(intValue, cVar3);
            }
            Y(x16);
        }
    }

    private final void C(FeedPostMediaPreviewAdapter adapter) {
        this.mAdapter = adapter;
        if (adapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            adapter = null;
        }
        adapter.u1(new c());
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void D(FeedEditorMediaMsgIntent.InitMediaList event) {
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        Map<String, ? extends LocalMediaInfo> mutableMap;
        Object firstOrNull;
        boolean z16;
        fm1.i iVar;
        boolean z17;
        List<fm1.i> a16 = event.a();
        if (a16.isEmpty()) {
            return;
        }
        QLog.e("GuildFeedPublishMediaPreviewVM", 1, "onInitAdapter--mediaListSize:" + a16.size() + ", unmodifiableSize:" + event.getUnmodifiableMediaSize());
        X(event);
        FeedPostMediaPreviewAdapter feedPostMediaPreviewAdapter = this.mAdapter;
        Object obj = null;
        if (feedPostMediaPreviewAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            feedPostMediaPreviewAdapter = null;
        }
        feedPostMediaPreviewAdapter.v1(a16);
        if (!a16.isEmpty()) {
            ArrayList<fm1.c> arrayList = new ArrayList();
            for (Object obj2 : a16) {
                if (obj2 instanceof fm1.c) {
                    arrayList.add(obj2);
                }
            }
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
            LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
            for (fm1.c cVar : arrayList) {
                Pair pair = TuplesKt.to(cVar.getCom.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet.KEY_TASKID java.lang.String(), cVar.j());
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            mutableMap = MapsKt__MapsKt.toMutableMap(linkedHashMap);
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) a16);
            fm1.i iVar2 = (fm1.i) firstOrNull;
            boolean z18 = false;
            if (iVar2 instanceof fm1.h) {
                if (iVar2.getImageUrl().length() > 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17 && !QAlbumUtil.isNetUrl(iVar2.getImageUrl())) {
                    z16 = true;
                    if (z16) {
                        obj = firstOrNull;
                    }
                    iVar = (fm1.i) obj;
                    if (iVar != null) {
                        String d16 = ((fm1.h) iVar).d();
                        LocalMediaInfo localMediaInfo = new LocalMediaInfo();
                        localMediaInfo.path = iVar.getImageUrl();
                        localMediaInfo.mMimeType = "image";
                        Unit unit = Unit.INSTANCE;
                        mutableMap.put(d16, localMediaInfo);
                        z18 = true;
                    }
                    QLog.i("GuildFeedPublishMediaPreviewVM", 1, "onInitAdapter-- mediaList.size:" + a16.size() + ", queryList:" + mutableMap.size() + ", containCommonThird:" + z18);
                    W(mutableMap);
                }
            }
            z16 = false;
            if (z16) {
            }
            iVar = (fm1.i) obj;
            if (iVar != null) {
            }
            QLog.i("GuildFeedPublishMediaPreviewVM", 1, "onInitAdapter-- mediaList.size:" + a16.size() + ", queryList:" + mutableMap.size() + ", containCommonThird:" + z18);
            W(mutableMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void G() {
        FeedPostMediaPreviewAdapter feedPostMediaPreviewAdapter = this.mAdapter;
        if (feedPostMediaPreviewAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            feedPostMediaPreviewAdapter = null;
        }
        com.tencent.mobileqq.guild.temp.api.b c16 = hm1.a.c(feedPostMediaPreviewAdapter.a1(), "album picker");
        IGuildFeedMediaApi iGuildFeedMediaApi = (IGuildFeedMediaApi) QRoute.api(IGuildFeedMediaApi.class);
        Activity f16 = ((com.tencent.base.api.runtime.a) getMContext()).f();
        Intrinsics.checkNotNullExpressionValue(f16, "mContext.activity");
        Intent openSimplifiedNativePublisherAlbumIntent = iGuildFeedMediaApi.getOpenSimplifiedNativePublisherAlbumIntent(f16, 18, false, c16);
        Object h16 = ((com.tencent.base.api.runtime.a) getMContext()).h();
        Intrinsics.checkNotNull(h16, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.nativepublish.FeedPublishParam");
        String h17 = ((zl1.a) h16).h();
        Object h18 = ((com.tencent.base.api.runtime.a) getMContext()).h();
        Intrinsics.checkNotNull(h18, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.nativepublish.FeedPublishParam");
        GuildFeedLauncher.l(openSimplifiedNativePublisherAlbumIntent, h17, ((zl1.a) h18).a(), 18, 1, false, 1200, false);
        ((com.tencent.base.api.runtime.a) getMContext()).g().a(openSimplifiedNativePublisherAlbumIntent, new ActivityResultCallback() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.mediapreview.p
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                GuildFeedPublishMediaPreviewVM.H(GuildFeedPublishMediaPreviewVM.this, (ActivityResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(GuildFeedPublishMediaPreviewVM this$0, ActivityResult it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.A(it);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void J() {
        FeedPostMediaPreviewAdapter feedPostMediaPreviewAdapter = this.mAdapter;
        if (feedPostMediaPreviewAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            feedPostMediaPreviewAdapter = null;
        }
        if (hm1.a.a(feedPostMediaPreviewAdapter.a1())) {
            com.tencent.mobileqq.guild.util.qqui.g.f(0, ((com.tencent.base.api.runtime.a) getMContext()).c().requireContext().getString(R.string.f145010qb));
            VideoReport.reportEvent("clck", z());
        } else {
            ((com.tencent.base.api.runtime.a) getMContext()).e().h(new SimplifiedFeedEditorGlobalMsgIntent.OverwriteCloseIntent("GuildFeedPublishMediaPreviewVM", "", false, 4, null));
            Activity f16 = ((com.tencent.base.api.runtime.a) getMContext()).f();
            Intrinsics.checkNotNullExpressionValue(f16, "mContext.activity");
            v(f16, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.mediapreview.GuildFeedPublishMediaPreviewVM$handleOpenAlbumPickerWithCheck$1
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
                    GuildFeedPublishMediaPreviewVM.this.U();
                    GuildFeedPublishMediaPreviewVM.this.G();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void K(fm1.i data, ImageView view, int position) {
        fm1.g gVar;
        String videoPlayUrl;
        if (position >= 0) {
            FeedPostMediaPreviewAdapter feedPostMediaPreviewAdapter = this.mAdapter;
            String str = null;
            if (feedPostMediaPreviewAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                feedPostMediaPreviewAdapter = null;
            }
            if (position < feedPostMediaPreviewAdapter.a1().size()) {
                FeedPostMediaPreviewAdapter feedPostMediaPreviewAdapter2 = this.mAdapter;
                if (feedPostMediaPreviewAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                    feedPostMediaPreviewAdapter2 = null;
                }
                List<jn1.d> w3 = w(feedPostMediaPreviewAdapter2.a1());
                List<GuildFeedRichMediaData> guildFeedRichMediaData = am.c(w3);
                Intrinsics.checkNotNullExpressionValue(guildFeedRichMediaData, "guildFeedRichMediaData");
                Iterator<T> it = guildFeedRichMediaData.iterator();
                while (it.hasNext()) {
                    ((GuildFeedRichMediaData) it.next()).setVideoScreenPlay(false);
                }
                GuildFeedGalleryInitBean O = O(guildFeedRichMediaData, position);
                jn1.d dVar = w3.get(position);
                if (!dVar.isGif) {
                    O.setTransitionBean(P(dVar, view));
                }
                if (fm1.d.d(data, 1)) {
                    if (data instanceof fm1.g) {
                        gVar = (fm1.g) data;
                    } else {
                        gVar = null;
                    }
                    if (gVar != null) {
                        str = gVar.getVideoShortPlayUrl();
                    }
                    QLog.i("GuildFeedPublishMediaPreviewVM", 2, "result: " + str);
                    O.setImmersiveSource(0);
                    if (gVar != null && (videoPlayUrl = gVar.getVideoPlayUrl()) != null) {
                        ai aiVar = ai.f223840a;
                        Activity f16 = ((com.tencent.base.api.runtime.a) getMContext()).f();
                        Intrinsics.checkNotNullExpressionValue(f16, "mContext.activity");
                        aiVar.a(f16, videoPlayUrl, O);
                        return;
                    }
                    return;
                }
                hx.a g16 = ((com.tencent.base.api.runtime.a) getMContext()).g();
                Intent K = GuildFeedLauncher.K(((com.tencent.base.api.runtime.a) getMContext()).f(), O, null);
                Intrinsics.checkNotNullExpressionValue(K, "makeOldGuildFeedGalleryA\u2026   null\n                )");
                g16.a(K, new ActivityResultCallback() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.mediapreview.q
                    @Override // androidx.activity.result.ActivityResultCallback
                    public final void onActivityResult(Object obj) {
                        GuildFeedPublishMediaPreviewVM.this.B((ActivityResult) obj);
                    }
                });
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void L() {
        ((com.tencent.base.api.runtime.a) getMContext()).e().h(new GuildFeedEditTextMsgIntent.OnTouchEvent());
    }

    private final void M(String docUrl, IGProTencentDocsRsp docInfo) {
        ArrayList arrayListOf;
        QLog.i("GuildFeedPublishMediaPreviewVM", 1, "handleTencentDocInsert " + docInfo);
        String url = docInfo.getUrl();
        Intrinsics.checkNotNullExpressionValue(url, "docInfo.url");
        String title = docInfo.getTitle();
        Intrinsics.checkNotNullExpressionValue(title, "docInfo.title");
        String icon = docInfo.getIcon();
        Intrinsics.checkNotNullExpressionValue(icon, "docInfo.icon");
        String platformName = docInfo.getPlatformName();
        Intrinsics.checkNotNullExpressionValue(platformName, "docInfo.platformName");
        String permission = docInfo.getPermission();
        Intrinsics.checkNotNullExpressionValue(permission, "docInfo.permission");
        fm1.f fVar = new fm1.f(docUrl, url, title, icon, platformName, permission);
        FeedPostMediaPreviewAdapter feedPostMediaPreviewAdapter = this.mAdapter;
        FeedPostMediaPreviewAdapter feedPostMediaPreviewAdapter2 = null;
        if (feedPostMediaPreviewAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            feedPostMediaPreviewAdapter = null;
        }
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(fVar);
        feedPostMediaPreviewAdapter.v1(arrayListOf);
        FeedPostMediaPreviewAdapter feedPostMediaPreviewAdapter3 = this.mAdapter;
        if (feedPostMediaPreviewAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
        } else {
            feedPostMediaPreviewAdapter2 = feedPostMediaPreviewAdapter3;
        }
        t(feedPostMediaPreviewAdapter2.a1());
    }

    private final void N(com.tencent.mobileqq.guild.feed.video.i videoInfo) {
        QLog.i("GuildFeedPublishMediaPreviewVM", 1, "handleThirdPartyVideoInsert " + videoInfo);
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final GuildFeedGalleryInitBean O(List<? extends GuildFeedRichMediaData> guildFeedRichMediaData, int position) {
        GuildFeedGalleryInitBean guildFeedGalleryInitBean = new GuildFeedGalleryInitBean();
        guildFeedGalleryInitBean.setRichMediaDataList(guildFeedRichMediaData);
        guildFeedGalleryInitBean.setEnterPos(position);
        guildFeedGalleryInitBean.setFromPage(0);
        guildFeedGalleryInitBean.setGuildId(((zl1.a) ((com.tencent.base.api.runtime.a) getMContext()).h()).h());
        guildFeedGalleryInitBean.setChannelId(((zl1.a) ((com.tencent.base.api.runtime.a) getMContext()).h()).a());
        guildFeedGalleryInitBean.setPosterId(((zl1.a) ((com.tencent.base.api.runtime.a) getMContext()).h()).getSelfTinyId());
        guildFeedGalleryInitBean.setShowMoreIcon(false);
        guildFeedGalleryInitBean.setShowCloseIcon(true);
        guildFeedGalleryInitBean.setShowPageIndex(true);
        guildFeedGalleryInitBean.setShowFloatLayerIcon(false);
        guildFeedGalleryInitBean.setOpenType(2);
        guildFeedGalleryInitBean.setShowEditBtn(true);
        guildFeedGalleryInitBean.setTransitionBeanCreatorKey(this.mTransitionCreatorKey);
        return guildFeedGalleryInitBean;
    }

    private final TransitionBean P(jn1.d bean, View view) {
        TransitionBean transitionBean = new TransitionBean().setEnterViewRect(view);
        int i3 = bean.type;
        if (i3 == 1) {
            transitionBean.setStImage(bean.coverUrl, bean.width, bean.height);
        } else if (i3 == 0) {
            transitionBean.setStImage(bean.thumbnailUrl, bean.width, bean.height);
        }
        transitionBean.setScaleType(ImageView.ScaleType.FIT_CENTER);
        Intrinsics.checkNotNullExpressionValue(transitionBean, "transitionBean");
        return transitionBean;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Q(List<? extends fm1.i> dataLi) {
        Object firstOrNull;
        boolean z16;
        boolean z17;
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) dataLi);
        fm1.i iVar = (fm1.i) firstOrNull;
        if (iVar != null && fm1.d.d(iVar, 1)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (iVar != null && fm1.d.d(iVar, 3)) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean R(List<? extends fm1.i> dataLi) {
        Object firstOrNull;
        boolean z16;
        boolean z17;
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) dataLi);
        fm1.i iVar = (fm1.i) firstOrNull;
        if (iVar != null && fm1.d.c(iVar)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            int urlType = iVar.getUrlType();
            if (6 <= urlType && urlType < 10) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void T(a.MediaDataResult result) {
        int collectionSizeOrDefault;
        Set set;
        int collectionSizeOrDefault2;
        Set set2;
        int collectionSizeOrDefault3;
        int mapCapacity;
        int coerceAtLeast;
        Map minus;
        int collectionSizeOrDefault4;
        Set set3;
        Set minus2;
        com.tencent.mvi.base.route.j e16;
        FeedPostMediaPreviewAdapter feedPostMediaPreviewAdapter = this.mAdapter;
        if (feedPostMediaPreviewAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            feedPostMediaPreviewAdapter = null;
        }
        List<fm1.i> a16 = feedPostMediaPreviewAdapter.a1();
        List<fm1.c> b16 = hm1.a.b(a16);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(b16, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = b16.iterator();
        while (it.hasNext()) {
            arrayList.add(((fm1.c) it.next()).getCom.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet.KEY_TASKID java.lang.String());
        }
        set = CollectionsKt___CollectionsKt.toSet(arrayList);
        List<fm1.i> a17 = result.a();
        List<fm1.c> b17 = hm1.a.b(a17);
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(b17, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
        Iterator<T> it5 = b17.iterator();
        while (it5.hasNext()) {
            arrayList2.add(((fm1.c) it5.next()).getCom.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet.KEY_TASKID java.lang.String());
        }
        set2 = CollectionsKt___CollectionsKt.toSet(arrayList2);
        List<fm1.c> b18 = hm1.a.b(a17);
        collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(b18, 10);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault3);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (fm1.c cVar : b18) {
            Pair pair = TuplesKt.to(cVar.getCom.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet.KEY_TASKID java.lang.String(), cVar.getRealInfo());
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        minus = MapsKt__MapsKt.minus((Map) linkedHashMap, (Iterable) set);
        FeedEditorContentMsgIntent.TriggerMediasUpload triggerMediasUpload = new FeedEditorContentMsgIntent.TriggerMediasUpload(minus);
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildFeedPublishMediaPreviewVM", 1, "[refreshAndUploadMedias]--uploadIntent:" + triggerMediasUpload);
        }
        List<fm1.c> b19 = hm1.a.b(a16);
        collectionSizeOrDefault4 = CollectionsKt__IterablesKt.collectionSizeOrDefault(b19, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault4);
        Iterator<T> it6 = b19.iterator();
        while (it6.hasNext()) {
            arrayList3.add(((fm1.c) it6.next()).getCom.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet.KEY_TASKID java.lang.String());
        }
        set3 = CollectionsKt___CollectionsKt.toSet(arrayList3);
        minus2 = SetsKt___SetsKt.minus(set3, (Iterable) set2);
        FeedEditorContentMsgIntent.TriggerMediasCancelUpload triggerMediasCancelUpload = new FeedEditorContentMsgIntent.TriggerMediasCancelUpload(minus2);
        Logger logger2 = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger2.d().d("GuildFeedPublishMediaPreviewVM", 1, "[refreshAndUploadMedias]--cancelUploadIntent:" + triggerMediasCancelUpload);
        }
        com.tencent.base.api.runtime.a aVar = (com.tencent.base.api.runtime.a) getSafetyContext();
        if (aVar != null && (e16 = aVar.e()) != null) {
            e16.h(new FeedEditorContentMsgIntent.TriggerMediasModify(triggerMediasUpload.a(), triggerMediasCancelUpload.a()));
        }
        Y(result.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void U() {
        ((com.tencent.base.api.runtime.a) getMContext()).e().h(SimplifiedFeedEditorGlobalMsgIntent.RestoreCloseIntent.f222059d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void W(Map<String, ? extends LocalMediaInfo> queryList) {
        com.tencent.base.api.runtime.a aVar;
        com.tencent.mvi.base.route.j e16;
        if (!queryList.isEmpty() && (aVar = (com.tencent.base.api.runtime.a) getSafetyContext()) != null && (e16 = aVar.e()) != null) {
            e16.h(new FeedEditorContentMsgIntent.TriggerMediasRestore(queryList));
        }
    }

    private final void X(FeedEditorMediaMsgIntent.InitMediaList event) {
        Object firstOrNull;
        if (event.getUnmodifiableMediaSize() > 0) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) event.a());
            fm1.i iVar = (fm1.i) firstOrNull;
            if (iVar != null) {
                iVar.h("game_share_media_source_type");
            }
        }
    }

    private final void Y(List<? extends fm1.i> newMediaList) {
        ArrayList arrayList = new ArrayList();
        FeedPostMediaPreviewAdapter feedPostMediaPreviewAdapter = this.mAdapter;
        FeedPostMediaPreviewAdapter feedPostMediaPreviewAdapter2 = null;
        if (feedPostMediaPreviewAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            feedPostMediaPreviewAdapter = null;
        }
        Set<fm1.i> c16 = feedPostMediaPreviewAdapter.c1();
        if (c16 != null) {
            arrayList.addAll(c16);
        }
        FeedPostMediaPreviewAdapter feedPostMediaPreviewAdapter3 = this.mAdapter;
        if (feedPostMediaPreviewAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            feedPostMediaPreviewAdapter3 = null;
        }
        feedPostMediaPreviewAdapter3.v1(newMediaList);
        FeedPostMediaPreviewAdapter feedPostMediaPreviewAdapter4 = this.mAdapter;
        if (feedPostMediaPreviewAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
        } else {
            feedPostMediaPreviewAdapter2 = feedPostMediaPreviewAdapter4;
        }
        feedPostMediaPreviewAdapter2.w0(arrayList);
    }

    private final void t(List<? extends fm1.i> mediaList) {
        if (u(mediaList)) {
            updateUI(new GuildFeedPublishMediaPreviewColumnChange(1));
        } else {
            updateUI(new GuildFeedPublishMediaPreviewColumnChange(1));
        }
    }

    private final boolean u(List<? extends fm1.i> mediaList) {
        if (mediaList.size() != 1) {
            return false;
        }
        if (!fm1.d.d(mediaList.get(0), 3) && !fm1.d.d(mediaList.get(0), 6)) {
            return false;
        }
        return true;
    }

    private final void v(Activity activity, Function0<Unit> allGranted) {
        if (activity.checkSelfPermission(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE) == 0 && activity.checkSelfPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0) {
            allGranted.invoke();
        } else {
            QQPermissionFactory.getQQPermission(activity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_AIO_ALBUM, QQPermissionConstants.Business.SCENE.OPEN_AIO_ALBUM)).requestPermissions(QQPermissionConstants.Permission.GROUP_STORAGE, 2, new b(allGranted, this));
        }
    }

    private final List<jn1.d> w(List<? extends fm1.i> mediaList) {
        int collectionSizeOrDefault;
        List<? extends fm1.i> list = mediaList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (fm1.i iVar : list) {
            jn1.d dVar = new jn1.d();
            dVar.fileId = iVar.getCom.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet.KEY_TASKID java.lang.String();
            dVar.type = iVar.getUrlType();
            dVar.width = iVar.getWidth();
            dVar.height = iVar.getHeight();
            dVar.showWidth = iVar.getWidth();
            dVar.showHeight = iVar.getHeight();
            dVar.duration = (int) iVar.getVideoDuration();
            dVar.isGif = iVar.getIsGif();
            if (iVar.getUrlType() == 1) {
                dVar.videoUrl = iVar.getVideoPlayUrl();
                dVar.coverUrl = iVar.getVideoCoverUrl();
            } else {
                String videoPlayUrl = iVar.getVideoPlayUrl();
                dVar.imageUrl = videoPlayUrl;
                dVar.thumbnailUrl = videoPlayUrl;
            }
            arrayList.add(dVar);
        }
        return arrayList;
    }

    private final ArrayList<fm1.i> x(List<? extends fm1.i> list) {
        ArrayList<fm1.i> arrayList = new ArrayList<>();
        arrayList.addAll(list);
        return arrayList;
    }

    private final com.tencent.mobileqq.guild.temp.api.c y(ActivityResult result) {
        return ((IGuildFeedMediaApi) QRoute.api(IGuildFeedMediaApi.class)).getAlbumResult(result);
    }

    private final Map<String, Object> z() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        VideoReportPageInfo pageInfo = VideoReport.getPageInfo();
        if (pageInfo != null) {
            Map<String, Object> pageParams = pageInfo.pageParams;
            if (pageParams != null) {
                Intrinsics.checkNotNullExpressionValue(pageParams, "pageParams");
                pageParams.put("pgid", pageInfo.pageId);
                linkedHashMap.put("cur_pg", pageInfo.pageParams);
            }
            linkedHashMap.put("dt_pgid", pageInfo.pageId);
        }
        linkedHashMap.put("eid", "em_sgrp_url_picture_exclude_tip");
        return linkedHashMap;
    }

    @Override // com.tencent.mobileqq.guild.feed.util.bf
    public void E(@NotNull MsgIntent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof FeedEditorContentMsgIntent.InsertThirdPartyVideoEvent) {
            ((FeedEditorContentMsgIntent.InsertThirdPartyVideoEvent) event).a();
            N(null);
        } else if (event instanceof FeedEditorContentMsgIntent.InsertTencentDocEvent) {
            FeedEditorContentMsgIntent.InsertTencentDocEvent insertTencentDocEvent = (FeedEditorContentMsgIntent.InsertTencentDocEvent) event;
            M(insertTencentDocEvent.getDocUrl(), insertTencentDocEvent.getVideoInfo());
        } else if (event instanceof FeedEditorMediaMsgIntent.InitMediaList) {
            D((FeedEditorMediaMsgIntent.InitMediaList) event);
        } else if (event instanceof FeedEditorMediaMsgIntent.OpenAlbum) {
            J();
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull n intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof n.a) {
            C(((n.a) intent).getAdapter());
        } else {
            if (intent instanceof n.b) {
                L();
                return;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.util.bf
    @NotNull
    public com.tencent.mvi.base.route.k I(@NotNull MsgIntent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof FeedEditorMediaMsgIntent.GetMediaList) {
            FeedPostMediaPreviewAdapter feedPostMediaPreviewAdapter = this.mAdapter;
            FeedPostMediaPreviewAdapter feedPostMediaPreviewAdapter2 = null;
            if (feedPostMediaPreviewAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                feedPostMediaPreviewAdapter = null;
            }
            List<fm1.i> a16 = feedPostMediaPreviewAdapter.a1();
            FeedPostMediaPreviewAdapter feedPostMediaPreviewAdapter3 = this.mAdapter;
            if (feedPostMediaPreviewAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            } else {
                feedPostMediaPreviewAdapter2 = feedPostMediaPreviewAdapter3;
            }
            return new r.GetMediaListResult(a16, feedPostMediaPreviewAdapter2.b1().size(), this.isRemoveGameCenterShareMedia);
        }
        return new com.tencent.input.base.utils.a();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public void onCreate(@NotNull com.tencent.base.api.runtime.a<zl1.a> context) {
        Intrinsics.checkNotNullParameter(context, "context");
        com.tencent.mobileqq.guild.feed.util.a aVar = this.actionSubscribeWrapper;
        com.tencent.mvi.base.route.j e16 = context.e();
        Intrinsics.checkNotNullExpressionValue(e16, "context.messenger");
        aVar.b(e16);
        this.mTransitionCreatorKey = TransitionHelper.g().registerTransitionBeanCreator(this);
        context.b().a(com.tencent.input.base.tool.emitter.a.class).a(this);
    }

    @Override // com.tencent.biz.richframework.animation.transition.TransitionHelper.TransitionBeanCreator
    @Nullable
    public TransitionBean generateTransitionBean(int currentPos) {
        RFWRoundImageView thumb;
        FeedPostMediaPreviewAdapter feedPostMediaPreviewAdapter = this.mAdapter;
        if (feedPostMediaPreviewAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            feedPostMediaPreviewAdapter = null;
        }
        FeedPostMediaPreviewAdapter.h d16 = feedPostMediaPreviewAdapter.d1(currentPos);
        if (d16 != null && (thumb = d16.getThumb()) != null && currentPos >= 0) {
            FeedPostMediaPreviewAdapter feedPostMediaPreviewAdapter2 = this.mAdapter;
            if (feedPostMediaPreviewAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                feedPostMediaPreviewAdapter2 = null;
            }
            if (currentPos < feedPostMediaPreviewAdapter2.a1().size()) {
                FeedPostMediaPreviewAdapter feedPostMediaPreviewAdapter3 = this.mAdapter;
                if (feedPostMediaPreviewAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
                    feedPostMediaPreviewAdapter3 = null;
                }
                fm1.i iVar = feedPostMediaPreviewAdapter3.a1().get(currentPos);
                if (thumb.getGlobalVisibleRect(new Rect()) && !iVar.getIsGif()) {
                    TransitionBean enterViewRect = new TransitionBean().setEnterViewRect(thumb);
                    if (iVar.getUrlType() == com.tencent.guild.api.media.album.c.b()) {
                        enterViewRect.setStImage(iVar.getVideoCoverUrl(), iVar.getWidth(), iVar.getHeight());
                    } else if (iVar.getUrlType() == com.tencent.guild.api.media.album.c.a()) {
                        enterViewRect.setStImage(iVar.getVideoPlayUrl(), iVar.getWidth(), iVar.getHeight());
                    }
                    enterViewRect.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    return enterViewRect;
                }
            }
        }
        return null;
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    @NotNull
    public Set<String> getSubscribeEventNames() {
        Set<String> mutableSetOf;
        String b16 = com.tencent.mvi.base.route.c.b(FeedEditorContentMsgIntent.InsertThirdPartyVideoEvent.class);
        Intrinsics.checkNotNullExpressionValue(b16, "get(java)");
        String b17 = com.tencent.mvi.base.route.c.b(FeedEditorContentMsgIntent.InsertTencentDocEvent.class);
        Intrinsics.checkNotNullExpressionValue(b17, "get(java)");
        String b18 = com.tencent.mvi.base.route.c.b(FeedEditorMediaMsgIntent.InitMediaList.class);
        Intrinsics.checkNotNullExpressionValue(b18, "get(java)");
        String b19 = com.tencent.mvi.base.route.c.b(FeedEditorMediaMsgIntent.OpenAlbum.class);
        Intrinsics.checkNotNullExpressionValue(b19, "get(java)");
        mutableSetOf = SetsKt__SetsKt.mutableSetOf(b16, b17, b18, b19);
        return mutableSetOf;
    }

    @Override // com.tencent.mvi.mvvm.BaseVM, com.tencent.mvi.base.route.g
    @NotNull
    public Set<String> getSubscribeEventRNames() {
        Set<String> mutableSetOf;
        String b16 = com.tencent.mvi.base.route.c.b(FeedEditorMediaMsgIntent.GetMediaList.class);
        Intrinsics.checkNotNullExpressionValue(b16, "get(java)");
        mutableSetOf = SetsKt__SetsKt.mutableSetOf(b16);
        return mutableSetOf;
    }

    @Override // com.tencent.input.base.tool.emitter.a
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        QLog.i("GuildFeedPublishMediaPreviewVM", 1, "handleOnConfigurationChanged");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        com.tencent.mobileqq.guild.feed.util.a aVar = this.actionSubscribeWrapper;
        com.tencent.mvi.base.route.j e16 = ((com.tencent.base.api.runtime.a) getMContext()).e();
        Intrinsics.checkNotNullExpressionValue(e16, "mContext.messenger");
        aVar.e(e16);
        ((com.tencent.base.api.runtime.a) getMContext()).b().a(com.tencent.input.base.tool.emitter.a.class).c(this);
    }
}

package com.qzone.reborn.intimate.part;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.google.android.material.appbar.AppBarLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.qzone.reborn.intimate.bean.QZoneIntimateSpaceBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.hippy.qq.view.scroll.HippyHeaderScrollViewController;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.partner.signin.pb.GeneralSigninPB$Button;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshHeader;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import ij.QZIntimateCheckInInfoBean;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u00d2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00b1\u00012\u00020\u0001:\u0002\u00b2\u0001B\t\u00a2\u0006\u0006\b\u00af\u0001\u0010\u00b0\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\tH\u0002J\b\u0010\u0015\u001a\u00020\u0002H\u0002J\b\u0010\u0016\u001a\u00020\u0002H\u0002J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\fH\u0002J\b\u0010\u0019\u001a\u00020\u0005H\u0002J\b\u0010\u001a\u001a\u00020\u0002H\u0002J\u0016\u0010\u001e\u001a\u00020\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002J\u0010\u0010!\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001fH\u0002J\u0012\u0010#\u001a\u00020\u00022\b\u0010\"\u001a\u0004\u0018\u00010\u001cH\u0002J\u0010\u0010%\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u0005H\u0002J\u0016\u0010)\u001a\u00020\u00022\f\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&H\u0002J\u0010\u0010+\u001a\u00020\u00022\u0006\u0010*\u001a\u00020'H\u0002J\u0010\u0010,\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u001cH\u0002J\u0018\u0010/\u001a\u00020\u00022\u0006\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020\u0005H\u0002J\u0010\u00100\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u001fH\u0002J\u0010\u00101\u001a\u00020\u00022\u0006\u0010-\u001a\u00020\u001fH\u0002J\b\u00102\u001a\u00020\u0002H\u0002J\u0010\u00103\u001a\u00020\u00022\u0006\u0010-\u001a\u00020\u001fH\u0002J\u0018\u00107\u001a\u0002062\u0006\u0010-\u001a\u00020\u001f2\u0006\u00105\u001a\u000204H\u0002J\u0010\u00108\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u001cH\u0002J\u0016\u0010<\u001a\u00020\u00022\f\u0010;\u001a\b\u0012\u0004\u0012\u00020:09H\u0002J \u0010A\u001a\u00020\u00022\u0006\u0010=\u001a\u00020:2\u0006\u0010?\u001a\u00020>2\u0006\u0010@\u001a\u00020>H\u0002J\u0018\u0010B\u001a\u00020\u00022\u0006\u0010=\u001a\u00020:2\u0006\u0010?\u001a\u00020>H\u0002J\"\u0010G\u001a\u00020\u00022\u0006\u0010D\u001a\u00020C2\b\u0010E\u001a\u0004\u0018\u00010'2\u0006\u0010F\u001a\u00020'H\u0002J(\u0010N\u001a\u00020\u00022\u0006\u0010D\u001a\u00020C2\u0006\u0010I\u001a\u00020H2\u0006\u0010K\u001a\u00020J2\u0006\u0010M\u001a\u00020LH\u0002J\u0010\u0010O\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\fH\u0016J\b\u0010P\u001a\u00020'H\u0016R\u0016\u0010S\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010V\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010Z\u001a\u00020W8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010^\u001a\u00020[8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010b\u001a\u00020_8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010f\u001a\u00020c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u0016\u0010i\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bg\u0010hR\u0016\u0010m\u001a\u00020j8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bk\u0010lR\u0016\u0010q\u001a\u00020n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bo\u0010pR\u0016\u0010s\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\br\u0010hR\u0016\u0010v\u001a\u00020H8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bt\u0010uR\u0016\u0010x\u001a\u00020n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bw\u0010pR\u0016\u0010z\u001a\u00020>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bU\u0010yR\u0016\u0010|\u001a\u00020>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b{\u0010yR\u0016\u0010~\u001a\u00020>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b}\u0010yR\u0017\u0010\u0080\u0001\u001a\u00020>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u007f\u0010yR\u0018\u0010\u0082\u0001\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u0081\u0001\u0010hR\u001a\u0010\u0086\u0001\u001a\u00030\u0083\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R\u001a\u0010\u0088\u0001\u001a\u00030\u0083\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0087\u0001\u0010\u0085\u0001R\u001a\u0010\u008a\u0001\u001a\u00030\u0083\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0089\u0001\u0010\u0085\u0001R\u0018\u0010\u008c\u0001\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u008b\u0001\u0010hR\u0018\u0010\u008e\u0001\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u008d\u0001\u0010hR\u0018\u0010\u0090\u0001\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u008f\u0001\u0010hR\u0018\u0010\u0092\u0001\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u0091\u0001\u0010hR\u0019\u0010\u0095\u0001\u001a\u00020J8\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R\u001a\u0010\u0097\u0001\u001a\u00030\u0083\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0096\u0001\u0010\u0085\u0001R\u001a\u0010\u009b\u0001\u001a\u00030\u0098\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001R\u0019\u0010\u009d\u0001\u001a\u00020J8\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u009c\u0001\u0010\u0094\u0001R\u0017\u0010\u009e\u0001\u001a\u00020H8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bR\u0010uR\u001a\u0010\u00a0\u0001\u001a\u00030\u0083\u00018\u0002@\u0002X\u0082.\u00a2\u0006\b\n\u0006\b\u009f\u0001\u0010\u0085\u0001R\u0018\u0010\u00a2\u0001\u001a\u00020H8\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u00a1\u0001\u0010uR\u0018\u0010\u00a4\u0001\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0007\n\u0005\b\u00a3\u0001\u0010hR\u001b\u0010\u00a7\u0001\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00a5\u0001\u0010\u00a6\u0001R\u0018\u0010\u00a9\u0001\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00a8\u0001\u0010UR5\u0010\u00ae\u0001\u001a \u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u0002040\u00aa\u0001j\u000f\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u000204`\u00ab\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00ac\u0001\u0010\u00ad\u0001\u00a8\u0006\u00b3\u0001"}, d2 = {"Lcom/qzone/reborn/intimate/part/QZoneIntimateSpaceCoverPart;", "Lcom/qzone/reborn/base/k;", "", "Z9", LocaleUtils.L_JAPANESE, "", "ca", "aa", "ba", "", com.tencent.luggage.wxa.c8.c.f123400v, "da", "Landroid/view/View;", "view", "height", "ea", "verticalOffset", "totalScrollRange", "qa", "animRatio", "ia", "ra", "Oa", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "ta", "ma", "initViewModel", "Lcom/tencent/richframework/data/base/UIStateData;", "Lcom/qzone/reborn/intimate/bean/QZoneIntimateSpaceBean;", "uiStateData", "pa", "Lij/b;", "checkInInfoBean", "Qa", "spaceBean", "Sa", "spaceType", "ha", "", "", "iconList", "Ra", "iconUrl", "za", "ga", "checkInBean", "relationColor", "Ea", "xa", "Da", "oa", "na", "", "hasCheckIn", "Landroid/graphics/drawable/Drawable;", "la", "Ha", "", "Lcom/qzone/proxy/feedcomponent/model/User;", "members", "Ca", QCircleAlphaUserReporter.KEY_USER, "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "bigAvatar", "smallAvatar", "Ba", "Aa", "", "retCode", "errorTitle", "errorMsg", "Ja", "Landroid/widget/ImageView;", "forbiddenImageBg", "Landroid/widget/LinearLayout;", "forbiddenContentLayout", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "forbiddenBottomBtn", "La", "onInitView", "getLogTag", "d", "Z", "mIsTitleAvatarShowing", "e", "I", "mCurVerticalOffset", "Lnk/at;", "f", "Lnk/at;", "mMainTabViewModel", "Lnk/i;", tl.h.F, "Lnk/i;", "styleViewModel", "Lnk/b;", "i", "Lnk/b;", "checkInViewModel", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "mRefreshLayout", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "mRefreshHeader", "Lcom/google/android/material/appbar/AppBarLayout;", "D", "Lcom/google/android/material/appbar/AppBarLayout;", "mAppBarLayout", "Landroid/widget/FrameLayout;", "E", "Landroid/widget/FrameLayout;", "coverContentLayout", UserInfo.SEX_FEMALE, "mCoverContainer", "G", "Landroid/widget/ImageView;", "mIvCoverBg", "H", "avatarContainer", "Lcom/qzone/reborn/feedx/widget/QZoneUserAvatarView;", "mIvAvatar1", "J", "mIvAvatar2", "K", "mIvTitleAvatar1", "L", "mIvTitleAvatar2", "M", "mTitleAvatarLayout", "Landroid/widget/TextView;", "N", "Landroid/widget/TextView;", "mTvRelationMsg", "P", "mTvRelationDays", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "mTvRelationDayText", BdhLogUtil.LogTag.Tag_Req, "bottomBasicContainer", ExifInterface.LATITUDE_SOUTH, "relationContainer", "T", "menuItemContainer", "U", "menuContentLayout", "V", "Landroid/widget/LinearLayout;", "relationIconContainer", "W", "mTvPunchDays", "Landroid/view/ViewGroup;", "X", "Landroid/view/ViewGroup;", "mLlPunch", "Y", "mLlShareContainer", "mIvPunchLeftIcon", "a0", "mTvPunch", "b0", "mIvPrivacyState", "c0", "titleMedalContainer", "d0", "Lcom/qzone/reborn/intimate/bean/QZoneIntimateSpaceBean;", "mSpaceBean", "e0", "mCoverBgMarginTop", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "f0", "Ljava/util/HashMap;", "iconMap", "<init>", "()V", "g0", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneIntimateSpaceCoverPart extends com.qzone.reborn.base.k {

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: h0, reason: collision with root package name */
    private static final int f57271h0 = ef.d.b(25);

    /* renamed from: C, reason: from kotlin metadata */
    private View mRefreshHeader;

    /* renamed from: D, reason: from kotlin metadata */
    private AppBarLayout mAppBarLayout;

    /* renamed from: E, reason: from kotlin metadata */
    private FrameLayout coverContentLayout;

    /* renamed from: F, reason: from kotlin metadata */
    private View mCoverContainer;

    /* renamed from: G, reason: from kotlin metadata */
    private ImageView mIvCoverBg;

    /* renamed from: H, reason: from kotlin metadata */
    private FrameLayout avatarContainer;

    /* renamed from: I, reason: from kotlin metadata */
    private QZoneUserAvatarView mIvAvatar1;

    /* renamed from: J, reason: from kotlin metadata */
    private QZoneUserAvatarView mIvAvatar2;

    /* renamed from: K, reason: from kotlin metadata */
    private QZoneUserAvatarView mIvTitleAvatar1;

    /* renamed from: L, reason: from kotlin metadata */
    private QZoneUserAvatarView mIvTitleAvatar2;

    /* renamed from: M, reason: from kotlin metadata */
    private View mTitleAvatarLayout;

    /* renamed from: N, reason: from kotlin metadata */
    private TextView mTvRelationMsg;

    /* renamed from: P, reason: from kotlin metadata */
    private TextView mTvRelationDays;

    /* renamed from: Q, reason: from kotlin metadata */
    private TextView mTvRelationDayText;

    /* renamed from: R, reason: from kotlin metadata */
    private View bottomBasicContainer;

    /* renamed from: S, reason: from kotlin metadata */
    private View relationContainer;

    /* renamed from: T, reason: from kotlin metadata */
    private View menuItemContainer;

    /* renamed from: U, reason: from kotlin metadata */
    private View menuContentLayout;

    /* renamed from: V, reason: from kotlin metadata */
    private LinearLayout relationIconContainer;

    /* renamed from: W, reason: from kotlin metadata */
    private TextView mTvPunchDays;

    /* renamed from: X, reason: from kotlin metadata */
    private ViewGroup mLlPunch;

    /* renamed from: Y, reason: from kotlin metadata */
    private LinearLayout mLlShareContainer;

    /* renamed from: Z, reason: from kotlin metadata */
    private ImageView mIvPunchLeftIcon;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private TextView mTvPunch;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private ImageView mIvPrivacyState;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private View titleMedalContainer;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean mIsTitleAvatarShowing;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private QZoneIntimateSpaceBean mSpaceBean;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mCurVerticalOffset;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private int mCoverBgMarginTop;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private nk.at mMainTabViewModel;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private final HashMap<String, Boolean> iconMap = new HashMap<>();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private nk.i styleViewModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private nk.b checkInViewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private SmartRefreshLayout mRefreshLayout;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\tR\u0014\u0010\u000e\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\tR\u0014\u0010\u0010\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\tR\u0014\u0010\u0011\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\tR\u0014\u0010\u0012\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\tR\u0014\u0010\u0013\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\fR\u0014\u0010\u0015\u001a\u00020\u00148\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/qzone/reborn/intimate/part/QZoneIntimateSpaceCoverPart$a;", "", "", "COVER_BG_SCROLL_THRESHOLD", "I", "a", "()I", "", "AVATAR_CONTAINER_RATIO", UserInfo.SEX_FEMALE, "", "COVER_BG_DAY", "Ljava/lang/String;", "COVER_BG_MARGIN_TOP_RATIO", "COVER_BG_NIGHT", "COVER_BG_RATIO", "COVER_BG_SCROLL_FACTOR", "COVER_LAYOUT_RATIO", "ELEMENT_DISMISS_FACTOR", "TAG", "", "TITLE_AVATAR_ANIMATE_DURATION", "J", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.intimate.part.QZoneIntimateSpaceCoverPart$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return QZoneIntimateSpaceCoverPart.f57271h0;
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J:\u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/qzone/reborn/intimate/part/QZoneIntimateSpaceCoverPart$c", "Lth/a;", "Lcom/tencent/richframework/widget/refresh/layout/api/IRefreshHeader;", "header", "", "isDragging", "", "percent", "", "offset", HippyHeaderScrollViewController.HEADER_HEIGHT, "maxDragHeight", "", "onHeaderMoving", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c extends th.a {
        c() {
        }

        @Override // com.tencent.richframework.widget.refresh.layout.listener.OnMultiListener
        public void onHeaderMoving(IRefreshHeader header, boolean isDragging, float percent, int offset, int headerHeight, int maxDragHeight) {
            float coerceAtLeast;
            float coerceAtMost;
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast((offset - QZoneIntimateSpaceCoverPart.INSTANCE.a()) * 1.5f, 0.0f);
            ImageView imageView = QZoneIntimateSpaceCoverPart.this.mIvCoverBg;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvCoverBg");
                imageView = null;
            }
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(coerceAtLeast, Math.abs(QZoneIntimateSpaceCoverPart.this.mCoverBgMarginTop));
            imageView.setTranslationY(coerceAtMost);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/intimate/part/QZoneIntimateSpaceCoverPart$d", "Lcom/google/android/material/appbar/AppBarLayout$g;", "Lcom/google/android/material/appbar/AppBarLayout;", "appBarLayout", "", "verticalOffset", "", "onOffsetChanged", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class d implements AppBarLayout.g {
        d() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.c
        public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
            Intrinsics.checkNotNullParameter(appBarLayout, "appBarLayout");
            if (QZoneIntimateSpaceCoverPart.this.mCurVerticalOffset == verticalOffset) {
                return;
            }
            QZoneIntimateSpaceCoverPart.this.mCurVerticalOffset = verticalOffset;
            SmartRefreshLayout smartRefreshLayout = QZoneIntimateSpaceCoverPart.this.mRefreshLayout;
            if (smartRefreshLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRefreshLayout");
                smartRefreshLayout = null;
            }
            smartRefreshLayout.setEnabled(verticalOffset >= 0);
            QZoneIntimateSpaceCoverPart.this.qa(verticalOffset, appBarLayout.p());
        }
    }

    private final void Aa(User user, QZoneUserAvatarView bigAvatar) {
        Map<String, Object> mutableMapOf;
        if (ef.b.g(user)) {
            fo.c.n(bigAvatar, "em_qz_my_profile_picture");
            return;
        }
        fo.b bVar = new fo.b();
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("touin", Long.valueOf(user.uin)));
        bVar.l(mutableMapOf);
        fo.c.o(bigAvatar, "em_qz_opponent_profile_picture", bVar);
    }

    private final void Ba(User user, QZoneUserAvatarView bigAvatar, QZoneUserAvatarView smallAvatar) {
        QZoneUserAvatarView.b bVar = new QZoneUserAvatarView.b();
        bVar.f55960b = false;
        bigAvatar.setUser(user, bVar);
        smallAvatar.setUser(user, bVar);
        smallAvatar.setIsShieldJumpToMainPage(true);
        Aa(user, bigAvatar);
    }

    private final void Da(QZIntimateCheckInInfoBean checkInBean) {
        PBStringField pBStringField;
        GeneralSigninPB$Button signInBtn = checkInBean.getSignInBtn();
        ImageView imageView = null;
        String str = (signInBtn == null || (pBStringField = signInBtn.img_url) == null) ? null : pBStringField.get();
        QLog.d("QZoneIntimateSpaceCoverPart", 1, "[showCheckInBtnLeftImg] leftImgUrl=" + str);
        Option url = Option.obtain().setUrl(mk.c.f416874a.b(str));
        ImageView imageView2 = this.mIvPunchLeftIcon;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvPunchLeftIcon");
        } else {
            imageView = imageView2;
        }
        com.tencent.mobileqq.qzone.picload.c.a().h(url.setTargetView(imageView).setFailedDrawableId(R.drawable.trans).setLoadingDrawableId(R.drawable.trans));
    }

    private final void Ea(final QZIntimateCheckInInfoBean checkInBean, int relationColor) {
        PBStringField pBStringField;
        GeneralSigninPB$Button signInBtn = checkInBean.getSignInBtn();
        ViewGroup viewGroup = null;
        String str = (signInBtn == null || (pBStringField = signInBtn.text) == null) ? null : pBStringField.get();
        if (str == null) {
            str = "";
        }
        if (checkInBean.getIsMasterSpace()) {
            TextView textView = this.mTvPunchDays;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvPunchDays");
                textView = null;
            }
            textView.setVisibility(8);
            ViewGroup viewGroup2 = this.mLlPunch;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLlPunch");
                viewGroup2 = null;
            }
            viewGroup2.setVisibility(0);
            if (!checkInBean.getIsSelfCheckInAlready()) {
                TextView textView2 = this.mTvPunch;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTvPunch");
                    textView2 = null;
                }
                if (str.length() == 0) {
                    str = com.qzone.util.l.a(R.string.v8w);
                }
                textView2.setText(str);
                TextView textView3 = this.mTvPunch;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTvPunch");
                    textView3 = null;
                }
                textView3.setTextColor(getActivity().getColor(R.color.qui_common_text_allwhite_primary));
                ViewGroup viewGroup3 = this.mLlPunch;
                if (viewGroup3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLlPunch");
                    viewGroup3 = null;
                }
                viewGroup3.setBackground(la(checkInBean, false));
                ViewGroup viewGroup4 = this.mLlPunch;
                if (viewGroup4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLlPunch");
                } else {
                    viewGroup = viewGroup4;
                }
                viewGroup.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.intimate.part.cd
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        QZoneIntimateSpaceCoverPart.Fa(QZoneIntimateSpaceCoverPart.this, view);
                    }
                });
            } else {
                TextView textView4 = this.mTvPunch;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTvPunch");
                    textView4 = null;
                }
                textView4.setText(str);
                TextView textView5 = this.mTvPunch;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTvPunch");
                    textView5 = null;
                }
                textView5.setTextColor(relationColor);
                ViewGroup viewGroup5 = this.mLlPunch;
                if (viewGroup5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLlPunch");
                    viewGroup5 = null;
                }
                viewGroup5.setBackground(la(checkInBean, true));
                ViewGroup viewGroup6 = this.mLlPunch;
                if (viewGroup6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLlPunch");
                } else {
                    viewGroup = viewGroup6;
                }
                viewGroup.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.intimate.part.ce
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        QZoneIntimateSpaceCoverPart.Ga(QZoneIntimateSpaceCoverPart.this, checkInBean, view);
                    }
                });
            }
            Da(checkInBean);
            return;
        }
        if (checkInBean.getCheckInDays() > 0) {
            TextView textView6 = this.mTvPunchDays;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvPunchDays");
                textView6 = null;
            }
            textView6.setVisibility(0);
            TextView textView7 = this.mTvPunchDays;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvPunchDays");
                textView7 = null;
            }
            textView7.setText(str);
            TextView textView8 = this.mTvPunchDays;
            if (textView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvPunchDays");
                textView8 = null;
            }
            textView8.setTextColor(relationColor);
        } else {
            TextView textView9 = this.mTvPunchDays;
            if (textView9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvPunchDays");
                textView9 = null;
            }
            textView9.setVisibility(8);
        }
        ViewGroup viewGroup7 = this.mLlPunch;
        if (viewGroup7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLlPunch");
        } else {
            viewGroup = viewGroup7;
        }
        viewGroup.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fa(QZoneIntimateSpaceCoverPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.oa();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ga(QZoneIntimateSpaceCoverPart this$0, QZIntimateCheckInInfoBean checkInBean, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(checkInBean, "$checkInBean");
        this$0.na(checkInBean);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void Ha(QZoneIntimateSpaceBean spaceBean) {
        T t16;
        T t17;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        nk.i iVar = this.styleViewModel;
        if (iVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("styleViewModel");
            iVar = null;
        }
        JSONObject coverSetting = iVar.getCoverSetting();
        if (coverSetting != null) {
            try {
                if (com.qzone.reborn.util.k.f59549a.f()) {
                    String string = coverSetting.getString("cover_bg_night");
                    Intrinsics.checkNotNullExpressionValue(string, "{\n                    co\u2026_NIGHT)\n                }");
                    t16 = string;
                } else {
                    String string2 = coverSetting.getString("cover_bg_day");
                    Intrinsics.checkNotNullExpressionValue(string2, "{\n                    co\u2026BG_DAY)\n                }");
                    t16 = string2;
                }
                objectRef.element = t16;
            } catch (Exception e16) {
                QLog.e("QZoneIntimateSpaceCoverPart", 1, "exception is " + e16);
            }
        }
        QLog.i("QZoneIntimateSpaceCoverPart", 1, "cover url is " + objectRef.element);
        if (TextUtils.isEmpty((CharSequence) objectRef.element)) {
            if (com.qzone.reborn.util.k.f59549a.f()) {
                t17 = spaceBean.getBgImageDark();
            } else {
                t17 = spaceBean.getBgImageLight();
            }
            objectRef.element = t17;
        }
        Option url = Option.obtain().setUrl((String) objectRef.element);
        ImageView imageView = this.mIvCoverBg;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvCoverBg");
            imageView = null;
        }
        com.tencent.mobileqq.qzone.picload.c.a().i(url.setTargetView(imageView).setLoadingDrawable(ResourcesCompat.getDrawable(getActivity().getResources(), R.drawable.qui_common_bg_bottom_standard_bg, null)), new IPicLoadStateListener() { // from class: com.qzone.reborn.intimate.part.cf
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                QZoneIntimateSpaceCoverPart.Ia(Ref.ObjectRef.this, loadState, option);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ia(Ref.ObjectRef url, LoadState loadState, Option option) {
        Intrinsics.checkNotNullParameter(url, "$url");
        if (loadState.isFinishError()) {
            QLog.d("QZoneIntimateSpaceCoverPart", 1, "[showCoverBg] onStateChange  isFinishError: " + url.element);
        }
    }

    private final void Ja(long retCode, String errorTitle, String errorMsg) {
        View findViewById = getPartRootView().findViewById(R.id.n5o);
        ImageView forbiddenImageBg = (ImageView) getPartRootView().findViewById(R.id.f162735jq1);
        LinearLayout forbiddenContentLayout = (LinearLayout) getPartRootView().findViewById(R.id.jpo);
        QUIButton forbiddenBottomBtn = (QUIButton) getPartRootView().findViewById(R.id.m1a);
        TextView textView = (TextView) getPartRootView().findViewById(R.id.n4q);
        TextView textView2 = (TextView) getPartRootView().findViewById(R.id.n4p);
        View findViewById2 = getPartRootView().findViewById(R.id.n4o);
        ViewGroup.LayoutParams layoutParams = findViewById2.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = ImmersiveUtils.getStatusBarHeight(getContext());
        }
        Intrinsics.checkNotNullExpressionValue(forbiddenImageBg, "forbiddenImageBg");
        Intrinsics.checkNotNullExpressionValue(forbiddenContentLayout, "forbiddenContentLayout");
        Intrinsics.checkNotNullExpressionValue(forbiddenBottomBtn, "forbiddenBottomBtn");
        La(retCode, forbiddenImageBg, forbiddenContentLayout, forbiddenBottomBtn);
        ImageView imageView = this.mIvCoverBg;
        SmartRefreshLayout smartRefreshLayout = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvCoverBg");
            imageView = null;
        }
        imageView.setVisibility(8);
        SmartRefreshLayout smartRefreshLayout2 = this.mRefreshLayout;
        if (smartRefreshLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRefreshLayout");
        } else {
            smartRefreshLayout = smartRefreshLayout2;
        }
        smartRefreshLayout.setVisibility(8);
        findViewById.setVisibility(0);
        if (errorTitle == null || errorTitle.length() == 0) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(errorTitle);
        }
        textView2.setText(errorMsg);
        findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.intimate.part.cc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneIntimateSpaceCoverPart.Ka(QZoneIntimateSpaceCoverPart.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ka(QZoneIntimateSpaceCoverPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ma(ImageView forbiddenImageBg, LoadState loadState, Option option) {
        Intrinsics.checkNotNullParameter(forbiddenImageBg, "$forbiddenImageBg");
        if (!loadState.isFinishSuccess()) {
            forbiddenImageBg.setVisibility(8);
        } else {
            forbiddenImageBg.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Na(QZoneIntimateSpaceCoverPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        mk.d dVar = mk.d.f416875a;
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        dVar.J(context);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Oa() {
        View view = this.mTitleAvatarLayout;
        LinearLayout linearLayout = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleAvatarLayout");
            view = null;
        }
        view.setVisibility(0);
        View view2 = this.titleMedalContainer;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleMedalContainer");
            view2 = null;
        }
        view2.setVisibility(8);
        LinearLayout linearLayout2 = this.mLlShareContainer;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLlShareContainer");
        } else {
            linearLayout = linearLayout2;
        }
        linearLayout.setVisibility(8);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(300L);
        ofFloat.setRepeatCount(0);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.qzone.reborn.intimate.part.bt
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                QZoneIntimateSpaceCoverPart.Pa(QZoneIntimateSpaceCoverPart.this, valueAnimator);
            }
        });
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Pa(QZoneIntimateSpaceCoverPart this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view = this$0.mTitleAvatarLayout;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleAvatarLayout");
            view = null;
        }
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        view.setAlpha(((Float) animatedValue).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Qa(QZIntimateCheckInInfoBean checkInInfoBean) {
        Ea(checkInInfoBean, ef.a.f396213a.a(checkInInfoBean.getThemeColor(), getActivity().getResources().getColor(R.color.qui_common_brand_standard)));
    }

    private final void Ra(List<String> iconList) {
        if (iconList.isEmpty()) {
            return;
        }
        Iterator<String> it = iconList.iterator();
        while (it.hasNext()) {
            String iconV2 = com.tencent.mobileqq.mutualmark.g.r(it.next());
            Intrinsics.checkNotNullExpressionValue(iconV2, "iconV2");
            za(iconV2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ta(QZoneIntimateSpaceCoverPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.broadcastMessage("INTIMATE_MODIFY_ANNIVERSARY", null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Z9() {
        FrameLayout frameLayout = this.avatarContainer;
        FrameLayout frameLayout2 = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarContainer");
            frameLayout = null;
        }
        if (frameLayout.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            FrameLayout frameLayout3 = this.avatarContainer;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarContainer");
            } else {
                frameLayout2 = frameLayout3;
            }
            ViewGroup.LayoutParams layoutParams = frameLayout2.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
            ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.LayoutParams) layoutParams)).topMargin = (int) (pl.a.f426446a.i() * 0.42666668f);
        }
    }

    private final int aa() {
        return (int) (pl.a.f426446a.i() * 1.1226667f);
    }

    private final int ba() {
        return (int) (pl.a.f426446a.i() * 0.34933335f * (-1));
    }

    private final int ca() {
        return (int) (pl.a.f426446a.i() * 0.74666667f);
    }

    private final void da(float alpha) {
        View view = this.menuContentLayout;
        FrameLayout frameLayout = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("menuContentLayout");
            view = null;
        }
        view.setAlpha(alpha);
        View view2 = this.bottomBasicContainer;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomBasicContainer");
            view2 = null;
        }
        view2.setAlpha(alpha);
        TextView textView = this.mTvPunchDays;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvPunchDays");
            textView = null;
        }
        textView.setAlpha(alpha);
        ViewGroup viewGroup = this.mLlPunch;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLlPunch");
            viewGroup = null;
        }
        viewGroup.setAlpha(alpha);
        nk.at atVar = this.mMainTabViewModel;
        if (atVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMainTabViewModel");
            atVar = null;
        }
        atVar.S1().setValue(Float.valueOf(alpha));
        FrameLayout frameLayout2 = this.avatarContainer;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarContainer");
        } else {
            frameLayout = frameLayout2;
        }
        frameLayout.setAlpha(alpha);
    }

    private final void ea(View view, int height) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = height;
            view.setLayoutParams(layoutParams);
        }
    }

    private final void ga(QZoneIntimateSpaceBean spaceBean) {
        String str;
        Map<String, Object> mutableMapOf;
        ImageView imageView = null;
        if (!spaceBean.isMasterSpace()) {
            ImageView imageView2 = this.mIvPrivacyState;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvPrivacyState");
            } else {
                imageView = imageView2;
            }
            imageView.setVisibility(8);
            return;
        }
        ImageView imageView3 = this.mIvPrivacyState;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvPrivacyState");
            imageView3 = null;
        }
        imageView3.setVisibility(0);
        if (spaceBean.getDisplayRight() == 1) {
            ImageView imageView4 = this.mIvPrivacyState;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvPrivacyState");
                imageView4 = null;
            }
            imageView4.setImageResource(R.drawable.qui_lock_off);
        } else {
            ImageView imageView5 = this.mIvPrivacyState;
            if (imageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvPrivacyState");
                imageView5 = null;
            }
            imageView5.setImageResource(R.drawable.qui_lock);
        }
        com.tencent.mobileqq.qzone.picload.c a16 = com.tencent.mobileqq.qzone.picload.c.a();
        ImageView imageView6 = this.mIvPrivacyState;
        if (imageView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvPrivacyState");
            imageView6 = null;
        }
        a16.m(imageView6, getActivity().getColor(R.color.qui_common_icon_primary));
        if (spaceBean.getDisplayRight() == 1) {
            str = "1";
        } else {
            str = "0";
        }
        fo.b bVar = new fo.b();
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("permission_state", str));
        bVar.l(mutableMapOf);
        ImageView imageView7 = this.mIvPrivacyState;
        if (imageView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvPrivacyState");
        } else {
            imageView = imageView7;
        }
        fo.c.o(imageView, "em_qz_permission_state", bVar);
    }

    private final void ha(int spaceType) {
        TextView textView = null;
        if (mk.d.f416875a.F(Integer.valueOf(spaceType))) {
            TextView textView2 = this.mTvRelationMsg;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvRelationMsg");
                textView2 = null;
            }
            textView2.setVisibility(8);
            TextView textView3 = this.mTvRelationDays;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvRelationDays");
                textView3 = null;
            }
            textView3.setVisibility(8);
            TextView textView4 = this.mTvRelationDayText;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvRelationDayText");
            } else {
                textView = textView4;
            }
            textView.setText("\u642d\u5b50\u7a7a\u95f4");
            return;
        }
        TextView textView5 = this.mTvRelationMsg;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvRelationMsg");
            textView5 = null;
        }
        textView5.setVisibility(0);
        TextView textView6 = this.mTvRelationDays;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvRelationDays");
            textView6 = null;
        }
        textView6.setVisibility(0);
        TextView textView7 = this.mTvRelationDayText;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvRelationDayText");
        } else {
            textView = textView7;
        }
        textView.setVisibility(0);
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(nk.i.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZIntimateM\u2026yleViewModel::class.java)");
        this.styleViewModel = (nk.i) viewModel;
        ViewModel viewModel2 = getViewModel(nk.at.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "getViewModel(QZoneIntima\u2026TabViewModel::class.java)");
        nk.at atVar = (nk.at) viewModel2;
        this.mMainTabViewModel = atVar;
        nk.b bVar = null;
        if (atVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMainTabViewModel");
            atVar = null;
        }
        MutableLiveData<UIStateData<QZoneIntimateSpaceBean>> U1 = atVar.U1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<UIStateData<QZoneIntimateSpaceBean>, Unit> function1 = new Function1<UIStateData<QZoneIntimateSpaceBean>, Unit>() { // from class: com.qzone.reborn.intimate.part.QZoneIntimateSpaceCoverPart$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<QZoneIntimateSpaceBean> uIStateData) {
                invoke2(uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<QZoneIntimateSpaceBean> it) {
                SmartRefreshLayout smartRefreshLayout = QZoneIntimateSpaceCoverPart.this.mRefreshLayout;
                if (smartRefreshLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRefreshLayout");
                    smartRefreshLayout = null;
                }
                smartRefreshLayout.finishRefresh();
                QZoneIntimateSpaceCoverPart qZoneIntimateSpaceCoverPart = QZoneIntimateSpaceCoverPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                qZoneIntimateSpaceCoverPart.pa(it);
            }
        };
        U1.observe(lifecycleOwner, new Observer() { // from class: com.qzone.reborn.intimate.part.bw
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneIntimateSpaceCoverPart.va(Function1.this, obj);
            }
        });
        nk.at atVar2 = this.mMainTabViewModel;
        if (atVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMainTabViewModel");
            atVar2 = null;
        }
        atVar2.N1();
        nk.at atVar3 = this.mMainTabViewModel;
        if (atVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMainTabViewModel");
            atVar3 = null;
        }
        atVar3.S1().setValue(Float.valueOf(1.0f));
        ViewModel viewModel3 = getViewModel(nk.b.class);
        Intrinsics.checkNotNullExpressionValue(viewModel3, "getViewModel(QZIntimateC\u2026kInViewModel::class.java)");
        nk.b bVar2 = (nk.b) viewModel3;
        this.checkInViewModel = bVar2;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkInViewModel");
        } else {
            bVar = bVar2;
        }
        MutableLiveData<UIStateData<QZIntimateCheckInInfoBean>> b26 = bVar.b2();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<UIStateData<QZIntimateCheckInInfoBean>, Unit> function12 = new Function1<UIStateData<QZIntimateCheckInInfoBean>, Unit>() { // from class: com.qzone.reborn.intimate.part.QZoneIntimateSpaceCoverPart$initViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<QZIntimateCheckInInfoBean> uIStateData) {
                invoke2(uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<QZIntimateCheckInInfoBean> uIStateData) {
                ViewGroup viewGroup;
                if (uIStateData == null || uIStateData.getData() == null) {
                    viewGroup = QZoneIntimateSpaceCoverPart.this.mLlPunch;
                    if (viewGroup == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mLlPunch");
                        viewGroup = null;
                    }
                    viewGroup.setVisibility(8);
                    return;
                }
                QZoneIntimateSpaceCoverPart qZoneIntimateSpaceCoverPart = QZoneIntimateSpaceCoverPart.this;
                QZIntimateCheckInInfoBean data = uIStateData.getData();
                Intrinsics.checkNotNullExpressionValue(data, "it.data");
                qZoneIntimateSpaceCoverPart.Qa(data);
            }
        };
        b26.observe(lifecycleOwner2, new Observer() { // from class: com.qzone.reborn.intimate.part.bx
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneIntimateSpaceCoverPart.wa(Function1.this, obj);
            }
        });
    }

    private final void ja() {
        ViewGroup viewGroup = this.mLlPunch;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLlPunch");
            viewGroup = null;
        }
        fo.c.n(viewGroup, "em_qz_punch_entry");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0055, code lost:
    
        r3 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0053, code lost:
    
        r3 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x002d, code lost:
    
        if (r1 == null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0040, code lost:
    
        if (r1 == null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0051, code lost:
    
        if (r1 == null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001c, code lost:
    
        if (r1 == null) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Drawable la(QZIntimateCheckInInfoBean checkInBean, boolean hasCheckIn) {
        PBStringField pBStringField;
        PBStringField pBStringField2;
        String str;
        List split$default;
        PBStringField pBStringField3;
        PBStringField pBStringField4;
        boolean f16 = com.qzone.reborn.util.k.f59549a.f();
        String str2 = null;
        String str3 = "";
        if (hasCheckIn) {
            if (f16) {
                GeneralSigninPB$Button signInBtn = checkInBean.getSignInBtn();
                if (signInBtn != null && (pBStringField4 = signInBtn.color_after_click2) != null) {
                    str2 = pBStringField4.get();
                }
            } else {
                GeneralSigninPB$Button signInBtn2 = checkInBean.getSignInBtn();
                if (signInBtn2 != null && (pBStringField3 = signInBtn2.color_after_click) != null) {
                    str2 = pBStringField3.get();
                }
            }
        } else if (f16) {
            GeneralSigninPB$Button signInBtn3 = checkInBean.getSignInBtn();
            if (signInBtn3 != null && (pBStringField2 = signInBtn3.color2) != null) {
                str2 = pBStringField2.get();
            }
        } else {
            GeneralSigninPB$Button signInBtn4 = checkInBean.getSignInBtn();
            if (signInBtn4 != null && (pBStringField = signInBtn4.color) != null) {
                str2 = pBStringField.get();
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("QZoneIntimateSpaceCoverPart", 2, "[getCheckInButtonBackground] isNight = " + f16 + ", colorStr = " + str);
        }
        split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{";"}, false, 0, 6, (Object) null);
        if (!split$default.isEmpty()) {
            str3 = (String) split$default.get(0);
        }
        String str4 = split$default.size() >= 2 ? (String) split$default.get(1) : str3;
        ef.a aVar = ef.a.f396213a;
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{aVar.a(str3.toString(), getActivity().getColor(R.color.qui_common_brand_standard)), aVar.a(str4.toString(), getActivity().getColor(R.color.qui_common_brand_standard))});
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(ef.d.b(4));
        return gradientDrawable;
    }

    private final void na(QZIntimateCheckInInfoBean checkInBean) {
        if (com.qzone.reborn.util.e.c("QZoneIntimateSpaceCoverPartAlreadyCheckIn", 1000L)) {
            return;
        }
        nk.b bVar = this.checkInViewModel;
        nk.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkInViewModel");
            bVar = null;
        }
        if (bVar.getInCheckInProcess()) {
            QLog.i("QZoneIntimateSpaceCoverPart", 1, "interceptPunchClick return");
            return;
        }
        if (gd.a.f401926a.c("KEY_CHECK_IN_ANIM_REPLACE_LAUNCH_PUNCH_DETAIL", false)) {
            broadcastMessage("START_PLAY_CHECK_IN_ANIM", null);
            nk.b bVar3 = this.checkInViewModel;
            if (bVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("checkInViewModel");
            } else {
                bVar2 = bVar3;
            }
            bVar2.n2();
            return;
        }
        xa(checkInBean);
    }

    private final void oa() {
        AppRuntime peekAppRuntime;
        if (com.qzone.reborn.util.e.c("QZoneIntimateSpaceCoverPartcheckIn", 1000L) || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
            return;
        }
        nk.b bVar = this.checkInViewModel;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkInViewModel");
            bVar = null;
        }
        nk.b bVar2 = this.checkInViewModel;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkInViewModel");
            bVar2 = null;
        }
        bVar.X1(peekAppRuntime, bVar2.getSpaceId());
        broadcastMessage("START_PLAY_CHECK_IN_ANIM", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pa(UIStateData<QZoneIntimateSpaceBean> uiStateData) {
        String a16;
        int state = uiStateData.getState();
        String str = "";
        if (state == 2 || state == 3) {
            QZoneIntimateSpaceBean data = uiStateData.getData();
            com.qzone.reborn.util.k kVar = com.qzone.reborn.util.k.f59549a;
            if (kVar.g() && data.isLoveSpace()) {
                String msg2 = com.qzone.util.l.a(R.string.w8q);
                long retCode = uiStateData.getRetCode();
                Intrinsics.checkNotNullExpressionValue(msg2, "msg");
                Ja(retCode, "", msg2);
                return;
            }
            if (kVar.a()) {
                String msg3 = com.qzone.util.l.a(R.string.f169554vw1);
                long retCode2 = uiStateData.getRetCode();
                Intrinsics.checkNotNullExpressionValue(msg3, "msg");
                Ja(retCode2, "", msg3);
                return;
            }
            Sa(uiStateData.getData());
            return;
        }
        if (state != 4) {
            return;
        }
        long retCode3 = uiStateData.getRetCode();
        if (retCode3 == 10014) {
            a16 = com.qzone.util.l.a(R.string.vyf);
            Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qzone_int\u2026te_forbidden_msg_no_data)");
        } else if (retCode3 == 10065) {
            a16 = com.qzone.util.l.a(R.string.f169555vw2);
            Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qzone_int\u2026te_forbidden_msg_disband)");
        } else if (retCode3 == 10057) {
            str = com.qzone.util.l.a(R.string.w9g);
            Intrinsics.checkNotNullExpressionValue(str, "qqStr(R.string.qzone_intimate_privacy_space)");
            a16 = com.qzone.util.l.a(R.string.vyg);
            Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qzone_int\u2026te_forbidden_msg_privacy)");
        } else if (retCode3 == 10056) {
            a16 = com.qzone.util.l.a(R.string.w8q);
            Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qzone_int\u2026rbidden_msg_teenage_mode)");
        } else if (retCode3 == 10058) {
            a16 = com.qzone.util.l.a(R.string.f169554vw1);
            Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qzone_int\u2026_forbidden_msg_care_mode)");
        } else {
            a16 = com.qzone.util.l.a(R.string.w_h);
            Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qzone_network_error)");
        }
        Ja(uiStateData.getRetCode(), str, a16);
    }

    private final void ra() {
        View view = this.titleMedalContainer;
        LinearLayout linearLayout = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleMedalContainer");
            view = null;
        }
        view.setVisibility(0);
        QZoneIntimateSpaceBean qZoneIntimateSpaceBean = this.mSpaceBean;
        if ((qZoneIntimateSpaceBean != null ? qZoneIntimateSpaceBean.getPhShareStatus() : null) != null && com.qzone.reborn.configx.g.f53821a.b().q0()) {
            LinearLayout linearLayout2 = this.mLlShareContainer;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLlShareContainer");
            } else {
                linearLayout = linearLayout2;
            }
            linearLayout.setVisibility(0);
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.setDuration(300L);
        ofFloat.setRepeatCount(0);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.qzone.reborn.intimate.part.bz
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                QZoneIntimateSpaceCoverPart.sa(QZoneIntimateSpaceCoverPart.this, valueAnimator);
            }
        });
        ofFloat.addListener(new b());
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sa(QZoneIntimateSpaceCoverPart this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view = this$0.mTitleAvatarLayout;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleAvatarLayout");
            view = null;
        }
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        view.setAlpha(((Float) animatedValue).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ua(QZoneIntimateSpaceCoverPart this$0, IRefreshLayout it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        nk.at atVar = this$0.mMainTabViewModel;
        if (atVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMainTabViewModel");
            atVar = null;
        }
        atVar.N1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void va(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void xa(QZIntimateCheckInInfoBean spaceBean) {
        String str;
        if (com.qzone.reborn.util.e.b("QZoneIntimateSpaceCoverPartHalfScreen", 500L)) {
            return;
        }
        nk.b bVar = this.checkInViewModel;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkInViewModel");
            bVar = null;
        }
        String spaceId = bVar.getSpaceId();
        int spaceType = spaceBean.getSpaceType();
        long friendUin = spaceBean.getFriendUin();
        if (com.qzone.reborn.a.c(com.qzone.reborn.a.f52169a, "exp__space_clock_in_remind2", null, 2, null)) {
            str = "&show_setting=1";
        } else {
            str = "";
        }
        ho.i.q(getContext(), com.tencent.mobileqq.webview.util.f.f314875a.c(0.85f, "https://h5.qzone.qq.com/intimate-space/h5/checkin?_wv=1&_wwv=8193&_bid=5588&_cwv=256&float=1&space_id=" + spaceId + "&space_type=" + spaceType + "&target=" + friendUin + str, 0));
    }

    private final void za(String iconUrl) {
        if (TextUtils.isEmpty(iconUrl)) {
            QLog.e("QZoneIntimateSpaceCoverPart", 1, "icon string is empty");
            return;
        }
        if (this.iconMap.containsKey(iconUrl)) {
            QLog.e("QZoneIntimateSpaceCoverPart", 1, "has added this icon");
            return;
        }
        ImageView imageView = new ImageView(getActivity());
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewUtils.dpToPx(20.0f), ViewUtils.dpToPx(20.0f));
        layoutParams.setMarginEnd(ViewUtils.dpToPx(2.0f));
        imageView.setLayoutParams(layoutParams);
        LinearLayout linearLayout = this.relationIconContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("relationIconContainer");
            linearLayout = null;
        }
        linearLayout.addView(imageView);
        this.iconMap.put(iconUrl, Boolean.TRUE);
        com.qzone.reborn.util.h.i(getActivity(), imageView, iconUrl, ViewUtils.dpToPx(20.0f), ViewUtils.dpToPx(20.0f));
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneIntimateSpaceCoverPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        initViewModel();
        ta(rootView);
        int ca5 = ca();
        View findViewById = rootView.findViewById(R.id.n4m);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026intimate_cover_container)");
        this.mCoverContainer = findViewById;
        View findViewById2 = rootView.findViewById(R.id.f162944ng4);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026ace_cover_content_layout)");
        this.coverContentLayout = (FrameLayout) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.ng7);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026spend_entrance_container)");
        this.menuItemContainer = findViewById3;
        AppBarLayout appBarLayout = null;
        if (findViewById3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("menuItemContainer");
            findViewById3 = null;
        }
        View findViewById4 = findViewById3.findViewById(R.id.ng5);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "menuItemContainer.findVi\u2026pace_menu_content_layout)");
        this.menuContentLayout = findViewById4;
        View view = this.mCoverContainer;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCoverContainer");
            view = null;
        }
        ea(view, ca5);
        int aa5 = aa();
        View findViewById5 = rootView.findViewById(R.id.n4l);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.\u2026.qzone_intimate_cover_bg)");
        ImageView imageView = (ImageView) findViewById5;
        this.mIvCoverBg = imageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvCoverBg");
            imageView = null;
        }
        ea(imageView, aa5);
        this.mCoverBgMarginTop = ba();
        ImageView imageView2 = this.mIvCoverBg;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvCoverBg");
            imageView2 = null;
        }
        if (imageView2.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ImageView imageView3 = this.mIvCoverBg;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvCoverBg");
                imageView3 = null;
            }
            ViewGroup.LayoutParams layoutParams = imageView3.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = this.mCoverBgMarginTop;
        }
        View findViewById6 = rootView.findViewById(R.id.n5n);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.\u2026e_space_avatar_container)");
        this.avatarContainer = (FrameLayout) findViewById6;
        View findViewById7 = rootView.findViewById(R.id.n5l);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById(R.\u2026_intimate_space_avatar_1)");
        this.mIvAvatar1 = (QZoneUserAvatarView) findViewById7;
        View findViewById8 = rootView.findViewById(R.id.n5m);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "rootView.findViewById(R.\u2026_intimate_space_avatar_2)");
        this.mIvAvatar2 = (QZoneUserAvatarView) findViewById8;
        Z9();
        View findViewById9 = rootView.findViewById(R.id.n5s);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "rootView.findViewById(R.\u2026ate_space_title_avatar_1)");
        this.mIvTitleAvatar1 = (QZoneUserAvatarView) findViewById9;
        View findViewById10 = rootView.findViewById(R.id.n5t);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "rootView.findViewById(R.\u2026ate_space_title_avatar_2)");
        this.mIvTitleAvatar2 = (QZoneUserAvatarView) findViewById10;
        View findViewById11 = rootView.findViewById(R.id.n5u);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "rootView.findViewById(R.\u2026pace_title_avatar_layout)");
        this.mTitleAvatarLayout = findViewById11;
        View findViewById12 = rootView.findViewById(R.id.nhe);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "rootView.findViewById(R.id.title_medal_container)");
        this.titleMedalContainer = findViewById12;
        View findViewById13 = rootView.findViewById(R.id.f20147l);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "rootView.findViewById(R.\u2026over_bottom_basic_layout)");
        this.bottomBasicContainer = findViewById13;
        if (findViewById13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomBasicContainer");
            findViewById13 = null;
        }
        View findViewById14 = findViewById13.findViewById(R.id.n5g);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "bottomBasicContainer.fin\u2026intimate_relation_layout)");
        this.relationContainer = findViewById14;
        View view2 = this.bottomBasicContainer;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomBasicContainer");
            view2 = null;
        }
        View findViewById15 = view2.findViewById(R.id.n5h);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "bottomBasicContainer.fin\u2026intimate_relation_msg_tv)");
        this.mTvRelationMsg = (TextView) findViewById15;
        View view3 = this.bottomBasicContainer;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomBasicContainer");
            view3 = null;
        }
        View findViewById16 = view3.findViewById(R.id.n5f);
        Intrinsics.checkNotNullExpressionValue(findViewById16, "bottomBasicContainer.fin\u2026ntimate_relation_days_tv)");
        this.mTvRelationDays = (TextView) findViewById16;
        View view4 = this.bottomBasicContainer;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomBasicContainer");
            view4 = null;
        }
        View findViewById17 = view4.findViewById(R.id.n5e);
        Intrinsics.checkNotNullExpressionValue(findViewById17, "bottomBasicContainer.fin\u2026ate_relation_day_text_tv)");
        this.mTvRelationDayText = (TextView) findViewById17;
        View view5 = this.bottomBasicContainer;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomBasicContainer");
            view5 = null;
        }
        View findViewById18 = view5.findViewById(R.id.n56);
        Intrinsics.checkNotNullExpressionValue(findViewById18, "bottomBasicContainer.fin\u2026imate_privacy_state_icon)");
        this.mIvPrivacyState = (ImageView) findViewById18;
        View view6 = this.bottomBasicContainer;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomBasicContainer");
            view6 = null;
        }
        View findViewById19 = view6.findViewById(R.id.nec);
        Intrinsics.checkNotNullExpressionValue(findViewById19, "bottomBasicContainer.fin\u2026.relation_icon_container)");
        this.relationIconContainer = (LinearLayout) findViewById19;
        View findViewById20 = rootView.findViewById(R.id.n66);
        Intrinsics.checkNotNullExpressionValue(findViewById20, "rootView.findViewById(R.\u2026te_title_share_container)");
        this.mLlShareContainer = (LinearLayout) findViewById20;
        View findViewById21 = rootView.findViewById(R.id.n5p);
        Intrinsics.checkNotNullExpressionValue(findViewById21, "rootView.findViewById(R.\u2026mate_space_punch_days_tv)");
        this.mTvPunchDays = (TextView) findViewById21;
        View view7 = this.bottomBasicContainer;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomBasicContainer");
            view7 = null;
        }
        View findViewById22 = view7.findViewById(R.id.n5q);
        Intrinsics.checkNotNullExpressionValue(findViewById22, "bottomBasicContainer.fin\u2026_intimate_space_punch_ll)");
        this.mLlPunch = (ViewGroup) findViewById22;
        View view8 = this.bottomBasicContainer;
        if (view8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomBasicContainer");
            view8 = null;
        }
        View findViewById23 = view8.findViewById(R.id.n5b);
        Intrinsics.checkNotNullExpressionValue(findViewById23, "bottomBasicContainer.fin\u2026mate_punch_btn_left_icon)");
        this.mIvPunchLeftIcon = (ImageView) findViewById23;
        View view9 = this.bottomBasicContainer;
        if (view9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomBasicContainer");
            view9 = null;
        }
        View findViewById24 = view9.findViewById(R.id.n5r);
        Intrinsics.checkNotNullExpressionValue(findViewById24, "bottomBasicContainer.fin\u2026_intimate_space_punch_tv)");
        this.mTvPunch = (TextView) findViewById24;
        View findViewById25 = rootView.findViewById(R.id.n5k);
        Intrinsics.checkNotNullExpressionValue(findViewById25, "rootView.findViewById(R.\u2026ate_space_app_bar_layout)");
        AppBarLayout appBarLayout2 = (AppBarLayout) findViewById25;
        this.mAppBarLayout = appBarLayout2;
        if (appBarLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAppBarLayout");
        } else {
            appBarLayout = appBarLayout2;
        }
        appBarLayout.e(new d());
        ja();
    }

    private final void Ca(List<? extends User> members) {
        QZoneUserAvatarView qZoneUserAvatarView = null;
        if (!members.isEmpty()) {
            User user = members.get(0);
            QZoneUserAvatarView qZoneUserAvatarView2 = this.mIvAvatar1;
            if (qZoneUserAvatarView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvAvatar1");
                qZoneUserAvatarView2 = null;
            }
            QZoneUserAvatarView qZoneUserAvatarView3 = this.mIvTitleAvatar1;
            if (qZoneUserAvatarView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvTitleAvatar1");
                qZoneUserAvatarView3 = null;
            }
            Ba(user, qZoneUserAvatarView2, qZoneUserAvatarView3);
        }
        if (members.size() >= 2) {
            User user2 = members.get(1);
            QZoneUserAvatarView qZoneUserAvatarView4 = this.mIvAvatar2;
            if (qZoneUserAvatarView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvAvatar2");
                qZoneUserAvatarView4 = null;
            }
            QZoneUserAvatarView qZoneUserAvatarView5 = this.mIvTitleAvatar2;
            if (qZoneUserAvatarView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mIvTitleAvatar2");
            } else {
                qZoneUserAvatarView = qZoneUserAvatarView5;
            }
            Ba(user2, qZoneUserAvatarView4, qZoneUserAvatarView);
        }
    }

    private final int ma() {
        return ef.d.b(50);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0025, code lost:
    
        if (android.text.TextUtils.isEmpty(r0.getStyleResourcesString()) != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void Sa(QZoneIntimateSpaceBean spaceBean) {
        if (spaceBean == null) {
            return;
        }
        nk.i iVar = this.styleViewModel;
        View view = null;
        if (iVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("styleViewModel");
            iVar = null;
        }
        if (iVar.getCoverSetting() != null) {
            nk.i iVar2 = this.styleViewModel;
            if (iVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("styleViewModel");
                iVar2 = null;
            }
        }
        nk.i iVar3 = this.styleViewModel;
        if (iVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("styleViewModel");
            iVar3 = null;
        }
        iVar3.S1(spaceBean.getSpaceType());
        this.mSpaceBean = spaceBean;
        Ca(spaceBean.getMembers());
        Ha(spaceBean);
        TextView textView = this.mTvRelationMsg;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvRelationMsg");
            textView = null;
        }
        textView.setText(spaceBean.getRelationMsg());
        TextView textView2 = this.mTvRelationDays;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvRelationDays");
            textView2 = null;
        }
        textView2.setText(String.valueOf(spaceBean.getRelationDays()));
        TextView textView3 = this.mTvRelationDays;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvRelationDays");
            textView3 = null;
        }
        com.qzone.reborn.feedx.widget.i.f(textView3);
        int a16 = ef.a.f396213a.a(spaceBean.getRelationColorPrimary(), getActivity().getResources().getColor(R.color.qui_common_brand_standard));
        TextView textView4 = this.mTvRelationDays;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvRelationDays");
            textView4 = null;
        }
        textView4.setTextColor(a16);
        TextView textView5 = this.mTvRelationDayText;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvRelationDayText");
            textView5 = null;
        }
        textView5.setVisibility(0);
        Ra(spaceBean.getIconList());
        if (spaceBean.supportModifyAnniversary()) {
            View view2 = this.relationContainer;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("relationContainer");
                view2 = null;
            }
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.intimate.part.cb
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    QZoneIntimateSpaceCoverPart.Ta(QZoneIntimateSpaceCoverPart.this, view3);
                }
            });
            View view3 = this.relationContainer;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("relationContainer");
            } else {
                view = view3;
            }
            fo.c.n(view, "em_qz_couple_days");
        }
        ga(spaceBean);
        ha(spaceBean.getSpaceType());
    }

    private final void ta(View rootView) {
        View findViewById = rootView.findViewById(R.id.n5c);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026_intimate_refresh_header)");
        this.mRefreshHeader = findViewById;
        SmartRefreshLayout smartRefreshLayout = null;
        if (findViewById == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRefreshHeader");
            findViewById = null;
        }
        findViewById.getLayoutParams().height = ImmersiveUtils.getStatusBarHeight(getContext()) + ma();
        View view = this.mRefreshHeader;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRefreshHeader");
            view = null;
        }
        view.setPadding(0, ImmersiveUtils.getStatusBarHeight(getContext()), 0, 0);
        View findViewById2 = rootView.findViewById(R.id.n5d);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026_intimate_refresh_layout)");
        SmartRefreshLayout smartRefreshLayout2 = (SmartRefreshLayout) findViewById2;
        this.mRefreshLayout = smartRefreshLayout2;
        if (smartRefreshLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRefreshLayout");
            smartRefreshLayout2 = null;
        }
        smartRefreshLayout2.setEnableOverScrollDrag(false);
        SmartRefreshLayout smartRefreshLayout3 = this.mRefreshLayout;
        if (smartRefreshLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRefreshLayout");
            smartRefreshLayout3 = null;
        }
        smartRefreshLayout3.setHeaderMaxDragRate(2.0f);
        SmartRefreshLayout smartRefreshLayout4 = this.mRefreshLayout;
        if (smartRefreshLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRefreshLayout");
            smartRefreshLayout4 = null;
        }
        smartRefreshLayout4.setHeaderTriggerRate(0.9f);
        SmartRefreshLayout smartRefreshLayout5 = this.mRefreshLayout;
        if (smartRefreshLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRefreshLayout");
            smartRefreshLayout5 = null;
        }
        smartRefreshLayout5.setOnRefreshListener(new OnRefreshListener() { // from class: com.qzone.reborn.intimate.part.ca
            @Override // com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener
            public final void onRefresh(IRefreshLayout iRefreshLayout) {
                QZoneIntimateSpaceCoverPart.ua(QZoneIntimateSpaceCoverPart.this, iRefreshLayout);
            }
        });
        SmartRefreshLayout smartRefreshLayout6 = this.mRefreshLayout;
        if (smartRefreshLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRefreshLayout");
        } else {
            smartRefreshLayout = smartRefreshLayout6;
        }
        smartRefreshLayout.setOnMultiListener(new c());
    }

    private final void La(long retCode, final ImageView forbiddenImageBg, LinearLayout forbiddenContentLayout, QUIButton forbiddenBottomBtn) {
        if (retCode == 10057) {
            fo.c.n(forbiddenBottomBtn, "em_qz_pilot_entry");
            String r16 = mk.d.f416875a.r();
            GradientDrawable gradientDrawable = new GradientDrawable();
            int g16 = ie0.a.f().g(getContext(), R.color.qui_button_bg_primary_default, 1000);
            int g17 = ie0.a.f().g(getContext(), R.color.qui_button_text_primary_default, 1000);
            gradientDrawable.setColor(g16);
            gradientDrawable.setCornerRadius(8.0f);
            forbiddenBottomBtn.setBackground(gradientDrawable);
            forbiddenBottomBtn.setTextColor(g17);
            forbiddenImageBg.setVisibility(0);
            com.tencent.mobileqq.qzone.picload.c.a().i(Option.obtain().setUrl(r16).setTargetView(forbiddenImageBg).setFailedDrawableId(R.drawable.trans).setLoadingDrawableId(R.drawable.trans), new IPicLoadStateListener() { // from class: com.qzone.reborn.intimate.part.bu
                @Override // com.tencent.libra.listener.IPicLoadStateListener
                public final void onStateChange(LoadState loadState, Option option) {
                    QZoneIntimateSpaceCoverPart.Ma(forbiddenImageBg, loadState, option);
                }
            });
            ViewGroup.LayoutParams layoutParams = forbiddenContentLayout.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.gravity = 1;
            layoutParams2.topMargin = ImmersiveUtils.dpToPx(120.0f);
            forbiddenContentLayout.setLayoutParams(layoutParams2);
            forbiddenBottomBtn.setVisibility(0);
            forbiddenBottomBtn.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.intimate.part.bv
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QZoneIntimateSpaceCoverPart.Na(QZoneIntimateSpaceCoverPart.this, view);
                }
            });
            return;
        }
        forbiddenBottomBtn.setVisibility(8);
        forbiddenImageBg.setVisibility(8);
    }

    private final void ia(float animRatio) {
        if (animRatio >= 1.0f && !this.mIsTitleAvatarShowing) {
            Oa();
            this.mIsTitleAvatarShowing = true;
        } else {
            if (animRatio >= 1.0f || !this.mIsTitleAvatarShowing) {
                return;
            }
            ra();
            this.mIsTitleAvatarShowing = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void qa(int verticalOffset, int totalScrollRange) {
        float coerceAtMost;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(Math.abs(verticalOffset) / ((int) (totalScrollRange * 0.9f)), 1.0f);
        ia(coerceAtMost);
        da(1 - coerceAtMost);
        ImageView imageView = this.mIvCoverBg;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvCoverBg");
            imageView = null;
        }
        imageView.setTranslationY(verticalOffset / 1.5f);
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/qzone/reborn/intimate/part/QZoneIntimateSpaceCoverPart$b", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            View view = QZoneIntimateSpaceCoverPart.this.mTitleAvatarLayout;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleAvatarLayout");
                view = null;
            }
            view.setVisibility(8);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
        }
    }
}

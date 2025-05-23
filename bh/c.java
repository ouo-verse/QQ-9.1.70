package bh;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.NinePatch;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.graphics.ColorUtils;
import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.feed.business.model.FeedResourceInfo;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.reborn.configx.g;
import com.qzone.reborn.feedx.bean.QZoneDragonUserInfo;
import com.qzone.reborn.feedx.presenter.springfestival.QZoneDragonAnimEvent;
import com.qzone.reborn.feedx.util.QZoneFeedxViewUtils;
import com.qzone.reborn.feedx.widget.QZoneNickNameView;
import com.qzone.reborn.feedx.widget.dragon.QZoneFeedHeadAppendDragonView;
import com.qzone.reborn.feedx.widget.dragon.QZoneFeedHeadBaseDragonView;
import com.qzone.reborn.feedx.widget.dragon.QZoneFeedHeadComposeDragonView;
import com.qzone.reborn.feedx.widget.dragon.QZoneFeedHeadDynamicDragonView;
import com.qzone.reborn.feedx.widget.dragon.QZoneFeedHeadUpgradeDragonView;
import com.qzone.reborn.util.k;
import com.qzone.util.ar;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qui.quishimmer.view.QUIShimmerFrameLayout;
import com.tencent.biz.richframework.compat.RFWNinePatchUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.service.qzone.e;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import ef.d;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00122\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001BB\u0007\u00a2\u0006\u0004\b@\u0010AJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0014J\b\u0010\u0017\u001a\u00020\u0016H\u0014J\b\u0010\u0019\u001a\u00020\u0018H\u0014J\b\u0010\u001a\u001a\u00020\u0018H\u0016J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0014J\b\u0010\u001e\u001a\u00020\u0004H\u0016J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J\b\u0010 \u001a\u00020\u0004H\u0016J\b\u0010!\u001a\u00020\u0004H\u0016J\u0012\u0010$\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016J$\u0010(\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030&0%j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030&`'H\u0016R\u0016\u0010+\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00105\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00102R\u0018\u00107\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u00106R\u0018\u0010:\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u00109R\u0016\u0010=\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010?\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010>\u00a8\u0006C"}, d2 = {"Lbh/c;", "Lvg/a;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/qzone/reborn/feedx/presenter/springfestival/QZoneDragonAnimEvent;", "", BdhLogUtil.LogTag.Tag_Req, "Lcom/qzone/reborn/feedx/bean/QZoneDragonUserInfo;", ITVKPlayerEventListener.KEY_USER_INFO, "K", "M", "J", "Lcom/qzone/reborn/feedx/widget/dragon/QZoneFeedHeadBaseDragonView;", "P", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, ExifInterface.LATITUDE_SOUTH, "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "O", "N", "T", "", "k", "", ReportConstant.COSTREPORT_PREFIX, "", HippyTKDListViewAdapter.X, "y", "Landroid/view/View;", "containerView", BdhLogUtil.LogTag.Tag_Conn, MosaicConstants$JsFunction.FUNC_ON_DESTROY, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "B", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", UserInfo.SEX_FEMALE, "Landroid/view/View;", "mTitleContainer", "Lcom/qzone/reborn/feedx/widget/QZoneNickNameView;", "G", "Lcom/qzone/reborn/feedx/widget/QZoneNickNameView;", "mNickNameView", "Lcom/tencent/biz/qui/quishimmer/view/QUIShimmerFrameLayout;", "H", "Lcom/tencent/biz/qui/quishimmer/view/QUIShimmerFrameLayout;", "mShimmerDragonContainer", "I", "mNickShimmerLayout", "Lcom/qzone/reborn/feedx/widget/dragon/QZoneFeedHeadBaseDragonView;", "mFeedHeadDragonView", "Lcom/tencent/mobileqq/widget/annimation/scaleview/a;", "Lcom/tencent/mobileqq/widget/annimation/scaleview/a;", "mImageViewScaleUtil", "L", "Z", "mIsAttachedToWindow", "Lcom/qzone/reborn/feedx/bean/QZoneDragonUserInfo;", "mDragonUserInfo", "<init>", "()V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class c extends vg.a implements SimpleEventReceiver<QZoneDragonAnimEvent> {

    /* renamed from: N, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static int P = ar.e(10.0f);
    private static int Q = ar.e(10.0f);
    private static final int R = ar.e(24.0f);

    /* renamed from: F, reason: from kotlin metadata */
    private View mTitleContainer;

    /* renamed from: G, reason: from kotlin metadata */
    private QZoneNickNameView mNickNameView;

    /* renamed from: H, reason: from kotlin metadata */
    private QUIShimmerFrameLayout mShimmerDragonContainer;

    /* renamed from: I, reason: from kotlin metadata */
    private QUIShimmerFrameLayout mNickShimmerLayout;

    /* renamed from: J, reason: from kotlin metadata */
    private QZoneFeedHeadBaseDragonView mFeedHeadDragonView;

    /* renamed from: K, reason: from kotlin metadata */
    private com.tencent.mobileqq.widget.annimation.scaleview.a mImageViewScaleUtil;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean mIsAttachedToWindow;

    /* renamed from: M, reason: from kotlin metadata */
    private QZoneDragonUserInfo mDragonUserInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004\u00a8\u0006\u000b"}, d2 = {"Lbh/c$a;", "", "", "DRAGON_CONTAINER_VIEW_HEIGHT", "I", "a", "()I", "DRAGON_PADDING_LEFT", "DRAGON_PADDING_RIGHT", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: bh.c$a, reason: from kotlin metadata */
    /* loaded from: classes39.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return c.R;
        }

        Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(c this$0, QZoneDragonUserInfo qZoneDragonUserInfo, LoadState state, Option option1) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(option1, "option1");
        if (state.isFinishSuccess() && option1.getResultBitMap() != null) {
            if (NinePatch.isNinePatchChunk(option1.getResultBitMap().getNinePatchChunk())) {
                QUIShimmerFrameLayout qUIShimmerFrameLayout = this$0.mNickShimmerLayout;
                QZoneNickNameView qZoneNickNameView = null;
                if (qUIShimmerFrameLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNickShimmerLayout");
                    qUIShimmerFrameLayout = null;
                }
                boolean z16 = qUIShimmerFrameLayout.getBackground() == null;
                QUIShimmerFrameLayout qUIShimmerFrameLayout2 = this$0.mNickShimmerLayout;
                if (qUIShimmerFrameLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNickShimmerLayout");
                    qUIShimmerFrameLayout2 = null;
                }
                qUIShimmerFrameLayout2.setPadding(P, 0, Q, 0);
                QUIShimmerFrameLayout qUIShimmerFrameLayout3 = this$0.mNickShimmerLayout;
                if (qUIShimmerFrameLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNickShimmerLayout");
                    qUIShimmerFrameLayout3 = null;
                }
                qUIShimmerFrameLayout3.setBackground(RFWNinePatchUtils.getNinePatchDrawable(option1.getResultBitMap()));
                QZoneNickNameView qZoneNickNameView2 = this$0.mNickNameView;
                if (qZoneNickNameView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNickNameView");
                } else {
                    qZoneNickNameView = qZoneNickNameView2;
                }
                qZoneNickNameView.setEnableFlash(false);
                this$0.M(qZoneDragonUserInfo);
                if (z16 && g.f53821a.b().T1()) {
                    this$0.S(qZoneDragonUserInfo);
                    return;
                }
                return;
            }
            return;
        }
        QLog.e(this$0.getTAG(), 1, "onStateChange state:" + state.isFinishSuccess() + " resultBitmap:" + option1.getResultBitMap());
    }

    private final void M(QZoneDragonUserInfo userInfo) {
        String textColorLight;
        if (userInfo.getFireResInfo() == null) {
            return;
        }
        if (k.f59549a.f()) {
            FeedResourceInfo fireResInfo = userInfo.getFireResInfo();
            Intrinsics.checkNotNull(fireResInfo);
            textColorLight = fireResInfo.getTextColorDark();
        } else {
            FeedResourceInfo fireResInfo2 = userInfo.getFireResInfo();
            Intrinsics.checkNotNull(fireResInfo2);
            textColorLight = fireResInfo2.getTextColorLight();
        }
        if (textColorLight != null) {
            try {
                QZoneNickNameView qZoneNickNameView = this.mNickNameView;
                if (qZoneNickNameView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNickNameView");
                    qZoneNickNameView = null;
                }
                qZoneNickNameView.setTextColor(Color.parseColor(textColorLight));
            } catch (Throwable th5) {
                RFWLog.fatal(getTAG(), RFWLog.USR, th5);
            }
        }
    }

    private final void N() {
        BusinessFeedData businessFeedData = this.f441565h;
        if (businessFeedData != null && ef.b.h(businessFeedData) && a.f28389a.n(this.f441565h)) {
            T();
        }
    }

    private final QZoneDragonUserInfo O(BusinessFeedData feedData) {
        Map<String, String> map;
        CellFeedCommInfo cellFeedCommInfo = feedData.cellFeedCommInfo;
        if (cellFeedCommInfo != null && (map = cellFeedCommInfo.extendInfo) != null) {
            String str = map.get("user_info");
            if ((str == null || str.length() == 0) || !e.f286406a.b() || feedData.isFakeFeed() || !ef.b.j(feedData)) {
                return null;
            }
            try {
                return (QZoneDragonUserInfo) new Gson().fromJson(str, QZoneDragonUserInfo.class);
            } catch (Throwable th5) {
                RFWLog.fatal(getTAG(), RFWLog.USR, th5);
                return null;
            }
        }
        RFWLog.d(getTAG(), RFWLog.USR, "getDragonUserInfo, error, no extend info");
        return null;
    }

    private final QZoneFeedHeadBaseDragonView P(QZoneDragonUserInfo userInfo) {
        int badgeType = userInfo.getBadgeType();
        if (badgeType == QZoneDragonUserInfo.BadgeType.BADGE_TYPE_LIST.getType()) {
            Activity activity = i();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            return new QZoneFeedHeadAppendDragonView(activity, null);
        }
        if (badgeType == QZoneDragonUserInfo.BadgeType.BADGE_TYPE_THREE_LAYER.getType()) {
            Activity activity2 = i();
            Intrinsics.checkNotNullExpressionValue(activity2, "activity");
            return new QZoneFeedHeadComposeDragonView(activity2, null);
        }
        if (badgeType == QZoneDragonUserInfo.BadgeType.BADGE_TYPE_FUSION.getType()) {
            Activity activity3 = i();
            Intrinsics.checkNotNullExpressionValue(activity3, "activity");
            return new QZoneFeedHeadDynamicDragonView(activity3, null);
        }
        Activity activity4 = i();
        Intrinsics.checkNotNullExpressionValue(activity4, "activity");
        return new QZoneFeedHeadUpgradeDragonView(activity4, null);
    }

    private final void Q() {
        int g16 = QZoneFeedxViewUtils.g(i(), false);
        QZoneNickNameView qZoneNickNameView = this.mNickNameView;
        QUIShimmerFrameLayout qUIShimmerFrameLayout = null;
        if (qZoneNickNameView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNickNameView");
            qZoneNickNameView = null;
        }
        qZoneNickNameView.setMaxWidth(g16);
        QUIShimmerFrameLayout qUIShimmerFrameLayout2 = this.mShimmerDragonContainer;
        if (qUIShimmerFrameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShimmerDragonContainer");
            qUIShimmerFrameLayout2 = null;
        }
        qUIShimmerFrameLayout2.clearAnimation();
        QUIShimmerFrameLayout qUIShimmerFrameLayout3 = this.mShimmerDragonContainer;
        if (qUIShimmerFrameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShimmerDragonContainer");
        } else {
            qUIShimmerFrameLayout = qUIShimmerFrameLayout3;
        }
        qUIShimmerFrameLayout.setVisibility(8);
    }

    private final void R() {
        QUIShimmerFrameLayout qUIShimmerFrameLayout = this.mShimmerDragonContainer;
        QUIShimmerFrameLayout qUIShimmerFrameLayout2 = null;
        if (qUIShimmerFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShimmerDragonContainer");
            qUIShimmerFrameLayout = null;
        }
        qUIShimmerFrameLayout.getLayoutParams().height = R;
        int color = i().getColor(R.color.cpf);
        QUIShimmerFrameLayout qUIShimmerFrameLayout3 = this.mShimmerDragonContainer;
        if (qUIShimmerFrameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShimmerDragonContainer");
            qUIShimmerFrameLayout3 = null;
        }
        qUIShimmerFrameLayout3.updateColors(0, ColorUtils.setAlphaComponent(color, 153), ColorUtils.setAlphaComponent(color, 102), 0);
        QUIShimmerFrameLayout qUIShimmerFrameLayout4 = this.mShimmerDragonContainer;
        if (qUIShimmerFrameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShimmerDragonContainer");
        } else {
            qUIShimmerFrameLayout2 = qUIShimmerFrameLayout4;
        }
        qUIShimmerFrameLayout2.updateRepeatCount(0);
    }

    private final void S(QZoneDragonUserInfo userInfo) {
        int g16 = QZoneFeedxViewUtils.g(i(), true);
        int b16 = a.f28389a.b(g16, userInfo);
        QUIShimmerFrameLayout qUIShimmerFrameLayout = this.mNickShimmerLayout;
        QZoneNickNameView qZoneNickNameView = null;
        if (qUIShimmerFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNickShimmerLayout");
            qUIShimmerFrameLayout = null;
        }
        int i3 = qUIShimmerFrameLayout.getBackground() != null ? ((g16 - b16) - P) - Q : g16 - b16;
        QZoneNickNameView qZoneNickNameView2 = this.mNickNameView;
        if (qZoneNickNameView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNickNameView");
            qZoneNickNameView2 = null;
        }
        qZoneNickNameView2.setMaxWidth(i3);
        QUIShimmerFrameLayout qUIShimmerFrameLayout2 = this.mShimmerDragonContainer;
        if (qUIShimmerFrameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShimmerDragonContainer");
            qUIShimmerFrameLayout2 = null;
        }
        ViewGroup.LayoutParams layoutParams = qUIShimmerFrameLayout2.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = b16;
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            QUIShimmerFrameLayout qUIShimmerFrameLayout3 = this.mNickShimmerLayout;
            if (qUIShimmerFrameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNickShimmerLayout");
                qUIShimmerFrameLayout3 = null;
            }
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = qUIShimmerFrameLayout3.getBackground() != null ? 0 : d.b(5);
        }
        String tag = getTAG();
        int i16 = RFWLog.DEV;
        Object[] objArr = new Object[1];
        int grade = userInfo.getGrade();
        QUIShimmerFrameLayout qUIShimmerFrameLayout4 = this.mNickShimmerLayout;
        if (qUIShimmerFrameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNickShimmerLayout");
            qUIShimmerFrameLayout4 = null;
        }
        Drawable background = qUIShimmerFrameLayout4.getBackground();
        QZoneNickNameView qZoneNickNameView3 = this.mNickNameView;
        if (qZoneNickNameView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNickNameView");
            qZoneNickNameView3 = null;
        }
        int width = qZoneNickNameView3.getWidth();
        QZoneNickNameView qZoneNickNameView4 = this.mNickNameView;
        if (qZoneNickNameView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNickNameView");
        } else {
            qZoneNickNameView = qZoneNickNameView4;
        }
        objArr[0] = "setupWidth, containerWidth: " + g16 + ", level: " + grade + ",dragonWidth: " + b16 + ", background:" + background + ", curWidth:" + width + ", nickNameMaxWidth:" + i3 + ", nickName:" + qZoneNickNameView.getText() + ", position: " + this.f441567m;
        RFWLog.d(tag, i16, objArr);
    }

    private final void T() {
        QUIShimmerFrameLayout qUIShimmerFrameLayout = this.mShimmerDragonContainer;
        if (qUIShimmerFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShimmerDragonContainer");
            qUIShimmerFrameLayout = null;
        }
        qUIShimmerFrameLayout.startShimming(null);
        com.tencent.mobileqq.widget.annimation.scaleview.a aVar = new com.tencent.mobileqq.widget.annimation.scaleview.a();
        this.mImageViewScaleUtil = aVar;
        Intrinsics.checkNotNull(aVar);
        QUIShimmerFrameLayout qUIShimmerFrameLayout2 = this.mShimmerDragonContainer;
        if (qUIShimmerFrameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShimmerDragonContainer");
            qUIShimmerFrameLayout2 = null;
        }
        aVar.e(qUIShimmerFrameLayout2).d(1.0f, 1.08f, 1.0f, 1.08f).c(1);
        com.tencent.mobileqq.widget.annimation.scaleview.a aVar2 = this.mImageViewScaleUtil;
        if (aVar2 != null) {
            aVar2.f(null);
        }
    }

    @Override // vg.a
    protected void A(BusinessFeedData feedData) {
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        try {
            QZoneDragonUserInfo O = O(feedData);
            this.mDragonUserInfo = O;
            J(O);
            K(O);
        } catch (Throwable th5) {
            RFWLog.e(getTAG(), RFWLog.USR, th5);
        }
    }

    @Override // vg.a
    public void B() {
        super.B();
        this.mIsAttachedToWindow = false;
    }

    @Override // vg.a
    protected void C(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        try {
            View findViewById = containerView.findViewById(R.id.n87);
            Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026(R.id.qzone_nike_name_tv)");
            this.mNickNameView = (QZoneNickNameView) findViewById;
            View findViewById2 = containerView.findViewById(R.id.n2y);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026qzone_head_dragon_layout)");
            this.mShimmerDragonContainer = (QUIShimmerFrameLayout) findViewById2;
            View findViewById3 = containerView.findViewById(R.id.n1p);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026e_feedx_title_sub_layout)");
            this.mTitleContainer = findViewById3;
            View findViewById4 = containerView.findViewById(R.id.f162904n84);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewBy\u2026zone_nick_shimmer_layout)");
            this.mNickShimmerLayout = (QUIShimmerFrameLayout) findViewById4;
            R();
            SimpleEventBus.getInstance().registerReceiver(this);
        } catch (Throwable th5) {
            RFWLog.e(getTAG(), RFWLog.USR, th5);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<QZoneDragonAnimEvent>> getEventClass() {
        ArrayList<Class<QZoneDragonAnimEvent>> arrayList = new ArrayList<>();
        arrayList.add(QZoneDragonAnimEvent.class);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "QZoneFeedHeadDragonPresenter";
    }

    @Override // vg.a, vg.c
    public void onDestroy() {
        super.onDestroy();
        QUIShimmerFrameLayout qUIShimmerFrameLayout = this.mShimmerDragonContainer;
        if (qUIShimmerFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShimmerDragonContainer");
            qUIShimmerFrameLayout = null;
        }
        qUIShimmerFrameLayout.stopShimming(null);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        BusinessFeedData businessFeedData;
        if (!(event instanceof QZoneDragonAnimEvent) || (businessFeedData = this.f441565h) == null || ef.b.h(businessFeedData)) {
            return;
        }
        QZoneDragonAnimEvent qZoneDragonAnimEvent = (QZoneDragonAnimEvent) event;
        if (Intrinsics.areEqual(ef.b.a(this.f441565h), qZoneDragonAnimEvent.getFeedUniKey()) && Intrinsics.areEqual(qZoneDragonAnimEvent.getContext(), i()) && ef.b.j(this.f441565h)) {
            a aVar = a.f28389a;
            if (aVar.l(this.f441565h, qZoneDragonAnimEvent.getIsPraise())) {
                T();
                if (qZoneDragonAnimEvent.getIsPraise()) {
                    BusinessFeedData mFeedData = this.f441565h;
                    Intrinsics.checkNotNullExpressionValue(mFeedData, "mFeedData");
                    aVar.k(mFeedData);
                }
            }
        }
    }

    @Override // vg.a
    protected int s() {
        return R.id.nog;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    @Override // vg.a
    public boolean y() {
        return super.y() && e.f286406a.b();
    }

    @Override // vg.a
    public void z() {
        super.z();
        this.mIsAttachedToWindow = true;
        N();
    }

    private final void J(QZoneDragonUserInfo userInfo) {
        if (userInfo != null && userInfo.isValidDragonResInfo()) {
            QZoneFeedHeadBaseDragonView P2 = P(userInfo);
            this.mFeedHeadDragonView = P2;
            S(userInfo);
            ViewGroup.LayoutParams layoutParams = P2.getLayoutParams();
            QUIShimmerFrameLayout qUIShimmerFrameLayout = null;
            if (layoutParams != null) {
                QUIShimmerFrameLayout qUIShimmerFrameLayout2 = this.mShimmerDragonContainer;
                if (qUIShimmerFrameLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mShimmerDragonContainer");
                    qUIShimmerFrameLayout2 = null;
                }
                ViewGroup.LayoutParams layoutParams2 = qUIShimmerFrameLayout2.getLayoutParams();
                layoutParams.width = (layoutParams2 != null ? Integer.valueOf(layoutParams2.width) : null).intValue();
            }
            P2.setFeedData(this.f441565h);
            P2.setData(userInfo);
            QUIShimmerFrameLayout qUIShimmerFrameLayout3 = this.mShimmerDragonContainer;
            if (qUIShimmerFrameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mShimmerDragonContainer");
                qUIShimmerFrameLayout3 = null;
            }
            qUIShimmerFrameLayout3.setVisibility(0);
            QUIShimmerFrameLayout qUIShimmerFrameLayout4 = this.mShimmerDragonContainer;
            if (qUIShimmerFrameLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mShimmerDragonContainer");
                qUIShimmerFrameLayout4 = null;
            }
            qUIShimmerFrameLayout4.removeAllViews();
            QUIShimmerFrameLayout qUIShimmerFrameLayout5 = this.mShimmerDragonContainer;
            if (qUIShimmerFrameLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mShimmerDragonContainer");
            } else {
                qUIShimmerFrameLayout = qUIShimmerFrameLayout5;
            }
            qUIShimmerFrameLayout.addView(P2);
            if (this.mIsAttachedToWindow && g.f53821a.b().H1()) {
                N();
            }
            QLog.d(getTAG(), 4, "bindDragonView, dragonView:" + P2 + ",grade:" + userInfo.getGrade());
            return;
        }
        RFWLog.e(getTAG(), RFWLog.DEV, "[bindDragonView] userInfo:" + userInfo);
        Q();
    }

    private final void K(final QZoneDragonUserInfo userInfo) {
        FeedResourceInfo fireResInfo;
        String sourceMaterialUrl = (userInfo == null || (fireResInfo = userInfo.getFireResInfo()) == null) ? null : fireResInfo.getSourceMaterialUrl();
        RFWLog.d(getTAG(), RFWLog.DEV, "bindNickFireBg, url: " + sourceMaterialUrl);
        if (sourceMaterialUrl == null || sourceMaterialUrl.length() == 0) {
            QUIShimmerFrameLayout qUIShimmerFrameLayout = this.mNickShimmerLayout;
            if (qUIShimmerFrameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNickShimmerLayout");
                qUIShimmerFrameLayout = null;
            }
            qUIShimmerFrameLayout.setPadding(0, 0, 0, 0);
            QUIShimmerFrameLayout qUIShimmerFrameLayout2 = this.mNickShimmerLayout;
            if (qUIShimmerFrameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNickShimmerLayout");
                qUIShimmerFrameLayout2 = null;
            }
            qUIShimmerFrameLayout2.setBackground(null);
            return;
        }
        com.tencent.mobileqq.qzone.picload.c.a().i(Option.obtain().setUrl(sourceMaterialUrl).setIsNinePatch(true), new IPicLoadStateListener() { // from class: bh.b
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                c.L(c.this, userInfo, loadState, option);
            }
        });
    }
}

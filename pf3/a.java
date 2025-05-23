package pf3;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.mini.entry.layout.LayoutAttrsKt;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.card.impl.view.ZPlanCommonFailCard;
import com.tencent.mobileqq.zplan.card.impl.view.ZPlanCommonLoadingShimmerCard;
import com.tencent.mobileqq.zplan.card.impl.view.ZPlanCommonTitleCard;
import com.tencent.mobileqq.zplan.card.impl.view.ZootopiaDefaultCard;
import com.tencent.mobileqq.zplan.card.impl.view.ZootopiaMidListCard;
import com.tencent.mobileqq.zplan.card.impl.view.ZootopiaTextCard;
import com.tencent.mobileqq.zplan.card.impl.view.ZootopiaVerticalGalleryCard;
import com.tencent.mobileqq.zplan.card.impl.view.avatar.ZPlanAvatarCard;
import com.tencent.mobileqq.zplan.card.impl.view.banner.ZootopiaMidBannerCard;
import com.tencent.mobileqq.zplan.card.impl.view.banner.ZootopiaNormalBannerCard;
import com.tencent.mobileqq.zplan.card.impl.view.banner.ZplanLinkedBannerCard;
import com.tencent.mobileqq.zplan.card.impl.view.grid.ZPlanGridWithBigCard;
import com.tencent.mobileqq.zplan.card.impl.view.halfbanner.ZPlanHalfBannerCard;
import com.tencent.mobileqq.zplan.card.impl.view.halfbanner.ZPlanParadiseNewBannerCard19;
import com.tencent.mobileqq.zplan.card.impl.view.horizontalscroll.ZPlanHorizontalScrollSmallCard;
import com.tencent.mobileqq.zplan.card.impl.view.horizontalscroll.ZPlanHorizontalScrollWithButtonCard;
import com.tencent.mobileqq.zplan.card.impl.view.horizontalscroll.ZPlanHorizontalScrollWithDownloadBtnCard;
import com.tencent.mobileqq.zplan.card.impl.view.horizontalscroll.ZplanHorizontalScrollSmallIconCard;
import com.tencent.mobileqq.zplan.card.impl.view.smallhome.ZplanSmallHomePartyCard;
import com.tencent.mobileqq.zplan.card.impl.view.smallhome.ZplanSmallHomeStatusCard;
import com.tencent.mobileqq.zplan.card.impl.view.stagger.ZPlanStaggerCard;
import com.tencent.mobileqq.zplan.card.impl.view.videoCard.ZootopiaBigVideoCard;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.utils.ScreenUtils;
import com.tencent.sqshow.zootopia.card.base.ZootopiaBaseCard;
import com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lpf3/a;", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J0\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0007J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0011\u001a\u00020\u00108\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lpf3/a$a;", "", "", "viewType", "Landroid/content/Context;", "context", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Loa4/a;", "mapResViewModel", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "Lcom/tencent/sqshow/zootopia/card/base/ZootopiaBaseCard;", "a", "", "b", "", "MIN_EXPOSURE_RATE", UserInfo.SEX_FEMALE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: pf3.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes36.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final ZootopiaBaseCard a(int viewType, Context context, LifecycleOwner owner, oa4.a mapResViewModel, ZootopiaSource sourceCurrent) {
            ZootopiaBaseCard zplanHorizontalScrollSmallIconCard;
            ZootopiaBaseCard zPlanCommonLoadingShimmerCard;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(owner, "owner");
            Intrinsics.checkNotNullParameter(mapResViewModel, "mapResViewModel");
            Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
            QLog.i("ZootopiaRecommendCardFactory", 1, "createRecommendCard - viewType = " + viewType);
            ViewUtils.dpToPx(16.0f);
            int screenWidth = ScreenUtils.getScreenWidth(context);
            long currentTimeMillis = System.currentTimeMillis();
            QLog.i("ZootopiaRecommendCardFactory", 1, "createRecommendCard begin - viewType = " + viewType);
            if (viewType == 2) {
                zplanHorizontalScrollSmallIconCard = new ZplanHorizontalScrollSmallIconCard(context, owner, mapResViewModel, sourceCurrent, viewType);
            } else if (viewType == 3) {
                zplanHorizontalScrollSmallIconCard = new ZootopiaNormalBannerCard(context, owner, mapResViewModel, sourceCurrent, viewType);
                zplanHorizontalScrollSmallIconCard.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            } else if (viewType == 4) {
                zplanHorizontalScrollSmallIconCard = new ZplanLinkedBannerCard(context, owner, mapResViewModel, sourceCurrent, viewType);
            } else if (viewType == 5) {
                zplanHorizontalScrollSmallIconCard = new ZootopiaVerticalGalleryCard(context, owner, mapResViewModel, sourceCurrent, viewType);
            } else if (viewType == 6) {
                zplanHorizontalScrollSmallIconCard = new ZootopiaMidListCard(context, owner, mapResViewModel, sourceCurrent, viewType);
            } else if (viewType == 8) {
                zplanHorizontalScrollSmallIconCard = new ZootopiaMidBannerCard(context, owner, mapResViewModel, sourceCurrent, viewType);
                zplanHorizontalScrollSmallIconCard.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            } else if (viewType == 9) {
                zplanHorizontalScrollSmallIconCard = new ZPlanAvatarCard(context, owner, mapResViewModel, sourceCurrent, viewType);
            } else if (viewType == 30) {
                zplanHorizontalScrollSmallIconCard = new ZootopiaTextCard(context, owner, mapResViewModel, sourceCurrent, viewType);
            } else if (viewType == 41) {
                zplanHorizontalScrollSmallIconCard = new ZPlanParadiseNewBannerCard19(context, owner, mapResViewModel, sourceCurrent, viewType);
            } else if (viewType == 36) {
                zplanHorizontalScrollSmallIconCard = new ZplanSmallHomeStatusCard(context, owner, mapResViewModel, sourceCurrent, viewType);
                zplanHorizontalScrollSmallIconCard.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            } else if (viewType != 37) {
                switch (viewType) {
                    case 21:
                        zplanHorizontalScrollSmallIconCard = new ZPlanHalfBannerCard(context, owner, mapResViewModel, sourceCurrent, viewType);
                        break;
                    case 22:
                        zplanHorizontalScrollSmallIconCard = new ZootopiaBigVideoCard(context, owner, mapResViewModel, sourceCurrent, viewType);
                        break;
                    case 23:
                        zplanHorizontalScrollSmallIconCard = new ZPlanGridWithBigCard(context, owner, mapResViewModel, sourceCurrent, viewType);
                        break;
                    case 24:
                        zplanHorizontalScrollSmallIconCard = new ZPlanHorizontalScrollSmallCard(context, owner, mapResViewModel, sourceCurrent, viewType);
                        break;
                    case 25:
                        zplanHorizontalScrollSmallIconCard = new ZPlanHorizontalScrollWithDownloadBtnCard(context, owner, mapResViewModel, sourceCurrent, viewType);
                        break;
                    case 26:
                        zplanHorizontalScrollSmallIconCard = new ZPlanHorizontalScrollWithButtonCard(context, owner, mapResViewModel, sourceCurrent, viewType);
                        break;
                    case 27:
                        zplanHorizontalScrollSmallIconCard = new ZPlanStaggerCard(context, owner, mapResViewModel, sourceCurrent, viewType);
                        break;
                    default:
                        switch (viewType) {
                            case 202201:
                                zPlanCommonLoadingShimmerCard = new ZPlanCommonLoadingShimmerCard(context, owner, mapResViewModel, sourceCurrent, viewType);
                                zPlanCommonLoadingShimmerCard.setLayoutParams(new FrameLayout.LayoutParams(screenWidth, LayoutAttrsKt.getDp(ITPMediaCodecDecoder.BYTES_SET_MEDIA_DRM_SESSION_ID)));
                                zplanHorizontalScrollSmallIconCard = zPlanCommonLoadingShimmerCard;
                                break;
                            case 202202:
                                zPlanCommonLoadingShimmerCard = new ZPlanCommonFailCard(context, owner, mapResViewModel, sourceCurrent, viewType);
                                zPlanCommonLoadingShimmerCard.setLayoutParams(new FrameLayout.LayoutParams(screenWidth, LayoutAttrsKt.getDp(300)));
                                zplanHorizontalScrollSmallIconCard = zPlanCommonLoadingShimmerCard;
                                break;
                            case 202203:
                                zPlanCommonLoadingShimmerCard = new ZPlanCommonFailCard(context, owner, mapResViewModel, sourceCurrent, viewType);
                                zPlanCommonLoadingShimmerCard.setLayoutParams(new FrameLayout.LayoutParams(screenWidth, LayoutAttrsKt.getDp(300)));
                                zplanHorizontalScrollSmallIconCard = zPlanCommonLoadingShimmerCard;
                                break;
                            case 202204:
                                zplanHorizontalScrollSmallIconCard = new ZPlanCommonTitleCard(context, owner, mapResViewModel, sourceCurrent, viewType);
                                break;
                            default:
                                zplanHorizontalScrollSmallIconCard = new ZootopiaDefaultCard(context, owner, mapResViewModel, sourceCurrent, viewType);
                                zplanHorizontalScrollSmallIconCard.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
                                break;
                        }
                }
            } else {
                zplanHorizontalScrollSmallIconCard = new ZplanSmallHomePartyCard(context, owner, mapResViewModel, sourceCurrent, viewType);
            }
            QLog.i("ZootopiaRecommendCardFactory", 1, "createRecommendCard instance cost:" + (System.currentTimeMillis() - currentTimeMillis) + " - viewType=" + viewType + ", cardRet:" + zplanHorizontalScrollSmallIconCard);
            zplanHorizontalScrollSmallIconCard.t(context);
            QLog.i("ZootopiaRecommendCardFactory", 1, "createRecommendCard initView cost:" + (System.currentTimeMillis() - currentTimeMillis) + "  - viewType=" + viewType + ", cardRet:" + zplanHorizontalScrollSmallIconCard);
            return zplanHorizontalScrollSmallIconCard;
        }

        @JvmStatic
        public final boolean b(int viewType) {
            if (viewType != 22 && viewType != 29) {
                return false;
            }
            return true;
        }

        Companion() {
        }
    }
}

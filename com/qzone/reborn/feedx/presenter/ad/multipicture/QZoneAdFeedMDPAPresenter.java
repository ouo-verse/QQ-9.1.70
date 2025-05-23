package com.qzone.reborn.feedx.presenter.ad.multipicture;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.commoncode.module.gdt.GdtFeedUtilForQZone;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.reborn.feedx.presenter.ad.multipicture.c;
import com.qzone.reborn.feedx.util.ad.QZoneAdFeedUtils;
import com.qzone.util.ar;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tencent.gdt.qq_ad_get;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\b\u0010\u0006\u001a\u00020\u0002H\u0014J\b\u0010\b\u001a\u00020\u0007H\u0014J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J\u0012\u0010\u000f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0019\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/qzone/reborn/feedx/presenter/ad/multipicture/QZoneAdFeedMDPAPresenter;", "Lvg/a;", "", "K", "", "k", ReportConstant.COSTREPORT_PREFIX, "", HippyTKDListViewAdapter.X, "Landroid/view/View;", "containerView", "", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/qzone/reborn/feedx/presenter/ad/multipicture/QZoneAdMDPARecyclerView;", UserInfo.SEX_FEMALE, "Lcom/qzone/reborn/feedx/presenter/ad/multipicture/QZoneAdMDPARecyclerView;", "mRecyclerView", "Lcom/qzone/reborn/feedx/presenter/ad/multipicture/c;", "G", "Lkotlin/Lazy;", "L", "()Lcom/qzone/reborn/feedx/presenter/ad/multipicture/c;", "mMultiPicAdapter", "<init>", "()V", "H", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneAdFeedMDPAPresenter extends vg.a {

    /* renamed from: F, reason: from kotlin metadata */
    private QZoneAdMDPARecyclerView mRecyclerView;

    /* renamed from: G, reason: from kotlin metadata */
    private final Lazy mMultiPicAdapter;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/feedx/presenter/ad/multipicture/QZoneAdFeedMDPAPresenter$b", "Lcom/qzone/reborn/feedx/presenter/ad/multipicture/c$c;", "", "itemViewType", "Landroid/view/View;", "view", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements c.InterfaceC0467c {
        b() {
        }

        @Override // com.qzone.reborn.feedx.presenter.ad.multipicture.c.InterfaceC0467c
        public void a(int itemViewType, View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    return;
                }
                ((vg.a) QZoneAdFeedMDPAPresenter.this).f441565h.getAdData().setMDPAClickItemPosition(Integer.MIN_VALUE);
                QZoneAdFeedUtils qZoneAdFeedUtils = QZoneAdFeedUtils.f55717a;
                Activity mActivity = ((vg.a) QZoneAdFeedMDPAPresenter.this).C;
                Intrinsics.checkNotNullExpressionValue(mActivity, "mActivity");
                BusinessFeedData mFeedData = ((vg.a) QZoneAdFeedMDPAPresenter.this).f441565h;
                Intrinsics.checkNotNullExpressionValue(mFeedData, "mFeedData");
                qZoneAdFeedUtils.H(mActivity, view, mFeedData, FeedElement.GDT_MDPA_AD, 10028, ((vg.a) QZoneAdFeedMDPAPresenter.this).f441567m, null);
                return;
            }
            Object tag = view.getTag(2131296418);
            if (!(tag instanceof Integer)) {
                QLog.e("QZoneAdFeedMDPAPresenter", 2, "[onClick] item click pos error");
                return;
            }
            ((vg.a) QZoneAdFeedMDPAPresenter.this).f441565h.getAdData().setMDPAClickItemPosition(((Number) tag).intValue());
            QZoneAdFeedUtils qZoneAdFeedUtils2 = QZoneAdFeedUtils.f55717a;
            Activity mActivity2 = ((vg.a) QZoneAdFeedMDPAPresenter.this).C;
            Intrinsics.checkNotNullExpressionValue(mActivity2, "mActivity");
            BusinessFeedData mFeedData2 = ((vg.a) QZoneAdFeedMDPAPresenter.this).f441565h;
            Intrinsics.checkNotNullExpressionValue(mFeedData2, "mFeedData");
            qZoneAdFeedUtils2.H(mActivity2, view, mFeedData2, FeedElement.GDT_MDPA_AD, 10028, ((vg.a) QZoneAdFeedMDPAPresenter.this).f441567m, null);
        }
    }

    public QZoneAdFeedMDPAPresenter() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<c>() { // from class: com.qzone.reborn.feedx.presenter.ad.multipicture.QZoneAdFeedMDPAPresenter$mMultiPicAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final c invoke() {
                Activity mActivity = ((vg.a) QZoneAdFeedMDPAPresenter.this).C;
                Intrinsics.checkNotNullExpressionValue(mActivity, "mActivity");
                return new c(mActivity);
            }
        });
        this.mMultiPicAdapter = lazy;
    }

    private final int K() {
        if (QZoneAdFeedDataExtKt.isMDPAStyleA(this.f441565h)) {
            return 1;
        }
        return QZoneAdFeedDataExtKt.isMDPAStyleB(this.f441565h) ? 2 : 0;
    }

    private final c L() {
        return (c) this.mMultiPicAdapter.getValue();
    }

    @Override // vg.a
    protected void A(BusinessFeedData feedData) {
        boolean z16;
        qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo displayInfo;
        qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo basicInfo;
        PBRepeatMessageField<qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.MaterialInfo> pBRepeatMessageField;
        QZoneAdMDPARecyclerView qZoneAdMDPARecyclerView = this.mRecyclerView;
        if (qZoneAdMDPARecyclerView != null) {
            qZoneAdMDPARecyclerView.setVisibility(8);
        }
        BusinessFeedData businessFeedData = this.f441565h;
        if (businessFeedData == null) {
            return;
        }
        boolean z17 = true;
        if (!QZoneAdFeedDataExtKt.isMDPAStyleA(businessFeedData) && !QZoneAdFeedDataExtKt.isMDPAStyleB(this.f441565h)) {
            QLog.e("QZoneAdFeedMDPAPresenter", 1, "[onBindData] is not MDPA Ad");
            return;
        }
        GdtAd E = GdtFeedUtilForQZone.E(feedData);
        if (E == null) {
            return;
        }
        qq_ad_get.QQAdGetRsp.AdInfo adInfo = E.info;
        List<qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.MaterialInfo> list = (adInfo == null || (displayInfo = adInfo.display_info) == null || (basicInfo = displayInfo.basic_info) == null || (pBRepeatMessageField = basicInfo.materials) == null) ? null : pBRepeatMessageField.get();
        List<qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.MaterialInfo> list2 = list;
        int i3 = 0;
        if (list2 == null || list2.isEmpty()) {
            QLog.e("QZoneAdFeedMDPAPresenter", 1, "[onBindData] mpdainfos is empty");
            return;
        }
        QZoneAdMDPARecyclerView qZoneAdMDPARecyclerView2 = this.mRecyclerView;
        if (qZoneAdMDPARecyclerView2 != null) {
            qZoneAdMDPARecyclerView2.setVisibility(0);
        }
        List<qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.MaterialInfo> list3 = list;
        boolean z18 = list3 instanceof Collection;
        if (!z18 || !list3.isEmpty()) {
            Iterator<T> it = list3.iterator();
            while (it.hasNext()) {
                if (TextUtils.isEmpty(((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.MaterialInfo) it.next()).price.get())) {
                    z16 = true;
                    break;
                }
            }
        }
        z16 = false;
        if (!z18 || !list3.isEmpty()) {
            Iterator<T> it5 = list3.iterator();
            while (it5.hasNext()) {
                if (TextUtils.isEmpty(((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.MaterialInfo) it5.next()).original_price.get())) {
                    break;
                }
            }
        }
        z17 = false;
        L().v0(new c.d(K(), z16, z17));
        L().t0(list, E);
        L().notifyDataSetChanged();
        L().u0(new b());
        QZoneAdMDPARecyclerView qZoneAdMDPARecyclerView3 = this.mRecyclerView;
        ViewGroup.LayoutParams layoutParams = qZoneAdMDPARecyclerView3 != null ? qZoneAdMDPARecyclerView3.getLayoutParams() : null;
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        if (QZoneAdFeedDataExtKt.isMDPAStyleA(this.f441565h)) {
            i3 = ar.e(8.0f);
        } else if (QZoneAdFeedDataExtKt.isMDPAStyleB(this.f441565h)) {
            i3 = ar.e(12.0f);
        }
        layoutParams2.topMargin = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "QZoneAdFeedMDPAPresenter";
    }

    @Override // vg.a
    protected int s() {
        return R.id.nmy;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    @Override // vg.a
    protected void C(View containerView) {
        if (containerView != null && (containerView instanceof QZoneAdMDPARecyclerView)) {
            this.mRecyclerView = (QZoneAdMDPARecyclerView) containerView;
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.C);
            linearLayoutManager.setOrientation(0);
            QZoneAdMDPARecyclerView qZoneAdMDPARecyclerView = this.mRecyclerView;
            if (qZoneAdMDPARecyclerView != null) {
                qZoneAdMDPARecyclerView.setLayoutManager(linearLayoutManager);
            }
            QZoneAdMDPARecyclerView qZoneAdMDPARecyclerView2 = this.mRecyclerView;
            if (qZoneAdMDPARecyclerView2 == null) {
                return;
            }
            qZoneAdMDPARecyclerView2.setAdapter(L());
            return;
        }
        QLog.e("QZoneAdFeedMDPAPresenter", 1, "[onInitView] error, containerView is null or container isn't recyclerview");
    }
}

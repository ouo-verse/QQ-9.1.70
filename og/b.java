package og;

import android.text.TextUtils;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdTianshuFeedData;
import com.qzone.reborn.feedx.util.ad.QZoneAdFeedUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.QZoneAdExposureChecker;
import com.tencent.qphone.base.util.QLog;
import ih.f;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b0\u00101J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\t\u001a\u00020\bH\u0014J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014J\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016R\u0014\u0010\u0018\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R$\u0010 \u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010(\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010/\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.\u00a8\u00062"}, d2 = {"Log/b;", "Lvg/a;", "", "I", "", "k", "", ReportConstant.COSTREPORT_PREFIX, "", HippyTKDListViewAdapter.X, "Landroid/view/View;", "containerView", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "c", "onPaused", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "onViewHolderAttachedToWindow", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "TAG", "Lcom/tencent/mobileqq/util/QZoneAdExposureChecker;", "G", "Lcom/tencent/mobileqq/util/QZoneAdExposureChecker;", "getMAdExposureChecker", "()Lcom/tencent/mobileqq/util/QZoneAdExposureChecker;", "setMAdExposureChecker", "(Lcom/tencent/mobileqq/util/QZoneAdExposureChecker;)V", "mAdExposureChecker", "Lcom/tencent/mobileqq/util/QZoneAdExposureChecker$b;", "H", "Lcom/tencent/mobileqq/util/QZoneAdExposureChecker$b;", "getMCallBack", "()Lcom/tencent/mobileqq/util/QZoneAdExposureChecker$b;", "setMCallBack", "(Lcom/tencent/mobileqq/util/QZoneAdExposureChecker$b;)V", "mCallBack", "Lcom/qzone/proxy/feedcomponent/model/gdt/QZoneAdTianshuFeedData;", "Lcom/qzone/proxy/feedcomponent/model/gdt/QZoneAdTianshuFeedData;", "J", "()Lcom/qzone/proxy/feedcomponent/model/gdt/QZoneAdTianshuFeedData;", "setMTianShuAd", "(Lcom/qzone/proxy/feedcomponent/model/gdt/QZoneAdTianshuFeedData;)V", "mTianShuAd", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b extends vg.a {

    /* renamed from: F, reason: from kotlin metadata */
    private final String TAG = "QZoneAdTianshuFeedExposePresenter";

    /* renamed from: G, reason: from kotlin metadata */
    private QZoneAdExposureChecker mAdExposureChecker;

    /* renamed from: H, reason: from kotlin metadata */
    private QZoneAdExposureChecker.b mCallBack;

    /* renamed from: I, reason: from kotlin metadata */
    private QZoneAdTianshuFeedData mTianShuAd;

    private final void I() {
        boolean contains;
        String traceId;
        BusinessFeedData businessFeedData = this.f441565h;
        QZoneAdTianshuFeedData tianshuData = businessFeedData != null ? QZoneAdFeedDataExtKt.getTianshuData(businessFeedData) : null;
        if (TextUtils.isEmpty(tianshuData != null ? tianshuData.getTraceId() : null)) {
            return;
        }
        QZoneAdFeedUtils qZoneAdFeedUtils = QZoneAdFeedUtils.f55717a;
        contains = CollectionsKt___CollectionsKt.contains(qZoneAdFeedUtils.v(), tianshuData != null ? tianshuData.getTraceId() : null);
        if (contains) {
            GdtLog.e(this.TAG, "[doOriginalExposureReport] cancel, has exposed");
            return;
        }
        if (tianshuData != null && (traceId = tianshuData.getTraceId()) != null) {
            qZoneAdFeedUtils.v().add(traceId);
        }
        f.f407629a.i(this.mTianShuAd, 0);
    }

    @Override // vg.a
    protected void A(BusinessFeedData feedData) {
        String str;
        BusinessFeedData businessFeedData = this.f441565h;
        QZoneAdTianshuFeedData tianshuData = businessFeedData != null ? QZoneAdFeedDataExtKt.getTianshuData(businessFeedData) : null;
        if (tianshuData == null || (str = tianshuData.getTraceId()) == null) {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            QZoneAdTianshuFeedData qZoneAdTianshuFeedData = this.mTianShuAd;
            if (!Intrinsics.areEqual(qZoneAdTianshuFeedData != null ? qZoneAdTianshuFeedData.getTraceId() : null, str)) {
                this.mAdExposureChecker = new QZoneAdExposureChecker(str, new WeakReference(this.f441563e));
                this.mCallBack = new a(tianshuData, str);
                QZoneAdExposureChecker qZoneAdExposureChecker = this.mAdExposureChecker;
                if (qZoneAdExposureChecker != null) {
                    qZoneAdExposureChecker.A(new WeakReference<>(this.mCallBack));
                }
            }
        }
        this.mTianShuAd = tianshuData;
        QZoneAdExposureChecker qZoneAdExposureChecker2 = this.mAdExposureChecker;
        if (qZoneAdExposureChecker2 != null) {
            qZoneAdExposureChecker2.E();
        }
        QZoneAdFeedUtils qZoneAdFeedUtils = QZoneAdFeedUtils.f55717a;
        View mRootView = this.f441563e;
        Intrinsics.checkNotNullExpressionValue(mRootView, "mRootView");
        if (qZoneAdFeedUtils.J(mRootView, 0.01f)) {
            I();
        }
    }

    /* renamed from: J, reason: from getter */
    public final QZoneAdTianshuFeedData getMTianShuAd() {
        return this.mTianShuAd;
    }

    @Override // vg.a, vg.c
    public void c() {
        super.c();
        QZoneAdExposureChecker qZoneAdExposureChecker = this.mAdExposureChecker;
        if (qZoneAdExposureChecker != null) {
            qZoneAdExposureChecker.y();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k, reason: from getter */
    public String getTAG() {
        return this.TAG;
    }

    @Override // vg.a, vg.c
    public void onDestroy() {
        super.onDestroy();
        QZoneAdExposureChecker qZoneAdExposureChecker = this.mAdExposureChecker;
        if (qZoneAdExposureChecker != null) {
            qZoneAdExposureChecker.u();
        }
    }

    @Override // vg.a, vg.c
    public void onPaused() {
        super.onPaused();
        QZoneAdExposureChecker qZoneAdExposureChecker = this.mAdExposureChecker;
        if (qZoneAdExposureChecker != null) {
            qZoneAdExposureChecker.w();
        }
    }

    @Override // vg.a, vg.c
    public void onViewHolderAttachedToWindow(RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewHolderAttachedToWindow(holder);
        QZoneAdExposureChecker qZoneAdExposureChecker = this.mAdExposureChecker;
        if (qZoneAdExposureChecker != null) {
            qZoneAdExposureChecker.y();
        }
        I();
    }

    @Override // vg.a
    protected int s() {
        return R.id.nmu;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"og/b$a", "Lcom/tencent/mobileqq/util/QZoneAdExposureChecker$b;", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "view", "", "onExposure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class a implements QZoneAdExposureChecker.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QZoneAdTianshuFeedData f422651b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f422652c;

        a(QZoneAdTianshuFeedData qZoneAdTianshuFeedData, String str) {
            this.f422651b = qZoneAdTianshuFeedData;
            this.f422652c = str;
        }

        @Override // com.tencent.mobileqq.util.QZoneAdExposureChecker.b
        public void onExposure(WeakReference<View> view) {
            String str;
            if (view == null) {
                return;
            }
            f.f407629a.i(b.this.getMTianShuAd(), 6);
            String str2 = b.this.TAG;
            QZoneAdTianshuFeedData qZoneAdTianshuFeedData = this.f422651b;
            if (qZoneAdTianshuFeedData == null || (str = qZoneAdTianshuFeedData.getAid()) == null) {
                str = "";
            }
            QLog.e(str2, 1, "[doEffectiveExposureReport],aid:  " + str + ",traceId: " + this.f422652c);
        }
    }

    @Override // vg.a
    protected void C(View containerView) {
    }
}

package ok;

import android.app.Activity;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.album.data.model.RecomAlbumList;
import com.qzone.reborn.layer.recommendphoto.QZoneFeedxAlbumRecommendPage;
import com.qzone.reborn.layer.recommendphoto.QZoneFeedxLayerRecommendPhotoBean;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.vas.adv.common.data.AlumBasicData;
import com.tencent.mobileqq.vas.adv.common.data.VasAdvServiceCode;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a extends RecyclerView.Adapter<c> {
    protected boolean D;
    private QZoneFeedxLayerRecommendPhotoBean E;
    private b F;

    /* renamed from: m, reason: collision with root package name */
    private c f423030m;
    private AlumBasicData C = null;
    private boolean G = false;
    private boolean H = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: ok.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public class C10922a implements SDKInitListener {
        C10922a() {
        }

        @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
        public void onSDKInited(boolean z16) {
            if (QLog.isColorLevel()) {
                QLog.d("DynamicPictureAdapter", 2, "@getGdtinfo onSDKInited result:" + z16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public interface b {
        void a();
    }

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class c extends RecyclerView.ViewHolder {
        public QZoneFeedxAlbumRecommendPage E;

        public c(QZoneFeedxAlbumRecommendPage qZoneFeedxAlbumRecommendPage) {
            super(qZoneFeedxAlbumRecommendPage);
            this.E = qZoneFeedxAlbumRecommendPage;
        }
    }

    private void l0() {
        if (QQVideoPlaySDKManager.isSDKReady()) {
            return;
        }
        QQVideoPlaySDKManager.initSDKAsync(BaseApplication.getContext(), new C10922a());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        RecomAlbumList recomAlbumList;
        QZoneFeedxLayerRecommendPhotoBean qZoneFeedxLayerRecommendPhotoBean = this.E;
        return (qZoneFeedxLayerRecommendPhotoBean == null || (recomAlbumList = qZoneFeedxLayerRecommendPhotoBean.recomAlbumList) == null || !recomAlbumList.canBeShown()) ? 0 : 1;
    }

    public void i0() {
        QZoneFeedxAlbumRecommendPage qZoneFeedxAlbumRecommendPage;
        c cVar = this.f423030m;
        if (cVar != null && (qZoneFeedxAlbumRecommendPage = cVar.E) != null) {
            AlumBasicData alumBasicData = this.C;
            if (alumBasicData != null) {
                qZoneFeedxAlbumRecommendPage.g(alumBasicData);
                o0();
                RFWLog.i("QZoneFeedxLayerAlbumAdapter", RFWLog.USR, "@getGdtInfo setAdvData alumBasicData");
                return;
            } else {
                RFWLog.i("QZoneFeedxLayerAlbumAdapter", RFWLog.USR, "@getGdtInfo setAdvData hideAdvView, alumBasicData: " + this.C);
                this.f423030m.E.h();
                return;
            }
        }
        RFWLog.e("QZoneFeedxLayerAlbumAdapter", RFWLog.USR, "album view holder is null");
    }

    public void j0() {
        QZoneFeedxAlbumRecommendPage qZoneFeedxAlbumRecommendPage;
        c cVar = this.f423030m;
        if (cVar == null || (qZoneFeedxAlbumRecommendPage = cVar.E) == null) {
            return;
        }
        qZoneFeedxAlbumRecommendPage.s();
    }

    public void k0() {
        QZoneFeedxAlbumRecommendPage qZoneFeedxAlbumRecommendPage;
        c cVar = this.f423030m;
        if (cVar == null || (qZoneFeedxAlbumRecommendPage = cVar.E) == null) {
            return;
        }
        qZoneFeedxAlbumRecommendPage.u();
    }

    public boolean m0() {
        return this.D;
    }

    public void n0() {
        k0();
        this.G = false;
    }

    public void o0() {
        j0();
        this.G = true;
    }

    public void onPartDestroy(Activity activity) {
        c cVar = this.f423030m;
        if (cVar == null) {
            RFWLog.e("QZoneFeedxLayerAlbumAdapter", RFWLog.USR, "mAlbumVH is null");
        } else if (cVar.E == null) {
            RFWLog.e("QZoneFeedxLayerAlbumAdapter", RFWLog.USR, "mAlbumRecommendPage is null");
        } else {
            RFWLog.i("QZoneFeedxLayerAlbumAdapter", RFWLog.USR, "mAlbumRecommendPage is destroying");
            this.f423030m.E.t();
        }
    }

    public void onPartPause(Activity activity) {
        if (this.G) {
            k0();
        }
        if (this.H) {
            s0();
        }
    }

    public void onPartResume(Activity activity) {
        if (this.G) {
            j0();
        }
        if (this.H) {
            r0();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(c cVar, int i3) {
        QZoneFeedxAlbumRecommendPage qZoneFeedxAlbumRecommendPage;
        QZoneFeedxLayerRecommendPhotoBean qZoneFeedxLayerRecommendPhotoBean = this.E;
        if (qZoneFeedxLayerRecommendPhotoBean == null || (qZoneFeedxAlbumRecommendPage = cVar.E) == null) {
            return;
        }
        qZoneFeedxAlbumRecommendPage.f(qZoneFeedxLayerRecommendPhotoBean);
        b bVar = this.F;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(ViewGroup viewGroup, int i3) {
        QZoneFeedxAlbumRecommendPage qZoneFeedxAlbumRecommendPage = new QZoneFeedxAlbumRecommendPage(viewGroup.getContext());
        qZoneFeedxAlbumRecommendPage.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        QLog.i("QZoneFeedxLayerAlbumAdapter", 1, "onCreatezViewHolder: " + i3);
        c cVar = new c(qZoneFeedxAlbumRecommendPage);
        this.f423030m = cVar;
        return cVar;
    }

    public void r0() {
        QZoneFeedxAlbumRecommendPage qZoneFeedxAlbumRecommendPage;
        c cVar = this.f423030m;
        if (cVar == null || (qZoneFeedxAlbumRecommendPage = cVar.E) == null) {
            return;
        }
        qZoneFeedxAlbumRecommendPage.v();
    }

    public void s0() {
        QZoneFeedxAlbumRecommendPage qZoneFeedxAlbumRecommendPage;
        c cVar = this.f423030m;
        if (cVar == null || (qZoneFeedxAlbumRecommendPage = cVar.E) == null) {
            return;
        }
        qZoneFeedxAlbumRecommendPage.w();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: t0, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(c cVar) {
        super.onViewAttachedToWindow(cVar);
        this.D = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: u0, reason: merged with bridge method [inline-methods] */
    public void onViewDetachedFromWindow(c cVar) {
        super.onViewDetachedFromWindow(cVar);
        this.D = false;
    }

    public void v0(boolean z16) {
        this.H = z16;
    }

    public void w0(b bVar) {
        this.F = bVar;
    }

    public void y0(QZoneFeedxLayerRecommendPhotoBean qZoneFeedxLayerRecommendPhotoBean) {
        if (qZoneFeedxLayerRecommendPhotoBean == null || qZoneFeedxLayerRecommendPhotoBean.isDataIllegal) {
            return;
        }
        this.E = qZoneFeedxLayerRecommendPhotoBean;
    }

    public void x0(String str, AlumBasicData alumBasicData) {
        if (alumBasicData == null) {
            return;
        }
        this.C = alumBasicData;
        if (alumBasicData.retCode == VasAdvServiceCode.SUCCEED) {
            if (alumBasicData.isVideoAdvType()) {
                l0();
            }
            if (QZLog.isColorLevel()) {
                QZLog.i("DynamicPictureAdapter", "@getGdtInfo onResult url =" + this.C.advimageUrl);
            }
        }
    }
}

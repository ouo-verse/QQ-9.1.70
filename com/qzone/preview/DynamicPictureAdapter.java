package com.qzone.preview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.album.data.model.RecomAlbumExData;
import com.qzone.album.data.model.RecomAlbumList;
import com.qzone.album.ui.widget.AlbumRecomGalleryPage;
import com.qzone.album.ui.widget.a;
import com.qzone.common.account.LoginData;
import com.qzone.common.protocol.request.QZoneRequest;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.adv.common.data.AlumBasicData;
import com.tencent.mobileqq.vas.adv.common.data.VasAdvServiceCode;
import com.tencent.mobileqq.vas.adv.common.pb.vac_adv_get;
import com.tencent.mobileqq.vas.adv.qzone.api.IVasQZoneApi;
import com.tencent.mobileqq.vas.adv.qzone.callback.VasAdMetaCallback;
import com.tencent.mobileqq.vas.adv.qzone.data.VasAdMetaParam;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import java.util.List;

/* loaded from: classes39.dex */
public abstract class DynamicPictureAdapter extends com.tencent.common.galleryactivity.d {
    protected static int K = 2;
    protected static int L = 0;
    protected static int M = 1;
    private a.c D;
    private AlbumRecomGalleryPage.b H;

    /* renamed from: h, reason: collision with root package name */
    protected List<RecomAlbumExData> f49526h;

    /* renamed from: f, reason: collision with root package name */
    protected RecomAlbumList f49525f = null;

    /* renamed from: i, reason: collision with root package name */
    private List<AlbumCacheData[]> f49527i = null;

    /* renamed from: m, reason: collision with root package name */
    private int f49528m = -1;
    private Context C = null;
    private AlumBasicData E = null;
    private boolean F = false;
    private boolean G = false;
    private int I = 0;
    private VasAdMetaCallback J = new a();

    /* loaded from: classes39.dex */
    class a implements VasAdMetaCallback {
        a() {
        }

        @Override // com.tencent.mobileqq.vas.adv.qzone.callback.VasAdMetaCallback
        public void onGetAdInfoResponse(VasAdvServiceCode vasAdvServiceCode, String str, AlumBasicData alumBasicData) {
            DynamicPictureAdapter.this.E = alumBasicData;
            if (vasAdvServiceCode != VasAdvServiceCode.SUCCEED || DynamicPictureAdapter.this.E == null) {
                return;
            }
            if (DynamicPictureAdapter.this.E.isVideoAdvType()) {
                DynamicPictureAdapter.this.n();
            }
            if (QZLog.isColorLevel()) {
                QZLog.i("DynamicPictureAdapter", "@getGdtInfo onResult url =" + DynamicPictureAdapter.this.E.advimageUrl);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class b implements SDKInitListener {
        b() {
        }

        @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
        public void onSDKInited(boolean z16) {
            if (QLog.isColorLevel()) {
                QLog.d("DynamicPictureAdapter", 2, "@getGdtinfo onSDKInited result:" + z16);
            }
        }
    }

    private void k() {
        final long uin = LoginData.getInstance().getUin();
        if (QZLog.isColorLevel()) {
            QZLog.i("DynamicPictureAdapter", "getGdtInfoRequest uin= " + uin + "advType = 2");
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.qzone.preview.DynamicPictureAdapter.2
            @Override // java.lang.Runnable
            public void run() {
                vac_adv_get.QzoneBusiMsg qzoneBusiMsg = new vac_adv_get.QzoneBusiMsg();
                qzoneBusiMsg.device_info.set(QZoneRequest.getDeiviceInfoDetail(true));
                ((IVasQZoneApi) QRoute.api(IVasQZoneApi.class)).requestAdvAsync(new VasAdMetaParam(uin, 2, qzoneBusiMsg, DynamicPictureAdapter.this.I), DynamicPictureAdapter.this.J);
            }
        }, 128, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (QQVideoPlaySDKManager.isSDKReady()) {
            return;
        }
        QQVideoPlaySDKManager.initSDKAsync(BaseApplication.getContext(), new b());
    }

    private void p() {
        if (this.f49528m != -1) {
            return;
        }
        QZLog.i("DynamicPictureAdapter", "@getGdtInfo get");
        k();
        this.f49528m = 1;
    }

    @Override // com.tencent.common.galleryactivity.d, android.widget.Adapter
    public int getCount() {
        int count = super.getCount();
        RecomAlbumList recomAlbumList = this.f49525f;
        return (recomAlbumList == null || !recomAlbumList.canBeShown()) ? count : count + 1;
    }

    @Override // com.tencent.common.galleryactivity.d, android.widget.Adapter
    public Object getItem(int i3) {
        com.tencent.common.galleryactivity.e a16;
        int itemViewType = getItemViewType(i3);
        if (itemViewType != M && itemViewType == L && (a16 = a()) != null && a16.getCount() != 0 && i3 < a16.getCount() && i3 >= 0) {
            return super.getItem(i3);
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i3) {
        int count = super.getCount();
        RecomAlbumList recomAlbumList = this.f49525f;
        if (recomAlbumList == null || !recomAlbumList.canBeShown() || this.C == null) {
            return L;
        }
        if (i3 >= count && count != 0) {
            return M;
        }
        return L;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        Context context;
        int itemViewType = getItemViewType(i3);
        if (itemViewType == M) {
            if (view == null && (context = this.C) != null) {
                View inflate = LayoutInflater.from(context).inflate(R.layout.bio, (ViewGroup) null);
                c cVar = new c();
                cVar.a(inflate);
                cVar.f49532a.setRecomAlbumClickListener(this.D);
                cVar.f49532a.setRecomHasMoreClickListener(this.H);
                List<AlbumCacheData[]> list = this.f49527i;
                if (list != null) {
                    cVar.f49532a.setUpView(this.C, list.size());
                }
                inflate.setTag(cVar);
                inflate.setTag(R.layout.bio, "AlbumRecomView");
                view = inflate;
            }
            Object tag = view != null ? view.getTag() : null;
            if (tag instanceof c) {
                c cVar2 = (c) tag;
                List<AlbumCacheData[]> list2 = this.f49527i;
                if (list2 != null && list2.size() > 0) {
                    cVar2.f49532a.setData(this.f49527i, this.f49526h, this.G);
                    AlumBasicData alumBasicData = this.E;
                    if (alumBasicData != null && !this.F) {
                        cVar2.f49532a.setAdvData(alumBasicData);
                        this.F = true;
                        QZLog.i("DynamicPictureAdapter", "@getGdtInfo setAdvData alumBasicData");
                    }
                }
            }
            return view;
        }
        if (itemViewType == L) {
            try {
                return m(i3, view, viewGroup);
            } catch (Throwable th5) {
                QZLog.e("DynamicPictureAdapter", "error: ", th5);
            }
        } else {
            try {
                return m(i3, view, viewGroup);
            } catch (Throwable th6) {
                QZLog.e("DynamicPictureAdapter", "error: ", th6);
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return K;
    }

    public int l() {
        return super.getCount();
    }

    public abstract View m(int i3, View view, ViewGroup viewGroup);

    public boolean o(int i3) {
        return getItemViewType(i3) == M;
    }

    public void r(a.c cVar) {
        this.D = cVar;
    }

    public void s(AlbumRecomGalleryPage.b bVar) {
        this.H = bVar;
    }

    public void u(int i3) {
        this.I = i3;
    }

    public void t(RecomAlbumList recomAlbumList, Context context, boolean z16) {
        if (recomAlbumList == null || !recomAlbumList.canBeShown() || context == null) {
            return;
        }
        this.C = context;
        p();
        this.f49525f = recomAlbumList;
        this.f49527i = recomAlbumList.changeDataStructure(this.f49528m);
        this.f49526h = this.f49525f.getFullData();
        this.G = z16;
    }

    /* loaded from: classes39.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public AlbumRecomGalleryPage f49532a;

        public void a(View view) {
            if (view == null) {
                return;
            }
            this.f49532a = (AlbumRecomGalleryPage) view.findViewById(R.id.hcz);
        }
    }
}

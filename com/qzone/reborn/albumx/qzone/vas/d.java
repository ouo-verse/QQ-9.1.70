package com.qzone.reborn.albumx.qzone.vas;

import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.qzone.module.feedcomponent.manage.FeedManager;
import com.qzone.reborn.albumx.common.bean.CommonGridItemData;
import com.qzone.reborn.albumx.qzone.bean.init.QZoneAlbumxExpicPicInitBean;
import com.qzone.reborn.albumx.qzone.vas.b;
import com.qzone.reborn.base.n;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZonePhotoDegrade$QueryNotifyMsgRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b-\u0010.J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006J\u0006\u0010\f\u001a\u00020\u0004J\b\u0010\u000e\u001a\u00020\rH\u0016R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R-\u0010\u001b\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u00160\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00138\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001aR\u0017\u0010%\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\"\u0010,\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+\u00a8\u0006/"}, d2 = {"Lcom/qzone/reborn/albumx/qzone/vas/d;", "Lcom/qzone/reborn/base/n;", "Landroid/os/Bundle;", "bundle", "", "R1", "", "Q1", "", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "status", "S1", "T1", "", "getLogTag", "Lcom/qzone/reborn/albumx/qzone/bean/init/QZoneAlbumxExpicPicInitBean;", "i", "Lcom/qzone/reborn/albumx/qzone/bean/init/QZoneAlbumxExpicPicInitBean;", "initBean", "Landroidx/lifecycle/MutableLiveData;", "Ljava/util/ArrayList;", "Lcom/qzone/reborn/albumx/common/bean/CommonGridItemData;", "Lkotlin/collections/ArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "P1", "()Landroidx/lifecycle/MutableLiveData;", "photoList", "Lqzone/QZonePhotoDegrade$QueryNotifyMsgRsp;", BdhLogUtil.LogTag.Tag_Conn, "O1", "notifyMsgRsp", "Lcom/qzone/reborn/albumx/qzone/vas/b;", "D", "Lcom/qzone/reborn/albumx/qzone/vas/b;", "M1", "()Lcom/qzone/reborn/albumx/qzone/vas/b;", "dataRepo", "E", "Z", "N1", "()Z", "U1", "(Z)V", "hasLoadMore", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class d extends n {

    /* renamed from: D, reason: from kotlin metadata */
    private final com.qzone.reborn.albumx.qzone.vas.b dataRepo;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean hasLoadMore;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QZoneAlbumxExpicPicInitBean initBean;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<ArrayList<CommonGridItemData>> photoList = new MutableLiveData<>();

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableLiveData<QZonePhotoDegrade$QueryNotifyMsgRsp> notifyMsgRsp = new MutableLiveData<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/qzone/reborn/albumx/qzone/vas/d$a", "Lcom/qzone/reborn/albumx/qzone/vas/b$b;", "", "isSuccess", "Ljava/util/ArrayList;", "Lcom/qzone/reborn/albumx/common/bean/a;", "Lkotlin/collections/ArrayList;", "list", FeedManager.LOAD_MORE, "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class a implements b.InterfaceC0449b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.qzone.reborn.albumx.qzone.vas.b f52782b;

        a(com.qzone.reborn.albumx.qzone.vas.b bVar) {
            this.f52782b = bVar;
        }

        @Override // com.qzone.reborn.albumx.qzone.vas.b.InterfaceC0449b
        public void a(boolean isSuccess, ArrayList<com.qzone.reborn.albumx.common.bean.a> list, boolean loadMore) {
            Intrinsics.checkNotNullParameter(list, "list");
            d.this.U1(loadMore);
            if (isSuccess) {
                d.this.P1().postValue(new ArrayList<>(aa.d.f25752a.d(list)));
            }
            this.f52782b.h(false);
        }
    }

    public d() {
        com.qzone.reborn.albumx.qzone.vas.b bVar = new com.qzone.reborn.albumx.qzone.vas.b();
        bVar.e(new a(bVar));
        this.dataRepo = bVar;
    }

    /* renamed from: M1, reason: from getter */
    public final com.qzone.reborn.albumx.qzone.vas.b getDataRepo() {
        return this.dataRepo;
    }

    /* renamed from: N1, reason: from getter */
    public final boolean getHasLoadMore() {
        return this.hasLoadMore;
    }

    public final MutableLiveData<QZonePhotoDegrade$QueryNotifyMsgRsp> O1() {
        return this.notifyMsgRsp;
    }

    public final MutableLiveData<ArrayList<CommonGridItemData>> P1() {
        return this.photoList;
    }

    public final int Q1() {
        QZoneAlbumxExpicPicInitBean qZoneAlbumxExpicPicInitBean = this.initBean;
        if (qZoneAlbumxExpicPicInitBean != null) {
            return qZoneAlbumxExpicPicInitBean.getPhotoStatus();
        }
        return 0;
    }

    public final void S1(boolean isLoadMore, int status) {
        this.dataRepo.i(status);
        this.dataRepo.f(isLoadMore);
    }

    public final void T1() {
        na.c.f419539a.i(2, new b());
    }

    public final void U1(boolean z16) {
        this.hasLoadMore = z16;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneAlbumExpirePicViewModel";
    }

    public final void R1(Bundle bundle) {
        if (bundle != null) {
            Serializable serializable = bundle.getSerializable("key_bundle_common_init_bean");
            this.initBean = serializable instanceof QZoneAlbumxExpicPicInitBean ? (QZoneAlbumxExpicPicInitBean) serializable : null;
            QLog.d(getTAG(), 1, "parseIntent: " + this.initBean);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"com/qzone/reborn/albumx/qzone/vas/d$b", "Lcom/qzone/reborn/base/n$a;", "Lqzone/QZonePhotoDegrade$QueryNotifyMsgRsp;", "t", "", "retCode", "", "msg", "", "isFinish", "", "a", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements n.a<QZonePhotoDegrade$QueryNotifyMsgRsp> {
        b() {
        }

        @Override // com.qzone.reborn.base.n.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(QZonePhotoDegrade$QueryNotifyMsgRsp t16, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(t16, "t");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            d.this.O1().postValue(t16);
        }

        @Override // com.qzone.reborn.base.n.a
        public void onFailure(long errorCode, String errorMsg) {
        }
    }
}

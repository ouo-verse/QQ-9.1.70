package ni;

import android.content.Intent;
import android.text.TextUtils;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.adapter.feedcomponent.s;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.album.protocol.AbsCompatRequest;
import com.qzone.album.protocol.QZoneAlbumListRequest;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.albumx.common.convert.bean.CommonStPicSpecUrlEntry;
import com.qzone.reborn.albumx.common.convert.bean.CommonStPicUrl;
import com.qzone.reborn.albumx.common.convert.enumtype.CommonEnumPhotoSpec;
import com.qzone.reborn.albumx.common.viewmodel.l;
import com.qzone.reborn.groupalbum.reship.bean.GroupAlbumReshipSelectInitBean;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.utils.bl;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qzone.model.BusinessAlbumInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0005H\u0002J\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rJ\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0011\u001a\u00020\u0002H\u0016R$\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00128\u0006@BX\u0086.\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lni/g;", "Lcom/qzone/reborn/albumx/common/viewmodel/l;", "", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "Ljava/util/ArrayList;", "Lcooperation/qzone/model/BusinessAlbumInfo;", "Lkotlin/collections/ArrayList;", "albumList", "", "d2", "businessAlbumInfo", "Lcom/qzone/reborn/albumx/common/bean/h;", "b2", "Landroid/content/Intent;", "intent", "f2", "W1", "Q1", "Lcom/qzone/reborn/groupalbum/reship/bean/GroupAlbumReshipSelectInitBean;", "<set-?>", UserInfo.SEX_FEMALE, "Lcom/qzone/reborn/groupalbum/reship/bean/GroupAlbumReshipSelectInitBean;", "c2", "()Lcom/qzone/reborn/groupalbum/reship/bean/GroupAlbumReshipSelectInitBean;", "initBean", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class g extends l {

    /* renamed from: F, reason: from kotlin metadata */
    private GroupAlbumReshipSelectInitBean initBean;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"ni/g$a", "Lcom/qzone/album/protocol/AbsCompatRequest$b;", "Lcom/qzone/album/protocol/AbsCompatRequest;", Const.BUNDLE_KEY_REQUEST, "Lcom/qzone/adapter/feedcomponent/s;", "resultWrapper", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class a implements AbsCompatRequest.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f420192b;

        a(boolean z16) {
            this.f420192b = z16;
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.b
        public boolean a(AbsCompatRequest<?> request, s resultWrapper) {
            Intrinsics.checkNotNullParameter(request, "request");
            if (resultWrapper != null && resultWrapper.getSucceed() && (resultWrapper.getData() instanceof QZoneAlbumListRequest.a)) {
                Object data = resultWrapper.getData();
                Intrinsics.checkNotNull(data, "null cannot be cast to non-null type com.qzone.album.protocol.QZoneAlbumListRequest.RespBean");
                QZoneAlbumListRequest.a aVar = (QZoneAlbumListRequest.a) data;
                g.this.getLoadInfo().setStringAttachInfo(aVar.f43888d);
                g.this.getLoadInfo().setFinish(!aVar.f43886b);
                g gVar = g.this;
                boolean z16 = this.f420192b;
                ArrayList<AlbumCacheData> arrayList = aVar.f43887c;
                Intrinsics.checkNotNullExpressionValue(arrayList, "respBean.albumDataList");
                gVar.d2(z16, fj.e.f(arrayList));
            }
            return true;
        }
    }

    private final com.qzone.reborn.albumx.common.bean.h b2(BusinessAlbumInfo businessAlbumInfo) {
        CommonAlbumInfo commonAlbumInfo = new CommonAlbumInfo();
        String str = businessAlbumInfo.mAlbumId;
        Intrinsics.checkNotNullExpressionValue(str, "businessAlbumInfo.mAlbumId");
        commonAlbumInfo.V(str);
        String str2 = businessAlbumInfo.mTitle;
        Intrinsics.checkNotNullExpressionValue(str2, "businessAlbumInfo.mTitle");
        commonAlbumInfo.m0(str2);
        commonAlbumInfo.y0(businessAlbumInfo.mTotal);
        CommonStMedia commonStMedia = new CommonStMedia();
        CommonStPicSpecUrlEntry commonStPicSpecUrlEntry = new CommonStPicSpecUrlEntry();
        commonStPicSpecUrlEntry.c(CommonEnumPhotoSpec.PHOTO_SPEC_ORIGIN.ordinal());
        CommonStPicUrl url = commonStPicSpecUrlEntry.getUrl();
        String str3 = businessAlbumInfo.mCover;
        Intrinsics.checkNotNullExpressionValue(str3, "businessAlbumInfo.mCover");
        url.c(str3);
        commonStMedia.getImage().e().add(commonStPicSpecUrlEntry);
        commonAlbumInfo.b0(commonStMedia);
        return new com.qzone.reborn.albumx.common.bean.h(commonAlbumInfo, TextUtils.equals(commonAlbumInfo.getAlbumId(), c2().getAlbumId()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d2(final boolean isLoadMore, final ArrayList<BusinessAlbumInfo> albumList) {
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: ni.f
            @Override // java.lang.Runnable
            public final void run() {
                g.e2(g.this, albumList, isLoadMore);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e2(g this$0, ArrayList albumList, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(albumList, "$albumList");
        this$0.getLoadInfo().setCurrentState(4);
        ArrayList arrayList = new ArrayList();
        Iterator it = albumList.iterator();
        while (it.hasNext()) {
            BusinessAlbumInfo albumInfo = (BusinessAlbumInfo) it.next();
            Intrinsics.checkNotNullExpressionValue(albumInfo, "albumInfo");
            arrayList.add(this$0.b2(albumInfo));
        }
        this$0.N1().addAll(arrayList);
        if (bl.b(this$0.N1())) {
            this$0.P1().postValue(UIStateData.obtainEmpty().setLoadMore(false));
        } else {
            this$0.P1().postValue(UIStateData.obtainSuccess(false).setData(z16, this$0.N1()).setFinish(this$0.getLoadInfo().isFinish()));
        }
    }

    @Override // com.qzone.reborn.albumx.common.viewmodel.l
    public boolean Q1() {
        return false;
    }

    @Override // com.qzone.reborn.albumx.common.viewmodel.l
    protected void W1(boolean isLoadMore) {
        a aVar = new a(isLoadMore);
        if (!isLoadMore) {
            getLoadInfo().setStringAttachInfo("");
            N1().clear();
        }
        QZoneAlbumListRequest qZoneAlbumListRequest = new QZoneAlbumListRequest(LoginData.getInstance().getUin(), 2, getLoadInfo().getStringAttachInfo(), isLoadMore, null);
        qZoneAlbumListRequest.setOnJceParseListener(aVar);
        com.qzone.album.base.Service.a.W().M().c(qZoneAlbumListRequest, null);
    }

    public final GroupAlbumReshipSelectInitBean c2() {
        GroupAlbumReshipSelectInitBean groupAlbumReshipSelectInitBean = this.initBean;
        if (groupAlbumReshipSelectInitBean != null) {
            return groupAlbumReshipSelectInitBean;
        }
        Intrinsics.throwUninitializedPropertyAccessException("initBean");
        return null;
    }

    public final void f2(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Serializable serializableExtra = intent.getSerializableExtra("key_bundle_common_init_bean");
        Intrinsics.checkNotNull(serializableExtra, "null cannot be cast to non-null type com.qzone.reborn.groupalbum.reship.bean.GroupAlbumReshipSelectInitBean");
        this.initBean = (GroupAlbumReshipSelectInitBean) serializableExtra;
    }
}

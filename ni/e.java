package ni;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
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
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.util.ArrayUtils;
import cooperation.qzone.model.BusinessAlbumInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\u0015\u0018\u0000 72\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00018B\u0007\u00a2\u0006\u0004\b5\u00106J \u0010\b\u001a\u00020\u00072\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005H\u0002J \u0010\t\u001a\u00020\u00072\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016J\u000e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\rJ\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u000e\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u000bR\u001c\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001f\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\"\u0010\u000f\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000b0$8\u0006\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\"\u0010-\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010\u001f\u001a\u0004\b+\u0010!\"\u0004\b,\u0010#R\"\u00104\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103\u00a8\u00069"}, d2 = {"Lni/e;", "Lql/a;", "", "Ljava/util/ArrayList;", "Lcooperation/qzone/model/BusinessAlbumInfo;", "Lkotlin/collections/ArrayList;", "albumList", "", "X1", "R1", "businessAlbumInfo", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "Q1", "", "getLogTag", "groupId", ICustomDataEditor.STRING_ARRAY_PARAM_2, "", "M1", "albumInfo", "b2", "Landroidx/lifecycle/MutableLiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "_albumInfo", "Landroidx/lifecycle/LiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/LiveData;", "S1", "()Landroidx/lifecycle/LiveData;", "D", "Ljava/lang/String;", "W1", "()Ljava/lang/String;", "setGroupId", "(Ljava/lang/String;)V", "", "E", "Ljava/util/List;", "U1", "()Ljava/util/List;", "commonAlbumList", UserInfo.SEX_FEMALE, "T1", "c2", "attachInfo", "G", "Z", "getHasMore", "()Z", "d2", "(Z)V", "hasMore", "<init>", "()V", "H", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class e extends ql.a<Object> {

    /* renamed from: C, reason: from kotlin metadata */
    private final LiveData<CommonAlbumInfo> albumInfo;

    /* renamed from: D, reason: from kotlin metadata */
    private String groupId;

    /* renamed from: E, reason: from kotlin metadata */
    private final List<CommonAlbumInfo> commonAlbumList;

    /* renamed from: F, reason: from kotlin metadata */
    private String attachInfo;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean hasMore;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<CommonAlbumInfo> _albumInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"ni/e$b", "Lcom/qzone/album/protocol/AbsCompatRequest$b;", "Lcom/qzone/album/protocol/AbsCompatRequest;", Const.BUNDLE_KEY_REQUEST, "Lcom/qzone/adapter/feedcomponent/s;", "resultWrapper", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements AbsCompatRequest.b {
        b() {
        }

        @Override // com.qzone.album.protocol.AbsCompatRequest.b
        public boolean a(AbsCompatRequest<?> request, s resultWrapper) {
            Intrinsics.checkNotNullParameter(request, "request");
            if (resultWrapper == null || !resultWrapper.getSucceed() || !(resultWrapper.getData() instanceof QZoneAlbumListRequest.a)) {
                return true;
            }
            Object data = resultWrapper.getData();
            Intrinsics.checkNotNull(data, "null cannot be cast to non-null type com.qzone.album.protocol.QZoneAlbumListRequest.RespBean");
            QZoneAlbumListRequest.a aVar = (QZoneAlbumListRequest.a) data;
            e eVar = e.this;
            String str = aVar.f43888d;
            Intrinsics.checkNotNullExpressionValue(str, "respBean.attachInfo");
            eVar.c2(str);
            e.this.d2(aVar.f43886b);
            e eVar2 = e.this;
            ArrayList<AlbumCacheData> arrayList = aVar.f43887c;
            Intrinsics.checkNotNullExpressionValue(arrayList, "respBean.albumDataList");
            eVar2.X1(fj.e.f(arrayList));
            return true;
        }
    }

    public e() {
        MutableLiveData<CommonAlbumInfo> mutableLiveData = new MutableLiveData<>(null);
        this._albumInfo = mutableLiveData;
        this.albumInfo = mutableLiveData;
        this.groupId = "";
        this.commonAlbumList = new ArrayList();
        this.attachInfo = "";
    }

    private final CommonAlbumInfo Q1(BusinessAlbumInfo businessAlbumInfo) {
        CommonAlbumInfo commonAlbumInfo = new CommonAlbumInfo();
        String title = businessAlbumInfo.getTitle();
        Intrinsics.checkNotNullExpressionValue(title, "businessAlbumInfo.title");
        commonAlbumInfo.m0(title);
        String str = businessAlbumInfo.mAlbumId;
        Intrinsics.checkNotNullExpressionValue(str, "businessAlbumInfo.mAlbumId");
        commonAlbumInfo.V(str);
        commonAlbumInfo.y0(businessAlbumInfo.mTotal);
        CommonStMedia commonStMedia = new CommonStMedia();
        CommonStPicSpecUrlEntry commonStPicSpecUrlEntry = new CommonStPicSpecUrlEntry();
        commonStPicSpecUrlEntry.c(CommonEnumPhotoSpec.PHOTO_SPEC_ORIGIN.ordinal());
        CommonStPicUrl url = commonStPicSpecUrlEntry.getUrl();
        String str2 = businessAlbumInfo.mCover;
        Intrinsics.checkNotNullExpressionValue(str2, "businessAlbumInfo.mCover");
        url.c(str2);
        commonStMedia.getImage().e().add(commonStPicSpecUrlEntry);
        commonAlbumInfo.b0(commonStMedia);
        return commonAlbumInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X1(final ArrayList<BusinessAlbumInfo> albumList) {
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: ni.d
            @Override // java.lang.Runnable
            public final void run() {
                e.Z1(albumList, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z1(ArrayList albumList, e this$0) {
        Intrinsics.checkNotNullParameter(albumList, "$albumList");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (ArrayUtils.isOutOfArrayIndex(0, albumList)) {
            return;
        }
        this$0.R1(albumList);
        Object obj = albumList.get(0);
        Intrinsics.checkNotNullExpressionValue(obj, "albumList[0]");
        this$0._albumInfo.postValue(this$0.Q1((BusinessAlbumInfo) obj));
    }

    @Override // ql.a
    public boolean M1() {
        return this._albumInfo.getValue() != null;
    }

    public final LiveData<CommonAlbumInfo> S1() {
        return this.albumInfo;
    }

    /* renamed from: T1, reason: from getter */
    public final String getAttachInfo() {
        return this.attachInfo;
    }

    public final List<CommonAlbumInfo> U1() {
        return this.commonAlbumList;
    }

    /* renamed from: W1, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    public final void a2(String groupId) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        this.groupId = groupId;
        b bVar = new b();
        QZoneAlbumListRequest qZoneAlbumListRequest = new QZoneAlbumListRequest(LoginData.getInstance().getUin(), 2, "", false, null);
        qZoneAlbumListRequest.setOnJceParseListener(bVar);
        com.qzone.album.base.Service.a.W().M().c(qZoneAlbumListRequest, null);
    }

    public final void b2(CommonAlbumInfo albumInfo) {
        Intrinsics.checkNotNullParameter(albumInfo, "albumInfo");
        this._albumInfo.postValue(albumInfo);
    }

    public final void c2(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.attachInfo = str;
    }

    public final void d2(boolean z16) {
        this.hasMore = z16;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "GroupAlbumReshipSelectBarViewModel";
    }

    private final void R1(ArrayList<BusinessAlbumInfo> albumList) {
        if (ArrayUtils.isOutOfArrayIndex(0, albumList)) {
            return;
        }
        this.commonAlbumList.clear();
        Iterator<BusinessAlbumInfo> it = albumList.iterator();
        while (it.hasNext()) {
            BusinessAlbumInfo businessAlbumInfo = it.next();
            List<CommonAlbumInfo> list = this.commonAlbumList;
            Intrinsics.checkNotNullExpressionValue(businessAlbumInfo, "businessAlbumInfo");
            list.add(Q1(businessAlbumInfo));
        }
    }
}

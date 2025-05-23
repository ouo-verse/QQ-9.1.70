package ni;

import android.os.Handler;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.groupalbum.reship.bean.GroupAlbumReshipInitBean;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceQuoteToQzoneCallback;
import com.tencent.qqnt.kernel.nativeinterface.NTQuoteToQzoneReq;
import com.tencent.qqnt.kernel.nativeinterface.NTQuoteToQzoneRsp;
import com.tencent.qqnt.kernel.nativeinterface.RequestTimelineInfo;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.ArrayUtils;
import cooperation.qzone.QzoneIPCModule;
import fj.r;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ni.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 C2\u00020\u0001:\u0001DB\u0007\u00a2\u0006\u0004\bA\u0010BJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\b\u0010\u0011\u001a\u00020\u0010H\u0016R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u001e\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\"\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u0019\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR\"\u0010*\u001a\u00020#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R(\u00103\u001a\b\u0012\u0004\u0012\u00020,0+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R.\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0+048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R(\u0010@\u001a\b\u0012\u0004\u0012\u00020<048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u00106\u001a\u0004\b>\u00108\"\u0004\b?\u0010:\u00a8\u0006E"}, d2 = {"Lni/h;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "Lcom/qzone/reborn/groupalbum/reship/bean/GroupAlbumReshipInitBean;", "initBean", "", "R1", "Lcom/qzone/reborn/part/publish/common/inputarea/d;", "inputAreaVm", "Lni/e;", "selectAlbumBarVm", "Ltl/h;", "mediaPickerVm", "M1", "", QzoneIPCModule.RESULT_CODE, "L1", "", "getLogTag", "i", "Lcom/qzone/reborn/groupalbum/reship/bean/GroupAlbumReshipInitBean;", "N1", "()Lcom/qzone/reborn/groupalbum/reship/bean/GroupAlbumReshipInitBean;", "setInitBean", "(Lcom/qzone/reborn/groupalbum/reship/bean/GroupAlbumReshipInitBean;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "getDestAlbumId", "()Ljava/lang/String;", "setDestAlbumId", "(Ljava/lang/String;)V", "destAlbumId", BdhLogUtil.LogTag.Tag_Conn, "getDestDesc", "setDestDesc", "destDesc", "", "D", "J", "getDestBatchId", "()J", "setDestBatchId", "(J)V", "destBatchId", "", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", "E", "Ljava/util/List;", "O1", "()Ljava/util/List;", "setMediaList", "(Ljava/util/List;)V", "mediaList", "Landroidx/lifecycle/MutableLiveData;", UserInfo.SEX_FEMALE, "Landroidx/lifecycle/MutableLiveData;", "P1", "()Landroidx/lifecycle/MutableLiveData;", "setMediaListData", "(Landroidx/lifecycle/MutableLiveData;)V", "mediaListData", "", "G", "Q1", "setUploadState", "uploadState", "<init>", "()V", "H", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class h extends BaseViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private String destDesc;

    /* renamed from: D, reason: from kotlin metadata */
    private long destBatchId;

    /* renamed from: E, reason: from kotlin metadata */
    private List<CommonStMedia> mediaList = new ArrayList();

    /* renamed from: F, reason: from kotlin metadata */
    private MutableLiveData<List<CommonStMedia>> mediaListData = new MutableLiveData<>();

    /* renamed from: G, reason: from kotlin metadata */
    private MutableLiveData<Boolean> uploadState = new MutableLiveData<>(Boolean.FALSE);

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private GroupAlbumReshipInitBean initBean;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String destAlbumId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"ni/h$b", "Lcom/tencent/qqnt/kernel/nativeinterface/IAlbumServiceQuoteToQzoneCallback;", "Lcom/tencent/qqnt/kernel/nativeinterface/NTQuoteToQzoneRsp;", "response", "", "onQuoteToQzone", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements IAlbumServiceQuoteToQzoneCallback {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(h this$0, NTQuoteToQzoneRsp response) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(response, "$response");
            this$0.Q1().postValue(Boolean.valueOf(response.result == 0));
            if (response.result != 0) {
                QLog.e("GroupAlbumReshipViewModel", 1, "errMsg is " + response.errMs + " traceID:" + response.traceId);
            }
            this$0.L1(response.result);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceQuoteToQzoneCallback
        public void onQuoteToQzone(final NTQuoteToQzoneRsp response) {
            Intrinsics.checkNotNullParameter(response, "response");
            Handler uIHandler = RFWThreadManager.getUIHandler();
            final h hVar = h.this;
            uIHandler.post(new Runnable() { // from class: ni.i
                @Override // java.lang.Runnable
                public final void run() {
                    h.b.b(h.this, response);
                }
            });
        }
    }

    public final void L1(int resultCode) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("quote_success", Integer.valueOf(resultCode == 0 ? 1 : 0));
        linkedHashMap.put("fail_error_code", Integer.valueOf(resultCode));
        fo.c.c("ev_qun_album_on_quote_to_qzone", linkedHashMap);
    }

    public final void M1(com.qzone.reborn.part.publish.common.inputarea.d inputAreaVm, e selectAlbumBarVm, tl.h mediaPickerVm) {
        Intrinsics.checkNotNullParameter(inputAreaVm, "inputAreaVm");
        Intrinsics.checkNotNullParameter(selectAlbumBarVm, "selectAlbumBarVm");
        Intrinsics.checkNotNullParameter(mediaPickerVm, "mediaPickerVm");
        GroupAlbumReshipInitBean groupAlbumReshipInitBean = this.initBean;
        if (groupAlbumReshipInitBean == null) {
            return;
        }
        Intrinsics.checkNotNull(groupAlbumReshipInitBean);
        if (ArrayUtils.isOutOfArrayIndex(0, groupAlbumReshipInitBean.getMediaList())) {
            return;
        }
        CommonAlbumInfo value = selectAlbumBarVm.S1().getValue();
        this.destAlbumId = value != null ? value.getAlbumId() : null;
        this.destDesc = inputAreaVm.U1();
        this.destBatchId = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (CommonStMedia commonStMedia : this.mediaList) {
            GroupAlbumReshipInitBean groupAlbumReshipInitBean2 = this.initBean;
            Intrinsics.checkNotNull(groupAlbumReshipInitBean2);
            if (!groupAlbumReshipInitBean2.isReshipBySourceBatchId()) {
                arrayList.add(commonStMedia.m());
            }
            arrayList2.add(commonStMedia.l());
        }
        b bVar = new b();
        RequestTimelineInfo requestTimelineInfo = new RequestTimelineInfo();
        GroupAlbumReshipInitBean groupAlbumReshipInitBean3 = this.initBean;
        Intrinsics.checkNotNull(groupAlbumReshipInitBean3);
        String groupId = groupAlbumReshipInitBean3.getGroupId();
        GroupAlbumReshipInitBean groupAlbumReshipInitBean4 = this.initBean;
        Intrinsics.checkNotNull(groupAlbumReshipInitBean4);
        CommonAlbumInfo albumInfo = groupAlbumReshipInitBean4.getAlbumInfo();
        String albumId = albumInfo != null ? albumInfo.getAlbumId() : null;
        String str = this.destAlbumId;
        String str2 = this.destDesc;
        long j3 = this.destBatchId;
        GroupAlbumReshipInitBean groupAlbumReshipInitBean5 = this.initBean;
        Intrinsics.checkNotNull(groupAlbumReshipInitBean5);
        NTQuoteToQzoneReq nTQuoteToQzoneReq = new NTQuoteToQzoneReq(0, requestTimelineInfo, groupId, albumId, arrayList, str, str2, j3, groupAlbumReshipInitBean5.getSourceBatchId());
        com.tencent.qqnt.kernel.api.g b16 = r.b();
        if (b16 != null) {
            b16.quoteToQzone(nTQuoteToQzoneReq, bVar);
        }
    }

    /* renamed from: N1, reason: from getter */
    public final GroupAlbumReshipInitBean getInitBean() {
        return this.initBean;
    }

    public final List<CommonStMedia> O1() {
        return this.mediaList;
    }

    public final MutableLiveData<List<CommonStMedia>> P1() {
        return this.mediaListData;
    }

    public final MutableLiveData<Boolean> Q1() {
        return this.uploadState;
    }

    public final void R1(GroupAlbumReshipInitBean initBean) {
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        this.initBean = initBean;
        List<CommonStMedia> mediaList = initBean.getMediaList();
        this.mediaList = mediaList;
        this.mediaListData.postValue(mediaList);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "GroupAlbumReshipViewModel";
    }
}

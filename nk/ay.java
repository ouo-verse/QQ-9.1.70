package nk;

import android.app.Activity;
import android.content.DialogInterface;
import androidx.lifecycle.MutableLiveData;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.base.n;
import com.qzone.util.ToastUtil;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b7\u00108J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J6\u0010\u000e\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0002H\u0002J\u001a\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0002J\u001a\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0002J\b\u0010\u0017\u001a\u00020\u000bH\u0016J\u0006\u0010\u0018\u001a\u00020\u0004J\u0006\u0010\u0019\u001a\u00020\u0004J\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0007J\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cR\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R4\u0010*\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060#0\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u00102\u001a\u00020+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R(\u00106\u001a\b\u0012\u0004\u0012\u00020\u001c0\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010%\u001a\u0004\b4\u0010'\"\u0004\b5\u0010)\u00a8\u00069"}, d2 = {"Lnk/ay;", "Lcom/qzone/reborn/base/n;", "", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "", "S1", "", "Lcom/qzone/reborn/message/data/a;", "list", "", "retCode", "", "errMsg", "isFinish", "Z1", "errorCode", "errorMsg", "X1", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "messageBean", "R1", "c2", "getLogTag", "d2", ICustomDataEditor.STRING_ARRAY_PARAM_2, "P1", "b2", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "T1", "", "i", "Ljava/util/List;", "mAllMessage", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "W1", "()Landroidx/lifecycle/MutableLiveData;", "setMMessageListData", "(Landroidx/lifecycle/MutableLiveData;)V", "mMessageListData", "Lbk/m;", BdhLogUtil.LogTag.Tag_Conn, "Lbk/m;", "getMMessageRepo", "()Lbk/m;", "setMMessageRepo", "(Lbk/m;)V", "mMessageRepo", "D", "U1", "setMClickFeedData", "mClickFeedData", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public class ay extends com.qzone.reborn.base.n {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private List<com.qzone.reborn.message.data.a> mAllMessage = new ArrayList();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private MutableLiveData<UIStateData<List<com.qzone.reborn.message.data.a>>> mMessageListData = new MutableLiveData<>();

    /* renamed from: C, reason: from kotlin metadata */
    private bk.m mMessageRepo = new bk.m();

    /* renamed from: D, reason: from kotlin metadata */
    private MutableLiveData<BusinessFeedData> mClickFeedData = new MutableLiveData<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J.\u0010\f\u001a\u00020\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u001a\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u0010"}, d2 = {"nk/ay$b", "Lcom/qzone/reborn/base/n$a;", "", "Lcom/qzone/reborn/message/data/a;", "list", "", "retCode", "", "msg", "", "isFinish", "", "a", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements n.a<List<? extends com.qzone.reborn.message.data.a>> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f420328a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ay f420329b;

        b(boolean z16, ay ayVar) {
            this.f420328a = z16;
            this.f420329b = ayVar;
        }

        @Override // com.qzone.reborn.base.n.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(List<com.qzone.reborn.message.data.a> list, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(list, "list");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (!this.f420328a) {
                dh.d.f393812a.a();
            }
            this.f420329b.Z1(list, this.f420328a, retCode, msg2, isFinish);
        }

        @Override // com.qzone.reborn.base.n.a
        public void onFailure(long errorCode, String errorMsg) {
            this.f420329b.X1(errorCode, errorMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q1(ay this$0, Activity activity, com.qzone.reborn.message.data.a aVar, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        this$0.R1(activity, aVar);
    }

    private final void S1(boolean isLoadMore) {
        this.mMessageRepo.e(this.contextHashCode, isLoadMore, new b(isLoadMore, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X1(long errorCode, String errorMsg) {
        this.mMessageListData.postValue(UIStateData.obtainError(errorMsg).setRetCode(errorCode).setLoadMore(false));
    }

    private final void c2() {
        RFWLog.d(getTAG(), RFWLog.USR, "refreshAdapter");
        UIStateData<List<com.qzone.reborn.message.data.a>> value = this.mMessageListData.getValue();
        if (value != null) {
            if (!this.mAllMessage.isEmpty()) {
                if (value.getState() == 0) {
                    RFWLog.d(getTAG(), RFWLog.USR, "refreshAdapter set to succeed");
                    value.setState(2);
                } else {
                    RFWLog.d(getTAG(), RFWLog.USR, "refreshAdapter set to modify");
                    value.setState(7);
                }
            } else {
                RFWLog.d(getTAG(), RFWLog.USR, "refreshAdapter set to empty");
                value.setState(0);
            }
            value.setDataList(this.mAllMessage);
        }
        this.mMessageListData.postValue(value);
    }

    public final void P1(final Activity activity, final com.qzone.reborn.message.data.a messageBean) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        new com.qzone.component.e().g(activity, com.qzone.util.l.a(R.string.w97), com.qzone.util.l.a(R.string.w95), new DialogInterface.OnClickListener() { // from class: nk.ax
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ay.Q1(ay.this, activity, messageBean, dialogInterface, i3);
            }
        }, null);
    }

    public final BusinessFeedData T1() {
        return this.mClickFeedData.getValue();
    }

    public final MutableLiveData<BusinessFeedData> U1() {
        return this.mClickFeedData;
    }

    public final MutableLiveData<UIStateData<List<com.qzone.reborn.message.data.a>>> W1() {
        return this.mMessageListData;
    }

    public final void b2(com.qzone.reborn.message.data.a messageBean) {
        Intrinsics.checkNotNullParameter(messageBean, "messageBean");
        this.mAllMessage.remove(messageBean);
        c2();
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneIntimateMessageViewModel";
    }

    public final void a2() {
        S1(true);
    }

    public final void d2() {
        S1(false);
    }

    private final void R1(Activity activity, com.qzone.reborn.message.data.a messageBean) {
        if (messageBean == null) {
            RFWLog.e(getTAG(), RFWLog.USR, "messageBean is null");
            return;
        }
        if (!NetworkUtil.isNetSupport(activity)) {
            com.qzone.reborn.util.o.f59556a.b(com.qzone.reborn.configx.g.f53821a.m().k());
            return;
        }
        bk.m mVar = this.mMessageRepo;
        int i3 = this.contextHashCode;
        String str = messageBean.getStNotice().notice_id.get();
        Intrinsics.checkNotNullExpressionValue(str, "messageBean.stNotice.notice_id.get()");
        mVar.c(i3, str, new a(messageBean));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z1(List<com.qzone.reborn.message.data.a> list, boolean isLoadMore, long retCode, String errMsg, boolean isFinish) {
        UIStateData.ModifyListRecord obtainNotifyDataSetChanged;
        if (!isLoadMore) {
            this.mAllMessage.clear();
        }
        int size = this.mAllMessage.size();
        this.mAllMessage.addAll(list);
        if (bl.b(this.mAllMessage)) {
            this.mMessageListData.postValue(UIStateData.obtainEmpty().setRetCode(retCode).setLoadMore(isLoadMore));
            return;
        }
        if (isLoadMore) {
            obtainNotifyDataSetChanged = UIStateData.ModifyListRecord.obtainNotifyItemRangeInsert(size, list.size());
        } else {
            obtainNotifyDataSetChanged = UIStateData.ModifyListRecord.obtainNotifyDataSetChanged();
        }
        this.mMessageListData.postValue(UIStateData.obtainSuccess(VSNetworkHelper.isProtocolCache(errMsg)).setData(isLoadMore, this.mAllMessage).setLatestModifyRecord(obtainNotifyDataSetChanged).setFinish(isFinish));
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J*\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"nk/ay$a", "Lcom/qzone/reborn/base/n$a;", "", "cellFeedCommInfo", "", "retCode", "", "msg", "", "isFinish", "", "onSuccess", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class a implements n.a<Object> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.qzone.reborn.message.data.a f420327b;

        a(com.qzone.reborn.message.data.a aVar) {
            this.f420327b = aVar;
        }

        @Override // com.qzone.reborn.base.n.a
        public void onSuccess(Object cellFeedCommInfo, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            ay.this.b2(this.f420327b);
            ToastUtil.o(R.string.f169559w93, 0);
        }

        @Override // com.qzone.reborn.base.n.a
        public void onFailure(long errorCode, String errorMsg) {
            ToastUtil.o(R.string.f169558w92, 1);
        }
    }
}

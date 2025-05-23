package nk;

import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.qzone.reborn.base.n;
import com.qzone.reborn.intimate.bean.QZoneAlbumInfoBean;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.bl;
import com.tencent.richframework.data.base.UIStateData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b/\u00100J(\u0010\t\u001a\u00020\b2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0006\u0010\u0010\u001a\u00020\bJ\u0006\u0010\u0011\u001a\u00020\bR\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR(\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R4\u0010.\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001e0'0&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-\u00a8\u00061"}, d2 = {"Lnk/r;", "Lcom/qzone/reborn/base/n;", "Ljava/util/ArrayList;", "Lcom/qzone/reborn/intimate/bean/QZoneAlbumInfoBean;", "Lkotlin/collections/ArrayList;", "data", "", "msg", "", "R1", "errMsg", "Q1", "getLogTag", "Landroid/content/Intent;", "intent", "S1", "U1", "T1", "", "i", "J", "getMUin", "()J", "setMUin", "(J)V", "mUin", "Lbk/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lbk/c;", "mAlbumTabServerRepo", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "P1", "()Ljava/util/List;", "setMAllAlbumList", "(Ljava/util/List;)V", "mAllAlbumList", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", "D", "Landroidx/lifecycle/MutableLiveData;", "O1", "()Landroidx/lifecycle/MutableLiveData;", "setMAlbumData", "(Landroidx/lifecycle/MutableLiveData;)V", "mAlbumData", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class r extends com.qzone.reborn.base.n {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long mUin;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private bk.c mAlbumTabServerRepo = new bk.c();

    /* renamed from: C, reason: from kotlin metadata */
    private List<QZoneAlbumInfoBean> mAllAlbumList = new ArrayList();

    /* renamed from: D, reason: from kotlin metadata */
    private MutableLiveData<UIStateData<List<QZoneAlbumInfoBean>>> mAlbumData = new MutableLiveData<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00040\u0001J8\u0010\r\u001a\u00020\f2\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u001a\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u0011"}, d2 = {"nk/r$a", "Lcom/qzone/reborn/base/n$a;", "Ljava/util/ArrayList;", "Lcom/qzone/reborn/intimate/bean/QZoneAlbumInfoBean;", "Lkotlin/collections/ArrayList;", "data", "", "retCode", "", "msg", "", "isFinish", "", "a", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class a implements n.a<ArrayList<QZoneAlbumInfoBean>> {
        a() {
        }

        @Override // com.qzone.reborn.base.n.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(ArrayList<QZoneAlbumInfoBean> data, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            r.this.R1(data, msg2);
        }

        @Override // com.qzone.reborn.base.n.a
        public void onFailure(long errorCode, String errorMsg) {
            r.this.Q1(errorMsg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q1(String errMsg) {
        RFWLog.d(getTAG(), RFWLog.USR, "[onRequestFail] errMsg " + errMsg);
        this.mAlbumData.postValue(UIStateData.obtainError(errMsg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R1(ArrayList<QZoneAlbumInfoBean> data, String msg2) {
        RFWLog.d(getTAG(), RFWLog.USR, "[onRequestSuccess] data.size=" + data.size() + " msg:" + msg2);
        this.mAllAlbumList.clear();
        Iterator<QZoneAlbumInfoBean> it = data.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "data.iterator()");
        while (it.hasNext()) {
            QZoneAlbumInfoBean next = it.next();
            next.setOwnerUin(this.mUin);
            if (next.getAlbumInfo().album_list.album_list.get().isEmpty()) {
                it.remove();
            }
        }
        this.mAllAlbumList.addAll(data);
        if (bl.b(this.mAllAlbumList)) {
            this.mAlbumData.postValue(UIStateData.obtainEmpty());
        } else {
            this.mAlbumData.postValue(UIStateData.obtainSuccess(VSNetworkHelper.isProtocolCache(msg2)).setDataList(this.mAllAlbumList).setFinish(true));
        }
    }

    public final MutableLiveData<UIStateData<List<QZoneAlbumInfoBean>>> O1() {
        return this.mAlbumData;
    }

    public final List<QZoneAlbumInfoBean> P1() {
        return this.mAllAlbumList;
    }

    public final void T1() {
        RFWLog.d(getTAG(), RFWLog.USR, "refreshAdapter");
        UIStateData<List<QZoneAlbumInfoBean>> value = this.mAlbumData.getValue();
        if (value != null) {
            if (!this.mAllAlbumList.isEmpty()) {
                RFWLog.d(getTAG(), RFWLog.USR, "refreshAdapter set to succeed");
                value.setState(2);
            } else {
                RFWLog.d(getTAG(), RFWLog.USR, "refreshAdapter set to empty");
                value.setState(0);
            }
            value.setDataList(this.mAllAlbumList);
        }
        this.mAlbumData.postValue(value);
    }

    public final void U1() {
        this.mAlbumTabServerRepo.c(this.contextHashCode, this.mUin, new a());
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneIntimateAlbumTabViewModel";
    }

    public final void S1(Intent intent) {
        Bundle extras;
        if (intent == null || (extras = intent.getExtras()) == null) {
            return;
        }
        this.mUin = extras.getLong("key_album_owner_uin", 0L);
    }
}

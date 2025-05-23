package com.qzone.reborn.groupalbum.viewmodel;

import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.qzone.reborn.base.n;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumNoticeInitBean;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqnt.kernel.nativeinterface.Notice;
import com.tencent.qqnt.kernel.nativeinterface.StCommonExt;
import com.tencent.richframework.data.base.UIStateData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000 92\u00020\u0001:\u0001:B\u0007\u00a2\u0006\u0004\b7\u00108J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J6\u0010\u000f\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\u000e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0014\u001a\u00020\u0006J\u0006\u0010\u0015\u001a\u00020\u0006R\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR(\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R4\u0010.\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\b0'0&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u00106\u001a\u00020/8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105\u00a8\u0006;"}, d2 = {"Lcom/qzone/reborn/groupalbum/viewmodel/am;", "Lcom/qzone/reborn/base/n;", "", "errorMsg", "", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "", "T1", "", "Lcom/tencent/qqnt/kernel/nativeinterface/Notice;", "list", "", "retCode", "errMsg", "isFinish", "U1", "getLogTag", "Landroid/content/Intent;", "intent", "O1", "P1", "S1", "i", "Ljava/lang/String;", "Q1", "()Ljava/lang/String;", "setGroupId", "(Ljava/lang/String;)V", "groupId", "", "Lkl/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "getMAllNotice", "()Ljava/util/List;", "setMAllNotice", "(Ljava/util/List;)V", "mAllNotice", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "R1", "()Landroidx/lifecycle/MutableLiveData;", "setMNoticeStateData", "(Landroidx/lifecycle/MutableLiveData;)V", "mNoticeStateData", "Lki/ad;", "D", "Lki/ad;", "getMNoticeDataRepo", "()Lki/ad;", "setMNoticeDataRepo", "(Lki/ad;)V", "mNoticeDataRepo", "<init>", "()V", "E", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class am extends com.qzone.reborn.base.n {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String groupId = "";

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private List<kl.a> mAllNotice = new ArrayList();

    /* renamed from: C, reason: from kotlin metadata */
    private MutableLiveData<UIStateData<List<kl.a>>> mNoticeStateData = new MutableLiveData<>();

    /* renamed from: D, reason: from kotlin metadata */
    private ki.ad mNoticeDataRepo = new ki.ad();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J.\u0010\f\u001a\u00020\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u001a\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u0010"}, d2 = {"com/qzone/reborn/groupalbum/viewmodel/am$b", "Lcom/qzone/reborn/base/n$a;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/Notice;", "list", "", "retCode", "", "msg", "", "isFinish", "", "a", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b implements n.a<List<? extends Notice>> {
        b() {
        }

        @Override // com.qzone.reborn.base.n.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(List<Notice> list, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(list, "list");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            am.this.U1(list, false, retCode, msg2, isFinish);
        }

        @Override // com.qzone.reborn.base.n.a
        public void onFailure(long errorCode, String errorMsg) {
            am.this.T1(errorMsg, false);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J.\u0010\f\u001a\u00020\u000b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u001a\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u0010"}, d2 = {"com/qzone/reborn/groupalbum/viewmodel/am$c", "Lcom/qzone/reborn/base/n$a;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/Notice;", "list", "", "retCode", "", "msg", "", "isFinish", "", "a", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class c implements n.a<List<? extends Notice>> {
        c() {
        }

        @Override // com.qzone.reborn.base.n.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(List<Notice> list, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(list, "list");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            am.this.U1(list, true, retCode, msg2, isFinish);
        }

        @Override // com.qzone.reborn.base.n.a
        public void onFailure(long errorCode, String errorMsg) {
            am.this.T1(errorMsg, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T1(String errorMsg, boolean isLoadMore) {
        this.mNoticeStateData.postValue(UIStateData.obtainError(errorMsg).setRetCode(0L).setLoadMore(isLoadMore));
    }

    public final void O1(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Bundle extras = intent.getExtras();
        if (extras != null && extras.containsKey("key_bundle_common_init_bean")) {
            Serializable serializable = extras.getSerializable("key_bundle_common_init_bean");
            Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.qzone.reborn.groupalbum.bean.init.GroupAlbumNoticeInitBean");
            this.groupId = ((GroupAlbumNoticeInitBean) serializable).getGroupId();
        }
        RFWLog.d("GroupAlbumFeedViewModel", RFWLog.USR, "[doInit] groupId:" + this.groupId);
    }

    public final void P1() {
        this.mNoticeDataRepo.h(this.contextHashCode, this.groupId, new b());
    }

    /* renamed from: Q1, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    public final MutableLiveData<UIStateData<List<kl.a>>> R1() {
        return this.mNoticeStateData;
    }

    public final void S1() {
        this.mNoticeDataRepo.g(this.contextHashCode, this.groupId, new c());
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "GroupAlbumFeedViewModel";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U1(List<Notice> list, boolean isLoadMore, long retCode, String errMsg, boolean isFinish) {
        int collectionSizeOrDefault;
        UIStateData.ModifyListRecord obtainNotifyDataSetChanged;
        if (!isLoadMore) {
            this.mAllNotice.clear();
        }
        List<kl.a> list2 = this.mAllNotice;
        List<Notice> list3 = list;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list3.iterator();
        while (it.hasNext()) {
            arrayList.add(new kl.a((Notice) it.next(), new StCommonExt()));
        }
        list2.addAll(arrayList);
        int size = this.mAllNotice.size();
        if (isLoadMore) {
            obtainNotifyDataSetChanged = UIStateData.ModifyListRecord.obtainNotifyItemRangeInsert(size, 0);
        } else {
            obtainNotifyDataSetChanged = UIStateData.ModifyListRecord.obtainNotifyDataSetChanged();
        }
        this.mNoticeStateData.postValue(UIStateData.obtainSuccess(VSNetworkHelper.isProtocolCache(errMsg)).setData(isLoadMore, this.mAllNotice).setLatestModifyRecord(obtainNotifyDataSetChanged).setFinish(isFinish));
    }
}

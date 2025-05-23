package com.qzone.reborn.groupalbum.viewmodel;

import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumInitBean;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qqnt.kernel.nativeinterface.GetAllAlbumListItem;
import com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceGetAllAlbumListCallback;
import com.tencent.qqnt.kernel.nativeinterface.NTGetAllAlbumListRsp;
import com.tencent.richframework.data.base.UIStateData;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0016\u0018\u0000 72\u00020\u0001:\u00018B\u0007\u00a2\u0006\u0004\b5\u00106J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J:\u0010\u000f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u00042\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rH\u0002J\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\u000e\u0010\u0014\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004J\b\u0010\u0015\u001a\u00020\u0006H\u0016R\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001bR\"\u0010&\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R3\u0010-\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r0(0'8\u0006\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R2\u00104\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103\u00a8\u00069"}, d2 = {"Lcom/qzone/reborn/groupalbum/viewmodel/al;", "Lcom/qzone/reborn/base/n;", "", "errorMsg", "", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "", "T1", "isGetMore", "attachInfo", "hasMore", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/GetAllAlbumListItem;", "Lkotlin/collections/ArrayList;", "qunList", "S1", "Landroid/content/Intent;", "intent", "N1", "getLogTag", "O1", "L1", "i", "Ljava/lang/String;", "getGroupId", "()Ljava/lang/String;", "setGroupId", "(Ljava/lang/String;)V", "groupId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getAttachInfo", "setAttachInfo", BdhLogUtil.LogTag.Tag_Conn, "Z", "getAllAlbumHasMore", "()Z", "setAllAlbumHasMore", "(Z)V", "allAlbumHasMore", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", "D", "Landroidx/lifecycle/MutableLiveData;", "Q1", "()Landroidx/lifecycle/MutableLiveData;", "mAllAlbumList", "E", "Ljava/util/ArrayList;", "R1", "()Ljava/util/ArrayList;", "setMAllAlbums", "(Ljava/util/ArrayList;)V", "mAllAlbums", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class al extends com.qzone.reborn.base.n {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean allAlbumHasMore;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String attachInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String groupId = "";

    /* renamed from: D, reason: from kotlin metadata */
    private final MutableLiveData<UIStateData<ArrayList<GetAllAlbumListItem>>> mAllAlbumList = new MutableLiveData<>();

    /* renamed from: E, reason: from kotlin metadata */
    private ArrayList<GetAllAlbumListItem> mAllAlbums = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P1(al this$0, boolean z16, NTGetAllAlbumListRsp nTGetAllAlbumListRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RFWLog.d("GroupAlbumMyAlbumViewModel", RFWLog.USR, "get all album list is " + nTGetAllAlbumListRsp.traceId);
        if (nTGetAllAlbumListRsp.result == 0) {
            String str = nTGetAllAlbumListRsp.attachInfo;
            boolean z17 = nTGetAllAlbumListRsp.hasMore;
            ArrayList<GetAllAlbumListItem> arrayList = nTGetAllAlbumListRsp.qunList;
            Intrinsics.checkNotNullExpressionValue(arrayList, "response.qunList");
            this$0.S1(z16, str, z17, arrayList);
            return;
        }
        this$0.T1(nTGetAllAlbumListRsp.errMs, z16);
        RFWLog.e("GroupAlbumMyAlbumViewModel", RFWLog.USR, "get all album list error, error msg is " + nTGetAllAlbumListRsp.errMs + ", error seq is " + nTGetAllAlbumListRsp.seq);
    }

    private final void S1(boolean isGetMore, String attachInfo, boolean hasMore, ArrayList<GetAllAlbumListItem> qunList) {
        UIStateData.ModifyListRecord obtainNotifyDataSetChanged;
        this.attachInfo = attachInfo;
        this.allAlbumHasMore = hasMore;
        if (!isGetMore) {
            this.mAllAlbums.clear();
        }
        this.mAllAlbums.addAll(qunList);
        int size = this.mAllAlbums.size();
        if (isGetMore) {
            obtainNotifyDataSetChanged = UIStateData.ModifyListRecord.obtainNotifyItemRangeInsert(size, 0);
        } else {
            obtainNotifyDataSetChanged = UIStateData.ModifyListRecord.obtainNotifyDataSetChanged();
        }
        this.mAllAlbumList.postValue(UIStateData.obtainSuccess(false).setDataList(this.mAllAlbums).setLatestModifyRecord(obtainNotifyDataSetChanged).setLoadMore(hasMore).setFinish(!hasMore));
    }

    private final void T1(String errorMsg, boolean isLoadMore) {
        this.mAllAlbumList.postValue(UIStateData.obtainError(errorMsg).setRetCode(0L).setLoadMore(isLoadMore));
    }

    public final void N1(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Bundle extras = intent.getExtras();
        if (extras != null && extras.containsKey("key_bundle_common_init_bean")) {
            Serializable serializable = extras.getSerializable("key_bundle_common_init_bean");
            if (serializable instanceof GroupAlbumInitBean) {
                this.groupId = ((GroupAlbumInitBean) serializable).getGroupId();
            }
        }
        RFWLog.d("GroupAlbumMyAlbumViewModel", RFWLog.USR, "[doInit] groupId:" + this.groupId);
    }

    public final MutableLiveData<UIStateData<ArrayList<GetAllAlbumListItem>>> Q1() {
        return this.mAllAlbumList;
    }

    public final ArrayList<GetAllAlbumListItem> R1() {
        return this.mAllAlbums;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "GroupAlbumMyAlbumViewModel";
    }

    @Override // com.qzone.reborn.base.n
    public void L1() {
        this.attachInfo = null;
        this.allAlbumHasMore = false;
        this.mAllAlbums.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x001c, code lost:
    
        if ((r1 == null || r1.length() == 0) != false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void O1(final boolean isGetMore) {
        if (!isGetMore) {
            this.attachInfo = null;
            this.allAlbumHasMore = false;
        } else {
            if (this.allAlbumHasMore) {
                String str = this.attachInfo;
            }
            RFWLog.d("GroupAlbumMyAlbumViewModel", RFWLog.USR, "get all album more error ");
            return;
        }
        if (!NetworkUtil.isNetworkAvailable()) {
            T1("\u65e0\u7f51\u7edc", isGetMore);
        } else {
            ki.a.f412421a.a(this.attachInfo, new IAlbumServiceGetAllAlbumListCallback() { // from class: com.qzone.reborn.groupalbum.viewmodel.ak
                @Override // com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceGetAllAlbumListCallback
                public final void onGetAllAlbumList(NTGetAllAlbumListRsp nTGetAllAlbumListRsp) {
                    al.P1(al.this, isGetMore, nTGetAllAlbumListRsp);
                }
            });
        }
    }
}

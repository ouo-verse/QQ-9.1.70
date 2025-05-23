package ii;

import android.text.TextUtils;
import ci.h;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.qqnt.kernel.nativeinterface.AlbumInfo;
import com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceGetMediaListCallback;
import com.tencent.qqnt.kernel.nativeinterface.MediaListInfo;
import com.tencent.qqnt.kernel.nativeinterface.NTGetMediaListRsp;
import com.tencent.qqnt.kernel.nativeinterface.StMedia;
import com.tencent.richframework.thread.RFWThreadManager;
import fj.v;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"Lii/e;", "Lii/a;", "", "W1", "Lci/h;", "requestBean", "", "X1", "<init>", "()V", "J", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class e extends a {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void e2(long j3, final e this$0, final h requestBean, final NTGetMediaListRsp nTGetMediaListRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(requestBean, "$requestBean");
        int i3 = nTGetMediaListRsp.result;
        v.a(i3 == 0, 4, i3, System.currentTimeMillis() - j3, nTGetMediaListRsp.traceId);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: ii.d
            @Override // java.lang.Runnable
            public final void run() {
                e.f2(e.this, nTGetMediaListRsp, requestBean);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f2(e this$0, NTGetMediaListRsp nTGetMediaListRsp, h requestBean) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(requestBean, "$requestBean");
        this$0.getLoadInfo().setCurrentState(4);
        com.tencent.xaction.log.b.a("GroupAlbumFeedLayerDataViewModel", 1, "get media list is " + nTGetMediaListRsp.traceId);
        if (nTGetMediaListRsp.result == 0) {
            this$0.S1().clear();
            this$0.S1().addAll(nTGetMediaListRsp.right.right);
            MediaListInfo mediaListInfo = new MediaListInfo(nTGetMediaListRsp.prevAttachInfo, nTGetMediaListRsp.nextAttachInfo, nTGetMediaListRsp.prevHasMore, nTGetMediaListRsp.nextHasMore, nTGetMediaListRsp.mediaIndex);
            AlbumInfo albumInfo = nTGetMediaListRsp.album;
            Intrinsics.checkNotNullExpressionValue(albumInfo, "response.album");
            ArrayList<StMedia> arrayList = nTGetMediaListRsp.mediaList;
            Intrinsics.checkNotNullExpressionValue(arrayList, "response.mediaList");
            this$0.T1(requestBean, albumInfo, arrayList, mediaListInfo);
            return;
        }
        RFWLog.e("GroupAlbumFeedLayerDataViewModel", RFWLog.USR, "get media list error, error msg is " + nTGetMediaListRsp.errMs + ", error seq is " + nTGetMediaListRsp.seq);
    }

    @Override // ii.a
    public boolean W1() {
        return false;
    }

    @Override // ii.a
    public void X1(final h requestBean) {
        String rightAttachInfo;
        long k3;
        Intrinsics.checkNotNullParameter(requestBean, "requestBean");
        final long currentTimeMillis = System.currentTimeMillis();
        IAlbumServiceGetMediaListCallback iAlbumServiceGetMediaListCallback = new IAlbumServiceGetMediaListCallback() { // from class: ii.c
            @Override // com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceGetMediaListCallback
            public final void onGetMediaList(NTGetMediaListRsp nTGetMediaListRsp) {
                e.e2(currentTimeMillis, this, requestBean, nTGetMediaListRsp);
            }
        };
        if (!requestBean.getIsRefresh() && !requestBean.getIsFetchRight()) {
            rightAttachInfo = requestBean.getLeftAttachInfo();
        } else {
            rightAttachInfo = requestBean.getRightAttachInfo();
        }
        String str = rightAttachInfo;
        if (TextUtils.isEmpty(requestBean.getBatchId())) {
            k3 = 0;
        } else {
            String batchId = requestBean.getBatchId();
            Intrinsics.checkNotNull(batchId);
            k3 = ef.d.k(batchId);
        }
        ki.a aVar = ki.a.f412421a;
        String groupId = requestBean.getGroupId();
        Intrinsics.checkNotNull(groupId);
        String albumId = requestBean.getAlbumId();
        Intrinsics.checkNotNull(albumId);
        aVar.b(groupId, albumId, requestBean.getLLocId(), k3, str, iAlbumServiceGetMediaListCallback);
    }
}

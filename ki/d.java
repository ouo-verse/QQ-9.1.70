package ki;

import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.groupalbum.event.GroupAlbumDeleteMediaEvent;
import com.qzone.util.ToastUtil;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceDeleteMediasCallback;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.ArrayUtils;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJj\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u001a\u0010\f\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00060\nj\n\u0012\u0006\u0012\u0004\u0018\u00010\u0006`\u000b2\u001a\u0010\r\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00060\nj\n\u0012\u0006\u0012\u0004\u0018\u00010\u0006`\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u000e\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0006J\u001e\u0010\u0016\u001a\u00020\u00022\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00140\nj\b\u0012\u0004\u0012\u00020\u0014`\u000bJ\u001e\u0010\u0017\u001a\u00020\u00022\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00140\nj\b\u0012\u0004\u0012\u00020\u0014`\u000bJ\u000e\u0010\u0019\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0018\u00a8\u0006\u001c"}, d2 = {"Lki/d;", "", "", "isSuccess", "", "retCode", "", "errMsg", "Lo9/f;", "requestBean", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "feedId", "batchId", "Lki/g;", "dataRepo", "", "c", "uid", "f", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", "mediaList", "e", "d", "Lci/j;", "g", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f412455a = new d();

    d() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(final ci.j requestBean, final ArrayList batchList, int i3, final int i16, final String str, final ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(requestBean, "$requestBean");
        Intrinsics.checkNotNullParameter(batchList, "$batchList");
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: ki.c
            @Override // java.lang.Runnable
            public final void run() {
                d.i(i16, str, requestBean, arrayList, batchList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(int i3, String errMs, ci.j requestBean, ArrayList feedIds, ArrayList batchList) {
        Intrinsics.checkNotNullParameter(requestBean, "$requestBean");
        Intrinsics.checkNotNullParameter(batchList, "$batchList");
        d dVar = f412455a;
        boolean z16 = i3 == 0;
        Intrinsics.checkNotNullExpressionValue(errMs, "errMs");
        Intrinsics.checkNotNullExpressionValue(feedIds, "feedIds");
        dVar.c(z16, i3, errMs, requestBean, feedIds, batchList, requestBean.getDataRepo());
    }

    public final boolean d(ArrayList<CommonStMedia> mediaList) {
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        if (ArrayUtils.isOutOfArrayIndex(0, mediaList)) {
            return false;
        }
        Iterator<CommonStMedia> it = mediaList.iterator();
        while (it.hasNext()) {
            CommonStMedia next = it.next();
            bk.e eVar = bk.e.f28497a;
            String str = next.getCom.tencent.weiyun.transmission.db.JobDbManager.TBL_UPLOAD java.lang.String();
            if (str == null) {
                str = "";
            }
            if (eVar.f(str)) {
                return false;
            }
        }
        return true;
    }

    public final boolean e(ArrayList<CommonStMedia> mediaList) {
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        if (ArrayUtils.isOutOfArrayIndex(0, mediaList)) {
            return false;
        }
        Iterator<CommonStMedia> it = mediaList.iterator();
        while (it.hasNext()) {
            String str = it.next().getCom.tencent.weiyun.transmission.db.JobDbManager.TBL_UPLOAD java.lang.String();
            if (str == null) {
                str = "";
            }
            if (!f(str)) {
                return false;
            }
        }
        return true;
    }

    public final boolean f(String uid) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        return TextUtils.equals(uid, LoginData.getInstance().getUid()) || TextUtils.equals(uid, String.valueOf(LoginData.getInstance().getUin()));
    }

    public final void g(final ci.j requestBean) {
        Intrinsics.checkNotNullParameter(requestBean, "requestBean");
        requestBean.g(requestBean.c());
        ArrayList<String> arrayList = new ArrayList<>();
        final ArrayList<String> arrayList2 = new ArrayList<>();
        for (CommonStMedia commonStMedia : requestBean.c()) {
            fj.p pVar = fj.p.f399467a;
            arrayList.add(pVar.i(commonStMedia));
            arrayList2.add(pVar.h(commonStMedia));
        }
        com.tencent.qqnt.kernel.api.g b16 = fj.r.b();
        if (b16 != null) {
            b16.V(requestBean.getGroupId(), requestBean.getAlbumId(), arrayList, arrayList2, new IAlbumServiceDeleteMediasCallback() { // from class: ki.b
                @Override // com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceDeleteMediasCallback
                public final void onDeleteMedias(int i3, int i16, String str, ArrayList arrayList3) {
                    d.h(ci.j.this, arrayList2, i3, i16, str, arrayList3);
                }
            });
        }
    }

    private final void c(boolean isSuccess, long retCode, String errMsg, o9.f requestBean, ArrayList<String> feedId, ArrayList<String> batchId, g dataRepo) {
        if (isSuccess && retCode == 0) {
            if (requestBean.getScene() == 3) {
                GroupAlbumDeleteMediaEvent groupAlbumDeleteMediaEvent = new GroupAlbumDeleteMediaEvent(requestBean);
                groupAlbumDeleteMediaEvent.getFeedList().addAll(feedId);
                groupAlbumDeleteMediaEvent.getBatchList().addAll(batchId);
                SimpleEventBus.getInstance().dispatchEvent(groupAlbumDeleteMediaEvent);
            } else if (dataRepo != null) {
                ArrayList<CommonStMedia> c16 = requestBean.c();
                String groupId = requestBean.getGroupId();
                if (groupId == null) {
                    groupId = "";
                }
                dataRepo.r(c16, groupId);
            }
            QQToast.makeText(BaseApplication.getContext(), 2, R.string.f1334162, 0).show();
            return;
        }
        RFWLog.e("QZoneIntimateDeleteMediaRepo", RFWLog.USR, "handleDeleteMediaResponse rsp error  isSuccess = " + isSuccess + " retCode = " + retCode + " errMsg = " + errMsg);
        if (!NetworkUtil.isNetworkAvailable(MobileQQ.sMobileQQ)) {
            ToastUtil.o(R.string.f1338579, 4);
        } else {
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.f1334061, 0).show();
        }
    }
}

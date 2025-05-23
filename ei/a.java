package ei;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;
import ci.i;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellLocalInfo;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumAlbumDetailInitBean;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ArrayUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import oi.b;
import xh.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\"J0\u0010\t\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J>\u0010\u0016\u001a\u00020\u00152\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u0013J6\u0010\u0017\u001a\u00020\u00152\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u0013J@\u0010\u001e\u001a\u00020\u00152\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0018\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cJ\"\u0010 \u001a\u00020\u00152\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001f\u001a\u00020\u0005\u00a8\u0006#"}, d2 = {"Lei/a;", "", "", "curPos", "", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", "initMediaList", "Lkotlin/Pair;", "Ljava/util/ArrayList;", "a", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "businessFeedData", "Landroid/content/Context;", "context", "Landroid/widget/ImageView;", "clickView", "index", "", "groupId", "", "fromFeedDetail", "", "c", "f", "mediaPos", "attachInfo", "Lcom/qzone/reborn/albumx/common/bean/a;", "batchBean", "Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumAlbumDetailInitBean;", "detailInitBean", "b", "commonStMedia", "e", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f396299a = new a();

    a() {
    }

    private final Pair<ArrayList<CommonStMedia>, Integer> a(int curPos, List<CommonStMedia> initMediaList) {
        int i3;
        int i16;
        ArrayList arrayList = new ArrayList();
        if (initMediaList.size() >= 30) {
            int size = initMediaList.size() - 1;
            if (curPos < 14) {
                i3 = 0;
                i16 = 29;
            } else if (curPos >= (initMediaList.size() - 1) - 14) {
                int i17 = (size - 30) + 1;
                curPos -= i17;
                i16 = size;
                i3 = i17;
            } else {
                i3 = curPos - 14;
                i16 = curPos + 14 + 1;
                curPos -= i3;
            }
            arrayList.addAll(initMediaList.subList(i3, i16 + 1));
        } else {
            arrayList.addAll(initMediaList);
        }
        return new Pair<>(arrayList, Integer.valueOf(curPos));
    }

    public final void c(BusinessFeedData businessFeedData, Context context, ImageView clickView, int index, String groupId, boolean fromFeedDetail) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        if (businessFeedData == null) {
            return;
        }
        ArrayList<CommonStMedia> a16 = e.a(businessFeedData);
        if (bl.b(a16)) {
            return;
        }
        QLog.i("GroupAlbumMediaClickProcess", 1, "media list size is " + e.d(businessFeedData) + ", index is " + index);
        Pair<ArrayList<CommonStMedia>, Integer> a17 = a(index, a16);
        ArrayList<CommonStMedia> first = a17.getFirst();
        int intValue = a17.getSecond().intValue();
        if (ArrayUtils.isOutOfArrayIndex(intValue, first)) {
            QLog.e("GroupAlbumMediaClickProcess", 1, "final cur pos " + intValue + ", media list size is " + first.size());
            QQToast.makeText(context, 1, "\u7f51\u7edc\u6570\u636e\u5f02\u5e38, \u8bf7\u7a0d\u540e\u518d\u8bd5", 0).show();
            return;
        }
        QLog.i("GroupAlbumMediaClickProcess", 1, "final media list size is " + first.size() + ", index is " + intValue);
        i iVar = new i();
        CellPictureInfo pictureInfo = businessFeedData.getPictureInfo();
        iVar.j(pictureInfo != null ? pictureInfo.albumid : null);
        CellPictureInfo pictureInfo2 = businessFeedData.getPictureInfo();
        iVar.k(pictureInfo2 != null ? pictureInfo2.albumname : null);
        CellPictureInfo pictureInfo3 = businessFeedData.getPictureInfo();
        iVar.b0(String.valueOf(pictureInfo3 != null ? Long.valueOf(pictureInfo3.batchId) : null));
        iVar.e0(groupId);
        iVar.l(clickView);
        iVar.m(intValue);
        CellLocalInfo localInfoV2 = businessFeedData.getLocalInfoV2();
        iVar.n(localInfoV2 != null ? localInfoV2.isFake() : false);
        iVar.w(first);
        iVar.y(first);
        CellFeedCommInfo feedCommInfo = businessFeedData.getFeedCommInfo();
        String str = feedCommInfo != null ? feedCommInfo.feedsid : null;
        if (str == null) {
            str = "";
        }
        iVar.c0(str);
        iVar.d0(fromFeedDetail);
        ((b) ho.i.t(b.class)).b((Activity) context, iVar);
    }

    public final void e(Context context, ImageView clickView, CommonStMedia commonStMedia) {
        Intrinsics.checkNotNullParameter(commonStMedia, "commonStMedia");
        ArrayList<CommonStMedia> arrayList = new ArrayList<>();
        arrayList.add(commonStMedia);
        i iVar = new i();
        iVar.y(arrayList);
        iVar.w(arrayList);
        iVar.l(clickView);
        iVar.m(0);
        ((b) ho.i.t(b.class)).c((Activity) context, iVar);
    }

    public final void f(BusinessFeedData businessFeedData, Context context, ImageView clickView, String groupId, boolean fromFeedDetail) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        if (businessFeedData == null) {
            return;
        }
        ArrayList<CommonStMedia> b16 = e.b(businessFeedData);
        i iVar = new i();
        VideoInfo videoInfo = businessFeedData.getVideoInfo();
        iVar.j(videoInfo != null ? videoInfo.albumid : null);
        VideoInfo videoInfo2 = businessFeedData.getVideoInfo();
        iVar.b0(String.valueOf(videoInfo2 != null ? Long.valueOf(videoInfo2.batchId) : null));
        iVar.l(clickView);
        iVar.m(0);
        iVar.e0(groupId);
        CellLocalInfo localInfoV2 = businessFeedData.getLocalInfoV2();
        iVar.n(localInfoV2 != null ? localInfoV2.isFake() : false);
        iVar.w(b16);
        iVar.y(b16);
        CellFeedCommInfo feedCommInfo = businessFeedData.getFeedCommInfo();
        String str = feedCommInfo != null ? feedCommInfo.feedsid : null;
        if (str == null) {
            str = "";
        }
        iVar.c0(str);
        iVar.d0(fromFeedDetail);
        ((b) ho.i.t(b.class)).b((Activity) context, iVar);
    }

    public final void b(Context context, ImageView clickView, int mediaPos, String attachInfo, com.qzone.reborn.albumx.common.bean.a batchBean, GroupAlbumAlbumDetailInitBean detailInitBean) {
        if (detailInitBean == null || batchBean == null) {
            return;
        }
        List<CommonStMedia> j3 = batchBean.getBatchInfo().j();
        if (bl.b(j3)) {
            return;
        }
        Pair<ArrayList<CommonStMedia>, Integer> a16 = a(mediaPos, j3);
        ArrayList<CommonStMedia> first = a16.getFirst();
        int intValue = a16.getSecond().intValue();
        i iVar = new i();
        iVar.j(batchBean.getAlbumId());
        iVar.k(batchBean.getCom.tencent.aelight.camera.constants.AEEditorConstants.ALBUMNAME java.lang.String());
        iVar.b0(String.valueOf(batchBean.getBatchInfo().getLinkId()));
        iVar.y(first);
        iVar.w(first);
        iVar.l(clickView);
        iVar.m(intValue);
        if (attachInfo == null) {
            attachInfo = "";
        }
        iVar.f0(attachInfo);
        iVar.a0(detailInitBean);
        iVar.e0(detailInitBean.getGroupId());
        ((b) ho.i.t(b.class)).a((Activity) context, iVar);
    }

    public static /* synthetic */ void g(a aVar, BusinessFeedData businessFeedData, Context context, ImageView imageView, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            z16 = false;
        }
        aVar.f(businessFeedData, context, imageView, str, z16);
    }

    public static /* synthetic */ void d(a aVar, BusinessFeedData businessFeedData, Context context, ImageView imageView, int i3, String str, boolean z16, int i16, Object obj) {
        if ((i16 & 32) != 0) {
            z16 = false;
        }
        aVar.c(businessFeedData, context, imageView, i3, str, z16);
    }
}

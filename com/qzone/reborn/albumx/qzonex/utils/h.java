package com.qzone.reborn.albumx.qzonex.utils;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;
import com.qzone.reborn.albumx.common.convert.bean.CommonPhotoInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxAlbumDetailInitBean;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ArrayUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J:\u0010\n\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\bj\b\u0012\u0004\u0012\u00020\u0005`\t\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J:\u0010\f\u001a\u001e\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b0\bj\b\u0012\u0004\u0012\u00020\u000b`\t\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004H\u0002JL\u0010\u0019\u001a\u00020\u00182\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u0016J@\u0010 \u001a\u00020\u00182\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001a\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u00132\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eJX\u0010\"\u001a\u00020\u00182\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001a\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u00132\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u00050\bj\b\u0012\u0004\u0012\u00020\u0005`\t\u00a8\u0006%"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/utils/h;", "", "", "curPos", "", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", "initMediaList", "Lkotlin/Pair;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "a", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonPhotoInfo;", "b", "Landroid/content/Context;", "context", "medias", "Landroid/widget/ImageView;", "clickView", "index", "", "uin", "dataRepoKey", "", "fromFeedDetail", "", "e", "mediaPos", "attachInfo", "Lcom/qzone/reborn/albumx/common/bean/a;", "batchBean", "Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxAlbumDetailInitBean;", "detailInitBean", "d", "selectMedias", "c", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f53411a = new h();

    h() {
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

    private final Pair<ArrayList<CommonPhotoInfo>, Integer> b(int curPos, List<CommonPhotoInfo> initMediaList) {
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

    public final void c(Context context, ImageView clickView, int mediaPos, String attachInfo, com.qzone.reborn.albumx.common.bean.a batchBean, QZAlbumxAlbumDetailInitBean detailInitBean, ArrayList<CommonStMedia> selectMedias) {
        Intrinsics.checkNotNullParameter(selectMedias, "selectMedias");
        if (detailInitBean == null || batchBean == null || bl.b(batchBean.getBatchInfo().j())) {
            return;
        }
        Pair<ArrayList<CommonStMedia>, Integer> a16 = a(mediaPos, batchBean.getBatchInfo().j());
        ArrayList<CommonStMedia> first = a16.getFirst();
        int intValue = a16.getSecond().intValue();
        bb.h hVar = new bb.h();
        hVar.j(batchBean.getAlbumId());
        hVar.k(batchBean.getCom.tencent.aelight.camera.constants.AEEditorConstants.ALBUMNAME java.lang.String());
        hVar.i0(String.valueOf(batchBean.getBatchInfo().getLinkId()));
        hVar.d0(detailInitBean.getUin());
        hVar.y(first);
        hVar.w(first);
        hVar.l(clickView);
        hVar.m(intValue);
        if (attachInfo == null) {
            attachInfo = "";
        }
        hVar.j0(attachInfo);
        hVar.e0(detailInitBean);
        hVar.A(selectMedias);
        hVar.k0(detailInitBean.getUin());
        ((vb.a) ho.i.t(vb.a.class)).a((Activity) context, hVar);
    }

    public final void e(Context context, List<CommonPhotoInfo> medias, ImageView clickView, int index, String uin, String dataRepoKey, boolean fromFeedDetail) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(dataRepoKey, "dataRepoKey");
        List<CommonPhotoInfo> list = medias;
        if (list == null || list.isEmpty()) {
            return;
        }
        Pair<ArrayList<CommonPhotoInfo>, Integer> b16 = b(index, medias);
        ArrayList<CommonPhotoInfo> first = b16.getFirst();
        int intValue = b16.getSecond().intValue();
        if (ArrayUtils.isOutOfArrayIndex(intValue, first)) {
            QLog.e("QZAlbumxMediaClickProcess", 1, "final cur pos " + intValue + ", media list size is " + first.size());
            QQToast.makeText(context, 1, "\u7f51\u7edc\u6570\u636e\u5f02\u5e38, \u8bf7\u7a0d\u540e\u518d\u8bd5", 0).show();
            return;
        }
        QLog.i("QZAlbumxMediaClickProcess", 1, "final media list size is " + first.size() + ", index is " + intValue);
        bb.i iVar = new bb.i();
        iVar.k0(uin);
        iVar.l(clickView);
        iVar.m(intValue);
        iVar.l0(first);
        iVar.n0(first);
        iVar.h0(fromFeedDetail);
        iVar.f0(dataRepoKey);
        ((vb.a) ho.i.t(vb.a.class)).c((Activity) context, iVar);
    }

    public final void d(Context context, ImageView clickView, int mediaPos, String attachInfo, com.qzone.reborn.albumx.common.bean.a batchBean, QZAlbumxAlbumDetailInitBean detailInitBean) {
        if (detailInitBean == null || batchBean == null || bl.b(batchBean.getBatchInfo().j())) {
            return;
        }
        Pair<ArrayList<CommonStMedia>, Integer> a16 = a(mediaPos, batchBean.getBatchInfo().j());
        ArrayList<CommonStMedia> first = a16.getFirst();
        int intValue = a16.getSecond().intValue();
        bb.h hVar = new bb.h();
        hVar.j(batchBean.getAlbumId());
        hVar.k(batchBean.getCom.tencent.aelight.camera.constants.AEEditorConstants.ALBUMNAME java.lang.String());
        hVar.i0(String.valueOf(batchBean.getBatchInfo().getLinkId()));
        hVar.d0(detailInitBean.getUin());
        hVar.y(first);
        hVar.w(first);
        hVar.l(clickView);
        hVar.m(intValue);
        if (attachInfo == null) {
            attachInfo = "";
        }
        hVar.j0(attachInfo);
        hVar.e0(detailInitBean);
        hVar.k0(detailInitBean.getUin());
        ((vb.a) ho.i.t(vb.a.class)).b((Activity) context, hVar);
    }
}

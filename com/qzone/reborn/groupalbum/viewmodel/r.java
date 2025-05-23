package com.qzone.reborn.groupalbum.viewmodel;

import android.app.Activity;
import androidx.lifecycle.MutableLiveData;
import com.qzone.album.protocol.QZoneOptAlbumRequest;
import com.qzone.reborn.albumx.common.bean.CommonAlbumEditInitBean;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.viewmodel.EditAlbumResult;
import com.qzone.reborn.albumx.common.viewmodel.EditAlbumType;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumAlbumDetailInitBean;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumEditTextInitBean;
import com.qzone.reborn.groupalbum.event.GroupAlbumEditAlbumEvent;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.AlbumInfo;
import com.tencent.qqnt.kernel.nativeinterface.AlbumModifyMask;
import com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceDeleteAlbumCallback;
import com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceModifyAlbumCallback;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ0\u0010\t\u001a\u00020\b2\u001e\u0010\u0005\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u0001`\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J*\u0010\u000b\u001a$\u0012\u0018\u0012\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0003`\u0004\u0012\u0004\u0012\u00020\u0006\u0018\u00010\nH\u0002J\b\u0010\f\u001a\u00020\bH\u0002J \u0010\u0010\u001a\u00020\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0018\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0006\u0010\u001a\u001a\u00020\b\u00a8\u0006\u001d"}, d2 = {"Lcom/qzone/reborn/groupalbum/viewmodel/r;", "Lcom/qzone/reborn/albumx/common/viewmodel/c;", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/AlbumModifyMask;", "Lkotlin/collections/ArrayList;", "maskList", "Lcom/tencent/qqnt/kernel/nativeinterface/AlbumInfo;", "albumInfo", "", "q2", "Lkotlin/Pair;", "j2", ICustomDataEditor.NUMBER_PARAM_2, "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", QZoneOptAlbumRequest.FIELD_CMD_EDIT, "deleteAlbum", "k2", "", "W1", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "requestCode", "Z1", "X1", ICustomDataEditor.STRING_ARRAY_PARAM_2, "m2", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class r extends com.qzone.reborn.albumx.common.viewmodel.c {
    private final Pair<ArrayList<AlbumModifyMask>, AlbumInfo> j2() {
        CommonAlbumEditInitBean value = Q1().getValue();
        RFWLog.i("CommonAlbumEditAlbumViewModel", RFWLog.DEV, "checkEdited, initBean:" + O1() + ", currentValue:" + value);
        if (value == null || Intrinsics.areEqual(O1(), value)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        CommonAlbumInfo albumInfo = value.getAlbumInfo();
        if (!Intrinsics.areEqual(O1().getAlbumName(), value.getAlbumName())) {
            arrayList.add(AlbumModifyMask.KALBUMMODIFYMASKNAME);
            albumInfo.m0(value.getAlbumName());
        }
        if (!Intrinsics.areEqual(O1().getAlbumDesc(), value.getAlbumDesc())) {
            arrayList.add(AlbumModifyMask.KALBUMMODIFYMASKDESC);
            albumInfo.g0(value.getAlbumDesc());
        }
        if (!Intrinsics.areEqual(k9.a.e(O1().getAlbumCover(), 0, 1, null), k9.a.e(value.getAlbumCover(), 0, 1, null))) {
            arrayList.add(AlbumModifyMask.KALBUMMODIFYMASKCOVER);
            albumInfo.b0(value.getAlbumCover());
        }
        if (O1().isStickTop() != value.isStickTop()) {
            arrayList.add(AlbumModifyMask.KALBUMMODIFYMASKTOP);
            albumInfo.w0(value.isStickTop() ? 1L : 0L);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Pair<>(arrayList, xh.a.b(albumInfo));
    }

    private final void k2(CommonAlbumInfo editAlbum, CommonAlbumInfo deleteAlbum) {
        SimpleEventBus.getInstance().dispatchEvent(new GroupAlbumEditAlbumEvent(O1().getBizId(), deleteAlbum, editAlbum, null, 8, null));
    }

    private final void n2() {
        RFWLog.i("CommonAlbumEditAlbumViewModel", RFWLog.USR, "sendDeleteAlbumReq ");
        com.tencent.qqnt.kernel.api.g b16 = fj.r.b();
        if (b16 != null) {
            b16.A0(O1().getBizId(), O1().getAlbumId(), new IAlbumServiceDeleteAlbumCallback() { // from class: com.qzone.reborn.groupalbum.viewmodel.p
                @Override // com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceDeleteAlbumCallback
                public final void onDeleteAlbum(int i3, int i16, String str) {
                    r.o2(r.this, i3, i16, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o2(final r this$0, int i3, final int i16, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i(this$0.getTAG(), 1, "sendDeleteAlbumReq seq: " + i3 + " | result: " + i16 + " | errMsg:" + str);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.groupalbum.viewmodel.q
            @Override // java.lang.Runnable
            public final void run() {
                r.p2(r.this, i16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p2(r this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.S1().postValue(Boolean.FALSE);
        if (i3 == 0) {
            this$0.R1().postValue(new EditAlbumResult(true, EditAlbumType.DELETE, this$0.O1().getAlbumInfo(), null, 8, null));
            l2(this$0, null, this$0.O1().getAlbumInfo(), 1, null);
        } else {
            this$0.R1().postValue(new EditAlbumResult(false, EditAlbumType.DELETE, this$0.O1().getAlbumInfo(), null, 8, null));
        }
    }

    private final void q2(final ArrayList<AlbumModifyMask> maskList, AlbumInfo albumInfo) {
        com.tencent.qqnt.kernel.api.g b16 = fj.r.b();
        if (b16 != null) {
            b16.d0(albumInfo, maskList, new IAlbumServiceModifyAlbumCallback() { // from class: com.qzone.reborn.groupalbum.viewmodel.n
                @Override // com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceModifyAlbumCallback
                public final void onModifyAlbum(int i3, int i16, String str, AlbumInfo albumInfo2) {
                    r.r2(maskList, this, i3, i16, str, albumInfo2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r2(ArrayList arrayList, final r this$0, int i3, final int i16, String str, final AlbumInfo albumInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RFWLog.i("CommonAlbumEditAlbumViewModel", RFWLog.USR, "sendEditAlbumReq, onReceive, seq:" + i3 + ", errMs:" + str + ", maskList:" + arrayList);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.groupalbum.viewmodel.o
            @Override // java.lang.Runnable
            public final void run() {
                r.s2(r.this, i16, albumInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s2(r this$0, int i3, AlbumInfo albumInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.S1().postValue(Boolean.FALSE);
        if (i3 == 0) {
            MutableLiveData<EditAlbumResult> R1 = this$0.R1();
            EditAlbumType editAlbumType = EditAlbumType.EDIT;
            Intrinsics.checkNotNullExpressionValue(albumInfo, "albumInfo");
            R1.postValue(new EditAlbumResult(true, editAlbumType, xh.a.a(albumInfo), null, 8, null));
            l2(this$0, xh.a.a(albumInfo), null, 2, null);
            return;
        }
        MutableLiveData<EditAlbumResult> R12 = this$0.R1();
        EditAlbumType editAlbumType2 = EditAlbumType.EDIT;
        Intrinsics.checkNotNullExpressionValue(albumInfo, "albumInfo");
        R12.postValue(new EditAlbumResult(false, editAlbumType2, xh.a.a(albumInfo), null, 8, null));
    }

    @Override // com.qzone.reborn.albumx.common.viewmodel.c
    public boolean W1() {
        Pair<ArrayList<AlbumModifyMask>, AlbumInfo> j26 = j2();
        if (j26 == null) {
            return false;
        }
        S1().postValue(Boolean.TRUE);
        q2(j26.getFirst(), j26.getSecond());
        return true;
    }

    @Override // com.qzone.reborn.albumx.common.viewmodel.c
    public void X1(Activity activity, int requestCode) {
        String str;
        Intrinsics.checkNotNullParameter(activity, "activity");
        oi.c m3 = ho.i.m();
        String bizId = O1().getBizId();
        String a16 = com.qzone.util.l.a(R.string.f133957i);
        Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qzone_albumx_album_desc_text)");
        CommonAlbumEditInitBean value = M1().getValue();
        if (value == null || (str = value.getAlbumDesc()) == null) {
            str = "";
        }
        String a17 = com.qzone.util.l.a(R.string.f133947h);
        Intrinsics.checkNotNullExpressionValue(a17, "qqStr(R.string.qzone_albumx_album_desc_hint)");
        m3.c(activity, requestCode, new GroupAlbumEditTextInitBean(bizId, a16, str, 50, a17, true, true, "pg_qz_album_description_edit"));
    }

    @Override // com.qzone.reborn.albumx.common.viewmodel.c
    public void Z1(Activity activity, int requestCode) {
        String str;
        Intrinsics.checkNotNullParameter(activity, "activity");
        oi.c m3 = ho.i.m();
        String bizId = O1().getBizId();
        CommonAlbumEditInitBean value = M1().getValue();
        if (value == null || (str = value.getAlbumName()) == null) {
            str = "";
        }
        m3.c(activity, requestCode, new GroupAlbumEditTextInitBean(bizId, "\u76f8\u518c\u540d", str, 15, "\u8f93\u5165\u76f8\u518c\u540d", false, false, "pg_qz_album_name_edit", 96, null));
    }

    @Override // com.qzone.reborn.albumx.common.viewmodel.c
    public void a2(Activity activity, int requestCode) {
        String albumId;
        Intrinsics.checkNotNullParameter(activity, "activity");
        oi.c m3 = ho.i.m();
        String bizId = O1().getBizId();
        String str = "";
        if (bizId == null) {
            bizId = "";
        }
        GroupAlbumAlbumDetailInitBean groupAlbumAlbumDetailInitBean = new GroupAlbumAlbumDetailInitBean(bizId);
        CommonAlbumEditInitBean value = M1().getValue();
        if (value != null && (albumId = value.getAlbumId()) != null) {
            str = albumId;
        }
        groupAlbumAlbumDetailInitBean.setAlbumId(str);
        Unit unit = Unit.INSTANCE;
        m3.a(activity, requestCode, groupAlbumAlbumDetailInitBean);
    }

    public final void m2() {
        S1().postValue(Boolean.TRUE);
        n2();
    }

    static /* synthetic */ void l2(r rVar, CommonAlbumInfo commonAlbumInfo, CommonAlbumInfo commonAlbumInfo2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            commonAlbumInfo = null;
        }
        if ((i3 & 2) != 0) {
            commonAlbumInfo2 = null;
        }
        rVar.k2(commonAlbumInfo, commonAlbumInfo2);
    }
}

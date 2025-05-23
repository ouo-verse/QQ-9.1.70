package com.qzone.reborn.intimate.part.selectalbum;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.albumx.common.bean.CommonAlbumEditInitBean;
import com.qzone.reborn.albumx.common.bean.h;
import com.qzone.reborn.albumx.common.part.selectalbum.CommonSelectAlbumListPart;
import com.qzone.reborn.albumx.common.viewmodel.l;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateAlbumDetailInitBean;
import com.qzone.reborn.intimate.bean.init.Source;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import ho.i;
import jj.IntimateSelectAlbumBean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import nk.bb;
import qzone.QZoneBaseAlbumMeta$AlbumInfo;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0014J\b\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u001c\u0010\u0013\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0002H\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/qzone/reborn/intimate/part/selectalbum/e;", "Lcom/qzone/reborn/albumx/common/part/selectalbum/CommonSelectAlbumListPart;", "Lcom/qzone/reborn/albumx/common/bean/h;", "selectAlbumBean", "", "S9", "Lqzone/QZoneBaseAlbumMeta$AlbumInfo;", "selectAlbumInfo", "Q9", "R9", "Lcom/qzone/reborn/albumx/common/viewmodel/l;", "H9", "Q1", "albumItem", Constants.ELECTRONIC_INFO, "", "action", "", "args", "handleBroadcastMessage", "G8", "<init>", "()V", "E", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class e extends CommonSelectAlbumListPart {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes37.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f57621a;

        static {
            int[] iArr = new int[Source.values().length];
            try {
                iArr[Source.UPLOAD_ALBUM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Source.DISSOLUTION_RELATIONSHIP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f57621a = iArr;
        }
    }

    private final void Q9(QZoneBaseAlbumMeta$AlbumInfo selectAlbumInfo) {
        Activity activity = getActivity();
        Intent intent = new Intent();
        intent.putExtra("SELECTED_ALBUM_INFO", selectAlbumInfo.toByteArray());
        Unit unit = Unit.INSTANCE;
        activity.setResult(-1, intent);
        activity.finish();
    }

    private final void R9() {
        l J9 = J9();
        Intrinsics.checkNotNull(J9, "null cannot be cast to non-null type com.qzone.reborn.intimate.viewmodel.QZoneIntimateSelectAlbumViewModel");
        int i3 = b.f57621a[((bb) J9).Z1().getSource().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                return;
            }
            getActivity().finish();
            return;
        }
        l J92 = J9();
        Intrinsics.checkNotNull(J92, "null cannot be cast to non-null type com.qzone.reborn.intimate.viewmodel.QZoneIntimateSelectAlbumViewModel");
        String albumId = ((bb) J92).Z1().getAlbumId();
        if (!(albumId == null || albumId.length() == 0) && !J9().R1() && !J9().S1()) {
            QQToast.makeText(getContext(), 1, HardCodeUtil.qqStr(R.string.w9q), 0).show();
        } else {
            getActivity().finish();
        }
    }

    private final void S9(h selectAlbumBean) {
        QZoneIntimateAlbumDetailInitBean qZoneIntimateAlbumDetailInitBean = new QZoneIntimateAlbumDetailInitBean();
        l J9 = J9();
        Intrinsics.checkNotNull(J9, "null cannot be cast to non-null type com.qzone.reborn.intimate.viewmodel.QZoneIntimateSelectAlbumViewModel");
        qZoneIntimateAlbumDetailInitBean.setSpaceId(((bb) J9).Z1().getSpaceId());
        qZoneIntimateAlbumDetailInitBean.setAlbumId(selectAlbumBean.getAlbumInfo().getAlbumId());
        ck.c o16 = i.o();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        o16.i(context, qZoneIntimateAlbumDetailInitBean);
    }

    @Override // l9.i
    public void G5(h albumItem) {
        Intrinsics.checkNotNullParameter(albumItem, "albumItem");
        l J9 = J9();
        Intrinsics.checkNotNull(J9, "null cannot be cast to non-null type com.qzone.reborn.intimate.viewmodel.QZoneIntimateSelectAlbumViewModel");
        int i3 = b.f57621a[((bb) J9).Z1().getSource().ordinal()];
        if (i3 == 1) {
            Q9(xh.e.f(albumItem.getAlbumInfo()));
        } else {
            if (i3 != 2) {
                return;
            }
            S9(albumItem);
        }
    }

    @Override // l9.k
    public void G8(h albumItem) {
        Intrinsics.checkNotNullParameter(albumItem, "albumItem");
        ck.c o16 = i.o();
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        l J9 = J9();
        Intrinsics.checkNotNull(J9, "null cannot be cast to non-null type com.qzone.reborn.intimate.viewmodel.QZoneIntimateSelectAlbumViewModel");
        o16.p(activity, 111, new CommonAlbumEditInitBean(((bb) J9).Z1().getSpaceId(), albumItem.getAlbumInfo()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.part.selectalbum.CommonSelectAlbumListPart
    public l H9() {
        ViewModel viewModel = getViewModel(bb.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneIntima\u2026bumViewModel::class.java)");
        return (l) viewModel;
    }

    @Override // l9.j
    public void Q1() {
        l J9 = J9();
        Intrinsics.checkNotNull(J9, "null cannot be cast to non-null type com.qzone.reborn.intimate.viewmodel.QZoneIntimateSelectAlbumViewModel");
        broadcastMessage("ACTION_CREATE_ALBUM", ((bb) J9).Z1().getSpaceId());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String action, Object args) {
        super.handleBroadcastMessage(action, args);
        if (Intrinsics.areEqual(action, "ACTION_CREATE_ALBUM_SUCCEED")) {
            if (args instanceof IntimateSelectAlbumBean) {
                Q9(((IntimateSelectAlbumBean) args).getAlbumInfo());
            }
        } else if (Intrinsics.areEqual(action, "ACTION_BACK_CLICK")) {
            R9();
        }
    }
}

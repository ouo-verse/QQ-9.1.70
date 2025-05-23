package com.qzone.reborn.groupalbum.upload.selectalbum;

import android.app.Activity;
import android.content.Intent;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.part.selectalbum.CommonSelectAlbumListPart;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0014J\b\u0010\t\u001a\u00020\u0004H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u001c\u0010\u0011\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/qzone/reborn/groupalbum/upload/selectalbum/k;", "Lcom/qzone/reborn/albumx/common/part/selectalbum/CommonSelectAlbumListPart;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "selectAlbumBean", "", "Q9", "R9", "Lcom/qzone/reborn/albumx/common/viewmodel/l;", "H9", "Q1", "Lcom/qzone/reborn/albumx/common/bean/h;", "albumItem", Constants.ELECTRONIC_INFO, "", "action", "", "args", "handleBroadcastMessage", "G8", "<init>", "()V", "E", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class k extends CommonSelectAlbumListPart {
    private final void Q9(CommonAlbumInfo selectAlbumBean) {
        Activity activity = getActivity();
        Intent intent = new Intent();
        intent.putExtra("SELECTED_ALBUM_INFO", selectAlbumBean);
        Unit unit = Unit.INSTANCE;
        activity.setResult(-1, intent);
        activity.finish();
    }

    private final void R9() {
        com.qzone.reborn.albumx.common.viewmodel.l J9 = J9();
        Intrinsics.checkNotNull(J9, "null cannot be cast to non-null type com.qzone.reborn.groupalbum.upload.selectalbum.GroupUploadSelectAlbumViewModel");
        String albumId = ((n) J9).a2().getAlbumId();
        if (!(albumId == null || albumId.length() == 0) && !J9().R1() && !J9().S1()) {
            QQToast.makeText(getContext(), 1, HardCodeUtil.qqStr(R.string.w9q), 0).show();
        } else {
            getActivity().finish();
        }
    }

    @Override // l9.i
    public void G5(com.qzone.reborn.albumx.common.bean.h albumItem) {
        Intrinsics.checkNotNullParameter(albumItem, "albumItem");
        Q9(albumItem.getAlbumInfo());
    }

    @Override // l9.k
    public void G8(com.qzone.reborn.albumx.common.bean.h albumItem) {
        Intrinsics.checkNotNullParameter(albumItem, "albumItem");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.common.part.selectalbum.CommonSelectAlbumListPart
    public com.qzone.reborn.albumx.common.viewmodel.l H9() {
        ViewModel viewModel = getViewModel(n.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(GroupUpload\u2026bumViewModel::class.java)");
        return (com.qzone.reborn.albumx.common.viewmodel.l) viewModel;
    }

    @Override // l9.j
    public void Q1() {
        com.qzone.reborn.albumx.common.viewmodel.l J9 = J9();
        Intrinsics.checkNotNull(J9, "null cannot be cast to non-null type com.qzone.reborn.groupalbum.upload.selectalbum.GroupUploadSelectAlbumViewModel");
        broadcastMessage("ACTION_CREATE_ALBUM", ((n) J9).a2().getGroupId());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String action, Object args) {
        super.handleBroadcastMessage(action, args);
        if (Intrinsics.areEqual(action, "ACTION_CREATE_ALBUM_SUCCEED")) {
            if (args instanceof vh.c) {
                Q9(xh.a.a(((vh.c) args).getAlbumInfo()));
            }
        } else if (Intrinsics.areEqual(action, "ACTION_BACK_CLICK")) {
            R9();
        }
    }
}

package com.qzone.reborn.groupalbum.reship.part;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.part.selectalbum.CommonSelectAlbumListPart;
import com.qzone.reborn.albumx.common.viewmodel.l;
import com.tencent.bugly.common.constants.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J\u001c\u0010\u000f\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/qzone/reborn/groupalbum/reship/part/h;", "Lcom/qzone/reborn/albumx/common/part/selectalbum/CommonSelectAlbumListPart;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "selectAlbumBean", "", "Q9", "Lcom/qzone/reborn/albumx/common/viewmodel/l;", "H9", "Lcom/qzone/reborn/albumx/common/bean/h;", "albumItem", Constants.ELECTRONIC_INFO, "", "action", "", "args", "handleBroadcastMessage", "Q1", "G8", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class h extends CommonSelectAlbumListPart {
    private final void Q9(CommonAlbumInfo selectAlbumBean) {
        Activity activity = getActivity();
        Intent intent = new Intent();
        intent.putExtra("SELECTED_ALBUM_INFO", selectAlbumBean);
        Unit unit = Unit.INSTANCE;
        activity.setResult(-1, intent);
        activity.finish();
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
    public l H9() {
        ViewModel viewModel = getViewModel(ni.g.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(GroupAlbumR\u2026ectViewModel::class.java)");
        return (l) viewModel;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String action, Object args) {
        super.handleBroadcastMessage(action, args);
        if (TextUtils.equals("ACTION_BACK_CLICK", action)) {
            getActivity().finish();
        }
    }

    @Override // l9.j
    public void Q1() {
    }
}

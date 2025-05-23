package com.qzone.reborn.groupalbum.upload.selectalbum;

import android.content.res.Configuration;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumCreateAlbumInitBean;
import com.qzone.reborn.groupalbum.dialog.GroupAlbumCreateAlbumDialog;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.qqnt.kernel.nativeinterface.AlbumInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\t\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/qzone/reborn/groupalbum/upload/selectalbum/j;", "Lcom/qzone/reborn/base/k;", "", "groupId", "", "D9", "action", "", "args", "handleBroadcastMessage", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "Lcom/qzone/reborn/groupalbum/dialog/GroupAlbumCreateAlbumDialog;", "d", "Lcom/qzone/reborn/groupalbum/dialog/GroupAlbumCreateAlbumDialog;", "createAlbumDialog", "<init>", "()V", "e", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class j extends com.qzone.reborn.base.k {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private GroupAlbumCreateAlbumDialog createAlbumDialog;

    private final void D9(String groupId) {
        GroupAlbumCreateAlbumDialog groupAlbumCreateAlbumDialog = new GroupAlbumCreateAlbumDialog(getContext(), new GroupAlbumCreateAlbumInitBean(groupId));
        groupAlbumCreateAlbumDialog.r0(new GroupAlbumCreateAlbumDialog.a() { // from class: com.qzone.reborn.groupalbum.upload.selectalbum.i
            @Override // com.qzone.reborn.groupalbum.dialog.GroupAlbumCreateAlbumDialog.a
            public final void a(boolean z16, AlbumInfo albumInfo) {
                j.E9(j.this, z16, albumInfo);
            }
        });
        groupAlbumCreateAlbumDialog.show();
        this.createAlbumDialog = groupAlbumCreateAlbumDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E9(j this$0, boolean z16, AlbumInfo albumInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RFWLog.i("QZoneIntimateSelectAlbumCreateAlbumPart", RFWLog.USR, "createAlbum, isSuccess:" + z16 + ", albumId:" + albumInfo.albumId);
        if (z16) {
            Intrinsics.checkNotNullExpressionValue(albumInfo, "albumInfo");
            this$0.broadcastMessage("ACTION_CREATE_ALBUM_SUCCEED", new vh.c(albumInfo, false, 2, null));
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String action, Object args) {
        super.handleBroadcastMessage(action, args);
        if (Intrinsics.areEqual(action, "ACTION_CREATE_ALBUM") && (args instanceof String)) {
            D9((String) args);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        GroupAlbumCreateAlbumDialog groupAlbumCreateAlbumDialog = this.createAlbumDialog;
        if (groupAlbumCreateAlbumDialog != null) {
            groupAlbumCreateAlbumDialog.dismiss();
        }
    }
}

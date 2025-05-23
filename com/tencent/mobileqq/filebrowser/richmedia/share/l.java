package com.tencent.mobileqq.filebrowser.richmedia.share;

import android.app.Activity;
import android.view.View;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.filebrowser.richmedia.share.FileShareActionManager;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.richframework.gallery.RFWLayerIOCUtil;
import com.tencent.richframework.gallery.delegate.outer.IMediaProvider;
import com.tencent.util.PermissionUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/filebrowser/richmedia/share/l;", "Lcom/tencent/mobileqq/filebrowser/richmedia/share/FileAbsShareAction;", "", "", "c", "Lcom/tencent/mobileqq/filebrowser/richmedia/share/FileShareActionManager$ShareLine;", "b", "Lcom/tencent/mobileqq/filebrowser/richmedia/share/m;", "shareContext", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "a", "<init>", "()V", "qqfile-filebrowser-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class l extends FileAbsShareAction {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/filebrowser/richmedia/share/l$a", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "qqfile-filebrowser-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FileShareContext f206047a;

        a(FileShareContext fileShareContext) {
            this.f206047a = fileShareContext;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            View decorView = this.f206047a.getActivity().getWindow().getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView, "shareContext.activity.window.decorView");
            IMediaProvider mediaProvider = RFWLayerIOCUtil.getMediaProvider(decorView);
            if (mediaProvider != null) {
                mediaProvider.saveToAlbum(this.f206047a.getLayerItemInfo());
            }
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.richmedia.share.FileAbsShareAction
    public void a(@NotNull FileShareContext shareContext, @NotNull ShareActionSheetBuilder.ActionSheetItem item) {
        String str;
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        if (!PermissionUtil.isHasStoragePermission(shareContext.getActivity()) && (shareContext.getActivity() instanceof Activity)) {
            if (shareContext.getLayerItemInfo().isVideo()) {
                str = QQPermissionConstants.Business.SCENE.RICH_MEDIA_AIO_SAVE_VIDEO;
            } else {
                str = QQPermissionConstants.Business.SCENE.RICH_MEDIA_AIO_SAVE_PIC;
            }
            QQPermissionFactory.getQQPermission(shareContext.getActivity(), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_RICH_MEDIA_SAVE, str)).requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new a(shareContext));
            return;
        }
        View decorView = shareContext.getActivity().getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "shareContext.activity.window.decorView");
        IMediaProvider mediaProvider = RFWLayerIOCUtil.getMediaProvider(decorView);
        if (mediaProvider != null) {
            mediaProvider.saveToAlbum(shareContext.getLayerItemInfo());
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.richmedia.share.FileAbsShareAction
    @NotNull
    public FileShareActionManager.ShareLine b() {
        return FileShareActionManager.ShareLine.SECOND;
    }

    @Override // com.tencent.mobileqq.filebrowser.richmedia.share.FileAbsShareAction
    @NotNull
    public List<Integer> c() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(39);
        return arrayListOf;
    }
}

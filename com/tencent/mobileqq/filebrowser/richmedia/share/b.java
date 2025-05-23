package com.tencent.mobileqq.filebrowser.richmedia.share;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.filebrowser.api.IFileShareDepend;
import com.tencent.mobileqq.filebrowser.richmedia.share.FileShareActionManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/filebrowser/richmedia/share/b;", "Lcom/tencent/mobileqq/filebrowser/richmedia/share/FileAbsShareAction;", "Lcom/tencent/mobileqq/filebrowser/richmedia/share/m;", "shareContext", "", "e", "", "", "c", "Lcom/tencent/mobileqq/filebrowser/richmedia/share/FileShareActionManager$ShareLine;", "b", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "a", "Z", "isQRCode", "<init>", "(Z)V", "qqfile-filebrowser-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class b extends FileAbsShareAction {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean isQRCode;

    public b(boolean z16) {
        this.isQRCode = z16;
    }

    @Override // com.tencent.mobileqq.filebrowser.richmedia.share.FileAbsShareAction
    public void a(@NotNull FileShareContext shareContext, @NotNull ShareActionSheetBuilder.ActionSheetItem item) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        String existSaveOrEditPath = shareContext.getLayerItemInfo().getExistSaveOrEditPath();
        if (existSaveOrEditPath != null) {
            ((IFileShareDepend) QRoute.api(IFileShareDepend.class)).createQRCodeOrLink(shareContext.getActivity(), null, existSaveOrEditPath, this.isQRCode);
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
        int i3;
        List<Integer> listOf;
        if (this.isQRCode) {
            i3 = 123;
        } else {
            i3 = 122;
        }
        listOf = CollectionsKt__CollectionsJVMKt.listOf(Integer.valueOf(i3));
        return listOf;
    }

    @Override // com.tencent.mobileqq.filebrowser.richmedia.share.FileAbsShareAction
    public boolean e(@NotNull FileShareContext shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        return !TextUtils.isEmpty(shareContext.getLayerItemInfo().getExistSaveOrEditPath());
    }
}

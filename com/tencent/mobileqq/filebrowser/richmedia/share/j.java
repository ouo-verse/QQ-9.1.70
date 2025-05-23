package com.tencent.mobileqq.filebrowser.richmedia.share;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.filebrowser.richmedia.share.FileShareActionManager;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/filebrowser/richmedia/share/j;", "Lcom/tencent/mobileqq/filebrowser/richmedia/share/FileAbsShareAction;", "", "", "c", "Lcom/tencent/mobileqq/filebrowser/richmedia/share/FileShareActionManager$ShareLine;", "b", "Lcom/tencent/mobileqq/filebrowser/richmedia/share/m;", "shareContext", "", "e", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "a", "<init>", "()V", "qqfile-filebrowser-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class j extends FileAbsShareAction {
    @Override // com.tencent.mobileqq.filebrowser.richmedia.share.FileAbsShareAction
    public void a(@NotNull FileShareContext shareContext, @NotNull ShareActionSheetBuilder.ActionSheetItem item) {
        com.tencent.mobileqq.richmedia.depend.f fVar;
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        if (!TextUtils.isEmpty(shareContext.getLayerItemInfo().getMediaId())) {
            com.tencent.mobileqq.richmedia.e eVar = com.tencent.mobileqq.richmedia.e.f281568a;
            String name = com.tencent.mobileqq.richmedia.depend.f.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "IShareActionDepend::class.java.name");
            com.tencent.mobileqq.richmedia.depend.c d16 = eVar.d(name);
            if (d16 instanceof com.tencent.mobileqq.richmedia.depend.f) {
                fVar = (com.tencent.mobileqq.richmedia.depend.f) d16;
            } else {
                fVar = null;
            }
            if (fVar != null) {
                Activity activity = shareContext.getActivity();
                String mediaId = shareContext.getLayerItemInfo().getMediaId();
                Intrinsics.checkNotNull(mediaId);
                fVar.R1(activity, mediaId);
            }
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
        List<Integer> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(121);
        return listOf;
    }

    @Override // com.tencent.mobileqq.filebrowser.richmedia.share.FileAbsShareAction
    public boolean e(@NotNull FileShareContext shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        return !shareContext.getLayerItemInfo().isVideo();
    }
}

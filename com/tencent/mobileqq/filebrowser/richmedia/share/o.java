package com.tencent.mobileqq.filebrowser.richmedia.share;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.filebrowser.richmedia.share.FileShareActionManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.api.IBrowserDepend;
import com.tencent.mobileqq.richmediabrowser.api.IFileDepend;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \u00062\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/filebrowser/richmedia/share/o;", "Lcom/tencent/mobileqq/filebrowser/richmedia/share/FileAbsShareAction;", "", "", "c", "Lcom/tencent/mobileqq/filebrowser/richmedia/share/FileShareActionManager$ShareLine;", "b", "Lcom/tencent/mobileqq/filebrowser/richmedia/share/m;", "shareContext", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "a", "<init>", "()V", "qqfile-filebrowser-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public class o extends FileAbsShareAction {
    @Override // com.tencent.mobileqq.filebrowser.richmedia.share.FileAbsShareAction
    public void a(@NotNull FileShareContext shareContext, @NotNull ShareActionSheetBuilder.ActionSheetItem item) {
        com.tencent.mobileqq.richmedia.depend.f fVar;
        boolean z16;
        com.tencent.mobileqq.richmedia.depend.f fVar2;
        boolean z17;
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        if (TextUtils.isEmpty(shareContext.getLayerItemInfo().getMediaId())) {
            QLog.i("FileShareToQQFriendAction", 1, "FileShareToQQFriendAction mediaId is null!");
            return;
        }
        com.tencent.mobileqq.richmedia.e eVar = com.tencent.mobileqq.richmedia.e.f281568a;
        String name = com.tencent.mobileqq.richmedia.depend.f.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "IShareActionDepend::class.java.name");
        com.tencent.mobileqq.richmedia.depend.c d16 = eVar.d(name);
        int i3 = item.action;
        Intent intent = null;
        if (i3 != 2) {
            if (i3 != 72) {
                if (i3 != 73) {
                    return;
                }
            } else {
                if (d16 instanceof com.tencent.mobileqq.richmedia.depend.f) {
                    fVar2 = (com.tencent.mobileqq.richmedia.depend.f) d16;
                } else {
                    fVar2 = null;
                }
                if (fVar2 != null) {
                    String mediaId = shareContext.getLayerItemInfo().getMediaId();
                    Intrinsics.checkNotNull(mediaId);
                    intent = fVar2.s3(mediaId);
                }
                Intent intent2 = intent;
                if (intent2 != null) {
                    IFileDepend iFileDepend = (IFileDepend) QRoute.api(IFileDepend.class);
                    Activity activity = shareContext.getActivity();
                    int i16 = item.uinType;
                    if (i16 == 1) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    iFileDepend.forwardToTargetFriend(activity, intent2, z17, item.uin, i16);
                    return;
                }
                return;
            }
        }
        if (d16 instanceof com.tencent.mobileqq.richmedia.depend.f) {
            fVar = (com.tencent.mobileqq.richmedia.depend.f) d16;
        } else {
            fVar = null;
        }
        if (fVar != null) {
            String mediaId2 = shareContext.getLayerItemInfo().getMediaId();
            Intrinsics.checkNotNull(mediaId2);
            intent = fVar.s3(mediaId2);
        }
        Intent intent3 = intent;
        if (intent3 != null) {
            IBrowserDepend iBrowserDepend = (IBrowserDepend) QRoute.api(IBrowserDepend.class);
            Activity activity2 = shareContext.getActivity();
            if (item.uinType == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            iBrowserDepend.forwardToFriend(activity2, intent3, z16, BusinessInfoCheckUpdateItem.UIAPPID_CUKING_CARD, "");
        }
    }

    @Override // com.tencent.mobileqq.filebrowser.richmedia.share.FileAbsShareAction
    @NotNull
    public FileShareActionManager.ShareLine b() {
        return FileShareActionManager.ShareLine.FIRST;
    }

    @Override // com.tencent.mobileqq.filebrowser.richmedia.share.FileAbsShareAction
    @NotNull
    public List<Integer> c() {
        List<Integer> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(2);
        return listOf;
    }
}

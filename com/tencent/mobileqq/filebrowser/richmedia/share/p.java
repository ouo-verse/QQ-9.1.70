package com.tencent.mobileqq.filebrowser.richmedia.share;

import android.graphics.BitmapFactory;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.filebrowser.api.IFileShareDepend;
import com.tencent.mobileqq.filebrowser.richmedia.share.FileShareActionManager;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.flashtransfer.api.IFlashTransferApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/filebrowser/richmedia/share/p;", "Lcom/tencent/mobileqq/filebrowser/richmedia/share/FileAbsShareAction;", "", "", "c", "Lcom/tencent/mobileqq/filebrowser/richmedia/share/FileShareActionManager$ShareLine;", "b", "Lcom/tencent/mobileqq/filebrowser/richmedia/share/m;", "shareContext", "", "e", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "a", "<init>", "()V", "qqfile-filebrowser-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class p extends FileAbsShareAction {
    @Override // com.tencent.mobileqq.filebrowser.richmedia.share.FileAbsShareAction
    public void a(@NotNull FileShareContext shareContext, @NotNull ShareActionSheetBuilder.ActionSheetItem item) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        String existSaveOrEditPath = shareContext.getLayerItemInfo().getExistSaveOrEditPath();
        if (existSaveOrEditPath != null) {
            if (com.tencent.mobileqq.filemanager.util.q.m(existSaveOrEditPath) <= 10485760) {
                WXShareHelper.b0().t0(existSaveOrEditPath, BitmapFactory.decodeResource(shareContext.getActivity().getResources(), ah.f0(existSaveOrEditPath)));
            } else if (((IFlashTransferApi) QRoute.api(IFlashTransferApi.class)).isFlashTransferFile(shareContext.getLayerItemInfo().getExistSaveOrEditPath())) {
                QQToast.makeText(shareContext.getActivity(), 1, ((IFlashTransferApi) QRoute.api(IFlashTransferApi.class)).getShareWeChatOverSizeResId(shareContext.getLayerItemInfo().getExistSaveOrEditPath()), 0).show();
            } else {
                FMDialogUtil.b(shareContext.getActivity(), "", R.string.zzc, new a(shareContext, existSaveOrEditPath));
            }
        }
        ReportController.o(null, "dc00898", "", "", "0X800A4FF", "0X800A4FF", 0, 0, "", "", "", "");
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
        listOf = CollectionsKt__CollectionsJVMKt.listOf(9);
        return listOf;
    }

    @Override // com.tencent.mobileqq.filebrowser.richmedia.share.FileAbsShareAction
    public boolean e(@NotNull FileShareContext shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        if (!WXShareHelper.b0().e0() || !shareContext.getActivity().getIntent().getBooleanExtra("is_share_to_wx", false)) {
            return false;
        }
        return true;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/filebrowser/richmedia/share/p$a", "Lcom/tencent/mobileqq/filemanager/util/FMDialogUtil$c;", "", "b", "a", "qqfile-filebrowser-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a implements FMDialogUtil.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FileShareContext f206053a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f206054b;

        a(FileShareContext fileShareContext, String str) {
            this.f206053a = fileShareContext;
            this.f206054b = str;
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void b() {
            ReportController.o(null, "dc00898", "", "", "0X800AEE3", "0X800AEE3", 0, 0, "", "", "", "");
            ((IFileShareDepend) QRoute.api(IFileShareDepend.class)).createQRCodeOrLink(this.f206053a.getActivity(), null, this.f206054b, false);
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void a() {
        }
    }
}

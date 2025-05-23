package com.tencent.qqnt.aio.gallery.share;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanageraux.link.LinkByWeiyunFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qqnt.aio.gallery.share.NTShareActionManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/share/ab;", "Lcom/tencent/qqnt/aio/gallery/share/a;", "Lcom/tencent/qqnt/aio/gallery/share/s;", "shareContext", "", "g", "", "", "e", "Lcom/tencent/qqnt/aio/gallery/share/NTShareActionManager$ShareLine;", "d", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "b", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ab extends com.tencent.qqnt.aio.gallery.share.a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/qqnt/aio/gallery/share/ab$a", "Lcom/tencent/mobileqq/filemanager/util/FMDialogUtil$c;", "", "b", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements FMDialogUtil.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ NTShareContext f350170a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f350171b;

        a(NTShareContext nTShareContext, String str) {
            this.f350170a = nTShareContext;
            this.f350171b = str;
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void b() {
            ReportController.o(null, "dc00898", "", "", "0X800AEE3", "0X800AEE3", 0, 0, "", "", "", "");
            LinkByWeiyunFragment.th(this.f350170a.getActivity(), null, this.f350171b, false);
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void a() {
        }
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public NTShareActionManager.ShareLine d() {
        return NTShareActionManager.ShareLine.FIRST;
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public boolean g(NTShareContext shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        return !TextUtils.isEmpty(shareContext.getExistSaveOrEditPath()) && WXShareHelper.b0().e0();
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public void b(NTShareContext shareContext, ShareActionSheetBuilder.ActionSheetItem item) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        ReportController.o(null, "dc00898", "", "", "0X800AEE0", "0X800AEE0", 0, 0, "", "", "", "");
        String existSaveOrEditPath = shareContext.getLayerItemInfo().getExistSaveOrEditPath();
        if (existSaveOrEditPath == null) {
            existSaveOrEditPath = "";
        }
        long m3 = com.tencent.mobileqq.filemanager.util.q.m(existSaveOrEditPath);
        WXShareHelper b06 = WXShareHelper.b0();
        if (m3 <= 10485760) {
            b06.t0(existSaveOrEditPath, BitmapFactory.decodeResource(shareContext.getActivity().getResources(), FileManagerUtil.getFileIconResId(existSaveOrEditPath)));
            ReportController.o(null, "dc00898", "", "", "0X800AEE1", "0X800AEE1", 0, 0, "", "", "", "");
        } else {
            ReportController.o(null, "dc00898", "", "", "0X800AEE2", "0X800AEE2", 0, 0, "", "", "", "");
            FMDialogUtil.b(shareContext.getActivity(), "", R.string.f187243tg, new a(shareContext, existSaveOrEditPath));
        }
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public List<Integer> e() {
        List<Integer> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(9);
        return listOf;
    }
}

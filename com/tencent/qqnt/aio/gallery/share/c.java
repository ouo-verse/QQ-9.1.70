package com.tencent.qqnt.aio.gallery.share;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.filemanageraux.link.LinkByWeiyunFragment;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qqnt.aio.gallery.share.NTShareActionManager;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/share/c;", "Lcom/tencent/qqnt/aio/gallery/share/a;", "Lcom/tencent/qqnt/aio/gallery/share/s;", "shareContext", "", "g", "", "", "e", "Lcom/tencent/qqnt/aio/gallery/share/NTShareActionManager$ShareLine;", "d", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "b", "a", "Z", "isQRCode", "<init>", "(Z)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class c extends com.tencent.qqnt.aio.gallery.share.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean isQRCode;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(((MsgElement) t16).fileElement.fileGroupIndex, ((MsgElement) t17).fileElement.fileGroupIndex);
            return compareValues;
        }
    }

    public c(boolean z16) {
        this.isQRCode = z16;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004f  */
    @Override // com.tencent.qqnt.aio.gallery.share.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(NTShareContext shareContext, ShareActionSheetBuilder.ActionSheetItem item) {
        int i3;
        List sortedWith;
        MsgElement msgElement;
        Object first;
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        MsgRecord msgRecord = shareContext.getMsgRecord();
        if (msgRecord != null) {
            if (shareContext.f() != null) {
                Pair<Long, Integer> f16 = shareContext.f();
                Intrinsics.checkNotNull(f16);
                if (f16.getSecond().intValue() > 0) {
                    Pair<Long, Integer> f17 = shareContext.f();
                    Intrinsics.checkNotNull(f17);
                    i3 = f17.getSecond().intValue();
                    if (i3 != 0) {
                        ArrayList<MsgElement> arrayList = msgRecord.elements;
                        Intrinsics.checkNotNullExpressionValue(arrayList, "it.elements");
                        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
                        msgElement = (MsgElement) first;
                    } else {
                        ArrayList<MsgElement> arrayList2 = msgRecord.elements;
                        Intrinsics.checkNotNullExpressionValue(arrayList2, "it.elements");
                        sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList2, new a());
                        msgElement = (MsgElement) sortedWith.get(i3);
                    }
                    LinkByWeiyunFragment.th(shareContext.getActivity(), null, msgElement.fileElement.filePath, this.isQRCode);
                }
            }
            i3 = 0;
            if (i3 != 0) {
            }
            LinkByWeiyunFragment.th(shareContext.getActivity(), null, msgElement.fileElement.filePath, this.isQRCode);
        }
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public NTShareActionManager.ShareLine d() {
        return NTShareActionManager.ShareLine.SECOND;
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public List<Integer> e() {
        List<Integer> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(Integer.valueOf(this.isQRCode ? 123 : 122));
        return listOf;
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public boolean g(NTShareContext shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        return shareContext.getMediaType() == 2 || shareContext.getMediaType() == 4;
    }
}

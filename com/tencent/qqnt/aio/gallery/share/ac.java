package com.tencent.qqnt.aio.gallery.share;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qqnt.aio.gallery.share.NTShareActionManager;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.qqnt.kernel.nativeinterface.VideoElement;
import cooperation.weiyun.WeiyunAIOUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0016J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/share/ac;", "Lcom/tencent/qqnt/aio/gallery/share/a;", "", "str", "", "i", "Lcom/tencent/qqnt/aio/gallery/share/s;", "shareContext", "", "j", "g", "", "", "e", "Lcom/tencent/qqnt/aio/gallery/share/NTShareActionManager$ShareLine;", "d", "c", "a", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "b", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public class ac extends a {
    private final void j(NTShareContext shareContext) {
        AppRuntime peekAppRuntime;
        List listOf;
        if (shareContext.getMsgRecord() == null || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null || !(peekAppRuntime instanceof QQAppInterface)) {
            return;
        }
        Resources resources = shareContext.getActivity().getResources();
        int dimensionPixelSize = resources != null ? resources.getDimensionPixelSize(R.dimen.title_bar_height) : 0;
        QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
        Activity activity = shareContext.getActivity();
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new AIOMsgItem(shareContext.getMsgRecord()));
        Pair<Long, Integer> a16 = com.tencent.qqnt.aio.gallery.h.f350002a.a(shareContext.getLayerItemInfo());
        WeiyunAIOUtils.t(qQAppInterface, activity, dimensionPixelSize, listOf, a16 != null ? a16.getSecond().intValue() : 0);
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public void a(NTShareContext shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        j(shareContext);
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public void b(NTShareContext shareContext, ShareActionSheetBuilder.ActionSheetItem item) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        j(shareContext);
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public List<String> c() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf("weiyun");
        return listOf;
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public NTShareActionManager.ShareLine d() {
        return NTShareActionManager.ShareLine.FIRST;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0032, code lost:
    
        if (r4 == null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0035, code lost:
    
        r3 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x005d, code lost:
    
        if (r4 == null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0078, code lost:
    
        if (r4 == null) goto L46;
     */
    @Override // com.tencent.qqnt.aio.gallery.share.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean g(NTShareContext shareContext) {
        ArrayList<MsgElement> arrayList;
        MsgElement msgElement;
        PicElement picElement;
        MsgElement msgElement2;
        VideoElement videoElement;
        MsgElement msgElement3;
        FileElement fileElement;
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        MsgRecord msgRecord = shareContext.getMsgRecord();
        String str = "";
        String str2 = null;
        if (msgRecord != null && msgRecord.msgType == 3) {
            ArrayList<MsgElement> arrayList2 = shareContext.getMsgRecord().elements;
            if (arrayList2 != null && (msgElement3 = arrayList2.get(0)) != null && (fileElement = msgElement3.fileElement) != null) {
                str2 = fileElement.fileUuid;
            }
        } else {
            MsgRecord msgRecord2 = shareContext.getMsgRecord();
            if (msgRecord2 != null && msgRecord2.msgType == 7) {
                ArrayList<MsgElement> arrayList3 = shareContext.getMsgRecord().elements;
                if (arrayList3 != null && (msgElement2 = arrayList3.get(0)) != null && (videoElement = msgElement2.videoElement) != null) {
                    str2 = videoElement.fileUuid;
                }
            } else {
                MsgRecord msgRecord3 = shareContext.getMsgRecord();
                if (msgRecord3 != null && (arrayList = msgRecord3.elements) != null && (msgElement = arrayList.get(0)) != null && (picElement = msgElement.picElement) != null) {
                    str2 = picElement.fileUuid;
                }
            }
        }
        boolean i3 = i(str);
        if (!TextUtils.isEmpty(shareContext.getExistSaveOrEditPath()) && i3) {
            if (str.length() > 0) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public List<Integer> e() {
        List<Integer> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(27);
        return listOf;
    }

    private final boolean i(String str) {
        if (str == null) {
            return false;
        }
        for (int i3 = 0; i3 < str.length(); i3++) {
            if (!Character.isDigit(str.charAt(i3))) {
                return false;
            }
        }
        return true;
    }
}

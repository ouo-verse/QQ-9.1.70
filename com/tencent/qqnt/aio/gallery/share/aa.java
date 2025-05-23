package com.tencent.qqnt.aio.gallery.share;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.RichMediaBrowserConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.gallery.share.NTShareActionManager;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\tH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/share/aa;", "Lcom/tencent/qqnt/aio/gallery/share/a;", "Lcom/tencent/qqnt/aio/gallery/share/s;", "shareContext", "", "i", "j", "", "g", "", "", "e", "Lcom/tencent/qqnt/aio/gallery/share/NTShareActionManager$ShareLine;", "d", "", "c", "a", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "b", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public class aa extends a {
    private final void i(NTShareContext shareContext) {
        if (shareContext.getMediaType() == 1) {
            j(shareContext);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x006c, code lost:
    
        if (r7 == null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007f, code lost:
    
        r10 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007d, code lost:
    
        r10 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x007b, code lost:
    
        if (r7 == null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0045, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void j(NTShareContext shareContext) {
        PicElement picElement;
        String str;
        PicElement picElement2;
        PicElement picElement3;
        Long longOrNull;
        if (shareContext.getActivity().getIntent().getExtras() != null) {
            Bundle extras = shareContext.getActivity().getIntent().getExtras();
            Intrinsics.checkNotNull(extras);
            int i3 = extras.getInt(RichMediaBrowserConstants.EXTRA_FORWARD_TO_QZONE_SRC, 1);
            QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
            userInfo.qzone_uin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin();
            MsgElement targetElement = shareContext.getTargetElement();
            long longValue = (targetElement == null || (picElement3 = targetElement.picElement) == null || (r0 = picElement3.fileUuid) == null || longOrNull == null) ? 0L : longOrNull.longValue();
            boolean z16 = longValue != 0;
            String str2 = null;
            if (z16) {
                MsgElement targetElement2 = shareContext.getTargetElement();
                if (targetElement2 != null && (picElement2 = targetElement2.picElement) != null) {
                    str2 = picElement2.fileName;
                }
            } else {
                MsgElement targetElement3 = shareContext.getTargetElement();
                if (targetElement3 != null && (picElement = targetElement3.picElement) != null) {
                    str2 = picElement.fileUuid;
                }
            }
            if (str.length() == 0) {
                QLog.e("NTShareToQZoneAlbumAction", 1, "fileUUid is empty");
                return;
            }
            Activity activity = shareContext.getActivity();
            String i16 = com.tencent.mobileqq.richmediabrowser.h.a().i();
            String h16 = com.tencent.mobileqq.richmediabrowser.h.a().h();
            String existSaveOrEditPath = shareContext.getLayerItemInfo().getExistSaveOrEditPath();
            MsgRecord msgRecord = shareContext.getMsgRecord();
            QZoneHelper.forwardToQzoneAlbum(activity, userInfo, z16, i16, h16, i3, existSaveOrEditPath, str, msgRecord != null ? msgRecord.msgTime : 0L, longValue, -1);
        }
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public void a(NTShareContext shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        i(shareContext);
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public void b(NTShareContext shareContext, ShareActionSheetBuilder.ActionSheetItem item) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        i(shareContext);
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public List<String> c() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(QCircleScheme.AttrQQPublish.PICKER_QZONE_ALBUM);
        return listOf;
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public NTShareActionManager.ShareLine d() {
        return NTShareActionManager.ShareLine.FIRST;
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public boolean g(NTShareContext shareContext) {
        PicElement picElement;
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        if (shareContext.getMediaType() != 1) {
            return false;
        }
        MsgElement targetElement = shareContext.getTargetElement();
        String str = (targetElement == null || (picElement = targetElement.picElement) == null) ? null : picElement.fileUuid;
        return ((str == null || str.length() == 0) || TextUtils.isEmpty(shareContext.getExistSaveOrEditPath())) ? false : true;
    }

    @Override // com.tencent.qqnt.aio.gallery.share.a
    public List<Integer> e() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(50);
        return arrayListOf;
    }
}

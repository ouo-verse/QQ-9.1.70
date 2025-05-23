package com.tencent.mobileqq.filebrowser.richmedia.share;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.filebrowser.richmedia.share.FileShareActionManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.richframework.gallery.RFWLayerIOCUtil;
import com.tencent.richframework.gallery.bean.RFWLayerVideoInfo;
import com.tencent.richframework.gallery.delegate.inner.IVideoPlayerProvider;
import com.tencent.richframework.video.RFWPlayerVideoInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/filebrowser/richmedia/share/d;", "Lcom/tencent/mobileqq/filebrowser/richmedia/share/FileAbsShareAction;", "", "", "c", "Lcom/tencent/mobileqq/filebrowser/richmedia/share/FileShareActionManager$ShareLine;", "b", "Lcom/tencent/mobileqq/filebrowser/richmedia/share/m;", "shareContext", "", "e", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "a", "<init>", "()V", "qqfile-filebrowser-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class d extends FileAbsShareAction {
    @Override // com.tencent.mobileqq.filebrowser.richmedia.share.FileAbsShareAction
    public void a(@NotNull FileShareContext shareContext, @NotNull ShareActionSheetBuilder.ActionSheetItem item) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        if (shareContext.getLayerItemInfo().isVideo()) {
            View decorView = shareContext.getActivity().getWindow().getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView, "shareContext.activity.window.decorView");
            IVideoPlayerProvider videoControlProvider = RFWLayerIOCUtil.getVideoControlProvider(decorView);
            if (videoControlProvider != null && videoControlProvider.getInnerCurrentPlayInfo() != null) {
                BaseApplication context = BaseApplication.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext()");
                hm2.b bVar = new hm2.b(context);
                RFWPlayerVideoInfo innerCurrentPlayInfo = videoControlProvider.getInnerCurrentPlayInfo();
                Intrinsics.checkNotNull(innerCurrentPlayInfo);
                bVar.w(innerCurrentPlayInfo);
                Drawable coverDrawable = videoControlProvider.getCoverDrawable();
                RFWLayerVideoInfo layerVideoInfo = shareContext.getLayerItemInfo().getLayerVideoInfo();
                Intrinsics.checkNotNull(layerVideoInfo);
                int videoWidth = layerVideoInfo.getVideoWidth();
                RFWLayerVideoInfo layerVideoInfo2 = shareContext.getLayerItemInfo().getLayerVideoInfo();
                Intrinsics.checkNotNull(layerVideoInfo2);
                bVar.u(coverDrawable, videoWidth, layerVideoInfo2.getVideoHeight());
                Activity activity = shareContext.getActivity();
                int i3 = item.uinType;
                RFWLayerVideoInfo layerVideoInfo3 = shareContext.getLayerItemInfo().getLayerVideoInfo();
                Intrinsics.checkNotNull(layerVideoInfo3);
                int videoWidth2 = layerVideoInfo3.getVideoWidth();
                RFWLayerVideoInfo layerVideoInfo4 = shareContext.getLayerItemInfo().getLayerVideoInfo();
                Intrinsics.checkNotNull(layerVideoInfo4);
                if (bVar.s(activity, i3, videoWidth2, layerVideoInfo4.getVideoHeight())) {
                    shareContext.getActivity().finish();
                }
            }
            ReportController.o(null, "dc00898", "", "", "0X800C493", "0X800C493", 5, 0, "", "2", "", "");
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
        listOf = CollectionsKt__CollectionsJVMKt.listOf(179);
        return listOf;
    }

    @Override // com.tencent.mobileqq.filebrowser.richmedia.share.FileAbsShareAction
    public boolean e(@NotNull FileShareContext shareContext) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        if (shareContext.getLayerItemInfo().isVideo()) {
            mb1.a aVar = mb1.a.f416517a;
            RFWLayerVideoInfo layerVideoInfo = shareContext.getLayerItemInfo().getLayerVideoInfo();
            Intrinsics.checkNotNull(layerVideoInfo);
            if (!TextUtils.isEmpty(aVar.j(layerVideoInfo))) {
                return true;
            }
        }
        return false;
    }
}

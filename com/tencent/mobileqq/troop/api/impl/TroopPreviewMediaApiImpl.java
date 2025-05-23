package com.tencent.mobileqq.troop.api.impl;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.api.ITroopPreviewMediaApi;
import com.tencent.mobileqq.troop.teamup.preview.fragment.TroopPreviewLayerFragment;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.gallery.QQGalleryActivity;
import com.tencent.richframework.gallery.RFWLayerLaunchUtil;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fH\u0016J0\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\b2\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00110\nj\b\u0012\u0004\u0012\u00020\u0011`\fH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/troop/api/impl/TroopPreviewMediaApiImpl;", "Lcom/tencent/mobileqq/troop/api/ITroopPreviewMediaApi;", "()V", "jumpToGallery", "", "context", "Landroid/content/Context;", "index", "", "mediaList", "Ljava/util/ArrayList;", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "Lkotlin/collections/ArrayList;", "showPicture", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "pathList", "", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class TroopPreviewMediaApiImpl implements ITroopPreviewMediaApi {
    static IPatchRedirector $redirector_;

    public TroopPreviewMediaApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopPreviewMediaApi
    public void jumpToGallery(@NotNull Context context, int index, @NotNull ArrayList<RFWLayerItemMediaInfo> mediaList) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, Integer.valueOf(index), mediaList);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        if (index >= mediaList.size()) {
            i3 = 0;
        } else {
            i3 = index;
        }
        RFWLayerLaunchUtil.jumpToGallery$default(context, null, mediaList, i3, QQGalleryActivity.class, TroopPreviewLayerFragment.class, null, 0, 128, null);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopPreviewMediaApi
    public void showPicture(@NotNull Activity activity, int index, @NotNull ArrayList<String> pathList) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, activity, Integer.valueOf(index), pathList);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(pathList, "pathList");
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = pathList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo = new RFWLayerItemMediaInfo();
            RFWLayerPicInfo rFWLayerPicInfo = new RFWLayerPicInfo();
            RFWLayerPicInfo.RFWPicInfo rFWPicInfo = new RFWLayerPicInfo.RFWPicInfo();
            rFWPicInfo.setUrl(next);
            rFWLayerPicInfo.setCurrentPicInfo(rFWPicInfo);
            rFWLayerPicInfo.setBigPicInfo(rFWLayerPicInfo.getCurrentPicInfo());
            rFWLayerPicInfo.setOriginPicInfo(rFWLayerPicInfo.getCurrentPicInfo());
            rFWLayerPicInfo.setSmallPicInfo(rFWLayerPicInfo.getCurrentPicInfo());
            rFWLayerItemMediaInfo.setLayerPicInfo(rFWLayerPicInfo);
            arrayList.add(rFWLayerItemMediaInfo);
        }
        if (index >= pathList.size()) {
            i3 = 0;
        } else {
            i3 = index;
        }
        RFWLayerLaunchUtil.jumpToGallery$default(activity, null, arrayList, i3, QQGalleryActivity.class, TroopPreviewLayerFragment.class, null, 0, 128, null);
    }
}

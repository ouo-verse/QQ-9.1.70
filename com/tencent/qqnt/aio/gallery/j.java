package com.tencent.qqnt.aio.gallery;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.aio.utils.aj;
import com.tencent.mobileqq.guild.temp.api.impl.GuildGalleryApiImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.sharepanel.api.ISharePanelApi;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.richframework.data.idata.IDataStore;
import com.tencent.richframework.gallery.datacenter.RFWLayerDataCenter;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002J\u0014\u0010\u0011\u001a\u00020\u00102\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000eJ\u0016\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/j;", "", "", "path", "", "a", WadlProxyConsts.SCENE_ID, "c", "Lcom/tencent/qqnt/kernel/nativeinterface/PicElement;", "picElement", "d", "mediaId", "Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;", "b", "", "aioRichMediaDataList", "", "f", "isUseNewShare", "g", "", "mediaType", "e", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final j f350008a = new j();

    j() {
    }

    private final boolean a(String path) {
        if (TextUtils.isEmpty(path)) {
            return false;
        }
        return new File(path).exists();
    }

    private final boolean c(String sceneId) {
        return ((ISharePanelApi) QRoute.api(ISharePanelApi.class)).useNewSharePanel(sceneId);
    }

    public final AIORichMediaData b(String mediaId) {
        IDataStore iDataStore = RFWLayerDataCenter.INSTANCE.getAllDataStore().get(GuildGalleryApiImpl.AIO_RICH_MEDIA_DATA_KEY);
        g gVar = iDataStore instanceof g ? (g) iDataStore : null;
        if (gVar != null) {
            return gVar.getData(mediaId);
        }
        return null;
    }

    public final void f(List<? extends AIORichMediaData> aioRichMediaDataList) {
        Intrinsics.checkNotNullParameter(aioRichMediaDataList, "aioRichMediaDataList");
        IDataStore iDataStore = RFWLayerDataCenter.INSTANCE.getAllDataStore().get(GuildGalleryApiImpl.AIO_RICH_MEDIA_DATA_KEY);
        g gVar = iDataStore instanceof g ? (g) iDataStore : null;
        for (AIORichMediaData aIORichMediaData : aioRichMediaDataList) {
            if ((gVar != null ? gVar.getData(h.f350002a.b(aIORichMediaData)) : null) == null && gVar != null) {
                gVar.addData(aIORichMediaData);
            }
        }
    }

    public final boolean g(boolean isUseNewShare, String sceneId) {
        Intrinsics.checkNotNullParameter(sceneId, "sceneId");
        return isUseNewShare && c(sceneId);
    }

    public final String d(PicElement picElement) {
        if (picElement == null) {
            return null;
        }
        String a16 = aj.a(picElement);
        if (a(a16)) {
            return a16;
        }
        String b16 = aj.b(picElement, 0);
        if (a(b16)) {
            return b16;
        }
        String b17 = aj.b(picElement, 720);
        if (a(b17)) {
            return b17;
        }
        String b18 = aj.b(picElement, 198);
        if (a(b18)) {
            return b18;
        }
        return null;
    }

    public final String e(int mediaType) {
        if (mediaType == 1) {
            return "mediamessage_picture";
        }
        if (mediaType == 2) {
            return "mediamessage_filepicture";
        }
        if (mediaType == 3) {
            return "mediamessage_video";
        }
        if (mediaType != 4) {
            return "";
        }
        return "mediamessage_filevideo";
    }
}

package com.qzone.reborn.albumx.common.viewmodel;

import com.tencent.biz.richframework.queue.RFWDownloadTaskStateData;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u000e\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/biz/richframework/queue/RFWDownloadTaskStateData;", "", "a", "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class f {
    public static final String a(RFWDownloadTaskStateData rFWDownloadTaskStateData) {
        if (rFWDownloadTaskStateData == null || rFWDownloadTaskStateData.getExtMap() == null) {
            return null;
        }
        return rFWDownloadTaskStateData.getExtMap().get("CommonAlbumOperateViewModel_ext_key_download_batch_id");
    }
}

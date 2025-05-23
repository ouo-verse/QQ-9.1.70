package com.tencent.mobileqq.zootopia.ipc;

import com.tencent.mobileqq.zootopia.video.ZootopiaVideoCutApiImpl;
import com.tencent.mobileqq.zplan.ipc.annotation.ServletImpl;
import java.util.HashMap;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J8\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022&\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0005H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ipc/ak;", "", "", "videoPath", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "extraInfo", "", "jumpToVideoCutPage", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
@ServletImpl(impl = ZootopiaVideoCutApiImpl.class)
/* loaded from: classes35.dex */
public interface ak {
    void jumpToVideoCutPage(String videoPath, HashMap<String, String> extraInfo);
}

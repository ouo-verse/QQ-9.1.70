package com.tencent.mobileqq.kandian.biz.video.api.impl;

import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoR5BuilderFactory;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import f62.c;
import kotlin.Metadata;
import r62.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ0\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/video/api/impl/VideoR5BuilderFactoryImpl;", "Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoR5BuilderFactory;", "", "md5", IPublicAccountBrowser.KEY_PUB_UIN, "vid", "aid", "Lf62/c;", OperateCustomButton.OPERATE_CREATE, "<init>", "()V", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class VideoR5BuilderFactoryImpl implements IVideoR5BuilderFactory {
    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoR5BuilderFactory
    public c create(String md5, String puin, String vid, String aid) {
        return new b.a(md5, puin, vid, aid);
    }
}

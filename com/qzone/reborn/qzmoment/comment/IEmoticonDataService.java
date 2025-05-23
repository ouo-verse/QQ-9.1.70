package com.qzone.reborn.qzmoment.comment;

import com.tencent.mobileqq.emoticon.data.EmoticonTabInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {"all"})
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001:\u0001\u000bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\f"}, d2 = {"Lcom/qzone/reborn/qzmoment/comment/IEmoticonDataService;", "Lmqq/app/api/IRuntimeService;", "", "tabType", "Lcom/qzone/reborn/qzmoment/comment/IEmoticonDataService$a;", "callback", "", "updateEmoticonInfo", "", "Lcom/tencent/mobileqq/emoticon/data/EmoticonTabInfo;", "getEmoticonTabInfo", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public interface IEmoticonDataService extends IRuntimeService {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/qzone/reborn/qzmoment/comment/IEmoticonDataService$a;", "", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public interface a {
    }

    List<EmoticonTabInfo> getEmoticonTabInfo(int tabType);

    void updateEmoticonInfo(int tabType, a callback);
}

package com.tencent.mobileqq.emoticon.data.api;

import com.tencent.mobileqq.emoticon.data.EmoticonTabInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Service(process = {"all"})
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u000bJ\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/emoticon/data/api/IEmoticonDataService;", "Lmqq/app/api/IRuntimeService;", "getEmoticonTabInfo", "", "Lcom/tencent/mobileqq/emoticon/data/EmoticonTabInfo;", "tabType", "", "updateEmoticonInfo", "", "callback", "Lcom/tencent/mobileqq/emoticon/data/api/IEmoticonDataService$UpdateEmoticonInfoCallback;", "UpdateEmoticonInfoCallback", "qqemoticondata-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public interface IEmoticonDataService extends IRuntimeService {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/emoticon/data/api/IEmoticonDataService$UpdateEmoticonInfoCallback;", "", "onComplete", "", "success", "", "tabInfoList", "", "Lcom/tencent/mobileqq/emoticon/data/EmoticonTabInfo;", "qqemoticondata-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public interface UpdateEmoticonInfoCallback {
        void onComplete(boolean success, @NotNull List<? extends EmoticonTabInfo> tabInfoList);
    }

    @NotNull
    List<EmoticonTabInfo> getEmoticonTabInfo(int tabType);

    void updateEmoticonInfo(int tabType, @NotNull UpdateEmoticonInfoCallback callback);
}

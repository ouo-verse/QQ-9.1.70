package com.tencent.mobileqq.qcircle.api;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.HashMap;
import java.util.List;
import mqq.app.api.IRuntimeService;
import qqcircle.QQCircleMainPageProfile$GetQQProfileFeedListRsp;

/* compiled from: P */
@Service(needUin = false, process = {"all"})
/* loaded from: classes16.dex */
public interface IQCircleService extends IRuntimeService {
    boolean canJumpBySchema(String str);

    void downloadSkinPackage(String str);

    void enterByScheme(Context context, String str);

    void enterBySchemeAction(Context context, String str, @NonNull HashMap<String, String> hashMap);

    void enterBySchemeAction(Context context, String str, @NonNull HashMap<String, String> hashMap, @Nullable HashMap<String, byte[]> hashMap2);

    void enterBySchemeSourceAction(Context context, String str, HashMap<String, String> hashMap, List<String> list);

    String fetchSchemaFromUrl(String str);

    void refreshMainPageFeed(Context context, String str, String str2, VSDispatchObserver.OnVSRspCallBack<QQCircleMainPageProfile$GetQQProfileFeedListRsp> onVSRspCallBack);

    void releaseWhenExitQCircle();
}

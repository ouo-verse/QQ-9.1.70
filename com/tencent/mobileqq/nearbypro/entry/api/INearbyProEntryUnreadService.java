package com.tencent.mobileqq.nearbypro.entry.api;

import android.content.Intent;
import com.tencent.mobileqq.qroute.annotation.Service;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

@Service(process = {""})
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\tH&J\b\u0010\u000b\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\tH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/entry/api/INearbyProEntryUnreadService;", "Lmqq/app/api/IRuntimeService;", "clearEntryUnreadInteractCnt", "", "clearEntryUnreadMsgCnt", "clearTianShuRedPoint", "getJumpIntent", "Landroid/content/Intent;", "hasTianShuServiceDot", "", "hasUnreadInteractCntDot", "hasUnreadMsgCntDot", "isShowRedDot", "qq_nearby_pro_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public interface INearbyProEntryUnreadService extends IRuntimeService {
    void clearEntryUnreadInteractCnt();

    void clearEntryUnreadMsgCnt();

    void clearTianShuRedPoint();

    @NotNull
    Intent getJumpIntent();

    boolean hasTianShuServiceDot();

    boolean hasUnreadInteractCntDot();

    boolean hasUnreadMsgCntDot();

    boolean isShowRedDot();
}

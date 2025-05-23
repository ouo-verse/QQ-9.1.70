package com.tencent.mobileqq.nearbypro.entry.api;

import android.content.Intent;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.xweb.FileReaderHelper;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

@Service(process = {""})
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/entry/api/INearbyProEntryUnreadMgr;", "Lmqq/app/api/IRuntimeService;", "clearUnreadInteractCnt", "", "getJumpIntent", "Landroid/content/Intent;", "markEntryCountRead", "syncTianshuRedDotCount", FileReaderHelper.OPEN_FILE_FROM_FORCE, "", "qq_nearby_pro_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public interface INearbyProEntryUnreadMgr extends IRuntimeService {
    void clearUnreadInteractCnt();

    @NotNull
    Intent getJumpIntent();

    void markEntryCountRead();

    void syncTianshuRedDotCount(boolean force);
}

package com.tencent.mobileqq.troop.api;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes19.dex */
public interface ITroopHandlerService extends IRuntimeService {
    Bitmap getGroupFaceIcon(String str, boolean z16);

    void handleMemberExit(String str, String str2);

    void updateGroupIcon(String str, boolean z16);
}

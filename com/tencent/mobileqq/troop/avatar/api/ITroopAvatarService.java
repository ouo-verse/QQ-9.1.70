package com.tencent.mobileqq.troop.avatar.api;

import android.graphics.Bitmap;
import com.tencent.mobileqq.app.face.GroupIconHelper;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes19.dex */
public interface ITroopAvatarService extends IRuntimeService {
    Bitmap getGroupFaceIcon(String str, boolean z16);

    GroupIconHelper getGroupIconHelper();

    void updateGroupIcon(String str, boolean z16);
}

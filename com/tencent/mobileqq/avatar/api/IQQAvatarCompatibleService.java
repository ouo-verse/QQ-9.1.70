package com.tencent.mobileqq.avatar.api;

import android.graphics.Bitmap;
import com.tencent.mobileqq.app.face.FaceInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(needUin = false, process = {"all"})
/* loaded from: classes11.dex */
public interface IQQAvatarCompatibleService extends IRuntimeService {
    Bitmap getFaceBitmap(int i3, String str, byte b16, int i16, boolean z16, byte b17, int i17);

    Bitmap getFaceBitmap(int i3, String str, byte b16, int i16, boolean z16, byte b17, int i17, FaceInfo faceInfo);
}

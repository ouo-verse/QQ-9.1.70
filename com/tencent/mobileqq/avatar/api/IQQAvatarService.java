package com.tencent.mobileqq.avatar.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(needUin = false, process = {"all"})
/* loaded from: classes11.dex */
public interface IQQAvatarService extends IRuntimeService {
    IFaceDecoder getInstance(AppInterface appInterface);
}

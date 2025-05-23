package com.tencent.mobileqq.tinyid;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.tinyid.impl.TinyIDHandler;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes18.dex */
public interface ITinyIDHandler extends IRuntimeService {
    @Nullable
    String getClassName();

    void removeListener(String str, @Nullable TinyIDHandler.a aVar);

    void reqGetTinyID(@Nullable TinyIDHandler.a aVar);
}

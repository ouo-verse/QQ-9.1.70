package com.tencent.mobileqq.uftransfer.api;

import android.os.Bundle;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes19.dex */
public interface IUFTTransferService extends IRuntimeService {
    void stop(a aVar, Bundle bundle);

    a uploadC2CFile(f fVar, k kVar, b bVar);

    a uploadDiscFile(g gVar, k kVar, b bVar);

    a uploadGuildFile(com.tencent.mobileqq.uftransfer.guild.e eVar, k kVar, b bVar);

    a uploadTroopFile(m mVar, k kVar, b bVar);
}

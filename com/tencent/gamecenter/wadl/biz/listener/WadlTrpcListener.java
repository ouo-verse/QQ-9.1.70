package com.tencent.gamecenter.wadl.biz.listener;

import android.content.Intent;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes6.dex */
public interface WadlTrpcListener {
    HashSet<String> getFilterCmds();

    void onTrpcRsp(Intent intent, String str, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp);
}

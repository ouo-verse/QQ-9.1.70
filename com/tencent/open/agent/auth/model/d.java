package com.tencent.open.agent.auth.model;

import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qconn.protofile.SubmitPromotePage$SubmitResultItem;
import eq3.CommonReqParams;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface d {
    void a(CommonReqParams commonReqParams, Object[] objArr, String str, List<SubmitPromotePage$SubmitResultItem> list, ByteStringMicro byteStringMicro, com.tencent.open.appcommon.d dVar);

    void b(long j3, String str, com.tencent.open.model.a aVar, boolean z16, fp3.d dVar);

    void c(String str, String str2, String str3, String str4, Bundle bundle, com.tencent.open.model.a aVar, Object[] objArr, com.tencent.open.appcommon.d dVar);

    void d(Bundle bundle, com.tencent.open.model.a aVar, boolean z16, String str, String str2, String str3, List<hp3.e> list, long j3, String str4, String str5, Object[] objArr, com.tencent.open.appcommon.d dVar);

    void e(Bundle bundle, com.tencent.open.model.a aVar, boolean z16, String str, String str2, String str3, List<hp3.e> list, long j3, String str4, Object[] objArr, com.tencent.open.appcommon.d dVar);

    void f(CommonReqParams commonReqParams, Object[] objArr, String str, boolean z16, com.tencent.open.appcommon.d dVar);
}

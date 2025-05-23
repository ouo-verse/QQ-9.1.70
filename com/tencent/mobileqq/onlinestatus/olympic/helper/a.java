package com.tencent.mobileqq.onlinestatus.olympic.helper;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import trpc.qq_status_rank.status_rank_mgr.StatusRankMgr$StatusRankRequest;
import trpc.qq_status_rank.status_rank_mgr.StatusRankMgr$StatusRankResponse;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.onlinestatus.olympic.helper.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    class C8188a extends ProtoUtils.TroopProtocolObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f256106d;

        C8188a(b bVar) {
            this.f256106d = bVar;
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            if (i3 != 0) {
                QLog.e("OlympicProtocolHelper", 1, "onResult error and error code: " + i3);
                return;
            }
            try {
                StatusRankMgr$StatusRankResponse statusRankMgr$StatusRankResponse = (StatusRankMgr$StatusRankResponse) MessageMicro.mergeFrom(new StatusRankMgr$StatusRankResponse(), bArr);
                b bVar = this.f256106d;
                if (bVar != null) {
                    bVar.a(statusRankMgr$StatusRankResponse);
                }
            } catch (InvalidProtocolBufferMicroException unused) {
                QLog.e("OlympicProtocolHelper", 1, "response merge failed");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface b {
        void a(StatusRankMgr$StatusRankResponse statusRankMgr$StatusRankResponse);
    }

    public static void a(AppRuntime appRuntime, StatusRankMgr$StatusRankRequest statusRankMgr$StatusRankRequest, b bVar) {
        ProtoUtils.d(appRuntime, new C8188a(bVar), statusRankMgr$StatusRankRequest.toByteArray(), "trpc.qq_status_rank.status_rank_mgr.StatusRank.GetRank");
    }
}

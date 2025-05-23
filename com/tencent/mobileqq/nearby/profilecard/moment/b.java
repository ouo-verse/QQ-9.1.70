package com.tencent.mobileqq.nearby.profilecard.moment;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.pb.now.ilive_feeds_write$DelFeedReq;
import com.tencent.pb.now.ilive_feeds_write$DelFeedRsp;
import com.tencent.pb.now.ilive_feeds_write$DelFeedStuct;
import com.tencent.qphone.base.util.QLog;
import o92.b;

/* compiled from: P */
/* loaded from: classes33.dex */
public class b {

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a implements b.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f253035a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f253036b;

        a(c cVar, String str) {
            this.f253035a = cVar;
            this.f253036b = str;
        }

        @Override // o92.b.c
        public void a(int i3, byte[] bArr) {
            QLog.i("NearbyMomentProtocol", 1, "deleteMomentFeed error, errorCode =" + i3);
            c cVar = this.f253035a;
            if (cVar != null) {
                cVar.onResult(false, this.f253036b);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.nearby.profilecard.moment.b$b, reason: collision with other inner class name */
    /* loaded from: classes33.dex */
    class C8146b implements b.InterfaceC10894b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f253037a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f253038b;

        C8146b(c cVar, String str) {
            this.f253037a = cVar;
            this.f253038b = str;
        }

        @Override // o92.b.InterfaceC10894b
        public void a(int i3, byte[] bArr, Bundle bundle) {
            boolean z16 = true;
            boolean z17 = false;
            if (i3 == 0) {
                ilive_feeds_write$DelFeedRsp ilive_feeds_write_delfeedrsp = new ilive_feeds_write$DelFeedRsp();
                try {
                    ilive_feeds_write_delfeedrsp.mergeFrom(bArr);
                    int i16 = ilive_feeds_write_delfeedrsp.ret.get();
                    if (i16 != 0) {
                        QLog.i("NearbyMomentProtocol", 1, "deleteMomentFeed error, ret=" + i16 + ",msg=" + ilive_feeds_write_delfeedrsp.err_msg.get().toStringUtf8());
                        z16 = false;
                    }
                    z17 = z16;
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.i("NearbyMomentProtocol", 1, "deleteMomentFeed error, e=" + e16.toString());
                }
            } else {
                QLog.i("NearbyMomentProtocol", 1, "deleteMomentFeed error, errorCode =" + i3);
            }
            c cVar = this.f253037a;
            if (cVar != null) {
                cVar.onResult(z17, this.f253038b);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public interface c {
        void onResult(boolean z16, String str);
    }

    public static void a(QQAppInterface qQAppInterface, String str, long j3, int i3, c cVar) {
        ilive_feeds_write$DelFeedReq ilive_feeds_write_delfeedreq = new ilive_feeds_write$DelFeedReq();
        ilive_feeds_write$DelFeedStuct ilive_feeds_write_delfeedstuct = new ilive_feeds_write$DelFeedStuct();
        ilive_feeds_write_delfeedstuct.feed_id.set(ByteStringMicro.copyFromUtf8(str));
        ilive_feeds_write_delfeedstuct.timestamp.set(j3);
        ilive_feeds_write_delfeedstuct.feed_type.set(i3);
        ilive_feeds_write_delfeedreq.del_type.set(2);
        ilive_feeds_write_delfeedreq.select_all.set(0);
        ilive_feeds_write_delfeedreq.del_st.get().add(ilive_feeds_write_delfeedstuct);
        ilive_feeds_write_delfeedreq.uid.set(Long.valueOf(qQAppInterface.getCurrentAccountUin()).longValue());
        new o92.b(qQAppInterface).b(22528).g(5).e(new C8146b(cVar, str)).d(new a(cVar, str)).f(ilive_feeds_write_delfeedreq.toByteArray());
    }
}

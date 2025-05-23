package iv;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.kernel.nativeinterface.LocalAVRecordElementType;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstractElement;
import java.util.ArrayList;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes3.dex */
public class e extends com.tencent.qqnt.chats.biz.summary.state.core.a {
    private int b(QQAppInterface qQAppInterface, long j3, int i3, RecentContactInfo recentContactInfo) {
        if (qQAppInterface.getAVNotifyCenter().W(i3, j3)) {
            if (c(qQAppInterface, recentContactInfo, j3, i3)) {
                return 12;
            }
            return 2;
        }
        if (c(qQAppInterface, recentContactInfo, j3, i3)) {
            return 13;
        }
        return 3;
    }

    private boolean c(QQAppInterface qQAppInterface, @NonNull RecentContactInfo recentContactInfo, long j3, int i3) {
        boolean z16;
        boolean z17;
        if (recentContactInfo.getAbstractContent() != null) {
            ArrayList<MsgAbstractElement> abstractContent = recentContactInfo.getAbstractContent();
            if (!abstractContent.isEmpty()) {
                MsgAbstractElement msgAbstractElement = abstractContent.get(0);
                if (msgAbstractElement.getElementType() == 21 && msgAbstractElement.getElementSubType().intValue() == LocalAVRecordElementType.KNOTICEVIDEOCHAT.ordinal()) {
                    z16 = true;
                    if (i3 != 1 && qQAppInterface.getAVNotifyCenter().l(j3) == 2) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z16 && !z17) {
                        return false;
                    }
                }
            }
        }
        z16 = false;
        if (i3 != 1) {
        }
        z17 = false;
        return z16 ? true : true;
    }

    @Override // com.tencent.qqnt.chats.biz.summary.state.core.a
    public Integer a(@NonNull g gVar, @NonNull Context context, @NonNull AppRuntime appRuntime) {
        int b16;
        if (!(appRuntime instanceof QQAppInterface)) {
            return null;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
        int n3 = gVar.n();
        if (n3 != 3 && n3 != 2) {
            if (qQAppInterface.isVideoChatting() && (qQAppInterface.getAVNotifyCenter().L() == 1 || qQAppInterface.getAVNotifyCenter().L() == 2)) {
                int P = qQAppInterface.getAVNotifyCenter().P();
                String F = qQAppInterface.getAVNotifyCenter().F();
                String r16 = qQAppInterface.getAVNotifyCenter().r();
                if (com.tencent.nt.adapter.session.c.c(n3) == P && (String.valueOf(gVar.l()).equals(F) || String.valueOf(gVar.l()).equals(r16))) {
                    b16 = 1;
                }
            }
            b16 = -1;
        } else {
            long l3 = gVar.l();
            int d16 = d(n3);
            long y16 = qQAppInterface.getAVNotifyCenter().y(d16, l3);
            RecentContactInfo s16 = gVar.s();
            if (y16 > 0) {
                b16 = b(qQAppInterface, l3, d16, s16);
            } else {
                AVNotifyCenter.i Q = qQAppInterface.getAVNotifyCenter().Q(l3, 2);
                int i3 = 0;
                if (Q != null) {
                    i3 = 0 + Q.f73809c;
                }
                AVNotifyCenter.i Q2 = qQAppInterface.getAVNotifyCenter().Q(l3, 10);
                if (Q2 != null) {
                    i3 += Q2.f73809c;
                }
                if (i3 > 0) {
                    b16 = b(qQAppInterface, l3, d16, s16);
                }
                b16 = -1;
            }
        }
        if (n3 == 1 && qQAppInterface.getAVNotifyCenter().d0(String.valueOf(gVar.l()))) {
            b16 = 5;
        }
        if (b16 == -1) {
            return null;
        }
        return Integer.valueOf(b16);
    }

    public int d(int i3) {
        if (i3 == 1) {
            return 3;
        }
        if (i3 == 2) {
            return 1;
        }
        if (i3 == 3) {
            return 2;
        }
        return 0;
    }
}

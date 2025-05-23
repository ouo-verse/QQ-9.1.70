package fe1;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.group_pro_proto.msgpush.servtype$QuestionChannelSystemMsg;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private static final b f398360b = new b();

    /* renamed from: a, reason: collision with root package name */
    private List<a> f398361a = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface a {
        void a(int i3, String str, String str2, String str3);
    }

    b() {
    }

    public static b b() {
        return f398360b;
    }

    public void a(a aVar) {
        if (aVar != null) {
            synchronized (this.f398361a) {
                if (!this.f398361a.contains(aVar)) {
                    this.f398361a.add(aVar);
                }
            }
        }
    }

    public void c(servtype$QuestionChannelSystemMsg servtype_questionchannelsystemmsg, String str, String str2) {
        if (servtype_questionchannelsystemmsg != null) {
            int i3 = servtype_questionchannelsystemmsg.busi_type.get();
            String stringUtf8 = servtype_questionchannelsystemmsg.busi_data.get().toStringUtf8();
            if (QLog.isColorLevel()) {
                QLog.d("GameQAChannelSystemMsgHandler", 2, "processSystemMsg, type=", Integer.valueOf(i3), ", guildId=", str, ", channelId=", str2, ", msgContent=", stringUtf8);
            }
            synchronized (this.f398361a) {
                Iterator<a> it = this.f398361a.iterator();
                while (it.hasNext()) {
                    it.next().a(i3, stringUtf8, str, str2);
                }
            }
        }
    }

    public void d(a aVar) {
        if (aVar != null) {
            synchronized (this.f398361a) {
                if (this.f398361a.contains(aVar)) {
                    this.f398361a.remove(aVar);
                }
            }
        }
    }
}

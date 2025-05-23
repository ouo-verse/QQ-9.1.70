package ep2;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fts.data.msg.FTSMessage;
import com.tencent.mobileqq.fts.v1.FTSEntity;
import com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine;
import com.tencent.mobileqq.search.ftsmsg.NTFtsMessageSearchEngine;
import com.tencent.mobileqq.search.ftsmsg.f;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes18.dex */
public class e {
    public static String a(Context context, int i3, String str, int i16) {
        if (str.length() > 13) {
            str = str.substring(0, 10) + "\u2026";
        }
        return context.getString(R.string.h_k, Integer.valueOf(i3), str);
    }

    public static c b(QQAppInterface qQAppInterface, int i3, String str, ArrayList<String> arrayList, FTSEntity fTSEntity) {
        if ((fTSEntity instanceof FTSMessage) && ((FTSMessage) fTSEntity).istroop == 10007) {
            return new f(qQAppInterface, str, arrayList, fTSEntity);
        }
        return new com.tencent.mobileqq.search.ftsmsg.b(qQAppInterface, str, arrayList, fTSEntity);
    }

    public static String c(Context context) {
        return context.getString(R.string.h_l);
    }

    public static String d(Context context, int i3) {
        return HardCodeUtil.qqStr(R.string.mu7);
    }

    public static pn2.a e(String str, String str2, String str3, int i3, String str4) {
        pn2.a aVar = new pn2.a(str);
        Bundle bundle = new Bundle();
        aVar.f426496b = bundle;
        bundle.putString("originalKeyword", str2);
        aVar.f426496b.putLong("uin", 0L);
        aVar.f426496b.putString("uid", str3);
        aVar.f426496b.putInt("chatType", i3);
        aVar.f426496b.putString("title", str4);
        return aVar;
    }

    public static b f(QQAppInterface qQAppInterface, int i3) {
        if (i3 == 2) {
            return new NTFtsMessageSearchEngine(qQAppInterface);
        }
        return new FTSMessageSearchEngine(qQAppInterface);
    }

    public static pn2.a g(int i3, String str, FTSEntity fTSEntity) {
        pn2.a aVar = new pn2.a(str);
        FTSMessage fTSMessage = (FTSMessage) fTSEntity;
        Bundle bundle = new Bundle();
        aVar.f426496b = bundle;
        bundle.putLong("uin", fTSMessage.uin);
        aVar.f426496b.putInt("uinType", fTSMessage.istroop);
        return aVar;
    }
}

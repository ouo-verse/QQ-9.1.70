package com.tencent.mobileqq.app.message;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class i {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f196012a;

        /* renamed from: b, reason: collision with root package name */
        public int f196013b;

        /* renamed from: c, reason: collision with root package name */
        public int f196014c;

        public a(String str, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            this.f196012a = str;
            this.f196013b = i3;
            this.f196014c = i16;
        }
    }

    public static int a(MessageRecord messageRecord, int i3) {
        List<a> b16 = b(messageRecord);
        int i16 = 0;
        if (b16 != null) {
            for (a aVar : b16) {
                if (aVar.f196013b == i3) {
                    i16 += aVar.f196014c;
                }
            }
        }
        return i16;
    }

    public static List<a> b(MessageRecord messageRecord) {
        int i3;
        if (messageRecord instanceof MessageForStructing) {
            AbsStructMsg absStructMsg = ((MessageForStructing) messageRecord).structingMsg;
            if ((absStructMsg instanceof AbsShareMsg) && absStructMsg.mMsgServiceID == 52) {
                ArrayList arrayList = new ArrayList();
                Iterator<AbsStructMsgElement> it = ((AbsShareMsg) absStructMsg).iterator();
                while (it.hasNext()) {
                    AbsStructMsgElement next = it.next();
                    if (next != null) {
                        String qqStr = HardCodeUtil.qqStr(R.string.n2s);
                        int i16 = 1;
                        if (next instanceof com.tencent.mobileqq.structmsg.view.h) {
                            i3 = ((com.tencent.mobileqq.structmsg.view.h) next).X0.getInt("count");
                        } else {
                            String str = next.F;
                            if (str != null) {
                                try {
                                    JSONObject jSONObject = new JSONObject(str);
                                    qqStr = jSONObject.getString("giftName");
                                    i16 = jSONObject.getInt("giftType");
                                    i3 = jSONObject.getInt("giftCount");
                                } catch (JSONException e16) {
                                    e16.printStackTrace();
                                }
                            }
                            i3 = 0;
                        }
                        arrayList.add(new a(qqStr, i16, i3));
                    }
                }
                return arrayList;
            }
            return null;
        }
        return null;
    }
}

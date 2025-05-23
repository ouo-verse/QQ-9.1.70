package com.tencent.mobileqq.app.message.hookparcel;

import com.google.gson.GsonBuilder;
import com.tencent.mobileqq.app.message.RecordForTest;
import com.tencent.mobileqq.app.message.hookparcel.ParcelHooker;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a implements ParcelHooker.Callback {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.message.hookparcel.ParcelHooker.Callback
    public void registerTypeAdapter(GsonBuilder gsonBuilder, Field[] fieldArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) gsonBuilder, (Object) fieldArr);
            return;
        }
        for (Field field : fieldArr) {
            if ((field.getModifiers() & 200) == 0 && field.getAnnotation(RecordForTest.class) != null) {
                if (MessageMicro.class.isAssignableFrom(field.getType())) {
                    gsonBuilder.registerTypeAdapter(field.getType(), new PBJsonAdapter(field.getType()));
                } else if (StructMsgForGeneralShare.class == field.getType()) {
                    gsonBuilder.registerTypeAdapter(field.getType(), new GeneralStructMsgJsonAdapter());
                }
            }
        }
    }
}

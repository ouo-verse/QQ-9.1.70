package com.tencent.qfsmonet.process.core;

import androidx.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qfsmonet.api.data.MonetPacket;
import java.util.ArrayList;
import java.util.List;

@Keep
/* loaded from: classes22.dex */
public class MonetProcessData {
    static IPatchRedirector $redirector_;
    private String mName;
    private MonetPacket mPacketData;
    private ArrayList<MonetProcessParams> mParams;

    MonetProcessData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.mParams = new ArrayList<>();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Keep
    public String getName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mName;
    }

    @Keep
    public MonetPacket getPacketData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MonetPacket) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mPacketData;
    }

    @Keep
    public ArrayList<MonetProcessParams> getParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mParams;
    }

    @Keep
    public MonetProcessData(MonetPacket monetPacket, List<MonetProcessParams> list, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, monetPacket, list, str);
            return;
        }
        ArrayList<MonetProcessParams> arrayList = new ArrayList<>();
        this.mParams = arrayList;
        this.mPacketData = monetPacket;
        if (list != null) {
            arrayList.addAll(list);
        }
        this.mName = str;
    }
}

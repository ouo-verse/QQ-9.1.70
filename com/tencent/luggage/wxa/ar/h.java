package com.tencent.luggage.wxa.ar;

import com.tencent.luggage.wxa.ar.a0;
import com.tencent.xweb.CommandCfg;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class h {
    public static synchronized CommandCfg.CmdHandleRet a(Object obj) {
        synchronized (h.class) {
            CommandCfg.CmdHandleRet cmdHandleRet = new CommandCfg.CmdHandleRet();
            if (!(obj instanceof j)) {
                return cmdHandleRet;
            }
            j jVar = (j) obj;
            String str = jVar.f121670b;
            String str2 = jVar.f121671c;
            if (str.equals("executeCommand")) {
                String[] parseOpValue = CommandCfg.getInstance().parseOpValue(jVar.f121671c);
                if (parseOpValue != null && parseOpValue.length >= 2) {
                    str = parseOpValue[0];
                    str2 = parseOpValue[1];
                }
                return cmdHandleRet;
            }
            x0.b("ConfigCmdProc", "processCommand, type:" + str + ", value:" + str2);
            if (!"revertToVersion".equals(str)) {
                return cmdHandleRet;
            }
            return a(cmdHandleRet, str2);
        }
    }

    public static CommandCfg.CmdHandleRet a(CommandCfg.CmdHandleRet cmdHandleRet, String str) {
        cmdHandleRet.handled = true;
        a0.a c16 = a0.c(str);
        if (c16.f121611a) {
            x0.d("ConfigCmdProc", "handleCommandRevertToVersion, version:" + str);
            com.tencent.luggage.wxa.yq.g.a(XWalkEnvironment.getApplicationContext(), c16.b());
        }
        return cmdHandleRet;
    }
}

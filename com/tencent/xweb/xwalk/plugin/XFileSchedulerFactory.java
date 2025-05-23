package com.tencent.xweb.xwalk.plugin;

import android.text.TextUtils;
import com.tencent.luggage.wxa.ar.i0;
import com.tencent.luggage.wxa.ar.j0;
import com.tencent.xweb.CommandCfg;
import com.tencent.xweb.CommandCfgPlugin;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes27.dex */
public class XFileSchedulerFactory {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap f385141a = new HashMap();

    public static synchronized XFileScheduler getScheduler(String str) {
        XFileScheduler xFileScheduler;
        synchronized (XFileSchedulerFactory.class) {
            HashMap hashMap = f385141a;
            if (!hashMap.containsKey(str)) {
                hashMap.put(str, new XFileScheduler(str));
            }
            xFileScheduler = (XFileScheduler) hashMap.get(str);
        }
        return xFileScheduler;
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class XFileScheduler extends i0 {

        /* renamed from: e, reason: collision with root package name */
        public String f385142e;

        public XFileScheduler(String str) {
            this.f385142e = str;
            this.f121664a = getScheduleType() + "Scheduler";
        }

        @Override // com.tencent.luggage.wxa.ar.i0
        public boolean a(j0 j0Var, j0 j0Var2) {
            if (j0Var.f121696x == j0Var2.f121696x && a(j0Var.f121697y, j0Var2.f121697y)) {
                return super.a(j0Var, j0Var2);
            }
            return false;
        }

        @Override // com.tencent.luggage.wxa.ar.i0
        public String b() {
            return CommandCfgPlugin.getInstance().getCmd("FREE_FETCH_CONFIG_TIME_ZONE", "tools");
        }

        @Override // com.tencent.luggage.wxa.ar.i0
        public int getIdkeyOffsetFromDefault() {
            return 15;
        }

        @Override // com.tencent.luggage.wxa.ar.i0
        public String getScheduleType() {
            return this.f385142e;
        }

        @Override // com.tencent.luggage.wxa.ar.i0
        public String a(boolean z16) {
            if (!z16) {
                String cmd = CommandCfgPlugin.getInstance().getCmd("UPDATE_SPEED_CONFIG", "tools");
                return TextUtils.isEmpty(cmd) ? CommandCfg.getInstance().getCmd("UPDATE_SPEED_CONFIG", "tools") : cmd;
            }
            String cmd2 = CommandCfgPlugin.getInstance().getCmd("UPDATE_FORWARD_SPEED_CONFIG", "tools");
            return TextUtils.isEmpty(cmd2) ? CommandCfg.getInstance().getCmd("UPDATE_FORWARD_SPEED_CONFIG", "tools") : cmd2;
        }

        @Override // com.tencent.luggage.wxa.ar.i0
        public String a() {
            String cmd = CommandCfgPlugin.getInstance().getCmd("UPDATE_SCHEDULE_TIME_RANGE_BIND", "tools");
            return TextUtils.isEmpty(cmd) ? super.a() : cmd;
        }
    }
}

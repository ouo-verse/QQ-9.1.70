package com.qq.e.comm.plugin.ipc.business;

import android.os.Bundle;
import com.qq.e.comm.plugin.ipc.IPCModule;
import com.qq.e.comm.plugin.ipc.IPCResult;
import com.qq.e.comm.plugin.j.e;
import com.qq.e.comm.util.GDTLogger;

/* loaded from: classes3.dex */
public class WuJiConfigIPCModule extends IPCModule {
    private static final String ACTION_WUJI_GET_INTEGER = "actionWujiGetInteger";
    private static final String KEY_WUJI_GET_INTEGER = "keyWujiGetInteger";
    private static final String KEY_WUJI_GET_INTEGER_1 = "keyWujiGetParams1";
    private static final String KEY_WUJI_GET_INTEGER_2 = "keyWujiGetParams2";
    private static final String KEY_WUJI_GET_INTEGER_3 = "keyWujiGetParams3";
    private static final String KEY_WUJI_GET_STRING = "keyWujiGetString";

    public WuJiConfigIPCModule(String str) {
        super(str);
    }

    private IPCResult getIntegerByIPC(Bundle bundle) {
        String string = bundle.getString("keyWujiGetParams1", "");
        String string2 = bundle.getString("keyWujiGetParams2", "");
        int i3 = bundle.getInt("keyWujiGetParams3");
        GDTLogger.d("WuJiConfigIPCModule key :" + string2 + ", default value:" + i3);
        int a16 = e.a().a(string, string2, i3);
        IPCResult iPCResult = new IPCResult();
        iPCResult.code = 0;
        Bundle bundle2 = new Bundle();
        bundle2.putInt("keyWujiGetInteger", a16);
        iPCResult.data = bundle2;
        return iPCResult;
    }

    private IPCResult getStringByIPC(Bundle bundle) {
        String string = bundle.getString("keyWujiGetParams1", "");
        String string2 = bundle.getString("keyWujiGetParams2", "");
        GDTLogger.d("WuJiConfigIPCModule skey :" + string2);
        String b16 = e.a().b(string, string2);
        IPCResult iPCResult = new IPCResult();
        iPCResult.code = 0;
        Bundle bundle2 = new Bundle();
        bundle2.putString("keyWujiGetString", b16);
        iPCResult.data = bundle2;
        return iPCResult;
    }

    @Override // com.qq.e.comm.plugin.ipc.IPCModule
    public IPCResult onCall(String str, Bundle bundle) {
        if ("actionWujiGetInteger".equals(str)) {
            return getIntegerByIPC(bundle);
        }
        if ("keyWujiGetString".equals(str)) {
            return getStringByIPC(bundle);
        }
        return null;
    }
}

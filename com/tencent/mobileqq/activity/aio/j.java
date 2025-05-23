package com.tencent.mobileqq.activity.aio;

import android.os.Bundle;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class j extends QIPCModule {

    /* renamed from: d, reason: collision with root package name */
    private List<i> f179523d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static j f179524a = new j("aio_client_module");
    }

    j(String str) {
        super(str);
        this.f179523d = new ArrayList();
    }

    public static j b() {
        return a.f179524a;
    }

    private void c(int i3, String str, int i16) {
        Iterator<i> it = this.f179523d.iterator();
        while (it.hasNext()) {
            it.next().a(i3, str, i16);
        }
    }

    public static void registerModule() {
        try {
            QIPCClientHelper.getInstance().register(b());
            if (QLog.isColorLevel()) {
                QLog.d("AIOUnreadQIPCClient", 2, "register AIOUnreadQIPCClient");
            }
        } catch (Exception e16) {
            QLog.e("AIOUnreadQIPCClient", 1, "register ipc module error.", e16);
        }
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("AIOUnreadQIPCClient", 2, "onCall main server action=" + str);
        }
        if (MiniChatConstants.ACTION_SYNC_SINGLE_CON_UNREAD_COUNT.equals(str) && bundle != null) {
            String string = bundle.getString(MiniChatConstants.PARAM_PROC_UIN);
            int i16 = bundle.getInt(MiniChatConstants.PARAM_PROC_UIN_TYPE);
            int i17 = bundle.getInt(MiniChatConstants.PARAM_PROC_SINGLE_CON_BADGE_COUNT);
            c(i16, string, i17);
            if (QLog.isColorLevel()) {
                QLog.d("AIOUnreadQIPCClient", 2, "AIOUnreadQIPCClient, uin = " + string + "; type= " + i16 + "; num= " + i17);
                return null;
            }
            return null;
        }
        return null;
    }
}

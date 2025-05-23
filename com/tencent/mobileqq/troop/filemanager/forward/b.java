package com.tencent.mobileqq.troop.filemanager.forward;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.filemanager.e;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.weiyun.api.IWeiyunResponseHandler;
import ef0.l;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected long f295950a;

    /* renamed from: b, reason: collision with root package name */
    protected Map<UUID, TroopFileTransferManager.Item> f295951b;

    /* renamed from: c, reason: collision with root package name */
    protected Map<UUID, Integer> f295952c;

    /* renamed from: d, reason: collision with root package name */
    protected int f295953d;

    /* renamed from: e, reason: collision with root package name */
    l f295954e;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a extends l {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // ef0.l
        public void c(boolean z16, int i3, int i16, String str, String str2, String str3, Bundle bundle) {
            String string;
            TroopFileTransferManager.Item item;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), str, str2, str3, bundle);
            } else if (bundle.getLong("troopUin") == b.this.f295950a && (string = bundle.getString("itemKey")) != null && (item = b.this.f295951b.get(UUID.fromString(string))) != null) {
                b.this.e(item, z16, i3, i16, str, str2, str3);
            }
        }
    }

    protected b(long j3, List<TroopFileTransferManager.Item> list, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), list, Integer.valueOf(i3));
            return;
        }
        this.f295951b = new HashMap();
        this.f295952c = new HashMap();
        this.f295954e = new a();
        this.f295950a = j3;
        for (TroopFileTransferManager.Item item : list) {
            this.f295951b.put(item.Id, item);
        }
        this.f295953d = i3;
    }

    public static b c(long j3, List<TroopFileTransferManager.Item> list) {
        if (j3 == 0) {
            e.b.b("TroopFileFromTroopForwarder", e.b.f295938b, "getTroop2WeiyunForwarder. troopuin=0");
            return null;
        }
        if (list == null) {
            e.b.b("TroopFileFromTroopForwarder", e.b.f295938b, "getTroop2WeiyunForwarder. item=null");
            return null;
        }
        return new b(j3, list, 1);
    }

    private int d() {
        QQAppInterface b16 = e.b();
        if (b16 == null) {
            e.b.b("TroopFileFromTroopForwarder", e.b.f295938b, "multiTroop2weiyun app=null");
            return -1;
        }
        for (TroopFileTransferManager.Item item : this.f295951b.values()) {
            if (item.Id == null) {
                e.b.b("TroopFileFromTroopForwarder", e.b.f295938b, "multiTroop2weiyun. item.id=null");
            } else if (item.ForwardTroopuin == 0) {
                e.b.b("TroopFileFromTroopForwarder", e.b.f295938b, "multiTroop2weiyun. ForwardTroopuin=0");
            } else if (item.BusId != 25) {
                e.b.b("TroopFileFromTroopForwarder", e.b.f295938b, "multiTroop2weiyun. BusId err:" + item.BusId);
            } else if (TextUtils.isEmpty(item.ForwardPath)) {
                e.b.b("TroopFileFromTroopForwarder", e.b.f295938b, "multiTroop2weiyun. ForwardPath=null");
            } else {
                e.b.c("TroopFileFromTroopForwarder", e.b.f295938b, "[" + item.Id.toString() + "] multiTroop2weiyun. BusId:" + item.BusId + " ForwardBusId:" + item.ForwardBusId + " ForwardPath:" + item.ForwardPath);
                synchronized (this) {
                    this.f295952c.put(item.Id, Integer.MAX_VALUE);
                }
                com.tencent.biz.troop.file.a.p(b16, true, this.f295950a, item, b16.getLongAccountUin(), 0L, this.f295954e);
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(TroopFileTransferManager.Item item, boolean z16, int i3, int i16, String str, String str2, String str3) {
        boolean z17;
        synchronized (this) {
            if (!z16) {
                ((IWeiyunResponseHandler) QRoute.api(IWeiyunResponseHandler.class)).endSave2Weiyun(-1);
                this.f295952c.put(item.Id, -1);
                e.b.b("TroopFileFromTroopForwarder", e.b.f295938b, "[" + item.Id.toString() + "] onRspMultiCopyToWeiyun fail. isSuc:" + z16);
                return;
            }
            e.b.c("TroopFileFromTroopForwarder", e.b.f295938b, "[" + item.Id.toString() + "] onRspMultiCopyToWeiyun retCode:" + i3);
            ((IWeiyunResponseHandler) QRoute.api(IWeiyunResponseHandler.class)).endSave2Weiyun(i3);
            if (i3 == 0) {
                this.f295952c.remove(item.Id);
            } else {
                this.f295952c.put(item.Id, Integer.valueOf(i3));
            }
            if (this.f295952c.size() == 0) {
                com.tencent.mobileqq.troop.filemanager.b.g(this.f295950a, item, 5, new TroopFileError.b(item.FileName, this.f295950a, 5, 604));
            } else {
                Iterator<UUID> it = this.f295952c.keySet().iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (this.f295952c.get(it.next()).intValue() == Integer.MAX_VALUE) {
                            z17 = false;
                            break;
                        }
                    } else {
                        z17 = true;
                        break;
                    }
                }
                if (z17) {
                    com.tencent.mobileqq.troop.filemanager.b.g(this.f295950a, item, 5, new TroopFileError.b(item.FileName, this.f295950a, 5, 605));
                }
            }
        }
    }

    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        if (1 == this.f295953d) {
            return d();
        }
        return -1;
    }
}

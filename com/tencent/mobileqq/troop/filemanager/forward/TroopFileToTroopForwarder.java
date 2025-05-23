package com.tencent.mobileqq.troop.filemanager.forward;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.data.t;
import com.tencent.mobileqq.troop.filemanager.e;
import com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadFeedsSender;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.widget.QQToast;
import ef0.l;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopFileToTroopForwarder extends TroopFileUploadFeedsSender {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    l f295941f;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a extends l {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopFileToTroopForwarder.this);
            }
        }

        @Override // ef0.l
        public void c(boolean z16, int i3, int i16, String str, String str2, String str3, Bundle bundle) {
            String string;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), str, str2, str3, bundle);
                return;
            }
            if (bundle.getLong("troopUin") != ((TroopFileUploadFeedsSender) TroopFileToTroopForwarder.this).f296015a || (string = bundle.getString("itemKey")) == null || !UUID.fromString(string).equals(TroopFileToTroopForwarder.this.a())) {
                return;
            }
            if (!z16) {
                e.b.b("TroopFileToTroopForwarder", e.b.f295938b, "[" + ((TroopFileUploadFeedsSender) TroopFileToTroopForwarder.this).f296017c + "] onFowardToTroopResult isSuccess:false ");
            }
            TroopFileToTroopForwarder.this.i(i3, i16, str, str2, str3);
        }
    }

    protected TroopFileToTroopForwarder(long j3, TroopFileTransferManager.Item item) {
        super(j3, item);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), item);
        } else {
            this.f295941f = new a();
        }
    }

    public static TroopFileToTroopForwarder h(long j3, TroopFileTransferManager.Item item) {
        if (j3 == 0) {
            e.b.b("TroopFileToTroopForwarder", e.b.f295938b, "getTroop2TroopForwarder. troopuin=0");
            return null;
        }
        if (item == null) {
            e.b.b("TroopFileToTroopForwarder", e.b.f295938b, "getTroop2TroopForwarder. item=null");
            return null;
        }
        if (item.Id == null) {
            e.b.b("TroopFileToTroopForwarder", e.b.f295938b, "getTroop2TroopForwarder. item.id=null");
            return null;
        }
        if (item.ForwardTroopuin == 0) {
            e.b.b("TroopFileToTroopForwarder", e.b.f295938b, "getTroop2TroopForwarder. ForwardTroopuin=0");
            return null;
        }
        int i3 = item.BusId;
        if (i3 != 102 && i3 != 104) {
            e.b.b("TroopFileToTroopForwarder", e.b.f295938b, "getTroop2TroopForwarder. BusId err:" + item.BusId);
            return null;
        }
        if (TextUtils.isEmpty(item.ForwardPath)) {
            e.b.b("TroopFileToTroopForwarder", e.b.f295938b, "getTroop2TroopForwarder. ForwardPath=null");
            return null;
        }
        return new TroopFileToTroopForwarder(j3, item);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:34:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x014b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void i(int i3, int i16, String str, String str2, String str3) {
        String str4;
        int i17;
        int i18;
        QQAppInterface b16 = e.b();
        e.b.c("TroopFileToTroopForwarder", e.b.f295938b, "[" + this.f296017c + "] onFowardToTroopResult isSuccess:true retCode:" + i3);
        if (i3 < 0) {
            if (i3 != -20001 && i3 != -20000) {
                if (i3 != -6101) {
                    if (i3 != -403) {
                        if (i3 == -36) {
                            i18 = 706;
                            str4 = HardCodeUtil.qqStr(R.string.uf6);
                            i17 = i18;
                            TroopFileTransferManager.Item item = this.f296016b;
                            com.tencent.mobileqq.troop.filemanager.b.g(this.f296015a, this.f296016b, 5, new TroopFileError.b(item.FileName, item.ForwardTroopuin, 5, i17, str4));
                            if (b16 != null) {
                                FileManagerEntity D = b16.getFileManagerDataCenter().D(this.f296016b.entrySessionID);
                                if (D != null) {
                                    long j3 = D.structMsgSeq;
                                    b16.getMessageFacade().T1("" + this.f296015a, 1, j3);
                                    return;
                                }
                                return;
                            }
                            e.b.b("TroopFileToTroopForwarder", e.b.f295938b, "[" + this.f296017c + "] onFowardToTroopResult fail. removeMsgByUniseq fail.");
                            return;
                        }
                        if (i3 == -30) {
                            i18 = 705;
                        } else if (i3 == -25 || i3 == -22) {
                            i18 = 701;
                        } else {
                            i18 = -139;
                            if (i3 != -139 && i3 != -138) {
                                i18 = i3 != -4 ? i3 != -3 ? 207 : 202 : 600;
                            }
                        }
                    }
                } else {
                    if (!TextUtils.isEmpty(this.f296016b.LocalFile) && new VFSFile(this.f296016b.LocalFile).exists()) {
                        e.b.e("TroopFileToTroopForwarder", e.b.f295938b, "[" + this.f296017c + "] onFowardToTroopResult: -6101. start local uploadl.");
                        b16.getFileManagerEngine().V().f(this.f296015a, this.f296016b, null);
                        return;
                    }
                    i18 = 603;
                }
                str4 = str3;
                i17 = i18;
                TroopFileTransferManager.Item item2 = this.f296016b;
                com.tencent.mobileqq.troop.filemanager.b.g(this.f296015a, this.f296016b, 5, new TroopFileError.b(item2.FileName, item2.ForwardTroopuin, 5, i17, str4));
                if (b16 != null) {
                }
            }
            TroopFileTransferManager.Item item3 = this.f296016b;
            if (item3.BusId == 102) {
                item3.BusId = 104;
                if (b16 != null) {
                    e.b.e("TroopFileToTroopForwarder", e.b.f295938b, "[" + this.f296017c + "] onFowardToTroopResult: space no enough. fowrd temp.");
                    long j16 = this.f296015a;
                    com.tencent.biz.troop.file.a.p(b16, false, j16, this.f296016b, j16, 0L, this.f295941f);
                    return;
                }
            }
            str4 = str3;
            i17 = 204;
            TroopFileTransferManager.Item item22 = this.f296016b;
            com.tencent.mobileqq.troop.filemanager.b.g(this.f296015a, this.f296016b, 5, new TroopFileError.b(item22.FileName, item22.ForwardTroopuin, 5, i17, str4));
            if (b16 != null) {
            }
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.troop.filemanager.forward.TroopFileToTroopForwarder.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopFileToTroopForwarder.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        QQToast.makeText(BaseApplicationImpl.sApplication, HardCodeUtil.qqStr(R.string.ufv), 0).show(BaseApplicationImpl.sApplication.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                    }
                }
            });
            this.f296016b.FilePath = str;
            e.b.c("TroopFileToTroopForwarder", e.b.f295938b, "[" + this.f296017c + "] onFowardToTroopResult sucess. mItem.FilePath:" + str);
            t info = this.f296016b.getInfo(this.f296015a);
            if (info != null) {
                info.f294985s = str;
            }
            if (b16 != null) {
                FileManagerEntity D2 = b16.getFileManagerDataCenter().D(this.f296016b.entrySessionID);
                if (D2 != null) {
                    D2.strTroopFilePath = str;
                }
            } else {
                e.b.b("TroopFileToTroopForwarder", e.b.f295938b, "[" + this.f296017c + "] onFowardToTroopResult sucess. update entity.strTroopFilePath fail.");
            }
            com.tencent.mobileqq.troop.filemanager.b.f(this.f296015a, this.f296016b, 7, 0);
            c();
        }
    }

    private int j() {
        QQAppInterface b16 = e.b();
        if (b16 == null) {
            e.b.b("TroopFileToTroopForwarder", e.b.f295938b, "[" + this.f296017c + "] startTroop2Troop app=null");
            return -1;
        }
        e.b.c("TroopFileToTroopForwarder", e.b.f295938b, "[" + this.f296017c + "] startTroop2Troop. BusId:" + this.f296016b.BusId + " ForwardBusId:" + this.f296016b.ForwardBusId + " ForwardPath:" + this.f296016b.ForwardPath + " entrySessionID:" + this.f296016b.entrySessionID + " with:" + this.f296016b.width + " height:" + this.f296016b.height);
        long j3 = this.f296015a;
        com.tencent.biz.troop.file.a.p(b16, false, j3, this.f296016b, j3, 0L, this.f295941f);
        com.tencent.mobileqq.troop.filemanager.b.f(this.f296015a, this.f296016b, 4, 0);
        return 0;
    }

    public int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return j();
    }
}

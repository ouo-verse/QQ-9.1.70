package com.tencent.mobileqq.troop.filemanager.download;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopFileHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.filemanager.e;
import com.tencent.mobileqq.troop.utils.TroopFileError;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.utils.HexUtil;
import ef0.m;
import java.util.UUID;
import qb1.g;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6$DownloadFileRspBody;

/* compiled from: P */
/* loaded from: classes19.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected long f295924a;

    /* renamed from: b, reason: collision with root package name */
    protected TroopFileTransferManager.Item f295925b;

    /* renamed from: c, reason: collision with root package name */
    protected String f295926c;

    /* renamed from: d, reason: collision with root package name */
    protected g f295927d;

    /* renamed from: e, reason: collision with root package name */
    m f295928e;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a extends m {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            }
        }

        @Override // ef0.m
        public void c(boolean z16, int i3, oidb_0x6d6$DownloadFileRspBody oidb_0x6d6_downloadfilerspbody, Bundle bundle) {
            String string;
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), oidb_0x6d6_downloadfilerspbody, bundle);
                return;
            }
            if (!bundle.getBoolean("isPreview", false) || bundle.getLong("troopUin") != e.this.f295924a || (string = bundle.getString("itemKey")) == null || !UUID.fromString(string).equals(e.this.a())) {
                return;
            }
            TroopFileTransferManager.e eVar = new TroopFileTransferManager.e();
            eVar.f301964f = -1;
            try {
                eVar.f301965g = e.this.a().toString();
            } catch (NullPointerException unused) {
                eVar.f301965g = null;
            }
            QQAppInterface b16 = com.tencent.mobileqq.troop.filemanager.e.b();
            if (b16 == null) {
                e.b.b("TroopFilePreviewWorker", e.b.f295938b, "[" + e.this.f295926c + "] getPreviewInfoResult app=null");
                return;
            }
            TroopFileHandler troopFileHandler = (TroopFileHandler) b16.getBusinessHandler(BusinessHandlerFactory.TROOP_FILE_HANDLER);
            if (oidb_0x6d6_downloadfilerspbody != null && z16) {
                int i16 = oidb_0x6d6_downloadfilerspbody.int32_ret_code.get();
                eVar.f301964f = i16;
                eVar.f301959a = false;
                String str2 = oidb_0x6d6_downloadfilerspbody.str_download_ip.get();
                if (oidb_0x6d6_downloadfilerspbody.str_download_dns.get() != null) {
                    str = oidb_0x6d6_downloadfilerspbody.str_download_dns.get().toString();
                } else {
                    str = "";
                }
                eVar.f301960b = str2;
                if (TextUtils.isEmpty(str2) || eVar.f301960b.equals("0.0.0.0")) {
                    eVar.f301960b = str;
                }
                eVar.f301961c = String.valueOf(oidb_0x6d6_downloadfilerspbody.uint32_preview_port.get());
                eVar.f301962d = oidb_0x6d6_downloadfilerspbody.str_client_wording.get();
                eVar.f301963e = HexUtil.bytes2HexStr(oidb_0x6d6_downloadfilerspbody.bytes_download_url.get().toByteArray());
                eVar.f301966h = str;
                if (i16 < 0) {
                    e.b.b("TroopFilePreviewWorker", e.b.f295938b, "[" + e.this.f295926c + "] getPreviewInfoResult fail. retCode:" + i16 + " retMsg:" + eVar.f301962d);
                    TroopFileError.h(b16, e.this.f295924a, 700);
                    if (TextUtils.isEmpty(eVar.f301962d)) {
                        eVar.f301962d = HardCodeUtil.qqStr(R.string.uf9);
                    }
                    eVar.f301959a = false;
                    troopFileHandler.G2(eVar);
                    return;
                }
                e.b.c("TroopFilePreviewWorker", e.b.f295938b, "[" + e.this.f295926c + "] getPreviewInfoResult isSuccess:true  downloadip:" + str2 + " downloadDns:" + str + " port:" + eVar.f301961c + " downloadKey:" + eVar.f301963e + " retMsg:" + eVar.f301962d + " httpsDomain:" + eVar.f301966h);
                eVar.f301959a = true;
                troopFileHandler.G2(eVar);
                return;
            }
            e.b.b("TroopFilePreviewWorker", e.b.f295938b, "[" + e.this.f295926c + "] getPreviewInfoResult isSuccess:false  errCode:" + i3);
            TroopFileError.h(b16, e.this.f295924a, 700);
            eVar.f301959a = false;
            troopFileHandler.G2(eVar);
        }
    }

    e(long j3, TroopFileTransferManager.Item item) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), item);
            return;
        }
        this.f295928e = new a();
        this.f295924a = j3;
        this.f295925b = item;
        UUID uuid = item.Id;
        if (uuid != null) {
            str = uuid.toString();
        } else {
            str = "";
        }
        this.f295926c = str;
    }

    public static e c(long j3, TroopFileTransferManager.Item item) {
        if (j3 == 0) {
            e.b.b("TroopFilePreviewWorker", e.b.f295938b, "getWoker. troopuin=0");
            return null;
        }
        if (item == null) {
            e.b.b("TroopFilePreviewWorker", e.b.f295938b, "getWoker. item=null");
            return null;
        }
        if (item.Id == null) {
            e.b.b("TroopFilePreviewWorker", e.b.f295938b, "getWoker. item.id=null");
            return null;
        }
        return new e(j3, item);
    }

    public UUID a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (UUID) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f295925b.Id;
    }

    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        QQAppInterface b16 = com.tencent.mobileqq.troop.filemanager.e.b();
        if (b16 == null) {
            e.b.b("TroopFilePreviewWorker", e.b.f295938b, "[" + this.f295926c + "] getPreviewInfo app=null");
            return false;
        }
        e.b.c("TroopFilePreviewWorker", e.b.f295938b, "[" + this.f295926c + "] getPreviewInfo");
        this.f295927d = com.tencent.biz.troop.file.a.q(b16, this.f295924a, this.f295925b, 0, true, false, this.f295928e);
        return true;
    }
}

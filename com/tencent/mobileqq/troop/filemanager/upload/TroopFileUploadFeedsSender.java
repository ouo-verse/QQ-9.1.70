package com.tencent.mobileqq.troop.filemanager.upload;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.filemanager.fileviewer.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.teamwork.spread.AIOMessageSpreadManager;
import com.tencent.mobileqq.troop.filemanager.e;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import ef0.i;
import ef0.n;
import java.util.UUID;
import tencent.im.cs.group_file_common.group_file_common$FileInfo;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopFileUploadFeedsSender {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected long f296015a;

    /* renamed from: b, reason: collision with root package name */
    protected TroopFileTransferManager.Item f296016b;

    /* renamed from: c, reason: collision with root package name */
    protected String f296017c;

    /* renamed from: d, reason: collision with root package name */
    n f296018d;

    /* renamed from: e, reason: collision with root package name */
    i f296019e;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a extends i {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopFileUploadFeedsSender.this);
            }
        }

        @Override // ef0.i
        protected void c(boolean z16, int i3, group_file_common$FileInfo group_file_common_fileinfo) {
            com.tencent.mobileqq.troop.data.n A;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), group_file_common_fileinfo);
                return;
            }
            if (z16 && group_file_common_fileinfo != null) {
                String str = group_file_common_fileinfo.str_file_id.get();
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (!str.startsWith("/")) {
                    str = "/" + str;
                }
                if (!str.equalsIgnoreCase(TroopFileUploadFeedsSender.this.f296016b.FilePath)) {
                    return;
                }
                e.b.c("TroopFileUploadFeedsSender", e.b.f295938b, "[" + TroopFileUploadFeedsSender.this.f296017c + "] onGetOneFileResult. bus_id:" + group_file_common_fileinfo.uint32_bus_id.get() + " dead_time:" + group_file_common_fileinfo.uint32_dead_time.get());
                TroopFileManager h16 = e.h(TroopFileUploadFeedsSender.this.f296015a);
                if (h16 != null && (A = h16.A(str)) != null) {
                    A.f294919e = group_file_common_fileinfo.uint32_bus_id.get();
                    A.f294923i = (int) ((System.currentTimeMillis() / 1000) + group_file_common_fileinfo.uint32_dead_time.get());
                    h16.O(A);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TroopFileUploadFeedsSender(long j3, TroopFileTransferManager.Item item) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), item);
            return;
        }
        this.f296018d = new n() { // from class: com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadFeedsSender.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopFileUploadFeedsSender.this);
                }
            }

            @Override // ef0.n
            public void c(boolean z16, int i3, String str2, int i16, int i17, Bundle bundle) {
                String string;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), str2, Integer.valueOf(i16), Integer.valueOf(i17), bundle);
                    return;
                }
                if (!z16 || (string = bundle.getString("itemKey")) == null) {
                    return;
                }
                UUID fromString = UUID.fromString(string);
                if (!fromString.equals(TroopFileUploadFeedsSender.this.a())) {
                    return;
                }
                e.b.c("TroopFileUploadFeedsSender", e.b.f295938b, "[" + TroopFileUploadFeedsSender.this.f296017c + "] onReqFeedsResult retCode:" + i3);
                String string2 = bundle.getString("fileId");
                TroopFileManager h16 = e.h(TroopFileUploadFeedsSender.this.f296015a);
                if (h16 == null) {
                    e.b.b("TroopFileUploadFeedsSender", e.b.f295938b, "[" + TroopFileUploadFeedsSender.this.f296017c + "] onReqFeedsResult getTroopFileMgr()=null");
                    return;
                }
                com.tencent.mobileqq.troop.data.n B = h16.B(fromString);
                if (B == null) {
                    e.b.b("TroopFileUploadFeedsSender", e.b.f295938b, "[" + TroopFileUploadFeedsSender.this.f296017c + "] onReqFeedsResult getFileInfo()=null");
                    return;
                }
                if (i3 == 0) {
                    e.b.c("TroopFileUploadFeedsSender", e.b.f295938b, "[" + TroopFileUploadFeedsSender.this.f296017c + "] onReqFeedsResult refreshOneFile");
                    QQAppInterface b16 = e.b();
                    TroopFileUploadFeedsSender troopFileUploadFeedsSender = TroopFileUploadFeedsSender.this;
                    com.tencent.biz.troop.file.a.m(b16, troopFileUploadFeedsSender.f296015a, B.f294919e, B.f294916b, troopFileUploadFeedsSender.f296019e);
                    ThreadManagerV2.executeOnSubThread(new Runnable(string2, B) { // from class: com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadFeedsSender.1.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ String f296021d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ com.tencent.mobileqq.troop.data.n f296022e;

                        {
                            this.f296021d = string2;
                            this.f296022e = B;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, this, AnonymousClass1.this, string2, B);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            String str3 = this.f296021d;
                            if (!TextUtils.isEmpty(this.f296022e.f294916b)) {
                                str3 = this.f296022e.f294916b;
                            }
                            QQAppInterface b17 = e.b();
                            if (b17 == null) {
                                e.b.b("TroopFileUploadFeedsSender", e.b.f295938b, "[" + TroopFileUploadFeedsSender.this.f296017c + "] addToSendCache app=null");
                                return;
                            }
                            MessageForTroopFile messageForTroopFile = (MessageForTroopFile) c.w(b17.getMessageFacade(), String.valueOf(TroopFileUploadFeedsSender.this.f296015a), 1, str3);
                            if (messageForTroopFile != null) {
                                ((AIOMessageSpreadManager) b17.getManager(QQManagerFactory.TEAMWORK_SPREAD_MANAGER)).n(messageForTroopFile);
                                return;
                            }
                            e.b.b("TroopFileUploadFeedsSender", e.b.f295938b, "[" + TroopFileUploadFeedsSender.this.f296017c + "] addToSendCache can't find troopFile Msg, troop[" + TroopFileUploadFeedsSender.this.f296015a + "], id:" + this.f296022e.f294916b);
                        }
                    });
                }
            }
        };
        this.f296019e = new a();
        this.f296015a = j3;
        this.f296016b = item;
        UUID uuid = item.Id;
        if (uuid != null) {
            str = uuid.toString();
        } else {
            str = "";
        }
        this.f296017c = str;
    }

    public static TroopFileUploadFeedsSender b(long j3, TroopFileTransferManager.Item item) {
        if (j3 == 0) {
            e.b.b("TroopFileUploadFeedsSender", e.b.f295938b, "getSender. troopuin=0");
            return null;
        }
        if (item == null) {
            e.b.b("TroopFileUploadFeedsSender", e.b.f295938b, "getSender. item=null");
            return null;
        }
        if (item.Id == null) {
            e.b.b("TroopFileUploadFeedsSender", e.b.f295938b, "getSender. item.id=null");
        }
        return new TroopFileUploadFeedsSender(j3, item);
    }

    public UUID a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (UUID) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f296016b.Id;
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        QQAppInterface b16 = e.b();
        if (b16 == null) {
            e.b.b("TroopFileUploadFeedsSender", e.b.f295938b, "[" + this.f296017c + "] reqFeedMsgV2 app=null");
            return;
        }
        e.b.c("TroopFileUploadFeedsSender", e.b.f295938b, "[" + this.f296017c + "] reqFeedMsgV2");
        com.tencent.biz.troop.file.a.t(b16, this.f296015a, this.f296016b, this.f296018d);
    }
}

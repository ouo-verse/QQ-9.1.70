package com.tencent.imcore.message;

import IMMsgBodyPack.MsgType0x210;
import IMMsgBodyPack.MsgType0x210SubMsgType0x24;
import IMMsgBodyPack.PluginNum;
import OnlinePushPack.DelMsgInfo;
import OnlinePushPack.MsgInfo;
import OnlinePushPack.SvcReqPushMsg;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x11e;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x76;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x87;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xb3;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xc7;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xef;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.aq;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.ar;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.as;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.at;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.au;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.av;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.aw;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.ax;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.az;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.ba;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.bb;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.bc;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.bd;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.be;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.bg;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.bh;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.bi;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.bj;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.bk;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.bl;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.bm;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.bn;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.bo;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.bp;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.bq;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.br;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.bs;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.bt;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.bu;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.bv;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.bw;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.bx;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.bz;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.ca;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.cb;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.cc;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.cd;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.ce;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.cf;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.cg;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.ch;
import com.tencent.imcore.message.g;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ExtSnsFrdDataHandleHelper;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.BaseMessageHandlerUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.ay;
import com.tencent.mobileqq.app.cj;
import com.tencent.mobileqq.app.message.PushMsg0x210C7Info;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.mutualmark.oldlogic.FriendIntimateRelationshipHelper;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.troop.utils.bf;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.nt.api.IRelationNTPushService;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import localpb.richMsg.SafeMsg$SafeMoreInfo;
import protocol.KQQConfig.GetResourceReqInfo;
import tencent.im.group.cmd0x2dc$GroupVisitorJoinMsg;
import tencent.im.group.cmd0x2dc$VisitorJoinInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xa8.SubMsgType0xa8$MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7$ForwardBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7$MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7$RelationalChainChange;
import tencent.im.s2c.msgtype0x210.submsgtype0xea.submsgtype0xea$MsgBody;

/* compiled from: P */
/* loaded from: classes7.dex */
public class af extends g {
    static IPatchRedirector $redirector_;

    /* renamed from: w, reason: collision with root package name */
    private final boolean f116476w;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    private class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private MsgInfo f116477a;

        /* renamed from: b, reason: collision with root package name */
        private String f116478b;

        /* renamed from: c, reason: collision with root package name */
        private int f116479c;

        /* renamed from: d, reason: collision with root package name */
        private int f116480d;

        /* renamed from: e, reason: collision with root package name */
        private long f116481e;

        public a(MsgInfo msgInfo, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, af.this, msgInfo, str);
            } else {
                this.f116477a = msgInfo;
                this.f116478b = str;
            }
        }

        public int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.f116479c;
        }

        public String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.f116478b;
        }

        public int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.f116480d;
        }

        public long d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
            }
            return this.f116481e;
        }

        public a e() throws UnsupportedEncodingException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (a) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            byte[] bArr = new byte[4];
            byte[] bArr2 = this.f116477a.vMsg;
            if (bArr2.length > 4) {
                PkgTools.copyData(bArr, 0, bArr2, 0, 4);
            }
            this.f116481e = PkgTools.getLongData(bArr, 0);
            byte[] bArr3 = this.f116477a.vMsg;
            if (bArr3.length >= 9) {
                int length = bArr3.length - 9;
                byte[] bArr4 = new byte[length];
                PkgTools.copyData(bArr4, 0, bArr3, 8, length);
                this.f116478b = new String(com.tencent.mobileqq.service.message.b.d(bArr4), "utf-8");
            }
            this.f116479c = 1000;
            this.f116480d = -1000;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    private class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private MsgInfo f116483a;

        /* renamed from: b, reason: collision with root package name */
        private String f116484b;

        /* renamed from: c, reason: collision with root package name */
        private int f116485c;

        /* renamed from: d, reason: collision with root package name */
        private int f116486d;

        /* renamed from: e, reason: collision with root package name */
        private long f116487e;

        public b(MsgInfo msgInfo, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, af.this, msgInfo, str);
            } else {
                this.f116483a = msgInfo;
                this.f116484b = str;
            }
        }

        public int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.f116485c;
        }

        public String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.f116484b;
        }

        public int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.f116486d;
        }

        public long d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
            }
            return this.f116487e;
        }

        public b e() throws UnsupportedEncodingException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (b) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            byte[] bArr = new byte[4];
            byte[] bArr2 = this.f116483a.vMsg;
            if (bArr2.length > 4) {
                PkgTools.copyData(bArr, 0, bArr2, 0, 4);
            }
            this.f116487e = PkgTools.getLongData(bArr, 0);
            byte[] bArr3 = this.f116483a.vMsg;
            if (bArr3.length >= 9) {
                int length = bArr3.length - 9;
                byte[] bArr4 = new byte[length];
                PkgTools.copyData(bArr4, 0, bArr3, 8, length);
                this.f116484b = new String(com.tencent.mobileqq.service.message.b.d(bArr4), "utf-8");
            }
            this.f116485c = 1020;
            this.f116486d = -1000;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    private class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private MsgInfo f116489a;

        /* renamed from: b, reason: collision with root package name */
        private long f116490b;

        /* renamed from: c, reason: collision with root package name */
        private long f116491c;

        /* renamed from: d, reason: collision with root package name */
        private int f116492d;

        /* renamed from: e, reason: collision with root package name */
        private int f116493e;

        /* renamed from: f, reason: collision with root package name */
        private String f116494f;

        /* renamed from: g, reason: collision with root package name */
        private byte[] f116495g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f116496h;

        public c(MsgInfo msgInfo, long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, af.this, msgInfo, Long.valueOf(j3), Long.valueOf(j16));
                return;
            }
            this.f116489a = msgInfo;
            this.f116490b = j3;
            this.f116491c = j16;
        }

        public int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.f116492d;
        }

        public String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.f116494f;
        }

        public byte[] c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (byte[]) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.f116495g;
        }

        public int d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.f116493e;
        }

        public c e() throws UnsupportedEncodingException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (c) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            this.f116494f = new String(com.tencent.mobileqq.service.message.b.d(this.f116489a.vMsg), "utf-8");
            if (com.tencent.qqnt.contact.friends.b.f355778a.c(String.valueOf(this.f116491c), "Q.msg.BaseMessageProcessor")) {
                this.f116492d = 0;
            } else {
                String phoneNumByUin = ((IPhoneContactService) af.this.f116342a.getRuntimeService(IPhoneContactService.class, "")).getPhoneNumByUin(String.valueOf(this.f116490b));
                if (phoneNumByUin != null && phoneNumByUin.length() != 0) {
                    this.f116492d = 1006;
                } else {
                    this.f116492d = 1000;
                }
            }
            SafeMsg$SafeMoreInfo safeMsg$SafeMoreInfo = new SafeMsg$SafeMoreInfo();
            safeMsg$SafeMoreInfo.strFromMobile.set(this.f116489a.strFromMobile);
            safeMsg$SafeMoreInfo.strFromName.set(this.f116489a.strFromName);
            safeMsg$SafeMoreInfo.strMsgTxt.set(this.f116494f);
            this.f116495g = safeMsg$SafeMoreInfo.toByteArray();
            this.f116493e = -1002;
            this.f116496h = true;
            return this;
        }

        public boolean f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
            }
            return this.f116496h;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    private class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private long f116498a;

        /* renamed from: b, reason: collision with root package name */
        private MsgInfo f116499b;

        /* renamed from: c, reason: collision with root package name */
        private int f116500c;

        /* renamed from: d, reason: collision with root package name */
        private int f116501d;

        /* renamed from: e, reason: collision with root package name */
        private long f116502e;

        public d(long j3, MsgInfo msgInfo, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, af.this, Long.valueOf(j3), msgInfo, Integer.valueOf(i3));
                return;
            }
            this.f116498a = j3;
            this.f116499b = msgInfo;
            this.f116500c = i3;
        }

        public long a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
            }
            return this.f116502e;
        }

        public int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.f116501d;
        }

        public d c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (d) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            ((QQAppInterface) af.this.f116342a).getMsgHandler().m3().v0(2);
            this.f116502e = AppConstants.SYSTEM_MSG_UIN_LONGVALUE;
            this.f116501d = (-1006) - (this.f116500c - 187);
            com.tencent.mobileqq.app.message.n m3 = ((QQAppInterface) af.this.f116342a).getMsgHandler().m3();
            long j3 = this.f116498a;
            MsgInfo msgInfo = this.f116499b;
            m3.V(j3, msgInfo.lFromUin, this.f116500c, this.f116501d, msgInfo.uMsgTime, msgInfo.shMsgSeq);
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    private class e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private MsgInfo f116504a;

        /* renamed from: b, reason: collision with root package name */
        private int f116505b;

        /* renamed from: c, reason: collision with root package name */
        private int f116506c;

        /* renamed from: d, reason: collision with root package name */
        private int f116507d;

        /* renamed from: e, reason: collision with root package name */
        private long f116508e;

        /* renamed from: f, reason: collision with root package name */
        private long f116509f;

        public e(MsgInfo msgInfo, int i3, int i16, int i17, long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, af.this, msgInfo, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Long.valueOf(j3), Long.valueOf(j16));
                return;
            }
            this.f116504a = msgInfo;
            this.f116505b = i3;
            this.f116506c = i16;
            this.f116507d = i17;
            this.f116508e = j3;
            this.f116509f = j16;
        }

        public int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.f116507d;
        }

        public long b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
            }
            return this.f116509f;
        }

        public int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.f116506c;
        }

        public e d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (e) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            int i3 = this.f116505b;
            if (i3 != 45) {
                this.f116509f = AppConstants.SYSTEM_MSG_UIN_LONGVALUE;
                this.f116507d = 32769;
                this.f116506c = SystemMsg.getTroopSystemMsgType(i3);
            }
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class f extends g.a {
        static IPatchRedirector $redirector_;

        public f(g.b bVar) {
            super(bVar);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) af.this, (Object) bVar);
            }
        }

        private void j(ArrayList<MessageRecord> arrayList, MsgInfo msgInfo, long j3) {
            MessageRecord I = af.this.I(msgInfo, j3);
            if (I != null && !MessageHandlerUtils.msgFilter(af.this.f116342a, I, true)) {
                arrayList.add(I);
            }
        }

        private boolean k(ArrayList<MessageRecord> arrayList, MsgInfo msgInfo) {
            byte[] bArr = msgInfo.vMsg;
            if (bArr == null) {
                return true;
            }
            int length = bArr.length;
            byte[] bArr2 = new byte[length];
            PkgTools.copyData(bArr2, 0, bArr, 0, length);
            byte b16 = bArr2[4];
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageProcessor", 2, "<---0x2dc push  groupCode:" + PkgTools.getLongData(msgInfo.vMsg, 0) + " subType:" + ((int) b16) + "msgSeq:" + ((int) msgInfo.shMsgSeq));
            }
            if (b16 != 16 && b16 != 17 && b16 != 20 && b16 != 21) {
                if (b16 == 15) {
                    af.this.l0(bArr2, msgInfo.shMsgSeq);
                    return true;
                }
                if (b16 == 6) {
                    af.this.f0(bArr2);
                } else if (b16 == 11 || b16 == 13) {
                    byte[] bArr3 = msgInfo.vMsg;
                    if (bArr3.length > 7) {
                        int length2 = bArr3.length - 7;
                        byte[] bArr4 = new byte[length2];
                        PkgTools.copyData(bArr4, 0, bArr3, 7, length2);
                        af.this.W(bArr4, b16);
                    }
                }
            } else if (msgInfo.vMsg.length > 7) {
                bf bfVar = (bf) af.this.f116342a.getManager(QQManagerFactory.TROOP_TIPS_MSG_MANAGER);
                byte[] bArr5 = msgInfo.vMsg;
                int length3 = bArr5.length - 7;
                byte[] bArr6 = new byte[length3];
                PkgTools.copyData(bArr6, 0, bArr5, 7, length3);
                MessageRecord c16 = bfVar.c((QQAppInterface) af.this.f116342a, bArr6, msgInfo.shMsgSeq, msgInfo.uRealMsgTime, msgInfo.lMsgUid, msgInfo.shMsgType, false, false, null, true);
                if (c16 != null) {
                    arrayList.add(c16);
                }
            }
            return false;
        }

        private void l(ArrayList<MsgInfo> arrayList, ArrayList<DelMsgInfo> arrayList2, long j3, MsgInfo msgInfo, int i3, long j16, long j17, boolean z16, DelMsgInfo delMsgInfo) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageProcessor", 2, "------->msgFilter-handleC2COnlinePushMsgResp receive msg size:" + arrayList.size());
            }
            if (MessageHandlerUtils.msgFilter(af.this.f116342a, i3, String.valueOf(j17), String.valueOf(j16), msgInfo.uMsgTime, msgInfo.shMsgSeq)) {
                return;
            }
            arrayList2.remove(delMsgInfo);
            if (!((QQAppInterface) af.this.f116342a).getMsgHandler().a3().Q(new String(msgInfo.vMsg) + msgInfo.uMsgTime)) {
                long[] jArr = {msgInfo.lFromUin};
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.BaseMessageProcessor", 2, "---->handleC2COnlinePushMsgResp, new file msg, about to call handleOffLineFileResp");
                }
                af.this.a0(String.valueOf(j17), j3, jArr, msgInfo.vMsg, msgInfo.uMsgTime, msgInfo.shMsgSeq, z16);
                msgInfo.lFromUin = jArr[0];
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageProcessor", 2, "rcv a repeated offline file push msg");
            }
        }

        @Override // com.tencent.imcore.message.g.a
        protected boolean c(DelMsgInfo delMsgInfo) throws UnsupportedEncodingException {
            String uin;
            long j3;
            String str;
            int c16;
            int a16;
            long b16;
            String str2;
            byte[] bArr;
            int i3;
            boolean z16;
            long j16;
            int i16;
            int a17;
            int c17;
            String b17;
            long d16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) delMsgInfo)).booleanValue();
            }
            MsgInfo msgInfo = this.f116664j;
            short s16 = msgInfo.shMsgType;
            long j17 = msgInfo.lFromUin;
            if (this.f116656b.getUin() == null) {
                uin = af.this.f116342a.getAccount();
            } else {
                uin = this.f116656b.getUin();
            }
            long longValue = Long.valueOf(uin).longValue();
            if (169 == s16) {
                l(this.f116660f, this.f116661g, this.f116662h, this.f116664j, 0, j17, j17, false, delMsgInfo);
                this.f116655a = true;
                return true;
            }
            if (8 == s16) {
                a e16 = new a(this.f116664j, null).e();
                a17 = e16.a();
                c17 = e16.c();
                b17 = e16.b();
                d16 = e16.d();
            } else if (132 == s16) {
                b e17 = new b(this.f116664j, null).e();
                a17 = e17.a();
                c17 = e17.c();
                b17 = e17.b();
                d16 = e17.d();
            } else {
                if (732 == s16) {
                    this.f116665k = k(this.f116659e, this.f116664j);
                    str = null;
                    j3 = j17;
                } else {
                    if (230 == s16) {
                        j3 = j17;
                        c e18 = new c(this.f116664j, j17, j3).e();
                        int a18 = e18.a();
                        int d17 = e18.d();
                        String b18 = e18.b();
                        byte[] c18 = e18.c();
                        z16 = e18.f();
                        i3 = a18;
                        i16 = d17;
                        str2 = b18;
                        bArr = c18;
                        a16 = -1;
                        j16 = j3;
                        b16 = j16;
                        b(this.f116659e, this.f116662h, this.f116664j, i3, i16, str2, bArr, a16, j16, b16, z16, this.f116665k);
                        return false;
                    }
                    j3 = j17;
                    if (SystemMsg.isSystemMessage(s16)) {
                        d c19 = new d(this.f116662h, this.f116664j, s16).c();
                        c16 = c19.b();
                        b16 = c19.a();
                        str2 = null;
                        bArr = null;
                        i3 = 0;
                        a16 = -1;
                    } else {
                        str = null;
                        if (SystemMsg.isTroopSystemMessage(s16)) {
                            e d18 = new e(this.f116664j, s16, -1000, -1, j3, j3).d();
                            c16 = d18.c();
                            a16 = d18.a();
                            b16 = d18.b();
                            str2 = null;
                            bArr = null;
                            i3 = 0;
                        } else if (528 == s16) {
                            j(this.f116659e, this.f116664j, longValue);
                        } else {
                            if (QLog.isColorLevel()) {
                                QLog.w("Q.msg.BaseMessageProcessor", 2, "~~~~~handleC2COnlinePushMsgResp msgtype: unknow msgType!!!");
                            }
                            this.f116655a = true;
                            return true;
                        }
                    }
                    z16 = false;
                    j16 = j3;
                    i16 = c16;
                    b(this.f116659e, this.f116662h, this.f116664j, i3, i16, str2, bArr, a16, j16, b16, z16, this.f116665k);
                    return false;
                }
                str2 = str;
                bArr = str2;
                i3 = 0;
                i16 = -1000;
                a16 = -1;
                z16 = false;
                j16 = j3;
                b16 = j16;
                b(this.f116659e, this.f116662h, this.f116664j, i3, i16, str2, bArr, a16, j16, b16, z16, this.f116665k);
                return false;
            }
            i16 = c17;
            str2 = b17;
            j16 = d16;
            bArr = null;
            b16 = j17;
            a16 = -1;
            z16 = false;
            i3 = a17;
            b(this.f116659e, this.f116662h, this.f116664j, i3, i16, str2, bArr, a16, j16, b16, z16, this.f116665k);
            return false;
        }

        @Override // com.tencent.imcore.message.g.a
        public /* bridge */ /* synthetic */ g.a f() {
            return super.f();
        }

        @Override // com.tencent.imcore.message.g.a
        public /* bridge */ /* synthetic */ boolean g() {
            return super.g();
        }
    }

    public af(QQAppInterface qQAppInterface, MessageHandler messageHandler) {
        super(qQAppInterface, messageHandler);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) messageHandler);
        } else {
            this.f116476w = ((IRelationNTPushService) QRoute.api(IRelationNTPushService.class)).getRelationNTPushSwitch();
            m0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(byte[] bArr, int i3) {
        try {
            cmd0x2dc$GroupVisitorJoinMsg mergeFrom = new cmd0x2dc$GroupVisitorJoinMsg().mergeFrom(bArr);
            mergeFrom.uint64_group_code.get();
            List<cmd0x2dc$VisitorJoinInfo> list = mergeFrom.rpt_msg_visitor_join_info.get();
            if (list != null && list.size() > 0) {
                this.f116342a.getCurrentAccountUin();
            }
        } catch (Exception unused) {
        }
    }

    private void Z(PushMsg0x210C7Info pushMsg0x210C7Info, submsgtype0xc7$ForwardBody submsgtype0xc7_forwardbody, String str) {
        if (submsgtype0xc7_forwardbody.uint32_notify_type.has() && submsgtype0xc7_forwardbody.uint32_notify_type.get() == 1) {
            if (QLog.isColorLevel()) {
                QLog.d("HotFriend_PushMessage", 2, "handleMsgType0x210SubMsgType0xc7 push a no content " + str);
                return;
            }
            return;
        }
        if (submsgtype0xc7_forwardbody.uint32_op_type.has() && submsgtype0xc7_forwardbody.uint32_op_type.get() == 4000 && submsgtype0xc7_forwardbody.msg_relational_chain_change.has()) {
            submsgtype0xc7$RelationalChainChange submsgtype0xc7_relationalchainchange = submsgtype0xc7_forwardbody.msg_relational_chain_change.get();
            if (submsgtype0xc7_relationalchainchange.uint64_appid.get() == 10001) {
                FriendIntimateRelationshipHelper.c(this.f116342a, submsgtype0xc7_relationalchainchange, pushMsg0x210C7Info, str);
                return;
            }
            if (submsgtype0xc7_relationalchainchange.uint64_appid.get() == 19999) {
                if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("remove_mutualmark_degrade_19999", true)) {
                    com.tencent.mobileqq.mutualmark.oldlogic.c.a((QQAppInterface) this.f116342a, submsgtype0xc7_relationalchainchange, pushMsg0x210C7Info);
                }
            } else if (submsgtype0xc7_relationalchainchange.uint64_appid.get() == 10002) {
                ExtSnsFrdDataHandleHelper.b((QQAppInterface) this.f116342a, submsgtype0xc7_relationalchainchange, pushMsg0x210C7Info, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0(String str, long j3, long[] jArr, byte[] bArr, long j16, short s16, boolean z16) {
        long j17 = jArr[0];
        BuddyTransfileProcessor.A9Message analysisOffLineFileMsg = BuddyTransfileProcessor.analysisOffLineFileMsg(bArr, jArr);
        if (analysisOffLineFileMsg != null) {
            ((QQAppInterface) this.f116342a).getFileTransferHandler().K(str, String.valueOf(jArr[0]), analysisOffLineFileMsg, j16, s16, j17, z16);
        }
    }

    private boolean c0(SubMsgType0xa8$MsgBody subMsgType0xa8$MsgBody, Intent intent, int i3) {
        if (!subMsgType0xa8$MsgBody.uint32_action_subType.has()) {
            return true;
        }
        int i16 = subMsgType0xa8$MsgBody.uint32_action_subType.get();
        intent.putExtra("extra_pull_active_push_type", i3);
        intent.putExtra("extra_pull_active_push_subtype", i16);
        if (QLog.isColorLevel()) {
            QLog.d("PullActive", 2, String.format("Recv 0x210_0xa8: actionSubType: %d", Integer.valueOf(i16)));
        }
        return false;
    }

    private boolean d0(SubMsgType0xa8$MsgBody subMsgType0xa8$MsgBody, Intent intent, int i3) {
        if (!subMsgType0xa8$MsgBody.bytes_extend_content.has()) {
            return true;
        }
        String stringUtf8 = subMsgType0xa8$MsgBody.bytes_extend_content.get().toStringUtf8();
        intent.putExtra("extra_pull_active_push_type", i3);
        intent.putExtra("extra_pull_active_push_url", stringUtf8);
        if (QLog.isColorLevel()) {
            QLog.d("PullActive", 2, String.format("Recv 0x210_0xa8: url: %s", stringUtf8));
        }
        return false;
    }

    @Nullable
    private String e0(SubMsgType0xa8$MsgBody subMsgType0xa8$MsgBody, Intent intent) {
        if (!subMsgType0xa8$MsgBody.bytes_extend_content.has()) {
            return null;
        }
        String stringUtf8 = subMsgType0xa8$MsgBody.bytes_extend_content.get().toStringUtf8();
        intent.putExtra("open_chatfragment", true);
        intent.putExtra("uin", stringUtf8);
        intent.putExtra(QQNotificationManager.PARAM_FROMUIN, stringUtf8);
        intent.putExtra("uintype", 1008);
        intent.putExtra("isforceRequestDetail", true);
        if (QLog.isColorLevel()) {
            QLog.d("PullActive", 2, String.format("Recv 0x210_0xa8: public account uin: %s", stringUtf8));
        }
        return stringUtf8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0(byte[] bArr) {
        long longData = PkgTools.getLongData(bArr, 0);
        String valueOf = String.valueOf(longData);
        byte b16 = bArr[5];
        if (QLog.isColorLevel()) {
            QLog.i("Q.msg.BaseMessageProcessor", 2, "----->handleTroopExitMsg cOp = " + ((int) b16));
        }
        if (b16 == 3) {
            h0(bArr[5], 5, longData, valueOf, b16);
        } else if (b16 == 1) {
            g0(bArr[5], 5, longData, b16);
        }
    }

    private void g0(byte b16, int i3, long j3, int i16) {
        if (QLog.isColorLevel()) {
            QLog.i("Q.msg.BaseMessageProcessor", 2, "----->handleTroopExitMsg dwGroupCode = " + j3 + ", cOp = " + i16 + ", cSubOp = " + ((int) b16));
        }
        cj gAudioHandler = ((QQAppInterface) this.f116342a).getGAudioHandler();
        if (gAudioHandler != null) {
            if (b16 != 0) {
                if (b16 != 1) {
                    if (b16 != 2) {
                        if (b16 == 3) {
                            gAudioHandler.p(j3, true);
                            return;
                        }
                        return;
                    }
                } else {
                    gAudioHandler.p(j3, false);
                    return;
                }
            }
            gAudioHandler.t(j3, true);
        }
    }

    private void h0(byte b16, int i3, long j3, String str, int i16) {
        int i17 = i3 + 1 + 4;
        if (QLog.isColorLevel()) {
            QLog.i("Q.msg.BaseMessageProcessor", 2, "----->handleTroopExitMsg dwGroupCode = " + j3 + ", cOp = " + i16 + ", cSubOp = " + ((int) b16));
        }
        ay ayVar = (ay) this.f116342a.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
        String.valueOf(j3);
        if (b16 == 3) {
            k0(b16, i17, j3, str, i16, b16, ayVar, null);
        } else if (b16 == 2) {
            j0(str, ayVar, null);
        } else if (b16 == 1) {
            i0(j3);
        }
    }

    private void i0(long j3) {
        cj gAudioHandler = ((QQAppInterface) this.f116342a).getGAudioHandler();
        if (gAudioHandler != null) {
            gAudioHandler.t(j3, false);
        }
    }

    private void k0(int i3, int i16, long j3, String str, int i17, int i18, ay ayVar, HotChatInfo hotChatInfo) {
        if (QLog.isColorLevel()) {
            QLog.i("Q.msg.BaseMessageProcessor", 2, "----->handleTroopExitMsg dwGroupCode = " + j3 + ", cOp = " + i17 + ", cSubOp = " + i18 + ", cSubOp2 = " + i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l0(byte[] bArr, int i3) {
        long longData = PkgTools.getLongData(bArr, 0);
        if (bArr[4] != 15) {
            return false;
        }
        long longData2 = PkgTools.getLongData(bArr, 5);
        long longData3 = PkgTools.getLongData(bArr, 9);
        String uTFString = PkgTools.getUTFString(bArr, 15, PkgTools.getHShortData(bArr, 13));
        ((TroopManager) this.f116342a.getManager(QQManagerFactory.TROOP_MANAGER)).f0(i3, longData, NetConnInfoCenter.getServerTime(), longData3, longData2, uTFString);
        return true;
    }

    private void m0() {
        this.f116654v.a(39L, com.tencent.imcore.message.ext.codec.decoder.msgType0x210.am.class);
        this.f116654v.a(40L, com.tencent.imcore.message.ext.codec.decoder.msgType0x210.an.class);
        this.f116654v.a(166L, bm.class);
        this.f116654v.a(49L, com.tencent.imcore.message.ext.codec.decoder.msgType0x210.ao.class);
        this.f116654v.a(61L, com.tencent.imcore.message.ext.codec.decoder.msgType0x210.ap.class);
        this.f116654v.a(67L, aq.class);
        this.f116654v.a(68L, ar.class);
        this.f116654v.a(38L, com.tencent.imcore.message.ext.codec.decoder.msgType0x210.ak.class);
        this.f116654v.a(278L, com.tencent.imcore.message.ext.codec.decoder.msgType0x210.d.class);
        this.f116654v.a(279L, com.tencent.imcore.message.ext.codec.decoder.msgType0x210.e.class);
        this.f116654v.a(181L, bp.class);
        this.f116654v.a(81L, at.class);
        this.f116654v.a(74L, as.class);
        this.f116654v.a(84L, au.class);
        this.f116654v.a(102L, av.class);
        this.f116654v.a(195L, bq.class);
        this.f116654v.a(126L, bc.class);
        this.f116654v.a(107L, ax.class);
        this.f116654v.a(105L, aw.class);
        this.f116654v.a(222L, ca.class);
        this.f116654v.a(111L, com.tencent.imcore.message.ext.codec.decoder.msgType0x210.ay.class);
        this.f116654v.a(120L, ba.class);
        this.f116654v.a(280L, com.tencent.imcore.message.ext.codec.decoder.msgType0x210.f.class);
        this.f116654v.a(114L, az.class);
        this.f116654v.a(121L, bb.class);
        this.f116654v.a(133L, bd.class);
        this.f116654v.a(146L, bg.class);
        this.f116654v.a(229L, cb.class);
        this.f116654v.a(159L, bk.class);
        this.f116654v.a(162L, bl.class);
        this.f116654v.a(141L, com.tencent.imcore.message.ext.codec.decoder.msgType0x210.bf.class);
        this.f116654v.a(138L, be.class);
        this.f116654v.a(139L, be.class);
        this.f116654v.a(150L, bi.class);
        this.f116654v.a(206L, bu.class);
        this.f116654v.a(284L, com.tencent.imcore.message.ext.codec.decoder.msgType0x210.i.class);
        this.f116654v.a(148L, bh.class);
        this.f116654v.a(152L, bj.class);
        this.f116654v.a(171L, bo.class);
        this.f116654v.a(168L, bn.class);
        this.f116654v.a(197L, br.class);
        this.f116654v.a(258L, com.tencent.imcore.message.ext.codec.decoder.msgType0x210.b.class);
        this.f116654v.a(238L, cd.class);
        this.f116654v.a(249L, ce.class);
        this.f116654v.a(253L, cg.class);
        this.f116654v.a(203L, bs.class);
        this.f116654v.a(204L, bt.class);
        this.f116654v.a(207L, bv.class);
        this.f116654v.a(208L, bw.class);
        this.f116654v.a(218L, bx.class);
        this.f116654v.a(254L, ch.class);
        this.f116654v.a(221L, bz.class);
        this.f116654v.a(235L, cc.class);
        this.f116654v.a(239L, SubType0xef.class);
        this.f116654v.a(251L, cf.class);
        this.f116654v.a(273L, com.tencent.imcore.message.ext.codec.decoder.msgType0x210.c.class);
        if (!this.f116476w) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "relationNTPushSwitch:" + this.f116476w);
            this.f116654v.a(286L, SubType0x11e.class);
            this.f116654v.a(179L, SubType0xb3.class);
            this.f116654v.a(118L, SubType0x76.class);
            this.f116654v.a(199L, SubType0xc7.class);
        }
        this.f116654v.a(135L, SubType0x87.class);
        this.f116654v.a(287L, com.tencent.imcore.message.ext.codec.decoder.msgType0x210.j.class);
        this.f116654v.a(295L, com.tencent.imcore.message.ext.codec.decoder.msgType0x210.n.class);
        this.f116654v.a(297L, com.tencent.imcore.message.ext.codec.decoder.msgType0x210.n.class);
        this.f116654v.a(288L, com.tencent.imcore.message.ext.codec.decoder.msgType0x210.k.class);
        this.f116654v.a(293L, com.tencent.imcore.message.ext.codec.decoder.msgType0x210.l.class);
        this.f116654v.a(282L, com.tencent.imcore.message.ext.codec.decoder.msgType0x210.g.class);
        this.f116654v.a(294L, com.tencent.imcore.message.ext.codec.decoder.msgType0x210.m.class);
        this.f116654v.a(283L, com.tencent.imcore.message.ext.codec.decoder.msgType0x210.h.class);
        this.f116654v.a(307L, com.tencent.imcore.message.ext.codec.decoder.msgType0x210.o.class);
        this.f116654v.a(313L, com.tencent.imcore.message.ext.codec.decoder.msgType0x210.p.class);
        this.f116654v.a(324L, com.tencent.imcore.message.ext.codec.decoder.msgType0x210.q.class);
        this.f116654v.a(325L, com.tencent.imcore.message.ext.codec.decoder.msgType0x210.r.class);
        this.f116654v.a(326L, com.tencent.imcore.message.ext.codec.decoder.msgType0x210.s.class);
        this.f116654v.a(328L, com.tencent.imcore.message.ext.codec.decoder.msgType0x210.t.class);
        this.f116654v.a(329L, com.tencent.imcore.message.ext.codec.decoder.msgType0x210.u.class);
        this.f116654v.a(336L, com.tencent.imcore.message.ext.codec.decoder.msgType0x210.y.class);
        this.f116654v.a(337L, com.tencent.imcore.message.ext.codec.decoder.msgType0x210.z.class);
        this.f116654v.a(338L, com.tencent.imcore.message.ext.codec.decoder.msgType0x210.aa.class);
        this.f116654v.a(340L, com.tencent.imcore.message.ext.codec.decoder.msgType0x210.ab.class);
        this.f116654v.a(341L, com.tencent.imcore.message.ext.codec.decoder.msgType0x210.ac.class);
        this.f116654v.a(343L, com.tencent.imcore.message.ext.codec.decoder.msgType0x210.ae.class);
        this.f116654v.a(344L, com.tencent.imcore.message.ext.codec.decoder.msgType0x210.af.class);
        this.f116654v.a(330L, com.tencent.imcore.message.ext.codec.decoder.msgType0x210.v.class);
        this.f116654v.a(333L, com.tencent.imcore.message.ext.codec.decoder.msgType0x210.x.class);
        this.f116654v.a(332L, com.tencent.imcore.message.ext.codec.decoder.msgType0x210.w.class);
        this.f116654v.a(342L, com.tencent.imcore.message.ext.codec.decoder.msgType0x210.ad.class);
        this.f116654v.a(347L, com.tencent.imcore.message.ext.codec.decoder.msgType0x210.ag.class);
        this.f116654v.a(349L, com.tencent.imcore.message.ext.codec.decoder.msgType0x210.ah.class);
        this.f116654v.a(362L, com.tencent.imcore.message.ext.codec.decoder.msgType0x210.aj.class);
        this.f116654v.a(350L, com.tencent.imcore.message.ext.codec.decoder.msgType0x210.ai.class);
    }

    @Override // com.tencent.imcore.message.g
    protected void A(FromServiceMsg fromServiceMsg, ArrayList<MessageRecord> arrayList, ArrayList<String> arrayList2, SvcReqPushMsg svcReqPushMsg, ArrayList<DelMsgInfo> arrayList3, long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, fromServiceMsg, arrayList, arrayList2, svcReqPushMsg, arrayList3, Long.valueOf(j3), Integer.valueOf(i3));
            return;
        }
        if (arrayList2.size() > 0) {
            X(arrayList2);
        }
        ((BaseMessageHandler) this.f116342a.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).delC2COnlinePushMsg(j3, arrayList3, i3, fromServiceMsg.getRequestSsoSeq(), null);
        if (arrayList.size() > 0) {
            boolean hasRecvAndUnreadMsg = BaseMessageHandlerUtils.hasRecvAndUnreadMsg(arrayList);
            int j16 = ad.j(arrayList, (com.tencent.mobileqq.service.message.e) this.f116342a.getMsgCache());
            IMessageFacade iMessageFacade = (IMessageFacade) this.f116342a.getRuntimeService(IMessageFacade.class, "");
            String valueOf = String.valueOf(j3);
            if (hasRecvAndUnreadMsg && this.f116342a.isBackgroundStop) {
                z16 = true;
            }
            iMessageFacade.addMessage(arrayList, valueOf, z16);
            ((com.tencent.mobileqq.service.message.e) this.f116342a.getMsgCache()).L1((int) svcReqPushMsg.uMsgTime);
            n("handleGetBuddyMessageResp", true, j16, this.f116343b.needNotifyNotification(hasRecvAndUnreadMsg), false);
        }
        com.tencent.mobileqq.app.handler.c.b(arrayList, true, this.f116342a);
    }

    @Override // com.tencent.imcore.message.g
    protected void B(SvcReqPushMsg svcReqPushMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) svcReqPushMsg);
            return;
        }
        ((QQAppInterface) this.f116342a).userActiveStatus = svcReqPushMsg.wUserActive;
        if ((svcReqPushMsg.wGeneralFlag & 32) == 32) {
            com.tencent.mobileqq.util.az.d(true);
        } else {
            com.tencent.mobileqq.util.az.d(false);
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "OnlinePush.ReqPush,notify.wUserActive:", Integer.valueOf(svcReqPushMsg.wUserActive), ", muteGeneralFlag:", Integer.valueOf(svcReqPushMsg.wGeneralFlag));
        }
    }

    @Override // com.tencent.imcore.message.g
    protected void E(MsgType0x210 msgType0x210) {
        ArrayList<PluginNum> arrayList;
        com.tencent.mobileqq.servlet.e eVar;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) msgType0x210);
            return;
        }
        MsgType0x210SubMsgType0x24 msgType0x210SubMsgType0x24 = msgType0x210.stMsgInfo0x24;
        if (msgType0x210SubMsgType0x24 != null && (arrayList = msgType0x210SubMsgType0x24.vPluginNumList) != null && arrayList != null && arrayList.size() > 0 && (eVar = (com.tencent.mobileqq.servlet.e) this.f116342a.getManager(QQManagerFactory.GAMECENTER_MANAGER)) != null) {
            for (PluginNum pluginNum : arrayList) {
                if (pluginNum != null) {
                    long j3 = pluginNum.dwID;
                    if (pluginNum.cFlag == 0) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    eVar.i(j3, z16, pluginNum.dwNUm);
                }
            }
        }
    }

    @Override // com.tencent.imcore.message.g
    protected void F(MsgType0x210 msgType0x210) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) msgType0x210);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0xea, [S2C push for ark]");
        }
        try {
            submsgtype0xea$MsgBody submsgtype0xea_msgbody = new submsgtype0xea$MsgBody();
            if (L(msgType0x210)) {
                submsgtype0xea_msgbody.mergeFrom(msgType0x210.vProtobuf);
                String str2 = "";
                if (!submsgtype0xea_msgbody.bytes_title.has()) {
                    str = "";
                } else {
                    str = submsgtype0xea_msgbody.bytes_title.get().toStringUtf8();
                }
                if (submsgtype0xea_msgbody.bytes_content.has()) {
                    str2 = submsgtype0xea_msgbody.bytes_content.get().toStringUtf8();
                }
                com.tencent.mobileqq.ark.n.c().h(this.f116342a, str, str2);
            }
        } catch (Exception e16) {
            QLog.e("Q.msg.BaseMessageProcessor", 1, "[msg0x210.uSubMsgType == 0xea], errInfo->" + e16.getMessage());
        }
    }

    public boolean S(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, i3)).booleanValue();
        }
        if (i3 != 3 && i3 != 9 && i3 != 10) {
            return false;
        }
        return true;
    }

    public boolean T(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, i3)).booleanValue();
        }
        if (i3 == 1 || i3 == 3) {
            return true;
        }
        return false;
    }

    public boolean U(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, i3)).booleanValue();
        }
        if (i3 == 1 || i3 == 2) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.imcore.message.g
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public f C(g.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (f) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
        }
        return new f(bVar);
    }

    public void X(ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) arrayList);
            return;
        }
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                AppShareID d06 = ((com.tencent.mobileqq.service.message.e) this.f116342a.getMsgCache()).d0(next);
                if (d06 == null || System.currentTimeMillis() - d06.updateTime >= 86400000) {
                    if (((com.tencent.mobileqq.service.message.e) this.f116342a.getMsgCache()).e0().add(next)) {
                        GetResourceReqInfo getResourceReqInfo = new GetResourceReqInfo();
                        getResourceReqInfo.uiResID = 0L;
                        getResourceReqInfo.strPkgName = next;
                        getResourceReqInfo.uiCurVer = 0L;
                        getResourceReqInfo.sResType = (short) 4;
                        getResourceReqInfo.sLanType = (short) 0;
                        getResourceReqInfo.sReqType = (short) 1;
                        arrayList2.add(getResourceReqInfo);
                        if (QLog.isColorLevel()) {
                            QLog.d("share_appid", 2, "Request list add appid = " + next);
                        }
                    }
                }
            }
            if (arrayList2.size() > 0) {
                AppInterface appInterface = this.f116342a;
                com.tencent.mobileqq.service.config.b.a(appInterface, appInterface.getCurrentAccountUin(), arrayList2);
            }
        }
    }

    public void Y(byte[] bArr, PushMsg0x210C7Info pushMsg0x210C7Info, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, bArr, pushMsg0x210C7Info, str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("HotFriend_PushMessage", 2, "handleMsgType0x210SubMsgType0xc7 " + str);
        }
        if (bArr == null) {
            return;
        }
        try {
            Iterator<submsgtype0xc7$ForwardBody> it = new submsgtype0xc7$MsgBody().mergeFrom(bArr).rpt_msg_mod_infos.get().iterator();
            while (it.hasNext()) {
                Z(pushMsg0x210C7Info, it.next(), str);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("HotFriend_PushMessage", 2, "handleMsgType0x210SubMsgType0xc7 " + str, e16);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b0(SubMsgType0xa8$MsgBody subMsgType0xa8$MsgBody) {
        String e06;
        Context baseContext;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) subMsgType0xa8$MsgBody);
            return;
        }
        if (!n0()) {
            if (QLog.isColorLevel()) {
                QLog.d("PullActive", 2, "handlePullActivePushMsg, isNeedNotifyActivePush is false");
                return;
            }
            return;
        }
        ReportController.o(this.f116342a, "CliOper", "", "", "0X80065A9", "0X80065A9", 0, 0, "", "", "", "");
        if (!subMsgType0xa8$MsgBody.bytes_msg_summary.has()) {
            return;
        }
        String stringUtf8 = subMsgType0xa8$MsgBody.bytes_msg_summary.get().toStringUtf8();
        Intent aliasIntent = SplashActivity.getAliasIntent(this.f116342a.getApp());
        aliasIntent.putExtra("tab_index", com.tencent.mobileqq.activity.home.impl.a.f183038a);
        aliasIntent.putExtra(SplashActivity.FRAGMENT_ID, 1);
        aliasIntent.setFlags(335544320);
        int i3 = subMsgType0xa8$MsgBody.uint32_action_type.get();
        if (QLog.isColorLevel()) {
            QLog.d("PullActive", 2, String.format("Recv 0x210_0xa8: actionType: %d, brief: %s", Integer.valueOf(i3), stringUtf8));
        }
        if (i3 == 1) {
            if (c0(subMsgType0xa8$MsgBody, aliasIntent, i3)) {
                return;
            }
        } else if (i3 == 2) {
            if (d0(subMsgType0xa8$MsgBody, aliasIntent, i3)) {
                return;
            }
        } else {
            if (i3 != 3 || (e06 = e0(subMsgType0xa8$MsgBody, aliasIntent)) == null) {
                return;
            }
            aliasIntent.putExtra(com.tencent.mobileqq.managers.h.f243720m, stringUtf8);
            aliasIntent.putExtra("activepull_push_flag", true);
            String[] strArr = {stringUtf8, com.tencent.mobileqq.managers.h.f243719i, stringUtf8};
            Bitmap g16 = com.tencent.mobileqq.util.j.g(this.f116342a.getApp().getResources(), R.drawable.icon);
            ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f116342a.getCurrentAccountUin(), "CMD_SHOW_NOTIFIYCATION");
            toServiceMsg.extraData.putStringArray("cmds", strArr);
            toServiceMsg.extraData.putParcelable("intent", aliasIntent);
            toServiceMsg.extraData.putParcelable(MimeHelper.IMAGE_SUBTYPE_BITMAP, g16);
            this.f116342a.sendToService(toServiceMsg);
            baseContext = this.f116342a.getApp().getBaseContext();
            if (!QQUtils.k(baseContext)) {
                com.tencent.mobileqq.managers.h hVar = (com.tencent.mobileqq.managers.h) this.f116342a.getManager(QQManagerFactory.PULL_ACTIVE_MANAGER);
                hVar.d(aliasIntent);
                com.tencent.mobileqq.managers.i iVar = (com.tencent.mobileqq.managers.i) this.f116342a.getManager(QQManagerFactory.QQLS_DATA_MANAGER);
                if (SettingCloneUtil.readValue(baseContext, this.f116342a.getCurrentAccountUin(), baseContext.getString(R.string.f171097c62), AppConstants.QQSETTING_LOCKSCREENMSG_WHENEXIST_KEY, true)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("QQLSActivity", 2, "handlePullActivePushMsg, start lsActivity");
                    }
                    iVar.f(this.f116342a, AppConstants.PULL_ACTIVE_PUSH_UIN, AppConstants.VALUE.UIN_TYPE_PULL_ACTIVE_PUSH, false, com.tencent.mobileqq.managers.d.a(e06, 1008, aliasIntent));
                }
                ((IMessageFacade) this.f116342a.getRuntimeService(IMessageFacade.class, "")).setChangeAndNotify(hVar.f243723f);
                return;
            }
            return;
        }
        e06 = "";
        aliasIntent.putExtra(com.tencent.mobileqq.managers.h.f243720m, stringUtf8);
        aliasIntent.putExtra("activepull_push_flag", true);
        String[] strArr2 = {stringUtf8, com.tencent.mobileqq.managers.h.f243719i, stringUtf8};
        Bitmap g162 = com.tencent.mobileqq.util.j.g(this.f116342a.getApp().getResources(), R.drawable.icon);
        ToServiceMsg toServiceMsg2 = new ToServiceMsg("mobileqq.service", this.f116342a.getCurrentAccountUin(), "CMD_SHOW_NOTIFIYCATION");
        toServiceMsg2.extraData.putStringArray("cmds", strArr2);
        toServiceMsg2.extraData.putParcelable("intent", aliasIntent);
        toServiceMsg2.extraData.putParcelable(MimeHelper.IMAGE_SUBTYPE_BITMAP, g162);
        this.f116342a.sendToService(toServiceMsg2);
        baseContext = this.f116342a.getApp().getBaseContext();
        if (!QQUtils.k(baseContext)) {
        }
    }

    public boolean n0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        AppInterface appInterface = this.f116342a;
        if ((appInterface.isBackgroundPause || appInterface.isBackgroundStop) && ((QQAppInterface) appInterface).userActiveStatus == 0) {
            return true;
        }
        return false;
    }

    public void o0(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            ((ISVIPHandler) this.f116342a.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).setSelfBubbleId(i3);
        }
    }

    private void j0(String str, ay ayVar, HotChatInfo hotChatInfo) {
    }
}

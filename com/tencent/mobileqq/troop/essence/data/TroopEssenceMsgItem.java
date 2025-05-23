package com.tencent.mobileqq.troop.essence.data;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: P */
@KeepClassConstructor
@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "troopUin,msgSeq,msgRandom")
/* loaded from: classes19.dex */
public class TroopEssenceMsgItem extends Entity implements Serializable {
    static IPatchRedirector $redirector_ = null;
    public static final int OPTYPE_ADD = 1;
    public static final int OPTYPE_BATCH_ADD = 3;
    public static final int OPTYPE_CANCEL = 2;
    public static final String TAG = "TroopEssenceMsgItem";
    public long graytipuniseq;
    public int msgRandom;
    public String msgSenderUin;
    public long msgSeq;

    @notColumn
    public int msgType;
    public long opTime;
    public int opType;
    public String opUin;
    public long troopUin;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public long f295267a;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList<TroopEssenceMsgItem> f295268b;

        /* renamed from: c, reason: collision with root package name */
        public String f295269c;

        /* renamed from: d, reason: collision with root package name */
        public String f295270d;

        public a(long j3, ArrayList<TroopEssenceMsgItem> arrayList, String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), arrayList, str, str2);
                return;
            }
            this.f295267a = j3;
            this.f295268b = arrayList;
            this.f295269c = str;
            this.f295270d = str2;
        }

        public String toString() {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("msgList:");
            ArrayList<TroopEssenceMsgItem> arrayList = this.f295268b;
            if (arrayList != null) {
                str = arrayList.toString();
            } else {
                str = "null";
            }
            sb5.append(str);
            sb5.append(" ");
            sb5.append("opUin:");
            sb5.append(this.f295269c);
            sb5.append(" ");
            sb5.append("opNickName:");
            sb5.append(this.f295270d);
            return sb5.toString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public long f295271a;

        /* renamed from: b, reason: collision with root package name */
        public long f295272b;

        /* renamed from: c, reason: collision with root package name */
        public int f295273c;

        public b(long j3, long j16, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3));
                return;
            }
            this.f295271a = j3;
            this.f295272b = j16;
            this.f295273c = i3;
        }

        public boolean equals(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, obj)).booleanValue();
            }
            if (obj == null || !(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (bVar.f295271a != this.f295271a || bVar.f295272b != this.f295272b || bVar.f295273c != this.f295273c) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return ((int) this.f295271a) + ((int) this.f295272b) + this.f295273c;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return "troopUin:" + this.f295271a + " msgSeq:" + this.f295272b + " msgRandom:" + this.f295273c;
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f295274a;

        /* renamed from: b, reason: collision with root package name */
        public String f295275b;

        /* renamed from: c, reason: collision with root package name */
        public String f295276c;

        /* renamed from: d, reason: collision with root package name */
        public long f295277d;

        /* renamed from: e, reason: collision with root package name */
        public long f295278e;

        public c(int i3, String str, String str2, long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, str2, Long.valueOf(j3), Long.valueOf(j16));
                return;
            }
            this.f295274a = i3;
            this.f295275b = str;
            this.f295276c = str2;
            this.f295277d = j3;
            this.f295278e = j16;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "opType:" + this.f295274a + " msgSenderUin:" + this.f295275b + " opUin:" + this.f295276c + " opTime:" + this.f295277d + "graytipuniseq:" + this.f295278e;
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public TroopEssenceMsgItem f295279a;

        /* renamed from: b, reason: collision with root package name */
        public int f295280b;

        /* renamed from: c, reason: collision with root package name */
        public String f295281c;

        /* renamed from: d, reason: collision with root package name */
        public String f295282d;

        /* renamed from: e, reason: collision with root package name */
        public String f295283e;

        /* renamed from: f, reason: collision with root package name */
        public int f295284f;

        public d(TroopEssenceMsgItem troopEssenceMsgItem, int i3, String str, String str2, String str3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, troopEssenceMsgItem, Integer.valueOf(i3), str, str2, str3, Integer.valueOf(i16));
                return;
            }
            this.f295279a = troopEssenceMsgItem;
            this.f295280b = i3;
            this.f295281c = str;
            this.f295282d = str2;
            this.f295284f = i16;
            this.f295283e = str3;
        }

        public String toString() {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("msgItem:");
            TroopEssenceMsgItem troopEssenceMsgItem = this.f295279a;
            if (troopEssenceMsgItem != null) {
                str = troopEssenceMsgItem.toString();
            } else {
                str = "null";
            }
            sb5.append(str);
            sb5.append(" ");
            sb5.append("graytipmsgseq:");
            sb5.append(this.f295280b);
            sb5.append(" ");
            sb5.append("opNickName:");
            sb5.append(this.f295281c);
            sb5.append(" ");
            sb5.append("senderNickName:");
            sb5.append(this.f295282d);
            sb5.append(" ");
            sb5.append("feedUrl:");
            sb5.append(this.f295283e);
            sb5.append(" ");
            sb5.append("msgType:");
            sb5.append(this.f295284f);
            return sb5.toString();
        }
    }

    public TroopEssenceMsgItem() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "troopUin:" + this.troopUin + " msgSeq:" + this.msgSeq + " msgRandom:" + this.msgRandom + " opType:" + this.opType + " msgSenderUin:" + this.msgSenderUin + " opUin:" + this.opUin + " opTime:" + this.opTime + " graytipuniseq:" + this.graytipuniseq + " ";
    }

    public TroopEssenceMsgItem(b bVar, c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar, (Object) cVar);
            return;
        }
        if (bVar != null) {
            this.troopUin = bVar.f295271a;
            this.msgSeq = bVar.f295272b;
            this.msgRandom = bVar.f295273c;
        }
        if (cVar != null) {
            this.opType = cVar.f295274a;
            this.msgSenderUin = cVar.f295275b;
            this.opUin = cVar.f295276c;
            this.opTime = cVar.f295277d;
            this.graytipuniseq = cVar.f295278e;
        }
    }
}

package com.tencent.mobileqq.leba.core;

import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.transaction.BaseTransaction;
import com.tencent.mobileqq.persistence.transaction.PersistTransaction;
import com.tencent.mobileqq.persistence.transaction.UpdateTransaction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0007J\"\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\n2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0002\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/leba/core/c;", "", "", "Lcom/tencent/mobileqq/leba/entity/LebaPluginInfo;", "resultInfos", "Lcom/tencent/mobileqq/leba/core/c$a;", "b", "Lcom/tencent/mobileqq/persistence/EntityManager;", "em", "respInfo", "Lcom/tencent/mobileqq/persistence/transaction/BaseTransaction;", "a", "<init>", "()V", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f240367a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/leba/core/c$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "c", "()Z", "isSuccess", "b", "isChange", "isAddNew", "<init>", "(ZZZ)V", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final /* data */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final boolean isSuccess;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final boolean isChange;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final boolean isAddNew;

        public a(boolean z16, boolean z17, boolean z18) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18));
                return;
            }
            this.isSuccess = z16;
            this.isChange = z17;
            this.isAddNew = z18;
        }

        public final boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            return this.isAddNew;
        }

        public final boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return this.isChange;
        }

        public final boolean c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return this.isSuccess;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof a)) {
                return false;
            }
            a aVar = (a) other;
            if (this.isSuccess == aVar.isSuccess && this.isChange == aVar.isChange && this.isAddNew == aVar.isAddNew) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v2, types: [int] */
        /* JADX WARN: Type inference failed for: r0v7 */
        /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            boolean z16 = this.isSuccess;
            int i3 = 1;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i16 = r06 * 31;
            ?? r26 = this.isChange;
            int i17 = r26;
            if (r26 != 0) {
                i17 = 1;
            }
            int i18 = (i16 + i17) * 31;
            boolean z17 = this.isAddNew;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            return i18 + i3;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return "SaveDbResult(isSuccess=" + this.isSuccess + ", isChange=" + this.isChange + ", isAddNew=" + this.isAddNew + ")";
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17332);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f240367a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final BaseTransaction<?> a(EntityManager em5, LebaPluginInfo respInfo) {
        LebaPluginInfo lebaPluginInfo = null;
        if (em5 != null && respInfo != null) {
            long j3 = respInfo.uiResId;
            if (j3 > 0) {
                Entity find = DBMethodProxy.find(em5, LebaPluginInfo.class, "uiResId=?", new String[]{String.valueOf(j3)});
                if (find instanceof LebaPluginInfo) {
                    lebaPluginInfo = (LebaPluginInfo) find;
                }
                if (lebaPluginInfo != null) {
                    lebaPluginInfo.sResSeq = respInfo.sResSeq;
                    lebaPluginInfo.strPkgName = respInfo.strPkgName;
                    lebaPluginInfo.strResName = respInfo.strResName;
                    lebaPluginInfo.strResURL = respInfo.strResURL;
                    lebaPluginInfo.sResSubType = respInfo.sResSubType;
                    lebaPluginInfo.strGotoUrl = respInfo.strGotoUrl;
                    lebaPluginInfo.cCanChangeState = respInfo.cCanChangeState;
                    lebaPluginInfo.resConf = respInfo.resConf;
                    lebaPluginInfo.cDataType = respInfo.cDataType;
                    lebaPluginInfo.showInSimpleMode = respInfo.showInSimpleMode;
                    lebaPluginInfo.strGridIconUrl = respInfo.strGridIconUrl;
                    return new UpdateTransaction(lebaPluginInfo);
                }
                return new PersistTransaction(respInfo);
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x009a  */
    @JvmStatic
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final a b(@NotNull List<? extends LebaPluginInfo> resultInfos) {
        boolean z16;
        boolean z17;
        boolean z18;
        Intrinsics.checkNotNullParameter(resultInfos, "resultInfos");
        EntityManager createEntityManager = MobileQQ.sMobileQQ.peekAppRuntime().getEntityManagerFactory().createEntityManager();
        StringBuffer stringBuffer = new StringBuffer();
        try {
            try {
                stringBuffer.append("onGetPluginConfig saveDb start");
                ArrayList arrayList = new ArrayList();
                z16 = false;
                z17 = false;
                for (LebaPluginInfo lebaPluginInfo : resultInfos) {
                    try {
                        if (lebaPluginInfo != null) {
                            stringBuffer.append(lebaPluginInfo);
                            short s16 = lebaPluginInfo.sResSubType;
                            if (s16 == 0 || s16 == 2) {
                                if (lebaPluginInfo.state == 3) {
                                    BaseTransaction<?> a16 = f240367a.a(createEntityManager, lebaPluginInfo);
                                    if (a16 != null) {
                                        arrayList.add(a16);
                                    }
                                    z16 = true;
                                    z17 = true;
                                }
                                if (lebaPluginInfo.state == 1) {
                                    BaseTransaction<?> a17 = f240367a.a(createEntityManager, lebaPluginInfo);
                                    if (a17 != null) {
                                        arrayList.add(a17);
                                    }
                                    z16 = true;
                                }
                            }
                            if (lebaPluginInfo.state == 2) {
                                LebaPluginInfo.remove(createEntityManager, lebaPluginInfo.uiResId);
                                z16 = true;
                            }
                        }
                    } catch (Exception e16) {
                        e = e16;
                        QLog.i("LebaPluginDbHelper", 1, "onGetPluginConfig", e);
                        createEntityManager.close();
                        z18 = false;
                        if (QLog.isColorLevel()) {
                        }
                        return new a(z18, z16, z17);
                    }
                }
                if (arrayList.size() > 0) {
                    createEntityManager.doMultiDBOperateByTransaction(arrayList);
                }
                createEntityManager.close();
                z18 = true;
            } catch (Exception e17) {
                e = e17;
                z16 = false;
                z17 = false;
            }
            if (QLog.isColorLevel()) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("onGetPluginConfig saveDb end, saveDbSuc=%b, isAddNew=%b, isChange=%b", Arrays.copyOf(new Object[]{Boolean.valueOf(z18), Boolean.valueOf(z17), Boolean.valueOf(z16)}, 3));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                stringBuffer.append(format);
                QLog.i("LebaPluginDbHelper", 2, stringBuffer.toString());
            }
            return new a(z18, z16, z17);
        } catch (Throwable th5) {
            createEntityManager.close();
            throw th5;
        }
    }
}

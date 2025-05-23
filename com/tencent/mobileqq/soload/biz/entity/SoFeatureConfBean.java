package com.tencent.mobileqq.soload.biz.entity;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/soload/biz/entity/SoFeatureConfBean;", "", "()V", "migrateConf", "Lcom/tencent/mobileqq/soload/biz/entity/SoFeatureConfBean$Companion$MigrateConf;", "getMigrateConf", "()Lcom/tencent/mobileqq/soload/biz/entity/SoFeatureConfBean$Companion$MigrateConf;", "setMigrateConf", "(Lcom/tencent/mobileqq/soload/biz/entity/SoFeatureConfBean$Companion$MigrateConf;)V", "priorityConf", "Lcom/tencent/mobileqq/soload/biz/entity/SoFeatureConfBean$Companion$PriorityConf;", "getPriorityConf", "()Lcom/tencent/mobileqq/soload/biz/entity/SoFeatureConfBean$Companion$PriorityConf;", "setPriorityConf", "(Lcom/tencent/mobileqq/soload/biz/entity/SoFeatureConfBean$Companion$PriorityConf;)V", "toString", "", "Companion", "soloader-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes18.dex */
public final class SoFeatureConfBean {
    static IPatchRedirector $redirector_;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private Companion.MigrateConf migrateConf;

    @NotNull
    private Companion.PriorityConf priorityConf;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0002\u0007\bB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/soload/biz/entity/SoFeatureConfBean$Companion;", "", "()V", "parse", "Lcom/tencent/mobileqq/soload/biz/entity/SoFeatureConfBean;", "dataObj", "Lorg/json/JSONObject;", "MigrateConf", "PriorityConf", "soloader-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/soload/biz/entity/SoFeatureConfBean$Companion$MigrateConf;", "", "()V", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "", "getSwitch", "()I", "setSwitch", "(I)V", "toString", "", "soloader-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes18.dex */
        public static final class MigrateConf {
            static IPatchRedirector $redirector_;
            private int switch;

            public MigrateConf() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                } else {
                    this.switch = 1;
                }
            }

            public final int getSwitch() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
                }
                return this.switch;
            }

            public final void setSwitch(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, i3);
                } else {
                    this.switch = i3;
                }
            }

            @NotNull
            public String toString() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (String) iPatchRedirector.redirect((short) 4, (Object) this);
                }
                return "MigrateConf(switch=" + this.switch + ')';
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/soload/biz/entity/SoFeatureConfBean$Companion$PriorityConf;", "", "()V", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "", "getSwitch", "()I", "setSwitch", "(I)V", "toString", "", "soloader-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes18.dex */
        public static final class PriorityConf {
            static IPatchRedirector $redirector_;
            private int switch;

            public PriorityConf() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            public final int getSwitch() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
                }
                return this.switch;
            }

            public final void setSwitch(int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, i3);
                } else {
                    this.switch = i3;
                }
            }

            @NotNull
            public String toString() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return (String) iPatchRedirector.redirect((short) 4, (Object) this);
                }
                return "PriorityConf(switch=" + this.switch + ')';
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @JvmStatic
        @NotNull
        public final SoFeatureConfBean parse(@Nullable JSONObject dataObj) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (SoFeatureConfBean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) dataObj);
            }
            SoFeatureConfBean soFeatureConfBean = new SoFeatureConfBean();
            if (dataObj != null) {
                JSONObject optJSONObject = dataObj.optJSONObject("priorityConf");
                PriorityConf priorityConf = soFeatureConfBean.getPriorityConf();
                int i16 = 0;
                if (optJSONObject != null) {
                    i3 = optJSONObject.optInt(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH);
                } else {
                    i3 = 0;
                }
                priorityConf.setSwitch(i3);
                JSONObject optJSONObject2 = dataObj.optJSONObject("migrateConf");
                MigrateConf migrateConf = soFeatureConfBean.getMigrateConf();
                if (optJSONObject2 != null) {
                    i16 = optJSONObject2.optInt(TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH);
                }
                migrateConf.setSwitch(i16);
            }
            return soFeatureConfBean;
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33619);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public SoFeatureConfBean() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.priorityConf = new Companion.PriorityConf();
            this.migrateConf = new Companion.MigrateConf();
        }
    }

    @JvmStatic
    @NotNull
    public static final SoFeatureConfBean parse(@Nullable JSONObject jSONObject) {
        return INSTANCE.parse(jSONObject);
    }

    @NotNull
    public final Companion.MigrateConf getMigrateConf() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Companion.MigrateConf) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.migrateConf;
    }

    @NotNull
    public final Companion.PriorityConf getPriorityConf() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Companion.PriorityConf) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.priorityConf;
    }

    public final void setMigrateConf(@NotNull Companion.MigrateConf migrateConf) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) migrateConf);
        } else {
            Intrinsics.checkNotNullParameter(migrateConf, "<set-?>");
            this.migrateConf = migrateConf;
        }
    }

    public final void setPriorityConf(@NotNull Companion.PriorityConf priorityConf) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) priorityConf);
        } else {
            Intrinsics.checkNotNullParameter(priorityConf, "<set-?>");
            this.priorityConf = priorityConf;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "SoFeatureConfBean(priorityConf=" + this.priorityConf + ", migrateConf=" + this.migrateConf + ')';
    }
}

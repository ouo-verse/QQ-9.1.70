package com.tencent.mobileqq.leba.entity;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\n\n\u0002\b\u0012\u0018\u0000  2\u00020\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0016\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0005J\u0006\u0010\n\u001a\u00020\tR\u0016\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000fR\u0016\u0010\u0015\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000fR\u0016\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u000fR\u0016\u0010\u0017\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u000fR\u0016\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u000fR\u0016\u0010\u001c\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0012R\u0016\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0019\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/leba/entity/LebaPluginConfig;", "Lcom/tencent/mobileqq/persistence/Entity;", "", "mode", "style", "", "checkAvailable", "checkAllowChange", "showInSimpleMode", "", "printLog", "", "uiResId", "J", "strResName", "Ljava/lang/String;", "", "sResSubType", ExifInterface.LATITUDE_SOUTH, "strGotoUrl", "strResURL", "strGridIconUrl", "strSimpleResUrl", "resConf", "groupId", "I", "priority", "allowChange", "show", "showVer", "<init>", "()V", "Companion", "a", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class LebaPluginConfig extends Entity {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final short SHOW_FALSE = 1;
    public static final short SHOW_TRUE = 0;

    @NotNull
    private static final String STYLE_FEEDS = "feeds";

    @NotNull
    private static final String STYLE_LIST = "list";

    @NotNull
    public static final String TAG = "PluginConfig";

    @JvmField
    @NotNull
    public String allowChange;

    @JvmField
    public int groupId;

    @JvmField
    public int priority;

    @JvmField
    @NotNull
    public String resConf;

    @JvmField
    public short sResSubType;

    @JvmField
    public short show;

    @JvmField
    public int showVer;

    @JvmField
    @NotNull
    public String strGotoUrl;

    @JvmField
    @NotNull
    public String strGridIconUrl;

    @JvmField
    @NotNull
    public String strResName;

    @JvmField
    @NotNull
    public String strResURL;

    @JvmField
    @NotNull
    public String strSimpleResUrl;

    @JvmField
    @NotNull
    public String style;

    @unique
    @JvmField
    public long uiResId;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/leba/entity/LebaPluginConfig$a;", "", "Lcom/tencent/mobileqq/persistence/EntityManager;", "em", "", "Lcom/tencent/mobileqq/leba/entity/LebaPluginConfig;", "a", "", "SHOW_FALSE", ExifInterface.LATITUDE_SOUTH, "SHOW_TRUE", "", "STYLE_FEEDS", "Ljava/lang/String;", "STYLE_LIST", "TAG", "<init>", "()V", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.leba.entity.LebaPluginConfig$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @JvmStatic
        @NotNull
        public final List<LebaPluginConfig> a(@NotNull EntityManager em5) {
            List<LebaPluginConfig> emptyList;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) em5);
            }
            Intrinsics.checkNotNullParameter(em5, "em");
            List query = em5.query(LebaPluginConfig.class, false, "", null, null, null, null, null);
            boolean z16 = query instanceof List;
            List list = query;
            if (!z16) {
                list = null;
            }
            if (list == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                return emptyList;
            }
            return list;
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17728);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public LebaPluginConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.strResName = "";
        this.strGotoUrl = "";
        this.strResURL = "";
        this.strGridIconUrl = "";
        this.strSimpleResUrl = "";
        this.resConf = "";
        this.allowChange = "";
        this.style = "";
    }

    @JvmStatic
    @NotNull
    public static final List<LebaPluginConfig> getAll(@NotNull EntityManager entityManager) {
        return INSTANCE.a(entityManager);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0056, code lost:
    
        if (r7.equals("true") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0071, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006e, code lost:
    
        if (r7.equals("all") == false) goto L38;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:15:0x003d. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean checkAllowChange(int mode, int style) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(mode), Integer.valueOf(style))).booleanValue();
        }
        String str = this.allowChange;
        if (str != null) {
            if (str.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                switch (str.hashCode()) {
                    case 96673:
                        break;
                    case 3322014:
                        if (str.equals("list")) {
                            if (style != 1) {
                                return false;
                            }
                            return true;
                        }
                        QLog.e(TAG, 1, "parseAllowChange error! unknown config: " + str);
                        return false;
                    case 3569038:
                        break;
                    case 97308309:
                        if (str.equals("feeds")) {
                            if (style != 2) {
                                return false;
                            }
                            return true;
                        }
                        QLog.e(TAG, 1, "parseAllowChange error! unknown config: " + str);
                        return false;
                    default:
                        QLog.e(TAG, 1, "parseAllowChange error! unknown config: " + str);
                        return false;
                }
            }
        }
        return true;
    }

    public final boolean checkAvailable(int mode, int style) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(mode), Integer.valueOf(style))).booleanValue();
        }
        String str = this.style;
        if (str != null) {
            if (str.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                if (Intrinsics.areEqual(str, "list")) {
                    if (style != 1) {
                        return false;
                    }
                    return true;
                }
                if (Intrinsics.areEqual(str, "feeds")) {
                    if (style != 2) {
                        return false;
                    }
                    return true;
                }
                QLog.e(TAG, 1, "checkPluginAvailable error! unknown config: " + str);
                return false;
            }
        }
        return true;
    }

    @NotNull
    public final String printLog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        long j3 = this.uiResId;
        String str = this.strResName;
        short s16 = this.sResSubType;
        String str2 = this.strGotoUrl;
        String str3 = this.strResURL;
        String str4 = this.strGridIconUrl;
        String str5 = this.strSimpleResUrl;
        String str6 = this.resConf;
        int i3 = this.groupId;
        int i16 = this.priority;
        String str7 = this.allowChange;
        String str8 = this.style;
        short s17 = this.show;
        return "PluginInfo[" + j3 + "]:" + str + "|" + ((int) s16) + "|" + str2 + "|" + str3 + "|" + str4 + "|" + str5 + "|" + str6 + "|" + i3 + "|" + i16 + "|" + str7 + "|" + str8 + "|" + ((int) s17) + "|" + this.showVer;
    }

    public final boolean showInSimpleMode() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (this.style.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        return Intrinsics.areEqual(this.style, "feeds");
    }
}

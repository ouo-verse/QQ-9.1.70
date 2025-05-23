package com.tencent.cache.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneHelper;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/cache/api/Business;", "", "(Ljava/lang/String;I)V", "Conversation", QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO, "Guild", "QCircle", "Contact", QZoneHelper.QZONE_PRELOAD_FROM_LEBA_CLICK, "QZone", "Setting", "MiniApp", "Album", "Default", "Library_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public final class Business {
    private static final /* synthetic */ Business[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final Business AIO;
    public static final Business Album;
    public static final Business Contact;
    public static final Business Conversation;
    public static final Business Default;
    public static final Business Guild;
    public static final Business Leba;
    public static final Business MiniApp;
    public static final Business QCircle;
    public static final Business QZone;
    public static final Business Setting;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7816);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        Business business = new Business("Conversation", 0);
        Conversation = business;
        Business business2 = new Business(QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO, 1);
        AIO = business2;
        Business business3 = new Business("Guild", 2);
        Guild = business3;
        Business business4 = new Business("QCircle", 3);
        QCircle = business4;
        Business business5 = new Business("Contact", 4);
        Contact = business5;
        Business business6 = new Business(QZoneHelper.QZONE_PRELOAD_FROM_LEBA_CLICK, 5);
        Leba = business6;
        Business business7 = new Business("QZone", 6);
        QZone = business7;
        Business business8 = new Business("Setting", 7);
        Setting = business8;
        Business business9 = new Business("MiniApp", 8);
        MiniApp = business9;
        Business business10 = new Business("Album", 9);
        Album = business10;
        Business business11 = new Business("Default", 10);
        Default = business11;
        $VALUES = new Business[]{business, business2, business3, business4, business5, business6, business7, business8, business9, business10, business11};
    }

    Business(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
        }
    }

    public static Business valueOf(String str) {
        return (Business) Enum.valueOf(Business.class, str);
    }

    public static Business[] values() {
        return (Business[]) $VALUES.clone();
    }
}

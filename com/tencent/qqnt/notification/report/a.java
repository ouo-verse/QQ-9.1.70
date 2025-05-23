package com.tencent.qqnt.notification.report;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqnt.notification.api.INotificationApi;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ,\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/notification/report/a;", "", "", "chatType", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "a", "", "b", "c", "<init>", "()V", "notification_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f359850a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45498);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f359850a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0037 A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final HashMap<String, String> a(int chatType) {
        String str;
        HashMap<String, String> hashMap = new HashMap<>();
        String str2 = "1";
        if (((INotificationApi) QRoute.api(INotificationApi.class)).isCurrentInAIO()) {
            str = "1";
        } else {
            str = "2";
        }
        if (chatType == 1) {
            str2 = "2";
        } else if (chatType != 2) {
            if (chatType != 111 && chatType != 201) {
                switch (chatType) {
                    default:
                        switch (chatType) {
                            default:
                                switch (chatType) {
                                    case 117:
                                    case 118:
                                    case 119:
                                        break;
                                    default:
                                        str2 = "4";
                                        break;
                                }
                            case 113:
                            case 114:
                            case 115:
                                str2 = "3";
                                break;
                        }
                    case 100:
                    case 101:
                    case 102:
                    case 103:
                    case 104:
                    case 105:
                    case 106:
                        break;
                }
            }
            str2 = "3";
        }
        hashMap.put("now_page", str);
        hashMap.put("session_type", str2);
        return hashMap;
    }

    public final void b(int chatType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, chatType);
        } else {
            VideoReport.reportEvent("ev_bas_push_popup_click", a(chatType));
        }
    }

    public final void c(int chatType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, chatType);
        } else {
            VideoReport.reportEvent("ev_bas_push_popup_imp", a(chatType));
        }
    }
}

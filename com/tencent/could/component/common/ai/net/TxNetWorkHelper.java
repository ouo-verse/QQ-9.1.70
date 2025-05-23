package com.tencent.could.component.common.ai.net;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.could.component.common.ai.eventreport.api.EventReportConfig;
import com.tencent.could.component.common.ai.utils.ThreadPoolUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes5.dex */
public class TxNetWorkHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public volatile Map<String, DnsCacheInfo> f100008a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Set<String> f100009b;

    /* renamed from: c, reason: collision with root package name */
    public NetWorkLoggerCallBack f100010c;

    /* renamed from: d, reason: collision with root package name */
    public LOG_LEVEL f100011d;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class LOG_LEVEL {
        static IPatchRedirector $redirector_;
        public static final LOG_LEVEL LEVEL_DEBUG;
        public static final LOG_LEVEL LEVEL_ERROR;
        public static final LOG_LEVEL LEVEL_INFO;
        public static final LOG_LEVEL LEVEL_NONE;
        public static final LOG_LEVEL LEVEL_VERBOSE;
        public static final LOG_LEVEL LEVEL_WARN;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LOG_LEVEL[] f100016a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13877);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            LOG_LEVEL log_level = new LOG_LEVEL("LEVEL_VERBOSE", 0);
            LEVEL_VERBOSE = log_level;
            LOG_LEVEL log_level2 = new LOG_LEVEL("LEVEL_DEBUG", 1);
            LEVEL_DEBUG = log_level2;
            LOG_LEVEL log_level3 = new LOG_LEVEL("LEVEL_INFO", 2);
            LEVEL_INFO = log_level3;
            LOG_LEVEL log_level4 = new LOG_LEVEL("LEVEL_WARN", 3);
            LEVEL_WARN = log_level4;
            LOG_LEVEL log_level5 = new LOG_LEVEL("LEVEL_ERROR", 4);
            LEVEL_ERROR = log_level5;
            LOG_LEVEL log_level6 = new LOG_LEVEL("LEVEL_NONE", 5);
            LEVEL_NONE = log_level6;
            f100016a = new LOG_LEVEL[]{log_level, log_level2, log_level3, log_level4, log_level5, log_level6};
        }

        public LOG_LEVEL(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static LOG_LEVEL valueOf(String str) {
            return (LOG_LEVEL) Enum.valueOf(LOG_LEVEL.class, str);
        }

        public static LOG_LEVEL[] values() {
            return (LOG_LEVEL[]) f100016a.clone();
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class TxNetWorkHelperHolder {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final TxNetWorkHelper f100017a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14462);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f100017a = new TxNetWorkHelper();
            }
        }

        public TxNetWorkHelperHolder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public TxNetWorkHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f100011d = LOG_LEVEL.LEVEL_VERBOSE;
            this.f100009b = new HashSet();
        }
    }

    public static void a(TxNetWorkHelper txNetWorkHelper, Context context, String str, String str2, long j3) {
        if (txNetWorkHelper.f100008a == null) {
            txNetWorkHelper.f100008a = new HashMap();
        }
        txNetWorkHelper.f100008a.put(str, new DnsCacheInfo(str, str2, j3));
        if (context != null) {
            context.getSharedPreferences("txy_comoon_share_data", 0).edit().putString(str, str2).apply();
        }
        String str3 = str + "_time";
        if (context == null) {
            return;
        }
        context.getSharedPreferences("txy_comoon_share_data", 0).edit().putLong(str3, j3).apply();
    }

    public static TxNetWorkHelper getInstance() {
        return TxNetWorkHelperHolder.f100017a;
    }

    public void checkHostName(Context context, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, context, str, Boolean.valueOf(z16));
        } else {
            ThreadPoolUtil.getInstance().addWork(new Runnable(context, str, z16) { // from class: com.tencent.could.component.common.ai.net.TxNetWorkHelper.1
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Context f100012a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ String f100013b;

                /* renamed from: c, reason: collision with root package name */
                public final /* synthetic */ boolean f100014c;

                {
                    this.f100012a = context;
                    this.f100013b = str;
                    this.f100014c = z16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, TxNetWorkHelper.this, context, str, Boolean.valueOf(z16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        if (!TxNetWorkHelper.a(TxNetWorkHelper.this, this.f100012a, this.f100013b) && !this.f100014c) {
                            return;
                        }
                        if (!TxNetWorkHelper.this.f100009b.contains(this.f100013b)) {
                            TxNetWorkHelper.this.f100009b.add(this.f100013b);
                        }
                        DnsResolver dnsResolver = new DnsResolver(this.f100013b);
                        BaseThread baseThread = new BaseThread(dnsResolver);
                        baseThread.start();
                        baseThread.join(5000L);
                        if (TxNetWorkHelper.this.f100009b.contains(this.f100013b)) {
                            TxNetWorkHelper.this.f100009b.remove(this.f100013b);
                        }
                        InetAddress hasAddress = dnsResolver.getHasAddress();
                        if (hasAddress == null) {
                            TxNetWorkHelper.a(TxNetWorkHelper.this, this.f100012a, this.f100013b, "", 0L);
                        } else {
                            TxNetWorkHelper.a(TxNetWorkHelper.this, this.f100012a, this.f100013b, hasAddress.getHostAddress(), System.currentTimeMillis());
                        }
                    } catch (Exception e16) {
                        TxNetWorkHelper.this.logError("TxNetWorkHelper", "checkHostName, error: " + e16.getLocalizedMessage());
                    }
                }
            });
        }
    }

    public String getHostNameCurrentIp(Context context, String str) {
        String string;
        DnsCacheInfo dnsCacheInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) context, (Object) str);
        }
        if (this.f100008a != null && (dnsCacheInfo = this.f100008a.get(str)) != null && System.currentTimeMillis() - dnsCacheInfo.getRefreshTime() < 86400000) {
            getInstance().logError("TxNetWorkHelper", "get hostName use cache: " + dnsCacheInfo.getIp());
            return dnsCacheInfo.getIp();
        }
        try {
            String str2 = str + "_time";
            long j3 = 0;
            if (context != null) {
                j3 = context.getSharedPreferences("txy_comoon_share_data", 0).getLong(str2, 0L);
            }
            if (System.currentTimeMillis() - j3 > 86400000) {
                if (!this.f100009b.contains(str)) {
                    getInstance().logError("TxNetWorkHelper", "need update dns!");
                    checkHostName(context, str, false);
                } else {
                    getInstance().logError("TxNetWorkHelper", "do not need update dns!");
                }
                return "";
            }
            if (context == null) {
                string = EventReportConfig.STRING_INIT;
            } else {
                string = context.getSharedPreferences("txy_comoon_share_data", 0).getString(str, EventReportConfig.STRING_INIT);
            }
            if (!TextUtils.isEmpty(string)) {
                if (this.f100008a == null) {
                    this.f100008a = new HashMap();
                }
                this.f100008a.put(str, new DnsCacheInfo(str, string, j3));
            }
            return string;
        } catch (Exception e16) {
            Log.e("TxNetWorkHelper", "getHostNameCurrentIp error: " + e16.getLocalizedMessage());
            return "";
        }
    }

    public void logDebug(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
        } else if (this.f100010c != null && LOG_LEVEL.LEVEL_DEBUG.compareTo(this.f100011d) >= 0) {
            this.f100010c.logger(str, str2);
        } else {
            Log.d(str, str2);
        }
    }

    public void logError(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
        } else if (this.f100010c != null && LOG_LEVEL.LEVEL_ERROR.compareTo(this.f100011d) >= 0) {
            this.f100010c.logger(str, str2);
        } else {
            Log.e(str, str2);
        }
    }

    public void setLoggerCallBack(NetWorkLoggerCallBack netWorkLoggerCallBack) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            setLoggerCallBack(netWorkLoggerCallBack, this.f100011d);
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) netWorkLoggerCallBack);
        }
    }

    public void setLoggerCallBack(NetWorkLoggerCallBack netWorkLoggerCallBack, LOG_LEVEL log_level) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) netWorkLoggerCallBack, (Object) log_level);
        } else {
            this.f100010c = netWorkLoggerCallBack;
            this.f100011d = log_level;
        }
    }

    public static boolean a(TxNetWorkHelper txNetWorkHelper, Context context, String str) {
        String string;
        DnsCacheInfo dnsCacheInfo;
        if (txNetWorkHelper.f100008a == null || (dnsCacheInfo = txNetWorkHelper.f100008a.get(str)) == null) {
            try {
                long j3 = context != null ? context.getSharedPreferences("txy_comoon_share_data", 0).getLong(str + "_time", 0L) : 0L;
                if (System.currentTimeMillis() - j3 > 86400000) {
                    getInstance().logError("TxNetWorkHelper", "isHostNameIpTimeOut is timeout");
                } else {
                    if (context == null) {
                        string = EventReportConfig.STRING_INIT;
                    } else {
                        string = context.getSharedPreferences("txy_comoon_share_data", 0).getString(str, EventReportConfig.STRING_INIT);
                    }
                    if (TextUtils.isEmpty(string)) {
                        return false;
                    }
                    if (txNetWorkHelper.f100008a == null) {
                        txNetWorkHelper.f100008a = new HashMap();
                    }
                    txNetWorkHelper.f100008a.put(str, new DnsCacheInfo(str, string, j3));
                    return false;
                }
            } catch (Exception e16) {
                getInstance().logError("TxNetWorkHelper", "isHostNameIpTimeOut e: " + e16.getLocalizedMessage());
            }
        } else {
            if (System.currentTimeMillis() - dnsCacheInfo.getRefreshTime() <= 86400000) {
                return false;
            }
            getInstance().logError("TxNetWorkHelper", "isHostNameIpTimeOut is timeout in cache");
        }
        return true;
    }
}

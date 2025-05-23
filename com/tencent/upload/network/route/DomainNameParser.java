package com.tencent.upload.network.route;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.network.NetworkState;
import com.tencent.upload.uinterface.IUploadService;
import com.tencent.upload.utils.Const;
import com.tencent.upload.utils.StringUtils;
import com.tencent.upload.utils.UploadLog;
import java.net.InetAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes27.dex */
public class DomainNameParser {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "DomainNameParser";
    private static Map<String, String> sLastParseResults;

    /* loaded from: classes27.dex */
    public static final class ParseResult {
        static IPatchRedirector $redirector_;
        public volatile String parsedIp;

        public ParseResult() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11489);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sLastParseResults = new ConcurrentHashMap();
        }
    }

    DomainNameParser() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void parse(String str, ParseResult parseResult) {
        UploadLog.i(TAG, "parse: start, domainName:" + str);
        if (str == null) {
            UploadLog.i(TAG, "parse: return, domainName == null");
            return;
        }
        byte[] bArr = new byte[0];
        synchronized (bArr) {
            new BaseThread(new Runnable(str, bArr, parseResult) { // from class: com.tencent.upload.network.route.DomainNameParser.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ String val$domainName;
                final /* synthetic */ byte[] val$lock;
                final /* synthetic */ ParseResult val$parseResult;

                {
                    this.val$domainName = str;
                    this.val$lock = bArr;
                    this.val$parseResult = parseResult;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, str, bArr, parseResult);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    String name = Thread.currentThread().getName();
                    String str2 = null;
                    try {
                        if (UploadGlobalConfig.getConfig().isSwitchOn(Const.SwitchConfigKey.QQCIRCLE_UPLOAD_GET_DOMAIN_IP_FIRST_FOR_IPV4)) {
                            InetAddress[] allByName = InetAddress.getAllByName(this.val$domainName);
                            if (!this.val$domainName.startsWith("v6") && NetworkState.getNetworkStackTypeInner() == 3) {
                                for (InetAddress inetAddress : allByName) {
                                    UploadLog.v(DomainNameParser.TAG, "inetAddress:" + inetAddress.getHostAddress());
                                    if (StringUtils.isIpv4String(inetAddress.getHostAddress())) {
                                        str2 = inetAddress.getHostAddress();
                                    }
                                }
                            } else {
                                str2 = InetAddress.getByName(this.val$domainName).getHostAddress();
                            }
                        } else {
                            str2 = InetAddress.getByName(this.val$domainName).getHostAddress();
                        }
                        UploadLog.i(DomainNameParser.TAG, "parse: getByName, get parsed ip:" + str2 + " domainName:" + this.val$domainName + " " + name);
                    } catch (Throwable th5) {
                        UploadLog.w(DomainNameParser.TAG, "parse: Error:" + th5);
                    }
                    synchronized (this.val$lock) {
                        if (!TextUtils.isEmpty(str2)) {
                            DomainNameParser.sLastParseResults.put(this.val$domainName, str2);
                        }
                        this.val$parseResult.parsedIp = str2;
                        UploadLog.i(DomainNameParser.TAG, "notify parsed ip:" + this.val$parseResult.parsedIp + " domainName:" + this.val$domainName + " " + name + " lock obj :" + this.val$lock.hashCode());
                        this.val$lock.notify();
                    }
                }
            }, IUploadService.DOMAIN_PARSER_THREAD_NAME + System.currentTimeMillis()).start();
            try {
                bArr.wait(UploadConfiguration.getDomainNameParseTimeout());
            } catch (InterruptedException e16) {
                UploadLog.w(TAG, "parse: wait:" + e16);
            }
            if (TextUtils.isEmpty(parseResult.parsedIp) && !TextUtils.isEmpty(sLastParseResults.get(str))) {
                UploadLog.w(TAG, "used last domain ip");
                parseResult.parsedIp = sLastParseResults.get(str);
            }
            UploadLog.i(TAG, "parse return, get domainName:" + str + " to ip:" + parseResult.parsedIp + " lock obj :" + bArr.hashCode());
        }
    }
}

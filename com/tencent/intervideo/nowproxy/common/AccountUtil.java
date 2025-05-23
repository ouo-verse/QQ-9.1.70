package com.tencent.intervideo.nowproxy.common;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.intervideo.nowproxy.common.login.LoginType;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes7.dex */
public class AccountUtil {
    static IPatchRedirector $redirector_ = null;
    public static final String DEVICE_ID_FILE = "DEVICE_ID";
    public static String sDeviceId;

    /* compiled from: P */
    /* renamed from: com.tencent.intervideo.nowproxy.common.AccountUtil$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$intervideo$nowproxy$common$login$LoginType;
        static IPatchRedirector $redirector_;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10383);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[LoginType.values().length];
            $SwitchMap$com$tencent$intervideo$nowproxy$common$login$LoginType = iArr;
            try {
                iArr[LoginType.WTLOGIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$intervideo$nowproxy$common$login$LoginType[LoginType.CUSTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$intervideo$nowproxy$common$login$LoginType[LoginType.TOURIST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$tencent$intervideo$nowproxy$common$login$LoginType[LoginType.QQConnect.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$tencent$intervideo$nowproxy$common$login$LoginType[LoginType.WXBind.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10402);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sDeviceId = "";
        }
    }

    public AccountUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static int getAccountType(LoginType loginType) {
        int i3 = AnonymousClass1.$SwitchMap$com$tencent$intervideo$nowproxy$common$login$LoginType[loginType.ordinal()];
        if (i3 == 1) {
            return 2;
        }
        if (i3 == 2) {
            return 4;
        }
        if (i3 == 3) {
            return 5;
        }
        if (i3 != 4) {
            if (i3 != 5) {
                return 2;
            }
            return 9;
        }
        return 8;
    }

    public static String getDeviceId(Context context) {
        if (!TextUtils.isEmpty(sDeviceId)) {
            return sDeviceId;
        }
        File file = new File(context.getFilesDir(), "DEVICE_ID");
        try {
            if (file.exists()) {
                sDeviceId = readDeviceIdFromFile(file);
            } else {
                sDeviceId = UUID.randomUUID().toString();
                file.createNewFile();
                writeDeviceIdToFile(file, sDeviceId);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return sDeviceId;
    }

    public static int getOriginalAccountType(LoginType loginType) {
        if (loginType == null) {
            return 0;
        }
        int i3 = AnonymousClass1.$SwitchMap$com$tencent$intervideo$nowproxy$common$login$LoginType[loginType.ordinal()];
        if (i3 != 4) {
            if (i3 != 5) {
                return 0;
            }
            return 9;
        }
        return 8;
    }

    private static String readDeviceIdFromFile(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        byte[] bArr = new byte[(int) randomAccessFile.length()];
        randomAccessFile.readFully(bArr);
        randomAccessFile.close();
        return new String(bArr);
    }

    private static void writeDeviceIdToFile(File file, String str) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(str.getBytes());
        fileOutputStream.close();
    }
}

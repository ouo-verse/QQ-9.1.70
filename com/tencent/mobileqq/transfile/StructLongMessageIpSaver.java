package com.tencent.mobileqq.transfile;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes19.dex */
public class StructLongMessageIpSaver implements INetInfoHandler {
    static IPatchRedirector $redirector_ = null;
    private static final String LONG_MSG_IPLIST;
    private static final String LONG_MSG_IPLIST_TMP;
    public static final String TAG = "StructLongMessageIpSaver";
    private int connectionFlag;
    private String ipCellular;
    private String ipWifi;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(76025);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        String str = AppConstants.SDCARD_DATABASE;
        sb5.append(str);
        sb5.append("longMsgList.ini");
        LONG_MSG_IPLIST = sb5.toString();
        LONG_MSG_IPLIST_TMP = str + "longMsgList.tmp";
    }

    public StructLongMessageIpSaver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.connectionFlag = 0;
        this.ipWifi = null;
        this.ipCellular = null;
        AppNetConnInfo.registerConnectionChangeReceiver(BaseApplicationImpl.getApplication(), this);
        initConnectionFlag();
        readFromFile();
    }

    private boolean checkLegality(String str) {
        return Pattern.compile("^http://((\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\.){3}(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])(:(\\d{1,4}|[1-5]\\d\\d\\d\\d|6[0-4]\\d\\d\\d|65[0-4]\\d\\d|655[0-2]\\d|6553[0-5]))?/$").matcher(str).matches();
    }

    private synchronized void initConnectionFlag() {
        int networkType = NetworkUtil.getNetworkType(BaseApplication.getContext());
        if (networkType != 0) {
            if (networkType == 1) {
                this.connectionFlag = 2;
            }
        } else {
            this.connectionFlag = 1;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x0091 -> B:22:0x0094). Please report as a decompilation issue!!! */
    private void readFromFile() {
        File createFile;
        BufferedReader bufferedReader = null;
        try {
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        try {
            try {
                createFile = FileUtils.createFile(LONG_MSG_IPLIST);
            } catch (FileNotFoundException e17) {
                e = e17;
            } catch (Exception e18) {
                e = e18;
            }
            if (createFile.length() == 0) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "read file failed, f.length() == 0");
                    return;
                }
                return;
            }
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(createFile)));
            try {
                this.ipWifi = bufferedReader2.readLine();
                this.ipCellular = bufferedReader2.readLine();
                String str = this.ipWifi;
                if (str == null || !checkLegality(str)) {
                    this.ipWifi = null;
                }
                String str2 = this.ipCellular;
                if (str2 == null || !checkLegality(str2)) {
                    this.ipCellular = null;
                }
                bufferedReader2.close();
            } catch (FileNotFoundException e19) {
                e = e19;
                bufferedReader = bufferedReader2;
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "readFromFile failed, File Not Found");
                }
                e.printStackTrace();
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (Exception e26) {
                e = e26;
                bufferedReader = bufferedReader2;
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "readFromFile failed, IOException");
                }
                e.printStackTrace();
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (Throwable th5) {
                th = th5;
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e27) {
                        e27.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private synchronized void writeToFile() {
        File createFile;
        BufferedWriter bufferedWriter = null;
        try {
            try {
                createFile = FileUtils.createFile(LONG_MSG_IPLIST);
                if (createFile.exists()) {
                    createFile.delete();
                }
            } catch (FileNotFoundException e16) {
                e = e16;
            } catch (Exception e17) {
                e = e17;
            }
            if (this.ipWifi == null && this.ipCellular == null) {
                return;
            }
            File createFile2 = FileUtils.createFile(LONG_MSG_IPLIST_TMP);
            if (createFile2.exists()) {
                createFile2.delete();
            }
            createFile2.createNewFile();
            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(createFile2)));
            try {
                String str = this.ipWifi;
                if (str == null) {
                    str = "";
                }
                bufferedWriter2.write(str);
                bufferedWriter2.write("\n");
                String str2 = this.ipCellular;
                if (str2 == null) {
                    str2 = "";
                }
                bufferedWriter2.write(str2);
                bufferedWriter2.flush();
            } catch (FileNotFoundException e18) {
                e = e18;
                bufferedWriter = bufferedWriter2;
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "readFromFile failed, File Not Found");
                }
                e.printStackTrace();
                if (bufferedWriter != null) {
                    try {
                        bufferedWriter.close();
                    } catch (IOException e19) {
                        e = e19;
                        e.printStackTrace();
                    } catch (Exception e26) {
                        e = e26;
                        e.printStackTrace();
                    }
                }
            } catch (Exception e27) {
                e = e27;
                bufferedWriter = bufferedWriter2;
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "readFromFile failed, IOException");
                }
                e.printStackTrace();
                if (bufferedWriter != null) {
                    try {
                        bufferedWriter.close();
                    } catch (IOException e28) {
                        e = e28;
                        e.printStackTrace();
                    } catch (Exception e29) {
                        e = e29;
                        e.printStackTrace();
                    }
                }
            } catch (Throwable th5) {
                th = th5;
                bufferedWriter = bufferedWriter2;
                if (bufferedWriter != null) {
                    try {
                        bufferedWriter.close();
                    } catch (IOException e36) {
                        e36.printStackTrace();
                    } catch (Exception e37) {
                        e37.printStackTrace();
                    }
                }
                throw th;
            }
            try {
                bufferedWriter2.close();
                createFile2.renameTo(createFile);
            } catch (IOException e38) {
                e = e38;
                e.printStackTrace();
            } catch (Exception e39) {
                e = e39;
                e.printStackTrace();
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public void deleteIp(ServerAddr serverAddr) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) serverAddr);
            return;
        }
        if (serverAddr == null) {
            return;
        }
        StringBuilder sb5 = new StringBuilder(200);
        sb5.append("http://");
        sb5.append(serverAddr.mIp);
        if (serverAddr.port != 80) {
            sb5.append(":");
            sb5.append(serverAddr.port);
        }
        sb5.append("/");
        String sb6 = sb5.toString();
        String str = this.ipWifi;
        boolean z17 = true;
        if (str != null && str.equals(sb6)) {
            this.ipWifi = null;
            z16 = true;
        } else {
            z16 = false;
        }
        String str2 = this.ipCellular;
        if (str2 != null && str2.equals(sb6)) {
            this.ipCellular = null;
        } else {
            z17 = z16;
        }
        if (z17) {
            writeToFile();
        }
    }

    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            AppNetConnInfo.unregisterNetInfoHandler(this);
        }
    }

    public synchronized int getConnectionFlag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.connectionFlag;
    }

    public String getIp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        int i3 = this.connectionFlag;
        if (i3 != 1) {
            if (i3 != 2) {
                return null;
            }
            return this.ipWifi;
        }
        return this.ipCellular;
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public synchronized void onNetMobile2None() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            this.connectionFlag = 0;
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public synchronized void onNetMobile2Wifi(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        } else {
            this.connectionFlag = 2;
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public synchronized void onNetNone2Mobile(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            this.connectionFlag = 1;
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public synchronized void onNetNone2Wifi(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        } else {
            this.connectionFlag = 2;
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public synchronized void onNetWifi2Mobile(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else {
            this.connectionFlag = 1;
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public synchronized void onNetWifi2None() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            this.connectionFlag = 0;
        }
    }

    public void saveIp(ServerAddr serverAddr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) serverAddr);
            return;
        }
        if (serverAddr != null && this.connectionFlag != 0) {
            StringBuilder sb5 = new StringBuilder(200);
            sb5.append("http://");
            sb5.append(serverAddr.mIp);
            if (serverAddr.port != 80) {
                sb5.append(":");
                sb5.append(serverAddr.port);
            }
            sb5.append("/");
            String sb6 = sb5.toString();
            int i3 = this.connectionFlag;
            if (i3 == 1) {
                this.ipCellular = sb6;
            } else if (i3 == 2) {
                this.ipWifi = sb6;
            }
            writeToFile();
        }
    }
}

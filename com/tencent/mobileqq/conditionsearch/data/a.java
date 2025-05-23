package com.tencent.mobileqq.conditionsearch.data;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static AddressData a(AppInterface appInterface, File file) {
        if (QLog.isColorLevel()) {
            QLog.d("ConditionSearch.AddressHelper", 2, "doParseFile | enter");
        }
        AddressData addressData = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            AddressData addressData2 = null;
            while (true) {
                try {
                    try {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            if (addressData2 == null) {
                                addressData2 = new AddressData();
                            }
                            try {
                            } catch (Exception e16) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("ConditionSearch.AddressHelper", 2, "doParseFile | insertData exception = ", e16);
                                }
                            }
                            if (!addressData2.d(appInterface, readLine)) {
                                if (!QLog.isColorLevel()) {
                                    break;
                                }
                                QLog.d("ConditionSearch.AddressHelper", 2, "doParseFile | parse breaked ");
                                break;
                            }
                            continue;
                        } catch (Throwable th5) {
                            try {
                                bufferedReader.close();
                                fileInputStream.close();
                            } catch (Exception e17) {
                                e17.printStackTrace();
                            }
                            throw th5;
                        }
                    } catch (Exception e18) {
                        e18.printStackTrace();
                    }
                } catch (Exception e19) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ConditionSearch.AddressHelper", 2, "doParseFile | exception two = ", e19);
                    }
                    bufferedReader.close();
                    fileInputStream.close();
                }
            }
            addressData = addressData2;
            bufferedReader.close();
            fileInputStream.close();
            if (QLog.isColorLevel()) {
                QLog.d("ConditionSearch.AddressHelper", 2, "doParseFile | leave");
            }
            return addressData;
        } catch (IOException e26) {
            if (QLog.isColorLevel()) {
                QLog.d("ConditionSearch.AddressHelper", 2, "doParseFile | excepiton one = ", e26);
            }
            try {
                throw null;
            } catch (Exception e27) {
                e27.printStackTrace();
                return null;
            }
        }
    }
}

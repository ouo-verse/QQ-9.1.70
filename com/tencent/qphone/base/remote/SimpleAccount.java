package com.tencent.qphone.base.remote;

import com.huawei.hms.framework.common.ContainerUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.msf.core.auth.k;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class SimpleAccount {
    public static final String _ISLOGINED = "_isLogined";
    public static final String _LOGINPROCESS = "_loginedProcess";
    public static final String _LOGINTIME = "_loginTime";
    public static final String _UIN = "_uin";
    private static final String tag = "SimpleAccount";
    private HashMap<String, String> attributes = new HashMap<>();

    public static boolean isSameAccount(SimpleAccount simpleAccount, SimpleAccount simpleAccount2) {
        if (simpleAccount.getUin().equals(simpleAccount2.getUin()) && simpleAccount.isLogined() == simpleAccount2.isLogined()) {
            return true;
        }
        return false;
    }

    public static SimpleAccount parseSimpleAccount(String str) {
        if (str != null && str.length() > 0) {
            SimpleAccount simpleAccount = new SimpleAccount();
            for (String str2 : str.split(",")) {
                if (str2.length() > 0) {
                    String[] split = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                    try {
                        if (split.length == 2) {
                            simpleAccount.attributes.put(split[0], new String(HexUtil.hexStr2Bytes(split[1]), "UTF-8"));
                        }
                    } catch (UnsupportedEncodingException e16) {
                        QLog.d(tag, 1, e16.toString(), e16);
                    }
                }
            }
            return simpleAccount;
        }
        return null;
    }

    public boolean containsKey(String str) {
        return this.attributes.containsKey(str);
    }

    public boolean equals(Object obj) {
        if (obj instanceof SimpleAccount) {
            return isSameAccount(this, (SimpleAccount) obj);
        }
        return false;
    }

    public String getAttribute(String str, String str2) {
        if (this.attributes.containsKey(str)) {
            return this.attributes.get(str);
        }
        return str2;
    }

    public HashMap<String, String> getAttributes() {
        return this.attributes;
    }

    public String getLoginProcess() {
        return getAttribute(_LOGINPROCESS, "");
    }

    public String getUin() {
        return getAttribute(_UIN, "");
    }

    public boolean isLogined() {
        return Boolean.parseBoolean(getAttribute(_ISLOGINED, String.valueOf(false)));
    }

    public String removeAttribute(String str) {
        return this.attributes.remove(str);
    }

    public void setAttribute(String str, String str2) {
        if (str.indexOf(" ") <= 0) {
            this.attributes.put(str, str2);
            return;
        }
        throw new RuntimeException("key found space ");
    }

    public void setLoginProcess(String str) {
        setAttribute(_LOGINPROCESS, str);
    }

    public void setUin(String str) {
        k.a(str, k.f247491e);
        setAttribute(_UIN, str);
    }

    public String toStoreString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : this.attributes.keySet()) {
            try {
                String str2 = this.attributes.get(str);
                if (str2 != null) {
                    stringBuffer.append(str + ContainerUtils.KEY_VALUE_DELIMITER + HexUtil.bytes2HexStr(str2.getBytes("UTF-8")) + ",");
                }
            } catch (UnsupportedEncodingException e16) {
                QLog.d(tag, 1, e16.toString(), e16);
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        if (stringBuffer2.endsWith(",")) {
            return stringBuffer2.substring(0, stringBuffer2.length() - 1);
        }
        return stringBuffer2;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : this.attributes.keySet()) {
            stringBuffer.append(str + ":" + this.attributes.get(str) + ",");
        }
        return stringBuffer.toString();
    }
}

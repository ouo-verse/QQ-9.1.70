package com.tencent.qimei.p;

import android.os.Build;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.tencent.lbssearch.object.param.Geo2AddressParam;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<String[]> f343356a;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f343356a = new ArrayList<>();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0056, code lost:
    
        if (r4.equals(com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant.ElementParamValue.XSJ_EDIT_STICKER_TYPE_CHAR) == false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        char c16 = 3;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        str.hashCode();
        switch (str.hashCode()) {
            case -1325958191:
                if (str.equals("double")) {
                    c16 = 0;
                    break;
                }
                c16 = '\uffff';
                break;
            case 104431:
                if (str.equals(PoiListCacheRecord.WEIGHT_TYPE)) {
                    c16 = 1;
                    break;
                }
                c16 = '\uffff';
                break;
            case 3039496:
                if (str.equals("byte")) {
                    c16 = 2;
                    break;
                }
                c16 = '\uffff';
                break;
            case 3052374:
                break;
            case 3327612:
                if (str.equals(PoiListCacheRecord.TIMESTAMP_TYPE)) {
                    c16 = 4;
                    break;
                }
                c16 = '\uffff';
                break;
            case 64711720:
                if (str.equals(HippyControllerProps.BOOLEAN)) {
                    c16 = 5;
                    break;
                }
                c16 = '\uffff';
                break;
            case 97526364:
                if (str.equals("float")) {
                    c16 = 6;
                    break;
                }
                c16 = '\uffff';
                break;
            case 109413500:
                if (str.equals(Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT)) {
                    c16 = 7;
                    break;
                }
                c16 = '\uffff';
                break;
            default:
                c16 = '\uffff';
                break;
        }
        switch (c16) {
            case 0:
                return "D";
            case 1:
                return "I";
            case 2:
                return "B";
            case 3:
                return BdhLogUtil.LogTag.Tag_Conn;
            case 4:
                return "J";
            case 5:
                return "Z";
            case 6:
                return UserInfo.SEX_FEMALE;
            case 7:
                return ExifInterface.LATITUDE_SOUTH;
            default:
                return "L" + str.replace('.', '/') + ";";
        }
    }

    public void a(String str, Class<?> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) cls);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            Method[] declaredMethods = cls.getDeclaredMethods();
            if (declaredMethods.length == 0) {
                return;
            }
            for (Method method : declaredMethods) {
                if (((b) method.getAnnotation(b.class)) != null) {
                    a(str, cls, method);
                    return;
                }
            }
        } catch (Exception unused) {
        }
    }

    public final void a(String str, Class<?> cls, Method method) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, cls, method);
            return;
        }
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            return;
        }
        String[] strArr = new String[4];
        strArr[0] = canonicalName.replace('.', '/');
        strArr[1] = method.getName();
        StringBuilder sb5 = new StringBuilder();
        try {
            Class<?>[] parameterTypes = method.getParameterTypes();
            int parameterCount = Build.VERSION.SDK_INT >= 26 ? method.getParameterCount() : parameterTypes.length;
            sb5.append("(");
            for (int i3 = 0; i3 < parameterCount; i3++) {
                sb5.append(a(parameterTypes[i3].getName()));
            }
            sb5.append(")");
            sb5.append(a(method.getReturnType().getName()));
        } catch (Exception unused) {
        }
        strArr[2] = sb5.toString();
        strArr[3] = str;
        this.f343356a.add(strArr);
    }
}

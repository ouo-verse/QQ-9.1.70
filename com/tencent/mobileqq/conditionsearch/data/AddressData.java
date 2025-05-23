package com.tencent.mobileqq.conditionsearch.data;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.selectorview.model.BaseAddress;
import com.tenpay.proxy.dlg.location.QbAddrData;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public class AddressData {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    public static final String f202019b;

    /* renamed from: a, reason: collision with root package name */
    public HashMap<String, BaseAddress> f202020a;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.conditionsearch.data.AddressData$1, reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass1 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f202021d;
        final /* synthetic */ AddressData this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            for (int i3 = 0; i3 < 3; i3++) {
                QQToast.makeText(BaseApplicationImpl.sApplication, "\u6761\u4ef6\u641c\u7d20\u914d\u7f6e\u6587\u4ef6\u5b58\u5728\u4e0d\u540ccode\u5bf9\u5e94\u76f8\u540cname\u7684\u95ee\u9898\uff01\uff01\uff01 name = " + this.f202021d, 1).show();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class NO_LIMIT_ADDRESS extends BaseAddress {
        static IPatchRedirector $redirector_;

        public NO_LIMIT_ADDRESS(String str, String str2, int i3) {
            super(str, str2, i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, this, str, str2, Integer.valueOf(i3));
        }

        public NO_LIMIT_ADDRESS(int i3) {
            this(IProfileCardConst.NAME_NO_LIMIT, "0", i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71284);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f202019b = HardCodeUtil.qqStr(R.string.j4q);
        }
    }

    public AddressData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f202020a = new HashMap<>(30);
        }
    }

    private int b(int i3) {
        switch (i3) {
            case 2:
            case 3:
                return 1;
            case 4:
            case 5:
                return 2;
            case 6:
            case 7:
                return 3;
            default:
                return 0;
        }
    }

    private int c(int i3, int i16, String[] strArr) {
        while (i3 < i16) {
            int i17 = i3 + 1;
            if (!TextUtils.isEmpty(strArr[i3])) {
                i3 = i17 + 1;
                if (!TextUtils.isEmpty(strArr[i17])) {
                    return i3 - 2;
                }
            } else {
                i3 = i17;
            }
            if (i3 >= i16 - 1) {
                return -1;
            }
        }
        return -1;
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        HashMap<String, BaseAddress> hashMap = this.f202020a;
        if (hashMap != null) {
            hashMap.clear();
            this.f202020a = null;
        }
    }

    public boolean d(AppInterface appInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInterface, (Object) str)).booleanValue();
        }
        if (str.startsWith(f202019b)) {
            return false;
        }
        String[] split = StringUtil.split(str, QbAddrData.DATA_SPLITER);
        if (!str.startsWith("#") && split.length >= 2) {
            int length = split.length;
            String str2 = split[0];
            String str3 = split[1];
            BaseAddress baseAddress = this.f202020a.get(str2);
            if (baseAddress == null) {
                baseAddress = new BaseAddress(str3, str2, b(1));
                this.f202020a.put("0", new BaseAddress(IProfileCardConst.NAME_NO_LIMIT, "0", 0));
                this.f202020a.put(str2, baseAddress);
            }
            int c16 = c(2, length, split);
            if (c16 == -1) {
                return true;
            }
            int i3 = c16 + 1;
            String str4 = split[c16];
            int i16 = i3 + 1;
            String str5 = split[i3];
            BaseAddress baseAddress2 = baseAddress.dataMap.get(str4);
            if (baseAddress2 == null) {
                int b16 = b(i16 - 1);
                BaseAddress baseAddress3 = new BaseAddress(str5, str4, b16);
                baseAddress.dataMap.put("0", new BaseAddress(IProfileCardConst.NAME_NO_LIMIT, "0", b16));
                baseAddress.dataMap.put(str4, baseAddress3);
                baseAddress.hasProvince = true;
                baseAddress2 = baseAddress3;
            }
            int c17 = c(i16, length, split);
            if (c17 == -1) {
                return true;
            }
            int i17 = c17 + 1;
            String str6 = split[c17];
            int i18 = i17 + 1;
            String str7 = split[i17];
            BaseAddress baseAddress4 = baseAddress2.dataMap.get(str6);
            if (baseAddress4 == null) {
                int b17 = b(i18 - 1);
                BaseAddress baseAddress5 = new BaseAddress(str7, str6, b17);
                baseAddress2.dataMap.put("0", new BaseAddress(IProfileCardConst.NAME_NO_LIMIT, "0", b17));
                baseAddress2.dataMap.put(str6, baseAddress5);
                baseAddress.hasCity = true;
                baseAddress4 = baseAddress5;
            }
            int c18 = c(i18, length, split);
            if (c18 == -1) {
                return true;
            }
            int i19 = c18 + 1;
            String str8 = split[c18];
            int i26 = i19 + 1;
            String str9 = split[i19];
            if (baseAddress4.dataMap.get(str8) == null) {
                int b18 = b(i26 - 1);
                BaseAddress baseAddress6 = new BaseAddress(str9, str8, b18);
                baseAddress4.dataMap.put("0", new BaseAddress(IProfileCardConst.NAME_NO_LIMIT, "0", b18));
                baseAddress4.dataMap.put(str8, baseAddress6);
                baseAddress.hasDistrict = true;
            }
        }
        return true;
    }
}

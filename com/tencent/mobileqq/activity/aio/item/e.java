package com.tencent.mobileqq.activity.aio.item;

import android.text.TextUtils;
import com.tencent.ark.ark;
import com.tencent.mobileqq.activity.aio.item.d;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.x.q;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes10.dex */
public class e implements ark.RuntimeClassCallbackWrapper, d.a {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<QQAppInterface> f179458a;

    /* renamed from: b, reason: collision with root package name */
    private d f179459b;

    /* renamed from: c, reason: collision with root package name */
    private ark.VariantWrapper f179460c;

    /* renamed from: d, reason: collision with root package name */
    private String f179461d;

    public e(QQAppInterface qQAppInterface, String str) {
        this.f179461d = str;
        this.f179458a = new WeakReference<>(qQAppInterface);
    }

    private void a() {
        d dVar = this.f179459b;
        if (dVar != null) {
            dVar.f(null);
            this.f179459b.a();
            this.f179459b = null;
        }
    }

    private void k(ark.VariantWrapper variantWrapper) {
        ark.VariantWrapper variantWrapper2 = this.f179460c;
        if (variantWrapper2 != null) {
            variantWrapper2.Reset();
            this.f179460c = null;
        }
        if (variantWrapper != null) {
            this.f179460c = variantWrapper.Copy();
        }
    }

    @Override // com.tencent.ark.ark.RuntimeClassCallbackWrapper
    public boolean Destruct() {
        a();
        k(null);
        return true;
    }

    @Override // com.tencent.ark.ark.RuntimeClassCallbackWrapper
    public boolean HasMethod(String str) {
        if (!str.equals("Open") && !str.equals("Abort") && !str.equals("AttachEvent") && !str.equals("DetachEvent") && !str.equals("Send") && !str.equals("SetTimeout") && !str.equals("IsSuccess") && !str.equals("GetData")) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.ark.ark.RuntimeClassCallbackWrapper
    public boolean Invoke(String str, ark.VariantWrapper[] variantWrapperArr, ark.VariantWrapper variantWrapper) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.equals("Open")) {
            return g(variantWrapperArr, variantWrapper);
        }
        if (str.equals("Abort")) {
            return b(variantWrapperArr, variantWrapper);
        }
        if (str.equals("AttachEvent")) {
            return c(variantWrapperArr, variantWrapper);
        }
        if (str.equals("DetachEvent")) {
            return d(variantWrapperArr, variantWrapper);
        }
        if (str.equals("Send")) {
            return h(variantWrapperArr, variantWrapper);
        }
        if (str.equals("SetTimeout")) {
            return i(variantWrapperArr, variantWrapper);
        }
        if (str.equals("IsSuccess")) {
            return f(variantWrapperArr, variantWrapper);
        }
        if (!str.equals("GetData")) {
            return false;
        }
        return e(variantWrapperArr, variantWrapper);
    }

    @Override // com.tencent.ark.ark.RuntimeClassCallbackWrapper
    public boolean IsModule() {
        return false;
    }

    protected boolean b(ark.VariantWrapper[] variantWrapperArr, ark.VariantWrapper variantWrapper) {
        a();
        variantWrapper.SetBool(true);
        return true;
    }

    protected boolean c(ark.VariantWrapper[] variantWrapperArr, ark.VariantWrapper variantWrapper) {
        if (variantWrapperArr != null && variantWrapperArr.length >= 3) {
            String GetString = variantWrapperArr[1].GetString();
            ark.VariantWrapper variantWrapper2 = variantWrapperArr[2];
            if (!TextUtils.isEmpty(GetString) && variantWrapper2 != null && variantWrapper2.IsFunction() && GetString.equals("OnComplete")) {
                k(variantWrapper2);
                variantWrapper.SetBool(true);
                return true;
            }
        }
        variantWrapper.SetBool(false);
        return true;
    }

    protected boolean d(ark.VariantWrapper[] variantWrapperArr, ark.VariantWrapper variantWrapper) {
        if (variantWrapperArr != null && variantWrapperArr.length >= 2) {
            String GetString = variantWrapperArr[1].GetString();
            if (!TextUtils.isEmpty(GetString) && GetString.equals("OnComplete")) {
                k(null);
                variantWrapper.SetBool(true);
                return true;
            }
        }
        variantWrapper.SetBool(false);
        return true;
    }

    protected boolean e(ark.VariantWrapper[] variantWrapperArr, ark.VariantWrapper variantWrapper) {
        String b16;
        d dVar = this.f179459b;
        if (dVar != null && variantWrapperArr != null && variantWrapperArr.length >= 2 && dVar.c() == 0 && (b16 = this.f179459b.b()) != null) {
            String GetString = variantWrapperArr[1].GetString();
            if (!TextUtils.isEmpty(GetString)) {
                if (GetString.equals("text")) {
                    if (variantWrapper.SetString(b16)) {
                        return true;
                    }
                } else if (GetString.equals(ark.ARKMETADATA_JSON) && variantWrapper.SetTableAsJsonString(b16)) {
                    return true;
                }
            }
        }
        variantWrapper.SetNull();
        return true;
    }

    protected boolean f(ark.VariantWrapper[] variantWrapperArr, ark.VariantWrapper variantWrapper) {
        d dVar = this.f179459b;
        boolean z16 = false;
        if (dVar != null && variantWrapperArr != null && variantWrapperArr.length >= 1) {
            if (dVar.c() == 0) {
                z16 = true;
            }
            variantWrapper.SetBool(z16);
            return true;
        }
        variantWrapper.SetBool(false);
        return true;
    }

    protected boolean g(ark.VariantWrapper[] variantWrapperArr, ark.VariantWrapper variantWrapper) {
        a();
        if (variantWrapperArr != null && variantWrapperArr.length >= 2) {
            String GetString = variantWrapperArr[1].GetString();
            if (!TextUtils.isEmpty(GetString)) {
                String j3 = j(GetString);
                if (!TextUtils.isEmpty(j3) && j3.equalsIgnoreCase(q.f250387s)) {
                    QQAppInterface qQAppInterface = this.f179458a.get();
                    if (qQAppInterface != null) {
                        this.f179459b = new ArkSSODataRequest(qQAppInterface, this.f179461d);
                    } else {
                        this.f179459b = new ArkIPCSSODataRequest(this.f179461d);
                    }
                    if (this.f179459b.d(GetString)) {
                        variantWrapper.SetBool(true);
                        return true;
                    }
                }
            }
        }
        variantWrapper.SetBool(false);
        return true;
    }

    protected boolean h(ark.VariantWrapper[] variantWrapperArr, ark.VariantWrapper variantWrapper) {
        ark.VariantWrapper variantWrapper2;
        String GetTableAsJsonString;
        if (this.f179459b != null && variantWrapperArr != null && variantWrapperArr.length >= 2 && (variantWrapper2 = variantWrapperArr[1]) != null) {
            if (variantWrapper2.GetType() == 1) {
                GetTableAsJsonString = null;
            } else if (variantWrapper2.GetType() == 5) {
                GetTableAsJsonString = variantWrapper2.GetString();
            } else if (variantWrapper2.IsArray() || variantWrapper2.IsTable()) {
                GetTableAsJsonString = variantWrapper2.GetTableAsJsonString();
            }
            this.f179459b.f(this);
            if (this.f179459b.e(GetTableAsJsonString)) {
                variantWrapper.SetBool(true);
                return true;
            }
        }
        variantWrapper.SetBool(false);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected boolean i(ark.VariantWrapper[] variantWrapperArr, ark.VariantWrapper variantWrapper) {
        int GetDouble;
        int i3 = 0;
        if (this.f179459b != null && variantWrapperArr != null && variantWrapperArr.length >= 2) {
            ark.VariantWrapper variantWrapper2 = variantWrapperArr[1];
            if (variantWrapper2 != null) {
                if (variantWrapper2.GetType() == 3) {
                    GetDouble = variantWrapper2.GetInt();
                } else if (variantWrapper2.GetType() == 4) {
                    GetDouble = (int) variantWrapper2.GetDouble();
                }
                if (GetDouble >= 0) {
                    i3 = GetDouble;
                }
                this.f179459b.g(i3);
                variantWrapper.SetBool(true);
                return true;
            }
            GetDouble = 0;
            if (GetDouble >= 0) {
            }
            this.f179459b.g(i3);
            variantWrapper.SetBool(true);
            return true;
        }
        variantWrapper.SetBool(false);
        return true;
    }

    protected String j(String str) {
        int indexOf;
        if (TextUtils.isEmpty(str) || (indexOf = str.indexOf(QzoneWebViewOfflinePlugin.STR_DEVIDER)) < 0) {
            return null;
        }
        return str.substring(0, indexOf);
    }

    @Override // com.tencent.mobileqq.activity.aio.item.d.a
    public void onComplete() {
        ark.VariantWrapper variantWrapper;
        if (this.f179459b != null && (variantWrapper = this.f179460c) != null && variantWrapper.IsFunction()) {
            this.f179460c.InvokeDefault(null, null);
        }
    }
}

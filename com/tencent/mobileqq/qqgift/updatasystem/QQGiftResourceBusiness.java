package com.tencent.mobileqq.qqgift.updatasystem;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.vas.update.entity.BusinessUpdateParams;
import com.tencent.vas.update.entity.UpdateListenerParams;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QQGiftResourceBusiness extends QQVasUpdateBusiness {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private String f265011a;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes16.dex */
    public @interface GiftResourceType {
    }

    public QQGiftResourceBusiness() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f265011a = "downloadGiftResource";
        }
    }

    public int e(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, i3)).intValue();
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            String[] split = str.split("\\.");
            if (split.length <= 1) {
                return 0;
            }
            return Integer.parseInt(split[1]);
        } catch (Exception e16) {
            QLog.e("QQGiftResourceBusiness", 2, "get id throw exception e:" + e16.getMessage());
            return 0;
        }
    }

    public String f(int i3, int i16) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        if (i16 == 1) {
            str = ".panel.zip";
        } else if (i16 == 2) {
            str = ".animation.zip";
        } else if (i16 == 3) {
            str = ".ark.zip";
        } else {
            QLog.e("QQGiftResourceBusiness", 1, "getScid error! suffix is empty! id:" + i3 + ", type:" + i16);
            return super.getScid(i3);
        }
        return "livegift." + i3 + str;
    }

    public void g(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.f265011a = str;
            QLog.e("QQGiftResourceBusiness", 1, "setFrom:" + this.f265011a);
        }
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public long getBid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return 311L;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    protected String getBusinessDir() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return AegisLogger.GIFT;
    }

    @Override // com.tencent.vas.update.callback.listener.IBusinessCallback
    public String getFrom() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f265011a;
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    public boolean isEnableCheckFile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return QQVasUpdateBusiness.isEnableFileCheck(getBid());
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness, com.tencent.vas.update.business.BaseUpdateBusiness, com.tencent.vas.update.callback.listener.IUpdateListener
    public void onLoadFail(@NonNull UpdateListenerParams updateListenerParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) updateListenerParams);
            return;
        }
        BusinessUpdateParams businessUpdateParams = updateListenerParams.mBusinessUpdateParams;
        if (businessUpdateParams != null && businessUpdateParams.mBid == getBid()) {
            super.onLoadFail(updateListenerParams);
        }
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness, com.tencent.vas.update.business.BaseUpdateBusiness, com.tencent.vas.update.callback.listener.IUpdateListener
    public void onLoadSuccess(@NonNull UpdateListenerParams updateListenerParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) updateListenerParams);
            return;
        }
        BusinessUpdateParams businessUpdateParams = updateListenerParams.mBusinessUpdateParams;
        if (businessUpdateParams != null && businessUpdateParams.mBid == getBid()) {
            super.onLoadSuccess(updateListenerParams);
        }
    }

    @Override // com.tencent.vas.update.business.BaseUpdateBusiness, com.tencent.vas.update.callback.listener.IUpdateListener
    public void onProgress(@NonNull UpdateListenerParams updateListenerParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) updateListenerParams);
            return;
        }
        BusinessUpdateParams businessUpdateParams = updateListenerParams.mBusinessUpdateParams;
        if (businessUpdateParams != null && businessUpdateParams.mBid == getBid()) {
            super.onProgress(updateListenerParams);
        }
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness
    @Deprecated
    public void startDownload(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            super.startDownload(i3);
        }
    }
}

package com.tencent.mobileqq.wxapi.api.impl;

import android.graphics.Bitmap;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.api.IWXShareHelper;
import com.tencent.mobileqq.wxapi.data.WXShareRsp;
import com.tencent.mobileqq.wxapi.listener.IWXShareHelperListener;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes21.dex */
public class WXShareHelperImpl implements IWXShareHelper {
    static IPatchRedirector $redirector_;
    private ConcurrentHashMap<IWXShareHelperListener, a> mListenerMap;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    static class a implements WXShareHelper.a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        WeakReference<IWXShareHelperListener> f327540d;

        public a(IWXShareHelperListener iWXShareHelperListener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) iWXShareHelperListener);
            } else {
                this.f327540d = new WeakReference<>(iWXShareHelperListener);
            }
        }

        @Override // com.tencent.mobileqq.wxapi.WXShareHelper.a
        public void onWXShareResp(BaseResp baseResp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) baseResp);
                return;
            }
            WeakReference<IWXShareHelperListener> weakReference = this.f327540d;
            if (weakReference != null && weakReference.get() != null) {
                WXShareRsp wXShareRsp = new WXShareRsp();
                wXShareRsp.errCode = baseResp.errCode;
                wXShareRsp.errStr = baseResp.errStr;
                wXShareRsp.openId = baseResp.openId;
                wXShareRsp.transaction = baseResp.transaction;
                this.f327540d.get().onWXShareResp(wXShareRsp);
            }
        }
    }

    public WXShareHelperImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mListenerMap = new ConcurrentHashMap<>();
        }
    }

    @Override // com.tencent.mobileqq.wxapi.api.IWXShareHelper
    public int ERR_AUTH_DENIED() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return -4;
    }

    @Override // com.tencent.mobileqq.wxapi.api.IWXShareHelper
    public int ERR_OK() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.wxapi.api.IWXShareHelper
    public int ERR_USER_CANCEL() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return -2;
    }

    @Override // com.tencent.mobileqq.wxapi.api.IWXShareHelper
    public int WXSceneFavorite() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        return 2;
    }

    @Override // com.tencent.mobileqq.wxapi.api.IWXShareHelper
    public int WXSceneSession() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.wxapi.api.IWXShareHelper
    public int WXSceneSpecifiedContact() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        return 3;
    }

    @Override // com.tencent.mobileqq.wxapi.api.IWXShareHelper
    public int WXSceneTimeline() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return 1;
    }

    @Override // com.tencent.mobileqq.wxapi.api.IWXShareHelper
    public void addObserver(IWXShareHelperListener iWXShareHelperListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) iWXShareHelperListener);
            return;
        }
        a aVar = new a(iWXShareHelperListener);
        WXShareHelper.b0().A(aVar);
        this.mListenerMap.put(iWXShareHelperListener, aVar);
    }

    @Override // com.tencent.mobileqq.wxapi.api.IWXShareHelper
    public boolean isWXInstalled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return WXShareHelper.b0().e0();
    }

    @Override // com.tencent.mobileqq.wxapi.api.IWXShareHelper
    public boolean isWXsupportApi() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return WXShareHelper.b0().f0();
    }

    @Override // com.tencent.mobileqq.wxapi.api.IWXShareHelper
    public void removeObserver(IWXShareHelperListener iWXShareHelperListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) iWXShareHelperListener);
        } else if (this.mListenerMap.get(iWXShareHelperListener) != null) {
            WXShareHelper.b0().q0(this.mListenerMap.get(iWXShareHelperListener));
            this.mListenerMap.remove(iWXShareHelperListener);
        }
    }

    @Override // com.tencent.mobileqq.wxapi.api.IWXShareHelper
    public void shareImageToWX(String str, Bitmap bitmap, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, bitmap, Integer.valueOf(i3));
        } else {
            WXShareHelper.b0().u0(str, bitmap, i3);
        }
    }

    @Override // com.tencent.mobileqq.wxapi.api.IWXShareHelper
    public void shareQcircleToWX(String str, String str2, Bitmap bitmap, String str3, String str4, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, str2, bitmap, str3, str4, Integer.valueOf(i3));
        } else {
            WXShareHelper.b0().E0(str, str2, bitmap, str3, str4, i3);
        }
    }

    @Override // com.tencent.mobileqq.wxapi.api.IWXShareHelper
    public void shareTroopToWXFriend(String str, String str2, Bitmap bitmap, String str3, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, str2, bitmap, str3, str4);
        } else {
            WXShareHelper.b0().J0(str, str2, bitmap, str3, str4);
        }
    }

    @Override // com.tencent.mobileqq.wxapi.api.IWXShareHelper
    public void shareTroopToWXFriendCircle(String str, String str2, Bitmap bitmap, String str3, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, str2, bitmap, str3, str4);
        } else {
            WXShareHelper.b0().K0(str, str2, bitmap, str3, str4);
        }
    }

    @Override // com.tencent.mobileqq.wxapi.api.IWXShareHelper
    public void shareWebPageToWXFriend(String str, String str2, Bitmap bitmap, String str3, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, str2, bitmap, str3, str4);
        } else {
            WXShareHelper.b0().M0(str, str2, bitmap, str3, str4);
        }
    }

    @Override // com.tencent.mobileqq.wxapi.api.IWXShareHelper
    public void shareWebPageToWXFriendCircle(String str, String str2, Bitmap bitmap, String str3, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, str2, bitmap, str3, str4);
        } else {
            WXShareHelper.b0().N0(str, str2, bitmap, str3, str4);
        }
    }
}

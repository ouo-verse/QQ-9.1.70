package com.tencent.could.huiyansdk.fragments;

import com.tencent.could.huiyansdk.manager.k;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import java.io.InputStream;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public class g implements YtSDKKitFramework.IYTBaseFunctionListener {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AuthingFragment f100093a;

    public g(AuthingFragment authingFragment) {
        this.f100093a = authingFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) authingFragment);
        }
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYTBaseFunctionListener
    public String base64Encode(byte[] bArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr, i3);
        }
        return null;
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYTBaseFunctionListener
    public void detectActionDone(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYTBaseFunctionListener
    public HashMap<String, Integer> getFrameResult(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (HashMap) iPatchRedirector.redirect((short) 4, (Object) this, obj);
        }
        return null;
    }

    @Override // com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYTBaseFunctionListener
    public byte[] getVoiceData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (byte[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        byte[] bArr = null;
        try {
            InputStream open = this.f100093a.c().getAssets().open("readnum6098.spx");
            if (open.available() != 0) {
                bArr = new byte[open.available()];
            }
            open.read(bArr);
            open.close();
        } catch (Exception e16) {
            k.a.f100197a.a(2, "AuthingFragment", "get voice failed " + e16.getLocalizedMessage());
        }
        return bArr;
    }
}

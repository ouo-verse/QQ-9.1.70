package com.tencent.qqlive.tvkplayer.vinfo.ckey;

/* compiled from: P */
/* loaded from: classes23.dex */
public class ModuleUpdateDefault implements ModuleUpdateInterface {
    @Override // com.tencent.qqlive.tvkplayer.vinfo.ckey.ModuleUpdateInterface
    public boolean loadLibrary(String str) {
        try {
            System.loadLibrary(str);
            return true;
        } catch (UnsatisfiedLinkError e16) {
            e16.printStackTrace();
            return false;
        }
    }
}

package com.tencent.mobileqq.pic.api.impl;

import com.tencent.libra.IPicLoader;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.pic.api.IPicAIOApi;
import com.tencent.mobileqq.picloader.PicLoader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.NTAIOImgThumbHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J \u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J \u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0005H\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/pic/api/impl/PicAIOApiImpl;", "Lcom/tencent/mobileqq/pic/api/IPicAIOApi;", "", "isDynamicImg", "isEmotion", "", "picMaxSize", "getThumbMaxDp", "getThumbMinDp", "Lcom/tencent/mobileqq/pic/option/a;", "option", "", "loadPic", "Lcom/tencent/libra/request/Option;", "Lcom/tencent/libra/listener/IPicLoadStateListener;", "listener", "Lcom/tencent/libra/IPicLoader;", "getPicLoader", "resetHelperCache", "picType", "<init>", "()V", "pic_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class PicAIOApiImpl implements IPicAIOApi {
    static IPatchRedirector $redirector_;

    public PicAIOApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.pic.api.IPicAIOApi
    @NotNull
    public IPicLoader getPicLoader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (IPicLoader) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return PicLoader.INSTANCE.a().c();
    }

    @Override // com.tencent.mobileqq.pic.api.IPicAIOApi
    public int getThumbMaxDp(boolean isDynamicImg, boolean isEmotion, int picMaxSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isDynamicImg), Boolean.valueOf(isEmotion), Integer.valueOf(picMaxSize))).intValue();
        }
        return NTAIOImgThumbHelper.INSTANCE.getAioThumbMaxDp(isDynamicImg, isEmotion, picMaxSize);
    }

    @Override // com.tencent.mobileqq.pic.api.IPicAIOApi
    public int getThumbMinDp(boolean isDynamicImg, boolean isEmotion, int picMaxSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(isDynamicImg), Boolean.valueOf(isEmotion), Integer.valueOf(picMaxSize))).intValue();
        }
        return NTAIOImgThumbHelper.INSTANCE.getAioThumbMinDp(isDynamicImg, isEmotion, picMaxSize);
    }

    @Override // com.tencent.mobileqq.pic.api.IPicAIOApi
    public boolean isDynamicImg(int picType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, picType)).booleanValue();
        }
        if (picType == 2000) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.pic.api.IPicAIOApi
    public void loadPic(@NotNull com.tencent.mobileqq.pic.option.a option) {
        Option b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) option);
            return;
        }
        Intrinsics.checkNotNullParameter(option, "option");
        PicLoader a16 = PicLoader.INSTANCE.a();
        b16 = a.b(option);
        a16.e(b16);
    }

    @Override // com.tencent.mobileqq.pic.api.IPicAIOApi
    public void resetHelperCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            NTAIOImgThumbHelper.INSTANCE.resetCache();
        }
    }

    @Override // com.tencent.mobileqq.pic.api.IPicAIOApi
    public void loadPic(@NotNull Option option, @Nullable IPicLoadStateListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) option, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(option, "option");
        option.disableHardwareDecode();
        PicLoader.INSTANCE.a().f(option, listener);
    }
}

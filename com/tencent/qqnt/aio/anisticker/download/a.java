package com.tencent.qqnt.aio.anisticker.download;

import com.tencent.mobileqq.data.AniStickerInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.FileUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0016\u0010\n\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/aio/anisticker/download/a;", "Lcom/tencent/qqnt/aio/anisticker/download/i;", "Lcom/tencent/mobileqq/data/AniStickerInfo;", "options", "", "v", "", "checkFileExists", "b", "Lcom/tencent/mobileqq/data/AniStickerInfo;", "mAniStickerInfo", "", "i", "()Ljava/lang/String;", "filePath", "g", "cacheKey", "<init>", "()V", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a extends i<AniStickerInfo> {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private AniStickerInfo mAniStickerInfo;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.anisticker.download.l
    public boolean checkFileExists() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return FileUtils.fileExists(i());
    }

    @Override // com.tencent.qqnt.aio.anisticker.download.i
    @NotNull
    public String g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        AniStickerInfo aniStickerInfo = this.mAniStickerInfo;
        if (aniStickerInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAniStickerInfo");
            aniStickerInfo = null;
        }
        String cacheKey = aniStickerInfo.getCacheKey();
        Intrinsics.checkNotNullExpressionValue(cacheKey, "mAniStickerInfo.cacheKey");
        return cacheKey;
    }

    @Override // com.tencent.qqnt.aio.anisticker.download.i
    @NotNull
    public String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        AniStickerInfo aniStickerInfo = this.mAniStickerInfo;
        if (aniStickerInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAniStickerInfo");
            aniStickerInfo = null;
        }
        String finishStateResFilePath = aniStickerInfo.getFinishStateResFilePath();
        Intrinsics.checkNotNullExpressionValue(finishStateResFilePath, "mAniStickerInfo.finishStateResFilePath");
        return finishStateResFilePath;
    }

    @Override // com.tencent.qqnt.aio.anisticker.download.i
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void u(@NotNull AniStickerInfo options) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) options);
        } else {
            Intrinsics.checkNotNullParameter(options, "options");
            this.mAniStickerInfo = options;
        }
    }
}

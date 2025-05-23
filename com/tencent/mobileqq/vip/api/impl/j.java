package com.tencent.mobileqq.vip.api.impl;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.vipicon.AbsLetterSwitchDrawable;
import com.tencent.qzonehub.api.utils.IQzoneZipCacheHelper;
import cooperation.qzone.zipanimate.ZipDrawableLoader;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\n\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\b\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0010\u0010\u0011J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0006R\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0006\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/vip/api/impl/j;", "Lcom/tencent/mobileqq/vas/vipicon/AbsLetterSwitchDrawable;", "Lcom/tencent/mobileqq/vas/vipicon/AbsLetterSwitchDrawable$b;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "resZipUrl", "", "G", "Ljava/util/List;", "idLetterList", "H", "bgFileName", "I", "fgFileName", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class j extends AbsLetterSwitchDrawable {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final String resZipUrl;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final List<String> idLetterList;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final String bgFileName;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final String fgFileName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(@NotNull String resZipUrl, @NotNull List<String> idLetterList, @NotNull String bgFileName, @NotNull String fgFileName) {
        super("qzone");
        Intrinsics.checkNotNullParameter(resZipUrl, "resZipUrl");
        Intrinsics.checkNotNullParameter(idLetterList, "idLetterList");
        Intrinsics.checkNotNullParameter(bgFileName, "bgFileName");
        Intrinsics.checkNotNullParameter(fgFileName, "fgFileName");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, resZipUrl, idLetterList, bgFileName, fgFileName);
            return;
        }
        this.resZipUrl = resZipUrl;
        this.idLetterList = idLetterList;
        this.bgFileName = bgFileName;
        this.fgFileName = fgFileName;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0064  */
    @Override // com.tencent.mobileqq.vas.vipicon.AbsLetterSwitchDrawable
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AbsLetterSwitchDrawable.ImageFileData A() {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AbsLetterSwitchDrawable.ImageFileData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        String basePath = ((IQzoneZipCacheHelper) QRoute.api(IQzoneZipCacheHelper.class)).getBasePath(ZipDrawableLoader.DEFAULT_BUSINESS, String.valueOf(this.resZipUrl.hashCode()));
        String str = basePath + "/diy";
        File file = new File(str);
        boolean z18 = false;
        if (file.exists() && file.isDirectory()) {
            String[] list = file.list();
            if (list != null) {
                if (list.length == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17) {
                    z16 = true;
                    if (z16) {
                        z18 = true;
                    }
                }
            }
            z16 = false;
            if (z16) {
            }
        }
        if (z18) {
            AbsLetterSwitchDrawable.ImageFileData imageFileData = new AbsLetterSwitchDrawable.ImageFileData(null, null, null, 7, null);
            String absolutePath = new File(str, this.bgFileName).getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "File(resFileDir, bgFileName).absolutePath");
            imageFileData.d(absolutePath);
            for (String str2 : this.idLetterList) {
                imageFileData.c().add(new File(str, "l_" + str2 + ".png").getAbsolutePath());
            }
            imageFileData.e(new File(str, this.fgFileName).getAbsolutePath());
            return imageFileData;
        }
        FileUtils.deleteDirectory(basePath);
        IQzoneZipCacheHelper iQzoneZipCacheHelper = (IQzoneZipCacheHelper) QRoute.api(IQzoneZipCacheHelper.class);
        String str3 = this.resZipUrl;
        iQzoneZipCacheHelper.checkAndDownLoadFileIfNeeded(null, str3, ZipDrawableLoader.DEFAULT_BUSINESS, String.valueOf(str3.hashCode()), 0, null);
        return null;
    }
}

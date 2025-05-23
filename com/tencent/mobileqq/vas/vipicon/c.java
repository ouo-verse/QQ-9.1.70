package com.tencent.mobileqq.vas.vipicon;

import android.graphics.drawable.Drawable;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.business.DiyVipIconDownloadBusiness;
import com.tencent.mobileqq.vas.vipicon.AbsLetterSwitchDrawable;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d\u00a2\u0006\u0004\b\u001f\u0010 J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016R\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\b\u001a\u0004\b\u0010\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0013\u0010\u000eR\u0017\u0010\u001a\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/vas/vipicon/c;", "Lcom/tencent/mobileqq/vas/vipicon/AbsLetterSwitchDrawable;", "Lcom/tencent/mobileqq/vas/vipicon/AbsLetterSwitchDrawable$b;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "getIntrinsicWidth", "getIntrinsicHeight", UserInfo.SEX_FEMALE, "I", "width", "G", "height", "H", "getId", "()I", "id", "getVipLevel", "vipLevel", "J", "getFgId", "fgId", "", "K", "[I", "getLetterIds", "()[I", "letterIds", "Landroid/graphics/drawable/Drawable;", "defaultDrawable", "", "scene", "<init>", "(IIIII[ILandroid/graphics/drawable/Drawable;Ljava/lang/String;)V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class c extends AbsLetterSwitchDrawable {

    /* renamed from: F, reason: from kotlin metadata */
    private final int width;

    /* renamed from: G, reason: from kotlin metadata */
    private final int height;

    /* renamed from: H, reason: from kotlin metadata */
    private final int id;

    /* renamed from: I, reason: from kotlin metadata */
    private final int vipLevel;

    /* renamed from: J, reason: from kotlin metadata */
    private final int fgId;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final int[] letterIds;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(int i3, int i16, int i17, int i18, int i19, @NotNull int[] letterIds, @Nullable Drawable drawable, @NotNull String scene) {
        super(scene);
        Intrinsics.checkNotNullParameter(letterIds, "letterIds");
        Intrinsics.checkNotNullParameter(scene, "scene");
        this.width = i3;
        this.height = i16;
        this.id = i17;
        this.vipLevel = i18;
        this.fgId = i19;
        this.letterIds = letterIds;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(c this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.F(false);
    }

    @Override // com.tencent.mobileqq.vas.vipicon.AbsLetterSwitchDrawable
    @Nullable
    public AbsLetterSwitchDrawable.ImageFileData A() {
        BaseApplication context = BaseApplication.getContext();
        DiyVipIconDownloadBusiness diyVipIconDownloadBusiness = (DiyVipIconDownloadBusiness) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(DiyVipIconDownloadBusiness.class);
        if (!diyVipIconDownloadBusiness.isFileExists(this.id)) {
            QLog.w("LetterSwitchDrawable", 1, this.id + " exists=false");
            diyVipIconDownloadBusiness.addDownLoadListener(this.id, new Runnable() { // from class: com.tencent.mobileqq.vas.vipicon.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.N(c.this);
                }
            });
            diyVipIconDownloadBusiness.startDownload(this.id);
            return null;
        }
        int i3 = this.id;
        int i16 = this.vipLevel;
        int i17 = this.fgId;
        String arrays = Arrays.toString(this.letterIds);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        QLog.i("LetterSwitchDrawable", 1, "id|vipLevel|fgId|letterIds " + i3 + "|" + i16 + "|" + i17 + "|" + arrays);
        AbsLetterSwitchDrawable.ImageFileData imageFileData = new AbsLetterSwitchDrawable.ImageFileData(null, null, null, 7, null);
        File imagesRoot = diyVipIconDownloadBusiness.getImagesRoot(context, this.id);
        int i18 = this.vipLevel;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("bg_lv");
        sb5.append(i18);
        sb5.append(".png");
        String absolutePath = new File(imagesRoot, sb5.toString()).getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "File(root, \"bg_lv${vipLevel}.png\").absolutePath");
        imageFileData.d(absolutePath);
        for (int i19 : this.letterIds) {
            imageFileData.c().add(new File(imagesRoot, "l_" + i19 + ".png").getAbsolutePath());
        }
        if (this.fgId > 0) {
            imageFileData.e(new File(imagesRoot, "fg_" + this.fgId + ".png").getAbsolutePath());
        }
        return imageFileData;
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable, android.graphics.drawable.Drawable
    /* renamed from: getIntrinsicHeight */
    public int getHeight() {
        return this.height;
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable, android.graphics.drawable.Drawable
    /* renamed from: getIntrinsicWidth */
    public int getWidth() {
        return this.width;
    }
}

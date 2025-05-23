package com.tencent.mobileqq.vas.vipicon;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.business.b;
import com.tencent.mobileqq.vas.vipicon.AbsLetterScrollDrawable;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0014\u0010\u0015J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0007R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/vas/vipicon/e;", "Lcom/tencent/mobileqq/vas/vipicon/AbsLetterScrollDrawable;", "Lcom/tencent/mobileqq/vas/vipicon/AbsLetterScrollDrawable$b;", "E", "", "getIntrinsicWidth", "getIntrinsicHeight", "I", "width", UserInfo.SEX_FEMALE, "height", "G", "id", "H", "vipLevel", "", "", "Ljava/util/List;", "letters", "scene", "<init>", "(IIIILjava/util/List;Ljava/lang/String;)V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class e extends AbsLetterScrollDrawable {

    /* renamed from: E, reason: from kotlin metadata */
    private final int width;

    /* renamed from: F, reason: from kotlin metadata */
    private final int height;

    /* renamed from: G, reason: from kotlin metadata */
    private final int id;

    /* renamed from: H, reason: from kotlin metadata */
    private final int vipLevel;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final List<String> letters;

    public /* synthetic */ e(int i3, int i16, int i17, int i18, List list, String str, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, i16, i17, i18, list, (i19 & 32) != 0 ? "" : str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(e this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.F(false);
    }

    @Override // com.tencent.mobileqq.vas.vipicon.AbsLetterScrollDrawable
    @Nullable
    public AbsLetterScrollDrawable.ImageFileData E() {
        com.tencent.mobileqq.vas.updatesystem.business.b bVar = (com.tencent.mobileqq.vas.updatesystem.business.b) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(com.tencent.mobileqq.vas.updatesystem.business.b.class);
        if (!bVar.isFileExists(this.id)) {
            QLog.w("AbsLetterScrollDrawable", 1, this.id + " exists=false");
            bVar.addDownLoadListener(this.id, new Runnable() { // from class: com.tencent.mobileqq.vas.vipicon.d
                @Override // java.lang.Runnable
                public final void run() {
                    e.K(e.this);
                }
            });
            bVar.startDownload(this.id);
            return null;
        }
        AbsLetterScrollDrawable.ImageFileData imageFileData = new AbsLetterScrollDrawable.ImageFileData(null, null, null, 7, null);
        b.a e16 = bVar.e(this.id, this.vipLevel, this.letters);
        String absolutePath = e16.f311186b.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "iconPath.cover.absolutePath");
        imageFileData.e(absolutePath);
        String absolutePath2 = e16.f311185a.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath2, "iconPath.background.absolutePath");
        imageFileData.d(absolutePath2);
        List<File> list = e16.f311187c;
        Intrinsics.checkNotNullExpressionValue(list, "iconPath.letters");
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            imageFileData.c().add(((File) it.next()).getAbsolutePath());
        }
        return imageFileData;
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.height;
    }

    @Override // com.tencent.mobileqq.vas.image.AbsAsyncDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.width;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(int i3, int i16, int i17, int i18, @NotNull List<String> letters, @NotNull String scene) {
        super(scene);
        Intrinsics.checkNotNullParameter(letters, "letters");
        Intrinsics.checkNotNullParameter(scene, "scene");
        this.width = i3;
        this.height = i16;
        this.id = i17;
        this.vipLevel = i18;
        this.letters = letters;
    }
}

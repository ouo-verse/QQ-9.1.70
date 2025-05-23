package com.tencent.mobileqq.vas.bubble.impl;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.bubble.IBubbleManager;
import com.tencent.mobileqq.vas.bubble.drawable.a;
import com.tencent.mobileqq.vas.bubble.report.VasBubbleReporter;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.business.BubbleBusiness;
import f03.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J2\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J*\u0010\u0015\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J*\u0010\u0018\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0004H\u0016R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/vas/bubble/impl/BubbleManagerImpl;", "Lcom/tencent/mobileqq/vas/bubble/IBubbleManager;", "", "bubbleId", "", "isShootBubble", "", "Lcom/tencent/mobileqq/vas/bubble/IBubbleManager$a;", "getBubbleTextInfo", "checkBubbleFile", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "startDownload", "diyId", "uin", "messageType", "isMirror", "Landroid/graphics/drawable/Drawable;", "getBackground", "message", "getAnimDrawable", "startX", "startY", "getShootAnimDrawable", "Lcom/tencent/mobileqq/vas/bubble/drawable/a;", "bubbleAnimDrawableFactory", "Lcom/tencent/mobileqq/vas/bubble/drawable/a;", "Ll03/a;", "bubbleConfigManager", "Ll03/a;", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class BubbleManagerImpl implements IBubbleManager {

    @NotNull
    private final a bubbleAnimDrawableFactory = new a();

    @NotNull
    private final l03.a bubbleConfigManager = new l03.a();

    @Override // com.tencent.mobileqq.vas.bubble.IBubbleManager
    public boolean checkBubbleFile(int bubbleId) {
        String replace$default;
        boolean isFileExists = ((BubbleBusiness) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(BubbleBusiness.class)).isFileExists(bubbleId);
        if (!isFileExists) {
            replace$default = StringsKt__StringsJVMKt.replace$default(VasBubbleReporter.ERROR_DRAW_FILE_EXIST, "{id}", String.valueOf(bubbleId), false, 4, (Object) null);
            VasBubbleReporter.INSTANCE.report(replace$default);
        }
        return isFileExists;
    }

    @Override // com.tencent.mobileqq.vas.bubble.IBubbleManager
    @Nullable
    public Drawable getAnimDrawable(@NotNull String bubbleId, @NotNull String message, int messageType, boolean isMirror) {
        Intrinsics.checkNotNullParameter(bubbleId, "bubbleId");
        Intrinsics.checkNotNullParameter(message, "message");
        return this.bubbleAnimDrawableFactory.a(bubbleId, message, messageType, isMirror);
    }

    @Override // com.tencent.mobileqq.vas.bubble.IBubbleManager
    @Nullable
    public Drawable getBackground(@NotNull String bubbleId, @NotNull String diyId, @NotNull String uin, int messageType, boolean isMirror) {
        Intrinsics.checkNotNullParameter(bubbleId, "bubbleId");
        Intrinsics.checkNotNullParameter(diyId, "diyId");
        Intrinsics.checkNotNullParameter(uin, "uin");
        return this.bubbleAnimDrawableFactory.b(bubbleId, diyId, uin, messageType, isMirror);
    }

    @Override // com.tencent.mobileqq.vas.bubble.IBubbleManager
    @Nullable
    public IBubbleManager.BubbleTextInfo getBubbleTextInfo(@NotNull String bubbleId) {
        Intrinsics.checkNotNullParameter(bubbleId, "bubbleId");
        b c16 = this.bubbleConfigManager.c(bubbleId, false);
        if (c16 != null) {
            return new IBubbleManager.BubbleTextInfo(c16.getFontColor(), c16.getLinkColor());
        }
        return null;
    }

    @Override // com.tencent.mobileqq.vas.bubble.IBubbleManager
    @Nullable
    public Drawable getShootAnimDrawable(@NotNull String bubbleId, int startX, int startY, boolean isMirror) {
        Intrinsics.checkNotNullParameter(bubbleId, "bubbleId");
        return this.bubbleAnimDrawableFactory.c(bubbleId, startX, startY, isMirror);
    }

    @Override // com.tencent.mobileqq.vas.bubble.IBubbleManager
    public boolean isShootBubble(int bubbleId) {
        b c16;
        if (!checkBubbleFile(bubbleId) || (c16 = this.bubbleConfigManager.c(String.valueOf(bubbleId), true)) == null || c16.getShootAnimation() == null) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.vas.bubble.IBubbleManager
    public void startDownload(int bubbleId, @NotNull AIOMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        ((BubbleBusiness) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(BubbleBusiness.class)).startDownload(bubbleId);
    }
}

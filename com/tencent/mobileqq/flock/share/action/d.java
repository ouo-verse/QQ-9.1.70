package com.tencent.mobileqq.flock.share.action;

import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import y45.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH\u0014\u00a2\u0006\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/flock/share/action/d;", "Lcom/tencent/mobileqq/flock/share/action/FlockShare2WeChatAction;", "Ly45/n;", "shareInfo", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "sheetItem", "", "e", "(Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;)Ljava/lang/Integer;", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class d extends FlockShare2WeChatAction {
    static IPatchRedirector $redirector_;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.flock.share.action.FlockShare2WeChatAction, com.tencent.mobileqq.flock.share.action.FlockShareBaseAction
    @Nullable
    protected Integer e(@NotNull ShareActionSheetBuilder.ActionSheetItem sheetItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) sheetItem);
        }
        Intrinsics.checkNotNullParameter(sheetItem, "sheetItem");
        return 4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.flock.share.action.FlockShare2WeChatAction
    public void n(@NotNull n shareInfo, @NotNull Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) shareInfo, (Object) bitmap);
            return;
        }
        Intrinsics.checkNotNullParameter(shareInfo, "shareInfo");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        com.tencent.mobileqq.flock.share.c.f210421a.d().shareWebPageToWXFriendCircle(String.valueOf(System.currentTimeMillis()), shareInfo.f449442a, bitmap, shareInfo.f449443b, shareInfo.f449445d);
    }
}

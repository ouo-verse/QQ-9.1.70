package com.tencent.mobileqq.hermes.share;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.hermes.share.HermesShareActionManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqforward.api.IForwardOption;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/hermes/share/HermesShareToQQFriendAction;", "Lcom/tencent/mobileqq/hermes/share/HermesAbsShareAction;", "", "filePath", "Lcom/tencent/mobileqq/hermes/share/k;", "shareContext", "", "k", "", "", "e", "Lcom/tencent/mobileqq/hermes/share/HermesShareActionManager$ShareLine;", "d", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "b", "<init>", "()V", "hermes-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class HermesShareToQQFriendAction extends HermesAbsShareAction {
    static IPatchRedirector $redirector_;

    public HermesShareToQQFriendAction() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(String filePath, k shareContext) {
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", 1);
        bundle.putBoolean(AppConstants.Key.KEY_HELP_FORWARD_PIC, true);
        bundle.putString(AppConstants.Key.FORWARD_FILEPATH, filePath);
        bundle.putString(AppConstants.Key.FORWARD_THUMB, filePath);
        bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, filePath);
        bundle.putString(AppConstants.Key.FORWARD_EXTRA, filePath);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        ((IForwardOption) QRoute.api(IForwardOption.class)).startForwardActivityForResult(shareContext.a(), intent, 21);
    }

    @Override // com.tencent.mobileqq.hermes.share.HermesAbsShareAction
    public void b(@NotNull k shareContext, @NotNull ShareActionSheetBuilder.ActionSheetItem item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) shareContext, (Object) item);
            return;
        }
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        BuildersKt__Builders_commonKt.launch$default(c(), null, null, new HermesShareToQQFriendAction$doAction$1(this, shareContext, null), 3, null);
    }

    @Override // com.tencent.mobileqq.hermes.share.HermesAbsShareAction
    @NotNull
    public HermesShareActionManager.ShareLine d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (HermesShareActionManager.ShareLine) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return HermesShareActionManager.ShareLine.FIRST;
    }

    @Override // com.tencent.mobileqq.hermes.share.HermesAbsShareAction
    @NotNull
    public List<Integer> e() {
        List<Integer> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(2);
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 2, (Object) this);
    }
}

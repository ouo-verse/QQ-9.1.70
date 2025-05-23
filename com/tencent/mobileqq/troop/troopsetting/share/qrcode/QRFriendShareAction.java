package com.tencent.mobileqq.troop.troopsetting.share.qrcode;

import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\fH\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0004\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/share/qrcode/QRFriendShareAction;", "Lcom/tencent/mobileqq/troop/troopsetting/share/qrcode/AbsQRCodeShareAction;", "Lcom/tencent/mobileqq/troop/troopsetting/share/b;", "shareContext", "Landroid/content/Intent;", "intent", "", "j", "", "filePath", "Landroid/os/Bundle;", "k", "", "d", "a", "l", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public class QRFriendShareAction extends AbsQRCodeShareAction {
    static IPatchRedirector $redirector_;

    public QRFriendShareAction() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(com.tencent.mobileqq.troop.troopsetting.share.b shareContext, Intent intent) {
        if (!Intrinsics.areEqual(shareContext.a(), "mypc")) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("key_direct_show_uin_type", 6000);
        bundle.putString("key_direct_show_uin", AppConstants.DATALINE_PC_UIN);
        bundle.putInt(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 1);
        bundle.putBoolean("filepath_copy", true);
        intent.putExtras(bundle);
    }

    private final Bundle k(String filePath) {
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", 1);
        bundle.putString(AppConstants.Key.FORWARD_FILEPATH, filePath);
        bundle.putString(AppConstants.Key.FORWARD_THUMB, filePath);
        bundle.putString(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, filePath);
        bundle.putString(AppConstants.Key.FORWARD_EXTRA, filePath);
        bundle.putBoolean(AppConstants.Key.KEY_HELP_FORWARD_PIC, true);
        return bundle;
    }

    @Override // com.tencent.mobileqq.troop.troopsetting.share.a
    public void a(@NotNull com.tencent.mobileqq.troop.troopsetting.share.b shareContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) shareContext);
            return;
        }
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        QBaseActivity b16 = shareContext.b();
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(b16), null, null, new QRFriendShareAction$doAction$1(this, shareContext, b16, null), 3, null);
    }

    @Override // com.tencent.mobileqq.troop.troopsetting.share.a
    @NotNull
    public List<String> d() {
        List<String> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"qqfriend", "mypc"});
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 2, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final Intent l(@NotNull String filePath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Intent) iPatchRedirector.redirect((short) 4, (Object) this, (Object) filePath);
        }
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intent intent = new Intent();
        intent.putExtras(k(filePath));
        intent.putExtra(AppConstants.Key.FORWARD_USE_BOTTOM_SHEET_PREVIEW, true);
        intent.putExtra(ForwardRecentActivity.SELECTION_MODE, 1);
        return intent;
    }
}

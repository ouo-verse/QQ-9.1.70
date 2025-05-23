package com.tencent.mobileqq.troop.troopsquare.topic.share;

import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.troopsquare.utils.ShareAction;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n\u00a2\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class TroopSquareTopicShareSheet$shareActionSheet$2 extends Lambda implements Function0<ShareActionSheet> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ TroopSquareTopicShareSheet this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopSquareTopicShareSheet$shareActionSheet$2(TroopSquareTopicShareSheet troopSquareTopicShareSheet) {
        super(0);
        this.this$0 = troopSquareTopicShareSheet;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopSquareTopicShareSheet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(TroopSquareTopicShareSheet this$0, View view, ShareActionSheetBuilder.ActionSheetItem item, ShareActionSheet sheet) {
        ShareActionSheet l3;
        TroopSquareTopicShareActionHandler k3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (QLog.isDebugVersion()) {
            QLog.d("TroopSquare.Topic.TroopSquareTopicShareSheet", 4, "share sheet clicked: " + item.f307296id);
        }
        l3 = this$0.l();
        l3.dismiss();
        ShareActionSheet.c h16 = this$0.h();
        if (h16 != null) {
            h16.w6(view, item, sheet);
        }
        Intrinsics.checkNotNullExpressionValue(view, "view");
        Intrinsics.checkNotNullExpressionValue(item, "item");
        Intrinsics.checkNotNullExpressionValue(sheet, "sheet");
        ShareAction shareAction = new ShareAction(view, item, sheet);
        k3 = this$0.k();
        shareAction.d(k3);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ShareActionSheet invoke() {
        List<ShareActionSheetBuilder.ActionSheetItem> j3;
        ArrayList i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ShareActionSheet) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        ShareActionSheetV2.Param param = new ShareActionSheetV2.Param();
        param.context = this.this$0.e();
        ShareActionSheet create = ShareActionSheetFactory.create(param);
        final TroopSquareTopicShareSheet troopSquareTopicShareSheet = this.this$0;
        create.setActionSheetTitle(troopSquareTopicShareSheet.e().getString(R.string.hja));
        create.setRowVisibility(0, 0, 0);
        j3 = troopSquareTopicShareSheet.j();
        i3 = troopSquareTopicShareSheet.i();
        create.setActionSheetItems(j3, i3);
        create.setIntentForStartForwardRecentActivity(new Intent());
        create.setItemClickListenerV3(new ShareActionSheet.c() { // from class: com.tencent.mobileqq.troop.troopsquare.topic.share.b
            @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.c
            public final void w6(View view, ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
                TroopSquareTopicShareSheet$shareActionSheet$2.b(TroopSquareTopicShareSheet.this, view, actionSheetItem, shareActionSheet);
            }
        });
        return create;
    }
}

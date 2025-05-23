package com.tencent.mobileqq.aio.msglist.holder.component.graptips.revoke;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msglist.holder.component.graptips.b;
import com.tencent.mobileqq.aio.msglist.holder.component.graptips.revoke.RevokeGrayTipsComponent;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqui.widget.AutoBgImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import w71.o;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/graptips/revoke/RevokeGrayTipsComponent$a;", "invoke", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/graptips/revoke/RevokeGrayTipsComponent$a;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class RevokeGrayTipsComponent$binding$2 extends Lambda implements Function0<RevokeGrayTipsComponent.a> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ RevokeGrayTipsComponent this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RevokeGrayTipsComponent$binding$2(RevokeGrayTipsComponent revokeGrayTipsComponent) {
        super(0);
        this.this$0 = revokeGrayTipsComponent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) revokeGrayTipsComponent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(final RevokeGrayTipsComponent this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.C1();
        HashMap hashMap = new HashMap();
        hashMap.put("gray_click_area", 3);
        hashMap.put("small_gray_service_id", Long.valueOf(RevokeGrayTipsComponent.J1(this$0).m2()));
        com.tencent.mobileqq.aio.utils.b.l("em_bas_aio_small_gray", hashMap);
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.valueOf(RevokeGrayTipsComponent.J1(this$0).getMsgRecord().msgId));
        ((IMsgService) QRoute.api(IMsgService.class)).deleteMsg(new Contact(RevokeGrayTipsComponent.J1(this$0).getMsgRecord().chatType, RevokeGrayTipsComponent.J1(this$0).getMsgRecord().peerUid, ""), arrayList, new IOperateCallback() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.graptips.revoke.e
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                RevokeGrayTipsComponent$binding$2.d(RevokeGrayTipsComponent.this, i3, str);
            }
        });
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(RevokeGrayTipsComponent this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("RevokeGrayTipsComponent", 4, "deleteMsg(res:" + i3 + ", errMsg:" + str);
        if (i3 == 0) {
            this$0.sendIntent(new b.C7299b(RevokeGrayTipsComponent.J1(this$0)));
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final RevokeGrayTipsComponent.a invoke() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (RevokeGrayTipsComponent.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        o g16 = o.g(LayoutInflater.from(this.this$0.getContext()), null, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, null, false)");
        ConstraintLayout root = g16.getRoot();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        root.setLayoutParams(layoutParams);
        g16.f444866c.setMaxWidth(com.tencent.mobileqq.aio.utils.e.f194142a.f() - ViewUtils.dpToPx(31.0f));
        g16.f444866c.setHighlightColor(0);
        RevokeGrayTipsComponent.a aVar = new RevokeGrayTipsComponent.a();
        final RevokeGrayTipsComponent revokeGrayTipsComponent = this.this$0;
        ConstraintLayout root2 = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "view.root");
        aVar.f(root2);
        AutoBgImageView autoBgImageView = g16.f444865b;
        Intrinsics.checkNotNullExpressionValue(autoBgImageView, "view.grayTipsCloseIcon");
        aVar.d(autoBgImageView);
        aVar.a().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.graptips.revoke.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RevokeGrayTipsComponent$binding$2.c(RevokeGrayTipsComponent.this, view);
            }
        });
        aVar.a().setContentDescription(HardCodeUtil.qqStr(R.string.f168842gq));
        TextView textView = g16.f444866c;
        Intrinsics.checkNotNullExpressionValue(textView, "view.grayTipsTextTotal");
        aVar.e(textView);
        return aVar;
    }
}

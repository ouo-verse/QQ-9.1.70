package com.tencent.mobileqq.aio.msgbox;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IAIOStarterApi;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import w71.f;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lw71/f;", "invoke", "()Lw71/f;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class MsgBox$binding$2 extends Lambda implements Function0<f> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ MsgBox this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgBox$binding$2(MsgBox msgBox) {
        super(0);
        this.this$0 = msgBox;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgBox);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(MsgBox this$0, f this_apply, View view) {
        Runnable runnable;
        ArrayList m3;
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        runnable = this$0.hideMsgBoxAction;
        runnable.run();
        m3 = this$0.m();
        Iterator it = m3.iterator();
        while (it.hasNext()) {
            ((jv3.b) it.next()).b(this$0.h());
        }
        if (this_apply.f444790b.getTag() instanceof AIOMsgItem) {
            Object tag = this_apply.f444790b.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.AIOMsgItem");
            AIOMsgItem aIOMsgItem = (AIOMsgItem) tag;
            IAIOStarterApi iAIOStarterApi = (IAIOStarterApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOStarterApi.class);
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "it.context");
            int i3 = aIOMsgItem.getMsgRecord().chatType;
            String str2 = aIOMsgItem.getMsgRecord().peerUid;
            Intrinsics.checkNotNullExpressionValue(str2, "msg.msgRecord.peerUid");
            String str3 = aIOMsgItem.getMsgRecord().peerName;
            Intrinsics.checkNotNullExpressionValue(str3, "msg.msgRecord.peerName");
            IAIOStarterApi.a.a(iAIOStarterApi, context, i3, str2, str3, aIOMsgItem.getMsgRecord().peerUin, null, 32, null);
        } else if (this_apply.f444790b.getTag() instanceof RecentContactInfo) {
            Object tag2 = this_apply.f444790b.getTag();
            Intrinsics.checkNotNull(tag2, "null cannot be cast to non-null type com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo");
            RecentContactInfo recentContactInfo = (RecentContactInfo) tag2;
            if (!TextUtils.isEmpty(recentContactInfo.remark)) {
                str = recentContactInfo.remark;
            } else if (!TextUtils.isEmpty(recentContactInfo.peerName)) {
                str = recentContactInfo.peerName;
            } else {
                str = "";
            }
            String name = str;
            IAIOStarterApi iAIOStarterApi2 = (IAIOStarterApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOStarterApi.class);
            Context context2 = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "it.context");
            int i16 = recentContactInfo.chatType;
            String str4 = recentContactInfo.peerUid;
            Intrinsics.checkNotNullExpressionValue(str4, "info.peerUid");
            Intrinsics.checkNotNullExpressionValue(name, "name");
            long j3 = recentContactInfo.peerUin;
            Bundle bundle = new Bundle();
            bundle.putBoolean("update_aio_by_msg_box", true);
            Unit unit = Unit.INSTANCE;
            iAIOStarterApi2.navigateToAIO(context2, i16, str4, name, j3, bundle);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final f invoke() {
        Context k3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (f) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        k3 = this.this$0.k();
        final f g16 = f.g(LayoutInflater.from(k3));
        final MsgBox msgBox = this.this$0;
        g16.f444790b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.msgbox.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MsgBox$binding$2.b(MsgBox.this, g16, view);
            }
        });
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.f\u2026}\n            }\n        }");
        return g16;
    }
}

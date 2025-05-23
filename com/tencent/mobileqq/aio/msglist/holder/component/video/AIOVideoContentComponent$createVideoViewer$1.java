package com.tencent.mobileqq.aio.msglist.holder.component.video;

import android.content.Context;
import android.view.View;
import com.tencent.map.sdk.comps.vis.VisualLayer;
import com.tencent.mobileqq.aio.msg.ShortVideoMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
public /* synthetic */ class AIOVideoContentComponent$createVideoViewer$1 extends FunctionReferenceImpl implements Function4<Context, ShortVideoMsgItem, View, Long, Unit> {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AIOVideoContentComponent$createVideoViewer$1(Object obj) {
        super(4, obj, AIOVideoContentComponent.class, VisualLayer.OnLayerStatusChangedListener.EventType.ON_CLICK, "onClickEvent(Landroid/content/Context;Lcom/tencent/mobileqq/aio/msg/ShortVideoMsgItem;Landroid/view/View;J)V", 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, obj);
        }
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(Context context, ShortVideoMsgItem shortVideoMsgItem, View view, Long l3) {
        invoke(context, shortVideoMsgItem, view, l3.longValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Context p06, @NotNull ShortVideoMsgItem p16, @NotNull View p26, long j3) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        Intrinsics.checkNotNullParameter(p16, "p1");
        Intrinsics.checkNotNullParameter(p26, "p2");
        ((AIOVideoContentComponent) this.receiver).S1(p06, p16, p26, j3);
    }
}

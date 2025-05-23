package com.tencent.guild.aio.msglist.file;

import android.content.Context;
import android.view.View;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.factory.business.holder.msglist.a;
import com.tencent.guild.aio.factory.business.holder.msglist.i;
import com.tencent.guild.aio.msglist.holder.component.t;
import com.tencent.guild.api.richmediabrowser.IGuildRichMediaBrowserApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mvi.base.route.k;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/guild/aio/msglist/file/c;", "Lcom/tencent/guild/aio/msglist/holder/component/t;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/PicElement;", "picElement", "Landroid/view/View;", "imageView", "", "l", "Lol3/b;", "intent", "handleIntent", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class c extends t {
    /* JADX WARN: Multi-variable type inference failed */
    private final void l(MsgRecord msgRecord, PicElement picElement, View imageView) {
        i.c cVar;
        List<MsgRecord> list;
        List<MsgRecord> list2;
        if (fo0.b.c((com.tencent.aio.api.runtime.a) getMContext())) {
            QLog.i(FrameworkVM.TAG, 1, "interceptOperationWhenInGuestInputMode");
            return;
        }
        k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(new GuildMsgListIntent.GetAIORichMediaMsgListEvent(msgRecord));
        if (k3 instanceof i.c) {
            cVar = (i.c) k3;
        } else {
            cVar = null;
        }
        Iterator<MsgElement> it = msgRecord.elements.iterator();
        String str = "";
        boolean z16 = false;
        boolean z17 = false;
        boolean z18 = false;
        while (it.hasNext()) {
            MsgElement next = it.next();
            if (next.elementType == 3) {
                Integer num = next.fileElement.invalidState;
                if (num != null && num.intValue() == 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                FileElement fileElement = next.fileElement;
                Intrinsics.checkNotNullExpressionValue(fileElement, "elem.fileElement");
                z16 = vp0.b.e(fileElement);
                str = next.fileElement.filePath;
                Intrinsics.checkNotNullExpressionValue(str, "elem.fileElement.filePath");
                String str2 = next.fileElement.fileName;
                Intrinsics.checkNotNullExpressionValue(str2, "elem.fileElement.fileName");
                if (vp0.b.d(str2) == 2) {
                    z17 = true;
                }
            }
        }
        if (z16 && !FileUtils.fileExistsAndNotEmpty(str)) {
            String string = MobileQQ.sMobileQQ.getString(R.string.f145830sj);
            Intrinsics.checkNotNullExpressionValue(string, "sMobileQQ.getString(R.string.guild_file_overtime)");
            QQToast.makeText(((com.tencent.aio.api.runtime.a) getMContext()).c().getActivity(), 1, string, 1).show();
            return;
        }
        if (!z18) {
            String string2 = MobileQQ.sMobileQQ.getString(R.string.f145820si);
            Intrinsics.checkNotNullExpressionValue(string2, "sMobileQQ.getString(R.string.guild_file_invalid)");
            QQToast.makeText(((com.tencent.aio.api.runtime.a) getMContext()).c().getActivity(), 1, string2, 1).show();
            return;
        }
        if (z17) {
            AppRuntime app = MobileQQ.sMobileQQ.peekAppRuntime();
            IGuildRichMediaBrowserApi iGuildRichMediaBrowserApi = (IGuildRichMediaBrowserApi) QRoute.api(IGuildRichMediaBrowserApi.class);
            Intrinsics.checkNotNullExpressionValue(app, "app");
            Context context = imageView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "imageView.context");
            if (cVar != null) {
                list2 = cVar.a();
            } else {
                list2 = null;
            }
            iGuildRichMediaBrowserApi.enterVideoPreview(app, context, msgRecord, imageView, 0L, false, false, null, list2);
            return;
        }
        AppRuntime app2 = MobileQQ.sMobileQQ.peekAppRuntime();
        IGuildRichMediaBrowserApi iGuildRichMediaBrowserApi2 = (IGuildRichMediaBrowserApi) QRoute.api(IGuildRichMediaBrowserApi.class);
        Intrinsics.checkNotNullExpressionValue(app2, "app");
        Context context2 = imageView.getContext();
        if (cVar != null) {
            list = cVar.a();
        } else {
            list = null;
        }
        iGuildRichMediaBrowserApi2.enterImagePreview(app2, context2, null, msgRecord, picElement, false, null, list);
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.t, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void handleIntent(@NotNull ol3.b intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.j) {
            a.j jVar = (a.j) intent;
            l(jVar.getMsgRecord(), jVar.getPicElement(), jVar.getClickedView());
        } else {
            super.handleIntent(intent);
        }
    }
}

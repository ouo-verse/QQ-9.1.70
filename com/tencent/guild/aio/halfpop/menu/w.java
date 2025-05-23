package com.tencent.guild.aio.halfpop.menu;

import android.content.Context;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.factory.business.holder.msglist.i;
import com.tencent.guild.aio.halfpop.menu.t;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.richmediabrowser.IGuildRichMediaBrowserApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\t\b\u0016\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/guild/aio/halfpop/menu/w;", "Lcom/tencent/guild/aio/halfpop/menu/t;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "", "H", "I", "", "tipResId", "", "J", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "data", "t", "Landroid/view/View;", "view", UserInfo.SEX_FEMALE, "<init>", "()V", "g", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class w extends t {
    public w() {
        super(new t.ItemData(R.drawable.qui_voice_mute, R.string.f16495278));
    }

    private final boolean H(MsgRecord msgRecord) {
        Iterator<MsgElement> it = msgRecord.elements.iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            MsgElement next = it.next();
            if (next.elementType == 3) {
                String str = next.fileElement.fileName;
                Intrinsics.checkNotNullExpressionValue(str, "elem.fileElement.fileName");
                if (vp0.b.d(str) == 2) {
                    z16 = true;
                }
            }
        }
        return z16;
    }

    private final boolean I(MsgRecord msgRecord) {
        if (!H(msgRecord)) {
            QLog.i("MutePlayMenuItem", 1, "isVideoFileAndInvalid not video File");
            return false;
        }
        Iterator<MsgElement> it = msgRecord.elements.iterator();
        String str = "";
        boolean z16 = false;
        boolean z17 = false;
        while (it.hasNext()) {
            MsgElement next = it.next();
            if (next.elementType == 3) {
                Integer num = next.fileElement.invalidState;
                if (num != null && num.intValue() == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                FileElement fileElement = next.fileElement;
                Intrinsics.checkNotNullExpressionValue(fileElement, "elem.fileElement");
                z16 = vp0.b.e(fileElement);
                str = next.fileElement.filePath;
                Intrinsics.checkNotNullExpressionValue(str, "elem.fileElement.filePath");
            }
        }
        if (z16 && !FileUtils.fileExistsAndNotEmpty(str)) {
            J(R.string.f145830sj);
            return true;
        }
        if (z17) {
            return false;
        }
        J(R.string.f145820si);
        return true;
    }

    private final void J(int tipResId) {
        Context v3 = v();
        if (v3 != null) {
            String string = MobileQQ.sMobileQQ.getString(tipResId);
            Intrinsics.checkNotNullExpressionValue(string, "sMobileQQ.getString(tipResId)");
            QQToast.makeText(v3, 1, string, 1).show();
        }
    }

    @Override // com.tencent.guild.aio.halfpop.menu.a, com.tencent.guild.aio.halfpop.menu.b, com.tencent.guild.aio.halfpop.menu.n
    /* renamed from: F */
    public void b(@NotNull View view, @NotNull GuildMsgItem data) {
        i.c cVar;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(data, "data");
        super.b(view, data);
        if (I(data.getMsgRecord())) {
            QLog.i("MutePlayMenuItem", 1, "isVideoFileAndInvalid");
            return;
        }
        com.tencent.mvi.base.route.k k3 = h().e().k(new GuildMsgListIntent.GetAIORichMediaMsgListEvent(data.getMsgRecord()));
        List<MsgRecord> list = null;
        if (k3 instanceof i.c) {
            cVar = (i.c) k3;
        } else {
            cVar = null;
        }
        AppRuntime app = MobileQQ.sMobileQQ.peekAppRuntime();
        IGuildRichMediaBrowserApi iGuildRichMediaBrowserApi = (IGuildRichMediaBrowserApi) QRoute.api(IGuildRichMediaBrowserApi.class);
        Intrinsics.checkNotNullExpressionValue(app, "app");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        MsgRecord msgRecord = data.getMsgRecord();
        if (cVar != null) {
            list = cVar.a();
        }
        iGuildRichMediaBrowserApi.enterVideoPreview(app, context, msgRecord, null, 0L, true, false, null, list);
    }

    @Override // com.tencent.guild.aio.halfpop.menu.t, com.tencent.guild.aio.halfpop.menu.b, com.tencent.guild.aio.halfpop.menu.n
    /* renamed from: t */
    public boolean a(@NotNull GuildMsgItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (qr0.d.p(data)) {
            QLog.i("MutePlayMenuItem", 1, "isVideoMsg");
            return true;
        }
        if (qr0.d.q(data)) {
            QLog.i("MutePlayMenuItem", 1, "isVideoMsgOnly");
            return true;
        }
        if (H(data.getMsgRecord())) {
            QLog.i("MutePlayMenuItem", 1, "isVideoFile");
            return true;
        }
        return false;
    }
}

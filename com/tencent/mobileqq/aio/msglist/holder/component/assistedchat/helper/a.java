package com.tencent.mobileqq.aio.msglist.holder.component.assistedchat.helper;

import android.util.Base64;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.assistedchat.pb.AssistedChatExtDataPB$MessageExtData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqnt.aio.assistedchat.adapter.IAssistedChatAdapterApi;
import com.tencent.qqnt.aio.assistedchat.api.IAssistedChatApi;
import com.tencent.qqnt.kernel.nativeinterface.AdelieRecommendedMsgElement;
import com.tencent.qqnt.kernel.nativeinterface.InlineKeyboardButton;
import com.tencent.qqnt.kernel.nativeinterface.InlineKeyboardRow;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.robot.api.IRobotServiceApi;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\"\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/assistedchat/helper/a;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/InlineKeyboardButton;", "buttonInfo", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "c", "a", "", "event", "", "e", "Lcom/tencent/mobileqq/aio/msglist/holder/component/assistedchat/pb/AssistedChatExtDataPB$MessageExtData;", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/AdelieRecommendedMsgElement;", DTConstants.TAG.ELEMENT, "b", "f", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f190696a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60084);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f190696a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean a(AIOMsgItem msgItem) {
        String str;
        MsgRecord msgRecord;
        IRobotServiceApi iRobotServiceApi = (IRobotServiceApi) QRoute.api(IRobotServiceApi.class);
        if (msgItem != null && (msgRecord = msgItem.getMsgRecord()) != null) {
            str = Long.valueOf(msgRecord.senderUin).toString();
        } else {
            str = null;
        }
        return iRobotServiceApi.isRobotUin(str);
    }

    private final boolean c(InlineKeyboardButton buttonInfo, AIOMsgItem msgItem) {
        AssistedChatExtDataPB$MessageExtData d16 = d(buttonInfo);
        if (d16 == null || d16.scene.get() != 8) {
            return false;
        }
        return !((IAssistedChatAdapterApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAssistedChatAdapterApi.class)).isReplySuggestionExperiment(msgItem.p0());
    }

    private final AssistedChatExtDataPB$MessageExtData d(InlineKeyboardButton buttonInfo) {
        if (buttonInfo.data == null) {
            return null;
        }
        try {
            AssistedChatExtDataPB$MessageExtData assistedChatExtDataPB$MessageExtData = new AssistedChatExtDataPB$MessageExtData();
            assistedChatExtDataPB$MessageExtData.mergeFrom(Base64.decode(buttonInfo.data, 0));
            return assistedChatExtDataPB$MessageExtData;
        } catch (Exception e16) {
            QLog.e("AssistedChatExtDataHelper", 1, "parseExtData mergeFrom error " + e16);
            return null;
        }
    }

    private final void e(InlineKeyboardButton buttonInfo, AIOMsgItem msgItem, int event) {
        int i3;
        String str;
        AssistedChatExtDataPB$MessageExtData d16 = d(buttonInfo);
        if (d16 == null) {
            return;
        }
        int i16 = d16.scene.get();
        if (msgItem != null) {
            i3 = msgItem.p0();
        } else {
            i3 = 0;
        }
        int i17 = i3;
        if (msgItem == null || (str = msgItem.r0()) == null) {
            str = "";
        }
        String str2 = str;
        QRouteApi api = QRoute.api(IAssistedChatApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAssistedChatApi::class.java)");
        IAssistedChatApi.a.a((IAssistedChatApi) api, i17, str2, i16, event, null, 16, null);
    }

    public final boolean b(@NotNull AdelieRecommendedMsgElement element, @NotNull AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) element, (Object) msgItem)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(element, "element");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (element.rows.isEmpty()) {
            return false;
        }
        ArrayList<InlineKeyboardRow> arrayList = element.rows;
        Intrinsics.checkNotNullExpressionValue(arrayList, "element.rows");
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            ArrayList<InlineKeyboardButton> arrayList2 = ((InlineKeyboardRow) it.next()).buttons;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "row.buttons");
            for (InlineKeyboardButton buttonInfo : arrayList2) {
                a aVar = f190696a;
                Intrinsics.checkNotNullExpressionValue(buttonInfo, "buttonInfo");
                if (aVar.c(buttonInfo, msgItem)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void f(@NotNull InlineKeyboardButton buttonInfo, @Nullable AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) buttonInfo, (Object) msgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(buttonInfo, "buttonInfo");
        if (a(msgItem)) {
            return;
        }
        try {
            e(buttonInfo, msgItem, 1);
        } catch (IllegalArgumentException e16) {
            QLog.e("AssistedChatExtDataHelper", 1, "reportToServiceClick error " + e16);
        }
    }
}

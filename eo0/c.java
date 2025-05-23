package eo0;

import android.content.Context;
import androidx.annotation.StringRes;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.util.y;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProTopMsg;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.TaskTopMsgElement;
import com.tencent.qqnt.msg.MsgExtKt;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import tl.h;
import vh2.cc;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u00a2\u0006\u0004\b \u0010!J\u001a\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\u0016\u0010\u0013\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011J\u0018\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u0002J\u000e\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0014J\u001e\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011J\u0016\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Leo0/c;", "", "", "stringRes", "", "showAnnounce", "", h.F, "channelId", "j", "content", "", "o", "result", "i", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "g", "", "msgSeqId", "c", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msg", "updateType", "l", "d", "guildId", "e", "k", "Landroid/content/Context;", "a", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    public c(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(c this$0, String channelId, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(channelId, "$channelId");
        QLog.i("SetChosenActionItem", 1, "cancelChannelTopMsg rsp result=" + i3 + " msg=" + str);
        this$0.i(i3, this$0.j(channelId));
    }

    private final IGPSService g() {
        AppInterface appInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        }
        return (IGPSService) iRuntimeService;
    }

    private final String h(@StringRes int stringRes, boolean showAnnounce) {
        String replace$default;
        if (showAnnounce) {
            String string = this.context.getString(stringRes);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(stringRes)");
            replace$default = StringsKt__StringsJVMKt.replace$default(string, "\u7cbe\u534e", "\u516c\u544a", false, 4, (Object) null);
            return replace$default;
        }
        String string2 = this.context.getString(stringRes);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(stringRes)");
        return string2;
    }

    private final void i(int result, boolean showAnnounce) {
        if (y.b(result)) {
            QQToast.makeText(this.context, 2, h(R.string.f157891o5, showAnnounce), 0).show();
        } else {
            QQToast.makeText(this.context, 1, h(R.string.f153131b_, showAnnounce), 0).show();
        }
    }

    private final boolean j(String channelId) {
        Integer num;
        IGProChannelInfo channelInfo;
        IGPSService g16 = g();
        if (g16 != null && (channelInfo = g16.getChannelInfo(channelId)) != null) {
            num = Integer.valueOf(channelInfo.getType());
        } else {
            num = null;
        }
        if ((num == null || num.intValue() != 5) && (num == null || num.intValue() != 2)) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ void m(c cVar, GuildMsgItem guildMsgItem, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        cVar.l(guildMsgItem, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(c this$0, GuildMsgItem msg2, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        QLog.i("SetChosenActionItem", 1, "setChannelTopMsg rsp result=" + i3 + " msg=" + str);
        String str2 = msg2.getMsgRecord().channelId;
        Intrinsics.checkNotNullExpressionValue(str2, "msg.msgRecord.channelId");
        this$0.k(i3, this$0.j(str2));
    }

    private final void o(String content) {
        QQToast.makeText(this.context, content, 0).show();
    }

    public final boolean c(@NotNull String channelId, long msgSeqId) {
        IGProChannelInfo channelInfo;
        ArrayList<IGProTopMsg> topMsgList;
        boolean z16;
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        IGPSService g16 = g();
        if (g16 == null || (channelInfo = g16.getChannelInfo(channelId)) == null || (topMsgList = channelInfo.getTopMsgList()) == null || topMsgList.isEmpty()) {
            return false;
        }
        Iterator<T> it = topMsgList.iterator();
        while (it.hasNext()) {
            if (((IGProTopMsg) it.next()).getTopMsgSeq() == msgSeqId) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return true;
            }
        }
        return false;
    }

    public final void d(@NotNull GuildMsgItem msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        String str = msg2.getMsgRecord().guildId;
        Intrinsics.checkNotNullExpressionValue(str, "msg.msgRecord.guildId");
        String str2 = msg2.getMsgRecord().channelId;
        Intrinsics.checkNotNullExpressionValue(str2, "msg.msgRecord.channelId");
        e(str, str2, msg2.getMsgSeq());
    }

    public final void e(@NotNull String guildId, @NotNull final String channelId, long msgSeqId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.valueOf(msgSeqId));
        QLog.i("SetChosenActionItem", 1, "cancelChosenInner msgSeqId=" + msgSeqId);
        IGPSService g16 = g();
        if (g16 != null) {
            g16.cancelChannelTopMsg(guildId, channelId, arrayList, new cc() { // from class: eo0.a
                @Override // vh2.cc
                public final void onResult(int i3, String str) {
                    c.f(c.this, channelId, i3, str);
                }
            });
        }
    }

    public final void k(int result, boolean showAnnounce) {
        int i3;
        if (y.b(result)) {
            if (showAnnounce) {
                QQToast.makeText(this.context, 2, R.string.f141100fr, 0).show();
                return;
            }
            return;
        }
        if (result != 1002 && result != 1013) {
            switch (result) {
                case 62002:
                    i3 = R.string.f153091b6;
                    break;
                case 62003:
                    i3 = R.string.f153081b5;
                    break;
                case 62004:
                    i3 = R.string.f153071b4;
                    break;
                default:
                    i3 = R.string.f153121b9;
                    break;
            }
        } else {
            i3 = R.string.f153111b8;
        }
        o(h(i3, showAnnounce));
    }

    public final void l(@NotNull final GuildMsgItem msg2, int updateType) {
        int i3;
        TaskTopMsgElement taskTopMsgElement;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        QLog.i("SetChosenActionItem", 1, "enableToChosenMsg msgSeqId=" + msg2.getMsgSeq() + " isRoamMsg=" + MsgExtKt.R(msg2.getMsgRecord()));
        if (!MsgExtKt.R(msg2.getMsgRecord())) {
            QQToast.makeText(this.context, "\u8be5\u6761\u6d88\u606f\u6682\u4e0d\u652f\u6301\u8bbe\u7f6e\u4e3a\u516c\u544a", 1).show();
            return;
        }
        ArrayList<MsgElement> arrayList = msg2.getMsgRecord().elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msg.msgRecord.elements");
        Iterator<T> it = arrayList.iterator();
        int i16 = 0;
        loop0: while (true) {
            i3 = i16;
            while (it.hasNext()) {
                taskTopMsgElement = ((MsgElement) it.next()).taskTopMsgElement;
                if (taskTopMsgElement != null) {
                    break;
                }
            }
            i16 = taskTopMsgElement.topMsgType;
        }
        IGPSService g16 = g();
        if (g16 != null) {
            g16.setChannelTopMsg(msg2.getMsgRecord().guildId, msg2.getMsgRecord().channelId, msg2.getMsgSeq(), updateType, i3, new cc() { // from class: eo0.b
                @Override // vh2.cc
                public final void onResult(int i17, String str) {
                    c.n(c.this, msg2, i17, str);
                }
            });
        }
    }
}

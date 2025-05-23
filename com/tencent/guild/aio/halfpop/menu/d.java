package com.tencent.guild.aio.halfpop.menu;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.guild.aio.halfpop.menu.t;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.emoji.IGuildEmojiApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/guild/aio/halfpop/menu/d;", "Lcom/tencent/guild/aio/halfpop/menu/t;", "Landroid/content/Context;", "context", "", "text", "", "H", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msg", "I", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "data", "", "t", "Landroid/view/View;", "view", UserInfo.SEX_FEMALE, "Lcom/tencent/guild/aio/halfpop/menu/t$a;", "itemData", "<init>", "(Lcom/tencent/guild/aio/halfpop/menu/t$a;)V", "g", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class d extends t {
    public d() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final void H(Context context, CharSequence text) {
        Object systemService = context.getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ClipboardMonitor.setPrimaryClip((ClipboardManager) systemService, ClipData.newPlainText(null, text));
    }

    private final CharSequence I(MsgRecord msg2) {
        List filterNotNull;
        ArrayList<MsgElement> arrayList = new ArrayList<>();
        ArrayList<MsgElement> elements = msg2.elements;
        if (elements != null) {
            Intrinsics.checkNotNullExpressionValue(elements, "elements");
            filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(elements);
            if (filterNotNull != null) {
                Iterator it = filterNotNull.iterator();
                while (it.hasNext()) {
                    arrayList.add((MsgElement) it.next());
                }
            }
        }
        return ((IGuildEmojiApi) QRoute.api(IGuildEmojiApi.class)).parseEmotionText(arrayList);
    }

    @Override // com.tencent.guild.aio.halfpop.menu.a, com.tencent.guild.aio.halfpop.menu.b, com.tencent.guild.aio.halfpop.menu.n
    /* renamed from: F */
    public void b(@NotNull View view, @NotNull GuildMsgItem data) {
        String str;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(data, "data");
        QLog.i("CopyActionItem", 4, "onItemClick type=" + data.getViewType());
        if (data.isMixMsg()) {
            str = zp0.b.f452962a.l(data);
        } else {
            CharSequence I = I(data.getMsgRecord());
            Intrinsics.checkNotNull(I, "null cannot be cast to non-null type kotlin.String");
            str = (String) I;
        }
        QLog.i("CopyActionItem", 1, "onItemClick content=" + str);
        if (!TextUtils.isEmpty(str)) {
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            H(context, str);
        }
        j().o8();
    }

    @Override // com.tencent.guild.aio.halfpop.menu.t, com.tencent.guild.aio.halfpop.menu.b, com.tencent.guild.aio.halfpop.menu.n
    /* renamed from: t */
    public boolean a(@NotNull GuildMsgItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (qr0.d.o(data)) {
            QLog.i("CopyActionItem", 1, "isTextMsg msgId : " + data.getMsgRecord().msgId);
            return true;
        }
        if (qr0.d.n(data)) {
            QLog.i("CopyActionItem", 1, "isReplyMsg msgId : " + data.getMsgRecord().msgId);
            return true;
        }
        if (qr0.d.j(data)) {
            QLog.i("CopyActionItem", 1, "isMixMsgAndContainTxtElement msgId : " + data.getMsgRecord().msgId);
            return true;
        }
        if (qr0.d.h(data)) {
            QLog.i("CopyActionItem", 1, "isMKDMsg msgId : " + data.getMsgRecord().msgId);
            return true;
        }
        return false;
    }

    public /* synthetic */ d(t.ItemData itemData, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new t.ItemData(R.drawable.qui_copy, R.string.f16487270) : itemData);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull t.ItemData itemData) {
        super(itemData);
        Intrinsics.checkNotNullParameter(itemData, "itemData");
    }
}

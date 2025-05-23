package com.tencent.guild.aio.msglist.holder.component.mix;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import com.tencent.aio.data.AIOParam;
import com.tencent.guild.aio.msglist.text.util.BubbleTextViewUtil;
import com.tencent.guild.aio.msglist.text.util.f;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.msg.IGuildMsgElementApi;
import com.tencent.mobileqq.qqemoticon.api.ITextUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wq0.l;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\rB\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/component/mix/a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "Lwq0/l;", "tv", "Lcom/tencent/guild/aio/msglist/holder/component/mix/a$a;", "callback", "", "b", "Landroid/widget/LinearLayout;", "a", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f111557a = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/component/mix/a$a;", "", "Lcom/tencent/aio/api/runtime/a;", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.msglist.holder.component.mix.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC1201a {
        @Nullable
        com.tencent.aio.api.runtime.a a();
    }

    a() {
    }

    @NotNull
    public final LinearLayout a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        return linearLayout;
    }

    public final void b(@NotNull Context context, @NotNull GuildMsgItem msgItem, @NotNull l tv5, @NotNull InterfaceC1201a callback) {
        Context context2;
        AIOParam aIOParam;
        Fragment c16;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(tv5, "tv");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ArrayList<MsgElement> arrayList = msgItem.getMsgRecord().elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgItem.msgRecord.elements");
        ArrayList<MsgElement> arrayList2 = new ArrayList<>();
        Iterator<MsgElement> it = arrayList.iterator();
        while (it.hasNext()) {
            MsgElement element = it.next();
            IGuildMsgElementApi iGuildMsgElementApi = (IGuildMsgElementApi) QRoute.api(IGuildMsgElementApi.class);
            Intrinsics.checkNotNullExpressionValue(element, "element");
            if (iGuildMsgElementApi.isTextElem(element)) {
                arrayList2.add(element);
            }
        }
        if (arrayList2.size() <= 0) {
            tv5.getView().setVisibility(8);
            return;
        }
        com.tencent.aio.api.runtime.a a16 = callback.a();
        f fVar = f.f111944a;
        tv5.setTextColor(fVar.g(context));
        tv5.setLinkTextColor(fVar.d(context));
        BubbleTextViewUtil bubbleTextViewUtil = BubbleTextViewUtil.f111916a;
        AIOParam aIOParam2 = null;
        if (a16 != null && (c16 = a16.c()) != null) {
            context2 = c16.getContext();
        } else {
            context2 = null;
        }
        if (a16 != null) {
            aIOParam = a16.g();
        } else {
            aIOParam = null;
        }
        SpannableStringBuilder j3 = bubbleTextViewUtil.j(msgItem, tv5, arrayList2, context2, aIOParam);
        if (a16 != null) {
            aIOParam2 = a16.g();
        }
        tv5.f(j3, bubbleTextViewUtil.i(msgItem, aIOParam2));
        tv5.getView().setContentDescription(((ITextUtilsApi) QRoute.api(ITextUtilsApi.class)).emoticonToTextForTalkBack(j3.toString()));
        if (!bubbleTextViewUtil.p()) {
            tv5.k();
        }
        tv5.getView().setVisibility(0);
    }
}

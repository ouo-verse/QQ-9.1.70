package ao0;

import android.content.Context;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.method.MovementMethod;
import com.tencent.aio.data.AIOParam;
import com.tencent.guild.aio.msglist.text.util.BubbleTextViewUtil;
import com.tencent.guild.aio.msglist.text.util.TextBubbleContentParser;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wq0.j;
import wq0.l;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018JJ\u0010\u000f\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J:\u0010\u0011\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016\u00a8\u0006\u0019"}, d2 = {"Lao0/e;", "Lao0/f;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "Lkotlin/collections/ArrayList;", "elemList", "Landroid/content/Context;", "context", "Lcom/tencent/aio/data/AIOParam;", "aioParam", "Lkotlin/Pair;", "Landroid/text/SpannableStringBuilder;", "Landroid/text/method/MovementMethod;", "d", "", "c", "", "a", "b", "", "getTag", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class e implements f {
    private final void c(Context context, AIOParam aioParam, GuildMsgItem msgItem, ArrayList<MsgElement> elemList) {
        Integer d16 = com.tencent.guild.aio.util.a.d(aioParam);
        if (d16 != null && d16.intValue() == 1 && j.f446044a.f() && context != null) {
            BubbleTextViewUtil bubbleTextViewUtil = BubbleTextViewUtil.f111916a;
            l e16 = bubbleTextViewUtil.e(context, true);
            bubbleTextViewUtil.r(context, aioParam, e16, msgItem, elemList);
            ArrayList<Object> arrayList = new ArrayList<>();
            for (Integer width : bubbleTextViewUtil.k().keySet()) {
                Intrinsics.checkNotNullExpressionValue(width, "width");
                Pair<com.tencent.aio.widget.textView.param.b, Layout> g16 = e16.g(width.intValue());
                if (g16 != null) {
                    arrayList.add(g16);
                }
            }
            if (!arrayList.isEmpty()) {
                msgItem.getPreParseInfo().q(arrayList);
            }
        }
    }

    private final Pair<SpannableStringBuilder, MovementMethod> d(GuildMsgItem msgItem, ArrayList<MsgElement> elemList, Context context, AIOParam aioParam) {
        if (context != null) {
            TextBubbleContentParser textBubbleContentParser = TextBubbleContentParser.f111932a;
            MsgRecord msgRecord = msgItem.getMsgRecord();
            bq0.e eVar = bq0.e.f28951a;
            boolean j3 = textBubbleContentParser.j(msgItem);
            BubbleTextViewUtil bubbleTextViewUtil = BubbleTextViewUtil.f111916a;
            return TextBubbleContentParser.i(textBubbleContentParser, context, msgRecord, elemList, eVar.h(j3, true, bubbleTextViewUtil.q(msgItem), 17.0f, 17.0f), aioParam, 0, textBubbleContentParser.j(msgItem), bubbleTextViewUtil.l(msgItem), 32, null);
        }
        return new Pair<>(null, null);
    }

    @Override // ao0.f
    public boolean a(@NotNull GuildMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (!BubbleTextViewUtil.f111916a.p()) {
            return false;
        }
        if (!qr0.d.o(msgItem) && !qr0.d.n(msgItem) && !qr0.d.j(msgItem)) {
            return false;
        }
        return true;
    }

    @Override // ao0.f
    public void b(@NotNull GuildMsgItem msgItem, @Nullable Context context, @NotNull AIOParam aioParam) {
        List filterNotNull;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(aioParam, "aioParam");
        ArrayList<MsgElement> arrayList = new ArrayList<>();
        ArrayList<MsgElement> elements = msgItem.getMsgRecord().elements;
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
        Pair<SpannableStringBuilder, MovementMethod> d16 = d(msgItem, arrayList, context, aioParam);
        msgItem.getPreParseInfo().p(d16.getFirst());
        msgItem.getPreParseInfo().r(d16.getSecond());
        if (d16.getFirst() != null) {
            c(context, aioParam, msgItem, arrayList);
        }
    }

    @Override // ao0.f
    @NotNull
    public String getTag() {
        return "GuildMsgTextPreParser";
    }
}

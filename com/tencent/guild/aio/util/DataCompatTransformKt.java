package com.tencent.guild.aio.util;

import com.tencent.guild.api.emoji.IGuildEmojiApi;
import com.tencent.guild.api.pic.IGuildPicApi;
import com.tencent.guild.api.video.IGuildVideoApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.TaskTopMsgElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\u001a(\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u0012\u0012\u0004\u0012\u00020\u00010\u0000j\b\u0012\u0004\u0012\u00020\u0001`\u00022\u0006\u0010\u0004\u001a\u00020\u0003\u001a(\u0010\f\u001a\u00020\u000b2\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0000j\b\u0012\u0004\u0012\u00020\u0006`\u00022\u0006\u0010\n\u001a\u00020\tH\u0002\u001a\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0001H\u0002\u001a\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u0001H\u0002\u001a\"\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u00112\u0006\u0010\r\u001a\u00020\u0001H\u0002\u001a \u0010\u0014\u001a\u00020\u000b*\b\u0012\u0004\u0012\u00020\t0\u00052\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005\u001a\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u0001H\u0002\u00a8\u0006\u0017"}, d2 = {"Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "Lkotlin/collections/ArrayList;", "", "topMsgType", "", "Lcom/tencent/guild/aio/reserve2/busi/chosen/a;", tl.h.F, "list", "", "msgSeq", "", "b", "msg", "e", "", "f", "Lkotlin/Triple;", "d", "data", "c", "", "g", "aio-guild_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class DataCompatTransformKt {
    private static final boolean b(ArrayList<com.tencent.guild.aio.reserve2.busi.chosen.a> arrayList, long j3) {
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            if (((com.tencent.guild.aio.reserve2.busi.chosen.a) it.next()).getMsg().msgSeq == j3) {
                return true;
            }
        }
        return false;
    }

    public static final boolean c(@NotNull List<Long> list, @Nullable List<Long> list2) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        boolean z16 = false;
        if (list2 != null && list.size() == list2.size()) {
            z16 = true;
        }
        if (!z16) {
            return true;
        }
        return !list.containsAll(list2);
    }

    private static final Triple<String, String, String> d(MsgRecord msgRecord) {
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msg.elements");
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            TaskTopMsgElement taskTopMsgElement = ((MsgElement) it.next()).taskTopMsgElement;
            if (taskTopMsgElement != null) {
                return new Triple<>(taskTopMsgElement.msgTitle, taskTopMsgElement.msgSummary, taskTopMsgElement.iconUrl);
            }
        }
        return new Triple<>("", "", "");
    }

    private static final int e(MsgRecord msgRecord) {
        boolean z16;
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msg.elements");
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((MsgElement) obj).picElement != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList2.add(obj);
            }
        }
        return arrayList2.size();
    }

    private static final String f(MsgRecord msgRecord) {
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msg.elements");
        for (MsgElement it : arrayList) {
            if (it.picElement != null) {
                IGuildPicApi iGuildPicApi = (IGuildPicApi) QRoute.api(IGuildPicApi.class);
                Intrinsics.checkNotNullExpressionValue(it, "it");
                return iGuildPicApi.getThumbImagePath720(it);
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence g(MsgRecord msgRecord) {
        List filterNotNull;
        ArrayList<MsgElement> arrayList = new ArrayList<>();
        ArrayList<MsgElement> elements = msgRecord.elements;
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
        return ((IGuildEmojiApi) QRoute.api(IGuildEmojiApi.class)).parseMsgElementToChosenStr(arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [T, java.lang.Object, java.lang.String] */
    @NotNull
    public static final List<com.tencent.guild.aio.reserve2.busi.chosen.a> h(@NotNull ArrayList<MsgRecord> arrayList, int i3) {
        boolean z16;
        boolean z17;
        boolean isBlank;
        boolean z18;
        boolean z19;
        boolean z26;
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        ArrayList arrayList2 = new ArrayList();
        for (final MsgRecord msgRecord : arrayList) {
            if (!b(arrayList2, msgRecord.msgSeq)) {
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = "";
                final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                ?? string = MobileQQ.sMobileQQ.getString(R.string.f157881o4);
                Intrinsics.checkNotNullExpressionValue(string, "sMobileQQ.getString(R.string.guild_top_msg)");
                objectRef2.element = string;
                final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
                objectRef3.element = "";
                int i16 = 0;
                if (i3 == 1) {
                    final Triple<String, String, String> d16 = d(msgRecord);
                    if (d16.getFirst().length() > 0) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    com.tencent.guild.aio.util.ex.g.b(Boolean.valueOf(z18), new Function0<Unit>() { // from class: com.tencent.guild.aio.util.DataCompatTransformKt$tranToTargetType$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Object] */
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            objectRef2.element = d16.getFirst();
                        }
                    });
                    if (d16.getSecond().length() > 0) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    com.tencent.guild.aio.util.ex.g.b(Boolean.valueOf(z19), new Function0<Unit>() { // from class: com.tencent.guild.aio.util.DataCompatTransformKt$tranToTargetType$1$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Object] */
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            objectRef3.element = d16.getSecond();
                        }
                    });
                    if (d16.getThird().length() > 0) {
                        z26 = true;
                    } else {
                        z26 = false;
                    }
                    com.tencent.guild.aio.util.ex.g.b(Boolean.valueOf(z26), new Function0<Unit>() { // from class: com.tencent.guild.aio.util.DataCompatTransformKt$tranToTargetType$1$3
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Object] */
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            objectRef.element = d16.getThird();
                        }
                    });
                }
                if (((CharSequence) objectRef3.element).length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                com.tencent.guild.aio.util.ex.g.b(Boolean.valueOf(z16), new Function0<Unit>() { // from class: com.tencent.guild.aio.util.DataCompatTransformKt$tranToTargetType$1$4
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.CharSequence, T] */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        ?? g16;
                        Ref.ObjectRef<CharSequence> objectRef4 = objectRef3;
                        g16 = DataCompatTransformKt.g(msgRecord);
                        objectRef4.element = g16;
                    }
                });
                QRouteApi api = QRoute.api(IGuildVideoApi.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(IGuildVideoApi::class.java)");
                String c16 = IGuildVideoApi.a.c((IGuildVideoApi) api, msgRecord, false, 2, null);
                String f16 = f(msgRecord);
                if (c16.length() == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    isBlank = StringsKt__StringsJVMKt.isBlank(f16);
                    if (true ^ isBlank) {
                        i16 = e(msgRecord);
                    }
                }
                arrayList2.add(new com.tencent.guild.aio.reserve2.busi.chosen.a((String) objectRef2.element, (CharSequence) objectRef3.element, (String) objectRef.element, f16, i16, c16, msgRecord));
            }
        }
        return arrayList2;
    }
}

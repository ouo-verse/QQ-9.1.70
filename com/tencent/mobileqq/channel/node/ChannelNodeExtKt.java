package com.tencent.mobileqq.channel.node;

import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.kernelpublic.nativeinterface.ChannelStateElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstractElement;
import ex3.a;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\f\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0003*\u00020\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/ChannelStateElement;", "getChannelStateElement", "", "isLiveChannel", "isAudioChannel", "qqchat_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class ChannelNodeExtKt {
    @Nullable
    public static final ChannelStateElement getChannelStateElement(@NotNull g gVar) {
        boolean z16;
        Intrinsics.checkNotNullParameter(gVar, "<this>");
        ArrayList<MsgAbstractElement> arrayList = gVar.s().abstractContent;
        if (arrayList != null && !arrayList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        Iterator<MsgAbstractElement> it = arrayList.iterator();
        while (it.hasNext()) {
            ChannelStateElement channelStateElement = it.next().channelStateElement;
            if (channelStateElement != null) {
                return channelStateElement;
            }
        }
        return null;
    }

    public static final boolean isAudioChannel(@NotNull g gVar) {
        Intrinsics.checkNotNullParameter(gVar, "<this>");
        if (a.e(gVar.s()) == 2) {
            return true;
        }
        return false;
    }

    public static final boolean isLiveChannel(@NotNull g gVar) {
        Intrinsics.checkNotNullParameter(gVar, "<this>");
        if (a.e(gVar.s()) == 5) {
            return true;
        }
        return false;
    }
}

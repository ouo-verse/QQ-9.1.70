package com.tencent.mobileqq.qqlive.sail;

import com.tencent.mobileqq.qqlive.callback.message.IQQLiveMessageCallback;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData;
import com.tencent.mobileqq.qqlive.login.LiveLoginInfo;
import com.tencent.mobileqq.qqlive.sail.room.l;
import com.tencent.qqlive.common.api.AegisLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rq3.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a&\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u001a<\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00002$\b\u0002\u0010\u0010\u001a\u001e\u0012\b\u0012\u00060\rR\u00020\u000e\u0018\u00010\fj\u000e\u0012\b\u0012\u00060\rR\u00020\u000e\u0018\u0001`\u000f\u001a(\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012*\u001a\u0012\b\u0012\u00060\rR\u00020\u000e0\fj\f\u0012\b\u0012\u00060\rR\u00020\u000e`\u000f\u00a8\u0006\u0015"}, d2 = {"", "tag", "Lcom/tencent/mobileqq/qqlive/sail/room/l;", "Lrq3/g;", "result", "Lcom/tencent/mobileqq/qqlive/callback/message/IQQLiveMessageCallback;", "callback", "", "b", "", "roomId", "message", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData$ExtData;", "Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData;", "Lkotlin/collections/ArrayList;", "exts", "a", "", "Lrq3/b;", "c", "timi-game-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a {
    @NotNull
    public static final LiveMessageData a(long j3, @NotNull String message, @Nullable ArrayList<LiveMessageData.ExtData> arrayList) {
        String str;
        String str2;
        Collection emptyList;
        Intrinsics.checkNotNullParameter(message, "message");
        LiveMessageData liveMessageData = new LiveMessageData();
        int i3 = (int) j3;
        liveMessageData.mMainRoomId = i3;
        liveMessageData.mSubRoomId = i3;
        liveMessageData.mMessageType = 1;
        LiveMessageData.SpeakerInfo speakerInfo = liveMessageData.mSpeakerInfo;
        c cVar = c.f272176a;
        speakerInfo.mSpeakId = cVar.G();
        LiveMessageData.SpeakerInfo speakerInfo2 = liveMessageData.mSpeakerInfo;
        LiveLoginInfo u16 = cVar.u();
        String str3 = null;
        if (u16 != null) {
            str = u16.m();
        } else {
            str = null;
        }
        speakerInfo2.mSpeakerName = str;
        LiveMessageData.SpeakerInfo speakerInfo3 = liveMessageData.mSpeakerInfo;
        LiveLoginInfo u17 = cVar.u();
        if (u17 != null) {
            str2 = u17.k();
        } else {
            str2 = null;
        }
        speakerInfo3.mBusinessUid = str2;
        LiveMessageData.SpeakerInfo speakerInfo4 = liveMessageData.mSpeakerInfo;
        LiveLoginInfo u18 = cVar.u();
        if (u18 != null) {
            str3 = u18.j();
        }
        speakerInfo4.mLogo = str3;
        LiveMessageData.MsgContent msgContent = liveMessageData.msgContent;
        ArrayList<LiveMessageData.MsgElement> arrayList2 = msgContent.mMsgElements;
        LiveMessageData.MsgElement msgElement = new LiveMessageData.MsgElement();
        msgElement.mElementType = 1;
        LiveMessageData.TextElement textElement = new LiveMessageData.TextElement();
        byte[] bytes = message.getBytes(Charsets.UTF_16LE);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        textElement.mText = bytes;
        textElement.strText = message;
        msgElement.mTextMsg = textElement;
        arrayList2.add(msgElement);
        ArrayList<LiveMessageData.ExtData> arrayList3 = msgContent.mExtDatas;
        Collection collection = arrayList;
        if (arrayList == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            collection = emptyList;
        }
        arrayList3.addAll(collection);
        return liveMessageData;
    }

    public static final void b(@NotNull String tag, @NotNull l<g> result, @Nullable IQQLiveMessageCallback iQQLiveMessageCallback) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(result, "result");
        g d16 = result.d();
        if (d16 != null) {
            int i3 = d16.f431954a;
            Unit unit = null;
            if (i3 != 0) {
                if (i3 != 10002) {
                    if (i3 != 10003) {
                        if (iQQLiveMessageCallback != null) {
                            iQQLiveMessageCallback.onFail(i3, d16.f431955b);
                        }
                        AegisLogger.INSTANCE.w(tag, "handleSendMessageResult", "rsp failed, code=" + d16.f431954a + ", msg=" + d16.f431955b);
                        unit = Unit.INSTANCE;
                    } else if (iQQLiveMessageCallback != null) {
                        iQQLiveMessageCallback.onIllegalMsg();
                        unit = Unit.INSTANCE;
                    }
                } else if (iQQLiveMessageCallback != null) {
                    iQQLiveMessageCallback.onUserForbid(d16.f431955b);
                    unit = Unit.INSTANCE;
                }
            } else if (iQQLiveMessageCallback != null) {
                iQQLiveMessageCallback.onSuccess(false);
                unit = Unit.INSTANCE;
            }
            if (unit != null) {
                return;
            }
        }
        AegisLogger.INSTANCE.w(tag, "handleSendMessageResult", "failed, code=" + result.b() + ", msg=" + result.c());
        if (iQQLiveMessageCallback != null) {
            iQQLiveMessageCallback.onFail((int) result.b(), result.c());
            Unit unit2 = Unit.INSTANCE;
        }
    }

    @NotNull
    public static final List<rq3.b> c(@NotNull ArrayList<LiveMessageData.ExtData> arrayList) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        for (LiveMessageData.ExtData extData : arrayList) {
            rq3.b bVar = new rq3.b();
            bVar.f431939a = extData.mId;
            bVar.f431940b = extData.mValue;
            arrayList2.add(bVar);
        }
        return arrayList2;
    }
}

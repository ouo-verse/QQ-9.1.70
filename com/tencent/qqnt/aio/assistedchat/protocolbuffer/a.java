package com.tencent.qqnt.aio.assistedchat.protocolbuffer;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqnt.aio.assistedchat.model.c;
import com.tencent.qqnt.aio.assistedchat.panel.subpanel.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u001a\n\u0010\t\u001a\u00020\b*\u00020\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/protocolbuffer/AssistedChatPB$RecommendRsp;", "", "scene", "", "success", "Lcom/tencent/qqnt/aio/assistedchat/panel/subpanel/d;", "b", "Lcom/tencent/qqnt/aio/assistedchat/protocolbuffer/AssistedChatPB$PromptInfo;", "Lcom/tencent/qqnt/aio/assistedchat/model/a;", "a", "aio_ext_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a {
    @NotNull
    public static final com.tencent.qqnt.aio.assistedchat.model.a a(@NotNull AssistedChatPB$PromptInfo assistedChatPB$PromptInfo) {
        String str;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(assistedChatPB$PromptInfo, "<this>");
        String str4 = assistedChatPB$PromptInfo.prompt_id.get();
        if (str4 == null) {
            str = "";
        } else {
            str = str4;
        }
        String str5 = assistedChatPB$PromptInfo.prompt_name.get();
        if (str5 == null) {
            str2 = "";
        } else {
            str2 = str5;
        }
        String str6 = assistedChatPB$PromptInfo.prompt_content.get();
        if (str6 == null) {
            str3 = "";
        } else {
            str3 = str6;
        }
        return new com.tencent.qqnt.aio.assistedchat.model.a(str, str2, str3, assistedChatPB$PromptInfo.prompt_color.get());
    }

    @NotNull
    public static final d b(@NotNull AssistedChatPB$RecommendRsp assistedChatPB$RecommendRsp, int i3, boolean z16) {
        byte[] serverBinaryData;
        byte[] serverExtData;
        List<Integer> emojiIds;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Intrinsics.checkNotNullParameter(assistedChatPB$RecommendRsp, "<this>");
        ArrayList arrayList = new ArrayList();
        int size = assistedChatPB$RecommendRsp.recommends.size();
        for (int i16 = 0; i16 < size; i16++) {
            AssistedChatPB$Recommend assistedChatPB$Recommend = assistedChatPB$RecommendRsp.recommends.get(i16);
            Intrinsics.checkNotNullExpressionValue(assistedChatPB$Recommend, "this.recommends[i]");
            AssistedChatPB$Recommend assistedChatPB$Recommend2 = assistedChatPB$Recommend;
            AssistedChatPB$PromptInfo assistedChatPB$PromptInfo = assistedChatPB$Recommend2.prompt.get();
            Intrinsics.checkNotNullExpressionValue(assistedChatPB$PromptInfo, "serverRecommend.prompt.get()");
            com.tencent.qqnt.aio.assistedchat.model.a a16 = a(assistedChatPB$PromptInfo);
            PBStringField pBStringField = assistedChatPB$Recommend2.f349417id;
            String str6 = null;
            if (pBStringField != null) {
                str = pBStringField.get();
            } else {
                str = null;
            }
            if (str == null) {
                str2 = "";
            } else {
                str2 = str;
            }
            PBStringField pBStringField2 = assistedChatPB$Recommend2.content;
            if (pBStringField2 != null) {
                str3 = pBStringField2.get();
            } else {
                str3 = null;
            }
            if (str3 == null) {
                str4 = "";
            } else {
                str4 = str3;
            }
            PBStringField pBStringField3 = assistedChatPB$Recommend2.recom_trace;
            if (pBStringField3 != null) {
                str6 = pBStringField3.get();
            }
            if (str6 == null) {
                str5 = "";
            } else {
                str5 = str6;
            }
            arrayList.add(new c(str2, str4, str5, Integer.valueOf(i3), a16));
        }
        if (assistedChatPB$RecommendRsp.binary_data.has()) {
            serverBinaryData = assistedChatPB$RecommendRsp.binary_data.get().toByteArray();
        } else {
            serverBinaryData = new byte[0];
        }
        if (assistedChatPB$RecommendRsp.ext_data.has()) {
            serverExtData = assistedChatPB$RecommendRsp.ext_data.get().toByteArray();
        } else {
            serverExtData = new byte[0];
        }
        if (!assistedChatPB$RecommendRsp.android_small_yellow_face_ids.has()) {
            emojiIds = CollectionsKt__CollectionsKt.emptyList();
        } else {
            emojiIds = assistedChatPB$RecommendRsp.android_small_yellow_face_ids.get();
        }
        String str7 = assistedChatPB$RecommendRsp.guide.get();
        Intrinsics.checkNotNullExpressionValue(str7, "this.guide.get()");
        d dVar = new d(z16, arrayList, str7);
        dVar.p(!assistedChatPB$RecommendRsp.is_end.get());
        Intrinsics.checkNotNullExpressionValue(serverBinaryData, "serverBinaryData");
        dVar.k(serverBinaryData);
        Intrinsics.checkNotNullExpressionValue(serverExtData, "serverExtData");
        dVar.n(serverExtData);
        Intrinsics.checkNotNullExpressionValue(emojiIds, "emojiIds");
        if (!emojiIds.isEmpty()) {
            Integer num = emojiIds.get(0);
            Intrinsics.checkNotNullExpressionValue(num, "emojiIds[0]");
            dVar.m(num.intValue());
        }
        return dVar;
    }

    public static /* synthetic */ d c(AssistedChatPB$RecommendRsp assistedChatPB$RecommendRsp, int i3, boolean z16, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            z16 = true;
        }
        return b(assistedChatPB$RecommendRsp, i3, z16);
    }
}

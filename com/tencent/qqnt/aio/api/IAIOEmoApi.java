package com.tencent.qqnt.aio.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.MsgAttributeInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001JJ\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062(\b\u0002\u0010\u000b\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u0001`\nH&JJ\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062(\b\u0002\u0010\u000b\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u0001`\nH&J \u0010\u0011\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH&JB\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042(\b\u0002\u0010\u000b\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u0001`\nH&J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000fH&\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/aio/api/IAIOEmoApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "qsid", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "peer", "", "isSingleLottie", "Ljava/util/HashMap;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgAttributeInfo;", "Lkotlin/collections/HashMap;", "msgAttrs", "", "sendEmoMsgFromOther", "syncSendEmoMsgFromOther", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "sendEmoMsgFromAIO", "", "searchWord", "sendRandomPicEmotionMsgFromOther", "sendRandomPicEmotionMsgFromAIO", "aio_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {""})
/* loaded from: classes23.dex */
public interface IAIOEmoApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(IAIOEmoApi iAIOEmoApi, int i3, Contact contact, boolean z16, HashMap hashMap, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 8) != 0) {
                    hashMap = null;
                }
                iAIOEmoApi.sendEmoMsgFromOther(i3, contact, z16, hashMap);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendEmoMsgFromOther");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void b(IAIOEmoApi iAIOEmoApi, String str, Contact contact, HashMap hashMap, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    hashMap = null;
                }
                iAIOEmoApi.sendRandomPicEmotionMsgFromOther(str, contact, hashMap);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendRandomPicEmotionMsgFromOther");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void c(IAIOEmoApi iAIOEmoApi, int i3, Contact contact, boolean z16, HashMap hashMap, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 8) != 0) {
                    hashMap = null;
                }
                iAIOEmoApi.syncSendEmoMsgFromOther(i3, contact, z16, hashMap);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: syncSendEmoMsgFromOther");
        }
    }

    void sendEmoMsgFromAIO(int qsid, boolean isSingleLottie, @NotNull com.tencent.aio.api.runtime.a aioContext);

    void sendEmoMsgFromOther(int qsid, @NotNull Contact peer, boolean isSingleLottie, @Nullable HashMap<Integer, MsgAttributeInfo> msgAttrs);

    void sendRandomPicEmotionMsgFromAIO(@NotNull String searchWord, @NotNull com.tencent.aio.api.runtime.a aioContext);

    void sendRandomPicEmotionMsgFromOther(@NotNull String searchWord, @NotNull Contact peer, @Nullable HashMap<Integer, MsgAttributeInfo> msgAttrs);

    void syncSendEmoMsgFromOther(int qsid, @NotNull Contact peer, boolean isSingleLottie, @Nullable HashMap<Integer, MsgAttributeInfo> msgAttrs);
}

package com.tencent.qqnt.emotion.text.style.api;

import com.tencent.mobileqq.emoticonview.ipc.proxy.EmojiManagerServiceProxy;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqnt.emotion.constant.b;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H&J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H&J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H&J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H&J6\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u0002H&J6\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u0002H&J\u0018\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H&J\u0018\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0002H&J\u0018\u0010 \u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0002H&\u00a8\u0006!"}, d2 = {"Lcom/tencent/qqnt/emotion/text/style/api/IEmojiSpanService;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", EmojiManagerServiceProxy.EPID, "eId", "type", "", "parseSmallEmo", "", "content", "index", "", "isValidEmojiFaceId", "serverEmoId", "emojiType", "convertEmoServerIdToEmoCode", "emoCode", "convertEmoCodeToServerId", "faceType", "faceIndex", NodeProps.CUSTOM_PROP_IMAGE_TYPE, "isAnim", "emoSize", "createEmojiSpanText", "createSysAndEmojiSpanText", "serverId", "getFaceDescription", "startIndex", "Lcom/tencent/qqnt/emotion/data/a;", "parseMarketSmallFace", "packId", "faceId", "combineEmoIndex", "emotion_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes24.dex */
public interface IEmojiSpanService extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes24.dex */
    public static final class a {
        public static /* synthetic */ CharSequence a(IEmojiSpanService iEmojiSpanService, int i3, int i16, int i17, boolean z16, int i18, int i19, Object obj) {
            int i26;
            boolean z17;
            if (obj == null) {
                if ((i19 & 4) != 0) {
                    i26 = 0;
                } else {
                    i26 = i17;
                }
                if ((i19 & 8) != 0) {
                    z17 = false;
                } else {
                    z17 = z16;
                }
                if ((i19 & 16) != 0) {
                    i18 = b.b();
                }
                return iEmojiSpanService.createEmojiSpanText(i3, i16, i26, z17, i18);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createEmojiSpanText");
        }
    }

    int combineEmoIndex(int packId, int faceId);

    int convertEmoCodeToServerId(@NotNull String emoCode, int index);

    @NotNull
    String convertEmoServerIdToEmoCode(int serverEmoId, int emojiType);

    @NotNull
    CharSequence createEmojiSpanText(int faceType, int faceIndex, int imageType, boolean isAnim, int emoSize);

    @NotNull
    CharSequence createSysAndEmojiSpanText(int faceType, int faceIndex, int imageType, boolean isAnim, int emoSize);

    @NotNull
    String getFaceDescription(int serverId, int emojiType);

    boolean isValidEmojiFaceId(@NotNull String content, int index);

    @NotNull
    com.tencent.qqnt.emotion.data.a parseMarketSmallFace(@NotNull String content, int startIndex);

    @NotNull
    CharSequence parseSmallEmo(int epId, int eId, int type);
}

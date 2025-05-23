package com.tencent.guild.api.emoji;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.Spannable;
import android.text.style.CharacterStyle;
import android.widget.TextView;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmojiManagerServiceProxy;
import com.tencent.mobileqq.guild.emoj.b;
import com.tencent.mobileqq.guild.emoj.f;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.text.ISpanRefreshCallback;
import com.tencent.qqnt.kernel.nativeinterface.EmojiUseInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\bg\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J \u0010\u0010\u001a\u00020\u000f2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rH&J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH&J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0002H&J \u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0002H&J*\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H&J4\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H&J\"\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0013\u001a\u00020\u0002H&J\u0018\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J\u0018\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0002H&J \u0010#\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u0002H&J\u0018\u0010$\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u0019H&J \u0010%\u001a\u00020\u000f2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rH&J\u001a\u0010(\u001a\u00020'2\u0006\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010&\u001a\u00020\u0002H&J\b\u0010*\u001a\u00020)H&J\u000e\u0010-\u001a\b\u0012\u0004\u0012\u00020,0+H&J \u00104\u001a\u0002032\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020\u00022\u0006\u00102\u001a\u000201H&J\u0018\u00107\u001a\u00020\u00052\u0006\u00105\u001a\u00020\u001c2\u0006\u00106\u001a\u00020\u0002H&J\u0018\u00108\u001a\u00020\u00022\u0006\u00105\u001a\u00020\u001c2\u0006\u00106\u001a\u00020\u0002H&J0\u0010B\u001a\u00020\u00022\u0006\u0010:\u001a\u0002092\u0006\u0010<\u001a\u00020;2\u0006\u0010=\u001a\u00020\u00022\u0006\u0010?\u001a\u00020>2\u0006\u0010A\u001a\u00020@H&J\u0010\u0010D\u001a\u00020\u00022\u0006\u0010C\u001a\u00020\u0002H&J\u0018\u0010G\u001a\u00020\u00022\u0006\u0010E\u001a\u00020\u00022\u0006\u0010F\u001a\u00020\u0002H&J\u0010\u0010H\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u0002H&J\u0018\u0010J\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010I\u001a\u00020\u0002H&J\u0018\u0010K\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010I\u001a\u00020\u0002H&\u00a8\u0006L"}, d2 = {"Lcom/tencent/guild/api/emoji/IGuildEmojiApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "localId", "emojiType", "", "isDynamicType", "Landroid/graphics/drawable/Drawable;", "getEmojiDrawable", "isEmoReady", "isDynamicResReady", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "Lkotlin/collections/ArrayList;", "msgElements", "", "parseEmotionText", "text", "parseQQText", "emoSize", WadlProxyConsts.FLAGS, "Lcom/tencent/mobileqq/text/ISpanRefreshCallback;", "callback", "", "msg", "Landroid/widget/TextView;", "view", "serverEmoId", "", "convertEmoServerIdToEmoCode", "emoType", "transEmoServerIdToEmoLocalId", EmojiManagerServiceProxy.EPID, "eId", "type", "parseSmallEmo", "parseQQTextCompatEmoji", "parseMsgElementToChosenStr", "grabFlags", "Landroid/text/Editable$Factory;", "getEmoEditableFactory", "Landroid/text/Spannable$Factory;", "getEmoSpanFactory", "", "Lcom/tencent/qqnt/kernel/nativeinterface/EmojiUseInfo;", "getRecentEmojiData", "Lcom/tencent/mobileqq/guild/emoj/b;", "param", "panelHeight", "Lcom/tencent/mobileqq/guild/emoj/f;", "callBack", "", "showReactionEmoPanel", "content", "index", "isValidEmojiFaceId", "parseEmojiFaceStrToServerId", "Landroid/text/style/CharacterStyle;", TtmlNode.TAG_SPAN, "Landroid/graphics/Canvas;", PM.CANVAS, "bitmapHeight", "Landroid/graphics/Paint;", "paint", "", "startX", "getEmoticonSpanDrawableWidth", "codePoint", "getSingleEmoji", "firstCode", "secondCode", "getDoubleEmoji", "isSkinEmoji", "picOrgSize", "calFavEmoMaxThumbSize", "calFavEmoMinThumbSize", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface IGuildEmojiApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Editable.Factory a(IGuildEmojiApi iGuildEmojiApi, int i3, int i16, int i17, Object obj) {
            if (obj == null) {
                if ((i17 & 2) != 0) {
                    i16 = 3;
                }
                return iGuildEmojiApi.getEmoEditableFactory(i3, i16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getEmoEditableFactory");
        }

        public static /* synthetic */ Drawable b(IGuildEmojiApi iGuildEmojiApi, int i3, int i16, boolean z16, int i17, Object obj) {
            if (obj == null) {
                if ((i17 & 4) != 0) {
                    z16 = false;
                }
                return iGuildEmojiApi.getEmojiDrawable(i3, i16, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getEmojiDrawable");
        }
    }

    int calFavEmoMaxThumbSize(boolean isDynamicType, int picOrgSize);

    int calFavEmoMinThumbSize(boolean isDynamicType, int picOrgSize);

    @NotNull
    String convertEmoServerIdToEmoCode(int serverEmoId, int emojiType);

    int getDoubleEmoji(int firstCode, int secondCode);

    @NotNull
    Editable.Factory getEmoEditableFactory(int emoSize, int grabFlags);

    @NotNull
    Spannable.Factory getEmoSpanFactory();

    @Nullable
    Drawable getEmojiDrawable(int localId, int emojiType, boolean isDynamicType);

    int getEmoticonSpanDrawableWidth(@NotNull CharacterStyle span, @NotNull Canvas canvas, int bitmapHeight, @NotNull Paint paint, float startX);

    @NotNull
    List<EmojiUseInfo> getRecentEmojiData();

    int getSingleEmoji(int codePoint);

    boolean isDynamicResReady(int localId, int emojiType);

    boolean isEmoReady(int localId, int emojiType);

    boolean isSkinEmoji(int codePoint);

    boolean isValidEmojiFaceId(@NotNull String content, int index);

    int parseEmojiFaceStrToServerId(@NotNull String content, int index);

    @NotNull
    CharSequence parseEmotionText(@NotNull ArrayList<MsgElement> msgElements);

    @NotNull
    CharSequence parseMsgElementToChosenStr(@NotNull ArrayList<MsgElement> msgElements);

    @NotNull
    CharSequence parseQQText(@NotNull CharSequence text);

    @NotNull
    CharSequence parseQQText(@NotNull CharSequence text, int emoSize);

    @NotNull
    CharSequence parseQQText(@NotNull CharSequence text, int emoSize, int flags);

    @NotNull
    CharSequence parseQQText(@NotNull CharSequence text, int emoSize, int flags, @Nullable ISpanRefreshCallback callback);

    @NotNull
    CharSequence parseQQText(@NotNull CharSequence text, int emoSize, int flags, @Nullable Object msg2, @Nullable ISpanRefreshCallback callback);

    @NotNull
    CharSequence parseQQText(@NotNull CharSequence text, @Nullable TextView view, int emoSize);

    @NotNull
    CharSequence parseQQTextCompatEmoji(@NotNull CharSequence text, @NotNull TextView view);

    @NotNull
    CharSequence parseSmallEmo(int epId, int eId, int type);

    void showReactionEmoPanel(@NotNull b param, int panelHeight, @NotNull f callBack);

    int transEmoServerIdToEmoLocalId(int serverEmoId, int emoType);
}

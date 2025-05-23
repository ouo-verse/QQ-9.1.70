package com.tencent.guild.api.emoji.impl;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.Spannable;
import android.text.style.CharacterStyle;
import android.widget.TextView;
import androidx.collection.LruCache;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.guild.aio.msglist.text.util.d;
import com.tencent.guild.api.emoji.IGuildEmojiApi;
import com.tencent.guild.api.msg.IGuildMsgElementApi;
import com.tencent.guild.api.msg.impl.GuildMsgElementApiImpl;
import com.tencent.mobileqq.emosm.e;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.emoticon.QQSysFaceResImpl;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmojiManagerServiceProxy;
import com.tencent.mobileqq.guild.emoj.api.IQQGuildEmojiApi;
import com.tencent.mobileqq.guild.emoj.f;
import com.tencent.mobileqq.guild.temp.api.IEmoEditableFactoryApi;
import com.tencent.mobileqq.guild.temp.api.IGuildMarkdownApi;
import com.tencent.mobileqq.pic.api.IPicAIO;
import com.tencent.mobileqq.qqemoticon.api.ISysEmoApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.text.ISpanRefreshCallback;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.ArkElement;
import com.tencent.qqnt.kernel.nativeinterface.EmojiUseInfo;
import com.tencent.qqnt.kernel.nativeinterface.FaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.msg.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringBuilderJVMKt;
import oi1.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00aa\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bU\u0010VJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\"\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J \u0010\u0017\u001a\u00020\u00042\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0016J \u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\nH\u0016J\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\nH\u0016J\"\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001a\u001a\u00020\nH\u0016J*\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J4\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\n2\b\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0018\u0010#\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J\u0018\u0010%\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010$\u001a\u00020\nH\u0016J \u0010)\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\nH\u0016J\u0018\u0010*\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0016\u0010+\u001a\u00020\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016J\u0018\u0010.\u001a\u00020-2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010,\u001a\u00020\nH\u0016J\b\u00100\u001a\u00020/H\u0016J\u000e\u00103\u001a\b\u0012\u0004\u0012\u00020201H\u0016J \u0010:\u001a\u0002092\u0006\u00105\u001a\u0002042\u0006\u00106\u001a\u00020\n2\u0006\u00108\u001a\u000207H\u0016J\u0018\u0010=\u001a\u00020\r2\u0006\u0010;\u001a\u00020\b2\u0006\u0010<\u001a\u00020\nH\u0016J\u0018\u0010>\u001a\u00020\n2\u0006\u0010;\u001a\u00020\b2\u0006\u0010<\u001a\u00020\nH\u0016J0\u0010H\u001a\u00020\n2\u0006\u0010@\u001a\u00020?2\u0006\u0010B\u001a\u00020A2\u0006\u0010C\u001a\u00020\n2\u0006\u0010E\u001a\u00020D2\u0006\u0010G\u001a\u00020FH\u0016J\u0010\u0010J\u001a\u00020\n2\u0006\u0010I\u001a\u00020\nH\u0016J\u0018\u0010M\u001a\u00020\n2\u0006\u0010K\u001a\u00020\n2\u0006\u0010L\u001a\u00020\nH\u0016J\u0010\u0010N\u001a\u00020\r2\u0006\u0010I\u001a\u00020\nH\u0016J\u0018\u0010P\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010O\u001a\u00020\nH\u0016J\u0018\u0010Q\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010O\u001a\u00020\nH\u0016R \u0010S\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bS\u0010T\u00a8\u0006W"}, d2 = {"Lcom/tencent/guild/api/emoji/impl/GuildEmojiApiImpl;", "Lcom/tencent/guild/api/emoji/IGuildEmojiApi;", "Lcom/tencent/qqnt/kernel/nativeinterface/FaceElement;", "faceElement", "", "parseMarketSmallFace", "Lcom/tencent/qqnt/kernel/nativeinterface/ArkElement;", "arkElement", "", "parseDscStr", "", "localId", "emojiType", "", "isDynamicType", "Landroid/graphics/drawable/Drawable;", "getEmojiDrawable", "isEmoReady", "isDynamicResReady", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "Lkotlin/collections/ArrayList;", "msgElements", "parseEmotionText", "text", "parseQQText", "emoSize", WadlProxyConsts.FLAGS, "Landroid/widget/TextView;", "view", "Lcom/tencent/mobileqq/text/ISpanRefreshCallback;", "callback", "", "msg", "serverEmoId", "convertEmoServerIdToEmoCode", "emoType", "transEmoServerIdToEmoLocalId", EmojiManagerServiceProxy.EPID, "eId", "type", "parseSmallEmo", "parseQQTextCompatEmoji", "parseMsgElementToChosenStr", "grabFlags", "Landroid/text/Editable$Factory;", "getEmoEditableFactory", "Landroid/text/Spannable$Factory;", "getEmoSpanFactory", "", "Lcom/tencent/qqnt/kernel/nativeinterface/EmojiUseInfo;", "getRecentEmojiData", "Lcom/tencent/mobileqq/guild/emoj/b;", "param", "panelHeight", "Lcom/tencent/mobileqq/guild/emoj/f;", "callBack", "", "showReactionEmoPanel", "content", "index", "isValidEmojiFaceId", "parseEmojiFaceStrToServerId", "Landroid/text/style/CharacterStyle;", TtmlNode.TAG_SPAN, "Landroid/graphics/Canvas;", PM.CANVAS, "bitmapHeight", "Landroid/graphics/Paint;", "paint", "", "startX", "getEmoticonSpanDrawableWidth", "codePoint", "getSingleEmoji", "firstCode", "secondCode", "getDoubleEmoji", "isSkinEmoji", "picOriginSize", "calFavEmoMaxThumbSize", "calFavEmoMinThumbSize", "Landroidx/collection/LruCache;", "sMarkdownCache", "Landroidx/collection/LruCache;", "<init>", "()V", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildEmojiApiImpl implements IGuildEmojiApi {

    @NotNull
    private final LruCache<String, String> sMarkdownCache = new LruCache<>(10);

    private final String parseDscStr(ArkElement arkElement) {
        String str;
        try {
            if (arkElement != null) {
                str = arkElement.bytesData;
            } else {
                str = null;
            }
            String optString = new JSONObject(str).optString("prompt");
            Intrinsics.checkNotNullExpressionValue(optString, "jsonRoot.optString(\"prompt\")");
            return optString;
        } catch (Exception e16) {
            QLog.e("MsgExt", 4, String.valueOf(e16));
            return "[Ark]";
        }
    }

    private final CharSequence parseMarketSmallFace(FaceElement faceElement) {
        a aVar = a.f359552a;
        int c16 = aVar.c(faceElement.faceIndex);
        int b16 = aVar.b(faceElement.faceIndex);
        QLog.i("MsgExt", 4, "parseMarketSmallFace emoPkgId=" + c16 + " emoId=" + b16);
        IGuildEmojiApi iGuildEmojiApi = (IGuildEmojiApi) QRoute.api(IGuildEmojiApi.class);
        Integer num = faceElement.imageType;
        Intrinsics.checkNotNullExpressionValue(num, "faceElement.imageType");
        return iGuildEmojiApi.parseSmallEmo(c16, b16, num.intValue());
    }

    @Override // com.tencent.guild.api.emoji.IGuildEmojiApi
    public int calFavEmoMaxThumbSize(boolean isDynamicType, int picOriginSize) {
        return ((IPicAIO) QRoute.api(IPicAIO.class)).getThumbMaxPx(isDynamicType, false, picOriginSize);
    }

    @Override // com.tencent.guild.api.emoji.IGuildEmojiApi
    public int calFavEmoMinThumbSize(boolean isDynamicType, int picOriginSize) {
        return ((IPicAIO) QRoute.api(IPicAIO.class)).getThumbMinPx(isDynamicType, false, picOriginSize);
    }

    @Override // com.tencent.guild.api.emoji.IGuildEmojiApi
    @NotNull
    public String convertEmoServerIdToEmoCode(int serverEmoId, int emojiType) {
        int serverToLocal = ((IQQGuildEmojiApi) QRoute.api(IQQGuildEmojiApi.class)).serverToLocal(String.valueOf(serverEmoId), emojiType);
        if (serverToLocal < 0) {
            QLog.i("MsgExt", 1, "convertEmoServerIdToEmoCode error: localeCode invalid");
            return "";
        }
        String emoString = ((ISysEmoApi) QRoute.api(ISysEmoApi.class)).getEmoString(emojiType, serverToLocal);
        Intrinsics.checkNotNullExpressionValue(emoString, "api(ISysEmoApi::class.ja\u2026ng(emojiType, localeCode)");
        return emoString;
    }

    @Override // com.tencent.guild.api.emoji.IGuildEmojiApi
    public int getDoubleEmoji(int firstCode, int secondCode) {
        return EmotcationConstants.getDoubleEmoji(firstCode, secondCode);
    }

    @Override // com.tencent.guild.api.emoji.IGuildEmojiApi
    @NotNull
    public Editable.Factory getEmoEditableFactory(int emoSize, int grabFlags) {
        return ((IEmoEditableFactoryApi) QRoute.api(IEmoEditableFactoryApi.class)).getEmoEditableFactory(emoSize, grabFlags);
    }

    @Override // com.tencent.guild.api.emoji.IGuildEmojiApi
    @NotNull
    public Spannable.Factory getEmoSpanFactory() {
        Spannable.Factory SPANNABLE_FACTORY = QQText.SPANNABLE_FACTORY;
        Intrinsics.checkNotNullExpressionValue(SPANNABLE_FACTORY, "SPANNABLE_FACTORY");
        return SPANNABLE_FACTORY;
    }

    @Override // com.tencent.guild.api.emoji.IGuildEmojiApi
    @Nullable
    public Drawable getEmojiDrawable(int localId, int emojiType, boolean isDynamicType) {
        if (isDynamicType) {
            return ((IQQGuildEmojiApi) QRoute.api(IQQGuildEmojiApi.class)).getDynamicDrawable(localId, emojiType);
        }
        return ((ISysEmoApi) QRoute.api(ISysEmoApi.class)).getEmoDrawable(emojiType, localId);
    }

    @Override // com.tencent.guild.api.emoji.IGuildEmojiApi
    public int getEmoticonSpanDrawableWidth(@NotNull CharacterStyle span, @NotNull Canvas canvas, int bitmapHeight, @NotNull Paint paint, float startX) {
        EmoticonSpan emoticonSpan;
        int i3;
        Drawable drawable;
        Rect bounds;
        Drawable drawable2;
        Rect bounds2;
        Intrinsics.checkNotNullParameter(span, "span");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (span instanceof EmoticonSpan) {
            emoticonSpan = (EmoticonSpan) span;
        } else {
            emoticonSpan = null;
        }
        if (emoticonSpan != null && (drawable2 = emoticonSpan.getDrawable()) != null && (bounds2 = drawable2.getBounds()) != null) {
            i3 = bounds2.height();
        } else {
            i3 = 0;
        }
        int i16 = (bitmapHeight - i3) / 2;
        int i17 = (i3 + bitmapHeight) / 2;
        if (emoticonSpan != null) {
            emoticonSpan.draw(canvas, "", 0, 0, startX, i16, i17, i17, paint);
        }
        if (emoticonSpan == null || (drawable = emoticonSpan.getDrawable()) == null || (bounds = drawable.getBounds()) == null) {
            return 0;
        }
        return bounds.width();
    }

    @Override // com.tencent.guild.api.emoji.IGuildEmojiApi
    @NotNull
    public List<EmojiUseInfo> getRecentEmojiData() {
        ArrayList arrayList = new ArrayList();
        List<b> fetchRecentEmojiData = ((IQQGuildEmojiApi) QRoute.api(IQQGuildEmojiApi.class)).fetchRecentEmojiData();
        if (fetchRecentEmojiData != null) {
            for (b bVar : fetchRecentEmojiData) {
                arrayList.add(new EmojiUseInfo(0L, 0, bVar.f422704b, bVar.f422703a));
            }
        }
        return arrayList;
    }

    @Override // com.tencent.guild.api.emoji.IGuildEmojiApi
    public int getSingleEmoji(int codePoint) {
        return EmotcationConstants.getSingleEmoji(codePoint);
    }

    @Override // com.tencent.guild.api.emoji.IGuildEmojiApi
    public boolean isDynamicResReady(int localId, int emojiType) {
        if (emojiType != 1) {
            return true;
        }
        QQSysAndEmojiResInfo resImpl = QQSysAndEmojiResMgr.getInstance().getResImpl(1);
        Intrinsics.checkNotNull(resImpl, "null cannot be cast to non-null type com.tencent.mobileqq.emoticon.QQSysFaceResImpl");
        QQSysFaceResImpl qQSysFaceResImpl = (QQSysFaceResImpl) resImpl;
        return qQSysFaceResImpl.isDynamicResReady(qQSysFaceResImpl.getServerId(localId));
    }

    @Override // com.tencent.guild.api.emoji.IGuildEmojiApi
    public boolean isEmoReady(int localId, int emojiType) {
        if (emojiType != 1) {
            if (emojiType != 2) {
                return false;
            }
            return QQEmojiUtil.isEmoReady(localId);
        }
        int serverId = QQSysAndEmojiResMgr.getInstance().getResImpl(1).getServerId(localId);
        QQSysAndEmojiResMgr.getInstance().getResImpl(1);
        return QQSysFaceUtil.isEmoReady(serverId);
    }

    @Override // com.tencent.guild.api.emoji.IGuildEmojiApi
    public boolean isSkinEmoji(int codePoint) {
        return EmotcationConstants.isSkinEmoji(codePoint);
    }

    @Override // com.tencent.guild.api.emoji.IGuildEmojiApi
    public boolean isValidEmojiFaceId(@NotNull String content, int index) {
        Intrinsics.checkNotNullParameter(content, "content");
        try {
            char charAt = content.charAt(index + 1);
            if (charAt == '\u00fa') {
                charAt = '\n';
            }
            return QQSysFaceUtil.isValidFaceId(charAt);
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.tencent.guild.api.emoji.IGuildEmojiApi
    public int parseEmojiFaceStrToServerId(@NotNull String content, int index) {
        Intrinsics.checkNotNullParameter(content, "content");
        if (isValidEmojiFaceId(content, index)) {
            char charAt = content.charAt(index + 1);
            if (charAt == '\u00fa') {
                charAt = '\n';
            }
            return ((IQQGuildEmojiApi) QRoute.api(IQQGuildEmojiApi.class)).localToServer(String.valueOf((int) charAt), 1);
        }
        return -1;
    }

    @Override // com.tencent.guild.api.emoji.IGuildEmojiApi
    @NotNull
    public CharSequence parseEmotionText(@NotNull ArrayList<MsgElement> msgElements) {
        Intrinsics.checkNotNullParameter(msgElements, "msgElements");
        if (msgElements.isEmpty()) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        QRouteApi api = QRoute.api(IGuildMsgElementApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IGuildMsgElementApi::class.java)");
        IGuildMsgElementApi iGuildMsgElementApi = (IGuildMsgElementApi) api;
        for (MsgElement msgElement : msgElements) {
            int i3 = msgElement.elementType;
            if (i3 == 6) {
                FaceElement faceElement = msgElement.faceElement;
                if (faceElement != null) {
                    Intrinsics.checkNotNullExpressionValue(faceElement, "faceElement");
                    d dVar = d.f111941a;
                    if (dVar.a(Integer.valueOf(faceElement.faceType))) {
                        sb5.append(parseMarketSmallFace(faceElement));
                    } else if (dVar.b(Integer.valueOf(faceElement.faceType))) {
                        sb5.append(QQSysFaceUtil.getFaceString(QQSysFaceUtil.convertToLocal(msgElement.faceElement.faceIndex)));
                    } else {
                        sb5.append(GuildMsgElementApiImpl.DESC_ELEMENT_EMOJI);
                    }
                }
            } else if (i3 == 1) {
                sb5.append(iGuildMsgElementApi.getElementContent(msgElement));
            }
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "result.toString()");
        return sb6;
    }

    @Override // com.tencent.guild.api.emoji.IGuildEmojiApi
    @NotNull
    public CharSequence parseMsgElementToChosenStr(@NotNull ArrayList<MsgElement> msgElements) {
        Intrinsics.checkNotNullParameter(msgElements, "msgElements");
        StringBuilder sb5 = new StringBuilder();
        QRouteApi api = QRoute.api(IGuildMsgElementApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IGuildMsgElementApi::class.java)");
        IGuildMsgElementApi iGuildMsgElementApi = (IGuildMsgElementApi) api;
        for (MsgElement msgElement : msgElements) {
            if (msgElement.elementType == 6) {
                FaceElement faceElement = msgElement.faceElement;
                if (faceElement != null) {
                    Intrinsics.checkNotNullExpressionValue(faceElement, "faceElement");
                    sb5.append(((IQQGuildEmojiApi) QRoute.api(IQQGuildEmojiApi.class)).fetchEmoSpan(faceElement.faceType, faceElement.faceIndex));
                }
            } else if (iGuildMsgElementApi.isTextElem(msgElement)) {
                sb5.append(iGuildMsgElementApi.getElementContent(msgElement));
            } else if (iGuildMsgElementApi.isPictureElem(msgElement)) {
                sb5.append(GuildMsgElementApiImpl.DESC_ELEMENT_PIC);
            } else if (iGuildMsgElementApi.isVideoElem(msgElement)) {
                sb5.append("[\u89c6\u9891]");
            } else if (iGuildMsgElementApi.isArkElem(msgElement)) {
                sb5.append(parseDscStr(msgElement.arkElement));
            } else {
                int i3 = msgElement.elementType;
                if (i3 == 3) {
                    sb5.append(GuildMsgElementApiImpl.DESC_ELEMENT_FILE);
                    sb5.append(msgElement.fileElement.fileName);
                } else if (i3 == 14) {
                    String str = msgElement.markdownElement.content;
                    String str2 = this.sMarkdownCache.get(str);
                    if (str2 == null) {
                        str2 = ((IGuildMarkdownApi) QRoute.api(IGuildMarkdownApi.class)).parseMarkdownText(str);
                        this.sMarkdownCache.put(str, str2);
                    }
                    StringsKt__StringBuilderJVMKt.clear(sb5);
                    sb5.append(str2);
                }
            }
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "result.toString()");
        return sb6;
    }

    @Override // com.tencent.guild.api.emoji.IGuildEmojiApi
    @NotNull
    public CharSequence parseQQText(@NotNull CharSequence text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return new QQText(text, 5, 16);
    }

    @Override // com.tencent.guild.api.emoji.IGuildEmojiApi
    @NotNull
    public CharSequence parseQQTextCompatEmoji(@NotNull CharSequence text, @NotNull TextView view) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(view, "view");
        return new QQText(text, 3, 14, view);
    }

    @Override // com.tencent.guild.api.emoji.IGuildEmojiApi
    @NotNull
    public CharSequence parseSmallEmo(int epId, int eId, int type) {
        char[] z16 = e.z(epId, eId, type);
        Intrinsics.checkNotNullExpressionValue(z16, "getSmallChatAryFormat(epId, eId, type)");
        return new String(z16);
    }

    @Override // com.tencent.guild.api.emoji.IGuildEmojiApi
    public void showReactionEmoPanel(@NotNull com.tencent.mobileqq.guild.emoj.b param, int panelHeight, @NotNull f callBack) {
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        ((IQQGuildEmojiApi) QRoute.api(IQQGuildEmojiApi.class)).showWithAnim(param, panelHeight, callBack);
    }

    @Override // com.tencent.guild.api.emoji.IGuildEmojiApi
    public int transEmoServerIdToEmoLocalId(int serverEmoId, int emoType) {
        return ((IQQGuildEmojiApi) QRoute.api(IQQGuildEmojiApi.class)).serverToLocal(String.valueOf(serverEmoId), emoType);
    }

    @Override // com.tencent.guild.api.emoji.IGuildEmojiApi
    @NotNull
    public CharSequence parseQQText(@NotNull CharSequence text, int emoSize, int flags) {
        Intrinsics.checkNotNullParameter(text, "text");
        return new QQText(text, flags, emoSize);
    }

    @Override // com.tencent.guild.api.emoji.IGuildEmojiApi
    @NotNull
    public CharSequence parseQQText(@NotNull CharSequence text, int emoSize) {
        Intrinsics.checkNotNullParameter(text, "text");
        return new QQText(text, 5, emoSize);
    }

    @Override // com.tencent.guild.api.emoji.IGuildEmojiApi
    @NotNull
    public CharSequence parseQQText(@NotNull CharSequence text, @Nullable TextView view, int emoSize) {
        Intrinsics.checkNotNullParameter(text, "text");
        return new QQText(text, 5, emoSize, view);
    }

    @Override // com.tencent.guild.api.emoji.IGuildEmojiApi
    @NotNull
    public CharSequence parseQQText(@NotNull CharSequence text, int emoSize, int flags, @Nullable ISpanRefreshCallback callback) {
        Intrinsics.checkNotNullParameter(text, "text");
        return new QQText(text, flags, emoSize, null, callback);
    }

    @Override // com.tencent.guild.api.emoji.IGuildEmojiApi
    @NotNull
    public CharSequence parseQQText(@NotNull CharSequence text, int emoSize, int flags, @Nullable Object msg2, @Nullable ISpanRefreshCallback callback) {
        Intrinsics.checkNotNullParameter(text, "text");
        return new QQText(text, flags, emoSize, msg2, callback);
    }
}

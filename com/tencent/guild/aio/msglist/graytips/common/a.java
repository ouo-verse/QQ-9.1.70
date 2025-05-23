package com.tencent.guild.aio.msglist.graytips.common;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.guild.data.GuildCommonGrayTipsParseParams;
import com.tencent.mobileqq.guild.message.api.IGuildCommonGrayTipsApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.GrayTipElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.LocalGrayTipElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.XmlElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J(\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/guild/aio/msglist/graytips/common/a;", "", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/LocalGrayTipElement;", "localGrayTipElement", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/XmlElement;", "a", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "guildMsgItem", "Landroid/graphics/drawable/Drawable$Callback;", "drawableCallback", "Landroid/os/Bundle;", QQBrowserActivity.APP_PARAM, "", "isRebuild", "", "b", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f111330a = new a();

    a() {
    }

    private final XmlElement a(LocalGrayTipElement localGrayTipElement) {
        String str;
        if (localGrayTipElement.type != 8 || (str = localGrayTipElement.extraJson) == null) {
            return null;
        }
        return new XmlElement(0L, 0L, 0, 0, 0, str, 0L, 0L, null, null, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004e  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final CharSequence b(@NotNull GuildMsgItem guildMsgItem, @NotNull Drawable.Callback drawableCallback, @NotNull Bundle extraParams, boolean isRebuild) {
        GrayTipElement grayTipElement;
        XmlElement xmlElement;
        LocalGrayTipElement localGrayTipElement;
        XmlElement xmlElement2;
        XmlElement a16;
        Intrinsics.checkNotNullParameter(guildMsgItem, "guildMsgItem");
        Intrinsics.checkNotNullParameter(drawableCallback, "drawableCallback");
        Intrinsics.checkNotNullParameter(extraParams, "extraParams");
        if (guildMsgItem.getMsgRecord().msgType != 5) {
            return null;
        }
        MsgElement firstTypeElement = guildMsgItem.getFirstTypeElement(8);
        if (firstTypeElement != null) {
            grayTipElement = firstTypeElement.grayTipElement;
        } else {
            grayTipElement = null;
        }
        if (grayTipElement != null) {
            xmlElement = grayTipElement.xmlElement;
        } else {
            xmlElement = null;
        }
        if (xmlElement != null) {
            a16 = grayTipElement.xmlElement;
        } else {
            if (grayTipElement != null) {
                localGrayTipElement = grayTipElement.localGrayTipElement;
            } else {
                localGrayTipElement = null;
            }
            if (localGrayTipElement != null) {
                LocalGrayTipElement localGrayTipElement2 = grayTipElement.localGrayTipElement;
                Intrinsics.checkNotNullExpressionValue(localGrayTipElement2, "grayTipElement.localGrayTipElement");
                a16 = a(localGrayTipElement2);
            } else {
                xmlElement2 = null;
                if (xmlElement2 != null) {
                    return null;
                }
                return ((IGuildCommonGrayTipsApi) QRoute.api(IGuildCommonGrayTipsApi.class)).getGuildCommonGrayTipsContent(new GuildCommonGrayTipsParseParams(guildMsgItem.getMsgRecord().guildId, guildMsgItem.getMsgRecord().channelId, guildMsgItem.getMsgRecord().senderUid, Long.valueOf(guildMsgItem.getMsgId()), xmlElement2, extraParams), drawableCallback, isRebuild);
            }
        }
        xmlElement2 = a16;
        if (xmlElement2 != null) {
        }
    }
}

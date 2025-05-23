package com.tencent.guild.api.msg.impl;

import com.tencent.guild.api.msg.IGuildMsgElementApi;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0013\u0010\u000f\u001a\u00020\u000b*\u00020\u0002H\u0000\u00a2\u0006\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/guild/api/msg/impl/GuildMsgElementApiImpl;", "Lcom/tencent/guild/api/msg/IGuildMsgElementApi;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "elem", "", "isTextElem", "isPictureElem", "isVideoElem", "isArkElem", "isReplyElem", DTConstants.TAG.ELEMENT, "", "getElementContent", "getContent$nt_guild_impl_release", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;)Ljava/lang/String;", "getContent", "<init>", "()V", "Companion", "a", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildMsgElementApiImpl implements IGuildMsgElementApi {

    @NotNull
    public static final String DESC_ELEMENT_EMOJI = "[emoji]";

    @NotNull
    public static final String DESC_ELEMENT_FILE = "[\u6587\u4ef6]";

    @NotNull
    public static final String DESC_ELEMENT_PIC = "[\u56fe\u7247]";

    @NotNull
    public static final String MSG_ELEMENT_UN_SUPPORT_PROMPT = "[\u4e0d\u652f\u6301\u7684\u5143\u7d20\u7c7b\u578b]";

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0030, code lost:
    
        r7 = kotlin.text.StringsKt__StringsJVMKt.replace$default(r0, "\r", "\n", false, 4, (java.lang.Object) null);
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String getContent$nt_guild_impl_release(@NotNull MsgElement msgElement) {
        String replace$default;
        Intrinsics.checkNotNullParameter(msgElement, "<this>");
        int i3 = msgElement.elementType;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 6) {
                        return MSG_ELEMENT_UN_SUPPORT_PROMPT;
                    }
                    String str = msgElement.faceElement.faceText;
                    if (str == null) {
                        return DESC_ELEMENT_EMOJI;
                    }
                    return str;
                }
                return DESC_ELEMENT_FILE;
            }
            return DESC_ELEMENT_PIC;
        }
        String str2 = msgElement.textElement.content;
        if (str2 == null || replace$default == null) {
            return "";
        }
        return replace$default;
    }

    @Override // com.tencent.guild.api.msg.IGuildMsgElementApi
    @NotNull
    public String getElementContent(@NotNull MsgElement element) {
        Intrinsics.checkNotNullParameter(element, "element");
        return getContent$nt_guild_impl_release(element);
    }

    @Override // com.tencent.guild.api.msg.IGuildMsgElementApi
    public boolean isArkElem(@NotNull MsgElement elem) {
        Intrinsics.checkNotNullParameter(elem, "elem");
        if (elem.elementType == 10) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.guild.api.msg.IGuildMsgElementApi
    public boolean isPictureElem(@NotNull MsgElement elem) {
        Intrinsics.checkNotNullParameter(elem, "elem");
        if (elem.elementType == 2) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.guild.api.msg.IGuildMsgElementApi
    public boolean isReplyElem(@NotNull MsgElement elem) {
        Intrinsics.checkNotNullParameter(elem, "elem");
        if (elem.elementType == 7 && elem.replyElement != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.guild.api.msg.IGuildMsgElementApi
    public boolean isTextElem(@NotNull MsgElement elem) {
        Intrinsics.checkNotNullParameter(elem, "elem");
        int i3 = elem.elementType;
        if (i3 == 1 || i3 == 6) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.guild.api.msg.IGuildMsgElementApi
    public boolean isVideoElem(@NotNull MsgElement elem) {
        Intrinsics.checkNotNullParameter(elem, "elem");
        if (elem.elementType == 5) {
            return true;
        }
        return false;
    }
}

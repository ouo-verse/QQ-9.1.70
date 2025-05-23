package com.tencent.guild.aio.util;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.tencent.guild.aio.input.at.utils.data.AtRoleInfo;
import com.tencent.guild.aio.input.widget.GuildAIOInputEditText;
import com.tencent.guild.api.msg.service.ChannelAIOMsgService;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqnt.kernel.nativeinterface.FaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.ReplyElement;
import com.tencent.qqnt.kernel.nativeinterface.TextElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J&\u0010\u0014\u001a\u00020\u00062\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00102\u0006\u0010\u0013\u001a\u00020\u0012J$\u0010\u0016\u001a\u00020\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00152\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004JB\u0010\u001f\u001a\u00020\u00062\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00102\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00060\u001c\u00a8\u0006\""}, d2 = {"Lcom/tencent/guild/aio/util/GuildDraftUtil;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/FaceElement;", "faceElement", "Landroid/widget/EditText;", "editText", "", "d", "Landroid/view/View;", "aioReply", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/TextElement;", "textElement", "f", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "Lkotlin/collections/ArrayList;", DTParamKey.REPORT_KEY_VISUAL_ELEMENTS, "Lvn0/e;", "binding", "b", "", "c", "msgElements", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "contact", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlin/Function1;", "Lcom/tencent/aio/data/msglist/a;", "callback", "e", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildDraftUtil {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildDraftUtil f112365a = new GuildDraftUtil();

    GuildDraftUtil() {
    }

    private final void a(EditText editText, View aioReply) {
        editText.getEditableText().clear();
        aioReply.setVisibility(8);
    }

    private final void d(FaceElement faceElement, EditText editText) {
        if (faceElement != null) {
            com.tencent.guild.aio.msglist.text.util.d.f111941a.m(faceElement, editText);
        }
    }

    private final void f(TextElement textElement, EditText editText) {
        int i3 = textElement.atType;
        if (i3 != 0) {
            if (i3 != 1 && i3 != 2) {
                if (i3 != 8) {
                    if (i3 != 16) {
                        if (i3 != 64) {
                            if (i3 != 512) {
                                return;
                            }
                        }
                    }
                    Context context = editText.getContext();
                    String valueOf = String.valueOf(textElement.atChannelId);
                    String str = textElement.content;
                    Intrinsics.checkNotNullExpressionValue(str, "textElement.content");
                    String substring = str.substring(1);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                    editText.getEditableText().append((CharSequence) com.tencent.guild.aio.input.at.utils.d.v(context, valueOf, substring, editText, 0, false, true, textElement.atType));
                    return;
                }
                String valueOf2 = String.valueOf(textElement.atRoleId);
                String str2 = textElement.atRoleName;
                Intrinsics.checkNotNullExpressionValue(str2, "textElement.atRoleName");
                Integer num = textElement.atRoleColor;
                Intrinsics.checkNotNullExpressionValue(num, "textElement.atRoleColor");
                AtRoleInfo atRoleInfo = new AtRoleInfo(valueOf2, str2, Utils.P(num.intValue()));
                Context context2 = editText.getContext();
                String valueOf3 = String.valueOf(textElement.atTinyId);
                String str3 = textElement.content;
                Intrinsics.checkNotNullExpressionValue(str3, "textElement.content");
                String substring2 = str3.substring(1);
                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                String str4 = textElement.content;
                Intrinsics.checkNotNullExpressionValue(str4, "textElement.content");
                String substring3 = str4.substring(1);
                Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String).substring(startIndex)");
                editText.getEditableText().append((CharSequence) com.tencent.guild.aio.input.at.utils.b.q(context2, valueOf3, substring2, substring3, editText, 0, false, false, textElement.atType, atRoleInfo));
                return;
            }
            Context context3 = editText.getContext();
            String valueOf4 = String.valueOf(textElement.atTinyId);
            String str5 = textElement.content;
            Intrinsics.checkNotNullExpressionValue(str5, "textElement.content");
            String substring4 = str5.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring4, "this as java.lang.String).substring(startIndex)");
            String str6 = textElement.content;
            Intrinsics.checkNotNullExpressionValue(str6, "textElement.content");
            String substring5 = str6.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring5, "this as java.lang.String).substring(startIndex)");
            editText.getEditableText().append((CharSequence) com.tencent.guild.aio.input.at.utils.b.q(context3, valueOf4, substring4, substring5, editText, 0, false, false, textElement.atType, null));
            return;
        }
        editText.getEditableText().append((CharSequence) textElement.content);
    }

    public final void b(@NotNull ArrayList<MsgElement> elements, @NotNull vn0.e binding) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Intrinsics.checkNotNullParameter(binding, "binding");
        LinearLayout linearLayout = binding.f441932b;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.aioReply");
        GuildAIOInputEditText guildAIOInputEditText = binding.f441937g;
        Intrinsics.checkNotNullExpressionValue(guildAIOInputEditText, "binding.guildAioInputEdittext");
        c(elements, linearLayout, guildAIOInputEditText);
    }

    public final void c(@NotNull List<MsgElement> elements, @NotNull View aioReply, @NotNull EditText editText) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Intrinsics.checkNotNullParameter(aioReply, "aioReply");
        Intrinsics.checkNotNullParameter(editText, "editText");
        a(editText, aioReply);
        for (MsgElement msgElement : elements) {
            int i3 = msgElement.elementType;
            if (i3 != 1) {
                if (i3 == 6) {
                    d(msgElement.faceElement, editText);
                }
            } else {
                TextElement textElement = msgElement.textElement;
                Intrinsics.checkNotNullExpressionValue(textElement, "element.textElement");
                f(textElement, editText);
            }
        }
    }

    public final void e(@NotNull ArrayList<MsgElement> msgElements, @NotNull Contact contact, @NotNull CoroutineScope scope, @NotNull Function1<? super com.tencent.aio.data.msglist.a, Unit> callback) {
        Object obj;
        Long l3;
        ArrayList<Long> arrayListOf;
        boolean z16;
        Intrinsics.checkNotNullParameter(msgElements, "msgElements");
        Intrinsics.checkNotNullParameter(contact, "contact");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Iterator<T> it = msgElements.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((MsgElement) obj).elementType == 7) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        MsgElement msgElement = (MsgElement) obj;
        if (msgElement != null) {
            msgElements.remove(msgElement);
            ChannelAIOMsgService channelAIOMsgService = ChannelAIOMsgService.f112613a;
            Long[] lArr = new Long[1];
            ReplyElement replyElement = msgElement.replyElement;
            if (replyElement != null) {
                l3 = Long.valueOf(replyElement.replayMsgId);
            } else {
                l3 = null;
            }
            lArr[0] = l3;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(lArr);
            FlowKt.launchIn(FlowKt.onEach(channelAIOMsgService.s(contact, arrayListOf), new GuildDraftUtil$retrieveReplyDraft$2$1(callback, null)), scope);
        }
    }
}

package com.tencent.mobileqq.channel.node.summary;

import com.tencent.mobileqq.guild.message.api.IGuildMsgSummaryDecodersApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstract;
import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstractElement;
import ex3.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000bJ\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/channel/node/summary/RecentChannelSummaryAdapter;", "", "()V", "decode", "", "contactInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", DTParamKey.REPORT_KEY_VISUAL_ELEMENTS, "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/MsgAbstractElement;", "selfTinyId", "", "tryToAddCalendarContent", "normalContent", "abstract", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/MsgAbstract;", "qqchat_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
public final class RecentChannelSummaryAdapter {
    static IPatchRedirector $redirector_;

    @NotNull
    public static final RecentChannelSummaryAdapter INSTANCE;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22823);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new RecentChannelSummaryAdapter();
        }
    }

    RecentChannelSummaryAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final CharSequence tryToAddCalendarContent(CharSequence normalContent, MsgAbstract r46) {
        Object firstOrNull;
        boolean z16;
        ArrayList<MsgAbstractElement> arrayList = r46.elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "abstract.elements");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
        MsgAbstractElement msgAbstractElement = (MsgAbstractElement) firstOrNull;
        if (msgAbstractElement != null) {
            if (msgAbstractElement.elementType == 19 && msgAbstractElement.calendarElement != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                msgAbstractElement = null;
            }
            if (msgAbstractElement != null) {
                return msgAbstractElement.calendarElement.summary + ((Object) normalContent);
            }
            return normalContent;
        }
        return normalContent;
    }

    @NotNull
    public final CharSequence decode(@NotNull RecentContactInfo contactInfo, @Nullable ArrayList<MsgAbstractElement> elements, @NotNull String selfTinyId) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CharSequence) iPatchRedirector.redirect((short) 2, this, contactInfo, elements, selfTinyId);
        }
        Intrinsics.checkNotNullParameter(contactInfo, "contactInfo");
        Intrinsics.checkNotNullParameter(selfTinyId, "selfTinyId");
        if (elements == null || (i3 = (int) a.i(contactInfo)) == 1) {
            return "";
        }
        MsgAbstract msgAbstract = new MsgAbstract(new Contact(4, a.b(contactInfo), a.f(contactInfo)), contactInfo.senderUid, contactInfo.sendMemberName, contactInfo.sendNickName, contactInfo.sendStatus, elements, contactInfo.msgTime, i3, contactInfo.msgSeq);
        CharSequence normalContent = ((IGuildMsgSummaryDecodersApi) QRoute.api(IGuildMsgSummaryDecodersApi.class)).decodeMsg(msgAbstract, selfTinyId);
        RecentChannelSummaryAdapter recentChannelSummaryAdapter = INSTANCE;
        Intrinsics.checkNotNullExpressionValue(normalContent, "normalContent");
        return recentChannelSummaryAdapter.tryToAddCalendarContent(normalContent, msgAbstract);
    }
}

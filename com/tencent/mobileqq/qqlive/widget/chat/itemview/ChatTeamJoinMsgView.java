package com.tencent.mobileqq.qqlive.widget.chat.itemview;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qqlive.widget.chat.message.k;
import com.tencent.mobileqq.qqlive.widget.chat.span.e;
import com.tencent.mobileqq.qqlive.widget.chat.span.f;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.MessageOuterClass$LiveRoomEnterGameTeamMsg;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010&\u001a\u00020%\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'\u0012\b\b\u0002\u0010*\u001a\u00020)\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\"\u0010\u000e\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0016\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000bJ\u0006\u0010\u0015\u001a\u00020\u0002J\b\u0010\u0016\u001a\u00020\u0002H\u0014J\b\u0010\u0017\u001a\u00020\u0002H\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\r\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001b\u0010$\u001a\u00020 8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010!\u001a\u0004\b\"\u0010#\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/chat/itemview/ChatTeamJoinMsgView;", "Lcom/tencent/mobileqq/qqlive/widget/chat/itemview/ChatBaseText;", "", "refresh", "", "u", "r", "Landroid/text/SpannableString;", "p", "", "nick", "", "speakId", "anchorId", DomainData.DOMAIN_NAME, "Ltrpc/yes/common/MessageOuterClass$LiveRoomEnterGameTeamMsg;", "joinMsg", "o", "Lcom/tencent/mobileqq/qqlive/widget/chat/message/k;", "teamPlayJoinMsg", "t", ReportConstant.COSTREPORT_PREFIX, NodeProps.ON_DETACHED_FROM_WINDOW, "setNormalBackground", "G", "Ltrpc/yes/common/MessageOuterClass$LiveRoomEnterGameTeamMsg;", "msg", "H", "Lcom/tencent/mobileqq/qqlive/widget/chat/message/k;", "screenMsg", "I", "J", "Lcom/tencent/mobileqq/qqlive/widget/chat/span/e;", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/mobileqq/qqlive/widget/chat/span/e;", "senderSpan", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public class ChatTeamJoinMsgView extends ChatBaseText {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private MessageOuterClass$LiveRoomEnterGameTeamMsg msg;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private k screenMsg;

    /* renamed from: I, reason: from kotlin metadata */
    private long anchorId;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy senderSpan;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/qqlive/widget/chat/itemview/ChatTeamJoinMsgView$a", "Landroid/text/style/ClickableSpan;", "Landroid/text/TextPaint;", "ds", "", "updateDrawState", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, NodeProps.ON_CLICK, "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a extends ClickableSpan {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatTeamJoinMsgView.this);
            }
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) widget);
            } else {
                Intrinsics.checkNotNullParameter(widget, "widget");
                ChatTeamJoinMsgView.this.r();
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint ds5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) ds5);
                return;
            }
            Intrinsics.checkNotNullParameter(ds5, "ds");
            super.updateDrawState(ds5);
            ds5.setUnderlineText(false);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ChatTeamJoinMsgView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, (Object) this, (Object) context);
    }

    private final String n(String nick, long speakId, long anchorId) {
        String f16;
        vi2.c h16 = h();
        if (h16 == null || (f16 = h16.f(i(), nick, speakId, anchorId)) == null) {
            return "";
        }
        return f16;
    }

    private final SpannableString o(MessageOuterClass$LiveRoomEnterGameTeamMsg joinMsg) {
        String n3 = n(joinMsg.nickname.get(), joinMsg.uid.get(), this.anchorId);
        e q16 = q();
        LiveUserInfo liveUserInfo = new LiveUserInfo();
        liveUserInfo.nick = joinMsg.nickname.get();
        liveUserInfo.uid = joinMsg.uid.get();
        liveUserInfo.headUrl = joinMsg.avatar_url.get();
        q16.e(liveUserInfo, i(), this.anchorId);
        q16.c(g(this.screenMsg));
        Unit unit = Unit.INSTANCE;
        return d(n3, q16);
    }

    private final SpannableString p() {
        SpannableString spannableString = new SpannableString("\u6211\u4e5f\u62a2\u5ea7");
        spannableString.setSpan(new a(), 0, spannableString.length(), 17);
        spannableString.setSpan(new f(-1, -16777216, wi2.c.b(10), false, 0.0f, 0, 56, null), 0, spannableString.length(), 17);
        return spannableString;
    }

    private final e q() {
        return (e) this.senderSpan.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r() {
        vi2.c h16 = h();
        if (h16 != null) {
            h16.g();
        }
    }

    private final void refresh() {
        List split$default;
        boolean z16;
        MessageOuterClass$LiveRoomEnterGameTeamMsg messageOuterClass$LiveRoomEnterGameTeamMsg = this.msg;
        if (messageOuterClass$LiveRoomEnterGameTeamMsg != null) {
            setNormalBackground();
            ArrayList arrayList = new ArrayList();
            String str = messageOuterClass$LiveRoomEnterGameTeamMsg.text.get();
            Intrinsics.checkNotNullExpressionValue(str, "msg.text.get()");
            split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{"{nickname}"}, false, 0, 6, (Object) null);
            List list = split$default;
            int i3 = 0;
            if (list != null && !list.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                for (Object obj : split$default) {
                    int i16 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    arrayList.add((String) obj);
                    if (i3 < split$default.size() - 1) {
                        arrayList.add(o(messageOuterClass$LiveRoomEnterGameTeamMsg));
                    }
                    i3 = i16;
                }
            }
            if (u()) {
                arrayList.add(p());
            }
            setSpanText(arrayList);
            k kVar = this.screenMsg;
            if (kVar != null) {
                l(kVar);
            }
        }
    }

    private final boolean u() {
        vi2.c h16 = h();
        if (h16 != null) {
            return h16.p();
        }
        return false;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onDetachedFromWindow();
        this.msg = null;
        this.screenMsg = null;
    }

    public final void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            refresh();
        }
    }

    public void setNormalBackground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            setBackgroundDrawable(e());
        }
    }

    public final void t(@NotNull k teamPlayJoinMsg, long anchorId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, teamPlayJoinMsg, Long.valueOf(anchorId));
            return;
        }
        Intrinsics.checkNotNullParameter(teamPlayJoinMsg, "teamPlayJoinMsg");
        this.msg = teamPlayJoinMsg.b();
        this.screenMsg = teamPlayJoinMsg;
        this.anchorId = anchorId;
        refresh();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ChatTeamJoinMsgView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, (Object) this, (Object) context, (Object) attributeSet);
    }

    public /* synthetic */ ChatTeamJoinMsgView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ChatTeamJoinMsgView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<e>() { // from class: com.tencent.mobileqq.qqlive.widget.chat.itemview.ChatTeamJoinMsgView$senderSpan$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ChatTeamJoinMsgView.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final e invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (e) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    e eVar = new e();
                    ChatTeamJoinMsgView chatTeamJoinMsgView = ChatTeamJoinMsgView.this;
                    eVar.d(chatTeamJoinMsgView.f(), chatTeamJoinMsgView.h());
                    return eVar;
                }
            });
            this.senderSpan = lazy;
        }
    }
}

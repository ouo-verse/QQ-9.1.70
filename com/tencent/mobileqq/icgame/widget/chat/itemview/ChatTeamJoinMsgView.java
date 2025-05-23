package com.tencent.mobileqq.icgame.widget.chat.itemview;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.icgame.trpc.yes.common.MessageOuterClass$LiveRoomEnterGameTeamMsg;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
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
import w42.TeamPlayJoinMsg;
import y42.d;
import z42.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010%\u001a\u00020$\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&\u0012\b\b\u0002\u0010)\u001a\u00020(\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\"\u0010\u000e\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0016\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000bJ\b\u0010\u0015\u001a\u00020\u0002H\u0014J\b\u0010\u0016\u001a\u00020\u0002H\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\r\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001b\u0010#\u001a\u00020\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010 \u001a\u0004\b!\u0010\"\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/icgame/widget/chat/itemview/ChatTeamJoinMsgView;", "Lcom/tencent/mobileqq/icgame/widget/chat/itemview/ChatBaseText;", "", "refresh", "", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/text/SpannableString;", "o", "", "nick", "", "speakId", "anchorId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/icgame/trpc/yes/common/MessageOuterClass$LiveRoomEnterGameTeamMsg;", "joinMsg", DomainData.DOMAIN_NAME, "Lw42/l;", "teamPlayJoinMsg", "r", NodeProps.ON_DETACHED_FROM_WINDOW, "setNormalBackground", "G", "Lcom/tencent/icgame/trpc/yes/common/MessageOuterClass$LiveRoomEnterGameTeamMsg;", "msg", "H", "Lw42/l;", "screenMsg", "I", "J", "Ly42/c;", "Lkotlin/Lazy;", "p", "()Ly42/c;", "senderSpan", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ic-game-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public class ChatTeamJoinMsgView extends ChatBaseText {

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private MessageOuterClass$LiveRoomEnterGameTeamMsg msg;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private TeamPlayJoinMsg screenMsg;

    /* renamed from: I, reason: from kotlin metadata */
    private long anchorId;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy senderSpan;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/icgame/widget/chat/itemview/ChatTeamJoinMsgView$a", "Landroid/text/style/ClickableSpan;", "Landroid/text/TextPaint;", "ds", "", "updateDrawState", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, NodeProps.ON_CLICK, "ic-game-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a extends ClickableSpan {
        a() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            ChatTeamJoinMsgView.this.q();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint ds5) {
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
    }

    private final String m(String nick, long speakId, long anchorId) {
        String f16;
        c playFunc = getPlayFunc();
        if (playFunc == null || (f16 = playFunc.f(getRoomId(), nick, speakId, anchorId)) == null) {
            return "";
        }
        return f16;
    }

    private final SpannableString n(MessageOuterClass$LiveRoomEnterGameTeamMsg joinMsg) {
        String m3 = m(joinMsg.nickname.get(), joinMsg.uid.get(), this.anchorId);
        y42.c p16 = p();
        LiveUserInfo liveUserInfo = new LiveUserInfo();
        liveUserInfo.nick = joinMsg.nickname.get();
        liveUserInfo.uid = joinMsg.uid.get();
        liveUserInfo.headUrl = joinMsg.avatar_url.get();
        p16.d(liveUserInfo, getRoomId(), this.anchorId);
        p16.b(c52.a.a(R.color.c5f));
        Unit unit = Unit.INSTANCE;
        return d(m3, p16);
    }

    private final SpannableString o() {
        SpannableString spannableString = new SpannableString("\u6211\u4e5f\u62a2\u5ea7");
        spannableString.setSpan(new a(), 0, spannableString.length(), 17);
        spannableString.setSpan(new d(-1, -16777216, wi2.c.b(10), false, 0.0f, 24, null), 0, spannableString.length(), 17);
        return spannableString;
    }

    private final y42.c p() {
        return (y42.c) this.senderSpan.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        c playFunc = getPlayFunc();
        if (playFunc != null) {
            playFunc.g();
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
                        arrayList.add(n(messageOuterClass$LiveRoomEnterGameTeamMsg));
                    }
                    i3 = i16;
                }
            }
            if (s()) {
                arrayList.add(o());
            }
            setSpanText(arrayList);
            TeamPlayJoinMsg teamPlayJoinMsg = this.screenMsg;
            if (teamPlayJoinMsg != null) {
                k(teamPlayJoinMsg);
            }
        }
    }

    private final boolean s() {
        c playFunc = getPlayFunc();
        if (playFunc != null) {
            return playFunc.p();
        }
        return false;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.msg = null;
        this.screenMsg = null;
    }

    public final void r(@NotNull TeamPlayJoinMsg teamPlayJoinMsg, long anchorId) {
        Intrinsics.checkNotNullParameter(teamPlayJoinMsg, "teamPlayJoinMsg");
        this.msg = teamPlayJoinMsg.getTeamPlayJoin();
        this.screenMsg = teamPlayJoinMsg;
        this.anchorId = anchorId;
        refresh();
    }

    public void setNormalBackground() {
        setBackgroundDrawable(e());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ChatTeamJoinMsgView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ChatTeamJoinMsgView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ChatTeamJoinMsgView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<y42.c>() { // from class: com.tencent.mobileqq.icgame.widget.chat.itemview.ChatTeamJoinMsgView$senderSpan$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final y42.c invoke() {
                y42.c cVar = new y42.c();
                ChatTeamJoinMsgView chatTeamJoinMsgView = ChatTeamJoinMsgView.this;
                cVar.c(chatTeamJoinMsgView.getDataSupport(), chatTeamJoinMsgView.getPlayFunc());
                return cVar;
            }
        });
        this.senderSpan = lazy;
    }
}

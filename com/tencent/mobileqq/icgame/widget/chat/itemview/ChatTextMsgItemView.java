package com.tencent.mobileqq.icgame.widget.chat.itemview;

import a52.ShareUserInfo;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.icgame.trpc.yes.common.CommonOuterClass$QQUserId;
import com.tencent.icgame.trpc.yes.common.MessageOuterClass$AnchorRoomBulletScreenMsg;
import com.tencent.icgame.trpc.yes.common.MessageOuterClass$AtUser;
import com.tencent.icgame.trpc.yes.common.MessageOuterClass$AtUserMsg;
import com.tencent.icgame.trpc.yes.common.MessageOuterClass$MsgContent;
import com.tencent.icgame.trpc.yes.common.MessageOuterClass$TimMsgBody;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.icgame.data.message.LiveMessageData;
import com.tencent.mobileqq.icgame.widget.chat.message.LiveLocalMsg;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.data.heart.QLBroadCastFreeLove;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w42.FollowPushScreenMessage;
import w42.e;
import w42.f;
import w42.g;
import w42.j;
import w42.k;
import y42.d;
import z42.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 ^2\u00020\u0001:\u0001_B'\b\u0007\u0012\u0006\u0010X\u001a\u00020W\u0012\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010Y\u0012\b\b\u0002\u0010[\u001a\u00020!\u00a2\u0006\u0004\b\\\u0010]J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J$\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\tJ\u0016\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u0004J\u001e\u0010\u001d\u001a\u00020\u00062\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a2\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\u001e\u001a\u00020\u0006H\u0016J\b\u0010\u001f\u001a\u00020\u0006H\u0016J\b\u0010 \u001a\u00020\u0006H\u0016J\b\u0010\"\u001a\u00020!H\u0016J\b\u0010#\u001a\u00020!H\u0016J\u0010\u0010'\u001a\u00020&2\u0006\u0010%\u001a\u00020$H\u0016J\b\u0010(\u001a\u00020&H\u0016J\"\u0010,\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010+\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010-\u001a\u00020\u0006H\u0002J\u0010\u0010.\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001e\u00102\u001a\b\u0012\u0004\u0012\u00020&012\u0006\u00100\u001a\u00020/2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u00105\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u00104\u001a\u000203H\u0002J\u0018\u00106\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u00108\u001a\u00020&2\u0006\u0010\u0003\u001a\u000207H\u0002J,\u0010:\u001a\u0004\u0018\u00010)2\b\u00109\u001a\u0004\u0018\u00010)2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010;\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010<\u001a\u00020&H\u0002R\"\u0010@\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020>0=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010?R\"\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001b0=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010?R\u0018\u0010D\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010CR\u0014\u0010E\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010CR\u001b\u0010I\u001a\u00020B8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b.\u0010F\u001a\u0004\bG\u0010HR\u001b\u0010N\u001a\u00020J8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bK\u0010F\u001a\u0004\bL\u0010MR\u001b\u0010Q\u001a\u00020J8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bO\u0010F\u001a\u0004\bP\u0010MR\u001b\u0010V\u001a\u00020R8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bS\u0010F\u001a\u0004\bT\u0010U\u00a8\u0006`"}, d2 = {"Lcom/tencent/mobileqq/icgame/widget/chat/itemview/ChatTextMsgItemView;", "Lcom/tencent/mobileqq/icgame/widget/chat/itemview/ChatBaseText;", "Lw42/e;", "msg", "", "anchorId", "", BdhLogUtil.LogTag.Tag_Conn, "Lw42/c;", "Lkotlin/Function0;", "followChangedSuccess", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lw42/g;", "B", "Lw42/a;", HippyTKDListViewAdapter.X, "Lw42/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lw42/k;", "G", "Lw42/j;", "I", "Lcom/tencent/mobileqq/icgame/widget/chat/message/LiveLocalMsg;", "D", "Lcom/tencent/icgame/trpc/yes/common/MessageOuterClass$AnchorRoomBulletScreenMsg;", "y", "", "Lcom/tencent/icgame/trpc/yes/common/MessageOuterClass$AtUser;", "data", "J", "setNormalBackground", "setAtMsgBackground", "setSysMsgBackground", "", ReportConstant.COSTREPORT_PREFIX, "r", "", "isSelfMsg", "", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "nick", "speakId", "l", "E", "K", "Lcom/tencent/mobileqq/qqlive/data/heart/QLBroadCastFreeLove;", "likeInfo", "", "o", "La52/c;", "shareUserInfo", "H", UserInfo.SEX_FEMALE, "Lw42/f;", "t", "content", "w", "v", "p", "", "Lcom/tencent/icgame/trpc/yes/common/CommonOuterClass$QQUserId;", "Ljava/util/Map;", "atUserInfoMap", "uidAtInfoMap", "Landroid/text/SpannableStringBuilder;", "Landroid/text/SpannableStringBuilder;", "followSpan", "spannable", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Landroid/text/SpannableStringBuilder;", "anchorSpan", "Landroid/graphics/drawable/GradientDrawable;", "L", "getAtBgDrawable", "()Landroid/graphics/drawable/GradientDrawable;", "atBgDrawable", "M", "getSysBgDrawable", "sysBgDrawable", "Ly42/c;", "N", "u", "()Ly42/c;", "nickClickSpan", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "P", "a", "ic-game-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public class ChatTextMsgItemView extends ChatBaseText {

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private Map<String, CommonOuterClass$QQUserId> atUserInfoMap;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private Map<Long, MessageOuterClass$AtUser> uidAtInfoMap;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private SpannableStringBuilder followSpan;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final SpannableStringBuilder spannable;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy anchorSpan;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Lazy atBgDrawable;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Lazy sysBgDrawable;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final Lazy nickClickSpan;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/icgame/widget/chat/itemview/ChatTextMsgItemView$b", "Landroid/text/style/ClickableSpan;", "Landroid/text/TextPaint;", "ds", "", "updateDrawState", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, NodeProps.ON_CLICK, "ic-game-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b extends ClickableSpan {
        b() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            c playFunc = ChatTextMsgItemView.this.getPlayFunc();
            if (playFunc != null) {
                playFunc.l();
            }
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
    public ChatTextMsgItemView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void E() {
        u().b(c52.a.a(R.color.c5f));
    }

    private final void F(w42.b msg2, long anchorId) {
        List<? extends CharSequence> listOf;
        y42.c u16 = u();
        LiveUserInfo liveUserInfo = new LiveUserInfo();
        LiveMessageData.SpeakerInfo speakerInfo = msg2.f444565d;
        liveUserInfo.nick = speakerInfo.mSpeakerName;
        liveUserInfo.uid = speakerInfo.mSpeakId;
        liveUserInfo.headUrl = speakerInfo.mLogo;
        u16.d(liveUserInfo, getRoomId(), anchorId);
        StringBuilder sb5 = new StringBuilder();
        LiveMessageData.SpeakerInfo speakerInfo2 = msg2.f444565d;
        sb5.append(l(speakerInfo2.mSpeakerName, speakerInfo2.mSpeakId, anchorId));
        sb5.append(TokenParser.SP);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new CharSequence[]{t(msg2), d(sb5.toString(), u16), m()});
        setSpanText(listOf);
    }

    private final void H(w42.b msg2, long anchorId, ShareUserInfo shareUserInfo) {
        List<? extends CharSequence> listOf;
        y42.c u16 = u();
        LiveUserInfo liveUserInfo = new LiveUserInfo();
        LiveMessageData.SpeakerInfo speakerInfo = msg2.f444565d;
        liveUserInfo.nick = speakerInfo.mSpeakerName;
        liveUserInfo.uid = speakerInfo.mSpeakId;
        liveUserInfo.headUrl = speakerInfo.mLogo;
        u16.d(liveUserInfo, getRoomId(), anchorId);
        y42.c cVar = new y42.c();
        cVar.c(getDataSupport(), getPlayFunc());
        LiveUserInfo liveUserInfo2 = new LiveUserInfo();
        liveUserInfo2.nick = shareUserInfo.getShareUserName();
        liveUserInfo2.uid = shareUserInfo.getShareUID();
        liveUserInfo2.headUrl = "";
        cVar.d(liveUserInfo2, getRoomId(), anchorId);
        cVar.b(c52.a.a(R.color.c5f));
        LiveMessageData.SpeakerInfo speakerInfo2 = msg2.f444565d;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new CharSequence[]{t(msg2), d(l(speakerInfo2.mSpeakerName, speakerInfo2.mSpeakId, anchorId), u16), " \u4ece ", d(l(shareUserInfo.getShareUserName(), shareUserInfo.getShareUID(), anchorId), cVar), " \u7684\u5206\u4eab\u8fdb\u5165\u4e86\u623f\u95f4"});
        setSpanText(listOf);
    }

    private final void K(long anchorId) {
        LiveUserInfo liveUserInfo;
        boolean z16;
        int i3;
        z42.a dataSupport = getDataSupport();
        if (dataSupport != null) {
            liveUserInfo = dataSupport.getSelfUserInfo();
        } else {
            liveUserInfo = null;
        }
        if (liveUserInfo != null && liveUserInfo.uid == anchorId) {
            return;
        }
        c playFunc = getPlayFunc();
        if (playFunc != null) {
            z16 = playFunc.j(anchorId);
        } else {
            z16 = false;
        }
        if (z16 && this.followSpan == null) {
            return;
        }
        if (z16) {
            i3 = R.drawable.myq;
        } else {
            i3 = R.drawable.myp;
        }
        Bitmap decodeResource = BitmapFactory.decodeResource(getContext().getResources(), i3);
        Intrinsics.checkNotNullExpressionValue(decodeResource, "decodeResource(context.resources, icon)");
        this.followSpan = ChatBaseText.b(this, decodeResource, 0, 0, 0, 0, 30, null);
        invalidate();
    }

    private final String l(String nick, long speakId, long anchorId) {
        String f16;
        c playFunc = getPlayFunc();
        if (playFunc == null || (f16 = playFunc.f(getRoomId(), nick, speakId, anchorId)) == null) {
            return "";
        }
        return f16;
    }

    private final List<CharSequence> o(QLBroadCastFreeLove likeInfo, long anchorId) {
        List split$default;
        boolean z16;
        ArrayList arrayList = new ArrayList();
        String str = likeInfo.roomMsg;
        Intrinsics.checkNotNullExpressionValue(str, "likeInfo.roomMsg");
        String str2 = likeInfo.userNick;
        Intrinsics.checkNotNullExpressionValue(str2, "likeInfo.userNick");
        int i3 = 0;
        split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{str2}, false, 0, 6, (Object) null);
        List list = split$default;
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
                    String str3 = l(likeInfo.userNick, likeInfo.uid, anchorId) + '\uff1a';
                    y42.c u16 = u();
                    LiveUserInfo liveUserInfo = new LiveUserInfo();
                    liveUserInfo.nick = likeInfo.userNick;
                    liveUserInfo.uid = likeInfo.uid;
                    liveUserInfo.headUrl = likeInfo.headImg;
                    u16.d(liveUserInfo, getRoomId(), anchorId);
                    Unit unit = Unit.INSTANCE;
                    arrayList.add(d(str3, u16));
                }
                i3 = i16;
            }
        }
        return arrayList;
    }

    private final CharSequence p() {
        return "\u5206\u4eab\u4e86\u8be5\u623f\u95f4";
    }

    private final SpannableStringBuilder q() {
        return (SpannableStringBuilder) this.anchorSpan.getValue();
    }

    private final CharSequence t(f msg2) {
        return "";
    }

    private final y42.c u() {
        return (y42.c) this.nickClickSpan.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void v(e msg2, long anchorId) {
        MessageOuterClass$AtUserMsg messageOuterClass$AtUserMsg;
        List<MessageOuterClass$AtUser> list;
        String str;
        List<MessageOuterClass$AtUser> list2;
        String str2;
        z42.a dataSupport;
        List<? extends CharSequence> listOf;
        PBRepeatMessageField<MessageOuterClass$AtUser> pBRepeatMessageField;
        PBStringField pBStringField;
        PBRepeatMessageField<MessageOuterClass$AtUser> pBRepeatMessageField2;
        MessageOuterClass$MsgContent messageOuterClass$MsgContent;
        MessageOuterClass$TimMsgBody a16 = msg2.a();
        String str3 = null;
        if (a16 != null && (messageOuterClass$MsgContent = a16.content) != null) {
            messageOuterClass$AtUserMsg = messageOuterClass$MsgContent.at_user_msg;
        } else {
            messageOuterClass$AtUserMsg = null;
        }
        if (messageOuterClass$AtUserMsg != null && (pBRepeatMessageField2 = messageOuterClass$AtUserMsg.user_list) != null) {
            list = pBRepeatMessageField2.get();
        } else {
            list = null;
        }
        J(list, anchorId);
        if (messageOuterClass$AtUserMsg != null && (pBStringField = messageOuterClass$AtUserMsg.text) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (messageOuterClass$AtUserMsg != null && (pBRepeatMessageField = messageOuterClass$AtUserMsg.user_list) != null) {
            list2 = pBRepeatMessageField.get();
        } else {
            list2 = null;
        }
        String w3 = w(str, list2, anchorId);
        CharSequence charSequence = "";
        if (w3 != null) {
            z42.a dataSupport2 = getDataSupport();
            if (dataSupport2 != null) {
                str3 = dataSupport2.decodeQQEmotion(w3);
            }
            if (str3 != null) {
                str2 = str3;
                this.spannable.clear();
                this.spannable.clearSpans();
                this.spannable.append((CharSequence) str2);
                dataSupport = getDataSupport();
                if (dataSupport != null) {
                    dataSupport.C(this, 0, str2, this.atUserInfoMap, this.spannable, this.uidAtInfoMap);
                }
                CharSequence[] charSequenceArr = new CharSequence[3];
                if (msg2.c().mSpeakId == anchorId) {
                    charSequence = q();
                }
                charSequenceArr[0] = charSequence;
                String str4 = l(msg2.c().mSpeakerName, msg2.c().mSpeakId, anchorId) + '\uff1a';
                y42.c u16 = u();
                LiveUserInfo liveUserInfo = new LiveUserInfo();
                liveUserInfo.nick = msg2.c().mSpeakerName;
                liveUserInfo.uid = msg2.c().mSpeakId;
                liveUserInfo.headUrl = msg2.c().mLogo;
                u16.d(liveUserInfo, getRoomId(), anchorId);
                Unit unit = Unit.INSTANCE;
                charSequenceArr[1] = d(str4, u16);
                charSequenceArr[2] = new QQText(this.spannable, 3, 16);
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) charSequenceArr);
                setSpanText(listOf);
            }
        }
        str2 = "";
        this.spannable.clear();
        this.spannable.clearSpans();
        this.spannable.append((CharSequence) str2);
        dataSupport = getDataSupport();
        if (dataSupport != null) {
        }
        CharSequence[] charSequenceArr2 = new CharSequence[3];
        if (msg2.c().mSpeakId == anchorId) {
        }
        charSequenceArr2[0] = charSequence;
        String str42 = l(msg2.c().mSpeakerName, msg2.c().mSpeakId, anchorId) + '\uff1a';
        y42.c u162 = u();
        LiveUserInfo liveUserInfo2 = new LiveUserInfo();
        liveUserInfo2.nick = msg2.c().mSpeakerName;
        liveUserInfo2.uid = msg2.c().mSpeakId;
        liveUserInfo2.headUrl = msg2.c().mLogo;
        u162.d(liveUserInfo2, getRoomId(), anchorId);
        Unit unit2 = Unit.INSTANCE;
        charSequenceArr2[1] = d(str42, u162);
        charSequenceArr2[2] = new QQText(this.spannable, 3, 16);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) charSequenceArr2);
        setSpanText(listOf);
    }

    private final String w(String content, List<MessageOuterClass$AtUser> data, long anchorId) {
        if (data != null) {
            Iterator<T> it = data.iterator();
            while (true) {
                String str = content;
                if (it.hasNext()) {
                    MessageOuterClass$AtUser messageOuterClass$AtUser = (MessageOuterClass$AtUser) it.next();
                    String str2 = '@' + messageOuterClass$AtUser.nick_name.get();
                    String str3 = '@' + l(messageOuterClass$AtUser.nick_name.get(), messageOuterClass$AtUser.user_id.uid.get(), anchorId);
                    if (str != null) {
                        content = StringsKt__StringsJVMKt.replace$default(str, str2, str3, false, 4, (Object) null);
                    } else {
                        content = null;
                    }
                } else {
                    return str;
                }
            }
        } else {
            return content;
        }
    }

    public final void A(@NotNull FollowPushScreenMessage msg2, long anchorId, @NotNull final Function0<Unit> followChangedSuccess) {
        boolean z16;
        String str;
        List<? extends CharSequence> listOf;
        SpannableStringBuilder spannableStringBuilder;
        ClickableSpan clickableSpan;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(followChangedSuccess, "followChangedSuccess");
        if (msg2.getFollowPushMessage().toUid != anchorId) {
            return;
        }
        K(anchorId);
        SpannableStringBuilder spannableStringBuilder2 = this.followSpan;
        LiveUserInfo liveUserInfo = null;
        if (spannableStringBuilder2 != null) {
            c playFunc = getPlayFunc();
            if (playFunc != null) {
                clickableSpan = playFunc.A(msg2, anchorId, getRoomId(), new Function1<FollowPushScreenMessage, Unit>() { // from class: com.tencent.mobileqq.icgame.widget.chat.itemview.ChatTextMsgItemView$renderFollow$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(FollowPushScreenMessage followPushScreenMessage) {
                        invoke2(followPushScreenMessage);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull FollowPushScreenMessage it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        followChangedSuccess.invoke();
                    }
                });
            } else {
                clickableSpan = null;
            }
            spannableStringBuilder2.setSpan(clickableSpan, 0, 1, 33);
        }
        z42.a dataSupport = getDataSupport();
        if (dataSupport != null) {
            liveUserInfo = dataSupport.getSelfUserInfo();
        }
        setNormalBackground();
        if (liveUserInfo != null && msg2.getFollowPushMessage().uid == liveUserInfo.uid) {
            z16 = true;
        } else {
            z16 = false;
        }
        CharSequence[] charSequenceArr = new CharSequence[4];
        String str2 = l(msg2.getFollowPushMessage().nick, msg2.getFollowPushMessage().uid, anchorId) + TokenParser.SP;
        y42.c u16 = u();
        LiveUserInfo liveUserInfo2 = new LiveUserInfo();
        liveUserInfo2.nick = msg2.getFollowPushMessage().nick;
        liveUserInfo2.uid = msg2.getFollowPushMessage().uid;
        liveUserInfo2.headUrl = msg2.getFollowPushMessage().icon;
        u16.d(liveUserInfo2, getRoomId(), anchorId);
        Unit unit = Unit.INSTANCE;
        charSequenceArr[0] = d(str2, u16);
        charSequenceArr[1] = n(z16);
        CharSequence charSequence = "";
        if (z16 || this.followSpan == null) {
            str = "";
        } else {
            str = " ";
        }
        charSequenceArr[2] = str;
        if (!z16 && (spannableStringBuilder = this.followSpan) != null && spannableStringBuilder != null) {
            charSequence = spannableStringBuilder;
        }
        charSequenceArr[3] = charSequence;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) charSequenceArr);
        setSpanText(listOf);
        k(msg2);
    }

    public final void B(@NotNull g msg2, long anchorId) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        setNormalBackground();
        QLBroadCastFreeLove qLBroadCastFreeLove = msg2.f444571d;
        Intrinsics.checkNotNullExpressionValue(qLBroadCastFreeLove, "msg.broadCastFreeLove");
        setSpanText(o(qLBroadCastFreeLove, anchorId));
        k(msg2);
    }

    public final void C(@NotNull e msg2, long anchorId) {
        boolean z16;
        String str;
        CharSequence charSequence;
        List<? extends CharSequence> listOf;
        PBInt32Field pBInt32Field;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        E();
        MessageOuterClass$TimMsgBody a16 = msg2.a();
        if (a16 != null && (pBInt32Field = a16.msg_type) != null && pBInt32Field.get() == 70) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            setAtMsgBackground();
            v(msg2, anchorId);
        } else {
            setNormalBackground();
            z42.a dataSupport = getDataSupport();
            if (dataSupport != null) {
                str = dataSupport.decodeQQEmotion(msg2.message());
            } else {
                str = null;
            }
            CharSequence[] charSequenceArr = new CharSequence[3];
            if (msg2.c().mSpeakId == anchorId) {
                charSequence = q();
            } else {
                charSequence = "";
            }
            charSequenceArr[0] = charSequence;
            String str2 = l(msg2.c().mSpeakerName, msg2.c().mSpeakId, anchorId) + '\uff1a';
            y42.c u16 = u();
            LiveUserInfo liveUserInfo = new LiveUserInfo();
            liveUserInfo.nick = msg2.c().mSpeakerName;
            liveUserInfo.uid = msg2.c().mSpeakId;
            liveUserInfo.headUrl = msg2.c().mLogo;
            u16.d(liveUserInfo, getRoomId(), anchorId);
            Unit unit = Unit.INSTANCE;
            charSequenceArr[1] = d(str2, u16);
            charSequenceArr[2] = new QQText(str, 3, 16);
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) charSequenceArr);
            setSpanText(listOf);
        }
        k(msg2);
    }

    public final void D(@NotNull LiveLocalMsg msg2, long anchorId) {
        CharSequence charSequence;
        List<? extends CharSequence> listOf;
        List<? extends CharSequence> listOf2;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (msg2.getIsSendMsgAlienation()) {
            listOf2 = CollectionsKt__CollectionsJVMKt.listOf(new QQText(msg2.getText(), 3, 16));
            setSpanText(listOf2);
            return;
        }
        CharSequence[] charSequenceArr = new CharSequence[3];
        if (msg2.getSender().uid == anchorId) {
            charSequence = q();
        } else {
            charSequence = "";
        }
        charSequenceArr[0] = charSequence;
        String str = l(msg2.getSender().nick, msg2.getSender().uid, anchorId) + '\uff1a';
        y42.c u16 = u();
        LiveUserInfo liveUserInfo = new LiveUserInfo();
        liveUserInfo.nick = msg2.getSender().nick;
        liveUserInfo.uid = msg2.getSender().uid;
        liveUserInfo.headUrl = msg2.getSender().headUrl;
        u16.d(liveUserInfo, getRoomId(), anchorId);
        Unit unit = Unit.INSTANCE;
        charSequenceArr[1] = d(str, u16);
        charSequenceArr[2] = new QQText(msg2.getText(), 3, 16);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) charSequenceArr);
        setSpanText(listOf);
        k(msg2);
    }

    public final void G(@NotNull k msg2, long anchorId) {
        List<? extends CharSequence> listOf;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        setNormalBackground();
        StringBuilder sb5 = new StringBuilder();
        LiveMessageData.SpeakerInfo speakerInfo = msg2.f444579d;
        sb5.append(l(speakerInfo.mSpeakerName, speakerInfo.mSpeakId, anchorId));
        sb5.append(TokenParser.SP);
        String sb6 = sb5.toString();
        y42.c u16 = u();
        LiveUserInfo liveUserInfo = new LiveUserInfo();
        LiveMessageData.SpeakerInfo speakerInfo2 = msg2.f444579d;
        liveUserInfo.nick = speakerInfo2.mSpeakerName;
        liveUserInfo.uid = speakerInfo2.mSpeakId;
        liveUserInfo.headUrl = speakerInfo2.mLogo;
        u16.d(liveUserInfo, getRoomId(), anchorId);
        Unit unit = Unit.INSTANCE;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new CharSequence[]{t(msg2), d(sb6, u16), p()});
        setSpanText(listOf);
        E();
        k(msg2);
    }

    public final void I(@NotNull j msg2, long anchorId) {
        List<? extends CharSequence> listOf;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (msg2.getTxtColor() != 0) {
            setTextColor(msg2.getTxtColor());
        }
        setSysMsgBackground();
        listOf = CollectionsKt__CollectionsJVMKt.listOf(msg2.getSystemNotice());
        setSpanText(listOf);
    }

    public final void J(@Nullable List<MessageOuterClass$AtUser> data, long anchorId) {
        this.atUserInfoMap.clear();
        if (data != null) {
            for (MessageOuterClass$AtUser messageOuterClass$AtUser : data) {
                if (messageOuterClass$AtUser.user_id.uid.get() != 0) {
                    CommonOuterClass$QQUserId atUserId = messageOuterClass$AtUser.user_id.get();
                    String l3 = l(messageOuterClass$AtUser.nick_name.get(), messageOuterClass$AtUser.user_id.get().uid.get(), anchorId);
                    if (!TextUtils.isEmpty(l3)) {
                        Map<String, CommonOuterClass$QQUserId> map = this.atUserInfoMap;
                        Intrinsics.checkNotNullExpressionValue(atUserId, "atUserId");
                        map.put(l3, atUserId);
                    }
                    this.uidAtInfoMap.put(Long.valueOf(atUserId.uid.get()), messageOuterClass$AtUser);
                }
            }
        }
        rt0.a.INSTANCE.j("ICGameChat_Message|ICGameAnchorTextMsgItemView", "atUserInfoMap =" + this.atUserInfoMap);
    }

    @NotNull
    public CharSequence m() {
        return "\u6765\u4e86";
    }

    @NotNull
    public CharSequence n(boolean isSelfMsg) {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("\u6536\u85cf\u4e86\u76f4\u64ad\u95f4");
        if (!isSelfMsg && this.followSpan != null) {
            str = " ";
        } else {
            str = "";
        }
        sb5.append(str);
        return sb5.toString();
    }

    public int r() {
        return wi2.c.b(16);
    }

    public int s() {
        return wi2.c.b(28);
    }

    public void setAtMsgBackground() {
        setBackgroundDrawable(e());
    }

    public void setNormalBackground() {
        setBackgroundDrawable(e());
    }

    public void setSysMsgBackground() {
        setBackgroundDrawable(e());
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x00af, code lost:
    
        if (r14.r() == true) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void x(@NotNull w42.a msg2, long anchorId) {
        boolean z16;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        setNormalBackground();
        ArrayList arrayList = new ArrayList();
        String str = l(msg2.f444564d.nickname.get(), msg2.f444564d.uid.get(), anchorId) + '\uff1a';
        y42.c u16 = u();
        LiveUserInfo liveUserInfo = new LiveUserInfo();
        liveUserInfo.nick = msg2.f444564d.nickname.get();
        liveUserInfo.uid = msg2.f444564d.uid.get();
        liveUserInfo.headUrl = msg2.f444564d.avatar.get();
        u16.d(liveUserInfo, getRoomId(), anchorId);
        Unit unit = Unit.INSTANCE;
        arrayList.add(d(str, u16));
        arrayList.add("\u4e3a\u4e3b\u64ad\u5145\u7535" + msg2.f444564d.charge_times.get() + "\u6b21,\u4e3b\u64ad\u8fd8\u5dee" + msg2.f444564d.upgrade_power.get() + "\u7535\u91cf\u5347\u7ea7 ");
        c playFunc = getPlayFunc();
        if (playFunc != null) {
            z16 = true;
        }
        z16 = false;
        if (z16) {
            SpannableString spannableString = new SpannableString("\u6211\u4e5f\u5145\u7535");
            spannableString.setSpan(new b(), 0, spannableString.length(), 17);
            spannableString.setSpan(new d(-1, -16777216, wi2.c.b(10), false, 0.0f, 24, null), 0, spannableString.length(), 17);
            arrayList.add(spannableString);
        }
        setSpanText(arrayList);
        k(msg2);
    }

    public final void y(@NotNull MessageOuterClass$AnchorRoomBulletScreenMsg msg2, long anchorId) {
        CharSequence charSequence;
        List<? extends CharSequence> listOf;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        CharSequence[] charSequenceArr = new CharSequence[3];
        if (msg2.uid.get() == anchorId) {
            charSequence = q();
        } else {
            charSequence = "";
        }
        charSequenceArr[0] = charSequence;
        String str = l(msg2.nickname.get(), msg2.uid.get(), anchorId) + '\uff1a';
        y42.c u16 = u();
        LiveUserInfo liveUserInfo = new LiveUserInfo();
        liveUserInfo.nick = msg2.nickname.get();
        liveUserInfo.uid = msg2.uid.get();
        liveUserInfo.headUrl = msg2.avator.get();
        u16.d(liveUserInfo, getRoomId(), anchorId);
        Unit unit = Unit.INSTANCE;
        charSequenceArr[1] = d(str, u16);
        charSequenceArr[2] = new QQText(msg2.text.get(), 3, 16);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) charSequenceArr);
        setSpanText(listOf);
    }

    public final void z(@NotNull w42.b msg2, long anchorId) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        setNormalBackground();
        LiveMessageData.SpeakerInfo speakerInfo = msg2.f444565d;
        Intrinsics.checkNotNullExpressionValue(speakerInfo, "msg.speakerInfo");
        ShareUserInfo b16 = a52.d.b(speakerInfo);
        if (b16 != null && b16.getShareUID() > 0 && !TextUtils.isEmpty(b16.getShareUserName()) && b16.getShareUID() != msg2.f444565d.mSpeakId) {
            H(msg2, anchorId, b16);
        } else {
            F(msg2, anchorId);
        }
        E();
        k(msg2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ChatTextMsgItemView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ChatTextMsgItemView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ChatTextMsgItemView(@NotNull final Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Intrinsics.checkNotNullParameter(context, "context");
        this.atUserInfoMap = new LinkedHashMap();
        this.uidAtInfoMap = new LinkedHashMap();
        this.spannable = new SpannableStringBuilder();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<SpannableStringBuilder>() { // from class: com.tencent.mobileqq.icgame.widget.chat.itemview.ChatTextMsgItemView$anchorSpan$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SpannableStringBuilder invoke() {
                ChatTextMsgItemView chatTextMsgItemView = ChatTextMsgItemView.this;
                Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), R.drawable.o65);
                Intrinsics.checkNotNullExpressionValue(decodeResource, "decodeResource(context.r\u2026.tg_anchor_msg_anchor_ic)");
                return chatTextMsgItemView.a(decodeResource, ChatTextMsgItemView.this.s(), ChatTextMsgItemView.this.r(), 0, wi2.c.b(4));
            }
        });
        this.anchorSpan = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<GradientDrawable>() { // from class: com.tencent.mobileqq.icgame.widget.chat.itemview.ChatTextMsgItemView$atBgDrawable$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GradientDrawable invoke() {
                return wi2.d.c(new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{Color.parseColor("#334D4D99"), Color.parseColor("#B34D4D99")}), wi2.c.d(12), wi2.c.d(12), wi2.c.d(12), wi2.c.d(12));
            }
        });
        this.atBgDrawable = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<GradientDrawable>() { // from class: com.tencent.mobileqq.icgame.widget.chat.itemview.ChatTextMsgItemView$sysBgDrawable$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GradientDrawable invoke() {
                GradientDrawable c16 = wi2.d.c(new GradientDrawable(), wi2.c.d(15), wi2.c.d(15), wi2.c.d(15), wi2.c.d(15));
                c16.setColor(c52.a.a(R.color.f156804bs));
                return c16;
            }
        });
        this.sysBgDrawable = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<y42.c>() { // from class: com.tencent.mobileqq.icgame.widget.chat.itemview.ChatTextMsgItemView$nickClickSpan$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final y42.c invoke() {
                y42.c cVar = new y42.c();
                ChatTextMsgItemView chatTextMsgItemView = ChatTextMsgItemView.this;
                cVar.c(chatTextMsgItemView.getDataSupport(), chatTextMsgItemView.getPlayFunc());
                return cVar;
            }
        });
        this.nickClickSpan = lazy4;
    }
}

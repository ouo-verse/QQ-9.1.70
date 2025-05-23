package com.tencent.guild.aio.msglist.reply;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.guild.aio.msglist.holder.component.nick.GuildReplyMsgNickState;
import com.tencent.guild.aio.msglist.reply.GuildReplyMsgState;
import com.tencent.guild.aio.util.ui.GuildChatPicDownloader;
import com.tencent.guild.aio.util.ui.PicSize;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.guild.api.channel.IGuildChannelApi;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.data.msglist.GuildMsgItemPayloadType;
import com.tencent.guild.api.emoji.IGuildEmojiApi;
import com.tencent.guild.api.video.IGuildVideoApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IGuestMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.ReplyElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.MsgExtKt;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import jr0.GuildImageOptions;
import kotlin.C11736d;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Marker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ae\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u0000 \u0081\u00012\u00020\u0001:\u0002\u0082\u0001B\u0010\u0012\u0006\u0010A\u001a\u00020.\u00a2\u0006\u0005\b\u007f\u0010\u0080\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u0018\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011H\u0002J\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0004H\u0002J\"\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0014H\u0002J!\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ \u0010 \u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001dH\u0002J\u0012\u0010!\u001a\u00020\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0014H\u0002J4\u0010'\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00142\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010%\u001a\u00020\u00102\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001d0\"H\u0002J4\u0010)\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00142\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010(\u001a\u00020\u00102\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001d0\"H\u0002J\u0010\u0010+\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u001dH\u0002J\u0010\u0010-\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u0019H\u0002J\b\u0010/\u001a\u00020.H\u0016J\u0010\u00102\u001a\u00020.2\u0006\u00101\u001a\u000200H\u0016J\u0016\u00106\u001a\u0010\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u000205\u0018\u000103H\u0016J&\u00109\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u0002082\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0010\u0010;\u001a\u00020\u000b2\u0006\u0010:\u001a\u000205H\u0016J\b\u0010<\u001a\u00020\u001dH\u0016R\u0017\u0010A\u001a\u00020.8\u0006\u00a2\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u001b\u0010G\u001a\u00020B8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u001b\u0010L\u001a\u00020H8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bI\u0010D\u001a\u0004\bJ\u0010KR\u001b\u0010O\u001a\u00020H8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bM\u0010D\u001a\u0004\bN\u0010KR\u001b\u0010R\u001a\u00020.8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bP\u0010D\u001a\u0004\bQ\u0010@R\u001b\u0010U\u001a\u00020B8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bS\u0010D\u001a\u0004\bT\u0010FR\u001b\u0010Z\u001a\u00020V8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bW\u0010D\u001a\u0004\bX\u0010YR\u001b\u0010]\u001a\u00020V8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b[\u0010D\u001a\u0004\b\\\u0010YR\u001b\u0010`\u001a\u00020V8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b^\u0010D\u001a\u0004\b_\u0010YR\u001b\u0010c\u001a\u00020H8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\ba\u0010D\u001a\u0004\bb\u0010KR\u001b\u0010h\u001a\u00020d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\be\u0010D\u001a\u0004\bf\u0010gR\u001b\u0010k\u001a\u00020B8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bi\u0010D\u001a\u0004\bj\u0010FR\u001d\u0010p\u001a\u0004\u0018\u00010l8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bm\u0010D\u001a\u0004\bn\u0010oR\u001d\u0010s\u001a\u0004\u0018\u00010l8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bq\u0010D\u001a\u0004\br\u0010oR\u0018\u0010v\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bt\u0010uR\u0018\u0010y\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bw\u0010xR\u0016\u0010|\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bz\u0010{R\u0018\u0010~\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b}\u0010x\u00a8\u0006\u0083\u0001"}, d2 = {"Lcom/tencent/guild/aio/msglist/reply/GuildReplyComponent;", "Lcom/tencent/guild/aio/msglist/holder/component/a;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "Lcom/tencent/qqnt/kernel/nativeinterface/ReplyElement;", "w1", "", "", "payloads", "", "O1", "", "M1", "replyElement", "H1", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "y1", "J1", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "x1", "replyMsgRecord", Constants.APK_CERTIFICATE, "isSelf", "", "commentCount", "P1", "(ZLjava/lang/Long;)V", "", "replyNickName", "sourceMsgText", "Q1", "S1", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "elementList", "picNum", "pathList", "R1", "videoNum", "T1", "tinyId", "L1", "seq", "N1", "Landroid/view/View;", "d1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "e1", "position", "Lcom/tencent/aio/data/msglist/a;", "b1", "state", "handleUIState", "getTag", "f", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", "Landroid/view/ViewGroup;", tl.h.F, "Lkotlin/Lazy;", "p1", "()Landroid/view/ViewGroup;", "contentView", "Landroid/widget/TextView;", "i", "A1", "()Landroid/widget/TextView;", "sourceMsgCntTextView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "B1", "sourceMsgTextView", BdhLogUtil.LogTag.Tag_Conn, "C1", "sourceSeparateLineView", "D", "E1", "thumbLayout", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "E", "q1", "()Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "imageView1", UserInfo.SEX_FEMALE, "r1", "imageView2", "G", ICustomDataEditor.STRING_PARAM_1, "imageView3", "H", "F1", "tvPicNum", "Landroid/widget/ImageView;", "I", "v1", "()Landroid/widget/ImageView;", "playView", "J", Constants.BASE_IN_PLUGIN_ID, "thumbContainer", "Landroid/graphics/drawable/Drawable;", "K", "z1", "()Landroid/graphics/drawable/Drawable;", "selfArrowDrawable", "L", "u1", "otherArrowDrawable", "M", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "mCurrentMsgItem", "N", "Ljava/lang/String;", "mReplyMsgSenderId", "P", "Z", "mReplyMsgRevoked", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "mSourceMsgText", "<init>", "(Landroid/view/View;)V", BdhLogUtil.LogTag.Tag_Req, "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildReplyComponent extends com.tencent.guild.aio.msglist.holder.component.a {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy sourceSeparateLineView;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy thumbLayout;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy imageView1;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy imageView2;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy imageView3;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy tvPicNum;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy playView;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy thumbContainer;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy selfArrowDrawable;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Lazy otherArrowDrawable;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private GuildMsgItem mCurrentMsgItem;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private String mReplyMsgSenderId;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean mReplyMsgRevoked;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private String mSourceMsgText;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View root;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy contentView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy sourceMsgCntTextView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy sourceMsgTextView;

    public GuildReplyComponent(@NotNull View root) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Lazy lazy7;
        Lazy lazy8;
        Lazy lazy9;
        Lazy lazy10;
        Lazy lazy11;
        Lazy lazy12;
        Lazy lazy13;
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ViewGroup>() { // from class: com.tencent.guild.aio.msglist.reply.GuildReplyComponent$contentView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewGroup invoke() {
                a aVar = new a();
                Context context = GuildReplyComponent.this.getRoot().getContext();
                View root2 = GuildReplyComponent.this.getRoot();
                Intrinsics.checkNotNull(root2, "null cannot be cast to non-null type android.view.ViewGroup");
                View i3 = aVar.i(context, (ViewGroup) root2, false);
                Intrinsics.checkNotNull(i3, "null cannot be cast to non-null type android.view.ViewGroup");
                return (ViewGroup) i3;
            }
        });
        this.contentView = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.guild.aio.msglist.reply.GuildReplyComponent$sourceMsgCntTextView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                ViewGroup p16;
                p16 = GuildReplyComponent.this.p1();
                return (TextView) p16.findViewById(R.id.vy7);
            }
        });
        this.sourceMsgCntTextView = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.guild.aio.msglist.reply.GuildReplyComponent$sourceMsgTextView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                ViewGroup p16;
                p16 = GuildReplyComponent.this.p1();
                return (TextView) p16.findViewById(R.id.f73323t9);
            }
        });
        this.sourceMsgTextView = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.guild.aio.msglist.reply.GuildReplyComponent$sourceSeparateLineView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                ViewGroup p16;
                p16 = GuildReplyComponent.this.p1();
                return p16.findViewById(R.id.vy6);
            }
        });
        this.sourceSeparateLineView = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<ViewGroup>() { // from class: com.tencent.guild.aio.msglist.reply.GuildReplyComponent$thumbLayout$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewGroup invoke() {
                ViewGroup p16;
                p16 = GuildReplyComponent.this.p1();
                return (ViewGroup) p16.findViewById(R.id.vy_);
            }
        });
        this.thumbLayout = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<GuildUserAvatarView>() { // from class: com.tencent.guild.aio.msglist.reply.GuildReplyComponent$imageView1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final GuildUserAvatarView invoke() {
                ViewGroup p16;
                p16 = GuildReplyComponent.this.p1();
                GuildUserAvatarView guildUserAvatarView = (GuildUserAvatarView) p16.findViewById(R.id.f96875iv);
                guildUserAvatarView.setRoundRect(com.tencent.guild.aio.util.c.b(3));
                return guildUserAvatarView;
            }
        });
        this.imageView1 = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<GuildUserAvatarView>() { // from class: com.tencent.guild.aio.msglist.reply.GuildReplyComponent$imageView2$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final GuildUserAvatarView invoke() {
                ViewGroup p16;
                p16 = GuildReplyComponent.this.p1();
                GuildUserAvatarView guildUserAvatarView = (GuildUserAvatarView) p16.findViewById(R.id.f96905iy);
                guildUserAvatarView.setRoundRect(com.tencent.guild.aio.util.c.b(3));
                return guildUserAvatarView;
            }
        });
        this.imageView2 = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(new Function0<GuildUserAvatarView>() { // from class: com.tencent.guild.aio.msglist.reply.GuildReplyComponent$imageView3$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final GuildUserAvatarView invoke() {
                ViewGroup p16;
                p16 = GuildReplyComponent.this.p1();
                GuildUserAvatarView guildUserAvatarView = (GuildUserAvatarView) p16.findViewById(R.id.f96935j1);
                guildUserAvatarView.setRoundRect(com.tencent.guild.aio.util.c.b(3));
                return guildUserAvatarView;
            }
        });
        this.imageView3 = lazy8;
        lazy9 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.guild.aio.msglist.reply.GuildReplyComponent$tvPicNum$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                ViewGroup p16;
                p16 = GuildReplyComponent.this.p1();
                return (TextView) p16.findViewById(R.id.f110016hd);
            }
        });
        this.tvPicNum = lazy9;
        lazy10 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.guild.aio.msglist.reply.GuildReplyComponent$playView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                ViewGroup p16;
                p16 = GuildReplyComponent.this.p1();
                return (ImageView) p16.findViewById(R.id.f25750bo);
            }
        });
        this.playView = lazy10;
        lazy11 = LazyKt__LazyJVMKt.lazy(new Function0<ViewGroup>() { // from class: com.tencent.guild.aio.msglist.reply.GuildReplyComponent$thumbContainer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewGroup invoke() {
                ViewGroup p16;
                p16 = GuildReplyComponent.this.p1();
                return (ViewGroup) p16.findViewById(R.id.f96985j6);
            }
        });
        this.thumbContainer = lazy11;
        lazy12 = LazyKt__LazyJVMKt.lazy(new Function0<Drawable>() { // from class: com.tencent.guild.aio.msglist.reply.GuildReplyComponent$selfArrowDrawable$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Drawable invoke() {
                Context context = GuildReplyComponent.this.getRoot().getContext();
                Intrinsics.checkNotNullExpressionValue(context, "root.context");
                Context context2 = GuildReplyComponent.this.getRoot().getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "root.context");
                return GuildUIUtils.y(context, R.drawable.guild_reply_icon_white, iq0.a.k(context2, false, 2, null));
            }
        });
        this.selfArrowDrawable = lazy12;
        lazy13 = LazyKt__LazyJVMKt.lazy(new Function0<Drawable>() { // from class: com.tencent.guild.aio.msglist.reply.GuildReplyComponent$otherArrowDrawable$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Drawable invoke() {
                Context context = GuildReplyComponent.this.getRoot().getContext();
                Intrinsics.checkNotNullExpressionValue(context, "root.context");
                Context context2 = GuildReplyComponent.this.getRoot().getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "root.context");
                return GuildUIUtils.y(context, R.drawable.guild_reply_icon_white, iq0.a.g(context2, false, 2, null));
            }
        });
        this.otherArrowDrawable = lazy13;
        this.mSourceMsgText = "";
    }

    private final TextView A1() {
        Object value = this.sourceMsgCntTextView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-sourceMsgCntTextView>(...)");
        return (TextView) value;
    }

    private final TextView B1() {
        Object value = this.sourceMsgTextView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-sourceMsgTextView>(...)");
        return (TextView) value;
    }

    private final View C1() {
        Object value = this.sourceSeparateLineView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-sourceSeparateLineView>(...)");
        return (View) value;
    }

    private final ViewGroup D1() {
        Object value = this.thumbContainer.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-thumbContainer>(...)");
        return (ViewGroup) value;
    }

    private final ViewGroup E1() {
        Object value = this.thumbLayout.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-thumbLayout>(...)");
        return (ViewGroup) value;
    }

    private final TextView F1() {
        Object value = this.tvPicNum.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-tvPicNum>(...)");
        return (TextView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G1(GuildMsgItem msgItem, ReplyElement replyElement, MsgRecord replyMsgRecord) {
        if (replyMsgRecord == null) {
            QLog.d("ReplyContentComponent", 1, "handleGetReplyMsgRecordResult replyMsgRecord is null. msgId = " + msgItem.getMsgId() + " msgSeq = " + msgItem.getMsgSeq() + " replyMsgSeq = " + replyElement.replayMsgSeq);
        }
        if (replyMsgRecord != null) {
            this.mReplyMsgRevoked = com.tencent.guild.aio.util.ex.d.a(replyMsgRecord);
            this.mReplyMsgSenderId = replyMsgRecord.senderUid;
            if (msgItem.getMsgRecord().directMsgFlag == 1) {
                P1(msgItem.isSelf(), null);
            } else {
                P1(msgItem.isSelf(), replyElement.replayMsgRootCommentCnt);
            }
            Q1(msgItem.isSelf(), iq0.a.m(String.valueOf(replyElement.senderUid), com.tencent.guild.aio.util.ex.f.a(msgItem), replyMsgRecord), iq0.a.r(getMContext(), replyMsgRecord, replyElement, y1(), false, 16, null));
            S1(replyMsgRecord);
        }
    }

    private final void H1(final GuildMsgItem msgItem, final ReplyElement replyElement) {
        QLog.d("ReplyContentComponent", 1, "handleGuestReplyLogic msgItem msgId = " + msgItem.getMsgId() + " msgSeq = " + msgItem.getMsgSeq());
        P1(msgItem.isSelf(), null);
        final String n3 = iq0.a.n(String.valueOf(replyElement.senderUid), com.tencent.guild.aio.util.ex.f.a(msgItem), null, 4, null);
        ((IMsgService) QRoute.api(IMsgService.class)).getGuestMsgByRange(new Contact(msgItem.getMsgRecord().chatType, msgItem.getMsgRecord().peerUid, com.tencent.guild.aio.util.ex.f.a(msgItem)), replyElement.replayMsgSeq.longValue() + 1, 1, true, new Random().nextInt(), new IGuestMsgOperateCallback() { // from class: com.tencent.guild.aio.msglist.reply.g
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGuestMsgOperateCallback
            public final void onResult(int i3, String str, ArrayList arrayList, HashMap hashMap) {
                GuildReplyComponent.I1(GuildMsgItem.this, this, replyElement, n3, i3, str, arrayList, hashMap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I1(final GuildMsgItem msgItem, final GuildReplyComponent this$0, final ReplyElement replyElement, final String replyNickName, int i3, String str, ArrayList msgList, HashMap hashMap) {
        boolean z16;
        Object obj;
        boolean z17;
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(replyElement, "$replyElement");
        Intrinsics.checkNotNullParameter(replyNickName, "$replyNickName");
        QLog.i("ReplyContentComponent", 1, "getGuestMsgByRange result=" + i3 + " errMsg=" + str);
        GuildMsgItem guildMsgItem = this$0.mCurrentMsgItem;
        if (guildMsgItem != null && msgItem.getMsgId() == guildMsgItem.getMsgId()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Intrinsics.checkNotNullExpressionValue(msgList, "msgList");
            Iterator it = msgList.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    long j3 = ((MsgRecord) obj).msgSeq;
                    Long l3 = replyElement.replayMsgSeq;
                    if (l3 != null && j3 == l3.longValue()) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            final MsgRecord msgRecord = (MsgRecord) obj;
            if (msgRecord != null) {
                C11736d.c(new Function0<Unit>() { // from class: com.tencent.guild.aio.msglist.reply.GuildReplyComponent$handleGuestReplyLogic$1$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        ArrayList y16;
                        GuildReplyComponent guildReplyComponent = GuildReplyComponent.this;
                        boolean isSelf = msgItem.isSelf();
                        String str2 = replyNickName;
                        Context mContext = GuildReplyComponent.this.getMContext();
                        MsgRecord msgRecord2 = msgRecord;
                        ReplyElement replyElement2 = replyElement;
                        y16 = GuildReplyComponent.this.y1();
                        guildReplyComponent.Q1(isSelf, str2, iq0.a.r(mContext, msgRecord2, replyElement2, y16, false, 16, null));
                        GuildReplyComponent.this.S1(msgRecord);
                    }
                });
            }
        }
    }

    private final void J1(final GuildMsgItem msgItem, final ReplyElement replyElement) {
        Contact contact = new Contact(msgItem.getMsgRecord().chatType, msgItem.getMsgRecord().peerUid, com.tencent.guild.aio.util.ex.f.a(msgItem));
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(replyElement.replayMsgSeq);
        QLog.d("ReplyContentComponent", 1, "handleNormalReplyLogic msgItem msgId = " + msgItem.getMsgId() + " msgSeq = " + msgItem.getMsgSeq() + " replyMsgSeq = " + replyElement.replayMsgSeq);
        MsgRecord x16 = x1(msgItem, replyElement);
        if (x16 != null) {
            G1(msgItem, replyElement, x16);
        } else {
            ((IMsgService) QRoute.api(IMsgService.class)).getMsgsBySeqs(contact, arrayList, new IMsgOperateCallback() { // from class: com.tencent.guild.aio.msglist.reply.f
                @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
                public final void onResult(int i3, String str, ArrayList arrayList2) {
                    GuildReplyComponent.K1(GuildMsgItem.this, replyElement, this, i3, str, arrayList2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K1(final GuildMsgItem msgItem, final ReplyElement replyElement, final GuildReplyComponent this$0, int i3, String str, ArrayList msgList) {
        boolean z16;
        Object obj;
        boolean z17;
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        Intrinsics.checkNotNullParameter(replyElement, "$replyElement");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("ReplyContentComponent", 1, "getMsgsBySeqs result: " + i3 + ", errMsg: " + str + ", msgItem msgId = " + msgItem.getMsgId() + " msgSeq = " + msgItem.getMsgSeq() + " replyMsgSeq = " + replyElement.replayMsgSeq);
        GuildMsgItem guildMsgItem = this$0.mCurrentMsgItem;
        if (guildMsgItem != null && msgItem.getMsgId() == guildMsgItem.getMsgId()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Intrinsics.checkNotNullExpressionValue(msgList, "msgList");
            Iterator it = msgList.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    long j3 = ((MsgRecord) obj).msgSeq;
                    Long l3 = replyElement.replayMsgSeq;
                    if (l3 != null && j3 == l3.longValue()) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            final MsgRecord msgRecord = (MsgRecord) obj;
            C11736d.c(new Function0<Unit>() { // from class: com.tencent.guild.aio.msglist.reply.GuildReplyComponent$handleNormalReplyLogic$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    GuildReplyComponent.this.G1(msgItem, replyElement, msgRecord);
                }
            });
        }
    }

    private final void L1(String tinyId) {
        ReplyElement w16;
        GuildMsgItem guildMsgItem = this.mCurrentMsgItem;
        if (guildMsgItem != null && Intrinsics.areEqual(this.mReplyMsgSenderId, tinyId) && !this.mReplyMsgRevoked && (w16 = w1(guildMsgItem)) != null) {
            String n3 = iq0.a.n(String.valueOf(w16.senderUid), com.tencent.guild.aio.util.ex.f.a(guildMsgItem), null, 4, null);
            QLog.d("ReplyContentComponent", 1, "handleReplyMsgNickNameChanged replyNickName = " + n3);
            String str = this.mSourceMsgText;
            if (str != null) {
                Q1(guildMsgItem.isSelf(), n3, str);
            }
        }
    }

    private final void M1() {
        this.mReplyMsgRevoked = true;
        GuildMsgItem guildMsgItem = this.mCurrentMsgItem;
        if (guildMsgItem != null) {
            String string = getMContext().getString(R.string.f153011ay);
            Intrinsics.checkNotNullExpressionValue(string, "mContext.getString(R.str\u2026_reply_source_msg_revoke)");
            S1(null);
            Q1(guildMsgItem.isSelf(), "", string);
        }
    }

    private final void N1(long seq) {
        Long l3;
        GuildMsgItem guildMsgItem = this.mCurrentMsgItem;
        if (guildMsgItem != null) {
            ReplyElement w16 = w1(guildMsgItem);
            boolean z16 = false;
            if (w16 != null && (l3 = w16.replayMsgSeq) != null && l3.longValue() == seq) {
                z16 = true;
            }
            if (z16) {
                String string = getMContext().getString(R.string.f153001ax);
                Intrinsics.checkNotNullExpressionValue(string, "mContext.getString(R.str\u2026_reply_source_msg_delete)");
                S1(null);
                Q1(guildMsgItem.isSelf(), "", string);
            }
        }
    }

    private final boolean O1(GuildMsgItem msgItem, List<Object> payloads) {
        Long l3;
        Long l16;
        GuildMsgItem guildMsgItem = this.mCurrentMsgItem;
        if (guildMsgItem != null) {
            Intrinsics.checkNotNull(guildMsgItem);
            if (guildMsgItem.isSameItem(msgItem)) {
                boolean z16 = true;
                for (Object obj : payloads) {
                    if (obj instanceof HashMap) {
                        Map map = (Map) obj;
                        Long l17 = null;
                        if (map.get(GuildMsgItemPayloadType.REPLAY_MSG_COMMENT_COUNT_PAYLOAD) != null && msgItem.getMsgRecord().directMsgFlag != 1) {
                            IGuildChannelApi iGuildChannelApi = (IGuildChannelApi) QRoute.api(IGuildChannelApi.class);
                            String str = msgItem.getMsgRecord().channelId;
                            Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.channelId");
                            if (!iGuildChannelApi.isSelfGuest(str, com.tencent.guild.aio.util.ex.f.a(msgItem))) {
                                ReplyElement w16 = w1(msgItem);
                                if (w16 != null) {
                                    l16 = w16.replayMsgRootCommentCnt;
                                } else {
                                    l16 = null;
                                }
                                P1(msgItem.isSelf(), l16);
                                QLog.d("ReplyContentComponent", 1, "REPLAY_MSG_COMMENT_COUNT_PAYLOAD msgId" + msgItem.getMsgId() + " msgSeq" + msgItem.getMsgSeq() + " commentCount = " + l16);
                            }
                        }
                        if (map.get(GuildMsgItemPayloadType.REPLY_MSG_REVOKED_PAYLOAD) != null) {
                            M1();
                            GuildMsgItem guildMsgItem2 = this.mCurrentMsgItem;
                            if (guildMsgItem2 != null) {
                                l3 = Long.valueOf(guildMsgItem2.getMsgId());
                            } else {
                                l3 = null;
                            }
                            GuildMsgItem guildMsgItem3 = this.mCurrentMsgItem;
                            if (guildMsgItem3 != null) {
                                l17 = Long.valueOf(guildMsgItem3.getMsgSeq());
                            }
                            QLog.d("ReplyContentComponent", 1, "REPLY_MSG_REVOKED_PAYLOAD msgId" + l3 + " msgSeq" + l17 + " revoked!");
                        }
                        z16 = false;
                    }
                }
                return z16;
            }
        }
        return true;
    }

    private final void P1(boolean isSelf, Long commentCount) {
        Long l3;
        Long l16;
        long longValue;
        GuildMsgItem guildMsgItem = this.mCurrentMsgItem;
        if (guildMsgItem != null) {
            l3 = Long.valueOf(guildMsgItem.getMsgId());
        } else {
            l3 = null;
        }
        GuildMsgItem guildMsgItem2 = this.mCurrentMsgItem;
        if (guildMsgItem2 != null) {
            l16 = Long.valueOf(guildMsgItem2.getMsgSeq());
        } else {
            l16 = null;
        }
        QLog.d("ReplyContentComponent", 1, "setCommentCount msgId = " + l3 + " msgSeq = " + l16 + " isSelf = " + isSelf + " commentCount = " + commentCount);
        if (commentCount == null) {
            A1().setVisibility(8);
            C1().setVisibility(8);
            ViewGroup.LayoutParams layoutParams = B1().getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = 0;
            layoutParams2.baselineToBaseline = R.id.f73283t5;
            return;
        }
        A1().setVisibility(0);
        C1().setVisibility(0);
        TextView A1 = A1();
        if (commentCount.longValue() == 0) {
            longValue = 1;
        } else {
            longValue = commentCount.longValue();
        }
        A1.setText(String.valueOf(longValue));
        boolean A = UIUtil.f112434a.A();
        if (isSelf) {
            A1().setTextColor(iq0.a.j(getMContext(), A));
            C1().setBackgroundColor(iq0.a.h(getMContext(), A));
            A1().setCompoundDrawablesWithIntrinsicBounds(z1(), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            A1().setTextColor(iq0.a.f(getMContext(), A));
            C1().setBackgroundColor(iq0.a.d(getMContext(), A));
            A1().setCompoundDrawablesWithIntrinsicBounds(u1(), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        ViewGroup.LayoutParams layoutParams3 = B1().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
        ((ViewGroup.MarginLayoutParams) layoutParams4).leftMargin = wr0.a.f446116a.b(6);
        layoutParams4.baselineToBaseline = R.id.vy7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q1(boolean isSelf, String replyNickName, String sourceMsgText) {
        this.mSourceMsgText = sourceMsgText.toString();
        B1().setText(((IGuildEmojiApi) QRoute.api(IGuildEmojiApi.class)).parseQQText(replyNickName + sourceMsgText, 16));
        B1().setVisibility(0);
        B1().setTextColor(iq0.a.s(getMContext(), isSelf));
    }

    private final void R1(MsgRecord replyMsgRecord, List<MsgElement> elementList, int picNum, List<String> pathList) {
        int i3;
        ArrayList arrayListOf;
        int i16 = picNum;
        if (i16 > 3) {
            i3 = 3;
        } else {
            i3 = i16;
        }
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(q1(), r1(), s1());
        for (int i17 = 0; i17 < i3; i17++) {
            Object obj = arrayListOf.get(i17);
            Intrinsics.checkNotNullExpressionValue(obj, "imageViewList[index]");
            GuildUserAvatarView guildUserAvatarView = (GuildUserAvatarView) obj;
            GuildChatPicDownloader.v(GuildChatPicDownloader.f112420a, new GuildImageOptions(pathList.get(i17), guildUserAvatarView, false, guildUserAvatarView.getLayoutParams().width, guildUserAvatarView.getLayoutParams().height, UIUtil.t(guildUserAvatarView.getLayoutParams().width, guildUserAvatarView.getLayoutParams().height), UIUtil.u(guildUserAvatarView.getLayoutParams().width, guildUserAvatarView.getLayoutParams().height)).e(), PicSize.PIC_DOWNLOAD_AIO, elementList.get(i17), replyMsgRecord, 0, null, 48, null);
            guildUserAvatarView.setVisibility(0);
        }
        E1().setVisibility(0);
        v1().setVisibility(8);
        if (i16 > 3) {
            D1().setVisibility(0);
            v1().setVisibility(8);
            F1().setVisibility(0);
            F1().setText(Marker.ANY_NON_NULL_MARKER + (i16 - 3));
            return;
        }
        if (i16 == 3) {
            D1().setVisibility(0);
            v1().setVisibility(8);
            F1().setVisibility(8);
        } else {
            while (i16 < 3) {
                ((View) arrayListOf.get(i16)).setVisibility(8);
                i16++;
            }
            D1().setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S1(MsgRecord replyMsgRecord) {
        int i3;
        if (replyMsgRecord == null) {
            E1().setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i16 = 0;
        if (MsgExtKt.P(replyMsgRecord)) {
            ArrayList<MsgElement> arrayList3 = replyMsgRecord.elements;
            Intrinsics.checkNotNullExpressionValue(arrayList3, "replyMsgRecord.elements");
            int i17 = 0;
            i3 = 0;
            for (MsgElement it : arrayList3) {
                int i18 = it.elementType;
                if (i18 != 2) {
                    if (i18 == 5) {
                        i3++;
                        arrayList2.add(it);
                        QRouteApi api = QRoute.api(IGuildVideoApi.class);
                        Intrinsics.checkNotNullExpressionValue(api, "api(IGuildVideoApi::class.java)");
                        arrayList.add(IGuildVideoApi.a.c((IGuildVideoApi) api, replyMsgRecord, false, 2, null));
                    }
                } else {
                    i17++;
                    arrayList2.add(it);
                    GuildChatPicDownloader guildChatPicDownloader = GuildChatPicDownloader.f112420a;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    arrayList.add(guildChatPicDownloader.q(it, PicSize.PIC_DOWNLOAD_AIO));
                }
            }
            i16 = i17;
        } else {
            i3 = 0;
        }
        if (i16 > 0) {
            R1(replyMsgRecord, arrayList2, i16, arrayList);
        } else if (i3 > 0) {
            T1(replyMsgRecord, arrayList2, i16, arrayList);
        } else {
            E1().setVisibility(8);
        }
    }

    private final void T1(MsgRecord replyMsgRecord, List<MsgElement> elementList, int videoNum, List<String> pathList) {
        GuildUserAvatarView s16 = s1();
        GuildChatPicDownloader.v(GuildChatPicDownloader.f112420a, new GuildImageOptions(pathList.get(0), s16, false, s16.getLayoutParams().width, s16.getLayoutParams().height, UIUtil.t(s16.getLayoutParams().width, s16.getLayoutParams().height), UIUtil.u(s16.getLayoutParams().width, s16.getLayoutParams().height)).e(), PicSize.PIC_DOWNLOAD_THUMB, elementList.get(0), replyMsgRecord, 0, null, 48, null);
        s16.setVisibility(0);
        q1().setVisibility(8);
        r1().setVisibility(8);
        E1().setVisibility(0);
        D1().setVisibility(0);
        v1().setVisibility(0);
        F1().setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ViewGroup p1() {
        return (ViewGroup) this.contentView.getValue();
    }

    private final GuildUserAvatarView q1() {
        Object value = this.imageView1.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-imageView1>(...)");
        return (GuildUserAvatarView) value;
    }

    private final GuildUserAvatarView r1() {
        Object value = this.imageView2.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-imageView2>(...)");
        return (GuildUserAvatarView) value;
    }

    private final GuildUserAvatarView s1() {
        Object value = this.imageView3.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-imageView3>(...)");
        return (GuildUserAvatarView) value;
    }

    private final Drawable u1() {
        return (Drawable) this.otherArrowDrawable.getValue();
    }

    private final ImageView v1() {
        Object value = this.playView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-playView>(...)");
        return (ImageView) value;
    }

    private final ReplyElement w1(GuildMsgItem msgItem) {
        ReplyElement replyElement;
        ArrayList<MsgElement> arrayList = msgItem.getMsgRecord().elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgItem.msgRecord.elements");
        for (MsgElement msgElement : arrayList) {
            if (msgElement.elementType == 7 && (replyElement = msgElement.replyElement) != null) {
                return replyElement;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0054 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[LOOP:0: B:9:0x0027->B:25:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final MsgRecord x1(GuildMsgItem msgItem, ReplyElement replyElement) {
        boolean z16;
        boolean z17;
        ArrayList<MsgRecord> arrayList = msgItem.getMsgRecord().records;
        if (arrayList != null && !arrayList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        Object obj = null;
        if (z16) {
            return null;
        }
        ArrayList<MsgRecord> arrayList2 = msgItem.getMsgRecord().records;
        Intrinsics.checkNotNullExpressionValue(arrayList2, "msgItem.msgRecord.records");
        Iterator<T> it = arrayList2.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            MsgRecord it5 = (MsgRecord) next;
            long j3 = it5.msgSeq;
            Long l3 = replyElement.replayMsgSeq;
            if (l3 != null && j3 == l3.longValue()) {
                Intrinsics.checkNotNullExpressionValue(it5, "it");
                if (MsgExtKt.R(it5)) {
                    z17 = true;
                    if (!z17) {
                        obj = next;
                        break;
                    }
                }
            }
            z17 = false;
            if (!z17) {
            }
        }
        return (MsgRecord) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ArrayList<Integer> y1() {
        ArrayList<Integer> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(1, 6, 14, 3, 9, 10, 11);
        return arrayListOf;
    }

    private final Drawable z1() {
        return (Drawable) this.selfArrowDrawable.getValue();
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        GuildMsgItem guildMsgItem = (GuildMsgItem) msgItem;
        if (!O1(guildMsgItem, payloads)) {
            this.mCurrentMsgItem = guildMsgItem;
            return;
        }
        B1().setVisibility(4);
        this.mCurrentMsgItem = guildMsgItem;
        this.mReplyMsgSenderId = "";
        this.mReplyMsgRevoked = false;
        this.mSourceMsgText = "";
        ReplyElement w16 = w1(guildMsgItem);
        if (w16 != null) {
            QLog.d("ReplyContentComponent", 1, "bind All msgSeq = " + msgItem.getMsgSeq() + " msgId = " + msgItem.getMsgId(), "commentCount = " + w16.replayMsgRootCommentCnt);
            IGuildChannelApi iGuildChannelApi = (IGuildChannelApi) QRoute.api(IGuildChannelApi.class);
            GuildMsgItem guildMsgItem2 = (GuildMsgItem) msgItem;
            String str = guildMsgItem2.getMsgRecord().channelId;
            Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.channelId");
            if (iGuildChannelApi.isSelfGuest(str, com.tencent.guild.aio.util.ex.f.a(guildMsgItem2))) {
                H1(guildMsgItem2, w16);
            } else {
                J1(guildMsgItem2, w16);
            }
        }
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public View d1() {
        return p1();
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a, com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    /* renamed from: e1 */
    public com.tencent.aio.base.mvvm.b<ol3.b, MviUIState> createVM() {
        return new h();
    }

    @NotNull
    public final View getRoot() {
        return this.root;
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public String getTag() {
        return "ReplyContentComponent";
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    public void handleUIState(@NotNull MviUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof GuildReplyMsgNickState) {
            String tinyId = ((GuildReplyMsgNickState) state).getTinyId();
            if (tinyId != null) {
                L1(tinyId);
                return;
            }
            return;
        }
        if (state instanceof GuildReplyMsgState.DeleteSourceMsgState) {
            N1(((GuildReplyMsgState.DeleteSourceMsgState) state).getSeq());
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        View containerView = getContainerView();
        Intrinsics.checkNotNull(containerView);
        return containerView;
    }
}

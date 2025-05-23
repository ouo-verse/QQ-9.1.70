package com.tencent.guild.aio.msglist.pic;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.guild.aio.util.ui.RoundBubbleImageView;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0001\u0015Bx\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u001a\u001a\u00020\u0013\u0012M\u0010(\u001aI\u0012\u0013\u0012\u00110\u001d\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0015\u0012\u0013\u0018\u00010!\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110#\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u000b0\u001c\u00a2\u0006\u0004\b4\u00105J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0014\u001a\u00020\u0013R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001a\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR^\u0010(\u001aI\u0012\u0013\u0012\u00110\u001d\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0015\u0012\u0013\u0018\u00010!\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110#\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u000b0\u001c8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010%\u001a\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010)R\u0018\u0010,\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010+R\u001b\u00100\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010-\u001a\u0004\b.\u0010/R\u0016\u00103\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u00102\u00a8\u00066"}, d2 = {"Lcom/tencent/guild/aio/msglist/pic/GuildPicViewer;", "", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "Landroid/view/ViewGroup;", "contentView", "d", "Landroid/content/Context;", "context", "Lcom/tencent/guild/aio/util/ui/RoundBubbleImageView;", "c", "", "e", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "fileInfo", h.F, "", "i", "a", "Landroid/view/ViewGroup;", "f", "()Landroid/view/ViewGroup;", "Z", "isMultiSelect", "()Z", "Lkotlin/Function3;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "Lkotlin/ParameterName;", "name", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/PicElement;", "picElement", "Landroid/view/View;", "clickedView", "Lkotlin/jvm/functions/Function3;", "getListener", "()Lkotlin/jvm/functions/Function3;", "listener", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "currentMsgItem", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", DTConstants.TAG.ELEMENT, "Lkotlin/Lazy;", "g", "()Lcom/tencent/guild/aio/util/ui/RoundBubbleImageView;", "picView", "", "J", "applyCalledWithElemId", "<init>", "(Lcom/tencent/guild/api/data/msglist/GuildMsgItem;Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;Landroid/view/ViewGroup;ZLkotlin/jvm/functions/Function3;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildPicViewer {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewGroup contentView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean isMultiSelect;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function3<MsgRecord, PicElement, View, Unit> listener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GuildMsgItem currentMsgItem;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MsgElement element;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy picView;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private long applyCalledWithElemId;

    /* JADX WARN: Multi-variable type inference failed */
    public GuildPicViewer(@NotNull GuildMsgItem msgItem, @Nullable MsgElement msgElement, @NotNull ViewGroup contentView, boolean z16, @NotNull Function3<? super MsgRecord, ? super PicElement, ? super View, Unit> listener) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.contentView = contentView;
        this.isMultiSelect = z16;
        this.listener = listener;
        this.currentMsgItem = msgItem;
        this.element = msgElement;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RoundBubbleImageView>() { // from class: com.tencent.guild.aio.msglist.pic.GuildPicViewer$picView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RoundBubbleImageView invoke() {
                RoundBubbleImageView c16;
                GuildPicViewer guildPicViewer = GuildPicViewer.this;
                Context context = guildPicViewer.getContentView().getContext();
                Intrinsics.checkNotNullExpressionValue(context, "contentView.context");
                c16 = guildPicViewer.c(context);
                return c16;
            }
        });
        this.picView = lazy;
        d(this.currentMsgItem, contentView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RoundBubbleImageView c(Context context) {
        boolean z16;
        RoundBubbleImageView roundBubbleImageView = new RoundBubbleImageView(context);
        if (this.currentMsgItem.getRadii().length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && !this.currentMsgItem.isMixMsg()) {
            roundBubbleImageView.setRadii(this.currentMsgItem.getRadii());
        } else {
            roundBubbleImageView.setRadiusDP(6.0f);
        }
        return roundBubbleImageView;
    }

    private final ViewGroup d(GuildMsgItem msgItem, ViewGroup contentView) {
        PicElement picElement;
        MsgElement msgElement = this.element;
        if (msgElement != null && (picElement = msgElement.picElement) != null) {
            if (QLog.isColorLevel()) {
                QLog.i("GUILD_MSGPIC.PicViewer", 2, "picSubType=" + picElement.picSubType);
            }
            e(msgItem, contentView);
        }
        return contentView;
    }

    private final void e(GuildMsgItem msgItem, ViewGroup contentView) {
        if (contentView.getChildCount() > 0) {
            contentView.removeAllViews();
        }
        MsgElement msgElement = this.element;
        if (msgElement != null) {
            UIUtil.f112434a.b(msgElement, msgItem, g(), msgItem.isMixMsg(), this.isMultiSelect, this.listener);
            this.applyCalledWithElemId = msgElement.elementId;
        }
        g().setContentDescription(contentView.getContext().getString(R.string.f1385809y));
        contentView.addView(g());
    }

    private final RoundBubbleImageView g() {
        return (RoundBubbleImageView) this.picView.getValue();
    }

    public final void b(@Nullable MsgElement msgElement, @NotNull GuildMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (QLog.isColorLevel()) {
            QLog.d("GUILD_MSGPIC.PicViewer", 2, "[bind] newMsgId = " + msgItem.getMsgId() + ", newMsgSeq: " + msgItem.getMsgSeq() + ", oldMsgSeq: " + this.currentMsgItem.getMsgSeq());
        }
        this.element = msgElement;
        this.currentMsgItem = msgItem;
        if (msgElement != null) {
            UIUtil.f112434a.c(msgElement, msgItem, g(), msgItem.isMixMsg(), this.isMultiSelect, this.listener);
            this.applyCalledWithElemId = msgElement.elementId;
        }
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final ViewGroup getContentView() {
        return this.contentView;
    }

    public final void h(@NotNull FileTransNotifyInfo fileInfo) {
        boolean z16;
        Intrinsics.checkNotNullParameter(fileInfo, "fileInfo");
        MsgElement msgElement = this.element;
        boolean z17 = true;
        if (msgElement != null && fileInfo.msgElementId == msgElement.elementId) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("GUILD_MSGPIC.PicViewer", 2, "[handleRichMediaUI] , fileTransNotifyInfo = " + fileInfo);
        }
        if (fileInfo.trasferStatus == 4) {
            MsgElement msgElement2 = this.element;
            if (msgElement2 == null || this.applyCalledWithElemId != msgElement2.elementId) {
                z17 = false;
            }
            if (!z17 && msgElement2 != null) {
                UIUtil uIUtil = UIUtil.f112434a;
                Intrinsics.checkNotNull(msgElement2);
                uIUtil.b(msgElement2, this.currentMsgItem, g(), this.currentMsgItem.isMixMsg(), this.isMultiSelect, this.listener);
            }
        }
    }

    public final boolean i() {
        Object tag = g().getTag(R.id.vxy);
        if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
            QLog.d("GUILD_MSGPIC.PicViewer", 1, "[isPicDownloaded] = false. msgId = " + this.currentMsgItem.getMsgId() + ", msgSeq: " + this.currentMsgItem.getMsgSeq() + ", view: " + g().hashCode());
            return true;
        }
        return false;
    }
}

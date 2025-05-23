package com.tencent.robot.aio.actionbar;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.FeedBackDataForMsg;
import com.tencent.qqnt.kernel.nativeinterface.FeedBackMsgInfo;
import com.tencent.qqnt.kernel.nativeinterface.FeedBackStateInfo;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.InlineKeyboardButton;
import com.tencent.qqnt.kernel.nativeinterface.MsgAttributeInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.util.QQToastUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\"B/\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0010\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u0015\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00108\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006#"}, d2 = {"Lcom/tencent/robot/aio/actionbar/d;", "Lcom/tencent/qqnt/aio/menu/ui/d;", "", "f", "", "c", "", h.F, "b", "e", "Landroid/content/Context;", "d", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lcom/tencent/qqnt/kernel/nativeinterface/InlineKeyboardButton;", "Lcom/tencent/qqnt/kernel/nativeinterface/InlineKeyboardButton;", "getButton", "()Lcom/tencent/qqnt/kernel/nativeinterface/InlineKeyboardButton;", "button", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "getOnClick", "()Lkotlin/jvm/functions/Function0;", NodeProps.ON_CLICK, "", "g", "Z", "isDisLike", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;Lcom/tencent/qqnt/kernel/nativeinterface/InlineKeyboardButton;Lkotlin/jvm/functions/Function0;)V", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class d extends com.tencent.qqnt.aio.menu.ui.d {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final InlineKeyboardButton button;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<Unit> onClick;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean isDisLike;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull Context context, @NotNull AIOMsgItem msgItem, @Nullable InlineKeyboardButton inlineKeyboardButton, @NotNull Function0<Unit> onClick) {
        super(msgItem);
        Integer num;
        int i3;
        FeedBackStateInfo feedBackStateInfo;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.context = context;
        this.button = inlineKeyboardButton;
        this.onClick = onClick;
        MsgAttributeInfo msgAttributeInfo = msgItem.getMsgRecord().msgAttrs.get(17);
        if (msgAttributeInfo != null && (feedBackStateInfo = msgAttributeInfo.feedBackStateInfo) != null) {
            num = Integer.valueOf(feedBackStateInfo.likeOrDislike);
        } else {
            num = null;
        }
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = 0;
        }
        this.isDisLike = i3 == 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(d this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("RobotDislikeMenuItem", 1, "[getMemberInfo]: result is " + i3 + ", errMsg is " + str);
        if (i3 != 0) {
            QQToastUtil.showQQToastInUiThread(0, this$0.context.getString(R.string.yfn));
        } else {
            QQToastUtil.showQQToastInUiThread(2, "\u53cd\u9988\u5df2\u6536\u5230");
        }
    }

    @Override // com.tencent.qqnt.aio.menu.ui.d
    public int b() {
        if (this.isDisLike) {
            return R.drawable.qui_dislike_filled_allwhite_primary;
        }
        return R.drawable.qui_dislike_icon;
    }

    @Override // com.tencent.qqnt.aio.menu.ui.d
    public int c() {
        return R.id.z4c;
    }

    @Override // com.tencent.qqnt.aio.menu.ui.d
    @NotNull
    public String e() {
        return "RobotDislikeMenuItem";
    }

    @Override // com.tencent.qqnt.aio.menu.ui.d
    @NotNull
    /* renamed from: f */
    public String getTitle() {
        String string = this.context.getString(R.string.f222316d7);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.robot_dislike)");
        return string;
    }

    @Override // com.tencent.qqnt.aio.menu.ui.d
    public void h() {
        String str;
        MsgRecord msgRecord = d().getMsgRecord();
        String str2 = "";
        Contact contact = new Contact(msgRecord.chatType, msgRecord.peerUid, "");
        FeedBackMsgInfo feedBackMsgInfo = new FeedBackMsgInfo(msgRecord.msgId, msgRecord.msgRandom, msgRecord.msgSeq, msgRecord.clientSeq);
        boolean z16 = !this.isDisLike;
        InlineKeyboardButton inlineKeyboardButton = this.button;
        if (inlineKeyboardButton != null) {
            str = inlineKeyboardButton.data;
        } else {
            str = null;
        }
        if (str != null) {
            str2 = str;
        }
        ((IMsgService) QRoute.api(IMsgService.class)).likeOrDislikeReportForMsg(contact, feedBackMsgInfo, new FeedBackDataForMsg(2, z16, str2), new IOperateCallback() { // from class: com.tencent.robot.aio.actionbar.c
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str3) {
                d.j(d.this, i3, str3);
            }
        });
        this.onClick.invoke();
    }
}

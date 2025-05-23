package com.tencent.guild.aio.msglist.holder.component;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.guild.aio.factory.business.holder.msglist.a;
import com.tencent.guild.aio.util.aa;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.guild.aio.util.x;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.data.msglist.GuildMsgItemPayloadType;
import com.tencent.guild.api.data.msglist.b;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 42\u00020\u0001:\u0001VB\u000f\u0012\u0006\u0010S\u001a\u00020%\u00a2\u0006\u0004\bT\u0010UJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\bH\u0002J\b\u0010\u000f\u001a\u00020\bH\u0002J'\u0010\u0014\u001a\u00020\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\u0012H\u0002J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0012H\u0002J\b\u0010\u001a\u001a\u00020\bH\u0002J\b\u0010\u001b\u001a\u00020\bH\u0002J\b\u0010\u001c\u001a\u00020\bH\u0002J\u0016\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001dH\u0016J&\u0010$\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\"2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\b\u0010&\u001a\u00020%H\u0016J\u0010\u0010)\u001a\u00020%2\u0006\u0010(\u001a\u00020'H\u0016J\b\u0010+\u001a\u00020*H\u0016R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00102\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00105\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u001c\u00109\u001a\n 6*\u0004\u0018\u00010%0%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010=\u001a\u00020:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010A\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@R#\u0010F\u001a\n 6*\u0004\u0018\u00010\u00100\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u001d\u0010I\u001a\u0004\u0018\u00010\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bG\u0010C\u001a\u0004\bH\u0010ER\u001b\u0010N\u001a\u00020J8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bK\u0010C\u001a\u0004\bL\u0010MR\u0014\u0010R\u001a\u00020O8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bP\u0010Q\u00a8\u0006W"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/component/GuildBubbleMsgStatusComponent;", "Lcom/tencent/guild/aio/msglist/holder/component/a;", "", "", "payloads", "", ICustomDataEditor.STRING_PARAM_1, "payload", "", "H1", "w1", "u1", "y1", Constants.APK_CERTIFICATE, "o1", "F1", "Landroid/graphics/drawable/Drawable;", "imageDrawable", "", "textResId", "C1", "(Landroid/graphics/drawable/Drawable;Ljava/lang/Integer;)V", "resId", "A1", "status", "I1", "x1", ICustomDataEditor.NUMBER_PARAM_1, "E1", "Lcom/tencent/aio/base/mvvm/b;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "e1", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "b1", "Landroid/view/View;", "d1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "", "getTag", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "f", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "currentMsgItem", tl.h.F, "Z", "delayShowSending", "i", "I", "msgSendStatus", "kotlin.jvm.PlatformType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "msgContentView", "Landroid/widget/ImageView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/ImageView;", "msgSendStatusImage", "Landroid/widget/TextView;", "D", "Landroid/widget/TextView;", "msgSendFailText", "E", "Lkotlin/Lazy;", "p1", "()Landroid/graphics/drawable/Drawable;", "loadingDrawable", UserInfo.SEX_FEMALE, "r1", "timeDrawable", "Landroid/widget/LinearLayout;", "G", "q1", "()Landroid/widget/LinearLayout;", "statusView", "Ljava/lang/Runnable;", "H", "Ljava/lang/Runnable;", "runnable", "root", "<init>", "(Landroid/view/View;)V", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildBubbleMsgStatusComponent extends a {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final ImageView msgSendStatusImage;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final TextView msgSendFailText;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy loadingDrawable;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy timeDrawable;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy statusView;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Runnable runnable;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private GuildMsgItem currentMsgItem;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean delayShowSending;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int msgSendStatus;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final View msgContentView;

    public GuildBubbleMsgStatusComponent(@NotNull final View root) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(root, "root");
        this.msgSendStatus = -1;
        this.msgContentView = root.findViewById(R.id.f164907u83);
        this.msgSendStatusImage = new ImageView(root.getContext());
        this.msgSendFailText = new TextView(root.getContext());
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Drawable>() { // from class: com.tencent.guild.aio.msglist.holder.component.GuildBubbleMsgStatusComponent$loadingDrawable$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Drawable invoke() {
                return com.tencent.mobileqq.guild.util.qqui.d.d(root.getContext(), 2);
            }
        });
        this.loadingDrawable = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Drawable>() { // from class: com.tencent.guild.aio.msglist.holder.component.GuildBubbleMsgStatusComponent$timeDrawable$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Drawable invoke() {
                Context context = root.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "root.context");
                return GuildUIUtils.w(context, R.drawable.qui_time, Integer.valueOf(R.color.qui_common_text_secondary));
            }
        });
        this.timeDrawable = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.guild.aio.msglist.holder.component.GuildBubbleMsgStatusComponent$statusView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LinearLayout invoke() {
                ImageView imageView;
                TextView textView;
                LinearLayout linearLayout = new LinearLayout(root.getContext());
                GuildBubbleMsgStatusComponent guildBubbleMsgStatusComponent = this;
                linearLayout.setId(R.id.zgn);
                linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                linearLayout.setGravity(16);
                imageView = guildBubbleMsgStatusComponent.msgSendStatusImage;
                imageView.setId(R.id.zgo);
                imageView.setVisibility(8);
                imageView.setLayoutParams(new LinearLayout.LayoutParams(ViewUtils.dpToPx(16.0f), ViewUtils.dpToPx(16.0f)));
                linearLayout.addView(imageView);
                textView = guildBubbleMsgStatusComponent.msgSendFailText;
                textView.setId(R.id.zgl);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                ViewExtKt.d(textView, ViewUtils.dpToPx(2.2f));
                textView.setLayoutParams(layoutParams);
                textView.setTextSize(13.0f);
                textView.setVisibility(8);
                linearLayout.addView(textView);
                return linearLayout;
            }
        });
        this.statusView = lazy3;
        this.runnable = new Runnable() { // from class: com.tencent.guild.aio.msglist.holder.component.m
            @Override // java.lang.Runnable
            public final void run() {
                GuildBubbleMsgStatusComponent.z1(GuildBubbleMsgStatusComponent.this);
            }
        };
    }

    private final void A1(int resId) {
        ImageView imageView = this.msgSendStatusImage;
        imageView.setVisibility(0);
        imageView.setRotation(0.0f);
        imageView.setImageResource(R.drawable.f160226dl);
        imageView.setBackgroundDrawable(new ColorDrawable(0));
        TextView textView = this.msgSendFailText;
        textView.setTextColor(ContextCompat.getColor(textView.getContext(), R.color.qui_common_feedback_error));
        textView.setText(textView.getContext().getString(resId));
        textView.setVisibility(0);
    }

    static /* synthetic */ void B1(GuildBubbleMsgStatusComponent guildBubbleMsgStatusComponent, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = R.string.f139240aq;
        }
        guildBubbleMsgStatusComponent.A1(i3);
    }

    private final void C1(Drawable imageDrawable, Integer textResId) {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            Logger.a d16 = logger.d();
            GuildMsgItem guildMsgItem = this.currentMsgItem;
            if (guildMsgItem == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                guildMsgItem = null;
            }
            d16.d("GuildBubbleMsgStatusComponent", 2, "showLoading, msgId = " + guildMsgItem.getMsgId());
        }
        ImageView imageView = this.msgSendStatusImage;
        imageView.setVisibility(0);
        imageView.setRotation(0.0f);
        imageView.setImageDrawable(imageDrawable);
        imageView.setBackground(new ColorDrawable(0));
        if (textResId != null) {
            int intValue = textResId.intValue();
            TextView textView = this.msgSendFailText;
            textView.setText(textView.getContext().getString(intValue));
            textView.setTextColor(ContextCompat.getColor(textView.getContext(), R.color.qui_common_text_secondary));
            textView.setVisibility(0);
            return;
        }
        this.msgSendFailText.setVisibility(8);
        Unit unit = Unit.INSTANCE;
    }

    static /* synthetic */ void D1(GuildBubbleMsgStatusComponent guildBubbleMsgStatusComponent, Drawable drawable, Integer num, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            drawable = guildBubbleMsgStatusComponent.p1();
        }
        if ((i3 & 2) != 0) {
            num = null;
        }
        guildBubbleMsgStatusComponent.C1(drawable, num);
    }

    private final void E1() {
        ImageView imageView = this.msgSendStatusImage;
        imageView.setVisibility(0);
        imageView.setRotation(0.0f);
        imageView.setImageResource(R.drawable.guild_aio_send_video_pause);
        imageView.setBackgroundDrawable(new ColorDrawable(0));
        this.msgSendFailText.setVisibility(8);
    }

    private final void F1() {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            Logger.a d16 = logger.d();
            GuildMsgItem guildMsgItem = this.currentMsgItem;
            if (guildMsgItem == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                guildMsgItem = null;
            }
            d16.d("GuildBubbleMsgStatusComponent", 2, "showSending, msgId = " + guildMsgItem.getMsgId());
        }
        x xVar = x.f112474a;
        GuildMsgItem guildMsgItem2 = this.currentMsgItem;
        if (guildMsgItem2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            guildMsgItem2 = null;
        }
        if (xVar.d(guildMsgItem2)) {
            E1();
        } else {
            D1(this, null, null, 3, null);
        }
    }

    private final void G1() {
        y1();
        this.msgSendStatusImage.setVisibility(8);
        this.msgSendFailText.setVisibility(8);
    }

    private final void H1(Object payload) {
        if (payload instanceof b.GuildMsgItemStatusPayload) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                Logger.a d16 = logger.d();
                GuildMsgItem guildMsgItem = this.currentMsgItem;
                if (guildMsgItem == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                    guildMsgItem = null;
                }
                long msgId = guildMsgItem.getMsgId();
                int sendStatus = ((b.GuildMsgItemStatusPayload) payload).getSendStatus();
                GuildMsgItem guildMsgItem2 = this.currentMsgItem;
                if (guildMsgItem2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                    guildMsgItem2 = null;
                }
                d16.d("GuildBubbleMsgStatusComponent", 2, "updateBindUIState msgId = " + msgId + ", status =  " + sendStatus + ", hashCode = " + guildMsgItem2.hashCode());
            }
            b.GuildMsgItemStatusPayload guildMsgItemStatusPayload = (b.GuildMsgItemStatusPayload) payload;
            int sendStatus2 = guildMsgItemStatusPayload.getSendStatus();
            if (sendStatus2 != 0) {
                if (sendStatus2 != 1) {
                    if (sendStatus2 != 2) {
                        if (sendStatus2 != 3) {
                            if (sendStatus2 == 4) {
                                y1();
                                C1(r1(), Integer.valueOf(R.string.f139230ap));
                            }
                        } else {
                            G1();
                        }
                    } else {
                        G1();
                    }
                } else {
                    y1();
                    F1();
                }
            } else {
                y1();
                B1(this, 0, 1, null);
            }
            I1(guildMsgItemStatusPayload.getSendStatus());
        }
    }

    private final void I1(int status) {
        this.msgSendStatus = status;
    }

    private final void n1() {
        GuildMsgItem guildMsgItem = this.currentMsgItem;
        if (guildMsgItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            guildMsgItem = null;
        }
        sendIntent(new a.h(guildMsgItem));
    }

    private final void o1() {
        aa.c(this.runnable, 1000L);
        this.delayShowSending = true;
    }

    private final Drawable p1() {
        return (Drawable) this.loadingDrawable.getValue();
    }

    private final LinearLayout q1() {
        return (LinearLayout) this.statusView.getValue();
    }

    private final Drawable r1() {
        return (Drawable) this.timeDrawable.getValue();
    }

    private final boolean s1(List<Object> payloads) {
        boolean z16 = true;
        for (Object obj : payloads) {
            if (obj instanceof HashMap) {
                Object obj2 = ((Map) obj).get(GuildMsgItemPayloadType.STATUS_PAYLOAD);
                if (obj2 != null) {
                    H1(obj2);
                }
                z16 = false;
            }
        }
        return z16;
    }

    private final void u1() {
        q1().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.msglist.holder.component.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildBubbleMsgStatusComponent.v1(GuildBubbleMsgStatusComponent.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v1(GuildBubbleMsgStatusComponent this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i3 = this$0.msgSendStatus;
        if (i3 != 0) {
            if (i3 == 1) {
                x xVar = x.f112474a;
                GuildMsgItem guildMsgItem = this$0.currentMsgItem;
                if (guildMsgItem == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                    guildMsgItem = null;
                }
                if (xVar.d(guildMsgItem)) {
                    this$0.n1();
                }
            }
        } else {
            this$0.x1();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void w1() {
        Logger logger = Logger.f235387a;
        GuildMsgItem guildMsgItem = null;
        if (QLog.isColorLevel()) {
            Logger.a d16 = logger.d();
            GuildMsgItem guildMsgItem2 = this.currentMsgItem;
            if (guildMsgItem2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                guildMsgItem2 = null;
            }
            long msgId = guildMsgItem2.getMsgId();
            GuildMsgItem guildMsgItem3 = this.currentMsgItem;
            if (guildMsgItem3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                guildMsgItem3 = null;
            }
            int i3 = guildMsgItem3.getMsgRecord().sendStatus;
            GuildMsgItem guildMsgItem4 = this.currentMsgItem;
            if (guildMsgItem4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
                guildMsgItem4 = null;
            }
            d16.d("GuildBubbleMsgStatusComponent", 2, "initUI msgId = " + msgId + ", status =  " + i3 + ", hashCode = " + guildMsgItem4.hashCode());
        }
        GuildMsgItem guildMsgItem5 = this.currentMsgItem;
        if (guildMsgItem5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            guildMsgItem5 = null;
        }
        int i16 = guildMsgItem5.getMsgRecord().sendStatus;
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 != 4) {
                    G1();
                } else {
                    C1(r1(), Integer.valueOf(R.string.f139230ap));
                }
            } else {
                o1();
            }
        } else {
            B1(this, 0, 1, null);
        }
        GuildMsgItem guildMsgItem6 = this.currentMsgItem;
        if (guildMsgItem6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
        } else {
            guildMsgItem = guildMsgItem6;
        }
        I1(guildMsgItem.getMsgRecord().sendStatus);
        u1();
    }

    private final void x1() {
        GuildMsgItem guildMsgItem = this.currentMsgItem;
        if (guildMsgItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentMsgItem");
            guildMsgItem = null;
        }
        sendIntent(new a.i(guildMsgItem));
    }

    private final void y1() {
        if (this.delayShowSending) {
            aa.a(this.runnable);
            this.delayShowSending = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z1(GuildBubbleMsgStatusComponent this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.F1();
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        float f16;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        GuildMsgItem guildMsgItem = (GuildMsgItem) msgItem;
        this.currentMsgItem = guildMsgItem;
        View view = this.msgContentView;
        if (view != null) {
            if (guildMsgItem.isReviewingMsg()) {
                f16 = 0.5f;
            } else {
                f16 = 1.0f;
            }
            view.setAlpha(f16);
        }
        if (s1(payloads)) {
            w1();
        }
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public View d1() {
        return q1();
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a, com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    /* renamed from: e1 */
    public com.tencent.aio.base.mvvm.b<ol3.b, MviUIState> createVM() {
        return new o();
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public String getTag() {
        return "GuildBubbleMsgStatusComponent";
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

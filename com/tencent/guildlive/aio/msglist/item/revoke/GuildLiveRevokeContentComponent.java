package com.tencent.guildlive.aio.msglist.item.revoke;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.util.l;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guildlive.aio.msglist.holder.component.AbsGuildLiveComponent;
import com.tencent.guildlive.aio.msglist.item.graytips.GuildRevokeMsgReeditUIState;
import com.tencent.guildlive.aio.msglist.item.graytips.a;
import com.tencent.guildlive.aio.msglist.item.graytips.e;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.GrayTipElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.RevokeElement;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 D2\u00020\u0001:\u0001EB\u000f\u0012\u0006\u0010+\u001a\u00020\u0013\u00a2\u0006\u0004\bB\u0010CJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J \u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\nH\u0002J*\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0013H\u0002J\b\u0010\u0018\u001a\u00020\u0013H\u0002J\b\u0010\u0019\u001a\u00020\u0013H\u0016J\u0014\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001c0\u001aH\u0016J\u0010\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001cH\u0016J&\u0010&\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 2\u0006\u0010\u0007\u001a\u00020\"2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#H\u0016R\u0017\u0010+\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00106R\u0016\u0010;\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010.R\u001b\u0010A\u001a\u00020<8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\u00a8\u0006F"}, d2 = {"Lcom/tencent/guildlive/aio/msglist/item/revoke/GuildLiveRevokeContentComponent;", "Lcom/tencent/guildlive/aio/msglist/holder/component/AbsGuildLiveComponent;", "", "O1", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/RevokeElement;", "revokeElement", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "K1", "L1", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "mr", "P1", "", "msgSenderUid", "operatorTinyId", "S1", "selfTinyId", "R1", "Landroid/view/View;", "W1", "U1", "X1", "V1", "T1", "d1", "Lcom/tencent/aio/base/mvvm/b;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "e1", "state", "handleUIState", "", "position", "Lcom/tencent/aio/data/msglist/a;", "", "", "payloads", "b1", "D", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "mIconView", "Landroid/widget/LinearLayout;", UserInfo.SEX_FEMALE, "Landroid/widget/LinearLayout;", "mRevokeLayout", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "mRevokeTextView", "H", "mReeditTextView", "I", "mDeleteIconView", "Landroid/view/ViewGroup;", "J", "Lkotlin/Lazy;", "Q1", "()Landroid/view/ViewGroup;", "mRootView", "<init>", "(Landroid/view/View;)V", "K", "a", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildLiveRevokeContentComponent extends AbsGuildLiveComponent {
    private static final int L = ViewUtils.dip2px(18.0f);
    private static final int M = ViewUtils.dip2px(5.0f);
    private static final int N = ViewUtils.dip2px(6.0f);
    private static final int P = ViewUtils.dip2px(3.0f);
    private static final int Q = Color.parseColor("#3AB0FF");
    private static final int R = ViewUtils.dip2px(3.0f);
    private static final int S = ViewUtils.dip2px(18.0f);
    private static final int T = ViewUtils.dip2px(5.0f);
    private static final int U = ViewUtils.dip2px(8.0f);

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final View root;

    /* renamed from: E, reason: from kotlin metadata */
    private ImageView mIconView;

    /* renamed from: F, reason: from kotlin metadata */
    private LinearLayout mRevokeLayout;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView mRevokeTextView;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView mReeditTextView;

    /* renamed from: I, reason: from kotlin metadata */
    private ImageView mDeleteIconView;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy mRootView;

    public GuildLiveRevokeContentComponent(@NotNull View root) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.guildlive.aio.msglist.item.revoke.GuildLiveRevokeContentComponent$mRootView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LinearLayout invoke() {
                View U1;
                View W1;
                LinearLayout linearLayout = new LinearLayout(GuildLiveRevokeContentComponent.this.getRoot().getContext());
                GuildLiveRevokeContentComponent guildLiveRevokeContentComponent = GuildLiveRevokeContentComponent.this;
                linearLayout.setOrientation(0);
                linearLayout.setGravity(16);
                linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                U1 = guildLiveRevokeContentComponent.U1();
                linearLayout.addView(U1);
                W1 = guildLiveRevokeContentComponent.W1();
                linearLayout.addView(W1);
                return linearLayout;
            }
        });
        this.mRootView = lazy;
    }

    private final void K1(RevokeElement revokeElement, GuildMsgItem msgItem) {
        ImageView imageView = this.mIconView;
        TextView textView = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIconView");
            imageView = null;
        }
        imageView.setBackgroundResource(R.drawable.guild_aio_revoke_msg_icon);
        L1(revokeElement, msgItem);
        String str = msgItem.getMsgRecord().guildId;
        Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.guildId");
        boolean i3 = yr0.a.i(str);
        ImageView imageView2 = this.mDeleteIconView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDeleteIconView");
            imageView2 = null;
        }
        yr0.a.s(imageView2, !i3);
        if (i3) {
            TextView textView2 = this.mReeditTextView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mReeditTextView");
            } else {
                textView = textView2;
            }
            yr0.a.s(textView, false);
        }
    }

    private final void L1(RevokeElement revokeElement, final GuildMsgItem msgItem) {
        P1(revokeElement, msgItem.getMsgRecord());
        TextView textView = this.mReeditTextView;
        ImageView imageView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mReeditTextView");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guildlive.aio.msglist.item.revoke.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildLiveRevokeContentComponent.M1(GuildLiveRevokeContentComponent.this, msgItem, view);
            }
        });
        ImageView imageView2 = this.mDeleteIconView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDeleteIconView");
        } else {
            imageView = imageView2;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guildlive.aio.msglist.item.revoke.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildLiveRevokeContentComponent.N1(GuildLiveRevokeContentComponent.this, msgItem, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M1(GuildLiveRevokeContentComponent this$0, GuildMsgItem msgItem, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        if (this$0.s1(this$0.root)) {
            this$0.sendIntent(new a.c(msgItem));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N1(GuildLiveRevokeContentComponent this$0, GuildMsgItem msgItem, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        if (this$0.s1(this$0.root)) {
            this$0.sendIntent(new a.C1227a(msgItem));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void O1() {
        HashMap hashMap = new HashMap();
        hashMap.put("aio_graytext_type", 3);
        yr0.a.p(Q1(), "em_aio_graytext", hashMap);
        yr0.a.o("imp", Q1(), null, 4, null);
    }

    private final void P1(RevokeElement revokeElement, MsgRecord mr5) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        String str;
        String R1;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        TextView textView = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        } else {
            iRuntimeService = null;
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            str = iGPSService.getSelfTinyId();
        } else {
            str = null;
        }
        String valueOf = String.valueOf(revokeElement.operatorTinyId);
        String msgSenderUid = mr5.senderUid;
        if (TextUtils.equals(str, valueOf)) {
            Intrinsics.checkNotNullExpressionValue(msgSenderUid, "msgSenderUid");
            R1 = S1(msgSenderUid, valueOf, mr5);
            TextView textView2 = this.mReeditTextView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mReeditTextView");
                textView2 = null;
            }
            textView2.setVisibility(0);
        } else {
            Intrinsics.checkNotNullExpressionValue(msgSenderUid, "msgSenderUid");
            R1 = R1(msgSenderUid, valueOf, mr5, str);
            TextView textView3 = this.mReeditTextView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mReeditTextView");
                textView3 = null;
            }
            textView3.setVisibility(8);
        }
        TextView textView4 = this.mRevokeTextView;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRevokeTextView");
            textView4 = null;
        }
        textView4.setText(R1);
        if (!mr5.editable) {
            TextView textView5 = this.mReeditTextView;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mReeditTextView");
            } else {
                textView = textView5;
            }
            textView.setVisibility(8);
        }
    }

    private final ViewGroup Q1() {
        return (ViewGroup) this.mRootView.getValue();
    }

    private final String R1(String msgSenderUid, String operatorTinyId, MsgRecord mr5, String selfTinyId) {
        if (TextUtils.equals(msgSenderUid, operatorTinyId)) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String obj = l.b(l.f112411a, R.string.f1650927l, null, 2, null).toString();
            String str = mr5.guildId;
            Intrinsics.checkNotNullExpressionValue(str, "mr.guildId");
            String format = String.format(obj, Arrays.copyOf(new Object[]{iq0.a.v(operatorTinyId, str, false)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            return format;
        }
        String str2 = mr5.guildId;
        Intrinsics.checkNotNullExpressionValue(str2, "mr.guildId");
        String str3 = mr5.channelId;
        Intrinsics.checkNotNullExpressionValue(str3, "mr.channelId");
        if (yr0.a.d(str2, str3)) {
            if (TextUtils.equals(msgSenderUid, selfTinyId)) {
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String obj2 = l.b(l.f112411a, R.string.f1651527r, null, 2, null).toString();
                String str4 = mr5.guildId;
                Intrinsics.checkNotNullExpressionValue(str4, "mr.guildId");
                String format2 = String.format(obj2, Arrays.copyOf(new Object[]{iq0.a.v(operatorTinyId, str4, false)}, 1));
                Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
                return format2;
            }
            StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
            String obj3 = l.b(l.f112411a, R.string.f1651427q, null, 2, null).toString();
            String str5 = mr5.guildId;
            Intrinsics.checkNotNullExpressionValue(str5, "mr.guildId");
            String str6 = mr5.guildId;
            Intrinsics.checkNotNullExpressionValue(str6, "mr.guildId");
            String format3 = String.format(obj3, Arrays.copyOf(new Object[]{iq0.a.v(operatorTinyId, str5, false), iq0.a.v(msgSenderUid, str6, false)}, 2));
            Intrinsics.checkNotNullExpressionValue(format3, "format(format, *args)");
            return format3;
        }
        if (TextUtils.equals(msgSenderUid, selfTinyId)) {
            return l.b(l.f112411a, R.string.f1651127n, null, 2, null).toString();
        }
        return l.b(l.f112411a, R.string.f1651027m, null, 2, null).toString();
    }

    private final String S1(String msgSenderUid, String operatorTinyId, MsgRecord mr5) {
        if (TextUtils.equals(msgSenderUid, operatorTinyId)) {
            return l.b(l.f112411a, R.string.f1651327p, null, 2, null).toString();
        }
        String str = mr5.guildId;
        Intrinsics.checkNotNullExpressionValue(str, "mr.guildId");
        String v3 = iq0.a.v(msgSenderUid, str, true);
        CharSequence b16 = l.b(l.f112411a, R.string.f1650727j, null, 2, null);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(b16.toString(), Arrays.copyOf(new Object[]{v3}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    private final View T1() {
        ImageView imageView = new ImageView(this.root.getContext());
        int i3 = S;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
        layoutParams.leftMargin = T;
        imageView.setLayoutParams(layoutParams);
        imageView.setBackgroundResource(R.drawable.guild_revoke_msg_close_icon);
        this.mDeleteIconView = imageView;
        return imageView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View U1() {
        ImageView imageView = new ImageView(this.root.getContext());
        int i3 = L;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
        int i16 = M;
        layoutParams.leftMargin = i16;
        layoutParams.rightMargin = i16;
        int i17 = N;
        layoutParams.topMargin = i17;
        layoutParams.bottomMargin = i17;
        imageView.setLayoutParams(layoutParams);
        this.mIconView = imageView;
        return imageView;
    }

    private final View V1() {
        TextView textView = new TextView(this.root.getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        textView.setVisibility(8);
        layoutParams.leftMargin = R;
        textView.setLayoutParams(layoutParams);
        textView.setTextSize(13.0f);
        textView.setIncludeFontPadding(false);
        textView.setTextColor(Q);
        textView.setText(R.string.f17893380);
        this.mReeditTextView = textView;
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View W1() {
        LinearLayout linearLayout = new LinearLayout(this.root.getContext());
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = U;
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.addView(X1());
        linearLayout.addView(V1());
        linearLayout.addView(T1());
        this.mRevokeLayout = linearLayout;
        return linearLayout;
    }

    private final View X1() {
        TextView textView = new TextView(this.root.getContext());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView.setIncludeFontPadding(false);
        textView.setTextSize(13.0f);
        textView.setTextColor(this.root.getContext().getResources().getColor(R.color.bpx));
        this.mRevokeTextView = textView;
        return textView;
    }

    @Override // com.tencent.guildlive.aio.msglist.holder.component.AbsGuildLiveComponent, com.tencent.guild.aio.msglist.holder.component.a
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        RevokeElement revokeElement;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.b1(position, msgItem, payloads);
        if (msgItem instanceof GuildMsgItem) {
            yr0.a.s(Q1(), true);
            ImageView imageView = this.mDeleteIconView;
            GrayTipElement grayTipElement = null;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDeleteIconView");
                imageView = null;
            }
            yr0.a.s(imageView, false);
            TextView textView = this.mReeditTextView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mReeditTextView");
                textView = null;
            }
            yr0.a.s(textView, false);
            GuildMsgItem guildMsgItem = (GuildMsgItem) msgItem;
            MsgElement firstTypeElement = guildMsgItem.getFirstTypeElement(8);
            if (firstTypeElement != null) {
                grayTipElement = firstTypeElement.grayTipElement;
            }
            if (grayTipElement != null && (revokeElement = grayTipElement.revokeElement) != null) {
                K1(revokeElement, guildMsgItem);
                O1();
                return;
            }
            return;
        }
        yr0.a.s(Q1(), false);
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public View d1() {
        return Q1();
    }

    @Override // com.tencent.guildlive.aio.msglist.holder.component.AbsGuildLiveComponent, com.tencent.guild.aio.msglist.holder.component.a, com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: e1 */
    public com.tencent.aio.base.mvvm.b<ol3.b, MviUIState> createVM() {
        return new e();
    }

    @NotNull
    public final View getRoot() {
        return this.root;
    }

    @Override // com.tencent.guildlive.aio.msglist.holder.component.AbsGuildLiveComponent, com.tencent.mvi.mvvm.BaseVB
    public void handleUIState(@NotNull MviUIState state) {
        TextView textView;
        MsgRecord msgRecord;
        Intrinsics.checkNotNullParameter(state, "state");
        super.handleUIState(state);
        if (state instanceof GuildRevokeMsgReeditUIState) {
            GuildMsgItem currentMsgItem = getCurrentMsgItem();
            boolean z16 = false;
            if (currentMsgItem != null && (msgRecord = currentMsgItem.getMsgRecord()) != null && msgRecord.msgId == ((GuildRevokeMsgReeditUIState) state).getMsgRecord().msgId) {
                z16 = true;
            }
            if (z16 && (textView = this.mReeditTextView) != null) {
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mReeditTextView");
                    textView = null;
                }
                textView.setVisibility(8);
            }
        }
    }
}

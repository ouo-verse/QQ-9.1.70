package com.tencent.guildmedia.aio.msglist.item.revoke;

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
import com.tencent.guildmedia.aio.msglist.item.graytips.GuildRevokeMsgReeditUIState;
import com.tencent.guildmedia.aio.msglist.item.graytips.a;
import com.tencent.guildmedia.aio.msglist.item.graytips.d;
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
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 @2\u00020\u0001:\u0001AB\u000f\u0012\u0006\u0010'\u001a\u00020\u000f\u00a2\u0006\u0004\b>\u0010?J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u000fH\u0002J\b\u0010\u0013\u001a\u00020\u000fH\u0002J\b\u0010\u0014\u001a\u00020\u000fH\u0002J\b\u0010\u0015\u001a\u00020\u000fH\u0016J\u0014\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016H\u0016J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0018H\u0016J&\u0010\"\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\t\u001a\u00020\u001e2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0016R\u0017\u0010'\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00105\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00102R\u0016\u00107\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u0010*R\u001b\u0010=\u001a\u0002088BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\u00a8\u0006B"}, d2 = {"Lcom/tencent/guildmedia/aio/msglist/item/revoke/GuildMediaRevokeContentComponent;", "Lcom/tencent/guildmedia/aio/msglist/holder/component/a;", "", "guildId", "", "V1", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/RevokeElement;", "revokeElement", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "", "L1", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "mr", "O1", "Landroid/view/View;", "T1", "R1", "U1", "S1", "Q1", "d1", "Lcom/tencent/aio/base/mvvm/b;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "e1", "state", "handleUIState", "", "position", "Lcom/tencent/aio/data/msglist/a;", "", "", "payloads", "b1", "D", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "mIconView", "Landroid/widget/LinearLayout;", UserInfo.SEX_FEMALE, "Landroid/widget/LinearLayout;", "mRevokeLayout", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "mRevokeTextView", "H", "mReeditTextView", "I", "mDeleteIconView", "Landroid/view/ViewGroup;", "J", "Lkotlin/Lazy;", "P1", "()Landroid/view/ViewGroup;", "mRootView", "<init>", "(Landroid/view/View;)V", "K", "a", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildMediaRevokeContentComponent extends com.tencent.guildmedia.aio.msglist.holder.component.a {
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

    public GuildMediaRevokeContentComponent(@NotNull View root) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.guildmedia.aio.msglist.item.revoke.GuildMediaRevokeContentComponent$mRootView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LinearLayout invoke() {
                View R1;
                View T1;
                LinearLayout linearLayout = new LinearLayout(GuildMediaRevokeContentComponent.this.getRoot().getContext());
                GuildMediaRevokeContentComponent guildMediaRevokeContentComponent = GuildMediaRevokeContentComponent.this;
                linearLayout.setOrientation(0);
                linearLayout.setGravity(16);
                linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                R1 = guildMediaRevokeContentComponent.R1();
                linearLayout.addView(R1);
                T1 = guildMediaRevokeContentComponent.T1();
                linearLayout.addView(T1);
                return linearLayout;
            }
        });
        this.mRootView = lazy;
    }

    private final void L1(RevokeElement revokeElement, final GuildMsgItem msgItem) {
        O1(revokeElement, msgItem.getMsgRecord());
        TextView textView = this.mReeditTextView;
        ImageView imageView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mReeditTextView");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guildmedia.aio.msglist.item.revoke.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildMediaRevokeContentComponent.M1(GuildMediaRevokeContentComponent.this, msgItem, view);
            }
        });
        ImageView imageView2 = this.mDeleteIconView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDeleteIconView");
        } else {
            imageView = imageView2;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guildmedia.aio.msglist.item.revoke.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildMediaRevokeContentComponent.N1(GuildMediaRevokeContentComponent.this, msgItem, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M1(GuildMediaRevokeContentComponent this$0, GuildMsgItem msgItem, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        if (this$0.u1(this$0.root)) {
            this$0.sendIntent(new a.c(msgItem));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N1(GuildMediaRevokeContentComponent this$0, GuildMsgItem msgItem, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        if (this$0.u1(this$0.root)) {
            this$0.sendIntent(new a.C1236a(msgItem));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void O1(RevokeElement revokeElement, MsgRecord mr5) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        RevokeElement revokeElement2;
        String str;
        String obj;
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
            revokeElement2 = revokeElement;
        } else {
            revokeElement2 = revokeElement;
            str = null;
        }
        String valueOf = String.valueOf(revokeElement2.operatorTinyId);
        String msgSenderUid = mr5.senderUid;
        if (TextUtils.equals(str, valueOf)) {
            if (TextUtils.equals(msgSenderUid, valueOf)) {
                obj = l.b(l.f112411a, R.string.f1651327p, null, 2, null).toString();
            } else {
                Intrinsics.checkNotNullExpressionValue(msgSenderUid, "msgSenderUid");
                String str2 = mr5.guildId;
                Intrinsics.checkNotNullExpressionValue(str2, "mr.guildId");
                String v3 = iq0.a.v(msgSenderUid, str2, true);
                CharSequence b16 = l.b(l.f112411a, R.string.f1650727j, null, 2, null);
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                obj = String.format(b16.toString(), Arrays.copyOf(new Object[]{v3}, 1));
                Intrinsics.checkNotNullExpressionValue(obj, "format(format, *args)");
            }
            TextView textView2 = this.mReeditTextView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mReeditTextView");
                textView2 = null;
            }
            textView2.setVisibility(0);
        } else {
            if (TextUtils.equals(msgSenderUid, valueOf)) {
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String obj2 = l.b(l.f112411a, R.string.f1650927l, null, 2, null).toString();
                String str3 = mr5.guildId;
                Intrinsics.checkNotNullExpressionValue(str3, "mr.guildId");
                obj = String.format(obj2, Arrays.copyOf(new Object[]{iq0.a.v(valueOf, str3, false)}, 1));
                Intrinsics.checkNotNullExpressionValue(obj, "format(format, *args)");
            } else {
                String str4 = mr5.guildId;
                Intrinsics.checkNotNullExpressionValue(str4, "mr.guildId");
                String str5 = mr5.channelId;
                Intrinsics.checkNotNullExpressionValue(str5, "mr.channelId");
                if (vs0.a.e(str4, str5)) {
                    if (TextUtils.equals(msgSenderUid, str)) {
                        StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                        String obj3 = l.b(l.f112411a, R.string.f1651527r, null, 2, null).toString();
                        String str6 = mr5.guildId;
                        Intrinsics.checkNotNullExpressionValue(str6, "mr.guildId");
                        obj = String.format(obj3, Arrays.copyOf(new Object[]{iq0.a.v(valueOf, str6, false)}, 1));
                        Intrinsics.checkNotNullExpressionValue(obj, "format(format, *args)");
                    } else {
                        StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
                        String obj4 = l.b(l.f112411a, R.string.f1651427q, null, 2, null).toString();
                        String str7 = mr5.guildId;
                        Intrinsics.checkNotNullExpressionValue(str7, "mr.guildId");
                        Intrinsics.checkNotNullExpressionValue(msgSenderUid, "msgSenderUid");
                        String str8 = mr5.guildId;
                        Intrinsics.checkNotNullExpressionValue(str8, "mr.guildId");
                        obj = String.format(obj4, Arrays.copyOf(new Object[]{iq0.a.v(valueOf, str7, false), iq0.a.v(msgSenderUid, str8, false)}, 2));
                        Intrinsics.checkNotNullExpressionValue(obj, "format(format, *args)");
                    }
                } else if (TextUtils.equals(msgSenderUid, str)) {
                    obj = l.b(l.f112411a, R.string.f1651127n, null, 2, null).toString();
                } else {
                    obj = l.b(l.f112411a, R.string.f1651027m, null, 2, null).toString();
                }
            }
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
        textView4.setText(obj);
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

    private final ViewGroup P1() {
        return (ViewGroup) this.mRootView.getValue();
    }

    private final View Q1() {
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
    public final View R1() {
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

    private final View S1() {
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
    public final View T1() {
        LinearLayout linearLayout = new LinearLayout(this.root.getContext());
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = U;
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.addView(U1());
        linearLayout.addView(S1());
        linearLayout.addView(Q1());
        this.mRevokeLayout = linearLayout;
        return linearLayout;
    }

    private final View U1() {
        TextView textView = new TextView(this.root.getContext());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView.setIncludeFontPadding(false);
        textView.setTextSize(13.0f);
        textView.setTextColor(this.root.getContext().getResources().getColor(R.color.bpx));
        this.mRevokeTextView = textView;
        return textView;
    }

    private final boolean V1(String guildId) {
        AppInterface appInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            return iGPSService.isGuest(guildId);
        }
        return true;
    }

    @Override // com.tencent.guild.aio.component.combinestyle.AbsGuildMediaStyleComponent, com.tencent.guild.aio.msglist.holder.component.a
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        GrayTipElement grayTipElement;
        RevokeElement revokeElement;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.b1(position, msgItem, payloads);
        if (msgItem instanceof GuildMsgItem) {
            vs0.a.p(P1(), true);
            ImageView imageView = this.mDeleteIconView;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDeleteIconView");
                imageView = null;
            }
            vs0.a.p(imageView, false);
            TextView textView = this.mReeditTextView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mReeditTextView");
                textView = null;
            }
            vs0.a.p(textView, false);
            GuildMsgItem guildMsgItem = (GuildMsgItem) msgItem;
            MsgElement firstTypeElement = guildMsgItem.getFirstTypeElement(8);
            if (firstTypeElement != null) {
                grayTipElement = firstTypeElement.grayTipElement;
            } else {
                grayTipElement = null;
            }
            if (grayTipElement != null && (revokeElement = grayTipElement.revokeElement) != null) {
                ImageView imageView2 = this.mIconView;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mIconView");
                    imageView2 = null;
                }
                imageView2.setBackgroundResource(R.drawable.guild_aio_revoke_msg_icon);
                L1(revokeElement, guildMsgItem);
                String str = guildMsgItem.getMsgRecord().guildId;
                Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.guildId");
                boolean V1 = V1(str);
                ImageView imageView3 = this.mDeleteIconView;
                if (imageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mDeleteIconView");
                    imageView3 = null;
                }
                vs0.a.p(imageView3, !V1);
                if (V1) {
                    TextView textView2 = this.mReeditTextView;
                    if (textView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mReeditTextView");
                        textView2 = null;
                    }
                    vs0.a.p(textView2, false);
                }
                HashMap hashMap = new HashMap();
                hashMap.put("aio_graytext_type", 3);
                vs0.a.n(P1(), "em_aio_graytext", hashMap);
                vs0.a.m("imp", P1(), null, 4, null);
                return;
            }
            return;
        }
        vs0.a.p(P1(), false);
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public View d1() {
        return P1();
    }

    @Override // com.tencent.guild.aio.component.combinestyle.AbsGuildMediaStyleComponent, com.tencent.guild.aio.msglist.holder.component.a, com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: e1 */
    public com.tencent.aio.base.mvvm.b<ol3.b, MviUIState> createVM() {
        return new d();
    }

    @NotNull
    public final View getRoot() {
        return this.root;
    }

    @Override // com.tencent.guild.aio.component.combinestyle.AbsGuildMediaStyleComponent, com.tencent.mvi.mvvm.BaseVB
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

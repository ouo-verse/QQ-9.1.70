package com.tencent.mobileqq.qwallet.pay.recommend;

import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.base.QWalletBaseFragment;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qwallet.pay.FinanceAdInfo;
import com.tencent.mobileqq.qwallet.utils.k;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.QQToastUtil;
import com.tenpay.sdk.net.gateway.QWalletGatewayServlet;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl2.h;
import tencent.im.qqwallet.Mall$CardInfo;
import tencent.im.qqwallet.Mall$CollectV2Req;
import tencent.im.qqwallet.Mall$CollectV2Rsp;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u001bB!\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0016\u0010\u0007\u001a\u00020\u0005*\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0006\u0010\b\u001a\u00020\u0002R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pay/recommend/CardBtnController;", "", "", "f", "e", "", RemoteHandleConst.PARAM_DEFAULT_VALUE, "b", "d", "Lcom/tencent/mobileqq/base/QWalletBaseFragment;", "a", "Lcom/tencent/mobileqq/base/QWalletBaseFragment;", "getFragment", "()Lcom/tencent/mobileqq/base/QWalletBaseFragment;", "fragment", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "getBtn", "()Landroid/widget/TextView;", "btn", "Ltencent/im/qqwallet/Mall$CardInfo;", "c", "Ltencent/im/qqwallet/Mall$CardInfo;", "()Ltencent/im/qqwallet/Mall$CardInfo;", "cardInfo", "<init>", "(Lcom/tencent/mobileqq/base/QWalletBaseFragment;Landroid/widget/TextView;Ltencent/im/qqwallet/Mall$CardInfo;)V", "CardStatusEnum", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class CardBtnController {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final QWalletBaseFragment fragment;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView btn;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Mall$CardInfo cardInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pay/recommend/CardBtnController$CardStatusEnum;", "", "", "pbValue", "I", "getPbValue", "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "UnReceived", "Received", "Completed", "Receiving", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public enum CardStatusEnum {
        UnReceived(1),
        Received(2),
        Completed(3),
        Receiving(999);


        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final int pbValue;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pay/recommend/CardBtnController$CardStatusEnum$a;", "", "", "value", "Lcom/tencent/mobileqq/qwallet/pay/recommend/CardBtnController$CardStatusEnum;", "a", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.qwallet.pay.recommend.CardBtnController$CardStatusEnum$a, reason: from kotlin metadata */
        /* loaded from: classes16.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final CardStatusEnum a(int value) {
                CardStatusEnum cardStatusEnum;
                boolean z16;
                CardStatusEnum[] values = CardStatusEnum.values();
                int length = values.length;
                int i3 = 0;
                while (true) {
                    if (i3 < length) {
                        cardStatusEnum = values[i3];
                        if (cardStatusEnum.getPbValue() == value) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            break;
                        }
                        i3++;
                    } else {
                        cardStatusEnum = null;
                        break;
                    }
                }
                if (cardStatusEnum == null) {
                    return CardStatusEnum.UnReceived;
                }
                return cardStatusEnum;
            }

            Companion() {
            }
        }

        CardStatusEnum(int i3) {
            this.pbValue = i3;
        }

        public final int getPbValue() {
            return this.pbValue;
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f278669a;

        static {
            int[] iArr = new int[CardStatusEnum.values().length];
            try {
                iArr[CardStatusEnum.UnReceived.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CardStatusEnum.Received.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CardStatusEnum.Completed.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CardStatusEnum.Receiving.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f278669a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/qwallet/pay/recommend/CardBtnController$b", "Lpl2/h;", "Ltencent/im/qqwallet/Mall$CollectV2Rsp;", "rsp", "", "c", "", "errCode", "", "errMsg", "onFail", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b extends h<Mall$CollectV2Rsp> {
        b(QWalletBaseFragment qWalletBaseFragment) {
            super(qWalletBaseFragment);
        }

        @Override // pl2.k
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull Mall$CollectV2Rsp rsp) {
            boolean z16;
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            CardBtnController.this.getCardInfo().status.set(CardStatusEnum.Received.getPbValue());
            CardBtnController.this.getCardInfo().apply_url.set(rsp.apply_url.get());
            CardBtnController.this.d();
            String str = rsp.err_msg.get();
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                QQToastUtil.showQQToast(2, rsp.err_msg.get());
            }
        }

        @Override // pl2.k
        public void onFail(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            CardBtnController.this.getCardInfo().status.set(CardStatusEnum.UnReceived.getPbValue());
            CardBtnController.this.d();
        }
    }

    public CardBtnController(@Nullable QWalletBaseFragment qWalletBaseFragment, @NotNull TextView btn, @NotNull Mall$CardInfo cardInfo) {
        Intrinsics.checkNotNullParameter(btn, "btn");
        Intrinsics.checkNotNullParameter(cardInfo, "cardInfo");
        this.fragment = qWalletBaseFragment;
        this.btn = btn;
        this.cardInfo = cardInfo;
        f();
        btn.setBackground(btn.getContext().getDrawable(R.drawable.kbv));
    }

    private final String b(String str, String str2) {
        boolean z16;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return str2;
        }
        return str;
    }

    private final void e() {
        Mall$CollectV2Req mall$CollectV2Req = new Mall$CollectV2Req();
        mall$CollectV2Req.field.set(this.cardInfo.field.get());
        mall$CollectV2Req.app_id.set(this.cardInfo.app_id.get());
        mall$CollectV2Req.card_id.set(this.cardInfo.card_id.get());
        mall$CollectV2Req.channel_id.set(9);
        mall$CollectV2Req.source.set("paysucc");
        b bVar = new b(this.fragment);
        QWalletGatewayServlet qWalletGatewayServlet = QWalletGatewayServlet.INSTANCE;
        Object newInstance = Mall$CollectV2Rsp.class.newInstance();
        Intrinsics.checkNotNullExpressionValue(newInstance, "Rsp::class.java.newInstance()");
        qWalletGatewayServlet.sendRequest("trpc.qcard.recommend.Mall", "CollectSSO", mall$CollectV2Req, (MessageMicro) newInstance, false, false, false, null, bVar);
    }

    private final void f() {
        this.btn.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qwallet.pay.recommend.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CardBtnController.g(CardBtnController.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(CardBtnController this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i3 = a.f278669a[CardStatusEnum.INSTANCE.a(this$0.cardInfo.status.get()).ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                QLog.w("PaySuccessAdFragment", 1, "onClick errorStatus:" + this$0.cardInfo.status.get() + ",  " + this$0.cardInfo.card_id.get() + " " + this$0.cardInfo.title.get() + " ");
            } else {
                k.h(this$0.btn.getContext(), this$0.cardInfo.apply_url.get());
                com.tencent.mobileqq.qwallet.pay.a.d("qqpay.success.adclick", this$0.cardInfo.card_id.get(), this$0.cardInfo.title.get(), FinanceAdInfo.EnumAdType.OP.ordinal());
            }
        } else {
            this$0.e();
            this$0.cardInfo.status.set(CardStatusEnum.Receiving.getPbValue());
            this$0.d();
            com.tencent.mobileqq.qwallet.pay.a.d("qqpay.success.adclick", this$0.cardInfo.card_id.get(), this$0.cardInfo.title.get(), FinanceAdInfo.EnumAdType.OP.ordinal());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final Mall$CardInfo getCardInfo() {
        return this.cardInfo;
    }

    public final void d() {
        int i3 = a.f278669a[CardStatusEnum.INSTANCE.a(this.cardInfo.status.get()).ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        this.btn.setText("\u9886\u53d6\u4e2d");
                        this.btn.setClickable(false);
                        this.btn.setHovered(true);
                        this.btn.setTextColor(-1);
                        return;
                    }
                    return;
                }
                this.btn.setText("\u5df2\u9886\u5b8c");
                this.btn.setClickable(false);
                this.btn.setHovered(false);
                this.btn.setTextColor(-16777216);
                return;
            }
            this.btn.setText(b(this.cardInfo.obtained_button_text.get(), "\u53bb\u4f7f\u7528"));
            this.btn.setClickable(true);
            this.btn.setHovered(false);
            this.btn.setTextColor(-16777216);
            return;
        }
        this.btn.setText(b(this.cardInfo.button_text.get(), "\u9886\u53d6"));
        this.btn.setClickable(true);
        this.btn.setHovered(true);
        this.btn.setTextColor(-1);
    }
}

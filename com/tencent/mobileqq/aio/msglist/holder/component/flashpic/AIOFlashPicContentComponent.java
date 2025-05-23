package com.tencent.mobileqq.aio.msglist.holder.component.flashpic;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.PicMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.AIOMsgItemUIState;
import com.tencent.mobileqq.aio.msglist.holder.base.AIOPicDownloader;
import com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.aio.msglist.payload.a;
import com.tencent.mobileqq.aio.utils.p;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqui.widget.RoundBubbleImageView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.widget.ToastView;
import com.tencent.qqnt.aio.holder.IMsgItemMviUIState;
import com.tencent.qqnt.aio.menu.af;
import com.tencent.qqnt.aio.menu.aj;
import com.tencent.qqnt.aio.menu.ap;
import com.tencent.qqnt.aio.menu.h;
import com.tencent.qqnt.aio.menu.u;
import com.tencent.qqnt.aio.menu.ui.d;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 I2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001JB\u000f\u0012\u0006\u0010&\u001a\u00020#\u00a2\u0006\u0004\bG\u0010HJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\tH\u0002J\u001e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J&\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 H\u0016R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u001b\u0010.\u001a\u00020\u00038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0016\u00102\u001a\u0004\u0018\u00010/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u001b\u00107\u001a\u0002038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b4\u0010+\u001a\u0004\b5\u00106R\u001b\u0010<\u001a\u0002088BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b9\u0010+\u001a\u0004\b:\u0010;R\u001b\u0010?\u001a\u0002038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b=\u0010+\u001a\u0004\b>\u00106R\u001b\u0010D\u001a\u00020@8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bA\u0010+\u001a\u0004\bB\u0010CR\u0016\u0010F\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010E\u00a8\u0006K"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/flashpic/AIOFlashPicContentComponent;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/BaseContentComponent;", "Lcom/tencent/mobileqq/aio/msg/PicMsgItem;", "Landroid/widget/RelativeLayout;", "K1", "", "msgId", "", "hasRead", "", "R1", "T1", "V1", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "", "payloads", "Q1", "Lcom/tencent/mobileqq/aio/msglist/payload/a$aw;", "payload", "U1", "Landroid/view/View;", "c1", "Lcom/tencent/mobileqq/aio/msglist/holder/component/b;", "p1", "", "position", "b1", "Lcom/tencent/qqnt/aio/holder/IMsgItemMviUIState;", "state", "g1", "", "Lcom/tencent/qqnt/aio/menu/ui/d;", ICustomDataEditor.STRING_PARAM_1, "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "context", BdhLogUtil.LogTag.Tag_Conn, "J", "mCurMsgId", "D", "Lkotlin/Lazy;", "L1", "()Landroid/widget/RelativeLayout;", "contentView", "Landroid/graphics/drawable/Drawable;", "E", "Landroid/graphics/drawable/Drawable;", "loadingDrawable", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "O1", "()Landroid/widget/ImageView;", ToastView.ICON_LOADING, "Lcom/tencent/mobileqq/qqui/widget/RoundBubbleImageView;", "G", "M1", "()Lcom/tencent/mobileqq/qqui/widget/RoundBubbleImageView;", "flashPicView", "H", "N1", "icon", "Landroid/widget/TextView;", "I", "P1", "()Landroid/widget/TextView;", "text", "Z", "isRead", "<init>", "(Landroid/content/Context;)V", "K", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOFlashPicContentComponent extends BaseContentComponent<PicMsgItem> {
    static IPatchRedirector $redirector_;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private long mCurMsgId;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy contentView;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private final Drawable loadingDrawable;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy loading;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy flashPicView;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy icon;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy text;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean isRead;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/flashpic/AIOFlashPicContentComponent$a;", "", "", "BUBBLE_MARGIN", UserInfo.SEX_FEMALE, "BUBBLE_ROUND", "", "LOADING_SIZE", "I", "", "TAG", "Ljava/lang/String;", "TEXT_MARGIN", "TEXT_SIZE", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.flashpic.AIOFlashPicContentComponent$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60555);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOFlashPicContentComponent(@NotNull Context context) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.context = context;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RelativeLayout>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.flashpic.AIOFlashPicContentComponent$contentView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOFlashPicContentComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RelativeLayout invoke() {
                RelativeLayout K1;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (RelativeLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                K1 = AIOFlashPicContentComponent.this.K1();
                return K1;
            }
        });
        this.contentView = lazy;
        this.loadingDrawable = ResourcesCompat.getDrawable(context.getResources(), R.drawable.common_loading2, null);
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.flashpic.AIOFlashPicContentComponent$loading$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOFlashPicContentComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ImageView invoke() {
                Context context2;
                Drawable drawable;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (ImageView) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                context2 = AIOFlashPicContentComponent.this.context;
                ImageView imageView = new ImageView(context2);
                drawable = AIOFlashPicContentComponent.this.loadingDrawable;
                imageView.setImageDrawable(drawable);
                return imageView;
            }
        });
        this.loading = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<RoundBubbleImageView>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.flashpic.AIOFlashPicContentComponent$flashPicView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOFlashPicContentComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RoundBubbleImageView invoke() {
                Context context2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (RoundBubbleImageView) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                context2 = AIOFlashPicContentComponent.this.context;
                RoundBubbleImageView roundBubbleImageView = new RoundBubbleImageView(context2);
                roundBubbleImageView.setId(R.id.shr);
                roundBubbleImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                roundBubbleImageView.setAdjustViewBounds(true);
                roundBubbleImageView.setRadiusDP(15.0f);
                roundBubbleImageView.setBackgroundColor(roundBubbleImageView.getResources().getColor(R.color.b4u, null));
                return roundBubbleImageView;
            }
        });
        this.flashPicView = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.flashpic.AIOFlashPicContentComponent$icon$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOFlashPicContentComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ImageView invoke() {
                Context context2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (ImageView) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                context2 = AIOFlashPicContentComponent.this.context;
                ImageView imageView = new ImageView(context2);
                imageView.setId(R.id.shq);
                return imageView;
            }
        });
        this.icon = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.flashpic.AIOFlashPicContentComponent$text$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOFlashPicContentComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                Context context2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (TextView) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                context2 = AIOFlashPicContentComponent.this.context;
                TextView textView = new TextView(context2);
                textView.setText(textView.getContext().getResources().getString(R.string.f170221yr0));
                textView.setTextSize(12.0f);
                textView.setTextColor(textView.getContext().getResources().getColor(R.color.f158017al3));
                return textView;
            }
        });
        this.text = lazy5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RelativeLayout K1() {
        RelativeLayout relativeLayout = new RelativeLayout(this.context);
        View M1 = M1();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = ViewUtils.dip2px(10.0f);
        layoutParams.topMargin = ViewUtils.dip2px(10.0f);
        layoutParams.rightMargin = ViewUtils.dip2px(10.0f);
        layoutParams.bottomMargin = ViewUtils.dip2px(10.0f);
        Unit unit = Unit.INSTANCE;
        relativeLayout.addView(M1, layoutParams);
        View O1 = O1();
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(p.c(16), p.c(16));
        layoutParams2.addRule(13);
        relativeLayout.addView(O1, layoutParams2);
        RelativeLayout relativeLayout2 = new RelativeLayout(this.context);
        ImageView N1 = N1();
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(14);
        relativeLayout2.addView(N1, layoutParams3);
        TextView P1 = P1();
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(3, R.id.shq);
        layoutParams4.addRule(14);
        layoutParams4.topMargin = ViewUtils.dpToPx(10.0f);
        relativeLayout2.addView(P1, layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(13);
        relativeLayout.addView(relativeLayout2, layoutParams5);
        return relativeLayout;
    }

    private final RelativeLayout L1() {
        return (RelativeLayout) this.contentView.getValue();
    }

    private final RoundBubbleImageView M1() {
        return (RoundBubbleImageView) this.flashPicView.getValue();
    }

    private final ImageView N1() {
        return (ImageView) this.icon.getValue();
    }

    private final ImageView O1() {
        return (ImageView) this.loading.getValue();
    }

    private final TextView P1() {
        return (TextView) this.text.getValue();
    }

    private final boolean Q1(com.tencent.aio.data.msglist.a msgItem, List<Object> payloads) {
        Object obj;
        if (payloads.isEmpty()) {
            return true;
        }
        Intrinsics.checkNotNull(msgItem, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.PicMsgItem");
        E1((PicMsgItem) msgItem);
        for (Object obj2 : payloads) {
            if ((obj2 instanceof HashMap) && (obj = ((Map) obj2).get(AIOMsgItemPayloadType.RICH_MEDIA_PAYLOAD)) != null) {
                U1((a.aw) obj);
            }
        }
        return false;
    }

    private final void R1(long msgId, boolean hasRead) {
        QLog.i("AIOFlashPicContentComponent", 1, "mCurMsgId: " + this.mCurMsgId + ", eventMsgId: " + msgId);
        if (this.mCurMsgId == msgId) {
            QLog.i("AIOFlashPicContentComponent", 1, "observe flash pic read event " + hasRead);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.flashpic.a
                @Override // java.lang.Runnable
                public final void run() {
                    AIOFlashPicContentComponent.S1(AIOFlashPicContentComponent.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S1(AIOFlashPicContentComponent this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isRead = true;
        this$0.T1();
        this$0.M1().setClickable(false);
    }

    private final void T1() {
        M1().setImageResource(R.drawable.mkv);
        N1().setImageResource(R.drawable.mkw);
        P1().setVisibility(0);
        O1().setVisibility(8);
    }

    private final void U1(a.aw payload) {
        if (QLog.isColorLevel()) {
            QLog.d("AIOFlashPicContentComponent", 2, "[updateBindUIState] RichMediaPayload fileTransNotifyInfo = " + payload.a());
        }
        FileTransNotifyInfo a16 = payload.a();
        q1().l2(a16.msgElementId, a16.trasferStatus, a16.filePath, AIOPicDownloader.f190570a.i(q1().p2(), a16.fileDownType, a16.thumbSize));
        if (a16.trasferStatus == 4 && !TextUtils.isEmpty(a16.filePath)) {
            V1();
        }
    }

    private final void V1() {
        com.tencent.mobileqq.aio.msglist.holder.base.util.c.f190636a.f(M1(), O1(), q1(), q1().o2());
        N1().setImageResource(R.drawable.mkx);
        P1().setVisibility(8);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mobileqq.aio.msglist.holder.component.c
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(position), msgItem, payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        this.mCurMsgId = msgItem.getMsgId();
        E1((PicMsgItem) msgItem);
        boolean s26 = q1().s2();
        this.isRead = s26;
        if (s26) {
            T1();
            return;
        }
        if (Q1(msgItem, payloads)) {
            if (x1()) {
                QLog.i("AIOFlashPicContentComponent", 1, "[bind] same data, msgId=" + msgItem.getMsgId());
                return;
            }
            V1();
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    public View c1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return L1();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c, com.tencent.mvi.mvvm.BaseVB
    /* renamed from: g1 */
    public void handleUIState(@NotNull IMsgItemMviUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof AIOMsgItemUIState.FlashPicRead) {
            AIOMsgItemUIState.FlashPicRead flashPicRead = (AIOMsgItemUIState.FlashPicRead) state;
            R1(flashPicRead.b(), flashPicRead.a());
        } else {
            super.handleUIState(state);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    /* renamed from: p1 */
    public com.tencent.mobileqq.aio.msglist.holder.component.b createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.aio.msglist.holder.component.b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new b();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent
    @NotNull
    public List<d> s1() {
        List<d> mutableListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new ap(getMContext(), q1(), this), new af(getMContext(), q1(), this), new h(getMContext(), q1(), this), new u(getMContext(), q1(), this), new aj(getMContext(), q1(), this));
            return mutableListOf;
        }
        return (List) iPatchRedirector.redirect((short) 6, (Object) this);
    }
}

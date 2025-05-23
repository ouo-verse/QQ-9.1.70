package com.tencent.mobileqq.aio.msglist.holder.component.LocationShare;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.LocationShareMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.d;
import com.tencent.mobileqq.aio.msglist.holder.skin.AIOBubbleSkinInfo;
import com.tencent.mobileqq.aio.msglist.holder.skin.padding.a;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.aio.utils.m;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IQQTextApi;
import com.tencent.qqnt.aio.menu.u;
import com.tencent.qqnt.aio.refresher.g;
import com.tencent.qqnt.aio.refresher.h;
import com.tencent.qqnt.aio.utils.s;
import com.tencent.qqnt.aio.widget.SelectableLinearLayout;
import com.tencent.qqnt.emotion.text.style.api.IEmojiSpanService;
import com.tencent.qqnt.kernel.nativeinterface.FaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.widget.ThemeImageWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 Z2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001[B\u000f\u0012\u0006\u00102\u001a\u00020-\u00a2\u0006\u0004\bX\u0010YJ&\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u0012\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0016\u0010\u0017\u001a\u00020\u00162\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0018\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0004H\u0002J\u0010\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\b\u0010\u001f\u001a\u00020\u000bH\u0002J \u0010$\u001a\u00020\u000b2\u0016\u0010#\u001a\u0012\u0012\u0004\u0012\u00020!0 j\b\u0012\u0004\u0012\u00020!`\"H\u0002J\u0016\u0010'\u001a\u00020&2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020!0\rH\u0002J\b\u0010(\u001a\u00020\u000bH\u0002J\b\u0010)\u001a\u00020\u000bH\u0002J\u0018\u0010,\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0004H\u0002R\u0017\u00102\u001a\u00020-8\u0006\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001b\u00107\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u001b\u0010:\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b8\u00104\u001a\u0004\b9\u00106R\u001b\u0010=\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b;\u00104\u001a\u0004\b<\u00106R\u001b\u0010@\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b>\u00104\u001a\u0004\b?\u00106R\u0014\u0010C\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u001b\u0010H\u001a\u00020D8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bE\u00104\u001a\u0004\bF\u0010GR\u001b\u0010L\u001a\u00020I8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bB\u00104\u001a\u0004\bJ\u0010KR\u001b\u0010P\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bM\u00104\u001a\u0004\bN\u0010OR\u001b\u0010\u0019\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bQ\u00104\u001a\u0004\bR\u0010SR\u0014\u0010W\u001a\u00020T8\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010V\u00a8\u0006\\"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/LocationShare/AIOLocationShareComponent;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/BaseContentComponent;", "Lcom/tencent/mobileqq/aio/msg/LocationShareMsgItem;", "Landroid/view/View$OnClickListener;", "", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "", "payloads", "", "b1", "", "Lcom/tencent/qqnt/aio/menu/ui/d;", ICustomDataEditor.STRING_PARAM_1, "Landroid/view/View;", "c1", "v", NodeProps.ON_CLICK, "Lcom/tencent/mobileqq/aio/msglist/holder/component/b;", "p1", "", "R1", "Landroid/widget/TextView;", "textView", "imageResId", "T1", "Lcom/tencent/mobileqq/aio/msglist/holder/skin/AIOBubbleSkinInfo;", "bubbleInfo", "W1", "U1", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "Lkotlin/collections/ArrayList;", "tempList", "L1", "msgElements", "", "M1", "V1", "X1", "color", c.f123400v, "S1", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "getBubblePaddingTop", "()I", "bubblePaddingTop", "D", "getBubblePaddingBottom", "bubblePaddingBottom", "E", "getBubblePaddingLeft", "bubblePaddingLeft", UserInfo.SEX_FEMALE, "getBubblePaddingRight", "bubblePaddingRight", "G", "I", "bubbleMaxWidth", "Landroidx/constraintlayout/widget/ConstraintLayout;", "H", "P1", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "mContentWithForeground", "Lcom/tencent/qqnt/aio/widget/SelectableLinearLayout;", "O1", "()Lcom/tencent/qqnt/aio/widget/SelectableLinearLayout;", "mContent", "J", "N1", "()Landroid/view/View;", "foregroundView", "K", "Q1", "()Landroid/widget/TextView;", "Landroid/content/res/ColorStateList;", "L", "Landroid/content/res/ColorStateList;", "normalBlackTextColor", "<init>", "(Landroid/content/Context;)V", "M", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOLocationShareComponent extends BaseContentComponent<LocationShareMsgItem> implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String N;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy bubblePaddingTop;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy bubblePaddingBottom;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy bubblePaddingLeft;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy bubblePaddingRight;

    /* renamed from: G, reason: from kotlin metadata */
    private final int bubbleMaxWidth;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy mContentWithForeground;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy mContent;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy foregroundView;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy textView;

    /* renamed from: L, reason: from kotlin metadata */
    @SuppressLint({"UseCompatLoadingForColorStateLists"})
    @NotNull
    private final ColorStateList normalBlackTextColor;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/LocationShare/AIOLocationShareComponent$a;", "", "", "ALPHA_BIT_NUM", "I", "ALPHA_MAX", "ALPHA_MIN", "ALPHA_UTIL", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.LocationShare.AIOLocationShareComponent$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59969);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
            N = "AIOLocationShareComponent";
        }
    }

    public AIOLocationShareComponent(@NotNull Context context) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        Lazy lazy7;
        Lazy lazy8;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.context = context;
        lazy = LazyKt__LazyJVMKt.lazy(AIOLocationShareComponent$bubblePaddingTop$2.INSTANCE);
        this.bubblePaddingTop = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(AIOLocationShareComponent$bubblePaddingBottom$2.INSTANCE);
        this.bubblePaddingBottom = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(AIOLocationShareComponent$bubblePaddingLeft$2.INSTANCE);
        this.bubblePaddingLeft = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(AIOLocationShareComponent$bubblePaddingRight$2.INSTANCE);
        this.bubblePaddingRight = lazy4;
        this.bubbleMaxWidth = a.C7329a.f192417a.b();
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<ConstraintLayout>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.LocationShare.AIOLocationShareComponent$mContentWithForeground$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOLocationShareComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ConstraintLayout invoke() {
                SelectableLinearLayout O1;
                View N1;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (ConstraintLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                ConstraintLayout constraintLayout = new ConstraintLayout(AIOLocationShareComponent.this.getContext());
                AIOLocationShareComponent aIOLocationShareComponent = AIOLocationShareComponent.this;
                constraintLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                O1 = aIOLocationShareComponent.O1();
                constraintLayout.addView(O1);
                ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(0, 0);
                layoutParams.startToStart = 0;
                layoutParams.endToEnd = 0;
                layoutParams.topToTop = 0;
                layoutParams.bottomToBottom = 0;
                layoutParams.leftToLeft = 0;
                layoutParams.rightToRight = 0;
                layoutParams.matchConstraintPercentWidth = 1.0f;
                layoutParams.matchConstraintPercentHeight = 1.0f;
                N1 = aIOLocationShareComponent.N1();
                constraintLayout.addView(N1, layoutParams);
                return constraintLayout;
            }
        });
        this.mContentWithForeground = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<SelectableLinearLayout>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.LocationShare.AIOLocationShareComponent$mContent$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOLocationShareComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SelectableLinearLayout invoke() {
                TextView Q1;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (SelectableLinearLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                SelectableLinearLayout selectableLinearLayout = new SelectableLinearLayout(AIOLocationShareComponent.this.getContext());
                AIOLocationShareComponent aIOLocationShareComponent = AIOLocationShareComponent.this;
                selectableLinearLayout.setOrientation(1);
                selectableLinearLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                Q1 = aIOLocationShareComponent.Q1();
                selectableLinearLayout.addView(Q1);
                return selectableLinearLayout;
            }
        });
        this.mContent = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.LocationShare.AIOLocationShareComponent$foregroundView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOLocationShareComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new View(AIOLocationShareComponent.this.getContext()) : (View) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.foregroundView = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.LocationShare.AIOLocationShareComponent$textView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOLocationShareComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                ColorStateList colorStateList;
                int i3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (TextView) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                TextView textView = new TextView(AIOLocationShareComponent.this.getContext());
                AIOLocationShareComponent aIOLocationShareComponent = AIOLocationShareComponent.this;
                colorStateList = aIOLocationShareComponent.normalBlackTextColor;
                textView.setTextColor(colorStateList);
                textView.setTextSize(0, textView.getContext().getResources().getDimensionPixelSize(R.dimen.ayp));
                i3 = aIOLocationShareComponent.bubbleMaxWidth;
                textView.setMaxWidth(i3);
                textView.setGravity(16);
                return textView;
            }
        });
        this.textView = lazy8;
        ColorStateList colorStateList = context.getColorStateList(R.color.skin_chat_buble);
        Intrinsics.checkNotNullExpressionValue(colorStateList, "context.getColorStateList(R.color.skin_chat_buble)");
        this.normalBlackTextColor = colorStateList;
    }

    private final void L1(ArrayList<MsgElement> tempList) {
        if (tempList.isEmpty()) {
            return;
        }
        if (q1().i2() == null) {
            Q1().setText(((IQQTextApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IQQTextApi.class)).getQQText(M1(tempList), 13, com.tencent.qqnt.emotion.constant.b.b(), Q1(), q1()), TextView.BufferType.SPANNABLE);
            return;
        }
        Q1().setText(q1().i2(), TextView.BufferType.SPANNABLE);
    }

    private final CharSequence M1(List<MsgElement> msgElements) {
        int intValue;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (MsgElement msgElement : msgElements) {
            int i3 = msgElement.elementType;
            if (i3 == 6) {
                FaceElement faceElement = msgElement.faceElement;
                if (faceElement != null) {
                    Intrinsics.checkNotNullExpressionValue(faceElement, "faceElement");
                    QRouteApi api = QRoute.api(IEmojiSpanService.class);
                    Intrinsics.checkNotNullExpressionValue(api, "api(IEmojiSpanService::class.java)");
                    IEmojiSpanService iEmojiSpanService = (IEmojiSpanService) api;
                    int i16 = faceElement.faceType;
                    int i17 = faceElement.faceIndex;
                    Integer num = faceElement.imageType;
                    if (num == null) {
                        intValue = 0;
                    } else {
                        Intrinsics.checkNotNullExpressionValue(num, "it.imageType ?: 0");
                        intValue = num.intValue();
                    }
                    spannableStringBuilder.append(IEmojiSpanService.a.a(iEmojiSpanService, i16, i17, intValue, true, 0, 16, null));
                }
            } else if (i3 == 1) {
                spannableStringBuilder.append((CharSequence) s.f352317a.b(msgElement));
            }
        }
        return spannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View N1() {
        return (View) this.foregroundView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SelectableLinearLayout O1() {
        return (SelectableLinearLayout) this.mContent.getValue();
    }

    private final ConstraintLayout P1() {
        return (ConstraintLayout) this.mContentWithForeground.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView Q1() {
        return (TextView) this.textView.getValue();
    }

    private final boolean R1(List<Object> payloads) {
        AIOBubbleSkinInfo x06;
        if (payloads.isEmpty()) {
            return true;
        }
        for (Object obj : payloads) {
            if (obj instanceof HashMap) {
                Map map = (Map) obj;
                if (map.get(AIOMsgItemPayloadType.LOCATION_SHARE_PAYLOAD) != null) {
                    if (QLog.isColorLevel()) {
                        QLog.i(N, 2, "bind LocationShare closed!!");
                    }
                    V1();
                    X1();
                }
                if (map.get(AIOMsgItemPayloadType.THEME_CHANGE_PAYLOAD) != null && (x06 = q1().x0()) != null) {
                    W1(x06);
                }
            }
        }
        return false;
    }

    private final int S1(int color, int alpha) {
        int i3;
        if (alpha < 0) {
            i3 = 0;
        } else {
            i3 = alpha;
        }
        if (alpha > 255) {
            i3 = 255;
        }
        return (color & 16777215) | (i3 << 24);
    }

    private final void T1(TextView textView, int imageResId) {
        Drawable drawable = getMContext().getResources().getDrawable(imageResId);
        drawable.setBounds(0, 0, 50, 50);
        textView.setCompoundDrawables(drawable, null, null, null);
        textView.setCompoundDrawablePadding(this.context.getResources().getDimensionPixelSize(R.dimen.f158206ab));
    }

    private final void U1() {
        AIOBubbleSkinInfo x06 = q1().x0();
        m mVar = m.f194167a;
        String b16 = mVar.b(q1());
        if ((x06 == null || x06.d() == 0) && !TextUtils.isEmpty(b16)) {
            if (QLog.isDevelopLevel()) {
                QLog.i(N, 4, "[tryGetBubbleInfo]: qqtext is " + q1().i2());
            }
            String a16 = mVar.a(q1());
            LocationShareMsgItem q16 = q1();
            String i26 = q1().i2();
            if (i26 == null) {
                i26 = "";
            }
            g gVar = new g(q16, b16, a16, i26, null, 16, null);
            sendIntent(new d.ah(gVar));
            h c16 = gVar.c();
            if (c16 != null) {
                if (QLog.isDevelopLevel()) {
                    QLog.i(N, 4, "[tryGetBubbleInfo]: resp, qqtext is " + q1().i2());
                }
                W1(c16.a());
            }
        }
    }

    private final void V1() {
        int i3;
        if (q1().j2()) {
            if (!ThemeImageWrapper.isNightMode()) {
                if (q1().isSelf()) {
                    i3 = R.drawable.aio_msg_share_location_self;
                } else {
                    i3 = R.drawable.aio_msg_share_location;
                }
            } else {
                i3 = R.drawable.aio_msg_share_location_dark;
            }
        } else if (!ThemeImageWrapper.isNightMode()) {
            if (q1().isSelf()) {
                i3 = R.drawable.aio_msg_share_location_disabled_self;
            } else {
                i3 = R.drawable.aio_msg_share_location_disabled;
            }
        } else {
            i3 = R.drawable.aio_msg_share_location_dark_disabled;
        }
        T1(Q1(), i3);
        Q1().setClickable(q1().j2());
    }

    private final void W1(AIOBubbleSkinInfo bubbleInfo) {
        Integer a16;
        Drawable a17;
        Drawable a18;
        boolean z16;
        int minWidth;
        int minHeight;
        if (QLog.isColorLevel()) {
            QLog.i(N, 2, "updateSkinBubbleInfo");
        }
        AIOBubbleSkinInfo.BackgroundImageInfo a19 = bubbleInfo.a();
        com.tencent.mobileqq.aio.msglist.holder.skin.padding.d dVar = null;
        if (a19 != null && (a18 = a19.a()) != null) {
            TextView Q1 = Q1();
            Integer valueOf = Integer.valueOf(a19.g());
            boolean z17 = true;
            if (valueOf.intValue() != Q1().getMinWidth()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!Boolean.valueOf(z16).booleanValue()) {
                valueOf = null;
            }
            if (valueOf != null) {
                minWidth = valueOf.intValue();
            } else {
                minWidth = Q1().getMinWidth();
            }
            Q1.setMinWidth(minWidth);
            TextView Q12 = Q1();
            Integer valueOf2 = Integer.valueOf(a19.f());
            if (valueOf2.intValue() == Q1().getMinHeight()) {
                z17 = false;
            }
            if (!Boolean.valueOf(z17).booleanValue()) {
                valueOf2 = null;
            }
            if (valueOf2 != null) {
                minHeight = valueOf2.intValue();
            } else {
                minHeight = Q1().getMinHeight();
            }
            Q12.setMinHeight(minHeight);
            Q1().setBackground(a18);
        }
        com.tencent.mobileqq.aio.msglist.holder.skin.padding.a b16 = bubbleInfo.b();
        if (b16 instanceof com.tencent.mobileqq.aio.msglist.holder.skin.padding.d) {
            dVar = (com.tencent.mobileqq.aio.msglist.holder.skin.padding.d) b16;
        }
        if (dVar != null && (Q1().getPaddingLeft() != dVar.c() || Q1().getPaddingRight() != dVar.d() || Q1().getPaddingTop() != dVar.e() || Q1().getPaddingBottom() != dVar.b())) {
            Q1().setPadding(dVar.c(), dVar.e(), dVar.d(), dVar.b());
        }
        AIOBubbleSkinInfo.b c16 = bubbleInfo.c();
        if (c16 != null && (a17 = c16.a()) != null) {
            N1().setBackground(a17);
        }
        AIOBubbleSkinInfo.c e16 = bubbleInfo.e();
        if (e16 != null && (a16 = e16.a()) != null) {
            Q1().setTextColor(a16.intValue());
            X1();
        }
    }

    private final void X1() {
        if (q1().j2()) {
            Q1().setTextColor(S1(Q1().getCurrentTextColor(), 255));
        } else {
            Q1().setTextColor(S1(Q1().getCurrentTextColor(), 128));
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mobileqq.aio.msglist.holder.component.c
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        List filterNotNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(position), msgItem, payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        LocationShareMsgItem locationShareMsgItem = (LocationShareMsgItem) msgItem;
        E1(locationShareMsgItem);
        if (QLog.isColorLevel()) {
            QLog.i(N, 2, "bind title:" + q1().i2() + " isSharingLocation:" + q1().j2());
        }
        if (!R1(payloads)) {
            return;
        }
        Q1().setOnClickListener(this);
        Q1().setText(q1().i2());
        if (com.tencent.qqnt.util.b.f362976b.enableTalkBack()) {
            Q1().setContentDescription(q1().i2());
        }
        ArrayList<MsgElement> arrayList = new ArrayList<>();
        ArrayList<MsgElement> elements = locationShareMsgItem.getMsgRecord().elements;
        if (elements != null) {
            Intrinsics.checkNotNullExpressionValue(elements, "elements");
            filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(elements);
            if (filterNotNull != null) {
                Iterator it = filterNotNull.iterator();
                while (it.hasNext()) {
                    arrayList.add((MsgElement) it.next());
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        AIOBubbleSkinInfo x06 = q1().x0();
        if (x06 != null) {
            W1(x06);
        }
        V1();
        L1(arrayList);
        U1();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    public View c1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return P1();
    }

    @NotNull
    public final Context getContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Context) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) v3);
        } else {
            sendIntent(new a(this.context, q1().getMsgRecord()));
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    /* renamed from: p1 */
    public com.tencent.mobileqq.aio.msglist.holder.component.b createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (com.tencent.mobileqq.aio.msglist.holder.component.b) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return new b();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent
    @NotNull
    public List<com.tencent.qqnt.aio.menu.ui.d> s1() {
        List<com.tencent.qqnt.aio.menu.ui.d> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.qqnt.aio.menu.ui.d[]{new com.tencent.qqnt.aio.menu.h(getMContext(), q1(), this), new u(getMContext(), q1(), this)});
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 4, (Object) this);
    }
}

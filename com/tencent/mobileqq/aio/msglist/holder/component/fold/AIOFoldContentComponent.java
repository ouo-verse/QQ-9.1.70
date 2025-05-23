package com.tencent.mobileqq.aio.msglist.holder.component.fold;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.FoldMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.ark.ArkAppLoadLayout;
import com.tencent.mobileqq.aio.msglist.holder.component.fold.d;
import com.tencent.mobileqq.aio.msglist.holder.d;
import com.tencent.mobileqq.aio.msglist.holder.skin.AIOBubbleSkinInfo;
import com.tencent.mobileqq.aio.msglist.holder.skin.padding.a;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.aio.utils.m;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.RichTextHelper;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.text.MarginSpan;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.refresher.g;
import com.tencent.qqnt.aio.refresher.h;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.rmonitor.custom.ICustomDataEditor;
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
@Metadata(d1 = {"\u0000\u00ae\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b!\b\u0000\u0018\u0000 p2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001qB\u000f\u0012\u0006\u00108\u001a\u000205\u00a2\u0006\u0004\bn\u0010oJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J&\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0016\u0010\u0015\u001a\u00020\u00132\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J6\u0010\u001a\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00022\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u00182\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\b\u001a\u00020\u0002H\u0002J \u0010\"\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0005H\u0002J\u0010\u0010#\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\u0010\u0010%\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u0005H\u0002J\u0010\u0010(\u001a\u00020\f2\u0006\u0010'\u001a\u00020&H\u0002J\u0010\u0010)\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u0005H\u0002J!\u0010-\u001a\u00020\f2\b\u0010*\u001a\u0004\u0018\u00010\u00052\u0006\u0010,\u001a\u00020+H\u0002\u00a2\u0006\u0004\b-\u0010.J\b\u0010/\u001a\u00020\fH\u0002J\u0010\u00102\u001a\u00020\f2\u0006\u00101\u001a\u000200H\u0002J\u0012\u00104\u001a\u00020\f2\b\u00103\u001a\u0004\u0018\u00010\u001bH\u0003R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u001b\u0010>\u001a\u0002098BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u001b\u0010C\u001a\u00020?8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b@\u0010;\u001a\u0004\bA\u0010BR\u001d\u0010G\u001a\u0004\u0018\u00010\u00038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bD\u0010;\u001a\u0004\bE\u0010FR\u001b\u0010L\u001a\u00020H8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bI\u0010;\u001a\u0004\bJ\u0010KR\u0018\u0010P\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u001b\u0010U\u001a\u00020Q8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bR\u0010;\u001a\u0004\bS\u0010TR\u001b\u0010Y\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bV\u0010;\u001a\u0004\bW\u0010XR\u001b\u0010\\\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bZ\u0010;\u001a\u0004\b[\u0010XR\u001b\u0010_\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b]\u0010;\u001a\u0004\b^\u0010XR\u001b\u0010b\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b`\u0010;\u001a\u0004\ba\u0010XR\u0014\u0010d\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bc\u0010VR\u001b\u0010g\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\be\u0010;\u001a\u0004\bf\u0010XR\u001b\u0010j\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bh\u0010;\u001a\u0004\bi\u0010XR\u001b\u0010m\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bk\u0010;\u001a\u0004\bl\u0010X\u00a8\u0006r"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/fold/AIOFoldContentComponent;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/BaseContentComponent;", "Lcom/tencent/mobileqq/aio/msg/FoldMsgItem;", "Landroid/view/View;", "c1", "", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "", "payloads", "", "b1", "Lcom/tencent/mobileqq/aio/msglist/holder/component/fold/c;", "S1", "", "Lcom/tencent/qqnt/aio/menu/ui/d;", ICustomDataEditor.STRING_PARAM_1, "", "d2", "c2", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "Lkotlin/collections/ArrayList;", "tempList", "O1", "", "Q1", "P1", "Landroid/graphics/drawable/Drawable;", "drawable", "backgroundMinWidth", "backgroundMinHeight", "e2", "f2", "color", SemanticAttributes.DbSystemValues.H2, "Landroid/content/res/ColorStateList;", NodeProps.COLORS, "i2", "g2", "unit", "", "size", "j2", "(Ljava/lang/Integer;F)V", "k2", "Lcom/tencent/mobileqq/aio/msglist/holder/skin/AIOBubbleSkinInfo;", "bubbleSkin", "l2", "toastTip", "m2", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "context", "Landroid/widget/FrameLayout;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "Y1", "()Landroid/widget/FrameLayout;", "mContentWithForeground", "Landroid/widget/LinearLayout;", "D", "Z1", "()Landroid/widget/LinearLayout;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "E", "X1", "()Landroid/view/View;", "mContent", "Landroid/widget/ImageView;", UserInfo.SEX_FEMALE, "W1", "()Landroid/widget/ImageView;", "foregroundView", "Lcom/tencent/mobileqq/aio/msglist/holder/component/ark/ArkAppLoadLayout;", "G", "Lcom/tencent/mobileqq/aio/msglist/holder/component/ark/ArkAppLoadLayout;", "arkAppLoadLayout", "Lcom/tencent/fastertextview/wrapper/a;", "H", ICustomDataEditor.STRING_ARRAY_PARAM_2, "()Lcom/tencent/fastertextview/wrapper/a;", "txtView", "I", "getBubblePaddingTop", "()I", "bubblePaddingTop", "J", "getBubblePaddingBottom", "bubblePaddingBottom", "K", "getBubblePaddingLeft", "bubblePaddingLeft", "L", "getBubblePaddingRight", "bubblePaddingRight", "M", "bubbleMaxWidth", "N", "V1", "arkFoldViewWidth", "P", "T1", "arkFoldViewHeight", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "U1", "arkFoldViewPadding", "<init>", "(Landroid/content/Context;)V", BdhLogUtil.LogTag.Tag_Req, "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOFoldContentComponent extends BaseContentComponent<FoldMsgItem> {
    static IPatchRedirector $redirector_;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy mContentWithForeground;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy rootView;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy mContent;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy foregroundView;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private ArkAppLoadLayout arkAppLoadLayout;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy txtView;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy bubblePaddingTop;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy bubblePaddingBottom;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy bubblePaddingLeft;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Lazy bubblePaddingRight;

    /* renamed from: M, reason: from kotlin metadata */
    private final int bubbleMaxWidth;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final Lazy arkFoldViewWidth;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final Lazy arkFoldViewHeight;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final Lazy arkFoldViewPadding;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/fold/AIOFoldContentComponent$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.fold.AIOFoldContentComponent$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/fold/AIOFoldContentComponent$b", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/MotionEvent;", "e", "", "onDoubleTap", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b extends GestureDetector.SimpleOnGestureListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CharSequence f190862d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AIOFoldContentComponent f190863e;

        b(CharSequence charSequence, AIOFoldContentComponent aIOFoldContentComponent) {
            this.f190862d = charSequence;
            this.f190863e = aIOFoldContentComponent;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) charSequence, (Object) aIOFoldContentComponent);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(@Nullable MotionEvent e16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) e16)).booleanValue();
            }
            QLog.d("AIOTextContentComponent", 1, "onDoubleTap  toastTip " + ((Object) this.f190862d));
            QQToast.makeText(this.f190863e.context, 1, this.f190862d, 0).show();
            return true;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60673);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOFoldContentComponent(@NotNull Context context) {
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
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.context = context;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.fold.AIOFoldContentComponent$mContentWithForeground$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOFoldContentComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FrameLayout invoke() {
                View X1;
                ImageView W1;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (FrameLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                FrameLayout frameLayout = new FrameLayout(AIOFoldContentComponent.this.context);
                AIOFoldContentComponent aIOFoldContentComponent = AIOFoldContentComponent.this;
                frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                X1 = aIOFoldContentComponent.X1();
                frameLayout.addView(X1);
                W1 = aIOFoldContentComponent.W1();
                frameLayout.addView(W1);
                return frameLayout;
            }
        });
        this.mContentWithForeground = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.fold.AIOFoldContentComponent$rootView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOFoldContentComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LinearLayout invoke() {
                FrameLayout Y1;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (LinearLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                LinearLayout linearLayout = new LinearLayout(AIOFoldContentComponent.this.context);
                AIOFoldContentComponent aIOFoldContentComponent = AIOFoldContentComponent.this;
                linearLayout.setOrientation(1);
                Y1 = aIOFoldContentComponent.Y1();
                linearLayout.addView(Y1);
                return linearLayout;
            }
        });
        this.rootView = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.fold.AIOFoldContentComponent$mContent$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOFoldContentComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final View invoke() {
                com.tencent.fastertextview.wrapper.a a26;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (View) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                a26 = AIOFoldContentComponent.this.a2();
                return a26.g();
            }
        });
        this.mContent = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.fold.AIOFoldContentComponent$foregroundView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOFoldContentComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ImageView invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new ImageView(AIOFoldContentComponent.this.context) : (ImageView) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.foregroundView = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.fastertextview.wrapper.a>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.fold.AIOFoldContentComponent$txtView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOFoldContentComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.fastertextview.wrapper.a invoke() {
                int i3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (com.tencent.fastertextview.wrapper.a) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                com.tencent.mobileqq.aio.msglist.holder.component.text.util.a aVar = com.tencent.mobileqq.aio.msglist.holder.component.text.util.a.f192006a;
                Context context2 = AIOFoldContentComponent.this.context;
                i3 = AIOFoldContentComponent.this.bubbleMaxWidth;
                return com.tencent.mobileqq.aio.msglist.holder.component.text.util.a.b(aVar, context2, i3, null, 4, null);
            }
        });
        this.txtView = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(AIOFoldContentComponent$bubblePaddingTop$2.INSTANCE);
        this.bubblePaddingTop = lazy6;
        lazy7 = LazyKt__LazyJVMKt.lazy(AIOFoldContentComponent$bubblePaddingBottom$2.INSTANCE);
        this.bubblePaddingBottom = lazy7;
        lazy8 = LazyKt__LazyJVMKt.lazy(AIOFoldContentComponent$bubblePaddingLeft$2.INSTANCE);
        this.bubblePaddingLeft = lazy8;
        lazy9 = LazyKt__LazyJVMKt.lazy(AIOFoldContentComponent$bubblePaddingRight$2.INSTANCE);
        this.bubblePaddingRight = lazy9;
        this.bubbleMaxWidth = a.C7329a.f192417a.b();
        lazy10 = LazyKt__LazyJVMKt.lazy(AIOFoldContentComponent$arkFoldViewWidth$2.INSTANCE);
        this.arkFoldViewWidth = lazy10;
        lazy11 = LazyKt__LazyJVMKt.lazy(AIOFoldContentComponent$arkFoldViewHeight$2.INSTANCE);
        this.arkFoldViewHeight = lazy11;
        lazy12 = LazyKt__LazyJVMKt.lazy(AIOFoldContentComponent$arkFoldViewPadding$2.INSTANCE);
        this.arkFoldViewPadding = lazy12;
    }

    private final void O1(FoldMsgItem msgItem, ArrayList<MsgElement> tempList, List<Object> payloads) {
        CharSequence Q1;
        if (!msgItem.i2()) {
            Q1 = P1(msgItem);
        } else {
            Q1 = Q1(msgItem);
        }
        a2().m(Q1, TextView.BufferType.SPANNABLE);
    }

    private final CharSequence P1(FoldMsgItem msgItem) {
        return f.b(msgItem.getMsgRecord());
    }

    private final CharSequence Q1(final FoldMsgItem msgItem) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(((Object) f.b(msgItem.getMsgRecord())) + " ");
        spannableStringBuilder.setSpan(new MarginSpan(24), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 33);
        ArrayList arrayList = new ArrayList();
        String qqStr = HardCodeUtil.qqStr(R.string.f172236op0);
        if (f.f190870a.c(msgItem)) {
            qqStr = HardCodeUtil.qqStr(R.string.f1354201e);
        }
        arrayList.add(new RichTextHelper.RichTextData(qqStr, new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.fold.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AIOFoldContentComponent.R1(AIOFoldContentComponent.this, msgItem, view);
            }
        }, true));
        SpannableString buildSpannable = RichTextHelper.buildSpannable(qqStr, getMContext(), false, arrayList);
        Intrinsics.checkNotNullExpressionValue(buildSpannable, "buildSpannable(text, mContext, false, list)");
        spannableStringBuilder.append((CharSequence) buildSpannable);
        return spannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R1(AIOFoldContentComponent this$0, FoldMsgItem msgItem, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        this$0.sendIntent(new d.a(msgItem));
        EventCollector.getInstance().onViewClicked(view);
    }

    private final int T1() {
        return ((Number) this.arkFoldViewHeight.getValue()).intValue();
    }

    private final int U1() {
        return ((Number) this.arkFoldViewPadding.getValue()).intValue();
    }

    private final int V1() {
        return ((Number) this.arkFoldViewWidth.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView W1() {
        return (ImageView) this.foregroundView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View X1() {
        return (View) this.mContent.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FrameLayout Y1() {
        return (FrameLayout) this.mContentWithForeground.getValue();
    }

    private final LinearLayout Z1() {
        return (LinearLayout) this.rootView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.fastertextview.wrapper.a a2() {
        return (com.tencent.fastertextview.wrapper.a) this.txtView.getValue();
    }

    private final boolean c2(List<Object> payloads) {
        if (payloads.isEmpty()) {
            return true;
        }
        for (Object obj : payloads) {
            if ((obj instanceof HashMap) && ((Map) obj).get(AIOMsgItemPayloadType.BUBBLE_REFRESH_PAYLOAD) != null) {
                k2();
            }
        }
        return false;
    }

    private final boolean d2(com.tencent.aio.data.msglist.a msgItem) {
        if (!(msgItem instanceof AIOMsgItem) || !com.tencent.mobileqq.aio.utils.d.u(((AIOMsgItem) msgItem).getMsgRecord())) {
            return false;
        }
        Y1().removeAllViews();
        View inflate = LayoutInflater.from(getMContext()).inflate(R.layout.dz8, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msglist.holder.component.ark.ArkAppLoadLayout");
        ArkAppLoadLayout arkAppLoadLayout = (ArkAppLoadLayout) inflate;
        this.arkAppLoadLayout = arkAppLoadLayout;
        if (arkAppLoadLayout != null) {
            arkAppLoadLayout.b(HardCodeUtil.qqStr(R.string.z67), false);
        }
        ArkAppLoadLayout arkAppLoadLayout2 = this.arkAppLoadLayout;
        if (arkAppLoadLayout2 != null) {
            arkAppLoadLayout2.setVisibility(0);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(V1(), T1());
        layoutParams.setMargins(U1(), U1(), U1(), U1());
        ArkAppLoadLayout arkAppLoadLayout3 = this.arkAppLoadLayout;
        if (arkAppLoadLayout3 != null) {
            arkAppLoadLayout3.setLayoutParams(layoutParams);
        }
        Y1().addView(this.arkAppLoadLayout);
        return true;
    }

    private final void e2(Drawable drawable, int backgroundMinWidth, int backgroundMinHeight) {
        boolean z16;
        int b16;
        int a16;
        com.tencent.fastertextview.wrapper.a a26 = a2();
        Integer valueOf = Integer.valueOf(backgroundMinWidth);
        boolean z17 = true;
        if (valueOf.intValue() != a2().b()) {
            z16 = true;
        } else {
            z16 = false;
        }
        Integer num = null;
        if (!z16) {
            valueOf = null;
        }
        if (valueOf != null) {
            b16 = valueOf.intValue();
        } else {
            b16 = a2().b();
        }
        a26.k(b16);
        com.tencent.fastertextview.wrapper.a a27 = a2();
        Integer valueOf2 = Integer.valueOf(backgroundMinHeight);
        if (valueOf2.intValue() == a2().a()) {
            z17 = false;
        }
        if (z17) {
            num = valueOf2;
        }
        if (num != null) {
            a16 = num.intValue();
        } else {
            a16 = a2().a();
        }
        a27.j(a16);
        a2().h(drawable);
    }

    private final void f2(Drawable drawable) {
        W1().setBackground(drawable);
    }

    private final void g2(int color) {
        a2().i(color);
    }

    private final void h2(int color) {
        a2().n(color);
    }

    private final void i2(ColorStateList colors) {
        a2().o(colors);
    }

    private final void j2(Integer unit, float size) {
        if (unit != null) {
            unit.intValue();
            a2().p(unit.intValue(), size);
        }
    }

    private final void k2() {
        AIOBubbleSkinInfo x06 = q1().x0();
        m mVar = m.f194167a;
        String b16 = mVar.b(q1());
        if ((x06 == null || x06.d() == 0) && !TextUtils.isEmpty(b16)) {
            g gVar = new g(q1(), b16, mVar.a(q1()), "", null, 16, null);
            sendIntent(new d.ah(gVar));
            h c16 = gVar.c();
            if (c16 != null) {
                l2(c16.a());
            }
        }
    }

    private final void l2(AIOBubbleSkinInfo bubbleSkin) {
        com.tencent.mobileqq.aio.msglist.holder.skin.padding.c cVar;
        Drawable a16;
        Drawable a17;
        AIOBubbleSkinInfo.BackgroundImageInfo a18 = bubbleSkin.a();
        if (a18 != null && (a17 = a18.a()) != null) {
            e2(a17, a18.g(), a18.f());
        }
        AIOBubbleSkinInfo.b c16 = bubbleSkin.c();
        if (c16 != null && (a16 = c16.a()) != null) {
            f2(a16);
        }
        AIOBubbleSkinInfo.c e16 = bubbleSkin.e();
        if (e16 != null) {
            Integer a19 = e16.a();
            if (a19 != null) {
                h2(a19.intValue());
            }
            ColorStateList b16 = e16.b();
            if (b16 != null) {
                i2(b16);
            }
            Integer c17 = e16.c();
            if (c17 != null) {
                g2(c17.intValue());
            }
            Float e17 = e16.e();
            if (e17 != null) {
                j2(e16.f(), e17.floatValue());
            }
        }
        com.tencent.mobileqq.aio.msglist.holder.skin.padding.a b17 = bubbleSkin.b();
        if (b17 instanceof com.tencent.mobileqq.aio.msglist.holder.skin.padding.c) {
            cVar = (com.tencent.mobileqq.aio.msglist.holder.skin.padding.c) b17;
        } else {
            cVar = null;
        }
        if (cVar != null) {
            if (a2().d() != cVar.c() || a2().e() != cVar.d() || a2().f() != cVar.e() || a2().c() != cVar.b()) {
                a2().l(cVar.c(), cVar.e(), cVar.d(), cVar.b());
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void m2(CharSequence toastTip) {
        if (TextUtils.isEmpty(toastTip)) {
            View g16 = a2().g();
            if (g16 != null) {
                g16.setOnTouchListener(null);
                return;
            }
            return;
        }
        final GestureDetector gestureDetector = new GestureDetector(this.context, new b(toastTip, this));
        View g17 = a2().g();
        if (g17 != null) {
            g17.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.fold.b
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean n26;
                    n26 = AIOFoldContentComponent.n2(gestureDetector, view, motionEvent);
                    return n26;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean n2(GestureDetector gesture, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(gesture, "$gesture");
        gesture.onTouchEvent(motionEvent);
        return false;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent
    @NotNull
    /* renamed from: S1, reason: merged with bridge method [inline-methods] */
    public c createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (c) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new c();
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
        super.b1(position, msgItem, payloads);
        if (!c2(payloads)) {
            return;
        }
        ArrayList<MsgElement> arrayList = new ArrayList<>();
        ArrayList<MsgElement> elements = ((AIOMsgItem) msgItem).getMsgRecord().elements;
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
        if (q1().x0() != null) {
            AIOBubbleSkinInfo x06 = q1().x0();
            Intrinsics.checkNotNull(x06);
            l2(x06);
        }
        if (d2(msgItem)) {
            QLog.d("AIOTextContentComponent", 1, "fold msg handled by ark");
            return;
        }
        FoldMsgItem foldMsgItem = (FoldMsgItem) msgItem;
        O1(foldMsgItem, arrayList, payloads);
        m2(foldMsgItem.m2());
        k2();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    public View c1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return Z1();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent
    @NotNull
    public List<com.tencent.qqnt.aio.menu.ui.d> s1() {
        List<com.tencent.qqnt.aio.menu.ui.d> emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return (List) iPatchRedirector.redirect((short) 5, (Object) this);
    }
}

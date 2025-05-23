package com.tencent.mobileqq.aio.msglist.holder.base;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FasterTextView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.o;
import com.tencent.mobileqq.aio.msglist.holder.base.util.PicContentViewUtil;
import com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.marketface.AIOMarketFaceUIState$MarketFaceInfoUpdateState;
import com.tencent.mobileqq.aio.msglist.holder.component.marketface.c;
import com.tencent.mobileqq.aio.msglist.holder.skin.AIOBubbleSkinInfo;
import com.tencent.mobileqq.aio.msglist.holder.skin.padding.a;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqui.widget.RoundBubbleImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.EmotionConstants;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IQQTextApi;
import com.tencent.qqnt.aio.holder.IMsgItemMviUIState;
import com.tencent.qqnt.aio.widget.AIOMsgFasterTextView;
import com.tencent.qqnt.aio.widget.AIOMsgTextView;
import com.tencent.qqnt.aio.widget.SelectableFasterTextView;
import com.tencent.qqnt.aio.widget.SelectableLinearLayout;
import com.tencent.qqnt.aio.widget.SelectableTextView;
import com.tencent.qqnt.emotion.adapter.api.IMarketFaceApi;
import com.tencent.qqnt.emotion.utils.s;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.msg.MsgExtKt;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ba\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u0000 u*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001vB\u000f\u0012\u0006\u0010H\u001a\u00020C\u00a2\u0006\u0004\bs\u0010tJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0006H\u0004J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0004J0\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0004J8\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0014H\u0004J\b\u0010\u001a\u001a\u00020\u0006H\u0004JD\u0010!\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001fH\u0004J\b\u0010\"\u001a\u00020\u0006H\u0004JD\u0010#\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001fH\u0004J\u0010\u0010$\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0001H\u0004J \u0010)\u001a\u00020\u00062\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\nH\u0016J\u0010\u0010*\u001a\u00020\u00062\b\u0010&\u001a\u0004\u0018\u00010%J\u0010\u0010,\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\nH\u0016J\u0010\u0010/\u001a\u00020\u00062\u0006\u0010.\u001a\u00020-H\u0016J\u0010\u00100\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\nH\u0016J\u0010\u00101\u001a\u00020\u00062\u0006\u0010+\u001a\u00020-H\u0016J!\u00105\u001a\u00020\u00062\b\u00102\u001a\u0004\u0018\u00010\n2\u0006\u00104\u001a\u000203H\u0016\u00a2\u0006\u0004\b5\u00106J\u0010\u00109\u001a\u00020\u00062\u0006\u00108\u001a\u000207H\u0016J,\u0010=\u001a\u00020\u00062\"\u0010<\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020%0:j\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020%`;H\u0004J\u0006\u0010>\u001a\u00020\u0006J\u0010\u0010A\u001a\u00020\u00062\u0006\u0010@\u001a\u00020?H\u0016J\b\u0010B\u001a\u00020\u0006H\u0016R\u0017\u0010H\u001a\u00020C8\u0006\u00a2\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u0014\u0010K\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010N\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR(\u0010W\u001a\b\u0012\u0004\u0012\u00020P0O8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR(\u0010[\u001a\b\u0012\u0004\u0012\u00020X0O8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bM\u0010R\u001a\u0004\bY\u0010T\"\u0004\bZ\u0010VR(\u0010`\u001a\b\u0012\u0004\u0012\u00020\\0O8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b]\u0010R\u001a\u0004\b^\u0010T\"\u0004\b_\u0010VR\u001a\u0010f\u001a\u00020a8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bb\u0010c\u001a\u0004\bd\u0010eR\u001b\u0010j\u001a\u00020\u00048DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\bJ\u0010g\u001a\u0004\bh\u0010iR\"\u0010r\u001a\u00020k8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bl\u0010m\u001a\u0004\bn\u0010o\"\u0004\bp\u0010q\u00a8\u0006w"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/base/BaseMixContentComponent;", "Lcom/tencent/mobileqq/aio/msg/o;", "T", "Lcom/tencent/mobileqq/aio/msglist/holder/component/BaseContentComponent;", "Landroid/view/View;", "view", "", "f2", "Lcom/tencent/qqnt/emotion/adapter/api/a;", "marketFaceInfo", "", "viewIndex", "e2", "W1", "X1", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "Lcom/tencent/qqnt/aio/widget/SelectableLinearLayout;", "linearLayout", "textViewIndex", "", "isFirst", "isEnd", "Q1", "isCheck", "R1", "V1", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "Landroid/widget/LinearLayout;", "picViewIndex", "Ljava/lang/Runnable;", "clickCallback", "N1", "U1", "K1", "p2", "Landroid/graphics/drawable/Drawable;", "drawable", "backgroundMinWidth", "backgroundMinHeight", "i2", "j2", "color", "m2", "Landroid/content/res/ColorStateList;", NodeProps.COLORS, ICustomDataEditor.NUMBER_PARAM_2, "k2", "l2", "unit", "", "size", "o2", "(Ljava/lang/Integer;F)V", "Lcom/tencent/mobileqq/aio/msglist/holder/skin/AIOBubbleSkinInfo;", "bubbleSkin", "r2", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "drawableInfo", "q2", "g2", "Lcom/tencent/qqnt/aio/holder/IMsgItemMviUIState;", "state", "g1", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", BdhLogUtil.LogTag.Tag_Conn, "I", "mBubbleMaxWidth", "D", UserInfo.SEX_FEMALE, "textSize", "", "Lcom/tencent/fastertextview/wrapper/a;", "E", "Ljava/util/List;", "c2", "()Ljava/util/List;", "setMTextViewList", "(Ljava/util/List;)V", "mTextViewList", "Lcom/tencent/mobileqq/qqui/widget/RoundBubbleImageView;", ICustomDataEditor.STRING_ARRAY_PARAM_2, "setMPicViewList", "mPicViewList", "Lcom/tencent/image/URLImageView;", "G", "Z1", "setMMarketFaceViewList", "mMarketFaceViewList", "Lcom/tencent/qqnt/aio/adapter/api/IQQTextApi;", "H", "Lcom/tencent/qqnt/aio/adapter/api/IQQTextApi;", "getMTextApi", "()Lcom/tencent/qqnt/aio/adapter/api/IQQTextApi;", "mTextApi", "Lkotlin/Lazy;", "Y1", "()Landroid/view/View;", "foregroundView", "Lcom/tencent/mobileqq/aio/msglist/holder/component/f;", "J", "Lcom/tencent/mobileqq/aio/msglist/holder/component/f;", "d2", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/f;", SemanticAttributes.DbSystemValues.H2, "(Lcom/tencent/mobileqq/aio/msglist/holder/component/f;)V", "shootBubbleContent", "<init>", "(Landroid/content/Context;)V", "K", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public abstract class BaseMixContentComponent<T extends o> extends BaseContentComponent<T> {
    static IPatchRedirector $redirector_;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private final int mBubbleMaxWidth;

    /* renamed from: D, reason: from kotlin metadata */
    private float textSize;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private List<com.tencent.fastertextview.wrapper.a> mTextViewList;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private List<RoundBubbleImageView> mPicViewList;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private List<URLImageView> mMarketFaceViewList;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final IQQTextApi mTextApi;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy foregroundView;

    /* renamed from: J, reason: from kotlin metadata */
    public com.tencent.mobileqq.aio.msglist.holder.component.f shootBubbleContent;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/base/BaseMixContentComponent$a;", "", "", "ACCESSIBILITY_ACTION_TAP", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.base.BaseMixContentComponent$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J$\u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/base/BaseMixContentComponent$b", "Landroid/view/View$AccessibilityDelegate;", "Landroid/view/View;", "host", "Landroid/view/accessibility/AccessibilityNodeInfo;", "info", "", "onInitializeAccessibilityNodeInfo", "", "action", "Landroid/os/Bundle;", "args", "", "performAccessibilityAction", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b extends View.AccessibilityDelegate {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseMixContentComponent<T> f190583a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f190584b;

        b(BaseMixContentComponent<T> baseMixContentComponent, View view) {
            this.f190583a = baseMixContentComponent;
            this.f190584b = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseMixContentComponent, (Object) view);
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(@Nullable View host, @Nullable AccessibilityNodeInfo info) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) host, (Object) info);
                return;
            }
            super.onInitializeAccessibilityNodeInfo(host, info);
            if (Build.VERSION.SDK_INT >= 24 && info != null) {
                BaseMixContentComponent<T> baseMixContentComponent = this.f190583a;
                info.setImportantForAccessibility(true);
                try {
                    info.addAction(new AccessibilityNodeInfo.AccessibilityAction(33554432, baseMixContentComponent.getContext().getResources().getString(R.string.f230486z_)));
                } catch (Exception e16) {
                    QLog.e("BaseMixContentComponent", 1, "add ACCESSIBILITY_ACTION_TAP " + e16);
                }
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(@Nullable View host, int action, @Nullable Bundle args) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, this, host, Integer.valueOf(action), args)).booleanValue();
            }
            if (action == 33554432) {
                try {
                    View view = this.f190584b;
                    Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.tencent.qqnt.aio.widget.SelectableTextView");
                    ((SelectableTextView) view).z();
                } catch (Exception e16) {
                    QLog.e("BaseMixContentComponent", 1, "add performDoubleClick " + e16);
                }
            }
            return super.performAccessibilityAction(host, action, args);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59759);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 35)) {
            redirector.redirect((short) 35);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public BaseMixContentComponent(@NotNull Context context) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.context = context;
        this.mBubbleMaxWidth = a.C7329a.f192417a.b();
        this.textSize = context.getResources().getDimensionPixelSize(R.dimen.ayp);
        this.mTextViewList = new ArrayList();
        this.mPicViewList = new ArrayList();
        this.mMarketFaceViewList = new ArrayList();
        this.mTextApi = (IQQTextApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IQQTextApi.class);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<View>(this) { // from class: com.tencent.mobileqq.aio.msglist.holder.base.BaseMixContentComponent$foregroundView$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ BaseMixContentComponent<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new View(this.this$0.getContext()) : (View) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.foregroundView = lazy;
    }

    public static /* synthetic */ void L1(BaseMixContentComponent baseMixContentComponent, o oVar, MsgElement msgElement, LinearLayout linearLayout, int i3, boolean z16, boolean z17, Runnable runnable, int i16, Object obj) {
        Runnable runnable2;
        if (obj == null) {
            if ((i16 & 64) != 0) {
                runnable2 = null;
            } else {
                runnable2 = runnable;
            }
            baseMixContentComponent.K1(oVar, msgElement, linearLayout, i3, z16, z17, runnable2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addMarketFaceView");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M1(BaseMixContentComponent this$0, o msgItem, MsgElement msgElement, View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        Intrinsics.checkNotNullParameter(msgElement, "$msgElement");
        Intrinsics.checkNotNullExpressionValue(v3, "v");
        this$0.sendIntent(new c.a(v3, msgItem.getMsgRecord(), msgElement.marketFaceElement));
        EventCollector.getInstance().onViewClicked(v3);
    }

    public static /* synthetic */ void O1(BaseMixContentComponent baseMixContentComponent, o oVar, MsgElement msgElement, LinearLayout linearLayout, int i3, boolean z16, boolean z17, Runnable runnable, int i16, Object obj) {
        Runnable runnable2;
        if (obj == null) {
            if ((i16 & 64) != 0) {
                runnable2 = null;
            } else {
                runnable2 = runnable;
            }
            baseMixContentComponent.N1(oVar, msgElement, linearLayout, i3, z16, z17, runnable2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addPicView");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P1(BaseMixContentComponent this$0, Runnable runnable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.C1();
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S1(Ref.ObjectRef qqText, final com.tencent.fastertextview.wrapper.a textView) {
        Intrinsics.checkNotNullParameter(qqText, "$qqText");
        Intrinsics.checkNotNullParameter(textView, "$textView");
        final String b16 = s.b(String.valueOf(qqText.element));
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.base.g
            @Override // java.lang.Runnable
            public final void run() {
                BaseMixContentComponent.T1(com.tencent.fastertextview.wrapper.a.this, b16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T1(com.tencent.fastertextview.wrapper.a textView, String str) {
        Intrinsics.checkNotNullParameter(textView, "$textView");
        View g16 = textView.g();
        Intrinsics.checkNotNull(g16);
        g16.setContentDescription(str);
    }

    private final void e2(com.tencent.qqnt.emotion.adapter.api.a marketFaceInfo, int viewIndex) {
        IPicEmoticonInfo a16 = marketFaceInfo.a();
        if (a16 != null) {
            if (this.mMarketFaceViewList.size() <= viewIndex) {
                QLog.e("BaseMixContentComponent", 1, "[handleMarketFaceInfoUpdate] invalidate view index. size=" + this.mMarketFaceViewList.size() + ", viewIndex=" + viewIndex + ".");
                return;
            }
            URLImageView uRLImageView = this.mMarketFaceViewList.get(viewIndex);
            uRLImageView.getLayoutParams().width = marketFaceInfo.c().getFirst().intValue();
            uRLImageView.getLayoutParams().height = marketFaceInfo.c().getSecond().intValue();
            uRLImageView.setImageDrawable(a16.getLoadingDrawable(EmotionConstants.FROM_AIO, true));
        }
    }

    private final void f2(View view) {
        view.setAccessibilityDelegate(new b(this, view));
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected final void K1(@NotNull final o msgItem, @NotNull final MsgElement msgElement, @NotNull LinearLayout linearLayout, int viewIndex, boolean isFirst, boolean isEnd, @Nullable Runnable clickCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, msgItem, msgElement, linearLayout, Integer.valueOf(viewIndex), Boolean.valueOf(isFirst), Boolean.valueOf(isEnd), clickCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(msgElement, "msgElement");
        Intrinsics.checkNotNullParameter(linearLayout, "linearLayout");
        if (viewIndex >= this.mMarketFaceViewList.size()) {
            QLog.d("BaseMixContentComponent", 1, "addMarketFaceView picViewIndex=" + viewIndex + ", mMarketFaceViewList.size=" + this.mMarketFaceViewList.size());
            return;
        }
        URLImageView uRLImageView = this.mMarketFaceViewList.get(viewIndex);
        uRLImageView.setTag(msgElement);
        uRLImageView.setContentDescription(HardCodeUtil.qqStr(R.string.f170197yp0));
        if (com.tencent.qqnt.util.b.f362976b.enableTalkBack() && MsgExtKt.y(((o) q1()).getMsgRecord())) {
            msgItem.g1(msgItem.w() + HardCodeUtil.qqStr(R.string.f170197yp0));
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        IMarketFaceApi iMarketFaceApi = (IMarketFaceApi) QRoute.api(IMarketFaceApi.class);
        MarketFaceElement marketFaceElement = msgElement.marketFaceElement;
        Intrinsics.checkNotNullExpressionValue(marketFaceElement, "msgElement.marketFaceElement");
        Pair<Integer, Integer> calculateMarketFaceViewSize = iMarketFaceApi.calculateMarketFaceViewSize(marketFaceElement);
        if (calculateMarketFaceViewSize.getFirst().intValue() > 0 && calculateMarketFaceViewSize.getSecond().intValue() > 0) {
            layoutParams = new LinearLayout.LayoutParams(calculateMarketFaceViewSize.getFirst().intValue(), calculateMarketFaceViewSize.getSecond().intValue());
        }
        linearLayout.addView(uRLImageView, layoutParams);
        MarketFaceElement marketFaceElement2 = msgElement.marketFaceElement;
        Intrinsics.checkNotNullExpressionValue(marketFaceElement2, "msgElement.marketFaceElement");
        sendIntent(new c.f(marketFaceElement2, viewIndex));
        uRLImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.base.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseMixContentComponent.M1(BaseMixContentComponent.this, msgItem, msgElement, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public final void N1(@NotNull o msgItem, @NotNull MsgElement msgElement, @NotNull LinearLayout linearLayout, int picViewIndex, boolean isFirst, boolean isEnd, @Nullable final Runnable clickCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, msgItem, msgElement, linearLayout, Integer.valueOf(picViewIndex), Boolean.valueOf(isFirst), Boolean.valueOf(isEnd), clickCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(msgElement, "msgElement");
        Intrinsics.checkNotNullParameter(linearLayout, "linearLayout");
        if (picViewIndex >= this.mPicViewList.size()) {
            QLog.d("BaseMixContentComponent", 1, "addPicView picViewIndex=" + picViewIndex + ", mPicViewList.size=" + this.mPicViewList.size());
            return;
        }
        RoundBubbleImageView roundBubbleImageView = this.mPicViewList.get(picViewIndex);
        roundBubbleImageView.setTag(msgElement);
        roundBubbleImageView.setContentDescription(HardCodeUtil.qqStr(R.string.yp6));
        if (com.tencent.qqnt.util.b.f362976b.enableTalkBack() && MsgExtKt.y(((o) q1()).getMsgRecord())) {
            msgItem.g1(msgItem.w() + HardCodeUtil.qqStr(R.string.yp6));
        }
        linearLayout.addView(roundBubbleImageView, new LinearLayout.LayoutParams(-2, -2));
        PicContentViewUtil.f190621a.c(roundBubbleImageView, msgItem, msgElement, this, new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.base.f
            @Override // java.lang.Runnable
            public final void run() {
                BaseMixContentComponent.P1(BaseMixContentComponent.this, clickCallback);
            }
        }, BaseMixContentComponent$addPicView$2.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Q1(@NotNull AIOMsgItem msgItem, @NotNull SelectableLinearLayout linearLayout, int textViewIndex, boolean isFirst, boolean isEnd) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, msgItem, linearLayout, Integer.valueOf(textViewIndex), Boolean.valueOf(isFirst), Boolean.valueOf(isEnd));
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(linearLayout, "linearLayout");
        R1(msgItem, linearLayout, textViewIndex, isFirst, isEnd, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [T, java.lang.Object] */
    public final void R1(@NotNull AIOMsgItem msgItem, @NotNull SelectableLinearLayout linearLayout, int textViewIndex, boolean isFirst, boolean isEnd, boolean isCheck) {
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, msgItem, linearLayout, Integer.valueOf(textViewIndex), Boolean.valueOf(isFirst), Boolean.valueOf(isEnd), Boolean.valueOf(isCheck));
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(linearLayout, "linearLayout");
        if (textViewIndex >= this.mTextViewList.size()) {
            QLog.d("BaseMixContentComponent", 1, "addTextView textViewIndex=" + textViewIndex + ", mTextViewList.size=" + this.mTextViewList.size());
            return;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? r06 = ((o) msgItem).p2().get(Integer.valueOf(textViewIndex));
        objectRef.element = r06;
        if (TextUtils.isEmpty((CharSequence) r06)) {
            QLog.d("BaseMixContentComponent", 1, "addTextView qqText isEmpty");
            if (isCheck) {
                objectRef.element = " ";
            } else {
                return;
            }
        }
        com.tencent.qqnt.util.b bVar = com.tencent.qqnt.util.b.f362976b;
        if (bVar.enableTalkBack() && MsgExtKt.y(((o) q1()).getMsgRecord())) {
            msgItem.g1(msgItem.w() + s.b(String.valueOf(objectRef.element)));
        }
        final com.tencent.fastertextview.wrapper.a aVar = this.mTextViewList.get(textViewIndex);
        if (aVar.g() != null && bVar.enableTalkBack()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.base.e
                @Override // java.lang.Runnable
                public final void run() {
                    BaseMixContentComponent.S1(Ref.ObjectRef.this, aVar);
                }
            }, 32, null, true);
        }
        T t16 = objectRef.element;
        Intrinsics.checkNotNull(t16);
        aVar.m((CharSequence) t16, TextView.BufferType.SPANNABLE);
        if (((o) q1()).s2() > 0.0f) {
            f16 = ((o) q1()).s2();
        } else {
            f16 = this.textSize;
        }
        aVar.p(0, f16);
        linearLayout.addView(aVar.g(), new LinearLayout.LayoutParams(-2, -2));
        if (aVar.g() instanceof SelectableTextView) {
            View g16 = aVar.g();
            Intrinsics.checkNotNull(g16, "null cannot be cast to non-null type com.tencent.qqnt.aio.widget.SelectableTextView");
            ((SelectableTextView) g16).o(linearLayout);
        } else if (aVar.g() instanceof SelectableFasterTextView) {
            View g17 = aVar.g();
            Intrinsics.checkNotNull(g17, "null cannot be cast to non-null type com.tencent.qqnt.aio.widget.SelectableFasterTextView");
            ((SelectableFasterTextView) g17).o(linearLayout);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void U1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        URLImageView uRLImageView = new URLImageView(this.context);
        uRLImageView.setId(R.id.big_image_layout);
        uRLImageView.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        uRLImageView.setImageResource(R.drawable.c0i);
        this.mMarketFaceViewList.add(uRLImageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void V1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        RoundBubbleImageView roundBubbleImageView = new RoundBubbleImageView(this.context);
        roundBubbleImageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        roundBubbleImageView.setRadiusDP(4.0f);
        this.mPicViewList.add(roundBubbleImageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void W1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        com.tencent.mobileqq.aio.msglist.holder.component.text.util.a aVar = com.tencent.mobileqq.aio.msglist.holder.component.text.util.a.f192006a;
        com.tencent.fastertextview.wrapper.a a16 = aVar.a(this.context, this.mBubbleMaxWidth, aVar.c(this));
        View g16 = a16.g();
        if (g16 != null) {
            g16.setImportantForAccessibility(1);
        }
        View it = a16.g();
        if (it != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            f2(it);
        }
        this.mTextViewList.add(a16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final View X1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (View) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        if (this.mTextViewList.isEmpty()) {
            return null;
        }
        return this.mTextViewList.get(0).g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final View Y1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (View) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return (View) this.foregroundView.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final List<URLImageView> Z1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (List) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.mMarketFaceViewList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final List<RoundBubbleImageView> a2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mPicViewList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final List<com.tencent.fastertextview.wrapper.a> c2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mTextViewList;
    }

    @NotNull
    public final com.tencent.mobileqq.aio.msglist.holder.component.f d2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (com.tencent.mobileqq.aio.msglist.holder.component.f) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        com.tencent.mobileqq.aio.msglist.holder.component.f fVar = this.shootBubbleContent;
        if (fVar != null) {
            return fVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("shootBubbleContent");
        return null;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c, com.tencent.mvi.mvvm.BaseVB
    /* renamed from: g1 */
    public void handleUIState(@NotNull IMsgItemMviUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof AIOMarketFaceUIState$MarketFaceInfoUpdateState) {
            AIOMarketFaceUIState$MarketFaceInfoUpdateState aIOMarketFaceUIState$MarketFaceInfoUpdateState = (AIOMarketFaceUIState$MarketFaceInfoUpdateState) state;
            e2(aIOMarketFaceUIState$MarketFaceInfoUpdateState.b(), aIOMarketFaceUIState$MarketFaceInfoUpdateState.a());
        } else {
            super.handleUIState(state);
        }
    }

    public final void g2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this);
            return;
        }
        int i3 = 0;
        for (Object obj : this.mTextViewList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            View g16 = ((com.tencent.fastertextview.wrapper.a) obj).g();
            if (g16 instanceof AIOMsgTextView) {
                AIOMsgTextView.setTextDrawable$default((AIOMsgTextView) g16, null, null, 2, null);
            } else if (g16 instanceof AIOMsgFasterTextView) {
                ((AIOMsgFasterTextView) g16).setTextDrawable(null);
            }
            i3 = i16;
        }
    }

    @NotNull
    public final Context getContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Context) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.context;
    }

    public final void h2(@NotNull com.tencent.mobileqq.aio.msglist.holder.component.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) fVar);
        } else {
            Intrinsics.checkNotNullParameter(fVar, "<set-?>");
            this.shootBubbleContent = fVar;
        }
    }

    public void i2(@NotNull Drawable drawable, int backgroundMinWidth, int backgroundMinHeight) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, drawable, Integer.valueOf(backgroundMinWidth), Integer.valueOf(backgroundMinHeight));
        } else {
            Intrinsics.checkNotNullParameter(drawable, "drawable");
        }
    }

    public final void j2(@Nullable Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) drawable);
        } else {
            Y1().setBackground(drawable);
        }
    }

    public void k2(int color) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, color);
            return;
        }
        int i3 = 0;
        for (Object obj : this.mTextViewList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            ((com.tencent.fastertextview.wrapper.a) obj).i(color);
            i3 = i16;
        }
    }

    public void l2(@NotNull ColorStateList color) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) color);
            return;
        }
        Intrinsics.checkNotNullParameter(color, "color");
        int i3 = 0;
        for (Object obj : this.mTextViewList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            com.tencent.fastertextview.wrapper.a aVar = (com.tencent.fastertextview.wrapper.a) obj;
            if (aVar.g() instanceof TextView) {
                View g16 = aVar.g();
                Intrinsics.checkNotNull(g16, "null cannot be cast to non-null type android.widget.TextView");
                ((TextView) g16).setLinkTextColor(color);
            } else if (aVar.g() instanceof FasterTextView) {
                View g17 = aVar.g();
                Intrinsics.checkNotNull(g17, "null cannot be cast to non-null type android.widget.FasterTextView");
                ((FasterTextView) g17).setLinkTextColor(color);
            }
            i3 = i16;
        }
    }

    public void m2(int color) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, color);
            return;
        }
        int i3 = 0;
        for (Object obj : this.mTextViewList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            ((com.tencent.fastertextview.wrapper.a) obj).n(color);
            i3 = i16;
        }
    }

    public void n2(@NotNull ColorStateList colors) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) colors);
            return;
        }
        Intrinsics.checkNotNullParameter(colors, "colors");
        int i3 = 0;
        for (Object obj : this.mTextViewList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            ((com.tencent.fastertextview.wrapper.a) obj).o(colors);
            i3 = i16;
        }
    }

    public void o2(@Nullable Integer unit, float size) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, unit, Float.valueOf(size));
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        Drawable drawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this);
            return;
        }
        int i3 = 0;
        for (Object obj : this.mTextViewList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            com.tencent.fastertextview.wrapper.a aVar = (com.tencent.fastertextview.wrapper.a) obj;
            if (aVar.g() instanceof AIOMsgTextView) {
                View g16 = aVar.g();
                Intrinsics.checkNotNull(g16, "null cannot be cast to non-null type com.tencent.qqnt.aio.widget.AIOMsgTextView");
                Object L = ((AIOMsgTextView) g16).L();
                if (L instanceof Drawable) {
                    drawable = (Drawable) L;
                }
                drawable = null;
            } else {
                if (aVar.g() instanceof AIOMsgFasterTextView) {
                    View g17 = aVar.g();
                    Intrinsics.checkNotNull(g17, "null cannot be cast to non-null type com.tencent.qqnt.aio.widget.AIOMsgFasterTextView");
                    Object D = ((AIOMsgFasterTextView) g17).D();
                    if (D instanceof Drawable) {
                        drawable = (Drawable) D;
                    }
                }
                drawable = null;
            }
            if (drawable != null) {
                drawable.setCallback(null);
            }
            i3 = i16;
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void p2(@NotNull o msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) msgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        AIOBubbleSkinInfo x06 = msgItem.x0();
        Intrinsics.checkNotNull(x06);
        r2(x06);
        g2();
        if (msgItem.n2() != null) {
            HashMap<Integer, Drawable> n26 = msgItem.n2();
            Intrinsics.checkNotNull(n26);
            q2(n26);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void q2(@NotNull HashMap<Integer, Drawable> drawableInfo) {
        y03.c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) drawableInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(drawableInfo, "drawableInfo");
        for (Map.Entry<Integer, Drawable> entry : drawableInfo.entrySet()) {
            Intrinsics.checkNotNullExpressionValue(entry, "iterator.next()");
            Map.Entry<Integer, Drawable> entry2 = entry;
            Integer key = entry2.getKey();
            Intrinsics.checkNotNullExpressionValue(key, "next.key");
            int intValue = key.intValue();
            Object value = entry2.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "next.value");
            Object obj = (Drawable) value;
            View g16 = this.mTextViewList.get(intValue).g();
            y03.c cVar2 = null;
            if (g16 instanceof AIOMsgTextView) {
                AIOMsgTextView aIOMsgTextView = (AIOMsgTextView) g16;
                if (obj instanceof y03.c) {
                    cVar = (y03.c) obj;
                } else {
                    cVar = null;
                }
                AIOMsgTextView.setTextDrawable$default(aIOMsgTextView, cVar, null, 2, null);
            } else if (g16 instanceof AIOMsgFasterTextView) {
                AIOMsgFasterTextView aIOMsgFasterTextView = (AIOMsgFasterTextView) g16;
                if (obj instanceof y03.c) {
                    cVar2 = (y03.c) obj;
                }
                aIOMsgFasterTextView.setTextDrawable(cVar2);
            }
        }
    }

    public void r2(@NotNull AIOBubbleSkinInfo bubbleSkin) {
        Drawable drawable;
        Drawable a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) bubbleSkin);
            return;
        }
        Intrinsics.checkNotNullParameter(bubbleSkin, "bubbleSkin");
        AIOBubbleSkinInfo.BackgroundImageInfo a17 = bubbleSkin.a();
        if (a17 != null && (a16 = a17.a()) != null) {
            i2(a16, a17.g(), a17.f());
        }
        AIOBubbleSkinInfo.b c16 = bubbleSkin.c();
        if (c16 != null) {
            drawable = c16.a();
        } else {
            drawable = null;
        }
        j2(drawable);
        AIOBubbleSkinInfo.c e16 = bubbleSkin.e();
        if (e16 != null) {
            Integer a18 = e16.a();
            if (a18 != null) {
                m2(a18.intValue());
            }
            ColorStateList b16 = e16.b();
            if (b16 != null) {
                n2(b16);
            }
            Integer c17 = e16.c();
            if (c17 != null) {
                k2(c17.intValue());
            }
            ColorStateList d16 = e16.d();
            if (d16 != null) {
                l2(d16);
            }
            Float e17 = e16.e();
            if (e17 != null) {
                float floatValue = e17.floatValue();
                Integer f16 = e16.f();
                if (f16 != null) {
                    o2(Integer.valueOf(f16.intValue()), floatValue);
                }
            }
        }
    }
}

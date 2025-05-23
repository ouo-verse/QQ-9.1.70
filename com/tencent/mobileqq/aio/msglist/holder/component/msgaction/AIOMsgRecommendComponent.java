package com.tencent.mobileqq.aio.msglist.holder.component.msgaction;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.image.ApngDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.l;
import com.tencent.mobileqq.aio.msglist.holder.component.assistedchat.pb.AssistedChatExtDataPB$MessageExtData;
import com.tencent.mobileqq.aio.msglist.holder.component.msgaction.c;
import com.tencent.mobileqq.aio.msglist.holder.skin.padding.a;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.holder.IMsgItemMviUIState;
import com.tencent.qqnt.kernel.nativeinterface.AdelieRecommendedMsgElement;
import com.tencent.qqnt.kernel.nativeinterface.InlineKeyboardButton;
import com.tencent.qqnt.kernel.nativeinterface.InlineKeyboardRow;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.robot.api.IRobotServiceApi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 N2\u00020\u0001:\u0001WB\u0007\u00a2\u0006\u0004\bU\u0010VJ\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J$\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u0007H\u0002J\b\u0010\r\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0007H\u0002J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0018\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u0007H\u0002J\u0012\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010!\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J>\u0010$\u001a\u001e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00050\"j\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0005`#2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u000e\u0010&\u001a\u00020\u0016*\u0004\u0018\u00010%H\u0002J\"\u0010'\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\"\u0010(\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010)\u001a\u00020\u0007H\u0002J\u0010\u0010*\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010.\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020-0+H\u0016J&\u00101\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u0002002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\b\u00102\u001a\u00020\u001aH\u0016J\b\u00103\u001a\u00020\u000bH\u0014J\b\u00104\u001a\u00020\u000bH\u0016R\u001b\u0010:\u001a\u0002058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u001b\u0010>\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b;\u00107\u001a\u0004\b<\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u001b\u0010E\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bC\u00107\u001a\u0004\bD\u0010=R$\u0010J\u001a\u0012\u0012\u0004\u0012\u00020\u00180Fj\b\u0012\u0004\u0012\u00020\u0018`G8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010IR$\u0010L\u001a\u0012\u0012\u0004\u0012\u00020\u001d0Fj\b\u0012\u0004\u0012\u00020\u001d`G8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010IR\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010Q\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010T\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010S\u00a8\u0006X"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgaction/AIOMsgRecommendComponent;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/e;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "", "payloads", "", "I1", "checkStreamAnim", "delayToShow", "", "S1", "N1", "Q1", "R1", "O1", "Lcom/tencent/qqnt/kernel/nativeinterface/InlineKeyboardButton;", "buttonInfo", "w1", "", "index", "", "text", "Landroid/widget/LinearLayout;", "F1", "Landroid/view/View;", "B1", "hasIcon", "Landroid/widget/TextView;", "H1", "Lcom/tencent/qqnt/kernel/nativeinterface/AdelieRecommendedMsgElement;", "E1", "K1", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "z1", "Lcom/tencent/mobileqq/aio/msglist/holder/component/assistedchat/pb/AssistedChatExtDataPB$MessageExtData;", Constants.APK_CERTIFICATE, "M1", "L1", "y1", "J1", "Lcom/tencent/aio/base/mvvm/b;", "Lcom/tencent/qqnt/aio/holder/a;", "Lcom/tencent/qqnt/aio/holder/IMsgItemMviUIState;", "d1", "position", "Lcom/tencent/aio/data/msglist/a;", "b1", "c1", "p1", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/os/Handler;", h.F, "Lkotlin/Lazy;", "A1", "()Landroid/os/Handler;", "handler", "i", Constants.BASE_IN_PLUGIN_ID, "()Landroid/widget/LinearLayout;", "recommendLayout", "Landroid/graphics/drawable/Drawable;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/graphics/drawable/Drawable;", "mLoadingDrawable", BdhLogUtil.LogTag.Tag_Conn, "C1", "loadingView", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "D", "Ljava/util/ArrayList;", "msgViewList", "E", "msgTextViewList", UserInfo.SEX_FEMALE, "I", "G", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "mCurrentMsgItem", "H", "Z", "mHasIcon", "<init>", "()V", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOMsgRecommendComponent extends com.tencent.mobileqq.aio.msglist.holder.component.e {
    static IPatchRedirector $redirector_;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy loadingView;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<LinearLayout> msgViewList;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<TextView> msgTextViewList;

    /* renamed from: F, reason: from kotlin metadata */
    private int index;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private AIOMsgItem mCurrentMsgItem;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean mHasIcon;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy handler;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy recommendLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable mLoadingDrawable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0007R\u0014\u0010\u000e\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0007R\u0014\u0010\u000f\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgaction/AIOMsgRecommendComponent$a;", "", "", "EM_BAS_RECOMMENDATION_MESSAGE", "Ljava/lang/String;", "", "ICON_SIZE_DP", UserInfo.SEX_FEMALE, "RECOMMEND_MSG_MARGIN_DP", "", "SHOW_DELAY_TIME", "J", "TAG", "TEXT_LEFT_MARGIN_DP", "TEXT_PADDING_DP", "TEXT_SIZE_DP", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.msgaction.AIOMsgRecommendComponent$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61893);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOMsgRecommendComponent() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(AIOMsgRecommendComponent$handler$2.INSTANCE);
            this.handler = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.msgaction.AIOMsgRecommendComponent$recommendLayout$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOMsgRecommendComponent.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final LinearLayout invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (LinearLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    LinearLayout linearLayout = new LinearLayout(AIOMsgRecommendComponent.this.getMContext());
                    linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
                    linearLayout.setOrientation(1);
                    return linearLayout;
                }
            });
            this.recommendLayout = lazy2;
            lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.msgaction.AIOMsgRecommendComponent$loadingView$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOMsgRecommendComponent.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final LinearLayout invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (LinearLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    LinearLayout linearLayout = new LinearLayout(AIOMsgRecommendComponent.this.getMContext());
                    AIOMsgRecommendComponent aIOMsgRecommendComponent = AIOMsgRecommendComponent.this;
                    linearLayout.setLayoutParams(new FrameLayout.LayoutParams(ViewUtils.dpToPx(44.0f), ViewUtils.dpToPx(36.0f)));
                    ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
                    if (marginLayoutParams != null) {
                        marginLayoutParams.leftMargin = ViewUtils.dpToPx(8.0f);
                    }
                    linearLayout.setOrientation(0);
                    linearLayout.setBackground(ContextCompat.getDrawable(aIOMsgRecommendComponent.getMContext(), R.drawable.qui_common_bubble_guest_secondary_bg_corner_8));
                    int dpToPx = ViewUtils.dpToPx(8.0f);
                    linearLayout.setPadding(dpToPx, dpToPx, dpToPx, dpToPx);
                    linearLayout.setGravity(17);
                    ImageView imageView = new ImageView(aIOMsgRecommendComponent.getMContext());
                    imageView.setLayoutParams(new LinearLayout.LayoutParams(ViewUtils.dpToPx(24.0f), ViewUtils.dpToPx(24.0f)));
                    Drawable a16 = com.tencent.qqnt.aio.utils.d.f352294a.a();
                    if (a16 != null) {
                        aIOMsgRecommendComponent.mLoadingDrawable = a16;
                        imageView.setBackground(a16);
                        aIOMsgRecommendComponent.Q1();
                    }
                    linearLayout.addView(imageView);
                    return linearLayout;
                }
            });
            this.loadingView = lazy3;
            this.msgViewList = new ArrayList<>();
            this.msgTextViewList = new ArrayList<>();
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final Handler A1() {
        return (Handler) this.handler.getValue();
    }

    private final View B1() {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ImageView imageView = new ImageView(getMContext());
        imageView.setImageResource(R.drawable.mlh);
        int dpToPx = ViewUtils.dpToPx(16.0f);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(dpToPx, dpToPx));
        ViewUtils.dpToPx(1.0f);
        Paint paint = new Paint();
        paint.setTextSize(ViewUtils.dpToPx(14.0f));
        int i3 = (int) (paint.getFontMetrics().ascent - paint.getFontMetrics().top);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            marginLayoutParams.topMargin = i3;
        }
        return imageView;
    }

    private final LinearLayout C1() {
        return (LinearLayout) this.loadingView.getValue();
    }

    private final LinearLayout D1() {
        return (LinearLayout) this.recommendLayout.getValue();
    }

    private final AdelieRecommendedMsgElement E1(AIOMsgItem msgItem) {
        return com.tencent.qqnt.aio.msg.d.e(msgItem);
    }

    private final LinearLayout F1(int index, String text) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        CharSequence trim;
        if (index < this.msgViewList.size()) {
            TextView textView = this.msgTextViewList.get(index);
            trim = StringsKt__StringsKt.trim((CharSequence) text);
            textView.setText(trim.toString());
            LinearLayout linearLayout = this.msgViewList.get(index);
            Intrinsics.checkNotNullExpressionValue(linearLayout, "msgViewList[index]");
            return linearLayout;
        }
        LinearLayout linearLayout2 = new LinearLayout(getMContext());
        linearLayout2.setOrientation(0);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        ViewGroup.LayoutParams layoutParams = linearLayout2.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            marginLayoutParams.bottomMargin = ViewUtils.dpToPx(8.0f);
            marginLayoutParams.leftMargin = ViewUtils.dpToPx(8.0f);
            marginLayoutParams.rightMargin = ViewUtils.dpToPx(8.0f);
        }
        int dpToPx = ViewUtils.dpToPx(8.0f);
        linearLayout2.setPadding(dpToPx, dpToPx, dpToPx, dpToPx);
        linearLayout2.setMinimumHeight(ViewUtils.dpToPx(30.0f));
        linearLayout2.setBackground(ContextCompat.getDrawable(getMContext(), R.drawable.j8m));
        if (this.mHasIcon) {
            linearLayout2.addView(B1());
        }
        TextView H1 = H1(this.mHasIcon);
        H1.setText(text);
        linearLayout2.addView(H1);
        this.msgTextViewList.add(H1);
        this.msgViewList.add(linearLayout2);
        return linearLayout2;
    }

    private final String G1(AssistedChatExtDataPB$MessageExtData assistedChatExtDataPB$MessageExtData) {
        PBBytesField pBBytesField;
        if (assistedChatExtDataPB$MessageExtData != null && (pBBytesField = assistedChatExtDataPB$MessageExtData.recom_trace) != null) {
            byte[] byteArray = pBBytesField.get().toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray, "it.get().toByteArray()");
            return new String(byteArray, Charsets.UTF_8);
        }
        return "";
    }

    private final TextView H1(boolean hasIcon) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        TextView textView = new TextView(getMContext());
        textView.setEnabled(false);
        textView.setTextColor(getMContext().getColorStateList(R.color.qui_common_bubble_guest_text_primary));
        textView.setTextSize(14.0f);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        if (hasIcon) {
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else {
                marginLayoutParams = null;
            }
            if (marginLayoutParams != null) {
                marginLayoutParams.leftMargin = ViewUtils.dpToPx(4.0f);
            }
            textView.setMaxWidth(((a.C7329a.g(a.C7329a.f192417a, false, 1, null) - (ViewUtils.dpToPx(8.0f) * 4)) - ViewUtils.dpToPx(16.0f)) - ViewUtils.dpToPx(4.0f));
        } else {
            textView.setMaxWidth(a.C7329a.g(a.C7329a.f192417a, false, 1, null) - (ViewUtils.dpToPx(8.0f) * 4));
        }
        textView.setMaxLines(2);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setIncludeFontPadding(true);
        return textView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean I1(AIOMsgItem msgItem, List<Object> payloads) {
        l lVar;
        Boolean bool;
        if (payloads.isEmpty()) {
            return true;
        }
        for (Object obj : payloads) {
            if (obj instanceof HashMap) {
                Map map = (Map) obj;
                if (map.get(AIOMsgItemPayloadType.LAST_RECEIVE_MSG_PAYLOAD) != null) {
                    if (QLog.isDevelopLevel()) {
                        QLog.i("AIOMsgRecommendComponent", 4, "[handleLastReceiveMsgPaylod]: msgId is " + msgItem.getMsgId() + ", lastReceiveMsgFlag is " + msgItem.I());
                    }
                    T1(this, msgItem, false, false, 6, null);
                }
                if (map.get(AIOMsgItemPayloadType.ADELIE_MSG_PUSH_STATE_PAYLOAD) != null) {
                    if (QLog.isDevelopLevel()) {
                        QLog.i("AIOMsgRecommendComponent", 4, "[handlePushStatePayload]: msgId is " + msgItem.getMsgId() + ", msgPushState is " + com.tencent.qqnt.aio.msg.d.g(msgItem));
                    }
                    T1(this, msgItem, false, false, 6, null);
                }
                if (map.get(AIOMsgItemPayloadType.MARKDOWN_STREAM_RUNNING_PAYLOAD) != null) {
                    l lVar2 = null;
                    if (QLog.isDevelopLevel()) {
                        long msgId = msgItem.getMsgId();
                        if (msgItem instanceof l) {
                            lVar = (l) msgItem;
                        } else {
                            lVar = null;
                        }
                        if (lVar != null) {
                            bool = Boolean.valueOf(lVar.d());
                        } else {
                            bool = null;
                        }
                        QLog.i("AIOMsgRecommendComponent", 4, "[handleMarkdownStreamPayload]: msgId is " + msgId + ", markDown running is " + bool);
                    }
                    if (msgItem instanceof l) {
                        lVar2 = (l) msgItem;
                    }
                    if (lVar2 != null && !lVar2.d()) {
                        T1(this, msgItem, false, false, 4, null);
                    }
                }
                if (map.get(AIOMsgItemPayloadType.SCREEN_SIZE_CHANGE) != null) {
                    T1(this, msgItem, false, false, 2, null);
                }
            }
        }
        return false;
    }

    private final boolean J1(AIOMsgItem msgItem) {
        if (((IRobotServiceApi) QRoute.api(IRobotServiceApi.class)).isRobotAIO(String.valueOf(msgItem.getMsgRecord().peerUin), Integer.valueOf(msgItem.getMsgRecord().chatType))) {
            return false;
        }
        return true;
    }

    private final boolean K1(AIOMsgItem msgItem) {
        c.C7310c c7310c = new c.C7310c(msgItem.getMsgId(), false, 2, null);
        sendIntent(c7310c);
        return c7310c.b();
    }

    private final void L1(InlineKeyboardButton buttonInfo, AIOMsgItem msgItem, int index) {
        if (QLog.isDevelopLevel()) {
            QLog.i("AIOMsgRecommendComponent", 4, "[reportClick]: em is em_bas_recommendation_message");
        }
        com.tencent.mobileqq.aio.utils.b.l("em_bas_recommendation_message", z1(buttonInfo, msgItem, index));
    }

    private final void M1(InlineKeyboardButton buttonInfo, AIOMsgItem msgItem, int index) {
        if (QLog.isDevelopLevel()) {
            QLog.i("AIOMsgRecommendComponent", 4, "[reportImpl]: em is em_bas_recommendation_message");
        }
        com.tencent.mobileqq.aio.utils.b.q("em_bas_recommendation_message", z1(buttonInfo, msgItem, index));
    }

    private final void N1() {
        D1().removeAllViews();
        D1().addView(C1());
        q1();
    }

    private final void O1(final AIOMsgItem msgItem, boolean delayToShow) {
        AdelieRecommendedMsgElement E1 = E1(msgItem);
        boolean z16 = true;
        boolean z17 = false;
        if (E1 != null && !com.tencent.mobileqq.aio.msglist.holder.component.assistedchat.helper.a.f190696a.b(E1, msgItem)) {
            if (delayToShow) {
                A1().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.msgaction.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        AIOMsgRecommendComponent.P1(AIOMsgRecommendComponent.this, msgItem);
                    }
                }, 1000L);
                return;
            }
            this.mHasIcon = J1(msgItem);
            D1().removeAllViews();
            ArrayList<InlineKeyboardRow> rows = E1.getRows();
            if (rows != null) {
                Iterator<T> it = rows.iterator();
                while (it.hasNext()) {
                    ArrayList<InlineKeyboardButton> buttons = ((InlineKeyboardRow) it.next()).getButtons();
                    if (buttons != null) {
                        Intrinsics.checkNotNullExpressionValue(buttons, "getButtons()");
                        for (InlineKeyboardButton buttonInfo : buttons) {
                            Intrinsics.checkNotNullExpressionValue(buttonInfo, "buttonInfo");
                            w1(buttonInfo);
                            z17 = true;
                        }
                    }
                }
            }
            if (QLog.isDevelopLevel()) {
                QLog.i("AIOMsgRecommendComponent", 4, "[showRecommendMsg]: msgId is " + msgItem.getMsgId() + ", show is " + z17);
            }
            if (z17) {
                q1();
                sendIntent(c.b.f191175d);
            } else {
                p1();
            }
            R1();
            return;
        }
        if (QLog.isDevelopLevel()) {
            long msgId = msgItem.getMsgId();
            if (E1 != null) {
                z16 = false;
            }
            QLog.i("AIOMsgRecommendComponent", 4, "[showRecommendMsg]: msgId is " + msgId + ", inlineKeyboardElement is null=" + z16);
        }
        p1();
        R1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P1(AIOMsgRecommendComponent this$0, AIOMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        this$0.O1(msgItem, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q1() {
        Drawable drawable;
        Drawable drawable2 = this.mLoadingDrawable;
        ApngDrawable apngDrawable = null;
        if (drawable2 != null) {
            drawable = drawable2.getCurrent();
        } else {
            drawable = null;
        }
        if (drawable instanceof ApngDrawable) {
            apngDrawable = (ApngDrawable) drawable;
        }
        if (apngDrawable != null) {
            try {
                apngDrawable.resume();
            } catch (Exception e16) {
                QLog.e("AIOMsgRecommendComponent", 1, "[startLoadingAnim]: " + e16);
            }
        }
    }

    private final void R1() {
        Drawable drawable;
        ApngDrawable apngDrawable;
        Drawable drawable2 = this.mLoadingDrawable;
        if (drawable2 != null) {
            drawable = drawable2.getCurrent();
        } else {
            drawable = null;
        }
        if (drawable instanceof ApngDrawable) {
            apngDrawable = (ApngDrawable) drawable;
        } else {
            apngDrawable = null;
        }
        if (apngDrawable != null) {
            try {
                apngDrawable.pause();
            } catch (Exception e16) {
                QLog.e("AIOMsgRecommendComponent", 1, "[startLoadingAnim]: " + e16);
            }
        }
        this.mLoadingDrawable = null;
    }

    private final void S1(AIOMsgItem msgItem, boolean checkStreamAnim, boolean delayToShow) {
        if (y1()) {
            return;
        }
        if (!msgItem.I() && msgItem.getMsgRecord().msgType != 29) {
            p1();
            return;
        }
        int g16 = com.tencent.qqnt.aio.msg.d.g(msgItem);
        if (QLog.isDevelopLevel()) {
            QLog.i("AIOMsgRecommendComponent", 4, "[updateRecommendMsgLayout]: msgId is " + msgItem.getMsgId() + ", pushState is " + g16);
        }
        if (g16 != 0) {
            if (g16 != 4) {
                if (g16 != 5 && g16 != 6) {
                    p1();
                    return;
                }
                if (checkStreamAnim && K1(msgItem)) {
                    if (QLog.isDevelopLevel()) {
                        QLog.i("AIOMsgRecommendComponent", 4, "[updateRecommendMsgLayout]: msgId is " + msgItem.getMsgId() + ", streamRunning");
                        return;
                    }
                    return;
                }
                O1(msgItem, delayToShow);
                return;
            }
            if (checkStreamAnim && K1(msgItem)) {
                if (QLog.isDevelopLevel()) {
                    QLog.i("AIOMsgRecommendComponent", 4, "[updateRecommendMsgLayout]: msgId is " + msgItem.getMsgId() + ", streamRunning, not show loadingView");
                    return;
                }
                return;
            }
            N1();
            return;
        }
        O1(msgItem, delayToShow);
    }

    static /* synthetic */ void T1(AIOMsgRecommendComponent aIOMsgRecommendComponent, AIOMsgItem aIOMsgItem, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        if ((i3 & 4) != 0) {
            z17 = true;
        }
        aIOMsgRecommendComponent.S1(aIOMsgItem, z16, z17);
    }

    private final void w1(final InlineKeyboardButton buttonInfo) {
        int i3 = this.index;
        String str = buttonInfo.label;
        Intrinsics.checkNotNullExpressionValue(str, "buttonInfo.label");
        LinearLayout F1 = F1(i3, str);
        final int i16 = this.index;
        F1.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.msgaction.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AIOMsgRecommendComponent.x1(AIOMsgRecommendComponent.this, buttonInfo, i16, view);
            }
        });
        if (F1.getParent() == null) {
            D1().addView(F1);
            M1(buttonInfo, this.mCurrentMsgItem, this.index);
        } else {
            QLog.e("AIOMsgRecommendComponent", 1, "textView already have parent");
        }
        this.index++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x1(AIOMsgRecommendComponent this$0, InlineKeyboardButton buttonInfo, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(buttonInfo, "$buttonInfo");
        if (!FastClickUtils.isFastDoubleClick("AIOMsgRecommendComponent")) {
            this$0.sendIntent(new c.a(this$0.mCurrentMsgItem, buttonInfo));
            this$0.L1(buttonInfo, this$0.mCurrentMsgItem, i3);
            com.tencent.mobileqq.aio.msglist.holder.component.assistedchat.helper.a.f190696a.f(buttonInfo, this$0.mCurrentMsgItem);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final boolean y1() {
        c.e eVar = new c.e(false, 1, null);
        sendIntent(eVar);
        return eVar.a();
    }

    private final HashMap<String, Object> z1(InlineKeyboardButton buttonInfo, AIOMsgItem msgItem, int index) {
        String str;
        MsgRecord msgRecord;
        if (msgItem == null || (str = Long.valueOf(msgItem.getMsgId()).toString()) == null) {
            str = "0";
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        String str2 = buttonInfo.label;
        Intrinsics.checkNotNullExpressionValue(str2, "buttonInfo.label");
        hashMap.put("text_content", str2);
        hashMap.put("msg_id", str);
        int i3 = 0;
        if (msgItem != null && (msgRecord = msgItem.getMsgRecord()) != null && msgRecord.msgType == 29) {
            i3 = 1;
        }
        hashMap.put("is_new_chat", Integer.valueOf(i3));
        hashMap.put("recom_trace_id", G1(o81.a.a(buttonInfo)));
        hashMap.put("sort_no", Integer.valueOf(index));
        String str3 = buttonInfo.data;
        Intrinsics.checkNotNullExpressionValue(str3, "buttonInfo.data");
        hashMap.put("callback_data", str3);
        if (QLog.isDevelopLevel()) {
            QLog.i("AIOMsgRecommendComponent", 4, "[getDTParams]: text is " + buttonInfo.label + ", msgId is " + str + ", callback_data is " + buttonInfo.data);
        }
        return hashMap;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(position), msgItem, payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        AIOMsgItem aIOMsgItem = (AIOMsgItem) msgItem;
        this.mCurrentMsgItem = aIOMsgItem;
        if (!aIOMsgItem.T0() && I1(aIOMsgItem, payloads)) {
            T1(this, aIOMsgItem, false, false, 2, null);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    public View c1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return D1();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c, com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: d1 */
    public com.tencent.aio.base.mvvm.b<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.aio.base.mvvm.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new d();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onDestroy();
        this.index = 0;
        R1();
        this.mCurrentMsgItem = null;
        p1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.aio.msglist.holder.component.e
    public void p1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.p1();
            A1().removeCallbacksAndMessages(null);
        }
    }
}

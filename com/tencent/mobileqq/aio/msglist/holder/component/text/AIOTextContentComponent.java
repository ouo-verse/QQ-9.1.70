package com.tencent.mobileqq.aio.msglist.holder.component.text;

import android.animation.Animator;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.aio.msg.TextMsgContent;
import com.tencent.mobileqq.aio.msg.ae;
import com.tencent.mobileqq.aio.msglist.holder.AIOMsgItemUIState;
import com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.f;
import com.tencent.mobileqq.aio.msglist.holder.component.stream.anomator.e;
import com.tencent.mobileqq.aio.msglist.holder.component.text.AIOTextContentComponent$mContentWithForeground$2;
import com.tencent.mobileqq.aio.msglist.holder.component.text.AIOTextContentComponent$mStreamAnimatorListener$2;
import com.tencent.mobileqq.aio.msglist.holder.d;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.aio.utils.StopWatch;
import com.tencent.mobileqq.aio.utils.m;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.holder.IMsgItemMviUIState;
import com.tencent.qqnt.aio.menu.ad;
import com.tencent.qqnt.aio.menu.af;
import com.tencent.qqnt.aio.menu.ag;
import com.tencent.qqnt.aio.menu.aj;
import com.tencent.qqnt.aio.menu.ak;
import com.tencent.qqnt.aio.menu.an;
import com.tencent.qqnt.aio.menu.ao;
import com.tencent.qqnt.aio.menu.ap;
import com.tencent.qqnt.aio.menu.h;
import com.tencent.qqnt.aio.menu.i;
import com.tencent.qqnt.aio.menu.k;
import com.tencent.qqnt.aio.menu.n;
import com.tencent.qqnt.aio.menu.u;
import com.tencent.qqnt.aio.msg.d;
import com.tencent.qqnt.aio.widget.SelectableLinearLayout;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ca\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0002DJ\b\u0016\u0018\u0000 m2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001nB\u000f\u0012\u0006\u0010C\u001a\u00020>\u00a2\u0006\u0004\bk\u0010lJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0016\u0010\b\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\u0016\u0010\f\u001a\u00020\u000b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\b\u0010\r\u001a\u00020\u0003H\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u000bH\u0002J\u0012\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J*\u0010\u001d\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0012\u0010\u001e\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010\u001f\u001a\u00020\u0003H\u0002J\b\u0010 \u001a\u00020\u0003H\u0002J\u0010\u0010#\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020!H\u0002J\b\u0010%\u001a\u00020$H\u0016J\n\u0010&\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010(\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u001bH\u0016J&\u0010,\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020*2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\b\u0010.\u001a\u00020-H\u0014J\b\u00100\u001a\u00020/H\u0016J\b\u00101\u001a\u00020\u0003H\u0016J\b\u00102\u001a\u00020\u0003H\u0016J\u000e\u00105\u001a\b\u0012\u0004\u0012\u00020403H\u0016J\u0006\u00107\u001a\u000206J\b\u00108\u001a\u00020\u000bH\u0016J\u0016\u0010;\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020:0903H\u0016J\u0010\u0010<\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020:H\u0016J\b\u0010=\u001a\u00020\u0003H\u0016R\u0017\u0010C\u001a\u00020>8\u0006\u00a2\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u001b\u0010I\u001a\u00020D8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\u001b\u0010N\u001a\u00020J8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bK\u0010F\u001a\u0004\bL\u0010MR\u001b\u0010S\u001a\u00020O8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bP\u0010F\u001a\u0004\bQ\u0010RR\u0018\u0010W\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u001b\u0010[\u001a\u00020$8DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\bX\u0010F\u001a\u0004\bY\u0010ZR\u001b\u0010_\u001a\u00020-8DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\\\u0010F\u001a\u0004\b]\u0010^R\u0016\u0010c\u001a\u00020`8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u0018\u0010g\u001a\u0004\u0018\u00010d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010fR\u0016\u0010j\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010i\u00a8\u0006o"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/text/AIOTextContentComponent;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/BaseContentComponent;", "Lcom/tencent/mobileqq/aio/msg/ae;", "", "P1", "", "", "payloads", "O1", "k2", "Q1", "", "f2", "T1", "Lcom/tencent/qqnt/aio/menu/ui/c;", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Lcom/tencent/aio/api/runtime/a;", "U1", "m2", "Landroid/view/MotionEvent;", "event", "e2", "Landroid/animation/Animator;", "animation", "", "originContent", "streamContent", "", "endIndex", "i2", SemanticAttributes.DbSystemValues.H2, "g2", "j2", "Lcom/tencent/mobileqq/aio/msglist/holder/AIOMsgItemUIState$EndStreamAnimUIState;", "state", "d2", "Landroid/view/View;", "c1", "e1", "importance", "l1", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "b1", "Lcom/tencent/mobileqq/aio/msg/TextMsgContent;", "R1", "Lcom/tencent/mobileqq/aio/msglist/holder/component/text/b;", "S1", "h1", "j1", "", "Lcom/tencent/qqnt/aio/menu/ui/d;", ICustomDataEditor.STRING_PARAM_1, "Lcom/tencent/qqnt/aio/widget/SelectableLinearLayout;", "Z1", ExifInterface.LATITUDE_SOUTH, "Ljava/lang/Class;", "Lcom/tencent/qqnt/aio/holder/IMsgItemMviUIState;", "getObserverStates", "g1", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "com/tencent/mobileqq/aio/msglist/holder/component/text/AIOTextContentComponent$mContentWithForeground$2$1", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "W1", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/text/AIOTextContentComponent$mContentWithForeground$2$1;", "mContentWithForeground", "com/tencent/mobileqq/aio/msglist/holder/component/text/AIOTextContentComponent$mStreamAnimatorListener$2$a", "D", "Y1", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/text/AIOTextContentComponent$mStreamAnimatorListener$2$a;", "mStreamAnimatorListener", "Landroid/text/SpannableString;", "E", "X1", "()Landroid/text/SpannableString;", "mLoadingDotString", "Lcom/tencent/mobileqq/aio/msglist/holder/component/stream/anomator/a;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/aio/msglist/holder/component/stream/anomator/a;", "mStreamAnimatorAdorn", "G", "V1", "()Landroid/view/View;", "foregroundView", "H", "c2", "()Lcom/tencent/mobileqq/aio/msg/TextMsgContent;", "textContent", "Lcom/tencent/mobileqq/aio/msglist/holder/component/f;", "I", "Lcom/tencent/mobileqq/aio/msglist/holder/component/f;", "shootBubbleContent", "Lcom/tencent/mobileqq/aio/msg/action/c;", "J", "Lcom/tencent/mobileqq/aio/msg/action/c;", "msgActionView", "K", "Z", "isActionViewCreated", "<init>", "(Landroid/content/Context;)V", "L", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public class AIOTextContentComponent extends BaseContentComponent<ae> {
    static IPatchRedirector $redirector_;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy mContentWithForeground;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy mStreamAnimatorListener;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy mLoadingDotString;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.aio.msglist.holder.component.stream.anomator.a mStreamAnimatorAdorn;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy foregroundView;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy textContent;

    /* renamed from: I, reason: from kotlin metadata */
    private f shootBubbleContent;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.aio.msg.action.c msgActionView;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean isActionViewCreated;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/text/AIOTextContentComponent$a;", "", "", "CHAR_ELLIPSIS", "Ljava/lang/String;", "TAG", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.text.AIOTextContentComponent$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63578);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 19)) {
            redirector.redirect((short) 19);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOTextContentComponent(@NotNull Context context) {
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
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AIOTextContentComponent$mContentWithForeground$2.AnonymousClass1>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.text.AIOTextContentComponent$mContentWithForeground$2
            static IPatchRedirector $redirector_;

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/text/AIOTextContentComponent$mContentWithForeground$2$a", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "v", "", "onViewAttachedToWindow", "onViewDetachedFromWindow", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes11.dex */
            public static final class a implements View.OnAttachStateChangeListener {
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ AIOTextContentComponent f191991d;

                a(AIOTextContentComponent aIOTextContentComponent) {
                    this.f191991d = aIOTextContentComponent;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) aIOTextContentComponent);
                    }
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(@NotNull View v3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) v3);
                    } else {
                        Intrinsics.checkNotNullParameter(v3, "v");
                    }
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(@NotNull View v3) {
                    ae q16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this, (Object) v3);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(v3, "v");
                    if (this.f191991d.w1()) {
                        q16 = this.f191991d.q1();
                        if (d.M(q16)) {
                            this.f191991d.T1();
                        }
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOTextContentComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r2v0, types: [com.tencent.mobileqq.aio.msglist.holder.component.text.AIOTextContentComponent$mContentWithForeground$2$1, android.view.View, android.view.ViewGroup] */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AnonymousClass1 invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (AnonymousClass1) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                ?? r26 = new ConstraintLayout(AIOTextContentComponent.this.getContext()) { // from class: com.tencent.mobileqq.aio.msglist.holder.component.text.AIOTextContentComponent$mContentWithForeground$2.1
                    static IPatchRedirector $redirector_;

                    {
                        super(r5);
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AIOTextContentComponent.this, (Object) r5);
                        }
                    }

                    @Override // android.view.ViewGroup
                    public boolean onInterceptTouchEvent(@Nullable MotionEvent ev5) {
                        boolean e26;
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                            e26 = AIOTextContentComponent.this.e2(ev5);
                            return e26;
                        }
                        return ((Boolean) iPatchRedirector3.redirect((short) 2, (Object) this, (Object) ev5)).booleanValue();
                    }
                };
                AIOTextContentComponent aIOTextContentComponent = AIOTextContentComponent.this;
                r26.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                r26.addView(aIOTextContentComponent.c2().j(), 0);
                View V1 = aIOTextContentComponent.V1();
                ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(0, 0);
                layoutParams.startToStart = 0;
                layoutParams.endToEnd = 0;
                layoutParams.topToTop = 0;
                layoutParams.bottomToBottom = 0;
                layoutParams.leftToLeft = 0;
                layoutParams.rightToRight = 0;
                layoutParams.matchConstraintPercentWidth = 1.0f;
                layoutParams.matchConstraintPercentHeight = 1.0f;
                Unit unit = Unit.INSTANCE;
                r26.addView(V1, layoutParams);
                r26.setImportantForAccessibility(2);
                r26.addOnAttachStateChangeListener(new a(aIOTextContentComponent));
                return r26;
            }
        });
        this.mContentWithForeground = lazy;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<AIOTextContentComponent$mStreamAnimatorListener$2.a>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.text.AIOTextContentComponent$mStreamAnimatorListener$2
            static IPatchRedirector $redirector_;

            /* compiled from: P */
            @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J4\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\r\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/text/AIOTextContentComponent$mStreamAnimatorListener$2$a", "Lcom/tencent/mobileqq/aio/msglist/holder/component/stream/anomator/d;", "Landroid/widget/TextView;", "textView", "Landroid/animation/Animator;", "animation", "", "originContent", "streamContent", "", "endIndex", "", "a", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes11.dex */
            public static final class a implements com.tencent.mobileqq.aio.msglist.holder.component.stream.anomator.d {
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ AIOTextContentComponent f191992a;

                a(AIOTextContentComponent aIOTextContentComponent) {
                    this.f191992a = aIOTextContentComponent;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) aIOTextContentComponent);
                    }
                }

                @Override // com.tencent.mobileqq.aio.msglist.holder.component.stream.anomator.d
                public void a(@Nullable TextView textView, @Nullable Animator animation, @NotNull CharSequence originContent, @NotNull CharSequence streamContent, int endIndex) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, this, textView, animation, originContent, streamContent, Integer.valueOf(endIndex));
                        return;
                    }
                    Intrinsics.checkNotNullParameter(originContent, "originContent");
                    Intrinsics.checkNotNullParameter(streamContent, "streamContent");
                    this.f191992a.i2(animation, originContent, streamContent, endIndex);
                }

                @Override // com.tencent.mobileqq.aio.msglist.holder.component.stream.anomator.d
                public void onAnimationCancel(@Nullable Animator animation) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                        this.f191992a.j2();
                    } else {
                        iPatchRedirector.redirect((short) 5, (Object) this, (Object) animation);
                    }
                }

                @Override // com.tencent.mobileqq.aio.msglist.holder.component.stream.anomator.d
                public void onAnimationEnd(@Nullable Animator animation) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                        this.f191992a.g2();
                    } else {
                        iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
                    }
                }

                @Override // com.tencent.mobileqq.aio.msglist.holder.component.stream.anomator.d
                public void onAnimationStart(@Nullable Animator animation) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                        this.f191992a.h2(animation);
                    } else {
                        iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOTextContentComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new a(AIOTextContentComponent.this) : (a) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.mStreamAnimatorListener = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SpannableString>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.text.AIOTextContentComponent$mLoadingDotString$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOTextContentComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SpannableString invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? e.f191878a.a(AIOTextContentComponent.this.getContext()) : (SpannableString) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.mLoadingDotString = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.text.AIOTextContentComponent$foregroundView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOTextContentComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new View(AIOTextContentComponent.this.getContext()) : (View) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.foregroundView = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<TextMsgContent>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.text.AIOTextContentComponent$textContent$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOTextContentComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextMsgContent invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (TextMsgContent) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                TextMsgContent R1 = AIOTextContentComponent.this.R1();
                AIOTextContentComponent aIOTextContentComponent = AIOTextContentComponent.this;
                com.tencent.mobileqq.aio.msglist.holder.component.text.util.a aVar = com.tencent.mobileqq.aio.msglist.holder.component.text.util.a.f192006a;
                R1.u(aVar.c(aIOTextContentComponent));
                aVar.g(R1.j(), aIOTextContentComponent);
                aVar.f(R1.j(), aIOTextContentComponent);
                return R1;
            }
        });
        this.textContent = lazy5;
    }

    private final void O1(List<Object> payloads) {
        if (d.a(q1()) == null) {
            return;
        }
        k2();
        com.tencent.mobileqq.aio.msg.action.c cVar = this.msgActionView;
        if (cVar != null) {
            if (cVar.a(q1(), payloads)) {
                c2().A(cVar.getRoot(), q1(), cVar.getMinWidth());
            } else {
                c2().q(cVar.getRoot(), q1());
            }
        }
    }

    private final void P1() {
        q1().H2(v1());
        c2().z(m2());
        c2().e(q1());
        q1().H2(false);
        f fVar = new f(q1(), this, this.context, W1());
        this.shootBubbleContent = fVar;
        fVar.e();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r4v9, types: [java.lang.CharSequence] */
    private final void Q1() {
        CharSequence u26;
        com.tencent.mobileqq.aio.msglist.holder.component.stream.anomator.a aVar;
        if (q1().E2()) {
            com.tencent.mobileqq.aio.msglist.holder.component.stream.anomator.a aVar2 = this.mStreamAnimatorAdorn;
            if (aVar2 != null) {
                aVar2.cancel();
            }
            com.tencent.mobileqq.aio.msglist.holder.component.stream.anomator.a aVar3 = this.mStreamAnimatorAdorn;
            if (aVar3 != null) {
                aVar3.b();
            }
        }
        String str = "";
        int i3 = 0;
        if (q1().D2()) {
            if (this.mStreamAnimatorAdorn == null) {
                this.mStreamAnimatorAdorn = new com.tencent.mobileqq.aio.msglist.holder.component.stream.anomator.c(Y1());
            }
            com.tencent.mobileqq.aio.msglist.holder.component.stream.anomator.a aVar4 = this.mStreamAnimatorAdorn;
            if (aVar4 != null) {
                ?? u27 = q1().u2();
                if (u27 != 0) {
                    str = u27;
                }
                aVar4.c(null, str);
            }
            com.tencent.mobileqq.aio.msglist.holder.component.stream.anomator.a aVar5 = this.mStreamAnimatorAdorn;
            if (aVar5 != null) {
                aVar5.start();
            }
            q1().b(false);
            return;
        }
        boolean z16 = true;
        if (q1().B2() && d.g(q1()) != 3 && q1().I()) {
            q1().h(false);
            com.tencent.mobileqq.aio.msglist.holder.component.stream.anomator.a aVar6 = this.mStreamAnimatorAdorn;
            if (aVar6 == null || !aVar6.isStarted()) {
                z16 = false;
            }
            if (z16 && (aVar = this.mStreamAnimatorAdorn) != null) {
                aVar.pause();
            }
            if (!q1().E2() && (u26 = q1().u2()) != null) {
                i3 = u26.length();
            }
            if (this.mStreamAnimatorAdorn == null) {
                this.mStreamAnimatorAdorn = new com.tencent.mobileqq.aio.msglist.holder.component.stream.anomator.c(Y1());
            }
            com.tencent.mobileqq.aio.msglist.holder.component.stream.anomator.a aVar7 = this.mStreamAnimatorAdorn;
            if (aVar7 != null) {
                ?? u28 = q1().u2();
                if (u28 != 0) {
                    str = u28;
                }
                aVar7.a(i3, null, str);
            }
            com.tencent.mobileqq.aio.msglist.holder.component.stream.anomator.a aVar8 = this.mStreamAnimatorAdorn;
            if (aVar8 != null) {
                aVar8.start();
                return;
            }
            return;
        }
        com.tencent.mobileqq.aio.msglist.holder.component.stream.anomator.a aVar9 = this.mStreamAnimatorAdorn;
        if (aVar9 != null) {
            aVar9.cancel();
        }
        com.tencent.mobileqq.aio.msglist.holder.component.stream.anomator.a aVar10 = this.mStreamAnimatorAdorn;
        if (aVar10 != null) {
            aVar10.b();
        }
        q1().b(false);
        q1().h(false);
        if (e81.a.a(q1())) {
            q1().I2(TextUtils.concat(q1().u2(), "\u2026"));
        } else if (d.g(q1()) == 1) {
            q1().I2(TextUtils.concat(q1().u2(), X1()));
        } else {
            q1().I2(q1().u2());
        }
        P1();
        sendIntent(new d.az(q1(), false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T1() {
        q1().b(false);
        q1().h(false);
        com.tencent.mobileqq.aio.msglist.holder.component.stream.anomator.a aVar = this.mStreamAnimatorAdorn;
        if (aVar != null) {
            aVar.end();
        }
        sendIntent(new d.az(q1(), false));
    }

    private final com.tencent.aio.api.runtime.a U1() {
        d.e eVar = new d.e(null, 1, null);
        sendIntent(new d.h(eVar));
        return eVar.a();
    }

    private final AIOTextContentComponent$mContentWithForeground$2.AnonymousClass1 W1() {
        return (AIOTextContentComponent$mContentWithForeground$2.AnonymousClass1) this.mContentWithForeground.getValue();
    }

    private final SpannableString X1() {
        return (SpannableString) this.mLoadingDotString.getValue();
    }

    private final AIOTextContentComponent$mStreamAnimatorListener$2.a Y1() {
        return (AIOTextContentComponent$mStreamAnimatorListener$2.a) this.mStreamAnimatorListener.getValue();
    }

    private final com.tencent.qqnt.aio.menu.ui.c a2() {
        com.tencent.qqnt.aio.menu.ui.c cVar = new com.tencent.qqnt.aio.menu.ui.c();
        com.tencent.qqnt.aio.menu.d dVar = new com.tencent.qqnt.aio.menu.d(getMContext(), q1());
        dVar.l(c2().j());
        cVar.a(dVar);
        an anVar = new an(getMContext(), q1());
        anVar.j(c2().j());
        cVar.a(anVar);
        cVar.a(new k(getMContext(), q1(), this, c2().j()));
        i iVar = new i(getMContext(), q1());
        iVar.i(c2().j());
        cVar.a(iVar);
        cVar.a(new ak(getMContext(), q1(), this));
        if (com.tencent.mobileqq.aio.msglist.holder.component.text.menuitems.a.INSTANCE.b()) {
            cVar.a(new com.tencent.mobileqq.aio.msglist.holder.component.text.menuitems.a(getMContext(), q1(), c2().j()));
        }
        return cVar;
    }

    private final void d2(AIOMsgItemUIState.EndStreamAnimUIState state) {
        if (w1() && q1().getMsgId() == state.a()) {
            T1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean e2(MotionEvent event) {
        boolean z16;
        boolean z17;
        if (event != null && event.getAction() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        com.tencent.mobileqq.aio.msglist.holder.component.stream.anomator.a aVar = this.mStreamAnimatorAdorn;
        if (aVar != null && aVar.isStarted()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            return true;
        }
        if (com.tencent.qqnt.aio.msg.d.g(q1()) == 1 && q1().I()) {
            return true;
        }
        return false;
    }

    private final boolean f2(List<Object> payloads) {
        f fVar;
        com.tencent.mobileqq.aio.msglist.holder.skin.a t06;
        if (payloads.isEmpty()) {
            return true;
        }
        boolean z16 = false;
        for (Object obj : payloads) {
            if (obj instanceof HashMap) {
                Map map = (Map) obj;
                if (map.get(AIOMsgItemPayloadType.BUBBLE_REFRESH_PAYLOAD) != null) {
                    if (QLog.isDevelopLevel()) {
                        QLog.i("AIOTextContentComponent", 4, "[handleRefreshPayLoad]: msgId is " + q1().getMsgId() + ", qqtext is " + ((Object) q1().u2()));
                    }
                    c2().H(q1());
                    c2().J(q1());
                }
                if (map.get(AIOMsgItemPayloadType.SHOOT_BUBBLE_PAYLOAD) != null && (t06 = q1().t0()) != null) {
                    if (QLog.isDevelopLevel()) {
                        QLog.i("AIOTextContentComponent", 4, "[handleShotBubblePayload]: msgId is " + q1().getMsgId() + ", qqtext is " + ((Object) q1().u2()));
                    }
                    f fVar2 = this.shootBubbleContent;
                    if (fVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("shootBubbleContent");
                        fVar2 = null;
                    }
                    fVar2.f(t06);
                    t06.c(false);
                }
                if (map.get(AIOMsgItemPayloadType.VAS_FONT_PAYLOAD) != null) {
                    if (QLog.isDevelopLevel()) {
                        QLog.i("AIOTextContentComponent", 4, "[handleFontPayload]: msgId is " + q1().getMsgId() + ", qqtext is " + ((Object) q1().u2()));
                    }
                    c2().J(q1());
                }
                if (map.get(AIOMsgItemPayloadType.LOAD_AVATAR_PENDANT_PAYLOAD) != null) {
                    if (QLog.isDevelopLevel()) {
                        QLog.i("AIOTextContentComponent", 4, "[handlePayloadData] do shoot bubble, msgId is " + q1().getMsgId() + ", qqtext is " + com.tencent.util.k.c(q1().u2()));
                    }
                    f fVar3 = this.shootBubbleContent;
                    if (fVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("shootBubbleContent");
                        fVar = null;
                    } else {
                        fVar = fVar3;
                    }
                    fVar.e();
                }
                if (map.get(AIOMsgItemPayloadType.AIO_TEXT_UPDATE_EMOTICON_PAYLOAD) != null) {
                    if (QLog.isDevelopLevel()) {
                        QLog.i("AIOTextContentComponent", 4, "[handleEmoPayload]: msgId is " + q1().getMsgId() + ", qqtext is " + ((Object) q1().u2()));
                    }
                    c2().B(q1());
                }
                if (map.get(AIOMsgItemPayloadType.AIO_TEXT_RICH_MSG_PAYLOAD) != null) {
                    QLog.d("AIOTextContentComponent", 1, "[handleRichPayload]: msgId is " + q1().getMsgId() + ", linkInfo is " + q1().r2());
                    c2().F(q1(), q1().r2());
                }
                if (map.get(AIOMsgItemPayloadType.THEME_CHANGE_PAYLOAD) != null) {
                    c2().H(q1());
                    c2().J(q1());
                }
                if (map.get(AIOMsgItemPayloadType.ADELIE_MSG_PUSH_STATE_PAYLOAD) != null) {
                    z16 = true;
                }
                if (map.get(AIOMsgItemPayloadType.LAST_RECEIVE_MSG_PAYLOAD) != null && com.tencent.qqnt.aio.msg.d.M(q1()) && !q1().I()) {
                    T1();
                }
            }
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g2() {
        if (QLog.isColorLevel()) {
            QLog.d("AIOTextContentComponent", 2, "onAnimationEnd seq=" + q1().getMsgSeq() + " status=" + com.tencent.qqnt.aio.msg.d.g(q1()));
        }
        int g16 = com.tencent.qqnt.aio.msg.d.g(q1());
        if (g16 != 2) {
            if (g16 == 3) {
                q1().I2(TextUtils.concat(q1().u2(), "\u2026"));
                P1();
            }
        } else {
            q1().I2(q1().u2());
            P1();
        }
        if (com.tencent.qqnt.aio.msg.d.g(q1()) != 1) {
            sendIntent(new d.az(q1(), false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h2(Animator animation) {
        long j3;
        Long l3;
        if (QLog.isColorLevel()) {
            long msgSeq = q1().getMsgSeq();
            int g16 = com.tencent.qqnt.aio.msg.d.g(q1());
            if (animation != null) {
                l3 = Long.valueOf(animation.getDuration());
            } else {
                l3 = null;
            }
            QLog.d("AIOTextContentComponent", 2, "onAnimationStart seq=" + msgSeq + " status=" + g16 + " duration=" + l3);
        }
        if (animation != null) {
            j3 = animation.getDuration();
        } else {
            j3 = 0;
        }
        if (j3 > 0) {
            sendIntent(new d.az(q1(), true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0030, code lost:
    
        if (q1().I() == false) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void i2(Animator animation, CharSequence originContent, CharSequence streamContent, int endIndex) {
        boolean z16;
        if (endIndex != originContent.length() || !e81.a.a(q1())) {
            if (endIndex < originContent.length()) {
                if (animation != null && !animation.isStarted()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                }
            }
            if (endIndex < originContent.length() || com.tencent.qqnt.aio.msg.d.g(q1()) == 1) {
                streamContent = TextUtils.concat(streamContent, X1());
                Intrinsics.checkNotNullExpressionValue(streamContent, "concat(currText, mLoadingDotString)");
            }
            if (Intrinsics.areEqual(q1().y2(), streamContent)) {
                q1().I2(streamContent);
                P1();
                return;
            }
            return;
        }
        streamContent = TextUtils.concat(streamContent, "\u2026");
        Intrinsics.checkNotNullExpressionValue(streamContent, "concat(currText, CHAR_ELLIPSIS)");
        if (Intrinsics.areEqual(q1().y2(), streamContent)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j2() {
        if (QLog.isColorLevel()) {
            QLog.d("AIOTextContentComponent", 2, "onAnimationCancel seq=" + q1().getMsgSeq() + " status=" + com.tencent.qqnt.aio.msg.d.g(q1()));
        }
    }

    private final void k2() {
        if (this.isActionViewCreated) {
            return;
        }
        this.isActionViewCreated = true;
        if (this.msgActionView == null) {
            this.msgActionView = com.tencent.mobileqq.aio.msg.action.d.f190103a.a(U1(), new com.tencent.mobileqq.aio.msg.action.a() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.text.a
                @Override // com.tencent.mobileqq.aio.msg.action.a
                public final void a(IMsgItemMviUIState iMsgItemMviUIState) {
                    AIOTextContentComponent.l2(AIOTextContentComponent.this, iMsgItemMviUIState);
                }
            });
        }
        com.tencent.mobileqq.aio.msg.action.c cVar = this.msgActionView;
        if (cVar != null) {
            cVar.onCreate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l2(AIOTextContentComponent this$0, IMsgItemMviUIState it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.handleUIState(it);
    }

    private final boolean m2() {
        d.l lVar = new d.l(false, 1, null);
        sendIntent(lVar);
        if (!lVar.a() || q1().isSelf()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public TextMsgContent R1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (TextMsgContent) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return new TextMsgContent(this.context, V1());
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.qqnt.aio.holder.template.b
    public boolean S() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        if (c2().j().q()) {
            return true;
        }
        com.tencent.mobileqq.aio.msglist.holder.component.stream.anomator.a aVar = this.mStreamAnimatorAdorn;
        if (aVar != null && aVar.isStarted()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        if (com.tencent.qqnt.aio.msg.d.g(q1()) == 1 && q1().I()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent
    @NotNull
    /* renamed from: S1, reason: merged with bridge method [inline-methods] */
    public b createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (b) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final View V1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return (View) this.foregroundView.getValue();
    }

    @NotNull
    public final SelectableLinearLayout Z1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (SelectableLinearLayout) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return c2().j();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mobileqq.aio.msglist.holder.component.c
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(position), msgItem, payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        StopWatch i3 = new StopWatch("AIOBind.AIOTextContentComponent-(" + hashCode() + "-" + msgItem.getMsgId() + ")", QLog.isColorLevel()).i();
        super.b1(position, msgItem, payloads);
        if (f2(payloads) || !z1()) {
            z16 = true;
        }
        if (!z16) {
            O1(payloads);
            i3.b("handle payload (" + msgItem.getMsgId() + ")");
            return;
        }
        if (com.tencent.qqnt.aio.msg.d.M(q1())) {
            Q1();
        } else {
            P1();
        }
        O1(payloads);
        i3.e("bind text view");
        i3.b("bind (" + q1().getMsgId() + "," + ((Object) AIOUtil.f194084a.o(q1().u2())) + ")");
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    public View c1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return W1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final TextMsgContent c2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (TextMsgContent) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return (TextMsgContent) this.textContent.getValue();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @Nullable
    public View e1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return c2().j();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c, com.tencent.mvi.mvvm.BaseVB
    /* renamed from: g1 */
    public void handleUIState(@NotNull IMsgItemMviUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        super.handleUIState(state);
        if (state instanceof AIOMsgItemUIState.EndStreamAnimUIState) {
            d2((AIOMsgItemUIState.EndStreamAnimUIState) state);
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

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends IMsgItemMviUIState>> getObserverStates() {
        List<Class<? extends IMsgItemMviUIState>> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(AIOMsgItemUIState.EndStreamAnimUIState.class);
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 16, (Object) this);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mobileqq.aio.msglist.holder.component.c
    public void h1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("aio_information_type", String.valueOf(q1().getMsgRecord().msgType));
        com.tencent.mobileqq.aio.utils.b.l("em_bas_message_bubble", hashMap);
        d.p pVar = new d.p(false, 1, null);
        sendIntent(pVar);
        if (!com.tencent.qqnt.util.b.f362976b.enableTalkBack() && !pVar.a()) {
            boolean isSelf = q1().isSelf();
            c2().j().u(isSelf);
            QLog.d("AIOTextContentComponent", 1, "startSelect " + isSelf);
            sendIntent(new d.ao(c2().j(), u1(), a2()));
            return;
        }
        super.h1();
        QLog.d("AIOTextContentComponent", 1, "no support on talkback");
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    public void j1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else if (w1() && c2().j().q()) {
            sendIntent(d.f.f192343d);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    public void l1(int importance) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, importance);
        } else {
            c2().j().setImportantForAccessibility(importance);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        Long l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            int hashCode = hashCode();
            ae D1 = D1();
            if (D1 != null) {
                l3 = Long.valueOf(D1.getMsgId());
            } else {
                l3 = null;
            }
            QLog.iAsync("AIOTextContentComponent", 2, "[onDestroy] this=" + hashCode + " msgId=" + l3);
        }
        if (w1()) {
            E1(ae.INSTANCE.b());
        }
        com.tencent.mobileqq.aio.msglist.holder.component.stream.anomator.a aVar = this.mStreamAnimatorAdorn;
        if (aVar != null) {
            aVar.cancel();
        }
        com.tencent.mobileqq.aio.msglist.holder.component.stream.anomator.a aVar2 = this.mStreamAnimatorAdorn;
        if (aVar2 != null) {
            aVar2.b();
        }
        com.tencent.mobileqq.aio.msg.action.c cVar = this.msgActionView;
        if (cVar != null) {
            cVar.onDestroy();
        }
        this.isActionViewCreated = false;
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent
    @NotNull
    public List<com.tencent.qqnt.aio.menu.ui.d> s1() {
        List listOf;
        boolean z16;
        List<com.tencent.qqnt.aio.menu.ui.d> mutableListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (List) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        boolean z17 = false;
        if (q1().getMsgRecord().chatType == 8) {
            com.tencent.qqnt.aio.menu.d dVar = new com.tencent.qqnt.aio.menu.d(getMContext(), q1());
            dVar.l(c2().j());
            Unit unit = Unit.INSTANCE;
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(dVar, new k(getMContext(), q1(), this, null, 8, null), new i(getMContext(), q1()), new h(getMContext(), q1(), this));
            return mutableListOf;
        }
        ArrayList arrayList = new ArrayList();
        com.tencent.qqnt.aio.menu.d dVar2 = new com.tencent.qqnt.aio.menu.d(getMContext(), q1());
        dVar2.l(c2().j());
        Unit unit2 = Unit.INSTANCE;
        i iVar = new i(getMContext(), q1());
        iVar.i(c2().j());
        an anVar = new an(getMContext(), q1());
        anVar.j(c2().j());
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.qqnt.aio.menu.ui.d[]{dVar2, new k(getMContext(), q1(), this, c2().j()), iVar, new af(getMContext(), q1(), this), new h(getMContext(), q1(), this), new u(getMContext(), q1(), this), new ad(getMContext(), q1(), this), anVar, new ap(getMContext(), q1(), this), new com.tencent.qqnt.aio.menu.a(getMContext(), q1(), this), new ao(getMContext(), q1()), new ag(getMContext(), q1())});
        arrayList.addAll(listOf);
        if (com.tencent.mobileqq.aio.msglist.holder.component.text.menuitems.a.INSTANCE.b()) {
            arrayList.add(new com.tencent.mobileqq.aio.msglist.holder.component.text.menuitems.a(getMContext(), q1(), c2().j()));
        }
        arrayList.add(new aj(getMContext(), q1(), this));
        if (q1().getMsgRecord().chatType == 2 || q1().getMsgRecord().chatType == 1) {
            String b16 = m.f194167a.b(q1());
            if (b16.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && !Intrinsics.areEqual(b16, "0")) {
                z17 = true;
            }
            if (z17) {
                arrayList.add(new n(getMContext(), q1(), this));
            }
        }
        return arrayList;
    }
}

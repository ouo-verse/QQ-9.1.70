package com.tencent.mobileqq.aio.msglist.holder.component.anisticker;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AniStickerMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.d;
import com.tencent.mobileqq.aio.msglist.payload.AIOMsgItemPayloadType;
import com.tencent.mobileqq.aio.msglist.payload.a;
import com.tencent.mobileqq.aio.utils.p;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IReportControllerApi;
import com.tencent.qqnt.aio.anisticker.view.AniStickerLottieView;
import com.tencent.qqnt.aio.anisticker.view.e;
import com.tencent.qqnt.aio.anisticker.view.h;
import com.tencent.qqnt.aio.menu.ad;
import com.tencent.qqnt.aio.menu.af;
import com.tencent.qqnt.aio.menu.aj;
import com.tencent.qqnt.aio.menu.ap;
import com.tencent.qqnt.aio.menu.i;
import com.tencent.qqnt.aio.menu.k;
import com.tencent.qqnt.aio.menu.u;
import com.tencent.qqnt.aio.utils.q;
import com.tencent.qqnt.kernel.nativeinterface.FaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
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

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 A2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001BB\u000f\u0012\u0006\u00100\u001a\u00020-\u00a2\u0006\u0004\b?\u0010@J\b\u0010\u0004\u001a\u00020\u0003H\u0016J&\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J\u0016\u0010\u0019\u001a\u00020\u00182\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\b\u0010\u001a\u001a\u00020\fH\u0002J\u0010\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0016H\u0002J\b\u0010\u001d\u001a\u00020\fH\u0002J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010 \u001a\u00020\u0005H\u0002J\b\u0010!\u001a\u00020\fH\u0002J\b\u0010\"\u001a\u00020\u0018H\u0002J\u0010\u0010#\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010$\u001a\u00020\u0005H\u0002J\b\u0010%\u001a\u00020\fH\u0002J\u001a\u0010(\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00022\b\u0010'\u001a\u0004\u0018\u00010&H\u0002J\u0010\u0010)\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0002H\u0002J\n\u0010+\u001a\u0004\u0018\u00010*H\u0002J\u0012\u0010,\u001a\u00020\f2\b\u0010'\u001a\u0004\u0018\u00010\u000eH\u0002R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u001b\u00105\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010:\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010>\u001a\u00020;8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b<\u0010=\u00a8\u0006C"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/anisticker/AIOAniStickerContentComponent;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/BaseContentComponent;", "Lcom/tencent/mobileqq/aio/msg/AniStickerMsgItem;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/anisticker/b;", "O1", "", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "", "payloads", "", "b1", "Landroid/view/View;", "c1", "", "Lcom/tencent/qqnt/aio/menu/ui/d;", ICustomDataEditor.STRING_PARAM_1, "e1", "Landroid/widget/RelativeLayout;", "M1", "", "c2", "", "U1", "e2", "resultId", "f2", "W1", "Lcom/tencent/qqnt/aio/anisticker/view/e$a;", "L1", "S1", "X1", "d2", "K1", "Q1", "V1", "Lcom/tencent/qqnt/aio/anisticker/view/AniStickerLottieView;", "lottieView", "Y1", "Z1", "Landroid/view/ViewGroup;", "T1", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "context", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "P1", "()Landroid/widget/RelativeLayout;", "contentView", "D", "Lcom/tencent/qqnt/aio/anisticker/view/AniStickerLottieView;", "E", "Ljava/lang/String;", "randomLottieResultId", "Landroid/graphics/Rect;", "R1", "()Landroid/graphics/Rect;", "picBubblePadding", "<init>", "(Landroid/content/Context;)V", UserInfo.SEX_FEMALE, "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOAniStickerContentComponent extends BaseContentComponent<AniStickerMsgItem> {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy contentView;

    /* renamed from: D, reason: from kotlin metadata */
    private AniStickerLottieView lottieView;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private String randomLottieResultId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/anisticker/AIOAniStickerContentComponent$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.anisticker.AIOAniStickerContentComponent$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/anisticker/AIOAniStickerContentComponent$b", "Lcom/tencent/qqnt/aio/anisticker/view/a;", "", "localId", "", "resultId", "", "onAnimationStart", "onAnimationEnd", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements com.tencent.qqnt.aio.anisticker.view.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.aio.anisticker.view.a
        public void onAnimationEnd(int localId, @Nullable String resultId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, localId, (Object) resultId);
            } else {
                q.a("AIOAniStickerContentComponent", "random emo prepare-anim finish");
            }
        }

        @Override // com.tencent.qqnt.aio.anisticker.view.a
        public void onAnimationStart(int localId, @Nullable String resultId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, localId, (Object) resultId);
            } else {
                q.a("AIOAniStickerContentComponent", "random emo prepare-anim start");
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/anisticker/AIOAniStickerContentComponent$c", "Lcom/tencent/qqnt/aio/anisticker/view/a;", "", "localId", "", "resultId", "", "onAnimationStart", "onAnimationEnd", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class c implements com.tencent.qqnt.aio.anisticker.view.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AniStickerMsgItem f190661a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AIOAniStickerContentComponent f190662b;

        c(AniStickerMsgItem aniStickerMsgItem, AIOAniStickerContentComponent aIOAniStickerContentComponent) {
            this.f190661a = aniStickerMsgItem;
            this.f190662b = aIOAniStickerContentComponent;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aniStickerMsgItem, (Object) aIOAniStickerContentComponent);
            }
        }

        @Override // com.tencent.qqnt.aio.anisticker.view.a
        public void onAnimationEnd(int localId, @Nullable String resultId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, localId, (Object) resultId);
                return;
            }
            q.a("AIOAniStickerContentComponent", "random emo result-anim finish");
            this.f190661a.B2(true, 2);
            this.f190662b.Z1(this.f190661a);
        }

        @Override // com.tencent.qqnt.aio.anisticker.view.a
        public void onAnimationStart(int localId, @Nullable String resultId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, localId, (Object) resultId);
            } else {
                q.a("AIOAniStickerContentComponent", "random emo result-anim start");
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/anisticker/AIOAniStickerContentComponent$d", "Lcom/tencent/qqnt/aio/anisticker/view/a;", "", "localId", "", "resultId", "", "onAnimationStart", "onAnimationEnd", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class d implements com.tencent.qqnt.aio.anisticker.view.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AniStickerLottieView f190663a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AIOAniStickerContentComponent f190664b;

        d(AniStickerLottieView aniStickerLottieView, AIOAniStickerContentComponent aIOAniStickerContentComponent) {
            this.f190663a = aniStickerLottieView;
            this.f190664b = aIOAniStickerContentComponent;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aniStickerLottieView, (Object) aIOAniStickerContentComponent);
            }
        }

        @Override // com.tencent.qqnt.aio.anisticker.view.a
        public void onAnimationEnd(int localId, @Nullable String resultId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                this.f190664b.a2(this.f190663a);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, localId, (Object) resultId);
            }
        }

        @Override // com.tencent.qqnt.aio.anisticker.view.a
        public void onAnimationStart(int localId, @Nullable String resultId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, localId, (Object) resultId);
            } else {
                this.f190663a.bringToFront();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60034);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
            h.f348873a.e();
        }
    }

    public AIOAniStickerContentComponent(@NotNull Context context) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.context = context;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RelativeLayout>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.anisticker.AIOAniStickerContentComponent$contentView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOAniStickerContentComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RelativeLayout invoke() {
                RelativeLayout M1;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (RelativeLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                M1 = AIOAniStickerContentComponent.this.M1();
                return M1;
            }
        });
        this.contentView = lazy;
        this.randomLottieResultId = "";
    }

    private final void K1(AniStickerMsgItem msgItem) {
        int i3 = msgItem.getMsgRecord().chatType;
    }

    private final e.a L1(AniStickerMsgItem msgItem) {
        AniStickerLottieView aniStickerLottieView = this.lottieView;
        if (aniStickerLottieView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lottieView");
            aniStickerLottieView = null;
        }
        return new e.a(aniStickerLottieView).r(msgItem.n2()).w(msgItem.q2()).z(msgItem.s2()).s(S1()).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RelativeLayout M1() {
        RelativeLayout relativeLayout = new RelativeLayout(this.context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        Rect R1 = R1();
        layoutParams.setMargins(R1.left, R1.top, R1.right, R1.bottom);
        relativeLayout.setLayoutParams(layoutParams);
        AniStickerLottieView aniStickerLottieView = new AniStickerLottieView(this.context);
        aniStickerLottieView.setId(R.id.spv);
        aniStickerLottieView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        aniStickerLottieView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.anisticker.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AIOAniStickerContentComponent.N1(AIOAniStickerContentComponent.this, view);
            }
        });
        int Q1 = Q1();
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(Q1, Q1);
        layoutParams2.addRule(13);
        Unit unit = Unit.INSTANCE;
        relativeLayout.addView(aniStickerLottieView, layoutParams2);
        this.lottieView = aniStickerLottieView;
        return relativeLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N1(AIOAniStickerContentComponent this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.V1();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final RelativeLayout P1() {
        return (RelativeLayout) this.contentView.getValue();
    }

    private final int Q1() {
        return defpackage.a.f25157a.c();
    }

    private final Rect R1() {
        return new Rect(p.c(10), p.c(10), p.c(10), p.c(10));
    }

    private final int S1() {
        if (QQTheme.isNowThemeIsNight()) {
            return R.drawable.f162503o43;
        }
        return R.drawable.c0i;
    }

    private final ViewGroup T1() {
        Context mContext = getMContext();
        Intrinsics.checkNotNull(mContext, "null cannot be cast to non-null type android.app.Activity");
        View decorView = ((Activity) mContext).getWindow().getDecorView();
        Intrinsics.checkNotNull(decorView, "null cannot be cast to non-null type android.view.ViewGroup");
        return null;
    }

    private final boolean U1(List<Object> payloads) {
        boolean z16 = true;
        for (Object obj : payloads) {
            if (obj instanceof HashMap) {
                Map map = (Map) obj;
                Object obj2 = map.get(AIOMsgItemPayloadType.RANDOM_LOTTIE_RESULT);
                if (obj2 != null && (obj2 instanceof a.as)) {
                    f2(((a.as) obj2).a());
                }
                if (map.get(AIOMsgItemPayloadType.LOTTIE_RES_UPDATE_PAYLOAD) != null) {
                    e2();
                }
                Object obj3 = map.get(AIOMsgItemPayloadType.SEND_STATUS_PAYLOAD);
                if (obj3 != null && QLog.isColorLevel()) {
                    QLog.d("AIOAniStickerContentComponent", 2, "[handlePayloadData] sendStatus=", obj3);
                }
                z16 = false;
            }
        }
        return z16;
    }

    private final void V1() {
        if (!w1()) {
            return;
        }
        q.a("AIOAniStickerContentComponent", "[onClickView]");
        C1();
        if (q1().k2()) {
            sendIntent(new d.w(q1()));
        }
    }

    private final void W1() {
        if (!q1().y2()) {
            q1().z2();
        }
        e.f348849a.r(L1(q1()));
    }

    private final void X1() {
        K1(q1());
        if (!q1().y2()) {
            q1().z2();
        }
        if (d2()) {
            e.a L1 = L1(q1());
            q1().B2(true, 2);
            e.f348849a.m(L1);
            return;
        }
        if (q1().x2() && TextUtils.isEmpty(q1().q2())) {
            q.e("AIOAniStickerContentComponent", q1().getMsgRecord().msgId + " isRead but resultId isEmpty");
        }
        b bVar = new b();
        e.a L12 = L1(q1());
        e eVar = e.f348849a;
        AniStickerLottieView aniStickerLottieView = null;
        e.a q16 = L12.z(eVar.h(q1().n2(), null, null)).y(true).q(bVar);
        q1().B2(true, 1);
        eVar.n(q16);
        AniStickerMsgItem q17 = q1();
        AniStickerLottieView aniStickerLottieView2 = this.lottieView;
        if (aniStickerLottieView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lottieView");
        } else {
            aniStickerLottieView = aniStickerLottieView2;
        }
        Y1(q17, aniStickerLottieView);
        this.randomLottieResultId = q1().q2();
    }

    private final void Y1(AniStickerMsgItem msgItem, AniStickerLottieView lottieView) {
        if (lottieView != null && msgItem.u2() && !TextUtils.isEmpty(msgItem.q2())) {
            e.f348849a.d(L1(q1()).q(new c(msgItem, this)));
            return;
        }
        q.e("AIOAniStickerContentComponent", "[playResultAniSticker] invalid arguments " + msgItem.u2() + ", resultId=" + msgItem.q2());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z1(AniStickerMsgItem msgItem) {
        if (msgItem.u2() && !TextUtils.isEmpty(msgItem.t2())) {
            ViewGroup T1 = T1();
            if (T1 == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("AIOAniStickerContentComponent", 2, "playSurpriseAniSticker when afrootView==null");
                    return;
                }
                return;
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            AniStickerLottieView aniStickerLottieView = new AniStickerLottieView(getMContext());
            aniStickerLottieView.setLayoutParams(layoutParams);
            T1.addView(aniStickerLottieView);
            e.a a16 = L1(q1()).A(msgItem.t2()).q(new d(aniStickerLottieView, this)).a();
            q1().B2(true, 3);
            e.f348849a.q(a16);
            return;
        }
        q.e("AIOAniStickerContentComponent", "playSurpriseAniSticker when surpriseId Empty");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a2(View lottieView) {
        if (lottieView != null && lottieView.getParent() != null) {
            ViewParent parent = lottieView.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(lottieView);
        }
    }

    private final String c2() {
        FaceElement faceElement;
        MsgElement firstTypeElement = q1().getFirstTypeElement(6);
        if (firstTypeElement != null && (faceElement = firstTypeElement.faceElement) != null) {
            return faceElement.faceText;
        }
        return null;
    }

    private final boolean d2() {
        boolean z16;
        if (q1().isSelf() && q1().w2()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (q1().x2() && !z16 && !TextUtils.isEmpty(q1().q2())) {
            return true;
        }
        return false;
    }

    private final void e2() {
        if (!q1().u2()) {
            W1();
        } else {
            X1();
        }
    }

    private final void f2(String resultId) {
        QLog.i("AIOAniStickerContentComponent", 1, "updateRandomLottieResult  resultId:" + resultId);
        this.randomLottieResultId = resultId;
        if (!TextUtils.isEmpty(resultId)) {
            AniStickerMsgItem q16 = q1();
            AniStickerLottieView aniStickerLottieView = this.lottieView;
            if (aniStickerLottieView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lottieView");
                aniStickerLottieView = null;
            }
            Y1(q16, aniStickerLottieView);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent
    @NotNull
    /* renamed from: O1, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.aio.msglist.holder.component.anisticker.b createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.aio.msglist.holder.component.anisticker.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new com.tencent.mobileqq.aio.msglist.holder.component.anisticker.b();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mobileqq.aio.msglist.holder.component.c
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(position), msgItem, payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.b1(position, msgItem, payloads);
        q.a("AIOAniStickerContentComponent", "[bind] msgId=" + q1().getMsgId() + ", localId=" + q1().n2());
        if (U1(payloads)) {
            if (!q1().u2()) {
                W1();
            } else {
                X1();
            }
            if (q1().u2()) {
                str = "0X800BCCD";
            } else {
                str = "0X800BBD6";
            }
            String str2 = str;
            ((IReportControllerApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IReportControllerApi.class)).reportWith898(null, "", "", str2, str2, q1().r2(), 0, "", "", "", "");
        }
        AniStickerLottieView aniStickerLottieView = this.lottieView;
        if (aniStickerLottieView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lottieView");
            aniStickerLottieView = null;
        }
        aniStickerLottieView.setContentDescription(HardCodeUtil.qqStr(R.string.f170197yp0) + c2());
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    public View c1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return P1();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @Nullable
    public View e1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        AniStickerLottieView aniStickerLottieView = this.lottieView;
        if (aniStickerLottieView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lottieView");
            return null;
        }
        return aniStickerLottieView;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent
    @NotNull
    public List<com.tencent.qqnt.aio.menu.ui.d> s1() {
        List<com.tencent.qqnt.aio.menu.ui.d> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.qqnt.aio.menu.ui.d[]{new com.tencent.qqnt.aio.menu.d(getMContext(), q1()), new k(getMContext(), q1(), this, null, 8, null), new i(getMContext(), q1()), new af(getMContext(), q1(), this), new com.tencent.qqnt.aio.menu.h(getMContext(), q1(), this), new u(getMContext(), q1(), this), new ad(getMContext(), q1(), this), new ap(getMContext(), q1(), this), new aj(getMContext(), q1(), this)});
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 5, (Object) this);
    }
}

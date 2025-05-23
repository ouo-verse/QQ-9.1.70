package com.tencent.mobileqq.aio.msglist.holder.component.videochat;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.aj;
import com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent;
import com.tencent.mobileqq.aio.msglist.holder.component.videochat.AIOVideoChatResultView;
import com.tencent.mobileqq.aio.msglist.holder.skin.AIOBubbleSkinInfo;
import com.tencent.mobileqq.aio.msglist.holder.skin.padding.j;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqnt.aio.adapter.api.IAIOVideoResultApi;
import com.tencent.qqnt.aio.menu.h;
import com.tencent.qqnt.aio.menu.u;
import com.tencent.qqnt.aio.menu.ui.d;
import com.tencent.qqnt.kernel.nativeinterface.AVRecordElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001*B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u00a2\u0006\u0004\b'\u0010(J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J&\u0010\u0014\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0016R\u0017\u0010\u001d\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\"\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/videochat/AIOVideoResultContentComponent;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/BaseContentComponent;", "Lcom/tencent/mobileqq/aio/msg/aj;", "Lcom/tencent/qqnt/kernel/nativeinterface/AVRecordElement;", DTConstants.TAG.ELEMENT, "Landroid/graphics/drawable/Drawable;", "K1", "Landroid/widget/FrameLayout;", "I1", "", "L1", "Landroid/view/View;", "c1", "", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "", "payloads", "b1", "", "Lcom/tencent/qqnt/aio/menu/ui/d;", ICustomDataEditor.STRING_PARAM_1, "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "J1", "()Landroid/widget/FrameLayout;", "contentView", "Lcom/tencent/mobileqq/aio/msglist/holder/component/videochat/AIOVideoChatResultView;", "D", "Lcom/tencent/mobileqq/aio/msglist/holder/component/videochat/AIOVideoChatResultView;", "chatResultView", "<init>", "(Landroid/content/Context;)V", "E", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOVideoResultContentComponent extends BaseContentComponent<aj> {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy contentView;

    /* renamed from: D, reason: from kotlin metadata */
    private AIOVideoChatResultView chatResultView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/videochat/AIOVideoResultContentComponent$a;", "", "", "TAG", "Ljava/lang/String;", "", "VIDEO_RESULT_ELEMENT_ID", "I", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.videochat.AIOVideoResultContentComponent$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/videochat/AIOVideoResultContentComponent$b", "Lcom/tencent/mobileqq/aio/msglist/holder/component/videochat/AIOVideoChatResultView$a;", "", NodeProps.ON_CLICK, "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements AIOVideoChatResultView.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOVideoResultContentComponent.this);
            }
        }

        @Override // com.tencent.mobileqq.aio.msglist.holder.component.videochat.AIOVideoChatResultView.a
        public void onClick() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                AIOVideoResultContentComponent.this.L1();
                AIOVideoResultContentComponent.this.C1();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64044);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIOVideoResultContentComponent(@NotNull Context context) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.context = context;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<FrameLayout>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.videochat.AIOVideoResultContentComponent$contentView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOVideoResultContentComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FrameLayout invoke() {
                FrameLayout I1;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (FrameLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                I1 = AIOVideoResultContentComponent.this.I1();
                return I1;
            }
        });
        this.contentView = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FrameLayout I1() {
        FrameLayout frameLayout = new FrameLayout(this.context);
        AIOVideoChatResultView aIOVideoChatResultView = new AIOVideoChatResultView(this.context, new b());
        this.chatResultView = aIOVideoChatResultView;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        Unit unit = Unit.INSTANCE;
        frameLayout.addView(aIOVideoChatResultView, layoutParams);
        return frameLayout;
    }

    private final FrameLayout J1() {
        return (FrameLayout) this.contentView.getValue();
    }

    private final Drawable K1(AVRecordElement element) {
        com.tencent.qqnt.aio.videochat.a aVar = com.tencent.qqnt.aio.videochat.a.f352344a;
        Context context = this.context;
        int i3 = element.type;
        String str = element.text;
        Intrinsics.checkNotNullExpressionValue(str, "element.text");
        int b16 = aVar.b(context, i3, str, aVar.e(element.type), q1().isSelf(), q1().isSelf());
        if (b16 <= 0) {
            return null;
        }
        return ContextCompat.getDrawable(this.context, b16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L1() {
        if (w1()) {
            ((IAIOVideoResultApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOVideoResultApi.class)).onMessageClick(this.context, q1());
        } else {
            QLog.i("AIOVideoContentComponent", 1, "mCurrentMsgItem hasn't been initialized");
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent, com.tencent.mobileqq.aio.msglist.holder.component.c
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        AVRecordElement aVRecordElement;
        AIOBubbleSkinInfo x06;
        j jVar;
        boolean contains$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(position), msgItem, payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.b1(position, msgItem, payloads);
        MsgElement firstTypeElement = q1().getFirstTypeElement(21);
        if (firstTypeElement != null && (aVRecordElement = firstTypeElement.avRecordElement) != null && (x06 = q1().x0()) != null) {
            AIOBubbleSkinInfo.BackgroundImageInfo a16 = x06.a();
            if (a16 != null) {
                J1().setBackground(a16.a());
            }
            com.tencent.mobileqq.aio.msglist.holder.skin.padding.a b16 = x06.b();
            AIOVideoChatResultView aIOVideoChatResultView = null;
            if (b16 instanceof j) {
                jVar = (j) b16;
            } else {
                jVar = null;
            }
            if (jVar != null && (J1().getPaddingLeft() != jVar.c() || J1().getPaddingRight() != jVar.d() || J1().getPaddingTop() != jVar.e() || J1().getPaddingBottom() != jVar.b())) {
                J1().setPadding(jVar.c(), jVar.e(), jVar.d(), jVar.b());
            }
            AIOVideoChatResultView aIOVideoChatResultView2 = this.chatResultView;
            if (aIOVideoChatResultView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chatResultView");
                aIOVideoChatResultView2 = null;
            }
            String str = aVRecordElement.text;
            Intrinsics.checkNotNullExpressionValue(str, "it.text");
            aIOVideoChatResultView2.setContent(str, K1(aVRecordElement));
            AIOBubbleSkinInfo.c e16 = x06.e();
            if (e16 != null) {
                String str2 = aVRecordElement.text;
                Intrinsics.checkNotNullExpressionValue(str2, "it.text");
                String string = this.context.getString(R.string.id5);
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.te\u2026msg_dont_respond_request)");
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) str2, (CharSequence) string, false, 2, (Object) null);
                if (contains$default) {
                    ColorStateList colorStateList = ResourcesCompat.getColorStateList(this.context.getResources(), R.color.qui_common_feedback_error, null);
                    AIOVideoChatResultView aIOVideoChatResultView3 = this.chatResultView;
                    if (aIOVideoChatResultView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("chatResultView");
                    } else {
                        aIOVideoChatResultView = aIOVideoChatResultView3;
                    }
                    aIOVideoChatResultView.setTextColor(colorStateList, e16.d());
                    return;
                }
                AIOVideoChatResultView aIOVideoChatResultView4 = this.chatResultView;
                if (aIOVideoChatResultView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chatResultView");
                } else {
                    aIOVideoChatResultView = aIOVideoChatResultView4;
                }
                aIOVideoChatResultView.setTextColor(e16.b(), e16.d());
            }
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    public View c1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return J1();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.BaseContentComponent
    @NotNull
    public List<d> s1() {
        List<d> mutableListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new h(getMContext(), q1(), this), new u(getMContext(), q1(), this), new com.tencent.qqnt.aio.menu.aj(getMContext(), q1(), this));
            return mutableListOf;
        }
        return (List) iPatchRedirector.redirect((short) 5, (Object) this);
    }
}

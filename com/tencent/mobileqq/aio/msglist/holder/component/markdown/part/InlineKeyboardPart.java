package com.tencent.mobileqq.aio.msglist.holder.component.markdown.part;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.android.androidbypass.enhance.inlinekeyboard.view.InlineBoardLayoutManager;
import com.tencent.android.androidbypass.enhance.inlinekeyboard.view.InlineBtnStyleSheet;
import com.tencent.android.androidbypass.enhance.inlinekeyboard.view.InlineBtnView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.markdown.MarkdownMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.markdown.a;
import com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b;
import com.tencent.mobileqq.aio.msglist.holder.component.markdown.part.InlineKeyboardPart$mInlineBoardDispatchContext$2;
import com.tencent.mobileqq.aio.utils.b;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.base.report.ProfileCardBlacklistReportConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqnt.aio.markdown.api.IMarkdownFeatureCompatApi;
import com.tencent.qqnt.kernel.nativeinterface.InlineKeyboardButton;
import com.tencent.qqnt.kernel.nativeinterface.InlineKeyboardElement;
import com.tencent.qqnt.kernel.nativeinterface.InlineKeyboardRow;
import com.tencent.qqnt.rich.e;
import com.tencent.qqnt.rich.j;
import com.tencent.qqnt.rich.k;
import com.tencent.qqnt.rich.l;
import com.tencent.qqnt.rich.m;
import com.tencent.qqnt.robot.api.IRobotServiceApi;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u000205\u0018\u0000 C2\u00020\u0001:\u0001\u001eB'\u0012\u0006\u0010:\u001a\u000209\u0012\u0006\u0010<\u001a\u00020;\u0012\u0006\u0010>\u001a\u00020=\u0012\u0006\u0010@\u001a\u00020?\u00a2\u0006\u0004\bA\u0010BJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J,\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\u001a\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u0010H\u0002J\u0018\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J4\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016j\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0018`\u00192\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0018\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u001a\u0010!\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u00172\b\u0010 \u001a\u0004\u0018\u00010\u0018H\u0016R\u0016\u0010$\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010%R'\u0010/\u001a\u0012\u0012\u0004\u0012\u00020(\u0012\b\u0012\u00060)j\u0002`*0'8\u0006\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001b\u00104\u001a\u0002008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b+\u00103R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107\u00a8\u0006D"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/part/InlineKeyboardPart;", "Lcom/tencent/qqnt/rich/part/a;", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;", "btnModel", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBtnStyleSheet;", "j", "Landroidx/constraintlayout/widget/ConstraintLayout;", ParseCommon.CONTAINER, "Lcom/tencent/qqnt/kernel/nativeinterface/InlineKeyboardElement;", "inlineKeyboardElement", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/MarkdownMsgItem;", "msgItem", "", "i", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/InlineKeyboardRow;", "Lkotlin/collections/ArrayList;", "buttonRows", "o", DomainData.DOMAIN_NAME, "Lcom/tencent/qqnt/kernel/nativeinterface/InlineKeyboardButton;", "inlineKeyboardButton", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "k", "Lcom/tencent/qqnt/rich/j;", "richData", "", "a", "action", "objects", "r0", h.F, "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/MarkdownMsgItem;", "mCurrentMsgItem", "Z", "supportVas", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBoardLayoutManager;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/compat/b;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/utils/InlineBtnPayload;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBoardLayoutManager;", "l", "()Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBoardLayoutManager;", "inlineBoardLayoutManager", "com/tencent/mobileqq/aio/msglist/holder/component/markdown/part/InlineKeyboardPart$mInlineBoardDispatchContext$2$a", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/part/InlineKeyboardPart$mInlineBoardDispatchContext$2$a;", "mInlineBoardDispatchContext", "com/tencent/mobileqq/aio/msglist/holder/component/markdown/part/InlineKeyboardPart$c", "D", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/part/InlineKeyboardPart$c;", "mInlineKeyboardClickListener", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/rich/m;", "helper", "Lcom/tencent/qqnt/rich/k;", "extParam", "Lcom/tencent/qqnt/rich/l;", "richFactory", "<init>", "(Landroid/content/Context;Lcom/tencent/qqnt/rich/m;Lcom/tencent/qqnt/rich/k;Lcom/tencent/qqnt/rich/l;)V", "E", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class InlineKeyboardPart extends com.tencent.qqnt.rich.part.a {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy mInlineBoardDispatchContext;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final c mInlineKeyboardClickListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private MarkdownMsgItem mCurrentMsgItem;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean supportVas;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final InlineBoardLayoutManager<com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b, AIOMsgItem> inlineBoardLayoutManager;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/part/InlineKeyboardPart$a;", "", "", "CHAR_ELLIPSIS", "Ljava/lang/String;", "EM_BAS_DEVELOPER_MESSAGE_FUNCTION", "TAG", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.markdown.part.InlineKeyboardPart$a, reason: from kotlin metadata */
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

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/markdown/part/InlineKeyboardPart$b", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBtnStyleSheet;", "Landroid/content/res/ColorStateList;", "e", "", h.F, "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements InlineBtnStyleSheet {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.android.androidbypass.enhance.inlinekeyboard.view.InlineBtnStyleSheet
        public /* synthetic */ int a() {
            return com.tencent.android.androidbypass.enhance.inlinekeyboard.view.b.h(this);
        }

        @Override // com.tencent.android.androidbypass.enhance.inlinekeyboard.view.InlineBtnStyleSheet
        public /* synthetic */ Drawable b() {
            return com.tencent.android.androidbypass.enhance.inlinekeyboard.view.b.a(this);
        }

        @Override // com.tencent.android.androidbypass.enhance.inlinekeyboard.view.InlineBtnStyleSheet
        public /* synthetic */ Drawable c() {
            return com.tencent.android.androidbypass.enhance.inlinekeyboard.view.b.g(this);
        }

        @Override // com.tencent.android.androidbypass.enhance.inlinekeyboard.view.InlineBtnStyleSheet
        public /* synthetic */ int d() {
            return com.tencent.android.androidbypass.enhance.inlinekeyboard.view.b.c(this);
        }

        @Override // com.tencent.android.androidbypass.enhance.inlinekeyboard.view.InlineBtnStyleSheet
        @NotNull
        public ColorStateList e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ColorStateList) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            ColorStateList valueOf = ColorStateList.valueOf(-16777216);
            Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(Color.BLACK)");
            return valueOf;
        }

        @Override // com.tencent.android.androidbypass.enhance.inlinekeyboard.view.InlineBtnStyleSheet
        public /* synthetic */ Drawable f() {
            return com.tencent.android.androidbypass.enhance.inlinekeyboard.view.b.d(this);
        }

        @Override // com.tencent.android.androidbypass.enhance.inlinekeyboard.view.InlineBtnStyleSheet
        public /* synthetic */ Drawable g() {
            return com.tencent.android.androidbypass.enhance.inlinekeyboard.view.b.f(this);
        }

        @Override // com.tencent.android.androidbypass.enhance.inlinekeyboard.view.InlineBtnStyleSheet
        public /* synthetic */ int getIconRes() {
            return com.tencent.android.androidbypass.enhance.inlinekeyboard.view.b.e(this);
        }

        @Override // com.tencent.android.androidbypass.enhance.inlinekeyboard.view.InlineBtnStyleSheet
        public /* synthetic */ InlineBtnStyleSheet.BtnType getType() {
            return com.tencent.android.androidbypass.enhance.inlinekeyboard.view.b.i(this);
        }

        @Override // com.tencent.android.androidbypass.enhance.inlinekeyboard.view.InlineBtnStyleSheet
        public int h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return R.drawable.skin_background;
        }
    }

    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0016\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0001j\u0002`\u0005J@\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00022\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00072\u0006\u0010\n\u001a\u00020\t2\u000e\u0010\u000b\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u0004H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/markdown/part/InlineKeyboardPart$c", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/clickdispatcher/b;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/compat/b;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/utils/InlineBtnPayload;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/utils/AIOInlineBoardClickHandler;", "ctx", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBtnView;", "btnView", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;", "btnModel", "payload", "", "b", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class c implements com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.b<com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b, AIOMsgItem> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ m f191056a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ InlineKeyboardPart f191057b;

        c(m mVar, InlineKeyboardPart inlineKeyboardPart) {
            this.f191056a = mVar;
            this.f191057b = inlineKeyboardPart;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) mVar, (Object) inlineKeyboardPart);
            }
        }

        @Override // com.tencent.android.androidbypass.enhance.inlinekeyboard.clickdispatcher.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b ctx, @NotNull InlineBtnView<com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b, AIOMsgItem> btnView, @NotNull com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a btnModel, @Nullable AIOMsgItem payload) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, ctx, btnView, btnModel, payload);
                return;
            }
            Intrinsics.checkNotNullParameter(ctx, "ctx");
            Intrinsics.checkNotNullParameter(btnView, "btnView");
            Intrinsics.checkNotNullParameter(btnModel, "btnModel");
            this.f191056a.d("send_external_message", new a.d(ctx, btnView, btnModel, payload));
            InlineKeyboardPart inlineKeyboardPart = this.f191057b;
            MarkdownMsgItem markdownMsgItem = inlineKeyboardPart.mCurrentMsgItem;
            if (markdownMsgItem == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCurrentMsgItem");
                markdownMsgItem = null;
            }
            inlineKeyboardPart.n(markdownMsgItem, btnModel);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61499);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InlineKeyboardPart(@NotNull Context context, @NotNull m helper, @NotNull k extParam, @NotNull l richFactory) {
        super(context, helper, extParam, richFactory);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(helper, "helper");
        Intrinsics.checkNotNullParameter(extParam, "extParam");
        Intrinsics.checkNotNullParameter(richFactory, "richFactory");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, helper, extParam, richFactory);
            return;
        }
        this.supportVas = true;
        this.inlineBoardLayoutManager = new InlineBoardLayoutManager<>(new InlineKeyboardPart$inlineBoardLayoutManager$1(this));
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<InlineKeyboardPart$mInlineBoardDispatchContext$2.a>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.markdown.part.InlineKeyboardPart$mInlineBoardDispatchContext$2
            static IPatchRedirector $redirector_;

            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/markdown/part/InlineKeyboardPart$mInlineBoardDispatchContext$2$a", "", "", "b", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/compat/b;", "a", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/compat/b;", "()Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/compat/b;", "mDispatchContext", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes11.dex */
            public static final class a {
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name and from kotlin metadata */
                @NotNull
                private final b mDispatchContext;

                @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u0005\u001a\u0010\u0012\u0002\b\u0003\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002H\u0016J \u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00062\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u001c\u0010\u0010\u001a\u00020\u000f2\n\u0010\f\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u001c\u0010\u0011\u001a\u00020\t2\n\u0010\f\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016\u00a8\u0006\u0012"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/markdown/part/InlineKeyboardPart$mInlineBoardDispatchContext$2$a$a", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/compat/a;", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/view/InlineBtnView;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/utils/InlineBtnPayload;", "btnView", "", "a", "btnKey", "", "b", "c", "payload", "Lcom/tencent/android/androidbypass/enhance/inlinekeyboard/model/a;", "btnModel", "", "e", "d", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
                /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.markdown.part.InlineKeyboardPart$mInlineBoardDispatchContext$2$a$a, reason: collision with other inner class name */
                /* loaded from: classes11.dex */
                public static final class C7306a implements com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.a {
                    static IPatchRedirector $redirector_;

                    /* renamed from: a, reason: collision with root package name */
                    final /* synthetic */ InlineKeyboardPart f191059a;

                    C7306a(InlineKeyboardPart inlineKeyboardPart) {
                        this.f191059a = inlineKeyboardPart;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) inlineKeyboardPart);
                        }
                    }

                    @Override // com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.a
                    @NotNull
                    public String a(@NotNull InlineBtnView<?, AIOMsgItem> btnView) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) btnView);
                        }
                        Intrinsics.checkNotNullParameter(btnView, "btnView");
                        return com.tencent.mobileqq.aio.msglist.holder.component.markdown.utils.a.f191110a.c(btnView.G0(), btnView.F0());
                    }

                    @Override // com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.a
                    public void b(@NotNull String btnKey, @NotNull InlineBtnView<?, ?> btnView) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                            iPatchRedirector.redirect((short) 3, (Object) this, (Object) btnKey, (Object) btnView);
                            return;
                        }
                        Intrinsics.checkNotNullParameter(btnKey, "btnKey");
                        Intrinsics.checkNotNullParameter(btnView, "btnView");
                        com.tencent.mobileqq.aio.msglist.holder.component.markdown.utils.a aVar = com.tencent.mobileqq.aio.msglist.holder.component.markdown.utils.a.f191110a;
                        aVar.b().put(btnKey, new WeakReference<>(btnView));
                        com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a[][] f16 = this.f191059a.l().f();
                        MarkdownMsgItem markdownMsgItem = this.f191059a.mCurrentMsgItem;
                        if (markdownMsgItem == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mCurrentMsgItem");
                            markdownMsgItem = null;
                        }
                        aVar.g(f16, markdownMsgItem);
                        this.f191059a.l().i();
                    }

                    @Override // com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.a
                    public void c(@NotNull String btnKey) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                            iPatchRedirector.redirect((short) 4, (Object) this, (Object) btnKey);
                            return;
                        }
                        Intrinsics.checkNotNullParameter(btnKey, "btnKey");
                        com.tencent.mobileqq.aio.msglist.holder.component.markdown.utils.a aVar = com.tencent.mobileqq.aio.msglist.holder.component.markdown.utils.a.f191110a;
                        WeakReference<InlineBtnView<?, ?>> remove = aVar.b().remove(btnKey);
                        if (remove != null && remove.get() != null) {
                            InlineKeyboardPart inlineKeyboardPart = this.f191059a;
                            com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a[][] f16 = inlineKeyboardPart.l().f();
                            MarkdownMsgItem markdownMsgItem = inlineKeyboardPart.mCurrentMsgItem;
                            if (markdownMsgItem == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mCurrentMsgItem");
                                markdownMsgItem = null;
                            }
                            aVar.g(f16, markdownMsgItem);
                            inlineKeyboardPart.l().i();
                        }
                    }

                    @Override // com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.a
                    public void d(@NotNull AIOMsgItem payload, @NotNull com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a btnModel) {
                        InlineKeyboardButton inlineKeyboardButton;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                            iPatchRedirector.redirect((short) 6, (Object) this, (Object) payload, (Object) btnModel);
                            return;
                        }
                        Intrinsics.checkNotNullParameter(payload, "payload");
                        Intrinsics.checkNotNullParameter(btnModel, "btnModel");
                        Object e16 = btnModel.e();
                        MarkdownMsgItem markdownMsgItem = null;
                        if (e16 instanceof InlineKeyboardButton) {
                            inlineKeyboardButton = (InlineKeyboardButton) e16;
                        } else {
                            inlineKeyboardButton = null;
                        }
                        if (inlineKeyboardButton == null) {
                            return;
                        }
                        long msgId = payload.getMsgId();
                        MarkdownMsgItem markdownMsgItem2 = this.f191059a.mCurrentMsgItem;
                        if (markdownMsgItem2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mCurrentMsgItem");
                            markdownMsgItem2 = null;
                        }
                        if (msgId == markdownMsgItem2.getMsgId()) {
                            com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a[][] f16 = this.f191059a.l().f();
                            com.tencent.mobileqq.aio.msglist.holder.component.markdown.utils.a aVar = com.tencent.mobileqq.aio.msglist.holder.component.markdown.utils.a.f191110a;
                            String str = inlineKeyboardButton.f359191id;
                            Intrinsics.checkNotNullExpressionValue(str, "selectButton.id");
                            String str2 = inlineKeyboardButton.label;
                            Intrinsics.checkNotNullExpressionValue(str2, "selectButton.label");
                            String str3 = inlineKeyboardButton.groupId;
                            Intrinsics.checkNotNullExpressionValue(str3, "selectButton.groupId");
                            aVar.h(f16, str, str2, str3);
                            this.f191059a.l().i();
                            MarkdownMsgItem markdownMsgItem3 = this.f191059a.mCurrentMsgItem;
                            if (markdownMsgItem3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mCurrentMsgItem");
                            } else {
                                markdownMsgItem = markdownMsgItem3;
                            }
                            String str4 = inlineKeyboardButton.f359191id;
                            Intrinsics.checkNotNullExpressionValue(str4, "selectButton.id");
                            String str5 = inlineKeyboardButton.groupId;
                            Intrinsics.checkNotNullExpressionValue(str5, "selectButton.groupId");
                            markdownMsgItem.N2(str4, str5);
                            return;
                        }
                        if (payload instanceof MarkdownMsgItem) {
                            markdownMsgItem = (MarkdownMsgItem) payload;
                        }
                        if (markdownMsgItem != null) {
                            String str6 = inlineKeyboardButton.f359191id;
                            Intrinsics.checkNotNullExpressionValue(str6, "selectButton.id");
                            String str7 = inlineKeyboardButton.groupId;
                            Intrinsics.checkNotNullExpressionValue(str7, "selectButton.groupId");
                            markdownMsgItem.N2(str6, str7);
                        }
                    }

                    @Override // com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.a
                    public boolean e(@NotNull AIOMsgItem payload, @NotNull com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a btnModel) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) payload, (Object) btnModel)).booleanValue();
                        }
                        Intrinsics.checkNotNullParameter(payload, "payload");
                        Intrinsics.checkNotNullParameter(btnModel, "btnModel");
                        com.tencent.mobileqq.aio.msglist.holder.component.markdown.utils.a aVar = com.tencent.mobileqq.aio.msglist.holder.component.markdown.utils.a.f191110a;
                        return aVar.b().containsKey(aVar.c(payload, btnModel));
                    }
                }

                a(InlineKeyboardPart inlineKeyboardPart) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) inlineKeyboardPart);
                        return;
                    }
                    b bVar = new b(null, null, 3, null);
                    this.mDispatchContext = bVar;
                    bVar.d(new C7306a(inlineKeyboardPart));
                }

                @NotNull
                public final b a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (b) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    return this.mDispatchContext;
                }

                public final void b() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this);
                    } else {
                        this.mDispatchContext.c(null);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) InlineKeyboardPart.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new a(InlineKeyboardPart.this) : (a) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.mInlineBoardDispatchContext = lazy;
        this.mInlineKeyboardClickListener = new c(helper, this);
    }

    private final void i(ConstraintLayout container, InlineKeyboardElement inlineKeyboardElement, MarkdownMsgItem msgItem) {
        if (inlineKeyboardElement == null) {
            this.inlineBoardLayoutManager.d();
            return;
        }
        com.tencent.mobileqq.aio.msglist.holder.component.markdown.utils.a aVar = com.tencent.mobileqq.aio.msglist.holder.component.markdown.utils.a.f191110a;
        com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a[][] f16 = aVar.f(inlineKeyboardElement);
        aVar.g(f16, msgItem);
        this.inlineBoardLayoutManager.h(m().a(), msgItem, f16, this.mInlineKeyboardClickListener);
        InlineBoardLayoutManager<com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b, AIOMsgItem> inlineBoardLayoutManager = this.inlineBoardLayoutManager;
        MarkdownMsgItem markdownMsgItem = this.mCurrentMsgItem;
        if (markdownMsgItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCurrentMsgItem");
            markdownMsgItem = null;
        }
        inlineBoardLayoutManager.c(markdownMsgItem.G2(), Integer.valueOf(c().b()), container);
        o(msgItem, inlineKeyboardElement.rows);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InlineBtnStyleSheet j(com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a btnModel) {
        InlineBtnStyleSheet inlineBtnStyleSheet;
        Object inlineButtonStyleSheet = ((IMarkdownFeatureCompatApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IMarkdownFeatureCompatApi.class)).getInlineButtonStyleSheet(b(), btnModel, this.supportVas);
        if (inlineButtonStyleSheet instanceof InlineBtnStyleSheet) {
            inlineBtnStyleSheet = (InlineBtnStyleSheet) inlineButtonStyleSheet;
        } else {
            inlineBtnStyleSheet = null;
        }
        if (inlineBtnStyleSheet == null) {
            return new b();
        }
        return inlineBtnStyleSheet;
    }

    private final HashMap<String, Object> k(MarkdownMsgItem msgItem, InlineKeyboardButton inlineKeyboardButton) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("msg_id", Long.valueOf(msgItem.getMsgId()));
        hashMap.put("bot_uin", Long.valueOf(msgItem.getMsgRecord().senderUin));
        hashMap.put("ActionType", Integer.valueOf(inlineKeyboardButton.type));
        String str = inlineKeyboardButton.data;
        Intrinsics.checkNotNullExpressionValue(str, "inlineKeyboardButton.data");
        hashMap.put("data", str);
        String str2 = inlineKeyboardButton.label;
        Intrinsics.checkNotNullExpressionValue(str2, "inlineKeyboardButton.label");
        hashMap.put(ProfileCardBlacklistReportConst.ELEM_PARAM_BUTTON_TEXT_CONTENT, str2);
        return hashMap;
    }

    private final InlineKeyboardPart$mInlineBoardDispatchContext$2.a m() {
        return (InlineKeyboardPart$mInlineBoardDispatchContext$2.a) this.mInlineBoardDispatchContext.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(MarkdownMsgItem msgItem, com.tencent.android.androidbypass.enhance.inlinekeyboard.model.a btnModel) {
        InlineKeyboardButton inlineKeyboardButton;
        Object e16 = btnModel.e();
        if (e16 instanceof InlineKeyboardButton) {
            inlineKeyboardButton = (InlineKeyboardButton) e16;
        } else {
            inlineKeyboardButton = null;
        }
        if (inlineKeyboardButton != null) {
            HashMap<String, Object> k3 = k(msgItem, inlineKeyboardButton);
            com.tencent.mobileqq.aio.utils.b.l("em_bas_developer_message_function", k3);
            if (QLog.isDevelopLevel()) {
                QLog.i("InlineKeyboardPart", 4, "[reportClick]: param is " + k3);
            }
        }
    }

    private final void o(final MarkdownMsgItem msgItem, final ArrayList<InlineKeyboardRow> buttonRows) {
        ThreadManager.execute(new Callable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.markdown.part.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Unit p16;
                p16 = InlineKeyboardPart.p(buttonRows, this, msgItem);
                return p16;
            }
        }, 128);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(ArrayList arrayList, InlineKeyboardPart this$0, MarkdownMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ArrayList<InlineKeyboardButton> buttons = ((InlineKeyboardRow) it.next()).buttons;
                if (buttons != null) {
                    Intrinsics.checkNotNullExpressionValue(buttons, "buttons");
                    for (InlineKeyboardButton it5 : buttons) {
                        b.a g16 = com.tencent.mobileqq.aio.utils.b.f194119a.g();
                        if (g16 == null) {
                            return Unit.INSTANCE;
                        }
                        Map<String, Object> a16 = g16.e().a();
                        a16.put("qq_eid", "em_bas_developer_message_function");
                        Intrinsics.checkNotNullExpressionValue(it5, "it");
                        a16.putAll(this$0.k(msgItem, it5));
                        VideoReport.reportEvent("qq_imp", a16);
                    }
                }
            }
        }
        return Unit.INSTANCE;
    }

    @Override // com.tencent.qqnt.rich.part.a
    public boolean a(@NotNull ConstraintLayout container, @NotNull j richData) {
        MarkdownMsgItem markdownMsgItem;
        Unit unit;
        com.tencent.aio.api.runtime.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) container, (Object) richData)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(richData, "richData");
        e b16 = richData.b();
        if (b16 != null) {
            Object a16 = b16.a();
            MarkdownMsgItem markdownMsgItem2 = null;
            if (a16 instanceof MarkdownMsgItem) {
                markdownMsgItem = (MarkdownMsgItem) a16;
            } else {
                markdownMsgItem = null;
            }
            if (markdownMsgItem != null) {
                this.mCurrentMsgItem = markdownMsgItem;
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                return false;
            }
            Object b17 = b16.b();
            if (b17 instanceof com.tencent.aio.api.runtime.a) {
                aVar = (com.tencent.aio.api.runtime.a) b17;
            } else {
                aVar = null;
            }
            if (aVar != null && !com.tencent.mobileqq.aio.a.a(aVar)) {
                m().a().c(aVar);
                int e16 = aVar.g().r().c().e();
                Intrinsics.checkNotNullExpressionValue(aVar.g(), "aioContext.aioParam");
                this.supportVas = !((IRobotServiceApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IRobotServiceApi.class)).isRobotAIO(su3.c.b(r7), Integer.valueOf(e16));
                MarkdownMsgItem markdownMsgItem3 = this.mCurrentMsgItem;
                if (markdownMsgItem3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCurrentMsgItem");
                    markdownMsgItem3 = null;
                }
                InlineKeyboardElement p26 = markdownMsgItem3.p2();
                MarkdownMsgItem markdownMsgItem4 = this.mCurrentMsgItem;
                if (markdownMsgItem4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCurrentMsgItem");
                } else {
                    markdownMsgItem2 = markdownMsgItem4;
                }
                i(container, p26, markdownMsgItem2);
            } else {
                this.inlineBoardLayoutManager.d();
            }
        }
        return false;
    }

    @NotNull
    public final InlineBoardLayoutManager<com.tencent.mobileqq.aio.msglist.holder.component.markdown.compat.b, AIOMsgItem> l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (InlineBoardLayoutManager) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.inlineBoardLayoutManager;
    }

    @Override // com.tencent.qqnt.rich.part.a, com.tencent.qqnt.rich.a
    public void r0(@NotNull String action, @Nullable Object objects) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) action, objects);
            return;
        }
        Intrinsics.checkNotNullParameter(action, "action");
        if (Intrinsics.areEqual(action, "rich_destory")) {
            m().b();
        }
    }
}

package com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor;

import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewTreeObserver;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.NativeDetailInputWindowAdorn;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.NativeDetailInputWindowDirector;
import com.tencent.mobileqq.guild.feed.widget.comment.CommentEditText;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\"\u0018\u0000 +2\u00060\u0001j\u0002`\u0002:\u0001,B\u0013\u0012\n\u0010(\u001a\u00060&j\u0002`'\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u001a\u0010\u000f\u001a\u00020\u000e2\u0010\u0010\r\u001a\f\u0012\u0004\u0012\u00020\u000b0\nj\u0002`\fH\u0016J\u0006\u0010\u0010\u001a\u00020\u0005J\b\u0010\u0011\u001a\u00020\u000eH\u0016R\u0016\u0010\u0014\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u001b\u0010\u001b\u001a\u00020\u00038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/actor/NewLineCompatActor;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$a;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputActor;", "Landroid/text/TextWatcher;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "p", "r", "", DomainData.DOMAIN_NAME, "Lxk1/d;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowAdorn;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindow;", "inputWindow", "", "e", ReportConstant.COSTREPORT_PREFIX, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "f", "Z", "curIsLongText", tl.h.F, "curShowingPrePic", "i", "Lkotlin/Lazy;", "o", "()Landroid/text/TextWatcher;", "textWatcher", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View$OnLayoutChangeListener;", "layoutChangeListener", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/Boolean;", "shouldCancelDraw", "com/tencent/mobileqq/guild/feed/nativedetail/bottom/input/actor/NewLineCompatActor$c", "D", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/actor/NewLineCompatActor$c;", "preDrawListener", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$b;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputAttachInfo;", "attachInfo", "<init>", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$b;)V", "E", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class NewLineCompatActor extends NativeDetailInputWindowDirector.a {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Boolean shouldCancelDraw;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final c preDrawListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean curIsLongText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean curShowingPrePic;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy textWatcher;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View.OnLayoutChangeListener layoutChangeListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/bottom/input/actor/NewLineCompatActor$c", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "", "onPreDraw", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements ViewTreeObserver.OnPreDrawListener {
        c() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            boolean z16;
            Boolean bool = NewLineCompatActor.this.shouldCancelDraw;
            NewLineCompatActor.this.shouldCancelDraw = null;
            if (bool != null) {
                z16 = bool.booleanValue();
            } else {
                z16 = false;
            }
            boolean z17 = !z16;
            ((NativeDetailInputWindowAdorn) NewLineCompatActor.this.b().X()).v().getMRv().getViewTreeObserver().removeOnPreDrawListener(this);
            return z17;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewLineCompatActor(@NotNull NativeDetailInputWindowDirector.b attachInfo) {
        super(attachInfo);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(attachInfo, "attachInfo");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TextWatcher>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor.NewLineCompatActor$textWatcher$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextWatcher invoke() {
                TextWatcher m3;
                m3 = NewLineCompatActor.this.m();
                return m3;
            }
        });
        this.textWatcher = lazy;
        this.layoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor.k
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                NewLineCompatActor.q(NewLineCompatActor.this, view, i3, i16, i17, i18, i19, i26, i27, i28);
            }
        };
        this.preDrawListener = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextWatcher m() {
        return new b();
    }

    private final float n() {
        CommentEditText a16 = b().X().v().a();
        return (((a16.getMeasuredWidth() - a16.getPaddingLeft()) - a16.getPaddingRight()) - b().X().v().getCtrlLayout().getMeasuredWidth()) + 0.0f;
    }

    private final TextWatcher o() {
        return (TextWatcher) this.textWatcher.getValue();
    }

    private final boolean p() {
        Layout layout = b().X().v().a().getLayout();
        if (layout == null) {
            return false;
        }
        if (layout.getLineWidth(0) <= n() && layout.getLineCount() <= 1) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(NewLineCompatActor this$0, View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Boolean valueOf = Boolean.valueOf(this$0.s());
        this$0.shouldCancelDraw = valueOf;
        if (Intrinsics.areEqual(valueOf, Boolean.TRUE)) {
            this$0.b().X().v().getMRv().getViewTreeObserver().addOnPreDrawListener(this$0.preDrawListener);
        }
    }

    private final boolean r() {
        if (getAttachInfo().i().getValue() == null || !(!r0.isEmpty())) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.NativeDetailInputWindowDirector.a
    public void e(@NotNull xk1.d<NativeDetailInputWindowAdorn> inputWindow) {
        Intrinsics.checkNotNullParameter(inputWindow, "inputWindow");
        super.e(inputWindow);
        inputWindow.X().v().a().addTextChangedListener(o());
        inputWindow.X().v().getCtrlLayout().addOnLayoutChangeListener(this.layoutChangeListener);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.NativeDetailInputWindowDirector.a
    public void onDestroy() {
        super.onDestroy();
        yk1.a v3 = b().X().v();
        v3.a().removeTextChangedListener(o());
        v3.getCtrlLayout().removeOnLayoutChangeListener(this.layoutChangeListener);
        v3.getMRv().getViewTreeObserver().removeOnPreDrawListener(this.preDrawListener);
    }

    public final boolean s() {
        boolean p16 = p();
        boolean r16 = r();
        QLog.i("NewLineCompatActor", 4, "triggerUpdateStyleIfNeed curIsLongText=" + this.curIsLongText + " longText=" + p16 + " curShowingPrePic=" + this.curShowingPrePic + " picPreShowing=" + r16);
        if (this.curIsLongText == p16 && this.curShowingPrePic == r16) {
            QLog.i("NewLineCompatActor", 4, "changeTextInputStyle same Style");
            return false;
        }
        this.curIsLongText = p16;
        this.curShowingPrePic = r16;
        b().X().v().getInputLayout().a(p16, r16);
        EditTextInputActor editTextInputActor = (EditTextInputActor) b().getRouter().b(EditTextInputActor.class);
        if (editTextInputActor != null) {
            editTextInputActor.o();
            return true;
        }
        return true;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\f\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\u000e\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\rH\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/bottom/input/actor/NewLineCompatActor$b", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "text", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@NotNull CharSequence s16, int start, int count, int after) {
            Intrinsics.checkNotNullParameter(s16, "s");
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable text) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence text, int start, int before, int count) {
        }
    }
}

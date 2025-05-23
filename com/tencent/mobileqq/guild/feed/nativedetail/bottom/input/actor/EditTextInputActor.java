package com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.NativeDetailInputWindowAdorn;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.NativeDetailInputWindowDirector;
import com.tencent.mobileqq.guild.feed.widget.comment.CommentEditText;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.richframework.text.rich.parser.RichTextAtParser;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 !2\u00060\u0001j\u0002`\u0002:\u0001\"B\u0013\u0012\n\u0010\u001e\u001a\u00060\u001cj\u0002`\u001d\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u001a\u0010\u000e\u001a\u00020\b2\u0010\u0010\r\u001a\f\u0012\u0004\u0012\u00020\u000b0\nj\u0002`\fH\u0016J\b\u0010\u000f\u001a\u00020\bH\u0016J\u0006\u0010\u0010\u001a\u00020\bJ\u0006\u0010\u0011\u001a\u00020\bJ\b\u0010\u0012\u001a\u00020\bH\u0016R\u001b\u0010\u0017\u001a\u00020\u00038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/actor/EditTextInputActor;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$a;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputActor;", "Landroid/text/TextWatcher;", "k", "", "current", "maxLength", "", DomainData.DOMAIN_NAME, "Lxk1/d;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowAdorn;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindow;", "inputWindow", "e", "d", "j", "o", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "f", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/text/TextWatcher;", "textWatcher", "Lcom/tencent/mobileqq/guild/feed/widget/comment/CommentEditText;", "l", "()Lcom/tencent/mobileqq/guild/feed/widget/comment/CommentEditText;", "textInput", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$b;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputAttachInfo;", "attachInfo", "<init>", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$b;)V", tl.h.F, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class EditTextInputActor extends NativeDetailInputWindowDirector.a {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy textWatcher;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\f\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\u000e\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\rH\u0016R\u0016\u0010\u0011\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/bottom/input/actor/EditTextInputActor$b", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "text", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "d", "I", "lastStart", "e", "lastCount", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements TextWatcher {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int lastStart;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int lastCount;

        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable text) {
            boolean z16;
            if (text == null) {
                return;
            }
            EditTextInputActor.this.j();
            if (text.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return;
            }
            String obj = text.toString();
            int i3 = this.lastStart;
            Intrinsics.checkNotNullExpressionValue(obj.substring(i3, this.lastCount + i3), "this as java.lang.String\u2026ing(startIndex, endIndex)");
            RichTextAtParser.changeAT2PlainText(text.toString());
            this.lastCount = 0;
            this.lastStart = 0;
            EditTextInputActor.this.n(text.length(), 500);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@NotNull CharSequence s16, int start, int count, int after) {
            Intrinsics.checkNotNullParameter(s16, "s");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence text, int start, int before, int count) {
            if (text == null) {
                return;
            }
            this.lastStart = start;
            this.lastCount = count;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditTextInputActor(@NotNull NativeDetailInputWindowDirector.b attachInfo) {
        super(attachInfo);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(attachInfo, "attachInfo");
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new EditTextInputActor$textWatcher$2(this));
        this.textWatcher = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextWatcher k() {
        return new b();
    }

    private final CommentEditText l() {
        return b().X().v().a();
    }

    private final TextWatcher m() {
        return (TextWatcher) this.textWatcher.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(int current, int maxLength) {
        ho1.a.f405438a.a(b().X().v().getLengthLimitTipsView(), current, maxLength);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.NativeDetailInputWindowDirector.a
    public void d() {
        b().X().v().getLengthLimitTipsView().setVisibility(8);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.NativeDetailInputWindowDirector.a
    public void e(@NotNull xk1.d<NativeDetailInputWindowAdorn> inputWindow) {
        Intrinsics.checkNotNullParameter(inputWindow, "inputWindow");
        super.e(inputWindow);
        CommentEditText a16 = inputWindow.X().v().a();
        a16.requestFocus();
        a16.addTextChangedListener(m());
        a16.setMaxWordLength(500);
        a16.setEditableFactory(ho1.c.b());
    }

    public final void j() {
        SendButtonActor sendButtonActor = (SendButtonActor) b().getRouter().b(SendButtonActor.class);
        if (sendButtonActor != null) {
            sendButtonActor.n();
        }
    }

    public final void o() {
        n(l().getEditableText().length(), 500);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.NativeDetailInputWindowDirector.a
    public void onDestroy() {
        b().X().v().a().removeTextChangedListener(m());
    }
}

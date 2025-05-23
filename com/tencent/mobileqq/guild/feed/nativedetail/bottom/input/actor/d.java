package com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.InputFunctionType;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.NativeDetailInputWindowAdorn;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.NativeDetailInputWindowDirector;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.ReplyCommentArgs;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.ShowInputComponentArgs;
import com.tencent.mobileqq.guild.feed.widget.comment.CommentEditText;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0013\u0012\n\u0010\u001f\u001a\u00060\u001dj\u0002`\u001e\u00a2\u0006\u0004\b \u0010!J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u001a\u0010\u000e\u001a\u00020\r2\u0010\u0010\f\u001a\f\u0012\u0004\u0012\u00020\n0\tj\u0002`\u000bH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016R\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/actor/d;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$a;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputActor;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "j", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/i;", "args", "", "i", "Lxk1/d;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowAdorn;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindow;", "inputWindow", "", "e", "d", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/guild/feed/widget/comment/e;", "f", "Lcom/tencent/mobileqq/guild/feed/widget/comment/e;", "getDraftManager", "()Lcom/tencent/mobileqq/guild/feed/widget/comment/e;", "l", "(Lcom/tencent/mobileqq/guild/feed/widget/comment/e;)V", "draftManager", "Landroidx/lifecycle/Observer;", tl.h.F, "Landroidx/lifecycle/Observer;", "inputArgsObserver", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$b;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputAttachInfo;", "attachInfo", "<init>", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$b;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d extends NativeDetailInputWindowDirector.a {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.guild.feed.widget.comment.e draftManager;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Observer<ShowInputComponentArgs> inputArgsObserver;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f220510a;

        static {
            int[] iArr = new int[InputFunctionType.values().length];
            try {
                iArr[InputFunctionType.FUNCTION_TYPE_COMMENT_FEED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InputFunctionType.FUNCTION_TYPE_REPLY_COMMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f220510a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull NativeDetailInputWindowDirector.b attachInfo) {
        super(attachInfo);
        Intrinsics.checkNotNullParameter(attachInfo, "attachInfo");
        this.draftManager = new com.tencent.mobileqq.guild.feed.widget.comment.c();
        this.inputArgsObserver = new Observer() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                d.k(d.this, (ShowInputComponentArgs) obj);
            }
        };
    }

    private final String i(ShowInputComponentArgs args) {
        InputFunctionType inputFunctionType;
        int i3;
        ReplyCommentArgs replyCommentArgs;
        if (args != null) {
            inputFunctionType = args.getInputFunctionType();
        } else {
            inputFunctionType = null;
        }
        if (inputFunctionType == null) {
            i3 = -1;
        } else {
            i3 = a.f220510a[inputFunctionType.ordinal()];
        }
        if (i3 != 1) {
            if (i3 != 2 || (replyCommentArgs = args.getReplyCommentArgs()) == null) {
                return null;
            }
            return replyCommentArgs.e();
        }
        return getAttachInfo().d();
    }

    private final LocalMediaInfo j() {
        Object orNull;
        ArrayList<LocalMediaInfo> value = getAttachInfo().i().getValue();
        if (value != null) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(value, 0);
            return (LocalMediaInfo) orNull;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(d this$0, ShowInputComponentArgs showInputComponentArgs) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (showInputComponentArgs == null) {
            return;
        }
        CommentEditText a16 = this$0.b().X().v().a();
        Spannable c16 = this$0.draftManager.c(this$0.i(showInputComponentArgs));
        a16.setText(c16);
        a16.setSelection(c16.length());
        LocalMediaInfo a17 = this$0.draftManager.a(this$0.i(showInputComponentArgs));
        if (a17 != null) {
            QLog.i("IGuildGiftEngine.", 1, "recover media draft");
            SelectPicActor selectPicActor = (SelectPicActor) this$0.b().getRouter().b(SelectPicActor.class);
            if (selectPicActor != null) {
                selectPicActor.s(a17, false);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.NativeDetailInputWindowDirector.a
    public void d() {
        this.draftManager.b(i(getAttachInfo().g().getValue()), new SpannableStringBuilder(b().X().v().a().getText()), j());
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.NativeDetailInputWindowDirector.a
    public void e(@NotNull xk1.d<NativeDetailInputWindowAdorn> inputWindow) {
        Intrinsics.checkNotNullParameter(inputWindow, "inputWindow");
        super.e(inputWindow);
        getAttachInfo().g().observeForever(this.inputArgsObserver);
    }

    public final void l(@NotNull com.tencent.mobileqq.guild.feed.widget.comment.e eVar) {
        Intrinsics.checkNotNullParameter(eVar, "<set-?>");
        this.draftManager = eVar;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.NativeDetailInputWindowDirector.a
    public void onDestroy() {
        getAttachInfo().g().removeObserver(this.inputArgsObserver);
    }
}

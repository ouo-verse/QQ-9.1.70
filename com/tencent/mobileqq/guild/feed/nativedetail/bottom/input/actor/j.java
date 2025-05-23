package com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.util.Consumer;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.InputFunctionType;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.NativeDetailInputWindowAdorn;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.NativeDetailInputWindowDirector;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.ReplyCommentArgs;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.ShowInputComponentArgs;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001f2\u00060\u0001j\u0002`\u0002:\u0001 B\u0013\u0012\n\u0010\u001c\u001a\u00060\u001aj\u0002`\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002J\u001a\u0010\u0010\u001a\u00020\u00052\u0010\u0010\u000f\u001a\f\u0012\u0004\u0012\u00020\r0\fj\u0002`\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016R\u0016\u0010\u0014\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/actor/j;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$a;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputActor;", "", "replyText", "", "k", "", "o", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/h;", "replyArgs", DomainData.DOMAIN_NAME, "Lxk1/d;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowAdorn;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindow;", "inputWindow", "e", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "f", "Ljava/lang/String;", "defaultHint", "Landroidx/lifecycle/Observer;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/i;", tl.h.F, "Landroidx/lifecycle/Observer;", "observer", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$b;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputAttachInfo;", "attachInfo", "<init>", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/NativeDetailInputWindowDirector$b;)V", "i", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class j extends NativeDetailInputWindowDirector.a {

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final a f220517i = new a(null);

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String defaultHint;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Observer<ShowInputComponentArgs> observer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/actor/j$a;", "", "", "DEFAULT_START_ELLIPSIZE_TEXT_LENGTH", "I", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f220520a;

        static {
            int[] iArr = new int[InputFunctionType.values().length];
            try {
                iArr[InputFunctionType.FUNCTION_TYPE_REPLY_COMMENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InputFunctionType.FUNCTION_TYPE_COMMENT_FEED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f220520a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(@NotNull NativeDetailInputWindowDirector.b attachInfo) {
        super(attachInfo);
        Intrinsics.checkNotNullParameter(attachInfo, "attachInfo");
        this.defaultHint = "";
        this.observer = new Observer() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                j.p(j.this, (ShowInputComponentArgs) obj);
            }
        };
    }

    private final void k(final String replyText) {
        b().X().v().a().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor.h
            @Override // java.lang.Runnable
            public final void run() {
                j.l(j.this, replyText);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(final j this$0, String replyText) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(replyText, "$replyText");
        bl1.b.f28597a.b(this$0.b().X().v().a(), replyText, 8, this$0.o(), new Consumer() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.actor.i
            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                j.m(j.this, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(j this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.getAttachInfo().getIsInitialized()) {
            QLog.w(yl1.o.f450625a.a(), 1, "try to update ui in not active state");
        } else {
            this$0.b().X().v().a().setHint(str);
        }
    }

    private final String n(ReplyCommentArgs replyArgs) {
        String it;
        boolean z16;
        if (replyArgs.getReplyType() == 2 && replyArgs.getReply() != null) {
            it = replyArgs.getReply().getPostUser().getNick();
        } else {
            it = replyArgs.getComment().getPostUser().getNick();
        }
        boolean z17 = true;
        if (it != null && it.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 && !TextUtils.isEmpty(getAttachInfo().f())) {
            String f16 = getAttachInfo().f();
            if (f16 == null) {
                return this.defaultHint;
            }
            return f16;
        }
        Context context = b().getContext();
        Object[] objArr = new Object[1];
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (it.length() != 0) {
            z17 = false;
        }
        if (z17) {
            it = null;
        }
        if (it == null) {
            it = b().getContext().getString(R.string.f143020ky);
            Intrinsics.checkNotNullExpressionValue(it, "inputWindow.context.getS\u2026.guild_default_nick_name)");
        }
        objArr[0] = it;
        String string = context.getString(R.string.f153021az, objArr);
        Intrinsics.checkNotNullExpressionValue(string, "{\n            inputWindo\u2026)\n            )\n        }");
        return string;
    }

    private final int o() {
        return b().X().v().getInputLayout().findViewById(R.id.uc_).getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(j this$0, ShowInputComponentArgs showInputComponentArgs) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i3 = b.f220520a[showInputComponentArgs.getInputFunctionType().ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                this$0.k(this$0.defaultHint);
            }
        } else {
            ReplyCommentArgs replyCommentArgs = showInputComponentArgs.getReplyCommentArgs();
            if (replyCommentArgs != null) {
                this$0.k(this$0.n(replyCommentArgs));
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.NativeDetailInputWindowDirector.a
    public void e(@NotNull xk1.d<NativeDetailInputWindowAdorn> inputWindow) {
        Intrinsics.checkNotNullParameter(inputWindow, "inputWindow");
        super.e(inputWindow);
        String string = inputWindow.getContext().getString(R.string.f144480ow);
        Intrinsics.checkNotNullExpressionValue(string, "inputWindow.context.getS\u2026tive_comment_normal_hint)");
        this.defaultHint = string;
        getAttachInfo().g().observeForever(this.observer);
    }

    @Override // com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.NativeDetailInputWindowDirector.a
    public void onDestroy() {
        getAttachInfo().g().removeObserver(this.observer);
    }
}

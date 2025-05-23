package ej1;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.guild.feed.comment.fragment.GuildWebFeedCommentFragment;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.NativeDetailInputWindowDirector;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0013\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0016\u0010\f\u001a\u0004\u0018\u00010\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lej1/b;", "Lcom/tencent/biz/richframework/part/Part;", "", "z9", "", "action", "", "args", "handleBroadcastMessage", "Lcom/tencent/mobileqq/guild/feed/comment/fragment/GuildWebFeedCommentFragment$b;", "d", "Lcom/tencent/mobileqq/guild/feed/comment/fragment/GuildWebFeedCommentFragment$b;", "dismissListener", "<init>", "(Lcom/tencent/mobileqq/guild/feed/comment/fragment/GuildWebFeedCommentFragment$b;)V", "e", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final GuildWebFeedCommentFragment.b dismissListener;

    public /* synthetic */ b(GuildWebFeedCommentFragment.b bVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A9(b this$0) {
        FragmentManager parentFragmentManager;
        FragmentTransaction beginTransaction;
        FragmentTransaction remove;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            Fragment hostFragment = this$0.getHostFragment();
            if (hostFragment != null && (parentFragmentManager = hostFragment.getParentFragmentManager()) != null && (beginTransaction = parentFragmentManager.beginTransaction()) != null && (remove = beginTransaction.remove(this$0.getHostFragment())) != null) {
                remove.commitNowAllowingStateLoss();
            }
        } catch (Exception unused) {
            QLog.e("FeedWebCommentCloseHelperPart", 1, "close pop failed");
        }
    }

    private final void z9() {
        GuildWebFeedCommentFragment.b bVar = this.dismissListener;
        if (bVar != null) {
            bVar.onDismiss();
        }
        getMainHandler().post(new Runnable() { // from class: ej1.a
            @Override // java.lang.Runnable
            public final void run() {
                b.A9(b.this);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        NativeDetailInputWindowDirector.InputBarDismissCause inputBarDismissCause;
        if (Intrinsics.areEqual(action, "message_dismiss_input_dialog")) {
            boolean z16 = args instanceof NativeDetailInputWindowDirector.InputBarDismissCause;
            NativeDetailInputWindowDirector.InputBarDismissCause inputBarDismissCause2 = null;
            if (z16) {
                inputBarDismissCause = (NativeDetailInputWindowDirector.InputBarDismissCause) args;
            } else {
                inputBarDismissCause = null;
            }
            QLog.i("FeedWebCommentCloseHelperPart", 1, "onInputPop closed cause=" + inputBarDismissCause);
            if (z16) {
                inputBarDismissCause2 = (NativeDetailInputWindowDirector.InputBarDismissCause) args;
            }
            if (inputBarDismissCause2 == NativeDetailInputWindowDirector.InputBarDismissCause.UNKNOWN) {
                z9();
            }
        }
    }

    public b(@Nullable GuildWebFeedCommentFragment.b bVar) {
        this.dismissListener = bVar;
    }
}

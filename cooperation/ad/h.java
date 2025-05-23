package cooperation.ad;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.api.IChatsUtil;
import com.tencent.qqnt.chats.core.uievent.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001\fB\u001d\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u00a2\u0006\u0004\b%\u0010&J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0004R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R$\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001eR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006("}, d2 = {"Lcooperation/ad/h;", "", "Landroid/view/View;", "title", "", "statusTitleHeight", "", "c", "e", "topMargin", "b", "Lcom/tencent/mobileqq/activity/home/a;", "a", "Lcom/tencent/mobileqq/activity/home/a;", "getAmsAdTabConversationApi", "()Lcom/tencent/mobileqq/activity/home/a;", "amsAdTabConversationApi", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/activity/home/Conversation;", "Lmqq/util/WeakReference;", "getWeakConversation", "()Lmqq/util/WeakReference;", "weakConversation", "Landroid/view/View;", "getMCoverView", "()Landroid/view/View;", "setMCoverView", "(Landroid/view/View;)V", "mCoverView", "d", "I", "mCurStatusTitleBarHeight", "mTitleBarOffset", "", "f", "Z", "mHasInitTitleAnim", "<init>", "(Lcom/tencent/mobileqq/activity/home/a;Lmqq/util/WeakReference;)V", "g", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes28.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.activity.home.a amsAdTabConversationApi;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<Conversation> weakConversation;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mCoverView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mCurStatusTitleBarHeight;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mTitleBarOffset;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mHasInitTitleAnim;

    public h(@NotNull com.tencent.mobileqq.activity.home.a amsAdTabConversationApi, @NotNull WeakReference<Conversation> weakConversation) {
        Intrinsics.checkNotNullParameter(amsAdTabConversationApi, "amsAdTabConversationApi");
        Intrinsics.checkNotNullParameter(weakConversation, "weakConversation");
        this.amsAdTabConversationApi = amsAdTabConversationApi;
        this.weakConversation = weakConversation;
    }

    private final void c(View title, int statusTitleHeight) {
        if (QLog.isColorLevel()) {
            QLog.d("AmsAdConversationManger", 2, "initTitleAnim statusTitleHeight:", Integer.valueOf(statusTitleHeight));
        }
        if (statusTitleHeight > 0) {
            this.mTitleBarOffset = statusTitleHeight;
        } else {
            int i3 = this.mCurStatusTitleBarHeight;
            if (i3 > 0) {
                this.mTitleBarOffset = i3;
            } else if (title != null) {
                this.mTitleBarOffset = title.getHeight();
            }
        }
        QLog.d("AmsAdConversationManger", 1, "initTitrbleAnim start mTitleBarOffset=", Integer.valueOf(this.mTitleBarOffset));
        if (title != null) {
            title.post(new Runnable() { // from class: cooperation.ad.g
                @Override // java.lang.Runnable
                public final void run() {
                    h.d(h.this);
                }
            });
        }
        this.mHasInitTitleAnim = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(h this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("AmsAdConversationManger", 1, "initTitleAnim sendEventToChat mTitleBarOffset=", Integer.valueOf(this$0.mTitleBarOffset));
        ((IChatsUtil) QRoute.api(IChatsUtil.class)).sendEventToChat(new a.r(this$0.mTitleBarOffset));
        ((IChatsUtil) QRoute.api(IChatsUtil.class)).sendEventToChat(a.o.f355022a);
    }

    protected final void b(int topMargin) {
        ViewGroup.LayoutParams layoutParams;
        View view = this.mCoverView;
        if (view == null) {
            return;
        }
        if (view != null) {
            layoutParams = view.getLayoutParams();
        } else {
            layoutParams = null;
        }
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.topMargin = topMargin;
        View view2 = this.mCoverView;
        if (view2 != null) {
            view2.setLayoutParams(layoutParams2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e(int statusTitleHeight) {
        View animTitle;
        Integer valueOf;
        View view = null;
        if (statusTitleHeight <= 0 && this.weakConversation.get() != null) {
            Conversation conversation = this.weakConversation.get();
            boolean z16 = false;
            if (conversation != null && Intrinsics.compare(conversation.statusTitleHeightInNormalState, 0) == 1) {
                z16 = true;
            }
            if (z16) {
                Conversation conversation2 = this.weakConversation.get();
                if (conversation2 != null) {
                    valueOf = Integer.valueOf(conversation2.statusTitleHeightInNormalState);
                    if (valueOf != null) {
                        this.mCurStatusTitleBarHeight = valueOf.intValue();
                    }
                }
                valueOf = null;
                if (valueOf != null) {
                }
            } else {
                Conversation conversation3 = this.weakConversation.get();
                if (conversation3 != null && (animTitle = conversation3.getAnimTitle()) != null) {
                    valueOf = Integer.valueOf(animTitle.getHeight());
                    if (valueOf != null) {
                    }
                }
                valueOf = null;
                if (valueOf != null) {
                }
            }
        } else {
            this.mCurStatusTitleBarHeight = statusTitleHeight;
        }
        Conversation conversation4 = this.weakConversation.get();
        if (conversation4 != null) {
            view = conversation4.getAnimTitle();
        }
        this.amsAdTabConversationApi.b().u(statusTitleHeight);
        c(view, statusTitleHeight);
        b(this.mCurStatusTitleBarHeight);
    }
}

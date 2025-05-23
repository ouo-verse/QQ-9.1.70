package com.tencent.qqnt.aio.assistedchat.panel.extend;

import android.view.MotionEvent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\b\u00a2\u0006\u0004\b\u0016\u0010\rJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\"\u0010\u000e\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/extend/d;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroid/view/MotionEvent;", "event", "", "d", "Lcom/tencent/qqnt/aio/assistedchat/panel/extend/c;", "Lcom/tencent/qqnt/aio/assistedchat/panel/extend/c;", "getExtendListener", "()Lcom/tencent/qqnt/aio/assistedchat/panel/extend/c;", "e", "(Lcom/tencent/qqnt/aio/assistedchat/panel/extend/c;)V", "extendListener", "", UserInfo.SEX_FEMALE, "downY", "", "f", "Z", "needPullUp", "<init>", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class d extends RecyclerView.OnScrollListener {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private c extendListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float downY;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean needPullUp;

    public d(@NotNull c extendListener) {
        Intrinsics.checkNotNullParameter(extendListener, "extendListener");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) extendListener);
        } else {
            this.extendListener = extendListener;
        }
    }

    public final void d(@NotNull RecyclerView recyclerView, @NotNull MotionEvent event) {
        LinearLayoutManager linearLayoutManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) recyclerView, (Object) event);
            return;
        }
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2 && event.getY() <= 0.0f) {
                    this.needPullUp = true;
                    return;
                }
                return;
            }
            if (this.needPullUp) {
                this.extendListener.onPullUp();
                this.needPullUp = false;
                return;
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                linearLayoutManager = (LinearLayoutManager) layoutManager;
            } else {
                linearLayoutManager = null;
            }
            if (linearLayoutManager != null && linearLayoutManager.findFirstCompletelyVisibleItemPosition() == 0 && event.getY() > this.downY) {
                this.extendListener.onPullDown();
                return;
            }
            return;
        }
        this.downY = event.getY();
    }

    public final void e(@NotNull c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar);
        } else {
            Intrinsics.checkNotNullParameter(cVar, "<set-?>");
            this.extendListener = cVar;
        }
    }
}

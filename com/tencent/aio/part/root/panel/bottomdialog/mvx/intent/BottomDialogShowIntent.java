package com.tencent.aio.part.root.panel.bottomdialog.mvx.intent;

import android.view.View;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.mvi.base.route.MsgIntent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001:\u0002\b\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/aio/part/root/panel/bottomdialog/mvx/intent/BottomDialogShowIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "", "d", "Z", "a", "()Z", ViewStickEventHelper.IS_SHOW, "BottomDialogShowAnchorView", "BottomDialogShowAtLocationIntent", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public class BottomDialogShowIntent implements MsgIntent {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean isShow;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/aio/part/root/panel/bottomdialog/mvx/intent/BottomDialogShowIntent$BottomDialogShowAnchorView;", "Lcom/tencent/aio/part/root/panel/bottomdialog/mvx/intent/BottomDialogShowIntent;", "", "e", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setDialogType", "(Ljava/lang/String;)V", "dialogType", "Landroid/view/View;", "f", "Landroid/view/View;", "b", "()Landroid/view/View;", "anchorView", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class BottomDialogShowAnchorView extends BottomDialogShowIntent {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String dialogType;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final View anchorView;

        @NotNull
        public final View b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (View) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.anchorView;
        }

        @NotNull
        public final String c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (String) iPatchRedirector.redirect((short) 1, (Object) this);
            }
            return this.dialogType;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/aio/part/root/panel/bottomdialog/mvx/intent/BottomDialogShowIntent$BottomDialogShowAtLocationIntent;", "Lcom/tencent/aio/part/root/panel/bottomdialog/mvx/intent/BottomDialogShowIntent;", "", "e", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setDialogType", "(Ljava/lang/String;)V", "dialogType", "", "f", "I", "c", "()I", "setX", "(I)V", HippyTKDListViewAdapter.X, h.F, "d", "setY", "y", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class BottomDialogShowAtLocationIntent extends BottomDialogShowIntent {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String dialogType;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private int x;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private int y;

        @NotNull
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return (String) iPatchRedirector.redirect((short) 1, (Object) this);
            }
            return this.dialogType;
        }

        public final int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.x;
        }

        public final int d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return this.y;
        }
    }

    public final boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) this)).booleanValue();
        }
        return this.isShow;
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return MsgIntent.a.a(this);
    }
}

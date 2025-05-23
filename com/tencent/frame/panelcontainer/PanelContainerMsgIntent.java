package com.tencent.frame.panelcontainer;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.h;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001:\u0007\u0004\u0005\u0006\u0007\b\t\nB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/frame/panelcontainer/PanelContainerMsgIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "<init>", "()V", "GetKeyboardStatus", "GetPanelStatus", "HideAllPanelAndKeyboard", "OnKeyboardStatusChanged", "OnPanelHeightChanged", "OnPanelStatusChanged", "ShowPanel", "input-base_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public class PanelContainerMsgIntent implements MsgIntent {
    static IPatchRedirector $redirector_;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/frame/panelcontainer/PanelContainerMsgIntent$GetKeyboardStatus;", "Lcom/tencent/frame/panelcontainer/PanelContainerMsgIntent;", "()V", "input-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class GetKeyboardStatus extends PanelContainerMsgIntent {
        static IPatchRedirector $redirector_;

        public GetKeyboardStatus() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/frame/panelcontainer/PanelContainerMsgIntent$GetPanelStatus;", "Lcom/tencent/frame/panelcontainer/PanelContainerMsgIntent;", "()V", "input-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class GetPanelStatus extends PanelContainerMsgIntent {
        static IPatchRedirector $redirector_;

        public GetPanelStatus() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/frame/panelcontainer/PanelContainerMsgIntent$HideAllPanelAndKeyboard;", "Lcom/tencent/frame/panelcontainer/PanelContainerMsgIntent;", "", "d", "Z", "getNeedAnim", "()Z", "needAnim", "<init>", "(Z)V", "input-base_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class HideAllPanelAndKeyboard extends PanelContainerMsgIntent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean needAnim;

        public HideAllPanelAndKeyboard(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, z16);
            } else {
                this.needAnim = z16;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/frame/panelcontainer/PanelContainerMsgIntent$OnKeyboardStatusChanged;", "Lcom/tencent/frame/panelcontainer/PanelContainerMsgIntent;", "", "d", "Z", "b", "()Z", "isShowKeyboard", "", "e", "I", "a", "()I", "curKeyboardHeight", "input-base_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class OnKeyboardStatusChanged extends PanelContainerMsgIntent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean isShowKeyboard;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final int curKeyboardHeight;

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.curKeyboardHeight;
        }

        public final boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return this.isShowKeyboard;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2 = {"Lcom/tencent/frame/panelcontainer/PanelContainerMsgIntent$OnPanelHeightChanged;", "Lcom/tencent/frame/panelcontainer/PanelContainerMsgIntent;", "", "d", "I", "a", "()I", "curPanelHeight", "input-base_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class OnPanelHeightChanged extends PanelContainerMsgIntent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int curPanelHeight;

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.curPanelHeight;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2 = {"Lcom/tencent/frame/panelcontainer/PanelContainerMsgIntent$OnPanelStatusChanged;", "Lcom/tencent/frame/panelcontainer/PanelContainerMsgIntent;", "", "d", "I", "a", "()I", "showPanelId", "input-base_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class OnPanelStatusChanged extends PanelContainerMsgIntent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int showPanelId;

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.showPanelId;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/frame/panelcontainer/PanelContainerMsgIntent$ShowPanel;", "Lcom/tencent/frame/panelcontainer/PanelContainerMsgIntent;", "", "d", "I", "getPanelId", "()I", "panelId", "", "e", "Z", "getNeedAnim", "()Z", "needAnim", "<init>", "(IZ)V", "input-base_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class ShowPanel extends PanelContainerMsgIntent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int panelId;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean needAnim;

        public ShowPanel(int i3, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            } else {
                this.panelId = i3;
                this.needAnim = z16;
            }
        }

        public /* synthetic */ ShowPanel(int i3, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3, (i16 & 2) != 0 ? true : z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(i16), defaultConstructorMarker);
        }
    }

    public PanelContainerMsgIntent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return MsgIntent.a.a(this);
    }
}

package com.tencent.qqnt.pluspanel.data.msg;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mvi.annotation.AutoEventName;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qqnt.pluspanel.data.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\t\u0004\u0005\u0006\u0007\b\t\n\u000b\fB\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\t\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/pluspanel/data/msg/PlusPanelEvent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "<init>", "()V", "ClickButtonEvent", "ClickMoreAppEvent", "ClosePanelEvent", "FetchPlusPanelAppList", "FirstOpenPanelEvent", "OpenPanelEvent", "RemoveIceBreakHotPicEvent", "RemovePanelEvent", "UpdatePlusPanel", "Lcom/tencent/qqnt/pluspanel/data/msg/PlusPanelEvent$ClickButtonEvent;", "Lcom/tencent/qqnt/pluspanel/data/msg/PlusPanelEvent$ClickMoreAppEvent;", "Lcom/tencent/qqnt/pluspanel/data/msg/PlusPanelEvent$ClosePanelEvent;", "Lcom/tencent/qqnt/pluspanel/data/msg/PlusPanelEvent$FetchPlusPanelAppList;", "Lcom/tencent/qqnt/pluspanel/data/msg/PlusPanelEvent$FirstOpenPanelEvent;", "Lcom/tencent/qqnt/pluspanel/data/msg/PlusPanelEvent$OpenPanelEvent;", "Lcom/tencent/qqnt/pluspanel/data/msg/PlusPanelEvent$RemoveIceBreakHotPicEvent;", "Lcom/tencent/qqnt/pluspanel/data/msg/PlusPanelEvent$RemovePanelEvent;", "Lcom/tencent/qqnt/pluspanel/data/msg/PlusPanelEvent$UpdatePlusPanel;", "plus_panel_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public abstract class PlusPanelEvent implements MsgIntent {
    static IPatchRedirector $redirector_;

    @AutoEventName
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/pluspanel/data/msg/PlusPanelEvent$ClickButtonEvent;", "Lcom/tencent/qqnt/pluspanel/data/msg/PlusPanelEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/qqnt/pluspanel/data/a;", "d", "Lcom/tencent/qqnt/pluspanel/data/a;", "a", "()Lcom/tencent/qqnt/pluspanel/data/a;", "appData", "<init>", "(Lcom/tencent/qqnt/pluspanel/data/a;)V", "plus_panel_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final /* data */ class ClickButtonEvent extends PlusPanelEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final a appData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ClickButtonEvent(@NotNull a appData) {
            super(null);
            Intrinsics.checkNotNullParameter(appData, "appData");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) appData);
            } else {
                this.appData = appData;
            }
        }

        @NotNull
        public final a a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.appData;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof ClickButtonEvent) && Intrinsics.areEqual(this.appData, ((ClickButtonEvent) other).appData)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (String) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return "com.tencent.qqnt.pluspanel.data.msg.PlusPanelEvent.ClickButtonEvent";
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.appData.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "ClickButtonEvent(appData=" + this.appData + ")";
        }
    }

    @AutoEventName
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/pluspanel/data/msg/PlusPanelEvent$ClickMoreAppEvent;", "Lcom/tencent/qqnt/pluspanel/data/msg/PlusPanelEvent;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/qqnt/pluspanel/data/a;", "d", "Lcom/tencent/qqnt/pluspanel/data/a;", "a", "()Lcom/tencent/qqnt/pluspanel/data/a;", "appData", "<init>", "(Lcom/tencent/qqnt/pluspanel/data/a;)V", "plus_panel_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final /* data */ class ClickMoreAppEvent extends PlusPanelEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final a appData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ClickMoreAppEvent(@NotNull a appData) {
            super(null);
            Intrinsics.checkNotNullParameter(appData, "appData");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) appData);
            } else {
                this.appData = appData;
            }
        }

        @NotNull
        public final a a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.appData;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if ((other instanceof ClickMoreAppEvent) && Intrinsics.areEqual(this.appData, ((ClickMoreAppEvent) other).appData)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (String) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return "com.tencent.qqnt.pluspanel.data.msg.PlusPanelEvent.ClickMoreAppEvent";
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.appData.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "ClickMoreAppEvent(appData=" + this.appData + ")";
        }
    }

    @AutoEventName
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/pluspanel/data/msg/PlusPanelEvent$ClosePanelEvent;", "Lcom/tencent/qqnt/pluspanel/data/msg/PlusPanelEvent;", "()V", "plus_panel_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes22.dex */
    public static final class ClosePanelEvent extends PlusPanelEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final ClosePanelEvent f360438d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37610);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f360438d = new ClosePanelEvent();
            }
        }

        ClosePanelEvent() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "com.tencent.qqnt.pluspanel.data.msg.PlusPanelEvent.ClosePanelEvent";
        }
    }

    @AutoEventName
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/pluspanel/data/msg/PlusPanelEvent$FetchPlusPanelAppList;", "Lcom/tencent/qqnt/pluspanel/data/msg/PlusPanelEvent;", "()V", "plus_panel_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes22.dex */
    public static final class FetchPlusPanelAppList extends PlusPanelEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final FetchPlusPanelAppList f360439d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37613);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f360439d = new FetchPlusPanelAppList();
            }
        }

        FetchPlusPanelAppList() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "com.tencent.qqnt.pluspanel.data.msg.PlusPanelEvent.FetchPlusPanelAppList";
        }
    }

    @AutoEventName
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/pluspanel/data/msg/PlusPanelEvent$FirstOpenPanelEvent;", "Lcom/tencent/qqnt/pluspanel/data/msg/PlusPanelEvent;", "()V", "plus_panel_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes22.dex */
    public static final class FirstOpenPanelEvent extends PlusPanelEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final FirstOpenPanelEvent f360440d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37622);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f360440d = new FirstOpenPanelEvent();
            }
        }

        FirstOpenPanelEvent() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "com.tencent.qqnt.pluspanel.data.msg.PlusPanelEvent.FirstOpenPanelEvent";
        }
    }

    @AutoEventName
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/pluspanel/data/msg/PlusPanelEvent$OpenPanelEvent;", "Lcom/tencent/qqnt/pluspanel/data/msg/PlusPanelEvent;", "()V", "plus_panel_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes22.dex */
    public static final class OpenPanelEvent extends PlusPanelEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final OpenPanelEvent f360441d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37626);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f360441d = new OpenPanelEvent();
            }
        }

        OpenPanelEvent() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "com.tencent.qqnt.pluspanel.data.msg.PlusPanelEvent.OpenPanelEvent";
        }
    }

    @AutoEventName
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/pluspanel/data/msg/PlusPanelEvent$RemoveIceBreakHotPicEvent;", "Lcom/tencent/qqnt/pluspanel/data/msg/PlusPanelEvent;", "()V", "plus_panel_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes22.dex */
    public static final class RemoveIceBreakHotPicEvent extends PlusPanelEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final RemoveIceBreakHotPicEvent f360442d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38078);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f360442d = new RemoveIceBreakHotPicEvent();
            }
        }

        RemoveIceBreakHotPicEvent() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "com.tencent.qqnt.pluspanel.data.msg.PlusPanelEvent.RemoveIceBreakHotPicEvent";
        }
    }

    @AutoEventName
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/pluspanel/data/msg/PlusPanelEvent$RemovePanelEvent;", "Lcom/tencent/qqnt/pluspanel/data/msg/PlusPanelEvent;", "()V", "plus_panel_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes22.dex */
    public static final class RemovePanelEvent extends PlusPanelEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final RemovePanelEvent f360443d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38082);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f360443d = new RemovePanelEvent();
            }
        }

        RemovePanelEvent() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "com.tencent.qqnt.pluspanel.data.msg.PlusPanelEvent.RemovePanelEvent";
        }
    }

    @AutoEventName
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/pluspanel/data/msg/PlusPanelEvent$UpdatePlusPanel;", "Lcom/tencent/qqnt/pluspanel/data/msg/PlusPanelEvent;", "()V", "plus_panel_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes22.dex */
    public static final class UpdatePlusPanel extends PlusPanelEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final UpdatePlusPanel f360444d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38088);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f360444d = new UpdatePlusPanel();
            }
        }

        UpdatePlusPanel() {
            super(null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mvi.base.route.i
        public String eventName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "com.tencent.qqnt.pluspanel.data.msg.PlusPanelEvent.UpdatePlusPanel";
        }
    }

    public /* synthetic */ PlusPanelEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return MsgIntent.a.a(this);
    }

    PlusPanelEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}

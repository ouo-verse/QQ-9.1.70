package com.tencent.mobileqq.aio.event;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.base.route.MsgIntent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0005\u0002\u0003\u0004\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/event/ShortcutEventIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "OnGetEmoIconViewIntent", "OnGetIconBarHeightIntent", "OnGetPlusIconPosIntent", "OnGetPlusIconViewIntent", "OnGetShortCutLayoutViewIntent", "aio_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes10.dex */
public interface ShortcutEventIntent extends MsgIntent {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/aio/event/ShortcutEventIntent$OnGetEmoIconViewIntent;", "Lcom/tencent/mobileqq/aio/event/ShortcutEventIntent;", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes10.dex */
    public static final class OnGetEmoIconViewIntent implements ShortcutEventIntent {
        static IPatchRedirector $redirector_;

        public OnGetEmoIconViewIntent() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mvi.base.route.i
        public /* synthetic */ String eventName() {
            return com.tencent.mvi.base.route.h.a(this);
        }

        @Override // com.tencent.mvi.base.route.MsgIntent
        public boolean isSticky() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/aio/event/ShortcutEventIntent$OnGetIconBarHeightIntent;", "Lcom/tencent/mobileqq/aio/event/ShortcutEventIntent;", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes10.dex */
    public static final class OnGetIconBarHeightIntent implements ShortcutEventIntent {
        static IPatchRedirector $redirector_;

        public OnGetIconBarHeightIntent() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mvi.base.route.i
        public /* synthetic */ String eventName() {
            return com.tencent.mvi.base.route.h.a(this);
        }

        @Override // com.tencent.mvi.base.route.MsgIntent
        public boolean isSticky() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/aio/event/ShortcutEventIntent$OnGetPlusIconPosIntent;", "Lcom/tencent/mobileqq/aio/event/ShortcutEventIntent;", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes10.dex */
    public static final class OnGetPlusIconPosIntent implements ShortcutEventIntent {
        static IPatchRedirector $redirector_;

        public OnGetPlusIconPosIntent() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mvi.base.route.i
        public /* synthetic */ String eventName() {
            return com.tencent.mvi.base.route.h.a(this);
        }

        @Override // com.tencent.mvi.base.route.MsgIntent
        public boolean isSticky() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/aio/event/ShortcutEventIntent$OnGetPlusIconViewIntent;", "Lcom/tencent/mobileqq/aio/event/ShortcutEventIntent;", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes10.dex */
    public static final class OnGetPlusIconViewIntent implements ShortcutEventIntent {
        static IPatchRedirector $redirector_;

        public OnGetPlusIconViewIntent() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mvi.base.route.i
        public /* synthetic */ String eventName() {
            return com.tencent.mvi.base.route.h.a(this);
        }

        @Override // com.tencent.mvi.base.route.MsgIntent
        public boolean isSticky() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/aio/event/ShortcutEventIntent$OnGetShortCutLayoutViewIntent;", "Lcom/tencent/mobileqq/aio/event/ShortcutEventIntent;", "()V", "aio_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes10.dex */
    public static final class OnGetShortCutLayoutViewIntent implements ShortcutEventIntent {
        static IPatchRedirector $redirector_;

        public OnGetShortCutLayoutViewIntent() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mvi.base.route.i
        public /* synthetic */ String eventName() {
            return com.tencent.mvi.base.route.h.a(this);
        }

        @Override // com.tencent.mvi.base.route.MsgIntent
        public boolean isSticky() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes10.dex */
    public static final class a {
        public static boolean a(@NotNull ShortcutEventIntent shortcutEventIntent) {
            return MsgIntent.a.a(shortcutEventIntent);
        }
    }
}

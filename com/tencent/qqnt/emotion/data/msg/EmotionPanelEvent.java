package com.tencent.qqnt.emotion.data.msg;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mvi.annotation.AutoEventName;
import com.tencent.mvi.base.route.MsgIntent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/emotion/data/msg/EmotionPanelEvent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "FetchEmotionRedDot", "Lcom/tencent/qqnt/emotion/data/msg/EmotionPanelEvent$FetchEmotionRedDot;", "emotion_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
public abstract class EmotionPanelEvent implements MsgIntent {
    static IPatchRedirector $redirector_;

    @AutoEventName
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/emotion/data/msg/EmotionPanelEvent$FetchEmotionRedDot;", "Lcom/tencent/qqnt/emotion/data/msg/EmotionPanelEvent;", "()V", "emotion_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes24.dex */
    public static final class FetchEmotionRedDot extends EmotionPanelEvent {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final FetchEmotionRedDot f356227d;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38376);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f356227d = new FetchEmotionRedDot();
            }
        }

        FetchEmotionRedDot() {
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
            return "com.tencent.qqnt.emotion.data.msg.EmotionPanelEvent.FetchEmotionRedDot";
        }
    }

    public /* synthetic */ EmotionPanelEvent(DefaultConstructorMarker defaultConstructorMarker) {
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

    EmotionPanelEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }
}

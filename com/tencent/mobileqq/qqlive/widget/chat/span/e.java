package com.tencent.mobileqq.qqlive.widget.chat.span;

import android.text.TextPaint;
import android.view.View;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 ;2\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b9\u0010:J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u001a\u0010\u0010\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0007H\u0016J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0015H\u0016R\u0016\u0010\u0019\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0018R$\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010!\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R*\u00100\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u00108\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/chat/span/e;", "Lcom/tencent/mobileqq/qqlive/widget/chat/span/d;", "Lcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;", "info", "", "roomId", "anchorId", "", "e", "", "nickColor", "c", "Lvi2/a;", "dataSupport", "Lvi2/c;", "playFunc", "d", "Landroid/text/TextPaint;", "tp", "updateDrawState", "a", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, NodeProps.ON_CLICK, "I", "nickNormalColor", "Lcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;", "getLiveUserInfo", "()Lcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;", "setLiveUserInfo", "(Lcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;)V", "liveUserInfo", "f", "J", "getRoomId", "()J", "setRoomId", "(J)V", h.F, "getAnchorId", "setAnchorId", "Lmqq/util/WeakReference;", "i", "Lmqq/util/WeakReference;", "getPlayFuncRef", "()Lmqq/util/WeakReference;", "setPlayFuncRef", "(Lmqq/util/WeakReference;)V", "playFuncRef", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "getMsgContent", "()Ljava/lang/String;", "b", "(Ljava/lang/String;)V", RemoteMessageConst.MessageBody.MSG_CONTENT, "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class e extends d {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int nickNormalColor;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LiveUserInfo liveUserInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long roomId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long anchorId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<vi2.c> playFuncRef;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String msgContent;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/chat/span/e$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.widget.chat.span.e$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33599);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 19)) {
            redirector.redirect((short) 19);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.nickNormalColor = com.tencent.mobileqq.qqlive.widget.util.e.a(R.color.cld);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.widget.chat.span.d
    public void a() {
        vi2.c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        WeakReference<vi2.c> weakReference = this.playFuncRef;
        if (weakReference != null) {
            cVar = weakReference.get();
        } else {
            cVar = null;
        }
        if (cVar != null) {
            cVar.t(this.liveUserInfo, this.anchorId);
        }
    }

    public final void b(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        } else {
            this.msgContent = str;
        }
    }

    public final void c(int nickColor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, nickColor);
        } else {
            this.nickNormalColor = nickColor;
        }
    }

    public final void d(@Nullable vi2.a dataSupport, @Nullable vi2.c playFunc) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) dataSupport, (Object) playFunc);
        } else if (playFunc != null) {
            this.playFuncRef = new WeakReference<>(playFunc);
        }
    }

    public final void e(@NotNull LiveUserInfo info, long roomId, long anchorId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, info, Long.valueOf(roomId), Long.valueOf(anchorId));
            return;
        }
        Intrinsics.checkNotNullParameter(info, "info");
        this.liveUserInfo = info;
        this.roomId = roomId;
        this.anchorId = anchorId;
    }

    @Override // com.tencent.mobileqq.qqlive.widget.chat.span.d, android.text.style.ClickableSpan
    public void onClick(@NotNull View widget) {
        vi2.c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) widget);
            return;
        }
        Intrinsics.checkNotNullParameter(widget, "widget");
        WeakReference<vi2.c> weakReference = this.playFuncRef;
        if (weakReference != null) {
            cVar = weakReference.get();
        } else {
            cVar = null;
        }
        if (cVar != null) {
            cVar.E(this.liveUserInfo, this.anchorId, this.msgContent);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.widget.chat.span.d, android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(@NotNull TextPaint tp5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) tp5);
            return;
        }
        Intrinsics.checkNotNullParameter(tp5, "tp");
        tp5.setColor(this.nickNormalColor);
        tp5.setUnderlineText(false);
    }
}

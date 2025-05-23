package com.tencent.mobileqq.aio.panel.emoticon;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.EditText;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent;
import com.tencent.qqnt.aio.api.e;
import com.tencent.qqnt.emotion.SystemAndEmojiPanel;
import com.tencent.qqnt.emotion.info.SystemAndEmojiEmotionInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001c\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J$\u0010\u001a\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001b\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016R\u0014\u0010\u001e\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010+\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/aio/panel/emoticon/a;", "Lcom/tencent/qqnt/aio/api/e;", "Lcom/tencent/qqnt/b;", "Landroid/view/View;", HippyEngineMonitorEvent.MODULE_LOAD_EVENT_CREATE_VIEW, "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Landroid/widget/EditText;", "editText", "", "a", "Lcom/tencent/qqnt/aio/api/e$a;", "callback", "b", "c", "Lcom/tencent/qqnt/emotion/info/SystemAndEmojiEmotionInfo;", "info", "f0", "e0", "delete", "", "h0", "oldInfo", "newInfo", "Landroid/graphics/drawable/Drawable;", "d", "g0", "i0", "Landroid/content/Context;", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/emotion/SystemAndEmojiPanel;", "e", "Lcom/tencent/qqnt/emotion/SystemAndEmojiPanel;", WinkDaTongReportConstant.ElementParamValue.MUSIC_FROM_PANEL, "f", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", h.F, "Landroid/widget/EditText;", "mEditText", "i", "Lcom/tencent/qqnt/aio/api/e$a;", "emoCallback", "<init>", "(Landroid/content/Context;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a implements e, com.tencent.qqnt.b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private SystemAndEmojiPanel panel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private EditText mEditText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private e.a emoCallback;

    public a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.context = context;
        }
    }

    @Override // com.tencent.qqnt.aio.api.e
    public void a(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull EditText editText) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aioContext, (Object) editText);
            return;
        }
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(editText, "editText");
        this.mAIOContext = aioContext;
        this.mEditText = editText;
        SystemAndEmojiPanel systemAndEmojiPanel = this.panel;
        if (systemAndEmojiPanel == null) {
            Intrinsics.throwUninitializedPropertyAccessException(WinkDaTongReportConstant.ElementParamValue.MUSIC_FROM_PANEL);
            systemAndEmojiPanel = null;
        }
        systemAndEmojiPanel.g(editText);
    }

    @Override // com.tencent.qqnt.aio.api.e
    public void b(@NotNull e.a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.emoCallback = callback;
        }
    }

    @Override // com.tencent.qqnt.aio.api.e
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.api.e
    @NotNull
    public View createView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        SystemAndEmojiPanel systemAndEmojiPanel = new SystemAndEmojiPanel(this.context);
        this.panel = systemAndEmojiPanel;
        systemAndEmojiPanel.f(this);
        SystemAndEmojiPanel systemAndEmojiPanel2 = this.panel;
        if (systemAndEmojiPanel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(WinkDaTongReportConstant.ElementParamValue.MUSIC_FROM_PANEL);
            systemAndEmojiPanel2 = null;
        }
        systemAndEmojiPanel2.e();
        SystemAndEmojiPanel systemAndEmojiPanel3 = this.panel;
        if (systemAndEmojiPanel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(WinkDaTongReportConstant.ElementParamValue.MUSIC_FROM_PANEL);
            return null;
        }
        return systemAndEmojiPanel3;
    }

    @Override // com.tencent.qqnt.b
    public void delete() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        aVar.e().h(InputEditTextMsgIntent.BackspaceInEditText.f189406d);
    }

    @Override // com.tencent.qqnt.b
    public void e0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        aVar.e().h(AIOMsgSendEvent.InputSendEvent.f188428d);
    }

    @Override // com.tencent.qqnt.b
    public void f0(@NotNull SystemAndEmojiEmotionInfo info) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) info);
            return;
        }
        Intrinsics.checkNotNullParameter(info, "info");
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        aVar.e().h(new InputEditTextMsgIntent.AddEmoticonToEditText(info.c(), info.getCode()));
    }

    @Override // com.tencent.qqnt.b
    public void g0(@Nullable SystemAndEmojiEmotionInfo oldInfo, @NotNull SystemAndEmojiEmotionInfo newInfo, @Nullable Drawable d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, oldInfo, newInfo, d16);
        } else {
            Intrinsics.checkNotNullParameter(newInfo, "newInfo");
        }
    }

    @Override // com.tencent.qqnt.b
    public boolean h0(@NotNull SystemAndEmojiEmotionInfo info) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) info)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(info, "info");
        return false;
    }

    @Override // com.tencent.qqnt.b
    public void i0(@Nullable SystemAndEmojiEmotionInfo info) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) info);
        }
    }
}

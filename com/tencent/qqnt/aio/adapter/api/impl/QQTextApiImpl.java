package com.tencent.qqnt.aio.adapter.api.impl;

import android.graphics.Paint;
import android.text.Editable;
import android.view.View;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendNTChatApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.aio.adapter.api.IQQTextApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J4\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\tH\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\tH\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/QQTextApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IQQTextApi;", "()V", "EMOTION_INPUT_FACTORY", "Landroid/text/Editable$Factory;", "createNewQQTextForStreamMsg", "", "qqText", "start", "", "end", "getInputQQTextBuilder", "getQQText", "content", WadlProxyConsts.FLAGS, "emoSize", "view", "Landroid/view/View;", "msgItem", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "getQQTextPurePlainText", "measureNickNameQQText", "", "setBizSrc", "", "src", "", "toPlainText", "nt-adapter-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class QQTextApiImpl implements IQQTextApi {
    static IPatchRedirector $redirector_;

    @NotNull
    private final Editable.Factory EMOTION_INPUT_FACTORY;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/adapter/api/impl/QQTextApiImpl$a", "Landroid/text/Editable$Factory;", "", "source", "Landroid/text/Editable;", "newEditable", "nt-adapter-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class a extends Editable.Factory {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.text.Editable.Factory
        @NotNull
        public Editable newEditable(@NotNull CharSequence source) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Editable) iPatchRedirector.redirect((short) 2, (Object) this, (Object) source);
            }
            Intrinsics.checkNotNullParameter(source, "source");
            if (source instanceof QQTextBuilder) {
                return (Editable) source;
            }
            return new QQTextBuilder(source, 3, 18);
        }
    }

    public QQTextApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.EMOTION_INPUT_FACTORY = new a();
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IQQTextApi
    @NotNull
    public CharSequence createNewQQTextForStreamMsg(@NotNull CharSequence qqText, int start, int end) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (CharSequence) iPatchRedirector.redirect((short) 8, this, qqText, Integer.valueOf(start), Integer.valueOf(end));
        }
        Intrinsics.checkNotNullParameter(qqText, "qqText");
        QQText qQText = (QQText) qqText;
        return new QQText(qQText, start, end, 0, qQText.getEmojiSize(), true);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IQQTextApi
    @NotNull
    public Editable.Factory getInputNotReuseQQTextBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Editable.Factory) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return IQQTextApi.a.a(this);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IQQTextApi
    @NotNull
    public Editable.Factory getInputQQTextBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Editable.Factory) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.EMOTION_INPUT_FACTORY;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IQQTextApi
    @NotNull
    public CharSequence getQQText(@NotNull CharSequence content, int flags, int emoSize, @Nullable View view, @Nullable AIOMsgItem msgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CharSequence) iPatchRedirector.redirect((short) 2, this, content, Integer.valueOf(flags), Integer.valueOf(emoSize), view, msgItem);
        }
        Intrinsics.checkNotNullParameter(content, "content");
        if (msgItem != null && msgItem.p0() == 104) {
            return ((IMatchFriendNTChatApi) QRoute.api(IMatchFriendNTChatApi.class)).getMatchFriendNTQQText(content, flags, emoSize, msgItem);
        }
        return new QQText(content, flags, emoSize, msgItem);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IQQTextApi
    @NotNull
    public CharSequence getQQTextPurePlainText(@NotNull CharSequence content, int flags) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (CharSequence) iPatchRedirector.redirect((short) 4, (Object) this, (Object) content, flags);
        }
        Intrinsics.checkNotNullParameter(content, "content");
        String purePlainText = new QQText(content, flags).toPurePlainText();
        Intrinsics.checkNotNullExpressionValue(purePlainText, "QQText(content, flags).toPurePlainText()");
        return purePlainText;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IQQTextApi
    public float measureNickNameQQText(@NotNull CharSequence content, int emoSize) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Float) iPatchRedirector.redirect((short) 7, (Object) this, (Object) content, emoSize)).floatValue();
        }
        Intrinsics.checkNotNullParameter(content, "content");
        Paint paint = new Paint();
        paint.setTextSize(BaseApplication.context.getResources().getDimension(R.dimen.f158235c01));
        if (content instanceof QQText) {
            String purePlainText = ((QQText) content).toPurePlainText();
            return paint.measureText(purePlainText, 0, purePlainText.length()) + (r4.mSpanCount * ViewUtils.dpToPx(13.0f));
        }
        return paint.measureText(content, 0, content.length());
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IQQTextApi
    public void setBizSrc(@NotNull CharSequence content, @NotNull String src) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) content, (Object) src);
            return;
        }
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(src, "src");
        if (content instanceof QQText) {
            ((QQText) content).setBizSrc(src);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IQQTextApi
    @NotNull
    public CharSequence toPlainText(@NotNull CharSequence content, int flags) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CharSequence) iPatchRedirector.redirect((short) 3, (Object) this, (Object) content, flags);
        }
        Intrinsics.checkNotNullParameter(content, "content");
        String plainText = new QQText(content, flags).toPlainText(false);
        Intrinsics.checkNotNullExpressionValue(plainText, "QQText(content, flags).toPlainText(false)");
        return plainText;
    }
}

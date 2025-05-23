package com.tencent.qqnt.emotion.adapter.api.impl;

import android.content.Context;
import android.os.Parcelable;
import android.widget.EditText;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticon.StickerInfo;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.emotion.adapter.api.IPicEmoticonInfoSenderApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J:\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016JH\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J.\u0010\u0017\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/emotion/adapter/api/impl/PicEmoticonInfoSenderApiNtImpl;", "Lcom/tencent/qqnt/emotion/adapter/api/IPicEmoticonInfoSenderApi;", "()V", "send", "", "runtime", "Lmqq/app/AppRuntime;", "context", "Landroid/content/Context;", "sessionInfoParcelable", "Landroid/os/Parcelable;", "emoticon", "Lcom/tencent/mobileqq/data/Emoticon;", "stickerInfo", "Lcom/tencent/mobileqq/emoticon/StickerInfo;", "input", "Landroid/widget/EditText;", "isFroward", "", "forwardID", "", "picEmoticonInfo", "Lcom/tencent/mobileqq/emoticonview/PicEmoticonInfo;", "sendFromGuild", "app", "sessionInfo", "emotion_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
public final class PicEmoticonInfoSenderApiNtImpl implements IPicEmoticonInfoSenderApi {
    static IPatchRedirector $redirector_;

    public PicEmoticonInfoSenderApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.emotion.adapter.api.IPicEmoticonInfoSenderApi
    public void send(@Nullable AppRuntime runtime, @Nullable Context context, @Nullable Parcelable sessionInfoParcelable, @Nullable Emoticon emoticon, @Nullable StickerInfo stickerInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, runtime, context, sessionInfoParcelable, emoticon, stickerInfo);
    }

    @Override // com.tencent.qqnt.emotion.adapter.api.IPicEmoticonInfoSenderApi
    public void sendFromGuild(@Nullable AppRuntime app, @Nullable Context context, @Nullable Parcelable sessionInfo, @NotNull PicEmoticonInfo picEmoticonInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, app, context, sessionInfo, picEmoticonInfo);
        } else {
            Intrinsics.checkNotNullParameter(picEmoticonInfo, "picEmoticonInfo");
        }
    }

    @Override // com.tencent.qqnt.emotion.adapter.api.IPicEmoticonInfoSenderApi
    public void send(@Nullable AppRuntime runtime, @Nullable Context context, @Nullable EditText input, @Nullable Parcelable sessionInfoParcelable, boolean isFroward, int forwardID, @NotNull PicEmoticonInfo picEmoticonInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            Intrinsics.checkNotNullParameter(picEmoticonInfo, "picEmoticonInfo");
        } else {
            iPatchRedirector.redirect((short) 2, this, runtime, context, input, sessionInfoParcelable, Boolean.valueOf(isFroward), Integer.valueOf(forwardID), picEmoticonInfo);
        }
    }
}

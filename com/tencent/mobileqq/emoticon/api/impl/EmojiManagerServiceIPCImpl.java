package com.tencent.mobileqq.emoticon.api.impl;

import com.tencent.mobileqq.emoticon.api.IEmojiManagerServiceIPC;
import com.tencent.mobileqq.emoticon.api.impl.EmojiManagerServiceIPC;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J.\u0010\f\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/emoticon/api/impl/EmojiManagerServiceIPCImpl;", "Lcom/tencent/mobileqq/emoticon/api/IEmojiManagerServiceIPC;", "Lcom/tencent/mobileqq/qipc/QIPCModule;", "createModule", "", "emojiId", "emojiPkgId", "", UIJsPlugin.EVENT_SHOW_TOAST, "Lcom/tencent/mobileqq/emoticon/api/IEmojiManagerServiceIPC$AddMarketEmoticonToFavoriteCallback;", "callback", "", "addMarketEmoticonToFavorite", "<init>", "()V", "Companion", "a", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class EmojiManagerServiceIPCImpl implements IEmojiManagerServiceIPC {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "EmojiManagerServiceQIPC";

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/emoticon/api/impl/EmojiManagerServiceIPCImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.emoticon.api.impl.EmojiManagerServiceIPCImpl$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19391);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public EmojiManagerServiceIPCImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.emoticon.api.IEmojiManagerServiceIPC
    public void addMarketEmoticonToFavorite(@Nullable String emojiId, @Nullable String emojiPkgId, boolean showToast, @Nullable final IEmojiManagerServiceIPC.AddMarketEmoticonToFavoriteCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, emojiId, emojiPkgId, Boolean.valueOf(showToast), callback);
            return;
        }
        if (emojiId != null && emojiPkgId != null) {
            EmojiManagerServiceIPC.AddMarketEmoticonToFavorite.INSTANCE.b(emojiId, emojiPkgId, showToast, new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.emoticon.api.impl.EmojiManagerServiceIPCImpl$addMarketEmoticonToFavorite$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) IEmojiManagerServiceIPC.AddMarketEmoticonToFavoriteCallback.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                        return;
                    }
                    IEmojiManagerServiceIPC.AddMarketEmoticonToFavoriteCallback addMarketEmoticonToFavoriteCallback = IEmojiManagerServiceIPC.AddMarketEmoticonToFavoriteCallback.this;
                    if (addMarketEmoticonToFavoriteCallback != null) {
                        addMarketEmoticonToFavoriteCallback.onResult(i3);
                    }
                }
            });
            return;
        }
        QLog.w("EmojiManagerServiceQIPC", 1, "invalid args");
        if (callback != null) {
            callback.onResult(-1);
        }
    }

    @Override // com.tencent.mobileqq.emoticon.api.IEmojiManagerServiceIPC
    @NotNull
    public QIPCModule createModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (QIPCModule) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return EmojiManagerServiceIPC.INSTANCE.a();
    }
}

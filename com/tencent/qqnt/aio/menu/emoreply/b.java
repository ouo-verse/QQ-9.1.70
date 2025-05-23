package com.tencent.qqnt.aio.menu.emoreply;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emoticonview.EmotionPanelData;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J8\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/aio/menu/emoreply/b;", "", "", "columnNum", "Lcom/tencent/mobileqq/emoticonview/SystemAndEmojiEmoticonInfo$EmoticonParams;", "params", "", "Lcom/tencent/mobileqq/emoticonview/EmotionPanelData;", "customData", "Lcom/tencent/qqnt/aio/menu/emoreply/c;", "filter", "Lcom/tencent/qqnt/aio/menu/emoreply/d;", "callback", "", "b", "<init>", "()V", "aio-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f351341a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33525);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f351341a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(int i3, SystemAndEmojiEmoticonInfo.EmoticonParams params, List customData, c cVar, d callback) {
        Intrinsics.checkNotNullParameter(params, "$params");
        Intrinsics.checkNotNullParameter(customData, "$customData");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        List<EmotionPanelData> resultEmoReplyMoreList = SystemAndEmojiEmoticonInfo.getRecentEmoticonPanelData(false, i3, params, customData);
        if (cVar != null) {
            Intrinsics.checkNotNullExpressionValue(resultEmoReplyMoreList, "emoReplyMoreList");
            List<EmotionPanelData> a16 = cVar.a(resultEmoReplyMoreList, i3);
            if (a16 != null) {
                resultEmoReplyMoreList = a16;
            }
        }
        Intrinsics.checkNotNullExpressionValue(resultEmoReplyMoreList, "resultEmoReplyMoreList");
        callback.a(resultEmoReplyMoreList);
    }

    public final void b(final int columnNum, @NotNull final SystemAndEmojiEmoticonInfo.EmoticonParams params, @NotNull final List<? extends EmotionPanelData> customData, @Nullable final c filter, @NotNull final d callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(columnNum), params, customData, filter, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(customData, "customData");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.menu.emoreply.a
            @Override // java.lang.Runnable
            public final void run() {
                b.c(columnNum, params, customData, filter, callback);
            }
        }, 16, null, true);
    }
}

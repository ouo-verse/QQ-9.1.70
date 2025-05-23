package com.tencent.qqnt.emotion.text;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.ISpanRefreshCallback;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqnt.aio.adapter.api.IQQTextApi;
import com.tencent.qqnt.emotion.text.style.api.IEmojiSpanService;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J<\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u0006H\u0002J$\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J8\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0006\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/emotion/text/b;", "", "", "faceType", "faceIndex", "emoSize", "", "isAnim", "Lcom/tencent/mobileqq/text/ISpanRefreshCallback;", "callback", "onlySysFace", "", "d", NodeProps.CUSTOM_PROP_IMAGE_TYPE, "b", "isOnlySysFace", "a", "<init>", "()V", "emotion_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f356678a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31714);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f356678a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final CharSequence b(int faceIndex, int imageType, ISpanRefreshCallback callback) {
        a aVar = a.f356677a;
        return ((IEmojiSpanService) QRoute.api(IEmojiSpanService.class)).parseSmallEmo(aVar.c(faceIndex), aVar.b(faceIndex), imageType);
    }

    static /* synthetic */ CharSequence c(b bVar, int i3, int i16, ISpanRefreshCallback iSpanRefreshCallback, int i17, Object obj) {
        if ((i17 & 4) != 0) {
            iSpanRefreshCallback = null;
        }
        return bVar.b(i3, i16, iSpanRefreshCallback);
    }

    private final CharSequence d(int faceType, int faceIndex, int emoSize, boolean isAnim, ISpanRefreshCallback callback, boolean onlySysFace) {
        int i3;
        IEmojiSpanService iEmojiSpanService = (IEmojiSpanService) QRoute.api(IEmojiSpanService.class);
        if (onlySysFace) {
            faceType = 1;
        }
        String convertEmoServerIdToEmoCode = iEmojiSpanService.convertEmoServerIdToEmoCode(faceIndex, faceType);
        if (isAnim) {
            i3 = 5;
        } else {
            i3 = 3;
        }
        return IQQTextApi.a.c((IQQTextApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IQQTextApi.class), convertEmoServerIdToEmoCode, i3, emoSize, null, null, 24, null);
    }

    static /* synthetic */ CharSequence e(b bVar, int i3, int i16, int i17, boolean z16, ISpanRefreshCallback iSpanRefreshCallback, boolean z17, int i18, Object obj) {
        if ((i18 & 16) != 0) {
            iSpanRefreshCallback = null;
        }
        return bVar.d(i3, i16, i17, z16, iSpanRefreshCallback, z17);
    }

    @NotNull
    public final CharSequence a(int faceType, int faceIndex, int emoSize, boolean isAnim, int imageType, boolean isOnlySysFace) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CharSequence) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(faceType), Integer.valueOf(faceIndex), Integer.valueOf(emoSize), Boolean.valueOf(isAnim), Integer.valueOf(imageType), Boolean.valueOf(isOnlySysFace));
        }
        if (faceType == 4) {
            return c(this, faceIndex, imageType, null, 4, null);
        }
        return e(this, faceType, faceIndex, emoSize, isAnim, null, isOnlySysFace, 16, null);
    }
}

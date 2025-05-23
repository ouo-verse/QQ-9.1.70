package com.tencent.aio.stranger.impl.shortcut;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/aio/stranger/impl/shortcut/e;", "Lcom/tencent/qqnt/aio/shortcutbar/c;", "", "chatType", "", "peerUid", "", "Lcom/tencent/qqnt/aio/shortcutbar/a;", "a", "<init>", "()V", "aio_stranger_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class e extends com.tencent.qqnt.aio.shortcutbar.c {
    static IPatchRedirector $redirector_;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.shortcutbar.c, com.tencent.qqnt.aio.shortcutbar.e
    @NotNull
    public List<com.tencent.qqnt.aio.shortcutbar.a> a(int chatType, @NotNull String peerUid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, chatType, (Object) peerUid);
        }
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        boolean b16 = com.tencent.aio.stranger.a.f69857a.b();
        ArrayList arrayList = new ArrayList();
        if (b16) {
            int[] AIO_PANEL_AUDIO = com.tencent.qqnt.aio.shortcutbar.b.f352101a;
            Intrinsics.checkNotNullExpressionValue(AIO_PANEL_AUDIO, "AIO_PANEL_AUDIO");
            arrayList.add(b(AIO_PANEL_AUDIO));
            int[] AIO_PANEL_FILE = com.tencent.qqnt.aio.shortcutbar.b.f352110j;
            Intrinsics.checkNotNullExpressionValue(AIO_PANEL_FILE, "AIO_PANEL_FILE");
            arrayList.add(b(AIO_PANEL_FILE));
        }
        int[] AIO_PANEL_PHOTOLIST = com.tencent.qqnt.aio.shortcutbar.b.f352102b;
        Intrinsics.checkNotNullExpressionValue(AIO_PANEL_PHOTOLIST, "AIO_PANEL_PHOTOLIST");
        arrayList.add(b(AIO_PANEL_PHOTOLIST));
        int[] AIO_PANEL_CAMERA = com.tencent.qqnt.aio.shortcutbar.b.f352103c;
        Intrinsics.checkNotNullExpressionValue(AIO_PANEL_CAMERA, "AIO_PANEL_CAMERA");
        arrayList.add(b(AIO_PANEL_CAMERA));
        int[] AIO_PANEL_EMOTICON = com.tencent.qqnt.aio.shortcutbar.b.f352105e;
        Intrinsics.checkNotNullExpressionValue(AIO_PANEL_EMOTICON, "AIO_PANEL_EMOTICON");
        arrayList.add(b(AIO_PANEL_EMOTICON));
        return arrayList;
    }
}

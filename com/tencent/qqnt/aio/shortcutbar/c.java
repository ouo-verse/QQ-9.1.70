package com.tencent.qqnt.aio.shortcutbar;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0004R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/aio/shortcutbar/c;", "Lcom/tencent/qqnt/aio/shortcutbar/e;", "", "chatType", "", "peerUid", "", "Lcom/tencent/qqnt/aio/shortcutbar/a;", "a", "", "data", "b", "Ljava/util/List;", "mDefaultItemList", "<init>", "()V", "aio_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public class c implements e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<a> mDefaultItemList;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        ArrayList arrayList = new ArrayList();
        int[] AIO_PANEL_AUDIO = b.f352101a;
        Intrinsics.checkNotNullExpressionValue(AIO_PANEL_AUDIO, "AIO_PANEL_AUDIO");
        arrayList.add(b(AIO_PANEL_AUDIO));
        int[] AIO_PANEL_PHOTOLIST = b.f352102b;
        Intrinsics.checkNotNullExpressionValue(AIO_PANEL_PHOTOLIST, "AIO_PANEL_PHOTOLIST");
        arrayList.add(b(AIO_PANEL_PHOTOLIST));
        int[] AIO_PANEL_CAMERA = b.f352103c;
        Intrinsics.checkNotNullExpressionValue(AIO_PANEL_CAMERA, "AIO_PANEL_CAMERA");
        arrayList.add(b(AIO_PANEL_CAMERA));
        int[] AIO_PANEL_HONGBAO = b.f352104d;
        Intrinsics.checkNotNullExpressionValue(AIO_PANEL_HONGBAO, "AIO_PANEL_HONGBAO");
        arrayList.add(b(AIO_PANEL_HONGBAO));
        int[] AIO_PANEL_EMOTICON = b.f352105e;
        Intrinsics.checkNotNullExpressionValue(AIO_PANEL_EMOTICON, "AIO_PANEL_EMOTICON");
        arrayList.add(b(AIO_PANEL_EMOTICON));
        int[] AIO_PANEL_PLUS = b.f352106f;
        Intrinsics.checkNotNullExpressionValue(AIO_PANEL_PLUS, "AIO_PANEL_PLUS");
        arrayList.add(b(AIO_PANEL_PLUS));
        if (com.tencent.qqnt.util.b.f362976b.isDebugVersion()) {
            int[] AIO_DEBUG_PANEL = b.f352107g;
            Intrinsics.checkNotNullExpressionValue(AIO_DEBUG_PANEL, "AIO_DEBUG_PANEL");
            arrayList.add(b(AIO_DEBUG_PANEL));
        }
        this.mDefaultItemList = arrayList;
    }

    @Override // com.tencent.qqnt.aio.shortcutbar.e
    @NotNull
    public List<a> a(int chatType, @NotNull String peerUid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, chatType, (Object) peerUid);
        }
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        return this.mDefaultItemList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final a b(@NotNull int[] data) {
        Drawable drawable;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) data);
        }
        Intrinsics.checkNotNullParameter(data, "data");
        String str2 = "";
        int i3 = 0;
        try {
            i3 = data[0];
            str = MobileQQ.sMobileQQ.getResources().getString(data[1]);
            Intrinsics.checkNotNullExpressionValue(str, "sMobileQQ.resources.getString(data[1])");
        } catch (Exception e16) {
            e = e16;
        }
        try {
            drawable = MobileQQ.sMobileQQ.getResources().getDrawable(data[2]);
        } catch (Exception e17) {
            e = e17;
            str2 = str;
            QLog.e("BasePanelBarLoader", 1, "createPanelIconItem Exception", e);
            drawable = null;
            str = str2;
            return new a(i3, str, drawable);
        }
        return new a(i3, str, drawable);
    }
}

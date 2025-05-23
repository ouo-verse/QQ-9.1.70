package com.tencent.qqnt.qbasealbum.album.repository;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.query.VideoCursor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/album/repository/PickerVideoCursor;", "Lcom/tencent/qqnt/qbasealbum/query/VideoCursor;", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "info", "", DomainData.DOMAIN_NAME, "Landroid/content/Context;", "context", "", "albumId", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class PickerVideoCursor extends VideoCursor {
    static IPatchRedirector $redirector_;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PickerVideoCursor(@NotNull Context context, @Nullable String str) {
        super(context, str);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.qbasealbum.query.ICursor
    public boolean n(@NotNull final LocalMediaInfo info) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) info)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(info, "info");
        if (super.n(info) && com.tencent.qqnt.qbasealbum.ktx.b.f(info) > 0 && info.getMediaWidth() > 0 && info.getMediaHeight() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            ox3.a.a("QBaseAlbum.MediaQuery", new Function0<String>() { // from class: com.tencent.qqnt.qbasealbum.album.repository.PickerVideoCursor$needMediaInfo$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LocalMediaInfo.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    return "video, duration=" + com.tencent.qqnt.qbasealbum.ktx.b.f(LocalMediaInfo.this) + ", height=" + LocalMediaInfo.this.getMediaHeight() + ", width=" + LocalMediaInfo.this.getMediaWidth() + ", path=" + LocalMediaInfo.this.getPath();
                }
            });
        }
        return z16;
    }
}

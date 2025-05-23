package ba2;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lba2/c;", "Lcom/tencent/qqnt/aio/shortcutbar/c;", "", "chatType", "", "peerUid", "", "Lcom/tencent/qqnt/aio/shortcutbar/a;", "a", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class c extends com.tencent.qqnt.aio.shortcutbar.c {
    @Override // com.tencent.qqnt.aio.shortcutbar.c, com.tencent.qqnt.aio.shortcutbar.e
    @NotNull
    public List<com.tencent.qqnt.aio.shortcutbar.a> a(int chatType, @NotNull String peerUid) {
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        ArrayList arrayList = new ArrayList();
        int[] AIO_PANEL_TEMP_SESSION_HOT_PIC = com.tencent.qqnt.aio.shortcutbar.b.f352108h;
        Intrinsics.checkNotNullExpressionValue(AIO_PANEL_TEMP_SESSION_HOT_PIC, "AIO_PANEL_TEMP_SESSION_HOT_PIC");
        arrayList.add(b(AIO_PANEL_TEMP_SESSION_HOT_PIC));
        int[] AIO_PANEL_EMOTICON = com.tencent.qqnt.aio.shortcutbar.b.f352105e;
        Intrinsics.checkNotNullExpressionValue(AIO_PANEL_EMOTICON, "AIO_PANEL_EMOTICON");
        arrayList.add(b(AIO_PANEL_EMOTICON));
        return arrayList;
    }
}

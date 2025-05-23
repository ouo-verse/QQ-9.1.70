package gm1;

import fm1.i;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0000*\f\u0012\u0004\u0012\u00020\u00010\u0000j\u0002`\u0002H\u0002*\u0018\b\u0002\u0010\u0006\"\b\u0012\u0004\u0012\u00020\u00050\u00002\b\u0012\u0004\u0012\u00020\u00050\u0000*\u0018\b\u0002\u0010\u0007\"\b\u0012\u0004\u0012\u00020\u00010\u00002\b\u0012\u0004\u0012\u00020\u00010\u0000\u00a8\u0006\b"}, d2 = {"", "Lfm1/i;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/datadelegate/PreviewMediaList;", "Lfm1/c;", "b", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "LocalMediaList", "PreviewMediaList", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b {
    /* JADX INFO: Access modifiers changed from: private */
    public static final List<fm1.c> b(List<? extends i> list) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((i) obj).f()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}

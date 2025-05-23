package com.tencent.sqshow.zootopia.publish;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J.\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/sqshow/zootopia/publish/a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "", "publishSource", "Landroid/os/Bundle;", "bundle", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public interface a {
    void a(Context context, ZootopiaSource source, String publishSource, Bundle bundle);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.sqshow.zootopia.publish.a$a, reason: collision with other inner class name */
    /* loaded from: classes34.dex */
    public static final class C9834a {
        public static /* synthetic */ void a(a aVar, Context context, ZootopiaSource zootopiaSource, String str, Bundle bundle, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    str = ZPlanPublishSource.FROM_DRESS_SQUARE_TITLE;
                }
                if ((i3 & 8) != 0) {
                    bundle = null;
                }
                aVar.a(context, zootopiaSource, str, bundle);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openSelectContentPage");
        }
    }
}

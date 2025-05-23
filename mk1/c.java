package mk1;

import android.graphics.Bitmap;
import androidx.collection.LruCache;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.guild.util.Logger;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0004R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lmk1/c;", "", "Lcom/tencent/libra/request/Option;", "option", "", "a", "c", "b", "Landroidx/collection/LruCache;", "", "Landroidx/collection/LruCache;", "optionList", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LruCache<String, Option> optionList = new LruCache<>(8);

    public final void a(@NotNull Option option) {
        Intrinsics.checkNotNullParameter(option, "option");
        this.optionList.put(option.getUrl(), option);
    }

    public final void b() {
        for (Option option : this.optionList.snapshot().values()) {
            com.tencent.mobileqq.guild.picload.e.a().h(option);
            try {
                Bitmap resultBitMap = option.getResultBitMap();
                if (resultBitMap != null) {
                    resultBitMap.recycle();
                }
                option.setResultBitMap(null);
            } catch (Throwable th5) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str = "notifyRecycle recycle bitmap error! " + th5;
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("Guild_Feed_GAL_GuildFeedGalleryOptionCache", 1, (String) it.next(), th5);
                }
            }
        }
        this.optionList.evictAll();
    }

    public final void c(@NotNull Option option) {
        Intrinsics.checkNotNullParameter(option, "option");
        this.optionList.remove(option.getUrl());
    }
}

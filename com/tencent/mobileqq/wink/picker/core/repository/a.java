package com.tencent.mobileqq.wink.picker.core.repository;

import e93.QZoneAlbumInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 \u000f2\u00020\u0001:\u0002\t\u000fB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ4\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006H&R\u0018\u0010\f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/repository/a;", "", "", "albumId", "", "mediaNum", "", "payload", "", "a", "Lcom/tencent/mobileqq/wink/picker/core/repository/a$b;", "Lcom/tencent/mobileqq/wink/picker/core/repository/a$b;", "mediaQueryListener", "<init>", "()V", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @Nullable
    public b mediaQueryListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/repository/a$b;", "", "Le93/j;", "qZoneAlbumInfo", "", "a", "Lcom/tencent/mobileqq/wink/picker/core/repository/b;", "mediaRepoData", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface b {
        void a(@NotNull QZoneAlbumInfo qZoneAlbumInfo);

        void b(@NotNull com.tencent.mobileqq.wink.picker.core.repository.b mediaRepoData);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void b(a aVar, String str, int i3, Map map, int i16, Object obj) {
        if (obj == null) {
            if ((i16 & 1) != 0) {
                str = "";
            }
            if ((i16 & 2) != 0) {
                i3 = 100;
            }
            if ((i16 & 4) != 0) {
                map = null;
            }
            aVar.a(str, i3, map);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryMediaNext");
    }

    public abstract void a(@NotNull String albumId, int mediaNum, @Nullable Map<String, Object> payload);
}

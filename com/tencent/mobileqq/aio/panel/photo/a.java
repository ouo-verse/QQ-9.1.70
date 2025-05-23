package com.tencent.mobileqq.aio.panel.photo;

import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\nH&J\b\u0010\f\u001a\u00020\u0004H&J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\rH&J\b\u0010\u000f\u001a\u00020\bH&J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\bH&J\b\u0010\u0012\u001a\u00020\u0004H&J\b\u0010\u0013\u001a\u00020\u0004H&J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H&J$\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u0018j\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0014`\u0019H&J\b\u0010\u001b\u001a\u00020\u0004H&\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/aio/panel/photo/a;", "", "Lcom/tencent/mobileqq/aio/panel/photo/g;", "intent", "", "v0", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "mediainfo", "", "e0", "", "E0", "f0", "", "K", "m0", "isChecked", "w", "t", "f", "", "originPath", "editPath", "X0", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "H", "u", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public interface a {
    @NotNull
    List<LocalMediaInfo> E0();

    @NotNull
    HashMap<String, String> H();

    @NotNull
    List<LocalMediaInfo> K();

    void X0(@NotNull String originPath, @NotNull String editPath);

    boolean e0(@NotNull LocalMediaInfo mediainfo);

    void f();

    void f0();

    boolean m0();

    void t();

    void u();

    void v0(@NotNull g intent);

    void w(boolean isChecked);
}

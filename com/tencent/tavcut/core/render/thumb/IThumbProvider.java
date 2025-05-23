package com.tencent.tavcut.core.render.thumb;

import android.graphics.Bitmap;
import androidx.annotation.WorkerThread;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'JJ\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u000528\u0010\b\u001a4\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00070\tH&JP\u0010\u000e\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f28\u0010\b\u001a4\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00070\tH&J\b\u0010\u0010\u001a\u00020\u0007H'J\b\u0010\u0011\u001a\u00020\u0007H&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/tavcut/core/render/thumb/IThumbProvider;", "", "getThumbAtTime", "Landroid/graphics/Bitmap;", "atTimeUs", "", "getThumbAtTimeAsync", "", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", MimeHelper.IMAGE_SUBTYPE_BITMAP, "actualTime", "getThumbAtTimesAsync", "", "init", "release", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public interface IThumbProvider {
    @WorkerThread
    @Nullable
    Bitmap getThumbAtTime(long atTimeUs);

    void getThumbAtTimeAsync(long atTimeUs, @NotNull Function2<? super Bitmap, ? super Long, Unit> callback);

    void getThumbAtTimesAsync(@NotNull List<Long> atTimeUs, @NotNull Function2<? super Bitmap, ? super Long, Unit> callback);

    @WorkerThread
    void init();

    void release();
}

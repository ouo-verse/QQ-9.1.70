package com.tencent.mobileqq.wink.picker.interceptor;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.wink.picker.MediaPickerInput;
import com.tencent.mobileqq.wink.picker.MediaPickerOutput;
import com.tencent.mobileqq.wink.picker.MediaPickerScene;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0007J\b\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/interceptor/c;", "", "", "name", "Lcom/tencent/mobileqq/wink/picker/interceptor/c$a;", "chain", "Lcom/tencent/mobileqq/wink/picker/b;", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public interface c {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\u0002H&J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&J\b\u0010\r\u001a\u00020\fH&J\b\u0010\u000f\u001a\u00020\u000eH&J\b\u0010\u0011\u001a\u00020\u0010H&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/interceptor/c$a;", "", "Lcom/tencent/mobileqq/wink/picker/a;", "mediaPickerInput", "Lcom/tencent/mobileqq/wink/picker/b;", "f", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isRunning", "d", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "e", "Lcom/tencent/mobileqq/wink/picker/MediaPickerScene;", "a", "", "c", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/b;", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface a {
        @NotNull
        MediaPickerScene a();

        @NotNull
        com.tencent.mobileqq.wink.picker.core.viewmodel.b b();

        boolean c();

        @NotNull
        MediaPickerInput d();

        @NotNull
        List<LocalMediaInfo> e();

        @NotNull
        MediaPickerOutput f(@NotNull MediaPickerInput mediaPickerInput);

        @NotNull
        AtomicBoolean isRunning();
    }

    @Nullable
    MediaPickerOutput a(@NotNull a chain) throws InterruptedException;

    @NotNull
    String name();
}

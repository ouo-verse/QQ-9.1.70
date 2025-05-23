package com.tencent.qqnt.biz.lightbusiness.lightinteraction;

import android.graphics.Bitmap;
import android.view.View;
import androidx.annotation.UiThread;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/b;", "", "Landroid/view/View;", "cover", "", "b", "Landroid/graphics/Bitmap;", "icon", "a", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/b$a;", "listener", "setOnAnimActionListener", "light_business_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public interface b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/b$a;", "", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/b;", "anim", "", "a", "b", "light_business_kit_release"}, k = 1, mv = {1, 7, 1})
    @UiThread
    /* loaded from: classes23.dex */
    public interface a {
        void a(@NotNull b anim);

        void b(@NotNull b anim);
    }

    void a(@Nullable Bitmap icon);

    void b(@Nullable View cover);

    void setOnAnimActionListener(@Nullable a listener);
}

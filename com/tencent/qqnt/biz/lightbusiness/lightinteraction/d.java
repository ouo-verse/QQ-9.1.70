package com.tencent.qqnt.biz.lightbusiness.lightinteraction;

import android.graphics.drawable.Drawable;
import androidx.annotation.UiThread;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H'J\b\u0010\b\u001a\u00020\u0006H'\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/d;", "", "Landroid/graphics/drawable/Drawable;", "iconDrawable", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/bean/b;", "res", "", "a", "onFail", "light_business_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public interface d {
    @UiThread
    void a(@NotNull Drawable iconDrawable, @NotNull com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.b res);

    @UiThread
    void onFail();
}

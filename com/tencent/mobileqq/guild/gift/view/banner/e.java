package com.tencent.mobileqq.guild.gift.view.banner;

import android.view.LayoutInflater;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&J\b\u0010\r\u001a\u00020\bH&J\b\u0010\u000e\u001a\u00020\bH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/gift/view/banner/e;", "", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/View;", "a", "Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/a;", "data", "", "c", "", "contentViewY", "b", "t", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface e {
    @NotNull
    View a(@NotNull LayoutInflater inflater);

    void b(float contentViewY);

    void c(@NotNull com.tencent.mobileqq.qqgift.mvvm.business.anim.a data);

    void onDestroy();

    void t();
}

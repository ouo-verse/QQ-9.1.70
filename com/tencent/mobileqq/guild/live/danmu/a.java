package com.tencent.mobileqq.guild.live.danmu;

import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&J\b\u0010\r\u001a\u00020\u0006H&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/live/danmu/a;", "", "Landroidx/fragment/app/Fragment;", "fragment", "Landroid/widget/FrameLayout;", ParseCommon.CONTAINER, "", "b", "", "type", "Lcom/tencent/mobileqq/guild/live/danmu/item/a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "a", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public interface a {
    void a(int type, @NotNull com.tencent.mobileqq.guild.live.danmu.item.a item);

    void b(@NotNull Fragment fragment, @NotNull FrameLayout container);

    void c();
}

package com.tencent.mobileqq.guild.gift.module;

import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\u0006H&J\u0019\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH&\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\r\u001a\u0004\u0018\u00010\tH&\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0010\u001a\u00020\u000fH&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/gift/module/f;", "", "Lcom/tencent/mobileqq/guild/gift/module/ShowPanelTab;", "tab", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "d", "hide", "", "receiverId", "setReceiver", "(Ljava/lang/Long;)V", "c", "()Ljava/lang/Long;", "", "v", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface f {
    @Nullable
    Long c();

    void d(@NotNull ShowPanelTab tab, @NotNull FragmentActivity activity);

    void hide();

    void setReceiver(@Nullable Long receiverId);

    int v();
}

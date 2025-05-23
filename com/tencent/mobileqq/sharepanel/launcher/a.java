package com.tencent.mobileqq.sharepanel.launcher;

import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\u0006H&J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/launcher/a;", "", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/sharepanel/launcher/SharePanelParam;", "param", "", "a", "dismiss", "Lcom/tencent/mobileqq/sharepanel/launcher/ShareActionDynamicModifier;", "modifier", "b", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public interface a {
    void a(@NotNull FragmentActivity activity, @NotNull SharePanelParam param);

    void b(@NotNull ShareActionDynamicModifier modifier);

    void dismiss();
}

package com.tencent.guild.api.wallet;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&J\n\u0010\n\u001a\u0004\u0018\u00010\tH&J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\rH&J\b\u0010\u000f\u001a\u00020\u0004H&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/guild/api/wallet/a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "c", "", WadlProxyConsts.KEY_JUMP_URL, "e", "Landroid/view/View;", "getBackground", "Landroid/widget/TextView;", "a", "", "d", "b", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public interface a {
    @Nullable
    TextView a();

    void b();

    void c(@NotNull Activity activity);

    @NotNull
    List<String> d();

    void e(@NotNull Activity activity, @NotNull String jumpUrl);

    @Nullable
    View getBackground();
}

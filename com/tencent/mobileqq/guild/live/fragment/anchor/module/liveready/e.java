package com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready;

import android.content.Intent;
import com.tencent.bugly.common.constants.Constants;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H&J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/live/fragment/anchor/module/liveready/e;", "", "", "isFirstCreate", "", "onSelected", "d6", "", "requestCode", QzoneIPCModule.RESULT_CODE, Constants.USER_SET_DEVICE_ID, "Landroid/content/Intent;", "intent", "Sb", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public interface e {
    void E8(int requestCode, int resultCode);

    void Sb(@NotNull Intent intent);

    void d6();

    void onSelected(boolean isFirstCreate);
}

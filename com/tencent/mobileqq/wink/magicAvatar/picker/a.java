package com.tencent.mobileqq.wink.magicAvatar.picker;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\"\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH&J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH&J\b\u0010\u0011\u001a\u00020\fH&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/wink/magicAvatar/picker/a;", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "mediaInfo", "", "Ze", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onReceiveActivityResult", "", "P5", "Landroidx/fragment/app/Fragment;", "fragment", "hg", "onBackEvent", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public interface a {
    boolean P5(int requestCode);

    void Ze(@NotNull LocalMediaInfo mediaInfo);

    void hg(@NotNull Fragment fragment);

    boolean onBackEvent();

    void onReceiveActivityResult(int requestCode, int resultCode, @Nullable Intent data);
}

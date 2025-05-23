package com.tencent.mobileqq.guild.feed.nativedetail.bottom.input;

import android.content.Intent;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JA\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH&\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/b;", "", "", "content", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/i;", "inputArgs", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", AEEditorConstants.KEY_WINK_LOCAL_MEDIA_INFOS, "", "originalPic", "", "b", "(Ljava/lang/String;Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/i;Ljava/util/ArrayList;Ljava/lang/Boolean;)V", "Landroid/content/Intent;", "intent", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface b {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class a {
        public static boolean a(@NotNull b bVar, @NotNull Intent intent) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            return false;
        }
    }

    boolean a(@NotNull Intent intent);

    void b(@Nullable String content, @Nullable ShowInputComponentArgs inputArgs, @Nullable ArrayList<LocalMediaInfo> localMediaInfos, @Nullable Boolean originalPic);
}

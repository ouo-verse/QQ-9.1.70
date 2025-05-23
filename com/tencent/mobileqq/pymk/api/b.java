package com.tencent.mobileqq.pymk.api;

import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J$\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\r\u001a\u0004\u0018\u00010\fH&J\b\u0010\u000f\u001a\u00020\u0006H&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/pymk/api/b;", "", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/mobileqq/data/MayKnowRecommend;", "recommendData", "Lkotlin/Function0;", "", "callback", "b", "Landroid/view/View;", "pymkItem", "recFriendData", "Landroid/os/Bundle;", "extras", "a", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "base_proj_ext_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public interface b {
    void a(@NotNull View pymkItem, @Nullable MayKnowRecommend recFriendData, @Nullable Bundle extras);

    void b(@NotNull CopyOnWriteArrayList<MayKnowRecommend> recommendData, @NotNull Function0<Unit> callback);

    void onPause();
}

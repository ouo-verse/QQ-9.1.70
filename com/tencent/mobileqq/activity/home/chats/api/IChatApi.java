package com.tencent.mobileqq.activity.home.chats.api;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.activity.home.chats.NtBasePartFrame;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bg\u0018\u00002\u00020\u0001JH\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tH&J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H&J\u0018\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH'\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/activity/home/chats/api/IChatApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "createFrame", "Lcom/tencent/mobileqq/activity/home/chats/NtBasePartFrame;", "titlePart", "Lcom/tencent/biz/richframework/part/Part;", "chatListPart", "miniProgramPart", "bizPart", "", "priorityPart", "createPreloadRepo", "Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;", "scope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "jumpToGuildHelperFragment", "", "context", "Landroid/content/Context;", "jumpToTroopHelperFragment", "obtainScope", "fragmentActivity", "Landroidx/fragment/app/FragmentActivity;", "overrideActivityAnimation", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", BaseConstants.BROADCAST_USERSYNC_ENTER, "", "qqchat_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes10.dex */
public interface IChatApi extends QRouteApi {
    @Nullable
    NtBasePartFrame createFrame(@Nullable Part titlePart, @Nullable Part chatListPart, @Nullable Part miniProgramPart, @Nullable List<? extends Part> bizPart, @Nullable List<? extends Part> priorityPart);

    @NotNull
    IRecentContactRepo createPreloadRepo(@NotNull LifecycleCoroutineScope scope);

    void jumpToGuildHelperFragment(@NotNull Context context);

    void jumpToTroopHelperFragment(@NotNull Context context);

    @NotNull
    LifecycleCoroutineScope obtainScope(@NotNull FragmentActivity fragmentActivity);

    @Deprecated(message = "use QActivityAnimationUtil.setStartAnimation instead")
    void overrideActivityAnimation(@NotNull Activity activity, boolean enter);
}

package com.tencent.mobileqq.guild.profile.profilecard.baseprofile;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.event.GuildUserCardDismissEvent;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.GuildUserProfileCardFragment;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.GuildProfileCard;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u0018\u0010\r\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000bJ\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0012\u0010\u0018\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J$\u0010\u001c\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001a0\u0019j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001a`\u001bH\u0016\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/profilecard/baseprofile/GuildUserProfileCardFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/guild/event/GuildUserCardDismissEvent;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "color", "sh", "initWindowStyleAndAnimation", "", "needStatusTrans", "needImmersive", "onFinish", "Landroid/content/Context;", "context", "onAttach", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "p0", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildUserProfileCardFragment extends QPublicBaseFragment implements SimpleEventReceiver<GuildUserCardDismissEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/profilecard/baseprofile/GuildUserProfileCardFragment$a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/data/profilecard/GuildProfileData;", "profileData", "", "a", "", "EXTRA_PROFILE_DATA", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.profile.profilecard.baseprofile.GuildUserProfileCardFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@NotNull Context context, @NotNull GuildProfileData profileData) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(profileData, "profileData");
            Intent intent = new Intent();
            intent.putExtra("EXTRA_PROFILE_DATA", profileData);
            intent.putExtra("public_fragment_window_feature", 1);
            QPublicFragmentActivity.b.b(context, intent, QPublicTransFragmentActivity.class, GuildUserProfileCardFragment.class);
        }

        Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qh(GuildUserProfileCardFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @JvmStatic
    public static final void rh(@NotNull Context context, @NotNull GuildProfileData guildProfileData) {
        INSTANCE.a(context, guildProfileData);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<GuildUserCardDismissEvent>> getEventClass() {
        ArrayList<Class<GuildUserCardDismissEvent>> arrayList = new ArrayList<>();
        arrayList.add(GuildUserCardDismissEvent.class);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.initWindowStyleAndAnimation(activity);
        if (ImmersiveUtils.isSupporImmersive() != 0) {
            ImmersiveUtils.setTranslucentStatus(activity.getWindow());
        }
        sh(activity, 0);
        ImmersiveUtils.setStatusTextColor(false, activity.getWindow());
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        GuildProfileData guildProfileData;
        FragmentActivity activity;
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.finish();
                return;
            }
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            guildProfileData = (GuildProfileData) arguments.getParcelable("EXTRA_PROFILE_DATA");
        } else {
            guildProfileData = null;
        }
        if (!GuildProfileCard.Lh(getActivity(), guildProfileData) && (activity = getActivity()) != null) {
            activity.finish();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        super.onFinish();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.overridePendingTransition(0, 0);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent p06) {
        if (p06 instanceof GuildUserCardDismissEvent) {
            new Handler().postDelayed(new Runnable() { // from class: vv1.a
                @Override // java.lang.Runnable
                public final void run() {
                    GuildUserProfileCardFragment.qh(GuildUserProfileCardFragment.this);
                }
            }, 300L);
        }
    }

    public final void sh(@Nullable Activity activity, int color) {
        if (activity == null) {
            return;
        }
        Window window = activity.getWindow();
        window.clearFlags(67108864);
        window.getDecorView().setSystemUiVisibility(1280);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(color);
        window.setNavigationBarColor(color);
    }
}

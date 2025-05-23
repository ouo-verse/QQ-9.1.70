package com.tencent.mobileqq.guild.feed.topic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartFragmentIOCKt;
import com.tencent.biz.richframework.util.RFWNetworkUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedMiscApi;
import com.tencent.mobileqq.guild.feed.part.aw;
import com.tencent.mobileqq.guild.feed.topic.part.TopicInfoPart;
import com.tencent.mobileqq.guild.feed.topic.part.TopicPublishPart;
import com.tencent.mobileqq.guild.feed.topic.part.TopicReservePart;
import com.tencent.mobileqq.guild.feed.topic.part.TopicViewPagePart;
import com.tencent.mobileqq.guild.feed.topic.part.TopicVisitorJoinPart;
import com.tencent.mobileqq.guild.feed.topic.part.n;
import com.tencent.mobileqq.guild.feed.util.l;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.IGuildFastClickUtilApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 $2\u00020\u0001:\u0001%B\u0007\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\u001c\u0010\u000f\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0014J\b\u0010\u0015\u001a\u00020\u0006H\u0016R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/GuildTopicFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "ph", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "initWindowStyleAndAnimation", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Landroid/view/View;", "contentView", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onViewCreatedBeforePartInit", "needStatusTrans", "needImmersive", "isWrapContent", "", "getContentLayoutId", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/guild/feed/topic/e;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/feed/topic/e;", "topicSession", "Lcom/tencent/mobileqq/guild/feed/topic/a;", "D", "Lcom/tencent/mobileqq/guild/feed/topic/a;", "topicDepends", "Lcom/tencent/mobileqq/guild/feed/topic/b;", "E", "Lcom/tencent/mobileqq/guild/feed/topic/b;", "topicGlobalDepends", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildTopicFragment extends QPublicBaseFragment {

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private e topicSession;

    /* renamed from: D, reason: from kotlin metadata */
    private a topicDepends;

    /* renamed from: E, reason: from kotlin metadata */
    private b topicGlobalDepends;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/GuildTopicFragment$a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/feed/topic/TopicLaunchParams;", "launchIntent", "", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.topic.GuildTopicFragment$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull TopicLaunchParams launchIntent) {
            boolean z16;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(launchIntent, "launchIntent");
            if (((IGuildFastClickUtilApi) QRoute.api(IGuildFastClickUtilApi.class)).isFastClick("GTopic_GuildTopicFusionFragment")) {
                QLog.e("GTopic_GuildTopicFusionFragment", 1, "fastClick doNothing");
                return;
            }
            if (launchIntent.getTopicId() == 0) {
                QLog.e("GTopic_GuildTopicFusionFragment", 1, "topicId error!!");
                return;
            }
            String guildId = launchIntent.getGuildId();
            boolean z17 = false;
            if (guildId != null) {
                if (guildId.length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    z17 = true;
                }
            }
            if (z17) {
                QLog.e("GTopic_GuildTopicFusionFragment", 1, "guildId error!!");
                return;
            }
            if (!RFWNetworkUtils.isNetworkAvailable(context)) {
                QLog.e("GTopic_GuildTopicFusionFragment", 1, "network_error");
                QQToastUtil.showQQToast(1, R.string.cib);
                return;
            }
            QLog.i("GTopic_GuildTopicFusionFragment", 1, "[trace] launching... intent: " + launchIntent);
            Intent intent = new Intent();
            intent.putExtras(launchIntent.toBundle());
            intent.putExtra("public_fragment_window_feature", 1);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            ((IGuildFeedMiscApi) QRoute.api(IGuildFeedMiscApi.class)).initGuildTaskQueueManager();
            GuildSplitViewUtils.p(GuildSplitViewUtils.f235370a, context, intent, GuildTopicFragment.class, null, 8, null);
        }

        Companion() {
        }
    }

    private final boolean ph() {
        TopicLaunchParams a16 = TopicLaunchParams.INSTANCE.a(getArguments());
        if (a16 == null) {
            return false;
        }
        long topicId = a16.getTopicId();
        String topicName = a16.getTopicName();
        if (topicName == null) {
            topicName = StringsKt__StringsKt.removePrefix("", (CharSequence) "#");
        }
        String guildId = a16.getGuildId();
        if (guildId == null) {
            guildId = "";
        }
        this.topicSession = TopicContextKt.a(topicId, topicName, guildId, "");
        this.topicDepends = TopicContextKt.b(this, String.valueOf(a16.getTraceId()));
        this.topicGlobalDepends = TopicContextKt.c();
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Part[]{new n(), new aw(), new ym1.a(0, 1, null), new TopicInfoPart(), new TopicPublishPart(), new TopicViewPagePart(), new TopicReservePart(), new com.tencent.mobileqq.guild.feed.gallery.part.a(20), new TopicVisitorJoinPart()});
        return listOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f168187f94;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(@Nullable Activity activity) {
        super.initWindowStyleAndAnimation(activity);
        if (activity != null) {
            activity.overridePendingTransition(R.anim.f154619or, R.anim.f154425m);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        PartFragmentIOCKt.unregisterIoc(this, e.class);
        PartFragmentIOCKt.unregisterIoc(this, a.class);
        PartFragmentIOCKt.unregisterIoc(this, b.class);
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(@Nullable View contentView, @Nullable Bundle savedInstanceState) {
        b bVar = null;
        if (!ph()) {
            QLog.e("GTopic_GuildTopicFusionFragment", 1, "initParams error args:" + getArguments());
            GuildSplitViewUtils.u(GuildSplitViewUtils.f235370a, getActivity(), false, 2, null);
            return;
        }
        if (l.c() == null) {
            QLog.e("GTopic_GuildTopicFusionFragment", 1, "initParams error sdk: " + l.c());
            GuildSplitViewUtils.u(GuildSplitViewUtils.f235370a, getActivity(), false, 2, null);
        }
        e eVar = this.topicSession;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topicSession");
            eVar = null;
        }
        PartFragmentIOCKt.registerIoc(this, eVar, e.class);
        a aVar = this.topicDepends;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topicDepends");
            aVar = null;
        }
        PartFragmentIOCKt.registerIoc(this, aVar, a.class);
        b bVar2 = this.topicGlobalDepends;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topicGlobalDepends");
        } else {
            bVar = bVar2;
        }
        PartFragmentIOCKt.registerIoc(this, bVar, b.class);
        GuildSplitViewUtils.f235370a.B(contentView);
    }
}

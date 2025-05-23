package com.tencent.mobileqq.nearbypro.feedscheck;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.nt.misc.api.IJumpApi;
import com.tencent.mobileqq.nearbypro.arch.NearbyBaseFragment;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.feedscheck.FeedCheckFragment;
import com.tencent.mobileqq.nearbypro.feedscheck.avatarpart.FeedsAvatarFilamentV2Part;
import com.tencent.mobileqq.nearbypro.part.a;
import com.tencent.mobileqq.nearbypro.part.e;
import com.tencent.mobileqq.nearbypro.profile.basepart.b;
import com.tencent.mobileqq.nearbypro.qqkuikly.module.QQNearbyModule;
import com.tencent.mobileqq.nearbypro.request.c;
import com.tencent.mobileqq.nearbypro.utils.s;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import op4.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sa2.f;
import sa2.l;
import xp4.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 /2\u00020\u0001:\u00010B\u0007\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0014J&\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\u001a\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010!\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u001aR\u0016\u0010#\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001aR\u0016\u0010$\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001aR\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/feedscheck/FeedCheckFragment;", "Lcom/tencent/mobileqq/nearbypro/arch/NearbyBaseFragment;", "", "vh", "Landroid/view/View;", "view", "th", "", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", "", "Lcom/tencent/mobileqq/nearbypro/part/e;", "rh", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "initWindowStyleAndAnimation", "onResume", "", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "openType", "", "G", "J", "userId", "H", "userName", "I", "userAvatar", "selectFeedId", "", "K", "Z", "isOnline", "Lop4/i;", "L", "Lop4/i;", "statusFeed", "<init>", "()V", "M", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class FeedCheckFragment extends NearbyBaseFragment {

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: G, reason: from kotlin metadata */
    private long userId;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private i statusFeed;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private String openType = "";

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private String userName = "";

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private String userAvatar = "";

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private String selectFeedId = "";

    /* renamed from: K, reason: from kotlin metadata */
    private boolean isOnline = true;

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013JF\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fR\u0014\u0010\u0010\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/feedscheck/FeedCheckFragment$a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/nearbypro/part/a;", "host", "Lxp4/h;", "person", "Lop4/i;", "statusFeed", "Lxp4/a;", "feed", "", "openType", "", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.nearbypro.feedscheck.FeedCheckFragment$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void b(Companion companion, Context context, a aVar, h hVar, i iVar, xp4.a aVar2, String str, int i3, Object obj) {
            a aVar3;
            h hVar2;
            i iVar2;
            xp4.a aVar4;
            if ((i3 & 2) != 0) {
                aVar3 = null;
            } else {
                aVar3 = aVar;
            }
            if ((i3 & 4) != 0) {
                hVar2 = null;
            } else {
                hVar2 = hVar;
            }
            if ((i3 & 8) != 0) {
                iVar2 = null;
            } else {
                iVar2 = iVar;
            }
            if ((i3 & 16) != 0) {
                aVar4 = null;
            } else {
                aVar4 = aVar2;
            }
            companion.a(context, aVar3, hVar2, iVar2, aVar4, str);
        }

        public final void a(@NotNull Context context, @Nullable a host, @Nullable h person, @Nullable i statusFeed, @Nullable xp4.a feed, @NotNull String openType) {
            byte[] bArr;
            byte[] bArr2;
            byte[] bArr3;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(openType, "openType");
            if (host != null) {
                host.t5("update_map_concise_action", Boolean.TRUE);
            }
            if (host != null) {
                host.t5("MSG_LOCATION_ACTION", Boolean.TRUE);
            }
            QQNearbyModule.Companion companion = QQNearbyModule.INSTANCE;
            Object[] objArr = new Object[3];
            if (person == null || (bArr = c.c(person)) == null) {
                bArr = new byte[0];
            }
            objArr[0] = bArr;
            if (statusFeed == null || (bArr2 = c.c(statusFeed)) == null) {
                bArr2 = new byte[0];
            }
            objArr[1] = bArr2;
            if (feed == null || (bArr3 = c.c(feed)) == null) {
                bArr3 = new byte[0];
            }
            objArr[2] = bArr3;
            companion.i(objArr);
            ((IJumpApi) QRoute.api(IJumpApi.class)).doJumpAction(context, "mqqapi://kuikly/open?target=52&channel=2&version=1&src_type=app&page_name=nearby_feed_detail&modal_mode=1&open_type=" + openType);
        }

        Companion() {
        }
    }

    private final void th(View view) {
        String str;
        Map<String, ? extends Object> mapOf;
        com.tencent.mobileqq.nearbypro.aio.utils.a aVar = com.tencent.mobileqq.nearbypro.aio.utils.a.f253152a;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to("nearby_map_view_entrance", this.openType);
        if (s.a() == this.userId) {
            str = "host";
        } else {
            str = QCircleDaTongConstant.ElementParamValue.PROFILE_GUEST_TYPE;
        }
        pairArr[1] = TuplesKt.to("nearby_host_guest_type", str);
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        aVar.c(view, requireActivity, "pg_nearby_map_view", mapOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uh(FeedCheckFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.bh();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void vh() {
        Long l3;
        long j3;
        String str;
        String str2;
        String str3;
        Boolean bool;
        boolean z16;
        if (getArguments() == null) {
            String string = getContext().getString(R.string.f170442l2);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026.nearbypro_open_page_err)");
            s.c(string);
            bh();
            return;
        }
        Bundle requireArguments = requireArguments();
        Object obj = requireArguments.get(CommonConstant.RETKEY.USERID);
        i iVar = null;
        if (obj instanceof Long) {
            l3 = (Long) obj;
        } else {
            l3 = null;
        }
        if (l3 != null) {
            j3 = l3.longValue();
        } else {
            j3 = 0;
        }
        this.userId = j3;
        Object obj2 = requireArguments.get("USER_NAME");
        if (obj2 instanceof String) {
            str = (String) obj2;
        } else {
            str = null;
        }
        String str4 = "";
        if (str == null) {
            str = "";
        }
        this.userName = str;
        Object obj3 = requireArguments.get("USER_AVATAR");
        if (obj3 instanceof String) {
            str2 = (String) obj3;
        } else {
            str2 = null;
        }
        if (str2 == null) {
            str2 = "";
        }
        this.userAvatar = str2;
        Object obj4 = requireArguments.get("SELECT_FEED_ID");
        if (obj4 instanceof String) {
            str3 = (String) obj4;
        } else {
            str3 = null;
        }
        if (str3 != null) {
            str4 = str3;
        }
        this.selectFeedId = str4;
        Object obj5 = requireArguments.get("IS_ONLINE");
        if (obj5 instanceof Boolean) {
            bool = (Boolean) obj5;
        } else {
            bool = null;
        }
        if (bool != null) {
            z16 = bool.booleanValue();
        } else {
            z16 = true;
        }
        this.isOnline = z16;
        byte[] byteArray = requireArguments.getByteArray("STATUS_FEED");
        if (byteArray != null) {
            iVar = (i) c.b(new i(), byteArray);
        }
        this.statusFeed = iVar;
        j.c().e("NBP.FeedsCheckPart.FeedCheckFragment", "userId: " + this.userId + ", selectFeedId: " + this.selectFeedId + ", isOnline: " + this.isOnline);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f168327fn3;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(@Nullable Activity activity) {
        if (activity != null) {
            activity.overridePendingTransition(R.anim.f154736qw, R.anim.f154737qx);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0055, code lost:
    
        if (r0.equals("0") == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0035, code lost:
    
        if (r0.equals("2") != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0058, code lost:
    
        ((com.tencent.mobileqq.nearbypro.profile.basepart.b) getViewModel(com.tencent.mobileqq.nearbypro.profile.basepart.b.class)).P1(new jb2.UserProfileData(r10.userId, r10.userName, r10.userAvatar, null, 8, null));
     */
    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Object obj;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Bundle arguments = getArguments();
        if (arguments != null) {
            obj = arguments.get("OPEN_TYPE");
        } else {
            obj = null;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
        this.openType = (String) obj;
        vh();
        String str = this.openType;
        switch (str.hashCode()) {
            case 49:
                if (str.equals("1")) {
                    ((b) getViewModel(b.class)).M1(this.userId);
                    break;
                }
                break;
        }
        View onCreateView = super.onCreateView(inflater, container, savedInstanceState);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // com.tencent.mobileqq.nearbypro.arch.NearbyBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        setStatusBarImmersive();
    }

    @Override // com.tencent.mobileqq.nearbypro.arch.NearbyBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Window window;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        view.setOnClickListener(new View.OnClickListener() { // from class: sa2.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FeedCheckFragment.uh(FeedCheckFragment.this, view2);
            }
        });
        Activity hostActivity = getHostActivity();
        if (hostActivity != null && (window = hostActivity.getWindow()) != null) {
            window.setSoftInputMode(32);
        }
        th(view);
    }

    @Override // com.tencent.mobileqq.nearbypro.arch.NearbyBaseFragment
    @NotNull
    public List<e> rh() {
        List<e> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new FeedsCheckTitlePart(), new com.tencent.mobileqq.nearbypro.feedscheck.avatarpart.b(this.userId), new FeedsAvatarFilamentV2Part(), new f(), new l(this.selectFeedId, this.isOnline, this.statusFeed));
        return mutableListOf;
    }
}

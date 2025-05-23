package com.tencent.mobileqq.newfriend.ui.builder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Space;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.addfriend.api.IAddFriendServiceApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.newfriend.ui.builder.d;
import com.tencent.mobileqq.newfriend.ui.view.PYMKItemView;
import com.tencent.mobileqq.profilecard.api.IProfileCardBusinessApi;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileCardConst;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.widget.SwipRightMenuBuilder;
import com.tenpay.ErrorCode;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0002,-B7\u0012\b\u0010\"\u001a\u0004\u0018\u00010!\u0012\b\u0010$\u001a\u0004\u0018\u00010#\u0012\b\u0010&\u001a\u0004\u0018\u00010%\u0012\b\u0010(\u001a\u0004\u0018\u00010'\u0012\u0006\u0010 \u001a\u00020\u001d\u00a2\u0006\u0004\b)\u0010*J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J,\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0013j\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e`\u00142\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0014J\u001a\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u001b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u001c\u001a\u00020\u0007H\u0014R\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/newfriend/ui/builder/g;", "Lcom/tencent/mobileqq/newfriend/ui/builder/d;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mobileqq/newfriend/ui/builder/g$b;", "holder", "Lcom/tencent/mobileqq/data/MayKnowRecommend;", "recommendData", "", "o", "Landroid/view/View;", "view", "u", "r", ReportConstant.COSTREPORT_PREFIX, "", "elementId", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "w", "v", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "t", "", "f", "position", "convertView", tl.h.F, NodeProps.ON_CLICK, "e", "Lcom/tencent/mobileqq/pymk/api/b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/pymk/api/b;", "mediaUtil", "Landroid/content/Context;", "context", "Lcom/tencent/common/app/AppInterface;", "app", "Lcom/tencent/mobileqq/newfriend/ui/adapter/a;", "adapter", "Lcom/tencent/mobileqq/newfriend/msg/i;", "data", "<init>", "(Landroid/content/Context;Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/newfriend/ui/adapter/a;Lcom/tencent/mobileqq/newfriend/msg/i;Lcom/tencent/mobileqq/pymk/api/b;)V", "D", "a", "b", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class g extends d implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final Set<String> E;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.pymk.api.b mediaUtil;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/newfriend/ui/builder/g$a;", "", "", "DT_PARAM_ALGORITHM_ID", "Ljava/lang/String;", "DT_PARAM_TO_UIN", "TAG", "", "exposureReportSet", "Ljava/util/Set;", "<init>", "()V", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.newfriend.ui.builder.g$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000b\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/newfriend/ui/builder/g$b;", "Lcom/tencent/mobileqq/newfriend/ui/builder/d$b;", "Lcom/tencent/mobileqq/newfriend/ui/view/PYMKItemView;", "I", "Lcom/tencent/mobileqq/newfriend/ui/view/PYMKItemView;", "a", "()Lcom/tencent/mobileqq/newfriend/ui/view/PYMKItemView;", "setPymkItem", "(Lcom/tencent/mobileqq/newfriend/ui/view/PYMKItemView;)V", "pymkItem", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "<init>", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b extends d.b {
        static IPatchRedirector $redirector_;

        /* renamed from: I, reason: from kotlin metadata */
        @NotNull
        private PYMKItemView pymkItem;

        public b(@NotNull PYMKItemView item) {
            Intrinsics.checkNotNullParameter(item, "item");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) item);
            } else {
                this.pymkItem = item;
            }
        }

        @NotNull
        public final PYMKItemView a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (PYMKItemView) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.pymkItem;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24193);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
            E = new LinkedHashSet();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@Nullable Context context, @Nullable AppInterface appInterface, @Nullable com.tencent.mobileqq.newfriend.ui.adapter.a aVar, @Nullable com.tencent.mobileqq.newfriend.msg.i iVar, @NotNull com.tencent.mobileqq.pymk.api.b mediaUtil) {
        super(context, appInterface, aVar, iVar);
        Intrinsics.checkNotNullParameter(mediaUtil, "mediaUtil");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, appInterface, aVar, iVar, mediaUtil);
        } else {
            this.mediaUtil = mediaUtil;
            this.f254110h = b(this.f254107d);
        }
    }

    private final void o(final b holder, final MayKnowRecommend recommendData) {
        Object first;
        com.tencent.mobileqq.pymk.api.b bVar = this.mediaUtil;
        PYMKItemView a16 = holder.a();
        Bundle bundle = new Bundle();
        bundle.putInt("user_request_subsourceid", 59);
        Unit unit = Unit.INSTANCE;
        bVar.a(a16, recommendData, bundle);
        holder.a().a(recommendData);
        holder.a().setOnClickListener(this);
        holder.a().b().setOnClickListener(this);
        q(holder.a(), "em_search_people_recommend_unit");
        q(holder.a().b(), "em_search_people_recommend_add");
        SwipRightMenuBuilder.SwipRightMenuItem[] swipRightMenuItemArr = holder.rightMenuItems;
        Intrinsics.checkNotNullExpressionValue(swipRightMenuItemArr, "holder.rightMenuItems");
        first = ArraysKt___ArraysKt.first(swipRightMenuItemArr);
        View view = ((SwipRightMenuBuilder.SwipRightMenuItem) first).menuView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.rightMenuItems.first().menuView");
        q(view, "em_bas_longer_recommend_person");
        holder.a().post(new Runnable() { // from class: com.tencent.mobileqq.newfriend.ui.builder.f
            @Override // java.lang.Runnable
            public final void run() {
                g.p(g.this, holder, recommendData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(g this$0, b holder, MayKnowRecommend recommendData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        Intrinsics.checkNotNullParameter(recommendData, "$recommendData");
        this$0.w(holder, recommendData);
    }

    private final void q(View view, String elementId) {
        VideoReport.setElementId(view, elementId);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
    }

    private final void r(View view) {
        com.tencent.mobileqq.newfriend.msg.g gVar;
        MayKnowRecommend mayKnowRecommend;
        boolean z16;
        int i3;
        int i16;
        Intent intent;
        com.tencent.mobileqq.newfriend.msg.i iVar = this.f254111i;
        Activity activity = null;
        if (iVar instanceof com.tencent.mobileqq.newfriend.msg.g) {
            gVar = (com.tencent.mobileqq.newfriend.msg.g) iVar;
        } else {
            gVar = null;
        }
        if (gVar != null) {
            mayKnowRecommend = gVar.d();
        } else {
            mayKnowRecommend = null;
        }
        if (mayKnowRecommend == null) {
            QLog.e("NewFriendMayKnowItemBuilder", 1, "clickAddButton data is null");
            return;
        }
        IRuntimeService runtimeService = this.f254108e.getRuntimeService(IFriendDataService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "mApp.getRuntimeService(I\u2026va, ProcessConstant.MAIN)");
        IRuntimeService runtimeService2 = this.f254108e.getRuntimeService(IAddFriendServiceApi.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService2, "mApp.getRuntimeService(I\u2026va, ProcessConstant.MAIN)");
        IAddFriendServiceApi iAddFriendServiceApi = (IAddFriendServiceApi) runtimeService2;
        if (((IFriendDataService) runtimeService).isFriend(mayKnowRecommend.uin)) {
            mayKnowRecommend.friendStatus = 2;
            this.f254109f.g();
            return;
        }
        boolean z17 = false;
        if (iAddFriendServiceApi.hasSendAddFriendReq(mayKnowRecommend.uin, false)) {
            mayKnowRecommend.friendStatus = 1;
            this.f254109f.g();
            return;
        }
        Context context = this.f254107d;
        if (context instanceof Activity) {
            activity = (Activity) context;
        }
        if (activity != null && (intent = activity.getIntent()) != null) {
            z16 = intent.getBooleanExtra(AppConstants.Key.KEY_FROM_BABYQ, false);
        } else {
            z16 = false;
        }
        if (z16) {
            i16 = 1;
            i3 = 3083;
        } else {
            i3 = 3045;
            i16 = 59;
        }
        IAddFriendApi iAddFriendApi = (IAddFriendApi) QRoute.api(IAddFriendApi.class);
        Context context2 = this.f254107d;
        Intent startAddFriend = iAddFriendApi.startAddFriend(context2, 1, mayKnowRecommend.uin, (String) null, i3, i16, mayKnowRecommend.nick, (String) null, (String) null, context2.getString(R.string.f170028dd), (String) null, mayKnowRecommend.getToken());
        Intrinsics.checkNotNullExpressionValue(startAddFriend, "api(IAddFriendApi::class\u2026mmendData.token\n        )");
        String makeSexAgeArea = ((IProfileCardBusinessApi) QRoute.api(IProfileCardBusinessApi.class)).makeSexAgeArea(this.f254107d, mayKnowRecommend.gender, mayKnowRecommend.age, mayKnowRecommend.country, mayKnowRecommend.province, mayKnowRecommend.city);
        Intrinsics.checkNotNullExpressionValue(makeSexAgeArea, "api(IProfileCardBusiness\u2026ommendData.city\n        )");
        startAddFriend.putExtra("key_param_age_area", makeSexAgeArea);
        startAddFriend.putExtra(AppConstants.Key.KEY_FROM_BABYQ, z16);
        byte[] bArr = mayKnowRecommend.algBuffer;
        if (bArr != null) {
            Intrinsics.checkNotNullExpressionValue(bArr, "recommendData.algBuffer");
            if (bArr.length == 0) {
                z17 = true;
            }
            if (true ^ z17) {
                byte[] bArr2 = mayKnowRecommend.algBuffer;
                Intrinsics.checkNotNullExpressionValue(bArr2, "recommendData.algBuffer");
                Charset UTF_8 = StandardCharsets.UTF_8;
                Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                startAddFriend.putExtra("algo_id", new String(bArr2, UTF_8));
            }
        }
        ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriend(this.f254107d, startAddFriend);
        v(view, mayKnowRecommend);
    }

    private final void s(View view) {
        com.tencent.mobileqq.newfriend.msg.g gVar;
        MayKnowRecommend d16;
        i(view);
        com.tencent.mobileqq.newfriend.msg.i iVar = this.f254111i;
        if (iVar instanceof com.tencent.mobileqq.newfriend.msg.g) {
            gVar = (com.tencent.mobileqq.newfriend.msg.g) iVar;
        } else {
            gVar = null;
        }
        if (gVar != null && (d16 = gVar.d()) != null) {
            v(view, d16);
        }
    }

    private final HashMap<String, String> t(MayKnowRecommend recommendData) {
        boolean z16;
        HashMap<String, String> hashMap = new HashMap<>();
        String str = recommendData.uin;
        Intrinsics.checkNotNullExpressionValue(str, "recommendData.uin");
        hashMap.put("to_uin", str);
        byte[] bArr = recommendData.algBuffer;
        if (bArr != null) {
            Intrinsics.checkNotNullExpressionValue(bArr, "recommendData.algBuffer");
            if (bArr.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                byte[] bArr2 = recommendData.algBuffer;
                Intrinsics.checkNotNullExpressionValue(bArr2, "recommendData.algBuffer");
                hashMap.put("algo_id", new String(bArr2, Charsets.UTF_8));
            }
        }
        String str2 = recommendData.recommendReason;
        Intrinsics.checkNotNullExpressionValue(str2, "recommendData.recommendReason");
        hashMap.put("recommend_reason", str2);
        hashMap.put("user_request_subsourceid", ErrorCode.ERR_NET);
        hashMap.put("user_request_sourceid", "3045");
        return hashMap;
    }

    private final void u(View view) {
        com.tencent.mobileqq.newfriend.msg.g gVar;
        com.tencent.mobileqq.newfriend.msg.i iVar = this.f254111i;
        MayKnowRecommend mayKnowRecommend = null;
        if (iVar instanceof com.tencent.mobileqq.newfriend.msg.g) {
            gVar = (com.tencent.mobileqq.newfriend.msg.g) iVar;
        } else {
            gVar = null;
        }
        if (gVar != null) {
            mayKnowRecommend = gVar.d();
        }
        if (mayKnowRecommend == null) {
            QLog.e("NewFriendMayKnowItemBuilder", 1, "openProfileCard data is null");
            return;
        }
        AllInOne allInOne = new AllInOne(mayKnowRecommend.uin, 81);
        allInOne.recommendName = mayKnowRecommend.getDisplayName();
        allInOne.nickname = mayKnowRecommend.nick;
        allInOne.profileEntryType = 88;
        allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SOURCE_ID, 3);
        allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SUB_SOURCE_ID, 32);
        allInOne.extras.putBoolean(ProfileCardConst.ENTER_PAGE_OPEN_STAND_IN_PAD, true);
        allInOne.extras.putInt(IProfileCardConst.PARAM_ADD_FRIEND_ID, 3045);
        allInOne.extras.putInt(IProfileCardConst.PARAM_ADD_FRIEND_SUB_ID, 59);
        allInOne.extras.putByteArray("recommend_algh_id", mayKnowRecommend.algBuffer);
        allInOne.extras.putString("recommend_reason", mayKnowRecommend.getMultiReason());
        ProfileUtils.openProfileCard(this.f254107d, allInOne);
        v(view, mayKnowRecommend);
        QLog.d("NewFriendMayKnowItemBuilder", 1, "openProfileCard ", mayKnowRecommend.uin + ", " + mayKnowRecommend.nick);
    }

    private final void v(View view, MayKnowRecommend recommendData) {
        VideoReport.reportEvent("clck", view, t(recommendData));
    }

    private final void w(b holder, MayKnowRecommend recommendData) {
        Set<String> set = E;
        if (set.contains(recommendData.uin)) {
            return;
        }
        VideoReport.reportEvent("dt_imp", holder.a(), t(recommendData));
        VideoReport.reportEvent("dt_imp", holder.a().b(), t(recommendData));
        String str = recommendData.uin;
        Intrinsics.checkNotNullExpressionValue(str, "recommendData.uin");
        set.add(str);
    }

    @Override // com.tencent.mobileqq.newfriend.ui.builder.d
    protected void e() {
        com.tencent.mobileqq.newfriend.msg.g gVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        com.tencent.mobileqq.newfriend.msg.i iVar = this.f254111i;
        MayKnowRecommend mayKnowRecommend = null;
        if (iVar instanceof com.tencent.mobileqq.newfriend.msg.g) {
            gVar = (com.tencent.mobileqq.newfriend.msg.g) iVar;
        } else {
            gVar = null;
        }
        if (gVar != null) {
            mayKnowRecommend = gVar.d();
        }
        if (mayKnowRecommend == null) {
            QLog.e("NewFriendMayKnowItemBuilder", 1, "deleteItem data is null");
        } else {
            ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).cancelMayKnowRecommend(mayKnowRecommend.uin, this.f254108e);
            this.f254109f.g();
        }
    }

    @Override // com.tencent.mobileqq.newfriend.ui.builder.d
    protected int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return 2;
        }
        return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
    }

    @Override // com.tencent.mobileqq.newfriend.ui.builder.d
    @NotNull
    public View h(int position, @Nullable View convertView) {
        com.tencent.mobileqq.newfriend.msg.g gVar;
        MayKnowRecommend mayKnowRecommend;
        b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, position, (Object) convertView);
        }
        com.tencent.mobileqq.newfriend.msg.i iVar = this.f254111i;
        if (iVar instanceof com.tencent.mobileqq.newfriend.msg.g) {
            gVar = (com.tencent.mobileqq.newfriend.msg.g) iVar;
        } else {
            gVar = null;
        }
        if (gVar != null) {
            mayKnowRecommend = gVar.d();
        } else {
            mayKnowRecommend = null;
        }
        if (mayKnowRecommend == null) {
            QLog.e("NewFriendMayKnowItemBuilder", 1, "getView data is null");
            return new View(this.f254107d);
        }
        if (convertView != null && (convertView.getTag() instanceof b)) {
            Object tag = convertView.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.newfriend.ui.builder.NewFriendMayKnowItemBuilder.NewFriendMayKnowItemHolder");
            bVar = (b) tag;
        } else {
            Context mContext = this.f254107d;
            Intrinsics.checkNotNullExpressionValue(mContext, "mContext");
            PYMKItemView pYMKItemView = new PYMKItemView(mContext, null, 2, null);
            bVar = new b(pYMKItemView);
            convertView = this.f254110h.createView(this.f254107d, pYMKItemView, bVar, -1);
            if (convertView == null) {
                return new Space(this.f254107d);
            }
            convertView.setTag(bVar);
        }
        b bVar2 = bVar;
        l(this.f254107d, convertView, position, this.f254111i, bVar2, this);
        o(bVar2, mayKnowRecommend);
        return convertView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
        } else {
            if (view != null) {
                num = Integer.valueOf(view.getId());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == R.id.i8s) {
                r(view);
            } else if (num != null && num.intValue() == R.id.ibi) {
                u(view);
            } else if (num != null && num.intValue() == R.id.epz) {
                s(view);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}

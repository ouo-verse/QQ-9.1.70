package com.tencent.mobileqq.selectfriend.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.proxy.IRecentForwardUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.k;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectfriend.api.IForwardFriendApi;
import com.tencent.mobileqq.selectfriend.model.FSForwardData;
import com.tencent.mobileqq.selectfriend.model.FSLayoutData;
import com.tencent.mobileqq.selectfriend.relationlist.BaseRelationSectionedNodeList;
import com.tencent.mobileqq.selectfriend.relationlist.RelationSectionedNodeList;
import com.tencent.mobileqq.selectfriend.relationlist.SharedNode;
import com.tencent.mobileqq.selectfriend.view.ForwardFriendHomeFragment;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.api.IRelationNTRecentListApi;
import com.tencent.relation.common.nt.listener.RecentContactListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 52\u00020\u0001:\u00016B\u0007\u00a2\u0006\u0004\b3\u00104J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J2\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0016J2\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u0007H\u0016J<\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J*\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0018\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007H\u0016J\u0010\u0010!\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u000fH\u0016JF\u0010'\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000f2\u001a\u0010&\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020%\u0018\u00010$\u0012\u0004\u0012\u00020\t0#H\u0016JF\u0010(\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000f2\u001a\u0010&\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020%\u0018\u00010$\u0012\u0004\u0012\u00020\t0#H\u0016J6\u0010)\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\"\u001a\u00020\u000f2\u001a\u0010&\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020%\u0018\u00010$\u0012\u0004\u0012\u00020\t0#H\u0016J\u0012\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010*\u001a\u00020%H\u0016J&\u00100\u001a\u0012\u0012\u0004\u0012\u00020+0.j\b\u0012\u0004\u0012\u00020+`/2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020%0$H\u0016J\u0010\u00101\u001a\u00020%2\u0006\u0010*\u001a\u00020+H\u0016R\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u00102\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/api/impl/ForwardFriendApiImpl;", "Lcom/tencent/mobileqq/selectfriend/api/IForwardFriendApi;", "Landroid/app/Activity;", "caller", "Lcom/tencent/mobileqq/selectfriend/model/FSForwardData;", "Landroid/os/Bundle;", "fsForwardData", "", "requestCode", "", "startForwardFriendActivityForResult", "Lcom/tencent/mobileqq/selectfriend/model/FSLayoutData;", "fsLayoutData", "Lcom/tencent/mobileqq/selectfriend/model/b;", "fsEventDelegate", "", "useRelationSectionedNodeList", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/selectfriend/relationlist/model/a;", "model", "Lcom/tencent/mobileqq/selectfriend/relationlist/BaseRelationSectionedNodeList;", "getUserList", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "isShowRecentChatList", "isMatchFriendUserList", "Landroid/content/Intent;", "intent", "getRecentUserModel", "businessType", "businessSubType", "getTopayUserModel", "showRobotGroup", "getGroupdFriendModel", "shouldShowGuild", "Lkotlin/Function1;", "", "Lcom/tencent/mobileqq/selectfriend/relationlist/SharedNode;", "callback", "getFrowardAndRecent", "getRecentUserListData", "getFrowardListData", "sharedNode", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "getResultRecordFromSharedNode", "sharedNodes", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getResultRecordsFromSharedNodes", "getSharedNodeFromResultRecord", "Z", "<init>", "()V", "Companion", "a", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ForwardFriendApiImpl implements IForwardFriendApi {
    private static final String TAG = "ForwardFriendImpl";
    private final boolean useRelationSectionedNodeList = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("use_relation_sectioned_node_list", true);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/selectfriend/api/impl/ForwardFriendApiImpl$b", "Lcom/tencent/relation/common/nt/listener/RecentContactListener;", "", "Lcom/tencent/mobileqq/data/RecentUser;", "recentUserList", "", "onResult", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements RecentContactListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<List<SharedNode>, Unit> f285291a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f285292b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f285293c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ForwardBaseOption f285294d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f285295e;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function1<? super List<SharedNode>, Unit> function1, boolean z16, boolean z17, ForwardBaseOption forwardBaseOption, boolean z18) {
            this.f285291a = function1;
            this.f285292b = z16;
            this.f285293c = z17;
            this.f285294d = forwardBaseOption;
            this.f285295e = z18;
        }

        @Override // com.tencent.relation.common.nt.listener.RecentContactListener
        public void onResult(List<RecentUser> recentUserList) {
            Intrinsics.checkNotNullParameter(recentUserList, "recentUserList");
            this.f285291a.invoke(com.tencent.mobileqq.selectfriend.relationlist.a.b(recentUserList, this.f285292b, this.f285293c, this.f285294d, this.f285295e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getFrowardAndRecent$lambda$0(final ForwardFriendApiImpl this$0, final Intent intent, final boolean z16, final boolean z17, final boolean z18, final Function1 callback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        this$0.getFrowardListData(intent, z16, new Function1<List<? extends SharedNode>, Unit>() { // from class: com.tencent.mobileqq.selectfriend.api.impl.ForwardFriendApiImpl$getFrowardAndRecent$runnable$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends SharedNode> list) {
                invoke2((List<SharedNode>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final List<SharedNode> list) {
                ForwardFriendApiImpl forwardFriendApiImpl = ForwardFriendApiImpl.this;
                Intent intent2 = intent;
                boolean z19 = z16;
                boolean z26 = z17;
                boolean z27 = z18;
                final Function1<List<SharedNode>, Unit> function1 = callback;
                forwardFriendApiImpl.getRecentUserListData(intent2, z19, z26, z27, new Function1<List<? extends SharedNode>, Unit>() { // from class: com.tencent.mobileqq.selectfriend.api.impl.ForwardFriendApiImpl$getFrowardAndRecent$runnable$1$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(List<? extends SharedNode> list2) {
                        invoke2((List<SharedNode>) list2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(List<SharedNode> list2) {
                        List list3;
                        List emptyList;
                        boolean z28;
                        if (list2 != null) {
                            List<SharedNode> list4 = list;
                            list3 = new ArrayList();
                            for (Object obj : list2) {
                                SharedNode sharedNode = (SharedNode) obj;
                                boolean z29 = false;
                                if (list4 != null) {
                                    List<SharedNode> list5 = list4;
                                    if (!(list5 instanceof Collection) || !list5.isEmpty()) {
                                        for (SharedNode sharedNode2 : list5) {
                                            if (Intrinsics.areEqual(sharedNode2.getKey(), sharedNode.getKey()) && Intrinsics.areEqual(sharedNode2.getType(), sharedNode.getType())) {
                                                z28 = true;
                                                break;
                                            }
                                        }
                                    }
                                    z28 = false;
                                    if (z28) {
                                        z29 = true;
                                    }
                                }
                                if (!z29) {
                                    list3.add(obj);
                                }
                            }
                        } else {
                            list3 = null;
                        }
                        ArrayList arrayList = new ArrayList();
                        List<SharedNode> list6 = list;
                        if (list6 == null) {
                            list6 = CollectionsKt__CollectionsKt.emptyList();
                        }
                        arrayList.addAll(list6);
                        if (list3 == null) {
                            emptyList = CollectionsKt__CollectionsKt.emptyList();
                            list3 = emptyList;
                        }
                        arrayList.addAll(list3);
                        function1.invoke(arrayList);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getFrowardListData$lambda$6(Function1 callback, Intent intent, ForwardFriendApiImpl this$0) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (peekAppRuntime instanceof QQAppInterface)) {
            if (intent == null) {
                intent = new Intent();
            }
            QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
            ForwardBaseOption b16 = k.b(intent, qQAppInterface);
            if (b16 == null) {
                QLog.i(TAG, 1, "getSharedNodeList fail because forwardOption is null");
                callback.invoke(null);
                return;
            }
            IRecentForwardUserProxy recentForwardCache = ((IRecentUserProxyService) peekAppRuntime.getRuntimeService(IRecentUserProxyService.class, "")).getRecentForwardCache();
            Intrinsics.checkNotNullExpressionValue(recentForwardCache, "app.getRuntimeService(\n \u2026     ).recentForwardCache");
            List<RecentUser> recentList = recentForwardCache.getRecentList(true, true, false);
            if (recentList == null) {
                recentList = new ArrayList<>();
            }
            ArrayList<RecentUser> arrayList = new ArrayList<>(recentList);
            com.tencent.mobileqq.selectfriend.relationlist.a.f285557a.e(arrayList, qQAppInterface, b16, true);
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            for (RecentUser it : arrayList) {
                com.tencent.mobileqq.selectfriend.relationlist.a aVar = com.tencent.mobileqq.selectfriend.relationlist.a.f285557a;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                arrayList2.add(aVar.h(it));
            }
            callback.invoke(arrayList2);
            return;
        }
        QLog.e(TAG, 1, "getRecentForwardListWithoutShowUp is error, app is null!");
        callback.invoke(new ArrayList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getRecentUserListData$lambda$3(ForwardFriendApiImpl this$0, Intent intent, Function1 callback, boolean z16, boolean z17, boolean z18) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        if (qQAppInterface == null) {
            QLog.i(TAG, 1, "getSharedNodeList fail because app is null");
            callback.invoke(null);
            return;
        }
        if (intent == null) {
            intent = new Intent();
        }
        ForwardBaseOption b16 = k.b(intent, qQAppInterface);
        if (b16 == null) {
            QLog.i(TAG, 1, "getSharedNodeList fail because forwardOption is null");
            callback.invoke(null);
        } else {
            ((IRelationNTRecentListApi) QRoute.api(IRelationNTRecentListApi.class)).getRecentList(qQAppInterface, new b(callback, z16, z17, b16, z18), false);
        }
    }

    @Override // com.tencent.mobileqq.selectfriend.api.IForwardFriendApi
    public void getFrowardAndRecent(final Intent intent, final boolean shouldShowGuild, final boolean isShowRecentChatList, final boolean isMatchFriendUserList, final Function1<? super List<SharedNode>, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.selectfriend.api.impl.c
            @Override // java.lang.Runnable
            public final void run() {
                ForwardFriendApiImpl.getFrowardAndRecent$lambda$0(ForwardFriendApiImpl.this, intent, shouldShowGuild, isShowRecentChatList, isMatchFriendUserList, callback);
            }
        };
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            ThreadManagerV2.excute(runnable, 32, null, true);
        } else {
            runnable.run();
        }
    }

    @Override // com.tencent.mobileqq.selectfriend.api.IForwardFriendApi
    public void getFrowardListData(final Intent intent, boolean shouldShowGuild, final Function1<? super List<SharedNode>, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.selectfriend.api.impl.b
            @Override // java.lang.Runnable
            public final void run() {
                ForwardFriendApiImpl.getFrowardListData$lambda$6(Function1.this, intent, this);
            }
        };
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            ThreadManagerV2.excute(runnable, 32, null, true);
        } else {
            runnable.run();
        }
    }

    @Override // com.tencent.mobileqq.selectfriend.api.IForwardFriendApi
    public com.tencent.mobileqq.selectfriend.relationlist.model.a getGroupdFriendModel(boolean showRobotGroup) {
        return new aq2.a(showRobotGroup);
    }

    @Override // com.tencent.mobileqq.selectfriend.api.IForwardFriendApi
    public void getRecentUserListData(final Intent intent, final boolean shouldShowGuild, final boolean isShowRecentChatList, final boolean isMatchFriendUserList, final Function1<? super List<SharedNode>, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.selectfriend.api.impl.d
            @Override // java.lang.Runnable
            public final void run() {
                ForwardFriendApiImpl.getRecentUserListData$lambda$3(ForwardFriendApiImpl.this, intent, callback, isShowRecentChatList, isMatchFriendUserList, shouldShowGuild);
            }
        };
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            ThreadManagerV2.excute(runnable, 32, null, true);
        } else {
            runnable.run();
        }
    }

    @Override // com.tencent.mobileqq.selectfriend.api.IForwardFriendApi
    public com.tencent.mobileqq.selectfriend.relationlist.model.a getRecentUserModel(Activity activity, boolean isShowRecentChatList, boolean isMatchFriendUserList, Intent intent) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        if (qQAppInterface == null) {
            return new bq2.a(isShowRecentChatList, isMatchFriendUserList, null);
        }
        if (intent == null) {
            intent = new Intent();
        }
        ForwardBaseOption d16 = k.d(intent, qQAppInterface, activity);
        if (d16 == null) {
            return new bq2.a(isShowRecentChatList, isMatchFriendUserList, null);
        }
        return new bq2.a(isShowRecentChatList, isMatchFriendUserList, d16);
    }

    @Override // com.tencent.mobileqq.selectfriend.api.IForwardFriendApi
    public ResultRecord getResultRecordFromSharedNode(SharedNode sharedNode) {
        Intrinsics.checkNotNullParameter(sharedNode, "sharedNode");
        return com.tencent.mobileqq.selectfriend.relationlist.a.f285557a.g(sharedNode);
    }

    @Override // com.tencent.mobileqq.selectfriend.api.IForwardFriendApi
    public ArrayList<ResultRecord> getResultRecordsFromSharedNodes(List<SharedNode> sharedNodes) {
        Intrinsics.checkNotNullParameter(sharedNodes, "sharedNodes");
        ArrayList<ResultRecord> arrayList = new ArrayList<>();
        Iterator<SharedNode> it = sharedNodes.iterator();
        while (it.hasNext()) {
            arrayList.add(com.tencent.mobileqq.selectfriend.relationlist.a.f285557a.g(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.selectfriend.api.IForwardFriendApi
    public SharedNode getSharedNodeFromResultRecord(ResultRecord sharedNode) {
        Intrinsics.checkNotNullParameter(sharedNode, "sharedNode");
        return com.tencent.mobileqq.selectfriend.relationlist.a.f285557a.k(sharedNode);
    }

    @Override // com.tencent.mobileqq.selectfriend.api.IForwardFriendApi
    public com.tencent.mobileqq.selectfriend.relationlist.model.a getTopayUserModel(int businessType, int businessSubType) {
        return new bq2.b(businessType, businessSubType);
    }

    @Override // com.tencent.mobileqq.selectfriend.api.IForwardFriendApi
    public BaseRelationSectionedNodeList getUserList(Context context, com.tencent.mobileqq.selectfriend.relationlist.model.a model) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(model, "model");
        return new RelationSectionedNodeList(context, null, 0, model, 6, null);
    }

    @Override // com.tencent.mobileqq.selectfriend.api.IForwardFriendApi
    public void startForwardFriendActivityForResult(Activity caller, FSForwardData<Bundle> fsForwardData, int requestCode) {
        Intrinsics.checkNotNullParameter(caller, "caller");
        startForwardFriendActivityForResult(caller, fsForwardData, null, null, requestCode);
    }

    @Override // com.tencent.mobileqq.selectfriend.api.IForwardFriendApi
    /* renamed from: useRelationSectionedNodeList, reason: from getter */
    public boolean getUseRelationSectionedNodeList() {
        return this.useRelationSectionedNodeList;
    }

    @Override // com.tencent.mobileqq.selectfriend.api.IForwardFriendApi
    public void startForwardFriendActivityForResult(Activity caller, FSForwardData<Bundle> fsForwardData, FSLayoutData fsLayoutData, int requestCode) {
        Intrinsics.checkNotNullParameter(caller, "caller");
        startForwardFriendActivityForResult(caller, fsForwardData, fsLayoutData, null, requestCode);
    }

    @Override // com.tencent.mobileqq.selectfriend.api.IForwardFriendApi
    public void startForwardFriendActivityForResult(Activity caller, FSForwardData<Bundle> fsForwardData, com.tencent.mobileqq.selectfriend.model.b fsEventDelegate, int requestCode) {
        Intrinsics.checkNotNullParameter(caller, "caller");
        startForwardFriendActivityForResult(caller, fsForwardData, null, null, requestCode);
    }

    @Override // com.tencent.mobileqq.selectfriend.api.IForwardFriendApi
    public void startForwardFriendActivityForResult(Activity caller, FSForwardData<Bundle> fsForwardData, FSLayoutData fsLayoutData, com.tencent.mobileqq.selectfriend.model.b fsEventDelegate, int requestCode) {
        Intrinsics.checkNotNullParameter(caller, "caller");
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100230", false);
        if (QLog.isColorLevel()) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("openFSSwitch : %b", Arrays.copyOf(new Object[]{Boolean.valueOf(isSwitchOn)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            QLog.i(TAG, 1, format);
        }
        if (isSwitchOn) {
            Intent intent = new Intent();
            intent.putExtra("caller_name", caller.getClass().getSimpleName());
            if (fsForwardData != null) {
                intent.putExtra("fs_forward_data_obj", fsForwardData);
            }
            if (fsLayoutData != null) {
                intent.putExtra("fs_forward_layout_obj", fsLayoutData);
            }
            QPublicFragmentActivity.startForResult(caller, intent, (Class<? extends QPublicBaseFragment>) ForwardFriendHomeFragment.class, requestCode);
            return;
        }
        Intent intent2 = new Intent();
        if ((fsForwardData != null ? fsForwardData.b() : null) != null) {
            Bundle b16 = fsForwardData.b();
            Intrinsics.checkNotNull(b16);
            intent2.putExtras(b16);
        }
        ForwardBaseOption.startForwardActivityForResult(caller, intent2, 21);
    }
}

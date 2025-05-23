package com.tencent.robot.story;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.aio.data.AIOParam;
import com.tencent.android.androidbypass.richui.viewdata.j;
import com.tencent.android.androidbypass.richui.viewdata.k;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.HalfViewCardNode;
import com.tencent.qqnt.kernel.nativeinterface.QueryHalfViewDataRsp;
import com.tencent.qqnt.kernel.nativeinterface.StoryAction;
import com.tencent.qqnt.kernel.nativeinterface.StoryBaseInfo;
import com.tencent.robot.adelie.homepage.utils.StoryUtils;
import com.tencent.robot.api.IRobotIdentityApi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.C11736d;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import p64.RobotStoryBoardCardData;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 62\u00020\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b4\u00105J!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ#\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002\u00a2\u0006\u0004\b\f\u0010\rJ7\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J9\u0010 \u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00060\u001bR\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\"0!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000e0!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010$R \u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0(0!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010$R\u0017\u0010/\u001a\b\u0012\u0004\u0012\u00020\"0,8F\u00a2\u0006\u0006\u001a\u0004\b-\u0010.R\u0017\u00101\u001a\b\u0012\u0004\u0012\u00020\u000e0,8F\u00a2\u0006\u0006\u001a\u0004\b0\u0010.R\u001d\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0(0,8F\u00a2\u0006\u0006\u001a\u0004\b2\u0010.\u00a8\u00067"}, d2 = {"Lcom/tencent/robot/story/RobotStoryBoardViewModel;", "", "", QQWinkConstants.STORY_ID, "Lcom/tencent/qqnt/kernel/nativeinterface/QueryHalfViewDataRsp;", "rsp", "", "i", "(Ljava/lang/Long;Lcom/tencent/qqnt/kernel/nativeinterface/QueryHalfViewDataRsp;)V", "Lcom/tencent/qqnt/kernel/nativeinterface/StoryBaseInfo;", "storyBaseInfo", "", DomainData.DOMAIN_NAME, "(Ljava/lang/Long;Lcom/tencent/qqnt/kernel/nativeinterface/StoryBaseInfo;)Z", "", "uid", "", "optId", "filterData", "isLocal", "currentStoryId", tl.h.F, "(Ljava/lang/String;ILjava/lang/String;ZLjava/lang/Long;)V", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/qqnt/kernel/nativeinterface/HalfViewCardNode;", "cardNode", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "cb", "g", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/robot/story/PageState;", "a", "Landroidx/lifecycle/MutableLiveData;", "_pageStateLiveData", "b", "_titleLiveData", "", "Lp64/a;", "c", "_cardListLiveData", "Landroidx/lifecycle/LiveData;", "l", "()Landroidx/lifecycle/LiveData;", "pageStateLiveData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "titleLiveData", "k", "cardListLiveData", "<init>", "()V", "d", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotStoryBoardViewModel {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<PageState> _pageStateLiveData = new MutableLiveData<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<String> _titleLiveData = new MutableLiveData<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<p64.a>> _cardListLiveData = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(final Long storyId, final QueryHalfViewDataRsp rsp) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.robot.story.i
            @Override // java.lang.Runnable
            public final void run() {
                RobotStoryBoardViewModel.j(QueryHalfViewDataRsp.this, this, storyId);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(QueryHalfViewDataRsp rsp, final RobotStoryBoardViewModel this$0, Long l3) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        boolean z16;
        j jVar;
        Intrinsics.checkNotNullParameter(rsp, "$rsp");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final ArrayList arrayList = new ArrayList();
        ArrayList<HalfViewCardNode> arrayList2 = rsp.cardNodes;
        Intrinsics.checkNotNullExpressionValue(arrayList2, "rsp.cardNodes");
        ArrayList<HalfViewCardNode> arrayList3 = new ArrayList();
        for (Object obj : arrayList2) {
            if (this$0.n(l3, ((HalfViewCardNode) obj).storyBaseInfo)) {
                arrayList3.add(obj);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10);
        ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault);
        for (HalfViewCardNode halfViewCardNode : arrayList3) {
            String str = rsp.layoutMap.get(halfViewCardNode.layoutId);
            String str2 = rsp.attrMap.get(halfViewCardNode.attrId);
            try {
                JSONObject jSONObject = new JSONObject(str);
                com.tencent.android.androidbypass.richui.utils.c.b(jSONObject, new JSONObject(str2));
                jSONObject.put("version", 0);
                jSONObject.put("templateId", "aio.robot.story");
                jVar = com.tencent.android.androidbypass.richui.e.c(com.tencent.android.androidbypass.richui.e.f72322a, jSONObject, null, null, 6, null);
            } catch (Exception e16) {
                QLog.i("RobotStoryBoardViewModel-RobotStory", 1, "[generateProfileItemList]", e16);
                jVar = null;
            }
            arrayList4.add(new Pair(halfViewCardNode, jVar));
        }
        ArrayList<Pair> arrayList5 = new ArrayList();
        for (Object obj2 : arrayList4) {
            if (((Pair) obj2).getSecond() != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList5.add(obj2);
            }
        }
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList5, 10);
        ArrayList arrayList6 = new ArrayList(collectionSizeOrDefault2);
        for (Pair pair : arrayList5) {
            Object first = pair.getFirst();
            Intrinsics.checkNotNullExpressionValue(first, "it.first");
            Object second = pair.getSecond();
            Intrinsics.checkNotNull(second);
            arrayList6.add(new RobotStoryBoardCardData((HalfViewCardNode) first, (k) second));
        }
        arrayList.addAll(arrayList6);
        C11736d.c(new Function0<Unit>() { // from class: com.tencent.robot.story.RobotStoryBoardViewModel$generateProfileItemList$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MutableLiveData mutableLiveData;
                MutableLiveData mutableLiveData2;
                mutableLiveData = RobotStoryBoardViewModel.this._pageStateLiveData;
                mutableLiveData.setValue(PageState.Success);
                mutableLiveData2 = RobotStoryBoardViewModel.this._cardListLiveData;
                mutableLiveData2.setValue(arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean n(Long storyId, StoryBaseInfo storyBaseInfo) {
        if (storyId == null || storyBaseInfo == null || storyBaseInfo.storyId == storyId.longValue()) {
            return false;
        }
        return true;
    }

    public final void g(@NotNull final com.tencent.aio.api.runtime.a aioContext, @NotNull final HalfViewCardNode cardNode, @NotNull final Function1<? super Boolean, Unit> cb5) {
        final Context context;
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(cardNode, "cardNode");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        if (cardNode.action != 1 || (context = aioContext.c().getContext()) == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        StoryBaseInfo storyBaseInfo = cardNode.storyBaseInfo;
        if (storyBaseInfo != null) {
            hashMap.put("plot_id", String.valueOf(storyBaseInfo.storyId));
            hashMap.put("plot_title", cardNode.storyBaseInfo.title);
        }
        com.tencent.mobileqq.aio.utils.b.l("em_bas_story_card", hashMap);
        final StoryBaseInfo storyBaseInfo2 = cardNode.storyBaseInfo;
        AIOParam g16 = aioContext.g();
        Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
        final long a16 = su3.c.a(g16);
        String j3 = aioContext.g().r().c().j();
        QLog.e("RobotStoryBoardViewModel-RobotStory", 1, "enterStory uin=" + StringUtil.getSimpleUinForPrint(String.valueOf(a16)) + ", storyInfo=" + storyBaseInfo2);
        ((IRobotIdentityApi) QRoute.api(IRobotIdentityApi.class)).checkAndAddFriend(j3, new Function0<Unit>() { // from class: com.tencent.robot.story.RobotStoryBoardViewModel$enterStory$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                QLog.e("RobotStoryBoardViewModel-RobotStory", 1, "enterStory checkAndAddFriend success");
                StoryBaseInfo storyBaseInfo3 = StoryBaseInfo.this;
                String str = storyBaseInfo3 != null ? storyBaseInfo3.callbackData : null;
                if (str == null) {
                    str = "";
                }
                String str2 = str;
                StoryUtils storyUtils = StoryUtils.f366640a;
                final Context context2 = context;
                long j16 = a16;
                StoryAction storyAction = StoryAction.ENTERSTORY;
                final Function1<Boolean, Unit> function1 = cb5;
                final HalfViewCardNode halfViewCardNode = cardNode;
                final com.tencent.aio.api.runtime.a aVar = aioContext;
                storyUtils.F(context2, j16, str2, storyAction, true, new Function2<Boolean, Integer, Unit>() { // from class: com.tencent.robot.story.RobotStoryBoardViewModel$enterStory$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num) {
                        invoke(bool.booleanValue(), num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z16, int i3) {
                        QLog.i("RobotStoryBoardViewModel-RobotStory", 1, "enterStory success: " + z16);
                        function1.invoke(Boolean.valueOf(z16));
                        if (z16) {
                            StoryUtils.f366640a.w(halfViewCardNode.storyBaseInfo, aVar, true);
                        } else {
                            QQToast.makeText(context2, 1, i3, 1).show();
                        }
                    }
                });
            }
        });
    }

    public final void h(@NotNull String uid, int optId, @NotNull String filterData, boolean isLocal, @Nullable final Long currentStoryId) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(filterData, "filterData");
        this._pageStateLiveData.setValue(PageState.Loading);
        if (!AppNetConnInfo.isNetSupport()) {
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.ci7, 0).show();
            this._pageStateLiveData.setValue(PageState.Error);
        } else {
            StoryUtils.f366640a.m(uid, optId, filterData, isLocal, new Function3<Boolean, String, QueryHalfViewDataRsp, Unit>() { // from class: com.tencent.robot.story.RobotStoryBoardViewModel$fetchRobotStoryBoardData$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str, QueryHalfViewDataRsp queryHalfViewDataRsp) {
                    invoke(bool.booleanValue(), str, queryHalfViewDataRsp);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16, @NotNull String errMsg, @NotNull QueryHalfViewDataRsp rsp) {
                    MutableLiveData mutableLiveData;
                    MutableLiveData mutableLiveData2;
                    ArrayList arrayList;
                    MutableLiveData mutableLiveData3;
                    MutableLiveData mutableLiveData4;
                    List emptyList;
                    boolean n3;
                    Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                    Intrinsics.checkNotNullParameter(rsp, "rsp");
                    boolean z17 = true;
                    QLog.i("RobotStoryBoardViewModel-RobotStory", 1, "fetchRobotStoryHalfViewData success: " + z16 + " ,errMsg:" + errMsg + ", rsp = " + rsp);
                    if (z16) {
                        mutableLiveData2 = RobotStoryBoardViewModel.this._titleLiveData;
                        mutableLiveData2.setValue(rsp.topName);
                        ArrayList<HalfViewCardNode> arrayList2 = rsp.cardNodes;
                        if (arrayList2 != null) {
                            RobotStoryBoardViewModel robotStoryBoardViewModel = RobotStoryBoardViewModel.this;
                            Long l3 = currentStoryId;
                            arrayList = new ArrayList();
                            for (Object obj : arrayList2) {
                                n3 = robotStoryBoardViewModel.n(l3, ((HalfViewCardNode) obj).storyBaseInfo);
                                if (n3) {
                                    arrayList.add(obj);
                                }
                            }
                        } else {
                            arrayList = null;
                        }
                        ArrayList arrayList3 = arrayList;
                        if (arrayList3 != null && !arrayList3.isEmpty()) {
                            z17 = false;
                        }
                        if (z17) {
                            mutableLiveData3 = RobotStoryBoardViewModel.this._pageStateLiveData;
                            mutableLiveData3.setValue(PageState.Empty);
                            mutableLiveData4 = RobotStoryBoardViewModel.this._cardListLiveData;
                            emptyList = CollectionsKt__CollectionsKt.emptyList();
                            mutableLiveData4.setValue(emptyList);
                            return;
                        }
                        RobotStoryBoardViewModel.this.i(currentStoryId, rsp);
                        return;
                    }
                    mutableLiveData = RobotStoryBoardViewModel.this._pageStateLiveData;
                    mutableLiveData.setValue(PageState.Error);
                }
            });
        }
    }

    @NotNull
    public final LiveData<List<p64.a>> k() {
        return this._cardListLiveData;
    }

    @NotNull
    public final LiveData<PageState> l() {
        return this._pageStateLiveData;
    }

    @NotNull
    public final LiveData<String> m() {
        return this._titleLiveData;
    }
}

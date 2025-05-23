package com.tencent.robot.profile.section.story.section;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.android.androidbypass.richui.viewdata.k;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernel.nativeinterface.HalfViewCardNode;
import com.tencent.qqnt.kernel.nativeinterface.StoryAction;
import com.tencent.qqnt.kernel.nativeinterface.StoryBaseInfo;
import com.tencent.qqnt.richui.api.IRichUIViewDelegateFactoryApi;
import com.tencent.robot.adelie.homepage.utils.StoryUtils;
import com.tencent.robot.api.IRobotIdentityApi;
import com.tencent.robot.profile.data.RobotProfileStoryInfoData;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0014J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0014J(\u0010\u0012\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0014R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/robot/profile/section/story/section/RobotStoryProfileItemSection;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lcom/tencent/robot/profile/data/n$b;", "Lcom/tencent/qqnt/kernel/nativeinterface/StoryBaseInfo;", "storyBaseInfo", "", "u", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "", "position", "", "", "payload", ReportConstant.COSTREPORT_PREFIX, "Landroid/view/ViewGroup;", "d", "Landroid/view/ViewGroup;", "cardContainer", "<init>", "()V", "e", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotStoryProfileItemSection extends Section<RobotProfileStoryInfoData.RobotProfileStoryItemCardData> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final Map<Long, Boolean> f368084f = new LinkedHashMap();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ViewGroup cardContainer;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0004R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR \u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/robot/profile/section/story/section/RobotStoryProfileItemSection$a;", "", "", QQWinkConstants.STORY_ID, "", "c", "", "b", "a", "", "TAG", "Ljava/lang/String;", "", "reportedStoryIds", "Ljava/util/Map;", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.profile.section.story.section.RobotStoryProfileItemSection$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a() {
            RobotStoryProfileItemSection.f368084f.clear();
        }

        public final boolean b(long storyId) {
            Boolean bool;
            if (!RobotStoryProfileItemSection.f368084f.containsKey(Long.valueOf(storyId)) || (bool = (Boolean) RobotStoryProfileItemSection.f368084f.get(Long.valueOf(storyId))) == null) {
                return false;
            }
            return bool.booleanValue();
        }

        public final void c(long storyId) {
            RobotStoryProfileItemSection.f368084f.put(Long.valueOf(storyId), Boolean.TRUE);
        }

        Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(final RobotProfileStoryInfoData.RobotProfileStoryItemCardData data, final View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(data, "$data");
        ((IRobotIdentityApi) QRoute.api(IRobotIdentityApi.class)).checkAndAddFriend(data.getRobotUid(), new Function0<Unit>() { // from class: com.tencent.robot.profile.section.story.section.RobotStoryProfileItemSection$onBindData$1$1
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
                HalfViewCardNode card;
                StoryBaseInfo storyBaseInfo;
                QLog.e("RobotStoryProfileItemSection", 1, "enterStory checkAndAddFriend success");
                RobotProfileStoryInfoData.RobotProfileStoryItemCardData robotProfileStoryItemCardData = RobotProfileStoryInfoData.RobotProfileStoryItemCardData.this;
                String str = (robotProfileStoryItemCardData == null || (card = robotProfileStoryItemCardData.getCard()) == null || (storyBaseInfo = card.storyBaseInfo) == null) ? null : storyBaseInfo.callbackData;
                if (str == null) {
                    str = "";
                }
                String str2 = str;
                StoryUtils storyUtils = StoryUtils.f366640a;
                Context context = view.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "it.context");
                long parseLong = Long.parseLong(RobotProfileStoryInfoData.RobotProfileStoryItemCardData.this.getRobotUin());
                StoryAction storyAction = StoryAction.ENTERSTORY;
                final View view2 = view;
                final RobotProfileStoryInfoData.RobotProfileStoryItemCardData robotProfileStoryItemCardData2 = RobotProfileStoryInfoData.RobotProfileStoryItemCardData.this;
                storyUtils.F(context, parseLong, str2, storyAction, true, new Function2<Boolean, Integer, Unit>() { // from class: com.tencent.robot.profile.section.story.section.RobotStoryProfileItemSection$onBindData$1$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num) {
                        invoke(bool.booleanValue(), num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z16, int i3) {
                        QLog.i("RobotStoryProfileItemSection", 1, "enterStory success: " + z16);
                        if (z16) {
                            StoryUtils storyUtils2 = StoryUtils.f366640a;
                            Context context2 = view2.getContext();
                            Intrinsics.checkNotNullExpressionValue(context2, "it.context");
                            storyUtils2.u(context2, Long.parseLong(robotProfileStoryItemCardData2.getRobotUin()), robotProfileStoryItemCardData2.getRobotUid(), robotProfileStoryItemCardData2.getNick(), robotProfileStoryItemCardData2.getCard().storyBaseInfo, robotProfileStoryItemCardData2.getAioBundle());
                            return;
                        }
                        QQToast.makeText(view2.getContext(), 1, i3, 1).show();
                    }
                });
            }
        });
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void u(final StoryBaseInfo storyBaseInfo) {
        if (storyBaseInfo == null) {
            QLog.e("RobotStoryProfileItemSection", 1, "reportExposeIfNeed return, storyBaseInfo == null");
            return;
        }
        ViewGroup viewGroup = this.cardContainer;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardContainer");
            viewGroup = null;
        }
        VideoReport.setElementId(viewGroup, "em_bas_story_card");
        ViewGroup viewGroup3 = this.cardContainer;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardContainer");
            viewGroup3 = null;
        }
        VideoReport.setElementParam(viewGroup3, "plot_id", Long.valueOf(storyBaseInfo.storyId));
        ViewGroup viewGroup4 = this.cardContainer;
        if (viewGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardContainer");
            viewGroup4 = null;
        }
        VideoReport.setElementParam(viewGroup4, "plot_title", storyBaseInfo.title);
        ViewGroup viewGroup5 = this.cardContainer;
        if (viewGroup5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardContainer");
            viewGroup5 = null;
        }
        VideoReport.setElementClickPolicy(viewGroup5, ClickPolicy.REPORT_ALL);
        ViewGroup viewGroup6 = this.cardContainer;
        if (viewGroup6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardContainer");
            viewGroup6 = null;
        }
        VideoReport.setElementExposePolicy(viewGroup6, ExposurePolicy.REPORT_NONE);
        ViewGroup viewGroup7 = this.cardContainer;
        if (viewGroup7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardContainer");
            viewGroup7 = null;
        }
        VideoReport.setElementEndExposePolicy(viewGroup7, EndExposurePolicy.REPORT_NONE);
        if (!INSTANCE.b(storyBaseInfo.storyId)) {
            ViewGroup viewGroup8 = this.cardContainer;
            if (viewGroup8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cardContainer");
            } else {
                viewGroup2 = viewGroup8;
            }
            viewGroup2.post(new Runnable() { // from class: com.tencent.robot.profile.section.story.section.b
                @Override // java.lang.Runnable
                public final void run() {
                    RobotStoryProfileItemSection.v(StoryBaseInfo.this, this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(StoryBaseInfo storyBaseInfo, RobotStoryProfileItemSection this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        INSTANCE.c(storyBaseInfo.storyId);
        ViewGroup viewGroup = this$0.cardContainer;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardContainer");
            viewGroup = null;
        }
        VideoReport.reportEvent("imp", viewGroup, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.tne);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.card_container)");
        this.cardContainer = (ViewGroup) findViewById;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void onBindData(@NotNull final RobotProfileStoryInfoData.RobotProfileStoryItemCardData data, int position, @Nullable List<Object> payload) {
        ViewGroup viewGroup;
        Intrinsics.checkNotNullParameter(data, "data");
        k viewNode = data.getViewNode();
        ViewGroup viewGroup2 = this.cardContainer;
        StoryBaseInfo storyBaseInfo = null;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardContainer");
            viewGroup2 = null;
        }
        Context context = viewGroup2.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "cardContainer.context");
        View i3 = k.i(viewNode, context, ((IRichUIViewDelegateFactoryApi) QRoute.api(IRichUIViewDelegateFactoryApi.class)).getViewFactory(), null, 4, null);
        ViewParent parent = i3.getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        ViewGroup viewGroup3 = this.cardContainer;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardContainer");
            viewGroup3 = null;
        }
        viewGroup3.removeAllViews();
        ViewGroup viewGroup4 = this.cardContainer;
        if (viewGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardContainer");
            viewGroup4 = null;
        }
        viewGroup4.addView(i3);
        ViewGroup viewGroup5 = this.cardContainer;
        if (viewGroup5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardContainer");
            viewGroup5 = null;
        }
        viewGroup5.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.profile.section.story.section.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RobotStoryProfileItemSection.t(RobotProfileStoryInfoData.RobotProfileStoryItemCardData.this, view);
            }
        });
        HalfViewCardNode card = data.getCard();
        if (card != null) {
            storyBaseInfo = card.storyBaseInfo;
        }
        u(storyBaseInfo);
    }
}

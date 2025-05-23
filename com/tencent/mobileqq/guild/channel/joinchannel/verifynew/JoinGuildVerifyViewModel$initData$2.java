package com.tencent.mobileqq.guild.channel.joinchannel.verifynew;

import android.content.res.Resources;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildChoiceQuestionItem;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildSetting;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildWordQuestionItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wf1.AnswerItem;
import wf1.JoinGuildChoiceQuestion;
import wf1.JoinGuildHeadItem;
import wf1.JoinGuildSubmitItem;
import wf1.JoinGuildWordQuestion;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.channel.joinchannel.verifynew.JoinGuildVerifyViewModel$initData$2", f = "JoinGuildVerifyViewModel.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes12.dex */
public final class JoinGuildVerifyViewModel$initData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IGProJoinGuildSetting $joinGuildSetting;
    final /* synthetic */ JumpGuildParam $jumpGuildParam;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ JoinGuildVerifyViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JoinGuildVerifyViewModel$initData$2(JumpGuildParam jumpGuildParam, JoinGuildVerifyViewModel joinGuildVerifyViewModel, IGProJoinGuildSetting iGProJoinGuildSetting, Continuation<? super JoinGuildVerifyViewModel$initData$2> continuation) {
        super(2, continuation);
        this.$jumpGuildParam = jumpGuildParam;
        this.this$0 = joinGuildVerifyViewModel;
        this.$joinGuildSetting = iGProJoinGuildSetting;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        JoinGuildVerifyViewModel$initData$2 joinGuildVerifyViewModel$initData$2 = new JoinGuildVerifyViewModel$initData$2(this.$jumpGuildParam, this.this$0, this.$joinGuildSetting, continuation);
        joinGuildVerifyViewModel$initData$2.L$0 = obj;
        return joinGuildVerifyViewModel$initData$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Deferred o16;
        Object await;
        IGProGuildInfo h16;
        List list;
        List list2;
        int b26;
        List list3;
        List list4;
        List list5;
        List list6;
        MutableLiveData mutableLiveData;
        List list7;
        MutableLiveData mutableLiveData2;
        List list8;
        List list9;
        List list10;
        List list11;
        List list12;
        List list13;
        List list14;
        List list15;
        List list16;
        List list17;
        List list18;
        MutableLiveData mutableLiveData3;
        List list19;
        List list20;
        List list21;
        List list22;
        List list23;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
                await = obj;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            com.tencent.mobileqq.qcoroutine.api.coroutine.a c16 = CorountineFunKt.c((CoroutineScope) this.L$0, "Guild.join.verfiy.JoinGuildVerifyViewModel fetchGuildAndChannelInfo async1", null, null, new JoinGuildVerifyViewModel$initData$2$guildAndChannelInfoRspDeferred$1(this.$jumpGuildParam, null), 6, null);
            if (c16 != null && (o16 = c16.o()) != null) {
                this.label = 1;
                await = o16.await(this);
                if (await == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        GuildMainFrameUtils.GuildAndChannelInfoRsp guildAndChannelInfoRsp = (GuildMainFrameUtils.GuildAndChannelInfoRsp) await;
        if (guildAndChannelInfoRsp != null && (h16 = guildAndChannelInfoRsp.h()) != null) {
            JoinGuildVerifyViewModel joinGuildVerifyViewModel = this.this$0;
            IGProJoinGuildSetting iGProJoinGuildSetting = this.$joinGuildSetting;
            JumpGuildParam jumpGuildParam = this.$jumpGuildParam;
            Logger.f235387a.d().i("Guild.join.verfiy.JoinGuildVerifyViewModel", 1, "get guildInfo:" + h16);
            list = joinGuildVerifyViewModel.com.tencent.ttpic.openapi.util.VideoTemplateParser.ITEM_LIST java.lang.String;
            list2 = joinGuildVerifyViewModel.com.tencent.ttpic.openapi.util.VideoTemplateParser.ITEM_LIST java.lang.String;
            int size = list2.size();
            Resources resources = ch.i().getResources();
            b26 = joinGuildVerifyViewModel.b2(iGProJoinGuildSetting.getOptionType());
            String string = resources.getString(b26);
            Intrinsics.checkNotNullExpressionValue(string, "appContext().resources.g\u2026GuildSetting.optionType))");
            list.add(new JoinGuildHeadItem(size, string, null, h16, 4, null));
            int optionType = iGProJoinGuildSetting.getOptionType();
            if (optionType == 2) {
                list3 = joinGuildVerifyViewModel.com.tencent.ttpic.openapi.util.VideoTemplateParser.ITEM_LIST java.lang.String;
                list4 = joinGuildVerifyViewModel.com.tencent.ttpic.openapi.util.VideoTemplateParser.ITEM_LIST java.lang.String;
                list3.add(new JoinGuildWordQuestion(list4.size(), "", "", "\u8f93\u5165\u4f60\u7684\u7533\u8bf7\u7406\u7531", null, 16, null));
                list5 = joinGuildVerifyViewModel.com.tencent.ttpic.openapi.util.VideoTemplateParser.ITEM_LIST java.lang.String;
                list6 = joinGuildVerifyViewModel.com.tencent.ttpic.openapi.util.VideoTemplateParser.ITEM_LIST java.lang.String;
                int size2 = list6.size();
                String str = jumpGuildParam.guildId;
                Intrinsics.checkNotNullExpressionValue(str, "jumpGuildParam.guildId");
                list5.add(new JoinGuildSubmitItem(size2, null, null, str, false, 22, null));
            } else {
                int i16 = R.string.f147120w1;
                if (optionType != 4) {
                    if (optionType != 5) {
                        if (optionType != 6) {
                            if (optionType == 7) {
                                ArrayList<IGProJoinGuildChoiceQuestionItem> items = iGProJoinGuildSetting.getChoiceQuestion().getItems();
                                Intrinsics.checkNotNullExpressionValue(items, "joinGuildSetting.choiceQuestion.items");
                                for (IGProJoinGuildChoiceQuestionItem iGProJoinGuildChoiceQuestionItem : items) {
                                    ArrayList arrayList = new ArrayList();
                                    ArrayList<String> answers = iGProJoinGuildChoiceQuestionItem.getAnswers();
                                    Intrinsics.checkNotNullExpressionValue(answers, "questionItem.answers");
                                    for (String answer : answers) {
                                        int size3 = arrayList.size();
                                        Intrinsics.checkNotNullExpressionValue(answer, "answer");
                                        arrayList.add(new AnswerItem(size3, answer, false, 4, null));
                                    }
                                    list21 = joinGuildVerifyViewModel.com.tencent.ttpic.openapi.util.VideoTemplateParser.ITEM_LIST java.lang.String;
                                    list22 = joinGuildVerifyViewModel.com.tencent.ttpic.openapi.util.VideoTemplateParser.ITEM_LIST java.lang.String;
                                    int size4 = list22.size();
                                    String question = iGProJoinGuildChoiceQuestionItem.getQuestion();
                                    Intrinsics.checkNotNullExpressionValue(question, "questionItem.question");
                                    String qqStr = HardCodeUtil.qqStr(i16);
                                    list23 = joinGuildVerifyViewModel.com.tencent.ttpic.openapi.util.VideoTemplateParser.ITEM_LIST java.lang.String;
                                    list21.add(new JoinGuildChoiceQuestion(size4, question, qqStr + list23.size() + MsgSummary.STR_COLON, arrayList));
                                    i16 = R.string.f147120w1;
                                }
                                if (iGProJoinGuildSetting.getWordQuestion().getItems().size() == 1) {
                                    list19 = joinGuildVerifyViewModel.com.tencent.ttpic.openapi.util.VideoTemplateParser.ITEM_LIST java.lang.String;
                                    list20 = joinGuildVerifyViewModel.com.tencent.ttpic.openapi.util.VideoTemplateParser.ITEM_LIST java.lang.String;
                                    int size5 = list20.size();
                                    String str2 = jumpGuildParam.guildId;
                                    Intrinsics.checkNotNullExpressionValue(str2, "jumpGuildParam.guildId");
                                    list19.add(new JoinGuildSubmitItem(size5, null, null, str2, false, 22, null));
                                } else {
                                    mutableLiveData3 = joinGuildVerifyViewModel.submitBtnVisibleLiveData;
                                    mutableLiveData3.setValue(Boxing.boxBoolean(true));
                                }
                            }
                        }
                    } else {
                        ArrayList<IGProJoinGuildWordQuestionItem> items2 = iGProJoinGuildSetting.getWordQuestion().getItems();
                        Intrinsics.checkNotNullExpressionValue(items2, "joinGuildSetting.wordQuestion.items");
                        if (true ^ items2.isEmpty()) {
                            list15 = joinGuildVerifyViewModel.com.tencent.ttpic.openapi.util.VideoTemplateParser.ITEM_LIST java.lang.String;
                            list16 = joinGuildVerifyViewModel.com.tencent.ttpic.openapi.util.VideoTemplateParser.ITEM_LIST java.lang.String;
                            int size6 = list16.size();
                            String question2 = iGProJoinGuildSetting.getWordQuestion().getItems().get(0).getQuestion();
                            Intrinsics.checkNotNullExpressionValue(question2, "joinGuildSetting.wordQuestion.items[0].question");
                            list15.add(new JoinGuildWordQuestion(size6, question2, HardCodeUtil.qqStr(R.string.f147120w1) + MsgSummary.STR_COLON, "\u8f93\u5165\u4f60\u7684\u56de\u7b54", null, 16, null));
                            list17 = joinGuildVerifyViewModel.com.tencent.ttpic.openapi.util.VideoTemplateParser.ITEM_LIST java.lang.String;
                            list18 = joinGuildVerifyViewModel.com.tencent.ttpic.openapi.util.VideoTemplateParser.ITEM_LIST java.lang.String;
                            int size7 = list18.size();
                            String str3 = jumpGuildParam.guildId;
                            Intrinsics.checkNotNullExpressionValue(str3, "jumpGuildParam.guildId");
                            list17.add(new JoinGuildSubmitItem(size7, null, null, str3, false, 22, null));
                        }
                    }
                }
                if (iGProJoinGuildSetting.getWordQuestion().getItems().size() == 1) {
                    list11 = joinGuildVerifyViewModel.com.tencent.ttpic.openapi.util.VideoTemplateParser.ITEM_LIST java.lang.String;
                    list12 = joinGuildVerifyViewModel.com.tencent.ttpic.openapi.util.VideoTemplateParser.ITEM_LIST java.lang.String;
                    int size8 = list12.size();
                    String question3 = iGProJoinGuildSetting.getWordQuestion().getItems().get(0).getQuestion();
                    Intrinsics.checkNotNullExpressionValue(question3, "joinGuildSetting.wordQuestion.items[0].question");
                    list11.add(new JoinGuildWordQuestion(size8, question3, HardCodeUtil.qqStr(R.string.f147120w1) + MsgSummary.STR_COLON, "\u8f93\u5165\u4f60\u7684\u56de\u7b54", null, 16, null));
                    list13 = joinGuildVerifyViewModel.com.tencent.ttpic.openapi.util.VideoTemplateParser.ITEM_LIST java.lang.String;
                    list14 = joinGuildVerifyViewModel.com.tencent.ttpic.openapi.util.VideoTemplateParser.ITEM_LIST java.lang.String;
                    int size9 = list14.size();
                    String str4 = jumpGuildParam.guildId;
                    Intrinsics.checkNotNullExpressionValue(str4, "jumpGuildParam.guildId");
                    list13.add(new JoinGuildSubmitItem(size9, null, null, str4, false, 22, null));
                } else {
                    ArrayList<IGProJoinGuildWordQuestionItem> items3 = iGProJoinGuildSetting.getWordQuestion().getItems();
                    Intrinsics.checkNotNullExpressionValue(items3, "joinGuildSetting.wordQuestion.items");
                    for (IGProJoinGuildWordQuestionItem iGProJoinGuildWordQuestionItem : items3) {
                        list8 = joinGuildVerifyViewModel.com.tencent.ttpic.openapi.util.VideoTemplateParser.ITEM_LIST java.lang.String;
                        list9 = joinGuildVerifyViewModel.com.tencent.ttpic.openapi.util.VideoTemplateParser.ITEM_LIST java.lang.String;
                        int size10 = list9.size();
                        String question4 = iGProJoinGuildWordQuestionItem.getQuestion();
                        Intrinsics.checkNotNullExpressionValue(question4, "questionItem.question");
                        String qqStr2 = HardCodeUtil.qqStr(R.string.f147120w1);
                        list10 = joinGuildVerifyViewModel.com.tencent.ttpic.openapi.util.VideoTemplateParser.ITEM_LIST java.lang.String;
                        list8.add(new JoinGuildWordQuestion(size10, question4, qqStr2 + list10.size() + MsgSummary.STR_COLON, "\u8f93\u5165\u4f60\u7684\u56de\u7b54", null, 16, null));
                    }
                    mutableLiveData2 = joinGuildVerifyViewModel.submitBtnVisibleLiveData;
                    mutableLiveData2.setValue(Boxing.boxBoolean(true));
                }
            }
            mutableLiveData = joinGuildVerifyViewModel.dataListLiveData;
            list7 = joinGuildVerifyViewModel.com.tencent.ttpic.openapi.util.VideoTemplateParser.ITEM_LIST java.lang.String;
            mutableLiveData.setValue(list7);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((JoinGuildVerifyViewModel$initData$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}

package com.tencent.mobileqq.troop.teamup.publish.vm;

import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.google.gson.Gson;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.BaseItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.ContentItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.TitleItem;
import com.tencent.mobileqq.troop.teamup.publish.data.TroopTeamUpJoinType;
import com.tencent.mobileqq.troop.teamup.publish.data.TroopTeamUpTemplateKt;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.s;
import com.tencent.qqnt.kernel.nativeinterface.PostTeamUpReq;
import com.tencent.qqnt.kernel.nativeinterface.PostTeamUpRsp;
import com.tencent.qqnt.kernel.nativeinterface.TeamUpAttachment;
import com.tencent.qqnt.kernel.nativeinterface.TeamUpTeamDetail;
import com.tencent.qqnt.kernel.nativeinterface.TeamUpTemplate;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010B\u001a\u00020A\u00a2\u0006\u0004\bC\u0010DJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u001d\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\tR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\u00108\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u001a\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001e\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u001c\u0010\u0014\"\u0004\b\u001d\u0010\u0019R\u0017\u0010$\u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001f\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0%8\u0006\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001f\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010,0%8\u0006\u00a2\u0006\f\n\u0004\b-\u0010(\u001a\u0004\b.\u0010*R%\u00103\u001a\u0010\u0012\f\u0012\n 0*\u0004\u0018\u00010\u00100\u00100%8\u0006\u00a2\u0006\f\n\u0004\b1\u0010(\u001a\u0004\b2\u0010*R%\u00105\u001a\u0010\u0012\f\u0012\n 0*\u0004\u0018\u00010\u00020\u00020%8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010(\u001a\u0004\b4\u0010*R#\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000207060%8\u0006\u00a2\u0006\f\n\u0004\b8\u0010(\u001a\u0004\b9\u0010*R\u0017\u0010@\u001a\u00020;8\u0006\u00a2\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/publish/vm/TroopTeamUpPublishVM;", "Landroidx/lifecycle/ViewModel;", "", "T1", "Lcom/tencent/qqnt/kernel/nativeinterface/PostTeamUpReq;", "L1", "req", "Lcom/tencent/qqnt/kernel/nativeinterface/PostTeamUpRsp;", "W1", "(Lcom/tencent/qqnt/kernel/nativeinterface/PostTeamUpReq;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpTemplate;", "i", "Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpTemplate;", "Q1", "()Lcom/tencent/qqnt/kernel/nativeinterface/TeamUpTemplate;", "template", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "O1", "()I", "maxMediaCount", BdhLogUtil.LogTag.Tag_Conn, "getMaxTitleWordCount", "setMaxTitleWordCount", "(I)V", "maxTitleWordCount", "D", "getMaxContentWordCount", "setMaxContentWordCount", "maxContentWordCount", "", "E", "Ljava/lang/String;", "R1", "()Ljava/lang/String;", "troopUin", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/troop/teamup/publish/data/TroopTeamUpJoinType;", UserInfo.SEX_FEMALE, "Landroidx/lifecycle/MutableLiveData;", "N1", "()Landroidx/lifecycle/MutableLiveData;", "joinType", "Ljava/util/Calendar;", "G", "M1", "deadline", "kotlin.jvm.PlatformType", "H", "getJoinLimit", "joinLimit", "U1", "isPublishSucceed", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "J", "S1", "uiItems", "Lcom/tencent/mobileqq/troop/teamup/publish/vm/a;", "K", "Lcom/tencent/mobileqq/troop/teamup/publish/vm/a;", "P1", "()Lcom/tencent/mobileqq/troop/teamup/publish/vm/a;", "mediaDataModel", "Landroid/os/Bundle;", "bundle", "<init>", "(Landroid/os/Bundle;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopTeamUpPublishVM extends ViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    private int maxTitleWordCount;

    /* renamed from: D, reason: from kotlin metadata */
    private int maxContentWordCount;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<TroopTeamUpJoinType> joinType;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Calendar> deadline;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Integer> joinLimit;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> isPublishSucceed;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<Group>> uiItems;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final a mediaDataModel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final TeamUpTemplate template;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int maxMediaCount;

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0102, code lost:
    
        if (r0 == null) goto L48;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TroopTeamUpPublishVM(@NotNull Bundle bundle) {
        Object m476constructorimpl;
        TroopTeamUpJoinType troopTeamUpJoinType;
        boolean z16;
        List<BaseItem> emptyList;
        ArrayList<TeamUpAttachment> attachments;
        String a16;
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bundle);
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl((TeamUpTemplate) new Gson().fromJson(bundle.getString("template_json_string"), TeamUpTemplate.class));
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        TeamUpTemplate teamUpTemplate = (TeamUpTemplate) (Result.m482isFailureimpl(m476constructorimpl) ? null : m476constructorimpl);
        this.template = teamUpTemplate;
        this.maxMediaCount = 10;
        this.maxTitleWordCount = 10;
        this.maxContentWordCount = 500;
        String str = "";
        String string = bundle.getString("troop_uin", "");
        Intrinsics.checkNotNullExpressionValue(string, "bundle.getString(AppConstants.Key.TROOP_UIN, \"\")");
        this.troopUin = string;
        if (teamUpTemplate != null) {
            troopTeamUpJoinType = TroopTeamUpTemplateKt.b(teamUpTemplate);
        } else {
            troopTeamUpJoinType = null;
        }
        this.joinType = new MutableLiveData<>(troopTeamUpJoinType);
        this.deadline = new MutableLiveData<>();
        this.joinLimit = new MutableLiveData<>(200);
        this.isPublishSucceed = new MutableLiveData<>(Boolean.FALSE);
        this.uiItems = new MutableLiveData<>(new ArrayList());
        a aVar = new a();
        TitleItem r16 = aVar.r();
        String str2 = teamUpTemplate != null ? teamUpTemplate.title : null;
        if (str2 == null) {
            str2 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str2, "template?.title ?: \"\"");
        }
        r16.setTitle(str2);
        r16.setMaxWordCount(this.maxTitleWordCount);
        r16.setInputMaxLen(Integer.MAX_VALUE);
        if (teamUpTemplate == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        r16.setReqFocus(z16);
        if (r16.isReqFocus()) {
            r16.setShowInputMethodOnce(true);
        }
        ContentItem k3 = aVar.k();
        if (teamUpTemplate != null && (a16 = TroopTeamUpTemplateKt.a(teamUpTemplate)) != null) {
            str = a16;
        }
        k3.setContent(str);
        k3.setMaxWordCount(this.maxContentWordCount);
        k3.setReqFocus(teamUpTemplate != null);
        if (teamUpTemplate != null && (attachments = teamUpTemplate.attachments) != null) {
            Intrinsics.checkNotNullExpressionValue(attachments, "attachments");
            emptyList = TroopTeamUpTemplateKt.c(attachments);
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        aVar.u(emptyList);
        this.mediaDataModel = aVar;
    }

    @Nullable
    public final PostTeamUpReq L1() {
        boolean isBlank;
        boolean isBlank2;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) {
            isBlank = StringsKt__StringsJVMKt.isBlank(this.mediaDataModel.r().getTitle());
            if (isBlank) {
                QQToastUtil.showQQToast(1, "\u8bf7\u586b\u5199\u6807\u9898\u540e\u53d1\u5e03");
                return null;
            }
            this.mediaDataModel.r().getCurrentWordCount();
            int currentWordCount = this.mediaDataModel.r().getCurrentWordCount();
            int i16 = this.maxTitleWordCount;
            if (currentWordCount <= i16) {
                isBlank2 = StringsKt__StringsJVMKt.isBlank(this.mediaDataModel.k().getContent());
                if (isBlank2) {
                    QQToastUtil.showQQToast(1, "\u8bf7\u586b\u5199\u5185\u5bb9\u540e\u53d1\u5e03");
                    return null;
                }
                int currentWordCount2 = this.mediaDataModel.k().getCurrentWordCount();
                int i17 = this.maxContentWordCount;
                if (currentWordCount2 > i17) {
                    QQToastUtil.showQQToast(1, "\u8bf7\u63a7\u5236\u5185\u5bb9\u5728" + i17 + "\u5b57\u4ee5\u5185");
                    return null;
                }
                TroopTeamUpJoinType value = this.joinType.getValue();
                if (value == null) {
                    QQToastUtil.showQQToast(1, "\u8bf7\u5b8c\u6210\u53c2\u4e0e\u65b9\u5f0f\u914d\u7f6e\u540e\u53d1\u5e03");
                    return null;
                }
                Calendar value2 = this.deadline.getValue();
                if (value2 == null) {
                    QQToastUtil.showQQToast(1, "\u8bf7\u5b8c\u6210\u622a\u6b62\u65f6\u95f4\u914d\u7f6e\u540e\u53d1\u5e03");
                    return null;
                }
                if (Calendar.getInstance().compareTo(value2) >= 0) {
                    QQToastUtil.showQQToast(1, "\u622a\u6b62\u65f6\u95f4\u5fc5\u987b\u665a\u4e8e\u5f53\u524d\u65f6\u95f4");
                    return null;
                }
                if (!this.mediaDataModel.d()) {
                    QQToastUtil.showQQToast(1, "\u8bf7\u7b49\u5f85\u8d44\u6e90\u4e0a\u4f20\u5b8c\u6210\u540e\u518d\u53d1\u5e03");
                    return null;
                }
                PostTeamUpReq postTeamUpReq = new PostTeamUpReq();
                TeamUpTeamDetail teamUpTeamDetail = new TeamUpTeamDetail();
                teamUpTeamDetail.groupId = Long.parseLong(this.troopUin);
                teamUpTeamDetail.title = this.mediaDataModel.r().getTitle();
                teamUpTeamDetail.content = this.mediaDataModel.k().getContent();
                teamUpTeamDetail.endTime = value2.getTimeInMillis() / 1000;
                teamUpTeamDetail.images = this.mediaDataModel.v();
                TeamUpTemplate teamUpTemplate = this.template;
                if (teamUpTemplate != null) {
                    i3 = teamUpTemplate.templateId;
                } else {
                    i3 = 0;
                }
                teamUpTeamDetail.templateId = i3;
                teamUpTeamDetail.joinType = value.getProtoValue();
                Integer value3 = this.joinLimit.getValue();
                Intrinsics.checkNotNull(value3);
                teamUpTeamDetail.joinLimit = value3.intValue();
                postTeamUpReq.detail = teamUpTeamDetail;
                return postTeamUpReq;
            }
            QQToastUtil.showQQToast(1, "\u8bf7\u63a7\u5236\u6807\u9898\u5728" + i16 + "\u5b57\u4ee5\u5185");
            return null;
        }
        return (PostTeamUpReq) iPatchRedirector.redirect((short) 16, (Object) this);
    }

    @NotNull
    public final MutableLiveData<Calendar> M1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.deadline;
    }

    @NotNull
    public final MutableLiveData<TroopTeamUpJoinType> N1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.joinType;
    }

    public final int O1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.maxMediaCount;
    }

    @NotNull
    public final a P1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (a) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.mediaDataModel;
    }

    @Nullable
    public final TeamUpTemplate Q1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TeamUpTemplate) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.template;
    }

    @NotNull
    public final String R1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.troopUin;
    }

    @NotNull
    public final MutableLiveData<List<Group>> S1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.uiItems;
    }

    public final boolean T1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        if (this.joinType.getValue() == null && this.deadline.getValue() == null && this.mediaDataModel.w()) {
            return true;
        }
        return false;
    }

    @NotNull
    public final MutableLiveData<Boolean> U1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.isPublishSucceed;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0044  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object W1(@NotNull PostTeamUpReq postTeamUpReq, @NotNull Continuation<? super PostTeamUpRsp> continuation) {
        TroopTeamUpPublishVM$post$1 troopTeamUpPublishVM$post$1;
        Object coroutine_suspended;
        int i3;
        PostTeamUpRsp postTeamUpRsp;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return iPatchRedirector.redirect((short) 17, (Object) this, (Object) postTeamUpReq, (Object) continuation);
        }
        if (continuation instanceof TroopTeamUpPublishVM$post$1) {
            troopTeamUpPublishVM$post$1 = (TroopTeamUpPublishVM$post$1) continuation;
            int i16 = troopTeamUpPublishVM$post$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                troopTeamUpPublishVM$post$1.label = i16 - Integer.MIN_VALUE;
                Object obj = troopTeamUpPublishVM$post$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = troopTeamUpPublishVM$post$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    s i17 = bg.i(null, 1, null);
                    if (i17 == null) {
                        QLog.e("TroopTeamUp.PublishPublishVM", 1, "service == null");
                        return null;
                    }
                    troopTeamUpPublishVM$post$1.label = 1;
                    obj = b.a(i17, postTeamUpReq, troopTeamUpPublishVM$post$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                postTeamUpRsp = (PostTeamUpRsp) obj;
                if (postTeamUpRsp != null) {
                    QQToastUtil.showQQToast(1, "\u53d1\u5e03\u5931\u8d25");
                    return null;
                }
                QQToastUtil.showQQToast(2, "\u53d1\u5e03\u6210\u529f");
                return postTeamUpRsp;
            }
        }
        troopTeamUpPublishVM$post$1 = new TroopTeamUpPublishVM$post$1(this, continuation);
        Object obj2 = troopTeamUpPublishVM$post$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = troopTeamUpPublishVM$post$1.label;
        if (i3 == 0) {
        }
        postTeamUpRsp = (PostTeamUpRsp) obj2;
        if (postTeamUpRsp != null) {
        }
    }
}

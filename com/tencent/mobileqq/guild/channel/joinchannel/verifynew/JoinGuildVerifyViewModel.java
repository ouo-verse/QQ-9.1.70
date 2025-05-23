package com.tencent.mobileqq.guild.channel.joinchannel.verifynew;

import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.channel.joinchannel.verifynew.a;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.GuildSourceId;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.ay;
import com.tencent.mobileqq.qqguildsdk.data.az;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildSetting;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.bv;
import wf1.AnswerItem;
import wf1.JoinGuildChoiceQuestion;
import wf1.JoinGuildSubmitItem;
import wf1.JoinGuildWordQuestion;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010!\n\u0002\b\u0016\u0018\u0000 F2\u00020\u00012\u00020\u0002:\u0002GHB\u0007\u00a2\u0006\u0004\bD\u0010EJ\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0016\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015J\u0018\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001e\u001a\u00020\u000eH\u0016J\u0012\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180 0\u001fJ\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060\u001fJ\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\u001fJ\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00030\u001fJ\f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u001fJ\b\u0010'\u001a\u0004\u0018\u00010%R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R \u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180 0\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u001c\u00100\u001a\b\u0012\u0004\u0012\u00020\u00060\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010-R\u001c\u00102\u001a\b\u0012\u0004\u0012\u00020\u00060\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010-R\u001c\u00106\u001a\b\u0012\u0004\u0012\u00020\u0018038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u001a\u00108\u001a\b\u0012\u0004\u0012\u00020\u00030\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u0010-R\u001c\u0010:\u001a\b\u0012\u0004\u0012\u00020%0\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010-R\u0018\u0010=\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010@\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010C\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010B\u00a8\u0006I"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/joinchannel/verifynew/JoinGuildVerifyViewModel;", "Lef1/b;", "Lcom/tencent/mobileqq/guild/channel/joinchannel/verifynew/a$b;", "", "optionType", "b2", "", "enable", "i2", "T1", "Lcom/tencent/mobileqq/qqguildsdk/data/GuildSourceId;", "guildSourceId", "Lcom/tencent/mobileqq/qqguildsdk/data/az$a;", "e2", "", SemanticAttributes.DbSystemValues.H2, "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "report", "g2", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "jumpGuildParam", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProJoinGuildSetting;", "joinGuildSetting", "d2", "Lwf1/b;", "question", "", "content", "f1", "l0", "k", "Landroidx/lifecycle/MutableLiveData;", "", "U1", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Z1", "c2", "Lcom/tencent/mobileqq/guild/channel/joinchannel/verifynew/JoinGuildVerifyViewModel$b;", "X1", "W1", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProJoinGuildSetting;", "D", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "E", "Landroidx/lifecycle/MutableLiveData;", "dataListLiveData", UserInfo.SEX_FEMALE, "submitBtnVisibleLiveData", "G", "submitBtnEnableLiveData", "", "H", "Ljava/util/List;", VideoTemplateParser.ITEM_LIST, "I", "verifyState", "J", "joinResultLiveData", "K", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "reportTask", "L", "Lcom/tencent/mobileqq/guild/channel/joinchannel/verifynew/JoinGuildVerifyViewModel$b;", "lastRequestResult", "M", "Z", "isSendingReq", "<init>", "()V", "N", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class JoinGuildVerifyViewModel extends ef1.b implements a.b {

    /* renamed from: C, reason: from kotlin metadata */
    private IGProJoinGuildSetting joinGuildSetting;

    /* renamed from: D, reason: from kotlin metadata */
    private JumpGuildParam jumpGuildParam;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<wf1.b>> dataListLiveData = new MutableLiveData<>();

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<Boolean> submitBtnVisibleLiveData;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<Boolean> submitBtnEnableLiveData;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private List<wf1.b> itemList;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Integer> verifyState;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<JoinResult> joinResultLiveData;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private IPerformanceReportTask reportTask;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private JoinResult lastRequestResult;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean isSendingReq;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\t\u0010\u0010R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00128\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0018\u001a\u0004\b\u000e\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/joinchannel/verifynew/JoinGuildVerifyViewModel$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "c", "()I", "result", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "errorMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;", "d", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;", "security", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProJoinGuildResult;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProJoinGuildResult;", "()Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProJoinGuildResult;", "joinGuildsRest", "<init>", "(ILjava/lang/String;Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProJoinGuildResult;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.channel.joinchannel.verifynew.JoinGuildVerifyViewModel$b, reason: from toString */
    /* loaded from: classes12.dex */
    public static final /* data */ class JoinResult {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int result;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String errorMsg;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final IGProSecurityResult security;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final IGProJoinGuildResult joinGuildsRest;

        public JoinResult(int i3, @NotNull String errorMsg, @Nullable IGProSecurityResult iGProSecurityResult, @Nullable IGProJoinGuildResult iGProJoinGuildResult) {
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            this.result = i3;
            this.errorMsg = errorMsg;
            this.security = iGProSecurityResult;
            this.joinGuildsRest = iGProJoinGuildResult;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getErrorMsg() {
            return this.errorMsg;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final IGProJoinGuildResult getJoinGuildsRest() {
            return this.joinGuildsRest;
        }

        /* renamed from: c, reason: from getter */
        public final int getResult() {
            return this.result;
        }

        @Nullable
        /* renamed from: d, reason: from getter */
        public final IGProSecurityResult getSecurity() {
            return this.security;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof JoinResult)) {
                return false;
            }
            JoinResult joinResult = (JoinResult) other;
            if (this.result == joinResult.result && Intrinsics.areEqual(this.errorMsg, joinResult.errorMsg) && Intrinsics.areEqual(this.security, joinResult.security) && Intrinsics.areEqual(this.joinGuildsRest, joinResult.joinGuildsRest)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = ((this.result * 31) + this.errorMsg.hashCode()) * 31;
            IGProSecurityResult iGProSecurityResult = this.security;
            int i3 = 0;
            if (iGProSecurityResult == null) {
                hashCode = 0;
            } else {
                hashCode = iGProSecurityResult.hashCode();
            }
            int i16 = (hashCode2 + hashCode) * 31;
            IGProJoinGuildResult iGProJoinGuildResult = this.joinGuildsRest;
            if (iGProJoinGuildResult != null) {
                i3 = iGProJoinGuildResult.hashCode();
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            return "JoinResult(result=" + this.result + ", errorMsg=" + this.errorMsg + ", security=" + this.security + ", joinGuildsRest=" + this.joinGuildsRest + ")";
        }
    }

    public JoinGuildVerifyViewModel() {
        Boolean bool = Boolean.FALSE;
        this.submitBtnVisibleLiveData = new MutableLiveData<>(bool);
        this.submitBtnEnableLiveData = new MutableLiveData<>(bool);
        this.itemList = new ArrayList();
        this.verifyState = new MutableLiveData<>();
        this.joinResultLiveData = new MutableLiveData<>();
    }

    private final boolean T1() {
        if (this.itemList.isEmpty()) {
            return false;
        }
        for (wf1.b bVar : this.itemList) {
            if ((bVar instanceof JoinGuildWordQuestion) && !((JoinGuildWordQuestion) bVar).f()) {
                return false;
            }
            if ((bVar instanceof JoinGuildChoiceQuestion) && !((JoinGuildChoiceQuestion) bVar).f()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int b2(int optionType) {
        if (optionType == 2) {
            return R.string.f147230wb;
        }
        if (optionType != 4) {
            if (optionType != 5) {
                if (optionType != 6) {
                    if (optionType != 7) {
                        return R.string.f147230wb;
                    }
                    return R.string.f147260we;
                }
            } else {
                return R.string.f147240wc;
            }
        }
        return R.string.f147250wd;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004d, code lost:
    
        if (r1 != 7) goto L61;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final az.a e2(GuildSourceId guildSourceId) {
        Object obj;
        boolean isBlank;
        boolean z16;
        Object obj2;
        az.a aVar = new az.a();
        JumpGuildParam jumpGuildParam = this.jumpGuildParam;
        if (jumpGuildParam == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jumpGuildParam");
            jumpGuildParam = null;
        }
        az.a i3 = aVar.i(jumpGuildParam.guildId);
        JumpGuildParam jumpGuildParam2 = this.jumpGuildParam;
        if (jumpGuildParam2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jumpGuildParam");
            jumpGuildParam2 = null;
        }
        az.a k3 = i3.j(jumpGuildParam2.getJoinSignature()).k(guildSourceId);
        ArrayList<ay> arrayList = new ArrayList<>();
        IGProJoinGuildSetting iGProJoinGuildSetting = this.joinGuildSetting;
        if (iGProJoinGuildSetting == null) {
            Intrinsics.throwUninitializedPropertyAccessException("joinGuildSetting");
            iGProJoinGuildSetting = null;
        }
        int optionType = iGProJoinGuildSetting.getOptionType();
        if (optionType != 2) {
            if (optionType != 4) {
                if (optionType != 5) {
                    if (optionType != 6) {
                    }
                }
            }
            for (wf1.b bVar : this.itemList) {
                if (bVar instanceof JoinGuildWordQuestion) {
                    ay ayVar = new ay(bVar.getQuestion(), ((JoinGuildWordQuestion) bVar).getAnswer());
                    String a16 = ayVar.a();
                    Intrinsics.checkNotNullExpressionValue(a16, "answerInfo.answer");
                    if (a16.length() == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        h2();
                        return null;
                    }
                    arrayList.add(ayVar);
                } else if (bVar instanceof JoinGuildChoiceQuestion) {
                    Iterator<T> it = ((JoinGuildChoiceQuestion) bVar).c().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            obj2 = it.next();
                            if (((AnswerItem) obj2).getIsSelected()) {
                                break;
                            }
                        } else {
                            obj2 = null;
                            break;
                        }
                    }
                    AnswerItem answerItem = (AnswerItem) obj2;
                    if (answerItem != null) {
                        arrayList.add(new ay(bVar.getQuestion(), answerItem.getAnswerContent()));
                    } else {
                        h2();
                        return null;
                    }
                } else {
                    continue;
                }
            }
            k3.f(arrayList);
            return k3;
        }
        Iterator<T> it5 = this.itemList.iterator();
        while (true) {
            if (it5.hasNext()) {
                obj = it5.next();
                if (((wf1.b) obj) instanceof JoinGuildWordQuestion) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        wf1.b bVar2 = (wf1.b) obj;
        if (bVar2 instanceof JoinGuildWordQuestion) {
            JoinGuildWordQuestion joinGuildWordQuestion = (JoinGuildWordQuestion) bVar2;
            isBlank = StringsKt__StringsJVMKt.isBlank(joinGuildWordQuestion.getAnswer());
            if (!isBlank) {
                k3.h(joinGuildWordQuestion.getAnswer());
                k3.f(arrayList);
                return k3;
            }
        }
        h2();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f2(JoinGuildVerifyViewModel this$0, IPerformanceReportTask iPerformanceReportTask, int i3, String errMsg, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger.f235387a.d().i("Guild.join.verfiy.JoinGuildVerifyViewModel", 1, "addGuildWithOption result:" + i3 + " errmsg:" + errMsg + " security:" + iGProSecurityResult + " joinGuildsRest" + iGProJoinGuildResult);
        this$0.isSendingReq = false;
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        this$0.lastRequestResult = new JoinResult(i3, errMsg, iGProSecurityResult, iGProJoinGuildResult);
        if (iPerformanceReportTask != null) {
            iPerformanceReportTask.setResultCode(i3);
        }
        if (iPerformanceReportTask != null) {
            iPerformanceReportTask.setResultMsg(errMsg);
        }
        if (iPerformanceReportTask != null) {
            iPerformanceReportTask.report();
        }
        if (i3 != 0) {
            switch (i3) {
                case 22006:
                case 22009:
                case 22010:
                    QQToastUtil.showQQToast(0, errMsg);
                    this$0.verifyState.setValue(2);
                    return;
                case 22007:
                    QQToastUtil.showQQToast(1, errMsg);
                    this$0.verifyState.setValue(1);
                    return;
                case 22008:
                    QQToastUtil.showQQToast(0, errMsg);
                    this$0.verifyState.setValue(2);
                    return;
                default:
                    this$0.verifyState.setValue(2);
                    return;
            }
        }
        this$0.verifyState.setValue(2);
    }

    private final void h2() {
        Logger.f235387a.d().w("Guild.join.verfiy.JoinGuildVerifyViewModel", 1, "no answer");
        QQToastUtil.showQQToastInUiThread(1, HardCodeUtil.qqStr(R.string.f147000vp));
    }

    private final boolean i2(boolean enable) {
        if (!this.itemList.isEmpty()) {
            List<wf1.b> list = this.itemList;
            wf1.b bVar = list.get(list.size() - 1);
            if (bVar instanceof JoinGuildSubmitItem) {
                JoinGuildSubmitItem c16 = JoinGuildSubmitItem.c((JoinGuildSubmitItem) bVar, 0, null, null, null, false, 31, null);
                c16.h(enable);
                List<wf1.b> list2 = this.itemList;
                list2.set(list2.size() - 1, c16);
                this.dataListLiveData.setValue(this.itemList);
                return true;
            }
            return false;
        }
        return false;
    }

    @NotNull
    public final MutableLiveData<List<wf1.b>> U1() {
        return this.dataListLiveData;
    }

    @Nullable
    /* renamed from: W1, reason: from getter */
    public final JoinResult getLastRequestResult() {
        return this.lastRequestResult;
    }

    @NotNull
    public final MutableLiveData<JoinResult> X1() {
        return this.joinResultLiveData;
    }

    @NotNull
    public final MutableLiveData<Boolean> Z1() {
        return this.submitBtnVisibleLiveData;
    }

    @NotNull
    public final MutableLiveData<Boolean> a2() {
        return this.submitBtnEnableLiveData;
    }

    @NotNull
    public final MutableLiveData<Integer> c2() {
        return this.verifyState;
    }

    public final void d2(@NotNull JumpGuildParam jumpGuildParam, @NotNull IGProJoinGuildSetting joinGuildSetting) {
        Intrinsics.checkNotNullParameter(jumpGuildParam, "jumpGuildParam");
        Intrinsics.checkNotNullParameter(joinGuildSetting, "joinGuildSetting");
        Logger.f235387a.d().i("Guild.join.verfiy.JoinGuildVerifyViewModel", 1, "initData jumpGuildParam:" + jumpGuildParam + " joinGuildSetting:" + joinGuildSetting);
        this.verifyState.setValue(0);
        this.itemList.clear();
        this.jumpGuildParam = jumpGuildParam;
        this.joinGuildSetting = joinGuildSetting;
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "Guild.join.verfiy.JoinGuildVerifyViewModel fetchGuildAndChannelInfo", null, null, null, new JoinGuildVerifyViewModel$initData$2(jumpGuildParam, this, joinGuildSetting, null), 14, null);
        }
    }

    @Override // com.tencent.mobileqq.guild.channel.joinchannel.verifynew.a.b
    public void f1(@NotNull wf1.b question, @NotNull String content) {
        Intrinsics.checkNotNullParameter(question, "question");
        Intrinsics.checkNotNullParameter(content, "content");
        Logger.a d16 = Logger.f235387a.d();
        JumpGuildParam jumpGuildParam = this.jumpGuildParam;
        IGProJoinGuildSetting iGProJoinGuildSetting = null;
        if (jumpGuildParam == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jumpGuildParam");
            jumpGuildParam = null;
        }
        boolean z16 = true;
        d16.i("Guild.join.verfiy.JoinGuildVerifyViewModel", 1, "onWordQuestionTextChanged guildId:" + jumpGuildParam.guildId + " question:" + question + " content:" + content);
        IGProJoinGuildSetting iGProJoinGuildSetting2 = this.joinGuildSetting;
        if (iGProJoinGuildSetting2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("joinGuildSetting");
            iGProJoinGuildSetting2 = null;
        }
        if (iGProJoinGuildSetting2.getOptionType() != 2) {
            IGProJoinGuildSetting iGProJoinGuildSetting3 = this.joinGuildSetting;
            if (iGProJoinGuildSetting3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("joinGuildSetting");
            } else {
                iGProJoinGuildSetting = iGProJoinGuildSetting3;
            }
            if (iGProJoinGuildSetting.getOptionType() != 5) {
                boolean T1 = T1();
                if (!i2(T1)) {
                    this.submitBtnEnableLiveData.setValue(Boolean.valueOf(T1));
                    return;
                }
                return;
            }
        }
        if (content.length() <= 0) {
            z16 = false;
        }
        i2(z16);
    }

    public final void g2(@Nullable IPerformanceReportTask report) {
        this.reportTask = report;
    }

    @Override // com.tencent.mobileqq.guild.channel.joinchannel.verifynew.a.b
    public void k() {
        final IPerformanceReportTask iPerformanceReportTask;
        JumpGuildParam jumpGuildParam = this.jumpGuildParam;
        JumpGuildParam jumpGuildParam2 = null;
        if (jumpGuildParam == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jumpGuildParam");
            jumpGuildParam = null;
        }
        String mainSource = jumpGuildParam.getJoinInfoParam().getMainSource();
        Intrinsics.checkNotNullExpressionValue(mainSource, "jumpGuildParam.joinInfoParam.mainSource");
        JumpGuildParam jumpGuildParam3 = this.jumpGuildParam;
        if (jumpGuildParam3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jumpGuildParam");
            jumpGuildParam3 = null;
        }
        String subSource = jumpGuildParam3.getJoinInfoParam().getSubSource();
        Intrinsics.checkNotNullExpressionValue(subSource, "jumpGuildParam.joinInfoParam.subSource");
        JumpGuildParam jumpGuildParam4 = this.jumpGuildParam;
        if (jumpGuildParam4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jumpGuildParam");
            jumpGuildParam4 = null;
        }
        int pageEntranceId = jumpGuildParam4.getJoinInfoParam().getPageEntranceId();
        JumpGuildParam jumpGuildParam5 = this.jumpGuildParam;
        if (jumpGuildParam5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jumpGuildParam");
            jumpGuildParam5 = null;
        }
        String string = jumpGuildParam5.extras.getString("sgrp_channel_extension_info", "");
        Intrinsics.checkNotNullExpressionValue(string, "jumpGuildParam.extras.ge\u2026nnel_extension_info\", \"\")");
        az.a e26 = e2(com.tencent.mobileqq.guild.channel.joinchannel.g.b(mainSource, subSource, pageEntranceId, 0, string));
        if (e26 == null) {
            return;
        }
        IPerformanceReportTask iPerformanceReportTask2 = this.reportTask;
        if (iPerformanceReportTask2 != null) {
            iPerformanceReportTask = iPerformanceReportTask2.duplicate(new String[0]);
        } else {
            iPerformanceReportTask = null;
        }
        if (iPerformanceReportTask != null) {
            iPerformanceReportTask.setStageCode("stage_send_join_guild_cmd_with_option");
        }
        if (this.isSendingReq) {
            Logger.a d16 = Logger.f235387a.d();
            JumpGuildParam jumpGuildParam6 = this.jumpGuildParam;
            if (jumpGuildParam6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("jumpGuildParam");
            } else {
                jumpGuildParam2 = jumpGuildParam6;
            }
            d16.w("Guild.join.verfiy.JoinGuildVerifyViewModel", 1, "submit guildId:" + jumpGuildParam2.guildId + " too fast");
            return;
        }
        Logger.a d17 = Logger.f235387a.d();
        JumpGuildParam jumpGuildParam7 = this.jumpGuildParam;
        if (jumpGuildParam7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jumpGuildParam");
        } else {
            jumpGuildParam2 = jumpGuildParam7;
        }
        d17.i("Guild.join.verfiy.JoinGuildVerifyViewModel", 1, "submit guildId:" + jumpGuildParam2.guildId + " " + e26.g());
        this.isSendingReq = true;
        ((IGPSService) ch.R0(IGPSService.class)).addGuildWithOption(e26.g(), new bv() { // from class: com.tencent.mobileqq.guild.channel.joinchannel.verifynew.i
            @Override // vh2.bv
            public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
                JoinGuildVerifyViewModel.f2(JoinGuildVerifyViewModel.this, iPerformanceReportTask, i3, str, iGProSecurityResult, iGProJoinGuildResult);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.channel.joinchannel.verifynew.a.b
    public void l0(@NotNull wf1.b question) {
        Intrinsics.checkNotNullParameter(question, "question");
        Logger.a d16 = Logger.f235387a.d();
        JumpGuildParam jumpGuildParam = this.jumpGuildParam;
        if (jumpGuildParam == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jumpGuildParam");
            jumpGuildParam = null;
        }
        d16.i("Guild.join.verfiy.JoinGuildVerifyViewModel", 1, "onAnswerChoosed guildId:" + jumpGuildParam.guildId + " question:" + question);
        boolean T1 = T1();
        if (!i2(T1)) {
            this.submitBtnEnableLiveData.setValue(Boolean.valueOf(T1));
        }
    }
}

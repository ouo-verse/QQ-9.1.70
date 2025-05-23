package com.tencent.robot.adelie.homepage.create.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qcoroutine.framework.impl.a;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.AiGenBotInfoOperationType;
import com.tencent.qqnt.kernel.nativeinterface.BotGender;
import com.tencent.qqnt.kernel.nativeinterface.ChangeMyBotOperationType;
import com.tencent.qqnt.kernel.nativeinterface.MyBotInfo;
import com.tencent.qqnt.kernel.nativeinterface.RobotActivityLabel;
import com.tencent.qqnt.kernel.nativeinterface.RobotPromptConversation;
import com.tencent.qqnt.kernel.nativeinterface.UgcSettingInfo;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.robot.adelie.homepage.AdelieUtils;
import com.tencent.robot.adelie.homepage.utils.d;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u0000 ]2\u00020\u0001:\u0001dB\u0007\u00a2\u0006\u0004\bb\u0010cJ(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\f\u0010\u000b\u001a\u00020\u0004*\u00020\u0007H\u0002J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0002Je\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\f2K\u0010\u0015\u001aG\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\t0\u0012H\u0002Ju\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042K\u0010\u0015\u001aG\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\t0\u0012H\u0002J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\fH\u0002J\u0006\u0010\u001d\u001a\u00020\u001cJ\u0006\u0010\u001e\u001a\u00020\u0002J\u000e\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u001fJ\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\f0\u001fJ\u000e\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0\u001fJ\u0006\u0010$\u001a\u00020\u001aJ\u0006\u0010%\u001a\u00020\tJ\u0006\u0010&\u001a\u00020\tJF\u0010(\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u000726\u0010\u0015\u001a2\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\t0'JV\u0010+\u001a\u00020\t2\u0006\u0010)\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u000426\u0010\u0015\u001a2\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\t0'J[\u0010,\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f2K\u0010\u0015\u001aG\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\t0\u0012J[\u0010.\u001a\u00020\t2\u0006\u0010-\u001a\u00020\u00042K\u0010\u0015\u001aG\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\t0\u0012J\u000e\u00100\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u0004J\u000e\u00102\u001a\u00020\t2\u0006\u00101\u001a\u00020\u0004J\u000e\u00104\u001a\u00020\t2\u0006\u00103\u001a\u00020\u0004J\u000e\u00105\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0004J\u001a\u00106\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004J\u001a\u00109\u001a\u00020\t2\b\u00107\u001a\u0004\u0018\u00010\u00042\b\u00108\u001a\u0004\u0018\u00010\u0004J\u000e\u0010<\u001a\u00020\t2\u0006\u0010;\u001a\u00020:J\u001e\u0010A\u001a\u00020\t2\u0016\u0010@\u001a\u0012\u0012\u0004\u0012\u00020>0=j\b\u0012\u0004\u0012\u00020>`?J2\u0010C\u001a\u00020\u001a*\u0012\u0012\u0004\u0012\u00020>0=j\b\u0012\u0004\u0012\u00020>`?2\u0016\u0010B\u001a\u0012\u0012\u0004\u0012\u00020>0=j\b\u0012\u0004\u0012\u00020>`?J\u0006\u0010D\u001a\u00020\u0004J\u0006\u0010E\u001a\u00020\u0004J\u001e\u0010I\u001a\u00020\t2\u0006\u0010F\u001a\u00020\u00042\u0006\u0010G\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\u001aJ\u0006\u0010J\u001a\u00020\tJ\b\u0010K\u001a\u00020\u0004H\u0016R\u001a\u0010O\u001a\b\u0012\u0004\u0012\u00020\f0L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010R\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010T\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010QR\u001c\u0010V\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010NR\u001c\u0010X\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bW\u0010NR\u0016\u0010[\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010^\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010a\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010`\u00a8\u0006e"}, d2 = {"Lcom/tencent/robot/adelie/homepage/create/viewmodel/AdelieCreateOrEditPageViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "errCode", "", "errMsg", QCircleWeakNetReporter.KEY_COST, "Lcom/tencent/qqnt/kernel/nativeinterface/AiGenBotInfoOperationType;", "genType", "", ICustomDataEditor.NUMBER_PARAM_2, "r2", "Lcom/tencent/qqnt/kernel/nativeinterface/MyBotInfo;", "botInfo", "t2", "Lcom/tencent/qqnt/kernel/nativeinterface/ChangeMyBotOperationType;", "type", "curBotInfo", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "cb", "b2", "avatarPath", "bgPath", "C2", "", ICustomDataEditor.STRING_ARRAY_PARAM_2, "", "j2", "k2", "Landroidx/lifecycle/LiveData;", "f2", SemanticAttributes.DbSystemValues.H2, "Lcom/tencent/qqnt/kernel/nativeinterface/UgcSettingInfo;", "i2", "g2", "Z1", "c2", "Lkotlin/Function2;", "o2", "robotName", "templateId", "p2", "X1", "botUid", "m2", "desc", "w2", "prompt", "z2", "msg", "B2", "u2", "y2", "ttsId", "ttsName", NowProxyConstants.AccountInfoKey.A2, "Lcom/tencent/qqnt/kernel/nativeinterface/BotGender;", "gender", "x2", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotPromptConversation;", "Lkotlin/collections/ArrayList;", "list", "v2", "otherList", "l2", "d2", "e2", "activityId", "activityName", BaseConstants.BROADCAST_USERSYNC_ENTER, ICustomDataEditor.STRING_PARAM_2, "q2", "getLogTag", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "_botInfo", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "_botAvatarPath", BdhLogUtil.LogTag.Tag_Conn, "_botBackgroundPath", "D", "_checkMyBot", "E", "_ugcSetting", UserInfo.SEX_FEMALE, "J", "uploadCostTime", "G", "I", "uploadErrorCode", "H", "Z", "hasChanged", "<init>", "()V", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieCreateOrEditPageViewModel extends BaseViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private String _botBackgroundPath;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<String> _checkMyBot;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<UgcSettingInfo> _ugcSetting;

    /* renamed from: F, reason: from kotlin metadata */
    private long uploadCostTime;

    /* renamed from: G, reason: from kotlin metadata */
    private int uploadErrorCode;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean hasChanged;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<MyBotInfo> _botInfo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String _botAvatarPath;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f366304a;

        static {
            int[] iArr = new int[AiGenBotInfoOperationType.values().length];
            try {
                iArr[AiGenBotInfoOperationType.KGENINFOBYBOTINFO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AiGenBotInfoOperationType.KPOLISHPROMPT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AiGenBotInfoOperationType.KPOLISHDESC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AiGenBotInfoOperationType.KPOLISHWELCOMEMSG.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AiGenBotInfoOperationType.KBYBOTNAME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AiGenBotInfoOperationType.KAVATARBYTEMPLATE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f366304a = iArr;
        }
    }

    public AdelieCreateOrEditPageViewModel() {
        MyBotInfo myBotInfo = new MyBotInfo();
        myBotInfo.ttsId = "none_voice";
        myBotInfo.ttsName = "\u65e0\u58f0\u97f3";
        myBotInfo.botGender = BotGender.KMALE;
        this._botInfo = new MutableLiveData<>(myBotInfo);
        this._botAvatarPath = "";
        this._botBackgroundPath = "";
        this._checkMyBot = new MutableLiveData<>(null);
        this._ugcSetting = new MutableLiveData<>(null);
    }

    private final void C2(ChangeMyBotOperationType type, MyBotInfo curBotInfo, String avatarPath, String bgPath, Function3<? super Integer, ? super String, ? super MyBotInfo, Unit> cb5) {
        long currentTimeMillis = System.currentTimeMillis();
        CoroutineScope f16 = a.f261834a.f(i.f.f261784e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "AdelieCreateOrEditPageViewModel_AdelieUtils_uploadAvatarAndGetUrl", null, null, null, new AdelieCreateOrEditPageViewModel$uploadPicAndCreate$1(avatarPath, curBotInfo, this, cb5, bgPath, currentTimeMillis, type, null), 14, null);
        }
    }

    private final boolean a2(MyBotInfo curBotInfo) {
        boolean z16;
        boolean z17;
        String str = curBotInfo.botAvatar;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            String str2 = curBotInfo.c2cDayBackground;
            if (str2 != null && str2.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b2(final ChangeMyBotOperationType type, MyBotInfo curBotInfo, final Function3<? super Integer, ? super String, ? super MyBotInfo, Unit> cb5) {
        QLog.i("AdelieCreateOrEditPageViewModel", 1, "changeMyBot type:" + type);
        AdelieUtils.f365929a.B(type, curBotInfo, new Function3<Integer, String, MyBotInfo, Unit>() { // from class: com.tencent.robot.adelie.homepage.create.viewmodel.AdelieCreateOrEditPageViewModel$doChangeMyBot$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, MyBotInfo myBotInfo) {
                invoke(num.intValue(), str, myBotInfo);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @NotNull String errMsg, @NotNull MyBotInfo botInfo) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                Intrinsics.checkNotNullParameter(botInfo, "botInfo");
                cb5.invoke(Integer.valueOf(i3), errMsg, botInfo);
                if (i3 != 0) {
                    QLog.e("AdelieCreateOrEditPageViewModel", 1, "changeMyBot type:" + type + " failed");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n2(int errCode, String errMsg, String cost, AiGenBotInfoOperationType genType) {
        Map mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("cost_time", cost), TuplesKt.to("error_code", String.valueOf(errCode)), TuplesKt.to("error_msg", errMsg), TuplesKt.to("scene", r2(genType)));
        d.c(null, "adelie_auto_fill_text", mapOf, 1, null);
    }

    private final String r2(AiGenBotInfoOperationType aiGenBotInfoOperationType) {
        int i3 = b.f366304a[aiGenBotInfoOperationType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        return "-1";
                    }
                    return "3";
                }
                return "2";
            }
            return "1";
        }
        return "0";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t2(AiGenBotInfoOperationType genType, MyBotInfo botInfo) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        MyBotInfo value = this._botInfo.getValue();
        if (value == null) {
            return;
        }
        boolean z28 = true;
        this.hasChanged = true;
        switch (b.f366304a[genType.ordinal()]) {
            case 1:
            case 5:
            case 6:
                String str = value.botPrompt;
                if (str != null && str.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    value.botPrompt = botInfo.botPrompt;
                }
                String str2 = value.botDesc;
                if (str2 != null && str2.length() != 0) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (z17) {
                    value.botDesc = botInfo.botDesc;
                }
                String str3 = value.botWelcomeMsg;
                if (str3 != null && str3.length() != 0) {
                    z18 = false;
                } else {
                    z18 = true;
                }
                if (z18) {
                    value.botWelcomeMsg = botInfo.botWelcomeMsg;
                }
                String str4 = botInfo.botAvatar;
                Intrinsics.checkNotNullExpressionValue(str4, "botInfo.botAvatar");
                if (str4.length() > 0) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                if (z19) {
                    String str5 = value.botAvatar;
                    if (str5 != null && str5.length() != 0) {
                        z26 = false;
                    } else {
                        z26 = true;
                    }
                    if (z26) {
                        String str6 = this._botAvatarPath;
                        if (str6 != null && str6.length() != 0) {
                            z27 = false;
                        } else {
                            z27 = true;
                        }
                        if (z27) {
                            String str7 = this._botBackgroundPath;
                            if (str7 != null && str7.length() != 0) {
                                z28 = false;
                            }
                            if (z28) {
                                value.botAvatar = botInfo.botAvatar;
                            }
                        }
                    }
                }
                value.botGender = botInfo.botGender;
                break;
            case 2:
                value.botPrompt = botInfo.botPrompt;
                break;
            case 3:
                value.botDesc = botInfo.botDesc;
                break;
            case 4:
                value.botWelcomeMsg = botInfo.botWelcomeMsg;
                break;
        }
        this._botInfo.postValue(value);
    }

    public final void A2(@Nullable String ttsId, @Nullable String ttsName) {
        MyBotInfo value = this._botInfo.getValue();
        if (value == null || ttsId == null || ttsName == null) {
            return;
        }
        value.ttsId = ttsId;
        value.ttsName = ttsName;
        this.hasChanged = true;
    }

    public final void B2(@NotNull String msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        MyBotInfo value = this._botInfo.getValue();
        if (value != null && !Intrinsics.areEqual(value.botWelcomeMsg, msg2)) {
            value.botWelcomeMsg = msg2;
            this.hasChanged = true;
        }
    }

    public final void X1(@NotNull ChangeMyBotOperationType type, @NotNull Function3<? super Integer, ? super String, ? super MyBotInfo, Unit> cb5) {
        boolean z16;
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        MyBotInfo value = this._botInfo.getValue();
        if (value == null) {
            cb5.invoke(-1, "", new MyBotInfo());
            return;
        }
        if (!AppNetConnInfo.isNetSupport()) {
            cb5.invoke(Integer.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_AIO_ADD), "\u7f51\u7edc\u8fde\u63a5\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5\u540e\u91cd\u8bd5", new MyBotInfo());
            return;
        }
        String str = this._botAvatarPath;
        String str2 = this._botBackgroundPath;
        boolean z17 = true;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            String str3 = value.botAvatar;
            if (str3 != null && str3.length() != 0) {
                z17 = false;
            }
            if (z17) {
                cb5.invoke(999997, "\u8bf7\u586b\u5199\u5b8c\u6574\u4fe1\u606f", new MyBotInfo());
                return;
            }
        }
        this.uploadCostTime = 0L;
        this.uploadErrorCode = 0;
        if (a2(value)) {
            C2(type, value, str, str2, cb5);
        } else {
            b2(type, value, cb5);
        }
    }

    public final void Z1() {
        AdelieUtils.f365929a.E(new Function2<Integer, String, Unit>() { // from class: com.tencent.robot.adelie.homepage.create.viewmodel.AdelieCreateOrEditPageViewModel$checkMyBotNum$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                invoke(num.intValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @NotNull String errMsg) {
                MutableLiveData mutableLiveData;
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                boolean z16 = false;
                if (30000 <= i3 && i3 < 30101) {
                    z16 = true;
                }
                if (z16) {
                    mutableLiveData = AdelieCreateOrEditPageViewModel.this._checkMyBot;
                    mutableLiveData.postValue(errMsg);
                }
            }
        });
    }

    public final void c2() {
        AdelieUtils.f365929a.K(new Function3<Integer, String, UgcSettingInfo, Unit>() { // from class: com.tencent.robot.adelie.homepage.create.viewmodel.AdelieCreateOrEditPageViewModel$fetchUgcSetting$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, UgcSettingInfo ugcSettingInfo) {
                invoke(num.intValue(), str, ugcSettingInfo);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @NotNull String errMsg, @NotNull UgcSettingInfo ugcSetting) {
                MutableLiveData mutableLiveData;
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                Intrinsics.checkNotNullParameter(ugcSetting, "ugcSetting");
                if (i3 == 0) {
                    mutableLiveData = AdelieCreateOrEditPageViewModel.this._ugcSetting;
                    mutableLiveData.postValue(ugcSetting);
                }
            }
        });
    }

    @NotNull
    public final String d2() {
        boolean z16;
        String str;
        String str2 = this._botAvatarPath;
        if (str2.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            MyBotInfo value = this._botInfo.getValue();
            if (value != null) {
                str = value.botAvatar;
            } else {
                str = null;
            }
            if (str == null) {
                return "";
            }
            Intrinsics.checkNotNullExpressionValue(str, "_botInfo.value?.botAvatar ?: \"\"");
            return str;
        }
        return str2;
    }

    @NotNull
    public final String e2() {
        boolean z16;
        String str;
        String str2 = this._botBackgroundPath;
        if (str2.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            MyBotInfo value = this._botInfo.getValue();
            if (value != null) {
                str = value.c2cDayBackground;
            } else {
                str = null;
            }
            if (str == null) {
                return "";
            }
            Intrinsics.checkNotNullExpressionValue(str, "_botInfo.value?.c2cDayBackground ?: \"\"");
            return str;
        }
        return str2;
    }

    @NotNull
    public final LiveData<String> f2() {
        return this._checkMyBot;
    }

    /* renamed from: g2, reason: from getter */
    public final boolean getHasChanged() {
        return this.hasChanged;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "AdelieCreateOrEditPageViewModel";
    }

    @NotNull
    public final LiveData<MyBotInfo> h2() {
        return this._botInfo;
    }

    @NotNull
    public final LiveData<UgcSettingInfo> i2() {
        return this._ugcSetting;
    }

    /* renamed from: j2, reason: from getter */
    public final long getUploadCostTime() {
        return this.uploadCostTime;
    }

    /* renamed from: k2, reason: from getter */
    public final int getUploadErrorCode() {
        return this.uploadErrorCode;
    }

    public final boolean l2(@NotNull ArrayList<RobotPromptConversation> arrayList, @NotNull ArrayList<RobotPromptConversation> otherList) {
        Object orNull;
        String str;
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        Intrinsics.checkNotNullParameter(otherList, "otherList");
        if (otherList.size() != arrayList.size()) {
            return false;
        }
        int i3 = 0;
        for (Object obj : arrayList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            RobotPromptConversation robotPromptConversation = (RobotPromptConversation) obj;
            orNull = CollectionsKt___CollectionsKt.getOrNull(otherList, i3);
            RobotPromptConversation robotPromptConversation2 = (RobotPromptConversation) orNull;
            String str2 = null;
            if (robotPromptConversation2 != null) {
                str = robotPromptConversation2.question;
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(str, robotPromptConversation.question)) {
                if (robotPromptConversation2 != null) {
                    str2 = robotPromptConversation2.answer;
                }
                if (Intrinsics.areEqual(str2, robotPromptConversation.answer)) {
                    i3 = i16;
                }
            }
            return false;
        }
        return true;
    }

    public final void m2(@NotNull String botUid, @NotNull final Function3<? super Integer, ? super String, ? super MyBotInfo, Unit> cb5) {
        Intrinsics.checkNotNullParameter(botUid, "botUid");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        MyBotInfo myBotInfo = new MyBotInfo();
        myBotInfo.uid = botUid;
        QLog.i("AdelieCreateOrEditPageViewModel", 1, "queryMyBot");
        AdelieUtils.f365929a.B(ChangeMyBotOperationType.KQUERY, myBotInfo, new Function3<Integer, String, MyBotInfo, Unit>() { // from class: com.tencent.robot.adelie.homepage.create.viewmodel.AdelieCreateOrEditPageViewModel$queryMyBot$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, MyBotInfo myBotInfo2) {
                invoke(num.intValue(), str, myBotInfo2);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @NotNull String errMsg, @NotNull MyBotInfo botInfo) {
                MutableLiveData mutableLiveData;
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                Intrinsics.checkNotNullParameter(botInfo, "botInfo");
                cb5.invoke(Integer.valueOf(i3), errMsg, botInfo);
                if (i3 == 0) {
                    mutableLiveData = this._botInfo;
                    mutableLiveData.postValue(botInfo);
                } else {
                    QLog.e("AdelieCreateOrEditPageViewModel", 1, "queryMyBot failed");
                }
            }
        });
    }

    public final void o2(@NotNull final AiGenBotInfoOperationType genType, @NotNull final Function2<? super Integer, ? super String, Unit> cb5) {
        Intrinsics.checkNotNullParameter(genType, "genType");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        QLog.i("AdelieCreateOrEditPageViewModel", 1, "requestAIGenerateBotInfo genType:" + genType);
        if (!AppNetConnInfo.isNetSupport()) {
            cb5.invoke(Integer.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_AIO_ADD), "\u7f51\u7edc\u8fde\u63a5\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5\u540e\u91cd\u8bd5");
            return;
        }
        MyBotInfo value = this._botInfo.getValue();
        if (value == null) {
            cb5.invoke(999998, "\u5f53\u524d\u7f51\u7edc\u7e41\u5fd9\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
        } else {
            final long currentTimeMillis = System.currentTimeMillis();
            AdelieUtils.f365929a.b0(value, genType, new Function3<Integer, String, MyBotInfo, Unit>() { // from class: com.tencent.robot.adelie.homepage.create.viewmodel.AdelieCreateOrEditPageViewModel$requestAIGenerateBotInfo$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, MyBotInfo myBotInfo) {
                    invoke(num.intValue(), str, myBotInfo);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3, @NotNull String errMsg, @NotNull MyBotInfo botInfo) {
                    Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                    Intrinsics.checkNotNullParameter(botInfo, "botInfo");
                    long currentTimeMillis2 = System.currentTimeMillis();
                    cb5.invoke(Integer.valueOf(i3), errMsg);
                    this.n2(i3, errMsg, String.valueOf(currentTimeMillis2 - currentTimeMillis), genType);
                    if (i3 == 0) {
                        this.t2(genType, botInfo);
                    } else {
                        QLog.e("AdelieCreateOrEditPageViewModel", 1, "requestAIGenerateBotInfo failed");
                    }
                }
            });
        }
    }

    public final void p2(@NotNull final String robotName, @NotNull AiGenBotInfoOperationType genType, @NotNull String templateId, @NotNull final Function2<? super Integer, ? super String, Unit> cb5) {
        Intrinsics.checkNotNullParameter(robotName, "robotName");
        Intrinsics.checkNotNullParameter(genType, "genType");
        Intrinsics.checkNotNullParameter(templateId, "templateId");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        QLog.i("AdelieCreateOrEditPageViewModel", 1, "requestAIGenerateBotInfo");
        if (!AppNetConnInfo.isNetSupport()) {
            cb5.invoke(Integer.valueOf(BusinessInfoCheckUpdateItem.UIAPPID_AIO_ADD), "\u7f51\u7edc\u8fde\u63a5\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5\u540e\u91cd\u8bd5");
        } else {
            AdelieUtils.f365929a.c0(robotName, genType, templateId, new Function3<Integer, String, MyBotInfo, Unit>() { // from class: com.tencent.robot.adelie.homepage.create.viewmodel.AdelieCreateOrEditPageViewModel$requestAIGenerateBotInfo$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, MyBotInfo myBotInfo) {
                    invoke(num.intValue(), str, myBotInfo);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Multi-variable type inference failed */
                public final void invoke(int i3, @NotNull String errMsg, @NotNull MyBotInfo botInfo) {
                    MutableLiveData mutableLiveData;
                    MutableLiveData mutableLiveData2;
                    MutableLiveData mutableLiveData3;
                    Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                    Intrinsics.checkNotNullParameter(botInfo, "botInfo");
                    cb5.invoke(Integer.valueOf(i3), errMsg);
                    if (i3 == 0) {
                        mutableLiveData = this._botInfo;
                        MyBotInfo myBotInfo = (MyBotInfo) mutableLiveData.getValue();
                        if (myBotInfo == null) {
                            myBotInfo = new MyBotInfo();
                        }
                        myBotInfo.botPrompt = botInfo.botPrompt;
                        myBotInfo.botWelcomeMsg = botInfo.botWelcomeMsg;
                        String str = botInfo.botAvatar;
                        Intrinsics.checkNotNullExpressionValue(str, "botInfo.botAvatar");
                        if (str.length() > 0) {
                            myBotInfo.botAvatar = botInfo.botAvatar;
                        }
                        myBotInfo.botDesc = botInfo.botDesc;
                        myBotInfo.botName = botInfo.botName;
                        mutableLiveData2 = this._botInfo;
                        mutableLiveData2.postValue(myBotInfo);
                        return;
                    }
                    QLog.e("AdelieCreateOrEditPageViewModel", 1, "requestAIGenerateBotInfo failed");
                    MyBotInfo myBotInfo2 = new MyBotInfo();
                    myBotInfo2.botName = robotName;
                    mutableLiveData3 = this._botInfo;
                    mutableLiveData3.postValue(myBotInfo2);
                }
            });
        }
    }

    public final void q2() {
        this.hasChanged = true;
    }

    public final void s2(@NotNull String activityId, @NotNull String activityName, boolean enter) {
        Intrinsics.checkNotNullParameter(activityId, "activityId");
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        MyBotInfo value = this._botInfo.getValue();
        if (value == null) {
            return;
        }
        ArrayList<RobotActivityLabel> arrayList = value.robotActivityLabelList;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        if (arrayList.size() > 0) {
            RobotActivityLabel robotActivityLabel = arrayList.get(0);
            if (robotActivityLabel == null) {
                robotActivityLabel = new RobotActivityLabel();
            }
            robotActivityLabel.f359208id = activityId;
            robotActivityLabel.name = activityName;
            robotActivityLabel.join = enter;
            arrayList.set(0, robotActivityLabel);
            return;
        }
        RobotActivityLabel robotActivityLabel2 = new RobotActivityLabel();
        robotActivityLabel2.f359208id = activityId;
        robotActivityLabel2.name = activityName;
        robotActivityLabel2.join = enter;
        arrayList.add(robotActivityLabel2);
    }

    public final void u2(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        MyBotInfo value = this._botInfo.getValue();
        if (value != null && !Intrinsics.areEqual(value.botName, name)) {
            value.botName = name;
            this.hasChanged = true;
        }
    }

    public final void v2(@NotNull ArrayList<RobotPromptConversation> list) {
        ArrayList<RobotPromptConversation> arrayList;
        Intrinsics.checkNotNullParameter(list, "list");
        MyBotInfo value = h2().getValue();
        if (value != null) {
            arrayList = value.robotPromptConversationList;
        } else {
            arrayList = null;
        }
        if (arrayList != null && !l2(arrayList, list)) {
            arrayList.clear();
            arrayList.addAll(list);
            this.hasChanged = true;
        }
    }

    public final void w2(@NotNull String desc) {
        Intrinsics.checkNotNullParameter(desc, "desc");
        MyBotInfo value = this._botInfo.getValue();
        if (value != null && !Intrinsics.areEqual(value.botDesc, desc)) {
            value.botDesc = desc;
            this.hasChanged = true;
        }
    }

    public final void x2(@NotNull BotGender gender) {
        Intrinsics.checkNotNullParameter(gender, "gender");
        MyBotInfo value = this._botInfo.getValue();
        if (value == null) {
            return;
        }
        value.botGender = gender;
        this.hasChanged = true;
    }

    public final void y2(@Nullable String avatarPath, @Nullable String bgPath) {
        MyBotInfo value = this._botInfo.getValue();
        if (value == null) {
            return;
        }
        if (avatarPath != null) {
            this._botAvatarPath = avatarPath;
            value.botAvatar = "";
        }
        if (bgPath != null) {
            this._botBackgroundPath = bgPath;
            value.c2cDayBackground = "";
        }
        this.hasChanged = true;
    }

    public final void z2(@NotNull String prompt) {
        Intrinsics.checkNotNullParameter(prompt, "prompt");
        MyBotInfo value = this._botInfo.getValue();
        if (value != null && !Intrinsics.areEqual(value.botPrompt, prompt)) {
            value.botPrompt = prompt;
            this.hasChanged = true;
        }
    }
}
